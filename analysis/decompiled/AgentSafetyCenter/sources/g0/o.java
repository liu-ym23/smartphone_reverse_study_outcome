package g0;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AnimationUtils;
import d1.f0;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class o extends View {

    /* renamed from: j, reason: collision with root package name */
    public static final int[] f4171j = {R.attr.state_pressed, R.attr.state_enabled};

    /* renamed from: k, reason: collision with root package name */
    public static final int[] f4172k = new int[0];

    /* renamed from: c, reason: collision with root package name */
    public x f4173c;

    /* renamed from: f, reason: collision with root package name */
    public Boolean f4174f;

    /* renamed from: g, reason: collision with root package name */
    public Long f4175g;

    /* renamed from: h, reason: collision with root package name */
    public a4.t f4176h;
    public xb.a i;

    private final void setRippleState(boolean z10) {
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        Runnable runnable = this.f4176h;
        if (runnable != null) {
            removeCallbacks(runnable);
            runnable.run();
        }
        Long l2 = this.f4175g;
        long jLongValue = jCurrentAnimationTimeMillis - (l2 != null ? l2.longValue() : 0L);
        if (z10 || jLongValue >= 5) {
            int[] iArr = z10 ? f4171j : f4172k;
            x xVar = this.f4173c;
            if (xVar != null) {
                xVar.setState(iArr);
            }
        } else {
            a4.t tVar = new a4.t(13);
            tVar.f200f = this;
            VarHandle.storeStoreFence();
            this.f4176h = tVar;
            postDelayed(tVar, 50L);
        }
        this.f4175g = Long.valueOf(jCurrentAnimationTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setRippleState$lambda$2(o oVar) {
        x xVar = oVar.f4173c;
        if (xVar != null) {
            xVar.setState(f4172k);
        }
        oVar.f4176h = null;
    }

    public final void b(v.m mVar, boolean z10, long j10, int i, long j11, float f5, xb.a aVar) {
        if (this.f4173c == null || !Boolean.valueOf(z10).equals(this.f4174f)) {
            x xVar = new x(ColorStateList.valueOf(-16777216), null, z10 ? new ColorDrawable(-1) : null);
            xVar.f4196c = z10;
            VarHandle.storeStoreFence();
            setBackground(xVar);
            this.f4173c = xVar;
            this.f4174f = Boolean.valueOf(z10);
        }
        x xVar2 = this.f4173c;
        xVar2.getClass();
        this.i = aVar;
        Integer num = xVar2.f4198g;
        if (num == null || num.intValue() != i) {
            xVar2.f4198g = Integer.valueOf(i);
            w.f4195a.a(xVar2, i);
        }
        e(j10, j11, f5);
        if (z10) {
            xVar2.setHotspot(c1.b.e(mVar.f14314a), c1.b.f(mVar.f14314a));
        } else {
            xVar2.setHotspot(xVar2.getBounds().centerX(), xVar2.getBounds().centerY());
        }
        setRippleState(true);
    }

    public final void c() {
        this.i = null;
        a4.t tVar = this.f4176h;
        if (tVar != null) {
            removeCallbacks(tVar);
            a4.t tVar2 = this.f4176h;
            tVar2.getClass();
            tVar2.run();
        } else {
            x xVar = this.f4173c;
            if (xVar != null) {
                xVar.setState(f4172k);
            }
        }
        x xVar2 = this.f4173c;
        if (xVar2 == null) {
            return;
        }
        xVar2.setVisible(false, false);
        unscheduleDrawable(xVar2);
    }

    public final void d() {
        setRippleState(false);
    }

    public final void e(long j10, long j11, float f5) {
        x xVar = this.f4173c;
        if (xVar == null) {
            return;
        }
        if (f5 > 1.0f) {
            f5 = 1.0f;
        }
        long jC = d1.p.c(f5, j11);
        d1.p pVar = xVar.f4197f;
        if (!(pVar == null ? false : d1.p.d(pVar.f3026a, jC))) {
            xVar.f4197f = d1.p.a(jC);
            xVar.setColor(ColorStateList.valueOf(f0.r(jC)));
        }
        Rect rect = new Rect(0, 0, ac.a.Q(c1.e.e(j10)), ac.a.Q(c1.e.c(j10)));
        setLeft(rect.left);
        setTop(rect.top);
        setRight(rect.right);
        setBottom(rect.bottom);
        xVar.setBounds(rect);
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        xb.a aVar = this.i;
        if (aVar != null) {
            aVar.invoke();
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i3) {
        setMeasuredDimension(0, 0);
    }

    @Override // android.view.View
    public final void refreshDrawableState() {
    }

    @Override // android.view.View
    public final void onLayout(boolean z10, int i, int i3, int i10, int i11) {
    }
}
