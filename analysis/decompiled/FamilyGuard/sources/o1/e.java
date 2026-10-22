package o1;

import P.j;
import a1.C0418k;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.animation.AnimationUtils;
import android.view.animation.PathInterpolator;
import q1.C0980b;

/* loaded from: classes.dex */
public class e {
    private static float a(String[] strArr, int i5) throws NumberFormatException {
        float f5 = Float.parseFloat(strArr[i5]);
        if (f5 >= 0.0f && f5 <= 1.0f) {
            return f5;
        }
        throw new IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + f5);
    }

    private static String b(String str, String str2) {
        return str.substring(str2.length() + 1, str.length() - 1);
    }

    private static TimeInterpolator c(String str) {
        if (!e(str, "cubic-bezier")) {
            if (e(str, "path")) {
                return new PathInterpolator(androidx.core.graphics.d.e(b(str, "path")));
            }
            throw new IllegalArgumentException("Invalid motion easing type: " + str);
        }
        String[] strArrSplit = b(str, "cubic-bezier").split(",");
        if (strArrSplit.length == 4) {
            return new PathInterpolator(a(strArrSplit, 0), a(strArrSplit, 1), a(strArrSplit, 2), a(strArrSplit, 3));
        }
        throw new IllegalArgumentException("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: " + strArrSplit.length);
    }

    private static boolean d(String str) {
        return e(str, "cubic-bezier") || e(str, "path");
    }

    private static boolean e(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append("(");
        return str.startsWith(sb.toString()) && str.endsWith(")");
    }

    public static int f(Context context, int i5, int i6) {
        return C0980b.d(context, i5, i6);
    }

    public static TimeInterpolator g(Context context, int i5, TimeInterpolator timeInterpolator) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i5, typedValue, true)) {
            return timeInterpolator;
        }
        if (typedValue.type != 3) {
            throw new IllegalArgumentException("Motion easing theme attribute must be an @interpolator resource for ?attr/motionEasing*Interpolator attributes or a string for ?attr/motionEasing* attributes.");
        }
        String strValueOf = String.valueOf(typedValue.string);
        return d(strValueOf) ? c(strValueOf) : AnimationUtils.loadInterpolator(context, typedValue.resourceId);
    }

    public static j h(Context context, int i5, int i6) {
        TypedValue typedValueA = C0980b.a(context, i5);
        TypedArray typedArrayObtainStyledAttributes = typedValueA == null ? context.obtainStyledAttributes(null, C0418k.f7196q3, 0, i6) : context.obtainStyledAttributes(typedValueA.resourceId, C0418k.f7196q3);
        j jVar = new j();
        try {
            float f5 = typedArrayObtainStyledAttributes.getFloat(C0418k.f7208s3, Float.MIN_VALUE);
            if (f5 == Float.MIN_VALUE) {
                throw new IllegalArgumentException("A MaterialSpring style must have stiffness value.");
            }
            float f6 = typedArrayObtainStyledAttributes.getFloat(C0418k.f7202r3, Float.MIN_VALUE);
            if (f6 == Float.MIN_VALUE) {
                throw new IllegalArgumentException("A MaterialSpring style must have a damping value.");
            }
            jVar.h(f5);
            jVar.f(f6);
            return jVar;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}
