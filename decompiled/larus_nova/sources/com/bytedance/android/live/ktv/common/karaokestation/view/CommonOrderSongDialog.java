package com.bytedance.android.live.ktv.common.karaokestation.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.karaokestation.model.UpdateTabType;
import com.bytedance.android.live.ktv.common.karaokestation.model.u;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import com.bytedance.android.livesdk.utils.w0;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.google.android.material.tabs.TabLayout;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/ktv/common/karaokestation/view/CommonOrderSongDialog;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CommonOrderSongDialog extends Fragment {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f69592u = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a> f69593d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f69594e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f69595f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f69596g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f69597h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f69598i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public FrameLayout f69599j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LinearLayout f69600k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f69601l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ViewPager f69602m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TabLayout f69603n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public FrameLayout f69604o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public FrameLayout f69605p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ImageView f69606q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public HSImageView f69607r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Function0<Unit> f69608s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final com.bytedance.android.live.ktv.common.karaokestation.model.a f69609t;

    public static final class a {
    }

    static {
    }

    public CommonOrderSongDialog() {
        this(new com.bytedance.android.live.ktv.common.karaokestation.model.a(0));
    }

    public final int S90() {
        Integer r100 = this.f69609t.f69496b.f69560i;
        if (r100 == null) goto L11;
        if (r100 == null) goto L12;
        if (r100.intValue() == 0) goto L11;
    L12:
        return this.f69609t.f69496b.f69560i.intValue();
    L11:
        return s1.f(481.0f);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r100 = (com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b) this.f69597h.getValue();
        if (r100 == null) goto L6;
        r100.clearData();
        return;
    }

    public CommonOrderSongDialog(com.bytedance.android.live.ktv.common.karaokestation.model.a r100) {
        Intrinsics.checkNotNullParameter(r100, "commonOrderSongConfig");
        this.f69609t = r100;
        this.f69593d = new ArrayList();
        this.f69594e = LazyKt.lazy(new CommonOrderSongDialog$firstLevelTabPagerAdapter$2(this));
        this.f69595f = LazyKt.lazy(new CommonOrderSongDialog$firstLevelTabViewPagerListener$2(this));
        this.f69596g = LazyKt.lazy(CommonOrderSongDialog$firstLevelTabSelectedListener$2.INSTANCE);
        this.f69597h = LazyKt.lazy(new CommonOrderSongDialog$commonOrderSongViewModel$2(this));
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        u r102 = this.f69609t.f69496b;
        if (r102.f69561j == false) goto L7;
        Function1<FrameLayout, Unit> r103 = r102.f69562k;
        if (r103 == null) goto L7;
        Unit r104 = r103.invoke(this.f69599j);
    L7:
        ViewPager r105 = this.f69602m;
        if (r105 == null) goto L10;
        r105.addOnPageChangeListener((CommonOrderSongDialog$firstLevelTabViewPagerListener$2.AnonymousClass1) this.f69595f.getValue());
    L10:
        TabLayout r106 = this.f69603n;
        if (r106 == null) goto L13;
        r106.addOnTabSelectedListener((CommonOrderSongDialog$firstLevelTabSelectedListener$2.a) this.f69596g.getValue());
    L13:
        ViewPager r107 = this.f69602m;
        if (r107 == null) goto L16;
        r107.setOffscreenPageLimit(((ArrayList) this.f69593d).size());
    L16:
        ViewPager r108 = this.f69602m;
        if (r108 == null) goto L19;
        r108.setAdapter((KtvCommonPagerAdapter) this.f69594e.getValue());
    L19:
        this.f69609t.f69496b.f69554c.invoke();
        this.f69609t.f69496b.f69555d.invoke();
        TabLayout r109 = this.f69603n;
        if (r109 == null) goto L22;
        r109.setupWithViewPager(this.f69602m);
    L22:
        TabLayout r110 = this.f69603n;
        if (r110 == null) goto L25;
        r110.removeAllTabs();
    L25:
        Iterator r111 = ((ArrayList) this.f69593d).iterator();
    L27:
        if (r111.hasNext() == false) goto L29;
        this.f69609t.f69495a.f69489b.invoke(((com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a) r111.next()).aK(), this.f69603n, getContext());
        goto L27
    L29:
        Function3<View, TabLayout, List<com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a>, Unit> r112 = this.f69609t.f69496b.f69553b;
        if (r112 == null) goto L32;
        Unit r113 = r112.invoke(this.f69598i, this.f69603n, this.f69593d);
    L32:
        this.f69609t.f69496b.f69558g.invoke(this.f69607r, this.f69608s, getActivity(), this.f69593d, this.f69603n);
        this.f69609t.f69496b.f69552a.invoke();
        Function3<TabLayout, FrameLayout, FrameLayout, Unit> r114 = this.f69609t.f69496b.f69563l;
        if (r114 == null) goto L35;
        Unit r115 = r114.invoke(this.f69603n, this.f69605p, this.f69599j);
    L35:
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r116 = (com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b) this.f69597h.getValue();
        TabLayout.Tab r117 = null;
        if (r116 == null) goto L40;
        Pair<Integer, UpdateTabType> r118 = r116.getSelectedFirstLevelTabValue();
        if (r118 == null) goto L40;
        Integer r119 = r118.getFirst();
    L41:
        Iterator r120 = ((ArrayList) this.f69593d).iterator();
        int r121 = 0;
    L43:
        if (r120.hasNext() == false) goto L54;
        int r122 = ((com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a) r120.next()).VL().getValue();
        if (r119 != null) goto L48;
    L50:
        boolean r123 = false;
    L51:
        if (r123 == true) goto L55;
        r121 = r121 + 1;
    L55:
        ViewPager r124 = this.f69602m;
        if (r124 == null) goto L58;
        r124.setCurrentItem(r121, false);
    L58:
        if (r121 != 0) goto L63;
        CommonOrderSongDialog$firstLevelTabSelectedListener$2.a r125 = (CommonOrderSongDialog$firstLevelTabSelectedListener$2.a) this.f69596g.getValue();
        TabLayout r126 = this.f69603n;
        if (r126 == null) goto L62;
        r117 = r126.getTabAt(r121);
    L62:
        r125.onTabSelected(r117);
        ((CommonOrderSongDialog$firstLevelTabViewPagerListener$2.AnonymousClass1) this.f69595f.getValue()).onPageSelected(0);
    L63:
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r127 = (com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b) this.f69597h.getValue();
        if (r127 == null) goto L70;
        r127.observeSelectedFirstLevelTabValueChange(this, new b(this));
        return;
    L70:
        return;
    L48:
        if (r122 != r119.intValue()) goto L50;
        r123 = true;
        goto L51
    L54:
        r121 = -1;
    L40:
        r119 = null;
        goto L41
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Integer r103 = this.f69609t.f69496b.f69559h;
        if (r103 != null) goto L5;
    L8:
        int r104 = R.layout.ttlive_ktv_common_order_song_dialog;
    L9:
        View r105 = r100.inflate(r104, r101, false);
        this.f69598i = r105;
        if (r105 == null) goto L12;
        FrameLayout r106 = (FrameLayout) r105.findViewById(R.id.ktv_control_bar_container);
    L13:
        this.f69599j = r106;
        View r107 = this.f69598i;
        if (r107 == null) goto L16;
        LinearLayout r108 = (LinearLayout) r107.findViewById(R.id.main_content);
    L17:
        this.f69600k = r108;
        View r109 = this.f69598i;
        if (r109 == null) goto L20;
        TabLayout r110 = (TabLayout) r109.findViewById(R.id.first_level_tab_layout);
    L21:
        this.f69603n = r110;
        View r111 = this.f69598i;
        if (r111 == null) goto L24;
        FrameLayout r112 = (FrameLayout) r111.findViewById(R.id.top_area);
    L25:
        this.f69604o = r112;
        View r113 = this.f69598i;
        if (r113 == null) goto L28;
        FrameLayout r114 = (FrameLayout) r113.findViewById(R.id.operate_area);
    L29:
        this.f69605p = r114;
        View r115 = this.f69598i;
        if (r115 == null) goto L32;
        ImageView r116 = (ImageView) r115.findViewById(R.id.back_iv);
    L33:
        this.f69606q = r116;
        if (this.f69609t.f69496b.f69564m.invoke().booleanValue() != true) goto L38;
        ImageView r117 = this.f69606q;
        if (r117 == null) goto L41;
        r117.setVisibility(0);
    L41:
        ImageView r118 = this.f69606q;
        if (r118 == null) goto L44;
        r118.setOnClickListener(new w0(new CommonOrderSongDialog$initView$1(this), 500));
    L44:
        View r119 = this.f69598i;
        if (r119 == null) goto L47;
        View r120 = r119.findViewById(R.id.diver);
    L48:
        this.f69601l = r120;
        if (this.f69609t.f69496b.f69565n.invoke().booleanValue() != true) goto L53;
        View r121 = this.f69601l;
        if (r121 == null) goto L56;
        r121.setVisibility(0);
    L56:
        View r122 = this.f69598i;
        if (r122 == null) goto L59;
        HSImageView r123 = (HSImageView) r122.findViewById(R.id.business_layout);
    L60:
        this.f69607r = r123;
        View r124 = this.f69598i;
        if (r124 == null) goto L63;
        ViewPager r125 = (ViewPager) r124.findViewById(R.id.first_level_tab_viewpager);
    L64:
        this.f69602m = r125;
        View r126 = this.f69601l;
        if (r126 == null) goto L67;
        r126.setBackgroundColor(ColorProtector.parseColor("#F2F2F2"));
        r126.setAlpha(1.0f);
    L67:
        View r127 = this.f69598i;
        if (r127 == null) goto L73;
        ViewGroup.LayoutParams r128 = r127.getLayoutParams();
        if (r128 != null) goto L72;
        r128 = new ViewGroup.LayoutParams(-1, S90());
    L72:
        r128.height = S90();
        Unit r129 = Unit.INSTANCE;
        r127.setLayoutParams(r128);
    L73:
        LinearLayout r130 = this.f69600k;
        if (r130 == null) goto L76;
        KtvOrderSongThemeManager.c(r130, 7);
    L76:
        TabLayout r131 = this.f69603n;
        if (r131 == null) goto L81;
        r131.setTabMode(1);
        r131.setTabGravity(0);
        r131.setTabIndicatorFullWidth(false);
        r131.setSelectedTabIndicatorColor(KtvOrderSongThemeManager.a(2));
        KtvOrderSongThemeManager.c(r131, 7);
        r131.setTabTextColors(ColorProtector.parseColor("#96989C"), ColorProtector.parseColor(CustomHeaderConfig.COLOR_DARK));
        r131.setTabRippleColor(null);
        if (this.f69609t.f69496b.f69566o.invoke().booleanValue() == true) goto L81;
        r131.setSelectedTabIndicatorHeight(0);
    L81:
        this.f69609t.f69495a.f69490c.invoke();
        ((ArrayList) this.f69593d).clear();
        this.f69609t.f69495a.f69491d.invoke(this.f69593d);
        KtvCommonPagerAdapter r132 = (KtvCommonPagerAdapter) this.f69594e.getValue();
        if (r132 == null) goto L85;
        ArrayList r133 = new ArrayList();
        r133.addAll(this.f69593d);
        Unit r134 = Unit.INSTANCE;
        r132.f(r133);
    L85:
        return this.f69598i;
    L63:
        r125 = null;
        goto L64
    L59:
        r123 = null;
        goto L60
    L53:
        View r135 = this.f69601l;
        if (r135 == null) goto L56;
        r135.setVisibility(8);
        goto L56
    L47:
        r120 = null;
        goto L48
    L38:
        ImageView r136 = this.f69606q;
        if (r136 == null) goto L41;
        r136.setVisibility(8);
        goto L41
    L32:
        r116 = null;
        goto L33
    L28:
        r114 = null;
        goto L29
    L24:
        r112 = null;
        goto L25
    L20:
        r110 = null;
        goto L21
    L16:
        r108 = null;
        goto L17
    L12:
        r106 = null;
        goto L13
    L5:
        if (r103.intValue() == 0) goto L8;
        r104 = this.f69609t.f69496b.f69559h.intValue();
        goto L9
    }
}
