package com.google.android.material.chip;

import a1.C0418k;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import b1.h;
import com.google.android.material.internal.m;
import com.google.android.material.internal.o;
import com.google.android.material.internal.r;
import d1.C0652a;
import h.C0744a;
import j1.C0777a;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import org.libpag.BuildConfig;
import q1.C0981c;
import q1.C0982d;
import r1.C0994a;
import t1.C1115h;

/* loaded from: classes.dex */
public class a extends C1115h implements Drawable.Callback, m.b {

    /* renamed from: W0, reason: collision with root package name */
    private static final int[] f12574W0 = {R.attr.state_enabled};

    /* renamed from: X0, reason: collision with root package name */
    private static final ShapeDrawable f12575X0 = new ShapeDrawable(new OvalShape());

    /* renamed from: A0, reason: collision with root package name */
    private final m f12576A0;

    /* renamed from: B0, reason: collision with root package name */
    private int f12577B0;

    /* renamed from: C0, reason: collision with root package name */
    private int f12578C0;

    /* renamed from: D0, reason: collision with root package name */
    private int f12579D0;

    /* renamed from: E0, reason: collision with root package name */
    private int f12580E0;

    /* renamed from: F0, reason: collision with root package name */
    private int f12581F0;

    /* renamed from: G0, reason: collision with root package name */
    private int f12582G0;

    /* renamed from: H0, reason: collision with root package name */
    private boolean f12583H0;

    /* renamed from: I0, reason: collision with root package name */
    private int f12584I0;

    /* renamed from: J, reason: collision with root package name */
    private ColorStateList f12585J;

    /* renamed from: J0, reason: collision with root package name */
    private int f12586J0;

    /* renamed from: K, reason: collision with root package name */
    private ColorStateList f12587K;

    /* renamed from: K0, reason: collision with root package name */
    private ColorFilter f12588K0;

    /* renamed from: L, reason: collision with root package name */
    private float f12589L;

    /* renamed from: L0, reason: collision with root package name */
    private PorterDuffColorFilter f12590L0;

    /* renamed from: M, reason: collision with root package name */
    private float f12591M;

    /* renamed from: M0, reason: collision with root package name */
    private ColorStateList f12592M0;

    /* renamed from: N0, reason: collision with root package name */
    private PorterDuff.Mode f12593N0;

    /* renamed from: O0, reason: collision with root package name */
    private int[] f12594O0;

    /* renamed from: P0, reason: collision with root package name */
    private boolean f12595P0;

    /* renamed from: Q, reason: collision with root package name */
    private ColorStateList f12596Q;

    /* renamed from: Q0, reason: collision with root package name */
    private ColorStateList f12597Q0;

    /* renamed from: R, reason: collision with root package name */
    private float f12598R;

    /* renamed from: R0, reason: collision with root package name */
    private WeakReference<InterfaceC0162a> f12599R0;

    /* renamed from: S, reason: collision with root package name */
    private ColorStateList f12600S;

    /* renamed from: S0, reason: collision with root package name */
    private TextUtils.TruncateAt f12601S0;

    /* renamed from: T, reason: collision with root package name */
    private CharSequence f12602T;

    /* renamed from: T0, reason: collision with root package name */
    private boolean f12603T0;

    /* renamed from: U, reason: collision with root package name */
    private boolean f12604U;

    /* renamed from: U0, reason: collision with root package name */
    private int f12605U0;

    /* renamed from: V, reason: collision with root package name */
    private Drawable f12606V;

    /* renamed from: V0, reason: collision with root package name */
    private boolean f12607V0;

    /* renamed from: W, reason: collision with root package name */
    private ColorStateList f12608W;

    /* renamed from: X, reason: collision with root package name */
    private float f12609X;

    /* renamed from: Y, reason: collision with root package name */
    private boolean f12610Y;

    /* renamed from: Z, reason: collision with root package name */
    private boolean f12611Z;

    /* renamed from: a0, reason: collision with root package name */
    private Drawable f12612a0;

    /* renamed from: b0, reason: collision with root package name */
    private Drawable f12613b0;

    /* renamed from: c0, reason: collision with root package name */
    private ColorStateList f12614c0;

    /* renamed from: d0, reason: collision with root package name */
    private float f12615d0;

    /* renamed from: e0, reason: collision with root package name */
    private CharSequence f12616e0;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f12617f0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f12618g0;

    /* renamed from: h0, reason: collision with root package name */
    private Drawable f12619h0;

    /* renamed from: i0, reason: collision with root package name */
    private ColorStateList f12620i0;

    /* renamed from: j0, reason: collision with root package name */
    private h f12621j0;

    /* renamed from: k0, reason: collision with root package name */
    private h f12622k0;

    /* renamed from: l0, reason: collision with root package name */
    private float f12623l0;

    /* renamed from: m0, reason: collision with root package name */
    private float f12624m0;

    /* renamed from: n0, reason: collision with root package name */
    private float f12625n0;

    /* renamed from: o0, reason: collision with root package name */
    private float f12626o0;

    /* renamed from: p0, reason: collision with root package name */
    private float f12627p0;

    /* renamed from: q0, reason: collision with root package name */
    private float f12628q0;

    /* renamed from: r0, reason: collision with root package name */
    private float f12629r0;

    /* renamed from: s0, reason: collision with root package name */
    private float f12630s0;

    /* renamed from: t0, reason: collision with root package name */
    private final Context f12631t0;

    /* renamed from: u0, reason: collision with root package name */
    private final Paint f12632u0;

    /* renamed from: v0, reason: collision with root package name */
    private final Paint f12633v0;

    /* renamed from: w0, reason: collision with root package name */
    private final Paint.FontMetrics f12634w0;

