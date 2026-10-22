package com.obric.matrix.platform.sdk.ones.commonmonitor.fps;

import android.os.SystemClock;
import android.widget.AbsListView;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.apm.trace.fps.FpsTracer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONObject;

/* JADX INFO: compiled from: ListViewFPSMonitorOnScrollListener.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ListViewFPSMonitorOnScrollListener implements AbsListView.OnScrollListener {
    public static final a Companion = null;
    private static final ConcurrentLinkedQueue<com.obric.matrix.platform.sdk.ones.commonmonitor.fps.d> FPS_BEANS = null;
    private static final String TAG = "FPSMonitorOnScrollListener";
    private com.obric.matrix.platform.sdk.ones.commonmonitor.fps.d curFpsBean;
    private int distanceX;
    private int distanceY;
    private long dragStart;
    private final boolean forceCollect;
    private final b fpsCallBack;
    private com.obric.matrix.platform.sdk.ones.commonmonitor.fps.d lastFpsBean;
    private final FpsTracer mFpsTracer;
    private boolean printerHasReset;
    private final String scene;

    /* JADX INFO: compiled from: ListViewFPSMonitorOnScrollListener.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: ListViewFPSMonitorOnScrollListener.kt */
    public interface b {
        void a(com.obric.matrix.platform.sdk.ones.commonmonitor.fps.d r1);
    }

    /* JADX INFO: compiled from: ListViewFPSMonitorOnScrollListener.kt */
    public static final class c implements FpsTracer.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ListViewFPSMonitorOnScrollListener f33645a;

        c(ListViewFPSMonitorOnScrollListener r1) {
            this.f33645a = r1;
        }

        @Override // com.bytedance.apm.trace.fps.FpsTracer.c
        public void a(double r5) {
            ListViewFPSMonitorOnScrollListener.access$setLastFpsBean$p(this.f33645a, (com.obric.matrix.platform.sdk.ones.commonmonitor.fps.d) ZeusTransformUtils.preCheckCast(ListViewFPSMonitorOnScrollListener.access$getFPS_BEANS$cp().poll(), com.obric.matrix.platform.sdk.ones.commonmonitor.fps.d.class, "com.obric.aiagent.plugin"));
            com.obric.matrix.platform.sdk.ones.commonmonitor.fps.d r4 = ListViewFPSMonitorOnScrollListener.access$getLastFpsBean$p(this.f33645a);
            if (r4 == null) goto L7;
            r4.a(r5);
            return;
        }
    }

    /* JADX INFO: compiled from: ListViewFPSMonitorOnScrollListener.kt */
    public static final class d implements FpsTracer.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ListViewFPSMonitorOnScrollListener f33646a;

        d(ListViewFPSMonitorOnScrollListener r1) {
            this.f33646a = r1;
        }

        @Override // com.bytedance.apm.trace.fps.FpsTracer.b
        public void a(JSONObject r14) {
            if (r14 != null) goto L5;
            return;
        L5:
            if (ListViewFPSMonitorOnScrollListener.access$getLastFpsBean$p(this.f33646a) == null) goto L47;
            Iterator<String> r1 = r14.keys();     // Catch: Exception -> L33
            double r2 = 0.0d;
            int r6 = 0;
            int r7 = 0;
            int r8 = 0;
            double r4 = 0.0d;
        L8:
            if (r1.hasNext() == false) goto L22;
            String r9 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L33
            o.c(r9, "keyStr");     // Catch: Exception -> L33
            int r10 = Integer.parseInt(r9);     // Catch: Exception -> L33
            int r11 = r14.getInt(r9);     // Catch: Exception -> L33
            if (r10 == 0) goto L11;
            if (r10 <= 0) goto L8;
            r2 = r2 + ((double) (r10 * r11));     // Catch: Exception -> L33
            r4 = r4 + ((double) r11);     // Catch: Exception -> L33
            if (r10 < 25) goto L17;
            r8 = r8 + r11;     // Catch: Exception -> L33
        L17:
            if (r10 < 7) goto L20;
            r7 = r7 + r11;     // Catch: Exception -> L33
        L20:
            if (r10 < 3) goto L8;
            r6 = r6 + r11;     // Catch: Exception -> L33
            goto L8
        L11:
            r4 = r4 + ((double) r11);     // Catch: Exception -> L33
            goto L8
        L22:
            com.obric.matrix.platform.sdk.ones.commonmonitor.fps.d r3 = ListViewFPSMonitorOnScrollListener.access$getLastFpsBean$p(this.f33646a);     // Catch: Exception -> L33
            if (r3 == null) goto L25;
            r3.b(e.f33662a.a(r2 / (r2 + r4)));     // Catch: Exception -> L33
            r3.b(r6);     // Catch: Exception -> L33
            r3.c(r7);     // Catch: Exception -> L33
            r3.d(r8);     // Catch: Exception -> L33
            r3.a((int) r4);     // Catch: Exception -> L33
        L25:
            com.obric.matrix.platform.sdk.ones.internal.b.b.c(ListViewFPSMonitorOnScrollListener.TAG, "dropFrame: " + r14, null, 4, null);     // Catch: Exception -> L33
            com.obric.matrix.platform.sdk.ones.internal.b.b.c(ListViewFPSMonitorOnScrollListener.TAG, "fpsCallBack: " + ListViewFPSMonitorOnScrollListener.access$getLastFpsBean$p(this.f33646a), null, 4, null);     // Catch: Exception -> L33
            b r15 = ListViewFPSMonitorOnScrollListener.access$getFpsCallBack$p(this.f33646a);     // Catch: Exception -> L33
            if (r15 == null) goto L28;
            r15.a(ListViewFPSMonitorOnScrollListener.access$getLastFpsBean$p(this.f33646a));     // Catch: Exception -> L33
        L28:
            com.obric.matrix.platform.sdk.ones.commonmonitor.fps.d r16 = ListViewFPSMonitorOnScrollListener.access$getLastFpsBean$p(this.f33646a);     // Catch: Exception -> L33
            if (r16 == null) goto L31;
            r16.a();     // Catch: Exception -> L33
        L31:
            ListViewFPSMonitorOnScrollListener.access$setLastFpsBean$p(this.f33646a, null);     // Catch: Exception -> L33
            return;
        L48:
            return;
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView r1, int r2, int r3, int r4) {
        o.e(r1, "view");
    }

    public ListViewFPSMonitorOnScrollListener(String r3, boolean r4, b r5) {
        b r6 = (b) ZeusTransformUtils.wrapperContextForParams(r5, b.class, "com.obric.aiagent.plugin");
        o.e(r3, DBHelper.BATTERY_COL_SCENE);
        this.scene = r3;
        this.forceCollect = r4;
        this.fpsCallBack = r6;
        this.mFpsTracer = new FpsTracer(r3, r4);
        this.dragStart = -1;
        initFpsTracerCallbacks();
    }

    public /* synthetic */ ListViewFPSMonitorOnScrollListener(String r2, boolean r3, b r4, int r5, h r6) {
        b r7 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = false;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r7 = null;
    L8:
        this(r2, r3, r7);
    }

    public static final /* synthetic */ ConcurrentLinkedQueue access$getFPS_BEANS$cp() {
        return FPS_BEANS;
    }

    public static final /* synthetic */ b access$getFpsCallBack$p(ListViewFPSMonitorOnScrollListener r0) {
        return r0.fpsCallBack;
    }

    public static final /* synthetic */ com.obric.matrix.platform.sdk.ones.commonmonitor.fps.d access$getLastFpsBean$p(ListViewFPSMonitorOnScrollListener r0) {
        return r0.lastFpsBean;
    }

    public static final /* synthetic */ void access$setLastFpsBean$p(ListViewFPSMonitorOnScrollListener r0, com.obric.matrix.platform.sdk.ones.commonmonitor.fps.d r1) {
        r0.lastFpsBean = r1;
    }

    static {
        Companion = new a(null);
        FPS_BEANS = new ConcurrentLinkedQueue();
    }

    public ListViewFPSMonitorOnScrollListener(String r3) {
        o.e(r3, DBHelper.BATTERY_COL_SCENE);
        this(r3, false, null);
    }

    private final void initFpsTracerCallbacks() {
        this.mFpsTracer.a((FpsTracer.c) ZeusTransformUtils.preCheckCast(new c(this), FpsTracer.c.class, "com.obric.aiagent.plugin"));
        this.mFpsTracer.a((FpsTracer.b) ZeusTransformUtils.preCheckCast(new d(this), FpsTracer.b.class, "com.obric.aiagent.plugin"));
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView r5, int r6) {
        o.e(r5, "view");
        if (r6 != 0) goto L5;
        com.obric.matrix.platform.sdk.ones.commonmonitor.fps.d r7 = this.curFpsBean;
        if (r7 != null) goto L17;
    L19:
        reset();
        this.mFpsTracer.b();
        return;
    L17:
        if (this.dragStart <= 0) goto L19;
        r7.a(SystemClock.elapsedRealtime() - this.dragStart);
        goto L19
    L5:
        if (r6 == 1) goto L8;
        return;
    L8:
        if (this.dragStart < 0) goto L10;
    L13:
        this.mFpsTracer.a();
        return;
    L10:
        if (this.curFpsBean != null) goto L12;
        this.curFpsBean = com.obric.matrix.platform.sdk.ones.commonmonitor.fps.d.f33657a.a();
    L12:
        com.obric.matrix.platform.sdk.ones.commonmonitor.fps.d r8 = this.curFpsBean;
        this.dragStart = SystemClock.elapsedRealtime();
        goto L13
    }

    private final void reset() {
        this.distanceX = 0;
        this.distanceY = 0;
        this.dragStart = -1;
        com.obric.matrix.platform.sdk.ones.commonmonitor.fps.d r0 = this.curFpsBean;
        if (r0 == null) goto L6;
        FPS_BEANS.add(r0);
        this.curFpsBean = null;
        return;
    }

    public final void removeFpsCallback() {
        this.mFpsTracer.a(null);
    }
}
