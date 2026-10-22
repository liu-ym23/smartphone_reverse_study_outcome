package com.stepos.ailauncher.chat.trace;

import Y8.j;
import Z8.Q;
import Z8.Y;
import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.N;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010$\n\u0002\b\u0011\n\u0002\u0010\"\n\u0002\b\u0017\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\r\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0003J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0003J#\u0010\f\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJQ\u0010\u0014\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0017\u0010\u0018J/\u0010\u001b\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001b\u0010\u001cJ/\u0010\u001e\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001e\u0010\u001cJ#\u0010\u001f\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001f\u0010 J-\u0010$\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\b2\u0014\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\"H\u0002¢\u0006\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010'R\u0014\u0010)\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b)\u0010'R\u0014\u0010*\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010'R\u0014\u0010+\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b+\u0010'R\u0014\u0010,\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b,\u0010'R\u0014\u0010-\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b-\u0010'R\u0014\u0010.\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b.\u0010'R\u0014\u0010/\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b/\u0010'R\u0014\u00100\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b0\u0010'R\u0014\u00101\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b1\u0010'R\u0014\u00102\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b2\u0010'R\u0014\u00103\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b3\u0010'R\u001a\u00105\u001a\b\u0012\u0004\u0012\u00020\b048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0014\u00107\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b7\u0010'R\u0014\u00108\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b8\u0010'R\u0014\u00109\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b9\u0010'R\u0014\u0010:\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b:\u0010'R\u0014\u0010;\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b;\u0010'R\u0014\u0010<\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b<\u0010'R\u0014\u0010=\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b=\u0010'R\u0014\u0010>\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b>\u0010'R\u0014\u0010?\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b?\u0010'R\u0014\u0010@\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b@\u0010'R\u0014\u0010A\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\bA\u0010'R\u0014\u0010B\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\bB\u0010'R\u0014\u0010C\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\bC\u0010'R\u0014\u0010D\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\bD\u0010'R\u0014\u0010E\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\bE\u0010'R\u0014\u0010F\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\bF\u0010'R\u0014\u0010G\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\bG\u0010'R\u0014\u0010H\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\bH\u0010'R\u0014\u0010I\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\bI\u0010'R\u0014\u0010J\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\bJ\u0010'¨\u0006K"}, d2 = {"Lcom/stepos/ailauncher/chat/trace/f;", "", "<init>", "()V", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "", "resultStatus", "", "hasTask", "k", "(Ljava/lang/String;Ljava/lang/Integer;)V", "sessionId", "chatId", "messageId", "entryType", "agentName", "agentType", "f", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "clickTarget", "e", "(Ljava/lang/String;)V", "actionType", "agentId", "c", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "buttonType", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_UMID, "(Ljava/lang/String;Ljava/lang/String;)V", "event", "", "params", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;Ljava/util/Map;)V", "PAGE_NAME", "Ljava/lang/String;", "EVENT_EXPOSE", "EVENT_AGENT_EXPOSE", "EVENT_SEARCH_INPUT", "EVENT_SEARCHRESULT_EXPOSE", "EVENT_CARD_CLICK", "EVENT_BUTTON_CLICK", "EVENT_AGENT_MANAGE_CLICK", "EVENT_AGENT_DISCONNECT_CONFIRM", "EVENT_AGENT_UNINSTALL_CONFIRM", "KEY_SESSION_ID", "KEY_CHAT_ID", "KEY_MESSAGE_ID", "", "IDENTITY_KEYS", "Ljava/util/Set;", "RESULT_SUCCESS", "RESULT_NO_RESULT", "ENTRY_AGENT", "ENTRY_HISTORY", "ENTRY_SEARCH", "ENTRY_TASK", "ENTRY_NEWCHAT", "CLICK_SIDEBAR_EXPAND", "CLICK_SIDEBAR_COLLAPSE", "CLICK_SEARCH", "CLICK_NEW_SESSION", "CLICK_SESSION_RENAME", "CLICK_SESSION_DELETE", "CLICK_NEW_AGENT", "ACTION_PIN", "ACTION_UNPIN", "ACTION_DISCONNECT", "ACTION_UNINSTALL", "BUTTON_CONFIRM", "BUTTON_CANCEL", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class f {
    public static final String ACTION_DISCONNECT = "disconnect";
    public static final String ACTION_PIN = "pin";
    public static final String ACTION_UNINSTALL = "uninstall";
    public static final String ACTION_UNPIN = "unpin";
    public static final String BUTTON_CANCEL = "cancel";
    public static final String BUTTON_CONFIRM = "confirm";
    public static final String CLICK_NEW_AGENT = "new_agent_click";
    public static final String CLICK_NEW_SESSION = "new_session_click";
    public static final String CLICK_SEARCH = "search_click";
    public static final String CLICK_SESSION_DELETE = "session_delete";
    public static final String CLICK_SESSION_RENAME = "session_rename";
    public static final String CLICK_SIDEBAR_COLLAPSE = "sidebar_collapse";
    public static final String CLICK_SIDEBAR_EXPAND = "sidebar_expand";
    public static final String ENTRY_AGENT = "agent";
    public static final String ENTRY_HISTORY = "history";
    public static final String ENTRY_NEWCHAT = "newchat";
    public static final String ENTRY_SEARCH = "search";
    public static final String ENTRY_TASK = "task";
    private static final String EVENT_AGENT_DISCONNECT_CONFIRM = "sidebar_agent_disconnect_confirm";
    private static final String EVENT_AGENT_EXPOSE = "sidebar_agent_expose";
    private static final String EVENT_AGENT_MANAGE_CLICK = "sidebar_agent_manage_click";
    private static final String EVENT_AGENT_UNINSTALL_CONFIRM = "sidebar_agent_uninstall_confirm";
    private static final String EVENT_BUTTON_CLICK = "sidebar_button_click";
    private static final String EVENT_CARD_CLICK = "sidebar_card_click";
    private static final String EVENT_EXPOSE = "sidebar_expose";
    private static final String EVENT_SEARCHRESULT_EXPOSE = "sidebar_searchresult_expose";
    private static final String EVENT_SEARCH_INPUT = "sidebar_search_input";
    private static final String KEY_MESSAGE_ID = "message_id";
    private static final String KEY_SESSION_ID = "session_id";
    private static final String PAGE_NAME = "sidebar";
    public static final String RESULT_NO_RESULT = "no_result";
    public static final String RESULT_SUCCESS = "success";
    public static final f INSTANCE = new f();
    private static final String KEY_CHAT_ID = "chat_id";
    private static final Set<String> IDENTITY_KEYS = Y.j("session_id", KEY_CHAT_ID, "message_id");

    public static /* synthetic */ void g(f fVar, String str, String str2, String str3, String str4, String str5, String str6, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        if ((i10 & 4) != 0) {
            str3 = null;
        }
        if ((i10 & 16) != 0) {
            str5 = null;
        }
        if ((i10 & 32) != 0) {
            str6 = null;
        }
        fVar.f(str, str2, str3, str4, str5, str6);
    }

    public final void a(String buttonType, String agentType, String agentId) {
        i(EVENT_AGENT_DISCONNECT_CONFIRM, kotlin.collections.a.m(j.a("button_type", buttonType), j.a("agent_type", b.INSTANCE.a(agentType)), j.a("agent_id", agentId)));
    }

    public final void b() {
        i(EVENT_AGENT_EXPOSE, kotlin.collections.a.i());
    }

    public final void c(String actionType, String agentType, String agentId) {
        i(EVENT_AGENT_MANAGE_CLICK, kotlin.collections.a.m(j.a("action_type", actionType), j.a("agent_type", b.INSTANCE.a(agentType)), j.a("agent_id", agentId)));
    }

    public final void d(String buttonType, String agentId) {
        i(EVENT_AGENT_UNINSTALL_CONFIRM, kotlin.collections.a.m(j.a("button_type", buttonType), j.a("agent_id", agentId)));
    }

    public final void e(String clickTarget) {
        i(EVENT_BUTTON_CLICK, Q.f(j.a("click_target", clickTarget)));
    }

    public final void f(String sessionId, String chatId, String messageId, String entryType, String agentName, String agentType) {
        i(EVENT_CARD_CLICK, kotlin.collections.a.m(j.a("session_id", sessionId), j.a(KEY_CHAT_ID, chatId), j.a("message_id", messageId), j.a("entry_type", entryType), j.a("agent_name", agentName), j.a("agent_type", b.INSTANCE.a(agentType))));
    }

    public final void h() {
        i(EVENT_EXPOSE, kotlin.collections.a.i());
    }

    public final void i(String event, Map<String, ? extends Object> params) {
        HashMap map = new HashMap();
        Iterator<Map.Entry<String, ? extends Object>> it = params.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                C4148a.d("Track", event + " page=sidebar " + map, false, 4, null);
                N.a(event, "sidebar", map);
                return;
            }
            Map.Entry<String, ? extends Object> next = it.next();
            String key = next.getKey();
            Object value = next.getValue();
            String string = value != null ? value.toString() : null;
            if (string == null) {
                string = "";
            }
            if (IDENTITY_KEYS.contains(key) || string.length() > 0) {
                map.put(key, string);
            }
        }
    }

    public final void j() {
        i(EVENT_SEARCH_INPUT, kotlin.collections.a.i());
    }

    public final void k(String resultStatus, Integer hasTask) {
        i(EVENT_SEARCHRESULT_EXPOSE, kotlin.collections.a.m(j.a("result_status", resultStatus), j.a("has_task", hasTask)));
    }
}
