package com.bytedance.apm6.consumer.slardar.b;

import android.app.Application;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.apm6.consumer.slardar.f;
import com.bytedance.apm6.util.e;
import com.bytedance.apm6.util.h;
import com.bytedance.common.wschannel.WsConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: HeaderManager.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f5069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, a> f5070b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f5071c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f5072d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f5073e;
    private com.bytedance.apm6.util.e.a f;

    public b() {
        this.f5070b = new ConcurrentHashMap();
        this.f5072d = -1;
        this.f5073e = -1;
    }

    static /* synthetic */ long a(b r0, long r1) {
        r0.f5073e = r1;
        return r1;
    }

    static /* synthetic */ com.bytedance.apm6.util.e.a a(b r0) {
        return r0.f;
    }

    static /* synthetic */ com.bytedance.apm6.util.e.a a(b r0, com.bytedance.apm6.util.e.a r1) {
        r0.f = r1;
        return r1;
    }

    static /* synthetic */ long b(b r0, long r1) {
        r0.f5072d = r1;
        return r1;
    }

    public static b a() {
        if (f5069a != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f5069a != null) goto L9;
        f5069a = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f5069a;
    }

    public void b() {
        a r5 = new a();
        r5.a("Android");
        r5.b("android");
        r5.c(Build.VERSION.RELEASE);
        r5.a(Build.VERSION.SDK_INT);
        r5.d(Build.MODEL);
        r5.e(Build.BRAND);
        r5.f(Build.MANUFACTURER);
        r5.g(com.bytedance.apm6.foundation.context.a.f());
        r5.a(com.bytedance.apm6.foundation.context.a.c());
        r5.h(h.a());
        r5.s(f.a());
        r5.c(com.bytedance.apm6.foundation.context.a.d());
        r5.j(com.bytedance.apm6.foundation.context.a.h());
        r5.b(com.bytedance.apm6.foundation.context.a.g());
        r5.b(com.bytedance.apm6.foundation.context.a.r());
        r5.k(String.valueOf(com.bytedance.apm6.foundation.context.a.i()));
        r5.o(com.bytedance.apm6.foundation.context.a.j());
        r5.n(String.valueOf(com.bytedance.apm6.foundation.context.a.k()));
        r5.l(com.bytedance.apm6.foundation.context.a.l());
        r5.p(com.bytedance.apm6.foundation.context.a.m());
        r5.q(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm6.foundation.context.a.getContext(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getPackageName());
        r5.t(r5.d());
        r5.m(com.bytedance.apm6.foundation.context.a.n());
        r5.d(com.bytedance.apm6.foundation.context.a.s());
        JSONObject r6 = new JSONObject();
        e.a(r6, com.bytedance.apm6.foundation.context.a.o());     // Catch: Exception -> L19
        if (r6.has("version_code") == false) goto L7;
        r6.remove("version_code");     // Catch: Exception -> L19
    L7:
        if (r6.has(WsConstants.KEY_APP_VERSION) == false) goto L10;
        r6.remove(WsConstants.KEY_APP_VERSION);     // Catch: Exception -> L19
    L10:
        if (r6.has("uid") == false) goto L13;
        r6.remove("uid");     // Catch: Exception -> L19
    L13:
        if (r6.has("update_version_code") == false) goto L16;
        r6.remove("update_version_code");     // Catch: Exception -> L19
    L16:
        if (r6.has("manifest_version_code") == false) goto L21;
        r6.remove("manifest_version_code");     // Catch: Exception -> L19
    L21:
        r5.b(r6);
        r5.r("5.0.21.41");
        if (com.bytedance.apm6.foundation.context.a.e() == false) goto L24;
        c.a().b();
    L24:
        b(r5);
        return;
    L19:
        e = move-exception;
        com.bytedance.apm6.util.c.b.d("APM", "header json exception" + e.toString());
        goto L21
    }

    public a a(String r3) {
        if (this.f5070b.containsKey(r3) == false) goto L5;
        a r4 = (a) ZeusTransformUtils.preCheckCast(this.f5070b.get(r3), a.class, "com.obric.aiagent.plugin");
    L8:
        a(r4);
        return r4;
    L5:
        a r0 = c.a().a(r3);
        if (r0 == null) goto L11;
        this.f5070b.put(r3, r0);
        r4 = r0;
        goto L8
    L11:
        return this.f5071c;
    }

    private void a(a r5) {
        if (r5 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r5.b()) == false) goto L7;
        r5.i(com.bytedance.apm6.foundation.context.a.p());
    L7:
        com.bytedance.apm6.foundation.context.b r0 = com.bytedance.apm6.foundation.context.a.b();
        if (r0 == null) goto L10;
        r5.a(r0.q());
    L10:
        long r1 = this.f5073e;
        if (r1 == (-1)) goto L13;
        r5.e(r1);
        r5.f(this.f5072d);
    L26:
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L28;
        com.bytedance.apm6.util.c.b.a(com.bytedance.apm6.consumer.slardar.a.f5054a, "nptTime:" + this.f5073e + " nptOffset:" + this.f5072d);
    L28:
        r5.b(com.bytedance.apm6.foundation.context.a.r());
        r5.d(com.bytedance.apm6.foundation.context.a.s());
        a r4 = this.f5071c;
        if (r4 == null) goto L34;
        r5.t(r4.d());
        return;
    L34:
        return;
    L13:
        final com.bytedance.apm.g.e r2 = com.bytedance.apm6.foundation.context.a.a();
        if (r2 == null) goto L26;
        if (this.f != null) goto L26;
        monitor-enter(b.class);
        this.f = new AnonymousClass1(this, r2);     // Catch: Throwable -> L22
        com.bytedance.apm6.util.e.b.a(com.bytedance.apm6.util.e.c.f5474b).a(this.f);     // Catch: Throwable -> L22
        monitor-exit(b.class);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    private void b(a r3) {
        String r0 = String.valueOf(d.a());
        this.f5070b.put(r0, r3);
        this.f5071c = r3;
        c.a().a(r0, r3);
    }
}
