package com.bumptech.glide.load.engine.bitmap_recycle;

/* JADX INFO: loaded from: classes39.dex */
public final class ByteArrayAdapter implements ArrayAdapterInterface<byte[]> {
    private static final String TAG = "ByteArrayPool";

    public ByteArrayAdapter() {
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface
    public int getElementSizeInBytes() {
        return 1;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface
    public String getTag() {
        return TAG;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface
    public /* bridge */ /* synthetic */ int getArrayLength(byte[] r100) {
        return getArrayLength2(r100);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface
    public /* bridge */ /* synthetic */ byte[] newArray(int r100) {
        return newArray2(r100);
    }

    /* JADX INFO: renamed from: getArrayLength, reason: avoid collision after fix types in other method */
    public int getArrayLength2(byte[] r100) {
        return r100.length;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface
    /* JADX INFO: renamed from: newArray, reason: avoid collision after fix types in other method */
    public byte[] newArray2(int r100) {
        return new byte[r100];
    }
}
