package com.stepos.agentbus.generated;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/stepos/agentbus/generated/ChannelReadyEvent;", "", "trigger", "Lcom/stepos/agentbus/generated/ChannelConnectTrigger;", AppAgent.CONSTRUCT, "(Lcom/stepos/agentbus/generated/ChannelConnectTrigger;)V", "getTrigger", "()Lcom/stepos/agentbus/generated/ChannelConnectTrigger;", "fromWake", "", "getFromWake", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ChannelReadyEvent {
    private final ChannelConnectTrigger trigger;

    public ChannelReadyEvent(ChannelConnectTrigger trigger) {
        k.f(trigger, "trigger");
        this.trigger = trigger;
    }

    public static /* synthetic */ ChannelReadyEvent copy$default(ChannelReadyEvent channelReadyEvent, ChannelConnectTrigger channelConnectTrigger, int i, Object obj) {
        if ((i & 1) != 0) {
            channelConnectTrigger = channelReadyEvent.trigger;
        }
        return channelReadyEvent.copy(channelConnectTrigger);
    }

    /* renamed from: component1, reason: from getter */
    public final ChannelConnectTrigger getTrigger() {
        return this.trigger;
    }

    public final ChannelReadyEvent copy(ChannelConnectTrigger trigger) {
        k.f(trigger, "trigger");
        return new ChannelReadyEvent(trigger);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ChannelReadyEvent) && this.trigger == ((ChannelReadyEvent) other).trigger;
    }

    public final boolean getFromWake() {
        return this.trigger == ChannelConnectTrigger.WAKE;
    }

    public final ChannelConnectTrigger getTrigger() {
        return this.trigger;
    }

    public int hashCode() {
        return this.trigger.hashCode();
    }

    public String toString() {
        return "ChannelReadyEvent(trigger=" + this.trigger + ")";
    }
}
