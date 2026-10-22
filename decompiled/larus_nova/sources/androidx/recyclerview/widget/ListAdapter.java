package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: classes17.dex */
public abstract class ListAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    final AsyncListDiffer<T> mDiffer;
    private final AsyncListDiffer.ListListener<T> mListener;

    public void onCurrentListChanged(List<T> r100, List<T> r101) {
    }

    public List<T> getCurrentList() {
        return this.mDiffer.getCurrentList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mDiffer.getCurrentList().size();
    }

    public ListAdapter(DiffUtil.ItemCallback<T> r100) {
        AsyncListDiffer.ListListener<T> r101 = new AnonymousClass1(this);
        this.mListener = r101;
        AsyncListDiffer<T> r102 = new AsyncListDiffer(new AdapterListUpdateCallback(this), new AsyncDifferConfig.Builder(r100).build());
        this.mDiffer = r102;
        r102.addListListener(r101);
    }

    public T getItem(int r100) {
        return (T) ListProtector.get(this.mDiffer.getCurrentList(), r100);
    }

    public void submitList(List<T> r100) {
        this.mDiffer.submitList(r100);
    }

    public ListAdapter(AsyncDifferConfig<T> r100) {
        AsyncListDiffer.ListListener<T> r101 = new AnonymousClass1(this);
        this.mListener = r101;
        AsyncListDiffer<T> r102 = new AsyncListDiffer(new AdapterListUpdateCallback(this), r100);
        this.mDiffer = r102;
        r102.addListListener(r101);
    }

    public void submitList(List<T> r100, Runnable r101) {
        this.mDiffer.submitList(r100, r101);
    }
}
