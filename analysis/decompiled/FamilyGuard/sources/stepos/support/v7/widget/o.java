package stepos.support.v7.widget;

import android.content.res.Resources;
import android.util.Log;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.List;
import stepos.support.v7.widget.StepOSRecyclerView;

/* loaded from: classes.dex */
public class o<T> extends StepOSRecyclerView.c<RecyclerView.ViewHolder> {

    /* renamed from: e, reason: collision with root package name */
    private static int f22081e = 100000;

    /* renamed from: f, reason: collision with root package name */
    private static int f22082f = 200000;

    /* renamed from: c, reason: collision with root package name */
    private StepOSRecyclerView.c f22085c;

    /* renamed from: a, reason: collision with root package name */
    private q.j<StepOSRecyclerView.d> f22083a = new q.j<>();

    /* renamed from: b, reason: collision with root package name */
    private q.j<StepOSRecyclerView.d> f22084b = new q.j<>();

    /* renamed from: d, reason: collision with root package name */
    private final RecyclerView.AdapterDataObserver f22086d = new b();

    class a extends GridLayoutManager.SpanSizeLookup {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GridLayoutManager f22087a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GridLayoutManager.SpanSizeLookup f22088b;

        a(GridLayoutManager gridLayoutManager, GridLayoutManager.SpanSizeLookup spanSizeLookup) {
            this.f22087a = gridLayoutManager;
            this.f22088b = spanSizeLookup;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i5) {
            int itemViewType = o.this.getItemViewType(i5);
            if (o.this.f22083a.g(itemViewType) == null && o.this.f22084b.g(itemViewType) == null) {
                GridLayoutManager.SpanSizeLookup spanSizeLookup = this.f22088b;
                if (spanSizeLookup != null) {
                    return spanSizeLookup.getSpanSize(i5);
                }
                return 1;
            }
            return this.f22087a.getSpanCount();
        }
    }

    public o(RecyclerView.Adapter adapter) {
        StepOSRecyclerView.c cVar = (StepOSRecyclerView.c) adapter;
        this.f22085c = cVar;
        setHasStableIds(cVar.hasStableIds());
    }

    private int t() {
        StepOSRecyclerView.c cVar = this.f22085c;
        if (cVar != null) {
            return cVar.getItemCount();
        }
        return 0;
    }

    private boolean w(int i5) {
        if (i5 < getItemCount()) {
            return i5 >= s() + t();
        }
        Log.e("HeaderFooterAdapter", "HeaderAndFooterWrapperAdapter isFooterViewPos : current index is " + i5 + ", but total itemcount is " + getItemCount() + ", headers:" + s() + ", items:" + t() + ", footers:" + q());
        return false;
    }

    private boolean x(int i5) {
        return i5 < s();
    }

    @Override // stepos.support.v7.widget.StepOSRecyclerView.c
    public boolean areAllItemsEnabled() {
        StepOSRecyclerView.c cVar = this.f22085c;
        return cVar != null ? cVar.areAllItemsEnabled() : super.areAllItemsEnabled();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return s() + q() + t();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i5) {
        int i6;
        if (x(i5)) {
            return this.f22083a.i(i5);
        }
        if (w(i5)) {
            return this.f22084b.i((i5 - s()) - t());
        }
        int iS = s();
        if (this.f22085c == null || i5 < iS || (i6 = i5 - iS) >= t()) {
            return -1L;
        }
        return this.f22085c.getItemId(i6);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i5) {
        if (x(i5)) {
            return this.f22083a.i(i5);
        }
        if (w(i5)) {
            return this.f22084b.i((i5 - s()) - t());
        }
        StepOSRecyclerView.c cVar = this.f22085c;
        if (cVar == null) {
            return -2;
        }
        cVar.setHeadCount(s());
        return this.f22085c.getItemViewType(i5 - s());
    }

    @Override // stepos.support.v7.widget.StepOSRecyclerView.c, stepos.support.v7.widget.StepOSRecyclerView.u
    public boolean isEnabled(int i5) {
        int iT;
        StepOSRecyclerView.d dVarL;
        int iS = s();
        if (i5 >= 0 && i5 < iS) {
            StepOSRecyclerView.d dVarL2 = this.f22083a.l(i5);
            if (dVarL2 != null) {
                return dVarL2.f21767b;
            }
            return false;
        }
        int i6 = i5 - iS;
        if (this.f22085c == null || i5 < iS) {
            iT = 0;
        } else {
            iT = t();
            if (i6 < iT) {
                return this.f22085c.isEnabled(i6);
            }
        }
        int i7 = i6 - iT;
        if (i7 < 0 || i7 >= q() || (dVarL = this.f22084b.l(i7)) == null) {
            return false;
        }
        return dVarL.f21767b;
    }

