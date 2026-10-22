package androidx.core.content;

import android.os.RemoteException;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback;

/* JADX INFO: loaded from: classes17.dex */
public class UnusedAppRestrictionsBackportCallback {
    private IUnusedAppRestrictionsBackportCallback mCallback;

    public UnusedAppRestrictionsBackportCallback(IUnusedAppRestrictionsBackportCallback r100) {
        this.mCallback = r100;
    }

    public void onResult(boolean r100, boolean r101) throws RemoteException {
        this.mCallback.onIsPermissionRevocationEnabledForAppResult(r100, r101);
    }
}
