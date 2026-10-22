package com.bytedance.frameworks.baselib.network.f;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: RequestAuditParams.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f8088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<com.bytedance.retrofit2.b.b> f8089b;

    public a(String r3, List<com.bytedance.retrofit2.b.b> r4) {
        List<com.bytedance.retrofit2.b.b> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        this.f8088a = r3;
        this.f8089b = r5;
    }
}
