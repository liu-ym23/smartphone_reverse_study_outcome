package androidx.vectordrawable.graphics.drawable;

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
import androidx.core.content.res.k;
import androidx.core.graphics.d;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.policy.sdk.bean.PolicyBasicListVO;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import q.C0933a;

/* loaded from: classes.dex */
public class f extends androidx.vectordrawable.graphics.drawable.e {

    /* renamed from: k, reason: collision with root package name */
    static final PorterDuff.Mode f11532k = PorterDuff.Mode.SRC_IN;

    /* renamed from: b, reason: collision with root package name */
    private h f11533b;

    /* renamed from: c, reason: collision with root package name */
    private PorterDuffColorFilter f11534c;

    /* renamed from: d, reason: collision with root package name */
    private ColorFilter f11535d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f11536e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f11537f;

    /* renamed from: g, reason: collision with root package name */
    private Drawable.ConstantState f11538g;

    /* renamed from: h, reason: collision with root package name */
    private final float[] f11539h;

    /* renamed from: i, reason: collision with root package name */
    private final Matrix f11540i;

    /* renamed from: j, reason: collision with root package name */
    private final Rect f11541j;

    private static class b extends AbstractC0151f {
        b() {
        }

        private void f(TypedArray typedArray, XmlPullParser xmlPullParser) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f11568b = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f11567a = androidx.core.graphics.d.d(string2);
            }
            this.f11569c = k.k(typedArray, xmlPullParser, "fillType", 2, 0);
        }

        @Override // androidx.vectordrawable.graphics.drawable.f.AbstractC0151f
        public boolean c() {
            return true;
        }

        public void e(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (k.p(xmlPullParser, "pathData")) {
                TypedArray typedArrayQ = k.q(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f11505d);
                f(typedArrayQ, xmlPullParser);
                typedArrayQ.recycle();
            }
        }

        b(b bVar) {
            super(bVar);
        }
    }

    private static abstract class e {
        private e() {
        }

        public boolean a() {
            return false;
        }

        public boolean b(int[] iArr) {
            return false;
        }
    }

    private static class h extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        int f11588a;

        /* renamed from: b, reason: collision with root package name */
        g f11589b;

        /* renamed from: c, reason: collision with root package name */
        ColorStateList f11590c;

        /* renamed from: d, reason: collision with root package name */
        PorterDuff.Mode f11591d;

        /* renamed from: e, reason: collision with root package name */
        boolean f11592e;

        /* renamed from: f, reason: collision with root package name */
        Bitmap f11593f;

        /* renamed from: g, reason: collision with root package name */
        ColorStateList f11594g;

        /* renamed from: h, reason: collision with root package name */
        PorterDuff.Mode f11595h;

        /* renamed from: i, reason: collision with root package name */
        int f11596i;

        /* renamed from: j, reason: collision with root package name */
        boolean f11597j;

        /* renamed from: k, reason: collision with root package name */
        boolean f11598k;

        /* renamed from: l, reason: collision with root package name */
        Paint f11599l;

        public h(h hVar) {
            this.f11590c = null;
            this.f11591d = f.f11532k;
            if (hVar != null) {
                this.f11588a = hVar.f11588a;
                g gVar = new g(hVar.f11589b);
                this.f11589b = gVar;
                if (hVar.f11589b.f11576e != null) {
                    gVar.f11576e = new Paint(hVar.f11589b.f11576e);
                }
                if (hVar.f11589b.f11575d != null) {
                    this.f11589b.f11575d = new Paint(hVar.f11589b.f11575d);
                }
                this.f11590c = hVar.f11590c;
                this.f11591d = hVar.f11591d;
                this.f11592e = hVar.f11592e;
            }
        }

        public boolean a(int i5, int i6) {
            return i5 == this.f11593f.getWidth() && i6 == this.f11593f.getHeight();
        }

        public boolean b() {
            return !this.f11598k && this.f11594g == this.f11590c && this.f11595h == this.f11591d && this.f11597j == this.f11592e && this.f11596i == this.f11589b.getRootAlpha();
        }

        public void c(int i5, int i6) {
            if (this.f11593f == null || !a(i5, i6)) {
                this.f11593f = Bitmap.createBitmap(i5, i6, Bitmap.Config.ARGB_8888);
                this.f11598k = true;
            }
        }

        public void d(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f11593f, (Rect) null, rect, e(colorFilter));
        }

        public Paint e(ColorFilter colorFilter) {
            if (!f() && colorFilter == null) {
                return null;
            }
            if (this.f11599l == null) {
                Paint paint = new Paint();
                this.f11599l = paint;
                paint.setFilterBitmap(true);
            }
            this.f11599l.setAlpha(this.f11589b.getRootAlpha());
            this.f11599l.setColorFilter(colorFilter);
            return this.f11599l;
        }

        public boolean f() {
            return this.f11589b.getRootAlpha() < 255;
        }

        public boolean g() {
            return this.f11589b.f();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f11588a;
        }

        public boolean h(int[] iArr) {
            boolean zG = this.f11589b.g(iArr);
            this.f11598k |= zG;
            return zG;
        }

        public void i() {
            this.f11594g = this.f11590c;
            this.f11595h = this.f11591d;
            this.f11596i = this.f11589b.getRootAlpha();
            this.f11597j = this.f11592e;
            this.f11598k = false;
        }

        public void j(int i5, int i6) {
            this.f11593f.eraseColor(0);
            this.f11589b.b(new Canvas(this.f11593f), i5, i6, null);
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
            this.f11590c = null;
            this.f11591d = f.f11532k;
            this.f11589b = new g();
        }
    }

    f() {
        this.f11537f = true;
        this.f11539h = new float[9];
        this.f11540i = new Matrix();
        this.f11541j = new Rect();
        this.f11533b = new h();
    }

    static int a(int i5, float f5) {
        return (i5 & 16777215) | (((int) (Color.alpha(i5) * f5)) << 24);
    }

    public static f b(Resources resources, int i5, Resources.Theme theme) {
        f fVar = new f();
        fVar.f11531a = androidx.core.content.res.h.f(resources, i5, theme);
        fVar.f11538g = new i(fVar.f11531a.getConstantState());
        return fVar;
    }

    private void d(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        h hVar = this.f11533b;
        g gVar = hVar.f11589b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(gVar.f11579h);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z5 = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                d dVar = (d) arrayDeque.peek();
                if ("path".equals(name)) {
                    c cVar = new c();
                    cVar.g(resources, attributeSet, theme, xmlPullParser);
                    dVar.f11555b.add(cVar);
                    if (cVar.getPathName() != null) {
                        gVar.f11587p.put(cVar.getPathName(), cVar);
                    }
                    hVar.f11588a = cVar.f11570d | hVar.f11588a;
                    z5 = false;
                } else if ("clip-path".equals(name)) {
                    b bVar = new b();
                    bVar.e(resources, attributeSet, theme, xmlPullParser);
                    dVar.f11555b.add(bVar);
                    if (bVar.getPathName() != null) {
                        gVar.f11587p.put(bVar.getPathName(), bVar);
                    }
                    hVar.f11588a = bVar.f11570d | hVar.f11588a;
                } else if ("group".equals(name)) {
                    d dVar2 = new d();
                    dVar2.c(resources, attributeSet, theme, xmlPullParser);
                    dVar.f11555b.add(dVar2);
                    arrayDeque.push(dVar2);
                    if (dVar2.getGroupName() != null) {
                        gVar.f11587p.put(dVar2.getGroupName(), dVar2);
                    }
                    hVar.f11588a = dVar2.f11564k | hVar.f11588a;
                }
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z5) {
            throw new XmlPullParserException("no path defined");
        }
    }

    private boolean e() {
        return isAutoMirrored() && androidx.core.graphics.drawable.a.f(this) == 1;
    }

    private static PorterDuff.Mode f(int i5, PorterDuff.Mode mode) {
        if (i5 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i5 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i5 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i5) {
            case PolicyBasicListVO.TYPE_ID_LIST_BASCI_SINGLE_LINE_NEW_MESSAGE_NUMBER_WITH_ARROW /* 14 */:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    private void h(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException {
        h hVar = this.f11533b;
        g gVar = hVar.f11589b;
        hVar.f11591d = f(k.k(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList colorStateListG = k.g(typedArray, xmlPullParser, theme, "tint", 1);
        if (colorStateListG != null) {
            hVar.f11590c = colorStateListG;
        }
        hVar.f11592e = k.e(typedArray, xmlPullParser, "autoMirrored", 5, hVar.f11592e);
        gVar.f11582k = k.j(typedArray, xmlPullParser, "viewportWidth", 7, gVar.f11582k);
        float fJ = k.j(typedArray, xmlPullParser, "viewportHeight", 8, gVar.f11583l);
        gVar.f11583l = fJ;
        if (gVar.f11582k <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (fJ <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
        gVar.f11580i = typedArray.getDimension(3, gVar.f11580i);
        float dimension = typedArray.getDimension(2, gVar.f11581j);
        gVar.f11581j = dimension;
        if (gVar.f11580i <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
        }
        if (dimension <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
        }
        gVar.setAlpha(k.j(typedArray, xmlPullParser, "alpha", 4, gVar.getAlpha()));
        String string = typedArray.getString(0);
        if (string != null) {
            gVar.f11585n = string;
            gVar.f11587p.put(string, gVar);
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    Object c(String str) {
        return this.f11533b.f11589b.f11587p.get(str);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f11531a;
        if (drawable == null) {
            return false;
        }
        androidx.core.graphics.drawable.a.b(drawable);
        return false;
    }

    @Override // androidx.vectordrawable.graphics.drawable.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f11531a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.f11541j);
        if (this.f11541j.width() <= 0 || this.f11541j.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.f11535d;
        if (colorFilter == null) {
            colorFilter = this.f11534c;
        }
        canvas.getMatrix(this.f11540i);
        this.f11540i.getValues(this.f11539h);
        float fAbs = Math.abs(this.f11539h[0]);
        float fAbs2 = Math.abs(this.f11539h[4]);
        float fAbs3 = Math.abs(this.f11539h[1]);
        float fAbs4 = Math.abs(this.f11539h[3]);
        if (fAbs3 != 0.0f || fAbs4 != 0.0f) {
            fAbs = 1.0f;
            fAbs2 = 1.0f;
        }
        int iMin = Math.min(RecyclerView.ItemAnimator.FLAG_MOVED, (int) (this.f11541j.width() * fAbs));
        int iMin2 = Math.min(RecyclerView.ItemAnimator.FLAG_MOVED, (int) (this.f11541j.height() * fAbs2));
        if (iMin <= 0 || iMin2 <= 0) {
            return;
        }
        int iSave = canvas.save();
        Rect rect = this.f11541j;
        canvas.translate(rect.left, rect.top);
        if (e()) {
            canvas.translate(this.f11541j.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        this.f11541j.offsetTo(0, 0);
        this.f11533b.c(iMin, iMin2);
        if (!this.f11537f) {
            this.f11533b.j(iMin, iMin2);
        } else if (!this.f11533b.b()) {
            this.f11533b.j(iMin, iMin2);
            this.f11533b.i();
        }
        this.f11533b.d(canvas, colorFilter, this.f11541j);
        canvas.restoreToCount(iSave);
    }

    void g(boolean z5) {
        this.f11537f = z5;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f11531a;
        return drawable != null ? androidx.core.graphics.drawable.a.d(drawable) : this.f11533b.f11589b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f11531a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return this.f11533b.getChangingConfigurations() | super.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f11531a;
        return drawable != null ? androidx.core.graphics.drawable.a.e(drawable) : this.f11535d;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f11531a != null) {
            return new i(this.f11531a.getConstantState());
        }
        this.f11533b.f11588a = getChangingConfigurations();
        return this.f11533b;
    }

    @Override // androidx.vectordrawable.graphics.drawable.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f11531a;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.f11533b.f11589b.f11581j;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f11531a;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.f11533b.f11589b.f11580i;
    }

    @Override // androidx.vectordrawable.graphics.drawable.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.vectordrawable.graphics.drawable.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f11531a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // androidx.vectordrawable.graphics.drawable.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // androidx.vectordrawable.graphics.drawable.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // androidx.vectordrawable.graphics.drawable.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    PorterDuffColorFilter i(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.f11531a;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable drawable = this.f11531a;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f11531a;
        return drawable != null ? androidx.core.graphics.drawable.a.h(drawable) : this.f11533b.f11592e;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.f11531a;
        if (drawable != null) {
            return drawable.isStateful();
        }
        if (super.isStateful()) {
            return true;
        }
        h hVar = this.f11533b;
        if (hVar == null) {
            return false;
        }
        if (hVar.g()) {
            return true;
        }
        ColorStateList colorStateList = this.f11533b.f11590c;
        return colorStateList != null && colorStateList.isStateful();
    }

    @Override // androidx.vectordrawable.graphics.drawable.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f11531a;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f11536e && super.mutate() == this) {
            this.f11533b = new h(this.f11533b);
            this.f11536e = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f11531a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean z5;
        PorterDuff.Mode mode;
        Drawable drawable = this.f11531a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        h hVar = this.f11533b;
        ColorStateList colorStateList = hVar.f11590c;
        if (colorStateList == null || (mode = hVar.f11591d) == null) {
            z5 = false;
        } else {
            this.f11534c = i(this.f11534c, colorStateList, mode);
            invalidateSelf();
            z5 = true;
        }
        if (!hVar.g() || !hVar.h(iArr)) {
            return z5;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j5) {
        Drawable drawable = this.f11531a;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j5);
        } else {
            super.scheduleSelf(runnable, j5);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i5) {
        Drawable drawable = this.f11531a;
        if (drawable != null) {
            drawable.setAlpha(i5);
        } else if (this.f11533b.f11589b.getRootAlpha() != i5) {
            this.f11533b.f11589b.setRootAlpha(i5);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z5) {
        Drawable drawable = this.f11531a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.j(drawable, z5);
        } else {
            this.f11533b.f11592e = z5;
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i5) {
        super.setChangingConfigurations(i5);
    }

    @Override // androidx.vectordrawable.graphics.drawable.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i5, PorterDuff.Mode mode) {
        super.setColorFilter(i5, mode);
    }

    @Override // androidx.vectordrawable.graphics.drawable.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z5) {
        super.setFilterBitmap(z5);
    }

    @Override // androidx.vectordrawable.graphics.drawable.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f5, float f6) {
        super.setHotspot(f5, f6);
    }

    @Override // androidx.vectordrawable.graphics.drawable.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i5, int i6, int i7, int i8) {
        super.setHotspotBounds(i5, i6, i7, i8);
    }

    @Override // androidx.vectordrawable.graphics.drawable.e, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i5) {
        Drawable drawable = this.f11531a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.n(drawable, i5);
        } else {
            setTintList(ColorStateList.valueOf(i5));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f11531a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.o(drawable, colorStateList);
            return;
        }
        h hVar = this.f11533b;
        if (hVar.f11590c != colorStateList) {
            hVar.f11590c = colorStateList;
            this.f11534c = i(this.f11534c, colorStateList, hVar.f11591d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f11531a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.p(drawable, mode);
            return;
        }
        h hVar = this.f11533b;
        if (hVar.f11591d != mode) {
            hVar.f11591d = mode;
            this.f11534c = i(this.f11534c, hVar.f11590c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z5, boolean z6) {
        Drawable drawable = this.f11531a;
        return drawable != null ? drawable.setVisible(z5, z6) : super.setVisible(z5, z6);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f11531a;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    private static class i extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        private final Drawable.ConstantState f11600a;

        public i(Drawable.ConstantState constantState) {
            this.f11600a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f11600a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f11600a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            f fVar = new f();
            fVar.f11531a = (VectorDrawable) this.f11600a.newDrawable();
            return fVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            f fVar = new f();
            fVar.f11531a = (VectorDrawable) this.f11600a.newDrawable(resources);
            return fVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            f fVar = new f();
            fVar.f11531a = (VectorDrawable) this.f11600a.newDrawable(resources, theme);
            return fVar;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f11531a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f11535d = colorFilter;
            invalidateSelf();
        }
    }

    /* renamed from: androidx.vectordrawable.graphics.drawable.f$f, reason: collision with other inner class name */
    private static abstract class AbstractC0151f extends e {

        /* renamed from: a, reason: collision with root package name */
        protected d.b[] f11567a;

        /* renamed from: b, reason: collision with root package name */
        String f11568b;

        /* renamed from: c, reason: collision with root package name */
        int f11569c;

        /* renamed from: d, reason: collision with root package name */
        int f11570d;

        public AbstractC0151f() {
            super();
            this.f11567a = null;
            this.f11569c = 0;
        }

        public boolean c() {
            return false;
        }

        public void d(Path path) {
            path.reset();
            d.b[] bVarArr = this.f11567a;
            if (bVarArr != null) {
                d.b.h(bVarArr, path);
            }
        }

        public d.b[] getPathData() {
            return this.f11567a;
        }

        public String getPathName() {
            return this.f11568b;
        }

        public void setPathData(d.b[] bVarArr) {
            if (androidx.core.graphics.d.b(this.f11567a, bVarArr)) {
                androidx.core.graphics.d.k(this.f11567a, bVarArr);
            } else {
                this.f11567a = androidx.core.graphics.d.f(bVarArr);
            }
        }

        public AbstractC0151f(AbstractC0151f abstractC0151f) {
            super();
            this.f11567a = null;
            this.f11569c = 0;
            this.f11568b = abstractC0151f.f11568b;
            this.f11570d = abstractC0151f.f11570d;
            this.f11567a = androidx.core.graphics.d.f(abstractC0151f.f11567a);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f11531a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        h hVar = this.f11533b;
        hVar.f11589b = new g();
        TypedArray typedArrayQ = k.q(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f11502a);
        h(typedArrayQ, xmlPullParser, theme);
        typedArrayQ.recycle();
        hVar.f11588a = getChangingConfigurations();
        hVar.f11598k = true;
        d(resources, xmlPullParser, attributeSet, theme);
        this.f11534c = i(this.f11534c, hVar.f11590c, hVar.f11591d);
    }

    f(h hVar) {
        this.f11537f = true;
        this.f11539h = new float[9];
        this.f11540i = new Matrix();
        this.f11541j = new Rect();
        this.f11533b = hVar;
        this.f11534c = i(this.f11534c, hVar.f11590c, hVar.f11591d);
    }

    private static class c extends AbstractC0151f {

        /* renamed from: e, reason: collision with root package name */
        private int[] f11542e;

        /* renamed from: f, reason: collision with root package name */
        androidx.core.content.res.d f11543f;

        /* renamed from: g, reason: collision with root package name */
        float f11544g;

        /* renamed from: h, reason: collision with root package name */
        androidx.core.content.res.d f11545h;

        /* renamed from: i, reason: collision with root package name */
        float f11546i;

        /* renamed from: j, reason: collision with root package name */
        float f11547j;

        /* renamed from: k, reason: collision with root package name */
        float f11548k;

        /* renamed from: l, reason: collision with root package name */
        float f11549l;

        /* renamed from: m, reason: collision with root package name */
        float f11550m;

        /* renamed from: n, reason: collision with root package name */
        Paint.Cap f11551n;

        /* renamed from: o, reason: collision with root package name */
        Paint.Join f11552o;

        /* renamed from: p, reason: collision with root package name */
        float f11553p;

        c() {
            this.f11544g = 0.0f;
            this.f11546i = 1.0f;
            this.f11547j = 1.0f;
            this.f11548k = 0.0f;
            this.f11549l = 1.0f;
            this.f11550m = 0.0f;
            this.f11551n = Paint.Cap.BUTT;
            this.f11552o = Paint.Join.MITER;
            this.f11553p = 4.0f;
        }

        private Paint.Cap e(int i5, Paint.Cap cap) {
            return i5 != 0 ? i5 != 1 ? i5 != 2 ? cap : Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
        }

        private Paint.Join f(int i5, Paint.Join join) {
            return i5 != 0 ? i5 != 1 ? i5 != 2 ? join : Paint.Join.BEVEL : Paint.Join.ROUND : Paint.Join.MITER;
        }

        private void h(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.f11542e = null;
            if (k.p(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f11568b = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.f11567a = androidx.core.graphics.d.d(string2);
                }
                this.f11545h = k.i(typedArray, xmlPullParser, theme, "fillColor", 1, 0);
                this.f11547j = k.j(typedArray, xmlPullParser, "fillAlpha", 12, this.f11547j);
                this.f11551n = e(k.k(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.f11551n);
                this.f11552o = f(k.k(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.f11552o);
                this.f11553p = k.j(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.f11553p);
                this.f11543f = k.i(typedArray, xmlPullParser, theme, "strokeColor", 3, 0);
                this.f11546i = k.j(typedArray, xmlPullParser, "strokeAlpha", 11, this.f11546i);
                this.f11544g = k.j(typedArray, xmlPullParser, "strokeWidth", 4, this.f11544g);
                this.f11549l = k.j(typedArray, xmlPullParser, "trimPathEnd", 6, this.f11549l);
                this.f11550m = k.j(typedArray, xmlPullParser, "trimPathOffset", 7, this.f11550m);
                this.f11548k = k.j(typedArray, xmlPullParser, "trimPathStart", 5, this.f11548k);
                this.f11569c = k.k(typedArray, xmlPullParser, "fillType", 13, this.f11569c);
            }
        }

        @Override // androidx.vectordrawable.graphics.drawable.f.e
        public boolean a() {
            return this.f11545h.i() || this.f11543f.i();
        }

        @Override // androidx.vectordrawable.graphics.drawable.f.e
        public boolean b(int[] iArr) {
            return this.f11543f.j(iArr) | this.f11545h.j(iArr);
        }

        public void g(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray typedArrayQ = k.q(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f11504c);
            h(typedArrayQ, xmlPullParser, theme);
            typedArrayQ.recycle();
        }

        float getFillAlpha() {
            return this.f11547j;
        }

        int getFillColor() {
            return this.f11545h.e();
        }

        float getStrokeAlpha() {
            return this.f11546i;
        }

        int getStrokeColor() {
            return this.f11543f.e();
        }

        float getStrokeWidth() {
            return this.f11544g;
        }

        float getTrimPathEnd() {
            return this.f11549l;
        }

        float getTrimPathOffset() {
            return this.f11550m;
        }

        float getTrimPathStart() {
            return this.f11548k;
        }

        void setFillAlpha(float f5) {
            this.f11547j = f5;
        }

        void setFillColor(int i5) {
            this.f11545h.k(i5);
        }

        void setStrokeAlpha(float f5) {
            this.f11546i = f5;
        }

        void setStrokeColor(int i5) {
            this.f11543f.k(i5);
        }

        void setStrokeWidth(float f5) {
            this.f11544g = f5;
        }

        void setTrimPathEnd(float f5) {
            this.f11549l = f5;
        }

        void setTrimPathOffset(float f5) {
            this.f11550m = f5;
        }

        void setTrimPathStart(float f5) {
            this.f11548k = f5;
        }

        c(c cVar) {
            super(cVar);
            this.f11544g = 0.0f;
            this.f11546i = 1.0f;
            this.f11547j = 1.0f;
            this.f11548k = 0.0f;
            this.f11549l = 1.0f;
            this.f11550m = 0.0f;
            this.f11551n = Paint.Cap.BUTT;
            this.f11552o = Paint.Join.MITER;
            this.f11553p = 4.0f;
            this.f11542e = cVar.f11542e;
            this.f11543f = cVar.f11543f;
            this.f11544g = cVar.f11544g;
            this.f11546i = cVar.f11546i;
            this.f11545h = cVar.f11545h;
            this.f11569c = cVar.f11569c;
            this.f11547j = cVar.f11547j;
            this.f11548k = cVar.f11548k;
            this.f11549l = cVar.f11549l;
            this.f11550m = cVar.f11550m;
            this.f11551n = cVar.f11551n;
            this.f11552o = cVar.f11552o;
            this.f11553p = cVar.f11553p;
        }
    }

    private static class g {

        /* renamed from: q, reason: collision with root package name */
        private static final Matrix f11571q = new Matrix();

        /* renamed from: a, reason: collision with root package name */
        private final Path f11572a;

        /* renamed from: b, reason: collision with root package name */
        private final Path f11573b;

        /* renamed from: c, reason: collision with root package name */
        private final Matrix f11574c;

        /* renamed from: d, reason: collision with root package name */
        Paint f11575d;

        /* renamed from: e, reason: collision with root package name */
        Paint f11576e;

        /* renamed from: f, reason: collision with root package name */
        private PathMeasure f11577f;

        /* renamed from: g, reason: collision with root package name */
        private int f11578g;

        /* renamed from: h, reason: collision with root package name */
        final d f11579h;

        /* renamed from: i, reason: collision with root package name */
        float f11580i;

        /* renamed from: j, reason: collision with root package name */
        float f11581j;

        /* renamed from: k, reason: collision with root package name */
        float f11582k;

        /* renamed from: l, reason: collision with root package name */
        float f11583l;

        /* renamed from: m, reason: collision with root package name */
        int f11584m;

        /* renamed from: n, reason: collision with root package name */
        String f11585n;

        /* renamed from: o, reason: collision with root package name */
        Boolean f11586o;

        /* renamed from: p, reason: collision with root package name */
        final C0933a<String, Object> f11587p;

        public g() {
            this.f11574c = new Matrix();
            this.f11580i = 0.0f;
            this.f11581j = 0.0f;
            this.f11582k = 0.0f;
            this.f11583l = 0.0f;
            this.f11584m = 255;
            this.f11585n = null;
            this.f11586o = null;
            this.f11587p = new C0933a<>();
            this.f11579h = new d();
            this.f11572a = new Path();
            this.f11573b = new Path();
        }

        private static float a(float f5, float f6, float f7, float f8) {
            return (f5 * f8) - (f6 * f7);
        }

        private void c(d dVar, Matrix matrix, Canvas canvas, int i5, int i6, ColorFilter colorFilter) {
            d dVar2 = dVar;
            dVar2.f11554a.set(matrix);
            dVar2.f11554a.preConcat(dVar2.f11563j);
            canvas.save();
            int i7 = 0;
            while (i7 < dVar2.f11555b.size()) {
                e eVar = dVar2.f11555b.get(i7);
                if (eVar instanceof d) {
                    c((d) eVar, dVar2.f11554a, canvas, i5, i6, colorFilter);
                } else if (eVar instanceof AbstractC0151f) {
                    d(dVar2, (AbstractC0151f) eVar, canvas, i5, i6, colorFilter);
                }
                i7++;
                dVar2 = dVar;
            }
            canvas.restore();
        }

        private void d(d dVar, AbstractC0151f abstractC0151f, Canvas canvas, int i5, int i6, ColorFilter colorFilter) {
            float f5 = i5 / this.f11582k;
            float f6 = i6 / this.f11583l;
            float fMin = Math.min(f5, f6);
            Matrix matrix = dVar.f11554a;
            this.f11574c.set(matrix);
            this.f11574c.postScale(f5, f6);
            float fE = e(matrix);
            if (fE == 0.0f) {
                return;
            }
            abstractC0151f.d(this.f11572a);
            Path path = this.f11572a;
            this.f11573b.reset();
            if (abstractC0151f.c()) {
                this.f11573b.setFillType(abstractC0151f.f11569c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                this.f11573b.addPath(path, this.f11574c);
                canvas.clipPath(this.f11573b);
                return;
            }
            c cVar = (c) abstractC0151f;
            float f7 = cVar.f11548k;
            if (f7 != 0.0f || cVar.f11549l != 1.0f) {
                float f8 = cVar.f11550m;
                float f9 = (f7 + f8) % 1.0f;
                float f10 = (cVar.f11549l + f8) % 1.0f;
                if (this.f11577f == null) {
                    this.f11577f = new PathMeasure();
                }
                this.f11577f.setPath(this.f11572a, false);
                float length = this.f11577f.getLength();
                float f11 = f9 * length;
                float f12 = f10 * length;
                path.reset();
                if (f11 > f12) {
                    this.f11577f.getSegment(f11, length, path, true);
                    this.f11577f.getSegment(0.0f, f12, path, true);
                } else {
                    this.f11577f.getSegment(f11, f12, path, true);
                }
                path.rLineTo(0.0f, 0.0f);
            }
            this.f11573b.addPath(path, this.f11574c);
            if (cVar.f11545h.l()) {
                androidx.core.content.res.d dVar2 = cVar.f11545h;
                if (this.f11576e == null) {
                    Paint paint = new Paint(1);
                    this.f11576e = paint;
                    paint.setStyle(Paint.Style.FILL);
                }
                Paint paint2 = this.f11576e;
                if (dVar2.h()) {
                    Shader shaderF = dVar2.f();
                    shaderF.setLocalMatrix(this.f11574c);
                    paint2.setShader(shaderF);
                    paint2.setAlpha(Math.round(cVar.f11547j * 255.0f));
                } else {
                    paint2.setShader(null);
                    paint2.setAlpha(255);
                    paint2.setColor(f.a(dVar2.e(), cVar.f11547j));
                }
                paint2.setColorFilter(colorFilter);
                this.f11573b.setFillType(cVar.f11569c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                canvas.drawPath(this.f11573b, paint2);
            }
            if (cVar.f11543f.l()) {
                androidx.core.content.res.d dVar3 = cVar.f11543f;
                if (this.f11575d == null) {
                    Paint paint3 = new Paint(1);
                    this.f11575d = paint3;
                    paint3.setStyle(Paint.Style.STROKE);
                }
                Paint paint4 = this.f11575d;
                Paint.Join join = cVar.f11552o;
                if (join != null) {
                    paint4.setStrokeJoin(join);
                }
                Paint.Cap cap = cVar.f11551n;
                if (cap != null) {
                    paint4.setStrokeCap(cap);
                }
                paint4.setStrokeMiter(cVar.f11553p);
                if (dVar3.h()) {
                    Shader shaderF2 = dVar3.f();
                    shaderF2.setLocalMatrix(this.f11574c);
                    paint4.setShader(shaderF2);
                    paint4.setAlpha(Math.round(cVar.f11546i * 255.0f));
                } else {
                    paint4.setShader(null);
                    paint4.setAlpha(255);
                    paint4.setColor(f.a(dVar3.e(), cVar.f11546i));
                }
                paint4.setColorFilter(colorFilter);
                paint4.setStrokeWidth(cVar.f11544g * fMin * fE);
                canvas.drawPath(this.f11573b, paint4);
            }
        }

        private float e(Matrix matrix) {
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

        public void b(Canvas canvas, int i5, int i6, ColorFilter colorFilter) {
            c(this.f11579h, f11571q, canvas, i5, i6, colorFilter);
        }

        public boolean f() {
            if (this.f11586o == null) {
                this.f11586o = Boolean.valueOf(this.f11579h.a());
            }
            return this.f11586o.booleanValue();
        }

        public boolean g(int[] iArr) {
            return this.f11579h.b(iArr);
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.f11584m;
        }

        public void setAlpha(float f5) {
            setRootAlpha((int) (f5 * 255.0f));
        }

        public void setRootAlpha(int i5) {
            this.f11584m = i5;
        }

        public g(g gVar) {
            this.f11574c = new Matrix();
            this.f11580i = 0.0f;
            this.f11581j = 0.0f;
            this.f11582k = 0.0f;
            this.f11583l = 0.0f;
            this.f11584m = 255;
            this.f11585n = null;
            this.f11586o = null;
            C0933a<String, Object> c0933a = new C0933a<>();
            this.f11587p = c0933a;
            this.f11579h = new d(gVar.f11579h, c0933a);
            this.f11572a = new Path(gVar.f11572a);
            this.f11573b = new Path(gVar.f11573b);
            this.f11580i = gVar.f11580i;
            this.f11581j = gVar.f11581j;
            this.f11582k = gVar.f11582k;
            this.f11583l = gVar.f11583l;
            this.f11578g = gVar.f11578g;
            this.f11584m = gVar.f11584m;
            this.f11585n = gVar.f11585n;
            String str = gVar.f11585n;
            if (str != null) {
                c0933a.put(str, this);
            }
            this.f11586o = gVar.f11586o;
        }
    }

    private static class d extends e {

        /* renamed from: a, reason: collision with root package name */
        final Matrix f11554a;

        /* renamed from: b, reason: collision with root package name */
        final ArrayList<e> f11555b;

        /* renamed from: c, reason: collision with root package name */
        float f11556c;

        /* renamed from: d, reason: collision with root package name */
        private float f11557d;

        /* renamed from: e, reason: collision with root package name */
        private float f11558e;

        /* renamed from: f, reason: collision with root package name */
        private float f11559f;

        /* renamed from: g, reason: collision with root package name */
        private float f11560g;

        /* renamed from: h, reason: collision with root package name */
        private float f11561h;

        /* renamed from: i, reason: collision with root package name */
        private float f11562i;

        /* renamed from: j, reason: collision with root package name */
        final Matrix f11563j;

        /* renamed from: k, reason: collision with root package name */
        int f11564k;

        /* renamed from: l, reason: collision with root package name */
        private int[] f11565l;

        /* renamed from: m, reason: collision with root package name */
        private String f11566m;

        public d(d dVar, C0933a<String, Object> c0933a) {
            AbstractC0151f bVar;
            super();
            this.f11554a = new Matrix();
            this.f11555b = new ArrayList<>();
            this.f11556c = 0.0f;
            this.f11557d = 0.0f;
            this.f11558e = 0.0f;
            this.f11559f = 1.0f;
            this.f11560g = 1.0f;
            this.f11561h = 0.0f;
            this.f11562i = 0.0f;
            Matrix matrix = new Matrix();
            this.f11563j = matrix;
            this.f11566m = null;
            this.f11556c = dVar.f11556c;
            this.f11557d = dVar.f11557d;
            this.f11558e = dVar.f11558e;
            this.f11559f = dVar.f11559f;
            this.f11560g = dVar.f11560g;
            this.f11561h = dVar.f11561h;
            this.f11562i = dVar.f11562i;
            this.f11565l = dVar.f11565l;
            String str = dVar.f11566m;
            this.f11566m = str;
            this.f11564k = dVar.f11564k;
            if (str != null) {
                c0933a.put(str, this);
            }
            matrix.set(dVar.f11563j);
            ArrayList<e> arrayList = dVar.f11555b;
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                e eVar = arrayList.get(i5);
                if (eVar instanceof d) {
                    this.f11555b.add(new d((d) eVar, c0933a));
                } else {
                    if (eVar instanceof c) {
                        bVar = new c((c) eVar);
                    } else {
                        if (!(eVar instanceof b)) {
                            throw new IllegalStateException("Unknown object in the tree!");
                        }
                        bVar = new b((b) eVar);
                    }
                    this.f11555b.add(bVar);
                    String str2 = bVar.f11568b;
                    if (str2 != null) {
                        c0933a.put(str2, bVar);
                    }
                }
            }
        }

        private void d() {
            this.f11563j.reset();
            this.f11563j.postTranslate(-this.f11557d, -this.f11558e);
            this.f11563j.postScale(this.f11559f, this.f11560g);
            this.f11563j.postRotate(this.f11556c, 0.0f, 0.0f);
            this.f11563j.postTranslate(this.f11561h + this.f11557d, this.f11562i + this.f11558e);
        }

        private void e(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f11565l = null;
            this.f11556c = k.j(typedArray, xmlPullParser, "rotation", 5, this.f11556c);
            this.f11557d = typedArray.getFloat(1, this.f11557d);
            this.f11558e = typedArray.getFloat(2, this.f11558e);
            this.f11559f = k.j(typedArray, xmlPullParser, "scaleX", 3, this.f11559f);
            this.f11560g = k.j(typedArray, xmlPullParser, "scaleY", 4, this.f11560g);
            this.f11561h = k.j(typedArray, xmlPullParser, "translateX", 6, this.f11561h);
            this.f11562i = k.j(typedArray, xmlPullParser, "translateY", 7, this.f11562i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.f11566m = string;
            }
            d();
        }

        @Override // androidx.vectordrawable.graphics.drawable.f.e
        public boolean a() {
            for (int i5 = 0; i5 < this.f11555b.size(); i5++) {
                if (this.f11555b.get(i5).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.vectordrawable.graphics.drawable.f.e
        public boolean b(int[] iArr) {
            boolean zB = false;
            for (int i5 = 0; i5 < this.f11555b.size(); i5++) {
                zB |= this.f11555b.get(i5).b(iArr);
            }
            return zB;
        }

        public void c(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray typedArrayQ = k.q(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f11503b);
            e(typedArrayQ, xmlPullParser);
            typedArrayQ.recycle();
        }

        public String getGroupName() {
            return this.f11566m;
        }

        public Matrix getLocalMatrix() {
            return this.f11563j;
        }

        public float getPivotX() {
            return this.f11557d;
        }

        public float getPivotY() {
            return this.f11558e;
        }

        public float getRotation() {
            return this.f11556c;
        }

        public float getScaleX() {
            return this.f11559f;
        }

        public float getScaleY() {
            return this.f11560g;
        }

        public float getTranslateX() {
            return this.f11561h;
        }

        public float getTranslateY() {
            return this.f11562i;
        }

        public void setPivotX(float f5) {
            if (f5 != this.f11557d) {
                this.f11557d = f5;
                d();
            }
        }

        public void setPivotY(float f5) {
            if (f5 != this.f11558e) {
                this.f11558e = f5;
                d();
            }
        }

        public void setRotation(float f5) {
            if (f5 != this.f11556c) {
                this.f11556c = f5;
                d();
            }
        }

        public void setScaleX(float f5) {
            if (f5 != this.f11559f) {
                this.f11559f = f5;
                d();
            }
        }

        public void setScaleY(float f5) {
            if (f5 != this.f11560g) {
                this.f11560g = f5;
                d();
            }
        }

        public void setTranslateX(float f5) {
            if (f5 != this.f11561h) {
                this.f11561h = f5;
                d();
            }
        }

        public void setTranslateY(float f5) {
            if (f5 != this.f11562i) {
                this.f11562i = f5;
                d();
            }
        }

        public d() {
            super();
            this.f11554a = new Matrix();
            this.f11555b = new ArrayList<>();
            this.f11556c = 0.0f;
            this.f11557d = 0.0f;
            this.f11558e = 0.0f;
            this.f11559f = 1.0f;
            this.f11560g = 1.0f;
            this.f11561h = 0.0f;
            this.f11562i = 0.0f;
            this.f11563j = new Matrix();
            this.f11566m = null;
        }
    }
}
