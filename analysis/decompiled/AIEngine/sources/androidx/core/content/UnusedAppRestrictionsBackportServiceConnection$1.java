package androidx.core.content;

import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
class UnusedAppRestrictionsBackportServiceConnection$1 extends IUnusedAppRestrictionsBackportCallback.Stub {
    final /* synthetic */ e this$0;

    public UnusedAppRestrictionsBackportServiceConnection$1(e eVar) {
    }

    @Override // androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback
    public void onIsPermissionRevocationEnabledForAppResult(boolean z, boolean z3) {
        if (z && !z3) {
            throw null;
        }
        throw null;
    }
}
