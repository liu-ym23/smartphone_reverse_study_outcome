package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes28.dex */
public class PolylineOptionsCreator implements Parcelable.Creator<PolylineOptions> {
    public PolylineOptionsCreator() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public PolylineOptions createFromParcel(Parcel r110) {
        PolylineOptions r100 = new PolylineOptions();
        ArrayList r101 = new ArrayList();
        r110.readTypedList(r101, LatLng.CREATOR);
        float r102 = r110.readFloat();
        int r103 = r110.readInt();
        int r104 = r110.readInt();
        float r105 = r110.readFloat();
        float r106 = r110.readFloat();
        r100.f28663a = r110.readString();
        r100.lineCapType(PolylineOptions.LineCapType.valueOf(r110.readInt()));
        r100.lineJoinType(PolylineOptions.LineJoinType.valueOf(r110.readInt()));
        boolean[] r107 = new boolean[5];
        r110.readBooleanArray(r107);
        BitmapDescriptor r108 = (BitmapDescriptor) r110.readParcelable(BitmapDescriptor.class.getClassLoader());
        r100.addAll(r101);
        r100.width(r102);
        r100.color(r103);
        r100.setDottedLineType(r104);
        r100.zIndex(r105);
        r100.transparency(r106);
        r100.visible(r107[0]);
        r100.setDottedLine(r107[1]);
        r100.geodesic(r107[2]);
        r100.useGradient(r107[3]);
        r100.aboveMaskLayer(r107[4]);
        r100.setCustomTexture(r108);
        r100.setCustomTextureList(r110.readArrayList(BitmapDescriptor.class.getClassLoader()));
        r100.setCustomTextureIndex(r110.readArrayList(Integer.class.getClassLoader()));
        r100.colorValues(r110.readArrayList(Integer.class.getClassLoader()));
        r100.setShownRatio(r110.readFloat());
        return r100;
    }

    @Override // android.os.Parcelable.Creator
    public /* bridge */ /* synthetic */ PolylineOptions[] newArray(int r100) {
        return newArray(r100);
    }

    @Override // android.os.Parcelable.Creator
    public /* bridge */ /* synthetic */ PolylineOptions createFromParcel(Parcel r100) {
        return createFromParcel(r100);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public PolylineOptions[] newArray(int r100) {
        return new PolylineOptions[r100];
    }
}
