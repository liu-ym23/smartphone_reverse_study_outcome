package com.google.android.gms.common.server.response;

import a1.C0154a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Map;
import t0.J;

@ShowFirstParty
@SafeParcelable.Class(creator = "FieldMappingDictionaryEntryCreator")
/* loaded from: classes.dex */
public final class zal extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zal> CREATOR = new C0154a(24);

    /* renamed from: a, reason: collision with root package name */
    public final int f9923a;

    /* renamed from: b, reason: collision with root package name */
    public final String f9924b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f9925c;

    public zal(int i4, String str, ArrayList arrayList) {
        this.f9923a = i4;
        this.f9924b = str;
        this.f9925c = arrayList;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.c0(parcel, 1, 4);
        parcel.writeInt(this.f9923a);
        J.U(parcel, 2, this.f9924b);
        J.W(parcel, 3, this.f9925c);
        J.b0(parcel, iZ);
    }

    public zal(String str, Map map) {
        ArrayList arrayList;
        this.f9923a = 1;
        this.f9924b = str;
        if (map == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (String str2 : map.keySet()) {
                arrayList.add(new zam(str2, (FastJsonResponse$Field) map.get(str2)));
            }
        }
        this.f9925c = arrayList;
    }
}
