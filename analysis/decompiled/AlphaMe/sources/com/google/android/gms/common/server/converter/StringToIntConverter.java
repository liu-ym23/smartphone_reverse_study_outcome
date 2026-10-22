package com.google.android.gms.common.server.converter;

import a1.C0154a;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.HashMap;
import t0.J;

@KeepForSdk
@SafeParcelable.Class(creator = "StringToIntConverterCreator")
/* loaded from: classes.dex */
public final class StringToIntConverter extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<StringToIntConverter> CREATOR = new C0154a(20);

    /* renamed from: a, reason: collision with root package name */
    public final int f9897a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f9898b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final SparseArray f9899c = new SparseArray();

    public StringToIntConverter(ArrayList arrayList, int i4) {
        this.f9897a = i4;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            zac zacVar = (zac) arrayList.get(i5);
            String str = zacVar.f9903b;
            int i6 = zacVar.f9904c;
            this.f9898b.put(str, Integer.valueOf(i6));
            this.f9899c.put(i6, str);
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.c0(parcel, 1, 4);
        parcel.writeInt(this.f9897a);
        ArrayList arrayList = new ArrayList();
        HashMap map = this.f9898b;
        for (String str : map.keySet()) {
            arrayList.add(new zac(str, ((Integer) map.get(str)).intValue()));
        }
        J.W(parcel, 2, arrayList);
        J.b0(parcel, iZ);
    }
}
