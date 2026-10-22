package com.stepos.ailauncher.chat.trace;

import Y8.j;
import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.N;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0013\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\u0003J'\u0010\u0011\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0013\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0012J\r\u0010\u0014\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\u0003J7\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00152\b\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J-\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00062\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0015H\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0014\u0010 \u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010\u001dR\u0014\u0010!\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\u001dR\u0014\u0010\"\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010\u001dR\u0014\u0010#\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010\u001dR\u0014\u0010$\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b$\u0010\u001dR\u0014\u0010%\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b%\u0010\u001dR\u0014\u0010&\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b&\u0010\u001dR\u0014\u0010'\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b'\u0010\u001d¨\u0006("}, d2 = {"Lcom/stepos/ailauncher/chat/trace/d;", "", "<init>", "()V", "LY8/t;", Const.INTENT_KEY_APIKEY, "", "action", "", "stayTimeSec", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;Ljava/lang/Long;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "cardId", "pageFrom", "", "position", Const.INTENT_KEY_UMID, "(Ljava/lang/String;Ljava/lang/String;I)V", "c", Const.INTENT_KEY_PKGNAME, "", "e", "(Ljava/lang/String;Ljava/lang/String;I)Ljava/util/Map;", "event", "params", "f", "(Ljava/lang/String;Ljava/util/Map;)V", "PAGE_NAME", "Ljava/lang/String;", "EVENT_AGENT_VIEW", "EVENT_SWITCH_SWIPE", "EVENT_TRADITIONAL_VIEW", "EVENT_CARD_EXPOSE", "EVENT_CARD_CLICK", "EVENT_ALLTASK_CLICK", "SWITCH_TO_TRADITIONAL", "SWITCH_TO_AGENT", "FROM_DESKTOP", "FROM_CHATVIEW", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class d {
    private static final String EVENT_AGENT_VIEW = "desktop_agent_view";
    private static final String EVENT_ALLTASK_CLICK = "desktop_alltask_click";
    private static final String EVENT_CARD_CLICK = "desktop_card_click";
    private static final String EVENT_CARD_EXPOSE = "desktop_card_expose";
    private static final String EVENT_SWITCH_SWIPE = "desktop_switch_swipe";
    private static final String EVENT_TRADITIONAL_VIEW = "desktop_traditional_view";
    public static final String FROM_CHATVIEW = "chatview";
    public static final String FROM_DESKTOP = "desktop";
    public static final d INSTANCE = new d();
    private static final String PAGE_NAME = "desktop";
    public static final String SWITCH_TO_AGENT = "agent";
    public static final String SWITCH_TO_TRADITIONAL = "app";

    public final void a() {
        f(EVENT_AGENT_VIEW, kotlin.collections.a.i());
    }

    public final void b() {
        f(EVENT_ALLTASK_CLICK, kotlin.collections.a.i());
    }

    public final void c(String cardId, String pageFrom, int position) {
        p.i(pageFrom, "pageFrom");
        f(EVENT_CARD_CLICK, e(cardId, pageFrom, position));
    }

    public final void d(String cardId, String pageFrom, int position) {
        p.i(pageFrom, "pageFrom");
        f(EVENT_CARD_EXPOSE, e(cardId, pageFrom, position));
    }

    public final Map<String, Object> e(String cardId, String pageFrom, int position) {
        return kotlin.collections.a.m(j.a("card_id", cardId), j.a("page_from", pageFrom), j.a("position", Integer.valueOf(position)));
    }

    public final void f(String event, Map<String, ? extends Object> params) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(params.size() + 1);
        Iterator<Map.Entry<String, ? extends Object>> it = params.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                linkedHashMap.put("page_name", "desktop");
                C4148a.k("Track", event + " page=desktop " + linkedHashMap, false, 4, null);
                N.a(event, "desktop", linkedHashMap);
                return;
            }
            Map.Entry<String, ? extends Object> next = it.next();
            String key = next.getKey();
            Object value = next.getValue();
            String string = value != null ? value.toString() : null;
            if (string == null) {
                string = "";
            }
            linkedHashMap.put(key, string);
        }
    }

    public final void g(String action, Long stayTimeSec) {
        p.i(action, "action");
        f(EVENT_SWITCH_SWIPE, kotlin.collections.a.m(j.a("action", action), j.a("stay_time", stayTimeSec)));
    }

    public final void h() {
        f(EVENT_TRADITIONAL_VIEW, kotlin.collections.a.i());
    }
}
