package L;

import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class c {
    @DoNotInline
    public static Object a(int i4, float f4, float f5, float f6) {
        return new AccessibilityNodeInfo.RangeInfo(i4, f4, f5, f6);
    }

    @DoNotInline
    public static CharSequence b(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.getStateDescription();
    }

    @DoNotInline
    public static void c(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
        accessibilityNodeInfo.setStateDescription(charSequence);
    }
}
