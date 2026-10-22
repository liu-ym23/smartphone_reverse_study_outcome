package e2;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import com.stepos.core.ability.converter.BundleContentBridge;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import n0.d;
import o0.a;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f extends e2.e {

    /* renamed from: m, reason: collision with root package name */
    public static final PorterDuff.Mode f8539m = PorterDuff.Mode.SRC_IN;

    /* renamed from: b, reason: collision with root package name */
    public g f8540b;

    /* renamed from: c, reason: collision with root package name */
    public PorterDuffColorFilter f8541c;

    /* renamed from: d, reason: collision with root package name */
    public ColorFilter f8542d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f8543e;
    public boolean h;

    /* renamed from: j, reason: collision with root package name */
    public final float[] f8544j;

    /* renamed from: k, reason: collision with root package name */
    public final Matrix f8545k;

    /* renamed from: l, reason: collision with root package name */
    public final Rect f8546l;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a extends e {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class b extends e {

        /* renamed from: d, reason: collision with root package name */
        public m0.d f8547d;

        /* renamed from: f, reason: collision with root package name */
        public m0.d f8549f;

        /* renamed from: e, reason: collision with root package name */
        public float f8548e = 0.0f;

        /* renamed from: g, reason: collision with root package name */
        public float f8550g = 1.0f;
        public float h = 1.0f;

        /* renamed from: i, reason: collision with root package name */
        public float f8551i = 0.0f;

        /* renamed from: j, reason: collision with root package name */
        public float f8552j = 1.0f;

        /* renamed from: k, reason: collision with root package name */
        public float f8553k = 0.0f;

        /* renamed from: l, reason: collision with root package name */
        public Paint.Cap f8554l = Paint.Cap.BUTT;

        /* renamed from: m, reason: collision with root package name */
        public Paint.Join f8555m = Paint.Join.MITER;

        /* renamed from: n, reason: collision with root package name */
        public float f8556n = 4.0f;

        @Override // e2.f.d
        public final boolean a() {
            return this.f8549f.b() || this.f8547d.b();
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x001c  */
        @Override // e2.f.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final boolean b(int[] r6) {
            /*
                r5 = this;
                m0.d r0 = r5.f8549f
                boolean r1 = r0.b()
                r2 = 1
                r3 = 0
                if (r1 == 0) goto L1c
                android.content.res.ColorStateList r1 = r0.f10450b
                int r4 = r1.getDefaultColor()
                int r1 = r1.getColorForState(r6, r4)
                int r4 = r0.f10451c
                if (r1 == r4) goto L1c
                r0.f10451c = r1
                r0 = r2
                goto L1d
            L1c:
                r0 = r3
            L1d:
                m0.d r5 = r5.f8547d
                boolean r1 = r5.b()
                if (r1 == 0) goto L36
                android.content.res.ColorStateList r1 = r5.f10450b
                int r4 = r1.getDefaultColor()
                int r6 = r1.getColorForState(r6, r4)
                int r1 = r5.f10451c
                if (r6 == r1) goto L36
                r5.f10451c = r6
                goto L37
            L36:
                r2 = r3
            L37:
                r5 = r0 | r2
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: e2.f.b.b(int[]):boolean");
        }

        public float getFillAlpha() {
            return this.h;
        }

        public int getFillColor() {
            return this.f8549f.f10451c;
        }

        public float getStrokeAlpha() {
            return this.f8550g;
        }

        public int getStrokeColor() {
            return this.f8547d.f10451c;
        }

        public float getStrokeWidth() {
            return this.f8548e;
        }

        public float getTrimPathEnd() {
            return this.f8552j;
        }

        public float getTrimPathOffset() {
            return this.f8553k;
        }

        public float getTrimPathStart() {
            return this.f8551i;
        }

        public void setFillAlpha(float f8) {
            this.h = f8;
        }

        public void setFillColor(int i10) {
            this.f8549f.f10451c = i10;
        }

        public void setStrokeAlpha(float f8) {
            this.f8550g = f8;
        }

        public void setStrokeColor(int i10) {
            this.f8547d.f10451c = i10;
        }

        public void setStrokeWidth(float f8) {
            this.f8548e = f8;
        }

        public void setTrimPathEnd(float f8) {
            this.f8552j = f8;
        }

        public void setTrimPathOffset(float f8) {
            this.f8553k = f8;
        }

        public void setTrimPathStart(float f8) {
            this.f8551i = f8;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class d {
        public boolean a() {
            return false;
        }

        public boolean b(int[] iArr) {
            return false;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class g extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        public int f8585a;

        /* renamed from: b, reason: collision with root package name */
        public C0075f f8586b;

        /* renamed from: c, reason: collision with root package name */
        public ColorStateList f8587c;

        /* renamed from: d, reason: collision with root package name */
        public PorterDuff.Mode f8588d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f8589e;

        /* renamed from: f, reason: collision with root package name */
        public Bitmap f8590f;

        /* renamed from: g, reason: collision with root package name */
        public ColorStateList f8591g;
        public PorterDuff.Mode h;

        /* renamed from: i, reason: collision with root package name */
        public int f8592i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f8593j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f8594k;

        /* renamed from: l, reason: collision with root package name */
        public Paint f8595l;

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f8585a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable() {
            return new f(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable(Resources resources) {
            return new f(this);
        }
    }

    public f() {
        this.h = true;
        this.f8544j = new float[9];
        this.f8545k = new Matrix();
        this.f8546l = new Rect();
        g gVar = new g();
        gVar.f8587c = null;
        gVar.f8588d = f8539m;
        gVar.f8586b = new C0075f();
        this.f8540b = gVar;
    }

    public final PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        Drawable drawable = this.f8538a;
        if (drawable == null) {
            return false;
        }
        o0.a.b(drawable);
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Paint paint;
        Drawable drawable = this.f8538a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        Rect rect = this.f8546l;
        copyBounds(rect);
        if (rect.width() <= 0 || rect.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.f8542d;
        if (colorFilter == null) {
            colorFilter = this.f8541c;
        }
        Matrix matrix = this.f8545k;
        canvas.getMatrix(matrix);
        float[] fArr = this.f8544j;
        matrix.getValues(fArr);
        float fAbs = Math.abs(fArr[0]);
        float fAbs2 = Math.abs(fArr[4]);
        float fAbs3 = Math.abs(fArr[1]);
        float fAbs4 = Math.abs(fArr[3]);
        if (fAbs3 != 0.0f || fAbs4 != 0.0f) {
            fAbs = 1.0f;
            fAbs2 = 1.0f;
        }
        int iWidth = (int) (rect.width() * fAbs);
        int iMin = Math.min(2048, iWidth);
        int iMin2 = Math.min(2048, (int) (rect.height() * fAbs2));
        if (iMin <= 0 || iMin2 <= 0) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(rect.left, rect.top);
        if (isAutoMirrored() && getLayoutDirection() == 1) {
            canvas.translate(rect.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        rect.offsetTo(0, 0);
        g gVar = this.f8540b;
        Bitmap bitmap = gVar.f8590f;
        if (bitmap == null || iMin != bitmap.getWidth() || iMin2 != gVar.f8590f.getHeight()) {
            gVar.f8590f = Bitmap.createBitmap(iMin, iMin2, Bitmap.Config.ARGB_8888);
            gVar.f8594k = true;
        }
        if (this.h) {
            g gVar2 = this.f8540b;
            if (gVar2.f8594k || gVar2.f8591g != gVar2.f8587c || gVar2.h != gVar2.f8588d || gVar2.f8593j != gVar2.f8589e || gVar2.f8592i != gVar2.f8586b.getRootAlpha()) {
                g gVar3 = this.f8540b;
                gVar3.f8590f.eraseColor(0);
                Canvas canvas2 = new Canvas(gVar3.f8590f);
                C0075f c0075f = gVar3.f8586b;
                c0075f.a(c0075f.f8577g, C0075f.f8570p, canvas2, iMin, iMin2);
                g gVar4 = this.f8540b;
                gVar4.f8591g = gVar4.f8587c;
                gVar4.h = gVar4.f8588d;
                gVar4.f8592i = gVar4.f8586b.getRootAlpha();
                gVar4.f8593j = gVar4.f8589e;
                gVar4.f8594k = false;
            }
        } else {
            g gVar5 = this.f8540b;
            gVar5.f8590f.eraseColor(0);
            Canvas canvas3 = new Canvas(gVar5.f8590f);
            C0075f c0075f2 = gVar5.f8586b;
            c0075f2.a(c0075f2.f8577g, C0075f.f8570p, canvas3, iMin, iMin2);
        }
        g gVar6 = this.f8540b;
        if (gVar6.f8586b.getRootAlpha() >= 255 && colorFilter == null) {
            paint = null;
        } else {
            if (gVar6.f8595l == null) {
                Paint paint2 = new Paint();
                gVar6.f8595l = paint2;
                paint2.setFilterBitmap(true);
            }
            gVar6.f8595l.setAlpha(gVar6.f8586b.getRootAlpha());
            gVar6.f8595l.setColorFilter(colorFilter);
            paint = gVar6.f8595l;
        }
        canvas.drawBitmap(gVar6.f8590f, (Rect) null, rect, paint);
        canvas.restoreToCount(iSave);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        Drawable drawable = this.f8538a;
        return drawable != null ? o0.a.c(drawable) : this.f8540b.f8586b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        Drawable drawable = this.f8538a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return this.f8540b.getChangingConfigurations() | super.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        Drawable drawable = this.f8538a;
        return drawable != null ? a.C0115a.a(drawable) : this.f8542d;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.f8538a != null) {
            return new h(this.f8538a.getConstantState());
        }
        this.f8540b.f8585a = getChangingConfigurations();
        return this.f8540b;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        Drawable drawable = this.f8538a;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.f8540b.f8586b.f8578i;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        Drawable drawable = this.f8538a;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.f8540b.f8586b.h;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable drawable = this.f8538a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.f8538a;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        Drawable drawable = this.f8538a;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        Drawable drawable = this.f8538a;
        return drawable != null ? drawable.isAutoMirrored() : this.f8540b.f8589e;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        Drawable drawable = this.f8538a;
        if (drawable != null) {
            return drawable.isStateful();
        }
        if (super.isStateful()) {
            return true;
        }
        g gVar = this.f8540b;
        if (gVar == null) {
            return false;
        }
        C0075f c0075f = gVar.f8586b;
        if (c0075f.f8583n == null) {
            c0075f.f8583n = Boolean.valueOf(c0075f.f8577g.a());
        }
        if (c0075f.f8583n.booleanValue()) {
            return true;
        }
        ColorStateList colorStateList = this.f8540b.f8587c;
        return colorStateList != null && colorStateList.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        Drawable drawable = this.f8538a;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f8543e && super.mutate() == this) {
            g gVar = this.f8540b;
            g gVar2 = new g();
            gVar2.f8587c = null;
            gVar2.f8588d = f8539m;
            if (gVar != null) {
                gVar2.f8585a = gVar.f8585a;
                C0075f c0075f = new C0075f(gVar.f8586b);
                gVar2.f8586b = c0075f;
                if (gVar.f8586b.f8575e != null) {
                    c0075f.f8575e = new Paint(gVar.f8586b.f8575e);
                }
                if (gVar.f8586b.f8574d != null) {
                    gVar2.f8586b.f8574d = new Paint(gVar.f8586b.f8574d);
                }
                gVar2.f8587c = gVar.f8587c;
                gVar2.f8588d = gVar.f8588d;
                gVar2.f8589e = gVar.f8589e;
            }
            this.f8540b = gVar2;
            this.f8543e = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.f8538a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        boolean z;
        PorterDuff.Mode mode;
        Drawable drawable = this.f8538a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        g gVar = this.f8540b;
        ColorStateList colorStateList = gVar.f8587c;
        if (colorStateList == null || (mode = gVar.f8588d) == null) {
            z = false;
        } else {
            this.f8541c = a(colorStateList, mode);
            invalidateSelf();
            z = true;
        }
        C0075f c0075f = gVar.f8586b;
        if (c0075f.f8583n == null) {
            c0075f.f8583n = Boolean.valueOf(c0075f.f8577g.a());
        }
        if (c0075f.f8583n.booleanValue()) {
            boolean zB = gVar.f8586b.f8577g.b(iArr);
            gVar.f8594k |= zB;
            if (zB) {
                invalidateSelf();
                return true;
            }
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public final void scheduleSelf(Runnable runnable, long j10) {
        Drawable drawable = this.f8538a;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j10);
        } else {
            super.scheduleSelf(runnable, j10);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i10) {
        Drawable drawable = this.f8538a;
        if (drawable != null) {
            drawable.setAlpha(i10);
        } else if (this.f8540b.f8586b.getRootAlpha() != i10) {
            this.f8540b.f8586b.setRootAlpha(i10);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z) {
        Drawable drawable = this.f8538a;
        if (drawable != null) {
            o0.a.e(drawable, z);
        } else {
            this.f8540b.f8589e = z;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f8538a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f8542d = colorFilter;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i10) {
        Drawable drawable = this.f8538a;
        if (drawable != null) {
            o0.a.h(drawable, i10);
        } else {
            setTintList(ColorStateList.valueOf(i10));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f8538a;
        if (drawable != null) {
            drawable.setTintList(colorStateList);
            return;
        }
        g gVar = this.f8540b;
        if (gVar.f8587c != colorStateList) {
            gVar.f8587c = colorStateList;
            this.f8541c = a(colorStateList, gVar.f8588d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f8538a;
        if (drawable != null) {
            drawable.setTintMode(mode);
            return;
        }
        g gVar = this.f8540b;
        if (gVar.f8588d != mode) {
            gVar.f8588d = mode;
            this.f8541c = a(gVar.f8587c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z3) {
        Drawable drawable = this.f8538a;
        return drawable != null ? drawable.setVisible(z, z3) : super.setVisible(z, z3);
    }

    @Override // android.graphics.drawable.Drawable
    public final void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f8538a;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class h extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        public final Drawable.ConstantState f8596a;

        public h(Drawable.ConstantState constantState) {
            this.f8596a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final boolean canApplyTheme() {
            return this.f8596a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f8596a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable() {
            f fVar = new f();
            fVar.f8538a = (VectorDrawable) this.f8596a.newDrawable();
            return fVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable(Resources resources) {
            f fVar = new f();
            fVar.f8538a = (VectorDrawable) this.f8596a.newDrawable(resources);
            return fVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable(Resources resources, Resources.Theme theme) {
            f fVar = new f();
            fVar.f8538a = (VectorDrawable) this.f8596a.newDrawable(resources, theme);
            return fVar;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class e extends d {

        /* renamed from: a, reason: collision with root package name */
        public d.a[] f8567a;

        /* renamed from: b, reason: collision with root package name */
        public String f8568b;

        /* renamed from: c, reason: collision with root package name */
        public int f8569c;

        public e() {
            this.f8567a = null;
            this.f8569c = 0;
        }

        public d.a[] getPathData() {
            return this.f8567a;
        }

        public String getPathName() {
            return this.f8568b;
        }

        public void setPathData(d.a[] aVarArr) {
            d.a[] aVarArr2 = this.f8567a;
            boolean z = false;
            if (aVarArr2 != null && aVarArr != null && aVarArr2.length == aVarArr.length) {
                int i10 = 0;
                while (true) {
                    if (i10 >= aVarArr2.length) {
                        z = true;
                        break;
                    }
                    d.a aVar = aVarArr2[i10];
                    char c9 = aVar.f10593a;
                    d.a aVar2 = aVarArr[i10];
                    if (c9 != aVar2.f10593a || aVar.f10594b.length != aVar2.f10594b.length) {
                        break;
                    } else {
                        i10++;
                    }
                }
            }
            if (!z) {
                this.f8567a = n0.d.c(aVarArr);
                return;
            }
            d.a[] aVarArr3 = this.f8567a;
            for (int i11 = 0; i11 < aVarArr.length; i11++) {
                aVarArr3[i11].f10593a = aVarArr[i11].f10593a;
                int i12 = 0;
                while (true) {
                    float[] fArr = aVarArr[i11].f10594b;
                    if (i12 < fArr.length) {
                        aVarArr3[i11].f10594b[i12] = fArr[i12];
                        i12++;
                    }
                }
            }
        }

        public e(e eVar) {
            this.f8567a = null;
            this.f8569c = 0;
            this.f8568b = eVar.f8568b;
            this.f8567a = n0.d.c(eVar.f8567a);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int i10;
        int i11;
        boolean z;
        int i12;
        Paint.Cap cap;
        Paint.Join join;
        Drawable drawable = this.f8538a;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
            return;
        }
        g gVar = this.f8540b;
        gVar.f8586b = new C0075f();
        TypedArray typedArrayD = m0.g.d(resources, theme, attributeSet, e2.a.f8520a);
        g gVar2 = this.f8540b;
        C0075f c0075f = gVar2.f8586b;
        int i13 = !m0.g.c(xmlPullParser, "tintMode") ? -1 : typedArrayD.getInt(6, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        if (i13 == 3) {
            mode = PorterDuff.Mode.SRC_OVER;
        } else if (i13 != 5) {
            if (i13 != 9) {
                switch (i13) {
                    case 14:
                        mode = PorterDuff.Mode.MULTIPLY;
                        break;
                    case 15:
                        mode = PorterDuff.Mode.SCREEN;
                        break;
                    case 16:
                        mode = PorterDuff.Mode.ADD;
                        break;
                }
            } else {
                mode = PorterDuff.Mode.SRC_ATOP;
            }
        }
        gVar2.f8588d = mode;
        ColorStateList colorStateListA = null;
        boolean z3 = false;
        int i14 = 1;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "tint") != null) {
            TypedValue typedValue = new TypedValue();
            typedArrayD.getValue(1, typedValue);
            int i15 = typedValue.type;
            if (i15 == 2) {
                throw new UnsupportedOperationException("Failed to resolve attribute at index 1: " + typedValue);
            }
            if (i15 >= 28 && i15 <= 31) {
                colorStateListA = ColorStateList.valueOf(typedValue.data);
            } else {
                Resources resources2 = typedArrayD.getResources();
                int resourceId = typedArrayD.getResourceId(1, 0);
                ThreadLocal<TypedValue> threadLocal = m0.c.f10448a;
                try {
                    colorStateListA = m0.c.a(resources2, resources2.getXml(resourceId), theme);
                } catch (Exception e10) {
                    Log.e("CSLCompat", "Failed to inflate ColorStateList.", e10);
                }
            }
        }
        ColorStateList colorStateList = colorStateListA;
        if (colorStateList != null) {
            gVar2.f8587c = colorStateList;
        }
        boolean z10 = gVar2.f8589e;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "autoMirrored") != null) {
            z10 = typedArrayD.getBoolean(5, z10);
        }
        gVar2.f8589e = z10;
        float f8 = c0075f.f8579j;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "viewportWidth") != null) {
            f8 = typedArrayD.getFloat(7, f8);
        }
        c0075f.f8579j = f8;
        float f9 = c0075f.f8580k;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "viewportHeight") != null) {
            f9 = typedArrayD.getFloat(8, f9);
        }
        c0075f.f8580k = f9;
        if (c0075f.f8579j <= 0.0f) {
            throw new XmlPullParserException(typedArrayD.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (f9 > 0.0f) {
            c0075f.h = typedArrayD.getDimension(3, c0075f.h);
            float dimension = typedArrayD.getDimension(2, c0075f.f8578i);
            c0075f.f8578i = dimension;
            if (c0075f.h <= 0.0f) {
                throw new XmlPullParserException(typedArrayD.getPositionDescription() + "<vector> tag requires width > 0");
            }
            if (dimension > 0.0f) {
                float alpha = c0075f.getAlpha();
                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "alpha") != null) {
                    alpha = typedArrayD.getFloat(4, alpha);
                }
                c0075f.setAlpha(alpha);
                String string = typedArrayD.getString(0);
                if (string != null) {
                    c0075f.f8582m = string;
                    c0075f.f8584o.put(string, c0075f);
                }
                typedArrayD.recycle();
                gVar.f8585a = getChangingConfigurations();
                gVar.f8594k = true;
                g gVar3 = this.f8540b;
                C0075f c0075f2 = gVar3.f8586b;
                ArrayDeque arrayDeque = new ArrayDeque();
                c cVar = c0075f2.f8577g;
                p.a<String, Object> aVar = c0075f2.f8584o;
                arrayDeque.push(cVar);
                int eventType = xmlPullParser.getEventType();
                int depth = xmlPullParser.getDepth() + 1;
                boolean z11 = true;
                while (eventType != i14 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
                    if (eventType == 2) {
                        String name = xmlPullParser.getName();
                        c cVar2 = (c) arrayDeque.peek();
                        if (BundleContentBridge.KEY_PATH.equals(name)) {
                            b bVar = new b();
                            TypedArray typedArrayD2 = m0.g.d(resources, theme, attributeSet, e2.a.f8522c);
                            if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "pathData") != null) {
                                i11 = depth;
                                String string2 = typedArrayD2.getString(0);
                                if (string2 != null) {
                                    bVar.f8568b = string2;
                                }
                                String string3 = typedArrayD2.getString(2);
                                if (string3 != null) {
                                    bVar.f8567a = n0.d.b(string3);
                                }
                                bVar.f8549f = m0.g.b(typedArrayD2, xmlPullParser, theme, "fillColor", 1);
                                float f10 = bVar.h;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "fillAlpha") != null) {
                                    f10 = typedArrayD2.getFloat(12, f10);
                                }
                                bVar.h = f10;
                                int i16 = xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeLineCap") != null ? typedArrayD2.getInt(8, -1) : -1;
                                Paint.Cap cap2 = bVar.f8554l;
                                if (i16 == 0) {
                                    cap = Paint.Cap.BUTT;
                                } else if (i16 != 1) {
                                    cap = i16 != 2 ? cap2 : Paint.Cap.SQUARE;
                                } else {
                                    cap = Paint.Cap.ROUND;
                                }
                                bVar.f8554l = cap;
                                int i17 = xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeLineJoin") != null ? typedArrayD2.getInt(9, -1) : -1;
                                Paint.Join join2 = bVar.f8555m;
                                if (i17 == 0) {
                                    join = Paint.Join.MITER;
                                } else if (i17 != 1) {
                                    join = i17 != 2 ? join2 : Paint.Join.BEVEL;
                                } else {
                                    join = Paint.Join.ROUND;
                                }
                                bVar.f8555m = join;
                                float f11 = bVar.f8556n;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeMiterLimit") != null) {
                                    f11 = typedArrayD2.getFloat(10, f11);
                                }
                                bVar.f8556n = f11;
                                bVar.f8547d = m0.g.b(typedArrayD2, xmlPullParser, theme, "strokeColor", 3);
                                float f12 = bVar.f8550g;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeAlpha") != null) {
                                    f12 = typedArrayD2.getFloat(11, f12);
                                }
                                bVar.f8550g = f12;
                                float f13 = bVar.f8548e;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeWidth") != null) {
                                    f13 = typedArrayD2.getFloat(4, f13);
                                }
                                bVar.f8548e = f13;
                                float f14 = bVar.f8552j;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "trimPathEnd") != null) {
                                    f14 = typedArrayD2.getFloat(6, f14);
                                }
                                bVar.f8552j = f14;
                                float f15 = bVar.f8553k;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "trimPathOffset") != null) {
                                    f15 = typedArrayD2.getFloat(7, f15);
                                }
                                bVar.f8553k = f15;
                                float f16 = bVar.f8551i;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "trimPathStart") != null) {
                                    f16 = typedArrayD2.getFloat(5, f16);
                                }
                                bVar.f8551i = f16;
                                int i18 = bVar.f8569c;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "fillType") != null) {
                                    i18 = typedArrayD2.getInt(13, i18);
                                }
                                bVar.f8569c = i18;
                            } else {
                                i11 = depth;
                            }
                            typedArrayD2.recycle();
                            cVar2.f8558b.add(bVar);
                            if (bVar.getPathName() != null) {
                                aVar.put(bVar.getPathName(), bVar);
                            }
                            gVar3.f8585a = gVar3.f8585a;
                            z = false;
                            i12 = 1;
                            z11 = false;
                        } else {
                            i11 = depth;
                            if ("clip-path".equals(name)) {
                                a aVar2 = new a();
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "pathData") != null) {
                                    TypedArray typedArrayD3 = m0.g.d(resources, theme, attributeSet, e2.a.f8523d);
                                    String string4 = typedArrayD3.getString(0);
                                    if (string4 != null) {
                                        aVar2.f8568b = string4;
                                    }
                                    String string5 = typedArrayD3.getString(1);
                                    if (string5 != null) {
                                        aVar2.f8567a = n0.d.b(string5);
                                    }
                                    aVar2.f8569c = !m0.g.c(xmlPullParser, "fillType") ? 0 : typedArrayD3.getInt(2, 0);
                                    typedArrayD3.recycle();
                                }
                                cVar2.f8558b.add(aVar2);
                                if (aVar2.getPathName() != null) {
                                    aVar.put(aVar2.getPathName(), aVar2);
                                }
                                gVar3.f8585a = gVar3.f8585a;
                            } else if ("group".equals(name)) {
                                c cVar3 = new c();
                                TypedArray typedArrayD4 = m0.g.d(resources, theme, attributeSet, e2.a.f8521b);
                                float f17 = cVar3.f8559c;
                                if (m0.g.c(xmlPullParser, "rotation")) {
                                    f17 = typedArrayD4.getFloat(5, f17);
                                }
                                cVar3.f8559c = f17;
                                i12 = 1;
                                cVar3.f8560d = typedArrayD4.getFloat(1, cVar3.f8560d);
                                cVar3.f8561e = typedArrayD4.getFloat(2, cVar3.f8561e);
                                float f18 = cVar3.f8562f;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "scaleX") != null) {
                                    f18 = typedArrayD4.getFloat(3, f18);
                                }
                                cVar3.f8562f = f18;
                                float f19 = cVar3.f8563g;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "scaleY") != null) {
                                    f19 = typedArrayD4.getFloat(4, f19);
                                }
                                cVar3.f8563g = f19;
                                float f20 = cVar3.h;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "translateX") != null) {
                                    f20 = typedArrayD4.getFloat(6, f20);
                                }
                                cVar3.h = f20;
                                float f21 = cVar3.f8564i;
                                if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "translateY") != null) {
                                    f21 = typedArrayD4.getFloat(7, f21);
                                }
                                cVar3.f8564i = f21;
                                z = false;
                                String string6 = typedArrayD4.getString(0);
                                if (string6 != null) {
                                    cVar3.f8566k = string6;
                                }
                                cVar3.c();
                                typedArrayD4.recycle();
                                cVar2.f8558b.add(cVar3);
                                arrayDeque.push(cVar3);
                                if (cVar3.getGroupName() != null) {
                                    aVar.put(cVar3.getGroupName(), cVar3);
                                }
                                gVar3.f8585a = gVar3.f8585a;
                            }
                            z = false;
                            i12 = 1;
                        }
                        i10 = i12;
                    } else {
                        i10 = i14;
                        i11 = depth;
                        z = z3;
                        if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                            arrayDeque.pop();
                        }
                    }
                    eventType = xmlPullParser.next();
                    z3 = z;
                    i14 = i10;
                    depth = i11;
                }
                if (!z11) {
                    this.f8541c = a(gVar.f8587c, gVar.f8588d);
                    return;
                }
                throw new XmlPullParserException("no path defined");
            }
            throw new XmlPullParserException(typedArrayD.getPositionDescription() + "<vector> tag requires height > 0");
        }
        throw new XmlPullParserException(typedArrayD.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class c extends d {

        /* renamed from: a, reason: collision with root package name */
        public final Matrix f8557a;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList<d> f8558b;

        /* renamed from: c, reason: collision with root package name */
        public float f8559c;

        /* renamed from: d, reason: collision with root package name */
        public float f8560d;

        /* renamed from: e, reason: collision with root package name */
        public float f8561e;

        /* renamed from: f, reason: collision with root package name */
        public float f8562f;

        /* renamed from: g, reason: collision with root package name */
        public float f8563g;
        public float h;

        /* renamed from: i, reason: collision with root package name */
        public float f8564i;

        /* renamed from: j, reason: collision with root package name */
        public final Matrix f8565j;

        /* renamed from: k, reason: collision with root package name */
        public String f8566k;

        public c() {
            this.f8557a = new Matrix();
            this.f8558b = new ArrayList<>();
            this.f8559c = 0.0f;
            this.f8560d = 0.0f;
            this.f8561e = 0.0f;
            this.f8562f = 1.0f;
            this.f8563g = 1.0f;
            this.h = 0.0f;
            this.f8564i = 0.0f;
            this.f8565j = new Matrix();
            this.f8566k = null;
        }

        @Override // e2.f.d
        public final boolean a() {
            int i10 = 0;
            while (true) {
                ArrayList<d> arrayList = this.f8558b;
                if (i10 >= arrayList.size()) {
                    return false;
                }
                if (arrayList.get(i10).a()) {
                    return true;
                }
                i10++;
            }
        }

        @Override // e2.f.d
        public final boolean b(int[] iArr) {
            int i10 = 0;
            boolean zB = false;
            while (true) {
                ArrayList<d> arrayList = this.f8558b;
                if (i10 >= arrayList.size()) {
                    return zB;
                }
                zB |= arrayList.get(i10).b(iArr);
                i10++;
            }
        }

        public final void c() {
            Matrix matrix = this.f8565j;
            matrix.reset();
            matrix.postTranslate(-this.f8560d, -this.f8561e);
            matrix.postScale(this.f8562f, this.f8563g);
            matrix.postRotate(this.f8559c, 0.0f, 0.0f);
            matrix.postTranslate(this.h + this.f8560d, this.f8564i + this.f8561e);
        }

        public String getGroupName() {
            return this.f8566k;
        }

        public Matrix getLocalMatrix() {
            return this.f8565j;
        }

        public float getPivotX() {
            return this.f8560d;
        }

        public float getPivotY() {
            return this.f8561e;
        }

        public float getRotation() {
            return this.f8559c;
        }

        public float getScaleX() {
            return this.f8562f;
        }

        public float getScaleY() {
            return this.f8563g;
        }

        public float getTranslateX() {
            return this.h;
        }

        public float getTranslateY() {
            return this.f8564i;
        }

        public void setPivotX(float f8) {
            if (f8 != this.f8560d) {
                this.f8560d = f8;
                c();
            }
        }

        public void setPivotY(float f8) {
            if (f8 != this.f8561e) {
                this.f8561e = f8;
                c();
            }
        }

        public void setRotation(float f8) {
            if (f8 != this.f8559c) {
                this.f8559c = f8;
                c();
            }
        }

        public void setScaleX(float f8) {
            if (f8 != this.f8562f) {
                this.f8562f = f8;
                c();
            }
        }

        public void setScaleY(float f8) {
            if (f8 != this.f8563g) {
                this.f8563g = f8;
                c();
            }
        }

        public void setTranslateX(float f8) {
            if (f8 != this.h) {
                this.h = f8;
                c();
            }
        }

        public void setTranslateY(float f8) {
            if (f8 != this.f8564i) {
                this.f8564i = f8;
                c();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(c cVar, p.a<String, Object> aVar) {
            a aVar2;
            this.f8557a = new Matrix();
            this.f8558b = new ArrayList<>();
            this.f8559c = 0.0f;
            this.f8560d = 0.0f;
            this.f8561e = 0.0f;
            this.f8562f = 1.0f;
            this.f8563g = 1.0f;
            this.h = 0.0f;
            this.f8564i = 0.0f;
            Matrix matrix = new Matrix();
            this.f8565j = matrix;
            this.f8566k = null;
            this.f8559c = cVar.f8559c;
            this.f8560d = cVar.f8560d;
            this.f8561e = cVar.f8561e;
            this.f8562f = cVar.f8562f;
            this.f8563g = cVar.f8563g;
            this.h = cVar.h;
            this.f8564i = cVar.f8564i;
            String str = cVar.f8566k;
            this.f8566k = str;
            if (str != null) {
                aVar.put(str, this);
            }
            matrix.set(cVar.f8565j);
            ArrayList<d> arrayList = cVar.f8558b;
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                d dVar = arrayList.get(i10);
                if (dVar instanceof c) {
                    this.f8558b.add(new c((c) dVar, aVar));
                } else {
                    if (dVar instanceof b) {
                        b bVar = (b) dVar;
                        b bVar2 = new b(bVar);
                        bVar2.f8548e = 0.0f;
                        bVar2.f8550g = 1.0f;
                        bVar2.h = 1.0f;
                        bVar2.f8551i = 0.0f;
                        bVar2.f8552j = 1.0f;
                        bVar2.f8553k = 0.0f;
                        bVar2.f8554l = Paint.Cap.BUTT;
                        bVar2.f8555m = Paint.Join.MITER;
                        bVar2.f8556n = 4.0f;
                        bVar2.f8547d = bVar.f8547d;
                        bVar2.f8548e = bVar.f8548e;
                        bVar2.f8550g = bVar.f8550g;
                        bVar2.f8549f = bVar.f8549f;
                        bVar2.f8569c = bVar.f8569c;
                        bVar2.h = bVar.h;
                        bVar2.f8551i = bVar.f8551i;
                        bVar2.f8552j = bVar.f8552j;
                        bVar2.f8553k = bVar.f8553k;
                        bVar2.f8554l = bVar.f8554l;
                        bVar2.f8555m = bVar.f8555m;
                        bVar2.f8556n = bVar.f8556n;
                        aVar2 = bVar2;
                    } else if (dVar instanceof a) {
                        aVar2 = new a((a) dVar);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f8558b.add(aVar2);
                    String str2 = aVar2.f8568b;
                    if (str2 != null) {
                        aVar.put(str2, aVar2);
                    }
                }
            }
        }
    }

    public f(g gVar) {
        this.h = true;
        this.f8544j = new float[9];
        this.f8545k = new Matrix();
        this.f8546l = new Rect();
        this.f8540b = gVar;
        this.f8541c = a(gVar.f8587c, gVar.f8588d);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: e2.f$f, reason: collision with other inner class name */
    public static class C0075f {

        /* renamed from: p, reason: collision with root package name */
        public static final Matrix f8570p = new Matrix();

        /* renamed from: a, reason: collision with root package name */
        public final Path f8571a;

        /* renamed from: b, reason: collision with root package name */
        public final Path f8572b;

        /* renamed from: c, reason: collision with root package name */
        public final Matrix f8573c;

        /* renamed from: d, reason: collision with root package name */
        public Paint f8574d;

        /* renamed from: e, reason: collision with root package name */
        public Paint f8575e;

        /* renamed from: f, reason: collision with root package name */
        public PathMeasure f8576f;

        /* renamed from: g, reason: collision with root package name */
        public final c f8577g;
        public float h;

        /* renamed from: i, reason: collision with root package name */
        public float f8578i;

        /* renamed from: j, reason: collision with root package name */
        public float f8579j;

        /* renamed from: k, reason: collision with root package name */
        public float f8580k;

        /* renamed from: l, reason: collision with root package name */
        public int f8581l;

        /* renamed from: m, reason: collision with root package name */
        public String f8582m;

        /* renamed from: n, reason: collision with root package name */
        public Boolean f8583n;

        /* renamed from: o, reason: collision with root package name */
        public final p.a<String, Object> f8584o;

        public C0075f() {
            this.f8573c = new Matrix();
            this.h = 0.0f;
            this.f8578i = 0.0f;
            this.f8579j = 0.0f;
            this.f8580k = 0.0f;
            this.f8581l = 255;
            this.f8582m = null;
            this.f8583n = null;
            this.f8584o = new p.a<>();
            this.f8577g = new c();
            this.f8571a = new Path();
            this.f8572b = new Path();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(c cVar, Matrix matrix, Canvas canvas, int i10, int i11) {
            int i12;
            float f8;
            int i13;
            float f9;
            Matrix matrix2 = cVar.f8557a;
            ArrayList<d> arrayList = cVar.f8558b;
            matrix2.set(matrix);
            Matrix matrix3 = cVar.f8557a;
            matrix3.preConcat(cVar.f8565j);
            canvas.save();
            char c9 = 0;
            int i14 = 0;
            while (i14 < arrayList.size()) {
                d dVar = arrayList.get(i14);
                if (dVar instanceof c) {
                    a((c) dVar, matrix3, canvas, i10, i11);
                } else if (dVar instanceof e) {
                    e eVar = (e) dVar;
                    float f10 = i10 / this.f8579j;
                    float f11 = i11 / this.f8580k;
                    float fMin = Math.min(f10, f11);
                    Matrix matrix4 = this.f8573c;
                    matrix4.set(matrix3);
                    matrix4.postScale(f10, f11);
                    float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
                    matrix3.mapVectors(fArr);
                    float fHypot = (float) Math.hypot(fArr[c9], fArr[1]);
                    boolean z = c9;
                    i12 = i14;
                    float fHypot2 = (float) Math.hypot(fArr[2], fArr[3]);
                    float f12 = (fArr[z ? 1 : 0] * fArr[3]) - (fArr[1] * fArr[2]);
                    float fMax = Math.max(fHypot, fHypot2);
                    float fAbs = fMax > 0.0f ? Math.abs(f12) / fMax : 0.0f;
                    if (fAbs != 0.0f) {
                        Path path = this.f8571a;
                        path.reset();
                        d.a[] aVarArr = eVar.f8567a;
                        if (aVarArr != null) {
                            d.a.b(aVarArr, path);
                        }
                        Path path2 = this.f8572b;
                        path2.reset();
                        if (eVar instanceof a) {
                            path2.setFillType(eVar.f8569c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                            path2.addPath(path, matrix4);
                            canvas.clipPath(path2);
                        } else {
                            b bVar = (b) eVar;
                            float f13 = bVar.f8551i;
                            if (f13 != 0.0f || bVar.f8552j != 1.0f) {
                                float f14 = bVar.f8553k;
                                float f15 = (f13 + f14) % 1.0f;
                                float f16 = (bVar.f8552j + f14) % 1.0f;
                                if (this.f8576f == null) {
                                    this.f8576f = new PathMeasure();
                                }
                                this.f8576f.setPath(path, z);
                                float length = this.f8576f.getLength();
                                float f17 = f15 * length;
                                float f18 = f16 * length;
                                path.reset();
                                if (f17 > f18) {
                                    this.f8576f.getSegment(f17, length, path, true);
                                    f8 = 0.0f;
                                    this.f8576f.getSegment(0.0f, f18, path, true);
                                } else {
                                    f8 = 0.0f;
                                    this.f8576f.getSegment(f17, f18, path, true);
                                }
                                path.rLineTo(f8, f8);
                            }
                            path2.addPath(path, matrix4);
                            m0.d dVar2 = bVar.f8549f;
                            if (dVar2.f10449a == null && dVar2.f10451c == 0) {
                                f9 = 255.0f;
                                i13 = 16777215;
                            } else {
                                if (this.f8575e == null) {
                                    i13 = 16777215;
                                    Paint paint = new Paint(1);
                                    this.f8575e = paint;
                                    paint.setStyle(Paint.Style.FILL);
                                } else {
                                    i13 = 16777215;
                                }
                                Paint paint2 = this.f8575e;
                                Shader shader = dVar2.f10449a;
                                if (shader != null) {
                                    shader.setLocalMatrix(matrix4);
                                    paint2.setShader(shader);
                                    paint2.setAlpha(Math.round(bVar.h * 255.0f));
                                    f9 = 255.0f;
                                } else {
                                    paint2.setShader(null);
                                    paint2.setAlpha(255);
                                    int i15 = dVar2.f10451c;
                                    float f19 = bVar.h;
                                    PorterDuff.Mode mode = f.f8539m;
                                    f9 = 255.0f;
                                    paint2.setColor((i15 & i13) | (((int) (Color.alpha(i15) * f19)) << 24));
                                }
                                paint2.setColorFilter(null);
                                path2.setFillType(bVar.f8569c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                                canvas.drawPath(path2, paint2);
                            }
                            m0.d dVar3 = bVar.f8547d;
                            if (dVar3.f10449a != null || dVar3.f10451c != 0) {
                                if (this.f8574d == null) {
                                    Paint paint3 = new Paint(1);
                                    this.f8574d = paint3;
                                    paint3.setStyle(Paint.Style.STROKE);
                                }
                                Paint paint4 = this.f8574d;
                                Paint.Join join = bVar.f8555m;
                                if (join != null) {
                                    paint4.setStrokeJoin(join);
                                }
                                Paint.Cap cap = bVar.f8554l;
                                if (cap != null) {
                                    paint4.setStrokeCap(cap);
                                }
                                paint4.setStrokeMiter(bVar.f8556n);
                                Shader shader2 = dVar3.f10449a;
                                if (shader2 != null) {
                                    shader2.setLocalMatrix(matrix4);
                                    paint4.setShader(shader2);
                                    paint4.setAlpha(Math.round(bVar.f8550g * f9));
                                } else {
                                    paint4.setShader(null);
                                    paint4.setAlpha(255);
                                    int i16 = dVar3.f10451c;
                                    float f20 = bVar.f8550g;
                                    PorterDuff.Mode mode2 = f.f8539m;
                                    paint4.setColor((i16 & i13) | (((int) (Color.alpha(i16) * f20)) << 24));
                                }
                                paint4.setColorFilter(null);
                                paint4.setStrokeWidth(bVar.f8548e * fMin * fAbs);
                                canvas.drawPath(path2, paint4);
                            }
                        }
                    }
                    i14 = i12 + 1;
                    c9 = 0;
                }
                i12 = i14;
                i14 = i12 + 1;
                c9 = 0;
            }
            canvas.restore();
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.f8581l;
        }

        public void setAlpha(float f8) {
            setRootAlpha((int) (f8 * 255.0f));
        }

        public void setRootAlpha(int i10) {
            this.f8581l = i10;
        }

        public C0075f(C0075f c0075f) {
            this.f8573c = new Matrix();
            this.h = 0.0f;
            this.f8578i = 0.0f;
            this.f8579j = 0.0f;
            this.f8580k = 0.0f;
            this.f8581l = 255;
            this.f8582m = null;
            this.f8583n = null;
            p.a<String, Object> aVar = new p.a<>();
            this.f8584o = aVar;
            this.f8577g = new c(c0075f.f8577g, aVar);
            this.f8571a = new Path(c0075f.f8571a);
            this.f8572b = new Path(c0075f.f8572b);
            this.h = c0075f.h;
            this.f8578i = c0075f.f8578i;
            this.f8579j = c0075f.f8579j;
            this.f8580k = c0075f.f8580k;
            this.f8581l = c0075f.f8581l;
            this.f8582m = c0075f.f8582m;
            String str = c0075f.f8582m;
            if (str != null) {
                aVar.put(str, this);
            }
            this.f8583n = c0075f.f8583n;
        }
    }
}
