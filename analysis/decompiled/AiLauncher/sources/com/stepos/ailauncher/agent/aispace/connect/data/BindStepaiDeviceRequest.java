package com.stepos.ailauncher.agent.aispace.connect.data;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\u0080\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJV\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0018\u001a\u0004\b\u001a\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u001b\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u001c\u0010\u0010R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u001d\u0010\u0010R\u001a\u0010\b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u001e\u0010\u0010R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u001f\u001a\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/connect/data/m;", "", "", "stepaiDeviceId", "stepaiDeviceName", "stepaiUserId", "phoneDeviceId", "phoneDeviceName", "loginToken", "", "ts", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)Lcom/stepos/ailauncher/agent/aispace/connect/data/m;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getStepaiDeviceId", "getStepaiDeviceName", "getStepaiUserId", "getPhoneDeviceId", "getPhoneDeviceName", "getLoginToken", "J", "getTs", "()J", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.connect.data.m, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class BindStepaiDeviceRequest {

    @SerializedName("login_token")
    private final String loginToken;

    @SerializedName("phone_device_id")
    private final String phoneDeviceId;

    @SerializedName("phone_device_name")
    private final String phoneDeviceName;

    @SerializedName("stepai_device_id")
    private final String stepaiDeviceId;

    @SerializedName("stepai_device_name")
    private final String stepaiDeviceName;

    @SerializedName("stepai_user_id")
    private final String stepaiUserId;

    @SerializedName("ts")
    private final long ts;

    public BindStepaiDeviceRequest(String stepaiDeviceId, String stepaiDeviceName, String stepaiUserId, String phoneDeviceId, String phoneDeviceName, String loginToken, long j10) {
        kotlin.jvm.internal.p.i(stepaiDeviceId, "stepaiDeviceId");
        kotlin.jvm.internal.p.i(stepaiDeviceName, "stepaiDeviceName");
        kotlin.jvm.internal.p.i(stepaiUserId, "stepaiUserId");
        kotlin.jvm.internal.p.i(phoneDeviceId, "phoneDeviceId");
        kotlin.jvm.internal.p.i(phoneDeviceName, "phoneDeviceName");
        kotlin.jvm.internal.p.i(loginToken, "loginToken");
        this.stepaiDeviceId = stepaiDeviceId;
        this.stepaiDeviceName = stepaiDeviceName;
        this.stepaiUserId = stepaiUserId;
        this.phoneDeviceId = phoneDeviceId;
        this.phoneDeviceName = phoneDeviceName;
        this.loginToken = loginToken;
        this.ts = j10;
    }

    public static /* synthetic */ BindStepaiDeviceRequest b(BindStepaiDeviceRequest bindStepaiDeviceRequest, String str, String str2, String str3, String str4, String str5, String str6, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = bindStepaiDeviceRequest.stepaiDeviceId;
        }
        if ((i10 & 2) != 0) {
            str2 = bindStepaiDeviceRequest.stepaiDeviceName;
        }
        if ((i10 & 4) != 0) {
            str3 = bindStepaiDeviceRequest.stepaiUserId;
        }
        if ((i10 & 8) != 0) {
            str4 = bindStepaiDeviceRequest.phoneDeviceId;
        }
        if ((i10 & 16) != 0) {
            str5 = bindStepaiDeviceRequest.phoneDeviceName;
        }
        if ((i10 & 32) != 0) {
            str6 = bindStepaiDeviceRequest.loginToken;
        }
        if ((i10 & 64) != 0) {
            j10 = bindStepaiDeviceRequest.ts;
        }
        long j11 = j10;
        String str7 = str5;
        String str8 = str6;
        return bindStepaiDeviceRequest.a(str, str2, str3, str4, str7, str8, j11);
    }

    public final BindStepaiDeviceRequest a(String stepaiDeviceId, String stepaiDeviceName, String stepaiUserId, String phoneDeviceId, String phoneDeviceName, String loginToken, long ts) {
        kotlin.jvm.internal.p.i(stepaiDeviceId, "stepaiDeviceId");
        kotlin.jvm.internal.p.i(stepaiDeviceName, "stepaiDeviceName");
        kotlin.jvm.internal.p.i(stepaiUserId, "stepaiUserId");
        kotlin.jvm.internal.p.i(phoneDeviceId, "phoneDeviceId");
        kotlin.jvm.internal.p.i(phoneDeviceName, "phoneDeviceName");
        kotlin.jvm.internal.p.i(loginToken, "loginToken");
        return new BindStepaiDeviceRequest(stepaiDeviceId, stepaiDeviceName, stepaiUserId, phoneDeviceId, phoneDeviceName, loginToken, ts);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BindStepaiDeviceRequest)) {
            return false;
        }
        BindStepaiDeviceRequest bindStepaiDeviceRequest = (BindStepaiDeviceRequest) other;
        return kotlin.jvm.internal.p.d(this.stepaiDeviceId, bindStepaiDeviceRequest.stepaiDeviceId) && kotlin.jvm.internal.p.d(this.stepaiDeviceName, bindStepaiDeviceRequest.stepaiDeviceName) && kotlin.jvm.internal.p.d(this.stepaiUserId, bindStepaiDeviceRequest.stepaiUserId) && kotlin.jvm.internal.p.d(this.phoneDeviceId, bindStepaiDeviceRequest.phoneDeviceId) && kotlin.jvm.internal.p.d(this.phoneDeviceName, bindStepaiDeviceRequest.phoneDeviceName) && kotlin.jvm.internal.p.d(this.loginToken, bindStepaiDeviceRequest.loginToken) && this.ts == bindStepaiDeviceRequest.ts;
    }

    public int hashCode() {
        return (((((((((((this.stepaiDeviceId.hashCode() * 31) + this.stepaiDeviceName.hashCode()) * 31) + this.stepaiUserId.hashCode()) * 31) + this.phoneDeviceId.hashCode()) * 31) + this.phoneDeviceName.hashCode()) * 31) + this.loginToken.hashCode()) * 31) + Long.hashCode(this.ts);
    }

    public String toString() {
        return "BindStepaiDeviceRequest(stepaiDeviceId=" + this.stepaiDeviceId + ", stepaiDeviceName=" + this.stepaiDeviceName + ", stepaiUserId=" + this.stepaiUserId + ", phoneDeviceId=" + this.phoneDeviceId + ", phoneDeviceName=" + this.phoneDeviceName + ", loginToken=" + this.loginToken + ", ts=" + this.ts + ")";
    }
}
