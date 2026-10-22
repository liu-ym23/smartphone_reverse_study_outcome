package com.obric.autogui.resourcemanage;

import com.bytedance.apm.battery.dao.DBHelper;
import com.obric.autogui.common.api.AOBizTracking;
import com.obric.autogui.common.api.platform.tracking.IAutoActionTrackingApi;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: ResourceInternals.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ah {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ah f30609a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, ag> f30610b = null;

    private ah() {
    }

    static {
        f30609a = new ah();
        f30610b = new ConcurrentHashMap();
    }

    public final ag a(o r8, v r9, k r10, long r11, String r13) {
        d.h.b.o.e(r8, "description");
        d.h.b.o.e(r9, "requestParams");
        d.h.b.o.e(r10, DBHelper.BATTERY_COL_SCENE);
        ag r7 = new ag(r8.g(), r8.d(), r8.e(), r8.f(), r9.b(), r10.name());
        r7.a(r11);
        r7.a(r13);
        ((Map) ZeusTransformUtils.preCheckCast(f30610b, Map.class, "com.obric.aiagent.plugin")).put(r8.g(), r7);
        return r7;
    }

    public final void a(String r3, long r4) {
        d.h.b.o.e(r3, "uniqueKey");
        ag r2 = (ag) ZeusTransformUtils.preCheckCast(f30610b.get(r3), ag.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L6;
        r2.b(r4 - r2.f());
        return;
    }

    public final void a(String r2) {
        d.h.b.o.e(r2, "uniqueKey");
        ag r1 = (ag) ZeusTransformUtils.preCheckCast(f30610b.get(r2), ag.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L6;
        r1.a(true);
        return;
    }

    public final void b(String r2, long r3) {
        d.h.b.o.e(r2, "uniqueKey");
        ag r1 = (ag) ZeusTransformUtils.preCheckCast(f30610b.get(r2), ag.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L6;
        r1.c(r3);
        return;
    }

    public final void a(String r5, long r6, long r8) {
        d.h.b.o.e(r5, "uniqueKey");
        ag r4 = (ag) ZeusTransformUtils.preCheckCast(f30610b.get(r5), ag.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.j() <= 0) goto L7;
        long r7 = r6 - r4.j();
    L8:
        r4.d(r7);
        r4.e(r8);
        r4.a(true);
        return;
    L7:
        r7 = -1;
        goto L8
    }

    public final void c(String r5, long r6) {
        d.h.b.o.e(r5, "uniqueKey");
        ag r4 = (ag) ZeusTransformUtils.preCheckCast(f30610b.get(r5), ag.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.j() <= 0) goto L7;
        long r7 = r6 - r4.j();
    L8:
        r4.d(r7);
        r4.a(false);
        return;
    L7:
        r7 = -1;
        goto L8
    }

    public final void a(String r2, long r3, boolean r5) {
        d.h.b.o.e(r2, "uniqueKey");
        ag r1 = (ag) ZeusTransformUtils.preCheckCast(f30610b.get(r2), ag.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L6;
        r1.f(r3);
        r1.b(Boolean.valueOf(r5));
        return;
    }

    public final void a(String r2, long r3, boolean r5, int r6) {
        d.h.b.o.e(r2, "uniqueKey");
        ag r1 = (ag) ZeusTransformUtils.preCheckCast(f30610b.get(r2), ag.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L6;
        r1.g(r3);
        r1.c(Boolean.valueOf(r5));
        r1.a(r6);
        return;
    }

    public final void a(String r2, boolean r3) {
        d.h.b.o.e(r2, "uniqueKey");
        ag r1 = (ag) ZeusTransformUtils.preCheckCast(f30610b.get(r2), ag.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L6;
        r1.d(Boolean.valueOf(r3));
        r1.h(System.currentTimeMillis());
        return;
    }

    public final void a(String r3, d.h.a.b<? super JSONObject, d.x> r4) {
        d.h.a.b<? super JSONObject, d.x> r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "uniqueKey");
        c(r3, System.currentTimeMillis());
        a(r3, false);
        b(r3, r5);
    }

    public final void b(String r10, d.h.a.b<? super JSONObject, d.x> r11) {
        d.h.a.b r9 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r11, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "uniqueKey");
        ag r12 = (ag) ZeusTransformUtils.preCheckCast(f30610b.remove(r10), ag.class, "com.obric.aiagent.plugin");
        if (r12 != null) goto L5;
        return;
    L5:
        JSONObject r3 = new JSONObject();
        r3.put("pkg", r12.a());
        r3.put("version_code", r12.b());
        r3.put("md5", r12.c());
        r3.put("resource_key", r12.d());
        r3.put(DBHelper.BATTERY_COL_SCENE, r12.e());
        r3.put("request_cost_ms", r12.g());
        r3.put("log_id", r12.h());
        r3.put("cache_hit", r12.i());
        r3.put("download_cost_ms", r12.k());
        r3.put("download_bytes", r12.l());
        r3.put("download_succeeded", r12.m());
        r3.put("verify_cost_ms", r12.n());
        r3.put("verify_succeeded", r12.o());
        r3.put("unzip_cost_ms", r12.p());
        r3.put("unzip_succeeded", r12.q());
        r3.put("unzip_retry_limit", r12.r());
        r3.put("install_succeeded", r12.s());
        if (r12.j() <= 0) goto L8;
        long r1 = r12.j();
    L10:
        if (r12.t() > 0) goto L12;
    L14:
        long r13 = -1;
    L15:
        r3.put("total_cost_ms", r13);
        if (r9 != null) goto L23;
    L21:
        IAutoActionTrackingApi.DefaultImpls.reportEvent$default((IAutoActionTrackingApi) ZeusTransformUtils.preCheckCast(AOBizTracking.INSTANCE, IAutoActionTrackingApi.class, "com.obric.aiagent.plugin"), "zeus_resource_download", r3, false, false, null, 28, null);
        return;
    L23:
        r9.invoke(r3);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        com.obric.autogui.resourcemanage.a.b.a("zeus_resource_download", "error happen when try to report: ", th);
        goto L21
    L12:
        if (r1 <= 0) goto L14;
        r13 = r12.t() - r1;
        goto L15
    L8:
        r1 = r12.f();
        goto L10
    }
}
