package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class InputStreamRewinder implements DataRewinder<InputStream> {
    private static final int MARK_LIMIT = 5242880;
    private final RecyclableBufferedInputStream bufferedStream;

    public static final class Factory implements DataRewinder.Factory<InputStream> {
        private final ArrayPool byteArrayPool;

        public Factory(ArrayPool r10) {
            this.byteArrayPool = r10;
        }

        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        @NonNull
        public /* bridge */ /* synthetic */ DataRewinder<InputStream> build(InputStream r10) {
            return build2(r10);
        }

        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        @NonNull
        public Class<InputStream> getDataClass() {
            return InputStream.class;
        }

        @NonNull
        /* JADX INFO: renamed from: build, reason: avoid collision after fix types in other method */
        public DataRewinder<InputStream> build2(InputStream r10) {
            return new InputStreamRewinder(r10, this.byteArrayPool);
        }
    }

    public InputStreamRewinder(InputStream r10, ArrayPool r11) {
        RecyclableBufferedInputStream r12 = new RecyclableBufferedInputStream(r10, r11);
        this.bufferedStream = r12;
        r12.mark(MARK_LIMIT);
    }

    @Override // com.bumptech.glide.load.data.DataRewinder
    public void cleanup() {
        this.bufferedStream.release();
    }

    @Override // com.bumptech.glide.load.data.DataRewinder
    @NonNull
    public /* bridge */ /* synthetic */ InputStream rewindAndGet() throws IOException {
        return rewindAndGet();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.data.DataRewinder
    @NonNull
    public InputStream rewindAndGet() throws IOException {
        this.bufferedStream.reset();
        return this.bufferedStream;
    }
}
