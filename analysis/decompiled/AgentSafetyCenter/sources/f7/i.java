package f7;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.StateSet;
import android.util.TypedValue;
import com.stepos.agentsafetycenter.R;
import java.lang.invoke.VarHandle;
import java.util.BitSet;
import java.util.Objects;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i extends Drawable implements w {
    public static final h[] H;
    public boolean A;
    public m B;
    public z3.h C;
    public final z3.g[] D;
    public float[] E;
    public float[] F;
    public b.b G;

    /* renamed from: c, reason: collision with root package name */
    public final a1.g f3953c;

    /* renamed from: f, reason: collision with root package name */
    public g f3954f;

    /* renamed from: g, reason: collision with root package name */
    public final u[] f3955g;

    /* renamed from: h, reason: collision with root package name */
    public final u[] f3956h;
    public final BitSet i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f3957j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f3958k;

    /* renamed from: l, reason: collision with root package name */
    public final Matrix f3959l;

    /* renamed from: m, reason: collision with root package name */
    public final Path f3960m;

    /* renamed from: n, reason: collision with root package name */
    public final Path f3961n;

    /* renamed from: o, reason: collision with root package name */
    public final RectF f3962o;

    /* renamed from: p, reason: collision with root package name */
    public final RectF f3963p;

    /* renamed from: q, reason: collision with root package name */
    public final Region f3964q;

    /* renamed from: r, reason: collision with root package name */
    public final Region f3965r;

    /* renamed from: s, reason: collision with root package name */
    public final Paint f3966s;

    /* renamed from: t, reason: collision with root package name */
    public final Paint f3967t;

    /* renamed from: u, reason: collision with root package name */
    public final a2.i f3968u;

    /* renamed from: v, reason: collision with root package name */
    public final o f3969v;

    /* renamed from: w, reason: collision with root package name */
    public PorterDuffColorFilter f3970w;

    /* renamed from: x, reason: collision with root package name */
    public PorterDuffColorFilter f3971x;

    /* renamed from: y, reason: collision with root package name */
    public int f3972y;

    /* renamed from: z, reason: collision with root package name */
    public final RectF f3973z;

    static {
        Paint paint = new Paint(1);
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        H = new h[4];
        int i = 0;
        while (true) {
            h[] hVarArr = H;
            if (i >= hVarArr.length) {
                return;
            }
            h hVar = new h();
            hVar.f3952a = i;
            VarHandle.storeStoreFence();
            hVarArr[i] = hVar;
            i++;
        }
    }

    public i(g gVar) {
        a1.g gVar2 = new a1.g(9, false);
        gVar2.f19f = this;
        VarHandle.storeStoreFence();
        this.f3953c = gVar2;
        this.f3955g = new u[4];
        this.f3956h = new u[4];
        int i = 8;
        this.i = new BitSet(8);
        this.f3959l = new Matrix();
        this.f3960m = new Path();
        this.f3961n = new Path();
        this.f3962o = new RectF();
        this.f3963p = new RectF();
        this.f3964q = new Region();
        this.f3965r = new Region();
        Paint paint = new Paint(1);
        this.f3966s = paint;
        Paint paint2 = new Paint(1);
        this.f3967t = paint2;
        e7.a aVar = new e7.a();
        new Path();
        Paint paint3 = new Paint();
        Paint paint4 = new Paint();
        aVar.f3601a = f3.a.d(-16777216, 68);
        f3.a.d(-16777216, 20);
        f3.a.d(-16777216, 0);
        paint4.setColor(aVar.f3601a);
        paint3.setColor(0);
        Paint paint5 = new Paint(4);
        Paint.Style style = Paint.Style.FILL;
        paint5.setStyle(style);
        new Paint(paint5);
        VarHandle.storeStoreFence();
        this.f3969v = Looper.getMainLooper().getThread() == Thread.currentThread() ? n.f3997a : new o();
        this.f3973z = new RectF();
        this.A = true;
        this.D = new z3.g[4];
        this.f3954f = gVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(style);
        n();
        l(getState());
        a2.i iVar = new a2.i(i);
        iVar.f49f = this;
        VarHandle.storeStoreFence();
        this.f3968u = iVar;
    }

    public static float b(RectF rectF, m mVar, float[] fArr) {
        if (fArr == null) {
            if (mVar.e(rectF)) {
                return mVar.f3990e.a(rectF);
            }
            return -1.0f;
        }
        if (fArr.length > 1) {
            float f5 = fArr[0];
            for (int i = 1; i < fArr.length; i++) {
                if (fArr[i] != f5) {
                    return -1.0f;
                }
            }
        }
        if (mVar.d()) {
            return fArr[0];
        }
        return -1.0f;
    }

    public final void a(RectF rectF, Path path) {
        g gVar = this.f3954f;
        this.f3969v.a(gVar.f3936a, this.E, gVar.f3944j, rectF, this.f3968u, path);
        if (this.f3954f.i != 1.0f) {
            Matrix matrix = this.f3959l;
            matrix.reset();
            float f5 = this.f3954f.i;
            matrix.setScale(f5, f5, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(matrix);
        }
        path.computeBounds(this.f3973z, true);
    }

    public final int c(int i) {
        int i3;
        g gVar = this.f3954f;
        float f5 = gVar.f3948n + 0.0f + gVar.f3947m;
        z6.a aVar = gVar.f3938c;
        if (aVar == null || !aVar.f16463a || f3.a.d(i, 255) != aVar.f16466d) {
            return i;
        }
        float fMin = (aVar.f16467e <= 0.0f || f5 <= 0.0f) ? 0.0f : Math.min(((((float) Math.log1p(f5 / r3)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
        int iAlpha = Color.alpha(i);
        int iM = t1.e.m(f3.a.d(i, 255), fMin, aVar.f16464b);
        if (fMin > 0.0f && (i3 = aVar.f16465c) != 0) {
            iM = f3.a.b(f3.a.d(i3, z6.a.f16462f), iM);
        }
        return f3.a.d(iM, iAlpha);
    }

    public final RectF d() {
        Rect bounds = getBounds();
        RectF rectF = this.f3962o;
        rectF.set(bounds);
        return rectF;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0090 A[EDGE_INSN: B:57:0x0090->B:28:0x0090 BREAK  A[LOOP:1: B:19:0x0078->B:24:0x0082]] */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void draw(android.graphics.Canvas r18) {
        /*
            Method dump skipped, instructions count: 361
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f7.i.draw(android.graphics.Canvas):void");
    }

    public final float e() {
        if (f()) {
            return this.f3967t.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    public final boolean f() {
        Paint.Style style = this.f3954f.f3951q;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.f3967t.getStrokeWidth() > 0.0f;
    }

    public final void g(Context context) {
        Integer numValueOf;
        Integer numValueOf2;
        g gVar = this.f3954f;
        boolean zF = p5.f.F(context, R.attr.elevationOverlayEnabled, false);
        TypedValue typedValueE = p5.f.E(R.attr.elevationOverlayColor, context);
        Integer numValueOf3 = null;
        if (typedValueE != null) {
            int i = typedValueE.resourceId;
            numValueOf = Integer.valueOf(i != 0 ? context.getColor(i) : typedValueE.data);
        } else {
            numValueOf = null;
        }
        int iIntValue = numValueOf != null ? numValueOf.intValue() : 0;
        TypedValue typedValueE2 = p5.f.E(R.attr.elevationOverlayAccentColor, context);
        if (typedValueE2 != null) {
            int i3 = typedValueE2.resourceId;
            numValueOf2 = Integer.valueOf(i3 != 0 ? context.getColor(i3) : typedValueE2.data);
        } else {
            numValueOf2 = null;
        }
        int iIntValue2 = numValueOf2 != null ? numValueOf2.intValue() : 0;
        TypedValue typedValueE3 = p5.f.E(R.attr.colorSurface, context);
        if (typedValueE3 != null) {
            int i10 = typedValueE3.resourceId;
            numValueOf3 = Integer.valueOf(i10 != 0 ? context.getColor(i10) : typedValueE3.data);
        }
        int iIntValue3 = numValueOf3 != null ? numValueOf3.intValue() : 0;
        float f5 = context.getResources().getDisplayMetrics().density;
        z6.a aVar = new z6.a();
        aVar.f16463a = zF;
        aVar.f16464b = iIntValue;
        aVar.f16465c = iIntValue2;
        aVar.f16466d = iIntValue3;
        aVar.f16467e = f5;
        VarHandle.storeStoreFence();
        gVar.f3938c = aVar;
        o();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f3954f.f3946l;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.f3954f;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        this.f3954f.getClass();
        RectF rectFD = d();
        if (rectFD.isEmpty()) {
            return;
        }
        float fB = b(rectFD, this.f3954f.f3936a, this.E);
        if (fB >= 0.0f) {
            outline.setRoundRect(getBounds(), fB * this.f3954f.f3944j);
            return;
        }
        boolean z10 = this.f3957j;
        Path path = this.f3960m;
        if (z10) {
            a(rectFD, path);
            this.f3957j = false;
        }
        y6.a.a(outline, path);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        Rect rect2 = this.f3954f.f3943h;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final Region getTransparentRegion() {
        Rect bounds = getBounds();
        Region region = this.f3964q;
        region.set(bounds);
        RectF rectFD = d();
        Path path = this.f3960m;
        a(rectFD, path);
        Region region2 = this.f3965r;
        region2.setPath(path, region);
        region.op(region2, Region.Op.DIFFERENCE);
        return region;
    }

    public final void h(z3.h hVar) {
        if (this.C == hVar) {
            return;
        }
        this.C = hVar;
        int i = 0;
        while (true) {
            z3.g[] gVarArr = this.D;
            if (i >= gVarArr.length) {
                m(getState(), true);
                invalidateSelf();
                return;
            }
            if (gVarArr[i] == null) {
                gVarArr[i] = new z3.g(this, H[i]);
            }
            z3.g gVar = gVarArr[i];
            z3.h hVar2 = new z3.h();
            hVar2.a((float) hVar.f16373b);
            double d7 = hVar.f16372a;
            hVar2.b((float) (d7 * d7));
            gVar.f16369k = hVar2;
            i++;
        }
    }

    public final void i(float f5) {
        g gVar = this.f3954f;
        if (gVar.f3948n != f5) {
            gVar.f3948n = f5;
            o();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        this.f3957j = true;
        this.f3958k = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        y yVar;
        if (!super.isStateful() && ((colorStateList = this.f3954f.f3941f) == null || !colorStateList.isStateful())) {
            this.f3954f.getClass();
            ColorStateList colorStateList3 = this.f3954f.f3940e;
            if ((colorStateList3 == null || !colorStateList3.isStateful()) && (((colorStateList2 = this.f3954f.f3939d) == null || !colorStateList2.isStateful()) && ((yVar = this.f3954f.f3937b) == null || yVar.f4033a <= 1))) {
                return false;
            }
        }
        return true;
    }

    public final void j(ColorStateList colorStateList) {
        g gVar = this.f3954f;
        if (gVar.f3939d != colorStateList) {
            gVar.f3939d = colorStateList;
            onStateChange(getState());
        }
    }

    public final void k(y yVar) {
        g gVar = this.f3954f;
        if (gVar.f3937b != yVar) {
            gVar.f3937b = yVar;
            m(getState(), true);
            invalidateSelf();
        }
    }

    public final boolean l(int[] iArr) {
        boolean z10;
        Paint paint;
        int color;
        int colorForState;
        Paint paint2;
        int color2;
        int colorForState2;
        if (this.f3954f.f3939d == null || color2 == (colorForState2 = this.f3954f.f3939d.getColorForState(iArr, (color2 = (paint2 = this.f3966s).getColor())))) {
            z10 = false;
        } else {
            paint2.setColor(colorForState2);
            z10 = true;
        }
        if (this.f3954f.f3940e == null || color == (colorForState = this.f3954f.f3940e.getColorForState(iArr, (color = (paint = this.f3967t).getColor())))) {
            return z10;
        }
        paint.setColor(colorForState);
        return true;
    }

    public final void m(int[] iArr, boolean z10) {
        int i;
        RectF rectFD = d();
        if (this.f3954f.f3937b == null || rectFD.isEmpty()) {
            return;
        }
        int i3 = 0;
        boolean z11 = z10 | (this.C == null);
        if (this.E == null) {
            this.E = new float[4];
        }
        y yVar = this.f3954f.f3937b;
        int[][] iArr2 = yVar.f4035c;
        int i10 = yVar.f4033a;
        int i11 = 0;
        while (true) {
            i = -1;
            if (i11 >= i10) {
                i11 = -1;
                break;
            } else if (StateSet.stateSetMatches(iArr2[i11], iArr)) {
                break;
            } else {
                i11++;
            }
        }
        if (i11 < 0) {
            int[] iArr3 = StateSet.WILD_CARD;
            int[][] iArr4 = yVar.f4035c;
            int i12 = 0;
            while (true) {
                if (i12 >= i10) {
                    break;
                }
                if (StateSet.stateSetMatches(iArr4[i12], iArr3)) {
                    i = i12;
                    break;
                }
                i12++;
            }
            i11 = i;
        }
        m mVar = yVar.f4036d[i11];
        while (i3 < 4) {
            this.f3969v.getClass();
            float fA = (i3 != 1 ? i3 != 2 ? i3 != 3 ? mVar.f3991f : mVar.f3990e : mVar.f3993h : mVar.f3992g).a(rectFD);
            if (z11) {
                this.E[i3] = fA;
            }
            z3.g[] gVarArr = this.D;
            z3.g gVar = gVarArr[i3];
            if (gVar != null) {
                if (gVar.f16365f) {
                    gVar.f16370l = fA;
                } else {
                    if (gVar.f16369k == null) {
                        gVar.f16369k = new z3.h(fA);
                    }
                    gVar.f16369k.i = fA;
                    gVar.g();
                }
                if (z11) {
                    gVarArr[i3].f();
                }
            }
            i3++;
        }
        if (z11) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        g gVar = this.f3954f;
        g gVar2 = new g();
        gVar2.f3939d = null;
        gVar2.f3940e = null;
        gVar2.f3941f = null;
        gVar2.f3942g = PorterDuff.Mode.SRC_IN;
        gVar2.f3943h = null;
        gVar2.i = 1.0f;
        gVar2.f3944j = 1.0f;
        gVar2.f3946l = 255;
        gVar2.f3947m = 0.0f;
        gVar2.f3948n = 0.0f;
        gVar2.f3949o = 0;
        gVar2.f3950p = 0;
        gVar2.f3951q = Paint.Style.FILL_AND_STROKE;
        gVar2.f3936a = gVar.f3936a;
        gVar2.f3937b = gVar.f3937b;
        gVar2.f3938c = gVar.f3938c;
        gVar2.f3945k = gVar.f3945k;
        gVar2.f3939d = gVar.f3939d;
        gVar2.f3940e = gVar.f3940e;
        gVar2.f3942g = gVar.f3942g;
        gVar2.f3941f = gVar.f3941f;
        gVar2.f3946l = gVar.f3946l;
        gVar2.i = gVar.i;
        gVar2.f3950p = gVar.f3950p;
        gVar2.f3944j = gVar.f3944j;
        gVar2.f3947m = gVar.f3947m;
        gVar2.f3948n = gVar.f3948n;
        gVar2.f3949o = gVar.f3949o;
        gVar2.f3951q = gVar.f3951q;
        Rect rect = gVar.f3943h;
        if (rect != null) {
            gVar2.f3943h = new Rect(rect);
        }
        this.f3954f = gVar2;
        return this;
    }

    public final boolean n() {
        PorterDuffColorFilter porterDuffColorFilter;
        PorterDuffColorFilter porterDuffColorFilter2 = this.f3970w;
        PorterDuffColorFilter porterDuffColorFilter3 = this.f3971x;
        g gVar = this.f3954f;
        ColorStateList colorStateList = gVar.f3941f;
        PorterDuff.Mode mode = gVar.f3942g;
        if (colorStateList == null || mode == null) {
            int color = this.f3966s.getColor();
            int iC = c(color);
            this.f3972y = iC;
            porterDuffColorFilter = iC != color ? new PorterDuffColorFilter(iC, PorterDuff.Mode.SRC_IN) : null;
        } else {
            int iC2 = c(colorStateList.getColorForState(getState(), 0));
            this.f3972y = iC2;
            porterDuffColorFilter = new PorterDuffColorFilter(iC2, mode);
        }
        this.f3970w = porterDuffColorFilter;
        this.f3954f.getClass();
        this.f3971x = null;
        this.f3954f.getClass();
        return (Objects.equals(porterDuffColorFilter2, this.f3970w) && Objects.equals(porterDuffColorFilter3, this.f3971x)) ? false : true;
    }

    public final void o() {
        g gVar = this.f3954f;
        float f5 = gVar.f3948n + 0.0f;
        gVar.f3949o = (int) Math.ceil(0.75f * f5);
        this.f3954f.f3950p = (int) Math.ceil(f5 * 0.25f);
        n();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        this.f3957j = true;
        this.f3958k = true;
        super.onBoundsChange(rect);
        if (this.f3954f.f3937b != null && !rect.isEmpty()) {
            m(getState(), this.A);
        }
        this.A = rect.isEmpty();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        if (this.f3954f.f3937b != null) {
            m(iArr, false);
        }
        boolean z10 = l(iArr) || n();
        if (z10) {
            invalidateSelf();
        }
        return z10;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        g gVar = this.f3954f;
        if (gVar.f3946l != i) {
            gVar.f3946l = i;
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f3954f.getClass();
        super.invalidateSelf();
    }

    @Override // f7.w
    public final void setShapeAppearanceModel(m mVar) {
        g gVar = this.f3954f;
        gVar.f3936a = mVar;
        gVar.f3937b = null;
        this.E = null;
        this.F = null;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        this.f3954f.f3941f = colorStateList;
        n();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        g gVar = this.f3954f;
        if (gVar.f3942g != mode) {
            gVar.f3942g = mode;
            n();
            super.invalidateSelf();
        }
    }

    public i(m mVar) {
        g gVar = new g();
        gVar.f3939d = null;
        gVar.f3940e = null;
        gVar.f3941f = null;
        gVar.f3942g = PorterDuff.Mode.SRC_IN;
        gVar.f3943h = null;
        gVar.i = 1.0f;
        gVar.f3944j = 1.0f;
        gVar.f3946l = 255;
        gVar.f3947m = 0.0f;
        gVar.f3948n = 0.0f;
        gVar.f3949o = 0;
        gVar.f3950p = 0;
        gVar.f3951q = Paint.Style.FILL_AND_STROKE;
        gVar.f3936a = mVar;
        gVar.f3938c = null;
        this(gVar);
    }
}
