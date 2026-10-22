package com.stepos.taskrobot.llmapi.stepfun;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.Gson;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.ability.commoninternal.Key;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import java.util.HashMap;
import kotlin.Metadata;
import stepai.aios.guiagent.config.GuiAgentConfigKt;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u000bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0007¨\u0006\f"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/TaskParamsParser;", "", AppAgent.CONSTRUCT, "()V", "parse", "Lcom/stepos/taskrobot/llmapi/stepfun/TaskParamsParser$ParsedStartParams;", "paramsJson", "", "appPackageName", AgentBusWakeContract.EXTRA_TRACE_ID, Key.KEY_TOOL_CALL_ID, "ParsedStartParams", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskParamsParser {
    public static final TaskParamsParser INSTANCE = new TaskParamsParser();

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\"\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J%\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001`\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003JO\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032$\b\u0002\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001`\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR-\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u001c"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/TaskParamsParser$ParsedStartParams;", "", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_NAME, "", "meta", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "openAppName", "guiModelName", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;)V", "getTaskName", "()Ljava/lang/String;", "getMeta", "()Ljava/util/HashMap;", "getOpenAppName", "getGuiModelName", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ParsedStartParams {
        private final String guiModelName;
        private final HashMap<String, Object> meta;
        private final String openAppName;
        private final String taskName;

        public ParsedStartParams(String taskName, HashMap<String, Object> meta, String openAppName, String str) {
            kotlin.jvm.internal.k.f(taskName, "taskName");
            kotlin.jvm.internal.k.f(meta, "meta");
            kotlin.jvm.internal.k.f(openAppName, "openAppName");
            this.taskName = taskName;
            this.meta = meta;
            this.openAppName = openAppName;
            this.guiModelName = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ParsedStartParams copy$default(ParsedStartParams parsedStartParams, String str, HashMap map, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = parsedStartParams.taskName;
            }
            if ((i & 2) != 0) {
                map = parsedStartParams.meta;
            }
            if ((i & 4) != 0) {
                str2 = parsedStartParams.openAppName;
            }
            if ((i & 8) != 0) {
                str3 = parsedStartParams.guiModelName;
            }
            return parsedStartParams.copy(str, map, str2, str3);
        }

        /* renamed from: component1, reason: from getter */
        public final String getTaskName() {
            return this.taskName;
        }

        public final HashMap<String, Object> component2() {
            return this.meta;
        }

        /* renamed from: component3, reason: from getter */
        public final String getOpenAppName() {
            return this.openAppName;
        }

        /* renamed from: component4, reason: from getter */
        public final String getGuiModelName() {
            return this.guiModelName;
        }

        public final ParsedStartParams copy(String taskName, HashMap<String, Object> meta, String openAppName, String guiModelName) {
            kotlin.jvm.internal.k.f(taskName, "taskName");
            kotlin.jvm.internal.k.f(meta, "meta");
            kotlin.jvm.internal.k.f(openAppName, "openAppName");
            return new ParsedStartParams(taskName, meta, openAppName, guiModelName);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ParsedStartParams)) {
                return false;
            }
            ParsedStartParams parsedStartParams = (ParsedStartParams) other;
            return kotlin.jvm.internal.k.b(this.taskName, parsedStartParams.taskName) && kotlin.jvm.internal.k.b(this.meta, parsedStartParams.meta) && kotlin.jvm.internal.k.b(this.openAppName, parsedStartParams.openAppName) && kotlin.jvm.internal.k.b(this.guiModelName, parsedStartParams.guiModelName);
        }

        public final String getGuiModelName() {
            return this.guiModelName;
        }

        public final HashMap<String, Object> getMeta() {
            return this.meta;
        }

        public final String getOpenAppName() {
            return this.openAppName;
        }

        public final String getTaskName() {
            return this.taskName;
        }

        public int hashCode() {
            int iC = B7.a.c((this.meta.hashCode() + (this.taskName.hashCode() * 31)) * 31, 31, this.openAppName);
            String str = this.guiModelName;
            return iC + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            String str = this.taskName;
            HashMap<String, Object> map = this.meta;
            String str2 = this.openAppName;
            String str3 = this.guiModelName;
            StringBuilder sb = new StringBuilder("ParsedStartParams(taskName=");
            sb.append(str);
            sb.append(", meta=");
            sb.append(map);
            sb.append(", openAppName=");
            return androidx.appfunctions.metadata.a.p(sb, str2, ", guiModelName=", str3, ")");
        }
    }

    private TaskParamsParser() {
    }

    public final ParsedStartParams parse(String paramsJson, String appPackageName, String traceId, String toolCallId) {
        String task;
        HashMap<String, Object> meta;
        String appName;
        String guiModelName;
        String taskSource;
        String msgSource;
        kotlin.jvm.internal.k.f(paramsJson, "paramsJson");
        kotlin.jvm.internal.k.f(appPackageName, "appPackageName");
        RootTaskData rootTaskData = (RootTaskData) new Gson().fromJson(paramsJson, RootTaskData.class);
        if (rootTaskData.getGuiAgentParam() != null) {
            task = rootTaskData.getGuiAgentParam().getTask();
            meta = rootTaskData.getGuiAgentParam().getMeta();
            if (meta == null) {
                meta = new HashMap<>();
            }
            appName = rootTaskData.getGuiAgentParam().getAppName();
        } else {
            task = rootTaskData.getTask();
            meta = rootTaskData.getMeta();
            if (meta == null) {
                meta = new HashMap<>();
            }
            appName = rootTaskData.getAppName();
        }
        GuiAgentParam guiAgentParam = rootTaskData.getGuiAgentParam();
        if (guiAgentParam == null || (guiModelName = guiAgentParam.getGuiModelName()) == null) {
            guiModelName = rootTaskData.getGuiModelName();
        }
        String str = null;
        if (guiModelName == null || j9.m.s0(guiModelName)) {
            guiModelName = null;
        }
        GuiAgentParam guiAgentParam2 = rootTaskData.getGuiAgentParam();
        if (guiAgentParam2 == null || (taskSource = guiAgentParam2.getTaskSource()) == null) {
            taskSource = rootTaskData.getTaskSource();
        }
        if (taskSource == null || j9.m.s0(taskSource)) {
            taskSource = null;
        }
        if (taskSource != null) {
            meta.put("task_source", taskSource);
        }
        GuiAgentParam guiAgentParam3 = rootTaskData.getGuiAgentParam();
        if (guiAgentParam3 == null || (msgSource = guiAgentParam3.getMsgSource()) == null) {
            msgSource = rootTaskData.getMsgSource();
        }
        if (msgSource != null && !j9.m.s0(msgSource)) {
            str = msgSource;
        }
        if (str != null) {
            meta.put("msg_source", str);
        }
        if (traceId != null) {
            meta.put(Key.KEY_TRACE_ID, traceId);
        }
        if (toolCallId != null) {
            meta.put(GuiAgentConfigKt.META_KEY_TOOL_CALL_ID, toolCallId);
        }
        meta.put("app_package_name", appPackageName);
        return new ParsedStartParams(task, meta, appName, guiModelName);
    }
}
