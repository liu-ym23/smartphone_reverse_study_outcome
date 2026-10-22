package com.stepos.ability.mcpserver.model;

import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\bHÆ\u0003J\u0015\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\u000bHÆ\u0003Je\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00062\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u001f\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lcom/stepos/ability/mcpserver/model/ExecutionTask;", "", "id", "", "toolName", "params", "", "dependsOn", "", "refBindings", "timeoutMs", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Ljava/util/Map;J)V", "getId", "()Ljava/lang/String;", "getToolName", "getParams", "()Ljava/util/Map;", "getDependsOn", "()Ljava/util/List;", "getRefBindings", "getTimeoutMs", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "server_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ExecutionTask {
    private final List<String> dependsOn;
    private final String id;
    private final Map<String, Object> params;
    private final Map<String, String> refBindings;
    private final long timeoutMs;
    private final String toolName;

    public ExecutionTask(String id, String toolName, Map<String, ? extends Object> params, List<String> dependsOn, Map<String, String> refBindings, long j5) {
        k.f(id, "id");
        k.f(toolName, "toolName");
        k.f(params, "params");
        k.f(dependsOn, "dependsOn");
        k.f(refBindings, "refBindings");
        this.id = id;
        this.toolName = toolName;
        this.params = params;
        this.dependsOn = dependsOn;
        this.refBindings = refBindings;
        this.timeoutMs = j5;
    }

    public static /* synthetic */ ExecutionTask copy$default(ExecutionTask executionTask, String str, String str2, Map map, List list, Map map2, long j5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = executionTask.id;
        }
        if ((i & 2) != 0) {
            str2 = executionTask.toolName;
        }
        if ((i & 4) != 0) {
            map = executionTask.params;
        }
        if ((i & 8) != 0) {
            list = executionTask.dependsOn;
        }
        if ((i & 16) != 0) {
            map2 = executionTask.refBindings;
        }
        if ((i & 32) != 0) {
            j5 = executionTask.timeoutMs;
        }
        long j6 = j5;
        Map map3 = map2;
        Map map4 = map;
        return executionTask.copy(str, str2, map4, list, map3, j6);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getToolName() {
        return this.toolName;
    }

    public final Map<String, Object> component3() {
        return this.params;
    }

    public final List<String> component4() {
        return this.dependsOn;
    }

    public final Map<String, String> component5() {
        return this.refBindings;
    }

    /* renamed from: component6, reason: from getter */
    public final long getTimeoutMs() {
        return this.timeoutMs;
    }

    public final ExecutionTask copy(String id, String toolName, Map<String, ? extends Object> params, List<String> dependsOn, Map<String, String> refBindings, long timeoutMs) {
        k.f(id, "id");
        k.f(toolName, "toolName");
        k.f(params, "params");
        k.f(dependsOn, "dependsOn");
        k.f(refBindings, "refBindings");
        return new ExecutionTask(id, toolName, params, dependsOn, refBindings, timeoutMs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExecutionTask)) {
            return false;
        }
        ExecutionTask executionTask = (ExecutionTask) other;
        return k.b(this.id, executionTask.id) && k.b(this.toolName, executionTask.toolName) && k.b(this.params, executionTask.params) && k.b(this.dependsOn, executionTask.dependsOn) && k.b(this.refBindings, executionTask.refBindings) && this.timeoutMs == executionTask.timeoutMs;
    }

    public final List<String> getDependsOn() {
        return this.dependsOn;
    }

    public final String getId() {
        return this.id;
    }

    public final Map<String, Object> getParams() {
        return this.params;
    }

    public final Map<String, String> getRefBindings() {
        return this.refBindings;
    }

    public final long getTimeoutMs() {
        return this.timeoutMs;
    }

    public final String getToolName() {
        return this.toolName;
    }

    public int hashCode() {
        return Long.hashCode(this.timeoutMs) + a.f(this.refBindings, a.e(this.dependsOn, a.f(this.params, B7.a.c(this.id.hashCode() * 31, 31, this.toolName), 31), 31), 31);
    }

    public String toString() {
        String str = this.id;
        String str2 = this.toolName;
        Map<String, Object> map = this.params;
        List<String> list = this.dependsOn;
        Map<String, String> map2 = this.refBindings;
        long j5 = this.timeoutMs;
        StringBuilder sbW = B7.a.w("ExecutionTask(id=", str, ", toolName=", str2, ", params=");
        sbW.append(map);
        sbW.append(", dependsOn=");
        sbW.append(list);
        sbW.append(", refBindings=");
        sbW.append(map2);
        sbW.append(", timeoutMs=");
        sbW.append(j5);
        sbW.append(")");
        return sbW.toString();
    }
}
