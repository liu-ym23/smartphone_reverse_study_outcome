package com.bytedance.android.shopping.commentfeed;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.commentfeed.widget.VerticalViewPager;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/commentfeed/HorizontalRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/bytedance/android/shopping/commentfeed/widget/VerticalViewPager;", "c", "Lcom/bytedance/android/shopping/commentfeed/widget/VerticalViewPager;", "getViewPager", "()Lcom/bytedance/android/shopping/commentfeed/widget/VerticalViewPager;", "setViewPager", "(Lcom/bytedance/android/shopping/commentfeed/widget/VerticalViewPager;)V", "viewPager", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HorizontalRecyclerView extends RecyclerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f172317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f172318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public VerticalViewPager f172319c;

    public HorizontalRecyclerView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public HorizontalRecyclerView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final VerticalViewPager getViewPager() {
        return this.f172319c;
    }

    public static RecyclerView r(View r100) {
        Object r101 = r100.getParent();
        if ((r101 instanceof RecyclerView) == false) goto L7;
        return (RecyclerView) r101;
    L7:
        if ((r101 instanceof View) == true) goto L9;
        Object r102 = null;
    L11:
        if (((View) r102) != null) goto L13;
        return null;
    L13:
        return r((View) r101);
    L9:
        r102 = r101;
        goto L11
    }

    public static VerticalViewPager t(View r100) {
        Object r101 = r100.getParent();
        if ((r101 instanceof VerticalViewPager) == false) goto L7;
        return (VerticalViewPager) r101;
    L7:
        if ((r101 instanceof View) == true) goto L9;
        Object r102 = null;
    L11:
        if (((View) r102) != null) goto L13;
        return null;
    L13:
        return t((View) r101);
    L9:
        r102 = r101;
        goto L11
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        int r101 = r100.getAction();
        if (r101 == 0) goto L19;
        if (r101 != 1) goto L6;
    L18:
        this.f172318b = 0.0f;
        this.f172317a = 0.0f;
    L26:
        return super.dispatchTouchEvent(r100);
    L6:
        if (r101 != 2) goto L8;
        float r102 = r100.getX();
        float r103 = r100.getY();
        if (Math.abs(r102 - this.f172317a) >= Math.abs(r103 - this.f172318b)) goto L26;
        VerticalViewPager r104 = t(this);
        if (r104 == null) goto L15;
        r104.requestDisallowInterceptTouchEvent(false);
    L15:
        RecyclerView r105 = r(this);
        if (r105 == null) goto L26;
        r105.requestDisallowInterceptTouchEvent(true);
        goto L26
    L8:
        if (r101 == 3) goto L18;
    L19:
        this.f172317a = r100.getX();
        this.f172318b = r100.getY();
        VerticalViewPager r106 = t(this);
        if (r106 == null) goto L22;
        r106.requestDisallowInterceptTouchEvent(true);
    L22:
        RecyclerView r107 = r(this);
        if (r107 == null) goto L26;
        r107.requestDisallowInterceptTouchEvent(true);
        goto L26
    }

    public final void setViewPager(VerticalViewPager r100) {
        this.f172319c = r100;
    }

    public HorizontalRecyclerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setLayoutManager(new LinearLayoutManager(r100, 0, false));
    }

    public /* synthetic */ HorizontalRecyclerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
