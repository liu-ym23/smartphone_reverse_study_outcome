package ci7;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes22.dex */
public final class j implements jta.g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile j f23865a;

    public class a implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            r.a.f23882a.a(l.a());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a() {
        }
    }

    public class b implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            r.a.f23882a.a(l.a());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b() {
        }
    }

    public j() {
    }

    @Override // jta.g.a
    public final void onRemoteConfigUpdate(boolean r100, boolean r101) {
    }

    @Override // jta.g.a
    public final void onDidLoadLocally(boolean r100) {
        if (r100 == false) goto L5;
        mi7.e.a("DeviceConfigUpdateListener", "HuaWeiReferrerHelper getReferrerAndUpload after did load locally");
        mi7.h.a(new b());
        return;
    }

    @Override // jta.g.a
    public final void onDeviceRegistrationInfoChanged(String r100, String r101) {
        mi7.e.a("DeviceConfigUpdateListener", "HuaWeiReferrerHelper getReferrerAndUpload onDeviceRegistrationInfoChanged");
        mi7.h.a(new a());
    }
}
