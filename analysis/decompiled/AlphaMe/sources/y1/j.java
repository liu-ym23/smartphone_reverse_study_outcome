package y1;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
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
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import com.stepos.alphame.utils.Property;
import f1.AbstractC0557a;
import java.util.BitSet;
import java.util.Objects;
import t1.AbstractC0931a;
import u1.C0938a;
import x1.C0980a;

/* loaded from: classes.dex */
public class j extends Drawable implements y {

    /* renamed from: F, reason: collision with root package name */
    public static final Paint f16226F;

    /* renamed from: G, reason: collision with root package name */
    public static final i[] f16227G;

    /* renamed from: A, reason: collision with root package name */
    public W.n f16228A;

    /* renamed from: B, reason: collision with root package name */
    public final W.m[] f16229B;

    /* renamed from: C, reason: collision with root package name */
    public float[] f16230C;

    /* renamed from: D, reason: collision with root package name */
    public float[] f16231D;

    /* renamed from: E, reason: collision with root package name */
    public androidx.core.app.f f16232E;

    /* renamed from: a, reason: collision with root package name */
    public final g f16233a;

    /* renamed from: b, reason: collision with root package name */
    public h f16234b;

    /* renamed from: c, reason: collision with root package name */
    public final w[] f16235c;

    /* renamed from: d, reason: collision with root package name */
    public final w[] f16236d;

    /* renamed from: e, reason: collision with root package name */
    public final BitSet f16237e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f16238f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f16239g;

    /* renamed from: h, reason: collision with root package name */
    public final Matrix f16240h;

    /* renamed from: i, reason: collision with root package name */
    public final Path f16241i;

    /* renamed from: j, reason: collision with root package name */
    public final Path f16242j;

    /* renamed from: k, reason: collision with root package name */
    public final RectF f16243k;

    /* renamed from: l, reason: collision with root package name */
    public final RectF f16244l;

    /* renamed from: m, reason: collision with root package name */
    public final Region f16245m;

    /* renamed from: n, reason: collision with root package name */
    public final Region f16246n;

    /* renamed from: o, reason: collision with root package name */
    public final Paint f16247o;

    /* renamed from: p, reason: collision with root package name */
    public final Paint f16248p;

    /* renamed from: q, reason: collision with root package name */
    public final C0980a f16249q;

    /* renamed from: r, reason: collision with root package name */
    public final g f16250r;

    /* renamed from: s, reason: collision with root package name */
    public final p f16251s;

    /* renamed from: t, reason: collision with root package name */
    public PorterDuffColorFilter f16252t;

    /* renamed from: u, reason: collision with root package name */
    public PorterDuffColorFilter f16253u;

    /* renamed from: v, reason: collision with root package name */
    public int f16254v;

    /* renamed from: w, reason: collision with root package name */
    public final RectF f16255w;

    /* renamed from: x, reason: collision with root package name */
    public final boolean f16256x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f16257y;

    /* renamed from: z, reason: collision with root package name */
    public n f16258z;

    static {
        f fVarN = B0.f.n();
        f fVarN2 = B0.f.n();
        f fVarN3 = B0.f.n();
        f fVarN4 = B0.f.n();
        int i4 = 0;
        B0.f fVarM = B0.f.m(0);
        m.b(fVarM);
        m.b(fVarM);
        m.b(fVarM);
        m.b(fVarM);
        C0987a c0987a = new C0987a(Property.DEFAULT_FLOAT_VALUE);
        C0987a c0987a2 = new C0987a(Property.DEFAULT_FLOAT_VALUE);
        C0987a c0987a3 = new C0987a(Property.DEFAULT_FLOAT_VALUE);
        C0987a c0987a4 = new C0987a(Property.DEFAULT_FLOAT_VALUE);
        n nVar = new n();
        nVar.f16272a = fVarM;
        nVar.f16273b = fVarM;
        nVar.f16274c = fVarM;
        nVar.f16275d = fVarM;
        nVar.f16276e = c0987a;
        nVar.f16277f = c0987a2;
        nVar.f16278g = c0987a3;
        nVar.f16279h = c0987a4;
        nVar.f16280i = fVarN;
        nVar.f16281j = fVarN2;
        nVar.f16282k = fVarN3;
        nVar.f16283l = fVarN4;
        Paint paint = new Paint(1);
        f16226F = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        f16227G = new i[4];
        while (true) {
            i[] iVarArr = f16227G;
            if (i4 >= iVarArr.length) {
                return;
            }
            iVarArr[i4] = new i(i4);
            i4++;
        }
    }

