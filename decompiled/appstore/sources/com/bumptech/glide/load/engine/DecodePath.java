package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.util.Pools$Pool;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DecodePath<DataType, ResourceType, Transcode> {
    private static final String TAG = "DecodePath";
    private final Class<DataType> dataClass;
    private final List<? extends ResourceDecoder<DataType, ResourceType>> decoders;
    private final String failureMessage;
    private final Pools$Pool<List<Throwable>> listPool;
    private final ResourceTranscoder<ResourceType, Transcode> transcoder;

    public interface DecodeCallback<ResourceType> {
        @NonNull
        Resource<ResourceType> onResourceDecoded(@NonNull Resource<ResourceType> r10);
    }

    public DecodePath(Class<DataType> r10, Class<ResourceType> r11, Class<Transcode> r12, List<? extends ResourceDecoder<DataType, ResourceType>> r13, ResourceTranscoder<ResourceType, Transcode> r14, Pools$Pool<List<Throwable>> r15) {
        this.dataClass = r10;
        this.decoders = r13;
        this.transcoder = r14;
        this.listPool = r15;
        this.failureMessage = "Failed DecodePath{" + r10.getSimpleName() + "->" + r11.getSimpleName() + "->" + r12.getSimpleName() + "}";
    }

    @NonNull
    private Resource<ResourceType> decodeResource(DataRewinder<DataType> r10, int r11, int r12, @NonNull Options r13) throws GlideException {
        List<Throwable> r14 = (List) Preconditions.checkNotNull(this.listPool.acquire());
        Resource<ResourceType> r15 = decodeResourceWithList(r10, r11, r12, r13, r14);     // Catch: Throwable -> L6
        this.listPool.release(r14);
        return r15;
    L6:
        th = move-exception;
        this.listPool.release(r14);
        throw th;
    }

    @NonNull
    private Resource<ResourceType> decodeResourceWithList(DataRewinder<DataType> r10, int r11, int r12, @NonNull Options r13, List<Throwable> r14) throws GlideException {
        int r15 = this.decoders.size();
        Resource<ResourceType> r16 = null;
        int r17 = 0;
    L3:
        if (r17 >= r15) goto L17;
        ResourceDecoder<DataType, ResourceType> r18 = this.decoders.get(r17);
    L9:
        e = move-exception;
        if (Log.isLoggable(TAG, 2) == false) goto L13;
        Log.v(TAG, "Failed to decode data for " + r18, e);
    L13:
        r14.add(e);
    L14:
        if (r16 != null) goto L17;
        r17 = r17 + 1;
        goto L3
    L6:
        if (r18.handles(r10.rewindAndGet(), r13) == false) goto L14;
        r16 = r18.decode(r10.rewindAndGet(), r11, r12, r13);     // Catch: Throwable -> L9
    L17:
        if (r16 == null) goto L20;
        return r16;
    L20:
        throw new GlideException(this.failureMessage, new ArrayList(r14));
    }

    public Resource<Transcode> decode(DataRewinder<DataType> r10, int r11, int r12, @NonNull Options r13, DecodeCallback<ResourceType> r14) throws GlideException {
        Resource<ResourceType> r15 = r14.onResourceDecoded(decodeResource(r10, r11, r12, r13));
        return this.transcoder.transcode(r15, r13);
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.dataClass + ", decoders=" + this.decoders + ", transcoder=" + this.transcoder + '}';
    }
}
