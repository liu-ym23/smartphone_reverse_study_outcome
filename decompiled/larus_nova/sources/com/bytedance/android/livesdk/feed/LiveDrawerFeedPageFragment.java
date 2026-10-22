package com.bytedance.android.livesdk.feed;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.uikit.viewpager.SSViewPager;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.depend.feed.IDrawerFeedAction;
import com.bytedance.android.livehostapi.business.depend.feed.ILiveDrawerLayoutInterceptor;
import com.bytedance.android.livesdk.chatroom.ui.DouyinLoadingLayout;
import com.bytedance.android.livesdk.config.a41;
import com.bytedance.android.livesdk.config.d00;
import com.bytedance.android.livesdk.config.gp;
import com.bytedance.android.livesdk.config.lp;
import com.bytedance.android.livesdk.feed.drawer.preload.PreloadHelper;
import com.bytedance.android.livesdk.feed.setting.LiveFeedSettings;
import com.bytedance.android.livesdk.feed.tab.viewmodel.FeedTabViewModelFactory;
import com.bytedance.android.livesdk.feed.viewmodel.FeedTabViewModel;
import com.bytedance.android.livesdk.feed.viewmodel.MultiFeedTabViewModel;
import com.bytedance.android.livesdk.feed.viewmodel.TabFeedViewModel;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.schema.interfaces.ILiveActionHandler;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdk.viewmodel.MergeDrawerViewModel;
import com.bytedance.android.livesdkapi.ILiveDrawerMultiTabView;
import com.bytedance.android.livesdkapi.ILiveOntologyInfoManager;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.LiveDrawerUrlHelper;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0006\u0007B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/feed/LiveDrawerFeedPageFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "Lqv1/a;", "Lcom/bytedance/android/livesdkapi/ILiveDrawerMultiTabView;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveDrawerFeedPageFragment extends BaseFragment implements qv1.a, ILiveDrawerMultiTabView {
    public static boolean G;
    public static final a H = null;
    public final Keva A;
    public ImageView B;
    public ImageView C;
    public ImageView D;
    public yo2.e E;
    public final String F;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SSViewPager f123479d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LiveDrawerPagerSlidingTabStrip f123480e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LiveDrawerTabScrollShadow f123481f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LiveDrawerPageAdapter f123482g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public DouyinLoadingLayout f123483h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f123484i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f123485j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f123486k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f123487l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f123488m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ViewGroup f123489n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public TextView f123490o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ImageView f123491p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f123492q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public FeedTabViewModel f123493r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final CompositeDisposable f123494s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f123495t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public LiveDrawerTabViewModel f123496u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f123497v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f123498w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public IDrawerFeedAction f123499x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f123500y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final String f123501z;

    public static final class a {
        public a() {
        }

        public static void a(long r100) {
            com.bytedance.android.livesdk.sharedpref.e<Map<String, Long>> r101 = com.bytedance.android.livesdk.sharedpref.b.f158125b2;
            r101.getValue().put("show_times", Long.valueOf(r100));
            r101.getValue().put("last_show_time", Long.valueOf(System.currentTimeMillis()));
        }
    }

    public static final class b implements ILiveDrawerLayoutInterceptor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f123502a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f123503b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f123504c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final View f123505d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final ViewPager f123506e;

        @Override // com.bytedance.android.livehostapi.business.depend.feed.ILiveDrawerLayoutInterceptor
        public final boolean onInterceptTouchEvent(MotionEvent r110) {
            if (r110 != null) goto L41;
            return false;
        L41:
            float r100 = r110.getRawX();     // Catch: IllegalArgumentException -> L38
            float r101 = r110.getRawY();     // Catch: IllegalArgumentException -> L38
            int r111 = r110.getAction();     // Catch: IllegalArgumentException -> L38
            if (r111 != 0) goto L9;
            this.f123502a = r100;     // Catch: IllegalArgumentException -> L38
            this.f123503b = r101;     // Catch: IllegalArgumentException -> L38
        L40:
            return true;
        L9:
            if (r111 != 2) goto L40;
            View r112 = this.f123505d;     // Catch: IllegalArgumentException -> L38
            int r102 = (int) r100;     // Catch: IllegalArgumentException -> L38
            int r103 = (int) r101;     // Catch: IllegalArgumentException -> L38
            if (r112 == null) goto L21;
            int[] r104 = new int[2];     // Catch: IllegalArgumentException -> L38
            r112.getLocationOnScreen(r104);     // Catch: IllegalArgumentException -> L38
            int r105 = r104[0];     // Catch: IllegalArgumentException -> L38
            int r106 = r104[1];     // Catch: IllegalArgumentException -> L38
            int r107 = r112.getMeasuredWidth() + r105;     // Catch: IllegalArgumentException -> L38
            int r113 = r112.getMeasuredHeight() + r106;     // Catch: IllegalArgumentException -> L38
            if (r106 > r103) goto L21;
            if (r113 < r103) goto L21;
            if (r102 < r105) goto L21;
            if (r102 > r107) goto L21;
            boolean r114 = true;
        L22:
            if (r114 == true) goto L24;
            return false;
        L24:
            float r115 = this.f123502a;     // Catch: IllegalArgumentException -> L38
            if (r100 >= r115) goto L27;
            return true;
        L27:
            float r116 = Math.abs(r100 - r115);     // Catch: IllegalArgumentException -> L38
            float r108 = Math.abs(r101 - this.f123503b);     // Catch: IllegalArgumentException -> L38
            float r117 = (r116 * r116) + (r108 * r108);     // Catch: IllegalArgumentException -> L38
            int r109 = this.f123504c;     // Catch: IllegalArgumentException -> L38
            if (r117 <= (r109 * r109)) goto L30;
            boolean r118 = true;
        L31:
            if (r118 == true) goto L33;
        L34:
            return true;
        L33:
            if (this.f123506e.getCurrentItem() != 0) goto L34;
            return false;
        L30:
            r118 = false;
        L21:
            r114 = false;
        L38:
            e = move-exception;
            e.printStackTrace();
            goto L40
        }

        public b(View r100, SSViewPager r101, LiveDrawerFeedPageFragment r102) {
            Intrinsics.checkNotNullParameter(r101, "viewPage");
            Intrinsics.checkNotNullParameter(r102, "baseFragment");
            this.f123505d = r100;
            this.f123506e = r101;
            this.f123504c = ViewConfiguration.get(jc1.a.b()).getScaledTouchSlop();
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveDrawerFeedPageFragment f123507a;

        public c(LiveDrawerFeedPageFragment r100) {
            this.f123507a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            uv1.e r101 = (uv1.e) r100;
            Intrinsics.checkNotNullParameter(r101, "liveDrawerActionEvent");
            int r102 = r101.f551796a;
            if (r102 != 0) goto L5;
            IDrawerFeedAction r103 = this.f123507a.f123499x;
            if (r103 == null) goto L16;
            r103.closeDrawerDialog();
            return;
        L16:
            return;
        L5:
            if (r102 != 1) goto L17;
            IDrawerFeedAction r104 = this.f123507a.f123499x;
            if (r104 == null) goto L14;
            r104.disableDrawerSlide();
            return;
        L14:
            return;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveDrawerFeedPageFragment f123508a;

        public d(LiveDrawerFeedPageFragment r100) {
            this.f123508a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            yv1.a r101 = (yv1.a) r100;
            Intrinsics.checkNotNullParameter(r101, "event");
            if (r101.f569280a == 0) goto L6;
            this.f123508a.f123495t = true;
            return;
        }
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, tw2.b
    public final String getSpm() {
        return "a100.a207";
    }

    static {
        H = new a();
    }

    @Override // qv1.a
    public final void DP() {
        if (G == false) goto L10;
        ImageView r100 = this.f123491p;
        if (r100 == null) goto L7;
        UtilityKotlinExtentionsKt.w(r100);
    L7:
        TextView r101 = this.f123490o;
        if (r101 == null) goto L17;
        UtilityKotlinExtentionsKt.t(r101);
        return;
    L17:
        return;
    L10:
        ImageView r102 = this.f123491p;
        if (r102 == null) goto L13;
        UtilityKotlinExtentionsKt.t(r102);
    L13:
        TextView r103 = this.f123490o;
        if (r103 == null) goto L19;
        UtilityKotlinExtentionsKt.t(r103);
        return;
    }

    @Override // qv1.a
    public final void P20() {
        ImageView r100 = this.f123491p;
        if (r100 == null) goto L6;
        UtilityKotlinExtentionsKt.t(r100);
        return;
    }

    @Override // com.bytedance.android.livesdkapi.ILiveDrawerMultiTabView
    public final void dismissPopView() {
        yo2.e r100 = this.E;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.h() == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L12;
        r100.d();
        return;
    }

    public final void onLeave() {
        LiveDrawerTabViewModel r100 = this.f123496u;
        if (r100 == null) goto L52;
        LiveDrawerTabViewModel.a r101 = new LiveDrawerTabViewModel.a();
        FeedTabViewModel r102 = this.f123493r;
        long r103 = -1;
        int r104 = 0;
        Fragment r105 = null;
        if (r102 == null) goto L17;
        List<com.bytedance.android.livesdk.feed.feed.e> r106 = r102.getAllTabs();
        if (r106 == null) goto L17;
        int r107 = r106.size();
        int r108 = this.f123497v;
        if (r107 <= r108) goto L11;
        boolean r109 = true;
    L12:
        if (r109 == true) goto L15;
        r106 = null;
    L15:
        if (r106 == null) goto L17;
        long r110 = ((com.bytedance.android.livesdk.feed.feed.e) ListProtector.get(r106, r108)).f();
    L18:
        r101.f123557a = r110;
        LiveDrawerPageAdapter r111 = this.f123482g;
        if (r111 == null) goto L21;
        Fragment r112 = r111.getItem(this.f123497v);
    L23:
        if ((r112 instanceof LiveDrawerFeedCategoryFragment) == true) goto L25;
        r112 = null;
    L25:
        LiveDrawerFeedCategoryFragment r113 = (LiveDrawerFeedCategoryFragment) r112;
        if (r113 == null) goto L28;
        int r114 = r113.C;
    L29:
        r101.f123558b = r114;
        LiveDrawerPageAdapter r115 = this.f123482g;
        if (r115 == null) goto L32;
        Fragment r116 = r115.getItem(this.f123497v);
    L34:
        if ((r116 instanceof LiveDrawerFeedCategoryFragment) == true) goto L36;
        r116 = null;
    L36:
        LiveDrawerFeedCategoryFragment r117 = (LiveDrawerFeedCategoryFragment) r116;
        if (r117 == null) goto L39;
        r104 = r117.B;
    L39:
        r101.f123559c = r104;
        LiveDrawerPageAdapter r118 = this.f123482g;
        if (r118 == null) goto L42;
        Fragment r119 = r118.getItem(this.f123497v);
    L44:
        if ((r119 instanceof LiveDrawerFeedCategoryFragment) == false) goto L47;
        r105 = r119;
    L47:
        LiveDrawerFeedCategoryFragment r120 = (LiveDrawerFeedCategoryFragment) r105;
        if (r120 == null) goto L50;
        r103 = r120.D;
    L50:
        r101.f123560d = r103;
        Unit r121 = Unit.INSTANCE;
        r100.setTabStatus(r101);
        return;
    L42:
        r119 = null;
        goto L44
    L32:
        r116 = null;
        goto L34
    L28:
        r114 = 0;
        goto L29
    L21:
        r112 = null;
        goto L23
    L11:
        r109 = false;
    L17:
        r110 = -1;
        goto L18
    }

    @Override // com.bytedance.android.livesdkapi.ILiveDrawerMultiTabView
    public final void showPopView() {
        View r100 = this.f123487l;
        if (r100 != null) goto L5;
        return;
    L5:
        Context r101 = getContext();
        if (r101 != null) goto L9;
        return;
    L9:
        if (gp.f120304a.getValue().c() == false) goto L11;
        return;
    L11:
        d00 r102 = d00.f119992a;
        if (r102 == null) goto L36;
        a41 r103 = r102.getValue();
        if (r103 != null) goto L16;
        return;
    L16:
        if (r103.a() != true) goto L38;
        Keva r104 = this.A;
        if (r104 != null) goto L21;
    L23:
        this.A.storeBoolean(this.F, true);
        String r105 = null;
        View r106 = LayoutInflater.from(r101).inflate(R.layout.ttlive_live_history_guide_layout, null);
        if (r106 == null) goto L26;
        TextView r107 = (TextView) r106.findViewById(R.id.text);
    L27:
        if (r107 == null) goto L34;
        a41 r108 = r102.getValue();
        if (r108 == null) goto L32;
        r105 = r108.b();
    L32:
        if (TextUtils.isEmpty(r105) == true) goto L34;
        r107.setText(r102.getValue().b());
    L34:
        yo2.e r109 = new yo2.e(r101);
        int r110 = (int) UIUtils.dip2Px(r101, 141.0f);
        int r111 = (int) UIUtils.dip2Px(r101, 49.0f);
        r109.f568642d = r106;
        r109.f568643e = 0;
        r109.f568646h = r110;
        r109.f568647i = r111;
        r109.f568651m = 50;
        r109.f568650l = true;
        r109.f568645g = false;
        r109.a();
        this.E = r109;
        r109.i(r100, 2, 4, 0, 0);
        return;
    L26:
        r107 = null;
        goto L27
    L21:
        if (r104.getBoolean(this.F, false) == false) goto L23;
        return;
    L38:
        return;
    }

    public LiveDrawerFeedPageFragment() {
        this.f123494s = new CompositeDisposable();
        this.f123501z = "yellow_keva";
        this.A = Keva.getRepo("draw_history", 0);
        this.F = "pop_guide";
        boolean r100 = x0.f124600d;
        x0.a.a();
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f123494s.clear();
        IDrawerFeedAction r100 = this.f123499x;
        if (r100 == null) goto L6;
        r100.setInterceptor(null);
        return;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        IService r100 = jc1.k.f(ILiveService.class);
        Intrinsics.checkNotNull(r100);
        ((ILiveService) r100).unMuteLivePlayer();
        SSViewPager r101 = this.f123479d;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.getCurrentItem();
    L6:
        FeedTabViewModel r104 = this.f123493r;
        if (r104 == null) goto L11;
        List<com.bytedance.android.livesdk.feed.feed.e> r105 = r104.getAllTabs();
        if (r105 == null) goto L11;
        int r106 = r105.size();
    L12:
        if (r103 >= r106) goto L24;
        FeedTabViewModel r107 = this.f123493r;
        if (r107 == null) goto L18;
        List<com.bytedance.android.livesdk.feed.feed.e> r108 = r107.getAllTabs();
        if (r108 == null) goto L18;
        com.bytedance.android.livesdk.feed.feed.e r109 = (com.bytedance.android.livesdk.feed.feed.e) ListProtector.get(r108, r103);
    L19:
        IDrawerFeedAction r110 = this.f123499x;
        if (r110 == null) goto L24;
        if (r109 == null) goto L23;
        r102 = r109.getType();
    L23:
        r110.setBackgroundByTabType(r102);
    L18:
        r109 = null;
    L24:
        DP();
        return;
    L11:
        r106 = 0;
        goto L12
    L5:
        r103 = 0;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        onLeave();
    }

    public static final void S90(LiveDrawerFeedPageFragment r110) {
        r110.getClass();
        if ((System.currentTimeMillis() - r110.f123492q) <= 3000) goto L22;
        com.bytedance.android.livesdk.log.u.l().a(1);
        r110.f123492q = System.currentTimeMillis();
        if (TTLiveSDK.hostService().user().isLogin() == true) goto L17;
        TTLiveSDK.hostService().user().login(r110.getActivity(), new m0(r110), "", "", 0, "", "", "");
        return;
    L17:
    L14:
        e = move-exception;
        IService r100 = jc1.k.f(ILiveService.class);
        Intrinsics.checkNotNull(r100);
        ((ILiveService) r100).unMuteLivePlayer();
        e.printStackTrace();
        return;
    L9:
        if (r110.getContext() == null) goto L20;
        IService r101 = jc1.k.f(ILiveService.class);     // Catch: Exception -> L14
        Intrinsics.checkNotNull(r101);     // Catch: Exception -> L14
        ((ILiveService) r101).muteLivePlayer();     // Catch: Exception -> L14
        ILiveActionHandler r102 = (ILiveActionHandler) jc1.k.f(ILiveActionHandler.class);     // Catch: Exception -> L14
        if (r102 == null) goto L21;
        r102.handle(r110.getContext(), "sslocal://webcast_open_live");     // Catch: Exception -> L14
        return;
    L21:
        return;
    L20:
        return;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        Disposable r101 = ((ObservableSubscribeProxy) xs2.b.a().b(uv1.e.class).compose(RxUtil.bindUntilDestroy(this)).as(AutoDispose.bind(this))).subscribe(new c(this));
        Disposable r102 = ((ObservableSubscribeProxy) xs2.b.a().b(yv1.a.class).compose(RxUtil.bindUntilDestroy(this)).as(AutoDispose.bind(this))).subscribe(new d(this));
        this.f123494s.add(r101);
        this.f123494s.add(r102);
        FragmentActivity r103 = getActivity();
        if (r103 == null) goto L11;
        TabFeedViewModel r104 = PreloadHelper.f123673a;
        if (r103.hashCode() != PreloadHelper.f123677e) goto L7;
        LiveDrawerTabViewModel r105 = PreloadHelper.f123674b;
    L8:
        this.f123496u = r105;
        if (r105 != null) goto L11;
        this.f123496u = (LiveDrawerTabViewModel) ViewModelProviders.of(r103).get(LiveDrawerTabViewModel.class);
        goto L11
    L7:
        r105 = null;
    L11:
        Bundle r106 = getArguments();
        if (r106 == null) goto L18;
        h0.f124069m = r106.getLong("drawer_enter_time");
        String r107 = r106.getString("pull_type");
        if (r107 != null) goto L16;
        r107 = "";
    L16:
        h0.a.a(r107);
        this.f123500y = r106.getBoolean("live_drawer_support_search", false);
        return;
    }

    @Override // qv1.a
    public final void scrollToTop(boolean r100) {
        IDrawerFeedAction r101 = this.f123499x;
        if (r101 == null) goto L6;
        r101.scrollToTop(r100);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void setUserVisibleHint(boolean r100) {
        super.setUserVisibleHint(r100);
        if (r100 == true) goto L6;
        onLeave();
        return;
    }

    public final void showLoading(boolean r100) {
        if (r100 == false) goto L9;
        DouyinLoadingLayout r101 = this.f123483h;
        if (r101 == null) goto L6;
        r101.setVisibility(0);
    L6:
        DouyinLoadingLayout r102 = this.f123483h;
        if (r102 == null) goto L16;
        r102.b();
        return;
    L16:
        return;
    L9:
        DouyinLoadingLayout r103 = this.f123483h;
        if (r103 == null) goto L12;
        r103.setVisibility(8);
    L12:
        DouyinLoadingLayout r104 = this.f123483h;
        if (r104 == null) goto L18;
        r104.c();
        return;
    }

    @Override // qv1.a
    public final void C(RecyclerView r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        if (this.f123495t == false) goto L6;
        xs2.b.a().post(new yv1.a(0));
        this.f123495t = false;
    L6:
        if (G == false) goto L12;
        if (r101 != 0) goto L13;
        ImageView r102 = this.f123491p;
        if (r102 == null) goto L14;
        r102.setVisibility(0);
        return;
    L14:
        return;
    L13:
        return;
    }

    public final void T90(View r100, int r101, int r102) {
        if (r100 == null) goto L11;
        ViewGroup.LayoutParams r103 = r100.getLayoutParams();
        if (r101 != (-1)) goto L6;
        r101 = r103.width;
    L6:
        r103.width = r101;
        if (r102 != (-1)) goto L9;
        r102 = r103.height;
    L9:
        r103.height = r102;
        r100.setLayoutParams(r103);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r210, ViewGroup r211, Bundle r212) {
        Intrinsics.checkNotNullParameter(r210, "inflater");
        View r100 = r210.inflate(R.layout.ttlive_feed_drawer_layout, r211, false);
        this.f123484i = r100;
        this.f123479d = (SSViewPager) r100.findViewById(R.id.view_pager);
        this.f123481f = (LiveDrawerTabScrollShadow) r100.findViewById(R.id.pager_shadow);
        this.f123489n = (ViewGroup) r100.findViewById(R.id.top);
        this.f123480e = (LiveDrawerPagerSlidingTabStrip) r100.findViewById(R.id.pager_tab);
        View r101 = r100.findViewById(R.id.back_icon);
        this.f123485j = r101;
        if (r101 == null) goto L5;
        r101.setVisibility(8);
    L5:
        this.f123487l = r100.findViewById(R.id.history_container);
        this.f123488m = r100.findViewById(R.id.yellow_point);
        View r102 = r100.findViewById(R.id.search_icon);
        this.f123486k = r102;
        if (r102 != null) goto L8;
    L12:
        SSViewPager r103 = this.f123479d;
        if (r103 == null) goto L17;
        IDrawerFeedAction r104 = this.f123499x;
        if (r104 == null) goto L17;
        r104.setInterceptor(new b(this.f123484i, r103, this));
    L17:
        this.B = (ImageView) r100.findViewById(R.id.imv_back_icon);
        this.C = (ImageView) r100.findViewById(R.id.imv_search_icon);
        this.D = (ImageView) r100.findViewById(R.id.history_icon);
        this.f123483h = (DouyinLoadingLayout) r100.findViewById(R.id.loading_view);
        if (Intrinsics.areEqual(lp.f120698a.getValue(), Boolean.TRUE) == true) goto L20;
    L38:
        View r105 = this.f123487l;
        if (r105 == null) goto L41;
        r105.setVisibility(8);
    L41:
        View r106 = this.f123488m;
        if (r106 == null) goto L44;
        r106.setVisibility(8);
    L44:
        this.f123482g = new LiveDrawerPageAdapter(getChildFragmentManager(), this.f123499x, this.f123496u, this, this);
        FragmentActivity r107 = getActivity();
        if (r107 == null) goto L47;
        boolean r108 = x0.f124600d;
        this.f123493r = (FeedTabViewModel) ViewModelProviders.of(r107, new FeedTabViewModelFactory(x0.a.a(), new n(), com.bytedance.android.livesdk.feed.services.d.b())).get(MultiFeedTabViewModel.class);
        ((MergeDrawerViewModel) ViewModelProviders.of(r107).get(MergeDrawerViewModel.class)).getCloseDrawer().observe(this, t0.f124481a);
    L47:
        com.bytedance.android.livesdk.log.filter.o r109 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class);
        String r110 = "";
        if (r109.getMap().containsKey("enter_from_merge") == false) goto L50;
        String r111 = r109.getMap().get("enter_from_merge");
    L51:
        if (r111 != null) goto L54;
        r111 = "";
    L54:
        if (r109.getMap().containsKey("enter_method") == false) goto L56;
        String r112 = r109.getMap().get("enter_method");
    L57:
        if (r112 != null) goto L59;
        r112 = "";
    L59:
        FeedTabViewModel r113 = this.f123493r;
        if (r113 == null) goto L91;
        List<com.bytedance.android.livesdk.feed.feed.e> r114 = r113.getAllTabs();
        if (r114 == null) goto L91;
        ArrayList r115 = new ArrayList();
        Iterator<T> r116 = r114.iterator();
    L65:
        if (r116.hasNext() == false) goto L92;
        Object r117 = r116.next();
        com.bytedance.android.livesdk.feed.feed.e r118 = (com.bytedance.android.livesdk.feed.feed.e) r117;
        List<String> r119 = r118.b();
        if (r119 != null) goto L69;
    L72:
        boolean r120 = true;
    L73:
        if (r120 == false) goto L75;
    L76:
        List<String> r121 = r118.d();
        if (r121 != null) goto L79;
    L82:
        boolean r122 = true;
    L83:
        if (r122 == false) goto L85;
    L88:
        boolean r123 = true;
    L89:
        if (r123 == false) goto L65;
        r115.add(r117);
        goto L65
    L85:
        if (LiveDrawerUrlHelper.isParamInList(r111, r112, r118.d()) == true) goto L88;
    L87:
        r123 = false;
        goto L89
    L79:
        if (r121.isEmpty() == true) goto L82;
        r122 = false;
        goto L83
    L75:
        if (LiveDrawerUrlHelper.isParamInList(r111, r112, r118.b()) == true) goto L87;
    L69:
        if (r119.isEmpty() == true) goto L72;
        r120 = false;
    L92:
        if (r115 == null) goto L96;
        LiveDrawerPageAdapter r124 = this.f123482g;
        if (r124 == null) goto L96;
        Intrinsics.checkNotNullParameter(r115, "data");
        ((ArrayList) r124.f123511a).clear();
        ((ArrayList) r124.f123511a).addAll(r115);
    L96:
        SSViewPager r125 = this.f123479d;
        if (r125 == null) goto L99;
        r125.setAdapter(this.f123482g);
    L99:
        LiveDrawerPagerSlidingTabStrip r126 = this.f123480e;
        if (r126 == null) goto L102;
        r126.setShadeView(this.f123481f);
    L102:
        LiveDrawerPagerSlidingTabStrip r127 = this.f123480e;
        if (r127 == null) goto L105;
        r127.setViewPager(this.f123479d);
    L105:
        Bundle r128 = getArguments();
        long r129 = -1;
        if (r128 == null) goto L108;
        boolean r130 = r128.getBoolean("switch_follow", false);
        long r131 = r128.getLong("default_tab_type", -1);
        long r132 = r128.getLong("tag_id", -1);
    L110:
        if (bx1.a.b(r111) == true) goto L125;
        if (r130 == true) goto L125;
        if (bx1.a.a(r111) == false) goto L117;
        int r133 = 3;
    L126:
        if (r115 == null) goto L137;
        Iterator r134 = r115.iterator();
        int r135 = 0;
        int r136 = 0;
    L129:
        if (r134.hasNext() == false) goto L138;
        Object r137 = r134.next();
        int r138 = r135 + 1;
        if (r135 >= 0) goto L134;
        CollectionsKt.throwIndexOverflow();
    L134:
        if (((com.bytedance.android.livesdk.feed.feed.e) r137).getType() != r133) goto L136;
        r136 = r135;
    L136:
        r135 = r138;
    L138:
        if (r115 == null) goto L154;
        Iterator r139 = r115.iterator();
        int r140 = 0;
    L141:
        if (r139.hasNext() == false) goto L154;
        Object r141 = r139.next();
        int r142 = r140 + 1;
        if (r140 >= 0) goto L145;
        CollectionsKt.throwIndexOverflow();
    L145:
        long r143 = ((com.bytedance.android.livesdk.feed.feed.e) r141).f();
        LiveDrawerTabViewModel r144 = this.f123496u;
        if (r144 == null) goto L152;
        LiveDrawerTabViewModel.a r145 = r144.getTabStatus();
        if (r145 == null) goto L152;
        if (r143 != r145.f123557a) goto L152;
        r136 = r140;
    L152:
        r140 = r142;
        r129 = -1;
    L154:
        if (r131 == r129) goto L167;
        if (r130 == true) goto L167;
        if (r115 == null) goto L167;
        Iterator r146 = r115.iterator();
        int r147 = 0;
    L159:
        if (r146.hasNext() == false) goto L167;
        Object r148 = r146.next();
        int r149 = r147 + 1;
        if (r147 >= 0) goto L164;
        CollectionsKt.throwIndexOverflow();
    L164:
        if (((com.bytedance.android.livesdk.feed.feed.e) r148).getType() != ((int) r131)) goto L166;
        r136 = r147;
    L166:
        r147 = r149;
    L167:
        int r150 = r136;
        if (r150 < 0) goto L192;
        if (r115 == null) goto L171;
        int r151 = r115.size();
    L172:
        if (r150 >= r151) goto L192;
        if (r115 == null) goto L175;
        com.bytedance.android.livesdk.feed.feed.e r152 = (com.bytedance.android.livesdk.feed.feed.e) ListProtector.get(r115, r150);
    L176:
        int r153 = v0.f124550a;
        ILiveService r154 = TTLiveService.getLiveService();
        if (r154 == null) goto L182;
        ILiveOntologyInfoManager r155 = r154.getLiveOntologyRecord();
        if (r155 == null) goto L182;
        String r156 = r155.getEnterFromMerge();
        if (r156 == null) goto L182;
    L183:
        if (r152 == null) goto L188;
        String r157 = r152.j();
        if (r157 == null) goto L188;
        r110 = r157;
    L188:
        if (r152 == null) goto L190;
        int r158 = r152.getType();
    L191:
        v0.a(r156, r110, "default", r158);
        goto L192
    L190:
        r158 = 0;
    L182:
        r156 = "drawer_null";
        goto L183
    L175:
        r152 = null;
        goto L176
    L171:
        r151 = 0;
    L192:
        Bundle r159 = getArguments();
        if (r159 == null) goto L195;
        r159.putLong(com.bytedance.android.ec.core.event.a.KEY_TAG_TYPE, r131);
    L195:
        Bundle r160 = getArguments();
        if (r160 == null) goto L198;
        r160.putLong("tag_id", r132);
    L198:
        SSViewPager r161 = this.f123479d;
        if (r161 == null) goto L201;
        r161.setCurrentItem(r150);
    L201:
        this.f123497v = r150;
        this.f123498w = r150;
        LiveDrawerPagerSlidingTabStrip r162 = this.f123480e;
        if (r162 == null) goto L204;
        r162.setOnTabClickListener(new u0(this));
    L204:
        LiveDrawerPagerSlidingTabStrip r163 = this.f123480e;
        if (r163 == null) goto L207;
        r163.setOnPageChangeListener(new LiveDrawerFeedPageFragment$initView$9(this));
    L207:
        View r164 = this.f123485j;
        if (r164 == null) goto L210;
        r164.setOnClickListener(new n0(this));
    L210:
        View r165 = this.f123486k;
        if (r165 == null) goto L213;
        r165.setOnClickListener(new o0(this));
    L213:
        View r166 = this.f123487l;
        if (r166 == null) goto L217;
        r166.setOnClickListener(new p0(this));
    L217:
        if (TTLiveSDK.hostService().user().isLogin() == true) goto L219;
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r167 = com.bytedance.android.livesdk.sharedpref.b.f158120a2;
        Boolean r168 = Boolean.TRUE;
        r167.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r167, r168);
        com.bytedance.android.livesdk.log.u.l().a(0);
    L227:
        TextView r169 = (TextView) r100.findViewById(R.id.bt_start_live);
        this.f123490o = r169;
        if (r169 == null) goto L230;
        r169.setOnClickListener(new r0(this));
    L230:
        ImageView r170 = (ImageView) r100.findViewById(R.id.bt_start_live2);
        this.f123491p = r170;
        if (r170 == null) goto L233;
        UtilityKotlinExtentionsKt.t(r170);
    L233:
        ImageView r171 = this.f123491p;
        if (r171 == null) goto L236;
        r171.setOnClickListener(new s0(this));
    L236:
        H.getClass();
        Integer r172 = LiveFeedSettings.LIVE_DRAWER_OPEN_LIVE.getValue();
        if (r172 != null) goto L240;
    L241:
        boolean r173 = true;
    L243:
        if (r173 == false) goto L258;
        Map<String, Long> r174 = com.bytedance.android.livesdk.sharedpref.b.f158125b2.getValue();
        if (r174.get("show_times") != null) goto L248;
        a.a(1);
    L257:
        boolean r175 = true;
    L259:
        G = r175;
        if (r175 == false) goto L262;
        ViewGroup.LayoutParams r176 = null;
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_drawer_page_inspire_live_button_show", null, new Object[]{Room.class, am2.x.class});
    L263:
        DP();
        IDrawerFeedAction r177 = this.f123499x;
        if (r177 == null) goto L266;
        r177.feedEnd();
    L266:
        r3.c(this.f123486k, s1.B(R.string.ttlive_live_pk_search), true);
        r3.c(this.f123487l, s1.B(R.string.ttlive_live_history), true);
        if (com.bytedance.android.livesdk.utils.landscape.b.b() == true) goto L269;
        boolean r178 = false;
    L270:
        if (r178 == false) goto L304;
        int r179 = s1.f(40.0f);
        int r180 = s1.f(40.0f);
        int r181 = s1.f(20.0f);
        int r182 = s1.f(20.0f);
        T90(this.f123489n, -1, r180);
        T90(this.f123485j, r179, r180);
        T90(this.B, r181, r182);
        T90(this.f123486k, -2, r180);
        T90(this.C, r181, r182);
        T90(this.f123487l, -1, r180);
        T90(this.D, r181, r182);
        LiveDrawerPagerSlidingTabStrip r183 = this.f123480e;
        if (r183 == null) goto L274;
        r183.setTextSize(s1.f(14.0f));
    L274:
        LiveDrawerPagerSlidingTabStrip r184 = this.f123480e;
        if (r184 == null) goto L277;
        r184.setTabTextSelectSize(s1.f(14.0f));
    L277:
        View r185 = this.f123487l;
        if (r185 == null) goto L280;
        ViewGroup.LayoutParams r186 = r185.getLayoutParams();
    L282:
        if (r186 == null) goto L303;
        LinearLayout.LayoutParams r187 = (LinearLayout.LayoutParams) r186;
        r187.leftMargin = s1.f(8.0f);
        r187.rightMargin = s1.f(4.0f);
        View r188 = this.f123487l;
        if (r188 == null) goto L286;
        r188.setLayoutParams(r187);
    L286:
        View r189 = this.f123486k;
        if (r189 == null) goto L289;
        ViewGroup.LayoutParams r190 = r189.getLayoutParams();
    L290:
        if (r190 == null) goto L301;
        LinearLayout.LayoutParams r191 = (LinearLayout.LayoutParams) r190;
        r191.leftMargin = s1.f(8.0f);
        View r192 = this.f123486k;
        if (r192 == null) goto L294;
        r192.setLayoutParams(r191);
    L294:
        ImageView r193 = this.D;
        if (r193 == null) goto L297;
        r193.setImageResource(R.drawable.ttlive_ic_search_bar_history_landscape);
    L297:
        ImageView r194 = this.C;
        if (r194 == null) goto L304;
        r194.setImageResource(R.drawable.ttlive_feed_ic_search_bar_search_landscape);
        goto L304
    L301:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L289:
        r190 = r176;
        goto L290
    L303:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L280:
        r186 = r176;
    L304:
        return r100;
    L269:
        r178 = e5.n();
        goto L270
    L262:
        r176 = null;
        goto L263
    L248:
        Long r195 = r174.get("show_times");
        Intrinsics.checkNotNull(r195);
        if (r195.longValue() >= 3) goto L251;
        a.a(r195.longValue() + 1);
        goto L257
    L251:
        Long r196 = r174.get("last_show_time");
        if (r196 != null) goto L255;
        r196 = 0L;
    L255:
        if ((System.currentTimeMillis() - r196.longValue()) <= 604800000) goto L258;
        a.a(1);
    L258:
        r175 = false;
        goto L259
    L240:
        if (r172.intValue() != 0) goto L241;
        r173 = false;
        goto L243
    L219:
        Integer r197 = LiveFeedSettings.LIVE_DRAWER_START_LIVE_BTN.getValue();
        if (r197 == null) goto L225;
        if (r197.intValue() == 0) goto L227;
    L225:
        if (TTLiveSDK.hostService().user().isLogin() == false) goto L227;
        TTLiveSDK.hostService().user().requestLivePermission(new q0(this));
        goto L227
    L137:
        r136 = 0;
        goto L138
    L117:
        if (TextUtils.isEmpty(r111) == false) goto L119;
    L121:
        boolean r198 = false;
    L122:
        if (r198 == false) goto L124;
        r133 = 4;
        goto L126
    L124:
        r133 = 1;
        goto L126
    L119:
        if (CollectionsKt.contains(bx1.a.f21279c, r111) == false) goto L121;
        r198 = true;
    L125:
        r133 = 2;
        goto L126
    L108:
        r132 = -1;
        r131 = -1;
        r130 = false;
    L91:
        r115 = null;
        goto L92
    L56:
        r112 = "";
        goto L57
    L50:
        r111 = "";
        goto L51
    L20:
        if (gp.f120304a.getValue().c() == true) goto L38;
        View r199 = this.f123487l;
        if (r199 == null) goto L25;
        r199.setVisibility(0);
    L25:
        if (this.A.getBoolean(this.f123501z, false) == false) goto L32;
        View r200 = this.f123488m;
        if (r200 == null) goto L29;
        r200.setVisibility(8);
    L29:
        IDrawerFeedAction r201 = this.f123499x;
        if (r201 == null) goto L44;
        r201.historyShow(0);
        goto L44
    L32:
        View r202 = this.f123488m;
        if (r202 == null) goto L35;
        r202.setVisibility(0);
    L35:
        IDrawerFeedAction r203 = this.f123499x;
        if (r203 == null) goto L44;
        r203.historyShow(1);
        goto L44
    L8:
        if (this.f123500y == false) goto L10;
        int r204 = 0;
    L11:
        r102.setVisibility(r204);
        goto L12
    L10:
        r204 = 8;
        goto L11
    }
}
