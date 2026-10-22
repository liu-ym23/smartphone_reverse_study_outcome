package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class MarkerOptionsCreator implements Parcelable.Creator<MarkerOptions> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public MarkerOptions createFromParcel(Parcel parcel) {
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position((LatLng) parcel.readParcelable(LatLng.class.getClassLoader()));
        markerOptions.title(parcel.readString());
        markerOptions.snippet(parcel.readString());
        markerOptions.anchor(parcel.readFloat(), parcel.readFloat());
        markerOptions.setInfoWindowOffset(parcel.readInt(), parcel.readInt());
        boolean[] zArr = new boolean[9];
        parcel.readBooleanArray(zArr);
        markerOptions.visible(zArr[0]);
        markerOptions.draggable(zArr[1]);
        markerOptions.setGps(zArr[2]);
        markerOptions.infoWindowEnable(zArr[5]);
        markerOptions.clickable(zArr[8]);
        markerOptions.f17225a = parcel.readString();
        markerOptions.zIndex(parcel.readFloat());
        markerOptions.rotateAngle(parcel.readFloat());
        BitmapDescriptor bitmapDescriptor = (BitmapDescriptor) parcel.readParcelable(BitmapDescriptor.class.getClassLoader());
        if (bitmapDescriptor != null) {
            markerOptions.icon(bitmapDescriptor);
        }
        return markerOptions;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public MarkerOptions[] newArray(int i10) {
        return new MarkerOptions[i10];
    }
}
