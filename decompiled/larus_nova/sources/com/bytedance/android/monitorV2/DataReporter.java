package com.bytedance.android.monitorV2;

import android.text.TextUtils;
import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.bytedance.android.monitorV2.dataprocessor.TypedDataDispatcher;
import com.bytedance.android.monitorV2.event.HybridEvent;
import com.bytedance.android.monitorV2.hybridSetting.Switches;
import com.bytedance.android.monitorV2.hybridSetting.entity.BidInfo;
import com.bytedance.android.monitorV2.util.l;
import com.bytedance.android.monitorV2.util.q;
import com.bytedance.apm.ApmAgent;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larksuite.component.card.plugin.ReportCardMonitorPlugin;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class DataReporter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TypedDataDispatcher f162979a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final iz2.a f162980b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, AtomicLong> f162981c = null;

    public static final class a implements com.bytedance.android.monitorV2.dataprocessor.a {
        public a() {
        }

        @Override // com.bytedance.android.monitorV2.dataprocessor.a
        public final void a(Object r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L17
            if ((r100 instanceof Pair) == false) goto L15;
            Object r102 = ((Pair) r100).getFirst();     // Catch: Throwable -> L17
            if ((r102 instanceof com.bytedance.android.monitorV2.event.a) == false) goto L13;
            TypedDataDispatcher r103 = DataReporter.f162979a;     // Catch: Throwable -> L17
            Object r104 = ((Pair) r100).getFirst();     // Catch: Throwable -> L17
            Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type com.bytedance.android.monitorV2.event.CommonEvent");     // Catch: Throwable -> L17
            com.bytedance.android.monitorV2.event.a r105 = (com.bytedance.android.monitorV2.event.a) r104;     // Catch: Throwable -> L17
            Object r106 = ((Pair) r100).getSecond();     // Catch: Throwable -> L17
            if ((r106 instanceof com.bytedance.android.monitorV2.webview.b) == false) goto L10;
            com.bytedance.android.monitorV2.webview.b r107 = (com.bytedance.android.monitorV2.webview.b) r106;     // Catch: Throwable -> L17
        L11:
            DataReporter.a(r105, r107);     // Catch: Throwable -> L17
            goto L15
        L10:
            r107 = null;
            goto L11
        L13:
            if ((r102 instanceof com.bytedance.android.monitorV2.event.b) == false) goto L15;
            TypedDataDispatcher r108 = DataReporter.f162979a;     // Catch: Throwable -> L17
            Object r109 = ((Pair) r100).getFirst();     // Catch: Throwable -> L17
            Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type com.bytedance.android.monitorV2.event.CustomEvent");     // Catch: Throwable -> L17
            DataReporter.b((com.bytedance.android.monitorV2.event.b) r109);     // Catch: Throwable -> L17
        L15:
            Object r110 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L17
        L19:
            Throwable r111 = Result.m9452exceptionOrNullimpl(r110);
            if (r111 == null) goto L25;
            com.bytedance.android.monitorV2.util.f.b(r111);
            return;
        L25:
            return;
        L17:
            th = move-exception;
            Result.Companion r112 = Result.Companion;
            r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L19
        }
    }

    public DataReporter() {
    }

    static {
        TypedDataDispatcher r100 = new TypedDataDispatcher();
        f162979a = r100;
        f162980b = new iz2.a();
        f162981c = new ConcurrentHashMap();
        TypedDataDispatcher.DataType r101 = TypedDataDispatcher.DataType.REPORT_DATA;
        a r102 = new a();
        Intrinsics.checkNotNullParameter(r101, "dataType");
        Intrinsics.checkNotNullParameter(r102, "dataProcessor");
        r100.f162997c.put(r101, r102);
    }

    public static final void b(com.bytedance.android.monitorV2.event.b r110) {
        nz2.b.f("DataReporter", "monitorCustom: " + r110.f163022m);     // Catch: Throwable -> L11
        kz2.a.C6634a r100 = kz2.a.f506727a;     // Catch: Throwable -> L11
        q.f163249a.getClass();     // Catch: Throwable -> L11
        q.h(r110);     // Catch: Throwable -> L11
        String r101 = q.c(r110);     // Catch: Throwable -> L11
        JSONObject r102 = q.b(r110);     // Catch: Throwable -> L11
        r110.f163022m.f501102b = r101;     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r101, "<set-?>");     // Catch: Throwable -> L11
        r110.f163009i = r101;     // Catch: Throwable -> L11
        BidInfo.BidConfig r103 = q.d(r101);     // Catch: Throwable -> L11
        Method r104 = gz2.c.f483375a;     // Catch: Throwable -> L11
        gz2.c.b(r103.bid);     // Catch: Throwable -> L11
        if (e(r110, r103) == true) goto L6;
        r110.d();     // Catch: Throwable -> L11
        return;
    L6:
        gz2.c.e("custom", r103.bid);     // Catch: Throwable -> L11
        StringCompanionObject r105 = StringCompanionObject.INSTANCE;     // Catch: Throwable -> L11
        jz2.d r106 = r110.f163022m;     // Catch: Throwable -> L11
        nz2.b.f("DataReporter", String.format("do report bid: %s, event: %s", Arrays.copyOf(new Object[]{r106.f501102b, r106.f501103c}, 2)));     // Catch: Throwable -> L11
        ConcurrentHashMap<String, AtomicLong> r107 = f162981c;     // Catch: Throwable -> L11
        AtomicLong r108 = r107.get(r101);     // Catch: Throwable -> L11
        if (r108 != null) goto L9;
        r108 = new AtomicLong();     // Catch: Throwable -> L11
        r107.put(r101, r108);     // Catch: Throwable -> L11
    L9:
        JSONObject r109 = new JSONObject();     // Catch: Throwable -> L11
        l.q(r109, ST.UUID_DEVICE, UUID.randomUUID().toString());     // Catch: Throwable -> L11
        l.o(r109, "inc_id", r108.incrementAndGet());     // Catch: Throwable -> L11
        l.p(r109, BindCardPayConfirmConstants.Key.TRACE_ID, r110.a());     // Catch: Throwable -> L11
        l.p(r102, "debugLog", r109);     // Catch: Throwable -> L11
        d(r110.f163022m.f501112l, r102, "custom", "", r110);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        com.bytedance.android.monitorV2.util.f.b(th);
        nz2.b.b("DataReporter", "monitorCustom error: " + th.getMessage());
    }

    public static boolean c(com.bytedance.android.monitorV2.event.b r100) {
        Intrinsics.checkNotNullParameter(r100, "customEvent");
        String r101 = r100.f163009i;
        String r102 = r100.f163022m.f501103c;
        if (TextUtils.isEmpty(r102) == false) goto L6;
        return false;
    L6:
        if (com.bytedance.android.monitorV2.util.d.c(r101, r102) != 1) goto L9;
        StringCompanionObject r103 = StringCompanionObject.INSTANCE;
        nz2.b.f("DataReporter", String.format("bid: %s, event: %s, sample hit", Arrays.copyOf(new Object[]{r101, r102}, 2)));
    L25:
        return true;
    L9:
        if (com.bytedance.android.monitorV2.util.d.c(r101, r102) != 0) goto L11;
        StringCompanionObject r104 = StringCompanionObject.INSTANCE;
        nz2.b.f("DataReporter", String.format("bid: %s, event: %s, sample not hit", Arrays.copyOf(new Object[]{r101, r102}, 2)));
        return false;
    L11:
        StringCompanionObject r105 = StringCompanionObject.INSTANCE;
        nz2.b.f("DataReporter", String.format("bid: %s, event: %s, sample not found, checking all...", Arrays.copyOf(new Object[]{r101, r102}, 2)));
        String r106 = r100.f163022m.f501103c;
        if (TextUtils.isEmpty(r106) == false) goto L15;
        return false;
    L15:
        if (com.bytedance.android.monitorV2.util.d.b(r106) != 1) goto L18;
        nz2.b.f("DataReporter", String.format("event: %s, sample hit", Arrays.copyOf(new Object[]{r106}, 1)));
        goto L25
    L18:
        if (com.bytedance.android.monitorV2.util.d.b(r106) != 0) goto L20;
        nz2.b.f("DataReporter", String.format("event: %s, sample not hit", Arrays.copyOf(new Object[]{r106}, 1)));
        return false;
    L20:
        nz2.b.f("DataReporter", String.format("event: %s, sample not found, checking canSample level...", Arrays.copyOf(new Object[]{r106}, 1)));
        BidInfo.BidConfig r107 = g.e().d().d().a(r100.f163009i);
        if (r107 == null) goto L42;
        int r108 = r100.f163022m.f501111k;
        if (hz2.a.f487670b == true) goto L25;
        switch(r108) {
            case 0: goto L35;
            case 1: goto L34;
            case 2: goto L33;
            case 3: goto L32;
            case 4: goto L31;
            case 5: goto L30;
            case 6: goto L29;
            case 7: goto L28;
            default: goto L27;
        };
    L27:
        boolean r109 = r107.custom_p8;
    L36:
        kz2.a.C6634a r110 = kz2.a.f506727a;
        nz2.b.f("CustomMonitor", String.format("canSample level: %s, sampleHit: %b, use: %s", new Object[]{Integer.valueOf(r108), Boolean.valueOf(r109), r107.bid}));
        return r109;
    L28:
        r109 = r107.custom_p7;
        goto L36
    L29:
        r109 = r107.custom_p6;
        goto L36
    L30:
        r109 = r107.custom_p5;
        goto L36
    L31:
        r109 = r107.custom_p4;
        goto L36
    L32:
        r109 = r107.custom_p3;
        goto L36
    L33:
        r109 = r107.custom_p2;
        goto L36
    L34:
        r109 = r107.custom_p1;
        goto L36
    L35:
        r109 = r107.custom_p0;
        goto L36
    L42:
        return false;
    }

    public static final void a(com.bytedance.android.monitorV2.event.a r100, com.bytedance.android.monitorV2.webview.b r101) {
        nz2.b.f("DataReporter", "reportCommonEventInner: " + r100.f163006f.containerType + ", " + r100.f163001a);     // Catch: Throwable -> L17
        kz2.a.C6634a r102 = kz2.a.f506727a;     // Catch: Throwable -> L17
        q.f163249a.getClass();     // Catch: Throwable -> L17
        q.h(r100);     // Catch: Throwable -> L17
        String r103 = q.c(r100);     // Catch: Throwable -> L17
        BidInfo.BidConfig r104 = q.d(r103);     // Catch: Throwable -> L17
        if (Intrinsics.areEqual(r100.f163001a, "jsbPv") == false) goto L6;
        Method r105 = gz2.c.f483375a;     // Catch: Throwable -> L17
        gz2.c.c(r100, r104.bid);     // Catch: Throwable -> L17
        return;
    L6:
        boolean r106 = e(r100, r104);     // Catch: Throwable -> L17
        Method r107 = gz2.c.f483375a;     // Catch: Throwable -> L17
        gz2.c.b(r104.bid);     // Catch: Throwable -> L17
        gz2.c.d(r100, r103, r106);     // Catch: Throwable -> L17
        if (r106 == true) goto L9;
        r100.d();     // Catch: Throwable -> L17
        return;
    L9:
        gz2.c.e(r100.f163001a, r104.bid);     // Catch: Throwable -> L17
        JSONObject r108 = q.a(r100);     // Catch: Throwable -> L17
        ConcurrentHashMap<String, AtomicLong> r109 = f162981c;     // Catch: Throwable -> L17
        AtomicLong r110 = r109.get(r103);     // Catch: Throwable -> L17
        if (r110 != null) goto L12;
        r110 = new AtomicLong();     // Catch: Throwable -> L17
        r109.put(r103, r110);     // Catch: Throwable -> L17
    L12:
        JSONObject r111 = new JSONObject();     // Catch: Throwable -> L17
        l.q(r111, ST.UUID_DEVICE, UUID.randomUUID().toString());     // Catch: Throwable -> L17
        l.o(r111, "inc_id", r110.incrementAndGet());     // Catch: Throwable -> L17
        l.p(r111, BindCardPayConfirmConstants.Key.TRACE_ID, r100.a());     // Catch: Throwable -> L17
        l.p(r108, "debugLog", r111);     // Catch: Throwable -> L17
        String r112 = r100.f163006f.containerType;     // Catch: Throwable -> L17
        if (r112 != null) goto L15;
        r112 = "";
    L15:
        d(r101, r108, r100.f163001a, r112, r100);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        r100.onEventTerminated(HybridEvent.TerminateType.CATCH_EXCEPTION);
        com.bytedance.android.monitorV2.util.f.b(th);
    }

    public static boolean e(Object r210, BidInfo.BidConfig r211) {
        boolean r100 = false;
        if ((r210 instanceof com.bytedance.android.monitorV2.event.a) == false) goto L205;
        com.bytedance.android.monitorV2.event.a r101 = (com.bytedance.android.monitorV2.event.a) r210;
        String r102 = r101.f163006f.containerType;
        if (Intrinsics.areEqual(r102, "web") == false) goto L111;
        String r103 = r101.f163001a;
        if (hz2.a.f487670b == true) goto L210;
        r103.getClass();
        switch(r103.hashCode()) {
            case -1898518694: goto L85;
            case -1577087617: goto L81;
            case -1323516222: goto L77;
            case -892481938: goto L73;
            case -588767010: goto L69;
            case -109980519: goto L65;
            case 2994720: goto L61;
            case 3437289: goto L57;
            case 93819220: goto L53;
            case 194292771: goto L49;
            case 281935726: goto L45;
            case 299602137: goto L41;
            case 831602183: goto L37;
            case 1008268974: goto L33;
            case 1157772918: goto L29;
            case 1521451035: goto L25;
            case 1727072305: goto L21;
            case 1830775838: goto L17;
            case 1910899023: goto L13;
            default: goto L11;
        };
    L11:
        byte r104 = -1;
    L88:
        switch(r104) {
            case 0: goto L107;
            case 1: goto L106;
            case 2: goto L105;
            case 3: goto L104;
            case 4: goto L105;
            case 5: goto L103;
            case 6: goto L102;
            case 7: goto L101;
            case 8: goto L100;
            case 9: goto L99;
            case 10: goto L98;
            case 11: goto L97;
            case 12: goto L96;
            case 13: goto L95;
            case 14: goto L94;
            case 15: goto L93;
            case 16: goto L92;
            case 17: goto L91;
            case 18: goto L90;
            default: goto L89;
        };
    L89:
        boolean r105 = false;
    L108:
        kz2.a.C6634a r106 = kz2.a.f506727a;
        nz2.b.f("HybridMonitor", String.format("sampling eventType: %s, sampleHit: %b, use: %s", new Object[]{r103, Boolean.valueOf(r105), r211.bid}));
    L209:
        return r105;
    L90:
        r105 = r211.jsb_error_web;
        goto L108
    L91:
        r105 = r211.res_loader_error_template_web;
        goto L108
    L92:
        r105 = r211.native_error_web;
        goto L108
    L93:
        r105 = r211.res_loader_error_web;
        goto L108
    L94:
        r105 = r211.res_loader_perf_web;
        goto L108
    L95:
        r105 = r211.navigation_start_web;
        goto L108
    L96:
        r105 = r211.container_error;
        goto L108
    L97:
        r105 = r211.js_exception_web;
        goto L108
    L98:
        r105 = r211.fetch_error_web;
        goto L108
    L99:
        r105 = r211.res_loader_perf_template_web;
        goto L108
    L100:
        r105 = r211.blank_web;
        goto L108
    L101:
        r105 = r211.perf_web;
        goto L108
    L102:
        r105 = r211.ajax_web;
        goto L108
    L103:
        r105 = r211.static_sri_web;
        goto L108
    L104:
        r105 = r211.static_error_web;
        goto L108
    L105:
        r105 = r211.jsb_perf_web;
        goto L108
    L106:
        r105 = r211.static_perf_web;
        goto L108
    L107:
        r105 = r211.falcon_perf_web;
        goto L108
    L13:
        if (r103.equals("jsbError") == false) goto L11;
        r104 = 18;
        goto L88
    L17:
        if (r103.equals("res_loader_error_template") == false) goto L11;
        r104 = 17;
        goto L88
    L21:
        if (r103.equals("nativeError") == false) goto L11;
        r104 = 16;
        goto L88
    L25:
        if (r103.equals("res_loader_error") == false) goto L11;
        r104 = 15;
        goto L88
    L29:
        if (r103.equals("res_loader_perf") == false) goto L11;
        r104 = 14;
        goto L88
    L33:
        if (r103.equals("navigationStart") == false) goto L11;
        r104 = HTTP.CR;
        goto L88
    L37:
        if (r103.equals("containerError") == false) goto L11;
        r104 = 12;
        goto L88
    L41:
        if (r103.equals("js_exception") == false) goto L11;
        r104 = 11;
        goto L88
    L45:
        if (r103.equals("fetchError") == false) goto L11;
        r104 = 10;
        goto L88
    L49:
        if (r103.equals("res_loader_perf_template") == false) goto L11;
        r104 = 9;
        goto L88
    L53:
        if (r103.equals("blank") == false) goto L11;
        r104 = 8;
        goto L88
    L57:
        if (r103.equals(PerfLog.TAG_PERF) == false) goto L11;
        r104 = 7;
        goto L88
    L61:
        if (r103.equals("ajax") == false) goto L11;
        r104 = 6;
        goto L88
    L65:
        if (r103.equals("static_sri") == false) goto L11;
        r104 = 5;
        goto L88
    L69:
        if (r103.equals("jsbPerfV2") == false) goto L11;
        r104 = 4;
        goto L88
    L73:
        if (r103.equals("static") == false) goto L11;
        r104 = 3;
        goto L88
    L77:
        if (r103.equals("jsbPerf") == false) goto L11;
        r104 = 2;
        goto L88
    L81:
        if (r103.equals("resource_performance") == false) goto L11;
        r104 = 1;
        goto L88
    L85:
        if (r103.equals("falconPerf") == false) goto L11;
        r104 = 0;
        goto L88
    L210:
        return true;
    L111:
        if (Intrinsics.areEqual(r102, "lynx") == false) goto L195;
        String r107 = r101.f163001a;
        if (hz2.a.f487670b == true) goto L211;
        r107.getClass();
        switch(r107.hashCode()) {
            case -1480388560: goto L175;
            case -1323516222: goto L171;
            case -892481938: goto L167;
            case -588767010: goto L163;
            case 93819220: goto L159;
            case 194292771: goto L155;
            case 281935726: goto L151;
            case 299602137: goto L147;
            case 831602183: goto L143;
            case 1008268974: goto L139;
            case 1157772918: goto L135;
            case 1521451035: goto L131;
            case 1727072305: goto L127;
            case 1830775838: goto L123;
            case 1910899023: goto L119;
            default: goto L117;
        };
    L117:
        byte r108 = -1;
    L178:
        switch(r108) {
            case 0: goto L193;
            case 1: goto L192;
            case 2: goto L191;
            case 3: goto L192;
            case 4: goto L190;
            case 5: goto L189;
            case 6: goto L188;
            case 7: goto L187;
            case 8: goto L186;
            case 9: goto L185;
            case 10: goto L184;
            case 11: goto L183;
            case 12: goto L182;
            case 13: goto L181;
            case 14: goto L180;
            default: goto L179;
        };
    L179:
        r105 = false;
    L194:
        kz2.a.C6634a r109 = kz2.a.f506727a;
        nz2.b.f("HybridMonitor", String.format("sampling eventType: %s, sampleHit: %b, use: %s", new Object[]{r107, Boolean.valueOf(r105), r211.bid}));
        goto L209
    L180:
        r105 = r211.jsb_error_lynx;
        goto L194
    L181:
        r105 = r211.res_loader_error_template_lynx;
        goto L194
    L182:
        r105 = r211.native_error_lynx;
        goto L194
    L183:
        r105 = r211.res_loader_error_lynx;
        goto L194
    L184:
        r105 = r211.res_loader_perf_lynx;
        goto L194
    L185:
        r105 = r211.navigation_start_lynx;
        goto L194
    L186:
        r105 = r211.container_error;
        goto L194
    L187:
        r105 = r211.js_exception_lynx;
        goto L194
    L188:
        r105 = r211.fetch_error_lynx;
        goto L194
    L189:
        r105 = r211.res_loader_perf_template_lynx;
        goto L194
    L190:
        r105 = r211.blank_lynx;
        goto L194
    L191:
        r105 = r211.static_error_lynx;
        goto L194
    L192:
        r105 = r211.jsb_perf_lynx;
        goto L194
    L193:
        r105 = r211.performance_lynx;
        goto L194
    L119:
        if (r107.equals("jsbError") == false) goto L117;
        r108 = 14;
        goto L178
    L123:
        if (r107.equals("res_loader_error_template") == false) goto L117;
        r108 = HTTP.CR;
        goto L178
    L127:
        if (r107.equals("nativeError") == false) goto L117;
        r108 = 12;
        goto L178
    L131:
        if (r107.equals("res_loader_error") == false) goto L117;
        r108 = 11;
        goto L178
    L135:
        if (r107.equals("res_loader_perf") == false) goto L117;
        r108 = 10;
        goto L178
    L139:
        if (r107.equals("navigationStart") == false) goto L117;
        r108 = 9;
        goto L178
    L143:
        if (r107.equals("containerError") == false) goto L117;
        r108 = 8;
        goto L178
    L147:
        if (r107.equals("js_exception") == false) goto L117;
        r108 = 7;
        goto L178
    L151:
        if (r107.equals("fetchError") == false) goto L117;
        r108 = 6;
        goto L178
    L155:
        if (r107.equals("res_loader_perf_template") == false) goto L117;
        r108 = 5;
        goto L178
    L159:
        if (r107.equals("blank") == false) goto L117;
        r108 = 4;
        goto L178
    L163:
        if (r107.equals("jsbPerfV2") == false) goto L117;
        r108 = 3;
        goto L178
    L167:
        if (r107.equals("static") == false) goto L117;
        r108 = 2;
        goto L178
    L171:
        if (r107.equals("jsbPerf") == false) goto L117;
        r108 = 1;
        goto L178
    L175:
        if (r107.equals("performance") == false) goto L117;
        r108 = 0;
        goto L178
    L211:
        return true;
    L195:
        String r110 = r101.f163001a;
        if (hz2.a.f487670b == true) goto L212;
        r110.getClass();
        if (r110.equals("containerError") == false) goto L203;
        r100 = r211.container_error;
    L203:
        return r100;
    L212:
        return true;
    L205:
        if ((r210 instanceof com.bytedance.android.monitorV2.event.b) == true) goto L207;
        return false;
    L207:
        return c((com.bytedance.android.monitorV2.event.b) r210);
    }

    public static void h(com.bytedance.android.monitorV2.event.b r100, Boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "customEvent");
        int r102 = com.bytedance.android.monitorV2.util.h.f163236a;
        String r103 = r100.f163022m.f501103c;
        if (r103 != null) goto L6;
        r103 = "";
    L6:
        if (com.bytedance.android.monitorV2.util.h.b(r103) == false) goto L9;
        r100.onEventTerminated(HybridEvent.TerminateType.SWITCH_OFF);
        return;
    L9:
        kz2.a.C6634a r104 = kz2.a.f506727a;
        TypedDataDispatcher r105 = f162979a;
        TypedDataDispatcher.DataType r106 = TypedDataDispatcher.DataType.REPORT_DATA;
        Pair r107 = new Pair(r100, null);
        if (r101 == null) goto L12;
        boolean r108 = r101.booleanValue();
    L13:
        r105.a(r106, r107, r108);
        return;
    L12:
        r108 = true;
        goto L13
    }

    public static void g(com.bytedance.android.monitorV2.event.a r100, com.bytedance.android.monitorV2.webview.b r101, Boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "commonEvent");
        int r103 = com.bytedance.android.monitorV2.util.h.f163236a;
        if (com.bytedance.android.monitorV2.util.h.a(r100.f163001a) == false) goto L6;
        r100.onEventTerminated(HybridEvent.TerminateType.SWITCH_OFF);
        return;
    L6:
        kz2.a.C6634a r104 = kz2.a.f506727a;
        TypedDataDispatcher r105 = f162979a;
        TypedDataDispatcher.DataType r106 = TypedDataDispatcher.DataType.REPORT_DATA;
        Pair r107 = new Pair(r100, r101);
        if (r102 == null) goto L9;
        boolean r108 = r102.booleanValue();
    L10:
        r105.a(r106, r107, r108);
        return;
    L9:
        r108 = true;
        goto L10
    }

    public static String i(String r100, String r101, JSONObject r102) {
        boolean r103 = gz2.b.f483372a;
        String r104 = "bd_hybrid_monitor_service_all_in_one";
        Intrinsics.checkNotNullParameter("bd_hybrid_monitor_service_all_in_one", "serviceName");
        Intrinsics.checkNotNullParameter(r100, "eventType");
        Intrinsics.checkNotNullParameter(r101, "containerType");
        Intrinsics.checkNotNullParameter(r102, "result");
        if (Switches.logType.isEnabled() == false) goto L16;
        if (gz2.b.f483373b.contains(r100) == false) goto L9;
        String r105 = "bd_hybrid_monitor_p_zero";
    L7:
        r104 = r105;
        if (gz2.b.f483372a == true) goto L18;
        ApmAgent.monitorCommonLog(r104, r102);
    L18:
        return r104;
    L9:
        if (gz2.b.f483374c.contains(r100) == false) goto L11;
        r105 = "bd_hybrid_monitor_p_one";
        goto L7
    L11:
        r105 = "bd_hybrid_monitor_normal";
        goto L7
    L16:
        if (gz2.b.f483372a == true) goto L18;
        ApmAgent.monitorEvent("bd_hybrid_monitor_service_all_in_one", null, null, r102);
        goto L18
    }

    public static void d(com.bytedance.android.monitorV2.webview.b r100, JSONObject r101, String r102, String r103, HybridEvent r104) {
        iz2.a r105 = f162980b;
        r105.getClass();
        Intrinsics.checkNotNullParameter(r101, "jsonObj");
        Intrinsics.checkNotNullParameter(r102, "eventType");
        Intrinsics.checkNotNullParameter(r103, "containerType");
        String r106 = "custom";
        if (TextUtils.equals("custom", r102) == true) goto L7;
        r106 = r103 + '_' + r102 + '_' + l.l(l.i(r101, "nativeBase"), "navigation_id");
    L7:
        if (r105.f496624a.containsKey(r102) == true) goto L9;
    L18:
        r105.a();
        f(r100, r101, r102, r103, r104);
    L19:
        r105.f496629f = r100;
        r105.f496625b = r101;
        r105.f496627d = r102;
        r105.f496628e = r103;
        return;
    L9:
        if (TextUtils.equals(r106, null) == false) goto L18;
        iz2.a.c r107 = r105.f496624a.get(r102);
        if (r107 == null) goto L19;
        if (r107.a(r105.f496625b, r101) == false) goto L17;
        r105.f496626c++;
        if (r104 == null) goto L19;
        r104.onEventTerminated(HybridEvent.TerminateType.EVENT_REPEATED);
        goto L19
    L17:
        r105.a();
        f(r100, r101, r102, r103, r104);
        goto L19
    }

    public static void f(com.bytedance.android.monitorV2.webview.b r100, JSONObject r101, String r102, String r110, HybridEvent r111) {
        if (r101 == null) goto L75;
        if (r102 == null) goto L75;
        if (r110 == null) goto L75;
        JSONObject r103 = new JSONObject();
        l.p(r103, "extra", r101);
        if (Intrinsics.areEqual("custom", r102) == false) goto L82;
        String r104 = JSONObjectProtectorUtils.getString(JSONObjectProtectorUtils.getJSONObject(r101, "bid_info"), "setting_bid");     // Catch: JSONException -> L15
    L18:
        Method r105 = gz2.c.f483375a;
        Intrinsics.checkNotNullParameter(r102, "eventName");
        Intrinsics.checkNotNullParameter(r104, "bid");
        if (TextUtils.isEmpty(r102) == false) goto L22;
    L25:
        String r106 = "bd_hybrid_monitor_service_all_in_one";
        if (r100 != null) goto L84;
    L30:
        r106 = i(r102, r110, r103);     // Catch: Throwable -> L34
    L31:
        if (r111 == null) goto L80;
        r111.f();     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        if (r111 == null) goto L37;
        r111.onEventTerminated(HybridEvent.TerminateType.CATCH_EXCEPTION);
    L37:
        com.bytedance.android.monitorV2.util.f.b(th);
    L80:
        nz2.b.f("DataReporter", "upload ".concat(r102));     // Catch: Throwable -> L72
        if (Intrinsics.areEqual("jsbPerf", r102) == false) goto L41;
    L46:
        boolean r107 = true;
    L47:
        if (r107 == true) goto L58;
        StringCompanionObject r108 = StringCompanionObject.INSTANCE;     // Catch: Throwable -> L72
        Object[] r109 = new Object[4];     // Catch: Throwable -> L72
        if (r111 == null) goto L52;
        String r112 = r111.f163003c;     // Catch: Throwable -> L72
        if (r112 == null) goto L52;
    L53:
        r109[0] = r112;     // Catch: Throwable -> L72
        r109[1] = r102;     // Catch: Throwable -> L72
        r109[2] = r110;     // Catch: Throwable -> L72
        String r113 = r103.toString();     // Catch: Throwable -> L72
        if (r113.length() <= 500) goto L57;
        r113 = r113.substring(0, 500);     // Catch: Throwable -> L72
    L57:
        r109[3] = r113;     // Catch: Throwable -> L72
        nz2.b.f("DataReporter", String.format("report: session: %s event: %s container: %s data: %s", Arrays.copyOf(r109, 4)));     // Catch: Throwable -> L72
    L52:
        r112 = "null";
    L58:
        g r114 = g.e();     // Catch: Throwable -> L72
        List<fz2.d> r115 = r114.f163047h;     // Catch: Throwable -> L72
        if (r115 != null) goto L61;
        return;
    L61:
        if (((CopyOnWriteArrayList) r115).size() <= 0) goto L94;
        Iterator r116 = ((CopyOnWriteArrayList) r114.f163047h).iterator();     // Catch: Throwable -> L72
    L63:
        if (r116.hasNext() == false) goto L95;
        fz2.d r117 = (fz2.d) r116.next();     // Catch: Throwable -> L72
        if (r117 == null) goto L63;
        r117.a(r106, r102, r103);     // Catch: Throwable -> L69
    L69:
        th = move-exception;
        com.bytedance.android.monitorV2.util.f.b(th);     // Catch: Throwable -> L72
        goto L63
    L95:
        return;
    L94:
        return;
    L41:
        if (Intrinsics.areEqual("jsbPerfV2", r102) == true) goto L46;
        if (Intrinsics.areEqual("custom", r102) == true) goto L46;
        r107 = false;
    L72:
        th = move-exception;
        com.bytedance.android.monitorV2.util.f.b(th);
        return;
    L84:
        if ((r100 instanceof com.bytedance.android.monitorV2.webview.a) == true) goto L30;
        nz2.b.f("DataReporter", "use another " + r100);     // Catch: Throwable -> L34
        r100.a(r103);     // Catch: Throwable -> L34
        goto L31
    L22:
        if (com.bytedance.android.monitorV2.util.d.d(r104) == false) goto L25;
        JSONObject r118 = new JSONObject();
        l.q(r118, ReportCardMonitorPlugin.EVENT_NAME, r102);
        l.q(r118, "bid", r104);
        gz2.c.f("hybridmonitor_report_sample_before_send", r118);
    L15:
        e = move-exception;
        com.bytedance.android.monitorV2.util.f.b(e);
    L17:
        r104 = "";
        goto L18
    L82:
        r104 = JSONObjectProtectorUtils.getString(JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(r101, "nativeBase"), "bid_info"), "setting_bid");     // Catch: JSONException -> L11
    L11:
        e = move-exception;
        com.bytedance.android.monitorV2.util.f.b(e);
    L75:
        if (r111 == null) goto L96;
        r111.onEventTerminated(HybridEvent.TerminateType.PARAM_EXCEPTION);
        return;
    }
}
