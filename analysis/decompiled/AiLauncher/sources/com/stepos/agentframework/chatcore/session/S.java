package com.stepos.agentframework.chatcore.session;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.stepos.agentframework.chatcore.intent.AgentTool;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/stepos/agentframework/chatcore/session/S;", "", "<init>", "()V", "", "Lcom/stepos/agentframework/chatcore/intent/e;", "tools", "", Const.INTENT_KEY_UMID, "(Ljava/util/List;)Ljava/util/List;", "tool", "c", "(Lcom/stepos/agentframework/chatcore/intent/e;)Ljava/lang/String;", "result", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Ljava/lang/String;", "", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/agentframework/chatcore/intent/e;)Z", "Lcom/google/gson/JsonElement;", "element", "e", "(Lcom/google/gson/JsonElement;)Ljava/lang/String;", "TOOL_NAME_CRON", "Ljava/lang/String;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class S {
    public static final S INSTANCE = new S();
    private static final String TOOL_NAME_CRON = "cron";

    public final boolean a(AgentTool tool) {
        String string = La.H.D1(tool.getName()).toString();
        String apiName = tool.getApiName();
        String string2 = apiName != null ? La.H.D1(apiName).toString() : null;
        if (string2 == null) {
            string2 = "";
        }
        return La.D.L(string, TOOL_NAME_CRON, true) || La.D.L(string2, TOOL_NAME_CRON, true);
    }

    public final String b(String result) {
        Object objB;
        String string = result != null ? La.H.D1(result).toString() : null;
        if (string == null) {
            string = "";
        }
        if (string.length() == 0 || string.charAt(0) != '{') {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(JsonParser.parseString(string).getAsJsonObject());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        JsonObject jsonObject = (JsonObject) objB;
        if (jsonObject == null) {
            return null;
        }
        JsonObject asJsonObject = jsonObject.getAsJsonObject("job");
        String strE = e(asJsonObject != null ? asJsonObject.get("id") : null);
        if (strE != null) {
            return strE;
        }
        JsonObject asJsonObject2 = jsonObject.getAsJsonObject("existing");
        String strE2 = e(asJsonObject2 != null ? asJsonObject2.get("id") : null);
        if (strE2 != null) {
            return strE2;
        }
        return null;
    }

    public final String c(AgentTool tool) {
        kotlin.jvm.internal.p.i(tool, "tool");
        if (a(tool)) {
            return b(tool.getResult());
        }
        return null;
    }

    public final List<String> d(List<AgentTool> tools) {
        kotlin.jvm.internal.p.i(tools, "tools");
        if (tools.isEmpty()) {
            return C1173v.m();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<AgentTool> it = tools.iterator();
        while (it.hasNext()) {
            String strC = c(it.next());
            if (strC != null) {
                linkedHashSet.add(strC);
            }
        }
        return Z8.F.m1(linkedHashSet);
    }

    public final String e(JsonElement element) {
        Object objB;
        if (element == null || element.isJsonNull() || !element.isJsonPrimitive()) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            String asString = element.getAsJsonPrimitive().getAsString();
            kotlin.jvm.internal.p.h(asString, "getAsString(...)");
            objB = Result.b(La.H.D1(asString).toString());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        String str = (String) objB;
        if (str != null && str.length() > 0) {
            return str;
        }
        return null;
    }
}
