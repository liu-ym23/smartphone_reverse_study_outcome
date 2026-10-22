package com.android.server.policy;

import android.content.ComponentName;
import android.content.Context;
import android.util.Slog;
import com.android.internal.accessibility.util.AccessibilityUtils;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
class VoiceAccessShortcutController {
    private static final String TAG = null;
    private static final String VOICE_ACCESS_LABEL = "Voice Access";
    private final Context mContext;

    static {
        TAG = VoiceAccessShortcutController.class.getSimpleName();
    }

    VoiceAccessShortcutController(Context context) {
        this.mContext = context;
    }

    boolean toggleVoiceAccess(int userId) {
        Set<ComponentName> enabledServices = AccessibilityUtils.getEnabledServicesFromSettings(this.mContext, userId);
        ComponentName componentName = AccessibilityUtils.getInstalledAccessibilityServiceComponentNameByLabel(this.mContext, VOICE_ACCESS_LABEL);
        if (componentName != null) goto L6;
        Slog.e(TAG, "Toggle Voice Access failed due to componentName being null");
        return false;
    L6:
        boolean newState = !enabledServices.contains(componentName);
        AccessibilityUtils.setAccessibilityServiceState(this.mContext, componentName, newState, userId);
        return newState;
    }
}
