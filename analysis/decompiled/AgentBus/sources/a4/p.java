package a4;

import b0.f2;
import b0.o1;
import c1.w;
import com.stepos.account.oauth.OAuthConstants;
import d7.z;
import f4.c2;
import f4.i1;
import f8.n0;
import i8.a0;
import ia.d0;
import java.lang.annotation.Annotation;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import m.x;
import p.t0;
import w7.e0;
import z8.f0;
import z8.p0;
import z8.u0;

/* loaded from: classes.dex */
public final class p implements h4.v, t0, r9.a, r9.c {

    /* renamed from: f, reason: collision with root package name */
    public Object f192f;

    /* renamed from: g, reason: collision with root package name */
    public Object f193g;

    /* renamed from: h, reason: collision with root package name */
    public Object f194h;

    /* renamed from: i, reason: collision with root package name */
    public Object f195i;

    /* renamed from: j, reason: collision with root package name */
    public Object f196j;

    /* renamed from: k, reason: collision with root package name */
    public Object f197k;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Can't wrap try/catch for region: R(7:64|(1:88)|65|66|86|67|(1:97)(8:70|71|72|78|(0)|81|62|(2:82|83)(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x01b9, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01ba, code lost:
    
        r12 = r1;
        r1 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01c0, code lost:
    
