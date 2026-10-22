package com.obric.server.display;

import android.app.ObricActivityManager;
import android.util.Slog;
import android.view.Display;
import com.obric.cae.libs.BuildConfig;

/* JADX INFO: loaded from: classes3.dex */
public final class ObricAutoActionDisplayStateReporter {
    private static final String AUTO_ACTION_DISPLAY_NAME = "auto_action";
    private static final String TAG = "ObricAutoActionVD";

    private ObricAutoActionDisplayStateReporter() {
    }

    public static boolean isAutoActionVirtualDisplay(String name, String ownerPackageName, int type) {
        if (type == 5) goto L5;
    L10:
        return false;
    L5:
        if (AUTO_ACTION_DISPLAY_NAME.equals(name) == false) goto L10;
        if (ownerPackageName == null) goto L10;
        if (ObricActivityManager.isAutoAction(ownerPackageName) == false) goto L10;
        return true;
    }

    public static void reportSurfaceChanged(String name, String ownerPackageName, boolean oldSurfaceNull, boolean newSurfaceNull, int displayState) {
        if (isAutoActionVirtualDisplay(name, ownerPackageName, 5) == false) goto L8;
        if (oldSurfaceNull == newSurfaceNull) goto L9;
        Slog.i(TAG, "surface " + surfaceTransitionToString(oldSurfaceNull, newSurfaceNull) + ", state=" + Display.stateToString(displayState));
        return;
    L9:
        return;
    }

    public static void reportForceBasicChanged(int displayId, int deviceState) {
        Slog.i(TAG, "LDM displayId=" + displayId + ", diff=STATE, state=" + Display.stateToString(deviceState) + ", forceBasicChanged");
    }

    public static void reportWmDisplayStateChanged(int displayId, String name, String ownerPackageName, int type, int oldState, int newState) {
        if (isAutoActionVirtualDisplay(name, ownerPackageName, type) == false) goto L8;
        if (oldState == newState) goto L9;
        Slog.i(TAG, "WM displayId=" + displayId + ", " + Display.stateToString(oldState) + "->" + Display.stateToString(newState) + ", token=" + tokenActionToString(newState));
        return;
    L9:
        return;
    }

    private static String surfaceTransitionToString(boolean oldSurfaceNull, boolean newSurfaceNull) {
        StringBuilder r0 = new StringBuilder();
        String r1 = "non-null";
        if (oldSurfaceNull == false) goto L5;
        String r3 = "null";
    L6:
        r0.append(r3);
        r0.append("->");
        if (newSurfaceNull == false) goto L9;
        r1 = "null";
    L9:
        r0.append(r1);
        return r0.toString();
    L5:
        r3 = "non-null";
        goto L6
    }

    private static String tokenActionToString(int state) {
        if (state != 1) goto L7;
        return "acquire";
    L7:
        if (state != 2) goto L10;
        return BuildConfig.BUILD_TYPE;
    L10:
        return "none";
    }
}
