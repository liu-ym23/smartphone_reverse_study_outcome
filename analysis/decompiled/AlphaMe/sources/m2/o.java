package m2;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import com.stepos.alphame.R;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public abstract class o {

    /* renamed from: a, reason: collision with root package name */
    public static final y0.e f13585a = new y0.e(16);

    /* renamed from: b, reason: collision with root package name */
    public static Integer f13586b;

    public static void a(TextView textView, int i4, n nVar) {
        int lineCount;
        float textSize = textView.getTextSize();
        int maxLines = textView.getMaxLines();
        if (maxLines <= 0) {
            return;
        }
        textView.setMaxLines(Integer.MAX_VALUE);
        for (float f4 = textSize; f4 > 1.0f; f4 -= 1.0f) {
            try {
                nVar.f(textView, f4);
                nVar.h(textView, View.MeasureSpec.makeMeasureSpec(i4, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
                Layout layout = textView.getLayout();
                if (layout == null || (lineCount = layout.getLineCount()) <= 0) {
                    throw new IllegalStateException();
                }
                if (lineCount <= maxLines) {
                    textView.setMaxLines(maxLines);
                    return;
                }
            } catch (Exception unused) {
            }
        }
        nVar.f(textView, textSize);
        textView.setMaxLines(maxLines);
    }

    public static int b(Context context, double d4) {
        return (int) TypedValue.applyDimension(1, (float) d4, context.getResources().getDisplayMetrics());
    }

    public static float c(Context context, float f4) {
        return TypedValue.applyDimension(1, f4, context.getResources().getDisplayMetrics());
    }

    public static Drawable d(Context context, String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            Object objInvoke = i.b("android.content.res.stepostheme.StepOSThemeUtils").b("getCustomRes", Context.class, String.class).f13573a.invoke(null, context, str);
            if (objInvoke instanceof Drawable) {
                return (Drawable) objInvoke;
            }
            return null;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e4) {
            Log.w("ThemeUtil", "reflect method#getCustomRes has an error:" + e4);
            return null;
        }
    }

    public static int e(Resources resources, String str) {
        return resources.getIdentifier(B0.g.n("android:", str, "/status_bar_height"), null, null);
    }

    public static int f(int i4, Context context) {
        TypedValue typedValue;
        Resources.Theme theme = context.getTheme();
        if (theme == null) {
            typedValue = null;
        } else {
            TypedValue typedValue2 = new TypedValue();
            try {
                try {
                    theme.resolveAttribute(i4, typedValue2, true);
                } catch (Exception e4) {
                    e4.printStackTrace();
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

    public static int g(Context context) {
        try {
            if (f13586b == null) {
                f13586b = Integer.valueOf(e(context.getResources(), "dimen"));
            }
            return context.getResources().getDimensionPixelSize(f13586b.intValue());
        } catch (Exception e4) {
            Log.e("ResurceUtils", "get status bar height fail", e4);
            return context.getResources().getDimensionPixelSize(R.dimen.status_bar_height);
        }
    }
}
