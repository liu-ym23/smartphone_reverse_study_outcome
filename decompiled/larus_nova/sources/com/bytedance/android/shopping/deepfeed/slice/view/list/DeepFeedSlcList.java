package com.bytedance.android.shopping.deepfeed.slice.view.list;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.shopping.deepfeed.slice.service.e;
import com.bytedance.android.shopping.deepfeed.slice.view.video.DeepFeedSliceVideoView;
import com.bytedance.android.shopping.deepfeed.ui.DeepFeedProductBannerIndicatorAnimator;
import com.bytedance.android.shopping.deepfeed.ui.DeepFeedProductOverScrollPagerSnapHelper;
import com.bytedance.android.shopping.feed.utils.f0;
import com.bytedance.android.shopping.inflow.cardui.product.header.layoutmanager.SmoothScrollLayoutManager;
import com.bytedance.android.shopping.widget.banner.PrimeHorizontalRecyclerView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/slice/view/list/DeepFeedSlcList;", "Lcom/bytedance/android/shopping/widget/banner/PrimeHorizontalRecyclerView;", "Lcom/bytedance/android/shopping/deepfeed/ui/b;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedSlcList extends PrimeHorizontalRecyclerView implements com.bytedance.android.shopping.deepfeed.ui.b {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f173558p = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DeepFeedProductOverScrollPagerSnapHelper f173559f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final OrientationHelper f173560g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public DeepFeedProductBannerIndicatorAnimator f173561h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f173562i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f173563j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public SlcTemplateContext f173564k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f173565l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f173566m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public c f173567n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final a f173568o;

    public static final class a implements com.bytedance.android.shopping.deepfeed.slice.service.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DeepFeedSlcList f173569a;

        @Override // com.bytedance.android.shopping.deepfeed.slice.service.a
        public final void onDestroy() {
        }

        @Override // com.bytedance.android.shopping.deepfeed.slice.service.a
        public final void onPause() {
        }

        @Override // com.bytedance.android.shopping.deepfeed.slice.service.a
        public final void onResume() {
            if (this.f173569a.isAttachedToWindow() == true) goto L5;
            return;
        L5:
            DeepFeedSlcList r100 = this.f173569a;
            r100.f173559f.f173727e = false;
            if (r100.f173567n.f173590a == false) goto L9;
            r100.C();
            return;
        }

        @Override // com.bytedance.android.shopping.deepfeed.slice.service.a
        public final void onStop() {
            if (this.f173569a.isAttachedToWindow() == true) goto L5;
            return;
        L5:
            DeepFeedSlcList r100 = this.f173569a;
            int r101 = 0;
            if (r100.f173567n.f173597h == false) goto L39;
            r100.D();
            DeepFeedSlcList r102 = this.f173569a;
            DeepFeedSlcListAdapter r103 = r102.v();
            if (r103 != null) goto L10;
            r101 = r102.f173563j;
        L37:
            r102.B(r101);
            return;
        L10:
            int r104 = r103.f173573a.size();
            if (r104 <= 0) goto L37;
            Integer r105 = null;
            View r106 = f0.a(r102, r102.f173560g, null);
            if (r106 == null) goto L22;
            RecyclerView.LayoutManager r107 = r102.getLayoutManager();
            if ((r107 instanceof LinearLayoutManager) == true) goto L19;
            r107 = null;
        L19:
            LinearLayoutManager r108 = (LinearLayoutManager) r107;
            if (r108 == null) goto L22;
            r105 = Integer.valueOf(r108.getPosition(r106));
        L22:
            if (r105 == null) goto L35;
            int r109 = r105.intValue();
            int r110 = r103.f173573a.size();
            if (r110 > 0) goto L27;
        L31:
            r109 = 0;
        L36:
            r101 = RangesKt.coerceIn(r109, 0, r104 - 1);
            goto L37
        L27:
            if (r103.f173578f == true) goto L32;
            if (r109 < r110) goto L36;
            if (r109 == r110) goto L31;
        L34:
            r109 = r110 - 1;
            goto L36
        L32:
            if (r109 >= r110) goto L34;
        L35:
            r109 = r102.f173563j;
            goto L36
        L39:
            r100.smoothScrollToPosition(0);
            this.f173569a.A();
        }

        public a(DeepFeedSlcList r100) {
            this.f173569a = r100;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DeepFeedSlcList f173570a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f173571b;

        public b(DeepFeedSlcList r100, int r101) {
            this.f173570a = r100;
            this.f173571b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            DeepFeedSlcList r100 = this.f173570a;     // Catch: Throwable -> L4
            int r101 = this.f173571b;     // Catch: Throwable -> L4
            int r102 = DeepFeedSlcList.f173558p;     // Catch: Throwable -> L4
            r100.B(r101);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public DeepFeedSlcList(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public DeepFeedSlcList(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void A() {
        this.f173563j = 0;
        scrollToPosition(0);
        e r100 = x();
        if (r100 == null) goto L6;
        r100.reset();
    L6:
        if (this.f173567n.f173596g == false) goto L8;
        post(new com.bytedance.android.shopping.deepfeed.slice.view.list.b(this, u(0)));
    L8:
        D();
        RecyclerView.Adapter r101 = getAdapter();
        if ((r101 instanceof DeepFeedSlcListAdapter) == true) goto L11;
        r101 = null;
    L11:
        DeepFeedSlcListAdapter r102 = (DeepFeedSlcListAdapter) r101;
        if (r102 == null) goto L14;
        r102.f173578f = false;
    L14:
        this.f173559f.f173725c = false;
    }

    public final void C() {
        if (this.f173566m == false) goto L5;
        return;
    L5:
        DeepFeedProductBannerIndicatorAnimator r100 = this.f173561h;
        if (r100 == null) goto L8;
        r100.b();
    L8:
        this.f173562i = true;
        this.f173565l = true;
    }

    public final void D() {
        DeepFeedProductBannerIndicatorAnimator r100 = this.f173561h;
        if (r100 == null) goto L5;
        r100.c();
    L5:
        this.f173562i = false;
    }

    public final boolean t() {
        c r100 = this.f173567n;
        if (r100 != null) goto L5;
    L9:
        return false;
    L5:
        if (r100.f173591b != true) goto L9;
        if (this.f173565l == false) goto L9;
        return true;
    }

    public final com.bytedance.android.shopping.deepfeed.slice.service.b w() {
        SlcTemplateContext r100 = this.f173564k;
        Object r101 = null;
        if (r100 == null) goto L10;
        Object r102 = r100.o(com.bytedance.android.shopping.deepfeed.slice.service.b.class);
        if ((r102 instanceof com.bytedance.android.shopping.deepfeed.slice.service.b) == false) goto L9;
        r101 = r102;
    L9:
        return (com.bytedance.android.shopping.deepfeed.slice.service.b) r101;
    L10:
        return null;
    }

    public final e x() {
        SlcTemplateContext r100 = this.f173564k;
        Object r101 = null;
        if (r100 == null) goto L10;
        Object r102 = r100.o(e.class);
        if ((r102 instanceof e) == false) goto L9;
        r101 = r102;
    L9:
        return (e) r101;
    L10:
        return null;
    }

    public final DeepFeedSliceVideoView y() {
        RecyclerView.ViewHolder r100 = findViewHolderForAdapterPosition(this.f173563j);
        View r101 = null;
        if ((r100 instanceof DeepFeedSlcElementVH) == true) goto L5;
        r100 = null;
    L5:
        DeepFeedSlcElementVH r102 = (DeepFeedSlcElementVH) r100;
        if (r102 != null) goto L8;
        return null;
    L8:
        View r103 = z(r102.f173557a);
        if ((r103 instanceof DeepFeedSliceVideoView) == false) goto L13;
        r101 = r103;
    L13:
        return (DeepFeedSliceVideoView) r101;
    }

    public final DeepFeedSlcListAdapter v() {
        RecyclerView.Adapter r100 = getAdapter();
        if ((r100 instanceof DeepFeedSlcListAdapter) == true) goto L6;
        r100 = null;
    L6:
        return (DeepFeedSlcListAdapter) r100;
    }

    public static View z(View r100) {
        if ((r100 instanceof ad3.b) == false) goto L5;
        return r100;
    L5:
        if ((r100 instanceof DeepFeedSliceVideoView) == false) goto L7;
        return r100;
    L7:
        if ((r100 instanceof com.bytedance.android.shopping.deepfeed.slice.view.live.b) == false) goto L10;
        return r100;
    L10:
        if ((r100 instanceof ViewGroup) == false) goto L17;
        ViewGroup r101 = (ViewGroup) r100;
        int r102 = r101.getChildCount();
        int r103 = 0;
    L12:
        if (r103 >= r102) goto L17;
        View r104 = z(r101.getChildAt(r103));
        if (r104 != null) goto L15;
        r103 = r103 + 1;
        goto L12
    L15:
        return r104;
    L17:
        return null;
    }

    public final void B(int r100) {
        DeepFeedSlcListAdapter r101 = v();
        if (r101 == null) goto L22;
        int r102 = r101.f173573a.size();
        if (r102 > 0) goto L7;
        return;
    L7:
        int r103 = RangesKt.coerceIn(r100, 0, r102 - 1);
        int r104 = this.f173563j;
        D();
        this.f173565l = false;
        this.f173559f.f173725c = false;
        DeepFeedSlcListAdapter r105 = v();
        if (r105 == null) goto L10;
        r105.f173578f = false;
    L10:
        this.f173563j = r103;
        e r106 = x();
        if (r106 == null) goto L14;
        r106.k(r103, r104, false);
    L14:
        if (isComputingLayout() == false) goto L16;
    L20:
        post(new b(this, r100));
        return;
    L16:
        if (getScrollState() != 0) goto L20;
        scrollToPosition(r103);
        return;
    }

    public final void E(c r100) {
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_PROPS);
        c r101 = this.f173567n;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_PROPS);
        if (r101.f173590a == r100.f173590a) goto L5;
    L19:
        boolean r102 = false;
    L20:
        if (r102 == false) goto L22;
        return;
    L22:
        c r103 = this.f173567n;
        Integer r104 = r103.f173595f;
        boolean r105 = r103.f173590a;
        if (r105 == false) goto L25;
    L33:
        if (r105 == true) goto L35;
    L37:
        com.bytedance.android.shopping.deepfeed.slice.service.b r106 = w();
        if (r106 == null) goto L40;
        r106.K(this.f173568o);
    L40:
        RecyclerView.Adapter r107 = getAdapter();
        if ((r107 instanceof DeepFeedSlcListAdapter) == true) goto L43;
        r107 = null;
    L43:
        DeepFeedSlcListAdapter r108 = (DeepFeedSlcListAdapter) r107;
        if (r108 == null) goto L46;
        boolean r109 = r100.f173591b;
        boolean r110 = r100.f173592c;
        r108.f173577e = r109;
        r108.f173576d = r110;
    L46:
        this.f173567n = r100;
        Integer r111 = r100.f173595f;
        if (r111 != null) goto L49;
        return;
    L49:
        if ((!Intrinsics.areEqual(r111, r104)) == false) goto L58;
        Integer r112 = r100.f173595f;
        int r113 = this.f173563j;
        if (r112 != null) goto L54;
    L55:
        B(r100.f173595f.intValue());
        return;
    L54:
        if (r112.intValue() != r113) goto L55;
        return;
    L58:
        return;
    L35:
        if (r100.f173590a == true) goto L37;
        A();
        goto L37
    L25:
        if (r100.f173590a == false) goto L33;
        if (r100.f173591b == true) goto L29;
        this.f173565l = false;
        D();
        goto L37
    L29:
        if (this.f173561h != null) goto L31;
        this.f173561h = new DeepFeedProductBannerIndicatorAnimator(this);
    L31:
        this.f173565l = true;
        C();
        goto L37
    L5:
        if (r101.f173591b != r100.f173591b) goto L19;
        if (r101.f173592c != r100.f173592c) goto L19;
        if (Intrinsics.areEqual(r101.f173593d, r100.f173593d) == false) goto L19;
        if (Intrinsics.areEqual(r101.f173594e, r100.f173594e) == false) goto L19;
        if (Intrinsics.areEqual(r101.f173595f, r100.f173595f) == false) goto L19;
        if (r101.f173596g != r100.f173596g) goto L19;
        if (r101.f173597h != r100.f173597h) goto L19;
        r102 = true;
        goto L20
    }

    public final Map<String, Object> u(int r100) {
        Pair[] r101 = new Pair[4];
        r101[0] = TuplesKt.to("multi_tab_scroll_to_index", Integer.valueOf(r100));
        r101[1] = TuplesKt.to("multi_tab_active_index", Integer.valueOf(r100));
        DeepFeedSlcListAdapter r102 = v();
        Object r103 = null;
        if (r102 == null) goto L22;
        DeepFeedSlcListAdapter.a r104 = (DeepFeedSlcListAdapter.a) CollectionsKt.getOrNull(r102.f173573a, r100);
        if (r104 == null) goto L22;
        SlcElement r105 = r104.f173583b;
        if (r105 == null) goto L22;
        Map<String, Object> r106 = r105.getProps();
        if (r106 == null) goto L13;
        Object r107 = r106.get("tab_type");
        if (r107 == null) goto L13;
    L18:
        if ((r107 instanceof String) == false) goto L21;
        r103 = r107;
    L21:
        r103 = (String) r103;
    L13:
        Map<String, Object> r108 = r105.getAttr();
        if (r108 == null) goto L16;
        r107 = r108.get("tab_type");
        goto L18
    L16:
        r107 = null;
    L22:
        r101[2] = TuplesKt.to("multi_tab_active_type", r103);
        r101[3] = TuplesKt.to("multi_tab_adapter_index", Integer.valueOf(r100));
        return MapsKt.mapOf(r101);
    }

    @Override // com.bytedance.android.shopping.deepfeed.ui.b
    public final void j(float r100, boolean r101) {
        e r102 = x();
        if (r102 == null) goto L5;
        r102.b(r100);
    L5:
        if (r101 == false) goto L8;
        smoothScrollToPosition(this.f173563j + 1);
        return;
    }

    public DeepFeedSlcList(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        DeepFeedProductOverScrollPagerSnapHelper r103 = new DeepFeedProductOverScrollPagerSnapHelper();
        this.f173559f = r103;
        this.f173567n = new c(0);
        this.f173568o = new a(this);
        SmoothScrollLayoutManager r104 = new SmoothScrollLayoutManager(r100);
        r104.setItemPrefetchEnabled(false);
        Resources r105 = th.a.f(r104.f176249b);
        r104.f176248a = WindowDisplayMetricsOverride.apply(r105, r105.getDisplayMetrics()).density * 0.15f;
        Unit r106 = Unit.INSTANCE;
        setLayoutManager(r104);
        r103.attachToRecyclerView(this);     // Catch: IllegalStateException -> L5
    L10:
        this.f173560g = OrientationHelper.createOrientationHelper(getLayoutManager(), 0);
        setItemViewCacheSize(0);
        setTouchCallback(new DeepFeedSlcList$initMoveListener$1(this));
        addOnScrollListener(new DeepFeedSlcList$onScrollListener$1(this));
        setItemAnimator(null);
        return;
    L5:
        e = move-exception;
        String r107 = e.getMessage();
        if (r107 != null) goto L9;
        r107 = "";
    L9:
        ECExceptionMonitor.c(r107);
        goto L10
    }

    public /* synthetic */ DeepFeedSlcList(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
