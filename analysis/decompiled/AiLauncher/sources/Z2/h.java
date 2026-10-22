package Z2;

import Z2.l;
import Z2.m;
import Z2.n;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
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
import com.google.android.material.R$attr;
import java.util.BitSet;

/* loaded from: classes2.dex */
public class h extends Drawable implements o {

    /* renamed from: F, reason: collision with root package name */
    public static final String f7120F = "h";

    /* renamed from: G, reason: collision with root package name */
    public static final l f7121G = l.a().q(0, 0.0f).m();

    /* renamed from: H, reason: collision with root package name */
    public static final Paint f7122H;

    /* renamed from: I, reason: collision with root package name */
    public static final e[] f7123I;

    /* renamed from: A, reason: collision with root package name */
    public androidx.dynamicanimation.animation.j f7124A;

    /* renamed from: B, reason: collision with root package name */
    public androidx.dynamicanimation.animation.i[] f7125B;

    /* renamed from: C, reason: collision with root package name */
    public float[] f7126C;

    /* renamed from: D, reason: collision with root package name */
    public float[] f7127D;

    /* renamed from: E, reason: collision with root package name */
    public d f7128E;

    /* renamed from: a, reason: collision with root package name */
    public final l.c f7129a;

    /* renamed from: b, reason: collision with root package name */
    public c f7130b;

    /* renamed from: c, reason: collision with root package name */
    public final n.g[] f7131c;

    /* renamed from: d, reason: collision with root package name */
    public final n.g[] f7132d;

    /* renamed from: e, reason: collision with root package name */
    public final BitSet f7133e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f7134f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f7135g;

    /* renamed from: h, reason: collision with root package name */
    public final Matrix f7136h;

    /* renamed from: i, reason: collision with root package name */
    public final Path f7137i;

    /* renamed from: j, reason: collision with root package name */
    public final Path f7138j;

    /* renamed from: k, reason: collision with root package name */
    public final RectF f7139k;

    /* renamed from: l, reason: collision with root package name */
    public final RectF f7140l;

    /* renamed from: m, reason: collision with root package name */
    public final Region f7141m;

    /* renamed from: n, reason: collision with root package name */
    public final Region f7142n;

    /* renamed from: o, reason: collision with root package name */
    public final Paint f7143o;

    /* renamed from: p, reason: collision with root package name */
    public final Paint f7144p;

    /* renamed from: q, reason: collision with root package name */
    public final Y2.a f7145q;

    /* renamed from: r, reason: collision with root package name */
    public final m.b f7146r;

    /* renamed from: s, reason: collision with root package name */
    public final m f7147s;

    /* renamed from: t, reason: collision with root package name */
    public PorterDuffColorFilter f7148t;

    /* renamed from: u, reason: collision with root package name */
    public PorterDuffColorFilter f7149u;

    /* renamed from: v, reason: collision with root package name */
    public int f7150v;

    /* renamed from: w, reason: collision with root package name */
    public final RectF f7151w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f7152x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f7153y;

    /* renamed from: z, reason: collision with root package name */
    public l f7154z;

    public class a implements l.c {
        public a() {
        }

        @Override // Z2.l.c
        public Z2.d a(Z2.d dVar) {
            return dVar instanceof j ? dVar : new Z2.b(-h.this.K(), dVar);
        }
    }

    public class b implements m.b {
        public b() {
        }

        @Override // Z2.m.b
        public void a(n nVar, Matrix matrix, int i10) {
            h.this.f7133e.set(i10 + 4, nVar.e());
            h.this.f7132d[i10] = nVar.f(matrix);
        }

        @Override // Z2.m.b
        public void b(n nVar, Matrix matrix, int i10) {
            h.this.f7133e.set(i10, nVar.e());
            h.this.f7131c[i10] = nVar.f(matrix);
        }
    }

    public interface d {
        void a(float f10);
    }

    public static class e extends androidx.dynamicanimation.animation.f<h> {

        /* renamed from: a, reason: collision with root package name */
        public final int f7180a;

        public e(int i10) {
            super("cornerSizeAtIndex" + i10);
            this.f7180a = i10;
        }

