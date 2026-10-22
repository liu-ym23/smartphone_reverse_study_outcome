package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import java.util.Set;

/* loaded from: classes2.dex */
public final class q0 {

    /* renamed from: a, reason: collision with root package name */
    public final androidx.collection.a f19669a;

    /* renamed from: b, reason: collision with root package name */
    public final androidx.collection.a f19670b;

    /* renamed from: c, reason: collision with root package name */
    public final D2.j f19671c;

    /* renamed from: d, reason: collision with root package name */
    public int f19672d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f19673e;

    public final Set a() {
        return this.f19669a.keySet();
    }

    public final void b(C1635b c1635b, ConnectionResult connectionResult, String str) {
        this.f19669a.put(c1635b, connectionResult);
        this.f19670b.put(c1635b, str);
        this.f19672d--;
        if (!connectionResult.isSuccess()) {
            this.f19673e = true;
        }
        if (this.f19672d == 0) {
            if (!this.f19673e) {
                this.f19671c.c(this.f19670b);
            } else {
                this.f19671c.b(new AvailabilityException(this.f19669a));
            }
        }
    }
}
