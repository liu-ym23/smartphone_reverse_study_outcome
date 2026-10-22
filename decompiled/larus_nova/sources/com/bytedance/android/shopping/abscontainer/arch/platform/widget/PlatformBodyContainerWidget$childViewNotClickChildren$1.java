package com.bytedance.android.shopping.abscontainer.arch.platform.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/bytedance/android/shopping/abscontainer/arch/platform/widget/PlatformBodyContainerWidget$childViewNotClickChildren$1", "Landroidx/recyclerview/widget/RecyclerView$OnChildAttachStateChangeListener;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlatformBodyContainerWidget$childViewNotClickChildren$1 implements RecyclerView.OnChildAttachStateChangeListener {
    public PlatformBodyContainerWidget$childViewNotClickChildren$1() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public final void onChildViewDetachedFromWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
    public final void onChildViewAttachedToWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if ((r100 instanceof ViewGroup) == true) goto L5;
        r100 = null;
    L5:
        ViewGroup r101 = (ViewGroup) r100;
        if (r101 == null) goto L9;
        r101.setClipChildren(false);
        return;
    }
}
