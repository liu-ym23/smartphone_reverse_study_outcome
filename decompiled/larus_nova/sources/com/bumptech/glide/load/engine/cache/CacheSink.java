package com.bumptech.glide.load.engine.cache;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes39.dex */
public interface CacheSink {
    OutputStream openOutputStream() throws IOException;
}
