package com.bumptech.glide.request.transition;

import com.bumptech.glide.load.DataSource;

/* JADX INFO: loaded from: classes.dex */
public interface TransitionFactory<R> {
    Transition<R> build(DataSource r10, boolean r11);
}
