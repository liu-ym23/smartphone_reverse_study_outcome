package V2;

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
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.core.graphics.drawable.DrawableCompat;
import c3.C0876f;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.h;
import com.google.android.material.internal.i;
import e3.C1419h;
import e3.k;
import e3.o;
import e3.p;
import e3.r;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class d extends k implements Drawable.Callback, h {

    /* renamed from: T0, reason: collision with root package name */
    public static final int[] f1304T0 = {R.attr.state_enabled};

    /* renamed from: U0, reason: collision with root package name */
    public static final ShapeDrawable f1305U0 = new ShapeDrawable(new OvalShape());

    /* renamed from: A0, reason: collision with root package name */
    public int f1306A0;

    /* renamed from: B0, reason: collision with root package name */
    public int f1307B0;

    /* renamed from: C0, reason: collision with root package name */
    public int f1308C0;

    /* renamed from: D0, reason: collision with root package name */
    public int f1309D0;

    /* renamed from: E0, reason: collision with root package name */
    public int f1310E0;

    /* renamed from: F0, reason: collision with root package name */
    public boolean f1311F0;

    /* renamed from: G0, reason: collision with root package name */
    public int f1312G0;

    /* renamed from: H0, reason: collision with root package name */
    public int f1313H0;
    public ColorFilter I0;

    /* renamed from: J0, reason: collision with root package name */
    public PorterDuffColorFilter f1314J0;
    public ColorStateList K0;

    /* renamed from: L, reason: collision with root package name */
    public ColorStateList f1315L;

    /* renamed from: L0, reason: collision with root package name */
    public PorterDuff.Mode f1316L0;

    /* renamed from: M, reason: collision with root package name */
    public ColorStateList f1317M;

    /* renamed from: M0, reason: collision with root package name */
    public int[] f1318M0;

    /* renamed from: N, reason: collision with root package name */
    public float f1319N;

    /* renamed from: N0, reason: collision with root package name */
    public ColorStateList f1320N0;

    /* renamed from: O, reason: collision with root package name */
    public float f1321O;

    /* renamed from: O0, reason: collision with root package name */
    public WeakReference f1322O0;

    /* renamed from: P, reason: collision with root package name */
    public ColorStateList f1323P;

    /* renamed from: P0, reason: collision with root package name */
    public TextUtils.TruncateAt f1324P0;

    /* renamed from: Q, reason: collision with root package name */
    public float f1325Q;

    /* renamed from: Q0, reason: collision with root package name */
    public boolean f1326Q0;

    /* renamed from: R, reason: collision with root package name */
    public ColorStateList f1327R;

    /* renamed from: R0, reason: collision with root package name */
    public int f1328R0;

    /* renamed from: S, reason: collision with root package name */
    public CharSequence f1329S;

    /* renamed from: S0, reason: collision with root package name */
    public boolean f1330S0;

    /* renamed from: T, reason: collision with root package name */
    public boolean f1331T;

    /* renamed from: U, reason: collision with root package name */
    public Drawable f1332U;

    /* renamed from: V, reason: collision with root package name */
    public ColorStateList f1333V;

    /* renamed from: W, reason: collision with root package name */
    public float f1334W;

    /* renamed from: X, reason: collision with root package name */
    public boolean f1335X;

    /* renamed from: Y, reason: collision with root package name */
    public boolean f1336Y;

    /* renamed from: Z, reason: collision with root package name */
    public Drawable f1337Z;

    /* renamed from: a0, reason: collision with root package name */
    public RippleDrawable f1338a0;
    public ColorStateList b0;

    /* renamed from: c0, reason: collision with root package name */
    public float f1339c0;

    /* renamed from: d0, reason: collision with root package name */
    public CharSequence f1340d0;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f1341e0;

    /* renamed from: f0, reason: collision with root package name */
    public boolean f1342f0;

    /* renamed from: g0, reason: collision with root package name */
    public Drawable f1343g0;

    /* renamed from: h0, reason: collision with root package name */
    public ColorStateList f1344h0;

    /* renamed from: i0, reason: collision with root package name */
    public Q2.c f1345i0;

    /* renamed from: j0, reason: collision with root package name */
    public Q2.c f1346j0;

    /* renamed from: k0, reason: collision with root package name */
    public float f1347k0;

    /* renamed from: l0, reason: collision with root package name */
    public float f1348l0;

    /* renamed from: m0, reason: collision with root package name */
    public float f1349m0;

    /* renamed from: n0, reason: collision with root package name */
    public float f1350n0;

    /* renamed from: o0, reason: collision with root package name */
    public float f1351o0;

    /* renamed from: p0, reason: collision with root package name */
    public float f1352p0;

    /* renamed from: q0, reason: collision with root package name */
    public float f1353q0;

    /* renamed from: r0, reason: collision with root package name */
    public float f1354r0;
    public final Context s0;
    public final Paint t0;

    /* renamed from: u0, reason: collision with root package name */
    public final Paint.FontMetrics f1355u0;

    /* renamed from: v0, reason: collision with root package name */
    public final RectF f1356v0;

    /* renamed from: w0, reason: collision with root package name */
    public final PointF f1357w0;

    /* renamed from: x0, reason: collision with root package name */
    public final Path f1358x0;

    /* renamed from: y0, reason: collision with root package name */
    public final i f1359y0;

    /* renamed from: z0, reason: collision with root package name */
    public int f1360z0;

    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, com.stepos.ability.R.attr.chipStyle, com.stepos.ability.R.style.Widget_MaterialComponents_Chip_Action);
        this.f1321O = -1.0f;
        this.t0 = new Paint(1);
        this.f1355u0 = new Paint.FontMetrics();
        this.f1356v0 = new RectF();
        this.f1357w0 = new PointF();
        this.f1358x0 = new Path();
        this.f1313H0 = 255;
        this.f1316L0 = PorterDuff.Mode.SRC_IN;
        this.f1322O0 = new WeakReference(null);
        m(context);
        this.s0 = context;
        i iVar = new i(this);
        this.f1359y0 = iVar;
        this.f1329S = "";
        iVar.f2501a.density = context.getResources().getDisplayMetrics().density;
        int[] iArr = f1304T0;
        setState(iArr);
        Y(iArr);
        this.f1326Q0 = true;
        f1305U0.setTint(-1);
    }

    public static boolean F(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    public static boolean G(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    public static void h0(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public final void A(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        DrawableCompat.setLayoutDirection(drawable, DrawableCompat.getLayoutDirection(this));
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.f1337Z) {
            if (drawable.isStateful()) {
                drawable.setState(this.f1318M0);
            }
            drawable.setTintList(this.b0);
            return;
        }
        Drawable drawable2 = this.f1332U;
        if (drawable == drawable2 && this.f1335X) {
            drawable2.setTintList(this.f1333V);
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
    }

    public final void B(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (f0() || e0()) {
            float f = this.f1347k0 + this.f1348l0;
            Drawable drawable = this.f1311F0 ? this.f1343g0 : this.f1332U;
            float intrinsicWidth = this.f1334W;
            if (intrinsicWidth <= 0.0f && drawable != null) {
                intrinsicWidth = drawable.getIntrinsicWidth();
            }
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                float f7 = rect.left + f;
                rectF.left = f7;
                rectF.right = f7 + intrinsicWidth;
            } else {
                float f9 = rect.right - f;
                rectF.right = f9;
                rectF.left = f9 - intrinsicWidth;
            }
            Drawable drawable2 = this.f1311F0 ? this.f1343g0 : this.f1332U;
            float fCeil = this.f1334W;
            if (fCeil <= 0.0f && drawable2 != null) {
                fCeil = (float) Math.ceil(TypedValue.applyDimension(1, 24, this.s0.getResources().getDisplayMetrics()));
                if (drawable2.getIntrinsicHeight() <= fCeil) {
                    fCeil = drawable2.getIntrinsicHeight();
                }
            }
            float fExactCenterY = rect.exactCenterY() - (fCeil / 2.0f);
            rectF.top = fExactCenterY;
            rectF.bottom = fExactCenterY + fCeil;
        }
    }

    public final float C() {
        if (!f0() && !e0()) {
            return 0.0f;
        }
        float f = this.f1348l0;
        Drawable drawable = this.f1311F0 ? this.f1343g0 : this.f1332U;
        float intrinsicWidth = this.f1334W;
        if (intrinsicWidth <= 0.0f && drawable != null) {
            intrinsicWidth = drawable.getIntrinsicWidth();
        }
        return intrinsicWidth + f + this.f1349m0;
    }

    public final float D() {
        if (g0()) {
            return this.f1352p0 + this.f1339c0 + this.f1353q0;
        }
        return 0.0f;
    }

    public final float E() {
        return this.f1330S0 ? k() : this.f1321O;
    }

    public final void H() {
        c cVar = (c) this.f1322O0.get();
        if (cVar != null) {
            Chip chip = (Chip) cVar;
            chip.c(chip.l);
            chip.requestLayout();
            chip.invalidateOutline();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean I(int[] r10, int[] r11) {
        /*
            Method dump skipped, instructions count: 378
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: V2.d.I(int[], int[]):boolean");
    }

    public final void J(boolean z10) {
        if (this.f1341e0 != z10) {
            this.f1341e0 = z10;
            float fC = C();
            if (!z10 && this.f1311F0) {
                this.f1311F0 = false;
            }
            float fC2 = C();
            invalidateSelf();
            if (fC != fC2) {
                H();
            }
        }
    }

    public final void K(Drawable drawable) {
        if (this.f1343g0 != drawable) {
            float fC = C();
            this.f1343g0 = drawable;
            float fC2 = C();
            h0(this.f1343g0);
            A(this.f1343g0);
            invalidateSelf();
            if (fC != fC2) {
                H();
            }
        }
    }

    public final void L(ColorStateList colorStateList) {
        Drawable drawable;
        if (this.f1344h0 != colorStateList) {
            this.f1344h0 = colorStateList;
            if (this.f1342f0 && (drawable = this.f1343g0) != null && this.f1341e0) {
                drawable.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void M(boolean z10) {
        if (this.f1342f0 != z10) {
            boolean zE0 = e0();
            this.f1342f0 = z10;
            boolean zE02 = e0();
            if (zE0 != zE02) {
                if (zE02) {
                    A(this.f1343g0);
                } else {
                    h0(this.f1343g0);
                }
                invalidateSelf();
                H();
            }
        }
    }

    public final void N(float f) {
        if (this.f1321O != f) {
            this.f1321O = f;
            o oVarF = this.b.f4345a.f();
            oVarF.c(f);
            setShapeAppearanceModel(oVarF.a());
        }
    }

    public final void O(Drawable drawable) {
        Drawable drawable2 = this.f1332U;
        Drawable drawableUnwrap = drawable2 != null ? DrawableCompat.unwrap(drawable2) : null;
        if (drawableUnwrap != drawable) {
            float fC = C();
            this.f1332U = drawable != null ? DrawableCompat.wrap(drawable).mutate() : null;
            float fC2 = C();
            h0(drawableUnwrap);
            if (f0()) {
                A(this.f1332U);
            }
            invalidateSelf();
            if (fC != fC2) {
                H();
            }
        }
    }

    public final void P(float f) {
        if (this.f1334W != f) {
            float fC = C();
            this.f1334W = f;
            float fC2 = C();
            invalidateSelf();
            if (fC != fC2) {
                H();
            }
        }
    }

    public final void Q(ColorStateList colorStateList) {
        this.f1335X = true;
        if (this.f1333V != colorStateList) {
            this.f1333V = colorStateList;
            if (f0()) {
                this.f1332U.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void R(boolean z10) {
        if (this.f1331T != z10) {
            boolean zF0 = f0();
            this.f1331T = z10;
            boolean zF02 = f0();
            if (zF0 != zF02) {
                if (zF02) {
                    A(this.f1332U);
                } else {
                    h0(this.f1332U);
                }
                invalidateSelf();
                H();
            }
        }
    }

    public final void S(ColorStateList colorStateList) {
        if (this.f1323P != colorStateList) {
            this.f1323P = colorStateList;
            if (this.f1330S0) {
                v(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void T(float f) {
        if (this.f1325Q != f) {
            this.f1325Q = f;
            this.t0.setStrokeWidth(f);
            if (this.f1330S0) {
                this.b.k = f;
                invalidateSelf();
            }
            invalidateSelf();
        }
    }

    public final void U(Drawable drawable) {
        Drawable drawable2 = this.f1337Z;
        Drawable drawableUnwrap = drawable2 != null ? DrawableCompat.unwrap(drawable2) : null;
        if (drawableUnwrap != drawable) {
            float fD = D();
            this.f1337Z = drawable != null ? DrawableCompat.wrap(drawable).mutate() : null;
            ColorStateList colorStateListValueOf = this.f1327R;
            if (colorStateListValueOf == null) {
                colorStateListValueOf = ColorStateList.valueOf(0);
            }
            this.f1338a0 = new RippleDrawable(colorStateListValueOf, this.f1337Z, f1305U0);
            float fD2 = D();
            h0(drawableUnwrap);
            if (g0()) {
                A(this.f1337Z);
            }
            invalidateSelf();
            if (fD != fD2) {
                H();
            }
        }
    }

    public final void V(float f) {
        if (this.f1353q0 != f) {
            this.f1353q0 = f;
            invalidateSelf();
            if (g0()) {
                H();
            }
        }
    }

    public final void W(float f) {
        if (this.f1339c0 != f) {
            this.f1339c0 = f;
            invalidateSelf();
            if (g0()) {
                H();
            }
        }
    }

    public final void X(float f) {
        if (this.f1352p0 != f) {
            this.f1352p0 = f;
            invalidateSelf();
            if (g0()) {
                H();
            }
        }
    }

    public final boolean Y(int[] iArr) {
        if (Arrays.equals(this.f1318M0, iArr)) {
            return false;
        }
        this.f1318M0 = iArr;
        if (g0()) {
            return I(getState(), iArr);
        }
        return false;
    }

    public final void Z(ColorStateList colorStateList) {
        if (this.b0 != colorStateList) {
            this.b0 = colorStateList;
            if (g0()) {
                this.f1337Z.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    @Override // e3.k, com.google.android.material.internal.h
    public final void a() {
        H();
        invalidateSelf();
    }

    public final void a0(boolean z10) {
        if (this.f1336Y != z10) {
            boolean zG0 = g0();
            this.f1336Y = z10;
            boolean zG02 = g0();
            if (zG0 != zG02) {
                if (zG02) {
                    A(this.f1337Z);
                } else {
                    h0(this.f1337Z);
                }
                invalidateSelf();
                H();
            }
        }
    }

    public final void b0(float f) {
        if (this.f1349m0 != f) {
            float fC = C();
            this.f1349m0 = f;
            float fC2 = C();
            invalidateSelf();
            if (fC != fC2) {
                H();
            }
        }
    }

    public final void c0(float f) {
        if (this.f1348l0 != f) {
            float fC = C();
            this.f1348l0 = f;
            float fC2 = C();
            invalidateSelf();
            if (fC != fC2) {
                H();
            }
        }
    }

    public final void d0(ColorStateList colorStateList) {
        if (this.f1327R != colorStateList) {
            this.f1327R = colorStateList;
            this.f1320N0 = null;
            onStateChange(getState());
        }
    }

    @Override // e3.k, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        int i;
        Canvas canvas2;
        int iSaveLayerAlpha;
        float f;
        int i6;
        Rect bounds = getBounds();
        if (bounds.isEmpty() || (i = this.f1313H0) == 0) {
            return;
        }
        if (i < 255) {
            canvas2 = canvas;
            iSaveLayerAlpha = canvas2.saveLayerAlpha(bounds.left, bounds.top, bounds.right, bounds.bottom, i);
        } else {
            canvas2 = canvas;
            iSaveLayerAlpha = 0;
        }
        boolean z10 = this.f1330S0;
        Paint paint = this.t0;
        RectF rectF = this.f1356v0;
        if (!z10) {
            paint.setColor(this.f1360z0);
            paint.setStyle(Paint.Style.FILL);
            rectF.set(bounds);
            canvas2.drawRoundRect(rectF, E(), E(), paint);
        }
        if (!this.f1330S0) {
            paint.setColor(this.f1306A0);
            paint.setStyle(Paint.Style.FILL);
            ColorFilter colorFilter = this.I0;
            if (colorFilter == null) {
                colorFilter = this.f1314J0;
            }
            paint.setColorFilter(colorFilter);
            rectF.set(bounds);
            canvas2.drawRoundRect(rectF, E(), E(), paint);
        }
        if (this.f1330S0) {
            super.draw(canvas);
        }
        if (this.f1325Q > 0.0f && !this.f1330S0) {
            paint.setColor(this.f1308C0);
            paint.setStyle(Paint.Style.STROKE);
            if (!this.f1330S0) {
                ColorFilter colorFilter2 = this.I0;
                if (colorFilter2 == null) {
                    colorFilter2 = this.f1314J0;
                }
                paint.setColorFilter(colorFilter2);
            }
            float f7 = bounds.left;
            float f9 = this.f1325Q / 2.0f;
            rectF.set(f7 + f9, bounds.top + f9, bounds.right - f9, bounds.bottom - f9);
            float f10 = this.f1321O - (this.f1325Q / 2.0f);
            canvas2.drawRoundRect(rectF, f10, f10, paint);
        }
        paint.setColor(this.f1309D0);
        paint.setStyle(Paint.Style.FILL);
        rectF.set(bounds);
        if (this.f1330S0) {
            RectF rectF2 = new RectF(bounds);
            C1419h c1419h = this.b;
            p pVar = c1419h.f4345a;
            float[] fArr = this.f4354C;
            float f11 = c1419h.f4346j;
            h2.d dVar = this.f4359r;
            r rVar = this.f4360s;
            f = 2.0f;
            Path path = this.f1358x0;
            rVar.a(pVar, fArr, f11, rectF2, dVar, path);
            f(canvas2, paint, path, this.b.f4345a, this.f4354C, h());
        } else {
            canvas2.drawRoundRect(rectF, E(), E(), paint);
            f = 2.0f;
        }
        if (f0()) {
            B(bounds, rectF);
            float f12 = rectF.left;
            float f13 = rectF.top;
            canvas2.translate(f12, f13);
            this.f1332U.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            this.f1332U.draw(canvas2);
            canvas2.translate(-f12, -f13);
        }
        if (e0()) {
            B(bounds, rectF);
            float f14 = rectF.left;
            float f15 = rectF.top;
            canvas2.translate(f14, f15);
            this.f1343g0.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            this.f1343g0.draw(canvas2);
            canvas2.translate(-f14, -f15);
        }
        if (this.f1326Q0 && this.f1329S != null) {
            PointF pointF = this.f1357w0;
            pointF.set(0.0f, 0.0f);
            Paint.Align align = Paint.Align.LEFT;
            CharSequence charSequence = this.f1329S;
            i iVar = this.f1359y0;
            if (charSequence != null) {
                float fC = C() + this.f1347k0 + this.f1350n0;
                if (DrawableCompat.getLayoutDirection(this) == 0) {
                    pointF.x = bounds.left + fC;
                } else {
                    pointF.x = bounds.right - fC;
                    align = Paint.Align.RIGHT;
                }
                float fCenterY = bounds.centerY();
                TextPaint textPaint = iVar.f2501a;
                Paint.FontMetrics fontMetrics = this.f1355u0;
                textPaint.getFontMetrics(fontMetrics);
                pointF.y = fCenterY - ((fontMetrics.descent + fontMetrics.ascent) / f);
            }
            rectF.setEmpty();
            if (this.f1329S != null) {
                float fC2 = C() + this.f1347k0 + this.f1350n0;
                float fD = D() + this.f1354r0 + this.f1351o0;
                if (DrawableCompat.getLayoutDirection(this) == 0) {
                    rectF.left = bounds.left + fC2;
                    rectF.right = bounds.right - fD;
                } else {
                    rectF.left = bounds.left + fD;
                    rectF.right = bounds.right - fC2;
                }
                rectF.top = bounds.top;
                rectF.bottom = bounds.bottom;
            }
            C0876f c0876f = iVar.f;
            TextPaint textPaint2 = iVar.f2501a;
            if (c0876f != null) {
                textPaint2.drawableState = getState();
                iVar.f.d(this.s0, textPaint2, iVar.b);
            }
            textPaint2.setTextAlign(align);
            boolean z11 = Math.round(iVar.a(this.f1329S.toString())) > Math.round(rectF.width());
            if (z11) {
                int iSave = canvas2.save();
                canvas2.clipRect(rectF);
                i6 = iSave;
            } else {
                i6 = 0;
            }
            CharSequence charSequenceEllipsize = this.f1329S;
            if (z11 && this.f1324P0 != null) {
                charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, textPaint2, rectF.width(), this.f1324P0);
            }
            canvas.drawText(charSequenceEllipsize, 0, charSequenceEllipsize.length(), pointF.x, pointF.y, textPaint2);
            canvas2 = canvas;
            if (z11) {
                canvas2.restoreToCount(i6);
            }
        }
        if (g0()) {
            rectF.setEmpty();
            if (g0()) {
                float f16 = this.f1354r0 + this.f1353q0;
                if (DrawableCompat.getLayoutDirection(this) == 0) {
                    float f17 = bounds.right - f16;
                    rectF.right = f17;
                    rectF.left = f17 - this.f1339c0;
                } else {
                    float f18 = bounds.left + f16;
                    rectF.left = f18;
                    rectF.right = f18 + this.f1339c0;
                }
                float fExactCenterY = bounds.exactCenterY();
                float f19 = this.f1339c0;
                float f20 = fExactCenterY - (f19 / f);
                rectF.top = f20;
                rectF.bottom = f20 + f19;
            }
            float f21 = rectF.left;
            float f22 = rectF.top;
            canvas2.translate(f21, f22);
            this.f1337Z.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            this.f1338a0.setBounds(this.f1337Z.getBounds());
            this.f1338a0.jumpToCurrentState();
            this.f1338a0.draw(canvas2);
            canvas2.translate(-f21, -f22);
        }
        if (this.f1313H0 < 255) {
            canvas2.restoreToCount(iSaveLayerAlpha);
        }
    }

    public final boolean e0() {
        return this.f1342f0 && this.f1343g0 != null && this.f1311F0;
    }

    public final boolean f0() {
        return this.f1331T && this.f1332U != null;
    }

    public final boolean g0() {
        return this.f1336Y && this.f1337Z != null;
    }

    @Override // e3.k, android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f1313H0;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        return this.I0;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return (int) this.f1319N;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return Math.min(Math.round(D() + this.f1359y0.a(this.f1329S.toString()) + C() + this.f1347k0 + this.f1350n0 + this.f1351o0 + this.f1354r0), this.f1328R0);
    }

    @Override // e3.k, android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // e3.k, android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        Outline outline2;
        if (this.f1330S0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            outline2 = outline;
            outline2.setRoundRect(0, 0, getIntrinsicWidth(), (int) this.f1319N, this.f1321O);
        } else {
            outline.setRoundRect(bounds, this.f1321O);
            outline2 = outline;
        }
        outline2.setAlpha(this.f1313H0 / 255.0f);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // e3.k, android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList colorStateList;
        if (F(this.f1315L) || F(this.f1317M) || F(this.f1323P)) {
            return true;
        }
        C0876f c0876f = this.f1359y0.f;
        if (c0876f == null || (colorStateList = c0876f.k) == null || !colorStateList.isStateful()) {
            return (this.f1342f0 && this.f1343g0 != null && this.f1341e0) || G(this.f1332U) || G(this.f1343g0) || F(this.K0);
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLayoutDirectionChanged(int i) {
        boolean zOnLayoutDirectionChanged = super.onLayoutDirectionChanged(i);
        if (f0()) {
            zOnLayoutDirectionChanged |= DrawableCompat.setLayoutDirection(this.f1332U, i);
        }
        if (e0()) {
            zOnLayoutDirectionChanged |= DrawableCompat.setLayoutDirection(this.f1343g0, i);
        }
        if (g0()) {
            zOnLayoutDirectionChanged |= DrawableCompat.setLayoutDirection(this.f1337Z, i);
        }
        if (!zOnLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i) {
        boolean zOnLevelChange = super.onLevelChange(i);
        if (f0()) {
            zOnLevelChange |= this.f1332U.setLevel(i);
        }
        if (e0()) {
            zOnLevelChange |= this.f1343g0.setLevel(i);
        }
        if (g0()) {
            zOnLevelChange |= this.f1337Z.setLevel(i);
        }
        if (zOnLevelChange) {
            invalidateSelf();
        }
        return zOnLevelChange;
    }

    @Override // e3.k, android.graphics.drawable.Drawable, com.google.android.material.internal.h
    public final boolean onStateChange(int[] iArr) {
        if (this.f1330S0) {
            super.onStateChange(iArr);
        }
        return I(iArr, this.f1318M0);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j5) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j5);
        }
    }

    @Override // e3.k, android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        if (this.f1313H0 != i) {
            this.f1313H0 = i;
            invalidateSelf();
        }
    }

    @Override // e3.k, android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.I0 != colorFilter) {
            this.I0 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // e3.k, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public final void setTintList(ColorStateList colorStateList) {
        if (this.K0 != colorStateList) {
            this.K0 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // e3.k, android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public final void setTintMode(PorterDuff.Mode mode) {
        if (this.f1316L0 != mode) {
            this.f1316L0 = mode;
            ColorStateList colorStateList = this.K0;
            this.f1314J0 = (colorStateList == null || mode == null) ? null : new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z10, boolean z11) {
        boolean visible = super.setVisible(z10, z11);
        if (f0()) {
            visible |= this.f1332U.setVisible(z10, z11);
        }
        if (e0()) {
            visible |= this.f1343g0.setVisible(z10, z11);
        }
        if (g0()) {
            visible |= this.f1337Z.setVisible(z10, z11);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }
}
