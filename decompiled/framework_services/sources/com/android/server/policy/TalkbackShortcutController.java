package com.android.server.policy;

import android.content.ComponentName;
import android.content.Context;
import android.provider.Settings;
import com.android.internal.accessibility.util.AccessibilityStatsLogUtils;
import com.android.internal.accessibility.util.AccessibilityUtils;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
class TalkbackShortcutController {
    private static final String TALKBACK_LABEL = "TalkBack";
    private final Context mContext;

    public static final enum ShortcutSource extends Enum<ShortcutSource> {
        private static final /* synthetic */ ShortcutSource[] $VALUES = null;
        public static final ShortcutSource GESTURE = null;
        public static final ShortcutSource KEYBOARD = null;

        private static /* synthetic */ ShortcutSource[] $values() {
            return new ShortcutSource[]{GESTURE, KEYBOARD};
        }

        private ShortcutSource(String r1, int r2) {
            super(r1, r2);
        }

        public static ShortcutSource valueOf(String name) {
            return (ShortcutSource) Enum.valueOf(ShortcutSource.class, name);
        }

        public static ShortcutSource[] values() {
            return (ShortcutSource[]) $VALUES.clone();
        }

        static {
            GESTURE = new ShortcutSource("GESTURE", 0);
            KEYBOARD = new ShortcutSource("KEYBOARD", 1);
            $VALUES = $values();
        }
    }

    TalkbackShortcutController(Context context) {
        this.mContext = context;
    }

    boolean toggleTalkback(int userId, ShortcutSource source) {
        Set<ComponentName> enabledServices = AccessibilityUtils.getEnabledServicesFromSettings(this.mContext, userId);
        ComponentName componentName = AccessibilityUtils.getInstalledAccessibilityServiceComponentNameByLabel(this.mContext, TALKBACK_LABEL);
        if (componentName != null) goto L6;
        return false;
    L6:
        boolean isTalkbackAlreadyEnabled = enabledServices.contains(componentName);
        if (source != ShortcutSource.KEYBOARD) goto L9;
    L10:
        isTalkbackAlreadyEnabled = !isTalkbackAlreadyEnabled;
        AccessibilityUtils.setAccessibilityServiceState(this.mContext, componentName, isTalkbackAlreadyEnabled, userId);
        if (source != ShortcutSource.GESTURE) goto L14;
        if (isTalkbackAlreadyEnabled == false) goto L14;
        logStemTriplePressAccessibilityTelemetry(componentName);
    L14:
        return isTalkbackAlreadyEnabled;
    L9:
        if (isTalkBackShortcutGestureEnabled() == false) goto L14;
        goto L10
    }

    boolean isTalkBackShortcutGestureEnabled() {
        if (Settings.System.getIntForUser(this.mContext.getContentResolver(), "wear_accessibility_gesture_enabled", 0, -2) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    private void logStemTriplePressAccessibilityTelemetry(ComponentName componentName) {
        if (AccessibilityUtils.isUserSetupCompleted(this.mContext) == true) goto L6;
        Settings.Secure.putInt(this.mContext.getContentResolver(), "wear_accessibility_gesture_enabled_during_oobe", 1);
        return;
    L6:
        AccessibilityStatsLogUtils.logAccessibilityShortcutActivated(this.mContext, componentName, 7, true);
    }
}
