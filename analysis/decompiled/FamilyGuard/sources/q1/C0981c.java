package q1;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.appcompat.widget.a0;
import h.C0744a;

/* renamed from: q1.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0981c {
    public static ColorStateList a(Context context, TypedArray typedArray, int i5) {
        int resourceId;
        ColorStateList colorStateListA;
        return (!typedArray.hasValue(i5) || (resourceId = typedArray.getResourceId(i5, 0)) == 0 || (colorStateListA = C0744a.a(context, resourceId)) == null) ? typedArray.getColorStateList(i5) : colorStateListA;
    }

    public static ColorStateList b(Context context, a0 a0Var, int i5) {
        int iN;
        ColorStateList colorStateListA;
        return (!a0Var.s(i5) || (iN = a0Var.n(i5, 0)) == 0 || (colorStateListA = C0744a.a(context, iN)) == null) ? a0Var.c(i5) : colorStateListA;
    }

    public static int c(Context context, TypedArray typedArray, int i5, int i6) {
        TypedValue typedValue = new TypedValue();
        if (!typedArray.getValue(i5, typedValue) || typedValue.type != 2) {
            return typedArray.getDimensionPixelSize(i5, i6);
        }
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, i6);
        typedArrayObtainStyledAttributes.recycle();
        return dimensionPixelSize;
    }

    public static Drawable d(Context context, TypedArray typedArray, int i5) {
        int resourceId;
        Drawable drawableB;
        return (!typedArray.hasValue(i5) || (resourceId = typedArray.getResourceId(i5, 0)) == 0 || (drawableB = C0744a.b(context, resourceId)) == null) ? typedArray.getDrawable(i5) : drawableB;
    }

    static int e(TypedArray typedArray, int i5, int i6) {
        return typedArray.hasValue(i5) ? i5 : i6;
    }

    public static C0982d f(Context context, TypedArray typedArray, int i5) {
        int resourceId;
        if (!typedArray.hasValue(i5) || (resourceId = typedArray.getResourceId(i5, 0)) == 0) {
            return null;
        }
        return new C0982d(context, resourceId);
    }

    public static boolean g(Context context) {
        return context.getResources().getConfiguration().fontScale >= 1.3f;
    }

    public static boolean h(Context context) {
        return context.getResources().getConfiguration().fontScale >= 2.0f;
    }
}
