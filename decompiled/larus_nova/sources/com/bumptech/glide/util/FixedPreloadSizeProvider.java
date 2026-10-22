package com.bumptech.glide.util;

import com.bumptech.glide.ListPreloader;

/* JADX INFO: loaded from: classes39.dex */
public class FixedPreloadSizeProvider<T> implements ListPreloader.PreloadSizeProvider<T> {
    private final int[] size;

    public FixedPreloadSizeProvider(int r100, int r101) {
        this.size = new int[]{r100, r101};
    }

    @Override // com.bumptech.glide.ListPreloader.PreloadSizeProvider
    public int[] getPreloadSize(T r100, int r101, int r102) {
        return this.size;
    }
}
