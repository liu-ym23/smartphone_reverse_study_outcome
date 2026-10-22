package androidx.core.content;

import android.os.RemoteException;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback;

/* loaded from: classes.dex */
class UnusedAppRestrictionsBackportServiceConnection$1 extends IUnusedAppRestrictionsBackportCallback.Stub {
    final /* synthetic */ k this$0;

    public UnusedAppRestrictionsBackportServiceConnection$1(k kVar) {
    }

    @Override // androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback
    public void onIsPermissionRevocationEnabledForAppResult(boolean z4, boolean z5) throws RemoteException {
        if (z4 && !z5) {
            throw null;
        }
        throw null;
    }
}
