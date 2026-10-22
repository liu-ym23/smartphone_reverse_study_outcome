package com.bumptech.glide.util;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.bumptech.glide.ListPreloader;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.transition.Transition;
import java.util.Arrays;

/* JADX INFO: loaded from: classes39.dex */
public class ViewPreloadSizeProvider<T> implements ListPreloader.PreloadSizeProvider<T>, SizeReadyCallback {
    private int[] size;
    private SizeViewTarget viewTarget;

    public static final class SizeViewTarget extends CustomViewTarget<View, Object> {
        @Override // com.bumptech.glide.request.target.Target
        public void onLoadFailed(Drawable r100) {
        }

        @Override // com.bumptech.glide.request.target.CustomViewTarget
        public void onResourceCleared(Drawable r100) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onResourceReady(Object r100, Transition<? super Object> r101) {
        }

        public SizeViewTarget(View r100) {
            super(r100);
        }
    }

    public ViewPreloadSizeProvider() {
    }

    public ViewPreloadSizeProvider(View r100) {
        this.viewTarget = new SizeViewTarget(r100);
        this.viewTarget.getSize(this);
    }

    public void setView(View r100) {
        if (this.size == null) goto L5;
        return;
    L5:
        if (this.viewTarget != null) goto L10;
        this.viewTarget = new SizeViewTarget(r100);
        this.viewTarget.getSize(this);
        return;
    }

    @Override // com.bumptech.glide.request.target.SizeReadyCallback
    public void onSizeReady(int r100, int r101) {
        this.size = new int[]{r100, r101};
        this.viewTarget = null;
    }

    @Override // com.bumptech.glide.ListPreloader.PreloadSizeProvider
    public int[] getPreloadSize(T r100, int r101, int r102) {
        int[] r103 = this.size;
        if (r103 != null) goto L7;
        return null;
    L7:
        return Arrays.copyOf(r103, r103.length);
    }
}
