package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.stepos.alphame.utils.Property;
import java.util.ArrayList;
import java.util.List;
import t0.J;

@SafeParcelable.Class(creator = "PolylineOptionsCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class PolylineOptions extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<PolylineOptions> CREATOR = new c(13);

    /* renamed from: a, reason: collision with root package name */
    public final List f10202a;

    /* renamed from: b, reason: collision with root package name */
    public final float f10203b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10204c;

    /* renamed from: d, reason: collision with root package name */
    public final float f10205d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f10206e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f10207f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f10208g;

    /* renamed from: h, reason: collision with root package name */
    public final Cap f10209h;

    /* renamed from: i, reason: collision with root package name */
    public final Cap f10210i;

    /* renamed from: j, reason: collision with root package name */
    public final int f10211j;

    /* renamed from: k, reason: collision with root package name */
    public final List f10212k;

    /* renamed from: l, reason: collision with root package name */
    public final List f10213l;

    public PolylineOptions(ArrayList arrayList, float f4, int i4, float f5, boolean z4, boolean z5, boolean z6, Cap cap, Cap cap2, int i5, ArrayList arrayList2, ArrayList arrayList3) {
        this.f10203b = 10.0f;
        this.f10204c = -16777216;
        this.f10205d = Property.DEFAULT_FLOAT_VALUE;
        this.f10206e = true;
        this.f10207f = false;
        this.f10208g = false;
        this.f10209h = new ButtCap();
        this.f10210i = new ButtCap();
        this.f10211j = 0;
        this.f10212k = null;
        this.f10213l = new ArrayList();
        this.f10202a = arrayList;
        this.f10203b = f4;
        this.f10204c = i4;
        this.f10205d = f5;
        this.f10206e = z4;
        this.f10207f = z5;
        this.f10208g = z6;
        if (cap != null) {
            this.f10209h = cap;
        }
        if (cap2 != null) {
            this.f10210i = cap2;
        }
        this.f10211j = i5;
        this.f10212k = arrayList2;
        if (arrayList3 != null) {
            this.f10213l = arrayList3;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.W(parcel, 2, this.f10202a);
        J.c0(parcel, 3, 4);
        parcel.writeFloat(this.f10203b);
        J.c0(parcel, 4, 4);
        parcel.writeInt(this.f10204c);
        J.c0(parcel, 5, 4);
        parcel.writeFloat(this.f10205d);
        J.c0(parcel, 6, 4);
        parcel.writeInt(this.f10206e ? 1 : 0);
        J.c0(parcel, 7, 4);
        parcel.writeInt(this.f10207f ? 1 : 0);
        J.c0(parcel, 8, 4);
        parcel.writeInt(this.f10208g ? 1 : 0);
        J.T(parcel, 9, this.f10209h.N(), i4);
        J.T(parcel, 10, this.f10210i.N(), i4);
        J.c0(parcel, 11, 4);
        parcel.writeInt(this.f10211j);
        J.W(parcel, 12, this.f10212k);
        List<StyleSpan> list = this.f10213l;
        ArrayList arrayList = new ArrayList(list.size());
        for (StyleSpan styleSpan : list) {
            StrokeStyle strokeStyle = styleSpan.f10232a;
            float f4 = strokeStyle.f10227a;
            Pair pair = new Pair(Integer.valueOf(strokeStyle.f10228b), Integer.valueOf(strokeStyle.f10229c));
            arrayList.add(new StyleSpan(new StrokeStyle(this.f10203b, ((Integer) pair.first).intValue(), ((Integer) pair.second).intValue(), this.f10206e, strokeStyle.f10231e), styleSpan.f10233b));
        }
        J.W(parcel, 13, arrayList);
        J.b0(parcel, iZ);
    }
}
