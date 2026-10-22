package ay7;

import androidx.recyclerview.widget.RecyclerView;
import com.ixigua.lib.list.ListAgency;
import com.ixigua.lib.list.simple.ListViewHolder;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public abstract class a<T, V extends ListViewHolder<T>> implements com.ixigua.lib.list.a<T, V>, wx7.b {
    public a() {
    }

    @Override // wx7.b
    public final boolean R1(ListViewHolder<?> r100, wx7.a r101) {
        return false;
    }

    public void i(V r100, T r101) {
    }

    public String toString() {
        ListAgency.f278497d.getClass();
        return super.toString();
    }

    @Override // com.ixigua.lib.list.a
    public final void b(RecyclerView.ViewHolder r100) {
        ((ListViewHolder) r100).W3();
    }

    @Override // com.ixigua.lib.list.a
    public final void c(RecyclerView.ViewHolder r100) {
        ((ListViewHolder) r100).X3();
    }

    @Override // com.ixigua.lib.list.a
    public final /* bridge */ /* synthetic */ boolean e(RecyclerView.ViewHolder r100) {
        ListViewHolder r101 = (ListViewHolder) r100;
        return false;
    }

    public void h(V r100) {
        r100.f278523a = null;
        r100.f278526d = null;
        r100.f278525c = null;
        r100.f278524b = null;
    }

    @Override // com.ixigua.lib.list.a
    public /* bridge */ /* synthetic */ void onViewRecycled(RecyclerView.ViewHolder r100) {
        h((ListViewHolder) r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ixigua.lib.list.a
    public final void d(RecyclerView.ViewHolder r100, Object r101) {
        ListViewHolder r102 = (ListViewHolder) r100;
        i(r102, r101);
        r102.T3(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ixigua.lib.list.a
    public final void f(RecyclerView.ViewHolder r100, Object r101, List r102) {
        ListViewHolder r103 = (ListViewHolder) r100;
        i(r103, r101);
        r103.U3(r101, r102);
    }
}
