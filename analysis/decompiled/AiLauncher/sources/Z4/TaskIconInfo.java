package Z4;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0016\u0010\u000bR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0017\u0010\u000b¨\u0006\u0018"}, d2 = {"LZ4/e;", "", "", "taskId", "", "iconRes", "title", "description", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "c", "I", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_UMID, Const.INTENT_KEY_APIKEY, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: Z4.e, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class TaskIconInfo {
    private final String description;
    private final int iconRes;
    private final String taskId;
    private final String title;

    public TaskIconInfo(String taskId, int i10, String title, String description) {
        p.i(taskId, "taskId");
        p.i(title, "title");
        p.i(description, "description");
        this.taskId = taskId;
        this.iconRes = i10;
        this.title = title;
        this.description = description;
    }

    /* renamed from: a, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: b, reason: from getter */
    public final int getIconRes() {
        return this.iconRes;
    }

    /* renamed from: c, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    /* renamed from: d, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskIconInfo)) {
            return false;
        }
        TaskIconInfo taskIconInfo = (TaskIconInfo) other;
        return p.d(this.taskId, taskIconInfo.taskId) && this.iconRes == taskIconInfo.iconRes && p.d(this.title, taskIconInfo.title) && p.d(this.description, taskIconInfo.description);
    }

    public int hashCode() {
        return (((((this.taskId.hashCode() * 31) + Integer.hashCode(this.iconRes)) * 31) + this.title.hashCode()) * 31) + this.description.hashCode();
    }

    public String toString() {
        return "TaskIconInfo(taskId=" + this.taskId + ", iconRes=" + this.iconRes + ", title=" + this.title + ", description=" + this.description + ")";
    }
}
