package com.mdisdk.capability.model;

import B7.a;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class Rect implements Parcelable {
    public static final Parcelable.Creator<Rect> CREATOR = new Parcelable.Creator<Rect>() { // from class: com.mdisdk.capability.model.Rect.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Rect createFromParcel(Parcel parcel) {
            return new Rect(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Rect[] newArray(int i) {
            return new Rect[i];
        }
    };
    private final int bottom;
    private final int left;
    private final int right;
    private final int top;

    public Rect() {
        this(0, 0, 0, 0);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Rect rect = (Rect) obj;
            if (this.left == rect.left && this.top == rect.top && this.right == rect.right && this.bottom == rect.bottom) {
                return true;
            }
        }
        return false;
    }

    public int getBottom() {
        return this.bottom;
    }

    public int getHeight() {
        return this.bottom - this.top;
    }

    public int getLeft() {
        return this.left;
    }

    public int getRight() {
        return this.right;
    }

    public int getTop() {
        return this.top;
    }

    public int getWidth() {
        return this.right - this.left;
    }

    public int hashCode() {
        return (((((this.left * 31) + this.top) * 31) + this.right) * 31) + this.bottom;
    }

    public boolean isEmpty() {
        return this.left >= this.right || this.top >= this.bottom;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Rect{left=");
        sb.append(this.left);
        sb.append(", top=");
        sb.append(this.top);
        sb.append(", right=");
        sb.append(this.right);
        sb.append(", bottom=");
        return a.o(sb, this.bottom, '}');
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.left);
        parcel.writeInt(this.top);
        parcel.writeInt(this.right);
        parcel.writeInt(this.bottom);
    }

    public Rect(int i, int i6, int i10, int i11) {
        this.left = i;
        this.top = i6;
        this.right = i10;
        this.bottom = i11;
    }

    public Rect(Parcel parcel) {
        this.left = parcel.readInt();
        this.top = parcel.readInt();
        this.right = parcel.readInt();
        this.bottom = parcel.readInt();
    }
}
