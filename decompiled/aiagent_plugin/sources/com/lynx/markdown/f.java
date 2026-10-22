package com.lynx.markdown;

import android.content.Context;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import com.ttreader.tttext.lite.TTTextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: MarkdownLayout.java */
/* JADX INFO: loaded from: classes2.dex */
public class f {
    private static final String TAG = "MarkdownLayout";
    private int A;
    private int B;
    private float C;
    private float D;
    private Looper E;
    private Handler F;
    private float G;
    private Context H;
    private boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private a f13885J;
    private MarkdownView K;
    private com.lynx.markdown.b L;
    private b M;
    private boolean N;
    private boolean O;
    private long P;
    private int Q;
    private float[] R;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f13886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f13887b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f13888c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f13889d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f13890e;
    private boolean f;
    private boolean g;
    private HashMap h;
    private MarkdownParser i;
    private MarkdownDrawableCallback j;
    private HashMap<String, g> k;
    private float l;
    private int m;
    private int n;
    private int o;
    private boolean p;
    private int q;
    private int r;
    private h s;
    private int t;
    private float u;
    private float v;
    private float w;
    private float x;
    private float y;
    private float z;

    /* JADX INFO: compiled from: MarkdownLayout.java */
    public interface a {
        void onAnimationStep(f r1, int r2, int r3, int r4);

        void onDrawEnd(f r1);

        void onDrawStart(f r1);

        void onLink(f r1, String r2, String r3);

        void onOverflow(f r1, String r2);

        void onSelectionChange(f r1, int r2, int r3, boolean r4);
    }

    /* JADX INFO: compiled from: MarkdownLayout.java */
    public interface b {
        void requestNextMeasure();
    }

    /* JADX INFO: compiled from: MarkdownLayout.java */
    public static final enum c extends Enum<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f13891a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f13892b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f13893c = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ c[] f13894e = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f13895d;

        public static c valueOf(String r2) {
            return (c) ZeusTransformUtils.preCheckCast(Enum.valueOf(c.class, r2), c.class, "com.obric.aiagent.plugin");
        }

        public static c[] values() {
            return (c[]) ZeusTransformUtils.preCheckCast(f13894e.clone(), c[].class, "com.obric.aiagent.plugin");
        }

        static {
            c r0 = new c("UNDEFINED", 0, 0);
            f13891a = r0;
            c r1 = new c("EXACTLY", 1, 1);
            f13892b = r1;
            c r3 = new c("AT_MOST", 2, 2);
            f13893c = r3;
            f13894e = new c[]{r0, r1, r3};
        }

        private c(String r1, int r2, int r3) {
            super(r1, r2);
            this.f13895d = r3;
        }

