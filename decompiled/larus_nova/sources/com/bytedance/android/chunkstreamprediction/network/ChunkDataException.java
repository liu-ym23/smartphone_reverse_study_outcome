package com.bytedance.android.chunkstreamprediction.network;

import java.util.Map;

/* JADX INFO: loaded from: classes43.dex */
public class ChunkDataException extends RuntimeException {
    public final Map<String, String> extraInfo;

    public ChunkDataException(Throwable r100, Map<String, String> r101) {
        super(r100);
        this.extraInfo = r101;
    }
}
