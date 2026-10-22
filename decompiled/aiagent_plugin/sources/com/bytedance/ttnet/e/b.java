package com.bytedance.ttnet.e;

import android.content.Context;
import com.bytedance.frameworks.baselib.network.http.cronet.b.i;
import com.bytedance.ttnet.TTNetInit;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: TTDnsQuery.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f11424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f11425c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map<String, String> f11426d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private CountDownLatch f11427e;
    private c f;

    b(String r3, int r4, Map<String, String> r5) {
        Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        this.f11423a = r3;
        this.f11424b = r4;
        this.f11426d = r6;
        this.f11425c = UUID.randomUUID().toString();
        this.f11427e = new CountDownLatch(1);
    }

    public String a() {
        return this.f11425c;
    }

    public void b() {
        this.f11427e.await();
    }

    public void c() {
        this.f11427e.countDown();
    }

    public c d() {
        return this.f;
    }

    public void setResult(c r1) {
        this.f = r1;
    }

    public void e() {
        i.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(TTNetInit.getTTNetDepend().getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).a(this.f11423a, this.f11424b, this.f11425c, this.f11426d);
    }
}
