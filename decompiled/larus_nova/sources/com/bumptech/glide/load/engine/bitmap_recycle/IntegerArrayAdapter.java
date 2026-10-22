package com.bumptech.glide.load.engine.bitmap_recycle;

/* JADX INFO: loaded from: classes39.dex */
public final class IntegerArrayAdapter implements ArrayAdapterInterface<int[]> {
    private static final String TAG = "IntegerArrayPool";

    public IntegerArrayAdapter() {
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface
    public int getElementSizeInBytes() {
        return 4;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface
    public String getTag() {
        return TAG;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface
    public /* bridge */ /* synthetic */ int getArrayLength(int[] r100) {
        return getArrayLength2(r100);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface
    public /* bridge */ /* synthetic */ int[] newArray(int r100) {
        return newArray2(r100);
    }

    /* JADX INFO: renamed from: getArrayLength, reason: avoid collision after fix types in other method */
    public int getArrayLength2(int[] r100) {
        return r100.length;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface
    /* JADX INFO: renamed from: newArray, reason: avoid collision after fix types in other method */
    public int[] newArray2(int r100) {
        return new int[r100];
    }
}
