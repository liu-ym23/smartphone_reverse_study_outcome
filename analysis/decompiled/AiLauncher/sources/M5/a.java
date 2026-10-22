package M5;

import La.H;
import Y8.j;
import Y8.t;
import Z8.Q;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.weather.WeatherCardProvider;
import h8.C4148a;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.N;
import kotlin.Pair;
import kotlin.Result;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0013\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ1\u0010\r\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ)\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0015\u0010\u0016J5\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010 R\u0014\u0010\"\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010 R\u0014\u0010#\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010 R\u0014\u0010$\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010 R\u0014\u0010%\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010 R\u0014\u0010&\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b&\u0010 R\u0014\u0010'\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b'\u0010 R\u0014\u0010(\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b(\u0010 R\u0014\u0010)\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b)\u0010 R\u0014\u0010*\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b*\u0010 ¨\u0006+"}, d2 = {"LM5/a;", "", "<init>", "()V", "", "cardId", WeatherCardProvider.KEY_CARD_TYPE, "LY8/t;", "c", "(Ljava/lang/String;Ljava/lang/String;)V", "action", "", "optionIndex", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "fromKey", "toKey", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "label", "", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)Z", "sceneEvent", "", "extra", "e", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "key", "f", "(Ljava/lang/String;)Ljava/lang/String;", "TAG", "Ljava/lang/String;", "EVENT", "PAGE_NAME", "SCENE_CARD_SHOW", "SCENE_ACTION_CLICK", "SCENE_TRAVEL_MODE_SWITCH", "CARD_TYPE_ROUTE", "CARD_TYPE_POI_DETAIL", "CARD_TYPE_OVERVIEW", "ACTION_START_NAV", "ACTION_OPTION_SELECT", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a {
    public static final String ACTION_OPTION_SELECT = "option_select";
    public static final String ACTION_START_NAV = "start_nav";
    public static final String CARD_TYPE_OVERVIEW = "overview";
    public static final String CARD_TYPE_POI_DETAIL = "poi_detail";
    public static final String CARD_TYPE_ROUTE = "route";
    private static final String EVENT = "amap_biz_event";
    public static final a INSTANCE = new a();
    private static final String PAGE_NAME = "chatview";
    private static final String SCENE_ACTION_CLICK = "amap_card_action_click";
    private static final String SCENE_CARD_SHOW = "amap_card_show";
    private static final String SCENE_TRAVEL_MODE_SWITCH = "amap_travel_mode_switch";
    private static final String TAG = "AmapBizTracker";

    public static /* synthetic */ void b(a aVar, String str, String str2, String str3, Integer num, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            num = null;
        }
        aVar.a(str, str2, str3, num);
    }

    public final void a(String cardId, String cardType, String action, Integer optionIndex) {
        p.i(cardId, "cardId");
        p.i(cardType, "cardType");
        p.i(action, "action");
        Pair pairA = j.a("card_type", cardType);
        Pair pairA2 = j.a("action", action);
        String strValueOf = null;
        if (optionIndex != null) {
            if (optionIndex.intValue() < 0) {
                optionIndex = null;
            }
            if (optionIndex != null) {
                strValueOf = String.valueOf(optionIndex.intValue());
            }
        }
        e(SCENE_ACTION_CLICK, cardId, kotlin.collections.a.m(pairA, pairA2, j.a("option_index", strValueOf)));
    }

    public final void c(String cardId, String cardType) {
        p.i(cardId, "cardId");
        p.i(cardType, "cardType");
        if (H.x0(cardId)) {
            return;
        }
        e(SCENE_CARD_SHOW, cardId, Q.f(j.a("card_type", cardType)));
    }

    public final boolean d(String label) {
        String string = label != null ? H.D1(label).toString() : null;
        if (string == null) {
            string = "";
        }
        return string.length() > 0 && !p.d(string, "查看行程") && H.g0(string, "导航", false, 2, null);
    }

    public final void e(String sceneEvent, String cardId, Map<String, String> extra) {
        String str;
        Object objB;
        if (H.x0(cardId)) {
            cardId = null;
        }
        if (cardId == null) {
            return;
        }
        LinkedHashMap linkedHashMapL = kotlin.collections.a.l(j.a("card_id", cardId), j.a("scene_event", sceneEvent));
        for (Map.Entry<String, String> entry : extra.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (value != null && !H.x0(value)) {
                linkedHashMapL.put(key, value);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(Q.e(linkedHashMapL.size()));
        Iterator it = linkedHashMapL.entrySet().iterator();
        while (true) {
            str = "";
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry2 = (Map.Entry) it.next();
            Object key2 = entry2.getKey();
            String str2 = (String) entry2.getValue();
            if (str2 != null) {
                str = str2;
            }
            linkedHashMap.put(key2, str);
        }
        C4148a.k("Track", linkedHashMap.toString(), false, 4, null);
        try {
            Result.Companion companion = Result.INSTANCE;
            N.a(EVENT, "chatview", linkedHashMap);
            objB = Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            String message = thE.getMessage();
            C4148a.u(TAG, message != null ? message : "", false, 4, null);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c6 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String f(java.lang.String r5) {
        /*
            r4 = this;
            r4 = 0
            if (r5 == 0) goto L1a
            java.lang.CharSequence r5 = La.H.D1(r5)
            java.lang.String r5 = r5.toString()
            if (r5 == 0) goto L1a
            java.util.Locale r0 = java.util.Locale.ROOT
            java.lang.String r5 = r5.toLowerCase(r0)
            java.lang.String r0 = "toLowerCase(...)"
            kotlin.jvm.internal.p.h(r5, r0)
            goto L1b
        L1a:
            r5 = r4
        L1b:
            if (r5 == 0) goto Lc7
            int r0 = r5.hashCode()
            java.lang.String r1 = "riding"
            java.lang.String r2 = "walking"
            java.lang.String r3 = "driving"
            switch(r0) {
                case -931190859: goto Lbf;
                case -117759745: goto Lb6;
                case 98260: goto Lac;
                case 817011: goto La2;
                case 887175: goto L97;
                case 1261531: goto L8d;
                case 1262760: goto L83;
                case 3023841: goto L7a;
                case 3148910: goto L71;
                case 3500280: goto L67;
                case 3552798: goto L5d;
                case 3641801: goto L52;
                case 95852938: goto L48;
                case 1118815609: goto L40;
                case 1227428899: goto L36;
                case 1920367559: goto L2e;
                default: goto L2c;
            }
        L2c:
            goto Lc7
        L2e:
            boolean r5 = r5.equals(r3)
            if (r5 != 0) goto Lb5
            goto Lc7
        L36:
            java.lang.String r0 = "cycling"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto Lc6
            goto Lc7
        L40:
            boolean r5 = r5.equals(r2)
            if (r5 != 0) goto La1
            goto Lc7
        L48:
            java.lang.String r0 = "drive"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto Lb5
            goto Lc7
        L52:
            java.lang.String r0 = "walk"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto La1
            goto Lc7
        L5d:
            java.lang.String r0 = "taxi"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto Lb5
            goto Lc7
        L67:
            java.lang.String r0 = "ride"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto Lc6
            goto Lc7
        L71:
            java.lang.String r0 = "foot"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto La1
            goto Lc7
        L7a:
            java.lang.String r0 = "bike"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto Lc6
            goto Lc7
        L83:
            java.lang.String r0 = "驾车"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto Lb5
            goto Lc7
        L8d:
            java.lang.String r0 = "骑行"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto Lc6
            goto Lc7
        L97:
            java.lang.String r0 = "步行"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto La1
            goto Lc7
        La1:
            return r2
        La2:
            java.lang.String r0 = "打车"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto Lb5
            goto Lc7
        Lac:
            java.lang.String r0 = "car"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto Lb5
            goto Lc7
        Lb5:
            return r3
        Lb6:
            java.lang.String r0 = "bicycle"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto Lc6
            goto Lc7
        Lbf:
            boolean r5 = r5.equals(r1)
            if (r5 != 0) goto Lc6
            goto Lc7
        Lc6:
            return r1
        Lc7:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: M5.a.f(java.lang.String):java.lang.String");
    }

    public final void g(String cardId, String fromKey, String toKey) {
        p.i(cardId, "cardId");
        e(SCENE_TRAVEL_MODE_SWITCH, cardId, kotlin.collections.a.m(j.a("from_mode", f(fromKey)), j.a("to_mode", f(toKey))));
    }
}
