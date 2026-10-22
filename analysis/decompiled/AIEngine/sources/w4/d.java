package w4;

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
import m0.f;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final ColorStateList f13581a;

    /* renamed from: b, reason: collision with root package name */
    public final String f13582b;

    /* renamed from: c, reason: collision with root package name */
    public final String f13583c;

    /* renamed from: d, reason: collision with root package name */
    public final int f13584d;

    /* renamed from: e, reason: collision with root package name */
    public final int f13585e;

    /* renamed from: f, reason: collision with root package name */
    public final float f13586f;

    /* renamed from: g, reason: collision with root package name */
    public final float f13587g;
    public final float h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f13588i;

    /* renamed from: j, reason: collision with root package name */
    public final float f13589j;

    /* renamed from: k, reason: collision with root package name */
    public final ColorStateList f13590k;

    /* renamed from: l, reason: collision with root package name */
    public float f13591l;

    /* renamed from: m, reason: collision with root package name */
    public final int f13592m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f13593n = false;

    /* renamed from: o, reason: collision with root package name */
    public boolean f13594o = false;

    /* renamed from: p, reason: collision with root package name */
    public Typeface f13595p;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends f.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ androidx.datastore.preferences.protobuf.f f13596a;

        public a(androidx.datastore.preferences.protobuf.f fVar) {
            this.f13596a = fVar;
        }

        @Override // m0.f.c
        public final void b(int i10) {
            d.this.f13593n = true;
            this.f13596a.g(i10);
        }

        @Override // m0.f.c
        public final void c(Typeface typeface) {
            d dVar = d.this;
            dVar.f13595p = Typeface.create(typeface, dVar.f13584d);
            dVar.f13593n = true;
            this.f13596a.h(dVar.f13595p, false);
        }
    }

    public d(Context context, int i10) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i10, g.a.f8941w);
        this.f13591l = typedArrayObtainStyledAttributes.getDimension(0, 0.0f);
        this.f13590k = c.a(context, typedArrayObtainStyledAttributes, 3);
        c.a(context, typedArrayObtainStyledAttributes, 4);
        c.a(context, typedArrayObtainStyledAttributes, 5);
        this.f13584d = typedArrayObtainStyledAttributes.getInt(2, 0);
        this.f13585e = typedArrayObtainStyledAttributes.getInt(1, 1);
        int i11 = typedArrayObtainStyledAttributes.hasValue(12) ? 12 : 10;
        this.f13592m = typedArrayObtainStyledAttributes.getResourceId(i11, 0);
        this.f13582b = typedArrayObtainStyledAttributes.getString(i11);
        typedArrayObtainStyledAttributes.getBoolean(14, false);
        this.f13581a = c.a(context, typedArrayObtainStyledAttributes, 6);
        this.f13586f = typedArrayObtainStyledAttributes.getFloat(7, 0.0f);
        this.f13587g = typedArrayObtainStyledAttributes.getFloat(8, 0.0f);
        this.h = typedArrayObtainStyledAttributes.getFloat(9, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(i10, k4.a.f9918x);
        this.f13588i = typedArrayObtainStyledAttributes2.hasValue(0);
        this.f13589j = typedArrayObtainStyledAttributes2.getFloat(0, 0.0f);
        this.f13583c = typedArrayObtainStyledAttributes2.getString(typedArrayObtainStyledAttributes2.hasValue(3) ? 3 : 1);
        typedArrayObtainStyledAttributes2.recycle();
    }

    public final void a() {
        String str;
        Typeface typeface = this.f13595p;
        int i10 = this.f13584d;
        if (typeface == null && (str = this.f13582b) != null) {
            this.f13595p = Typeface.create(str, i10);
        }
        if (this.f13595p == null) {
            int i11 = this.f13585e;
            if (i11 == 1) {
                this.f13595p = Typeface.SANS_SERIF;
            } else if (i11 == 2) {
                this.f13595p = Typeface.SERIF;
            } else if (i11 != 3) {
                this.f13595p = Typeface.DEFAULT;
            } else {
                this.f13595p = Typeface.MONOSPACE;
            }
            this.f13595p = Typeface.create(this.f13595p, i10);
        }
    }

    public final void b(Context context, androidx.datastore.preferences.protobuf.f fVar) {
        if (!c(context)) {
            a();
        }
        int i10 = this.f13592m;
        if (i10 == 0) {
            this.f13593n = true;
        }
        if (this.f13593n) {
            fVar.h(this.f13595p, true);
            return;
        }
        try {
            a aVar = new a(fVar);
            ThreadLocal<TypedValue> threadLocal = m0.f.f10462a;
            if (context.isRestricted()) {
                aVar.a(-4);
            } else {
                m0.f.b(context, i10, new TypedValue(), 0, aVar, false, false);
            }
        } catch (Resources.NotFoundException unused) {
            this.f13593n = true;
            fVar.g(1);
        } catch (Exception e10) {
            Log.d("TextAppearance", "Error loading font " + this.f13582b, e10);
            this.f13593n = true;
            fVar.g(-3);
        }
    }

    public final boolean c(Context context) throws Exception {
        Context context2;
        Typeface typefaceB;
        String string;
        Typeface typefaceCreate;
        if (this.f13593n) {
            return true;
        }
        int i10 = this.f13592m;
        if (i10 != 0) {
            ThreadLocal<TypedValue> threadLocal = m0.f.f10462a;
            Typeface typefaceCreate2 = null;
            if (context.isRestricted()) {
                context2 = context;
                typefaceB = null;
            } else {
                context2 = context;
                typefaceB = m0.f.b(context2, i10, new TypedValue(), 0, null, false, true);
            }
            if (typefaceB != null) {
                this.f13595p = typefaceB;
                this.f13593n = true;
                return true;
            }
            if (!this.f13594o) {
                this.f13594o = true;
                Resources resources = context2.getResources();
                int i11 = this.f13592m;
                if (i11 == 0 || !resources.getResourceTypeName(i11).equals("font")) {
                    string = null;
                    if (string != null && (typefaceCreate = Typeface.create(string, 0)) != Typeface.DEFAULT) {
                        typefaceCreate2 = Typeface.create(typefaceCreate, this.f13584d);
                    }
                } else {
                    try {
                        XmlResourceParser xml = resources.getXml(i11);
                        while (xml.getEventType() != 1) {
                            if (xml.getEventType() == 2 && xml.getName().equals("font-family")) {
                                TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xml), l0.a.f10182b);
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
                        typefaceCreate2 = Typeface.create(typefaceCreate, this.f13584d);
                    }
                }
            }
            if (typefaceCreate2 != null) {
                this.f13595p = typefaceCreate2;
                this.f13593n = true;
                return true;
            }
        }
        return false;
    }

    public final void d(Context context, TextPaint textPaint, androidx.datastore.preferences.protobuf.f fVar) {
        e(context, textPaint, fVar);
        ColorStateList colorStateList = this.f13590k;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        ColorStateList colorStateList2 = this.f13581a;
        textPaint.setShadowLayer(this.h, this.f13586f, this.f13587g, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public final void e(Context context, TextPaint textPaint, androidx.datastore.preferences.protobuf.f fVar) {
        Typeface typeface;
        if (c(context) && this.f13593n && (typeface = this.f13595p) != null) {
            f(context, textPaint, typeface);
            return;
        }
        a();
        f(context, textPaint, this.f13595p);
        b(context, new e(this, context, textPaint, fVar));
    }

    public final void f(Context context, TextPaint textPaint, Typeface typeface) {
        Typeface typefaceA = f.a(context.getResources().getConfiguration(), typeface);
        if (typefaceA != null) {
            typeface = typefaceA;
        }
        textPaint.setTypeface(typeface);
        int i10 = (~typeface.getStyle()) & this.f13584d;
        textPaint.setFakeBoldText((i10 & 1) != 0);
        textPaint.setTextSkewX((i10 & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.f13591l);
        textPaint.setFontVariationSettings(this.f13583c);
        if (this.f13588i) {
            textPaint.setLetterSpacing(this.f13589j);
        }
    }
}
