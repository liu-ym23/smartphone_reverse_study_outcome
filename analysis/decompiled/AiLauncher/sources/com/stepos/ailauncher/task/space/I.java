package com.stepos.ailauncher.task.space;

import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.stepos.agentframework.chatcore.intent.AgentTool;
import com.stepos.agentframework.chatcore.session.RobotArguments;
import com.stepos.agentframework.chatcore.session.bean.AppUIData;
import com.stepos.agentframework.chatcore.utils.ExtKt;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import r4.C5218a;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ!\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/stepos/ailauncher/task/space/I;", "", "<init>", "()V", "Lcom/stepos/agentframework/chatcore/intent/e;", "tool", "", "cardTaskId", "Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;", "f", "(Lcom/stepos/agentframework/chatcore/intent/e;Ljava/lang/String;)Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;", "robotTaskId", "parameter", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lcom/stepos/agentframework/chatcore/intent/e;Ljava/lang/String;)Ljava/lang/String;", "", "c", "(Lcom/stepos/agentframework/chatcore/intent/e;)Z", "e", "(Ljava/lang/String;)Ljava/lang/String;", Const.INTENT_KEY_UMID, "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "", "ROBOT_ARGS_PIP_TYPE", "I", "EXEC_WRAPPER_DISPLAY_NAME", "Ljava/lang/String;", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class I {
    private static final String EXEC_WRAPPER_DISPLAY_NAME = "正在执行终端命令「ability-cli」";
    public static final I INSTANCE = new I();
    private static final int ROBOT_ARGS_PIP_TYPE = 0;

    public static /* synthetic */ AppUIData b(I i10, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = null;
        }
        return i10.a(str, str2);
    }

    public static /* synthetic */ AppUIData g(I i10, AgentTool agentTool, String str, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = null;
        }
        return i10.f(agentTool, str);
    }

    public static /* synthetic */ String i(I i10, AgentTool agentTool, String str, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = null;
        }
        return i10.h(agentTool, str);
    }

    public final AppUIData a(String robotTaskId, String parameter) {
        kotlin.jvm.internal.p.i(robotTaskId, "robotTaskId");
        String strD = d(robotTaskId, parameter);
        int iC = AppUIData.INSTANCE.c();
        String json = ExtKt.l().toJson(new RobotArguments(strD, 0, null, 4, null));
        kotlin.jvm.internal.p.h(json, "toJson(...)");
        return new AppUIData(null, iC, null, false, "task_robot_running", null, null, json, null, null, null, null, null, C5218a.INSTANCE.a(), false, false, 57197, null);
    }

    public final boolean c(AgentTool tool) {
        Object objB;
        JsonObject asJsonObject;
        JsonElement jsonElement;
        String asString;
        kotlin.jvm.internal.p.i(tool, "tool");
        boolean z10 = true;
        if (kotlin.jvm.internal.p.d(tool.getToolId(), "0") || kotlin.jvm.internal.p.d(tool.getName(), "gui_agent") || kotlin.jvm.internal.p.d(tool.getApiName(), "gui_agent")) {
            return true;
        }
        String parameter = tool.getParameter();
        if (parameter == null || La.H.x0(parameter)) {
            return false;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            JsonElement string = JsonParser.parseString(parameter);
            if (!string.isJsonObject()) {
                string = null;
            }
            if (string == null || (asJsonObject = string.getAsJsonObject()) == null || (jsonElement = asJsonObject.get("command")) == null || (asString = jsonElement.getAsString()) == null || !La.H.g0(asString, "--tool-name", false, 2, null) || !La.H.e0(asString, "gui_agent", true)) {
                z10 = false;
            }
            objB = Result.b(Boolean.valueOf(z10));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        return ((Boolean) objB).booleanValue();
    }

    public final String d(String robotTaskId, String parameter) {
        Object objB;
        if (parameter == null || La.H.x0(parameter)) {
            return "{\"ai_launcher_task_id\":\"" + robotTaskId + "\"}";
        }
        if (e(parameter) != null) {
            return parameter;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            JsonObject asJsonObject = JsonParser.parseString(parameter).getAsJsonObject();
            asJsonObject.addProperty("ai_launcher_task_id", robotTaskId);
            objB = Result.b(asJsonObject.toString());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        String str = "{\"ai_launcher_task_id\":\"" + robotTaskId + "\"}";
        if (Result.g(objB)) {
            objB = str;
        }
        return (String) objB;
    }

    public final String e(String parameter) {
        Object objB;
        JsonElement string;
        String string2;
        String asString;
        if (parameter == null || La.H.x0(parameter)) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            string = JsonParser.parseString(parameter);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (!string.isJsonObject()) {
            return null;
        }
        JsonElement jsonElement = string.getAsJsonObject().get("ai_launcher_task_id");
        if (jsonElement == null || (asString = jsonElement.getAsString()) == null || (string2 = La.H.D1(asString).toString()) == null || string2.length() <= 0) {
            string2 = null;
        }
        objB = Result.b(string2);
        return (String) (Result.g(objB) ? null : objB);
    }

    public final AppUIData f(AgentTool tool, String cardTaskId) {
        kotlin.jvm.internal.p.i(tool, "tool");
        AppUIData appUIData = tool.getAppUIData();
        if (appUIData != null && appUIData.getUiType() == AppUIData.INSTANCE.c()) {
            return tool.getAppUIData();
        }
        if (c(tool)) {
            return a(h(tool, cardTaskId), tool.getParameter());
        }
        return null;
    }

    public final String h(AgentTool tool, String cardTaskId) {
        kotlin.jvm.internal.p.i(tool, "tool");
        String strE = e(tool.getParameter());
        if (strE != null) {
            return strE;
        }
        if (cardTaskId != null) {
            if (La.H.x0(cardTaskId)) {
                cardTaskId = null;
            }
            if (cardTaskId != null) {
                return cardTaskId;
            }
        }
        return tool.getToolCallId();
    }
}
