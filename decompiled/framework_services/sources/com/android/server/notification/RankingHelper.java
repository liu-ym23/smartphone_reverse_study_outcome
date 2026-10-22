package com.android.server.notification;

import android.content.Context;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Slog;
import android.util.proto.ProtoOutputStream;
import com.android.internal.compat.IPlatformCompat;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public class RankingHelper {
    private static final String TAG = "RankingHelper";
    private final Context mContext;
    private final GlobalSortKeyComparator mFinalComparator;
    private final Comparator mPreliminaryComparator;
    private final ArrayMap<String, NotificationRecord> mProxyByGroupTmp;
    private final RankingHandler mRankingHandler;
    private final NotificationSignalExtractor[] mSignalExtractors;

    public RankingHelper(Context context, RankingHandler rankingHandler, RankingConfig config, ZenModeHelper zenHelper, NotificationUsageStats usageStats, String[] extractorNames, IPlatformCompat platformCompat, GroupHelper groupHelper) {
        this.mFinalComparator = new GlobalSortKeyComparator();
        this.mProxyByGroupTmp = new ArrayMap();
        this.mContext = context;
        this.mRankingHandler = rankingHandler;
        this.mPreliminaryComparator = new NotificationTimeComparator();
        int N = extractorNames.length;
        this.mSignalExtractors = new NotificationSignalExtractor[N];
        int i = 0;
    L3:
        if (i >= N) goto L17;
        Class<?> extractorClass = this.mContext.getClassLoader().loadClass(extractorNames[i]);     // Catch: IllegalAccessException -> L6 InstantiationException -> L8 ClassNotFoundException -> L10
        NotificationSignalExtractor extractor = (NotificationSignalExtractor) extractorClass.newInstance();     // Catch: IllegalAccessException -> L6 InstantiationException -> L8 ClassNotFoundException -> L10
        extractor.initialize(this.mContext, usageStats);     // Catch: IllegalAccessException -> L6 InstantiationException -> L8 ClassNotFoundException -> L10
        extractor.setConfig(config);     // Catch: IllegalAccessException -> L6 InstantiationException -> L8 ClassNotFoundException -> L10
        extractor.setZenHelper(zenHelper);     // Catch: IllegalAccessException -> L6 InstantiationException -> L8 ClassNotFoundException -> L10
        extractor.setGroupHelper(groupHelper);     // Catch: IllegalAccessException -> L6 InstantiationException -> L8 ClassNotFoundException -> L10
        extractor.setCompatChangeLogger(platformCompat);     // Catch: IllegalAccessException -> L6 InstantiationException -> L8 ClassNotFoundException -> L10
        this.mSignalExtractors[i] = extractor;     // Catch: IllegalAccessException -> L6 InstantiationException -> L8 ClassNotFoundException -> L10
    L15:
        i = i + 1;
    L10:
        e = move-exception;
        Slog.w(TAG, "Couldn't find extractor " + extractorNames[i] + ".", e);
    L6:
        e = move-exception;
        Slog.w(TAG, "Problem accessing extractor " + extractorNames[i] + ".", e);
    L8:
        e = move-exception;
        Slog.w(TAG, "Couldn't instantiate extractor " + extractorNames[i] + ".", e);
        goto L15
    }

    public <T extends NotificationSignalExtractor> T findExtractor(Class<T> r5) {
        int r0 = this.mSignalExtractors.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        T r2 = (T) this.mSignalExtractors[r1];
        if (r5.equals(r2.getClass()) == true) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r2;
    L8:
        return null;
    }

    public void extractSignals(NotificationRecord r) {
        int N = this.mSignalExtractors.length;
        int i = 0;
    L3:
        if (i >= N) goto L15;
        NotificationSignalExtractor extractor = this.mSignalExtractors[i];
        RankingReconsideration recon = extractor.process(r);     // Catch: Throwable -> L9
        if (recon == null) goto L13;
        this.mRankingHandler.requestReconsideration(recon);     // Catch: Throwable -> L9
    L13:
        i = i + 1;
    L9:
        t = move-exception;
        Slog.w(TAG, "NotificationSignalExtractor failed.", t);
        goto L13
    }

    public void sort(ArrayList<NotificationRecord> notificationList) {
        int N = notificationList.size();
        int i = N - 1;
    L3:
        if (i < 0) goto L5;
        notificationList.get(i).setGlobalSortKey(null);
        i = i - 1;
        goto L3
    L5:
        notificationList.sort(this.mPreliminaryComparator);
        ArrayMap<String, NotificationRecord> r4 = this.mProxyByGroupTmp;
        monitor-enter(r4);
        int i2 = 0;
    L8:
        if (i2 >= N) goto L18;
        NotificationRecord record = notificationList.get(i2);     // Catch: Throwable -> L14
        record.setAuthoritativeRank(i2);     // Catch: Throwable -> L14
        String groupKey = record.getGroupKey();     // Catch: Throwable -> L14
        NotificationRecord existingProxy = this.mProxyByGroupTmp.get(groupKey);     // Catch: Throwable -> L14
        if (existingProxy == null) goto L16;
        if (existingProxy.getNotification().isGroupSummary() == true) goto L16;
    L17:
        i2 = i2 + 1;     // Catch: Throwable -> L14
    L16:
        this.mProxyByGroupTmp.put(groupKey, record);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    L18:
        int i3 = 0;
    L19:
        if (i3 >= N) goto L32;
        NotificationRecord record2 = notificationList.get(i3);     // Catch: Throwable -> L14
        NotificationRecord groupProxy = this.mProxyByGroupTmp.get(record2.getGroupKey());     // Catch: Throwable -> L14
        String groupSortKey = record2.getNotification().getSortKey();     // Catch: Throwable -> L14
        if (groupSortKey != null) goto L24;
        String groupSortKeyPortion = "nsk";
    L27:
        boolean isGroupSummary = record2.getNotification().isGroupSummary();     // Catch: Throwable -> L14
        Integer r10 = Integer.valueOf(record2.getCriticality());     // Catch: Throwable -> L14
        Integer r12 = Integer.valueOf(groupProxy.getAuthoritativeRank());     // Catch: Throwable -> L14
        if (isGroupSummary == false) goto L30;
        char r14 = '0';
    L31:
        record2.setGlobalSortKey(TextUtils.formatSimple("crtcl=0x%04x:intrsv=%c:grnk=0x%04x:gsmry=%c:%s:rnk=0x%04x", new Object[]{r10, '2', r12, Character.valueOf(r14), groupSortKeyPortion, Integer.valueOf(record2.getAuthoritativeRank())}));     // Catch: Throwable -> L14
        i3 = i3 + 1;     // Catch: Throwable -> L14
        goto L19
    L30:
        r14 = '1';
        goto L31
    L24:
        if (groupSortKey.equals("") == false) goto L26;
        groupSortKeyPortion = "esk";
        goto L27
    L26:
        groupSortKeyPortion = "gsk=" + groupSortKey;     // Catch: Throwable -> L14
        goto L27
    L32:
        this.mProxyByGroupTmp.clear();     // Catch: Throwable -> L14
        monitor-exit(r4);     // Catch: Throwable -> L14
        Collections.sort(notificationList, this.mFinalComparator);
    }

    public int indexOf(ArrayList<NotificationRecord> notificationList, NotificationRecord target) {
        return Collections.binarySearch(notificationList, target, this.mFinalComparator);
    }

    public void dump(PrintWriter pw, String prefix, NotificationManagerService.DumpFilter filter) {
        int N = this.mSignalExtractors.length;
        pw.print(prefix);
        pw.print("mSignalExtractors.length = ");
        pw.println(N);
        int i = 0;
    L3:
        if (i >= N) goto L6;
        pw.print(prefix);
        pw.print("  ");
        pw.println(this.mSignalExtractors[i].getClass().getSimpleName());
        i = i + 1;
        goto L3
    }

    public void dump(ProtoOutputStream proto, NotificationManagerService.DumpFilter filter) {
        int N = this.mSignalExtractors.length;
        int i = 0;
    L3:
        if (i >= N) goto L6;
        proto.write(2237677961217L, this.mSignalExtractors[i].getClass().getSimpleName());
        i = i + 1;
        goto L3
    }
}
