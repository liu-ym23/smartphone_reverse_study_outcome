package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes28.dex */
public class TileProjection implements Parcelable {
    public static final TileProjection CREATOR = null;
    public final int maxX;
    public final int maxY;
    public final int minX;
    public final int minY;
    public final int offsetX;
    public final int offsetY;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new TileProjection(0, 0, 0, 0, 0, 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.offsetX);
        r100.writeInt(this.offsetY);
        r100.writeInt(this.minX);
        r100.writeInt(this.maxX);
        r100.writeInt(this.minY);
        r100.writeInt(this.maxY);
    }

    public TileProjection(int r100, int r101, int r102, int r103, int r104, int r105) {
        this.offsetX = r100;
        this.offsetY = r101;
        this.minX = r102;
        this.maxX = r103;
        this.minY = r104;
        this.maxY = r105;
    }
}
