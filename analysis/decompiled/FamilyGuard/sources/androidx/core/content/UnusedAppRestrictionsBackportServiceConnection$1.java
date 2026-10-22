package androidx.core.content;

import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback;

/* loaded from: classes.dex */
class UnusedAppRestrictionsBackportServiceConnection$1 extends IUnusedAppRestrictionsBackportCallback.Stub {
    final /* synthetic */ f this$0;

    UnusedAppRestrictionsBackportServiceConnection$1(f fVar) {
    }

    @Override // androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback
    public void onIsPermissionRevocationEnabledForAppResult(boolean z5, boolean z6) {
        if (z5 && !z6) {
            throw null;
        }
        throw null;
    }
}
