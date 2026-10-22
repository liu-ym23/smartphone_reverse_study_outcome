package W4;

import La.H;
import Y8.j;
import Z8.Q;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.agent.aispace.market.ConnectedAgentsActivity;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.N;
import kotlin.Pair;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010$\n\u0002\b,\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\u0003J\u0017\u0010\u000b\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\u000f\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u0003J!\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u0019\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0004¢\u0006\u0004\b\u0019\u0010\u001aJ7\u0010\u001f\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001c\u001a\u00020\u001b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010\"\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u0004¢\u0006\u0004\b\"\u0010\fJ\u0015\u0010$\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u001b¢\u0006\u0004\b$\u0010%J\u0019\u0010&\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b&\u0010\fJ\u0017\u0010(\u001a\u00020\b2\b\u0010'\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b(\u0010\fJ\u001f\u0010*\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u00042\b\u0010'\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b*\u0010\u0015J\u001f\u0010,\u001a\u00020\b2\u0006\u0010+\u001a\u00020\u00042\b\u0010'\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b,\u0010\u0015J5\u00101\u001a\u00020\b2\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00042\u0014\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010/H\u0002¢\u0006\u0004\b1\u00102R\u0014\u00103\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u00105\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b5\u00104R\u0014\u00106\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b6\u00104R\u0014\u00107\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b7\u00104R\u0014\u00108\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b8\u00104R\u0014\u00109\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b9\u00104R\u0014\u0010:\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b:\u00104R\u0014\u0010;\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b;\u00104R\u0014\u0010<\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b<\u00104R\u0014\u0010=\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b=\u00104R\u0014\u0010>\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b>\u00104R\u0014\u0010?\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b?\u00104R\u0014\u0010@\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b@\u00104R\u0014\u0010A\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\bA\u00104R\u0014\u0010B\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\bB\u00104R\u0014\u0010C\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\bC\u00104R\u0014\u0010D\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\bD\u00104R\u0014\u0010E\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bE\u00104R\u0014\u0010F\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bF\u00104R\u0014\u0010G\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bG\u00104R\u0014\u0010H\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bH\u00104R\u0014\u0010I\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bI\u00104R\u0014\u0010J\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bJ\u00104R\u0014\u0010K\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bK\u00104R\u0014\u0010L\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bL\u00104R\u0014\u0010M\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bM\u00104R\u0014\u0010N\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bN\u00104R\u0014\u0010O\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bO\u00104R\u0014\u0010P\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bP\u00104R\u0014\u0010Q\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bQ\u00104R\u0014\u0010R\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bR\u00104R\u0014\u0010S\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bS\u00104R\u0014\u0010T\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bT\u00104R\u0014\u0010U\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bU\u00104R\u0014\u0010V\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bV\u00104R\u0014\u0010W\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bW\u00104R\u0014\u0010X\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bX\u00104R\u0014\u0010Y\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bY\u00104R\u0014\u0010Z\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\bZ\u00104¨\u0006["}, d2 = {"LW4/c;", "", "<init>", "()V", "", "id", "s", "(Ljava/lang/String;)Ljava/lang/String;", "LY8/t;", "f", "agentType", "e", "(Ljava/lang/String;)V", "entrySource", "isStepaiLinked", "c", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "p", "stepType", "accountLinkResult", "q", "(Ljava/lang/String;Ljava/lang/String;)V", "", "stepNo", "stepAction", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;ILjava/lang/String;)V", "", "success", "errorCode", "pairedDeviceId", "m", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "entryType", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, c.CHOICE_AGREE, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Z)V", Const.INTENT_KEY_APIKEY, "pageSource", "l", "manageAction", "k", "confirmResult", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "event", "pageName", "", "params", "o", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "EVENT_AGENT_SELECT_SHOW", "Ljava/lang/String;", "EVENT_AGENT_SELECT_CLICK", "EVENT_AGENT_CONNECT_SHOW", "EVENT_STEPAI_CONNECT_SHOW", "EVENT_STEPAI_STEP_CLICK", "EVENT_CODEX_STEP_CLICK", "EVENT_PAIR_RESULT", "EVENT_CROSS_AUTH_EXPOSE", "EVENT_CROSS_AUTH_CLICK", "EVENT_ADD_AGENT_CLICK", "EVENT_DEVICE_MANAGE_SHOW", "EVENT_DEVICE_MANAGE_CLICK", "EVENT_DEVICE_DISCONNECT_CLICK", "PAGE_EXTAGENT", "PAGE_EXTAGENT_CONNECT", "PAGE_STEPAI_CONNECT", "PAGE_AGENT_DEVICE", "RESULT_SUCCESS", "RESULT_FAIL", "LINKED", "UNLINKED", "SOURCE_UNCONNECTED", "SOURCE_ADD_AGENT", "SOURCE_SIDEBAR", "STEP_DOWNLOAD_COPY", "STEP_ACCOUNT_LINK", "STEP_SCAN_PAIR", "ACTION_INSTALL_COPY", "ACTION_LAUNCH_COPY", "ACTION_SCAN_PAIR", "ENTRY_STEPAI", "ENTRY_REMOTE", "CHOICE_AGREE", "CHOICE_CANCEL", "MANAGE_RENAME", "MANAGE_RECONNECT", "MANAGE_DISCONNECT", "CONFIRM_YES", "CONFIRM_CANCEL", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class c {
    public static final String ACTION_INSTALL_COPY = "install_copy";
    public static final String ACTION_LAUNCH_COPY = "launch_copy";
    public static final String ACTION_SCAN_PAIR = "scan_pair";
    public static final String CHOICE_AGREE = "agree";
    public static final String CHOICE_CANCEL = "cancel";
    public static final String CONFIRM_CANCEL = "cancel";
    public static final String CONFIRM_YES = "confirm";
    public static final String ENTRY_REMOTE = "remote_agent";
    public static final String ENTRY_STEPAI = "stepai_desktop";
    private static final String EVENT_ADD_AGENT_CLICK = "extagent_add_agent_click";
    private static final String EVENT_AGENT_CONNECT_SHOW = "extagent_agent_connect_show";
    private static final String EVENT_AGENT_SELECT_CLICK = "extagent_agent_select_click";
    private static final String EVENT_AGENT_SELECT_SHOW = "extagent_agent_select_show";
    private static final String EVENT_CODEX_STEP_CLICK = "extagent_codex_step_click";
    private static final String EVENT_CROSS_AUTH_CLICK = "extagent_cross_auth_click";
    private static final String EVENT_CROSS_AUTH_EXPOSE = "extagent_cross_auth_expose";
    private static final String EVENT_DEVICE_DISCONNECT_CLICK = "device_disconnect_click";
    private static final String EVENT_DEVICE_MANAGE_CLICK = "extagent_device_manage_click";
    private static final String EVENT_DEVICE_MANAGE_SHOW = "device_manage_show";
    private static final String EVENT_PAIR_RESULT = "extagent_pair_result";
    private static final String EVENT_STEPAI_CONNECT_SHOW = "extagent_stepai_connect_show";
    private static final String EVENT_STEPAI_STEP_CLICK = "extagent_stepai_step_click";
    public static final c INSTANCE = new c();
    public static final String LINKED = "linked";
    public static final String MANAGE_DISCONNECT = "disconnect";
    public static final String MANAGE_RECONNECT = "reconnect";
    public static final String MANAGE_RENAME = "rename";
    private static final String PAGE_AGENT_DEVICE = "agent_device";
    private static final String PAGE_EXTAGENT = "extagent";
    private static final String PAGE_EXTAGENT_CONNECT = "extagent_connect";
    private static final String PAGE_STEPAI_CONNECT = "stepai_connect";
    public static final String RESULT_FAIL = "fail";
    public static final String RESULT_SUCCESS = "success";
    public static final String SOURCE_ADD_AGENT = "add_agent";
    public static final String SOURCE_SIDEBAR = "sidebar_agent";
    public static final String SOURCE_UNCONNECTED = "unconnected_entry";
    public static final String STEP_ACCOUNT_LINK = "account_link";
    public static final String STEP_DOWNLOAD_COPY = "download_copy";
    public static final String STEP_SCAN_PAIR = "scan_pair";
    public static final String UNLINKED = "unlinked";

    public static /* synthetic */ void b(c cVar, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        cVar.a(str);
    }

    public static /* synthetic */ void d(c cVar, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str3 = null;
        }
        cVar.c(str, str2, str3);
    }

    public static /* synthetic */ void n(c cVar, String str, boolean z10, String str2, String str3, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str2 = null;
        }
        if ((i10 & 8) != 0) {
            str3 = null;
        }
        cVar.m(str, z10, str2, str3);
    }

    public static /* synthetic */ void r(c cVar, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        cVar.q(str, str2);
    }

    public final void a(String agentType) {
        o(EVENT_ADD_AGENT_CLICK, PAGE_AGENT_DEVICE, Q.f(j.a("agent_type", s(agentType))));
    }

    public final void c(String agentType, String entrySource, String isStepaiLinked) {
        o(EVENT_AGENT_CONNECT_SHOW, PAGE_EXTAGENT_CONNECT, kotlin.collections.a.m(j.a("agent_type", s(agentType)), j.a("is_stepai_linked", isStepaiLinked), j.a("entry_source", entrySource)));
    }

    public final void e(String agentType) {
        o(EVENT_AGENT_SELECT_CLICK, PAGE_EXTAGENT, Q.f(j.a("agent_type", s(agentType))));
    }

    public final void f() {
        o(EVENT_AGENT_SELECT_SHOW, PAGE_EXTAGENT, kotlin.collections.a.i());
    }

    public final void g(String agentType, int stepNo, String stepAction) {
        p.i(stepAction, "stepAction");
        o(EVENT_CODEX_STEP_CLICK, PAGE_EXTAGENT_CONNECT, kotlin.collections.a.m(j.a("agent_type", s(agentType)), j.a("step_no", Integer.valueOf(stepNo)), j.a("step_action", stepAction)));
    }

    public final void h(boolean agree) {
        o(EVENT_CROSS_AUTH_CLICK, PAGE_EXTAGENT_CONNECT, Q.f(j.a("user_choice", agree ? CHOICE_AGREE : "cancel")));
    }

    public final void i(String entryType) {
        p.i(entryType, "entryType");
        o(EVENT_CROSS_AUTH_EXPOSE, PAGE_EXTAGENT_CONNECT, Q.f(j.a("entry_type", entryType)));
    }

    public final void j(String confirmResult, String pageSource) {
        p.i(confirmResult, "confirmResult");
        o(EVENT_DEVICE_DISCONNECT_CLICK, PAGE_AGENT_DEVICE, kotlin.collections.a.m(j.a("confirm_result", confirmResult), j.a("page_source", pageSource)));
    }

    public final void k(String manageAction, String pageSource) {
        p.i(manageAction, "manageAction");
        o(EVENT_DEVICE_MANAGE_CLICK, PAGE_AGENT_DEVICE, kotlin.collections.a.m(j.a("manage_action", manageAction), j.a("page_source", pageSource)));
    }

    public final void l(String pageSource) {
        o(EVENT_DEVICE_MANAGE_SHOW, PAGE_AGENT_DEVICE, Q.f(j.a("page_source", pageSource)));
    }

    public final void m(String agentType, boolean success, String errorCode, String pairedDeviceId) {
        Pair pairA = j.a("agent_type", s(agentType));
        Pair pairA2 = j.a("result", success ? "success" : "fail");
        if (errorCode == null || success || H.x0(errorCode)) {
            errorCode = null;
        }
        Pair pairA3 = j.a("error_code", errorCode);
        if (pairedDeviceId == null || !success) {
            pairedDeviceId = null;
        }
        o(EVENT_PAIR_RESULT, PAGE_EXTAGENT_CONNECT, kotlin.collections.a.m(pairA, pairA2, pairA3, j.a("paired_device_id", pairedDeviceId)));
    }

    public final void o(String event, String pageName, Map<String, ? extends Object> params) {
        HashMap map = new HashMap();
        for (Map.Entry<String, ? extends Object> entry : params.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value != null) {
                map.put(key, value.toString());
            }
        }
        N.a(event, pageName, map);
    }

    public final void p() {
        o(EVENT_STEPAI_CONNECT_SHOW, PAGE_STEPAI_CONNECT, kotlin.collections.a.i());
    }

    public final void q(String stepType, String accountLinkResult) {
        p.i(stepType, "stepType");
        o(EVENT_STEPAI_STEP_CLICK, PAGE_STEPAI_CONNECT, kotlin.collections.a.m(j.a("step_type", stepType), j.a("account_link_result", accountLinkResult)));
    }

    public final String s(String id) {
        String lowerCase;
        String string;
        if (id == null || (string = H.D1(id).toString()) == null) {
            lowerCase = null;
        } else {
            lowerCase = string.toLowerCase(Locale.ROOT);
            p.h(lowerCase, "toLowerCase(...)");
        }
        if (lowerCase == null) {
            return null;
        }
        int iHashCode = lowerCase.hashCode();
        if (iHashCode != -1357935714) {
            if (iHashCode != -892366860) {
                if (iHashCode == 0 && lowerCase.equals("")) {
                    return null;
                }
            } else if (lowerCase.equals(ConnectedAgentsActivity.FILTER_STEPAI)) {
                return ENTRY_STEPAI;
            }
        } else if (lowerCase.equals("claude")) {
            return "claude_code";
        }
        String lowerCase2 = H.D1(id).toString().toLowerCase(Locale.ROOT);
        p.h(lowerCase2, "toLowerCase(...)");
        return lowerCase2;
    }
}
