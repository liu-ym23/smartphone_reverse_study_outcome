package com.google.android.gms.common.moduleinstall;

import a1.C0154a;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import t0.J;

@SafeParcelable.Class(creator = "ModuleInstallIntentResponseCreator")
/* loaded from: classes.dex */
public class ModuleInstallIntentResponse extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<ModuleInstallIntentResponse> CREATOR = new C0154a(16);

    /* renamed from: a, reason: collision with root package name */
    public final PendingIntent f9882a;

    public ModuleInstallIntentResponse(PendingIntent pendingIntent) {
        this.f9882a = pendingIntent;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.T(parcel, 1, this.f9882a, i4);
        J.b0(parcel, iZ);
    }
}
