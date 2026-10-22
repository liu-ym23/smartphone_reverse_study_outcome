package w4;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.x0;
import androidx.datastore.preferences.protobuf.b1;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c {
    public static ColorStateList a(Context context, TypedArray typedArray, int i10) {
        int resourceId;
        ColorStateList colorStateListB;
        return (!typedArray.hasValue(i10) || (resourceId = typedArray.getResourceId(i10, 0)) == 0 || (colorStateListB = androidx.core.content.a.b(resourceId, context)) == null) ? typedArray.getColorStateList(i10) : colorStateListB;
    }

    public static ColorStateList b(Context context, x0 x0Var, int i10) {
        int resourceId;
        ColorStateList colorStateListB;
        TypedArray typedArray = x0Var.f948b;
        return (!typedArray.hasValue(i10) || (resourceId = typedArray.getResourceId(i10, 0)) == 0 || (colorStateListB = androidx.core.content.a.b(resourceId, context)) == null) ? x0Var.a(i10) : colorStateListB;
    }

    public static Drawable c(Context context, TypedArray typedArray, int i10) {
        int resourceId;
        Drawable drawableL;
        return (!typedArray.hasValue(i10) || (resourceId = typedArray.getResourceId(i10, 0)) == 0 || (drawableL = b1.L(resourceId, context)) == null) ? typedArray.getDrawable(i10) : drawableL;
    }

    public static boolean d(Context context) {
        return context.getResources().getConfiguration().fontScale >= 1.3f;
    }
}
