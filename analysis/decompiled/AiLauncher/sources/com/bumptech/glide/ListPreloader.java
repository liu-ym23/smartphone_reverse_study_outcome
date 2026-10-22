package com.bumptech.glide;

import android.graphics.drawable.Drawable;
import android.widget.AbsListView;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.util.List;
import java.util.Queue;

/* loaded from: classes.dex */
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
        List<U> getPreloadItems(int i10);

        RequestBuilder<?> getPreloadRequestBuilder(U u10);
    }

    public interface PreloadSizeProvider<T> {
        int[] getPreloadSize(T t10, int i10, int i11);
    }

    public static final class PreloadTarget implements Target<Object> {
        int photoHeight;
        int photoWidth;
        private Request request;

        @Override // com.bumptech.glide.request.target.Target
        public Request getRequest() {
            return this.request;
        }

        @Override // com.bumptech.glide.request.target.Target
        public void getSize(SizeReadyCallback sizeReadyCallback) {
            sizeReadyCallback.onSizeReady(this.photoWidth, this.photoHeight);
        }

        @Override // com.bumptech.glide.manager.LifecycleListener
        public void onDestroy() {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadFailed(Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadStarted(Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onResourceReady(Object obj, Transition<? super Object> transition) {
        }

        @Override // com.bumptech.glide.manager.LifecycleListener
        public void onStart() {
        }

        @Override // com.bumptech.glide.manager.LifecycleListener
        public void onStop() {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void removeCallback(SizeReadyCallback sizeReadyCallback) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void setRequest(Request request) {
            this.request = request;
        }
    }

    public static final class PreloadTargetQueue {
        final Queue<PreloadTarget> queue;

        public PreloadTargetQueue(int i10) {
            this.queue = Util.createQueue(i10);
            for (int i11 = 0; i11 < i10; i11++) {
                this.queue.offer(new PreloadTarget());
            }
        }

        public PreloadTarget next(int i10, int i11) {
            PreloadTarget preloadTargetPoll = this.queue.poll();
            this.queue.offer(preloadTargetPoll);
            preloadTargetPoll.photoWidth = i10;
            preloadTargetPoll.photoHeight = i11;
            return preloadTargetPoll;
        }
    }

    public ListPreloader(RequestManager requestManager, PreloadModelProvider<T> preloadModelProvider, PreloadSizeProvider<T> preloadSizeProvider, int i10) {
        this.requestManager = requestManager;
        this.preloadModelProvider = preloadModelProvider;
        this.preloadDimensionProvider = preloadSizeProvider;
        this.maxPreload = i10;
        this.preloadTargetQueue = new PreloadTargetQueue(i10 + 1);
    }

    private void cancelAll() {
        for (int i10 = 0; i10 < this.preloadTargetQueue.queue.size(); i10++) {
            this.requestManager.clear(this.preloadTargetQueue.next(0, 0));
        }
    }

    private void preload(int i10, boolean z10) {
        if (this.isIncreasing != z10) {
            this.isIncreasing = z10;
            cancelAll();
        }
        preload(i10, (z10 ? this.maxPreload : -this.maxPreload) + i10);
    }

    private void preloadAdapterPosition(List<T> list, int i10, boolean z10) {
        int size = list.size();
        if (z10) {
            for (int i11 = 0; i11 < size; i11++) {
                preloadItem(list.get(i11), i10, i11);
            }
            return;
        }
        for (int i12 = size - 1; i12 >= 0; i12--) {
            preloadItem(list.get(i12), i10, i12);
        }
    }

    private void preloadItem(T t10, int i10, int i11) {
        int[] preloadSize;
        RequestBuilder<?> preloadRequestBuilder;
        if (t10 == null || (preloadSize = this.preloadDimensionProvider.getPreloadSize(t10, i10, i11)) == null || (preloadRequestBuilder = this.preloadModelProvider.getPreloadRequestBuilder(t10)) == null) {
            return;
        }
        preloadRequestBuilder.into((RequestBuilder<?>) this.preloadTargetQueue.next(preloadSize[0], preloadSize[1]));
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
        if (this.totalItemCount == 0 && i12 == 0) {
            return;
        }
        this.totalItemCount = i12;
        int i13 = this.lastFirstVisible;
        if (i10 > i13) {
            preload(i11 + i10, true);
        } else if (i10 < i13) {
            preload(i10, false);
        }
        this.lastFirstVisible = i10;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i10) {
    }

    private void preload(int i10, int i11) {
        int iMin;
        int iMax;
        if (i10 < i11) {
            iMax = Math.max(this.lastEnd, i10);
            iMin = i11;
        } else {
            iMin = Math.min(this.lastStart, i10);
            iMax = i11;
        }
        int iMin2 = Math.min(this.totalItemCount, iMin);
        int iMin3 = Math.min(this.totalItemCount, Math.max(0, iMax));
        if (i10 < i11) {
            for (int i12 = iMin3; i12 < iMin2; i12++) {
                preloadAdapterPosition(this.preloadModelProvider.getPreloadItems(i12), i12, true);
            }
        } else {
            for (int i13 = iMin2 - 1; i13 >= iMin3; i13--) {
                preloadAdapterPosition(this.preloadModelProvider.getPreloadItems(i13), i13, false);
            }
        }
        this.lastStart = iMin3;
        this.lastEnd = iMin2;
    }
}
