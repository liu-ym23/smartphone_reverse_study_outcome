package com.bumptech.glide.manager;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public interface Lifecycle {
    void addListener(@NonNull LifecycleListener r10);

    void removeListener(@NonNull LifecycleListener r10);
}
