package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.adapter.OpenFeatureTabPageAdapter;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewmodel.AbsOpenFeaturePanelViewModel;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.bytedance.android.livesdk.chatroom.ui.SSGridLayoutManager;
import com.bytedance.android.livesdk.widget.LivePagerSlidingTabStrip;
import com.bytedance.ies.utility.SharedPrefHelper;
import com.google.android.material.appbar.AppBarLayout;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/view/in_live/LiveOpenFeatureChooseListFragment;", "Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/view/in_live/AbsLiveOpenFeatureChooseFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveOpenFeatureChooseListFragment extends AbsLiveOpenFeatureChooseFragment {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f61466p = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<Integer, View> f61467d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f61468e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public OpenFeatureTabPageAdapter f61469f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ViewPager f61470g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LivePagerSlidingTabStrip f61471h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public MultiTypeAdapter f61472i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public RecyclerView f61473j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f61474k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b f61475l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final HashMap<Integer, b> f61476m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f61477n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public AbsOpenFeaturePanelViewModel f61478o;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f61479a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f61480b;

        public b() {
            this(-1, -1);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L10;
            b r101 = (b) r100;
            if (this.f61479a == r101.f61479a) goto L8;
            return false;
        L8:
            if (this.f61480b == r101.f61480b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            return (this.f61479a * 31) + this.f61480b;
        }

        public final String toString() {
            return "ItemVisibleBound(leftBound=" + this.f61479a + ", rightBound=" + this.f61480b + ")";
        }

        public b(int r100, int r101) {
            this.f61479a = r100;
            this.f61480b = r101;
        }
    }

    public static abstract class c {

        public static final class a extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f61481a = null;

            static {
                f61481a = new a();
            }

            public a() {
            }
        }

        public static final class b extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f61482a = null;

            static {
                f61482a = new b();
            }

            public b() {
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live.LiveOpenFeatureChooseListFragment$c$c, reason: collision with other inner class name */
        public static final class C1017c extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C1017c f61483a = null;

            static {
                f61483a = new C1017c();
            }

            public C1017c() {
            }
        }

        public c() {
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live.AbsLiveOpenFeatureChooseFragment
    public final void S90() {
        this.f61474k = true;
    }

    public final void X90() {
        MultiTypeAdapter r100 = this.f61472i;
        if (r100 == null) goto L5;
        r100.f513437a = new ArrayList();
    L5:
        MultiTypeAdapter r101 = this.f61472i;
        if (r101 == null) goto L9;
        r101.notifyDataSetChanged();
        return;
    }

    public LiveOpenFeatureChooseListFragment() {
        this.f61467d = new LinkedHashMap();
        SharedPrefHelper.b(s1.getContext());
        ((IHostContext) jc1.k.n(IHostContext.class)).getServerDeviceId();
        ((IUserService) jc1.k.n(IUserService.class)).user().n();
        ((IHostContext) jc1.k.n(IHostContext.class)).getServerDeviceId();
        this.f61474k = true;
        this.f61475l = new b(-1, -1);
        this.f61476m = new HashMap();
        this.f61477n = -1;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f61467d.clear();
    }

    public final View T90(int r100) {
        if (this.f61467d != null) goto L5;
        this.f61467d = new LinkedHashMap();
    L5:
        View r101 = this.f61467d.get(Integer.valueOf(r100));
        if (r101 != null) goto L14;
        View r102 = getView();
        if (r102 == null) goto L12;
        View r103 = r102.findViewById(r100);
        if (r103 == null) goto L12;
        this.f61467d.put(Integer.valueOf(r100), r103);
        return r103;
    L12:
        return null;
    L14:
        return r101;
    }

    public final void Y90(boolean r100) {
        LinearLayout r101 = (LinearLayout) T90(R.id.loading_view_container);
        int r102 = 0;
        if (r100 == false) goto L5;
        int r103 = 0;
    L6:
        r101.setVisibility(r103);
        LiveDoubleColorBallAnimationView r104 = (LiveDoubleColorBallAnimationView) T90(R.id.loading_anim_view);
        if (r100 == true) goto L10;
        r102 = 8;
    L10:
        r104.setVisibility(r102);
        return;
    L5:
        r103 = 8;
        goto L6
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        AbsOpenFeaturePanelViewModel.Companion.getClass();
        this.f61478o = AbsOpenFeaturePanelViewModel.a.a(true, this);
        IInteractService r101 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r101 == null) goto L6;
        r101.updateSwitchSceneSource("interaction_button");
        return;
    }

    public static final void V90(LiveOpenFeatureChooseListFragment r100, boolean r101) {
        if ((((LinearLayout) r100.T90(R.id.appbar_layout_content)).getParent() instanceof AppBarLayout) == false) goto L14;
        ViewGroup.LayoutParams r102 = ((LinearLayout) r100.T90(R.id.appbar_layout_content)).getLayoutParams();
        if ((r102 instanceof AppBarLayout.LayoutParams) == true) goto L7;
        r102 = null;
    L7:
        AppBarLayout.LayoutParams r103 = (AppBarLayout.LayoutParams) r102;
        if (r101 == false) goto L11;
        if (r103 == null) goto L15;
        r103.setScrollFlags(1);
        return;
    L15:
        return;
    L11:
        if (r103 == null) goto L17;
        r103.setScrollFlags(0);
        return;
    L17:
        return;
    }

    public final void ba0(View r100, int r101) {
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if ((r102 instanceof LinearLayout.LayoutParams) == true) goto L5;
        r102 = null;
    L5:
        LinearLayout.LayoutParams r103 = (LinearLayout.LayoutParams) r102;
        if (r103 == null) goto L8;
        r103.width = (int) UtilityKotlinExtentionsKt.h(180);
    L8:
        if (r101 == 0) goto L11;
        if (r103 == null) goto L11;
        r103.height = (int) UtilityKotlinExtentionsKt.h(r101);
    L11:
        if (r103 == null) goto L14;
        r100.setLayoutParams(r103);
        return;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        this.f61477n = -1;
        this.f61474k = true;
        ImageView r100 = (ImageView) T90(R.id.img_back);
        if (r100 == null) goto L5;
        UtilityKotlinExtentionsKt.v(r100, false);
    L5:
        ImageView r101 = (ImageView) T90(R.id.search_btn);
        if (r101 == null) goto L8;
        UtilityKotlinExtentionsKt.v(r101, true);
    L8:
        ImageView r102 = (ImageView) T90(R.id.search_btn);
        if (r102 == null) goto L11;
        r102.setOnClickListener(new o(this));
    L11:
        TextView r103 = (TextView) T90(R.id.txt_title);
        if (r103 == null) goto L14;
        r103.setText(R.string.ttlive_open_platform_feature_list_inlive_subtitle);
    L14:
        UtilityKotlinExtentionsKt.v(T90(R.id.search_input), false);
        RecyclerView r104 = (RecyclerView) r110.findViewById(R.id.feature_group_list);
        this.f61473j = r104;
        if (r104 == null) goto L17;
        r104.setOverScrollMode(2);
    L17:
        final SSGridLayoutManager r105 = new SSGridLayoutManager(getContext(), 5);
        RecyclerView r106 = this.f61473j;
        if (r106 == null) goto L20;
        r106.setLayoutManager(r105);
    L20:
        r105.setSpanSizeLookup(new LiveOpenFeatureChooseListFragment$initGroupListView$1(this));
        MultiTypeAdapter r107 = new MultiTypeAdapter();
        this.f61472i = r107;
        AbsOpenFeaturePanelViewModel r108 = this.f61478o;
        a20.d r109 = null;
        if (r108 == null) goto L23;
        a20.d r112 = r108.getFeatureIconBehaviorController();
    L25:
        if ((r112 instanceof a20.e) == true) goto L27;
        r112 = null;
    L27:
        r107.z2(f10.f.class, new com.bytedance.android.live.broadcastgame.openplatform.feature_panel.adapter.a(r112));
        MultiTypeAdapter r113 = this.f61472i;
        if (r113 == null) goto L37;
        AbsOpenFeaturePanelViewModel r114 = this.f61478o;
        if (r114 == null) goto L32;
        a20.d r115 = r114.getFeatureIconBehaviorController();
    L34:
        if ((r115 instanceof a20.e) == true) goto L36;
        r115 = null;
    L36:
        r113.z2(f10.d.class, new com.bytedance.android.live.broadcastgame.openplatform.feature_panel.adapter.b(r115));
        goto L37
    L32:
        r115 = null;
    L37:
        MultiTypeAdapter r116 = this.f61472i;
        if (r116 == null) goto L40;
        r116.z2(f10.b.class, new f10.c());
    L40:
        RecyclerView r117 = this.f61473j;
        if (r117 == null) goto L43;
        r117.setAdapter(this.f61472i);
    L43:
        RecyclerView r118 = this.f61473j;
        if (r118 == null) goto L46;
        UtilityKotlinExtentionsKt.v(r118, true);
    L46:
        RecyclerView r119 = this.f61473j;
        if (r119 == null) goto L49;
        r119.addOnScrollListener(new LiveOpenFeatureChooseListFragment$initRecyclerScrollListener$1(LiveOpenFeatureChooseListFragment$initGroupListView$2$1.INSTANCE, new LiveOpenFeatureChooseListFragment$initGroupListView$$inlined$let$lambda$1(this, r105)));
    L49:
        this.f61470g = (ViewPager) r110.findViewById(R.id.feature_tab_list);
        LivePagerSlidingTabStrip r120 = (LivePagerSlidingTabStrip) r110.findViewById(R.id.feature_category_tab);
        this.f61471h = r120;
        if (r120 == null) goto L52;
        r120.setTextSelectedStyle(1);
    L52:
        LivePagerSlidingTabStrip r121 = this.f61471h;
        if (r121 == null) goto L55;
        r121.A = null;
        r121.B = 0;
        r121.d();
    L55:
        List r122 = CollectionsKt.listOf(new b20.e[]{new b20.d(), new b20.b()});
        AbsOpenFeaturePanelViewModel r123 = this.f61478o;
        if (r123 == null) goto L58;
        a20.d r124 = r123.getFeatureIconBehaviorController();
    L60:
        if ((r124 instanceof a20.e) == false) goto L63;
        r109 = r124;
    L63:
        OpenFeatureTabPageAdapter r125 = new OpenFeatureTabPageAdapter(r109, this.f61471h, this.f61470g, r122);
        this.f61469f = r125;
        r125.f61382e = new n(this);
        ViewPager r126 = this.f61470g;
        if (r126 == null) goto L66;
        r126.setAdapter(r125);
    L66:
        LivePagerSlidingTabStrip r127 = this.f61471h;
        if (r127 == null) goto L69;
        r127.setOnPageChangeListener(new LiveOpenFeatureChooseListFragment$initOnTabPageListener$1(this));
    L69:
        OpenFeatureTabPageAdapter r128 = this.f61469f;
        if (r128 == null) goto L72;
        Function3<RecyclerView, LinearLayoutManager, Integer, Unit> r129 = new LiveOpenFeatureChooseListFragment$initTabListView$2(this);
        Intrinsics.checkNotNullParameter(r129, "cb");
        r128.f61381d = r129;
    L72:
        ((AppBarLayout) T90(R.id.appbar_layout)).addOnOffsetChangedListener(new f(this));
        AbsOpenFeaturePanelViewModel r130 = this.f61478o;
        if (r130 == null) goto L77;
        LiveData<Boolean> r131 = r130.getNoOpenFeatureGroupListData();
        if (r131 == null) goto L77;
        r131.observe(this, new g(this));
    L77:
        AbsOpenFeaturePanelViewModel r132 = this.f61478o;
        if (r132 == null) goto L82;
        LiveData<Boolean> r133 = r132.getNoOpenFeatureTabListData();
        if (r133 == null) goto L82;
        r133.observe(this, new h(this));
    L82:
        AbsOpenFeaturePanelViewModel r134 = this.f61478o;
        if (r134 == null) goto L87;
        LiveData<List<Object>> r135 = r134.getOpenFeatureGroupListData();
        if (r135 == null) goto L87;
        r135.observe(this, new i(this));
    L87:
        AbsOpenFeaturePanelViewModel r136 = this.f61478o;
        if (r136 == null) goto L92;
        LiveData<Boolean> r137 = r136.getOpenFeatureListLoadingState();
        if (r137 == null) goto L92;
        r137.observe(this, new j(this));
    L92:
        AbsOpenFeaturePanelViewModel r138 = this.f61478o;
        if (r138 == null) goto L97;
        LiveData<c20.c> r139 = r138.getOpenFeatureTabListData();
        if (r139 == null) goto L97;
        r139.observe(this, new k(this));
    L97:
        AbsOpenFeaturePanelViewModel r140 = this.f61478o;
        if (r140 == null) goto L102;
        LiveData<Boolean> r141 = r140.getNoOpenFeatureListData();
        if (r141 == null) goto L102;
        r141.observe(this, new l(this));
    L102:
        AbsOpenFeaturePanelViewModel r142 = this.f61478o;
        if (r142 == null) goto L107;
        LiveData<Boolean> r143 = r142.getRequestOpenFeatureListDataError();
        if (r143 == null) goto L107;
        r143.observe(this, new m(this));
    L107:
        AbsOpenFeaturePanelViewModel r144 = this.f61478o;
        if (r144 == null) goto L113;
        a20.i r145 = r144.getFeatureListHandler();
        if (r145 == null) goto L114;
        r145.d();
        return;
    L114:
        return;
    L113:
        return;
    L58:
        r124 = null;
        goto L60
    L23:
        r112 = null;
        goto L25
    }

    public static final void U90(final LiveOpenFeatureChooseListFragment r100, final LinearLayoutManager r101, final int r102) {
        if (r100.f61476m.size() != 0) goto L5;
        return;
    L5:
        if (r102 >= r100.f61476m.size()) goto L18;
        if (r102 < 0) goto L21;
        final b r103 = r100.f61476m.get(Integer.valueOf(r102));
        if (r103 == null) goto L19;
        ViewPager r104 = r100.f61470g;
        if (r104 != null) goto L13;
        return;
    L13:
        if (r104.getCurrentItem() != r102) goto L22;
        W90(r101, r103, new LiveOpenFeatureChooseListFragment$processTabListVisibleScroll$$inlined$let$lambda$1(r103, r100, r102, r101), new LiveOpenFeatureChooseListFragment$processTabListVisibleScroll$$inlined$let$lambda$2(r100, r102, r101));
        r100.f61477n = r102;
        return;
    L22:
        return;
    L19:
        return;
    L21:
        return;
    }

    public static b Z90(int r100, int r101, LinearLayoutManager r102) {
    L2:
        if (r100 >= r101) goto L7;
        int r103 = f10.g.f475049a;
        if (f10.g.a(r102.findViewByPosition(r100), r102.getOrientation()) == true) goto L7;
        r100 = r100 + 1;
    L7:
        if (r101 <= r100) goto L13;
        int r104 = f10.g.f475049a;
        if (f10.g.a(r102.findViewByPosition(r101), r102.getOrientation()) == true) goto L13;
        r101 = r101 - 1;
    L13:
        return new b(r100, r101);
    }

    public final void aa0(View r100, int r101, int r102) {
        ViewGroup.LayoutParams r103 = r100.getLayoutParams();
        if ((r103 instanceof LinearLayout.LayoutParams) == true) goto L5;
        r103 = null;
    L5:
        LinearLayout.LayoutParams r104 = (LinearLayout.LayoutParams) r103;
        if ((r100.getLayoutParams() instanceof LinearLayout.LayoutParams) == true) goto L8;
        com.bytedance.android.live.broadcastgame.opengame.utils.i.c("OpenFeatureChooseListFragment中当前view不在LinearLayout中，会引起布局UI不对");
    L8:
        if (r104 == null) goto L10;
        r104.topMargin = (int) UtilityKotlinExtentionsKt.h(r101);
    L10:
        if (r102 <= 0) goto L13;
        if (r104 == null) goto L13;
        r104.bottomMargin = (int) UtilityKotlinExtentionsKt.h(r102);
    L13:
        if (r104 == null) goto L16;
        r100.setLayoutParams(r104);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_open_feature_list_fragment, r101, false);
    }

    public static void W90(LinearLayoutManager r100, b r110, Function1 r111, Function2 r112) {
        b r101 = Z90(r100.findFirstVisibleItemPosition(), r100.findLastVisibleItemPosition(), r100);
        int r102 = r110.f61479a;
        if (r102 == (-1)) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == false) goto L10;
        int r113 = r101.f61479a;
        int r104 = r101.f61480b;
    L26:
        if (r113 < 0) goto L30;
        if (r104 < 0) goto L30;
        if (r113 > r104) goto L30;
        b r105 = Z90(r113, r104, r100);
        r112.invoke(Integer.valueOf(r105.f61479a), Integer.valueOf(r105.f61480b));
    L30:
        r111.invoke(r101);
        return;
    L10:
        int r106 = r101.f61479a;
        int r107 = r101.f61480b;
        int r108 = (r106 + r107) / 2;
        int r109 = r110.f61480b;
        if (r108 <= ((r102 + r109) / 2)) goto L14;
        Object r114 = c.C1017c.f61483a;
    L18:
        if (Intrinsics.areEqual(r114, c.a.f61481a) == false) goto L21;
        int r115 = r101.f61479a;
        r104 = Math.min(r101.f61480b, r110.f61479a - 1);
        r113 = r115;
        goto L26
    L21:
        if (Intrinsics.areEqual(r114, c.C1017c.f61483a) == false) goto L24;
        r113 = Math.max(r110.f61480b + 1, r101.f61479a);
        r104 = r101.f61480b;
        goto L26
    L24:
        if (Intrinsics.areEqual(r114, c.b.f61482a) == false) goto L33;
        r113 = r101.f61479a;
        r104 = r101.f61480b;
        goto L26
    L33:
        throw new NoWhenBranchMatchedException();
    L14:
        if (((r106 + r107) / 2) >= ((r102 + r109) / 2)) goto L16;
        r114 = c.a.f61481a;
        goto L18
    L16:
        r114 = c.b.f61482a;
        goto L18
    L5:
        if (r110.f61480b != (-1)) goto L7;
        r103 = true;
        goto L8
    }
}
