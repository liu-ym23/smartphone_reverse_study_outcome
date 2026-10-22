package w1;

import B0.f;
import C.o;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import com.stepos.alphame.utils.Property;
import f1.AbstractC0557a;
import g.AbstractC0560a;
import m1.AbstractC0769a;

/* renamed from: w1.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0973d {

    /* renamed from: a, reason: collision with root package name */
    public final ColorStateList f15813a;

    /* renamed from: b, reason: collision with root package name */
    public final String f15814b;

    /* renamed from: c, reason: collision with root package name */
    public final String f15815c;

    /* renamed from: d, reason: collision with root package name */
    public final int f15816d;

    /* renamed from: e, reason: collision with root package name */
    public final int f15817e;

    /* renamed from: f, reason: collision with root package name */
    public final float f15818f;

    /* renamed from: g, reason: collision with root package name */
    public final float f15819g;

    /* renamed from: h, reason: collision with root package name */
    public final float f15820h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f15821i;

    /* renamed from: j, reason: collision with root package name */
    public final float f15822j;

    /* renamed from: k, reason: collision with root package name */
    public final ColorStateList f15823k;

    /* renamed from: l, reason: collision with root package name */
    public float f15824l;

    /* renamed from: m, reason: collision with root package name */
    public final int f15825m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f15826n = false;

    /* renamed from: o, reason: collision with root package name */
    public boolean f15827o = false;

    /* renamed from: p, reason: collision with root package name */
    public Typeface f15828p;

    public C0973d(Context context, int i4) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i4, AbstractC0560a.f12610w);
        this.f15824l = typedArrayObtainStyledAttributes.getDimension(0, Property.DEFAULT_FLOAT_VALUE);
        this.f15823k = f.y(context, typedArrayObtainStyledAttributes, 3);
        f.y(context, typedArrayObtainStyledAttributes, 4);
        f.y(context, typedArrayObtainStyledAttributes, 5);
        this.f15816d = typedArrayObtainStyledAttributes.getInt(2, 0);
        this.f15817e = typedArrayObtainStyledAttributes.getInt(1, 1);
        int i5 = typedArrayObtainStyledAttributes.hasValue(12) ? 12 : 10;
        this.f15825m = typedArrayObtainStyledAttributes.getResourceId(i5, 0);
        this.f15814b = typedArrayObtainStyledAttributes.getString(i5);
        typedArrayObtainStyledAttributes.getBoolean(14, false);
        this.f15813a = f.y(context, typedArrayObtainStyledAttributes, 6);
        this.f15818f = typedArrayObtainStyledAttributes.getFloat(7, Property.DEFAULT_FLOAT_VALUE);
        this.f15819g = typedArrayObtainStyledAttributes.getFloat(8, Property.DEFAULT_FLOAT_VALUE);
        this.f15820h = typedArrayObtainStyledAttributes.getFloat(9, Property.DEFAULT_FLOAT_VALUE);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(i4, AbstractC0769a.f13558x);
        this.f15821i = typedArrayObtainStyledAttributes2.hasValue(0);
        this.f15822j = typedArrayObtainStyledAttributes2.getFloat(0, Property.DEFAULT_FLOAT_VALUE);
        this.f15815c = typedArrayObtainStyledAttributes2.getString(typedArrayObtainStyledAttributes2.hasValue(3) ? 3 : 1);
        typedArrayObtainStyledAttributes2.recycle();
    }

    public final void a() {
        String str;
        Typeface typeface = this.f15828p;
        int i4 = this.f15816d;
        if (typeface == null && (str = this.f15814b) != null) {
            this.f15828p = Typeface.create(str, i4);
        }
        if (this.f15828p == null) {
            int i5 = this.f15817e;
            if (i5 == 1) {
                this.f15828p = Typeface.SANS_SERIF;
            } else if (i5 == 2) {
                this.f15828p = Typeface.SERIF;
            } else if (i5 != 3) {
                this.f15828p = Typeface.DEFAULT;
            } else {
                this.f15828p = Typeface.MONOSPACE;
            }
            this.f15828p = Typeface.create(this.f15828p, i4);
        }
    }

    public final void b(Context context, AbstractC0557a abstractC0557a) {
        if (!c(context)) {
            a();
        }
        int i4 = this.f15825m;
        if (i4 == 0) {
            this.f15826n = true;
        }
        if (this.f15826n) {
            abstractC0557a.P(this.f15828p, true);
            return;
        }
        try {
            C0971b c0971b = new C0971b(this, abstractC0557a);
            ThreadLocal threadLocal = o.f272a;
            if (context.isRestricted()) {
                c0971b.a(-4);
            } else {
                o.a(context, i4, new TypedValue(), 0, c0971b, false, false);
            }
        } catch (Resources.NotFoundException unused) {
            this.f15826n = true;
            abstractC0557a.O(1);
        } catch (Exception e4) {
            Log.d("TextAppearance", "Error loading font " + this.f15814b, e4);
            this.f15826n = true;
            abstractC0557a.O(-3);
        }
    }

    public final boolean c(Context context) {
        String string;
        Typeface typefaceCreate;
        if (this.f15826n) {
            return true;
        }
        int i4 = this.f15825m;
        if (i4 == 0) {
            return false;
        }
        ThreadLocal threadLocal = o.f272a;
        Typeface typefaceCreate2 = null;
        Typeface typefaceA = context.isRestricted() ? null : o.a(context, i4, new TypedValue(), 0, null, false, true);
        if (typefaceA != null) {
            this.f15828p = typefaceA;
            this.f15826n = true;
            return true;
        }
        if (!this.f15827o) {
            this.f15827o = true;
            Resources resources = context.getResources();
            int i5 = this.f15825m;
            if (i5 == 0 || !resources.getResourceTypeName(i5).equals("font")) {
                string = null;
                if (string != null && (typefaceCreate = Typeface.create(string, 0)) != Typeface.DEFAULT) {
                    typefaceCreate2 = Typeface.create(typefaceCreate, this.f15816d);
                }
            } else {
                try {
                    XmlResourceParser xml = resources.getXml(i5);
                    while (xml.getEventType() != 1) {
                        if (xml.getEventType() == 2 && xml.getName().equals("font-family")) {
                            TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xml), B.a.f128b);
                            string = typedArrayObtainAttributes.getString(6);
                            typedArrayObtainAttributes.recycle();
                            break;
                        }
                        xml.next();
                    }
                } catch (Throwable unused) {
                }
                string = null;
                if (string != null) {
                    typefaceCreate2 = Typeface.create(typefaceCreate, this.f15816d);
                }
            }
        }
        if (typefaceCreate2 == null) {
            return false;
        }
        this.f15828p = typefaceCreate2;
        this.f15826n = true;
        return true;
    }

    public final void d(Context context, TextPaint textPaint, AbstractC0557a abstractC0557a) {
        e(context, textPaint, abstractC0557a);
        ColorStateList colorStateList = this.f15823k;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        ColorStateList colorStateList2 = this.f15813a;
        textPaint.setShadowLayer(this.f15820h, this.f15818f, this.f15819g, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public final void e(Context context, TextPaint textPaint, AbstractC0557a abstractC0557a) {
        Typeface typeface;
        if (c(context) && this.f15826n && (typeface = this.f15828p) != null) {
            f(context, textPaint, typeface);
            return;
        }
        a();
        f(context, textPaint, this.f15828p);
        b(context, new C0972c(this, context, textPaint, abstractC0557a));
    }

    public final void f(Context context, TextPaint textPaint, Typeface typeface) {
        Typeface typefaceD = com.stepos.statsrpk.c.D(context.getResources().getConfiguration(), typeface);
        if (typefaceD != null) {
            typeface = typefaceD;
        }
        textPaint.setTypeface(typeface);
        int i4 = (~typeface.getStyle()) & this.f15816d;
        textPaint.setFakeBoldText((i4 & 1) != 0);
        textPaint.setTextSkewX((i4 & 2) != 0 ? -0.25f : Property.DEFAULT_FLOAT_VALUE);
        textPaint.setTextSize(this.f15824l);
        textPaint.setFontVariationSettings(this.f15815c);
        if (this.f15821i) {
            textPaint.setLetterSpacing(this.f15822j);
        }
    }
}
