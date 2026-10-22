package N1;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class m {
    public static Drawable a(Context context, String str) {
        try {
            Object objA = h.c("android.content.res.stepostheme.StepOSThemeUtils").a("getCustomRes", Context.class, String.class).a(null, context, str);
            if (objA instanceof Drawable) {
                return (Drawable) objA;
            }
            return null;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e6) {
            Log.w("ThemeUtil", "reflect method#getCustomRes has an error:" + e6);
            return null;
        }
    }
}
