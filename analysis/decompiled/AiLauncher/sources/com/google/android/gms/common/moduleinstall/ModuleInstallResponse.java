package com.google.android.gms.common.moduleinstall;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p2.C5047a;
import q2.h;

/* loaded from: classes2.dex */
public class ModuleInstallResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ModuleInstallResponse> CREATOR = new h();
    private final int zaa;
    private final boolean zab;

    public ModuleInstallResponse(int i10) {
        this(i10, false);
    }

    public boolean areModulesAlreadyInstalled() {
        return this.zaa == 0;
    }

    public int getSessionId() {
        return this.zaa;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = C5047a.a(parcel);
        C5047a.p(parcel, 1, getSessionId());
        C5047a.g(parcel, 2, this.zab);
        C5047a.b(parcel, iA);
    }

    public final boolean zaa() {
        return this.zab;
    }

    public ModuleInstallResponse(int i10, boolean z10) {
        this.zaa = i10;
        this.zab = z10;
    }
}
