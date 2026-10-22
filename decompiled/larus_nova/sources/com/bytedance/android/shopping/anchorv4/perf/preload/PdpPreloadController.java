package com.bytedance.android.shopping.anchorv4.perf.preload;

import android.view.Choreographer;
import com.bytedance.android.ec.core.utils.UIUtils;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.android.shopping.anchorv4.dto.PackParsedDTO;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.dto.meta.PageMeta;
import com.bytedance.android.shopping.anchorv4.perf.PdpPerfOptManager;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.android.shopping.utils.z;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.batterymonitor.stragety.AbsBatteryStrategy;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes12.dex */
public final class PdpPreloadController implements com.bytedance.android.shopping.anchorv4.perf.preload.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f167282e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f167283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function1<? super PackParsedDTO, Unit> f167284b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PackParsedDTO f167285c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.android.shopping.anchorv4.perf.monitor.c f167286d;

    public static final class a {
        public static void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "message");
            z.c(r100, "preload", 4);
        }
    }

    public static final class b implements Choreographer.FrameCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PdpPreloadController f167287a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f167288b;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f167289a;

            public a(b r100) {
                this.f167289a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                b r100 = this.f167289a;     // Catch: Throwable -> L13
                PdpPreloadController r101 = r100.f167287a;     // Catch: Throwable -> L13
                final AnchorV4VM r102 = (AnchorV4VM) r100.f167288b;     // Catch: Throwable -> L13
                int r103 = PdpPreloadController.f167282e;     // Catch: Throwable -> L13
                r101.getClass();     // Catch: Throwable -> L13
                Function1<PackParsedDTO, Unit> r104 = new PdpPreloadController$tryUpdateState$1(r102);     // Catch: Throwable -> L13
                monitor-enter(r101);     // Catch: Throwable -> L13
                PackParsedDTO r105 = r101.f167285c;     // Catch: Throwable -> L10
                if (r105 == null) goto L7;
                r104.invoke(r105);     // Catch: Throwable -> L10
            L8:
                monitor-exit(r101);     // Catch: Throwable -> L13
                return;
            L7:
                r101.f167284b = r104;     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                throw th;     // Catch: Throwable -> L13
            L13:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L20;
                throw th;
            }
        }

        public b(PdpPreloadController r100, Object r101) {
            this.f167287a = r100;
            this.f167288b = r101;
        }

        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long r100) {
            Lazy r101 = UIUtils.f45548a;
            UIUtils.c().postAtFrontOfQueue(new a(this));
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PdpPreloadController f167290a;

        public c(PdpPreloadController r100) {
            this.f167290a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            PreloadDataDTO r101 = (PreloadDataDTO) r100;
            int r102 = PdpPreloadController.f167282e;
            StringBuilder r103 = new StringBuilder("preload result code=");
            r103.append(r101.getStatusCode());
            r103.append(" message=");
            r103.append(r101.getMessage());
            r103.append(" callback_not_null=");
            boolean r104 = false;
            if (this.f167290a.f167284b == null) goto L5;
            boolean r105 = true;
        L6:
            r103.append(r105);
            a.a(r103.toString());
            com.bytedance.android.shopping.anchorv4.perf.monitor.c r106 = this.f167290a.f167286d;
            if (r106 == null) goto L9;
            r106.f167221a.f167258q = Long.valueOf(System.currentTimeMillis());
        L9:
            com.bytedance.android.shopping.anchorv4.perf.monitor.c r107 = this.f167290a.f167286d;
            if (r107 == null) goto L12;
            Object r108 = r101.getTtNetExtraInfo();
            Integer r109 = Integer.valueOf(r101.getStatusCode());
            com.bytedance.android.shopping.anchorv4.perf.monitor.a r110 = r107.f167222b;
            r110.f167200j = r108;
            r110.f167205o = r109;
        L12:
            com.bytedance.android.shopping.anchorv4.perf.monitor.c r111 = this.f167290a.f167286d;
            if (r111 == null) goto L33;
            com.bytedance.android.shopping.anchorv4.perf.monitor.k r112 = r111.f167223c;
            if (r112 == null) goto L33;
            PackParsedDTO r113 = r101.getData();
            com.bytedance.android.shopping.anchorv4.perf.monitor.j r114 = r112.f167279a;
            AnchorV4HeadV2VO r115 = null;
            if (r113 == null) goto L19;
            AnchorV4HeadV2VO r116 = r113.getHeaderV2();
        L20:
            r114.f167269c = com.bytedance.android.shopping.anchorv4.perf.monitor.k.c(r116);
            com.bytedance.android.shopping.anchorv4.perf.monitor.j r117 = r112.f167279a;
            if (r113 == null) goto L23;
            r115 = r113.getHeaderV2();
        L23:
            r117.f167270d = com.bytedance.android.shopping.anchorv4.perf.monitor.k.d(r115);
            com.bytedance.android.shopping.anchorv4.perf.monitor.j r118 = r112.f167279a;
            if (r113 == null) goto L32;
            PageMeta r119 = r113.getPageMeta();
            if (r119 == null) goto L32;
            CommonMeta r120 = r119.getCommonMeta();
            if (r120 == null) goto L32;
            Boolean r121 = r120.getHasGirdle();
            if (r121 == null) goto L32;
            r104 = r121.booleanValue();
        L32:
            r118.f167271e = r104;
            r112.f167279a.f167277k = r113;
            goto L33
        L19:
            r116 = null;
        L33:
            PdpPreloadController r122 = this.f167290a;
            monitor-enter(r122);
            PdpPreloadController r123 = this.f167290a;     // Catch: Throwable -> L42
            if (r123.f167284b != null) goto L38;
            r123.f167285c = r101.getData();     // Catch: Throwable -> L42
        L39:
            int r124 = t73.a.f544881a;     // Catch: Throwable -> L42
            t73.a.a(r101.getData(), "preload_res");     // Catch: Throwable -> L42
            Unit r125 = Unit.INSTANCE;     // Catch: Throwable -> L42
            monitor-exit(r122);
            return;
        L38:
            Lazy r126 = UIUtils.f45548a;     // Catch: Throwable -> L42
            UIUtils.c().postAtFrontOfQueue(new h(this, r101));     // Catch: Throwable -> L42
        L42:
            th = move-exception;
            throw th;
        L5:
            r105 = false;
            goto L6
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PdpPreloadController f167291a;

        public d(PdpPreloadController r100) {
            this.f167291a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            com.bytedance.android.shopping.anchorv4.perf.monitor.c r102 = this.f167291a.f167286d;
            if (r102 == null) goto L5;
            com.bytedance.android.shopping.anchorv4.perf.monitor.i r103 = r102.f167221a;
            r103.f167258q = Long.valueOf(System.currentTimeMillis());
        L5:
            z.a("preload error", r101, null);
        }
    }

    public PdpPreloadController() {
    }

    static {
        int r100 = PdpPerfOptManager.f167178c;
        PdpPerfOptManager.a.a();
    }

    @Override // com.bytedance.android.shopping.anchorv4.perf.preload.b
    public final void b() {
        d("onPackLoaded");
    }

    @Override // com.bytedance.android.shopping.anchorv4.perf.preload.b
    public final void onDestroy() {
        d(LiveCommonConstants.REASON_ON_DEDTROY);
    }

    @Override // com.bytedance.android.shopping.anchorv4.perf.preload.b
    public final void c(final Object r100) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        if ((r100 instanceof com.bytedance.android.shopping.prepurchase.business.pdp.repository.o) == false) goto L16;
        Function1<PackParsedDTO, Unit> r101 = new PdpPreloadController$onCreate$1(r100);
        monitor-enter(this);
        PackParsedDTO r102 = this.f167285c;     // Catch: Throwable -> L12
        if (r102 == null) goto L9;
        r101.invoke(r102);     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        goto L16
    L9:
        this.f167284b = r101;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    L16:
        if ((r100 instanceof AnchorV4VM) == true) goto L18;
        return;
    L18:
        Choreographer.getInstance().postFrameCallback(new b(this, r100));
    }

    public final void d(String r100) {
        a.a("call cancel from=".concat(r100));
        Disposable r101 = this.f167283a;
        if (r101 == null) goto L5;
        r101.dispose();
    L5:
        this.f167283a = null;
    }

    public final void e(k r100) {
        int r101 = n.f167340a;
        String r102 = r100.f167334e;
        PackParsedDTO r103 = null;
        if (r102 == null) goto L7;
        List r104 = StringsKt.split$default(r102, new String[]{","}, false, 0, 6, null);
        if (r104 == null) goto L7;
        String r105 = (String) CollectionsKt.lastOrNull(r104);
    L8:
        if (r105 != null) goto L11;
        String r106 = null;
    L32:
        if (r106 == null) goto L39;
        com.bytedance.android.shopping.anchorv4.perf.monitor.c r107 = this.f167286d;
        if (r107 == null) goto L36;
        Intrinsics.checkNotNullParameter(r106, "scene");
        r107.f167222b.f167206p = r106;
    L36:
        PdpPreloadDataManager r108 = PdpPreloadDataManager.f167292c;
        if (r108 == null) goto L39;
        r103 = r108.c(r106, r100.f167330a, r100.f167331b);
    L39:
        if (r103 == null) goto L45;
        com.bytedance.android.shopping.anchorv4.perf.monitor.c r109 = this.f167286d;
        if (r109 == null) goto L43;
        r109.f167222b.f167207q = true;
    L43:
        this.f167285c = r103;
        t73.a.a(r103, "preload_cache");
        a.a("preload hit ahead cache promotion_id=" + r100.f167331b + " product_id=" + r100.f167330a);
        return;
    L45:
        PreloadApi.a r110 = PreloadApi.f167304a;
        LinkedHashMap r111 = new LinkedHashMap();
        r111.put("preload_config", g.f167319a);
        String r112 = r100.f167330a;
        String r113 = "";
        if (r112 != null) goto L48;
        r112 = "";
    L48:
        r111.put("product_id", r112);
        String r114 = r100.f167331b;
        if (r114 != null) goto L51;
        r114 = "";
    L51:
        r111.put("promotion_id", r114);
        String r115 = r100.f167332c;
        if (r115 != null) goto L54;
        r115 = "";
    L54:
        r111.put("product_pre_info", r115);
        String r116 = r100.f167333d;
        if (r116 != null) goto L57;
        r116 = "";
    L57:
        r111.put("header_config", r116);
        String r117 = r100.f167334e;
        if (r117 != null) goto L60;
        r117 = "";
    L60:
        r111.put("ecom_scene_id", r117);
        r111.put("full_mode", String.valueOf(r100.f167335f));
        r111.put("is_short_screen", String.valueOf(r100.f167336g));
        String r118 = r100.f167337h;
        if (r118 != null) goto L63;
        r118 = "";
    L63:
        r111.put(AppConstants.BUNDLE_ACTIVITY_AB_PARAMS_KEYS, r118);
        r111.put("ui_params", r100.f167338i.toString());
        String r119 = r100.f167339j;
        if (r119 == null) goto L67;
        r113 = r119;
    L67:
        r111.put("preload_extra", r113);
        r110.getClass();
        Intrinsics.checkNotNullParameter(r111, "params");
        this.f167283a = PreloadApi.a.f167305a.fetchPreloadData(r111).subscribeOn(Schedulers.io()).subscribe(new c(this), new d(this));
        return;
    L11:
        switch(r105.hashCode()) {
            case 1507424: goto L29;
            case 1507425: goto L26;
            case 1507517: goto L23;
            case 1507673: goto L20;
            case 1507677: goto L17;
            case 1507678: goto L14;
            default: goto L75;
        };
    L75:
        r106 = null;
        goto L32
    L14:
        if (r105.equals("1087") == true) goto L21;
        r106 = null;
    L21:
        r106 = "search";
        goto L32
    L17:
        if (r105.equals("1086") == true) goto L21;
        r106 = null;
        goto L32
    L20:
        if (r105.equals("1082") == true) goto L21;
        r106 = null;
        goto L32
    L23:
        if (r105.equals("1031") == false) goto L71;
        r106 = "mall";
        goto L32
    L71:
        r106 = null;
        goto L32
    L26:
        if (r105.equals(AbsBatteryStrategy.AppBgCombination.APP_BG__CHARGE_IN__NETWORK_WIFI__SCREEN_OFF_3M) == false) goto L72;
        r106 = "video";
        goto L32
    L72:
        r106 = null;
        goto L32
    L29:
        if (r105.equals(AbsBatteryStrategy.AppBgCombination.APP_BG__CHARGE_IN__NETWORK_WIFI__SCREEN_OFF) == false) goto L73;
        r106 = "live";
        goto L32
    L73:
        r106 = null;
    L7:
        r105 = null;
        goto L8
    }

    @Override // com.bytedance.android.shopping.anchorv4.perf.preload.b
    public final void a(com.bytedance.android.shopping.anchorv4.perf.monitor.c r100, k r101) {
        Intrinsics.checkNotNullParameter(r101, "params");
        a.a("call setup promotion_id=" + r101.f167331b + " product_id=" + r101.f167330a);     // Catch: Throwable -> L8
        this.f167286d = r100;     // Catch: Throwable -> L8
        if (r100 == null) goto L6;
        r100.f167221a.f167257p = Long.valueOf(System.currentTimeMillis());     // Catch: Throwable -> L8
    L6:
        e(r101);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        z.a("preload setup error", th, null);
    }
}
