package u4;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Path;
import android.util.TypedValue;
import android.view.animation.AnimationUtils;
import android.view.animation.PathInterpolator;
import com.stepos.core.ability.converter.BundleContentBridge;
import n0.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class j {
    public static float a(String[] strArr, int i10) throws NumberFormatException {
        float f8 = Float.parseFloat(strArr[i10]);
        if (f8 >= 0.0f && f8 <= 1.0f) {
            return f8;
        }
        throw new IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + f8);
    }

    public static boolean b(String str, String str2) {
        return str.startsWith(str2.concat("(")) && str.endsWith(")");
    }

    public static int c(Context context, int i10, int i11) {
        TypedValue typedValueA = w4.b.a(i10, context);
        return (typedValueA == null || typedValueA.type != 16) ? i11 : typedValueA.data;
    }

    public static TimeInterpolator d(Context context, int i10, TimeInterpolator timeInterpolator) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i10, typedValue, true)) {
            return timeInterpolator;
        }
        if (typedValue.type != 3) {
            throw new IllegalArgumentException("Motion easing theme attribute must be an @interpolator resource for ?attr/motionEasing*Interpolator attributes or a string for ?attr/motionEasing* attributes.");
        }
        String strValueOf = String.valueOf(typedValue.string);
        if (!b(strValueOf, "cubic-bezier") && !b(strValueOf, BundleContentBridge.KEY_PATH)) {
            return AnimationUtils.loadInterpolator(context, typedValue.resourceId);
        }
        if (b(strValueOf, "cubic-bezier")) {
            String[] strArrSplit = strValueOf.substring(13, strValueOf.length() - 1).split(",");
            if (strArrSplit.length == 4) {
                return new PathInterpolator(a(strArrSplit, 0), a(strArrSplit, 1), a(strArrSplit, 2), a(strArrSplit, 3));
            }
            throw new IllegalArgumentException("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: " + strArrSplit.length);
        }
        if (!b(strValueOf, BundleContentBridge.KEY_PATH)) {
            throw new IllegalArgumentException("Invalid motion easing type: ".concat(strValueOf));
        }
        String strSubstring = strValueOf.substring(5, strValueOf.length() - 1);
        Path path = new Path();
        try {
            d.a.b(n0.d.b(strSubstring), path);
            return new PathInterpolator(path);
        } catch (RuntimeException e10) {
            throw new RuntimeException("Error in parsing ".concat(strSubstring), e10);
        }
    }
}
