package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.C1668i;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p2.C5047a;

/* loaded from: classes2.dex */
public class Feature extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Feature> CREATOR = new j();
    private final String zza;

    @Deprecated
    private final int zzb;
    private final long zzc;

    public Feature(String str, int i10, long j10) {
        this.zza = str;
        this.zzb = i10;
        this.zzc = j10;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Feature) {
            Feature feature = (Feature) obj;
            if (((getName() != null && getName().equals(feature.getName())) || (getName() == null && feature.getName() == null)) && getVersion() == feature.getVersion()) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return this.zza;
    }

    public long getVersion() {
        long j10 = this.zzc;
        return j10 == -1 ? this.zzb : j10;
    }

    public final int hashCode() {
        return C1668i.b(getName(), Long.valueOf(getVersion()));
    }

    public final String toString() {
        C1668i.a aVarC = C1668i.c(this);
        aVarC.a("name", getName());
        aVarC.a("version", Long.valueOf(getVersion()));
        return aVarC.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = C5047a.a(parcel);
        C5047a.x(parcel, 1, getName(), false);
        C5047a.p(parcel, 2, this.zzb);
        C5047a.r(parcel, 3, getVersion());
        C5047a.b(parcel, iA);
    }

    public Feature(String str, long j10) {
        this.zza = str;
        this.zzc = j10;
        this.zzb = -1;
    }
}
