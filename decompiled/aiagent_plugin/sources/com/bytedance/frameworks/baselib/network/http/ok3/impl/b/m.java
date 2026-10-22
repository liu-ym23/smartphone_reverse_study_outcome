package com.bytedance.frameworks.baselib.network.http.ok3.impl.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: URLRequest.java */
/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f8462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f8463b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f8464c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<com.bytedance.retrofit2.b.b> f8465d;

    public m(String r1, String r2) {
        this.f8462a = r1;
        this.f8463b = r2;
        this.f8464c = 0;
        this.f8465d = null;
    }

    public m(String r3, String r4, List<com.bytedance.retrofit2.b.b> r5) {
        List<com.bytedance.retrofit2.b.b> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        this.f8462a = r3;
        this.f8463b = r4;
        this.f8464c = 0;
        this.f8465d = r6;
    }

    public String a() {
        return this.f8463b;
    }

    public String b() {
        return this.f8462a;
    }

    public void a(int r1) {
        this.f8464c = r1;
    }

    public int c() {
        return this.f8464c;
    }

    public List<com.bytedance.retrofit2.b.b> d() {
        return this.f8465d;
    }
}
