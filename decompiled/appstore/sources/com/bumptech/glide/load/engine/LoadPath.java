package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import androidx.core.util.Pools$Pool;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LoadPath<Data, ResourceType, Transcode> {
    private final Class<Data> dataClass;
    private final List<? extends DecodePath<Data, ResourceType, Transcode>> decodePaths;
    private final String failureMessage;
    private final Pools$Pool<List<Throwable>> listPool;

    public LoadPath(Class<Data> r10, Class<ResourceType> r11, Class<Transcode> r12, List<DecodePath<Data, ResourceType, Transcode>> r13, Pools$Pool<List<Throwable>> r14) {
        this.dataClass = r10;
        this.listPool = r14;
        this.decodePaths = (List) Preconditions.checkNotEmpty(r13);
        this.failureMessage = "Failed LoadPath{" + r10.getSimpleName() + "->" + r11.getSimpleName() + "->" + r12.getSimpleName() + "}";
    }

    private Resource<Transcode> loadWithExceptionList(DataRewinder<Data> r13, @NonNull Options r14, int r15, int r16, DecodePath.DecodeCallback<ResourceType> r17, List<Throwable> r18) throws GlideException {
        int r10 = this.decodePaths.size();
        int r11 = 0;
        Resource<Transcode> r12 = null;
    L3:
        if (r11 >= r10) goto L12;
        r12 = this.decodePaths.get(r11).decode(r13, r15, r16, r14, r17);     // Catch: GlideException -> L7
    L9:
        if (r12 != null) goto L12;
        r11 = r11 + 1;
    L7:
        e = move-exception;
        r18.add(e);
    L12:
        if (r12 == null) goto L15;
        return r12;
    L15:
        throw new GlideException(this.failureMessage, new ArrayList(r18));
    }

    public Class<Data> getDataClass() {
        return this.dataClass;
    }

    public Resource<Transcode> load(DataRewinder<Data> r10, @NonNull Options r11, int r12, int r13, DecodePath.DecodeCallback<ResourceType> r14) throws GlideException {
        List<Throwable> r15 = (List) Preconditions.checkNotNull(this.listPool.acquire());
        Resource<Transcode> r16 = loadWithExceptionList(r10, r11, r12, r13, r14, r15);     // Catch: Throwable -> L6
        this.listPool.release(r15);
        return r16;
    L6:
        th = move-exception;
        this.listPool.release(r15);
        throw th;
    }

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.decodePaths.toArray()) + '}';
    }
}
