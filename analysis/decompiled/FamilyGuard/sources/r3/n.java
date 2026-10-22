package r3;

import W3.C0403n;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.C0446p;
import i4.InterfaceC0761a;
import i4.InterfaceC0772l;
import java.util.Set;
import l3.C0844b;

/* loaded from: classes.dex */
public class n extends C0446p {

    /* renamed from: t, reason: collision with root package name */
    private static final a f20036t = new a(null);

    /* renamed from: d, reason: collision with root package name */
    private j f20037d;

    /* renamed from: e, reason: collision with root package name */
    private final C1009e f20038e;

    /* renamed from: f, reason: collision with root package name */
    private b f20039f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f20040g;

    /* renamed from: h, reason: collision with root package name */
    private InterfaceC1005a f20041h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f20042i;

    /* renamed from: j, reason: collision with root package name */
    private final s3.e f20043j;

    /* renamed from: k, reason: collision with root package name */
    private int f20044k;

    /* renamed from: l, reason: collision with root package name */
    private final Runnable f20045l;

    /* renamed from: m, reason: collision with root package name */
    private final C1012h f20046m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f20047n;

    /* renamed from: o, reason: collision with root package name */
    private float f20048o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f20049p;

    /* renamed from: q, reason: collision with root package name */
    private K2.o f20050q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f20051r;

    /* renamed from: s, reason: collision with root package name */
    private Drawable f20052s;

    private static final class a {
        public /* synthetic */ a(j4.g gVar) {
            this();
        }

        private a() {
        }
    }

    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final int f20053a;

        /* renamed from: b, reason: collision with root package name */
        private final int f20054b;

        /* renamed from: c, reason: collision with root package name */
        private final float f20055c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f20056d;

        /* renamed from: e, reason: collision with root package name */
        private final K2.o f20057e;

        /* renamed from: f, reason: collision with root package name */
        private final InterfaceC1005a f20058f;

        public b(int i5, int i6, float f5, boolean z5, K2.o oVar, InterfaceC1005a interfaceC1005a) {
            j4.k.g(oVar, "effect");
            this.f20053a = i5;
            this.f20054b = i6;
            this.f20055c = f5;
            this.f20056d = z5;
            this.f20057e = oVar;
            this.f20058f = interfaceC1005a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f20053a == bVar.f20053a && this.f20054b == bVar.f20054b && Float.compare(this.f20055c, bVar.f20055c) == 0 && this.f20056d == bVar.f20056d && j4.k.b(this.f20057e, bVar.f20057e) && j4.k.b(this.f20058f, bVar.f20058f);
        }

        public int hashCode() {
            int iHashCode = ((((((((Integer.hashCode(this.f20053a) * 31) + Integer.hashCode(this.f20054b)) * 31) + Float.hashCode(this.f20055c)) * 31) + Boolean.hashCode(this.f20056d)) * 31) + this.f20057e.hashCode()) * 31;
            InterfaceC1005a interfaceC1005a = this.f20058f;
            return iHashCode + (interfaceC1005a == null ? 0 : interfaceC1005a.hashCode());
        }

