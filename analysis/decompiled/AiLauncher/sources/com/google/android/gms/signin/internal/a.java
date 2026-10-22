package com.google.android.gms.signin.internal;

import C2.f;
import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.internal.AbstractC1662c;
import com.google.android.gms.common.internal.AbstractC1664e;
import com.google.android.gms.common.internal.C1663d;
import com.google.android.gms.common.internal.C1669j;
import com.google.android.gms.common.internal.zat;

/* loaded from: classes2.dex */
public class a extends AbstractC1664e<zaf> implements f {

    /* renamed from: M, reason: collision with root package name */
    public static final /* synthetic */ int f20193M = 0;

    /* renamed from: I, reason: collision with root package name */
    public final boolean f20194I;

    /* renamed from: J, reason: collision with root package name */
    public final C1663d f20195J;

    /* renamed from: K, reason: collision with root package name */
    public final Bundle f20196K;

    /* renamed from: L, reason: collision with root package name */
    public final Integer f20197L;

    public a(Context context, Looper looper, boolean z10, C1663d c1663d, Bundle bundle, d.a aVar, d.b bVar) {
        super(context, looper, 44, c1663d, aVar, bVar);
        this.f20194I = true;
        this.f20195J = c1663d;
        this.f20196K = bundle;
        this.f20197L = c1663d.g();
    }

    public static Bundle h0(C1663d c1663d) {
        c1663d.f();
        Integer numG = c1663d.g();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", c1663d.a());
        if (numG != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", numG.intValue());
        }
        bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", false);
        bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", false);
        bundle.putString("com.google.android.gms.signin.internal.serverClientId", null);
        bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
        bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", false);
        bundle.putString("com.google.android.gms.signin.internal.hostedDomain", null);
        bundle.putString("com.google.android.gms.signin.internal.logSessionId", null);
        bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", false);
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.AbstractC1662c
    public final String B() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // com.google.android.gms.common.internal.AbstractC1662c
    public final String C() {
        return "com.google.android.gms.signin.service.START";
    }

    @Override // com.google.android.gms.common.internal.AbstractC1662c, com.google.android.gms.common.api.a.f
    public final boolean f() {
        return this.f20194I;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // C2.f
    public final void k(zae zaeVar) {
        C1669j.l(zaeVar, "Expecting a valid ISignInCallbacks");
        try {
            Account accountB = this.f20195J.b();
            ((zaf) A()).zag(new zai(1, new zat(accountB, ((Integer) C1669j.k(this.f20197L)).intValue(), "<<default account>>".equals(accountB.name) ? com.google.android.gms.auth.api.signin.internal.b.a(v()).b() : null)), zaeVar);
        } catch (RemoteException e10) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                zaeVar.zab(new zak(1, new ConnectionResult(8, null), null));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e10);
            }
        }
    }

    @Override // com.google.android.gms.common.internal.AbstractC1662c, com.google.android.gms.common.api.a.f
    public final int l() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.AbstractC1662c
    public final /* synthetic */ IInterface p(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return iInterfaceQueryLocalInterface instanceof zaf ? (zaf) iInterfaceQueryLocalInterface : new zaf(iBinder);
    }

    @Override // com.google.android.gms.common.internal.AbstractC1662c
    public final Bundle x() {
        if (!v().getPackageName().equals(this.f20195J.d())) {
            this.f20196K.putString("com.google.android.gms.signin.internal.realClientPackageName", this.f20195J.d());
        }
        return this.f20196K;
    }

    @Override // C2.f
    public final void zab() {
        d(new AbstractC1662c.d());
    }
}
