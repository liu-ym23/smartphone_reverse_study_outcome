package com.bytedance.crash.entity;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.dumper.LocaleInfo;
import com.bytedance.crash.dumper.d;
import com.bytedance.crash.monitor.f;
import com.bytedance.crash.o.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class Header {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f7453c = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JSONObject f7454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f7455b;

    static {
    }

    public Header() {
        this.f7455b = -1;
        this.f7454a = new JSONObject();
    }

    public static Header a(com.bytedance.crash.monitor.a r7, long r8, CrashType r10, int r11) {
        Header r6 = new Header();
        r6.a(r8);
        JSONObject r0 = r6.f7454a;
        if (r0.has("device_id") == true) goto L6;
        l.a(r0, "device_id", r7.a("0"));
    L6:
        if (r0.has("channel") == true) goto L8;
        l.a(r0, "channel", r7.c(r8));
    L8:
        int r1 = 4444;
        r1 = Integer.parseInt(r7.e());     // Catch: Throwable -> L24
    L10:
        l.a(r0, WsConstants.KEY_APP_ID, Integer.valueOf(r1));
        com.bytedance.crash.monitor.c r9 = r7.f(r8);
        if (r9.d() == null) goto L14;
        l.a(r0, WsConstants.KEY_APP_VERSION, r9.d());
    L14:
        if (r9.b() == 0) goto L17;
        l.a(r0, "version_code", Long.valueOf(r9.b()));
    L17:
        if (r9.a() == 0) goto L20;
        l.a(r0, "update_version_code", Long.valueOf(r9.a()));
    L20:
        if (r9.c() == 0) goto L22;
        l.a(r0, "manifest_version_code", Long.valueOf(r9.c()));
    L22:
        r6.a(r8, r10, r11, null);
        return r6;
    }

    public static Header a(f r7, long r8, CrashType r10, int r11) {
        Header r6 = new Header();
        r6.a(r8);
        r6.a(r7, r10);
        r6.a(r8, r10, r11, null);
        return r6;
    }

    public static Header a(com.bytedance.crash.monitor.a r8, long r9, long r11, CrashType r13, int r14, File r15) {
        Header r7 = new Header();
        r7.a(r9);
        r7.a(r8, r9, r11, r15);
        r7.b(r15);
        r7.a(r11, r13, r14, r15);
        return r7;
    }

    private void a(long r1, CrashType r3, int r4, File r5) {
        f();
        g();
        a(r3);
        a(r3, r4, r1);
        a(r5);
    }

    private void a(CrashType r2) {
        l.a(b(), "crash_type", r2.getName());
    }

    private void a(CrashType r3, int r4, long r5) {
        l.a(b(), "unique_key", "android_" + c() + "_" + r5 + "_" + r4 + "_" + r3.getName());
    }

    private void f() {
        com.bytedance.crash.general.a.b(this.f7454a);
    }

    private void g() {
        com.bytedance.crash.general.a.a(this.f7454a);
        this.f7455b = com.bytedance.crash.general.a.b();
    }

    private void a(long r1) {
        com.bytedance.crash.general.a.a(this.f7454a, r1);
    }

    private void a(File r1) {
        LocaleInfo.putTo(this.f7454a, r1);
    }

    private void a(f r7, CrashType r8) {
        l.a(this.f7454a, "device_id", r7.a("0"));
        l.a(this.f7454a, "user_id", Long.valueOf(r7.g()));
        l.a(this.f7454a, "channel", r7.f());
        l.a(this.f7454a, "mp_params", r7.o());
        int r9 = Integer.parseInt(r7.e());     // Catch: Throwable -> L5
    L6:
        l.a(this.f7454a, WsConstants.KEY_APP_ID, Integer.valueOf(r9));
        com.bytedance.crash.monitor.c r10 = r7.h();
        if (r10.d() == null) goto L10;
        l.a(this.f7454a, WsConstants.KEY_APP_VERSION, r10.d());
    L10:
        if (r10.b() == 0) goto L13;
        l.a(this.f7454a, "version_code", Long.valueOf(r10.b()));
    L13:
        if (r10.a() == 0) goto L16;
        l.a(this.f7454a, "update_version_code", Long.valueOf(r10.a()));
    L16:
        if (r10.c() == 0) goto L18;
        l.a(this.f7454a, "manifest_version_code", Long.valueOf(r10.c()));
    L18:
        Map<String, Object> r11 = r7.b();
        if (r11 == null) goto L26;
        Iterator<String> r12 = r11.keySet().iterator();
    L22:
        if (r12.hasNext() == false) goto L34;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r12.next(), String.class, "com.obric.aiagent.plugin");
        if (r11.get(r0) == null) goto L22;
        l.a(this.f7454a, r0, r11.get(r0));
        goto L22
    L34:
        return;
    L26:
        return;
    L5:
        r9 = 4444;
        goto L6
    }

    private void b(File r1) {
        if (r1 == null) goto L5;
        d.a(this.f7454a, r1);
        return;
    }

    private void a(com.bytedance.crash.monitor.a r10, long r11, long r13, File r15) {
        l.a(this.f7454a, "device_id", r10.d(r13));
        l.a(this.f7454a, "user_id", Long.valueOf(r10.e(r13)));
        l.a(this.f7454a, "channel", r10.c(r13));
        l.a(this.f7454a, "mp_params", r10.o());
        int r0 = Integer.parseInt(r10.b(r13));     // Catch: Throwable -> L5
    L6:
        l.a(this.f7454a, WsConstants.KEY_APP_ID, Integer.valueOf(r0));
        if (com.bytedance.crash.dumper.a.a(this.f7454a, r15) == true) goto L36;
        long r2 = a();
        if (r2 > 0) goto L14;
    L23:
        com.bytedance.crash.monitor.c r12 = r10.f(r13);
        if (r12 != null) goto L26;
    L31:
        l.a(this.f7454a, "version_type", "app_info");
        return;
    L26:
        if (r12.b() == 0) goto L31;
        if (r12.d() == null) goto L31;
        l.a(this.f7454a, WsConstants.KEY_APP_VERSION, r12.d());
        l.a(this.f7454a, "update_version_code", Long.valueOf(r12.a()));
        l.a(this.f7454a, "version_code", Long.valueOf(r12.b()));
        l.a(this.f7454a, "manifest_version_code", Long.valueOf(r12.c()));
        l.a(this.f7454a, "version_type", "crash_time");
        return;
    L14:
        if (r11 <= r2) goto L23;
        com.bytedance.crash.monitor.c r14 = r10.a(r2);
        if (r14 == null) goto L23;
        if (r14.b() == 0) goto L23;
        if (r14.d() == null) goto L23;
        l.a(this.f7454a, WsConstants.KEY_APP_VERSION, r14.d());
        l.a(this.f7454a, "update_version_code", Long.valueOf(r14.a()));
        l.a(this.f7454a, "version_code", Long.valueOf(r14.b()));
        l.a(this.f7454a, "manifest_version_code", Long.valueOf(r14.c()));
        l.a(this.f7454a, "version_type", "last_update_time");
        return;
    L36:
        JSONObject r16 = this.f7454a;     // Catch: Throwable -> L33
        l.a(r16, "init_version_name", r16.opt("version_name"));     // Catch: Throwable -> L33
        JSONObject r17 = this.f7454a;     // Catch: Throwable -> L33
        l.a(r17, "init_update_version_code", r17.opt("update_version_code"));     // Catch: Throwable -> L33
    L9:
        l.a(this.f7454a, "version_type", "crash_dump");
        return;
    L5:
        r0 = 4444;
        goto L6
    }

    public long a() {
        return this.f7454a.optLong("last_update_time");
    }

    public JSONObject b() {
        return this.f7454a;
    }

    public String c() {
        return this.f7454a.optString("device_id");
    }

    public static boolean d() {
        if (f7453c != (-1)) goto L6;
        f7453c = com.bytedance.crash.general.b.b().contains("64") ? 1 : 0;
    L6:
        if (f7453c == 1) goto L10;
        return false;
    L10:
        return true;
    }

    public long e() {
        return this.f7455b;
    }
}
