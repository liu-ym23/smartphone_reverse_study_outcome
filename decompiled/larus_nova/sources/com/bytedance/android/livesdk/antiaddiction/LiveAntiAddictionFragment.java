package com.bytedance.android.livesdk.antiaddiction;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livesdk.antiaddiction.view.VideoPinchViewContainer;
import com.bytedance.android.livesdk.explore.view.AbsBaseFragment;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.ILiveOntologyInfoManager;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.lighten.loader.SmartImageView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.videoshop.context.VideoContext;
import com.ss.android.videoshop.mediaview.LayerHostMediaLayout;
import com.ss.android.videoshop.mediaview.SimpleMediaView;
import com.ss.ttvideoengine.utils.Error;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nic.l;
import nic.m;
import nic.p;
import oic.f;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/antiaddiction/LiveAntiAddictionFragment;", "Lcom/bytedance/android/livesdk/explore/view/AbsBaseFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveAntiAddictionFragment extends AbsBaseFragment {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ int f103662x = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f103663f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public FeedItem f103664g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ae1.c f103665h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public SimpleMediaView f103666i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public VideoPinchViewContainer f103667j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f103668k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public SmartImageView f103669l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ViewGroup f103670m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f103671n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public com.bytedance.android.livesdk.antiaddiction.view.a f103672o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f103673p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f103674q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f103675r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f103676s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f103677t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final LiveAntiAddictionManager f103678u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final b f103679v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final c f103680w;

    public static final class a {
        public static void a(String r100, ae1.c r101) {
            Intrinsics.checkNotNullParameter(r100, "action");
            LinkedHashMap r102 = new LinkedHashMap();
            LiveAntiAddictionManager.Companion.getClass();
            LiveAntiAddictionManager r103 = LiveAntiAddictionManager.a.a();
            String r104 = "";
            if (r103 == null) goto L6;
            String r105 = r103.getEnterFromMerge();
            if (r105 == null) goto L6;
        L7:
            r102.put("enter_from_merge", r105);
            LiveAntiAddictionManager r106 = LiveAntiAddictionManager.a.a();
            if (r106 == null) goto L11;
            String r107 = r106.getEnterMethod();
            if (r107 == null) goto L11;
        L12:
            r102.put("enter_method", r107);
            LiveAntiAddictionManager r108 = LiveAntiAddictionManager.a.a();
            if (r108 == null) goto L16;
            String r109 = r108.getActionType();
            if (r109 == null) goto L16;
        L17:
            r102.put("action_type", r109);
            if (r101 == null) goto L20;
            Integer r110 = Integer.valueOf(r101.f3067c);
        L21:
            if (r110 != null) goto L24;
        L26:
            if (r110 != null) goto L29;
        L31:
            if (r110 != null) goto L34;
        L36:
            if (r110 != null) goto L39;
        L41:
            r102.put("notice_type", r104);
            r102.put("action", r100);
            u.l().sendLog("livesdk_anti_addiction_notice_click", r102, new Object[0]);
            return;
        L39:
            if (r110.intValue() != 5) goto L41;
            r104 = "sleep";
            goto L41
        L34:
            if (r110.intValue() != 4) goto L36;
            r104 = "rest";
            goto L41
        L29:
            if (r110.intValue() != 3) goto L31;
            r104 = "stop";
            goto L41
        L24:
            if (r110.intValue() != 2) goto L26;
            r104 = "auto";
            goto L41
        L20:
            r110 = null;
        L16:
            r109 = "";
        L11:
            r107 = "";
        L6:
            r105 = "";
            goto L7
        }
    }

    public static final class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveAntiAddictionFragment f103681a;

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            super.handleMessage(r100);
            this.f103681a.f103675r = false;
        }

        public b(LiveAntiAddictionFragment r100, Looper r101) {
            this.f103681a = r100;
            super(r101);
        }
    }

    public static final class c extends l.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveAntiAddictionFragment f103682a;

        public c(LiveAntiAddictionFragment r100) {
            this.f103682a = r100;
        }

        @Override // nic.l.a, nic.h
        public final void B(p r100, tic.a r101) {
            LiveAntiAddictionFragment r102 = this.f103682a;
            int r103 = LiveAntiAddictionFragment.f103662x;
            r102.getClass();
        }

        @Override // nic.l.a, nic.h
        public final void v(f r100, tic.a r101, Error r102) {
            f2.c("网络不给力", 0);
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragment
    public final void forceSmoothExit() {
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragment
    public final LiveMode getStreamType() {
        return null;
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragment
    public final void onSlide() {
    }

    @Override // com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragment
    public final as0.a roomPlayerContext() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.explore.view.AbsBaseFragment, com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragment
    public final boolean onBackPressed() {
        if (this.f103663f == 3) goto L5;
        return false;
    L5:
        if (this.f103675r == true) goto L7;
        f2.j("再按一次退出", 17);
        this.f103675r = true;
        this.f103679v.sendEmptyMessageDelayed(0, 2000);
    L8:
        return true;
    L7:
        ((IHostBusiness) k.n(IHostBusiness.class)).finishAllActivities();
        goto L8
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        ALogger.d("LiveAntiAddictionFragment", "LiveAntiAddictionFragment onDestroyView");
        super.onDestroyView();
        LiveAntiAddictionManager r100 = this.f103678u;
        if (r100 != null) goto L5;
    L43:
        SimpleMediaView r101 = this.f103666i;
        if (r101 == null) goto L46;
        r101.m();
    L46:
        VideoContext r102 = VideoContext.n0(getContext());
        if (r102 == null) goto L49;
        r102.K0(this.f103680w);
    L49:
        VideoContext r103 = VideoContext.n0(getContext());
        if (r103 == null) goto L54;
        Lifecycle r104 = getLifecycle();
        LifecycleObserver r105 = (LifecycleObserver) ((ConcurrentHashMap) r103.f455955i).remove(r104);
        if (r105 == null) goto L54;
        r104.removeObserver(r105);
    L54:
        VideoContext r106 = VideoContext.n0(getContext());
        if (r106 == null) goto L59;
        LayerHostMediaLayout r107 = r106.f455949c;
        if (r107 == null) goto L59;
        r107.k0();
    L59:
        LiveAntiAddictionManager r108 = this.f103678u;
        if (r108 == null) goto L62;
        r108.setFragmentShowing(false);
    L62:
        LiveAntiAddictionManager r109 = this.f103678u;
        if (r109 == null) goto L66;
        r109.setViewPagerCanScroll(true);
    L66:
        if (this.f103674q == false) goto L68;
        UIUtils.setViewVisibility(this.f103673p, 0);
    L68:
        this.f103674q = false;
        VideoPinchViewContainer r110 = this.f103667j;
        if (r110 == null) goto L71;
        r110.setOnClickListener(null);
    L71:
        this.f103679v.removeCallbacksAndMessages(null);
        return;
    L5:
        if (r100.isFragmentShowing() != true) goto L43;
        int r111 = this.f103663f;
        int r112 = 2;
        if (r111 == 1) goto L12;
        if (r111 == 2) goto L12;
        if (r111 == 3) goto L11;
        r112 = 0;
        goto L12
    L11:
        r112 = 1;
    L12:
        LinkedHashMap r113 = new LinkedHashMap();
        LiveAntiAddictionManager r114 = this.f103678u;
        String r115 = "";
        if (r114 == null) goto L16;
        String r116 = r114.getEnterFromMerge();
        if (r116 == null) goto L16;
    L17:
        r113.put("enter_from_merge", r116);
        LiveAntiAddictionManager r117 = this.f103678u;
        if (r117 == null) goto L21;
        String r118 = r117.getEnterMethod();
        if (r118 == null) goto L21;
    L22:
        r113.put("enter_method", r118);
        LiveAntiAddictionManager r119 = this.f103678u;
        if (r119 == null) goto L26;
        String r120 = r119.getActionType();
        if (r120 == null) goto L26;
    L27:
        r113.put("action_type", r120);
        r113.put("addiction_notice_type", String.valueOf(r112));
        r113.put("duration", String.valueOf(this.f103677t));
        u.l().sendLog("livesdk_anti_addiction_notice_stay_time", r113, new Object[0]);
        IHostBusiness r121 = (IHostBusiness) k.n(IHostBusiness.class);
        Long r122 = Long.valueOf(this.f103677t);
        ILiveService r123 = TTLiveService.getLiveService();
        if (r123 == null) goto L32;
        ILiveOntologyInfoManager r124 = r123.getLiveOntologyRecord();
        if (r124 == null) goto L32;
        String r125 = r124.getEnterFromMerge();
    L33:
        if (r125 == null) goto L36;
        r115 = r125;
    L36:
        r121.reportAntiAddictionStayTime(r122, r115, r112, null);
        LiveAntiAddictionManager r126 = this.f103678u;
        if (r126 == null) goto L43;
        if (this.f103663f != 3) goto L41;
        boolean r127 = true;
    L42:
        r126.changeAntiAddictionStatus(false, r127);
        goto L43
    L41:
        r127 = false;
    L32:
        r125 = null;
    L26:
        r120 = "";
    L21:
        r118 = "";
    L16:
        r116 = "";
        goto L17
    }

    public LiveAntiAddictionFragment() {
        LiveAntiAddictionManager.Companion.getClass();
        this.f103678u = LiveAntiAddictionManager.a.a();
        this.f103679v = new b(this, Looper.getMainLooper());
        new GradientDrawable();
        new ArgbEvaluator();
        ColorProtector.parseColor("#00ffffff");
        ColorProtector.parseColor("#CCffffff");
        this.f103680w = new c(this);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        LiveAntiAddictionManager r100 = this.f103678u;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isFragmentShowing() != true) goto L9;
        this.f103676s = System.currentTimeMillis();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        this.f103677t += System.currentTimeMillis() - this.f103676s;
        this.f103676s = 0;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        VideoContext r101 = VideoContext.n0(getContext());
        if (r101 == null) goto L6;
        r101.C0(getLifecycle(), new m.a());
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void setUserVisibleHint(boolean r100) {
        super.setUserVisibleHint(r100);
        if (r100 == false) goto L73;
        this.f103676s = System.currentTimeMillis();
        this.f103677t = 0;
        View r101 = this.f103673p;
        if (r101 != null) goto L7;
    L9:
        LiveAntiAddictionManager r102 = this.f103678u;
        if (r102 == null) goto L12;
        r102.setFragmentShowing(true);
    L12:
        SimpleMediaView r103 = this.f103666i;
        if (r103 == null) goto L15;
        r103.k();
    L15:
        VideoPinchViewContainer r104 = this.f103667j;
        if (r104 == null) goto L18;
        r104.setOnClickListener(null);
    L18:
        SmartImageView r105 = this.f103669l;
        if (r105 == null) goto L21;
        r105.setOnClickListener(null);
    L21:
        this.f103679v.postDelayed(new ae1.b(this), 1000);
        LinkedHashMap r106 = new LinkedHashMap();
        LiveAntiAddictionManager r107 = this.f103678u;
        String r108 = "";
        if (r107 == null) goto L25;
        String r109 = r107.getEnterFromMerge();
        if (r109 == null) goto L25;
    L26:
        r106.put("enter_from_merge", r109);
        LiveAntiAddictionManager r110 = this.f103678u;
        if (r110 == null) goto L30;
        String r111 = r110.getEnterMethod();
        if (r111 == null) goto L30;
    L31:
        r106.put("enter_method", r111);
        LiveAntiAddictionManager r112 = this.f103678u;
        if (r112 == null) goto L35;
        String r113 = r112.getActionType();
        if (r113 == null) goto L35;
    L36:
        r106.put("action_type", r113);
        ae1.c r114 = this.f103665h;
        if (r114 == null) goto L39;
        Integer r115 = Integer.valueOf(r114.f3067c);
    L41:
        if (r115 != null) goto L44;
    L46:
        if (r115 != null) goto L49;
    L51:
        if (r115 != null) goto L54;
    L56:
        if (r115 != null) goto L59;
    L61:
        r106.put("notice_type", r108);
        boolean r116 = false;
        u.l().sendLog("livesdk_anti_addiction_notice_show", r106, new Object[0]);
        LiveAntiAddictionManager r117 = this.f103678u;
        if (r117 == null) goto L64;
        r117.setViewPagerCanScroll(false);
    L64:
        LiveAntiAddictionManager r118 = this.f103678u;
        if (r118 == null) goto L67;
        r118.markRemindEventShown(this.f103665h, null);
    L67:
        LiveAntiAddictionManager r119 = this.f103678u;
        if (r119 != null) goto L70;
        return;
    L70:
        if (this.f103663f != 3) goto L72;
        r116 = true;
    L72:
        r119.changeAntiAddictionStatus(true, r116);
        return;
    L59:
        if (r115.intValue() != 5) goto L61;
        r108 = "sleep";
        goto L61
    L54:
        if (r115.intValue() != 4) goto L56;
        r108 = "rest";
        goto L61
    L49:
        if (r115.intValue() != 3) goto L51;
        r108 = "stop";
        goto L61
    L44:
        if (r115.intValue() != 2) goto L46;
        r108 = "auto";
        goto L61
    L39:
        r115 = null;
    L35:
        r113 = "";
    L30:
        r111 = "";
    L25:
        r109 = "";
        goto L26
    L7:
        if (r101.getVisibility() != 0) goto L9;
        UIUtils.setViewVisibility(this.f103673p, 8);
        this.f103674q = true;
        goto L9
    L73:
        SimpleMediaView r120 = this.f103666i;
        if (r120 == null) goto L79;
        r120.j();
        return;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        View r102 = this.f103668k;
        Object r103 = null;
        if (r102 == null) goto L5;
        ViewGroup r104 = (ViewGroup) r102.findViewById(R.id.extra_container_anti_addiction);
    L6:
        this.f103670m = r104;
        if (r104 != null) goto L9;
    L10:
        ViewGroup r105 = this.f103670m;
        if (r105 == null) goto L13;
        r105.removeAllViewsInLayout();
    L13:
        ViewGroup r106 = this.f103670m;
        if (r106 == null) goto L18;
        com.bytedance.android.livesdk.antiaddiction.view.a r107 = this.f103672o;
        if (r107 == null) goto L18;
        r107.a(r106);
    L18:
        View r108 = this.f103668k;
        if (r108 == null) goto L21;
        VideoPinchViewContainer r109 = (VideoPinchViewContainer) r108.findViewById(R.id.player_view_container);
    L22:
        this.f103667j = r109;
        View r110 = this.f103668k;
        if (r110 == null) goto L25;
        SmartImageView r111 = (SmartImageView) r110.findViewById(R.id.cover_anti_addiction);
    L26:
        this.f103669l = r111;
        View r112 = this.f103668k;
        if (r112 == null) goto L29;
        SmartImageView r113 = (SmartImageView) r112.findViewById(R.id.cover_anti_addiction_no_network);
    L29:
        View r114 = this.f103668k;
        if (r114 == null) goto L32;
        SmartImageView r115 = (SmartImageView) r114.findViewById(R.id.cover_blur_anti_addiction);
    L32:
        View r116 = this.f103668k;
        if (r116 == null) goto L35;
        View r117 = r116.findViewById(R.id.anti_addiction_player_placeholder);
    L36:
        this.f103671n = r117;
        View r118 = this.f103668k;
        if (r118 == null) goto L41;
        ViewParent r119 = r118.getParent();
        if (r119 == null) goto L41;
        r103 = r119.getParent();
    L41:
        if (r103 == null) goto L59;
        this.f103673p = ((View) r103).findViewById(R.id.back_to_pre_room_widget_v2);
        VideoPinchViewContainer r120 = this.f103667j;
        if (r120 == null) goto L45;
        r120.addView(this.f103666i);
    L45:
        VideoPinchViewContainer r121 = this.f103667j;
        if (r121 == null) goto L48;
        r121.removeView(this.f103669l);
    L48:
        VideoPinchViewContainer r122 = this.f103667j;
        if (r122 == null) goto L51;
        r122.addView(this.f103669l, new FrameLayout.LayoutParams(-1, -1));
    L51:
        SmartImageView r123 = this.f103669l;
        if (r123 == null) goto L54;
        r123.setVisibility(0);
    L54:
        com.bytedance.android.livesdk.antiaddiction.view.a r124 = this.f103672o;
        if (r124 == null) goto L60;
        r124.onViewCreated();
        return;
    L60:
        return;
    L59:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L35:
        r117 = null;
        goto L36
    L25:
        r111 = null;
        goto L26
    L21:
        r109 = null;
        goto L22
    L9:
        if (r104.getChildCount() == 0) goto L13;
    L5:
        r104 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        com.bytedance.android.livesdk.antiaddiction.view.a r103 = null;
        if (getContext() != null) goto L5;
        return null;
    L5:
        UIUtils.dip2Px(getContext(), 1.0f);
        UIUtils.dip2Px(getContext(), 6.0f);
        UIUtils.dip2Px(getContext(), 200.0f);
        UIUtils.dip2Px(getContext(), 270.0f);
        LiveAntiAddictionManager r104 = this.f103678u;
        if (r104 == null) goto L8;
        ae1.c r105 = r104.getLastEvent();
    L9:
        this.f103665h = r105;
        LiveAntiAddictionManager r106 = this.f103678u;
        if (r106 == null) goto L12;
        r106.getLastStyle();
    L12:
        ae1.c r107 = this.f103665h;
        if (r107 == null) goto L27;
        int r108 = r107.f3067c;
        if (r108 != 2) goto L17;
    L24:
        this.f103663f = 2;
        Context r109 = getContext();
        Intrinsics.checkNotNull(r109);
        com.bytedance.android.livesdk.antiaddiction.view.a r110 = new com.bytedance.android.livesdk.antiaddiction.view.c(r109, this.f103664g, this.f103665h);
    L25:
        r103 = r110;
    L26:
        this.f103672o = r103;
        goto L27
    L17:
        if (r108 != 3) goto L19;
        this.f103663f = 3;
        Context r111 = getContext();
        Intrinsics.checkNotNull(r111);
        r110 = new com.bytedance.android.livesdk.antiaddiction.view.b(r111, this.f103664g, this.f103665h);
        goto L25
    L19:
        if (r108 == 4) goto L24;
        if (r108 == 5) goto L24;
    L27:
        this.f103666i = new SimpleMediaView(getContext());
        tic.a r112 = new tic.a();
        ejc.b.a r113 = new ejc.b.a();
        r113.f472912a = 2;
        r113.f472917f = true;
        r112.f546377o = new ejc.b(r113);
        View r114 = r100.inflate(R.layout.ttlive_anti_addiction_fragment_layout, r101, false);
        this.f103668k = r114;
        return r114;
    L8:
        r105 = null;
        goto L9
    }
}
