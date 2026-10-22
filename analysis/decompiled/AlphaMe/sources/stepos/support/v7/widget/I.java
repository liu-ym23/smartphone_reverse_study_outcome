package stepos.support.v7.widget;

import android.util.Log;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.List;

/* loaded from: classes2.dex */
public final class I extends X {

    /* renamed from: e, reason: collision with root package name */
    public static int f14825e = 100000;

    /* renamed from: f, reason: collision with root package name */
    public static int f14826f = 200000;

    /* renamed from: c, reason: collision with root package name */
    public final X f14829c;

    /* renamed from: a, reason: collision with root package name */
    public final q.m f14827a = new q.m();

    /* renamed from: b, reason: collision with root package name */
    public final q.m f14828b = new q.m();

    /* renamed from: d, reason: collision with root package name */
    public final H f14830d = new H(this);

    public I(RecyclerView.Adapter adapter) {
        X x4 = (X) adapter;
        this.f14829c = x4;
        setHasStableIds(x4.hasStableIds());
    }

    public final int a() {
        X x4 = this.f14829c;
        if (x4 != null) {
            return x4.getItemCount();
        }
        return 0;
    }

    @Override // stepos.support.v7.widget.X
    public final boolean areAllItemsEnabled() {
        X x4 = this.f14829c;
        return x4 != null ? x4.areAllItemsEnabled() : super.areAllItemsEnabled();
    }

    public final boolean b(int i4) {
        int itemCount = getItemCount();
        q.m mVar = this.f14827a;
        if (i4 < itemCount) {
            return i4 >= a() + mVar.f13973c;
        }
        StringBuilder sbT = B0.g.t("HeaderAndFooterWrapperAdapter isFooterViewPos : current index is ", i4, ", but total itemcount is ");
        sbT.append(getItemCount());
        sbT.append(", headers:");
        sbT.append(mVar.f13973c);
        sbT.append(", items:");
        sbT.append(a());
        sbT.append(", footers:");
        sbT.append(this.f14828b.f13973c);
        Log.e("HeaderFooterAdapter", sbT.toString());
        return false;
    }

    public final boolean c(int i4) {
        return i4 < this.f14827a.f13973c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return a() + this.f14827a.f13973c + this.f14828b.f13973c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int i4) {
        int i5;
        boolean zC = c(i4);
        q.m mVar = this.f14827a;
        if (zC) {
            return mVar.f13971a[i4];
        }
        if (b(i4)) {
            return this.f14828b.f13971a[(i4 - mVar.f13973c) - a()];
        }
        int i6 = mVar.f13973c;
        X x4 = this.f14829c;
        if (x4 == null || i4 < i6 || (i5 = i4 - i6) >= a()) {
            return -1L;
        }
        return x4.getItemId(i5);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i4) {
        boolean zC = c(i4);
        q.m mVar = this.f14827a;
        if (zC) {
            return mVar.f13971a[i4];
        }
        if (b(i4)) {
            return this.f14828b.f13971a[(i4 - mVar.f13973c) - a()];
        }
        X x4 = this.f14829c;
        if (x4 == null) {
            return -2;
        }
        x4.setHeadCount(mVar.f13973c);
        return x4.getItemViewType(i4 - mVar.f13973c);
    }

    @Override // stepos.support.v7.widget.l0
    public final boolean isEnabled(int i4) {
        int iA;
        q.m mVar = this.f14827a;
        int i5 = mVar.f13973c;
        if (i4 >= 0 && i4 < i5) {
            B0.g.y(mVar.f13972b[i4]);
            return false;
        }
        int i6 = i4 - i5;
        X x4 = this.f14829c;
        if (x4 == null || i4 < i5) {
            iA = 0;
        } else {
            iA = a();
            if (i6 < iA) {
                return x4.isEnabled(i6);
            }
        }
        int i7 = i6 - iA;
        if (i7 >= 0) {
            q.m mVar2 = this.f14828b;
            if (i7 < mVar2.f13973c) {
                B0.g.y(mVar2.f13972b[i7]);
            }
        }
        return false;
    }

    @Override // stepos.support.v7.widget.X, stepos.support.v7.widget.l0
    public final boolean isSelectable(int i4) {
        int i5 = this.f14827a.f13973c;
        if (i4 < i5) {
            return false;
        }
        int i6 = i4 - i5;
        X x4 = this.f14829c;
        if (x4 == null || i4 < i5 || i6 >= a()) {
            return false;
        }
        return x4.isSelectable(i6);
    }

    @Override // stepos.support.v7.widget.X, androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onAttachedToRecyclerView(RecyclerView recyclerView) {
        X x4 = this.f14829c;
        if (x4 != null) {
            x4.onAttachedToRecyclerView(recyclerView);
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.setSpanSizeLookup(new G(this, gridLayoutManager, gridLayoutManager.getSpanSizeLookup()));
            gridLayoutManager.setSpanCount(gridLayoutManager.getSpanCount());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i4) {
        X x4;
        if (c(i4) || b(i4) || (x4 = this.f14829c) == null) {
            return;
        }
        x4.onBindViewHolder(viewHolder, i4 - this.f14827a.f13973c);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i4) {
        q.m mVar = this.f14827a;
        if (mVar.c(i4) != null) {
            B0.g.y(mVar.c(i4));
            throw null;
        }
        q.m mVar2 = this.f14828b;
        if (mVar2.c(i4) != null) {
            B0.g.y(mVar2.c(i4));
            throw null;
        }
        X x4 = this.f14829c;
        if (x4 != null) {
            return x4.onCreateViewHolder(viewGroup, i4);
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        X x4 = this.f14829c;
        if (x4 != null) {
            x4.onDetachedFromRecyclerView(recyclerView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
        X x4 = this.f14829c;
        return x4 != null ? x4.onFailedToRecycleView(viewHolder) : super.onFailedToRecycleView(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        ViewGroup.LayoutParams layoutParams;
        X x4 = this.f14829c;
        if (x4 != null) {
            x4.onViewAttachedToWindow(viewHolder);
        }
        int layoutPosition = viewHolder.getLayoutPosition();
        if ((c(layoutPosition) || b(layoutPosition)) && (layoutParams = viewHolder.itemView.getLayoutParams()) != null && (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams)) {
            ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        X x4 = this.f14829c;
        if (x4 != null) {
            x4.onViewDetachedFromWindow(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        X x4 = this.f14829c;
        if (x4 != null) {
            x4.onViewRecycled(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void registerAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        this.f14829c.registerAdapterDataObserver(adapterDataObserver);
        super.registerAdapterDataObserver(this.f14830d);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        this.f14829c.unregisterAdapterDataObserver(adapterDataObserver);
        super.unregisterAdapterDataObserver(this.f14830d);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i4, List list) {
        X x4;
        if (c(i4) || b(i4) || (x4 = this.f14829c) == null) {
            return;
        }
        x4.onBindViewHolder(viewHolder, i4 - this.f14827a.f13973c, list);
    }
}
