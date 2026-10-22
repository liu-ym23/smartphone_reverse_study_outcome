package stepos.support.v7.widget;

import android.util.Log;
import android.view.ViewGroup;
import androidx.collection.SparseArrayCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.List;

/* loaded from: classes4.dex */
public final class N extends AbstractC1988f0 {
    public static int e = 100000;
    public static int f = 200000;
    public final AbstractC1988f0 c;

    /* renamed from: a, reason: collision with root package name */
    public final SparseArrayCompat f6474a = new SparseArrayCompat();
    public final SparseArrayCompat b = new SparseArrayCompat();
    public final M d = new M(this);

    public N(RecyclerView.Adapter adapter) {
        AbstractC1988f0 abstractC1988f0 = (AbstractC1988f0) adapter;
        this.c = abstractC1988f0;
        setHasStableIds(abstractC1988f0.hasStableIds());
    }

    public final int a() {
        AbstractC1988f0 abstractC1988f0 = this.c;
        if (abstractC1988f0 != null) {
            return abstractC1988f0.getItemCount();
        }
        return 0;
    }

    @Override // stepos.support.v7.widget.AbstractC1988f0
    public final boolean areAllItemsEnabled() {
        AbstractC1988f0 abstractC1988f0 = this.c;
        return abstractC1988f0 != null ? abstractC1988f0.areAllItemsEnabled() : super.areAllItemsEnabled();
    }

    public final boolean b(int i) {
        int itemCount = getItemCount();
        SparseArrayCompat sparseArrayCompat = this.f6474a;
        if (i < itemCount) {
            return i >= a() + sparseArrayCompat.size();
        }
        StringBuilder sbU = B7.a.u(i, "HeaderAndFooterWrapperAdapter isFooterViewPos : current index is ", ", but total itemcount is ");
        sbU.append(getItemCount());
        sbU.append(", headers:");
        sbU.append(sparseArrayCompat.size());
        sbU.append(", items:");
        sbU.append(a());
        sbU.append(", footers:");
        sbU.append(this.b.size());
        Log.e("HeaderFooterAdapter", sbU.toString());
        return false;
    }

    public final boolean c(int i) {
        return i < this.f6474a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return a() + this.b.size() + this.f6474a.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int i) {
        int i6;
        int iKeyAt;
        boolean zC = c(i);
        SparseArrayCompat sparseArrayCompat = this.f6474a;
        if (zC) {
            iKeyAt = sparseArrayCompat.keyAt(i);
        } else {
            if (!b(i)) {
                int size = sparseArrayCompat.size();
                AbstractC1988f0 abstractC1988f0 = this.c;
                if (abstractC1988f0 == null || i < size || (i6 = i - size) >= a()) {
                    return -1L;
                }
                return abstractC1988f0.getItemId(i6);
            }
            iKeyAt = this.b.keyAt((i - sparseArrayCompat.size()) - a());
        }
        return iKeyAt;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i) {
        boolean zC = c(i);
        SparseArrayCompat sparseArrayCompat = this.f6474a;
        if (zC) {
            return sparseArrayCompat.keyAt(i);
        }
        if (b(i)) {
            return this.b.keyAt((i - sparseArrayCompat.size()) - a());
        }
        AbstractC1988f0 abstractC1988f0 = this.c;
        if (abstractC1988f0 == null) {
            return -2;
        }
        abstractC1988f0.setHeadCount(sparseArrayCompat.size());
        return abstractC1988f0.getItemViewType(i - sparseArrayCompat.size());
    }

    @Override // stepos.support.v7.widget.t0
    public final boolean isEnabled(int i) {
        int iA;
        SparseArrayCompat sparseArrayCompat = this.f6474a;
        int size = sparseArrayCompat.size();
        if (i < 0 || i >= size) {
            int i6 = i - size;
            AbstractC1988f0 abstractC1988f0 = this.c;
            if (abstractC1988f0 == null || i < size) {
                iA = 0;
            } else {
                iA = a();
                if (i6 < iA) {
                    return abstractC1988f0.isEnabled(i6);
                }
            }
            int i10 = i6 - iA;
            if (i10 >= 0) {
                SparseArrayCompat sparseArrayCompat2 = this.b;
                if (i10 < sparseArrayCompat2.size() && sparseArrayCompat2.valueAt(i10) != null) {
                    throw new ClassCastException();
                }
            }
        } else if (sparseArrayCompat.valueAt(i) != null) {
            throw new ClassCastException();
        }
        return false;
    }

