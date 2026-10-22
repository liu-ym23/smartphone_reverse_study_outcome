package f6;

import C7.f;
import D6.i;
import D7.q;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.stepos.account.oauth.AuthException;
import com.stepos.account.oauth.Authenticator;
import kotlin.jvm.internal.k;

/* renamed from: f6.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1438c {

    /* renamed from: a, reason: collision with root package name */
    public final Context f4441a;
    public final f b;

    public C1438c(Context context) {
        k.f(context, "context");
        this.f4441a = context;
        this.b = kotlin.a.a(new i(this, 27));
    }

    public final String a() {
        String str;
        try {
            String[] authToken = ((Authenticator) this.b.getF4884a()).getAuthToken(System.currentTimeMillis(), (Activity) null);
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

    public final String b() {
        try {
            String localAccountId = ((Authenticator) this.b.getF4884a()).getLocalAccountId();
            if (localAccountId == null) {
                localAccountId = "";
            }
            Log.i("AccountUtil", "getUserId: ".concat(localAccountId));
            return localAccountId;
        } catch (Throwable th) {
            androidx.constraintlayout.core.dsl.a.w("getUserId error: ", th.getMessage(), "AccountUtil");
            return "";
        }
    }
}
