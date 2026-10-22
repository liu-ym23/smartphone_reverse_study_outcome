package L;

import android.graphics.Rect;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.DoNotInline;
import java.time.Duration;

/* loaded from: classes.dex */
public abstract class e {
    @DoNotInline
    public static AccessibilityNodeInfo.AccessibilityAction a() {
        return AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_IN_DIRECTION;
    }

    @DoNotInline
    public static void b(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
        accessibilityNodeInfo.getBoundsInWindow(rect);
    }

    @DoNotInline
    public static CharSequence c(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.getContainerTitle();
    }

    @DoNotInline
    public static long d(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.getMinDurationBetweenContentChanges().toMillis();
    }

    @DoNotInline
    public static boolean e(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.hasRequestInitialAccessibilityFocus();
    }

    @DoNotInline
    public static boolean f(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.isAccessibilityDataSensitive();
    }

    @DoNotInline
    public static void g(AccessibilityNodeInfo accessibilityNodeInfo, boolean z4) {
        accessibilityNodeInfo.setAccessibilityDataSensitive(z4);
    }

    @DoNotInline
    public static void h(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
        accessibilityNodeInfo.setBoundsInWindow(rect);
    }

    @DoNotInline
    public static void i(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
        accessibilityNodeInfo.setContainerTitle(charSequence);
    }

    @DoNotInline
    public static void j(AccessibilityNodeInfo accessibilityNodeInfo, long j4) {
        accessibilityNodeInfo.setMinDurationBetweenContentChanges(Duration.ofMillis(j4));
    }

    @DoNotInline
    public static void k(AccessibilityNodeInfo accessibilityNodeInfo, View view, boolean z4) {
        accessibilityNodeInfo.setQueryFromAppProcessEnabled(view, z4);
    }

    @DoNotInline
    public static void l(AccessibilityNodeInfo accessibilityNodeInfo, boolean z4) {
        accessibilityNodeInfo.setRequestInitialAccessibilityFocus(z4);
    }
}
