package androidx.core.content;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService;

/* JADX INFO: loaded from: classes.dex */
public abstract class UnusedAppRestrictionsBackportService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IUnusedAppRestrictionsBackportService.a f2519a;

    public class a extends IUnusedAppRestrictionsBackportService.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ UnusedAppRestrictionsBackportService f2520a;

        public a(UnusedAppRestrictionsBackportService r10) {
            this.f2520a = r10;
        }

        @Override // androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService
        public void isPermissionRevocationEnabledForApp(IUnusedAppRestrictionsBackportCallback r10) {
            if (r10 != null) goto L4;
            return;
        L4:
            androidx.core.content.a r11 = new androidx.core.content.a(r10);
            this.f2520a.a(r11);
        }
    }

    public UnusedAppRestrictionsBackportService() {
        this.f2519a = new a(this);
    }

    public abstract void a(androidx.core.content.a r10);

    @Override // android.app.Service
    public IBinder onBind(Intent r10) {
        return this.f2519a;
    }
}
