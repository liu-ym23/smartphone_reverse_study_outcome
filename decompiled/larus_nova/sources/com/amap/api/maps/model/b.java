package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes28.dex */
class b implements Parcelable.Creator<Tile> {
    public b() {
    }

    @Override // android.os.Parcelable.Creator
    public Tile createFromParcel(Parcel r100) {
        int r101 = r100.readInt();
        int r102 = r100.readInt();
        int r103 = r100.readInt();
        byte[] r104 = r100.createByteArray();
        if (r100.readInt() != 1) goto L5;
        boolean r105 = true;
    L7:
        return new Tile(r101, r102, r103, r104, r105);
    L5:
        r105 = false;
        goto L7
    }

    @Override // android.os.Parcelable.Creator
    public Tile[] newArray(int r100) {
        return new Tile[r100];
    }
}
