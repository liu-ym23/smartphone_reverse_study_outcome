package com.stepos.ailauncher.task.space.credential;

import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\u0019\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ%\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ1\u0010\u0013\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0015\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0018\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006¢\u0006\u0004\b\u0018\u0010\u0016J%\u0010\u001b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006¢\u0006\u0004\b\u001b\u0010\u000fJ+\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u00062\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010\"R\u0014\u0010$\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010\"R\u0014\u0010%\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010\"R\u0014\u0010&\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b&\u0010\"R\u0014\u0010'\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010\"R\u0014\u0010(\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010\"R\u0014\u0010)\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b)\u0010\"R\u0014\u0010*\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b*\u0010\"R\u0014\u0010+\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b+\u0010\"R\u0014\u0010,\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b,\u0010\"R\u0014\u0010-\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b-\u0010\"R\u0014\u0010.\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b.\u0010\"R\u0014\u0010/\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b/\u0010\"R\u0014\u00100\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b0\u0010\"R\u0014\u00101\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b1\u0010\"R\u0014\u00102\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b2\u0010\"R\u0014\u00103\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b3\u0010\"R\u0014\u00104\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b4\u0010\"R\u0014\u00105\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b5\u0010\"¨\u00066"}, d2 = {"Lcom/stepos/ailauncher/task/space/credential/P;", "", "<init>", "()V", "", "authorizedCount", "", "entrySource", "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(ILjava/lang/String;)V", "clickTarget", "thirdAppId", "authType", "c", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "authorizedDurationSec", "lastUsedIntervalSec", "e", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)V", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;)V", "actionType", Const.INTENT_KEY_PKGNAME, "credentialType", "result", Const.INTENT_KEY_UMID, "event", "", "attrs", "f", "(Ljava/lang/String;Ljava/util/Map;)V", "TAG", "Ljava/lang/String;", "EVENT_VIEW", "EVENT_CLICK", "EVENT_DETAIL_VIEW", "EVENT_CANCEL_CLICK", "EVENT_CANCEL_CONFIRM_CLICK", "EVENT_CREDENTIAL_EDIT", "PAGE_NAME", "ENTRY_REPAIR", "ENTRY_CHATVIEW", "ENTRY_DETAIL", "ACTION_CONFIRM", "ACTION_CANCEL", "RESULT_SUCCESS", "RESULT_FAILED", "CLICK_CANCEL", "CLICK_CARD", "AUTH_OAUTH", "AUTH_APPKEY", "AUTH_API_KEY", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class P {
    public static final String ACTION_CANCEL = "cancel";
    public static final String ACTION_CONFIRM = "confirm";
    public static final String AUTH_API_KEY = "api_key";
    public static final String AUTH_APPKEY = "appkey";
    public static final String AUTH_OAUTH = "oauth";
    public static final String CLICK_CANCEL = "cancel";
    public static final String CLICK_CARD = "card";
    public static final String ENTRY_CHATVIEW = "chatview";
    public static final String ENTRY_DETAIL = "detail";
    public static final String ENTRY_REPAIR = "repair";
    private static final String EVENT_CANCEL_CLICK = "thirdapp_cancel_thirdauth_click";
    private static final String EVENT_CANCEL_CONFIRM_CLICK = "thirdapp_cancel_thirdauth_confirm_click";
    private static final String EVENT_CLICK = "thirdapp_thirdauth_click";
    private static final String EVENT_CREDENTIAL_EDIT = "thirdapp_auth_credential_edit";
    private static final String EVENT_DETAIL_VIEW = "thirdapp_thirdauth_detail_view";
    private static final String EVENT_VIEW = "thirdapp_thirdauth_view";
    public static final P INSTANCE = new P();
    private static final String PAGE_NAME = "thirdapp";
    public static final String RESULT_FAILED = "failed";
    public static final String RESULT_SUCCESS = "success";
    private static final String TAG = "ThirdPartyAuthTracker";

    public final void a(String thirdAppId, String authType) {
        kotlin.jvm.internal.p.i(thirdAppId, "thirdAppId");
        kotlin.jvm.internal.p.i(authType, "authType");
        f(EVENT_CANCEL_CLICK, kotlin.collections.a.m(Y8.j.a("thirdapp_id", thirdAppId), Y8.j.a("auth_type", authType), Y8.j.a("entry_source", "detail")));
    }

    public final void b(String thirdAppId, String actionType) {
        kotlin.jvm.internal.p.i(thirdAppId, "thirdAppId");
        kotlin.jvm.internal.p.i(actionType, "actionType");
        f(EVENT_CANCEL_CONFIRM_CLICK, kotlin.collections.a.m(Y8.j.a("thirdapp_id", thirdAppId), Y8.j.a("action_type", actionType)));
    }

    public final void c(String clickTarget, String thirdAppId, String authType) {
        kotlin.jvm.internal.p.i(clickTarget, "clickTarget");
        kotlin.jvm.internal.p.i(thirdAppId, "thirdAppId");
        kotlin.jvm.internal.p.i(authType, "authType");
        f(EVENT_CLICK, kotlin.collections.a.m(Y8.j.a("click_target", clickTarget), Y8.j.a("thirdapp_id", thirdAppId), Y8.j.a("auth_type", authType)));
    }

    public final void d(String thirdAppId, String credentialType, String result) {
        kotlin.jvm.internal.p.i(thirdAppId, "thirdAppId");
        kotlin.jvm.internal.p.i(credentialType, "credentialType");
        kotlin.jvm.internal.p.i(result, "result");
        f(EVENT_CREDENTIAL_EDIT, kotlin.collections.a.m(Y8.j.a("thirdapp_id", thirdAppId), Y8.j.a("credential_type", credentialType), Y8.j.a("result", result)));
    }

    public final void e(String thirdAppId, String authType, Long authorizedDurationSec, Long lastUsedIntervalSec) {
        kotlin.jvm.internal.p.i(thirdAppId, "thirdAppId");
        kotlin.jvm.internal.p.i(authType, "authType");
        LinkedHashMap linkedHashMapL = kotlin.collections.a.l(Y8.j.a("thirdapp_id", thirdAppId), Y8.j.a("auth_type", authType));
        if (authorizedDurationSec != null) {
            linkedHashMapL.put("authorized_duration", String.valueOf(authorizedDurationSec.longValue()));
        }
        if (lastUsedIntervalSec != null) {
            linkedHashMapL.put("last_used_interval", String.valueOf(lastUsedIntervalSec.longValue()));
        }
        f(EVENT_DETAIL_VIEW, linkedHashMapL);
    }

    public final void f(String event, Map<String, String> attrs) {
        C4148a.d(TAG, event + " " + attrs, false, 4, null);
        kotlin.N.a(event, PAGE_NAME, attrs);
    }

    public final void g(int authorizedCount, String entrySource) {
        kotlin.jvm.internal.p.i(entrySource, "entrySource");
        f(EVENT_VIEW, kotlin.collections.a.m(Y8.j.a("authorized_count", String.valueOf(authorizedCount)), Y8.j.a("entry_source", entrySource)));
    }
}
