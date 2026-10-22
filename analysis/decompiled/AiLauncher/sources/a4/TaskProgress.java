package a4;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.credential.api.AuthSessionDto;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u000eR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0014\u001a\u0004\b\u0016\u0010\u000eR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0015\u0010\u000eR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0017\u0010\u000eR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0014\u001a\u0004\b\u0018\u0010\u000e¨\u0006\u0019"}, d2 = {"La4/D;", "", "", "completed", "total", "failed", "inProgress", AuthSessionDto.STATUS_PENDING, "<init>", "(IIIII)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "I", Const.INTENT_KEY_PKGNAME, "e", "c", Const.INTENT_KEY_UMID, "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: a4.D, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class TaskProgress {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final int completed;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final int total;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final int failed;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final int inProgress;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final int pending;

    public TaskProgress() {
        this(0, 0, 0, 0, 0, 31, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getCompleted() {
        return this.completed;
    }

    /* renamed from: b, reason: from getter */
    public final int getFailed() {
        return this.failed;
    }

    /* renamed from: c, reason: from getter */
    public final int getInProgress() {
        return this.inProgress;
    }

    /* renamed from: d, reason: from getter */
    public final int getPending() {
        return this.pending;
    }

    /* renamed from: e, reason: from getter */
    public final int getTotal() {
        return this.total;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskProgress)) {
            return false;
        }
        TaskProgress taskProgress = (TaskProgress) other;
        return this.completed == taskProgress.completed && this.total == taskProgress.total && this.failed == taskProgress.failed && this.inProgress == taskProgress.inProgress && this.pending == taskProgress.pending;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.completed) * 31) + Integer.hashCode(this.total)) * 31) + Integer.hashCode(this.failed)) * 31) + Integer.hashCode(this.inProgress)) * 31) + Integer.hashCode(this.pending);
    }

    public String toString() {
        return "TaskProgress(completed=" + this.completed + ", total=" + this.total + ", failed=" + this.failed + ", inProgress=" + this.inProgress + ", pending=" + this.pending + ")";
    }

    public TaskProgress(int i10, int i11, int i12, int i13, int i14) {
        this.completed = i10;
        this.total = i11;
        this.failed = i12;
        this.inProgress = i13;
        this.pending = i14;
    }

    public /* synthetic */ TaskProgress(int i10, int i11, int i12, int i13, int i14, int i15, kotlin.jvm.internal.i iVar) {
        this((i15 & 1) != 0 ? 0 : i10, (i15 & 2) != 0 ? 0 : i11, (i15 & 4) != 0 ? 0 : i12, (i15 & 8) != 0 ? 0 : i13, (i15 & 16) != 0 ? 0 : i14);
    }
}
