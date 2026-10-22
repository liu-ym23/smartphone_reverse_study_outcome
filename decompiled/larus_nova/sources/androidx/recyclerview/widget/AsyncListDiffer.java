package androidx.recyclerview.widget;

import android.os.Handler;
import android.os.Looper;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes17.dex */
public class AsyncListDiffer<T> {
    private static final Executor sMainThreadExecutor = null;
    final AsyncDifferConfig<T> mConfig;
    private List<T> mList;
    private final List<ListListener<T>> mListeners;
    Executor mMainThreadExecutor;
    int mMaxScheduledGeneration;
    private List<T> mReadOnlyList;
    private final ListUpdateCallback mUpdateCallback;

    public interface ListListener<T> {
        void onCurrentListChanged(List<T> r100, List<T> r101);
    }

    public static class MainThreadExecutor implements Executor {
        final Handler mHandler;

        public MainThreadExecutor() {
            this.mHandler = new Handler(Looper.getMainLooper());
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable r100) {
            this.mHandler.post(r100);
        }
    }

    static {
        sMainThreadExecutor = new MainThreadExecutor();
    }

    public List<T> getCurrentList() {
        return this.mReadOnlyList;
    }

    public void addListListener(ListListener<T> r100) {
        this.mListeners.add(r100);
    }

    public void removeListListener(ListListener<T> r100) {
        this.mListeners.remove(r100);
    }

    public void submitList(List<T> r100) {
        submitList(r100, null);
    }

    public AsyncListDiffer(ListUpdateCallback r100, AsyncDifferConfig<T> r101) {
        this.mListeners = new CopyOnWriteArrayList();
        this.mReadOnlyList = Collections.emptyList();
        this.mUpdateCallback = r100;
        this.mConfig = r101;
        if (r101.getMainThreadExecutor() == null) goto L5;
        this.mMainThreadExecutor = r101.getMainThreadExecutor();
        return;
    L5:
        this.mMainThreadExecutor = sMainThreadExecutor;
    }

    private void onCurrentListChanged(List<T> r100, Runnable r101) {
        Iterator<ListListener<T>> r102 = this.mListeners.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().onCurrentListChanged(r100, this.mReadOnlyList);
        goto L4
    L6:
        if (r101 == null) goto L10;
        r101.run();
        return;
    }

    public void submitList(final List<T> r100, final Runnable r110) {
        final int r101 = this.mMaxScheduledGeneration + 1;
        this.mMaxScheduledGeneration = r101;
        final List<T> r102 = this.mList;
        if (r100 != r102) goto L7;
        if (r110 == null) goto L16;
        r110.run();
        return;
    L16:
        return;
    L7:
        List<T> r103 = this.mReadOnlyList;
        if (r100 != null) goto L11;
        int r104 = r102.size();
        this.mList = null;
        this.mReadOnlyList = Collections.emptyList();
        this.mUpdateCallback.onRemoved(0, r104);
        onCurrentListChanged(r103, r110);
        return;
    L11:
        if (r102 != null) goto L14;
        this.mList = r100;
        this.mReadOnlyList = Collections.unmodifiableList(r100);
        this.mUpdateCallback.onInserted(0, r100.size());
        onCurrentListChanged(r103, r110);
        return;
    L14:
        this.mConfig.getBackgroundThreadExecutor().execute(new AnonymousClass1(this, r102, r100, r101, r110));
    }

    public AsyncListDiffer(RecyclerView.Adapter r100, DiffUtil.ItemCallback<T> r101) {
        this(new AdapterListUpdateCallback(r100), new AsyncDifferConfig.Builder(r101).build());
    }

    public void latchList(List<T> r100, DiffUtil.DiffResult r101, Runnable r102) {
        List<T> r103 = this.mReadOnlyList;
        this.mList = r100;
        this.mReadOnlyList = Collections.unmodifiableList(r100);
        r101.dispatchUpdatesTo(this.mUpdateCallback);
        onCurrentListChanged(r103, r102);
    }
}
