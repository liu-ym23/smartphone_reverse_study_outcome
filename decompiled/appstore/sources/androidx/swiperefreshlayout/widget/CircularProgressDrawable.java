package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.RestrictTo;
import androidx.core.util.e;
import com.ttnet.org.chromium.net.PrivateKeyType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public class CircularProgressDrawable extends Drawable implements Animatable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Interpolator f4821g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Interpolator f4822h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int[] f4823i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f4824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f4825b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Resources f4826c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Animator f4827d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f4828e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f4829f;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface ProgressDrawableSize {
    }

    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f4830a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CircularProgressDrawable f4831b;

        public a(CircularProgressDrawable r10, c r11) {
            this.f4831b = r10;
            this.f4830a = r11;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator r10) {
            float r11 = ((Float) r10.getAnimatedValue()).floatValue();
            this.f4831b.n(r11, this.f4830a);
            this.f4831b.b(r11, this.f4830a, false);
            this.f4831b.invalidateSelf();
        }
    }

    public class b implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f4832a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ CircularProgressDrawable f4833b;

        public b(CircularProgressDrawable r10, c r11) {
            this.f4833b = r10;
            this.f4832a = r11;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r10) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator r10) {
            this.f4833b.b(1.0f, this.f4832a, true);
            this.f4832a.A();
            this.f4832a.l();
            CircularProgressDrawable r11 = this.f4833b;
            if (r11.f4829f == false) goto L5;
            r11.f4829f = false;
            r10.cancel();
            r10.setDuration(1332);
            r10.start();
            this.f4832a.x(false);
            return;
        L5:
            r11.f4828e += 1.0f;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10) {
            this.f4833b.f4828e = 0.0f;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RectF f4834a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Paint f4835b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Paint f4836c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Paint f4837d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f4838e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f4839f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f4840g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f4841h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int[] f4842i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f4843j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f4844k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public float f4845l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public float f4846m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f4847n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public Path f4848o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public float f4849p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public float f4850q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f4851r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f4852s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f4853t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f4854u;

        public c() {
            this.f4834a = new RectF();
            Paint r10 = new Paint();
            this.f4835b = r10;
            Paint r11 = new Paint();
            this.f4836c = r11;
            Paint r12 = new Paint();
            this.f4837d = r12;
            this.f4838e = 0.0f;
            this.f4839f = 0.0f;
            this.f4840g = 0.0f;
            this.f4841h = 5.0f;
            this.f4849p = 1.0f;
            this.f4853t = PrivateKeyType.INVALID;
            r10.setStrokeCap(Paint.Cap.SQUARE);
            r10.setAntiAlias(true);
            r10.setStyle(Paint.Style.STROKE);
            r11.setStyle(Paint.Style.FILL);
            r11.setAntiAlias(true);
            r12.setColor(0);
        }

        public void A() {
            this.f4844k = this.f4838e;
            this.f4845l = this.f4839f;
            this.f4846m = this.f4840g;
        }

        public void a(Canvas r10, Rect r11) {
            RectF r12 = this.f4834a;
            float r13 = this.f4850q;
            float r14 = (this.f4841h / 2.0f) + r13;
            if (r13 > 0.0f) goto L5;
            r14 = (Math.min(r11.width(), r11.height()) / 2.0f) - Math.max((this.f4851r * this.f4849p) / 2.0f, this.f4841h / 2.0f);
        L5:
            r12.set(r11.centerX() - r14, r11.centerY() - r14, r11.centerX() + r14, r11.centerY() + r14);
            float r15 = this.f4838e;
            float r16 = this.f4840g;
            float r17 = (r15 + r16) * 360.0f;
            float r18 = ((this.f4839f + r16) * 360.0f) - r17;
            this.f4835b.setColor(this.f4854u);
            this.f4835b.setAlpha(this.f4853t);
            float r19 = this.f4841h / 2.0f;
            r12.inset(r19, r19);
            r10.drawCircle(r12.centerX(), r12.centerY(), r12.width() / 2.0f, this.f4837d);
            float r20 = -r19;
            r12.inset(r20, r20);
            r10.drawArc(r12, r17, r18, false, this.f4835b);
            b(r10, r17, r18, r12);
        }

        public void b(Canvas r10, float r11, float r12, RectF r13) {
            if (this.f4847n == false) goto L10;
            Path r14 = this.f4848o;
            if (r14 != null) goto L7;
            Path r15 = new Path();
            this.f4848o = r15;
            r15.setFillType(Path.FillType.EVEN_ODD);
        L8:
            float r16 = Math.min(r13.width(), r13.height()) / 2.0f;
            float r17 = (this.f4851r * this.f4849p) / 2.0f;
            this.f4848o.moveTo(0.0f, 0.0f);
            this.f4848o.lineTo(this.f4851r * this.f4849p, 0.0f);
            Path r18 = this.f4848o;
            float r19 = this.f4851r;
            float r20 = this.f4849p;
            r18.lineTo((r19 * r20) / 2.0f, this.f4852s * r20);
            this.f4848o.offset((r16 + r13.centerX()) - r17, r13.centerY() + (this.f4841h / 2.0f));
            this.f4848o.close();
            this.f4836c.setColor(this.f4854u);
            this.f4836c.setAlpha(this.f4853t);
            r10.save();
            r10.rotate(r11 + r12, r13.centerX(), r13.centerY());
            r10.drawPath(this.f4848o, this.f4836c);
            r10.restore();
            return;
        L7:
            r14.reset();
            goto L8
        }

        public int c() {
            return this.f4853t;
        }

        public float d() {
            return this.f4839f;
        }

        public int e() {
            return this.f4842i[f()];
        }

        public int f() {
            return (this.f4843j + 1) % this.f4842i.length;
        }

        public float g() {
            return this.f4838e;
        }

        public int h() {
            return this.f4842i[this.f4843j];
        }

        public float i() {
            return this.f4845l;
        }

        public float j() {
            return this.f4846m;
        }

        public float k() {
            return this.f4844k;
        }

        public void l() {
            t(f());
        }

        public void m() {
            this.f4844k = 0.0f;
            this.f4845l = 0.0f;
            this.f4846m = 0.0f;
            y(0.0f);
            v(0.0f);
            w(0.0f);
        }

        public void n(int r10) {
            this.f4853t = r10;
        }

        public void o(float r10, float r11) {
            this.f4851r = (int) r10;
            this.f4852s = (int) r11;
        }

        public void p(float r10) {
            if (r10 == this.f4849p) goto L6;
            this.f4849p = r10;
            return;
        }

        public void q(float r10) {
            this.f4850q = r10;
        }

        public void r(int r10) {
            this.f4854u = r10;
        }

        public void s(ColorFilter r10) {
            this.f4835b.setColorFilter(r10);
        }

        public void t(int r10) {
            this.f4843j = r10;
            this.f4854u = this.f4842i[r10];
        }

        public void u(int[] r10) {
            this.f4842i = r10;
            t(0);
        }

        public void v(float r10) {
            this.f4839f = r10;
        }

        public void w(float r10) {
            this.f4840g = r10;
        }

        public void x(boolean r10) {
            if (this.f4847n == r10) goto L6;
            this.f4847n = r10;
            return;
        }

        public void y(float r10) {
            this.f4838e = r10;
        }

        public void z(float r10) {
            this.f4841h = r10;
            this.f4835b.setStrokeWidth(r10);
        }
    }

    static {
        f4821g = new LinearInterpolator();
        f4822h = new x.b();
        f4823i = new int[]{-16777216};
    }

    public CircularProgressDrawable(Context r10) {
        this.f4826c = ((Context) e.g(r10)).getResources();
        c r11 = new c();
        this.f4824a = r11;
        r11.u(f4823i);
        k(2.5f);
        m();
    }

    public final void a(float r10, c r11) {
        n(r10, r11);
        float r12 = (float) (Math.floor(r11.j() / 0.8f) + 1.0d);
        r11.y(r11.k() + (((r11.i() - 0.01f) - r11.k()) * r10));
        r11.v(r11.i());
        r11.w(r11.j() + ((r12 - r11.j()) * r10));
    }

    public void b(float r10, c r11, boolean r12) {
        if (this.f4829f == false) goto L6;
        a(r10, r11);
        return;
    L6:
        if (r10 != 1.0f) goto L8;
        if (r12 == true) goto L8;
        return;
    L8:
        float r13 = r11.j();
        if (r10 >= 0.5f) goto L11;
        float r14 = r11.k();
        Interpolator r15 = f4822h;
        float r16 = ((r15.getInterpolation(r10 / 0.5f) * 0.79f) + 0.01f) + r14;
    L12:
        float r17 = r13 + (0.20999998f * r10);
        float r18 = (r10 + this.f4828e) * 216.0f;
        r11.y(r14);
        r11.v(r16);
        r11.w(r17);
        h(r18);
        return;
    L11:
        float r19 = r11.k() + 0.79f;
        Interpolator r20 = f4822h;
        r14 = r19 - (((1.0f - r20.getInterpolation((r10 - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
        r16 = r19;
        goto L12
    }

    public final int c(float r10, int r11, int r12) {
        int r13 = (r11 >> 24) & PrivateKeyType.INVALID;
        int r14 = (r11 >> 16) & PrivateKeyType.INVALID;
        int r15 = (r11 >> 8) & PrivateKeyType.INVALID;
        int r16 = r11 & PrivateKeyType.INVALID;
        return ((((r13 + ((int) ((((r12 >> 24) & PrivateKeyType.INVALID) - r13) * r10))) << 24) | ((r14 + ((int) ((((r12 >> 16) & PrivateKeyType.INVALID) - r14) * r10))) << 16)) | ((r15 + ((int) ((((r12 >> 8) & PrivateKeyType.INVALID) - r15) * r10))) << 8)) | (r16 + ((int) (r10 * ((r12 & PrivateKeyType.INVALID) - r16))));
    }

    public void d(boolean r10) {
        this.f4824a.x(r10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas r10) {
        Rect r11 = getBounds();
        r10.save();
        r10.rotate(this.f4825b, r11.exactCenterX(), r11.exactCenterY());
        this.f4824a.a(r10, r11);
        r10.restore();
    }

    public void e(float r10) {
        this.f4824a.p(r10);
        invalidateSelf();
    }

    public void f(int... r10) {
        this.f4824a.u(r10);
        this.f4824a.t(0);
        invalidateSelf();
    }

    public void g(float r10) {
        this.f4824a.w(r10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f4824a.c();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public final void h(float r10) {
        this.f4825b = r10;
    }

    public final void i(float r10, float r11, float r12, float r13) {
        c r14 = this.f4824a;
        float r15 = this.f4826c.getDisplayMetrics().density;
        r14.z(r11 * r15);
        r14.q(r10 * r15);
        r14.t(0);
        r14.o(r12 * r15, r13 * r15);
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f4827d.isRunning();
    }

    public void j(float r10, float r11) {
        this.f4824a.y(r10);
        this.f4824a.v(r11);
        invalidateSelf();
    }

    public void k(float r10) {
        this.f4824a.z(r10);
        invalidateSelf();
    }

    public void l(int r10) {
        if (r10 != 0) goto L4;
        i(11.0f, 3.0f, 12.0f, 6.0f);
    L5:
        invalidateSelf();
        return;
    L4:
        i(7.5f, 2.5f, 10.0f, 5.0f);
        goto L5
    }

    public final void m() {
        c r10 = this.f4824a;
        ValueAnimator r11 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r11.addUpdateListener(new a(this, r10));
        r11.setRepeatCount(-1);
        r11.setRepeatMode(1);
        r11.setInterpolator(f4821g);
        r11.addListener(new b(this, r10));
        this.f4827d = r11;
    }

    public void n(float r10, c r11) {
        if (r10 <= 0.75f) goto L5;
        r11.r(c((r10 - 0.75f) / 0.25f, r11.h(), r11.e()));
        return;
    L5:
        r11.r(r11.h());
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r10) {
        this.f4824a.n(r10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r10) {
        this.f4824a.s(r10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f4827d.cancel();
        this.f4824a.A();
        if (this.f4824a.d() == this.f4824a.g()) goto L5;
        this.f4829f = true;
        this.f4827d.setDuration(666);
        this.f4827d.start();
        return;
    L5:
        this.f4824a.t(0);
        this.f4824a.m();
        this.f4827d.setDuration(1332);
        this.f4827d.start();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f4827d.cancel();
        h(0.0f);
        this.f4824a.x(false);
        this.f4824a.t(0);
        this.f4824a.m();
        invalidateSelf();
    }
}
