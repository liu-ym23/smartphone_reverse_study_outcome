package T2;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.animation.AnimationUtils;
import android.view.animation.PathInterpolator;
import androidx.dynamicanimation.animation.j;
import com.autonavi.aps.amapapi.config.Const;
import com.google.android.material.R$styleable;

/* loaded from: classes2.dex */
public class h {
    public static float a(String[] strArr, int i10) throws NumberFormatException {
        float f10 = Float.parseFloat(strArr[i10]);
        if (f10 >= 0.0f && f10 <= 1.0f) {
            return f10;
        }
        throw new IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + f10);
    }

    public static String b(String str, String str2) {
        return str.substring(str2.length() + 1, str.length() - 1);
    }

    public static TimeInterpolator c(String str) {
        if (!e(str, "cubic-bezier")) {
            if (e(str, "path")) {
                return new PathInterpolator(t0.g.e(b(str, "path")));
            }
            throw new IllegalArgumentException("Invalid motion easing type: " + str);
        }
        String[] strArrSplit = b(str, "cubic-bezier").split(Const.STR_MART_COMMA);
        if (strArrSplit.length == 4) {
            return new PathInterpolator(a(strArrSplit, 0), a(strArrSplit, 1), a(strArrSplit, 2), a(strArrSplit, 3));
        }
        throw new IllegalArgumentException("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: " + strArrSplit.length);
    }

    public static boolean d(String str) {
        return e(str, "cubic-bezier") || e(str, "path");
    }

    public static boolean e(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        sb2.append("(");
        return str.startsWith(sb2.toString()) && str.endsWith(")");
    }

    public static int f(Context context, int i10, int i11) {
        return W2.b.d(context, i10, i11);
    }

    public static TimeInterpolator g(Context context, int i10, TimeInterpolator timeInterpolator) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i10, typedValue, true)) {
            return timeInterpolator;
        }
        if (typedValue.type != 3) {
            throw new IllegalArgumentException("Motion easing theme attribute must be an @interpolator resource for ?attr/motionEasing*Interpolator attributes or a string for ?attr/motionEasing* attributes.");
        }
        String strValueOf = String.valueOf(typedValue.string);
        return d(strValueOf) ? c(strValueOf) : AnimationUtils.loadInterpolator(context, typedValue.resourceId);
    }

    public static j h(Context context, int i10, int i11) {
        TypedValue typedValueA = W2.b.a(context, i10);
        TypedArray typedArrayObtainStyledAttributes = typedValueA == null ? context.obtainStyledAttributes(null, R$styleable.MaterialSpring, 0, i11) : context.obtainStyledAttributes(typedValueA.resourceId, R$styleable.MaterialSpring);
        j jVar = new j();
        try {
            float f10 = typedArrayObtainStyledAttributes.getFloat(R$styleable.MaterialSpring_stiffness, Float.MIN_VALUE);
            if (f10 == Float.MIN_VALUE) {
                throw new IllegalArgumentException("A MaterialSpring style must have stiffness value.");
            }
            float f11 = typedArrayObtainStyledAttributes.getFloat(R$styleable.MaterialSpring_damping, Float.MIN_VALUE);
            if (f11 == Float.MIN_VALUE) {
                throw new IllegalArgumentException("A MaterialSpring style must have a damping value.");
            }
            jVar.h(f10);
            jVar.f(f11);
            return jVar;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}
