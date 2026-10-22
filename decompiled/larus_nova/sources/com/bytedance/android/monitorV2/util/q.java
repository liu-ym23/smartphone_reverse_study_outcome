package com.bytedance.android.monitorV2.util;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.monitorV2.event.HybridEvent;
import com.bytedance.android.monitorV2.hybridSetting.entity.BidInfo;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f163249a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ArrayList<String> f163250b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ArrayList<String> f163251c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ArrayList<String> f163252d = null;

    public q() {
    }

    static {
        f163249a = new q();
        f163250b = CollectionsKt.arrayListOf(new String[]{"jsb_bid", "regex_bid", "config_bid"});
        f163251c = CollectionsKt.arrayListOf(new String[]{"[?&]bd_hybrid_monitor_bid=([^&#]+)", "[?&]bdhm_bid=([^&#]+)"});
        f163252d = CollectionsKt.arrayListOf(new String[]{"[?&]bdhm_pid=([^&#]+)"});
    }

    public static JSONObject a(com.bytedance.android.monitorV2.event.a r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        JSONObject r101 = new JSONObject();
        String r102 = c(r100);
        BidInfo.BidConfig r103 = d(r102);
        JSONObject r104 = new JSONObject();
        Object r105 = ((LinkedHashMap) r100.f163005e).get("config_bid");
        if (r105 != null) goto L5;
        r105 = "";
    L5:
        r100.f163006f.addContext("bid_source", r100.f163010j);
        l.q(r101, "event_type", r100.f163001a);
        l.q(r101, "full_link_id", r100.f163003c);
        JSONObject r106 = r100.f163006f.toJsonObject();
        l.p(r101, "nativeBase", r106);
        l.p(r106, "bid_info", r104);
        l.q(r104, "bid", r102);
        l.q(r104, "setting_bid", r103.bid);
        l.o(r104, "hit_sample", r103.hitSample);
        l.o(r104, Constant.KEY_SETTING_ID, r103.settingId);
        l.p(r104, "config_bid", r105);
        fz2.b r107 = r100.f163019m;
        if (r107 == null) goto L8;
        l.p(r101, "nativeInfo", r107.toJsonObject());
    L8:
        JSONObject r108 = r100.f163021o;
        if (r108 == null) goto L11;
        l.p(r101, "jsInfo", r108);
    L11:
        JSONObject r109 = r100.f163007g;
        if (r109 == null) goto L14;
        l.p(r101, "jsBase", r109);
    L14:
        jz2.a r110 = r100.f163008h;
        if (r110 == null) goto L17;
        l.p(r101, "containerBase", r110.toJsonObject());
    L17:
        jz2.b r111 = r100.f163020n;
        if (r111 == null) goto L20;
        l.p(r101, "containerInfo", r111.toJsonObject());
    L20:
        Map<String, Object> r112 = r100.f163011k;
        if (r112 == null) goto L23;
        l.p(r101, "extra", new JSONObject(r112));
    L23:
        return r101;
    }

    public static JSONObject b(com.bytedance.android.monitorV2.event.b r100) {
        Intrinsics.checkNotNullParameter(r100, "customEvent");
        String r101 = c(r100);
        r100.f163022m.f501102b = r101;
        BidInfo.BidConfig r102 = d(r101);
        JSONObject r103 = new JSONObject();
        Object r104 = ((LinkedHashMap) r100.f163005e).get("config_bid");
        String r105 = "";
        if (r104 != null) goto L5;
        r104 = "";
    L5:
        r100.f163006f.addContext("bid_source", r100.f163010j);
        JSONObject r106 = new JSONObject();
        l.q(r106, "full_link_id", r100.f163003c);
        l.p(r106, "bid_info", r103);
        l.q(r103, "bid", r101);
        l.q(r103, "setting_bid", r102.bid);
        l.o(r103, "hit_sample", r102.hitSample);
        l.o(r103, Constant.KEY_SETTING_ID, r102.settingId);
        l.p(r103, "config_bid", r104);
        l.n(r103, "can_sample", r100.f163022m.f501111k);
        JSONObject r107 = r100.f163022m.f501104d;
        if (r107 == null) goto L8;
        l.p(r106, "client_category", r107);
    L8:
        JSONObject r108 = r100.f163022m.f501105e;
        if (r108 == null) goto L11;
        l.p(r106, "client_metric", r108);
    L11:
        jz2.d r109 = r100.f163022m;
        JSONObject r110 = r109.f501106f;
        if (r110 == null) goto L14;
        l.q(r110, ReportCardMonitorPlugin.EVENT_NAME, r109.f501103c);
        l.q(r100.f163022m.f501106f, "sdk_version", "10.4.0");
        l.p(r106, "client_extra", r100.f163022m.f501106f);
    L14:
        JSONObject r111 = r100.f163022m.f501107g;
        if (r111 == null) goto L17;
        l.p(r106, "client_timing", r111);
    L17:
        l.p(r106, "nativeBase", r100.f163006f.toJsonObject());
        jz2.a r112 = r100.f163008h;
        if (r112 == null) goto L20;
        l.p(r106, "containerBase", r112.toJsonObject());
    L20:
        JSONObject r113 = r100.f163007g;
        if (r113 == null) goto L23;
        l.p(r106, "jsBase", r113);
    L23:
        String r114 = r100.f163022m.f501101a;
        l.q(r106, "url", r114);
        if (r114 == null) goto L39;
        Pattern r115 = u.f163257a;
        Uri r116 = UriProtector.parse(r114);     // Catch: Throwable -> L47
        if (r116 == null) goto L31;
        String r117 = r116.getHost();     // Catch: Throwable -> L47
        if (r117 == null) goto L31;
    L32:
        l.q(r106, "host", r117);
        Pattern r118 = u.f163257a;
        Uri r119 = UriProtector.parse(r114);     // Catch: Throwable -> L46
        if (r119 == null) goto L38;
        String r120 = r119.getPath();     // Catch: Throwable -> L46
        if (r120 == null) goto L38;
        r105 = r120;
    L38:
        l.q(r106, "path", r105);
    L31:
        r117 = "";
    L39:
        l.q(r106, "ev_type", "custom");
        JSONObject r121 = r100.f163022m.f501108h;
        if (r121 != null) goto L42;
    L44:
        l.a(r106, r100.f163022m.f501108h);
        return r106;
    L42:
        if (r121.has("virtual_aid") == false) goto L44;
        r121.remove("virtual_aid");
        goto L44
    }

    public static String c(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        kz2.a.C6634a r101 = kz2.a.f506727a;
        if ((r100 instanceof com.bytedance.android.monitorV2.event.a) == false) goto L7;
        return f((HybridEvent) r100);
    L7:
        if ((r100 instanceof com.bytedance.android.monitorV2.event.b) == false) goto L14;
        com.bytedance.android.monitorV2.event.b r102 = (com.bytedance.android.monitorV2.event.b) r100;
        if (TextUtils.isEmpty(r102.f163022m.f501102b) == true) goto L13;
        return r102.f163022m.f501102b;
    L13:
        return f((HybridEvent) r100);
    L14:
        return "";
    }

    public static BidInfo.BidConfig d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "bid");
        return com.bytedance.android.monitorV2.g.e().d().d().a(r100);
    }

    public static JSONObject e(HybridEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if ((r100 instanceof com.bytedance.android.monitorV2.event.a) == false) goto L6;
        return a((com.bytedance.android.monitorV2.event.a) r100);
    L6:
        if ((r100 instanceof com.bytedance.android.monitorV2.event.b) == false) goto L9;
        return b((com.bytedance.android.monitorV2.event.b) r100);
    L9:
        return new JSONObject();
    }

    public static String f(HybridEvent r100) {
        Map<String, Object> r101 = r100.f163005e;
        Iterator<String> r102 = f163250b.iterator();
    L3:
        String r103 = "";
        if (r102.hasNext() == false) goto L23;
        String r104 = r102.next();
        Object r105 = ((LinkedHashMap) r101).get(r104);
        if ((r105 instanceof String) == false) goto L3;
        if ((!StringsKt.isBlank((CharSequence) r105)) == false) goto L3;
        if (Intrinsics.areEqual("regex_bid", r104) == false) goto L20;
        Map<String, Object> r106 = r100.f163011k;
        String r107 = null;
        if (r106 == null) goto L14;
        Object r108 = ((LinkedHashMap) r106).get("regex_source");
    L16:
        if ((r108 instanceof String) == false) goto L18;
        r107 = (String) r108;
    L18:
        if (r107 == null) goto L21;
        r103 = r107;
    L21:
        r100.f163006f.addContext("bid_source", r103);
        return (String) r105;
    L14:
        r108 = null;
        goto L16
    L20:
        r103 = r104;
        goto L21
    L23:
        r100.f163006f.addContext("bid_source", "default_bid");
        return "";
    }

    public static void h(HybridEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r100, "event");
        if ((r100 instanceof com.bytedance.android.monitorV2.event.a) == false) goto L8;
        String r101 = r100.f163006f.url;
        if (r101 == null) goto L11;
    L12:
        jz2.a r102 = r100.f163008h;
        if (r102 == null) goto L15;
        JSONObject r103 = r102.toJsonObject();
    L16:
        String r104 = l.l(r103, "schema");
        kz2.a.C6634a r105 = kz2.a.f506727a;
        Map<String, Object> r106 = r100.f163005e;
        LinkedList r107 = new LinkedList();
        r107.add(r101);
        r107.add(r104);
        String r108 = g(r107, f163251c);
        r100.g("regex_param_bid");
        if (StringsKt.isBlank(r108) == true) goto L19;
    L21:
        nz2.b.f("ReportDataUtils", "regexMatcher: " + r108);
        r106.put("regex_bid", r108);
        if ((!StringsKt.isBlank(l.l(r100.f163007g, "pid"))) == false) goto L25;
        return;
    L25:
        if (r100.f163007g != null) goto L27;
        r100.f163007g = new JSONObject();
    L27:
        LinkedList r109 = new LinkedList();
        r109.add(r101);
        r109.add(r104);
        String r110 = g(r109, f163252d);
        if ((!StringsKt.isBlank(r110)) == false) goto L33;
        JSONObject r111 = r100.f163007g;
        if (r111 == null) goto L34;
        r111.put("pid", r110);
        return;
    L34:
        return;
    L33:
        return;
    L19:
        if ((!StringsKt.isBlank(r101)) == false) goto L21;
        com.bytedance.android.monitorV2.i.a r112 = com.bytedance.android.monitorV2.i.f163108a;
        r108 = com.bytedance.android.monitorV2.i.a(r101, com.bytedance.android.monitorV2.g.e().d().a(), true);
        r100.g("regex_list_bid");
        goto L21
    L15:
        r103 = null;
    L11:
        r101 = "";
        goto L12
    L8:
        if ((r100 instanceof com.bytedance.android.monitorV2.event.b) == false) goto L11;
        r101 = ((com.bytedance.android.monitorV2.event.b) r100).f163022m.f501101a;
        if (r101 != null) goto L12;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String g(List r110, List r111) {
        Ref.ObjectRef r100 = new Ref.ObjectRef();
        r100.element = "";
        Iterator r112 = r110.iterator();
    L4:
        if (r112.hasNext() == false) goto L46;
        String r101 = (String) r112.next();
        Iterator r102 = r111.iterator();
    L7:
        if (r102.hasNext() == false) goto L4;
        String r103 = (String) r102.next();
        if ((!StringsKt.isBlank(r101)) == false) goto L7;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L40
        Matcher r105 = PatternProtector.compile(r103).matcher(r101);     // Catch: Throwable -> L40
        if (r105.find() == false) goto L35;
        String r106 = r105.group(1);     // Catch: Throwable -> L40
        if (r106 == null) goto L32;
        int r107 = r106.length() - 1;     // Catch: Throwable -> L40
        int r108 = 0;
        boolean r109 = false;
    L15:
        if (r108 > r107) goto L30;
        if (r109 == true) goto L18;
        int r113 = r108;
    L20:
        if (Intrinsics.compare(r106.charAt(r113), 32) > 0) goto L22;
        boolean r114 = true;
    L23:
        if (r109 == false) goto L24;
        if (r114 == false) goto L30;
        r107 = r107 - 1;     // Catch: Throwable -> L40
        goto L15
    L24:
        if (r114 == false) goto L25;
        r108 = r108 + 1;     // Catch: Throwable -> L40
        goto L15
    L25:
        r109 = true;
        goto L15
    L22:
        r114 = false;
        goto L23
    L18:
        r113 = r107;
    L30:
        String r115 = r106.subSequence(r108, r107 + 1).toString();     // Catch: Throwable -> L40
        T r116 = r115;
        if (r115 == null) goto L32;
    L33:
        r100.element = r116;     // Catch: Throwable -> L40
    L32:
        r116 = "";
    L35:
        if ((!StringsKt.isBlank((CharSequence) r100.element)) == false) goto L38;
        return (String) r100.element;
    L38:
        Object r117 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L40
    L43:
        if (Result.m9452exceptionOrNullimpl(r117) == null) goto L7;
        nz2.b.c("ReportDataUtils", "match error");
    L40:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L43
    L46:
        return (String) r100.element;
    }
}