        public static c a(int r1) {
            int r2 = View.MeasureSpec.getMode(r1);
            if (r2 == Integer.MIN_VALUE) goto L11;
            if (r2 == 1073741824) goto L9;
            return f13891a;
        L9:
            return f13892b;
        L11:
            return f13893c;
        }
    }

    /* JADX INFO: renamed from: lambda$-P9dYOkPXAA-EgH7IxerU6YxoPc, reason: not valid java name */
    public static /* synthetic */ void m51lambda$P9dYOkPXAAEgH7IxerU6YxoPc(f r0) {
        r0.j();
    }

    /* JADX INFO: renamed from: lambda$D9nAQ7FTuCW-hptceACY1pTmhHY, reason: not valid java name */
    public static /* synthetic */ void m52lambda$D9nAQ7FTuCWhptceACY1pTmhHY(f r0) {
        r0.m();
    }

    public static /* synthetic */ void lambda$HHK5HabGQmCqjQMdaMZ5Lirom8Q(f r0) {
        r0.l();
    }

    public static /* synthetic */ void lambda$lCr6hCOqPadHvAaqFgqo3uG1HWg(f r0) {
        r0.k();
    }

    public f(Context r8, com.lynx.markdown.b r9, a r10, b r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        com.lynx.markdown.b r13 = (com.lynx.markdown.b) ZeusTransformUtils.wrapperContextForParams(r9, com.lynx.markdown.b.class, "com.obric.aiagent.plugin");
        a r14 = (a) ZeusTransformUtils.wrapperContextForParams(r10, a.class, "com.obric.aiagent.plugin");
        b r15 = (b) ZeusTransformUtils.wrapperContextForParams(r11, b.class, "com.obric.aiagent.plugin");
        this.f = true;
        this.g = false;
        this.l = 1.0f;
        this.m = 0;
        this.n = 0;
        this.o = 0;
        this.p = false;
        this.q = 0;
        this.r = 0;
        this.t = -1;
        this.u = 0.0f;
        this.v = 0.0f;
        this.w = 0.0f;
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = Float.MAX_VALUE;
        this.A = 0;
        this.B = Integer.MAX_VALUE;
        this.C = 0.0f;
        this.D = 0.0f;
        this.E = null;
        this.F = null;
        this.G = 0.0f;
        this.I = false;
        this.f13886a = c.f13891a;
        this.f13887b = c.f13891a;
        this.N = false;
        this.O = false;
        this.P = 0;
        this.Q = 0;
        this.R = null;
        this.f13888c = true;
        this.H = ZeusTransformUtils.wrapperContext(r12, "com.obric.aiagent.plugin");
        this.L = r13;
        this.f13885J = r14;
        this.M = r15;
        Looper r16 = Looper.myLooper();
        this.E = r16;
        if (r16 != null) goto L5;
        this.E = Looper.getMainLooper();
    L5:
        this.F = new Handler(this.E);
    }

    private void g() {
        if (this.I == true) goto L8;
        b r1 = this.M;
        if (r1 == null) goto L9;
        r1.requestNextMeasure();
        return;
    L9:
        return;
    }

    private String b(HashMap<String, Object> r2) {
        if (r2 == null) goto L9;
        Object r1 = r2.get("typewriterCursor");
        if (ZeusTransformUtils.instanceOf(r1, HashMap.class) == false) goto L11;
        Object r3 = ((HashMap) ZeusTransformUtils.preCheckCast(r1, HashMap.class, "com.obric.aiagent.plugin")).get("customCursor");
        if (ZeusTransformUtils.instanceOf(r3, String.class) == true) goto L8;
        return "";
    L8:
        return (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin");
    L11:
        return "";
    L9:
        return "";
    }

    private float c(HashMap r3) {
        if (r3 == null) goto L8;
        HashMap r2 = com.lynx.markdown.b.a.a(r3, "normalText", null);
        if (r2 == null) goto L8;
        return TTTextUtils.Dp2Px((float) com.lynx.markdown.b.a.a(r2, "fontSize", 17.0d));
    L8:
        return TTTextUtils.Dp2Px(17.0f);
    }

    public RectF a(float r4, c r5, float r6, c r7) {
        Markdown.ensureInitialized();
        h();
        if (this.i != null) goto L6;
        this.i = new MarkdownParser(this.L, this);
        MarkdownDrawableCallback r0 = new MarkdownDrawableCallback();
        this.j = r0;
        r0.setNode(this);
    L6:
        if (r5 != c.f13891a) goto L9;
        r4 = Float.MAX_VALUE;
    L9:
        if (r6 > 0.0f) goto L11;
        r6 = Float.MAX_VALUE;
    L11:
        float r8 = Float.min(TTTextUtils.Dp2Px(this.z), r6);
        if (r5 != c.f13892b) goto L14;
        float r9 = r4;
    L16:
        if (r7 != c.f13892b) goto L18;
        float r10 = r8;
    L20:
        if (this.f13889d == null) goto L41;
        if (this.f13888c == false) goto L24;
    L27:
        this.u = r4;
        this.v = r8;
        HashMap r11 = this.h;
        if (r11 == null) goto L30;
        this.i.setStyle(r11);
        this.f13890e = b(this.h);
    L31:
        this.G = c(this.h);
        this.i.parseMarkdown(this.f13889d, this.A, this.B, r4);
        float[] r12 = this.i.layoutMarkdown(r4, r8, this.t);
        float r13 = r12[0];
        float r14 = r12[1];
        this.w = r13;
        this.x = r14;
        if (this.n == 1) goto L34;
    L36:
        this.r = this.f13889d.length();
        h r15 = new h();
        this.s = r15;
        r15.f13900a = this.i;
        this.s.f13903d = this.j;
        this.s.f13901b = this.n;
        this.s.f13902c = this.o;
        this.s.f = this.f;
        this.s.g = this.k;
        this.s.f13904e = new WeakReference(this);
        if (this.f13888c == false) goto L39;
        this.O = false;
        this.f13888c = false;
        this.P = 0;
    L39:
        r10 = r14;
        r9 = r13;
        goto L41
    L34:
        if (this.l < 0.0f) goto L36;
        this.q = this.i.getMaxTypewriterStep();
        goto L36
    L30:
        this.i.setStyle(null);
        goto L31
    L24:
        if (Float.compare(this.w, r4) != 0) goto L27;
        if (Float.compare(this.x, r8) != 0) goto L27;
    L41:
        if (this.s == null) goto L44;
        i();
        r9 = this.w;
        r10 = this.y;
        this.s.h = (int) r9;
        this.s.i = (int) r10;
        com.lynx.markdown.b.b.a(new $$Lambda$f$D9nAQ7FTuCWhptceACY1pTmhHY(this));
    L44:
        return new RectF(0.0f, 0.0f, r9, r10);
    L18:
        r10 = 0.0f;
        goto L20
    L14:
        r9 = 0.0f;
        goto L16
    }

    private /* synthetic */ void m() {
        MarkdownView r0 = this.K;
        if (r0 == null) goto L6;
        r0.setLayoutBundle(this.s);
        return;
    }

    public RectF a(int r3, int r4) {
        int r0 = View.MeasureSpec.getSize(r3);
        return a(r0, c.a(View.MeasureSpec.getMode(r3)), View.MeasureSpec.getSize(r4), c.a(View.MeasureSpec.getMode(r4)));
    }

    private void h() {
        DisplayMetrics r1 = ZeusTransformUtils.getResources(this.H, "com.obric.aiagent.plugin").getDisplayMetrics();
        if (r1 == null) goto L6;
        TTTextUtils.SetDpi(r1.densityDpi);
        return;
    }

    public void a(MarkdownView r1) {
        this.K = r1;
    }

    public void a() {
        a(new $$Lambda$f$HHK5HabGQmCqjQMdaMZ5Lirom8Q(this));
    }

    private /* synthetic */ void l() {
        this.f13888c = true;
        g();
    }

    private void i() {
        if (this.N == true) goto L8;
        this.N = true;
        a r0 = this.f13885J;
        if (r0 == null) goto L8;
        r0.onDrawStart(this);
    L8:
        if (this.n == 1) goto L10;
    L55:
        this.y = this.x;
        boolean r2 = true;
    L56:
        if (r2 == false) goto L71;
        float r1 = this.x;
        if (r1 <= this.y) goto L61;
        this.y = Float.min(r1, this.z);
    L61:
        if (this.O == false) goto L63;
        return;
    L63:
        if (this.f == false) goto L73;
        a r3 = this.f13885J;
        if (r3 == null) goto L67;
        r3.onDrawEnd(this);
    L67:
        this.O = true;
        return;
    L73:
        return;
    L71:
        return;
    L10:
        if (this.l < 0.0f) goto L55;
        long r4 = SystemClock.elapsedRealtime();
        float r5 = this.l;
        if (r5 <= 0.0f) goto L14;
        long r6 = (long) (1000.0d / ((double) r5));
    L16:
        if (this.p == true) goto L23;
        long r9 = this.P;
        if ((r4 - r9) < r6) goto L23;
        if (r9 != 0) goto L22;
        long r7 = 1;
    L25:
        if (r7 <= 0) goto L40;
        int r8 = this.q;
        monitor-enter(this);
    L37:
        th = move-exception;
        throw th;
    L29:
        if (this.p == true) goto L35;
        int r10 = this.o;     // Catch: Throwable -> L37
        if (r10 >= r8) goto L35;
        int r11 = (int) (((long) r10) + r7);     // Catch: Throwable -> L37
        this.o = r11;     // Catch: Throwable -> L37
        if (r11 <= r8) goto L35;
        this.o = r8;     // Catch: Throwable -> L37
    L35:
        monitor-exit(this);     // Catch: Throwable -> L37
    L40:
        this.s.f13902c = this.o;
        float[] r12 = this.i.findCursorPosition(this.o, !this.f);
        this.R = r12;
        if (r12[2] <= 0.0f) goto L43;
        r2 = true;
    L45:
        if (this.g == false) goto L47;
        this.y = r12[3];
    L48:
        int r13 = this.Q;
        int r14 = this.o;
        if (r13 == r14) goto L56;
        if (r2 == false) goto L52;
        r4 = 0;
    L52:
        this.P = r4;
        this.Q = r14;
        a r15 = this.f13885J;
        if (r15 == null) goto L56;
        r15.onAnimationStep(this, r14, this.q, this.r);
        goto L56
    L47:
        this.y = this.x;
        goto L48
    L43:
        r2 = false;
        goto L45
    L22:
        r7 = (r4 - r9) / r6;
    L23:
        r7 = 0;
        goto L25
    L14:
        r6 = Long.MAX_VALUE;
        goto L16
    }

    public void b() {
        a(new $$Lambda$f$P9dYOkPXAAEgH7IxerU6YxoPc(this));
    }

    private /* synthetic */ void j() {
        if (this.O == false) goto L5;
        return;
    L5:
        if (this.n == 1) goto L7;
        return;
    L7:
        if (this.l > 0.0f) goto L9;
        return;
    L9:
        if (this.p == true) goto L19;
        long r4 = (this.P + ((long) (1000.0d / ((double) this.l)))) - SystemClock.elapsedRealtime();
        if (r4 > 0) goto L14;
        r4 = 0;
    L14:
        a(new $$Lambda$f$lCr6hCOqPadHvAaqFgqo3uG1HWg(this), r4);
        return;
    }

    private /* synthetic */ void k() {
        g();
    }

    public void a(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        if (this.E == Looper.myLooper()) goto L5;
        this.F.post(r4);
        return;
    L5:
        r4.run();
    }

    private void a(Runnable r4, long r5) {
        Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.aiagent.plugin");
        Looper r0 = this.E;
        if (r0 != null) goto L5;
        a(TAG, "run task on a thread without looper!");
        return;
    L5:
        if (r5 <= 0) goto L7;
    L10:
        this.F.postDelayed(r6, r5);
        return;
    L7:
        if (r0 != Looper.myLooper()) goto L10;
        r6.run();
    }

    public void a(String r1) {
        this.f13889d = r1;
        this.f13888c = true;
        g();
    }

    public void b(String r2) {
        if (r2.equals("typewriter") == false) goto L5;
        this.n = 1;
    L6:
        g();
        return;
    L5:
        this.n = 0;
        goto L6
    }

    public void a(float r2) {
        if (r2 >= 0.0f) goto L6;
        r2 = 1.0f;
    L6:
        this.l = r2;
        g();
    }

    public void a(HashMap r1) {
        this.h = r1;
        this.f13888c = true;
        g();
    }

    public void a(boolean r1) {
        this.f = r1;
        this.f13888c = true;
        g();
    }

    public void b(boolean r1) {
        this.g = r1;
        g();
    }

    public void a(int r1) {
        this.m = r1;
        this.o = r1;
        g();
    }

    public int c() {
        return this.A;
    }

    public int d() {
        return this.B;
    }

    public int e() {
        return this.q;
    }

    a f() {
        return this.f13885J;
    }

    public void a(f r1, int r2, int r3, boolean r4) {
        a r0 = this.f13885J;
        if (r0 == null) goto L6;
        r0.onSelectionChange(r1, r2, r3, r4);
        return;
    }

    public void a(f r1, String r2, String r3) {
        a r0 = this.f13885J;
        if (r0 == null) goto L6;
        r0.onLink(r1, r2, r3);
        return;
    }

    public void a(f r1, String r2) {
        a r0 = this.f13885J;
        if (r0 == null) goto L6;
        r0.onOverflow(r1, r2);
        return;
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
