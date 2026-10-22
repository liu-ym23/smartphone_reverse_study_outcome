package com.bytedance.ttnet.h;

import com.bytedance.retrofit2.b.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SsRetrofitClient.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements com.bytedance.retrofit2.b.a {
    public d() {
    }

    @Override // com.bytedance.retrofit2.b.a
    public e a(com.bytedance.retrofit2.b.c r3) {
        if (ZeusTransformUtils.instanceOf(r3.l(), com.bytedance.frameworks.baselib.network.http.c.class) == false) goto L5;
        boolean r2 = ((com.bytedance.frameworks.baselib.network.http.c) ZeusTransformUtils.preCheckCast(r3.l(), com.bytedance.frameworks.baselib.network.http.c.class, "com.obric.aiagent.plugin")).l;
    L6:
        com.bytedance.frameworks.baselib.network.http.d r4 = com.bytedance.ttnet.c.a(r3.b(), r2);
        if (r4 != null) goto L11;
        return null;
    L11:
        return r4.a(r3);
    L5:
        r2 = false;
        goto L6
    }
}
