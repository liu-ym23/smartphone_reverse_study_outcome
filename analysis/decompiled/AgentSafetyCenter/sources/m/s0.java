package m;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import java.lang.invoke.VarHandle;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class s0 {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f8063a;

    /* renamed from: b, reason: collision with root package name */
    public ad.h f8064b;

    /* renamed from: c, reason: collision with root package name */
    public ad.h f8065c;

    /* renamed from: d, reason: collision with root package name */
    public ad.h f8066d;

    /* renamed from: e, reason: collision with root package name */
    public ad.h f8067e;

    /* renamed from: f, reason: collision with root package name */
    public ad.h f8068f;

    /* renamed from: g, reason: collision with root package name */
    public ad.h f8069g;

    /* renamed from: h, reason: collision with root package name */
    public ad.h f8070h;
    public final z0 i;

    /* renamed from: j, reason: collision with root package name */
    public int f8071j = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f8072k = -1;

    /* renamed from: l, reason: collision with root package name */
    public Typeface f8073l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f8074m;

    public s0(TextView textView) {
        this.f8063a = textView;
        z0 z0Var = new z0();
        z0Var.f8143a = 0;
        z0Var.f8144b = -1.0f;
        z0Var.f8145c = -1.0f;
        z0Var.f8146d = -1.0f;
        z0Var.f8147e = new int[0];
        z0Var.f8148f = false;
        z0Var.f8149g = textView;
        z0Var.f8150h = textView.getContext();
        new x0();
        VarHandle.storeStoreFence();
        this.i = z0Var;
    }

    public static ad.h c(Context context, s sVar, int i) {
        ColorStateList colorStateListG;
        synchronized (sVar) {
            colorStateListG = sVar.f8062a.g(i, context);
        }
        if (colorStateListG == null) {
            return null;
        }
        ad.h hVar = new ad.h();
        hVar.f508b = true;
        hVar.f509c = colorStateListG;
        return hVar;
    }

    public final void a(Drawable drawable, ad.h hVar) {
        if (drawable == null || hVar == null) {
            return;
        }
        s.d(drawable, hVar, this.f8063a.getDrawableState());
    }

    public final void b() {
        ad.h hVar = this.f8064b;
        TextView textView = this.f8063a;
        if (hVar != null || this.f8065c != null || this.f8066d != null || this.f8067e != null) {
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            a(compoundDrawables[0], this.f8064b);
            a(compoundDrawables[1], this.f8065c);
            a(compoundDrawables[2], this.f8066d);
            a(compoundDrawables[3], this.f8067e);
        }
        if (this.f8068f == null && this.f8069g == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
        a(compoundDrawablesRelative[0], this.f8068f);
        a(compoundDrawablesRelative[2], this.f8069g);
    }

    public final ColorStateList d() {
        ad.h hVar = this.f8070h;
        if (hVar != null) {
            return (ColorStateList) hVar.f509c;
        }
        return null;
    }

    public final PorterDuff.Mode e() {
        ad.h hVar = this.f8070h;
        if (hVar != null) {
            return (PorterDuff.Mode) hVar.f510d;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0451  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x045d  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0491  */
    /* JADX WARN: Removed duplicated region for block: B:280:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(android.util.AttributeSet r28, int r29) {
        /*
            Method dump skipped, instructions count: 1206
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m.s0.f(android.util.AttributeSet, int):void");
    }

    public final void g(int i, Context context) {
        String string;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, g.a.f4119w);
        p5.m mVar = new p5.m(context, typedArrayObtainStyledAttributes);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(14);
        TextView textView = this.f8063a;
        if (zHasValue) {
            textView.setAllCaps(typedArrayObtainStyledAttributes.getBoolean(14, false));
        }
        if (typedArrayObtainStyledAttributes.hasValue(0) && typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1) == 0) {
            textView.setTextSize(0, 0.0f);
        }
        j(context, mVar);
        if (typedArrayObtainStyledAttributes.hasValue(13) && (string = typedArrayObtainStyledAttributes.getString(13)) != null) {
            q0.d(textView, string);
        }
        mVar.M();
        Typeface typeface = this.f8073l;
        if (typeface != null) {
            textView.setTypeface(typeface, this.f8071j);
        }
    }

    public final void h(ColorStateList colorStateList) {
        if (this.f8070h == null) {
            this.f8070h = new ad.h();
        }
        ad.h hVar = this.f8070h;
        hVar.f509c = colorStateList;
        hVar.f508b = colorStateList != null;
        this.f8064b = hVar;
        this.f8065c = hVar;
        this.f8066d = hVar;
        this.f8067e = hVar;
        this.f8068f = hVar;
        this.f8069g = hVar;
    }

    public final void i(PorterDuff.Mode mode) {
        if (this.f8070h == null) {
            this.f8070h = new ad.h();
        }
        ad.h hVar = this.f8070h;
        hVar.f510d = mode;
        hVar.f507a = mode != null;
        this.f8064b = hVar;
        this.f8065c = hVar;
        this.f8066d = hVar;
        this.f8067e = hVar;
        this.f8068f = hVar;
        this.f8069g = hVar;
    }

    public final void j(Context context, p5.m mVar) {
        String string;
        int i = this.f8071j;
        TypedArray typedArray = (TypedArray) mVar.f9742g;
        this.f8071j = typedArray.getInt(2, i);
        int i3 = typedArray.getInt(11, -1);
        this.f8072k = i3;
        if (i3 != -1) {
            this.f8071j &= 2;
        }
        if (!typedArray.hasValue(10) && !typedArray.hasValue(12)) {
            if (typedArray.hasValue(1)) {
                this.f8074m = false;
                int i10 = typedArray.getInt(1, 1);
                if (i10 == 1) {
                    this.f8073l = Typeface.SANS_SERIF;
                    return;
                } else if (i10 == 2) {
                    this.f8073l = Typeface.SERIF;
                    return;
                } else {
                    if (i10 != 3) {
                        return;
                    }
                    this.f8073l = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.f8073l = null;
        int i11 = typedArray.hasValue(12) ? 12 : 10;
        int i12 = this.f8072k;
        int i13 = this.f8071j;
        if (!context.isRestricted()) {
            WeakReference weakReference = new WeakReference(this.f8063a);
            o0 o0Var = new o0();
            o0Var.f8026d = this;
            o0Var.f8023a = i12;
            o0Var.f8024b = i13;
            o0Var.f8025c = weakReference;
            VarHandle.storeStoreFence();
            try {
                Typeface typefaceC = mVar.C(i11, this.f8071j, o0Var);
                if (typefaceC != null) {
                    if (this.f8072k != -1) {
                        this.f8073l = r0.a(Typeface.create(typefaceC, 0), this.f8072k, (this.f8071j & 2) != 0);
                    } else {
                        this.f8073l = typefaceC;
                    }
                }
                this.f8074m = this.f8073l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f8073l != null || (string = typedArray.getString(i11)) == null) {
            return;
        }
        if (this.f8072k != -1) {
            this.f8073l = r0.a(Typeface.create(string, 0), this.f8072k, (this.f8071j & 2) != 0);
        } else {
            this.f8073l = Typeface.create(string, this.f8071j);
        }
    }
}
