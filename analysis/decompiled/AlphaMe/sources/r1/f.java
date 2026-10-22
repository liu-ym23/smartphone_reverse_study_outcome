package r1;

import E.g;
import E.h;
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
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.i;
import com.stepos.alphame.utils.Property;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import n1.C0777c;
import w1.C0973d;
import y1.j;
import y1.m;

/* loaded from: classes.dex */
public final class f extends j implements Drawable.Callback, i {

    /* renamed from: a1, reason: collision with root package name */
    public static final int[] f14012a1 = {R.attr.state_enabled};

    /* renamed from: b1, reason: collision with root package name */
    public static final ShapeDrawable f14013b1 = new ShapeDrawable(new OvalShape());

    /* renamed from: A0, reason: collision with root package name */
    public final Paint.FontMetrics f14014A0;

    /* renamed from: B0, reason: collision with root package name */
    public final RectF f14015B0;

    /* renamed from: C0, reason: collision with root package name */
    public final PointF f14016C0;

    /* renamed from: D0, reason: collision with root package name */
    public final Path f14017D0;

    /* renamed from: E0, reason: collision with root package name */
    public final com.google.android.material.internal.j f14018E0;

    /* renamed from: F0, reason: collision with root package name */
    public int f14019F0;

    /* renamed from: G0, reason: collision with root package name */
    public int f14020G0;

    /* renamed from: H, reason: collision with root package name */
    public ColorStateList f14021H;

    /* renamed from: H0, reason: collision with root package name */
    public int f14022H0;

    /* renamed from: I, reason: collision with root package name */
    public ColorStateList f14023I;

    /* renamed from: I0, reason: collision with root package name */
    public int f14024I0;

    /* renamed from: J, reason: collision with root package name */
    public float f14025J;

    /* renamed from: J0, reason: collision with root package name */
    public int f14026J0;

    /* renamed from: K, reason: collision with root package name */
    public float f14027K;

    /* renamed from: K0, reason: collision with root package name */
    public int f14028K0;

    /* renamed from: L, reason: collision with root package name */
    public ColorStateList f14029L;

    /* renamed from: L0, reason: collision with root package name */
    public boolean f14030L0;

    /* renamed from: M, reason: collision with root package name */
    public float f14031M;

    /* renamed from: M0, reason: collision with root package name */
    public int f14032M0;

    /* renamed from: N, reason: collision with root package name */
    public ColorStateList f14033N;

    /* renamed from: N0, reason: collision with root package name */
    public int f14034N0;

    /* renamed from: O, reason: collision with root package name */
    public CharSequence f14035O;

    /* renamed from: O0, reason: collision with root package name */
    public ColorFilter f14036O0;

    /* renamed from: P, reason: collision with root package name */
    public boolean f14037P;

    /* renamed from: P0, reason: collision with root package name */
    public PorterDuffColorFilter f14038P0;

    /* renamed from: Q, reason: collision with root package name */
    public Drawable f14039Q;

    /* renamed from: Q0, reason: collision with root package name */
    public ColorStateList f14040Q0;

    /* renamed from: R, reason: collision with root package name */
    public ColorStateList f14041R;
    public PorterDuff.Mode R0;

    /* renamed from: S, reason: collision with root package name */
    public float f14042S;

    /* renamed from: S0, reason: collision with root package name */
    public int[] f14043S0;
    public boolean T;

    /* renamed from: T0, reason: collision with root package name */
    public boolean f14044T0;

    /* renamed from: U, reason: collision with root package name */
    public boolean f14045U;

    /* renamed from: U0, reason: collision with root package name */
    public ColorStateList f14046U0;

    /* renamed from: V, reason: collision with root package name */
    public Drawable f14047V;

    /* renamed from: V0, reason: collision with root package name */
    public WeakReference f14048V0;

    /* renamed from: W, reason: collision with root package name */
    public RippleDrawable f14049W;

    /* renamed from: W0, reason: collision with root package name */
    public TextUtils.TruncateAt f14050W0;

