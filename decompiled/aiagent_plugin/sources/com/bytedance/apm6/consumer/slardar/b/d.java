package com.bytedance.apm6.consumer.slardar.b;

import android.os.Process;
import android.text.TextUtils;
import com.bytedance.apm6.util.e;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.general.HardwareInfo;
import com.bytedance.crash.general.RomInfo;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: HeaderUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f5080a = -1;

    static {
    }

    static long a(long r3) {
        if (r3 >= 0) goto L6;
        return 0;
    L6:
        return r3 >> 16;
    }

    public static JSONObject a(a r8) {
        if (r8 != null) goto L31;
        return null;
    L31:
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L30
        if (r8.x() == null) goto L9;
        r1 = e.a(r1, r8.x());     // Catch: Exception -> L30
    L9:
        if (r8.w() == null) goto L11;
        r1 = e.a(r1, r8.w());     // Catch: Exception -> L30
    L11:
        r1.put("version_code", r8.g());     // Catch: Exception -> L30
        r1.put("version_name", r8.h());     // Catch: Exception -> L30
        r1.put("manifest_version_code", r8.f());     // Catch: Exception -> L30
        r1.put("update_version_code", r8.d());     // Catch: Exception -> L30
        r1.put(WsConstants.KEY_APP_VERSION, r8.e());     // Catch: Exception -> L30
        r1.put(RomInfo.KEY_OS_TYPE, r8.j());     // Catch: Exception -> L30
        r1.put("device_platform", r8.k());     // Catch: Exception -> L30
        r1.put(RomInfo.KEY_ROM_OS_VERSION, r8.l());     // Catch: Exception -> L30
        r1.put(RomInfo.KEY_ROM_OS_API, r8.m());     // Catch: Exception -> L30
        r1.put(HardwareInfo.KEY_HW_VENDOR_MODEL, r8.n());     // Catch: Exception -> L30
        r1.put(HardwareInfo.KEY_HW_VENDOR_BRAND, r8.o());     // Catch: Exception -> L30
        r1.put(HardwareInfo.KEY_HW_VENDOR_MANUFACTURER, r8.p());     // Catch: Exception -> L30
        r1.put("process_name", r8.q());     // Catch: Exception -> L30
        r1.put("sid", r8.r());     // Catch: Exception -> L30
        r1.put("rom_version", r8.s());     // Catch: Exception -> L30
        r1.put("package", r8.t());     // Catch: Exception -> L30
        r1.put(MonitorConstants.EXTRA_MONITOR_VERSION, r8.u());     // Catch: Exception -> L30
        r1.put("channel", r8.c());     // Catch: Exception -> L30
        r1.put(WsConstants.KEY_APP_ID, r8.a());     // Catch: Exception -> L30
        if (TextUtils.isEmpty(r8.b()) == true) goto L14;
        r1.put("device_id", r8.b());     // Catch: Exception -> L30
    L14:
        r1.put("uid", r8.v());     // Catch: Exception -> L30
        r1.put("phone_startup_time", r8.y());     // Catch: Exception -> L30
        r1.put("release_build", r8.i());     // Catch: Exception -> L30
        if (r8.C() == (-1)) goto L18;
        r1.put("config_time", String.valueOf(r8.C()));     // Catch: Exception -> L30
    L18:
        if (TextUtils.isEmpty(r8.z()) == true) goto L20;
        r1.put("verify_info", r8.z());     // Catch: Exception -> L30
    L20:
        r1.put("current_update_version_code", r8.B());     // Catch: Exception -> L30
        if (r8.D() == (-1)) goto L24;
        r1.put("ntp_time", r8.D());     // Catch: Exception -> L30
    L24:
        if (r8.E() == (-1)) goto L27;
        r1.put("ntp_offset", r8.E());     // Catch: Exception -> L30
    L27:
        if (r8.A() == null) goto L29;
        r1.put("filters", r8.A());     // Catch: Exception -> L30
    L29:
        return r1;
    L30:
        return null;
    }

    public static a a(byte[] r5) {
        a r1 = new a();     // Catch: Exception -> L9
        JSONObject r2 = new JSONObject(new String(r5));     // Catch: Exception -> L9
        r1.n(e.a(r2, "version_code"));     // Catch: Exception -> L9
        r1.o(e.a(r2, "version_name"));     // Catch: Exception -> L9
        r1.m(e.a(r2, "manifest_version_code"));     // Catch: Exception -> L9
        r1.k(e.a(r2, "update_version_code"));     // Catch: Exception -> L9
        r1.l(e.a(r2, WsConstants.KEY_APP_VERSION));     // Catch: Exception -> L9
        r1.a(e.a(r2, RomInfo.KEY_OS_TYPE));     // Catch: Exception -> L9
        r1.b(e.a(r2, "device_platform"));     // Catch: Exception -> L9
        r1.c(e.a(r2, RomInfo.KEY_ROM_OS_VERSION));     // Catch: Exception -> L9
        r1.a(e.b(r2, RomInfo.KEY_ROM_OS_API));     // Catch: Exception -> L9
        r1.d(e.a(r2, HardwareInfo.KEY_HW_VENDOR_MODEL));     // Catch: Exception -> L9
        r1.e(e.a(r2, HardwareInfo.KEY_HW_VENDOR_BRAND));     // Catch: Exception -> L9
        r1.f(e.a(r2, HardwareInfo.KEY_HW_VENDOR_MANUFACTURER));     // Catch: Exception -> L9
        r1.g(e.a(r2, "process_name"));     // Catch: Exception -> L9
        r1.a(e.c(r2, "sid"));     // Catch: Exception -> L9
        r1.h(e.a(r2, "rom_version"));     // Catch: Exception -> L9
        r1.q(e.a(r2, "package"));     // Catch: Exception -> L9
        r1.r(e.a(r2, MonitorConstants.EXTRA_MONITOR_VERSION));     // Catch: Exception -> L9
        r1.j(e.a(r2, "channel"));     // Catch: Exception -> L9
        r1.b(e.b(r2, WsConstants.KEY_APP_ID));     // Catch: Exception -> L9
        r1.i(e.a(r2, "device_id"));     // Catch: Exception -> L9
        r1.c(e.c(r2, "phone_startup_time"));     // Catch: Exception -> L9
        r1.p(e.a(r2, "release_build"));     // Catch: Exception -> L9
        r1.b(e.c(r2, "uid"));     // Catch: Exception -> L9
        r1.s(e.a(r2, "verify_info"));     // Catch: Exception -> L9
        r1.t(e.a(r2, "current_update_version_code"));     // Catch: Exception -> L9
        if (r2.has("config_time") == false) goto L14;
        r1.d(e.b(r2, "config_time"));     // Catch: Exception -> L9
    L14:
        r1.c(new JSONObject((String) ZeusTransformUtils.preCheckCast(r2.remove("filters"), String.class, "com.obric.aiagent.plugin")));     // Catch: Exception -> L11
    L7:
        r1.b(r2);     // Catch: Exception -> L9
        return r1;
    L9:
        return null;
    }

    public static long a() {
        if (f5080a != (-1)) goto L6;
        long r0 = com.bytedance.apm6.foundation.context.a.c();
        f5080a = (r0 << 16) | ((long) Process.myPid());
    L6:
        return f5080a;
    }
}
