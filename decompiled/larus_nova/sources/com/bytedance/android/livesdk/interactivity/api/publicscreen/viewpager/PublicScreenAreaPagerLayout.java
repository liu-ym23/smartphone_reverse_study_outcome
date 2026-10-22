package com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.uikit.viewpager.SSViewPager;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.k;
import com.bytedance.android.livesdkapi.feed.tabviewmodel.MultiTabContainerConfig;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0003\u001c\u001d\u001eB\u001d\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003J\u0010\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010\u000e\u001a\u00020\fR\"\u0010\u0015\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/viewpager/PublicScreenAreaPagerLayout;", "Lcom/bytedance/android/live/uikit/viewpager/SSViewPager;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/k;", "", "visible", "", "setPagerTabVisible", "enableSmoothScroll", "setEnableSmoothScroll", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/viewpager/PublicScreenAreaPagerLayout$c;", "listener", "setSwitchListener", "", "getPageCount", "getTabHeight", RXScreenCaptureService.KEY_INDEX, "Z", "getEnableOnTouchEvent", "()Z", "setEnableOnTouchEvent", "(Z)V", "enableOnTouchEvent", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", SlcElement.KEY_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "b", "c", "PublicScreenAreaPagerAdapter", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PublicScreenAreaPagerLayout extends SSViewPager implements k {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f133688q = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<View> f133689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.c> f133690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.b f133691c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f133692d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f133693e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PublicScreenAreaPagerAdapter f133694f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public f f133695g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public c f133696h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f133697i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f133698j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f133699k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f133700l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f133701m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f133702n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f133703o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f133704p;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/viewpager/PublicScreenAreaPagerLayout$PublicScreenAreaPagerAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class PublicScreenAreaPagerAdapter extends PagerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<View> f133706a;

        @Override // androidx.viewpager.widget.PagerAdapter
        public final int getCount() {
            return this.f133706a.size();
        }

        public PublicScreenAreaPagerAdapter(List<View> r100) {
            Intrinsics.checkNotNullParameter(r100, "viewList");
            this.f133706a = r100;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final int getItemPosition(Object r100) {
            Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
            if (CollectionsKt.contains(this.f133706a, r100) == true) goto L7;
            return -2;
        L7:
            return CollectionsKt.indexOf(this.f133706a, r100);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final Object instantiateItem(ViewGroup r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
            View r102 = (View) ListProtector.get(this.f133706a, r101);
            ViewPager.LayoutParams r103 = new ViewPager.LayoutParams();
            ((ViewGroup.LayoutParams) r103).width = -1;
            ((ViewGroup.LayoutParams) r103).height = -2;
            Unit r104 = Unit.INSTANCE;
            r100.addView(r102, r103);
            return ListProtector.get(this.f133706a, r101);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final boolean isViewFromObject(View r100, Object r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r101, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
            return Intrinsics.areEqual(r100, r101);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final void destroyItem(ViewGroup r100, int r101, Object r102) {
            Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
            Intrinsics.checkNotNullParameter(r102, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
            r100.removeView((View) r102);
        }
    }

    public static final class a extends DataSetObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PublicScreenAreaPagerLayout f133707a;

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            PublicScreenAreaPagerLayout r100 = this.f133707a;
            int r101 = PublicScreenAreaPagerLayout.f133688q;
            r100.l();
        }

        public a(PublicScreenAreaPagerLayout r100) {
            this.f133707a = r100;
        }
    }

    public static final class b {
    }

    public interface c {
        void a(com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.c r100);
    }

    static {
        f133688q = s1.j(R.dimen.ttlive_public_screen_indicator_height) + s1.j(R.dimen.ttlive_public_screen_indicator_margin_top);
    }

    public final int getPageCount() {
        return ((ArrayList) this.f133690b).size();
    }

    public final int getTabHeight() {
        Object r100 = this.f133695g;
        if ((r100 instanceof View) == true) goto L5;
        r100 = null;
    L5:
        View r101 = (View) r100;
        if (r101 != null) goto L8;
    L10:
        return 0;
    L8:
        if (r101.getVisibility() != 0) goto L10;
        return f133688q;
    }

    public final void l() {
        Object r100 = null;
        if (this.f133694f.getCount() > 1) goto L5;
    L13:
        f r101 = this.f133695g;
        if ((r101 instanceof View) == false) goto L17;
        r100 = r101;
    L17:
        View r102 = (View) r100;
        if (r102 == null) goto L23;
        r102.setVisibility(8);
        return;
    L23:
        return;
    L5:
        if (this.f133693e == false) goto L13;
        f r103 = this.f133695g;
        if ((r103 instanceof View) == false) goto L10;
        r100 = r103;
    L10:
        View r104 = (View) r100;
        if (r104 == null) goto L21;
        r104.setVisibility(0);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.k
    public final boolean f() {
        return this.f133698j;
    }

    public final boolean getEnableOnTouchEvent() {
        return this.f133697i;
    }

    public PublicScreenAreaPagerLayout(Context r100) {
        this(r100, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        this.f133698j = true;
        int r101 = r100.getAction();
        if (r101 == 3) goto L7;
        if (r101 == 1) goto L7;
        boolean r102 = false;
    L8:
        if (r102 != true) goto L11;
        this.f133698j = false;
    L11:
        if (MultiTabContainerConfig.Companion.getConfig().getEnableGestureIntercept() == false) goto L59;
        IRoomContextService r103 = (IRoomContextService) jc1.k.f(IRoomContextService.class);
        if (r103 == null) goto L22;
        o r104 = IRoomContextService.a.a(r103, null, 0, 3);
        if (r104 == null) goto L22;
        m<Boolean> r105 = r104.H1();
        if (r105 == null) goto L22;
        if (r105.getValue().booleanValue() == false) goto L59;
    L22:
        if (getCurrentItem() != 0) goto L24;
        boolean r106 = true;
    L26:
        if (getCurrentItem() != (this.f133694f.getCount() - 1)) goto L28;
        boolean r107 = true;
    L29:
        int r108 = r100.getAction();
        if (r108 == 0) goto L55;
        if (r108 != 1) goto L33;
    L54:
        getParent().requestDisallowInterceptTouchEvent(false);
        this.f133704p = false;
    L57:
        return super.dispatchTouchEvent(r100);
    L33:
        if (r108 == 2) goto L36;
        if (r108 == 3) goto L54;
    L36:
        float r109 = r100.getX() - this.f133701m;
        if (Math.abs(r109) <= Math.abs(r100.getY() - this.f133702n)) goto L52;
        float r110 = 0;
        if (r109 <= r110) goto L45;
        if (r106 == false) goto L45;
        if (this.f133703o == true) goto L45;
        getParent().requestDisallowInterceptTouchEvent(false);
    L45:
        if (r109 >= r110) goto L50;
        if (r107 == false) goto L50;
        if (this.f133703o == true) goto L50;
        getParent().requestDisallowInterceptTouchEvent(false);
    L50:
        getParent().requestDisallowInterceptTouchEvent(true);
        this.f133703o = true;
        goto L57
    L52:
        if (this.f133704p == false) goto L57;
        this.f133704p = false;
        getParent().requestDisallowInterceptTouchEvent(false);
        goto L57
    L55:
        this.f133701m = r100.getX();
        this.f133702n = r100.getY();
        this.f133703o = false;
        getParent().requestDisallowInterceptTouchEvent(true);
        this.f133704p = true;
        goto L57
    L28:
        r107 = false;
        goto L29
    L24:
        r106 = false;
    L59:
        return super.dispatchTouchEvent(r100);
    L7:
        r102 = true;
        goto L8
    }

    public final void h(com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.c r100) {
        Intrinsics.checkNotNullParameter(r100, "page");
        com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.b r101 = this.f133691c;
        if (r101 != null) goto L5;
        return;
    L5:
        View r102 = r100.B5(r101);
        r100.A5(r101);
        if (r100.getPageType() == PublicScreenAreaPageType.Square) goto L8;
    L10:
        ((ArrayList) this.f133690b).add(r100);
        ((ArrayList) this.f133689a).add(r102);
    L11:
        f r103 = this.f133695g;
        if (r103 == null) goto L18;
        List<com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.c> r104 = this.f133690b;
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator r106 = ((ArrayList) r104).iterator();
    L15:
        if (r106.hasNext() == false) goto L17;
        r105.add(((com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.c) r106.next()).getPageType());
        goto L15
    L17:
        r103.b(r105);
    L18:
        this.f133694f.notifyDataSetChanged();
        return;
    L8:
        if ((!((ArrayList) this.f133690b).isEmpty()) == false) goto L10;
        ListProtector.add(this.f133690b, 1, r100);
        ListProtector.add(this.f133689a, 1, r102);
        goto L11
    }

    public final boolean i(PublicScreenAreaPageType r100) {
        Intrinsics.checkNotNullParameter(r100, "pageType");
        Iterator r101 = ((ArrayList) this.f133690b).iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L12;
        if (((com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.c) r101.next()).getPageType() != r100) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == true) goto L13;
        r102 = r102 + 1;
    L13:
        if (r102 < 0) goto L18;
        return true;
    L18:
        return false;
    L8:
        r103 = false;
        goto L9
    L12:
        r102 = -1;
        goto L13
    }

    public final void j(final PublicScreenAreaPageType r100) {
        Intrinsics.checkNotNullParameter(r100, "pageType");
        Function1<com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.c, Boolean> r101 = new PublicScreenAreaPagerLayout$removePages$removeCondition$1(r100);
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = this.f133690b.iterator();
        int r104 = 0;
    L4:
        if (r103.hasNext() == false) goto L9;
        if (r101.invoke((com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.c) r103.next()).booleanValue() == false) goto L8;
        r102.add(Integer.valueOf(r104));
    L8:
        r104 = r104 + 1;
        goto L4
    L9:
        CollectionsKt.sortDescending(r102);
        Iterator r105 = r102.iterator();
    L11:
        if (r105.hasNext() == false) goto L16;
        int r106 = ((Number) r105.next()).intValue();
        com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.b r107 = this.f133691c;
        if (r107 == null) goto L15;
        ((com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.c) ListProtector.get(this.f133690b, r106)).C5(r107);
    L15:
        ListProtector.remove(this.f133690b, r106);
        ListProtector.remove(this.f133689a, r106);
        goto L11
    L16:
        f r108 = this.f133695g;
        if (r108 == null) goto L23;
        List<com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.c> r109 = this.f133690b;
        ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r109, 10));
        Iterator<T> r111 = r109.iterator();
    L20:
        if (r111.hasNext() == false) goto L22;
        r110.add(((com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.c) r111.next()).getPageType());
        goto L20
    L22:
        r108.b(r110);
    L23:
        this.f133694f.notifyDataSetChanged();
    }

    @Override // com.bytedance.android.live.uikit.viewpager.SSViewPager, androidx.viewpager.widget.ViewPager, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.f133697i == true) goto L7;
        return false;
    L7:
        return super.onTouchEvent(r100);
    }

    public final void setEnableOnTouchEvent(boolean r100) {
        this.f133697i = r100;
    }

    public final void setEnableSmoothScroll(boolean r100) {
        this.f133692d = r100;
    }

    public final void setPagerTabVisible(boolean r100) {
        this.f133693e = r100;
        l();
    }

    public final void setSwitchListener(c r100) {
        this.f133696h = r100;
    }

    public PublicScreenAreaPagerLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f133692d = true;
        this.f133693e = true;
        this.f133697i = true;
        ArrayList r102 = new ArrayList();
        this.f133689a = r102;
        this.f133690b = new ArrayList();
        PublicScreenAreaPagerAdapter r103 = new PublicScreenAreaPagerAdapter(r102);
        this.f133694f = r103;
        setAdapter(r103);
        r103.registerDataSetObserver(new a(this));
        addOnPageChangeListener(new AnonymousClass2(this));
        this.f133699k = "slide_bottom_tab";
        this.f133700l = "slide_bottom_tab";
    }

    public final void k(PublicScreenAreaPageType r100, PublicScreenAreaPageChangeSource r101) {
        Intrinsics.checkNotNullParameter(r100, "pageType");
        Intrinsics.checkNotNullParameter(r101, "triggerSource");
        Iterator r102 = ((ArrayList) this.f133690b).iterator();
        int r103 = 0;
    L4:
        if (r102.hasNext() == false) goto L12;
        if (((com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.c) r102.next()).getPageType() != r100) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == true) goto L13;
        r103 = r103 + 1;
    L13:
        if (r103 == (-1)) goto L28;
        if (r103 > 0) goto L16;
    L24:
        setCurrentItem(r103, this.f133692d);
        return;
    L16:
        switch(i.f133711a[r101.ordinal()]) {
            case 1: goto L22;
            case 2: goto L21;
            case 3: goto L20;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L18;
            default: goto L17;
        };
    L17:
        String r105 = "slide_bottom_tab";
    L23:
        this.f133700l = r105;
        goto L24
    L18:
        r105 = "manage";
        goto L23
    L19:
        r105 = "click_entry";
        goto L23
    L20:
        r105 = "join";
        goto L23
    L21:
        r105 = "create";
        goto L23
    L22:
        r105 = "click_bottom_tab";
        goto L23
    L28:
        return;
    L8:
        r104 = false;
        goto L9
    L12:
        r103 = -1;
        goto L13
    }
}
