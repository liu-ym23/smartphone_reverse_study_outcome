package com.bytedanceos.appstore.update;

import android.app.PackageInstallObserver;
import android.content.Intent;
import android.os.Bundle;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedanceos.appstore.download.manager.AppsInstallManager;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.utils.k;

/* JADX INFO: loaded from: classes2.dex */
public class AriesAppInstallObserver extends PackageInstallObserver {
    private AppInfo mAppInfo;

    public AriesAppInstallObserver(AppInfo r10) {
        this.mAppInfo = r10;
    }

    @Override // android.app.PackageInstallObserver
    public void onPackageInstalled(String r10, int r11, String r12, Bundle r13) {
        if (r11 != 1) goto L5;
        j.e("Install apk file success:" + r10 + LibrarianImpl.Constants.SEPARATOR + this.mAppInfo.appPackageName);
        AppsInstallManager.getInstance().installSuccess(this.mAppInfo);
        return;
    L5:
        String r14 = k.e(r11);
        j.e("Install apk file failed: [" + this.mAppInfo.appPackageName + "]/[" + r11 + "]  fail reason " + r14);
        AppsInstallManager.getInstance().installFailure(this.mAppInfo, r11, r14);
    }

    @Override // android.app.PackageInstallObserver
    public void onUserActionRequired(Intent r10) {
    }
}
