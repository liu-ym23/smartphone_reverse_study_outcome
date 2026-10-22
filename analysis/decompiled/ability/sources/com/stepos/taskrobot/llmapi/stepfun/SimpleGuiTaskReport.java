package com.stepos.taskrobot.llmapi.stepfun;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import stepai.aios.guiagent.model.SessionState;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b5\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u008d\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0006HÆ\u0003J\u0010\u0010;\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010=\u001a\u00020\nHÆ\u0003J\t\u0010>\u001a\u00020\fHÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\u000f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013HÆ\u0003J\u009e\u0001\u0010E\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013HÆ\u0001¢\u0006\u0002\u0010FJ\u0013\u0010G\u001a\u00020\n2\b\u0010H\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010I\u001a\u00020JHÖ\u0001J\t\u0010K\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010#R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0018\"\u0004\b-\u0010#R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0018\"\u0004\b/\u0010#R\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0018\"\u0004\b1\u0010#R\u001a\u0010\u0010\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0018\"\u0004\b3\u0010#R\u001a\u0010\u0011\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0018\"\u0004\b5\u0010#R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\b\n\u0000\u001a\u0004\b6\u00107¨\u0006L"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/SimpleGuiTaskReport;", "", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_NAME, "", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID, "startTime", "", "endTime", "appName", "preOpenApp", "", "taskState", "Lstepai/aios/guiagent/model/SessionState;", "lastLlmResponse", "lastScreenshotPath", AgentBusWakeContract.EXTRA_TRACE_ID, "sjflTraceId", "cancelReason", "content", "", "Lcom/stepos/taskrobot/llmapi/stepfun/ContentItem;", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/Long;Ljava/lang/String;ZLstepai/aios/guiagent/model/SessionState;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getTaskName", "()Ljava/lang/String;", "getTaskId", "getStartTime", "()J", "getEndTime", "()Ljava/lang/Long;", "setEndTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getAppName", "setAppName", "(Ljava/lang/String;)V", "getPreOpenApp", "()Z", "setPreOpenApp", "(Z)V", "getTaskState", "()Lstepai/aios/guiagent/model/SessionState;", "setTaskState", "(Lstepai/aios/guiagent/model/SessionState;)V", "getLastLlmResponse", "setLastLlmResponse", "getLastScreenshotPath", "setLastScreenshotPath", "getTraceId", "setTraceId", "getSjflTraceId", "setSjflTraceId", "getCancelReason", "setCancelReason", "getContent", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/Long;Ljava/lang/String;ZLstepai/aios/guiagent/model/SessionState;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lcom/stepos/taskrobot/llmapi/stepfun/SimpleGuiTaskReport;", "equals", "other", "hashCode", "", "toString", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class SimpleGuiTaskReport {
    private String appName;
    private String cancelReason;
    private final List<ContentItem> content;
    private Long endTime;
    private String lastLlmResponse;
    private String lastScreenshotPath;
    private boolean preOpenApp;
    private String sjflTraceId;
    private final long startTime;
    private final String taskId;
    private final String taskName;
    private SessionState taskState;
    private String traceId;

    public SimpleGuiTaskReport(String taskName, String taskId, long j5, Long l, String str, boolean z10, SessionState taskState, String str2, String str3, String traceId, String sjflTraceId, String cancelReason, List<ContentItem> content) {
        kotlin.jvm.internal.k.f(taskName, "taskName");
        kotlin.jvm.internal.k.f(taskId, "taskId");
        kotlin.jvm.internal.k.f(taskState, "taskState");
        kotlin.jvm.internal.k.f(traceId, "traceId");
        kotlin.jvm.internal.k.f(sjflTraceId, "sjflTraceId");
        kotlin.jvm.internal.k.f(cancelReason, "cancelReason");
        kotlin.jvm.internal.k.f(content, "content");
        this.taskName = taskName;
        this.taskId = taskId;
        this.startTime = j5;
        this.endTime = l;
        this.appName = str;
        this.preOpenApp = z10;
        this.taskState = taskState;
        this.lastLlmResponse = str2;
        this.lastScreenshotPath = str3;
        this.traceId = traceId;
        this.sjflTraceId = sjflTraceId;
        this.cancelReason = cancelReason;
        this.content = content;
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

    /* renamed from: component12, reason: from getter */
    public final String getCancelReason() {
        return this.cancelReason;
    }

    public final List<ContentItem> component13() {
        return this.content;
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

    /* renamed from: component9, reason: from getter */
    public final String getLastScreenshotPath() {
        return this.lastScreenshotPath;
    }

    public final SimpleGuiTaskReport copy(String taskName, String taskId, long startTime, Long endTime, String appName, boolean preOpenApp, SessionState taskState, String lastLlmResponse, String lastScreenshotPath, String traceId, String sjflTraceId, String cancelReason, List<ContentItem> content) {
        kotlin.jvm.internal.k.f(taskName, "taskName");
        kotlin.jvm.internal.k.f(taskId, "taskId");
        kotlin.jvm.internal.k.f(taskState, "taskState");
        kotlin.jvm.internal.k.f(traceId, "traceId");
        kotlin.jvm.internal.k.f(sjflTraceId, "sjflTraceId");
        kotlin.jvm.internal.k.f(cancelReason, "cancelReason");
        kotlin.jvm.internal.k.f(content, "content");
        return new SimpleGuiTaskReport(taskName, taskId, startTime, endTime, appName, preOpenApp, taskState, lastLlmResponse, lastScreenshotPath, traceId, sjflTraceId, cancelReason, content);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SimpleGuiTaskReport)) {
            return false;
        }
        SimpleGuiTaskReport simpleGuiTaskReport = (SimpleGuiTaskReport) other;
        return kotlin.jvm.internal.k.b(this.taskName, simpleGuiTaskReport.taskName) && kotlin.jvm.internal.k.b(this.taskId, simpleGuiTaskReport.taskId) && this.startTime == simpleGuiTaskReport.startTime && kotlin.jvm.internal.k.b(this.endTime, simpleGuiTaskReport.endTime) && kotlin.jvm.internal.k.b(this.appName, simpleGuiTaskReport.appName) && this.preOpenApp == simpleGuiTaskReport.preOpenApp && this.taskState == simpleGuiTaskReport.taskState && kotlin.jvm.internal.k.b(this.lastLlmResponse, simpleGuiTaskReport.lastLlmResponse) && kotlin.jvm.internal.k.b(this.lastScreenshotPath, simpleGuiTaskReport.lastScreenshotPath) && kotlin.jvm.internal.k.b(this.traceId, simpleGuiTaskReport.traceId) && kotlin.jvm.internal.k.b(this.sjflTraceId, simpleGuiTaskReport.sjflTraceId) && kotlin.jvm.internal.k.b(this.cancelReason, simpleGuiTaskReport.cancelReason) && kotlin.jvm.internal.k.b(this.content, simpleGuiTaskReport.content);
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getCancelReason() {
        return this.cancelReason;
    }

    public final List<ContentItem> getContent() {
        return this.content;
    }

    public final Long getEndTime() {
        return this.endTime;
    }

    public final String getLastLlmResponse() {
        return this.lastLlmResponse;
    }

    public final String getLastScreenshotPath() {
        return this.lastScreenshotPath;
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
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.lastScreenshotPath;
        return this.content.hashCode() + B7.a.c(B7.a.c(B7.a.c((iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31, 31, this.traceId), 31, this.sjflTraceId), 31, this.cancelReason);
    }

    public final void setAppName(String str) {
        this.appName = str;
    }

    public final void setCancelReason(String str) {
        kotlin.jvm.internal.k.f(str, "<set-?>");
        this.cancelReason = str;
    }

    public final void setEndTime(Long l) {
        this.endTime = l;
    }

    public final void setLastLlmResponse(String str) {
        this.lastLlmResponse = str;
    }

    public final void setLastScreenshotPath(String str) {
        this.lastScreenshotPath = str;
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
        String str5 = this.lastScreenshotPath;
        String str6 = this.traceId;
        String str7 = this.sjflTraceId;
        String str8 = this.cancelReason;
        List<ContentItem> list = this.content;
        StringBuilder sbW = B7.a.w("SimpleGuiTaskReport(taskName=", str, ", taskId=", str2, ", startTime=");
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
        androidx.constraintlayout.core.dsl.a.A(sbW, ", lastScreenshotPath=", str5, ", traceId=", str6);
        androidx.constraintlayout.core.dsl.a.A(sbW, ", sjflTraceId=", str7, ", cancelReason=", str8);
        sbW.append(", content=");
        sbW.append(list);
        sbW.append(")");
        return sbW.toString();
    }

    public SimpleGuiTaskReport(String str, String str2, long j5, Long l, String str3, boolean z10, SessionState sessionState, String str4, String str5, String str6, String str7, String str8, List list, int i, kotlin.jvm.internal.e eVar) {
        this(str, str2, j5, (i & 8) != 0 ? null : l, str3, (i & 32) != 0 ? false : z10, sessionState, (i & 128) != 0 ? null : str4, (i & 256) != 0 ? null : str5, (i & 512) != 0 ? "" : str6, (i & 1024) != 0 ? "" : str7, (i & 2048) != 0 ? "" : str8, (i & 4096) != 0 ? EmptyList.f4893a : list);
    }
}
