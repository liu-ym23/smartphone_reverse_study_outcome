package com.amap.api.maps.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.mapcore.util.w3;
import com.autonavi.base.ae.gmap.maploader.Pools;

/* JADX INFO: loaded from: classes28.dex */
public final class Tile implements Parcelable {
    public static final b CREATOR = null;
    private static final Pools.SynchronizedPool<Tile> M_POOL = null;
    private BitmapDescriptor bitmapDescriptor;
    public final byte[] data;
    public final int height;
    private final boolean isBitmap;
    private final int mVersionCode;
    public final int width;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new b();
        M_POOL = new Pools.SynchronizedPool(18);
    }

    public void recycle() {
        M_POOL.release(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.mVersionCode);
        r100.writeInt(this.width);
        r100.writeInt(this.height);
        r100.writeByteArray(this.data);
        r100.writeInt(this.isBitmap ? 1 : 0);
    }

    public Tile(int r100, int r101, byte[] r102) {
        this(1, r100, r101, r102, true);
    }

    public static Tile obtain(int r100, int r101, byte[] r102) {
        Tile r103 = M_POOL.acquire();
        if (r103 == null) goto L6;
        return r103;
    L6:
        return new Tile(r100, r101, r102);
    }

    public Tile(int r100, int r101, byte[] r102, boolean r110) {
        this(1, r100, r101, r102, r110);
    }

    public Tile(int r100, int r101, int r102, byte[] r103, boolean r104) {
        this.mVersionCode = r100;
        this.width = r101;
        this.height = r102;
        this.data = r103;
        if (r103 != null) goto L10;
    L8:
        this.isBitmap = r104;
        return;
    L10:
        Bitmap r105 = BitmapFactory.decodeByteArray(r103, 0, r103.length);     // Catch: Throwable -> L6
        this.bitmapDescriptor = BitmapDescriptorFactory.fromBitmap(r105);     // Catch: Throwable -> L6
        w3.a(r105);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        th.printStackTrace();
        goto L8
    }
}
