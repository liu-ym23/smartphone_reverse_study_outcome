package com.google.android.material.chip;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
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
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.google.android.material.internal.g;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import l4.c;
import o0.b;
import w4.d;
import y4.g;
import y4.j;
import y4.k;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a extends g implements Drawable.Callback, g.b {
    public static final int[] P0 = {R.attr.state_enabled};
    public static final ShapeDrawable Q0 = new ShapeDrawable(new OvalShape());
    public int A0;
    public boolean B0;
    public int C0;
    public int D0;
    public ColorFilter E0;
    public PorterDuffColorFilter F0;
    public ColorStateList G0;
    public ColorStateList H;
    public PorterDuff.Mode H0;
    public ColorStateList I;
    public int[] I0;
    public float J;
    public ColorStateList J0;
    public float K;
    public WeakReference<InterfaceC0036a> K0;
    public ColorStateList L;
    public TextUtils.TruncateAt L0;
    public float M;
    public boolean M0;
    public ColorStateList N;
    public int N0;
    public CharSequence O;
    public boolean O0;
    public boolean P;
    public Drawable Q;
    public ColorStateList R;
    public float S;
    public boolean T;
    public boolean U;
    public Drawable V;
    public RippleDrawable W;
    public ColorStateList X;
    public float Y;
    public SpannableStringBuilder Z;

    /* renamed from: a0, reason: collision with root package name */
    public boolean f4876a0;
    public boolean b0;
    public Drawable c0;

    /* renamed from: d0, reason: collision with root package name */
    public ColorStateList f4877d0;

    /* renamed from: e0, reason: collision with root package name */
    public c f4878e0;

    /* renamed from: f0, reason: collision with root package name */
    public c f4879f0;

    /* renamed from: g0, reason: collision with root package name */
    public float f4880g0;

    /* renamed from: h0, reason: collision with root package name */
    public float f4881h0;

    /* renamed from: i0, reason: collision with root package name */
    public float f4882i0;

    /* renamed from: j0, reason: collision with root package name */
    public float f4883j0;

    /* renamed from: k0, reason: collision with root package name */
    public float f4884k0;

    /* renamed from: l0, reason: collision with root package name */
    public float f4885l0;

    /* renamed from: m0, reason: collision with root package name */
    public float f4886m0;

    /* renamed from: n0, reason: collision with root package name */
    public float f4887n0;

    /* renamed from: o0, reason: collision with root package name */
    public final Context f4888o0;

    /* renamed from: p0, reason: collision with root package name */
    public final Paint f4889p0;
    public final Paint.FontMetrics q0;

    /* renamed from: r0, reason: collision with root package name */
    public final RectF f4890r0;

    /* renamed from: s0, reason: collision with root package name */
    public final PointF f4891s0;

    /* renamed from: t0, reason: collision with root package name */
    public final Path f4892t0;

    /* renamed from: u0, reason: collision with root package name */
    public final com.google.android.material.internal.g f4893u0;

    /* renamed from: v0, reason: collision with root package name */
    public int f4894v0;

    /* renamed from: w0, reason: collision with root package name */
    public int f4895w0;

    /* renamed from: x0, reason: collision with root package name */
    public int f4896x0;

    /* renamed from: y0, reason: collision with root package name */
    public int f4897y0;
    public int z0;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: com.google.android.material.chip.a$a, reason: collision with other inner class name */
    public interface InterfaceC0036a {
        void a();
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, com.stepos.aiengine.R.attr.chipStyle, com.stepos.aiengine.R.style.Widget_MaterialComponents_Chip_Action);
        this.K = -1.0f;
        this.f4889p0 = new Paint(1);
        this.q0 = new Paint.FontMetrics();
        this.f4890r0 = new RectF();
        this.f4891s0 = new PointF();
        this.f4892t0 = new Path();
        this.D0 = 255;
        this.H0 = PorterDuff.Mode.SRC_IN;
        this.K0 = new WeakReference<>(null);
        k(context);
        this.f4888o0 = context;
        com.google.android.material.internal.g gVar = new com.google.android.material.internal.g(this);
        this.f4893u0 = gVar;
        this.O = "";
        gVar.f5098a.density = context.getResources().getDisplayMetrics().density;
        int[] iArr = P0;
        setState(iArr);
        R(iArr);
        this.M0 = true;
        Q0.setTint(-1);
    }

    public static void b0(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public static boolean y(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    public static boolean z(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    public final void A() {
        InterfaceC0036a interfaceC0036a = this.K0.get();
        if (interfaceC0036a != null) {
            interfaceC0036a.a();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean B(int[] r10, int[] r11) {
        /*
            Method dump skipped, instructions count: 378
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.a.B(int[], int[]):boolean");
    }

    public final void C(boolean z) {
        if (this.f4876a0 != z) {
            this.f4876a0 = z;
            float fV = v();
            if (!z && this.B0) {
                this.B0 = false;
            }
            float fV2 = v();
            invalidateSelf();
            if (fV != fV2) {
                A();
            }
        }
    }

    public final void D(Drawable drawable) {
        if (this.c0 != drawable) {
            float fV = v();
            this.c0 = drawable;
            float fV2 = v();
            b0(this.c0);
            t(this.c0);
            invalidateSelf();
            if (fV != fV2) {
                A();
            }
        }
    }

    public final void E(ColorStateList colorStateList) {
        Drawable drawable;
        if (this.f4877d0 != colorStateList) {
            this.f4877d0 = colorStateList;
            if (this.b0 && (drawable = this.c0) != null && this.f4876a0) {
                drawable.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void F(boolean z) {
        if (this.b0 != z) {
            boolean zY = Y();
            this.b0 = z;
            boolean zY2 = Y();
            if (zY != zY2) {
                if (zY2) {
                    t(this.c0);
                } else {
                    b0(this.c0);
                }
                invalidateSelf();
                A();
            }
        }
    }

    @Deprecated
    public final void G(float f8) {
        if (this.K != f8) {
            this.K = f8;
            j.a aVarF = this.f14023b.f14044a.f();
            aVarF.b(f8);
            setShapeAppearanceModel(aVarF.a());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void H(Drawable drawable) {
        Drawable drawableA;
        Drawable drawable2 = this.Q;
        if (drawable2 != 0) {
            boolean z = drawable2 instanceof b;
            drawableA = drawable2;
            if (z) {
                drawableA = ((b) drawable2).a();
            }
        } else {
            drawableA = null;
        }
        if (drawableA != drawable) {
            float fV = v();
            this.Q = drawable != null ? drawable.mutate() : null;
            float fV2 = v();
            b0(drawableA);
            if (Z()) {
                t(this.Q);
            }
            invalidateSelf();
            if (fV != fV2) {
                A();
            }
        }
    }

    public final void I(float f8) {
        if (this.S != f8) {
            float fV = v();
            this.S = f8;
            float fV2 = v();
            invalidateSelf();
            if (fV != fV2) {
                A();
            }
        }
    }

    public final void J(ColorStateList colorStateList) {
        this.T = true;
        if (this.R != colorStateList) {
            this.R = colorStateList;
            if (Z()) {
                this.Q.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void K(boolean z) {
        if (this.P != z) {
            boolean Z = Z();
            this.P = z;
            boolean Z2 = Z();
            if (Z != Z2) {
                if (Z2) {
                    t(this.Q);
                } else {
                    b0(this.Q);
                }
                invalidateSelf();
                A();
            }
        }
    }

    public final void L(ColorStateList colorStateList) {
        if (this.L != colorStateList) {
            this.L = colorStateList;
            if (this.O0) {
                g.c cVar = this.f14023b;
                if (cVar.f14048e != colorStateList) {
                    cVar.f14048e = colorStateList;
                    onStateChange(getState());
                }
            }
            onStateChange(getState());
        }
    }

    public final void M(float f8) {
        if (this.M != f8) {
            this.M = f8;
            this.f4889p0.setStrokeWidth(f8);
            if (this.O0) {
                this.f14023b.f14053k = f8;
                invalidateSelf();
            }
            invalidateSelf();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void N(Drawable drawable) {
        Drawable drawableA;
        Drawable drawable2 = this.V;
        if (drawable2 != 0) {
            boolean z = drawable2 instanceof b;
            drawableA = drawable2;
            if (z) {
                drawableA = ((b) drawable2).a();
            }
        } else {
            drawableA = null;
        }
        if (drawableA != drawable) {
            float fW = w();
            this.V = drawable != null ? drawable.mutate() : null;
            ColorStateList colorStateListValueOf = this.N;
            if (colorStateListValueOf == null) {
                colorStateListValueOf = ColorStateList.valueOf(0);
            }
            this.W = new RippleDrawable(colorStateListValueOf, this.V, Q0);
            float fW2 = w();
            b0(drawableA);
            if (a0()) {
                t(this.V);
            }
            invalidateSelf();
            if (fW != fW2) {
                A();
            }
        }
    }

    public final void O(float f8) {
        if (this.f4886m0 != f8) {
            this.f4886m0 = f8;
            invalidateSelf();
            if (a0()) {
                A();
            }
        }
    }

    public final void P(float f8) {
        if (this.Y != f8) {
            this.Y = f8;
            invalidateSelf();
            if (a0()) {
                A();
            }
        }
    }

    public final void Q(float f8) {
        if (this.f4885l0 != f8) {
            this.f4885l0 = f8;
            invalidateSelf();
            if (a0()) {
                A();
            }
        }
    }

    public final boolean R(int[] iArr) {
        if (Arrays.equals(this.I0, iArr)) {
            return false;
        }
        this.I0 = iArr;
        if (a0()) {
            return B(getState(), iArr);
        }
        return false;
    }

    public final void S(ColorStateList colorStateList) {
        if (this.X != colorStateList) {
            this.X = colorStateList;
            if (a0()) {
                this.V.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void T(boolean z) {
        if (this.U != z) {
            boolean zA0 = a0();
            this.U = z;
            boolean zA02 = a0();
            if (zA0 != zA02) {
                if (zA02) {
                    t(this.V);
                } else {
                    b0(this.V);
                }
                invalidateSelf();
                A();
            }
        }
    }

    public final void U(float f8) {
        if (this.f4882i0 != f8) {
            float fV = v();
            this.f4882i0 = f8;
            float fV2 = v();
            invalidateSelf();
            if (fV != fV2) {
                A();
            }
        }
    }

    public final void V(float f8) {
        if (this.f4881h0 != f8) {
            float fV = v();
            this.f4881h0 = f8;
            float fV2 = v();
            invalidateSelf();
            if (fV != fV2) {
                A();
            }
        }
    }

    public final void W(ColorStateList colorStateList) {
        if (this.N != colorStateList) {
            this.N = colorStateList;
            this.J0 = null;
            onStateChange(getState());
        }
    }

    public final void X(d dVar) {
        com.google.android.material.internal.g gVar = this.f4893u0;
        g.a aVar = gVar.f5099b;
        TextPaint textPaint = gVar.f5098a;
        if (gVar.f5103f != dVar) {
            gVar.f5103f = dVar;
            if (dVar != null) {
                Context context = this.f4888o0;
                dVar.e(context, textPaint, aVar);
                g.b bVar = gVar.f5102e.get();
                if (bVar != null) {
                    textPaint.drawableState = bVar.getState();
                }
                dVar.d(context, textPaint, aVar);
                gVar.f5101d = true;
            }
            g.b bVar2 = gVar.f5102e.get();
            if (bVar2 != null) {
                bVar2.a();
                bVar2.onStateChange(bVar2.getState());
            }
        }
    }

    public final boolean Y() {
        return this.b0 && this.c0 != null && this.B0;
    }

    public final boolean Z() {
        return this.P && this.Q != null;
    }

    @Override // com.google.android.material.internal.g.b
    public final void a() {
        A();
        invalidateSelf();
    }

    public final boolean a0() {
        return this.U && this.V != null;
    }

    @Override // y4.g, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        int i10;
        Canvas canvas2;
        int iSaveLayerAlpha;
        float f8;
        int i11;
        Rect bounds = getBounds();
        if (bounds.isEmpty() || (i10 = this.D0) == 0) {
            return;
        }
        if (i10 < 255) {
            canvas2 = canvas;
            iSaveLayerAlpha = canvas2.saveLayerAlpha(bounds.left, bounds.top, bounds.right, bounds.bottom, i10);
        } else {
            canvas2 = canvas;
            iSaveLayerAlpha = 0;
        }
        boolean z = this.O0;
        Paint paint = this.f4889p0;
        RectF rectF = this.f4890r0;
        if (!z) {
            paint.setColor(this.f4894v0);
            paint.setStyle(Paint.Style.FILL);
            rectF.set(bounds);
            canvas2.drawRoundRect(rectF, x(), x(), paint);
        }
        if (!this.O0) {
            paint.setColor(this.f4895w0);
            paint.setStyle(Paint.Style.FILL);
            ColorFilter colorFilter = this.E0;
            if (colorFilter == null) {
                colorFilter = this.F0;
            }
            paint.setColorFilter(colorFilter);
            rectF.set(bounds);
            canvas2.drawRoundRect(rectF, x(), x(), paint);
        }
        if (this.O0) {
            super.draw(canvas);
        }
        if (this.M > 0.0f && !this.O0) {
            paint.setColor(this.f4897y0);
            paint.setStyle(Paint.Style.STROKE);
            if (!this.O0) {
                ColorFilter colorFilter2 = this.E0;
                if (colorFilter2 == null) {
                    colorFilter2 = this.F0;
                }
                paint.setColorFilter(colorFilter2);
            }
            float f9 = bounds.left;
            float f10 = this.M / 2.0f;
            rectF.set(f9 + f10, bounds.top + f10, bounds.right - f10, bounds.bottom - f10);
            float f11 = this.K - (this.M / 2.0f);
            canvas2.drawRoundRect(rectF, f11, f11, paint);
        }
        paint.setColor(this.z0);
        paint.setStyle(Paint.Style.FILL);
        rectF.set(bounds);
        if (this.O0) {
            RectF rectF2 = new RectF(bounds);
            g.c cVar = this.f14023b;
            j jVar = cVar.f14044a;
            float[] fArr = this.D;
            float f12 = cVar.f14052j;
            g.b bVar = this.f14036t;
            k kVar = this.f14037u;
            f8 = 2.0f;
            Path path = this.f4892t0;
            kVar.a(jVar, fArr, f12, rectF2, bVar, path);
            e(canvas2, paint, path, this.f14023b.f14044a, this.D, g());
        } else {
            canvas2.drawRoundRect(rectF, x(), x(), paint);
            f8 = 2.0f;
        }
        if (Z()) {
            u(bounds, rectF);
            float f13 = rectF.left;
            float f14 = rectF.top;
            canvas2.translate(f13, f14);
            this.Q.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            this.Q.draw(canvas2);
            canvas2.translate(-f13, -f14);
        }
        if (Y()) {
            u(bounds, rectF);
            float f15 = rectF.left;
            float f16 = rectF.top;
            canvas2.translate(f15, f16);
            this.c0.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            this.c0.draw(canvas2);
            canvas2.translate(-f15, -f16);
        }
        if (this.M0 && this.O != null) {
            PointF pointF = this.f4891s0;
            pointF.set(0.0f, 0.0f);
            Paint.Align align = Paint.Align.LEFT;
            CharSequence charSequence = this.O;
            com.google.android.material.internal.g gVar = this.f4893u0;
            if (charSequence != null) {
                float fV = v() + this.f4880g0 + this.f4883j0;
                if (getLayoutDirection() == 0) {
                    pointF.x = bounds.left + fV;
                } else {
                    pointF.x = bounds.right - fV;
                    align = Paint.Align.RIGHT;
                }
                float fCenterY = bounds.centerY();
                TextPaint textPaint = gVar.f5098a;
                Paint.FontMetrics fontMetrics = this.q0;
                textPaint.getFontMetrics(fontMetrics);
                pointF.y = fCenterY - ((fontMetrics.descent + fontMetrics.ascent) / f8);
            }
            rectF.setEmpty();
            if (this.O != null) {
                float fV2 = v() + this.f4880g0 + this.f4883j0;
                float fW = w() + this.f4887n0 + this.f4884k0;
                if (getLayoutDirection() == 0) {
                    rectF.left = bounds.left + fV2;
                    rectF.right = bounds.right - fW;
                } else {
                    rectF.left = bounds.left + fW;
                    rectF.right = bounds.right - fV2;
                }
                rectF.top = bounds.top;
                rectF.bottom = bounds.bottom;
            }
            d dVar = gVar.f5103f;
            TextPaint textPaint2 = gVar.f5098a;
            if (dVar != null) {
                textPaint2.drawableState = getState();
                gVar.f5103f.d(this.f4888o0, textPaint2, gVar.f5099b);
            }
            textPaint2.setTextAlign(align);
            boolean z3 = Math.round(gVar.a(this.O.toString())) > Math.round(rectF.width());
            if (z3) {
                int iSave = canvas2.save();
                canvas2.clipRect(rectF);
                i11 = iSave;
            } else {
                i11 = 0;
            }
            CharSequence charSequenceEllipsize = this.O;
            if (z3 && this.L0 != null) {
                charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, textPaint2, rectF.width(), this.L0);
            }
            canvas.drawText(charSequenceEllipsize, 0, charSequenceEllipsize.length(), pointF.x, pointF.y, textPaint2);
            canvas2 = canvas;
            if (z3) {
                canvas2.restoreToCount(i11);
            }
        }
        if (a0()) {
            rectF.setEmpty();
            if (a0()) {
                float f17 = this.f4887n0 + this.f4886m0;
                if (getLayoutDirection() == 0) {
                    float f18 = bounds.right - f17;
                    rectF.right = f18;
                    rectF.left = f18 - this.Y;
                } else {
                    float f19 = bounds.left + f17;
                    rectF.left = f19;
                    rectF.right = f19 + this.Y;
                }
                float fExactCenterY = bounds.exactCenterY();
                float f20 = this.Y;
                float f21 = fExactCenterY - (f20 / f8);
                rectF.top = f21;
                rectF.bottom = f21 + f20;
            }
            float f22 = rectF.left;
            float f23 = rectF.top;
            canvas2.translate(f22, f23);
            this.V.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            this.W.setBounds(this.V.getBounds());
            this.W.jumpToCurrentState();
            this.W.draw(canvas2);
            canvas2.translate(-f22, -f23);
        }
        if (this.D0 < 255) {
            canvas2.restoreToCount(iSaveLayerAlpha);
        }
    }

    @Override // y4.g, android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.D0;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        return this.E0;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return (int) this.J;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return Math.min(Math.round(w() + this.f4893u0.a(this.O.toString()) + v() + this.f4880g0 + this.f4883j0 + this.f4884k0 + this.f4887n0), this.N0);
    }

    @Override // y4.g, android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // y4.g, android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        Outline outline2;
        if (this.O0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            outline2 = outline;
            outline2.setRoundRect(0, 0, getIntrinsicWidth(), (int) this.J, this.K);
        } else {
            outline.setRoundRect(bounds, this.K);
            outline2 = outline;
        }
        outline2.setAlpha(this.D0 / 255.0f);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // y4.g, android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList colorStateList;
        if (y(this.H) || y(this.I) || y(this.L)) {
            return true;
        }
        d dVar = this.f4893u0.f5103f;
        if (dVar == null || (colorStateList = dVar.f13590k) == null || !colorStateList.isStateful()) {
            return (this.b0 && this.c0 != null && this.f4876a0) || z(this.Q) || z(this.c0) || y(this.G0);
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLayoutDirectionChanged(int i10) {
        boolean zOnLayoutDirectionChanged = super.onLayoutDirectionChanged(i10);
        if (Z()) {
            zOnLayoutDirectionChanged |= this.Q.setLayoutDirection(i10);
        }
        if (Y()) {
            zOnLayoutDirectionChanged |= this.c0.setLayoutDirection(i10);
        }
        if (a0()) {
            zOnLayoutDirectionChanged |= this.V.setLayoutDirection(i10);
        }
        if (!zOnLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i10) {
        boolean zOnLevelChange = super.onLevelChange(i10);
        if (Z()) {
            zOnLevelChange |= this.Q.setLevel(i10);
        }
        if (Y()) {
            zOnLevelChange |= this.c0.setLevel(i10);
        }
        if (a0()) {
            zOnLevelChange |= this.V.setLevel(i10);
        }
        if (zOnLevelChange) {
            invalidateSelf();
        }
        return zOnLevelChange;
    }

    @Override // y4.g, android.graphics.drawable.Drawable, com.google.android.material.internal.g.b
    public final boolean onStateChange(int[] iArr) {
        if (this.O0) {
            super.onStateChange(iArr);
        }
        return B(iArr, this.I0);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j10);
        }
    }

    @Override // y4.g, android.graphics.drawable.Drawable
    public final void setAlpha(int i10) {
        if (this.D0 != i10) {
            this.D0 = i10;
            invalidateSelf();
        }
    }

    @Override // y4.g, android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.E0 != colorFilter) {
            this.E0 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // y4.g, android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        if (this.G0 != colorStateList) {
            this.G0 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // y4.g, android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        if (this.H0 != mode) {
            this.H0 = mode;
            ColorStateList colorStateList = this.G0;
            this.F0 = (colorStateList == null || mode == null) ? null : new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z3) {
        boolean visible = super.setVisible(z, z3);
        if (Z()) {
            visible |= this.Q.setVisible(z, z3);
        }
        if (Y()) {
            visible |= this.c0.setVisible(z, z3);
        }
        if (a0()) {
            visible |= this.V.setVisible(z, z3);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public final void t(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        drawable.setLayoutDirection(getLayoutDirection());
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.V) {
            if (drawable.isStateful()) {
                drawable.setState(this.I0);
            }
            drawable.setTintList(this.X);
            return;
        }
        Drawable drawable2 = this.Q;
        if (drawable == drawable2 && this.T) {
            drawable2.setTintList(this.R);
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
    }

    public final void u(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (Z() || Y()) {
            float f8 = this.f4880g0 + this.f4881h0;
            Drawable drawable = this.B0 ? this.c0 : this.Q;
            float intrinsicWidth = this.S;
            if (intrinsicWidth <= 0.0f && drawable != null) {
                intrinsicWidth = drawable.getIntrinsicWidth();
            }
            if (getLayoutDirection() == 0) {
                float f9 = rect.left + f8;
                rectF.left = f9;
                rectF.right = f9 + intrinsicWidth;
            } else {
                float f10 = rect.right - f8;
                rectF.right = f10;
                rectF.left = f10 - intrinsicWidth;
            }
            Drawable drawable2 = this.B0 ? this.c0 : this.Q;
            float fCeil = this.S;
            if (fCeil <= 0.0f && drawable2 != null) {
                fCeil = (float) Math.ceil(TypedValue.applyDimension(1, 24, this.f4888o0.getResources().getDisplayMetrics()));
                if (drawable2.getIntrinsicHeight() <= fCeil) {
                    fCeil = drawable2.getIntrinsicHeight();
                }
            }
            float fExactCenterY = rect.exactCenterY() - (fCeil / 2.0f);
            rectF.top = fExactCenterY;
            rectF.bottom = fExactCenterY + fCeil;
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public final float v() {
        if (!Z() && !Y()) {
            return 0.0f;
        }
        float f8 = this.f4881h0;
        Drawable drawable = this.B0 ? this.c0 : this.Q;
        float intrinsicWidth = this.S;
        if (intrinsicWidth <= 0.0f && drawable != null) {
            intrinsicWidth = drawable.getIntrinsicWidth();
        }
        return intrinsicWidth + f8 + this.f4882i0;
    }

    public final float w() {
        if (a0()) {
            return this.f4885l0 + this.Y + this.f4886m0;
        }
        return 0.0f;
    }

    public final float x() {
        if (!this.O0) {
            return this.K;
        }
        float[] fArr = this.D;
        return fArr != null ? fArr[3] : this.f14023b.f14044a.f14066e.a(g());
    }
}
