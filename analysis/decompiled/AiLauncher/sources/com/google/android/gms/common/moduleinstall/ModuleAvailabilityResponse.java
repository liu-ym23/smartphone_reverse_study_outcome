package com.google.android.gms.common.moduleinstall;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p2.C5047a;
import q2.e;

/* loaded from: classes2.dex */
public class ModuleAvailabilityResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ModuleAvailabilityResponse> CREATOR = new e();
    private final boolean zaa;
    private final int zab;

    public ModuleAvailabilityResponse(boolean z10, int i10) {
        this.zaa = z10;
        this.zab = i10;
    }

    public boolean areModulesAvailable() {
        return this.zaa;
    }

    public int getAvailabilityStatus() {
        return this.zab;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = C5047a.a(parcel);
        C5047a.g(parcel, 1, areModulesAvailable());
        C5047a.p(parcel, 2, getAvailabilityStatus());
        C5047a.b(parcel, iA);
    }
}
