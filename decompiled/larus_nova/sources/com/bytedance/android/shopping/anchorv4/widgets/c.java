package com.bytedance.android.shopping.anchorv4.widgets;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f170182a;

    public c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        Integer r102 = this.f170182a;
        int r103 = 0;
        if (r102 != null) goto L5;
    L13:
        int r104 = View.MeasureSpec.getSize(r100);
        measureChildren(r100, r101);
        int r105 = getChildCount();
        int r106 = 0;
    L14:
        if (r103 >= r105) goto L16;
        r106 = r106 + getChildAt(r103).getMeasuredHeight();
        r103 = r103 + 1;
        goto L14
    L16:
        setMeasuredDimension(r104, r106);
        return;
    L5:
        if (r102.intValue() <= 0) goto L7;
        boolean r107 = true;
    L8:
        if (r107 == true) goto L11;
        r102 = null;
    L11:
        if (r102 == null) goto L13;
        r101 = View.MeasureSpec.makeMeasureSpec(r102.intValue(), Integer.MIN_VALUE);
        goto L13
    L7:
        r107 = false;
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        int r105 = getChildCount();
        int r106 = 0;
    L3:
        if (r106 >= r105) goto L8;
        View r107 = getChildAt(r106);
        if (r107.getVisibility() == 8) goto L7;
        int r108 = r107.getMeasuredWidth();
        int r109 = r107.getMeasuredHeight() + r102;
        r107.layout(r101, r102, r108 + r101, r109);
        r102 = r109;
    L7:
        r106 = r106 + 1;
        goto L3
    }
}
