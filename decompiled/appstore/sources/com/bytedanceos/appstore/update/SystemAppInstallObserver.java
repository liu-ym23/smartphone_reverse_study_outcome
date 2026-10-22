package com.bytedanceos.appstore.update;

import android.content.pm.IPackageInstallObserver;
import android.os.RemoteException;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedanceos.appstore.download.manager.AppsInstallManager;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.utils.k;

/* JADX INFO: loaded from: classes2.dex */
class SystemAppInstallObserver extends IPackageInstallObserver.a {
    private AppInfo mAppInfo;

    public SystemAppInstallObserver(AppInfo r10) {
        this.mAppInfo = r10;
    }

    @Override // android.content.pm.IPackageInstallObserver
    public void packageInstalled(String r10, int r11) throws RemoteException {
        if (r11 != 1) goto L5;
        j.e("Install apk file success:" + r10 + LibrarianImpl.Constants.SEPARATOR + this.mAppInfo.appPackageName);
        AppsInstallManager.getInstance().installSuccess(this.mAppInfo);
        return;
    L5:
        String r12 = k.e(r11);
        j.e("Install apk file failed: [" + this.mAppInfo.appPackageName + "]/[" + r11 + "]  fail reason " + r12);
        AppsInstallManager.getInstance().installFailure(this.mAppInfo, r11, r12);
    }
}
