package com.stepos.ability.mcpserver.model;

import androidx.appfunctions.metadata.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.commoninternal.AgentCache;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0003JG\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001f\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/stepos/ability/mcpserver/model/BatchTask;", "", "id", "", AgentCache.AGENT_CACHE_TASK_TYPE_TOOL, "params", "", "dependsOn", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/List;)V", "getId", "()Ljava/lang/String;", "getTool", "getParams", "()Ljava/util/Map;", "getDependsOn", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "server_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class BatchTask {
    private final List<String> dependsOn;
    private final String id;
    private final Map<String, Object> params;
    private final String tool;

    public BatchTask(String id, String tool, Map<String, ? extends Object> params, List<String> list) {
        k.f(id, "id");
        k.f(tool, "tool");
        k.f(params, "params");
        this.id = id;
        this.tool = tool;
        this.params = params;
        this.dependsOn = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BatchTask copy$default(BatchTask batchTask, String str, String str2, Map map, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = batchTask.id;
        }
        if ((i & 2) != 0) {
            str2 = batchTask.tool;
        }
        if ((i & 4) != 0) {
            map = batchTask.params;
        }
        if ((i & 8) != 0) {
            list = batchTask.dependsOn;
        }
        return batchTask.copy(str, str2, map, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTool() {
        return this.tool;
    }

    public final Map<String, Object> component3() {
        return this.params;
    }

    public final List<String> component4() {
        return this.dependsOn;
    }

    public final BatchTask copy(String id, String tool, Map<String, ? extends Object> params, List<String> dependsOn) {
        k.f(id, "id");
        k.f(tool, "tool");
        k.f(params, "params");
        return new BatchTask(id, tool, params, dependsOn);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BatchTask)) {
            return false;
        }
        BatchTask batchTask = (BatchTask) other;
        return k.b(this.id, batchTask.id) && k.b(this.tool, batchTask.tool) && k.b(this.params, batchTask.params) && k.b(this.dependsOn, batchTask.dependsOn);
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

    public final String getTool() {
        return this.tool;
    }

    public int hashCode() {
        int iF = a.f(this.params, B7.a.c(this.id.hashCode() * 31, 31, this.tool), 31);
        List<String> list = this.dependsOn;
        return iF + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        String str = this.id;
        String str2 = this.tool;
        Map<String, Object> map = this.params;
        List<String> list = this.dependsOn;
        StringBuilder sbW = B7.a.w("BatchTask(id=", str, ", tool=", str2, ", params=");
        sbW.append(map);
        sbW.append(", dependsOn=");
        sbW.append(list);
        sbW.append(")");
        return sbW.toString();
    }

    public /* synthetic */ BatchTask(String str, String str2, Map map, List list, int i, e eVar) {
        this(str, str2, map, (i & 8) != 0 ? null : list);
    }
}
