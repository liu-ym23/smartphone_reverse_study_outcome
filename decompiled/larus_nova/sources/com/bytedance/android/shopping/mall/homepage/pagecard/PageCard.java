package com.bytedance.android.shopping.mall.homepage.pagecard;

import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.ec.hybrid.bridge.LynxStatefulBridgeProxy;
import com.bytedance.android.ec.hybrid.card.api.ECLynxCardErrorType;
import com.bytedance.android.ec.hybrid.card.api.ECLynxLoadParam;
import com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle;
import com.bytedance.android.ec.hybrid.card.event.ECEventCenter;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.ec.hybrid.card.util.ECLynxBuildUtilKt;
import com.bytedance.android.ec.hybrid.list.util.q;
import com.bytedance.android.ec.hybrid.list.util.r;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.log.mall.k;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.shopping.api.mall.preload.gecko.ECMallGeckoResourceHelper;
import com.bytedance.android.shopping.mall.homepage.pagecard.bridge.LynxSubscribeEventListBridge;
import com.bytedance.android.shopping.mall.homepage.pagecard.dynamicparams.DynamicParamsController;
import com.bytedance.android.shopping.verse.api.IVerseService;
import com.bytedance.forest.utils.h;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes13.dex */
public final class PageCard {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f178262p = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ECLynxCard f178263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f178264b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f178265c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f178266d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f178267e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f178268f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ConcurrentHashMap<String, Map<String, Object>> f178269g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function0<Unit> f178270h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArrayList<com.bytedance.android.ec.hybrid.card.event.b> f178271i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ArrayList<Pair<String, Map<String, Object>>> f178272j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Disposable f178273k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<IECLynxCardLifeCycle> f178274l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final nf3.a f178275m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f178276n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile boolean f178277o;

    public static final class a {
    }

    public static final class b extends rj.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ PageCard f178278d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ boolean f178279e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Context f178280f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f178281g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ Lifecycle f178282h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f178283i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ Map f178284j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final /* synthetic */ String f178285k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final /* synthetic */ Map f178286l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final /* synthetic */ Map f178287m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ boolean f178288n;

        @Override // rj.a, com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
        public final void onFirstScreen() {
            super.onFirstScreen();
            if (this.f178278d.f178263a == null) goto L8;
            IVerseService r100 = ECLynxCard.f46500f;
            if (r100 == null) goto L9;
            r100.getMallDebugService();
            return;
        L9:
            return;
        }

        @Override // rj.a, com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
        public final void onLoadSuccess() {
            super.onLoadSuccess();
            this.f178278d.getClass();
            nf3.a r100 = this.f178278d.f178275m;
            r100.f518945a.setTLoadFinish(Long.valueOf(System.currentTimeMillis()));
            r100.f518945a.setStatus(1);
            Iterator r101 = ((ArrayList) this.f178278d.f178274l).iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            ((IECLynxCardLifeCycle) r101.next()).onLoadSuccess();
            goto L4
        L6:
            Lazy r102 = ECMallLogUtil.f47441a;
            ECMallLogUtil.c(k.b.f47502b, "pageCard onLoadSuccess");
        }

        @Override // rj.a, com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
        public final void onRuntimeReady() {
            super.onRuntimeReady();
            Lazy r100 = ECMallLogUtil.f47441a;
            ECMallLogUtil.c(k.b.f47502b, "pageCard onRuntimeReady");
            this.f178278d.getClass();
        }

        @Override // rj.a, com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
        public final void onReceivedError(com.bytedance.lynx.service.model.b r100) {
            super.onReceivedError(r100);
            Lazy r101 = ECMallLogUtil.f47441a;
            ECMallLogUtil.c(k.b.f47502b, "pageCard onReceivedError , type = " + r100);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rj.a, com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
        public final void onLoadFailed(ECLynxCardErrorType r110, Integer r111, String r210) {
            Intrinsics.checkNotNullParameter(r110, "type");
            super.onLoadFailed(r110, r111, r210);
            if (this.f178279e == true) goto L5;
            this.f178278d.b(this.f178280f, this.f178281g, this.f178282h, (String) this.f178283i.element, true, this.f178284j, this.f178285k, this.f178286l, this.f178287m, "", this.f178288n);
            Lazy r100 = ECMallLogUtil.f47441a;
            ECMallLogUtil.c(k.b.f47502b, "pageCard onLoadFailed , retry");
        L5:
            nf3.a r101 = this.f178278d.f178275m;
            r101.f518945a.setStatus(2);
            r101.f518945a.setErrorCode(r111);
            r101.f518945a.setErrorMsg(r210);
            r101.b();
            Iterator r102 = ((ArrayList) this.f178278d.f178274l).iterator();
        L7:
            if (r102.hasNext() == false) goto L9;
            ((IECLynxCardLifeCycle) r102.next()).onLoadFailed(r110, r111, r210);
            goto L7
        L9:
            Lazy r103 = ECMallLogUtil.f47441a;
            ECMallLogUtil.c(k.b.f47502b, "pageCard onLoadFailed , type = " + r110 + " , errorCode =" + r111 + " , errorMsg = " + r210);
        }

        public b(PageCard r100, boolean r101, Context r102, ViewGroup r103, Lifecycle r104, Ref.ObjectRef r105, Map r106, String r107, Map r108, Map r110, boolean r111, ECLynxCard r112) {
            this.f178278d = r100;
            this.f178279e = r101;
            this.f178280f = r102;
            this.f178281g = r103;
            this.f178282h = r104;
            this.f178283i = r105;
            this.f178284j = r106;
            this.f178285k = r107;
            this.f178286l = r108;
            this.f178287m = r110;
            this.f178288n = r111;
            super(r112, "page_card");
        }
    }

