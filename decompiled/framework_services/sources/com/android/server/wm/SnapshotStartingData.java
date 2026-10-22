package com.android.server.wm;

import android.window.TaskSnapshot;

/* JADX INFO: loaded from: classes3.dex */
class SnapshotStartingData extends StartingData {
    private final WindowManagerService mService;
    private final TaskSnapshot mSnapshot;

    SnapshotStartingData(WindowManagerService service, TaskSnapshot snapshot, int typeParams) {
        super(service, typeParams);
        this.mService = service;
        this.mSnapshot = snapshot;
    }

    @Override // com.android.server.wm.StartingData
    StartingSurfaceController.StartingSurface createStartingSurface(ActivityRecord activity) {
        return this.mService.mStartingSurfaceController.createTaskSnapshotSurface(activity, this.mSnapshot);
    }

    @Override // com.android.server.wm.StartingData
    boolean needRevealAnimation() {
        return false;
    }

    @Override // com.android.server.wm.StartingData
    boolean hasImeSurface() {
        return this.mSnapshot.hasImeSurface();
    }
}
