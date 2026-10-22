package okhttp3.internal.i.a;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: CloseGuard.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f40110a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Method f40111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Method f40112c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Method f40113d;

    /* JADX INFO: compiled from: CloseGuard.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final h a() {
            Method r6 = null;
            Class r0 = ZeusTransformUtils.forName("dalvik.system.CloseGuard", "com.obric.aiagent.plugin");     // Catch: Exception -> L5
            Method r1 = r0.getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[0]);     // Catch: Exception -> L5
            Method r3 = r0.getMethod("open", new Class[]{String.class});     // Catch: Exception -> L5
            Method r2 = r0.getMethod("warnIfOpen", new Class[0]);     // Catch: Exception -> L5
            r6 = r1;
        L7:
            return new h(r6, r3, r2);
        L5:
            r2 = null;
            r3 = null;
            goto L7
        }
    }

    static {
        f40110a = new a(null);
    }

    public h(Method r1, Method r2, Method r3) {
        this.f40111b = r1;
        this.f40112c = r2;
        this.f40113d = r3;
    }

    public final Object a(String r5) {
        o.e(r5, "closer");
        Method r0 = this.f40111b;
        if (r0 != null) goto L9;
    L7:
        return null;
    L9:
        Object r1 = r0.invoke(null, new Object[0]);     // Catch: Exception -> L8
        Method r4 = this.f40112c;     // Catch: Exception -> L8
        o.a(r4);     // Catch: Exception -> L8
        r4.invoke(r1, new Object[]{r5});     // Catch: Exception -> L8
        return r1;
    }

    public final boolean a(Object r3) {
        if (r3 == null) goto L10;
        Method r2 = this.f40113d;     // Catch: Exception -> L7
        o.a(r2);     // Catch: Exception -> L7
        r2.invoke(r3, new Object[0]);     // Catch: Exception -> L7
        return true;
    L11:
        return false;
    L10:
        return false;
    }
}
