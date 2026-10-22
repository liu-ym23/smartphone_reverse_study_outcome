package e3;

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
import android.util.StateSet;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.util.ObjectsCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import d3.C1376a;
import g1.AbstractC1451a;
import java.util.BitSet;

/* loaded from: classes3.dex */
public class k extends Drawable implements TintAwareDrawable, InterfaceC1407A {

    /* renamed from: F, reason: collision with root package name */
    public static final Paint f4350F;

    /* renamed from: G, reason: collision with root package name */
    public static final C1421j[] f4351G;

    /* renamed from: A, reason: collision with root package name */
    public SpringForce f4352A;

    /* renamed from: B, reason: collision with root package name */
    public final SpringAnimation[] f4353B;

    /* renamed from: C, reason: collision with root package name */
    public float[] f4354C;

    /* renamed from: D, reason: collision with root package name */
    public float[] f4355D;
    public InterfaceC1420i E;

    /* renamed from: a, reason: collision with root package name */
    public final a5.d f4356a;
    public C1419h b;
    public final y[] c;
    public final y[] d;
    public final BitSet e;
    public boolean f;
    public boolean g;
    public final Matrix h;
    public final Path i;

    /* renamed from: j, reason: collision with root package name */
    public final Path f4357j;
    public final RectF k;
    public final RectF l;
    public final Region m;
    public final Region n;
    public final Paint o;
    public final Paint p;

    /* renamed from: q, reason: collision with root package name */
    public final C1376a f4358q;

    /* renamed from: r, reason: collision with root package name */
    public final h2.d f4359r;

    /* renamed from: s, reason: collision with root package name */
    public final r f4360s;

    /* renamed from: t, reason: collision with root package name */
    public PorterDuffColorFilter f4361t;
    public PorterDuffColorFilter u;

    /* renamed from: v, reason: collision with root package name */
    public int f4362v;

    /* renamed from: w, reason: collision with root package name */
    public final RectF f4363w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f4364x;
    public boolean y;

    /* renamed from: z, reason: collision with root package name */
    public p f4365z;

    static {
        int i = 0;
        com.stepos.statsrpk.d dVarX = AbstractC1451a.x(0);
        o.b(dVarX);
        o.b(dVarX);
        o.b(dVarX);
        o.b(dVarX);
        Paint paint = new Paint(1);
        f4350F = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        f4351G = new C1421j[4];
        while (true) {
            C1421j[] c1421jArr = f4351G;
            if (i >= c1421jArr.length) {
                return;
            }
            c1421jArr[i] = new C1421j(i);
            i++;
        }
    }

    public k() {
        this(new p());
    }

    public static float c(RectF rectF, p pVar, float[] fArr) {
        if (fArr == null) {
            if (pVar.e(rectF)) {
                return pVar.e.a(rectF);
            }
            return -1.0f;
        }
        if (fArr.length > 1) {
            float f = fArr[0];
            for (int i = 1; i < fArr.length; i++) {
                if (fArr[i] != f) {
                    return -1.0f;
                }
            }
        }
        if (pVar.d()) {
            return fArr[0];
        }
        return -1.0f;
    }

    public void a() {
        invalidateSelf();
    }

