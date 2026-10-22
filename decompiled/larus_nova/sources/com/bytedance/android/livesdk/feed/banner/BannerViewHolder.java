package com.bytedance.android.livesdk.feed.banner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.livesdk.feed.BannerSwipeRefreshLayout;
import com.bytedance.android.livesdk.feed.banner.adapter.BannerPageAdapter;
import com.bytedance.android.livesdk.feed.feed.FeedDataKey;
import com.bytedance.android.livesdk.feed.l;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import io.reactivex.subjects.PublishSubject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kw1.c;
import ov1.b;
import ov1.d;
import ov1.e;

/* JADX INFO: loaded from: classes8.dex */
public class BannerViewHolder extends BaseViewHolder<FeedItem> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f123624k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewPager f123625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RoundIndicatorView f123626b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BannerPageAdapter f123627c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f123628d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PageChangeListener f123629e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<com.bytedance.android.live.base.model.banner.a> f123630f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f123631g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f123632h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f123633i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final l f123634j;

    public static class PageChangeListener implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ViewPager f123635a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a f123636b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f123637c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f123638d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f123639e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f123640f;

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int r100) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int r100, float r101, int r102) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int r100) {
            this.f123639e = r100;
            if (this.f123638d == true) goto L5;
            return;
        L5:
            ViewPager r101 = this.f123635a;
            a r102 = this.f123636b;
            int r103 = BannerViewHolder.f123624k;
            r101.removeCallbacks(r102);
            r101.postDelayed(r102, 5000);
            if (this.f123640f == true) goto L9;
            return;
        L9:
            if (((BannerPageAdapter) this.f123635a.getAdapter()) != null) goto L11;
            return;
        L11:
            BannerPageAdapter r104 = (BannerPageAdapter) this.f123635a.getAdapter();
            List<com.bytedance.android.live.base.model.banner.a> r105 = r104.f123658a;
            if (r105 != null) goto L14;
        L18:
            com.bytedance.android.live.base.model.banner.a r106 = null;
        L19:
            if (r106 != null) goto L21;
            return;
        L21:
            HashMap r107 = new HashMap();
            r107.put("show_source", this.f123637c);
            r107.put("banner_id", String.valueOf(r106.getId()));
            r107.put("banner_page", "more_anchor");
            List<com.bytedance.android.live.base.model.banner.a> r108 = ((BannerPageAdapter) this.f123635a.getAdapter()).f123658a;
            if (r108 != null) goto L24;
            int r109 = 0;
        L26:
            if (r109 <= 0) goto L28;
            r107.put("index", String.valueOf((this.f123639e % r109) + 1));
        L28:
            c.d("banner_show", r107);
            ViewPager r110 = this.f123635a;
            if ((r110 instanceof BannerViewPager) == false) goto L39;
            final BannerViewPager r111 = (BannerViewPager) r110;
            MotionEvent r112 = r111.f123645c;
            if (r112 != null) goto L33;
        L36:
            r111.post(new e(r111));
        L37:
            Logger.d("BannerViewPager", "onPageSelected ");
            return;
        L33:
            if (r112.getAction() == 3) goto L36;
            if (r111.f123645c.getAction() != 1) goto L37;
        L39:
            return;
        L24:
            r109 = ((ArrayList) r108).size();
            goto L26
        L14:
            if (((ArrayList) r105).isEmpty() == true) goto L18;
            if (r100 < 0) goto L18;
            int r113 = r100 % ((ArrayList) r104.f123658a).size();
            r106 = (com.bytedance.android.live.base.model.banner.a) ListProtector.get(r104.f123658a, r113);
            goto L19
        }

        public PageChangeListener(ViewPager r100, a r101, String r102) {
            this.f123639e = 0;
            this.f123640f = true;
            this.f123635a = r100;
            this.f123636b = r101;
            this.f123637c = r102;
        }
    }

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ViewPager f123641a;

        public final void a() {
            Field r100 = ViewPager.class.getDeclaredField("mFirstLayout");     // Catch: Exception -> L5
            r100.setAccessible(true);     // Catch: Exception -> L5
            r100.set(this.f123641a, Boolean.FALSE);     // Catch: Exception -> L5
            r100.setAccessible(false);     // Catch: Exception -> L5
            Class r101 = Integer.TYPE;     // Catch: Exception -> L5
            Class r102 = Boolean.TYPE;     // Catch: Exception -> L5
            Method r103 = ViewPager.class.getDeclaredMethod("setCurrentItemInternal", new Class[]{r101, r102, r102, r101});     // Catch: Exception -> L5
            r103.setAccessible(true);     // Catch: Exception -> L5
            ViewPager r104 = this.f123641a;     // Catch: Exception -> L5
            Boolean r105 = Boolean.TRUE;     // Catch: Exception -> L5
            r103.invoke(r104, new Object[]{Integer.valueOf(r104.getCurrentItem() + 1), r105, r105, 1});     // Catch: Exception -> L5
            r103.setAccessible(false);     // Catch: Exception -> L5
            return;
        L5:
            ViewPager r106 = this.f123641a;
            r106.setCurrentItem(r106.getCurrentItem() + 1);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(ViewPager r100) {
            this.f123641a = r100;
        }
    }

    @Override // com.bytedance.android.live.core.viewholder.BaseViewHolder
    public final boolean fullSpan() {
        return true;
    }

    public final void U3() {
        if (this.f123633i == false) goto L22;
        View r100 = this.itemView;
        if (r100 != null) goto L7;
        return;
    L7:
        if (r100.getVisibility() != 0) goto L28;
        T3(this.f123630f);
        List<com.bytedance.android.live.base.model.banner.a> r101 = this.f123630f;
        if (r101 != null) goto L12;
        return;
    L12:
        if (r101.size() <= 1) goto L25;
        ViewPager r102 = this.f123625a;
        if (r102 != null) goto L16;
        return;
    L16:
        if (this.f123626b == null) goto L27;
        PageChangeListener r103 = this.f123629e;
        if (r103 == null) goto L20;
        r103.f123638d = true;
    L20:
        r102.clearOnPageChangeListeners();
        this.f123625a.addOnPageChangeListener(this.f123629e);
        this.f123626b.setViewPager(this.f123625a);
        ViewPager r104 = this.f123625a;
        a r105 = this.f123628d;
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
        this.f123625a.removeCallbacks(this.f123628d);
        this.f123625a.clearOnPageChangeListeners();
        PageChangeListener r100 = this.f123629e;
        if (r100 == null) goto L6;
        r100.f123638d = false;
        return;
    }

    @Override // com.bytedance.android.live.core.viewholder.BaseViewHolder
    public final void onViewAttachedToWindow() {
        super.onViewAttachedToWindow();
        this.f123633i = true;
        PageChangeListener r100 = this.f123629e;
        if (r100 == null) goto L5;
        r100.f123640f = true;
    L5:
        U3();
    }

    @Override // com.bytedance.android.live.core.viewholder.BaseViewHolder
    public final void onViewDetachedFromWindow() {
        super.onViewDetachedFromWindow();
        this.f123633i = false;
        PageChangeListener r100 = this.f123629e;
        if (r100 == null) goto L5;
        r100.f123640f = false;
    L5:
        V3();
    }

    public final void T3(List<com.bytedance.android.live.base.model.banner.a> r100) {
        PageChangeListener r101 = this.f123629e;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.f123639e;
    L6:
        if (r100 != null) goto L8;
        return;
    L8:
        if (r100.isEmpty() == false) goto L10;
        return;
    L10:
        if (this.f123633i == false) goto L21;
        int r104 = r103 % r100.size();
        com.bytedance.android.live.base.model.banner.a r105 = (com.bytedance.android.live.base.model.banner.a) ListProtector.get(r100, r104);
        HashMap r106 = new HashMap();
        r106.put("show_source", this.f123632h);
        r106.put("banner_id", String.valueOf(r105.getId()));
        r106.put("banner_page", "more_anchor");
        List<com.bytedance.android.live.base.model.banner.a> r107 = ((BannerPageAdapter) this.f123625a.getAdapter()).f123658a;
        if (r107 == null) goto L15;
        r102 = ((ArrayList) r107).size();
    L15:
        if (r102 <= 0) goto L17;
        r106.put("index", String.valueOf((r104 % r102) + 1));
    L17:
        c.d("banner_show", r106);
        return;
    L21:
        return;
    L5:
        r103 = 0;
        goto L6
    }

    @Override // com.bytedance.android.live.core.viewholder.BaseViewHolder
    public final void bind(FeedItem r100, int r101) {
        FeedItem r102 = r100;
        if (r102 == null) goto L70;
        List<com.bytedance.android.live.base.model.banner.a> r103 = r102.banners;
        if (r103 == null) goto L74;
        List<com.bytedance.android.live.base.model.banner.a> r104 = this.f123630f;
        if (r104 == r103) goto L28;
        if (r104 != null) goto L13;
    L26:
        boolean r105 = false;
    L29:
        if (r105 == true) goto L71;
        T3(r103);
        this.f123625a.removeCallbacks(this.f123628d);
        this.f123630f = r103;
        this.f123625a.setAdapter(null);
        if (r103.isEmpty() == true) goto L57;
        ViewGroup.LayoutParams r106 = this.f123625a.getLayoutParams();
        Iterator<com.bytedance.android.live.base.model.banner.a> r107 = r103.iterator();
    L34:
        if (r107.hasNext() == false) goto L40;
        com.bytedance.android.live.base.model.banner.a r108 = r107.next();
        if (r108 == null) goto L34;
        if (r108.h() == 0) goto L34;
        int r109 = (UIUtils.getScreenWidth(this.f123631g) * r108.b()) / r108.h();
    L42:
        if (r109 == r106.height) goto L45;
        r106.height = r109;
        this.f123625a.setLayoutParams(r106);
    L45:
        if (this.f123627c != null) goto L47;
        this.f123627c = new BannerPageAdapter(this.itemView.getContext(), LayoutInflater.from(this.itemView.getContext()), this.f123632h, this.f123634j);
    L47:
        BannerPageAdapter r110 = this.f123627c;
        List<com.bytedance.android.live.base.model.banner.a> r111 = this.f123630f;
        ((ArrayList) r110.f123658a).clear();
        if (r111 == null) goto L50;
        ((ArrayList) r110.f123658a).addAll(r111);
    L50:
        r110.notifyDataSetChanged();
        this.f123625a.setAdapter(this.f123627c);
        if (this.f123630f.size() <= 1) goto L56;
        ViewPager r112 = this.f123625a;
        a r113 = this.f123628d;
        r112.removeCallbacks(r113);
        r112.postDelayed(r113, 5000);
        this.f123625a.clearOnPageChangeListeners();
        this.f123625a.addOnPageChangeListener(this.f123629e);
        PageChangeListener r114 = this.f123629e;
        if (r114 == null) goto L55;
        r114.f123638d = true;
    L55:
        this.f123626b.setViewPager(this.f123625a);
        this.f123626b.setVisibility(0);
        this.f123626b.setCount(r103.size());
        this.f123625a.setCurrentItem(this.f123630f.size() * (Integer.MAX_VALUE / (this.f123630f.size() * 2)));
        return;
    L56:
        this.f123626b.setVisibility(8);
        return;
    L40:
        r109 = 0;
        goto L42
    L57:
        ViewGroup.LayoutParams r115 = this.f123625a.getLayoutParams();
        r115.height = 0;
        this.f123625a.setLayoutParams(r115);
        this.f123627c = null;
        this.f123626b.setVisibility(8);
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

    public BannerViewHolder(View r100, BannerSwipeRefreshLayout.a r101, FeedDataKey r102, PublishSubject<Object> r103, PublishSubject<Object> r104, PublishSubject<Boolean> r105, l r110) {
        super(r100);
        ViewPager r106 = (ViewPager) r100.findViewById(R.id.viewpager);
        this.f123625a = r106;
        RoundIndicatorView r107 = (RoundIndicatorView) r100.findViewById(R.id.indicator);
        this.f123626b = r107;
        this.f123631g = r100.getContext();
        String r108 = r102.f124004b;
        this.f123632h = r108;
        this.f123634j = r110;
        a r111 = new a(r106);
        this.f123628d = r111;
        r106.removeCallbacks(r111);
        PageChangeListener r109 = new PageChangeListener(r106, r111, r108);
        this.f123629e = r109;
        r106.setOnTouchListener(new ov1.a(this));
        r107.setViewPager(r106);
        ViewPager r112 = r107.f123656k;
        if (r112 == null) goto L5;
        r112.addOnPageChangeListener(r109);
    L5:
        if (r101 == null) goto L7;
        r101.a(r106, r100);
    L7:
        r105.subscribe(new b(this), new g60.c());
        r103.subscribe(new ov1.c(this), new g60.c());
        r104.subscribe(new d(this), new g60.c());
    }
}
