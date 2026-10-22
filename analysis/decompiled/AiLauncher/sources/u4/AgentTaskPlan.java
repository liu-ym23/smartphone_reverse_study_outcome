package u4;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u001bR\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0018\u001a\u0004\b\u001c\u0010\u0010\"\u0004\b\u001d\u0010\u001bR*\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0018\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u001bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0018\u001a\u0004\b%\u0010\u0010\"\u0004\b&\u0010\u001bR\"\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0018\u001a\u0004\b'\u0010\u0010\"\u0004\b(\u0010\u001bR$\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b)\u0010\u0010\"\u0004\b*\u0010\u001bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0018\u001a\u0004\b+\u0010\u0010\"\u0004\b,\u0010\u001b¨\u0006-"}, d2 = {"Lu4/i;", "", "", "title", "description", "", "Lu4/e;", "tasks", "cover", "tempSessionId", "sessionId", "taskType", "planId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTitle", "setTitle", "(Ljava/lang/String;)V", "getDescription", "setDescription", "Ljava/util/List;", Const.INTENT_KEY_APIKEY, "()Ljava/util/List;", "setTasks", "(Ljava/util/List;)V", "getCover", "setCover", "getTempSessionId", "c", "getSessionId", Const.INTENT_KEY_PKGNAME, "getTaskType", "setTaskType", "getPlanId", "setPlanId", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: u4.i, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class AgentTaskPlan {
    private String cover;
    private String description;

    @SerializedName("plan_id")
    private String planId;
    private String sessionId;

    @SerializedName("task_type")
    private String taskType;
    private List<AgentTask> tasks;
    private String tempSessionId;
    private String title;

    public AgentTaskPlan() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public final List<AgentTask> a() {
        return this.tasks;
    }

    public final void b(String str) {
        p.i(str, "<set-?>");
        this.sessionId = str;
    }

    public final void c(String str) {
        p.i(str, "<set-?>");
        this.tempSessionId = str;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AgentTaskPlan)) {
            return false;
        }
        AgentTaskPlan agentTaskPlan = (AgentTaskPlan) other;
        return p.d(this.title, agentTaskPlan.title) && p.d(this.description, agentTaskPlan.description) && p.d(this.tasks, agentTaskPlan.tasks) && p.d(this.cover, agentTaskPlan.cover) && p.d(this.tempSessionId, agentTaskPlan.tempSessionId) && p.d(this.sessionId, agentTaskPlan.sessionId) && p.d(this.taskType, agentTaskPlan.taskType) && p.d(this.planId, agentTaskPlan.planId);
    }

    public int hashCode() {
        int iHashCode = ((this.title.hashCode() * 31) + this.description.hashCode()) * 31;
        List<AgentTask> list = this.tasks;
        int iHashCode2 = (iHashCode + (list == null ? 0 : list.hashCode())) * 31;
        String str = this.cover;
        int iHashCode3 = (((((iHashCode2 + (str == null ? 0 : str.hashCode())) * 31) + this.tempSessionId.hashCode()) * 31) + this.sessionId.hashCode()) * 31;
        String str2 = this.taskType;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.planId;
        return iHashCode4 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "AgentTaskPlan(title=" + this.title + ", description=" + this.description + ", tasks=" + this.tasks + ", cover=" + this.cover + ", tempSessionId=" + this.tempSessionId + ", sessionId=" + this.sessionId + ", taskType=" + this.taskType + ", planId=" + this.planId + ")";
    }

    public AgentTaskPlan(String title, String description, List<AgentTask> list, String str, String tempSessionId, String sessionId, String str2, String str3) {
        p.i(title, "title");
        p.i(description, "description");
        p.i(tempSessionId, "tempSessionId");
        p.i(sessionId, "sessionId");
        this.title = title;
        this.description = description;
        this.tasks = list;
        this.cover = str;
        this.tempSessionId = tempSessionId;
        this.sessionId = sessionId;
        this.taskType = str2;
        this.planId = str3;
    }

    public /* synthetic */ AgentTaskPlan(String str, String str2, List list, String str3, String str4, String str5, String str6, String str7, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? "" : str2, (i10 & 4) != 0 ? null : list, (i10 & 8) != 0 ? null : str3, (i10 & 16) != 0 ? "" : str4, (i10 & 32) != 0 ? "" : str5, (i10 & 64) != 0 ? null : str6, (i10 & 128) != 0 ? null : str7);
    }
}