    public j() {
        this(new n());
    }

    public static float b(RectF rectF, n nVar, float[] fArr) {
        if (fArr == null) {
            if (nVar.e(rectF)) {
                return nVar.f16276e.a(rectF);
            }
            return -1.0f;
        }
        if (fArr.length > 1) {
            float f4 = fArr[0];
            for (int i4 = 1; i4 < fArr.length; i4++) {
                if (fArr[i4] != f4) {
                    return -1.0f;
                }
            }
        }
        if (nVar.d()) {
            return fArr[0];
        }
        return -1.0f;
    }

    public final void a(RectF rectF, Path path) {
        h hVar = this.f16234b;
        this.f16251s.a(hVar.f16203a, this.f16230C, hVar.f16213k, rectF, this.f16250r, path);
        if (this.f16234b.f16212j != 1.0f) {
            Matrix matrix = this.f16240h;
            matrix.reset();
            float f4 = this.f16234b.f16212j;
            matrix.setScale(f4, f4, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(matrix);
        }
        path.computeBounds(this.f16255w, true);
    }

    public final PorterDuffColorFilter c(ColorStateList colorStateList, PorterDuff.Mode mode, Paint paint, boolean z4) {
        if (colorStateList != null && mode != null) {
            int colorForState = colorStateList.getColorForState(getState(), 0);
            if (z4) {
                colorForState = d(colorForState);
            }
            this.f16254v = colorForState;
            return new PorterDuffColorFilter(colorForState, mode);
        }
        if (z4) {
            int color = paint.getColor();
            int iD = d(color);
            this.f16254v = iD;
            if (iD != color) {
                return new PorterDuffColorFilter(iD, PorterDuff.Mode.SRC_IN);
            }
        }
        return null;
    }

    public final int d(int i4) {
        int i5;
        h hVar = this.f16234b;
        float f4 = hVar.f16217o + hVar.f16218p + hVar.f16216n;
        C0938a c0938a = hVar.f16205c;
        if (c0938a == null || !c0938a.f15477a || D.a.d(i4, 255) != c0938a.f15480d) {
            return i4;
        }
        float fMin = (c0938a.f15481e <= Property.DEFAULT_FLOAT_VALUE || f4 <= Property.DEFAULT_FLOAT_VALUE) ? 0.0f : Math.min(((((float) Math.log1p(f4 / r2)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
        int iAlpha = Color.alpha(i4);
        int iL = AbstractC0557a.L(fMin, D.a.d(i4, 255), c0938a.f15478b);
        if (fMin > Property.DEFAULT_FLOAT_VALUE && (i5 = c0938a.f15479c) != 0) {
            iL = D.a.b(D.a.d(i5, C0938a.f15476f), iL);
        }
        return D.a.d(iL, iAlpha);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0095 A[EDGE_INSN: B:63:0x0095->B:32:0x0095 BREAK  A[LOOP:1: B:23:0x007c->B:28:0x0086]] */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void draw(android.graphics.Canvas r22) {
        /*
            Method dump skipped, instructions count: 503
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y1.j.draw(android.graphics.Canvas):void");
    }

    public final void e(Canvas canvas) {
        if (this.f16237e.cardinality() > 0) {
            Log.w("j", "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        int i4 = this.f16234b.f16221s;
        Path path = this.f16241i;
        C0980a c0980a = this.f16249q;
        if (i4 != 0) {
            canvas.drawPath(path, c0980a.f15893a);
        }
        for (int i5 = 0; i5 < 4; i5++) {
            w wVar = this.f16235c[i5];
            int i6 = this.f16234b.f16220r;
            Matrix matrix = w.f16313b;
            wVar.a(matrix, c0980a, i6, canvas);
            this.f16236d[i5].a(matrix, c0980a, this.f16234b.f16220r, canvas);
        }
        if (this.f16256x) {
            h hVar = this.f16234b;
            int iSin = (int) (Math.sin(Math.toRadians(hVar.f16222t)) * hVar.f16221s);
            h hVar2 = this.f16234b;
            int iCos = (int) (Math.cos(Math.toRadians(hVar2.f16222t)) * hVar2.f16221s);
            canvas.translate(-iSin, -iCos);
            canvas.drawPath(path, f16226F);
            canvas.translate(iSin, iCos);
        }
    }

    public final void f(Canvas canvas, Paint paint, Path path, n nVar, float[] fArr, RectF rectF) {
        float fB = b(rectF, nVar, fArr);
        if (fB < Property.DEFAULT_FLOAT_VALUE) {
            canvas.drawPath(path, paint);
        } else {
            float f4 = fB * this.f16234b.f16213k;
            canvas.drawRoundRect(rectF, f4, f4, paint);
        }
    }

    public void g(Canvas canvas) {
        Paint paint = this.f16248p;
        Path path = this.f16242j;
        n nVar = this.f16258z;
        float[] fArr = this.f16231D;
        RectF rectF = this.f16244l;
        rectF.set(h());
        float fJ = j();
        rectF.inset(fJ, fJ);
        f(canvas, paint, path, nVar, fArr, rectF);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f16234b.f16215m;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.f16234b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.f16234b.f16219q == 2) {
            return;
        }
        RectF rectFH = h();
        if (rectFH.isEmpty()) {
            return;
        }
        float fB = b(rectFH, this.f16234b.f16203a, this.f16230C);
        if (fB >= Property.DEFAULT_FLOAT_VALUE) {
            outline.setRoundRect(getBounds(), fB * this.f16234b.f16213k);
            return;
        }
        boolean z4 = this.f16238f;
        Path path = this.f16241i;
        if (z4) {
            a(rectFH, path);
            this.f16238f = false;
        }
        AbstractC0931a.a(outline, path);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        Rect rect2 = this.f16234b.f16211i;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final Region getTransparentRegion() {
        Rect bounds = getBounds();
        Region region = this.f16245m;
        region.set(bounds);
        RectF rectFH = h();
        Path path = this.f16241i;
        a(rectFH, path);
        Region region2 = this.f16246n;
        region2.setPath(path, region);
        region.op(region2, Region.Op.DIFFERENCE);
        return region;
    }

    public final RectF h() {
        RectF rectF = this.f16243k;
        rectF.set(getBounds());
        return rectF;
    }

    public final float i() {
        float[] fArr = this.f16230C;
        if (fArr != null) {
            return (((fArr[3] + fArr[2]) - fArr[1]) - fArr[0]) / 2.0f;
        }
        RectF rectFH = h();
        n nVar = this.f16234b.f16203a;
        this.f16251s.getClass();
        return (((p.b(2, this.f16234b.f16203a).a(rectFH) + p.b(3, nVar).a(rectFH)) - p.b(1, this.f16234b.f16203a).a(rectFH)) - p.b(0, this.f16234b.f16203a).a(rectFH)) / 2.0f;
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        this.f16238f = true;
        this.f16239g = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        B b4;
        return super.isStateful() || ((colorStateList = this.f16234b.f16209g) != null && colorStateList.isStateful()) || (((colorStateList2 = this.f16234b.f16208f) != null && colorStateList2.isStateful()) || (((colorStateList3 = this.f16234b.f16207e) != null && colorStateList3.isStateful()) || (((colorStateList4 = this.f16234b.f16206d) != null && colorStateList4.isStateful()) || ((b4 = this.f16234b.f16204b) != null && b4.d()))));
    }

    public final float j() {
        return k() ? this.f16248p.getStrokeWidth() / 2.0f : Property.DEFAULT_FLOAT_VALUE;
    }

    public final boolean k() {
        Paint.Style style = this.f16234b.f16224v;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.f16248p.getStrokeWidth() > Property.DEFAULT_FLOAT_VALUE;
    }

    public final void l(Context context) {
        this.f16234b.f16205c = new C0938a(context);
        t();
    }

    public final void m(W.n nVar) {
        if (this.f16228A == nVar) {
            return;
        }
        this.f16228A = nVar;
        int i4 = 0;
        while (true) {
            W.m[] mVarArr = this.f16229B;
            if (i4 >= mVarArr.length) {
                r(getState(), true);
                invalidateSelf();
                return;
            }
            if (mVarArr[i4] == null) {
                mVarArr[i4] = new W.m(this, f16227G[i4]);
            }
            W.m mVar = mVarArr[i4];
            W.n nVar2 = new W.n();
            nVar2.a((float) nVar.f1978b);
            double d4 = nVar.f1977a;
            nVar2.b((float) (d4 * d4));
            mVar.f1974m = nVar2;
            i4++;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f16234b = new h(this.f16234b);
        return this;
    }

    public final void n(float f4) {
        h hVar = this.f16234b;
        if (hVar.f16217o != f4) {
            hVar.f16217o = f4;
            t();
        }
    }

    public final void o(ColorStateList colorStateList) {
        h hVar = this.f16234b;
        if (hVar.f16206d != colorStateList) {
            hVar.f16206d = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        this.f16238f = true;
        this.f16239g = true;
        super.onBoundsChange(rect);
        if (this.f16234b.f16204b != null && !rect.isEmpty()) {
            r(getState(), this.f16257y);
        }
        this.f16257y = rect.isEmpty();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        if (this.f16234b.f16204b != null) {
            r(iArr, false);
        }
        boolean z4 = q(iArr) || s();
        if (z4) {
            invalidateSelf();
        }
        return z4;
    }

    public final void p(B b4) {
        h hVar = this.f16234b;
        if (hVar.f16204b != b4) {
            hVar.f16204b = b4;
            r(getState(), true);
            invalidateSelf();
        }
    }

    public final boolean q(int[] iArr) {
        boolean z4;
        Paint paint;
        int color;
        int colorForState;
        Paint paint2;
        int color2;
        int colorForState2;
        if (this.f16234b.f16206d == null || color2 == (colorForState2 = this.f16234b.f16206d.getColorForState(iArr, (color2 = (paint2 = this.f16247o).getColor())))) {
            z4 = false;
        } else {
            paint2.setColor(colorForState2);
            z4 = true;
        }
        if (this.f16234b.f16207e == null || color == (colorForState = this.f16234b.f16207e.getColorForState(iArr, (color = (paint = this.f16248p).getColor())))) {
            return z4;
        }
        paint.setColor(colorForState);
        return true;
    }

    public final void r(int[] iArr, boolean z4) {
        int i4;
        int[][] iArr2;
        n nVarA;
        RectF rectFH = h();
        if (this.f16234b.f16204b == null || rectFH.isEmpty()) {
            return;
        }
        boolean z5 = z4 | (this.f16228A == null);
        if (this.f16230C == null) {
            this.f16230C = new float[4];
        }
        B b4 = this.f16234b.f16204b;
        int i5 = 0;
        while (true) {
            int i6 = b4.f16182a;
            i4 = -1;
            iArr2 = b4.f16184c;
            if (i5 >= i6) {
                i5 = -1;
                break;
            } else if (StateSet.stateSetMatches(iArr2[i5], iArr)) {
                break;
            } else {
                i5++;
            }
        }
        if (i5 < 0) {
            int[] iArr3 = StateSet.WILD_CARD;
            int i7 = 0;
            while (true) {
                if (i7 >= b4.f16182a) {
                    break;
                }
                if (StateSet.stateSetMatches(iArr2[i7], iArr3)) {
                    i4 = i7;
                    break;
                }
                i7++;
            }
            i5 = i4;
        }
        n[] nVarArr = b4.f16185d;
        z zVar = b4.f16189h;
        z zVar2 = b4.f16188g;
        z zVar3 = b4.f16187f;
        z zVar4 = b4.f16186e;
        if (zVar4 == null && zVar3 == null && zVar2 == null && zVar == null) {
            nVarA = nVarArr[i5];
        } else {
            m mVarF = nVarArr[i5].f();
            if (zVar4 != null) {
                mVarF.f16264e = zVar4.c(iArr);
            }
            if (zVar3 != null) {
                mVarF.f16265f = zVar3.c(iArr);
            }
            if (zVar2 != null) {
                mVarF.f16267h = zVar2.c(iArr);
            }
            if (zVar != null) {
                mVarF.f16266g = zVar.c(iArr);
            }
            nVarA = mVarF.a();
        }
        for (int i8 = 0; i8 < 4; i8++) {
            this.f16251s.getClass();
            float fA = p.b(i8, nVarA).a(rectFH);
            if (z5) {
                this.f16230C[i8] = fA;
            }
            W.m[] mVarArr = this.f16229B;
            W.m mVar = mVarArr[i8];
            if (mVar != null) {
                if (mVar.f1967f) {
                    mVar.f1975n = fA;
                } else {
                    if (mVar.f1974m == null) {
                        mVar.f1974m = new W.n(fA);
                    }
                    mVar.f1974m.f1985i = fA;
                    mVar.i();
                }
                if (z5) {
                    mVarArr[i8].h();
                }
            }
        }
        if (z5) {
            invalidateSelf();
        }
    }

    public final boolean s() {
        PorterDuffColorFilter porterDuffColorFilter = this.f16252t;
        PorterDuffColorFilter porterDuffColorFilter2 = this.f16253u;
        h hVar = this.f16234b;
        this.f16252t = c(hVar.f16209g, hVar.f16210h, this.f16247o, true);
        h hVar2 = this.f16234b;
        this.f16253u = c(hVar2.f16208f, hVar2.f16210h, this.f16248p, false);
        h hVar3 = this.f16234b;
        if (hVar3.f16223u) {
            int colorForState = hVar3.f16209g.getColorForState(getState(), 0);
            C0980a c0980a = this.f16249q;
            c0980a.getClass();
            c0980a.f15896d = D.a.d(colorForState, 68);
            c0980a.f15897e = D.a.d(colorForState, 20);
            c0980a.f15898f = D.a.d(colorForState, 0);
            c0980a.f15893a.setColor(c0980a.f15896d);
        }
        return (Objects.equals(porterDuffColorFilter, this.f16252t) && Objects.equals(porterDuffColorFilter2, this.f16253u)) ? false : true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i4) {
        h hVar = this.f16234b;
        if (hVar.f16215m != i4) {
            hVar.f16215m = i4;
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f16234b.getClass();
        super.invalidateSelf();
    }

    @Override // y1.y
    public final void setShapeAppearanceModel(n nVar) {
        h hVar = this.f16234b;
        hVar.f16203a = nVar;
        hVar.f16204b = null;
        this.f16230C = null;
        this.f16231D = null;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i4) {
        setTintList(ColorStateList.valueOf(i4));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f16234b.f16209g = colorStateList;
        s();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        h hVar = this.f16234b;
        if (hVar.f16210h != mode) {
            hVar.f16210h = mode;
            s();
            super.invalidateSelf();
        }
    }

    public final void t() {
        h hVar = this.f16234b;
        float f4 = hVar.f16217o + hVar.f16218p;
        hVar.f16220r = (int) Math.ceil(0.75f * f4);
        this.f16234b.f16221s = (int) Math.ceil(f4 * 0.25f);
        s();
        super.invalidateSelf();
    }

    public j(Context context, AttributeSet attributeSet, int i4, int i5) {
        this(n.b(context, attributeSet, i4, i5).a());
    }

    public j(n nVar) {
        this(new h(nVar));
    }

    public j(h hVar) {
        p pVar;
        this.f16233a = new g(this);
        this.f16235c = new w[4];
        this.f16236d = new w[4];
        this.f16237e = new BitSet(8);
        this.f16240h = new Matrix();
        this.f16241i = new Path();
        this.f16242j = new Path();
        this.f16243k = new RectF();
        this.f16244l = new RectF();
        this.f16245m = new Region();
        this.f16246n = new Region();
        Paint paint = new Paint(1);
        this.f16247o = paint;
        Paint paint2 = new Paint(1);
        this.f16248p = paint2;
        this.f16249q = new C0980a();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            pVar = o.f16284a;
        } else {
            pVar = new p();
        }
        this.f16251s = pVar;
        this.f16255w = new RectF();
        this.f16256x = true;
        this.f16257y = true;
        this.f16229B = new W.m[4];
        this.f16234b = hVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        s();
        q(getState());
        this.f16250r = new g(this);
    }
}
