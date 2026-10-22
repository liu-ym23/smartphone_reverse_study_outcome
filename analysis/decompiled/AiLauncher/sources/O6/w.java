package O6;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes3.dex */
public class w {
    private static final String TAG = "ThemeUtil";

    public static Drawable a(Context context, String str) {
        try {
            Object objA = r.c("android.content.res.stepostheme.StepOSThemeUtils").a("getCustomRes", Context.class, String.class).a(null, context, str);
            if (objA instanceof Drawable) {
                return (Drawable) objA;
            }
            return null;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e10) {
            Log.w(TAG, "reflect method#getCustomRes has an error:" + e10);
            return null;
        }
    }
}
