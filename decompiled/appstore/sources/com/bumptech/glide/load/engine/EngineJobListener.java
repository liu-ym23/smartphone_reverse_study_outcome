package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;

/* JADX INFO: loaded from: classes.dex */
interface EngineJobListener {
    void onEngineJobCancelled(EngineJob<?> r10, Key r11);

    void onEngineJobComplete(EngineJob<?> r10, Key r11, EngineResource<?> r12);
}
