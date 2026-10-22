package kotlin;

import La.H;
import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0004\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0013\u0010\u0007\u001a\u00020\u0006*\u00020\u0000H\u0002¢\u0006\u0004\b\u0007\u0010\b\"\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"LK6/d;", "", "requestId", "behavior", Const.INTENT_KEY_PKGNAME, "(LK6/d;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Lcom/google/gson/JsonElement;", Const.INTENT_KEY_APIKEY, "(LK6/d;)Lcom/google/gson/JsonElement;", "Lcom/google/gson/Gson;", "askUserQuestionGson", "Lcom/google/gson/Gson;", "common_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: K6.g, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0911g {
    private static final Gson askUserQuestionGson = new Gson();

    public static final JsonElement a(AskUserConversation askUserConversation) {
        Object objB;
        String questionsJson = askUserConversation.getQuestionsJson();
        if (questionsJson != null) {
            if (H.x0(questionsJson)) {
                questionsJson = null;
            }
            if (questionsJson != null) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    objB = Result.b(JsonParser.parseString(questionsJson));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th));
                }
                JsonElement jsonElement = (JsonElement) (Result.g(objB) ? null : objB);
                if (jsonElement != null) {
                    return jsonElement;
                }
            }
        }
        JsonElement jsonTree = askUserQuestionGson.toJsonTree(askUserConversation.b());
        p.h(jsonTree, "toJsonTree(...)");
        return jsonTree;
    }

    public static final String b(AskUserConversation askUserConversation, String requestId, String behavior) {
        p.i(askUserConversation, "<this>");
        p.i(requestId, "requestId");
        p.i(behavior, "behavior");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("type", "control_response");
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("subtype", "success");
        jsonObject2.addProperty("request_id", H.D1(requestId).toString());
        JsonObject jsonObject3 = new JsonObject();
        jsonObject3.addProperty("behavior", behavior);
        if (p.d(behavior, "deny")) {
            jsonObject3.addProperty("message", "User declined to answer questions.");
        } else {
            JsonObject jsonObject4 = new JsonObject();
            jsonObject4.add("questions", a(askUserConversation));
            jsonObject4.add("answers", askUserQuestionGson.toJsonTree(askUserConversation.a()));
            t tVar = t.f7040a;
            jsonObject3.add("updatedInput", jsonObject4);
        }
        t tVar2 = t.f7040a;
        jsonObject2.add(UxipConstants.f30685x, jsonObject3);
        jsonObject.add(UxipConstants.f30685x, jsonObject2);
        String json = askUserQuestionGson.toJson((JsonElement) jsonObject);
        p.h(json, "toJson(...)");
        return json;
    }
}
