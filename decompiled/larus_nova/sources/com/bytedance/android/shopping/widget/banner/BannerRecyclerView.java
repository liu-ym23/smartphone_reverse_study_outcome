package com.bytedance.android.shopping.widget.banner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.feed.banner.b;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R$\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/widget/banner/BannerRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "", "angle", "", "setInterceptAngle", "Lcom/bytedance/android/shopping/feed/banner/b;", "e", "Lcom/bytedance/android/shopping/feed/banner/b;", "getScrollByDragListener", "()Lcom/bytedance/android/shopping/feed/banner/b;", "setScrollByDragListener", "(Lcom/bytedance/android/shopping/feed/banner/b;)V", "scrollByDragListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BannerRecyclerView extends RecyclerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f187255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f187256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f187257c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f187258d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f187259e;

    public BannerRecyclerView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BannerRecyclerView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final b getScrollByDragListener() {
        return this.f187259e;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "e");
        int r100 = r110.getActionMasked();
        if (r100 != 0) goto L5;
        this.f187257c = r110.getX();
        this.f187258d = r110.getY();
        if (this.f187256b <= 0) goto L27;
        getParent().requestDisallowInterceptTouchEvent(true);
        setNestedScrollingEnabled(false);
    L27:
        return super.onInterceptTouchEvent(r110);
    L5:
        if (r100 != 2) goto L27;
        float r101 = Math.abs(r110.getX() - this.f187257c);
        float r102 = Math.abs(r110.getY() - this.f187258d);
        float r103 = this.f187255a;
        if (r101 >= r103) goto L12;
        if (r102 >= r103) goto L12;
    L17:
        if (r101 < this.f187255a) goto L27;
        if (r101 <= r102) goto L27;
        b r104 = this.f187259e;
        if (r104 == null) goto L27;
        r104.b();
    L12:
        if ((((double) r102) / ((double) r101)) <= Math.tan((((double) this.f187256b) * 3.141592653589793d) / ((double) 180))) goto L17;
        if (this.f187256b <= 0) goto L17;
        getParent().requestDisallowInterceptTouchEvent(false);
        setNestedScrollingEnabled(true);
        goto L17
    }

    public final void setInterceptAngle(int r100) {
        this.f187256b = r100;
    }

    public final void setScrollByDragListener(b r100) {
        this.f187259e = r100;
    }

    public BannerRecyclerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f187255a = ViewConfiguration.get(r100).getScaledTouchSlop();
    }

    public /* synthetic */ BannerRecyclerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
