package t1;

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
import android.util.StateSet;
import java.util.BitSet;
import java.util.Objects;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class j extends Drawable implements x {
    public static final i[] D;
    public float[] A;
    public float[] B;
    public j1.a C;

    /* renamed from: a, reason: collision with root package name */
    public final g f5474a;

    /* renamed from: b, reason: collision with root package name */
    public h f5475b;

    /* renamed from: c, reason: collision with root package name */
    public final v[] f5476c;
    public final v[] d;

    /* renamed from: e, reason: collision with root package name */
    public final BitSet f5477e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f5478f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f5479g;

    /* renamed from: h, reason: collision with root package name */
    public final Matrix f5480h;

    /* renamed from: j, reason: collision with root package name */
    public final Path f5481j;

    /* renamed from: k, reason: collision with root package name */
    public final Path f5482k;

    /* renamed from: l, reason: collision with root package name */
    public final RectF f5483l;

    /* renamed from: m, reason: collision with root package name */
    public final RectF f5484m;

    /* renamed from: n, reason: collision with root package name */
    public final Region f5485n;

    /* renamed from: o, reason: collision with root package name */
    public final Region f5486o;

    /* renamed from: p, reason: collision with root package name */
    public final Paint f5487p;

    /* renamed from: q, reason: collision with root package name */
    public final Paint f5488q;

    /* renamed from: r, reason: collision with root package name */
    public final g f5489r;

    /* renamed from: s, reason: collision with root package name */
    public final p f5490s;

    /* renamed from: t, reason: collision with root package name */
    public PorterDuffColorFilter f5491t;

    /* renamed from: u, reason: collision with root package name */
    public PorterDuffColorFilter f5492u;

    /* renamed from: v, reason: collision with root package name */
    public final RectF f5493v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f5494w;

    /* renamed from: x, reason: collision with root package name */
    public n f5495x;
    public n0.f y;
    public final n0.e[] z;

    static {
        Paint paint = new Paint(1);
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        D = new i[4];
        int i8 = 0;
        while (true) {
            i[] iVarArr = D;
            if (i8 >= iVarArr.length) {
                return;
            }
            iVarArr[i8] = new i(i8);
            i8++;
        }
    }

    public j() {
        this(new n());
    }

    public static float b(RectF rectF, n nVar, float[] fArr) {
        if (fArr == null) {
            if (nVar.e(rectF)) {
                return nVar.f5511e.a(rectF);
            }
            return -1.0f;
        }
        if (fArr.length > 1) {
            float f3 = fArr[0];
            for (int i8 = 1; i8 < fArr.length; i8++) {
                if (fArr[i8] != f3) {
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
        h hVar = this.f5475b;
        this.f5490s.a(hVar.f5457a, this.A, hVar.f5465j, rectF, this.f5489r, path);
        if (this.f5475b.f5464i != 1.0f) {
            Matrix matrix = this.f5480h;
            matrix.reset();
            float f3 = this.f5475b.f5464i;
            matrix.setScale(f3, f3, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(matrix);
        }
        path.computeBounds(this.f5493v, true);
    }

    public final int c(int i8) {
        int i9;
        h hVar = this.f5475b;
        float f3 = hVar.f5469n + 0.0f + hVar.f5468m;
        o1.a aVar = hVar.f5459c;
        if (aVar == null || !aVar.f4297a || x.a.d(i8, 255) != aVar.d) {
            return i8;
        }
        float fMin = (aVar.f4300e <= 0.0f || f3 <= 0.0f) ? 0.0f : Math.min(((((float) Math.log1p(f3 / r3)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
        int iAlpha = Color.alpha(i8);
        int iA0 = k4.v.a0(x.a.d(i8, 255), aVar.f4298b, fMin);
        if (fMin > 0.0f && (i9 = aVar.f4299c) != 0) {
            iA0 = x.a.b(x.a.d(i9, o1.a.f4296f), iA0);
        }
        return x.a.d(iA0, iAlpha);
    }

    public final void d(Canvas canvas, Paint paint, Path path, n nVar, float[] fArr, RectF rectF) {
        float fB = b(rectF, nVar, fArr);
        if (fB < 0.0f) {
            canvas.drawPath(path, paint);
        } else {
            float f3 = fB * this.f5475b.f5465j;
            canvas.drawRoundRect(rectF, f3, f3, paint);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x008d A[EDGE_INSN: B:50:0x008d->B:28:0x008d BREAK  A[LOOP:1: B:19:0x0075->B:24:0x007f]] */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void draw(android.graphics.Canvas r19) {
        /*
            Method dump skipped, instructions count: 306
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t1.j.draw(android.graphics.Canvas):void");
    }

    public void e(Canvas canvas) {
        n nVar = this.f5495x;
        float[] fArr = this.B;
        RectF rectFF = f();
        RectF rectF = this.f5484m;
        rectF.set(rectFF);
        float fH = h();
        rectF.inset(fH, fH);
        d(canvas, this.f5488q, this.f5482k, nVar, fArr, rectF);
    }

    public final RectF f() {
        Rect bounds = getBounds();
        RectF rectF = this.f5483l;
        rectF.set(bounds);
        return rectF;
    }

    public final float g() {
        float[] fArr = this.A;
        if (fArr != null) {
            return (((fArr[3] + fArr[2]) - fArr[1]) - fArr[0]) / 2.0f;
        }
        RectF rectFF = f();
        n nVar = this.f5475b.f5457a;
        p pVar = this.f5490s;
        pVar.getClass();
        float fA = nVar.f5511e.a(rectFF);
        n nVar2 = this.f5475b.f5457a;
        pVar.getClass();
        float fA2 = nVar2.f5514h.a(rectFF) + fA;
        n nVar3 = this.f5475b.f5457a;
        pVar.getClass();
        float fA3 = fA2 - nVar3.f5513g.a(rectFF);
        n nVar4 = this.f5475b.f5457a;
        pVar.getClass();
        return (fA3 - nVar4.f5512f.a(rectFF)) / 2.0f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f5475b.f5467l;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.f5475b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        this.f5475b.getClass();
        RectF rectFF = f();
        if (rectFF.isEmpty()) {
            return;
        }
        float fB = b(rectFF, this.f5475b.f5457a, this.A);
        if (fB >= 0.0f) {
            outline.setRoundRect(getBounds(), fB * this.f5475b.f5465j);
            return;
        }
        boolean z = this.f5478f;
        Path path = this.f5481j;
        if (z) {
            a(rectFF, path);
            this.f5478f = false;
        }
        n1.a.a(outline, path);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        Rect rect2 = this.f5475b.f5463h;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final Region getTransparentRegion() {
        Rect bounds = getBounds();
        Region region = this.f5485n;
        region.set(bounds);
        RectF rectFF = f();
        Path path = this.f5481j;
        a(rectFF, path);
        Region region2 = this.f5486o;
        region2.setPath(path, region);
        region.op(region2, Region.Op.DIFFERENCE);
        return region;
    }

    public final float h() {
        if (i()) {
            return this.f5488q.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    public final boolean i() {
        Paint.Style style = this.f5475b.f5472q;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.f5488q.getStrokeWidth() > 0.0f;
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        this.f5478f = true;
        this.f5479g = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (super.isStateful()) {
            return true;
        }
        ColorStateList colorStateList = this.f5475b.f5461f;
        if (colorStateList != null && colorStateList.isStateful()) {
            return true;
        }
        this.f5475b.getClass();
        ColorStateList colorStateList2 = this.f5475b.f5460e;
        if (colorStateList2 != null && colorStateList2.isStateful()) {
            return true;
        }
        ColorStateList colorStateList3 = this.f5475b.d;
        if (colorStateList3 != null && colorStateList3.isStateful()) {
            return true;
        }
        z zVar = this.f5475b.f5458b;
        return zVar != null && zVar.d();
    }

    public final void j(Context context) {
        this.f5475b.f5459c = new o1.a(context);
        r();
    }

    public final void k(n0.f fVar) {
        if (this.y == fVar) {
            return;
        }
        this.y = fVar;
        int i8 = 0;
        while (true) {
            n0.e[] eVarArr = this.z;
            if (i8 >= eVarArr.length) {
                p(getState(), true);
                invalidateSelf();
                return;
            }
            if (eVarArr[i8] == null) {
                eVarArr[i8] = new n0.e(this, D[i8]);
            }
            n0.e eVar = eVarArr[i8];
            n0.f fVar2 = new n0.f();
            float f3 = (float) fVar.f3966b;
            if (f3 < 0.0f) {
                throw new IllegalArgumentException("Damping ratio must be non-negative");
            }
            fVar2.f3966b = f3;
            fVar2.f3967c = false;
            double d = fVar.f3965a;
            float f7 = (float) (d * d);
            if (f7 <= 0.0f) {
                throw new IllegalArgumentException("Spring stiffness constant must be positive.");
            }
            fVar2.f3965a = Math.sqrt(f7);
            fVar2.f3967c = false;
            eVar.f3962j = fVar2;
            i8++;
        }
    }

    public final void l(float f3) {
        h hVar = this.f5475b;
        if (hVar.f5469n != f3) {
            hVar.f5469n = f3;
            r();
        }
    }

    public final void m(ColorStateList colorStateList) {
        h hVar = this.f5475b;
        if (hVar.d != colorStateList) {
            hVar.d = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f5475b = new h(this.f5475b);
        return this;
    }

    public final void n(z zVar) {
        h hVar = this.f5475b;
        if (hVar.f5458b != zVar) {
            hVar.f5458b = zVar;
            p(getState(), true);
            invalidateSelf();
        }
    }

    public final boolean o(int[] iArr) {
        boolean z;
        Paint paint;
        int color;
        int colorForState;
        Paint paint2;
        int color2;
        int colorForState2;
        if (this.f5475b.d == null || color2 == (colorForState2 = this.f5475b.d.getColorForState(iArr, (color2 = (paint2 = this.f5487p).getColor())))) {
            z = false;
        } else {
            paint2.setColor(colorForState2);
            z = true;
        }
        if (this.f5475b.f5460e == null || color == (colorForState = this.f5475b.f5460e.getColorForState(iArr, (color = (paint = this.f5488q).getColor())))) {
            return z;
        }
        paint.setColor(colorForState);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        this.f5478f = true;
        this.f5479g = true;
        super.onBoundsChange(rect);
        if (this.f5475b.f5458b != null && !rect.isEmpty()) {
            p(getState(), this.f5494w);
        }
        this.f5494w = rect.isEmpty();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        if (this.f5475b.f5458b != null) {
            p(iArr, false);
        }
        boolean z = o(iArr) || q();
        if (z) {
            invalidateSelf();
        }
        return z;
    }

    public final void p(int[] iArr, boolean z) {
        n nVarA;
        int i8;
        RectF rectFF = f();
        if (this.f5475b.f5458b == null || rectFF.isEmpty()) {
            return;
        }
        boolean z2 = z | (this.y == null);
        if (this.A == null) {
            this.A = new float[4];
        }
        z zVar = this.f5475b.f5458b;
        n[] nVarArr = zVar.d;
        int i9 = zVar.f5552a;
        int[][] iArr2 = zVar.f5554c;
        y yVar = zVar.f5558h;
        y yVar2 = zVar.f5557g;
        y yVar3 = zVar.f5556f;
        y yVar4 = zVar.f5555e;
        int i10 = 0;
        while (true) {
            if (i10 >= i9) {
                i10 = -1;
                break;
            } else if (StateSet.stateSetMatches(iArr2[i10], iArr)) {
                break;
            } else {
                i10++;
            }
        }
        if (i10 < 0) {
            int[] iArr3 = StateSet.WILD_CARD;
            int i11 = 0;
            while (true) {
                if (i11 >= i9) {
                    i8 = -1;
                    break;
                } else {
                    if (StateSet.stateSetMatches(iArr2[i11], iArr3)) {
                        i8 = i11;
                        break;
                    }
                    i11++;
                }
            }
            i10 = i8;
        }
        if (yVar4 == null && yVar3 == null && yVar2 == null && yVar == null) {
            nVarA = nVarArr[i10];
        } else {
            m mVarF = nVarArr[i10].f();
            if (yVar4 != null) {
                mVarF.f5500e = yVar4.c(iArr);
            }
            if (yVar3 != null) {
                mVarF.f5501f = yVar3.c(iArr);
            }
            if (yVar2 != null) {
                mVarF.f5503h = yVar2.c(iArr);
            }
            if (yVar != null) {
                mVarF.f5502g = yVar.c(iArr);
            }
            nVarA = mVarF.a();
        }
        int i12 = 0;
        while (i12 < 4) {
            this.f5490s.getClass();
            float fA = (i12 != 1 ? i12 != 2 ? i12 != 3 ? nVarA.f5512f : nVarA.f5511e : nVarA.f5514h : nVarA.f5513g).a(rectFF);
            if (z2) {
                this.A[i12] = fA;
            }
            n0.e[] eVarArr = this.z;
            n0.e eVar = eVarArr[i12];
            if (eVar != null) {
                eVar.a(fA);
                if (z2) {
                    eVarArr[i12].d();
                }
            }
            i12++;
        }
        if (z2) {
            invalidateSelf();
        }
    }

    public final boolean q() {
        PorterDuffColorFilter porterDuffColorFilter;
        PorterDuffColorFilter porterDuffColorFilter2 = this.f5491t;
        PorterDuffColorFilter porterDuffColorFilter3 = this.f5492u;
        h hVar = this.f5475b;
        ColorStateList colorStateList = hVar.f5461f;
        PorterDuff.Mode mode = hVar.f5462g;
        if (colorStateList == null || mode == null) {
            int color = this.f5487p.getColor();
            int iC = c(color);
            porterDuffColorFilter = iC != color ? new PorterDuffColorFilter(iC, PorterDuff.Mode.SRC_IN) : null;
        } else {
            porterDuffColorFilter = new PorterDuffColorFilter(c(colorStateList.getColorForState(getState(), 0)), mode);
        }
        this.f5491t = porterDuffColorFilter;
        this.f5475b.getClass();
        this.f5492u = null;
        this.f5475b.getClass();
        return (Objects.equals(porterDuffColorFilter2, this.f5491t) && Objects.equals(porterDuffColorFilter3, this.f5492u)) ? false : true;
    }

    public final void r() {
        h hVar = this.f5475b;
        float f3 = hVar.f5469n + 0.0f;
        hVar.f5470o = (int) Math.ceil(0.75f * f3);
        this.f5475b.f5471p = (int) Math.ceil(f3 * 0.25f);
        q();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i8) {
        h hVar = this.f5475b;
        if (hVar.f5467l != i8) {
            hVar.f5467l = i8;
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f5475b.getClass();
        super.invalidateSelf();
    }

    @Override // t1.x
    public final void setShapeAppearanceModel(n nVar) {
        h hVar = this.f5475b;
        hVar.f5457a = nVar;
        hVar.f5458b = null;
        this.A = null;
        this.B = null;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i8) {
        setTintList(ColorStateList.valueOf(i8));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f5475b.f5461f = colorStateList;
        q();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        h hVar = this.f5475b;
        if (hVar.f5462g != mode) {
            hVar.f5462g = mode;
            q();
            super.invalidateSelf();
        }
    }

    public j(n nVar) {
        this(new h(nVar));
    }

    public j(h hVar) {
        p pVar;
        this.f5474a = new g(this);
        this.f5476c = new v[4];
        this.d = new v[4];
        this.f5477e = new BitSet(8);
        this.f5480h = new Matrix();
        this.f5481j = new Path();
        this.f5482k = new Path();
        this.f5483l = new RectF();
        this.f5484m = new RectF();
        this.f5485n = new Region();
        this.f5486o = new Region();
        Paint paint = new Paint(1);
        this.f5487p = paint;
        Paint paint2 = new Paint(1);
        this.f5488q = paint2;
        new s1.a();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            pVar = o.f5519a;
        } else {
            pVar = new p();
        }
        this.f5490s = pVar;
        this.f5493v = new RectF();
        this.f5494w = true;
        this.z = new n0.e[4];
        this.f5475b = hVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        q();
        o(getState());
        this.f5489r = new g(this);
    }
}
