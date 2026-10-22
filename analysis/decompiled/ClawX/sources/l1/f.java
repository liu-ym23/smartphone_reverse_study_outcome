package l1;

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
import com.stepos.stepclaw.SecurePrefs;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import p1.h;
import p1.i;
import t1.g;
import t1.j;
import t1.m;
import t1.n;
import t1.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class f extends j implements Drawable.Callback, h {
    public static final int[] M0 = {R.attr.state_enabled};
    public static final ShapeDrawable N0 = new ShapeDrawable(new OvalShape());
    public int A0;
    public ColorFilter B0;
    public PorterDuffColorFilter C0;
    public ColorStateList D0;
    public ColorStateList E;
    public PorterDuff.Mode E0;
    public ColorStateList F;
    public int[] F0;
    public float G;
    public ColorStateList G0;
    public float H;
    public WeakReference H0;
    public ColorStateList I;
    public TextUtils.TruncateAt I0;
    public float J;
    public boolean J0;
    public ColorStateList K;
    public int K0;
    public CharSequence L;
    public boolean L0;
    public boolean M;
    public Drawable N;
    public ColorStateList O;
    public float P;
    public boolean Q;
    public boolean R;
    public Drawable S;
    public RippleDrawable T;
    public ColorStateList U;
    public float V;
    public SpannableStringBuilder W;
    public boolean X;
    public boolean Y;
    public Drawable Z;

    /* renamed from: a0, reason: collision with root package name */
    public ColorStateList f3738a0;

    /* renamed from: b0, reason: collision with root package name */
    public e1.b f3739b0;

    /* renamed from: c0, reason: collision with root package name */
    public e1.b f3740c0;

    /* renamed from: d0, reason: collision with root package name */
    public float f3741d0;

    /* renamed from: e0, reason: collision with root package name */
    public float f3742e0;

    /* renamed from: f0, reason: collision with root package name */
    public float f3743f0;

    /* renamed from: g0, reason: collision with root package name */
    public float f3744g0;

    /* renamed from: h0, reason: collision with root package name */
    public float f3745h0;

    /* renamed from: i0, reason: collision with root package name */
    public float f3746i0;

    /* renamed from: j0, reason: collision with root package name */
    public float f3747j0;
    public float k0;

    /* renamed from: l0, reason: collision with root package name */
    public final Context f3748l0;

    /* renamed from: m0, reason: collision with root package name */
    public final Paint f3749m0;

    /* renamed from: n0, reason: collision with root package name */
    public final Paint.FontMetrics f3750n0;

    /* renamed from: o0, reason: collision with root package name */
    public final RectF f3751o0;

    /* renamed from: p0, reason: collision with root package name */
    public final PointF f3752p0;

    /* renamed from: q0, reason: collision with root package name */
    public final Path f3753q0;

    /* renamed from: r0, reason: collision with root package name */
    public final i f3754r0;

    /* renamed from: s0, reason: collision with root package name */
    public int f3755s0;

    /* renamed from: t0, reason: collision with root package name */
    public int f3756t0;

    /* renamed from: u0, reason: collision with root package name */
    public int f3757u0;

    /* renamed from: v0, reason: collision with root package name */
    public int f3758v0;

    /* renamed from: w0, reason: collision with root package name */
    public int f3759w0;

    /* renamed from: x0, reason: collision with root package name */
    public int f3760x0;

    /* renamed from: y0, reason: collision with root package name */
    public boolean f3761y0;

    /* renamed from: z0, reason: collision with root package name */
    public int f3762z0;

    public f(Context context, AttributeSet attributeSet) {
        super(n.b(context, attributeSet, com.stepos.stepclaw.R.attr.chipStyle, com.stepos.stepclaw.R.style.Widget_MaterialComponents_Chip_Action).a());
        this.H = -1.0f;
        this.f3749m0 = new Paint(1);
        this.f3750n0 = new Paint.FontMetrics();
        this.f3751o0 = new RectF();
        this.f3752p0 = new PointF();
        this.f3753q0 = new Path();
        this.A0 = 255;
        this.E0 = PorterDuff.Mode.SRC_IN;
        this.H0 = new WeakReference(null);
        j(context);
        this.f3748l0 = context;
        i iVar = new i(this);
        this.f3754r0 = iVar;
        this.L = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        iVar.f4716a.density = context.getResources().getDisplayMetrics().density;
        int[] iArr = M0;
        setState(iArr);
        Q(iArr);
        this.J0 = true;
        N0.setTint(-1);
    }

    public static void a0(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public static boolean x(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    public static boolean y(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean A(int[] r10, int[] r11) {
        /*
            Method dump skipped, instructions count: 378
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: l1.f.A(int[], int[]):boolean");
    }

    public final void B(boolean z) {
        if (this.X != z) {
            this.X = z;
            float fU = u();
            if (!z && this.f3761y0) {
                this.f3761y0 = false;
            }
            float fU2 = u();
            invalidateSelf();
            if (fU != fU2) {
                z();
            }
        }
    }

    public final void C(Drawable drawable) {
        if (this.Z != drawable) {
            float fU = u();
            this.Z = drawable;
            float fU2 = u();
            a0(this.Z);
            s(this.Z);
            invalidateSelf();
            if (fU != fU2) {
                z();
            }
        }
    }

    public final void D(ColorStateList colorStateList) {
        Drawable drawable;
        if (this.f3738a0 != colorStateList) {
            this.f3738a0 = colorStateList;
            if (this.Y && (drawable = this.Z) != null && this.X) {
                drawable.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void E(boolean z) {
        if (this.Y != z) {
            boolean zX = X();
            this.Y = z;
            boolean zX2 = X();
            if (zX != zX2) {
                if (zX2) {
                    s(this.Z);
                } else {
                    a0(this.Z);
                }
                invalidateSelf();
                z();
            }
        }
    }

    public final void F(float f3) {
        if (this.H != f3) {
            this.H = f3;
            m mVarF = this.f5475b.f5457a.f();
            mVarF.f5500e = new t1.a(f3);
            mVarF.f5501f = new t1.a(f3);
            mVarF.f5502g = new t1.a(f3);
            mVarF.f5503h = new t1.a(f3);
            setShapeAppearanceModel(mVarF.a());
        }
    }

    public final void G(Drawable drawable) {
        Drawable drawable2 = this.N;
        if (drawable2 == null) {
            drawable2 = null;
        }
        if (drawable2 != drawable) {
            float fU = u();
            this.N = drawable != null ? drawable.mutate() : null;
            float fU2 = u();
            a0(drawable2);
            if (Y()) {
                s(this.N);
            }
            invalidateSelf();
            if (fU != fU2) {
                z();
            }
        }
    }

    public final void H(float f3) {
        if (this.P != f3) {
            float fU = u();
            this.P = f3;
            float fU2 = u();
            invalidateSelf();
            if (fU != fU2) {
                z();
            }
        }
    }

    public final void I(ColorStateList colorStateList) {
        this.Q = true;
        if (this.O != colorStateList) {
            this.O = colorStateList;
            if (Y()) {
                this.N.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void J(boolean z) {
        if (this.M != z) {
            boolean zY = Y();
            this.M = z;
            boolean zY2 = Y();
            if (zY != zY2) {
                if (zY2) {
                    s(this.N);
                } else {
                    a0(this.N);
                }
                invalidateSelf();
                z();
            }
        }
    }

    public final void K(ColorStateList colorStateList) {
        if (this.I != colorStateList) {
            this.I = colorStateList;
            if (this.L0) {
                t1.h hVar = this.f5475b;
                if (hVar.f5460e != colorStateList) {
                    hVar.f5460e = colorStateList;
                    onStateChange(getState());
                }
            }
            onStateChange(getState());
        }
    }

    public final void L(float f3) {
        if (this.J != f3) {
            this.J = f3;
            this.f3749m0.setStrokeWidth(f3);
            if (this.L0) {
                this.f5475b.f5466k = f3;
                invalidateSelf();
            }
            invalidateSelf();
        }
    }

    public final void M(Drawable drawable) {
        Drawable drawable2 = this.S;
        if (drawable2 == null) {
            drawable2 = null;
        }
        if (drawable2 != drawable) {
            float fV = v();
            this.S = drawable != null ? drawable.mutate() : null;
            ColorStateList colorStateListValueOf = this.K;
            if (colorStateListValueOf == null) {
                colorStateListValueOf = ColorStateList.valueOf(0);
            }
            this.T = new RippleDrawable(colorStateListValueOf, this.S, N0);
            float fV2 = v();
            a0(drawable2);
            if (Z()) {
                s(this.S);
            }
            invalidateSelf();
            if (fV != fV2) {
                z();
            }
        }
    }

    public final void N(float f3) {
        if (this.f3747j0 != f3) {
            this.f3747j0 = f3;
            invalidateSelf();
            if (Z()) {
                z();
            }
        }
    }

    public final void O(float f3) {
        if (this.V != f3) {
            this.V = f3;
            invalidateSelf();
            if (Z()) {
                z();
            }
        }
    }

    public final void P(float f3) {
        if (this.f3746i0 != f3) {
            this.f3746i0 = f3;
            invalidateSelf();
            if (Z()) {
                z();
            }
        }
    }

    public final boolean Q(int[] iArr) {
        if (Arrays.equals(this.F0, iArr)) {
            return false;
        }
        this.F0 = iArr;
        if (Z()) {
            return A(getState(), iArr);
        }
        return false;
    }

    public final void R(ColorStateList colorStateList) {
        if (this.U != colorStateList) {
            this.U = colorStateList;
            if (Z()) {
                this.S.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void S(boolean z) {
        if (this.R != z) {
            boolean Z = Z();
            this.R = z;
            boolean Z2 = Z();
            if (Z != Z2) {
                if (Z2) {
                    s(this.S);
                } else {
                    a0(this.S);
                }
                invalidateSelf();
                z();
            }
        }
    }

    public final void T(float f3) {
        if (this.f3743f0 != f3) {
            float fU = u();
            this.f3743f0 = f3;
            float fU2 = u();
            invalidateSelf();
            if (fU != fU2) {
                z();
            }
        }
    }

    public final void U(float f3) {
        if (this.f3742e0 != f3) {
            float fU = u();
            this.f3742e0 = f3;
            float fU2 = u();
            invalidateSelf();
            if (fU != fU2) {
                z();
            }
        }
    }

    public final void V(ColorStateList colorStateList) {
        if (this.K != colorStateList) {
            this.K = colorStateList;
            this.G0 = null;
            onStateChange(getState());
        }
    }

    public final void W(r1.d dVar) {
        i iVar = this.f3754r0;
        b bVar = iVar.f4717b;
        TextPaint textPaint = iVar.f4716a;
        if (iVar.f4720f != dVar) {
            iVar.f4720f = dVar;
            if (dVar != null) {
                Context context = this.f3748l0;
                dVar.e(context, textPaint, bVar);
                h hVar = (h) iVar.f4719e.get();
                if (hVar != null) {
                    textPaint.drawableState = hVar.getState();
                }
                dVar.d(context, textPaint, bVar);
                iVar.d = true;
            }
            h hVar2 = (h) iVar.f4719e.get();
            if (hVar2 != null) {
                f fVar = (f) hVar2;
                fVar.z();
                fVar.invalidateSelf();
                fVar.onStateChange(hVar2.getState());
            }
        }
    }

    public final boolean X() {
        return this.Y && this.Z != null && this.f3761y0;
    }

    public final boolean Y() {
        return this.M && this.N != null;
    }

    public final boolean Z() {
        return this.R && this.S != null;
    }

    @Override // t1.j, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        int i8;
        Canvas canvas2;
        int iSaveLayerAlpha;
        float f3;
        int i9;
        Rect bounds = getBounds();
        if (bounds.isEmpty() || (i8 = this.A0) == 0) {
            return;
        }
        if (i8 < 255) {
            canvas2 = canvas;
            iSaveLayerAlpha = canvas2.saveLayerAlpha(bounds.left, bounds.top, bounds.right, bounds.bottom, i8);
        } else {
            canvas2 = canvas;
            iSaveLayerAlpha = 0;
        }
        boolean z = this.L0;
        Paint paint = this.f3749m0;
        RectF rectF = this.f3751o0;
        if (!z) {
            paint.setColor(this.f3755s0);
            paint.setStyle(Paint.Style.FILL);
            rectF.set(bounds);
            canvas2.drawRoundRect(rectF, w(), w(), paint);
        }
        if (!this.L0) {
            paint.setColor(this.f3756t0);
            paint.setStyle(Paint.Style.FILL);
            ColorFilter colorFilter = this.B0;
            if (colorFilter == null) {
                colorFilter = this.C0;
            }
            paint.setColorFilter(colorFilter);
            rectF.set(bounds);
            canvas2.drawRoundRect(rectF, w(), w(), paint);
        }
        if (this.L0) {
            super.draw(canvas);
        }
        if (this.J > 0.0f && !this.L0) {
            paint.setColor(this.f3758v0);
            paint.setStyle(Paint.Style.STROKE);
            if (!this.L0) {
                ColorFilter colorFilter2 = this.B0;
                if (colorFilter2 == null) {
                    colorFilter2 = this.C0;
                }
                paint.setColorFilter(colorFilter2);
            }
            float f7 = bounds.left;
            float f9 = this.J / 2.0f;
            rectF.set(f7 + f9, bounds.top + f9, bounds.right - f9, bounds.bottom - f9);
            float f10 = this.H - (this.J / 2.0f);
            canvas2.drawRoundRect(rectF, f10, f10, paint);
        }
        paint.setColor(this.f3759w0);
        paint.setStyle(Paint.Style.FILL);
        rectF.set(bounds);
        if (this.L0) {
            RectF rectF2 = new RectF(bounds);
            t1.h hVar = this.f5475b;
            n nVar = hVar.f5457a;
            float[] fArr = this.A;
            float f11 = hVar.f5465j;
            g gVar = this.f5489r;
            p pVar = this.f5490s;
            f3 = 2.0f;
            Path path = this.f3753q0;
            pVar.a(nVar, fArr, f11, rectF2, gVar, path);
            d(canvas2, paint, path, this.f5475b.f5457a, this.A, f());
        } else {
            canvas2.drawRoundRect(rectF, w(), w(), paint);
            f3 = 2.0f;
        }
        if (Y()) {
            t(bounds, rectF);
            float f12 = rectF.left;
            float f13 = rectF.top;
            canvas2.translate(f12, f13);
            this.N.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            this.N.draw(canvas2);
            canvas2.translate(-f12, -f13);
        }
        if (X()) {
            t(bounds, rectF);
            float f14 = rectF.left;
            float f15 = rectF.top;
            canvas2.translate(f14, f15);
            this.Z.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            this.Z.draw(canvas2);
            canvas2.translate(-f14, -f15);
        }
        if (this.J0 && this.L != null) {
            PointF pointF = this.f3752p0;
            pointF.set(0.0f, 0.0f);
            Paint.Align align = Paint.Align.LEFT;
            CharSequence charSequence = this.L;
            i iVar = this.f3754r0;
            if (charSequence != null) {
                float fU = u() + this.f3741d0 + this.f3744g0;
                if (getLayoutDirection() == 0) {
                    pointF.x = bounds.left + fU;
                } else {
                    pointF.x = bounds.right - fU;
                    align = Paint.Align.RIGHT;
                }
                float fCenterY = bounds.centerY();
                TextPaint textPaint = iVar.f4716a;
                Paint.FontMetrics fontMetrics = this.f3750n0;
                textPaint.getFontMetrics(fontMetrics);
                pointF.y = fCenterY - ((fontMetrics.descent + fontMetrics.ascent) / f3);
            }
            rectF.setEmpty();
            if (this.L != null) {
                float fU2 = u() + this.f3741d0 + this.f3744g0;
                float fV = v() + this.k0 + this.f3745h0;
                if (getLayoutDirection() == 0) {
                    rectF.left = bounds.left + fU2;
                    rectF.right = bounds.right - fV;
                } else {
                    rectF.left = bounds.left + fV;
                    rectF.right = bounds.right - fU2;
                }
                rectF.top = bounds.top;
                rectF.bottom = bounds.bottom;
            }
            r1.d dVar = iVar.f4720f;
            TextPaint textPaint2 = iVar.f4716a;
            if (dVar != null) {
                textPaint2.drawableState = getState();
                iVar.f4720f.d(this.f3748l0, textPaint2, iVar.f4717b);
            }
            textPaint2.setTextAlign(align);
            boolean z2 = Math.round(iVar.a(this.L.toString())) > Math.round(rectF.width());
            if (z2) {
                int iSave = canvas2.save();
                canvas2.clipRect(rectF);
                i9 = iSave;
            } else {
                i9 = 0;
            }
            CharSequence charSequenceEllipsize = this.L;
            if (z2 && this.I0 != null) {
                charSequenceEllipsize = TextUtils.ellipsize(charSequenceEllipsize, textPaint2, rectF.width(), this.I0);
            }
            canvas.drawText(charSequenceEllipsize, 0, charSequenceEllipsize.length(), pointF.x, pointF.y, textPaint2);
            canvas2 = canvas;
            if (z2) {
                canvas2.restoreToCount(i9);
            }
        }
        if (Z()) {
            rectF.setEmpty();
            if (Z()) {
                float f16 = this.k0 + this.f3747j0;
                if (getLayoutDirection() == 0) {
                    float f17 = bounds.right - f16;
                    rectF.right = f17;
                    rectF.left = f17 - this.V;
                } else {
                    float f18 = bounds.left + f16;
                    rectF.left = f18;
                    rectF.right = f18 + this.V;
                }
                float fExactCenterY = bounds.exactCenterY();
                float f19 = this.V;
                float f20 = fExactCenterY - (f19 / f3);
                rectF.top = f20;
                rectF.bottom = f20 + f19;
            }
            float f21 = rectF.left;
            float f22 = rectF.top;
            canvas2.translate(f21, f22);
            this.S.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            this.T.setBounds(this.S.getBounds());
            this.T.jumpToCurrentState();
            this.T.draw(canvas2);
            canvas2.translate(-f21, -f22);
        }
        if (this.A0 < 255) {
            canvas2.restoreToCount(iSaveLayerAlpha);
        }
    }

    @Override // t1.j, android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.A0;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        return this.B0;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return (int) this.G;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return Math.min(Math.round(v() + this.f3754r0.a(this.L.toString()) + u() + this.f3741d0 + this.f3744g0 + this.f3745h0 + this.k0), this.K0);
    }

    @Override // t1.j, android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // t1.j, android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        Outline outline2;
        if (this.L0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            outline2 = outline;
            outline2.setRoundRect(0, 0, getIntrinsicWidth(), (int) this.G, this.H);
        } else {
            outline.setRoundRect(bounds, this.H);
            outline2 = outline;
        }
        outline2.setAlpha(this.A0 / 255.0f);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // t1.j, android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList colorStateList;
        if (x(this.E) || x(this.F) || x(this.I)) {
            return true;
        }
        r1.d dVar = this.f3754r0.f4720f;
        if (dVar == null || (colorStateList = dVar.f5081k) == null || !colorStateList.isStateful()) {
            return (this.Y && this.Z != null && this.X) || y(this.N) || y(this.Z) || x(this.D0);
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLayoutDirectionChanged(int i8) {
        boolean zOnLayoutDirectionChanged = super.onLayoutDirectionChanged(i8);
        if (Y()) {
            zOnLayoutDirectionChanged |= this.N.setLayoutDirection(i8);
        }
        if (X()) {
            zOnLayoutDirectionChanged |= this.Z.setLayoutDirection(i8);
        }
        if (Z()) {
            zOnLayoutDirectionChanged |= this.S.setLayoutDirection(i8);
        }
        if (!zOnLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i8) {
        boolean zOnLevelChange = super.onLevelChange(i8);
        if (Y()) {
            zOnLevelChange |= this.N.setLevel(i8);
        }
        if (X()) {
            zOnLevelChange |= this.Z.setLevel(i8);
        }
        if (Z()) {
            zOnLevelChange |= this.S.setLevel(i8);
        }
        if (zOnLevelChange) {
            invalidateSelf();
        }
        return zOnLevelChange;
    }

    @Override // t1.j, android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        if (this.L0) {
            super.onStateChange(iArr);
        }
        return A(iArr, this.F0);
    }

    public final void s(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        drawable.setLayoutDirection(getLayoutDirection());
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.S) {
            if (drawable.isStateful()) {
                drawable.setState(this.F0);
            }
            drawable.setTintList(this.U);
            return;
        }
        Drawable drawable2 = this.N;
        if (drawable == drawable2 && this.Q) {
            drawable2.setTintList(this.O);
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j4) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j4);
        }
    }

    @Override // t1.j, android.graphics.drawable.Drawable
    public final void setAlpha(int i8) {
        if (this.A0 != i8) {
            this.A0 = i8;
            invalidateSelf();
        }
    }

    @Override // t1.j, android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.B0 != colorFilter) {
            this.B0 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // t1.j, android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        if (this.D0 != colorStateList) {
            this.D0 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // t1.j, android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        if (this.E0 != mode) {
            this.E0 = mode;
            ColorStateList colorStateList = this.D0;
            this.C0 = (colorStateList == null || mode == null) ? null : new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (Y()) {
            visible |= this.N.setVisible(z, z2);
        }
        if (X()) {
            visible |= this.Z.setVisible(z, z2);
        }
        if (Z()) {
            visible |= this.S.setVisible(z, z2);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public final void t(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (Y() || X()) {
            float f3 = this.f3741d0 + this.f3742e0;
            Drawable drawable = this.f3761y0 ? this.Z : this.N;
            float intrinsicWidth = this.P;
            if (intrinsicWidth <= 0.0f && drawable != null) {
                intrinsicWidth = drawable.getIntrinsicWidth();
            }
            if (getLayoutDirection() == 0) {
                float f7 = rect.left + f3;
                rectF.left = f7;
                rectF.right = f7 + intrinsicWidth;
            } else {
                float f9 = rect.right - f3;
                rectF.right = f9;
                rectF.left = f9 - intrinsicWidth;
            }
            Drawable drawable2 = this.f3761y0 ? this.Z : this.N;
            float fCeil = this.P;
            if (fCeil <= 0.0f && drawable2 != null) {
                fCeil = (float) Math.ceil(TypedValue.applyDimension(1, 24, this.f3748l0.getResources().getDisplayMetrics()));
                if (drawable2.getIntrinsicHeight() <= fCeil) {
                    fCeil = drawable2.getIntrinsicHeight();
                }
            }
            float fExactCenterY = rect.exactCenterY() - (fCeil / 2.0f);
            rectF.top = fExactCenterY;
            rectF.bottom = fExactCenterY + fCeil;
        }
    }

    public final float u() {
        if (!Y() && !X()) {
            return 0.0f;
        }
        float f3 = this.f3742e0;
        Drawable drawable = this.f3761y0 ? this.Z : this.N;
        float intrinsicWidth = this.P;
        if (intrinsicWidth <= 0.0f && drawable != null) {
            intrinsicWidth = drawable.getIntrinsicWidth();
        }
        return intrinsicWidth + f3 + this.f3743f0;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public final float v() {
        if (Z()) {
            return this.f3746i0 + this.V + this.f3747j0;
        }
        return 0.0f;
    }

    public final float w() {
        if (!this.L0) {
            return this.H;
        }
        float[] fArr = this.A;
        return fArr != null ? fArr[3] : this.f5475b.f5457a.f5511e.a(f());
    }

    public final void z() {
        e eVar = (e) this.H0.get();
        if (eVar != null) {
            Chip chip = (Chip) eVar;
            chip.b(chip.f1302q);
            chip.requestLayout();
            chip.invalidateOutline();
        }
    }
}
