package androidx.paging;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.recyclerview.widget.AdapterListUpdateCallback;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes17.dex */
public class AsyncPagedListDiffer<T> {
    final AsyncDifferConfig<T> mConfig;
    private boolean mIsContiguous;
    private final List<PagedListListener<T>> mListeners;
    Executor mMainThreadExecutor;
    int mMaxScheduledGeneration;
    private PagedList<T> mPagedList;
    private PagedList.Callback mPagedListCallback;
    private PagedList<T> mSnapshot;
    final ListUpdateCallback mUpdateCallback;

    public interface PagedListListener<T> {
        void onCurrentListChanged(PagedList<T> r100, PagedList<T> r101);
    }

    public PagedList<T> getCurrentList() {
        PagedList<T> r100 = this.mSnapshot;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return this.mPagedList;
    }

    public int getItemCount() {
        PagedList<T> r100 = this.mPagedList;
        if (r100 != null) goto L5;
        PagedList<T> r101 = this.mSnapshot;
        if (r101 != null) goto L10;
        return 0;
    L10:
        return r101.size();
    L5:
        return r100.size();
    }

    public void addPagedListListener(PagedListListener<T> r100) {
        this.mListeners.add(r100);
    }

    public T getItem(int r100) {
        PagedList<T> r101 = this.mPagedList;
        if (r101 != null) goto L10;
        PagedList<T> r102 = this.mSnapshot;
        if (r102 == null) goto L9;
        return r102.get(r100);
    L9:
        throw new IndexOutOfBoundsException("Item count is zero, getItem() call is invalid");
    L10:
        r101.loadAround(r100);
        return this.mPagedList.get(r100);
    }

    public void removePagedListListener(PagedListListener<T> r100) {
        this.mListeners.remove(r100);
    }

    public void submitList(PagedList<T> r100) {
        submitList(r100, null);
    }

    public AsyncPagedListDiffer(RecyclerView.Adapter r100, DiffUtil.ItemCallback<T> r101) {
        this.mMainThreadExecutor = ArchTaskExecutor.getMainThreadExecutor();
        this.mListeners = new CopyOnWriteArrayList();
        this.mPagedListCallback = new AnonymousClass1(this);
        this.mUpdateCallback = new AdapterListUpdateCallback(r100);
        this.mConfig = new AsyncDifferConfig.Builder(r101).build();
    }

    public void submitList(final PagedList<T> r110, final Runnable r111) {
        if (r110 != null) goto L4;
    L13:
        final int r100 = this.mMaxScheduledGeneration + 1;
        this.mMaxScheduledGeneration = r100;
        PagedList<T> r101 = this.mPagedList;
        if (r110 != r101) goto L18;
        if (r111 == null) goto L46;
        r111.run();
        return;
    L46:
        return;
    L18:
        PagedList<T> r102 = this.mSnapshot;
        if (r102 == null) goto L21;
        PagedList<T> r103 = r102;
    L23:
        if (r110 != null) goto L32;
        int r112 = getItemCount();
        PagedList<T> r104 = this.mPagedList;
        if (r104 == null) goto L28;
        r104.removeWeakCallback(this.mPagedListCallback);
        this.mPagedList = null;
    L30:
        this.mUpdateCallback.onRemoved(0, r112);
        onCurrentListChanged(r103, null, r111);
        return;
    L28:
        if (this.mSnapshot == null) goto L30;
        this.mSnapshot = null;
        goto L30
    L32:
        if (r101 != null) goto L36;
        if (r102 != null) goto L36;
        this.mPagedList = r110;
        r110.addWeakCallback(null, this.mPagedListCallback);
        this.mUpdateCallback.onInserted(0, r110.size());
        onCurrentListChanged(null, r110, r111);
        return;
    L36:
        if (r101 == null) goto L38;
        r101.removeWeakCallback(this.mPagedListCallback);
        this.mSnapshot = (PagedList) this.mPagedList.snapshot();
        this.mPagedList = null;
    L38:
        final PagedList<T> r105 = this.mSnapshot;
        if (r105 == null) goto L45;
        if (this.mPagedList != null) goto L45;
        final PagedList r106 = (PagedList) r110.snapshot();
        this.mConfig.getBackgroundThreadExecutor().execute(new AnonymousClass2(this, r105, r106, r100, r110, r111));
        return;
    L45:
        throw new IllegalStateException("must be in snapshot state to diff");
    L21:
        r103 = r101;
        goto L23
    L4:
        if (this.mPagedList != null) goto L9;
        if (this.mSnapshot != null) goto L9;
        this.mIsContiguous = r110.isContiguous();
    L9:
        if (r110.isContiguous() == this.mIsContiguous) goto L13;
        throw new IllegalArgumentException("AsyncPagedListDiffer cannot handle both contiguous and non-contiguous lists.");
    }

    public AsyncPagedListDiffer(ListUpdateCallback r100, AsyncDifferConfig<T> r101) {
        this.mMainThreadExecutor = ArchTaskExecutor.getMainThreadExecutor();
        this.mListeners = new CopyOnWriteArrayList();
        this.mPagedListCallback = new AnonymousClass1(this);
        this.mUpdateCallback = r100;
        this.mConfig = r101;
    }

    private void onCurrentListChanged(PagedList<T> r100, PagedList<T> r101, Runnable r102) {
        Iterator<PagedListListener<T>> r103 = this.mListeners.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r103.next().onCurrentListChanged(r100, r101);
        goto L4
    L6:
        if (r102 == null) goto L10;
        r102.run();
        return;
    }

    public void latchPagedList(PagedList<T> r100, PagedList<T> r101, DiffUtil.DiffResult r102, int r103, Runnable r104) {
        PagedList<T> r105 = this.mSnapshot;
        if (r105 == null) goto L12;
        if (this.mPagedList != null) goto L12;
        this.mPagedList = r100;
        this.mSnapshot = null;
        PagedStorageDiffHelper.dispatchDiff(this.mUpdateCallback, r105.mStorage, r100.mStorage, r102);
        r100.addWeakCallback(r101, this.mPagedListCallback);
        if (this.mPagedList.isEmpty() == true) goto L9;
        int r106 = PagedStorageDiffHelper.transformAnchorIndex(r102, r105.mStorage, r101.mStorage, r103);
        PagedList<T> r107 = this.mPagedList;
        r107.loadAround(Math.max(0, Math.min(r107.size() - 1, r106)));
    L9:
        onCurrentListChanged(r105, this.mPagedList, r104);
        return;
    L12:
        throw new IllegalStateException("must be in snapshot state to apply diff");
    }
}
