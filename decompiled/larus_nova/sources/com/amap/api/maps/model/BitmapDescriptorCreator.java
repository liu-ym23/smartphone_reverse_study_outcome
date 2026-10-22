package com.amap.api.maps.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes28.dex */
public class BitmapDescriptorCreator implements Parcelable.Creator<BitmapDescriptor> {
    public BitmapDescriptorCreator() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public BitmapDescriptor createFromParcel(Parcel r100) {
        BitmapDescriptor r101 = new BitmapDescriptor(null, r100.readString());
        r101.mBitmap = r100.readParcelable(Bitmap.class.getClassLoader());
        r101.f28644a = r100.readInt();
        r101.f28645b = r100.readInt();
        return r101;
    }

    @Override // android.os.Parcelable.Creator
    public /* bridge */ /* synthetic */ BitmapDescriptor[] newArray(int r100) {
        return newArray(r100);
    }

    @Override // android.os.Parcelable.Creator
    public /* bridge */ /* synthetic */ BitmapDescriptor createFromParcel(Parcel r100) {
        return createFromParcel(r100);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public BitmapDescriptor[] newArray(int r100) {
        return new BitmapDescriptor[r100];
    }
}
