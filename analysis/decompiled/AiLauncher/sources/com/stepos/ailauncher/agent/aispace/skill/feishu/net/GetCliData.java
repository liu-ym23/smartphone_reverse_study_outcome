package com.stepos.ailauncher.agent.aispace.skill.feishu.net;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/skill/feishu/net/m;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/net/a;", "cli", "Lcom/stepos/ailauncher/agent/aispace/skill/feishu/net/a;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/agent/aispace/skill/feishu/net/a;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.skill.feishu.net.m, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class GetCliData {

    @SerializedName("cli")
    private final CliHubInfoDto cli;

    /* renamed from: a, reason: from getter */
    public final CliHubInfoDto getCli() {
        return this.cli;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof GetCliData) && kotlin.jvm.internal.p.d(this.cli, ((GetCliData) other).cli);
    }

    public int hashCode() {
        CliHubInfoDto cliHubInfoDto = this.cli;
        if (cliHubInfoDto == null) {
            return 0;
        }
        return cliHubInfoDto.hashCode();
    }

    public String toString() {
        return "GetCliData(cli=" + this.cli + ")";
    }
}
