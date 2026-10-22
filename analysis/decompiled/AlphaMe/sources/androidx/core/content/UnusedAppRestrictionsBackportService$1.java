package androidx.core.content;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService;

/* loaded from: classes.dex */
class UnusedAppRestrictionsBackportService$1 extends IUnusedAppRestrictionsBackportService.Stub {
    final /* synthetic */ j this$0;

    public UnusedAppRestrictionsBackportService$1(j jVar) {
    }

    @Override // androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService
    public void isPermissionRevocationEnabledForApp(@Nullable IUnusedAppRestrictionsBackportCallback iUnusedAppRestrictionsBackportCallback) throws RemoteException {
        if (iUnusedAppRestrictionsBackportCallback != null) {
            throw null;
        }
    }
}
