package com.stepos.agentframework.chatcore.search;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/agentframework/chatcore/search/p;", "", "", "Lcom/stepos/agentframework/chatcore/search/n;", "tasks", "<init>", "(Ljava/util/List;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", Const.INTENT_KEY_APIKEY, "()Ljava/util/List;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatcore.search.p, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class TaskSearchSnapshot {
    private final List<TaskSearchHit> tasks;

    /* JADX WARN: Multi-variable type inference failed */
    public TaskSearchSnapshot() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final List<TaskSearchHit> a() {
        return this.tasks;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof TaskSearchSnapshot) && kotlin.jvm.internal.p.d(this.tasks, ((TaskSearchSnapshot) other).tasks);
    }

    public int hashCode() {
        return this.tasks.hashCode();
    }

    public String toString() {
        return "TaskSearchSnapshot(tasks=" + this.tasks + ")";
    }

    public TaskSearchSnapshot(List<TaskSearchHit> tasks) {
        kotlin.jvm.internal.p.i(tasks, "tasks");
        this.tasks = tasks;
    }

    public /* synthetic */ TaskSearchSnapshot(List list, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? C1173v.m() : list);
    }
}
