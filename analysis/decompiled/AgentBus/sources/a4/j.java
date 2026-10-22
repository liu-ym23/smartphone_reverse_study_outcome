package a4;

import com.google.crypto.tink.shaded.protobuf.b0;
import f4.c1;
import f4.c2;
import f4.f2;
import f4.i1;
import f4.j0;
import f4.n0;
import f4.v0;
import f4.x;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: b, reason: collision with root package name */
    public static final j f182b = new j();

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f183a = new AtomicReference(new t(new i5.f(1)));

    public final t3.b a(p pVar) {
        u3.f fVar;
        u3.f fVar2;
        AtomicReference atomicReference = this.f183a;
        t tVar = (t) atomicReference.get();
        tVar.getClass();
        i4.a aVar = (i4.a) pVar.f193g;
        if (!tVar.f204b.containsKey(new r(p.class, aVar))) {
            try {
                f fVar3 = new f();
                ((i1) pVar.f195i).ordinal();
                return fVar3;
            } catch (GeneralSecurityException e10) {
                throw new u("Creating a LegacyProtoKey failed", e10);
            }
        }
        t tVar2 = (t) atomicReference.get();
        tVar2.getClass();
        r rVar = new r(p.class, aVar);
        HashMap map = tVar2.f204b;
        if (!map.containsKey(rVar)) {
            throw new GeneralSecurityException("No Key Parser for requested key type " + rVar + " available");
        }
        switch (((a) map.get(rVar)).f168b.f1486a) {
            case 1:
                if (!((String) pVar.f192f).equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
                    throw new IllegalArgumentException("Wrong type URL in call to AesCmacParameters.parseParameters");
                }
                try {
                    f4.b bVarC = f4.b.C((com.google.crypto.tink.shaded.protobuf.h) pVar.f194h, com.google.crypto.tink.shaded.protobuf.n.a());
                    if (bVarC.A() != 0) {
                        throw new GeneralSecurityException("Only version 0 keys are accepted");
                    }
                    i5.l lVar = new i5.l(5, false);
                    lVar.f4687g = null;
                    lVar.f4688h = null;
                    lVar.f4689i = b4.f.f1496f;
                    lVar.O(bVarC.y().size());
                    int iX = bVarC.z().x();
                    if (iX < 10 || 16 < iX) {
                        throw new GeneralSecurityException(n.f.c(iX, "Invalid tag size for AesCmacParameters: "));
                    }
                    lVar.f4688h = Integer.valueOf(iX);
                    lVar.f4689i = b4.h.a((c2) pVar.f196j);
                    b4.g gVarN = lVar.n();
                    i5.l lVar2 = new i5.l(4, false);
                    lVar2.f4688h = null;
                    lVar2.f4689i = null;
                    lVar2.f4687g = gVarN;
                    lVar2.f4688h = new a7.d(12, i4.a.a(bVarC.y().j()));
                    lVar2.f4689i = (Integer) pVar.f197k;
                    return lVar2.m();
                } catch (b0 | IllegalArgumentException unused) {
                    throw new GeneralSecurityException("Parsing AesCmacKey failed");
                }
            case 2:
            case 4:
            case 5:
            case 6:
            case 7:
            default:
                if (!((String) pVar.f192f).equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
                    throw new IllegalArgumentException("Wrong type URL in call to XChaCha20Poly1305Parameters.parseParameters");
                }
                try {
                    f2 f2VarA = f2.A((com.google.crypto.tink.shaded.protobuf.h) pVar.f194h, com.google.crypto.tink.shaded.protobuf.n.a());
                    if (f2VarA.y() != 0) {
                        throw new GeneralSecurityException("Only version 0 keys are accepted");
                    }
                    c2 c2Var = (c2) pVar.f196j;
                    int iOrdinal = c2Var.ordinal();
                    if (iOrdinal == 1) {
                        fVar2 = u3.f.f10019o;
                    } else if (iOrdinal == 2) {
                        fVar2 = u3.f.f10020p;
                    } else if (iOrdinal == 3) {
                        fVar2 = u3.f.f10021q;
                    } else {
                        if (iOrdinal != 4) {
                            throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + c2Var.b());
                        }
                        fVar2 = u3.f.f10020p;
                    }
                    return u3.s.b(fVar2, new a7.d(12, i4.a.a(f2VarA.x().j())), (Integer) pVar.f197k);
                } catch (b0 unused2) {
                    throw new GeneralSecurityException("Parsing XChaCha20Poly1305Key failed");
                }
            case 3:
                if (!((String) pVar.f192f).equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
                    throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseKey");
                }
                try {
                    c1 c1VarD = c1.D((com.google.crypto.tink.shaded.protobuf.h) pVar.f194h, com.google.crypto.tink.shaded.protobuf.n.a());
                    if (c1VarD.B() != 0) {
                        throw new GeneralSecurityException("Only version 0 keys are accepted");
                    }
                    i5.f fVar4 = new i5.f(5);
                    fVar4.f4653g = null;
                    fVar4.f4654h = null;
                    fVar4.f4655i = null;
                    fVar4.f4656j = b4.f.f1505o;
                    fVar4.f4653g = Integer.valueOf(c1VarD.z().size());
                    fVar4.f4654h = Integer.valueOf(c1VarD.A().z());
                    fVar4.f4655i = b4.n.a(c1VarD.A().y());
                    fVar4.f4656j = b4.n.b((c2) pVar.f196j);
                    b4.m mVarZ = fVar4.z();
                    i5.l lVar3 = new i5.l(6, false);
                    lVar3.f4688h = null;
                    lVar3.f4689i = null;
                    lVar3.f4687g = mVarZ;
                    lVar3.f4688h = new a7.d(12, i4.a.a(c1VarD.z().j()));
                    lVar3.f4689i = (Integer) pVar.f197k;
                    return lVar3.o();
                } catch (b0 | IllegalArgumentException unused3) {
                    throw new GeneralSecurityException("Parsing HmacKey failed");
                }
            case 8:
                if (!((String) pVar.f192f).equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
                    throw new IllegalArgumentException("Wrong type URL in call to AesEaxParameters.parseParameters");
                }
                try {
                    x xVarC = x.C((com.google.crypto.tink.shaded.protobuf.h) pVar.f194h, com.google.crypto.tink.shaded.protobuf.n.a());
                    if (xVarC.A() != 0) {
                        throw new GeneralSecurityException("Only version 0 keys are accepted");
                    }
                    u3.f fVar5 = u3.f.f10009e;
                    int size = xVarC.y().size();
                    if (size != 16 && size != 24 && size != 32) {
                        throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", Integer.valueOf(size)));
                    }
                    int iX2 = xVarC.z().x();
                    if (iX2 != 12 && iX2 != 16) {
                        throw new GeneralSecurityException(String.format("Invalid IV size in bytes %d; acceptable values have 12 or 16 bytes", Integer.valueOf(iX2)));
                    }
                    c2 c2Var2 = (c2) pVar.f196j;
                    int iOrdinal2 = c2Var2.ordinal();
                    if (iOrdinal2 == 1) {
                        fVar5 = u3.f.f10007c;
                    } else if (iOrdinal2 == 2) {
                        fVar5 = u3.f.f10008d;
                    } else if (iOrdinal2 != 3) {
                        if (iOrdinal2 != 4) {
                            throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + c2Var2.b());
                        }
                        fVar5 = u3.f.f10008d;
                    }
                    u3.g gVar = new u3.g(size, iX2, 16, fVar5);
                    i5.l lVar4 = new i5.l(26, false);
                    lVar4.f4688h = null;
                    lVar4.f4689i = null;
                    lVar4.f4687g = gVar;
                    lVar4.f4688h = new a7.d(12, i4.a.a(xVarC.y().j()));
                    lVar4.f4689i = (Integer) pVar.f197k;
                    return lVar4.p();
                } catch (b0 unused4) {
                    throw new GeneralSecurityException("Parsing AesEaxcKey failed");
                }
            case 9:
                if (!((String) pVar.f192f).equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
                    throw new IllegalArgumentException("Wrong type URL in call to AesGcmParameters.parseParameters");
                }
                try {
                    j0 j0VarA = j0.A((com.google.crypto.tink.shaded.protobuf.h) pVar.f194h, com.google.crypto.tink.shaded.protobuf.n.a());
                    if (j0VarA.y() != 0) {
                        throw new GeneralSecurityException("Only version 0 keys are accepted");
                    }
                    u3.f fVar6 = u3.f.f10012h;
                    int size2 = j0VarA.x().size();
                    if (size2 != 16 && size2 != 24 && size2 != 32) {
                        throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", Integer.valueOf(size2)));
                    }
                    c2 c2Var3 = (c2) pVar.f196j;
                    int iOrdinal3 = c2Var3.ordinal();
                    if (iOrdinal3 == 1) {
                        fVar6 = u3.f.f10010f;
                    } else if (iOrdinal3 == 2) {
                        fVar6 = u3.f.f10011g;
                    } else if (iOrdinal3 != 3) {
                        if (iOrdinal3 != 4) {
                            throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + c2Var3.b());
                        }
                        fVar6 = u3.f.f10011g;
                    }
                    u3.j jVar = new u3.j(size2, 12, 16, fVar6);
                    i5.l lVar5 = new i5.l(27, false);
                    lVar5.f4688h = null;
                    lVar5.f4689i = null;
                    lVar5.f4687g = jVar;
                    lVar5.f4688h = new a7.d(12, i4.a.a(j0VarA.x().j()));
                    lVar5.f4689i = (Integer) pVar.f197k;
                    return lVar5.q();
                } catch (b0 unused5) {
                    throw new GeneralSecurityException("Parsing AesGcmKey failed");
                }
            case 10:
                if (!((String) pVar.f192f).equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
                    throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivParameters.parseParameters");
                }
                try {
                    n0 n0VarA = n0.A((com.google.crypto.tink.shaded.protobuf.h) pVar.f194h, com.google.crypto.tink.shaded.protobuf.n.a());
                    if (n0VarA.y() != 0) {
                        throw new GeneralSecurityException("Only version 0 keys are accepted");
                    }
                    u3.f fVar7 = u3.f.f10015k;
                    int size3 = n0VarA.x().size();
                    if (size3 != 16 && size3 != 32) {
                        throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte and 32-byte AES keys are supported", Integer.valueOf(size3)));
                    }
                    c2 c2Var4 = (c2) pVar.f196j;
                    int iOrdinal4 = c2Var4.ordinal();
                    if (iOrdinal4 == 1) {
                        fVar7 = u3.f.f10013i;
                    } else if (iOrdinal4 == 2) {
                        fVar7 = u3.f.f10014j;
                    } else if (iOrdinal4 != 3) {
                        if (iOrdinal4 != 4) {
                            throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + c2Var4.b());
                        }
                        fVar7 = u3.f.f10014j;
                    }
                    u3.m mVar = new u3.m(size3, fVar7);
                    i5.l lVar6 = new i5.l(28, false);
                    lVar6.f4688h = null;
                    lVar6.f4689i = null;
                    lVar6.f4687g = mVar;
                    lVar6.f4688h = new a7.d(12, i4.a.a(n0VarA.x().j()));
                    lVar6.f4689i = (Integer) pVar.f197k;
                    return lVar6.r();
                } catch (b0 unused6) {
                    throw new GeneralSecurityException("Parsing AesGcmSivKey failed");
                }
            case 11:
                if (!((String) pVar.f192f).equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
                    throw new IllegalArgumentException("Wrong type URL in call to ChaCha20Poly1305Parameters.parseParameters");
                }
                try {
                    v0 v0VarA = v0.A((com.google.crypto.tink.shaded.protobuf.h) pVar.f194h, com.google.crypto.tink.shaded.protobuf.n.a());
                    if (v0VarA.y() != 0) {
                        throw new GeneralSecurityException("Only version 0 keys are accepted");
                    }
                    c2 c2Var5 = (c2) pVar.f196j;
                    int iOrdinal5 = c2Var5.ordinal();
                    if (iOrdinal5 == 1) {
                        fVar = u3.f.f10016l;
                    } else if (iOrdinal5 == 2) {
                        fVar = u3.f.f10017m;
                    } else if (iOrdinal5 == 3) {
                        fVar = u3.f.f10018n;
                    } else {
                        if (iOrdinal5 != 4) {
                            throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + c2Var5.b());
                        }
                        fVar = u3.f.f10017m;
                    }
                    return u3.o.b(fVar, new a7.d(12, i4.a.a(v0VarA.x().j())), (Integer) pVar.f197k);
                } catch (b0 unused7) {
                    throw new GeneralSecurityException("Parsing ChaCha20Poly1305Key failed");
                }
        }
    }

    public final synchronized void b(a aVar) {
        i5.f fVar = new i5.f((t) this.f183a.get());
        fVar.N(aVar);
        this.f183a.set(new t(fVar));
    }

    public final synchronized void c(b bVar) {
        i5.f fVar = new i5.f((t) this.f183a.get());
        fVar.O(bVar);
        this.f183a.set(new t(fVar));
    }

    public final synchronized void d(k kVar) {
        i5.f fVar = new i5.f((t) this.f183a.get());
        fVar.P(kVar);
        this.f183a.set(new t(fVar));
    }

    public final synchronized void e(l lVar) {
        i5.f fVar = new i5.f((t) this.f183a.get());
        fVar.Q(lVar);
        this.f183a.set(new t(fVar));
    }
}
