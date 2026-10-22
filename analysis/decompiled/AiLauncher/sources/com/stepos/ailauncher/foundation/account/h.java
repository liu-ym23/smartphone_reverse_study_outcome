package com.stepos.ailauncher.foundation.account;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.stepos.account.oauth.AuthException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class h {
    private static final String AUTH_SCOPE = "basic";
    private static final String TAG = "AuthenticatorManager";
    private final Z3.b mAuthenticator;

    public class a implements Z3.c {
        final /* synthetic */ j[] val$ref;

        public a(j[] jVarArr) {
            this.val$ref = jVarArr;
        }

        @Override // Z3.c
        public void a(String str, String str2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onSuccess: hasToken=");
            sb2.append((str == null || str.isEmpty()) ? false : true);
            sb2.append(" hasSecret=");
            sb2.append((str2 == null || str2.isEmpty()) ? false : true);
            Log.d(h.TAG, sb2.toString());
            j jVar = this.val$ref[0];
            if (jVar != null) {
                jVar.a(str, str2);
            }
            this.val$ref[0] = null;
        }

        @Override // Z3.c
        public void b(Intent intent) {
            j jVar = this.val$ref[0];
            if (jVar != null) {
                jVar.b(intent);
            }
        }

        @Override // Z3.c
        public void c(int i10, String str, String str2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onError: ");
            sb2.append(i10);
            sb2.append(" ");
            sb2.append(str);
            sb2.append(" hasAccountName=");
            sb2.append(str2 != null);
            Log.e(h.TAG, sb2.toString());
            j jVar = this.val$ref[0];
            if (jVar != null) {
                jVar.c(i10, str, str2);
            }
            this.val$ref[0] = null;
        }
    }

    public class b implements Z3.d {
        final /* synthetic */ k[] val$ref;

        public b(k[] kVarArr) {
            this.val$ref = kVarArr;
        }

        @Override // Z3.d
        public void a(JSONObject jSONObject) {
            k kVar = this.val$ref[0];
            if (kVar != null) {
                kVar.a(jSONObject);
            }
            this.val$ref[0] = null;
        }

        @Override // Z3.d
        public void onFailed(int i10, String str) {
            k kVar = this.val$ref[0];
            if (kVar != null) {
                kVar.onFailed(i10, str);
            }
            this.val$ref[0] = null;
        }
    }

    public h(Context context) {
        this.mAuthenticator = new Z3.b(context, AUTH_SCOPE);
    }

    public static boolean f(JSONObject jSONObject) {
        return Z3.b.x(jSONObject);
    }

    public String a() {
        return this.mAuthenticator.k();
    }

    public void b(boolean z10, Activity activity, j jVar) {
        this.mAuthenticator.l(z10, activity, new a(new j[]{jVar}));
    }

    public String[] c(boolean z10, Activity activity) {
        try {
            return this.mAuthenticator.n(z10, activity);
        } catch (AuthException e10) {
            Log.w(TAG, "getAuthTokenSync", e10);
            return null;
        }
    }

    public Intent d() {
        return this.mAuthenticator.p();
    }

    public void e(String str, boolean z10, k kVar) {
        this.mAuthenticator.t(str, new b(new k[]{kVar}), z10);
    }
}
