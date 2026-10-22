package t1;

import a1.C0409b;
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
import j1.C0777a;
import java.util.BitSet;
import l1.C0831a;
import n1.C0873a;
import s1.C1047a;
import t1.l;
import t1.m;
import t1.n;

/* renamed from: t1.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1115h extends Drawable implements o {

    /* renamed from: F, reason: collision with root package name */
    private static final String f22322F = "h";

    /* renamed from: G, reason: collision with root package name */
    static final l f22323G = l.a().q(0, 0.0f).m();

    /* renamed from: H, reason: collision with root package name */
    private static final Paint f22324H;

    /* renamed from: I, reason: collision with root package name */
    private static final e[] f22325I;

    /* renamed from: A, reason: collision with root package name */
    private P.j f22326A;

    /* renamed from: B, reason: collision with root package name */
    P.i[] f22327B;

    /* renamed from: C, reason: collision with root package name */
    private float[] f22328C;

    /* renamed from: D, reason: collision with root package name */
    private float[] f22329D;

    /* renamed from: E, reason: collision with root package name */
    private d f22330E;

    /* renamed from: a, reason: collision with root package name */
    private final l.c f22331a;

    /* renamed from: b, reason: collision with root package name */
    private c f22332b;

    /* renamed from: c, reason: collision with root package name */
    private final n.g[] f22333c;

    /* renamed from: d, reason: collision with root package name */
    private final n.g[] f22334d;

    /* renamed from: e, reason: collision with root package name */
    private final BitSet f22335e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f22336f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f22337g;

    /* renamed from: h, reason: collision with root package name */
    private final Matrix f22338h;

    /* renamed from: i, reason: collision with root package name */
    private final Path f22339i;

    /* renamed from: j, reason: collision with root package name */
    private final Path f22340j;

    /* renamed from: k, reason: collision with root package name */
    private final RectF f22341k;

    /* renamed from: l, reason: collision with root package name */
    private final RectF f22342l;

    /* renamed from: m, reason: collision with root package name */
    private final Region f22343m;

    /* renamed from: n, reason: collision with root package name */
    private final Region f22344n;

    /* renamed from: o, reason: collision with root package name */
    private final Paint f22345o;

    /* renamed from: p, reason: collision with root package name */
    private final Paint f22346p;

    /* renamed from: q, reason: collision with root package name */
    private final C1047a f22347q;

    /* renamed from: r, reason: collision with root package name */
    private final m.b f22348r;

    /* renamed from: s, reason: collision with root package name */
    private final m f22349s;

    /* renamed from: t, reason: collision with root package name */
    private PorterDuffColorFilter f22350t;

    /* renamed from: u, reason: collision with root package name */
    private PorterDuffColorFilter f22351u;

    /* renamed from: v, reason: collision with root package name */
    private int f22352v;

    /* renamed from: w, reason: collision with root package name */
    private final RectF f22353w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f22354x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f22355y;

    /* renamed from: z, reason: collision with root package name */
    private l f22356z;

    /* renamed from: t1.h$a */
    class a implements l.c {
        a() {
        }

        @Override // t1.l.c
        public InterfaceC1111d a(InterfaceC1111d interfaceC1111d) {
            return interfaceC1111d instanceof j ? interfaceC1111d : new C1109b(-C1115h.this.K(), interfaceC1111d);
        }
    }

    /* renamed from: t1.h$b */
    class b implements m.b {
        b() {
        }

        @Override // t1.m.b
        public void a(n nVar, Matrix matrix, int i5) {
            C1115h.this.f22335e.set(i5, nVar.e());
            C1115h.this.f22333c[i5] = nVar.f(matrix);
        }

        @Override // t1.m.b
        public void b(n nVar, Matrix matrix, int i5) {
            C1115h.this.f22335e.set(i5 + 4, nVar.e());
            C1115h.this.f22334d[i5] = nVar.f(matrix);
        }
    }

    /* renamed from: t1.h$d */
    public interface d {
        void a(float f5);
    }

    /* renamed from: t1.h$e */
    private static class e extends P.f<C1115h> {

        /* renamed from: b, reason: collision with root package name */
        private final int f22382b;

        e(int i5) {
            super("cornerSizeAtIndex" + i5);
            this.f22382b = i5;
        }

        @Override // P.f
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(C1115h c1115h) {
            if (c1115h.f22328C != null) {
                return c1115h.f22328C[this.f22382b];
            }
            return 0.0f;
        }

        @Override // P.f
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(C1115h c1115h, float f5) {
            if (c1115h.f22328C == null || c1115h.f22328C[this.f22382b] == f5) {
                return;
            }
            c1115h.f22328C[this.f22382b] = f5;
            if (c1115h.f22330E != null) {
                c1115h.f22330E.a(c1115h.z());
            }
            c1115h.invalidateSelf();
        }
    }

    static {
        int i5 = 0;
        Paint paint = new Paint(1);
        f22324H = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        f22325I = new e[4];
        while (true) {
            e[] eVarArr = f22325I;
            if (i5 >= eVarArr.length) {
                return;
            }
            eVarArr[i5] = new e(i5);
            i5++;
        }
    }

    public C1115h() {
        this(new l());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float K() {
        if (T()) {
            return this.f22346p.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    private boolean R() {
        c cVar = this.f22332b;
        int i5 = cVar.f22376r;
        if (i5 == 1 || cVar.f22377s <= 0) {
            return false;
        }
        return i5 == 2 || b0();
    }

    private boolean S() {
        Paint.Style style = this.f22332b.f22381w;
        return style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL;
    }

    private boolean T() {
        Paint.Style style = this.f22332b.f22381w;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.f22346p.getStrokeWidth() > 0.0f;
    }

    private void V() {
        super.invalidateSelf();
    }

    private void Y(Canvas canvas) {
        if (R()) {
            canvas.save();
            a0(canvas);
            if (!this.f22354x) {
                s(canvas);
                canvas.restore();
                return;
            }
            int iWidth = (int) (this.f22353w.width() - getBounds().width());
            int iHeight = (int) (this.f22353w.height() - getBounds().height());
            if (iWidth < 0 || iHeight < 0) {
                throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(((int) this.f22353w.width()) + (this.f22332b.f22377s * 2) + iWidth, ((int) this.f22353w.height()) + (this.f22332b.f22377s * 2) + iHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(bitmapCreateBitmap);
            float f5 = (getBounds().left - this.f22332b.f22377s) - iWidth;
            float f6 = (getBounds().top - this.f22332b.f22377s) - iHeight;
            canvas2.translate(-f5, -f6);
            s(canvas2);
            canvas.drawBitmap(bitmapCreateBitmap, f5, f6, (Paint) null);
            bitmapCreateBitmap.recycle();
            canvas.restore();
        }
    }

    private static int Z(int i5, int i6) {
        return (i5 * (i6 + (i6 >>> 7))) >>> 8;
    }

    private void a0(Canvas canvas) {
        canvas.translate(F(), G());
    }

    private PorterDuffColorFilter j(Paint paint, boolean z5) {
        if (!z5) {
            return null;
        }
        int color = paint.getColor();
        int iQ = q(color);
        this.f22352v = iQ;
        if (iQ != color) {
            return new PorterDuffColorFilter(iQ, PorterDuff.Mode.SRC_IN);
        }
        return null;
    }

    private void k(RectF rectF, Path path) {
        l(rectF, path);
        if (this.f22332b.f22369k != 1.0f) {
            this.f22338h.reset();
            Matrix matrix = this.f22338h;
            float f5 = this.f22332b.f22369k;
            matrix.setScale(f5, f5, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.f22338h);
        }
        path.computeBounds(this.f22353w, true);
    }

    private float m(RectF rectF, l lVar, float[] fArr) {
        if (fArr == null) {
            if (lVar.v(rectF)) {
                return lVar.r().a(rectF);
            }
            return -1.0f;
        }
        if (C0873a.a(fArr) && lVar.u()) {
            return fArr[0];
        }
        return -1.0f;
    }

    private void n() {
        t0();
        this.f22349s.d(this.f22356z, this.f22329D, this.f22332b.f22370l, y(), null, this.f22340j);
    }

    private PorterDuffColorFilter o(ColorStateList colorStateList, PorterDuff.Mode mode, boolean z5) {
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z5) {
            colorForState = q(colorForState);
        }
        this.f22352v = colorForState;
        return new PorterDuffColorFilter(colorForState, mode);
    }

    private PorterDuffColorFilter p(ColorStateList colorStateList, PorterDuff.Mode mode, Paint paint, boolean z5) {
        return (colorStateList == null || mode == null) ? j(paint, z5) : o(colorStateList, mode, z5);
    }

    private boolean q0(int[] iArr) {
        boolean z5;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.f22332b.f22363e == null || color2 == (colorForState2 = this.f22332b.f22363e.getColorForState(iArr, (color2 = this.f22345o.getColor())))) {
            z5 = false;
        } else {
            this.f22345o.setColor(colorForState2);
            z5 = true;
        }
        if (this.f22332b.f22364f == null || color == (colorForState = this.f22332b.f22364f.getColorForState(iArr, (color = this.f22346p.getColor())))) {
            return z5;
        }
        this.f22346p.setColor(colorForState);
        return true;
    }

    public static C1115h r(Context context, float f5, ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(C0777a.c(context, C0409b.f6720g, C1115h.class.getSimpleName()));
        }
        C1115h c1115h = new C1115h();
        c1115h.U(context);
        c1115h.g0(colorStateList);
        c1115h.f0(f5);
        return c1115h;
    }

    private void r0(int[] iArr) {
        s0(iArr, false);
    }

    private void s(Canvas canvas) {
        if (this.f22335e.cardinality() > 0) {
            Log.w(f22322F, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        if (this.f22332b.f22378t != 0) {
            canvas.drawPath(this.f22339i, this.f22347q.c());
        }
        for (int i5 = 0; i5 < 4; i5++) {
            this.f22333c[i5].b(this.f22347q, this.f22332b.f22377s, canvas);
            this.f22334d[i5].b(this.f22347q, this.f22332b.f22377s, canvas);
        }
        if (this.f22354x) {
            int iF = F();
            int iG = G();
            canvas.translate(-iF, -iG);
            canvas.drawPath(this.f22339i, f22324H);
            canvas.translate(iF, iG);
        }
    }

    private void s0(int[] iArr, boolean z5) {
        RectF rectFX = x();
        if (this.f22332b.f22360b == null || rectFX.isEmpty()) {
            return;
        }
        boolean z6 = z5 | (this.f22326A == null);
        if (this.f22328C == null) {
            this.f22328C = new float[4];
        }
        l lVarD = this.f22332b.f22360b.d(iArr);
        for (int i5 = 0; i5 < 4; i5++) {
            float fA = this.f22349s.f(i5, lVarD).a(rectFX);
            if (z6) {
                this.f22328C[i5] = fA;
            }
            P.i iVar = this.f22327B[i5];
            if (iVar != null) {
                iVar.s(fA);
                if (z6) {
                    this.f22327B[i5].y();
                }
            }
        }
        if (z6) {
            invalidateSelf();
        }
    }

    private void t(Canvas canvas) {
        v(canvas, this.f22345o, this.f22339i, this.f22332b.f22359a, this.f22328C, x());
    }

    private void t0() {
        this.f22356z = I().z(this.f22331a);
        float[] fArr = this.f22328C;
        if (fArr == null) {
            this.f22329D = null;
            return;
        }
        if (this.f22329D == null) {
            this.f22329D = new float[fArr.length];
        }
        float fK = K();
        int i5 = 0;
        while (true) {
            float[] fArr2 = this.f22328C;
            if (i5 >= fArr2.length) {
                return;
            }
            this.f22329D[i5] = Math.max(0.0f, fArr2[i5] - fK);
            i5++;
        }
    }

    private boolean u0() {
        PorterDuffColorFilter porterDuffColorFilter = this.f22350t;
        PorterDuffColorFilter porterDuffColorFilter2 = this.f22351u;
        c cVar = this.f22332b;
        this.f22350t = p(cVar.f22366h, cVar.f22367i, this.f22345o, true);
        c cVar2 = this.f22332b;
        this.f22351u = p(cVar2.f22365g, cVar2.f22367i, this.f22346p, false);
        c cVar3 = this.f22332b;
        if (cVar3.f22380v) {
            this.f22347q.d(cVar3.f22366h.getColorForState(getState(), 0));
        }
        return (D.c.a(porterDuffColorFilter, this.f22350t) && D.c.a(porterDuffColorFilter2, this.f22351u)) ? false : true;
    }

    private void v(Canvas canvas, Paint paint, Path path, l lVar, float[] fArr, RectF rectF) {
        float fM = m(rectF, lVar, fArr);
        if (fM < 0.0f) {
            canvas.drawPath(path, paint);
        } else {
            float f5 = fM * this.f22332b.f22370l;
            canvas.drawRoundRect(rectF, f5, f5, paint);
        }
    }

    private void v0() {
        float fQ = Q();
        this.f22332b.f22377s = (int) Math.ceil(0.75f * fQ);
        this.f22332b.f22378t = (int) Math.ceil(fQ * 0.25f);
        u0();
        V();
    }

    private RectF y() {
        this.f22342l.set(x());
        float fK = K();
        this.f22342l.inset(fK, fK);
        return this.f22342l;
    }

    public float A() {
        return this.f22332b.f22374p;
    }

    public ColorStateList B() {
        return this.f22332b.f22363e;
    }

    public float C() {
        return this.f22332b.f22370l;
    }

    public float D() {
        return this.f22332b.f22373o;
    }

    public int E() {
        return this.f22352v;
    }

    public int F() {
        c cVar = this.f22332b;
        return (int) (cVar.f22378t * Math.sin(Math.toRadians(cVar.f22379u)));
    }

    public int G() {
        c cVar = this.f22332b;
        return (int) (cVar.f22378t * Math.cos(Math.toRadians(cVar.f22379u)));
    }

    public int H() {
        return this.f22332b.f22377s;
    }

    public l I() {
        return this.f22332b.f22359a;
    }

    public ColorStateList J() {
        return this.f22332b.f22364f;
    }

    public float L() {
        return this.f22332b.f22371m;
    }

    public ColorStateList M() {
        return this.f22332b.f22366h;
    }

    public float N() {
        float[] fArr = this.f22328C;
        return fArr != null ? fArr[3] : this.f22332b.f22359a.r().a(x());
    }

    public float O() {
        float[] fArr = this.f22328C;
        return fArr != null ? fArr[0] : this.f22332b.f22359a.t().a(x());
    }

    public float P() {
        return this.f22332b.f22375q;
    }

    public float Q() {
        return A() + P();
    }

    public void U(Context context) {
        this.f22332b.f22361c = new C0831a(context);
        v0();
    }

    public boolean W() {
        C0831a c0831a = this.f22332b.f22361c;
        return c0831a != null && c0831a.d();
    }

    public boolean X() {
        if (this.f22332b.f22359a.v(x())) {
            return true;
        }
        float[] fArr = this.f22328C;
        return fArr != null && C0873a.a(fArr) && this.f22332b.f22359a.u();
    }

    public boolean b0() {
        if (X()) {
            return false;
        }
        this.f22339i.isConvex();
        return false;
    }

    public void c0(float f5) {
        setShapeAppearanceModel(this.f22332b.f22359a.x(f5));
    }

    public void d0(InterfaceC1111d interfaceC1111d) {
        setShapeAppearanceModel(this.f22332b.f22359a.y(interfaceC1111d));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f22345o.setColorFilter(this.f22350t);
        int alpha = this.f22345o.getAlpha();
        this.f22345o.setAlpha(Z(alpha, this.f22332b.f22372n));
        this.f22346p.setColorFilter(this.f22351u);
        this.f22346p.setStrokeWidth(this.f22332b.f22371m);
        int alpha2 = this.f22346p.getAlpha();
        this.f22346p.setAlpha(Z(alpha2, this.f22332b.f22372n));
        if (S()) {
            if (this.f22336f) {
                k(x(), this.f22339i);
                this.f22336f = false;
            }
            Y(canvas);
            t(canvas);
        }
        if (T()) {
            if (this.f22337g) {
                n();
                this.f22337g = false;
            }
            w(canvas);
        }
        this.f22345o.setAlpha(alpha);
        this.f22346p.setAlpha(alpha2);
    }

    public void e0(P.j jVar) {
        if (this.f22326A == jVar) {
            return;
        }
        this.f22326A = jVar;
        int i5 = 0;
        while (true) {
            P.i[] iVarArr = this.f22327B;
            if (i5 >= iVarArr.length) {
                s0(getState(), true);
                invalidateSelf();
                return;
            } else {
                if (iVarArr[i5] == null) {
                    iVarArr[i5] = new P.i(this, f22325I[i5]);
                }
                this.f22327B[i5].x(new P.j().f(jVar.a()).h(jVar.c()));
                i5++;
            }
        }
    }

    public void f0(float f5) {
        c cVar = this.f22332b;
        if (cVar.f22374p != f5) {
            cVar.f22374p = f5;
            v0();
        }
    }

    public void g0(ColorStateList colorStateList) {
        c cVar = this.f22332b;
        if (cVar.f22363e != colorStateList) {
            cVar.f22363e = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f22332b.f22372n;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f22332b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.f22332b.f22376r == 2) {
            return;
        }
        RectF rectFX = x();
        if (rectFX.isEmpty()) {
            return;
        }
        float fM = m(rectFX, this.f22332b.f22359a, this.f22328C);
        if (fM >= 0.0f) {
            outline.setRoundRect(getBounds(), fM * this.f22332b.f22370l);
            return;
        }
        if (this.f22336f) {
            k(rectFX, this.f22339i);
            this.f22336f = false;
        }
        com.google.android.material.drawable.a.i(outline, this.f22339i);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        Rect rect2 = this.f22332b.f22368j;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        this.f22343m.set(getBounds());
        k(x(), this.f22339i);
        this.f22344n.setPath(this.f22339i, this.f22343m);
        this.f22343m.op(this.f22344n, Region.Op.DIFFERENCE);
        return this.f22343m;
    }

    public void h0(float f5) {
        c cVar = this.f22332b;
        if (cVar.f22370l != f5) {
            cVar.f22370l = f5;
            this.f22336f = true;
            this.f22337g = true;
            invalidateSelf();
        }
    }

    public void i0(d dVar) {
        this.f22330E = dVar;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.f22336f = true;
        this.f22337g = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (super.isStateful()) {
            return true;
        }
        ColorStateList colorStateList = this.f22332b.f22366h;
        if (colorStateList != null && colorStateList.isStateful()) {
            return true;
        }
        ColorStateList colorStateList2 = this.f22332b.f22365g;
        if (colorStateList2 != null && colorStateList2.isStateful()) {
            return true;
        }
        ColorStateList colorStateList3 = this.f22332b.f22364f;
        if (colorStateList3 != null && colorStateList3.isStateful()) {
            return true;
        }
        ColorStateList colorStateList4 = this.f22332b.f22363e;
        if (colorStateList4 != null && colorStateList4.isStateful()) {
            return true;
        }
        q qVar = this.f22332b.f22360b;
        return qVar != null && qVar.f();
    }

    public void j0(int i5, int i6, int i7, int i8) {
        c cVar = this.f22332b;
        if (cVar.f22368j == null) {
            cVar.f22368j = new Rect();
        }
        this.f22332b.f22368j.set(i5, i6, i7, i8);
        invalidateSelf();
    }

    public void k0(float f5) {
        c cVar = this.f22332b;
        if (cVar.f22373o != f5) {
            cVar.f22373o = f5;
            v0();
        }
    }

    protected final void l(RectF rectF, Path path) {
        m mVar = this.f22349s;
        c cVar = this.f22332b;
        mVar.d(cVar.f22359a, this.f22328C, cVar.f22370l, rectF, this.f22348r, path);
    }

    public void l0(q qVar) {
        c cVar = this.f22332b;
        if (cVar.f22360b != qVar) {
            cVar.f22360b = qVar;
            s0(getState(), true);
            invalidateSelf();
        }
    }

    public void m0(float f5, int i5) {
        p0(f5);
        o0(ColorStateList.valueOf(i5));
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f22332b = new c(this.f22332b);
        return this;
    }

    public void n0(float f5, ColorStateList colorStateList) {
        p0(f5);
        o0(colorStateList);
    }

    public void o0(ColorStateList colorStateList) {
        c cVar = this.f22332b;
        if (cVar.f22364f != colorStateList) {
            cVar.f22364f = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.f22336f = true;
        this.f22337g = true;
        super.onBoundsChange(rect);
        if (this.f22332b.f22360b != null && !rect.isEmpty()) {
            s0(getState(), this.f22355y);
        }
        this.f22355y = rect.isEmpty();
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.m.b
    protected boolean onStateChange(int[] iArr) {
        if (this.f22332b.f22360b != null) {
            r0(iArr);
        }
        boolean z5 = q0(iArr) || u0();
        if (z5) {
            invalidateSelf();
        }
        return z5;
    }

    public void p0(float f5) {
        this.f22332b.f22371m = f5;
        invalidateSelf();
    }

    protected int q(int i5) {
        float fQ = Q() + D();
        C0831a c0831a = this.f22332b.f22361c;
        return c0831a != null ? c0831a.c(i5, fQ) : i5;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i5) {
        c cVar = this.f22332b;
        if (cVar.f22372n != i5) {
            cVar.f22372n = i5;
            V();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f22332b.f22362d = colorFilter;
        V();
    }

    @Override // t1.o
    public void setShapeAppearanceModel(l lVar) {
        c cVar = this.f22332b;
        cVar.f22359a = lVar;
        cVar.f22360b = null;
        this.f22328C = null;
        this.f22329D = null;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i5) {
        setTintList(ColorStateList.valueOf(i5));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f22332b.f22366h = colorStateList;
        u0();
        V();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        c cVar = this.f22332b;
        if (cVar.f22367i != mode) {
            cVar.f22367i = mode;
            u0();
            V();
        }
    }

    protected void u(Canvas canvas, Paint paint, Path path, RectF rectF) {
        v(canvas, paint, path, this.f22332b.f22359a, this.f22328C, rectF);
    }

    protected void w(Canvas canvas) {
        v(canvas, this.f22346p, this.f22340j, this.f22356z, this.f22329D, y());
    }

    protected RectF x() {
        this.f22341k.set(getBounds());
        return this.f22341k;
    }

    public float z() {
        float[] fArr = this.f22328C;
        if (fArr != null) {
            return (((fArr[3] + fArr[2]) - fArr[1]) - fArr[0]) / 2.0f;
        }
        RectF rectFX = x();
        return (((this.f22349s.f(3, I()).a(rectFX) + this.f22349s.f(2, I()).a(rectFX)) - this.f22349s.f(1, I()).a(rectFX)) - this.f22349s.f(0, I()).a(rectFX)) / 2.0f;
    }

    public C1115h(Context context, AttributeSet attributeSet, int i5, int i6) {
        this(l.e(context, attributeSet, i5, i6).m());
    }

    public C1115h(l lVar) {
        this(new c(lVar, null));
    }

    protected C1115h(c cVar) {
        m mVar;
        this.f22331a = new a();
        this.f22333c = new n.g[4];
        this.f22334d = new n.g[4];
        this.f22335e = new BitSet(8);
        this.f22338h = new Matrix();
        this.f22339i = new Path();
        this.f22340j = new Path();
        this.f22341k = new RectF();
        this.f22342l = new RectF();
        this.f22343m = new Region();
        this.f22344n = new Region();
        Paint paint = new Paint(1);
        this.f22345o = paint;
        Paint paint2 = new Paint(1);
        this.f22346p = paint2;
        this.f22347q = new C1047a();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            mVar = m.j();
        } else {
            mVar = new m();
        }
        this.f22349s = mVar;
        this.f22353w = new RectF();
        this.f22354x = true;
        this.f22355y = true;
        this.f22327B = new P.i[4];
        this.f22332b = cVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        u0();
        q0(getState());
        this.f22348r = new b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: t1.h$c */
    public static class c extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        l f22359a;

        /* renamed from: b, reason: collision with root package name */
        q f22360b;

        /* renamed from: c, reason: collision with root package name */
        C0831a f22361c;

        /* renamed from: d, reason: collision with root package name */
        ColorFilter f22362d;

        /* renamed from: e, reason: collision with root package name */
        ColorStateList f22363e;

        /* renamed from: f, reason: collision with root package name */
        ColorStateList f22364f;

        /* renamed from: g, reason: collision with root package name */
        ColorStateList f22365g;

        /* renamed from: h, reason: collision with root package name */
        ColorStateList f22366h;

        /* renamed from: i, reason: collision with root package name */
        PorterDuff.Mode f22367i;

        /* renamed from: j, reason: collision with root package name */
        Rect f22368j;

        /* renamed from: k, reason: collision with root package name */
        float f22369k;

        /* renamed from: l, reason: collision with root package name */
        float f22370l;

        /* renamed from: m, reason: collision with root package name */
        float f22371m;

        /* renamed from: n, reason: collision with root package name */
        int f22372n;

        /* renamed from: o, reason: collision with root package name */
        float f22373o;

        /* renamed from: p, reason: collision with root package name */
        float f22374p;

        /* renamed from: q, reason: collision with root package name */
        float f22375q;

        /* renamed from: r, reason: collision with root package name */
        int f22376r;

        /* renamed from: s, reason: collision with root package name */
        int f22377s;

        /* renamed from: t, reason: collision with root package name */
        int f22378t;

        /* renamed from: u, reason: collision with root package name */
        int f22379u;

        /* renamed from: v, reason: collision with root package name */
        boolean f22380v;

        /* renamed from: w, reason: collision with root package name */
        Paint.Style f22381w;

        public c(l lVar, C0831a c0831a) {
            this.f22363e = null;
            this.f22364f = null;
            this.f22365g = null;
            this.f22366h = null;
            this.f22367i = PorterDuff.Mode.SRC_IN;
            this.f22368j = null;
            this.f22369k = 1.0f;
            this.f22370l = 1.0f;
            this.f22372n = 255;
            this.f22373o = 0.0f;
            this.f22374p = 0.0f;
            this.f22375q = 0.0f;
            this.f22376r = 0;
            this.f22377s = 0;
            this.f22378t = 0;
            this.f22379u = 0;
            this.f22380v = false;
            this.f22381w = Paint.Style.FILL_AND_STROKE;
            this.f22359a = lVar;
            this.f22361c = c0831a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            C1115h c1115h = new C1115h(this);
            c1115h.f22336f = true;
            c1115h.f22337g = true;
            return c1115h;
        }

        public c(c cVar) {
            this.f22363e = null;
            this.f22364f = null;
            this.f22365g = null;
            this.f22366h = null;
            this.f22367i = PorterDuff.Mode.SRC_IN;
            this.f22368j = null;
            this.f22369k = 1.0f;
            this.f22370l = 1.0f;
            this.f22372n = 255;
            this.f22373o = 0.0f;
            this.f22374p = 0.0f;
            this.f22375q = 0.0f;
            this.f22376r = 0;
            this.f22377s = 0;
            this.f22378t = 0;
            this.f22379u = 0;
            this.f22380v = false;
            this.f22381w = Paint.Style.FILL_AND_STROKE;
            this.f22359a = cVar.f22359a;
            this.f22360b = cVar.f22360b;
            this.f22361c = cVar.f22361c;
            this.f22371m = cVar.f22371m;
            this.f22362d = cVar.f22362d;
            this.f22363e = cVar.f22363e;
            this.f22364f = cVar.f22364f;
            this.f22367i = cVar.f22367i;
            this.f22366h = cVar.f22366h;
            this.f22372n = cVar.f22372n;
            this.f22369k = cVar.f22369k;
            this.f22378t = cVar.f22378t;
            this.f22376r = cVar.f22376r;
            this.f22380v = cVar.f22380v;
            this.f22370l = cVar.f22370l;
            this.f22373o = cVar.f22373o;
            this.f22374p = cVar.f22374p;
            this.f22375q = cVar.f22375q;
            this.f22377s = cVar.f22377s;
            this.f22379u = cVar.f22379u;
            this.f22365g = cVar.f22365g;
            this.f22381w = cVar.f22381w;
            if (cVar.f22368j != null) {
                this.f22368j = new Rect(cVar.f22368j);
            }
        }
    }
}
