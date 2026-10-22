package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes28.dex */
public class MarkerOptionsCreator implements Parcelable.Creator<MarkerOptions> {
    public MarkerOptionsCreator() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public MarkerOptions createFromParcel(Parcel r100) {
        MarkerOptions r101 = new MarkerOptions();
        r101.position((LatLng) r100.readParcelable(LatLng.class.getClassLoader()));
        r101.title(r100.readString());
        r101.snippet(r100.readString());
        r101.anchor(r100.readFloat(), r100.readFloat());
        r101.setInfoWindowOffset(r100.readInt(), r100.readInt());
        boolean[] r102 = new boolean[9];
        r100.readBooleanArray(r102);
        r101.visible(r102[0]);
        r101.draggable(r102[1]);
        r101.setGps(r102[2]);
        r101.setFlat(r102[3]);
        r101.autoOverturnInfoWindow(r102[4]);
        r101.infoWindowEnable(r102[5]);
        r101.belowMaskLayer(r102[6]);
        r101.setRotatingMode(r102[7]);
        r101.isOpenCollisionDetection(r102[8]);
        r101.f28660a = r100.readString();
        r101.period(r100.readInt());
        r101.icons(r100.readArrayList(BitmapDescriptor.class.getClassLoader()));
        r101.zIndex(r100.readFloat());
        r101.alpha(r100.readFloat());
        r101.displayLevel(r100.readInt());
        r101.rotateAngle(r100.readFloat());
        r101.setScreenPosition(r100.readInt(), r100.readInt());
        BitmapDescriptor r103 = (BitmapDescriptor) r100.readParcelable(BitmapDescriptor.class.getClassLoader());
        if (r103 == null) goto L5;
        r101.icon(r103);
    L5:
        return r101;
    }

    @Override // android.os.Parcelable.Creator
    public /* bridge */ /* synthetic */ MarkerOptions[] newArray(int r100) {
        return newArray(r100);
    }

    @Override // android.os.Parcelable.Creator
    public /* bridge */ /* synthetic */ MarkerOptions createFromParcel(Parcel r100) {
        return createFromParcel(r100);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public MarkerOptions[] newArray(int r100) {
        return new MarkerOptions[r100];
    }
}
