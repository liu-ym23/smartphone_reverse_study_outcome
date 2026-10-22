package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.stepos.alphame.utils.Property;
import g.AbstractC0560a;
import java.lang.ref.WeakReference;

/* renamed from: androidx.appcompat.widget.b0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0192b0 {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f3055a;

    /* renamed from: b, reason: collision with root package name */
    public X0 f3056b;

    /* renamed from: c, reason: collision with root package name */
    public X0 f3057c;

    /* renamed from: d, reason: collision with root package name */
    public X0 f3058d;

    /* renamed from: e, reason: collision with root package name */
    public X0 f3059e;

    /* renamed from: f, reason: collision with root package name */
    public X0 f3060f;

    /* renamed from: g, reason: collision with root package name */
    public X0 f3061g;

    /* renamed from: h, reason: collision with root package name */
    public X0 f3062h;

    /* renamed from: i, reason: collision with root package name */
    public final C0208j0 f3063i;

    /* renamed from: j, reason: collision with root package name */
    public int f3064j = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f3065k = -1;

    /* renamed from: l, reason: collision with root package name */
    public Typeface f3066l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f3067m;

    public C0192b0(TextView textView) {
        this.f3055a = textView;
        this.f3063i = new C0208j0(textView);
    }

    public static X0 c(Context context, A a4, int i4) {
        ColorStateList colorStateListH;
        synchronized (a4) {
            colorStateListH = a4.f2723a.h(i4, context);
        }
        if (colorStateListH == null) {
            return null;
        }
        X0 x02 = new X0();
        x02.f3045d = true;
        x02.f3042a = colorStateListH;
        return x02;
    }

    public final void a(Drawable drawable, X0 x02) {
        if (drawable == null || x02 == null) {
            return;
        }
        A.d(drawable, x02, this.f3055a.getDrawableState());
    }

    public final void b() {
        X0 x02 = this.f3056b;
        TextView textView = this.f3055a;
        if (x02 != null || this.f3057c != null || this.f3058d != null || this.f3059e != null) {
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            a(compoundDrawables[0], this.f3056b);
            a(compoundDrawables[1], this.f3057c);
            a(compoundDrawables[2], this.f3058d);
            a(compoundDrawables[3], this.f3059e);
        }
        if (this.f3060f == null && this.f3061g == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
        a(compoundDrawablesRelative[0], this.f3060f);
        a(compoundDrawablesRelative[2], this.f3061g);
    }

    public final ColorStateList d() {
        X0 x02 = this.f3062h;
        if (x02 != null) {
            return x02.f3042a;
        }
        return null;
    }

    public final PorterDuff.Mode e() {
        X0 x02 = this.f3062h;
        if (x02 != null) {
            return x02.f3043b;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:216:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:236:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(android.util.AttributeSet r24, int r25) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 1005
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0192b0.f(android.util.AttributeSet, int):void");
    }

    public final void g(int i4, Context context) {
        String strS;
        android.support.v4.media.session.c cVar = new android.support.v4.media.session.c(context, context.obtainStyledAttributes(i4, AbstractC0560a.f12610w));
        boolean zV = cVar.v(14);
        TextView textView = this.f3055a;
        if (zV) {
            textView.setAllCaps(cVar.g(14, false));
        }
        if (cVar.v(0) && cVar.j(0, -1) == 0) {
            textView.setTextSize(0, Property.DEFAULT_FLOAT_VALUE);
        }
        j(context, cVar);
        if (cVar.v(13) && (strS = cVar.s(13)) != null) {
            Z.d(textView, strS);
        }
        cVar.A();
        Typeface typeface = this.f3066l;
        if (typeface != null) {
            textView.setTypeface(typeface, this.f3064j);
        }
    }

    public final void h(ColorStateList colorStateList) {
        if (this.f3062h == null) {
            this.f3062h = new X0();
        }
        X0 x02 = this.f3062h;
        x02.f3042a = colorStateList;
        x02.f3045d = colorStateList != null;
        this.f3056b = x02;
        this.f3057c = x02;
        this.f3058d = x02;
        this.f3059e = x02;
        this.f3060f = x02;
        this.f3061g = x02;
    }

    public final void i(PorterDuff.Mode mode) {
        if (this.f3062h == null) {
            this.f3062h = new X0();
        }
        X0 x02 = this.f3062h;
        x02.f3043b = mode;
        x02.f3044c = mode != null;
        this.f3056b = x02;
        this.f3057c = x02;
        this.f3058d = x02;
        this.f3059e = x02;
        this.f3060f = x02;
        this.f3061g = x02;
    }

    public final void j(Context context, android.support.v4.media.session.c cVar) {
        String strS;
        this.f3064j = cVar.p(2, this.f3064j);
        int iP = cVar.p(11, -1);
        this.f3065k = iP;
        if (iP != -1) {
            this.f3064j &= 2;
        }
        if (!cVar.v(10) && !cVar.v(12)) {
            if (cVar.v(1)) {
                this.f3067m = false;
                int iP2 = cVar.p(1, 1);
                if (iP2 == 1) {
                    this.f3066l = Typeface.SANS_SERIF;
                    return;
                } else if (iP2 == 2) {
                    this.f3066l = Typeface.SERIF;
                    return;
                } else {
                    if (iP2 != 3) {
                        return;
                    }
                    this.f3066l = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.f3066l = null;
        int i4 = cVar.v(12) ? 12 : 10;
        int i5 = this.f3065k;
        int i6 = this.f3064j;
        if (!context.isRestricted()) {
            try {
                Typeface typefaceO = cVar.o(i4, this.f3064j, new W(this, i5, i6, new WeakReference(this.f3055a)));
                if (typefaceO != null) {
                    if (this.f3065k != -1) {
                        this.f3066l = AbstractC0190a0.a(Typeface.create(typefaceO, 0), this.f3065k, (this.f3064j & 2) != 0);
                    } else {
                        this.f3066l = typefaceO;
                    }
                }
                this.f3067m = this.f3066l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f3066l != null || (strS = cVar.s(i4)) == null) {
            return;
        }
        if (this.f3065k != -1) {
            this.f3066l = AbstractC0190a0.a(Typeface.create(strS, 0), this.f3065k, (this.f3064j & 2) != 0);
        } else {
            this.f3066l = Typeface.create(strS, this.f3064j);
        }
    }
}
