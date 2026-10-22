package com.stepos.ailauncher.agent.aispace.market.data;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0080\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u000fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0018\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001a\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001b\u0010\u0011R\u001a\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0019\u001a\u0004\b\u001c\u0010\u0011R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u001d\u0010\u000fR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/stepos/ailauncher/agent/aispace/market/data/p;", "", "", "taskId", "status", "", "totalSteps", "currentStep", "completedSteps", "errorMessage", "", "steps", "<init>", "(Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;Ljava/util/List;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "e", Const.INTENT_KEY_UMID, "I", "f", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "c", "Ljava/util/List;", "getSteps", "()Ljava/util/List;", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.agent.aispace.market.data.p, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class GetInstallProgressData {

    @SerializedName(alternate = {"completed_steps"}, value = "completedSteps")
    private final int completedSteps;

    @SerializedName(alternate = {"current_step"}, value = "currentStep")
    private final int currentStep;

    @SerializedName(alternate = {"error_message"}, value = "errorMessage")
    private final String errorMessage;

    @SerializedName("status")
    private final String status;

    @SerializedName("steps")
    private final List<Object> steps;

    @SerializedName(alternate = {"task_id"}, value = "taskId")
    private final String taskId;

    @SerializedName(alternate = {"total_steps"}, value = "totalSteps")
    private final int totalSteps;

    public GetInstallProgressData() {
        this(null, null, 0, 0, 0, null, null, 127, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getCompletedSteps() {
        return this.completedSteps;
    }

    /* renamed from: b, reason: from getter */
    public final int getCurrentStep() {
        return this.currentStep;
    }

    /* renamed from: c, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    /* renamed from: d, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: e, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GetInstallProgressData)) {
            return false;
        }
        GetInstallProgressData getInstallProgressData = (GetInstallProgressData) other;
        return kotlin.jvm.internal.p.d(this.taskId, getInstallProgressData.taskId) && kotlin.jvm.internal.p.d(this.status, getInstallProgressData.status) && this.totalSteps == getInstallProgressData.totalSteps && this.currentStep == getInstallProgressData.currentStep && this.completedSteps == getInstallProgressData.completedSteps && kotlin.jvm.internal.p.d(this.errorMessage, getInstallProgressData.errorMessage) && kotlin.jvm.internal.p.d(this.steps, getInstallProgressData.steps);
    }

    /* renamed from: f, reason: from getter */
    public final int getTotalSteps() {
        return this.totalSteps;
    }

    public int hashCode() {
        String str = this.taskId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.status;
        int iHashCode2 = (((((((iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + Integer.hashCode(this.totalSteps)) * 31) + Integer.hashCode(this.currentStep)) * 31) + Integer.hashCode(this.completedSteps)) * 31;
        String str3 = this.errorMessage;
        return ((iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.steps.hashCode();
    }

    public String toString() {
        return "GetInstallProgressData(taskId=" + this.taskId + ", status=" + this.status + ", totalSteps=" + this.totalSteps + ", currentStep=" + this.currentStep + ", completedSteps=" + this.completedSteps + ", errorMessage=" + this.errorMessage + ", steps=" + this.steps + ")";
    }

    public GetInstallProgressData(String str, String str2, int i10, int i11, int i12, String str3, List<Object> steps) {
        kotlin.jvm.internal.p.i(steps, "steps");
        this.taskId = str;
        this.status = str2;
        this.totalSteps = i10;
        this.currentStep = i11;
        this.completedSteps = i12;
        this.errorMessage = str3;
        this.steps = steps;
    }

    public /* synthetic */ GetInstallProgressData(String str, String str2, int i10, int i11, int i12, String str3, List list, int i13, kotlin.jvm.internal.i iVar) {
        this((i13 & 1) != 0 ? null : str, (i13 & 2) != 0 ? null : str2, (i13 & 4) != 0 ? 0 : i10, (i13 & 8) != 0 ? 0 : i11, (i13 & 16) != 0 ? 0 : i12, (i13 & 32) != 0 ? null : str3, (i13 & 64) != 0 ? C1173v.m() : list);
    }
}
