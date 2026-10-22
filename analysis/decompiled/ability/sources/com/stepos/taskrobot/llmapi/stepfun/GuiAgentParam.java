package com.stepos.taskrobot.llmapi.stepfun;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import kotlin.Metadata;
import stepai.aios.guiagent.config.GuiAgentConfigKt;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012&\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J)\u0010\u0016\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jk\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032(\b\u0002\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR1\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000e¨\u0006\""}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/GuiAgentParam;", "", "appName", "", "meta", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "task", "guiModelName", "taskSource", "msgSource", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppName", "()Ljava/lang/String;", "getMeta", "()Ljava/util/HashMap;", "getTask", "getGuiModelName", "getTaskSource", "getMsgSource", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class GuiAgentParam {

    @SerializedName(GuiAgentConfigKt.META_KEY_APP_NAME)
    private final String appName;

    @SerializedName("gui_model_name")
    private final String guiModelName;
    private final HashMap<String, Object> meta;

    @SerializedName("msg_source")
    private final String msgSource;
    private final String task;

    @SerializedName("task_source")
    private final String taskSource;

    public GuiAgentParam(String appName, HashMap<String, Object> map, String task, String str, String str2, String str3) {
        kotlin.jvm.internal.k.f(appName, "appName");
        kotlin.jvm.internal.k.f(task, "task");
        this.appName = appName;
        this.meta = map;
        this.task = task;
        this.guiModelName = str;
        this.taskSource = str2;
        this.msgSource = str3;
    }

    public static /* synthetic */ GuiAgentParam copy$default(GuiAgentParam guiAgentParam, String str, HashMap map, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = guiAgentParam.appName;
        }
        if ((i & 2) != 0) {
            map = guiAgentParam.meta;
        }
        if ((i & 4) != 0) {
            str2 = guiAgentParam.task;
        }
        if ((i & 8) != 0) {
            str3 = guiAgentParam.guiModelName;
        }
        if ((i & 16) != 0) {
            str4 = guiAgentParam.taskSource;
        }
        if ((i & 32) != 0) {
            str5 = guiAgentParam.msgSource;
        }
        String str6 = str4;
        String str7 = str5;
        return guiAgentParam.copy(str, map, str2, str3, str6, str7);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAppName() {
        return this.appName;
    }

    public final HashMap<String, Object> component2() {
        return this.meta;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTask() {
        return this.task;
    }

    /* renamed from: component4, reason: from getter */
    public final String getGuiModelName() {
        return this.guiModelName;
    }

    /* renamed from: component5, reason: from getter */
    public final String getTaskSource() {
        return this.taskSource;
    }

    /* renamed from: component6, reason: from getter */
    public final String getMsgSource() {
        return this.msgSource;
    }

    public final GuiAgentParam copy(String appName, HashMap<String, Object> meta, String task, String guiModelName, String taskSource, String msgSource) {
        kotlin.jvm.internal.k.f(appName, "appName");
        kotlin.jvm.internal.k.f(task, "task");
        return new GuiAgentParam(appName, meta, task, guiModelName, taskSource, msgSource);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuiAgentParam)) {
            return false;
        }
        GuiAgentParam guiAgentParam = (GuiAgentParam) other;
        return kotlin.jvm.internal.k.b(this.appName, guiAgentParam.appName) && kotlin.jvm.internal.k.b(this.meta, guiAgentParam.meta) && kotlin.jvm.internal.k.b(this.task, guiAgentParam.task) && kotlin.jvm.internal.k.b(this.guiModelName, guiAgentParam.guiModelName) && kotlin.jvm.internal.k.b(this.taskSource, guiAgentParam.taskSource) && kotlin.jvm.internal.k.b(this.msgSource, guiAgentParam.msgSource);
    }

    public final String getAppName() {
        return this.appName;
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
        int iHashCode = this.appName.hashCode() * 31;
        HashMap<String, Object> map = this.meta;
        int iC = B7.a.c((iHashCode + (map == null ? 0 : map.hashCode())) * 31, 31, this.task);
        String str = this.guiModelName;
        int iHashCode2 = (iC + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.taskSource;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.msgSource;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        String str = this.appName;
        HashMap<String, Object> map = this.meta;
        String str2 = this.task;
        String str3 = this.guiModelName;
        String str4 = this.taskSource;
        String str5 = this.msgSource;
        StringBuilder sb = new StringBuilder("GuiAgentParam(appName=");
        sb.append(str);
        sb.append(", meta=");
        sb.append(map);
        sb.append(", task=");
        androidx.constraintlayout.core.dsl.a.A(sb, str2, ", guiModelName=", str3, ", taskSource=");
        return androidx.appfunctions.metadata.a.p(sb, str4, ", msgSource=", str5, ")");
    }

    public /* synthetic */ GuiAgentParam(String str, HashMap map, String str2, String str3, String str4, String str5, int i, kotlin.jvm.internal.e eVar) {
        this(str, map, str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5);
    }
}
