package com.stepos.agentbus.generated;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/stepos/agentbus/generated/ChannelReadyContext;", "", "trigger", "Lcom/stepos/agentbus/generated/ChannelConnectTrigger;", AppAgent.CONSTRUCT, "(Lcom/stepos/agentbus/generated/ChannelConnectTrigger;)V", "getTrigger", "()Lcom/stepos/agentbus/generated/ChannelConnectTrigger;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ChannelReadyContext {
    private final ChannelConnectTrigger trigger;

    public ChannelReadyContext(ChannelConnectTrigger trigger) {
        k.f(trigger, "trigger");
        this.trigger = trigger;
    }

    public static /* synthetic */ ChannelReadyContext copy$default(ChannelReadyContext channelReadyContext, ChannelConnectTrigger channelConnectTrigger, int i, Object obj) {
        if ((i & 1) != 0) {
            channelConnectTrigger = channelReadyContext.trigger;
        }
        return channelReadyContext.copy(channelConnectTrigger);
    }

    /* renamed from: component1, reason: from getter */
    public final ChannelConnectTrigger getTrigger() {
        return this.trigger;
    }

    public final ChannelReadyContext copy(ChannelConnectTrigger trigger) {
        k.f(trigger, "trigger");
        return new ChannelReadyContext(trigger);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ChannelReadyContext) && this.trigger == ((ChannelReadyContext) other).trigger;
    }

    public final ChannelConnectTrigger getTrigger() {
        return this.trigger;
    }

    public int hashCode() {
        return this.trigger.hashCode();
    }

    public String toString() {
        return "ChannelReadyContext(trigger=" + this.trigger + ")";
    }
}
