package stepos.support.v7.widget;

import android.util.Log;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.List;
import stepos.support.v7.widget.StepOSRecyclerView;

/* loaded from: classes5.dex */
public class m<T> extends StepOSRecyclerView.c<RecyclerView.ViewHolder> {

    /* renamed from: e, reason: collision with root package name */
    public static int f41650e = 100000;

    /* renamed from: f, reason: collision with root package name */
    public static int f41651f = 200000;

    /* renamed from: c, reason: collision with root package name */
    public StepOSRecyclerView.c f41654c;

    /* renamed from: a, reason: collision with root package name */
    public androidx.collection.u<StepOSRecyclerView.d> f41652a = new androidx.collection.u<>();

    /* renamed from: b, reason: collision with root package name */
    public androidx.collection.u<StepOSRecyclerView.d> f41653b = new androidx.collection.u<>();

    /* renamed from: d, reason: collision with root package name */
    public final RecyclerView.AdapterDataObserver f41655d = new b();

    public class a extends GridLayoutManager.SpanSizeLookup {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GridLayoutManager f41656a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ GridLayoutManager.SpanSizeLookup f41657b;

        public a(GridLayoutManager gridLayoutManager, GridLayoutManager.SpanSizeLookup spanSizeLookup) {
            this.f41656a = gridLayoutManager;
            this.f41657b = spanSizeLookup;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i10) {
            int itemViewType = m.this.getItemViewType(i10);
            if (m.this.f41652a.g(itemViewType) == null && m.this.f41653b.g(itemViewType) == null) {
                GridLayoutManager.SpanSizeLookup spanSizeLookup = this.f41657b;
                if (spanSizeLookup != null) {
                    return spanSizeLookup.getSpanSize(i10);
                }
                return 1;
            }
            return this.f41656a.getSpanCount();
        }
    }

    public m(RecyclerView.Adapter adapter) {
        StepOSRecyclerView.c cVar = (StepOSRecyclerView.c) adapter;
        this.f41654c = cVar;
        setHasStableIds(cVar.hasStableIds());
    }

    @Override // stepos.support.v7.widget.StepOSRecyclerView.c
    public boolean areAllItemsEnabled() {
        StepOSRecyclerView.c cVar = this.f41654c;
        return cVar != null ? cVar.areAllItemsEnabled() : super.areAllItemsEnabled();
    }

    public void f(StepOSRecyclerView.d dVar) {
        androidx.collection.u<StepOSRecyclerView.d> uVar = this.f41653b;
        int i10 = f41651f;
        f41651f = i10 + 1;
        uVar.j(i10, dVar);
    }

    public void g(StepOSRecyclerView.d dVar) {
        androidx.collection.u<StepOSRecyclerView.d> uVar = this.f41652a;
        int i10 = f41650e;
        f41650e = i10 + 1;
        uVar.j(i10, dVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return i() + h() + j();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i10) {
        int i11;
        if (l(i10)) {
            return this.f41652a.i(i10);
        }
        if (k(i10)) {
            return this.f41653b.i((i10 - i()) - j());
        }
        int i12 = i();
        if (this.f41654c == null || i10 < i12 || (i11 = i10 - i12) >= j()) {
            return -1L;
        }
        return this.f41654c.getItemId(i11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i10) {
        if (l(i10)) {
            return this.f41652a.i(i10);
        }
        if (k(i10)) {
            return this.f41653b.i((i10 - i()) - j());
        }
        StepOSRecyclerView.c cVar = this.f41654c;
        if (cVar == null) {
            return -2;
        }
        cVar.setHeadCount(i());
        return this.f41654c.getItemViewType(i10 - i());
    }

    public int h() {
        return this.f41653b.k();
    }

    public int i() {
        return this.f41652a.k();
    }

    @Override // stepos.support.v7.widget.StepOSRecyclerView.c, stepos.support.v7.widget.StepOSRecyclerView.u
    public boolean isEnabled(int i10) {
        int iJ;
        StepOSRecyclerView.d dVarN;
        int i11 = i();
        if (i10 >= 0 && i10 < i11) {
            StepOSRecyclerView.d dVarN2 = this.f41652a.n(i10);
            if (dVarN2 != null) {
                return dVarN2.f41387b;
            }
            return false;
        }
        int i12 = i10 - i11;
        if (this.f41654c == null || i10 < i11) {
            iJ = 0;
        } else {
            iJ = j();
            if (i12 < iJ) {
                return this.f41654c.isEnabled(i12);
            }
        }
        int i13 = i12 - iJ;
        if (i13 < 0 || i13 >= h() || (dVarN = this.f41653b.n(i13)) == null) {
            return false;
        }
        return dVarN.f41387b;
    }

    @Override // stepos.support.v7.widget.StepOSRecyclerView.c, stepos.support.v7.widget.StepOSRecyclerView.u
    public boolean isSelectable(int i10) {
        int i11 = i();
        if (i10 < i11) {
            return false;
        }
        int i12 = i10 - i11;
        if (this.f41654c == null || i10 < i11 || i12 >= j()) {
            return false;
        }
        return this.f41654c.isSelectable(i12);
    }

    public final int j() {
        StepOSRecyclerView.c cVar = this.f41654c;
        if (cVar != null) {
            return cVar.getItemCount();
        }
        return 0;
    }

    public final boolean k(int i10) {
        if (i10 < getItemCount()) {
            return i10 >= i() + j();
        }
        Log.e("HeaderFooterAdapter", "HeaderAndFooterWrapperAdapter isFooterViewPos : current index is " + i10 + ", but total itemcount is " + getItemCount() + ", headers:" + i() + ", items:" + j() + ", footers:" + h());
        return false;
    }

    public final boolean l(int i10) {
        return i10 < i();
    }

    public void m(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.setSpanSizeLookup(new a(gridLayoutManager, gridLayoutManager.getSpanSizeLookup()));
            gridLayoutManager.setSpanCount(gridLayoutManager.getSpanCount());
        }
    }

    @Override // stepos.support.v7.widget.StepOSRecyclerView.c, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        StepOSRecyclerView.c cVar = this.f41654c;
        if (cVar != null) {
            cVar.onAttachedToRecyclerView(recyclerView);
        }
        m(recyclerView);
    }

