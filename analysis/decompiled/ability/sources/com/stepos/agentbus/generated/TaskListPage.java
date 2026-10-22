package com.stepos.agentbus.generated;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\bHÆ\u0003J/\u0010\u0014\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0019\u001a\u00020\bHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/stepos/agentbus/generated/TaskListPage;", "", "tasks", "", "Lcom/stepos/agentbus/generated/Task;", "total", "", "nextCursor", "", AppAgent.CONSTRUCT, "(Ljava/util/List;ILjava/lang/String;)V", "getTasks", "()Ljava/util/List;", "getTotal", "()I", "getNextCursor", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class TaskListPage {
    private final String nextCursor;
    private final List<Task> tasks;
    private final int total;

    public TaskListPage(List<Task> tasks, int i, String str) {
        k.f(tasks, "tasks");
        this.tasks = tasks;
        this.total = i;
        this.nextCursor = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TaskListPage copy$default(TaskListPage taskListPage, List list, int i, String str, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            list = taskListPage.tasks;
        }
        if ((i6 & 2) != 0) {
            i = taskListPage.total;
        }
        if ((i6 & 4) != 0) {
            str = taskListPage.nextCursor;
        }
        return taskListPage.copy(list, i, str);
    }

    public final List<Task> component1() {
        return this.tasks;
    }

    /* renamed from: component2, reason: from getter */
    public final int getTotal() {
        return this.total;
    }

    /* renamed from: component3, reason: from getter */
    public final String getNextCursor() {
        return this.nextCursor;
    }

    public final TaskListPage copy(List<Task> tasks, int total, String nextCursor) {
        k.f(tasks, "tasks");
        return new TaskListPage(tasks, total, nextCursor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskListPage)) {
            return false;
        }
        TaskListPage taskListPage = (TaskListPage) other;
        return k.b(this.tasks, taskListPage.tasks) && this.total == taskListPage.total && k.b(this.nextCursor, taskListPage.nextCursor);
    }

    public final String getNextCursor() {
        return this.nextCursor;
    }

    public final List<Task> getTasks() {
        return this.tasks;
    }

    public final int getTotal() {
        return this.total;
    }

    public int hashCode() {
        int iA = androidx.constraintlayout.core.dsl.a.a(this.total, this.tasks.hashCode() * 31, 31);
        String str = this.nextCursor;
        return iA + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        List<Task> list = this.tasks;
        int i = this.total;
        String str = this.nextCursor;
        StringBuilder sb = new StringBuilder("TaskListPage(tasks=");
        sb.append(list);
        sb.append(", total=");
        sb.append(i);
        sb.append(", nextCursor=");
        return B7.a.q(sb, str, ")");
    }
}
