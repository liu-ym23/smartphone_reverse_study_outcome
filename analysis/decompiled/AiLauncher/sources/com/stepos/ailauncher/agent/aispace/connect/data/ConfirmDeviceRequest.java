package com.stepos.ailauncher.agent.aispace.connect.data;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0080\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ8\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\fR\u001a\u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0016\u0010\fR\u001a\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0017\u0010\fR\u001a\u0010\u0006\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0018\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/connect/data/o;", "", "", "pairId", "deviceId", "agent", "loginToken", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/ailauncher/agent/aispace/connect/data/o;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getPairId", "getDeviceId", "getAgent", "getLoginToken", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.connect.data.o, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class ConfirmDeviceRequest {

    @SerializedName("agent")
    private final String agent;

    @SerializedName(Parameters.DEVICE_ID)
    private final String deviceId;

    @SerializedName("login_token")
    private final String loginToken;

    @SerializedName("pair_id")
    private final String pairId;

    public ConfirmDeviceRequest(String pairId, String deviceId, String agent, String loginToken) {
        kotlin.jvm.internal.p.i(pairId, "pairId");
        kotlin.jvm.internal.p.i(deviceId, "deviceId");
        kotlin.jvm.internal.p.i(agent, "agent");
        kotlin.jvm.internal.p.i(loginToken, "loginToken");
        this.pairId = pairId;
        this.deviceId = deviceId;
        this.agent = agent;
        this.loginToken = loginToken;
    }

    public static /* synthetic */ ConfirmDeviceRequest b(ConfirmDeviceRequest confirmDeviceRequest, String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = confirmDeviceRequest.pairId;
        }
        if ((i10 & 2) != 0) {
            str2 = confirmDeviceRequest.deviceId;
        }
        if ((i10 & 4) != 0) {
            str3 = confirmDeviceRequest.agent;
        }
        if ((i10 & 8) != 0) {
            str4 = confirmDeviceRequest.loginToken;
        }
        return confirmDeviceRequest.a(str, str2, str3, str4);
    }

    public final ConfirmDeviceRequest a(String pairId, String deviceId, String agent, String loginToken) {
        kotlin.jvm.internal.p.i(pairId, "pairId");
        kotlin.jvm.internal.p.i(deviceId, "deviceId");
        kotlin.jvm.internal.p.i(agent, "agent");
        kotlin.jvm.internal.p.i(loginToken, "loginToken");
        return new ConfirmDeviceRequest(pairId, deviceId, agent, loginToken);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConfirmDeviceRequest)) {
            return false;
        }
        ConfirmDeviceRequest confirmDeviceRequest = (ConfirmDeviceRequest) other;
        return kotlin.jvm.internal.p.d(this.pairId, confirmDeviceRequest.pairId) && kotlin.jvm.internal.p.d(this.deviceId, confirmDeviceRequest.deviceId) && kotlin.jvm.internal.p.d(this.agent, confirmDeviceRequest.agent) && kotlin.jvm.internal.p.d(this.loginToken, confirmDeviceRequest.loginToken);
    }

    public int hashCode() {
        return (((((this.pairId.hashCode() * 31) + this.deviceId.hashCode()) * 31) + this.agent.hashCode()) * 31) + this.loginToken.hashCode();
    }

    public String toString() {
        return "ConfirmDeviceRequest(pairId=" + this.pairId + ", deviceId=" + this.deviceId + ", agent=" + this.agent + ", loginToken=" + this.loginToken + ")";
    }
}
