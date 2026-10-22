package com.bumptech.glide.load.resource.bytes;

import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;

/* JADX INFO: loaded from: classes39.dex */
public class BytesResource implements Resource<byte[]> {
    private final byte[] bytes;

    @Override // com.bumptech.glide.load.engine.Resource
    public void recycle() {
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int getSize() {
        return this.bytes.length;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public /* bridge */ /* synthetic */ byte[] get() {
        return get2();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public Class<byte[]> getResourceClass() {
        return byte[].class;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
    public byte[] get2() {
        return this.bytes;
    }

    public BytesResource(byte[] r100) {
        this.bytes = (byte[]) Preconditions.checkNotNull(r100);
    }
}
