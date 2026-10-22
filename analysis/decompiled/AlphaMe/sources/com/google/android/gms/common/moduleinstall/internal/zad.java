package com.google.android.gms.common.moduleinstall.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.moduleinstall.ModuleAvailabilityResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallIntentResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallResponse;
import com.google.android.gms.internal.base.zab;
import g1.AbstractC0573a;

/* loaded from: classes.dex */
public abstract class zad extends zab implements zae {
    public zad() {
        super("com.google.android.gms.common.moduleinstall.internal.IModuleInstallCallbacks");
    }

    @Override // com.google.android.gms.internal.base.zab
    public final boolean zaa(int i4, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
        if (i4 == 1) {
            Status status = (Status) AbstractC0573a.a(parcel, Status.CREATOR);
            ModuleAvailabilityResponse moduleAvailabilityResponse = (ModuleAvailabilityResponse) AbstractC0573a.a(parcel, ModuleAvailabilityResponse.CREATOR);
            AbstractC0573a.b(parcel);
            zae(status, moduleAvailabilityResponse);
        } else if (i4 == 2) {
            Status status2 = (Status) AbstractC0573a.a(parcel, Status.CREATOR);
            ModuleInstallResponse moduleInstallResponse = (ModuleInstallResponse) AbstractC0573a.a(parcel, ModuleInstallResponse.CREATOR);
            AbstractC0573a.b(parcel);
            zad(status2, moduleInstallResponse);
        } else if (i4 == 3) {
            Status status3 = (Status) AbstractC0573a.a(parcel, Status.CREATOR);
            ModuleInstallIntentResponse moduleInstallIntentResponse = (ModuleInstallIntentResponse) AbstractC0573a.a(parcel, ModuleInstallIntentResponse.CREATOR);
            AbstractC0573a.b(parcel);
            zac(status3, moduleInstallIntentResponse);
        } else {
            if (i4 != 4) {
                return false;
            }
            Status status4 = (Status) AbstractC0573a.a(parcel, Status.CREATOR);
            AbstractC0573a.b(parcel);
            zab(status4);
        }
        return true;
    }
}