        r0 = w7.e0.n(r0);
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01ef  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x01b0 -> B:71:0x01b2). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object s(a4.p r19, a6.s r20, i7.c r21) {
        /*
            Method dump skipped, instructions count: 584
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a4.p.s(a4.p, a6.s, i7.c):java.lang.Object");
    }

    public static final j9.g t(p pVar, e9.f fVar, Object obj) {
        j9.g gVarB = j9.h.b(obj, (a0) pVar.f194h);
        if (gVarB != null) {
            return gVarB;
        }
        String str = "Unsupported annotation argument: " + fVar;
        q7.k.e(str, OAuthConstants.FACTOR_RESULT_MESSAGE);
        return new j9.j(str);
    }

    public static p u(String str, com.google.crypto.tink.shaded.protobuf.h hVar, i1 i1Var, c2 c2Var, Integer num) throws GeneralSecurityException {
        if (c2Var == c2.RAW) {
            if (num != null) {
                throw new GeneralSecurityException("Keys with output prefix type raw should not have an id requirement.");
            }
        } else if (num == null) {
            throw new GeneralSecurityException("Keys with output prefix type different from raw should have an id requirement.");
        }
        p pVar = new p();
        pVar.f192f = str;
        pVar.f193g = v.b(str);
        pVar.f194h = hVar;
        pVar.f195i = i1Var;
        pVar.f196j = c2Var;
        pVar.f197k = num;
        return pVar;
    }

    public static /* synthetic */ List w(p pVar, e eVar, x8.o oVar, Boolean bool, boolean z4, int i2) {
        boolean z10 = (i2 & 4) == 0;
        if ((i2 & 16) != 0) {
            bool = null;
        }
        return pVar.v(eVar, oVar, z10, false, bool, (i2 & 32) != 0 ? false : z4);
    }

    public static x8.o x(f9.a aVar, b9.f fVar, b9.g gVar, int i2, boolean z4) {
        q7.k.e(aVar, "proto");
        q7.k.e(fVar, "nameResolver");
        x.t(i2, "kind");
        if (aVar instanceof z8.k) {
            f9.h hVar = d9.h.f3015a;
            d9.e eVarA = d9.h.a((z8.k) aVar, fVar, gVar);
            if (eVarA != null) {
                return n7.m.q(eVarA);
            }
        } else if (aVar instanceof z8.x) {
            f9.h hVar2 = d9.h.f3015a;
            d9.e eVarC = d9.h.c((z8.x) aVar, fVar, gVar);
            if (eVarC != null) {
                return n7.m.q(eVarC);
            }
        } else if (aVar instanceof f0) {
            f9.n nVar = c9.l.f2165d;
            q7.k.d(nVar, "propertySignature");
            c9.f fVar2 = (c9.f) e0.A((f9.l) aVar, nVar);
            if (fVar2 != null) {
                int iD = n.f.d(i2);
                if (iD == 1) {
                    return nb.i.B((f0) aVar, fVar, gVar, true, true, z4);
                }
                if (iD == 2) {
                    if ((fVar2.f2117g & 4) != 4) {
                        return null;
                    }
                    c9.d dVar = fVar2.f2120j;
                    q7.k.d(dVar, "signature.getter");
                    return new x8.o(fVar.getString(dVar.f2104h).concat(fVar.getString(dVar.f2105i)));
                }
                if (iD != 3 || (fVar2.f2117g & 8) != 8) {
                    return null;
                }
                c9.d dVar2 = fVar2.f2121k;
                q7.k.d(dVar2, "signature.setter");
                return new x8.o(fVar.getString(dVar2.f2104h).concat(fVar.getString(dVar2.f2105i)));
            }
        }
        return null;
    }

    public a7.g A(e9.b bVar, n0 n0Var, List list) {
        q7.k.e(list, "result");
        return new a7.g(this, f8.v.f((a0) this.f194h, bVar, (i5.f) this.f195i), bVar, list, n0Var);
    }

    public a7.g B(e9.b bVar, k8.a aVar, List list) {
        q7.k.e(list, "result");
        if (b8.a.f1547a.contains(bVar)) {
            return null;
        }
        return A(bVar, aVar, list);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object C(a4.e r9, z8.f0 r10, int r11, v9.v r12, p7.n r13) {
        /*
            r8 = this;
            b9.b r0 = b9.e.A
            int r1 = r10.f12135i
            java.lang.Boolean r6 = r0.e(r1)
            boolean r7 = d9.h.d(r10)
            r4 = 1
            r5 = 1
            r2 = r8
            r3 = r9
            k8.c r8 = r2.y(r3, r4, r5, r6, r7)
            r9 = 0
            if (r8 != 0) goto L30
            boolean r8 = r3 instanceof r9.s
            if (r8 == 0) goto L2f
            r8 = r3
            r9.s r8 = (r9.s) r8
            java.lang.Object r8 = r8.f176d
            f8.n0 r8 = (f8.n0) r8
            boolean r0 = r8 instanceof x8.n
            if (r0 == 0) goto L29
            x8.n r8 = (x8.n) r8
            goto L2a
        L29:
            r8 = r9
        L2a:
            if (r8 == 0) goto L2f
            k8.c r8 = r8.f11272f
            goto L30
        L2f:
            r8 = r9
        L30:
            if (r8 != 0) goto L33
            goto L67
        L33:
            gb.h r0 = r8.f5653b
            java.lang.Object r0 = r0.f4054d
            d9.f r0 = (d9.f) r0
            d9.f r1 = x8.d.f11253e
            java.lang.String r4 = "version"
            q7.k.e(r1, r4)
            int r4 = r1.f1550b
            int r5 = r1.f1551c
            int r1 = r1.f1552d
            boolean r0 = r0.a(r4, r5, r1)
            java.lang.Object r1 = r3.f174b
            b9.f r1 = (b9.f) r1
            java.lang.Object r3 = r3.f175c
            b9.g r3 = (b9.g) r3
            x8.o r10 = x(r10, r1, r3, r11, r0)
            if (r10 != 0) goto L59
            goto L67
        L59:
            java.lang.Object r11 = r2.f193g
            u9.e r11 = (u9.e) r11
            java.lang.Object r8 = r11.invoke(r8)
            java.lang.Object r8 = r13.invoke(r8, r10)
            if (r8 != 0) goto L68
        L67:
            return r9
        L68:
            boolean r9 = c8.r.a(r12)
            if (r9 == 0) goto Lc0
            j9.g r8 = (j9.g) r8
            boolean r9 = r8 instanceof j9.d
            if (r9 == 0) goto L84
            j9.y r9 = new j9.y
            j9.d r8 = (j9.d) r8
            java.lang.Object r8 = r8.f5408a
            java.lang.Number r8 = (java.lang.Number) r8
            byte r8 = r8.byteValue()
            r9.<init>(r8)
            return r9
        L84:
            boolean r9 = r8 instanceof j9.v
            if (r9 == 0) goto L98
            j9.y r9 = new j9.y
            j9.v r8 = (j9.v) r8
            java.lang.Object r8 = r8.f5408a
            java.lang.Number r8 = (java.lang.Number) r8
            short r8 = r8.shortValue()
            r9.<init>(r8)
            return r9
        L98:
            boolean r9 = r8 instanceof j9.k
            if (r9 == 0) goto Lac
            j9.y r9 = new j9.y
            j9.k r8 = (j9.k) r8
            java.lang.Object r8 = r8.f5408a
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            r9.<init>(r8)
            return r9
        Lac:
            boolean r9 = r8 instanceof j9.t
            if (r9 == 0) goto Lc0
            j9.y r9 = new j9.y
            j9.t r8 = (j9.t) r8
            java.lang.Object r8 = r8.f5408a
            java.lang.Number r8 = (java.lang.Number) r8
            long r10 = r8.longValue()
            r9.<init>(r10)
            return r9
        Lc0:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: a4.p.C(a4.e, z8.f0, int, v9.v, p7.n):java.lang.Object");
    }

    public List D(e eVar, f0 f0Var, int i2) {
        b9.g gVar = (b9.g) eVar.f175c;
        b9.f fVar = (b9.f) eVar.f174b;
        Boolean boolE = b9.e.A.e(f0Var.f12135i);
        boolean zD = d9.h.d(f0Var);
        if (i2 == 1) {
            x8.o oVarB = nb.i.B(f0Var, fVar, gVar, (40 & 8) == 0, (40 & 16) == 0, true);
            if (oVarB != null) {
                return w(this, eVar, oVarB, boolE, zD, 8);
            }
        } else {
            x8.o oVarB2 = nb.i.B(f0Var, fVar, gVar, (40 & 8) == 0, (40 & 16) == 0, true);
            if (oVarB2 != null) {
                if (ga.k.k0(oVarB2.f11273a, "$delegate", false) == (i2 == 3)) {
                    return v(eVar, oVarB2, true, true, boolE, zD);
                }
            }
        }
        return z.f2978f;
    }

    @Override // p.t0
    public Object b(int i2, f2 f2Var, i7.c cVar) {
        Object objF = d0.f(new p.k(this, i2, f2Var, null), cVar);
        return objF == h7.a.f4212f ? objF : c7.r.f1986a;
    }

    @Override // r9.c
    public List c(e eVar, f0 f0Var) {
        q7.k.e(f0Var, "proto");
        return D(eVar, f0Var, 3);
    }

    @Override // r9.c
    public List d(e eVar, f0 f0Var) {
        q7.k.e(f0Var, "proto");
        return D(eVar, f0Var, 2);
    }

    @Override // r9.a
    public Object e(e eVar, f0 f0Var, v9.v vVar) {
        q7.k.e(f0Var, "proto");
        return C(eVar, f0Var, 2, vVar, x8.b.f11247i);
    }

    @Override // h4.v
    public synchronized void f(ByteBuffer byteBuffer, byte[] bArr) {
        if (byteBuffer.remaining() != ((h4.b) this.f197k).e()) {
            throw new InvalidAlgorithmParameterException("Invalid header length");
        }
        if (byteBuffer.get() != ((h4.b) this.f197k).e()) {
            throw new GeneralSecurityException("Invalid ciphertext");
        }
        this.f196j = new byte[7];
        byte[] bArr2 = new byte[((h4.b) this.f197k).f4107a];
        byteBuffer.get(bArr2);
        byteBuffer.get((byte[]) this.f196j);
        h4.b bVar = (h4.b) this.f197k;
        byte[] bArrP = ib.c.p(bVar.f4112f, bVar.f4113g, bArr2, bArr, bVar.f4107a + 32);
        this.f192f = new SecretKeySpec(bArrP, 0, ((h4.b) this.f197k).f4107a, "AES");
        h4.b bVar2 = (h4.b) this.f197k;
        this.f193g = new SecretKeySpec(bArrP, bVar2.f4107a, 32, bVar2.f4108b);
        this.f194h = (Cipher) h4.m.f4149b.f4151a.a("AES/CTR/NoPadding");
        h4.b bVar3 = (h4.b) this.f197k;
        h4.m mVar = h4.m.f4150c;
        this.f195i = (Mac) mVar.f4151a.a(bVar3.f4108b);
    }

    @Override // r9.c
    public ArrayList g(u0 u0Var, b9.f fVar) {
        q7.k.e(u0Var, "proto");
        q7.k.e(fVar, "nameResolver");
        Object objI = u0Var.i(c9.l.f2169h);
        q7.k.d(objI, "proto.getExtension(JvmPr….typeParameterAnnotation)");
        Iterable<z8.f> iterable = (Iterable) objI;
        ArrayList arrayList = new ArrayList(d7.t.A0(iterable, 10));
        for (z8.f fVar2 : iterable) {
            q7.k.d(fVar2, "it");
            arrayList.add(((nb.f) this.f196j).t(fVar2, fVar));
        }
        return arrayList;
    }

    @Override // r9.c
    public ArrayList h(r9.s sVar) {
        q7.k.e(sVar, "container");
        n0 n0Var = (n0) sVar.f176d;
        x8.n nVar = n0Var instanceof x8.n ? (x8.n) n0Var : null;
        k8.c cVar = nVar != null ? nVar.f11272f : null;
        if (cVar == null) {
            throw new IllegalStateException(("Class for loading annotations is not found: " + sVar.f9104g.b()).toString());
        }
        ArrayList arrayList = new ArrayList(1);
        Class cls = cVar.f5652a;
        q7.k.e(cls, "klass");
        Annotation[] declaredAnnotations = cls.getDeclaredAnnotations();
        q7.k.d(declaredAnnotations, "klass.declaredAnnotations");
        for (Annotation annotation : declaredAnnotations) {
            q7.k.d(annotation, "annotation");
            Class clsT = nb.i.t(nb.i.p(annotation));
            a7.g gVarB = B(l8.d.a(clsT), new k8.a(annotation), arrayList);
            if (gVarB != null) {
                ib.k.I(gVarB, annotation, clsT);
            }
        }
        return arrayList;
    }

    @Override // p.t0
    public boolean i() {
        return ((Boolean) ((o1) this.f195i).getValue()).booleanValue();
    }

    @Override // r9.c
    public List j(e eVar, f9.a aVar, int i2) {
        q7.k.e(aVar, "proto");
        x.t(i2, "kind");
        if (i2 == 2) {
            return D(eVar, (f0) aVar, 1);
        }
        x8.o oVarX = x(aVar, (b9.f) eVar.f174b, (b9.g) eVar.f175c, i2, false);
        return oVarX == null ? z.f2978f : w(this, eVar, oVarX, null, false, 60);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    @Override // r9.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List k(a4.e r10, f9.a r11, int r12, int r13, z8.x0 r14) {
        /*
            r9 = this;
            java.lang.String r14 = "callableProto"
            q7.k.e(r11, r14)
            java.lang.String r14 = "kind"
            m.x.t(r12, r14)
            java.lang.Object r14 = r10.f174b
            b9.f r14 = (b9.f) r14
            java.lang.Object r0 = r10.f175c
            b9.g r0 = (b9.g) r0
            r1 = 0
            x8.o r12 = x(r11, r14, r0, r12, r1)
            if (r12 == 0) goto L92
            boolean r14 = r11 instanceof z8.x
            r0 = 32
            r2 = 64
            r3 = 1
            if (r14 == 0) goto L30
            z8.x r11 = (z8.x) r11
            int r11 = r11.f12445h
            r14 = r11 & 32
            if (r14 != r0) goto L2b
            goto L2e
        L2b:
            r11 = r11 & r2
            if (r11 != r2) goto L55
        L2e:
            r1 = r3
            goto L55
        L30:
            boolean r14 = r11 instanceof z8.f0
            if (r14 == 0) goto L41
            z8.f0 r11 = (z8.f0) r11
            int r11 = r11.f12134h
            r14 = r11 & 32
            if (r14 != r0) goto L3d
            goto L40
        L3d:
            r11 = r11 & r2
            if (r11 != r2) goto L55
        L40:
            goto L2e
        L41:
            boolean r14 = r11 instanceof z8.k
            if (r14 == 0) goto L7a
            r11 = r10
            r9.s r11 = (r9.s) r11
            z8.h r14 = r11.f9105h
            z8.h r0 = z8.h.ENUM_CLASS
            if (r14 != r0) goto L50
            r1 = 2
            goto L55
        L50:
            boolean r11 = r11.f9106i
            if (r11 == 0) goto L55
            goto L2e
        L55:
            int r13 = r13 + r1
            x8.o r5 = new x8.o
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = r12.f11273a
            r11.append(r12)
            r11.append(r2)
            r11.append(r13)
            java.lang.String r11 = r11.toString()
            r5.<init>(r11)
            r7 = 0
            r8 = 60
            r6 = 0
            r3 = r9
            r4 = r10
            java.util.List r9 = w(r3, r4, r5, r6, r7, r8)
            return r9
        L7a:
            java.lang.UnsupportedOperationException r9 = new java.lang.UnsupportedOperationException
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r12 = "Unsupported message: "
            r10.<init>(r12)
            java.lang.Class r11 = r11.getClass()
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L92:
            d7.z r9 = d7.z.f2978f
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: a4.p.k(a4.e, f9.a, int, int, z8.x0):java.util.List");
    }

    @Override // r9.c
    public List m(e eVar, z8.s sVar) {
        q7.k.e(eVar, "container");
        String string = ((b9.f) eVar.f174b).getString(sVar.f12359i);
        String strB = d9.b.b(((r9.s) eVar).f9104g.c());
        q7.k.e(strB, "desc");
        return w(this, eVar, new x8.o(string + '#' + strB), null, false, 60);
    }

    @Override // p.t0
    public float n(float f10) {
        return ((Number) ((w) this.f192f).invoke(Float.valueOf(f10))).floatValue();
    }

    @Override // r9.c
    public ArrayList o(p0 p0Var, b9.f fVar) {
        q7.k.e(p0Var, "proto");
        q7.k.e(fVar, "nameResolver");
        Object objI = p0Var.i(c9.l.f2167f);
        q7.k.d(objI, "proto.getExtension(JvmProtoBuf.typeAnnotation)");
        Iterable<z8.f> iterable = (Iterable) objI;
        ArrayList arrayList = new ArrayList(d7.t.A0(iterable, 10));
        for (z8.f fVar2 : iterable) {
            q7.k.d(fVar2, "it");
            arrayList.add(((nb.f) this.f196j).t(fVar2, fVar));
        }
        return arrayList;
    }

    @Override // r9.c
    public List p(e eVar, f9.a aVar, int i2) {
        q7.k.e(aVar, "proto");
        x.t(i2, "kind");
        x8.o oVarX = x(aVar, (b9.f) eVar.f174b, (b9.g) eVar.f175c, i2, false);
        return oVarX != null ? w(this, eVar, new x8.o(a1.a.m(new StringBuilder(), oVarX.f11273a, "@0")), null, false, 60) : z.f2978f;
    }

    @Override // h4.v
    public synchronized void q(ByteBuffer byteBuffer, int i2, boolean z4, ByteBuffer byteBuffer2) {
        int iPosition = byteBuffer.position();
        byte[] bArrI = h4.b.i((h4.b) this.f197k, (byte[]) this.f196j, i2, z4);
        int iRemaining = byteBuffer.remaining();
        int i10 = ((h4.b) this.f197k).f4109c;
        if (iRemaining < i10) {
            throw new GeneralSecurityException("Ciphertext too short");
        }
        int i11 = (iRemaining - i10) + iPosition;
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.limit(i11);
        ByteBuffer byteBufferDuplicate2 = byteBuffer.duplicate();
        byteBufferDuplicate2.position(i11);
        ((Mac) this.f195i).init((SecretKeySpec) this.f193g);
        ((Mac) this.f195i).update(bArrI);
        ((Mac) this.f195i).update(byteBufferDuplicate);
        byte[] bArrCopyOf = Arrays.copyOf(((Mac) this.f195i).doFinal(), ((h4.b) this.f197k).f4109c);
        byte[] bArr = new byte[((h4.b) this.f197k).f4109c];
        byteBufferDuplicate2.get(bArr);
        if (!MessageDigest.isEqual(bArr, bArrCopyOf)) {
            throw new GeneralSecurityException("Tag mismatch");
        }
        byteBuffer.limit(i11);
        ((Cipher) this.f194h).init(1, (SecretKeySpec) this.f192f, new IvParameterSpec(bArrI));
        ((Cipher) this.f194h).doFinal(byteBuffer, byteBuffer2);
    }

    @Override // r9.a
    public Object r(e eVar, f0 f0Var, v9.v vVar) {
        q7.k.e(f0Var, "proto");
        return C(eVar, f0Var, 3, vVar, x8.b.f11246h);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List v(a4.e r7, x8.o r8, boolean r9, boolean r10, java.lang.Boolean r11, boolean r12) {
        /*
            r6 = this;
            r0 = r6
            r1 = r7
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            k8.c r6 = r0.y(r1, r2, r3, r4, r5)
            if (r6 != 0) goto L26
            boolean r6 = r1 instanceof r9.s
            r7 = 0
            if (r6 == 0) goto L25
            r6 = r1
            r9.s r6 = (r9.s) r6
            java.lang.Object r6 = r6.f176d
            f8.n0 r6 = (f8.n0) r6
            boolean r9 = r6 instanceof x8.n
            if (r9 == 0) goto L1f
            x8.n r6 = (x8.n) r6
            goto L20
        L1f:
            r6 = r7
        L20:
            if (r6 == 0) goto L25
            k8.c r6 = r6.f11272f
            goto L26
        L25:
            r6 = r7
        L26:
            if (r6 != 0) goto L29
            goto L3d
        L29:
            java.lang.Object r7 = r0.f193g
            u9.e r7 = (u9.e) r7
            java.lang.Object r6 = r7.invoke(r6)
            x8.a r6 = (x8.a) r6
            java.util.HashMap r6 = r6.f11243a
            java.lang.Object r6 = r6.get(r8)
            java.util.List r6 = (java.util.List) r6
            if (r6 != 0) goto L3f
        L3d:
            d7.z r6 = d7.z.f2978f
        L3f:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: a4.p.v(a4.e, x8.o, boolean, boolean, java.lang.Boolean, boolean):java.util.List");
    }

    public k8.c y(e eVar, boolean z4, boolean z10, Boolean bool, boolean z11) {
        r9.s sVar;
        z8.h hVar;
        k8.b bVar = (k8.b) this.f192f;
        q7.k.e(eVar, "container");
        n0 n0Var = (n0) eVar.f176d;
        z8.h hVar2 = z8.h.INTERFACE;
        if (z4) {
            if (bool == null) {
                throw new IllegalStateException(("isConst should not be null for property (container=" + eVar + ')').toString());
            }
            if (eVar instanceof r9.s) {
                r9.s sVar2 = (r9.s) eVar;
                if (sVar2.f9105h == hVar2) {
                    return n7.b.h(bVar, sVar2.f9104g.d(e9.f.e("DefaultImpls")), (d9.f) this.f197k);
                }
            }
            if (bool.booleanValue() && (eVar instanceof r9.t)) {
                x8.f fVar = n0Var instanceof x8.f ? (x8.f) n0Var : null;
                m9.b bVar2 = fVar != null ? fVar.f11259g : null;
                if (bVar2 != null) {
                    String strE = bVar2.e();
                    q7.k.d(strE, "facadeClassName.internalName");
                    return n7.b.h(bVar, e9.b.j(new e9.c(ga.r.d0(strE, '/', '.'))), (d9.f) this.f197k);
                }
            }
        }
        if (z10 && (eVar instanceof r9.s)) {
            r9.s sVar3 = (r9.s) eVar;
            if (sVar3.f9105h == z8.h.COMPANION_OBJECT && (sVar = sVar3.f9103f) != null && ((hVar = sVar.f9105h) == z8.h.CLASS || hVar == z8.h.ENUM_CLASS || (z11 && (hVar == hVar2 || hVar == z8.h.ANNOTATION_CLASS)))) {
                n0 n0Var2 = (n0) sVar.f176d;
                x8.n nVar = n0Var2 instanceof x8.n ? (x8.n) n0Var2 : null;
                if (nVar != null) {
                    return nVar.f11272f;
                }
                return null;
            }
        }
        if (!(eVar instanceof r9.t) || !(n0Var instanceof x8.f)) {
            return null;
        }
        x8.f fVar2 = (x8.f) n0Var;
        k8.c cVar = fVar2.f11260h;
        return cVar == null ? n7.b.h(bVar, fVar2.a(), (d9.f) this.f197k) : cVar;
    }

    public boolean z(e9.b bVar) {
        k8.c cVarH;
        if (bVar.f() != null && q7.k.a(bVar.i().b(), "Container") && (cVarH = n7.b.h((k8.b) this.f192f, bVar, (d9.f) this.f197k)) != null) {
            LinkedHashSet linkedHashSet = b8.a.f1547a;
            Class cls = cVarH.f5652a;
            q7.k.e(cls, "klass");
            Annotation[] declaredAnnotations = cls.getDeclaredAnnotations();
            q7.k.d(declaredAnnotations, "klass.declaredAnnotations");
            boolean z4 = false;
            for (Annotation annotation : declaredAnnotations) {
                q7.k.d(annotation, "annotation");
                if (l8.d.a(nb.i.t(nb.i.p(annotation))).equals(o8.w.f7857b)) {
                    z4 = true;
                }
            }
            if (z4) {
                return true;
            }
        }
        return false;
    }
}
