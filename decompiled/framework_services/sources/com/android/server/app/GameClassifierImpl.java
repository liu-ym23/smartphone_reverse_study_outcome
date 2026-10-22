package com.android.server.app;

import android.content.pm.PackageManager;
import android.os.UserHandle;

/* JADX INFO: loaded from: classes.dex */
final class GameClassifierImpl implements GameClassifier {
    private final PackageManager mPackageManager;

    GameClassifierImpl(PackageManager packageManager) {
        this.mPackageManager = packageManager;
    }

    @Override // com.android.server.app.GameClassifier
    public boolean isGame(String packageName, UserHandle userHandle) {
        int applicationCategory = this.mPackageManager.getApplicationInfoAsUser(packageName, 0, userHandle.getIdentifier()).category;     // Catch: PackageManager.NameNotFoundException -> L7
        if (applicationCategory != 0) goto L11;
        return true;
    L11:
        return false;
    L8:
        return false;
    }
}
