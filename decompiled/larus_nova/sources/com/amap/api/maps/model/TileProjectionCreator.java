package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes28.dex */
public class TileProjectionCreator implements Parcelable.Creator<TileProjection> {
    public TileProjectionCreator() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public TileProjection createFromParcel(Parcel r100) {
        return new TileProjection(r100.readInt(), r100.readInt(), r100.readInt(), r100.readInt(), r100.readInt(), r100.readInt());
    }

    @Override // android.os.Parcelable.Creator
    public /* bridge */ /* synthetic */ TileProjection[] newArray(int r100) {
        return newArray(r100);
    }

    @Override // android.os.Parcelable.Creator
    public /* bridge */ /* synthetic */ TileProjection createFromParcel(Parcel r100) {
        return createFromParcel(r100);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public TileProjection[] newArray(int r100) {
        return new TileProjection[r100];
    }
}
