package K;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.contentcapture.ContentCaptureSession;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

/* loaded from: classes.dex */
public abstract class O {
    @DoNotInline
    public static View.AccessibilityDelegate a(View view) {
        return view.getAccessibilityDelegate();
    }

    @DoNotInline
    public static ContentCaptureSession b(View view) {
        return view.getContentCaptureSession();
    }

    @DoNotInline
    public static List<Rect> c(View view) {
        return view.getSystemGestureExclusionRects();
    }

    @DoNotInline
    public static void d(@NonNull View view, @NonNull Context context, @NonNull int[] iArr, @Nullable AttributeSet attributeSet, @NonNull TypedArray typedArray, int i4, int i5) {
        view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i4, i5);
    }

    @DoNotInline
    public static void e(View view, O.a aVar) {
        view.setContentCaptureSession(null);
    }

    @DoNotInline
    public static void f(View view, List<Rect> list) {
        view.setSystemGestureExclusionRects(list);
    }
}
