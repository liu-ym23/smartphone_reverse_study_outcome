package com.stepos.taskrobot.taskmanager.experiencelib.model;

import B7.a;
import androidx.annotation.Keep;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Keep
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006HÆ\u0003J5\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR$\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/stepos/taskrobot/taskmanager/experiencelib/model/Step2RetrieveRequest;", "", "task", "", "action1", "action1Params", "", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getTask", "()Ljava/lang/String;", "getAction1", "getAction1Params", "()Ljava/util/Map;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "experiencelib_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class Step2RetrieveRequest {

    @SerializedName("action1")
    private final String action1;

    @SerializedName("action1_params")
    private final Map<String, Object> action1Params;

    @SerializedName("task")
    private final String task;

    public Step2RetrieveRequest(String task, String action1, Map<String, ? extends Object> action1Params) {
        k.f(task, "task");
        k.f(action1, "action1");
        k.f(action1Params, "action1Params");
        this.task = task;
        this.action1 = action1;
        this.action1Params = action1Params;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Step2RetrieveRequest copy$default(Step2RetrieveRequest step2RetrieveRequest, String str, String str2, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            str = step2RetrieveRequest.task;
        }
        if ((i & 2) != 0) {
            str2 = step2RetrieveRequest.action1;
        }
        if ((i & 4) != 0) {
            map = step2RetrieveRequest.action1Params;
        }
        return step2RetrieveRequest.copy(str, str2, map);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTask() {
        return this.task;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAction1() {
        return this.action1;
    }

    public final Map<String, Object> component3() {
        return this.action1Params;
    }

    public final Step2RetrieveRequest copy(String task, String action1, Map<String, ? extends Object> action1Params) {
        k.f(task, "task");
        k.f(action1, "action1");
        k.f(action1Params, "action1Params");
        return new Step2RetrieveRequest(task, action1, action1Params);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Step2RetrieveRequest)) {
            return false;
        }
        Step2RetrieveRequest step2RetrieveRequest = (Step2RetrieveRequest) other;
        return k.b(this.task, step2RetrieveRequest.task) && k.b(this.action1, step2RetrieveRequest.action1) && k.b(this.action1Params, step2RetrieveRequest.action1Params);
    }

    public final String getAction1() {
        return this.action1;
    }

    public final Map<String, Object> getAction1Params() {
        return this.action1Params;
    }

    public final String getTask() {
        return this.task;
    }

    public int hashCode() {
        return this.action1Params.hashCode() + a.c(this.task.hashCode() * 31, 31, this.action1);
    }

    public String toString() {
        String str = this.task;
        String str2 = this.action1;
        Map<String, Object> map = this.action1Params;
        StringBuilder sbW = a.w("Step2RetrieveRequest(task=", str, ", action1=", str2, ", action1Params=");
        sbW.append(map);
        sbW.append(")");
        return sbW.toString();
    }

    public /* synthetic */ Step2RetrieveRequest(String str, String str2, Map map, int i, e eVar) {
        this(str, str2, (i & 4) != 0 ? kotlin.collections.a.M() : map);
    }
}
