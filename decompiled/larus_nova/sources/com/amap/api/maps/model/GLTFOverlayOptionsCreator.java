package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes28.dex */
public class GLTFOverlayOptionsCreator implements Parcelable.Creator<GLTFOverlayOptions> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public GLTFOverlayOptions[] newArray(int r100) {
        return new GLTFOverlayOptions[0];
    }

    public GLTFOverlayOptionsCreator() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public GLTFOverlayOptions createFromParcel(Parcel r110) {
        LatLng r100 = (LatLng) r110.readParcelable(LatLng.class.getClassLoader());
        double r111 = r110.readDouble();
        double r112 = r110.readDouble();
        double r113 = r110.readDouble();
        GLTFOverlayOptions r101 = new GLTFOverlayOptions(r100, r110.readDouble(), r110.readDouble(), r110.readString(), r110.readArrayList(GLTFResourceIterm.class.getClassLoader()));
        r101.rotationDegree(r112, r113, r111);
        return r101;
    }

    @Override // android.os.Parcelable.Creator
    public /* bridge */ /* synthetic */ GLTFOverlayOptions[] newArray(int r100) {
        return newArray(r100);
    }

    @Override // android.os.Parcelable.Creator
    public /* bridge */ /* synthetic */ GLTFOverlayOptions createFromParcel(Parcel r100) {
        return createFromParcel(r100);
    }
}
