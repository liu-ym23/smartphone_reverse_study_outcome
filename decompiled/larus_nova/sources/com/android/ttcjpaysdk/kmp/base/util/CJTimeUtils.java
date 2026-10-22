package com.android.ttcjpaysdk.kmp.base.util;

import com.android.ttcjpaysdk.kmp.base.alog.CJLogger;
import com.android.ttcjpaysdk.kmp.base.extension.CoroutineExtensionKt;
import com.android.ttcjpaysdk.kmp.base.http.CJHeader;
import com.android.ttcjpaysdk.kmp.base.tracker.IKmpCJTrackerService;
import fuc.e;
import fuc.f;
import fuc.g;
import fuc.h;
import gb6.d;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.datetime.format.DateTimeComponents;
import nuc.a1;
import nuc.v2;
import ouc.i;
import ouc.k;
import pd6.b;
import pd6.c;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u001d\u001a\u00020\u0019J(\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00192\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"2\b\u0010$\u001a\u0004\u0018\u00010\u0005J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0019H\u0002J\"\u0010(\u001a\u00020\u001f2\b\u0010)\u001a\u0004\u0018\u00010\u00052\u0006\u0010'\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u0005H\u0002J\u0018\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u0005H\u0002J\u0018\u0010.\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u0005H\u0002J\u0018\u00100\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u0019H\u0002J\u0012\u00102\u001a\u00020\u00052\b\u00103\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u00104\u001a\u00020\u001f2\u0006\u00105\u001a\u00020&H\u0002JL\u00106\u001a\u00020\u001f2\u0006\u00107\u001a\u00020&2\b\b\u0002\u00108\u001a\u00020\u00192\b\b\u0002\u00109\u001a\u00020\f2\b\b\u0002\u0010:\u001a\u00020\f2\b\b\u0002\u0010*\u001a\u00020\u00052\b\b\u0002\u0010;\u001a\u00020\u00192\b\b\u0002\u0010<\u001a\u00020\u0019H\u0002J$\u0010=\u001a\u00020\u001f2\u0006\u0010>\u001a\u00020\u00052\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020A0@H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/util/CJTimeUtils;", "", "<init>", "()V", "TAG", "", "KV_REPO_NAME", "KEY_OFFSET_USE_SYSTEM_LOCAL_TIME", "KEY_OFFSET_USE_ELAPSED_TIME", "KEY_LAST_UPDATE_ELAPSED_TIME", "KEY_LAST_UPDATE_LOCAL_TIME", "VALUE_NET_COST_THRESHOLD_MS", "", "VALUE_UPDATE_EFFECTIVE_TIME_MS", "KEY_EVENT_NO_SYNC_COUNT", "KEY_EVENT_FLUCTUATION", "KEY_PARAM_HAS_LOCAL_CACHE", "KEY_PARAM_OFFSET_LOCAL_DIFF_TIME", "KEY_PARAM_UPTIME_DIFF_STATUS", "KEY_PARAM_START_TIME_DIFF_STATUS", "KEY_PARAM_IS_FIRST", "KEY_PARAM_SYNC_URL", "KEY_PARAM_DURATION", "KEY_PARAM_DIFF_TIME", "offsetUseElapsedRealtime", "", "Ljava/lang/Long;", "minNetCost", "lastUpdateElapsedRealtime", "getServerTime", "updateServerTime", "", "reqStartTime", "headers", "", "Lcom/android/ttcjpaysdk/kmp/base/http/CJHeader;", "reqUrl", "checkNeedUpdate", "", "netCost", "updateAndSaveOffset", "dateStr", "syncUrl", "getStringFromHostRepo", "key", "defaultStr", "storeStringInHostRepo", "value", "getTimeFromHostRepo", "defaultTime", "getSyncUrl", "url", "reportNoSyncCountEvent", "hasLocalCache", "reportFluctuationEvent", "isFirst", "offsetLocalDiffTime", "uptimeDiffStatus", "startTimeDiffStatus", "duration", "diffTime", "reportEvent", "eventName", "evtParams", "", "Lkotlinx/serialization/json/JsonElement;", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CJTimeUtils {
    public static final int $stable = 0;
    public static final CJTimeUtils INSTANCE = null;
    private static final String KEY_EVENT_FLUCTUATION = "wallet_rd_timesync_fluctuation";
    private static final String KEY_EVENT_NO_SYNC_COUNT = "wallet_rd_timesync_nosync_count";
    private static final String KEY_LAST_UPDATE_ELAPSED_TIME = "cjpay_ts_last_update_elapsed_time";
    private static final String KEY_LAST_UPDATE_LOCAL_TIME = "cjpay_ts_last_update_local_time";
    private static final String KEY_OFFSET_USE_ELAPSED_TIME = "cjpay_ts_offset_use_elapsed_time";
    private static final String KEY_OFFSET_USE_SYSTEM_LOCAL_TIME = "cjpay_ts_offset_use_system_local_time";
    private static final String KEY_PARAM_DIFF_TIME = "diff_time";
    private static final String KEY_PARAM_DURATION = "duration";
    private static final String KEY_PARAM_HAS_LOCAL_CACHE = "has_local_cache";
    private static final String KEY_PARAM_IS_FIRST = "is_first";
    private static final String KEY_PARAM_OFFSET_LOCAL_DIFF_TIME = "offset_local_diff_time";
    private static final String KEY_PARAM_START_TIME_DIFF_STATUS = "start_time_diff_status";
    private static final String KEY_PARAM_SYNC_URL = "sync_url";
    private static final String KEY_PARAM_UPTIME_DIFF_STATUS = "uptime_diff_status";
    private static final String KV_REPO_NAME = "cjpay_time_sync_kv_repo";
    private static final String TAG = "CJTimeUtils";
    private static final int VALUE_NET_COST_THRESHOLD_MS = 5000;
    private static final int VALUE_UPDATE_EFFECTIVE_TIME_MS = 120000;
    private static long lastUpdateElapsedRealtime;
    private static int minNetCost;
    private static Long offsetUseElapsedRealtime;

    private CJTimeUtils() {
    }

    public static /* synthetic */ Unit a(String r100, Map r101) {
        return reportEvent$lambda$12(r100, r101);
    }

    static {
        INSTANCE = new CJTimeUtils();
        minNetCost = 5000;
        lastUpdateElapsedRealtime = SystemTimeUtils.INSTANCE.elapsedRealtime();
        $stable = 8;
    }

    public final long getServerTime() {
        Long r100 = offsetUseElapsedRealtime;     // Catch: Throwable -> L13
        if (r100 == null) goto L7;
        long r101 = r100.longValue();     // Catch: Throwable -> L13
        CJLogger r102 = CJLogger.INSTANCE;     // Catch: Throwable -> L13
        StringBuilder r103 = new StringBuilder("use elapsedRealtime offset, ");     // Catch: Throwable -> L13
        SystemTimeUtils r104 = SystemTimeUtils.INSTANCE;     // Catch: Throwable -> L13
        r103.append(r104.elapsedRealtime() + r101);     // Catch: Throwable -> L13
        r102.i(TAG, r103.toString());     // Catch: Throwable -> L13
        return r104.elapsedRealtime() + r101;
    L7:
        CJTimeUtils r105 = INSTANCE;     // Catch: Throwable -> L13
        Long r106 = StringsKt.toLongOrNull(r105.getStringFromHostRepo(KEY_OFFSET_USE_SYSTEM_LOCAL_TIME, ""));     // Catch: Throwable -> L13
        if (r106 == null) goto L11;
        long r107 = r106.longValue();     // Catch: Throwable -> L13
        CJLogger r108 = CJLogger.INSTANCE;     // Catch: Throwable -> L13
        StringBuilder r109 = new StringBuilder("use currentTimeMillis offset, ");     // Catch: Throwable -> L13
        SystemTimeUtils r110 = SystemTimeUtils.INSTANCE;     // Catch: Throwable -> L13
        r109.append(r110.currentTimeMillis() + r107);     // Catch: Throwable -> L13
        r108.i(TAG, r109.toString());     // Catch: Throwable -> L13
        r105.reportNoSyncCountEvent(true);     // Catch: Throwable -> L13
        return r110.currentTimeMillis() + r107;
    L11:
        CJLogger.INSTANCE.i(TAG, "use currentTimeMillis");     // Catch: Throwable -> L13
    L15:
        reportNoSyncCountEvent(false);
        return SystemTimeUtils.INSTANCE.currentTimeMillis();
    L13:
        th = move-exception;
        CJLogger.INSTANCE.e(TAG, "getServerTime exp " + th.getMessage());
        goto L15
    }

    private final boolean checkNeedUpdate(long r100) {
        CJLogger.INSTANCE.i(TAG, "updateServerTime netCost: " + r100 + ", minNetCost: " + minNetCost);
        if (r100 < 5000) goto L5;
    L9:
        return false;
    L5:
        if (r100 > minNetCost) goto L7;
    L8:
        return true;
    L7:
        if ((SystemTimeUtils.INSTANCE.elapsedRealtime() - lastUpdateElapsedRealtime) <= 120000) goto L9;
        goto L8
    }

    private final String getSyncUrl(String r100) {
        if (r100 != null) goto L4;
    L19:
        return "";
    L4:
        if ((!StringsKt.isBlank(r100)) == true) goto L7;
        r100 = null;
    L7:
        if (r100 == null) goto L19;
        String r101 = StringsKt.trim(r100).toString();
        if (r101 == null) goto L19;
        String r102 = StringsKt.substringAfter(r101, "://", r101);
        if (r102 == null) goto L19;
        String r103 = StringsKt.substringAfter$default(r102, '@', null, 2, null);
        if (r103 == null) goto L19;
        String r104 = StringsKt.substringBefore$default(r103, '?', null, 2, null);
        if (r104 == null) goto L19;
        String r105 = StringsKt.substringBefore$default(r104, '#', null, 2, null);
        if (r105 == null) goto L19;
        return r105;
    }

    private final void reportNoSyncCountEvent(boolean r100) {
        reportEvent(KEY_EVENT_NO_SYNC_COUNT, MapsKt.mapOf(TuplesKt.to(KEY_PARAM_HAS_LOCAL_CACHE, k.a(Boolean.valueOf(r100)))));
    }

    private final String getStringFromHostRepo(String r100, String r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L4
        Object r103 = Result.m9449constructorimpl(d.a(KV_REPO_NAME).getString(r100, r101));     // Catch: Throwable -> L4
    L7:
        if (Result.m9455isFailureimpl(r103) == false) goto L9;
        r103 = null;
    L9:
        String r104 = (String) r103;
        if (r104 != null) goto L13;
        return r101;
    L13:
        return r104;
    L4:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private final long getTimeFromHostRepo(String r100, long r101) {
        Long r102 = StringsKt.toLongOrNull(getStringFromHostRepo(r100, String.valueOf(r101)));
        if (r102 != null) goto L5;
        return r101;
    L5:
        return r102.longValue();
    }

    private final void reportEvent(final String r100, final Map<String, ? extends i> r101) {
        ThreadUtils_androidKt.runOnFFIThread(new a(r100, r101));
    }

    private static final Unit reportEvent$lambda$12(String r100, Map r101) {
        b r102 = c.f528682a;
        IKmpCJTrackerService r103 = (IKmpCJTrackerService) c.a(Reflection.getOrCreateKotlinClass(IKmpCJTrackerService.class));
        if (r103 == null) goto L5;
        ouc.a.C7114a r104 = ouc.a.f526798d;
        r104.getClass();
        r103.trackEvent(r100, r104.a(new a1(v2.f520790a, i.Companion.serializer()), r101));
        return Unit.INSTANCE;
    L5:
        return null;
    }

    private final void storeStringInHostRepo(String r100, String r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L4
        d.a(KV_REPO_NAME).storeString(r100, r101);     // Catch: Throwable -> L4
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    private final void updateAndSaveOffset(String r310, long r410, String r411) {
        CJLogger r100 = CJLogger.INSTANCE;
        r100.i(TAG, "updateAndSaveOffset dateStr: " + r310 + ", netCost: " + r410 + ", syncUrl: " + r411);
        if (r310 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L53;
        DateTimeComponents r102 = DateTimeComponents.b.f505177b.a(r310);     // Catch: Throwable -> L48
        e r103 = r102.f505175a.f505236a.g();     // Catch: Throwable -> L48
        g r104 = r102.f505175a.f505237b.b();     // Catch: Throwable -> L48
        Intrinsics.checkNotNullParameter(r103, "<this>");     // Catch: Throwable -> L48
        Intrinsics.checkNotNullParameter(r104, "time");     // Catch: Throwable -> L48
        f r110 = new f(r103, r104);     // Catch: Throwable -> L48
        h.Companion.getClass();     // Catch: Throwable -> L48
        long r105 = fuc.i.a(r110, h.f478939b).a();     // Catch: Throwable -> L48
        if (r105 <= 0) goto L54;
        SystemTimeUtils r106 = SystemTimeUtils.INSTANCE;     // Catch: Throwable -> L48
        long r111 = r106.elapsedRealtime();     // Catch: Throwable -> L48
        long r112 = r106.currentTimeMillis();     // Catch: Throwable -> L48
        long r107 = r105 - r112;     // Catch: Throwable -> L48
        long r113 = r105 - r111;     // Catch: Throwable -> L48
        Long r210 = offsetUseElapsedRealtime;     // Catch: Throwable -> L48
        if (r210 != null) goto L16;
        CJTimeUtils r114 = INSTANCE;     // Catch: Throwable -> L46
        long r211 = r113 - r114.getTimeFromHostRepo(KEY_OFFSET_USE_ELAPSED_TIME, 0);     // Catch: Throwable -> L46
        long r212 = r114.getTimeFromHostRepo(KEY_LAST_UPDATE_ELAPSED_TIME, 0);     // Catch: Throwable -> L46
        long r213 = r111 - r212;     // Catch: Throwable -> L46
        int r214 = 2;
        if (r213 >= 0) goto L20;
        int r311 = 1;
    L23:
        long r312 = r114.getTimeFromHostRepo(KEY_LAST_UPDATE_LOCAL_TIME, 0);     // Catch: Throwable -> L46
        long r108 = r312 - r212;     // Catch: Throwable -> L46
        long r215 = r112 - r111;     // Catch: Throwable -> L46
        if (Math.abs(r215 - r108) >= 1000) goto L27;
    L40:
        long r109 = 0;
        r214 = 0;
    L41:
        long r216 = r107 - r114.getTimeFromHostRepo(KEY_OFFSET_USE_SYSTEM_LOCAL_TIME, r109);     // Catch: Throwable -> L46
        long r115 = r211;
        boolean r217 = true;
    L42:
        offsetUseElapsedRealtime = Long.valueOf(r113);     // Catch: Throwable -> L46
        lastUpdateElapsedRealtime = r111;     // Catch: Throwable -> L46
        minNetCost = (int) r410;     // Catch: Throwable -> L46
        r100.i(TAG, "do update, serverDateTime: " + r105 + ", offsetUseElapsedRealtime: " + offsetUseElapsedRealtime + ", offsetUseSystemLocaltime: " + r107 + ", minNetCost: " + minNetCost);     // Catch: Throwable -> L46
        storeStringInHostRepo(KEY_OFFSET_USE_SYSTEM_LOCAL_TIME, String.valueOf(r107));     // Catch: Throwable -> L48
        storeStringInHostRepo(KEY_OFFSET_USE_ELAPSED_TIME, String.valueOf(r113));     // Catch: Throwable -> L48
        storeStringInHostRepo(KEY_LAST_UPDATE_ELAPSED_TIME, String.valueOf(lastUpdateElapsedRealtime));     // Catch: Throwable -> L48
        storeStringInHostRepo(KEY_LAST_UPDATE_LOCAL_TIME, String.valueOf(r112));     // Catch: Throwable -> L48
        reportFluctuationEvent(r217, r216, r311, r214, r411, r410, r115);     // Catch: Throwable -> L48
        return;
    L27:
        if (r108 <= r215) goto L30;
        r109 = 0;
        r214 = 1;
        goto L41
    L30:
        if (r312 >= r215) goto L33;
        r109 = 0;
        goto L41
    L33:
        if ((r108 + 1) <= r215) goto L35;
    L37:
        boolean r116 = false;
    L38:
        if (r116 == false) goto L40;
        r109 = 0;
        r214 = 3;
        goto L41
    L35:
        if (r215 >= r312) goto L37;
        r116 = true;
        goto L38
    L20:
        if (r213 <= 0) goto L22;
        r311 = 2;
        goto L23
    L22:
        r311 = 0;
    L47:
        return;
    L16:
        r115 = r113 - r210.longValue();
        r214 = 0;
        r217 = false;
        r216 = 0;
        r311 = 0;
        goto L42
    L54:
        return;
    L56:
        return;
    L53:
        return;
    L5:
        if (r310.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public final void updateServerTime(long r110, List<CJHeader> r111, String r112) {
        long r100 = SystemTimeUtils.INSTANCE.currentTimeMillis() - r110;
    L19:
        th = th;
    L23:
        CJLogger.INSTANCE.e(TAG, "updateServerTime exp " + th.getMessage());
        return;
    L5:
        if (checkNeedUpdate(r100) == true) goto L7;
        return;
    L7:
        if (r111 == null) goto L32;
        Iterator<T> r101 = r111.iterator();     // Catch: Throwable -> L19
    L10:
        if (r101.hasNext() == false) goto L14;
        Object r102 = r101.next();     // Catch: Throwable -> L19
        if (StringsKt.equals("date", ((CJHeader) r102).getName(), true) == false) goto L10;
    L15:
        CJHeader r103 = (CJHeader) r102;     // Catch: Throwable -> L19
        if (r103 == null) goto L33;
        BuildersKt.launch$default(CoroutineExtensionKt.getGlobalMainScope(), null, null, new CJTimeUtils$updateServerTime$2$1(r103, r100, INSTANCE.getSyncUrl(r112), null), 3, null);     // Catch: Throwable -> L19
        return;
    L33:
        return;
    L14:
        r102 = null;
        goto L15
    L32:
        return;
    L21:
        th = th;
        goto L23
    }

    public static final /* synthetic */ void access$updateAndSaveOffset(CJTimeUtils r100, String r101, long r102, String r103) {
        r100.updateAndSaveOffset(r101, r102, r103);
    }

    private final void reportFluctuationEvent(boolean r100, long r101, int r102, int r103, String r104, long r110, long r111) {
        Map<String, ? extends i> r105 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("is_first", k.a(Boolean.valueOf(r100))), TuplesKt.to(KEY_PARAM_SYNC_URL, k.c(r104)), TuplesKt.to("duration", k.b(Long.valueOf(r110))), TuplesKt.to(KEY_PARAM_DIFF_TIME, k.b(Long.valueOf(r111)))});
        if (r100 == false) goto L5;
        r105.put(KEY_PARAM_OFFSET_LOCAL_DIFF_TIME, k.b(Long.valueOf(r101)));
        r105.put(KEY_PARAM_UPTIME_DIFF_STATUS, k.b(Integer.valueOf(r102)));
        r105.put(KEY_PARAM_START_TIME_DIFF_STATUS, k.b(Integer.valueOf(r103)));
    L5:
        reportEvent(KEY_EVENT_FLUCTUATION, r105);
    }

    public static /* synthetic */ void reportFluctuationEvent$default(CJTimeUtils r110, boolean r111, long r112, int r113, int r114, String r115, long r116, long r117, int r210, Object r211) {
        long r100 = 0;
        if ((r210 & 2) == 0) goto L5;
        long r101 = 0;
    L6:
        int r102 = 0;
        if ((r210 & 4) == 0) goto L9;
        int r103 = 0;
    L11:
        if ((r210 & 8) != 0) goto L15;
        r102 = r114;
    L15:
        if ((r210 & 16) == 0) goto L17;
        String r104 = "";
    L19:
        if ((r210 & 32) == 0) goto L21;
        long r105 = 0;
    L23:
        if ((r210 & 64) != 0) goto L26;
        r100 = r117;
    L26:
        r110.reportFluctuationEvent(r111, r101, r103, r102, r104, r105, r100);
        return;
    L21:
        r105 = r116;
        goto L23
    L17:
        r104 = r115;
        goto L19
    L9:
        r103 = r113;
        goto L11
    L5:
        r101 = r112;
        goto L6
    }
}