        @Override // androidx.dynamicanimation.animation.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public float getValue(h hVar) {
            if (hVar.f7126C != null) {
                return hVar.f7126C[this.f7180a];
            }
            return 0.0f;
        }

        @Override // androidx.dynamicanimation.animation.f
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void setValue(h hVar, float f10) {
            if (hVar.f7126C == null || hVar.f7126C[this.f7180a] == f10) {
                return;
            }
            hVar.f7126C[this.f7180a] = f10;
            if (hVar.f7128E != null) {
                hVar.f7128E.a(hVar.z());
            }
            hVar.invalidateSelf();
        }
    }

    static {
        int i10 = 0;
        Paint paint = new Paint(1);
        f7122H = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        f7123I = new e[4];
        while (true) {
            e[] eVarArr = f7123I;
            if (i10 >= eVarArr.length) {
                return;
            }
            eVarArr[i10] = new e(i10);
            i10++;
        }
    }

    public h() {
        this(new l());
    }

    public static int Z(int i10, int i11) {
        return (i10 * (i11 + (i11 >>> 7))) >>> 8;
    }

    public static h r(Context context, float f10, ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(M2.a.c(context, R$attr.colorSurface, h.class.getSimpleName()));
        }
        h hVar = new h();
        hVar.U(context);
        hVar.g0(colorStateList);
        hVar.f0(f10);
        return hVar;
    }

    public float A() {
        return this.f7130b.f7172p;
    }

    public ColorStateList B() {
        return this.f7130b.f7161e;
    }

    public float C() {
        return this.f7130b.f7168l;
    }

    public float D() {
        return this.f7130b.f7171o;
    }

    public int E() {
        return this.f7150v;
    }

    public int F() {
        c cVar = this.f7130b;
        return (int) (cVar.f7176t * Math.sin(Math.toRadians(cVar.f7177u)));
    }

    public int G() {
        c cVar = this.f7130b;
        return (int) (cVar.f7176t * Math.cos(Math.toRadians(cVar.f7177u)));
    }

    public int H() {
        return this.f7130b.f7175s;
    }

    public l I() {
        return this.f7130b.f7157a;
    }

    public ColorStateList J() {
        return this.f7130b.f7162f;
    }

    public final float K() {
        if (T()) {
            return this.f7144p.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    public float L() {
        return this.f7130b.f7169m;
    }

    public ColorStateList M() {
        return this.f7130b.f7164h;
    }

    public float N() {
        float[] fArr = this.f7126C;
        return fArr != null ? fArr[3] : this.f7130b.f7157a.r().a(x());
    }

    public float O() {
        float[] fArr = this.f7126C;
        return fArr != null ? fArr[0] : this.f7130b.f7157a.t().a(x());
    }

    public float P() {
        return this.f7130b.f7173q;
    }

    public float Q() {
        return A() + P();
    }

    public final boolean R() {
        c cVar = this.f7130b;
        int i10 = cVar.f7174r;
        if (i10 == 1 || cVar.f7175s <= 0) {
            return false;
        }
        return i10 == 2 || b0();
    }

    public final boolean S() {
        Paint.Style style = this.f7130b.f7179w;
        return style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL;
    }

    public final boolean T() {
        Paint.Style style = this.f7130b.f7179w;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.f7144p.getStrokeWidth() > 0.0f;
    }

    public void U(Context context) {
        this.f7130b.f7159c = new P2.a(context);
        v0();
    }

    public final void V() {
        super.invalidateSelf();
    }

    public boolean W() {
        P2.a aVar = this.f7130b.f7159c;
        return aVar != null && aVar.d();
    }

    public boolean X() {
        if (this.f7130b.f7157a.v(x())) {
            return true;
        }
        float[] fArr = this.f7126C;
        return fArr != null && S2.a.a(fArr) && this.f7130b.f7157a.u();
    }

    public final void Y(Canvas canvas) {
        if (R()) {
            canvas.save();
            a0(canvas);
            if (!this.f7152x) {
                s(canvas);
                canvas.restore();
                return;
            }
            int iWidth = (int) (this.f7151w.width() - getBounds().width());
            int iHeight = (int) (this.f7151w.height() - getBounds().height());
            if (iWidth < 0 || iHeight < 0) {
                throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(((int) this.f7151w.width()) + (this.f7130b.f7175s * 2) + iWidth, ((int) this.f7151w.height()) + (this.f7130b.f7175s * 2) + iHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(bitmapCreateBitmap);
            float f10 = (getBounds().left - this.f7130b.f7175s) - iWidth;
            float f11 = (getBounds().top - this.f7130b.f7175s) - iHeight;
            canvas2.translate(-f10, -f11);
            s(canvas2);
            canvas.drawBitmap(bitmapCreateBitmap, f10, f11, (Paint) null);
            bitmapCreateBitmap.recycle();
            canvas.restore();
        }
    }

    public final void a0(Canvas canvas) {
        canvas.translate(F(), G());
    }

    public boolean b0() {
        if (X()) {
            return false;
        }
        this.f7137i.isConvex();
        return false;
    }

    public void c0(float f10) {
        setShapeAppearanceModel(this.f7130b.f7157a.x(f10));
    }

    public void d0(Z2.d dVar) {
        setShapeAppearanceModel(this.f7130b.f7157a.y(dVar));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f7143o.setColorFilter(this.f7148t);
        int alpha = this.f7143o.getAlpha();
        this.f7143o.setAlpha(Z(alpha, this.f7130b.f7170n));
        this.f7144p.setColorFilter(this.f7149u);
        this.f7144p.setStrokeWidth(this.f7130b.f7169m);
        int alpha2 = this.f7144p.getAlpha();
        this.f7144p.setAlpha(Z(alpha2, this.f7130b.f7170n));
        if (S()) {
            if (this.f7134f) {
                k(x(), this.f7137i);
                this.f7134f = false;
            }
            Y(canvas);
            t(canvas);
        }
        if (T()) {
            if (this.f7135g) {
                n();
                this.f7135g = false;
            }
            w(canvas);
        }
        this.f7143o.setAlpha(alpha);
        this.f7144p.setAlpha(alpha2);
    }

    public void e0(androidx.dynamicanimation.animation.j jVar) {
        if (this.f7124A == jVar) {
            return;
        }
        this.f7124A = jVar;
        int i10 = 0;
        while (true) {
            androidx.dynamicanimation.animation.i[] iVarArr = this.f7125B;
            if (i10 >= iVarArr.length) {
                s0(getState(), true);
                invalidateSelf();
                return;
            } else {
                if (iVarArr[i10] == null) {
                    iVarArr[i10] = new androidx.dynamicanimation.animation.i(this, f7123I[i10]);
                }
                this.f7125B[i10].B(new androidx.dynamicanimation.animation.j().f(jVar.a()).h(jVar.c()));
                i10++;
            }
        }
    }

    public void f0(float f10) {
        c cVar = this.f7130b;
        if (cVar.f7172p != f10) {
            cVar.f7172p = f10;
            v0();
        }
    }

    public void g0(ColorStateList colorStateList) {
        c cVar = this.f7130b;
        if (cVar.f7161e != colorStateList) {
            cVar.f7161e = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f7130b.f7170n;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f7130b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.f7130b.f7174r == 2) {
            return;
        }
        RectF rectFX = x();
        if (rectFX.isEmpty()) {
            return;
        }
        float fM = m(rectFX, this.f7130b.f7157a, this.f7126C);
        if (fM >= 0.0f) {
            outline.setRoundRect(getBounds(), fM * this.f7130b.f7168l);
            return;
        }
        if (this.f7134f) {
            k(rectFX, this.f7137i);
            this.f7134f = false;
        }
        O2.a.j(outline, this.f7137i);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        Rect rect2 = this.f7130b.f7166j;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        this.f7141m.set(getBounds());
        k(x(), this.f7137i);
        this.f7142n.setPath(this.f7137i, this.f7141m);
        this.f7141m.op(this.f7142n, Region.Op.DIFFERENCE);
        return this.f7141m;
    }

    public void h0(float f10) {
        c cVar = this.f7130b;
        if (cVar.f7168l != f10) {
            cVar.f7168l = f10;
            this.f7134f = true;
            this.f7135g = true;
            invalidateSelf();
        }
    }

    public void i0(d dVar) {
        this.f7128E = dVar;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.f7134f = true;
        this.f7135g = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (super.isStateful()) {
            return true;
        }
        ColorStateList colorStateList = this.f7130b.f7164h;
        if (colorStateList != null && colorStateList.isStateful()) {
            return true;
        }
        ColorStateList colorStateList2 = this.f7130b.f7163g;
        if (colorStateList2 != null && colorStateList2.isStateful()) {
            return true;
        }
        ColorStateList colorStateList3 = this.f7130b.f7162f;
        if (colorStateList3 != null && colorStateList3.isStateful()) {
            return true;
        }
        ColorStateList colorStateList4 = this.f7130b.f7161e;
        if (colorStateList4 != null && colorStateList4.isStateful()) {
            return true;
        }
        s sVar = this.f7130b.f7158b;
        return sVar != null && sVar.f();
    }

    public final PorterDuffColorFilter j(Paint paint, boolean z10) {
        if (!z10) {
            return null;
        }
        int color = paint.getColor();
        int iQ = q(color);
        this.f7150v = iQ;
        if (iQ != color) {
            return new PorterDuffColorFilter(iQ, PorterDuff.Mode.SRC_IN);
        }
        return null;
    }

    public void j0(int i10, int i11, int i12, int i13) {
        c cVar = this.f7130b;
        if (cVar.f7166j == null) {
            cVar.f7166j = new Rect();
        }
        this.f7130b.f7166j.set(i10, i11, i12, i13);
        invalidateSelf();
    }

    public final void k(RectF rectF, Path path) {
        l(rectF, path);
        if (this.f7130b.f7167k != 1.0f) {
            this.f7136h.reset();
            Matrix matrix = this.f7136h;
            float f10 = this.f7130b.f7167k;
            matrix.setScale(f10, f10, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.f7136h);
        }
        path.computeBounds(this.f7151w, true);
    }

    public void k0(float f10) {
        c cVar = this.f7130b;
        if (cVar.f7171o != f10) {
            cVar.f7171o = f10;
            v0();
        }
    }

    public final void l(RectF rectF, Path path) {
        m mVar = this.f7147s;
        c cVar = this.f7130b;
        mVar.f(cVar.f7157a, this.f7126C, cVar.f7168l, rectF, this.f7146r, path);
    }

    public void l0(s sVar) {
        c cVar = this.f7130b;
        if (cVar.f7158b != sVar) {
            cVar.f7158b = sVar;
            s0(getState(), true);
            invalidateSelf();
        }
    }

    public final float m(RectF rectF, l lVar, float[] fArr) {
        if (fArr == null) {
            if (lVar.v(rectF)) {
                return lVar.r().a(rectF);
            }
            return -1.0f;
        }
        if (S2.a.a(fArr) && lVar.u()) {
            return fArr[0];
        }
        return -1.0f;
    }

    public void m0(float f10, int i10) {
        p0(f10);
        o0(ColorStateList.valueOf(i10));
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f7130b = new c(this.f7130b);
        return this;
    }

    public final void n() {
        t0();
        this.f7147s.f(this.f7154z, this.f7127D, this.f7130b.f7168l, y(), null, this.f7138j);
    }

    public void n0(float f10, ColorStateList colorStateList) {
        p0(f10);
        o0(colorStateList);
    }

    public final PorterDuffColorFilter o(ColorStateList colorStateList, PorterDuff.Mode mode, boolean z10) {
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z10) {
            colorForState = q(colorForState);
        }
        this.f7150v = colorForState;
        return new PorterDuffColorFilter(colorForState, mode);
    }

    public void o0(ColorStateList colorStateList) {
        c cVar = this.f7130b;
        if (cVar.f7162f != colorStateList) {
            cVar.f7162f = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.f7134f = true;
        this.f7135g = true;
        super.onBoundsChange(rect);
        if (this.f7130b.f7158b != null && !rect.isEmpty()) {
            s0(getState(), this.f7153y);
        }
        this.f7153y = rect.isEmpty();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        if (this.f7130b.f7158b != null) {
            r0(iArr);
        }
        boolean z10 = q0(iArr) || u0();
        if (z10) {
            invalidateSelf();
        }
        return z10;
    }

    public final PorterDuffColorFilter p(ColorStateList colorStateList, PorterDuff.Mode mode, Paint paint, boolean z10) {
        return (colorStateList == null || mode == null) ? j(paint, z10) : o(colorStateList, mode, z10);
    }

    public void p0(float f10) {
        this.f7130b.f7169m = f10;
        invalidateSelf();
    }

    public int q(int i10) {
        float fQ = Q() + D();
        P2.a aVar = this.f7130b.f7159c;
        return aVar != null ? aVar.c(i10, fQ) : i10;
    }

    public final boolean q0(int[] iArr) {
        boolean z10;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.f7130b.f7161e == null || color2 == (colorForState2 = this.f7130b.f7161e.getColorForState(iArr, (color2 = this.f7143o.getColor())))) {
            z10 = false;
        } else {
            this.f7143o.setColor(colorForState2);
            z10 = true;
        }
        if (this.f7130b.f7162f == null || color == (colorForState = this.f7130b.f7162f.getColorForState(iArr, (color = this.f7144p.getColor())))) {
            return z10;
        }
        this.f7144p.setColor(colorForState);
        return true;
    }

    public final void r0(int[] iArr) {
        s0(iArr, false);
    }

    public final void s(Canvas canvas) {
        if (this.f7133e.cardinality() > 0) {
            Log.w(f7120F, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        if (this.f7130b.f7176t != 0) {
            canvas.drawPath(this.f7137i, this.f7145q.c());
        }
        for (int i10 = 0; i10 < 4; i10++) {
            this.f7131c[i10].a(this.f7145q, this.f7130b.f7175s, canvas);
            this.f7132d[i10].a(this.f7145q, this.f7130b.f7175s, canvas);
        }
        if (this.f7152x) {
            int iF = F();
            int iG = G();
            canvas.translate(-iF, -iG);
            canvas.drawPath(this.f7137i, f7122H);
            canvas.translate(iF, iG);
        }
    }

    public final void s0(int[] iArr, boolean z10) {
        RectF rectFX = x();
        if (this.f7130b.f7158b == null || rectFX.isEmpty()) {
            return;
        }
        boolean z11 = z10 | (this.f7124A == null);
        if (this.f7126C == null) {
            this.f7126C = new float[4];
        }
        l lVarD = this.f7130b.f7158b.d(iArr);
        for (int i10 = 0; i10 < 4; i10++) {
            float fA = this.f7147s.h(i10, lVarD).a(rectFX);
            if (z11) {
                this.f7126C[i10] = fA;
            }
            androidx.dynamicanimation.animation.i iVar = this.f7125B[i10];
            if (iVar != null) {
                iVar.w(fA);
                if (z11) {
                    this.f7125B[i10].C();
                }
            }
        }
        if (z11) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        c cVar = this.f7130b;
        if (cVar.f7170n != i10) {
            cVar.f7170n = i10;
            V();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f7130b.f7160d = colorFilter;
        V();
    }

    @Override // Z2.o
    public void setShapeAppearanceModel(l lVar) {
        c cVar = this.f7130b;
        cVar.f7157a = lVar;
        cVar.f7158b = null;
        this.f7126C = null;
        this.f7127D = null;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i10) {
        setTintList(ColorStateList.valueOf(i10));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f7130b.f7164h = colorStateList;
        u0();
        V();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        c cVar = this.f7130b;
        if (cVar.f7165i != mode) {
            cVar.f7165i = mode;
            u0();
            V();
        }
    }

    public final void t(Canvas canvas) {
        u(canvas, this.f7143o, this.f7137i, this.f7130b.f7157a, this.f7126C, x());
    }

    public final void t0() {
        this.f7154z = I().z(this.f7129a);
        float[] fArr = this.f7126C;
        if (fArr == null) {
            this.f7127D = null;
            return;
        }
        if (this.f7127D == null) {
            this.f7127D = new float[fArr.length];
        }
        float fK = K();
        int i10 = 0;
        while (true) {
            float[] fArr2 = this.f7126C;
            if (i10 >= fArr2.length) {
                return;
            }
            this.f7127D[i10] = Math.max(0.0f, fArr2[i10] - fK);
            i10++;
        }
    }

    public final void u(Canvas canvas, Paint paint, Path path, l lVar, float[] fArr, RectF rectF) {
        float fM = m(rectF, lVar, fArr);
        if (fM < 0.0f) {
            canvas.drawPath(path, paint);
        } else {
            float f10 = fM * this.f7130b.f7168l;
            canvas.drawRoundRect(rectF, f10, f10, paint);
        }
    }

    public final boolean u0() {
        PorterDuffColorFilter porterDuffColorFilter = this.f7148t;
        PorterDuffColorFilter porterDuffColorFilter2 = this.f7149u;
        c cVar = this.f7130b;
        this.f7148t = p(cVar.f7164h, cVar.f7165i, this.f7143o, true);
        c cVar2 = this.f7130b;
        this.f7149u = p(cVar2.f7163g, cVar2.f7165i, this.f7144p, false);
        c cVar3 = this.f7130b;
        if (cVar3.f7178v) {
            this.f7145q.d(cVar3.f7164h.getColorForState(getState(), 0));
        }
        return (B0.c.a(porterDuffColorFilter, this.f7148t) && B0.c.a(porterDuffColorFilter2, this.f7149u)) ? false : true;
    }

    public void v(Canvas canvas, Paint paint, Path path, RectF rectF) {
        u(canvas, paint, path, this.f7130b.f7157a, this.f7126C, rectF);
    }

    public final void v0() {
        float fQ = Q();
        this.f7130b.f7175s = (int) Math.ceil(0.75f * fQ);
        this.f7130b.f7176t = (int) Math.ceil(fQ * 0.25f);
        u0();
        V();
    }

    public void w(Canvas canvas) {
        u(canvas, this.f7144p, this.f7138j, this.f7154z, this.f7127D, y());
    }

    public RectF x() {
        this.f7139k.set(getBounds());
        return this.f7139k;
    }

    public final RectF y() {
        this.f7140l.set(x());
        float fK = K();
        this.f7140l.inset(fK, fK);
        return this.f7140l;
    }

    public float z() {
        float[] fArr = this.f7126C;
        if (fArr != null) {
            return (((fArr[3] + fArr[2]) - fArr[1]) - fArr[0]) / 2.0f;
        }
        RectF rectFX = x();
        return (((this.f7147s.h(3, I()).a(rectFX) + this.f7147s.h(2, I()).a(rectFX)) - this.f7147s.h(1, I()).a(rectFX)) - this.f7147s.h(0, I()).a(rectFX)) / 2.0f;
    }

    public h(Context context, AttributeSet attributeSet, int i10, int i11) {
        this(l.e(context, attributeSet, i10, i11).m());
    }

    public h(l lVar) {
        this(new c(lVar, null));
    }

    public h(c cVar) {
        m mVar;
        this.f7129a = new a();
        this.f7131c = new n.g[4];
        this.f7132d = new n.g[4];
        this.f7133e = new BitSet(8);
        this.f7136h = new Matrix();
        this.f7137i = new Path();
        this.f7138j = new Path();
        this.f7139k = new RectF();
        this.f7140l = new RectF();
        this.f7141m = new Region();
        this.f7142n = new Region();
        Paint paint = new Paint(1);
        this.f7143o = paint;
        Paint paint2 = new Paint(1);
        this.f7144p = paint2;
        this.f7145q = new Y2.a();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            mVar = m.l();
        } else {
            mVar = new m();
        }
        this.f7147s = mVar;
        this.f7151w = new RectF();
        this.f7152x = true;
        this.f7153y = true;
        this.f7125B = new androidx.dynamicanimation.animation.i[4];
        this.f7130b = cVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        u0();
        q0(getState());
        this.f7146r = new b();
    }

    public static class c extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        public l f7157a;

        /* renamed from: b, reason: collision with root package name */
        public s f7158b;

        /* renamed from: c, reason: collision with root package name */
        public P2.a f7159c;

        /* renamed from: d, reason: collision with root package name */
        public ColorFilter f7160d;

        /* renamed from: e, reason: collision with root package name */
        public ColorStateList f7161e;

        /* renamed from: f, reason: collision with root package name */
        public ColorStateList f7162f;

        /* renamed from: g, reason: collision with root package name */
        public ColorStateList f7163g;

        /* renamed from: h, reason: collision with root package name */
        public ColorStateList f7164h;

        /* renamed from: i, reason: collision with root package name */
        public PorterDuff.Mode f7165i;

        /* renamed from: j, reason: collision with root package name */
        public Rect f7166j;

        /* renamed from: k, reason: collision with root package name */
        public float f7167k;

        /* renamed from: l, reason: collision with root package name */
        public float f7168l;

        /* renamed from: m, reason: collision with root package name */
        public float f7169m;

        /* renamed from: n, reason: collision with root package name */
        public int f7170n;

        /* renamed from: o, reason: collision with root package name */
        public float f7171o;

        /* renamed from: p, reason: collision with root package name */
        public float f7172p;

        /* renamed from: q, reason: collision with root package name */
        public float f7173q;

        /* renamed from: r, reason: collision with root package name */
        public int f7174r;

        /* renamed from: s, reason: collision with root package name */
        public int f7175s;

        /* renamed from: t, reason: collision with root package name */
        public int f7176t;

        /* renamed from: u, reason: collision with root package name */
        public int f7177u;

        /* renamed from: v, reason: collision with root package name */
        public boolean f7178v;

        /* renamed from: w, reason: collision with root package name */
        public Paint.Style f7179w;

        public c(l lVar, P2.a aVar) {
            this.f7161e = null;
            this.f7162f = null;
            this.f7163g = null;
            this.f7164h = null;
            this.f7165i = PorterDuff.Mode.SRC_IN;
            this.f7166j = null;
            this.f7167k = 1.0f;
            this.f7168l = 1.0f;
            this.f7170n = 255;
            this.f7171o = 0.0f;
            this.f7172p = 0.0f;
            this.f7173q = 0.0f;
            this.f7174r = 0;
            this.f7175s = 0;
            this.f7176t = 0;
            this.f7177u = 0;
            this.f7178v = false;
            this.f7179w = Paint.Style.FILL_AND_STROKE;
            this.f7157a = lVar;
            this.f7159c = aVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            h hVar = new h(this);
            hVar.f7134f = true;
            hVar.f7135g = true;
            return hVar;
        }

        public c(c cVar) {
            this.f7161e = null;
            this.f7162f = null;
            this.f7163g = null;
            this.f7164h = null;
            this.f7165i = PorterDuff.Mode.SRC_IN;
            this.f7166j = null;
            this.f7167k = 1.0f;
            this.f7168l = 1.0f;
            this.f7170n = 255;
            this.f7171o = 0.0f;
            this.f7172p = 0.0f;
            this.f7173q = 0.0f;
            this.f7174r = 0;
            this.f7175s = 0;
            this.f7176t = 0;
            this.f7177u = 0;
            this.f7178v = false;
            this.f7179w = Paint.Style.FILL_AND_STROKE;
            this.f7157a = cVar.f7157a;
            this.f7158b = cVar.f7158b;
            this.f7159c = cVar.f7159c;
            this.f7169m = cVar.f7169m;
            this.f7160d = cVar.f7160d;
            this.f7161e = cVar.f7161e;
            this.f7162f = cVar.f7162f;
            this.f7165i = cVar.f7165i;
            this.f7164h = cVar.f7164h;
            this.f7170n = cVar.f7170n;
            this.f7167k = cVar.f7167k;
            this.f7176t = cVar.f7176t;
            this.f7174r = cVar.f7174r;
            this.f7178v = cVar.f7178v;
            this.f7168l = cVar.f7168l;
            this.f7171o = cVar.f7171o;
            this.f7172p = cVar.f7172p;
            this.f7173q = cVar.f7173q;
            this.f7175s = cVar.f7175s;
            this.f7177u = cVar.f7177u;
            this.f7163g = cVar.f7163g;
            this.f7179w = cVar.f7179w;
            if (cVar.f7166j != null) {
                this.f7166j = new Rect(cVar.f7166j);
            }
        }
    }
}
