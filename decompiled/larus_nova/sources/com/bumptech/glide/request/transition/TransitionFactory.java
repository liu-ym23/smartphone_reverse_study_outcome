package com.bumptech.glide.request.transition;

import com.bumptech.glide.load.DataSource;

/* JADX INFO: loaded from: classes39.dex */
public interface TransitionFactory<R> {
    Transition<R> build(DataSource r100, boolean r101);
}
