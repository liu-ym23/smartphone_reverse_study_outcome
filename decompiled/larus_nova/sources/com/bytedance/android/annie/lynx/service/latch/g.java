package com.bytedance.android.annie.lynx.service.latch;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.view.View;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.service.latch.ILatchService;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.android.latch.LatchProcessOptions;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.mt.protector.impl.UriProtector;
import com.lynx.tasm.LynxView;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class g implements com.bytedance.android.annie.lynx.service.latch.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f39565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f39566b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Pair<Boolean, Long>> f39567c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f39568d;

    public static final class a {
    }

    public static final class b implements ILatchService.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f39569a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ILatchService.d f39570b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ g f39571c;

        @Override // com.bytedance.android.annie.service.latch.ILatchService.a
        public final void a(ILatchService.c r110) {
            Intrinsics.checkNotNullParameter(r110, "perfMetric");
            j9.b r100 = ((k9.e) Annie.getService$default(k9.e.class, null, 2, null)).H0();
            String r101 = this.f39569a;
            JSONObject r102 = r110.f39880b;
            JSONObject r103 = r110.f39879a;
            JSONObject r104 = r110.f39881c;
            JSONObject r105 = new JSONObject();
            g r111 = this.f39571c;
            com.bytedance.android.annie.ng.a r112 = com.bytedance.android.annie.ng.g.f39671c.get(r111.f39565a);
            if (r112 == null) goto L8;
            o8.f r113 = r112.f39644b;
            if (r113 == null) goto L8;
            String r114 = r113.f522331a;
            if (r114 == null) goto L8;
        L9:
            r105.put("virtual_aid", r114);
            Unit r115 = Unit.INSTANCE;
            r100.b(null, "latch_timeline", r101, r102, r103, r104, r105, 1, this.f39570b.f39886e);
            return;
        L8:
            r114 = "88888";
            goto L9
        }

        @Override // com.bytedance.android.annie.service.latch.ILatchService.a
        public final void b(ILatchService.b r110) {
            Intrinsics.checkNotNullParameter(r110, "jsbPromiseMetric");
            j9.b r100 = ((k9.e) Annie.getService$default(k9.e.class, null, 2, null)).H0();
            String r101 = this.f39569a;
            JSONObject r102 = r110.f39876a;
            JSONObject r111 = new JSONObject();
            g r103 = this.f39571c;
            ConcurrentHashMap<String, com.bytedance.android.annie.ng.a> r112 = com.bytedance.android.annie.ng.g.f39671c;
            com.bytedance.android.annie.ng.a r104 = r112.get(r103.f39565a);
            if (r104 == null) goto L8;
            o8.f r105 = r104.f39644b;
            if (r105 == null) goto L8;
            String r106 = r105.f522331a;
            if (r106 == null) goto L8;
        L9:
            r111.put("virtual_aid", r106);
            Unit r107 = Unit.INSTANCE;
            r100.b(null, "latch_jsb_promise", r101, r102, null, null, r111, 1, this.f39570b.f39886e);
            Object r108 = r110.f39876a.get("status_code");
            if ((r108 instanceof Integer) == false) goto L12;
            Integer r109 = (Integer) r108;
        L13:
            if (r109 != null) goto L16;
            return;
        L16:
            if (r109.intValue() != 1) goto L26;
            j9.b r113 = ((k9.e) Annie.getService$default(k9.e.class, null, 2, null)).H0();
            String r114 = this.f39569a;
            JSONObject r115 = r110.f39876a;
            JSONObject r116 = r110.f39877b;
            JSONObject r117 = r110.f39878c;
            JSONObject r118 = new JSONObject();
            com.bytedance.android.annie.ng.a r119 = r112.get(this.f39571c.f39565a);
            if (r119 == null) goto L23;
            o8.f r120 = r119.f39644b;
            if (r120 == null) goto L23;
            String r121 = r120.f522331a;
            if (r121 == null) goto L23;
        L24:
            r118.put("virtual_aid", r121);
            r113.b(null, "latch_jsb_promise_fail", r114, r115, r116, r117, r118, 0, this.f39570b.f39886e);
            return;
        L23:
            r121 = "88888";
            goto L24
        L26:
            return;
        L12:
            r109 = null;
        L8:
            r106 = "88888";
            goto L9
        }

        public b(String r100, ILatchService.d r101, g r102) {
            this.f39569a = r100;
            this.f39570b = r101;
            this.f39571c = r102;
        }

        @Override // com.bytedance.android.annie.service.latch.ILatchService.a
        public final void c(int r210, int r211, String r212, String r213, int r214, String r215, Map<String, ? extends Object> r216) {
            Intrinsics.checkNotNullParameter(r212, "transferType");
            Intrinsics.checkNotNullParameter(r213, "errMessage");
            Intrinsics.checkNotNullParameter(r215, "engineType");
            Intrinsics.checkNotNullParameter(r216, "extras");
            j9.b r110 = ((k9.e) Annie.getService$default(k9.e.class, null, 2, null)).H0();
            String r111 = this.f39569a;
            JSONObject r112 = new JSONObject();
            r112.put("cached", r211);
            r112.put("status_code", r210);
            r112.put("transfer_type", r212);
            r112.put(LocationMonitorConst.ERR_MSG, r213);
            r112.put("timeout", r214);
            r112.put("engine_type", r215);
            Iterator<Map.Entry<String, ? extends Object>> r100 = r216.entrySet().iterator();
        L4:
            if (r100.hasNext() == false) goto L6;
            Map.Entry<String, ? extends Object> r101 = r100.next();
            r112.put(r101.getKey(), r101.getValue());
            goto L4
        L6:
            Unit r102 = Unit.INSTANCE;
            JSONObject r103 = new JSONObject();
            g r104 = this.f39571c;
            com.bytedance.android.annie.ng.a r105 = com.bytedance.android.annie.ng.g.f39671c.get(r104.f39565a);
            String r106 = "88888";
            if (r105 == null) goto L12;
            o8.f r107 = r105.f39644b;
            if (r107 == null) goto L12;
            String r108 = r107.f522331a;
            if (r108 == null) goto L12;
        L13:
            r103.put("virtual_aid", r108);
            r110.b(null, "latch_result_all", r111, r112, null, null, r103, 1, this.f39570b.f39886e);
            if (r210 == 1) goto L31;
            j9.b r113 = ((k9.e) Annie.getService$default(k9.e.class, null, 2, null)).H0();
            String r114 = this.f39569a;
            JSONObject r115 = new JSONObject();
            r115.put("status_code", r210);
            r115.put(LocationMonitorConst.ERR_MSG, r213);
            r115.put("timeout", r214);
            Iterator<Map.Entry<String, ? extends Object>> r109 = r216.entrySet().iterator();
        L17:
            if (r109.hasNext() == false) goto L19;
            Map.Entry<String, ? extends Object> r116 = r109.next();
            r115.put(r116.getKey(), r116.getValue());
            goto L17
        L19:
            Unit r117 = Unit.INSTANCE;
            JSONObject r118 = new JSONObject();
            g r119 = this.f39571c;
            com.bytedance.android.annie.ng.a r120 = com.bytedance.android.annie.ng.g.f39671c.get(r119.f39565a);
            if (r120 == null) goto L27;
            o8.f r121 = r120.f39644b;
            if (r121 == null) goto L27;
            String r122 = r121.f522331a;
            if (r122 == null) goto L27;
            r106 = r122;
        L27:
            r118.put("virtual_aid", r106);
            r113.b(null, "latch_result_error", r114, r115, null, null, r118, 0, this.f39570b.f39886e);
            return;
        L31:
            return;
        L12:
            r108 = "88888";
            goto L13
        }
    }

    static {
    }

    @Override // com.bytedance.android.annie.service.latch.ILatchService
    public final void initPrefetch() {
        Map<String, com.bytedance.android.latch.prefetch.internal.g> r100 = LatchPrefetchProcessorHolder.f39534a;
        LatchPrefetchProcessorHolder.a(((com.bytedance.android.annie.service.resource.f) Annie.getService$default(com.bytedance.android.annie.service.resource.f.class, null, 2, null)).r());
    }

    public g(int r100) {
        Intrinsics.checkNotNullParameter("host", "mBizKey");
        this.f39565a = "host";
        this.f39566b = LazyKt.lazy(LatchServiceImpl$latch$2.INSTANCE);
        this.f39567c = new LinkedHashMap();
        this.f39568d = new f();
    }

    public final LatchProcessOptions H1(ILatchService.d r100) {
        LatchProcessOptions r101 = new LatchProcessOptions();
        String r102 = r100.f39882a;
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r101.f58204a = r102;
        r101.f58205b = r100.f39883b;
        ILatchService.a r103 = r100.f39885d;
        if (r103 == null) goto L5;
        h r104 = new h(r103, this);
    L6:
        r101.f58207d = r104;
        String r105 = r100.f39884c;
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        r101.f58206c = r105;
        Map<String, String> r106 = r100.f39888g;
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r101.f58209f = r106;
        if (r100.f39887f == false) goto L9;
        LatchProcessOptions.PrefetchPartial r107 = LatchProcessOptions.PrefetchPartial.NATIVE;
    L10:
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        r101.f58208e = r107;
        return r101;
    L9:
        r107 = LatchProcessOptions.PrefetchPartial.LATCH;
        goto L10
    L5:
        r104 = null;
        goto L6
    }

    @Override // com.bytedance.android.annie.service.latch.ILatchService
    public final boolean O0(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        return r100 instanceof gx.a;
    }

    @Override // com.bytedance.android.annie.service.latch.ILatchService
    public final void Q0(String r110) {
        Intrinsics.checkNotNullParameter(r110, "url");
        j r100 = j.f39576a;
        String r101 = this.f39565a;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r110, "url");
        Intrinsics.checkNotNullParameter(r101, "bizKey");
        LinkedList r102 = (LinkedList) ((LinkedHashMap) j.f39577b).get(r110);
        if (r102 != null) goto L5;
        return;
    L5:
        if ((!r102.isEmpty()) == true) goto L8;
        r102 = null;
    L8:
        if (r102 == null) goto L20;
        j9.b r103 = ((k9.e) Annie.getService$default(k9.e.class, null, 2, null)).H0();
        JSONObject r104 = new JSONObject();
        r104.put("optimize_type", 2);
        Unit r105 = Unit.INSTANCE;
        JSONObject r106 = new JSONObject();
        r106.put("duration", SystemClock.elapsedRealtime() - ((Number) r102.removeFirst()).longValue());
        JSONObject r107 = new JSONObject();
        com.bytedance.android.annie.ng.a r108 = com.bytedance.android.annie.ng.g.f39671c.get(r101);
        if (r108 == null) goto L16;
        o8.f r109 = r108.f39644b;
        if (r109 == null) goto L16;
        String r111 = r109.f522331a;
        if (r111 == null) goto L16;
    L17:
        r107.put("virtual_aid", r111);
        j9.b.a.a(r103, null, "latch_ng_callback", r110, r104, r106, null, r107, 0, 256);
        return;
    L16:
        r111 = "88888";
        goto L17
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.annie.service.latch.ILatchService
    public final String R0(View r100) {
        if ((r100 instanceof gx.a) == false) goto L5;
        gx.a r101 = (gx.a) r100;
    L6:
        if (r101 != null) goto L8;
        return null;
    L8:
        return r101.getUrl();
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.bytedance.android.annie.service.latch.ILatchService
    public final void S0(String r110) {
        Intrinsics.checkNotNullParameter(r110, "url");
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L5
        Object r101 = Result.m9449constructorimpl(UriProtector.parse(r110).getPath());     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r101) == false) goto L10;
        r101 = null;
    L10:
        String r102 = (String) r101;
        if (r102 != null) goto L13;
        return;
    L13:
        Pair<Boolean, Long> r103 = this.f39567c.remove(r102);
        if (r103 != null) goto L16;
        return;
    L16:
        boolean r104 = r103.component1().booleanValue();
        long r105 = r103.component2().longValue();
        j9.b r106 = ((k9.e) Annie.getService$default(k9.e.class, null, 2, null)).H0();
        JSONObject r107 = new JSONObject();
        if (r104 == false) goto L19;
        int r108 = 3;
    L20:
        r107.put("optimize_type", r108);
        Unit r109 = Unit.INSTANCE;
        JSONObject r111 = new JSONObject();
        r111.put("duration", SystemClock.elapsedRealtime() - r105);
        JSONObject r112 = new JSONObject();
        com.bytedance.android.annie.ng.a r113 = com.bytedance.android.annie.ng.g.f39671c.get(this.f39565a);
        if (r113 == null) goto L26;
        o8.f r114 = r113.f39644b;
        if (r114 == null) goto L26;
        String r115 = r114.f522331a;
        if (r115 == null) goto L26;
    L27:
        r112.put("virtual_aid", r115);
        j9.b.a.a(r106, null, "latch_ng_callback", r110, r107, r111, null, r112, 0, 256);
        return;
    L26:
        r115 = "88888";
        goto L27
    L19:
        r108 = 4;
    L5:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    @Override // com.bytedance.android.annie.service.latch.ILatchService
    public final boolean c(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        return r100 instanceof LynxView;
    L5:
        return false;
    }

    @Override // com.bytedance.android.annie.service.latch.ILatchService
    public final String i(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        String r101 = UriProtector.getQueryParameter(r100, "latch_id");
        if (r101 != null) goto L5;
        return null;
    L5:
        if ((!StringsKt.isBlank(r101)) == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L16;
        Integer r102 = StringsKt.toIntOrNull(r101);
        if (r102 == null) goto L17;
        int r103 = r102.intValue();
        Pair r104 = (Pair) ((LinkedHashMap) this.f39568d.f39563a).get(Integer.valueOf(r103));
        if (r104 != null) goto L14;
        return null;
    L14:
        return (String) r104.getSecond();
    L17:
        return null;
    L16:
        return null;
    }

    @Override // com.bytedance.android.annie.service.latch.ILatchService
    public final void s(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        String r101 = UriProtector.getQueryParameter(r100, "latch_id");
        if (r101 == null) goto L17;
        ILatchService.e r102 = null;
        if ((!StringsKt.isBlank(r101)) == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L18;
        Integer r103 = StringsKt.toIntOrNull(r101);
        if (r103 == null) goto L19;
        Pair<ILatchService.e, String> r104 = this.f39568d.f39563a.remove(Integer.valueOf(r103.intValue()));
        if (r104 == null) goto L14;
        r102 = r104.getFirst();
    L14:
        if (r102 == null) goto L20;
        r102.dispose();
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    }

    @Override // com.bytedance.android.annie.service.latch.ILatchService
    public final void d(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl(UriProtector.parse(r100).getPath());     // Catch: Throwable -> L5
    L8:
        if (Result.m9455isFailureimpl(r103) == false) goto L10;
        r103 = null;
    L10:
        String r104 = (String) r103;
        if (r104 == null) goto L16;
        this.f39567c.put(r104, new Pair(Boolean.valueOf(r101), Long.valueOf(SystemClock.elapsedRealtime())));
        return;
    L16:
        return;
    L5:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    @Override // com.bytedance.android.annie.service.latch.ILatchService
    public final Pair<ILatchService.PrefetchStrategy, String> k(Uri r210, String r211) {
        Intrinsics.checkNotNullParameter(r210, "uri");
        Intrinsics.checkNotNullParameter(r211, "url");
        j r100 = j.f39576a;
        String r101 = this.f39565a;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r210, "uri");
        Intrinsics.checkNotNullParameter(r211, "url");
        Intrinsics.checkNotNullParameter(r101, "bizKey");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L23
        String r103 = UriProtector.getQueryParameter(r210, "enable_prefetch");     // Catch: Throwable -> L23
        String r104 = UriProtector.getQueryParameter(r210, "enable_latch");     // Catch: Throwable -> L23
        if (r103 != null) goto L6;
    L9:
        boolean r105 = true;
    L10:
        if (r105 == false) goto L21;
        if (r104 != null) goto L14;
    L17:
        boolean r106 = true;
    L18:
        if (r106 == true) goto L20;
        r103 = r104;
        goto L21
    L20:
        r103 = UriProtector.getQueryParameter(UriProtector.parse(r211), "use_latch_ng");     // Catch: Throwable -> L23
        goto L21
    L14:
        if (StringsKt.isBlank(r104) == true) goto L17;
        r106 = false;
    L21:
        Object r107 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L23
    L26:
        if (Result.m9455isFailureimpl(r107) == false) goto L28;
        r107 = null;
    L28:
        String r108 = (String) r107;
        if (Intrinsics.areEqual(r108, "1") == true) goto L31;
        String r109 = "check if scheme append enable_latch or enable_prefetch.";
    L32:
        y9.i<Integer> r110 = AnnieConfigSettingKeys.ENABLE_LATCH;
        Integer r111 = r110.a();
        if (r111 != null) goto L36;
    L37:
        r109 = "check if current appVersion support Latch.";
    L38:
        String r112 = r109;
        if (Intrinsics.areEqual(r108, "1") == false) goto L46;
        Integer r113 = r110.a();
        if (r113 != null) goto L44;
    L45:
        r108 = "";
        goto L46
    L44:
        if (r113.intValue() != 1) goto L45;
    L46:
        if (r108 == null) goto L81;
        String r114 = "88888";
        switch(r108.hashCode()) {
            case 48: goto L78;
            case 49: goto L66;
            case 50: goto L51;
            default: goto L81;
        };
    L51:
        if (r108.equals("2") == false) goto L81;
        ILatchService.PrefetchStrategy r115 = ILatchService.PrefetchStrategy.Prefetch;
        j9.b r116 = ((k9.e) Annie.getService$default(k9.e.class, null, 2, null)).H0();
        JSONObject r117 = new JSONObject();
        r117.put("optimize_type", 2);
        Unit r118 = Unit.INSTANCE;
        JSONObject r119 = new JSONObject();
        com.bytedance.android.annie.ng.a r120 = com.bytedance.android.annie.ng.g.f39671c.get(r101);
        if (r120 == null) goto L61;
        o8.f r121 = r120.f39644b;
        if (r121 == null) goto L61;
        String r122 = r121.f522331a;
        if (r122 == null) goto L61;
        r114 = r122;
    L61:
        r119.put("virtual_aid", r114);
        j9.b.a.a(r116, null, "latch_ng_start", r211, r117, null, null, r119, 0, 256);
        LinkedHashMap r123 = (LinkedHashMap) j.f39577b;
        Object r124 = r123.get(r211);
        if (r124 != null) goto L64;
        r124 = new LinkedList();
        r123.put(r211, r124);
    L64:
        ((LinkedList) r124).push(Long.valueOf(SystemClock.elapsedRealtime()));
        ((ILatchService) Annie.getService$default(ILatchService.class, null, 2, null)).d(r211, false);
    L83:
        return new Pair(r115, r112);
    L66:
        if (r108.equals("1") == false) goto L81;
        ILatchService.PrefetchStrategy r125 = ILatchService.PrefetchStrategy.Latch;
        j9.b r126 = ((k9.e) Annie.getService$default(k9.e.class, null, 2, null)).H0();
        JSONObject r127 = new JSONObject();
        r127.put("optimize_type", 1);
        Unit r128 = Unit.INSTANCE;
        JSONObject r129 = new JSONObject();
        com.bytedance.android.annie.ng.a r130 = com.bytedance.android.annie.ng.g.f39671c.get(r101);
        if (r130 == null) goto L76;
        o8.f r131 = r130.f39644b;
        if (r131 == null) goto L76;
        String r132 = r131.f522331a;
        if (r132 == null) goto L76;
        r114 = r132;
    L76:
        r129.put("virtual_aid", r114);
        j9.b.a.a(r126, null, "latch_ng_start", r211, r127, null, null, r129, 0, 256);
        ((ILatchService) Annie.getService$default(ILatchService.class, null, 2, null)).d(r211, true);
        r115 = r125;
        goto L83
    L78:
        if (r108.equals("0") == false) goto L81;
        r115 = ILatchService.PrefetchStrategy.Nothing;
    L81:
        r115 = ILatchService.PrefetchStrategy.Prefetch;
        goto L83
    L36:
        if (r111.intValue() == 1) goto L38;
    L31:
        r109 = "";
        goto L32
    L6:
        if (StringsKt.isBlank(r103) == true) goto L9;
        r105 = false;
    L23:
        th = move-exception;
        Result.Companion r133 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L26
    }

    @Override // com.bytedance.android.annie.service.latch.ILatchService
    public final int d1(Context r100, String r110, Uri r111, ILatchService.d r112) {
        Intrinsics.checkNotNullParameter(r111, "schema");
        Intrinsics.checkNotNullParameter(r112, "latchProcessOptions");
        if (r110 != null) goto L6;
        return -1;
    L6:
        String r101 = UUID.randomUUID().toString();
        boolean r102 = false;
        boolean r103 = r111.getBooleanQueryParameter("enableLatchXBridge", false);
        r112.f39886e = r101;
        int r104 = com.bytedance.android.latch.b.f58213c;
        com.bytedance.android.latch.b.a.a(r112.f39888g, "enableRegisterXBridge", r103);
        com.bytedance.android.latch.b.a.a(r112.f39888g, "enableCheckVersion", AnnieConfigSettingKeys.LATCH_ENABLE_CHECK_VERSION.a().booleanValue());
        f r105 = this.f39568d;
        ex.a r106 = (ex.a) this.f39566b.getValue();
        Uri.Builder r107 = UriProtector.parse(r110).buildUpon();
        String r108 = UriProtector.getQueryParameter(r111, "loader_name");
        if (r108 == null) goto L9;
        r107.appendQueryParameter("loader_name", r108);
        r102 = true;
    L9:
        String r109 = UriProtector.getQueryParameter(r111, "lock_resource");
        if (r109 == null) goto L18;
        r107.appendQueryParameter("lock_resource", r109);
        String r113 = UriProtector.getQueryParameter(r111, "forest_session_id");
        if (r113 != null) goto L14;
    L17:
        r102 = true;
        goto L18
    L14:
        if (StringsKt.isBlank(r113) == false) goto L16;
        r113 = r101;
    L16:
        r107.appendQueryParameter("forest_session_id", r113);
    L18:
        if (r102 == false) goto L20;
        String r114 = r107.build().toString();
    L21:
        String r115 = UriProtector.getQueryParameter(r111, "open_time");
        Long r116 = null;
        if (r115 != null) goto L24;
    L29:
        i r117 = new i(r106.b(r100, r110, new c(r100, r111, r114, r116), H1(r112)));
        r105.getClass();
        Intrinsics.checkNotNullParameter(r117, "process");
        Intrinsics.checkNotNullParameter(r101, ST.UUID_DEVICE);
        int r118 = r105.f39564b.incrementAndGet();
        r105.f39563a.put(Integer.valueOf(r118), TuplesKt.to(r117, r101));
        return r118;
    L24:
        if ((!StringsKt.isBlank(r115)) == true) goto L27;
        r115 = null;
    L27:
        if (r115 == null) goto L29;
        r116 = StringsKt.toLongOrNull(r115);
        goto L29
    L20:
        r114 = r110;
        goto L21
    }

    @Override // com.bytedance.android.annie.service.latch.ILatchService
    public final ILatchService.d e(long r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "display");
        Intrinsics.checkNotNullParameter(r102, "errMsg");
        ILatchService.d r104 = new ILatchService.d();
        r104.f39883b = r100;
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r104.f39884c = r101;
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r104.f39882a = r102;
        r104.f39887f = AnnieConfigSettingKeys.LATCH_PREFER_NATIVE_PREFETCH.a().booleanValue();
        r104.f39885d = new b(r103, r104, this);
        return r104;
    }

    @Override // com.bytedance.android.annie.service.latch.ILatchService
    public final ILatchService.e u0(Context r100, String r101, Uri r102, long r103, ILatchService.d r104, boolean r110) {
        Intrinsics.checkNotNullParameter(r102, "schema");
        Intrinsics.checkNotNullParameter(r104, "latchProcessOptions");
        if (r110 == false) goto L5;
        if (r100 != null) goto L8;
        String r111 = "context is null";
    L12:
        if (r111.length() <= 0) goto L14;
        boolean r105 = true;
    L15:
        if (r105 == false) goto L18;
        ex.a r106 = (ex.a) this.f39566b.getValue();
        LatchProcessOptions r107 = H1(r104);
        Intrinsics.checkNotNullParameter(r111, "<set-?>");
        r107.f58204a = r111;
        Unit r108 = Unit.INSTANCE;
        return new i(r106.a(r107));
    L18:
        String r112 = UriProtector.getQueryParameter(r102, "latch_id");
        ILatchService.e r109 = null;
        if (r112 != null) goto L21;
    L26:
        Integer r113 = null;
    L27:
        if (r113 == null) goto L33;
        Pair<ILatchService.e, String> r114 = this.f39568d.f39563a.remove(Integer.valueOf(r113.intValue()));
        if (r114 == null) goto L31;
        r109 = r114.getFirst();
    L31:
        if (r109 == null) goto L33;
        return r109;
    L33:
        ex.a r115 = (ex.a) this.f39566b.getValue();
        Intrinsics.checkNotNull(r100);
        Intrinsics.checkNotNull(r101);
        return new i(r115.b(r100, r101, new c(r100, r102, r101, Long.valueOf(r103)), H1(r104)));
    L21:
        if ((true ^ StringsKt.isBlank(r112)) == true) goto L24;
        r112 = null;
    L24:
        if (r112 == null) goto L26;
        r113 = StringsKt.toIntOrNull(r112);
        goto L27
    L14:
        r105 = false;
        goto L15
    L8:
        if (r101 != null) goto L10;
        r111 = "url is null";
        goto L12
    L10:
        r111 = "";
        goto L12
    L5:
        return new i(((ex.a) this.f39566b.getValue()).a(H1(r104)));
    }
}
