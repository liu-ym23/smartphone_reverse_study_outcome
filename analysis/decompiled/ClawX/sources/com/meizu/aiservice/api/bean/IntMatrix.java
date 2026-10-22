package com.meizu.aiservice.api.bean;

import android.os.Parcel;
import android.os.Parcelable;
import b.a;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@a
/* loaded from: classes.dex */
public class IntMatrix implements Parcelable {
    public static final Parcelable.Creator<IntMatrix> CREATOR = new a3.a(3);
    private final int[][] matrix;

    public IntMatrix(int[][] iArr) {
        this.matrix = iArr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int[][] getMatrix() {
        return this.matrix;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i8) {
        parcel.writeInt(this.matrix.length);
        for (int[] iArr : this.matrix) {
            parcel.writeInt(iArr.length);
            parcel.writeIntArray(iArr);
        }
    }

    public IntMatrix(Parcel parcel) {
        int i8 = parcel.readInt();
        this.matrix = new int[i8][];
        for (int i9 = 0; i9 < i8; i9++) {
            int[] iArr = new int[parcel.readInt()];
            this.matrix[i9] = iArr;
            parcel.readIntArray(iArr);
        }
    }
}
