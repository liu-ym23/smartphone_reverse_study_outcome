package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

/* loaded from: classes2.dex */
public final class N extends E {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ AbstractC1662c f19747g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public N(AbstractC1662c abstractC1662c, int i10, Bundle bundle) {
        super(abstractC1662c, i10, null);
        this.f19747g = abstractC1662c;
    }

    @Override // com.google.android.gms.common.internal.E
    public final void f(ConnectionResult connectionResult) {
        if (this.f19747g.q() && AbstractC1662c.d0(this.f19747g)) {
            AbstractC1662c.Z(this.f19747g, 16);
        } else {
            this.f19747g.f19793p.a(connectionResult);
            this.f19747g.I(connectionResult);
        }
    }

    @Override // com.google.android.gms.common.internal.E
    public final boolean g() {
        this.f19747g.f19793p.a(ConnectionResult.RESULT_SUCCESS);
        return true;
    }
}
