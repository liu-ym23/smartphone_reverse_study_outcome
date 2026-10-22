package a4;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentbus.generated.TaskStatus;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import com.stepos.ailauncher.taskstore.provider.c;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\b5\b\u0086\b\u0018\u00002\u00020\u0001B§\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000e\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001c\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001c\u0012\b\b\u0002\u0010!\u001a\u00020 \u0012\u0018\b\u0002\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\"¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b(\u0010)J\u001a\u0010+\u001a\u00020 2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b+\u0010,R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u0010'R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b0\u0010.\u001a\u0004\b1\u0010'R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b2\u0010.\u001a\u0004\b3\u0010'R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b4\u0010.\u001a\u0004\b5\u0010'R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b6\u0010.\u001a\u0004\b7\u0010'R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b8\u0010.\u001a\u0004\b9\u0010'R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b:\u0010.\u001a\u0004\b;\u0010'R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b1\u0010<\u001a\u0004\b=\u0010>R\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006¢\u0006\f\n\u0004\bA\u0010C\u001a\u0004\b0\u0010DR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b5\u0010.\u001a\u0004\bE\u0010'R\u001f\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b3\u0010C\u001a\u0004\b?\u0010DR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\bF\u0010.\u001a\u0004\b8\u0010'R\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8\u0006¢\u0006\f\n\u0004\b=\u0010C\u001a\u0004\bG\u0010DR\u001f\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\bG\u0010C\u001a\u0004\bH\u0010DR\u0017\u0010\u0018\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\bH\u0010I\u001a\u0004\b2\u0010JR\u0017\u0010\u0019\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b9\u0010I\u001a\u0004\bK\u0010JR\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0006¢\u0006\f\n\u0004\bE\u0010L\u001a\u0004\bF\u0010MR\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00178\u0006¢\u0006\f\n\u0004\b/\u0010L\u001a\u0004\b4\u0010MR\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006¢\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010QR\u0017\u0010\u001e\u001a\u00020\u001c8\u0006¢\u0006\f\n\u0004\b7\u0010R\u001a\u0004\bN\u0010)R\u0017\u0010\u001f\u001a\u00020\u001c8\u0006¢\u0006\f\n\u0004\b;\u0010R\u001a\u0004\b-\u0010)R\u0017\u0010!\u001a\u00020 8\u0006¢\u0006\f\n\u0004\bK\u0010S\u001a\u0004\b:\u0010TR'\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\"8\u0006¢\u0006\f\n\u0004\bP\u0010U\u001a\u0004\b6\u0010V¨\u0006W"}, d2 = {"La4/A;", "", "", "taskId", "parentTaskId", SystemDeleteBroadcastReceiver.EXTRA_SESSION_KEY, "requestSessionKey", "title", "subTitle", "type", "Lcom/stepos/agentbus/generated/TaskStatus;", "status", "La4/D;", "progress", "", "La4/B;", "artifacts", c.a.COL_SUMMARY, "La4/y;", "pendingQuestions", "intention", "subTaskIds", "subTasks", "", "createdAt", "updatedAt", "startedAt", "endedAt", "", "version", "taskVersion", "activeTaskVersion", "", "noTaskDetail", "", "extensions", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentbus/generated/TaskStatus;La4/D;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;JJLjava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;IIZLjava/util/Map;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "s", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "c", "l", Const.INTENT_KEY_UMID, "k", "e", "u", "f", "q", Const.INTENT_KEY_BACKGROUND_COMMAND, "v", "Lcom/stepos/agentbus/generated/TaskStatus;", "n", "()Lcom/stepos/agentbus/generated/TaskStatus;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "La4/D;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()La4/D;", "Ljava/util/List;", "()Ljava/util/List;", "r", "m", "o", "p", "J", "()J", "w", "Ljava/lang/Long;", "()Ljava/lang/Long;", "t", "Ljava/lang/Integer;", "x", "()Ljava/lang/Integer;", "I", "Z", "()Z", "Ljava/util/Map;", "()Ljava/util/Map;", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: a4.A, reason: case insensitive filesystem and from toString */
/* loaded from: classes2.dex */
public final /* data */ class Task {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String taskId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String parentTaskId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final String sessionKey;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final String requestSessionKey;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final String title;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    public final String subTitle;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    public final String type;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    public final TaskStatus status;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    public final TaskProgress progress;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    public final List<TaskArtifact> artifacts;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    public final String summary;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    public final List<Question> pendingQuestions;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    public final String intention;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata and from toString */
    public final List<String> subTaskIds;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata and from toString */
    public final List<Task> subTasks;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata and from toString */
    public final long createdAt;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata and from toString */
    public final long updatedAt;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata and from toString */
    public final Long startedAt;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata and from toString */
    public final Long endedAt;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata and from toString */
    public final Integer version;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata and from toString */
    public final int taskVersion;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata and from toString */
    public final int activeTaskVersion;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean noTaskDetail;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata and from toString */
    public final Map<String, Object> extensions;

    public Task(String taskId, String str, String str2, String str3, String title, String subTitle, String type, TaskStatus status, TaskProgress taskProgress, List<TaskArtifact> artifacts, String str4, List<Question> list, String str5, List<String> subTaskIds, List<Task> list2, long j10, long j11, Long l10, Long l11, Integer num, int i10, int i11, boolean z10, Map<String, ? extends Object> map) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        kotlin.jvm.internal.p.i(title, "title");
        kotlin.jvm.internal.p.i(subTitle, "subTitle");
        kotlin.jvm.internal.p.i(type, "type");
        kotlin.jvm.internal.p.i(status, "status");
        kotlin.jvm.internal.p.i(artifacts, "artifacts");
        kotlin.jvm.internal.p.i(subTaskIds, "subTaskIds");
        this.taskId = taskId;
        this.parentTaskId = str;
        this.sessionKey = str2;
        this.requestSessionKey = str3;
        this.title = title;
        this.subTitle = subTitle;
        this.type = type;
        this.status = status;
        this.progress = taskProgress;
        this.artifacts = artifacts;
        this.summary = str4;
        this.pendingQuestions = list;
        this.intention = str5;
        this.subTaskIds = subTaskIds;
        this.subTasks = list2;
        this.createdAt = j10;
        this.updatedAt = j11;
        this.startedAt = l10;
        this.endedAt = l11;
        this.version = num;
        this.taskVersion = i10;
        this.activeTaskVersion = i11;
        this.noTaskDetail = z10;
        this.extensions = map;
    }

    /* renamed from: a, reason: from getter */
    public final int getActiveTaskVersion() {
        return this.activeTaskVersion;
    }

    public final List<TaskArtifact> b() {
        return this.artifacts;
    }

    /* renamed from: c, reason: from getter */
    public final long getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: d, reason: from getter */
    public final Long getEndedAt() {
        return this.endedAt;
    }

    public final Map<String, Object> e() {
        return this.extensions;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Task)) {
            return false;
        }
        Task task = (Task) other;
        return kotlin.jvm.internal.p.d(this.taskId, task.taskId) && kotlin.jvm.internal.p.d(this.parentTaskId, task.parentTaskId) && kotlin.jvm.internal.p.d(this.sessionKey, task.sessionKey) && kotlin.jvm.internal.p.d(this.requestSessionKey, task.requestSessionKey) && kotlin.jvm.internal.p.d(this.title, task.title) && kotlin.jvm.internal.p.d(this.subTitle, task.subTitle) && kotlin.jvm.internal.p.d(this.type, task.type) && this.status == task.status && kotlin.jvm.internal.p.d(this.progress, task.progress) && kotlin.jvm.internal.p.d(this.artifacts, task.artifacts) && kotlin.jvm.internal.p.d(this.summary, task.summary) && kotlin.jvm.internal.p.d(this.pendingQuestions, task.pendingQuestions) && kotlin.jvm.internal.p.d(this.intention, task.intention) && kotlin.jvm.internal.p.d(this.subTaskIds, task.subTaskIds) && kotlin.jvm.internal.p.d(this.subTasks, task.subTasks) && this.createdAt == task.createdAt && this.updatedAt == task.updatedAt && kotlin.jvm.internal.p.d(this.startedAt, task.startedAt) && kotlin.jvm.internal.p.d(this.endedAt, task.endedAt) && kotlin.jvm.internal.p.d(this.version, task.version) && this.taskVersion == task.taskVersion && this.activeTaskVersion == task.activeTaskVersion && this.noTaskDetail == task.noTaskDetail && kotlin.jvm.internal.p.d(this.extensions, task.extensions);
    }

    /* renamed from: f, reason: from getter */
    public final String getIntention() {
        return this.intention;
    }

    /* renamed from: g, reason: from getter */
    public final boolean getNoTaskDetail() {
        return this.noTaskDetail;
    }

    /* renamed from: h, reason: from getter */
    public final String getParentTaskId() {
        return this.parentTaskId;
    }

    public int hashCode() {
        int iHashCode = this.taskId.hashCode() * 31;
        String str = this.parentTaskId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.sessionKey;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.requestSessionKey;
        int iHashCode4 = (((((((((iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.title.hashCode()) * 31) + this.subTitle.hashCode()) * 31) + this.type.hashCode()) * 31) + this.status.hashCode()) * 31;
        TaskProgress taskProgress = this.progress;
        int iHashCode5 = (((iHashCode4 + (taskProgress == null ? 0 : taskProgress.hashCode())) * 31) + this.artifacts.hashCode()) * 31;
        String str4 = this.summary;
        int iHashCode6 = (iHashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        List<Question> list = this.pendingQuestions;
        int iHashCode7 = (iHashCode6 + (list == null ? 0 : list.hashCode())) * 31;
        String str5 = this.intention;
        int iHashCode8 = (((iHashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.subTaskIds.hashCode()) * 31;
        List<Task> list2 = this.subTasks;
        int iHashCode9 = (((((iHashCode8 + (list2 == null ? 0 : list2.hashCode())) * 31) + Long.hashCode(this.createdAt)) * 31) + Long.hashCode(this.updatedAt)) * 31;
        Long l10 = this.startedAt;
        int iHashCode10 = (iHashCode9 + (l10 == null ? 0 : l10.hashCode())) * 31;
        Long l11 = this.endedAt;
        int iHashCode11 = (iHashCode10 + (l11 == null ? 0 : l11.hashCode())) * 31;
        Integer num = this.version;
        int iHashCode12 = (((((((iHashCode11 + (num == null ? 0 : num.hashCode())) * 31) + Integer.hashCode(this.taskVersion)) * 31) + Integer.hashCode(this.activeTaskVersion)) * 31) + Boolean.hashCode(this.noTaskDetail)) * 31;
        Map<String, Object> map = this.extensions;
        return iHashCode12 + (map != null ? map.hashCode() : 0);
    }

    public final List<Question> i() {
        return this.pendingQuestions;
    }

    /* renamed from: j, reason: from getter */
    public final TaskProgress getProgress() {
        return this.progress;
    }

    /* renamed from: k, reason: from getter */
    public final String getRequestSessionKey() {
        return this.requestSessionKey;
    }

    /* renamed from: l, reason: from getter */
    public final String getSessionKey() {
        return this.sessionKey;
    }

    /* renamed from: m, reason: from getter */
    public final Long getStartedAt() {
        return this.startedAt;
    }

    /* renamed from: n, reason: from getter */
    public final TaskStatus getStatus() {
        return this.status;
    }

    public final List<String> o() {
        return this.subTaskIds;
    }

    public final List<Task> p() {
        return this.subTasks;
    }

    /* renamed from: q, reason: from getter */
    public final String getSubTitle() {
        return this.subTitle;
    }

    /* renamed from: r, reason: from getter */
    public final String getSummary() {
        return this.summary;
    }

    /* renamed from: s, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    /* renamed from: t, reason: from getter */
    public final int getTaskVersion() {
        return this.taskVersion;
    }

    public String toString() {
        return "Task(taskId=" + this.taskId + ", parentTaskId=" + this.parentTaskId + ", sessionKey=" + this.sessionKey + ", requestSessionKey=" + this.requestSessionKey + ", title=" + this.title + ", subTitle=" + this.subTitle + ", type=" + this.type + ", status=" + this.status + ", progress=" + this.progress + ", artifacts=" + this.artifacts + ", summary=" + this.summary + ", pendingQuestions=" + this.pendingQuestions + ", intention=" + this.intention + ", subTaskIds=" + this.subTaskIds + ", subTasks=" + this.subTasks + ", createdAt=" + this.createdAt + ", updatedAt=" + this.updatedAt + ", startedAt=" + this.startedAt + ", endedAt=" + this.endedAt + ", version=" + this.version + ", taskVersion=" + this.taskVersion + ", activeTaskVersion=" + this.activeTaskVersion + ", noTaskDetail=" + this.noTaskDetail + ", extensions=" + this.extensions + ")";
    }

    /* renamed from: u, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: v, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* renamed from: w, reason: from getter */
    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    /* renamed from: x, reason: from getter */
    public final Integer getVersion() {
        return this.version;
    }
}
