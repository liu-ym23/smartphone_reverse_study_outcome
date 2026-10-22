package com.google.android.material.chip;

import W2.c;
import W2.d;
import Z2.h;
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
import com.google.android.material.R$styleable;
import com.google.android.material.internal.p;
import com.google.android.material.internal.r;
import com.google.android.material.internal.u;
import f.C4027a;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import t0.C5502d;
import u0.C5566a;
import z0.C6050a;

/* loaded from: classes2.dex */
public class a extends h implements Drawable.Callback, p.b {

    /* renamed from: b1, reason: collision with root package name */
    public static final int[] f20639b1 = {R.attr.state_enabled};

    /* renamed from: c1, reason: collision with root package name */
    public static final ShapeDrawable f20640c1 = new ShapeDrawable(new OvalShape());

    /* renamed from: A0, reason: collision with root package name */
    public final Paint f20641A0;

    /* renamed from: B0, reason: collision with root package name */
    public final Paint.FontMetrics f20642B0;

    /* renamed from: C0, reason: collision with root package name */
    public final RectF f20643C0;

    /* renamed from: D0, reason: collision with root package name */
    public final PointF f20644D0;

    /* renamed from: E0, reason: collision with root package name */
    public final Path f20645E0;

    /* renamed from: F0, reason: collision with root package name */
    public final p f20646F0;

    /* renamed from: G0, reason: collision with root package name */
    public int f20647G0;

    /* renamed from: H0, reason: collision with root package name */
    public int f20648H0;

    /* renamed from: I0, reason: collision with root package name */
    public int f20649I0;

    /* renamed from: J, reason: collision with root package name */
    public ColorStateList f20650J;

    /* renamed from: J0, reason: collision with root package name */
    public int f20651J0;

    /* renamed from: K, reason: collision with root package name */
    public ColorStateList f20652K;

    /* renamed from: K0, reason: collision with root package name */
    public int f20653K0;

    /* renamed from: L, reason: collision with root package name */
    public float f20654L;

    /* renamed from: L0, reason: collision with root package name */
    public int f20655L0;

    /* renamed from: M, reason: collision with root package name */
    public float f20656M;

    /* renamed from: M0, reason: collision with root package name */
    public boolean f20657M0;

    /* renamed from: N, reason: collision with root package name */
    public ColorStateList f20658N;

    /* renamed from: N0, reason: collision with root package name */
    public int f20659N0;

    /* renamed from: O, reason: collision with root package name */
    public float f20660O;

    /* renamed from: O0, reason: collision with root package name */
    public int f20661O0;

    /* renamed from: P, reason: collision with root package name */
    public ColorStateList f20662P;

    /* renamed from: P0, reason: collision with root package name */
    public ColorFilter f20663P0;

    /* renamed from: Q, reason: collision with root package name */
    public CharSequence f20664Q;

    /* renamed from: Q0, reason: collision with root package name */
    public PorterDuffColorFilter f20665Q0;

    /* renamed from: R, reason: collision with root package name */
    public boolean f20666R;

    /* renamed from: R0, reason: collision with root package name */
    public ColorStateList f20667R0;

    /* renamed from: S, reason: collision with root package name */
    public Drawable f20668S;

    /* renamed from: S0, reason: collision with root package name */
    public PorterDuff.Mode f20669S0;

    /* renamed from: T, reason: collision with root package name */
    public ColorStateList f20670T;

    /* renamed from: T0, reason: collision with root package name */
    public int[] f20671T0;

    /* renamed from: U, reason: collision with root package name */
    public float f20672U;

    /* renamed from: U0, reason: collision with root package name */
    public boolean f20673U0;

    /* renamed from: V, reason: collision with root package name */
    public boolean f20674V;

    /* renamed from: V0, reason: collision with root package name */
    public ColorStateList f20675V0;

    /* renamed from: W, reason: collision with root package name */
    public boolean f20676W;

    /* renamed from: W0, reason: collision with root package name */
    public WeakReference<InterfaceC0232a> f20677W0;

    /* renamed from: X, reason: collision with root package name */
    public Drawable f20678X;

    /* renamed from: X0, reason: collision with root package name */
    public TextUtils.TruncateAt f20679X0;

    /* renamed from: Y, reason: collision with root package name */
    public Drawable f20680Y;

    /* renamed from: Y0, reason: collision with root package name */
    public boolean f20681Y0;

    /* renamed from: Z, reason: collision with root package name */
    public ColorStateList f20682Z;

    /* renamed from: Z0, reason: collision with root package name */
    public int f20683Z0;

    /* renamed from: a0, reason: collision with root package name */
    public float f20684a0;

    /* renamed from: a1, reason: collision with root package name */
    public boolean f20685a1;

    /* renamed from: b0, reason: collision with root package name */
    public CharSequence f20686b0;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f20687c0;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f20688d0;

    /* renamed from: e0, reason: collision with root package name */
    public Drawable f20689e0;

    /* renamed from: f0, reason: collision with root package name */
    public ColorStateList f20690f0;

    /* renamed from: g0, reason: collision with root package name */
    public E2.h f20691g0;

    /* renamed from: h0, reason: collision with root package name */
    public E2.h f20692h0;

    /* renamed from: i0, reason: collision with root package name */
    public float f20693i0;

    /* renamed from: j0, reason: collision with root package name */
    public float f20694j0;

    /* renamed from: k0, reason: collision with root package name */
    public float f20695k0;

    /* renamed from: t0, reason: collision with root package name */
    public float f20696t0;

    /* renamed from: u0, reason: collision with root package name */
    public float f20697u0;

