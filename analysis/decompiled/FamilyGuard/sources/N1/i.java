package N1;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private static Integer f4210a;

    public static float a(float f5, Context context) {
        return TypedValue.applyDimension(1, f5, context.getResources().getDisplayMetrics());
    }

    public static int b(Context context, float f5) {
        return (int) ((f5 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int c(Resources resources, String str, String str2, String str3) {
        if (!"android".equals(str3)) {
            return resources.getIdentifier(str, str2, str3);
        }
        return resources.getIdentifier("android:" + str2 + "/" + str, null, null);
    }

    public static int d(int i5, Context context) {
        TypedValue typedValueH = h(i5, context);
        if (typedValueH == null) {
            return 0;
        }
        return typedValueH.resourceId;
    }

    public static int e(Context context) {
        try {
            if (f4210a == null) {
                f4210a = Integer.valueOf(c(context.getResources(), "status_bar_height", "dimen", "android"));
            }
            return context.getResources().getDimensionPixelSize(f4210a.intValue());
        } catch (Exception e6) {
            Log.e("ResurceUtils", "get status bar height fail", e6);
            return context.getResources().getDimensionPixelSize(H1.f.f2123S);
        }
    }

    public static ArrayList<String> f(Context context, TypedArray typedArray, int i5) throws Resources.NotFoundException {
        TypedValue typedValue = new TypedValue();
        if (!typedArray.getValue(i5, typedValue)) {
            return null;
        }
        int i6 = typedValue.resourceId;
        if (i6 == 0) {
            throw new IllegalStateException("can't find the resourceId");
        }
        TypedArray typedArrayObtainTypedArray = context.getResources().obtainTypedArray(i6);
        int length = typedArrayObtainTypedArray.length();
        ArrayList<String> arrayList = new ArrayList<>(length);
        for (int i7 = 0; i7 < length; i7++) {
            arrayList.add(typedArrayObtainTypedArray.getString(i7));
        }
        typedArrayObtainTypedArray.recycle();
        return arrayList;
    }

    public static Context g(Context context) {
        if ((context instanceof ContextThemeWrapper) && d(H1.c.f2064k, context) != 0) {
            return context;
        }
        int identifier = context.getResources().getIdentifier("Theme.StepOS.AppCompat.Light.Color.Blue", "style", context.getPackageName());
        if (identifier != 0) {
            return new ContextThemeWrapper(context, identifier);
        }
        Log.i("Common ResourceUtil", "can't find default style");
        return context;
    }

    private static TypedValue h(int i5, Context context) {
        Resources.Theme theme = context.getTheme();
        if (theme == null) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        try {
            try {
                theme.resolveAttribute(i5, typedValue, true);
                return typedValue;
            } catch (Exception e6) {
                e6.printStackTrace();
                return typedValue;
            }
        } catch (Throwable unused) {
            return typedValue;
        }
    }

    public static float i(Context context, float f5) {
        return f5 / context.getResources().getDisplayMetrics().density;
    }

    public static int j(Context context, float f5) {
        return (int) ((f5 / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static float k(float f5, Context context) {
        return (int) ((f5 * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
