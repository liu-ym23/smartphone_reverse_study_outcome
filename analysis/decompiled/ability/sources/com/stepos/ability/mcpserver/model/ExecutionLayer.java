package com.stepos.ability.mcpserver.model;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/stepos/ability/mcpserver/model/ExecutionLayer;", "", "level", "", "tasks", "", "Lcom/stepos/ability/mcpserver/model/ExecutionTask;", AppAgent.CONSTRUCT, "(ILjava/util/List;)V", "getLevel", "()I", "getTasks", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "server_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ExecutionLayer {
    private final int level;
    private final List<ExecutionTask> tasks;

    public ExecutionLayer(int i, List<ExecutionTask> tasks) {
        k.f(tasks, "tasks");
        this.level = i;
        this.tasks = tasks;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ExecutionLayer copy$default(ExecutionLayer executionLayer, int i, List list, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = executionLayer.level;
        }
        if ((i6 & 2) != 0) {
            list = executionLayer.tasks;
        }
        return executionLayer.copy(i, list);
    }

    /* renamed from: component1, reason: from getter */
    public final int getLevel() {
        return this.level;
    }

    public final List<ExecutionTask> component2() {
        return this.tasks;
    }

    public final ExecutionLayer copy(int level, List<ExecutionTask> tasks) {
        k.f(tasks, "tasks");
        return new ExecutionLayer(level, tasks);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExecutionLayer)) {
            return false;
        }
        ExecutionLayer executionLayer = (ExecutionLayer) other;
        return this.level == executionLayer.level && k.b(this.tasks, executionLayer.tasks);
    }

    public final int getLevel() {
        return this.level;
    }

    public final List<ExecutionTask> getTasks() {
        return this.tasks;
    }

    public int hashCode() {
        return this.tasks.hashCode() + (Integer.hashCode(this.level) * 31);
    }

    public String toString() {
        return "ExecutionLayer(level=" + this.level + ", tasks=" + this.tasks + ")";
    }
}
