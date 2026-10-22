package g;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.TextView;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class d0 {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f2676a;

    /* renamed from: b, reason: collision with root package name */
    public s1 f2677b;

    /* renamed from: c, reason: collision with root package name */
    public s1 f2678c;
    public s1 d;

    /* renamed from: e, reason: collision with root package name */
    public s1 f2679e;

    /* renamed from: f, reason: collision with root package name */
    public s1 f2680f;

    /* renamed from: g, reason: collision with root package name */
    public s1 f2681g;

    /* renamed from: h, reason: collision with root package name */
    public s1 f2682h;

    /* renamed from: i, reason: collision with root package name */
    public final k0 f2683i;

    /* renamed from: j, reason: collision with root package name */
    public int f2684j = 0;

    /* renamed from: k, reason: collision with root package name */
    public int f2685k = -1;

    /* renamed from: l, reason: collision with root package name */
    public Typeface f2686l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f2687m;

    public d0(TextView textView) {
        this.f2676a = textView;
        this.f2683i = new k0(textView);
    }

    public static s1 c(Context context, r rVar, int i8) {
        ColorStateList colorStateListF;
        synchronized (rVar) {
            colorStateListF = rVar.f2816a.f(context, i8);
        }
        if (colorStateListF == null) {
            return null;
        }
        s1 s1Var = new s1();
        s1Var.f2823b = true;
        s1Var.f2824c = colorStateListF;
        return s1Var;
    }

    public final void a(Drawable drawable, s1 s1Var) {
        if (drawable == null || s1Var == null) {
            return;
        }
        r.d(drawable, s1Var, this.f2676a.getDrawableState());
    }

    public final void b() {
        s1 s1Var = this.f2677b;
        TextView textView = this.f2676a;
        if (s1Var != null || this.f2678c != null || this.d != null || this.f2679e != null) {
            Drawable[] compoundDrawables = textView.getCompoundDrawables();
            a(compoundDrawables[0], this.f2677b);
            a(compoundDrawables[1], this.f2678c);
            a(compoundDrawables[2], this.d);
            a(compoundDrawables[3], this.f2679e);
        }
        if (this.f2680f == null && this.f2681g == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
        a(compoundDrawablesRelative[0], this.f2680f);
        a(compoundDrawablesRelative[2], this.f2681g);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d(AttributeSet attributeSet, int i8) {
        r rVar;
        boolean z;
        boolean z2;
        String string;
        String string2;
        char c3;
        int i9;
        int i10;
        int i11;
        int i12;
        float dimensionPixelSize;
        ColorStateList colorStateList;
        int resourceId;
        int i13;
        int resourceId2;
        int[] iArr = c.a.f1019g;
        int[] iArr2 = c.a.f1030r;
        k0 k0Var = this.f2683i;
        TextView textView = this.f2676a;
        Context context = textView.getContext();
        PorterDuff.Mode mode = r.f2814b;
        synchronized (r.class) {
            try {
                if (r.f2815c == null) {
                    r.c();
                }
                rVar = r.f2815c;
            } catch (Throwable th) {
                throw th;
            }
        }
        int[] iArr3 = c.a.f1018f;
        a4.d dVarE = a4.d.E(context, attributeSet, iArr3, i8);
        TextView textView2 = this.f2676a;
        Context context2 = textView2.getContext();
        TypedArray typedArray = (TypedArray) dVarE.f97c;
        int[] iArr4 = e0.a0.f2285a;
        e0.y.b(textView2, context2, iArr3, attributeSet, typedArray, i8, 0);
        TypedArray typedArray2 = (TypedArray) dVarE.f97c;
        int resourceId3 = typedArray2.getResourceId(0, -1);
        if (typedArray2.hasValue(3)) {
            this.f2677b = c(context, rVar, typedArray2.getResourceId(3, 0));
        }
        if (typedArray2.hasValue(1)) {
            this.f2678c = c(context, rVar, typedArray2.getResourceId(1, 0));
        }
        if (typedArray2.hasValue(4)) {
            this.d = c(context, rVar, typedArray2.getResourceId(4, 0));
        }
        if (typedArray2.hasValue(2)) {
            this.f2679e = c(context, rVar, typedArray2.getResourceId(2, 0));
        }
        if (typedArray2.hasValue(5)) {
            this.f2680f = c(context, rVar, typedArray2.getResourceId(5, 0));
        }
        if (typedArray2.hasValue(6)) {
            this.f2681g = c(context, rVar, typedArray2.getResourceId(6, 0));
        }
        dVarE.H();
        boolean z8 = textView.getTransformationMethod() instanceof PasswordTransformationMethod;
        if (resourceId3 != -1) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(resourceId3, iArr2);
            a4.d dVar = new a4.d(context, typedArrayObtainStyledAttributes);
            if (z8 || !typedArrayObtainStyledAttributes.hasValue(14)) {
                z = false;
                z2 = false;
            } else {
                z = typedArrayObtainStyledAttributes.getBoolean(14, false);
                z2 = true;
            }
            h(context, dVar);
            string2 = typedArrayObtainStyledAttributes.hasValue(15) ? typedArrayObtainStyledAttributes.getString(15) : null;
            string = typedArrayObtainStyledAttributes.hasValue(13) ? typedArrayObtainStyledAttributes.getString(13) : null;
            dVar.H();
        } else {
            z = false;
            z2 = false;
            string = null;
            string2 = null;
        }
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, i8, 0);
        a4.d dVar2 = new a4.d(context, typedArrayObtainStyledAttributes2);
        if (!z8 && typedArrayObtainStyledAttributes2.hasValue(14)) {
            z = typedArrayObtainStyledAttributes2.getBoolean(14, false);
            z2 = true;
        }
        boolean z9 = z;
        if (typedArrayObtainStyledAttributes2.hasValue(15)) {
            string2 = typedArrayObtainStyledAttributes2.getString(15);
        }
        if (typedArrayObtainStyledAttributes2.hasValue(13)) {
            string = typedArrayObtainStyledAttributes2.getString(13);
        }
        if (typedArrayObtainStyledAttributes2.hasValue(0) && typedArrayObtainStyledAttributes2.getDimensionPixelSize(0, -1) == 0) {
            textView.setTextSize(0, 0.0f);
        }
        h(context, dVar2);
        dVar2.H();
        if (!z8 && z2) {
            this.f2676a.setAllCaps(z9);
        }
        Typeface typeface = this.f2686l;
        if (typeface != null) {
            if (this.f2685k == -1) {
                textView.setTypeface(typeface, this.f2684j);
            } else {
                textView.setTypeface(typeface);
            }
        }
        if (string != null) {
            b0.d(textView, string);
        }
        if (string2 != null) {
            a0.b(textView, a0.a(string2));
        }
        Context context3 = k0Var.f2770h;
        TypedArray typedArrayObtainStyledAttributes3 = context3.obtainStyledAttributes(attributeSet, iArr, i8, 0);
        TextView textView3 = k0Var.f2769g;
        e0.y.b(textView3, textView3.getContext(), iArr, attributeSet, typedArrayObtainStyledAttributes3, i8, 0);
        if (typedArrayObtainStyledAttributes3.hasValue(5)) {
            k0Var.f2764a = typedArrayObtainStyledAttributes3.getInt(5, 0);
        }
        float dimension = typedArrayObtainStyledAttributes3.hasValue(4) ? typedArrayObtainStyledAttributes3.getDimension(4, -1.0f) : -1.0f;
        float dimension2 = typedArrayObtainStyledAttributes3.hasValue(2) ? typedArrayObtainStyledAttributes3.getDimension(2, -1.0f) : -1.0f;
        float dimension3 = typedArrayObtainStyledAttributes3.hasValue(1) ? typedArrayObtainStyledAttributes3.getDimension(1, -1.0f) : -1.0f;
        if (!typedArrayObtainStyledAttributes3.hasValue(3) || (resourceId2 = typedArrayObtainStyledAttributes3.getResourceId(3, 0)) <= 0) {
            c3 = 3;
            i9 = 0;
        } else {
            c3 = 3;
            TypedArray typedArrayObtainTypedArray = typedArrayObtainStyledAttributes3.getResources().obtainTypedArray(resourceId2);
            int length = typedArrayObtainTypedArray.length();
            i9 = 0;
            int[] iArr5 = new int[length];
            if (length > 0) {
                for (int i14 = 0; i14 < length; i14++) {
                    iArr5[i14] = typedArrayObtainTypedArray.getDimensionPixelSize(i14, -1);
                }
                int[] iArrA = k0.a(iArr5);
                k0Var.f2767e = iArrA;
                boolean z10 = iArrA.length > 0;
                k0Var.f2768f = z10;
                if (z10) {
                    k0Var.f2764a = 1;
                    k0Var.f2766c = iArrA[0];
                    k0Var.d = iArrA[r7 - 1];
                    k0Var.f2765b = -1.0f;
                }
            }
            typedArrayObtainTypedArray.recycle();
        }
        typedArrayObtainStyledAttributes3.recycle();
        if (!k0Var.b()) {
            k0Var.f2764a = i9;
        } else if (k0Var.f2764a == 1) {
            if (!k0Var.f2768f) {
                DisplayMetrics displayMetrics = context3.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    i13 = 2;
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                } else {
                    i13 = 2;
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(i13, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                if (dimension2 <= 0.0f) {
                    throw new IllegalArgumentException("Minimum auto-size text size (" + dimension2 + "px) is less or equal to (0px)");
                }
                if (dimension3 <= dimension2) {
                    throw new IllegalArgumentException("Maximum auto-size text size (" + dimension3 + "px) is less or equal to minimum auto-size text size (" + dimension2 + "px)");
                }
                if (dimension <= 0.0f) {
                    throw new IllegalArgumentException("The auto-size step granularity (" + dimension + "px) is less or equal to (0px)");
                }
                k0Var.f2764a = 1;
                k0Var.f2766c = dimension2;
                k0Var.d = dimension3;
                k0Var.f2765b = dimension;
                k0Var.f2768f = i9;
            }
            if (k0Var.b() && k0Var.f2764a == 1 && (!k0Var.f2768f || k0Var.f2767e.length == 0)) {
                int iFloor = ((int) Math.floor((k0Var.d - k0Var.f2766c) / k0Var.f2765b)) + 1;
                int[] iArr6 = new int[iFloor];
                for (int i15 = 0; i15 < iFloor; i15++) {
                    iArr6[i15] = Math.round((i15 * k0Var.f2765b) + k0Var.f2766c);
                }
                k0Var.f2767e = k0.a(iArr6);
            }
        }
        if (k0Var.f2764a != 0) {
            int[] iArr7 = k0Var.f2767e;
            if (iArr7.length > 0) {
                if (b0.a(textView) != -1.0f) {
                    b0.b(textView, Math.round(k0Var.f2766c), Math.round(k0Var.d), Math.round(k0Var.f2765b), 0);
                } else {
                    b0.c(textView, iArr7, 0);
                }
            }
        }
        TypedArray typedArrayObtainStyledAttributes4 = context.obtainStyledAttributes(attributeSet, iArr);
        int resourceId4 = typedArrayObtainStyledAttributes4.getResourceId(8, -1);
        Drawable drawableA = resourceId4 != -1 ? rVar.a(context, resourceId4) : null;
        int resourceId5 = typedArrayObtainStyledAttributes4.getResourceId(13, -1);
        Drawable drawableA2 = resourceId5 != -1 ? rVar.a(context, resourceId5) : null;
        int resourceId6 = typedArrayObtainStyledAttributes4.getResourceId(9, -1);
        Drawable drawableA3 = resourceId6 != -1 ? rVar.a(context, resourceId6) : null;
        int resourceId7 = typedArrayObtainStyledAttributes4.getResourceId(6, -1);
        Drawable drawableA4 = resourceId7 != -1 ? rVar.a(context, resourceId7) : null;
        int resourceId8 = typedArrayObtainStyledAttributes4.getResourceId(10, -1);
        Drawable drawableA5 = resourceId8 != -1 ? rVar.a(context, resourceId8) : null;
        int resourceId9 = typedArrayObtainStyledAttributes4.getResourceId(7, -1);
        Drawable drawableA6 = resourceId9 != -1 ? rVar.a(context, resourceId9) : null;
        if (drawableA5 != null || drawableA6 != null) {
            Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
            if (drawableA5 == null) {
                drawableA5 = compoundDrawablesRelative[0];
            }
            if (drawableA2 == null) {
                drawableA2 = compoundDrawablesRelative[1];
            }
            if (drawableA6 == null) {
                drawableA6 = compoundDrawablesRelative[2];
            }
            if (drawableA4 == null) {
                drawableA4 = compoundDrawablesRelative[c3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawableA5, drawableA2, drawableA6, drawableA4);
        } else if (drawableA != null || drawableA2 != null || drawableA3 != null || drawableA4 != null) {
            Drawable[] compoundDrawablesRelative2 = textView.getCompoundDrawablesRelative();
            Drawable drawable = compoundDrawablesRelative2[0];
            if (drawable == null && compoundDrawablesRelative2[2] == null) {
                Drawable[] compoundDrawables = textView.getCompoundDrawables();
                if (drawableA == null) {
                    drawableA = compoundDrawables[0];
                }
                if (drawableA2 == null) {
                    drawableA2 = compoundDrawables[1];
                }
                if (drawableA3 == null) {
                    drawableA3 = compoundDrawables[2];
                }
                if (drawableA4 == null) {
                    drawableA4 = compoundDrawables[c3];
                }
                textView.setCompoundDrawablesWithIntrinsicBounds(drawableA, drawableA2, drawableA3, drawableA4);
            } else {
                if (drawableA2 == null) {
                    drawableA2 = compoundDrawablesRelative2[1];
                }
                if (drawableA4 == null) {
                    drawableA4 = compoundDrawablesRelative2[c3];
                }
                textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawableA2, compoundDrawablesRelative2[2], drawableA4);
            }
        }
        if (typedArrayObtainStyledAttributes4.hasValue(11)) {
            if (!typedArrayObtainStyledAttributes4.hasValue(11) || (resourceId = typedArrayObtainStyledAttributes4.getResourceId(11, 0)) == 0 || (colorStateList = k4.z.t(context, resourceId)) == null) {
                colorStateList = typedArrayObtainStyledAttributes4.getColorStateList(11);
            }
            textView.setCompoundDrawableTintList(colorStateList);
        }
        if (typedArrayObtainStyledAttributes4.hasValue(12)) {
            i10 = -1;
            textView.setCompoundDrawableTintMode(n0.a(typedArrayObtainStyledAttributes4.getInt(12, -1), null));
        } else {
            i10 = -1;
        }
        int dimensionPixelSize2 = typedArrayObtainStyledAttributes4.getDimensionPixelSize(15, i10);
        int dimensionPixelSize3 = typedArrayObtainStyledAttributes4.getDimensionPixelSize(18, i10);
        if (typedArrayObtainStyledAttributes4.hasValue(19)) {
            TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes4.peekValue(19);
            if (typedValuePeekValue == null || typedValuePeekValue.type != 5) {
                i11 = -1;
                dimensionPixelSize = typedArrayObtainStyledAttributes4.getDimensionPixelSize(19, -1);
                i12 = -1;
            } else {
                int i16 = typedValuePeekValue.data;
                int i17 = i16 & 15;
                dimensionPixelSize = TypedValue.complexToFloat(i16);
                i12 = i17;
                i11 = -1;
            }
        } else {
            i11 = -1;
            i12 = -1;
            dimensionPixelSize = -1.0f;
        }
        typedArrayObtainStyledAttributes4.recycle();
        if (dimensionPixelSize2 != i11) {
            a.a.h(dimensionPixelSize2);
            textView.setFirstBaselineToTopHeight(dimensionPixelSize2);
        }
        if (dimensionPixelSize3 != i11) {
            a.a.h(dimensionPixelSize3);
            Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
            int i18 = textView.getIncludeFontPadding() ? fontMetricsInt.bottom : fontMetricsInt.descent;
            if (dimensionPixelSize3 > Math.abs(i18)) {
                textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), dimensionPixelSize3 - i18);
            }
        }
        if (dimensionPixelSize != -1.0f) {
            if (i12 == -1) {
                b8.h.L(textView, (int) dimensionPixelSize);
            } else if (Build.VERSION.SDK_INT >= 34) {
                e0.p.h(textView, i12, dimensionPixelSize);
            } else {
                b8.h.L(textView, Math.round(TypedValue.applyDimension(i12, dimensionPixelSize, textView.getResources().getDisplayMetrics())));
            }
        }
    }

    public final void e(Context context, int i8) {
        String string;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i8, c.a.f1030r);
        a4.d dVar = new a4.d(context, typedArrayObtainStyledAttributes);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(14);
        TextView textView = this.f2676a;
        if (zHasValue) {
            textView.setAllCaps(typedArrayObtainStyledAttributes.getBoolean(14, false));
        }
        if (typedArrayObtainStyledAttributes.hasValue(0) && typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1) == 0) {
            textView.setTextSize(0, 0.0f);
        }
        h(context, dVar);
        if (typedArrayObtainStyledAttributes.hasValue(13) && (string = typedArrayObtainStyledAttributes.getString(13)) != null) {
            b0.d(textView, string);
        }
        dVar.H();
        Typeface typeface = this.f2686l;
        if (typeface != null) {
            textView.setTypeface(typeface, this.f2684j);
        }
    }

    public final void f(ColorStateList colorStateList) {
        if (this.f2682h == null) {
            this.f2682h = new s1();
        }
        s1 s1Var = this.f2682h;
        s1Var.f2824c = colorStateList;
        s1Var.f2823b = colorStateList != null;
        this.f2677b = s1Var;
        this.f2678c = s1Var;
        this.d = s1Var;
        this.f2679e = s1Var;
        this.f2680f = s1Var;
        this.f2681g = s1Var;
    }

    public final void g(PorterDuff.Mode mode) {
        if (this.f2682h == null) {
            this.f2682h = new s1();
        }
        s1 s1Var = this.f2682h;
        s1Var.d = mode;
        s1Var.f2822a = mode != null;
        this.f2677b = s1Var;
        this.f2678c = s1Var;
        this.d = s1Var;
        this.f2679e = s1Var;
        this.f2680f = s1Var;
        this.f2681g = s1Var;
    }

    public final void h(Context context, a4.d dVar) {
        String string;
        int i8 = this.f2684j;
        TypedArray typedArray = (TypedArray) dVar.f97c;
        this.f2684j = typedArray.getInt(2, i8);
        int i9 = typedArray.getInt(11, -1);
        this.f2685k = i9;
        if (i9 != -1) {
            this.f2684j &= 2;
        }
        if (!typedArray.hasValue(10) && !typedArray.hasValue(12)) {
            if (typedArray.hasValue(1)) {
                this.f2687m = false;
                int i10 = typedArray.getInt(1, 1);
                if (i10 == 1) {
                    this.f2686l = Typeface.SANS_SERIF;
                    return;
                } else if (i10 == 2) {
                    this.f2686l = Typeface.SERIF;
                    return;
                } else {
                    if (i10 != 3) {
                        return;
                    }
                    this.f2686l = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.f2686l = null;
        int i11 = typedArray.hasValue(12) ? 12 : 10;
        int i12 = this.f2685k;
        int i13 = this.f2684j;
        if (!context.isRestricted()) {
            try {
                Typeface typefaceU = dVar.u(i11, this.f2684j, new y(this, i12, i13, new WeakReference(this.f2676a)));
                if (typefaceU != null) {
                    if (this.f2685k != -1) {
                        this.f2686l = c0.a(Typeface.create(typefaceU, 0), this.f2685k, (this.f2684j & 2) != 0);
                    } else {
                        this.f2686l = typefaceU;
                    }
                }
                this.f2687m = this.f2686l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f2686l != null || (string = typedArray.getString(i11)) == null) {
            return;
        }
        if (this.f2685k != -1) {
            this.f2686l = c0.a(Typeface.create(string, 0), this.f2685k, (this.f2684j & 2) != 0);
        } else {
            this.f2686l = Typeface.create(string, this.f2684j);
        }
    }
}
