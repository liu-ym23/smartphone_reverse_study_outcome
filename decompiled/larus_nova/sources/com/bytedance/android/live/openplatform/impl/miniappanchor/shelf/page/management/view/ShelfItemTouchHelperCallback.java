package com.bytedance.android.live.openplatform.impl.miniappanchor.shelf.page.management.view;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/shelf/page/management/view/ShelfItemTouchHelperCallback;", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShelfItemTouchHelperCallback extends ItemTouchHelper.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f84576a;

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final boolean isItemViewSwipeEnabled() {
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final void onSwiped(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "viewHolder");
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final boolean isLongPressDragEnabled() {
        return this.f84576a.isDraggable();
    }

    public ShelfItemTouchHelperCallback(a r100) {
        Intrinsics.checkNotNullParameter(r100, "adapter");
        this.f84576a = r100;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final void clearView(RecyclerView r100, RecyclerView.ViewHolder r101) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        Intrinsics.checkNotNullParameter(r101, "viewHolder");
        super.clearView(r100, r101);
        if (r100.isComputingLayout() == true) goto L6;
        this.f84576a.g();
        return;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final int getMovementFlags(RecyclerView r100, RecyclerView.ViewHolder r101) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        Intrinsics.checkNotNullParameter(r101, "viewHolder");
        return ItemTouchHelper.Callback.makeMovementFlags(3, 0);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final void onSelectedChanged(RecyclerView.ViewHolder r100, int r101) {
        super.onSelectedChanged(r100, r101);
        if (r101 != 2) goto L6;
        this.f84576a.c();
        return;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final boolean onMove(RecyclerView r100, RecyclerView.ViewHolder r101, RecyclerView.ViewHolder r102) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        Intrinsics.checkNotNullParameter(r101, "viewHolder");
        Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
        this.f84576a.r(r101, r102);
        return true;
    }
}
