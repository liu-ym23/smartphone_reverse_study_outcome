package com.amap.api.maps.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class BitmapDescriptorCreator implements Parcelable.Creator<BitmapDescriptor> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public BitmapDescriptor createFromParcel(Parcel parcel) {
        BitmapDescriptor bitmapDescriptor = new BitmapDescriptor(null, parcel.readString());
        bitmapDescriptor.f17222c = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        bitmapDescriptor.f17220a = parcel.readInt();
        bitmapDescriptor.f17221b = parcel.readInt();
        return bitmapDescriptor;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public BitmapDescriptor[] newArray(int i10) {
        return new BitmapDescriptor[i10];
    }
}
