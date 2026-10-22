package Hc;

import O6.s;
import android.content.Context;
import android.content.res.Configuration;
import android.util.TypedValue;
import com.stepos.common.R$dimen;
import stepos.support.v7.appcompat.R$attr;

/* loaded from: classes5.dex */
public class f {
    public static int a(Context context) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(O6.c.c() ? R$attr.steposActionBarSizeFullScreen : androidx.appcompat.R$attr.actionBarSize, typedValue, true)) {
            return TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
        }
        return context.getResources().getDimensionPixelSize(O6.c.c() ? R$dimen.stepos_action_bar_default_height_appcompat_full_screen : R$dimen.stepos_action_bar_default_height_appcompat);
    }

    public static int b(Context context) {
        return s.d(context);
    }

    public static boolean c(Configuration configuration) {
        return (configuration.uiMode & 48) == 32;
    }
}
