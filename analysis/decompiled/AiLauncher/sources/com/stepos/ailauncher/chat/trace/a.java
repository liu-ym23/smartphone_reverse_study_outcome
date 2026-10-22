package com.stepos.ailauncher.chat.trace;

import Y8.j;
import Z8.Q;
import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.N;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010$\n\u0002\b\u0019\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\n\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010\u000bJ+\u0010\u000e\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0014\u0010\u0012J\u0017\u0010\u0016\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0016\u0010\u0017J5\u0010\u001a\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u001d\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001d\u0010\u001eJ5\u0010#\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u00042\u0014\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010!H\u0002¢\u0006\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010&R\u0014\u0010(\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010&R\u0014\u0010)\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b)\u0010&R\u0014\u0010*\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010&R\u0014\u0010+\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b+\u0010&R\u0014\u0010,\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b,\u0010&R\u0014\u0010-\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b-\u0010&R\u0014\u0010.\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b.\u0010&R\u0014\u0010/\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b/\u0010&R\u0014\u00100\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b0\u0010&R\u0014\u00101\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b1\u0010&R\u0014\u00102\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b2\u0010&R\u0014\u00103\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b3\u0010&R\u0014\u00104\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b4\u0010&R\u0014\u00105\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b5\u0010&R\u0014\u00106\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b6\u0010&R\u0014\u00107\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b7\u0010&R\u0014\u00108\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b8\u0010&R\u0014\u00109\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b9\u0010&¨\u0006:"}, d2 = {"Lcom/stepos/ailauncher/chat/trace/a;", "", "<init>", "()V", "", "exposeType", "", "appId", "appName", "LY8/t;", "f", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;)V", "", "position", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;)V", "entryType", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)V", "query", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "appCount", "e", "(Ljava/lang/Integer;)V", "version", "installStatus", "c", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "buttonType", Const.INTENT_KEY_APIKEY, "(Ljava/lang/Long;Ljava/lang/String;)V", "event", "pageName", "", "params", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "PAGE_MARKET", "Ljava/lang/String;", "PAGE_APP_DETAIL", "EVENT_PAGE_SHOW", "EVENT_CARD_CLICK", "EVENT_ENTRY_CLICK", "EVENT_SEARCH", "EVENT_INSTALLED_SHOW", "EVENT_DETAIL_SHOW", "EVENT_BUTTON_CLICK", "EXPOSE_CARD", "EXPOSE_SEARCH", "EXPOSE_INSTALLED", "ENTRY_SEARCH", "ENTRY_INSTALLED", "INSTALL_INSTALLED", "INSTALL_UNINSTALLED", "BUTTON_DOWNLOAD", "BUTTON_UPDATE", "BUTTON_OPEN", "BUTTON_UNINSTALL", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a {
    public static final String BUTTON_DOWNLOAD = "download";
    public static final String BUTTON_OPEN = "open";
    public static final String BUTTON_UNINSTALL = "uninstall";
    public static final String BUTTON_UPDATE = "update";
    public static final String ENTRY_INSTALLED = "installed";
    public static final String ENTRY_SEARCH = "search";
    private static final String EVENT_BUTTON_CLICK = "market_app_button_click";
    private static final String EVENT_CARD_CLICK = "market_app_card_click";
    private static final String EVENT_DETAIL_SHOW = "market_app_detail_show";
    private static final String EVENT_ENTRY_CLICK = "market_app_entry_click";
    private static final String EVENT_INSTALLED_SHOW = "market_app_installed_show";
    private static final String EVENT_PAGE_SHOW = "market_app_page_show";
    private static final String EVENT_SEARCH = "market_app_search";
    public static final String EXPOSE_CARD = "card";
    public static final String EXPOSE_INSTALLED = "installed";
    public static final String EXPOSE_SEARCH = "search";
    public static final String INSTALL_INSTALLED = "installed";
    public static final String INSTALL_UNINSTALLED = "uninstalled";
    public static final a INSTANCE = new a();
    private static final String PAGE_APP_DETAIL = "app_detail";
    private static final String PAGE_MARKET = "market";

    public static /* synthetic */ void g(a aVar, String str, Long l10, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            l10 = null;
        }
        if ((i10 & 4) != 0) {
            str2 = null;
        }
        aVar.f(str, l10, str2);
    }

    public final void a(Long appId, String buttonType) {
        h(EVENT_BUTTON_CLICK, PAGE_APP_DETAIL, kotlin.collections.a.m(j.a("app_id", appId), j.a("button_type", buttonType)));
    }

    public final void b(Long appId, String appName, Integer position) {
        h(EVENT_CARD_CLICK, "market", kotlin.collections.a.m(j.a("app_id", appId), j.a("app_name", appName), j.a("position", position)));
    }

    public final void c(Long appId, String appName, String version, String installStatus) {
        h(EVENT_DETAIL_SHOW, PAGE_APP_DETAIL, kotlin.collections.a.m(j.a("app_id", appId), j.a("app_name", appName), j.a("version", version), j.a("install_status", installStatus)));
    }

    public final void d(String entryType) {
        h(EVENT_ENTRY_CLICK, "market", Q.f(j.a("entry_type", entryType)));
    }

    public final void e(Integer appCount) {
        h(EVENT_INSTALLED_SHOW, "market", Q.f(j.a("app_count", appCount)));
    }

    public final void f(String exposeType, Long appId, String appName) {
        h(EVENT_PAGE_SHOW, "market", kotlin.collections.a.m(j.a("expose_type", exposeType), j.a("app_id", appId), j.a("app_name", appName)));
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
        C4148a.k("Track", event + " page=" + pageName + " " + map, false, 4, null);
        N.a(event, pageName, map);
    }

    public final void i(String query) {
        h(EVENT_SEARCH, "market", Q.f(j.a("query", query)));
    }
}
