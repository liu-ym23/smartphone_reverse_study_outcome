package com.bytedance.android.livesdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/widget/ReverseHorizontalLinearLayout;", "Landroid/widget/LinearLayout;", "", "reverse", "", "setReverse", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReverseHorizontalLinearLayout extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f161257a;

    public ReverseHorizontalLinearLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ReverseHorizontalLinearLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void setReverse(boolean r100) {
        this.f161257a = r100;
        requestLayout();
    }

    public ReverseHorizontalLinearLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f161257a = true;
        setOrientation(0);
    }

    public /* synthetic */ ReverseHorizontalLinearLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        if (getOrientation() == 0) goto L5;
        return;
    L5:
        if (this.f161257a == false) goto L11;
        int r105 = getChildCount();
        int r106 = getRight() - getLeft();
        int r107 = 0;
    L7:
        if (r107 >= r105) goto L12;
        View r108 = getChildAt(r107);
        int r109 = r108.getRight() - r108.getLeft();
        int r110 = r106 - r108.getLeft();
        r108.layout(r110 - r109, r108.getTop(), r110, r108.getBottom());
        r107 = r107 + 1;
        goto L7
    L12:
        return;
    }
}
