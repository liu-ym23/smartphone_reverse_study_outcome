package com.bytedance.android.live.profile.ui.component.descriptioncomponent.groupmember;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/profile/ui/component/descriptioncomponent/groupmember/HorizontalSpacingItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HorizontalSpacingItemDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f86523a;

    public HorizontalSpacingItemDecoration(int r100) {
        this.f86523a = r100;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect r100, View r101, RecyclerView r102, RecyclerView.State r103) {
        Intrinsics.checkNotNullParameter(r100, "outRect");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "parent");
        Intrinsics.checkNotNullParameter(r103, "state");
        if (r102.getChildAdapterPosition(r101) != 0) goto L6;
        r100.left = this.f86523a;
        return;
    L6:
        if (r102.getChildAdapterPosition(r101) != (r103.getItemCount() - 1)) goto L8;
        r100.right = this.f86523a;
        return;
    L8:
        int r104 = this.f86523a;
        r100.left = r104;
        r100.right = r104;
    }
}
