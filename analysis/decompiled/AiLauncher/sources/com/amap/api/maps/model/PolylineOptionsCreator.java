package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.maps.model.PolylineOptions;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class PolylineOptionsCreator implements Parcelable.Creator<PolylineOptions> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public PolylineOptions createFromParcel(Parcel parcel) {
        PolylineOptions polylineOptions = new PolylineOptions();
        ArrayList arrayList = new ArrayList();
        parcel.readTypedList(arrayList, LatLng.CREATOR);
        float f10 = parcel.readFloat();
        int i10 = parcel.readInt();
        int i11 = parcel.readInt();
        float f11 = parcel.readFloat();
        float f12 = parcel.readFloat();
        polylineOptions.f17232a = parcel.readString();
        polylineOptions.lineCapType(PolylineOptions.LineCapType.valueOf(parcel.readInt()));
        polylineOptions.lineJoinType(PolylineOptions.LineJoinType.valueOf(parcel.readInt()));
        boolean[] zArr = new boolean[5];
        parcel.readBooleanArray(zArr);
        polylineOptions.addAll(arrayList);
        polylineOptions.width(f10);
        polylineOptions.color(i10);
        polylineOptions.setDottedLineType(i11);
        polylineOptions.zIndex(f11);
        polylineOptions.transparency(f12);
        polylineOptions.visible(zArr[0]);
        polylineOptions.setDottedLine(zArr[1]);
        polylineOptions.geodesic(zArr[2]);
        parcel.readArrayList(BitmapDescriptor.class.getClassLoader());
        parcel.readArrayList(Integer.class.getClassLoader());
        polylineOptions.colorValues(parcel.readArrayList(Integer.class.getClassLoader()));
        return polylineOptions;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public PolylineOptions[] newArray(int i10) {
        return new PolylineOptions[i10];
    }
}