    @Override // stepos.support.v7.widget.StepOSRecyclerView.c, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10) {
        StepOSRecyclerView.c cVar;
        if (l(i10) || k(i10) || (cVar = this.f41654c) == null) {
            return;
        }
        cVar.onBindViewHolder(viewHolder, i10 - i());
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [androidx.recyclerview.widget.RecyclerView$ViewHolder] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        if (this.f41652a.g(i10) != null) {
            return this.f41652a.g(i10).f41386a;
        }
        if (this.f41653b.g(i10) != null) {
            return this.f41653b.g(i10).f41386a;
        }
        StepOSRecyclerView.c cVar = this.f41654c;
        if (cVar != null) {
            return cVar.onCreateViewHolder(viewGroup, i10);
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        StepOSRecyclerView.c cVar = this.f41654c;
        if (cVar != null) {
            cVar.onDetachedFromRecyclerView(recyclerView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
        StepOSRecyclerView.c cVar = this.f41654c;
        return cVar != null ? cVar.onFailedToRecycleView(viewHolder) : super.onFailedToRecycleView(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        ViewGroup.LayoutParams layoutParams;
        StepOSRecyclerView.c cVar = this.f41654c;
        if (cVar != null) {
            cVar.onViewAttachedToWindow(viewHolder);
        }
        int layoutPosition = viewHolder.getLayoutPosition();
        if ((l(layoutPosition) || k(layoutPosition)) && (layoutParams = viewHolder.itemView.getLayoutParams()) != null && (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams)) {
            ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        StepOSRecyclerView.c cVar = this.f41654c;
        if (cVar != null) {
            cVar.onViewDetachedFromWindow(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        StepOSRecyclerView.c cVar = this.f41654c;
        if (cVar != null) {
            cVar.onViewRecycled(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        this.f41654c.registerAdapterDataObserver(adapterDataObserver);
        super.registerAdapterDataObserver(this.f41655d);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        this.f41654c.unregisterAdapterDataObserver(adapterDataObserver);
        super.unregisterAdapterDataObserver(this.f41655d);
    }

    public class b extends RecyclerView.AdapterDataObserver {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            if (m.this.f41654c != null) {
                m.this.f41654c.notifyDataSetChanged();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i10, int i11) {
            if (m.this.f41654c != null) {
                m.this.f41654c.notifyItemRangeChanged(i10, i11);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i10, int i11) {
            if (m.this.f41654c != null) {
                m.this.f41654c.notifyItemRangeInserted(i10, i11);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i10, int i11, int i12) {
            if (m.this.f41654c != null) {
                m.this.f41654c.notifyItemMoved(i10, i11);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i10, int i11) {
            if (m.this.f41654c != null) {
                m.this.f41654c.notifyItemRangeRemoved(i10, i11);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i10, int i11, Object obj) {
            if (m.this.f41654c != null) {
                m.this.f41654c.notifyItemRangeChanged(i10, i11, obj);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i10, List list) {
        StepOSRecyclerView.c cVar;
        if (l(i10) || k(i10) || (cVar = this.f41654c) == null) {
            return;
        }
        cVar.onBindViewHolder(viewHolder, i10 - i(), list);
    }
}