    /* renamed from: X, reason: collision with root package name */
    public ColorStateList f14051X;

    /* renamed from: X0, reason: collision with root package name */
    public boolean f14052X0;

    /* renamed from: Y, reason: collision with root package name */
    public float f14053Y;

    /* renamed from: Y0, reason: collision with root package name */
    public int f14054Y0;

    /* renamed from: Z, reason: collision with root package name */
    public SpannableStringBuilder f14055Z;

    /* renamed from: Z0, reason: collision with root package name */
    public boolean f14056Z0;

    /* renamed from: k0, reason: collision with root package name */
    public boolean f14057k0;

    /* renamed from: l0, reason: collision with root package name */
    public boolean f14058l0;

    /* renamed from: m0, reason: collision with root package name */
    public Drawable f14059m0;

    /* renamed from: n0, reason: collision with root package name */
    public ColorStateList f14060n0;

    /* renamed from: o0, reason: collision with root package name */
    public C0777c f14061o0;

    /* renamed from: p0, reason: collision with root package name */
    public C0777c f14062p0;

    /* renamed from: q0, reason: collision with root package name */
    public float f14063q0;

    /* renamed from: r0, reason: collision with root package name */
    public float f14064r0;

    /* renamed from: s0, reason: collision with root package name */
    public float f14065s0;

    /* renamed from: t0, reason: collision with root package name */
    public float f14066t0;

    /* renamed from: u0, reason: collision with root package name */
    public float f14067u0;

    /* renamed from: v0, reason: collision with root package name */
    public float f14068v0;

    /* renamed from: w0, reason: collision with root package name */
    public float f14069w0;

    /* renamed from: x0, reason: collision with root package name */
    public float f14070x0;

    /* renamed from: y0, reason: collision with root package name */
    public final Context f14071y0;

    /* renamed from: z0, reason: collision with root package name */
    public final Paint f14072z0;

