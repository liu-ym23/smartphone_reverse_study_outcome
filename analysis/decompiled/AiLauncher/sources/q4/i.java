package q4;

import Ka.t;
import La.D;
import La.H;
import Z8.C1174w;
import Z8.Q;
import Z8.Y;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.stepos.agentframework.chatcore.session.ChatCoreSdk;
import com.stepos.agentframework.chatcore.session.bean.AppUIData;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import com.zyql.ai.selector.config.PictureMimeType;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.json.JSONObject;
import p9.InterfaceC5074l;
import u4.m;
import u6.C5578a;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\"\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\t\u0010\nJ/\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000b\u0010\nJ/\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0012\u0010\u0011J/\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0013\u0010\nJ\u0017\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0016\u0010\u0017J3\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00192\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001a\u0010\u001bJ/\u0010\u001d\u001a\u0004\u0018\u00010\b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u001c\u001a\u00020\u0004¢\u0006\u0004\b\u001d\u0010\nJ\u0017\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001f\u0010 J!\u0010!\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b!\u0010\u0011J!\u0010\"\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\"\u0010\u0011J\u0015\u0010#\u001a\u00020\u000f*\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b#\u0010\u0015J\u0019\u0010$\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b$\u0010%J\u0013\u0010'\u001a\u00020\u000f*\u00020&H\u0002¢\u0006\u0004\b'\u0010(J\u0013\u0010*\u001a\u00020\u000f*\u00020)H\u0002¢\u0006\u0004\b*\u0010+J)\u0010.\u001a\u0004\u0018\u00010\u0004*\u00020)2\u0012\u0010-\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040,\"\u00020\u0004H\u0002¢\u0006\u0004\b.\u0010/J\u0019\u00101\u001a\u0004\u0018\u00010\u00042\u0006\u00100\u001a\u00020&H\u0002¢\u0006\u0004\b1\u00102J-\u00104\u001a\u00020\b2\u0014\u00103\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00192\u0006\u0010\u001c\u001a\u00020\u0004H\u0002¢\u0006\u0004\b4\u00105J!\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0019*\u00020\fH\u0002¢\u0006\u0004\b6\u00107J\u0017\u0010:\u001a\u00020\u000f2\u0006\u00109\u001a\u000208H\u0002¢\u0006\u0004\b:\u0010;J\u0019\u0010<\u001a\u00020\u000f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b<\u0010\u0015J\u0019\u0010=\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b=\u0010%J\u0019\u0010>\u001a\u0004\u0018\u00010\f2\u0006\u00100\u001a\u00020)H\u0002¢\u0006\u0004\b>\u0010?J\u0019\u0010@\u001a\u0004\u0018\u00010\f2\u0006\u00100\u001a\u00020&H\u0002¢\u0006\u0004\b@\u0010AR\u0014\u0010B\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010D\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bD\u0010CR\u0014\u0010E\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bE\u0010CR\u0014\u0010F\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bF\u0010CR\u0014\u0010G\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bG\u0010CR\u001a\u0010H\u001a\u00020\u00048\u0006X\u0087T¢\u0006\f\n\u0004\bH\u0010C\u0012\u0004\bI\u0010\u0003R\u001a\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00040J8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bK\u0010L¨\u0006M"}, d2 = {"Lq4/i;", "", "<init>", "()V", "", "toolName", "resultJson", "argsJson", "Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;", "C", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;", "D", "Lq4/f;", "q", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lq4/f;", "", "n", "(Ljava/lang/String;Ljava/lang/String;)Z", "l", ExifInterface.LONGITUDE_EAST, "m", "(Ljava/lang/String;)Z", "u", "(Ljava/lang/String;)Ljava/lang/String;", "fallbackTaskId", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;", "packageName", Const.INTENT_KEY_UMID, "payload", "c", "(Lq4/f;)Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;", "y", "x", "p", "v", "(Ljava/lang/String;)Lq4/f;", "Lorg/json/JSONObject;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lorg/json/JSONObject;)Z", "Lcom/google/gson/JsonObject;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lcom/google/gson/JsonObject;)Z", "", "keys", "w", "(Lcom/google/gson/JsonObject;[Ljava/lang/String;)Ljava/lang/String;", Parameters.ROOT, "z", "(Lorg/json/JSONObject;)Ljava/lang/String;", "structuredContent", "e", "(Ljava/util/Map;Ljava/lang/String;)Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;", "B", "(Lq4/f;)Ljava/util/Map;", "Lq4/e;", "item", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lq4/e;)Z", "o", "r", "t", "(Lcom/google/gson/JsonObject;)Lq4/f;", "s", "(Lorg/json/JSONObject;)Lq4/f;", "APP_UI_NAME", "Ljava/lang/String;", "TOOL_NAME_TASK_ARTIFACT", "TOOL_NAME_RESULT_SUBMIT", "TOOL_NAME_TEXT_TO_IMAGE", "KEY_ACTIVE_TOOL_CALL_IDS", "TOOL_NAME", "getTOOL_NAME$annotations", "", "IMAGE_EXTENSIONS", "Ljava/util/Set;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class i {
    public static final String APP_UI_NAME = "app_ui_name_task_result_file";
    public static final String KEY_ACTIVE_TOOL_CALL_IDS = "active_tool_call_ids";
    public static final String TOOL_NAME = "task_result_submit";
    public static final String TOOL_NAME_RESULT_SUBMIT = "task_result_submit";
    public static final String TOOL_NAME_TASK_ARTIFACT = "task_artifact";
    public static final String TOOL_NAME_TEXT_TO_IMAGE = "text_to_image";
    public static final i INSTANCE = new i();
    private static final Set<String> IMAGE_EXTENSIONS = Y.j("png", C5578a.DST_JPG, "jpeg", "gif", "webp", "bmp", "svg", "heic", "heif");

    public static /* synthetic */ AppUIData f(i iVar, String str, String str2, String str3, int i10, Object obj) {
        Object objB;
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        if ((i10 & 4) != 0) {
            try {
                Result.Companion companion = Result.INSTANCE;
                objB = Result.b(ChatCoreSdk.INSTANCE.c().getPackageName());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            if (Result.g(objB)) {
                objB = "";
            }
            str3 = (String) objB;
        }
        return iVar.d(str, str2, str3);
    }

    public static final String j(String it) {
        p.i(it, "it");
        return H.w1(H.w1(it, '?', null, 2, null), '#', null, 2, null);
    }

    public static final String k(String it) {
        p.i(it, "it");
        String lowerCase = H.q1(it, '.', "").toLowerCase(Locale.ROOT);
        p.h(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    public final Map<String, Object> A(String resultJson, String fallbackTaskId) {
        TaskResultFileAppUiPayload taskResultFileAppUiPayloadV = null;
        if (m(resultJson)) {
            if (fallbackTaskId != null) {
                if (H.x0(fallbackTaskId)) {
                    fallbackTaskId = null;
                }
                if (fallbackTaskId != null) {
                    return Q.f(Y8.j.a("task_id", fallbackTaskId));
                }
            }
            return null;
        }
        String strU = u(resultJson);
        if (strU == null) {
            if (fallbackTaskId != null) {
                if (H.x0(fallbackTaskId)) {
                    fallbackTaskId = null;
                }
                strU = fallbackTaskId;
            } else {
                strU = null;
            }
            if (strU == null) {
                return null;
            }
        }
        String str = strU;
        if (resultJson != null) {
            if (H.x0(resultJson)) {
                resultJson = null;
            }
            if (resultJson != null) {
                taskResultFileAppUiPayloadV = v(resultJson);
            }
        }
        TaskResultFileAppUiPayload taskResultFileAppUiPayload = taskResultFileAppUiPayloadV;
        return taskResultFileAppUiPayload != null ? B(TaskResultFileAppUiPayload.b(taskResultFileAppUiPayload, str, null, null, null, 14, null)) : Q.f(Y8.j.a("task_id", str));
    }

    public final Map<String, Object> B(TaskResultFileAppUiPayload taskResultFileAppUiPayload) {
        Map mapC = Q.c();
        mapC.put("task_id", taskResultFileAppUiPayload.getTaskId());
        mapC.put("version_id", taskResultFileAppUiPayload.getVersionId());
        List<TaskResultFileAppUiItem> listD = taskResultFileAppUiPayload.d();
        ArrayList arrayList = new ArrayList(C1174w.x(listD, 10));
        for (TaskResultFileAppUiItem taskResultFileAppUiItem : listD) {
            arrayList.add(kotlin.collections.a.m(Y8.j.a("fileId", taskResultFileAppUiItem.getFileId()), Y8.j.a("cloudPath", taskResultFileAppUiItem.getCloudPath()), Y8.j.a("fileName", taskResultFileAppUiItem.getFileName()), Y8.j.a("title", taskResultFileAppUiItem.getTitle()), Y8.j.a("mimeType", taskResultFileAppUiItem.getMimeType()), Y8.j.a(ContentDisposition.Parameters.Size, taskResultFileAppUiItem.getSize())));
        }
        mapC.put("artifacts", arrayList);
        if (!taskResultFileAppUiPayload.c().isEmpty()) {
            mapC.put(KEY_ACTIVE_TOOL_CALL_IDS, taskResultFileAppUiPayload.c());
        }
        return Q.b(mapC);
    }

    public final AppUIData C(String toolName, String resultJson, String argsJson) {
        TaskResultFileAppUiPayload taskResultFileAppUiPayloadR;
        Object objB;
        if (toolName == null || H.x0(toolName) || resultJson == null || H.x0(resultJson) || !y(toolName, argsJson) || (taskResultFileAppUiPayloadR = r(resultJson)) == null) {
            return null;
        }
        if (p.d(toolName, TOOL_NAME_TASK_ARTIFACT)) {
            String taskId = taskResultFileAppUiPayloadR.getTaskId();
            String str = (taskId == null || H.x0(taskId)) ? null : taskId;
            List<TaskResultFileAppUiItem> listD = taskResultFileAppUiPayloadR.d();
            ArrayList arrayList = new ArrayList();
            for (Object obj : listD) {
                if (i((TaskResultFileAppUiItem) obj)) {
                    arrayList.add(obj);
                }
            }
            if (str != null && arrayList.size() == taskResultFileAppUiPayloadR.d().size()) {
                return c(TaskResultFileAppUiPayload.b(taskResultFileAppUiPayloadR, str, null, null, null, 14, null));
            }
        }
        int iA = AppUIData.INSTANCE.a();
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(ChatCoreSdk.INSTANCE.c().getPackageName());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = "";
        }
        p.h(objB, "getOrDefault(...)");
        return new AppUIData(null, iA, null, false, "app_ui_name_task_result_file", null, null, B(taskResultFileAppUiPayloadR), null, null, (String) objB, null, null, null, true, false, 15205, null);
    }

    public final AppUIData D(String toolName, String resultJson, String argsJson) {
        TaskResultFileAppUiPayload taskResultFileAppUiPayloadR;
        String taskId;
        if (p.d(toolName, TOOL_NAME_TASK_ARTIFACT) && o(argsJson) && resultJson != null && (taskResultFileAppUiPayloadR = r(resultJson)) != null && (taskId = taskResultFileAppUiPayloadR.getTaskId()) != null) {
            String str = !H.x0(taskId) ? taskId : null;
            if (str != null) {
                List<TaskResultFileAppUiItem> listD = taskResultFileAppUiPayloadR.d();
                ArrayList arrayList = new ArrayList();
                for (Object obj : listD) {
                    if (i((TaskResultFileAppUiItem) obj)) {
                        arrayList.add(obj);
                    }
                }
                if (!arrayList.isEmpty() && arrayList.size() != taskResultFileAppUiPayloadR.d().size()) {
                    return c(TaskResultFileAppUiPayload.b(taskResultFileAppUiPayloadR, str, null, arrayList, null, 10, null));
                }
            }
        }
        return null;
    }

    public final AppUIData E(String toolName, String resultJson, String argsJson) {
        boolean zL = l(toolName, argsJson);
        boolean z10 = p.d(toolName, "tool") && p(resultJson);
        if (zL || z10) {
            return f(this, resultJson, null, null, 6, null);
        }
        return null;
    }

    public final AppUIData c(TaskResultFileAppUiPayload payload) {
        Object objB;
        Map<String, Object> mapB = B(payload);
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(ChatCoreSdk.INSTANCE.c().getPackageName());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = "";
        }
        p.h(objB, "getOrDefault(...)");
        return e(mapB, (String) objB);
    }

    public final AppUIData d(String resultJson, String fallbackTaskId, String packageName) {
        p.i(packageName, "packageName");
        Map<String, Object> mapA = A(resultJson, fallbackTaskId);
        if (mapA == null) {
            return null;
        }
        return e(mapA, packageName);
    }

    public final AppUIData e(Map<String, ? extends Object> structuredContent, String packageName) {
        return new AppUIData(null, AppUIData.INSTANCE.a(), null, false, m.TaskMessage.APP_UI_NAME_TEXT_TO_IMAGE, null, null, structuredContent, null, null, packageName, null, null, null, false, false, 64365, null);
    }

    public final boolean g(JsonObject jsonObject) {
        if (!jsonObject.has("ok")) {
            return false;
        }
        JsonElement jsonElement = jsonObject.get("ok");
        return jsonElement.isJsonPrimitive() && !jsonElement.getAsBoolean();
    }

    public final boolean h(JSONObject jSONObject) {
        return jSONObject.has("ok") && !jSONObject.optBoolean("ok", true);
    }

    public final boolean i(TaskResultFileAppUiItem item) {
        String lowerCase;
        String strW1;
        String string;
        String mimeType = item.getMimeType();
        if (mimeType == null || (strW1 = H.w1(mimeType, ';', null, 2, null)) == null || (string = H.D1(strW1).toString()) == null) {
            lowerCase = null;
        } else {
            lowerCase = string.toLowerCase(Locale.ROOT);
            p.h(lowerCase, "toLowerCase(...)");
        }
        if (lowerCase != null && D.X(lowerCase, "image/", false, 2, null)) {
            return true;
        }
        Iterator it = SequencesKt___SequencesKt.R(SequencesKt___SequencesKt.R(SequencesKt___SequencesKt.H(t.w(item.getFileName(), item.getTitle())), new InterfaceC5074l() { // from class: q4.g
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return i.j((String) obj);
            }
        }), new InterfaceC5074l() { // from class: q4.h
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return i.k((String) obj);
            }
        }).iterator();
        while (it.hasNext()) {
            if (IMAGE_EXTENSIONS.contains((String) it.next())) {
                return true;
            }
        }
        return false;
    }

    public final boolean l(String toolName, String argsJson) {
        return p.d(toolName, TOOL_NAME_TEXT_TO_IMAGE) && !n(toolName, argsJson);
    }

    public final boolean m(String resultJson) {
        Object objB;
        Object objB2;
        if (resultJson == null || H.x0(resultJson)) {
            return false;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Boolean.valueOf(INSTANCE.h(new JSONObject(resultJson))));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        boolean z10 = Result.e(objB) != null;
        Object obj = null;
        if (Result.g(objB)) {
            objB = null;
        }
        if (objB != null) {
            obj = objB;
        } else if (z10) {
            try {
                JsonObject asJsonObject = JsonParser.parseString(resultJson).getAsJsonObject();
                p.h(asJsonObject, "getAsJsonObject(...)");
                objB2 = Result.b(Boolean.valueOf(INSTANCE.g(asJsonObject)));
            } catch (Throwable th2) {
                Result.Companion companion3 = Result.INSTANCE;
                objB2 = Result.b(C4849c.a(th2));
            }
            if (!Result.g(objB2)) {
                obj = objB2;
            }
        }
        return p.d(obj, Boolean.TRUE);
    }

    public final boolean n(String toolName, String argsJson) {
        Object objB;
        if (!p.d(toolName, TOOL_NAME_TEXT_TO_IMAGE) || argsJson == null || H.x0(argsJson) || !H.g0(argsJson, "skip_upload", false, 2, null)) {
            return false;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Boolean.valueOf(new JSONObject(argsJson).optBoolean("skip_upload", false)));
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

    public final boolean o(String argsJson) {
        Object objB;
        if (argsJson == null || H.x0(argsJson)) {
            return false;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(Boolean.valueOf(p.d(new JSONObject(argsJson).optString("action"), "upload")));
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

    public final boolean p(String str) {
        if (str == null || H.x0(str) || !H.g0(str, "fileId", false, 2, null) || !H.g0(str, "upload", false, 2, null)) {
            return false;
        }
        return H.g0(str, "image/", false, 2, null) || H.g0(str, PictureMimeType.PNG, false, 2, null) || H.g0(str, PictureMimeType.JPG, false, 2, null) || H.g0(str, ".jpeg", false, 2, null);
    }

    public final TaskResultFileAppUiPayload q(String toolName, String resultJson, String argsJson) {
        if (toolName == null || H.x0(toolName) || resultJson == null || H.x0(resultJson) || !x(toolName, argsJson)) {
            return null;
        }
        return r(resultJson);
    }

    public final TaskResultFileAppUiPayload r(String resultJson) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(s(new JSONObject(resultJson)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        return (TaskResultFileAppUiPayload) objB;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final q4.TaskResultFileAppUiPayload s(org.json.JSONObject r15) {
        /*
            Method dump skipped, instructions count: 258
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q4.i.s(org.json.JSONObject):q4.f");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0040 A[EDGE_INSN: B:57:0x0040->B:20:0x0040 BREAK  A[LOOP:0: B:6:0x001a->B:61:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[LOOP:0: B:6:0x001a->B:61:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final q4.TaskResultFileAppUiPayload t(com.google.gson.JsonObject r15) {
        /*
            Method dump skipped, instructions count: 271
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q4.i.t(com.google.gson.JsonObject):q4.f");
    }

    public final String u(String resultJson) {
        Object objB;
        Object objB2;
        Object obj = null;
        if (resultJson == null || H.x0(resultJson)) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            JSONObject jSONObject = new JSONObject(resultJson);
            i iVar = INSTANCE;
            objB = Result.b(iVar.h(jSONObject) ? null : iVar.z(jSONObject));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        boolean z10 = Result.e(objB) != null;
        if (Result.g(objB)) {
            objB = null;
        }
        if (objB != null) {
            obj = objB;
        } else if (z10) {
            try {
                JsonObject asJsonObject = JsonParser.parseString(resultJson).getAsJsonObject();
                p.h(asJsonObject, "getAsJsonObject(...)");
                i iVar2 = INSTANCE;
                objB2 = Result.b(iVar2.g(asJsonObject) ? null : iVar2.w(asJsonObject, "task_id", "taskId"));
            } catch (Throwable th2) {
                Result.Companion companion3 = Result.INSTANCE;
                objB2 = Result.b(C4849c.a(th2));
            }
            if (!Result.g(objB2)) {
                obj = objB2;
            }
        }
        return (String) obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x005d A[PHI: r3
      0x005d: PHI (r3v6 java.lang.Object) = (r3v5 java.lang.Object), (r3v10 java.lang.Object) binds: [B:13:0x002e, B:21:0x005a] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final q4.TaskResultFileAppUiPayload v(java.lang.String r4) {
        /*
            r3 = this;
            kotlin.Result$a r3 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L12
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L12
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L12
            q4.i r0 = q4.i.INSTANCE     // Catch: java.lang.Throwable -> L12
            q4.f r3 = r0.s(r3)     // Catch: java.lang.Throwable -> L12
            java.lang.Object r3 = kotlin.Result.b(r3)     // Catch: java.lang.Throwable -> L12
            goto L1d
        L12:
            r3 = move-exception
            kotlin.Result$a r0 = kotlin.Result.INSTANCE
            java.lang.Object r3 = kotlin.C4849c.a(r3)
            java.lang.Object r3 = kotlin.Result.b(r3)
        L1d:
            java.lang.Throwable r0 = kotlin.Result.e(r3)
            if (r0 == 0) goto L25
            r0 = 1
            goto L26
        L25:
            r0 = 0
        L26:
            boolean r1 = kotlin.Result.g(r3)
            r2 = 0
            if (r1 == 0) goto L2e
            r3 = r2
        L2e:
            if (r3 != 0) goto L5d
            if (r0 != 0) goto L33
            goto L5e
        L33:
            com.google.gson.JsonElement r3 = com.google.gson.JsonParser.parseString(r4)     // Catch: java.lang.Throwable -> L4b
            com.google.gson.JsonObject r3 = r3.getAsJsonObject()     // Catch: java.lang.Throwable -> L4b
            java.lang.String r4 = "getAsJsonObject(...)"
            kotlin.jvm.internal.p.h(r3, r4)     // Catch: java.lang.Throwable -> L4b
            q4.i r4 = q4.i.INSTANCE     // Catch: java.lang.Throwable -> L4b
            q4.f r3 = r4.t(r3)     // Catch: java.lang.Throwable -> L4b
            java.lang.Object r3 = kotlin.Result.b(r3)     // Catch: java.lang.Throwable -> L4b
            goto L56
        L4b:
            r3 = move-exception
            kotlin.Result$a r4 = kotlin.Result.INSTANCE
            java.lang.Object r3 = kotlin.C4849c.a(r3)
            java.lang.Object r3 = kotlin.Result.b(r3)
        L56:
            boolean r4 = kotlin.Result.g(r3)
            if (r4 == 0) goto L5d
            goto L5e
        L5d:
            r2 = r3
        L5e:
            q4.f r2 = (q4.TaskResultFileAppUiPayload) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: q4.i.v(java.lang.String):q4.f");
    }

    public final String w(JsonObject jsonObject, String... strArr) {
        String str;
        String asString;
        int length = strArr.length;
        int i10 = 0;
        while (true) {
            str = null;
            if (i10 < length) {
                JsonElement jsonElement = jsonObject.get(strArr[i10]);
                if (jsonElement != null) {
                    if (!jsonElement.isJsonPrimitive()) {
                        jsonElement = null;
                    }
                    if (jsonElement != null && (asString = jsonElement.getAsString()) != null && !H.x0(asString)) {
                        str = asString;
                    }
                }
                if (str != null) {
                    break;
                }
                i10++;
            } else {
                break;
            }
        }
        return str;
    }

    public final boolean x(String toolName, String argsJson) {
        int iHashCode = toolName.hashCode();
        if (iHashCode != -1220253876) {
            if (iHashCode != 703661376) {
                return iHashCode == 1212711273 && toolName.equals(TOOL_NAME_TEXT_TO_IMAGE) && !n(toolName, argsJson);
            }
            if (toolName.equals("task_result_submit")) {
                return true;
            }
        } else if (toolName.equals(TOOL_NAME_TASK_ARTIFACT)) {
            return o(argsJson);
        }
        return false;
    }

    public final boolean y(String toolName, String argsJson) {
        if (p.d(toolName, TOOL_NAME_TEXT_TO_IMAGE)) {
            return false;
        }
        return x(toolName, argsJson);
    }

    public final String z(JSONObject root) {
        String strOptString = root.optString("task_id");
        if (H.x0(strOptString)) {
            strOptString = null;
        }
        if (strOptString != null) {
            return strOptString;
        }
        String strOptString2 = root.optString("taskId");
        if (H.x0(strOptString2)) {
            return null;
        }
        return strOptString2;
    }
}
