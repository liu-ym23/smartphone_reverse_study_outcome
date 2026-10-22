package androidx.appcompat.widget;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000¨\u0006\t"}, d2 = {"getRecyclerMaxScrap", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "viewType", "resetViewHolder", "", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "ext_adapter_release"}, k = 2, mv = {1, 1, 16})
public final class JediRecyclerHelperKt {
    public static final void resetViewHolder(RecyclerView.ViewHolder r100) {
        r100.resetInternal();
    }

    public static final int getRecyclerMaxScrap(RecyclerView r100, int r101) {
        RecyclerView.RecycledViewPool.ScrapData r102 = r100.getRecycledViewPool().mScrap.get(r101);
        if (r102 != null) goto L7;
        return -1;
    L7:
        return r102.mMaxScrap;
    }
}
