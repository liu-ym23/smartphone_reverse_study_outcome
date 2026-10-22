package l8;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.util.TypedValue;
import com.stepos.aiengine.R;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static Integer f10358a;

    public static float a(float f8, Context context) {
        return TypedValue.applyDimension(1, f8, context.getResources().getDisplayMetrics());
    }

    public static int b(int i10, Context context) {
        TypedValue typedValue;
        Resources.Theme theme = context.getTheme();
        if (theme == null) {
            typedValue = null;
        } else {
            TypedValue typedValue2 = new TypedValue();
            try {
                try {
                    theme.resolveAttribute(i10, typedValue2, true);
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            } catch (Throwable unused) {
            }
            typedValue = typedValue2;
        }
        if (typedValue == null) {
            return 0;
        }
        return typedValue.resourceId;
    }

    public static int c(Context context) {
        try {
            if (f10358a == null) {
                f10358a = Integer.valueOf(context.getResources().getIdentifier(a0.a.k("android:", "dimen", "/status_bar_height"), null, null));
            }
            return context.getResources().getDimensionPixelSize(f10358a.intValue());
        } catch (Exception e10) {
            Log.e("ResurceUtils", "get status bar height fail", e10);
            return context.getResources().getDimensionPixelSize(R.dimen.status_bar_height);
        }
    }
}
