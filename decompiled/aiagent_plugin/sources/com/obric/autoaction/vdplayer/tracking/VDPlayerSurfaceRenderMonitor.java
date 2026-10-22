package com.obric.autoaction.vdplayer.tracking;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.view.PixelCopy;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.obric.autogui.vdplayer.api.fws.IPlatformTools;
import com.obric.autogui.vdplayer.api.orchestrator.IAgentSessionManager;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.l.n;
import d.x;
import kotlinx.coroutines.b.ak;
import org.json.JSONObject;

/* JADX INFO: compiled from: VDPlayerSurfaceRenderMonitor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class VDPlayerSurfaceRenderMonitor implements SurfaceHolder.Callback {
    private static final long BLACK_CONFIRM_DURATION_MS = 500;
    private static final int BLACK_CONFIRM_SAMPLE_COUNT = 3;
    private static final long BLACK_CONFIRM_SAMPLE_INTERVAL_MS = 250;
    private static final double BLACK_DARK_PIXEL_RATIO_THRESHOLD = 0.98d;
    private static final int BLACK_MEAN_LUMA_THRESHOLD = 16;
    private static final b Companion = null;
    private static final int DARK_PIXEL_LUMA_THRESHOLD = 24;
    private static final String EVENT_NAME = "obric_vdplayer_surface_render_monitor";
    private static final long FIRST_BUFFER_RETRY_MS = 80;
    private static final long MONITOR_TIMEOUT_MS = 5000;
    private static final int MONITOR_VERSION = 4;
    private static final String REASON_FIRST_BUFFER_NON_BLACK = "first_buffer_non_black";
    private static final String REASON_INITIAL_BLACK_CONFIRMED = "initial_black_confirmed";
    private static final String REASON_MONITOR_TIMEOUT = "monitor_timeout";
    private static final String REASON_PIXEL_ANALYSIS_FAILED = "pixel_analysis_failed";
    private static final String REASON_SECURE_LAYER = "secure_layer";
    private static final String REASON_TRANSIENT_BLACK = "transient_black";
    private static final int RESULT_NOT_REQUESTED = -1;
    private static final int SAMPLE_SIZE = 32;
    private static final String TAG = "VDSurfaceRenderMonitor";
    private static final String THREAD_NAME = "vd-first-open-monitor";
    private static final long UNAVAILABLE_DURATION_MS = -1;
    private static final int UNAVAILABLE_LUMA = -1;
    private static final double UNAVAILABLE_RATE = -1.0d;
    private static final int UNKNOWN_METRIC_VALUE = -1;
    private long blackCandidateStartElapsedMs;
    private int blackSampleCount;
    private a diagnosticSample;
    private boolean finished;
    private long firstBufferDurationMs;
    private c firstBufferStatus;
    private final long firstOpenStartElapsedMs;
    private d initialBlackStatus;
    private final d.h.a.a<Boolean> isSecureLayer;
    private int lastPixelCopyResult;
    private final Handler mainHandler;
    private final Runnable monitorTimeout;
    private final d.h.a.a<x> onFinished;
    private final d.h.a.a<String> operatingPackage;
    private Handler sampleHandler;
    private final Runnable sampleSurface;
    private final HandlerThread sampleThread;
    private boolean started;
    private boolean surfaceActive;
    private int surfaceGeneration;
    private boolean surfaceSeen;
    private final SurfaceView surfaceView;

    /* JADX INFO: compiled from: VDPlayerSurfaceRenderMonitor.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f26052a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f26053b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final double f26054c;

        public boolean equals(Object r7) {
            if (this != r7) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, a.class) == true) goto L8;
            return false;
        L8:
            a r8 = (a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.aiagent.plugin");
            if (this.f26052a == r8.f26052a) goto L12;
            return false;
        L12:
            if (this.f26053b == r8.f26053b) goto L15;
            return false;
        L15:
            if (Double.compare(this.f26054c, r8.f26054c) == 0) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Boolean.hashCode(this.f26052a) * 31) + Integer.hashCode(this.f26053b)) * 31) + Double.hashCode(this.f26054c);
        }

        public String toString() {
            return "BlackSample(isBlack=" + this.f26052a + ", meanLuma=" + this.f26053b + ", darkPixelRatio=" + this.f26054c + ')';
        }

        public a(boolean r1, int r2, double r3) {
            this.f26052a = r1;
            this.f26053b = r2;
            this.f26054c = r3;
        }

        public final boolean a() {
            return this.f26052a;
        }

        public final int b() {
            return this.f26053b;
        }

        public final double c() {
            return this.f26054c;
        }
    }

    /* JADX INFO: compiled from: VDPlayerSurfaceRenderMonitor.kt */
    private static final class b {
        public /* synthetic */ b(h r1) {
            this();
        }

        private b() {
        }
    }

    /* JADX INFO: compiled from: VDPlayerSurfaceRenderMonitor.kt */
    private static final enum c extends Enum<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f26055a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f26056b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f26057c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final c f26058d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final c f26059e = null;
        public static final c f = null;
        private static final /* synthetic */ c[] h = null;
        private static final /* synthetic */ d.d.a i = null;
        private final String g;

        private static final /* synthetic */ c[] b() {
            return new c[]{f26055a, f26056b, f26057c, f26058d, f26059e, f};
        }

        private c(String r1, int r2, String r3) {
            super(r1, r2);
            this.g = r3;
        }

        public final String a() {
            return this.g;
        }

        static {
            f26055a = new c("PENDING", 0, "pending");
            f26056b = new c("SUCCESS", 1, "success");
            f26057c = new c("TIMEOUT", 2, "timeout");
            f26058d = new c("STOPPED", 3, "stopped");
            f26059e = new c("SURFACE_UNAVAILABLE", 4, "surface_unavailable");
            f = new c("SECURE_UNMEASURABLE", 5, "secure_unmeasurable");
            c[] r0 = b();
            h = r0;
            i = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static c valueOf(String r2) {
            return (c) ZeusTransformUtils.preCheckCast(Enum.valueOf(c.class, r2), c.class, "com.obric.aiagent.plugin");
        }

        public static c[] values() {
            return (c[]) ZeusTransformUtils.preCheckCast(h.clone(), c[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: VDPlayerSurfaceRenderMonitor.kt */
    private static final enum d extends Enum<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f26060a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f26061b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final d f26062c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final d f26063d = null;
        private static final /* synthetic */ d[] g = null;
        private static final /* synthetic */ d.d.a h = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f26064e;
        private final int f;

        private static final /* synthetic */ d[] c() {
            return new d[]{f26060a, f26061b, f26062c, f26063d};
        }

        private d(String r1, int r2, String r3, int r4) {
            super(r1, r2);
            this.f26064e = r3;
            this.f = r4;
        }

        public final String a() {
            return this.f26064e;
        }

        public final int b() {
            return this.f;
        }

        static {
            f26060a = new d("PENDING", 0, "pending", -1);
            f26061b = new d("CONFIRMED", 1, "confirmed", 1);
            f26062c = new d("NOT_BLACK", 2, "not_black", 0);
            f26063d = new d("UNKNOWN", 3, SensitiveType.UNKNOWN, -1);
            d[] r0 = c();
            g = r0;
            h = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static d valueOf(String r2) {
            return (d) ZeusTransformUtils.preCheckCast(Enum.valueOf(d.class, r2), d.class, "com.obric.aiagent.plugin");
        }

        public static d[] values() {
            return (d[]) ZeusTransformUtils.preCheckCast(g.clone(), d[].class, "com.obric.aiagent.plugin");
        }
    }

    static {
        Companion = new b(null);
    }

    public static /* synthetic */ void lambda$5PARpUA23x_ykDLrNZb6qvETOo0(VDPlayerSurfaceRenderMonitor r0) {
        monitorTimeout$lambda$0(r0);
    }

    public static /* synthetic */ void lambda$7cxxEdF1xBLMUmYXl9OCU0LoqzA(VDPlayerSurfaceRenderMonitor r0) {
        sampleSurface$lambda$1(r0);
    }

    public static /* synthetic */ void lambda$DoTGoMzms_vaG2GUozxYCfDzdVQ(VDPlayerSurfaceRenderMonitor r0, int r1, int r2, a r3) {
        analyzePixelCopyResult$lambda$8(r0, r1, r2, r3);
    }

    public static /* synthetic */ void lambda$xgc_cu3an07EefvTal_Pd8kRpSk(VDPlayerSurfaceRenderMonitor r0, Bitmap r1, int r2, int r3) {
        requestPixelSample$lambda$5$lambda$4(r0, r1, r2, r3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder r1, int r2, int r3, int r4) {
        o.e((SurfaceHolder) ZeusTransformUtils.wrapperContextForParams(r1, SurfaceHolder.class, "com.obric.aiagent.plugin"), "holder");
    }

    public VDPlayerSurfaceRenderMonitor(SurfaceView r3, long r4, d.h.a.a<Boolean> r6, d.h.a.a<String> r7, d.h.a.a<x> r8) {
        d.h.a.a<Boolean> r9 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.a<String> r10 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.a<x> r11 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r3, "surfaceView");
        o.e(r9, "isSecureLayer");
        o.e(r10, "operatingPackage");
        o.e(r11, "onFinished");
        this.surfaceView = r3;
        this.firstOpenStartElapsedMs = r4;
        this.isSecureLayer = r9;
        this.operatingPackage = r10;
        this.onFinished = r11;
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.sampleThread = new HandlerThread(THREAD_NAME);
        this.lastPixelCopyResult = -1;
        this.firstBufferStatus = c.f26055a;
        this.firstBufferDurationMs = -1;
        this.initialBlackStatus = d.f26060a;
        this.monitorTimeout = new $$Lambda$VDPlayerSurfaceRenderMonitor$5PARpUA23x_ykDLrNZb6qvETOo0(this);
        this.sampleSurface = new $$Lambda$VDPlayerSurfaceRenderMonitor$7cxxEdF1xBLMUmYXl9OCU0LoqzA(this);
    }

    private static final void monitorTimeout$lambda$0(VDPlayerSurfaceRenderMonitor r2) {
        if (r2.isRunning() == true) goto L6;
        return;
    L6:
        if (r2.firstBufferStatus == c.f26055a) goto L8;
    L12:
        r2.finishAndReport(REASON_MONITOR_TIMEOUT);
        return;
    L8:
        if (r2.surfaceSeen == false) goto L10;
        c r0 = c.f26057c;
    L11:
        r2.firstBufferStatus = r0;
        goto L12
    L10:
        r0 = c.f26059e;
        goto L11
    }

    private static final void sampleSurface$lambda$1(VDPlayerSurfaceRenderMonitor r0) {
        r0.requestPixelSample();
    }

    public final void start() {
        if (this.started == false) goto L5;
        return;
    L5:
        if (this.finished == true) goto L13;
        this.started = true;
        this.sampleThread.start();
        this.sampleHandler = new Handler(this.sampleThread.getLooper());
        this.surfaceView.getHolder().addCallback((SurfaceHolder.Callback) ZeusTransformUtils.preCheckCast(this, SurfaceHolder.Callback.class, "com.obric.aiagent.plugin"));
        long r0 = n.a(5000 - elapsedSinceFirstOpen(), 0);
        this.mainHandler.postDelayed(this.monitorTimeout, r0);
        if (this.surfaceView.getHolder().getSurface().isValid() == false) goto L12;
        beginSurfaceSampling();
        return;
    L12:
        return;
    }

    public final void stop(String r3) {
        o.e(r3, "reason");
        if (isRunning() == true) goto L6;
        return;
    L6:
        if (this.firstBufferStatus != c.f26055a) goto L8;
        this.firstBufferStatus = c.f26058d;
    L8:
        finishAndReport(r3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder r3) {
        o.e((SurfaceHolder) ZeusTransformUtils.wrapperContextForParams(r3, SurfaceHolder.class, "com.obric.aiagent.plugin"), "holder");
        if (isRunning() == false) goto L6;
        beginSurfaceSampling();
        return;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder r3) {
        o.e((SurfaceHolder) ZeusTransformUtils.wrapperContextForParams(r3, SurfaceHolder.class, "com.obric.aiagent.plugin"), "holder");
        this.surfaceActive = false;
        this.surfaceGeneration++;
        clearBlackCandidate();
        this.mainHandler.removeCallbacks(this.sampleSurface);
    }

    private final void beginSurfaceSampling() {
        if (isRunning() == true) goto L5;
        return;
    L5:
        if (this.surfaceActive == true) goto L10;
        this.surfaceSeen = true;
        this.surfaceActive = true;
        this.surfaceGeneration++;
        clearBlackCandidate();
        this.mainHandler.post(this.sampleSurface);
        return;
    }

    private final void requestPixelSample() {
        Handler r4 = null;
        if (isCurrentSurface$default(this, 0, 1, null) == true) goto L6;
        return;
    L6:
        if (this.surfaceView.getHolder().getSurface().isValid() == true) goto L10;
        scheduleNextSample(FIRST_BUFFER_RETRY_MS);
        return;
    L10:
        if (secureLayer() == true) goto L12;
        d.n.a r2 = d.n.f38560a;     // Catch: Throwable -> L18
        VDPlayerSurfaceRenderMonitor r3 = (VDPlayerSurfaceRenderMonitor) ZeusTransformUtils.preCheckCast(this, VDPlayerSurfaceRenderMonitor.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        Object r5 = d.n.f(Bitmap.createBitmap(32, 32, Bitmap.Config.ARGB_8888));     // Catch: Throwable -> L18
    L21:
        if (d.n.c(r5) != null) goto L35;
        o.c(r5, "getOrElse(...)");
        final Bitmap r6 = (Bitmap) ZeusTransformUtils.preCheckCast(r5, Bitmap.class, "com.obric.aiagent.plugin");
        final int r7 = this.surfaceGeneration;
        d.n.a r8 = d.n.f38560a;     // Catch: Throwable -> L29
        final VDPlayerSurfaceRenderMonitor r0 = (VDPlayerSurfaceRenderMonitor) ZeusTransformUtils.preCheckCast(this, VDPlayerSurfaceRenderMonitor.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L29
        SurfaceView r1 = r0.surfaceView;     // Catch: Throwable -> L29
        PixelCopy.OnPixelCopyFinishedListener r9 = new $$Lambda$VDPlayerSurfaceRenderMonitor$xgc_cu3an07EefvTal_Pd8kRpSk(r0, r6, r7);     // Catch: Throwable -> L29
        Handler r10 = r0.sampleHandler;     // Catch: Throwable -> L29
        if (r10 != null) goto L26;
        o.c("sampleHandler");     // Catch: Throwable -> L29
    L27:
        PixelCopy.request(r1, r6, r9, r4);     // Catch: Throwable -> L29
        Object r11 = d.n.f(x.f38692a);     // Catch: Throwable -> L29
    L32:
        if (d.n.c(r11) == null) goto L41;
        recycleSafely(r6);
        handlePixelCopyFailure(r7, 1);
        return;
    L41:
        return;
    L26:
        r4 = r10;
    L29:
        th = move-exception;
        d.n.a r12 = d.n.f38560a;
        r11 = d.n.f(d.o.a(th));
        goto L32
    L35:
        handlePixelCopyFailure(this.surfaceGeneration, 1);
        return;
    L18:
        th = move-exception;
        d.n.a r13 = d.n.f38560a;
        r5 = d.n.f(d.o.a(th));
        goto L21
    L12:
        if (this.firstBufferStatus != c.f26055a) goto L14;
        this.firstBufferStatus = c.f;
    L14:
        finishAndReport(REASON_SECURE_LAYER);
    }

    private static final void requestPixelSample$lambda$5$lambda$4(VDPlayerSurfaceRenderMonitor r0, Bitmap r1, int r2, int r3) {
        r0.analyzePixelCopyResult(r1, r3, r2);
    }

    private final void analyzePixelCopyResult(Bitmap r5, final int r6, final int r7) {
        final a r1 = null;
        Object r2 = null;
        if (r6 == 0) goto L15;
    L13:
        recycleSafely(r5);
        this.mainHandler.post(new $$Lambda$VDPlayerSurfaceRenderMonitor$DoTGoMzms_vaG2GUozxYCfDzdVQ(this, r7, r6, r1));
        return;
    L15:
        d.n.a r3 = d.n.f38560a;     // Catch: Throwable -> L6
        Object r4 = d.n.f(((VDPlayerSurfaceRenderMonitor) ZeusTransformUtils.preCheckCast(this, VDPlayerSurfaceRenderMonitor.class, "com.obric.aiagent.plugin")).analyzeBlackSample(r5));     // Catch: Throwable -> L6
    L9:
        if (d.n.b(r4) == true) goto L12;
        r2 = r4;
    L12:
        r1 = (a) ZeusTransformUtils.preCheckCast(r2, a.class, "com.obric.aiagent.plugin");
    L6:
        th = move-exception;
        d.n.a r8 = d.n.f38560a;
        r4 = d.n.f(d.o.a(th));
        goto L9
    }

    private static final void analyzePixelCopyResult$lambda$8(VDPlayerSurfaceRenderMonitor r0, int r1, int r2, a r3) {
        r0.handlePixelCopyResult(r1, r2, r3);
    }

    private final void handlePixelCopyResult(int r1, int r2, a r3) {
        if (isCurrentSurface(r1) == true) goto L5;
        return;
    L5:
        this.lastPixelCopyResult = r2;
        if (r2 == 0) goto L10;
        scheduleNextSample(nextRetryDelay());
        return;
    L10:
        if (this.firstBufferStatus != c.f26055a) goto L12;
        this.firstBufferStatus = c.f26056b;
        this.firstBufferDurationMs = elapsedSinceFirstOpen();
    L12:
        if (r3 != null) goto L15;
        finishAndReport(REASON_PIXEL_ANALYSIS_FAILED);
        return;
    L15:
        handleBlackSample(r3);
    }

    private final void handlePixelCopyFailure(int r1, int r2) {
        if (isCurrentSurface(r1) == true) goto L5;
        return;
    L5:
        this.lastPixelCopyResult = r2;
        scheduleNextSample(nextRetryDelay());
    }

    private final void handleBlackSample(a r5) {
        this.diagnosticSample = r5;
        long r0 = SystemClock.elapsedRealtime();
        if (r5.a() == true) goto L10;
        this.initialBlackStatus = d.f26062c;
        if (this.blackSampleCount != 0) goto L7;
        String r6 = REASON_FIRST_BUFFER_NON_BLACK;
    L8:
        finishAndReport(r6);
        return;
    L7:
        r6 = REASON_TRANSIENT_BLACK;
        goto L8
    L10:
        int r7 = this.blackSampleCount;
        if (r7 != 0) goto L13;
        this.blackCandidateStartElapsedMs = r0;
    L13:
        int r8 = r7 + 1;
        this.blackSampleCount = r8;
        long r1 = r0 - this.blackCandidateStartElapsedMs;
        if (r8 >= 3) goto L16;
    L18:
        scheduleNextSample(BLACK_CONFIRM_SAMPLE_INTERVAL_MS);
        return;
    L16:
        if (r1 < 500) goto L18;
        this.initialBlackStatus = d.f26061b;
        finishAndReport(REASON_INITIAL_BLACK_CONFIRMED);
    }

    private final void finishAndReport(String r4) {
        if (this.finished == false) goto L5;
        return;
    L5:
        this.finished = true;
        this.started = false;
        this.surfaceActive = false;
        if (this.initialBlackStatus != d.f26060a) goto L8;
        this.initialBlackStatus = d.f26063d;
    L8:
        this.mainHandler.removeCallbacks(this.monitorTimeout);
        this.mainHandler.removeCallbacks(this.sampleSurface);
        this.surfaceView.getHolder().removeCallback((SurfaceHolder.Callback) ZeusTransformUtils.preCheckCast(this, SurfaceHolder.Callback.class, "com.obric.aiagent.plugin"));
        reportUnifiedEvent(r4);
        Handler r5 = this.sampleHandler;
        if (r5 != null) goto L11;
    L14:
        this.sampleThread.quitSafely();
        d.h.a.a<x> r3 = this.onFinished;
        d.n.a r6 = d.n.f38560a;     // Catch: Throwable -> L17
        Object r7 = d.n.f(r3.invoke());     // Catch: Throwable -> L17
    L19:
        Throwable r8 = d.n.c(r7);
        if (r8 == null) goto L25;
        Loog.INSTANCE.e(TAG, "Failed to notify monitor completion", r8);
        return;
    L25:
        return;
    L17:
        th = move-exception;
        d.n.a r9 = d.n.f38560a;
        r7 = d.n.f(d.o.a(th));
        goto L19
    L11:
        if (r5 != null) goto L13;
        o.c("sampleHandler");
        r5 = null;
    L13:
        r5.removeCallbacksAndMessages(null);
        goto L14
    }

    private final void reportUnifiedEvent(String r11) {
        d.n.a r1 = d.n.f38560a;     // Catch: Throwable -> L40
        VDPlayerSurfaceRenderMonitor r10 = (VDPlayerSurfaceRenderMonitor) ZeusTransformUtils.preCheckCast(this, VDPlayerSurfaceRenderMonitor.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L40
        a r2 = r10.diagnosticSample;     // Catch: Throwable -> L40
        JSONObject r4 = new JSONObject();     // Catch: Throwable -> L40
        r4.put(MonitorConstants.EXTRA_MONITOR_VERSION, 4);     // Catch: Throwable -> L40
        r4.put("finish_reason", r11);     // Catch: Throwable -> L40
        r4.put("monitor_duration_ms", r10.elapsedSinceFirstOpen());     // Catch: Throwable -> L40
        r4.put("first_buffer_status", r10.firstBufferStatus.a());     // Catch: Throwable -> L40
        r4.put("first_buffer_available_duration_ms", r10.firstBufferDurationMs);     // Catch: Throwable -> L40
        r4.put("initial_black_status", r10.initialBlackStatus.a());     // Catch: Throwable -> L40
        r4.put("is_initial_black", r10.initialBlackStatus.b());     // Catch: Throwable -> L40
        if (r2 == null) goto L6;
        int r3 = r2.b();     // Catch: Throwable -> L40
    L7:
        r4.put("mean_luma", r3);     // Catch: Throwable -> L40
        if (r2 == null) goto L10;
        double r5 = r2.c();     // Catch: Throwable -> L40
    L11:
        r4.put("dark_pixel_ratio", r5);     // Catch: Throwable -> L40
        r4.put("pixel_copy_result", r10.lastPixelCopyResult);     // Catch: Throwable -> L40
        r4.put("surface_width", r10.surfaceView.getWidth());     // Catch: Throwable -> L40
        r4.put("surface_height", r10.surfaceView.getHeight());     // Catch: Throwable -> L40
        int r6 = 1;
        if (r10.surfaceView.getHolder().getSurface().isValid() == false) goto L14;
        int r7 = 1;
    L15:
        r4.put("surface_valid", r7);     // Catch: Throwable -> L40
        if (r10.secureLayer() == true) goto L19;
        r6 = 0;
    L19:
        r4.put(REASON_SECURE_LAYER, r6);     // Catch: Throwable -> L40
        d.h.a.a<String> r12 = r10.operatingPackage;     // Catch: Throwable -> L40
        d.n.a r8 = d.n.f38560a;     // Catch: Throwable -> L22
        Object r13 = d.n.f(r12.invoke());     // Catch: Throwable -> L22
    L25:
        if (d.n.b(r13) == false) goto L27;
        r13 = "";
    L27:
        r4.put("operating_package", r13);     // Catch: Throwable -> L40
        r4.put("os_sdk", Build.VERSION.SDK_INT);     // Catch: Throwable -> L40
        IAgentSessionManager.a r14 = new com.obric.autoaction.vdplayer.b.b.a().a();     // Catch: Throwable -> L40
        if (r14 == null) goto L38;
        ak<com.obric.autogui.vdplayer.api.a.b> r15 = r14.b();     // Catch: Throwable -> L40
        if (r15 == null) goto L38;
        com.obric.autogui.vdplayer.api.a.b r16 = (com.obric.autogui.vdplayer.api.a.b) ZeusTransformUtils.preCheckCast(r15.c(), com.obric.autogui.vdplayer.api.a.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L40
        if (r16 == null) goto L38;
        IAutoActionAgentEventListener.SessionInfo r17 = r16.a();     // Catch: Throwable -> L40
        if (r17 == null) goto L38;
        IPlatformTools r18 = (IPlatformTools) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IPlatformTools.class), IPlatformTools.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L40
        if (r18 == null) goto L38;
        r18.putSessionInfo(r4, r17);     // Catch: Throwable -> L40
    L38:
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default((IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin"), EVENT_NAME, r4, false, false, null, 16, null);     // Catch: Throwable -> L40
        Object r19 = d.n.f(x.f38692a);     // Catch: Throwable -> L40
    L42:
        Throwable r110 = d.n.c(r19);
        if (r110 == null) goto L50;
        Loog.INSTANCE.e(TAG, "Failed to report first-open render event", r110);
        return;
    L50:
        return;
    L22:
        th = move-exception;
        d.n.a r9 = d.n.f38560a;     // Catch: Throwable -> L40
        r13 = d.n.f(d.o.a(th));     // Catch: Throwable -> L40
        goto L25
    L14:
        r7 = 0;
        goto L15
    L10:
        r5 = UNAVAILABLE_RATE;
        goto L11
    L6:
        r3 = -1;
    L40:
        th = move-exception;
        d.n.a r111 = d.n.f38560a;
        r19 = d.n.f(d.o.a(th));
        goto L42
    }

    private final void scheduleNextSample(long r4) {
        if (isCurrentSurface$default(this, 0, 1, null) == false) goto L6;
        this.mainHandler.postDelayed(this.sampleSurface, r4);
        return;
    }

    private final long nextRetryDelay() {
        if (this.firstBufferStatus != c.f26055a) goto L5;
        return FIRST_BUFFER_RETRY_MS;
    L5:
        return BLACK_CONFIRM_SAMPLE_INTERVAL_MS;
    }

    private final void clearBlackCandidate() {
        this.blackCandidateStartElapsedMs = 0;
        this.blackSampleCount = 0;
    }

    private final boolean isRunning() {
        if (this.started == true) goto L5;
    L7:
        return false;
    L5:
        if (this.finished == true) goto L7;
        return true;
    }

    static /* synthetic */ boolean isCurrentSurface$default(VDPlayerSurfaceRenderMonitor r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.surfaceGeneration;
    L6:
        return r0.isCurrentSurface(r1);
    }

    private final boolean isCurrentSurface(int r2) {
        if (isRunning() == true) goto L5;
    L9:
        return false;
    L5:
        if (this.surfaceActive == false) goto L9;
        if (r2 != this.surfaceGeneration) goto L9;
        return true;
    }

    private final long elapsedSinceFirstOpen() {
        return n.a(SystemClock.elapsedRealtime() - this.firstOpenStartElapsedMs, 0);
    }

    private final boolean secureLayer() {
        d.h.a.a<Boolean> r2 = this.isSecureLayer;
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L5
        Object r3 = d.n.f(r2.invoke());     // Catch: Throwable -> L5
    L8:
        if (d.n.b(r3) == false) goto L11;
        r3 = false;
    L11:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
    L5:
        th = move-exception;
        d.n.a r1 = d.n.f38560a;
        r3 = d.n.f(d.o.a(th));
        goto L8
    }

    private final a analyzeBlackSample(Bitmap r10) {
        int[] r8 = new int[1024];
        r10.getPixels(r8, 0, 32, 0, 0, 32, 32);
        boolean r11 = false;
        long r0 = 0;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= 1024) goto L8;
        int r4 = r8[r2];
        int r5 = (((((r4 >> 16) & 255) * 77) + (((r4 >> 8) & 255) * 150)) + ((r4 & 255) * 29)) >> 8;
        r0 = r0 + ((long) r5);
        if (r5 > 24) goto L7;
        r3 = r3 + 1;
    L7:
        r2 = r2 + 1;
        goto L3
    L8:
        int r1 = (int) (r0 / ((long) 1024));
        double r6 = ((double) r3) / ((double) 1024);
        if (r1 > 16) goto L14;
        if (r6 < BLACK_DARK_PIXEL_RATIO_THRESHOLD) goto L14;
        r11 = true;
    L14:
        return new a(r11, r1, r6);
    }

    private final void recycleSafely(Bitmap r1) {
        if (r1.isRecycled() == true) goto L6;
        r1.recycle();
        return;
    }
}
