package com.stepos.ailauncher.task.space;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.weather.WeatherCardProvider;
import h8.C4148a;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0017\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\r\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0003J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJC\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014JC\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0015\u0010\u0014J\u0015\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0007¢\u0006\u0004\b\u0017\u0010\nJ\u0015\u0010\u0018\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0018\u0010\nJS\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00192\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ5\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0019H\u0002¢\u0006\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010\"R\u0014\u0010$\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010\"R\u0014\u0010%\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010\"R\u0014\u0010&\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b&\u0010\"R\u0014\u0010'\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010\"R\u0014\u0010(\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010\"R\u0014\u0010)\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b)\u0010\"R\u0014\u0010*\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010\"R\u0014\u0010+\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b+\u0010\"R\u0014\u0010,\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b,\u0010\"R\u0014\u0010-\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b-\u0010\"R\u0014\u0010.\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b.\u0010\"R\u0014\u0010/\u001a\u00020\u00078\u0006X\u0086T¢\u0006\u0006\n\u0004\b/\u0010\"¨\u00060"}, d2 = {"Lcom/stepos/ailauncher/task/space/a2;", "", "<init>", "()V", "LY8/t;", "e", Const.INTENT_KEY_UMID, "", "exposeType", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;)V", WeatherCardProvider.KEY_CARD_TYPE, "itemId", "itemName", "version", "", "hasNewVersion", "", "position", "c", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Integer;)V", Const.INTENT_KEY_PKGNAME, "clickType", "f", Const.INTENT_KEY_BACKGROUND_COMMAND, "", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Integer;)Ljava/util/Map;", "event", "pageName", "params", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "TAG", "Ljava/lang/String;", "EVENT_ENTRY_EXPOSE", "EVENT_ENTRY_CLICK", "EVENT_PAGE_SHOW", "EVENT_CARD_EXPOSE", "EVENT_CARD_CLICK", "EVENT_GUIDE_CLICK", "EVENT_GUIDE_SHOW", "PAGE_REPAIR", "PAGE_TEST", "TYPE_AGENT", "TYPE_SKILL", "NEW_VERSION_YES", "NEW_VERSION_NO", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.task.space.a2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3577a2 {
    private static final String EVENT_CARD_CLICK = "test_card_click";
    private static final String EVENT_CARD_EXPOSE = "test_card_expose";
    private static final String EVENT_ENTRY_CLICK = "repair_testspace_click";
    private static final String EVENT_ENTRY_EXPOSE = "repair_testspace_expose";
    private static final String EVENT_GUIDE_CLICK = "test_guide_click";
    private static final String EVENT_GUIDE_SHOW = "test_guide_show";
    private static final String EVENT_PAGE_SHOW = "test_page_show";
    public static final C3577a2 INSTANCE = new C3577a2();
    public static final String NEW_VERSION_NO = "no";
    public static final String NEW_VERSION_YES = "yes";
    private static final String PAGE_REPAIR = "repair";
    private static final String PAGE_TEST = "test";
    private static final String TAG = "TestSpaceTracker";
    public static final String TYPE_AGENT = "agent";
    public static final String TYPE_SKILL = "skill";

    public final Map<String, Object> a(String cardType, String itemId, String itemName, String version, boolean hasNewVersion, Integer position) {
        Pair pairA = Y8.j.a("card_type", cardType);
        Pair pairA2 = Y8.j.a("item_id", itemId);
        Pair pairA3 = Y8.j.a("item_name", itemName);
        Pair pairA4 = Y8.j.a("version", version);
        Pair pairA5 = Y8.j.a("has_new_version", hasNewVersion ? "yes" : "no");
        if (position == null || position.intValue() < 0) {
            position = null;
        }
        return kotlin.collections.a.m(pairA, pairA2, pairA3, pairA4, pairA5, Y8.j.a("position", position));
    }

    public final void b(String cardType, String itemId, String itemName, String version, boolean hasNewVersion, Integer position) {
        kotlin.jvm.internal.p.i(cardType, "cardType");
        kotlin.jvm.internal.p.i(itemId, "itemId");
        i(EVENT_CARD_CLICK, PAGE_TEST, a(cardType, itemId, itemName, version, hasNewVersion, position));
    }

    public final void c(String cardType, String itemId, String itemName, String version, boolean hasNewVersion, Integer position) {
        kotlin.jvm.internal.p.i(cardType, "cardType");
        kotlin.jvm.internal.p.i(itemId, "itemId");
        i(EVENT_CARD_EXPOSE, PAGE_TEST, a(cardType, itemId, itemName, version, hasNewVersion, position));
    }

    public final void d() {
        i(EVENT_ENTRY_CLICK, "repair", kotlin.collections.a.i());
    }

    public final void e() {
        i(EVENT_ENTRY_EXPOSE, "repair", kotlin.collections.a.i());
    }

    public final void f(String clickType) {
        kotlin.jvm.internal.p.i(clickType, "clickType");
        i(EVENT_GUIDE_CLICK, PAGE_TEST, Z8.Q.f(Y8.j.a("click_type", clickType)));
    }

    public final void g(String exposeType) {
        kotlin.jvm.internal.p.i(exposeType, "exposeType");
        i(EVENT_GUIDE_SHOW, PAGE_TEST, Z8.Q.f(Y8.j.a("expose_type", exposeType)));
    }

    public final void h(String exposeType) {
        kotlin.jvm.internal.p.i(exposeType, "exposeType");
        i(EVENT_PAGE_SHOW, PAGE_TEST, Z8.Q.f(Y8.j.a("expose_type", exposeType)));
    }

    public final void i(String event, String pageName, Map<String, ? extends Object> params) {
        HashMap map = new HashMap();
        for (Map.Entry<String, ? extends Object> entry : params.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value != null) {
                map.put(key, value.toString());
            }
        }
        C4148a.d(TAG, event + " " + map, false, 4, null);
        kotlin.N.a(event, pageName, map);
    }
}
