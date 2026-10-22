package com.google.android.gms.common;

import a1.C0154a;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import t0.J;

@SafeParcelable.Class(creator = "ConnectionResultCreator")
/* loaded from: classes.dex */
public final class ConnectionResult extends AbstractSafeParcelable {

    /* renamed from: a, reason: collision with root package name */
    public final int f9597a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9598b;

    /* renamed from: c, reason: collision with root package name */
    public final PendingIntent f9599c;

    /* renamed from: d, reason: collision with root package name */
    public final String f9600d;

    /* renamed from: e, reason: collision with root package name */
    public static final ConnectionResult f9596e = new ConnectionResult(0);

    @NonNull
    public static final Parcelable.Creator<ConnectionResult> CREATOR = new C0154a(28);

    public ConnectionResult(String str, PendingIntent pendingIntent, int i4, int i5) {
        this.f9597a = i4;
        this.f9598b = i5;
        this.f9599c = pendingIntent;
        this.f9600d = str;
    }

    public static String N(int i4) {
        if (i4 == 99) {
            return "UNFINISHED";
        }
        if (i4 == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i4) {
            case -1:
                return "UNKNOWN";
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i4) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    case 22:
                        return "RESOLUTION_ACTIVITY_NOT_FOUND";
                    case 23:
                        return "API_DISABLED";
                    case 24:
                        return "API_DISABLED_FOR_CONNECTION";
                    default:
                        return B0.g.j("UNKNOWN_ERROR_CODE(", i4, ")");
                }
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ConnectionResult)) {
            return false;
        }
        ConnectionResult connectionResult = (ConnectionResult) obj;
        return this.f9598b == connectionResult.f9598b && com.airbnb.lottie.h.m(this.f9599c, connectionResult.f9599c) && com.airbnb.lottie.h.m(this.f9600d, connectionResult.f9600d);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f9598b), this.f9599c, this.f9600d});
    }

    public final String toString() {
        B0.e eVar = new B0.e(this);
        eVar.a(N(this.f9598b), "statusCode");
        eVar.a(this.f9599c, "resolution");
        eVar.a(this.f9600d, "message");
        return eVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.c0(parcel, 1, 4);
        parcel.writeInt(this.f9597a);
        J.c0(parcel, 2, 4);
        parcel.writeInt(this.f9598b);
        J.T(parcel, 3, this.f9599c, i4);
        J.U(parcel, 4, this.f9600d);
        J.b0(parcel, iZ);
    }

    public ConnectionResult(int i4) {
        this(null, null, 1, i4);
    }

    public ConnectionResult(int i4, PendingIntent pendingIntent) {
        this(null, pendingIntent, 1, i4);
    }
}
