package android.app;

import android.content.Intent;
import android.content.pm.IPackageInstallObserver2;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class PackageInstallObserver {
    private final IPackageInstallObserver2.a mBinder;

    public PackageInstallObserver() {
        this.mBinder = new AnonymousClass1(this);
    }

    public IPackageInstallObserver2 getBinder() {
        return this.mBinder;
    }

    public void onPackageInstalled(String r10, int r11, String r12, Bundle r13) {
    }

    public void onUserActionRequired(Intent r10) {
    }
}
