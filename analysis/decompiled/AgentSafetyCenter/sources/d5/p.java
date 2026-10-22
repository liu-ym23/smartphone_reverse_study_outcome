package d5;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;
import java.io.IOException;
import java.lang.invoke.VarHandle;
import java.util.ArrayDeque;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class p extends g {

    /* renamed from: n, reason: collision with root package name */
    public static final PorterDuff.Mode f3260n = PorterDuff.Mode.SRC_IN;

    /* renamed from: f, reason: collision with root package name */
    public n f3261f;

    /* renamed from: g, reason: collision with root package name */
    public PorterDuffColorFilter f3262g;

    /* renamed from: h, reason: collision with root package name */
    public ColorFilter f3263h;
    public boolean i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f3264j;

    /* renamed from: k, reason: collision with root package name */
    public final float[] f3265k;

    /* renamed from: l, reason: collision with root package name */
    public final Matrix f3266l;

    /* renamed from: m, reason: collision with root package name */
    public final Rect f3267m;

    public p() {
        this.f3264j = true;
        this.f3265k = new float[9];
        this.f3266l = new Matrix();
        this.f3267m = new Rect();
        n nVar = new n();
        nVar.f3250c = null;
        nVar.f3251d = f3260n;
        nVar.f3249b = new m();
        this.f3261f = nVar;
    }

    public final PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        Drawable drawable = this.f3209c;
        if (drawable == null) {
            return false;
        }
        drawable.canApplyTheme();
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Paint paint;
        Drawable drawable = this.f3209c;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        Rect rect = this.f3267m;
        copyBounds(rect);
        if (rect.width() <= 0 || rect.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.f3263h;
        if (colorFilter == null) {
            colorFilter = this.f3262g;
        }
        Matrix matrix = this.f3266l;
        canvas.getMatrix(matrix);
        float[] fArr = this.f3265k;
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
        int iMin = Math.min(RecyclerView.ItemAnimator.FLAG_MOVED, iWidth);
        int iMin2 = Math.min(RecyclerView.ItemAnimator.FLAG_MOVED, (int) (rect.height() * fAbs2));
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
        n nVar = this.f3261f;
        Bitmap bitmap = nVar.f3253f;
        if (bitmap == null || iMin != bitmap.getWidth() || iMin2 != nVar.f3253f.getHeight()) {
            nVar.f3253f = Bitmap.createBitmap(iMin, iMin2, Bitmap.Config.ARGB_8888);
            nVar.f3257k = true;
        }
        boolean z10 = this.f3264j;
        n nVar2 = this.f3261f;
        if (!z10) {
            nVar2.f3253f.eraseColor(0);
            Canvas canvas2 = new Canvas(nVar2.f3253f);
            m mVar = nVar2.f3249b;
            mVar.a(mVar.f3240g, m.f3233p, canvas2, iMin, iMin2);
        } else if (nVar2.f3257k || nVar2.f3254g != nVar2.f3250c || nVar2.f3255h != nVar2.f3251d || nVar2.f3256j != nVar2.f3252e || nVar2.i != nVar2.f3249b.getRootAlpha()) {
            n nVar3 = this.f3261f;
            nVar3.f3253f.eraseColor(0);
            Canvas canvas3 = new Canvas(nVar3.f3253f);
            m mVar2 = nVar3.f3249b;
            mVar2.a(mVar2.f3240g, m.f3233p, canvas3, iMin, iMin2);
            n nVar4 = this.f3261f;
            nVar4.f3254g = nVar4.f3250c;
            nVar4.f3255h = nVar4.f3251d;
            nVar4.i = nVar4.f3249b.getRootAlpha();
            nVar4.f3256j = nVar4.f3252e;
            nVar4.f3257k = false;
        }
        n nVar5 = this.f3261f;
        if (nVar5.f3249b.getRootAlpha() >= 255 && colorFilter == null) {
            paint = null;
        } else {
            if (nVar5.f3258l == null) {
                Paint paint2 = new Paint();
                nVar5.f3258l = paint2;
                paint2.setFilterBitmap(true);
            }
            nVar5.f3258l.setAlpha(nVar5.f3249b.getRootAlpha());
            nVar5.f3258l.setColorFilter(colorFilter);
            paint = nVar5.f3258l;
        }
        canvas.drawBitmap(nVar5.f3253f, (Rect) null, rect, paint);
        canvas.restoreToCount(iSave);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        Drawable drawable = this.f3209c;
        return drawable != null ? drawable.getAlpha() : this.f3261f.f3249b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        Drawable drawable = this.f3209c;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return this.f3261f.getChangingConfigurations() | super.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        Drawable drawable = this.f3209c;
        return drawable != null ? drawable.getColorFilter() : this.f3263h;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.f3209c != null) {
            return new o(this.f3209c.getConstantState());
        }
        this.f3261f.f3248a = getChangingConfigurations();
        return this.f3261f;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        Drawable drawable = this.f3209c;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.f3261f.f3249b.i;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        Drawable drawable = this.f3209c;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.f3261f.f3249b.f3241h;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable drawable = this.f3209c;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int i;
        int i3;
        int i10;
        int i11;
        Drawable drawable = this.f3209c;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
            return;
        }
        n nVar = this.f3261f;
        nVar.f3249b = new m();
        TypedArray typedArrayG = e3.b.g(resources, theme, attributeSet, a.f3191a);
        n nVar2 = this.f3261f;
        m mVar = nVar2.f3249b;
        int i12 = !e3.b.d(xmlPullParser, "tintMode") ? -1 : typedArrayG.getInt(6, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        int i13 = 3;
        if (i12 == 3) {
            mode = PorterDuff.Mode.SRC_OVER;
        } else if (i12 != 5) {
            if (i12 != 9) {
                switch (i12) {
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
        nVar2.f3251d = mode;
        ColorStateList colorStateListB = e3.b.b(typedArrayG, xmlPullParser, theme);
        if (colorStateListB != null) {
            nVar2.f3250c = colorStateListB;
        }
        boolean z10 = nVar2.f3252e;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "autoMirrored") != null) {
            z10 = typedArrayG.getBoolean(5, z10);
        }
        nVar2.f3252e = z10;
        float f5 = mVar.f3242j;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "viewportWidth") != null) {
            f5 = typedArrayG.getFloat(7, f5);
        }
        mVar.f3242j = f5;
        float f10 = mVar.f3243k;
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "viewportHeight") != null) {
            f10 = typedArrayG.getFloat(8, f10);
        }
        mVar.f3243k = f10;
        if (mVar.f3242j <= 0.0f) {
            throw new XmlPullParserException(typedArrayG.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (f10 <= 0.0f) {
            throw new XmlPullParserException(typedArrayG.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
        mVar.f3241h = typedArrayG.getDimension(3, mVar.f3241h);
        int i14 = 2;
        float dimension = typedArrayG.getDimension(2, mVar.i);
        mVar.i = dimension;
        if (mVar.f3241h <= 0.0f) {
            throw new XmlPullParserException(typedArrayG.getPositionDescription() + "<vector> tag requires width > 0");
        }
        if (dimension <= 0.0f) {
            throw new XmlPullParserException(typedArrayG.getPositionDescription() + "<vector> tag requires height > 0");
        }
        float alpha = mVar.getAlpha();
        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "alpha") != null) {
            alpha = typedArrayG.getFloat(4, alpha);
        }
        mVar.setAlpha(alpha);
        String string = typedArrayG.getString(0);
        if (string != null) {
            mVar.f3245m = string;
            mVar.f3247o.put(string, mVar);
        }
        typedArrayG.recycle();
        nVar.f3248a = getChangingConfigurations();
        int i15 = 1;
        nVar.f3257k = true;
        n nVar3 = this.f3261f;
        m mVar2 = nVar3.f3249b;
        ArrayDeque arrayDeque = new ArrayDeque();
        j jVar = mVar2.f3240g;
        p.e eVar = mVar2.f3247o;
        arrayDeque.push(jVar);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z11 = true;
        while (eventType != i15 && (xmlPullParser.getDepth() >= depth || eventType != i13)) {
            if (eventType == i14) {
                String name = xmlPullParser.getName();
                j jVar2 = (j) arrayDeque.peek();
                i = depth;
                if ("path".equals(name)) {
                    i iVar = new i();
                    iVar.f3211e = 0.0f;
                    iVar.f3213g = 1.0f;
                    iVar.f3214h = 1.0f;
                    iVar.i = 0.0f;
                    iVar.f3215j = 1.0f;
                    iVar.f3216k = 0.0f;
                    Paint.Cap cap = Paint.Cap.BUTT;
                    iVar.f3217l = cap;
                    Paint.Join join = Paint.Join.MITER;
                    iVar.f3218m = join;
                    iVar.f3219n = 4.0f;
                    TypedArray typedArrayG2 = e3.b.g(resources, theme, attributeSet, a.f3193c);
                    if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "pathData") != null) {
                        String string2 = typedArrayG2.getString(0);
                        if (string2 != null) {
                            iVar.f3231b = string2;
                        }
                        String string3 = typedArrayG2.getString(2);
                        if (string3 != null) {
                            iVar.f3230a = ac.a.p(string3);
                        }
                        iVar.f3212f = e3.b.c(typedArrayG2, xmlPullParser, theme, "fillColor", 1);
                        float f11 = iVar.f3214h;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "fillAlpha") != null) {
                            f11 = typedArrayG2.getFloat(12, f11);
                        }
                        iVar.f3214h = f11;
                        int i16 = xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeLineCap") != null ? typedArrayG2.getInt(8, -1) : -1;
                        iVar.f3217l = i16 != 0 ? i16 != 1 ? i16 != 2 ? iVar.f3217l : Paint.Cap.SQUARE : Paint.Cap.ROUND : cap;
                        int i17 = xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeLineJoin") != null ? typedArrayG2.getInt(9, -1) : -1;
                        iVar.f3218m = i17 != 0 ? i17 != 1 ? i17 != 2 ? iVar.f3218m : Paint.Join.BEVEL : Paint.Join.ROUND : join;
                        float f12 = iVar.f3219n;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeMiterLimit") != null) {
                            f12 = typedArrayG2.getFloat(10, f12);
                        }
                        iVar.f3219n = f12;
                        iVar.f3210d = e3.b.c(typedArrayG2, xmlPullParser, theme, "strokeColor", 3);
                        float f13 = iVar.f3213g;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeAlpha") != null) {
                            f13 = typedArrayG2.getFloat(11, f13);
                        }
                        iVar.f3213g = f13;
                        float f14 = iVar.f3211e;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "strokeWidth") != null) {
                            f14 = typedArrayG2.getFloat(4, f14);
                        }
                        iVar.f3211e = f14;
                        float f15 = iVar.f3215j;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "trimPathEnd") != null) {
                            f15 = typedArrayG2.getFloat(6, f15);
                        }
                        iVar.f3215j = f15;
                        float f16 = iVar.f3216k;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "trimPathOffset") != null) {
                            f16 = typedArrayG2.getFloat(7, f16);
                        }
                        iVar.f3216k = f16;
                        float f17 = iVar.i;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "trimPathStart") != null) {
                            f17 = typedArrayG2.getFloat(5, f17);
                        }
                        iVar.i = f17;
                        int i18 = iVar.f3232c;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "fillType") != null) {
                            i18 = typedArrayG2.getInt(13, i18);
                        }
                        iVar.f3232c = i18;
                    }
                    typedArrayG2.recycle();
                    jVar2.f3221b.add(iVar);
                    if (iVar.getPathName() != null) {
                        eVar.put(iVar.getPathName(), iVar);
                    }
                    nVar3.f3248a = nVar3.f3248a;
                    i11 = 1;
                    z11 = false;
                } else {
                    if ("clip-path".equals(name)) {
                        h hVar = new h();
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "pathData") != null) {
                            TypedArray typedArrayG3 = e3.b.g(resources, theme, attributeSet, a.f3194d);
                            String string4 = typedArrayG3.getString(0);
                            if (string4 != null) {
                                hVar.f3231b = string4;
                            }
                            String string5 = typedArrayG3.getString(1);
                            if (string5 != null) {
                                hVar.f3230a = ac.a.p(string5);
                            }
                            hVar.f3232c = !e3.b.d(xmlPullParser, "fillType") ? 0 : typedArrayG3.getInt(2, 0);
                            typedArrayG3.recycle();
                        }
                        jVar2.f3221b.add(hVar);
                        if (hVar.getPathName() != null) {
                            eVar.put(hVar.getPathName(), hVar);
                        }
                        nVar3.f3248a = nVar3.f3248a;
                    } else if ("group".equals(name)) {
                        j jVar3 = new j();
                        TypedArray typedArrayG4 = e3.b.g(resources, theme, attributeSet, a.f3192b);
                        float f18 = jVar3.f3222c;
                        if (e3.b.d(xmlPullParser, "rotation")) {
                            f18 = typedArrayG4.getFloat(5, f18);
                        }
                        jVar3.f3222c = f18;
                        i11 = 1;
                        jVar3.f3223d = typedArrayG4.getFloat(1, jVar3.f3223d);
                        jVar3.f3224e = typedArrayG4.getFloat(2, jVar3.f3224e);
                        float f19 = jVar3.f3225f;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "scaleX") != null) {
                            f19 = typedArrayG4.getFloat(3, f19);
                        }
                        jVar3.f3225f = f19;
                        float f20 = jVar3.f3226g;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "scaleY") != null) {
                            f20 = typedArrayG4.getFloat(4, f20);
                        }
                        jVar3.f3226g = f20;
                        float f21 = jVar3.f3227h;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "translateX") != null) {
                            f21 = typedArrayG4.getFloat(6, f21);
                        }
                        jVar3.f3227h = f21;
                        float f22 = jVar3.i;
                        if (xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", "translateY") != null) {
                            f22 = typedArrayG4.getFloat(7, f22);
                        }
                        jVar3.i = f22;
                        String string6 = typedArrayG4.getString(0);
                        if (string6 != null) {
                            jVar3.f3229k = string6;
                        }
                        jVar3.c();
                        typedArrayG4.recycle();
                        jVar2.f3221b.add(jVar3);
                        arrayDeque.push(jVar3);
                        if (jVar3.getGroupName() != null) {
                            eVar.put(jVar3.getGroupName(), jVar3);
                        }
                        nVar3.f3248a = nVar3.f3248a;
                    }
                    i11 = 1;
                }
                i10 = i11;
                i3 = 3;
            } else {
                i = depth;
                i3 = i13;
                i10 = 1;
                if (eventType == i3 && "group".equals(xmlPullParser.getName())) {
                    arrayDeque.pop();
                }
            }
            eventType = xmlPullParser.next();
            i13 = i3;
            i15 = i10;
            depth = i;
            i14 = 2;
        }
        if (z11) {
            throw new XmlPullParserException("no path defined");
        }
        this.f3262g = a(nVar.f3250c, nVar.f3251d);
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        Drawable drawable = this.f3209c;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        Drawable drawable = this.f3209c;
        return drawable != null ? drawable.isAutoMirrored() : this.f3261f.f3252e;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        Drawable drawable = this.f3209c;
        if (drawable != null) {
            return drawable.isStateful();
        }
        if (super.isStateful()) {
            return true;
        }
        n nVar = this.f3261f;
        if (nVar == null) {
            return false;
        }
        m mVar = nVar.f3249b;
        if (mVar.f3246n == null) {
            mVar.f3246n = Boolean.valueOf(mVar.f3240g.a());
        }
        if (mVar.f3246n.booleanValue()) {
            return true;
        }
        ColorStateList colorStateList = this.f3261f.f3250c;
        return colorStateList != null && colorStateList.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        Drawable drawable = this.f3209c;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.i && super.mutate() == this) {
            n nVar = this.f3261f;
            n nVar2 = new n();
            nVar2.f3250c = null;
            nVar2.f3251d = f3260n;
            if (nVar != null) {
                nVar2.f3248a = nVar.f3248a;
                m mVar = nVar.f3249b;
                m mVar2 = new m();
                mVar2.f3236c = new Matrix();
                mVar2.f3241h = 0.0f;
                mVar2.i = 0.0f;
                mVar2.f3242j = 0.0f;
                mVar2.f3243k = 0.0f;
                mVar2.f3244l = 255;
                mVar2.f3245m = null;
                mVar2.f3246n = null;
                p.e eVar = new p.e(0);
                mVar2.f3247o = eVar;
                mVar2.f3240g = new j(mVar.f3240g, eVar);
                mVar2.f3234a = new Path(mVar.f3234a);
                mVar2.f3235b = new Path(mVar.f3235b);
                mVar2.f3241h = mVar.f3241h;
                mVar2.i = mVar.i;
                mVar2.f3242j = mVar.f3242j;
                mVar2.f3243k = mVar.f3243k;
                mVar2.f3244l = mVar.f3244l;
                mVar2.f3245m = mVar.f3245m;
                String str = mVar.f3245m;
                if (str != null) {
                    eVar.put(str, mVar2);
                }
                mVar2.f3246n = mVar.f3246n;
                VarHandle.storeStoreFence();
                nVar2.f3249b = mVar2;
                if (nVar.f3249b.f3238e != null) {
                    mVar2.f3238e = new Paint(nVar.f3249b.f3238e);
                }
                if (nVar.f3249b.f3237d != null) {
                    nVar2.f3249b.f3237d = new Paint(nVar.f3249b.f3237d);
                }
                nVar2.f3250c = nVar.f3250c;
                nVar2.f3251d = nVar.f3251d;
                nVar2.f3252e = nVar.f3252e;
            }
            this.f3261f = nVar2;
            this.i = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.f3209c;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        boolean z10;
        PorterDuff.Mode mode;
        Drawable drawable = this.f3209c;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        n nVar = this.f3261f;
        ColorStateList colorStateList = nVar.f3250c;
        if (colorStateList == null || (mode = nVar.f3251d) == null) {
            z10 = false;
        } else {
            this.f3262g = a(colorStateList, mode);
            invalidateSelf();
            z10 = true;
        }
        m mVar = nVar.f3249b;
        if (mVar.f3246n == null) {
            mVar.f3246n = Boolean.valueOf(mVar.f3240g.a());
        }
        if (mVar.f3246n.booleanValue()) {
            boolean zB = nVar.f3249b.f3240g.b(iArr);
            nVar.f3257k |= zB;
            if (zB) {
                invalidateSelf();
                return true;
            }
        }
        return z10;
    }

    @Override // android.graphics.drawable.Drawable
    public final void scheduleSelf(Runnable runnable, long j10) {
        Drawable drawable = this.f3209c;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j10);
        } else {
            super.scheduleSelf(runnable, j10);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        Drawable drawable = this.f3209c;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else if (this.f3261f.f3249b.getRootAlpha() != i) {
            this.f3261f.f3249b.setRootAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z10) {
        Drawable drawable = this.f3209c;
        if (drawable != null) {
            drawable.setAutoMirrored(z10);
        } else {
            this.f3261f.f3252e = z10;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f3209c;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f3263h = colorFilter;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i) {
        Drawable drawable = this.f3209c;
        if (drawable != null) {
            drawable.setTint(i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f3209c;
        if (drawable != null) {
            drawable.setTintList(colorStateList);
            return;
        }
        n nVar = this.f3261f;
        if (nVar.f3250c != colorStateList) {
            nVar.f3250c = colorStateList;
            this.f3262g = a(colorStateList, nVar.f3251d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f3209c;
        if (drawable != null) {
            drawable.setTintMode(mode);
            return;
        }
        n nVar = this.f3261f;
        if (nVar.f3251d != mode) {
            nVar.f3251d = mode;
            this.f3262g = a(nVar.f3250c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z10, boolean z11) {
        Drawable drawable = this.f3209c;
        return drawable != null ? drawable.setVisible(z10, z11) : super.setVisible(z10, z11);
    }

    @Override // android.graphics.drawable.Drawable
    public final void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f3209c;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    public p(n nVar) {
        this.f3264j = true;
        this.f3265k = new float[9];
        this.f3266l = new Matrix();
        this.f3267m = new Rect();
        this.f3261f = nVar;
        this.f3262g = a(nVar.f3250c, nVar.f3251d);
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.f3209c;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }
}
