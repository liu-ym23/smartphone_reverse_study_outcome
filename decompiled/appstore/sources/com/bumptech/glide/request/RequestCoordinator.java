package com.bumptech.glide.request;

/* JADX INFO: loaded from: classes.dex */
public interface RequestCoordinator {
    boolean canNotifyCleared(Request r10);

    boolean canNotifyStatusChanged(Request r10);

    boolean canSetImage(Request r10);

    boolean isAnyResourceSet();

    void onRequestFailed(Request r10);

    void onRequestSuccess(Request r10);
}
