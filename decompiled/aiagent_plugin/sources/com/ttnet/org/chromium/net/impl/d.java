package com.ttnet.org.chromium.net.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: CronetEngineBase.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class d extends com.ttnet.org.chromium.net.h {
    public abstract com.ttnet.org.chromium.net.ac a(com.ttnet.org.chromium.net.ac.b r1, Executor r2, int r3, List<String> r4, int r5, int r6, int r7);

    public abstract com.ttnet.org.chromium.net.ae a(com.ttnet.org.chromium.net.ae.b r1, Executor r2, List<String> r3, int r4, String r5, long r6, int r8, long r9, String r11, int r12, String r13, Map<String, String> r14, Map<String, String> r15, boolean r16);

    public abstract com.ttnet.org.chromium.net.ae a(com.ttnet.org.chromium.net.ae.b r1, Executor r2, List<String> r3, Map<String, String> r4, Map<String, String> r5, boolean r6);

    public abstract af a(String r1, com.ttnet.org.chromium.net.ai.b r2, Executor r3, int r4, Collection<Object> r5, boolean r6, boolean r7, boolean r8, boolean r9, int r10, boolean r11, int r12, com.ttnet.org.chromium.net.w.a r13, int r14, long r15);

    public d() {
    }

    @Override // com.ttnet.org.chromium.net.h, com.ttnet.org.chromium.net.d
    public /* synthetic */ com.ttnet.org.chromium.net.ai.a a(String r3, com.ttnet.org.chromium.net.ai.b r4, Executor r5) {
        return b(r3, r4, (Executor) ZeusTransformUtils.wrapperContextForParams(r5, Executor.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.ttnet.org.chromium.net.h
    public com.ttnet.org.chromium.net.i.a b(String r3, com.ttnet.org.chromium.net.ai.b r4, Executor r5) {
        return new ag(r3, r4, (Executor) ZeusTransformUtils.wrapperContextForParams(r5, Executor.class, "com.obric.aiagent.plugin"), this);
    }

    @Override // com.ttnet.org.chromium.net.d
    public com.ttnet.org.chromium.net.ae.a a(com.ttnet.org.chromium.net.ae.b r3, Executor r4) {
        return new ae(r3, (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.aiagent.plugin"), this);
    }

    @Override // com.ttnet.org.chromium.net.d
    public com.ttnet.org.chromium.net.ac.a a(com.ttnet.org.chromium.net.ac.b r3, Executor r4) {
        return new ac((com.ttnet.org.chromium.net.ac.b) ZeusTransformUtils.wrapperContextForParams(r3, com.ttnet.org.chromium.net.ac.b.class, "com.obric.aiagent.plugin"), (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.aiagent.plugin"), this);
    }
}
