package androidx.core.content;

import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
class UnusedAppRestrictionsBackportServiceConnection$1 extends IUnusedAppRestrictionsBackportCallback.Stub {
    final /* synthetic */ e this$0;

    public UnusedAppRestrictionsBackportServiceConnection$1(e eVar) {
    }

    @Override // androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback
    public void onIsPermissionRevocationEnabledForAppResult(boolean z10, boolean z11) {
        if (z10 && !z11) {
            throw null;
        }
        throw null;
    }
}
