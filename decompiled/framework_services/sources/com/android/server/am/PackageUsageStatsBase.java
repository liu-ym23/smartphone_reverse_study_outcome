package com.android.server.am;

import android.os.Handler;
import android.util.Log;
import android.util.Slog;
import bytedanceos.util.SmtRingBuffer;
import com.android.server.job.controllers.JobStatus;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class PackageUsageStatsBase {
    static final boolean DEBUG = false;
    static final int HistoryCount = 10;
    static final String TAG = "PackUsage";
    protected static final int UPDATE_PACKAGE_STATS_DURATION = 5000;
    static long totalActive = 0;
    static int totalCount = 0;
    static final int unit10m = 600000;
    static final int unit1h = 3600000;
    static final int unit1m = 60000;
    static final int unit24h = 86400000;
    static final int unit2h = 7200000;
    static final int unit30m = 1800000;
    static final int unit5m = 300000;
    Handler mHandler;
    ArrayList<PackageUsageInfo> mLruStats;
    SmtUidDictionaryExt<PackageUsageInfo> sud;

    static class PackageUsageInfo {
        History current;
        SmtRingBuffer<History> history;
        History oldHistories;
        int order;
        String packageName;
        History pendinghis;
        long resumeStart;
        int uid;
        int weight;

        static class History {
            long active;
            int count;
            long resumeEnd;

            History() {
            }

            History(int c, long a, long r) {
                this.count = c;
                this.active = a;
                this.resumeEnd = r;
            }

            History(History o) {
                this.count = o.count;
                this.active = o.active;
                this.resumeEnd = o.resumeEnd;
            }

            void reset(int c, long a, long r) {
                this.count = c;
                this.active = a;
                this.resumeEnd = r;
            }

            void add(History o, int countLimit) {
                this.active += o.active;
                this.resumeEnd = o.resumeEnd;
                if (this.count >= countLimit) goto L5;
                this.count += o.count;
                return;
            L5:
                this.active = (this.active * ((long) countLimit)) / ((long) (countLimit + 1));
            }

            public String toString() {
                return "PUI.History{ count=" + this.count + ", active=" + this.active + ", resumeEnd=" + this.resumeEnd + " }";
            }
        }

        public void updatePackageActive(long when, boolean resumed) {
            boolean hisFull = this.history.isFull();
            if (resumed == false) goto L21;
            if (hisFull == false) goto L19;
            SmtRingBuffer<History> r2 = this.history;
            monitor-enter(r2);
            History item = (History) this.history.get(0);     // Catch: Throwable -> L16
            monitor-exit(r2);     // Catch: Throwable -> L16
            if (this.oldHistories != null) goto L14;
            this.oldHistories = new History(item);
            if (PackageUsageStatsBase.DEBUG == false) goto L15;
            Slog.d(PackageUsageStatsBase.TAG, "updatePackageActive new history item for" + this.packageName);
        L15:
            PackageUsageStatsBase.totalCount -= item.count;
            PackageUsageStatsBase.totalActive -= item.active;
        L20:
            this.current = item;
            this.resumeStart = when;
            return;
        L14:
            this.oldHistories.add(item, 10);
        L16:
            th = move-exception;
            throw th;
        L19:
            item = new History();
            goto L20
        L21:
            long delta = when - this.resumeStart;
            if (delta >= 0) goto L24;
        L30:
            Slog.w(PackageUsageStatsBase.TAG, "error in updatePackageActive, when=" + when + ", resumed=" + resumed + ", resumeStart=" + this.resumeStart);
        L31:
            this.current = null;
            this.resumeStart = -1;
            return;
        L24:
            if (this.current == null) goto L30;
            this.current.reset(1, delta, when);
            History tmp = this.pendinghis;
            if (tmp != null) goto L28;
            this.pendinghis = this.current;
        L29:
            PackageUsageStatsBase.totalActive += delta;
            PackageUsageStatsBase.totalCount++;
            goto L31
        L28:
            tmp.add(this.current, 10);
            goto L29
        }

        PackageUsageInfo(long start, String name, int userId) {
            this.order = 1;
            this.resumeStart = -1;
            this.weight = -1000;
            this.history = new SmtRingBuffer(10);
            this.uid = userId;
            this.packageName = name;
            this.resumeStart = start;
        }

        private int computeFactor(long resumeDelta, long span) {
            if (span > 3600000) goto L5;
            return 291;
        L5:
            if (resumeDelta != 0) goto L9;
            return (int) ((30000 * span) / 86400000);
        L9:
            if (resumeDelta >= 60000) goto L13;
            return (int) ((16000 * span) / 86400000);
        L13:
            if (resumeDelta >= 300000) goto L17;
            return (int) ((13000 * span) / 86400000);
        L17:
            if (resumeDelta >= 600000) goto L21;
            return (int) ((12000 * span) / 86400000);
        L21:
            if (resumeDelta >= 1800000) goto L25;
            return (int) ((11000 * span) / 86400000);
        L25:
            if (resumeDelta <= 7200000) goto L29;
            return (int) ((8000 * span) / 86400000);
        L29:
            return (int) ((JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY * span) / 86400000);
        }

        int computeWeight(long when, History item) {
            long resumeDelta = when - item.resumeEnd;
            long span = 86400000 - resumeDelta;
            int count = item.count;
            if (count <= 1) goto L10;
            int fact = ((10 - count) * 10) / 10;
            if (fact >= 2) goto L7;
            fact = 2;
        L7:
            span = (((long) fact) * span) / 10;
            if (PackageUsageStatsBase.DEBUG == false) goto L10;
            Slog.d(PackageUsageStatsBase.TAG, "reduce span of oldHistories fact=" + fact);
        L10:
            int factor = computeFactor(resumeDelta, span);
            int wcount = 0;
            if (PackageUsageStatsBase.totalCount == 0) goto L13;
            wcount = (factor * count) / PackageUsageStatsBase.totalCount;
        L13:
            int wactive = 0;
            if (PackageUsageStatsBase.totalActive == 0) goto L16;
            wactive = (int) ((((long) factor) * item.active) / PackageUsageStatsBase.totalActive);
        L16:
            int res = wcount + wactive;
            if (PackageUsageStatsBase.DEBUG == false) goto L19;
            Slog.d(PackageUsageStatsBase.TAG, "compute history weight of: " + this.packageName + ", factor=" + factor + ", span=" + span + ", one weight=" + res + "(+" + wcount + ", +" + wactive + "), item=" + item + ", uid=" + this.uid);
        L19:
            return res;
        }

        void updateWeight(long when) {
            int r1 = PackageUsageStatsBase.totalCount;
            long r2 = PackageUsageStatsBase.totalActive;
            if (this.pendinghis == null) goto L12;
            SmtRingBuffer<History> r4 = this.history;
            monitor-enter(r4);
            this.history.add(this.pendinghis);     // Catch: Throwable -> L9
            monitor-exit(r4);     // Catch: Throwable -> L9
            this.pendinghis = null;
        L9:
            th = move-exception;
            throw th;
        L12:
            int N = this.history.size();
            this.weight = 0;
            int i = 0;
        L13:
            if (i >= N) goto L15;
            History item = (History) this.history.get(i);
            this.weight += computeWeight(when, item);
            i = i + 1;
            goto L13
        L15:
            History tmp = this.current;
            if (tmp != null) goto L18;
        L20:
            long when2 = when;
        L22:
            if (this.oldHistories == null) goto L25;
            this.weight += computeWeight(when2, this.oldHistories);
        L25:
            if (PackageUsageStatsBase.DEBUG == false) goto L31;
            Slog.d(PackageUsageStatsBase.TAG, "updateWeight weight=" + this.weight);
            return;
        L31:
            return;
        L18:
            if (this.resumeStart <= 0) goto L20;
            when2 = when;
            tmp.reset(1, when - this.resumeStart, when2);
            this.weight += computeWeight(when2, tmp);
            goto L22
        }

        boolean isRecent(long when, long delta) {
            if (this.current == null) goto L6;
            return true;
        L6:
            if (this.pendinghis != null) goto L8;
            History item = (History) this.history.getLast();
        L9:
            if (item != null) goto L11;
        L18:
            return true;
        L11:
            if (0 == item.resumeEnd) goto L18;
            if (delta > (when - item.resumeEnd)) goto L19;
            return false;
        L19:
            return true;
        L8:
            item = this.pendinghis;
            goto L9
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("PUI{ uid=");
            r0.append(this.uid);
            r0.append(", order=");
            r0.append(this.order);
            r0.append(", packageName=");
            r0.append(this.packageName);
            r0.append(", weight=");
            r0.append(this.weight);
            r0.append(", current=");
            r0.append(this.current);
            r0.append(", resumeEnd=");
            if (this.pendinghis == null) goto L5;
            History r1 = this.pendinghis;
        L7:
            Object r2 = Long.valueOf(r1.resumeEnd);
        L10:
            r0.append(r2);
            r0.append(" }");
            return r0.toString();
        L5:
            if (this.history.getLast() == null) goto L8;
            r1 = (History) this.history.getLast();
            goto L7
        L8:
            r2 = "null";
            goto L10
        }
    }

    protected class SmtUidDictionaryExt<T> extends SmtUidDictionary<T> {
        private Map<String, T> sharedUidMap;

        protected SmtUidDictionaryExt(PackageUsageStatsBase this$0) {
            this.sharedUidMap = new HashMap(10);
        }

        public void setSharedUidMap(String pkgName, T t) {
            this.sharedUidMap.put(pkgName, t);
        }

        public Map<String, T> getSharedUidMap() {
            return this.sharedUidMap;
        }

        public T getValue(ProcessRecord app) {
            if (app.uid != 1000) goto L7;
            return getSharedUidMap().get(app.processName);
        L7:
            return getValueByUid(app.uid, false);
        }

        @Override // com.android.server.am.SmtUidDictionary
        public int getSize() {
            return (this.uidSets.size() + this.sharedUidMap.size()) - 1;
        }
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
    }

    PackageUsageStatsBase(Handler h) {
        this.mLruStats = new ArrayList(50);
        this.mHandler = h;
        this.sud = new SmtUidDictionaryExt(this);
    }

    public ArrayList<ProcessRecord> sortByPackageUsage(ArrayList<ProcessRecord> records) {
        SmtUidDictionaryExt<PackageUsageInfo> r0 = this.sud;
        monitor-enter(r0);
        Collections.sort(records, new AnonymousClass1(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return records;
    L7:
        th = move-exception;
        throw th;
    }

    int getOrder(int uid, int max) {
        PackageUsageInfo info = this.sud.getValueByUid(uid, false);
        if (info == null) goto L5;
        int ret = info.order;
    L6:
        if (ret <= max) goto L8;
        return max;
    L8:
        return ret;
    L5:
        ret = this.sud.getSize();
        goto L6
    }

    boolean isRecent(long when, long delta, int uid) {
        PackageUsageInfo info = this.sud.getValueByUid(uid, false);
        if (info != null) goto L5;
        return false;
    L5:
        return info.isRecent(when, delta);
    }

    String dumpInfo(int uid) {
        PackageUsageInfo info = this.sud.getValueByUid(uid, false);
        if (info != null) goto L7;
        return "null";
    L7:
        return info.toString();
    }

    public ArrayList<Integer> sortNoSystemAppByPackageUsage(ArrayList<Integer> uids) {
        SmtUidDictionaryExt<PackageUsageInfo> r0 = this.sud;
        monitor-enter(r0);
        Collections.sort(uids, new AnonymousClass2(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return uids;
    L7:
        th = move-exception;
        throw th;
    }

    public ArrayList<ProcessRecord> sortByAdjAndPackageUsage(ArrayList<ProcessRecord> records) {
        SmtUidDictionaryExt<PackageUsageInfo> r0 = this.sud;
        monitor-enter(r0);
        Collections.sort(records, new AnonymousClass3(this));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return records;
    L7:
        th = move-exception;
        throw th;
    }
}
