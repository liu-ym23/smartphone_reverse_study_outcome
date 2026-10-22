package com.bytedance.ttnet.f;

import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: OkHttpAppInfoProvider.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements com.bytedance.frameworks.baselib.network.http.ok3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f11440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ICronetAppProvider f11441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private d f11442c;

    public static a f() {
        if (f11440a != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f11440a != null) goto L9;
        f11440a = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f11440a;
    }

    private a() {
    }

    public void a(ICronetAppProvider r3) {
        this.f11441b = (ICronetAppProvider) ZeusTransformUtils.wrapperContextForParams(r3, ICronetAppProvider.class, "com.obric.aiagent.plugin");
    }

    public void a(d r3) {
        this.f11442c = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.a
    public int a() {
        d r0 = this.f11442c;
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.g();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.a
    public String b() {
        d r2 = this.f11442c;
        if (r2 != null) goto L5;
        return null;
    L5:
        return (String) ZeusTransformUtils.preCheckCast(r2.h().get(TTNetInit.DOMAIN_HTTPDNS_KEY), String.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.a
    public String[] c() {
        if (ZeusTransformUtils.instanceOf(this.f11442c, com.bytedance.ttnet.a.class) == true) goto L5;
        return null;
    L5:
        return ((com.bytedance.ttnet.a) ZeusTransformUtils.preCheckCast(this.f11442c, com.bytedance.ttnet.a.class, "com.obric.aiagent.plugin")).e();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.a
    public String[] d() {
        if (ZeusTransformUtils.instanceOf(this.f11442c, com.bytedance.ttnet.a.class) == true) goto L5;
        return null;
    L5:
        return ((com.bytedance.ttnet.a) ZeusTransformUtils.preCheckCast(this.f11442c, com.bytedance.ttnet.a.class, "com.obric.aiagent.plugin")).d();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.a
    public List<String> e() {
        ICronetAppProvider r0 = this.f11441b;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getAbSdkVersion();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.a
    public void a(String r1, String r2) {
        ICronetAppProvider r0 = this.f11441b;
        if (r0 == null) goto L6;
        r0.sendAppMonitorEvent(r1, r2);
        return;
    }
}
