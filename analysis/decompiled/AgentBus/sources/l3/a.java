package l3;

import a7.g;
import android.content.Context;
import f8.x;
import i5.l;
import java.io.File;
import t3.o;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    public static final Object f5826d = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final File f5827a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f5828b;

    /* renamed from: c, reason: collision with root package name */
    public final String f5829c;

    public a(Context context, File file, x xVar) {
        this.f5827a = file;
        this.f5828b = context.getApplicationContext();
        this.f5829c = xVar.f3520g;
    }

    public final q6.b a() {
        z3.a aVarI;
        l lVarC;
        g4.c.a();
        g gVar = new g(3);
        gVar.f423l = t3.b.a("AES256_GCM_HKDF_4KB");
        gVar.A(this.f5828b, "__androidx_security_crypto_encrypted_file_keyset__", "__androidx_security_crypto_encrypted_file_pref__");
        gVar.z("android-keystore://" + this.f5829c);
        synchronized (f5826d) {
            aVarI = gVar.i();
        }
        synchronized (aVarI) {
            lVarC = aVarI.f11800a.c();
        }
        return new q6.b(21, this.f5827a, (o) lVarC.A(o.class));
    }
}
