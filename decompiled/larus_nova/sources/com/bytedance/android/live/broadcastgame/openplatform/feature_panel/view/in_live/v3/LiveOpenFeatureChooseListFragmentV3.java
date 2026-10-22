package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live.v3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.broadcastgame.api.model.n0;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.adapter.v3.OpenFeatureTabPageAdapterV3;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live.AbsLiveOpenFeatureChooseFragment;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.tab.TabSelectorView;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewmodel.AbsOpenFeaturePanelViewModel;
import com.bytedance.android.live.cloudgrouplive.model.CloudGroupLivePipelineStatus;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.bytedance.android.livesdk.chatroom.ui.SSGridLayoutManager;
import com.bytedance.android.livesdk.widget.LivePagerSlidingTabStrip;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.utility.SharedPrefHelper;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.android.material.appbar.AppBarLayout;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/view/in_live/v3/LiveOpenFeatureChooseListFragmentV3;", "Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/view/in_live/AbsLiveOpenFeatureChooseFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveOpenFeatureChooseListFragmentV3 extends AbsLiveOpenFeatureChooseFragment {
    public static final /* synthetic */ int F = 0;
    public TextView A;
    public final b B;
    public final HashMap<Integer, b> C;
    public int D;
    public AbsOpenFeaturePanelViewModel E;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f61521d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OpenFeatureTabPageAdapterV3 f61522e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ViewPager f61523f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f61524g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LivePagerSlidingTabStrip f61525h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TabSelectorView f61526i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public MultiTypeAdapter f61527j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public RecyclerView f61528k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f61529l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public AppBarLayout f61530m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public LinearLayout f61531n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public LinearLayout f61532o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public LivePagerSlidingTabStrip f61533p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public RecyclerView f61534q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ViewPager f61535r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public HSImageView f61536s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public LiveDoubleColorBallAnimationView f61537t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public LinearLayout f61538u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public TextView f61539v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public TextView f61540w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public TextView f61541x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ImageView f61542y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public ImageView f61543z;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f61544a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f61545b;

        public b() {
            this(-1, -1);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L10;
            b r101 = (b) r100;
            if (this.f61544a == r101.f61544a) goto L8;
            return false;
        L8:
            if (this.f61545b == r101.f61545b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            return (this.f61544a * 31) + this.f61545b;
        }

        public final String toString() {
            return "ItemVisibleBound(leftBound=" + this.f61544a + ", rightBound=" + this.f61545b + ")";
        }

        public b(int r100, int r101) {
            this.f61544a = r100;
            this.f61545b = r101;
        }
    }

    public static abstract class c {

        public static final class a extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f61546a = null;

            static {
                f61546a = new a();
            }

            public a() {
            }
        }

        public static final class b extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f61547a = null;

            static {
                f61547a = new b();
            }

            public b() {
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live.v3.LiveOpenFeatureChooseListFragmentV3$c$c, reason: collision with other inner class name */
        public static final class C1018c extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C1018c f61548a = null;

            static {
                f61548a = new C1018c();
            }

            public C1018c() {
            }
        }

        public c() {
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live.AbsLiveOpenFeatureChooseFragment
    public final void S90() {
        this.f61529l = true;
    }

    public final void X90() {
        z30.b r100 = ((IInteractService) jc1.k.n(IInteractService.class)).getCloudGroupLiveService();
        if (r100 == null) goto L5;
        CloudGroupLivePipelineStatus r101 = r100.b();
    L7:
        if (r101 == CloudGroupLivePipelineStatus.END) goto L12;
        ImageView r102 = this.f61543z;
        if (r102 == null) goto L13;
        UtilityKotlinExtentionsKt.t(r102);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r101 = null;
        goto L7
    }

    public final void Z90() {
        MultiTypeAdapter r100 = this.f61527j;
        if (r100 == null) goto L5;
        r100.f513437a = new ArrayList();
    L5:
        MultiTypeAdapter r101 = this.f61527j;
        if (r101 == null) goto L9;
        r101.notifyDataSetChanged();
        return;
    }

    public LiveOpenFeatureChooseListFragmentV3() {
        SharedPrefHelper.b(s1.getContext());
        ((IHostContext) jc1.k.n(IHostContext.class)).getServerDeviceId();
        ((IUserService) jc1.k.n(IUserService.class)).user().n();
        ((IHostContext) jc1.k.n(IHostContext.class)).getServerDeviceId();
        this.f61529l = true;
        this.B = new b(-1, -1);
        this.C = new HashMap();
        this.D = -1;
    }

    public final void aa0(boolean r100) {
        LinearLayout r101 = this.f61538u;
        int r102 = 0;
        if (r101 == null) goto L8;
        if (r100 == false) goto L6;
        int r103 = 0;
    L7:
        r101.setVisibility(r103);
        goto L8
    L6:
        r103 = 8;
    L8:
        LiveDoubleColorBallAnimationView r104 = this.f61537t;
        if (r104 == null) goto L15;
        if (r100 == true) goto L13;
        r102 = 8;
    L13:
        r104.setVisibility(r102);
        return;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        AbsOpenFeaturePanelViewModel.Companion.getClass();
        this.E = AbsOpenFeaturePanelViewModel.a.a(true, this);
        IInteractService r101 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r101 == null) goto L6;
        r101.updateSwitchSceneSource("interaction_button");
        return;
    }

    public static final void U90(LiveOpenFeatureChooseListFragmentV3 r100, boolean r101) {
        if (r101 == true) goto L14;
        OpenFeatureTabPageAdapterV3 r102 = r100.f61522e;
        if (r102 == null) goto L16;
        ArrayList<c20.d> r103 = r102.f61400b;
        if (r103 == null) goto L17;
        ViewPager r104 = r100.f61523f;
        if (r104 == null) goto L10;
        int r105 = r104.getCurrentItem();
    L11:
        c20.d r106 = (c20.d) ListProtector.get(r103, r105);
        if (r106 == null) goto L18;
        int r107 = d20.a.f466501a;
        d20.a.d(r106.f22136b);
        return;
    L18:
        return;
    L10:
        r105 = 0;
        goto L11
    L17:
        return;
    L16:
        return;
    L14:
        r100.getClass();
    }

    public static final void W90(LiveOpenFeatureChooseListFragmentV3 r100, boolean r101) {
        LinearLayout r102 = r100.f61531n;
        ViewGroup.LayoutParams r103 = null;
        if (r102 == null) goto L5;
        ViewParent r104 = r102.getParent();
    L7:
        if ((r104 instanceof AppBarLayout) == false) goto L23;
        LinearLayout r105 = r100.f61531n;
        if (r105 == null) goto L11;
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
    L13:
        if ((r106 instanceof AppBarLayout.LayoutParams) == false) goto L16;
        r103 = r106;
    L16:
        AppBarLayout.LayoutParams r107 = (AppBarLayout.LayoutParams) r103;
        if (r101 == false) goto L20;
        if (r107 == null) goto L24;
        r107.setScrollFlags(1);
        return;
    L24:
        return;
    L20:
        if (r107 == null) goto L26;
        r107.setScrollFlags(0);
        return;
    L26:
        return;
    L11:
        r106 = null;
        goto L13
    L23:
        return;
    L5:
        r104 = null;
        goto L7
    }

    public final void da0(View r100, int r101) {
        ViewGroup.LayoutParams r102 = null;
        if (r100 == null) goto L5;
        ViewGroup.LayoutParams r103 = r100.getLayoutParams();
    L7:
        if ((r103 instanceof LinearLayout.LayoutParams) == false) goto L10;
        r102 = r103;
    L10:
        LinearLayout.LayoutParams r104 = (LinearLayout.LayoutParams) r102;
        if (r104 == null) goto L13;
        r104.width = (int) UtilityKotlinExtentionsKt.h(180);
    L13:
        if (r101 == 0) goto L16;
        if (r104 == null) goto L16;
        r104.height = (int) UtilityKotlinExtentionsKt.h(r101);
    L16:
        if (r104 == null) goto L19;
        r100.setLayoutParams(r104);
        return;
    L19:
        return;
    L5:
        r103 = null;
        goto L7
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        this.D = -1;
        this.f61529l = true;
        this.f61530m = (AppBarLayout) r110.findViewById(R.id.appbar_layout);
        this.f61531n = (LinearLayout) r110.findViewById(R.id.appbar_layout_content);
        this.f61532o = (LinearLayout) r110.findViewById(R.id.error_area);
        this.f61533p = (LivePagerSlidingTabStrip) r110.findViewById(R.id.feature_category_tab);
        this.f61534q = (RecyclerView) r110.findViewById(R.id.feature_group_list);
        this.f61535r = (ViewPager) r110.findViewById(R.id.feature_tab_list);
        this.f61536s = (HSImageView) r110.findViewById(R.id.img_tip);
        this.f61537t = (LiveDoubleColorBallAnimationView) r110.findViewById(R.id.loading_anim_view);
        this.f61538u = (LinearLayout) r110.findViewById(R.id.loading_view_container);
        this.f61539v = (TextView) r110.findViewById(R.id.network_tip);
        this.f61540w = (TextView) r110.findViewById(R.id.retry_btn);
        this.f61541x = (TextView) r110.findViewById(R.id.txt_tip);
        this.f61542y = (ImageView) r110.findViewById(R.id.img_back);
        this.f61543z = (ImageView) r110.findViewById(R.id.search_btn);
        this.A = (TextView) r110.findViewById(R.id.txt_title);
        ImageView r100 = this.f61542y;
        if (r100 == null) goto L5;
        UtilityKotlinExtentionsKt.v(r100, false);
    L5:
        ImageView r101 = this.f61543z;
        if (r101 == null) goto L8;
        UtilityKotlinExtentionsKt.v(r101, true);
    L8:
        ImageView r102 = this.f61543z;
        if (r102 == null) goto L11;
        r102.setOnClickListener(new k(this));
    L11:
        TextView r103 = this.A;
        if (r103 == null) goto L14;
        r103.setText(R.string.ttlive_open_platform_feature_list_inlive_subtitle);
    L14:
        RecyclerView r104 = (RecyclerView) r110.findViewById(R.id.feature_group_list);
        this.f61528k = r104;
        if (r104 == null) goto L17;
        r104.setOverScrollMode(2);
    L17:
        final SSGridLayoutManager r105 = new SSGridLayoutManager(getContext(), 5);
        RecyclerView r106 = this.f61528k;
        if (r106 == null) goto L20;
        r106.setLayoutManager(r105);
    L20:
        r105.setSpanSizeLookup(new LiveOpenFeatureChooseListFragmentV3$initGroupListView$1(this));
        MultiTypeAdapter r107 = new MultiTypeAdapter();
        this.f61527j = r107;
        AbsOpenFeaturePanelViewModel r108 = this.E;
        a20.d r109 = null;
        if (r108 == null) goto L23;
        a20.d r112 = r108.getFeatureIconBehaviorController();
    L25:
        if ((r112 instanceof a20.e) == true) goto L27;
        r112 = null;
    L27:
        r107.z2(f10.f.class, new z10.a(r112));
        MultiTypeAdapter r113 = this.f61527j;
        if (r113 == null) goto L37;
        AbsOpenFeaturePanelViewModel r114 = this.E;
        if (r114 == null) goto L32;
        a20.d r115 = r114.getFeatureIconBehaviorController();
    L34:
        if ((r115 instanceof a20.e) == true) goto L36;
        r115 = null;
    L36:
        r113.z2(f10.d.class, new z10.d(r115));
        goto L37
    L32:
        r115 = null;
    L37:
        MultiTypeAdapter r116 = this.f61527j;
        if (r116 == null) goto L40;
        r116.z2(f10.b.class, new f10.c());
    L40:
        RecyclerView r117 = this.f61528k;
        if (r117 == null) goto L43;
        r117.setAdapter(this.f61527j);
    L43:
        RecyclerView r118 = this.f61528k;
        if (r118 == null) goto L46;
        UtilityKotlinExtentionsKt.v(r118, true);
    L46:
        RecyclerView r119 = this.f61528k;
        if (r119 == null) goto L49;
        r119.addItemDecoration(new LiveOpenFeatureChooseListFragmentV3$initGroupListView$$inlined$let$lambda$1(this));
        r119.addOnScrollListener(new LiveOpenFeatureChooseListFragmentV3$initRecyclerScrollListener$1(LiveOpenFeatureChooseListFragmentV3$initGroupListView$2$2.INSTANCE, new LiveOpenFeatureChooseListFragmentV3$initGroupListView$$inlined$let$lambda$2(this, r105)));
    L49:
        this.f61524g = r110.findViewById(R.id.feature_tab_list_title);
        this.f61523f = (ViewPager) r110.findViewById(R.id.feature_tab_list);
        this.f61525h = (LivePagerSlidingTabStrip) r110.findViewById(R.id.feature_category_tab);
        this.f61526i = (TabSelectorView) r110.findViewById(R.id.tab_selector_view);
        LivePagerSlidingTabStrip r120 = this.f61525h;
        if (r120 == null) goto L52;
        r120.setTextSelectedStyle(1);
    L52:
        LivePagerSlidingTabStrip r121 = this.f61525h;
        if (r121 == null) goto L55;
        r121.A = null;
        r121.B = 1;
        r121.d();
    L55:
        LivePagerSlidingTabStrip r122 = this.f61525h;
        if (r122 == null) goto L58;
        r122.setTextSize(s1.f(15.0f));
    L58:
        List r123 = CollectionsKt.listOf(new b20.e[]{new b20.d(), new b20.b()});
        AbsOpenFeaturePanelViewModel r124 = this.E;
        if (r124 == null) goto L61;
        a20.d r125 = r124.getFeatureIconBehaviorController();
    L63:
        if ((r125 instanceof a20.e) == false) goto L66;
        r109 = r125;
    L66:
        OpenFeatureTabPageAdapterV3 r126 = new OpenFeatureTabPageAdapterV3(r109, this.f61525h, this.f61523f, r123);
        this.f61522e = r126;
        ViewPager r127 = this.f61523f;
        if (r127 == null) goto L69;
        r127.setAdapter(r126);
    L69:
        LivePagerSlidingTabStrip r128 = this.f61525h;
        if (r128 == null) goto L72;
        r128.setTabClickListener(new j(this));
    L72:
        LivePagerSlidingTabStrip r129 = this.f61525h;
        if (r129 == null) goto L75;
        r129.setOnPageChangeListener(new LiveOpenFeatureChooseListFragmentV3$initOnTabPageListener$2(this));
    L75:
        OpenFeatureTabPageAdapterV3 r130 = this.f61522e;
        if (r130 == null) goto L78;
        Function3<RecyclerView, LinearLayoutManager, Integer, Unit> r131 = new LiveOpenFeatureChooseListFragmentV3$initTabListView$2(this);
        Intrinsics.checkNotNullParameter(r131, "cb");
        r130.f61402d = r131;
    L78:
        AppBarLayout r132 = this.f61530m;
        if (r132 == null) goto L81;
        r132.addOnOffsetChangedListener(new com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live.v3.a(this));
    L81:
        AbsOpenFeaturePanelViewModel r133 = this.E;
        if (r133 == null) goto L86;
        LiveData<Boolean> r134 = r133.getNoOpenFeatureGroupListData();
        if (r134 == null) goto L86;
        r134.observe(this, new com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live.v3.c(this));
    L86:
        AbsOpenFeaturePanelViewModel r135 = this.E;
        if (r135 == null) goto L91;
        LiveData<Boolean> r136 = r135.getNoOpenFeatureTabListData();
        if (r136 == null) goto L91;
        r136.observe(this, new d(this));
    L91:
        AbsOpenFeaturePanelViewModel r137 = this.E;
        if (r137 == null) goto L96;
        LiveData<List<Object>> r138 = r137.getOpenFeatureGroupListData();
        if (r138 == null) goto L96;
        r138.observe(this, new e(this));
    L96:
        AbsOpenFeaturePanelViewModel r139 = this.E;
        if (r139 == null) goto L101;
        LiveData<Boolean> r140 = r139.getOpenFeatureListLoadingState();
        if (r140 == null) goto L101;
        r140.observe(this, new f(this));
    L101:
        AbsOpenFeaturePanelViewModel r141 = this.E;
        if (r141 == null) goto L106;
        LiveData<c20.c> r142 = r141.getOpenFeatureTabListData();
        if (r142 == null) goto L106;
        r142.observe(this, new g(this));
    L106:
        AbsOpenFeaturePanelViewModel r143 = this.E;
        if (r143 == null) goto L111;
        LiveData<Boolean> r144 = r143.getNoOpenFeatureListData();
        if (r144 == null) goto L111;
        r144.observe(this, new h(this));
    L111:
        AbsOpenFeaturePanelViewModel r145 = this.E;
        if (r145 == null) goto L116;
        LiveData<Boolean> r146 = r145.getRequestOpenFeatureListDataError();
        if (r146 == null) goto L116;
        r146.observe(this, new i(this));
    L116:
        AbsOpenFeaturePanelViewModel r147 = this.E;
        if (r147 == null) goto L121;
        a20.i r148 = r147.getFeatureListHandler();
        if (r148 == null) goto L121;
        r148.d();
    L121:
        Room r149 = ((IRoomService) jc1.k.n(IRoomService.class)).getCurrentRoom();
        if (r149 != null) goto L124;
    L128:
        X90();
        return;
    L124:
        if (r149.isVirtualLive != true) goto L128;
        ImageView r150 = this.f61543z;
        if (r150 == null) goto L128;
        UtilityKotlinExtentionsKt.t(r150);
        goto L128
    L61:
        r125 = null;
        goto L63
    L23:
        r112 = null;
        goto L25
    }

    public static final void T90(LiveOpenFeatureChooseListFragmentV3 r100, c20.d r101, int r102) {
        r100.getClass();
        n0 r103 = r101.f22137c;
        if (r103 == null) goto L13;
        TabSelectorView r104 = r100.f61526i;
        if (r104 == null) goto L7;
        r104.b(r103, new com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live.v3.b(r100, r102, r101));
    L7:
        TabSelectorView r105 = r100.f61526i;
        if (r105 == null) goto L10;
        UtilityKotlinExtentionsKt.v(r105, true);
    L10:
        OpenFeatureTabPageAdapterV3 r106 = r100.f61522e;
        if (r106 == null) goto L20;
        r106.f(r102);
        Unit r107 = Unit.INSTANCE;
        return;
    L20:
        return;
    L13:
        TabSelectorView r108 = r100.f61526i;
        if (r108 == null) goto L16;
        r108.b(null, null);
    L16:
        TabSelectorView r109 = r100.f61526i;
        if (r109 == null) goto L22;
        UtilityKotlinExtentionsKt.v(r109, false);
        Unit r110 = Unit.INSTANCE;
        return;
    }

    public static final void V90(final LiveOpenFeatureChooseListFragmentV3 r100, final LinearLayoutManager r101, final int r102) {
        if (r100.C.size() != 0) goto L5;
        return;
    L5:
        if (r102 >= r100.C.size()) goto L18;
        if (r102 < 0) goto L21;
        final b r103 = r100.C.get(Integer.valueOf(r102));
        if (r103 == null) goto L19;
        ViewPager r104 = r100.f61523f;
        if (r104 != null) goto L13;
        return;
    L13:
        if (r104.getCurrentItem() != r102) goto L22;
        Y90(r101, r103, new LiveOpenFeatureChooseListFragmentV3$processTabListVisibleScroll$$inlined$let$lambda$1(r103, r100, r102, r101), new LiveOpenFeatureChooseListFragmentV3$processTabListVisibleScroll$$inlined$let$lambda$2(r100, r102, r101));
        r100.D = r102;
        return;
    L22:
        return;
    L19:
        return;
    L21:
        return;
    }

    public static b ba0(int r100, int r101, LinearLayoutManager r102) {
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

    public final void ca0(View r100, int r101, int r102) {
        ViewGroup.LayoutParams r103 = null;
        if (r100 == null) goto L5;
        ViewGroup.LayoutParams r104 = r100.getLayoutParams();
    L7:
        if ((r104 instanceof LinearLayout.LayoutParams) == true) goto L9;
        r104 = null;
    L9:
        LinearLayout.LayoutParams r105 = (LinearLayout.LayoutParams) r104;
        if (r100 == null) goto L13;
        r103 = r100.getLayoutParams();
    L13:
        if ((r103 instanceof LinearLayout.LayoutParams) == true) goto L15;
        com.bytedance.android.live.broadcastgame.opengame.utils.i.c("OpenFeatureChooseListFragment中当前view不在LinearLayout中，会引起布局UI不对");
    L15:
        if (r105 == null) goto L17;
        r105.topMargin = (int) UtilityKotlinExtentionsKt.h(r101);
    L17:
        if (r102 <= 0) goto L20;
        if (r105 == null) goto L20;
        r105.bottomMargin = (int) UtilityKotlinExtentionsKt.h(r102);
    L20:
        if (r105 == null) goto L23;
        r100.setLayoutParams(r105);
        return;
    L23:
        return;
    L5:
        r104 = null;
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.ttlive_open_feature_list_fragment_v3, r101, false);
    }

    public static void Y90(LinearLayoutManager r100, b r110, Function1 r111, Function2 r112) {
        b r101 = ba0(r100.findFirstVisibleItemPosition(), r100.findLastVisibleItemPosition(), r100);
        int r102 = r110.f61544a;
        if (r102 == (-1)) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == false) goto L10;
        int r113 = r101.f61544a;
        int r104 = r101.f61545b;
    L26:
        if (r113 < 0) goto L30;
        if (r104 < 0) goto L30;
        if (r113 > r104) goto L30;
        b r105 = ba0(r113, r104, r100);
        r112.invoke(Integer.valueOf(r105.f61544a), Integer.valueOf(r105.f61545b));
    L30:
        r111.invoke(r101);
        return;
    L10:
        int r106 = r101.f61544a;
        int r107 = r101.f61545b;
        int r108 = (r106 + r107) / 2;
        int r109 = r110.f61545b;
        if (r108 <= ((r102 + r109) / 2)) goto L14;
        Object r114 = c.C1018c.f61548a;
    L18:
        if (Intrinsics.areEqual(r114, c.a.f61546a) == false) goto L21;
        int r115 = r101.f61544a;
        r104 = Math.min(r101.f61545b, r110.f61544a - 1);
        r113 = r115;
        goto L26
    L21:
        if (Intrinsics.areEqual(r114, c.C1018c.f61548a) == false) goto L24;
        r113 = Math.max(r110.f61545b + 1, r101.f61544a);
        r104 = r101.f61545b;
        goto L26
    L24:
        if (Intrinsics.areEqual(r114, c.b.f61547a) == false) goto L33;
        r113 = r101.f61544a;
        r104 = r101.f61545b;
        goto L26
    L33:
        throw new NoWhenBranchMatchedException();
    L14:
        if (((r106 + r107) / 2) >= ((r102 + r109) / 2)) goto L16;
        r114 = c.a.f61546a;
        goto L18
    L16:
        r114 = c.b.f61547a;
        goto L18
    L5:
        if (r110.f61545b != (-1)) goto L7;
        r103 = true;
        goto L8
    }
}
