package p3;

import android.content.Context;
import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Iterator;
import r4.C1031n;

/* loaded from: classes.dex */
public final class r {
    public static final boolean a(View view) {
        j4.k.g(view, "view");
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        for (int childCount = viewGroup.getChildCount() - 1; -1 < childCount; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            j4.k.f(childAt, "getChildAt(...)");
            if (a(childAt)) {
                return true;
            }
        }
        return false;
    }

    public static final View b(View view) {
        if (view == null) {
            return null;
        }
        if (view instanceof EditText) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View viewB = b(viewGroup.getChildAt(i5));
                if (viewB != null) {
                    return viewB;
                }
            }
        }
        return null;
    }

    public static final int c(TextView textView, CharSequence charSequence) {
        CharSequence transformation;
        j4.k.g(textView, "textView");
        int iMax = 0;
        if (charSequence != null && charSequence.length() != 0) {
            TransformationMethod transformationMethod = textView.getTransformationMethod();
            if (transformationMethod != null && (transformation = transformationMethod.getTransformation(charSequence, textView)) != null) {
                charSequence = transformation;
            }
            Iterator it = C1031n.X(charSequence.toString(), new char[]{'\n'}, false, 0, 6, null).iterator();
            while (it.hasNext()) {
                iMax = Math.max(iMax, (int) textView.getPaint().measureText((String) it.next()));
            }
        }
        return iMax;
    }

    public static final int d(Context context) {
        j4.k.g(context, "context");
        Rect rectF = f(context);
        return rectF != null ? rectF.height() : context.getResources().getDisplayMetrics().heightPixels;
    }

    public static final int e(Context context) {
        j4.k.g(context, "context");
        WindowManager windowManager = (WindowManager) context.getSystemService(WindowManager.class);
        if (windowManager == null) {
            return 0;
        }
        return windowManager.getCurrentWindowMetrics().getWindowInsets().getInsets(WindowInsets.Type.statusBars()).top;
    }

    private static final Rect f(Context context) {
        WindowMetrics currentWindowMetrics;
        WindowManager windowManager = (WindowManager) context.getSystemService(WindowManager.class);
        if (windowManager == null || (currentWindowMetrics = windowManager.getCurrentWindowMetrics()) == null) {
            return null;
        }
        return currentWindowMetrics.getBounds();
    }
}
