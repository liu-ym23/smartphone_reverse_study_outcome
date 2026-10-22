package com.stepos.taskrobot.llmapi.stepfun;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\rJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\rJ\u0012\u0010\u0012\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013JH\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\rJ\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b!\u0010\u000fR$\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b\"\u0010\r\"\u0004\b#\u0010$R$\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b%\u0010\r\"\u0004\b&\u0010$R$\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010'\u001a\u0004\b(\u0010\u0013\"\u0004\b)\u0010*¨\u0006+"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/ActionDetail;", "", "", "actionType", "", "time", "screenshotPath", "llmResponse", "Lza/g;", "stepExecutionInfo", AppAgent.CONSTRUCT, "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Lza/g;)V", "component1", "()Ljava/lang/String;", "component2", "()J", "component3", "component4", "component5", "()Lza/g;", "copy", "(Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Lza/g;)Lcom/stepos/taskrobot/llmapi/stepfun/ActionDetail;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getActionType", "J", "getTime", "getScreenshotPath", "setScreenshotPath", "(Ljava/lang/String;)V", "getLlmResponse", "setLlmResponse", "Lza/g;", "getStepExecutionInfo", "setStepExecutionInfo", "(Lza/g;)V", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ActionDetail {
    private final String actionType;
    private String llmResponse;
    private String screenshotPath;
    private za.g stepExecutionInfo;
    private final long time;

    public ActionDetail(String actionType, long j5, String str, String str2, za.g gVar) {
        kotlin.jvm.internal.k.f(actionType, "actionType");
        this.actionType = actionType;
        this.time = j5;
        this.screenshotPath = str;
        this.llmResponse = str2;
        this.stepExecutionInfo = gVar;
    }

    public static /* synthetic */ ActionDetail copy$default(ActionDetail actionDetail, String str, long j5, String str2, String str3, za.g gVar, int i, Object obj) {
        if ((i & 1) != 0) {
            str = actionDetail.actionType;
        }
        if ((i & 2) != 0) {
            j5 = actionDetail.time;
        }
        if ((i & 4) != 0) {
            str2 = actionDetail.screenshotPath;
        }
        if ((i & 8) != 0) {
            str3 = actionDetail.llmResponse;
        }
        if ((i & 16) != 0) {
            gVar = actionDetail.stepExecutionInfo;
        }
        za.g gVar2 = gVar;
        String str4 = str2;
        return actionDetail.copy(str, j5, str4, str3, gVar2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getActionType() {
        return this.actionType;
    }

    /* renamed from: component2, reason: from getter */
    public final long getTime() {
        return this.time;
    }

    /* renamed from: component3, reason: from getter */
    public final String getScreenshotPath() {
        return this.screenshotPath;
    }

    /* renamed from: component4, reason: from getter */
    public final String getLlmResponse() {
        return this.llmResponse;
    }

    /* renamed from: component5, reason: from getter */
    public final za.g getStepExecutionInfo() {
        return this.stepExecutionInfo;
    }

    public final ActionDetail copy(String actionType, long time, String screenshotPath, String llmResponse, za.g stepExecutionInfo) {
        kotlin.jvm.internal.k.f(actionType, "actionType");
        return new ActionDetail(actionType, time, screenshotPath, llmResponse, stepExecutionInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActionDetail)) {
            return false;
        }
        ActionDetail actionDetail = (ActionDetail) other;
        return kotlin.jvm.internal.k.b(this.actionType, actionDetail.actionType) && this.time == actionDetail.time && kotlin.jvm.internal.k.b(this.screenshotPath, actionDetail.screenshotPath) && kotlin.jvm.internal.k.b(this.llmResponse, actionDetail.llmResponse) && kotlin.jvm.internal.k.b(this.stepExecutionInfo, actionDetail.stepExecutionInfo);
    }

    public final String getActionType() {
        return this.actionType;
    }

    public final String getLlmResponse() {
        return this.llmResponse;
    }

    public final String getScreenshotPath() {
        return this.screenshotPath;
    }

    public final za.g getStepExecutionInfo() {
        return this.stepExecutionInfo;
    }

    public final long getTime() {
        return this.time;
    }

    public int hashCode() {
        int iC = androidx.appfunctions.metadata.a.c(this.actionType.hashCode() * 31, 31, this.time);
        String str = this.screenshotPath;
        int iHashCode = (iC + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.llmResponse;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        za.g gVar = this.stepExecutionInfo;
        return iHashCode2 + (gVar != null ? gVar.hashCode() : 0);
    }

    public final void setLlmResponse(String str) {
        this.llmResponse = str;
    }

    public final void setScreenshotPath(String str) {
        this.screenshotPath = str;
    }

    public final void setStepExecutionInfo(za.g gVar) {
        this.stepExecutionInfo = gVar;
    }

    public String toString() {
        String str = this.actionType;
        long j5 = this.time;
        String str2 = this.screenshotPath;
        String str3 = this.llmResponse;
        za.g gVar = this.stepExecutionInfo;
        StringBuilder sb = new StringBuilder("ActionDetail(actionType=");
        sb.append(str);
        sb.append(", time=");
        sb.append(j5);
        androidx.constraintlayout.core.dsl.a.A(sb, ", screenshotPath=", str2, ", llmResponse=", str3);
        sb.append(", stepExecutionInfo=");
        sb.append(gVar);
        sb.append(")");
        return sb.toString();
    }

    public /* synthetic */ ActionDetail(String str, long j5, String str2, String str3, za.g gVar, int i, kotlin.jvm.internal.e eVar) {
        this(str, j5, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : gVar);
    }
}
