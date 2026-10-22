package W2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
import android.util.Xml;
import androidx.appcompat.R$styleable;
import io.ktor.http.ContentType;
import s0.h;

/* loaded from: classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public final ColorStateList f6605a;

    /* renamed from: b, reason: collision with root package name */
    public final ColorStateList f6606b;

    /* renamed from: c, reason: collision with root package name */
    public final ColorStateList f6607c;

    /* renamed from: d, reason: collision with root package name */
    public final String f6608d;

    /* renamed from: e, reason: collision with root package name */
    public String f6609e;

    /* renamed from: f, reason: collision with root package name */
    public final int f6610f;

    /* renamed from: g, reason: collision with root package name */
    public final int f6611g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f6612h;

    /* renamed from: i, reason: collision with root package name */
    public final float f6613i;

    /* renamed from: j, reason: collision with root package name */
    public final float f6614j;

    /* renamed from: k, reason: collision with root package name */
    public final float f6615k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f6616l;

    /* renamed from: m, reason: collision with root package name */
    public final float f6617m;

    /* renamed from: n, reason: collision with root package name */
    public ColorStateList f6618n;

    /* renamed from: o, reason: collision with root package name */
    public float f6619o;

    /* renamed from: p, reason: collision with root package name */
    public final int f6620p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f6621q = false;

    /* renamed from: r, reason: collision with root package name */
    public boolean f6622r = false;

    /* renamed from: s, reason: collision with root package name */
    public Typeface f6623s;

    public class a extends h.f {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f6624a;

        public a(f fVar) {
            this.f6624a = fVar;
        }

        @Override // s0.h.f
        public void f(int i10) {
            d.this.f6621q = true;
            this.f6624a.a(i10);
        }

        @Override // s0.h.f
        public void g(Typeface typeface) {
            d dVar = d.this;
            dVar.f6623s = Typeface.create(typeface, dVar.f6610f);
            d.this.f6621q = true;
            this.f6624a.b(d.this.f6623s, false);
        }
    }

    public class b extends f {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f6626a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TextPaint f6627b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ f f6628c;

        public b(Context context, TextPaint textPaint, f fVar) {
            this.f6626a = context;
            this.f6627b = textPaint;
            this.f6628c = fVar;
        }

        @Override // W2.f
        public void a(int i10) {
            this.f6628c.a(i10);
        }

        @Override // W2.f
        public void b(Typeface typeface, boolean z10) {
            d.this.r(this.f6626a, this.f6627b, typeface);
            this.f6628c.b(typeface, z10);
        }
    }

    public d(Context context, int i10) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i10, R$styleable.TextAppearance);
        o(typedArrayObtainStyledAttributes.getDimension(R$styleable.TextAppearance_android_textSize, 0.0f));
        n(c.a(context, typedArrayObtainStyledAttributes, R$styleable.TextAppearance_android_textColor));
        this.f6605a = c.a(context, typedArrayObtainStyledAttributes, R$styleable.TextAppearance_android_textColorHint);
        this.f6606b = c.a(context, typedArrayObtainStyledAttributes, R$styleable.TextAppearance_android_textColorLink);
        this.f6610f = typedArrayObtainStyledAttributes.getInt(R$styleable.TextAppearance_android_textStyle, 0);
        this.f6611g = typedArrayObtainStyledAttributes.getInt(R$styleable.TextAppearance_android_typeface, 1);
        int iF = c.f(typedArrayObtainStyledAttributes, R$styleable.TextAppearance_fontFamily, R$styleable.TextAppearance_android_fontFamily);
        this.f6620p = typedArrayObtainStyledAttributes.getResourceId(iF, 0);
        this.f6608d = typedArrayObtainStyledAttributes.getString(iF);
        this.f6612h = typedArrayObtainStyledAttributes.getBoolean(R$styleable.TextAppearance_textAllCaps, false);
        this.f6607c = c.a(context, typedArrayObtainStyledAttributes, R$styleable.TextAppearance_android_shadowColor);
        this.f6613i = typedArrayObtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowDx, 0.0f);
        this.f6614j = typedArrayObtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowDy, 0.0f);
        this.f6615k = typedArrayObtainStyledAttributes.getFloat(R$styleable.TextAppearance_android_shadowRadius, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(i10, com.google.android.material.R$styleable.MaterialTextAppearance);
        int i11 = com.google.android.material.R$styleable.MaterialTextAppearance_android_letterSpacing;
        this.f6616l = typedArrayObtainStyledAttributes2.hasValue(i11);
        this.f6617m = typedArrayObtainStyledAttributes2.getFloat(i11, 0.0f);
        this.f6609e = typedArrayObtainStyledAttributes2.getString(c.f(typedArrayObtainStyledAttributes2, com.google.android.material.R$styleable.MaterialTextAppearance_fontVariationSettings, com.google.android.material.R$styleable.MaterialTextAppearance_android_fontVariationSettings));
        typedArrayObtainStyledAttributes2.recycle();
    }

    @SuppressLint({"ResourceType"})
    public static String m(Context context, int i10) {
        Resources resources = context.getResources();
        if (i10 != 0 && resources.getResourceTypeName(i10).equals(ContentType.Font.TYPE)) {
            try {
                XmlResourceParser xml = resources.getXml(i10);
                while (xml.getEventType() != 1) {
                    if (xml.getEventType() == 2 && xml.getName().equals("font-family")) {
                        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xml), androidx.core.R$styleable.FontFamily);
                        String string = typedArrayObtainAttributes.getString(androidx.core.R$styleable.FontFamily_fontProviderSystemFontFamily);
                        typedArrayObtainAttributes.recycle();
                        return string;
                    }
                    xml.next();
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public final void d() {
        String str;
        if (this.f6623s == null && (str = this.f6608d) != null) {
            this.f6623s = Typeface.create(str, this.f6610f);
        }
        if (this.f6623s == null) {
            int i10 = this.f6611g;
            if (i10 == 1) {
                this.f6623s = Typeface.SANS_SERIF;
            } else if (i10 == 2) {
                this.f6623s = Typeface.SERIF;
            } else if (i10 != 3) {
                this.f6623s = Typeface.DEFAULT;
            } else {
                this.f6623s = Typeface.MONOSPACE;
            }
            this.f6623s = Typeface.create(this.f6623s, this.f6610f);
        }
    }

    public Typeface e() {
        d();
        return this.f6623s;
    }

    public Typeface f(Context context) {
        if (this.f6621q) {
            return this.f6623s;
        }
        if (!context.isRestricted()) {
            try {
                Typeface typefaceH = h.h(context, this.f6620p);
                this.f6623s = typefaceH;
                if (typefaceH != null) {
                    this.f6623s = Typeface.create(typefaceH, this.f6610f);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e10) {
                Log.d("TextAppearance", "Error loading font " + this.f6608d, e10);
            }
        }
        d();
        this.f6621q = true;
        return this.f6623s;
    }

    public void g(Context context, f fVar) {
        if (!l(context)) {
            d();
        }
        int i10 = this.f6620p;
        if (i10 == 0) {
            this.f6621q = true;
        }
        if (this.f6621q) {
            fVar.b(this.f6623s, true);
            return;
        }
        try {
            h.j(context, i10, new a(fVar), null);
        } catch (Resources.NotFoundException unused) {
            this.f6621q = true;
            fVar.a(1);
        } catch (Exception e10) {
            Log.d("TextAppearance", "Error loading font " + this.f6608d, e10);
            this.f6621q = true;
            fVar.a(-3);
        }
    }

    public void h(Context context, TextPaint textPaint, f fVar) {
        r(context, textPaint, e());
        g(context, new b(context, textPaint, fVar));
    }

    public final Typeface i(Context context) {
        Typeface typefaceCreate;
        if (this.f6622r) {
            return null;
        }
        this.f6622r = true;
        String strM = m(context, this.f6620p);
        if (strM == null || (typefaceCreate = Typeface.create(strM, 0)) == Typeface.DEFAULT) {
            return null;
        }
        return Typeface.create(typefaceCreate, this.f6610f);
    }

    public ColorStateList j() {
        return this.f6618n;
    }

    public float k() {
        return this.f6619o;
    }

    public final boolean l(Context context) throws Resources.NotFoundException {
        if (e.a()) {
            f(context);
            return true;
        }
        if (this.f6621q) {
            return true;
        }
        int i10 = this.f6620p;
        if (i10 == 0) {
            return false;
        }
        Typeface typefaceC = h.c(context, i10);
        if (typefaceC != null) {
            this.f6623s = typefaceC;
            this.f6621q = true;
            return true;
        }
        Typeface typefaceI = i(context);
        if (typefaceI == null) {
            return false;
        }
        this.f6623s = typefaceI;
        this.f6621q = true;
        return true;
    }

    public void n(ColorStateList colorStateList) {
        this.f6618n = colorStateList;
    }

    public void o(float f10) {
        this.f6619o = f10;
    }

    public void p(Context context, TextPaint textPaint, f fVar) {
        q(context, textPaint, fVar);
        ColorStateList colorStateList = this.f6618n;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        float f10 = this.f6615k;
        float f11 = this.f6613i;
        float f12 = this.f6614j;
        ColorStateList colorStateList2 = this.f6607c;
        textPaint.setShadowLayer(f10, f11, f12, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public void q(Context context, TextPaint textPaint, f fVar) {
        Typeface typeface;
        if (l(context) && this.f6621q && (typeface = this.f6623s) != null) {
            r(context, textPaint, typeface);
        } else {
            h(context, textPaint, fVar);
        }
    }

    public void r(Context context, TextPaint textPaint, Typeface typeface) {
        Typeface typefaceA = g.a(context, typeface);
        if (typefaceA != null) {
            typeface = typefaceA;
        }
        textPaint.setTypeface(typeface);
        int i10 = this.f6610f & (~typeface.getStyle());
        textPaint.setFakeBoldText((i10 & 1) != 0);
        textPaint.setTextSkewX((i10 & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.f6619o);
        textPaint.setFontVariationSettings(this.f6609e);
        if (this.f6616l) {
            textPaint.setLetterSpacing(this.f6617m);
        }
    }
}
