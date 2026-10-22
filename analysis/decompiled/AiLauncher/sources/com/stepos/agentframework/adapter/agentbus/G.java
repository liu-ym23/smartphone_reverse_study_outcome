package com.stepos.agentframework.adapter.agentbus;

import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a%\u0010\u0007\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\b\u001a!\u0010\u000b\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/stepos/agentframework/adapter/agentbus/ClawChannel;", "Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding;", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/agentframework/adapter/agentbus/ClawChannel;)Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding;", "", "clientId", "packageName", "c", "(Lcom/stepos/agentframework/adapter/agentbus/ClawChannel;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding;", "Landroid/content/Context;", "context", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/agentframework/adapter/agentbus/ClawChannel;Landroid/content/Context;Ljava/lang/String;)Lcom/stepos/agentframework/adapter/agentbus/ClawChannelAgentBusBinding;", "protocol_agentbus_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class G {
    public static final ClawChannelAgentBusBinding a(ClawChannel clawChannel) {
        kotlin.jvm.internal.p.i(clawChannel, "<this>");
        ClawChannelAgentBusBinding clawChannelAgentBusBinding = new ClawChannelAgentBusBinding(clawChannel);
        F.INSTANCE.a(clawChannelAgentBusBinding);
        return clawChannelAgentBusBinding;
    }

    public static final ClawChannelAgentBusBinding b(ClawChannel clawChannel, Context context, String clientId) {
        kotlin.jvm.internal.p.i(clawChannel, "<this>");
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(clientId, "clientId");
        return c(clawChannel, clientId, context.getPackageName());
    }

    public static final ClawChannelAgentBusBinding c(ClawChannel clawChannel, String clientId, String str) {
        kotlin.jvm.internal.p.i(clawChannel, "<this>");
        kotlin.jvm.internal.p.i(clientId, "clientId");
        ClawChannelAgentBusBinding clawChannelAgentBusBinding = new ClawChannelAgentBusBinding(clawChannel);
        clawChannelAgentBusBinding.O(clientId);
        if (str != null) {
            clawChannelAgentBusBinding.P(str);
        }
        F.INSTANCE.a(clawChannelAgentBusBinding);
        return clawChannelAgentBusBinding;
    }
}
