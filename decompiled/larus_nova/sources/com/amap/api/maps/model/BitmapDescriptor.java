package com.amap.api.maps.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.mapcore.util.w3;

/* JADX INFO: loaded from: classes28.dex */
public final class BitmapDescriptor implements Parcelable, Cloneable {
    public static final BitmapDescriptorCreator CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f28644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f28645b;
    protected Object mBitmap;
    private String mId;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new BitmapDescriptorCreator();
    }

    public BitmapDescriptor clone() {
        Object r100 = this.mBitmap;     // Catch: Throwable -> L4
        return new BitmapDescriptor(((Bitmap) r100).copy(((Bitmap) r100).getConfig(), true), this.f28644a, this.f28645b, this.mId);
    L4:
        th = move-exception;
        th.printStackTrace();
        w3.a(th);
        return null;
    }

    public Bitmap getBitmap() {
        return (Bitmap) this.mBitmap;
    }

    public void recycle() {
        w3.a((Bitmap) this.mBitmap);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        w3.a(th);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public int getHeight() {
        return this.f28645b;
    }

    public String getId() {
        return this.mId;
    }

    public int getWidth() {
        return this.f28644a;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8022clone() throws CloneNotSupportedException {
        return clone();
    }

    public boolean equals(Object r100) {
        Object r101 = this.mBitmap;
        if (r101 != null) goto L5;
    L29:
        return false;
    L5:
        if (((Bitmap) r101).isRecycled() == true) goto L29;
        if (r100 != null) goto L9;
        return false;
    L9:
        if (this != r100) goto L13;
        return true;
    L13:
        if (BitmapDescriptor.class == r100.getClass()) goto L15;
        return false;
    L15:
        BitmapDescriptor r102 = (BitmapDescriptor) r100;
        Object r103 = r102.mBitmap;
        if (r103 == null) goto L29;
        if (((Bitmap) r103).isRecycled() == true) goto L29;
        if (this.f28644a != r102.getWidth()) goto L29;
        if (this.f28645b != r102.getHeight()) goto L29;
        return ((Bitmap) this.mBitmap).sameAs((Bitmap) r102.mBitmap);
    L27:
        th = move-exception;
        w3.a(th);
        goto L29
    }

    public BitmapDescriptor(Bitmap r100, String r101) {
        this.f28644a = 0;
        this.f28645b = 0;
        if (r100 != null) goto L13;
    L8:
        this.mId = r101;     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        w3.a(th);
        return;
    L13:
        this.f28644a = r100.getWidth();     // Catch: Throwable -> L10
        this.f28645b = r100.getHeight();     // Catch: Throwable -> L10
        if (r100.getConfig() != null) goto L7;
        this.mBitmap = r100.copy(Bitmap.Config.ARGB_8888, true);     // Catch: Throwable -> L10
        goto L8
    L7:
        this.mBitmap = r100.copy(r100.getConfig(), true);     // Catch: Throwable -> L10
        goto L8
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.mId);
        r100.writeParcelable((Bitmap) this.mBitmap, r101);
        r100.writeInt(this.f28644a);
        r100.writeInt(this.f28645b);
    }

    private BitmapDescriptor(Bitmap r100, int r101, int r102, String r103) {
        this.f28644a = r101;
        this.f28645b = r102;
        this.mBitmap = r100;
        this.mId = r103;
    }
}
