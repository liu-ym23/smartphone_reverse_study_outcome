package com.android.server.display;

/* JADX INFO: loaded from: classes2.dex */
public interface IZswDisplayManagerService {
    void handleLogicalDisplayAddedLocked(LogicalDisplay r1);

    void releaseDisplayAndEmitEventForPerfCube(LogicalDisplay r1);
}
