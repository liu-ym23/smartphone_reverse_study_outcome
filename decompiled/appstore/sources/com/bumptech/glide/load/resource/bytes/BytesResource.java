package com.bumptech.glide.load.resource.bytes;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public class BytesResource implements Resource<byte[]> {
    private final byte[] bytes;

    public BytesResource(byte[] r10) {
        this.bytes = (byte[]) Preconditions.checkNotNull(r10);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public /* bridge */ /* synthetic */ byte[] get() {
        return get2();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    public Class<byte[]> getResourceClass() {
        return byte[].class;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return this.bytes.length;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void recycle() {
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
    public byte[] get2() {
        return this.bytes;
    }
}
