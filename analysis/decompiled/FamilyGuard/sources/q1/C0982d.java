package q1;

import a1.C0418k;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
import android.util.Xml;
import androidx.core.content.res.h;
import g.j;
import z.C1334f;

/* renamed from: q1.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0982d {

    /* renamed from: a, reason: collision with root package name */
    public final ColorStateList f19885a;

    /* renamed from: b, reason: collision with root package name */
    public final ColorStateList f19886b;

    /* renamed from: c, reason: collision with root package name */
    public final ColorStateList f19887c;

    /* renamed from: d, reason: collision with root package name */
    public final String f19888d;

    /* renamed from: e, reason: collision with root package name */
    public String f19889e;

    /* renamed from: f, reason: collision with root package name */
    public final int f19890f;

    /* renamed from: g, reason: collision with root package name */
    public final int f19891g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f19892h;

    /* renamed from: i, reason: collision with root package name */
    public final float f19893i;

    /* renamed from: j, reason: collision with root package name */
    public final float f19894j;

    /* renamed from: k, reason: collision with root package name */
    public final float f19895k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f19896l;

    /* renamed from: m, reason: collision with root package name */
    public final float f19897m;

    /* renamed from: n, reason: collision with root package name */
    private ColorStateList f19898n;

    /* renamed from: o, reason: collision with root package name */
    private float f19899o;

    /* renamed from: p, reason: collision with root package name */
    private final int f19900p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f19901q = false;

    /* renamed from: r, reason: collision with root package name */
    private boolean f19902r = false;

    /* renamed from: s, reason: collision with root package name */
    private Typeface f19903s;

    /* renamed from: q1.d$a */
    class a extends h.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f19904a;

        a(f fVar) {
            this.f19904a = fVar;
        }

        @Override // androidx.core.content.res.h.e
        public void f(int i5) {
            C0982d.this.f19901q = true;
            this.f19904a.a(i5);
        }

        @Override // androidx.core.content.res.h.e
        public void g(Typeface typeface) {
            C0982d c0982d = C0982d.this;
            c0982d.f19903s = Typeface.create(typeface, c0982d.f19890f);
            C0982d.this.f19901q = true;
            this.f19904a.b(C0982d.this.f19903s, false);
        }
    }

    /* renamed from: q1.d$b */
    class b extends f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f19906a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ TextPaint f19907b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ f f19908c;

        b(Context context, TextPaint textPaint, f fVar) {
            this.f19906a = context;
            this.f19907b = textPaint;
            this.f19908c = fVar;
        }

        @Override // q1.f
        public void a(int i5) {
            this.f19908c.a(i5);
        }

        @Override // q1.f
        public void b(Typeface typeface, boolean z5) {
            C0982d.this.r(this.f19906a, this.f19907b, typeface);
            this.f19908c.b(typeface, z5);
        }
    }

    public C0982d(Context context, int i5) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i5, j.f16995C2);
        o(typedArrayObtainStyledAttributes.getDimension(j.f17000D2, 0.0f));
        n(C0981c.a(context, typedArrayObtainStyledAttributes, j.f17015G2));
        this.f19885a = C0981c.a(context, typedArrayObtainStyledAttributes, j.f17020H2);
        this.f19886b = C0981c.a(context, typedArrayObtainStyledAttributes, j.f17025I2);
        this.f19890f = typedArrayObtainStyledAttributes.getInt(j.f17010F2, 0);
        this.f19891g = typedArrayObtainStyledAttributes.getInt(j.f17005E2, 1);
        int iE = C0981c.e(typedArrayObtainStyledAttributes, j.f17053P2, j.f17045N2);
        this.f19900p = typedArrayObtainStyledAttributes.getResourceId(iE, 0);
        this.f19888d = typedArrayObtainStyledAttributes.getString(iE);
        this.f19892h = typedArrayObtainStyledAttributes.getBoolean(j.f17061R2, false);
        this.f19887c = C0981c.a(context, typedArrayObtainStyledAttributes, j.f17029J2);
        this.f19893i = typedArrayObtainStyledAttributes.getFloat(j.f17033K2, 0.0f);
        this.f19894j = typedArrayObtainStyledAttributes.getFloat(j.f17037L2, 0.0f);
        this.f19895k = typedArrayObtainStyledAttributes.getFloat(j.f17041M2, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(i5, C0418k.f7220u3);
        int i6 = C0418k.f7226v3;
        this.f19896l = typedArrayObtainStyledAttributes2.hasValue(i6);
        this.f19897m = typedArrayObtainStyledAttributes2.getFloat(i6, 0.0f);
        this.f19889e = typedArrayObtainStyledAttributes2.getString(C0981c.e(typedArrayObtainStyledAttributes2, C0418k.f7244y3, C0418k.f7232w3));
        typedArrayObtainStyledAttributes2.recycle();
    }

    private void d() {
        String str;
        if (this.f19903s == null && (str = this.f19888d) != null) {
            this.f19903s = Typeface.create(str, this.f19890f);
        }
        if (this.f19903s == null) {
            int i5 = this.f19891g;
            if (i5 == 1) {
                this.f19903s = Typeface.SANS_SERIF;
            } else if (i5 == 2) {
                this.f19903s = Typeface.SERIF;
            } else if (i5 != 3) {
                this.f19903s = Typeface.DEFAULT;
            } else {
                this.f19903s = Typeface.MONOSPACE;
            }
            this.f19903s = Typeface.create(this.f19903s, this.f19890f);
        }
    }

    private Typeface i(Context context) {
        Typeface typefaceCreate;
        if (this.f19902r) {
            return null;
        }
        this.f19902r = true;
        String strM = m(context, this.f19900p);
        if (strM == null || (typefaceCreate = Typeface.create(strM, 0)) == Typeface.DEFAULT) {
            return null;
        }
        return Typeface.create(typefaceCreate, this.f19890f);
    }

    private boolean l(Context context) {
        if (e.a()) {
            f(context);
            return true;
        }
        if (this.f19901q) {
            return true;
        }
        int i5 = this.f19900p;
        if (i5 == 0) {
            return false;
        }
        Typeface typefaceC = h.c(context, i5);
        if (typefaceC != null) {
            this.f19903s = typefaceC;
            this.f19901q = true;
            return true;
        }
        Typeface typefaceI = i(context);
        if (typefaceI == null) {
            return false;
        }
        this.f19903s = typefaceI;
        this.f19901q = true;
        return true;
    }

    private static String m(Context context, int i5) {
        Resources resources = context.getResources();
        if (i5 != 0 && resources.getResourceTypeName(i5).equals("font")) {
            try {
                XmlResourceParser xml = resources.getXml(i5);
                while (xml.getEventType() != 1) {
                    if (xml.getEventType() == 2 && xml.getName().equals("font-family")) {
                        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xml), C1334f.f24011h);
                        String string = typedArrayObtainAttributes.getString(C1334f.f24018o);
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

    public Typeface e() {
        d();
        return this.f19903s;
    }

    public Typeface f(Context context) {
        if (this.f19901q) {
            return this.f19903s;
        }
        if (!context.isRestricted()) {
            try {
                Typeface typefaceH = h.h(context, this.f19900p);
                this.f19903s = typefaceH;
                if (typefaceH != null) {
                    this.f19903s = Typeface.create(typefaceH, this.f19890f);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e6) {
                Log.d("TextAppearance", "Error loading font " + this.f19888d, e6);
            }
        }
        d();
        this.f19901q = true;
        return this.f19903s;
    }

    public void g(Context context, TextPaint textPaint, f fVar) {
        r(context, textPaint, e());
        h(context, new b(context, textPaint, fVar));
    }

    public void h(Context context, f fVar) {
        if (!l(context)) {
            d();
        }
        int i5 = this.f19900p;
        if (i5 == 0) {
            this.f19901q = true;
        }
        if (this.f19901q) {
            fVar.b(this.f19903s, true);
            return;
        }
        try {
            h.j(context, i5, new a(fVar), null);
        } catch (Resources.NotFoundException unused) {
            this.f19901q = true;
            fVar.a(1);
        } catch (Exception e6) {
            Log.d("TextAppearance", "Error loading font " + this.f19888d, e6);
            this.f19901q = true;
            fVar.a(-3);
        }
    }

    public ColorStateList j() {
        return this.f19898n;
    }

    public float k() {
        return this.f19899o;
    }

    public void n(ColorStateList colorStateList) {
        this.f19898n = colorStateList;
    }

    public void o(float f5) {
        this.f19899o = f5;
    }

    public void p(Context context, TextPaint textPaint, f fVar) {
        q(context, textPaint, fVar);
        ColorStateList colorStateList = this.f19898n;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        float f5 = this.f19895k;
        float f6 = this.f19893i;
        float f7 = this.f19894j;
        ColorStateList colorStateList2 = this.f19887c;
        textPaint.setShadowLayer(f5, f6, f7, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public void q(Context context, TextPaint textPaint, f fVar) {
        Typeface typeface;
        if (l(context) && this.f19901q && (typeface = this.f19903s) != null) {
            r(context, textPaint, typeface);
        } else {
            g(context, textPaint, fVar);
        }
    }

    public void r(Context context, TextPaint textPaint, Typeface typeface) {
        Typeface typefaceA = g.a(context, typeface);
        if (typefaceA != null) {
            typeface = typefaceA;
        }
        textPaint.setTypeface(typeface);
        int i5 = this.f19890f & (~typeface.getStyle());
        textPaint.setFakeBoldText((i5 & 1) != 0);
        textPaint.setTextSkewX((i5 & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.f19899o);
        textPaint.setFontVariationSettings(this.f19889e);
        if (this.f19896l) {
            textPaint.setLetterSpacing(this.f19897m);
        }
    }
}
