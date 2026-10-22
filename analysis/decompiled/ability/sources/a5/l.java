package a5;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.stepos.ability.R;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.libpag.PAG;
import w0.C2085f;

/* loaded from: classes3.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    public static final C2085f f1646a = new C2085f(6);
    public static Integer b;

    public static void a(TextView textView, int i, k kVar) {
        int lineCount;
        float textSize = textView.getTextSize();
        int maxLines = textView.getMaxLines();
        if (maxLines <= 0) {
            return;
        }
        textView.setMaxLines(Integer.MAX_VALUE);
        for (float f = textSize; f > 1.0f; f -= 1.0f) {
            try {
                kVar.p(textView, f);
                kVar.i(textView, View.MeasureSpec.makeMeasureSpec(i, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(0, 0));
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
        kVar.p(textView, textSize);
        textView.setMaxLines(maxLines);
    }

    public static int b(Context context, double d) {
        return (int) TypedValue.applyDimension(1, (float) d, context.getResources().getDisplayMetrics());
    }

    public static float c(float f, Context context) {
        return TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public static Drawable d(Context context, String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            Object objInvoke = g.b("android.content.res.stepostheme.StepOSThemeUtils").a("getCustomRes", Context.class, String.class).f1642a.invoke(null, context, str);
            if (objInvoke instanceof Drawable) {
                return (Drawable) objInvoke;
            }
            return null;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            Log.w("ThemeUtil", "reflect method#getCustomRes has an error:" + e);
            return null;
        }
    }

    public static int e(int i, Context context) {
        TypedValue typedValue;
        Resources.Theme theme = context.getTheme();
        if (theme == null) {
            typedValue = null;
        } else {
            TypedValue typedValue2 = new TypedValue();
            try {
                try {
                    theme.resolveAttribute(i, typedValue2, true);
                } catch (Exception e) {
                    e.printStackTrace();
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

    public static int f(Context context) {
        try {
            if (b == null) {
                b = Integer.valueOf(context.getResources().getIdentifier(B7.a.m("android:", "dimen", "/status_bar_height"), null, null));
            }
            return context.getResources().getDimensionPixelSize(b.intValue());
        } catch (Exception e) {
            Log.e("ResurceUtils", "get status bar height fail", e);
            return context.getResources().getDimensionPixelSize(R.dimen.status_bar_height);
        }
    }

    public static void g(Context context) {
        String strSDKVersion;
        h("init");
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("pag_reporter", 0);
            if (sharedPreferences == null) {
                h("prefs null");
                return;
            }
            String strSDKVersion2 = null;
            try {
                strSDKVersion = PAG.SDKVersion();
            } catch (UnsatisfiedLinkError unused) {
                strSDKVersion = null;
            }
            if (TextUtils.isEmpty(strSDKVersion)) {
                h("sdkVersion is null");
                return;
            }
            String string = sharedPreferences.getString("last_pag_version", "");
            String string2 = sharedPreferences.getString("pag_report_time", "");
            String str = new SimpleDateFormat("yyyy-MM").format(new Date());
            if (strSDKVersion.equals(string) && str.equals(string2)) {
                h("not need update");
                return;
            }
            h("writeData");
            try {
                strSDKVersion2 = PAG.SDKVersion();
            } catch (UnsatisfiedLinkError unused2) {
            }
            if (TextUtils.isEmpty(strSDKVersion2)) {
                h("sdkVersion is null");
                return;
            }
            String str2 = new SimpleDateFormat("yyyy-MM").format(new Date());
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString("last_pag_version", strSDKVersion2);
            editorEdit.putString("pag_report_time", str2);
            editorEdit.commit();
        } catch (Exception e) {
            h("init error:" + e);
        }
    }

    public static void h(String str) {
        Log.i(" [PAGReporterPrevent] ", str);
    }
}
