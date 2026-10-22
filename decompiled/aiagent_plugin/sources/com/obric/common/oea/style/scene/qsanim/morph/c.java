package com.obric.common.oea.style.scene.qsanim.morph;

import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.q;
import d.h.b.h;
import d.h.b.o;
import d.h.b.p;
import d.l.n;
import d.m;
import d.x;

/* JADX INFO: compiled from: ViewMorphAnimHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
public class c {
    private static final String TAG = "ViewMorphAnimHelper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f32574a = null;
    private static int x;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ViewTreeObserver.OnGlobalLayoutListener f32575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.obric.common.oea.style.scene.qsanim.common.d.a f32576c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.obric.common.oea.style.scene.qsanim.common.d.a f32577d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f32578e;
    private float f;
    private float g;
    private float h;
    private PointF i;
    private com.obric.common.oea.foundation.animation.engine.b<?> j;
    private com.obric.common.oea.foundation.animation.engine.b<?> k;
    private boolean l;
    private final q<com.obric.common.oea.foundation.animation.engine.b<?>, Float, Float, x> m;
    private final q<com.obric.common.oea.foundation.animation.engine.b<?>, Float, Float, x> n;
    private final View o;
    private final float p;
    private final float q;
    private final int r;
    private final int s;
    private final int t;
    private final int u;
    private final boolean v;
    private final boolean w;

    /* JADX INFO: compiled from: ViewMorphAnimHelper.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(h r1) {
            this();
        }
    }

    /* JADX INFO: compiled from: ViewMorphAnimHelper.kt */
    static final class b extends p implements q<com.obric.common.oea.foundation.animation.engine.b<?>, Float, Float, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f32579a;

        b(c r1) {
            this.f32579a = r1;
            super(3);
        }

        @Override // d.h.a.q
        public /* synthetic */ x invoke(com.obric.common.oea.foundation.animation.engine.b<?> r3, Float r4, Float r5) {
            a((com.obric.common.oea.foundation.animation.engine.b) ZeusTransformUtils.preCheckCast(r3, com.obric.common.oea.foundation.animation.engine.b.class, "com.obric.aiagent.plugin"), ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).floatValue(), ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.aiagent.plugin")).floatValue());
            return x.f38692a;
        }

        public final void a(com.obric.common.oea.foundation.animation.engine.b<?> r2, float r3, float r4) {
            o.e(r2, "anim");
            if (this.f32579a.j() != 0.0f) goto L5;
        L7:
            View r5 = this.f32579a.h();
            ViewGroup.LayoutParams r1 = this.f32579a.h().getLayoutParams();
            r1.height = (int) r3;
            x r6 = x.f38692a;
            r5.setLayoutParams(r1);
            return;
        L5:
            if (this.f32579a.h().getY() >= c.c(this.f32579a)) goto L7;
            this.f32579a.h().setY(c.c(this.f32579a) - (r3 - this.f32579a.b()));
            goto L7
        }
    }

    /* JADX INFO: renamed from: com.obric.common.oea.style.scene.qsanim.morph.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ViewMorphAnimHelper.kt */
    final class C0891c implements com.obric.common.oea.foundation.animation.engine.b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final /* synthetic */ q f32580a;

        C0891c(q r3) {
            this.f32580a = (q) ZeusTransformUtils.wrapperContextForParams(r3, q.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.common.oea.foundation.animation.engine.b.c
        public final /* synthetic */ void a(com.obric.common.oea.foundation.animation.engine.b r1, float r2, float r3) {
            o.c(this.f32580a.invoke(r1, Float.valueOf(r2), Float.valueOf(r3)), "invoke(...)");
        }
    }

    /* JADX INFO: compiled from: ViewMorphAnimHelper.kt */
    static final class d extends p implements q<com.obric.common.oea.foundation.animation.engine.b<?>, Float, Float, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f32581a;

        d(c r1) {
            this.f32581a = r1;
            super(3);
        }

        @Override // d.h.a.q
        public /* synthetic */ x invoke(com.obric.common.oea.foundation.animation.engine.b<?> r3, Float r4, Float r5) {
            a((com.obric.common.oea.foundation.animation.engine.b) ZeusTransformUtils.preCheckCast(r3, com.obric.common.oea.foundation.animation.engine.b.class, "com.obric.aiagent.plugin"), ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).floatValue(), ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.aiagent.plugin")).floatValue());
            return x.f38692a;
        }

        public final void a(com.obric.common.oea.foundation.animation.engine.b<?> r2, float r3, float r4) {
            o.e(r2, "anim");
            if (this.f32581a.i() != 0.0f) goto L5;
        L7:
            View r5 = this.f32581a.h();
            ViewGroup.LayoutParams r1 = this.f32581a.h().getLayoutParams();
            r1.width = (int) r3;
            x r6 = x.f38692a;
            r5.setLayoutParams(r1);
            return;
        L5:
            if (this.f32581a.h().getX() >= c.b(this.f32581a)) goto L7;
            this.f32581a.h().setX(c.b(this.f32581a) - (r3 - this.f32581a.a()));
            goto L7
        }
    }

    static {
        f32574a = new a(null);
    }

    public c(View r2, float r3, float r4, int r5, int r6, int r7, int r8, boolean r9, boolean r10) {
        o.e(r2, "view");
        this.o = r2;
        this.p = r3;
        this.q = r4;
        this.r = r5;
        this.s = r6;
        this.t = r7;
        this.u = r8;
        this.v = r9;
        this.w = r10;
        this.f32575b = (ViewTreeObserver.OnGlobalLayoutListener) ZeusTransformUtils.preCheckCast(new ViewMorphAnimHelper$globalLayoutListener$1(this), ViewTreeObserver.OnGlobalLayoutListener.class, "com.obric.aiagent.plugin");
        boolean r11 = false;
        float r12 = 0;
        if (r3 >= r12) goto L5;
    L7:
        boolean r13 = false;
    L8:
        if (r13 == false) goto L29;
        if (r4 >= r12) goto L12;
    L14:
        boolean r14 = false;
    L15:
        if (r14 == false) goto L27;
        if (r3 != 0.0f) goto L19;
    L20:
        r11 = true;
    L21:
        if (r11 == false) goto L25;
        x++;
        this.f32576c = new com.obric.common.oea.style.scene.qsanim.common.d.a(0.0f);
        this.f32577d = new com.obric.common.oea.style.scene.qsanim.common.d.a(0.0f);
        this.i = new PointF();
        this.m = (q) ZeusTransformUtils.preCheckCast(new d(this), q.class, "com.obric.aiagent.plugin");
        this.n = (q) ZeusTransformUtils.preCheckCast(new b(this), q.class, "com.obric.aiagent.plugin");
        return;
    L25:
        throw new IllegalArgumentException("morphFactorX and morphFactorY can't be both non-zero".toString());
    L19:
        if (r4 != 0.0f) goto L21;
    L27:
        throw new IllegalArgumentException("morphFactorY must be in the range [0, 1]".toString());
    L12:
        if (r3 > 1.0f) goto L14;
        r14 = true;
        goto L15
    L29:
        throw new IllegalArgumentException("morphFactorX must be in the range [0, 1]".toString());
    L5:
        if (r3 > 1.0f) goto L7;
        r13 = true;
        goto L8
    }

    public static final /* synthetic */ boolean a(c r0) {
        return r0.l();
    }

    public static final /* synthetic */ float b(c r0) {
        return r0.h;
    }

    public static final /* synthetic */ float c(c r0) {
        return r0.g;
    }

    public final View h() {
        return this.o;
    }

    public final float i() {
        return this.p;
    }

    public final float j() {
        return this.q;
    }

    public final float a() {
        return this.f32578e;
    }

    public final float b() {
        return this.f;
    }

    public final void c() {
        if (this.f32578e != 0.0f) goto L5;
    L6:
        this.o.getViewTreeObserver().addOnGlobalLayoutListener(this.f32575b);
        com.obric.common.oea.foundation.b.c.f32472a.b(TAG, "init[" + x + "], morphFactorX: " + this.p + ", morphFactorY: " + this.q + ", leftMorphStart: " + this.r + ", rightMorphStart: " + this.s + ", topMorphStart: " + this.t + ", bottomMorphStart: " + this.u);
        return;
    L5:
        if (this.f == 0.0f) goto L6;
    }

    public final void d() {
        this.o.getViewTreeObserver().removeOnGlobalLayoutListener(this.f32575b);
    }

    public final void e() {
        k();
    }

    private final void k() {
        com.obric.common.oea.foundation.animation.engine.b<?> r0 = this.j;
        if (r0 == null) goto L5;
        r0.b();
    L5:
        com.obric.common.oea.foundation.animation.engine.b<?> r1 = this.j;
        if (r1 == null) goto L11;
        q<com.obric.common.oea.foundation.animation.engine.b<?>, Float, Float, x> r2 = this.m;
        Object r3 = r2;
        if (r2 == null) goto L10;
        r3 = new C0891c(r2);
    L10:
        r1.b((com.obric.common.oea.foundation.animation.engine.b.c) ZeusTransformUtils.preCheckCast(r3, com.obric.common.oea.foundation.animation.engine.b.c.class, "com.obric.aiagent.plugin"));
    L11:
        com.obric.common.oea.foundation.animation.engine.b<?> r4 = this.k;
        if (r4 == null) goto L14;
        r4.b();
    L14:
        com.obric.common.oea.foundation.animation.engine.b<?> r5 = this.k;
        if (r5 == null) goto L20;
        q<com.obric.common.oea.foundation.animation.engine.b<?>, Float, Float, x> r6 = this.n;
        Object r7 = r6;
        if (r6 == null) goto L19;
        r7 = new C0891c(r6);
    L19:
        r5.b((com.obric.common.oea.foundation.animation.engine.b.c) ZeusTransformUtils.preCheckCast(r7, com.obric.common.oea.foundation.animation.engine.b.c.class, "com.obric.aiagent.plugin"));
    L20:
        com.obric.common.oea.style.scene.qsanim.common.d.f32567a.a(this.f32576c, com.obric.common.oea.style.scene.qsanim.common.d.f32567a.b());
        com.obric.common.oea.style.scene.qsanim.common.d.f32567a.a(this.f32577d, com.obric.common.oea.style.scene.qsanim.common.d.f32567a.b());
    }

    public final void a(float r3, float r4) {
        if (n() == false) goto L5;
        this.l = true;
    L6:
        com.obric.common.oea.foundation.b.c.f32472a.b(TAG, "startDrag, x: " + r3 + ", y: " + r4);
        return;
    L5:
        this.i = new PointF(r3, r4);
        this.l = false;
        goto L6
    }

    public final void b(float r3, float r4) {
        if (n() == false) goto L5;
    L7:
        com.obric.common.oea.foundation.b.c.f32472a.b(TAG, "dragContinue, x: " + r3 + ", y: " + r4);
        return;
    L5:
        if (this.l == true) goto L7;
        d(r3, r4);
        goto L7
    }

    public final void f() {
        if (n() == false) goto L5;
    L7:
        com.obric.common.oea.foundation.b.c.f32472a.b(TAG, "dragEnd");
        return;
    L5:
        if (this.l == true) goto L7;
        m();
        goto L7
    }

    public final void c(float r4, float r5) {
        this.f32578e = r4;
        this.f = r5;
        com.obric.common.oea.foundation.b.c.f32472a.b(TAG, "setOriginalViewSize, width: " + r4 + ", height: " + r5 + ", initialViewX: " + this.h + ", initialViewY: " + this.g);
    }

    public final com.obric.common.oea.style.scene.qsanim.common.a g() {
        return new com.obric.common.oea.style.scene.qsanim.common.a(this.f32578e, this.f, this.h, this.g);
    }

    public final void a(com.obric.common.oea.style.scene.qsanim.common.a r7) {
        o.e(r7, "viewParams");
        if (r7.a() != 0.0f) goto L5;
    L7:
        com.obric.common.oea.foundation.b.c.a(com.obric.common.oea.foundation.b.c.f32472a, TAG, "setOriginalViewParams, invalid viewParams: " + r7, null, 4, null);
        return;
    L5:
        if (r7.b() == 0.0f) goto L7;
        this.f32578e = r7.a();
        this.f = r7.b();
        this.h = r7.c();
        this.g = r7.d();
    }

    private final boolean l() {
        float r0 = this.o.getWidth();
        float r1 = this.o.getHeight();
        if (r0 != 0.0f) goto L5;
    L8:
        com.obric.common.oea.foundation.b.c.a(com.obric.common.oea.foundation.b.c.f32472a, TAG, "updateViewSize: width or height is zero", null, 4, null);
        return false;
    L5:
        if (r1 == 0.0f) goto L8;
        this.f32578e = r0;
        this.f = r1;
        this.g = this.o.getY();
        this.h = this.o.getX();
        this.f32576c = new com.obric.common.oea.style.scene.qsanim.common.d.a(this.f32578e);
        this.f32577d = new com.obric.common.oea.style.scene.qsanim.common.d.a(this.f);
        com.obric.common.oea.style.scene.qsanim.common.d.f32567a.a();
        com.obric.common.oea.foundation.b.c.f32472a.b(TAG, "instance: " + x + ", updateViewSize, originalWidth: " + this.f32578e + ", originalHeight: " + this.f + ", initialViewX: " + this.h + ", initialViewY: " + this.g);
        return true;
    }

    private final void d(float r7, float r8) {
        if (this.p == 0.0f) goto L5;
    L8:
        float r0 = r7 - this.i.x;
        int r3 = -1;
        if (this.w == false) goto L11;
        int r2 = -1;
    L12:
        float r1 = r0 * r2;
        float r4 = r8 - this.i.y;
        if (this.v == true) goto L16;
        r3 = 1;
    L16:
        float r5 = r4 * r3;
        m<Integer, Integer> r9 = a(r7, r8, r1, r5);
        if (((Number) ZeusTransformUtils.preCheckCast(r9.b(), Number.class, "com.obric.aiagent.plugin")).intValue() != this.f) goto L21;
        if (((Number) ZeusTransformUtils.preCheckCast(r9.a(), Number.class, "com.obric.aiagent.plugin")).intValue() != this.f32578e) goto L21;
        return;
    L21:
        if (this.p == 0.0f) goto L28;
        if (r1 >= 0) goto L25;
        float r10 = this.h - (((Number) ZeusTransformUtils.preCheckCast(r9.a(), Number.class, "com.obric.aiagent.plugin")).floatValue() - this.f32578e);
    L26:
        this.o.setX(r10);
        goto L28
    L25:
        r10 = this.h;
    L28:
        if (this.q != 0.0f) goto L30;
    L34:
        ViewGroup.LayoutParams r11 = this.o.getLayoutParams();
        r11.width = ((Number) ZeusTransformUtils.preCheckCast(r9.a(), Number.class, "com.obric.aiagent.plugin")).intValue();
        r11.height = ((Number) ZeusTransformUtils.preCheckCast(r9.b(), Number.class, "com.obric.aiagent.plugin")).intValue();
        this.o.requestLayout();
        return;
    L30:
        if (r5 >= 0) goto L32;
        float r12 = this.g - (((Number) ZeusTransformUtils.preCheckCast(r9.b(), Number.class, "com.obric.aiagent.plugin")).floatValue() - this.f);
    L33:
        this.o.setY(r12);
        goto L34
    L32:
        r12 = this.g;
        goto L33
    L11:
        r2 = 1;
        goto L12
    L5:
        if (this.q != 0.0f) goto L8;
        com.obric.common.oea.foundation.b.c.f32472a.c(TAG, "performViewMorph: morphFactorX and morphFactorY are both zero, skip");
    }

    public m<Integer, Integer> a(float r12, float r13, float r14, float r15) {
        float r0 = 0;
        if (r14 <= r0) goto L5;
        float r1 = n.a(r12 - this.s, 0.0f);
    L6:
        float r4 = r1;
        if (r15 <= r0) goto L9;
        float r2 = n.b(r13 - this.u, 0.0f);
    L11:
        if (this.p == 0.0f) goto L14;
        com.obric.common.oea.foundation.b.c.f32472a.b(TAG, "calculateNewSize, x: " + r12 + ", dx: " + r14 + ", coercedDx: " + r4 + ", leftStart: " + this.r + ", rightStart: " + this.s);
    L14:
        if (this.q == 0.0f) goto L16;
        com.obric.common.oea.foundation.b.c.f32472a.b(TAG, "calculateNewSize, y: " + r13 + ", dy: " + r15 + ", coercedDy: " + r2 + ", upStart: " + this.t + ", downStart: " + this.u);
    L16:
        float r16 = com.obric.common.oea.style.scene.qsanim.common.b.a(com.obric.common.oea.style.scene.qsanim.common.b.f32563a, r4, this.f32578e * this.p, 0.0f, 4, null);
        float r17 = com.obric.common.oea.style.scene.qsanim.common.b.a(com.obric.common.oea.style.scene.qsanim.common.b.f32563a, r2, this.f * this.q, 0.0f, 4, null);
        float r18 = this.o.getWidth();
        float r19 = this.o.getHeight();
        float r3 = ((r18 * r17) * (-1.0f)) / r19;
        float r110 = ((r19 * r16) * (-1.0f)) / r18;
        return new m(Integer.valueOf(d.i.a.a((this.f32578e + r16) + r3)), Integer.valueOf(d.i.a.a((this.f + r17) + r110)));
    L9:
        r2 = n.a(r13 - this.t, 0.0f);
        goto L11
    L5:
        r1 = n.b(r12 - this.r, 0.0f);
        goto L6
    }

    private final void m() {
        float r0 = this.o.getWidth();
        float r1 = this.o.getHeight();
        com.obric.common.oea.foundation.b.c.f32472a.b(TAG, "animResetView, " + r0 + ", " + r1 + ", " + this.f32578e + ", " + this.f);
        com.obric.common.oea.style.scene.qsanim.common.d r5 = com.obric.common.oea.style.scene.qsanim.common.d.f32567a;
        com.obric.common.oea.style.scene.qsanim.common.d.a r6 = this.f32576c;
        r6.a(r0);
        x r2 = x.f38692a;
        com.obric.common.oea.foundation.animation.engine.c<com.obric.common.oea.style.scene.qsanim.common.d.a> r7 = com.obric.common.oea.style.scene.qsanim.common.d.f32567a.b();
        float r8 = this.f32578e;
        q<com.obric.common.oea.foundation.animation.engine.b<?>, Float, Float, x> r3 = this.m;
        Object r4 = r3;
        if (r3 == null) goto L5;
        r4 = new C0891c(r3);
    L5:
        this.j = (com.obric.common.oea.foundation.animation.engine.b) ZeusTransformUtils.preCheckCast(com.obric.common.oea.style.scene.qsanim.common.d.a(r5, r6, r7, r8, 0.0f, 0.0f, (com.obric.common.oea.foundation.animation.engine.b.c) ZeusTransformUtils.preCheckCast(r4, com.obric.common.oea.foundation.animation.engine.b.c.class, "com.obric.aiagent.plugin"), null, 44, null), com.obric.common.oea.foundation.animation.engine.b.class, "com.obric.aiagent.plugin");
        com.obric.common.oea.style.scene.qsanim.common.d r9 = com.obric.common.oea.style.scene.qsanim.common.d.f32567a;
        com.obric.common.oea.style.scene.qsanim.common.d.a r10 = this.f32577d;
        r10.a(r1);
        x r11 = x.f38692a;
        com.obric.common.oea.foundation.animation.engine.c<com.obric.common.oea.style.scene.qsanim.common.d.a> r12 = com.obric.common.oea.style.scene.qsanim.common.d.f32567a.b();
        float r13 = this.f;
        q<com.obric.common.oea.foundation.animation.engine.b<?>, Float, Float, x> r14 = this.n;
        Object r15 = r14;
        if (r14 == null) goto L8;
        r15 = new C0891c(r14);
    L8:
        this.k = (com.obric.common.oea.foundation.animation.engine.b) ZeusTransformUtils.preCheckCast(com.obric.common.oea.style.scene.qsanim.common.d.a(r9, r10, r12, r13, 0.0f, 0.0f, (com.obric.common.oea.foundation.animation.engine.b.c) ZeusTransformUtils.preCheckCast(r15, com.obric.common.oea.foundation.animation.engine.b.c.class, "com.obric.aiagent.plugin"), null, 44, null), com.obric.common.oea.foundation.animation.engine.b.class, "com.obric.aiagent.plugin");
    }

    private final boolean n() {
        com.obric.common.oea.foundation.animation.engine.b<?> r0 = this.k;
        if (r0 != null) goto L5;
    L6:
        com.obric.common.oea.foundation.animation.engine.b<?> r2 = this.j;
        if (r2 != null) goto L9;
    L11:
        return false;
    L9:
        if (r2.c() != true) goto L11;
        return true;
    L5:
        if (r0.c() != true) goto L6;
        return true;
    }
}
