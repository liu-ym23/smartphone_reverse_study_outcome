package com.google.android.gms.common.moduleinstall;

import a1.C0154a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import t0.J;

@SafeParcelable.Class(creator = "ModuleAvailabilityResponseCreator")
/* loaded from: classes.dex */
public class ModuleAvailabilityResponse extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<ModuleAvailabilityResponse> CREATOR = new C0154a(15);

    /* renamed from: a, reason: collision with root package name */
    public final boolean f9880a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9881b;

    @Retention(RetentionPolicy.CLASS)
    public @interface AvailabilityStatus {
        public static final int STATUS_ALREADY_AVAILABLE = 0;
        public static final int STATUS_READY_TO_DOWNLOAD = 1;
        public static final int STATUS_UNKNOWN_MODULE = 2;
    }

    public ModuleAvailabilityResponse(int i4, boolean z4) {
        this.f9880a = z4;
        this.f9881b = i4;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.c0(parcel, 1, 4);
        parcel.writeInt(this.f9880a ? 1 : 0);
        J.c0(parcel, 2, 4);
        parcel.writeInt(this.f9881b);
        J.b0(parcel, iZ);
    }
}