    @Override // stepos.support.v7.widget.AbstractC1988f0, stepos.support.v7.widget.t0
    public final boolean isSelectable(int i) {
        int size = this.f6474a.size();
        if (i < size) {
            return false;
        }
        int i6 = i - size;
        AbstractC1988f0 abstractC1988f0 = this.c;
        if (abstractC1988f0 == null || i < size || i6 >= a()) {
            return false;
        }
        return abstractC1988f0.isSelectable(i6);
    }

    @Override // stepos.support.v7.widget.AbstractC1988f0, androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onAttachedToRecyclerView(RecyclerView recyclerView) {
        AbstractC1988f0 abstractC1988f0 = this.c;
        if (abstractC1988f0 != null) {
            abstractC1988f0.onAttachedToRecyclerView(recyclerView);
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.setSpanSizeLookup(new L(this, gridLayoutManager, gridLayoutManager.getSpanSizeLookup()));
            gridLayoutManager.setSpanCount(gridLayoutManager.getSpanCount());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        AbstractC1988f0 abstractC1988f0;
        if (c(i) || b(i) || (abstractC1988f0 = this.c) == null) {
            return;
        }
        abstractC1988f0.onBindViewHolder(viewHolder, i - this.f6474a.size());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        SparseArrayCompat sparseArrayCompat = this.f6474a;
        if (sparseArrayCompat.get(i) != null) {
            sparseArrayCompat.get(i).getClass();
            throw new ClassCastException();
        }
        SparseArrayCompat sparseArrayCompat2 = this.b;
        if (sparseArrayCompat2.get(i) != null) {
            sparseArrayCompat2.get(i).getClass();
            throw new ClassCastException();
        }
        AbstractC1988f0 abstractC1988f0 = this.c;
        if (abstractC1988f0 != null) {
            return abstractC1988f0.onCreateViewHolder(viewGroup, i);
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        AbstractC1988f0 abstractC1988f0 = this.c;
        if (abstractC1988f0 != null) {
            abstractC1988f0.onDetachedFromRecyclerView(recyclerView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
        AbstractC1988f0 abstractC1988f0 = this.c;
        return abstractC1988f0 != null ? abstractC1988f0.onFailedToRecycleView(viewHolder) : super.onFailedToRecycleView(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        ViewGroup.LayoutParams layoutParams;
        AbstractC1988f0 abstractC1988f0 = this.c;
        if (abstractC1988f0 != null) {
            abstractC1988f0.onViewAttachedToWindow(viewHolder);
        }
        int layoutPosition = viewHolder.getLayoutPosition();
        if ((c(layoutPosition) || b(layoutPosition)) && (layoutParams = viewHolder.itemView.getLayoutParams()) != null && (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams)) {
            ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        AbstractC1988f0 abstractC1988f0 = this.c;
        if (abstractC1988f0 != null) {
            abstractC1988f0.onViewDetachedFromWindow(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        AbstractC1988f0 abstractC1988f0 = this.c;
        if (abstractC1988f0 != null) {
            abstractC1988f0.onViewRecycled(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void registerAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        this.c.registerAdapterDataObserver(adapterDataObserver);
        super.registerAdapterDataObserver(this.d);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        this.c.unregisterAdapterDataObserver(adapterDataObserver);
        super.unregisterAdapterDataObserver(this.d);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list) {
        AbstractC1988f0 abstractC1988f0;
        if (c(i) || b(i) || (abstractC1988f0 = this.c) == null) {
            return;
        }
        abstractC1988f0.onBindViewHolder(viewHolder, i - this.f6474a.size(), list);
    }
}
