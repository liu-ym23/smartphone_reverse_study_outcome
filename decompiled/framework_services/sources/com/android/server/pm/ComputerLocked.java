package com.android.server.pm;

import android.content.ComponentName;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;

/* JADX INFO: loaded from: classes2.dex */
public final class ComputerLocked extends ComputerEngine {
    ComputerLocked(PackageManagerService.Snapshot args) {
        super(args, -1);
    }

    @Override // com.android.server.pm.ComputerEngine
    protected ComponentName resolveComponentName() {
        return this.mService.getResolveComponentName();
    }

    @Override // com.android.server.pm.ComputerEngine
    protected ActivityInfo instantAppInstallerActivity() {
        return this.mService.mInstantAppInstallerActivity;
    }

    @Override // com.android.server.pm.ComputerEngine
    protected ApplicationInfo androidApplication() {
        return this.mService.getCoreAndroidApplication();
    }
}
