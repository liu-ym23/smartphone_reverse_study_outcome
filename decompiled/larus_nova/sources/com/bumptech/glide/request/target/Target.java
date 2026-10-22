package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.transition.Transition;

/* JADX INFO: loaded from: classes39.dex */
public interface Target<R> extends LifecycleListener {
    public static final int SIZE_ORIGINAL = Integer.MIN_VALUE;

    Request getRequest();

    void getSize(SizeReadyCallback r100);

    void onLoadCleared(Drawable r100);

    void onLoadFailed(Drawable r100);

    void onLoadStarted(Drawable r100);

    void onResourceReady(R r100, Transition<? super R> r101);

    void removeCallback(SizeReadyCallback r100);

    void setRequest(Request r100);
}
