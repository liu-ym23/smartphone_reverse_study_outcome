package d2;

import f2.g;
import f2.h;
import f2.q;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Iterator;
import k4.v;
import y1.k;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e implements y1.c {

    /* renamed from: a, reason: collision with root package name */
    public final a4.d f1787a;

    /* renamed from: b, reason: collision with root package name */
    public final t1.f f1788b;

    /* renamed from: c, reason: collision with root package name */
    public final t1.f f1789c;

    public e(a4.d dVar) throws GeneralSecurityException {
        this.f1787a = dVar;
        boolean zIsEmpty = ((i2.a) dVar.d).f3138a.isEmpty();
        t1.f fVar = q.f2578a;
        if (zIsEmpty) {
            this.f1788b = fVar;
            this.f1789c = fVar;
            return;
        }
        g gVar = (g) h.f2558b.f2560a.get();
        gVar = gVar == null ? h.f2559c : gVar;
        q.a(dVar);
        gVar.getClass();
        this.f1788b = fVar;
        this.f1789c = fVar;
    }

    @Override // y1.c
    public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        t1.f fVar = this.f1788b;
        k kVar = (k) this.f1787a.f97c;
        try {
            byte[] bArr3 = kVar.f6324c;
            byte[] bArrQ = v.q(bArr3 == null ? null : Arrays.copyOf(bArr3, bArr3.length), ((y1.c) kVar.f6323b).a(bArr, bArr2));
            int i8 = kVar.f6326f;
            fVar.getClass();
            return bArrQ;
        } catch (GeneralSecurityException e9) {
            fVar.getClass();
            throw e9;
        }
    }

    @Override // y1.c
    public final byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        a4.d dVar = this.f1787a;
        t1.f fVar = this.f1789c;
        if (length > 5) {
            byte[] bArrCopyOf = Arrays.copyOf(bArr, 5);
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 5, bArr.length);
            Iterator it = dVar.x(bArrCopyOf).iterator();
            while (it.hasNext()) {
                try {
                    byte[] bArrB = ((y1.c) ((k) it.next()).f6323b).b(bArrCopyOfRange, bArr2);
                    fVar.getClass();
                    return bArrB;
                } catch (GeneralSecurityException e9) {
                    f.f1790a.info("ciphertext prefix matches a key, but cannot decrypt: " + e9);
                }
            }
        }
        Iterator it2 = dVar.x(y1.b.f6311a).iterator();
        while (it2.hasNext()) {
            try {
                byte[] bArrB2 = ((y1.c) ((k) it2.next()).f6323b).b(bArr, bArr2);
                fVar.getClass();
                return bArrB2;
            } catch (GeneralSecurityException unused) {
            }
        }
        fVar.getClass();
        throw new GeneralSecurityException("decryption failed");
    }
}
