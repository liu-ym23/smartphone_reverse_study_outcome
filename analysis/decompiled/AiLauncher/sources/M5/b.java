package M5;

import La.H;
import Y8.j;
import Y8.t;
import Z8.A;
import Z8.C1173v;
import Z8.C1174w;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherCardModel;
import com.stepos.ailauncher.foundation.appui.card.provider.appauther.AppAutherField;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.q0;
import h8.C4148a;
import io.ktor.sse.ServerSentEventKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.N;
import kotlin.Result;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u001c\n\u0002\u0010#\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\r\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000bJ1\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u001a\u0010\u0019J\u001d\u0010\u001e\u001a\u00020\u00062\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ+\u0010#\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u00062\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060!H\u0002¢\u0006\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010&R\u0014\u0010(\u001a\u00020\u00068\u0000X\u0080T¢\u0006\u0006\n\u0004\b(\u0010&R\u0014\u0010)\u001a\u00020\u00068\u0000X\u0080T¢\u0006\u0006\n\u0004\b)\u0010&R\u0014\u0010*\u001a\u00020\u00068\u0000X\u0080T¢\u0006\u0006\n\u0004\b*\u0010&R\u0014\u0010+\u001a\u00020\u00068\u0000X\u0080T¢\u0006\u0006\n\u0004\b+\u0010&R\u0014\u0010,\u001a\u00020\u00068\u0000X\u0080T¢\u0006\u0006\n\u0004\b,\u0010&R\u0014\u0010-\u001a\u00020\u00068\u0000X\u0080T¢\u0006\u0006\n\u0004\b-\u0010&R\u0014\u0010.\u001a\u00020\u00068\u0000X\u0080T¢\u0006\u0006\n\u0004\b.\u0010&R\u0014\u0010/\u001a\u00020\u00068\u0000X\u0080T¢\u0006\u0006\n\u0004\b/\u0010&R\u0014\u00100\u001a\u00020\u00068\u0000X\u0080T¢\u0006\u0006\n\u0004\b0\u0010&R\u0014\u00101\u001a\u00020\u00068\u0000X\u0080T¢\u0006\u0006\n\u0004\b1\u0010&R\u0014\u00102\u001a\u00020\u00068\u0000X\u0080T¢\u0006\u0006\n\u0004\b2\u0010&R\u0014\u00103\u001a\u00020\u00068\u0000X\u0080T¢\u0006\u0006\n\u0004\b3\u0010&R\u0014\u00104\u001a\u00020\u00068\u0000X\u0080T¢\u0006\u0006\n\u0004\b4\u0010&R\u0014\u00105\u001a\u00020\u00068\u0000X\u0080T¢\u0006\u0006\n\u0004\b5\u0010&R\u0014\u00106\u001a\u00020\u00068\u0000X\u0080T¢\u0006\u0006\n\u0004\b6\u0010&R\u0014\u00107\u001a\u00020\u00068\u0000X\u0080T¢\u0006\u0006\n\u0004\b7\u0010&R\u0014\u00108\u001a\u00020\u00068\u0000X\u0080T¢\u0006\u0006\n\u0004\b8\u0010&R\u0014\u00109\u001a\u00020\u00068\u0000X\u0080T¢\u0006\u0006\n\u0004\b9\u0010&R\u0014\u0010:\u001a\u00020\u00068\u0000X\u0080T¢\u0006\u0006\n\u0004\b:\u0010&R\u0014\u0010;\u001a\u00020\u00068\u0000X\u0080T¢\u0006\u0006\n\u0004\b;\u0010&R\u0014\u0010<\u001a\u00020\u00068\u0000X\u0080T¢\u0006\u0006\n\u0004\b<\u0010&R\u0014\u0010=\u001a\u00020\u00068\u0000X\u0080T¢\u0006\u0006\n\u0004\b=\u0010&R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00060>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010@¨\u0006A"}, d2 = {"LM5/b;", "", "<init>", "()V", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/k;", AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, "", "sessionId", "authStatus", "LY8/t;", "f", "(Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/k;Ljava/lang/String;Ljava/lang/String;)V", "actionKind", "c", "", "success", "failReason", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/k;Ljava/lang/String;ZLjava/lang/String;)V", Const.INTENT_KEY_UMID, "(Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/k;Ljava/lang/String;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/k;)Ljava/lang/String;", "mode", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "", "Lcom/stepos/ailauncher/foundation/appui/card/provider/appauther/r;", "fields", "e", "(Ljava/util/List;)Ljava/lang/String;", "event", "", "attrs", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;Ljava/util/Map;)V", "TAG", "Ljava/lang/String;", "PAGE_NAME", "EVENT_EXPOSE", "EVENT_CLICK", "EVENT_JUMP", "EVENT_CREDENTIAL_SUBMIT", "AUTH_TYPE_OAUTH", "AUTH_TYPE_API_KEY", "AUTH_TYPE_MANUAL", "AUTH_STATUS_UNAUTHORIZED", "AUTH_STATUS_AUTHORIZED", "AUTH_STATUS_EXPIRED", "AUTH_STATUS_INVALID", "ACTION_OAUTH", "ACTION_GET_KEY", "ACTION_COMPLETE", "RESULT_SUCCESS", "RESULT_FAILED", "FAIL_CREATE_SESSION", "FAIL_MISSING_TARGET", "FAIL_OPEN_TARGET", "CREDENTIAL_API_KEY", "CREDENTIAL_KEY_SECRET", "CREDENTIAL_TOKEN", "", "exposedCards", "Ljava/util/Set;", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class b {
    public static final String ACTION_COMPLETE = "complete";
    public static final String ACTION_GET_KEY = "get_key";
    public static final String ACTION_OAUTH = "oauth";
    public static final String AUTH_STATUS_AUTHORIZED = "authorized";
    public static final String AUTH_STATUS_EXPIRED = "expired";
    public static final String AUTH_STATUS_INVALID = "invalid";
    public static final String AUTH_STATUS_UNAUTHORIZED = "unauthorized";
    public static final String AUTH_TYPE_API_KEY = "api_key";
    public static final String AUTH_TYPE_MANUAL = "manual_auth";
    public static final String AUTH_TYPE_OAUTH = "oauth";
    public static final String CREDENTIAL_API_KEY = "api_key";
    public static final String CREDENTIAL_KEY_SECRET = "key_secret";
    public static final String CREDENTIAL_TOKEN = "token";
    public static final String EVENT_CLICK = "thirdapp_authcard_click";
    public static final String EVENT_CREDENTIAL_SUBMIT = "thirdapp_auth_credential_submit";
    public static final String EVENT_EXPOSE = "thirdapp_authcard_expose";
    public static final String EVENT_JUMP = "thirdapp_auth_jump";
    public static final String FAIL_CREATE_SESSION = "create_session_failed";
    public static final String FAIL_MISSING_TARGET = "missing_target";
    public static final String FAIL_OPEN_TARGET = "open_target_failed";
    public static final b INSTANCE = new b();
    private static final String PAGE_NAME = "chatview";
    public static final String RESULT_FAILED = "failed";
    public static final String RESULT_SUCCESS = "success";
    private static final String TAG = "AppAutherTracker";
    private static final Set<String> exposedCards;

    static {
        ConcurrentHashMap.KeySetView keySetViewNewKeySet = ConcurrentHashMap.newKeySet();
        p.h(keySetViewNewKeySet, "newKeySet(...)");
        exposedCards = keySetViewNewKeySet;
    }

    public final String a(String actionKind) {
        p.i(actionKind, "actionKind");
        switch (actionKind.hashCode()) {
            case -2123212072:
                if (actionKind.equals(AppAutherCardModel.ActionItem.ACTION_JUMP_FOR_KEY)) {
                    return ACTION_GET_KEY;
                }
                return null;
            case -2076491336:
                if (actionKind.equals(AppAutherCardModel.ActionItem.ACTION_SUBMIT_KEY)) {
                    return "complete";
                }
                return null;
            case -1573699739:
                if (actionKind.equals(AppAutherCardModel.ActionItem.ACTION_START_AUTH)) {
                    return "oauth";
                }
                return null;
            case -409694582:
                if (actionKind.equals(AppAutherCardModel.ActionItem.ACTION_COMPLETE_A2A)) {
                    return "complete";
                }
                return null;
            default:
                return null;
        }
    }

    public final String b(String mode) {
        p.i(mode, "mode");
        switch (mode.hashCode()) {
            case 94864:
                if (mode.equals("a2a")) {
                    return AUTH_TYPE_MANUAL;
                }
                return null;
            case 3023933:
                if (mode.equals("bind")) {
                    return "api_key";
                }
                return null;
            case 98712316:
                if (mode.equals("guide")) {
                    return AUTH_TYPE_MANUAL;
                }
                return null;
            case 105516695:
                if (mode.equals("oauth")) {
                    return "oauth";
                }
                return null;
            default:
                return null;
        }
    }

    public final void c(AppAutherCardModel model, String sessionId, String actionKind) {
        String strA;
        p.i(model, "model");
        p.i(sessionId, "sessionId");
        p.i(actionKind, "actionKind");
        String strB = b(model.getMode());
        if (strB == null || (strA = a(actionKind)) == null) {
            return;
        }
        h(EVENT_CLICK, kotlin.collections.a.l(j.a("thirdapp_id", i(model)), j.a("auth_type", strB), j.a("action_type", strA), j.a("session_id", sessionId), j.a("task_id", model.getCardId())));
    }

    public final void d(AppAutherCardModel model, String sessionId) {
        p.i(model, "model");
        p.i(sessionId, "sessionId");
        h(EVENT_CREDENTIAL_SUBMIT, kotlin.collections.a.l(j.a("thirdapp_id", i(model)), j.a("session_id", sessionId), j.a("credential_type", e(model.g()))));
    }

    public final String e(List<AppAutherField> fields) {
        p.i(fields, "fields");
        ArrayList arrayList = new ArrayList();
        for (AppAutherField appAutherField : fields) {
            String name = appAutherField.getName();
            String str = "";
            if (name == null) {
                name = "";
            }
            String label = appAutherField.getLabel();
            if (label != null) {
                str = label;
            }
            A.E(arrayList, C1173v.p(name, str));
        }
        ArrayList<String> arrayList2 = new ArrayList(C1174w.x(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String lowerCase = ((String) it.next()).toLowerCase(Locale.ROOT);
            p.h(lowerCase, "toLowerCase(...)");
            arrayList2.add(lowerCase);
        }
        if (!arrayList2.isEmpty()) {
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                if (H.g0((String) it2.next(), CREDENTIAL_TOKEN, false, 2, null)) {
                    return CREDENTIAL_TOKEN;
                }
            }
        }
        if (!arrayList2.isEmpty()) {
            for (String str2 : arrayList2) {
                if (H.g0(str2, "secret", false, 2, null) || H.g0(str2, "密钥", false, 2, null) || H.g0(str2, "密匙", false, 2, null)) {
                    return CREDENTIAL_KEY_SECRET;
                }
            }
        }
        return fields.size() > 1 ? CREDENTIAL_KEY_SECRET : "api_key";
    }

    public final void f(AppAutherCardModel model, String sessionId, String authStatus) {
        p.i(model, "model");
        p.i(sessionId, "sessionId");
        p.i(authStatus, "authStatus");
        String strI = i(model);
        String strB = b(model.getMode());
        if (strB == null) {
            return;
        }
        if (exposedCards.add(sessionId + ServerSentEventKt.COLON + model.getCardId() + ServerSentEventKt.COLON + strI + ServerSentEventKt.COLON + strB)) {
            h(EVENT_EXPOSE, kotlin.collections.a.l(j.a("thirdapp_id", strI), j.a("auth_type", strB), j.a("auth_status", authStatus), j.a("session_id", sessionId), j.a("task_id", model.getCardId())));
        }
    }

    public final void g(AppAutherCardModel model, String sessionId, boolean success, String failReason) {
        p.i(model, "model");
        p.i(sessionId, "sessionId");
        LinkedHashMap linkedHashMapL = kotlin.collections.a.l(j.a("thirdapp_id", i(model)), j.a("session_id", sessionId), j.a("result", success ? "success" : "failed"));
        if (!success && failReason != null && !H.x0(failReason)) {
            linkedHashMapL.put("fail_reason", failReason);
        }
        h(EVENT_JUMP, linkedHashMapL);
    }

    public final void h(String event, Map<String, String> attrs) {
        Object objB;
        C4148a.k("Track", event + " page=chatview " + attrs, false, 4, null);
        try {
            Result.Companion companion = Result.INSTANCE;
            N.a(event, "chatview", attrs);
            objB = Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.u(TAG, event + " skipped: " + thE.getMessage(), false, 4, null);
        }
    }

    public final String i(AppAutherCardModel model) {
        Object next;
        String lowerCase;
        String string;
        p.i(model, "model");
        Iterator it = Ka.t.w(model.getProvider(), model.getVendorId(), model.getIntegrationId(), model.getDisplayName()).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            String str = (String) next;
            if (!(str == null || H.x0(str))) {
                break;
            }
        }
        String str2 = (String) next;
        if (str2 == null || (string = H.D1(str2).toString()) == null) {
            lowerCase = null;
        } else {
            lowerCase = string.toLowerCase(Locale.ROOT);
            p.h(lowerCase, "toLowerCase(...)");
        }
        if (lowerCase == null) {
            lowerCase = "";
        }
        if (lowerCase.length() == 0) {
            return "unknown";
        }
        String str3 = "meituan";
        if (!H.g0(lowerCase, "meituan", false, 2, null) && !H.g0(lowerCase, "mt-paotui", false, 2, null) && !H.g0(lowerCase, "美团", false, 2, null)) {
            str3 = "alipay";
            if (!H.g0(lowerCase, "alipay", false, 2, null) && !H.g0(lowerCase, "支付宝", false, 2, null)) {
                str3 = "wechat";
                if (!H.g0(lowerCase, "wechat", false, 2, null) && !H.g0(lowerCase, "weixin", false, 2, null) && !H.g0(lowerCase, "微信", false, 2, null)) {
                    str3 = "weibo";
                    if (!H.g0(lowerCase, "weibo", false, 2, null) && !H.g0(lowerCase, "微博", false, 2, null)) {
                        str3 = q0.CAOCAO;
                        if (!H.g0(lowerCase, q0.CAOCAO, false, 2, null) && !H.g0(lowerCase, "曹操", false, 2, null)) {
                            str3 = "eastmoney";
                            if (!H.g0(lowerCase, "eastmoney", false, 2, null) && !H.g0(lowerCase, "mx-finance", false, 2, null) && !H.g0(lowerCase, "东方财富", false, 2, null)) {
                                return (H.g0(lowerCase, "baidu", false, 2, null) || H.g0(lowerCase, "百度网盘", false, 2, null)) ? "baidu_netdisk" : lowerCase;
                            }
                        }
                    }
                }
            }
        }
        return str3;
    }
}
