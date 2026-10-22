package com.bumptech.glide.util;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.ListPreloader;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.request.transition.Transition;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class ViewPreloadSizeProvider<T> implements ListPreloader.PreloadSizeProvider<T>, SizeReadyCallback {
    private int[] size;
    private SizeViewTarget viewTarget;

    public static final class SizeViewTarget extends ViewTarget<View, Object> {
        public SizeViewTarget(@NonNull View r10, @NonNull SizeReadyCallback r11) {
            super(r10);
            getSize(r11);
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onResourceReady(@NonNull Object r10, @Nullable Transition<? super Object> r11) {
        }
    }

    public ViewPreloadSizeProvider() {
    }

    @Override // com.bumptech.glide.ListPreloader.PreloadSizeProvider
    @Nullable
    public int[] getPreloadSize(@NonNull T r10, int r11, int r12) {
        int[] r13 = this.size;
        if (r13 != null) goto L7;
        return null;
    L7:
        return Arrays.copyOf(r13, r13.length);
    }

    @Override // com.bumptech.glide.request.target.SizeReadyCallback
    public void onSizeReady(int r10, int r11) {
        this.size = new int[]{r10, r11};
        this.viewTarget = null;
    }

    public void setView(@NonNull View r10) {
        if (this.size == null) goto L5;
        return;
    L5:
        if (this.viewTarget != null) goto L10;
        this.viewTarget = new SizeViewTarget(r10, this);
        return;
    }

    public ViewPreloadSizeProvider(@NonNull View r10) {
        this.viewTarget = new SizeViewTarget(r10, this);
    }
}
