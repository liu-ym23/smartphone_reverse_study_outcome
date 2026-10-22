package com.obric.oui.indicator;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.h.b.p;
import d.k;
import d.x;

/* JADX INFO: compiled from: IndicatorAnimator.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0957b f35366a = null;
    private static final boolean j = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final View f35367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TimeInterpolator f35368c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c f35369d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f35370e;
    private com.obric.oui.indicator.g f;
    private a g;
    private int h;
    private float i;

    /* JADX INFO: compiled from: IndicatorAnimator.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f35371a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.obric.oui.indicator.g f35372b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private com.obric.oui.indicator.g f35373c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final com.obric.oui.indicator.f f35374d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final d f35375e;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (this.f35371a == r6.f35371a) goto L12;
            return false;
        L12:
            if (o.a(this.f35372b, r6.f35372b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f35373c, r6.f35373c) == true) goto L18;
            return false;
        L18:
            if (this.f35374d == r6.f35374d) goto L21;
            return false;
        L21:
            if (this.f35375e == r6.f35375e) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            return (((((((Integer.hashCode(this.f35371a) * 31) + this.f35372b.hashCode()) * 31) + this.f35373c.hashCode()) * 31) + this.f35374d.hashCode()) * 31) + this.f35375e.hashCode();
        }

        public String toString() {
            return "ActiveViewportTransition(transitionToken=" + this.f35371a + ", sourceState=" + this.f35372b + ", targetState=" + this.f35373c + ", direction=" + this.f35374d + ", reason=" + this.f35375e + ')';
        }

        public a(int r2, com.obric.oui.indicator.g r3, com.obric.oui.indicator.g r4, com.obric.oui.indicator.f r5, d r6) {
            o.e(r3, "sourceState");
            o.e(r4, "targetState");
            o.e(r5, "direction");
            o.e(r6, "reason");
            this.f35371a = r2;
            this.f35372b = r3;
            this.f35373c = r4;
            this.f35374d = r5;
            this.f35375e = r6;
        }

        public final int a() {
            return this.f35371a;
        }

        public final com.obric.oui.indicator.g b() {
            return this.f35372b;
        }

        public final com.obric.oui.indicator.g c() {
            return this.f35373c;
        }

        public final d d() {
            return this.f35375e;
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.indicator.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: IndicatorAnimator.kt */
    public static final class C0957b {
        public /* synthetic */ C0957b(d.h.b.h r1) {
            this();
        }

        private C0957b() {
        }
    }

    /* JADX INFO: compiled from: IndicatorAnimator.kt */
    public interface c {
        int a();

        void a(com.obric.oui.indicator.g r1);

        void a(com.obric.oui.indicator.g r1, d r2);

        void a(com.obric.oui.indicator.g r1, com.obric.oui.indicator.g r2, float r3);

        boolean a(d.l.j r1);

        int b();

        float c();
    }

    /* JADX INFO: compiled from: IndicatorAnimator.kt */
    public static final enum d extends Enum<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f35376a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f35377b = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ d[] f35378d = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f35379c;

        private static final /* synthetic */ d[] b() {
            return new d[]{f35376a, f35377b};
        }

        public static d valueOf(String r2) {
            return (d) ZeusTransformUtils.preCheckCast(Enum.valueOf(d.class, r2), d.class, "com.obric.aiagent.plugin");
        }

        public static d[] values() {
            return (d[]) ZeusTransformUtils.preCheckCast(f35378d.clone(), d[].class, "com.obric.aiagent.plugin");
        }

        private d(String r1, int r2, String r3) {
            super(r1, r2);
            this.f35379c = r3;
        }

        public final String a() {
            return this.f35379c;
        }

        static {
            f35376a = new d("SCROLL", 0, "scroll");
            f35377b = new d("REFRESH_DOTS", 1, "refreshDots");
            f35378d = b();
        }
    }

    /* JADX INFO: compiled from: IndicatorAnimator.kt */
    private static final enum e extends Enum<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f35380a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final e f35381b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ e[] f35382c = null;

        private static final /* synthetic */ e[] a() {
            return new e[]{f35380a, f35381b};
        }

        public static e valueOf(String r2) {
            return (e) ZeusTransformUtils.preCheckCast(Enum.valueOf(e.class, r2), e.class, "com.obric.aiagent.plugin");
        }

        public static e[] values() {
            return (e[]) ZeusTransformUtils.preCheckCast(f35382c.clone(), e[].class, "com.obric.aiagent.plugin");
        }

        private e(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f35380a = new e("FORWARD", 0);
            f35381b = new e("BACKWARD", 1);
            f35382c = a();
        }
    }

    /* JADX INFO: compiled from: IndicatorAnimator.kt */
    public /* synthetic */ class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f35383a = null;

        static {
            int[] r0 = new int[e.values().length];
            r0[e.f35381b.ordinal()] = 1;
            r0[e.f35380a.ordinal()] = 2;
            f35383a = r0;
        }
    }

    /* JADX INFO: compiled from: IndicatorAnimator.kt */
    static final class g extends p implements d.h.a.a<x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f35384a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f35385b;

        g(b r1, a r2) {
            this.f35384a = r1;
            this.f35385b = r2;
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ x invoke() {
            a();
            return x.f38692a;
        }

        public final void a() {
            b.a(this.f35384a, this.f35385b);
        }
    }

    static {
        f35366a = new C0957b(null);
    }

    /* JADX INFO: renamed from: lambda$fh0_Ht-i6RnOeXdGl6hzq8v5QTU, reason: not valid java name */
    public static /* synthetic */ void m1098lambda$fh0_Hti6RnOeXdGl6hzq8v5QTU(b r0, a r1, float r2, ValueAnimator r3) {
        a(r0, r1, r2, r3);
    }

    public b(View r3, TimeInterpolator r4, c r5) {
        TimeInterpolator r6 = (TimeInterpolator) ZeusTransformUtils.wrapperContextForParams(r4, TimeInterpolator.class, "com.obric.aiagent.plugin");
        c r7 = (c) ZeusTransformUtils.wrapperContextForParams(r5, c.class, "com.obric.aiagent.plugin");
        o.e(r3, "trackView");
        o.e(r6, "interpolator");
        o.e(r7, "host");
        this.f35367b = r3;
        this.f35368c = r6;
        this.f35369d = r7;
        this.f35370e = OCarouselIndicator.TAG;
    }

    public static final /* synthetic */ View a(b r0) {
        return r0.f35367b;
    }

    public static final /* synthetic */ void a(b r0, a r1) {
        r0.a(r1);
    }

    public static final /* synthetic */ a b(b r0) {
        return r0.g;
    }

    public final String a() {
        return this.f35370e;
    }

    public final com.obric.oui.indicator.g b() {
        return this.f;
    }

    public final void a(d r6, com.obric.oui.indicator.g r7) {
        o.e(r6, "reason");
        o.e(r7, "nextViewportState");
        if (this.g == null) goto L5;
        return;
    L5:
        com.obric.oui.indicator.g r0 = this.f;
        if (r0 != null) goto L8;
        d.l.j r1 = null;
    L9:
        boolean r2 = true;
        boolean r3 = !o.a(r1, r7.b());
        if (r3 == true) goto L16;
        if (this.f35369d.a(r7.b()) == true) goto L16;
        r2 = false;
    L16:
        if (a(r6, r0, r7, r3) == false) goto L21;
        if (r0 != null) goto L19;
        r0 = r7;
    L19:
        a(r0, r7, r6);
        return;
    L21:
        if (r2 == false) goto L23;
        this.f35369d.a(r7, r6);
    L23:
        this.f = r7;
        this.f35369d.a(r7);
        return;
    L8:
        r1 = r0.b();
        goto L9
    }

    public final int a(int r6, int r7, float r8) {
        float r0 = this.i;
        if (r8 <= r0) goto L6;
        e r1 = e.f35380a;
    L10:
        if (r1 != null) goto L12;
        int r2 = -1;
    L13:
        boolean r3 = false;
        if (r2 == (-1)) goto L25;
        if (r2 == 1) goto L22;
        if (r2 == 2) goto L25;
        throw new k();
    L22:
        if (r8 > 0.5f) goto L26;
    L27:
        boolean r4 = false;
    L28:
        if (r4 == false) goto L31;
        r6 = r7;
    L31:
        if (r8 != 0.0f) goto L33;
        r3 = true;
    L33:
        if (r3 == true) goto L35;
        this.i = r8;
    L35:
        return r6;
    L26:
        r4 = true;
    L25:
        if (r8 < 0.5f) goto L27;
    L12:
        r2 = f.f35383a[r1.ordinal()];
        goto L13
    L6:
        if (r8 >= r0) goto L8;
        r1 = e.f35381b;
        goto L10
    L8:
        r1 = null;
        goto L10
    }

    private final boolean a(d r3, com.obric.oui.indicator.g r4, com.obric.oui.indicator.g r5, boolean r6) {
        if (r3 != d.f35376a) goto L16;
        if (r6 == false) goto L16;
        if (r4 != null) goto L12;
        if (j == false) goto L10;
        com.obric.oui.d.a.b.b(this.f35370e, "Skip viewport transition, reason=" + r3.a() + " current=null next=" + r5.b());
    L10:
        return false;
    L12:
        if (this.f35369d.a() > this.f35369d.b()) goto L14;
        return false;
    L14:
        return true;
    L16:
        return false;
    }

    private final void a(com.obric.oui.indicator.g r12, com.obric.oui.indicator.g r13, d r14) {
        com.obric.oui.indicator.f r0 = h.a(r12.b(), r13.b());
        if (r0 != null) goto L6;
        b r11 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");
        com.obric.oui.d.a.b.d(r11.a(), "Abort viewport transition because range shift is not adjacent, source=" + r12.b() + " target=" + r13.b());
        r11.f35369d.a(r13, r14);
        r11.f = r13;
        r11.f35369d.a(r13);
        return;
    L6:
        float r8 = this.f35369d.c();
        if (r8 > 0.0f) goto L10;
        com.obric.oui.d.a.b.d(this.f35370e, o.a("Abort viewport transition because step distance is invalid, distance=", Float.valueOf(r8)));
        this.f35369d.a(r13, r14);
        this.f = r13;
        this.f35369d.a(r13);
        return;
    L10:
        c();
        int r3 = this.h + 1;
        this.h = r3;
        a r10 = new a(r3, r12, r13, r0, r14);
        this.g = r10;
        if (j == false) goto L13;
        com.obric.oui.d.a.b.b(this.f35370e, "Start viewport transition, reason=" + r14.a() + " from=" + r12.b() + " to=" + r13.b() + " direction=" + r0 + " distance=" + r8);
    L13:
        this.f35369d.a(r12, r13, 0.0f);
        a(r10, r0.a(r8), (d.h.a.a) ZeusTransformUtils.preCheckCast(new g(this, r10), d.h.a.a.class, "com.obric.aiagent.plugin"));
    }

    private final void a(a r7) {
        a r0 = this.g;
        boolean r1 = false;
        if (r0 != null) goto L6;
    L8:
        if (r1 == true) goto L10;
        return;
    L10:
        com.obric.oui.indicator.g r2 = r0.c();
        this.f35369d.a(r2, r0.d());
        this.f = r2;
        this.f35369d.a(r2);
        boolean r3 = j;
        if (r3 == false) goto L13;
        com.obric.oui.d.a.b.b(this.f35370e, "Commit viewport transition, token=" + r7.a() + " range=" + r2.b());
    L13:
        c();
        this.g = null;
        if (r3 == false) goto L17;
        com.obric.oui.d.a.b.b(this.f35370e, "Finish viewport transition after commit, token=" + r7.a() + " range=" + r2.b());
        return;
    L17:
        return;
    L6:
        if (r0.a() != r7.a()) goto L8;
        r1 = true;
        goto L8
    }

    private final void a(final a r5, float r6, d.h.a.a<x> r7) {
        final d.h.a.a r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.a.class, "com.obric.aiagent.plugin");
        d();
        final float r0 = Math.abs(r6);
        this.f35367b.animate().translationX(r6).setDuration(300).setInterpolator(this.f35368c).setUpdateListener(new $$Lambda$b$fh0_Hti6RnOeXdGl6hzq8v5QTU(this, r5, r0)).setListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(new IndicatorAnimator$startTrackTranslationAnimation$2(this, r5, r8), Animator.AnimatorListener.class, "com.obric.aiagent.plugin")).start();
    }

    private static final void a(b r2, a r3, float r4, ValueAnimator r5) {
        o.e(r2, "this$0");
        o.e(r3, "$transition");
        o.e(r5, "it");
        a r6 = r2.g;
        boolean r0 = false;
        if (r6 != null) goto L6;
    L8:
        if (r0 == true) goto L10;
        return;
    L10:
        float r7 = Math.abs(r2.f35367b.getTranslationX()) / r4;
        r2.f35369d.a(r3.b(), r3.c(), r7);
        return;
    L6:
        if (r6.a() != r3.a()) goto L8;
        r0 = true;
        goto L8
    }

    private final void c() {
        this.f35367b.setTranslationX(0.0f);
        com.obric.oui.indicator.g r0 = this.f;
        if (r0 == null) goto L7;
        this.f35369d.a(r0);
        return;
    }

    private final void d() {
        this.f35367b.animate().setUpdateListener(null).setListener(null).cancel();
    }
}
