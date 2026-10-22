package x;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AnimationUtils;
import androidx.lifecycle.a0;
import u0.z;

/* loaded from: classes.dex */
public final class n extends View {

    /* renamed from: k, reason: collision with root package name */
    public static final int[] f11037k = {R.attr.state_pressed, R.attr.state_enabled};

    /* renamed from: l, reason: collision with root package name */
    public static final int[] f11038l = new int[0];

    /* renamed from: f, reason: collision with root package name */
    public u f11039f;

    /* renamed from: g, reason: collision with root package name */
    public Boolean f11040g;

    /* renamed from: h, reason: collision with root package name */
    public Long f11041h;

    /* renamed from: i, reason: collision with root package name */
    public a0 f11042i;

    /* renamed from: j, reason: collision with root package name */
    public p7.a f11043j;

    private final void setRippleState(boolean z4) {
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        Runnable runnable = this.f11042i;
        if (runnable != null) {
            removeCallbacks(runnable);
            runnable.run();
        }
        Long l6 = this.f11041h;
        long jLongValue = jCurrentAnimationTimeMillis - (l6 != null ? l6.longValue() : 0L);
        if (z4 || jLongValue >= 5) {
            int[] iArr = z4 ? f11037k : f11038l;
            u uVar = this.f11039f;
            if (uVar != null) {
                uVar.setState(iArr);
            }
        } else {
            a0 a0Var = new a0(7, this);
            this.f11042i = a0Var;
            postDelayed(a0Var, 50L);
        }
        this.f11041h = Long.valueOf(jCurrentAnimationTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setRippleState$lambda$2(n nVar) {
        u uVar = nVar.f11039f;
        if (uVar != null) {
            uVar.setState(f11038l);
        }
        nVar.f11042i = null;
    }

    public final void b(q.k kVar, boolean z4, long j2, int i2, long j4, float f10, p7.a aVar) {
        if (this.f11039f == null || !Boolean.valueOf(z4).equals(this.f11040g)) {
            u uVar = new u(z4);
            setBackground(uVar);
            this.f11039f = uVar;
            this.f11040g = Boolean.valueOf(z4);
        }
        u uVar2 = this.f11039f;
        q7.k.b(uVar2);
        this.f11043j = aVar;
        Integer num = uVar2.f11060h;
        if (num == null || num.intValue() != i2) {
            uVar2.f11060h = Integer.valueOf(i2);
            t.f11057a.a(uVar2, i2);
        }
        e(j2, j4, f10);
        if (z4) {
            uVar2.setHotspot(t0.b.d(kVar.f8616a), t0.b.e(kVar.f8616a));
        } else {
            uVar2.setHotspot(uVar2.getBounds().centerX(), uVar2.getBounds().centerY());
        }
        setRippleState(true);
    }

    public final void c() {
        this.f11043j = null;
        a0 a0Var = this.f11042i;
        if (a0Var != null) {
            removeCallbacks(a0Var);
            a0 a0Var2 = this.f11042i;
            q7.k.b(a0Var2);
            a0Var2.run();
        } else {
            u uVar = this.f11039f;
            if (uVar != null) {
                uVar.setState(f11038l);
            }
        }
        u uVar2 = this.f11039f;
        if (uVar2 == null) {
            return;
        }
        uVar2.setVisible(false, false);
        unscheduleDrawable(uVar2);
    }

    public final void d() {
        setRippleState(false);
    }

    public final void e(long j2, long j4, float f10) {
        u uVar = this.f11039f;
        if (uVar == null) {
            return;
        }
        if (f10 > 1.0f) {
            f10 = 1.0f;
        }
        long jB = u0.m.b(f10, j4);
        u0.m mVar = uVar.f11059g;
        if (!(mVar == null ? false : u0.m.c(mVar.f9918a, jB))) {
            uVar.f11059g = new u0.m(jB);
            uVar.setColor(ColorStateList.valueOf(z.o(jB)));
        }
        Rect rect = new Rect(0, 0, s7.a.U(t0.e.d(j2)), s7.a.U(t0.e.b(j2)));
        setLeft(rect.left);
        setTop(rect.top);
        setRight(rect.right);
        setBottom(rect.bottom);
        uVar.setBounds(rect);
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        p7.a aVar = this.f11043j;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // android.view.View
    public final void onLayout(boolean z4, int i2, int i10, int i11, int i12) {
    }

    @Override // android.view.View
    public final void onMeasure(int i2, int i10) {
        setMeasuredDimension(0, 0);
    }

    @Override // android.view.View
    public final void refreshDrawableState() {
    }
}
