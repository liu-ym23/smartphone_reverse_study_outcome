package com.chad.library.adapter.base.diff;

import androidx.annotation.RestrictTo;
import androidx.recyclerview.widget.DiffUtil;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u000eB%\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/chad/library/adapter/base/diff/BrvahAsyncDifferConfig;", "T", "", "mainThreadExecutor", "Ljava/util/concurrent/Executor;", "backgroundThreadExecutor", "diffCallback", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "(Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;Landroidx/recyclerview/widget/DiffUtil$ItemCallback;)V", "getBackgroundThreadExecutor", "()Ljava/util/concurrent/Executor;", "getDiffCallback", "()Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "getMainThreadExecutor", "Builder", "com.github.CymChad.brvah"}, k = 1, mv = {1, 1, 16})
public final class BrvahAsyncDifferConfig<T> {

    @NotNull
    private final Executor backgroundThreadExecutor;

    @NotNull
    private final DiffUtil.ItemCallback diffCallback;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Nullable
    private final Executor mainThreadExecutor;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000e*\u0004\b\u0001\u0010\u00012\u00020\u0002:\u0001\u000eB\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0002\u0010\u0005J\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\nJ\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u0007J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u0007R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/chad/library/adapter/base/diff/BrvahAsyncDifferConfig$Builder;", "T", "", "mDiffCallback", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "(Landroidx/recyclerview/widget/DiffUtil$ItemCallback;)V", "mBackgroundThreadExecutor", "Ljava/util/concurrent/Executor;", "mMainThreadExecutor", "build", "Lcom/chad/library/adapter/base/diff/BrvahAsyncDifferConfig;", "setBackgroundThreadExecutor", "executor", "setMainThreadExecutor", "Companion", "com.github.CymChad.brvah"}, k = 1, mv = {1, 1, 16})
    public static final class Builder<T> {
        public static final Companion Companion = null;
        private static Executor sDiffExecutor;
        private static final Object sExecutorLock = null;
        private Executor mBackgroundThreadExecutor;
        private final DiffUtil.ItemCallback mDiffCallback;
        private Executor mMainThreadExecutor;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/chad/library/adapter/base/diff/BrvahAsyncDifferConfig$Builder$Companion;", "", "()V", "sDiffExecutor", "Ljava/util/concurrent/Executor;", "sExecutorLock", "com.github.CymChad.brvah"}, k = 1, mv = {1, 1, 16})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r10) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
            sExecutorLock = new Object();
        }

        public Builder(@NotNull DiffUtil.ItemCallback r10) {
            q.h(r10, "mDiffCallback");
            this.mDiffCallback = r10;
        }

        @NotNull
        public final BrvahAsyncDifferConfig<T> build() {
            if (this.mBackgroundThreadExecutor != null) goto L16;
            Object r10 = sExecutorLock;
            monitor-enter(r10);
        L9:
            th = move-exception;
            throw th;
        L7:
            if (sDiffExecutor != null) goto L11;
            sDiffExecutor = Executors.newFixedThreadPool(2);     // Catch: Throwable -> L9
        L11:
            Unit r11 = Unit.f21064a;     // Catch: Throwable -> L9
            monitor-exit(r10);
            this.mBackgroundThreadExecutor = sDiffExecutor;
        L16:
            Executor r12 = this.mMainThreadExecutor;
            Executor r13 = this.mBackgroundThreadExecutor;
            if (r13 != null) goto L20;
            q.s();
        L20:
            return new BrvahAsyncDifferConfig(r12, r13, this.mDiffCallback);
        }

        @NotNull
        public final Builder<T> setBackgroundThreadExecutor(@Nullable Executor r10) {
            this.mBackgroundThreadExecutor = r10;
            return this;
        }

        @NotNull
        public final Builder<T> setMainThreadExecutor(@Nullable Executor r10) {
            this.mMainThreadExecutor = r10;
            return this;
        }
    }

    public BrvahAsyncDifferConfig(@Nullable Executor r10, @NotNull Executor r11, @NotNull DiffUtil.ItemCallback r12) {
        q.h(r11, "backgroundThreadExecutor");
        q.h(r12, "diffCallback");
        this.mainThreadExecutor = r10;
        this.backgroundThreadExecutor = r11;
        this.diffCallback = r12;
    }

    @NotNull
    public final Executor getBackgroundThreadExecutor() {
        return this.backgroundThreadExecutor;
    }

    @NotNull
    public final DiffUtil.ItemCallback getDiffCallback() {
        return this.diffCallback;
    }

    @Nullable
    public final Executor getMainThreadExecutor() {
        return this.mainThreadExecutor;
    }
}
