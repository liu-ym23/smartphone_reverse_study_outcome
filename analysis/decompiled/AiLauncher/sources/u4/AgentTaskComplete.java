package u4;

import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\nR\u001f\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0017\u0010\n¨\u0006\u0018"}, d2 = {"Lu4/f;", "", "", "cover", "", "suggestions", "plan_id", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getCover", "Ljava/util/List;", "getSuggestions", "()Ljava/util/List;", Const.INTENT_KEY_APIKEY, "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: u4.f, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class AgentTaskComplete {
    private final String cover;
    private final String plan_id;
    private final List<String> suggestions;

    public AgentTaskComplete() {
        this(null, null, null, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getPlan_id() {
        return this.plan_id;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AgentTaskComplete)) {
            return false;
        }
        AgentTaskComplete agentTaskComplete = (AgentTaskComplete) other;
        return p.d(this.cover, agentTaskComplete.cover) && p.d(this.suggestions, agentTaskComplete.suggestions) && p.d(this.plan_id, agentTaskComplete.plan_id);
    }

    public int hashCode() {
        String str = this.cover;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<String> list = this.suggestions;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        String str2 = this.plan_id;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "AgentTaskComplete(cover=" + this.cover + ", suggestions=" + this.suggestions + ", plan_id=" + this.plan_id + ")";
    }

    public AgentTaskComplete(String str, List<String> list, String str2) {
        this.cover = str;
        this.suggestions = list;
        this.plan_id = str2;
    }

    public /* synthetic */ AgentTaskComplete(String str, List list, String str2, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : list, (i10 & 4) != 0 ? null : str2);
    }
}
