package androidx.core.content;

import android.os.RemoteException;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback;

/* loaded from: classes.dex */
class UnusedAppRestrictionsBackportServiceConnection$1 extends IUnusedAppRestrictionsBackportCallback.Stub {
    final /* synthetic */ g this$0;

    public UnusedAppRestrictionsBackportServiceConnection$1(g gVar) {
    }

    @Override // androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback
    public void onIsPermissionRevocationEnabledForAppResult(boolean z10, boolean z11) throws RemoteException {
        if (z10 && !z11) {
            throw null;
        }
        throw null;
    }
}
