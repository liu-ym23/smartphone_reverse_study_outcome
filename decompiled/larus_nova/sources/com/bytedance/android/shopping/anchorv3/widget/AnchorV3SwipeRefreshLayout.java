package com.bytedance.android.shopping.anchorv3.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0014\u0010\u0006\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/widget/AnchorV3SwipeRefreshLayout;", "Landroid/view/ViewGroup;", "", "Lkotlin/Function0;", "", "listener", "setOnRefreshListener", "", "getRefreshState", "()Ljava/lang/Integer;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attributeSet", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV3SwipeRefreshLayout extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewDragHelper f165577a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public FixedRecyclerView f165578b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public FixedHeadView f165579c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f165580d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f165581e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function0<Unit> f165582f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f165583g;

    public AnchorV3SwipeRefreshLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AnchorV3SwipeRefreshLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final void computeScroll() {
        ViewDragHelper r100 = this.f165577a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.continueSettling(true) != true) goto L9;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    }

    public Integer getRefreshState() {
        FixedHeadView r100 = this.f165579c;
        if (r100 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(r100.getAnimState());
    }

    public final void a() {
        Integer r100 = getRefreshState();
        if (r100 != null) goto L6;
    L7:
        FixedHeadView r101 = this.f165579c;
        if (r101 == null) goto L10;
        r101.setRefreshStatus(0);
    L10:
        ViewDragHelper r102 = this.f165577a;
        if (r102 == null) goto L17;
        FixedHeadView r103 = this.f165579c;
        if (r103 == null) goto L16;
        r102.smoothSlideViewTo(r103, 0, -this.f165580d);
        goto L17
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L17:
        ViewDragHelper r104 = this.f165577a;
        if (r104 == null) goto L24;
        FixedRecyclerView r105 = this.f165578b;
        if (r105 == null) goto L23;
        r104.smoothSlideViewTo(r105, 0, 0);
        goto L24
    L23:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L24:
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L6:
        if (r100.intValue() != 0) goto L7;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        View r100 = getChildAt(0);
        if (r100 == null) goto L11;
        this.f165579c = (FixedHeadView) r100;
        View r101 = getChildAt(1);
        if (r101 == null) goto L9;
        this.f165578b = (FixedRecyclerView) r101;
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv3.widget.FixedRecyclerView");
    L11:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv3.widget.FixedHeadView");
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        ViewDragHelper r101 = this.f165577a;
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.shouldInterceptTouchEvent(r100);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        ViewDragHelper r101 = this.f165577a;
        if (r101 == null) goto L7;
        r101.processTouchEvent(r100);
        return true;
    L7:
        return true;
    }

    public final void setOnRefreshListener(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f165582f = r100;
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        measureChildren(r100, r101);
    }

    public AnchorV3SwipeRefreshLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        addView(new FixedHeadView(r100, null, 6, 0), 0);
        this.f165577a = ViewDragHelper.create(this, new AnonymousClass1(this));
    }

    public /* synthetic */ AnchorV3SwipeRefreshLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        FixedHeadView r105 = this.f165579c;
        if (r105 == null) goto L5;
        int r106 = r105.getMeasuredHeight();
    L6:
        this.f165580d = r106;
        FixedRecyclerView r107 = this.f165578b;
        if (r107 == null) goto L9;
        int r108 = r107.getMeasuredHeight();
    L11:
        if (this.f165583g != 0) goto L19;
        FixedRecyclerView r109 = this.f165578b;
        if (r109 == null) goto L15;
        r109.layout(r101, 0, r103, r108);
    L15:
        FixedHeadView r110 = this.f165579c;
        if (r110 == null) goto L20;
        r110.layout(r101, 0 - this.f165580d, r103, 0);
        return;
    L20:
        return;
    L19:
        return;
    L9:
        r108 = 0;
        goto L11
    L5:
        r106 = 0;
        goto L6
    }
}
