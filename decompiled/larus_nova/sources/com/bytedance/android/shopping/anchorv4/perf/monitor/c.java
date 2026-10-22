package com.bytedance.android.shopping.anchorv4.perf.monitor;

import android.net.Uri;
import android.view.Choreographer;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.core.monitor.ECMonitorService;
import com.bytedance.android.ec.core.utils.k0;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.android.shopping.anchorv4.dto.PackParsedDTO;
import com.bytedance.android.shopping.anchorv4.dto.PackResponseDTO;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.dto.meta.PageMeta;
import com.bytedance.android.shopping.anchorv4.experiment.PdpAB;
import com.bytedance.android.shopping.anchorv4.helper.t;
import com.bytedance.android.shopping.anchorv4.helper.u;
import com.bytedance.android.shopping.anchorv4.params.V4NativeParams;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.ugc.aweme.search.vision.model.data.PhotoEnterModel;
import di.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static float f167219j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f167220k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f167221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.shopping.anchorv4.perf.monitor.a f167222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f167223c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f167224d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f167225e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f167226f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f167227g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function1<? super com.bytedance.android.ecom.arch.slice.render.event.a, Unit> f167228h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.bytedance.android.ec.monitor.duration.d f167229i;

    public static final class a {
        public a() {
        }

        public static c a(AnchorV4VM r100) {
            if (r100 == null) goto L5;
            String r101 = r100.getSessionId();
        L6:
            u r102 = t.a(r101);
            if (r102 != null) goto L9;
            return null;
        L9:
            return r102.f166995d;
        L5:
            r101 = null;
            goto L6
        }
    }

    public static final class b implements Choreographer.FrameCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f167230a;

        public b(c r100) {
            this.f167230a = r100;
        }

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long r100) {
            final c r101 = this.f167230a;
            r101.f167225e = false;
            r101.f167224d = true;
            if (r101.f167227g != 2) goto L6;
            i r102 = r101.f167221a;
            r102.f167249h = Long.valueOf(System.currentTimeMillis());
            r101.f167228h = new PdpPerfMonitorManager$onDoFrameBegin$1(r101);
            return;
        }
    }

    static {
        f167220k = new a();
    }

    public final void c() {
        if (this.f167226f == false) goto L6;
        i r100 = this.f167221a;
        r100.f167255n = Long.valueOf(System.currentTimeMillis());
        return;
    }

    public final void d() {
        if (this.f167226f == false) goto L6;
        i r100 = this.f167221a;
        r100.f167256o = Long.valueOf(System.currentTimeMillis());
        return;
    }

    public final void h() {
        if (this.f167226f == false) goto L6;
        i r100 = this.f167221a;
        r100.f167253l = Long.valueOf(System.currentTimeMillis());
        return;
    }

    public final void i() {
        if (this.f167226f == false) goto L6;
        i r100 = this.f167221a;
        r100.f167254m = Long.valueOf(System.currentTimeMillis());
        return;
    }

    public final void l() {
        if (this.f167225e == true) goto L6;
        this.f167225e = true;
        Choreographer.getInstance().postFrameCallback(new b(this));
        return;
    }

    public c(com.bytedance.android.ec.monitor.duration.d r100) {
        Intrinsics.checkNotNullParameter(r100, "mainMonitor");
        this.f167229i = r100;
        i r101 = new i();
        this.f167221a = r101;
        com.bytedance.android.shopping.anchorv4.perf.monitor.a r102 = new com.bytedance.android.shopping.anchorv4.perf.monitor.a(0);
        this.f167222b = r102;
        this.f167223c = new k(r101, r102);
    }

    public final void e(PackResponseDTO r100) {
        Intrinsics.checkNotNullParameter(r100, "packDTO");
        com.bytedance.android.shopping.anchorv4.perf.monitor.a r101 = this.f167222b;
        PackParsedDTO r102 = r100.getParsedDTO();
        if (r102 == null) goto L7;
        PageMeta r103 = r102.getPageMeta();
        if (r103 == null) goto L7;
        Map<String, String> r104 = r103.getServerMonitorMeta();
    L8:
        r101.f167203m = r104;
        com.bytedance.android.shopping.anchorv4.perf.monitor.a r105 = this.f167222b;
        r105.f167192b = r100.isChunk();
        i r106 = this.f167221a;
        r106.f167266y = Long.valueOf(System.currentTimeMillis());
        this.f167229i.a("request_end");
        return;
    L7:
        r104 = null;
        goto L8
    }

    public final void f(Long r100) {
        if (r100 == null) goto L4;
        long r101 = r100.longValue();
    L5:
        i r102 = this.f167221a;
        r102.f167248g = Long.valueOf(r101);
        this.f167229i.d("render_start", r101);
        return;
    L4:
        r101 = System.currentTimeMillis();
        goto L5
    }

    public final void j(PackResponseDTO r100) {
        Intrinsics.checkNotNullParameter(r100, "packDTO");
        if (this.f167226f == true) goto L33;
        this.f167226f = true;
        this.f167222b.f167191a = r100.getFromCache();
        com.bytedance.android.shopping.anchorv4.perf.monitor.a r101 = this.f167222b;
        PackParsedDTO r102 = r100.getParsedDTO();
        AnchorV4HeadV2VO r103 = null;
        if (r102 == null) goto L11;
        PageMeta r104 = r102.getPageMeta();
        if (r104 == null) goto L11;
        CommonMeta r105 = r104.getCommonMeta();
        if (r105 == null) goto L11;
        String r106 = r105.getProductId();
    L12:
        if (r106 != null) goto L14;
        r106 = "";
    L14:
        r101.f167204n = r106;
        k r107 = this.f167223c;
        PackParsedDTO r108 = r100.getParsedDTO();
        j r109 = r107.f167279a;
        if (r108 == null) goto L17;
        AnchorV4HeadV2VO r110 = r108.getHeaderV2();
    L18:
        r109.f167272f = k.c(r110);
        j r111 = r107.f167279a;
        if (r108 == null) goto L21;
        r103 = r108.getHeaderV2();
    L21:
        r111.f167273g = k.d(r103);
        j r112 = r107.f167279a;
        if (r108 == null) goto L30;
        PageMeta r113 = r108.getPageMeta();
        if (r113 == null) goto L30;
        CommonMeta r114 = r113.getCommonMeta();
        if (r114 == null) goto L30;
        Boolean r115 = r114.getHasGirdle();
        if (r115 == null) goto L30;
        boolean r116 = r115.booleanValue();
    L31:
        r112.f167274h = r116;
        r107.f167279a.f167278l = r108;
        return;
    L30:
        r116 = false;
        goto L31
    L17:
        r110 = null;
    L11:
        r106 = null;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r15v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [org.json.JSONObject] */
    public static final void a(c r210, JSONObject r211, V4NativeParams r212) {
        r210.f167221a.f167252k = Long.valueOf(r211.optLong("render_end"));
        if (r212 == null) goto L11;
        String r100 = r212.getPdpEventTransparentId();
        if (r100 == null) goto L11;
        boolean r101 = ECServiceManager.f42805a;
        s83.g r102 = (s83.g) ECServiceManager.c(s83.g.class);
        LinkedHashMap r103 = new LinkedHashMap();
        Long r104 = r210.f167221a.f167252k;
        if (r104 == null) goto L9;
        long r105 = r104.longValue();
    L10:
        r103.put("interactive_time", Long.valueOf(r105));
        r103.put("pdp_event_transparent_id", r100);
        Unit r106 = Unit.INSTANCE;
        r102.k(r103);
        goto L11
    L9:
        r105 = 0;
    L11:
        i r107 = r210.f167221a;
        Long r108 = i.a(r107.f167243b, r107.f167245d);
        if (r108 == null) goto L14;
        r211.put("timing_starter_duration", r108.longValue());
    L14:
        Long r109 = i.a(Long.valueOf(r210.f167221a.f167244c), r210.f167221a.f167245d);
        if (r109 == null) goto L17;
        r211.put("timing_prepare_duration", r109.longValue());
    L17:
        i r110 = r210.f167221a;
        Long r111 = i.a(r110.f167245d, r110.f167246e);
        if (r111 == null) goto L20;
        r211.put("timing_open_duration", r111.longValue());
    L20:
        i r112 = r210.f167221a;
        Long r113 = i.a(r112.f167246e, r112.f167247f);
        if (r113 == null) goto L23;
        r211.put("timing_display_duration", r113.longValue());
    L23:
        i r114 = r210.f167221a;
        Long r115 = i.a(r114.f167247f, r114.f167248g);
        if (r115 == null) goto L26;
        r211.put("timing_dataload_duration", r115.longValue());
    L26:
        Long r116 = i.a(Long.valueOf(r210.f167221a.f167244c), r210.f167221a.f167247f);
        if (r116 == null) goto L29;
        r211.put("init_duration", r116.longValue());
    L29:
        i r117 = r210.f167221a;
        Long r118 = i.a(r117.f167248g, r117.f167249h);
        if (r118 == null) goto L32;
        r211.put("render_before_duration", r118.longValue());
    L32:
        i r119 = r210.f167221a;
        Long r120 = i.a(r119.f167249h, r119.f167251j);
        if (r120 == null) goto L35;
        r211.put("render_inner_duration", r120.longValue());
    L35:
        i r121 = r210.f167221a;
        Long r122 = i.a(r121.f167251j, r121.f167252k);
        if (r122 == null) goto L38;
        r211.put("render_after_duration", r122.longValue());
    L38:
        i r123 = r210.f167221a;
        Long r124 = i.a(r123.f167250i, r123.f167251j);
        if (r124 == null) goto L41;
        r211.put("render_draw_duration", r124.longValue());
    L41:
        i r125 = r210.f167221a;
        Long r126 = i.a(r125.f167253l, r125.f167254m);
        if (r126 == null) goto L44;
        r211.put("top_nav_bind_duration", r126.longValue());
    L44:
        i r127 = r210.f167221a;
        Long r128 = i.a(r127.f167255n, r127.f167256o);
        if (r128 == null) goto L47;
        r211.put("bottom_nav_bind_duration", r128.longValue());
    L47:
        i r129 = r210.f167221a;
        Long r130 = i.a(r129.f167242a, r129.f167252k);
        if (r130 == null) goto L50;
        r211.put("total_duration", r130.longValue());
    L50:
        i r131 = r210.f167221a;
        Long r132 = i.a(r131.f167242a, Long.valueOf(r131.f167244c));
        if (r132 == null) goto L53;
        r211.put("pre_entry_duration", r132.longValue());
    L53:
        int r133 = h.f167241a;
        r211.put("slc_expr_duration", Float.valueOf(Math.round(r210.f167222b.f167209s / 1000.0f) / 1000.0f));
        r211.put("slc_layout_duration", Float.valueOf(Math.round(r210.f167222b.f167213w / 1000.0f) / 1000.0f));
        r211.put("slc_create_view_duration", Float.valueOf(Math.round(r210.f167222b.f167212v / 1000.0f) / 1000.0f));
        r211.put("slc_load_template_duration", Float.valueOf(Math.round(r210.f167222b.f167211u / 1000.0f) / 1000.0f));
        r211.put("slc_update_props_duration", Float.valueOf(Math.round(r210.f167222b.f167210t / 1000.0f) / 1000.0f));
        r211.put("slc_measure_duration", Float.valueOf(Math.round(r210.f167222b.f167214x / 1000.0f) / 1000.0f));
        r211.put("slc_bind_duration", Float.valueOf(Math.round(r210.f167222b.f167208r / 1000.0f) / 1000.0f));
        r211.put("slc_view_cache_miss", r210.f167222b.f167215y);
        r211.put("slc_template_cache_miss", r210.f167222b.f167216z);
        com.bytedance.android.chunkstreamprediction.network.c r134 = r210.f167222b.f167202l;
        int r135 = 2;
        int r136 = 1;
        if (r134 == null) goto L87;
        monitor-enter(r134);
        List<com.bytedance.android.chunkstreamprediction.network.c.a> r137 = r134.f42525a;     // Catch: Throwable -> L83
        monitor-exit(r134);
        int r138 = ((ArrayList) r137).size();
        int r139 = 0;
    L59:
        if (r139 >= r138) goto L87;
        if (r139 > r135) goto L82;
        com.bytedance.android.chunkstreamprediction.network.c.a r140 = (com.bytedance.android.chunkstreamprediction.network.c.a) CollectionsKt.getOrNull(r134.a(), r139);
        if (r139 == 0) goto L68;
        if (r139 == r136) goto L67;
        if (r139 == r135) goto L66;
        String r141 = "unknown";
    L69:
        String r142 = "tt_timing_body_recv_" + r141 + "_chunk";
        if (r140 == null) goto L72;
        Long r143 = Long.valueOf(r140.f42529c - r140.f42528b);
    L73:
        r211.put(r142, r143);
        String r144 = "tt_timing_parse_" + r141 + "_chunk";
        if (r140 == null) goto L76;
        Long r145 = Long.valueOf(r140.f42530d - r140.f42529c);
    L77:
        r211.put(r144, r145);
        String r146 = "tt_resp_body_size_" + r141 + "_chunk";
        if (r140 == null) goto L80;
        Integer r147 = Integer.valueOf(r140.f42533g);
    L81:
        r211.put(r146, r147);
        goto L82
    L80:
        r147 = null;
        goto L81
    L76:
        r145 = null;
        goto L77
    L72:
        r143 = null;
        goto L73
    L66:
        r141 = com.alipay.sdk.m.k.b.f25414o;
        goto L69
    L67:
        r141 = "second";
        goto L69
    L68:
        r141 = SoloKtvContext.SOLO_PAGE_FIRST;
    L82:
        r139 = r139 + 1;
        r135 = 2;
        r136 = 1;
    L83:
        th = move-exception;
        throw th;
    L87:
        Object r148 = r210.f167222b.f167201k;
        if (r148 == null) goto L98;
        l r149 = k0.e(r148);
        if (r149 == null) goto L98;
        Map r150 = k0.d(null, r149, 1);
        if (r150 == null) goto L94;
        r211.put("tt_timing_connect", r150.get("tt_timing_connect"));
        r211.put("tt_net_duration", r150.get("tt_net_duration"));
        r211.put("tt_timing_ttfb_inner", r150.get("tt_timing_ttfb_inner"));
        r211.put("tt_timing_connect", r150.get("tt_timing_connect"));
        r211.put("tt_timing_send", r150.get("tt_timing_send"));
        r211.put("tt_timing_ttfb_edge", r150.get("tt_timing_ttfb_edge"));
        r211.put("tt_timing_ttfb_origin", r150.get("tt_timing_ttfb_origin"));
        r211.put("tt_timing_ttfb_rtt", r150.get("tt_timing_ttfb_rtt"));
        r211.put("tt_timing_req_interceptor", r150.get("tt_timing_req_interceptor"));
        r211.put("tt_timing_req_pre_process", r150.get("tt_timing_req_pre_process"));
        r211.put("tt_timing_req_create", r150.get("tt_timing_req_create"));
    L94:
        Long r151 = r149.b();
        Long r152 = r210.f167221a.f167264w;
        if (r151 == null) goto L98;
        if (r152 == null) goto L98;
        r211.put("tt_timing_req_switch_thread", r151.longValue() - r152.longValue());
    L98:
        i r153 = r210.f167221a;
        Long r154 = r153.f167266y;
        Long r155 = r153.f167265x;
        if (r154 == null) goto L102;
        if (r155 == null) goto L102;
        r211.put("tt_timing_resp_switch_thread", r154.longValue() - r155.longValue());
    L102:
        Map<String, String> r156 = r210.f167222b.f167203m;
        if (r156 == null) goto L108;
        Iterator r157 = r156.entrySet().iterator();
    L106:
        if (r157.hasNext() == false) goto L108;
        Map.Entry r158 = (Map.Entry) r157.next();
        r211.put((String) r158.getKey(), r158.getValue());
    L108:
        int r159 = h.f167241a;
        r211.put("chunk_enable", r210.f167222b.f167192b ? 1 : 0);
        r211.put("preload_is_show", r210.f167222b.f167199i ? 1 : 0);
        if (r210.f167222b.f167199i == false) goto L127;
        Long r160 = i.a(Long.valueOf(r210.f167221a.f167244c), r210.f167221a.f167260s);
        if (r160 == null) goto L113;
        r211.put("preload_duration", r160.longValue());
    L113:
        i r161 = r210.f167221a;
        Long r162 = i.a(r161.f167247f, r161.f167259r);
        if (r162 == null) goto L116;
        r211.put("preload_dataload_duration", r162.longValue());
    L116:
        i r163 = r210.f167221a;
        Long r164 = i.a(r163.f167259r, r163.f167260s);
        if (r164 == null) goto L119;
        r211.put("preload_render_duration", r164.longValue());
    L119:
        i r165 = r210.f167221a;
        Long r166 = i.a(r165.f167257p, r165.f167258q);
        if (r166 == null) goto L122;
        r211.put("preload_api_duration", r166.longValue());
    L122:
        Object r167 = r210.f167222b.f167200j;
        if (r167 == null) goto L127;
        Map r168 = k0.d(r167, null, 2);
        if (r168 == null) goto L127;
        r211.put("preload_tt_total_duration", r168.get("tt_total_duration"));
        r211.put("preload_tt_timing_connect", r168.get("tt_timing_connect"));
        r211.put("preload_tt_net_duration", r168.get("tt_net_duration"));
        r211.put("preload_tt_timing_ttfb_inner", r168.get("tt_timing_ttfb_inner"));
        r211.put("preload_tt_resp_body_size", r168.get("tt_resp_body_size"));
        r211.put("preload_tt_timing_body_recv", r168.get("tt_timing_body_recv"));
        r211.put("preload_tt_timing_parse", r168.get("tt_timing_parse"));
    L127:
        r211.put("pdp_type", r210.f167222b.f167195e);
        r211.put(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE, r210.f167222b.f167196f);
        r211.put(com.bytedance.android.ec.core.event.a.KEY_SOURCE_METHOD, r210.f167222b.f167197g);
        r211.put("ecom_entrance_from", r210.f167222b.f167198h);
        r211.put("last_ecom_scene_id", r210.f167222b.f167194d);
        r211.put("pdp_cache", r210.f167222b.f167191a ? 1 : 0);
        r211.put("pdp_times", r210.f167222b.f167193c);
        r211.put("product_id", r210.f167222b.f167204n);
        r211.put("preload_status_code", r210.f167222b.f167205o);
        r211.put("preload_is_enable", PdpAB.b() ? 1 : 0);
        r211.put("preload_scene", r210.f167222b.f167206p);
        r211.put("preload_hit_cache", r210.f167222b.f167207q ? 1 : 0);
        if (r212 == null) goto L155;
        String r169 = r212.getV3EventsAdditions();
        if (r169 == null) goto L141;
        JSONObject r170 = z1.g(r169);
        if (r170 == null) goto L141;
        String r171 = r170.optString("perf_log_extra");
        if (r171 == null) goto L141;
        JSONObject r172 = z1.g(r171);
        if (r172 == null) goto L141;
        Iterator<String> r173 = r172.keys();
    L139:
        if (r173.hasNext() == false) goto L141;
        String r174 = r173.next();
        r211.put(r174, r172.optString(r174));
    L141:
        String r175 = r212.getV3EventsAdditions();
        if (r175 == null) goto L152;
        JSONObject r176 = z1.g(r175);
        if (r176 == null) goto L152;
        String r177 = r176.optString("search_params");
        if (r177 == null) goto L152;
        JSONObject r178 = z1.g(r177);
        if (r178 == null) goto L152;
        String r179 = r178.optString("is_ad");
        if (r179 == null) goto L152;
        r211.put("is_ad", r179);
    L152:
        String r180 = r212.getSourceBtmToken();
        if (r180 == null) goto L155;
        r211.put(PhotoEnterModel.SOURCE_BTM_TOKEN, r180);
    L155:
        k r181 = r210.f167223c;
        r181.getClass();
        int r182 = ECMonitorService.f45110b;
        ?? r183 = new JSONObject();
        String r184 = k.b(r181.f167279a.f167268b);
        String r185 = k.b(r181.f167279a.f167269c);
        String r186 = k.b(r181.f167279a.f167272f);
        i r187 = r181.f167280b;
        if ((!Intrinsics.areEqual(r187.f167247f, r187.f167246e)) == false) goto L158;
        r183.put("wireframe_is_show", 1);
        int r188 = h.f167241a;
        r183.put("wireframe_has_pic", r181.f167279a.f167267a ? 1 : 0);
        r183.put("wireframe_pic_scale", r184);
    L160:
        if (r181.f167281c.f167199i == false) goto L162;
        r183.put("preload_is_show", 1);
        r183.put("preload_header_cell_scale", r185);
        r183.put("preload_header_cell_type", r181.f167279a.f167270d);
        int r189 = h.f167241a;
        r183.put("preload_has_girdle", r181.f167279a.f167271e ? 1 : 0);
    L163:
        r183.put("main_header_cell_scale", r186);
        r183.put("main_header_cell_type", r181.f167279a.f167273g);
        int r190 = h.f167241a;
        r183.put("main_has_girdle", r181.f167279a.f167274h ? 1 : 0);
        Boolean r191 = r181.f167279a.f167275i;
        if (r191 == null) goto L166;
        r183.put("main_has_blank_on_first_chunk", r191.booleanValue() ? 1 : 0);
    L166:
        Integer r192 = r181.f167279a.f167276j;
        if (r192 == null) goto L169;
        r183.put("main_blank_height_on_first_chunk", r192.intValue());
    L169:
        r183.put("wireframe_preload_scale_same", Intrinsics.areEqual(r184, r185) ? 1 : 0);
        r183.put("wireframe_main_scale_same", Intrinsics.areEqual(r184, r186) ? 1 : 0);
        r183.put("preload_main_scale_same", Intrinsics.areEqual(r185, r186) ? 1 : 0);
        if (r181.f167281c.f167199i == false) goto L192;
        j r193 = r181.f167279a;
        if (r193.f167271e == false) goto L192;
        if (r193.f167274h == false) goto L192;
        String r194 = k.a(r193.f167277k);
        String r195 = k.a(r181.f167279a.f167278l);
        if (r194 == null) goto L192;
        if (r195 == null) goto L192;
        Uri r196 = UriProtector.parse(r194);     // Catch: Throwable -> L188
        if (r196 == null) goto L181;
        String r197 = r196.getPath();     // Catch: Throwable -> L188
    L182:
        Uri r198 = UriProtector.parse(r195);     // Catch: Throwable -> L188
        if (r198 == null) goto L185;
        String r199 = r198.getPath();     // Catch: Throwable -> L188
    L186:
        ?? r1100 = Intrinsics.areEqual(r197, r199);     // Catch: Throwable -> L188
    L189:
        int r200 = h.f167241a;
        r183.put("girdle_is_same", r1100);
        if (r1100 != 0) goto L192;
        r183.put("preload_girdle_url", r194);
        r183.put("main_girdle_url", r195);
        goto L192
    L185:
        r199 = null;
        goto L186
    L181:
        r197 = null;
    L188:
        r1100 = 0;
    L192:
        i r201 = r181.f167280b;
        int r202 = 1;
        if ((!Intrinsics.areEqual(r201.f167247f, r201.f167246e)) == false) goto L207;
        r183.put("wireframe_duration", i.a(Long.valueOf(r181.f167280b.f167244c), r181.f167280b.f167247f));
        if (r181.f167281c.f167199i == false) goto L197;
        i r203 = r181.f167280b;
        Long r204 = i.a(r203.f167247f, r203.f167260s);
    L198:
        r183.put("wireframe_visible_duration", r204);
        i r205 = r181.f167280b;
        long r1101 = r181.e(r205.f167247f, r205.f167261t);
        r183.put("wireframe_pic_load_duration", r1101);
        if (r1101 < 0) goto L204;
        if (r204 == null) goto L204;
        if (r1101 > r204.longValue()) goto L204;
        int r206 = 1;
    L205:
        r183.put("wireframe_pic_is_loaded", r206);
    L204:
        r206 = 0;
        goto L205
    L197:
        i r207 = r181.f167280b;
        r204 = i.a(r207.f167247f, r207.f167251j);
    L207:
        if (r181.f167281c.f167199i == false) goto L216;
        r183.put("preload_duration", i.a(Long.valueOf(r181.f167280b.f167244c), r181.f167280b.f167260s));
        i r208 = r181.f167280b;
        Long r209 = i.a(r208.f167260s, r208.f167251j);
        r183.put("preload_visible_duration", r209);
        i r213 = r181.f167280b;
        long r214 = r181.e(r213.f167260s, r213.f167262u);
        r183.put("preload_header_pic_load_duration", r214);
        if (r214 < 0) goto L214;
        if (r209 == null) goto L214;
        if (r214 > r209.longValue()) goto L214;
    L215:
        r183.put("preload_header_pic_is_loaded", r202);
    L214:
        r202 = 0;
    L216:
        r183.put("first_frame_duration", i.a(Long.valueOf(r181.f167280b.f167244c), r181.f167280b.f167251j));
        i r215 = r181.f167280b;
        r183.put("main_header_pic_load_duration", r181.e(r215.f167251j, r215.f167263v));
        r183.put("pdp_type", r181.f167281c.f167195e);
        r183.put(com.bytedance.android.ec.core.event.a.KEY_CARRIER_SOURCE, r181.f167281c.f167196f);
        r183.put(com.bytedance.android.ec.core.event.a.KEY_SOURCE_METHOD, r181.f167281c.f167197g);
        r183.put("ecom_entrance_from", r181.f167281c.f167198h);
        r183.put("last_ecom_scene_id", r181.f167281c.f167194d);
        r183.put("pdp_cache", r181.f167281c.f167191a ? 1 : 0);
        r183.put("chunk_enable", r181.f167281c.f167192b ? 1 : 0);
        ECMonitorService.a.a("ec_pdp_ux_monitor", r183, null, null);
        return;
    L162:
        r183.put("preload_is_show", 0);
        goto L163
    L158:
        r183.put("wireframe_is_show", 0);
        goto L160
    }

    public static final void b(c r100, CommonMeta r101, JSONObject r102) {
        r100.getClass();
        if (r101 == null) goto L12;
        ECAdLogExtra r103 = r101.getAdLogExtra();
        if (r103 == null) goto L13;
        String r104 = r103.getCreativeId();
        if (r104 == null) goto L14;
        int r105 = ECSdk.f48106a;
        s83.g r106 = (s83.g) ECSdk.a(s83.g.class);
        if (r106 == null) goto L15;
        r106.C(r104, r102);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    public static void g(c r100, Long r101, boolean r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 2) == 0) goto L8;
        r102 = false;
    L8:
        i r104 = r100.f167221a;
        if (r101 == null) goto L11;
        long r105 = r101.longValue();
    L12:
        r104.f167259r = Long.valueOf(r105);
        if (r102 == false) goto L16;
        r100.f167222b.f167199i = true;
        return;
    L16:
        return;
    L11:
        r105 = System.currentTimeMillis();
        goto L12
    }

    public final void k(String r100, boolean r101, boolean r102, boolean r103, String r104, String r105, String r106) {
        com.bytedance.android.shopping.anchorv4.perf.monitor.a r107 = this.f167222b;
        int r108 = h.f167241a;
        if (r101 == false) goto L5;
        String r109 = "full";
    L10:
        r107.f167195e = r109;
        r107.f167194d = r100;
        r107.f167196f = r105;
        r107.f167197g = r104;
        r107.f167198h = r106;
        String r110 = String.valueOf(f167219j);
        r107.getClass();
        Intrinsics.checkNotNullParameter(r110, "<set-?>");
        r107.f167193c = r110;
        return;
    L5:
        if (r102 == false) goto L7;
        r109 = "video";
        goto L10
    L7:
        if (r103 == false) goto L9;
        r109 = "live";
        goto L10
    L9:
        r109 = "other";
        goto L10
    }
}
