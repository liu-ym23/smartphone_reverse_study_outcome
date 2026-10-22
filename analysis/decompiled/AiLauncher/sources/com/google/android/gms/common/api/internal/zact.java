package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.internal.C1663d;
import com.google.android.gms.common.internal.C1669j;
import com.google.android.gms.common.internal.zav;
import com.google.android.gms.signin.internal.zac;
import com.google.android.gms.signin.internal.zak;
import java.util.Set;

/* loaded from: classes2.dex */
public final class zact extends zac implements d.a, d.b {
    private static final a.AbstractC0224a zaa = C2.e.f1695c;
    private final Context zab;
    private final Handler zac;
    private final a.AbstractC0224a zad;
    private final Set zae;
    private final C1663d zaf;
    private C2.f zag;
    private h0 zah;

    public zact(Context context, Handler handler, C1663d c1663d) {
        a.AbstractC0224a abstractC0224a = zaa;
        this.zab = context;
        this.zac = handler;
        this.zaf = (C1663d) C1669j.l(c1663d, "ClientSettings must not be null");
        this.zae = c1663d.e();
        this.zad = abstractC0224a;
    }

    public static /* bridge */ /* synthetic */ void zad(zact zactVar, zak zakVar) {
        ConnectionResult connectionResultZaa = zakVar.zaa();
        if (connectionResultZaa.isSuccess()) {
            zav zavVar = (zav) C1669j.k(zakVar.zab());
            ConnectionResult connectionResultZaa2 = zavVar.zaa();
            if (!connectionResultZaa2.isSuccess()) {
                String strValueOf = String.valueOf(connectionResultZaa2);
                Log.wtf("SignInCoordinator", "Sign-in succeeded with resolve account failure: ".concat(strValueOf), new Exception());
                zactVar.zah.c(connectionResultZaa2);
                zactVar.zag.disconnect();
                return;
            }
            zactVar.zah.b(zavVar.zab(), zactVar.zae);
        } else {
            zactVar.zah.c(connectionResultZaa);
        }
        zactVar.zag.disconnect();
    }

    @Override // com.google.android.gms.common.api.internal.InterfaceC1639e
    public final void onConnected(Bundle bundle) {
        this.zag.k(this);
    }

    @Override // com.google.android.gms.common.api.internal.InterfaceC1646l
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.zah.c(connectionResult);
    }

    @Override // com.google.android.gms.common.api.internal.InterfaceC1639e
    public final void onConnectionSuspended(int i10) {
        this.zah.d(i10);
    }

    @Override // com.google.android.gms.signin.internal.zac, com.google.android.gms.signin.internal.zae
    public final void zab(zak zakVar) {
        this.zac.post(new g0(this, zakVar));
    }

    /* JADX WARN: Type inference failed for: r9v1, types: [C2.f, com.google.android.gms.common.api.a$f] */
    public final void zae(h0 h0Var) {
        C2.f fVar = this.zag;
        if (fVar != null) {
            fVar.disconnect();
        }
        this.zaf.i(Integer.valueOf(System.identityHashCode(this)));
        a.AbstractC0224a abstractC0224a = this.zad;
        Context context = this.zab;
        Handler handler = this.zac;
        C1663d c1663d = this.zaf;
        this.zag = abstractC0224a.a(context, handler.getLooper(), c1663d, c1663d.f(), this, this);
        this.zah = h0Var;
        Set set = this.zae;
        if (set == null || set.isEmpty()) {
            this.zac.post(new f0(this));
        } else {
            this.zag.zab();
        }
    }

    public final void zaf() {
        C2.f fVar = this.zag;
        if (fVar != null) {
            fVar.disconnect();
        }
    }
}
