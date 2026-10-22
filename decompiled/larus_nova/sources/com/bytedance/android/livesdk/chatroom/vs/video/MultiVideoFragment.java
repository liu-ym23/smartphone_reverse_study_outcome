package com.bytedance.android.livesdk.chatroom.vs.video;

import android.animation.ObjectAnimator;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.android.live.core.tetris.widgets.RecyclableWidgetManager;
import com.bytedance.android.live.core.tetris.widgets.h;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.x1;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.livesdk.chatroom.vs_base.base.view.ReplayVideoPlayerView;
import com.bytedance.android.livesdk.t8;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.paid.PaidPrivilegeItem;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.videoshop.context.VideoContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import jm1.g;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import nm1.l;
import pm1.f;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vs/video/MultiVideoFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "Lcom/bytedance/android/livesdk/chatroom/vs/video/b;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MultiVideoFragment extends BaseFragment implements b {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final /* synthetic */ int f117762z = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PaidPrivilegeItem f117763d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RecyclableWidgetManager f117764e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map<Widget, Integer> f117765f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Map<Widget, Integer> f117766g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f117767h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LinearLayout f117768i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public FrameLayout f117769j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public FrameLayout f117770k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ConstraintLayout f117771l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f117772m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f117773n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f117774o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f117775p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public DataCenter f117776q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f117777r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f117778s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f117779t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f117780u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f117781v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f117782w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public g f117783x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final VideoPlayerWidget f117784y;

    public static final class a {
    }

    static {
    }

    public final void S90() {
        ViewGroup.LayoutParams r100 = null;
        if (this.f117777r == false) goto L19;
        ConstraintLayout r101 = this.f117771l;
        if (r101 == null) goto L13;
        r101.setLayoutParams(new FrameLayout.LayoutParams(-1, s1.f(36.0f)));
        a1.j(r101, 80);
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == false) goto L10;
        r100 = r102;
    L10:
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r100;
        if (r103 == null) goto L13;
        r103.bottomMargin = s1.f(46.0f);
    L13:
        FrameLayout r104 = this.f117770k;
        if (r104 == null) goto L16;
        r104.setLayoutParams(new FrameLayout.LayoutParams(-1, s1.f(90.0f)));
        a1.j(r104, 80);
    L16:
        View r105 = this.f117774o;
        if (r105 == null) goto L59;
        UtilityKotlinExtentionsKt.t(r105);
    L59:
        ObjectAnimator r106 = (ObjectAnimator) this.f117781v.getValue();
        if (r106 == null) goto L62;
        r106.cancel();
    L62:
        ObjectAnimator r107 = (ObjectAnimator) this.f117782w.getValue();
        if (r107 == null) goto L66;
        r107.start();
        return;
    L66:
        return;
    L19:
        DataCenter r108 = this.f117776q;
        if (r108 != null) goto L22;
    L44:
        ConstraintLayout r109 = this.f117771l;
        if (r109 == null) goto L53;
        r109.setLayoutParams(new FrameLayout.LayoutParams(U90(), s1.f(36.0f)));
        a1.j(r109, 81);
        ViewGroup.LayoutParams r110 = r109.getLayoutParams();
        if ((r110 instanceof ViewGroup.MarginLayoutParams) == false) goto L50;
        r100 = r110;
    L50:
        ViewGroup.MarginLayoutParams r111 = (ViewGroup.MarginLayoutParams) r100;
        if (r111 == null) goto L53;
        r111.bottomMargin = s1.f(12.0f);
    L53:
        FrameLayout r112 = this.f117770k;
        if (r112 == null) goto L56;
        r112.setLayoutParams(new FrameLayout.LayoutParams(U90(), s1.f(90.0f)));
        a1.j(r112, 81);
    L56:
        View r113 = this.f117774o;
        if (r113 == null) goto L59;
        UtilityKotlinExtentionsKt.w(r113);
        goto L59
    L22:
        if (z.m(r108, true) != true) goto L44;
        ConstraintLayout r114 = this.f117771l;
        if (r114 == null) goto L32;
        r114.setLayoutParams(new FrameLayout.LayoutParams(U90(), s1.f(36.0f)));
        a1.j(r114, 80);
        ViewGroup.LayoutParams r115 = r114.getLayoutParams();
        if ((r115 instanceof ViewGroup.MarginLayoutParams) == true) goto L29;
        r115 = null;
    L29:
        ViewGroup.MarginLayoutParams r116 = (ViewGroup.MarginLayoutParams) r115;
        if (r116 == null) goto L32;
        r116.bottomMargin = s1.f(12.0f);
    L32:
        FrameLayout r117 = this.f117770k;
        if (r117 == null) goto L41;
        r117.setLayoutParams(new FrameLayout.LayoutParams(U90(), s1.f(90.0f)));
        a1.j(r117, 17);
        ViewGroup.LayoutParams r118 = r117.getLayoutParams();
        if ((r118 instanceof ViewGroup.MarginLayoutParams) == false) goto L38;
        r100 = r118;
    L38:
        ViewGroup.MarginLayoutParams r119 = (ViewGroup.MarginLayoutParams) r100;
        if (r119 == null) goto L41;
        r119.topMargin = (this.f117778s - s1.f(90.0f)) / 2;
    L41:
        View r120 = this.f117774o;
        if (r120 == null) goto L59;
        UtilityKotlinExtentionsKt.w(r120);
        goto L59
    }

    public final void T90() {
        DataCenter r100 = this.f117776q;
        ViewGroup.LayoutParams r101 = null;
        if (r100 != null) goto L5;
    L20:
        LinearLayout r102 = this.f117768i;
        if (r102 == null) goto L29;
        r102.setLayoutParams(new FrameLayout.LayoutParams(-1, s1.f(24.0f)));
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        if ((r103 instanceof ViewGroup.MarginLayoutParams) == false) goto L26;
        r101 = r103;
    L26:
        ViewGroup.MarginLayoutParams r104 = (ViewGroup.MarginLayoutParams) r101;
        if (r104 == null) goto L29;
        r104.topMargin = s1.f(44.0f);
        r102.setPadding(s1.f(16.0f), 0, s1.f(50.0f), 0);
    L29:
        FrameLayout r105 = this.f117769j;
        if (r105 == null) goto L35;
        r105.setLayoutParams(new FrameLayout.LayoutParams(-1, s1.f(90.0f)));
        return;
    L35:
        return;
    L5:
        if (z.m(r100, true) == true) goto L20;
        LinearLayout r106 = this.f117768i;
        if (r106 == null) goto L17;
        r106.setLayoutParams(new FrameLayout.LayoutParams(U90(), s1.f(24.0f)));
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
        if ((r107 instanceof ViewGroup.MarginLayoutParams) == false) goto L13;
        r101 = r107;
    L13:
        ViewGroup.MarginLayoutParams r108 = (ViewGroup.MarginLayoutParams) r101;
        if (r108 == null) goto L16;
        r108.topMargin = s1.f(10.0f);
    L16:
        r106.setPadding(s1.f(10.0f), 0, s1.f(10.0f), 0);
    L17:
        FrameLayout r109 = this.f117769j;
        if (r109 == null) goto L33;
        r109.setLayoutParams(new FrameLayout.LayoutParams(U90(), s1.f(90.0f)));
        a1.j(r109, 49);
        return;
    }

    public final int U90() {
        DataCenter r100 = this.f117776q;
        if (r100 == null) goto L9;
        if (z.m(r100, true) == true) goto L9;
        return RangesKt.coerceAtMost((this.f117779t * 16) / 9, this.f117780u);
    L9:
        return this.f117779t;
    }

    public final void V90() {
        Iterator<Map.Entry<Widget, Integer>> r100 = this.f117765f.entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        Map.Entry<Widget, Integer> r101 = r100.next();
        RecyclableWidgetManager r102 = this.f117764e;
        if (r102 == null) goto L4;
        r102.unload(r101.getKey());
        goto L4
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs.video.b
    public final List<View> vf() {
        ArrayList r100 = new ArrayList();
        View r101 = this.f117767h;
        if (r101 == null) goto L7;
        View r102 = r101.findViewById(R.id.video_play_control_container);
        if (r102 == null) goto L7;
        r100.add(r102);
    L7:
        View r103 = this.f117767h;
        if (r103 == null) goto L12;
        View r104 = r103.findViewById(R.id.progress_area_container);
        if (r104 == null) goto L12;
        r100.add(r104);
    L12:
        View r105 = this.f117767h;
        if (r105 == null) goto L17;
        View r106 = r105.findViewById(R.id.enter_full_icon);
        if (r106 == null) goto L17;
        r100.add(r106);
    L17:
        View r107 = this.f117767h;
        if (r107 == null) goto L22;
        View r108 = r107.findViewById(R.id.video_bottom_shadow);
        if (r108 == null) goto L22;
        r100.add(r108);
    L22:
        View r109 = this.f117767h;
        if (r109 == null) goto L27;
        View r110 = r109.findViewById(R.id.video_top_shadow);
        if (r110 == null) goto L27;
        r100.add(r110);
    L27:
        LinearLayout r111 = this.f117768i;
        if (r111 == null) goto L30;
        r100.add(r111);
    L30:
        return r100;
    }

    public MultiVideoFragment() {
        this.f117765f = new LinkedHashMap();
        this.f117766g = new LinkedHashMap();
        this.f117779t = x1.h();
        this.f117780u = x1.g();
        this.f117781v = LazyKt.lazy(new MultiVideoFragment$hideAnimator$2(this));
        this.f117782w = LazyKt.lazy(new MultiVideoFragment$showAnimator$2(this));
        l r100 = f.j();
        if (r100 == null) goto L5;
        ReplayVideoPlayerView r101 = r100.c();
    L6:
        this.f117783x = r101;
        this.f117784y = new VideoPlayerWidget(r101, this);
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final void W90() {
        V90();
        Iterator<Map.Entry<Widget, Integer>> r100 = this.f117765f.entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L15;
        Map.Entry<Widget, Integer> r101 = r100.next();
        Widget r102 = r101.getKey();
        Integer r103 = r101.getValue();
        if (r103 == null) goto L12;
        int r104 = r103.intValue();
        RecyclableWidgetManager r105 = this.f117764e;
        if (r105 == null) goto L10;
        WidgetManager r106 = r105.load(r104, r102);
    L11:
        if (r106 != null) goto L4;
    L10:
        r106 = null;
    L12:
        RecyclableWidgetManager r107 = this.f117764e;
        if (r107 == null) goto L4;
        r107.load(r102);
        goto L4
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs.video.b
    public final SharedPreferences oS() {
        return jc1.a.b().getSharedPreferences("simple_video_progress_history", 0);
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        V90();
        Iterator<Map.Entry<Widget, Integer>> r100 = this.f117766g.entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        Map.Entry<Widget, Integer> r101 = r100.next();
        RecyclableWidgetManager r102 = this.f117764e;
        if (r102 == null) goto L4;
        r102.unload(r101.getKey());
        goto L4
    L8:
        g r103 = this.f117783x;
        if (r103 == null) goto L11;
        r103.release();
    L11:
        this.f117783x = null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs.video.b
    public final void mn(int r100) {
        V90();
        Window r101 = null;
        if (r100 != 0) goto L8;
        FragmentActivity r102 = getActivity();
        if (r102 == null) goto L7;
        r101 = r102.getWindow();
    L7:
        t8.d(r101);
    L12:
        FragmentActivity r103 = getActivity();
        if (r103 == null) goto L16;
        r103.setRequestedOrientation(r100);
        return;
    L16:
        return;
    L8:
        FragmentActivity r104 = getActivity();
        if (r104 == null) goto L11;
        r101 = r104.getWindow();
    L11:
        t8.b(r101);
        t8.e(getActivity());
        goto L12
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
        super.onConfigurationChanged(r100);
        boolean r101 = true;
        if (r100.orientation != 1) goto L7;
        VideoContext r102 = VideoContext.n0(getContext());
        if (r102 == null) goto L10;
        r102.l0();
    L10:
        DataCenter r103 = this.f117776q;
        if (r103 != null) goto L13;
    L17:
        g r104 = this.f117783x;
        if (r104 != null) goto L20;
    L24:
        VideoPlayerWidget r105 = this.f117784y;
        r105.Aq(r105.f117808g, r105.f117809h);
        ((ObjectAnimator) this.f117781v.getValue()).start();
        T90();
        W90();
        ILinkServiceExternal r106 = (ILinkServiceExternal) k.f(ILinkServiceExternal.class);
        if (r106 != null) goto L27;
        return;
    L27:
        if (r100.orientation == 1) goto L30;
        r101 = false;
    L30:
        r106.updatePortrait(r101);
        return;
    L20:
        if (r104.isPlaying() != true) goto L24;
        DataCenter r107 = this.f117776q;
        if (r107 == null) goto L24;
        r107.put("video_start_play_ts", Long.valueOf(System.currentTimeMillis()));
        goto L24
    L13:
        if (r100.orientation != 1) goto L15;
        boolean r108 = true;
    L16:
        r103.put("data_is_portrait", Boolean.valueOf(r108));
        goto L17
    L15:
        r108 = false;
        goto L16
    L7:
        VideoContext r109 = VideoContext.n0(getContext());
        if (r109 == null) goto L10;
        r109.k0();
        goto L10
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        PaidPrivilegeItem r101 = this.f117763d;
        if (r101 != null) goto L5;
    L6:
        SharedPreferences.Editor r102 = oS().edit();
        if (r102 == null) goto L12;
        SharedPreferences.Editor r103 = r102.clear();
        if (r103 == null) goto L12;
        r103.apply();
    L12:
        if (this.f117776q != null) goto L14;
        this.f117776q = DataCenter.create(ViewModelProviders.of(this), this);
    L14:
        DataCenter r104 = this.f117776q;
        if (r104 == null) goto L17;
        r104.put("data_is_portrait", Boolean.valueOf(!e5.l()));
    L17:
        DataCenter r105 = this.f117776q;
        if (r105 == null) goto L20;
        r105.put("paid_privilege_item", this.f117763d);
    L20:
        ILinkServiceExternal r106 = (ILinkServiceExternal) k.f(ILinkServiceExternal.class);
        if (r106 == null) goto L24;
        r106.updatePortrait(true ^ e5.l());
        return;
    L24:
        return;
    L5:
        if (r101.getNeedHistoryStart() == true) goto L12;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs.video.b
    public final void Aj(int r100, int r101) {
        this.f117778s = r101;
        if (r100 > r101) goto L5;
        boolean r102 = true;
    L7:
        if (this.f117777r == r102) goto L22;
        this.f117777r = r102;
        if (r102 == false) goto L15;
        DataCenter r103 = this.f117776q;
        if (r103 == null) goto L15;
        if (z.m(r103, true) == true) goto L15;
        mn(1);
    L15:
        ObjectAnimator r104 = (ObjectAnimator) this.f117782w.getValue();
        if (r104 == null) goto L18;
        r104.cancel();
    L18:
        ObjectAnimator r105 = (ObjectAnimator) this.f117781v.getValue();
        if (r105 == null) goto L21;
        r105.start();
    L21:
        T90();
    L27:
        this.f117777r = r102;
        return;
    L22:
        FrameLayout r106 = this.f117770k;
        if (r106 == null) goto L27;
        if (r106.getVisibility() != 8) goto L27;
        S90();
        goto L27
    L5:
        r102 = false;
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.ttlive_multi_video_fragment_layout, r101, false);
        this.f117767h = r103;
        if (r103 == null) goto L5;
        FrameLayout r104 = (FrameLayout) r103.findViewById(R.id.top_area_container);
    L6:
        this.f117769j = r104;
        if (r103 == null) goto L9;
        LinearLayout r105 = (LinearLayout) r103.findViewById(R.id.top_bar_container);
    L10:
        this.f117768i = r105;
        if (r103 == null) goto L13;
        FrameLayout r106 = (FrameLayout) r103.findViewById(R.id.video_bottom_area_group);
    L14:
        this.f117770k = r106;
        if (r103 == null) goto L17;
        ConstraintLayout r107 = (ConstraintLayout) r103.findViewById(R.id.video_bottom_progress_group);
    L18:
        this.f117771l = r107;
        if (r103 == null) goto L21;
        View r108 = r103.findViewById(R.id.multi_video_container);
    L22:
        this.f117772m = r108;
        if (r103 == null) goto L25;
        View r109 = r103.findViewById(R.id.progress_area_container);
    L26:
        this.f117773n = r109;
        if (r103 == null) goto L29;
        View r110 = r103.findViewById(R.id.exit_multi_video);
    L30:
        this.f117775p = r110;
        if (r103 == null) goto L33;
        View r111 = r103.findViewById(R.id.enter_full_container);
    L34:
        this.f117774o = r111;
        View r112 = this.f117775p;
        if (r112 == null) goto L37;
        r112.setOnClickListener(new c(this));
    L37:
        RecyclableWidgetManager r113 = RecyclableWidgetManager.ga0(this, this.f117767h);
        this.f117764e = r113;
        r113.f65947d = h.c();
        RecyclableWidgetManager r114 = this.f117764e;
        if (r114 == null) goto L40;
        r114.setDataCenter(this.f117776q);
    L40:
        this.f117765f = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(new VideoTitleWidget(), Integer.valueOf(R.id.multi_video_title_container)), TuplesKt.to(new VideoProgressAreaWidget(), Integer.valueOf(R.id.progress_area_container)), TuplesKt.to(new VideoPlayControlWidget(), Integer.valueOf(R.id.video_play_control_container)), TuplesKt.to(new EnterFullScreenWidget(this), Integer.valueOf(R.id.enter_full_container)), TuplesKt.to(new VideoPlayControlVisibilityWidget(this), Integer.valueOf(R.id.play_control_visibility_container))});
        Map<Widget, Integer> r115 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(this.f117784y, Integer.valueOf(R.id.multi_video_container))});
        this.f117766g = r115;
        Iterator<Map.Entry<Widget, Integer>> r116 = r115.entrySet().iterator();
    L42:
        if (r116.hasNext() == false) goto L53;
        Map.Entry<Widget, Integer> r117 = r116.next();
        Widget r118 = r117.getKey();
        Integer r119 = r117.getValue();
        if (r119 == null) goto L50;
        int r120 = r119.intValue();
        RecyclableWidgetManager r121 = this.f117764e;
        if (r121 == null) goto L48;
        WidgetManager r122 = r121.load(r120, r118);
    L49:
        if (r122 != null) goto L42;
    L48:
        r122 = null;
    L50:
        RecyclableWidgetManager r123 = this.f117764e;
        if (r123 == null) goto L42;
        r123.load(r118);
        goto L42
    L53:
        W90();
        return this.f117767h;
    L33:
        r111 = null;
        goto L34
    L29:
        r110 = null;
        goto L30
    L25:
        r109 = null;
        goto L26
    L21:
        r108 = null;
        goto L22
    L17:
        r107 = null;
        goto L18
    L13:
        r106 = null;
        goto L14
    L9:
        r105 = null;
        goto L10
    L5:
        r104 = null;
        goto L6
    }
}
