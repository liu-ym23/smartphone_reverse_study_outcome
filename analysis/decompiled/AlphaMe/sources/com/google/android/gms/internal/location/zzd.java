package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import androidx.room.AbstractC0351g;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.List;
import t0.J;

@SafeParcelable.Class(creator = "ClientIdentityCreator")
/* loaded from: classes.dex */
public final class zzd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzd> CREATOR = new com.google.android.gms.common.k(7);

    /* renamed from: a, reason: collision with root package name */
    public final int f9974a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9975b;

    /* renamed from: c, reason: collision with root package name */
    public final String f9976c;

    /* renamed from: d, reason: collision with root package name */
    public final String f9977d;

    /* renamed from: e, reason: collision with root package name */
    public final int f9978e;

    /* renamed from: f, reason: collision with root package name */
    public final String f9979f;

    /* renamed from: g, reason: collision with root package name */
    public final zzd f9980g;

    /* renamed from: h, reason: collision with root package name */
    public final j f9981h;

    static {
        Process.myUid();
        Process.myPid();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public zzd(int i4, int i5, String str, String str2, String str3, int i6, List list, zzd zzdVar) {
        k kVar;
        k kVar2;
        j jVar;
        this.f9974a = i4;
        this.f9975b = i5;
        this.f9976c = str;
        this.f9977d = str2;
        this.f9979f = str3;
        this.f9978e = i6;
        h hVar = j.f9970b;
        if (list instanceof g) {
            jVar = (j) ((g) list);
            jVar.getClass();
            if (jVar.e()) {
                Object[] array = jVar.toArray(g.f9965a);
                int length = array.length;
                if (length == 0) {
                    kVar2 = k.f9971e;
                    jVar = kVar2;
                } else {
                    kVar = new k(array, length);
                    jVar = kVar;
                }
            }
        } else {
            Object[] array2 = list.toArray();
            int length2 = array2.length;
            for (int i7 = 0; i7 < length2; i7++) {
                if (array2[i7] == null) {
                    throw new NullPointerException(AbstractC0351g.m("at index ", i7));
                }
            }
            if (length2 == 0) {
                kVar2 = k.f9971e;
                jVar = kVar2;
            } else {
                kVar = new k(array2, length2);
                jVar = kVar;
            }
        }
        this.f9981h = jVar;
        this.f9980g = zzdVar;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzd) {
            zzd zzdVar = (zzd) obj;
            if (this.f9974a == zzdVar.f9974a && this.f9975b == zzdVar.f9975b && this.f9978e == zzdVar.f9978e && this.f9976c.equals(zzdVar.f9976c) && J.a0(this.f9977d, zzdVar.f9977d) && J.a0(this.f9979f, zzdVar.f9979f) && J.a0(this.f9980g, zzdVar.f9980g) && this.f9981h.equals(zzdVar.f9981h)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f9974a), this.f9976c, this.f9977d, this.f9979f});
    }

    public final String toString() {
        String str = this.f9976c;
        int length = str.length() + 18;
        String str2 = this.f9977d;
        if (str2 != null) {
            length += str2.length();
        }
        StringBuilder sb = new StringBuilder(length);
        sb.append(this.f9974a);
        sb.append("/");
        sb.append(str);
        if (str2 != null) {
            sb.append("[");
            if (str2.startsWith(str)) {
                sb.append((CharSequence) str2, str.length(), str2.length());
            } else {
                sb.append(str2);
            }
            sb.append("]");
        }
        String str3 = this.f9979f;
        if (str3 != null) {
            sb.append("/");
            sb.append(Integer.toHexString(str3.hashCode()));
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.c0(parcel, 1, 4);
        parcel.writeInt(this.f9974a);
        J.c0(parcel, 2, 4);
        parcel.writeInt(this.f9975b);
        J.U(parcel, 3, this.f9976c);
        J.U(parcel, 4, this.f9977d);
        J.c0(parcel, 5, 4);
        parcel.writeInt(this.f9978e);
        J.U(parcel, 6, this.f9979f);
        J.T(parcel, 7, this.f9980g, i4);
        J.W(parcel, 8, this.f9981h);
        J.b0(parcel, iZ);
    }
}
