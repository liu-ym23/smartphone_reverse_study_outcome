package r3;

import W3.C0403n;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import java.util.Set;

/* loaded from: classes.dex */
public class o extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private j f20059a;

    /* renamed from: b, reason: collision with root package name */
    private final C1009e f20060b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f20061c;

    /* renamed from: d, reason: collision with root package name */
    private InterfaceC1005a f20062d;

    /* renamed from: e, reason: collision with root package name */
    private final Runnable f20063e;

    /* renamed from: f, reason: collision with root package name */
    private final C1012h f20064f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f20065g;

    /* renamed from: h, reason: collision with root package name */
    private float f20066h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f20067i;

    /* renamed from: j, reason: collision with root package name */
    private K2.o f20068j;

    /* renamed from: k, reason: collision with root package name */
    private Drawable f20069k;

    private final K2.o b() {
        Context context = getContext();
        j4.k.f(context, "getContext(...)");
        return C1013i.a(context) ? K2.o.f3626h.i() : K2.o.f3626h.k();
    }

    public final void a(InterfaceC1005a interfaceC1005a) {
        j4.k.g(interfaceC1005a, "customizer");
        this.f20062d = interfaceC1005a;
        d();
        e();
    }

    public final boolean c() {
        return this.f20060b.l();
    }

    protected void d() {
        this.f20060b.m();
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int actionMasked;
        j4.k.g(motionEvent, "ev");
        if (getForeground() != null && ((actionMasked = motionEvent.getActionMasked()) == 0 || actionMasked == 2)) {
            drawableHotspotChanged(motionEvent.getX(), motionEvent.getY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void drawableHotspotChanged(float f5, float f6) {
        super.drawableHotspotChanged(f5, f6);
        j jVar = this.f20059a;
        if (jVar != null) {
            jVar.c(f5, f6);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        j jVar = this.f20059a;
        if (jVar == null || !jVar.g()) {
            return;
        }
        invalidate();
    }

    protected void e() {
        if (this.f20065g && isAttachedToWindow() && !this.f20061c) {
            this.f20061c = true;
            post(this.f20063e);
        }
    }

    public final Set<String> getGlassActiveIds() {
        return C0403n.X(this.f20060b.j());
    }

    public final float getGlassCornerRadius() {
        return this.f20066h;
    }

    public final K2.o getGlassEffect() {
        K2.o oVar = this.f20068j;
        return oVar == null ? b() : oVar;
    }

    public final Drawable getSurfaceDrawable() {
        return this.f20069k;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        j jVar = this.f20059a;
        if (jVar != null) {
            jVar.d();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        e();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        j4.k.g(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        this.f20064f.c(configuration);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.f20063e);
        this.f20061c = false;
        this.f20064f.b();
        d();
        super.onDetachedFromWindow();
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        j jVar;
        j4.k.g(canvas, "canvas");
        if (!this.f20060b.l() && (jVar = this.f20059a) != null) {
            jVar.a(canvas);
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onRtlPropertiesChanged(int i5) {
        super.onRtlPropertiesChanged(i5);
        j jVar = this.f20059a;
        if (jVar != null) {
            jVar.h(i5);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i5, int i6, int i7, int i8) {
        super.onSizeChanged(i5, i6, i7, i8);
        e();
    }

    public final void setGlassCornerRadius(float f5) {
        if (f5 < 0.0f) {
            throw new IllegalArgumentException(("glassCornerRadius must be >= 0 but was " + f5).toString());
        }
        if (this.f20066h == f5) {
            return;
        }
        this.f20066h = f5;
        d();
        e();
    }

    public final void setGlassCrossWindow(boolean z5) {
        if (this.f20067i == z5) {
            return;
        }
        this.f20067i = z5;
        d();
        e();
    }

    public final void setGlassEffect(K2.o oVar) {
        j4.k.g(oVar, "value");
        boolean z5 = this.f20062d != null;
        this.f20062d = null;
        if (!j4.k.b(this.f20068j, oVar) || z5) {
            this.f20068j = oVar;
            d();
            e();
        }
    }

    public final void setGlassEnabled(boolean z5) {
        if (this.f20065g == z5) {
            return;
        }
        this.f20065g = z5;
        if (z5) {
            e();
        } else {
            d();
        }
    }

    public final void setSurfaceDrawable(Drawable drawable) {
        this.f20069k = drawable;
        j jVar = this.f20059a;
        if (jVar != null) {
            jVar.f(drawable);
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        j4.k.g(drawable, "who");
        j jVar = this.f20059a;
        return (jVar != null && jVar.i(drawable)) || super.verifyDrawable(drawable);
    }
}
