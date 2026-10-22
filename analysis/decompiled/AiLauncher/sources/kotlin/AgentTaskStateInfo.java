package kotlin;

import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.common.AgentTaskState;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\t¨\u0006\u0016"}, d2 = {"LK6/c;", "", "Lcom/stepos/common/AgentTaskState;", VoiceWakeupReceiver.EXTRA_STATE, "", "details", "<init>", "(Lcom/stepos/common/AgentTaskState;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/common/AgentTaskState;", "getState", "()Lcom/stepos/common/AgentTaskState;", "Ljava/lang/String;", "getDetails", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: K6.c, reason: case insensitive filesystem and from toString */
/* loaded from: classes3.dex */
public final /* data */ class AgentTaskStateInfo {
    private final String details;
    private final AgentTaskState state;

    /* JADX WARN: Multi-variable type inference failed */
    public AgentTaskStateInfo() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AgentTaskStateInfo)) {
            return false;
        }
        AgentTaskStateInfo agentTaskStateInfo = (AgentTaskStateInfo) other;
        return this.state == agentTaskStateInfo.state && p.d(this.details, agentTaskStateInfo.details);
    }

    public int hashCode() {
        AgentTaskState agentTaskState = this.state;
        int iHashCode = (agentTaskState == null ? 0 : agentTaskState.hashCode()) * 31;
        String str = this.details;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "AgentTaskStateInfo(state=" + this.state + ", details=" + this.details + ")";
    }

    public AgentTaskStateInfo(AgentTaskState agentTaskState, String str) {
        this.state = agentTaskState;
        this.details = str;
    }

    public /* synthetic */ AgentTaskStateInfo(AgentTaskState agentTaskState, String str, int i10, i iVar) {
        this((i10 & 1) != 0 ? AgentTaskState.STATE_UNSPECIFIED : agentTaskState, (i10 & 2) != 0 ? null : str);
    }
}
