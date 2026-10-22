package com.bumptech.glide.request;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Resource;

/* JADX INFO: loaded from: classes.dex */
public interface ResourceCallback {
    void onLoadFailed(GlideException r10);

    void onResourceReady(Resource<?> r10, DataSource r11);
}
