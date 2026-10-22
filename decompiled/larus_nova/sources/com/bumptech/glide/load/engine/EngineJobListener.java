package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;

/* JADX INFO: loaded from: classes39.dex */
interface EngineJobListener {
    void onEngineJobCancelled(EngineJob<?> r100, Key r101);

    void onEngineJobComplete(EngineJob<?> r100, Key r101, EngineResource<?> r102);
}
