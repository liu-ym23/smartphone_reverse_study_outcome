package com.stepos.ailauncher.agent.aispace.skill.feishu.net;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\b\u0018\u00002\u00020\u0001J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0007R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/feishu/net/o;", "", "", Const.INTENT_KEY_UMID, "()Z", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "code", "Ljava/lang/Integer;", Const.INTENT_KEY_APIKEY, "()Ljava/lang/Integer;", "msg", "Ljava/lang/String;", "c", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/net/m;", "data", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/net/m;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/ailauncher/agent/aispace/skill/feishu/net/m;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.skill.feishu.net.o, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class GetCliResponse {

    @SerializedName("code")
    private final Integer code;

    @SerializedName("data")
    private final GetCliData data;

    @SerializedName("msg")
    private final String msg;

    /* renamed from: a, reason: from getter */
    public final Integer getCode() {
        return this.code;
    }

    /* renamed from: b, reason: from getter */
    public final GetCliData getData() {
        return this.data;
    }

    /* renamed from: c, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    public final boolean d() {
        Integer num = this.code;
        return num != null && num.intValue() == 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GetCliResponse)) {
            return false;
        }
        GetCliResponse getCliResponse = (GetCliResponse) other;
        return kotlin.jvm.internal.p.d(this.code, getCliResponse.code) && kotlin.jvm.internal.p.d(this.msg, getCliResponse.msg) && kotlin.jvm.internal.p.d(this.data, getCliResponse.data);
    }

    public int hashCode() {
        Integer num = this.code;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.msg;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        GetCliData getCliData = this.data;
        return iHashCode2 + (getCliData != null ? getCliData.hashCode() : 0);
    }

    public String toString() {
        return "GetCliResponse(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ")";
    }
}
