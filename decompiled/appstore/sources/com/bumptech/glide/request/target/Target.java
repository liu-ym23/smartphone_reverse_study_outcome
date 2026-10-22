package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.transition.Transition;

/* JADX INFO: loaded from: classes.dex */
public interface Target<R> extends LifecycleListener {
    public static final int SIZE_ORIGINAL = Integer.MIN_VALUE;

    @Nullable
    Request getRequest();

    void getSize(@NonNull SizeReadyCallback r10);

    void onLoadCleared(@Nullable Drawable r10);

    void onLoadFailed(@Nullable Drawable r10);

    void onLoadStarted(@Nullable Drawable r10);

    void onResourceReady(@NonNull R r10, @Nullable Transition<? super R> r11);

    void removeCallback(@NonNull SizeReadyCallback r10);

    void setRequest(@Nullable Request r10);
}
