package com.stepos.taskrobot.llmapi.stepfun;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import kotlin.Metadata;
import stepai.aios.guiagent.config.GuiAgentConfigKt;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bm\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012&\u0010\u0007\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\bj\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J)\u0010\u001c\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\bj\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\tHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jw\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052(\b\u0002\u0010\u0007\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\bj\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R6\u0010\u0007\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\bj\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012¨\u0006'"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/RootTaskData;", "", "guiAgentParam", "Lcom/stepos/taskrobot/llmapi/stepfun/GuiAgentParam;", "appName", "", "task", "meta", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "guiModelName", "taskSource", "msgSource", AppAgent.CONSTRUCT, "(Lcom/stepos/taskrobot/llmapi/stepfun/GuiAgentParam;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getGuiAgentParam", "()Lcom/stepos/taskrobot/llmapi/stepfun/GuiAgentParam;", "getAppName", "()Ljava/lang/String;", "getTask", "getMeta", "()Ljava/util/HashMap;", "getGuiModelName", "getTaskSource", "getMsgSource", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class RootTaskData {

    @SerializedName(GuiAgentConfigKt.META_KEY_APP_NAME)
    private final String appName;

    @SerializedName("gui_agent_param")
    private final GuiAgentParam guiAgentParam;

    @SerializedName("gui_model_name")
    private final String guiModelName;

    @SerializedName("meta")
    private final HashMap<String, Object> meta;

    @SerializedName("msg_source")
    private final String msgSource;

    @SerializedName("task")
    private final String task;

    @SerializedName("task_source")
    private final String taskSource;

    public RootTaskData(GuiAgentParam guiAgentParam, String appName, String task, HashMap<String, Object> map, String str, String str2, String str3) {
        kotlin.jvm.internal.k.f(appName, "appName");
        kotlin.jvm.internal.k.f(task, "task");
        this.guiAgentParam = guiAgentParam;
        this.appName = appName;
        this.task = task;
        this.meta = map;
        this.guiModelName = str;
        this.taskSource = str2;
        this.msgSource = str3;
    }

    public static /* synthetic */ RootTaskData copy$default(RootTaskData rootTaskData, GuiAgentParam guiAgentParam, String str, String str2, HashMap map, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            guiAgentParam = rootTaskData.guiAgentParam;
        }
        if ((i & 2) != 0) {
            str = rootTaskData.appName;
        }
        if ((i & 4) != 0) {
            str2 = rootTaskData.task;
        }
        if ((i & 8) != 0) {
            map = rootTaskData.meta;
        }
        if ((i & 16) != 0) {
            str3 = rootTaskData.guiModelName;
        }
        if ((i & 32) != 0) {
            str4 = rootTaskData.taskSource;
        }
        if ((i & 64) != 0) {
            str5 = rootTaskData.msgSource;
        }
        String str6 = str4;
        String str7 = str5;
        String str8 = str3;
        String str9 = str2;
        return rootTaskData.copy(guiAgentParam, str, str9, map, str8, str6, str7);
    }

    /* renamed from: component1, reason: from getter */
    public final GuiAgentParam getGuiAgentParam() {
        return this.guiAgentParam;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAppName() {
        return this.appName;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTask() {
        return this.task;
    }

    public final HashMap<String, Object> component4() {
        return this.meta;
    }

    /* renamed from: component5, reason: from getter */
    public final String getGuiModelName() {
        return this.guiModelName;
    }

    /* renamed from: component6, reason: from getter */
    public final String getTaskSource() {
        return this.taskSource;
    }

    /* renamed from: component7, reason: from getter */
    public final String getMsgSource() {
        return this.msgSource;
    }

    public final RootTaskData copy(GuiAgentParam guiAgentParam, String appName, String task, HashMap<String, Object> meta, String guiModelName, String taskSource, String msgSource) {
        kotlin.jvm.internal.k.f(appName, "appName");
        kotlin.jvm.internal.k.f(task, "task");
        return new RootTaskData(guiAgentParam, appName, task, meta, guiModelName, taskSource, msgSource);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RootTaskData)) {
            return false;
        }
        RootTaskData rootTaskData = (RootTaskData) other;
        return kotlin.jvm.internal.k.b(this.guiAgentParam, rootTaskData.guiAgentParam) && kotlin.jvm.internal.k.b(this.appName, rootTaskData.appName) && kotlin.jvm.internal.k.b(this.task, rootTaskData.task) && kotlin.jvm.internal.k.b(this.meta, rootTaskData.meta) && kotlin.jvm.internal.k.b(this.guiModelName, rootTaskData.guiModelName) && kotlin.jvm.internal.k.b(this.taskSource, rootTaskData.taskSource) && kotlin.jvm.internal.k.b(this.msgSource, rootTaskData.msgSource);
    }

    public final String getAppName() {
        return this.appName;
    }

    public final GuiAgentParam getGuiAgentParam() {
        return this.guiAgentParam;
    }

    public final String getGuiModelName() {
        return this.guiModelName;
    }

    public final HashMap<String, Object> getMeta() {
        return this.meta;
    }

    public final String getMsgSource() {
        return this.msgSource;
    }

    public final String getTask() {
        return this.task;
    }

    public final String getTaskSource() {
        return this.taskSource;
    }

    public int hashCode() {
        GuiAgentParam guiAgentParam = this.guiAgentParam;
        int iC = B7.a.c(B7.a.c((guiAgentParam == null ? 0 : guiAgentParam.hashCode()) * 31, 31, this.appName), 31, this.task);
        HashMap<String, Object> map = this.meta;
        int iHashCode = (iC + (map == null ? 0 : map.hashCode())) * 31;
        String str = this.guiModelName;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.taskSource;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.msgSource;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        GuiAgentParam guiAgentParam = this.guiAgentParam;
        String str = this.appName;
        String str2 = this.task;
        HashMap<String, Object> map = this.meta;
        String str3 = this.guiModelName;
        String str4 = this.taskSource;
        String str5 = this.msgSource;
        StringBuilder sb = new StringBuilder("RootTaskData(guiAgentParam=");
        sb.append(guiAgentParam);
        sb.append(", appName=");
        sb.append(str);
        sb.append(", task=");
        sb.append(str2);
        sb.append(", meta=");
        sb.append(map);
        sb.append(", guiModelName=");
        androidx.constraintlayout.core.dsl.a.A(sb, str3, ", taskSource=", str4, ", msgSource=");
        return B7.a.q(sb, str5, ")");
    }

    public /* synthetic */ RootTaskData(GuiAgentParam guiAgentParam, String str, String str2, HashMap map, String str3, String str4, String str5, int i, kotlin.jvm.internal.e eVar) {
        this(guiAgentParam, str, str2, map, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : str5);
    }
}
