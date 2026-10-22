package com.stepos.ailauncher.agent.aispace.skill.feishu.net;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0080\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0011\u001a\u0004\b\u0014\u0010\u0004R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/feishu/net/b;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "code", "Ljava/lang/Integer;", Const.INTENT_KEY_APIKEY, "()Ljava/lang/Integer;", "error", "Ljava/lang/String;", "c", "detailCode", Const.INTENT_KEY_PKGNAME, "msg", Const.INTENT_KEY_UMID, "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.skill.feishu.net.b, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class FeishuApiErrorBody {

    @SerializedName("code")
    private final Integer code;

    @SerializedName("detailCode")
    private final String detailCode;

    @SerializedName("error")
    private final String error;

    @SerializedName("msg")
    private final String msg;

    /* renamed from: a, reason: from getter */
    public final Integer getCode() {
        return this.code;
    }

    /* renamed from: b, reason: from getter */
    public final String getDetailCode() {
        return this.detailCode;
    }

    /* renamed from: c, reason: from getter */
    public final String getError() {
        return this.error;
    }

    /* renamed from: d, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeishuApiErrorBody)) {
            return false;
        }
        FeishuApiErrorBody feishuApiErrorBody = (FeishuApiErrorBody) other;
        return kotlin.jvm.internal.p.d(this.code, feishuApiErrorBody.code) && kotlin.jvm.internal.p.d(this.error, feishuApiErrorBody.error) && kotlin.jvm.internal.p.d(this.detailCode, feishuApiErrorBody.detailCode) && kotlin.jvm.internal.p.d(this.msg, feishuApiErrorBody.msg);
    }

    public int hashCode() {
        Integer num = this.code;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.error;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.detailCode;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.msg;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "FeishuApiErrorBody(code=" + this.code + ", error=" + this.error + ", detailCode=" + this.detailCode + ", msg=" + this.msg + ")";
    }
}
