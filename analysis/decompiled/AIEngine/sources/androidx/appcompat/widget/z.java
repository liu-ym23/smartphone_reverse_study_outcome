package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.LocaleList;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import m0.f;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f954a;

    /* renamed from: b, reason: collision with root package name */
    public v0 f955b;

    /* renamed from: c, reason: collision with root package name */
    public v0 f956c;

    /* renamed from: d, reason: collision with root package name */
    public v0 f957d;

    /* renamed from: e, reason: collision with root package name */
    public v0 f958e;

    /* renamed from: f, reason: collision with root package name */
    public v0 f959f;

    /* renamed from: g, reason: collision with root package name */
    public v0 f960g;
    public v0 h;

    /* renamed from: i, reason: collision with root package name */
    public final b0 f961i;

    /* renamed from: j, reason: collision with root package name */
    public int f962j = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f963k = -1;

    /* renamed from: l, reason: collision with root package name */
    public Typeface f964l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f965m;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class b {
        public static LocaleList a(String str) {
            return LocaleList.forLanguageTags(str);
        }

        public static void b(TextView textView, LocaleList localeList) {
            textView.setTextLocales(localeList);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class c {
        public static int a(TextView textView) {
            return textView.getAutoSizeStepGranularity();
        }

        public static void b(TextView textView, int i10, int i11, int i12, int i13) {
            textView.setAutoSizeTextTypeUniformWithConfiguration(i10, i11, i12, i13);
        }

        public static void c(TextView textView, int[] iArr, int i10) {
            textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i10);
        }

        public static boolean d(TextView textView, String str) {
            return textView.setFontVariationSettings(str);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class d {
        public static Typeface a(Typeface typeface, int i10, boolean z) {
            return Typeface.create(typeface, i10, z);
        }
    }

    public z(TextView textView) {
        this.f954a = textView;
        this.f961i = new b0(textView);
    }

    public static v0 c(Context context, j jVar, int i10) {
        ColorStateList colorStateListF;
        synchronized (jVar) {
            colorStateListF = jVar.f848a.f(i10, context);
        }
        if (colorStateListF == null) {
            return null;
        }
        v0 v0Var = new v0();
        v0Var.f940d = true;
        v0Var.f937a = colorStateListF;
        return v0Var;
    }

    public final void a(Drawable drawable, v0 v0Var) {
        if (drawable == null || v0Var == null) {
            return;
        }
        j.e(drawable, v0Var, this.f954a.getDrawableState());
    }

    public final void b() {
        v0 v0Var = this.f955b;
        TextView textView = this.f954a;
        if (v0Var != null || this.f956c != null || this.f957d != null || this.f958e != null) {
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            a(compoundDrawables[0], this.f955b);
            a(compoundDrawables[1], this.f956c);
            a(compoundDrawables[2], this.f957d);
            a(compoundDrawables[3], this.f958e);
        }
        if (this.f959f == null && this.f960g == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
        a(compoundDrawablesRelative[0], this.f959f);
        a(compoundDrawablesRelative[2], this.f960g);
    }

    public final ColorStateList d() {
        v0 v0Var = this.h;
        if (v0Var != null) {
            return v0Var.f937a;
        }
        return null;
    }

    public final PorterDuff.Mode e() {
        v0 v0Var = this.h;
        if (v0Var != null) {
            return v0Var.f938b;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:252:0x044d  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0455  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0485  */
    /* JADX WARN: Removed duplicated region for block: B:270:? A[RETURN, SYNTHETIC] */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(android.util.AttributeSet r28, int r29) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 1168
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.z.f(android.util.AttributeSet, int):void");
    }

    public final void g(int i10, Context context) throws Resources.NotFoundException {
        String string;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i10, g.a.f8941w);
        x0 x0Var = new x0(context, typedArrayObtainStyledAttributes);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(14);
        TextView textView = this.f954a;
        if (zHasValue) {
            textView.setAllCaps(typedArrayObtainStyledAttributes.getBoolean(14, false));
        }
        if (typedArrayObtainStyledAttributes.hasValue(0) && typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1) == 0) {
            textView.setTextSize(0, 0.0f);
        }
        j(context, x0Var);
        if (typedArrayObtainStyledAttributes.hasValue(13) && (string = typedArrayObtainStyledAttributes.getString(13)) != null) {
            c.d(textView, string);
        }
        x0Var.f();
        Typeface typeface = this.f964l;
        if (typeface != null) {
            textView.setTypeface(typeface, this.f962j);
        }
    }

    public final void h(ColorStateList colorStateList) {
        if (this.h == null) {
            this.h = new v0();
        }
        v0 v0Var = this.h;
        v0Var.f937a = colorStateList;
        v0Var.f940d = colorStateList != null;
        this.f955b = v0Var;
        this.f956c = v0Var;
        this.f957d = v0Var;
        this.f958e = v0Var;
        this.f959f = v0Var;
        this.f960g = v0Var;
    }

    public final void i(PorterDuff.Mode mode) {
        if (this.h == null) {
            this.h = new v0();
        }
        v0 v0Var = this.h;
        v0Var.f938b = mode;
        v0Var.f939c = mode != null;
        this.f955b = v0Var;
        this.f956c = v0Var;
        this.f957d = v0Var;
        this.f958e = v0Var;
        this.f959f = v0Var;
        this.f960g = v0Var;
    }

    public final void j(Context context, x0 x0Var) {
        String string;
        int i10 = this.f962j;
        TypedArray typedArray = x0Var.f948b;
        this.f962j = typedArray.getInt(2, i10);
        int i11 = typedArray.getInt(11, -1);
        this.f963k = i11;
        if (i11 != -1) {
            this.f962j &= 2;
        }
        if (!typedArray.hasValue(10) && !typedArray.hasValue(12)) {
            if (typedArray.hasValue(1)) {
                this.f965m = false;
                int i12 = typedArray.getInt(1, 1);
                if (i12 == 1) {
                    this.f964l = Typeface.SANS_SERIF;
                    return;
                } else if (i12 == 2) {
                    this.f964l = Typeface.SERIF;
                    return;
                } else {
                    if (i12 != 3) {
                        return;
                    }
                    this.f964l = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.f964l = null;
        int i13 = typedArray.hasValue(12) ? 12 : 10;
        int i14 = this.f963k;
        int i15 = this.f962j;
        if (!context.isRestricted()) {
            try {
                Typeface typefaceD = x0Var.d(i13, this.f962j, new a(i14, i15, new WeakReference(this.f954a)));
                if (typefaceD != null) {
                    if (this.f963k != -1) {
                        this.f964l = d.a(Typeface.create(typefaceD, 0), this.f963k, (this.f962j & 2) != 0);
                    } else {
                        this.f964l = typefaceD;
                    }
                }
                this.f965m = this.f964l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f964l != null || (string = typedArray.getString(i13)) == null) {
            return;
        }
        if (this.f963k != -1) {
            this.f964l = d.a(Typeface.create(string, 0), this.f963k, (this.f962j & 2) != 0);
        } else {
            this.f964l = Typeface.create(string, this.f962j);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends f.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f966a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f967b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ WeakReference f968c;

        public a(int i10, int i11, WeakReference weakReference) {
            this.f966a = i10;
            this.f967b = i11;
            this.f968c = weakReference;
        }

        @Override // m0.f.c
        public final void c(Typeface typeface) {
            int i10 = this.f966a;
            if (i10 != -1) {
                typeface = d.a(typeface, i10, (this.f967b & 2) != 0);
            }
            z zVar = z.this;
            if (zVar.f965m) {
                zVar.f964l = typeface;
                TextView textView = (TextView) this.f968c.get();
                if (textView != null) {
                    if (textView.isAttachedToWindow()) {
                        textView.post(new a0(textView, typeface, zVar.f962j));
                    } else {
                        textView.setTypeface(typeface, zVar.f962j);
                    }
                }
            }
        }

        @Override // m0.f.c
        public final void b(int i10) {
        }
    }
}
