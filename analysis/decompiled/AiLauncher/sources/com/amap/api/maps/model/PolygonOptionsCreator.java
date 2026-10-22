package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class PolygonOptionsCreator implements Parcelable.Creator<PolygonOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public PolygonOptions createFromParcel(Parcel parcel) {
        PolygonOptions polygonOptions = new PolygonOptions();
        ArrayList arrayList = new ArrayList();
        parcel.readTypedList(arrayList, LatLng.CREATOR);
        float f10 = parcel.readFloat();
        int i10 = parcel.readInt();
        int i11 = parcel.readInt();
        float f11 = parcel.readFloat();
        boolean z10 = parcel.readByte() == 1;
        LatLng[] latLngArr = new LatLng[arrayList.size()];
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            latLngArr[i12] = (LatLng) arrayList.get(i12);
        }
        polygonOptions.add(latLngArr);
        polygonOptions.strokeWidth(f10);
        polygonOptions.strokeColor(i10);
        polygonOptions.fillColor(i11);
        polygonOptions.zIndex(f11);
        polygonOptions.visible(z10);
        polygonOptions.f17231a = parcel.readString();
        ArrayList arrayList2 = new ArrayList();
        parcel.readList(arrayList2, BaseHoleOptions.class.getClassLoader());
        polygonOptions.addHoles(arrayList2);
        parcel.readByte();
        return polygonOptions;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public PolygonOptions[] newArray(int i10) {
        return new PolygonOptions[i10];
    }
}
