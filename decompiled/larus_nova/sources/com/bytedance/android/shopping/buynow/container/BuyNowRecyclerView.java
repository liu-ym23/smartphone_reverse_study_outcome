package com.bytedance.android.shopping.buynow.container;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/buynow/container/BuyNowRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BuyNowRecyclerView extends RecyclerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f170768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f170769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.shopping.buynow.controller.m f170770c;

    public BuyNowRecyclerView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f170770c = new com.bytedance.android.shopping.buynow.controller.m(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        if (r100.getAction() != 1) goto L5;
    L10:
        this.f170769b = false;
    L11:
        float r101 = this.f170768a;
        if (r101 == 0.0f) goto L15;
        r100.offsetLocation(0.0f, r101);
    L15:
        return super.dispatchTouchEvent(r100);
    L5:
        if (r100.getAction() == 3) goto L10;
        if (r100.getAction() != 0) goto L11;
        this.f170768a = 0.0f;
        this.f170769b = true;
        goto L11
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        com.bytedance.android.shopping.buynow.controller.m r101 = this.f170770c;
        if (r101 == null) goto L9;
        Boolean r102 = r101.b(r100);
        if (r102 == null) goto L9;
        return r102.booleanValue();
    L9:
        return super.onInterceptTouchEvent(r100);
    }

    public BuyNowRecyclerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f170770c = new com.bytedance.android.shopping.buynow.controller.m(this);
    }

    public BuyNowRecyclerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f170770c = new com.bytedance.android.shopping.buynow.controller.m(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (this.f170769b == false) goto L7;
        if (r103 == r101) goto L8;
        this.f170768a = r103 - r101;
        return;
    L8:
        return;
    }
}
