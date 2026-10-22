package r1;

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
import k4.v;
import k4.z;
import w.j;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final ColorStateList f5072a;

    /* renamed from: b, reason: collision with root package name */
    public final String f5073b;

    /* renamed from: c, reason: collision with root package name */
    public final String f5074c;
    public final int d;

    /* renamed from: e, reason: collision with root package name */
    public final int f5075e;

    /* renamed from: f, reason: collision with root package name */
    public final float f5076f;

    /* renamed from: g, reason: collision with root package name */
    public final float f5077g;

    /* renamed from: h, reason: collision with root package name */
    public final float f5078h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f5079i;

    /* renamed from: j, reason: collision with root package name */
    public final float f5080j;

    /* renamed from: k, reason: collision with root package name */
    public final ColorStateList f5081k;

    /* renamed from: l, reason: collision with root package name */
    public float f5082l;

    /* renamed from: m, reason: collision with root package name */
    public final int f5083m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f5084n = false;

    /* renamed from: o, reason: collision with root package name */
    public boolean f5085o = false;

    /* renamed from: p, reason: collision with root package name */
    public Typeface f5086p;

    public d(Context context, int i8) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i8, c.a.f1030r);
        this.f5082l = typedArrayObtainStyledAttributes.getDimension(0, 0.0f);
        this.f5081k = v.D(context, typedArrayObtainStyledAttributes, 3);
        v.D(context, typedArrayObtainStyledAttributes, 4);
        v.D(context, typedArrayObtainStyledAttributes, 5);
        this.d = typedArrayObtainStyledAttributes.getInt(2, 0);
        this.f5075e = typedArrayObtainStyledAttributes.getInt(1, 1);
        int i9 = typedArrayObtainStyledAttributes.hasValue(12) ? 12 : 10;
        this.f5083m = typedArrayObtainStyledAttributes.getResourceId(i9, 0);
        this.f5073b = typedArrayObtainStyledAttributes.getString(i9);
        typedArrayObtainStyledAttributes.getBoolean(14, false);
        this.f5072a = v.D(context, typedArrayObtainStyledAttributes, 6);
        this.f5076f = typedArrayObtainStyledAttributes.getFloat(7, 0.0f);
        this.f5077g = typedArrayObtainStyledAttributes.getFloat(8, 0.0f);
        this.f5078h = typedArrayObtainStyledAttributes.getFloat(9, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(i8, d1.a.f1773o);
        this.f5079i = typedArrayObtainStyledAttributes2.hasValue(0);
        this.f5080j = typedArrayObtainStyledAttributes2.getFloat(0, 0.0f);
        this.f5074c = typedArrayObtainStyledAttributes2.getString(typedArrayObtainStyledAttributes2.hasValue(3) ? 3 : 1);
        typedArrayObtainStyledAttributes2.recycle();
    }

    public final void a() {
        String str;
        Typeface typeface = this.f5086p;
        int i8 = this.d;
        if (typeface == null && (str = this.f5073b) != null) {
            this.f5086p = Typeface.create(str, i8);
        }
        if (this.f5086p == null) {
            int i9 = this.f5075e;
            if (i9 == 1) {
                this.f5086p = Typeface.SANS_SERIF;
            } else if (i9 == 2) {
                this.f5086p = Typeface.SERIF;
            } else if (i9 != 3) {
                this.f5086p = Typeface.DEFAULT;
            } else {
                this.f5086p = Typeface.MONOSPACE;
            }
            this.f5086p = Typeface.create(this.f5086p, i8);
        }
    }

    public final void b(Context context, z zVar) {
        if (!c(context)) {
            a();
        }
        int i8 = this.f5083m;
        if (i8 == 0) {
            this.f5084n = true;
        }
        if (this.f5084n) {
            zVar.A(this.f5086p, true);
            return;
        }
        try {
            b bVar = new b(this, zVar);
            ThreadLocal threadLocal = j.f6061a;
            if (context.isRestricted()) {
                bVar.a(-4);
            } else {
                j.a(context, i8, new TypedValue(), 0, bVar, false, false);
            }
        } catch (Resources.NotFoundException unused) {
            this.f5084n = true;
            zVar.z(1);
        } catch (Exception e9) {
            Log.d("TextAppearance", "Error loading font " + this.f5073b, e9);
            this.f5084n = true;
            zVar.z(-3);
        }
    }

    public final boolean c(Context context) throws Throwable {
        Context context2;
        Typeface typefaceA;
        String string;
        Typeface typefaceCreate;
        if (this.f5084n) {
            return true;
        }
        int i8 = this.f5083m;
        if (i8 != 0) {
            ThreadLocal threadLocal = j.f6061a;
            Typeface typefaceCreate2 = null;
            if (context.isRestricted()) {
                context2 = context;
                typefaceA = null;
            } else {
                context2 = context;
                typefaceA = j.a(context2, i8, new TypedValue(), 0, null, false, true);
            }
            if (typefaceA != null) {
                this.f5086p = typefaceA;
                this.f5084n = true;
                return true;
            }
            if (!this.f5085o) {
                this.f5085o = true;
                Resources resources = context2.getResources();
                int i9 = this.f5083m;
                if (i9 == 0 || !resources.getResourceTypeName(i9).equals("font")) {
                    string = null;
                    if (string != null && (typefaceCreate = Typeface.create(string, 0)) != Typeface.DEFAULT) {
                        typefaceCreate2 = Typeface.create(typefaceCreate, this.d);
                    }
                } else {
                    try {
                        XmlResourceParser xml = resources.getXml(i9);
                        while (xml.getEventType() != 1) {
                            if (xml.getEventType() == 2 && xml.getName().equals("font-family")) {
                                TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xml), u.a.f5613b);
                                string = typedArrayObtainAttributes.getString(7);
                                typedArrayObtainAttributes.recycle();
                                break;
                            }
                            xml.next();
                        }
                    } catch (Throwable unused) {
                    }
                    string = null;
                    if (string != null) {
                        typefaceCreate2 = Typeface.create(typefaceCreate, this.d);
                    }
                }
            }
            if (typefaceCreate2 != null) {
                this.f5086p = typefaceCreate2;
                this.f5084n = true;
                return true;
            }
        }
        return false;
    }

    public final void d(Context context, TextPaint textPaint, z zVar) {
        e(context, textPaint, zVar);
        ColorStateList colorStateList = this.f5081k;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        ColorStateList colorStateList2 = this.f5072a;
        textPaint.setShadowLayer(this.f5078h, this.f5076f, this.f5077g, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public final void e(Context context, TextPaint textPaint, z zVar) {
        Typeface typeface;
        if (c(context) && this.f5084n && (typeface = this.f5086p) != null) {
            f(context, textPaint, typeface);
            return;
        }
        a();
        f(context, textPaint, this.f5086p);
        b(context, new c(this, context, textPaint, zVar));
    }

    public final void f(Context context, TextPaint textPaint, Typeface typeface) {
        Typeface typefaceB0 = v.b0(context.getResources().getConfiguration(), typeface);
        if (typefaceB0 != null) {
            typeface = typefaceB0;
        }
        textPaint.setTypeface(typeface);
        int i8 = (~typeface.getStyle()) & this.d;
        textPaint.setFakeBoldText((i8 & 1) != 0);
        textPaint.setTextSkewX((i8 & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.f5082l);
        textPaint.setFontVariationSettings(this.f5074c);
        if (this.f5079i) {
            textPaint.setLetterSpacing(this.f5080j);
        }
    }
}
