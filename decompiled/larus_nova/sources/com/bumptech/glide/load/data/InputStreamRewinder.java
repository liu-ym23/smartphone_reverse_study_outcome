package com.bumptech.glide.load.data;

import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import com.bumptech.glide.util.GlideCommonUtils;
import com.ss.android.lark.log.Log;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes39.dex */
public final class InputStreamRewinder implements DataRewinder<InputStream> {
    private static final int MARK_READ_LIMIT = 5242880;
    private static final String TAG = "InputStreamRewinder";
    private final RecyclableBufferedInputStream bufferedStream;

    public static final class Factory implements DataRewinder.Factory<InputStream> {
        private final ArrayPool byteArrayPool;

        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        public Class<InputStream> getDataClass() {
            return InputStream.class;
        }

        public Factory(ArrayPool r100) {
            this.byteArrayPool = r100;
        }

        /* JADX INFO: renamed from: build, reason: avoid collision after fix types in other method */
        public DataRewinder<InputStream> build2(InputStream r100) {
            return new InputStreamRewinder(r100, this.byteArrayPool);
        }

        @Override // com.bumptech.glide.load.data.DataRewinder.Factory
        public /* bridge */ /* synthetic */ DataRewinder<InputStream> build(InputStream r100) {
            return build2(r100);
        }
    }

    @Override // com.bumptech.glide.load.data.DataRewinder
    public void cleanup() {
        this.bufferedStream.release();
    }

    public void fixMarkLimits() {
        this.bufferedStream.fixMarkLimit();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.data.DataRewinder
    public InputStream rewindAndGet() throws IOException {
        this.bufferedStream.reset();
        return this.bufferedStream;
    }

    @Override // com.bumptech.glide.load.data.DataRewinder
    public /* bridge */ /* synthetic */ InputStream rewindAndGet() throws IOException {
        return rewindAndGet();
    }

    public InputStreamRewinder(InputStream r100, ArrayPool r101) {
        RecyclableBufferedInputStream r102 = new RecyclableBufferedInputStream(r100, r101);
        this.bufferedStream = r102;
        if (GlideCommonUtils.getUseImageLoadImprove() == true) goto L12;
        r102.mark(5242880);
        return;
    L12:
        int r103 = r100.available();     // Catch: IOException -> L9
        if (r103 > 0) goto L7;
        r103 = 5242880;
    L7:
        r102.mark(r103);     // Catch: IOException -> L9
        Log.i(TAG, "rewindAndGet, available is:" + r103);     // Catch: IOException -> L9
        return;
    L9:
        this.bufferedStream.mark(5242880);
    }
}
