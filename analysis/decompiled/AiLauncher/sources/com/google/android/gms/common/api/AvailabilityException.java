package com.google.android.gms.common.api;

import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.C1635b;
import com.google.android.gms.common.internal.C1669j;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class AvailabilityException extends Exception {

    /* renamed from: a, reason: collision with root package name */
    public final androidx.collection.a f19489a;

    public AvailabilityException(androidx.collection.a aVar) {
        this.f19489a = aVar;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        ArrayList arrayList = new ArrayList();
        boolean z10 = true;
        for (C1635b c1635b : this.f19489a.keySet()) {
            ConnectionResult connectionResult = (ConnectionResult) C1669j.k((ConnectionResult) this.f19489a.get(c1635b));
            z10 &= !connectionResult.isSuccess();
            arrayList.add(c1635b.b() + ": " + String.valueOf(connectionResult));
        }
        StringBuilder sb2 = new StringBuilder();
        if (z10) {
            sb2.append("None of the queried APIs are available. ");
        } else {
            sb2.append("Some of the queried APIs are unavailable. ");
        }
        sb2.append(TextUtils.join("; ", arrayList));
        return sb2.toString();
    }
}
