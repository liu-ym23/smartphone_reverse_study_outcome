package com.obric.oui.orecyclerview.widget;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0004H&¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0013\u0010\u000f¨\u0006\u0014"}, d2 = {"com/obric/oui/orecyclerview/widget/ODragItemTouchHelper$Callback", "", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$t;", "viewHolder", "", "fromPosition", "toPosition", "", "onPositionChange", "(Lcom/obric/oui/orecyclerview/widget/RecyclerView$t;II)Z", "position", "onCheckCanDrag", "(Lcom/obric/oui/orecyclerview/widget/RecyclerView$t;I)Z", "", "onStartDrag", "(Lcom/obric/oui/orecyclerview/widget/RecyclerView$t;)V", "offset", "onDragging", "(Lcom/obric/oui/orecyclerview/widget/RecyclerView$t;I)V", "onEndDrag", "OUIRecyclerView_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ODragItemTouchHelper$Callback {
    boolean onCheckCanDrag(@NotNull RecyclerView.t r10, int r11);

    void onDragging(@NotNull RecyclerView.t r10, int r11);

    void onEndDrag(@NotNull RecyclerView.t r10);

    boolean onPositionChange(@NotNull RecyclerView.t r10, int r11, int r12);

    void onStartDrag(@NotNull RecyclerView.t r10);
}
