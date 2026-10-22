package com.stepos.agentframework.adapter.agentspace;

import androidx.appfunctions.metadata.a;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/stepos/agentframework/adapter/agentspace/AgentSpaceConfigQueryResponse;", "", "code", "", NotificationCompat.CATEGORY_MESSAGE, "", SettingsConfig.KEY_DATA, "", "Lcom/stepos/agentframework/adapter/agentspace/AgentSpaceConfigItem;", AppAgent.CONSTRUCT, "(ILjava/lang/String;Ljava/util/List;)V", "getCode", "()I", "getMsg", "()Ljava/lang/String;", "getData", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "adapter_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AgentSpaceConfigQueryResponse {
    private final int code;
    private final List<AgentSpaceConfigItem> data;
    private final String msg;

    public AgentSpaceConfigQueryResponse(int i, String str, List<AgentSpaceConfigItem> list) {
        this.code = i;
        this.msg = str;
        this.data = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AgentSpaceConfigQueryResponse copy$default(AgentSpaceConfigQueryResponse agentSpaceConfigQueryResponse, int i, String str, List list, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = agentSpaceConfigQueryResponse.code;
        }
        if ((i6 & 2) != 0) {
            str = agentSpaceConfigQueryResponse.msg;
        }
        if ((i6 & 4) != 0) {
            list = agentSpaceConfigQueryResponse.data;
        }
        return agentSpaceConfigQueryResponse.copy(i, str, list);
    }

    /* renamed from: component1, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    public final List<AgentSpaceConfigItem> component3() {
        return this.data;
    }

    public final AgentSpaceConfigQueryResponse copy(int code, String msg, List<AgentSpaceConfigItem> data) {
        return new AgentSpaceConfigQueryResponse(code, msg, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AgentSpaceConfigQueryResponse)) {
            return false;
        }
        AgentSpaceConfigQueryResponse agentSpaceConfigQueryResponse = (AgentSpaceConfigQueryResponse) other;
        return this.code == agentSpaceConfigQueryResponse.code && k.b(this.msg, agentSpaceConfigQueryResponse.msg) && k.b(this.data, agentSpaceConfigQueryResponse.data);
    }

    public final int getCode() {
        return this.code;
    }

    public final List<AgentSpaceConfigItem> getData() {
        return this.data;
    }

    public final String getMsg() {
        return this.msg;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.code) * 31;
        String str = this.msg;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<AgentSpaceConfigItem> list = this.data;
        return iHashCode2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        int i = this.code;
        String str = this.msg;
        return a.q(androidx.constraintlayout.core.dsl.a.k(i, "AgentSpaceConfigQueryResponse(code=", ", msg=", str, ", data="), this.data, ")");
    }
}
