package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.BinderThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.appcompat.widget.RunnableC0209k;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.zav;
import com.google.android.gms.signin.internal.zac;
import com.google.android.gms.signin.internal.zak;
import h.RunnableC0583a;
import j1.AbstractC0634b;
import j1.InterfaceC0635c;
import java.util.Set;

/* loaded from: classes.dex */
public final class zact extends zac implements Z0.g, Z0.h {
    private static final Z0.a zaa = AbstractC0634b.f13130a;
    private final Context zab;
    private final Handler zac;
    private final Z0.a zad;
    private final Set zae;
    private final com.google.android.gms.common.internal.d zaf;
    private InterfaceC0635c zag;
    private z zah;

    @WorkerThread
    public zact(Context context, Handler handler, @NonNull com.google.android.gms.common.internal.d dVar) {
        Z0.a aVar = zaa;
        this.zab = context;
        this.zac = handler;
        com.stepos.statsrpk.c.m(dVar, "ClientSettings must not be null");
        this.zaf = dVar;
        this.zae = dVar.f9796b;
        this.zad = aVar;
    }

    public static void zad(zact zactVar, zak zakVar) {
        ConnectionResult connectionResult = zakVar.f10257b;
        if (connectionResult.f9598b == 0) {
            zav zavVar = zakVar.f10258c;
            com.stepos.statsrpk.c.l(zavVar);
            ConnectionResult connectionResult2 = zavVar.f9864c;
            if (connectionResult2.f9598b != 0) {
                Log.wtf("SignInCoordinator", "Sign-in succeeded with resolve account failure: ".concat(String.valueOf(connectionResult2)), new Exception());
                ((s) zactVar.zah).c(connectionResult2);
                zactVar.zag.f();
                return;
            }
            z zVar = zactVar.zah;
            IBinder iBinder = zavVar.f9863b;
            IAccountAccessor iAccountAccessorAsInterface = iBinder == null ? null : IAccountAccessor.Stub.asInterface(iBinder);
            Set set = zactVar.zae;
            s sVar = (s) zVar;
            sVar.getClass();
            if (iAccountAccessorAsInterface == null || set == null) {
                Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
                sVar.c(new ConnectionResult(4));
            } else {
                sVar.f9682d = iAccountAccessorAsInterface;
                sVar.f9683e = set;
                if (sVar.f9679a) {
                    ((Z0.c) sVar.f9680b).b(iAccountAccessorAsInterface, set);
                }
            }
        } else {
            ((s) zactVar.zah).c(connectionResult);
        }
        zactVar.zag.f();
    }

    @Override // com.google.android.gms.common.api.internal.InterfaceC0406d
    @WorkerThread
    public final void onConnected(@Nullable Bundle bundle) {
        this.zag.d(this);
    }

    @Override // com.google.android.gms.common.api.internal.j
    @WorkerThread
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        ((s) this.zah).c(connectionResult);
    }

    @Override // com.google.android.gms.common.api.internal.InterfaceC0406d
    @WorkerThread
    public final void onConnectionSuspended(int i4) {
        this.zag.f();
    }

    @Override // com.google.android.gms.signin.internal.zac, com.google.android.gms.signin.internal.zae
    @BinderThread
    public final void zab(zak zakVar) {
        this.zac.post(new RunnableC0209k(13, this, zakVar));
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.google.android.gms.common.internal.e, j1.c] */
    @WorkerThread
    public final void zae(z zVar) {
        InterfaceC0635c interfaceC0635c = this.zag;
        if (interfaceC0635c != null) {
            interfaceC0635c.f();
        }
        this.zaf.f9803i = Integer.valueOf(System.identityHashCode(this));
        Z0.a aVar = this.zad;
        Context context = this.zab;
        Looper looper = this.zac.getLooper();
        com.google.android.gms.common.internal.d dVar = this.zaf;
        this.zag = aVar.a(context, looper, dVar, dVar.f9802h, this, this);
        this.zah = zVar;
        Set set = this.zae;
        if (set == null || set.isEmpty()) {
            this.zac.post(new RunnableC0583a(12, this));
        } else {
            this.zag.h();
        }
    }

    public final void zaf() {
        InterfaceC0635c interfaceC0635c = this.zag;
        if (interfaceC0635c != null) {
            interfaceC0635c.f();
        }
    }
}
