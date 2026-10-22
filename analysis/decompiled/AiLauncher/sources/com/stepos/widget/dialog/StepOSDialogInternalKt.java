package com.stepos.widget.dialog;

import La.H;
import android.content.Context;
import android.graphics.Rect;
import android.text.Layout;
import android.text.method.TransformationMethod;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Iterator;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0005\u0010\u0004\u001a\u0017\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0006\u0010\u0004\u001a\u0019\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\b\u0010\t\u001a\u001f\u0010\f\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH\u0000¢\u0006\u0004\b\f\u0010\r\u001a!\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001f\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u001f\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0017\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001bH\u0000¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u001b\u0010 \u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0000¢\u0006\u0004\b \u0010!¨\u0006\""}, d2 = {"Landroid/content/Context;", "context", "", "screenWidthPx", "(Landroid/content/Context;)I", "screenHeightPx", "statusBarHeightPx", "Landroid/graphics/Rect;", "windowBounds", "(Landroid/content/Context;)Landroid/graphics/Rect;", "", "dp", "dpToPx", "(Landroid/content/Context;F)I", "Landroid/widget/TextView;", "textView", "", "text", "measureTextWidth", "(Landroid/widget/TextView;Ljava/lang/CharSequence;)I", "availableWidth", "LY8/t;", "shrinkTextSizeToFit", "(Landroid/widget/TextView;I)V", "width", "lineCountAt", "(Landroid/widget/TextView;I)I", "Landroid/view/View;", "view", "", "canTextInput", "(Landroid/view/View;)Z", "findEditText", "(Landroid/view/View;)Landroid/view/View;", "StepOSWidget_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSDialogInternalKt {
    public static final boolean canTextInput(View view) {
        kotlin.jvm.internal.p.i(view, "view");
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        for (int childCount = viewGroup.getChildCount() - 1; -1 < childCount; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            kotlin.jvm.internal.p.h(childAt, "getChildAt(...)");
            if (canTextInput(childAt)) {
                return true;
            }
        }
        return false;
    }

    public static final int dpToPx(Context context, float f10) {
        kotlin.jvm.internal.p.i(context, "context");
        return (int) TypedValue.applyDimension(1, f10, context.getResources().getDisplayMetrics());
    }

    public static final View findEditText(View view) {
        if (view == null) {
            return null;
        }
        if (view instanceof EditText) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View viewFindEditText = findEditText(viewGroup.getChildAt(i10));
                if (viewFindEditText != null) {
                    return viewFindEditText;
                }
            }
        }
        return null;
    }

    private static final int lineCountAt(TextView textView, int i10) {
        textView.measure(View.MeasureSpec.makeMeasureSpec(i10, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        Layout layout = textView.getLayout();
        if (layout != null) {
            return layout.getLineCount();
        }
        return 0;
    }

    public static final int measureTextWidth(TextView textView, CharSequence charSequence) {
        CharSequence transformation;
        kotlin.jvm.internal.p.i(textView, "textView");
        int iMax = 0;
        if (charSequence != null && charSequence.length() != 0) {
            TransformationMethod transformationMethod = textView.getTransformationMethod();
            if (transformationMethod != null && (transformation = transformationMethod.getTransformation(charSequence, textView)) != null) {
                charSequence = transformation;
            }
            Iterator it = H.a1(charSequence.toString(), new char[]{'\n'}, false, 0, 6, null).iterator();
            while (it.hasNext()) {
                iMax = Math.max(iMax, (int) textView.getPaint().measureText((String) it.next()));
            }
        }
        return iMax;
    }

    public static final int screenHeightPx(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        Rect rectWindowBounds = windowBounds(context);
        return rectWindowBounds != null ? rectWindowBounds.height() : context.getResources().getDisplayMetrics().heightPixels;
    }

    public static final int screenWidthPx(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        Rect rectWindowBounds = windowBounds(context);
        return rectWindowBounds != null ? rectWindowBounds.width() : context.getResources().getDisplayMetrics().widthPixels;
    }

    public static final void shrinkTextSizeToFit(TextView textView, int i10) {
        kotlin.jvm.internal.p.i(textView, "textView");
        int maxLines = textView.getMaxLines();
        if (maxLines <= 0 || i10 <= 0) {
            return;
        }
        float textSize = textView.getTextSize();
        textView.setMaxLines(Integer.MAX_VALUE);
        for (float f10 = textSize; f10 > 1.0f; f10 -= 1.0f) {
            try {
                textView.setTextSize(0, f10);
                if (lineCountAt(textView, i10) <= maxLines) {
                    textView.setMaxLines(maxLines);
                    return;
                }
            } finally {
                textView.setMaxLines(maxLines);
            }
        }
        textView.setTextSize(0, textSize);
    }

    public static final int statusBarHeightPx(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        WindowManager windowManager = (WindowManager) context.getSystemService(WindowManager.class);
        if (windowManager == null) {
            return 0;
        }
        return windowManager.getCurrentWindowMetrics().getWindowInsets().getInsets(WindowInsets.Type.statusBars()).top;
    }

    private static final Rect windowBounds(Context context) {
        WindowMetrics currentWindowMetrics;
        WindowManager windowManager = (WindowManager) context.getSystemService(WindowManager.class);
        if (windowManager == null || (currentWindowMetrics = windowManager.getCurrentWindowMetrics()) == null) {
            return null;
        }
        return currentWindowMetrics.getBounds();
    }
}
