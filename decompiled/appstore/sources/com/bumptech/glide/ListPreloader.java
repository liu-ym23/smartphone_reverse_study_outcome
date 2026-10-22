package com.bumptech.glide;

import android.widget.AbsListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.target.BaseTarget;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.util.List;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
public class ListPreloader<T> implements AbsListView.OnScrollListener {
    private boolean isIncreasing;
    private int lastEnd;
    private int lastFirstVisible;
    private int lastStart;
    private final int maxPreload;
    private final PreloadSizeProvider<T> preloadDimensionProvider;
    private final PreloadModelProvider<T> preloadModelProvider;
    private final PreloadTargetQueue preloadTargetQueue;
    private final RequestManager requestManager;
    private int totalItemCount;

    public interface PreloadModelProvider<U> {
        @NonNull
        List<U> getPreloadItems(int r10);

        @Nullable
        RequestBuilder<?> getPreloadRequestBuilder(@NonNull U r10);
    }

    public interface PreloadSizeProvider<T> {
        @Nullable
        int[] getPreloadSize(@NonNull T r10, int r11, int r12);
    }

    public static final class PreloadTarget extends BaseTarget<Object> {
        int photoHeight;
        int photoWidth;

        public PreloadTarget() {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void getSize(@NonNull SizeReadyCallback r10) {
            r10.onSizeReady(this.photoWidth, this.photoHeight);
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onResourceReady(@NonNull Object r10, @Nullable Transition<? super Object> r11) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void removeCallback(@NonNull SizeReadyCallback r10) {
        }
    }

    public static final class PreloadTargetQueue {
        private final Queue<PreloadTarget> queue;

        public PreloadTargetQueue(int r10) {
            this.queue = Util.createQueue(r10);
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L5;
            this.queue.offer(new PreloadTarget());
            r11 = r11 + 1;
            goto L3
        }

        public PreloadTarget next(int r10, int r11) {
            PreloadTarget r12 = this.queue.poll();
            this.queue.offer(r12);
            r12.photoWidth = r10;
            r12.photoHeight = r11;
            return r12;
        }
    }

    public ListPreloader(@NonNull RequestManager r10, @NonNull PreloadModelProvider<T> r11, @NonNull PreloadSizeProvider<T> r12, int r13) {
        this.lastFirstVisible = -1;
        this.isIncreasing = true;
        this.requestManager = r10;
        this.preloadModelProvider = r11;
        this.preloadDimensionProvider = r12;
        this.maxPreload = r13;
        this.preloadTargetQueue = new PreloadTargetQueue(r13 + 1);
    }

    private void cancelAll() {
        int r10 = 0;
    L4:
        if (r10 >= this.maxPreload) goto L6;
        this.requestManager.clear(this.preloadTargetQueue.next(0, 0));
        r10 = r10 + 1;
        goto L4
    }

    private void preload(int r10, boolean r11) {
        if (this.isIncreasing == r11) goto L5;
        this.isIncreasing = r11;
        cancelAll();
    L5:
        if (r11 == false) goto L7;
        int r12 = this.maxPreload;
    L8:
        preload(r10, r12 + r10);
        return;
    L7:
        r12 = -this.maxPreload;
        goto L8
    }

    private void preloadAdapterPosition(List<T> r10, int r11, boolean r12) {
        int r13 = r10.size();
        if (r12 == false) goto L7;
        int r14 = 0;
    L5:
        if (r14 >= r13) goto L10;
        preloadItem(r10.get(r14), r11, r14);
        r14 = r14 + 1;
        goto L5
    L10:
        return;
    L7:
        int r15 = r13 - 1;
    L8:
        if (r15 < 0) goto L13;
        preloadItem(r10.get(r15), r11, r15);
        r15 = r15 - 1;
        goto L8
    }

    private void preloadItem(@Nullable T r10, int r11, int r12) {
        if (r10 != null) goto L4;
        return;
    L4:
        int[] r13 = this.preloadDimensionProvider.getPreloadSize(r10, r11, r12);
        if (r13 != null) goto L7;
        return;
    L7:
        RequestBuilder<?> r14 = this.preloadModelProvider.getPreloadRequestBuilder(r10);
        if (r14 != null) goto L10;
        return;
    L10:
        r14.into(this.preloadTargetQueue.next(r13[0], r13[1]));
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView r10, int r11, int r12, int r13) {
        this.totalItemCount = r13;
        int r14 = this.lastFirstVisible;
        if (r11 <= r14) goto L5;
        preload(r12 + r11, true);
    L7:
        this.lastFirstVisible = r11;
        return;
    L5:
        if (r11 >= r14) goto L7;
        preload(r11, false);
        goto L7
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView r10, int r11) {
    }

    private void preload(int r10, int r11) {
        if (r10 >= r11) goto L4;
        int r12 = Math.max(this.lastEnd, r10);
        int r13 = r11;
    L5:
        int r14 = Math.min(this.totalItemCount, r13);
        int r15 = Math.min(this.totalItemCount, Math.max(0, r12));
        if (r10 >= r11) goto L10;
        int r16 = r15;
    L8:
        if (r16 >= r14) goto L13;
        preloadAdapterPosition(this.preloadModelProvider.getPreloadItems(r16), r16, true);
        r16 = r16 + 1;
    L13:
        this.lastStart = r15;
        this.lastEnd = r14;
        return;
    L10:
        int r17 = r14 - 1;
    L11:
        if (r17 < r15) goto L13;
        preloadAdapterPosition(this.preloadModelProvider.getPreloadItems(r17), r17, false);
        r17 = r17 - 1;
        goto L11
    L4:
        r13 = Math.min(this.lastStart, r10);
        r12 = r11;
        goto L5
    }
}
