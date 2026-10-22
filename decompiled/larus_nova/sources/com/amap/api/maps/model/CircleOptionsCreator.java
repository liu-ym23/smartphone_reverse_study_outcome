package com.amap.api.maps.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes28.dex */
public class CircleOptionsCreator implements Parcelable.Creator<CircleOptions> {
    public CircleOptionsCreator() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public CircleOptions createFromParcel(Parcel r100) {
        CircleOptions r101 = new CircleOptions();
        Bundle r102 = r100.readBundle();
        r101.center(new LatLng(r102.getDouble("lat"), r102.getDouble("lng")));
        r101.radius(r100.readDouble());
        r101.strokeWidth(r100.readFloat());
        r101.strokeColor(r100.readInt());
        r101.fillColor(r100.readInt());
        r101.zIndex(r100.readFloat());
        boolean r103 = false;
        if (r100.readByte() != 1) goto L5;
        boolean r104 = true;
    L6:
        r101.visible(r104);
        r101.f28647a = r100.readString();
        ArrayList r105 = new ArrayList();
        r100.readList(r105, BaseHoleOptions.class.getClassLoader());
        r101.addHoles(r105);
        r101.setStrokeDottedLineType(r100.readInt());
        if (r100.readByte() != 1) goto L9;
        r103 = true;
    L9:
        r101.usePolylineStroke(r103);
        return r101;
    L5:
        r104 = false;
        goto L6
    }

    @Override // android.os.Parcelable.Creator
    public /* bridge */ /* synthetic */ CircleOptions[] newArray(int r100) {
        return newArray(r100);
    }

    @Override // android.os.Parcelable.Creator
    public /* bridge */ /* synthetic */ CircleOptions createFromParcel(Parcel r100) {
        return createFromParcel(r100);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public CircleOptions[] newArray(int r100) {
        return new CircleOptions[r100];
    }
}
