package com.android.server.media.projection;

import android.app.WindowConfiguration;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Log;
import com.android.internal.util.FrameworkStatsLog;
import java.time.Duration;

/* JADX INFO: loaded from: classes2.dex */
public class MediaProjectionMetricsLogger {
    private static final String TAG = "MediaProjectionMetricsLogger";
    private static final int TARGET_UID_UNKNOWN = -2;
    private static final int TIME_SINCE_LAST_ACTIVE_UNKNOWN = -1;
    private static MediaProjectionMetricsLogger sSingleton;
    private final FrameworkStatsLogWrapper mFrameworkStatsLogWrapper;
    private int mPreviousProjectionState;
    private final Rect mPreviousTargetBounds;
    private int mPreviousTargetWindowingMode;
    private final MediaProjectionSessionIdGenerator mSessionIdGenerator;
    private final MediaProjectionTimestampStore mTimestampStore;

    static {
        sSingleton = null;
    }

    MediaProjectionMetricsLogger(FrameworkStatsLogWrapper frameworkStatsLogWrapper, MediaProjectionSessionIdGenerator sessionIdGenerator, MediaProjectionTimestampStore timestampStore) {
        this.mPreviousTargetBounds = new Rect();
        this.mPreviousTargetWindowingMode = 0;
        this.mPreviousProjectionState = 0;
        this.mFrameworkStatsLogWrapper = frameworkStatsLogWrapper;
        this.mSessionIdGenerator = sessionIdGenerator;
        this.mTimestampStore = timestampStore;
    }

    public static MediaProjectionMetricsLogger getInstance(Context context) {
        if (sSingleton != null) goto L6;
        sSingleton = new MediaProjectionMetricsLogger(new FrameworkStatsLogWrapper(), MediaProjectionSessionIdGenerator.getInstance(context), MediaProjectionTimestampStore.getInstance(context));
    L6:
        return sSingleton;
    }

    public void logInitiated(int hostUid, int sessionCreationSource) {
        Log.d(TAG, "logInitiated");
        Duration durationSinceLastActiveSession = this.mTimestampStore.timeSinceLastActiveSession();
        if (durationSinceLastActiveSession != null) goto L5;
        int r1 = -1;
    L6:
        int timeSinceLastActiveInSeconds = r1;
        writeStateChanged(this.mSessionIdGenerator.createAndGetNewSessionId(), 1, hostUid, -2, timeSinceLastActiveInSeconds, sessionCreationSource, 0);
        return;
    L5:
        r1 = (int) durationSinceLastActiveSession.toSeconds();
        goto L6
    }

    public void logPermissionRequestDisplayed(int hostUid) {
        Log.d(TAG, "logPermissionRequestDisplayed");
        writeStateChanged(this.mSessionIdGenerator.getCurrentSessionId(), 2, hostUid, -2, -1, 0, 0);
    }

    public void logProjectionPermissionRequestCancelled(int hostUid) {
        writeStateChanged(this.mSessionIdGenerator.getCurrentSessionId(), 8, hostUid, -2, -1, 0, 0);
    }

    public void logAppSelectorDisplayed(int hostUid) {
        Log.d(TAG, "logAppSelectorDisplayed");
        writeStateChanged(this.mSessionIdGenerator.getCurrentSessionId(), 3, hostUid, -2, -1, 0, 0);
    }

    public void logInProgress(int hostUid, int targetUid) {
        Log.d(TAG, "logInProgress");
        writeStateChanged(this.mSessionIdGenerator.getCurrentSessionId(), 4, hostUid, targetUid, -1, 0, 0);
    }

    public void logChangedWindowingMode(int contentToRecord, int hostUid, int targetUid, int windowingMode) {
        Log.d(TAG, "logChangedWindowingMode: windowingMode= " + WindowConfiguration.windowingModeToString(windowingMode));
        Log.d(TAG, "targetChangeType= changeWindowingMode");
        writeTargetChanged(this.mSessionIdGenerator.getCurrentSessionId(), contentToRecordToTargetType(contentToRecord), hostUid, targetUid, windowingModeToTargetWindowingMode(windowingMode), this.mPreviousTargetBounds.width(), this.mPreviousTargetBounds.height(), this.mPreviousTargetBounds.centerX(), this.mPreviousTargetBounds.centerY(), 1);
        this.mPreviousTargetWindowingMode = windowingMode;
    }

