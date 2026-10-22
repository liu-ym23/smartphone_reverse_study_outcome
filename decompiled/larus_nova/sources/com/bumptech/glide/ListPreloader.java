package com.bumptech.glide;

import android.graphics.drawable.Drawable;
import android.widget.AbsListView;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import java.util.Queue;

/* JADX INFO: loaded from: classes39.dex */
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
        List<U> getPreloadItems(int r100);

        RequestBuilder<?> getPreloadRequestBuilder(U r100);
    }

    public interface PreloadSizeProvider<T> {
        int[] getPreloadSize(T r100, int r101, int r102);
    }

    public static final class PreloadTarget implements Target<Object> {
        int photoHeight;
        int photoWidth;
        private Request request;

        public PreloadTarget() {
        }

        @Override // com.bumptech.glide.manager.LifecycleListener
        public void onDestroy() {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(Drawable r100) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadFailed(Drawable r100) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadStarted(Drawable r100) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onResourceReady(Object r100, Transition<? super Object> r101) {
        }

        @Override // com.bumptech.glide.manager.LifecycleListener
        public void onStart() {
        }

        @Override // com.bumptech.glide.manager.LifecycleListener
        public void onStop() {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void removeCallback(SizeReadyCallback r100) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public Request getRequest() {
            return this.request;
        }

        @Override // com.bumptech.glide.request.target.Target
        public void getSize(SizeReadyCallback r100) {
            r100.onSizeReady(this.photoWidth, this.photoHeight);
        }

        @Override // com.bumptech.glide.request.target.Target
        public void setRequest(Request r100) {
            this.request = r100;
        }
    }

    public static final class PreloadTargetQueue {
        final Queue<PreloadTarget> queue;

        public PreloadTargetQueue(int r100) {
            this.queue = Util.createQueue(r100);
            int r101 = 0;
        L3:
            if (r101 >= r100) goto L5;
            this.queue.offer(new PreloadTarget());
            r101 = r101 + 1;
            goto L3
        }

        public PreloadTarget next(int r100, int r101) {
            PreloadTarget r102 = this.queue.poll();
            this.queue.offer(r102);
            r102.photoWidth = r100;
            r102.photoHeight = r101;
            return r102;
        }
    }

    private void cancelAll() {
        int r100 = 0;
    L4:
        if (r100 >= this.preloadTargetQueue.queue.size()) goto L6;
        this.requestManager.clear(this.preloadTargetQueue.next(0, 0));
        r100 = r100 + 1;
        goto L4
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView r100, int r101) {
    }

    private void preload(int r100, int r101) {
        if (r100 >= r101) goto L4;
        int r102 = Math.max(this.lastEnd, r100);
        int r103 = r101;
    L5:
        int r104 = Math.min(this.totalItemCount, r103);
        int r105 = Math.min(this.totalItemCount, Math.max(0, r102));
        if (r100 >= r101) goto L10;
        int r106 = r105;
    L8:
        if (r106 >= r104) goto L13;
        preloadAdapterPosition(this.preloadModelProvider.getPreloadItems(r106), r106, true);
        r106 = r106 + 1;
    L13:
        this.lastStart = r105;
        this.lastEnd = r104;
        return;
    L10:
        int r107 = r104 - 1;
    L11:
        if (r107 < r105) goto L13;
        preloadAdapterPosition(this.preloadModelProvider.getPreloadItems(r107), r107, false);
        r107 = r107 - 1;
        goto L11
    L4:
        r103 = Math.min(this.lastStart, r100);
        r102 = r101;
        goto L5
    }

    private void preload(int r100, boolean r101) {
        if (this.isIncreasing == r101) goto L5;
        this.isIncreasing = r101;
        cancelAll();
    L5:
        if (r101 == false) goto L7;
        int r102 = this.maxPreload;
    L8:
        preload(r100, r102 + r100);
        return;
    L7:
        r102 = -this.maxPreload;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void preloadAdapterPosition(List<T> r100, int r101, boolean r102) {
        int r103 = r100.size();
        if (r102 == false) goto L7;
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L10;
        preloadItem(ListProtector.get(r100, r104), r101, r104);
        r104 = r104 + 1;
        goto L5
    L10:
        return;
    L7:
        int r105 = r103 - 1;
    L8:
        if (r105 < 0) goto L13;
        preloadItem(ListProtector.get(r100, r105), r101, r105);
        r105 = r105 - 1;
        goto L8
    }

    private void preloadItem(T r100, int r101, int r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        int[] r103 = this.preloadDimensionProvider.getPreloadSize(r100, r101, r102);
        if (r103 != null) goto L7;
        return;
    L7:
        RequestBuilder<?> r104 = this.preloadModelProvider.getPreloadRequestBuilder(r100);
        if (r104 != null) goto L10;
        return;
    L10:
        r104.into(this.preloadTargetQueue.next(r103[0], r103[1]));
    }

    public ListPreloader(RequestManager r100, PreloadModelProvider<T> r101, PreloadSizeProvider<T> r102, int r103) {
        this.lastFirstVisible = -1;
        this.isIncreasing = true;
        this.requestManager = r100;
        this.preloadModelProvider = r101;
        this.preloadDimensionProvider = r102;
        this.maxPreload = r103;
        this.preloadTargetQueue = new PreloadTargetQueue(r103 + 1);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView r100, int r101, int r102, int r103) {
        this.totalItemCount = r103;
        int r104 = this.lastFirstVisible;
        if (r101 <= r104) goto L5;
        preload(r102 + r101, true);
    L7:
        this.lastFirstVisible = r101;
        return;
    L5:
        if (r101 >= r104) goto L7;
        preload(r101, false);
        goto L7
    }
}
