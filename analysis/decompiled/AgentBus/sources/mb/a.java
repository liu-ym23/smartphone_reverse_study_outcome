package mb;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import q7.k;
import w7.e0;

/* loaded from: classes.dex */
public final class a extends e0 {

    /* renamed from: c, reason: collision with root package name */
    public final b f6517c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(b bVar) {
        super(28);
        k.e(bVar, "trustRootIndex");
        this.f6517c = bVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof a) && k.a(((a) obj).f6517c, this.f6517c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // w7.e0
    public final List h(String str, List list) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateException, NoSuchProviderException, SSLPeerUnverifiedException {
        k.e(list, "chain");
        k.e(str, "hostname");
        ArrayDeque arrayDeque = new ArrayDeque(list);
        ArrayList arrayList = new ArrayList();
        Object objRemoveFirst = arrayDeque.removeFirst();
        k.d(objRemoveFirst, "queue.removeFirst()");
        arrayList.add(objRemoveFirst);
        boolean z4 = false;
        for (int i2 = 0; i2 < 9; i2++) {
            Object obj = arrayList.get(arrayList.size() - 1);
            k.c(obj, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            X509Certificate x509Certificate = (X509Certificate) obj;
            b bVar = this.f6517c;
            bVar.getClass();
            Set set = (Set) bVar.f6518a.get(x509Certificate.getIssuerX500Principal());
            X509Certificate x509Certificate2 = null;
            if (set != null) {
                Iterator it = set.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    try {
                        x509Certificate.verify(((X509Certificate) next).getPublicKey());
                        x509Certificate2 = next;
                        break;
                    } catch (Exception unused) {
                    }
                }
                x509Certificate2 = x509Certificate2;
            }
            if (x509Certificate2 == null) {
                Iterator it2 = arrayDeque.iterator();
                k.d(it2, "queue.iterator()");
                while (it2.hasNext()) {
                    Object next2 = it2.next();
                    k.c(next2, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                    X509Certificate x509Certificate3 = (X509Certificate) next2;
                    if (k.a(x509Certificate.getIssuerDN(), x509Certificate3.getSubjectDN())) {
                        try {
                            x509Certificate.verify(x509Certificate3.getPublicKey());
                            it2.remove();
                            arrayList.add(x509Certificate3);
                        } catch (GeneralSecurityException unused2) {
                            continue;
                        }
                    }
                }
                if (!z4) {
                    throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + x509Certificate);
                }
                return arrayList;
            }
            if (arrayList.size() > 1 || !x509Certificate.equals(x509Certificate2)) {
                arrayList.add(x509Certificate2);
            }
            if (k.a(x509Certificate2.getIssuerDN(), x509Certificate2.getSubjectDN())) {
                try {
                    x509Certificate2.verify(x509Certificate2.getPublicKey());
                    return arrayList;
                } catch (GeneralSecurityException unused3) {
                }
            }
            z4 = true;
        }
        throw new SSLPeerUnverifiedException("Certificate chain too long: " + arrayList);
    }

    public final int hashCode() {
        return this.f6517c.hashCode();
    }
}
