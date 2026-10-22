package com.stepos.widget.button;

import K2.A;
import K2.o;
import V3.v;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import androidx.appcompat.widget.D;
import com.stepos.widget.button.StepOSButton;
import g4.C0743a;
import i4.InterfaceC0761a;
import i4.InterfaceC0772l;
import j4.g;
import j4.k;
import l3.C0844b;
import l3.l;
import l3.m;
import r3.C1009e;
import r3.C1010f;
import r3.C1012h;
import r3.InterfaceC1005a;
import r3.j;

/* loaded from: classes.dex */
public class StepOSButton extends D {

    /* renamed from: r, reason: collision with root package name */
    private static final a f16072r = new a(null);

    /* renamed from: h, reason: collision with root package name */
    private j f16073h;

    /* renamed from: i, reason: collision with root package name */
    private final C1009e f16074i;

    /* renamed from: j, reason: collision with root package name */
    private b f16075j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f16076k;

    /* renamed from: l, reason: collision with root package name */
    private InterfaceC1005a f16077l;

    /* renamed from: m, reason: collision with root package name */
    private final Runnable f16078m;

    /* renamed from: n, reason: collision with root package name */
    private final C1012h f16079n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f16080o;

    /* renamed from: p, reason: collision with root package name */
    private o f16081p;

    /* renamed from: q, reason: collision with root package name */
    private Drawable f16082q;

    private static final class a {
        public /* synthetic */ a(g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Context b(Context context, int i5) {
            return i5 == 0 ? context : new ContextThemeWrapper(context, i5);
        }

        private a() {
        }
    }

    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final int f16083a;

        /* renamed from: b, reason: collision with root package name */
        private final int f16084b;

        /* renamed from: c, reason: collision with root package name */
        private final float f16085c;

        /* renamed from: d, reason: collision with root package name */
        private final o f16086d;

        /* renamed from: e, reason: collision with root package name */
        private final InterfaceC1005a f16087e;

        public b(int i5, int i6, float f5, o oVar, InterfaceC1005a interfaceC1005a) {
            k.g(oVar, "effect");
            this.f16083a = i5;
            this.f16084b = i6;
            this.f16085c = f5;
            this.f16086d = oVar;
            this.f16087e = interfaceC1005a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f16083a == bVar.f16083a && this.f16084b == bVar.f16084b && Float.compare(this.f16085c, bVar.f16085c) == 0 && k.b(this.f16086d, bVar.f16086d) && k.b(this.f16087e, bVar.f16087e);
        }

        public int hashCode() {
            int iHashCode = ((((((Integer.hashCode(this.f16083a) * 31) + Integer.hashCode(this.f16084b)) * 31) + Float.hashCode(this.f16085c)) * 31) + this.f16086d.hashCode()) * 31;
            InterfaceC1005a interfaceC1005a = this.f16087e;
            return iHashCode + (interfaceC1005a == null ? 0 : interfaceC1005a.hashCode());
        }

