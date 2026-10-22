package a4;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentbus.generated.ChannelConnectTrigger;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"La4/q;", "", "Lcom/stepos/agentbus/generated/ChannelConnectTrigger;", "trigger", "<init>", "(Lcom/stepos/agentbus/generated/ChannelConnectTrigger;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Lcom/stepos/agentbus/generated/ChannelConnectTrigger;", "getTrigger", "()Lcom/stepos/agentbus/generated/ChannelConnectTrigger;", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: a4.q, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class ChannelReadyEvent {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final ChannelConnectTrigger trigger;

    public ChannelReadyEvent(ChannelConnectTrigger trigger) {
        kotlin.jvm.internal.p.i(trigger, "trigger");
        this.trigger = trigger;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ChannelReadyEvent) && this.trigger == ((ChannelReadyEvent) other).trigger;
    }

    public int hashCode() {
        return this.trigger.hashCode();
    }

    public String toString() {
        return "ChannelReadyEvent(trigger=" + this.trigger + ")";
    }
}
