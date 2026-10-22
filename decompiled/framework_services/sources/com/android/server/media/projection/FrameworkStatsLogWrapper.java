package com.android.server.media.projection;

import com.android.internal.util.FrameworkStatsLog;

/* JADX INFO: loaded from: classes2.dex */
public class FrameworkStatsLogWrapper {
    public FrameworkStatsLogWrapper() {
    }

    public void writeStateChanged(int code, int sessionId, int state, int previousState, int hostUid, int targetUid, int timeSinceLastActive, int creationSource, int stopSource) {
        FrameworkStatsLog.write(code, sessionId, state, previousState, hostUid, targetUid, timeSinceLastActive, creationSource, stopSource);
    }

    public void writeTargetChanged(int code, int sessionId, int targetType, int hostUid, int targetUid, int windowingMode, int width, int height, int centerX, int centerY, int targetChangeType) {
        FrameworkStatsLog.write(code, sessionId, targetType, hostUid, targetUid, windowingMode, width, height, centerX, centerY, targetChangeType);
    }
}
