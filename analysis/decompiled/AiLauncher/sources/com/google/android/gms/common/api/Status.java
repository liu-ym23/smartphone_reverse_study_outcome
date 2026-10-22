package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.activity.result.IntentSenderRequest;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.C1668i;
import com.google.android.gms.common.internal.C1669j;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import d.AbstractC3936b;
import p2.C5047a;

/* loaded from: classes2.dex */
public final class Status extends AbstractSafeParcelable implements h, ReflectedParcelable {
    private final int zzb;
    private final String zzc;
    private final PendingIntent zzd;
    private final ConnectionResult zze;
    public static final Status RESULT_SUCCESS_CACHE = new Status(-1);
    public static final Status RESULT_SUCCESS = new Status(0);
    public static final Status RESULT_INTERRUPTED = new Status(14);
    public static final Status RESULT_INTERNAL_ERROR = new Status(8);
    public static final Status RESULT_TIMEOUT = new Status(15);
    public static final Status RESULT_CANCELED = new Status(16);
    public static final Status zza = new Status(17);
    public static final Status RESULT_DEAD_CLIENT = new Status(18);
    public static final Parcelable.Creator<Status> CREATOR = new m();

    public Status(int i10, String str, PendingIntent pendingIntent, ConnectionResult connectionResult) {
        this.zzb = i10;
        this.zzc = str;
        this.zzd = pendingIntent;
        this.zze = connectionResult;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.zzb == status.zzb && C1668i.a(this.zzc, status.zzc) && C1668i.a(this.zzd, status.zzd) && C1668i.a(this.zze, status.zze);
    }

    public ConnectionResult getConnectionResult() {
        return this.zze;
    }

    public PendingIntent getResolution() {
        return this.zzd;
    }

    @Override // com.google.android.gms.common.api.h
    public Status getStatus() {
        return this;
    }

    @ResultIgnorabilityUnspecified
    public int getStatusCode() {
        return this.zzb;
    }

    public String getStatusMessage() {
        return this.zzc;
    }

    public boolean hasResolution() {
        return this.zzd != null;
    }

    public int hashCode() {
        return C1668i.b(Integer.valueOf(this.zzb), this.zzc, this.zzd, this.zze);
    }

    public boolean isCanceled() {
        return this.zzb == 16;
    }

    public boolean isInterrupted() {
        return this.zzb == 14;
    }

    public boolean isSuccess() {
        return this.zzb <= 0;
    }

    public void startResolutionForResult(Activity activity, int i10) throws IntentSender.SendIntentException {
        if (hasResolution()) {
            PendingIntent pendingIntent = this.zzd;
            C1669j.k(pendingIntent);
            activity.startIntentSenderForResult(pendingIntent.getIntentSender(), i10, null, 0, 0, 0);
        }
    }

    public String toString() {
        C1668i.a aVarC = C1668i.c(this);
        aVarC.a("statusCode", zza());
        aVarC.a("resolution", this.zzd);
        return aVarC.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = C5047a.a(parcel);
        C5047a.p(parcel, 1, getStatusCode());
        C5047a.x(parcel, 2, getStatusMessage(), false);
        C5047a.w(parcel, 3, this.zzd, i10, false);
        C5047a.w(parcel, 4, getConnectionResult(), i10, false);
        C5047a.b(parcel, iA);
    }

    public final String zza() {
        String str = this.zzc;
        return str != null ? str : b.a(this.zzb);
    }

    public Status(int i10) {
        this(i10, (String) null);
    }

    public Status(ConnectionResult connectionResult, String str) {
        this(connectionResult, str, 17);
    }

    public void startResolutionForResult(AbstractC3936b<IntentSenderRequest> abstractC3936b) {
        if (hasResolution()) {
            PendingIntent pendingIntent = this.zzd;
            C1669j.k(pendingIntent);
            abstractC3936b.a(new IntentSenderRequest.a(pendingIntent.getIntentSender()).a());
        }
    }

    public Status(int i10, String str) {
        this(i10, str, (PendingIntent) null);
    }

    @Deprecated
    public Status(ConnectionResult connectionResult, String str, int i10) {
        this(i10, str, connectionResult.getResolution(), connectionResult);
    }

    public Status(int i10, String str, PendingIntent pendingIntent) {
        this(i10, str, pendingIntent, null);
    }
}
