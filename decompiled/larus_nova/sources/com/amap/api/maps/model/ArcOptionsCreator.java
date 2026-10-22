package com.amap.api.maps.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes28.dex */
public class ArcOptionsCreator implements Parcelable.Creator<ArcOptions> {
    public ArcOptionsCreator() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public ArcOptions createFromParcel(Parcel r110) {
        ArcOptions r100 = new ArcOptions();
        Bundle r101 = r110.readBundle();
        r100.point(new LatLng(r101.getDouble("startlat"), r101.getDouble("startlng")), new LatLng(r101.getDouble("passedlat"), r101.getDouble("passedlng")), new LatLng(r101.getDouble("endlat"), r101.getDouble("endlng")));
        r100.strokeWidth(r110.readFloat());
        r100.strokeColor(r110.readInt());
        r100.zIndex(r110.readFloat());
        boolean r102 = true;
        if (r110.readByte() == 1) goto L6;
        r102 = false;
    L6:
        r100.visible(r102);
        r100.f28643a = r110.readString();
        return r100;
    }

    @Override // android.os.Parcelable.Creator
    public /* bridge */ /* synthetic */ ArcOptions[] newArray(int r100) {
        return newArray(r100);
    }

    @Override // android.os.Parcelable.Creator
    public /* bridge */ /* synthetic */ ArcOptions createFromParcel(Parcel r100) {
        return createFromParcel(r100);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public ArcOptions[] newArray(int r100) {
        return new ArcOptions[r100];
    }
}
