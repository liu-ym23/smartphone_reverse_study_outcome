package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;
import t0.J;

@SafeParcelable.Class(creator = "PolygonOptionsCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class PolygonOptions extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<PolygonOptions> CREATOR = new c(12);

    /* renamed from: a, reason: collision with root package name */
    public final List f10191a;

    /* renamed from: b, reason: collision with root package name */
    public final List f10192b;

    /* renamed from: c, reason: collision with root package name */
    public final float f10193c;

    /* renamed from: d, reason: collision with root package name */
    public final int f10194d;

    /* renamed from: e, reason: collision with root package name */
    public final int f10195e;

    /* renamed from: f, reason: collision with root package name */
    public final float f10196f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f10197g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f10198h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f10199i;

    /* renamed from: j, reason: collision with root package name */
    public final int f10200j;

    /* renamed from: k, reason: collision with root package name */
    public final List f10201k;

    public PolygonOptions(ArrayList arrayList, ArrayList arrayList2, float f4, int i4, int i5, float f5, boolean z4, boolean z5, boolean z6, int i6, ArrayList arrayList3) {
        this.f10191a = arrayList;
        this.f10192b = arrayList2;
        this.f10193c = f4;
        this.f10194d = i4;
        this.f10195e = i5;
        this.f10196f = f5;
        this.f10197g = z4;
        this.f10198h = z5;
        this.f10199i = z6;
        this.f10200j = i6;
        this.f10201k = arrayList3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.W(parcel, 2, this.f10191a);
        List list = this.f10192b;
        if (list != null) {
            int iZ2 = J.Z(parcel, 3);
            parcel.writeList(list);
            J.b0(parcel, iZ2);
        }
        J.c0(parcel, 4, 4);
        parcel.writeFloat(this.f10193c);
        J.c0(parcel, 5, 4);
        parcel.writeInt(this.f10194d);
        J.c0(parcel, 6, 4);
        parcel.writeInt(this.f10195e);
        J.c0(parcel, 7, 4);
        parcel.writeFloat(this.f10196f);
        J.c0(parcel, 8, 4);
        parcel.writeInt(this.f10197g ? 1 : 0);
        J.c0(parcel, 9, 4);
        parcel.writeInt(this.f10198h ? 1 : 0);
        J.c0(parcel, 10, 4);
        parcel.writeInt(this.f10199i ? 1 : 0);
        J.c0(parcel, 11, 4);
        parcel.writeInt(this.f10200j);
        J.W(parcel, 12, this.f10201k);
        J.b0(parcel, iZ);
    }
}
