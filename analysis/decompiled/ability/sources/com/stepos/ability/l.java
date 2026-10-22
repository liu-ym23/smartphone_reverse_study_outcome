package com.stepos.ability;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.core.json.ByteSourceJsonBootstrapper;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f3100a = {65, 28, 31, -46, 51, 24, -29, -63, 94, -36, 32, 125, -21, 108, 4, 50, 52, -84, -26, -39, -77, 119, -53, -98, 54, -120, 64, -106, 43, -36, 5, 66, 42, 112, -79, -91, 9, 124, 0, 13, 89, 7, -12, 125, -89, ByteSourceJsonBootstrapper.UTF8_BOM_1, -109, ByteSourceJsonBootstrapper.UTF8_BOM_2, -83, -52, 120, -79, -128, 61, 81, 20, -106, -119, -104, -92};

    public static Object a(Parcel parcel) {
        Parcelable.Creator creator = Bundle.CREATOR;
        if (parcel.readInt() != 0) {
            return creator.createFromParcel(parcel);
        }
        return null;
    }

    public static Object b(Parcel parcel, Parcelable.Creator creator) {
        if (parcel.readInt() != 0) {
            return creator.createFromParcel(parcel);
        }
        return null;
    }

    public static void c(Parcel parcel, List list, int i) {
        if (list == null) {
            parcel.writeInt(-1);
            return;
        }
        int size = list.size();
        parcel.writeInt(size);
        for (int i6 = 0; i6 < size; i6++) {
            e(parcel, (Parcelable) list.get(i6), i);
        }
    }

    public static void d(Parcel parcel, Bundle bundle, int i) {
        if (bundle == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, i);
        }
    }

    public static void e(Parcel parcel, Parcelable parcelable, int i) {
        if (parcelable == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, i);
        }
    }
}
