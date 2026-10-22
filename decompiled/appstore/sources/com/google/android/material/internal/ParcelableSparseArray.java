package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ParcelableSparseArray extends SparseArray<Parcelable> implements Parcelable {
    public static final Parcelable.Creator<ParcelableSparseArray> CREATOR = null;

    static {
        CREATOR = new AnonymousClass1();
    }

    public ParcelableSparseArray() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel r10, int r11) {
        int r12 = size();
        int[] r13 = new int[r12];
        Parcelable[] r14 = new Parcelable[r12];
        int r15 = 0;
    L3:
        if (r15 >= r12) goto L5;
        r13[r15] = keyAt(r15);
        r14[r15] = valueAt(r15);
        r15 = r15 + 1;
        goto L3
    L5:
        r10.writeInt(r12);
        r10.writeIntArray(r13);
        r10.writeParcelableArray(r14, r11);
    }

    public ParcelableSparseArray(@NonNull Parcel r10, @Nullable ClassLoader r11) {
        int r12 = r10.readInt();
        int[] r13 = new int[r12];
        r10.readIntArray(r13);
        Parcelable[] r14 = r10.readParcelableArray(r11);
        int r15 = 0;
    L3:
        if (r15 >= r12) goto L5;
        put(r13[r15], r14[r15]);
        r15 = r15 + 1;
        goto L3
    }
}
