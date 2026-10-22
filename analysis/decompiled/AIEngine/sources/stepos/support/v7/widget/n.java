package stepos.support.v7.widget;

import android.util.Log;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.List;
import stepos.support.v7.widget.StepOSRecyclerView;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class n<T> extends StepOSRecyclerView.a<RecyclerView.ViewHolder> {

    /* renamed from: e, reason: collision with root package name */
    public static int f12818e = 100000;

    /* renamed from: f, reason: collision with root package name */
    public static int f12819f = 200000;

    /* renamed from: c, reason: collision with root package name */
    public final StepOSRecyclerView.a f12822c;

    /* renamed from: a, reason: collision with root package name */
    public final p.p<StepOSRecyclerView.b> f12820a = new p.p<>();

    /* renamed from: b, reason: collision with root package name */
    public final p.p<StepOSRecyclerView.b> f12821b = new p.p<>();

    /* renamed from: d, reason: collision with root package name */
    public final a f12823d = new a();

    public n(RecyclerView.Adapter adapter) {
        StepOSRecyclerView.a aVar = (StepOSRecyclerView.a) adapter;
        this.f12822c = aVar;
        setHasStableIds(aVar.hasStableIds());
    }

    @Override // stepos.support.v7.widget.StepOSRecyclerView.a
    public final boolean areAllItemsEnabled() {
        StepOSRecyclerView.a aVar = this.f12822c;
        return aVar != null ? aVar.areAllItemsEnabled() : super.areAllItemsEnabled();
    }

    public final int c() {
        StepOSRecyclerView.a aVar = this.f12822c;
        if (aVar != null) {
            return aVar.getItemCount();
        }
        return 0;
    }

    public final boolean d(int i10) {
        int itemCount = getItemCount();
        p.p<StepOSRecyclerView.b> pVar = this.f12820a;
        if (i10 < itemCount) {
            return i10 >= c() + pVar.f11388c;
        }
        StringBuilder sbK = com.stepos.core.ota.d.k(i10, "HeaderAndFooterWrapperAdapter isFooterViewPos : current index is ", ", but total itemcount is ");
        sbK.append(getItemCount());
        sbK.append(", headers:");
        sbK.append(pVar.f11388c);
        sbK.append(", items:");
        sbK.append(c());
        sbK.append(", footers:");
        sbK.append(this.f12821b.f11388c);
        Log.e("HeaderFooterAdapter", sbK.toString());
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return c() + this.f12820a.f11388c + this.f12821b.f11388c;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int i10) {
        int i11;
        int i12;
        p.p<StepOSRecyclerView.b> pVar = this.f12820a;
        if (i10 < pVar.f11388c) {
            i12 = pVar.f11386a[i10];
        } else {
            if (!d(i10)) {
                int i13 = pVar.f11388c;
                StepOSRecyclerView.a aVar = this.f12822c;
                if (aVar == null || i10 < i13 || (i11 = i10 - i13) >= c()) {
                    return -1L;
                }
                return aVar.getItemId(i11);
            }
            i12 = this.f12821b.f11386a[(i10 - pVar.f11388c) - c()];
        }
        return i12;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i10) {
        p.p<StepOSRecyclerView.b> pVar = this.f12820a;
        if (i10 < pVar.f11388c) {
            return pVar.f11386a[i10];
        }
        if (d(i10)) {
            return this.f12821b.f11386a[(i10 - pVar.f11388c) - c()];
        }
        StepOSRecyclerView.a aVar = this.f12822c;
        if (aVar == null) {
            return -2;
        }
        aVar.setHeadCount(pVar.f11388c);
        return aVar.getItemViewType(i10 - pVar.f11388c);
    }

    @Override // stepos.support.v7.widget.StepOSRecyclerView.a, stepos.support.v7.widget.StepOSRecyclerView.s
    public final boolean isEnabled(int i10) {
        int iC;
        p.p<StepOSRecyclerView.b> pVar = this.f12820a;
        int i11 = pVar.f11388c;
        if (i10 >= 0 && i10 < i11) {
            pVar.e(i10);
            return false;
        }
        int i12 = i10 - i11;
        StepOSRecyclerView.a aVar = this.f12822c;
        if (aVar == null || i10 < i11) {
            iC = 0;
        } else {
            iC = c();
            if (i12 < iC) {
                return aVar.isEnabled(i12);
            }
        }
        int i13 = i12 - iC;
        if (i13 >= 0) {
            p.p<StepOSRecyclerView.b> pVar2 = this.f12821b;
            if (i13 < pVar2.f11388c) {
                pVar2.e(i13);
            }
        }
        return false;
    }

    @Override // stepos.support.v7.widget.StepOSRecyclerView.a, stepos.support.v7.widget.StepOSRecyclerView.s
    public final boolean isSelectable(int i10) {
        int i11 = this.f12820a.f11388c;
        if (i10 < i11) {
            return false;
        }
        int i12 = i10 - i11;
        StepOSRecyclerView.a aVar = this.f12822c;
        if (aVar == null || i10 < i11 || i12 >= c()) {
            return false;
        }
        return aVar.isSelectable(i12);
    }

    @Override // stepos.support.v7.widget.StepOSRecyclerView.a, androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onAttachedToRecyclerView(RecyclerView recyclerView) {
        StepOSRecyclerView.a aVar = this.f12822c;
        if (aVar != null) {
            aVar.onAttachedToRecyclerView(recyclerView);
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.setSpanSizeLookup(new m(this, gridLayoutManager, gridLayoutManager.getSpanSizeLookup()));
            gridLayoutManager.setSpanCount(gridLayoutManager.getSpanCount());
        }
    }

    @Override // stepos.support.v7.widget.StepOSRecyclerView.a, androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) {
        StepOSRecyclerView.a aVar;
        p.p<StepOSRecyclerView.b> pVar = this.f12820a;
        if (i10 < pVar.f11388c || d(i10) || (aVar = this.f12822c) == null) {
            return;
        }
        aVar.onBindViewHolder(viewHolder, i10 - pVar.f11388c);
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [androidx.recyclerview.widget.RecyclerView$ViewHolder] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        p.p<StepOSRecyclerView.b> pVar = this.f12820a;
        if (pVar.c(i10) != null) {
            pVar.c(i10).getClass();
            return null;
        }
        p.p<StepOSRecyclerView.b> pVar2 = this.f12821b;
        if (pVar2.c(i10) != null) {
            pVar2.c(i10).getClass();
            return null;
        }
        StepOSRecyclerView.a aVar = this.f12822c;
        if (aVar != null) {
            return aVar.onCreateViewHolder(viewGroup, i10);
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        StepOSRecyclerView.a aVar = this.f12822c;
        if (aVar != null) {
            aVar.onDetachedFromRecyclerView(recyclerView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
        StepOSRecyclerView.a aVar = this.f12822c;
        return aVar != null ? aVar.onFailedToRecycleView(viewHolder) : super.onFailedToRecycleView(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        ViewGroup.LayoutParams layoutParams;
        StepOSRecyclerView.a aVar = this.f12822c;
        if (aVar != null) {
            aVar.onViewAttachedToWindow(viewHolder);
        }
        int layoutPosition = viewHolder.getLayoutPosition();
        if ((layoutPosition >= this.f12820a.f11388c && !d(layoutPosition)) || (layoutParams = viewHolder.itemView.getLayoutParams()) == null || !(layoutParams instanceof StaggeredGridLayoutManager.LayoutParams)) {
            return;
        }
        ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        StepOSRecyclerView.a aVar = this.f12822c;
        if (aVar != null) {
            aVar.onViewDetachedFromWindow(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        StepOSRecyclerView.a aVar = this.f12822c;
        if (aVar != null) {
            aVar.onViewRecycled(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void registerAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        this.f12822c.registerAdapterDataObserver(adapterDataObserver);
        super.registerAdapterDataObserver(this.f12823d);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        this.f12822c.unregisterAdapterDataObserver(adapterDataObserver);
        super.unregisterAdapterDataObserver(this.f12823d);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends RecyclerView.AdapterDataObserver {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onChanged() {
            StepOSRecyclerView.a aVar = n.this.f12822c;
            if (aVar != null) {
                aVar.notifyDataSetChanged();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i10, int i11) {
            StepOSRecyclerView.a aVar = n.this.f12822c;
            if (aVar != null) {
                aVar.notifyItemRangeChanged(i10, i11);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeInserted(int i10, int i11) {
            StepOSRecyclerView.a aVar = n.this.f12822c;
            if (aVar != null) {
                aVar.notifyItemRangeInserted(i10, i11);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeMoved(int i10, int i11, int i12) {
            StepOSRecyclerView.a aVar = n.this.f12822c;
            if (aVar != null) {
                aVar.notifyItemMoved(i10, i11);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeRemoved(int i10, int i11) {
            StepOSRecyclerView.a aVar = n.this.f12822c;
            if (aVar != null) {
                aVar.notifyItemRangeRemoved(i10, i11);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i10, int i11, Object obj) {
            StepOSRecyclerView.a aVar = n.this.f12822c;
            if (aVar != null) {
                aVar.notifyItemRangeChanged(i10, i11, obj);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10, List list) {
        StepOSRecyclerView.a aVar;
        p.p<StepOSRecyclerView.b> pVar = this.f12820a;
        if (i10 < pVar.f11388c || d(i10) || (aVar = this.f12822c) == null) {
            return;
        }
        aVar.onBindViewHolder(viewHolder, i10 - pVar.f11388c, list);
    }
}
