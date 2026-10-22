package cj2;

import com.bytedance.android.ec.core.utils.g;
import com.bytedance.android.livesdk.livecommerce.ECLiveCommerceModel_ProvideEventServiceFactory;
import com.bytedance.android.livesdk.livecommerce.event.k;
import el2.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static c f23945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f23946b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0450a f23947c = null;

    /* JADX INFO: renamed from: cj2.a$a, reason: collision with other inner class name */
    public static final class C0450a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public i f23948a;

        public C0450a() {
            this.f23948a = ECLiveCommerceModel_ProvideEventServiceFactory.proxyProvideEventService(hh2.a.a().f485153f);
        }
    }

    public a() {
    }

    static {
        f23947c = new C0450a();
    }

    public static /* synthetic */ void c(String r100, String r101) {
        b(r100, r101, null, null, null, null);
    }

    public static void e(Integer r100, String r101, String r102) {
        HashMap r103 = new HashMap();
        if (r100 == null) goto L6;
        String r104 = String.valueOf(r100.intValue());
        if (r104 == null) goto L6;
    L7:
        r103.put("duration", r104);
        a("livesdk_explain_replay_tolive_click", r103, r101, r102);
        return;
    L6:
        r104 = "";
        goto L7
    }

    public static void f(String r100, String r101, int r102) {
        if ((r102 & 2) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 4) == 0) goto L8;
        r101 = null;
    L8:
        HashMap r103 = new HashMap();
        r103.put("duration", "");
        a("livesdk_explain_replay_tolive_show", r103, r100, r101);
    }

    public static void a(String r100, Map r101, String r102, String r103) {
        i r104 = f23947c.f23948a;
        if (r104 == null) goto L31;
        k r105 = r104.a(r100);
        if (r105 == null) goto L32;
        c r106 = f23945a;
        if (r106 == null) goto L15;
        HashMap<String, String> r107 = r106.f23956a;
        if (r107 == null) goto L15;
        Iterator<Map.Entry<String, String>> r108 = r107.entrySet().iterator();
    L12:
        if (r108.hasNext() == false) goto L15;
        Map.Entry<String, String> r109 = r108.next();
        r105.c(r109.getKey(), r109.getValue());
    L15:
        if (f23946b == false) goto L17;
        String r110 = "1";
    L18:
        r105.c("subtitle_status", r110);
        c r111 = f23945a;
        if (r111 == null) goto L21;
        r105.c("system_volume_pct", String.valueOf(Double.valueOf(r111.f23957b).doubleValue()));
    L21:
        r105.c("end_volume_pct", String.valueOf(g.a()));
        if (r101 == null) goto L27;
        Iterator r112 = r101.entrySet().iterator();
    L25:
        if (r112.hasNext() == false) goto L27;
        Map.Entry r113 = (Map.Entry) r112.next();
        r105.c((String) r113.getKey(), (String) r113.getValue());
    L27:
        r105.l(r102, r103);
        return;
    L17:
        r110 = "0";
        goto L18
    L32:
        return;
    }

    public static void d(String r100, Integer r101, String r102, String r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "cardStatus");
        HashMap r105 = new HashMap();
        r105.put(com.bytedance.android.ec.core.event.a.KEY_CARD_STATUS, r100);
        r105.put(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM, com.bytedance.android.ec.core.event.a.VALUE_REPlAY_POPUP_CARD);
        if (r101 == null) goto L5;
        String r106 = (String) r105.put("is_replay_default_product", String.valueOf(r101.intValue()));
    L5:
        if (r102 == null) goto L7;
        r105.put("replay_type", r102);
    L7:
        a("livesdk_replay_popup_card_show", r105, r103, r104);
    }

    public static void b(String r100, String r101, String r102, String r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "clickArea");
        HashMap r106 = new HashMap();
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r106.put(com.bytedance.android.ec.core.event.a.KEY_CARD_STATUS, r101);
        r106.put(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, r100);
        r106.put(com.bytedance.android.ec.core.event.a.KEY_ECOM_ENTRANCE_FORM, com.bytedance.android.ec.core.event.a.VALUE_REPlAY_POPUP_CARD);
        if (r102 == null) goto L8;
        String r107 = (String) r106.put("is_replay_default_product", r102);
    L8:
        if (r103 == null) goto L10;
        r106.put("replay_type", r103);
    L10:
        a("livesdk_replay_popup_card_click", r106, r104, r105);
    }
}
