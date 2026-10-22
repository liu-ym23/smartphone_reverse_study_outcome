package com.stepos.taskrobot.llmapi.stepfun;

import D7.v;
import D7.z;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import stepai.aios.guiagent.model.SessionState;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J3\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004¢\u0006\u0004\b\u001d\u0010\u001eJ\u001d\u0010 \u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0004¢\u0006\u0004\b \u0010\u001eJ\u001d\u0010#\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\u0015\u0010%\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b%\u0010\u001bJ\u0013\u0010'\u001a\b\u0012\u0004\u0012\u00020\n0&¢\u0006\u0004\b'\u0010(J\r\u0010)\u001a\u00020\u0013¢\u0006\u0004\b)\u0010\u0003R\u0014\u0010*\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b,\u0010+R\u0014\u0010-\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b-\u0010+R \u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100¨\u00061"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/GuitaskreportManager;", "", AppAgent.CONSTRUCT, "()V", "", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_NAME, GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID, "appName", "Lstepai/aios/guiagent/model/SessionState;", "taskState", "Lcom/stepos/taskrobot/llmapi/stepfun/GuiTaskReport;", "createReport", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lstepai/aios/guiagent/model/SessionState;)Lcom/stepos/taskrobot/llmapi/stepfun/GuiTaskReport;", "getReport", "(Ljava/lang/String;)Lcom/stepos/taskrobot/llmapi/stepfun/GuiTaskReport;", "Lcom/stepos/taskrobot/llmapi/stepfun/SimpleGuiTaskReport;", "getReportSimple", "(Ljava/lang/String;)Lcom/stepos/taskrobot/llmapi/stepfun/SimpleGuiTaskReport;", "state", "LC7/r;", "updateReportState", "(Ljava/lang/String;Lstepai/aios/guiagent/model/SessionState;)V", AgentBusWakeContract.EXTRA_TRACE_ID, "sjflTraceId", "updateReportTraceIds", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "finishReport", "(Ljava/lang/String;)V", "screenshotPath", "addCaptureScreenAction", "(Ljava/lang/String;Ljava/lang/String;)V", "content", "addLlmChatAction", "Lza/g;", "stepExecutionInfo", "addStepExecutionInfoAction", "(Ljava/lang/String;Lza/g;)V", "removeReport", "", "getAllReports", "()Ljava/util/List;", "clearAllReports", "ACTION_TYPE_CAPTURE_SCREEN", "Ljava/lang/String;", "ACTION_TYPE_LLM_CHAT", "ACTION_TYPE_STEP_EXECUTION_INFO", "", "reports", "Ljava/util/Map;", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GuitaskreportManager {
    private static final String ACTION_TYPE_CAPTURE_SCREEN = "captureScreen";
    private static final String ACTION_TYPE_LLM_CHAT = "llm_chat";
    private static final String ACTION_TYPE_STEP_EXECUTION_INFO = "StepExecutionInfo";
    public static final GuitaskreportManager INSTANCE = new GuitaskreportManager();
    private static final Map<String, GuiTaskReport> reports = new LinkedHashMap();

    private GuitaskreportManager() {
    }

    public static /* synthetic */ GuiTaskReport createReport$default(GuitaskreportManager guitaskreportManager, String str, String str2, String str3, SessionState sessionState, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = null;
        }
        if ((i & 8) != 0) {
            sessionState = SessionState.f6031a;
        }
        return guitaskreportManager.createReport(str, str2, str3, sessionState);
    }

    public final synchronized void addCaptureScreenAction(String taskId, String screenshotPath) {
        List<ActionDetail> actions;
        kotlin.jvm.internal.k.f(taskId, "taskId");
        kotlin.jvm.internal.k.f(screenshotPath, "screenshotPath");
        ActionDetail actionDetail = new ActionDetail(ACTION_TYPE_CAPTURE_SCREEN, System.currentTimeMillis(), screenshotPath, null, null, 24, null);
        GuiTaskReport guiTaskReport = reports.get(taskId);
        if (guiTaskReport != null && (actions = guiTaskReport.getActions()) != null) {
            actions.add(actionDetail);
        }
    }

    public final synchronized void addLlmChatAction(String taskId, String content) {
        List<ActionDetail> actions;
        try {
            kotlin.jvm.internal.k.f(taskId, "taskId");
            kotlin.jvm.internal.k.f(content, "content");
            ActionDetail actionDetail = new ActionDetail(ACTION_TYPE_LLM_CHAT, System.currentTimeMillis(), null, content, null, 20, null);
            Map<String, GuiTaskReport> map = reports;
            GuiTaskReport guiTaskReport = map.get(taskId);
            if (guiTaskReport != null && (actions = guiTaskReport.getActions()) != null) {
                actions.add(actionDetail);
            }
            GuiTaskReport guiTaskReport2 = map.get(taskId);
            if (guiTaskReport2 != null) {
                guiTaskReport2.setLastLlmResponse(content);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void addStepExecutionInfoAction(String taskId, za.g stepExecutionInfo) {
        List<ActionDetail> actions;
        kotlin.jvm.internal.k.f(taskId, "taskId");
        kotlin.jvm.internal.k.f(stepExecutionInfo, "stepExecutionInfo");
        ActionDetail actionDetail = new ActionDetail(ACTION_TYPE_STEP_EXECUTION_INFO, System.currentTimeMillis(), null, null, stepExecutionInfo, 12, null);
        GuiTaskReport guiTaskReport = reports.get(taskId);
        if (guiTaskReport != null && (actions = guiTaskReport.getActions()) != null) {
            actions.add(actionDetail);
        }
    }

    public final synchronized void clearAllReports() {
        reports.clear();
    }

    public final synchronized GuiTaskReport createReport(String taskName, String taskId, String appName, SessionState taskState) {
        GuiTaskReport guiTaskReport;
        kotlin.jvm.internal.k.f(taskName, "taskName");
        kotlin.jvm.internal.k.f(taskId, "taskId");
        kotlin.jvm.internal.k.f(taskState, "taskState");
        guiTaskReport = new GuiTaskReport(taskName, taskId, System.currentTimeMillis(), null, appName, false, taskState, null, null, null, null, 1960, null);
        reports.put(taskId, guiTaskReport);
        return guiTaskReport;
    }

    public final synchronized void finishReport(String taskId) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        GuiTaskReport guiTaskReport = reports.get(taskId);
        if (guiTaskReport != null) {
            guiTaskReport.setEndTime(Long.valueOf(System.currentTimeMillis()));
        }
    }

    public final synchronized List<GuiTaskReport> getAllReports() {
        return v.f1(reports.values());
    }

    public final synchronized GuiTaskReport getReport(String taskId) {
        GuiTaskReport guiTaskReport;
        List<ActionDetail> actions;
        kotlin.jvm.internal.k.f(taskId, "taskId");
        guiTaskReport = reports.get(taskId);
        if (guiTaskReport != null && (actions = guiTaskReport.getActions()) != null && actions.size() > 1) {
            z.d0(new Comparator() { // from class: com.stepos.taskrobot.llmapi.stepfun.GuitaskreportManager$getReport$$inlined$sortBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t9, T t10) {
                    return N9.j.m(Long.valueOf(((ActionDetail) t9).getTime()), Long.valueOf(((ActionDetail) t10).getTime()));
                }
            }, actions);
        }
        return guiTaskReport;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized com.stepos.taskrobot.llmapi.stepfun.SimpleGuiTaskReport getReportSimple(java.lang.String r19) {
        /*
            Method dump skipped, instructions count: 293
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.GuitaskreportManager.getReportSimple(java.lang.String):com.stepos.taskrobot.llmapi.stepfun.SimpleGuiTaskReport");
    }

    public final synchronized void removeReport(String taskId) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        reports.remove(taskId);
    }

    public final synchronized void updateReportState(String taskId, SessionState state) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        kotlin.jvm.internal.k.f(state, "state");
        GuiTaskReport guiTaskReport = reports.get(taskId);
        if (guiTaskReport != null) {
            guiTaskReport.setTaskState(state);
        }
    }

    public final synchronized void updateReportTraceIds(String taskId, String traceId, String sjflTraceId) {
        kotlin.jvm.internal.k.f(taskId, "taskId");
        kotlin.jvm.internal.k.f(traceId, "traceId");
        kotlin.jvm.internal.k.f(sjflTraceId, "sjflTraceId");
        GuiTaskReport guiTaskReport = reports.get(taskId);
        if (guiTaskReport != null) {
            guiTaskReport.setTraceId(traceId);
            guiTaskReport.setSjflTraceId(sjflTraceId);
        }
    }
}
