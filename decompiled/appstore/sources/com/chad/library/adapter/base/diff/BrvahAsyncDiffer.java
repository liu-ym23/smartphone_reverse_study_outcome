package com.chad.library.adapter.base.diff;

import android.os.Handler;
import android.os.Looper;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.chad.library.adapter.base.BaseQuickAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001!B%\u0012\u0010\u0010\u0003\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0016J\u0006\u0010\u0015\u001a\u00020\u0013J(\u0010\u0016\u001a\u00020\u00132\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J \u0010\u001c\u001a\u00020\u00132\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\u0014\u0010\u001f\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\nJ$\u0010 \u001a\u00020\u00132\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007R\u0018\u0010\u0003\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/chad/library/adapter/base/diff/BrvahAsyncDiffer;", "T", "Lcom/chad/library/adapter/base/diff/DifferImp;", "adapter", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "config", "Lcom/chad/library/adapter/base/diff/BrvahAsyncDifferConfig;", "(Lcom/chad/library/adapter/base/BaseQuickAdapter;Lcom/chad/library/adapter/base/diff/BrvahAsyncDifferConfig;)V", "mListeners", "", "Lcom/chad/library/adapter/base/diff/ListChangeListener;", "mMainThreadExecutor", "Ljava/util/concurrent/Executor;", "mMaxScheduledGeneration", "", "mUpdateCallback", "Landroidx/recyclerview/widget/ListUpdateCallback;", "sMainThreadExecutor", "addListListener", "", "listener", "clearAllListListener", "latchList", "newList", "diffResult", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "commitCallback", "Ljava/lang/Runnable;", "onCurrentListChanged", "previousList", "", "removeListListener", "submitList", "MainThreadExecutor", "com.github.CymChad.brvah"}, k = 1, mv = {1, 1, 16})
public final class BrvahAsyncDiffer<T> implements DifferImp<T> {
    private final BaseQuickAdapter<T, ?> adapter;
    private final BrvahAsyncDifferConfig<T> config;
    private final List<ListChangeListener<T>> mListeners;
    private Executor mMainThreadExecutor;
    private int mMaxScheduledGeneration;
    private final ListUpdateCallback mUpdateCallback;
    private final Executor sMainThreadExecutor;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/chad/library/adapter/base/diff/BrvahAsyncDiffer$MainThreadExecutor;", "Ljava/util/concurrent/Executor;", "()V", "mHandler", "Landroid/os/Handler;", "getMHandler", "()Landroid/os/Handler;", "execute", "", "command", "Ljava/lang/Runnable;", "com.github.CymChad.brvah"}, k = 1, mv = {1, 1, 16})
    public static final class MainThreadExecutor implements Executor {

        @NotNull
        private final Handler mHandler;

        public MainThreadExecutor() {
            this.mHandler = new Handler(Looper.getMainLooper());
        }

        @Override // java.util.concurrent.Executor
        public void execute(@NotNull Runnable r10) {
            q.h(r10, "command");
            this.mHandler.post(r10);
        }

        @NotNull
        public final Handler getMHandler() {
            return this.mHandler;
        }
    }

    /* JADX INFO: renamed from: com.chad.library.adapter.base.diff.BrvahAsyncDiffer$submitList$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "T", "run"}, k = 3, mv = {1, 1, 16})
    public static final class AnonymousClass1 implements Runnable {
        final /* synthetic */ Runnable $commitCallback;
        final /* synthetic */ List $newList;
        final /* synthetic */ List $oldList;
        final /* synthetic */ int $runGeneration;
        final /* synthetic */ BrvahAsyncDiffer this$0;

        public AnonymousClass1(BrvahAsyncDiffer r10, List r11, List r12, int r13, Runnable r14) {
            this.this$0 = r10;
            this.$oldList = r11;
            this.$newList = r12;
            this.$runGeneration = r13;
            this.$commitCallback = r14;
        }

        @Override // java.lang.Runnable
        public final void run() {
            final DiffUtil.DiffResult r10 = DiffUtil.b(new BrvahAsyncDiffer$submitList$1$result$1(this));
            q.c(r10, "DiffUtil.calculateDiff(o…         }\n            })");
            BrvahAsyncDiffer.access$getMMainThreadExecutor$p(this.this$0).execute(new RunnableC01381(this, r10));
        }
    }

    public BrvahAsyncDiffer(@NotNull BaseQuickAdapter<T, ?> r10, @NotNull BrvahAsyncDifferConfig<T> r11) {
        q.h(r10, "adapter");
        q.h(r11, "config");
        this.adapter = r10;
        this.config = r11;
        this.mUpdateCallback = new BrvahListUpdateCallback(r10);
        Executor r12 = new MainThreadExecutor();
        this.sMainThreadExecutor = r12;
        Executor r13 = r11.getMainThreadExecutor();
        if (r13 == null) goto L5;
        r12 = r13;
    L5:
        this.mMainThreadExecutor = r12;
        this.mListeners = new CopyOnWriteArrayList();
    }

    public static final /* synthetic */ BrvahAsyncDifferConfig access$getConfig$p(BrvahAsyncDiffer r10) {
        return r10.config;
    }

    public static final /* synthetic */ Executor access$getMMainThreadExecutor$p(BrvahAsyncDiffer r10) {
        return r10.mMainThreadExecutor;
    }

    public static final /* synthetic */ int access$getMMaxScheduledGeneration$p(BrvahAsyncDiffer r10) {
        return r10.mMaxScheduledGeneration;
    }

    public static final /* synthetic */ void access$latchList(BrvahAsyncDiffer r10, List r11, DiffUtil.DiffResult r12, Runnable r13) {
        r10.latchList(r11, r12, r13);
    }

    public static final /* synthetic */ void access$setMMainThreadExecutor$p(BrvahAsyncDiffer r10, Executor r11) {
        r10.mMainThreadExecutor = r11;
    }

    public static final /* synthetic */ void access$setMMaxScheduledGeneration$p(BrvahAsyncDiffer r10, int r11) {
        r10.mMaxScheduledGeneration = r11;
    }

    private final void latchList(List<T> r10, DiffUtil.DiffResult r11, Runnable r12) {
        List<? extends T> r13 = this.adapter.getData();
        this.adapter.setData$com_github_CymChad_brvah(r10);
        r11.b(this.mUpdateCallback);
        onCurrentListChanged(r13, r12);
    }

    private final void onCurrentListChanged(List<? extends T> r10, Runnable r11) {
        Iterator<ListChangeListener<T>> r12 = this.mListeners.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r12.next().onCurrentListChanged(r10, this.adapter.getData());
        goto L4
    L6:
        if (r11 == null) goto L10;
        r11.run();
        return;
    }

    public static /* synthetic */ void submitList$default(BrvahAsyncDiffer r10, List r11, Runnable r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = null;
    L5:
        r10.submitList(r11, r12);
    }

    @Override // com.chad.library.adapter.base.diff.DifferImp
    public void addListListener(@NotNull ListChangeListener<T> r10) {
        q.h(r10, "listener");
        this.mListeners.add(r10);
    }

    public final void clearAllListListener() {
        this.mListeners.clear();
    }

    public final void removeListListener(@NotNull ListChangeListener<T> r10) {
        q.h(r10, "listener");
        this.mListeners.remove(r10);
    }

    @JvmOverloads
    public final void submitList(@Nullable List<T> r10) {
        submitList$default(this, r10, null, 2, null);
    }

    @JvmOverloads
    public final void submitList(@Nullable List<T> r10, @Nullable Runnable r11) {
        int r12 = this.mMaxScheduledGeneration + 1;
        this.mMaxScheduledGeneration = r12;
        if (r10 != this.adapter.getData()) goto L7;
        if (r11 == null) goto L17;
        r11.run();
        return;
    L17:
        return;
    L7:
        List<? extends T> r13 = this.adapter.getData();
        if (r10 != null) goto L12;
        int r14 = this.adapter.getData().size();
        this.adapter.setData$com_github_CymChad_brvah(new ArrayList());
        this.mUpdateCallback.onRemoved(0, r14);
        onCurrentListChanged(r13, r11);
        return;
    L12:
        if (this.adapter.getData().isEmpty() == false) goto L15;
        this.adapter.setData$com_github_CymChad_brvah(r10);
        this.mUpdateCallback.onInserted(0, r10.size());
        onCurrentListChanged(r13, r11);
        return;
    L15:
        this.config.getBackgroundThreadExecutor().execute(new AnonymousClass1(this, r13, r10, r12, r11));
    }
}
