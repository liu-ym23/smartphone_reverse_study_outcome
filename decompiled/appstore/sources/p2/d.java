package p2;

import android.os.Process;
import android.text.TextUtils;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.ReportProtocal;
import org.json.JSONObject;
import r3.e;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f23319a = -1;

    static {
    }

    public static a a(byte[] r10) {
        a r11 = new a();     // Catch: Exception -> L9
        JSONObject r12 = new JSONObject(new String(r10));     // Catch: Exception -> L9
        r11.i0(e.k(r12, "version_code"));     // Catch: Exception -> L9
        r11.j0(e.k(r12, CommonKey.KEY_VERSION_NAME));     // Catch: Exception -> L9
        r11.S(e.k(r12, CommonKey.KEY_MANIFEST_VERSION_CODE));     // Catch: Exception -> L9
        r11.g0(e.k(r12, "update_version_code"));     // Catch: Exception -> L9
        r11.H(e.k(r12, "app_version"));     // Catch: Exception -> L9
        r11.W(e.k(r12, "os"));     // Catch: Exception -> L9
        r11.P(e.k(r12, "device_platform"));     // Catch: Exception -> L9
        r11.X(e.k(r12, CommonKey.KEY_OS_VERSION));     // Catch: Exception -> L9
        r11.G(e.i(r12, "os_api"));     // Catch: Exception -> L9
        r11.O(e.k(r12, "device_model"));     // Catch: Exception -> L9
        r11.L(e.k(r12, "device_brand"));     // Catch: Exception -> L9
        r11.N(e.k(r12, CommonKey.KEY_DEVICE_MANUFACTURER));     // Catch: Exception -> L9
        r11.a0(e.k(r12, "process_name"));     // Catch: Exception -> L9
        r11.d0(e.j(r12, "sid"));     // Catch: Exception -> L9
        r11.c0(e.k(r12, CommonKey.KEY_ROM_VERSION));     // Catch: Exception -> L9
        r11.Y(e.k(r12, "package"));     // Catch: Exception -> L9
        r11.T(e.k(r12, CommonKey.KEY_MONITOR_VERSION));     // Catch: Exception -> L9
        r11.I(e.k(r12, "channel"));     // Catch: Exception -> L9
        r11.F(e.i(r12, "aid"));     // Catch: Exception -> L9
        r11.M(e.k(r12, "device_id"));     // Catch: Exception -> L9
        r11.Z(e.j(r12, CommonKey.KEY_PHONE_STARTUP_TIME));     // Catch: Exception -> L9
        r11.b0(e.k(r12, CommonKey.KEY_RELEASE_BUILD));     // Catch: Exception -> L9
        r11.f0(e.j(r12, "uid"));     // Catch: Exception -> L9
        r11.h0(e.k(r12, CommonKey.KEY_VERIFY_INFO));     // Catch: Exception -> L9
        r11.K(e.k(r12, ReportProtocal.KEY_HEADER_UPDATE_VERSION_CODE));     // Catch: Exception -> L9
        if (r12.has("config_time") == false) goto L12;
        r11.J(e.i(r12, "config_time"));     // Catch: Exception -> L9
    L12:
        r11.R(new JSONObject((String) r12.remove("filters")));     // Catch: Exception -> L11
    L7:
        r11.e0(r12);     // Catch: Exception -> L9
        return r11;
    L9:
        return null;
    }

    public static long b(long r10) {
        if (r10 >= 0) goto L6;
        return 0;
    L6:
        return r10 >> 16;
    }

    public static long c() {
        if (f23319a != (-1)) goto L6;
        long r10 = d3.a.u();
        f23319a = (r10 << 16) | ((long) Process.myPid());
    L6:
        return f23319a;
    }

    public static JSONObject d(a r10) {
        if (r10 != null) goto L31;
        return null;
    L31:
        JSONObject r11 = new JSONObject();     // Catch: Exception -> L30
        if (r10.z() == null) goto L9;
        r11 = e.a(r11, r10.z());     // Catch: Exception -> L30
    L9:
        if (r10.l() == null) goto L11;
        r11 = e.a(r11, r10.l());     // Catch: Exception -> L30
    L11:
        r11.put("version_code", r10.D());     // Catch: Exception -> L30
        r11.put(CommonKey.KEY_VERSION_NAME, r10.E());     // Catch: Exception -> L30
        r11.put(CommonKey.KEY_MANIFEST_VERSION_CODE, r10.n());     // Catch: Exception -> L30
        r11.put("update_version_code", r10.B());     // Catch: Exception -> L30
        r11.put("app_version", r10.c());     // Catch: Exception -> L30
        r11.put("os", r10.r());     // Catch: Exception -> L30
        r11.put("device_platform", r10.k());     // Catch: Exception -> L30
        r11.put(CommonKey.KEY_OS_VERSION, r10.s());     // Catch: Exception -> L30
        r11.put("os_api", r10.b());     // Catch: Exception -> L30
        r11.put("device_model", r10.j());     // Catch: Exception -> L30
        r11.put("device_brand", r10.g());     // Catch: Exception -> L30
        r11.put(CommonKey.KEY_DEVICE_MANUFACTURER, r10.i());     // Catch: Exception -> L30
        r11.put("process_name", r10.v());     // Catch: Exception -> L30
        r11.put("sid", r10.y());     // Catch: Exception -> L30
        r11.put(CommonKey.KEY_ROM_VERSION, r10.x());     // Catch: Exception -> L30
        r11.put("package", r10.t());     // Catch: Exception -> L30
        r11.put(CommonKey.KEY_MONITOR_VERSION, r10.o());     // Catch: Exception -> L30
        r11.put("channel", r10.d());     // Catch: Exception -> L30
        r11.put("aid", r10.a());     // Catch: Exception -> L30
        if (TextUtils.isEmpty(r10.h()) == true) goto L14;
        r11.put("device_id", r10.h());     // Catch: Exception -> L30
    L14:
        r11.put("uid", r10.A());     // Catch: Exception -> L30
        r11.put(CommonKey.KEY_PHONE_STARTUP_TIME, r10.u());     // Catch: Exception -> L30
        r11.put(CommonKey.KEY_RELEASE_BUILD, r10.w());     // Catch: Exception -> L30
        if (r10.e() == (-1)) goto L18;
        r11.put("config_time", String.valueOf(r10.e()));     // Catch: Exception -> L30
    L18:
        if (TextUtils.isEmpty(r10.C()) == true) goto L20;
        r11.put(CommonKey.KEY_VERIFY_INFO, r10.C());     // Catch: Exception -> L30
    L20:
        r11.put(ReportProtocal.KEY_HEADER_UPDATE_VERSION_CODE, r10.f());     // Catch: Exception -> L30
        if (r10.q() == (-1)) goto L24;
        r11.put("ntp_time", r10.q());     // Catch: Exception -> L30
    L24:
        if (r10.p() == (-1)) goto L27;
        r11.put("ntp_offset", r10.p());     // Catch: Exception -> L30
    L27:
        if (r10.m() == null) goto L29;
        r11.put("filters", r10.m());     // Catch: Exception -> L30
    L29:
        return r11;
    L30:
        return null;
    }
}
