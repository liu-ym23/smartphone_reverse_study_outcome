package q1;

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
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.util.AttributeSet;
import com.stepos.launcher.assistant.slidepanel.ConstConfig;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import s0.k;
import t0.g;
import u0.C5566a;

/* loaded from: classes.dex */
public class f extends q1.e {

    /* renamed from: k, reason: collision with root package name */
    public static final PorterDuff.Mode f38523k = PorterDuff.Mode.SRC_IN;

    /* renamed from: b, reason: collision with root package name */
    public h f38524b;

    /* renamed from: c, reason: collision with root package name */
    public PorterDuffColorFilter f38525c;

    /* renamed from: d, reason: collision with root package name */
    public ColorFilter f38526d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f38527e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f38528f;

    /* renamed from: g, reason: collision with root package name */
    public Drawable.ConstantState f38529g;

    /* renamed from: h, reason: collision with root package name */
    public final float[] f38530h;

    /* renamed from: i, reason: collision with root package name */
    public final Matrix f38531i;

    /* renamed from: j, reason: collision with root package name */
    public final Rect f38532j;

    public static class b extends AbstractC0504f {
        public b() {
        }

        private void f(TypedArray typedArray, XmlPullParser xmlPullParser) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f38559b = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f38558a = t0.g.d(string2);
            }
            this.f38560c = k.k(typedArray, xmlPullParser, "fillType", 2, 0);
        }

        @Override // q1.f.AbstractC0504f
        public boolean c() {
            return true;
        }

        public void e(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (k.p(xmlPullParser, "pathData")) {
                TypedArray typedArrayQ = k.q(resources, theme, attributeSet, C5143a.f38496d);
                f(typedArrayQ, xmlPullParser);
                typedArrayQ.recycle();
            }
        }

        public b(b bVar) {
            super(bVar);
        }
    }

    public static abstract class e {
        public e() {
        }

        public boolean a() {
            return false;
        }

        public boolean b(int[] iArr) {
            return false;
        }
    }

    public static class h extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        public int f38579a;

        /* renamed from: b, reason: collision with root package name */
        public g f38580b;

        /* renamed from: c, reason: collision with root package name */
        public ColorStateList f38581c;

        /* renamed from: d, reason: collision with root package name */
        public PorterDuff.Mode f38582d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f38583e;

        /* renamed from: f, reason: collision with root package name */
        public Bitmap f38584f;

        /* renamed from: g, reason: collision with root package name */
        public ColorStateList f38585g;

        /* renamed from: h, reason: collision with root package name */
        public PorterDuff.Mode f38586h;

        /* renamed from: i, reason: collision with root package name */
        public int f38587i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f38588j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f38589k;

        /* renamed from: l, reason: collision with root package name */
        public Paint f38590l;

        public h(h hVar) {
            this.f38581c = null;
            this.f38582d = f.f38523k;
            if (hVar != null) {
                this.f38579a = hVar.f38579a;
                g gVar = new g(hVar.f38580b);
                this.f38580b = gVar;
                if (hVar.f38580b.f38567e != null) {
                    gVar.f38567e = new Paint(hVar.f38580b.f38567e);
                }
                if (hVar.f38580b.f38566d != null) {
                    this.f38580b.f38566d = new Paint(hVar.f38580b.f38566d);
                }
                this.f38581c = hVar.f38581c;
                this.f38582d = hVar.f38582d;
                this.f38583e = hVar.f38583e;
            }
        }

        public boolean a(int i10, int i11) {
            return i10 == this.f38584f.getWidth() && i11 == this.f38584f.getHeight();
        }

        public boolean b() {
            return !this.f38589k && this.f38585g == this.f38581c && this.f38586h == this.f38582d && this.f38588j == this.f38583e && this.f38587i == this.f38580b.getRootAlpha();
        }

        public void c(int i10, int i11) {
            if (this.f38584f == null || !a(i10, i11)) {
                this.f38584f = Bitmap.createBitmap(i10, i11, Bitmap.Config.ARGB_8888);
                this.f38589k = true;
            }
        }

        public void d(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f38584f, (Rect) null, rect, e(colorFilter));
        }

        public Paint e(ColorFilter colorFilter) {
            if (!f() && colorFilter == null) {
                return null;
            }
            if (this.f38590l == null) {
                Paint paint = new Paint();
                this.f38590l = paint;
                paint.setFilterBitmap(true);
            }
            this.f38590l.setAlpha(this.f38580b.getRootAlpha());
            this.f38590l.setColorFilter(colorFilter);
            return this.f38590l;
        }

        public boolean f() {
            return this.f38580b.getRootAlpha() < 255;
        }

        public boolean g() {
            return this.f38580b.f();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f38579a;
        }

        public boolean h(int[] iArr) {
            boolean zG = this.f38580b.g(iArr);
            this.f38589k |= zG;
            return zG;
        }

        public void i() {
            this.f38585g = this.f38581c;
            this.f38586h = this.f38582d;
            this.f38587i = this.f38580b.getRootAlpha();
            this.f38588j = this.f38583e;
            this.f38589k = false;
        }

        public void j(int i10, int i11) {
            this.f38584f.eraseColor(0);
            this.f38580b.b(new Canvas(this.f38584f), i10, i11, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new f(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new f(this);
        }

        public h() {
            this.f38581c = null;
            this.f38582d = f.f38523k;
            this.f38580b = new g();
        }
    }

    public f() {
        this.f38528f = true;
        this.f38530h = new float[9];
        this.f38531i = new Matrix();
        this.f38532j = new Rect();
        this.f38524b = new h();
    }

    public static int a(int i10, float f10) {
        return (i10 & 16777215) | (((int) (Color.alpha(i10) * f10)) << 24);
    }

    public static f b(Resources resources, int i10, Resources.Theme theme) {
        f fVar = new f();
        fVar.f38522a = s0.h.e(resources, i10, theme);
        fVar.f38529g = new i(fVar.f38522a.getConstantState());
        return fVar;
    }

    public static PorterDuff.Mode f(int i10, PorterDuff.Mode mode) {
        if (i10 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i10 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i10 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i10) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    @Override // q1.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    public Object c(String str) {
        return this.f38524b.f38580b.f38578p.get(str);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f38522a;
        if (drawable == null) {
            return false;
        }
        C5566a.b(drawable);
        return false;
    }

    @Override // q1.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public final void d(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        h hVar = this.f38524b;
        g gVar = hVar.f38580b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(gVar.f38570h);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z10 = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                d dVar = (d) arrayDeque.peek();
                if ("path".equals(name)) {
                    c cVar = new c();
                    cVar.g(resources, attributeSet, theme, xmlPullParser);
                    dVar.f38546b.add(cVar);
                    if (cVar.getPathName() != null) {
                        gVar.f38578p.put(cVar.getPathName(), cVar);
                    }
                    hVar.f38579a = cVar.f38561d | hVar.f38579a;
                    z10 = false;
                } else if ("clip-path".equals(name)) {
                    b bVar = new b();
                    bVar.e(resources, attributeSet, theme, xmlPullParser);
                    dVar.f38546b.add(bVar);
                    if (bVar.getPathName() != null) {
                        gVar.f38578p.put(bVar.getPathName(), bVar);
                    }
                    hVar.f38579a = bVar.f38561d | hVar.f38579a;
                } else if ("group".equals(name)) {
                    d dVar2 = new d();
                    dVar2.c(resources, attributeSet, theme, xmlPullParser);
                    dVar.f38546b.add(dVar2);
                    arrayDeque.push(dVar2);
                    if (dVar2.getGroupName() != null) {
                        gVar.f38578p.put(dVar2.getGroupName(), dVar2);
                    }
                    hVar.f38579a = dVar2.f38555k | hVar.f38579a;
                }
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z10) {
            throw new XmlPullParserException("no path defined");
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f38522a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.f38532j);
        if (this.f38532j.width() <= 0 || this.f38532j.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.f38526d;
        if (colorFilter == null) {
            colorFilter = this.f38525c;
        }
        canvas.getMatrix(this.f38531i);
        this.f38531i.getValues(this.f38530h);
        float fAbs = Math.abs(this.f38530h[0]);
        float fAbs2 = Math.abs(this.f38530h[4]);
        float fAbs3 = Math.abs(this.f38530h[1]);
        float fAbs4 = Math.abs(this.f38530h[3]);
        if (fAbs3 != 0.0f || fAbs4 != 0.0f) {
            fAbs = 1.0f;
            fAbs2 = 1.0f;
        }
        int iMin = Math.min(2048, (int) (this.f38532j.width() * fAbs));
        int iMin2 = Math.min(2048, (int) (this.f38532j.height() * fAbs2));
        if (iMin <= 0 || iMin2 <= 0) {
            return;
        }
        int iSave = canvas.save();
        Rect rect = this.f38532j;
        canvas.translate(rect.left, rect.top);
        if (e()) {
            canvas.translate(this.f38532j.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        this.f38532j.offsetTo(0, 0);
        this.f38524b.c(iMin, iMin2);
        if (!this.f38528f) {
            this.f38524b.j(iMin, iMin2);
        } else if (!this.f38524b.b()) {
            this.f38524b.j(iMin, iMin2);
            this.f38524b.i();
        }
        this.f38524b.d(canvas, colorFilter, this.f38532j);
        canvas.restoreToCount(iSave);
    }

    public final boolean e() {
        return isAutoMirrored() && C5566a.f(this) == 1;
    }

    public void g(boolean z10) {
        this.f38528f = z10;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f38522a;
        return drawable != null ? C5566a.d(drawable) : this.f38524b.f38580b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f38522a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return this.f38524b.getChangingConfigurations() | super.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f38522a;
        return drawable != null ? C5566a.e(drawable) : this.f38526d;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f38522a != null) {
            return new i(this.f38522a.getConstantState());
        }
        this.f38524b.f38579a = getChangingConfigurations();
        return this.f38524b;
    }

    @Override // q1.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f38522a;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.f38524b.f38580b.f38572j;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f38522a;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.f38524b.f38580b.f38571i;
    }

    @Override // q1.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // q1.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f38522a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // q1.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // q1.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // q1.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public final void h(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException {
        h hVar = this.f38524b;
        g gVar = hVar.f38580b;
        hVar.f38582d = f(k.k(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList colorStateListG = k.g(typedArray, xmlPullParser, theme, "tint", 1);
        if (colorStateListG != null) {
            hVar.f38581c = colorStateListG;
        }
        hVar.f38583e = k.e(typedArray, xmlPullParser, "autoMirrored", 5, hVar.f38583e);
        gVar.f38573k = k.j(typedArray, xmlPullParser, "viewportWidth", 7, gVar.f38573k);
        float fJ = k.j(typedArray, xmlPullParser, "viewportHeight", 8, gVar.f38574l);
        gVar.f38574l = fJ;
        if (gVar.f38573k <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (fJ <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
        gVar.f38571i = typedArray.getDimension(3, gVar.f38571i);
        float dimension = typedArray.getDimension(2, gVar.f38572j);
        gVar.f38572j = dimension;
        if (gVar.f38571i <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
        }
        if (dimension <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
        }
        gVar.setAlpha(k.j(typedArray, xmlPullParser, ConstConfig.KEY_VIEW_ALPHA_PROPERTY, 4, gVar.getAlpha()));
        String string = typedArray.getString(0);
        if (string != null) {
            gVar.f38576n = string;
            gVar.f38578p.put(string, gVar);
        }
    }

    public PorterDuffColorFilter i(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.f38522a;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable drawable = this.f38522a;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f38522a;
        return drawable != null ? C5566a.h(drawable) : this.f38524b.f38583e;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.f38522a;
        if (drawable != null) {
            return drawable.isStateful();
        }
        if (super.isStateful()) {
            return true;
        }
        h hVar = this.f38524b;
        if (hVar == null) {
            return false;
        }
        if (hVar.g()) {
            return true;
        }
        ColorStateList colorStateList = this.f38524b.f38581c;
        return colorStateList != null && colorStateList.isStateful();
    }

    @Override // q1.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f38522a;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f38527e && super.mutate() == this) {
            this.f38524b = new h(this.f38524b);
            this.f38527e = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f38522a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean z10;
        PorterDuff.Mode mode;
        Drawable drawable = this.f38522a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        h hVar = this.f38524b;
        ColorStateList colorStateList = hVar.f38581c;
        if (colorStateList == null || (mode = hVar.f38582d) == null) {
            z10 = false;
        } else {
            this.f38525c = i(this.f38525c, colorStateList, mode);
            invalidateSelf();
            z10 = true;
        }
        if (!hVar.g() || !hVar.h(iArr)) {
            return z10;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j10) {
        Drawable drawable = this.f38522a;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j10);
        } else {
            super.scheduleSelf(runnable, j10);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        Drawable drawable = this.f38522a;
        if (drawable != null) {
            drawable.setAlpha(i10);
        } else if (this.f38524b.f38580b.getRootAlpha() != i10) {
            this.f38524b.f38580b.setRootAlpha(i10);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z10) {
        Drawable drawable = this.f38522a;
        if (drawable != null) {
            C5566a.j(drawable, z10);
        } else {
            this.f38524b.f38583e = z10;
        }
    }

    @Override // q1.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i10) {
        super.setChangingConfigurations(i10);
    }

    @Override // q1.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i10, PorterDuff.Mode mode) {
        super.setColorFilter(i10, mode);
    }

    @Override // q1.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z10) {
        super.setFilterBitmap(z10);
    }

    @Override // q1.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f10, float f11) {
        super.setHotspot(f10, f11);
    }

    @Override // q1.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i10, int i11, int i12, int i13) {
        super.setHotspotBounds(i10, i11, i12, i13);
    }

    @Override // q1.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i10) {
        Drawable drawable = this.f38522a;
        if (drawable != null) {
            C5566a.n(drawable, i10);
        } else {
            setTintList(ColorStateList.valueOf(i10));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f38522a;
        if (drawable != null) {
            C5566a.o(drawable, colorStateList);
            return;
        }
        h hVar = this.f38524b;
        if (hVar.f38581c != colorStateList) {
            hVar.f38581c = colorStateList;
            this.f38525c = i(this.f38525c, colorStateList, hVar.f38582d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f38522a;
        if (drawable != null) {
            C5566a.p(drawable, mode);
            return;
        }
        h hVar = this.f38524b;
        if (hVar.f38582d != mode) {
            hVar.f38582d = mode;
            this.f38525c = i(this.f38525c, hVar.f38581c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        Drawable drawable = this.f38522a;
        return drawable != null ? drawable.setVisible(z10, z11) : super.setVisible(z10, z11);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f38522a;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    public static class i extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        public final Drawable.ConstantState f38591a;

        public i(Drawable.ConstantState constantState) {
            this.f38591a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f38591a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f38591a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            f fVar = new f();
            fVar.f38522a = (VectorDrawable) this.f38591a.newDrawable();
            return fVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            f fVar = new f();
            fVar.f38522a = (VectorDrawable) this.f38591a.newDrawable(resources);
            return fVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            f fVar = new f();
            fVar.f38522a = (VectorDrawable) this.f38591a.newDrawable(resources, theme);
            return fVar;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f38522a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f38526d = colorFilter;
            invalidateSelf();
        }
    }

    /* renamed from: q1.f$f, reason: collision with other inner class name */
    public static abstract class AbstractC0504f extends e {

        /* renamed from: a, reason: collision with root package name */
        public g.b[] f38558a;

        /* renamed from: b, reason: collision with root package name */
        public String f38559b;

        /* renamed from: c, reason: collision with root package name */
        public int f38560c;

        /* renamed from: d, reason: collision with root package name */
        public int f38561d;

        public AbstractC0504f() {
            super();
            this.f38558a = null;
            this.f38560c = 0;
        }

        public boolean c() {
            return false;
        }

        public void d(Path path) {
            path.reset();
            g.b[] bVarArr = this.f38558a;
            if (bVarArr != null) {
                g.b.h(bVarArr, path);
            }
        }

        public g.b[] getPathData() {
            return this.f38558a;
        }

        public String getPathName() {
            return this.f38559b;
        }

        public void setPathData(g.b[] bVarArr) {
            if (t0.g.b(this.f38558a, bVarArr)) {
                t0.g.k(this.f38558a, bVarArr);
            } else {
                this.f38558a = t0.g.f(bVarArr);
            }
        }

        public AbstractC0504f(AbstractC0504f abstractC0504f) {
            super();
            this.f38558a = null;
            this.f38560c = 0;
            this.f38559b = abstractC0504f.f38559b;
            this.f38561d = abstractC0504f.f38561d;
            this.f38558a = t0.g.f(abstractC0504f.f38558a);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f38522a;
        if (drawable != null) {
            C5566a.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        h hVar = this.f38524b;
        hVar.f38580b = new g();
        TypedArray typedArrayQ = k.q(resources, theme, attributeSet, C5143a.f38493a);
        h(typedArrayQ, xmlPullParser, theme);
        typedArrayQ.recycle();
        hVar.f38579a = getChangingConfigurations();
        hVar.f38589k = true;
        d(resources, xmlPullParser, attributeSet, theme);
        this.f38525c = i(this.f38525c, hVar.f38581c, hVar.f38582d);
    }

    public f(h hVar) {
        this.f38528f = true;
        this.f38530h = new float[9];
        this.f38531i = new Matrix();
        this.f38532j = new Rect();
        this.f38524b = hVar;
        this.f38525c = i(this.f38525c, hVar.f38581c, hVar.f38582d);
    }

    public static class c extends AbstractC0504f {

        /* renamed from: e, reason: collision with root package name */
        public int[] f38533e;

        /* renamed from: f, reason: collision with root package name */
        public s0.d f38534f;

        /* renamed from: g, reason: collision with root package name */
        public float f38535g;

        /* renamed from: h, reason: collision with root package name */
        public s0.d f38536h;

        /* renamed from: i, reason: collision with root package name */
        public float f38537i;

        /* renamed from: j, reason: collision with root package name */
        public float f38538j;

        /* renamed from: k, reason: collision with root package name */
        public float f38539k;

        /* renamed from: l, reason: collision with root package name */
        public float f38540l;

        /* renamed from: m, reason: collision with root package name */
        public float f38541m;

        /* renamed from: n, reason: collision with root package name */
        public Paint.Cap f38542n;

        /* renamed from: o, reason: collision with root package name */
        public Paint.Join f38543o;

        /* renamed from: p, reason: collision with root package name */
        public float f38544p;

        public c() {
            this.f38535g = 0.0f;
            this.f38537i = 1.0f;
            this.f38538j = 1.0f;
            this.f38539k = 0.0f;
            this.f38540l = 1.0f;
            this.f38541m = 0.0f;
            this.f38542n = Paint.Cap.BUTT;
            this.f38543o = Paint.Join.MITER;
            this.f38544p = 4.0f;
        }

        @Override // q1.f.e
        public boolean a() {
            return this.f38536h.i() || this.f38534f.i();
        }

        @Override // q1.f.e
        public boolean b(int[] iArr) {
            return this.f38534f.j(iArr) | this.f38536h.j(iArr);
        }

        public final Paint.Cap e(int i10, Paint.Cap cap) {
            return i10 != 0 ? i10 != 1 ? i10 != 2 ? cap : Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
        }

        public final Paint.Join f(int i10, Paint.Join join) {
            return i10 != 0 ? i10 != 1 ? i10 != 2 ? join : Paint.Join.BEVEL : Paint.Join.ROUND : Paint.Join.MITER;
        }

        public void g(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray typedArrayQ = k.q(resources, theme, attributeSet, C5143a.f38495c);
            h(typedArrayQ, xmlPullParser, theme);
            typedArrayQ.recycle();
        }

        public float getFillAlpha() {
            return this.f38538j;
        }

        public int getFillColor() {
            return this.f38536h.e();
        }

        public float getStrokeAlpha() {
            return this.f38537i;
        }

        public int getStrokeColor() {
            return this.f38534f.e();
        }

        public float getStrokeWidth() {
            return this.f38535g;
        }

        public float getTrimPathEnd() {
            return this.f38540l;
        }

        public float getTrimPathOffset() {
            return this.f38541m;
        }

        public float getTrimPathStart() {
            return this.f38539k;
        }

        public final void h(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.f38533e = null;
            if (k.p(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f38559b = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.f38558a = t0.g.d(string2);
                }
                this.f38536h = k.i(typedArray, xmlPullParser, theme, "fillColor", 1, 0);
                this.f38538j = k.j(typedArray, xmlPullParser, "fillAlpha", 12, this.f38538j);
                this.f38542n = e(k.k(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.f38542n);
                this.f38543o = f(k.k(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.f38543o);
                this.f38544p = k.j(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.f38544p);
                this.f38534f = k.i(typedArray, xmlPullParser, theme, "strokeColor", 3, 0);
                this.f38537i = k.j(typedArray, xmlPullParser, "strokeAlpha", 11, this.f38537i);
                this.f38535g = k.j(typedArray, xmlPullParser, "strokeWidth", 4, this.f38535g);
                this.f38540l = k.j(typedArray, xmlPullParser, "trimPathEnd", 6, this.f38540l);
                this.f38541m = k.j(typedArray, xmlPullParser, "trimPathOffset", 7, this.f38541m);
                this.f38539k = k.j(typedArray, xmlPullParser, "trimPathStart", 5, this.f38539k);
                this.f38560c = k.k(typedArray, xmlPullParser, "fillType", 13, this.f38560c);
            }
        }

        public void setFillAlpha(float f10) {
            this.f38538j = f10;
        }

        public void setFillColor(int i10) {
            this.f38536h.k(i10);
        }

        public void setStrokeAlpha(float f10) {
            this.f38537i = f10;
        }

        public void setStrokeColor(int i10) {
            this.f38534f.k(i10);
        }

        public void setStrokeWidth(float f10) {
            this.f38535g = f10;
        }

        public void setTrimPathEnd(float f10) {
            this.f38540l = f10;
        }

        public void setTrimPathOffset(float f10) {
            this.f38541m = f10;
        }

        public void setTrimPathStart(float f10) {
            this.f38539k = f10;
        }

        public c(c cVar) {
            super(cVar);
            this.f38535g = 0.0f;
            this.f38537i = 1.0f;
            this.f38538j = 1.0f;
            this.f38539k = 0.0f;
            this.f38540l = 1.0f;
            this.f38541m = 0.0f;
            this.f38542n = Paint.Cap.BUTT;
            this.f38543o = Paint.Join.MITER;
            this.f38544p = 4.0f;
            this.f38533e = cVar.f38533e;
            this.f38534f = cVar.f38534f;
            this.f38535g = cVar.f38535g;
            this.f38537i = cVar.f38537i;
            this.f38536h = cVar.f38536h;
            this.f38560c = cVar.f38560c;
            this.f38538j = cVar.f38538j;
            this.f38539k = cVar.f38539k;
            this.f38540l = cVar.f38540l;
            this.f38541m = cVar.f38541m;
            this.f38542n = cVar.f38542n;
            this.f38543o = cVar.f38543o;
            this.f38544p = cVar.f38544p;
        }
    }

    public static class g {

        /* renamed from: q, reason: collision with root package name */
        public static final Matrix f38562q = new Matrix();

        /* renamed from: a, reason: collision with root package name */
        public final Path f38563a;

        /* renamed from: b, reason: collision with root package name */
        public final Path f38564b;

        /* renamed from: c, reason: collision with root package name */
        public final Matrix f38565c;

        /* renamed from: d, reason: collision with root package name */
        public Paint f38566d;

        /* renamed from: e, reason: collision with root package name */
        public Paint f38567e;

        /* renamed from: f, reason: collision with root package name */
        public PathMeasure f38568f;

        /* renamed from: g, reason: collision with root package name */
        public int f38569g;

        /* renamed from: h, reason: collision with root package name */
        public final d f38570h;

        /* renamed from: i, reason: collision with root package name */
        public float f38571i;

        /* renamed from: j, reason: collision with root package name */
        public float f38572j;

        /* renamed from: k, reason: collision with root package name */
        public float f38573k;

        /* renamed from: l, reason: collision with root package name */
        public float f38574l;

        /* renamed from: m, reason: collision with root package name */
        public int f38575m;

        /* renamed from: n, reason: collision with root package name */
        public String f38576n;

        /* renamed from: o, reason: collision with root package name */
        public Boolean f38577o;

        /* renamed from: p, reason: collision with root package name */
        public final androidx.collection.a<String, Object> f38578p;

        public g() {
            this.f38565c = new Matrix();
            this.f38571i = 0.0f;
            this.f38572j = 0.0f;
            this.f38573k = 0.0f;
            this.f38574l = 0.0f;
            this.f38575m = 255;
            this.f38576n = null;
            this.f38577o = null;
            this.f38578p = new androidx.collection.a<>();
            this.f38570h = new d();
            this.f38563a = new Path();
            this.f38564b = new Path();
        }

        public static float a(float f10, float f11, float f12, float f13) {
            return (f10 * f13) - (f11 * f12);
        }

        public void b(Canvas canvas, int i10, int i11, ColorFilter colorFilter) {
            c(this.f38570h, f38562q, canvas, i10, i11, colorFilter);
        }

        public final void c(d dVar, Matrix matrix, Canvas canvas, int i10, int i11, ColorFilter colorFilter) {
            d dVar2 = dVar;
            dVar2.f38545a.set(matrix);
            dVar2.f38545a.preConcat(dVar2.f38554j);
            canvas.save();
            int i12 = 0;
            while (i12 < dVar2.f38546b.size()) {
                e eVar = dVar2.f38546b.get(i12);
                if (eVar instanceof d) {
                    c((d) eVar, dVar2.f38545a, canvas, i10, i11, colorFilter);
                } else if (eVar instanceof AbstractC0504f) {
                    d(dVar2, (AbstractC0504f) eVar, canvas, i10, i11, colorFilter);
                }
                i12++;
                dVar2 = dVar;
            }
            canvas.restore();
        }

        public final void d(d dVar, AbstractC0504f abstractC0504f, Canvas canvas, int i10, int i11, ColorFilter colorFilter) {
            float f10 = i10 / this.f38573k;
            float f11 = i11 / this.f38574l;
            float fMin = Math.min(f10, f11);
            Matrix matrix = dVar.f38545a;
            this.f38565c.set(matrix);
            this.f38565c.postScale(f10, f11);
            float fE = e(matrix);
            if (fE == 0.0f) {
                return;
            }
            abstractC0504f.d(this.f38563a);
            Path path = this.f38563a;
            this.f38564b.reset();
            if (abstractC0504f.c()) {
                this.f38564b.setFillType(abstractC0504f.f38560c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                this.f38564b.addPath(path, this.f38565c);
                canvas.clipPath(this.f38564b);
                return;
            }
            c cVar = (c) abstractC0504f;
            float f12 = cVar.f38539k;
            if (f12 != 0.0f || cVar.f38540l != 1.0f) {
                float f13 = cVar.f38541m;
                float f14 = (f12 + f13) % 1.0f;
                float f15 = (cVar.f38540l + f13) % 1.0f;
                if (this.f38568f == null) {
                    this.f38568f = new PathMeasure();
                }
                this.f38568f.setPath(this.f38563a, false);
                float length = this.f38568f.getLength();
                float f16 = f14 * length;
                float f17 = f15 * length;
                path.reset();
                if (f16 > f17) {
                    this.f38568f.getSegment(f16, length, path, true);
                    this.f38568f.getSegment(0.0f, f17, path, true);
                } else {
                    this.f38568f.getSegment(f16, f17, path, true);
                }
                path.rLineTo(0.0f, 0.0f);
            }
            this.f38564b.addPath(path, this.f38565c);
            if (cVar.f38536h.l()) {
                s0.d dVar2 = cVar.f38536h;
                if (this.f38567e == null) {
                    Paint paint = new Paint(1);
                    this.f38567e = paint;
                    paint.setStyle(Paint.Style.FILL);
                }
                Paint paint2 = this.f38567e;
                if (dVar2.h()) {
                    Shader shaderF = dVar2.f();
                    shaderF.setLocalMatrix(this.f38565c);
                    paint2.setShader(shaderF);
                    paint2.setAlpha(Math.round(cVar.f38538j * 255.0f));
                } else {
                    paint2.setShader(null);
                    paint2.setAlpha(255);
                    paint2.setColor(f.a(dVar2.e(), cVar.f38538j));
                }
                paint2.setColorFilter(colorFilter);
                this.f38564b.setFillType(cVar.f38560c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                canvas.drawPath(this.f38564b, paint2);
            }
            if (cVar.f38534f.l()) {
                s0.d dVar3 = cVar.f38534f;
                if (this.f38566d == null) {
                    Paint paint3 = new Paint(1);
                    this.f38566d = paint3;
                    paint3.setStyle(Paint.Style.STROKE);
                }
                Paint paint4 = this.f38566d;
                Paint.Join join = cVar.f38543o;
                if (join != null) {
                    paint4.setStrokeJoin(join);
                }
                Paint.Cap cap = cVar.f38542n;
                if (cap != null) {
                    paint4.setStrokeCap(cap);
                }
                paint4.setStrokeMiter(cVar.f38544p);
                if (dVar3.h()) {
                    Shader shaderF2 = dVar3.f();
                    shaderF2.setLocalMatrix(this.f38565c);
                    paint4.setShader(shaderF2);
                    paint4.setAlpha(Math.round(cVar.f38537i * 255.0f));
                } else {
                    paint4.setShader(null);
                    paint4.setAlpha(255);
                    paint4.setColor(f.a(dVar3.e(), cVar.f38537i));
                }
                paint4.setColorFilter(colorFilter);
                paint4.setStrokeWidth(cVar.f38535g * fMin * fE);
                canvas.drawPath(this.f38564b, paint4);
            }
        }

        public final float e(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float fHypot = (float) Math.hypot(fArr[0], fArr[1]);
            float fHypot2 = (float) Math.hypot(fArr[2], fArr[3]);
            float fA = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float fMax = Math.max(fHypot, fHypot2);
            if (fMax > 0.0f) {
                return Math.abs(fA) / fMax;
            }
            return 0.0f;
        }

        public boolean f() {
            if (this.f38577o == null) {
                this.f38577o = Boolean.valueOf(this.f38570h.a());
            }
            return this.f38577o.booleanValue();
        }

        public boolean g(int[] iArr) {
            return this.f38570h.b(iArr);
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.f38575m;
        }

        public void setAlpha(float f10) {
            setRootAlpha((int) (f10 * 255.0f));
        }

        public void setRootAlpha(int i10) {
            this.f38575m = i10;
        }

        public g(g gVar) {
            this.f38565c = new Matrix();
            this.f38571i = 0.0f;
            this.f38572j = 0.0f;
            this.f38573k = 0.0f;
            this.f38574l = 0.0f;
            this.f38575m = 255;
            this.f38576n = null;
            this.f38577o = null;
            androidx.collection.a<String, Object> aVar = new androidx.collection.a<>();
            this.f38578p = aVar;
            this.f38570h = new d(gVar.f38570h, aVar);
            this.f38563a = new Path(gVar.f38563a);
            this.f38564b = new Path(gVar.f38564b);
            this.f38571i = gVar.f38571i;
            this.f38572j = gVar.f38572j;
            this.f38573k = gVar.f38573k;
            this.f38574l = gVar.f38574l;
            this.f38569g = gVar.f38569g;
            this.f38575m = gVar.f38575m;
            this.f38576n = gVar.f38576n;
            String str = gVar.f38576n;
            if (str != null) {
                aVar.put(str, this);
            }
            this.f38577o = gVar.f38577o;
        }
    }

    public static class d extends e {

        /* renamed from: a, reason: collision with root package name */
        public final Matrix f38545a;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList<e> f38546b;

        /* renamed from: c, reason: collision with root package name */
        public float f38547c;

        /* renamed from: d, reason: collision with root package name */
        public float f38548d;

        /* renamed from: e, reason: collision with root package name */
        public float f38549e;

        /* renamed from: f, reason: collision with root package name */
        public float f38550f;

        /* renamed from: g, reason: collision with root package name */
        public float f38551g;

        /* renamed from: h, reason: collision with root package name */
        public float f38552h;

        /* renamed from: i, reason: collision with root package name */
        public float f38553i;

        /* renamed from: j, reason: collision with root package name */
        public final Matrix f38554j;

        /* renamed from: k, reason: collision with root package name */
        public int f38555k;

        /* renamed from: l, reason: collision with root package name */
        public int[] f38556l;

        /* renamed from: m, reason: collision with root package name */
        public String f38557m;

        public d(d dVar, androidx.collection.a<String, Object> aVar) {
            AbstractC0504f bVar;
            super();
            this.f38545a = new Matrix();
            this.f38546b = new ArrayList<>();
            this.f38547c = 0.0f;
            this.f38548d = 0.0f;
            this.f38549e = 0.0f;
            this.f38550f = 1.0f;
            this.f38551g = 1.0f;
            this.f38552h = 0.0f;
            this.f38553i = 0.0f;
            Matrix matrix = new Matrix();
            this.f38554j = matrix;
            this.f38557m = null;
            this.f38547c = dVar.f38547c;
            this.f38548d = dVar.f38548d;
            this.f38549e = dVar.f38549e;
            this.f38550f = dVar.f38550f;
            this.f38551g = dVar.f38551g;
            this.f38552h = dVar.f38552h;
            this.f38553i = dVar.f38553i;
            this.f38556l = dVar.f38556l;
            String str = dVar.f38557m;
            this.f38557m = str;
            this.f38555k = dVar.f38555k;
            if (str != null) {
                aVar.put(str, this);
            }
            matrix.set(dVar.f38554j);
            ArrayList<e> arrayList = dVar.f38546b;
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                e eVar = arrayList.get(i10);
                if (eVar instanceof d) {
                    this.f38546b.add(new d((d) eVar, aVar));
                } else {
                    if (eVar instanceof c) {
                        bVar = new c((c) eVar);
                    } else {
                        if (!(eVar instanceof b)) {
                            throw new IllegalStateException("Unknown object in the tree!");
                        }
                        bVar = new b((b) eVar);
                    }
                    this.f38546b.add(bVar);
                    String str2 = bVar.f38559b;
                    if (str2 != null) {
                        aVar.put(str2, bVar);
                    }
                }
            }
        }

        @Override // q1.f.e
        public boolean a() {
            for (int i10 = 0; i10 < this.f38546b.size(); i10++) {
                if (this.f38546b.get(i10).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // q1.f.e
        public boolean b(int[] iArr) {
            boolean zB = false;
            for (int i10 = 0; i10 < this.f38546b.size(); i10++) {
                zB |= this.f38546b.get(i10).b(iArr);
            }
            return zB;
        }

        public void c(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray typedArrayQ = k.q(resources, theme, attributeSet, C5143a.f38494b);
            e(typedArrayQ, xmlPullParser);
            typedArrayQ.recycle();
        }

        public final void d() {
            this.f38554j.reset();
            this.f38554j.postTranslate(-this.f38548d, -this.f38549e);
            this.f38554j.postScale(this.f38550f, this.f38551g);
            this.f38554j.postRotate(this.f38547c, 0.0f, 0.0f);
            this.f38554j.postTranslate(this.f38552h + this.f38548d, this.f38553i + this.f38549e);
        }

        public final void e(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f38556l = null;
            this.f38547c = k.j(typedArray, xmlPullParser, "rotation", 5, this.f38547c);
            this.f38548d = typedArray.getFloat(1, this.f38548d);
            this.f38549e = typedArray.getFloat(2, this.f38549e);
            this.f38550f = k.j(typedArray, xmlPullParser, "scaleX", 3, this.f38550f);
            this.f38551g = k.j(typedArray, xmlPullParser, "scaleY", 4, this.f38551g);
            this.f38552h = k.j(typedArray, xmlPullParser, "translateX", 6, this.f38552h);
            this.f38553i = k.j(typedArray, xmlPullParser, "translateY", 7, this.f38553i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.f38557m = string;
            }
            d();
        }

        public String getGroupName() {
            return this.f38557m;
        }

        public Matrix getLocalMatrix() {
            return this.f38554j;
        }

        public float getPivotX() {
            return this.f38548d;
        }

        public float getPivotY() {
            return this.f38549e;
        }

        public float getRotation() {
            return this.f38547c;
        }

        public float getScaleX() {
            return this.f38550f;
        }

        public float getScaleY() {
            return this.f38551g;
        }

        public float getTranslateX() {
            return this.f38552h;
        }

        public float getTranslateY() {
            return this.f38553i;
        }

        public void setPivotX(float f10) {
            if (f10 != this.f38548d) {
                this.f38548d = f10;
                d();
            }
        }

        public void setPivotY(float f10) {
            if (f10 != this.f38549e) {
                this.f38549e = f10;
                d();
            }
        }

        public void setRotation(float f10) {
            if (f10 != this.f38547c) {
                this.f38547c = f10;
                d();
            }
        }

        public void setScaleX(float f10) {
            if (f10 != this.f38550f) {
                this.f38550f = f10;
                d();
            }
        }

        public void setScaleY(float f10) {
            if (f10 != this.f38551g) {
                this.f38551g = f10;
                d();
            }
        }

        public void setTranslateX(float f10) {
            if (f10 != this.f38552h) {
                this.f38552h = f10;
                d();
            }
        }

        public void setTranslateY(float f10) {
            if (f10 != this.f38553i) {
                this.f38553i = f10;
                d();
            }
        }

        public d() {
            super();
            this.f38545a = new Matrix();
            this.f38546b = new ArrayList<>();
            this.f38547c = 0.0f;
            this.f38548d = 0.0f;
            this.f38549e = 0.0f;
            this.f38550f = 1.0f;
            this.f38551g = 1.0f;
            this.f38552h = 0.0f;
            this.f38553i = 0.0f;
            this.f38554j = new Matrix();
            this.f38557m = null;
        }
    }
}
