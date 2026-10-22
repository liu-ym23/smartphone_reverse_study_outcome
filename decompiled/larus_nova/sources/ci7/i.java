package ci7;

import com.larus.apm.impl.protector.RunnableProtector;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class i implements com.bytedance.applog.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile i f23864a;

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

    public i() {
    }

    @Override // com.bytedance.applog.h
    public final void a(boolean r100, JSONObject r101) {
    }

    public static i b() {
        if (f23864a != null) goto L15;
        monitor-enter(i.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f23864a != null) goto L9;
        f23864a = new i();     // Catch: Throwable -> L11
    L9:
        monitor-exit(i.class);     // Catch: Throwable -> L11
    L15:
        return f23864a;
    }

    @Override // com.bytedance.applog.h
    public final void onIdLoaded(String r100, String r101, String r102) {
        mi7.e.a("DeviceIdObserver", "HuaWeiReferrerHelper getReferrerAndUpload onIdLoaded");
        mi7.h.a(new a());
    }

    @Override // com.bytedance.applog.h
    public final void onRemoteIdGet(boolean r100, String r101, String r102, String r103, String r104, String r105, String r106) {
        if (r100 == false) goto L5;
        mi7.e.a("DeviceIdObserver", "HuaWeiReferrerHelper getReferrerAndUpload onRemoteIdGet");
        mi7.h.a(new b());
        return;
    }
}
