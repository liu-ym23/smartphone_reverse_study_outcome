package com.ss.bduploader.net;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.ab;
import okhttp3.ac;
import okhttp3.x;
import okhttp3.z;
import org.json.JSONObject;

/* JADX INFO: compiled from: BDHTTPNetwork.java */
/* JADX INFO: loaded from: classes4.dex */
public class a extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f37509a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static z f37510b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private okhttp3.e f37511c;

    public a() {
    }

    static {
        f37509a = x.c("application/json");
    }

    @Override // com.ss.bduploader.net.g
    public void a(String r6, Map<String, String> r7, g.a r8) {
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        final g.a r10 = (g.a) ZeusTransformUtils.wrapperContextForParams(r8, g.a.class, "com.obric.aiagent.plugin");
        monitor-enter(a.class);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (f37510b != null) goto L7;
        f37510b = new z().E().a(10, TimeUnit.SECONDS).c(10, TimeUnit.SECONDS).b(10, TimeUnit.SECONDS).E();     // Catch: Throwable -> L16
    L7:
        monitor-exit(a.class);     // Catch: Throwable -> L16
        ab.a r11 = new ab.a().a(r6);
        if (r9 == null) goto L14;
        Iterator r0 = r9.keySet().iterator();
    L12:
        if (r0.hasNext() == false) goto L14;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.aiagent.plugin");
        r11.a(r1, (String) ZeusTransformUtils.preCheckCast(r9.get(r1), String.class, "com.obric.aiagent.plugin"));
    L14:
        ab r12 = r11.b();
        okhttp3.e r13 = f37510b.a(r12);
        this.f37511c = r13;
        r13.a(new AnonymousClass1(this, r10));
    }

    @Override // com.ss.bduploader.net.g
    public void a(String r6, Map<String, String> r7, JSONObject r8, int r9, g.a r10) {
        Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        final g.a r12 = (g.a) ZeusTransformUtils.wrapperContextForParams(r10, g.a.class, "com.obric.aiagent.plugin");
        monitor-enter(a.class);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (f37510b != null) goto L7;
        f37510b = new z().E().a(10, TimeUnit.SECONDS).c(10, TimeUnit.SECONDS).b(10, TimeUnit.SECONDS).E();     // Catch: Throwable -> L21
    L7:
        monitor-exit(a.class);     // Catch: Throwable -> L21
        ab.a r13 = new ab.a().a(r6);
        if (r11 == null) goto L17;
        if (r11.size() <= 0) goto L17;
        Iterator r0 = r11.keySet().iterator();
    L14:
        if (r0.hasNext() == false) goto L17;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.aiagent.plugin");
        r13.b(r1, (String) ZeusTransformUtils.preCheckCast(r11.get(r1), String.class, "com.obric.aiagent.plugin"));
    L17:
        if (r9 != 1) goto L19;
        r13.a(ac.a(f37509a, String.valueOf(r8)));
    L19:
        okhttp3.e r14 = f37510b.a(r13.b());
        this.f37511c = r14;
        r14.a(new AnonymousClass2(this, r12));
    }

    @Override // com.ss.bduploader.net.g
    public void a() {
        okhttp3.e r0 = this.f37511c;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.d() == true) goto L9;
        this.f37511c.c();
        return;
    }
}
