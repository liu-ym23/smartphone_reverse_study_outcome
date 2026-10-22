package com.stepos.agentframework.adapter.agentbus;

import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import p9.InterfaceC5063a;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* synthetic */ class ClawChannelAgentBusBinding$base$1 extends FunctionReferenceImpl implements InterfaceC5063a<String> {
    public ClawChannelAgentBusBinding$base$1(Object obj) {
        super(0, obj, ClawChannelAgentBusBinding.class, "resolveClientId", "resolveClientId()Ljava/lang/String;", 0);
    }

    @Override // p9.InterfaceC5063a
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public final String invoke() {
        return ((ClawChannelAgentBusBinding) this.receiver).K();
    }
}
