package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.list.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0007\u000eB'\b\u0007\u0012\u0006\u0010%\u001a\u00020$\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&\u0012\b\b\u0002\u0010(\u001a\u00020\u0002¢\u0006\u0004\b)\u0010*J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0018\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\b\u001a\u0004\b\u0016\u0010\n\"\u0004\b\u0017\u0010\fR\u0011\u0010\u001a\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0011R\u0011\u0010\u001c\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0011R(\u0010#\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006+"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/list/banner/SimpleCarouselViewPager;", "Landroid/widget/FrameLayout;", "", MapController.ITEM_LAYER_TAG, "", "setCurrentItem", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Z", "getEnableAutoCarousel", "()Z", "setEnableAutoCarousel", "(Z)V", "enableAutoCarousel", "b", "I", "getAutoCarouselInterval", "()I", "setAutoCarouselInterval", "(I)V", "autoCarouselInterval", "d", "getEnableInfiniteCarousel", "setEnableInfiniteCarousel", "enableInfiniteCarousel", "getCurrentItem", "currentItem", "getCount", "count", "Landroidx/viewpager/widget/PagerAdapter;", "value", "getAdapter", "()Landroidx/viewpager/widget/PagerAdapter;", "setAdapter", "(Landroidx/viewpager/widget/PagerAdapter;)V", "adapter", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SimpleCarouselViewPager extends FrameLayout {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f84222h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f84223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f84224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f84225c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f84226d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ViewPager f84227e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<ViewPager.OnPageChangeListener, a> f84228f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f84229g;

    public final class a implements ViewPager.OnPageChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ViewPager.OnPageChangeListener f84230a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SimpleCarouselViewPager f84231b;

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrollStateChanged(int r100) {
            if (r100 != 1) goto L5;
            SimpleCarouselViewPager r101 = this.f84231b;
            r101.removeCallbacks(r101.f84225c);
        L7:
            this.f84230a.onPageScrollStateChanged(r100);
            return;
        L5:
            if (r100 != 0) goto L7;
            SimpleCarouselViewPager.a(this.f84231b);
            goto L7
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageSelected(int r100) {
            int r101 = r100 % this.f84231b.getCount();
            this.f84230a.onPageSelected(r100 % this.f84231b.getCount());
        }

        public a(SimpleCarouselViewPager r100, SimpleCarouselIndicator$setViewPager$2$addOnPageChangeListener$1 r101) {
            Intrinsics.checkNotNullParameter(r101, "realListener");
            this.f84231b = r100;
            this.f84230a = r101;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public final void onPageScrolled(int r100, float r101, int r102) {
            this.f84230a.onPageScrolled(r100 % this.f84231b.getCount(), r101, r102);
        }
    }

    public final class b extends PagerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PagerAdapter f84232a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SimpleCarouselViewPager f84233b;

        public static final class a extends DataSetObserver {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f84234a;

            @Override // android.database.DataSetObserver
            public final void onChanged() {
                this.f84234a.notifyDataSetChanged();
                SimpleCarouselViewPager r100 = this.f84234a.f84233b;
                int r101 = SimpleCarouselViewPager.f84222h;
                if (r100.f84226d == true) goto L5;
                return;
            L5:
                if (r100.getCount() <= 0) goto L9;
                r100.f84227e.setCurrentItem(1073741823 - (1073741823 % r100.getCount()));
                return;
            }

            public a(b r100) {
                this.f84234a = r100;
            }
        }

        public final int f() {
            return this.f84232a.getCount();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final int getCount() {
            if (f() != 0) goto L7;
            return 0;
        L7:
            if (this.f84233b.getEnableInfiniteCarousel() == false) goto L10;
            return Integer.MAX_VALUE;
        L10:
            return f();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final void finishUpdate(ViewGroup r100) {
            Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
            super.finishUpdate(r100);
            SimpleCarouselViewPager.a(this.f84233b);
        }

        public b(SimpleCarouselViewPager r100, PagerAdapter r101) {
            Intrinsics.checkNotNullParameter(r101, "realPagerAdapter");
            this.f84233b = r100;
            this.f84232a = r101;
            r101.registerDataSetObserver(new a(this));
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final Object instantiateItem(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
            int r102 = r101 % f();
            return this.f84232a.instantiateItem(r100, r101 % f());
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final boolean isViewFromObject(View r100, Object r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r101, "object");
            return this.f84232a.isViewFromObject(r100, r101);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final void destroyItem(ViewGroup r100, int r101, Object r102) {
            Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
            Intrinsics.checkNotNullParameter(r102, "object");
            int r103 = r101 % f();
            this.f84232a.destroyItem(r100, r101 % f(), r102);
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SimpleCarouselViewPager f84235a;

        public c(SimpleCarouselViewPager r100) {
            this.f84235a = r100;
        }

        public final void a() {
            if (this.f84235a.getCount() > 0) goto L6;
            return;
        L6:
            if (this.f84235a.getEnableInfiniteCarousel() == false) goto L8;
            int r100 = this.f84235a.f84227e.getCurrentItem() + 1;
            this.f84235a.f84227e.setCurrentItem(r100, true);
        L20:
            SimpleCarouselViewPager.a(this.f84235a);
            return;
        L8:
            int r101 = this.f84235a.getCurrentItem() + 1;
            if (r101 != this.f84235a.getCount()) goto L11;
            return;
        L11:
            SimpleCarouselViewPager r102 = this.f84235a;
            int r103 = r102.getCount();
            if (r101 < 0) goto L16;
            if (r103 <= r101) goto L16;
            boolean r104 = true;
        L17:
            if (r104 == false) goto L20;
            int r105 = r102.f84227e.getCurrentItem();
            int r106 = r102.getCurrentItem();
            r102.f84227e.setCurrentItem(r105 + (r101 - r106), true);
        L16:
            r104 = false;
            goto L17
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
    }

    public SimpleCarouselViewPager(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SimpleCarouselViewPager(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final int getCount() {
        b r100 = this.f84229g;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.f();
    }

    public final int getCurrentItem() {
        if (getCount() != 0) goto L6;
        return 0;
    L6:
        return this.f84227e.getCurrentItem() % getCount();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f84225c);
    }

    public final PagerAdapter getAdapter() {
        return this.f84229g;
    }

    public final int getAutoCarouselInterval() {
        return this.f84224b;
    }

    public final boolean getEnableAutoCarousel() {
        return this.f84223a;
    }

    public final boolean getEnableInfiniteCarousel() {
        return this.f84226d;
    }

    public static final void a(SimpleCarouselViewPager r100) {
        if (r100.f84223a == true) goto L5;
        return;
    L5:
        if (r100.f84224b <= 0) goto L10;
        r100.removeCallbacks(r100.f84225c);
        r100.postDelayed(r100.f84225c, r100.f84224b);
        return;
    }

    public final void setAdapter(PagerAdapter r100) {
        if (r100 == null) goto L4;
        b r101 = new b(this, r100);
    L5:
        this.f84229g = r101;
        this.f84227e.setAdapter(r101);
        if (this.f84226d == true) goto L8;
        return;
    L8:
        if (getCount() <= 0) goto L12;
        this.f84227e.setCurrentItem(1073741823 - (1073741823 % getCount()));
        return;
    L12:
        return;
    L4:
        r101 = null;
        goto L5
    }

    public final void setAutoCarouselInterval(int r100) {
        this.f84224b = r100;
    }

    public final void setCurrentItem(int r100) {
        int r101 = getCount();
        if (r100 < 0) goto L7;
        if (r101 <= r100) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L10;
        return;
    L10:
        int r103 = this.f84227e.getCurrentItem();
        int r104 = getCurrentItem();
        this.f84227e.setCurrentItem(r103 + (r100 - r104));
        return;
    L7:
        r102 = false;
        goto L8
    }

    public final void setEnableAutoCarousel(boolean r100) {
        this.f84223a = r100;
    }

    public final void setEnableInfiniteCarousel(boolean r100) {
        this.f84226d = r100;
    }

    public SimpleCarouselViewPager(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f84224b = 3000;
        this.f84225c = new c(this);
        this.f84228f = new LinkedHashMap();
        if (r101 == null) goto L10;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.auto_carousel_interval, R.attr.enable_auto_carousel, R.attr.enable_infinite_carousel});
        this.f84223a = r103.getBoolean(1, false);     // Catch: Throwable -> L7
        this.f84224b = r103.getInt(0, 3000);     // Catch: Throwable -> L7
        this.f84226d = r103.getBoolean(2, false);     // Catch: Throwable -> L7
        r103.recycle();
    L7:
        th = move-exception;
        r103.recycle();
        throw th;
    L10:
        ViewPager r104 = new ViewPager(r100);
        r104.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        Unit r105 = Unit.INSTANCE;
        this.f84227e = r104;
        addView(r104);
    }

    public /* synthetic */ SimpleCarouselViewPager(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
