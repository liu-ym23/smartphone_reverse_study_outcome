package com.bytedance.android.livesdk.preview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.core.setting.CoreSettingKeys;
import com.bytedance.android.live.core.utils.FeedDraw;
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
import com.bytedance.android.livesdkapi.roomplayer.LiveMetricsParams;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes11.dex */
public final class w0 extends FrameLayout implements ty.a {
    public kn2.n A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f156647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f156648b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f156649c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LiveVerticalViewPager f156650d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SafeInterceptTouchLayout f156651e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LiveSwipeRefreshLayout f156652f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ry.f f156653g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Bundle f156654h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f156655i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f156656j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f156657k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final LiveMetricsParams f156658l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public z0 f156659m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public b f156660n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f156661o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f156662p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final LiveNetworkBroadcastReceiver f156663q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final t0 f156664r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ry.b f156665s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public FrameLayout f156666t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public TextView f156667u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f156668v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f156669w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ValueAnimator f156670x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f156671y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public com.bytedance.android.livesdk.live.listprovider.o f156672z;

    public class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w0 f156673a;

        public a(w0 r100) {
            this.f156673a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            super.onAnimationEnd(r100);
            this.f156673a.f156667u.setVisibility(8);
            SafeInterceptTouchLayout r101 = this.f156673a.f156651e;
            if (r101 == null) goto L6;
            r101.setInterceptTouchEvent(true);
            return;
        }
    }

    public class b implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f156674a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f156675b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ILivePreviewCoverView f156676c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final SparseBooleanArray f156677d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ w0 f156678e;

        public b(w0 r100) {
            this.f156678e = r100;
            this.f156674a = 0;
            this.f156675b = -1;
            this.f156676c = null;
            int r101 = r100.f156671y;
            this.f156677d = new SparseBooleanArray();
        }

        public final void c(int r100) {
            z0 r101 = this.f156678e.f156659m;
            if (r101 == null) goto L18;
            int r102 = r101.getCount();
            if (r100 < 0) goto L17;
            if (r100 < r102) goto L10;
            return;
        L10:
            if (this.f156678e.b(r100) != null) goto L13;
            return;
        L13:
            if (this.f156677d.get(r100) == true) goto L21;
            this.f156677d.put(r100, true);
            this.f156678e.h(r100, false);
            return;
        L21:
            return;
        L17:
            return;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int r100) {
            this.f156674a = r100;
            if (r100 != 0) goto L6;
            w0 r101 = this.f156678e;
            r101.f156659m.i(r101.getCurrentPreviewCoverView());
            this.f156677d.clear();
            this.f156677d.put(this.f156678e.f156650d.getCurrentItem(), true);
            return;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int r100) {
            w0 r101 = this.f156678e;
            LiveSwipeRefreshLayout r102 = r101.f156652f;
            if (r100 == 0) goto L5;
        L7:
            boolean r103 = false;
        L8:
            r102.setEnabled(r103);
            this.f156675b = r100;
            if (this.f156674a != 0) goto L12;
            b(r100, this.f156678e.b(r100));
            return;
        L12:
            return;
        L5:
            if (r101.f156657k == false) goto L7;
            r103 = true;
            goto L8
        }

        public final void b(int r100, LivePreviewCoverView r101) {
            if (r101 == null) goto L14;
            ILivePreviewCoverView r102 = this.f156676c;
            if (r101 == r102) goto L15;
            if (r102 == null) goto L9;
            r102.release();
        L9:
            if (r101.k() == false) goto L11;
            r101.onShow();
        L12:
            this.f156676c = r101;
            this.f156675b = -1;
            this.f156678e.g();
            return;
        L11:
            this.f156678e.h(r100, true);
            goto L12
        L15:
            return;
        }

        public final boolean a(int r100, float r101, boolean r102) {
            w0 r103 = this.f156678e;
            if (r103.f156662p == true) goto L5;
            return false;
        L5:
            int r104 = r103.f156659m.getCount();
            if (r100 < 0) goto L26;
            if (r100 < r104) goto L10;
            return false;
        L10:
            if (this.f156678e.b(r100) != null) goto L13;
            return false;
        L13:
            if (this.f156677d.get(r100) == false) goto L16;
            return false;
        L16:
            if (r102 == false) goto L22;
            if (r101 <= 0.05f) goto L25;
            return true;
        L25:
            return false;
        L22:
            if (r101 >= 0.95f) goto L27;
            return true;
        L27:
            return false;
        L26:
            return false;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int r100, float r101, int r102) {
            kn2.n r103 = this.f156678e.A;
            if (r103 == null) goto L7;
            ln2.b r104 = r103.f504158b;
            if ((r104 instanceof ViewPager.OnPageChangeListener) == false) goto L7;
            ((ViewPager.OnPageChangeListener) r104).onPageScrolled(r100, r101, r102);
        L7:
            ILivePreviewCoverView r105 = this.f156676c;
            if (r105 == null) goto L14;
            if (r102 <= 0) goto L14;
            if ((r105 instanceof LivePreviewCoverView) == false) goto L13;
            ((LivePreviewCoverView) r105).n();
        L13:
            this.f156676c.cancelAutoEnterGuide(true);
        L14:
            int r106 = this.f156678e.f156650d.getCurrentItem();
            this.f156677d.put(r106, true);
            if (r100 != r106) goto L20;
            int r107 = r100 + 1;
            if (a(r107, r101, true) == false) goto L25;
            c(r107);
        L25:
            if (r100 == this.f156675b) goto L27;
            return;
        L27:
            if (r101 >= 1.0E-10f) goto L31;
            b(r100, this.f156678e.b(r100));
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

    public final void e() {
        this.f156650d.setAdapter(null);     // Catch: Exception -> L5
    L7:
        if (this.f156659m == null) goto L13;
        LivePreviewCoverView r100 = b(this.f156650d.getCurrentItem());
        if (r100 == null) goto L12;
        r100.release();
    L12:
        z0 r101 = this.f156659m;
        r101.f156414b.removeListener(r101.f156415c);
        r101.f156416d.clear();
        this.f156659m = null;
    L13:
        b r102 = this.f156660n;
        if (r102 == null) goto L16;
        r102.f156676c = null;
        this.f156660n = null;
    L16:
        com.bytedance.android.livesdk.live.listprovider.o r103 = this.f156672z;
        if (r103 == null) goto L22;
        r103.release();
        this.f156672z = null;
        return;
    }

    @Override // ty.a
    public View getView() {
        return this;
    }

    public void setRefreshListener(ty.a.b r100) {
    }

    public final void a() {
        Context r100 = this.f156647a;
        this.f156647a = r100;
        View r101 = LayoutInflater.from(r100).inflate(R.layout.ttlive_preview_layout, this, true);
        this.f156648b = r101;
        this.f156650d = (LiveVerticalViewPager) r101.findViewById(R.id.viewpager);
        SafeInterceptTouchLayout r102 = (SafeInterceptTouchLayout) this.f156648b.findViewById(R.id.container);
        this.f156651e = r102;
        r102.setBackgroundColor(getResources().getColor(R.color.liveuikit_black));
        LiveSwipeRefreshLayout r103 = (LiveSwipeRefreshLayout) this.f156648b.findViewById(R.id.swipe_refresh);
        this.f156652f = r103;
        LiveVerticalViewPager r104 = this.f156650d;
        SafeInterceptTouchLayout r105 = this.f156651e;
        r103.E = r104;
        r103.F = r105;
        if (this.f156655i == false) goto L18;
        this.f156666t = (FrameLayout) this.f156648b.findViewById(R.id.follow_view_container);
        TextView r106 = (TextView) this.f156648b.findViewById(R.id.tv_follow_user_count);
        this.f156667u = r106;
        r106.setVisibility(8);
        ry.d r107 = (ry.d) jc1.k.f(ry.d.class);
        if (r107 == null) goto L8;
        this.f156665s = r107.getFollowListView(this.f156647a, this.f156654h, this.f156653g);
    L8:
        if (this.f156665s != null) goto L10;
        this.f156666t.setVisibility(8);
        this.f156651e.setInterceptTouchEvent(false);
        return;
    L10:
        this.f156666t.removeAllViews();
        FrameLayout r108 = this.f156666t;
        HorizontalLiveListView r109 = ((LiveOuterFollowListView) this.f156665s).f124252d;
        HorizontalLiveListView r110 = null;
        if ((r109 instanceof View) == true) goto L13;
        r109 = null;
    L13:
        if (r109 == null) goto L16;
        r110 = r109;
    L16:
        r108.addView(r110, new FrameLayout.LayoutParams(-1, -2));
        ((LiveOuterFollowListView) this.f156665s).a(new n0(this));
        ((LiveOuterFollowListView) this.f156665s).b(new o0(this));
        ((LiveOuterFollowListView) this.f156665s).c(new p0(this));
        this.f156651e.setOnTouchListener(new q0(this));
        this.f156667u.setOnClickListener(new r0(this));
        return;
    }

    public final void d() {
        UIUtils.updateLayoutMargin(this.f156651e, -3, 0, -3, -3);
        SafeInterceptTouchLayout r100 = this.f156651e;
        if (r100 == null) goto L5;
        r100.setInterceptTouchEvent(false);
    L5:
        UIUtils.setViewVisibility(this.f156667u, 8);
        UIUtils.setViewVisibility(this.f156666t, 8);
    }

    public final void f() {
        if (this.f156668v != 0) goto L6;
        this.f156668v = this.f156666t.getMeasuredHeight();
    L6:
        if (this.f156668v != 0) goto L9;
        this.f156668v = (int) UIUtils.dip2Px(this.f156647a, 100.0f);
    L9:
        if (this.f156668v != 0) goto L11;
        return;
    L11:
        ValueAnimator r100 = this.f156670x;
        if (r100 == null) goto L14;
        r100.removeAllListeners();
        this.f156670x.removeAllUpdateListeners();
        this.f156670x.cancel();
        this.f156670x = null;
    L14:
        ValueAnimator r101 = ValueAnimator.ofInt(new int[]{0, this.f156669w}).setDuration(300);
        this.f156670x = r101;
        r101.addUpdateListener(new u0(this));
        this.f156666t.setVisibility(0);
        this.f156670x.start();
        this.f156667u.animate().alpha(0.0f).scaleY(0.01f).scaleX(0.01f).setDuration(300).setListener(new a(this)).start();
    }

    public final void g() {
        int r100 = this.f156650d.getCurrentItem();
        if (r100 >= 0) goto L5;
        return;
    L5:
        z0 r101 = this.f156659m;
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
        this.f156672z.loadMore(r100);
        return;
    L17:
        return;
    L10:
        r104 = 0;
        goto L11
    }

    public LivePreviewCoverView getCurrentPreviewCoverView() {
        z0 r100 = this.f156659m;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.getCount() == 0) goto L13;
        LiveVerticalViewPager r101 = this.f156650d;
        if (r101 != null) goto L10;
        return null;
    L10:
        return this.f156659m.h(r101.getCurrentItem());
    L13:
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        LiveNetworkBroadcastReceiver r100 = this.f156663q;
        Context r101 = this.f156647a;
        TokenCert r102 = LiveNetworkBroadcastReceiver.f158755d;
        r100.b(r101, r102);
        this.f156663q.a(this.f156664r, r102);
        Bundle r103 = this.f156654h;
        e();
        if (r103 != null) goto L5;
        r103 = new Bundle();
    L5:
        String r104 = this.f156658l.getEnterFromMerge().lowerName();
        String r105 = this.f156658l.getEnterMethod().lowerName();
        String r106 = this.f156654h.getString("enter_from_merge", r104);
        String r107 = this.f156654h.getString("enter_method", r105);
        String r108 = FeedDraw.conventRequestFrom(r106, r107, new Bundle());
        this.f156649c = com.bytedance.android.live.core.feed.d.a(r106, r107);
        com.bytedance.android.livesdk.live.listprovider.o r109 = new com.bytedance.android.livesdk.live.listprovider.o(r103, this.f156649c, r108, r106 + "-" + r107);
        r109.p();
        this.f156672z = r109;
        int r110 = this.f156671y;
        this.f156659m = new z0(this, this.f156647a, r109, this.f156658l);
        this.f156650d.setOffscreenPageLimit(1);
        this.f156650d.setAdapter(this.f156659m);     // Catch: Exception -> L8
    L9:
        this.f156671y = r110;
        this.f156650d.setCurrentItem(r110, false);
        b r111 = new b(this);
        this.f156660n = r111;
        this.f156650d.setOnPageChangeListener(r111);
        kn2.n r112 = kn2.l.b(this.f156651e, this.f156650d);
        this.A = r112;
        if (r112 == null) goto L12;
        r112.f504170n = new a1(this);
        r112.f504174r = true;
    L12:
        this.f156650d.bringToFront();
        this.f156660n.f156676c = getCurrentPreviewCoverView();
        g();
        this.f156652f.setEnabled(false);
        this.f156652f.setOnRefreshListener(new s0(this));
        ry.b r113 = this.f156665s;
        if (r113 != null) goto L15;
        return;
    L15:
        if (this.f156655i == false) goto L23;
        HorizontalLiveListView r114 = ((LiveOuterFollowListView) r113).f124252d;
        if (r114 == null) goto L24;
        r114.refresh();
        return;
    L24:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        e();
        this.f156663q.d();
        this.f156663q.c(this.f156664r);
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.livesdk.preview.t0] */
    public w0(Context r100) {
        super(r100);
        this.f156649c = "";
        this.f156653g = null;
        this.f156654h = new Bundle();
        this.f156655i = false;
        this.f156656j = false;
        this.f156657k = true;
        this.f156658l = new LiveMetricsParams(EnterFromMerge.LIVE_CHANNEL, EnterMethod.LIVE_CELL);
        this.f156661o = true;
        this.f156662p = false;
        this.f156663q = new LiveNetworkBroadcastReceiver();
        this.f156664r = new t0(this);
        this.f156668v = 0;
        this.f156669w = com.bytedance.android.live.core.utils.s1.f(97.0f);
        this.f156670x = null;
        this.f156671y = 0;
        this.f156647a = r100;
    }

    public final LivePreviewCoverView b(int r100) {
        z0 r101 = this.f156659m;
        if (r101 != null) goto L5;
        return null;
    L5:
        if (r101.getCount() != 0) goto L7;
        return null;
    L7:
        if (this.f156650d != null) goto L9;
        return null;
    L9:
        if (this.f156659m.getCount() <= r100) goto L18;
        if (r100 >= 0) goto L13;
        return null;
    L13:
        return this.f156659m.h(r100);
    L18:
        return null;
    }

    public final Room c(int r100) {
        if (r100 < 0) goto L14;
        com.bytedance.android.livesdk.live.listprovider.o r101 = this.f156672z;
        if (r101 != null) goto L6;
        return null;
    L6:
        if (r100 >= r101.size()) goto L17;
        Room r102 = (Room) ListProtector.get(this.f156672z.f147575b, r100);
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

    public final void h(int r100, boolean r101) {
        if (this.f156662p == true) goto L5;
        return;
    L5:
        Room r102 = c(r100);
        if (r102 != null) goto L8;
        return;
    L8:
        LivePreviewCoverView r103 = b(r100);
        if (r103 != null) goto L11;
        return;
    L11:
        r103.stream(r102);
        if (r101 == false) goto L15;
        r103.onShow();
        return;
    }
}
