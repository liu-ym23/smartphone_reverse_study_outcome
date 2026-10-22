package com.stepos.ability.agentbusclient;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"toAgentBusBinding", "Lcom/stepos/ability/agentbusclient/AbilityAgentBusNodeAgentBusBinding;", "Lcom/stepos/ability/agentbusclient/AbilityAgentBusNode;", "context", "Landroid/content/Context;", "agentbus-client_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AbilityAgentBusNodeAgentBusBindingKt {
    public static final AbilityAgentBusNodeAgentBusBinding toAgentBusBinding(AbilityAgentBusNode abilityAgentBusNode) {
        k.f(abilityAgentBusNode, "<this>");
        return new AbilityAgentBusNodeAgentBusBinding(abilityAgentBusNode);
    }

    public static final AbilityAgentBusNodeAgentBusBinding toAgentBusBinding(AbilityAgentBusNode abilityAgentBusNode, Context context) {
        k.f(abilityAgentBusNode, "<this>");
        k.f(context, "context");
        AbilityAgentBusNodeAgentBusBinding abilityAgentBusNodeAgentBusBinding = new AbilityAgentBusNodeAgentBusBinding(abilityAgentBusNode);
        abilityAgentBusNodeAgentBusBinding.setPackageName(context.getPackageName());
        return abilityAgentBusNodeAgentBusBinding;
    }
}
