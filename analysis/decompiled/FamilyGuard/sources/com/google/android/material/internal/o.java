package com.google.android.material.internal;

import a1.C0409b;
import a1.C0418k;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.widget.a0;
import g.C0728a;
import q1.C0980b;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f13040a = {C0728a.f16805B};

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f13041b = {C0409b.f6719f};

    public static void a(Context context) {
        e(context, f13040a, "Theme.AppCompat");
    }

    private static void b(Context context, AttributeSet attributeSet, int i5, int i6) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0418k.f6, i5, i6);
        boolean z5 = typedArrayObtainStyledAttributes.getBoolean(C0418k.h6, false);
        typedArrayObtainStyledAttributes.recycle();
        if (z5) {
            TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(C0409b.f6726m, typedValue, true) || (typedValue.type == 18 && typedValue.data == 0)) {
                c(context);
            }
        }
        a(context);
    }

    public static void c(Context context) {
        e(context, f13041b, "Theme.MaterialComponents");
    }

    private static void d(Context context, AttributeSet attributeSet, int[] iArr, int i5, int i6, int... iArr2) {
        boolean zF;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0418k.f6, i5, i6);
        if (!typedArrayObtainStyledAttributes.getBoolean(C0418k.i6, false)) {
            typedArrayObtainStyledAttributes.recycle();
            return;
        }
        if (iArr2 == null || iArr2.length == 0) {
            zF = typedArrayObtainStyledAttributes.getResourceId(C0418k.g6, -1) != -1;
        } else {
            zF = f(context, attributeSet, iArr, i5, i6, iArr2);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!zF) {
            throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
        }
    }

    private static void e(Context context, int[] iArr, String str) {
        if (h(context, iArr)) {
            return;
        }
        throw new IllegalArgumentException("The style on this component requires your app theme to be " + str + " (or a descendant).");
    }

    private static boolean f(Context context, AttributeSet attributeSet, int[] iArr, int i5, int i6, int... iArr2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i5, i6);
        for (int i7 : iArr2) {
            if (typedArrayObtainStyledAttributes.getResourceId(i7, -1) == -1) {
                typedArrayObtainStyledAttributes.recycle();
                return false;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        return true;
    }

    public static boolean g(Context context) {
        return C0980b.b(context, C0409b.f6725l, false);
    }

    private static boolean h(Context context, int[] iArr) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iArr);
        for (int i5 = 0; i5 < iArr.length; i5++) {
            if (!typedArrayObtainStyledAttributes.hasValue(i5)) {
                typedArrayObtainStyledAttributes.recycle();
                return false;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        return true;
    }

    public static TypedArray i(Context context, AttributeSet attributeSet, int[] iArr, int i5, int i6, int... iArr2) {
        b(context, attributeSet, i5, i6);
        d(context, attributeSet, iArr, i5, i6, iArr2);
        return context.obtainStyledAttributes(attributeSet, iArr, i5, i6);
    }

    public static a0 j(Context context, AttributeSet attributeSet, int[] iArr, int i5, int i6, int... iArr2) {
        b(context, attributeSet, i5, i6);
        d(context, attributeSet, iArr, i5, i6, iArr2);
        return a0.v(context, attributeSet, iArr, i5, i6);
    }
}
