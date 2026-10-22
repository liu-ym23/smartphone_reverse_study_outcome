package com.meizu.aiservice.api.bean;

import android.os.Parcel;
import android.os.Parcelable;
import b.a;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@a
/* loaded from: classes.dex */
public class OpenCVHierarchy implements Parcelable {
    public static final Parcelable.Creator<OpenCVHierarchy> CREATOR = new a3.a(4);
    public final int firstChild;
    public final int next;
    public final int parent;
    public final int previous;

    public OpenCVHierarchy(int i8, int i9, int i10, int i11) {
        this.next = i8;
        this.previous = i9;
        this.firstChild = i10;
        this.parent = i11;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i8) {
        parcel.writeInt(this.next);
        parcel.writeInt(this.previous);
        parcel.writeInt(this.firstChild);
        parcel.writeInt(this.parent);
    }

    public OpenCVHierarchy(Parcel parcel) {
        this.next = parcel.readInt();
        this.previous = parcel.readInt();
        this.firstChild = parcel.readInt();
        this.parent = parcel.readInt();
    }
}
