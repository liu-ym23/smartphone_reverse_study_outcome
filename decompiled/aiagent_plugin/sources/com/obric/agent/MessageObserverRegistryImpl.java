package com.obric.agent;

import com.obric.agent.im.IMessageObserverRegistry;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: MessageObserverRegistryImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageObserverRegistryImpl implements IMessageObserverRegistry {
    public MessageObserverRegistryImpl() {
    }

    @Override // com.obric.agent.im.IMessageObserverRegistry
    public void register(com.obric.agent.im.d r2) {
        com.obric.agent.im.d r1 = (com.obric.agent.im.d) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.agent.im.d.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "observer");
        k.f15191a.a(r1);
    }

    @Override // com.obric.agent.im.IMessageObserverRegistry
    public void unregister(com.obric.agent.im.d r2) {
        com.obric.agent.im.d r1 = (com.obric.agent.im.d) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.agent.im.d.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "observer");
        k.f15191a.b(r1);
    }
}
