package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p2.C5047a;

/* loaded from: classes2.dex */
public class ConnectionTelemetryConfiguration extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ConnectionTelemetryConfiguration> CREATOR = new S();
    private final RootTelemetryConfiguration zza;
    private final boolean zzb;
    private final boolean zzc;
    private final int[] zzd;
    private final int zze;
    private final int[] zzf;

    public ConnectionTelemetryConfiguration(RootTelemetryConfiguration rootTelemetryConfiguration, boolean z10, boolean z11, int[] iArr, int i10, int[] iArr2) {
        this.zza = rootTelemetryConfiguration;
        this.zzb = z10;
        this.zzc = z11;
        this.zzd = iArr;
        this.zze = i10;
        this.zzf = iArr2;
    }

    public int getMaxMethodInvocationsLogged() {
        return this.zze;
    }

    public int[] getMethodInvocationMethodKeyAllowlist() {
        return this.zzd;
    }

    public int[] getMethodInvocationMethodKeyDisallowlist() {
        return this.zzf;
    }

    public boolean getMethodInvocationTelemetryEnabled() {
        return this.zzb;
    }

    public boolean getMethodTimingTelemetryEnabled() {
        return this.zzc;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = C5047a.a(parcel);
        C5047a.w(parcel, 1, this.zza, i10, false);
        C5047a.g(parcel, 2, getMethodInvocationTelemetryEnabled());
        C5047a.g(parcel, 3, getMethodTimingTelemetryEnabled());
        C5047a.q(parcel, 4, getMethodInvocationMethodKeyAllowlist(), false);
        C5047a.p(parcel, 5, getMaxMethodInvocationsLogged());
        C5047a.q(parcel, 6, getMethodInvocationMethodKeyDisallowlist(), false);
        C5047a.b(parcel, iA);
    }

    public final RootTelemetryConfiguration zza() {
        return this.zza;
    }
}
