package com.stepos.agentframework.adapter.agentbus;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR(\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0005\u0010\n\u001a\u0004\b\u000b\u0010\fR$\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/agentframework/adapter/agentbus/F;", "", "<init>", "()V", "Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding;", "binding", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding;)V", UxipConstants.f30680s, "Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding;", "getBinding", "()Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding;", "Lkotlin/Function1;", "onBindingCreated", "Lp9/l;", "Lkotlin/Function0;", "", "wakeClientIdProvider", "Lp9/a;", "wakeClientIdFallback", "Ljava/lang/String;", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class F {
    private static volatile ClawChannelAgentBusBinding binding;
    public static InterfaceC5074l<? super ClawChannelAgentBusBinding, Y8.t> onBindingCreated;
    public static InterfaceC5063a<String> wakeClientIdProvider;
    public static final F INSTANCE = new F();
    private static final String wakeClientIdFallback = "agentframework";

    public final void a(ClawChannelAgentBusBinding binding2) {
        InterfaceC5074l<? super ClawChannelAgentBusBinding, Y8.t> interfaceC5074l;
        kotlin.jvm.internal.p.i(binding2, "binding");
        boolean z10 = binding == null;
        binding = binding2;
        if (!z10 || (interfaceC5074l = onBindingCreated) == null) {
            return;
        }
        interfaceC5074l.invoke(binding2);
    }
}
