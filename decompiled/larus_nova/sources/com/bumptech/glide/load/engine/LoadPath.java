package com.bumptech.glide.load.engine;

import androidx.core.util.Pools;
import com.alipay.sdk.m.u.i;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.util.Preconditions;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes39.dex */
public class LoadPath<Data, ResourceType, Transcode> {
    private final Class<Data> dataClass;
    private final List<? extends DecodePath<Data, ResourceType, Transcode>> decodePaths;
    private final String failureMessage;
    private final Pools.Pool<List<Throwable>> listPool;

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.decodePaths.toArray()) + '}';
    }

    public Class<Data> getDataClass() {
        return this.dataClass;
    }

    public LoadPath(Class<Data> r100, Class<ResourceType> r101, Class<Transcode> r102, List<DecodePath<Data, ResourceType, Transcode>> r103, Pools.Pool<List<Throwable>> r104) {
        this.dataClass = r100;
        this.listPool = r104;
        this.decodePaths = (List) Preconditions.checkNotEmpty(r103);
        this.failureMessage = "Failed LoadPath{" + r100.getSimpleName() + "->" + r101.getSimpleName() + "->" + r102.getSimpleName() + i.f25855d;
    }

    public Resource<Transcode> load(DataRewinder<Data> r100, Options r110, int r111, int r112, DecodePath.DecodeCallback<ResourceType> r113) throws GlideException {
        List<Throwable> r101 = (List) Preconditions.checkNotNull(this.listPool.acquire());
        Resource<Transcode> r102 = loadWithExceptionList(r100, r110, r111, r112, r113, r101);     // Catch: Throwable -> L6
        this.listPool.release(r101);
        return r102;
    L6:
        th = move-exception;
        this.listPool.release(r101);
        throw th;
    }

    private Resource<Transcode> loadWithExceptionList(DataRewinder<Data> r110, Options r111, int r112, int r113, DecodePath.DecodeCallback<ResourceType> r114, List<Throwable> r115) throws GlideException {
        int r100 = this.decodePaths.size();
        Resource<Transcode> r101 = null;
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L12;
        r101 = ((DecodePath) ListProtector.get(this.decodePaths, r102)).decode(r110, r112, r113, r111, r114);     // Catch: GlideException -> L7
    L9:
        if (r101 != null) goto L12;
        r102 = r102 + 1;
    L7:
        e = move-exception;
        r115.add(e);
    L12:
        if (r101 == null) goto L14;
        return r101;
    L14:
        GlideException r103 = new GlideException(this.failureMessage, new ArrayList(r115));
        r103.setErrorCode(GlideException.ERROR_CODE_LOAD_RESOURCE_FAILED);
        throw r103;
    }
}
