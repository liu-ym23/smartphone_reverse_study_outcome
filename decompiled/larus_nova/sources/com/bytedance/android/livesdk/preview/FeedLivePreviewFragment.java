package com.bytedance.android.livesdk.preview;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.core.setting.CoreSettingKeys;
import com.bytedance.android.live.core.ui.BaseFragment;
import com.bytedance.android.live.core.utils.FeedDraw;
import com.bytedance.android.live.core.utils.LiveResUtil;
import com.bytedance.android.live.core.utils.NetworkUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.feed.openui.view.HorizontalLiveListView;
import com.bytedance.android.livesdk.feed.openui.view.LiveOuterFollowListView;
import com.bytedance.android.livesdk.utils.LiveNetworkBroadcastReceiver;
import com.bytedance.android.livesdk.widget.LiveSwipeRefreshLayout;
import com.bytedance.android.livesdk.widget.LiveVerticalViewPager;
import com.bytedance.android.livesdk.widget.SafeInterceptTouchLayout;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.roomplayer.EnterFromMerge;
import com.bytedance.android.livesdkapi.roomplayer.EnterMethod;
import com.bytedance.android.livesdkapi.roomplayer.ILivePreviewCoverView;
import com.bytedance.android.livesdkapi.roomplayer.ILivePreviewFragment;
import com.bytedance.android.livesdkapi.roomplayer.LiveMetricsParams;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes11.dex */
public class FeedLivePreviewFragment extends BaseFragment implements ILivePreviewFragment {
    public static final /* synthetic */ int B = 0;
    public int A;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f156317d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LiveMetricsParams f156318e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ry.f f156319f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f156320g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LiveVerticalViewPager f156321h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public FrameLayout f156322i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public LiveSwipeRefreshLayout f156323j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public p f156324k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.bytedance.android.livesdk.live.listprovider.o f156325l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public b f156326m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public kn2.n f156327n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final LiveNetworkBroadcastReceiver f156328o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f156329p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ry.b f156330q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f156331r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public FrameLayout f156332s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public TextView f156333t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public SafeInterceptTouchLayout f156334u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f156335v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f156336w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ValueAnimator f156337x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final a f156338y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f156339z;

    public class a implements LiveNetworkBroadcastReceiver.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FeedLivePreviewFragment f156340a;

        public a(FeedLivePreviewFragment r100) {
            this.f156340a = r100;
        }

