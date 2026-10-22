package g2;

import f2.q;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Iterator;
import k2.q1;
import k4.v;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class o implements y1.j {

    /* renamed from: a, reason: collision with root package name */
    public final a4.d f2944a;

    /* renamed from: b, reason: collision with root package name */
    public final t1.f f2945b;

    /* renamed from: c, reason: collision with root package name */
    public final t1.f f2946c;

    public o(a4.d dVar) throws GeneralSecurityException {
        this.f2944a = dVar;
        boolean zIsEmpty = ((i2.a) dVar.d).f3138a.isEmpty();
        t1.f fVar = q.f2578a;
        if (zIsEmpty) {
            this.f2945b = fVar;
            this.f2946c = fVar;
            return;
        }
        f2.g gVar = (f2.g) f2.h.f2558b.f2560a.get();
        gVar = gVar == null ? f2.h.f2559c : gVar;
        q.a(dVar);
        gVar.getClass();
        this.f2945b = fVar;
        this.f2946c = fVar;
    }

    @Override // y1.j
    public final void a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        t1.f fVar = this.f2946c;
        if (length <= 5) {
            fVar.getClass();
            throw new GeneralSecurityException("tag too short");
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, 5);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 5, bArr.length);
        a4.d dVar = this.f2944a;
        for (y1.k kVar : dVar.x(bArrCopyOf)) {
            try {
                ((y1.j) kVar.f6323b).a(bArrCopyOfRange, kVar.f6325e.equals(q1.LEGACY) ? v.q(bArr2, p.f2948b) : bArr2);
                fVar.getClass();
                return;
            } catch (GeneralSecurityException e9) {
                p.f2947a.info("tag prefix matches a key, but cannot verify: " + e9);
            }
        }
        Iterator it = dVar.x(y1.b.f6311a).iterator();
        while (it.hasNext()) {
            try {
                ((y1.j) ((y1.k) it.next()).f6323b).a(bArr, bArr2);
                fVar.getClass();
                return;
            } catch (GeneralSecurityException unused) {
            }
        }
        fVar.getClass();
        throw new GeneralSecurityException("invalid MAC");
    }

    @Override // y1.j
    public final byte[] b(byte[] bArr) throws GeneralSecurityException {
        t1.f fVar = this.f2945b;
        y1.k kVar = (y1.k) this.f2944a.f97c;
        if (kVar.f6325e.equals(q1.LEGACY)) {
            bArr = v.q(bArr, p.f2948b);
        }
        try {
            byte[] bArr2 = kVar.f6324c;
            byte[] bArrQ = v.q(bArr2 == null ? null : Arrays.copyOf(bArr2, bArr2.length), ((y1.j) kVar.f6323b).b(bArr));
            int i8 = kVar.f6326f;
            fVar.getClass();
            return bArrQ;
        } catch (GeneralSecurityException e9) {
            fVar.getClass();
            throw e9;
        }
    }
}
