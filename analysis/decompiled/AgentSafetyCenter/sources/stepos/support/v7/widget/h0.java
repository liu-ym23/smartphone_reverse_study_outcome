package stepos.support.v7.widget;

import android.util.Log;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class h0 extends x0 {

    /* renamed from: e, reason: collision with root package name */
    public static int f12757e = 100000;

    /* renamed from: f, reason: collision with root package name */
    public static int f12758f = 200000;

    /* renamed from: c, reason: collision with root package name */
    public final x0 f12761c;

    /* renamed from: a, reason: collision with root package name */
    public final p.q0 f12759a = new p.q0(0);

    /* renamed from: b, reason: collision with root package name */
    public final p.q0 f12760b = new p.q0(0);

    /* renamed from: d, reason: collision with root package name */
    public final g0 f12762d = new g0(this);

    public h0(RecyclerView.Adapter adapter) {
        x0 x0Var = (x0) adapter;
        this.f12761c = x0Var;
        setHasStableIds(x0Var.hasStableIds());
    }

    public final int a() {
        x0 x0Var = this.f12761c;
        if (x0Var != null) {
            return x0Var.getItemCount();
        }
        return 0;
    }

    @Override // stepos.support.v7.widget.x0
    public final boolean areAllItemsEnabled() {
        x0 x0Var = this.f12761c;
        return x0Var != null ? x0Var.areAllItemsEnabled() : super.areAllItemsEnabled();
    }

    public final boolean b(int i) {
        int itemCount = getItemCount();
        p.q0 q0Var = this.f12759a;
        if (i < itemCount) {
            return i >= a() + q0Var.f9616g;
        }
        StringBuilder sbT = k0.a.t(i, "HeaderAndFooterWrapperAdapter isFooterViewPos : current index is ", ", but total itemcount is ");
        sbT.append(getItemCount());
        sbT.append(", headers:");
        sbT.append(q0Var.f9616g);
        sbT.append(", items:");
        sbT.append(a());
        sbT.append(", footers:");
        sbT.append(this.f12760b.f9616g);
        Log.e("HeaderFooterAdapter", sbT.toString());
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return a() + this.f12759a.f9616g + this.f12760b.f9616g;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int i) {
        int i3;
        int i10;
        p.q0 q0Var = this.f12759a;
        if (i < q0Var.f9616g) {
            i10 = q0Var.f9614c[i];
        } else {
            if (!b(i)) {
                int i11 = q0Var.f9616g;
                x0 x0Var = this.f12761c;
                if (x0Var == null || i < i11 || (i3 = i - i11) >= a()) {
                    return -1L;
                }
                return x0Var.getItemId(i3);
            }
            i10 = this.f12760b.f9614c[(i - q0Var.f9616g) - a()];
        }
        return i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i) {
        p.q0 q0Var = this.f12759a;
        if (i < q0Var.f9616g) {
            return q0Var.f9614c[i];
        }
        if (b(i)) {
            return this.f12760b.f9614c[(i - q0Var.f9616g) - a()];
        }
        x0 x0Var = this.f12761c;
        if (x0Var == null) {
            return -2;
        }
        x0Var.setHeadCount(q0Var.f9616g);
        return x0Var.getItemViewType(i - q0Var.f9616g);
    }

    @Override // stepos.support.v7.widget.m1
    public final boolean isEnabled(int i) {
        int iA;
        p.q0 q0Var = this.f12759a;
        int i3 = q0Var.f9616g;
        if (i < 0 || i >= i3) {
            int i10 = i - i3;
            x0 x0Var = this.f12761c;
            if (x0Var == null || i < i3) {
                iA = 0;
            } else {
                iA = a();
                if (i10 < iA) {
                    return x0Var.isEnabled(i10);
                }
            }
            int i11 = i10 - iA;
            if (i11 >= 0) {
                p.q0 q0Var2 = this.f12760b;
                if (i11 < q0Var2.f9616g && q0Var2.d(i11) != null) {
                    od.f.j();
                    return false;
                }
            }
        } else if (q0Var.d(i) != null) {
            od.f.j();
            return false;
        }
        return false;
    }

    @Override // stepos.support.v7.widget.x0, stepos.support.v7.widget.m1
    public final boolean isSelectable(int i) {
        int i3 = this.f12759a.f9616g;
        if (i < i3) {
            return false;
        }
        int i10 = i - i3;
        x0 x0Var = this.f12761c;
        if (x0Var == null || i < i3 || i10 >= a()) {
            return false;
        }
        return x0Var.isSelectable(i10);
    }

    @Override // stepos.support.v7.widget.x0, androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onAttachedToRecyclerView(RecyclerView recyclerView) {
        x0 x0Var = this.f12761c;
        if (x0Var != null) {
            x0Var.onAttachedToRecyclerView(recyclerView);
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.setSpanSizeLookup(new f0(this, gridLayoutManager, gridLayoutManager.getSpanSizeLookup()));
            gridLayoutManager.setSpanCount(gridLayoutManager.getSpanCount());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        x0 x0Var;
        p.q0 q0Var = this.f12759a;
        if (i < q0Var.f9616g || b(i) || (x0Var = this.f12761c) == null) {
            return;
        }
        x0Var.onBindViewHolder(viewHolder, i - q0Var.f9616g);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        p.q0 q0Var = this.f12759a;
        if (q0Var.b(i) != null) {
            q0Var.b(i).getClass();
            od.f.j();
            return null;
        }
        p.q0 q0Var2 = this.f12760b;
        if (q0Var2.b(i) != null) {
            q0Var2.b(i).getClass();
            od.f.j();
            return null;
        }
        x0 x0Var = this.f12761c;
        if (x0Var != null) {
            return x0Var.onCreateViewHolder(viewGroup, i);
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        x0 x0Var = this.f12761c;
        if (x0Var != null) {
            x0Var.onDetachedFromRecyclerView(recyclerView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
        x0 x0Var = this.f12761c;
        return x0Var != null ? x0Var.onFailedToRecycleView(viewHolder) : super.onFailedToRecycleView(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        ViewGroup.LayoutParams layoutParams;
        x0 x0Var = this.f12761c;
        if (x0Var != null) {
            x0Var.onViewAttachedToWindow(viewHolder);
        }
        int layoutPosition = viewHolder.getLayoutPosition();
        if ((layoutPosition >= this.f12759a.f9616g && !b(layoutPosition)) || (layoutParams = viewHolder.itemView.getLayoutParams()) == null || !(layoutParams instanceof StaggeredGridLayoutManager.LayoutParams)) {
            return;
        }
        ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        x0 x0Var = this.f12761c;
        if (x0Var != null) {
            x0Var.onViewDetachedFromWindow(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        x0 x0Var = this.f12761c;
        if (x0Var != null) {
            x0Var.onViewRecycled(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void registerAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        this.f12761c.registerAdapterDataObserver(adapterDataObserver);
        super.registerAdapterDataObserver(this.f12762d);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
        this.f12761c.unregisterAdapterDataObserver(adapterDataObserver);
        super.unregisterAdapterDataObserver(this.f12762d);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list) {
        x0 x0Var;
        p.q0 q0Var = this.f12759a;
        if (i < q0Var.f9616g || b(i) || (x0Var = this.f12761c) == null) {
            return;
        }
        x0Var.onBindViewHolder(viewHolder, i - q0Var.f9616g, list);
    }
}
