package com.bytedance.apm.trace.fps;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.os.SystemClock;
import android.view.Choreographer;
import android.view.View;
import android.view.WindowManager;
import com.bytedance.apm.block.h;
import com.bytedance.keva.KevaImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class FpsTracer {
    private static final String TAG = "FpsTracer";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f4926c = false;
    private static final Long q = null;
    private static final Long r = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f4927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f4928b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private c f4929d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private b f4930e;
    private RealFpsTracer f;
    private d g;
    private Choreographer.FrameCallback h;
    private LinkedList<Integer> i;
    private HashMap<String, String> j;
    private float k;
    private float l;
    private float m;
    private float n;
    private FPSRecordView o;
    private WindowManager p;
    private boolean s;
    private final JSONObject t;
    private long u;
    private long v;
    private int w;

    private class FPSRecordView extends View {
        private int mCounter;
        private long mStartTime;
        final /* synthetic */ FpsTracer this$0;

        static /* synthetic */ long access$002(FPSRecordView r0, long r1) {
            r0.mStartTime = r1;
            return r1;
        }

        static /* synthetic */ int access$302(FPSRecordView r0, int r1) {
            r0.mCounter = r1;
            return r1;
        }

        public FPSRecordView(FpsTracer r3, Context r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r5);
            this.mStartTime = -1;
            this.mCounter = 0;
        }

        @Override // android.view.View
        public void onDraw(Canvas r5) {
            if (this.mStartTime != (-1)) goto L5;
            this.mStartTime = SystemClock.elapsedRealtime();
            this.mCounter = 0;
        L7:
            if (FpsTracer.d(this.this$0) == null) goto L9;
            FpsTracer.d(this.this$0).a(SystemClock.elapsedRealtime());
        L9:
            long r0 = SystemClock.elapsedRealtime() - this.mStartTime;
            if (r0 <= FpsTracer.e().longValue()) goto L16;
            double r2 = (((double) this.mCounter) / r0) * FpsTracer.f().longValue();
            if (FpsTracer.n(this.this$0) == null) goto L14;
            FpsTracer.n(this.this$0).a(r2);
        L14:
            com.bytedance.apm.trace.fps.a.a().a(FpsTracer.o(this.this$0), FpsTracer.h(this.this$0), (float) r2);
            FpsTracer.p(this.this$0);
            return;
        L16:
            return;
        L5:
            this.mCounter++;
            goto L7
        }
    }

    public interface a {
        void a(long r1, int r3);
    }

    public interface b {
        void a(JSONObject r1);
    }

    public interface c {
        void a(double r1);
    }

    public interface d {
        void a(long r1);
    }

    public interface e {
        void a(JSONObject r1, int r2);
    }

    static /* synthetic */ int a(int r0, float r1) {
        return b(r0, r1);
    }

    static /* synthetic */ long a(FpsTracer r0, long r1) {
        r0.u = r1;
        return r1;
    }

    static /* synthetic */ void a(FpsTracer r0, long r1, long r3) {
        r0.a(r1, r3);
    }

    static /* synthetic */ boolean a(FpsTracer r0) {
        return r0.f4928b;
    }

    static /* synthetic */ long b(FpsTracer r0, long r1) {
        r0.v = r1;
        return r1;
    }

    static /* synthetic */ FPSRecordView b(FpsTracer r0) {
        return r0.o;
    }

    static /* synthetic */ long c(FpsTracer r2) {
        return r2.u;
    }

    static /* synthetic */ d d(FpsTracer r0) {
        return r0.g;
    }

    static /* synthetic */ int e(FpsTracer r1) {
        int r0 = r1.w + 1;
        r1.w = r0;
        return r0;
    }

    static /* synthetic */ Long e() {
        return q;
    }

    static /* synthetic */ long f(FpsTracer r2) {
        return r2.v;
    }

    static /* synthetic */ Long f() {
        return r;
    }

    static /* synthetic */ b g(FpsTracer r0) {
        return r0.f4930e;
    }

    static /* synthetic */ String h(FpsTracer r0) {
        return r0.f4927a;
    }

    static /* synthetic */ float i(FpsTracer r0) {
        return r0.k;
    }

    static /* synthetic */ float j(FpsTracer r0) {
        return r0.l;
    }

    static /* synthetic */ float k(FpsTracer r0) {
        return r0.m;
    }

    static /* synthetic */ float l(FpsTracer r0) {
        return r0.n;
    }

    static /* synthetic */ JSONObject m(FpsTracer r0) {
        return r0.t;
    }

    static /* synthetic */ c n(FpsTracer r0) {
        return r0.f4929d;
    }

    static /* synthetic */ HashMap o(FpsTracer r0) {
        return r0.j;
    }

    static /* synthetic */ void p(FpsTracer r0) {
        r0.m();
    }

    static {
        q = 200L;
        r = 1000L;
    }

    public FpsTracer(String r2) {
        this(r2, true);
    }

    public FpsTracer(String r2, boolean r3) {
        this(r2, r3, null);
    }

    public FpsTracer(String r4, boolean r5, JSONObject r6) {
        this.f4928b = false;
        this.g = null;
        this.j = new HashMap();
        this.k = 0.0f;
        this.l = 0.0f;
        this.m = 0.0f;
        this.n = 0.0f;
        this.o = null;
        this.p = null;
        this.u = -1;
        this.v = -1;
        this.w = 0;
        this.t = r6;
        if (f4926c == false) goto L6;
        this.f = new RealFpsTracer(r4, r5, r6);
        return;
    L6:
        this.f4927a = r4;
        this.s = r5;
        this.i = new LinkedList();
        if (Build.VERSION.SDK_INT >= 16) goto L10;
        this.p = (WindowManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("window"), WindowManager.class, "com.obric.aiagent.plugin");
        this.o = new FPSRecordView(this, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        return;
    }

    public void a(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        RealFpsTracer r0 = this.f;
        if (r0 == null) goto L5;
        r0.a(r4);
    L5:
        this.f4930e = r4;
    }

    public void a(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
        RealFpsTracer r0 = this.f;
        if (r0 == null) goto L5;
        r0.a(r4);
    L5:
        this.f4929d = r4;
    }

    public static void a(boolean r0) {
        f4926c = r0;
    }

    public void a() {
        RealFpsTracer r0 = this.f;
        if (r0 == null) goto L7;
        r0.a();
        return;
    L7:
        if (this.f4928b == false) goto L10;
        return;
    L10:
        if (this.s == false) goto L12;
    L14:
        g();
        if (Build.VERSION.SDK_INT >= 16) goto L17;
        l();
    L18:
        this.f4928b = true;
        return;
    L17:
        j();
        a(this.f4927a);
        goto L18
    L12:
        if (c() == true) goto L14;
    }

    private void g() {
        this.k = 0.0f;
        this.l = 0.0f;
        this.m = 0.0f;
        this.n = 0.0f;
    }

    public synchronized void b() {
        monitor-enter(this);
        RealFpsTracer r0 = this.f;     // Catch: Throwable -> L16
        if (r0 == null) goto L10;
        r0.b();     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L10:
        if (Build.VERSION.SDK_INT >= 16) goto L13;
        monitor-exit(this);
        return;
    L13:
        k();     // Catch: Throwable -> L16
        b(this.f4927a);     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    private boolean h() {
        return com.bytedance.apm.m.c.a("fps", this.f4927a);
    }

    private boolean i() {
        return com.bytedance.apm.m.c.a("fps_drop", this.f4927a);
    }

    public boolean c() {
        if (com.bytedance.apm.c.a() == true) goto L5;
    L9:
        return false;
    L5:
        if (i() == false) goto L7;
    L8:
        return true;
    L7:
        if (h() == false) goto L9;
        goto L8
    }

    private void j() {
        monitor-enter(this);
        this.i.clear();     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        n();
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void k() {
        if (this.f4928b == true) goto L5;
        return;
    L5:
        o();
        if (this.h == null) goto L8;
        Choreographer.getInstance().removeFrameCallback(this.h);
    L8:
        p();
        this.f4928b = false;
    }

    private void l() {
        FPSRecordView.access$002(this.o, -1);
        WindowManager.LayoutParams r0 = new WindowManager.LayoutParams(-2, -2, 2005, 0, -3);
        r0.gravity = 51;
        r0.flags = 24;
        r0.height = 1;
        r0.width = 1;
        this.p.removeView(this.o);     // Catch: Exception -> L6
    L4:
        this.p.addView(this.o, r0);
        this.o.postDelayed(new AnonymousClass1(this), 10);
    }

    private void m() {
        if (this.f4928b == true) goto L10;
        return;
    L10:
        this.p.removeView(this.o);     // Catch: Exception -> L9
        FPSRecordView.access$002(this.o, -1);     // Catch: Exception -> L9
        FPSRecordView.access$302(this.o, 0);     // Catch: Exception -> L9
    L7:
        this.f4928b = false;
    }

    private void n() {
        this.u = -1;
        this.v = -1;
        this.w = 0;
        this.h = new AnonymousClass3(this);
        Choreographer.getInstance().postFrameCallback(this.h);     // Catch: Exception -> L5
        return;
    L5:
        this.f4928b = false;
        this.u = -1;
        this.v = -1;
        this.w = 0;
        this.h = null;
    }

    private void o() {
        long r0 = this.v - this.u;
        if (r0 <= 0) goto L12;
        int r2 = this.w;
        if (r2 <= 1) goto L13;
        long r3 = (((((long) (r2 - 1)) * 1000) * 1000) * 1000) / r0;
        c r1 = this.f4929d;
        if (r1 == null) goto L10;
        r1.a(r3);
    L10:
        com.bytedance.apm.trace.fps.a.a().a(this.j, this.f4927a, r3);
        return;
    L13:
        return;
    }

    private void a(long r5, long r7) {
        if (this.v > 0) goto L5;
        return;
    L5:
        long r8 = r7 - r5;
        if ((r8 / 1000000) > 0) goto L8;
        return;
    L8:
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L10:
        if (this.i.size() <= 20000) goto L12;
        this.i.poll();     // Catch: Throwable -> L15
    L12:
        this.i.add(Integer.valueOf(((int) r8) / KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD));     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
    }

    private void p() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.i.isEmpty() == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L7:
        final LinkedList<Integer> r0 = this.i;     // Catch: Throwable -> L11
        this.i = new LinkedList();     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        com.bytedance.apm.thread.b.a().a(new AnonymousClass2(this, r0));
    }

    public static String d() {
        return h.a();
    }

    public static void a(String r0) {
        h.a(r0);
    }

    public static void b(String r0) {
        h.b(r0);
    }

    private static int b(int r1, float r2) {
        int r3 = (int) (r2 * 100.0f);
        return ((r1 + (r3 - 1)) / r3) - 1;
    }
}
