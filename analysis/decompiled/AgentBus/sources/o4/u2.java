package o4;

import android.content.Context;
import android.content.SharedPreferences;
import java.security.KeyStore;

/* loaded from: classes.dex */
public final class u2 {

    /* renamed from: a, reason: collision with root package name */
    public final SharedPreferences f7656a;

    public u2(Context context) {
        q7.k.e(context, "context");
        SharedPreferences sharedPreferencesP = a.p(context);
        if (sharedPreferencesP == null) {
            try {
                context.deleteSharedPreferences("openclaw_tls_fingerprints");
            } catch (Throwable th) {
                w7.e0.n(th);
            }
            try {
                KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                keyStore.load(null);
                if (keyStore.containsAlias("_androidx_security_master_key_")) {
                    keyStore.deleteEntry("_androidx_security_master_key_");
                }
            } catch (Throwable th2) {
                w7.e0.n(th2);
            }
            sharedPreferencesP = a.p(context);
            if (sharedPreferencesP == null) {
                throw new IllegalStateException("EncryptedSharedPreferences re-create failed after reset");
            }
        }
        this.f7656a = sharedPreferencesP;
    }
}
