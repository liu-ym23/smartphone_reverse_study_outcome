package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes28.dex */
public class TileOverlayOptionsCreator implements Parcelable.Creator<TileOverlayOptions> {
    public static final int CONTENT_DESCRIPTION = 0;

    public TileOverlayOptionsCreator() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public TileOverlayOptions createFromParcel(Parcel r110) {
        int r100 = r110.readInt();
        TileProvider r101 = (TileProvider) r110.readValue(TileProvider.class.getClassLoader());
        boolean r102 = true;
        if (r110.readByte() == 0) goto L5;
        boolean r103 = true;
    L6:
        float r104 = r110.readFloat();
        int r105 = r110.readInt();
        int r106 = r110.readInt();
        String r107 = r110.readString();
        if (r110.readByte() == 0) goto L9;
        boolean r108 = true;
    L11:
        if (r110.readByte() != 0) goto L14;
        r102 = false;
    L14:
        TileOverlayOptions r111 = new TileOverlayOptions(r100, r103, r104);
        if (r101 == null) goto L17;
        r111.tileProvider(r101);
    L17:
        r111.memCacheSize(r105);
        r111.diskCacheSize(r106);
        r111.diskCacheDir(r107);
        r111.memoryCacheEnabled(r108);
        r111.diskCacheEnabled(r102);
        return r111;
    L9:
        r108 = false;
        goto L11
    L5:
        r103 = false;
        goto L6
    }

    @Override // android.os.Parcelable.Creator
    public /* bridge */ /* synthetic */ TileOverlayOptions[] newArray(int r100) {
        return newArray(r100);
    }

    @Override // android.os.Parcelable.Creator
    public /* bridge */ /* synthetic */ TileOverlayOptions createFromParcel(Parcel r100) {
        return createFromParcel(r100);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public TileOverlayOptions[] newArray(int r100) {
        return new TileOverlayOptions[r100];
    }
}
