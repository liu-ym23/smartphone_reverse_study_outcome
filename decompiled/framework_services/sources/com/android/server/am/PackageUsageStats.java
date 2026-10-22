package com.android.server.am;

import android.os.Handler;
import android.util.Slog;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class PackageUsageStats extends PackageUsageStatsBase {
    static int shrinkCount;
    boolean mInfoStatsScheduled;
    long mInfoStatsUpdateTime;
    Comparator<PackageUsageStatsBase.PackageUsageInfo> mPackUsageComparator;
    Comparator<Object> mUidStatsComparator;

    PackageUsageStats(Handler h) {
        super(h);
        this.mPackUsageComparator = new AnonymousClass1(this);
        this.mUidStatsComparator = new AnonymousClass2(this);
    }

    int[] getLruUidArray(int nums) {
        PackageUsageStatsBase.SmtUidDictionaryExt<PackageUsageStatsBase.PackageUsageInfo> r0 = this.sud;
        monitor-enter(r0);
        int[] lruArray = new int[nums];     // Catch: Throwable -> L12
        int index = 0;
        int N = this.mLruStats.size();     // Catch: Throwable -> L12
        int i = 0;
    L5:
        if (i >= N) goto L15;
        int currentUid = this.mLruStats.get(i).uid;     // Catch: Throwable -> L12
        if (currentUid <= 10000) goto L14;
        int index2 = index + 1;     // Catch: Throwable -> L12
        lruArray[index] = currentUid;     // Catch: Throwable -> L12
        if (index2 == nums) goto L15;
        index = index2;
    L14:
        i = i + 1;     // Catch: Throwable -> L12
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return lruArray;
    L12:
        th = move-exception;
        throw th;
    }

    void updatePackageUsage(long when, String name, int uid, boolean resume, boolean create) {
        PackageUsageStatsBase.SmtUidDictionaryExt<PackageUsageStatsBase.PackageUsageInfo> r0 = this.sud;
        monitor-enter(r0);
        PackageUsageStatsBase.PackageUsageInfo pack = this.sud.getValueByUid(uid, false);     // Catch: Throwable -> L10
        if (pack != null) goto L12;
        if (create == false) goto L12;
        pack = new PackageUsageStatsBase.PackageUsageInfo(when, name, uid);     // Catch: Throwable -> L10
        pack.weight = 1000;     // Catch: Throwable -> L10
        pack.order = 1;     // Catch: Throwable -> L10
        this.sud.setValueByUid(uid, pack, false);     // Catch: Throwable -> L10
        if (uid == 1000) goto L12;
        this.mLruStats.add(0, pack);     // Catch: Throwable -> L10
    L12:
        if (uid != 1000) goto L17;
        pack = this.sud.getSharedUidMap().get(name);     // Catch: Throwable -> L10
        if (pack != null) goto L17;
        if (create == false) goto L17;
        pack = new PackageUsageStatsBase.PackageUsageInfo(when, name, uid);     // Catch: Throwable -> L10
        pack.weight = 1000;     // Catch: Throwable -> L10
        pack.order = 1;     // Catch: Throwable -> L10
        this.sud.setSharedUidMap(name, pack);     // Catch: Throwable -> L10
        this.mLruStats.add(0, pack);     // Catch: Throwable -> L10
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L10
        if (pack == null) goto L25;
        pack.updatePackageActive(when, resume);
        return;
    L25:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    void updatePackageUsageStats(long when) {
        long tcount = PackageUsageStatsBase.totalCount;
        long tactive = PackageUsageStatsBase.totalActive;
        if (PackageUsageStatsBase.DEBUG == false) goto L6;
        Slog.d("PackUsage", "updatePackageUsageStats tcount=" + tcount + ", tactive=" + tactive + ", when=" + when);
    L6:
        if (tcount > 0) goto L8;
        return;
    L8:
        if (tactive <= 0) goto L57;
        int tryCount = 0;
    L11:
        if (tryCount >= 2) goto L30;
        Iterator<Integer> r8 = this.sud.getAllUidSet().iterator();     // Catch: ConcurrentModificationException -> L18
    L14:
        if (r8.hasNext() == false) goto L21;
        Integer uid = r8.next();     // Catch: ConcurrentModificationException -> L18
        PackageUsageStatsBase.PackageUsageInfo info = this.sud.getValueByUid(uid.intValue(), false);     // Catch: ConcurrentModificationException -> L18
        if (info == null) goto L14;
        info.updateWeight(when);     // Catch: ConcurrentModificationException -> L18
        goto L14
    L21:
        Map<String, PackageUsageStatsBase.PackageUsageInfo> sharedUidMap = this.sud.getSharedUidMap();     // Catch: ConcurrentModificationException -> L18
        Iterator<String> r9 = sharedUidMap.keySet().iterator();     // Catch: ConcurrentModificationException -> L18
    L22:
        if (r9.hasNext() == false) goto L30;
        String pkg = r9.next();     // Catch: ConcurrentModificationException -> L18
        PackageUsageStatsBase.PackageUsageInfo info2 = sharedUidMap.get(pkg);     // Catch: ConcurrentModificationException -> L18
        if (info2 == null) goto L22;
        info2.updateWeight(when);     // Catch: ConcurrentModificationException -> L18
    L18:
        e = move-exception;
        tryCount = tryCount + 1;
        Slog.w("PackUsage", "mInfoStats modified!", e);
    L30:
        PackageUsageStatsBase.SmtUidDictionaryExt<PackageUsageStatsBase.PackageUsageInfo> r7 = this.sud;
        monitor-enter(r7);
        Collections.sort(this.mLruStats, this.mPackUsageComparator);     // Catch: Throwable -> L35
        int N = this.mLruStats.size();     // Catch: Throwable -> L35
        int i = 0;
    L33:
        if (i >= N) goto L38;
        PackageUsageStatsBase.PackageUsageInfo stats = this.mLruStats.get(i);     // Catch: Throwable -> L35
        stats.order = i;     // Catch: Throwable -> L35
        i = i + 1;     // Catch: Throwable -> L35
        goto L33
    L38:
        monitor-exit(r7);     // Catch: Throwable -> L35
        return;
    L35:
        th = move-exception;
        throw th;
    }
}
