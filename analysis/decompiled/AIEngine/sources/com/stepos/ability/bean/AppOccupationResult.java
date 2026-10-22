package com.stepos.ability.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.g;
import v1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AppOccupationResult implements Parcelable {
    public static final Parcelable.Creator<AppOccupationResult> CREATOR = new a();
    private final boolean occupied;
    private final String occupierTaskId;
    private final String packageName;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements Parcelable.Creator<AppOccupationResult> {
        @Override // android.os.Parcelable.Creator
        public final AppOccupationResult createFromParcel(Parcel parcel) {
            g.f(parcel, "parcel");
            return new AppOccupationResult(parcel.readInt() != 0, parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final AppOccupationResult[] newArray(int i10) {
            return new AppOccupationResult[i10];
        }
    }

    public AppOccupationResult(boolean z, String occupierTaskId, String packageName) {
        g.f(occupierTaskId, "occupierTaskId");
        g.f(packageName, "packageName");
        this.occupied = z;
        this.occupierTaskId = occupierTaskId;
        this.packageName = packageName;
    }

    public static /* synthetic */ AppOccupationResult copy$default(AppOccupationResult appOccupationResult, boolean z, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z = appOccupationResult.occupied;
        }
        if ((i10 & 2) != 0) {
            str = appOccupationResult.occupierTaskId;
        }
        if ((i10 & 4) != 0) {
            str2 = appOccupationResult.packageName;
        }
        return appOccupationResult.copy(z, str, str2);
    }

    public final boolean component1() {
        return this.occupied;
    }

    public final String component2() {
        return this.occupierTaskId;
    }

    public final String component3() {
        return this.packageName;
    }

    public final AppOccupationResult copy(boolean z, String occupierTaskId, String packageName) {
        g.f(occupierTaskId, "occupierTaskId");
        g.f(packageName, "packageName");
        return new AppOccupationResult(z, occupierTaskId, packageName);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppOccupationResult)) {
            return false;
        }
        AppOccupationResult appOccupationResult = (AppOccupationResult) obj;
        return this.occupied == appOccupationResult.occupied && g.b(this.occupierTaskId, appOccupationResult.occupierTaskId) && g.b(this.packageName, appOccupationResult.packageName);
    }

    public final boolean getOccupied() {
        return this.occupied;
    }

    public final String getOccupierTaskId() {
        return this.occupierTaskId;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public int hashCode() {
        return this.packageName.hashCode() + d.a(Boolean.hashCode(this.occupied) * 31, 31, this.occupierTaskId);
    }

    public String toString() {
        boolean z = this.occupied;
        String str = this.occupierTaskId;
        String str2 = this.packageName;
        StringBuilder sb2 = new StringBuilder("AppOccupationResult(occupied=");
        sb2.append(z);
        sb2.append(", occupierTaskId=");
        sb2.append(str);
        sb2.append(", packageName=");
        return ai.onnxruntime.a.o(sb2, str2, ")");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i10) {
        g.f(dest, "dest");
        dest.writeInt(this.occupied ? 1 : 0);
        dest.writeString(this.occupierTaskId);
        dest.writeString(this.packageName);
    }
}
