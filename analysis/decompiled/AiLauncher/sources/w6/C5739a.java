package w6;

import La.H;
import Z8.Y;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.g;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.o0;
import java.util.Locale;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\"\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0017\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b \u0010\u001fR\u0014\u0010!\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\u001fR\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lw6/a;", "", "<init>", "()V", "", "existingJson", "incomingJson", "c", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "phase", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;)I", "ordinal", "", Const.INTENT_KEY_PKGNAME, "(I)Z", "json", "Lorg/json/JSONObject;", "e", "(Ljava/lang/String;)Lorg/json/JSONObject;", "existingObj", "incomingObj", Const.INTENT_KEY_APIKEY, "(Lorg/json/JSONObject;Lorg/json/JSONObject;)Lorg/json/JSONObject;", "obj", Const.INTENT_KEY_UMID, "(Lorg/json/JSONObject;)Z", "f", "(Ljava/lang/String;)Ljava/lang/String;", "KEY_CARD_HIDDEN", "Ljava/lang/String;", "KEY_CARD_HIDDEN_PHASE", "KEY_RECORDING_PHASE", "", "POST_RECORDING_PHASES", "Ljava/util/Set;", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: w6.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C5739a {
    public static final String KEY_CARD_HIDDEN = "card_hidden";
    public static final String KEY_CARD_HIDDEN_PHASE = "card_hidden_phase";
    private static final String KEY_RECORDING_PHASE = "recording_phase";
    public static final C5739a INSTANCE = new C5739a();
    private static final Set<String> POST_RECORDING_PHASES = Y.j("transcribing", "transcribe", "transcript_generating", "transcribe_done", "transcribe_success", "transcribed", "transcript_done", "summarizing", "summary_generating", "summarising", "summary_done", "summary_success", "summary_completed", "summarized");

    public final JSONObject a(JSONObject existingObj, JSONObject incomingObj) throws JSONException {
        if (!d(existingObj)) {
            return null;
        }
        String strOptString = existingObj.optString(KEY_CARD_HIDDEN_PHASE, "");
        p.h(strOptString, "optString(...)");
        String string = H.D1(strOptString).toString();
        String strOptString2 = incomingObj.optString(KEY_RECORDING_PHASE, "");
        p.h(strOptString2, "optString(...)");
        String string2 = H.D1(strOptString2).toString();
        Locale locale = Locale.ROOT;
        String lowerCase = string2.toLowerCase(locale);
        p.h(lowerCase, "toLowerCase(...)");
        String strF = f(lowerCase);
        String strOptString3 = existingObj.optString(KEY_RECORDING_PHASE, "");
        p.h(strOptString3, "optString(...)");
        String lowerCase2 = H.D1(strOptString3).toString().toLowerCase(locale);
        p.h(lowerCase2, "toLowerCase(...)");
        String strF2 = f(lowerCase2);
        if (strF == null) {
            strF = strF2;
        }
        if (!(!H.x0(string) ? p.d(string, strF) : strF == null || p.d(strF, "COMPLETED"))) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(incomingObj.toString());
        jSONObject.put(KEY_CARD_HIDDEN, true);
        if (H.x0(string)) {
            jSONObject.remove(KEY_CARD_HIDDEN_PHASE);
            return jSONObject;
        }
        jSONObject.put(KEY_CARD_HIDDEN_PHASE, string);
        return jSONObject;
    }

    public final boolean b(int ordinal) {
        return ordinal >= g("completed");
    }

    public final String c(String existingJson, String incomingJson) throws JSONException {
        String string;
        String string2;
        JSONObject jSONObjectE = e(existingJson);
        if (jSONObjectE != null) {
            JSONObject jSONObjectE2 = e(incomingJson);
            if (jSONObjectE2 == null) {
                return existingJson;
            }
            String strOptString = jSONObjectE.optString(KEY_RECORDING_PHASE, "");
            p.h(strOptString, "optString(...)");
            String string3 = H.D1(strOptString).toString();
            Locale locale = Locale.ROOT;
            String lowerCase = string3.toLowerCase(locale);
            p.h(lowerCase, "toLowerCase(...)");
            String strOptString2 = jSONObjectE2.optString(KEY_RECORDING_PHASE, "");
            p.h(strOptString2, "optString(...)");
            String lowerCase2 = H.D1(strOptString2).toString().toLowerCase(locale);
            p.h(lowerCase2, "toLowerCase(...)");
            if (!H.x0(lowerCase) && !H.x0(lowerCase2)) {
                int iG = g(lowerCase);
                int iG2 = g(lowerCase2);
                if (iG2 >= 0 && iG >= 0 && b(iG) && iG2 < iG) {
                    JSONObject jSONObject = new JSONObject(jSONObjectE2.toString());
                    jSONObject.put(KEY_RECORDING_PHASE, jSONObjectE.get(KEY_RECORDING_PHASE));
                    JSONObject jSONObjectA = a(jSONObjectE, jSONObject);
                    if (jSONObjectA != null && (string2 = jSONObjectA.toString()) != null) {
                        return string2;
                    }
                    String string4 = jSONObject.toString();
                    p.h(string4, "toString(...)");
                    return string4;
                }
            }
            JSONObject jSONObjectA2 = a(jSONObjectE, jSONObjectE2);
            if (jSONObjectA2 != null && (string = jSONObjectA2.toString()) != null) {
                return string;
            }
        }
        return incomingJson;
    }

    public final boolean d(JSONObject obj) {
        if (!obj.optBoolean(KEY_CARD_HIDDEN, false)) {
            String strOptString = obj.optString(KEY_CARD_HIDDEN, "");
            p.h(strOptString, "optString(...)");
            String lowerCase = H.D1(strOptString).toString().toLowerCase(Locale.ROOT);
            p.h(lowerCase, "toLowerCase(...)");
            if (!p.d(lowerCase, "true") && obj.optInt(KEY_CARD_HIDDEN, 0) != 1) {
                return false;
            }
        }
        return true;
    }

    public final JSONObject e(String json) {
        Object objB;
        if (json == null) {
            return null;
        }
        if (H.x0(json)) {
            json = null;
        }
        if (json == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(new JSONObject(json));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        return (JSONObject) (Result.g(objB) ? null : objB);
    }

    public final String f(String phase) {
        switch (phase.hashCode()) {
            case -2100843269:
                if (phase.equals("summarize_failed")) {
                    return "SUMMARY_FAILED";
                }
                return null;
            case -2082944753:
                if (phase.equals("transcribed")) {
                    return "TRANSCRIBE_DONE";
                }
                return null;
            case -2014562021:
                if (phase.equals("transcript_generating")) {
                    return "TRANSCRIBING";
                }
                return null;
            case -1884319283:
                if (phase.equals("stopped")) {
                    return "COMPLETED";
                }
                return null;
            case -1729759755:
                if (phase.equals("transcribe")) {
                    return "TRANSCRIBING";
                }
                return null;
            case -1402931637:
                if (phase.equals("completed")) {
                    return "COMPLETED";
                }
                return null;
            case -1206727899:
                if (phase.equals("summarising")) {
                    return "SUMMARIZING";
                }
                return null;
            case -1206519362:
                if (phase.equals("summarizing")) {
                    return "SUMMARIZING";
                }
                return null;
            case -995321554:
                if (phase.equals(o0.TRACK_STATUS_PAUSED)) {
                    return "PAUSED";
                }
                return null;
            case -890049081:
                if (phase.equals("transcribe_failed")) {
                    return "TRANSCRIBE_FAILED";
                }
                return null;
            case -782989206:
                if (phase.equals("summary_success")) {
                    return "SUMMARY_DONE";
                }
                return null;
            case -673660814:
                if (phase.equals("finished")) {
                    return "COMPLETED";
                }
                return null;
            case -599445191:
                if (phase.equals("complete")) {
                    return "COMPLETED";
                }
                return null;
            case -415742357:
                if (phase.equals("transcript_done")) {
                    return "TRANSCRIBE_DONE";
                }
                return null;
            case -385329268:
                if (phase.equals("transcribe_done")) {
                    return "TRANSCRIBE_DONE";
                }
                return null;
            case -385283288:
                if (phase.equals("transcribe_fail")) {
                    return "TRANSCRIBE_FAILED";
                }
                return null;
            case -316014781:
                if (phase.equals("summarized")) {
                    return "SUMMARY_DONE";
                }
                return null;
            case -146773646:
                if (phase.equals("transcribing")) {
                    return "TRANSCRIBING";
                }
                return null;
            case -52256538:
                if (phase.equals("transcript_failed")) {
                    return "TRANSCRIBE_FAILED";
                }
                return null;
            case 3089282:
                if (phase.equals("done")) {
                    return "COMPLETED";
                }
                return null;
            case 3540994:
                if (phase.equals(g.ACTION_STOP)) {
                    return "COMPLETED";
                }
                return null;
            case 106440182:
                if (phase.equals("pause")) {
                    return "PAUSED";
                }
                return null;
            case 692658934:
                if (phase.equals("summary_failed")) {
                    return "SUMMARY_FAILED";
                }
                return null;
            case 714672175:
                if (phase.equals("summary_error")) {
                    return "SUMMARY_FAILED";
                }
                return null;
            case 940711742:
                if (phase.equals("transcribe_error")) {
                    return "TRANSCRIBE_FAILED";
                }
                return null;
            case 975385387:
                if (phase.equals("summary_generating")) {
                    return "SUMMARIZING";
                }
                return null;
            case 993558001:
                if (phase.equals(com.stepos.ailauncher.chat.util.g.REASON_RECORDING)) {
                    return "RECORDING";
                }
                return null;
            case 1112522994:
                if (phase.equals("summary_completed")) {
                    return "SUMMARY_DONE";
                }
                return null;
            case 1550783935:
                if (phase.equals("running")) {
                    return "RECORDING";
                }
                return null;
            case 1685589115:
                if (phase.equals("summary_done")) {
                    return "SUMMARY_DONE";
                }
                return null;
            case 1685635095:
                if (phase.equals("summary_fail")) {
                    return "SUMMARY_FAILED";
                }
                return null;
            case 1692669881:
                if (phase.equals("transcribe_success")) {
                    return "TRANSCRIBE_DONE";
                }
                return null;
            default:
                return null;
        }
    }

    public final int g(String phase) {
        switch (phase.hashCode()) {
            case -2100843269:
                return !phase.equals("summarize_failed") ? -1 : 8;
            case -2082944753:
                return !phase.equals("transcribed") ? -1 : 4;
            case -2014562021:
                return !phase.equals("transcript_generating") ? -1 : 3;
            case -1884319283:
                return !phase.equals("stopped") ? -1 : 2;
            case -1729759755:
                return !phase.equals("transcribe") ? -1 : 3;
            case -1402931637:
                return !phase.equals("completed") ? -1 : 2;
            case -1206727899:
                return !phase.equals("summarising") ? -1 : 5;
            case -1206519362:
                return !phase.equals("summarizing") ? -1 : 5;
            case -995321554:
                return !phase.equals(o0.TRACK_STATUS_PAUSED) ? -1 : 1;
            case -890049081:
                return !phase.equals("transcribe_failed") ? -1 : 7;
            case -782989206:
                return !phase.equals("summary_success") ? -1 : 6;
            case -673660814:
                return !phase.equals("finished") ? -1 : 2;
            case -599445191:
                return !phase.equals("complete") ? -1 : 2;
            case -415742357:
                return !phase.equals("transcript_done") ? -1 : 4;
            case -385329268:
                return !phase.equals("transcribe_done") ? -1 : 4;
            case -385283288:
                return !phase.equals("transcribe_fail") ? -1 : 7;
            case -316014781:
                return !phase.equals("summarized") ? -1 : 6;
            case -146773646:
                return !phase.equals("transcribing") ? -1 : 3;
            case -52256538:
                return !phase.equals("transcript_failed") ? -1 : 7;
            case 3089282:
                return !phase.equals("done") ? -1 : 2;
            case 3540994:
                return !phase.equals(g.ACTION_STOP) ? -1 : 2;
            case 106440182:
                return !phase.equals("pause") ? -1 : 1;
            case 692658934:
                return !phase.equals("summary_failed") ? -1 : 8;
            case 714672175:
                return !phase.equals("summary_error") ? -1 : 8;
            case 940711742:
                return !phase.equals("transcribe_error") ? -1 : 7;
            case 975385387:
                return !phase.equals("summary_generating") ? -1 : 5;
            case 993558001:
                return !phase.equals(com.stepos.ailauncher.chat.util.g.REASON_RECORDING) ? -1 : 0;
            case 1112522994:
                return !phase.equals("summary_completed") ? -1 : 6;
            case 1550783935:
                return !phase.equals("running") ? -1 : 0;
            case 1685589115:
                return !phase.equals("summary_done") ? -1 : 6;
            case 1685635095:
                return !phase.equals("summary_fail") ? -1 : 8;
            case 1692669881:
                return !phase.equals("transcribe_success") ? -1 : 4;
            default:
                return -1;
        }
    }
}
