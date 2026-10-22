package com.bumptech.glide.load;

import com.bumptech.glide.load.engine.Resource;
import java.io.IOException;

/* JADX INFO: loaded from: classes39.dex */
public interface ResourceDecoder<T, Z> {
    Resource<Z> decode(T r100, int r101, int r102, Options r103) throws IOException;

    boolean handles(T r100, Options r101) throws IOException;
}
