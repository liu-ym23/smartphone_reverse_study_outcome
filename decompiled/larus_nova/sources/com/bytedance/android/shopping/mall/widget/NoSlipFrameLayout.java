package com.bytedance.android.shopping.mall.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/mall/widget/NoSlipFrameLayout;", "Landroid/widget/FrameLayout;", "", "enableSlip", "", "setEnableControlSlip", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NoSlipFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f178629a;

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        if (this.f178629a == true) goto L7;
        return super.dispatchTouchEvent(r100);
    L7:
        if (r100.getAction() != 0) goto L11;
        getParent().requestDisallowInterceptTouchEvent(true);
    L11:
        return super.dispatchTouchEvent(r100);
    }

    public final void setEnableControlSlip(boolean r100) {
        this.f178629a = r100;
    }

    public NoSlipFrameLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attributeSet");
        super(r100, r101);
    }
}