        public String toString() {
            return "GlassRequest(width=" + this.f16083a + ", height=" + this.f16084b + ", radius=" + this.f16085c + ", effect=" + this.f16086d + ", customizer=" + this.f16087e + ")";
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        k.g(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(StepOSButton stepOSButton) {
        stepOSButton.f16076k = false;
        if (stepOSButton.isAttachedToWindow()) {
            stepOSButton.x();
        }
    }

    private final void C() {
        this.f16074i.m();
        this.f16075j = null;
    }

    private final void D() {
        if (A() && isAttachedToWindow() && !this.f16076k) {
            this.f16076k = true;
            post(this.f16078m);
        }
    }

    private final void w() {
        setAlpha(isEnabled() ? 1.0f : 0.3f);
    }

    private final void x() {
        if (!A() || getWidth() <= 0 || getHeight() <= 0 || getVisibility() == 8) {
            C();
            return;
        }
        float fMin = Math.min(getWidth(), getHeight()) / 2.0f;
        final InterfaceC1005a interfaceC1005a = this.f16077l;
        b bVar = new b(getWidth(), getHeight(), fMin, getGlassEffect(), interfaceC1005a);
        if (k.b(this.f16075j, bVar)) {
            return;
        }
        if (interfaceC1005a != null) {
            this.f16074i.h(0, fMin, new InterfaceC0772l() { // from class: m3.c
                @Override // i4.InterfaceC0772l
                public final Object invoke(Object obj) {
                    return StepOSButton.y(interfaceC1005a, (A) obj);
                }
            });
        } else {
            this.f16074i.d(0, fMin, getGlassEffect());
        }
        this.f16075j = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final A y(InterfaceC1005a interfaceC1005a, A a6) {
        k.g(a6, "it");
        return interfaceC1005a.a(a6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final v z(StepOSButton stepOSButton) {
        stepOSButton.C();
        stepOSButton.D();
        return v.f5542a;
    }

    public boolean A() {
        return this.f16080o;
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float f5, float f6) {
        super.drawableHotspotChanged(f5, f6);
        j jVar = this.f16073h;
        if (jVar != null) {
            jVar.c(f5, f6);
        }
    }

    @Override // androidx.appcompat.widget.D, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        j jVar = this.f16073h;
        if (jVar == null || !jVar.g()) {
            return;
        }
        invalidate();
    }

    public o getGlassEffect() {
        return this.f16081p;
    }

    public Drawable getSurfaceDrawable() {
        return this.f16082q;
    }

    @Override // android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        j jVar = this.f16073h;
        if (jVar != null) {
            jVar.d();
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        D();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        k.g(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        this.f16079n.c(configuration);
    }

    @Override // androidx.appcompat.widget.D, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.f16078m);
        this.f16076k = false;
        this.f16079n.b();
        C();
        super.onDetachedFromWindow();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        k.g(canvas, "canvas");
        j jVar = this.f16073h;
        if (jVar != null) {
            jVar.a(canvas);
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        k.g(accessibilityNodeInfo, "info");
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRtlPropertiesChanged(int i5) {
        super.onRtlPropertiesChanged(i5);
        j jVar = this.f16073h;
        if (jVar != null) {
            jVar.h(i5);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i5, int i6, int i7, int i8) {
        super.onSizeChanged(i5, i6, i7, i8);
        D();
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean z5) {
        super.setEnabled(z5);
        w();
    }

    public void setGlassEffect(o oVar) {
        k.g(oVar, "value");
        boolean z5 = this.f16077l != null;
        this.f16077l = null;
        if (!k.b(this.f16081p, oVar) || z5) {
            this.f16081p = oVar;
            C();
            D();
        }
    }

    public void setGlassEnabled(boolean z5) {
        if (this.f16080o == z5) {
            return;
        }
        this.f16080o = z5;
        if (z5) {
            D();
        } else {
            C();
        }
    }

    public void setSurfaceDrawable(Drawable drawable) {
        this.f16082q = drawable;
        j jVar = this.f16073h;
        if (jVar != null) {
            jVar.f(drawable);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        k.g(drawable, "who");
        j jVar = this.f16073h;
        return (jVar != null && jVar.i(drawable)) || super.verifyDrawable(drawable);
    }

    public /* synthetic */ StepOSButton(Context context, AttributeSet attributeSet, int i5, int i6, int i7, g gVar) {
        this(context, (i7 & 2) != 0 ? null : attributeSet, (i7 & 4) != 0 ? C0844b.f18282c : i5, (i7 & 8) != 0 ? l.f18489l : i6);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSButton(Context context, AttributeSet attributeSet, int i5, int i6) throws Exception {
        super(f16072r.b(context, i6), attributeSet, i5);
        k.g(context, "context");
        this.f16074i = new C1009e(this);
        this.f16078m = new Runnable() { // from class: m3.a
            @Override // java.lang.Runnable
            public final void run() {
                StepOSButton.B(this.f18820a);
            }
        };
        this.f16079n = new C1012h(this, new InterfaceC0761a() { // from class: m3.b
            @Override // i4.InterfaceC0761a
            public final Object invoke() {
                return StepOSButton.z(this.f18821a);
            }
        });
        this.f16080o = true;
        this.f16081p = o.f3626h.i();
        this.f16073h = new j(this);
        setClickable(true);
        setFocusable(true);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.f18665d1, i5, i6);
        try {
            setGlassEnabled(typedArrayObtainStyledAttributes.getBoolean(m.f18677f1, true));
            C1010f c1010f = C1010f.f20022a;
            k.d(typedArrayObtainStyledAttributes);
            o oVarB = c1010f.b(typedArrayObtainStyledAttributes, m.f18671e1);
            if (oVarB != null) {
                setGlassEffect(oVarB);
                v vVar = v.f5542a;
            }
            C0743a.a(typedArrayObtainStyledAttributes, null);
            Drawable background = getBackground();
            setBackground(null);
            setSurfaceDrawable(background);
            w();
        } finally {
        }
    }
}
