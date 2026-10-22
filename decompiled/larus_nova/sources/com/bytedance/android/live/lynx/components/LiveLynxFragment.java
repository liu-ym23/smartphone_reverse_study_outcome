package com.bytedance.android.live.lynx.components;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.browser.LynxThreadStrategy;
import com.bytedance.android.live.browser.d0;
import com.bytedance.android.live.browser.jsbridge.upload.q;
import com.bytedance.android.live.browser.w;
import com.bytedance.android.live.browser.webview.fragment.AbsHybridFragment;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.core.monitor.LiveTraceSchemaMonitor;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.schema.vo.BaseHybridParamVo;
import com.bytedance.android.live.schema.vo.LynxHybridParamVo;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.android.livesdkapi.base.ILiveBrowserActivity;
import com.bytedance.android.livesdkapi.base.ILiveWebCommonApi;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.lynx.tasm.LynxView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/lynx/components/LiveLynxFragment;", "Lcom/bytedance/android/live/browser/webview/fragment/AbsHybridFragment;", "Lcom/bytedance/android/live/browser/jsbridge/f;", "Ly6/d;", "", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveLynxFragment extends AbsHybridFragment implements y6.d {
    public static final /* synthetic */ int N = 0;
    public LynxThreadStrategy A;
    public y6.e B;
    public q C;
    public vl0.b D;
    public View E;
    public FrameLayout F;
    public RelativeLayout G;
    public int H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f82587J;
    public long K;
    public d0 L;
    public final Lazy<LiveLynxFragment$mGlobalLayoutListener$1.a> M;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public com.bytedance.android.live.lynx.api.c f82588x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public LynxHybridParamVo f82589y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f82590z;

    public static final class a {
    }

    public static final class b extends d0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveLynxFragment f82591a;

        @Override // com.bytedance.android.live.browser.d0
        public final void a() {
            LiveLynxFragment r100 = this.f82591a;
            int r101 = LiveLynxFragment.N;
            r100.W90();
            View r102 = this.f82591a.E;
            if (r102 == null) goto L6;
            r102.setVisibility(8);
            return;
        }

        public b(LiveLynxFragment r100) {
            this.f82591a = r100;
        }

        @Override // com.bytedance.android.live.browser.d0
        public final void b(LynxView r100) {
            Intrinsics.checkNotNullParameter(r100, "lynxView");
            d0 r101 = this.f82591a.L;
            if (r101 == null) goto L5;
            r101.b(r100);
        L5:
            BaseHybridParamVo r102 = this.f82591a.f64325j;
            if (r102 != null) goto L8;
            return;
        L8:
            if (r102.h() != true) goto L20;
            final LiveLynxFragment r103 = this.f82591a;
            r103.getClass();
            final View r104 = r103.V90(r100, LiveLynxFragment$handleNestedScrollWithVp$vp$1.INSTANCE);
            boolean r105 = r104 instanceof ViewPager;
            if (r105 == false) goto L21;
            final ArrayList r106 = new ArrayList();
            if (r105 == true) goto L14;
            View r107 = null;
        L15:
            ViewPager r108 = (ViewPager) r107;
            if (r108 == null) goto L22;
            r108.addOnPageChangeListener(new LiveLynxFragment$handleNestedScrollWithVp$1(r103, r106, r104));
            return;
        L22:
            return;
        L14:
            r107 = r104;
            goto L15
        L21:
            return;
        }

        @Override // com.bytedance.android.live.browser.d0
        public final void d(View r100) {
            Intrinsics.checkNotNullParameter(r100, "lynxView");
            BaseMonitor.MonitorEventModule r101 = BaseMonitor.MonitorEventModule.HYBRID;
            LiveTraceSchemaMonitor.Status r102 = LiveTraceSchemaMonitor.Status.SUCCESS;
            LiveLynxFragment r103 = this.f82591a;
            int r104 = LiveLynxFragment.N;
            String r105 = r103.f64323h;
            JSONObject r106 = new JSONObject();
            r106.put("hybrid_type", LiveTraceSchemaMonitor.HybridType.LYNX);
            Unit r107 = Unit.INSTANCE;
            LiveTraceSchemaMonitor.l(r101, r102, "Lynx页面加载成功", r105, "LiveLynxFragment", r106);
            d0 r108 = this.f82591a.L;
            if (r108 == null) goto L5;
            r108.d(r100);
        L5:
            View r109 = this.f82591a.E;
            int r110 = 8;
            if (r109 == null) goto L8;
            r109.setVisibility(8);
        L8:
            LiveLynxFragment r111 = this.f82591a;
            if (r111.f64325j.f100525g == false) goto L11;
        L17:
            UIUtils.setViewVisibility(r111.f64328m, 8);
        L18:
            LiveLynxFragment r112 = this.f82591a;
            if (r112.f64327l != null) goto L21;
        L23:
            int r113 = p20.d.f527361a;
            if (v.a() == false) goto L28;
            String r114 = p20.e.f527362a;
            v.a();
            return;
        L28:
            return;
        L21:
            if (r112.f64325j.d() == true) goto L23;
            r112.f64327l.setVisibility(0);
            goto L23
        L11:
            if ((r111.getActivity() instanceof ILiveBrowserActivity) == false) goto L17;
            View r115 = r111.f64328m;
            if (r111.f64325j.j() == false) goto L16;
            r110 = 0;
        L16:
            UIUtils.setViewVisibility(r115, r110);
            goto L18
        }

        @Override // com.bytedance.android.live.browser.d0
        public final void g(View r100) {
            Intrinsics.checkNotNullParameter(r100, "lynxView");
            d0 r101 = this.f82591a.L;
            if (r101 == null) goto L5;
            r101.g(r100);
        L5:
            this.f82591a.X90(true);
        }

        @Override // com.bytedance.android.live.browser.d0
        public final void c(LynxView r110, String r210) {
            Intrinsics.checkNotNullParameter(r110, "lynxView");
            d0 r100 = this.f82591a.L;
            if (r100 == null) goto L5;
            r100.c(r110, r210);
        L5:
            View r101 = this.f82591a.E;
            if (r101 == null) goto L9;
            r101.setVisibility(8);
        L9:
            if (r210 != null) goto L11;
            String r102 = "";
        L12:
            y50.i.m("lynx", null, this.f82591a.f64323h, "LiveLynxFragment#onLoadFailed()", 1, r102, null, 66);
            String r111 = this.f82591a.f64323h;
            JSONObject r103 = new JSONObject();
            r103.put("hybrid_type", LiveTraceSchemaMonitor.HybridType.LYNX);
            Unit r104 = Unit.INSTANCE;
            LiveTraceSchemaMonitor.l(BaseMonitor.MonitorEventModule.HYBRID, LiveTraceSchemaMonitor.Status.HYBRID_LYNX_LOAD_FAIL, "Lynx页面加载失败：" + r210, r111, "LiveLynxFragment", r103);
            return;
        L11:
            r102 = r210;
            goto L12
        }

        @Override // com.bytedance.android.live.browser.d0
        public final void e(View r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "lynxView");
            d0 r102 = this.f82591a.L;
            if (r102 == null) goto L5;
            r102.e(r100, r101);
        L5:
            int r103 = p20.d.f527361a;
            if (v.a() == false) goto L10;
            String r104 = p20.e.f527362a;
            v.a();
            return;
        }

        @Override // com.bytedance.android.live.browser.d0
        public final void f(View r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "lynxView");
            d0 r102 = this.f82591a.L;
            if (r102 == null) goto L5;
            r102.f(r100, r101);
        L5:
            View r103 = this.f82591a.E;
            if (r103 == null) goto L8;
            r103.setVisibility(8);
        L8:
            int r104 = p20.d.f527361a;
            if (v.a() == false) goto L16;
            String r105 = p20.e.f527362a;
            if (v.a() == true) goto L15;
            return;
        L15:
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.browser.webview.fragment.AbsHybridFragment
    public final void U90() {
    }

    public final void W90() {
        boolean r100 = true;
        this.f82587J = true;
        y50.i.m("lynx", null, this.f64323h, "LiveLynxFragment#handleFallback()", 1, "Lynx fallback with no fallback_url!!", null, 66);
        BaseMonitor.MonitorEventModule r101 = BaseMonitor.MonitorEventModule.HYBRID;
        LiveTraceSchemaMonitor.Status r110 = LiveTraceSchemaMonitor.Status.HYBRID_LYNX_LOAD_FAIL;
        String r111 = this.f64323h;
        JSONObject r112 = new JSONObject();
        r112.put("hybrid_type", LiveTraceSchemaMonitor.HybridType.LYNX);
        Unit r102 = Unit.INSTANCE;
        LiveTraceSchemaMonitor.l(r101, r110, "Lynx页面加载失败:handleFallback", r111, "LiveLynxFragment", r112);
        if (this.L == null) goto L11;
        FragmentActivity r103 = getActivity();
        if (r103 == null) goto L7;
        r103.finish();
    L7:
        d0 r104 = this.L;
        if (r104 == null) goto L31;
        r104.a();
        return;
    L31:
        return;
    L11:
        Bundle r105 = getArguments();
        if (r105 == null) goto L28;
        String r106 = r105.getString(AppConstants.BUNDLE_FALLBACK_URL);
        if (r106 == null) goto L28;
        if (r106.length() > 0) goto L19;
        r100 = false;
    L19:
        if (r100 == true) goto L22;
        r106 = null;
    L22:
        if (r106 == null) goto L28;
        FragmentActivity r107 = getActivity();
        if (r107 == null) goto L26;
        r107.finish();
    L26:
        ((IRoomService) jc1.k.n(IRoomService.class)).actionHandler().handle(getActivity(), r106);
        return;
    L28:
        if (v.a() == false) goto L33;
        f2.c("Lynx fallback with no fallback_url!!", 0);
        return;
    }

    @Override // y6.d
    public final void fZ() {
    }

    @Override // com.bytedance.android.livesdkapi.base.ILiveWebCommonApi
    public final void setOnPageLoadListener(ILiveWebCommonApi.OnPageLoadListener r100) {
    }

    public LiveLynxFragment() {
        this.A = LynxThreadStrategy.ALL_ON_UI;
        this.M = LazyKt.lazy(new LiveLynxFragment$mGlobalLayoutListener$1(this));
    }

    @Override // com.bytedance.android.live.browser.webview.fragment.AbsHybridFragment, com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.live.lynx.api.c r100 = this.f82588x;
        if (r100 == null) goto L6;
        r100.release();
    L6:
        if (this.I == true) goto L14;
        if (this.f82587J == true) goto L14;
        HashMap r101 = new HashMap();
        r101.put("type", "lynx");
        String r102 = this.f82590z;
        if (r102 != null) goto L12;
        r102 = "";
    L12:
        r101.put("path", r102);
        LiveSlardarMonitor.monitorStatusAndDuration("ttlive_profile_dismiss_while_loading", 0, SystemClock.uptimeMillis() - this.K, r101);
    L14:
        if (this.M.isInitialized() == false) goto L21;
        View r103 = getView();
        if (r103 == null) goto L22;
        ViewTreeObserver r104 = r103.getViewTreeObserver();
        if (r104 == null) goto L23;
        r104.removeOnGlobalLayoutListener(this.M.getValue());
        return;
    L23:
        return;
    L22:
        return;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        X90(false);
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        X90(true);
    }

    @Override // y6.d
    public final y6.e w1() {
        return this.B;
    }

    @Override // y6.d
    public final void DY(y6.e r100) {
        this.B = r100;
    }

    @Override // com.bytedance.android.live.browser.webview.fragment.AbsHybridFragment
    public final void T90(Bundle r100) {
        int r101 = com.bytedance.android.live.schema.helper.a.f100513a;
        Integer r102 = null;
        if (r100 == null) goto L13;
        Object r103 = r100.get("hybrid_pop_vo");
        Object r104 = r100.get("hybrid_lynx_vo");
        if (r103 != null) goto L13;
        if (r104 != null) goto L13;
        com.bytedance.android.live.schema.api.utils.a.d("tag_hybrid_parse", "HybridParamHelper->checkLynxFullVo: lynxHybridParamVo or commonVo is null");
        LynxHybridParamVo r105 = com.bytedance.android.live.schema.helper.a.c(r100.getString("url"), null, r100, null, false);
        r100.putParcelable("hybrid_lynx_vo", r105);
        if (r105 == null) goto L11;
        Parcelable r106 = r105.f100536b;
    L12:
        r100.putParcelable("hybrid_pop_vo", r106);
        goto L13
    L11:
        r106 = null;
    L13:
        super.T90(r100);
        if (r100 == null) goto L16;
        LynxHybridParamVo r107 = (LynxHybridParamVo) r100.getParcelable("hybrid_lynx_vo");
    L17:
        this.f82589y = r107;
        StringBuilder r108 = new StringBuilder("LiveLynxFragment->initArgs: ");
        LynxHybridParamVo r109 = this.f82589y;
        if (r109 == null) goto L20;
        String r110 = r109.toString();
    L21:
        r108.append(r110);
        ALogger.i("tag_hybrid_parse", r108.toString());
        this.f82590z = UriProtector.parse(this.f64323h).getPath();
        if (r100 == null) goto L26;
        String r111 = r100.getString(AppConstants.BUNDLE_EXTRA_DATA);
        if (r111 == null) goto L26;
        new JSONObject(r111);
    L26:
        LynxHybridParamVo r112 = this.f82589y;
        if (r112 == null) goto L29;
        r102 = Integer.valueOf(r112.c());
    L29:
        if (r102 != null) goto L32;
    L34:
        if (r102 != null) goto L37;
    L39:
        if (r102 != null) goto L42;
    L44:
        if (r102 != null) goto L47;
        return;
    L47:
        if (r102.intValue() != 3) goto L53;
        this.A = LynxThreadStrategy.MULTI_THREADS;
        return;
    L53:
        return;
    L42:
        if (r102.intValue() != 2) goto L44;
        this.A = LynxThreadStrategy.PART_ON_LAYOUT;
        return;
    L37:
        if (r102.intValue() != 1) goto L39;
        this.A = LynxThreadStrategy.MOST_ON_TASM;
        return;
    L32:
        if (r102.intValue() != 0) goto L34;
        this.A = LynxThreadStrategy.ALL_ON_UI;
        return;
    L20:
        r110 = null;
        goto L21
    L16:
        r107 = null;
        goto L17
    }

    public final void X90(boolean r100) {
        JSONObject r101 = new JSONObject();
        r101.put("visible", r100);
        com.bytedance.android.live.lynx.api.c r102 = this.f82588x;
        if (r102 == null) goto L6;
        r102.sendJsEvent("H5_visibilityChange", r101);
        return;
    }

    @Override // com.bytedance.android.live.browser.webview.fragment.AbsHybridFragment, com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.K = SystemClock.uptimeMillis();
    }

    public final View V90(View r100, Function1<? super View, Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        Intrinsics.checkNotNullParameter(r101, "predicate");
        if (r101.invoke(r100).booleanValue() == false) goto L6;
        return r100;
    L6:
        if ((r100 instanceof ViewGroup) == true) goto L8;
        return null;
    L8:
        ViewGroup r102 = (ViewGroup) r100;
        int r103 = r102.getChildCount();
        int r104 = 0;
    L9:
        if (r104 >= r103) goto L14;
        View r105 = V90(r102.getChildAt(r104), r101);
        if (r105 != null) goto L12;
        r104 = r104 + 1;
        goto L9
    L12:
        return r105;
    L14:
        return null;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
    }

    @Override // com.bytedance.android.live.browser.webview.fragment.AbsHybridFragment, com.bytedance.android.live.browser.jsbridge.f
    public final <T> void sendJsEvent(String r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        com.bytedance.android.live.lynx.api.c r102 = this.f82588x;
        if (r102 == null) goto L6;
        r102.sendJsEvent(r100, r101);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int r100, int r101, Intent r102) {
        super.onActivityResult(r100, r101, r102);
        q r103 = this.C;
        if (r103 == null) goto L6;
        Intrinsics.checkNotNull(r103);
        r103.onActivityResult(r100, r101, r102);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r112) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        super.onCreateView(r110, r111, r112);
        View r113 = r110.inflate(R.layout.ttlive_lynx_fragment, r111, false);
        if (r113 == null) goto L71;
        RelativeLayout r114 = (RelativeLayout) r113;
        this.G = r114;
        this.F = (FrameLayout) r114.findViewById(R.id.lynx_container_view);
        RelativeLayout r115 = this.G;
        if (r115 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L7:
        ViewTreeObserver r116 = r115.getViewTreeObserver();
        if (r116 == null) goto L10;
        r116.addOnGlobalLayoutListener(this.M.getValue());
    L10:
        Integer r117 = null;
        if (this.f64325j.c() == true) goto L22;
        RelativeLayout r118 = this.G;
        if (r118 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L15:
        View r119 = ((ViewStub) r118.findViewById(R.id.view_stub_loading)).inflate();
        if (r119 == null) goto L18;
        View r120 = r119.findViewById(R.id.double_loading_view);
    L19:
        this.E = r120;
        if (r120 == null) goto L22;
        r120.setVisibility(0);
        goto L22
    L18:
        r120 = null;
    L22:
        vl0.b r121 = this.D;
        if (r121 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("serviceHolder");
    L25:
        w r100 = r121.f555612a;
        if (r100 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("lynxService");
    L28:
        String r101 = this.f64323h;
        LynxHybridParamVo r122 = this.f82589y;
        if (r122 == null) goto L31;
        r117 = Integer.valueOf(r122.f100535a);
    L31:
        com.bytedance.android.live.lynx.api.c r123 = r100.createAndLoad(this, r101, r117, this.A, this.f64324i, new b(this));
        if (r123 == null) goto L66;
        FrameLayout r124 = this.F;
        if (r124 == null) goto L36;
        LynxView r102 = r123.getLynxView();
        r102.setScrollBarStyle(0);
        r102.setBackgroundColor(this.f64322g);
        Unit r103 = Unit.INSTANCE;
        r124.addView(r102, new FrameLayout.LayoutParams(-1, -1));
    L36:
        FrameLayout r125 = this.F;
        if (r125 == null) goto L39;
        r123.registerMethod("clipScreen", new h(r125, this, r123));
    L39:
        r123.registerMethod("shareInfo", new i(this));
        r123.registerMethod("sharePanel", new j(this));
        r123.registerMethod("upload", new k(this));
        Unit r126 = Unit.INSTANCE;
        this.f82588x = r123;
        LynxHybridParamVo r127 = this.f82589y;
        if (r127 != null) goto L42;
    L47:
        FrameLayout r128 = this.F;
        if (v.a() == true) goto L51;
    L58:
        String r129 = this.f64323h;
        String r130 = p20.e.f527362a;
        if (v.a() == false) goto L62;
        p20.e.f527362a = r129;
    L62:
        RelativeLayout r131 = this.G;
        if (r131 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L65:
        return r131;
    L51:
        if (r128 == null) goto L53;
        TextView r104 = new TextView(getContext());
        r104.setText("Lynx");
        r104.setTextSize(1, 14.0f);
        r104.setTextColor(ColorProtector.parseColor(CustomHeaderConfig.COLOR_LIGHT));
        r104.setBackgroundColor(ColorProtector.parseColor("#88008800"));
        r104.setOnClickListener(new g(this));
        FrameLayout.LayoutParams r105 = new FrameLayout.LayoutParams(-2, -2);
        r105.gravity = 8388661;
        r128.addView(r104, r105);
    L53:
        if (r128 == null) goto L58;
        int r106 = p20.c.f527360a;
        Context r107 = getContext();
        String r108 = this.f64323h;
        String r109 = this.f64325j.f100533o;
        Intrinsics.checkNotNullParameter(r128, "viewGroup");
        Intrinsics.checkNotNullParameter(r108, "url");
        if (v.a() == false) goto L58;
        TextView r132 = new TextView(r107);
        r132.setText("Debug Tool-Live");
        r132.setBackgroundColor(ColorProtector.parseColor("#88008800"));
        r132.setTextColor(ColorProtector.parseColor(CustomHeaderConfig.COLOR_LIGHT));
        r132.setTextSize(1, 15.0f);
        FrameLayout.LayoutParams r133 = new FrameLayout.LayoutParams(-2, -2);
        r133.topMargin = 300;
        r133.gravity = 8388659;
        r128.addView(r132, r133);
        r132.setOnClickListener(new p20.a(r108, r109));
        r132.setOnLongClickListener(new p20.b(r128));
        goto L58
    L42:
        if (r127.d() != true) goto L47;
        RelativeLayout r134 = this.G;
        if (r134 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L46:
        GradientDrawable r135 = new GradientDrawable();
        float r136 = t6.a(getContext(), 8.0f);
        r135.setCornerRadii(new float[]{r136, r136, r136, r136, 0.0f, 0.0f, 0.0f, 0.0f});
        r135.setGradientType(0);
        Context r137 = getContext();
        Intrinsics.checkNotNull(r137);
        r135.setColor(r137.getResources().getColor(R.color.white));
        r134.setBackground(r135);
        goto L47
    L66:
        W90();
        RelativeLayout r138 = this.G;
        if (r138 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L69:
        return r138;
    L71:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout");
    }
}
