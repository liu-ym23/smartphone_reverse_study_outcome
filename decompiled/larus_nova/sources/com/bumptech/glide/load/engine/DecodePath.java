package com.bumptech.glide.load.engine;

import androidx.core.util.Pools;
import com.alipay.sdk.m.u.i;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.util.GlideLogUtil;
import com.bumptech.glide.util.Preconditions;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class DecodePath<DataType, ResourceType, Transcode> {
    private static final String TAG = "DecodePath";
    private final Class<DataType> dataClass;
    private final List<? extends ResourceDecoder<DataType, ResourceType>> decoders;
    private final String failureMessage;
    private final Pools.Pool<List<Throwable>> listPool;
    private final ResourceTranscoder<ResourceType, Transcode> transcoder;

    public interface DecodeCallback<ResourceType> {
        Resource<ResourceType> onResourceDecoded(Resource<ResourceType> r100);
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.dataClass + ", decoders=" + this.decoders + ", transcoder=" + this.transcoder + '}';
    }

    private Resource<ResourceType> decodeResource(DataRewinder<DataType> r100, int r101, int r110, Options r111) throws GlideException {
        List<Throwable> r102 = (List) Preconditions.checkNotNull(this.listPool.acquire());
        Resource<ResourceType> r103 = decodeResourceWithList(r100, r101, r110, r111, r102);     // Catch: Throwable -> L6
        this.listPool.release(r102);
        return r103;
    L6:
        th = move-exception;
        this.listPool.release(r102);
        throw th;
    }

    private Resource<ResourceType> decodeResourceWithList(DataRewinder<DataType> r100, int r110, int r111, Options r112, List<Throwable> r113) throws GlideException {
        int r101 = this.decoders.size();
        Resource<ResourceType> r102 = null;
        int r103 = 0;
    L4:
        if (r103 >= r101) goto L19;
        ResourceDecoder r104 = (ResourceDecoder) ListProtector.get(this.decoders, r103);
    L14:
        e = move-exception;
        GlideLogUtil.e(TAG, "Failed to decode data for " + r104, e);
        r113.add(e);
    L16:
        if (r102 != null) goto L19;
        r103 = r103 + 1;
        goto L4
    L7:
        if (r104.handles(r100.rewindAndGet(), r112) == false) goto L16;
        r102 = r104.decode(r100.rewindAndGet(), r110, r111, r112);     // Catch: OutOfMemoryError -> L10 RuntimeException -> L12 Throwable -> L14
    L19:
        if (r102 == null) goto L21;
        return r102;
    L21:
        GlideException r105 = new GlideException(this.failureMessage, new ArrayList(r113));
        r105.setErrorCode(GlideException.ERROR_CODE_DECODE_RESOURCE_FAILED);
        GlideLogUtil.d(TAG, "decode error:" + r105);
        throw r105;
    }

    public Resource<Transcode> decode(DataRewinder<DataType> r100, int r101, int r102, Options r103, DecodeCallback<ResourceType> r104) throws GlideException {
        Resource<ResourceType> r105 = r104.onResourceDecoded(decodeResource(r100, r101, r102, r103));
        return this.transcoder.transcode(r105, r103);
    }

    public DecodePath(Class<DataType> r100, Class<ResourceType> r101, Class<Transcode> r102, List<? extends ResourceDecoder<DataType, ResourceType>> r103, ResourceTranscoder<ResourceType, Transcode> r104, Pools.Pool<List<Throwable>> r105) {
        this.dataClass = r100;
        this.decoders = r103;
        this.transcoder = r104;
        this.listPool = r105;
        this.failureMessage = "Failed DecodePath{" + r100.getSimpleName() + "->" + r101.getSimpleName() + "->" + r102.getSimpleName() + i.f25855d;
    }
}