        public String toString() {
            return "GlassRequest(width=" + this.f20053a + ", height=" + this.f20054b + ", radius=" + this.f20055c + ", crossWindow=" + this.f20056d + ", effect=" + this.f20057e + ", customizer=" + this.f20058f + ")";
        }
    }

    public /* synthetic */ n(Context context, AttributeSet attributeSet, int i5, int i6, int i7, j4.g gVar) {
        this(context, (i7 & 2) != 0 ? null : attributeSet, (i7 & 4) != 0 ? C0844b.f18284e : i5, (i7 & 8) != 0 ? l3.l.f18491n : i6);
    }

    private final void e() {
        if (!this.f20047n || getWidth() <= 0 || getHeight() <= 0 || getVisibility() == 8) {
            m();
            return;
        }
        float fI = i();
        final InterfaceC1005a interfaceC1005a = this.f20041h;
        b bVar = new b(getWidth(), getHeight(), fI, this.f20049p, getGlassEffect(), interfaceC1005a);
        if (j4.k.b(this.f20039f, bVar)) {
            return;
        }
        boolean z5 = this.f20049p;
        if (interfaceC1005a != null) {
            this.f20038e.h(z5 ? 1 : 0, fI, new InterfaceC0772l() { // from class: r3.m
                @Override // i4.InterfaceC0772l
                public final Object invoke(Object obj) {
                    return n.f(interfaceC1005a, (K2.A) obj);
                }
            });
        } else {
            this.f20038e.d(z5 ? 1 : 0, fI, getGlassEffect());
        }
        this.f20039f = bVar;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final K2.A f(InterfaceC1005a interfaceC1005a, K2.A a6) {
        j4.k.g(a6, "it");
        return interfaceC1005a.a(a6);
    }

    private final void g() {
        setImageAlpha(this.f20044k);
    }

    private final K2.o h() {
        Context context = getContext();
        j4.k.f(context, "getContext(...)");
        return C1013i.a(context) ? K2.o.f3626h.i() : K2.o.f3626h.k();
    }

    private final float i() {
        float f5 = this.f20048o;
        return f5 > 0.0f ? f5 : Math.min(getWidth(), getHeight()) / 2.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final V3.v j(n nVar) {
        nVar.m();
        nVar.n();
        return V3.v.f5542a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(n nVar) {
        nVar.f20040g = false;
        if (nVar.isAttachedToWindow()) {
            nVar.e();
        }
    }

    private final void m() {
        this.f20038e.m();
        this.f20039f = null;
        invalidate();
    }

    private final void n() {
        if (this.f20047n && isAttachedToWindow() && !this.f20040g) {
            this.f20040g = true;
            post(this.f20045l);
        }
    }

    public final void d(InterfaceC1005a interfaceC1005a) {
        j4.k.g(interfaceC1005a, "customizer");
        this.f20041h = interfaceC1005a;
        m();
        n();
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableHotspotChanged(float f5, float f6) {
        super.drawableHotspotChanged(f5, f6);
        j jVar = this.f20037d;
        if (jVar != null) {
            jVar.c(f5, f6);
        }
        Drawable foreground = getForeground();
        if (foreground != null) {
            foreground.setHotspot(f5, f6);
        }
    }

    @Override // androidx.appcompat.widget.C0446p, android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        j jVar = this.f20037d;
        if (jVar == null || !jVar.g()) {
            return;
        }
        invalidate();
    }

    public final Set<String> getGlassActiveIds() {
        return C0403n.X(this.f20038e.j());
    }

    public final float getGlassCornerRadius() {
        return this.f20048o;
    }

    public final K2.o getGlassEffect() {
        K2.o oVar = this.f20050q;
        return oVar == null ? h() : oVar;
    }

    public final Drawable getSurfaceDrawable() {
        return this.f20052s;
    }

    @Override // android.widget.ImageView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        j jVar = this.f20037d;
        if (jVar != null) {
            jVar.d();
        }
    }

    public final boolean k() {
        return this.f20038e.l();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f20051r) {
            this.f20043j.d();
        }
        n();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        j4.k.g(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        this.f20046m.c(configuration);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.f20045l);
        this.f20040g = false;
        this.f20046m.b();
        this.f20043j.o();
        m();
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        j jVar;
        j4.k.g(canvas, "canvas");
        if (!this.f20038e.l() && (jVar = this.f20037d) != null) {
            jVar.a(canvas);
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onRtlPropertiesChanged(int i5) {
        super.onRtlPropertiesChanged(i5);
        j jVar = this.f20037d;
        if (jVar != null) {
            jVar.h(i5);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i5, int i6, int i7, int i8) {
        super.onSizeChanged(i5, i6, i7, i8);
        n();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        j4.k.g(motionEvent, "event");
        if (this.f20042i && this.f20051r && isEnabled()) {
            this.f20043j.k(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setEnabled(boolean z5) {
        super.setEnabled(z5);
        this.f20044k = z5 ? 255 : 77;
        g();
        if (!this.f20042i || z5) {
            return;
        }
        this.f20043j.o();
    }

    public final void setGlassCornerRadius(float f5) {
        if (f5 < 0.0f) {
            throw new IllegalArgumentException(("glassCornerRadius must be >= 0 but was " + f5).toString());
        }
        if (this.f20048o == f5) {
            return;
        }
        this.f20048o = f5;
        m();
        n();
    }

    public final void setGlassCrossWindow(boolean z5) {
        if (this.f20049p == z5) {
            return;
        }
        this.f20049p = z5;
        m();
        n();
    }

    public final void setGlassEffect(K2.o oVar) {
        j4.k.g(oVar, "value");
        boolean z5 = this.f20041h != null;
        this.f20041h = null;
        if (!j4.k.b(this.f20050q, oVar) || z5) {
            this.f20050q = oVar;
            m();
            n();
        }
    }

    public final void setGlassEnabled(boolean z5) {
        if (this.f20047n == z5) {
            return;
        }
        this.f20047n = z5;
        if (z5) {
            n();
        } else {
            m();
        }
    }

    @Override // androidx.appcompat.widget.C0446p, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        g();
    }

    public final void setPressScaleEnabled(boolean z5) {
        if (this.f20051r == z5) {
            return;
        }
        this.f20051r = z5;
        if (!z5) {
            this.f20043j.o();
        }
        if (z5 && isAttachedToWindow()) {
            this.f20043j.d();
        }
    }

    public final void setSurfaceDrawable(Drawable drawable) {
        this.f20052s = drawable;
        j jVar = this.f20037d;
        if (jVar != null) {
            jVar.f(drawable);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        j4.k.g(drawable, "who");
        j jVar = this.f20037d;
        return (jVar != null && jVar.i(drawable)) || super.verifyDrawable(drawable);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(Context context, AttributeSet attributeSet, int i5, int i6) {
        super(context, attributeSet, i5);
        j4.k.g(context, "context");
        this.f20038e = new C1009e(this);
        this.f20043j = new s3.e(this);
        this.f20044k = 255;
        this.f20045l = new Runnable() { // from class: r3.k
            @Override // java.lang.Runnable
            public final void run() {
                n.l(this.f20033a);
            }
        };
        this.f20046m = new C1012h(this, new InterfaceC0761a() { // from class: r3.l
            @Override // i4.InterfaceC0761a
            public final Object invoke() {
                return n.j(this.f20034a);
            }
        });
        this.f20047n = true;
        this.f20051r = true;
        this.f20037d = new j(this);
        setBackground(null);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l3.m.f18497A1, i5, i6);
        j4.k.f(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        K2.o oVarB = C1010f.f20022a.b(typedArrayObtainStyledAttributes, l3.m.f18509C1);
        if (oVarB != null) {
            setGlassEffect(oVarB);
        }
        setGlassEnabled(typedArrayObtainStyledAttributes.getBoolean(l3.m.f18515D1, true));
        setGlassCrossWindow(typedArrayObtainStyledAttributes.getBoolean(l3.m.f18503B1, false));
        setPressScaleEnabled(typedArrayObtainStyledAttributes.getBoolean(l3.m.f18521E1, true));
        V3.v vVar = V3.v.f5542a;
        typedArrayObtainStyledAttributes.recycle();
        this.f20044k = isEnabled() ? 255 : 77;
        g();
        this.f20042i = true;
    }
}
