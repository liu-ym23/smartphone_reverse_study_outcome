package k1;

import Z0.g;
import Z0.h;
import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.common.internal.zat;
import com.google.android.gms.signin.internal.zae;
import com.google.android.gms.signin.internal.zaf;
import com.google.android.gms.signin.internal.zai;
import com.google.android.gms.signin.internal.zak;
import com.stepos.statsrpk.c;
import j1.InterfaceC0635c;
import org.json.JSONException;

/* renamed from: k1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0677a extends e implements InterfaceC0635c {

    /* renamed from: A, reason: collision with root package name */
    public final d f13332A;

    /* renamed from: B, reason: collision with root package name */
    public final Bundle f13333B;

    /* renamed from: C, reason: collision with root package name */
    public final Integer f13334C;

    /* renamed from: z, reason: collision with root package name */
    public final boolean f13335z;

    public C0677a(Context context, Looper looper, d dVar, Bundle bundle, g gVar, h hVar) {
        super(context, looper, 44, dVar, gVar, hVar);
        this.f13335z = true;
        this.f13332A = dVar;
        this.f13333B = bundle;
        this.f13334C = dVar.f9803i;
    }

    @Override // j1.InterfaceC0635c
    public final void d(zae zaeVar) throws NumberFormatException {
        GoogleSignInAccount googleSignInAccountN;
        c.m(zaeVar, "Expecting a valid ISignInCallbacks");
        try {
            Account account = this.f13332A.f9795a;
            if (account == null) {
                account = new Account("<<default account>>", "com.google");
            }
            if ("<<default account>>".equals(account.name)) {
                Y0.a aVarA = Y0.a.a(this.f9775c);
                String strB = aVarA.b("defaultGoogleSignInAccount");
                if (!TextUtils.isEmpty(strB)) {
                    String strB2 = aVarA.b("googleSignInAccount:" + strB);
                    if (strB2 != null) {
                        try {
                            googleSignInAccountN = GoogleSignInAccount.N(strB2);
                        } catch (JSONException unused) {
                        }
                    }
                }
                googleSignInAccountN = null;
            } else {
                googleSignInAccountN = null;
            }
            Integer num = this.f13334C;
            c.l(num);
            ((zaf) l()).zag(new zai(1, new zat(2, account, num.intValue(), googleSignInAccountN)), zaeVar);
        } catch (RemoteException e4) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                zaeVar.zab(new zak(1, new ConnectionResult(8, null), null));
            } catch (RemoteException unused2) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e4);
            }
        }
    }

    @Override // com.google.android.gms.common.internal.c, Z0.c
    public final int e() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.c, Z0.c
    public final boolean g() {
        return this.f13335z;
    }

    @Override // j1.InterfaceC0635c
    public final void h() {
        this.f9781i = new b(this);
        s(2, null);
    }

    @Override // com.google.android.gms.common.internal.c
    public final /* synthetic */ IInterface i(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return iInterfaceQueryLocalInterface instanceof zaf ? (zaf) iInterfaceQueryLocalInterface : new zaf(iBinder);
    }

    @Override // com.google.android.gms.common.internal.c
    public final Bundle k() {
        d dVar = this.f13332A;
        boolean zEquals = this.f9775c.getPackageName().equals(dVar.f9800f);
        Bundle bundle = this.f13333B;
        if (!zEquals) {
            bundle.putString("com.google.android.gms.signin.internal.realClientPackageName", dVar.f9800f);
        }
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.c
    public final String m() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // com.google.android.gms.common.internal.c
    public final String n() {
        return "com.google.android.gms.signin.service.START";
    }
}
