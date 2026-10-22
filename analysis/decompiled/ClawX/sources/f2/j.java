package f2;

import a1.w;
import com.google.crypto.tink.shaded.protobuf.c0;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;
import k2.b0;
import k2.j0;
import k2.q0;
import k2.q1;
import k2.t1;
import k2.w0;
import k2.x;
import org.bouncycastle.asn1.BERTags;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: b, reason: collision with root package name */
    public static final j f2563b = new j();

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f2564a = new AtomicReference(new t(new w(3)));

    public final y1.b a(p pVar) {
        z1.f fVar;
        z1.f fVar2;
        AtomicReference atomicReference = this.f2564a;
        t tVar = (t) atomicReference.get();
        tVar.getClass();
        m2.a aVar = (m2.a) pVar.f2574b;
        if (!tVar.f2584b.containsKey(new r(p.class, aVar))) {
            try {
                f fVar3 = new f();
                ((w0) pVar.d).ordinal();
                return fVar3;
            } catch (GeneralSecurityException e9) {
                throw new a6.w("Creating a LegacyProtoKey failed", e9);
            }
        }
        t tVar2 = (t) atomicReference.get();
        tVar2.getClass();
        r rVar = new r(p.class, aVar);
        HashMap map = tVar2.f2584b;
        if (!map.containsKey(rVar)) {
            throw new GeneralSecurityException("No Key Parser for requested key type " + rVar + " available");
        }
        switch (((a) map.get(rVar)).f2550b.f39a) {
            case 9:
                if (!((String) pVar.f2573a).equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
                    throw new IllegalArgumentException("Wrong type URL in call to AesCmacParameters.parseParameters");
                }
                try {
                    k2.b bVarD = k2.b.D((com.google.crypto.tink.shaded.protobuf.i) pVar.f2575c, com.google.crypto.tink.shaded.protobuf.o.a());
                    if (bVarD.B() != 0) {
                        throw new GeneralSecurityException("Only version 0 keys are accepted");
                    }
                    a4.d dVar = new a4.d(4);
                    dVar.f96b = null;
                    dVar.f97c = null;
                    dVar.d = g2.c.f2918f;
                    dVar.J(bVarD.z().size());
                    int iY = bVarD.A().y();
                    if (iY < 10 || 16 < iY) {
                        throw new GeneralSecurityException(a8.b.j(iY, "Invalid tag size for AesCmacParameters: "));
                    }
                    dVar.f97c = Integer.valueOf(iY);
                    dVar.d = g2.e.a((q1) pVar.f2576e);
                    g2.d dVarH = dVar.h();
                    a4.d dVar2 = new a4.d(3);
                    dVar2.f97c = null;
                    dVar2.d = null;
                    dVar2.f96b = dVarH;
                    dVar2.f97c = new androidx.emoji2.text.m(m2.a.a(bVarD.z().j()));
                    dVar2.d = (Integer) pVar.f2577f;
                    return dVar2.g();
                } catch (c0 | IllegalArgumentException unused) {
                    throw new GeneralSecurityException("Parsing AesCmacKey failed");
                }
            case 10:
            case 12:
            case BERTags.RELATIVE_OID /* 13 */:
            default:
                if (!((String) pVar.f2573a).equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
                    throw new IllegalArgumentException("Wrong type URL in call to XChaCha20Poly1305Parameters.parseParameters");
                }
                try {
                    t1 t1VarB = t1.B((com.google.crypto.tink.shaded.protobuf.i) pVar.f2575c, com.google.crypto.tink.shaded.protobuf.o.a());
                    if (t1VarB.z() != 0) {
                        throw new GeneralSecurityException("Only version 0 keys are accepted");
                    }
                    q1 q1Var = (q1) pVar.f2576e;
                    int iOrdinal = q1Var.ordinal();
                    if (iOrdinal == 1) {
                        fVar2 = z1.f.f6379o;
                    } else if (iOrdinal == 2) {
                        fVar2 = z1.f.f6380p;
                    } else if (iOrdinal == 3) {
                        fVar2 = z1.f.f6381q;
                    } else {
                        if (iOrdinal != 4) {
                            throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + q1Var.b());
                        }
                        fVar2 = z1.f.f6380p;
                    }
                    return z1.s.b(fVar2, new androidx.emoji2.text.m(m2.a.a(t1VarB.y().j())), (Integer) pVar.f2577f);
                } catch (c0 unused2) {
                    throw new GeneralSecurityException("Parsing XChaCha20Poly1305Key failed");
                }
            case BERTags.EMBEDDED_PDV /* 11 */:
                if (!((String) pVar.f2573a).equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
                    throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseKey");
                }
                try {
                    q0 q0VarE = q0.E((com.google.crypto.tink.shaded.protobuf.i) pVar.f2575c, com.google.crypto.tink.shaded.protobuf.o.a());
                    if (q0VarE.C() != 0) {
                        throw new GeneralSecurityException("Only version 0 keys are accepted");
                    }
                    w wVar = new w(4);
                    wVar.f75b = null;
                    wVar.f76c = null;
                    wVar.d = null;
                    wVar.f77e = g2.c.f2927o;
                    wVar.f75b = Integer.valueOf(q0VarE.A().size());
                    wVar.f76c = Integer.valueOf(q0VarE.B().A());
                    wVar.d = g2.k.a(q0VarE.B().z());
                    wVar.f77e = g2.k.b((q1) pVar.f2576e);
                    g2.j jVarB = wVar.b();
                    a4.d dVar3 = new a4.d(5);
                    dVar3.f97c = null;
                    dVar3.d = null;
                    dVar3.f96b = jVarB;
                    dVar3.f97c = new androidx.emoji2.text.m(m2.a.a(q0VarE.A().j()));
                    dVar3.d = (Integer) pVar.f2577f;
                    return dVar3.i();
                } catch (c0 | IllegalArgumentException unused3) {
                    throw new GeneralSecurityException("Parsing HmacKey failed");
                }
            case BERTags.TIME /* 14 */:
                if (!((String) pVar.f2573a).equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
                    throw new IllegalArgumentException("Wrong type URL in call to AesEaxParameters.parseParameters");
                }
                try {
                    k2.r rVarD = k2.r.D((com.google.crypto.tink.shaded.protobuf.i) pVar.f2575c, com.google.crypto.tink.shaded.protobuf.o.a());
                    if (rVarD.B() != 0) {
                        throw new GeneralSecurityException("Only version 0 keys are accepted");
                    }
                    z1.f fVar4 = z1.f.f6369e;
                    int size = rVarD.z().size();
                    if (size != 16 && size != 24 && size != 32) {
                        throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", Integer.valueOf(size)));
                    }
                    int iY2 = rVarD.A().y();
                    if (iY2 != 12 && iY2 != 16) {
                        throw new GeneralSecurityException(String.format("Invalid IV size in bytes %d; acceptable values have 12 or 16 bytes", Integer.valueOf(iY2)));
                    }
                    q1 q1Var2 = (q1) pVar.f2576e;
                    int iOrdinal2 = q1Var2.ordinal();
                    if (iOrdinal2 == 1) {
                        fVar4 = z1.f.f6368c;
                    } else if (iOrdinal2 == 2) {
                        fVar4 = z1.f.d;
                    } else if (iOrdinal2 != 3) {
                        if (iOrdinal2 != 4) {
                            throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + q1Var2.b());
                        }
                        fVar4 = z1.f.d;
                    }
                    z1.g gVar = new z1.g(size, iY2, 16, fVar4);
                    a4.d dVar4 = new a4.d(16);
                    dVar4.f97c = null;
                    dVar4.d = null;
                    dVar4.f96b = gVar;
                    dVar4.f97c = new androidx.emoji2.text.m(m2.a.a(rVarD.z().j()));
                    dVar4.d = (Integer) pVar.f2577f;
                    return dVar4.j();
                } catch (c0 unused4) {
                    throw new GeneralSecurityException("Parsing AesEaxcKey failed");
                }
            case 15:
                if (!((String) pVar.f2573a).equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
                    throw new IllegalArgumentException("Wrong type URL in call to AesGcmParameters.parseParameters");
                }
                try {
                    x xVarB = x.B((com.google.crypto.tink.shaded.protobuf.i) pVar.f2575c, com.google.crypto.tink.shaded.protobuf.o.a());
                    if (xVarB.z() != 0) {
                        throw new GeneralSecurityException("Only version 0 keys are accepted");
                    }
                    z1.f fVar5 = z1.f.f6372h;
                    int size2 = xVarB.y().size();
                    if (size2 != 16 && size2 != 24 && size2 != 32) {
                        throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", Integer.valueOf(size2)));
                    }
                    q1 q1Var3 = (q1) pVar.f2576e;
                    int iOrdinal3 = q1Var3.ordinal();
                    if (iOrdinal3 == 1) {
                        fVar5 = z1.f.f6370f;
                    } else if (iOrdinal3 == 2) {
                        fVar5 = z1.f.f6371g;
                    } else if (iOrdinal3 != 3) {
                        if (iOrdinal3 != 4) {
                            throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + q1Var3.b());
                        }
                        fVar5 = z1.f.f6371g;
                    }
                    z1.j jVar = new z1.j(size2, 12, 16, fVar5);
                    a4.d dVar5 = new a4.d(17);
                    dVar5.f97c = null;
                    dVar5.d = null;
                    dVar5.f96b = jVar;
                    dVar5.f97c = new androidx.emoji2.text.m(m2.a.a(xVarB.y().j()));
                    dVar5.d = (Integer) pVar.f2577f;
                    return dVar5.k();
                } catch (c0 unused5) {
                    throw new GeneralSecurityException("Parsing AesGcmKey failed");
                }
            case 16:
                if (!((String) pVar.f2573a).equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
                    throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivParameters.parseParameters");
                }
                try {
                    b0 b0VarB = b0.B((com.google.crypto.tink.shaded.protobuf.i) pVar.f2575c, com.google.crypto.tink.shaded.protobuf.o.a());
                    if (b0VarB.z() != 0) {
                        throw new GeneralSecurityException("Only version 0 keys are accepted");
                    }
                    z1.f fVar6 = z1.f.f6375k;
                    int size3 = b0VarB.y().size();
                    if (size3 != 16 && size3 != 32) {
                        throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte and 32-byte AES keys are supported", Integer.valueOf(size3)));
                    }
                    q1 q1Var4 = (q1) pVar.f2576e;
                    int iOrdinal4 = q1Var4.ordinal();
                    if (iOrdinal4 == 1) {
                        fVar6 = z1.f.f6373i;
                    } else if (iOrdinal4 == 2) {
                        fVar6 = z1.f.f6374j;
                    } else if (iOrdinal4 != 3) {
                        if (iOrdinal4 != 4) {
                            throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + q1Var4.b());
                        }
                        fVar6 = z1.f.f6374j;
                    }
                    z1.m mVar = new z1.m(size3, fVar6);
                    a4.d dVar6 = new a4.d(18);
                    dVar6.f97c = null;
                    dVar6.d = null;
                    dVar6.f96b = mVar;
                    dVar6.f97c = new androidx.emoji2.text.m(m2.a.a(b0VarB.y().j()));
                    dVar6.d = (Integer) pVar.f2577f;
                    return dVar6.l();
                } catch (c0 unused6) {
                    throw new GeneralSecurityException("Parsing AesGcmSivKey failed");
                }
            case 17:
                if (!((String) pVar.f2573a).equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
                    throw new IllegalArgumentException("Wrong type URL in call to ChaCha20Poly1305Parameters.parseParameters");
                }
                try {
                    j0 j0VarB = j0.B((com.google.crypto.tink.shaded.protobuf.i) pVar.f2575c, com.google.crypto.tink.shaded.protobuf.o.a());
                    if (j0VarB.z() != 0) {
                        throw new GeneralSecurityException("Only version 0 keys are accepted");
                    }
                    q1 q1Var5 = (q1) pVar.f2576e;
                    int iOrdinal5 = q1Var5.ordinal();
                    if (iOrdinal5 == 1) {
                        fVar = z1.f.f6376l;
                    } else if (iOrdinal5 == 2) {
                        fVar = z1.f.f6377m;
                    } else if (iOrdinal5 == 3) {
                        fVar = z1.f.f6378n;
                    } else {
                        if (iOrdinal5 != 4) {
                            throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + q1Var5.b());
                        }
                        fVar = z1.f.f6377m;
                    }
                    return z1.o.b(fVar, new androidx.emoji2.text.m(m2.a.a(j0VarB.y().j())), (Integer) pVar.f2577f);
                } catch (c0 unused7) {
                    throw new GeneralSecurityException("Parsing ChaCha20Poly1305Key failed");
                }
        }
    }

    public final synchronized void b(a aVar) {
        w wVar = new w((t) this.f2564a.get());
        wVar.k(aVar);
        this.f2564a.set(new t(wVar));
    }

    public final synchronized void c(b bVar) {
        w wVar = new w((t) this.f2564a.get());
        wVar.l(bVar);
        this.f2564a.set(new t(wVar));
    }

    public final synchronized void d(k kVar) {
        w wVar = new w((t) this.f2564a.get());
        wVar.m(kVar);
        this.f2564a.set(new t(wVar));
    }

    public final synchronized void e(l lVar) {
        w wVar = new w((t) this.f2564a.get());
        wVar.n(lVar);
        this.f2564a.set(new t(wVar));
    }
}
