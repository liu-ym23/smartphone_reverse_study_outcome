package com.amap.api.maps.model;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes28.dex */
public class LatLngBoundsCreator implements Parcelable.Creator<LatLngBounds> {
    public static final int CONTENT_DESCRIPTION = 0;

    public LatLngBoundsCreator() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public LatLngBounds createFromParcel(Parcel r100) {
        int r101 = r100.readInt();
        LatLng r102 = null;
        LatLng r103 = (LatLng) r100.readParcelable(LatLngBounds.class.getClassLoader());     // Catch: BadParcelableException -> L8
        r102 = (LatLng) r100.readParcelable(LatLngBounds.class.getClassLoader());     // Catch: BadParcelableException -> L6
    L12:
        return new LatLngBounds(r101, r103, r102);
    L6:
        e = e;
    L10:
        e.printStackTrace();
    L8:
        e = e;
        r103 = null;
        goto L10
    }

    @Override // android.os.Parcelable.Creator
    public /* bridge */ /* synthetic */ LatLngBounds[] newArray(int r100) {
        return newArray(r100);
    }

    @Override // android.os.Parcelable.Creator
    public /* bridge */ /* synthetic */ LatLngBounds createFromParcel(Parcel r100) {
        return createFromParcel(r100);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public LatLngBounds[] newArray(int r100) {
        return new LatLngBounds[r100];
    }
}
