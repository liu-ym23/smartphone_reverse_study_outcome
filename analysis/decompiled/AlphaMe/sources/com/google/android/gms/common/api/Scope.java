package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import b.C0354a;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import t0.J;

@SafeParcelable.Class(creator = "ScopeCreator")
/* loaded from: classes.dex */
public final class Scope extends AbstractSafeParcelable implements ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<Scope> CREATOR = new C0354a(27);

    /* renamed from: a, reason: collision with root package name */
    public final int f9609a;

    /* renamed from: b, reason: collision with root package name */
    public final String f9610b;

    public Scope(int i4, String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("scopeUri must not be null or empty");
        }
        this.f9609a = i4;
        this.f9610b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scope)) {
            return false;
        }
        return this.f9610b.equals(((Scope) obj).f9610b);
    }

    public final int hashCode() {
        return this.f9610b.hashCode();
    }

    public final String toString() {
        return this.f9610b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iZ = J.Z(parcel, 20293);
        J.c0(parcel, 1, 4);
        parcel.writeInt(this.f9609a);
        J.U(parcel, 2, this.f9610b);
        J.b0(parcel, iZ);
    }
}
