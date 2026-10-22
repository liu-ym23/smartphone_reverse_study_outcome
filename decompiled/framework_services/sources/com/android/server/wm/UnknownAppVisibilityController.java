package com.android.server.wm;

import android.util.ArrayMap;
import android.util.Slog;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes3.dex */
class UnknownAppVisibilityController {
    private static final String TAG = "WindowManager";
    private static final int UNKNOWN_STATE_WAITING_RELAYOUT = 2;
    private static final int UNKNOWN_STATE_WAITING_RESUME = 1;
    private static final int UNKNOWN_STATE_WAITING_VISIBILITY_UPDATE = 3;
    private final DisplayContent mDisplayContent;
    private final WindowManagerService mService;
    private final ArrayMap<ActivityRecord, Integer> mUnknownApps;

    UnknownAppVisibilityController(WindowManagerService service, DisplayContent displayContent) {
        this.mUnknownApps = new ArrayMap();
        this.mService = service;
        this.mDisplayContent = displayContent;
    }

    boolean allResolved() {
        return this.mUnknownApps.isEmpty();
    }

    boolean isVisibilityUnknown(ActivityRecord r) {
        if (this.mUnknownApps.isEmpty() == false) goto L7;
        return false;
    L7:
        return this.mUnknownApps.containsKey(r);
    }

    void clear() {
        this.mUnknownApps.clear();
    }

    String getDebugMessage() {
        StringBuilder builder = new StringBuilder();
        int i = this.mUnknownApps.size() - 1;
    L3:
        if (i < 0) goto L9;
        builder.append("app=");
        builder.append(this.mUnknownApps.keyAt(i));
        builder.append(" state=");
        builder.append(this.mUnknownApps.valueAt(i));
        if (i == 0) goto L7;
        builder.append(' ');
    L7:
        i = i - 1;
        goto L3
    L9:
        return builder.toString();
    }

    void appRemovedOrHidden(ActivityRecord activity) {
        if (this.mUnknownApps.isEmpty() == false) goto L6;
        return;
    L6:
        if (WindowManagerDebugConfig.DEBUG_UNKNOWN_APP_VISIBILITY == false) goto L8;
        Slog.d(TAG, "App removed or hidden activity=" + activity);
    L8:
        this.mUnknownApps.remove(activity);
    }

    void notifyLaunched(ActivityRecord activity) {
        if (WindowManagerDebugConfig.DEBUG_UNKNOWN_APP_VISIBILITY == false) goto L6;
        Slog.d(TAG, "App launched activity=" + activity);
    L6:
        if (activity.mLaunchTaskBehind == true) goto L8;
        this.mUnknownApps.put(activity, 1);
        return;
    L8:
        this.mUnknownApps.put(activity, 2);
    }

    void notifyAppResumedFinished(ActivityRecord activity) {
        if (this.mUnknownApps.isEmpty() == false) goto L5;
        return;
    L5:
        Integer state = this.mUnknownApps.get(activity);
        if (state != null) goto L8;
        return;
    L8:
        if (state.intValue() == 1) goto L10;
        return;
    L10:
        if (WindowManagerDebugConfig.DEBUG_UNKNOWN_APP_VISIBILITY == false) goto L12;
        Slog.d(TAG, "App resume finished activity=" + activity);
    L12:
        this.mUnknownApps.put(activity, 2);
    }

    void notifyRelayouted(ActivityRecord activity) {
        if (this.mUnknownApps.isEmpty() == false) goto L5;
        return;
    L5:
        Integer state = this.mUnknownApps.get(activity);
        if (state != null) goto L9;
        return;
    L9:
        if (WindowManagerDebugConfig.DEBUG_UNKNOWN_APP_VISIBILITY == false) goto L12;
        Slog.d(TAG, "App relayouted appWindow=" + activity);
    L12:
        if (state.intValue() != 2) goto L14;
    L21:
        this.mUnknownApps.put(activity, 3);
        this.mDisplayContent.notifyKeyguardFlagsChanged();
        notifyVisibilitiesUpdated();
        return;
    L14:
        if (activity.mStartingWindow != null) goto L21;
        if (state.intValue() == 1) goto L19;
        return;
    L19:
        if (activity.isState(ActivityRecord.State.RESUMED) == true) goto L24;
        Slog.d(TAG, "UAVC: skip waiting for non-resumed relayouted " + activity);
        this.mUnknownApps.remove(activity);
        return;
    }

    private void notifyVisibilitiesUpdated() {
        if (WindowManagerDebugConfig.DEBUG_UNKNOWN_APP_VISIBILITY == false) goto L5;
        Slog.d(TAG, "Visibility updated DONE");
    L5:
        boolean changed = false;
        int i = this.mUnknownApps.size() - 1;
    L6:
        if (i < 0) goto L12;
        if (this.mUnknownApps.valueAt(i).intValue() != 3) goto L10;
        this.mUnknownApps.removeAt(i);
        changed = true;
    L10:
        i = i - 1;
        goto L6
    L12:
        if (changed == false) goto L18;
        this.mService.mWindowPlacerLocked.performSurfacePlacement();
        return;
    }

    void dump(PrintWriter pw, String prefix) {
        if (this.mUnknownApps.isEmpty() == false) goto L5;
        return;
    L5:
        pw.println(prefix + "Unknown visibilities:");
        int i = this.mUnknownApps.size() + (-1);
    L6:
        if (i < 0) goto L9;
        pw.println(prefix + "  app=" + this.mUnknownApps.keyAt(i) + " state=" + this.mUnknownApps.valueAt(i));
        i = i + (-1);
        goto L6
    }
}
