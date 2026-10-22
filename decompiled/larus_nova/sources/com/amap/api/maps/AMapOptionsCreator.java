package com.amap.api.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.maps.model.CameraPosition;

/* JADX INFO: loaded from: classes28.dex */
public class AMapOptionsCreator implements Parcelable.Creator<AMapOptions> {
    public AMapOptionsCreator() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public AMapOptions createFromParcel(Parcel r100) {
        AMapOptions r101 = new AMapOptions();
        CameraPosition r102 = (CameraPosition) r100.readParcelable(CameraPosition.class.getClassLoader());
        r101.mapType(r100.readInt());
        r101.logoPosition(r100.readInt());
        r101.camera(r102);
        boolean[] r103 = r100.createBooleanArray();
        if (r103 != null) goto L5;
    L7:
        return r101;
    L5:
        if (r103.length < 6) goto L7;
        r101.rotateGesturesEnabled(r103[0]);
        r101.scrollGesturesEnabled(r103[1]);
        r101.tiltGesturesEnabled(r103[2]);
        r101.zoomGesturesEnabled(r103[3]);
        r101.zoomControlsEnabled(r103[4]);
        r101.zOrderOnTop(r103[5]);
        r101.compassEnabled(r103[6]);
        r101.scaleControlsEnabled(r103[7]);
        goto L7
    }

    @Override // android.os.Parcelable.Creator
    public /* bridge */ /* synthetic */ AMapOptions[] newArray(int r100) {
        return newArray(r100);
    }

    @Override // android.os.Parcelable.Creator
    public /* bridge */ /* synthetic */ AMapOptions createFromParcel(Parcel r100) {
        return createFromParcel(r100);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public AMapOptions[] newArray(int r100) {
        return new AMapOptions[r100];
    }
}