        @Override // com.bytedance.android.livesdk.utils.LiveNetworkBroadcastReceiver.a
        public final void a(NetworkUtils.NetworkType r100) {
            if (r100 != NetworkUtils.NetworkType.NONE) goto L6;
            f2.b(R.string.ttlive_toast_network_exception, 0);
        L6:
            if (NetworkUtils.c(this.f156340a.getActivity()) == false) goto L9;
            f2.c(this.f156340a.getActivity().getString(R.string.ttlive_live_network_on_mobile), 1);
            return;
        }
    }

    public class b implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f156341a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f156342b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ILivePreviewCoverView f156343c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final SparseBooleanArray f156344d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ FeedLivePreviewFragment f156345e;

        public b(FeedLivePreviewFragment r100) {
            this.f156345e = r100;
            this.f156341a = 0;
            this.f156342b = -1;
            this.f156343c = null;
            int r101 = r100.f156329p;
            this.f156344d = new SparseBooleanArray();
        }

        public final void c(int r100) {
            p r101 = this.f156345e.f156324k;
            if (r101 == null) goto L18;
            int r102 = r101.getCount();
            if (r100 < 0) goto L17;
            if (r100 < r102) goto L10;
            return;
        L10:
            if (this.f156345e.T90(r100) != null) goto L13;
            return;
        L13:
            if (this.f156344d.get(r100) == true) goto L21;
            this.f156344d.put(r100, true);
            this.f156345e.Y90(r100, false);
            return;
        L21:
            return;
        L17:
            return;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int r100) {
            this.f156341a = r100;
            if (r100 != 0) goto L6;
            FeedLivePreviewFragment r101 = this.f156345e;
            r101.f156324k.i(r101.S90());
            this.f156344d.clear();
            this.f156344d.put(this.f156345e.f156321h.getCurrentItem(), true);
            return;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int r100) {
            LiveSwipeRefreshLayout r101 = this.f156345e.f156323j;
            if (r100 != 0) goto L5;
            boolean r102 = true;
        L6:
            r101.setEnabled(r102);
            this.f156342b = r100;
            if (this.f156341a != 0) goto L10;
            b(r100, this.f156345e.T90(r100));
            return;
        L10:
            return;
        L5:
            r102 = false;
            goto L6
        }

        public final void b(int r100, LivePreviewCoverView r101) {
            if (r101 == null) goto L14;
            ILivePreviewCoverView r102 = this.f156343c;
            if (r101 == r102) goto L15;
            if (r102 == null) goto L9;
            r102.release();
        L9:
            if (r101.k() == false) goto L11;
            r101.onShow();
        L12:
            this.f156343c = r101;
            this.f156342b = -1;
            FeedLivePreviewFragment r103 = this.f156345e;
            int r104 = FeedLivePreviewFragment.B;
            r103.X90();
            return;
        L11:
            FeedLivePreviewFragment r105 = this.f156345e;
            int r106 = FeedLivePreviewFragment.B;
            r105.Y90(r100, true);
            goto L12
        L15:
            return;
        }

        public final boolean a(int r100, float r101, boolean r102) {
            int r103 = this.f156345e.f156324k.getCount();
            if (r100 < 0) goto L23;
            if (r100 < r103) goto L7;
            return false;
        L7:
            if (this.f156345e.T90(r100) != null) goto L10;
            return false;
        L10:
            if (this.f156344d.get(r100) == false) goto L13;
            return false;
        L13:
            if (r102 == false) goto L19;
            if (r101 <= 0.05f) goto L22;
            return true;
        L22:
            return false;
        L19:
            if (r101 >= 0.95f) goto L24;
            return true;
        L24:
            return false;
        L23:
            return false;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int r100, float r101, int r102) {
            kn2.n r103 = this.f156345e.f156327n;
            if (r103 == null) goto L7;
            ln2.b r104 = r103.f504158b;
            if ((r104 instanceof ViewPager.OnPageChangeListener) == false) goto L7;
            ((ViewPager.OnPageChangeListener) r104).onPageScrolled(r100, r101, r102);
        L7:
            ILivePreviewCoverView r105 = this.f156343c;
            if (r105 == null) goto L14;
            if (r102 <= 0) goto L14;
            if ((r105 instanceof LivePreviewCoverView) == false) goto L13;
            ((LivePreviewCoverView) r105).n();
        L13:
            this.f156343c.cancelAutoEnterGuide(true);
        L14:
            int r106 = this.f156345e.f156321h.getCurrentItem();
            this.f156344d.put(r106, true);
            if (r100 != r106) goto L20;
            int r107 = r100 + 1;
            if (a(r107, r101, true) == false) goto L25;
            c(r107);
        L25:
            if (r100 == this.f156342b) goto L27;
            return;
        L27:
            if (r101 >= 1.0E-10f) goto L31;
            b(r100, this.f156345e.T90(r100));
            return;
        L31:
            return;
        L20:
            if (r100 != (r106 - 1)) goto L25;
            if (a(r100, r101, false) == false) goto L25;
            c(r100);
            goto L25
        }
    }

    public final void W90() {
        this.f156321h.setAdapter(null);     // Catch: Exception -> L5
    L7:
        if (this.f156324k == null) goto L13;
        LivePreviewCoverView r100 = T90(this.f156321h.getCurrentItem());
        if (r100 == null) goto L12;
        r100.release();
    L12:
        p r101 = this.f156324k;
        r101.f156414b.removeListener(r101.f156415c);
        r101.f156416d.clear();
        this.f156324k = null;
    L13:
        b r102 = this.f156326m;
        if (r102 == null) goto L16;
        r102.f156343c = null;
        this.f156326m = null;
    L16:
        com.bytedance.android.livesdk.live.listprovider.o r103 = this.f156325l;
        if (r103 == null) goto L22;
        r103.release();
        this.f156325l = null;
        return;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePreviewFragment
    public final Fragment self() {
        return this;
    }

    public final LivePreviewCoverView S90() {
        p r100 = this.f156324k;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.getCount() == 0) goto L13;
        LiveVerticalViewPager r101 = this.f156321h;
        if (r101 != null) goto L10;
        return null;
    L10:
        return this.f156324k.h(r101.getCurrentItem());
    L13:
        return null;
    }

    public final void V90() {
        boolean r100 = this.mStatusActive;
        if (r100 == true) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L10;
    L12:
        if (r100 == true) goto L14;
    L16:
        boolean r102 = false;
    L17:
        if (r102 == false) goto L19;
    L21:
        if (r100 == true) goto L23;
    L25:
        boolean r103 = false;
    L26:
        if (r103 == false) goto L28;
        this.A = 0;
        Y90(this.f156321h.getCurrentItem(), true);
        return;
    L28:
        this.A = 1;
        LivePreviewCoverView r104 = T90(this.f156321h.getCurrentItem());
        if (r104 == null) goto L34;
        r104.release();
        return;
    L34:
        return;
    L23:
        if (this.f156339z == false) goto L25;
        r103 = true;
        goto L26
    L19:
        if (this.A != 1) goto L21;
        return;
    L14:
        if (this.f156339z == false) goto L16;
        r102 = true;
        goto L17
    L10:
        if (this.A != 0) goto L12;
        return;
    L5:
        if (this.f156339z == false) goto L7;
        r101 = true;
        goto L8
    }

    public final void X90() {
        int r100 = this.f156321h.getCurrentItem();
        if (r100 >= 0) goto L5;
        return;
    L5:
        p r101 = this.f156324k;
        if (r101 == null) goto L16;
        int r102 = r101.getCount() - r100;
        com.bytedance.android.live.base.model.feed.a r103 = CoreSettingKeys.LIVE_FEED_PRELOAD.getValue();
        if (r103 == null) goto L10;
        int r104 = r103.a();
    L11:
        if (r104 > 0) goto L13;
        r104 = 2;
    L13:
        if (r102 > r104) goto L17;
        this.f156325l.loadMore(r100);
        return;
    L17:
        return;
    L10:
        r104 = 0;
        goto L11
    }

    public FeedLivePreviewFragment() {
        this.f156317d = "";
        this.f156318e = new LiveMetricsParams(EnterFromMerge.LIVE_CHANNEL, EnterMethod.LIVE_CELL);
        this.f156319f = null;
        this.f156328o = new LiveNetworkBroadcastReceiver();
        this.f156329p = 0;
        this.f156331r = false;
        this.f156335v = 0;
        this.f156336w = LiveResUtil.dp2Px(97.0f);
        this.f156337x = null;
        this.f156338y = new a(this);
        this.f156339z = false;
        this.A = 1;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        W90();
        this.f156328o.d();
        this.f156328o.c(this.f156338y);
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        V90();
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        V90();
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
    }

    public final LivePreviewCoverView T90(int r100) {
        p r101 = this.f156324k;
        if (r101 != null) goto L5;
        return null;
    L5:
        if (r101.getCount() != 0) goto L7;
        return null;
    L7:
        if (this.f156321h != null) goto L9;
        return null;
    L9:
        if (this.f156324k.getCount() <= r100) goto L18;
        if (r100 >= 0) goto L13;
        return null;
    L13:
        return this.f156324k.h(r100);
    L18:
        return null;
    }

    public final Room U90(int r100) {
        if (r100 < 0) goto L14;
        com.bytedance.android.livesdk.live.listprovider.o r101 = this.f156325l;
        if (r101 != null) goto L6;
        return null;
    L6:
        if (r100 >= r101.size()) goto L17;
        Room r102 = (Room) ListProtector.get(this.f156325l.f147575b, r100);
        if (r102 != null) goto L10;
        return null;
    L10:
        if (r102.getRoomId() > 0) goto L12;
        return null;
    L12:
        if (r102.mo8271getOwner() == null) goto L20;
        return r102;
    L20:
        return null;
    L17:
        return null;
    L14:
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        Bundle r101 = getArguments();
        W90();
        if (r101 != null) goto L5;
        r101 = new Bundle();
    L5:
        String r102 = this.f156318e.getEnterFromMerge().lowerName();
        String r103 = this.f156318e.getEnterMethod().lowerName();
        String r104 = FeedDraw.conventRequestFrom(r102, r103, new Bundle());
        this.f156317d = com.bytedance.android.live.core.feed.d.a(r102, r103);
        com.bytedance.android.livesdk.live.listprovider.o r105 = new com.bytedance.android.livesdk.live.listprovider.o(r101, this.f156317d, r104, r102 + "-" + r103);
        r105.p();
        this.f156325l = r105;
        int r106 = this.f156329p;
        this.f156324k = new p(this, getActivity(), this.f156325l, this.f156318e);
        this.f156321h.setOffscreenPageLimit(1);
        this.f156321h.setAdapter(this.f156324k);     // Catch: Exception -> L8
    L9:
        this.f156329p = r106;
        this.f156321h.setCurrentItem(r106, false);
        b r107 = new b(this);
        this.f156326m = r107;
        this.f156321h.setOnPageChangeListener(r107);
        kn2.n r108 = kn2.l.b(this.f156322i, this.f156321h);
        this.f156327n = r108;
        if (r108 == null) goto L12;
        r108.f504170n = new q();
        r108.f504174r = true;
    L12:
        this.f156321h.bringToFront();
        this.f156326m.f156343c = S90();
        X90();
        this.f156323j.setEnabled(false);
        this.f156323j.setOnRefreshListener(new i(this));
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        LiveNetworkBroadcastReceiver r101 = this.f156328o;
        FragmentActivity r102 = getActivity();
        TokenCert r103 = LiveNetworkBroadcastReceiver.f158755d;
        r101.b(r102, r103);
        this.f156328o.a(this.f156338y, r103);
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePreviewFragment
    public final void setLiveBorderAnimController(ry.f r100) {
        this.f156319f = r100;
    }

    @Override // androidx.fragment.app.Fragment
    public final void setUserVisibleHint(boolean r100) {
        super.setUserVisibleHint(r100);
        this.f156339z = r100;
        V90();
    }

    public final void Y90(int r100, boolean r101) {
        Room r102 = U90(r100);
        if (r102 != null) goto L5;
        return;
    L5:
        LivePreviewCoverView r103 = T90(r100);
        if (r103 != null) goto L8;
        return;
    L8:
        r103.stream(r102);
        if (r101 == false) goto L12;
        r103.onShow();
        return;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        super.onViewCreated(r100, r101);
        ry.b r102 = this.f156330q;
        if (r102 == null) goto L8;
        HorizontalLiveListView r103 = ((LiveOuterFollowListView) r102).f124252d;
        if (r103 == null) goto L9;
        r103.refresh();
        return;
    L9:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        View r103 = r100.inflate(R.layout.ttlive_feed_live_preview_fragment, r101, false);
        this.f156320g = r103;
        this.f156321h = (LiveVerticalViewPager) r103.findViewById(R.id.viewpager);
        FrameLayout r104 = (FrameLayout) r103.findViewById(R.id.container);
        this.f156322i = r104;
        r104.setBackgroundColor(getResources().getColor(R.color.liveuikit_black));
        LiveSwipeRefreshLayout r105 = (LiveSwipeRefreshLayout) r103.findViewById(R.id.swipe_refresh);
        this.f156323j = r105;
        LiveVerticalViewPager r106 = this.f156321h;
        FrameLayout r107 = this.f156322i;
        r105.E = r106;
        r105.F = r107;
        this.f156332s = (FrameLayout) this.f156320g.findViewById(R.id.follow_view_container);
        TextView r108 = (TextView) this.f156320g.findViewById(R.id.tv_follow_user_count);
        this.f156333t = r108;
        r108.setVisibility(8);
        this.f156334u = (SafeInterceptTouchLayout) this.f156320g.findViewById(R.id.container);
        Bundle r109 = getArguments();
        if (r109 != null) goto L5;
    L22:
        this.f156332s.setVisibility(8);
        this.f156334u.setInterceptTouchEvent(false);
    L23:
        return r103;
    L5:
        if (r109.getBoolean("enable_follow_list_view", false) == false) goto L22;
        ry.d r110 = (ry.d) jc1.k.f(ry.d.class);
        if (r110 == null) goto L10;
        this.f156330q = r110.getFollowListView(getActivity(), r109, this.f156319f);
    L10:
        if (this.f156330q != null) goto L12;
        this.f156332s.setVisibility(8);
        this.f156334u.setInterceptTouchEvent(false);
        goto L23
    L12:
        this.f156332s.setVisibility(0);
        this.f156332s.removeAllViews();
        FrameLayout r111 = this.f156332s;
        HorizontalLiveListView r112 = ((LiveOuterFollowListView) this.f156330q).f124252d;
        HorizontalLiveListView r113 = null;
        if ((r112 instanceof View) == true) goto L15;
        r112 = null;
    L15:
        if (r112 == null) goto L18;
        r113 = r112;
    L18:
        r111.addView(r113, new FrameLayout.LayoutParams(-1, -2));
        ((LiveOuterFollowListView) this.f156330q).a(new e(this));
        ((LiveOuterFollowListView) this.f156330q).b(new f(this));
        ((LiveOuterFollowListView) this.f156330q).c(new g(this));
        this.f156334u.setOnTouchListener(new l(this));
        if (this.f156332s.getVisibility() != 0) goto L21;
        this.f156334u.setInterceptTouchEvent(true);
    L21:
        this.f156333t.setOnClickListener(new h(this));
        goto L23
    }
}
