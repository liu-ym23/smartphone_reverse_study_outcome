package p8;

import android.content.Context;
import android.security.keystore.KeyGenParameterSpec;
import java.lang.invoke.VarHandle;
import pc.t;
import s.f;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f9923a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static volatile t f9924b;

    public final t a(Context context) {
        t tVarD;
        context.getClass();
        t tVar = f9924b;
        if (tVar != null) {
            return tVar;
        }
        synchronized (this) {
            try {
                tVarD = f9924b;
                if (tVarD == null) {
                    Context applicationContext = context.getApplicationContext();
                    b2.a aVar = new b2.a(5);
                    applicationContext.getApplicationContext();
                    aVar.f1861c = "_androidx_security_master_key_";
                    VarHandle.storeStoreFence();
                    if (f.c(1) != 0) {
                        throw new IllegalArgumentException("Unsupported scheme: ".concat("AES256_GCM"));
                    }
                    if (((KeyGenParameterSpec) aVar.f1862d) != null) {
                        throw new IllegalArgumentException("KeyScheme set after setting a KeyGenParamSpec");
                    }
                    aVar.f1860b = 1;
                    tVarD = aVar.d();
                    f9924b = tVarD;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return tVarD;
    }
}
