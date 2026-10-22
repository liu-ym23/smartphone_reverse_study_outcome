package com.bumptech.glide.request;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.target.Target;

/* JADX INFO: loaded from: classes39.dex */
public interface RequestListener<R> {
    boolean onLoadFailed(GlideException r100, Object r101, Target<R> r102, boolean r103);

    boolean onResourceReady(R r100, Object r101, Target<R> r102, DataSource r103, boolean r104);
}
