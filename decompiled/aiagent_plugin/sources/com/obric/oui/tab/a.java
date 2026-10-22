package com.obric.oui.tab;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.l.n;
import java.util.Objects;

/* JADX INFO: compiled from: OTabLayoutHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0997a f36320a = null;
    private static final float[] r = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Paint f36321b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PorterDuffXfermode f36322c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Matrix f36323d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Matrix f36324e;
    private boolean f;
    private float g;
    private float h;
    private float i;
    private float j;
    private float k;
    private LinearGradient l;
    private LinearGradient m;
    private float n;
    private int o;
    private int p;
    private ValueAnimator q;

    /* JADX INFO: renamed from: com.obric.oui.tab.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: OTabLayoutHelper.kt */
    public static final class C0997a {
        public /* synthetic */ C0997a(h r1) {
            this();
        }

        private C0997a() {
        }
    }

    private final float b(boolean r1) {
        if (r1 == false) goto L4;
        return 1.0f;
    L4:
        return 0.0f;
    }

    /* JADX INFO: renamed from: lambda$lDlyBXhX-Qjno7k11UKHZm9YQ1g, reason: not valid java name */
    public static /* synthetic */ void m1193lambda$lDlyBXhXQjno7k11UKHZm9YQ1g(a r0, float r1, float r2, float r3, float r4, View r5, ValueAnimator r6) {
        a(r0, r1, r2, r3, r4, r5, r6);
    }

    public a() {
        this.f36321b = new Paint(1);
        this.f36322c = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        this.f36323d = new Matrix();
        this.f36324e = new Matrix();
        this.n = -1.0f;
        this.o = -1;
        this.p = -1;
    }

    public static final /* synthetic */ void a(a r0, Animator r1) {
        r0.a(r1);
    }

    static {
        f36320a = new C0997a(null);
        r = new float[]{0.0f, 1.0f};
    }

    public final void a(boolean r3, boolean r4, View r5) {
        o.e(r5, "invalidateView");
        if (this.f == false) goto L10;
        if (this.g <= 0.0f) goto L10;
        a(b(r3), b(r4), r5);
        return;
    L10:
        if (e() == false) goto L13;
        r5.invalidate();
        return;
    }

    public final boolean a(int r3, int r4) {
        if (this.f == true) goto L5;
    L13:
        return false;
    L5:
        if (this.g <= 0.0f) goto L13;
        if (r3 <= 0) goto L13;
        if (r4 <= 0) goto L13;
        if (a() == false) goto L11;
    L12:
        return true;
    L11:
        if (b() == false) goto L13;
        goto L12
    }

    public final boolean a() {
        if (this.h <= 0.0f) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean b() {
        if (this.i <= 0.0f) goto L5;
        return true;
    L5:
        return false;
    }

    public final void a(Canvas r13, float r14, float r15, float r16, float r17, boolean r18, boolean r19) {
        o.e(r13, "canvas");
        float r8 = Math.min(this.g, ((int) (r16 - r14)) / 2.0f);
        if (r8 > 0.0f) goto L5;
        return;
    L5:
        this.f36321b.setXfermode((Xfermode) ZeusTransformUtils.preCheckCast(this.f36322c, Xfermode.class, "com.obric.aiagent.plugin"));
        if (r18 == false) goto L10;
        float r1 = this.h * r8;
        if (r1 <= 0.0f) goto L10;
        LinearGradient r3 = b(r8);
        this.f36323d.reset();
        this.f36323d.setScale(r1 / r8, 1.0f);
        this.f36323d.postTranslate(r14, 0.0f);
        r3.setLocalMatrix(this.f36323d);
        this.f36321b.setShader((Shader) ZeusTransformUtils.preCheckCast(r3, Shader.class, "com.obric.aiagent.plugin"));
        r13.drawRect(r14, r15, r14 + r1, r17, this.f36321b);
    L10:
        if (r19 == false) goto L14;
        float r2 = this.i * r8;
        if (r2 <= 0.0f) goto L14;
        LinearGradient r4 = c(r8);
        this.f36324e.reset();
        this.f36324e.setScale(r2 / r8, 1.0f);
        float r5 = r16 - r2;
        this.f36324e.postTranslate(r5, 0.0f);
        r4.setLocalMatrix(this.f36324e);
        this.f36321b.setShader((Shader) ZeusTransformUtils.preCheckCast(r4, Shader.class, "com.obric.aiagent.plugin"));
        r13.drawRect(r5, r15, r16, r17, this.f36321b);
    L14:
        this.f36321b.setShader(null);
        this.f36321b.setXfermode(null);
    }

    private final void a(final float r11, final float r12, final View r13) {
        boolean r1 = true;
        if (this.j != r11) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
    L13:
        final float r5 = this.h;
        final float r7 = this.i;
        this.j = r11;
        this.k = r12;
        if (r5 != r11) goto L16;
        boolean r2 = true;
    L17:
        if (r2 == true) goto L19;
    L24:
        ValueAnimator r3 = this.q;
        if (r3 == null) goto L28;
        r3.cancel();
    L28:
        ValueAnimator r4 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r4.setDuration(Math.max(1, (long) (120 * Math.max(Math.abs(r11 - r5), Math.abs(r12 - r7)))));
        r4.addUpdateListener(new $$Lambda$a$lDlyBXhXQjno7k11UKHZm9YQ1g(this, r5, r11, r7, r12, r13));
        r4.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(new OTabLayoutEdgeFadeHelper$animateFadeStrength$1$2(this), Animator.AnimatorListener.class, "com.obric.aiagent.plugin"));
        this.q = r4;
        if (r4 == null) goto L33;
        r4.start();
        return;
    L33:
        return;
    L19:
        if (r7 == r12) goto L22;
        r1 = false;
    L22:
        if (r1 == false) goto L24;
        return;
    L16:
        r2 = false;
        goto L17
    L8:
        if (this.k != r12) goto L10;
        boolean r6 = true;
    L11:
        if (r6 == false) goto L13;
        return;
    L10:
        r6 = false;
        goto L11
    L5:
        r0 = false;
        goto L6
    }

    private static final void a(a r2, float r3, float r4, float r5, float r6, View r7, ValueAnimator r8) {
        o.e(r2, "this$0");
        o.e(r7, "$invalidateView");
        o.e(r8, "it");
        Object r9 = r8.getAnimatedValue();
        Objects.requireNonNull(r9, "null cannot be cast to non-null type kotlin.Float");
        float r10 = ((Float) ZeusTransformUtils.preCheckCast(r9, Float.class, "com.obric.aiagent.plugin")).floatValue();
        r2.h = r2.a(r3, r4, r10);
        r2.i = r2.a(r5, r6, r10);
        r7.invalidate();
    }

    private final void a(Animator r2) {
        if (this.q != r2) goto L6;
        this.q = null;
        return;
    }

    public final boolean a(boolean r2) {
        if (this.f != r2) goto L6;
        return false;
    L6:
        this.f = r2;
        return true;
    }

    public final boolean c() {
        return this.f;
    }

    public final boolean a(float r4) {
        float r5 = n.a(r4, 0.0f);
        if (this.g != r5) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return false;
    L8:
        this.g = r5;
        f();
        return true;
    L5:
        r0 = false;
        goto L6
    }

    public final float d() {
        return this.g;
    }

    private final LinearGradient b(float r14) {
        int r0 = d(this.h);
        LinearGradient r1 = this.l;
        if (r1 != null) goto L5;
    L12:
        LinearGradient r2 = new LinearGradient(0.0f, 0.0f, r14, 0.0f, new int[]{Color.argb(r0, 0, 0, 0), Color.argb(255, 0, 0, 0)}, r, Shader.TileMode.CLAMP);
        this.l = r2;
        this.n = r14;
        this.o = r0;
        return r2;
    L5:
        if (this.n != r14) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == false) goto L12;
        if (this.o != r0) goto L12;
        return r1;
    L7:
        r4 = false;
        goto L8
    }

    private final LinearGradient c(float r14) {
        int r0 = d(this.i);
        LinearGradient r1 = this.m;
        if (r1 != null) goto L5;
    L12:
        LinearGradient r2 = new LinearGradient(0.0f, 0.0f, r14, 0.0f, new int[]{Color.argb(255, 0, 0, 0), Color.argb(r0, 0, 0, 0)}, r, Shader.TileMode.CLAMP);
        this.m = r2;
        this.n = r14;
        this.p = r0;
        return r2;
    L5:
        if (this.n != r14) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == false) goto L12;
        if (this.p != r0) goto L12;
        return r1;
    L7:
        r4 = false;
        goto L8
    }

    private final int d(float r3) {
        return d.i.a.a(255 * (1.0f - n.a(r3, 0.0f, 1.0f)));
    }

    private final float a(float r2, float r3, float r4) {
        return r2 + ((r3 - r2) * n.a(r4, 0.0f, 1.0f));
    }

    private final boolean e() {
        if (a() == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        ValueAnimator r1 = this.q;
        if (r1 == null) goto L13;
        r1.cancel();
    L13:
        this.q = null;
        this.h = 0.0f;
        this.i = 0.0f;
        this.j = 0.0f;
        this.k = 0.0f;
        f();
        return r0;
    L5:
        if (b() == true) goto L8;
        r0 = false;
        goto L9
    }

    private final void f() {
        this.n = -1.0f;
        this.l = null;
        this.m = null;
        this.o = -1;
        this.p = -1;
    }
}
