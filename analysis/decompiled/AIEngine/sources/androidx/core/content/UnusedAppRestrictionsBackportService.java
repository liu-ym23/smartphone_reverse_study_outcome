package androidx.core.content;

import android.app.Service;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class UnusedAppRestrictionsBackportService extends Service {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: androidx.core.content.UnusedAppRestrictionsBackportService$1, reason: invalid class name */
    public class AnonymousClass1 extends IUnusedAppRestrictionsBackportService.Stub {
        final /* synthetic */ UnusedAppRestrictionsBackportService this$0;

        public AnonymousClass1(UnusedAppRestrictionsBackportService unusedAppRestrictionsBackportService) {
        }

        @Override // androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService
        public void isPermissionRevocationEnabledForApp(IUnusedAppRestrictionsBackportCallback iUnusedAppRestrictionsBackportCallback) {
            if (iUnusedAppRestrictionsBackportCallback != null) {
                throw null;
            }
        }
    }
}