    public void logChangedCaptureBounds(int contentToRecord, int hostUid, int targetUid, Rect captureBounds) {
        Point capturePosition = new Point(captureBounds.centerX(), captureBounds.centerY());
        Log.d(TAG, "logChangedCaptureBounds: captureBounds= " + captureBounds + " position= " + capturePosition);
        writeTargetChanged(this.mSessionIdGenerator.getCurrentSessionId(), contentToRecordToTargetType(contentToRecord), hostUid, targetUid, this.mPreviousTargetWindowingMode, captureBounds.width(), captureBounds.height(), captureBounds.centerX(), captureBounds.centerY(), captureBoundsToTargetChangeType(captureBounds));
        this.mPreviousTargetBounds.set(captureBounds);
    }

    private int captureBoundsToTargetChangeType(Rect captureBounds) {
        if (captureBounds.width() != this.mPreviousTargetBounds.width()) goto L5;
    L7:
        boolean hasChangedSize = false;
    L9:
        if (hasChangedSize == false) goto L12;
        Log.d(TAG, "targetChangeType= changeBounds");
        return 3;
    L12:
        Log.d(TAG, "targetChangeType= changePosition");
        return 2;
    L5:
        if (captureBounds.height() == this.mPreviousTargetBounds.height()) goto L7;
        hasChangedSize = true;
        goto L9
    }

    public int contentToRecordToTargetType(int recordContentType) {
        switch(recordContentType) {
            case 0: goto L5;
            case 1: goto L4;
            default: goto L3;
        };
    L3:
        return 0;
    L4:
        return 2;
    L5:
        return 1;
    }

    public int windowingModeToTargetWindowingMode(int windowingMode) {
        switch(windowingMode) {
            case 1: goto L6;
            case 5: goto L5;
            case 6: goto L4;
            default: goto L3;
        };
    L3:
        return 0;
    L4:
        return 3;
    L5:
        return 4;
    L6:
        return 2;
    }

    public int stopReasonToSessionStopSource(int stopReason) {
        switch(stopReason) {
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            case 9: goto L5;
            case 10: goto L4;
            default: goto L3;
        };
    L3:
        return 0;
    L4:
        return 10;
    L5:
        return 9;
    L6:
        return 8;
    L7:
        return 7;
    L8:
        return 6;
    L9:
        return 5;
    L10:
        return 4;
    L11:
        return 3;
    L12:
        return 2;
    L13:
        return 1;
    }

    public void logStopped(int hostUid, int targetUid, int stopReason) {
        if (this.mPreviousProjectionState != 4) goto L5;
        boolean wasCaptureInProgress = true;
    L6:
        Log.d(TAG, "logStopped: wasCaptureInProgress=" + wasCaptureInProgress + " stopReason=" + stopReason);
        writeStateChanged(this.mSessionIdGenerator.getCurrentSessionId(), 7, hostUid, targetUid, -1, 0, stopReasonToSessionStopSource(stopReason));
        if (wasCaptureInProgress == false) goto L10;
        this.mTimestampStore.registerActiveSessionEnded();
        return;
    L10:
        return;
    L5:
        wasCaptureInProgress = false;
        goto L6
    }

    public void notifyProjectionStateChange(int hostUid, int state, int sessionCreationSource, int sessionStopSource) {
        writeStateChanged(hostUid, state, sessionCreationSource, sessionStopSource);
    }

    private void writeStateChanged(int hostUid, int state, int sessionCreationSource, int sessionStopSource) {
        this.mFrameworkStatsLogWrapper.writeStateChanged(FrameworkStatsLog.MEDIA_PROJECTION_STATE_CHANGED, 123, state, 0, hostUid, -1, 0, sessionCreationSource, sessionStopSource);
    }

    private void writeStateChanged(int sessionId, int state, int hostUid, int targetUid, int timeSinceLastActive, int creationSource, int stopSource) {
        this.mFrameworkStatsLogWrapper.writeStateChanged(FrameworkStatsLog.MEDIA_PROJECTION_STATE_CHANGED, sessionId, state, this.mPreviousProjectionState, hostUid, targetUid, timeSinceLastActive, creationSource, stopSource);
        this.mPreviousProjectionState = state;
    }

    private void writeTargetChanged(int sessionId, int targetType, int hostUid, int targetUid, int targetWindowingMode, int width, int height, int centerX, int centerY, int targetChangeType) {
        this.mFrameworkStatsLogWrapper.writeTargetChanged(FrameworkStatsLog.MEDIA_PROJECTION_TARGET_CHANGED, sessionId, targetType, hostUid, targetUid, targetWindowingMode, width, height, centerX, centerY, targetChangeType);
    }
}
