package y3;

import a4.g;
import a4.h;
import a4.q;
import i5.l;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Iterator;
import s9.d;
import t3.k;
import w7.e0;

/* loaded from: classes.dex */
public final class b implements t3.c {

    /* renamed from: a, reason: collision with root package name */
    public final l f11547a;

    /* renamed from: b, reason: collision with root package name */
    public final d f11548b;

    /* renamed from: c, reason: collision with root package name */
    public final d f11549c;

    public b(l lVar) {
        this.f11547a = lVar;
        boolean zIsEmpty = ((d4.a) lVar.f4689i).f2837a.isEmpty();
        d dVar = q.f198a;
        if (zIsEmpty) {
            this.f11548b = dVar;
            this.f11549c = dVar;
            return;
        }
        g gVar = (g) h.f177b.f179a.get();
        gVar = gVar == null ? h.f178c : gVar;
        q.a(lVar);
        gVar.getClass();
        this.f11548b = dVar;
        this.f11549c = dVar;
    }

    @Override // t3.c
    public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        d dVar = this.f11548b;
        k kVar = (k) this.f11547a.f4688h;
        try {
            byte[] bArr3 = kVar.f9719c;
            byte[] bArrK = e0.k(bArr3 == null ? null : Arrays.copyOf(bArr3, bArr3.length), ((t3.c) kVar.f9718b).a(bArr, bArr2));
            int i2 = kVar.f9722f;
            dVar.getClass();
            return bArrK;
        } catch (GeneralSecurityException e10) {
            dVar.getClass();
            throw e10;
        }
    }

    @Override // t3.c
    public final byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        l lVar = this.f11547a;
        d dVar = this.f11549c;
        if (length > 5) {
            byte[] bArrCopyOf = Arrays.copyOf(bArr, 5);
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 5, bArr.length);
            Iterator it = lVar.B(bArrCopyOf).iterator();
            while (it.hasNext()) {
                try {
                    byte[] bArrB = ((t3.c) ((k) it.next()).f9718b).b(bArrCopyOfRange, bArr2);
                    dVar.getClass();
                    return bArrB;
                } catch (GeneralSecurityException e10) {
                    c.f11550a.info("ciphertext prefix matches a key, but cannot decrypt: " + e10);
                }
            }
        }
        Iterator it2 = lVar.B(t3.b.f9705a).iterator();
        while (it2.hasNext()) {
            try {
                byte[] bArrB2 = ((t3.c) ((k) it2.next()).f9718b).b(bArr, bArr2);
                dVar.getClass();
                return bArrB2;
            } catch (GeneralSecurityException unused) {
            }
        }
        dVar.getClass();
        throw new GeneralSecurityException("decryption failed");
    }
}
