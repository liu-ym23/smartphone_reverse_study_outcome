package c3;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
import android.util.Xml;
import androidx.appcompat.R;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;

/* renamed from: c3.f, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0876f {

    /* renamed from: a, reason: collision with root package name */
    public final ColorStateList f2087a;
    public final String b;
    public final String c;
    public final int d;
    public final int e;
    public final float f;
    public final float g;
    public final float h;
    public final boolean i;

    /* renamed from: j, reason: collision with root package name */
    public final float f2088j;
    public ColorStateList k;
    public float l;
    public final int m;
    public boolean n = false;
    public boolean o = false;
    public Typeface p;

    public C0876f(Context context, int i) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, R.styleable.TextAppearance);
        this.l = typedArrayObtainStyledAttributes.getDimension(R.styleable.TextAppearance_android_textSize, 0.0f);
        this.k = AbstractC0873c.a(context, typedArrayObtainStyledAttributes, R.styleable.TextAppearance_android_textColor);
        AbstractC0873c.a(context, typedArrayObtainStyledAttributes, R.styleable.TextAppearance_android_textColorHint);
        AbstractC0873c.a(context, typedArrayObtainStyledAttributes, R.styleable.TextAppearance_android_textColorLink);
        this.d = typedArrayObtainStyledAttributes.getInt(R.styleable.TextAppearance_android_textStyle, 0);
        this.e = typedArrayObtainStyledAttributes.getInt(R.styleable.TextAppearance_android_typeface, 1);
        int i6 = R.styleable.TextAppearance_fontFamily;
        i6 = typedArrayObtainStyledAttributes.hasValue(i6) ? i6 : R.styleable.TextAppearance_android_fontFamily;
        this.m = typedArrayObtainStyledAttributes.getResourceId(i6, 0);
        this.b = typedArrayObtainStyledAttributes.getString(i6);
        typedArrayObtainStyledAttributes.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
        this.f2087a = AbstractC0873c.a(context, typedArrayObtainStyledAttributes, R.styleable.TextAppearance_android_shadowColor);
        this.f = typedArrayObtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDx, 0.0f);
        this.g = typedArrayObtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDy, 0.0f);
        this.h = typedArrayObtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowRadius, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(i, P2.a.y);
        this.i = typedArrayObtainStyledAttributes2.hasValue(0);
        this.f2088j = typedArrayObtainStyledAttributes2.getFloat(0, 0.0f);
        this.c = typedArrayObtainStyledAttributes2.getString(typedArrayObtainStyledAttributes2.hasValue(3) ? 3 : 1);
        typedArrayObtainStyledAttributes2.recycle();
    }

    public final void a() {
        String str;
        Typeface typeface = this.p;
        int i = this.d;
        if (typeface == null && (str = this.b) != null) {
            this.p = Typeface.create(str, i);
        }
        if (this.p == null) {
            int i6 = this.e;
            if (i6 == 1) {
                this.p = Typeface.SANS_SERIF;
            } else if (i6 == 2) {
                this.p = Typeface.SERIF;
            } else if (i6 != 3) {
                this.p = Typeface.DEFAULT;
            } else {
                this.p = Typeface.MONOSPACE;
            }
            this.p = Typeface.create(this.p, i);
        }
    }

    public final void b(Context context, AbstractC0877g abstractC0877g) {
        if (!c(context)) {
            a();
        }
        int i = this.m;
        if (i == 0) {
            this.n = true;
        }
        if (this.n) {
            abstractC0877g.b(this.p, true);
            return;
        }
        try {
            ResourcesCompat.getFont(context, i, new C0874d(this, abstractC0877g), null);
        } catch (Resources.NotFoundException unused) {
            this.n = true;
            abstractC0877g.a(1);
        } catch (Exception e) {
            Log.d("TextAppearance", "Error loading font " + this.b, e);
            this.n = true;
            abstractC0877g.a(-3);
        }
    }

    public final boolean c(Context context) throws Resources.NotFoundException {
        String string;
        Typeface typefaceCreate;
        if (this.n) {
            return true;
        }
        int i = this.m;
        if (i != 0) {
            Typeface cachedFont = ResourcesCompat.getCachedFont(context, i);
            if (cachedFont != null) {
                this.p = cachedFont;
                this.n = true;
                return true;
            }
            Typeface typefaceCreate2 = null;
            if (!this.o) {
                this.o = true;
                Resources resources = context.getResources();
                if (i == 0 || !resources.getResourceTypeName(i).equals("font")) {
                    string = null;
                    if (string != null && (typefaceCreate = Typeface.create(string, 0)) != Typeface.DEFAULT) {
                        typefaceCreate2 = Typeface.create(typefaceCreate, this.d);
                    }
                } else {
                    try {
                        XmlResourceParser xml = resources.getXml(i);
                        while (xml.getEventType() != 1) {
                            if (xml.getEventType() == 2 && xml.getName().equals("font-family")) {
                                TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xml), androidx.core.R.styleable.FontFamily);
                                string = typedArrayObtainAttributes.getString(androidx.core.R.styleable.FontFamily_fontProviderSystemFontFamily);
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
                this.p = typefaceCreate2;
                this.n = true;
                return true;
            }
        }
        return false;
    }

    public final void d(Context context, TextPaint textPaint, AbstractC0877g abstractC0877g) {
        e(context, textPaint, abstractC0877g);
        ColorStateList colorStateList = this.k;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : ViewCompat.MEASURED_STATE_MASK);
        ColorStateList colorStateList2 = this.f2087a;
        textPaint.setShadowLayer(this.h, this.f, this.g, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public final void e(Context context, TextPaint textPaint, AbstractC0877g abstractC0877g) {
        Typeface typeface;
        if (c(context) && this.n && (typeface = this.p) != null) {
            f(context, textPaint, typeface);
            return;
        }
        a();
        f(context, textPaint, this.p);
        b(context, new C0875e(this, context, textPaint, abstractC0877g));
    }

    public final void f(Context context, TextPaint textPaint, Typeface typeface) {
        Typeface typefaceA = h.a(context.getResources().getConfiguration(), typeface);
        if (typefaceA != null) {
            typeface = typefaceA;
        }
        textPaint.setTypeface(typeface);
        int i = (~typeface.getStyle()) & this.d;
        textPaint.setFakeBoldText((i & 1) != 0);
        textPaint.setTextSkewX((i & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.l);
        textPaint.setFontVariationSettings(this.c);
        if (this.i) {
            textPaint.setLetterSpacing(this.f2088j);
        }
    }
}
