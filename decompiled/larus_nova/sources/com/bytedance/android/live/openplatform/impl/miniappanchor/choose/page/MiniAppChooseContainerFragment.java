package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.live.broadcastgame.api.model.response.MiniAppEntrancePermissionResponse;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.openplatform.api.model.datacontext.AnchorMiniAppDataContext;
import com.bytedance.android.live.openplatform.impl.base.OpenPlatformAnchorServiceImpl;
import com.bytedance.android.live.openplatform.impl.base.perf.OpenPlatformPerformanceReportService;
import com.bytedance.android.live.openplatform.impl.base.perf.PerformanceScene;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.intro.MiniAppChooseIntroFragment;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list.MiniAppChooseListFragment;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.lynx.MiniAppChooseLynxFragment;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.search.MiniAppChooseSearchFragment;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.utils.MiniAppChooseTalentSettingUtil;
import com.bytedance.android.live.openplatform.impl.miniappanchor.choose.view.MiniAppChooseTitleBar;
import com.bytedance.android.livesdk.log.g;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.util.InfraKotlinExtsKt;
import com.bytedance.android.scope.l;
import com.bytedance.android.scope.m;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.android.material.tabs.TabLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import e33.k;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.UninitializedPropertyAccessException;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import zo0.h;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/MiniAppChooseContainerFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/b;", "", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MiniAppChooseContainerFragment extends BaseFragment implements com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.b {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f84119r = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<Integer, View> f84120d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public so0.a f84121e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.android.live.openplatform.impl.miniappanchor.choose.a f84122f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public lp0.c f84123g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.c> f84124h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TabLayout f84125i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ViewPager f84126j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public MiniAppChooseContainerTabPagerAdapter f84127k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f84128l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f84129m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f84130n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f84131o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f84132p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.openplatform.impl.base.utils.a f84133q;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MiniAppChooseContainerFragment f84134a;

        public b(MiniAppChooseContainerFragment r100) {
            this.f84134a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ep0.a r101 = (ep0.a) r100;
            com.bytedance.android.live.openplatform.impl.miniappanchor.choose.a r102 = this.f84134a.f84122f;
            if (r102 == null) goto L6;
            r102.close();
            return;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MiniAppChooseContainerFragment f84135a;

        public c(MiniAppChooseContainerFragment r100) {
            this.f84135a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            zo0.a.a(PerformanceScene.CHOOSE_PAGE).b((zo0.b.a) lp0.b.b(this.f84135a.T90(), OpenPlatformPerformanceReportService.class));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.b
    public final void Cx() {
        MiniAppChooseContainerTabPagerAdapter r100 = this.f84127k;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
    L5:
        MiniAppChooseSearchFragment r101 = (MiniAppChooseSearchFragment) this.f84129m.getValue();
        if (r101 == null) goto L8;
        ListProtector.remove(r100.f84136a, 0);
        ListProtector.add(r100.f84136a, 0, r101);
        r100.notifyDataSetChanged();
        return;
    L8:
        r100.getClass();
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.b
    public final void Eq() {
        MiniAppChooseContainerTabPagerAdapter r100 = this.f84127k;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
    L5:
        MiniAppChooseListFragment r101 = (MiniAppChooseListFragment) this.f84130n.getValue();
        if (r101 == null) goto L8;
        ListProtector.remove(r100.f84136a, 0);
        ListProtector.add(r100.f84136a, 0, r101);
        r100.notifyDataSetChanged();
        return;
    L8:
        r100.getClass();
    }

    public final lp0.a T90() {
        lp0.c r100 = this.f84123g;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("scope");
    L5:
        return r100;
    }

    public final void U90() {
        qo0.a.c("choose_container", "reportLandingPageShow");
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r100 = AnchorMiniAppDataContext.a.a();
        if (r100 == null) goto L7;
        n<MiniAppEntrancePermissionResponse> r101 = r100.getEntranceInfo();
        if (r101 == null) goto L7;
        MiniAppEntrancePermissionResponse r102 = r101.getValue();
    L9:
        if (r102 != null) goto L11;
    L16:
        String r103 = "normal_info";
    L18:
        if (MiniAppChooseTalentSettingUtil.b() == false) goto L20;
        String r104 = "bind_taskset";
    L21:
        lp0.c r105 = this.f84123g;
        if (r105 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("scope");
    L24:
        com.bytedance.android.live.openplatform.impl.miniappanchor.choose.c r106 = lp0.b.c(r105);
        if (r106 == null) goto L28;
        String r107 = r106.f84112a;
        if (r107 == null) goto L28;
    L29:
        lp0.c r108 = this.f84123g;
        if (r108 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("scope");
    L32:
        mp0.a r109 = lp0.b.a(r108);
        if (r109 == null) goto L40;
        Intrinsics.checkNotNullParameter(r103, "content");
        Intrinsics.checkNotNullParameter(r104, "tabModule");
        Intrinsics.checkNotNullParameter(r107, "clickSource");
        g r110 = u.l();
        Pair[] r111 = new Pair[6];
        r111[0] = TuplesKt.to(BdpAppEventConstant.PARAMS_FOR_SPECIAL, BdpAppEventConstant.MICRO_APP);
        r111[1] = TuplesKt.to("show_module", "bind");
        r111[2] = TuplesKt.to("show_content", r103);
        if (lp0.b.d(r109.f514696d) == false) goto L37;
        String r112 = "in_live";
    L38:
        r111[3] = TuplesKt.to("live_status", r112);
        r111[4] = TuplesKt.to("tab_module", r104);
        r111[5] = TuplesKt.to("click_source", r107);
        r110.e("mp_live_bind_landing_page_show", MapsKt.mutableMapOf(r111), new Object[]{Room.class});
        return;
    L37:
        r112 = "before_live";
        goto L38
    L40:
        return;
    L28:
        r107 = "";
        goto L29
    L20:
        r104 = "bind_only";
        goto L21
    L11:
        if (r102.getShowIntroPanel() != true) goto L16;
        if (r102.getPermit() == false) goto L15;
        r103 = "satisfied";
        goto L18
    L15:
        r103 = "not_satisfied";
    L7:
        r102 = null;
        goto L9
    }

    public MiniAppChooseContainerFragment() {
        this.f84133q = new com.bytedance.android.live.openplatform.impl.base.utils.a();
        this.f84120d = new LinkedHashMap();
        this.f84124h = new ArrayList();
        this.f84128l = InfraKotlinExtsKt.mainThreadLazy(new MiniAppChooseContainerFragment$chooseIntroFragment$2(this));
        this.f84129m = InfraKotlinExtsKt.mainThreadLazy(new MiniAppChooseContainerFragment$chooseSearchFragment$2(this));
        this.f84130n = InfraKotlinExtsKt.mainThreadLazy(new MiniAppChooseContainerFragment$chooseListFragment$2(this));
        this.f84131o = InfraKotlinExtsKt.mainThreadLazy(new MiniAppChooseContainerFragment$chooseLynxFragment$2(this));
        this.f84132p = -1;
        OpenPlatformAnchorServiceImpl.Companion.getClass();
        so0.a r100 = ((po0.a.b) OpenPlatformAnchorServiceImpl.access$getDiComponent$cp()).a().f530019a.f530021b.get();
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f84121e = r100;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        qo0.a.c("choose_container", "container fragment destroyed, leave scope");
        lp0.c r100 = this.f84123g;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("scope");
    L5:
        l.c(r100);
        this.f84133q.b();
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f84120d.clear();
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.b
    public final void Iz(com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ((ArrayList) this.f84124h).add(r100);
    }

    public final View S90(int r100) {
        if (this.f84120d != null) goto L5;
        this.f84120d = new LinkedHashMap();
    L5:
        View r101 = this.f84120d.get(Integer.valueOf(r100));
        if (r101 != null) goto L14;
        View r102 = getView();
        if (r102 == null) goto L12;
        View r103 = r102.findViewById(r100);
        if (r103 == null) goto L12;
        this.f84120d.put(Integer.valueOf(r100), r103);
        return r103;
    L12:
        return null;
    L14:
        return r101;
    }

    @Override // com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.b
    public final void j30(com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.c r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ((ArrayList) this.f84124h).remove(r100);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Context r100) {
        String r101 = PerfLog.PARAM_KEY_CONTEXT_ID;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.onAttach(r100);
        qo0.a.c("choose_container", "container fragment attached, create scope");
        so0.a r102 = this.f84121e;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("miniAppAnchorService");
    L5:
        com.bytedance.android.live.openplatform.impl.miniappanchor.choose.a r103 = this.f84122f;
        Intrinsics.checkNotNullParameter(r102, "anchorService");
        Intrinsics.checkNotNullParameter(r100, "ctx");
        Intrinsics.checkNotNullParameter(this, "chooseContainer");
        m.f163449e.getClass();
        lp0.c r104 = new lp0.c(m.f163448d);
        Intrinsics.checkNotNullParameter(r104, "scope");
        Intrinsics.checkNotNullParameter(r102, "value");
        r104.f510199e = r102;
        Intrinsics.checkNotNullParameter(r100, "value");
        r104.f510200f = r100;
        r104.f510201g = r103;
        Intrinsics.checkNotNullParameter(this, "value");
        r104.f510202h = this;
        Object r105 = k.f470908a;
        if (r104.f510199e != r105) goto L9;
        r101 = "miniAppAnchorService";
    L17:
        if (r101 != null) goto L21;
        this.f84123g = r104;
        return;
    L21:
        throw new UninitializedPropertyAccessException(r101);
    L9:
        if (r104.f510200f == r105) goto L17;
        if (r104.f510201g != r105) goto L14;
        r101 = RootDescription.ROOT_ELEMENT;
        goto L17
    L14:
        if (this != r105) goto L16;
        r101 = KtvSubElement.CONTAINER;
        goto L17
    L16:
        r101 = null;
        goto L17
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        qo0.a.c("choose_container", "container fragment created, enter scope");
        lp0.c r101 = this.f84123g;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("scope");
    L5:
        l.a(r101);
        Disposable r102 = xs2.b.a().b(ep0.a.class).subscribe(new b(this));
        Intrinsics.checkNotNullParameter(r102, "$this$autoDispose");
        this.f84133q.a(r102);
        if (r100 == null) goto L8;
        HashMap<String, zo0.f> r103 = zo0.g.f573094a;
        h.b(PerformanceScene.CHOOSE_PAGE).n();
    L8:
        lp0.c r104 = this.f84123g;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("scope");
    L11:
        mp0.a r105 = lp0.b.a(r104);
        if (r105 == null) goto L15;
        mp0.a.c(r105, "container_loaded", null, null, 14);
        return;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        AnchorMiniAppDataContext.Companion.getClass();
        AnchorMiniAppDataContext r102 = AnchorMiniAppDataContext.a.a();
        if (r102 == null) goto L7;
        n<MiniAppEntrancePermissionResponse> r103 = r102.getEntranceInfo();
        if (r103 == null) goto L7;
        final MiniAppEntrancePermissionResponse r104 = r103.getValue();
    L8:
        ((MiniAppChooseTitleBar) S90(R.id.title_bar)).setCloseBtnOnClickListener(new MiniAppChooseContainerFragment$initTitleBar$1(this));
        ((MiniAppChooseTitleBar) S90(R.id.title_bar)).setHelpBtnOnClickListener(new MiniAppChooseContainerFragment$initTitleBar$2(this, r104));
        if (v.a() == false) goto L11;
        ((MiniAppChooseTitleBar) S90(R.id.title_bar)).setHelpBtnOnLongClickListener(new MiniAppChooseContainerFragment$initTitleBar$3(this));
    L11:
        MiniAppChooseTitleBar r105 = (MiniAppChooseTitleBar) S90(R.id.title_bar);
        if (r104 != null) goto L14;
    L17:
        boolean r106 = true;
    L18:
        r105.d(r106);
        this.f84125i = (TabLayout) ((MiniAppChooseTitleBar) S90(R.id.title_bar)).findViewById(R.id.tab_layout);
        this.f84126j = (ViewPager) ((LinearLayout) S90(R.id.choose_container_root)).findViewById(R.id.view_pager);
        this.f84127k = new MiniAppChooseContainerTabPagerAdapter(getChildFragmentManager());
        AnchorMiniAppDataContext r107 = AnchorMiniAppDataContext.a.a();
        if (r107 == null) goto L30;
        n<MiniAppEntrancePermissionResponse> r108 = r107.getEntranceInfo();
        if (r108 == null) goto L30;
        MiniAppEntrancePermissionResponse r109 = r108.getValue();
        if (r109 == null) goto L30;
        if (r109.getShowIntroPanel() != true) goto L30;
        MiniAppChooseContainerTabPagerAdapter r110 = this.f84127k;
        if (r110 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
    L29:
        r110.f((MiniAppChooseIntroFragment) this.f84128l.getValue(), s1.B(R.string.ttlive_mini_app_choose_miniapp_page_title));
    L34:
        TabLayout r111 = this.f84125i;
        if (r111 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    L37:
        r111.addTab(r111.newTab().setText(s1.B(R.string.ttlive_mini_app_choose_miniapp_page_title)));
        if (MiniAppChooseTalentSettingUtil.b() == false) goto L69;
        lp0.c r112 = this.f84123g;
        if (r112 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("scope");
    L42:
        com.bytedance.android.live.openplatform.impl.miniappanchor.choose.c r113 = lp0.b.c(r112);
        if (r113 == null) goto L69;
        if (r113.f84114c != true) goto L69;
        lp0.c r114 = this.f84123g;
        if (r114 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("scope");
    L50:
        if (lp0.b.d(r114) == false) goto L62;
        lp0.c r115 = this.f84123g;
        if (r115 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("scope");
    L55:
        if (lp0.b.d(r115) == false) goto L69;
        AnchorMiniAppDataContext r116 = AnchorMiniAppDataContext.a.a();
        if (r116 == null) goto L62;
        com.bytedance.live.datacontext.m<Boolean> r117 = r116.getMicroAppMountPunishing();
        if (r117 == null) goto L62;
        if (r117.getValue().booleanValue() == true) goto L69;
    L62:
        MiniAppChooseContainerTabPagerAdapter r118 = this.f84127k;
        if (r118 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
    L65:
        r118.f((MiniAppChooseLynxFragment) this.f84131o.getValue(), s1.B(R.string.ttlive_mini_app_choose_lynx_page_title));
        TabLayout r119 = this.f84125i;
        if (r119 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    L68:
        r119.addTab(r119.newTab().setText(s1.B(R.string.ttlive_mini_app_choose_lynx_page_title)));
        ((MiniAppChooseTitleBar) S90(R.id.title_bar)).post(new d(this));
    L69:
        ViewPager r120 = this.f84126j;
        if (r120 != null) goto L72;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    L72:
        MiniAppChooseContainerTabPagerAdapter r121 = this.f84127k;
        if (r121 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
    L75:
        r120.setAdapter(r121);
        TabLayout r122 = this.f84125i;
        if (r122 != null) goto L78;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    L78:
        ViewPager r123 = this.f84126j;
        if (r123 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    L81:
        r122.setupWithViewPager(r123);
        int r124 = MiniAppChooseTalentSettingUtil.a();
        ViewPager r125 = this.f84126j;
        if (r125 != null) goto L84;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
    L84:
        r125.setCurrentItem(r124);
        this.f84132p = r124;
        if (r124 != 0) goto L87;
        U90();
    L87:
        TabLayout r126 = this.f84125i;
        if (r126 != null) goto L90;
        Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
    L90:
        r126.addOnTabSelectedListener(new e(this));
        ((LinearLayout) S90(R.id.choose_container_root)).post(new c(this));
        HashMap<String, zo0.f> r127 = zo0.g.f573094a;
        h.b(PerformanceScene.CHOOSE_PAGE).b();
        return;
    L30:
        MiniAppChooseContainerTabPagerAdapter r128 = this.f84127k;
        if (r128 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
    L33:
        r128.f((MiniAppChooseListFragment) this.f84130n.getValue(), s1.B(R.string.ttlive_mini_app_choose_miniapp_page_title));
        goto L34
    L14:
        if (r104.getPermitStatus() != 0) goto L17;
        r106 = false;
    L7:
        r104 = null;
        goto L8
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_mini_app_choose_container_fragment, r101, false);
    }
}
