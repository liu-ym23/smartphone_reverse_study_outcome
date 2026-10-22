package f8;

import android.text.TextUtils;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

/* loaded from: classes.dex */
public final class x implements m3.c, x2.l {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f3519f;

    /* renamed from: g, reason: collision with root package name */
    public final String f3520g;

    public /* synthetic */ x(String str, int i2) {
        this.f3519f = i2;
        this.f3520g = str;
    }

    @Override // m3.c
    public String a() {
        return this.f3520g;
    }

    @Override // m3.c
    public void b(m3.b bVar) {
    }

    @Override // x2.l
    public boolean f(CharSequence charSequence, int i2, int i10, x2.q qVar) {
        if (!TextUtils.equals(charSequence.subSequence(i2, i10), this.f3520g)) {
            return true;
        }
        qVar.f11148c = (qVar.f11148c & 3) | 4;
        return false;
    }

    @Override // x2.l
    public Object getResult() {
        return this;
    }

    public String toString() throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        boolean zContainsAlias;
        switch (this.f3519f) {
            case 0:
                return this.f3520g;
            case 1:
                StringBuilder sb2 = new StringBuilder("MasterKey{keyAlias=");
                String str = this.f3520g;
                sb2.append(str);
                sb2.append(", isKeyStoreBacked=");
                try {
                    KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
                    keyStore.load(null);
                    zContainsAlias = keyStore.containsAlias(str);
                } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException unused) {
                    zContainsAlias = false;
                }
                sb2.append(zContainsAlias);
                sb2.append("}");
                return sb2.toString();
            case 2:
            default:
                return super.toString();
            case 3:
                return a1.a.l(new StringBuilder("<"), this.f3520g, '>');
        }
    }

    public x(String str) {
        this.f3519f = 2;
        q7.k.e(str, "query");
        this.f3520g = str;
    }

    public x(Object obj, String str) {
        this.f3519f = 1;
        this.f3520g = str;
    }
}
