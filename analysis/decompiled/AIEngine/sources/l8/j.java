package l8;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class j {
    public static Drawable a(Context context, String str) {
        try {
            Object objA = e.b("android.content.res.stepostheme.StepOSThemeUtils").a("getCustomRes", Context.class, String.class).a(null, context, str);
            if (objA instanceof Drawable) {
                return (Drawable) objA;
            }
            return null;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e10) {
            Log.w("ThemeUtil", "reflect method#getCustomRes has an error:" + e10);
            return null;
        }
    }
}