    static {
    }

    public final boolean a() {
        if (((Number) this.f178267e.getValue()).intValue() == 1) goto L5;
    L9:
        return false;
    L5:
        if (((com.bytedance.android.shopping.mall.homepage.pagecard.dynamicparams.a) this.f178268f.getValue()).f178317g == false) goto L9;
        if (this.f178265c == false) goto L9;
        return true;
    }

    public final boolean c() {
        DynamicParamsController r100 = (DynamicParamsController) this.f178266d.getValue();
        if (r100.f178312c.isEmpty() == true) goto L5;
    L9:
        return false;
    L5:
        if (r100.f178310a.isEmpty() == false) goto L9;
        if (r100.f178311b.isEmpty() == false) goto L9;
        return true;
    }

    public PageCard() {
        this.f178266d = LazyKt.lazy(PageCard$dynamicParamsController$2.INSTANCE);
        this.f178267e = LazyKt.lazy(PageCard$useWhiteBoardDynamicParams$2.INSTANCE);
        this.f178268f = LazyKt.lazy(PageCard$whiteBoardDynamicParamsController$2.INSTANCE);
        this.f178269g = new ConcurrentHashMap();
        this.f178271i = new ArrayList();
        this.f178272j = new ArrayList();
        this.f178274l = new ArrayList();
        this.f178275m = new nf3.a();
    }

