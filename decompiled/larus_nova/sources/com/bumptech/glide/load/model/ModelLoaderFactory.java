package com.bumptech.glide.load.model;

/* JADX INFO: loaded from: classes39.dex */
public interface ModelLoaderFactory<T, Y> {
    ModelLoader<T, Y> build(MultiModelLoaderFactory r100);

    void teardown();
}
