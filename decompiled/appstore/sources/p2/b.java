package p2;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.listener.INtpTimeService;
import com.bytedance.apm6.foundation.context.ApmContextAdapter;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import n2.f;
import org.json.JSONObject;
import r3.e;
import r3.g;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile b f23307f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map f23308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p2.a f23309b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f23310c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f23311d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public u3.a f23312e;

    public class a extends u3.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ INtpTimeService f23313d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ b f23314e;

        public a(b r10, INtpTimeService r11) {
            this.f23314e = r10;
            this.f23313d = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            long r10 = this.f23313d.getNtpTime();
            if (r10 == (-1)) goto L6;
            b.a(this.f23314e, r10);
            b.b(this.f23314e, System.currentTimeMillis() - r10);
        L6:
            monitor-enter(b.class);
            u3.b.a(AsyncTaskManagerType.LIGHT_WEIGHT).b(b.c(this.f23314e));     // Catch: Throwable -> L10
            b.d(this.f23314e, null);     // Catch: Throwable -> L10
            monitor-exit(b.class);     // Catch: Throwable -> L10
            return;
        L10:
            th = move-exception;
            throw th;
        }
    }

    public b() {
        this.f23308a = new ConcurrentHashMap();
        this.f23310c = -1;
        this.f23311d = -1;
    }

    public static /* synthetic */ long a(b r10, long r11) {
        r10.f23311d = r11;
        return r11;
    }

    public static /* synthetic */ long b(b r10, long r11) {
        r10.f23310c = r11;
        return r11;
    }

    public static /* synthetic */ u3.a c(b r10) {
        return r10.f23312e;
    }

    public static /* synthetic */ u3.a d(b r10, u3.a r11) {
        r10.f23312e = r11;
        return r11;
    }

    public static b f() {
        if (f23307f != null) goto L16;
        monitor-enter(b.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f23307f != null) goto L11;
        f23307f = new b();     // Catch: Throwable -> L9
    L11:
        monitor-exit(b.class);     // Catch: Throwable -> L9
    L16:
        return f23307f;
    }

    public p2.a e(String r10) {
        if (this.f23308a.containsKey(r10) == false) goto L5;
        p2.a r11 = (p2.a) this.f23308a.get(r10);
    L8:
        i(r11);
        return r11;
    L5:
        p2.a r12 = c.d().c(r10);
        if (r12 == null) goto L11;
        this.f23308a.put(r10, r12);
        r11 = r12;
        goto L8
    L11:
        return this.f23309b;
    }

    public void g() {
        p2.a r10 = new p2.a();
        r10.W("Android");
        r10.P("android");
        r10.X(Build.VERSION.RELEASE);
        r10.G(Build.VERSION.SDK_INT);
        r10.O(Build.MODEL);
        r10.L(Build.BRAND);
        r10.N(Build.MANUFACTURER);
        r10.a0(d3.a.m());
        r10.d0(d3.a.u());
        r10.c0(g.k());
        r10.h0(f.a());
        r10.Z(d3.a.o());
        r10.I(d3.a.k());
        r10.F(d3.a.h());
        r10.f0(d3.a.x());
        r10.g0(String.valueOf(d3.a.v()));
        r10.j0(d3.a.z());
        r10.i0(String.valueOf(d3.a.y()));
        r10.H(d3.a.j());
        r10.b0(d3.a.r());
        r10.Y(r3.a.b().getPackageName());
        r10.K(r10.B());
        r10.S(d3.a.p());
        r10.J(d3.a.l());
        JSONObject r11 = new JSONObject();
        e.a(r11, d3.a.t());     // Catch: Exception -> L6
        if (r11.has("version_code") == false) goto L9;
        r11.remove("version_code");     // Catch: Exception -> L6
    L9:
        if (r11.has("app_version") == false) goto L12;
        r11.remove("app_version");     // Catch: Exception -> L6
    L12:
        if (r11.has("uid") == false) goto L15;
        r11.remove("uid");     // Catch: Exception -> L6
    L15:
        if (r11.has("update_version_code") == false) goto L18;
        r11.remove("update_version_code");     // Catch: Exception -> L6
    L18:
        if (r11.has(CommonKey.KEY_MANIFEST_VERSION_CODE) == false) goto L22;
        r11.remove(CommonKey.KEY_MANIFEST_VERSION_CODE);     // Catch: Exception -> L6
    L22:
        r10.e0(r11);
        r10.T("5.0.21.21");
        if (d3.a.A() == false) goto L25;
        c.d().a();
    L25:
        h(r10);
        return;
    L6:
        e = move-exception;
        s3.a.b("APM", "header json exception" + e.toString());
        goto L22
    }

    public final void h(p2.a r10) {
        String r11 = String.valueOf(d.c());
        this.f23308a.put(r11, r10);
        this.f23309b = r10;
        c.d().f(r11, r10);
    }

    public final void i(p2.a r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r10.h()) == false) goto L7;
        r10.M(d3.a.n());
    L7:
        ApmContextAdapter r11 = d3.a.i();
        if (r11 == null) goto L10;
        r10.Q(r11.getDynamicHeaderExtras());
    L10:
        long r12 = this.f23311d;
        if (r12 == (-1)) goto L13;
        r10.V(r12);
        r10.U(this.f23310c);
    L26:
        if (r3.a.c() == false) goto L28;
        s3.a.a(n2.a.f22354a, "nptTime:" + this.f23311d + " nptOffset:" + this.f23310c);
    L28:
        r10.f0(d3.a.x());
        r10.J(d3.a.l());
        p2.a r13 = this.f23309b;
        if (r13 == null) goto L34;
        r10.K(r13.B());
        return;
    L34:
        return;
    L13:
        INtpTimeService r14 = d3.a.q();
        if (r14 == null) goto L26;
        if (this.f23312e != null) goto L26;
        monitor-enter(b.class);
        this.f23312e = new a(this, r14);     // Catch: Throwable -> L22
        u3.b.a(AsyncTaskManagerType.LIGHT_WEIGHT).c(this.f23312e);     // Catch: Throwable -> L22
        monitor-exit(b.class);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }
}
