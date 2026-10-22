package b4;

import f4.c2;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Iterator;
import w7.e0;

/* loaded from: classes.dex */
public final class r implements t3.j {

    /* renamed from: a, reason: collision with root package name */
    public final i5.l f1526a;

    /* renamed from: b, reason: collision with root package name */
    public final s9.d f1527b;

    /* renamed from: c, reason: collision with root package name */
    public final s9.d f1528c;

    public r(i5.l lVar) {
        this.f1526a = lVar;
        boolean zIsEmpty = ((d4.a) lVar.f4689i).f2837a.isEmpty();
        s9.d dVar = a4.q.f198a;
        if (zIsEmpty) {
            this.f1527b = dVar;
            this.f1528c = dVar;
            return;
        }
        a4.g gVar = (a4.g) a4.h.f177b.f179a.get();
        gVar = gVar == null ? a4.h.f178c : gVar;
        a4.q.a(lVar);
        gVar.getClass();
        this.f1527b = dVar;
        this.f1528c = dVar;
    }

    @Override // t3.j
    public final void a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        s9.d dVar = this.f1528c;
        if (length <= 5) {
            dVar.getClass();
            throw new GeneralSecurityException("tag too short");
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, 5);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 5, bArr.length);
        i5.l lVar = this.f1526a;
        for (t3.k kVar : lVar.B(bArrCopyOf)) {
            try {
                ((t3.j) kVar.f9718b).a(bArrCopyOfRange, kVar.f9721e.equals(c2.LEGACY) ? e0.k(bArr2, s.f1530b) : bArr2);
                dVar.getClass();
                return;
            } catch (GeneralSecurityException e10) {
                s.f1529a.info("tag prefix matches a key, but cannot verify: " + e10);
            }
        }
        Iterator it = lVar.B(t3.b.f9705a).iterator();
        while (it.hasNext()) {
            try {
                ((t3.j) ((t3.k) it.next()).f9718b).a(bArr, bArr2);
                dVar.getClass();
                return;
            } catch (GeneralSecurityException unused) {
            }
        }
        dVar.getClass();
        throw new GeneralSecurityException("invalid MAC");
    }

    @Override // t3.j
    public final byte[] b(byte[] bArr) throws GeneralSecurityException {
        s9.d dVar = this.f1527b;
        t3.k kVar = (t3.k) this.f1526a.f4688h;
        if (kVar.f9721e.equals(c2.LEGACY)) {
            bArr = e0.k(bArr, s.f1530b);
        }
        try {
            byte[] bArr2 = kVar.f9719c;
            byte[] bArrK = e0.k(bArr2 == null ? null : Arrays.copyOf(bArr2, bArr2.length), ((t3.j) kVar.f9718b).b(bArr));
            int i2 = kVar.f9722f;
            dVar.getClass();
            return bArrK;
        } catch (GeneralSecurityException e10) {
            dVar.getClass();
            throw e10;
        }
    }
}
