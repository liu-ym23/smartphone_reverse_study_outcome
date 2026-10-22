package com.obric.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScreenCenterLayout.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J0\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eH\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/widget/ScreenCenterRelativeLayout;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "loc", "", "onLayout", "", "changed", "", "left", "", "top", "right", "bottom", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ScreenCenterRelativeLayout extends RelativeLayout {
    private final int[] loc;

    /* JADX WARN: Multi-variable type inference failed */
    public ScreenCenterRelativeLayout(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ ScreenCenterRelativeLayout(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public ScreenCenterRelativeLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.loc = new int[2];
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r2, int r3, int r4, int r5, int r6) {
        View r7 = getChildAt(0);
        if (r7 != null) goto L5;
        return;
    L5:
        View r8 = getRootView();
        if (r8 != null) goto L8;
        return;
    L8:
        getLocationInWindow(this.loc);
        int r9 = r8.getMeasuredWidth();
        int r10 = ((r8.getMeasuredHeight() - r7.getMeasuredHeight()) / 2) - this.loc[1];
        int r11 = ((r9 - r7.getMeasuredWidth()) / 2) - this.loc[0];
        r7.layout(r11, r10, r7.getMeasuredWidth() + r11, r7.getMeasuredHeight() + r10);
    }
}