    /* renamed from: v0, reason: collision with root package name */
    public float f20698v0;

    /* renamed from: w0, reason: collision with root package name */
    public float f20699w0;

    /* renamed from: x0, reason: collision with root package name */
    public float f20700x0;

    /* renamed from: y0, reason: collision with root package name */
    public final Context f20701y0;

    /* renamed from: z0, reason: collision with root package name */
    public final Paint f20702z0;

    /* renamed from: com.google.android.material.chip.a$a, reason: collision with other inner class name */
    public interface InterfaceC0232a {
        void a();
    }

    public a(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f20656M = -1.0f;
        this.f20702z0 = new Paint(1);
        this.f20642B0 = new Paint.FontMetrics();
        this.f20643C0 = new RectF();
        this.f20644D0 = new PointF();
        this.f20645E0 = new Path();
        this.f20661O0 = 255;
        this.f20669S0 = PorterDuff.Mode.SRC_IN;
        this.f20677W0 = new WeakReference<>(null);
        U(context);
        this.f20701y0 = context;
        p pVar = new p(this);
        this.f20646F0 = pVar;
        this.f20664Q = "";
        pVar.g().density = context.getResources().getDisplayMetrics().density;
        this.f20641A0 = null;
        int[] iArr = f20639b1;
        setState(iArr);
        y2(iArr);
        this.f20681Y0 = true;
        f20640c1.setTint(-1);
    }

    public static boolean D1(d dVar) {
        return (dVar == null || dVar.j() == null || !dVar.j().isStateful()) ? false : true;
    }

