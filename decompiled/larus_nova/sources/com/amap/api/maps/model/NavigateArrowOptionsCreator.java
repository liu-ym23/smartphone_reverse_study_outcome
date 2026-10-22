package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes28.dex */
public class NavigateArrowOptionsCreator implements Parcelable.Creator<NavigateArrowOptions> {
    public NavigateArrowOptionsCreator() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public NavigateArrowOptions createFromParcel(Parcel r110) {
        NavigateArrowOptions r100 = new NavigateArrowOptions();
        ArrayList r101 = new ArrayList();
        r110.readTypedList(r101, LatLng.CREATOR);
        float r102 = r110.readFloat();
        int r103 = r110.readInt();
        int r104 = r110.readInt();
        float r105 = r110.readFloat();
        boolean r106 = false;
        if (r110.readByte() != 1) goto L5;
        boolean r107 = true;
    L7:
        if (r110.readByte() != 1) goto L9;
        r106 = true;
    L9:
        r100.addAll(r101);
        r100.width(r102);
        r100.topColor(r103);
        r100.sideColor(r104);
        r100.zIndex(r105);
        r100.visible(r107);
        r100.f28661a = r110.readString();
        r100.set3DModel(r106);
        return r100;
    L5:
        r107 = false;
        goto L7
    }

    @Override // android.os.Parcelable.Creator
    public /* bridge */ /* synthetic */ NavigateArrowOptions[] newArray(int r100) {
        return newArray(r100);
    }

    @Override // android.os.Parcelable.Creator
    public /* bridge */ /* synthetic */ NavigateArrowOptions createFromParcel(Parcel r100) {
        return createFromParcel(r100);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public NavigateArrowOptions[] newArray(int r100) {
        return new NavigateArrowOptions[r100];
    }
}
