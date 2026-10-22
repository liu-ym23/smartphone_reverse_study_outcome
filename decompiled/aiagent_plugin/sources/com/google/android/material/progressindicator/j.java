package com.google.android.material.progressindicator;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.Property;
import android.view.animation.Interpolator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: compiled from: LinearIndeterminateDisjointAnimatorDelegate.java */
/* JADX INFO: loaded from: classes2.dex */
final class j extends g<ObjectAnimator> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[] f13526e = null;
    private static final int[] f = null;
    private static final Property<j, Float> n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Animatable2Compat.a f13527a;
    private ObjectAnimator g;
    private ObjectAnimator h;
    private final Interpolator[] i;
    private final b j;
    private int k;
    private boolean l;
    private float m;

    static /* synthetic */ int a(j r0) {
        return r0.k;
    }

    static /* synthetic */ int a(j r0, int r1) {
        r0.k = r1;
        return r1;
    }

    static /* synthetic */ boolean a(j r0, boolean r1) {
        r0.l = r1;
        return r1;
    }

    static /* synthetic */ b b(j r0) {
        return r0.j;
    }

    static /* synthetic */ float c(j r0) {
        return r0.i();
    }

    static {
        f13526e = new int[]{533, 567, 850, 750};
        f = new int[]{1267, 1000, 333, 0};
        final Class<Float> r1 = Float.class;
        final String r2 = "animationFraction";
        n = new LinearIndeterminateDisjointAnimatorDelegate$3(r1, r2);
    }

    public j(Context r6, k r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        super(2);
        this.k = 0;
        this.f13527a = null;
        this.j = r7;
        this.i = new Interpolator[]{androidx.vectordrawable.graphics.drawable.b.a(r8, ZeusTransformUtils.mapRes(R.animator.linear_indeterminate_line1_head_interpolator, "animator", "linear_indeterminate_line1_head_interpolator")), androidx.vectordrawable.graphics.drawable.b.a(r8, ZeusTransformUtils.mapRes(R.animator.linear_indeterminate_line1_tail_interpolator, "animator", "linear_indeterminate_line1_tail_interpolator")), androidx.vectordrawable.graphics.drawable.b.a(r8, ZeusTransformUtils.mapRes(R.animator.linear_indeterminate_line2_head_interpolator, "animator", "linear_indeterminate_line2_head_interpolator")), androidx.vectordrawable.graphics.drawable.b.a(r8, ZeusTransformUtils.mapRes(R.animator.linear_indeterminate_line2_tail_interpolator, "animator", "linear_indeterminate_line2_tail_interpolator"))};
    }

    @Override // com.google.android.material.progressindicator.g
    public void a() {
        g();
        f();
        this.g.start();
    }

    private void g() {
        if (this.g != null) goto L6;
        ObjectAnimator r0 = ObjectAnimator.ofFloat(this, n, new float[]{0.0f, 1.0f});
        this.g = r0;
        r0.setDuration(1800);
        this.g.setInterpolator(null);
        this.g.setRepeatCount(-1);
        this.g.addListener(new LinearIndeterminateDisjointAnimatorDelegate$1(this));
    L6:
        if (this.h != null) goto L9;
        ObjectAnimator r1 = ObjectAnimator.ofFloat(this, n, new float[]{1.0f});
        this.h = r1;
        r1.setDuration(1800);
        this.h.setInterpolator(null);
        this.h.addListener(new LinearIndeterminateDisjointAnimatorDelegate$2(this));
        return;
    }

    @Override // com.google.android.material.progressindicator.g
    public void b() {
        ObjectAnimator r0 = this.g;
        if (r0 == null) goto L6;
        r0.cancel();
        return;
    }

    @Override // com.google.android.material.progressindicator.g
    public void c() {
        ObjectAnimator r0 = this.h;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isRunning() == true) goto L13;
        b();
        if (this.f13518b.isVisible() == false) goto L12;
        this.h.setFloatValues(new float[]{this.m, 1.0f});
        this.h.setDuration((long) ((1.0f - this.m) * 1800.0f));
        this.h.start();
        return;
    L12:
        return;
    }

    @Override // com.google.android.material.progressindicator.g
    public void d() {
        f();
    }

    @Override // com.google.android.material.progressindicator.g
    public void a(Animatable2Compat.a r1) {
        this.f13527a = r1;
    }

    @Override // com.google.android.material.progressindicator.g
    public void e() {
        this.f13527a = null;
    }

    private void a(int r6) {
        int r0 = 0;
    L4:
        if (r0 >= 4) goto L6;
        float r1 = a(r6, f[r0], f13526e[r0]);
        float r2 = this.i[r0].getInterpolation(r1);
        this.f13519c[r0] = Math.max(0.0f, Math.min(1.0f, r2));
        r0 = r0 + 1;
        goto L4
    }

    private void h() {
        if (this.l == false) goto L6;
        Arrays.fill(this.f13520d, com.google.android.material.color.b.b(this.j.f13508c[this.k], this.f13518b.getAlpha()));
        this.l = false;
        return;
    }

    void f() {
        this.k = 0;
        int r1 = com.google.android.material.color.b.b(this.j.f13508c[0], this.f13518b.getAlpha());
        this.f13520d[0] = r1;
        this.f13520d[1] = r1;
    }

    private float i() {
        return this.m;
    }

    void a(float r2) {
        this.m = r2;
        a((int) (r2 * 1800.0f));
        h();
        this.f13518b.invalidateSelf();
    }
}
