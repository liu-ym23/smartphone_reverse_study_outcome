package com.stepos.ailauncher.agent.aispace.connect.data;

import com.google.gson.annotations.SerializedName;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0080\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0014\u0010\nR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0015\u0010\nR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0016\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/connect/data/t;", "", "", "fileId", "deviceId", "sessionId", SystemDeleteBroadcastReceiver.EXTRA_RUN_ID, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getFileId", "getDeviceId", "getSessionId", "getRunId", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.connect.data.t, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class GetFileSyncRequest {

    @SerializedName(Parameters.DEVICE_ID)
    private final String deviceId;

    @SerializedName("file_id")
    private final String fileId;

    @SerializedName("run_id")
    private final String runId;

    @SerializedName("session_id")
    private final String sessionId;

    public GetFileSyncRequest(String fileId, String str, String str2, String str3) {
        kotlin.jvm.internal.p.i(fileId, "fileId");
        this.fileId = fileId;
        this.deviceId = str;
        this.sessionId = str2;
        this.runId = str3;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GetFileSyncRequest)) {
            return false;
        }
        GetFileSyncRequest getFileSyncRequest = (GetFileSyncRequest) other;
        return kotlin.jvm.internal.p.d(this.fileId, getFileSyncRequest.fileId) && kotlin.jvm.internal.p.d(this.deviceId, getFileSyncRequest.deviceId) && kotlin.jvm.internal.p.d(this.sessionId, getFileSyncRequest.sessionId) && kotlin.jvm.internal.p.d(this.runId, getFileSyncRequest.runId);
    }

    public int hashCode() {
        int iHashCode = this.fileId.hashCode() * 31;
        String str = this.deviceId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.sessionId;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.runId;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "GetFileSyncRequest(fileId=" + this.fileId + ", deviceId=" + this.deviceId + ", sessionId=" + this.sessionId + ", runId=" + this.runId + ")";
    }

    public /* synthetic */ GetFileSyncRequest(String str, String str2, String str3, String str4, int i10, kotlin.jvm.internal.i iVar) {
        this(str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : str4);
    }
}
