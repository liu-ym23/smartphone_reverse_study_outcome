package com.tmall.wireless.tangram.ext;

/* JADX INFO: loaded from: classes4.dex */
public interface PullFromEndListener {
    int getPullEdge();

    boolean isReadyToPull();

    void onAction();

    void onPull(float r10, float r11);

    void onReleaseToAction(float r10, float r11);

    void onReset();
}
