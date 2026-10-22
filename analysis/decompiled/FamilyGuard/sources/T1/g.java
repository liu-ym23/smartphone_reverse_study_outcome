package T1;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RemoteViews;
import android.widget.TextView;

/* loaded from: classes.dex */
public class g {
    public static int a(Context context, int i5) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i5});
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        return dimensionPixelOffset;
    }

    public static int b(Context context, int i5) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i5});
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        return dimensionPixelSize;
    }

    public static void c(float f5, TextView textView) {
        if (textView != null && textView.getResources().getConfiguration().fontScale > f5) {
            textView.setTextSize(0, (textView.getTextSize() * f5) / 1.7f);
        }
    }

    public static void d(Context context, RemoteViews remoteViews, int i5, int i6) {
        remoteViews.setTextViewTextSize(i5, 0, i6);
    }

    public static void e(float f5, ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = viewGroup.getChildAt(i5);
            if (childAt instanceof TextView) {
                c(f5, (TextView) childAt);
            } else if (childAt instanceof ViewGroup) {
                e(f5, (ViewGroup) childAt);
            }
        }
    }

    public static int f(float f5) {
        return (int) TypedValue.applyDimension(1, f5, P1.a.a().getResources().getDisplayMetrics());
    }
}
