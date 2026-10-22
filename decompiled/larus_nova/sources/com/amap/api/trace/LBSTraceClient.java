package com.amap.api.trace;

import android.content.Context;
import com.amap.api.mapcore.util.h5;
import com.amap.api.mapcore.util.p0;
import com.amap.api.mapcore.util.u5;
import com.amap.api.mapcore.util.v5;
import com.amap.api.mapcore.util.w3;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class LBSTraceClient {
    public static final String LOCATE_TIMEOUT_ERROR = null;
    public static final String MIN_GRASP_POINT_ERROR = null;
    public static final String TRACE_SUCCESS = null;
    public static final int TYPE_AMAP = 1;
    public static final int TYPE_BAIDU = 3;
    public static final int TYPE_GPS = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static LBSTraceBase f29317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile LBSTraceClient f29318b;

    public void destroy() {
        LBSTraceBase r100 = f29317a;
        if (r100 == null) goto L6;
        r100.destroy();
        f29317a = null;
        f29318b = null;
        return;
    }

    public void stopTrace() {
        LBSTraceBase r100 = f29317a;
        if (r100 == null) goto L6;
        r100.stopTrace();
        return;
    }

    static {
        MIN_GRASP_POINT_ERROR = p0.a(2131034197);
        LOCATE_TIMEOUT_ERROR = p0.a(2131034198);
        TRACE_SUCCESS = p0.a(2131034199);
    }

    private LBSTraceClient() {
    }

    public LBSTraceClient(Context r100) throws Exception {
        a(r100);
    }

    private static void a(Context r100) throws Exception {
        v5 r101 = u5.a(r100, w3.b());
        if (r101.f28191a != u5.e.f28083b) goto L8;
        if (r100 == null) goto L9;
        f29317a = new h5(r100.getApplicationContext());
        return;
    L9:
        return;
    L8:
        throw new Exception(r101.f28192b);
    }

    public static LBSTraceClient getInstance(Context r100) throws Exception {
        if (f29318b != null) goto L15;
        monitor-enter(LBSTraceClient.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f29318b != null) goto L9;
        a(r100);     // Catch: Throwable -> L11
        f29318b = new LBSTraceClient();     // Catch: Throwable -> L11
    L9:
        monitor-exit(LBSTraceClient.class);     // Catch: Throwable -> L11
    L15:
        return f29318b;
    }

    public void startTrace(TraceStatusListener r100) {
        LBSTraceBase r101 = f29317a;
        if (r101 == null) goto L6;
        r101.startTrace(r100);
        return;
    }

    public void queryProcessedTrace(int r100, List<TraceLocation> r101, int r102, TraceListener r103) {
        LBSTraceBase r104 = f29317a;
        if (r104 == null) goto L6;
        r104.queryProcessedTrace(r100, r101, r102, r103);
        return;
    }
}
