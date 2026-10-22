package com.bytedance.android.live.revlink.impl.pk.ui;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/pk/ui/CrossRoomContainerLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CrossRoomContainerLayout extends ConstraintLayout {
    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View, android.view.ViewParent
    public final void requestLayout() {
        super.requestLayout();
        z41.a.f569893f.getClass();
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L5;
    L7:
        boolean r100 = false;
    L8:
        if (r100 == false) goto L11;
        jy0.b.e("PkMeasureDebugUtils", "CrossRoomContainerLayout requestLayout", new IllegalStateException());
        return;
    L11:
        return;
    L5:
        if (z41.a.f569891d == false) goto L7;
        r100 = true;
        goto L8
    }

    public CrossRoomContainerLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }

    public CrossRoomContainerLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        z41.a.f569893f.getClass();
        if (com.bytedance.android.live.core.utils.v.a() == true) goto L5;
    L7:
        boolean r102 = false;
    L9:
        if (r102 == false) goto L11;
        long r103 = System.currentTimeMillis();
    L12:
        super.onMeasure(r100, r101);
        if (r103 <= 0) goto L16;
        jy0.b.f("PkMeasureDebugUtils", "CrossRoomContainerLayout onMeasure " + (System.currentTimeMillis() - r103) + "ms", null, 4);
        return;
    L16:
        return;
    L11:
        r103 = 0;
        goto L12
    L5:
        if (z41.a.f569892e == false) goto L7;
        r102 = true;
        goto L9
    }

    public CrossRoomContainerLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }
}
