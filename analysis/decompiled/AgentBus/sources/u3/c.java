package u3;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Iterator;
import w7.e0;

/* loaded from: classes.dex */
public final class c implements t3.a {

    /* renamed from: a, reason: collision with root package name */
    public final i5.l f10002a;

    /* renamed from: b, reason: collision with root package name */
    public final s9.d f10003b;

    /* renamed from: c, reason: collision with root package name */
    public final s9.d f10004c;

    public c(i5.l lVar) {
        this.f10002a = lVar;
        boolean zIsEmpty = ((d4.a) lVar.f4689i).f2837a.isEmpty();
        s9.d dVar = a4.q.f198a;
        if (zIsEmpty) {
            this.f10003b = dVar;
            this.f10004c = dVar;
            return;
        }
        a4.g gVar = (a4.g) a4.h.f177b.f179a.get();
        gVar = gVar == null ? a4.h.f178c : gVar;
        a4.q.a(lVar);
        gVar.getClass();
        this.f10003b = dVar;
        this.f10004c = dVar;
    }

    @Override // t3.a
    public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        s9.d dVar = this.f10003b;
        t3.k kVar = (t3.k) this.f10002a.f4688h;
        try {
            byte[] bArr3 = kVar.f9719c;
            byte[] bArrK = e0.k(bArr3 == null ? null : Arrays.copyOf(bArr3, bArr3.length), ((t3.a) kVar.f9718b).a(bArr, bArr2));
            int i2 = kVar.f9722f;
            int length = bArr.length;
            dVar.getClass();
            return bArrK;
        } catch (GeneralSecurityException e10) {
            dVar.getClass();
            throw e10;
        }
    }

    @Override // t3.a
    public final byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        i5.l lVar = this.f10002a;
        s9.d dVar = this.f10004c;
        if (length > 5) {
            byte[] bArrCopyOf = Arrays.copyOf(bArr, 5);
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 5, bArr.length);
            Iterator it = lVar.B(bArrCopyOf).iterator();
            while (it.hasNext()) {
                try {
                    byte[] bArrB = ((t3.a) ((t3.k) it.next()).f9718b).b(bArrCopyOfRange, bArr2);
                    dVar.getClass();
                    return bArrB;
                } catch (GeneralSecurityException e10) {
                    d.f10005a.info("ciphertext prefix matches a key, but cannot decrypt: " + e10);
                }
            }
        }
        Iterator it2 = lVar.B(t3.b.f9705a).iterator();
        while (it2.hasNext()) {
            try {
                byte[] bArrB2 = ((t3.a) ((t3.k) it2.next()).f9718b).b(bArr, bArr2);
                dVar.getClass();
                return bArrB2;
            } catch (GeneralSecurityException unused) {
            }
        }
        dVar.getClass();
        throw new GeneralSecurityException("decryption failed");
    }
}