    public final void b(RectF rectF, Path path) {
        C1419h c1419h = this.b;
        this.f4360s.a(c1419h.f4345a, this.f4354C, c1419h.f4346j, rectF, this.f4359r, path);
        if (this.b.i != 1.0f) {
            Matrix matrix = this.h;
            matrix.reset();
            float f = this.b.i;
            matrix.setScale(f, f, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(matrix);
        }
        path.computeBounds(this.f4363w, true);
    }

    public final int d(int i) {
        C1419h c1419h = this.b;
        float f = c1419h.n + 0.0f + c1419h.m;
        Z2.a aVar = c1419h.c;
        return aVar != null ? aVar.a(f, i) : i;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Paint paint;
        PorterDuffColorFilter porterDuffColorFilter = this.f4361t;
        Paint paint2 = this.o;
        paint2.setColorFilter(porterDuffColorFilter);
        int alpha = paint2.getAlpha();
        int i = this.b.l;
        paint2.setAlpha(((i + (i >>> 7)) * alpha) >>> 8);
        PorterDuffColorFilter porterDuffColorFilter2 = this.u;
        Paint paint3 = this.p;
        paint3.setColorFilter(porterDuffColorFilter2);
        paint3.setStrokeWidth(this.b.k);
        int alpha2 = paint3.getAlpha();
        int i6 = this.b.l;
        paint3.setAlpha(((i6 + (i6 >>> 7)) * alpha2) >>> 8);
        Paint.Style style = this.b.f4348r;
        if (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL) {
            boolean z10 = this.f;
            paint = paint2;
            Path path = this.i;
            if (z10) {
                b(h(), path);
                this.f = false;
            }
            C1419h c1419h = this.b;
            int i10 = c1419h.o;
            if (i10 != 1 && c1419h.p > 0) {
                if (i10 == 2) {
                    canvas.save();
                    double d = 0;
                    canvas.translate((int) (Math.sin(Math.toRadians(d)) * this.b.f4347q), (int) (Math.cos(Math.toRadians(d)) * this.b.f4347q));
                    if (this.f4364x) {
                        RectF rectF = this.f4363w;
                        int iWidth = (int) (rectF.width() - getBounds().width());
                        int iHeight = (int) (rectF.height() - getBounds().height());
                        if (iWidth < 0 || iHeight < 0) {
                            throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
                        }
                        Bitmap bitmapCreateBitmap = Bitmap.createBitmap((this.b.p * 2) + ((int) rectF.width()) + iWidth, (this.b.p * 2) + ((int) rectF.height()) + iHeight, Bitmap.Config.ARGB_8888);
                        Canvas canvas2 = new Canvas(bitmapCreateBitmap);
                        float f = (getBounds().left - this.b.p) - iWidth;
                        float f7 = (getBounds().top - this.b.p) - iHeight;
                        canvas2.translate(-f, -f7);
                        e(canvas2);
                        canvas.drawBitmap(bitmapCreateBitmap, f, f7, (Paint) null);
                        bitmapCreateBitmap.recycle();
                        canvas.restore();
                    } else {
                        e(canvas);
                        canvas.restore();
                    }
                } else if (!n()) {
                    path.isConvex();
                }
            }
            f(canvas, paint, path, this.b.f4345a, this.f4354C, h());
        } else {
            paint = paint2;
        }
        if (l()) {
            if (this.g) {
                p pVar = this.b.f4345a;
                o oVarF = pVar.f();
                InterfaceC1415d interfaceC1415d = pVar.e;
                a5.d dVar = this.f4356a;
                oVarF.e = dVar.d(interfaceC1415d);
                oVarF.f = dVar.d(pVar.f);
                oVarF.h = dVar.d(pVar.h);
                oVarF.g = dVar.d(pVar.g);
                this.f4365z = oVarF.a();
                float[] fArr = this.f4354C;
                if (fArr != null) {
                    if (this.f4355D == null) {
                        this.f4355D = new float[fArr.length];
                    }
                    float fJ = j();
                    int i11 = 0;
                    while (true) {
                        float[] fArr2 = this.f4354C;
                        if (i11 >= fArr2.length) {
                            break;
                        }
                        this.f4355D[i11] = Math.max(0.0f, fArr2[i11] - fJ);
                        i11++;
                    }
                } else {
                    this.f4355D = null;
                }
                p pVar2 = this.f4365z;
                float[] fArr3 = this.f4355D;
                float f9 = this.b.f4346j;
                RectF rectFH = h();
                RectF rectF2 = this.l;
                rectF2.set(rectFH);
                float fJ2 = j();
                rectF2.inset(fJ2, fJ2);
                this.f4360s.a(pVar2, fArr3, f9, rectF2, null, this.f4357j);
                this.g = false;
            }
            g(canvas);
        }
        paint.setAlpha(alpha);
        paint3.setAlpha(alpha2);
    }

    public final void e(Canvas canvas) {
        if (this.e.cardinality() > 0) {
            Log.w("k", "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        int i = this.b.f4347q;
        Path path = this.i;
        C1376a c1376a = this.f4358q;
        if (i != 0) {
            canvas.drawPath(path, c1376a.f4288a);
        }
        for (int i6 = 0; i6 < 4; i6++) {
            y yVar = this.c[i6];
            int i10 = this.b.p;
            Matrix matrix = y.b;
            yVar.a(matrix, c1376a, i10, canvas);
            this.d[i6].a(matrix, c1376a, this.b.p, canvas);
        }
        if (this.f4364x) {
            double d = 0;
            int iSin = (int) (Math.sin(Math.toRadians(d)) * this.b.f4347q);
            int iCos = (int) (Math.cos(Math.toRadians(d)) * this.b.f4347q);
            canvas.translate(-iSin, -iCos);
            canvas.drawPath(path, f4350F);
            canvas.translate(iSin, iCos);
        }
    }

    public final void f(Canvas canvas, Paint paint, Path path, p pVar, float[] fArr, RectF rectF) {
        float fC = c(rectF, pVar, fArr);
        if (fC < 0.0f) {
            canvas.drawPath(path, paint);
        } else {
            float f = fC * this.b.f4346j;
            canvas.drawRoundRect(rectF, f, f, paint);
        }
    }

    public void g(Canvas canvas) {
        p pVar = this.f4365z;
        float[] fArr = this.f4355D;
        RectF rectFH = h();
        RectF rectF = this.l;
        rectF.set(rectFH);
        float fJ = j();
        rectF.inset(fJ, fJ);
        f(canvas, this.p, this.f4357j, pVar, fArr, rectF);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.b.l;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.b.o == 2) {
            return;
        }
        RectF rectFH = h();
        if (rectFH.isEmpty()) {
            return;
        }
        float fC = c(rectFH, this.b.f4345a, this.f4354C);
        if (fC >= 0.0f) {
            outline.setRoundRect(getBounds(), fC * this.b.f4346j);
            return;
        }
        boolean z10 = this.f;
        Path path = this.i;
        if (z10) {
            b(rectFH, path);
            this.f = false;
        }
        Y2.a.a(outline, path);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        Rect rect2 = this.b.h;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final Region getTransparentRegion() {
        Rect bounds = getBounds();
        Region region = this.m;
        region.set(bounds);
        RectF rectFH = h();
        Path path = this.i;
        b(rectFH, path);
        Region region2 = this.n;
        region2.setPath(path, region);
        region.op(region2, Region.Op.DIFFERENCE);
        return region;
    }

    public final RectF h() {
        Rect bounds = getBounds();
        RectF rectF = this.k;
        rectF.set(bounds);
        return rectF;
    }

    public final float i() {
        float[] fArr = this.f4354C;
        if (fArr != null) {
            return (((fArr[3] + fArr[2]) - fArr[1]) - fArr[0]) / 2.0f;
        }
        RectF rectFH = h();
        p pVar = this.b.f4345a;
        r rVar = this.f4360s;
        rVar.getClass();
        float fA = pVar.e.a(rectFH);
        p pVar2 = this.b.f4345a;
        rVar.getClass();
        float fA2 = pVar2.h.a(rectFH) + fA;
        p pVar3 = this.b.f4345a;
        rVar.getClass();
        float fA3 = fA2 - pVar3.g.a(rectFH);
        p pVar4 = this.b.f4345a;
        rVar.getClass();
        return (fA3 - pVar4.f.a(rectFH)) / 2.0f;
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        this.f = true;
        this.g = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (super.isStateful()) {
            return true;
        }
        ColorStateList colorStateList = this.b.f;
        if (colorStateList != null && colorStateList.isStateful()) {
            return true;
        }
        this.b.getClass();
        ColorStateList colorStateList2 = this.b.e;
        if (colorStateList2 != null && colorStateList2.isStateful()) {
            return true;
        }
        ColorStateList colorStateList3 = this.b.d;
        if (colorStateList3 != null && colorStateList3.isStateful()) {
            return true;
        }
        C1409C c1409c = this.b.b;
        return c1409c != null && c1409c.d();
    }

    public final float j() {
        if (l()) {
            return this.p.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    public final float k() {
        float[] fArr = this.f4354C;
        return fArr != null ? fArr[3] : this.b.f4345a.e.a(h());
    }

    public final boolean l() {
        Paint.Style style = this.b.f4348r;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.p.getStrokeWidth() > 0.0f;
    }

    public final void m(Context context) {
        this.b.c = new Z2.a(context);
        z();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.b = new C1419h(this.b);
        return this;
    }

    public final boolean n() {
        if (!this.b.f4345a.e(h())) {
            float[] fArr = this.f4354C;
            if (fArr != null) {
                if (fArr.length > 1) {
                    float f = fArr[0];
                    for (int i = 1; i < fArr.length; i++) {
                        if (fArr[i] != f) {
                            break;
                        }
                    }
                }
                if (this.b.f4345a.d()) {
                }
            }
            return false;
        }
        return true;
    }

    public final void o(SpringForce springForce) {
        if (this.f4352A == springForce) {
            return;
        }
        this.f4352A = springForce;
        int i = 0;
        while (true) {
            SpringAnimation[] springAnimationArr = this.f4353B;
            if (i >= springAnimationArr.length) {
                x(true, getState());
                invalidateSelf();
                return;
            } else {
                if (springAnimationArr[i] == null) {
                    springAnimationArr[i] = new SpringAnimation(this, f4351G[i]);
                }
                springAnimationArr[i].setSpring(new SpringForce().setDampingRatio(springForce.getDampingRatio()).setStiffness(springForce.getStiffness()));
                i++;
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.f = true;
        this.g = true;
        super.onBoundsChange(rect);
        if (this.b.b != null && !rect.isEmpty()) {
            x(this.y, getState());
        }
        this.y = rect.isEmpty();
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.h
    public boolean onStateChange(int[] iArr) {
        if (this.b.b != null) {
            x(false, iArr);
        }
        boolean z10 = w(iArr) || y();
        if (z10) {
            invalidateSelf();
        }
        return z10;
    }

    public final void p(float f) {
        C1419h c1419h = this.b;
        if (c1419h.n != f) {
            c1419h.n = f;
            z();
        }
    }

    public final void q(ColorStateList colorStateList) {
        C1419h c1419h = this.b;
        if (c1419h.d != colorStateList) {
            c1419h.d = colorStateList;
            onStateChange(getState());
        }
    }

    public final void r(float f) {
        C1419h c1419h = this.b;
        if (c1419h.f4346j != f) {
            c1419h.f4346j = f;
            this.f = true;
            this.g = true;
            invalidateSelf();
        }
    }

    public final void s() {
        this.f4358q.a(-12303292);
        this.b.getClass();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        C1419h c1419h = this.b;
        if (c1419h.l != i) {
            c1419h.l = i;
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.b.getClass();
        super.invalidateSelf();
    }

    @Override // e3.InterfaceC1407A
    public final void setShapeAppearanceModel(p pVar) {
        C1419h c1419h = this.b;
        c1419h.f4345a = pVar;
        c1419h.b = null;
        this.f4354C = null;
        this.f4355D = null;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public final void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList colorStateList) {
        this.b.f = colorStateList;
        y();
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode mode) {
        C1419h c1419h = this.b;
        if (c1419h.g != mode) {
            c1419h.g = mode;
            y();
            super.invalidateSelf();
        }
    }

    public final void t() {
        C1419h c1419h = this.b;
        if (c1419h.o != 2) {
            c1419h.o = 2;
            super.invalidateSelf();
        }
    }

    public final void u(C1409C c1409c) {
        C1419h c1419h = this.b;
        if (c1419h.b != c1409c) {
            c1419h.b = c1409c;
            x(true, getState());
            invalidateSelf();
        }
    }

    public final void v(ColorStateList colorStateList) {
        C1419h c1419h = this.b;
        if (c1419h.e != colorStateList) {
            c1419h.e = colorStateList;
            onStateChange(getState());
        }
    }

    public final boolean w(int[] iArr) {
        boolean z10;
        Paint paint;
        int color;
        int colorForState;
        Paint paint2;
        int color2;
        int colorForState2;
        if (this.b.d == null || color2 == (colorForState2 = this.b.d.getColorForState(iArr, (color2 = (paint2 = this.o).getColor())))) {
            z10 = false;
        } else {
            paint2.setColor(colorForState2);
            z10 = true;
        }
        if (this.b.e == null || color == (colorForState = this.b.e.getColorForState(iArr, (color = (paint = this.p).getColor())))) {
            return z10;
        }
        paint.setColor(colorForState);
        return true;
    }

    public final void x(boolean z10, int[] iArr) {
        p pVarA;
        int i;
        RectF rectFH = h();
        if (this.b.b == null || rectFH.isEmpty()) {
            return;
        }
        boolean z11 = z10 | (this.f4352A == null);
        if (this.f4354C == null) {
            this.f4354C = new float[4];
        }
        C1409C c1409c = this.b.b;
        p[] pVarArr = c1409c.d;
        int i6 = c1409c.f4338a;
        int[][] iArr2 = c1409c.c;
        C1408B c1408b = c1409c.h;
        C1408B c1408b2 = c1409c.g;
        C1408B c1408b3 = c1409c.f;
        C1408B c1408b4 = c1409c.e;
        int i10 = 0;
        while (true) {
            if (i10 >= i6) {
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
                if (i11 >= i6) {
                    i = -1;
                    break;
                } else {
                    if (StateSet.stateSetMatches(iArr2[i11], iArr3)) {
                        i = i11;
                        break;
                    }
                    i11++;
                }
            }
            i10 = i;
        }
        if (c1408b4 == null && c1408b3 == null && c1408b2 == null && c1408b == null) {
            pVarA = pVarArr[i10];
        } else {
            o oVarF = pVarArr[i10].f();
            if (c1408b4 != null) {
                oVarF.e = c1408b4.c(iArr);
            }
            if (c1408b3 != null) {
                oVarF.f = c1408b3.c(iArr);
            }
            if (c1408b2 != null) {
                oVarF.h = c1408b2.c(iArr);
            }
            if (c1408b != null) {
                oVarF.g = c1408b.c(iArr);
            }
            pVarA = oVarF.a();
        }
        int i12 = 0;
        while (i12 < 4) {
            this.f4360s.getClass();
            float fA = (i12 != 1 ? i12 != 2 ? i12 != 3 ? pVarA.f : pVarA.e : pVarA.h : pVarA.g).a(rectFH);
            if (z11) {
                this.f4354C[i12] = fA;
            }
            SpringAnimation[] springAnimationArr = this.f4353B;
            SpringAnimation springAnimation = springAnimationArr[i12];
            if (springAnimation != null) {
                springAnimation.animateToFinalPosition(fA);
                if (z11) {
                    springAnimationArr[i12].skipToEnd();
                }
            }
            i12++;
        }
        if (z11) {
            invalidateSelf();
        }
    }

    public final boolean y() {
        PorterDuffColorFilter porterDuffColorFilter;
        PorterDuffColorFilter porterDuffColorFilter2 = this.f4361t;
        PorterDuffColorFilter porterDuffColorFilter3 = this.u;
        C1419h c1419h = this.b;
        ColorStateList colorStateList = c1419h.f;
        PorterDuff.Mode mode = c1419h.g;
        if (colorStateList == null || mode == null) {
            int color = this.o.getColor();
            int iD = d(color);
            this.f4362v = iD;
            porterDuffColorFilter = iD != color ? new PorterDuffColorFilter(iD, PorterDuff.Mode.SRC_IN) : null;
        } else {
            int iD2 = d(colorStateList.getColorForState(getState(), 0));
            this.f4362v = iD2;
            porterDuffColorFilter = new PorterDuffColorFilter(iD2, mode);
        }
        this.f4361t = porterDuffColorFilter;
        this.b.getClass();
        this.u = null;
        this.b.getClass();
        return (ObjectsCompat.equals(porterDuffColorFilter2, this.f4361t) && ObjectsCompat.equals(porterDuffColorFilter3, this.u)) ? false : true;
    }

    public final void z() {
        C1419h c1419h = this.b;
        float f = c1419h.n + 0.0f;
        c1419h.p = (int) Math.ceil(0.75f * f);
        this.b.f4347q = (int) Math.ceil(f * 0.25f);
        y();
        super.invalidateSelf();
    }

    public k(Context context, AttributeSet attributeSet, int i, int i6) {
        this(p.b(context, attributeSet, i, i6).a());
    }

    public k(p pVar) {
        this(new C1419h(pVar));
    }

    public k(C1419h c1419h) {
        r rVar;
        this.f4356a = new a5.d(this, 4);
        this.c = new y[4];
        this.d = new y[4];
        this.e = new BitSet(8);
        this.h = new Matrix();
        this.i = new Path();
        this.f4357j = new Path();
        this.k = new RectF();
        this.l = new RectF();
        this.m = new Region();
        this.n = new Region();
        Paint paint = new Paint(1);
        this.o = paint;
        Paint paint2 = new Paint(1);
        this.p = paint2;
        this.f4358q = new C1376a();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            rVar = q.f4371a;
        } else {
            rVar = new r();
        }
        this.f4360s = rVar;
        this.f4363w = new RectF();
        this.f4364x = true;
        this.y = true;
        this.f4353B = new SpringAnimation[4];
        this.b = c1419h;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        y();
        w(getState());
        this.f4359r = new h2.d(this);
    }
}
