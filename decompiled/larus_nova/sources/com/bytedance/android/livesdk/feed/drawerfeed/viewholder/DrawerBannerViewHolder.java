package com.bytedance.android.livesdk.feed.drawerfeed.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.livesdk.feed.BannerSwipeRefreshLayout;
import com.bytedance.android.livesdk.feed.banner.BannerViewHolder;
import com.bytedance.android.livesdk.feed.banner.RoundIndicatorView;
import com.bytedance.android.livesdk.feed.banner.adapter.BannerPageAdapter;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class DrawerBannerViewHolder extends BaseViewHolder<FeedItem> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f123843k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewPager f123844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RoundIndicatorView f123845b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BannerPageAdapter f123846c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BannerViewHolder.a f123847d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BannerViewHolder.PageChangeListener f123848e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<com.bytedance.android.live.base.model.banner.a> f123849f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f123850g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f123851h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.bytedance.android.livesdk.feed.l f123852i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ViewGroup f123853j;

    @Override // com.bytedance.android.live.core.viewholder.BaseViewHolder
    public final boolean fullSpan() {
        return true;
    }

    public final void U3() {
        if (this.f123851h == false) goto L22;
        View r100 = this.itemView;
        if (r100 != null) goto L7;
        return;
    L7:
        if (r100.getVisibility() != 0) goto L28;
        T3(this.f123849f);
        List<com.bytedance.android.live.base.model.banner.a> r101 = this.f123849f;
        if (r101 != null) goto L12;
        return;
    L12:
        if (r101.size() <= 1) goto L25;
        ViewPager r102 = this.f123844a;
        if (r102 != null) goto L16;
        return;
    L16:
        if (this.f123845b == null) goto L27;
        BannerViewHolder.PageChangeListener r103 = this.f123848e;
        if (r103 == null) goto L20;
        r103.f123638d = true;
    L20:
        r102.clearOnPageChangeListeners();
        this.f123844a.addOnPageChangeListener(this.f123848e);
        this.f123845b.setViewPager(this.f123844a);
        ViewPager r104 = this.f123844a;
        BannerViewHolder.a r105 = this.f123847d;
        r104.removeCallbacks(r105);
        r104.postDelayed(r105, 5000);
        return;
    L27:
        return;
    L25:
        return;
    L28:
        return;
    }

    public final void V3() {
        this.f123844a.removeCallbacks(this.f123847d);
        this.f123844a.clearOnPageChangeListeners();
        BannerViewHolder.PageChangeListener r100 = this.f123848e;
        if (r100 == null) goto L6;
        r100.f123638d = false;
        return;
    }

    @Override // com.bytedance.android.live.core.viewholder.BaseViewHolder
    public final void onViewAttachedToWindow() {
        super.onViewAttachedToWindow();
        this.f123851h = true;
        BannerViewHolder.PageChangeListener r100 = this.f123848e;
        if (r100 == null) goto L5;
        r100.f123640f = true;
    L5:
        U3();
    }

    @Override // com.bytedance.android.live.core.viewholder.BaseViewHolder
    public final void onViewDetachedFromWindow() {
        super.onViewDetachedFromWindow();
        this.f123851h = false;
        BannerViewHolder.PageChangeListener r100 = this.f123848e;
        if (r100 == null) goto L5;
        r100.f123640f = false;
    L5:
        V3();
    }

    public final void T3(List<com.bytedance.android.live.base.model.banner.a> r100) {
        BannerViewHolder.PageChangeListener r101 = this.f123848e;
        if (r101 == null) goto L5;
        int r102 = r101.f123639e;
    L6:
        if (r100 != null) goto L8;
        return;
    L8:
        if (r100.isEmpty() == false) goto L10;
        return;
    L10:
        if (this.f123851h == false) goto L25;
        com.bytedance.android.live.base.model.banner.a r103 = (com.bytedance.android.live.base.model.banner.a) ListProtector.get(r100, r102 % r100.size());
        HashMap r104 = new HashMap();
        r104.put("show_source", this.f123850g);
        r104.put("banner_id", String.valueOf(r103.getId()));
        r104.put("banner_page", "more_anchor");
        if (e5.n() == false) goto L14;
        String r105 = "landscape";
    L15:
        r104.put("screen_direction", r105);
        String r106 = TTLiveService.getLiveService().getLiveOntologyRecord().getEnterFromMerge();     // Catch: Exception -> L18
    L19:
        r104.put("enter_from_merge", r106);
        r104.put("enter_method", "drawer_cover");
        kw1.c.d("banner_show", r104);
        return;
    L18:
        r106 = "drawer_null";
        goto L19
    L14:
        r105 = "portrait";
        goto L15
    L25:
        return;
    L5:
        r102 = 0;
        goto L6
    }

    @Override // com.bytedance.android.live.core.viewholder.BaseViewHolder
    public final void bind(FeedItem r100, int r101) {
        FeedItem r102 = r100;
        if (r102 == null) goto L70;
        List<com.bytedance.android.live.base.model.banner.a> r103 = r102.banners;
        if (r103 == null) goto L74;
        List<com.bytedance.android.live.base.model.banner.a> r104 = this.f123849f;
        if (r104 == r103) goto L28;
        if (r104 != null) goto L13;
    L26:
        boolean r105 = false;
    L29:
        if (r105 == true) goto L71;
        T3(r103);
        this.f123844a.removeCallbacks(this.f123847d);
        this.f123849f = r103;
        this.f123844a.setAdapter(null);
        if (r103.isEmpty() == true) goto L57;
        ViewGroup.LayoutParams r106 = this.f123844a.getLayoutParams();
        Iterator<com.bytedance.android.live.base.model.banner.a> r107 = r103.iterator();
    L34:
        if (r107.hasNext() == false) goto L40;
        com.bytedance.android.live.base.model.banner.a r108 = r107.next();
        if (r108 == null) goto L34;
        if (r108.h() == 0) goto L34;
        int r109 = (this.f123853j.getMeasuredWidth() * r108.b()) / r108.h();
    L42:
        if (r109 == r106.height) goto L45;
        r106.height = r109;
        this.f123844a.setLayoutParams(r106);
    L45:
        if (this.f123846c != null) goto L47;
        this.f123846c = new BannerPageAdapter(this.itemView.getContext(), LayoutInflater.from(this.itemView.getContext()), this.f123850g, this.f123852i);
    L47:
        BannerPageAdapter r110 = this.f123846c;
        List<com.bytedance.android.live.base.model.banner.a> r111 = this.f123849f;
        ((ArrayList) r110.f123658a).clear();
        if (r111 == null) goto L50;
        ((ArrayList) r110.f123658a).addAll(r111);
    L50:
        r110.notifyDataSetChanged();
        this.f123844a.setAdapter(this.f123846c);
        if (this.f123849f.size() <= 1) goto L56;
        ViewPager r112 = this.f123844a;
        BannerViewHolder.a r113 = this.f123847d;
        r112.removeCallbacks(r113);
        r112.postDelayed(r113, 5000);
        this.f123844a.clearOnPageChangeListeners();
        this.f123844a.addOnPageChangeListener(this.f123848e);
        BannerViewHolder.PageChangeListener r114 = this.f123848e;
        if (r114 == null) goto L55;
        r114.f123638d = true;
    L55:
        this.f123845b.setViewPager(this.f123844a);
        this.f123845b.setVisibility(0);
        this.f123845b.setCount(r103.size());
        this.f123844a.setCurrentItem(this.f123849f.size() * (Integer.MAX_VALUE / (this.f123849f.size() * 2)));
        return;
    L56:
        this.f123845b.setVisibility(8);
        return;
    L40:
        r109 = 0;
        goto L42
    L57:
        ViewGroup.LayoutParams r115 = this.f123844a.getLayoutParams();
        r115.height = 0;
        this.f123844a.setLayoutParams(r115);
        this.f123846c = null;
        this.f123845b.setVisibility(8);
        return;
    L71:
        return;
    L13:
        if (r104.size() != r103.size()) goto L26;
        int r116 = 0;
    L17:
        if (r116 >= r104.size()) goto L28;
        com.bytedance.android.live.base.model.banner.a r117 = (com.bytedance.android.live.base.model.banner.a) ListProtector.get(r104, r116);
        com.bytedance.android.live.base.model.banner.a r118 = (com.bytedance.android.live.base.model.banner.a) ListProtector.get(r103, r116);
        if (r117 != null) goto L21;
    L23:
        if (r118 == null) goto L27;
        if (r118.a(r117) == false) goto L26;
    L27:
        r116 = r116 + 1;
        goto L17
    L21:
        if (r117.a(r118) == true) goto L23;
    L28:
        r105 = true;
        goto L29
    L74:
        return;
    }

    public DrawerBannerViewHolder(View r100, BannerSwipeRefreshLayout.a r101, FeedDataKey r102, PublishSubject<Object> r103, PublishSubject<Object> r104, PublishSubject<Boolean> r105, com.bytedance.android.livesdk.feed.l r106, ViewGroup r110) {
        super(r100);
        this.f123853j = r110;
        ViewPager r111 = (ViewPager) r100.findViewById(R.id.viewpager);
        this.f123844a = r111;
        RoundIndicatorView r107 = (RoundIndicatorView) r100.findViewById(R.id.indicator);
        this.f123845b = r107;
        r100.getContext();
        String r108 = r102.f124004b;
        this.f123850g = r108;
        this.f123852i = r106;
        BannerViewHolder.a r109 = new BannerViewHolder.a(r111);
        this.f123847d = r109;
        r111.removeCallbacks(r109);
        BannerViewHolder.PageChangeListener r112 = new BannerViewHolder.PageChangeListener(r111, r109, r108);
        this.f123848e = r112;
        r111.setOnTouchListener(new a(this));
        r107.setViewPager(r111);
        ViewPager r113 = r107.f123656k;
        if (r113 == null) goto L5;
        r113.addOnPageChangeListener(r112);
    L5:
        if (r101 == null) goto L7;
        r101.a(r111, r100);
    L7:
        r105.subscribe(new b(this), new g60.c());
        r103.subscribe(new c(this), new g60.c());
        r104.subscribe(new d(this), new g60.c());
    }
}