    public f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, com.stepos.alphame.R.attr.chipStyle, com.stepos.alphame.R.style.Widget_MaterialComponents_Chip_Action);
        this.f14027K = -1.0f;
        this.f14072z0 = new Paint(1);
        this.f14014A0 = new Paint.FontMetrics();
        this.f14015B0 = new RectF();
        this.f14016C0 = new PointF();
        this.f14017D0 = new Path();
        this.f14034N0 = 255;
        this.R0 = PorterDuff.Mode.SRC_IN;
        this.f14048V0 = new WeakReference(null);
        l(context);
        this.f14071y0 = context;
        com.google.android.material.internal.j jVar = new com.google.android.material.internal.j(this);
        this.f14018E0 = jVar;
        this.f14035O = "";
        jVar.f10853a.density = context.getResources().getDisplayMetrics().density;
        int[] iArr = f14012a1;
        setState(iArr);
        S(iArr);
        this.f14052X0 = true;
        f14013b1.setTint(-1);
    }

    public static boolean A(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    public static void c0(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public static boolean z(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    public final void B() {
        e eVar = (e) this.f14048V0.get();
        if (eVar != null) {
            Chip chip = (Chip) eVar;
            chip.b(chip.f10585p);
            chip.requestLayout();
            chip.invalidateOutline();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean C(int[] r10, int[] r11) {
        /*
            Method dump skipped, instructions count: 383
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r1.f.C(int[], int[]):boolean");
    }

    public final void D(boolean z4) {
        if (this.f14057k0 != z4) {
            this.f14057k0 = z4;
            float fW = w();
            if (!z4 && this.f14030L0) {
                this.f14030L0 = false;
            }
            float fW2 = w();
            invalidateSelf();
            if (fW != fW2) {
                B();
            }
        }
    }

    public final void E(Drawable drawable) {
        if (this.f14059m0 != drawable) {
            float fW = w();
            this.f14059m0 = drawable;
            float fW2 = w();
            c0(this.f14059m0);
            u(this.f14059m0);
            invalidateSelf();
            if (fW != fW2) {
                B();
            }
        }
    }

    public final void F(ColorStateList colorStateList) {
        Drawable drawable;
        if (this.f14060n0 != colorStateList) {
            this.f14060n0 = colorStateList;
            if (this.f14058l0 && (drawable = this.f14059m0) != null && this.f14057k0) {
                drawable.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void G(boolean z4) {
        if (this.f14058l0 != z4) {
            boolean Z3 = Z();
            this.f14058l0 = z4;
            boolean Z4 = Z();
            if (Z3 != Z4) {
                if (Z4) {
                    u(this.f14059m0);
                } else {
                    c0(this.f14059m0);
                }
                invalidateSelf();
                B();
            }
        }
    }

    public final void H(float f4) {
        if (this.f14027K != f4) {
            this.f14027K = f4;
            m mVarF = this.f16234b.f16203a.f();
            mVarF.c(f4);
            setShapeAppearanceModel(mVarF.a());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void I(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f14039Q;
        if (drawable3 != 0) {
            boolean z4 = drawable3 instanceof g;
            drawable2 = drawable3;
            if (z4) {
                ((h) ((g) drawable3)).getClass();
                drawable2 = null;
            }
        } else {
            drawable2 = null;
        }
        if (drawable2 != drawable) {
            float fW = w();
            this.f14039Q = drawable != null ? drawable.mutate() : null;
            float fW2 = w();
            c0(drawable2);
            if (a0()) {
                u(this.f14039Q);
            }
            invalidateSelf();
            if (fW != fW2) {
                B();
            }
        }
    }

    public final void J(float f4) {
        if (this.f14042S != f4) {
            float fW = w();
            this.f14042S = f4;
            float fW2 = w();
            invalidateSelf();
            if (fW != fW2) {
                B();
            }
        }
    }

    public final void K(ColorStateList colorStateList) {
        this.T = true;
        if (this.f14041R != colorStateList) {
            this.f14041R = colorStateList;
            if (a0()) {
                this.f14039Q.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void L(boolean z4) {
        if (this.f14037P != z4) {
            boolean zA0 = a0();
            this.f14037P = z4;
            boolean zA02 = a0();
            if (zA0 != zA02) {
                if (zA02) {
                    u(this.f14039Q);
                } else {
                    c0(this.f14039Q);
                }
                invalidateSelf();
                B();
            }
        }
    }

    public final void M(ColorStateList colorStateList) {
        if (this.f14029L != colorStateList) {
            this.f14029L = colorStateList;
            if (this.f14056Z0) {
                y1.h hVar = this.f16234b;
                if (hVar.f16207e != colorStateList) {
                    hVar.f16207e = colorStateList;
                    onStateChange(getState());
                }
            }
            onStateChange(getState());
        }
    }

    public final void N(float f4) {
        if (this.f14031M != f4) {
            this.f14031M = f4;
            this.f14072z0.setStrokeWidth(f4);
            if (this.f14056Z0) {
                this.f16234b.f16214l = f4;
                invalidateSelf();
            }
            invalidateSelf();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void O(Drawable drawable) {
        Drawable drawable2;
        Drawable drawable3 = this.f14047V;
        if (drawable3 != 0) {
            boolean z4 = drawable3 instanceof g;
            drawable2 = drawable3;
            if (z4) {
                ((h) ((g) drawable3)).getClass();
                drawable2 = null;
            }
        } else {
            drawable2 = null;
        }
        if (drawable2 != drawable) {
            float fX = x();
            this.f14047V = drawable != null ? drawable.mutate() : null;
            ColorStateList colorStateListValueOf = this.f14033N;
            if (colorStateListValueOf == null) {
                colorStateListValueOf = ColorStateList.valueOf(0);
            }
            this.f14049W = new RippleDrawable(colorStateListValueOf, this.f14047V, f14013b1);
            float fX2 = x();
            c0(drawable2);
            if (b0()) {
                u(this.f14047V);
            }
            invalidateSelf();
            if (fX != fX2) {
                B();
            }
        }
    }

    public final void P(float f4) {
        if (this.f14069w0 != f4) {
            this.f14069w0 = f4;
            invalidateSelf();
            if (b0()) {
                B();
            }
        }
    }

    public final void Q(float f4) {
        if (this.f14053Y != f4) {
            this.f14053Y = f4;
            invalidateSelf();
            if (b0()) {
                B();
            }
        }
    }

    public final void R(float f4) {
        if (this.f14068v0 != f4) {
            this.f14068v0 = f4;
            invalidateSelf();
            if (b0()) {
                B();
            }
        }
    }

    public final boolean S(int[] iArr) {
        if (Arrays.equals(this.f14043S0, iArr)) {
            return false;
        }
        this.f14043S0 = iArr;
        if (b0()) {
            return C(getState(), iArr);
        }
        return false;
    }

    public final void T(ColorStateList colorStateList) {
        if (this.f14051X != colorStateList) {
            this.f14051X = colorStateList;
            if (b0()) {
                this.f14047V.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void U(boolean z4) {
        if (this.f14045U != z4) {
            boolean zB0 = b0();
            this.f14045U = z4;
            boolean zB02 = b0();
            if (zB0 != zB02) {
                if (zB02) {
                    u(this.f14047V);
                } else {
                    c0(this.f14047V);
                }
                invalidateSelf();
                B();
            }
        }
    }

    public final void V(float f4) {
        if (this.f14065s0 != f4) {
            float fW = w();
            this.f14065s0 = f4;
            float fW2 = w();
            invalidateSelf();
            if (fW != fW2) {
                B();
            }
        }
    }

    public final void W(float f4) {
        if (this.f14064r0 != f4) {
            float fW = w();
            this.f14064r0 = f4;
            float fW2 = w();
            invalidateSelf();
            if (fW != fW2) {
                B();
            }
        }
    }

    public final void X(ColorStateList colorStateList) {
        if (this.f14033N != colorStateList) {
            this.f14033N = colorStateList;
            if (!this.f14044T0) {
                colorStateList = null;
            } else if (colorStateList == null) {
                colorStateList = ColorStateList.valueOf(0);
            }
            this.f14046U0 = colorStateList;
            onStateChange(getState());
        }
    }

    public final void Y(C0973d c0973d) {
        com.google.android.material.internal.j jVar = this.f14018E0;
        if (jVar.f10858f != c0973d) {
            jVar.f10858f = c0973d;
            if (c0973d != null) {
                TextPaint textPaint = jVar.f10853a;
                Context context = this.f14071y0;
                b bVar = jVar.f10854b;
                c0973d.e(context, textPaint, bVar);
                i iVar = (i) jVar.f10857e.get();
                if (iVar != null) {
                    textPaint.drawableState = iVar.getState();
                }
                c0973d.d(context, textPaint, bVar);
                jVar.f10856d = true;
            }
            i iVar2 = (i) jVar.f10857e.get();
            if (iVar2 != null) {
                f fVar = (f) iVar2;
                fVar.B();
                fVar.invalidateSelf();
                fVar.onStateChange(iVar2.getState());
            }
        }
    }

    public final boolean Z() {
        return this.f14058l0 && this.f14059m0 != null && this.f14030L0;
    }

    public final boolean a0() {
        return this.f14037P && this.f14039Q != null;
    }

    public final boolean b0() {
        return this.f14045U && this.f14047V != null;
    }

    @Override // y1.j, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        int i4;
        int i5;
        Rect bounds = getBounds();
        if (bounds.isEmpty() || (i4 = this.f14034N0) == 0) {
            return;
        }
        int iSaveLayerAlpha = i4 < 255 ? canvas.saveLayerAlpha(bounds.left, bounds.top, bounds.right, bounds.bottom, i4) : 0;
        boolean z4 = this.f14056Z0;
        Paint paint = this.f14072z0;
        RectF rectF = this.f14015B0;
        if (!z4) {
            paint.setColor(this.f14019F0);
            paint.setStyle(Paint.Style.FILL);
            rectF.set(bounds);
            canvas.drawRoundRect(rectF, y(), y(), paint);
        }
        if (!this.f14056Z0) {
            paint.setColor(this.f14020G0);
            paint.setStyle(Paint.Style.FILL);
            ColorFilter colorFilter = this.f14036O0;
            if (colorFilter == null) {
                colorFilter = this.f14038P0;
            }
            paint.setColorFilter(colorFilter);
            rectF.set(bounds);
            canvas.drawRoundRect(rectF, y(), y(), paint);
        }
        if (this.f14056Z0) {
            super.draw(canvas);
        }
        if (this.f14031M > Property.DEFAULT_FLOAT_VALUE && !this.f14056Z0) {
            paint.setColor(this.f14024I0);
            paint.setStyle(Paint.Style.STROKE);
            if (!this.f14056Z0) {
                ColorFilter colorFilter2 = this.f14036O0;
                if (colorFilter2 == null) {
                    colorFilter2 = this.f14038P0;
                }
                paint.setColorFilter(colorFilter2);
            }
            float f4 = bounds.left;
            float f5 = this.f14031M / 2.0f;
            rectF.set(f4 + f5, bounds.top + f5, bounds.right - f5, bounds.bottom - f5);
            float f6 = this.f14027K - (this.f14031M / 2.0f);
            canvas.drawRoundRect(rectF, f6, f6, paint);
        }
        paint.setColor(this.f14026J0);
        paint.setStyle(Paint.Style.FILL);
        rectF.set(bounds);
        if (this.f14056Z0) {
            RectF rectF2 = new RectF(bounds);
            Path path = this.f14017D0;
            y1.h hVar = this.f16234b;
            this.f16251s.a(hVar.f16203a, this.f16230C, hVar.f16213k, rectF2, this.f16250r, path);
            f(canvas, paint, path, this.f16234b.f16203a, this.f16230C, h());
        } else {
            canvas.drawRoundRect(rectF, y(), y(), paint);
        }
        if (a0()) {
            v(bounds, rectF);
            float f7 = rectF.left;
            float f8 = rectF.top;
            canvas.translate(f7, f8);
            this.f14039Q.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            this.f14039Q.draw(canvas);
            canvas.translate(-f7, -f8);
        }
        if (Z()) {
            v(bounds, rectF);
            float f9 = rectF.left;
            float f10 = rectF.top;
            canvas.translate(f9, f10);
            this.f14059m0.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            this.f14059m0.draw(canvas);
            canvas.translate(-f9, -f10);
        }
        if (this.f14052X0 && this.f14035O != null) {
            PointF pointF = this.f14016C0;
            pointF.set(Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE);
            Paint.Align align = Paint.Align.LEFT;
            CharSequence charSequence = this.f14035O;
            com.google.android.material.internal.j jVar = this.f14018E0;
            if (charSequence != null) {
                float fW = w() + this.f14063q0 + this.f14066t0;
                if (E.b.a(this) == 0) {
                    pointF.x = bounds.left + fW;
                } else {
                    pointF.x = bounds.right - fW;
                    align = Paint.Align.RIGHT;
                }
                float fCenterY = bounds.centerY();
                TextPaint textPaint = jVar.f10853a;
                Paint.FontMetrics fontMetrics = this.f14014A0;
                textPaint.getFontMetrics(fontMetrics);
                pointF.y = fCenterY - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f);
            }
            rectF.setEmpty();
            if (this.f14035O != null) {
                float fW2 = w() + this.f14063q0 + this.f14066t0;
                float fX = x() + this.f14070x0 + this.f14067u0;
                if (E.b.a(this) == 0) {
                    rectF.left = bounds.left + fW2;
                    rectF.right = bounds.right - fX;
                } else {
                    rectF.left = bounds.left + fX;
                    rectF.right = bounds.right - fW2;
                }
                rectF.top = bounds.top;
                rectF.bottom = bounds.bottom;
            }
            C0973d c0973d = jVar.f10858f;
            TextPaint textPaint2 = jVar.f10853a;
            if (c0973d != null) {
                textPaint2.drawableState = getState();
                jVar.f10858f.d(this.f14071y0, textPaint2, jVar.f10854b);
            }
            textPaint2.setTextAlign(align);
            boolean z5 = Math.round(jVar.a(this.f14035O.toString())) > Math.round(rectF.width());
            if (z5) {
                int iSave = canvas.save();
                canvas.clipRect(rectF);
                i5 = iSave;
            } else {
                i5 = 0;
            }
            CharSequence charSequenceEllipsize = this.f14035O;
            if (z5 && this.f14050W0 != null) {
                charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, textPaint2, rectF.width(), this.f14050W0);
            }
            canvas.drawText(charSequenceEllipsize, 0, charSequenceEllipsize.length(), pointF.x, pointF.y, textPaint2);
            if (z5) {
                canvas.restoreToCount(i5);
            }
        }
        if (b0()) {
            rectF.setEmpty();
            if (b0()) {
                float f11 = this.f14070x0 + this.f14069w0;
                if (E.b.a(this) == 0) {
                    float f12 = bounds.right - f11;
                    rectF.right = f12;
                    rectF.left = f12 - this.f14053Y;
                } else {
                    float f13 = bounds.left + f11;
                    rectF.left = f13;
                    rectF.right = f13 + this.f14053Y;
                }
                float fExactCenterY = bounds.exactCenterY();
                float f14 = this.f14053Y;
                float f15 = fExactCenterY - (f14 / 2.0f);
                rectF.top = f15;
                rectF.bottom = f15 + f14;
            }
            float f16 = rectF.left;
            float f17 = rectF.top;
            canvas.translate(f16, f17);
            this.f14047V.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            this.f14049W.setBounds(this.f14047V.getBounds());
            this.f14049W.jumpToCurrentState();
            this.f14049W.draw(canvas);
            canvas.translate(-f16, -f17);
        }
        if (this.f14034N0 < 255) {
            canvas.restoreToCount(iSaveLayerAlpha);
        }
    }

    @Override // y1.j, android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f14034N0;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        return this.f14036O0;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return (int) this.f14025J;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return Math.min(Math.round(x() + this.f14018E0.a(this.f14035O.toString()) + w() + this.f14063q0 + this.f14066t0 + this.f14067u0 + this.f14070x0), this.f14054Y0);
    }

    @Override // y1.j, android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // y1.j, android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        if (this.f14056Z0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), (int) this.f14025J, this.f14027K);
        } else {
            outline.setRoundRect(bounds, this.f14027K);
        }
        outline.setAlpha(this.f14034N0 / 255.0f);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // y1.j, android.graphics.drawable.Drawable
    public final boolean isStateful() {
        C0973d c0973d;
        ColorStateList colorStateList;
        return z(this.f14021H) || z(this.f14023I) || z(this.f14029L) || (this.f14044T0 && z(this.f14046U0)) || (!((c0973d = this.f14018E0.f10858f) == null || (colorStateList = c0973d.f15823k) == null || !colorStateList.isStateful()) || ((this.f14058l0 && this.f14059m0 != null && this.f14057k0) || A(this.f14039Q) || A(this.f14059m0) || z(this.f14040Q0)));
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLayoutDirectionChanged(int i4) {
        boolean zOnLayoutDirectionChanged = super.onLayoutDirectionChanged(i4);
        if (a0()) {
            zOnLayoutDirectionChanged |= E.b.b(this.f14039Q, i4);
        }
        if (Z()) {
            zOnLayoutDirectionChanged |= E.b.b(this.f14059m0, i4);
        }
        if (b0()) {
            zOnLayoutDirectionChanged |= E.b.b(this.f14047V, i4);
        }
        if (!zOnLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i4) {
        boolean zOnLevelChange = super.onLevelChange(i4);
        if (a0()) {
            zOnLevelChange |= this.f14039Q.setLevel(i4);
        }
        if (Z()) {
            zOnLevelChange |= this.f14059m0.setLevel(i4);
        }
        if (b0()) {
            zOnLevelChange |= this.f14047V.setLevel(i4);
        }
        if (zOnLevelChange) {
            invalidateSelf();
        }
        return zOnLevelChange;
    }

    @Override // y1.j, android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        if (this.f14056Z0) {
            super.onStateChange(iArr);
        }
        return C(iArr, this.f14043S0);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j4) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j4);
        }
    }

    @Override // y1.j, android.graphics.drawable.Drawable
    public final void setAlpha(int i4) {
        if (this.f14034N0 != i4) {
            this.f14034N0 = i4;
            invalidateSelf();
        }
    }

    @Override // y1.j, android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.f14036O0 != colorFilter) {
            this.f14036O0 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // y1.j, android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        if (this.f14040Q0 != colorStateList) {
            this.f14040Q0 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // y1.j, android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        if (this.R0 != mode) {
            this.R0 = mode;
            ColorStateList colorStateList = this.f14040Q0;
            this.f14038P0 = (colorStateList == null || mode == null) ? null : new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z4, boolean z5) {
        boolean visible = super.setVisible(z4, z5);
        if (a0()) {
            visible |= this.f14039Q.setVisible(z4, z5);
        }
        if (Z()) {
            visible |= this.f14059m0.setVisible(z4, z5);
        }
        if (b0()) {
            visible |= this.f14047V.setVisible(z4, z5);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public final void u(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        E.b.b(drawable, E.b.a(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.f14047V) {
            if (drawable.isStateful()) {
                drawable.setState(this.f14043S0);
            }
            drawable.setTintList(this.f14051X);
            return;
        }
        Drawable drawable2 = this.f14039Q;
        if (drawable == drawable2 && this.T) {
            drawable2.setTintList(this.f14041R);
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public final void v(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (a0() || Z()) {
            float f4 = this.f14063q0 + this.f14064r0;
            Drawable drawable = this.f14030L0 ? this.f14059m0 : this.f14039Q;
            float intrinsicWidth = this.f14042S;
            if (intrinsicWidth <= Property.DEFAULT_FLOAT_VALUE && drawable != null) {
                intrinsicWidth = drawable.getIntrinsicWidth();
            }
            if (E.b.a(this) == 0) {
                float f5 = rect.left + f4;
                rectF.left = f5;
                rectF.right = f5 + intrinsicWidth;
            } else {
                float f6 = rect.right - f4;
                rectF.right = f6;
                rectF.left = f6 - intrinsicWidth;
            }
            Drawable drawable2 = this.f14030L0 ? this.f14059m0 : this.f14039Q;
            float fCeil = this.f14042S;
            if (fCeil <= Property.DEFAULT_FLOAT_VALUE && drawable2 != null) {
                fCeil = (float) Math.ceil(TypedValue.applyDimension(1, 24, this.f14071y0.getResources().getDisplayMetrics()));
                if (drawable2.getIntrinsicHeight() <= fCeil) {
                    fCeil = drawable2.getIntrinsicHeight();
                }
            }
            float fExactCenterY = rect.exactCenterY() - (fCeil / 2.0f);
            rectF.top = fExactCenterY;
            rectF.bottom = fExactCenterY + fCeil;
        }
    }

    public final float w() {
        if (!a0() && !Z()) {
            return Property.DEFAULT_FLOAT_VALUE;
        }
        float f4 = this.f14064r0;
        Drawable drawable = this.f14030L0 ? this.f14059m0 : this.f14039Q;
        float intrinsicWidth = this.f14042S;
        if (intrinsicWidth <= Property.DEFAULT_FLOAT_VALUE && drawable != null) {
            intrinsicWidth = drawable.getIntrinsicWidth();
        }
        return intrinsicWidth + f4 + this.f14065s0;
    }

    public final float x() {
        return b0() ? this.f14068v0 + this.f14053Y + this.f14069w0 : Property.DEFAULT_FLOAT_VALUE;
    }

    public final float y() {
        if (!this.f14056Z0) {
            return this.f14027K;
        }
        float[] fArr = this.f16230C;
        return fArr != null ? fArr[3] : this.f16234b.f16203a.f16276e.a(h());
    }
}
