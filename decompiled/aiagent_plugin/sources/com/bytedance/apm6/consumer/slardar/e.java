package com.bytedance.apm6.consumer.slardar;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.common.utility.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: compiled from: SlardarHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements com.bytedance.apm6.monitor.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile e f5166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bytedance.apm6.consumer.slardar.c.c f5167b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.bytedance.apm6.consumer.slardar.a.a f5168c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile boolean f5169d;

    static {
        f5166a = new e();
    }

    public synchronized void a(com.bytedance.apm6.consumer.slardar.a.a r5) {
        monitor-enter(this);
        this.f5168c = r5;     // Catch: Throwable -> L11
        if (r5 == null) goto L7;
        com.bytedance.apm6.consumer.slardar.d.c.a().a(r5);     // Catch: Throwable -> L11
        c.a().b(r5.g());     // Catch: Throwable -> L11
        c.a().a(r5.f());     // Catch: Throwable -> L11
        com.bytedance.apm6.consumer.slardar.e.c.a().a(r5.h(), r5.i(), r5.j());     // Catch: Throwable -> L11
        com.bytedance.apm6.consumer.slardar.d.e.a(r5.a());     // Catch: Throwable -> L11
    L7:
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L9;
        com.bytedance.apm6.util.c.b.a(a.f5054a, "setSlardarHandlerConfig:" + r5);     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private e() {
        this.f5169d = false;
    }

    public static e a() {
        return f5166a;
    }

    @Override // com.bytedance.apm6.monitor.c
    public void a(com.bytedance.apm6.monitor.b r5) {
        com.bytedance.apm6.monitor.b r6 = (com.bytedance.apm6.monitor.b) ZeusTransformUtils.wrapperContextForParams(r5, com.bytedance.apm6.monitor.b.class, "com.obric.aiagent.plugin");
        if (this.f5169d == true) goto L5;
        b();
    L5:
        JSONObject r0 = r6.i();
        if (a.f5055b.contains(r6.g()) == false) goto L8;
    L17:
        a(r0, false);
    L19:
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L21;
        com.bytedance.apm.doctor.a.a(r6.g(), r0, true);
    L21:
        this.f5167b.a(r0);
        return;
    L8:
        if ("tracing".equals(r6.g()) == true) goto L17;
        if (com.bytedance.apm6.consumer.slardar.d.a.a.a().a(r0, com.bytedance.apm6.foundation.context.a.g()) == false) goto L13;
        a(r0, true);
        goto L19
    L13:
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L23;
        com.bytedance.apm.doctor.a.a(r6.g(), r0);
        com.bytedance.apm6.util.c.b.a(a.f5054a, "push failed: event(aid=" + com.bytedance.apm6.foundation.context.a.g() + " is downgraded: " + r0.toString());
        return;
    }

    private synchronized void b() {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L4:
        if (this.f5169d == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L11;
        com.bytedance.apm6.util.c.b.a(a.f5054a, "Initializing SlardarHandler...");     // Catch: Throwable -> L19
    L11:
        if (com.bytedance.apm.h.a.c() == null) goto L13;
        com.bytedance.apm.h.a.c().b(a.f5054a, "ensureInited");     // Catch: Throwable -> L19
    L13:
        com.bytedance.apm6.consumer.slardar.b.b.a().b();     // Catch: Throwable -> L19
        com.bytedance.apm6.consumer.slardar.d.a.a.a().a((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm6.foundation.context.a.getContext(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L19
        com.bytedance.apm6.consumer.slardar.a.b r0 = (com.bytedance.apm6.consumer.slardar.a.b) ZeusTransformUtils.preCheckCast(com.bytedance.apm6.service.c.a(com.bytedance.apm6.consumer.slardar.a.b.class), com.bytedance.apm6.consumer.slardar.a.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        if (r0 == null) goto L16;
        a(r0.a());     // Catch: Throwable -> L19
    L16:
        this.f5167b = new com.bytedance.apm6.consumer.slardar.c.c(com.bytedance.apm6.consumer.slardar.b.d.a(), b.d(), b.e());     // Catch: Throwable -> L19
        c.a().a(this.f5167b);     // Catch: Throwable -> L19
        com.bytedance.apm6.consumer.slardar.e.c.a().a(c.a());     // Catch: Throwable -> L19
        com.bytedance.apm6.consumer.slardar.e.c.a().a(com.bytedance.apm6.consumer.slardar.d.d.a());     // Catch: Throwable -> L19
        com.bytedance.apm6.consumer.slardar.e.c.a().b();     // Catch: Throwable -> L19
        c.a().b();     // Catch: Throwable -> L19
        com.bytedance.apm6.consumer.slardar.d.d.a().b();     // Catch: Throwable -> L19
        this.f5169d = true;     // Catch: Throwable -> L19
        monitor-exit(this);
    }

    private void a(JSONObject r7, boolean r8) {
    L27:
        e = move-exception;
        a(a.f5054a, "addExtension", e);
        return;
    L4:
        if (TextUtils.isEmpty(com.bytedance.apm6.foundation.context.a.q()) == true) goto L7;
        r7.put("session_id", com.bytedance.apm6.foundation.context.a.q());     // Catch: Exception -> L27
    L7:
        if (r7.isNull("network_type") == false) goto L16;
        i.b r3 = i.c((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm6.foundation.context.a.getContext(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L27
        r7.put("network_type", r3.a());     // Catch: Exception -> L27
        if (r3.b() == false) goto L11;
    L12:
        int r0 = com.bytedance.apm6.util.g.b((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm6.foundation.context.a.getContext(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L27
        if (r0 == (-10000)) goto L16;
        r7.put("network_type_code", r0);     // Catch: Exception -> L27
        goto L16
    L11:
        if (r3.c() == true) goto L12;
    L16:
        if (r7.isNull(DBHelper.COL_TIME) == false) goto L18;
    L19:
        r7.put(DBHelper.COL_TIME, System.currentTimeMillis());     // Catch: Exception -> L27
    L21:
        if (r7.isNull("sid") == false) goto L23;
        r7.put("sid", com.bytedance.apm6.foundation.context.a.c());     // Catch: Exception -> L27
    L23:
        r7.put("process_name", com.bytedance.apm6.foundation.context.a.f());     // Catch: Exception -> L27
        if (r8 == false) goto L32;
        r7.put("seq_no", d.a().b());     // Catch: Exception -> L27
        return;
    L32:
        return;
    L18:
        if (r7.optLong(DBHelper.COL_TIME) > 0) goto L21;
        goto L19
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
