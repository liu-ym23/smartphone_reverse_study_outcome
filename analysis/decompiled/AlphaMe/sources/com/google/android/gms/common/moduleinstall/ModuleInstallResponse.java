package com.google.android.gms.common.moduleinstall;

import a1.C0154a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import t0.J;

@SafeParcelable.Class(creator = "ModuleInstallResponseCreator")
/* loaded from: classes.dex */
public class ModuleInstallResponse extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<ModuleInstallResponse> CREATOR = new C0154a(17);

    /* renamed from: a, reason: collision with root package name */
    public final int f9883a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f9884b;

    public ModuleInstallResponse(int i4, boolean z4) {
        this.f9883a = i4;
        this.f9884b = z4;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.c0(parcel, 1, 4);
        parcel.writeInt(this.f9883a);
        J.c0(parcel, 2, 4);
        parcel.writeInt(this.f9884b ? 1 : 0);
        J.b0(parcel, iZ);
    }
}