    /* renamed from: x0, reason: collision with root package name */
    private final RectF f12635x0;

    /* renamed from: y0, reason: collision with root package name */
    private final PointF f12636y0;

    /* renamed from: z0, reason: collision with root package name */
    private final Path f12637z0;

    /* renamed from: com.google.android.material.chip.a$a, reason: collision with other inner class name */
    public interface InterfaceC0162a {
        void a();
    }

    private a(Context context, AttributeSet attributeSet, int i5, int i6) {
        super(context, attributeSet, i5, i6);
        this.f12591M = -1.0f;
        this.f12632u0 = new Paint(1);
        this.f12634w0 = new Paint.FontMetrics();
        this.f12635x0 = new RectF();
        this.f12636y0 = new PointF();
        this.f12637z0 = new Path();
        this.f12586J0 = 255;
        this.f12593N0 = PorterDuff.Mode.SRC_IN;
        this.f12599R0 = new WeakReference<>(null);
        U(context);
        this.f12631t0 = context;
        m mVar = new m(this);
        this.f12576A0 = mVar;
        this.f12602T = BuildConfig.FLAVOR;
        mVar.f().density = context.getResources().getDisplayMetrics().density;
        this.f12633v0 = null;
        int[] iArr = f12574W0;
        setState(iArr);
        y2(iArr);
        this.f12603T0 = true;
        f12575X0.setTint(-1);
    }

