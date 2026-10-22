package com.bumptech.glide.load.resource.transcode;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;

/* JADX INFO: loaded from: classes39.dex */
public interface ResourceTranscoder<Z, R> {
    Resource<R> transcode(Resource<Z> r100, Options r101);
}
