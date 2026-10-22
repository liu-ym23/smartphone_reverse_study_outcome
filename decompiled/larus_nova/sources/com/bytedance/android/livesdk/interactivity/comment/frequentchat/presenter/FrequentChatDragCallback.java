package com.bytedance.android.livesdk.interactivity.comment.frequentchat.presenter;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.interactivity.comment.frequentchat.model.FrequentChatViewHolder;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/frequentchat/presenter/FrequentChatDragCallback;", "Landroidx/recyclerview/widget/ItemTouchHelper$Callback;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FrequentChatDragCallback extends ItemTouchHelper.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t62.a f134886a;

    public static final class a {
    }

    static {
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final float getMoveThreshold(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "viewHolder");
        return 1.0f;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final boolean isItemViewSwipeEnabled() {
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final boolean isLongPressDragEnabled() {
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final void onSwiped(RecyclerView.ViewHolder r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "viewHolder");
    }

    public FrequentChatDragCallback(t62.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f134886a = r100;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final void clearView(RecyclerView r100, RecyclerView.ViewHolder r101) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        Intrinsics.checkNotNullParameter(r101, "viewHolder");
        super.clearView(r100, r101);
        if ((r101 instanceof FrequentChatViewHolder) == true) goto L5;
        r101 = null;
    L5:
        FrequentChatViewHolder r102 = (FrequentChatViewHolder) r101;
        if (r102 == null) goto L12;
        CardView r103 = r102.f134879b;
        if (r103 == null) goto L13;
        r103.setCardElevation(0.0f);
        return;
    L13:
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
        if (r101 == 2) goto L6;
    L15:
        super.onSelectedChanged(r100, r101);
        return;
    L6:
        if ((r100 instanceof FrequentChatViewHolder) == true) goto L8;
        RecyclerView.ViewHolder r102 = null;
    L9:
        FrequentChatViewHolder r103 = (FrequentChatViewHolder) r102;
        if (r103 == null) goto L17;
        CardView r104 = r103.f134879b;
        if (r104 == null) goto L18;
        r104.setCardElevation(10.0f);
        goto L15
    L18:
        return;
    L17:
        return;
    L8:
        r102 = r100;
        goto L9
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final boolean onMove(RecyclerView r100, RecyclerView.ViewHolder r101, RecyclerView.ViewHolder r102) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        Intrinsics.checkNotNullParameter(r101, "viewHolder");
        Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
        this.f134886a.J(r101.getAdapterPosition(), r102.getAdapterPosition());
        return true;
    }
}
