package com.bytedance.memory.h;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.apm.util.m;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.memory.b.b;
import com.bytedance.memory.b.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: MemoryNetApi.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static List<String> f8828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static List<String> f8829b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static List<String> f8830c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f8831d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f8832e;
    private static volatile boolean f;

    public a() {
    }

    static {
        f8828a = new ArrayList();
        f8829b = new ArrayList();
        f8830c = new ArrayList();
        f8831d = "hprof_force_upload";
        f8832e = "upload_when_not_wifi";
        f = false;
    }

    public static void a(final String r2) {
        b.f8771b.a(new AnonymousClass1(r2), "uploadClientResult-MNA");
    }

    public static void a() {
        monitor-enter(a.class);
    L42:
        th = move-exception;
        throw th;
    L5:
        if (f == false) goto L7;
    L40:
        monitor-exit(a.class);     // Catch: Throwable -> L42
        return;
    L7:
        if (TextUtils.isEmpty(com.bytedance.memory.heap.a.a().f()) == true) goto L40;
        boolean r1 = true;
        f = true;     // Catch: Throwable -> L42
        if (m.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.memory.a.a.c().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == false) goto L12;
    L16:
        monitor-exit(a.class);     // Catch: Throwable -> L42
        c.a("MemoryNetApi uploadFile begin", new Object[0]);     // Catch: Throwable -> L36
        JSONObject r0 = com.bytedance.apm.c.q();     // Catch: Throwable -> L36
        r0.put("update_version_code", com.bytedance.memory.heap.a.a().g());     // Catch: Throwable -> L36
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L36
        r2.put("event_type", "memory_object_monitor");     // Catch: Throwable -> L36
        r2.put("hprof_type", com.bytedance.memory.heap.a.a().h());     // Catch: Throwable -> L36
        r2.put(DBHelper.COL_TIME, com.bytedance.memory.heap.a.a().i());     // Catch: Throwable -> L36
        HashMap r4 = new HashMap(2);     // Catch: Throwable -> L36
        r4.put("header", r0.toString());     // Catch: Throwable -> L36
        r4.put("data", r2.toString());     // Catch: Throwable -> L36
        ArrayList r3 = new ArrayList(1);     // Catch: Throwable -> L36
        r3.add(new File(com.bytedance.memory.heap.a.a().f()));     // Catch: Throwable -> L36
        com.bytedance.memory.d.a.a("upload_dump");     // Catch: Throwable -> L36
        List<String> r5 = f8829b;     // Catch: Throwable -> L36
        if (r5 != null) goto L20;
    L34:
        com.bytedance.memory.d.a.a("error_dumpcollect_url_null");     // Catch: Throwable -> L36
    L38:
        f = false;
        return;
    L20:
        if (r5.size() <= 0) goto L34;
        Iterator<String> r6 = f8829b.iterator();     // Catch: Throwable -> L36
    L23:
        if (r6.hasNext() == false) goto L31;
        com.bytedance.services.apm.api.c r7 = com.bytedance.apm.c.a((String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.aiagent.plugin"), r3, r4);     // Catch: Throwable -> L36
        if (r7 != null) goto L26;
        c.a("MemoryNetApi uploadFile failed, response is null", new Object[0]);     // Catch: Throwable -> L36
        goto L23
    L26:
        String r8 = new String(r7.b());     // Catch: Throwable -> L36
        if (TextUtils.isEmpty(r8) == true) goto L28;
        c.a("MemoryNetApi uploadFile failed,message:" + r8, new Object[0]);     // Catch: Throwable -> L36
        goto L23
    L28:
        c.a("MemoryNetApi uploadFile succeed", new Object[0]);     // Catch: Throwable -> L36
        com.bytedance.memory.heap.a.a().m();     // Catch: Throwable -> L36
        com.bytedance.memory.d.a.a("upload_dump_success");     // Catch: Throwable -> L36
        com.bytedance.memory.i.a.a().a(false);     // Catch: Throwable -> L36
    L32:
        if (r1 == true) goto L38;
        com.bytedance.memory.d.a.a("error_uploadfile_failed");     // Catch: Throwable -> L36
        goto L38
    L31:
        r1 = false;
    L36:
        th = move-exception;
        com.bytedance.apm.h.a.a("MemoryNetApi", th.toString());
        com.bytedance.services.apm.api.a.a(th);
        com.bytedance.memory.d.a.a("error_uploadfile_exception");
        goto L38
    L12:
        if (com.bytedance.memory.d.a.c(f8832e) == true) goto L16;
        com.bytedance.memory.d.a.a("error_not_wifi_in_upload");     // Catch: Throwable -> L42
        c.a("not wifi, not upload", new Object[0]);     // Catch: Throwable -> L42
        monitor-exit(a.class);     // Catch: Throwable -> L42
    }

    public static void b() {
        if (com.bytedance.memory.c.b.i().e() == true) goto L9;
        if (com.bytedance.memory.c.b.i().g().exists() == false) goto L54;
        com.bytedance.memory.heap.a.a().m();
        com.bytedance.memory.d.a.a("error_corruppted_hprof");
        return;
    L54:
        return;
    L9:
        if (m.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.memory.a.a.c().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")) == false) goto L11;
    L14:
        File r0 = com.bytedance.memory.c.b.i().g();
        if (r0.exists() == false) goto L20;
        if (r0.lastModified() >= (System.currentTimeMillis() - 604800000)) goto L20;
        com.bytedance.memory.heap.a.a().m();
        com.bytedance.memory.d.a.a("error_expired_heap_hprof");
    L20:
        if (TextUtils.isEmpty(com.bytedance.memory.heap.a.a().f()) == true) goto L27;
        File r1 = new File(com.bytedance.memory.heap.a.a().f());
        if (r1.exists() == false) goto L27;
        if (r1.lastModified() >= (System.currentTimeMillis() - 604800000)) goto L27;
        com.bytedance.memory.heap.a.a().m();
        com.bytedance.memory.d.a.a("error_expired_zip_hprof");
    L27:
        if (TextUtils.equals(com.bytedance.apm.c.q().optString("update_version_code", ""), com.bytedance.memory.heap.a.a().g()) == true) goto L31;
        com.bytedance.memory.heap.a.a().m();
        com.bytedance.memory.d.a.a("error_version_mismatch");
        return;
    L31:
        if (com.bytedance.memory.d.a.c(f8831d) == false) goto L49;
    L47:
        com.bytedance.memory.heap.a.a().l();
        return;
    L49:
        List<String> r2 = f8828a;     // Catch: Exception -> L45
        if (r2 == null) goto L47;
        if (r2.size() <= 0) goto L47;
        Iterator<String> r3 = f8828a.iterator();     // Catch: Exception -> L45
    L38:
        if (r3.hasNext() == false) goto L47;
        com.bytedance.services.apm.api.c r4 = com.bytedance.apm.c.a(String.format((String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.aiagent.plugin"), new Object[]{Integer.valueOf(com.bytedance.apm.c.q().optInt(WsConstants.KEY_APP_ID, 0))}), null);     // Catch: Exception -> L45
        if (r4 == null) goto L38;
        boolean r5 = new JSONObject(new String(r4.b())).optBoolean("should_upload");     // Catch: Exception -> L45
        c.a("uploadCheck with api: shouldUpload " + r5, new Object[0]);     // Catch: Exception -> L45
        if (r5 == true) goto L47;
        com.bytedance.memory.d.a.a("error_forbid_upload");     // Catch: Exception -> L45
        return;
    L45:
        e = move-exception;
        e.printStackTrace();
        goto L47
    L11:
        if (com.bytedance.memory.d.a.c(f8832e) == true) goto L14;
        com.bytedance.memory.d.a.a("error_not_wifi_in_uploadcheck");
        c.a("not wifi, not upload", new Object[0]);
    }
}
