package org.chromium;

import android.os.Process;
import com.ttnet.org.chromium.net.impl.aa;
import com.ttnet.org.chromium.net.z;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: compiled from: CronetEventListener.java */
/* JADX INFO: loaded from: classes5.dex */
public class e extends z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile e f40533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f40534b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f40535c;

    public static e d() {
        if (f40533a != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f40533a != null) goto L9;
        f40533a = new e();     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return f40533a;
    }

    private e() {
        this.f40534b = false;
        this.f40535c = false;
    }

    public void b(boolean r1) {
        this.f40534b = r1;
    }

    @Override // com.ttnet.org.chromium.net.z
    public void a(String r1, String r2, String r3) {
        if (this.f40534b == false) goto L6;
        c.a().a(r1, r2, r3);
        return;
    }

    @Override // com.ttnet.org.chromium.net.z
    public void a(String r1) {
        if (this.f40534b == false) goto L6;
        c.a().a(r1);
        return;
    }

    @Override // com.ttnet.org.chromium.net.z
    public void a(String r9, String r10, int r11, int r12, int r13, List<String> r14, String r15) {
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r14, List.class, "com.obric.aiagent.plugin");
        c.a().a(r9, r10, r11, r12, r13, r6, r15);
    }

    public void a(String r1, int r2) {
        if (this.f40534b == false) goto L6;
        c.a().a(r1, r2);
        return;
    }

    @Override // com.ttnet.org.chromium.net.z
    public void a() {
        if (this.f40534b == false) goto L6;
        c.a().b();
        return;
    }

    @Override // com.ttnet.org.chromium.net.z
    public void a(int r1) {
        c.a().a(r1);
    }

    @Override // com.ttnet.org.chromium.net.z
    public void a(int r1, int r2, int r3) {
        c.a().a(r1, r2, r3);
    }

    @Override // com.ttnet.org.chromium.net.z
    public void a(int r11, double r12, double r14, double r16, double r18) {
        c.a().a(r11, r12, r14, r16, r18);
    }

    @Override // com.ttnet.org.chromium.net.z
    public void b(int r1) {
        c.a().b(r1);
    }

    @Override // com.ttnet.org.chromium.net.z
    public void b(String r1) {
        if (this.f40534b == false) goto L6;
        c.a().b(r1);
        return;
    }

    @Override // com.ttnet.org.chromium.net.z
    public void b() {
        com.bytedance.retrofit2.e.f.b();
    }

    @Override // com.ttnet.org.chromium.net.z
    public void a(List<String> r3, List<String> r4) {
        List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if (this.f40534b == false) goto L6;
        c.a().a(r5, r6);
        return;
    }

    @Override // com.ttnet.org.chromium.net.z
    public void a(String r8, String r9, String r10, String r11, String r12, String r13) {
        if (this.f40534b == false) goto L6;
        c.a().a(r8, r9, r10, r11, r12, r13);
        return;
    }

    @Override // com.ttnet.org.chromium.net.z
    public void a(boolean r3, List<Integer> r4) {
        List<Integer> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if (this.f40534b == false) goto L6;
        c.a().a(r3, r5);
        return;
    }

    @Override // com.ttnet.org.chromium.net.z
    public void a(String[] r1, String r2) {
        if (this.f40534b == false) goto L6;
        c.a().a(r1, r2);
        return;
    }

    @Override // com.ttnet.org.chromium.net.z
    public Map<String, String> a(String r2, Map<String, String> r3) {
        Map<String, String> r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        return c.a().a(r2, r1);
    }

    @Override // com.ttnet.org.chromium.net.z
    public String a(String r2, Map<String, String> r3, List<String> r4) {
        return com.bytedance.frameworks.baselib.network.http.f.a(r2, (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.ttnet.org.chromium.net.z
    public String a(String r2, Map<String, List<String>> r3, int r4) {
        return com.bytedance.frameworks.baselib.network.http.f.a(r2, (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin"), r4);
    }

    @Override // com.ttnet.org.chromium.net.z
    public String b(String r2, Map<String, String> r3) {
        return com.bytedance.frameworks.baselib.network.http.cronet.a.a(r2, (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.ttnet.org.chromium.net.z
    public void a(long r8, long r10, long r12, long r14, long r16, long r18, long r20, long r22, long r24, long r26, long r28, long r30, long r32, long r34, long r36, long r38) {
        if (this.f40535c == false) goto L5;
        com.bytedance.frameworks.baselib.network.c.a(true);
    L5:
        com.bytedance.frameworks.baselib.network.c r1 = com.bytedance.frameworks.baselib.network.c.c();
        r1.f7998d = Process.getThreadPriority(0);
        r1.G = aa.f38079c;
        r1.H = aa.f38080d;
        r1.I = aa.f38077a;
        r1.f7995J = aa.f38078b;
        r1.K = aa.f38081e;
        r1.M = aa.f;
        r1.L = System.nanoTime();
        r1.O = r8;
        r1.P = r10;
        r1.Q = r12;
        r1.N = r14;
        r1.R = r16;
        r1.S = r18;
        r1.T = r20;
        r1.U = r22;
        r1.V = r24;
        r1.W = r26;
        r1.X = r28;
        r1.Y = r30;
        r1.Z = r32;
        r1.aa = r34;
        r1.ab = r36;
        r1.ac = r38;
        final long r3 = c.a().F();
        if (com.bytedance.frameworks.baselib.network.c.c().e() == true) goto L11;
        com.bytedance.common.utility.a.a.b().schedule(new AnonymousClass1(this, r3), 5, TimeUnit.SECONDS);
        if (this.f40535c == true) goto L16;
        com.bytedance.frameworks.baselib.network.c.a(true);
        return;
    L16:
        return;
    L11:
        JSONObject r2 = com.bytedance.frameworks.baselib.network.c.c().d();
        JSONObject r4 = com.bytedance.frameworks.baselib.network.c.c().a(r3);
        if (this.f40535c == true) goto L14;
        com.bytedance.frameworks.baselib.network.c.a(true);
    L14:
        c.a().a(r2.toString(), "ttnet_init");
        c.a().a(r4.toString(), "ttnet_init_v2");
    }

    @Override // com.ttnet.org.chromium.net.z
    public void c() {
        if (this.f40534b == false) goto L6;
        c.a().c();
        return;
    }

    @Override // com.ttnet.org.chromium.net.z
    public void a(int r1, int r2) {
        c.a().a(r1, r2);
    }

    @Override // com.ttnet.org.chromium.net.z
    public void b(int r1, int r2) {
        c.a().b(r1, r2);
    }

    @Override // com.ttnet.org.chromium.net.z
    public void a(boolean r1) {
        c.a().a(r1);
    }

    @Override // com.ttnet.org.chromium.net.z
    public void c(int r1) {
        c.a().c(r1);
    }

    @Override // com.ttnet.org.chromium.net.z
    public void b(int r1, int r2, int r3) {
        c.a().b(r1, r2, r3);
    }

    @Override // com.ttnet.org.chromium.net.z
    public void a(boolean r1, boolean r2, int r3) {
        c.a().a(r1, r2, r3);
    }
}
