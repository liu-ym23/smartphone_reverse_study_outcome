package com.bumptech.glide.request;

import androidx.annotation.Nullable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.target.Target;

/* JADX INFO: loaded from: classes.dex */
public interface RequestListener<R> {
    boolean onLoadFailed(@Nullable GlideException r10, Object r11, Target<R> r12, boolean r13);

    boolean onResourceReady(R r10, Object r11, Target<R> r12, DataSource r13, boolean r14);
}
