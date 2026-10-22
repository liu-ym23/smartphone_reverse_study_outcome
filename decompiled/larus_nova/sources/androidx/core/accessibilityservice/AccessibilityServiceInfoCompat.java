package androidx.core.accessibilityservice;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.pm.PackageManager;
import androidx.annotation.ReplaceWith;

/* JADX INFO: loaded from: classes17.dex */
public final class AccessibilityServiceInfoCompat {
    public static final int CAPABILITY_CAN_FILTER_KEY_EVENTS = 8;
    public static final int CAPABILITY_CAN_REQUEST_ENHANCED_WEB_ACCESSIBILITY = 4;
    public static final int CAPABILITY_CAN_REQUEST_TOUCH_EXPLORATION = 2;
    public static final int CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT = 1;
    public static final int FEEDBACK_ALL_MASK = -1;
    public static final int FEEDBACK_BRAILLE = 32;
    public static final int FLAG_INCLUDE_NOT_IMPORTANT_VIEWS = 2;
    public static final int FLAG_REPORT_VIEW_IDS = 16;
    public static final int FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY = 8;
    public static final int FLAG_REQUEST_FILTER_KEY_EVENTS = 32;
    public static final int FLAG_REQUEST_TOUCH_EXPLORATION_MODE = 4;

    private AccessibilityServiceInfoCompat() {
    }

    public static String capabilityToString(int r100) {
        if (r100 != 1) goto L5;
        return "CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT";
    L5:
        if (r100 != 2) goto L7;
        return "CAPABILITY_CAN_REQUEST_TOUCH_EXPLORATION";
    L7:
        if (r100 != 4) goto L9;
        return "CAPABILITY_CAN_REQUEST_ENHANCED_WEB_ACCESSIBILITY";
    L9:
        if (r100 == 8) goto L12;
        return "UNKNOWN";
    L12:
        return "CAPABILITY_CAN_FILTER_KEY_EVENTS";
    }

    public static String flagToString(int r100) {
        if (r100 != 1) goto L5;
        return "DEFAULT";
    L5:
        if (r100 != 2) goto L7;
        return "FLAG_INCLUDE_NOT_IMPORTANT_VIEWS";
    L7:
        if (r100 != 4) goto L9;
        return "FLAG_REQUEST_TOUCH_EXPLORATION_MODE";
    L9:
        if (r100 != 8) goto L11;
        return "FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY";
    L11:
        if (r100 != 16) goto L13;
        return "FLAG_REPORT_VIEW_IDS";
    L13:
        if (r100 == 32) goto L16;
        return null;
    L16:
        return "FLAG_REQUEST_FILTER_KEY_EVENTS";
    }

    public static String feedbackTypeToString(int r100) {
        StringBuilder r101 = new StringBuilder();
        r101.append("[");
    L3:
        if (r100 <= 0) goto L22;
        int r102 = 1 << Integer.numberOfTrailingZeros(r100);
        r100 = r100 & (~r102);
        if (r101.length() <= 1) goto L7;
        r101.append(", ");
    L7:
        if (r102 != 1) goto L9;
        r101.append("FEEDBACK_SPOKEN");
        goto L3
    L9:
        if (r102 != 2) goto L11;
        r101.append("FEEDBACK_HAPTIC");
        goto L3
    L11:
        if (r102 != 4) goto L13;
        r101.append("FEEDBACK_AUDIBLE");
        goto L3
    L13:
        if (r102 != 8) goto L15;
        r101.append("FEEDBACK_VISUAL");
        goto L3
    L15:
        if (r102 != 16) goto L3;
        r101.append("FEEDBACK_GENERIC");
        goto L3
    L22:
        r101.append("]");
        return r101.toString();
    }

    @ReplaceWith(expression = "info.getCapabilities()")
    public static int getCapabilities(AccessibilityServiceInfo r100) {
        return r100.getCapabilities();
    }

    @ReplaceWith(expression = "info.loadDescription(packageManager)")
    public static String loadDescription(AccessibilityServiceInfo r100, PackageManager r101) {
        return r100.loadDescription(r101);
    }
}
