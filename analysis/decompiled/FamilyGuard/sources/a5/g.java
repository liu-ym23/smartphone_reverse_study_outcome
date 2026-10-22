package a5;

import N1.i;
import android.content.Context;
import android.content.res.Configuration;
import android.util.TypedValue;
import g.C0728a;

/* loaded from: classes.dex */
public class g {
    public static int a(Context context) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(N1.a.c() ? X4.a.f5831g : C0728a.f16825b, typedValue, true)) {
            return TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
        }
        return context.getResources().getDimensionPixelSize(N1.a.c() ? H1.f.f2125U : H1.f.f2124T);
    }

    public static int b(Context context) {
        return i.e(context);
    }

    public static boolean c(Configuration configuration) {
        return (configuration.uiMode & 48) == 32;
    }
}
