package v5;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import b0.a2;
import c7.o;
import com.stepos.account.oauth.AuthException;
import com.stepos.account.oauth.Authenticator;
import d7.n;
import m.x;
import q7.k;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Context f10508a;

    /* renamed from: b, reason: collision with root package name */
    public final o f10509b;

    public a(Context context) {
        k.e(context, "context");
        this.f10508a = context;
        this.f10509b = s7.a.H(new a2(8, this));
    }

    public final String a() {
        String str;
        String str2;
        try {
            String[] authToken = ((Authenticator) this.f10509b.getValue()).getAuthToken(System.currentTimeMillis(), (Activity) null);
            if (authToken == null || (str = (String) n.k0(0, authToken)) == null) {
                str = "";
            }
            if (str.length() == 0) {
                str2 = "<empty>";
            } else {
                str2 = "len=" + str.length();
            }
            Log.i("AccountUtil", "getToken: " + str2);
            return str;
        } catch (AuthException e10) {
            x.v("getToken error: ", e10.getMessage(), "AccountUtil");
            return "";
        }
    }

    public final String b() {
        String str;
        try {
            String localAccountId = ((Authenticator) this.f10509b.getValue()).getLocalAccountId();
            if (localAccountId == null) {
                localAccountId = "";
            }
            if (localAccountId.length() == 0) {
                str = "<empty>";
            } else {
                str = "len=" + localAccountId.length();
            }
            Log.i("AccountUtil", "getUserId: " + str);
            return localAccountId;
        } catch (Throwable th) {
            x.v("getUserId error: ", th.getMessage(), "AccountUtil");
            return "";
        }
    }
}
