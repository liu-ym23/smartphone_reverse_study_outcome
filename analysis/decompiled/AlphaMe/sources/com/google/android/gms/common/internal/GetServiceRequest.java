package com.google.android.gms.common.internal;

import a1.C0154a;
import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@KeepForSdk
@SafeParcelable.Class(creator = "GetServiceRequestCreator")
@SafeParcelable.Reserved({9})
/* loaded from: classes.dex */
public class GetServiceRequest extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new C0154a(13);

    /* renamed from: o, reason: collision with root package name */
    public static final Scope[] f9739o = new Scope[0];

    /* renamed from: p, reason: collision with root package name */
    public static final Feature[] f9740p = new Feature[0];

    /* renamed from: a, reason: collision with root package name */
    public final int f9741a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9742b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9743c;

    /* renamed from: d, reason: collision with root package name */
    public String f9744d;

    /* renamed from: e, reason: collision with root package name */
    public IBinder f9745e;

    /* renamed from: f, reason: collision with root package name */
    public Scope[] f9746f;

    /* renamed from: g, reason: collision with root package name */
    public Bundle f9747g;

    /* renamed from: h, reason: collision with root package name */
    public Account f9748h;

    /* renamed from: i, reason: collision with root package name */
    public Feature[] f9749i;

    /* renamed from: j, reason: collision with root package name */
    public Feature[] f9750j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f9751k;

    /* renamed from: l, reason: collision with root package name */
    public final int f9752l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f9753m;

    /* renamed from: n, reason: collision with root package name */
    public final String f9754n;

    public GetServiceRequest(int i4, int i5, int i6, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, Feature[] featureArr, Feature[] featureArr2, boolean z4, int i7, boolean z5, String str2) {
        scopeArr = scopeArr == null ? f9739o : scopeArr;
        bundle = bundle == null ? new Bundle() : bundle;
        Feature[] featureArr3 = f9740p;
        featureArr = featureArr == null ? featureArr3 : featureArr;
        featureArr2 = featureArr2 == null ? featureArr3 : featureArr2;
        this.f9741a = i4;
        this.f9742b = i5;
        this.f9743c = i6;
        if ("com.google.android.gms".equals(str)) {
            this.f9744d = "com.google.android.gms";
        } else {
            this.f9744d = str;
        }
        if (i4 < 2) {
            this.f9748h = iBinder != null ? AccountAccessor.getAccountBinderSafe(IAccountAccessor.Stub.asInterface(iBinder)) : null;
        } else {
            this.f9745e = iBinder;
            this.f9748h = account;
        }
        this.f9746f = scopeArr;
        this.f9747g = bundle;
        this.f9749i = featureArr;
        this.f9750j = featureArr2;
        this.f9751k = z4;
        this.f9752l = i7;
        this.f9753m = z5;
        this.f9754n = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        C0154a.a(this, parcel, i4);
    }
}
