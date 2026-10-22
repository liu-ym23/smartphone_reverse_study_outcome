package N5;

import La.H;
import Z8.F;
import Z8.Y;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.intent.tool.TripartiteAppUiCoercion;
import com.stepos.ailauncher.foundation.appui.card.provider.alipay.AlipayXuiLiveClickReceiver;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.q0;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001:\u0002-5B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bJ-\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J7\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0014\u0010\u0015JC\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJQ\u0010\u001f\u001a\u0004\u0018\u00010\u000e2\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r2\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r2\u0012\u0010\u001e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\u001d\"\u00020\u000eH\u0002¢\u0006\u0004\b\u001f\u0010 J3\u0010%\u001a\u00020$*\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010!2\u0006\u0010\"\u001a\u00020\u000e2\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b%\u0010&J)\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\rH\u0002¢\u0006\u0004\b'\u0010(J1\u0010-\u001a\u00020$2\b\u0010#\u001a\u0004\u0018\u00010\u00012\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000e0)2\b\b\u0002\u0010,\u001a\u00020+H\u0002¢\u0006\u0004\b-\u0010.R\u0014\u0010/\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00101\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b1\u00100R\u001a\u00103\u001a\b\u0012\u0004\u0012\u00020\u000e028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104¨\u00066"}, d2 = {"LN5/y;", "", "<init>", "()V", "LN5/i;", "envelope", "LN5/y$a;", "e", "(LN5/i;)LN5/y$a;", "LN5/y$b;", "c", "(LN5/i;)LN5/y$b;", "detection", "", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(LN5/i;LN5/y$b;)Ljava/util/Map;", "raw", "displayName", "vendor", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;", "label", AlipayXuiLiveClickReceiver.EXTRA_APP_LINK, "webLink", "f", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;", "primary", "fallback", "", "keys", Const.INTENT_KEY_UMID, "(Ljava/util/Map;Ljava/util/Map;[Ljava/lang/String;)Ljava/lang/String;", "", "key", UxipConstants.f30680s, "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/util/Map;Ljava/lang/String;Ljava/lang/Object;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/util/Map;)Ljava/util/Map;", "", "out", "", "depth", Const.INTENT_KEY_APIKEY, "(Ljava/lang/Object;Ljava/util/List;I)V", "TEMPLATE_TAXI", "Ljava/lang/String;", "TEMPLATE_OAUTH_AUTHORIZE", "", "compatTemplates", "Ljava/util/Set;", Const.INTENT_KEY_PKGNAME, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class y {
    private static final String TEMPLATE_TAXI = "taxi";
    public static final y INSTANCE = new y();
    private static final String TEMPLATE_OAUTH_AUTHORIZE = "oauth-authorize";
    private static final Set<String> compatTemplates = Y.j(TripartiteAppUiCoercion.CARD_CENTER_ALIAS, TEMPLATE_OAUTH_AUTHORIZE);

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0012\u0010\b¨\u0006\u0013"}, d2 = {"LN5/y$b;", "", "", "vendor", "reason", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: N5.y$b, reason: from toString */
    public static final /* data */ class VendorDetection {
        private final String reason;
        private final String vendor;

        public VendorDetection(String vendor, String reason) {
            kotlin.jvm.internal.p.i(vendor, "vendor");
            kotlin.jvm.internal.p.i(reason, "reason");
            this.vendor = vendor;
            this.reason = reason;
        }

        /* renamed from: a, reason: from getter */
        public final String getReason() {
            return this.reason;
        }

        /* renamed from: b, reason: from getter */
        public final String getVendor() {
            return this.vendor;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VendorDetection)) {
                return false;
            }
            VendorDetection vendorDetection = (VendorDetection) other;
            return kotlin.jvm.internal.p.d(this.vendor, vendorDetection.vendor) && kotlin.jvm.internal.p.d(this.reason, vendorDetection.reason);
        }

        public int hashCode() {
            return (this.vendor.hashCode() * 31) + this.reason.hashCode();
        }

        public String toString() {
            return "VendorDetection(vendor=" + this.vendor + ", reason=" + this.reason + ")";
        }
    }

    public static /* synthetic */ void b(y yVar, Object obj, List list, int i10, int i11, Object obj2) {
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        yVar.a(obj, list, i10);
    }

    public final void a(Object value, List<String> out, int depth) {
        if (depth > 4 || out.size() > 80) {
            return;
        }
        if (value instanceof String) {
            String strD = j.INSTANCE.d((String) value);
            if (strD != null) {
                out.add(strD);
                return;
            }
            return;
        }
        if (!(value instanceof Map)) {
            if (value instanceof Iterable) {
                Iterator it = ((Iterable) value).iterator();
                while (it.hasNext()) {
                    INSTANCE.a(it.next(), out, depth + 1);
                }
                return;
            }
            return;
        }
        for (Map.Entry entry : ((Map) value).entrySet()) {
            Object key = entry.getKey();
            Object value2 = entry.getValue();
            String str = key instanceof String ? (String) key : null;
            if (str != null) {
                out.add(str);
            }
            INSTANCE.a(value2, out, depth + 1);
        }
    }

    public final VendorDetection c(CardEnvelope envelope) {
        String web;
        String app;
        ArrayList arrayList = new ArrayList();
        j jVar = j.INSTANCE;
        String strD = jVar.d(envelope.getBizChannel());
        if (strD != null) {
            arrayList.add(strD);
        }
        String strD2 = jVar.d(envelope.getTaskTitle());
        if (strD2 != null) {
            arrayList.add(strD2);
        }
        CardSummary summary = envelope.getSummary();
        String strD3 = jVar.d(summary != null ? summary.getTitle() : null);
        if (strD3 != null) {
            arrayList.add(strD3);
        }
        CardSummary summary2 = envelope.getSummary();
        String strD4 = jVar.d(summary2 != null ? summary2.getDesc() : null);
        if (strD4 != null) {
            arrayList.add(strD4);
        }
        CardLinks links = envelope.getLinks();
        if (links != null && (app = links.getApp()) != null) {
            arrayList.add(app);
        }
        CardLinks links2 = envelope.getLinks();
        if (links2 != null && (web = links2.getWeb()) != null) {
            arrayList.add(web);
        }
        b(this, envelope.e(), arrayList, 0, 4, null);
        String lowerCase = F.A0(arrayList, "|", null, null, 0, null, null, 62, null).toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
        if (H.g0(lowerCase, q0.CAOCAO, false, 2, null) || H.g0(lowerCase, "曹操", false, 2, null) || H.g0(lowerCase, "cn.caocaokeji.user", false, 2, null)) {
            return new VendorDetection(q0.CAOCAO, "caocao_keyword");
        }
        if (H.g0(lowerCase, q0.DIDI, false, 2, null) || H.g0(lowerCase, "滴滴", false, 2, null) || H.g0(lowerCase, "com.sdu.didi.psnger", false, 2, null)) {
            return new VendorDetection(q0.DIDI, "didi_keyword");
        }
        return null;
    }

    public final String d(Map<String, ? extends Object> primary, Map<String, ? extends Object> fallback, String... keys) {
        int length = keys.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                return null;
            }
            String str = keys[i10];
            j jVar = j.INSTANCE;
            Object obj = primary.get(str);
            String strD = jVar.d(obj instanceof String ? (String) obj : null);
            if (strD != null) {
                return strD;
            }
            Object obj2 = fallback.get(str);
            String strD2 = jVar.d(obj2 instanceof String ? (String) obj2 : null);
            if (strD2 != null) {
                return strD2;
            }
            i10++;
        }
    }

    public final Result e(CardEnvelope envelope) {
        kotlin.jvm.internal.p.i(envelope, "envelope");
        j jVar = j.INSTANCE;
        String strD = jVar.d(envelope.getTemplateType());
        if (strD == null) {
            strD = "";
        }
        if (!compatTemplates.contains(strD)) {
            return new Result(envelope, strD, strD, null, null, 24, null);
        }
        VendorDetection vendorDetectionC = c(envelope);
        if (vendorDetectionC == null) {
            return new Result(envelope, strD, strD, null, null, 24, null);
        }
        String str = strD;
        String strD2 = jVar.d(envelope.getBizChannel());
        if (strD2 == null) {
            strD2 = vendorDetectionC.getVendor();
        }
        return new Result(CardEnvelope.b(envelope, "taxi", null, null, null, null, null, 91, null, strD2, null, null, null, null, h(envelope, vendorDetectionC), null, null, null, 122558, null), str, "taxi", vendorDetectionC.getVendor(), vendorDetectionC.getReason());
    }

    public final Map<String, Object> f(Object raw, String label, String appLink, String webLink) {
        Map<String, Object> linkedHashMap;
        Map<String, Object> mapJ;
        Map<?, ?> map = raw instanceof Map ? (Map) raw : null;
        if (map == null || (mapJ = j(map)) == null || (linkedHashMap = kotlin.collections.a.C(mapJ)) == null) {
            linkedHashMap = new LinkedHashMap<>();
        }
        i(linkedHashMap, "actionType", "open_link");
        i(linkedHashMap, "label", label);
        if (appLink != null) {
            INSTANCE.i(linkedHashMap, AlipayXuiLiveClickReceiver.EXTRA_APP_LINK, appLink);
        }
        if (webLink != null) {
            INSTANCE.i(linkedHashMap, "webLink", webLink);
        }
        return linkedHashMap;
    }

    public final Map<String, Object> g(Object raw, String displayName, String vendor) {
        Map<String, Object> linkedHashMap;
        Map<String, Object> mapJ;
        Map<?, ?> map = raw instanceof Map ? (Map) raw : null;
        if (map == null || (mapJ = j(map)) == null || (linkedHashMap = kotlin.collections.a.C(mapJ)) == null) {
            linkedHashMap = new LinkedHashMap<>();
        }
        i(linkedHashMap, "appName", displayName);
        i(linkedHashMap, "appId", kotlin.jvm.internal.p.d(vendor, q0.CAOCAO) ? "cn.caocaokeji.user" : "com.sdu.didi.psnger");
        return linkedHashMap;
    }

    public final Map<String, Object> h(CardEnvelope envelope, VendorDetection detection) {
        Map<String, ? extends Object> linkedHashMap;
        Map<String, Object> mapE = envelope.e();
        if (mapE == null || (linkedHashMap = kotlin.collections.a.C(mapE)) == null) {
            linkedHashMap = new LinkedHashMap<>();
        }
        Object obj = linkedHashMap.get(DidiCardProvider.KEY_ORDER);
        Map<?, ?> map = obj instanceof Map ? (Map) obj : null;
        Map<String, ? extends Object> mapJ = map != null ? j(map) : null;
        if (mapJ == null) {
            mapJ = linkedHashMap;
        }
        Map<String, ? extends Object> mapC = kotlin.collections.a.C(mapJ);
        String str = kotlin.jvm.internal.p.d(detection.getVendor(), q0.CAOCAO) ? "曹操出行" : "滴滴出行";
        String strD = d(mapC, linkedHashMap, "title", "authTitle", "name");
        if (strD == null) {
            j jVar = j.INSTANCE;
            CardSummary summary = envelope.getSummary();
            strD = jVar.d(summary != null ? summary.getTitle() : null);
            if (strD == null) {
                strD = "请求" + str + "授权";
            }
        }
        i(mapC, "title", strD);
        String strD2 = d(mapC, linkedHashMap, "subTitle", "subtitle", Const.JSON_KEY_DESC, "description");
        if (strD2 == null) {
            j jVar2 = j.INSTANCE;
            CardSummary summary2 = envelope.getSummary();
            strD2 = jVar2.d(summary2 != null ? summary2.getDesc() : null);
            if (strD2 == null) {
                strD2 = DidiCardProvider.DEFAULT_AUTH_SUBTITLE;
            }
        }
        i(mapC, "subTitle", strD2);
        mapC.put("app", g(mapC.get("app"), str, detection.getVendor()));
        Object obj2 = mapC.get("action");
        String strD3 = d(mapC, linkedHashMap, AlipayXuiLiveClickReceiver.EXTRA_APP_LINK, "deepLink", "deeplink", "schema", "scheme", "authAppLink", "authorizeAppLink", "oauthAppLink");
        if (strD3 == null) {
            j jVar3 = j.INSTANCE;
            CardLinks links = envelope.getLinks();
            strD3 = jVar3.d(links != null ? links.getApp() : null);
        }
        String strD4 = d(mapC, linkedHashMap, "webLink", "browserLink", "h5Url", "url", "authUrl", "authorizeUrl", "oauthUrl");
        if (strD4 == null) {
            j jVar4 = j.INSTANCE;
            CardLinks links2 = envelope.getLinks();
            strD4 = jVar4.d(links2 != null ? links2.getWeb() : null);
        }
        mapC.put("action", f(obj2, "去授权", strD3, strD4));
        mapC.put("secondaryAction", f(mapC.get("secondaryAction"), DidiCardProvider.LABEL_DISMISS, null, null));
        linkedHashMap.put(DidiCardProvider.KEY_ORDER, mapC);
        return linkedHashMap;
    }

    public final void i(Map<String, Object> map, String str, Object obj) {
        if (obj == null) {
            return;
        }
        Object obj2 = map.get(str);
        if (!(obj2 instanceof String) || j.INSTANCE.d((String) obj2) == null) {
            if (obj2 == null || (obj2 instanceof String)) {
                map.put(str, obj);
            }
        }
    }

    public final Map<String, Object> j(Map<?, ?> map) {
        Set<Map.Entry<?, ?>> setEntrySet = map.entrySet();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            String str = key instanceof String ? (String) key : null;
            Pair pairA = str != null ? Y8.j.a(str, entry.getValue()) : null;
            if (pairA != null) {
                arrayList.add(pairA);
            }
        }
        return kotlin.collections.a.y(arrayList);
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\fR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u0019\u0010\fR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u001a\u0010\fR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u001b\u0010\fR\u0011\u0010\u001e\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, d2 = {"LN5/y$a;", "", "LN5/i;", "envelope", "", "originalTemplateType", "normalizedTemplateType", "vendor", "reason", "<init>", "(LN5/i;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "LN5/i;", Const.INTENT_KEY_PKGNAME, "()LN5/i;", "Ljava/lang/String;", Const.INTENT_KEY_UMID, "c", "f", "e", Const.INTENT_KEY_APIKEY, "()Z", "changed", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: N5.y$a, reason: from toString */
    public static final /* data */ class Result {
        private final CardEnvelope envelope;
        private final String normalizedTemplateType;
        private final String originalTemplateType;
        private final String reason;
        private final String vendor;

        public Result(CardEnvelope envelope, String originalTemplateType, String normalizedTemplateType, String str, String str2) {
            kotlin.jvm.internal.p.i(envelope, "envelope");
            kotlin.jvm.internal.p.i(originalTemplateType, "originalTemplateType");
            kotlin.jvm.internal.p.i(normalizedTemplateType, "normalizedTemplateType");
            this.envelope = envelope;
            this.originalTemplateType = originalTemplateType;
            this.normalizedTemplateType = normalizedTemplateType;
            this.vendor = str;
            this.reason = str2;
        }

        public final boolean a() {
            return !kotlin.jvm.internal.p.d(this.originalTemplateType, this.normalizedTemplateType);
        }

        /* renamed from: b, reason: from getter */
        public final CardEnvelope getEnvelope() {
            return this.envelope;
        }

        /* renamed from: c, reason: from getter */
        public final String getNormalizedTemplateType() {
            return this.normalizedTemplateType;
        }

        /* renamed from: d, reason: from getter */
        public final String getOriginalTemplateType() {
            return this.originalTemplateType;
        }

        /* renamed from: e, reason: from getter */
        public final String getReason() {
            return this.reason;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Result)) {
                return false;
            }
            Result result = (Result) other;
            return kotlin.jvm.internal.p.d(this.envelope, result.envelope) && kotlin.jvm.internal.p.d(this.originalTemplateType, result.originalTemplateType) && kotlin.jvm.internal.p.d(this.normalizedTemplateType, result.normalizedTemplateType) && kotlin.jvm.internal.p.d(this.vendor, result.vendor) && kotlin.jvm.internal.p.d(this.reason, result.reason);
        }

        /* renamed from: f, reason: from getter */
        public final String getVendor() {
            return this.vendor;
        }

        public int hashCode() {
            int iHashCode = ((((this.envelope.hashCode() * 31) + this.originalTemplateType.hashCode()) * 31) + this.normalizedTemplateType.hashCode()) * 31;
            String str = this.vendor;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.reason;
            return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "Result(envelope=" + this.envelope + ", originalTemplateType=" + this.originalTemplateType + ", normalizedTemplateType=" + this.normalizedTemplateType + ", vendor=" + this.vendor + ", reason=" + this.reason + ")";
        }

        public /* synthetic */ Result(CardEnvelope cardEnvelope, String str, String str2, String str3, String str4, int i10, kotlin.jvm.internal.i iVar) {
            this(cardEnvelope, str, str2, (i10 & 8) != 0 ? null : str3, (i10 & 16) != 0 ? null : str4);
        }
    }
}
