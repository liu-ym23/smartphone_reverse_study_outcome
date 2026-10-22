package p0;

import Z2.I;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import com.stepos.activeview.moveline.item.ViewTweenItem;
import com.stepos.alphame.utils.Property;
import java.io.IOException;
import java.util.ArrayDeque;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import t0.J;

/* loaded from: classes.dex */
public final class o extends f {

    /* renamed from: j, reason: collision with root package name */
    public static final PorterDuff.Mode f13914j = PorterDuff.Mode.SRC_IN;

    /* renamed from: b, reason: collision with root package name */
    public m f13915b;

    /* renamed from: c, reason: collision with root package name */
    public PorterDuffColorFilter f13916c;

    /* renamed from: d, reason: collision with root package name */
    public ColorFilter f13917d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f13918e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f13919f;

    /* renamed from: g, reason: collision with root package name */
    public final float[] f13920g;

    /* renamed from: h, reason: collision with root package name */
    public final Matrix f13921h;

    /* renamed from: i, reason: collision with root package name */
    public final Rect f13922i;

    public o() {
        this.f13919f = true;
        this.f13920g = new float[9];
        this.f13921h = new Matrix();
        this.f13922i = new Rect();
        m mVar = new m();
        mVar.f13903c = null;
        mVar.f13904d = f13914j;
        mVar.f13902b = new l();
        this.f13915b = mVar;
    }