    public static boolean E1(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    public static boolean F1(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    public static a H0(Context context, AttributeSet attributeSet, int i10, int i11) {
        a aVar = new a(context, attributeSet, i10, i11);
        aVar.G1(attributeSet, i10, i11);
        return aVar;
    }

    public static boolean z1(int[] iArr, int i10) {
        if (iArr == null) {
            return false;
        }
        for (int i11 : iArr) {
            if (i11 == i10) {
                return true;
            }
        }
        return false;
    }

    public final void A0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (c3()) {
            float f10 = this.f20700x0 + this.f20699w0;
            if (C5566a.f(this) == 0) {
                float f11 = rect.right - f10;
                rectF.right = f11;
                rectF.left = f11 - this.f20684a0;
            } else {
                float f12 = rect.left + f10;
                rectF.left = f12;
                rectF.right = f12 + this.f20684a0;
            }
            float fExactCenterY = rect.exactCenterY();
            float f13 = this.f20684a0;
            float f14 = fExactCenterY - (f13 / 2.0f);
            rectF.top = f14;
            rectF.bottom = f14 + f13;
        }
    }

    public boolean A1() {
        return this.f20687c0;
    }

    public void A2(int i10) {
        z2(C4027a.a(this.f20701y0, i10));
    }

    public final void B0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (c3()) {
            float f10 = this.f20700x0 + this.f20699w0 + this.f20684a0 + this.f20698v0 + this.f20697u0;
            if (C5566a.f(this) == 0) {
                float f11 = rect.right;
                rectF.right = f11;
                rectF.left = f11 - f10;
            } else {
                int i10 = rect.left;
                rectF.left = i10;
                rectF.right = i10 + f10;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    public boolean B1() {
        return F1(this.f20678X);
    }

    public void B2(boolean z10) {
        if (this.f20676W != z10) {
            boolean zC3 = c3();
            this.f20676W = z10;
            boolean zC32 = c3();
            if (zC3 != zC32) {
                if (zC32) {
                    w0(this.f20678X);
                } else {
                    d3(this.f20678X);
                }
                invalidateSelf();
                H1();
            }
        }
    }

    public float C0() {
        if (c3()) {
            return this.f20698v0 + this.f20684a0 + this.f20699w0;
        }
        return 0.0f;
    }

    public boolean C1() {
        return this.f20676W;
    }

    public void C2(InterfaceC0232a interfaceC0232a) {
        this.f20677W0 = new WeakReference<>(interfaceC0232a);
    }

    public final void D0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (this.f20664Q != null) {
            float fY0 = this.f20693i0 + y0() + this.f20696t0;
            float fC0 = this.f20700x0 + C0() + this.f20697u0;
            if (C5566a.f(this) == 0) {
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

    public void D2(TextUtils.TruncateAt truncateAt) {
        this.f20679X0 = truncateAt;
    }

    public final float E0() {
        this.f20646F0.g().getFontMetrics(this.f20642B0);
        Paint.FontMetrics fontMetrics = this.f20642B0;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    public void E2(E2.h hVar) {
        this.f20692h0 = hVar;
    }

    public Paint.Align F0(Rect rect, PointF pointF) {
        pointF.set(0.0f, 0.0f);
        Paint.Align align = Paint.Align.LEFT;
        if (this.f20664Q != null) {
            float fY0 = this.f20693i0 + y0() + this.f20696t0;
            if (C5566a.f(this) == 0) {
                pointF.x = rect.left + fY0;
            } else {
                pointF.x = rect.right - fY0;
                align = Paint.Align.RIGHT;
            }
            pointF.y = rect.centerY() - E0();
        }
        return align;
    }

    public void F2(int i10) {
        E2(E2.h.c(this.f20701y0, i10));
    }

    public final boolean G0() {
        return this.f20688d0 && this.f20689e0 != null && this.f20687c0;
    }

    public final void G1(AttributeSet attributeSet, int i10, int i11) {
        TypedArray typedArrayI = r.i(this.f20701y0, attributeSet, R$styleable.Chip, i10, i11, new int[0]);
        this.f20685a1 = typedArrayI.hasValue(R$styleable.Chip_shapeAppearance);
        o2(c.a(this.f20701y0, typedArrayI, R$styleable.Chip_chipSurfaceColor));
        S1(c.a(this.f20701y0, typedArrayI, R$styleable.Chip_chipBackgroundColor));
        g2(typedArrayI.getDimension(R$styleable.Chip_chipMinHeight, 0.0f));
        int i12 = R$styleable.Chip_chipCornerRadius;
        if (typedArrayI.hasValue(i12)) {
            U1(typedArrayI.getDimension(i12, 0.0f));
        }
        k2(c.a(this.f20701y0, typedArrayI, R$styleable.Chip_chipStrokeColor));
        m2(typedArrayI.getDimension(R$styleable.Chip_chipStrokeWidth, 0.0f));
        L2(c.a(this.f20701y0, typedArrayI, R$styleable.Chip_rippleColor));
        Q2(typedArrayI.getText(R$styleable.Chip_android_text));
        d dVarG = c.g(this.f20701y0, typedArrayI, R$styleable.Chip_android_textAppearance);
        dVarG.o(typedArrayI.getDimension(R$styleable.Chip_android_textSize, dVarG.k()));
        R2(dVarG);
        int i13 = typedArrayI.getInt(R$styleable.Chip_android_ellipsize, 0);
        if (i13 == 1) {
            D2(TextUtils.TruncateAt.START);
        } else if (i13 == 2) {
            D2(TextUtils.TruncateAt.MIDDLE);
        } else if (i13 == 3) {
            D2(TextUtils.TruncateAt.END);
        }
        f2(typedArrayI.getBoolean(R$styleable.Chip_chipIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null) {
            f2(typedArrayI.getBoolean(R$styleable.Chip_chipIconEnabled, false));
        }
        Y1(c.d(this.f20701y0, typedArrayI, R$styleable.Chip_chipIcon));
        int i14 = R$styleable.Chip_chipIconTint;
        if (typedArrayI.hasValue(i14)) {
            c2(c.a(this.f20701y0, typedArrayI, i14));
        }
        a2(typedArrayI.getDimension(R$styleable.Chip_chipIconSize, -1.0f));
        B2(typedArrayI.getBoolean(R$styleable.Chip_closeIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null) {
            B2(typedArrayI.getBoolean(R$styleable.Chip_closeIconEnabled, false));
        }
        p2(c.d(this.f20701y0, typedArrayI, R$styleable.Chip_closeIcon));
        z2(c.a(this.f20701y0, typedArrayI, R$styleable.Chip_closeIconTint));
        u2(typedArrayI.getDimension(R$styleable.Chip_closeIconSize, 0.0f));
        K1(typedArrayI.getBoolean(R$styleable.Chip_android_checkable, false));
        R1(typedArrayI.getBoolean(R$styleable.Chip_checkedIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null) {
            R1(typedArrayI.getBoolean(R$styleable.Chip_checkedIconEnabled, false));
        }
        M1(c.d(this.f20701y0, typedArrayI, R$styleable.Chip_checkedIcon));
        int i15 = R$styleable.Chip_checkedIconTint;
        if (typedArrayI.hasValue(i15)) {
            O1(c.a(this.f20701y0, typedArrayI, i15));
        }
        O2(E2.h.b(this.f20701y0, typedArrayI, R$styleable.Chip_showMotionSpec));
        E2(E2.h.b(this.f20701y0, typedArrayI, R$styleable.Chip_hideMotionSpec));
        i2(typedArrayI.getDimension(R$styleable.Chip_chipStartPadding, 0.0f));
        I2(typedArrayI.getDimension(R$styleable.Chip_iconStartPadding, 0.0f));
        G2(typedArrayI.getDimension(R$styleable.Chip_iconEndPadding, 0.0f));
        W2(typedArrayI.getDimension(R$styleable.Chip_textStartPadding, 0.0f));
        T2(typedArrayI.getDimension(R$styleable.Chip_textEndPadding, 0.0f));
        w2(typedArrayI.getDimension(R$styleable.Chip_closeIconStartPadding, 0.0f));
        r2(typedArrayI.getDimension(R$styleable.Chip_closeIconEndPadding, 0.0f));
        W1(typedArrayI.getDimension(R$styleable.Chip_chipEndPadding, 0.0f));
        K2(typedArrayI.getDimensionPixelSize(R$styleable.Chip_android_maxWidth, Integer.MAX_VALUE));
        typedArrayI.recycle();
    }

    public void G2(float f10) {
        if (this.f20695k0 != f10) {
            float fY0 = y0();
            this.f20695k0 = f10;
            float fY02 = y0();
            invalidateSelf();
            if (fY0 != fY02) {
                H1();
            }
        }
    }

    public void H1() {
        InterfaceC0232a interfaceC0232a = this.f20677W0.get();
        if (interfaceC0232a != null) {
            interfaceC0232a.a();
        }
    }

    public void H2(int i10) {
        G2(this.f20701y0.getResources().getDimension(i10));
    }

    public final void I0(Canvas canvas, Rect rect) {
        if (a3()) {
            x0(rect, this.f20643C0);
            RectF rectF = this.f20643C0;
            float f10 = rectF.left;
            float f11 = rectF.top;
            canvas.translate(f10, f11);
            this.f20689e0.setBounds(0, 0, (int) this.f20643C0.width(), (int) this.f20643C0.height());
            this.f20689e0.draw(canvas);
            canvas.translate(-f10, -f11);
        }
    }

    public final boolean I1(int[] iArr, int[] iArr2) {
        boolean z10;
        boolean zOnStateChange = super.onStateChange(iArr);
        ColorStateList colorStateList = this.f20650J;
        int iQ = q(colorStateList != null ? colorStateList.getColorForState(iArr, this.f20647G0) : 0);
        boolean state = true;
        if (this.f20647G0 != iQ) {
            this.f20647G0 = iQ;
            zOnStateChange = true;
        }
        ColorStateList colorStateList2 = this.f20652K;
        int iQ2 = q(colorStateList2 != null ? colorStateList2.getColorForState(iArr, this.f20648H0) : 0);
        if (this.f20648H0 != iQ2) {
            this.f20648H0 = iQ2;
            zOnStateChange = true;
        }
        int i10 = M2.a.i(iQ, iQ2);
        if ((this.f20649I0 != i10) | (B() == null)) {
            this.f20649I0 = i10;
            g0(ColorStateList.valueOf(i10));
            zOnStateChange = true;
        }
        ColorStateList colorStateList3 = this.f20658N;
        int colorForState = colorStateList3 != null ? colorStateList3.getColorForState(iArr, this.f20651J0) : 0;
        if (this.f20651J0 != colorForState) {
            this.f20651J0 = colorForState;
            zOnStateChange = true;
        }
        int colorForState2 = (this.f20675V0 == null || !X2.a.e(iArr)) ? 0 : this.f20675V0.getColorForState(iArr, this.f20653K0);
        if (this.f20653K0 != colorForState2) {
            this.f20653K0 = colorForState2;
            if (this.f20673U0) {
                zOnStateChange = true;
            }
        }
        int colorForState3 = (this.f20646F0.e() == null || this.f20646F0.e().j() == null) ? 0 : this.f20646F0.e().j().getColorForState(iArr, this.f20655L0);
        if (this.f20655L0 != colorForState3) {
            this.f20655L0 = colorForState3;
            zOnStateChange = true;
        }
        boolean z11 = z1(getState(), R.attr.state_checked) && this.f20687c0;
        if (this.f20657M0 == z11 || this.f20689e0 == null) {
            z10 = false;
        } else {
            float fY0 = y0();
            this.f20657M0 = z11;
            if (fY0 != y0()) {
                zOnStateChange = true;
                z10 = true;
            } else {
                z10 = false;
                zOnStateChange = true;
            }
        }
        ColorStateList colorStateList4 = this.f20667R0;
        int colorForState4 = colorStateList4 != null ? colorStateList4.getColorForState(iArr, this.f20659N0) : 0;
        if (this.f20659N0 != colorForState4) {
            this.f20659N0 = colorForState4;
            this.f20665Q0 = O2.a.l(this, this.f20667R0, this.f20669S0);
        } else {
            state = zOnStateChange;
        }
        if (F1(this.f20668S)) {
            state |= this.f20668S.setState(iArr);
        }
        if (F1(this.f20689e0)) {
            state |= this.f20689e0.setState(iArr);
        }
        if (F1(this.f20678X)) {
            int[] iArr3 = new int[iArr.length + iArr2.length];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
            state |= this.f20678X.setState(iArr3);
        }
        if (F1(this.f20680Y)) {
            state |= this.f20680Y.setState(iArr2);
        }
        if (state) {
            invalidateSelf();
        }
        if (z10) {
            H1();
        }
        return state;
    }

    public void I2(float f10) {
        if (this.f20694j0 != f10) {
            float fY0 = y0();
            this.f20694j0 = f10;
            float fY02 = y0();
            invalidateSelf();
            if (fY0 != fY02) {
                H1();
            }
        }
    }

    public final void J0(Canvas canvas, Rect rect) {
        if (this.f20685a1) {
            return;
        }
        this.f20702z0.setColor(this.f20648H0);
        this.f20702z0.setStyle(Paint.Style.FILL);
        this.f20702z0.setColorFilter(x1());
        this.f20643C0.set(rect);
        canvas.drawRoundRect(this.f20643C0, U0(), U0(), this.f20702z0);
    }

    public boolean J1(boolean z10) {
        if (this.f20678X != null) {
            return y2(z10 ? new int[]{R.attr.state_pressed, R.attr.state_enabled} : f20639b1);
        }
        return false;
    }

    public void J2(int i10) {
        I2(this.f20701y0.getResources().getDimension(i10));
    }

    public final void K0(Canvas canvas, Rect rect) {
        if (b3()) {
            x0(rect, this.f20643C0);
            RectF rectF = this.f20643C0;
            float f10 = rectF.left;
            float f11 = rectF.top;
            canvas.translate(f10, f11);
            this.f20668S.setBounds(0, 0, (int) this.f20643C0.width(), (int) this.f20643C0.height());
            this.f20668S.draw(canvas);
            canvas.translate(-f10, -f11);
        }
    }

    public void K1(boolean z10) {
        if (this.f20687c0 != z10) {
            this.f20687c0 = z10;
            float fY0 = y0();
            if (!z10 && this.f20657M0) {
                this.f20657M0 = false;
            }
            float fY02 = y0();
            invalidateSelf();
            if (fY0 != fY02) {
                H1();
            }
        }
    }

    public void K2(int i10) {
        this.f20683Z0 = i10;
    }

    public final void L0(Canvas canvas, Rect rect) {
        if (this.f20660O <= 0.0f || this.f20685a1) {
            return;
        }
        this.f20702z0.setColor(this.f20651J0);
        this.f20702z0.setStyle(Paint.Style.STROKE);
        if (!this.f20685a1) {
            this.f20702z0.setColorFilter(x1());
        }
        RectF rectF = this.f20643C0;
        float f10 = rect.left;
        float f11 = this.f20660O;
        rectF.set(f10 + (f11 / 2.0f), rect.top + (f11 / 2.0f), rect.right - (f11 / 2.0f), rect.bottom - (f11 / 2.0f));
        float f12 = this.f20656M - (this.f20660O / 2.0f);
        canvas.drawRoundRect(this.f20643C0, f12, f12, this.f20702z0);
    }

    public void L1(int i10) {
        K1(this.f20701y0.getResources().getBoolean(i10));
    }

    public void L2(ColorStateList colorStateList) {
        if (this.f20662P != colorStateList) {
            this.f20662P = colorStateList;
            e3();
            onStateChange(getState());
        }
    }

    public final void M0(Canvas canvas, Rect rect) {
        if (this.f20685a1) {
            return;
        }
        this.f20702z0.setColor(this.f20647G0);
        this.f20702z0.setStyle(Paint.Style.FILL);
        this.f20643C0.set(rect);
        canvas.drawRoundRect(this.f20643C0, U0(), U0(), this.f20702z0);
    }

    public void M1(Drawable drawable) {
        if (this.f20689e0 != drawable) {
            float fY0 = y0();
            this.f20689e0 = drawable;
            float fY02 = y0();
            d3(this.f20689e0);
            w0(this.f20689e0);
            invalidateSelf();
            if (fY0 != fY02) {
                H1();
            }
        }
    }

    public void M2(int i10) {
        L2(C4027a.a(this.f20701y0, i10));
    }

    public final void N0(Canvas canvas, Rect rect) {
        if (c3()) {
            A0(rect, this.f20643C0);
            RectF rectF = this.f20643C0;
            float f10 = rectF.left;
            float f11 = rectF.top;
            canvas.translate(f10, f11);
            this.f20678X.setBounds(0, 0, (int) this.f20643C0.width(), (int) this.f20643C0.height());
            this.f20680Y.setBounds(this.f20678X.getBounds());
            this.f20680Y.jumpToCurrentState();
            this.f20680Y.draw(canvas);
            canvas.translate(-f10, -f11);
        }
    }

    public void N1(int i10) {
        M1(C4027a.b(this.f20701y0, i10));
    }

    public void N2(boolean z10) {
        this.f20681Y0 = z10;
    }

    public final void O0(Canvas canvas, Rect rect) {
        this.f20702z0.setColor(this.f20653K0);
        this.f20702z0.setStyle(Paint.Style.FILL);
        this.f20643C0.set(rect);
        if (!this.f20685a1) {
            canvas.drawRoundRect(this.f20643C0, U0(), U0(), this.f20702z0);
        } else {
            l(new RectF(rect), this.f20645E0);
            super.v(canvas, this.f20702z0, this.f20645E0, x());
        }
    }

    public void O1(ColorStateList colorStateList) {
        if (this.f20690f0 != colorStateList) {
            this.f20690f0 = colorStateList;
            if (G0()) {
                this.f20689e0.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public void O2(E2.h hVar) {
        this.f20691g0 = hVar;
    }

    public final void P0(Canvas canvas, Rect rect) {
        Canvas canvas2;
        Paint paint = this.f20641A0;
        if (paint != null) {
            paint.setColor(C5502d.k(-16777216, 127));
            canvas.drawRect(rect, this.f20641A0);
            if (b3() || a3()) {
                x0(rect, this.f20643C0);
                canvas.drawRect(this.f20643C0, this.f20641A0);
            }
            if (this.f20664Q != null) {
                canvas2 = canvas;
                canvas2.drawLine(rect.left, rect.exactCenterY(), rect.right, rect.exactCenterY(), this.f20641A0);
            } else {
                canvas2 = canvas;
            }
            if (c3()) {
                A0(rect, this.f20643C0);
                canvas2.drawRect(this.f20643C0, this.f20641A0);
            }
            this.f20641A0.setColor(C5502d.k(-65536, 127));
            z0(rect, this.f20643C0);
            canvas2.drawRect(this.f20643C0, this.f20641A0);
            this.f20641A0.setColor(C5502d.k(-16711936, 127));
            B0(rect, this.f20643C0);
            canvas2.drawRect(this.f20643C0, this.f20641A0);
        }
    }

    public void P1(int i10) {
        O1(C4027a.a(this.f20701y0, i10));
    }

    public void P2(int i10) {
        O2(E2.h.c(this.f20701y0, i10));
    }

    public final void Q0(Canvas canvas, Rect rect) {
        if (this.f20664Q != null) {
            Paint.Align alignF0 = F0(rect, this.f20644D0);
            D0(rect, this.f20643C0);
            if (this.f20646F0.e() != null) {
                this.f20646F0.g().drawableState = getState();
                this.f20646F0.n(this.f20701y0);
            }
            this.f20646F0.g().setTextAlign(alignF0);
            int iSave = 0;
            boolean z10 = Math.round(this.f20646F0.h(t1().toString())) > Math.round(this.f20643C0.width());
            if (z10) {
                iSave = canvas.save();
                canvas.clipRect(this.f20643C0);
            }
            CharSequence charSequenceEllipsize = this.f20664Q;
            if (z10 && this.f20679X0 != null) {
                charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, this.f20646F0.g(), this.f20643C0.width(), this.f20679X0);
            }
            CharSequence charSequence = charSequenceEllipsize;
            int length = charSequence.length();
            PointF pointF = this.f20644D0;
            canvas.drawText(charSequence, 0, length, pointF.x, pointF.y, this.f20646F0.g());
            if (z10) {
                canvas.restoreToCount(iSave);
            }
        }
    }

    public void Q1(int i10) {
        R1(this.f20701y0.getResources().getBoolean(i10));
    }

    public void Q2(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (TextUtils.equals(this.f20664Q, charSequence)) {
            return;
        }
        this.f20664Q = charSequence;
        this.f20646F0.m(true);
        invalidateSelf();
        H1();
    }

    public Drawable R0() {
        return this.f20689e0;
    }

    public void R1(boolean z10) {
        if (this.f20688d0 != z10) {
            boolean zA3 = a3();
            this.f20688d0 = z10;
            boolean zA32 = a3();
            if (zA3 != zA32) {
                if (zA32) {
                    w0(this.f20689e0);
                } else {
                    d3(this.f20689e0);
                }
                invalidateSelf();
                H1();
            }
        }
    }

    public void R2(d dVar) {
        this.f20646F0.k(dVar, this.f20701y0);
    }

    public ColorStateList S0() {
        return this.f20690f0;
    }

    public void S1(ColorStateList colorStateList) {
        if (this.f20652K != colorStateList) {
            this.f20652K = colorStateList;
            onStateChange(getState());
        }
    }

    public void S2(int i10) {
        R2(new d(this.f20701y0, i10));
    }

    public ColorStateList T0() {
        return this.f20652K;
    }

    public void T1(int i10) {
        S1(C4027a.a(this.f20701y0, i10));
    }

    public void T2(float f10) {
        if (this.f20697u0 != f10) {
            this.f20697u0 = f10;
            invalidateSelf();
            H1();
        }
    }

    public float U0() {
        return this.f20685a1 ? N() : this.f20656M;
    }

    @Deprecated
    public void U1(float f10) {
        if (this.f20656M != f10) {
            this.f20656M = f10;
            setShapeAppearanceModel(I().x(f10));
        }
    }

    public void U2(int i10) {
        T2(this.f20701y0.getResources().getDimension(i10));
    }

    public float V0() {
        return this.f20700x0;
    }

    @Deprecated
    public void V1(int i10) {
        U1(this.f20701y0.getResources().getDimension(i10));
    }

    public void V2(float f10) {
        d dVarU1 = u1();
        if (dVarU1 != null) {
            dVarU1.o(f10);
            this.f20646F0.g().setTextSize(f10);
            a();
        }
    }

    public Drawable W0() {
        Drawable drawable = this.f20668S;
        if (drawable != null) {
            return C5566a.q(drawable);
        }
        return null;
    }

    public void W1(float f10) {
        if (this.f20700x0 != f10) {
            this.f20700x0 = f10;
            invalidateSelf();
            H1();
        }
    }

    public void W2(float f10) {
        if (this.f20696t0 != f10) {
            this.f20696t0 = f10;
            invalidateSelf();
            H1();
        }
    }

    public float X0() {
        return this.f20672U;
    }

    public void X1(int i10) {
        W1(this.f20701y0.getResources().getDimension(i10));
    }

    public void X2(int i10) {
        W2(this.f20701y0.getResources().getDimension(i10));
    }

    public ColorStateList Y0() {
        return this.f20670T;
    }

    public void Y1(Drawable drawable) {
        Drawable drawableW0 = W0();
        if (drawableW0 != drawable) {
            float fY0 = y0();
            this.f20668S = drawable != null ? C5566a.r(drawable).mutate() : null;
            float fY02 = y0();
            d3(drawableW0);
            if (b3()) {
                w0(this.f20668S);
            }
            invalidateSelf();
            if (fY0 != fY02) {
                H1();
            }
        }
    }

    public void Y2(boolean z10) {
        if (this.f20673U0 != z10) {
            this.f20673U0 = z10;
            e3();
            onStateChange(getState());
        }
    }

    public float Z0() {
        return this.f20654L;
    }

    public void Z1(int i10) {
        Y1(C4027a.b(this.f20701y0, i10));
    }

    public boolean Z2() {
        return this.f20681Y0;
    }

    @Override // com.google.android.material.internal.p.b
    public void a() {
        H1();
        invalidateSelf();
    }

    public float a1() {
        return this.f20693i0;
    }

    public void a2(float f10) {
        if (this.f20672U != f10) {
            float fY0 = y0();
            this.f20672U = f10;
            float fY02 = y0();
            invalidateSelf();
            if (fY0 != fY02) {
                H1();
            }
        }
    }

    public final boolean a3() {
        return this.f20688d0 && this.f20689e0 != null && this.f20657M0;
    }

    public ColorStateList b1() {
        return this.f20658N;
    }

    public void b2(int i10) {
        a2(this.f20701y0.getResources().getDimension(i10));
    }

    public final boolean b3() {
        return this.f20666R && this.f20668S != null;
    }

    public float c1() {
        return this.f20660O;
    }

    public void c2(ColorStateList colorStateList) {
        this.f20674V = true;
        if (this.f20670T != colorStateList) {
            this.f20670T = colorStateList;
            if (b3()) {
                this.f20668S.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final boolean c3() {
        return this.f20676W && this.f20678X != null;
    }

    public Drawable d1() {
        Drawable drawable = this.f20678X;
        if (drawable != null) {
            return C5566a.q(drawable);
        }
        return null;
    }

    public void d2(int i10) {
        c2(C4027a.a(this.f20701y0, i10));
    }

    public final void d3(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    @Override // Z2.h, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Canvas canvas2;
        int iA;
        Rect bounds = getBounds();
        if (bounds.isEmpty() || getAlpha() == 0) {
            return;
        }
        int i10 = this.f20661O0;
        if (i10 < 255) {
            canvas2 = canvas;
            iA = G2.a.a(canvas2, bounds.left, bounds.top, bounds.right, bounds.bottom, i10);
        } else {
            canvas2 = canvas;
            iA = 0;
        }
        M0(canvas2, bounds);
        J0(canvas2, bounds);
        if (this.f20685a1) {
            super.draw(canvas2);
        }
        L0(canvas2, bounds);
        O0(canvas2, bounds);
        K0(canvas2, bounds);
        I0(canvas2, bounds);
        if (this.f20681Y0) {
            Q0(canvas2, bounds);
        }
        N0(canvas2, bounds);
        P0(canvas2, bounds);
        if (this.f20661O0 < 255) {
            canvas2.restoreToCount(iA);
        }
    }

    public CharSequence e1() {
        return this.f20686b0;
    }

    public void e2(int i10) {
        f2(this.f20701y0.getResources().getBoolean(i10));
    }

    public final void e3() {
        this.f20675V0 = this.f20673U0 ? X2.a.d(this.f20662P) : null;
    }

    public float f1() {
        return this.f20699w0;
    }

    public void f2(boolean z10) {
        if (this.f20666R != z10) {
            boolean zB3 = b3();
            this.f20666R = z10;
            boolean zB32 = b3();
            if (zB3 != zB32) {
                if (zB32) {
                    w0(this.f20668S);
                } else {
                    d3(this.f20668S);
                }
                invalidateSelf();
                H1();
            }
        }
    }

    public final void f3() {
        this.f20680Y = new RippleDrawable(X2.a.d(r1()), this.f20678X, f20640c1);
    }

    public float g1() {
        return this.f20684a0;
    }

    public void g2(float f10) {
        if (this.f20654L != f10) {
            this.f20654L = f10;
            invalidateSelf();
            H1();
        }
    }

    @Override // Z2.h, android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f20661O0;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f20663P0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.f20654L;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.min(Math.round(this.f20693i0 + y0() + this.f20696t0 + this.f20646F0.h(t1().toString()) + this.f20697u0 + C0() + this.f20700x0), this.f20683Z0);
    }

    @Override // Z2.h, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // Z2.h, android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        Outline outline2;
        if (this.f20685a1) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            outline2 = outline;
            outline2.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.f20656M);
        } else {
            outline.setRoundRect(bounds, this.f20656M);
            outline2 = outline;
        }
        outline2.setAlpha(getAlpha() / 255.0f);
    }

    public float h1() {
        return this.f20698v0;
    }

    public void h2(int i10) {
        g2(this.f20701y0.getResources().getDimension(i10));
    }

    public int[] i1() {
        return this.f20671T0;
    }

    public void i2(float f10) {
        if (this.f20693i0 != f10) {
            this.f20693i0 = f10;
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

    @Override // Z2.h, android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (E1(this.f20650J) || E1(this.f20652K) || E1(this.f20658N)) {
            return true;
        }
        return (this.f20673U0 && E1(this.f20675V0)) || D1(this.f20646F0.e()) || G0() || F1(this.f20668S) || F1(this.f20689e0) || E1(this.f20667R0);
    }

    public ColorStateList j1() {
        return this.f20682Z;
    }

    public void j2(int i10) {
        i2(this.f20701y0.getResources().getDimension(i10));
    }

    public void k1(RectF rectF) {
        B0(getBounds(), rectF);
    }

    public void k2(ColorStateList colorStateList) {
        if (this.f20658N != colorStateList) {
            this.f20658N = colorStateList;
            if (this.f20685a1) {
                o0(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final float l1() {
        Drawable drawable = this.f20657M0 ? this.f20689e0 : this.f20668S;
        float f10 = this.f20672U;
        if (f10 > 0.0f || drawable == null) {
            return f10;
        }
        float fCeil = (float) Math.ceil(u.c(this.f20701y0, 24));
        return ((float) drawable.getIntrinsicHeight()) <= fCeil ? drawable.getIntrinsicHeight() : fCeil;
    }

    public void l2(int i10) {
        k2(C4027a.a(this.f20701y0, i10));
    }

    public final float m1() {
        Drawable drawable = this.f20657M0 ? this.f20689e0 : this.f20668S;
        float f10 = this.f20672U;
        return (f10 > 0.0f || drawable == null) ? f10 : drawable.getIntrinsicWidth();
    }

    public void m2(float f10) {
        if (this.f20660O != f10) {
            this.f20660O = f10;
            this.f20702z0.setStrokeWidth(f10);
            if (this.f20685a1) {
                super.p0(f10);
            }
            invalidateSelf();
        }
    }

    public TextUtils.TruncateAt n1() {
        return this.f20679X0;
    }

    public void n2(int i10) {
        m2(this.f20701y0.getResources().getDimension(i10));
    }

    public E2.h o1() {
        return this.f20692h0;
    }

    public final void o2(ColorStateList colorStateList) {
        if (this.f20650J != colorStateList) {
            this.f20650J = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i10) {
        boolean zOnLayoutDirectionChanged = super.onLayoutDirectionChanged(i10);
        if (b3()) {
            zOnLayoutDirectionChanged |= C5566a.m(this.f20668S, i10);
        }
        if (a3()) {
            zOnLayoutDirectionChanged |= C5566a.m(this.f20689e0, i10);
        }
        if (c3()) {
            zOnLayoutDirectionChanged |= C5566a.m(this.f20678X, i10);
        }
        if (!zOnLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i10) {
        boolean zOnLevelChange = super.onLevelChange(i10);
        if (b3()) {
            zOnLevelChange |= this.f20668S.setLevel(i10);
        }
        if (a3()) {
            zOnLevelChange |= this.f20689e0.setLevel(i10);
        }
        if (c3()) {
            zOnLevelChange |= this.f20678X.setLevel(i10);
        }
        if (zOnLevelChange) {
            invalidateSelf();
        }
        return zOnLevelChange;
    }

    @Override // Z2.h, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        if (this.f20685a1) {
            super.onStateChange(iArr);
        }
        return I1(iArr, i1());
    }

    public float p1() {
        return this.f20695k0;
    }

    public void p2(Drawable drawable) {
        Drawable drawableD1 = d1();
        if (drawableD1 != drawable) {
            float fC0 = C0();
            this.f20678X = drawable != null ? C5566a.r(drawable).mutate() : null;
            f3();
            float fC02 = C0();
            d3(drawableD1);
            if (c3()) {
                w0(this.f20678X);
            }
            invalidateSelf();
            if (fC0 != fC02) {
                H1();
            }
        }
    }

    public float q1() {
        return this.f20694j0;
    }

    public void q2(CharSequence charSequence) {
        if (this.f20686b0 != charSequence) {
            this.f20686b0 = C6050a.c().h(charSequence);
            invalidateSelf();
        }
    }

    public ColorStateList r1() {
        return this.f20662P;
    }

    public void r2(float f10) {
        if (this.f20699w0 != f10) {
            this.f20699w0 = f10;
            invalidateSelf();
            if (c3()) {
                H1();
            }
        }
    }

    public E2.h s1() {
        return this.f20691g0;
    }

    public void s2(int i10) {
        r2(this.f20701y0.getResources().getDimension(i10));
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j10);
        }
    }

    @Override // Z2.h, android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        if (this.f20661O0 != i10) {
            this.f20661O0 = i10;
            invalidateSelf();
        }
    }

    @Override // Z2.h, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f20663P0 != colorFilter) {
            this.f20663P0 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // Z2.h, android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        if (this.f20667R0 != colorStateList) {
            this.f20667R0 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // Z2.h, android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.f20669S0 != mode) {
            this.f20669S0 = mode;
            this.f20665Q0 = O2.a.l(this, this.f20667R0, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        boolean visible = super.setVisible(z10, z11);
        if (b3()) {
            visible |= this.f20668S.setVisible(z10, z11);
        }
        if (a3()) {
            visible |= this.f20689e0.setVisible(z10, z11);
        }
        if (c3()) {
            visible |= this.f20678X.setVisible(z10, z11);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public CharSequence t1() {
        return this.f20664Q;
    }

    public void t2(int i10) {
        p2(C4027a.b(this.f20701y0, i10));
    }

    public d u1() {
        return this.f20646F0.e();
    }

    public void u2(float f10) {
        if (this.f20684a0 != f10) {
            this.f20684a0 = f10;
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
        return this.f20697u0;
    }

    public void v2(int i10) {
        u2(this.f20701y0.getResources().getDimension(i10));
    }

    public final void w0(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        C5566a.m(drawable, C5566a.f(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.f20678X) {
            if (drawable.isStateful()) {
                drawable.setState(i1());
            }
            drawable.setTintList(this.f20682Z);
            return;
        }
        Drawable drawable2 = this.f20668S;
        if (drawable == drawable2 && this.f20674V) {
            drawable2.setTintList(this.f20670T);
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
    }

    public float w1() {
        return this.f20696t0;
    }

    public void w2(float f10) {
        if (this.f20698v0 != f10) {
            this.f20698v0 = f10;
            invalidateSelf();
            if (c3()) {
                H1();
            }
        }
    }

    public final void x0(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (b3() || a3()) {
            float f10 = this.f20693i0 + this.f20694j0;
            float fM1 = m1();
            if (C5566a.f(this) == 0) {
                float f11 = rect.left + f10;
                rectF.left = f11;
                rectF.right = f11 + fM1;
            } else {
                float f12 = rect.right - f10;
                rectF.right = f12;
                rectF.left = f12 - fM1;
            }
            float fL1 = l1();
            float fExactCenterY = rect.exactCenterY() - (fL1 / 2.0f);
            rectF.top = fExactCenterY;
            rectF.bottom = fExactCenterY + fL1;
        }
    }

    public final ColorFilter x1() {
        ColorFilter colorFilter = this.f20663P0;
        return colorFilter != null ? colorFilter : this.f20665Q0;
    }

    public void x2(int i10) {
        w2(this.f20701y0.getResources().getDimension(i10));
    }

    public float y0() {
        if (b3() || a3()) {
            return this.f20694j0 + m1() + this.f20695k0;
        }
        return 0.0f;
    }

    public boolean y1() {
        return this.f20673U0;
    }

    public boolean y2(int[] iArr) {
        if (Arrays.equals(this.f20671T0, iArr)) {
            return false;
        }
        this.f20671T0 = iArr;
        if (c3()) {
            return I1(getState(), iArr);
        }
        return false;
    }

    public final void z0(Rect rect, RectF rectF) {
        rectF.set(rect);
        if (c3()) {
            float f10 = this.f20700x0 + this.f20699w0 + this.f20684a0 + this.f20698v0 + this.f20697u0;
            if (C5566a.f(this) == 0) {
                rectF.right = rect.right - f10;
            } else {
                rectF.left = rect.left + f10;
            }
        }
    }

    public void z2(ColorStateList colorStateList) {
        if (this.f20682Z != colorStateList) {
            this.f20682Z = colorStateList;
            if (c3()) {
                this.f20678X.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }
}
