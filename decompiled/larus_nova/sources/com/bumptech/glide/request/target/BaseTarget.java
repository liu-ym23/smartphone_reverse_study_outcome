package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.request.Request;

/* JADX INFO: loaded from: classes39.dex */
public abstract class BaseTarget<Z> implements Target<Z> {
    private Request request;

    public BaseTarget() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadCleared(Drawable r100) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadFailed(Drawable r100) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadStarted(Drawable r100) {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public Request getRequest() {
        return this.request;
    }

    @Override // com.bumptech.glide.request.target.Target
    public void setRequest(Request r100) {
        this.request = r100;
    }
}
