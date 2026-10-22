package com.bytedance.frameworks.baselib.network.d;

import com.bytedance.frameworks.baselib.network.a.b;
import com.bytedance.retrofit2.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: NetworkLogReporter.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements c {
    public a() {
    }

    @Override // com.bytedance.retrofit2.c
    public void a(Runnable r9, final long r10) {
        final Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r9, Runnable.class, "com.obric.aiagent.plugin");
        final long r4 = 0;
        b.a(com.bytedance.frameworks.baselib.network.a.c.f7963a).a(new AnonymousClass1(this, r10, r4, r6));
    }
}
