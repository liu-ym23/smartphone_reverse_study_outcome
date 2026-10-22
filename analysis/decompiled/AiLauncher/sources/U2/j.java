package U2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.Property;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class j extends Drawable implements Animatable {

    /* renamed from: q, reason: collision with root package name */
    public static final Property<j, Float> f6246q = new c(Float.class, "growFraction");

    /* renamed from: a, reason: collision with root package name */
    public final Context f6247a;

    /* renamed from: b, reason: collision with root package name */
    public final U2.b f6248b;

    /* renamed from: d, reason: collision with root package name */
    public ValueAnimator f6250d;

    /* renamed from: e, reason: collision with root package name */
    public ValueAnimator f6251e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f6252f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f6253g;

    /* renamed from: h, reason: collision with root package name */
    public float f6254h;

    /* renamed from: j, reason: collision with root package name */
    public List<q1.b> f6256j;

    /* renamed from: k, reason: collision with root package name */
    public q1.b f6257k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f6258l;

    /* renamed from: m, reason: collision with root package name */
    public float f6259m;

    /* renamed from: o, reason: collision with root package name */
    public int f6261o;

    /* renamed from: i, reason: collision with root package name */
    public float f6255i = -1.0f;

    /* renamed from: n, reason: collision with root package name */
    public final Paint f6260n = new Paint();

    /* renamed from: p, reason: collision with root package name */
    public Rect f6262p = new Rect();

    /* renamed from: c, reason: collision with root package name */
    public U2.a f6249c = new U2.a();

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            j.this.f();
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            j.super.setVisible(false, false);
            j.this.e();
        }
    }

    public class c extends Property<j, Float> {
        public c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(j jVar) {
            return Float.valueOf(jVar.h());
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(j jVar, Float f10) {
            jVar.p(f10.floatValue());
        }
    }

    public j(Context context, U2.b bVar) {
        this.f6247a = context;
        this.f6248b = bVar;
        setAlpha(255);
    }

    public final void d(ValueAnimator... valueAnimatorArr) {
        boolean z10 = this.f6258l;
        this.f6258l = true;
        for (ValueAnimator valueAnimator : valueAnimatorArr) {
            valueAnimator.cancel();
        }
        this.f6258l = z10;
    }

    public final void e() {
        q1.b bVar = this.f6257k;
        if (bVar != null) {
            bVar.b(this);
        }
        List<q1.b> list = this.f6256j;
        if (list == null || this.f6258l) {
            return;
        }
        Iterator<q1.b> it = list.iterator();
        while (it.hasNext()) {
            it.next().b(this);
        }
    }

    public final void f() {
        q1.b bVar = this.f6257k;
        if (bVar != null) {
            bVar.c(this);
        }
        List<q1.b> list = this.f6256j;
        if (list == null || this.f6258l) {
            return;
        }
        Iterator<q1.b> it = list.iterator();
        while (it.hasNext()) {
            it.next().c(this);
        }
    }

    public final void g(ValueAnimator... valueAnimatorArr) {
        boolean z10 = this.f6258l;
        this.f6258l = true;
        for (ValueAnimator valueAnimator : valueAnimatorArr) {
            valueAnimator.end();
        }
        this.f6258l = z10;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f6261o;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public float h() {
        if (this.f6248b.d() || this.f6248b.c()) {
            return (this.f6253g || this.f6252f) ? this.f6254h : this.f6259m;
        }
        return 1.0f;
    }

    public float i() {
        float f10 = this.f6255i;
        if (f10 > 0.0f) {
            return f10;
        }
        if (this.f6248b.b(k()) && this.f6248b.f6182m != 0) {
            float fA = this.f6249c.a(this.f6247a.getContentResolver());
            if (fA > 0.0f) {
                float fUptimeMillis = (SystemClock.uptimeMillis() % r6) / ((int) ((((k() ? this.f6248b.f6179j : this.f6248b.f6180k) * 1000.0f) / this.f6248b.f6182m) * fA));
                return fUptimeMillis < 0.0f ? (fUptimeMillis % 1.0f) + 1.0f : fUptimeMillis;
            }
        }
        return 0.0f;
    }

    public boolean isRunning() {
        return m() || l();
    }

    public boolean j() {
        return s(false, false, false);
    }

    public final boolean k() {
        return this instanceof i;
    }

    public boolean l() {
        ValueAnimator valueAnimator = this.f6251e;
        return (valueAnimator != null && valueAnimator.isRunning()) || this.f6253g;
    }

    public boolean m() {
        ValueAnimator valueAnimator = this.f6250d;
        return (valueAnimator != null && valueAnimator.isRunning()) || this.f6252f;
    }

    public final void n() {
        if (this.f6250d == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, f6246q, 0.0f, 1.0f);
            this.f6250d = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(500L);
            this.f6250d.setInterpolator(E2.a.f2340b);
            r(this.f6250d);
        }
        if (this.f6251e == null) {
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this, f6246q, 1.0f, 0.0f);
            this.f6251e = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setDuration(500L);
            this.f6251e.setInterpolator(E2.a.f2340b);
            q(this.f6251e);
        }
    }

    public void o(q1.b bVar) {
        if (this.f6256j == null) {
            this.f6256j = new ArrayList();
        }
        if (this.f6256j.contains(bVar)) {
            return;
        }
        this.f6256j.add(bVar);
    }

    public void p(float f10) {
        if (this.f6259m != f10) {
            this.f6259m = f10;
            invalidateSelf();
        }
    }

    public final void q(ValueAnimator valueAnimator) {
        ValueAnimator valueAnimator2 = this.f6251e;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            throw new IllegalArgumentException("Cannot set hideAnimator while the current hideAnimator is running.");
        }
        this.f6251e = valueAnimator;
        valueAnimator.addListener(new b());
    }

    public final void r(ValueAnimator valueAnimator) {
        ValueAnimator valueAnimator2 = this.f6250d;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            throw new IllegalArgumentException("Cannot set showAnimator while the current showAnimator is running.");
        }
        this.f6250d = valueAnimator;
        valueAnimator.addListener(new a());
    }

    public boolean s(boolean z10, boolean z11, boolean z12) {
        return t(z10, z11, z12 && this.f6249c.a(this.f6247a.getContentResolver()) > 0.0f);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f6261o = i10;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f6260n.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        return s(z10, z11, true);
    }

    public void start() {
        t(true, true, false);
    }

    public void stop() {
        t(false, true, false);
    }

    public boolean t(boolean z10, boolean z11, boolean z12) {
        n();
        if (!isVisible() && !z10) {
            return false;
        }
        ValueAnimator valueAnimator = z10 ? this.f6250d : this.f6251e;
        ValueAnimator valueAnimator2 = z10 ? this.f6251e : this.f6250d;
        if (!z12) {
            if (valueAnimator2.isRunning()) {
                d(valueAnimator2);
            }
            if (valueAnimator.isRunning()) {
                valueAnimator.end();
            } else {
                g(valueAnimator);
            }
            return super.setVisible(z10, false);
        }
        if (valueAnimator.isRunning()) {
            return false;
        }
        boolean z13 = !z10 || super.setVisible(z10, false);
        if (!(z10 ? this.f6248b.d() : this.f6248b.c())) {
            g(valueAnimator);
            return z13;
        }
        if (z11 || !valueAnimator.isPaused()) {
            valueAnimator.start();
            return z13;
        }
        valueAnimator.resume();
        return z13;
    }

    public boolean u(q1.b bVar) {
        List<q1.b> list = this.f6256j;
        if (list == null || !list.contains(bVar)) {
            return false;
        }
        this.f6256j.remove(bVar);
        if (!this.f6256j.isEmpty()) {
            return true;
        }
        this.f6256j = null;
        return true;
    }
}
