package com.google.android.gms.common.api;

import B0.e;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.room.AbstractC0351g;
import b.C0354a;
import com.airbnb.lottie.h;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import t0.J;

@SafeParcelable.Class(creator = "StatusCreator")
/* loaded from: classes.dex */
public final class Status extends AbstractSafeParcelable implements ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<Status> CREATOR = new C0354a(28);

    /* renamed from: a, reason: collision with root package name */
    public final int f9611a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9612b;

    /* renamed from: c, reason: collision with root package name */
    public final String f9613c;

    /* renamed from: d, reason: collision with root package name */
    public final PendingIntent f9614d;

    /* renamed from: e, reason: collision with root package name */
    public final ConnectionResult f9615e;

    public Status(int i4, int i5, String str, PendingIntent pendingIntent, ConnectionResult connectionResult) {
        this.f9611a = i4;
        this.f9612b = i5;
        this.f9613c = str;
        this.f9614d = pendingIntent;
        this.f9615e = connectionResult;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f9611a == status.f9611a && this.f9612b == status.f9612b && h.m(this.f9613c, status.f9613c) && h.m(this.f9614d, status.f9614d) && h.m(this.f9615e, status.f9615e);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f9611a), Integer.valueOf(this.f9612b), this.f9613c, this.f9614d, this.f9615e});
    }

    public final String toString() {
        e eVar = new e(this);
        String strM = this.f9613c;
        if (strM == null) {
            int i4 = this.f9612b;
            switch (i4) {
                case -1:
                    strM = "SUCCESS_CACHE";
                    break;
                case 0:
                    strM = "SUCCESS";
                    break;
                case 1:
                case 9:
                case 11:
                case 12:
                default:
                    strM = AbstractC0351g.m("unknown status code: ", i4);
                    break;
                case 2:
                    strM = "SERVICE_VERSION_UPDATE_REQUIRED";
                    break;
                case 3:
                    strM = "SERVICE_DISABLED";
                    break;
                case 4:
                    strM = "SIGN_IN_REQUIRED";
                    break;
                case 5:
                    strM = "INVALID_ACCOUNT";
                    break;
                case 6:
                    strM = "RESOLUTION_REQUIRED";
                    break;
                case 7:
                    strM = "NETWORK_ERROR";
                    break;
                case 8:
                    strM = "INTERNAL_ERROR";
                    break;
                case 10:
                    strM = "DEVELOPER_ERROR";
                    break;
                case 13:
                    strM = "ERROR";
                    break;
                case 14:
                    strM = "INTERRUPTED";
                    break;
                case 15:
                    strM = "TIMEOUT";
                    break;
                case 16:
                    strM = "CANCELED";
                    break;
                case 17:
                    strM = "API_NOT_CONNECTED";
                    break;
                case 18:
                    strM = "DEAD_CLIENT";
                    break;
                case 19:
                    strM = "REMOTE_EXCEPTION";
                    break;
                case 20:
                    strM = "CONNECTION_SUSPENDED_DURING_CALL";
                    break;
                case 21:
                    strM = "RECONNECTION_TIMED_OUT_DURING_UPDATE";
                    break;
                case 22:
                    strM = "RECONNECTION_TIMED_OUT";
                    break;
            }
        }
        eVar.a(strM, "statusCode");
        eVar.a(this.f9614d, "resolution");
        return eVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.c0(parcel, 1, 4);
        parcel.writeInt(this.f9612b);
        J.U(parcel, 2, this.f9613c);
        J.T(parcel, 3, this.f9614d, i4);
        J.T(parcel, 4, this.f9615e, i4);
        J.c0(parcel, 1000, 4);
        parcel.writeInt(this.f9611a);
        J.b0(parcel, iZ);
    }

    public Status(int i4, String str) {
        this(1, i4, str, null, null);
    }
}
