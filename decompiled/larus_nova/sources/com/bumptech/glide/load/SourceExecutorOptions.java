package com.bumptech.glide.load;

import com.bumptech.glide.load.engine.executor.GlideExecutor;

/* JADX INFO: loaded from: classes39.dex */
public class SourceExecutorOptions {
    public static final Option<GlideExecutor> SOURCE_EXECUTOR = null;

    public SourceExecutorOptions() {
    }

    static {
        SOURCE_EXECUTOR = Option.memory("com.bumptech.glide.load.SourceExecutorOptions.SOURCE_EXECUTOR");
    }
}
