package com.bytedance.android.ec.store.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.widget.NestedScrollView;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/store/widget/ECOverScrollExpandContainer;", "Landroidx/core/widget/NestedScrollView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECOverScrollExpandContainer extends NestedScrollView {
    public ECOverScrollExpandContainer(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECOverScrollExpandContainer(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(r100);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        int r101 = r100.getAction();     // Catch: Exception -> L14
        if (r101 != 1) goto L6;
    L11:
        requestDisallowInterceptTouchEvent(false);     // Catch: Exception -> L14
    L12:
        return super.onTouchEvent(r100);
    L6:
        if (r101 != 2) goto L8;
        requestDisallowInterceptTouchEvent(true);     // Catch: Exception -> L14
        goto L12
    L8:
        if (r101 == 3) goto L11;
    L14:
        return false;
    }

    public ECOverScrollExpandContainer(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public final void measureChild(View r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        ViewGroup.LayoutParams r103 = r100.getLayoutParams();
        r100.measure(FrameLayout.getChildMeasureSpec(r101, getPaddingLeft() + getPaddingRight(), r103.width), FrameLayout.getChildMeasureSpec(r102, getPaddingTop() + getPaddingBottom(), r103.height));
    }

    public /* synthetic */ ECOverScrollExpandContainer(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public final void measureChildWithMargins(View r100, int r101, int r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        ViewGroup.LayoutParams r105 = r100.getLayoutParams();
        if (r105 == null) goto L7;
        ViewGroup.MarginLayoutParams r106 = (ViewGroup.MarginLayoutParams) r105;
        r100.measure(FrameLayout.getChildMeasureSpec(r101, (((getPaddingLeft() + getPaddingRight()) + r106.leftMargin) + r106.rightMargin) + r102, r106.width), FrameLayout.getChildMeasureSpec(r103, (((getPaddingTop() + getPaddingBottom()) + r106.topMargin) + r106.bottomMargin) + r104, r106.height));
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }
}
