package com.stepos.ailauncher.agent.aispace.skill.feishu.net;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u0080\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\r\u001a\u0004\b\u0010\u0010\u0004R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u0004R\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/feishu/net/q;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "openId", "Ljava/lang/String;", "getOpenId", "tenantBrand", "getTenantBrand", "appId", "getAppId", "", "scopes", "Ljava/util/List;", "getScopes", "()Ljava/util/List;", "", "connectedAt", "Ljava/lang/Long;", "getConnectedAt", "()Ljava/lang/Long;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.skill.feishu.net.q, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class NetFeishuAccount {

    @SerializedName("appId")
    private final String appId;

    @SerializedName("connectedAt")
    private final Long connectedAt;

    @SerializedName("openId")
    private final String openId;

    @SerializedName("scopes")
    private final List<String> scopes;

    @SerializedName("tenantBrand")
    private final String tenantBrand;

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NetFeishuAccount)) {
            return false;
        }
        NetFeishuAccount netFeishuAccount = (NetFeishuAccount) other;
        return kotlin.jvm.internal.p.d(this.openId, netFeishuAccount.openId) && kotlin.jvm.internal.p.d(this.tenantBrand, netFeishuAccount.tenantBrand) && kotlin.jvm.internal.p.d(this.appId, netFeishuAccount.appId) && kotlin.jvm.internal.p.d(this.scopes, netFeishuAccount.scopes) && kotlin.jvm.internal.p.d(this.connectedAt, netFeishuAccount.connectedAt);
    }

    public int hashCode() {
        String str = this.openId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.tenantBrand;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.appId;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<String> list = this.scopes;
        int iHashCode4 = (iHashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        Long l10 = this.connectedAt;
        return iHashCode4 + (l10 != null ? l10.hashCode() : 0);
    }

    public String toString() {
        return "NetFeishuAccount(openId=" + this.openId + ", tenantBrand=" + this.tenantBrand + ", appId=" + this.appId + ", scopes=" + this.scopes + ", connectedAt=" + this.connectedAt + ")";
    }
}