    public final void d(final String r110, final Map<String, ? extends Object> r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r110, "eventName");
        Lazy r100 = ECMallLogUtil.f47441a;
        ECMallLogUtil.d(k.b.f47502b, new PageCard$sendGlobalEvent$1(r110, r111));
        long r101 = System.currentTimeMillis();
        String r102 = this.f178264b;
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        com.bytedance.android.ec.hybrid.card.event.b r103 = new com.bytedance.android.ec.hybrid.card.event.b(r110, r101, r102, false, r111, false, 32);
        if (this.f178276n == true) goto L9;
        if (r112 == false) goto L9;
        this.f178271i.add(r103);
        return;
    L9:
        ECEventCenter.c(r103);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void e(PageCard r100, String r101, Map r102, int r103) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        r100.d(r101, r102, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [T, java.lang.String] */
    public final void b(Context r210, ViewGroup r211, Lifecycle r212, String r213, boolean r214, Map<String, ? extends Object> r215, String r216, Map<String, String> r217, Map<String, ? extends Object> r310, String r311, boolean r312) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r211, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r212, NewBroadcastMonitor.STAGE.LIFECYCLE);
        Intrinsics.checkNotNullParameter(r215, "globalProps");
        Intrinsics.checkNotNullParameter(r216, "bid");
        Intrinsics.checkNotNullParameter(r217, "consumerMonitor");
        Intrinsics.checkNotNullParameter(r311, "initData");
        Ref.ObjectRef r100 = new Ref.ObjectRef();
        int r101 = d.f178307c;
        r100.element = d.a.a();
        if (h.a(r213) == false) goto L6;
        r100.element = r213;
        nf3.a r102 = this.f178275m;
        r102.getClass();
        Intrinsics.checkNotNullParameter("settings", "type");
        r102.f518945a.setSchemaType("settings");
    L8:
        Lazy r103 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(k.b.f47502b, "pageCard load,schema = " + ((String) r100.element));
        nf3.a r104 = this.f178275m;
        boolean r105 = r214 ^ true;
        r104.f518945a.setTLoadStart(Long.valueOf(System.currentTimeMillis()));
        boolean r110 = true;
        if (r105 == false) goto L11;
        r104.f518945a.setFirstLoad(1);
    L12:
        Lazy r106 = ECMallGeckoResourceHelper.f170594a;
        String r107 = (String) r100.element;
        Intrinsics.checkNotNull(r107);
        ECLynxLoadParam.a r111 = new ECLynxLoadParam.a(r210, r212, r211, ECMallGeckoResourceHelper.a(r107));
        Object r108 = r215.get("page_name");
        Object r112 = null;
        if ((r108 instanceof String) == true) goto L15;
        r108 = null;
    L15:
        r111.g((String) r108);
        ViewGroup.LayoutParams r109 = new ViewGroup.LayoutParams(-1, -1);
        Intrinsics.checkNotNullParameter(r109, "ecLayoutParams");
        r111.f46356u = r109;
        Pair[] r113 = new Pair[5];
        r113[0] = TuplesKt.to("ec.mallDynamicParamsChanged", new LynxStatefulBridgeProxy(new PageCard$makeJsBridgeMap$1(this), "ec.mallDynamicParamsChanged"));
        r113[1] = TuplesKt.to("ec.mallFlushDynamicParam", new LynxStatefulBridgeProxy(new PageCard$makeJsBridgeMap$2(this), "ec.mallFlushDynamicParam"));
        r113[2] = TuplesKt.to("ec.mallSyncDynamicParams", new LynxStatefulBridgeProxy(new PageCard$makeJsBridgeMap$3(this), "ec.mallSyncDynamicParams"));
        com.bytedance.android.shopping.mall.homepage.pagecard.b r114 = new com.bytedance.android.shopping.mall.homepage.pagecard.b(this);
        String r115 = this.f178264b;
        if (r115 != null) goto L18;
        r115 = "";
    L18:
        r113[3] = TuplesKt.to("ec.subscribeEventList", new LynxSubscribeEventListBridge(r114, r115, String.valueOf(hashCode()), new PageCard$makeJsBridgeMap$5(this)));
        String r116 = this.f178264b;
        if (r116 != null) goto L21;
        r116 = "";
    L21:
        r113[4] = TuplesKt.to("ec.unsubscribeEventList", new com.bytedance.android.shopping.mall.homepage.pagecard.bridge.a(r116, String.valueOf(hashCode())));
        r111.d(MapsKt.mutableMapOf(r113));
        r111.f46355t = r216;
        Intrinsics.checkNotNullParameter(r217, "map");
        r111.f46354s = r217;
        String r117 = this.f178264b;
        if (r117 != null) goto L24;
        r117 = "";
    L24:
        Intrinsics.checkNotNullParameter(r117, "sceneID");
        r111.f46361z = r117;
        Object r118 = r215.get("page_name");
        if ((r118 instanceof String) == false) goto L28;
        r112 = r118;
    L28:
        String r119 = (String) r112;
        String r120 = this.f178264b;
        if (r120 != null) goto L31;
        r120 = "";
    L31:
        ECLynxBuildUtilKt.a(r111, new uj.a(r119, r120));
        Intrinsics.checkNotNullParameter(r215, "ecGlobalProps");
        r111.f46351p = r215;
        r111.H = r312;
        Map<String, q> r121 = r.f47356a;
        String r122 = this.f178264b;
        if (r122 != null) goto L34;
        r122 = "no scene";
    L34:
        r111.i(r.a(r122, 0, 6));
        b r123 = new b(this, r214, r210, r211, r212, r100, r215, r216, r217, r310, r312, this.f178263a);
        Intrinsics.checkNotNullParameter(r123, NewBroadcastMonitor.STAGE.LIFECYCLE);
        r111.f46350o = r123;
        if (r311.length() > 0) goto L38;
        r110 = false;
    L38:
        if (r110 == false) goto L41;
        r111.f46345j = r311;
    L41:
        if (r310 == null) goto L43;
        r111.f46352q = r310;
    L43:
        ECLynxCard r124 = this.f178263a;
        if (r124 == null) goto L46;
        r124.j(new ECLynxLoadParam(r111));
    L46:
        this.f178275m.f518945a.setTNativeLoadFinish(Long.valueOf(System.currentTimeMillis()));
        return;
    L11:
        r104.f518945a.setFirstLoad(2);
        goto L12
    L6:
        if (h.a((String) r100.element) == false) goto L49;
        nf3.a r125 = this.f178275m;
        r125.getClass();
        Intrinsics.checkNotNullParameter("default", "type");
        r125.f518945a.setSchemaType("default");
        goto L8
    }
}
