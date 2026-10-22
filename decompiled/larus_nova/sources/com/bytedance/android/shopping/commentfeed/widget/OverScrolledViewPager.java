package com.bytedance.android.shopping.commentfeed.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.TranslateAnimation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\rB\u0013\b\u0016\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tB\u001d\b\u0016\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/commentfeed/widget/OverScrolledViewPager;", "Lcom/bytedance/android/shopping/commentfeed/widget/VerticalViewPager;", "Lcom/bytedance/android/shopping/commentfeed/widget/OverScrolledViewPager$a;", "listener", "", "setOnRefreshListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OverScrolledViewPager extends VerticalViewPager {
    public boolean P0;
    public boolean V0;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public final Rect f172438b1;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public a f172439g1;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public float f172440h1;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public int f172441k1;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public final int f172442p1;

    public interface a {
        void a();

        void onLoadMore();

        void onRefresh();
    }

    public OverScrolledViewPager(Context r100) {
        super(r100);
        this.P0 = true;
        this.f172438b1 = new Rect();
        this.f172442p1 = vf4.a.b(30);
    }

    @Override // com.bytedance.android.shopping.commentfeed.widget.VerticalViewPager, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        int r101 = r100.getAction();
        if (r101 == 1) goto L25;
        if (r101 != 2) goto L40;
        if (this.f172440h1 != 0.0f) goto L10;
        this.f172440h1 = r100.getY();
    L10:
        int r102 = ((int) (this.f172440h1 - r100.getY())) / 2;
        this.f172441k1 = r102;
        if (this.P0 == false) goto L14;
        if (r102 > 0) goto L14;
    L16:
        Rect r103 = this.f172438b1;
        layout(r103.left, -r102, r103.right, r103.bottom - r102);
        if (this.V0 == true) goto L19;
    L23:
        return true;
    L19:
        if (Math.abs(this.f172441k1) <= this.f172442p1) goto L23;
        a r104 = this.f172439g1;
        if (r104 == null) goto L23;
        r104.a();
    L14:
        if (this.V0 == false) goto L40;
        if (r102 >= 0) goto L16;
    L40:
        return super.onTouchEvent(r100);
    L25:
        if (this.P0 == false) goto L27;
    L28:
        int r105 = this.f172441k1;
        int r106 = this.f172442p1;
        if (r105 <= r106) goto L34;
        a r107 = this.f172439g1;
        if (r107 == null) goto L38;
        r107.onLoadMore();
    L38:
        this.f172440h1 = 0.0f;
        TranslateAnimation r108 = new TranslateAnimation(0.0f, 0.0f, getY(), this.f172438b1.top);
        r108.setDuration(200);
        startAnimation(r108);
        Rect r109 = this.f172438b1;
        layout(r109.left, r109.top, r109.right, r109.bottom);
        goto L40
    L34:
        if (r105 >= (-r106)) goto L38;
        a r110 = this.f172439g1;
        if (r110 == null) goto L38;
        r110.onRefresh();
        goto L38
    L27:
        if (this.V0 == false) goto L40;
        goto L28
    }

    public final void setOnRefreshListener(a r100) {
        this.f172439g1 = r100;
    }

    public OverScrolledViewPager(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.P0 = true;
        this.f172438b1 = new Rect();
        this.f172442p1 = vf4.a.b(30);
    }

    @Override // com.bytedance.android.shopping.commentfeed.widget.VerticalViewPager
    public final void m(int r100, float r101, int r102) {
        if (getAdapter() != null) goto L5;
    L20:
        this.P0 = false;
        this.V0 = false;
    L22:
        if (this.f172438b1.isEmpty() == true) goto L25;
        Rect r103 = this.f172438b1;
        if ((r103.left - r103.right) == 0) goto L25;
    L26:
        super.m(r100, r101, r102);
        return;
    L25:
        this.f172438b1.set(getLeft(), getTop(), getRight(), getBottom());
        goto L26
    L5:
        if (getAdapter().getCount() == 0) goto L20;
        if (r100 != 0) goto L14;
        if (r101 != 0.0f) goto L14;
        if (r102 != 0) goto L14;
        this.P0 = true;
    L14:
        if (r100 == (getAdapter().getCount() - 1)) goto L16;
    L19:
        this.P0 = false;
        this.V0 = false;
        goto L22
    L16:
        if (r101 != 0.0f) goto L19;
        if (r102 != 0) goto L19;
        this.V0 = true;
        goto L22
    }
}
