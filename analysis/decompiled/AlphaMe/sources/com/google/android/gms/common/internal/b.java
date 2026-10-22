package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;

/* loaded from: classes.dex */
public final class b implements a {

    /* renamed from: a, reason: collision with root package name */
    public final Object f9771a;

    public /* synthetic */ b(Object obj) {
        this.f9771a = obj;
    }

    @Override // com.google.android.gms.common.internal.a
    public final void a(ConnectionResult connectionResult) {
        boolean z4 = connectionResult.f9598b == 0;
        Object obj = this.f9771a;
        if (z4) {
            c cVar = (c) obj;
            cVar.b(null, ((e) cVar).f9804x);
        } else {
            b bVar = ((c) obj).f9787o;
            if (bVar != null) {
                ((com.google.android.gms.common.api.internal.j) bVar.f9771a).onConnectionFailed(connectionResult);
            }
        }
    }
}