    public final PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        Drawable drawable = this.f13857a;
        if (drawable == null) {
            return false;
        }
        E.a.b(drawable);
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Paint paint;
        Drawable drawable = this.f13857a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        Rect rect = this.f13922i;
        copyBounds(rect);
        if (rect.width() <= 0 || rect.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.f13917d;
        if (colorFilter == null) {
            colorFilter = this.f13916c;
        }
        Matrix matrix = this.f13921h;
        canvas.getMatrix(matrix);
        float[] fArr = this.f13920g;
        matrix.getValues(fArr);
        float fAbs = Math.abs(fArr[0]);
        float fAbs2 = Math.abs(fArr[4]);
        float fAbs3 = Math.abs(fArr[1]);
        float fAbs4 = Math.abs(fArr[3]);
        if (fAbs3 != Property.DEFAULT_FLOAT_VALUE || fAbs4 != Property.DEFAULT_FLOAT_VALUE) {
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
        if (isAutoMirrored() && E.b.a(this) == 1) {
            canvas.translate(rect.width(), Property.DEFAULT_FLOAT_VALUE);
            canvas.scale(-1.0f, 1.0f);
        }
        rect.offsetTo(0, 0);
        m mVar = this.f13915b;
        Bitmap bitmap = mVar.f13906f;
        if (bitmap == null || iMin != bitmap.getWidth() || iMin2 != mVar.f13906f.getHeight()) {
            mVar.f13906f = Bitmap.createBitmap(iMin, iMin2, Bitmap.Config.ARGB_8888);
            mVar.f13911k = true;
        }
        if (this.f13919f) {
            m mVar2 = this.f13915b;
            if (mVar2.f13911k || mVar2.f13907g != mVar2.f13903c || mVar2.f13908h != mVar2.f13904d || mVar2.f13910j != mVar2.f13905e || mVar2.f13909i != mVar2.f13902b.getRootAlpha()) {
                m mVar3 = this.f13915b;
                mVar3.f13906f.eraseColor(0);
                Canvas canvas2 = new Canvas(mVar3.f13906f);
                l lVar = mVar3.f13902b;
                lVar.a(lVar.f13892g, l.f13885p, canvas2, iMin, iMin2);
                m mVar4 = this.f13915b;
                mVar4.f13907g = mVar4.f13903c;
                mVar4.f13908h = mVar4.f13904d;
                mVar4.f13909i = mVar4.f13902b.getRootAlpha();
                mVar4.f13910j = mVar4.f13905e;
                mVar4.f13911k = false;
            }
        } else {
            m mVar5 = this.f13915b;
            mVar5.f13906f.eraseColor(0);
            Canvas canvas3 = new Canvas(mVar5.f13906f);
            l lVar2 = mVar5.f13902b;
            lVar2.a(lVar2.f13892g, l.f13885p, canvas3, iMin, iMin2);
        }
        m mVar6 = this.f13915b;
        if (mVar6.f13902b.getRootAlpha() >= 255 && colorFilter == null) {
            paint = null;
        } else {
            if (mVar6.f13912l == null) {
                Paint paint2 = new Paint();
                mVar6.f13912l = paint2;
                paint2.setFilterBitmap(true);
            }
            mVar6.f13912l.setAlpha(mVar6.f13902b.getRootAlpha());
            mVar6.f13912l.setColorFilter(colorFilter);
            paint = mVar6.f13912l;
        }
        canvas.drawBitmap(mVar6.f13906f, (Rect) null, rect, paint);
        canvas.restoreToCount(iSave);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        Drawable drawable = this.f13857a;
        return drawable != null ? drawable.getAlpha() : this.f13915b.f13902b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        Drawable drawable = this.f13857a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return this.f13915b.getChangingConfigurations() | super.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        Drawable drawable = this.f13857a;
        return drawable != null ? E.a.c(drawable) : this.f13917d;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.f13857a != null) {
            return new n(this.f13857a.getConstantState());
        }
        this.f13915b.f13901a = getChangingConfigurations();
        return this.f13915b;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        Drawable drawable = this.f13857a;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.f13915b.f13902b.f13894i;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        Drawable drawable = this.f13857a;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.f13915b.f13902b.f13893h;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable drawable = this.f13857a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        l lVar;
        int i4;
        int i5;
        boolean z4;
        int i6;
        boolean z5;
        Paint.Join join;
        Paint.Cap cap;
        Drawable drawable = this.f13857a;
        if (drawable != null) {
            E.a.d(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        m mVar = this.f13915b;
        mVar.f13902b = new l();
        TypedArray typedArrayZ = I.z(resources, theme, attributeSet, AbstractC0811a.f13840a);
        m mVar2 = this.f13915b;
        l lVar2 = mVar2.f13902b;
        int i7 = !I.u(xmlPullParser, "tintMode") ? -1 : typedArrayZ.getInt(6, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        int i8 = 3;
        if (i7 == 3) {
            mode = PorterDuff.Mode.SRC_OVER;
        } else if (i7 != 5) {
            if (i7 != 9) {
                switch (i7) {
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
        mVar2.f13904d = mode;
        int i9 = 1;
        ColorStateList colorStateListA = null;
        boolean z6 = false;
        if (I.u(xmlPullParser, "tint")) {
            TypedValue typedValue = new TypedValue();
            typedArrayZ.getValue(1, typedValue);
            int i10 = typedValue.type;
            if (i10 == 2) {
                throw new UnsupportedOperationException("Failed to resolve attribute at index 1: " + typedValue);
            }
            if (i10 < 28 || i10 > 31) {
                Resources resources2 = typedArrayZ.getResources();
                int resourceId = typedArrayZ.getResourceId(1, 0);
                ThreadLocal threadLocal = C.c.f249a;
                try {
                    colorStateListA = C.c.a(resources2, resources2.getXml(resourceId), theme);
                } catch (Exception e4) {
                    Log.e("CSLCompat", "Failed to inflate ColorStateList.", e4);
                }
            } else {
                colorStateListA = ColorStateList.valueOf(typedValue.data);
            }
        }
        ColorStateList colorStateList = colorStateListA;
        if (colorStateList != null) {
            mVar2.f13903c = colorStateList;
        }
        boolean z7 = mVar2.f13905e;
        if (I.u(xmlPullParser, "autoMirrored")) {
            z7 = typedArrayZ.getBoolean(5, z7);
        }
        mVar2.f13905e = z7;
        float f4 = lVar2.f13895j;
        if (I.u(xmlPullParser, "viewportWidth")) {
            f4 = typedArrayZ.getFloat(7, f4);
        }
        lVar2.f13895j = f4;
        float f5 = lVar2.f13896k;
        if (I.u(xmlPullParser, "viewportHeight")) {
            f5 = typedArrayZ.getFloat(8, f5);
        }
        lVar2.f13896k = f5;
        if (lVar2.f13895j <= Property.DEFAULT_FLOAT_VALUE) {
            throw new XmlPullParserException(typedArrayZ.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (f5 <= Property.DEFAULT_FLOAT_VALUE) {
            throw new XmlPullParserException(typedArrayZ.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
        lVar2.f13893h = typedArrayZ.getDimension(3, lVar2.f13893h);
        float dimension = typedArrayZ.getDimension(2, lVar2.f13894i);
        lVar2.f13894i = dimension;
        if (lVar2.f13893h <= Property.DEFAULT_FLOAT_VALUE) {
            throw new XmlPullParserException(typedArrayZ.getPositionDescription() + "<vector> tag requires width > 0");
        }
        if (dimension <= Property.DEFAULT_FLOAT_VALUE) {
            throw new XmlPullParserException(typedArrayZ.getPositionDescription() + "<vector> tag requires height > 0");
        }
        float alpha = lVar2.getAlpha();
        if (I.u(xmlPullParser, ViewTweenItem.ALPHA)) {
            alpha = typedArrayZ.getFloat(4, alpha);
        }
        lVar2.setAlpha(alpha);
        String string = typedArrayZ.getString(0);
        if (string != null) {
            lVar2.f13898m = string;
            lVar2.f13900o.put(string, lVar2);
        }
        typedArrayZ.recycle();
        mVar.f13901a = getChangingConfigurations();
        mVar.f13911k = true;
        m mVar3 = this.f13915b;
        l lVar3 = mVar3.f13902b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(lVar3.f13892g);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z8 = true;
        while (eventType != i9 && (xmlPullParser.getDepth() >= depth || eventType != i8)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                i iVar = (i) arrayDeque.peek();
                boolean zEquals = "path".equals(name);
                i4 = depth;
                q.f fVar = lVar3.f13900o;
                if (zEquals) {
                    h hVar = new h();
                    hVar.f13859f = Property.DEFAULT_FLOAT_VALUE;
                    hVar.f13861h = 1.0f;
                    hVar.f13862i = 1.0f;
                    hVar.f13863j = Property.DEFAULT_FLOAT_VALUE;
                    hVar.f13864k = 1.0f;
                    hVar.f13865l = Property.DEFAULT_FLOAT_VALUE;
                    Paint.Cap cap2 = Paint.Cap.BUTT;
                    hVar.f13866m = cap2;
                    Paint.Join join2 = Paint.Join.MITER;
                    hVar.f13867n = join2;
                    lVar = lVar3;
                    hVar.f13868o = 4.0f;
                    TypedArray typedArrayZ2 = I.z(resources, theme, attributeSet, AbstractC0811a.f13842c);
                    if (I.u(xmlPullParser, "pathData")) {
                        String string2 = typedArrayZ2.getString(0);
                        if (string2 != null) {
                            hVar.f13882b = string2;
                        }
                        String string3 = typedArrayZ2.getString(2);
                        if (string3 != null) {
                            hVar.f13881a = J.q(string3);
                        }
                        hVar.f13860g = I.q(typedArrayZ2, xmlPullParser, theme, "fillColor", 1);
                        float f6 = hVar.f13862i;
                        if (I.u(xmlPullParser, "fillAlpha")) {
                            f6 = typedArrayZ2.getFloat(12, f6);
                        }
                        hVar.f13862i = f6;
                        int i11 = !I.u(xmlPullParser, "strokeLineCap") ? -1 : typedArrayZ2.getInt(8, -1);
                        Paint.Cap cap3 = hVar.f13866m;
                        if (i11 != 0) {
                            join = join2;
                            cap = i11 != 1 ? i11 != 2 ? cap3 : Paint.Cap.SQUARE : Paint.Cap.ROUND;
                        } else {
                            join = join2;
                            cap = cap2;
                        }
                        hVar.f13866m = cap;
                        int i12 = !I.u(xmlPullParser, "strokeLineJoin") ? -1 : typedArrayZ2.getInt(9, -1);
                        hVar.f13867n = i12 != 0 ? i12 != 1 ? i12 != 2 ? hVar.f13867n : Paint.Join.BEVEL : Paint.Join.ROUND : join;
                        float f7 = hVar.f13868o;
                        if (I.u(xmlPullParser, "strokeMiterLimit")) {
                            f7 = typedArrayZ2.getFloat(10, f7);
                        }
                        hVar.f13868o = f7;
                        hVar.f13858e = I.q(typedArrayZ2, xmlPullParser, theme, "strokeColor", 3);
                        float f8 = hVar.f13861h;
                        if (I.u(xmlPullParser, "strokeAlpha")) {
                            f8 = typedArrayZ2.getFloat(11, f8);
                        }
                        hVar.f13861h = f8;
                        float f9 = hVar.f13859f;
                        if (I.u(xmlPullParser, "strokeWidth")) {
                            f9 = typedArrayZ2.getFloat(4, f9);
                        }
                        hVar.f13859f = f9;
                        float f10 = hVar.f13864k;
                        if (I.u(xmlPullParser, "trimPathEnd")) {
                            f10 = typedArrayZ2.getFloat(6, f10);
                        }
                        hVar.f13864k = f10;
                        float f11 = hVar.f13865l;
                        if (I.u(xmlPullParser, "trimPathOffset")) {
                            f11 = typedArrayZ2.getFloat(7, f11);
                        }
                        hVar.f13865l = f11;
                        float f12 = hVar.f13863j;
                        if (I.u(xmlPullParser, "trimPathStart")) {
                            f12 = typedArrayZ2.getFloat(5, f12);
                        }
                        hVar.f13863j = f12;
                        int i13 = hVar.f13883c;
                        if (I.u(xmlPullParser, "fillType")) {
                            i13 = typedArrayZ2.getInt(13, i13);
                        }
                        hVar.f13883c = i13;
                    }
                    typedArrayZ2.recycle();
                    iVar.f13870b.add(hVar);
                    if (hVar.getPathName() != null) {
                        fVar.put(hVar.getPathName(), hVar);
                    }
                    mVar3.f13901a |= hVar.f13884d;
                    z5 = false;
                    i5 = 1;
                    z8 = false;
                } else {
                    lVar = lVar3;
                    if ("clip-path".equals(name)) {
                        g gVar = new g();
                        if (I.u(xmlPullParser, "pathData")) {
                            TypedArray typedArrayZ3 = I.z(resources, theme, attributeSet, AbstractC0811a.f13843d);
                            String string4 = typedArrayZ3.getString(0);
                            if (string4 != null) {
                                gVar.f13882b = string4;
                            }
                            String string5 = typedArrayZ3.getString(1);
                            if (string5 != null) {
                                gVar.f13881a = J.q(string5);
                            }
                            gVar.f13883c = !I.u(xmlPullParser, "fillType") ? 0 : typedArrayZ3.getInt(2, 0);
                            typedArrayZ3.recycle();
                        }
                        iVar.f13870b.add(gVar);
                        if (gVar.getPathName() != null) {
                            fVar.put(gVar.getPathName(), gVar);
                        }
                        mVar3.f13901a = gVar.f13884d | mVar3.f13901a;
                    } else if ("group".equals(name)) {
                        i iVar2 = new i();
                        TypedArray typedArrayZ4 = I.z(resources, theme, attributeSet, AbstractC0811a.f13841b);
                        float f13 = iVar2.f13871c;
                        if (I.u(xmlPullParser, "rotation")) {
                            f13 = typedArrayZ4.getFloat(5, f13);
                        }
                        iVar2.f13871c = f13;
                        i5 = 1;
                        iVar2.f13872d = typedArrayZ4.getFloat(1, iVar2.f13872d);
                        iVar2.f13873e = typedArrayZ4.getFloat(2, iVar2.f13873e);
                        float f14 = iVar2.f13874f;
                        if (I.u(xmlPullParser, "scaleX")) {
                            f14 = typedArrayZ4.getFloat(3, f14);
                        }
                        iVar2.f13874f = f14;
                        float f15 = iVar2.f13875g;
                        if (I.u(xmlPullParser, "scaleY")) {
                            f15 = typedArrayZ4.getFloat(4, f15);
                        }
                        iVar2.f13875g = f15;
                        float f16 = iVar2.f13876h;
                        if (I.u(xmlPullParser, "translateX")) {
                            f16 = typedArrayZ4.getFloat(6, f16);
                        }
                        iVar2.f13876h = f16;
                        float f17 = iVar2.f13877i;
                        if (I.u(xmlPullParser, "translateY")) {
                            f17 = typedArrayZ4.getFloat(7, f17);
                        }
                        iVar2.f13877i = f17;
                        z5 = false;
                        String string6 = typedArrayZ4.getString(0);
                        if (string6 != null) {
                            iVar2.f13880l = string6;
                        }
                        iVar2.c();
                        typedArrayZ4.recycle();
                        iVar.f13870b.add(iVar2);
                        arrayDeque.push(iVar2);
                        if (iVar2.getGroupName() != null) {
                            fVar.put(iVar2.getGroupName(), iVar2);
                        }
                        mVar3.f13901a = iVar2.f13879k | mVar3.f13901a;
                    }
                    z5 = false;
                    i5 = 1;
                }
                z4 = z5;
                i6 = 3;
            } else {
                lVar = lVar3;
                i4 = depth;
                i5 = i9;
                z4 = z6;
                i6 = 3;
                if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                    arrayDeque.pop();
                }
            }
            eventType = xmlPullParser.next();
            i8 = i6;
            z6 = z4;
            i9 = i5;
            depth = i4;
            lVar3 = lVar;
        }
        if (z8) {
            throw new XmlPullParserException("no path defined");
        }
        this.f13916c = a(mVar.f13903c, mVar.f13904d);
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        Drawable drawable = this.f13857a;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        Drawable drawable = this.f13857a;
        return drawable != null ? drawable.isAutoMirrored() : this.f13915b.f13905e;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList colorStateList;
        Drawable drawable = this.f13857a;
        if (drawable != null) {
            return drawable.isStateful();
        }
        if (!super.isStateful()) {
            m mVar = this.f13915b;
            if (mVar != null) {
                l lVar = mVar.f13902b;
                if (lVar.f13899n == null) {
                    lVar.f13899n = Boolean.valueOf(lVar.f13892g.a());
                }
                if (lVar.f13899n.booleanValue() || ((colorStateList = this.f13915b.f13903c) != null && colorStateList.isStateful())) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        Drawable drawable = this.f13857a;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f13918e && super.mutate() == this) {
            m mVar = this.f13915b;
            m mVar2 = new m();
            mVar2.f13903c = null;
            mVar2.f13904d = f13914j;
            if (mVar != null) {
                mVar2.f13901a = mVar.f13901a;
                l lVar = new l(mVar.f13902b);
                mVar2.f13902b = lVar;
                if (mVar.f13902b.f13890e != null) {
                    lVar.f13890e = new Paint(mVar.f13902b.f13890e);
                }
                if (mVar.f13902b.f13889d != null) {
                    mVar2.f13902b.f13889d = new Paint(mVar.f13902b.f13889d);
                }
                mVar2.f13903c = mVar.f13903c;
                mVar2.f13904d = mVar.f13904d;
                mVar2.f13905e = mVar.f13905e;
            }
            this.f13915b = mVar2;
            this.f13918e = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.f13857a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        boolean z4;
        PorterDuff.Mode mode;
        Drawable drawable = this.f13857a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        m mVar = this.f13915b;
        ColorStateList colorStateList = mVar.f13903c;
        if (colorStateList == null || (mode = mVar.f13904d) == null) {
            z4 = false;
        } else {
            this.f13916c = a(colorStateList, mode);
            invalidateSelf();
            z4 = true;
        }
        l lVar = mVar.f13902b;
        if (lVar.f13899n == null) {
            lVar.f13899n = Boolean.valueOf(lVar.f13892g.a());
        }
        if (lVar.f13899n.booleanValue()) {
            boolean zB = mVar.f13902b.f13892g.b(iArr);
            mVar.f13911k |= zB;
            if (zB) {
                invalidateSelf();
                return true;
            }
        }
        return z4;
    }

    @Override // android.graphics.drawable.Drawable
    public final void scheduleSelf(Runnable runnable, long j4) {
        Drawable drawable = this.f13857a;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j4);
        } else {
            super.scheduleSelf(runnable, j4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i4) {
        Drawable drawable = this.f13857a;
        if (drawable != null) {
            drawable.setAlpha(i4);
        } else if (this.f13915b.f13902b.getRootAlpha() != i4) {
            this.f13915b.f13902b.setRootAlpha(i4);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z4) {
        Drawable drawable = this.f13857a;
        if (drawable != null) {
            drawable.setAutoMirrored(z4);
        } else {
            this.f13915b.f13905e = z4;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f13857a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f13917d = colorFilter;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i4) {
        Drawable drawable = this.f13857a;
        if (drawable != null) {
            com.airbnb.lottie.h.F(drawable, i4);
        } else {
            setTintList(ColorStateList.valueOf(i4));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f13857a;
        if (drawable != null) {
            E.a.h(drawable, colorStateList);
            return;
        }
        m mVar = this.f13915b;
        if (mVar.f13903c != colorStateList) {
            mVar.f13903c = colorStateList;
            this.f13916c = a(colorStateList, mVar.f13904d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f13857a;
        if (drawable != null) {
            E.a.i(drawable, mode);
            return;
        }
        m mVar = this.f13915b;
        if (mVar.f13904d != mode) {
            mVar.f13904d = mode;
            this.f13916c = a(mVar.f13903c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z4, boolean z5) {
        Drawable drawable = this.f13857a;
        return drawable != null ? drawable.setVisible(z4, z5) : super.setVisible(z4, z5);
    }

    @Override // android.graphics.drawable.Drawable
    public final void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f13857a;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    public o(m mVar) {
        this.f13919f = true;
        this.f13920g = new float[9];
        this.f13921h = new Matrix();
        this.f13922i = new Rect();
        this.f13915b = mVar;
        this.f13916c = a(mVar.f13903c, mVar.f13904d);
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.f13857a;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }
}
