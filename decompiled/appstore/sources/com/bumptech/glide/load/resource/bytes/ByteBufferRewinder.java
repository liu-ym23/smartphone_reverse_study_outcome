package com.bumptech.glide.load.resource.bytes;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.data.DataRewinder;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class ByteBufferRewinder implements DataRewinder<ByteBuffer> {
    private final ByteBuffer buffer;

    public static class Factory implements DataRewinder.Factory<ByteBuffer> {
        public Factory() {
        }

        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        @NonNull
        public /* bridge */ /* synthetic */ DataRewinder<ByteBuffer> build(ByteBuffer r10) {
            return build2(r10);
        }

        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        @NonNull
        public Class<ByteBuffer> getDataClass() {
            return ByteBuffer.class;
        }

        @NonNull
        /* JADX INFO: renamed from: build, reason: avoid collision after fix types in other method */
        public DataRewinder<ByteBuffer> build2(ByteBuffer r10) {
            return new ByteBufferRewinder(r10);
        }
    }

    public ByteBufferRewinder(ByteBuffer r10) {
        this.buffer = r10;
    }

    @Override // com.bumptech.glide.load.data.DataRewinder
    public void cleanup() {
    }

    @Override // com.bumptech.glide.load.data.DataRewinder
    @NonNull
    public /* bridge */ /* synthetic */ ByteBuffer rewindAndGet() throws IOException {
        return rewindAndGet2();
    }

    @Override // com.bumptech.glide.load.data.DataRewinder
    @NonNull
    /* JADX INFO: renamed from: rewindAndGet, reason: avoid collision after fix types in other method */
    public ByteBuffer rewindAndGet2() {
        this.buffer.position(0);
        return this.buffer;
    }
}
