package com.bumptech.glide.load.resource.transcode;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;

/* JADX INFO: loaded from: classes39.dex */
public class UnitTranscoder<Z> implements ResourceTranscoder<Z, Z> {
    private static final UnitTranscoder<?> UNIT_TRANSCODER = null;

    public UnitTranscoder() {
    }

    @Override // com.bumptech.glide.load.resource.transcode.ResourceTranscoder
    public Resource<Z> transcode(Resource<Z> r100, Options r101) {
        return r100;
    }

    static {
        UNIT_TRANSCODER = new UnitTranscoder();
    }

    public static <Z> ResourceTranscoder<Z, Z> get() {
        return UNIT_TRANSCODER;
    }
}
