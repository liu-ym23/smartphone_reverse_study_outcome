package com.google.android.gms.common.moduleinstall.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.moduleinstall.ModuleAvailabilityResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallIntentResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallResponse;
import com.google.android.gms.internal.base.zab;
import w2.C5717a;

/* loaded from: classes2.dex */
public abstract class zad extends zab implements zae {
    public zad() {
        super("com.google.android.gms.common.moduleinstall.internal.IModuleInstallCallbacks");
    }

    @Override // com.google.android.gms.internal.base.zab
    public final boolean zaa(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        if (i10 == 1) {
            Status status = (Status) C5717a.a(parcel, Status.CREATOR);
            ModuleAvailabilityResponse moduleAvailabilityResponse = (ModuleAvailabilityResponse) C5717a.a(parcel, ModuleAvailabilityResponse.CREATOR);
            C5717a.b(parcel);
            zae(status, moduleAvailabilityResponse);
        } else if (i10 == 2) {
            Status status2 = (Status) C5717a.a(parcel, Status.CREATOR);
            ModuleInstallResponse moduleInstallResponse = (ModuleInstallResponse) C5717a.a(parcel, ModuleInstallResponse.CREATOR);
            C5717a.b(parcel);
            zad(status2, moduleInstallResponse);
        } else if (i10 == 3) {
            Status status3 = (Status) C5717a.a(parcel, Status.CREATOR);
            ModuleInstallIntentResponse moduleInstallIntentResponse = (ModuleInstallIntentResponse) C5717a.a(parcel, ModuleInstallIntentResponse.CREATOR);
            C5717a.b(parcel);
            zac(status3, moduleInstallIntentResponse);
        } else {
            if (i10 != 4) {
                return false;
            }
            Status status4 = (Status) C5717a.a(parcel, Status.CREATOR);
            C5717a.b(parcel);
            zab(status4);
        }
        return true;
    }
}
