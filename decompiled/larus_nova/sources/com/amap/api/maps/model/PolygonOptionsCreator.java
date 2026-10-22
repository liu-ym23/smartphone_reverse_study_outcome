package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes28.dex */
public class PolygonOptionsCreator implements Parcelable.Creator<PolygonOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    public PolygonOptionsCreator() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public PolygonOptions createFromParcel(Parcel r110) {
        PolygonOptions r100 = new PolygonOptions();
        ArrayList r101 = new ArrayList();
        r110.readTypedList(r101, LatLng.CREATOR);
        float r102 = r110.readFloat();
        int r103 = r110.readInt();
        int r104 = r110.readInt();
        float r105 = r110.readFloat();
        boolean r106 = false;
        if (r110.readByte() != 1) goto L5;
        boolean r107 = true;
    L6:
        LatLng[] r108 = new LatLng[r101.size()];
        int r111 = 0;
    L8:
        if (r111 >= r101.size()) goto L10;
        r108[r111] = (LatLng) ListProtector.get(r101, r111);
        r111 = r111 + 1;
        goto L8
    L10:
        r100.add(r108);
        r100.strokeWidth(r102);
        r100.strokeColor(r103);
        r100.fillColor(r104);
        r100.zIndex(r105);
        r100.visible(r107);
        r100.f28662a = r110.readString();
        ArrayList r109 = new ArrayList();
        r110.readList(r109, BaseHoleOptions.class.getClassLoader());
        r100.addHoles(r109);
        r100.lineJoinType(AMapPara.LineJoinType.valueOf(r110.readInt()));
        r100.setStrokeDottedLineType(r110.readInt());
        if (r110.readByte() != 1) goto L13;
        r106 = true;
    L13:
        r100.usePolylineStroke(r106);
        return r100;
    L5:
        r107 = false;
        goto L6
    }

    @Override // android.os.Parcelable.Creator
    public /* bridge */ /* synthetic */ PolygonOptions[] newArray(int r100) {
        return newArray(r100);
    }

    @Override // android.os.Parcelable.Creator
    public /* bridge */ /* synthetic */ PolygonOptions createFromParcel(Parcel r100) {
        return createFromParcel(r100);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public PolygonOptions[] newArray(int r100) {
        return new PolygonOptions[r100];
    }
}
