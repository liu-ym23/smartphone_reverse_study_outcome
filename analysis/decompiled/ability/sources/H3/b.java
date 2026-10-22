package H3;

import C7.f;
import D6.i;
import D7.q;
import android.accounts.Account;
import android.accounts.OnAccountsUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.stepos.account.oauth.AuthException;
import com.stepos.account.oauth.Authenticator;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class b {
    public static String g = "";

    /* renamed from: a, reason: collision with root package name */
    public final Context f733a;
    public W3.a b;
    public W3.a c;
    public volatile Boolean d;
    public final f e;
    public final a f;

    /* JADX WARN: Type inference failed for: r2v3, types: [H3.a] */
    public b(Context context) {
        k.f(context, "context");
        this.f733a = context;
        this.e = kotlin.a.a(new i(this, 4));
        this.f = new OnAccountsUpdateListener() { // from class: H3.a
            @Override // android.accounts.OnAccountsUpdateListener
            public final void onAccountsUpdated(Account[] accountArr) {
                b bVar = this.f732a;
                boolean zB = bVar.b();
                String localAccountId = ((Authenticator) bVar.e.getF4884a()).getLocalAccountId();
                if (localAccountId == null) {
                    localAccountId = "";
                }
                Log.i("AccountUtil", "onAccountsUpdated: isLogin=" + zB + " uid=" + localAccountId + " wasLoggedIn=" + bVar.d);
                Boolean bool = bVar.d;
                bVar.d = Boolean.valueOf(zB);
                if (zB && !k.b(bool, Boolean.TRUE)) {
                    b.g = localAccountId;
                    W3.a aVar = bVar.b;
                    if (aVar != null) {
                        aVar.invoke();
                        return;
                    }
                    return;
                }
                if (zB || !k.b(bool, Boolean.TRUE)) {
                    return;
                }
                b.g = "";
                W3.a aVar2 = bVar.c;
                if (aVar2 != null) {
                    aVar2.invoke();
                }
            }
        };
    }

    public final String a() {
        String str;
        try {
            String[] authToken = ((Authenticator) this.e.getF4884a()).getAuthToken(System.currentTimeMillis(), (Activity) null);
            if (authToken == null || (str = (String) q.s0(0, authToken)) == null) {
                str = "";
            }
            Log.i("AccountUtil", "getToken: ".concat(str.length() == 0 ? "<empty>" : "<present>"));
            return str;
        } catch (AuthException e) {
            androidx.constraintlayout.core.dsl.a.w("getToken error: ", e.getMessage(), "AccountUtil");
            return "";
        }
    }

    public final boolean b() {
        try {
            return ((Authenticator) this.e.getF4884a()).isLoggedIn();
        } catch (Throwable th) {
            androidx.constraintlayout.core.dsl.a.w("isLoggedIn error: ", th.getMessage(), "AccountUtil");
            return false;
        }
    }
}
