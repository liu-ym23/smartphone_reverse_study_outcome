package com.bytedance.android.shopping.card_list.widgets.nest;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.amap.api.col.s.ce;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableResourceData;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0005B'\b\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0002R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006$"}, d2 = {"Lcom/bytedance/android/shopping/card_list/widgets/nest/CardListTwoRevNestedScrollView;", "Landroidx/core/widget/NestedScrollView;", "", "getSessionId", "Lcom/bytedance/android/shopping/card_list/widgets/nest/d;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/shopping/card_list/widgets/nest/d;", "getViewState", "()Lcom/bytedance/android/shopping/card_list/widgets/nest/d;", "setViewState", "(Lcom/bytedance/android/shopping/card_list/widgets/nest/d;)V", "viewState", "Lcom/bytedance/android/shopping/card_list/widgets/nest/CardListTwoRevViewAction;", "b", "Lcom/bytedance/android/shopping/card_list/widgets/nest/CardListTwoRevViewAction;", "getViewAction", "()Lcom/bytedance/android/shopping/card_list/widgets/nest/CardListTwoRevViewAction;", "setViewAction", "(Lcom/bytedance/android/shopping/card_list/widgets/nest/CardListTwoRevViewAction;)V", "viewAction", "Landroid/view/ViewGroup;", ce.f26391f, "Landroid/view/ViewGroup;", "getInnerLayout", "()Landroid/view/ViewGroup;", "setInnerLayout", "(Landroid/view/ViewGroup;)V", "innerLayout", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class CardListTwoRevNestedScrollView extends NestedScrollView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f171979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CardListTwoRevViewAction f171980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RecyclerView f171981c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RecyclerView f171982d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public e f171983e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public e f171984f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ViewGroup f171985g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Pair<? extends Object, Integer> f171986h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f171987i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f171988j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final CardListTwoRevNestedScrollView$lockUpdateHook$1 f171989k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final CardListTwoRevNestedScrollView$scrollListener$1 f171990l;

    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicBoolean f171991a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final GestureDetector f171992b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Rect f171993c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Rect f171994d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ CardListTwoRevNestedScrollView f171995e;

        /* JADX INFO: renamed from: com.bytedance.android.shopping.card_list.widgets.nest.CardListTwoRevNestedScrollView$a$a, reason: collision with other inner class name */
        public static final class C2577a extends GestureDetector.SimpleOnGestureListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f171996a;

            public C2577a(a r100) {
                this.f171996a = r100;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onSingleTapUp(MotionEvent r100) {
                Intrinsics.checkNotNullParameter(r100, "e");
                return this.f171996a.f171991a.get();
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103) {
                Intrinsics.checkNotNullParameter(r101, "e2");
                this.f171996a.f171995e.getViewAction().f172003e.invoke(Float.valueOf(r102), Float.valueOf(r103));
                return super.onScroll(r100, r101, r102, r103);
            }
        }

        public final boolean a(RecyclerView r100) {
            if (r100 != null) goto L5;
            return false;
        L5:
            this.f171995e.getGlobalVisibleRect(this.f171993c);
            r100.getGlobalVisibleRect(this.f171994d);
            Rect r101 = this.f171993c;
            if (r101.top == this.f171994d.top) goto L8;
            return false;
        L8:
            if (r101.height() != this.f171994d.height()) goto L12;
            return true;
        L12:
            return false;
        }

        public a(CardListTwoRevNestedScrollView r100, Context r101) {
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f171995e = r100;
            this.f171991a = new AtomicBoolean(false);
            this.f171992b = new GestureDetector(r101, new C2577a(this));
            this.f171993c = new Rect();
            this.f171994d = new Rect();
        }
    }

    public CardListTwoRevNestedScrollView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CardListTwoRevNestedScrollView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final String getSessionId() {
        CardListTwoRevViewAction r100 = this.f171980b;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewAction");
    L6:
        return r100.f172000b.invoke();
    }

    public final CardListTwoRevViewAction getViewAction() {
        CardListTwoRevViewAction r100 = this.f171980b;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewAction");
    L5:
        return r100;
    }

    public final d getViewState() {
        d r100 = this.f171979a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewState");
    L5:
        return r100;
    }

    public final ViewGroup getInnerLayout() {
        return this.f171985g;
    }

    public static final /* synthetic */ String e(CardListTwoRevNestedScrollView r100) {
        return r100.getSessionId();
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        if (r100.getAction() != 0) goto L10;
        AtomicBoolean r101 = this.f171987i.f171991a;
        if (this.f171986h == null) goto L7;
        boolean r102 = true;
    L8:
        r101.set(r102);
        goto L10
    L7:
        r102 = false;
    L10:
        if (this.f171987i.f171992b.onTouchEvent(r100) == false) goto L13;
        return true;
    L13:
        return super.onInterceptTouchEvent(r100);
    }

    public final void setInnerLayout(ViewGroup r100) {
        this.f171985g = r100;
    }

    public final void setViewAction(CardListTwoRevViewAction r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f171980b = r100;
    }

    public final void setViewState(d r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f171979a = r100;
    }

    public final void f(@NestedRevType String r100, RecyclerView r101) {
        Intrinsics.checkNotNullParameter(r100, "revType");
        a r102 = this.f171987i;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "revType");
        e r103 = null;
        switch(r100.hashCode()) {
            case 3496942: goto L17;
            case 3496943: goto L6;
            default: goto L27;
        };
    L27:
        a r104 = this.f171987i;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r100, "revType");
        if (r101 == null) goto L30;
        r101.setOverScrollMode(2);
    L30:
        if (r101 == null) goto L32;
        r101.addOnScrollListener(r104.f171995e.f171989k);
    L32:
        if (r101 == null) goto L35;
        r101.addOnScrollListener(r104.f171995e.f171990l);
    L35:
        switch(r100.hashCode()) {
            case 3496942: goto L45;
            case 3496943: goto L38;
            default: goto L55;
        };
    L55:
        return;
    L38:
        if (r100.equals(BitableResourceData.KEY_REV_2) == false) goto L52;
        int r105 = e.f172024c;
        if (r101 == null) goto L43;
        r103 = new e(r101);
    L43:
        this.f171984f = r103;
        this.f171982d = r101;
        return;
    L52:
        return;
    L45:
        if (r100.equals(BitableResourceData.KEY_REV_1) == false) goto L54;
        int r106 = e.f172024c;
        if (r101 == null) goto L50;
        r103 = new e(r101);
    L50:
        this.f171983e = r103;
        this.f171981c = r101;
        return;
    L54:
        return;
    L6:
        if (r100.equals(BitableResourceData.KEY_REV_2) == false) goto L27;
        CardListTwoRevNestedScrollView r107 = r102.f171995e;
        e r108 = r107.f171984f;
        if (r108 == null) goto L10;
        RecyclerView r109 = r108.f172026b;
    L11:
        if (r109 == null) goto L13;
        r109.removeOnScrollListener(r107.f171989k);
    L13:
        if (r109 == null) goto L15;
        r109.removeOnScrollListener(r102.f171995e.f171990l);
    L15:
        r102.f171995e.f171984f = null;
        goto L27
    L10:
        r109 = null;
        goto L11
    L17:
        if (r100.equals(BitableResourceData.KEY_REV_1) == false) goto L27;
        CardListTwoRevNestedScrollView r110 = r102.f171995e;
        e r111 = r110.f171983e;
        if (r111 == null) goto L21;
        RecyclerView r112 = r111.f172026b;
    L22:
        if (r112 == null) goto L24;
        r112.removeOnScrollListener(r110.f171989k);
    L24:
        if (r112 == null) goto L26;
        r112.removeOnScrollListener(r102.f171995e.f171990l);
    L26:
        r102.f171995e.f171983e = null;
        goto L27
    L21:
        r112 = null;
        goto L22
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.bytedance.android.shopping.card_list.widgets.nest.CardListTwoRevNestedScrollView$lockUpdateHook$1] */
    public CardListTwoRevNestedScrollView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f171987i = new a(this, r100);
        this.f171989k = new CardListTwoRevNestedScrollView$lockUpdateHook$1(this);
        this.f171990l = new CardListTwoRevNestedScrollView$scrollListener$1(this);
    }

    public /* synthetic */ CardListTwoRevNestedScrollView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // androidx.core.widget.NestedScrollView, androidx.core.view.NestedScrollingParent2
    public final void onNestedScrollAccepted(View r100, View r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        if (r103 != 0) goto L25;
        Pair<? extends Object, Integer> r104 = this.f171986h;
        if (r104 == null) goto L7;
        Object r105 = r104.getFirst();
    L9:
        if (Intrinsics.areEqual(r105, r101) == true) goto L25;
        Pair<? extends Object, Integer> r106 = this.f171986h;
        if (r106 == null) goto L25;
        if (r106.getSecond().intValue() != 2) goto L25;
        Pair<? extends Object, Integer> r107 = this.f171986h;
        if (r107 == null) goto L17;
        Object r108 = r107.getFirst();
    L19:
        if ((r108 instanceof RecyclerView) == true) goto L21;
        r108 = null;
    L21:
        RecyclerView r109 = (RecyclerView) r108;
        if (r109 == null) goto L24;
        r109.stopScroll();
    L24:
        this.f171986h = null;
        goto L25
    L17:
        r108 = null;
        goto L19
    L7:
        r105 = null;
    L25:
        super.onNestedScrollAccepted(r100, r101, r102, r103);
    }

    @Override // androidx.core.widget.NestedScrollView, androidx.core.view.NestedScrollingParent2
    public final void onNestedPreScroll(View r110, int r111, int r112, int[] r113, int r114) {
        Intrinsics.checkNotNullParameter(r110, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r113, "consumed");
        Pair<? extends Object, Integer> r100 = this.f171986h;
        if (r100 == null) goto L5;
        Object r101 = r100.getFirst();
    L7:
        if (Intrinsics.areEqual(r101, r110) == true) goto L14;
        r113[1] = r112;
        if ((r110 instanceof RecyclerView) == true) goto L11;
        r110 = null;
    L11:
        RecyclerView r115 = (RecyclerView) r110;
        if (r115 == null) goto L37;
        r115.stopScroll();
        return;
    L37:
        return;
    L14:
        CardListTwoRevViewAction r102 = this.f171980b;
        if (r102 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewAction");
    L17:
        r102.f171999a.invoke(Integer.valueOf(r112));
        super.onNestedPreScroll(r110, r111, r112 - r113[1], r113, r114);
        int r116 = r112 - r113[1];
        int r117 = c.f172010a;
        if (r116 >= 0) goto L20;
        boolean r118 = true;
    L21:
        if (r118 == false) goto L28;
        if (Intrinsics.areEqual(r110, this.f171981c) == true) goto L25;
        return;
    L25:
        if (canScrollVertically(r116) == false) goto L40;
        int r119 = Math.max(-getScrollY(), r116);
        r113[1] = r113[1] + r119;
        scrollBy(0, r119);
        return;
    L40:
        return;
    L28:
        if (Intrinsics.areEqual(r110, this.f171982d) == true) goto L30;
        return;
    L30:
        if (canScrollVertically(r116) == false) goto L43;
        ViewGroup r120 = this.f171985g;
        if (r120 == null) goto L34;
        int r121 = r120.getHeight();
    L35:
        int r122 = Math.min((r121 - getHeight()) - getScrollY(), r116);
        r113[1] = r113[1] + r122;
        scrollBy(0, r122);
        return;
    L34:
        r121 = 0;
        goto L35
    L43:
        return;
    L20:
        r118 = false;
        goto L21
    L5:
        r101 = null;
        goto L7
    }

    @Override // androidx.core.widget.NestedScrollView, androidx.core.view.NestedScrollingParent3
    public final void onNestedScroll(View r100, int r101, int r102, int r103, int r104, int r105, int[] r106) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r106, "consumed");
        super.onNestedScroll(r100, r101, r102, r103, r104, r105, r106);
        int r107 = r104 - r106[1];
        if (Intrinsics.areEqual(r100, this.f171981c) == false) goto L16;
        if (r107 <= 0) goto L16;
        RecyclerView r108 = this.f171982d;
        if (r108 == null) goto L16;
        if (r108.canScrollVertically(r107) != true) goto L16;
        if (this.f171987i.a(this.f171982d) == false) goto L16;
        RecyclerView r109 = this.f171982d;
        if (r109 == null) goto L14;
        r109.scrollBy(0, r107);
    L14:
        r106[1] = r106[1] + r107;
        return;
    L16:
        if (Intrinsics.areEqual(r100, this.f171982d) == false) goto L30;
        if (r107 >= 0) goto L31;
        RecyclerView r110 = this.f171981c;
        if (r110 != null) goto L21;
        return;
    L21:
        if (r110.canScrollVertically(r107) == true) goto L23;
        return;
    L23:
        if (this.f171987i.a(this.f171981c) == false) goto L34;
        RecyclerView r111 = this.f171981c;
        if (r111 == null) goto L27;
        r111.scrollBy(0, r107);
    L27:
        r106[1] = r106[1] + r107;
        return;
    L34:
        return;
    L31:
        return;
    }
}
