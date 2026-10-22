package com.android.ttcjpaysdk.bdpay.counter.outer.sign.helper;

import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.ss.android.dypay.api.DyPayConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001a\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0004H\u0002J\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00010\u001fJ\u0006\u0010!\u001a\u00020\"R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\b¨\u0006#"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/sign/helper/CJSignPerfTracker;", "", "()V", "firstLaidOutTs", "", "getFirstLaidOutTs", "()J", "setFirstLaidOutTs", "(J)V", "httpCallStartTs", "getHttpCallStartTs", "setHttpCallStartTs", "pageRefreshedTs", "getPageRefreshedTs", "setPageRefreshedTs", "requestPrepareStartTs", "getRequestPrepareStartTs", "setRequestPrepareStartTs", "responseCallbackStartTs", "getResponseCallbackStartTs", "setResponseCallbackStartTs", "routeStartTs", "getRouteStartTs", "setRouteStartTs", DyPayConstant.KEY_START_TIME, "getStartTime", "setStartTime", "duration", "start", "end", "getFinalPerfParams", "", "", BasicTestActionHandler.TEST_ACTION_RESET, "", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJSignPerfTracker {
    public static final CJSignPerfTracker INSTANCE = null;
    private static long firstLaidOutTs;
    private static long httpCallStartTs;
    private static long pageRefreshedTs;
    private static long requestPrepareStartTs;
    private static long responseCallbackStartTs;
    private static long routeStartTs;
    private static long startTime;

    static {
        INSTANCE = new CJSignPerfTracker();
    }

    private CJSignPerfTracker() {
    }

    private final long duration(long r100, long r101) {
        if (r100 > 0) goto L5;
        return -1;
    L5:
        if (r101 > 0) goto L7;
        return -1;
    L7:
        if (r101 >= r100) goto L10;
        return -1;
    L10:
        return r101 - r100;
    }

    public final Map<String, Object> getFinalPerfParams() {
        long r100 = pageRefreshedTs;
        if (r100 > 0) goto L6;
        r100 = firstLaidOutTs;
    L6:
        long r101 = duration(startTime, r100);
        long r102 = duration(routeStartTs, firstLaidOutTs);
        long r103 = duration(routeStartTs, requestPrepareStartTs);
        long r104 = duration(requestPrepareStartTs, httpCallStartTs);
        long r110 = duration(httpCallStartTs, responseCallbackStartTs);
        long r111 = -1;
        if (r102 >= 0) goto L9;
    L11:
        long r112 = -1;
    L13:
        if (r112 < 0) goto L20;
        if (r103 < 0) goto L20;
        if (r104 < 0) goto L20;
        r111 = (r112 - r103) - r104;
    L20:
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("client_duration", Long.valueOf(r101)), TuplesKt.to("entry_to_imp_duration", Long.valueOf(r102)), TuplesKt.to("route_to_http_call", Long.valueOf(r103)), TuplesKt.to("body_encode", Long.valueOf(r104)), TuplesKt.to(LBSLightLocationTraceLogger.NETWORK_TOTAL, Long.valueOf(r110)), TuplesKt.to("response_to_laid_out", Long.valueOf(r111)), TuplesKt.to("client_pure_duration", Long.valueOf(r112))});
    L9:
        if (r110 < 0) goto L11;
        r112 = r102 - r110;
        goto L13
    }

    public final void reset() {
        startTime = 0;
        routeStartTs = 0;
        requestPrepareStartTs = 0;
        httpCallStartTs = 0;
        responseCallbackStartTs = 0;
        firstLaidOutTs = 0;
        pageRefreshedTs = 0;
    }

    public final long getFirstLaidOutTs() {
        return firstLaidOutTs;
    }

    public final long getHttpCallStartTs() {
        return httpCallStartTs;
    }

    public final long getPageRefreshedTs() {
        return pageRefreshedTs;
    }

    public final long getRequestPrepareStartTs() {
        return requestPrepareStartTs;
    }

    public final long getResponseCallbackStartTs() {
        return responseCallbackStartTs;
    }

    public final long getRouteStartTs() {
        return routeStartTs;
    }

    public final long getStartTime() {
        return startTime;
    }

    public final void setFirstLaidOutTs(long r100) {
        firstLaidOutTs = r100;
    }

    public final void setHttpCallStartTs(long r100) {
        httpCallStartTs = r100;
    }

    public final void setPageRefreshedTs(long r100) {
        pageRefreshedTs = r100;
    }

    public final void setRequestPrepareStartTs(long r100) {
        requestPrepareStartTs = r100;
    }

    public final void setResponseCallbackStartTs(long r100) {
        responseCallbackStartTs = r100;
    }

    public final void setRouteStartTs(long r100) {
        routeStartTs = r100;
    }

    public final void setStartTime(long r100) {
        startTime = r100;
    }
}
