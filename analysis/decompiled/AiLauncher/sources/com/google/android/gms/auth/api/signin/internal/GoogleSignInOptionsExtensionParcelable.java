package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p2.C5047a;

/* loaded from: classes2.dex */
public class GoogleSignInOptionsExtensionParcelable extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GoogleSignInOptionsExtensionParcelable> CREATOR = new c();
    final int zaa;
    private int zab;
    private Bundle zac;

    public GoogleSignInOptionsExtensionParcelable(int i10, int i11, Bundle bundle) {
        this.zaa = i10;
        this.zab = i11;
        this.zac = bundle;
    }

    public int getType() {
        return this.zab;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int iA = C5047a.a(parcel);
        C5047a.p(parcel, 1, this.zaa);
        C5047a.p(parcel, 2, getType());
        C5047a.i(parcel, 3, this.zac, false);
        C5047a.b(parcel, iA);
    }

    public GoogleSignInOptionsExtensionParcelable(com.google.android.gms.auth.api.signin.a aVar) {
        this(1, aVar.a(), aVar.b());
    }
}
