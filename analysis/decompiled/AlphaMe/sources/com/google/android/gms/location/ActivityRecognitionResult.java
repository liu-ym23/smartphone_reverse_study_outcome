package com.google.android.gms.location;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.airbnb.lottie.h;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.k;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import t0.J;

@SafeParcelable.Class(creator = "ActivityRecognitionResultCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public class ActivityRecognitionResult extends AbstractSafeParcelable implements ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<ActivityRecognitionResult> CREATOR = new k(17);

    /* renamed from: a, reason: collision with root package name */
    public List f10005a;

    /* renamed from: b, reason: collision with root package name */
    public long f10006b;

    /* renamed from: c, reason: collision with root package name */
    public long f10007c;

    /* renamed from: d, reason: collision with root package name */
    public int f10008d;

    /* renamed from: e, reason: collision with root package name */
    public Bundle f10009e;

    public static boolean N(Bundle bundle, Bundle bundle2) {
        int length;
        if (bundle == null) {
            return bundle2 == null;
        }
        if (bundle2 == null || bundle.size() != bundle2.size()) {
            return false;
        }
        for (String str : bundle.keySet()) {
            if (!bundle2.containsKey(str)) {
                return false;
            }
            Object obj = bundle.get(str);
            Object obj2 = bundle2.get(str);
            if (obj == null) {
                if (obj2 != null) {
                    return false;
                }
            } else if (obj instanceof Bundle) {
                if (!N(bundle.getBundle(str), bundle2.getBundle(str))) {
                    return false;
                }
            } else {
                if (obj.getClass().isArray()) {
                    if (obj2 != null && obj2.getClass().isArray() && (length = Array.getLength(obj)) == Array.getLength(obj2)) {
                        for (int i4 = 0; i4 < length; i4++) {
                            if (h.m(Array.get(obj, i4), Array.get(obj2, i4))) {
                            }
                        }
                    }
                    return false;
                }
                if (!obj.equals(obj2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ActivityRecognitionResult activityRecognitionResult = (ActivityRecognitionResult) obj;
            if (this.f10006b == activityRecognitionResult.f10006b && this.f10007c == activityRecognitionResult.f10007c && this.f10008d == activityRecognitionResult.f10008d && h.m(this.f10005a, activityRecognitionResult.f10005a) && N(this.f10009e, activityRecognitionResult.f10009e)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f10006b), Long.valueOf(this.f10007c), Integer.valueOf(this.f10008d), this.f10005a, this.f10009e});
    }

    public final String toString() {
        return "ActivityRecognitionResult [probableActivities=" + String.valueOf(this.f10005a) + ", timeMillis=" + this.f10006b + ", elapsedRealtimeMillis=" + this.f10007c + "]";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.W(parcel, 1, this.f10005a);
        J.c0(parcel, 2, 8);
        parcel.writeLong(this.f10006b);
        J.c0(parcel, 3, 8);
        parcel.writeLong(this.f10007c);
        J.c0(parcel, 4, 4);
        parcel.writeInt(this.f10008d);
        J.P(parcel, 5, this.f10009e);
        J.b0(parcel, iZ);
    }
}
