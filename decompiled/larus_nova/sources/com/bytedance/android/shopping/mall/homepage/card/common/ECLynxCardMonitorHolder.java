package com.bytedance.android.shopping.mall.homepage.card.common;

import android.graphics.Point;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.airbnb.lottie.LottieAnimationView;
import com.android.ttcjpaysdk.base.CJPayConstant;
import com.bytedance.android.ec.hybrid.ECHybridSettings;
import com.bytedance.android.ec.hybrid.card.api.ECLynxCardErrorType;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxLoadType;
import com.bytedance.android.ec.hybrid.list.ECHybridListAdapter;
import com.bytedance.android.ec.hybrid.list.ECHybridListEngine;
import com.bytedance.android.ec.hybrid.list.entity.ECHybridListItemVO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECNAMallCardExtra;
import com.bytedance.android.ec.hybrid.list.entity.f;
import com.bytedance.android.ec.hybrid.list.entity.k;
import com.bytedance.android.ec.hybrid.list.entity.n;
import com.bytedance.android.ec.hybrid.list.holder.ECLynxCardHolder;
import com.bytedance.android.ec.hybrid.list.view.ECHybridListContainer;
import com.bytedance.android.ec.hybrid.list.view.ECHybridRecyclerView;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.monitor.ECHybridCardMonitor;
import com.bytedance.android.ec.hybrid.tools.UIToolsKt;
import com.bytedance.android.ec.hybrid.ui.ApertureView;
import com.bytedance.android.ec.hybrid.ui.CusShadowView;
import com.bytedance.android.ec.hybrid.ui.HoleOverlayView;
import com.bytedance.android.ec.vlayout.VirtualLayoutManager;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.ECRoundedFrameLayout;
import com.bytedance.android.shopping.api.mall.common.homepage.card.common.ToolsKt;
import com.bytedance.android.shopping.api.mall.common.tools.b0;
import com.bytedance.android.shopping.api.mall.common.tools.l;
import com.bytedance.android.shopping.mall.feed.ECMallFeed;
import com.bytedance.android.shopping.mall.homepage.tools.BstUtilsNewKt;
import com.bytedance.common.utility.Logger;
import com.bytedance.forest.utils.h;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.bytedance.services.apm.api.EnsureManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.ttvideoengine.log.IVideoEventLogger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\tJ\u001e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/common/ECLynxCardMonitorHolder;", "Lcom/bytedance/android/ec/hybrid/list/holder/ECLynxCardHolder;", "Lff3/b;", "", "isCompletelyVisible", "Lkotlin/Function0;", "", "cb", NotificationCompat.CATEGORY_CALL, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECLynxCardMonitorHolder extends ECLynxCardHolder implements ff3.b {

    /* JADX INFO: renamed from: g2, reason: collision with root package name */
    public static final int f177444g2 = 0;

    /* JADX INFO: renamed from: h2, reason: collision with root package name */
    public static final int f177445h2 = 0;

    /* JADX INFO: renamed from: p2, reason: collision with root package name */
    public static final int f177446p2 = 0;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public static final Lazy f177447v2 = null;
    public com.bytedance.android.ec.hybrid.monitor.b G1;
    public float H0;
    public final ViewGroup H1;
    public ViewGroup L0;
    public final String L1;
    public final Long M1;
    public HoleOverlayView P0;
    public final Integer P1;
    public final Integer Q1;
    public final MutableLiveData<Float> S1;
    public final Function2<View, ECHybridListItemVO, Unit> T1;
    public ApertureView V0;
    public final ECMallFeed.f V1;
    public boolean W;
    public y93.d X;
    public final Lazy Y;
    public String Z;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public CusShadowView f177448b1;

    /* JADX INFO: renamed from: b2, reason: collision with root package name */
    public final /* synthetic */ ff3.a f177449b2;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public boolean f177450g1;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public boolean f177451h1;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f177452k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public d f177453k1;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public long f177454p0;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public final com.bytedance.android.shopping.mall.homepage.card.common.c f177455p1;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public final Lazy f177456v1;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public final Lazy f177457x1;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public final Lazy f177458y1;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f177459a;

        public b(Function0 r100) {
            this.f177459a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f177459a.invoke();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECLynxCardMonitorHolder f177460a;

        public c(ECLynxCardMonitorHolder r100) {
            this.f177460a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ECLynxCardMonitorHolder r100 = this.f177460a;     // Catch: Throwable -> L4
            int r101 = ECLynxCardMonitorHolder.f177444g2;     // Catch: Throwable -> L4
            r100.J4();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECLynxCardMonitorHolder f177461a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f177462b;

        public d(ECLynxCardMonitorHolder r100, String r101) {
            this.f177461a = r100;
            this.f177462b = r101;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            ECLynxCardMonitorHolder.H4(this.f177461a, this.f177462b);
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECLynxCardMonitorHolder f177463a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f177464b;

        public e(ECLynxCardMonitorHolder r100, String r101) {
            this.f177463a = r100;
            this.f177464b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ECLynxCardMonitorHolder.F4(this.f177463a, this.f177464b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public ECLynxCardMonitorHolder() {
        throw null;
    }

    @Override // ff3.b
    public final View Q1() {
        return this.f177449b2.Q1();
    }

    @Override // com.bytedance.android.ec.hybrid.list.holder.ECLynxCardHolder, com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder
    public final void X3() {
        this.f177450g1 = true;
        I4();
    }

    @Override // com.bytedance.android.ec.hybrid.list.holder.ECLynxCardHolder, com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder
    public final void a4() {
        this.f177450g1 = true;
        I4();
    }

    @Override // com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder
    public final void l4() {
        N4(null);
    }

    @Override // ff3.b
    public final void s3(LottieAnimationView r100, FrameLayout.LayoutParams r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "lp");
        this.f177449b2.s3(r100, r101);
    }

    static {
        f177444g2 = b0.c(2);
        f177445h2 = b0.c(5);
        f177446p2 = b0.c(25);
        f177447v2 = LazyKt.lazy(ECLynxCardMonitorHolder$Companion$lynxCardPerfReportEnable$2.INSTANCE);
    }

    public final void I4() {
        if (this.P0 != null) goto L10;
        if (this.V0 != null) goto L10;
        if (this.f177448b1 != null) goto L10;
        return;
    L10:
        if (((Boolean) this.f177458y1.getValue()).booleanValue() == false) goto L12;
        new Handler(Looper.getMainLooper()).post(new c(this));
        return;
    L12:
        J4();
    }

    public final void J4() {
        Lazy r100 = ECMallLogUtil.f47441a;     // Catch: Exception -> L13
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.b.d.f47458b, "clear all animation view");     // Catch: Exception -> L13
        HoleOverlayView r101 = this.P0;     // Catch: Exception -> L13
        if (r101 == null) goto L5;
        UIToolsKt.b(r101);     // Catch: Exception -> L13
    L5:
        ApertureView r102 = this.V0;     // Catch: Exception -> L13
        if (r102 == null) goto L8;
        UIToolsKt.b(r102);     // Catch: Exception -> L13
    L8:
        CusShadowView r103 = this.f177448b1;     // Catch: Exception -> L13
        if (r103 == null) goto L11;
        UIToolsKt.b(r103);     // Catch: Exception -> L13
    L11:
        this.P0 = null;     // Catch: Exception -> L13
        this.V0 = null;     // Catch: Exception -> L13
        this.f177448b1 = null;     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e);
    }

    public final void M4() {
        y93.d r100 = this.X;
        if (r100.f566970a == false) goto L5;
        return;
    L5:
        this.X = y93.d.a(r100, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, true, 4194303);
        JSONObject r101 = new JSONObject();
        r101.put("type", "LYNX_RENDER_LOG");
        r101.put(ChameleonOpenTracker.ParamKey.RES_VERSION, this.M1);
        int r102 = f93.a.f475963a;
        f93.a.c(r101, (String) this.Y.getValue());
        r101.put(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);
        ECHybridListItemVO r103 = this.f47152c;
        if (r103 == null) goto L12;
        n r104 = r103.f47041o;
        if (r104 == null) goto L12;
        HashMap<String, Object> r105 = r104.f47140b;
        if (r105 == null) goto L12;
        Object r106 = r105.get("request_id");
    L13:
        r101.put("log_id", r106);
        r101.put(CJPayConstant.CJ_PAY_RETAIN_INFO_V2_SCHEMA_KEY, this.X.f());
        r101.put("error_msg", this.X.b());
        r101.put("perf_dict", this.X.e());
        r101.put(IVideoEventLogger.FEATURE_KEY_PREPARE_DECODE_ONLY, this.X.d());
        String r107 = this.Q.get("na_page_name");
        String r108 = "";
        if (r107 != null) goto L16;
        r107 = "";
    L16:
        r101.putOpt("page_name", r107);
        String r109 = this.Q.get("enter_from");
        if (r109 == null) goto L20;
        r108 = r109;
    L20:
        r101.putOpt("enter_from", r108);
        JSONObject r110 = tv5.a.b(y93.d.a(this.X, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, false, 8387054));
        Map<String, Object> r111 = this.X.g();
        if (r111 == null) goto L28;
        Iterator<T> r112 = r111.keySet().iterator();
    L24:
        if (r112.hasNext() == false) goto L28;
        String r113 = (String) r112.next();
        Object r114 = r111.get(r113);
        if (r114 == null) goto L24;
        r110.putOpt(r113, r114);
    L28:
        ECHybridListItemVO r115 = this.f47152c;
        if (r115 == null) goto L33;
        Integer r116 = r115.f47028c;
        if (r116 == null) goto L33;
        int r117 = r116.intValue();
    L34:
        r110.putOpt(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE, Integer.valueOf(r117));
        r101.put("detail", r110);
        l.b(l.f170445a, r101, this.P1, false, 12);
        return;
    L33:
        r117 = -2;
    L12:
        r106 = null;
        goto L13
    }

    @Override // com.bytedance.android.ec.hybrid.list.holder.ECLynxCardHolder
    public final Integer u4() {
        return this.X.c();
    }

    @Override // com.bytedance.android.ec.hybrid.list.holder.ECLynxCardHolder, com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder, com.bytedance.android.ec.hybrid.list.holder.IHybridListViewHolder
    public final void o() {
        super.o();
        View r100 = this.itemView;
        Set<String> r101 = BstUtilsNewKt.f178398a;
        Intrinsics.checkNotNullParameter(this, "$this$cleanMarkBstCardShowMonitor");
        if (r100 != null) goto L5;
        r100 = this.itemView;
    L5:
        r100.setTag(R.id.shopping_mall_bst_mark_new, null);
    }

    @Override // com.bytedance.android.ec.hybrid.list.holder.ECLynxCardHolder, com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder, com.bytedance.android.ec.hybrid.list.holder.IHybridListViewHolder
    public final void onHide() {
        super.onHide();
        I4();
    }

    @Override // com.bytedance.android.ec.hybrid.list.holder.ECLynxCardHolder, com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onLoadSuccess() {
        super.onLoadSuccess();
        if (this.f177452k0 == false) goto L6;
        this.W = true;
        this.f177452k0 = false;
        com.bytedance.android.ec.hybrid.list.holder.e r100 = new com.bytedance.android.ec.hybrid.list.holder.e(this.Z, false, System.currentTimeMillis() - this.f177454p0);
        Intrinsics.checkNotNullParameter(r100, "status");
        Intrinsics.checkNotNullParameter(r100, "status");
        this.f47163n = r100;
        return;
    }

    @Override // com.bytedance.android.ec.hybrid.list.holder.ECLynxCardHolder, com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder, com.bytedance.android.ec.hybrid.list.holder.IHybridListViewHolder
    public final void onRelease() {
        super.onRelease();
        if (((Boolean) this.f177456v1.getValue()).booleanValue() == false) goto L7;
        MutableLiveData<Float> r100 = this.S1;
        if (r100 == null) goto L7;
        r100.removeObserver(this.f177455p1);
    L7:
        I4();
        d r101 = this.f177453k1;
        if (r101 == null) goto L17;
        ECHybridListAdapter r102 = this.f47156g;
        if (r102 == null) goto L18;
        ECHybridListEngine r103 = r102.f46860u;
        if (r103 == null) goto L19;
        ECHybridRecyclerView r104 = r103.f46871b;
        if (r104 == null) goto L20;
        r104.removeOnLayoutChangeListener(r101);
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    }

    public final ViewGroup K4(String r100) {
        if (this.L0 != null) goto L21;
        if (Intrinsics.areEqual(r100, "5") == false) goto L19;
        ViewGroup r101 = this.H1;
        ViewGroup r102 = null;
        if (r101 == null) goto L9;
        ViewParent r103 = r101.getParent();
    L10:
        int r104 = 0;
    L11:
        if (r103 == null) goto L18;
        if (r104 >= 10) goto L18;
        if ((r103 instanceof ECHybridListContainer) == true) goto L16;
        r103 = r103.getParent();
        r104 = r104 + 1;
        goto L11
    L16:
        r102 = (ViewGroup) r103;
    L18:
        this.L0 = r102;
        goto L21
    L9:
        r103 = null;
        goto L10
    L19:
        this.L0 = this.V1.ex();
    L21:
        return this.L0;
    }

    public final void N4(Integer r100) {
        ViewGroup r101 = null;
        C4(null);
        ECHybridListItemVO r102 = this.f47152c;
        if (r102 == null) goto L7;
        com.bytedance.android.ec.hybrid.list.entity.e r103 = r102.L;
        if (r103 == null) goto L7;
        Integer r104 = r103.f47099c;
    L8:
        if (r102 == null) goto L12;
        com.bytedance.android.ec.hybrid.list.entity.e r105 = r102.L;
        if (r105 == null) goto L12;
        List<Float> r106 = r105.f47098b;
    L13:
        if (r104 == null) goto L50;
        if (r106 == null) goto L50;
        if (r106.size() != 4) goto L50;
        if (r100 == null) goto L19;
        int r107 = r100.intValue();
    L21:
        if (r104.intValue() != (-1)) goto L23;
    L27:
        ViewGroup r108 = this.H1;
        if ((r108 instanceof ECRoundedFrameLayout) == false) goto L31;
        r101 = r108;
    L31:
        ECRoundedFrameLayout r109 = (ECRoundedFrameLayout) r101;
        if (r109 == null) goto L64;
        Float r110 = (Float) CollectionsKt.getOrNull(r106, 0);
        float r111 = 0.0f;
        if (r110 == null) goto L36;
        float r112 = b0.c(r110) * this.H0;
    L37:
        Float r113 = (Float) CollectionsKt.getOrNull(r106, 1);
        if (r113 == null) goto L40;
        float r114 = b0.c(r113) * this.H0;
    L41:
        Float r115 = (Float) CollectionsKt.getOrNull(r106, 2);
        if (r115 == null) goto L44;
        float r116 = b0.c(r115) * this.H0;
    L45:
        Float r117 = (Float) CollectionsKt.getOrNull(r106, 3);
        if (r117 == null) goto L48;
        r111 = this.H0 * b0.c(r117);
    L48:
        r109.a(r112, r114, r116, r111);
        return;
    L44:
        r116 = 0.0f;
        goto L45
    L40:
        r114 = 0.0f;
        goto L41
    L36:
        r112 = 0.0f;
        goto L37
    L64:
        return;
    L23:
        if (r104.intValue() <= 0) goto L50;
        if (r107 < 0) goto L50;
        if (r107 >= r104.intValue()) goto L50;
    L19:
        r107 = ToolsKt.g(this);
    L50:
        ECHybridListItemVO r118 = this.f47152c;
        if (r118 == null) goto L65;
        com.bytedance.android.ec.hybrid.list.entity.e r119 = r118.L;
        if (r119 == null) goto L66;
        Double r120 = r119.f47097a;
        if (r120 == null) goto L67;
        double r121 = r120.doubleValue();
        ViewGroup r122 = this.H1;
        if ((r122 instanceof ECRoundedFrameLayout) == false) goto L60;
        r101 = r122;
    L60:
        ECRoundedFrameLayout r123 = (ECRoundedFrameLayout) r101;
        if (r123 == null) goto L68;
        r123.setRadius(b0.c(Double.valueOf(r121)) * this.H0);
        return;
    L68:
        return;
    L67:
        return;
    L66:
        return;
    L65:
        return;
    L12:
        r106 = null;
    L7:
        r104 = null;
        goto L8
    }

    @Override // com.bytedance.android.ec.hybrid.list.holder.ECLynxCardHolder, com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onCreateKitViewEnd(long r210) {
        this.X = y93.d.a(this.X, null, null, null, null, null, null, null, null, null, null, null, Long.valueOf(r210), null, null, null, null, null, 0, false, 8384511);
    }

    @Override // com.bytedance.android.ec.hybrid.list.holder.ECLynxCardHolder, com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onReceivedError(com.bytedance.lynx.service.model.b r100) {
        StringBuilder r101 = new StringBuilder("schema: ");
        k.a r102 = this.f47154e;
        Integer r103 = null;
        if (r102 == null) goto L7;
        f r104 = r102.f47132a;
        if (r104 == null) goto L7;
        String r105 = r104.f47100a;
    L8:
        r101.append(r105);
        r101.append(" , itemType: ");
        ECHybridListItemVO r106 = this.f47152c;
        if (r106 == null) goto L11;
        r103 = r106.f47028c;
    L11:
        r101.append(r103);
        Logger.d("puffone-ECLynxCardMonitorHolder.onReceivedError()", r101.toString());
        return;
    L7:
        r105 = null;
        goto L8
    }

    @Override // com.bytedance.android.ec.hybrid.list.holder.ECLynxCardHolder, com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onTimingSetup(Map<String, ? extends Object> r210) {
        super.onTimingSetup(r210);
        Object r100 = null;
        if (r210 == null) goto L5;
        Object r101 = r210.get(LynxMonitorService.KEY_SETUP_TIMING);
    L7:
        if ((r101 instanceof Map) == true) goto L9;
        r101 = null;
    L9:
        Map r110 = (Map) r101;
        if (r110 != null) goto L12;
        return;
    L12:
        ECLynxCardHolder.BindType r102 = ECLynxCardHolder.BindType.UNKNOWN;
        Object r103 = r210.get("ec_session");
        if ((r103 instanceof xj.a) == true) goto L15;
        r103 = null;
    L15:
        xj.a r104 = (xj.a) r103;
        int r105 = 1;
        if (r104 == null) goto L30;
        r104.f564026c.getClass();
        Long r106 = Long.valueOf(r104.f564024a);
        int r107 = r104.f564030g;
        ECLynxLoadType r108 = r104.f564029f;
        if (r108 == null) goto L29;
        int r109 = com.bytedance.android.shopping.mall.homepage.card.common.b.f177508a[r108.ordinal()];
        if (r109 == 1) goto L28;
        if (r109 != 2) goto L24;
        r102 = ECLynxCardHolder.BindType.PRE_CREATE;
        goto L29
    L24:
        if (r109 != 3) goto L29;
        r102 = ECLynxCardHolder.BindType.PRE_LOAD;
        goto L29
    L28:
        r102 = ECLynxCardHolder.BindType.DEFAULT;
    L29:
        Long r111 = r106;
        int r112 = r107;
    L31:
        y93.d r113 = this.X;
        Object r114 = r110.get("draw_end");
        if ((r114 instanceof Long) == true) goto L34;
        r114 = null;
    L34:
        Long r115 = (Long) r114;
        Object r116 = r110.get("load_template_start");
        if ((r116 instanceof Long) == false) goto L38;
        r100 = r116;
    L38:
        Long r117 = (Long) r100;
        if (this.W == true) goto L42;
        r105 = 2;
    L42:
        this.X = y93.d.a(r113, null, null, 1, null, null, r117, r115, Integer.valueOf(r105), r210, r110, null, null, null, null, r111, null, Integer.valueOf(r102.ordinal()), r112, false, 4356379);
        M4();
        return;
    L30:
        r111 = null;
        r112 = -1;
        goto L31
    L5:
        r101 = null;
        goto L7
    }

    public static final void E4(ECLynxCardMonitorHolder r100, View r101) {
        r100.getClass();
        if (r101 == null) goto L14;
        ViewPropertyAnimator r102 = r101.animate();
        if (r102 == null) goto L15;
        ViewPropertyAnimator r103 = r102.alpha(0.0f);
        if (r103 == null) goto L16;
        ViewPropertyAnimator r104 = r103.setDuration(300);
        if (r104 == null) goto L17;
        ViewPropertyAnimator r105 = r104.setListener(new com.bytedance.android.shopping.mall.homepage.card.common.d(r100));
        if (r105 == null) goto L18;
        r105.start();
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    }

    public static final void F4(final ECLynxCardMonitorHolder r100, final String r101) {
        if (r100.f177450g1 == false) goto L5;
        Lazy r102 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.b.d.f47458b, "current page has leave, do not start animation");
        return;
    L5:
        final ViewGroup r103 = r100.K4(r101);
        if (r103 == null) goto L97;
        ECHybridListAdapter r104 = r100.f47156g;
        if (r104 == null) goto L93;
        ECHybridListEngine r105 = r104.f46860u;
        if (r105 == null) goto L94;
        ECHybridRecyclerView r106 = r105.f46871b;
        if (r106 == null) goto L95;
        VirtualLayoutManager r107 = r106.getLayoutManager();
        if (r107 == null) goto L98;
        Iterator<T> r108 = b0.b(r103).iterator();
    L19:
        if (r108.hasNext() == false) goto L23;
        Object r109 = r108.next();
        if ((((View) r109) instanceof HoleOverlayView) == false) goto L19;
    L25:
        if ((r109 instanceof HoleOverlayView) == true) goto L27;
        r109 = null;
    L27:
        HoleOverlayView r110 = (HoleOverlayView) r109;
        Iterator<T> r111 = b0.b(r103).iterator();
    L29:
        if (r111.hasNext() == false) goto L33;
        Object r112 = r111.next();
        if ((((View) r112) instanceof ApertureView) == false) goto L29;
    L35:
        if ((r112 instanceof ApertureView) == true) goto L37;
        r112 = null;
    L37:
        ApertureView r113 = (ApertureView) r112;
        Iterator<T> r114 = b0.b(r103).iterator();
    L39:
        if (r114.hasNext() == false) goto L43;
        Object r115 = r114.next();
        if ((((View) r115) instanceof CusShadowView) == false) goto L39;
    L45:
        if ((r115 instanceof CusShadowView) == true) goto L47;
        r115 = null;
    L47:
        CusShadowView r116 = (CusShadowView) r115;
        if (r110 != null) goto L75;
        if (r113 != null) goto L75;
        if (r116 != null) goto L75;
        Lazy r117 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.b.d.f47458b, "start animation, cardAnimationType = " + r101);
        int r118 = r107.findFirstCompletelyVisibleItemPosition();
        int r119 = r107.findLastCompletelyVisibleItemPosition();
        if (r100.getAdapterPosition() < 0) goto L59;
        int r120 = r100.getAdapterPosition();
        if (r118 > r120) goto L59;
        if (r119 < r120) goto L59;
        boolean r121 = true;
    L60:
        if (r121 == true) goto L70;
        ECHybridListAdapter r122 = r100.f47156g;
        if (r122 == null) goto L68;
        ECHybridListEngine r123 = r122.f46860u;
        if (r123 == null) goto L68;
        ECHybridRecyclerView r124 = r123.f46871b;
        if (r124 == null) goto L68;
        r124.scrollToPosition(0);
    L68:
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.a.g.f47453b, "item covered, scroll to top");
    L70:
        if (Intrinsics.areEqual(r101, "1") == false) goto L72;
    L73:
        r103.postDelayed(new com.bytedance.android.shopping.mall.homepage.card.common.e(r100), 3500);
        HoleOverlayView r125 = new HoleOverlayView(r100.H1.getContext(), null);
        r100.P0 = r125;
        r103.addView(r125);
    L74:
        r100.call(r121, new ECLynxCardMonitorHolder$startAnimation$2(r100, r103, r101));
        return;
    L72:
        if (Intrinsics.areEqual(r101, "2") == false) goto L74;
    L59:
        r121 = false;
    L75:
        if (r110 == null) goto L77;
        UIToolsKt.b(r110);
    L77:
        if (r113 == null) goto L79;
        UIToolsKt.b(r113);
    L79:
        if (r116 == null) goto L81;
        UIToolsKt.b(r116);
    L81:
        Lazy r126 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.b.d.f47458b, "animation view has exit");
        return;
    L43:
        r115 = null;
        goto L45
    L33:
        r112 = null;
        goto L35
    L23:
        r109 = null;
        goto L25
    L98:
        return;
    L95:
        return;
    L94:
        return;
    L93:
        return;
    }

    public static final void H4(ECLynxCardMonitorHolder r310, String r311) {
        if (r310.P0 == null) goto L5;
    L9:
        ViewGroup r100 = r310.K4(r311);
        Point r101 = L4(r310.H1, r100);
        if (r100 == null) goto L22;
        if (r101 == null) goto L22;
        HoleOverlayView r102 = r310.P0;
        if (r102 == null) goto L16;
        r102.a(r101.x, r101.y + 2, r310.H1.getWidth(), r310.H1.getHeight());
    L16:
        ApertureView r103 = r310.V0;
        if (r103 == null) goto L19;
        int r104 = r101.x;
        int r105 = f177444g2;
        ToolsKt.A(r103, 0.0f, null, null, null, Integer.valueOf(r104 - r105), Integer.valueOf((r101.y - r105) + 2), null, null, false, null, 975);
    L19:
        CusShadowView r106 = r310.f177448b1;
        if (r106 == null) goto L24;
        ToolsKt.A(r106, 0.0f, null, null, null, Integer.valueOf(r101.x - f177445h2), Integer.valueOf((r101.y - f177446p2) + 2), null, null, false, null, 975);
        return;
    L24:
        return;
    L22:
        r310.I4();
        return;
    L5:
        if (r310.V0 != null) goto L9;
        if (r310.f177448b1 != null) goto L9;
    }

    public static Point L4(View r100, View r101) {
        if (r100 == null) goto L7;
        if (r101 == null) goto L9;
        int[] r102 = new int[2];
        int[] r103 = new int[2];
        r101.getLocationOnScreen(r102);
        r100.getLocationOnScreen(r103);
        return new Point(r103[0] - r102[0], r103[1] - r102[1]);
    L9:
        return null;
    L7:
        return null;
    }

    private final void call(boolean r100, Function0<Unit> r101) {
        if (r100 == false) goto L4;
        r101.invoke();
        return;
    L4:
        this.H1.post(new b(r101));
    }

    @Override // com.bytedance.android.ec.hybrid.list.holder.ECLynxCardHolder, com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onTransDataTime(long r210, long r211) {
        this.X = y93.d.a(this.X, null, null, null, null, null, null, null, null, null, null, null, null, Long.valueOf(r210), Long.valueOf(r211), null, null, null, 0, false, 8364031);
    }

    @Override // com.bytedance.android.ec.hybrid.list.holder.ECLynxCardHolder, com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder
    public final void b4(Object r310, String r311, k.a r312) {
        Intrinsics.checkNotNullParameter(r311, "itemId");
        long r100 = System.currentTimeMillis();
        this.X = y93.d.a(this.X, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Long.valueOf(r100), null, 0, false, 8257535);
        String r101 = null;
        if (r312 == null) goto L7;
        f r102 = r312.f47132a;
        if (r102 == null) goto L7;
        String r103 = r102.f47100a;
    L8:
        this.Z = r103;
        if (ECHybridSettings.a() == false) goto L11;
        this.f47172u = new ECLynxCardMonitorHolder$onBind$1(this);
    L11:
        ECHybridListItemVO r104 = this.f47152c;
        boolean r105 = false;
        if (r104 != null) goto L14;
    L16:
        boolean r110 = false;
    L17:
        if (r104 != null) goto L19;
    L21:
        boolean r111 = false;
    L22:
        int r106 = h.f244547a;
        if (r312 == null) goto L27;
        f r107 = r312.f47132a;
        if (r107 == null) goto L27;
        String r108 = r107.f47100a;
    L29:
        if (h.a(r108) == false) goto L32;
        Intrinsics.checkNotNull(r312);
        f r109 = r312.f47132a;
        Intrinsics.checkNotNull(r109);
        f r112 = r312.f47132a;
        Intrinsics.checkNotNull(r112);
        String r113 = r112.f47100a;
        Intrinsics.checkNotNull(r113);
        r109.f47100a = ToolsKt.n(r113, this.Q1);
    L32:
        if (ECHybridSettings.a() == true) goto L35;
        if (r312 == null) goto L35;
        r312.f47134c = new ECLynxCardMonitorHolder$onBind$$inlined$apply$lambda$1(this);
    L35:
        Unit r114 = Unit.INSTANCE;
        super.b4(r310, r311, r312);
        if (r110 == true) goto L38;
    L40:
        Function2<View, ECHybridListItemVO, Unit> r115 = this.T1;
        if (r115 == null) goto L43;
        Unit r116 = r115.invoke(this.itemView, this.f47152c);
    L43:
        View r117 = this.itemView;
        Set<String> r118 = BstUtilsNewKt.f178398a;
        Intrinsics.checkNotNullParameter(this, "$this$markBstCardShowMonitor");
        View r119 = this.itemView;
        Intrinsics.checkNotNullParameter(this, "$this$cleanMarkBstCardShowMonitor");
        if (r119 != null) goto L46;
        r119 = this.itemView;
    L46:
        r119.setTag(R.id.shopping_mall_bst_mark_new, null);
        String r120 = BstUtilsNewKt.d(this);
        if (r120 != null) goto L49;
    L50:
        r105 = true;
    L51:
        if (r105 == true) goto L56;
        if (r117 != null) goto L55;
        r117 = this.itemView;
    L55:
        r117.setTag(R.id.shopping_mall_bst_mark_new, "bst_mark");
    L56:
        y93.d r121 = this.X;
        if (r312 == null) goto L61;
        f r122 = r312.f47132a;
        if (r122 == null) goto L61;
        String r123 = r122.f47100a;
    L62:
        ECHybridListItemVO r124 = this.f47152c;
        if (r124 == null) goto L65;
        Integer r125 = r124.f47028c;
    L66:
        this.X = y93.d.a(r121, r123, r125, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Integer.valueOf(this.H.ordinal()), this.f47160k, false, 5242876);
        StringBuilder r126 = new StringBuilder("schema: ");
        if (r312 == null) goto L71;
        f r127 = r312.f47132a;
        if (r127 == null) goto L71;
        String r128 = r127.f47100a;
    L72:
        r126.append(r128);
        r126.append(" , itemType: ");
        ECHybridListItemVO r129 = this.f47152c;
        if (r129 == null) goto L75;
        Integer r130 = r129.f47028c;
    L76:
        r126.append(r130);
        Logger.d("puffone-ECLynxCardMonitorHolder.onBind()", r126.toString());
        int r131 = ToolsKt.g(this);
        N4(Integer.valueOf(r131));
        ECHybridListItemVO r132 = this.f47152c;
        if (r132 == null) goto L81;
        ECNAMallCardExtra r133 = r132.c();
        if (r133 == null) goto L81;
        String r134 = r133.getCardAnimationType();
    L83:
        if (h.a(r134) == true) goto L85;
    L106:
        long r135 = System.currentTimeMillis();
        com.bytedance.android.ec.hybrid.monitor.b r136 = this.G1;
        String r137 = this.N;
        String r138 = "";
        if (r137 != null) goto L109;
        r137 = "";
    L109:
        ECHybridListItemVO r139 = this.f47152c;
        if (r139 == null) goto L115;
        Integer r140 = r139.f47028c;
        if (r140 == null) goto L115;
        String r141 = String.valueOf(r140.intValue());
        if (r141 == null) goto L115;
    L116:
        if (r312 == null) goto L120;
        f r142 = r312.f47132a;
        if (r142 == null) goto L120;
        r101 = r142.f47100a;
    L120:
        if (r101 == null) goto L123;
        r138 = r101;
    L123:
        r136.getClass();
        Intrinsics.checkNotNullParameter(r137, "pageName");
        Intrinsics.checkNotNullParameter(r141, "cardName");
        Intrinsics.checkNotNullParameter(r138, "cardUrl");
        com.bytedance.android.ec.hybrid.monitor.b r143 = new com.bytedance.android.ec.hybrid.monitor.b(r137, r141, r138, r131, r100, r135, r135 - r100, r110, r111);
        this.G1 = r143;
        ECHybridCardMonitor.a(r143);
        return;
    L115:
        r141 = "";
        goto L116
    L85:
        if (CollectionsKt.contains(SetsKt.setOf(new String[]{"1", "2", "5"}), r134) == false) goto L106;
        ECHybridListItemVO r144 = this.f47152c;
        if (r144 == null) goto L106;
        if (r144.f47049w == true) goto L106;
        Lazy r145 = ECMallLogUtil.f47441a;
        ECMallLogUtil.c(com.bytedance.android.ec.hybrid.log.mall.b.d.f47458b, "enter to handle animation process");
        ECHybridListItemVO r146 = this.f47152c;
        if (r146 == null) goto L95;
        ECNAMallCardExtra r147 = r146.c();
        if (r147 == null) goto L95;
        r147.setCardAnimationType(null);
    L95:
        d r148 = new d(this, r134);
        this.f177453k1 = r148;
        ECHybridListAdapter r149 = this.f47156g;
        if (r149 == null) goto L125;
        ECHybridListEngine r150 = r149.f46860u;
        if (r150 == null) goto L125;
        ECHybridRecyclerView r151 = r150.f46871b;
        if (r151 == null) goto L125;
        r151.addOnLayoutChangeListener(r148);
    L125:
        this.H1.post(new e(this, r134));     // Catch: Exception -> L104
    L104:
        e = move-exception;
        I4();
        EnsureManager.ensureNotReachHere(e);
    L81:
        r134 = null;
        goto L83
    L75:
        r130 = null;
    L71:
        r128 = null;
        goto L72
    L65:
        r125 = null;
    L61:
        r123 = null;
        goto L62
    L49:
        if (r120.length() != 0) goto L51;
    L38:
        if (((Boolean) f177447v2.getValue()).booleanValue() == false) goto L40;
        int r152 = ze3.a.f571532a;
        Intrinsics.checkNotNullParameter(new ECLynxCardMonitorHolder$onBind$3(this), "entryMapCallback");
    L27:
        r108 = null;
        goto L29
    L19:
        if (r104.f47049w != true) goto L21;
        r111 = true;
        goto L22
    L14:
        if (r104.K != true) goto L16;
        r110 = true;
    L7:
        r103 = null;
        goto L8
    }

    @Override // com.bytedance.android.ec.hybrid.list.holder.ECLynxCardHolder, com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder
    public final void d4(boolean r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "source");
        Intrinsics.checkNotNullParameter(r102, "pageSource");
        super.d4(r100, r101, r102);
        if (r100 == true) goto L8;
        this.f177450g1 = true;
        if (this.f177451h1 == true) goto L9;
        I4();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder, com.bytedance.android.ec.hybrid.list.holder.IHybridListViewHolder
    public final void g1(int r100, int r101, double r102) {
        HoleOverlayView r103 = this.P0;
        if (r103 == null) goto L5;
        r103.f47684b.offset(-r100, -r101);
        r103.invalidate();
    L5:
        ApertureView r104 = this.V0;
        ViewGroup.LayoutParams r105 = null;
        if (r104 == null) goto L13;
        ViewGroup.LayoutParams r106 = r104.getLayoutParams();
        if ((r106 instanceof ViewGroup.MarginLayoutParams) == true) goto L10;
        r106 = null;
    L10:
        ViewGroup.MarginLayoutParams r107 = (ViewGroup.MarginLayoutParams) r106;
        if (r107 == null) goto L13;
        r107.leftMargin -= r100;
        r107.topMargin -= r101;
        r104.requestLayout();
    L13:
        CusShadowView r108 = this.f177448b1;
        if (r108 == null) goto L23;
        ViewGroup.LayoutParams r109 = r108.getLayoutParams();
        if ((r109 instanceof ViewGroup.MarginLayoutParams) == false) goto L19;
        r105 = r109;
    L19:
        ViewGroup.MarginLayoutParams r110 = (ViewGroup.MarginLayoutParams) r105;
        if (r110 == null) goto L24;
        r110.leftMargin -= r100;
        r110.topMargin -= r101;
        r108.requestLayout();
        return;
    L24:
        return;
    }

    @Override // com.bytedance.android.ec.hybrid.list.holder.ECLynxCardHolder, com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder
    public final void g4(String r100, Integer r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "scheme");
        this.Z = r100;
        this.f177452k0 = true;
        this.f177454p0 = System.currentTimeMillis();
        super.g4(ToolsKt.n(r100, this.Q1), r101, r102);
    }

    @Override // com.bytedance.android.ec.hybrid.list.holder.ECLynxCardHolder, com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
    public final void onLoadFailed(ECLynxCardErrorType r210, Integer r211, String r212) {
        Intrinsics.checkNotNullParameter(r210, "type");
        super.onLoadFailed(r210, r211, r212);
        y93.d r100 = this.X;
        if (this.W == false) goto L5;
        int r101 = 1;
    L6:
        this.X = y93.d.a(r100, null, null, 0, r211, r212, null, null, Integer.valueOf(r101), null, null, null, null, null, null, null, null, null, 0, false, 8388451);
        M4();
        return;
    L5:
        r101 = 2;
        goto L6
    }

    public ECLynxCardMonitorHolder(ECMallFeed.h r110, String r111, Long r210, Integer r211, Integer r212, com.bytedance.android.ec.hybrid.list.entity.l.b r213, String r214, Lifecycle r215, ECLynxCardHolder.a r216, Map r217, String r218, ik.a r219, MutableLiveData r310, Function2 r311, LifecycleOwner r312, ECMallFeed.f r313, boolean r314) {
        Intrinsics.checkNotNullParameter(r110, "viewGroup");
        Intrinsics.checkNotNullParameter(r111, "sceneID");
        Intrinsics.checkNotNullParameter(r213, "pageType");
        Intrinsics.checkNotNullParameter(r217, "lynxConsumerMonitor");
        Intrinsics.checkNotNullParameter(r313, "containerAbility");
        super(r110, r111, r213, r214, r215, r216, r217, r218, r219, false, r314);
        this.f177449b2 = new ff3.a(r110);
        this.H1 = r110;
        this.L1 = r111;
        this.M1 = r210;
        this.P1 = r211;
        this.Q1 = r212;
        this.S1 = r310;
        this.T1 = r311;
        this.V1 = r313;
        this.X = new y93.d(null, "feed", 8388351);
        this.Y = LazyKt.lazy(new ECLynxCardMonitorHolder$defaultBTM$2(this));
        this.f177454p0 = -1;
        this.H0 = 1.0f;
        com.bytedance.android.shopping.mall.homepage.card.common.c r100 = new com.bytedance.android.shopping.mall.homepage.card.common.c(this);
        this.f177455p1 = r100;
        this.f177456v1 = LazyKt.lazy(ECLynxCardMonitorHolder$memoryLeakFix$2.INSTANCE);
        this.f177457x1 = LazyKt.lazy(ECLynxCardMonitorHolder$animationDurationConfig$2.INSTANCE);
        this.f177458y1 = LazyKt.lazy(ECLynxCardMonitorHolder$removeAnimationFix$2.INSTANCE);
        if (r312 == null) goto L6;
        if (r310 == null) goto L6;
        r310.observe(r312, r100);
    L6:
        this.G1 = new com.bytedance.android.ec.hybrid.monitor.b(0);
    }
}
