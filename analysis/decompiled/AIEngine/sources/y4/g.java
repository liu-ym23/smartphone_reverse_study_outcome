package y4;

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
import android.util.StateSet;
import com.google.android.material.button.MaterialButton;
import java.util.BitSet;
import java.util.Objects;
import r4.a;
import y4.j;
import y4.k;
import y4.m;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class g extends Drawable implements n {
    public static final e[] G;
    public j A;
    public h1.g B;
    public final h1.f[] C;
    public float[] D;
    public float[] E;
    public d F;

    /* renamed from: a, reason: collision with root package name */
    public final a f14022a;

    /* renamed from: b, reason: collision with root package name */
    public c f14023b;

    /* renamed from: c, reason: collision with root package name */
    public final m.f[] f14024c;

    /* renamed from: d, reason: collision with root package name */
    public final m.f[] f14025d;

    /* renamed from: e, reason: collision with root package name */
    public final BitSet f14026e;
    public boolean h;

    /* renamed from: j, reason: collision with root package name */
    public boolean f14027j;

    /* renamed from: k, reason: collision with root package name */
    public final Matrix f14028k;

    /* renamed from: l, reason: collision with root package name */
    public final Path f14029l;

    /* renamed from: m, reason: collision with root package name */
    public final Path f14030m;

    /* renamed from: n, reason: collision with root package name */
    public final RectF f14031n;

    /* renamed from: o, reason: collision with root package name */
    public final RectF f14032o;

    /* renamed from: p, reason: collision with root package name */
    public final Region f14033p;

    /* renamed from: q, reason: collision with root package name */
    public final Region f14034q;
    public final Paint r;

    /* renamed from: s, reason: collision with root package name */
    public final Paint f14035s;

    /* renamed from: t, reason: collision with root package name */
    public final b f14036t;

    /* renamed from: u, reason: collision with root package name */
    public final k f14037u;

    /* renamed from: v, reason: collision with root package name */
    public PorterDuffColorFilter f14038v;

    /* renamed from: w, reason: collision with root package name */
    public PorterDuffColorFilter f14039w;

    /* renamed from: x, reason: collision with root package name */
    public int f14040x;

    /* renamed from: y, reason: collision with root package name */
    public final RectF f14041y;
    public boolean z;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a {
        public a() {
        }

        public final y4.d a(y4.d dVar) {
            return dVar instanceof h ? dVar : new y4.b(-g.this.i(), dVar);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b {
        public b() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface d {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class e extends androidx.datastore.preferences.protobuf.f {

        /* renamed from: b, reason: collision with root package name */
        public final int f14060b;

        public e(int i10) {
            this.f14060b = i10;
        }

        @Override // androidx.datastore.preferences.protobuf.f
        public final float f(Object obj) {
            float[] fArr = ((g) obj).D;
            if (fArr != null) {
                return fArr[this.f14060b];
            }
            return 0.0f;
        }

        @Override // androidx.datastore.preferences.protobuf.f
        public final void i(Object obj, float f8) {
            g gVar = (g) obj;
            float[] fArr = gVar.D;
            if (fArr != null) {
                int i10 = this.f14060b;
                if (fArr[i10] != f8) {
                    fArr[i10] = f8;
                    d dVar = gVar.F;
                    if (dVar != null) {
                        float fH = gVar.h();
                        MaterialButton materialButton = (MaterialButton) ((com.google.android.material.button.a) dVar).f4761g;
                        int i11 = (int) (fH * 0.11f);
                        if (materialButton.A != i11) {
                            materialButton.A = i11;
                            materialButton.j();
                            materialButton.invalidate();
                        }
                    }
                    gVar.invalidateSelf();
                }
            }
        }
    }

    static {
        j.a aVar = new j.a();
        int i10 = 0;
        xb.a aVarB = xb.a.b(0);
        aVar.f14073a = aVarB;
        aVar.f14074b = aVarB;
        aVar.f14075c = aVarB;
        aVar.f14076d = aVarB;
        aVar.b(0.0f);
        aVar.a();
        Paint paint = new Paint(1);
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        G = new e[4];
        while (true) {
            e[] eVarArr = G;
            if (i10 >= eVarArr.length) {
                return;
            }
            eVarArr[i10] = new e(i10);
            i10++;
        }
    }

    public g() {
        this(new j());
    }

    public static float c(RectF rectF, j jVar, float[] fArr) {
        if (fArr == null) {
            if (jVar.e(rectF)) {
                return jVar.f14066e.a(rectF);
            }
            return -1.0f;
        }
        if (fArr.length > 1) {
            float f8 = fArr[0];
            for (int i10 = 1; i10 < fArr.length; i10++) {
                if (fArr[i10] != f8) {
                    return -1.0f;
                }
            }
        }
        if (jVar.d()) {
            return fArr[0];
        }
        return -1.0f;
    }

    public final void b(RectF rectF, Path path) {
        c cVar = this.f14023b;
        this.f14037u.a(cVar.f14044a, this.D, cVar.f14052j, rectF, this.f14036t, path);
        if (this.f14023b.f14051i != 1.0f) {
            Matrix matrix = this.f14028k;
            matrix.reset();
            float f8 = this.f14023b.f14051i;
            matrix.setScale(f8, f8, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(matrix);
        }
        path.computeBounds(this.f14041y, true);
    }

    public final int d(int i10) {
        int i11;
        c cVar = this.f14023b;
        float f8 = cVar.f14056n + 0.0f + cVar.f14055m;
        s4.a aVar = cVar.f14046c;
        if (aVar == null || !aVar.f11884a || n0.a.d(i10, 255) != aVar.f11887d) {
            return i10;
        }
        float fMin = (aVar.f11888e <= 0.0f || f8 <= 0.0f) ? 0.0f : Math.min(((((float) Math.log1p(f8 / r3)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
        int iAlpha = Color.alpha(i10);
        int iC = jd.b.C(fMin, n0.a.d(i10, 255), aVar.f11885b);
        if (fMin > 0.0f && (i11 = aVar.f11886c) != 0) {
            iC = n0.a.b(n0.a.d(i11, s4.a.f11883f), iC);
        }
        return n0.a.d(iC, iAlpha);
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
        throw new UnsupportedOperationException("Method not decompiled: y4.g.draw(android.graphics.Canvas):void");
    }

    public final void e(Canvas canvas, Paint paint, Path path, j jVar, float[] fArr, RectF rectF) {
        float fC = c(rectF, jVar, fArr);
        if (fC < 0.0f) {
            canvas.drawPath(path, paint);
        } else {
            float f8 = fC * this.f14023b.f14052j;
            canvas.drawRoundRect(rectF, f8, f8, paint);
        }
    }

    public void f(Canvas canvas) {
        j jVar = this.A;
        float[] fArr = this.E;
        RectF rectFG = g();
        RectF rectF = this.f14032o;
        rectF.set(rectFG);
        float fI = i();
        rectF.inset(fI, fI);
        e(canvas, this.f14035s, this.f14030m, jVar, fArr, rectF);
    }

    public final RectF g() {
        Rect bounds = getBounds();
        RectF rectF = this.f14031n;
        rectF.set(bounds);
        return rectF;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f14023b.f14054l;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.f14023b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        this.f14023b.getClass();
        RectF rectFG = g();
        if (rectFG.isEmpty()) {
            return;
        }
        float fC = c(rectFG, this.f14023b.f14044a, this.D);
        if (fC >= 0.0f) {
            outline.setRoundRect(getBounds(), fC * this.f14023b.f14052j);
            return;
        }
        boolean z = this.h;
        Path path = this.f14029l;
        if (z) {
            b(rectFG, path);
            this.h = false;
        }
        a.C0131a.a(outline, path);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        Rect rect2 = this.f14023b.h;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final Region getTransparentRegion() {
        Rect bounds = getBounds();
        Region region = this.f14033p;
        region.set(bounds);
        RectF rectFG = g();
        Path path = this.f14029l;
        b(rectFG, path);
        Region region2 = this.f14034q;
        region2.setPath(path, region);
        region.op(region2, Region.Op.DIFFERENCE);
        return region;
    }

    public final float h() {
        float[] fArr = this.D;
        if (fArr != null) {
            return (((fArr[3] + fArr[2]) - fArr[1]) - fArr[0]) / 2.0f;
        }
        RectF rectFG = g();
        j jVar = this.f14023b.f14044a;
        k kVar = this.f14037u;
        kVar.getClass();
        float fA = jVar.f14066e.a(rectFG);
        j jVar2 = this.f14023b.f14044a;
        kVar.getClass();
        float fA2 = jVar2.h.a(rectFG) + fA;
        j jVar3 = this.f14023b.f14044a;
        kVar.getClass();
        float fA3 = fA2 - jVar3.f14068g.a(rectFG);
        j jVar4 = this.f14023b.f14044a;
        kVar.getClass();
        return (fA3 - jVar4.f14067f.a(rectFG)) / 2.0f;
    }

    public final float i() {
        if (j()) {
            return this.f14035s.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        this.h = true;
        this.f14027j = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (super.isStateful()) {
            return true;
        }
        ColorStateList colorStateList = this.f14023b.f14049f;
        if (colorStateList != null && colorStateList.isStateful()) {
            return true;
        }
        this.f14023b.getClass();
        ColorStateList colorStateList2 = this.f14023b.f14048e;
        if (colorStateList2 != null && colorStateList2.isStateful()) {
            return true;
        }
        ColorStateList colorStateList3 = this.f14023b.f14047d;
        if (colorStateList3 != null && colorStateList3.isStateful()) {
            return true;
        }
        p pVar = this.f14023b.f14045b;
        return pVar != null && pVar.d();
    }

    public final boolean j() {
        Paint.Style style = this.f14023b.f14059q;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.f14035s.getStrokeWidth() > 0.0f;
    }

    public final void k(Context context) {
        this.f14023b.f14046c = new s4.a(context);
        s();
    }

    public final void l(h1.g gVar) {
        if (this.B == gVar) {
            return;
        }
        this.B = gVar;
        int i10 = 0;
        while (true) {
            h1.f[] fVarArr = this.C;
            if (i10 >= fVarArr.length) {
                q(getState(), true);
                invalidateSelf();
                return;
            }
            if (fVarArr[i10] == null) {
                fVarArr[i10] = new h1.f(this, G[i10]);
            }
            h1.f fVar = fVarArr[i10];
            h1.g gVar2 = new h1.g();
            gVar2.a((float) gVar.f9245b);
            double d8 = gVar.f9244a;
            gVar2.b((float) (d8 * d8));
            fVar.f9241t = gVar2;
            i10++;
        }
    }

    public final void m(float f8) {
        c cVar = this.f14023b;
        if (cVar.f14056n != f8) {
            cVar.f14056n = f8;
            s();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f14023b = new c(this.f14023b);
        return this;
    }

    public final void n(ColorStateList colorStateList) {
        c cVar = this.f14023b;
        if (cVar.f14047d != colorStateList) {
            cVar.f14047d = colorStateList;
            onStateChange(getState());
        }
    }

    public final void o(p pVar) {
        c cVar = this.f14023b;
        if (cVar.f14045b != pVar) {
            cVar.f14045b = pVar;
            q(getState(), true);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        this.h = true;
        this.f14027j = true;
        super.onBoundsChange(rect);
        if (this.f14023b.f14045b != null && !rect.isEmpty()) {
            q(getState(), this.z);
        }
        this.z = rect.isEmpty();
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.g.b
    public boolean onStateChange(int[] iArr) {
        if (this.f14023b.f14045b != null) {
            q(iArr, false);
        }
        boolean z = p(iArr) || r();
        if (z) {
            invalidateSelf();
        }
        return z;
    }

    public final boolean p(int[] iArr) {
        boolean z;
        Paint paint;
        int color;
        int colorForState;
        Paint paint2;
        int color2;
        int colorForState2;
        if (this.f14023b.f14047d == null || color2 == (colorForState2 = this.f14023b.f14047d.getColorForState(iArr, (color2 = (paint2 = this.r).getColor())))) {
            z = false;
        } else {
            paint2.setColor(colorForState2);
            z = true;
        }
        if (this.f14023b.f14048e == null || color == (colorForState = this.f14023b.f14048e.getColorForState(iArr, (color = (paint = this.f14035s).getColor())))) {
            return z;
        }
        paint.setColor(colorForState);
        return true;
    }

    public final void q(int[] iArr, boolean z) {
        j jVarA;
        int i10;
        RectF rectFG = g();
        if (this.f14023b.f14045b == null || rectFG.isEmpty()) {
            return;
        }
        boolean z3 = z | (this.B == null);
        if (this.D == null) {
            this.D = new float[4];
        }
        p pVar = this.f14023b.f14045b;
        j[] jVarArr = pVar.f14122d;
        int i11 = pVar.f14119a;
        int[][] iArr2 = pVar.f14121c;
        o oVar = pVar.h;
        o oVar2 = pVar.f14125g;
        o oVar3 = pVar.f14124f;
        o oVar4 = pVar.f14123e;
        int i12 = 0;
        while (true) {
            if (i12 >= i11) {
                i12 = -1;
                break;
            } else if (StateSet.stateSetMatches(iArr2[i12], iArr)) {
                break;
            } else {
                i12++;
            }
        }
        if (i12 < 0) {
            int[] iArr3 = StateSet.WILD_CARD;
            int i13 = 0;
            while (true) {
                if (i13 >= i11) {
                    i10 = -1;
                    break;
                } else {
                    if (StateSet.stateSetMatches(iArr2[i13], iArr3)) {
                        i10 = i13;
                        break;
                    }
                    i13++;
                }
            }
            i12 = i10;
        }
        if (oVar4 == null && oVar3 == null && oVar2 == null && oVar == null) {
            jVarA = jVarArr[i12];
        } else {
            j.a aVarF = jVarArr[i12].f();
            if (oVar4 != null) {
                aVarF.f14077e = oVar4.c(iArr);
            }
            if (oVar3 != null) {
                aVarF.f14078f = oVar3.c(iArr);
            }
            if (oVar2 != null) {
                aVarF.h = oVar2.c(iArr);
            }
            if (oVar != null) {
                aVarF.f14079g = oVar.c(iArr);
            }
            jVarA = aVarF.a();
        }
        int i14 = 0;
        while (i14 < 4) {
            this.f14037u.getClass();
            float fA = (i14 != 1 ? i14 != 2 ? i14 != 3 ? jVarA.f14067f : jVarA.f14066e : jVarA.h : jVarA.f14068g).a(rectFG);
            if (z3) {
                this.D[i14] = fA;
            }
            h1.f[] fVarArr = this.C;
            h1.f fVar = fVarArr[i14];
            if (fVar != null) {
                if (fVar.f9232f) {
                    fVar.f9242u = fA;
                } else {
                    if (fVar.f9241t == null) {
                        fVar.f9241t = new h1.g(fA);
                    }
                    fVar.f9241t.f9251i = fA;
                    fVar.h();
                }
                if (z3) {
                    fVarArr[i14].g();
                }
            }
            i14++;
        }
        if (z3) {
            invalidateSelf();
        }
    }

    public final boolean r() {
        PorterDuffColorFilter porterDuffColorFilter;
        PorterDuffColorFilter porterDuffColorFilter2 = this.f14038v;
        PorterDuffColorFilter porterDuffColorFilter3 = this.f14039w;
        c cVar = this.f14023b;
        ColorStateList colorStateList = cVar.f14049f;
        PorterDuff.Mode mode = cVar.f14050g;
        if (colorStateList == null || mode == null) {
            int color = this.r.getColor();
            int iD = d(color);
            this.f14040x = iD;
            porterDuffColorFilter = iD != color ? new PorterDuffColorFilter(iD, PorterDuff.Mode.SRC_IN) : null;
        } else {
            int iD2 = d(colorStateList.getColorForState(getState(), 0));
            this.f14040x = iD2;
            porterDuffColorFilter = new PorterDuffColorFilter(iD2, mode);
        }
        this.f14038v = porterDuffColorFilter;
        this.f14023b.getClass();
        this.f14039w = null;
        this.f14023b.getClass();
        return (Objects.equals(porterDuffColorFilter2, this.f14038v) && Objects.equals(porterDuffColorFilter3, this.f14039w)) ? false : true;
    }

    public final void s() {
        c cVar = this.f14023b;
        float f8 = cVar.f14056n + 0.0f;
        cVar.f14057o = (int) Math.ceil(0.75f * f8);
        this.f14023b.f14058p = (int) Math.ceil(f8 * 0.25f);
        r();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        c cVar = this.f14023b;
        if (cVar.f14054l != i10) {
            cVar.f14054l = i10;
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f14023b.getClass();
        super.invalidateSelf();
    }

    @Override // y4.n
    public final void setShapeAppearanceModel(j jVar) {
        c cVar = this.f14023b;
        cVar.f14044a = jVar;
        cVar.f14045b = null;
        this.D = null;
        this.E = null;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i10) {
        setTintList(ColorStateList.valueOf(i10));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f14023b.f14049f = colorStateList;
        r();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        c cVar = this.f14023b;
        if (cVar.f14050g != mode) {
            cVar.f14050g = mode;
            r();
            super.invalidateSelf();
        }
    }

    public g(Context context, AttributeSet attributeSet, int i10, int i11) {
        this(j.b(context, attributeSet, i10, i11).a());
    }

    public g(j jVar) {
        this(new c(jVar));
    }

    public g(c cVar) {
        k kVar;
        this.f14022a = new a();
        this.f14024c = new m.f[4];
        this.f14025d = new m.f[4];
        this.f14026e = new BitSet(8);
        this.f14028k = new Matrix();
        this.f14029l = new Path();
        this.f14030m = new Path();
        this.f14031n = new RectF();
        this.f14032o = new RectF();
        this.f14033p = new Region();
        this.f14034q = new Region();
        Paint paint = new Paint(1);
        this.r = paint;
        Paint paint2 = new Paint(1);
        this.f14035s = paint2;
        new x4.a();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            kVar = k.a.f14095a;
        } else {
            kVar = new k();
        }
        this.f14037u = kVar;
        this.f14041y = new RectF();
        this.z = true;
        this.C = new h1.f[4];
        this.f14023b = cVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        r();
        p(getState());
        this.f14036t = new b();
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class c extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        public j f14044a;

        /* renamed from: b, reason: collision with root package name */
        public p f14045b;

        /* renamed from: c, reason: collision with root package name */
        public s4.a f14046c;

        /* renamed from: d, reason: collision with root package name */
        public ColorStateList f14047d;

        /* renamed from: e, reason: collision with root package name */
        public ColorStateList f14048e;

        /* renamed from: f, reason: collision with root package name */
        public ColorStateList f14049f;

        /* renamed from: g, reason: collision with root package name */
        public PorterDuff.Mode f14050g;
        public Rect h;

        /* renamed from: i, reason: collision with root package name */
        public final float f14051i;

        /* renamed from: j, reason: collision with root package name */
        public float f14052j;

        /* renamed from: k, reason: collision with root package name */
        public float f14053k;

        /* renamed from: l, reason: collision with root package name */
        public int f14054l;

        /* renamed from: m, reason: collision with root package name */
        public float f14055m;

        /* renamed from: n, reason: collision with root package name */
        public float f14056n;

        /* renamed from: o, reason: collision with root package name */
        public int f14057o;

        /* renamed from: p, reason: collision with root package name */
        public int f14058p;

        /* renamed from: q, reason: collision with root package name */
        public final Paint.Style f14059q;

        public c(j jVar) {
            this.f14047d = null;
            this.f14048e = null;
            this.f14049f = null;
            this.f14050g = PorterDuff.Mode.SRC_IN;
            this.h = null;
            this.f14051i = 1.0f;
            this.f14052j = 1.0f;
            this.f14054l = 255;
            this.f14055m = 0.0f;
            this.f14056n = 0.0f;
            this.f14057o = 0;
            this.f14058p = 0;
            this.f14059q = Paint.Style.FILL_AND_STROKE;
            this.f14044a = jVar;
            this.f14046c = null;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            g gVar = new g(this);
            gVar.h = true;
            gVar.f14027j = true;
            return gVar;
        }

        public c(c cVar) {
            this.f14047d = null;
            this.f14048e = null;
            this.f14049f = null;
            this.f14050g = PorterDuff.Mode.SRC_IN;
            this.h = null;
            this.f14051i = 1.0f;
            this.f14052j = 1.0f;
            this.f14054l = 255;
            this.f14055m = 0.0f;
            this.f14056n = 0.0f;
            this.f14057o = 0;
            this.f14058p = 0;
            this.f14059q = Paint.Style.FILL_AND_STROKE;
            this.f14044a = cVar.f14044a;
            this.f14045b = cVar.f14045b;
            this.f14046c = cVar.f14046c;
            this.f14053k = cVar.f14053k;
            this.f14047d = cVar.f14047d;
            this.f14048e = cVar.f14048e;
            this.f14050g = cVar.f14050g;
            this.f14049f = cVar.f14049f;
            this.f14054l = cVar.f14054l;
            this.f14051i = cVar.f14051i;
            this.f14058p = cVar.f14058p;
            this.f14052j = cVar.f14052j;
            this.f14055m = cVar.f14055m;
            this.f14056n = cVar.f14056n;
            this.f14057o = cVar.f14057o;
            this.f14059q = cVar.f14059q;
            if (cVar.h != null) {
                this.h = new Rect(cVar.h);
            }
        }
    }
}
