package com.bytedance.apm.block.trace;

/* JADX INFO: loaded from: classes.dex */
public interface BeatLifecycle {
    boolean isAlive();

    void onStart();

    void onStop();
}
