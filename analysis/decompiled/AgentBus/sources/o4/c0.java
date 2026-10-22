package o4;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.Base64;

/* loaded from: classes.dex */
public final class c0 {

    /* renamed from: e, reason: collision with root package name */
    public static final Base64.Encoder f7304e;

    /* renamed from: a, reason: collision with root package name */
    public final Context f7305a;

    /* renamed from: b, reason: collision with root package name */
    public final File f7306b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f7307c;

    /* renamed from: d, reason: collision with root package name */
    public volatile c f7308d;

    static {
        Base64.Encoder encoderWithoutPadding = Base64.getUrlEncoder().withoutPadding();
        q7.k.d(encoderWithoutPadding, "withoutPadding(...)");
        f7304e = encoderWithoutPadding;
    }

    public c0(Context context, File file) {
        q7.k.e(context, "context");
        this.f7305a = context;
        this.f7306b = file;
        this.f7307c = new Object();
    }

    public final c a() throws IOException {
        d0 d0VarG;
        SecureRandom secureRandom = new SecureRandom();
        ((qb.c) qb.d.f8836a.get()).getClass();
        byte[] bArr = new byte[32];
        secureRandom.nextBytes(bArr);
        synchronized (bArr) {
            d0VarG = vb.b.g(bArr);
        }
        byte[] bArr2 = new byte[32];
        int[] iArr = (int[]) d0VarG.f7326g;
        ub.a.h(iArr, 10, bArr2, 0);
        ub.a.h(iArr, 15, bArr2, 16);
        bArr2[31] = (byte) (((iArr[0] & 1) << 7) | bArr2[31]);
        byte[] bArrC = n7.b.c(bArr);
        String strB = a.b(bArr2);
        try {
            File parentFile = this.f7306b.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
        } catch (Throwable th) {
            w7.e0.n(th);
        }
        try {
            this.f7306b.delete();
        } catch (Throwable th2) {
            w7.e0.n(th2);
        }
        Context context = this.f7305a;
        ab.x xVar = new ab.x(context, 0);
        xVar.j();
        l3.c cVarJ0 = new l3.a(context, this.f7306b, xVar.a()).a().J0();
        try {
            cVarJ0.write(1);
            cVarJ0.write(bArr2);
            cVarJ0.write(bArrC);
            cVarJ0.close();
            q7.k.b(bArrC);
            return new c(strB, bArr2, bArrC);
        } finally {
        }
    }

    public final c b() throws IOException {
        Object objN;
        Object objN2;
        try {
            objN = a();
        } catch (Throwable th) {
            objN = w7.e0.n(th);
        }
        Throwable thA = c7.m.a(objN);
        if (thA != null) {
            File file = this.f7306b;
            Log.w("OpenClawDeviceId", m.x.x("createAndSave failed for ", file.getName(), ": ", thA.getMessage(), "; trying file-only reset"));
            try {
                file.delete();
            } catch (Throwable th2) {
                w7.e0.n(th2);
            }
            try {
                objN2 = a();
            } catch (Throwable th3) {
                objN2 = w7.e0.n(th3);
            }
            Throwable thA2 = c7.m.a(objN2);
            if (thA2 != null) {
                Log.w("OpenClawDeviceId", m.x.x("file-only reset + createAndSave still failed for ", file.getName(), ": ", thA2.getMessage(), "; escalating to full reset"));
                d();
                objN2 = a();
            }
            objN = (c) objN2;
        }
        return (c) objN;
    }

    public final c c() {
        c cVar;
        Object objN;
        c cVarB;
        c cVar2 = this.f7308d;
        if (cVar2 != null) {
            return cVar2;
        }
        synchronized (this.f7307c) {
            try {
                cVar = this.f7308d;
                if (cVar == null) {
                    b0 b0VarE = e();
                    if (b0VarE instanceof a0) {
                        cVarB = ((a0) b0VarE).f7261a;
                    } else if (b0VarE.equals(z.f7710b)) {
                        cVarB = b();
                    } else {
                        if (!b0VarE.equals(z.f7709a)) {
                            throw new a4.u();
                        }
                        Log.w("OpenClawDeviceId", "device key file " + this.f7306b.getName() + " decrypt failed; trying file-only reset first");
                        try {
                            this.f7306b.delete();
                        } catch (Throwable th) {
                            w7.e0.n(th);
                        }
                        try {
                            objN = a();
                        } catch (Throwable th2) {
                            objN = w7.e0.n(th2);
                        }
                        Throwable thA = c7.m.a(objN);
                        if (thA != null) {
                            Log.w("OpenClawDeviceId", "file-only reset + createAndSave failed for " + this.f7306b.getName() + ": " + thA.getMessage() + "; escalating to full reset");
                            d();
                            objN = a();
                        }
                        cVar = (c) objN;
                        this.f7308d = cVar;
                    }
                    cVar = cVarB;
                    this.f7308d = cVar;
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        return cVar;
    }

    public final void d() {
        try {
            this.f7306b.delete();
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
        try {
            this.f7305a.deleteSharedPreferences("__androidx_security_crypto_encrypted_file_pref__");
        } catch (Throwable th3) {
            w7.e0.n(th3);
        }
    }

    public final b0 e() {
        Object objN;
        l3.b bVarI0;
        int i2;
        File file = this.f7306b;
        if (!file.exists()) {
            return z.f7710b;
        }
        try {
            Context context = this.f7305a;
            ab.x xVar = new ab.x(context, 0);
            xVar.j();
            bVarI0 = new l3.a(context, file, xVar.a()).a().I0();
            try {
                i2 = bVarI0.f5830f.read();
            } finally {
            }
        } catch (Throwable th) {
            objN = w7.e0.n(th);
        }
        if (i2 != 1) {
            throw new IllegalArgumentException(("unsupported device key file version: " + i2).toString());
        }
        byte[] bArr = new byte[32];
        bVarI0.read(bArr);
        byte[] bArr2 = new byte[32];
        bVarI0.read(bArr2);
        objN = new a0(new c(a.b(bArr), bArr, bArr2));
        bVarI0.close();
        if (c7.m.a(objN) != null) {
            objN = z.f7709a;
        }
        return (b0) objN;
    }
}
