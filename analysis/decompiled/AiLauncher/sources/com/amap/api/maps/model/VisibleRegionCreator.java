package com.amap.api.maps.model;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class VisibleRegionCreator implements Parcelable.Creator<VisibleRegion> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public VisibleRegion createFromParcel(Parcel parcel) {
        BadParcelableException badParcelableException;
        LatLng latLng;
        LatLng latLng2;
        LatLng latLng3;
        LatLng latLng4;
        LatLngBounds latLngBounds;
        int i10 = parcel.readInt();
        try {
            latLng2 = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
        } catch (BadParcelableException e10) {
            badParcelableException = e10;
            latLng = null;
            latLng2 = null;
            latLng3 = null;
        }
        try {
            latLng3 = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            try {
                latLng4 = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
                try {
                    latLng = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
                    try {
                        latLngBounds = (LatLngBounds) parcel.readParcelable(LatLngBounds.class.getClassLoader());
                    } catch (BadParcelableException e11) {
                        badParcelableException = e11;
                        badParcelableException.printStackTrace();
                        latLngBounds = null;
                        return new VisibleRegion(i10, latLng2, latLng3, latLng4, latLng, latLngBounds);
                    }
                } catch (BadParcelableException e12) {
                    badParcelableException = e12;
                    latLng = null;
                }
            } catch (BadParcelableException e13) {
                badParcelableException = e13;
                latLng = null;
                latLng4 = null;
            }
        } catch (BadParcelableException e14) {
            badParcelableException = e14;
            latLng = null;
            latLng3 = null;
            latLng4 = latLng3;
            badParcelableException.printStackTrace();
            latLngBounds = null;
            return new VisibleRegion(i10, latLng2, latLng3, latLng4, latLng, latLngBounds);
        }
        return new VisibleRegion(i10, latLng2, latLng3, latLng4, latLng, latLngBounds);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public VisibleRegion[] newArray(int i10) {
        return new VisibleRegion[i10];
    }
}
