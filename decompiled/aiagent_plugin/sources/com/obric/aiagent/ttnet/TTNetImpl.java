package com.obric.aiagent.ttnet;

import com.bytedance.ttnet.TTNetInit;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: TTNetImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class TTNetImpl implements ITTNet {
    public TTNetImpl() {
    }

    @Override // com.obric.aiagent.ttnet.ITTNet
    public void init(g r3, e r4) {
        o.e(r3, "config");
        o.e(r4, "requestRestrictConfig");
        h.f22239a.a(r3);
        a.f22195a.a();
        com.bytedance.ttnet.utils.d.a((com.bytedance.retrofit2.d.b) ZeusTransformUtils.preCheckCast(new com.obric.aiagent.ttnet.interceptor.a(r4, (b) ZeusTransformUtils.preCheckCast(f.f22233a, b.class, "com.obric.aiagent.plugin")), com.bytedance.retrofit2.d.b.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.ttnet.ITTNet
    public void addInterceptor(com.bytedance.retrofit2.d.b r2) {
        com.bytedance.retrofit2.d.b r1 = (com.bytedance.retrofit2.d.b) ZeusTransformUtils.wrapperContextForParams(r2, com.bytedance.retrofit2.d.b.class, "com.obric.aiagent.plugin");
        o.e(r1, "interceptor");
        com.bytedance.ttnet.utils.d.a(r1);
    }

    @Override // com.obric.aiagent.ttnet.ITTNet
    public b getRequestRestrictManager() {
        return (b) ZeusTransformUtils.preCheckCast(f.f22233a, b.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.ttnet.ITTNet
    public int getEffectiveConnectionType() {
        return TTNetInit.getEffectiveConnectionType();
    }

    @Override // com.obric.aiagent.ttnet.ITTNet
    public void onNetworkError(c r1) {
        o.e(r1, "biz");
        com.obric.aiagent.ttnet.c.b.f22223a.a(r1);
    }
}
