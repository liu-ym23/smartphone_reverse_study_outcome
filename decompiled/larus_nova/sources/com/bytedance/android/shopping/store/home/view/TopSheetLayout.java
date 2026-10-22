package com.bytedance.android.shopping.store.home.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.ec.hybrid.list.view.ECHybridRecyclerView;
import com.bytedance.android.ec.store.setting.ECStoreSettings;
import com.bytedance.android.shopping.store.utils.CommonUtils;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0006\rB'\b\u0007\u0012\u0006\u0010A\u001a\u00020@\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010B\u0012\b\b\u0002\u0010D\u001a\u00020<¢\u0006\u0004\bE\u0010FJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002R2\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0004j\b\u0012\u0004\u0012\u00020\u0002`\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010#\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010'\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010\u001e\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R\"\u0010+\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010\u001e\u001a\u0004\b)\u0010 \"\u0004\b*\u0010\"R$\u00103\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R$\u00107\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u0010\u000e\u001a\u0004\b5\u0010\u0010\"\u0004\b6\u0010\u0012R\"\u0010;\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u0010\u001e\u001a\u0004\b9\u0010 \"\u0004\b:\u0010\"R\u0014\u0010?\u001a\u00020<8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>¨\u0006G"}, d2 = {"Lcom/bytedance/android/shopping/store/home/view/TopSheetLayout;", "Landroid/widget/LinearLayout;", "Landroid/view/View;", "getCurrentSheetView", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Ljava/util/ArrayList;", "getTopSheetViews", "()Ljava/util/ArrayList;", "setTopSheetViews", "(Ljava/util/ArrayList;)V", "topSheetViews", "b", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "contentView", "Lcom/bytedance/android/shopping/store/home/view/TopSheetLayout$b;", "e", "Lcom/bytedance/android/shopping/store/home/view/TopSheetLayout$b;", "getOnTopSheetOffsetChangeListener", "()Lcom/bytedance/android/shopping/store/home/view/TopSheetLayout$b;", "setOnTopSheetOffsetChangeListener", "(Lcom/bytedance/android/shopping/store/home/view/TopSheetLayout$b;)V", "onTopSheetOffsetChangeListener", "", "m", "Z", "getEnableSheetScroll", "()Z", "setEnableSheetScroll", "(Z)V", "enableSheetScroll", OfficeSDKRequestTag.KEY_NEW_USER, "getEnableInternalScroll", "setEnableInternalScroll", "enableInternalScroll", "p", "getEnableSetNestedScrollView", "setEnableSetNestedScrollView", "enableSetNestedScrollView", "Lcom/bytedance/android/shopping/store/home/view/TopSheetLayout$a;", "q", "Lcom/bytedance/android/shopping/store/home/view/TopSheetLayout$a;", "getScrollListener", "()Lcom/bytedance/android/shopping/store/home/view/TopSheetLayout$a;", "setScrollListener", "(Lcom/bytedance/android/shopping/store/home/view/TopSheetLayout$a;)V", "scrollListener", "t", "getTargetChild", "setTargetChild", "targetChild", "w", "getSlideByHand", "setSlideByHand", "slideByHand", "", "getTopSheetViewHeight", "()I", "topSheetViewHeight", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TopSheetLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList<View> f184662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f184663b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Scroller f184664c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WeakReference<View> f184665d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f184666e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f184667f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f184668g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f184669h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f184670i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f184671j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final VelocityTracker f184672k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f184673l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f184674m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f184675n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ArrayList<Integer> f184676o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f184677p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public a f184678q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public RecyclerView f184679r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f184680s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public View f184681t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final TopSheetLayout$nestedScrollViewListener$1 f184682u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f184683v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f184684w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int[] f184685x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f184686y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f184687z;

    public interface a {
        void onScrollStateChanged(int r100);
    }

    public interface b {
        void a(View r100);

        void b(float r100, boolean r101);
    }

    public TopSheetLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public TopSheetLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final View getCurrentSheetView() {
        int r100 = this.f184662a.size();
        int r101 = 0;
        int r102 = 0;
    L3:
        if (r101 >= r100) goto L10;
        View r103 = getChildAt(r101);
        int r104 = f(getChildAt(r101)) + r102;
        int r105 = getScrollY();
        if (r102 > r105) goto L9;
        if (r104 < r105) goto L9;
        return r103;
    L9:
        r101 = r101 + 1;
        r102 = r104;
        goto L3
    L10:
        return null;
    }

    private final int getTopSheetViewHeight() {
        Iterator<T> r100 = this.f184662a.iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L6;
        r101 = r101 + f((View) r100.next());
        goto L4
    L6:
        return r101;
    }

    public final void b() {
        this.f184664c.abortAnimation();
        this.f184686y = getScrollY();
        this.f184684w = false;
        scrollTo(0, getTopSheetViewHeight());
        c();
    }

    public final void h() {
        if (this.f184664c.isFinished() == true) goto L5;
        return;
    L5:
        View r100 = getCurrentSheetView();
        if (r100 != null) goto L8;
        return;
    L8:
        int r101 = f(r100);
        View r102 = r100;
    L10:
        if (CollectionsKt.contains(this.f184676o, g(r102)) == false) goto L20;
        Integer r103 = g(r102);
        if (r103 == null) goto L16;
        int r104 = r103.intValue() + 1;
        if (r104 >= getChildCount()) goto L16;
        r102 = getChildAt(r104);
    L17:
        if (r102 == null) goto L20;
        r101 = r101 + f(r102);
    L16:
        r102 = null;
    L20:
        int r105 = (int) (getScrollY() - r100.getY());
        int r106 = r101 / 2;
        if (1 > r105) goto L25;
        if (r106 <= r105) goto L25;
        int r107 = -r105;
    L30:
        if (r107 == 0) goto L35;
        this.f184686y = getScrollY();
        this.f184664c.startScroll(0, getScrollY(), 0, r107);
        invalidate();
        return;
    L35:
        return;
    L25:
        if (r106 > r105) goto L29;
        if (r101 <= r105) goto L29;
        r107 = r101 - r105;
    L29:
        r107 = 0;
        goto L30
    }

    public final void c() {
        if (getTopSheetViewHeight() > 0.0f) goto L5;
        return;
    L5:
        if (getScrollY() > getTopSheetViewHeight()) goto L22;
        b r100 = this.f184666e;
        if (r100 == null) goto L9;
        r100.b(getScrollY() / getTopSheetViewHeight(), this.f184684w);
    L9:
        View r101 = getCurrentSheetView();
        if (r101 != null) goto L12;
        return;
    L12:
        getScrollY();
        r101.getY();
        if (f(r101) == 0) goto L15;
        f(r101);
    L15:
        Integer r102 = g(r101);
        if (r102 == null) goto L23;
        r102.intValue();
        b r103 = this.f184666e;
        if (r103 == null) goto L24;
        r103.a(r101);
        return;
    L24:
        return;
    L23:
        return;
    }

    @Override // android.view.View
    public final void computeScroll() {
        super.computeScroll();
        if (this.f184664c.computeScrollOffset() == false) goto L18;
        this.f184687z = true;
        int r100 = this.f184664c.getCurrY() - this.f184686y;
        this.f184686y = this.f184664c.getCurrY();
        WeakReference<View> r101 = this.f184665d;
        if (r101 == null) goto L7;
        View r102 = r101.get();
    L8:
        int[] r103 = this.f184685x;
        r103[0] = 0;
        r103[1] = 0;
        i(r100, r102, r103);
        if (r102 == null) goto L16;
        int r104 = r100 - this.f184685x[1];
        if (r102.canScrollVertically(r104) == false) goto L16;
        r102.scrollBy(0, r104);     // Catch: Exception -> L14
    L14:
        e = move-exception;
        dm.a.b r105 = dm.a.f469202a;
        dm.a.a("shop.topsheetlayout").b(e.getMessage(), e);
    L16:
        invalidate();
        goto L18
    L7:
        r102 = null;
    L18:
        if (this.f184687z == true) goto L20;
        return;
    L20:
        if (this.f184664c.isFinished() == false) goto L30;
        this.f184687z = false;
        this.f184665d = null;
        h();
        if (this.f184679r != null) goto L24;
        return;
    L24:
        if (this.f184680s == 0) goto L32;
        d(0);
        return;
    L32:
        return;
    }

    public final View getContentView() {
        return this.f184663b;
    }

    public final boolean getEnableInternalScroll() {
        return this.f184675n;
    }

    public final boolean getEnableSetNestedScrollView() {
        return this.f184677p;
    }

    public final boolean getEnableSheetScroll() {
        return this.f184674m;
    }

    public final b getOnTopSheetOffsetChangeListener() {
        return this.f184666e;
    }

    public final a getScrollListener() {
        return this.f184678q;
    }

    public final boolean getSlideByHand() {
        return this.f184684w;
    }

    public final View getTargetChild() {
        return this.f184681t;
    }

    public final ArrayList<View> getTopSheetViews() {
        return this.f184662a;
    }

    public static int f(View r100) {
        int r101 = r100.getHeight();
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r102 = null;
    L5:
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r102;
        if (r103 == null) goto L8;
        int r104 = r103.topMargin + r103.bottomMargin;
    L10:
        return r101 + r104;
    L8:
        r104 = 0;
        goto L10
    }

    public final void a(boolean r100) {
        this.f184664c.abortAnimation();
        this.f184686y = getScrollY();
        this.f184664c.startScroll(0, getScrollY(), 0, getTopSheetViewHeight() - getScrollY(), this.f184683v);
        invalidate();
        this.f184684w = r100;
        c();
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int r100) {
        if (r100 >= 0) goto L6;
        if (getScrollY() != 0) goto L6;
    L8:
        return false;
    L6:
        if (this.f184674m == false) goto L8;
        return true;
    }

    public final void d(int r100) {
        this.f184680s = r100;
        a r101 = this.f184678q;
        if (r101 == null) goto L6;
        r101.onScrollStateChanged(r100);
        return;
    }

    public final Integer g(View r100) {
        int r101 = getChildCount();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L9;
        if (Intrinsics.areEqual(getChildAt(r102), r100) == true) goto L7;
        r102 = r102 + 1;
        goto L3
    L7:
        return Integer.valueOf(r102);
    L9:
        return null;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        if (r100.getAction() != 0) goto L8;
        this.f184681t = null;
        this.f184664c.abortAnimation();
        this.f184665d = null;
        if (this.f184680s != 2) goto L8;
        d(1);
    L8:
        if (this.f184668g == false) goto L10;
        return false;
    L10:
        int r101 = r100.getAction();
        if (r101 != 2) goto L16;
        if (this.f184667f == false) goto L16;
        return true;
    L16:
        if (super.onInterceptTouchEvent(r100) == false) goto L19;
        return true;
    L19:
        if (getScrollY() == 0) goto L21;
    L23:
        if (r101 == 0) goto L47;
        if (r101 != 2) goto L49;
        this.f184672k.addMovement(r100);
        int r102 = (int) r100.getY();
        int r103 = this.f184670i - r102;
        if (getScrollY() != getTopSheetViewHeight()) goto L29;
        boolean r104 = true;
    L30:
        if (r104 == false) goto L37;
        View r105 = this.f184681t;
        if (r105 == null) goto L37;
        if (r105.canScrollVertically(r103) != true) goto L37;
        this.f184667f = false;
    L40:
        if (this.f184680s != 1) goto L42;
    L46:
        this.f184671j = r102;
        goto L49
    L42:
        if (this.f184667f == false) goto L46;
        if (canScrollVertically(r103) == false) goto L46;
        d(1);
    L37:
        if (Math.abs(r103) <= this.f184669h) goto L40;
        this.f184667f = true;
        goto L40
    L29:
        r104 = false;
    L49:
        return this.f184667f;
    L47:
        this.f184670i = (int) r100.getY();
        this.f184671j = (int) r100.getY();
        this.f184667f = false;
        this.f184672k.clear();
        this.f184672k.addMovement(r100);
        goto L49
    L21:
        if (canScrollVertically(1) == true) goto L23;
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        super.onStopNestedScroll(r100);
        this.f184668g = false;
        h();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        dm.a.a("TopSheetLayout").a("onTouchEvent lastMoveEventY = " + this.f184671j + ",ev.y = " + r100.getY());
        if (this.f184674m == false) goto L24;
        int r101 = r100.getAction();
        this.f184672k.addMovement(r100);
        if (r101 != 1) goto L7;
        this.f184672k.computeCurrentVelocity(1000, this.f184673l);
        e(-this.f184672k.getYVelocity(), this.f184681t);
    L20:
        if (r101 != 1) goto L24;
        if (this.f184664c.isFinished() == false) goto L24;
        h();
        goto L24
    L7:
        if (r101 != 2) goto L20;
        int r102 = (int) (this.f184671j - r100.getY());
        int[] r103 = this.f184685x;
        r103[0] = 0;
        r103[1] = 0;
        i(r102, this.f184681t, r103);
        View r104 = this.f184681t;
        if (r104 == null) goto L12;
        r104.scrollBy(0, r102 - this.f184685x[1]);
    L12:
        this.f184671j = (int) r100.getY();
        if (this.f184680s == 1) goto L20;
        if (Math.abs(r102) <= this.f184669h) goto L20;
        if (canScrollVertically(r102) == false) goto L20;
        d(1);
    L24:
        this.f184684w = true;
        if (super.onTouchEvent(r100) == false) goto L27;
    L28:
        return true;
    L27:
        if (this.f184674m == true) goto L28;
        return false;
    }

    public final void setContentView(View r100) {
        this.f184663b = r100;
    }

    public final void setEnableInternalScroll(boolean r100) {
        this.f184675n = r100;
    }

    public final void setEnableSetNestedScrollView(boolean r100) {
        this.f184677p = r100;
    }

    public final void setEnableSheetScroll(boolean r100) {
        this.f184674m = r100;
    }

    public final void setOnTopSheetOffsetChangeListener(b r100) {
        this.f184666e = r100;
    }

    public final void setScrollListener(a r100) {
        this.f184678q = r100;
    }

    public final void setSlideByHand(boolean r100) {
        this.f184684w = r100;
    }

    public final void setTargetChild(View r100) {
        this.f184681t = r100;
    }

    public final void setTopSheetViews(ArrayList<View> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f184662a = r100;
    }

    public final void e(float r110, View r111) {
        if (r111 == null) goto L4;
        this.f184665d = new WeakReference(r111);
    L4:
        int r100 = (int) r110;
        if (canScrollVertically(r100) == false) goto L12;
        this.f184664c.abortAnimation();
        this.f184664c.fling(0, getScrollY(), 0, r100, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        this.f184686y = getScrollY();
        invalidate();
        if (this.f184679r != null) goto L9;
        return;
    L9:
        if (this.f184680s == 2) goto L14;
        d(2);
        return;
    L14:
        return;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        if (getChildCount() < 2) goto L14;
        this.f184662a.clear();
        int r102 = getChildCount();
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L11;
        View r104 = getChildAt(r103);
        if (r103 >= (getChildCount() - 1)) goto L9;
        this.f184662a.add(r104);
    L10:
        measureChild(r104, r100, r101);
        r103 = r103 + 1;
        goto L5
    L9:
        this.f184663b = r104;
        goto L10
    L11:
        setMeasuredDimension(View.MeasureSpec.getSize(r100), View.MeasureSpec.getSize(r101));
        return;
    L14:
        throw new IllegalArgumentException("child count must >= 2");
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [com.bytedance.android.shopping.store.home.view.TopSheetLayout$nestedScrollViewListener$1] */
    public TopSheetLayout(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f184662a = new ArrayList();
        this.f184664c = new Scroller(r100, new AccelerateDecelerateInterpolator());
        this.f184672k = VelocityTracker.obtain();
        this.f184674m = true;
        this.f184675n = true;
        this.f184676o = new ArrayList();
        this.f184682u = new TopSheetLayout$nestedScrollViewListener$1(this);
        com.bytedance.android.ec.store.setting.e r103 = ECStoreSettings.g();
        if (r103 == null) goto L5;
        long r104 = r103.a();
    L6:
        this.f184683v = (int) r104;
        Handler r105 = CommonUtils.f186901a;
        CommonUtils.c(false, new AnonymousClass1(this, r100));
        this.f184685x = new int[2];
        return;
    L5:
        r104 = 500;
        goto L6
    }

    public final void i(int r100, View r101, int[] r102) {
        if (getTopSheetViewHeight() <= 0) goto L31;
        if (r100 != 0) goto L6;
        return;
    L6:
        if (this.f184675n == true) goto L9;
        return;
    L9:
        if (getScrollY() < getTopSheetViewHeight()) goto L19;
        if (getScrollY() != getTopSheetViewHeight()) goto L13;
        boolean r103 = true;
    L14:
        if (r103 == false) goto L33;
        if (r101 == null) goto L19;
        if (r101.canScrollVertically(r100) != true) goto L19;
        return;
    L33:
        return;
    L13:
        r103 = false;
    L19:
        if ((getScrollY() + r100) <= getTopSheetViewHeight()) goto L21;
        int r104 = getTopSheetViewHeight() - getScrollY();
    L23:
        if ((r100 + getScrollY()) >= 0) goto L25;
        r104 = -getScrollY();
    L25:
        scrollBy(0, r104);
        if (r102 == null) goto L28;
        r102[1] = r104;
    L28:
        if (r104 == 0) goto L35;
        this.f184684w = true;
        c();
        return;
    L35:
        return;
    L21:
        r104 = r100;
        goto L23
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View r100, float r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        if (this.f184674m == true) goto L6;
        return false;
    L6:
        e(r102, r100);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View r100, View r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
        if (this.f184674m == true) goto L6;
        return false;
    L6:
        if (r102 != 2) goto L9;
        this.f184668g = true;
        return true;
    L9:
        return false;
    }

    public /* synthetic */ TopSheetLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View r100, int r101, int r102, int[] r103) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r103, "consumed");
        if ((r100 instanceof ECHybridRecyclerView) == true) goto L5;
    L9:
        RecyclerView r104 = this.f184679r;
        if (r104 == null) goto L12;
        r104.removeOnScrollListener(this.f184682u);
    L12:
        this.f184679r = null;
    L13:
        i(r102, r100, r103);
        return;
    L5:
        if (this.f184677p == false) goto L9;
        if ((!Intrinsics.areEqual(r100, this.f184679r)) == false) goto L13;
        ((ECHybridRecyclerView) r100).addOnScrollListener(this.f184682u);
        Unit r105 = Unit.INSTANCE;
        this.f184679r = (RecyclerView) r100;
        goto L13
    }
}