    @Override // stepos.support.v7.widget.StepOSRecyclerView.c, stepos.support.v7.widget.StepOSRecyclerView.u
    public boolean isSelectable(int i5) {
        int iS = s();
        if (i5 < iS) {
            return false;
        }
        int i6 = i5 - iS;
        if (this.f22085c == null || i5 < iS || i6 >= t()) {
            return false;
        }
        return this.f22085c.isSelectable(i6);
    }

    public void n(StepOSRecyclerView.d dVar) {
        q.j<StepOSRecyclerView.d> jVar = this.f22084b;
        int i5 = f22082f;
        f22082f = i5 + 1;
        jVar.j(i5, dVar);
    }

    @Override // stepos.support.v7.widget.StepOSRecyclerView.c, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        StepOSRecyclerView.c cVar = this.f22085c;
        if (cVar != null) {
            cVar.onAttachedToRecyclerView(recyclerView);
        }
        y(recyclerView);
    }

    @Override // stepos.support.v7.widget.StepOSRecyclerView.c, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i5) throws Resources.NotFoundException {
        StepOSRecyclerView.c cVar;
        if (x(i5) || w(i5) || (cVar = this.f22085c) == null) {
            return;
        }
        cVar.onBindViewHolder(viewHolder, i5 - s());
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [androidx.recyclerview.widget.RecyclerView$ViewHolder] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i5) {
        if (this.f22083a.g(i5) != null) {
            return this.f22083a.g(i5).f21766a;
        }
        if (this.f22084b.g(i5) != null) {
            return this.f22084b.g(i5).f21766a;
        }
        StepOSRecyclerView.c cVar = this.f22085c;
        if (cVar != null) {
            return cVar.onCreateViewHolder(viewGroup, i5);
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        StepOSRecyclerView.c cVar = this.f22085c;
        if (cVar != null) {
            cVar.onDetachedFromRecyclerView(recyclerView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
        StepOSRecyclerView.c cVar = this.f22085c;
        return cVar != null ? cVar.onFailedToRecycleView(viewHolder) : super.onFailedToRecycleView(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        ViewGroup.LayoutParams layoutParams;
        StepOSRecyclerView.c cVar = this.f22085c;
        if (cVar != null) {
            cVar.onViewAttachedToWindow(viewHolder);
        }
        int layoutPosition = viewHolder.getLayoutPosition();
        if ((x(layoutPosition) || w(layoutPosition)) && (layoutParams = viewHolder.itemView.getLayoutParams()) != null && (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams)) {
            ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        StepOSRecyclerView.c cVar = this.f22085c;
        if (cVar != null) {
            cVar.onViewDetachedFromWindow(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        StepOSRecyclerView.c cVar = this.f22085c;
        if (cVar != null) {
            cVar.onViewRecycled(viewHolder);
        }
    }

    public void p(StepOSRecyclerView.d dVar) {
        q.j<StepOSRecyclerView.d> jVar = this.f22083a;
        int i5 = f22081e;
        f22081e = i5 + 1;
        jVar.j(i5, dVar);
    }

    public int q() {
        return this.f22084b.k();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        this.f22085c.registerAdapterDataObserver(adapterDataObserver);
        super.registerAdapterDataObserver(this.f22086d);
    }

    public int s() {
        return this.f22083a.k();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        this.f22085c.unregisterAdapterDataObserver(adapterDataObserver);
        super.unregisterAdapterDataObserver(this.f22086d);
    }

    public RecyclerView.Adapter v() {
        return this.f22085c;
    }

    public void y(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.setSpanSizeLookup(new a(gridLayoutManager, gridLayoutManager.getSpanSizeLookup()));
            gridLayoutManager.setSpanCount(gridLayoutManager.getSpanCount());
        }
    }

    class b extends RecyclerView.AdapterDataObserver {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            if (o.this.f22085c != null) {
                o.this.f22085c.notifyDataSetChanged();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i5, int i6) {
            if (o.this.f22085c != null) {
                o.this.f22085c.notifyItemRangeChanged(i5, i6);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i5, int i6) {
            if (o.this.f22085c != null) {
                o.this.f22085c.notifyItemRangeInserted(i5, i6);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i5, int i6, int i7) {
            if (o.this.f22085c != null) {
                o.this.f22085c.notifyItemMoved(i5, i6);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i5, int i6) {
            if (o.this.f22085c != null) {
                o.this.f22085c.notifyItemRangeRemoved(i5, i6);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i5, int i6, Object obj) {
            if (o.this.f22085c != null) {
                o.this.f22085c.notifyItemRangeChanged(i5, i6, obj);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i5, List list) {
        StepOSRecyclerView.c cVar;
        if (x(i5) || w(i5) || (cVar = this.f22085c) == null) {
            return;
        }
        cVar.onBindViewHolder(viewHolder, i5 - s(), list);
    }
}
