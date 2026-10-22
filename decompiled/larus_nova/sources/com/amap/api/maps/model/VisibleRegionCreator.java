package com.amap.api.maps.model;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes28.dex */
public class VisibleRegionCreator implements Parcelable.Creator<VisibleRegion> {
    public static final int CONTENT_DESCRIPTION = 0;

    public VisibleRegionCreator() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public VisibleRegion createFromParcel(Parcel r100) {
        int r101 = r100.readInt();
        LatLng r102 = (LatLng) r100.readParcelable(LatLng.class.getClassLoader());     // Catch: BadParcelableException -> L17
        LatLng r103 = (LatLng) r100.readParcelable(LatLng.class.getClassLoader());     // Catch: BadParcelableException -> L15
        LatLng r104 = (LatLng) r100.readParcelable(LatLng.class.getClassLoader());     // Catch: BadParcelableException -> L13
        LatLng r105 = (LatLng) r100.readParcelable(LatLng.class.getClassLoader());     // Catch: BadParcelableException -> L11
        LatLngBounds r106 = (LatLngBounds) r100.readParcelable(LatLngBounds.class.getClassLoader());     // Catch: BadParcelableException -> L9
    L23:
        return new VisibleRegion(r101, r102, r103, r104, r105, r106);
    L9:
        e = e;
    L21:
        e.printStackTrace();
        r106 = null;
    L11:
        e = e;
        r105 = null;
    L13:
        e = e;
        r104 = null;
    L20:
        r105 = r104;
    L15:
        e = e;
        r103 = null;
    L19:
        r104 = r103;
    L17:
        e = e;
        r102 = null;
        r103 = null;
        goto L19
    }

    @Override // android.os.Parcelable.Creator
    public /* bridge */ /* synthetic */ VisibleRegion[] newArray(int r100) {
        return newArray(r100);
    }

    @Override // android.os.Parcelable.Creator
    public /* bridge */ /* synthetic */ VisibleRegion createFromParcel(Parcel r100) {
        return createFromParcel(r100);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public VisibleRegion[] newArray(int r100) {
        return new VisibleRegion[r100];
    }
}
