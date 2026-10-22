package com.google.android.gms.common.server.response;

import a1.C0154a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.stepos.statsrpk.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import s.AbstractC0831a;
import t0.J;

@ShowFirstParty
@SafeParcelable.Class(creator = "FieldMappingDictionaryCreator")
/* loaded from: classes.dex */
public final class zan extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zan> CREATOR = new C0154a(23);

    /* renamed from: a, reason: collision with root package name */
    public final int f9929a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f9930b;

    /* renamed from: c, reason: collision with root package name */
    public final String f9931c;

    public zan(int i4, String str, ArrayList arrayList) {
        this.f9929a = i4;
        HashMap map = new HashMap();
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            zal zalVar = (zal) arrayList.get(i5);
            String str2 = zalVar.f9924b;
            HashMap map2 = new HashMap();
            ArrayList arrayList2 = zalVar.f9925c;
            c.l(arrayList2);
            int size2 = arrayList2.size();
            for (int i6 = 0; i6 < size2; i6++) {
                zam zamVar = (zam) arrayList2.get(i6);
                map2.put(zamVar.f9927b, zamVar.f9928c);
            }
            map.put(str2, map2);
        }
        this.f9930b = map;
        c.l(str);
        this.f9931c = str;
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            Map map3 = (Map) map.get((String) it.next());
            Iterator it2 = map3.keySet().iterator();
            while (it2.hasNext()) {
                ((FastJsonResponse$Field) map3.get((String) it2.next())).f9914j = this;
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        HashMap map = this.f9930b;
        for (String str : map.keySet()) {
            sb.append(str);
            sb.append(":\n");
            Map map2 = (Map) map.get(str);
            for (String str2 : map2.keySet()) {
                AbstractC0831a.h(sb, "  ", str2, ": ");
                sb.append(map2.get(str2));
            }
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.c0(parcel, 1, 4);
        parcel.writeInt(this.f9929a);
        ArrayList arrayList = new ArrayList();
        HashMap map = this.f9930b;
        for (String str : map.keySet()) {
            arrayList.add(new zal(str, (Map) map.get(str)));
        }
        J.W(parcel, 2, arrayList);
        J.U(parcel, 3, this.f9931c);
        J.b0(parcel, iZ);
    }
}
