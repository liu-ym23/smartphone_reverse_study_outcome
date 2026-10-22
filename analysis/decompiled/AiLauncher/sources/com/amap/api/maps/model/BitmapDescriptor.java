package com.amap.api.maps.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.jmsl.C1570k;
import com.amap.api.col.jmsl.C1624x2;
import com.amap.api.col.jmsl.G1;

/* loaded from: classes.dex */
public final class BitmapDescriptor implements Parcelable, Cloneable {
    public static final BitmapDescriptorCreator CREATOR = new BitmapDescriptorCreator();
    public static String INVALID_ID = "INVALID_ID";

    /* renamed from: a, reason: collision with root package name */
    int f17220a;

    /* renamed from: b, reason: collision with root package name */
    int f17221b;

    /* renamed from: c, reason: collision with root package name */
    Bitmap f17222c;
    private String mId;

    public BitmapDescriptor(Bitmap bitmap, String str) {
        this.f17220a = 0;
        this.f17221b = 0;
        if (bitmap != null) {
            try {
                this.f17220a = bitmap.getWidth();
                this.f17221b = bitmap.getHeight();
                if (bitmap.getConfig() == null) {
                    this.f17222c = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                } else {
                    this.f17222c = bitmap.copy(bitmap.getConfig(), true);
                }
            } catch (Throwable th) {
                C1570k.j(th);
                return;
            }
        }
        this.mId = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        BitmapDescriptor bitmapDescriptor;
        Bitmap bitmap;
        Bitmap bitmap2 = this.f17222c;
        if (bitmap2 == null || bitmap2.isRecycled() || obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (BitmapDescriptor.class == obj.getClass() && (bitmap = (bitmapDescriptor = (BitmapDescriptor) obj).f17222c) != null && !bitmap.isRecycled() && this.f17220a == bitmapDescriptor.getWidth() && this.f17221b == bitmapDescriptor.getHeight()) {
            try {
                return this.f17222c.sameAs(bitmapDescriptor.f17222c);
            } catch (Throwable th) {
                C1570k.j(th);
            }
        }
        return false;
    }

    public Bitmap getBitmap() {
        return this.f17222c;
    }

    public int getHeight() {
        return this.f17221b;
    }

    public String getId() {
        return this.mId;
    }

    public int getWidth() {
        return this.f17220a;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public void recycle() {
        try {
            C1570k.f(this.f17222c);
        } catch (Throwable th) {
            C1570k.j(th);
        }
    }

    public String toString() {
        return C1624x2.f(this.mId, this.f17220a / G1.a(), this.f17221b / G1.a());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.mId);
        parcel.writeParcelable(this.f17222c, i10);
        parcel.writeInt(this.f17220a);
        parcel.writeInt(this.f17221b);
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public BitmapDescriptor m11clone() {
        try {
            Bitmap bitmap = this.f17222c;
            return new BitmapDescriptor(bitmap.copy(bitmap.getConfig(), true), this.f17220a, this.f17221b, this.mId);
        } catch (Throwable th) {
            th.printStackTrace();
            C1570k.j(th);
            return null;
        }
    }

    private BitmapDescriptor(Bitmap bitmap, int i10, int i11, String str) {
        this.f17220a = i10;
        this.f17221b = i11;
        this.f17222c = bitmap;
        this.mId = str;
    }
}
