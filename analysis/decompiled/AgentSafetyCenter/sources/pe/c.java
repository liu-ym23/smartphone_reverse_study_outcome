package pe;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.animation.PathInterpolator;
import java.lang.invoke.VarHandle;
import java.lang.ref.WeakReference;
import stepos.support.v7.widget.n;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public abstract class c extends Drawable {

    /* renamed from: s, reason: collision with root package name */
    public static final PathInterpolator f10045s = new PathInterpolator(0.0f, 0.0f, 0.1f, 1.0f);

    /* renamed from: t, reason: collision with root package name */
    public static final PathInterpolator f10046t = new PathInterpolator(0.66f, 0.0f, 0.67f, 1.0f);

    /* renamed from: a, reason: collision with root package name */
    public WeakReference f10047a;

    /* renamed from: b, reason: collision with root package name */
    public Paint f10048b;

    /* renamed from: c, reason: collision with root package name */
    public Paint f10049c;

    /* renamed from: d, reason: collision with root package name */
    public int f10050d;

    /* renamed from: e, reason: collision with root package name */
    public int f10051e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f10052f;

    /* renamed from: g, reason: collision with root package name */
    public int f10053g;

    /* renamed from: h, reason: collision with root package name */
    public int f10054h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public int f10055j;

    /* renamed from: k, reason: collision with root package name */
    public int f10056k;

    /* renamed from: l, reason: collision with root package name */
    public int f10057l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f10058m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f10059n;

    /* renamed from: o, reason: collision with root package name */
    public ValueAnimator f10060o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f10061p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f10062q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f10063r;

    public static void a(n nVar) {
        View view = (View) nVar.f10047a.get();
        if (view == null) {
            return;
        }
        nVar.f10054h = view.getWidth();
        nVar.i = view.getHeight();
        new Rect(0, 0, nVar.f10054h, nVar.i);
        if (nVar.f10053g <= 0) {
            nVar.f10053g = ((int) Math.hypot(nVar.f10054h, nVar.i)) / 2;
        }
        if (nVar.f10051e < 0) {
            nVar.f10051e = (int) (nVar.f10053g * 0.825f);
        }
    }

    public final void b() {
        ValueAnimator valueAnimator = this.f10060o;
        if (valueAnimator != null && (valueAnimator.isStarted() || this.f10060o.isRunning())) {
            this.f10060o.cancel();
        }
        this.f10048b.setAlpha(this.f10057l);
        this.f10052f = true;
        int i = this.f10053g;
        this.f10050d = i;
        int i3 = this.f10051e;
        float f5 = i3 / i;
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i, i3);
        this.f10060o = valueAnimatorOfInt;
        b bVar = new b();
        bVar.f10044b = this;
        bVar.f10043a = f5;
        VarHandle.storeStoreFence();
        valueAnimatorOfInt.addUpdateListener(bVar);
        this.f10060o.setDuration(this.f10056k);
        this.f10060o.setInterpolator(f10046t);
        this.f10060o.start();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        if (Build.MODEL.equals("vivo X3t")) {
            int i = this.f10053g;
            int i3 = (this.f10054h / 2) + i;
            int i10 = (this.i / 2) + i;
            setBounds(-i3, -i10, i3, i10);
        }
        if (this.f10052f || this.f10059n) {
            if (this.f10061p) {
                canvas.drawCircle(this.f10054h / 2, this.i / 2, this.f10053g, this.f10049c);
            }
            canvas.drawCircle(this.f10054h / 2, this.i / 2, this.f10050d, this.f10048b);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return this.f10057l;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        int i;
        boolean zOnStateChange = super.onStateChange(iArr);
        int length = iArr.length;
        int i3 = 0;
        boolean z10 = false;
        boolean z11 = false;
        while (true) {
            i = 1;
            if (i3 >= length) {
                break;
            }
            int i10 = iArr[i3];
            if (i10 == 16842910) {
                z10 = true;
            }
            if (i10 == 16842919) {
                z11 = true;
            }
            i3++;
        }
        if (!z10 || !z11) {
            if (this.f10059n) {
                this.f10059n = false;
                invalidateSelf();
                if (!this.f10052f && this.f10062q) {
                    b();
                }
            }
            return zOnStateChange;
        }
        this.f10059n = true;
        ValueAnimator valueAnimator = this.f10060o;
        if (valueAnimator != null && (valueAnimator.isStarted() || this.f10060o.isRunning())) {
            this.f10060o.cancel();
        }
        this.f10048b.setAlpha(this.f10057l);
        this.f10049c.setAlpha(this.f10057l / 2);
        this.f10052f = true;
        int i11 = this.f10051e;
        this.f10050d = i11;
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i11, this.f10053g);
        this.f10060o = valueAnimatorOfInt;
        com.stepos.common.widget.b bVar = new com.stepos.common.widget.b(i);
        bVar.f2663b = this;
        VarHandle.storeStoreFence();
        valueAnimatorOfInt.addUpdateListener(bVar);
        this.f10060o.setDuration(this.f10055j);
        this.f10060o.setInterpolator(f10045s);
        this.f10060o.start();
        return zOnStateChange;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        this.f10057l = i;
        this.f10048b.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f10048b.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setBounds(Rect rect) {
    }
}
