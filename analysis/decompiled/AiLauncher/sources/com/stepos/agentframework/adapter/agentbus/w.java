package com.stepos.agentframework.adapter.agentbus;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.AskUserOption;
import kotlin.AskUserQuestion;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u0013\u0010\u000eJ%\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00142\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0019\u001a\u00020\u0004*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u0004*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001b\u0010\u001aJ\u001b\u0010\u001d\u001a\u00020\u001c*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/stepos/agentframework/adapter/agentbus/w;", "", "<init>", "()V", "", "argumentsJson", "LK6/d;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)LK6/d;", "Lcom/google/gson/JsonElement;", "element", "", "LK6/f;", "e", "(Lcom/google/gson/JsonElement;)Ljava/util/List;", "Lcom/google/gson/JsonArray;", "f", "(Lcom/google/gson/JsonElement;)Lcom/google/gson/JsonArray;", "LK6/e;", Const.INTENT_KEY_UMID, "", "c", "(Lcom/google/gson/JsonElement;)Ljava/util/Map;", "Lcom/google/gson/JsonObject;", "key", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "", Const.INTENT_KEY_APIKEY, "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Z", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lcom/google/gson/JsonElement;)Ljava/lang/String;", "TAG", "Ljava/lang/String;", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class w {
    public static final w INSTANCE = new w();
    private static final String TAG = "AskUserQuestionMapper";

    public final boolean a(JsonObject jsonObject, String str) {
        Object objB;
        JsonElement jsonElement = jsonObject.get(str);
        if (jsonElement == null || jsonElement.isJsonNull() || !jsonElement.isJsonPrimitive()) {
            return false;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Boolean.valueOf(jsonElement.getAsBoolean()));
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

    /* JADX WARN: Removed duplicated region for block: B:29:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final kotlin.AskUserConversation b(java.lang.String r8) {
        /*
            r7 = this;
            r0 = 0
            if (r8 == 0) goto Lbc
            boolean r1 = La.H.x0(r8)
            if (r1 == 0) goto Lb
            goto Lbc
        Lb:
            kotlin.Result$a r1 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L2c
            com.google.gson.JsonElement r1 = com.google.gson.JsonParser.parseString(r8)     // Catch: java.lang.Throwable -> L2c
            boolean r2 = r1.isJsonArray()     // Catch: java.lang.Throwable -> L2c
            if (r2 == 0) goto L2e
            kotlin.jvm.internal.p.f(r1)     // Catch: java.lang.Throwable -> L2c
            java.util.List r7 = r7.e(r1)     // Catch: java.lang.Throwable -> L2c
            K6.d r2 = new K6.d     // Catch: java.lang.Throwable -> L2c
            java.util.Map r3 = kotlin.collections.a.i()     // Catch: java.lang.Throwable -> L2c
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L2c
            r2.<init>(r7, r3, r1)     // Catch: java.lang.Throwable -> L2c
            goto L65
        L2c:
            r7 = move-exception
            goto L6a
        L2e:
            boolean r2 = r1.isJsonObject()     // Catch: java.lang.Throwable -> L2c
            if (r2 == 0) goto L64
            com.google.gson.JsonObject r1 = r1.getAsJsonObject()     // Catch: java.lang.Throwable -> L2c
            java.lang.String r2 = "questions"
            com.google.gson.JsonElement r2 = r1.get(r2)     // Catch: java.lang.Throwable -> L2c
            if (r2 == 0) goto L64
            boolean r3 = r2.isJsonNull()     // Catch: java.lang.Throwable -> L2c
            if (r3 != 0) goto L47
            goto L48
        L47:
            r2 = r0
        L48:
            if (r2 != 0) goto L4b
            goto L64
        L4b:
            java.util.List r3 = r7.e(r2)     // Catch: java.lang.Throwable -> L2c
            java.lang.String r4 = "answers"
            com.google.gson.JsonElement r1 = r1.get(r4)     // Catch: java.lang.Throwable -> L2c
            java.util.Map r1 = r7.c(r1)     // Catch: java.lang.Throwable -> L2c
            K6.d r4 = new K6.d     // Catch: java.lang.Throwable -> L2c
            java.lang.String r7 = r7.g(r2)     // Catch: java.lang.Throwable -> L2c
            r4.<init>(r3, r1, r7)     // Catch: java.lang.Throwable -> L2c
            r2 = r4
            goto L65
        L64:
            r2 = r0
        L65:
            java.lang.Object r7 = kotlin.Result.b(r2)     // Catch: java.lang.Throwable -> L2c
            goto L74
        L6a:
            kotlin.Result$a r1 = kotlin.Result.INSTANCE
            java.lang.Object r7 = kotlin.C4849c.a(r7)
            java.lang.Object r7 = kotlin.Result.b(r7)
        L74:
            java.lang.Throwable r1 = kotlin.Result.e(r7)
            r2 = 4
            r3 = 0
            java.lang.String r4 = "AskUserQuestionMapper"
            if (r1 == 0) goto L9e
            java.lang.String r1 = r1.getMessage()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "parse failed: "
            r5.append(r6)
            r5.append(r1)
            java.lang.String r1 = " raw="
            r5.append(r1)
            r5.append(r8)
            java.lang.String r8 = r5.toString()
            h8.C4148a.u(r4, r8, r3, r2, r0)
        L9e:
            boolean r8 = kotlin.Result.g(r7)
            if (r8 == 0) goto La5
            r7 = r0
        La5:
            K6.d r7 = (kotlin.AskUserConversation) r7
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r1 = "parse: "
            r8.append(r1)
            r8.append(r7)
            java.lang.String r8 = r8.toString()
            h8.C4148a.d(r4, r8, r3, r2, r0)
            return r7
        Lbc:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.adapter.agentbus.w.b(java.lang.String):K6.d");
    }

    public final Map<String, String> c(JsonElement element) {
        Object objB;
        JsonObject asJsonObject;
        if (element == null || element.isJsonNull()) {
            return kotlin.collections.a.i();
        }
        if (element.isJsonObject()) {
            asJsonObject = element.getAsJsonObject();
        } else if (element.isJsonPrimitive()) {
            try {
                Result.Companion companion = Result.INSTANCE;
                JsonElement string = JsonParser.parseString(element.getAsString());
                if (!string.isJsonObject()) {
                    string = null;
                }
                objB = Result.b(string != null ? string.getAsJsonObject() : null);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            asJsonObject = (JsonObject) (Result.g(objB) ? null : objB);
        } else {
            asJsonObject = null;
        }
        if (asJsonObject == null) {
            return kotlin.collections.a.i();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, JsonElement> entry : asJsonObject.entrySet()) {
            kotlin.jvm.internal.p.f(entry);
            String key = entry.getKey();
            JsonElement value = entry.getValue();
            if (value != null && !value.isJsonNull() && value.isJsonPrimitive()) {
                linkedHashMap.put(key, value.getAsString());
            }
        }
        return linkedHashMap;
    }

    public final List<AskUserOption> d(JsonElement element) {
        if (element == null || element.isJsonNull() || !element.isJsonArray()) {
            return C1173v.m();
        }
        JsonArray asJsonArray = element.getAsJsonArray();
        kotlin.jvm.internal.p.h(asJsonArray, "getAsJsonArray(...)");
        ArrayList arrayList = new ArrayList();
        for (JsonElement jsonElement : asJsonArray) {
            AskUserOption askUserOption = null;
            if (jsonElement.isJsonObject()) {
                JsonObject asJsonObject = jsonElement.getAsJsonObject();
                w wVar = INSTANCE;
                kotlin.jvm.internal.p.f(asJsonObject);
                String strH = wVar.h(asJsonObject, "label");
                if (strH.length() != 0) {
                    askUserOption = new AskUserOption(strH, wVar.i(asJsonObject, "description"));
                }
            }
            if (askUserOption != null) {
                arrayList.add(askUserOption);
            }
        }
        return arrayList;
    }

    public final List<AskUserQuestion> e(JsonElement element) {
        AskUserQuestion askUserQuestion;
        JsonArray jsonArrayF = f(element);
        if (jsonArrayF == null) {
            return C1173v.m();
        }
        ArrayList arrayList = new ArrayList();
        for (JsonElement jsonElement : jsonArrayF) {
            if (jsonElement.isJsonObject()) {
                JsonObject asJsonObject = jsonElement.getAsJsonObject();
                w wVar = INSTANCE;
                kotlin.jvm.internal.p.f(asJsonObject);
                askUserQuestion = new AskUserQuestion(wVar.h(asJsonObject, "question"), wVar.h(asJsonObject, "header"), wVar.a(asJsonObject, "multiSelect"), wVar.d(asJsonObject.get("options")));
            } else {
                askUserQuestion = null;
            }
            if (askUserQuestion != null) {
                arrayList.add(askUserQuestion);
            }
        }
        return arrayList;
    }

    public final JsonArray f(JsonElement element) {
        Object objB;
        if (element.isJsonArray()) {
            return element.getAsJsonArray();
        }
        if (!element.isJsonPrimitive()) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            JsonElement string = JsonParser.parseString(element.getAsString());
            if (!string.isJsonArray()) {
                string = null;
            }
            objB = Result.b(string != null ? string.getAsJsonArray() : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        return (JsonArray) (Result.g(objB) ? null : objB);
    }

    public final String g(JsonElement element) {
        String string;
        String str;
        if (element.isJsonPrimitive()) {
            string = element.getAsString();
            str = "getAsString(...)";
        } else {
            string = element.toString();
            str = "toString(...)";
        }
        kotlin.jvm.internal.p.h(string, str);
        return string;
    }

    public final String h(JsonObject jsonObject, String str) {
        String strI = i(jsonObject, str);
        return strI == null ? "" : strI;
    }

    public final String i(JsonObject jsonObject, String str) {
        JsonElement jsonElement = jsonObject.get(str);
        if (jsonElement == null || jsonElement.isJsonNull() || !jsonElement.isJsonPrimitive()) {
            return null;
        }
        return jsonElement.getAsString();
    }
}
