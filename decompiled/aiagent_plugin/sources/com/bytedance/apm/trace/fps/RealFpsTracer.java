package com.bytedance.apm.trace.fps;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.os.SystemClock;
import android.view.View;
import android.view.WindowManager;
import com.bytedance.apm.block.trace.b;
import com.bytedance.apm.block.trace.f;
import com.bytedance.apm.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class RealFpsTracer {
    private static final String TAG = "FpsTracer";
    private static final Long s = null;
    private static final Long t = null;
    private static b u;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f4934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f4935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b.a f4936c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private FpsTracer.c f4937d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private FpsTracer.d f4938e;
    private volatile FpsTracer.b f;
    private volatile FpsTracer.e g;
    private volatile FpsTracer.a h;
    private LinkedList<Integer> i;
    private HashMap<String, String> j;
    private float k;
    private float l;
    private float m;
    private float n;
    private long o;
    private long p;
    private FpsRecordView q;
    private WindowManager r;
    private final boolean v;
    private final JSONObject w;

    private class FpsRecordView extends View {
        private int mCounter;
        private long mStartTime;
        final /* synthetic */ RealFpsTracer this$0;

        static /* synthetic */ long access$002(FpsRecordView r0, long r1) {
            r0.mStartTime = r1;
            return r1;
        }

        static /* synthetic */ int access$302(FpsRecordView r0, int r1) {
            r0.mCounter = r1;
            return r1;
        }

        public FpsRecordView(RealFpsTracer r3, Context r4) {
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
            if (RealFpsTracer.l(this.this$0) == null) goto L9;
            RealFpsTracer.l(this.this$0).a(SystemClock.elapsedRealtime());
        L9:
            long r0 = SystemClock.elapsedRealtime() - this.mStartTime;
            if (r0 <= RealFpsTracer.d().longValue()) goto L16;
            double r2 = (((double) this.mCounter) / r0) * RealFpsTracer.e().longValue();
            if (RealFpsTracer.m(this.this$0) == null) goto L14;
            RealFpsTracer.m(this.this$0).a(r2);
        L14:
            a.a().a(RealFpsTracer.n(this.this$0), RealFpsTracer.f(this.this$0), (float) r2);
            RealFpsTracer.o(this.this$0);
            return;
        L16:
            return;
        L5:
            this.mCounter++;
            goto L7
        }
    }

    static /* synthetic */ int a(int r0, float r1) {
        return b(r0, r1);
    }

    static /* synthetic */ void a(RealFpsTracer r2, Map r3, float r4) {
        r2.a((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin"), r4);
    }

    static /* synthetic */ boolean a(RealFpsTracer r0) {
        return r0.f4935b;
    }

    static /* synthetic */ FpsRecordView b(RealFpsTracer r0) {
        return r0.q;
    }

    static /* synthetic */ FpsTracer.b c(RealFpsTracer r0) {
        return r0.f;
    }

    static /* synthetic */ FpsTracer.a d(RealFpsTracer r0) {
        return r0.h;
    }

    static /* synthetic */ Long d() {
        return s;
    }

    static /* synthetic */ FpsTracer.e e(RealFpsTracer r0) {
        return r0.g;
    }

    static /* synthetic */ Long e() {
        return t;
    }

    static /* synthetic */ String f(RealFpsTracer r0) {
        return r0.f4934a;
    }

    static /* synthetic */ float g(RealFpsTracer r0) {
        return r0.k;
    }

    static /* synthetic */ float h(RealFpsTracer r0) {
        return r0.l;
    }

    static /* synthetic */ float i(RealFpsTracer r0) {
        return r0.m;
    }

    static /* synthetic */ float j(RealFpsTracer r0) {
        return r0.n;
    }

    static /* synthetic */ JSONObject k(RealFpsTracer r0) {
        return r0.w;
    }

    static /* synthetic */ FpsTracer.d l(RealFpsTracer r0) {
        return r0.f4938e;
    }

    static /* synthetic */ FpsTracer.c m(RealFpsTracer r0) {
        return r0.f4937d;
    }

    static /* synthetic */ HashMap n(RealFpsTracer r0) {
        return r0.j;
    }

    static /* synthetic */ void o(RealFpsTracer r0) {
        r0.l();
    }

    static {
        s = 200L;
        t = 1000L;
    }

    public RealFpsTracer(String r4, boolean r5, JSONObject r6) {
        this.f4935b = false;
        this.f4936c = new b.a();
        this.f4938e = null;
        this.j = new HashMap();
        this.k = 0.0f;
        this.l = 0.0f;
        this.m = 0.0f;
        this.n = 0.0f;
        this.o = 0;
        this.p = 0;
        this.q = null;
        this.r = null;
        this.f4934a = r4;
        this.v = r5;
        this.w = r6;
        this.i = new LinkedList();
        if (Build.VERSION.SDK_INT >= 16) goto L6;
        this.r = (WindowManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("window"), WindowManager.class, "com.obric.aiagent.plugin");
        this.q = new FpsRecordView(this, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        return;
    }

    public void a(FpsTracer.b r3) {
        this.f = (FpsTracer.b) ZeusTransformUtils.wrapperContextForParams(r3, FpsTracer.b.class, "com.obric.aiagent.plugin");
    }

    public static void a(b r0) {
        u = r0;
    }

    public void a(FpsTracer.c r3) {
        this.f4937d = (FpsTracer.c) ZeusTransformUtils.wrapperContextForParams(r3, FpsTracer.c.class, "com.obric.aiagent.plugin");
    }

    public void a() {
        if (this.f4935b == false) goto L6;
        return;
    L6:
        if (this.v == false) goto L8;
    L10:
        f();
        if (Build.VERSION.SDK_INT >= 16) goto L13;
        k();
    L14:
        this.o = SystemClock.uptimeMillis();
        this.f4935b = true;
        return;
    L13:
        i();
        FpsTracer.a(this.f4934a);
        goto L14
    L8:
        if (c() == true) goto L10;
    }

    private void f() {
        this.k = 0.0f;
        this.l = 0.0f;
        this.m = 0.0f;
        this.n = 0.0f;
        this.o = 0;
    }

    public synchronized void b() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (Build.VERSION.SDK_INT >= 16) goto L8;
        monitor-exit(this);
        return;
    L8:
        j();     // Catch: Throwable -> L11
        FpsTracer.b(this.f4934a);     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    private boolean g() {
        return com.bytedance.apm.m.c.a("fps", this.f4934a);
    }

    private boolean h() {
        return com.bytedance.apm.m.c.a("fps_drop", this.f4934a);
    }

    public boolean c() {
        if (f.a().j() == false) goto L13;
        if (c.a() == true) goto L7;
        return false;
    L7:
        if (h() == true) goto L11;
        if (g() == true) goto L11;
        return false;
    L11:
        return true;
    L13:
        if (c.a() == true) goto L19;
        if (h() == true) goto L19;
        if (g() == true) goto L19;
        return false;
    L19:
        return true;
    }

    private void i() {
        if (u == null) goto L6;
        this.f4935b = true;
        u.a(this);
        return;
    }

    private void j() {
        b r0 = u;
        if (r0 == null) goto L9;
        r0.b(this);
        if (this.f4935b == true) goto L7;
        return;
    L7:
        a(this.o, SystemClock.uptimeMillis());
        this.f4935b = false;
        return;
    }

    private void k() {
        FpsRecordView.access$002(this.q, -1);
        WindowManager.LayoutParams r0 = new WindowManager.LayoutParams(-2, -2, 2005, 0, -3);
        r0.gravity = 51;
        r0.flags = 24;
        r0.height = 1;
        r0.width = 1;
        this.r.removeView(this.q);     // Catch: Exception -> L6
    L4:
        this.r.addView(this.q, r0);
        this.q.postDelayed(new AnonymousClass1(this), 10);
    }

    private void l() {
        if (this.f4935b == true) goto L10;
        return;
    L10:
        this.r.removeView(this.q);     // Catch: Exception -> L9
        FpsRecordView.access$002(this.q, -1);     // Catch: Exception -> L9
        FpsRecordView.access$302(this.q, 0);     // Catch: Exception -> L9
    L7:
        this.f4935b = false;
    }

    private void a(Map<String, String> r4, float r5) {
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
        FpsTracer.c r0 = this.f4937d;
        if (r0 == null) goto L5;
        r0.a(r5);
    L5:
        a.a().a(r6, this.f4934a, r5);
    }

    public void a(long r3) {
        if (r3 >= 0) goto L5;
        return;
    L5:
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (this.i.size() <= 20000) goto L9;
        this.i.poll();     // Catch: Throwable -> L12
    L9:
        this.i.add(Integer.valueOf(((int) r3) * 100));     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
    }

    private void a(long r2, long r4) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.i.isEmpty() == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L7:
        int r3 = (this.p > 0 ? 1 : (this.p == 0 ? 0 : -1));
        this.p = 0;     // Catch: Throwable -> L11
        final LinkedList<Integer> r5 = this.i;     // Catch: Throwable -> L11
        this.i = new LinkedList();     // Catch: Throwable -> L11
        final b.a r6 = this.f4936c;     // Catch: Throwable -> L11
        this.f4936c = new b.a();     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        final HashMap r7 = new HashMap();
        r7.putAll(this.j);
        com.bytedance.apm.thread.b.a().a(new AnonymousClass2(this, r5, r7, r6));
    }

    private static int b(int r1, float r2) {
        return r1 / ((int) (r2 * 100.0f));
    }

    public void a(long r1, boolean r3) {
        this.f4936c.a(r1, r3);
    }
}
