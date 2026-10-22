package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ParcelableSparseIntArray extends SparseIntArray implements Parcelable {
    public static final Parcelable.Creator<ParcelableSparseIntArray> CREATOR = null;

    static {
        CREATOR = new AnonymousClass1();
    }

    public ParcelableSparseIntArray() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel r10, int r11) {
        int[] r12 = new int[size()];
        int[] r13 = new int[size()];
        int r14 = 0;
    L4:
        if (r14 >= size()) goto L6;
        r12[r14] = keyAt(r14);
        r13[r14] = valueAt(r14);
        r14 = r14 + 1;
        goto L4
    L6:
        r10.writeInt(size());
        r10.writeIntArray(r12);
        r10.writeIntArray(r13);
    }

    public ParcelableSparseIntArray(int r10) {
        super(r10);
    }

    public ParcelableSparseIntArray(@NonNull SparseIntArray r10) {
        int r11 = 0;
    L4:
        if (r11 >= r10.size()) goto L6;
        put(r10.keyAt(r11), r10.valueAt(r11));
        r11 = r11 + 1;
        goto L4
    }
}
