package h4;

import ia.d0;
import ia.f1;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import m.a0;
import m.b0;
import m.c0;

/* loaded from: classes.dex */
public final class a implements w, n.e {

    /* renamed from: a, reason: collision with root package name */
    public long f4099a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f4100b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f4101c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f4102d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f4103e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f4104f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f4105g;

    /* renamed from: h, reason: collision with root package name */
    public Object f4106h;

    public a(String str, i5.l lVar, d5.l lVar2, k5.q qVar, long j2, k5.a aVar, k5.t tVar) {
        q7.k.e(lVar2, "pool");
        q7.k.e(qVar, "internalBus");
        q7.k.e(aVar, "dispatchers");
        q7.k.e(tVar, "logger");
        this.f4100b = str;
        this.f4101c = lVar;
        this.f4102d = lVar2;
        this.f4103e = qVar;
        this.f4099a = j2;
        this.f4104f = tVar;
        this.f4105g = d0.b(f1.plus(d0.c(), aVar.f5618c));
    }

    @Override // n.e
    public boolean a() {
        return false;
    }

    @Override // h4.w
    public synchronized void b(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3) {
        int iPosition = byteBuffer3.position();
        byte[] bArrI = b.i((b) this.f4106h, (byte[]) this.f4104f, this.f4099a, false);
        ((Cipher) this.f4102d).init(1, (SecretKeySpec) this.f4100b, new IvParameterSpec(bArrI));
        this.f4099a++;
        ((Cipher) this.f4102d).update(byteBuffer, byteBuffer3);
        ((Cipher) this.f4102d).doFinal(byteBuffer2, byteBuffer3);
        ByteBuffer byteBufferDuplicate = byteBuffer3.duplicate();
        byteBufferDuplicate.flip();
        byteBufferDuplicate.position(iPosition);
        ((Mac) this.f4103e).init((SecretKeySpec) this.f4101c);
        ((Mac) this.f4103e).update(bArrI);
        ((Mac) this.f4103e).update(byteBufferDuplicate);
        byteBuffer3.put(((Mac) this.f4103e).doFinal(), 0, ((b) this.f4106h).f4109c);
    }

    @Override // n.e
    public Object c(long j2) {
        if (i(j2)) {
            return this.f4106h;
        }
        p7.k kVar = (p7.k) ((q6.b) this.f4101c).f8787g;
        i5.f fVar = (i5.f) this.f4100b;
        n.n nVar = (n.n) this.f4103e;
        n.n nVar2 = (n.n) this.f4104f;
        if (((n.n) fVar.f4654h) == null) {
            fVar.f4654h = nVar.c();
        }
        n.n nVar3 = (n.n) fVar.f4654h;
        if (nVar3 == null) {
            q7.k.j("valueVector");
            throw null;
        }
        int iB = nVar3.b();
        for (int i2 = 0; i2 < iB; i2++) {
            n.n nVar4 = (n.n) fVar.f4654h;
            if (nVar4 == null) {
                q7.k.j("valueVector");
                throw null;
            }
            a7.d dVar = (a7.d) fVar.f4653g;
            float fA = nVar.a(i2);
            long j4 = j2 / 1000000;
            a0 a0VarA = ((b0) dVar.f411g).a(nVar2.a(i2));
            long j10 = a0VarA.f6040c;
            nVar4.e(i2, (Math.signum(a0VarA.f6038a) * a0VarA.f6039b * m.b.a(j10 > 0 ? j4 / j10 : 1.0f).f6036a) + fA);
        }
        n.n nVar5 = (n.n) fVar.f4654h;
        if (nVar5 != null) {
            return kVar.invoke(nVar5);
        }
        q7.k.j("valueVector");
        throw null;
    }

    @Override // n.e
    public long d() {
        return this.f4099a;
    }

    @Override // n.e
    public q6.b e() {
        return (q6.b) this.f4101c;
    }

    @Override // n.e
    public Object f() {
        return this.f4106h;
    }

    @Override // n.e
    public n.n g(long j2) {
        return !i(j2) ? ((i5.f) this.f4100b).J(j2, (n.n) this.f4103e, (n.n) this.f4104f) : (n.n) this.f4105g;
    }

    @Override // h4.w
    public ByteBuffer h() {
        return ((ByteBuffer) this.f4105g).asReadOnlyBuffer();
    }