    private void A0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (c3()) {
            float f5 = this.f12630s0 + this.f12629r0;
            if (androidx.core.graphics.drawable.a.f(this) == 0) {
                float f6 = rect.right - f5;
                rectF.right = f6;
                rectF.left = f6 - this.f12615d0;
            } else {
                float f7 = rect.left + f5;
                rectF.left = f7;
                rectF.right = f7 + this.f12615d0;
            }
            float fExactCenterY = rect.exactCenterY();
            float f8 = this.f12615d0;
            float f9 = fExactCenterY - (f8 / 2.0f);
            rectF.top = f9;
            rectF.bottom = f9 + f8;
        }
    }

    private void B0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (c3()) {
            float f5 = this.f12630s0 + this.f12629r0 + this.f12615d0 + this.f12628q0 + this.f12627p0;
            if (androidx.core.graphics.drawable.a.f(this) == 0) {
                float f6 = rect.right;
                rectF.right = f6;
                rectF.left = f6 - f5;
            } else {
                int i5 = rect.left;
                rectF.left = i5;
                rectF.right = i5 + f5;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    private void D0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (this.f12602T != null) {
            float fY0 = this.f12623l0 + y0() + this.f12626o0;
            float fC0 = this.f12630s0 + C0() + this.f12627p0;
            if (androidx.core.graphics.drawable.a.f(this) == 0) {
                rectF.left = rect.left + fY0;
                rectF.right = rect.right - fC0;
            } else {
                rectF.left = rect.left + fC0;
                rectF.right = rect.right - fY0;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    private static boolean D1(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    private float E0() {
        this.f12576A0.f().getFontMetrics(this.f12634w0);
        Paint.FontMetrics fontMetrics = this.f12634w0;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    private static boolean E1(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    private static boolean F1(C0982d c0982d) {
        return (c0982d == null || c0982d.j() == null || !c0982d.j().isStateful()) ? false : true;
    }

    private boolean G0() {
        return this.f12618g0 && this.f12619h0 != null && this.f12617f0;
    }

    private void G1(AttributeSet attributeSet, int i5, int i6) {
        TypedArray typedArrayI = o.i(this.f12631t0, attributeSet, C0418k.f7055U, i5, i6, new int[0]);
        this.f12607V0 = typedArrayI.hasValue(C0418k.f6966F0);
        o2(C0981c.a(this.f12631t0, typedArrayI, C0418k.f7205s0));
        S1(C0981c.a(this.f12631t0, typedArrayI, C0418k.f7127f0));
        g2(typedArrayI.getDimension(C0418k.f7175n0, 0.0f));
        int i7 = C0418k.f7133g0;
        if (typedArrayI.hasValue(i7)) {
            U1(typedArrayI.getDimension(i7, 0.0f));
        }
        k2(C0981c.a(this.f12631t0, typedArrayI, C0418k.f7193q0));
        m2(typedArrayI.getDimension(C0418k.f7199r0, 0.0f));
        L2(C0981c.a(this.f12631t0, typedArrayI, C0418k.f6960E0));
        Q2(typedArrayI.getText(C0418k.f7085Z));
        C0982d c0982dF = C0981c.f(this.f12631t0, typedArrayI, C0418k.f7061V);
        c0982dF.o(typedArrayI.getDimension(C0418k.f7067W, c0982dF.k()));
        R2(c0982dF);
        int i8 = typedArrayI.getInt(C0418k.f7073X, 0);
        if (i8 == 1) {
            D2(TextUtils.TruncateAt.START);
        } else if (i8 == 2) {
            D2(TextUtils.TruncateAt.MIDDLE);
        } else if (i8 == 3) {
            D2(TextUtils.TruncateAt.END);
        }
        f2(typedArrayI.getBoolean(C0418k.f7169m0, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null) {
            f2(typedArrayI.getBoolean(C0418k.f7151j0, false));
        }
        Y1(C0981c.d(this.f12631t0, typedArrayI, C0418k.f7145i0));
        int i9 = C0418k.f7163l0;
        if (typedArrayI.hasValue(i9)) {
            c2(C0981c.a(this.f12631t0, typedArrayI, i9));
        }
        a2(typedArrayI.getDimension(C0418k.f7157k0, -1.0f));
        B2(typedArrayI.getBoolean(C0418k.f7247z0, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null) {
            B2(typedArrayI.getBoolean(C0418k.f7217u0, false));
        }
        p2(C0981c.d(this.f12631t0, typedArrayI, C0418k.f7211t0));
        z2(C0981c.a(this.f12631t0, typedArrayI, C0418k.f7241y0));
        u2(typedArrayI.getDimension(C0418k.f7229w0, 0.0f));
        K1(typedArrayI.getBoolean(C0418k.f7092a0, false));
        R1(typedArrayI.getBoolean(C0418k.f7120e0, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null) {
            R1(typedArrayI.getBoolean(C0418k.f7106c0, false));
        }
        M1(C0981c.d(this.f12631t0, typedArrayI, C0418k.f7099b0));
        int i10 = C0418k.f7113d0;
        if (typedArrayI.hasValue(i10)) {
            O1(C0981c.a(this.f12631t0, typedArrayI, i10));
        }
        O2(h.b(this.f12631t0, typedArrayI, C0418k.f6972G0));
        E2(h.b(this.f12631t0, typedArrayI, C0418k.f6942B0));
        i2(typedArrayI.getDimension(C0418k.f7187p0, 0.0f));
        I2(typedArrayI.getDimension(C0418k.f6954D0, 0.0f));
        G2(typedArrayI.getDimension(C0418k.f6948C0, 0.0f));
        W2(typedArrayI.getDimension(C0418k.f6984I0, 0.0f));
        T2(typedArrayI.getDimension(C0418k.f6978H0, 0.0f));
        w2(typedArrayI.getDimension(C0418k.f7235x0, 0.0f));
        r2(typedArrayI.getDimension(C0418k.f7223v0, 0.0f));
        W1(typedArrayI.getDimension(C0418k.f7139h0, 0.0f));
        K2(typedArrayI.getDimensionPixelSize(C0418k.f7079Y, Integer.MAX_VALUE));
        typedArrayI.recycle();
    }

    public static a H0(Context context, AttributeSet attributeSet, int i5, int i6) {
        a aVar = new a(context, attributeSet, i5, i6);
        aVar.G1(attributeSet, i5, i6);
        return aVar;
    }

    private void I0(Canvas canvas, Rect rect) {
        if (a3()) {
            x0(rect, this.f12635x0);
            RectF rectF = this.f12635x0;
            float f5 = rectF.left;
            float f6 = rectF.top;
            canvas.translate(f5, f6);
            this.f12619h0.setBounds(0, 0, (int) this.f12635x0.width(), (int) this.f12635x0.height());
            this.f12619h0.draw(canvas);
            canvas.translate(-f5, -f6);
        }
    }

    private boolean I1(int[] iArr, int[] iArr2) {
        boolean z5;
        boolean zOnStateChange = super.onStateChange(iArr);
        ColorStateList colorStateList = this.f12585J;
        int iQ = q(colorStateList != null ? colorStateList.getColorForState(iArr, this.f12577B0) : 0);
        boolean state = true;
        if (this.f12577B0 != iQ) {
            this.f12577B0 = iQ;
            zOnStateChange = true;
        }
        ColorStateList colorStateList2 = this.f12587K;
        int iQ2 = q(colorStateList2 != null ? colorStateList2.getColorForState(iArr, this.f12578C0) : 0);
        if (this.f12578C0 != iQ2) {
            this.f12578C0 = iQ2;
            zOnStateChange = true;
        }
        int i5 = C0777a.i(iQ, iQ2);
        if ((this.f12579D0 != i5) | (B() == null)) {
            this.f12579D0 = i5;
            g0(ColorStateList.valueOf(i5));
            zOnStateChange = true;
        }
        ColorStateList colorStateList3 = this.f12596Q;
        int colorForState = colorStateList3 != null ? colorStateList3.getColorForState(iArr, this.f12580E0) : 0;
        if (this.f12580E0 != colorForState) {
            this.f12580E0 = colorForState;
            zOnStateChange = true;
        }
        int colorForState2 = (this.f12597Q0 == null || !C0994a.b(iArr)) ? 0 : this.f12597Q0.getColorForState(iArr, this.f12581F0);
        if (this.f12581F0 != colorForState2) {
            this.f12581F0 = colorForState2;
            if (this.f12595P0) {
                zOnStateChange = true;
            }
        }
        int colorForState3 = (this.f12576A0.e() == null || this.f12576A0.e().j() == null) ? 0 : this.f12576A0.e().j().getColorForState(iArr, this.f12582G0);
        if (this.f12582G0 != colorForState3) {
            this.f12582G0 = colorForState3;
            zOnStateChange = true;
        }
        boolean z6 = z1(getState(), R.attr.state_checked) && this.f12617f0;
        if (this.f12583H0 == z6 || this.f12619h0 == null) {
            z5 = false;
        } else {
            float fY0 = y0();
            this.f12583H0 = z6;
            if (fY0 != y0()) {
                zOnStateChange = true;
                z5 = true;
            } else {
                z5 = false;
                zOnStateChange = true;
            }
        }
        ColorStateList colorStateList4 = this.f12592M0;
        int colorForState4 = colorStateList4 != null ? colorStateList4.getColorForState(iArr, this.f12584I0) : 0;
        if (this.f12584I0 != colorForState4) {
            this.f12584I0 = colorForState4;
            this.f12590L0 = com.google.android.material.drawable.a.j(this, this.f12592M0, this.f12593N0);
        } else {
            state = zOnStateChange;
        }
        if (E1(this.f12606V)) {
            state |= this.f12606V.setState(iArr);
        }
        if (E1(this.f12619h0)) {
            state |= this.f12619h0.setState(iArr);
        }
        if (E1(this.f12612a0)) {
            int[] iArr3 = new int[iArr.length + iArr2.length];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
            state |= this.f12612a0.setState(iArr3);
        }
        if (E1(this.f12613b0)) {
            state |= this.f12613b0.setState(iArr2);
        }
        if (state) {
            invalidateSelf();
        }
        if (z5) {
            H1();
        }
        return state;
    }

    private void J0(Canvas canvas, Rect rect) {
        if (this.f12607V0) {
            return;
        }
        this.f12632u0.setColor(this.f12578C0);
        this.f12632u0.setStyle(Paint.Style.FILL);
        this.f12632u0.setColorFilter(x1());
        this.f12635x0.set(rect);
        canvas.drawRoundRect(this.f12635x0, U0(), U0(), this.f12632u0);
    }

    private void K0(Canvas canvas, Rect rect) {
        if (b3()) {
            x0(rect, this.f12635x0);
            RectF rectF = this.f12635x0;
            float f5 = rectF.left;
            float f6 = rectF.top;
            canvas.translate(f5, f6);
            this.f12606V.setBounds(0, 0, (int) this.f12635x0.width(), (int) this.f12635x0.height());
            this.f12606V.draw(canvas);
            canvas.translate(-f5, -f6);
        }
    }

    private void L0(Canvas canvas, Rect rect) {
        if (this.f12598R <= 0.0f || this.f12607V0) {
            return;
        }
        this.f12632u0.setColor(this.f12580E0);
        this.f12632u0.setStyle(Paint.Style.STROKE);
        if (!this.f12607V0) {
            this.f12632u0.setColorFilter(x1());
        }
        RectF rectF = this.f12635x0;
        float f5 = rect.left;
        float f6 = this.f12598R;
        rectF.set(f5 + (f6 / 2.0f), rect.top + (f6 / 2.0f), rect.right - (f6 / 2.0f), rect.bottom - (f6 / 2.0f));
        float f7 = this.f12591M - (this.f12598R / 2.0f);
        canvas.drawRoundRect(this.f12635x0, f7, f7, this.f12632u0);
    }

    private void M0(Canvas canvas, Rect rect) {
        if (this.f12607V0) {
            return;
        }
        this.f12632u0.setColor(this.f12577B0);
        this.f12632u0.setStyle(Paint.Style.FILL);
        this.f12635x0.set(rect);
        canvas.drawRoundRect(this.f12635x0, U0(), U0(), this.f12632u0);
    }

    private void N0(Canvas canvas, Rect rect) {
        if (c3()) {
            A0(rect, this.f12635x0);
            RectF rectF = this.f12635x0;
            float f5 = rectF.left;
            float f6 = rectF.top;
            canvas.translate(f5, f6);
            this.f12612a0.setBounds(0, 0, (int) this.f12635x0.width(), (int) this.f12635x0.height());
            this.f12613b0.setBounds(this.f12612a0.getBounds());
            this.f12613b0.jumpToCurrentState();
            this.f12613b0.draw(canvas);
            canvas.translate(-f5, -f6);
        }
    }

    private void O0(Canvas canvas, Rect rect) {
        this.f12632u0.setColor(this.f12581F0);
        this.f12632u0.setStyle(Paint.Style.FILL);
        this.f12635x0.set(rect);
        if (!this.f12607V0) {
            canvas.drawRoundRect(this.f12635x0, U0(), U0(), this.f12632u0);
        } else {
            l(new RectF(rect), this.f12637z0);
            super.u(canvas, this.f12632u0, this.f12637z0, x());
        }
    }

    private void P0(Canvas canvas, Rect rect) {
        Canvas canvas2;
        Paint paint = this.f12633v0;
        if (paint != null) {
            paint.setColor(androidx.core.graphics.a.k(-16777216, 127));
            canvas.drawRect(rect, this.f12633v0);
            if (b3() || a3()) {
                x0(rect, this.f12635x0);
                canvas.drawRect(this.f12635x0, this.f12633v0);
            }
            if (this.f12602T != null) {
                canvas2 = canvas;
                canvas2.drawLine(rect.left, rect.exactCenterY(), rect.right, rect.exactCenterY(), this.f12633v0);
            } else {
                canvas2 = canvas;
            }
            if (c3()) {
                A0(rect, this.f12635x0);
                canvas2.drawRect(this.f12635x0, this.f12633v0);
            }
            this.f12633v0.setColor(androidx.core.graphics.a.k(-65536, 127));
            z0(rect, this.f12635x0);
            canvas2.drawRect(this.f12635x0, this.f12633v0);
            this.f12633v0.setColor(androidx.core.graphics.a.k(-16711936, 127));
            B0(rect, this.f12635x0);
            canvas2.drawRect(this.f12635x0, this.f12633v0);
        }
    }

    private void Q0(Canvas canvas, Rect rect) {
        if (this.f12602T != null) {
            Paint.Align alignF0 = F0(rect, this.f12636y0);
            D0(rect, this.f12635x0);
            if (this.f12576A0.e() != null) {
                this.f12576A0.f().drawableState = getState();
                this.f12576A0.l(this.f12631t0);
            }
            this.f12576A0.f().setTextAlign(alignF0);
            int iSave = 0;
            boolean z5 = Math.round(this.f12576A0.g(t1().toString())) > Math.round(this.f12635x0.width());
            if (z5) {
                iSave = canvas.save();
                canvas.clipRect(this.f12635x0);
            }
            CharSequence charSequenceEllipsize = this.f12602T;
            if (z5 && this.f12601S0 != null) {
                charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, this.f12576A0.f(), this.f12635x0.width(), this.f12601S0);
            }
            CharSequence charSequence = charSequenceEllipsize;
            int length = charSequence.length();
            PointF pointF = this.f12636y0;
            canvas.drawText(charSequence, 0, length, pointF.x, pointF.y, this.f12576A0.f());
            if (z5) {
                canvas.restoreToCount(iSave);
            }
        }
    }

    private boolean a3() {
        return this.f12618g0 && this.f12619h0 != null && this.f12583H0;
    }

    private boolean b3() {
        return this.f12604U && this.f12606V != null;
    }

    private boolean c3() {
        return this.f12611Z && this.f12612a0 != null;
    }

    private void d3(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    private void e3() {
        this.f12597Q0 = this.f12595P0 ? C0994a.a(this.f12600S) : null;
    }

    private void f3() {
        this.f12613b0 = new RippleDrawable(C0994a.a(r1()), this.f12612a0, f12575X0);
    }

    private float l1() {
        Drawable drawable = this.f12583H0 ? this.f12619h0 : this.f12606V;
        float f5 = this.f12609X;
        if (f5 > 0.0f || drawable == null) {
            return f5;
        }
        float fCeil = (float) Math.ceil(r.c(this.f12631t0, 24));
        return ((float) drawable.getIntrinsicHeight()) <= fCeil ? drawable.getIntrinsicHeight() : fCeil;
    }

    private float m1() {
        Drawable drawable = this.f12583H0 ? this.f12619h0 : this.f12606V;
        float f5 = this.f12609X;
        return (f5 > 0.0f || drawable == null) ? f5 : drawable.getIntrinsicWidth();
    }

    private void o2(ColorStateList colorStateList) {
        if (this.f12585J != colorStateList) {
            this.f12585J = colorStateList;
            onStateChange(getState());
        }
    }

    private void w0(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        androidx.core.graphics.drawable.a.m(drawable, androidx.core.graphics.drawable.a.f(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.f12612a0) {
            if (drawable.isStateful()) {
                drawable.setState(i1());
            }
            drawable.setTintList(this.f12614c0);
            return;
        }
        Drawable drawable2 = this.f12606V;
        if (drawable == drawable2 && this.f12610Y) {
            drawable2.setTintList(this.f12608W);
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
    }

    private void x0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (b3() || a3()) {
            float f5 = this.f12623l0 + this.f12624m0;
            float fM1 = m1();
            if (androidx.core.graphics.drawable.a.f(this) == 0) {
                float f6 = rect.left + f5;
                rectF.left = f6;
                rectF.right = f6 + fM1;
            } else {
                float f7 = rect.right - f5;
                rectF.right = f7;
                rectF.left = f7 - fM1;
            }
            float fL1 = l1();
            float fExactCenterY = rect.exactCenterY() - (fL1 / 2.0f);
            rectF.top = fExactCenterY;
            rectF.bottom = fExactCenterY + fL1;
        }
    }

    private ColorFilter x1() {
        ColorFilter colorFilter = this.f12588K0;
        return colorFilter != null ? colorFilter : this.f12590L0;
    }

    private void z0(Rect rect, RectF rectF) {
        rectF.set(rect);
        if (c3()) {
            float f5 = this.f12630s0 + this.f12629r0 + this.f12615d0 + this.f12628q0 + this.f12627p0;
            if (androidx.core.graphics.drawable.a.f(this) == 0) {
                rectF.right = rect.right - f5;
            } else {
                rectF.left = rect.left + f5;
            }
        }
    }

    private static boolean z1(int[] iArr, int i5) {
        if (iArr == null) {
            return false;
        }
        for (int i6 : iArr) {
            if (i6 == i5) {
                return true;
            }
        }
        return false;
    }

    public boolean A1() {
        return this.f12617f0;
    }

    public void A2(int i5) {
        z2(C0744a.a(this.f12631t0, i5));
    }

    public boolean B1() {
        return E1(this.f12612a0);
    }

    public void B2(boolean z5) {
        if (this.f12611Z != z5) {
            boolean zC3 = c3();
            this.f12611Z = z5;
            boolean zC32 = c3();
            if (zC3 != zC32) {
                if (zC32) {
                    w0(this.f12612a0);
                } else {
                    d3(this.f12612a0);
                }
                invalidateSelf();
                H1();
            }
        }
    }

    float C0() {
        if (c3()) {
            return this.f12628q0 + this.f12615d0 + this.f12629r0;
        }
        return 0.0f;
    }

    public boolean C1() {
        return this.f12611Z;
    }

    public void C2(InterfaceC0162a interfaceC0162a) {
        this.f12599R0 = new WeakReference<>(interfaceC0162a);
    }

    public void D2(TextUtils.TruncateAt truncateAt) {
        this.f12601S0 = truncateAt;
    }

    public void E2(h hVar) {
        this.f12622k0 = hVar;
    }

    Paint.Align F0(Rect rect, PointF pointF) {
        pointF.set(0.0f, 0.0f);
        Paint.Align align = Paint.Align.LEFT;
        if (this.f12602T != null) {
            float fY0 = this.f12623l0 + y0() + this.f12626o0;
            if (androidx.core.graphics.drawable.a.f(this) == 0) {
                pointF.x = rect.left + fY0;
            } else {
                pointF.x = rect.right - fY0;
                align = Paint.Align.RIGHT;
            }
            pointF.y = rect.centerY() - E0();
        }
        return align;
    }

    public void F2(int i5) {
        E2(h.c(this.f12631t0, i5));
    }

    public void G2(float f5) {
        if (this.f12625n0 != f5) {
            float fY0 = y0();
            this.f12625n0 = f5;
            float fY02 = y0();
            invalidateSelf();
            if (fY0 != fY02) {
                H1();
            }
        }
    }

    protected void H1() {
        InterfaceC0162a interfaceC0162a = this.f12599R0.get();
        if (interfaceC0162a != null) {
            interfaceC0162a.a();
        }
    }

    public void H2(int i5) {
        G2(this.f12631t0.getResources().getDimension(i5));
    }

    public void I2(float f5) {
        if (this.f12624m0 != f5) {
            float fY0 = y0();
            this.f12624m0 = f5;
            float fY02 = y0();
            invalidateSelf();
            if (fY0 != fY02) {
                H1();
            }
        }
    }

    boolean J1(boolean z5) {
        if (this.f12612a0 != null) {
            return y2(z5 ? new int[]{R.attr.state_pressed, R.attr.state_enabled} : f12574W0);
        }
        return false;
    }

    public void J2(int i5) {
        I2(this.f12631t0.getResources().getDimension(i5));
    }

    public void K1(boolean z5) {
        if (this.f12617f0 != z5) {
            this.f12617f0 = z5;
            float fY0 = y0();
            if (!z5 && this.f12583H0) {
                this.f12583H0 = false;
            }
            float fY02 = y0();
            invalidateSelf();
            if (fY0 != fY02) {
                H1();
            }
        }
    }

    public void K2(int i5) {
        this.f12605U0 = i5;
    }

    public void L1(int i5) {
        K1(this.f12631t0.getResources().getBoolean(i5));
    }

    public void L2(ColorStateList colorStateList) {
        if (this.f12600S != colorStateList) {
            this.f12600S = colorStateList;
            e3();
            onStateChange(getState());
        }
    }

    public void M1(Drawable drawable) {
        if (this.f12619h0 != drawable) {
            float fY0 = y0();
            this.f12619h0 = drawable;
            float fY02 = y0();
            d3(this.f12619h0);
            w0(this.f12619h0);
            invalidateSelf();
            if (fY0 != fY02) {
                H1();
            }
        }
    }

    public void M2(int i5) {
        L2(C0744a.a(this.f12631t0, i5));
    }

    public void N1(int i5) {
        M1(C0744a.b(this.f12631t0, i5));
    }

    void N2(boolean z5) {
        this.f12603T0 = z5;
    }

    public void O1(ColorStateList colorStateList) {
        if (this.f12620i0 != colorStateList) {
            this.f12620i0 = colorStateList;
            if (G0()) {
                this.f12619h0.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void O2(h hVar) {
        this.f12621j0 = hVar;
    }

    public void P1(int i5) {
        O1(C0744a.a(this.f12631t0, i5));
    }

    public void P2(int i5) {
        O2(h.c(this.f12631t0, i5));
    }

    public void Q1(int i5) {
        R1(this.f12631t0.getResources().getBoolean(i5));
    }

    public void Q2(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = BuildConfig.FLAVOR;
        }
        if (TextUtils.equals(this.f12602T, charSequence)) {
            return;
        }
        this.f12602T = charSequence;
        this.f12576A0.k(true);
        invalidateSelf();
        H1();
    }

    public Drawable R0() {
        return this.f12619h0;
    }

    public void R1(boolean z5) {
        if (this.f12618g0 != z5) {
            boolean zA3 = a3();
            this.f12618g0 = z5;
            boolean zA32 = a3();
            if (zA3 != zA32) {
                if (zA32) {
                    w0(this.f12619h0);
                } else {
                    d3(this.f12619h0);
                }
                invalidateSelf();
                H1();
            }
        }
    }

    public void R2(C0982d c0982d) {
        this.f12576A0.j(c0982d, this.f12631t0);
    }

    public ColorStateList S0() {
        return this.f12620i0;
    }

    public void S1(ColorStateList colorStateList) {
        if (this.f12587K != colorStateList) {
            this.f12587K = colorStateList;
            onStateChange(getState());
        }
    }

    public void S2(int i5) {
        R2(new C0982d(this.f12631t0, i5));
    }

    public ColorStateList T0() {
        return this.f12587K;
    }

    public void T1(int i5) {
        S1(C0744a.a(this.f12631t0, i5));
    }

    public void T2(float f5) {
        if (this.f12627p0 != f5) {
            this.f12627p0 = f5;
            invalidateSelf();
            H1();
        }
    }

    public float U0() {
        return this.f12607V0 ? N() : this.f12591M;
    }

    @Deprecated
    public void U1(float f5) {
        if (this.f12591M != f5) {
            this.f12591M = f5;
            setShapeAppearanceModel(I().x(f5));
        }
    }

    public void U2(int i5) {
        T2(this.f12631t0.getResources().getDimension(i5));
    }

    public float V0() {
        return this.f12630s0;
    }

    @Deprecated
    public void V1(int i5) {
        U1(this.f12631t0.getResources().getDimension(i5));
    }

    public void V2(float f5) {
        C0982d c0982dU1 = u1();
        if (c0982dU1 != null) {
            c0982dU1.o(f5);
            this.f12576A0.f().setTextSize(f5);
            a();
        }
    }

    public Drawable W0() {
        Drawable drawable = this.f12606V;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.q(drawable);
        }
        return null;
    }

    public void W1(float f5) {
        if (this.f12630s0 != f5) {
            this.f12630s0 = f5;
            invalidateSelf();
            H1();
        }
    }

    public void W2(float f5) {
        if (this.f12626o0 != f5) {
            this.f12626o0 = f5;
            invalidateSelf();
            H1();
        }
    }

    public float X0() {
        return this.f12609X;
    }

    public void X1(int i5) {
        W1(this.f12631t0.getResources().getDimension(i5));
    }

    public void X2(int i5) {
        W2(this.f12631t0.getResources().getDimension(i5));
    }

    public ColorStateList Y0() {
        return this.f12608W;
    }

    public void Y1(Drawable drawable) {
        Drawable drawableW0 = W0();
        if (drawableW0 != drawable) {
            float fY0 = y0();
            this.f12606V = drawable != null ? androidx.core.graphics.drawable.a.r(drawable).mutate() : null;
            float fY02 = y0();
            d3(drawableW0);
            if (b3()) {
                w0(this.f12606V);
            }
            invalidateSelf();
            if (fY0 != fY02) {
                H1();
            }
        }
    }

    public void Y2(boolean z5) {
        if (this.f12595P0 != z5) {
            this.f12595P0 = z5;
            e3();
            onStateChange(getState());
        }
    }

    public float Z0() {
        return this.f12589L;
    }

    public void Z1(int i5) {
        Y1(C0744a.b(this.f12631t0, i5));
    }

    boolean Z2() {
        return this.f12603T0;
    }

    @Override // com.google.android.material.internal.m.b
    public void a() {
        H1();
        invalidateSelf();
    }

    public float a1() {
        return this.f12623l0;
    }

    public void a2(float f5) {
        if (this.f12609X != f5) {
            float fY0 = y0();
            this.f12609X = f5;
            float fY02 = y0();
            invalidateSelf();
            if (fY0 != fY02) {
                H1();
            }
        }
    }

    public ColorStateList b1() {
        return this.f12596Q;
    }

    public void b2(int i5) {
        a2(this.f12631t0.getResources().getDimension(i5));
    }

    public float c1() {
        return this.f12598R;
    }

    public void c2(ColorStateList colorStateList) {
        this.f12610Y = true;
        if (this.f12608W != colorStateList) {
            this.f12608W = colorStateList;
            if (b3()) {
                this.f12606V.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public Drawable d1() {
        Drawable drawable = this.f12612a0;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.q(drawable);
        }
        return null;
    }

    public void d2(int i5) {
        c2(C0744a.a(this.f12631t0, i5));
    }

    @Override // t1.C1115h, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Canvas canvas2;
        int iA;
        Rect bounds = getBounds();
        if (bounds.isEmpty() || getAlpha() == 0) {
            return;
        }
        int i5 = this.f12586J0;
        if (i5 < 255) {
            canvas2 = canvas;
            iA = C0652a.a(canvas2, bounds.left, bounds.top, bounds.right, bounds.bottom, i5);
        } else {
            canvas2 = canvas;
            iA = 0;
        }
        M0(canvas2, bounds);
        J0(canvas2, bounds);
        if (this.f12607V0) {
            super.draw(canvas2);
        }
        L0(canvas2, bounds);
        O0(canvas2, bounds);
        K0(canvas2, bounds);
        I0(canvas2, bounds);
        if (this.f12603T0) {
            Q0(canvas2, bounds);
        }
        N0(canvas2, bounds);
        P0(canvas2, bounds);
        if (this.f12586J0 < 255) {
            canvas2.restoreToCount(iA);
        }
    }

    public CharSequence e1() {
        return this.f12616e0;
    }

    public void e2(int i5) {
        f2(this.f12631t0.getResources().getBoolean(i5));
    }

    public float f1() {
        return this.f12629r0;
    }

    public void f2(boolean z5) {
        if (this.f12604U != z5) {
            boolean zB3 = b3();
            this.f12604U = z5;
            boolean zB32 = b3();
            if (zB3 != zB32) {
                if (zB32) {
                    w0(this.f12606V);
                } else {
                    d3(this.f12606V);
                }
                invalidateSelf();
                H1();
            }
        }
    }

    public float g1() {
        return this.f12615d0;
    }

    public void g2(float f5) {
        if (this.f12589L != f5) {
            this.f12589L = f5;
            invalidateSelf();
            H1();
        }
    }

    @Override // t1.C1115h, android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f12586J0;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f12588K0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.f12589L;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.min(Math.round(this.f12623l0 + y0() + this.f12626o0 + this.f12576A0.g(t1().toString()) + this.f12627p0 + C0() + this.f12630s0), this.f12605U0);
    }

    @Override // t1.C1115h, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // t1.C1115h, android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        Outline outline2;
        if (this.f12607V0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            outline2 = outline;
            outline2.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.f12591M);
        } else {
            outline.setRoundRect(bounds, this.f12591M);
            outline2 = outline;
        }
        outline2.setAlpha(getAlpha() / 255.0f);
    }

    public float h1() {
        return this.f12628q0;
    }

    public void h2(int i5) {
        g2(this.f12631t0.getResources().getDimension(i5));
    }

    public int[] i1() {
        return this.f12594O0;
    }

    public void i2(float f5) {
        if (this.f12623l0 != f5) {
            this.f12623l0 = f5;
            invalidateSelf();
            H1();
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // t1.C1115h, android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (D1(this.f12585J) || D1(this.f12587K) || D1(this.f12596Q)) {
            return true;
        }
        return (this.f12595P0 && D1(this.f12597Q0)) || F1(this.f12576A0.e()) || G0() || E1(this.f12606V) || E1(this.f12619h0) || D1(this.f12592M0);
    }

    public ColorStateList j1() {
        return this.f12614c0;
    }

    public void j2(int i5) {
        i2(this.f12631t0.getResources().getDimension(i5));
    }

    public void k1(RectF rectF) {
        B0(getBounds(), rectF);
    }

    public void k2(ColorStateList colorStateList) {
        if (this.f12596Q != colorStateList) {
            this.f12596Q = colorStateList;
            if (this.f12607V0) {
                o0(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void l2(int i5) {
        k2(C0744a.a(this.f12631t0, i5));
    }

    public void m2(float f5) {
        if (this.f12598R != f5) {
            this.f12598R = f5;
            this.f12632u0.setStrokeWidth(f5);
            if (this.f12607V0) {
                super.p0(f5);
            }
            invalidateSelf();
        }
    }

    public TextUtils.TruncateAt n1() {
        return this.f12601S0;
    }

    public void n2(int i5) {
        m2(this.f12631t0.getResources().getDimension(i5));
    }

    public h o1() {
        return this.f12622k0;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i5) {
        boolean zOnLayoutDirectionChanged = super.onLayoutDirectionChanged(i5);
        if (b3()) {
            zOnLayoutDirectionChanged |= androidx.core.graphics.drawable.a.m(this.f12606V, i5);
        }
        if (a3()) {
            zOnLayoutDirectionChanged |= androidx.core.graphics.drawable.a.m(this.f12619h0, i5);
        }
        if (c3()) {
            zOnLayoutDirectionChanged |= androidx.core.graphics.drawable.a.m(this.f12612a0, i5);
        }
        if (!zOnLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i5) {
        boolean zOnLevelChange = super.onLevelChange(i5);
        if (b3()) {
            zOnLevelChange |= this.f12606V.setLevel(i5);
        }
        if (a3()) {
            zOnLevelChange |= this.f12619h0.setLevel(i5);
        }
        if (c3()) {
            zOnLevelChange |= this.f12612a0.setLevel(i5);
        }
        if (zOnLevelChange) {
            invalidateSelf();
        }
        return zOnLevelChange;
    }

    @Override // t1.C1115h, android.graphics.drawable.Drawable, com.google.android.material.internal.m.b
    public boolean onStateChange(int[] iArr) {
        if (this.f12607V0) {
            super.onStateChange(iArr);
        }
        return I1(iArr, i1());
    }

    public float p1() {
        return this.f12625n0;
    }

    public void p2(Drawable drawable) {
        Drawable drawableD1 = d1();
        if (drawableD1 != drawable) {
            float fC0 = C0();
            this.f12612a0 = drawable != null ? androidx.core.graphics.drawable.a.r(drawable).mutate() : null;
            f3();
            float fC02 = C0();
            d3(drawableD1);
            if (c3()) {
                w0(this.f12612a0);
            }
            invalidateSelf();
            if (fC0 != fC02) {
                H1();
            }
        }
    }

    public float q1() {
        return this.f12624m0;
    }

    public void q2(CharSequence charSequence) {
        if (this.f12616e0 != charSequence) {
            this.f12616e0 = androidx.core.text.a.c().h(charSequence);
            invalidateSelf();
        }
    }

    public ColorStateList r1() {
        return this.f12600S;
    }

    public void r2(float f5) {
        if (this.f12629r0 != f5) {
            this.f12629r0 = f5;
            invalidateSelf();
            if (c3()) {
                H1();
            }
        }
    }

    public h s1() {
        return this.f12621j0;
    }

    public void s2(int i5) {
        r2(this.f12631t0.getResources().getDimension(i5));
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j5) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j5);
        }
    }

    @Override // t1.C1115h, android.graphics.drawable.Drawable
    public void setAlpha(int i5) {
        if (this.f12586J0 != i5) {
            this.f12586J0 = i5;
            invalidateSelf();
        }
    }

    @Override // t1.C1115h, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f12588K0 != colorFilter) {
            this.f12588K0 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // t1.C1115h, android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        if (this.f12592M0 != colorStateList) {
            this.f12592M0 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // t1.C1115h, android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.f12593N0 != mode) {
            this.f12593N0 = mode;
            this.f12590L0 = com.google.android.material.drawable.a.j(this, this.f12592M0, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z5, boolean z6) {
        boolean visible = super.setVisible(z5, z6);
        if (b3()) {
            visible |= this.f12606V.setVisible(z5, z6);
        }
        if (a3()) {
            visible |= this.f12619h0.setVisible(z5, z6);
        }
        if (c3()) {
            visible |= this.f12612a0.setVisible(z5, z6);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public CharSequence t1() {
        return this.f12602T;
    }

    public void t2(int i5) {
        p2(C0744a.b(this.f12631t0, i5));
    }

    public C0982d u1() {
        return this.f12576A0.e();
    }

    public void u2(float f5) {
        if (this.f12615d0 != f5) {
            this.f12615d0 = f5;
            invalidateSelf();
            if (c3()) {
                H1();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public float v1() {
        return this.f12627p0;
    }

    public void v2(int i5) {
        u2(this.f12631t0.getResources().getDimension(i5));
    }

    public float w1() {
        return this.f12626o0;
    }

    public void w2(float f5) {
        if (this.f12628q0 != f5) {
            this.f12628q0 = f5;
            invalidateSelf();
            if (c3()) {
                H1();
            }
        }
    }

    public void x2(int i5) {
        w2(this.f12631t0.getResources().getDimension(i5));
    }

    float y0() {
        if (b3() || a3()) {
            return this.f12624m0 + m1() + this.f12625n0;
        }
        return 0.0f;
    }

    public boolean y1() {
        return this.f12595P0;
    }

    public boolean y2(int[] iArr) {
        if (Arrays.equals(this.f12594O0, iArr)) {
            return false;
        }
        this.f12594O0 = iArr;
        if (c3()) {
            return I1(getState(), iArr);
        }
        return false;
    }

    public void z2(ColorStateList colorStateList) {
        if (this.f12614c0 != colorStateList) {
            this.f12614c0 = colorStateList;
            if (c3()) {
                this.f12612a0.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }
}
