package com.bytedance.common.wschannel.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class IntegerParcelable implements Parcelable {
    public static final Parcelable.Creator<IntegerParcelable> CREATOR = null;
    private final int mData;

    public static class a implements Parcelable.Creator {
        public a() {
        }

        public IntegerParcelable a(Parcel r10) {
            return new IntegerParcelable(r10);
        }

        public IntegerParcelable[] b(int r10) {
            return new IntegerParcelable[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object[] newArray(int r10) {
            return b(r10);
        }
    }

    static {
        CREATOR = new a();
    }

    public IntegerParcelable(int r10) {
        this.mData = r10;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getData() {
        return this.mData;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        r10.writeInt(this.mData);
    }

    public IntegerParcelable(Parcel r10) {
        this.mData = r10.readInt();
    }
}
