package androidx.core.content;

import android.app.Service;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService;

/* loaded from: classes.dex */
public abstract class UnusedAppRestrictionsBackportService extends Service {

    /* renamed from: androidx.core.content.UnusedAppRestrictionsBackportService$1, reason: invalid class name */
    class AnonymousClass1 extends IUnusedAppRestrictionsBackportService.Stub {
        final /* synthetic */ UnusedAppRestrictionsBackportService this$0;

        AnonymousClass1(UnusedAppRestrictionsBackportService unusedAppRestrictionsBackportService) {
        }

        @Override // androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService
        public void isPermissionRevocationEnabledForApp(IUnusedAppRestrictionsBackportCallback iUnusedAppRestrictionsBackportCallback) {
            if (iUnusedAppRestrictionsBackportCallback == null) {
                return;
            }
            new e(iUnusedAppRestrictionsBackportCallback);
            throw null;
        }
    }
}
