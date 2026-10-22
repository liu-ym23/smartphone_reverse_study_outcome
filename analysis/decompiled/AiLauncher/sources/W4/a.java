package W4;

import La.H;
import Y8.j;
import Z8.Q;
import com.autonavi.aps.amapapi.config.Const;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.N;
import kotlin.Pair;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010$\n\u0002\b\u001b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\u001d\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0014J/\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0015¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u001e\u0010\u0014J7\u0010!\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b!\u0010\"J9\u0010$\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b$\u0010%J5\u0010*\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u00062\u0014\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010(H\u0002¢\u0006\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b.\u0010-R\u0014\u0010/\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b/\u0010-R\u0014\u00100\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b0\u0010-R\u0014\u00101\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b1\u0010-R\u0014\u00102\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b2\u0010-R\u0014\u00103\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b3\u0010-R\u0014\u00104\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b4\u0010-R\u0014\u00105\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b5\u0010-R\u0014\u00106\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b6\u0010-R\u0014\u00107\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b7\u0010-R\u0014\u00108\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b8\u0010-R\u0014\u00109\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b9\u0010-R\u0014\u0010:\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b:\u0010-R\u0014\u0010;\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b;\u0010-R\u0014\u0010<\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b<\u0010-R\u0014\u0010=\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b=\u0010-R\u0014\u0010>\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b>\u0010-R\u0014\u0010?\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b?\u0010-R\u0014\u0010@\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b@\u0010-R\u0014\u0010A\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\bA\u0010-R\u0014\u0010B\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\bB\u0010-¨\u0006C"}, d2 = {"LW4/a;", "", "<init>", "()V", "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "", "agentId", "", "position", "f", "(Ljava/lang/String;I)V", "entryType", "c", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "installStatus", "version", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)V", "", "success", "failReason", "e", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "source", "enable", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;Z)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "fromVersion", "toVersion", "k", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "step", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "event", "pageName", "", "params", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "EVENT_PAGE_SHOW", "Ljava/lang/String;", "EVENT_LIST_EXPOSE", "EVENT_ENTRY_CLICK", "EVENT_DETAIL_SHOW", "EVENT_INSTALL_CLICK", "EVENT_INSTALL_RESULT", "EVENT_ENABLE_CHANGE", "EVENT_UPDATE_CLICK", "EVENT_UPDATE_RESULT", "EVENT_UNINSTALL_CLICK", "RESULT_SUCCESS", "RESULT_FAIL", "ENABLE_ON", "ENABLE_OFF", "SOURCE_DETAIL", "SOURCE_LIST", "ENTRY_AGENT_CARD", "ENTRY_MY_AGENT", "ENTRY_CONNECT_REMOTE", "ENTRY_TEST_ZONE", "PAGE_MARKET", "PAGE_AGENT_DETAIL", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a {
    public static final String ENABLE_OFF = "off";
    public static final String ENABLE_ON = "on";
    public static final String ENTRY_AGENT_CARD = "agent_card";
    public static final String ENTRY_CONNECT_REMOTE = "connect_remote";
    public static final String ENTRY_MY_AGENT = "my_agent";
    public static final String ENTRY_TEST_ZONE = "test_zone";
    private static final String EVENT_DETAIL_SHOW = "market_agent_detail_show";
    private static final String EVENT_ENABLE_CHANGE = "market_agent_enable_change";
    private static final String EVENT_ENTRY_CLICK = "market_agent_entry_click";
    private static final String EVENT_INSTALL_CLICK = "market_agent_install_click";
    private static final String EVENT_INSTALL_RESULT = "market_agent_install_result";
    private static final String EVENT_LIST_EXPOSE = "market_agent_list_expose";
    private static final String EVENT_PAGE_SHOW = "market_agent_page_show";
    private static final String EVENT_UNINSTALL_CLICK = "market_agent_uninstall_click";
    private static final String EVENT_UPDATE_CLICK = "market_agent_update_click";
    private static final String EVENT_UPDATE_RESULT = "market_agent_update_result";
    public static final a INSTANCE = new a();
    private static final String PAGE_AGENT_DETAIL = "agent_detail";
    private static final String PAGE_MARKET = "market";
    public static final String RESULT_FAIL = "fail";
    public static final String RESULT_SUCCESS = "success";
    public static final String SOURCE_DETAIL = "detail_page";
    public static final String SOURCE_LIST = "market_list";

    public final void a(String agentId, String installStatus, String version) {
        p.i(agentId, "agentId");
        p.i(installStatus, "installStatus");
        p.i(version, "version");
        h(EVENT_DETAIL_SHOW, PAGE_AGENT_DETAIL, kotlin.collections.a.m(j.a("agent_id", agentId), j.a("install_status", installStatus), j.a("version", version)));
    }

    public final void b(String agentId, String source, boolean enable) {
        p.i(agentId, "agentId");
        p.i(source, "source");
        h(EVENT_ENABLE_CHANGE, PAGE_AGENT_DETAIL, kotlin.collections.a.m(j.a("agent_id", agentId), j.a("source", source), j.a("enable_status", enable ? ENABLE_ON : ENABLE_OFF)));
    }

    public final void c(String entryType, String agentId, Integer position) {
        p.i(entryType, "entryType");
        h(EVENT_ENTRY_CLICK, "market", kotlin.collections.a.m(j.a("entry_type", entryType), j.a("agent_id", agentId), j.a("position", position)));
    }

    public final void d(String agentId) {
        p.i(agentId, "agentId");
        h(EVENT_INSTALL_CLICK, PAGE_AGENT_DETAIL, Q.f(j.a("agent_id", agentId)));
    }

    public final void e(String agentId, String version, boolean success, String failReason) {
        p.i(agentId, "agentId");
        p.i(version, "version");
        Pair pairA = j.a("agent_id", agentId);
        Pair pairA2 = j.a("version", version);
        Pair pairA3 = j.a("result", success ? "success" : "fail");
        if (failReason == null || success || H.x0(failReason)) {
            failReason = null;
        }
        h(EVENT_INSTALL_RESULT, PAGE_AGENT_DETAIL, kotlin.collections.a.m(pairA, pairA2, pairA3, j.a("fail_reason", failReason)));
    }

    public final void f(String agentId, int position) {
        p.i(agentId, "agentId");
        h(EVENT_LIST_EXPOSE, "market", kotlin.collections.a.m(j.a("agent_id", agentId), j.a("position", Integer.valueOf(position))));
    }

    public final void g() {
        h(EVENT_PAGE_SHOW, "market", kotlin.collections.a.i());
    }

    public final void h(String event, String pageName, Map<String, ? extends Object> params) {
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

    public final void i(String agentId, boolean success, String source, String step, String failReason) {
        p.i(agentId, "agentId");
        p.i(source, "source");
        Pair pairA = j.a("agent_id", agentId);
        Pair pairA2 = j.a("result", success ? "success" : "fail");
        Pair pairA3 = j.a("source", source);
        Pair pairA4 = j.a("step", step);
        if (failReason == null || success || H.x0(failReason)) {
            failReason = null;
        }
        h(EVENT_UNINSTALL_CLICK, PAGE_AGENT_DETAIL, kotlin.collections.a.m(pairA, pairA2, pairA3, pairA4, j.a("fail_reason", failReason)));
    }

    public final void j(String agentId) {
        p.i(agentId, "agentId");
        h(EVENT_UPDATE_CLICK, PAGE_AGENT_DETAIL, Q.f(j.a("agent_id", agentId)));
    }

    public final void k(String agentId, String fromVersion, String toVersion, boolean success, String failReason) {
        p.i(agentId, "agentId");
        p.i(fromVersion, "fromVersion");
        p.i(toVersion, "toVersion");
        Pair pairA = j.a("agent_id", agentId);
        Pair pairA2 = j.a("from_version", fromVersion);
        Pair pairA3 = j.a("to_version", toVersion);
        Pair pairA4 = j.a("result", success ? "success" : "fail");
        if (failReason == null || success || H.x0(failReason)) {
            failReason = null;
        }
        h(EVENT_UPDATE_RESULT, PAGE_AGENT_DETAIL, kotlin.collections.a.m(pairA, pairA2, pairA3, pairA4, j.a("fail_reason", failReason)));
    }
}
