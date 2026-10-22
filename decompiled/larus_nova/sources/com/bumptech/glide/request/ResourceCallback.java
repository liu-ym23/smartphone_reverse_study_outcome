package com.bumptech.glide.request;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Resource;

/* JADX INFO: loaded from: classes39.dex */
public interface ResourceCallback {
    Object getLock();

    void onLoadFailed(GlideException r100);

    void onResourceReady(Resource<?> r100, DataSource r101);
}
