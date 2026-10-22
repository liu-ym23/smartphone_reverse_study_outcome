package com.stepos.taskrobot.llmapi.stepfun;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import stepai.aios.guiagent.model.SessionState;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b1\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bw\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0006HÆ\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00107\u001a\u00020\nHÆ\u0003J\t\u00108\u001a\u00020\fHÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fHÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\u0088\u0001\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010>J\u0013\u0010?\u001a\u00020\n2\b\u0010@\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010A\u001a\u00020BHÖ\u0001J\t\u0010C\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010!R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0016\"\u0004\b+\u0010!R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u001a\u0010\u0011\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0016\"\u0004\b/\u0010!R\u001a\u0010\u0012\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0016\"\u0004\b1\u0010!¨\u0006D"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/GuiTaskReport;", "", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_NAME, "", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID, "startTime", "", "endTime", "appName", "preOpenApp", "", "taskState", "Lstepai/aios/guiagent/model/SessionState;", "lastLlmResponse", "actions", "", "Lcom/stepos/taskrobot/llmapi/stepfun/ActionDetail;", AgentBusWakeContract.EXTRA_TRACE_ID, "sjflTraceId", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/Long;Ljava/lang/String;ZLstepai/aios/guiagent/model/SessionState;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getTaskName", "()Ljava/lang/String;", "getTaskId", "getStartTime", "()J", "getEndTime", "()Ljava/lang/Long;", "setEndTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getAppName", "setAppName", "(Ljava/lang/String;)V", "getPreOpenApp", "()Z", "setPreOpenApp", "(Z)V", "getTaskState", "()Lstepai/aios/guiagent/model/SessionState;", "setTaskState", "(Lstepai/aios/guiagent/model/SessionState;)V", "getLastLlmResponse", "setLastLlmResponse", "getActions", "()Ljava/util/List;", "getTraceId", "setTraceId", "getSjflTraceId", "setSjflTraceId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/Long;Ljava/lang/String;ZLstepai/aios/guiagent/model/SessionState;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/taskrobot/llmapi/stepfun/GuiTaskReport;", "equals", "other", "hashCode", "", "toString", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class GuiTaskReport {
    private final List<ActionDetail> actions;
    private String appName;
    private Long endTime;
    private String lastLlmResponse;
    private boolean preOpenApp;
    private String sjflTraceId;
    private final long startTime;
    private final String taskId;
    private final String taskName;
    private SessionState taskState;
    private String traceId;

    public GuiTaskReport(String taskName, String taskId, long j5, Long l, String str, boolean z10, SessionState taskState, String str2, List<ActionDetail> actions, String traceId, String sjflTraceId) {
        kotlin.jvm.internal.k.f(taskName, "taskName");
        kotlin.jvm.internal.k.f(taskId, "taskId");
        kotlin.jvm.internal.k.f(taskState, "taskState");
        kotlin.jvm.internal.k.f(actions, "actions");
        kotlin.jvm.internal.k.f(traceId, "traceId");
        kotlin.jvm.internal.k.f(sjflTraceId, "sjflTraceId");
        this.taskName = taskName;
        this.taskId = taskId;
        this.startTime = j5;
        this.endTime = l;
        this.appName = str;
        this.preOpenApp = z10;
        this.taskState = taskState;
        this.lastLlmResponse = str2;
        this.actions = actions;
        this.traceId = traceId;
        this.sjflTraceId = sjflTraceId;
    }

    public static /* synthetic */ GuiTaskReport copy$default(GuiTaskReport guiTaskReport, String str, String str2, long j5, Long l, String str3, boolean z10, SessionState sessionState, String str4, List list, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = guiTaskReport.taskName;
        }
        if ((i & 2) != 0) {
            str2 = guiTaskReport.taskId;
        }
        if ((i & 4) != 0) {
            j5 = guiTaskReport.startTime;
        }
        if ((i & 8) != 0) {
            l = guiTaskReport.endTime;
        }
        if ((i & 16) != 0) {
            str3 = guiTaskReport.appName;
        }
        if ((i & 32) != 0) {
            z10 = guiTaskReport.preOpenApp;
        }
        if ((i & 64) != 0) {
            sessionState = guiTaskReport.taskState;
        }
        if ((i & 128) != 0) {
            str4 = guiTaskReport.lastLlmResponse;
        }
        if ((i & 256) != 0) {
            list = guiTaskReport.actions;
        }
        if ((i & 512) != 0) {
            str5 = guiTaskReport.traceId;
        }
        if ((i & 1024) != 0) {
            str6 = guiTaskReport.sjflTraceId;
        }
        String str7 = str5;
        String str8 = str6;
        String str9 = str4;
        List list2 = list;
        long j6 = j5;
        return guiTaskReport.copy(str, str2, j6, l, str3, z10, sessionState, str9, list2, str7, str8);
    }

    /* renamed from: component1, reason: from getter */
    public final String getTaskName() {
        return this.taskName;
    }

    /* renamed from: component10, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    /* renamed from: component11, reason: from getter */
    public final String getSjflTraceId() {
        return this.sjflTraceId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    /* renamed from: component3, reason: from getter */
    public final long getStartTime() {
        return this.startTime;
    }

    /* renamed from: component4, reason: from getter */
    public final Long getEndTime() {
        return this.endTime;
    }

    /* renamed from: component5, reason: from getter */
    public final String getAppName() {
        return this.appName;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getPreOpenApp() {
        return this.preOpenApp;
    }

    /* renamed from: component7, reason: from getter */
    public final SessionState getTaskState() {
        return this.taskState;
    }

    /* renamed from: component8, reason: from getter */
    public final String getLastLlmResponse() {
        return this.lastLlmResponse;
    }

    public final List<ActionDetail> component9() {
        return this.actions;
    }

    public final GuiTaskReport copy(String taskName, String taskId, long startTime, Long endTime, String appName, boolean preOpenApp, SessionState taskState, String lastLlmResponse, List<ActionDetail> actions, String traceId, String sjflTraceId) {
        kotlin.jvm.internal.k.f(taskName, "taskName");
        kotlin.jvm.internal.k.f(taskId, "taskId");
        kotlin.jvm.internal.k.f(taskState, "taskState");
        kotlin.jvm.internal.k.f(actions, "actions");
        kotlin.jvm.internal.k.f(traceId, "traceId");
        kotlin.jvm.internal.k.f(sjflTraceId, "sjflTraceId");
        return new GuiTaskReport(taskName, taskId, startTime, endTime, appName, preOpenApp, taskState, lastLlmResponse, actions, traceId, sjflTraceId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuiTaskReport)) {
            return false;
        }
        GuiTaskReport guiTaskReport = (GuiTaskReport) other;
        return kotlin.jvm.internal.k.b(this.taskName, guiTaskReport.taskName) && kotlin.jvm.internal.k.b(this.taskId, guiTaskReport.taskId) && this.startTime == guiTaskReport.startTime && kotlin.jvm.internal.k.b(this.endTime, guiTaskReport.endTime) && kotlin.jvm.internal.k.b(this.appName, guiTaskReport.appName) && this.preOpenApp == guiTaskReport.preOpenApp && this.taskState == guiTaskReport.taskState && kotlin.jvm.internal.k.b(this.lastLlmResponse, guiTaskReport.lastLlmResponse) && kotlin.jvm.internal.k.b(this.actions, guiTaskReport.actions) && kotlin.jvm.internal.k.b(this.traceId, guiTaskReport.traceId) && kotlin.jvm.internal.k.b(this.sjflTraceId, guiTaskReport.sjflTraceId);
    }

    public final List<ActionDetail> getActions() {
        return this.actions;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final Long getEndTime() {
        return this.endTime;
    }

    public final String getLastLlmResponse() {
        return this.lastLlmResponse;
    }

    public final boolean getPreOpenApp() {
        return this.preOpenApp;
    }

    public final String getSjflTraceId() {
        return this.sjflTraceId;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getTaskName() {
        return this.taskName;
    }

    public final SessionState getTaskState() {
        return this.taskState;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public int hashCode() {
        int iC = androidx.appfunctions.metadata.a.c(B7.a.c(this.taskName.hashCode() * 31, 31, this.taskId), 31, this.startTime);
        Long l = this.endTime;
        int iHashCode = (iC + (l == null ? 0 : l.hashCode())) * 31;
        String str = this.appName;
        int iHashCode2 = (this.taskState.hashCode() + androidx.appfunctions.metadata.a.d((iHashCode + (str == null ? 0 : str.hashCode())) * 31, 31, this.preOpenApp)) * 31;
        String str2 = this.lastLlmResponse;
        return this.sjflTraceId.hashCode() + B7.a.c(androidx.appfunctions.metadata.a.e(this.actions, (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31, 31), 31, this.traceId);
    }

    public final void setAppName(String str) {
        this.appName = str;
    }

    public final void setEndTime(Long l) {
        this.endTime = l;
    }

    public final void setLastLlmResponse(String str) {
        this.lastLlmResponse = str;
    }

    public final void setPreOpenApp(boolean z10) {
        this.preOpenApp = z10;
    }

    public final void setSjflTraceId(String str) {
        kotlin.jvm.internal.k.f(str, "<set-?>");
        this.sjflTraceId = str;
    }

    public final void setTaskState(SessionState sessionState) {
        kotlin.jvm.internal.k.f(sessionState, "<set-?>");
        this.taskState = sessionState;
    }

    public final void setTraceId(String str) {
        kotlin.jvm.internal.k.f(str, "<set-?>");
        this.traceId = str;
    }

    public String toString() {
        String str = this.taskName;
        String str2 = this.taskId;
        long j5 = this.startTime;
        Long l = this.endTime;
        String str3 = this.appName;
        boolean z10 = this.preOpenApp;
        SessionState sessionState = this.taskState;
        String str4 = this.lastLlmResponse;
        List<ActionDetail> list = this.actions;
        String str5 = this.traceId;
        String str6 = this.sjflTraceId;
        StringBuilder sbW = B7.a.w("GuiTaskReport(taskName=", str, ", taskId=", str2, ", startTime=");
        sbW.append(j5);
        sbW.append(", endTime=");
        sbW.append(l);
        sbW.append(", appName=");
        sbW.append(str3);
        sbW.append(", preOpenApp=");
        sbW.append(z10);
        sbW.append(", taskState=");
        sbW.append(sessionState);
        sbW.append(", lastLlmResponse=");
        sbW.append(str4);
        sbW.append(", actions=");
        sbW.append(list);
        sbW.append(", traceId=");
        sbW.append(str5);
        return androidx.constraintlayout.core.dsl.a.j(sbW, ", sjflTraceId=", str6, ")");
    }

    public /* synthetic */ GuiTaskReport(String str, String str2, long j5, Long l, String str3, boolean z10, SessionState sessionState, String str4, List list, String str5, String str6, int i, kotlin.jvm.internal.e eVar) {
        this(str, str2, j5, (i & 8) != 0 ? null : l, str3, (i & 32) != 0 ? false : z10, sessionState, (i & 128) != 0 ? null : str4, (i & 256) != 0 ? new ArrayList() : list, (i & 512) != 0 ? "" : str5, (i & 1024) != 0 ? "" : str6);
    }
}
