package androidx.paging;

import androidx.recyclerview.widget.AdapterListUpdateCallback;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

/* JADX INFO: loaded from: classes17.dex */
public abstract class PagedListAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    final AsyncPagedListDiffer<T> mDiffer;
    private final AsyncPagedListDiffer.PagedListListener<T> mListener;

    public void onCurrentListChanged(PagedList<T> r100) {
    }

    public void onCurrentListChanged(PagedList<T> r100, PagedList<T> r101) {
    }

    public PagedList<T> getCurrentList() {
        return this.mDiffer.getCurrentList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mDiffer.getItemCount();
    }

    public PagedListAdapter(AsyncDifferConfig<T> r100) {
        AsyncPagedListDiffer.PagedListListener<T> r101 = new AnonymousClass1(this);
        this.mListener = r101;
        AsyncPagedListDiffer<T> r102 = new AsyncPagedListDiffer(new AdapterListUpdateCallback(this), r100);
        this.mDiffer = r102;
        r102.addPagedListListener(r101);
    }

    public T getItem(int r100) {
        return this.mDiffer.getItem(r100);
    }

    public void submitList(PagedList<T> r100) {
        this.mDiffer.submitList(r100);
    }

    public PagedListAdapter(DiffUtil.ItemCallback<T> r100) {
        AsyncPagedListDiffer.PagedListListener<T> r101 = new AnonymousClass1(this);
        this.mListener = r101;
        AsyncPagedListDiffer<T> r102 = new AsyncPagedListDiffer(this, r100);
        this.mDiffer = r102;
        r102.addPagedListListener(r101);
    }

    public void submitList(PagedList<T> r100, Runnable r101) {
        this.mDiffer.submitList(r100, r101);
    }
}
