package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes28.dex */
public class GroundOverlayOptionsCreator implements Parcelable.Creator<GroundOverlayOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    public GroundOverlayOptionsCreator() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public GroundOverlayOptions createFromParcel(Parcel r110) {
        int r100 = r110.readInt();
        BitmapDescriptor r111 = (BitmapDescriptor) r110.readParcelable(BitmapDescriptor.class.getClassLoader());
        LatLng r101 = (LatLng) r110.readParcelable(LatLng.class.getClassLoader());
        float r102 = r110.readFloat();
        float r103 = r110.readFloat();
        LatLngBounds r104 = (LatLngBounds) r110.readParcelable(LatLngBounds.class.getClassLoader());
        float r105 = r110.readFloat();
        float r106 = r110.readFloat();
        if (r110.readByte() == 0) goto L5;
        boolean r107 = true;
    L6:
        GroundOverlayOptions r112 = new GroundOverlayOptions(r100, r101, r102, r103, r104, r105, r106, r107, r110.readFloat(), r110.readFloat(), r110.readFloat());
        r112.image(r111);
        return r112;
    L5:
        r107 = false;
        goto L6
    }

    @Override // android.os.Parcelable.Creator
    public /* bridge */ /* synthetic */ GroundOverlayOptions[] newArray(int r100) {
        return newArray(r100);
    }

    @Override // android.os.Parcelable.Creator
    public /* bridge */ /* synthetic */ GroundOverlayOptions createFromParcel(Parcel r100) {
        return createFromParcel(r100);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public GroundOverlayOptions[] newArray(int r100) {
        return new GroundOverlayOptions[r100];
    }
}