    @Override // h4.w
    public synchronized void j(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        int iPosition = byteBuffer2.position();
        byte[] bArrI = b.i((b) this.f4106h, (byte[]) this.f4104f, this.f4099a, true);
        ((Cipher) this.f4102d).init(1, (SecretKeySpec) this.f4100b, new IvParameterSpec(bArrI));
        this.f4099a++;
        ((Cipher) this.f4102d).doFinal(byteBuffer, byteBuffer2);
        ByteBuffer byteBufferDuplicate = byteBuffer2.duplicate();
        byteBufferDuplicate.flip();
        byteBufferDuplicate.position(iPosition);
        ((Mac) this.f4103e).init((SecretKeySpec) this.f4101c);
        ((Mac) this.f4103e).update(bArrI);
        ((Mac) this.f4103e).update(byteBufferDuplicate);
        byteBuffer2.put(((Mac) this.f4103e).doFinal(), 0, ((b) this.f4106h).f4109c);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object k(i7.c r26) {
        /*
            Method dump skipped, instructions count: 630
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h4.a.k(i7.c):java.lang.Object");
    }

    public a(a7.d dVar, q6.b bVar, Object obj, n.n nVar) {
        i5.f fVar = new i5.f(13, (a7.d) dVar.f411g);
        this.f4100b = fVar;
        this.f4101c = bVar;
        this.f4102d = obj;
        n.n nVar2 = (n.n) ((p7.k) bVar.f8788h).invoke(obj);
        this.f4103e = nVar2;
        this.f4104f = n.d.e(nVar);
        p7.k kVar = (p7.k) bVar.f8787g;
        if (((n.n) fVar.f4656j) == null) {
            fVar.f4656j = nVar2.c();
        }
        n.n nVar3 = (n.n) fVar.f4656j;
        if (nVar3 != null) {
            int iB = nVar3.b();
            int i2 = 0;
            while (i2 < iB) {
                n.n nVar4 = (n.n) fVar.f4656j;
                if (nVar4 == null) {
                    q7.k.j("targetVector");
                    throw null;
                }
                a7.d dVar2 = (a7.d) fVar.f4653g;
                float fA = nVar2.a(i2);
                float fA2 = nVar.a(i2);
                double dB = ((b0) dVar2.f411g).b(fA2);
                double d6 = c0.f6046a;
                int i10 = i2;
                nVar4.e(i10, (Math.signum(fA2) * ((float) (Math.exp((d6 / (d6 - 1.0d)) * dB) * r13.f6042a * r13.f6043b))) + fA);
                i2 = i10 + 1;
            }
            n.n nVar5 = (n.n) fVar.f4656j;
            if (nVar5 != null) {
                this.f4106h = kVar.invoke(nVar5);
                i5.f fVar2 = (i5.f) this.f4100b;
                n.n nVar6 = (n.n) this.f4103e;
                if (((n.n) fVar2.f4655i) == null) {
                    fVar2.f4655i = nVar6.c();
                }
                n.n nVar7 = (n.n) fVar2.f4655i;
                if (nVar7 != null) {
                    int iB2 = nVar7.b();
                    long jMax = 0;
                    for (int i11 = 0; i11 < iB2; i11++) {
                        a7.d dVar3 = (a7.d) fVar2.f4653g;
                        nVar6.getClass();
                        jMax = Math.max(jMax, ((long) (Math.exp(((b0) dVar3.f411g).b(nVar.a(i11)) / (c0.f6046a - 1.0d)) * 1000.0d)) * 1000000);
                    }
                    this.f4099a = jMax;
                    n.n nVarE = n.d.e(((i5.f) this.f4100b).J(jMax, (n.n) this.f4103e, nVar));
                    this.f4105g = nVarE;
                    int iB3 = nVarE.b();
                    for (int i12 = 0; i12 < iB3; i12++) {
                        n.n nVar8 = (n.n) this.f4105g;
                        float fA3 = nVar8.a(i12);
                        ((i5.f) this.f4100b).getClass();
                        ((i5.f) this.f4100b).getClass();
                        nVar8.e(i12, nb.i.j(fA3, -0.0f, 0.0f));
                    }
                    return;
                }
                q7.k.j("velocityVector");
                throw null;
            }
            q7.k.j("targetVector");
            throw null;
        }
        q7.k.j("targetVector");
        throw null;
    }

    public a(b bVar, byte[] bArr) throws IllegalStateException, GeneralSecurityException {
        this.f4106h = bVar;
        this.f4099a = 0L;
        this.f4102d = (Cipher) m.f4149b.f4151a.a("AES/CTR/NoPadding");
        m mVar = m.f4150c;
        String str = bVar.f4108b;
        this.f4103e = (Mac) mVar.f4151a.a(str);
        this.f4099a = 0L;
        int i2 = bVar.f4107a;
        byte[] bArrA = u.a(i2);
        byte[] bArrA2 = u.a(7);
        this.f4104f = bArrA2;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bVar.e());
        this.f4105g = byteBufferAllocate;
        byteBufferAllocate.put((byte) bVar.e());
        byteBufferAllocate.put(bArrA);
        byteBufferAllocate.put(bArrA2);
        byteBufferAllocate.flip();
        byte[] bArrP = ib.c.p(bVar.f4112f, bVar.f4113g, bArrA, bArr, i2 + 32);
        this.f4100b = new SecretKeySpec(bArrP, 0, i2, "AES");
        this.f4101c = new SecretKeySpec(bArrP, i2, 32, str);
    }
}
