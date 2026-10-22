package com.bytedance.android.livesdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/widget/ReverseLinearLayout;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liveui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReverseLinearLayout extends LinearLayout {
    public ReverseLinearLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ReverseLinearLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r110, int r111) {
        int r100 = getChildCount() - 1;
        int r101 = 0;
        int r102 = 0;
    L3:
        if (r100 < 0) goto L15;
        View r112 = getChildAt(r100);
        if (r112 == null) goto L14;
        if (r112.getVisibility() == 8) goto L14;
        measureChildWithMargins(r112, r110, r102, r111, 0);
        ViewGroup.LayoutParams r103 = r112.getLayoutParams();
        if (r103 == null) goto L13;
        LinearLayout.LayoutParams r104 = (LinearLayout.LayoutParams) r103;
        int r105 = r112.getMeasuredWidth();
        int r106 = (r112.getMeasuredHeight() + r104.topMargin) + r104.bottomMargin;
        r102 = r102 + ((r105 + r104.leftMargin) + r104.rightMargin);
        r101 = Math.max(r101, r106);
        goto L14
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L14:
        r100 = r100 - 1;
        goto L3
    L15:
        setMeasuredDimension(LinearLayout.resolveSizeAndState(Math.max((r102 + getPaddingLeft()) + getPaddingRight(), getSuggestedMinimumWidth()), r110, 0), LinearLayout.resolveSizeAndState(Math.max(r101 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), r111, 0));
    }

    public ReverseLinearLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setOrientation(0);
    }

    public /* synthetic */ ReverseLinearLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
