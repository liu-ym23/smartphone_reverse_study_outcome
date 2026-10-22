package com.amap.api.maps.model;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.platform.comapi.map.MapBundleKey;

/* JADX INFO: loaded from: classes28.dex */
public class TextOptionsCreator implements Parcelable.Creator<TextOptions> {
    public TextOptionsCreator() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public TextOptions createFromParcel(Parcel r100) {
        TextOptions r101 = new TextOptions();
        r101.f28664a = r100.readString();
        Bundle r102 = r100.readBundle();
        r101.position(new LatLng(r102.getDouble("lat"), r102.getDouble("lng")));
        r101.text(r100.readString());
        r101.typeface(Typeface.defaultFromStyle(r100.readInt()));
        r101.rotate(r100.readFloat());
        r101.align(r100.readInt(), r100.readInt());
        r101.backgroundColor(r100.readInt());
        r101.fontColor(r100.readInt());
        r101.fontSize(r100.readInt());
        r101.zIndex(r100.readFloat());
        boolean r103 = true;
        if (r100.readByte() == 1) goto L6;
        r103 = false;
    L6:
        r101.visible(r103);
        Parcelable r104 = r100.readBundle().getParcelable(MapBundleKey.MapObjKey.OBJ_SL_OBJ);     // Catch: Throwable -> L11
        if (r104 == null) goto L13;
        r101.setObject(r104);     // Catch: Throwable -> L11
    L13:
        return r101;
    L11:
        th = move-exception;
        th.printStackTrace();
        goto L13
    }

    @Override // android.os.Parcelable.Creator
    public /* bridge */ /* synthetic */ TextOptions[] newArray(int r100) {
        return newArray(r100);
    }

    @Override // android.os.Parcelable.Creator
    public /* bridge */ /* synthetic */ TextOptions createFromParcel(Parcel r100) {
        return createFromParcel(r100);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public TextOptions[] newArray(int r100) {
        return new TextOptions[r100];
    }
}
