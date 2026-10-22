package com.meizu.aiservice.api.bean;

import android.os.Parcel;
import android.os.Parcelable;
import b.a;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@a
/* loaded from: classes.dex */
public class FloatMatrix implements Parcelable {
    public static final Parcelable.Creator<FloatMatrix> CREATOR = new a3.a(1);
    private final float[][] matrix;

    public FloatMatrix(float[][] fArr) {
        this.matrix = fArr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float[][] getMatrix() {
        return this.matrix;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i8) {
        parcel.writeInt(this.matrix.length);
        for (float[] fArr : this.matrix) {
            parcel.writeInt(fArr.length);
            parcel.writeFloatArray(fArr);
        }
    }

    public FloatMatrix(Parcel parcel) {
        int i8 = parcel.readInt();
        this.matrix = new float[i8][];
        for (int i9 = 0; i9 < i8; i9++) {
            float[] fArr = new float[parcel.readInt()];
            this.matrix[i9] = fArr;
            parcel.readFloatArray(fArr);
        }
    }
}
