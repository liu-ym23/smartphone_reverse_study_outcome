package com.bumptech.glide;

import android.graphics.drawable.Drawable;
import android.widget.AbsListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.util.List;
import java.util.Queue;

/* loaded from: classes2.dex */
public class ListPreloader<T> implements AbsListView.OnScrollListener {
    private int lastEnd;
    private int lastStart;
    private final int maxPreload;
    private final PreloadSizeProvider<T> preloadDimensionProvider;
    private final PreloadModelProvider<T> preloadModelProvider;
    private final PreloadTargetQueue preloadTargetQueue;
    private final RequestManager requestManager;
    private int totalItemCount;
    private int lastFirstVisible = -1;
    private boolean isIncreasing = true;

    public interface PreloadModelProvider<U> {
        @NonNull
        List<U> getPreloadItems(int i);

        @Nullable
        RequestBuilder<?> getPreloadRequestBuilder(@NonNull U u);
    }

    public interface PreloadSizeProvider<T> {
        @Nullable
        int[] getPreloadSize(@NonNull T t9, int i, int i6);
    }

    public static final class PreloadTarget implements Target<Object> {
        int photoHeight;
        int photoWidth;

        @Nullable
        private Request request;

        @Override // com.bumptech.glide.request.target.Target
        @Nullable
        public Request getRequest() {
            return this.request;
        }

        @Override // com.bumptech.glide.request.target.Target
        public void getSize(@NonNull SizeReadyCallback sizeReadyCallback) {
            sizeReadyCallback.onSizeReady(this.photoWidth, this.photoHeight);
        }

        @Override // com.bumptech.glide.manager.LifecycleListener
        public void onDestroy() {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(@Nullable Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadFailed(@Nullable Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadStarted(@Nullable Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onResourceReady(@NonNull Object obj, @Nullable Transition<? super Object> transition) {
        }

        @Override // com.bumptech.glide.manager.LifecycleListener
        public void onStart() {
        }

        @Override // com.bumptech.glide.manager.LifecycleListener
        public void onStop() {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void removeCallback(@NonNull SizeReadyCallback sizeReadyCallback) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void setRequest(@Nullable Request request) {
            this.request = request;
        }
    }

    public static final class PreloadTargetQueue {
        final Queue<PreloadTarget> queue;

        public PreloadTargetQueue(int i) {
            this.queue = Util.createQueue(i);
            for (int i6 = 0; i6 < i; i6++) {
                this.queue.offer(new PreloadTarget());
            }
        }

        public PreloadTarget next(int i, int i6) {
            PreloadTarget preloadTargetPoll = this.queue.poll();
            this.queue.offer(preloadTargetPoll);
            preloadTargetPoll.photoWidth = i;
            preloadTargetPoll.photoHeight = i6;
            return preloadTargetPoll;
        }
    }

    public ListPreloader(@NonNull RequestManager requestManager, @NonNull PreloadModelProvider<T> preloadModelProvider, @NonNull PreloadSizeProvider<T> preloadSizeProvider, int i) {
        this.requestManager = requestManager;
        this.preloadModelProvider = preloadModelProvider;
        this.preloadDimensionProvider = preloadSizeProvider;
        this.maxPreload = i;
        this.preloadTargetQueue = new PreloadTargetQueue(i + 1);
    }

    private void cancelAll() {
        for (int i = 0; i < this.preloadTargetQueue.queue.size(); i++) {
            this.requestManager.clear(this.preloadTargetQueue.next(0, 0));
        }
    }

    private void preload(int i, boolean z10) {
        if (this.isIncreasing != z10) {
            this.isIncreasing = z10;
            cancelAll();
        }
        preload(i, (z10 ? this.maxPreload : -this.maxPreload) + i);
    }

    private void preloadAdapterPosition(List<T> list, int i, boolean z10) {
        int size = list.size();
        if (z10) {
            for (int i6 = 0; i6 < size; i6++) {
                preloadItem(list.get(i6), i, i6);
            }
            return;
        }
        for (int i10 = size - 1; i10 >= 0; i10--) {
            preloadItem(list.get(i10), i, i10);
        }
    }

    private void preloadItem(@Nullable T t9, int i, int i6) {
        int[] preloadSize;
        RequestBuilder<?> preloadRequestBuilder;
        if (t9 == null || (preloadSize = this.preloadDimensionProvider.getPreloadSize(t9, i, i6)) == null || (preloadRequestBuilder = this.preloadModelProvider.getPreloadRequestBuilder(t9)) == null) {
            return;
        }
        preloadRequestBuilder.into((RequestBuilder<?>) this.preloadTargetQueue.next(preloadSize[0], preloadSize[1]));
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i6, int i10) {
        if (this.totalItemCount == 0 && i10 == 0) {
            return;
        }
        this.totalItemCount = i10;
        int i11 = this.lastFirstVisible;
        if (i > i11) {
            preload(i6 + i, true);
        } else if (i < i11) {
            preload(i, false);
        }
        this.lastFirstVisible = i;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    private void preload(int i, int i6) {
        int iMin;
        int iMax;
        if (i < i6) {
            iMax = Math.max(this.lastEnd, i);
            iMin = i6;
        } else {
            iMin = Math.min(this.lastStart, i);
            iMax = i6;
        }
        int iMin2 = Math.min(this.totalItemCount, iMin);
        int iMin3 = Math.min(this.totalItemCount, Math.max(0, iMax));
        if (i < i6) {
            for (int i10 = iMin3; i10 < iMin2; i10++) {
                preloadAdapterPosition(this.preloadModelProvider.getPreloadItems(i10), i10, true);
            }
        } else {
            for (int i11 = iMin2 - 1; i11 >= iMin3; i11--) {
                preloadAdapterPosition(this.preloadModelProvider.getPreloadItems(i11), i11, false);
            }
        }
        this.lastStart = iMin3;
        this.lastEnd = iMin2;
    }
}
