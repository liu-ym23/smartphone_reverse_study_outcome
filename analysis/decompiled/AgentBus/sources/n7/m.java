package n7;

import a4.u;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import b0.p;
import b0.t1;
import c7.r;
import com.stepos.agentbus.platform.AgentBusService;
import d7.c0;
import d7.d0;
import d7.t;
import f8.q0;
import i1.y;
import i5.l;
import i8.r0;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import m.x;
import o.i0;
import o.y0;
import q7.k;
import v9.e0;
import v9.m0;
import v9.p0;
import v9.v;
import v9.z;
import v9.z0;
import z7.k1;
import z7.m1;
import z7.q1;
import z7.s;
import z7.x1;

/* loaded from: classes.dex */
public abstract class m {
    public m(boolean z4) {
    }

    public static void A(byte[] bArr, int i2, int i10) {
        bArr[i10] = (byte) (i2 >>> 24);
        bArr[i10 + 1] = (byte) (i2 >>> 16);
        bArr[i10 + 2] = (byte) (i2 >>> 8);
        bArr[i10 + 3] = (byte) i2;
    }

    public static void B(int i2, long j2, byte[] bArr) {
        A(bArr, (int) (j2 >>> 32), i2);
        A(bArr, (int) (j2 & 4294967295L), i2 + 4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x011d, code lost:
    
        if (l9.d.g(r0).equals(l9.d.g(r3)) == false) goto L51;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static x8.j C(f8.t r8, i8.r0 r9) {
        /*
            Method dump skipped, instructions count: 327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n7.m.C(f8.t, i8.r0):x8.j");
    }

    public static y2.b D(MappedByteBuffer mappedByteBuffer) throws IOException {
        long j2;
        ByteBuffer byteBufferDuplicate = mappedByteBuffer.duplicate();
        byteBufferDuplicate.order(ByteOrder.BIG_ENDIAN);
        byteBufferDuplicate.position(byteBufferDuplicate.position() + 4);
        int i2 = byteBufferDuplicate.getShort() & 65535;
        if (i2 > 100) {
            throw new IOException("Cannot read metadata.");
        }
        byteBufferDuplicate.position(byteBufferDuplicate.position() + 6);
        int i10 = 0;
        while (true) {
            if (i10 >= i2) {
                j2 = -1;
                break;
            }
            int i11 = byteBufferDuplicate.getInt();
            byteBufferDuplicate.position(byteBufferDuplicate.position() + 4);
            j2 = byteBufferDuplicate.getInt() & 4294967295L;
            byteBufferDuplicate.position(byteBufferDuplicate.position() + 4);
            if (1835365473 == i11) {
                break;
            }
            i10++;
        }
        if (j2 != -1) {
            byteBufferDuplicate.position(byteBufferDuplicate.position() + ((int) (j2 - byteBufferDuplicate.position())));
            byteBufferDuplicate.position(byteBufferDuplicate.position() + 12);
            long j4 = byteBufferDuplicate.getInt() & 4294967295L;
            for (int i12 = 0; i12 < j4; i12++) {
                int i13 = byteBufferDuplicate.getInt();
                long j10 = byteBufferDuplicate.getInt() & 4294967295L;
                byteBufferDuplicate.getInt();
                if (1164798569 == i13 || 1701669481 == i13) {
                    byteBufferDuplicate.position((int) (j10 + j2));
                    y2.b bVar = new y2.b();
                    byteBufferDuplicate.order(ByteOrder.LITTLE_ENDIAN);
                    int iPosition = byteBufferDuplicate.position() + byteBufferDuplicate.getInt(byteBufferDuplicate.position());
                    bVar.f3097i = byteBufferDuplicate;
                    bVar.f3094f = iPosition;
                    int i14 = iPosition - byteBufferDuplicate.getInt(iPosition);
                    bVar.f3095g = i14;
                    bVar.f3096h = ((ByteBuffer) bVar.f3097i).getShort(i14);
                    return bVar;
                }
            }
        }
        throw new IOException("Cannot read metadata.");
    }

    public static final y0 E(p pVar) {
        final Object obj;
        Object objC;
        int i2 = 0;
        final Object[] objArr = new Object[0];
        q6.b bVar = y0.f7158n;
        boolean zD = pVar.d(0);
        Object objJ = pVar.J();
        Object obj2 = b0.k.f1229a;
        if (zD || objJ == obj2) {
            objJ = new i0(i2, 2);
            pVar.b0(objJ);
        }
        p7.a aVar = (p7.a) objJ;
        final q6.b bVar2 = y0.f7158n;
        long j2 = pVar.Q;
        ib.c.o(36);
        final String string = Long.toString(j2, 36);
        q7.k.d(string, "toString(...)");
        final k0.c cVar = (k0.c) pVar.j(k0.e.f5573a);
        Object objJ2 = pVar.J();
        if (objJ2 == obj2) {
            Object y0Var = (cVar == null || (objC = cVar.c(string)) == null) ? null : new y0(((Number) objC).intValue());
            if (y0Var == null) {
                y0Var = aVar.c();
            }
            objJ2 = new k0.b(bVar2, cVar, string, y0Var, objArr);
            pVar.b0(objJ2);
        }
        final k0.b bVar3 = (k0.b) objJ2;
        Object objC2 = Arrays.equals(objArr, bVar3.f5568j) ? bVar3.f5567i : null;
        if (objC2 == null) {
            objC2 = aVar.c();
        }
        boolean zH = pVar.h(bVar3) | pVar.h(bVar2) | pVar.h(cVar) | pVar.f(string) | pVar.h(objC2) | pVar.h(objArr);
        Object objJ3 = pVar.J();
        if (zH || objJ3 == obj2) {
            obj = objC2;
            Object obj3 = new p7.a() { // from class: k0.a
                @Override // p7.a
                public final Object c() {
                    boolean z4;
                    b bVar4 = bVar3;
                    c cVar2 = bVar4.f5565g;
                    c cVar3 = cVar;
                    boolean z10 = true;
                    if (cVar2 != cVar3) {
                        bVar4.f5565g = cVar3;
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    String str = bVar4.f5566h;
                    String str2 = string;
                    if (k.a(str, str2)) {
                        z10 = z4;
                    } else {
                        bVar4.f5566h = str2;
                    }
                    bVar4.f5564f = bVar2;
                    bVar4.f5567i = obj;
                    bVar4.f5568j = objArr;
                    l lVar = bVar4.f5569k;
                    if (lVar != null && z10) {
                        lVar.S();
                        bVar4.f5569k = null;
                        bVar4.a();
                    }
                    return r.f1986a;
                }
            };
            pVar.b0(obj3);
            objJ3 = obj3;
        } else {
            obj = objC2;
        }
        b0.b.f((p7.a) objJ3, pVar);
        return (y0) obj;
    }

    public static final v F(v vVar, g8.j jVar) {
        return (vVar.getAnnotations().isEmpty() && jVar.isEmpty()) ? vVar : vVar.H0().K0(v9.c.q(vVar.D0(), jVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [v9.z0] */
    public static final z0 G(v vVar) {
        z zVarP;
        q7.k.e(vVar, "<this>");
        z0 z0VarH0 = vVar.H0();
        if (z0VarH0 instanceof v9.p) {
            v9.p pVar = (v9.p) z0VarH0;
            z zVarP2 = pVar.f10580g;
            if (!zVarP2.E0().getParameters().isEmpty() && zVarP2.E0().c() != null) {
                List parameters = zVarP2.E0().getParameters();
                q7.k.d(parameters, "constructor.parameters");
                ArrayList arrayList = new ArrayList(t.A0(parameters, 10));
                Iterator it = parameters.iterator();
                while (it.hasNext()) {
                    arrayList.add(new e0((q0) it.next()));
                }
                zVarP2 = v9.c.p(zVarP2, arrayList, null, 2);
            }
            z zVarP3 = pVar.f10581h;
            if (!zVarP3.E0().getParameters().isEmpty() && zVarP3.E0().c() != null) {
                List parameters2 = zVarP3.E0().getParameters();
                q7.k.d(parameters2, "constructor.parameters");
                ArrayList arrayList2 = new ArrayList(t.A0(parameters2, 10));
                Iterator it2 = parameters2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(new e0((q0) it2.next()));
                }
                zVarP3 = v9.c.p(zVarP3, arrayList2, null, 2);
            }
            zVarP = v9.d.j(zVarP2, zVarP3);
        } else {
            if (!(z0VarH0 instanceof z)) {
                throw new u();
            }
            z zVar = (z) z0VarH0;
            boolean zIsEmpty = zVar.E0().getParameters().isEmpty();
            zVarP = zVar;
            if (!zIsEmpty) {
                f8.g gVarC = zVar.E0().c();
                zVarP = zVar;
                if (gVarC != null) {
                    List parameters3 = zVar.E0().getParameters();
                    q7.k.d(parameters3, "constructor.parameters");
                    ArrayList arrayList3 = new ArrayList(t.A0(parameters3, 10));
                    Iterator it3 = parameters3.iterator();
                    while (it3.hasNext()) {
                        arrayList3.add(new e0((q0) it3.next()));
                    }
                    zVarP = v9.c.p(zVar, arrayList3, null, 2);
                }
            }
        }
        return v9.c.g(zVarP, z0VarH0);
    }

    public static void H(Context context) {
        context.startService(new Intent(context, (Class<?>) AgentBusService.class));
    }

    public static n0.m I(n0.m mVar, y0 y0Var) {
        return mVar.c(new n0.h(new androidx.compose.foundation.d(y0Var)));
    }

    public static final t0.c a(long j2, long j4) {
        int i2 = (int) (j2 >> 32);
        int i10 = (int) (j2 & 4294967295L);
        return new t0.c(Float.intBitsToFloat(i2), Float.intBitsToFloat(i10), Float.intBitsToFloat((int) (j4 >> 32)) + Float.intBitsToFloat(i2), Float.intBitsToFloat((int) (j4 & 4294967295L)) + Float.intBitsToFloat(i10));
    }

    public static final void b(p pVar, n0.m mVar) {
        r.k kVar = r.k.f8878c;
        int iK = b0.b.k(pVar);
        n0.m mVarV = a.a.V(pVar, mVar);
        t1 t1VarL = pVar.l();
        i1.h.f4488c.getClass();
        y yVar = i1.g.f4474b;
        pVar.U();
        if (pVar.P) {
            pVar.k(yVar);
        } else {
            pVar.e0();
        }
        b0.b.q(pVar, kVar, i1.g.f4477e);
        b0.b.q(pVar, t1VarL, i1.g.f4476d);
        b0.b.q(pVar, mVarV, i1.g.f4475c);
        i1.f fVar = i1.g.f4478f;
        if (pVar.P || !q7.k.a(pVar.J(), Integer.valueOf(iK))) {
            a1.a.r(iK, pVar, iK, fVar);
        }
        pVar.q(true);
    }

    public static final int c(float[] fArr) {
        int i2 = 0;
        if (fArr.length < 16) {
            return 0;
        }
        int i10 = (fArr[0] == 1.0f && fArr[1] == 0.0f && fArr[2] == 0.0f && fArr[4] == 0.0f && fArr[5] == 1.0f && fArr[6] == 0.0f && fArr[8] == 0.0f && fArr[9] == 0.0f && fArr[10] == 1.0f) ? 1 : 0;
        if (fArr[12] == 0.0f && fArr[13] == 0.0f && fArr[14] == 0.0f && fArr[15] == 1.0f) {
            i2 = 1;
        }
        return (i10 << 1) | i2;
    }

    public static final boolean d(long j2) {
        return !d2.i.a(j2, 9223372034707292159L);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0083 -> B:25:0x0066). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0086 -> B:25:0x0066). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object e(java.util.List r7, s2.i r8, i7.c r9) throws java.lang.Throwable {
        /*
            boolean r0 = r9 instanceof s2.d
            if (r0 == 0) goto L13
            r0 = r9
            s2.d r0 = (s2.d) r0
            int r1 = r0.f9347i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f9347i = r1
            goto L18
        L13:
            s2.d r0 = new s2.d
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.f9346h
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f9347i
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L42
            if (r2 == r4) goto L3a
            if (r2 != r3) goto L32
            java.util.Iterator r7 = r0.f9345g
            java.io.Serializable r8 = r0.f9344f
            q7.v r8 = (q7.v) r8
            w7.e0.N(r9)     // Catch: java.lang.Throwable -> L30
            goto L66
        L30:
            r9 = move-exception
            goto L7f
        L32:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3a:
            java.io.Serializable r7 = r0.f9344f
            java.util.List r7 = (java.util.List) r7
            w7.e0.N(r9)
            goto L5d
        L42:
            w7.e0.N(r9)
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            b0.g2 r2 = new b0.g2
            r5 = 0
            r6 = 7
            r2.<init>(r7, r9, r5, r6)
            r0.f9344f = r9
            r0.f9347i = r4
            java.lang.Object r7 = r8.a(r2, r0)
            if (r7 != r1) goto L5c
            goto L94
        L5c:
            r7 = r9
        L5d:
            q7.v r8 = new q7.v
            r8.<init>()
            java.util.Iterator r7 = r7.iterator()
        L66:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L8c
            java.lang.Object r9 = r7.next()
            p7.k r9 = (p7.k) r9
            r0.f9344f = r8     // Catch: java.lang.Throwable -> L30
            r0.f9345g = r7     // Catch: java.lang.Throwable -> L30
            r0.f9347i = r3     // Catch: java.lang.Throwable -> L30
            java.lang.Object r9 = r9.invoke(r0)     // Catch: java.lang.Throwable -> L30
            if (r9 != r1) goto L66
            goto L94
        L7f:
            java.lang.Object r2 = r8.f8820f
            if (r2 != 0) goto L86
            r8.f8820f = r9
            goto L66
        L86:
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            ib.k.e(r2, r9)
            goto L66
        L8c:
            java.lang.Object r7 = r8.f8820f
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            if (r7 != 0) goto L95
            c7.r r1 = c7.r.f1986a
        L94:
            return r1
        L95:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: n7.m.e(java.util.List, s2.i, i7.c):java.lang.Object");
    }

    public static final v9.q0 f(v vVar) {
        q7.k.e(vVar, "<this>");
        return new v9.q0(1, vVar);
    }

    public static int g(int i2, byte[] bArr) {
        return (bArr[i2 + 3] & 255) | (bArr[i2] << 24) | ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2 + 2] & 255) << 8);
    }

    public static int h(int i2, int i10, int i11) {
        int i12 = i10 & ((i2 >>> i11) ^ i2);
        return i2 ^ (i12 ^ (i12 << i11));
    }

    public static a3.b i(a3.b bVar, f8.f fVar, l8.o oVar, int i2) {
        if ((i2 & 2) != 0) {
            oVar = null;
        }
        q7.k.e(bVar, "<this>");
        return new a3.b((r8.a) bVar.f162f, oVar != null ? new g3.e(bVar, fVar, oVar, 0) : (r8.f) bVar.f163g, s7.a.G(c7.h.f1971g, new a8.e(14, bVar, fVar)));
    }

    public static final boolean j(v vVar, m0 m0Var, Set set) {
        boolean zJ;
        if (q7.k.a(vVar.E0(), m0Var)) {
            return true;
        }
        f8.g gVarC = vVar.E0().c();
        f8.h hVar = gVarC instanceof f8.h ? (f8.h) gVarC : null;
        List listS = hVar != null ? hVar.s() : null;
        Iterable iterableR1 = d7.r.r1(vVar.C0());
        if (!(iterableR1 instanceof Collection) || !((Collection) iterableR1).isEmpty()) {
            Iterator it = iterableR1.iterator();
            do {
                d0 d0Var = (d0) it;
                if (d0Var.f2955g.hasNext()) {
                    c0 c0Var = (c0) d0Var.next();
                    int i2 = c0Var.f2951a;
                    p0 p0Var = (p0) c0Var.f2952b;
                    q0 q0Var = listS != null ? (q0) d7.r.Q0(i2, listS) : null;
                    if ((q0Var == null || set == null || !set.contains(q0Var)) && !p0Var.c()) {
                        v vVarB = p0Var.b();
                        q7.k.d(vVarB, "argument.type");
                        zJ = j(vVarB, m0Var, set);
                    } else {
                        zJ = false;
                    }
                }
            } while (!zJ);
            return true;
        }
        return false;
    }

    public static final a3.b k(a3.b bVar, g8.j jVar) {
        q7.k.e(bVar, "<this>");
        q7.k.e(jVar, "additionalAnnotations");
        return jVar.isEmpty() ? bVar : new a3.b((r8.a) bVar.f162f, (r8.f) bVar.f163g, s7.a.G(c7.h.f1971g, new a8.e(15, bVar, jVar)));
    }

    public static final v1.e l(Context context) {
        h4.n nVar = new h4.n(26, false);
        context.getApplicationContext();
        return new v1.e(nVar, new v1.a(Build.VERSION.SDK_INT >= 31 ? v1.l.f10364a.a(context) : 0));
    }

    public static final v9.q0 m(v vVar, int i2, q0 q0Var) {
        q7.k.e(vVar, "type");
        x.t(i2, "projectionKind");
        if ((q0Var != null ? q0Var.a0() : 0) == i2) {
            i2 = 1;
        }
        return new v9.q0(i2, vVar);
    }

    public static boolean n(f8.b bVar, f8.b bVar2) {
        q7.k.e(bVar, "superDescriptor");
        q7.k.e(bVar2, "subDescriptor");
        if (!(bVar2 instanceof q8.e) || !(bVar instanceof f8.t)) {
            return false;
        }
        q8.e eVar = (q8.e) bVar2;
        eVar.x0().size();
        f8.t tVar = (f8.t) bVar;
        tVar.x0().size();
        List listX0 = eVar.a().x0();
        q7.k.d(listX0, "subDescriptor.original.valueParameters");
        List listX02 = tVar.a().x0();
        q7.k.d(listX02, "superDescriptor.original.valueParameters");
        Iterator it = d7.r.s1(listX0, listX02).iterator();
        while (it.hasNext()) {
            c7.j jVar = (c7.j) it.next();
            r0 r0Var = (r0) jVar.f1973f;
            r0 r0Var2 = (r0) jVar.f1974g;
            q7.k.d(r0Var, "subParameter");
            boolean z4 = C((f8.t) bVar2, r0Var) instanceof x8.i;
            q7.k.d(r0Var2, "superParameter");
            if (z4 != (C(tVar, r0Var2) instanceof x8.i)) {
                return true;
            }
        }
        return false;
    }

    public static final void o(v vVar, z zVar, LinkedHashSet linkedHashSet, Set set) {
        f8.g gVarC = vVar.E0().c();
        if (gVarC instanceof q0) {
            if (!q7.k.a(vVar.E0(), zVar.E0())) {
                linkedHashSet.add(gVarC);
                return;
            }
            for (v vVar2 : ((q0) gVarC).getUpperBounds()) {
                q7.k.d(vVar2, "upperBound");
                o(vVar2, zVar, linkedHashSet, set);
            }
            return;
        }
        f8.g gVarC2 = vVar.E0().c();
        f8.h hVar = gVarC2 instanceof f8.h ? (f8.h) gVarC2 : null;
        List listS = hVar != null ? hVar.s() : null;
        int i2 = 0;
        for (p0 p0Var : vVar.C0()) {
            int i10 = i2 + 1;
            q0 q0Var = listS != null ? (q0) d7.r.Q0(i2, listS) : null;
            if ((q0Var == null || set == null || !set.contains(q0Var)) && !p0Var.c() && !d7.r.I0(linkedHashSet, p0Var.b().E0().c()) && !q7.k.a(p0Var.b().E0(), zVar.E0())) {
                v vVarB = p0Var.b();
                q7.k.d(vVarB, "argument.type");
                o(vVarB, zVar, linkedHashSet, set);
            }
            i2 = i10;
        }
    }

    public static final HashSet p(Iterable iterable) {
        HashSet hashSet = new HashSet();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            Set setG = ((o9.n) it.next()).g();
            if (setG == null) {
                return null;
            }
            d7.x.D0(hashSet, setG);
        }
        return hashSet;
    }

    public static x8.o q(w7.e0 e0Var) {
        if (e0Var instanceof d9.e) {
            d9.e eVar = (d9.e) e0Var;
            String str = eVar.f3006c;
            String str2 = eVar.f3007d;
            q7.k.e(str, "name");
            q7.k.e(str2, "desc");
            return new x8.o(str.concat(str2));
        }
        if (!(e0Var instanceof d9.d)) {
            throw new u();
        }
        d9.d dVar = (d9.d) e0Var;
        String str3 = dVar.f3004c;
        String str4 = dVar.f3005d;
        q7.k.e(str3, "name");
        q7.k.e(str4, "desc");
        return new x8.o(str3 + '#' + str4);
    }

    public static final c8.h r(v vVar) {
        q7.k.e(vVar, "<this>");
        c8.h hVarN = vVar.E0().n();
        q7.k.d(hVarN, "constructor.builtIns");
        return hVarN;
    }

    public static final w7.d s(ua.d dVar) {
        q7.k.e(dVar, "<this>");
        if (dVar instanceof wa.k) {
            return s(((wa.k) dVar).f10987a);
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [c7.f, java.lang.Object] */
    public static final Field t(w7.t tVar) {
        q7.k.e(tVar, "<this>");
        k1 k1VarC = x1.c(tVar);
        if (k1VarC != null) {
            return (Field) k1VarC.f11898n.getValue();
        }
        return null;
    }

    public static final Method u(w7.g gVar) {
        a8.h hVarY;
        q7.k.e(gVar, "<this>");
        s sVarA = x1.a(gVar);
        Member memberJ = (sVarA == null || (hVarY = sVarA.y()) == null) ? null : hVarY.j();
        if (memberJ instanceof Method) {
            return (Method) memberJ;
        }
        return null;
    }

    public static final Type v(w7.u uVar) {
        q7.k.e(uVar, "<this>");
        q1 q1Var = ((m1) uVar).f11909g;
        Type type = q1Var != null ? (Type) q1Var.c() : null;
        return type == null ? w7.e0.C(uVar) : type;
    }

    public static final sa.a w(sa.a aVar) {
        return aVar.a().g() ? aVar : new wa.f(aVar);
    }

    public static final v x(q0 q0Var) {
        Object obj;
        q7.k.e(q0Var, "<this>");
        List upperBounds = q0Var.getUpperBounds();
        q7.k.d(upperBounds, "upperBounds");
        upperBounds.isEmpty();
        List upperBounds2 = q0Var.getUpperBounds();
        q7.k.d(upperBounds2, "upperBounds");
        Iterator it = upperBounds2.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            f8.g gVarC = ((v) next).E0().c();
            f8.e eVar = gVarC instanceof f8.e ? (f8.e) gVarC : null;
            if (eVar != null && eVar.B() != 2 && eVar.B() != 5) {
                obj = next;
                break;
            }
        }
        v vVar = (v) obj;
        if (vVar != null) {
            return vVar;
        }
        List upperBounds3 = q0Var.getUpperBounds();
        q7.k.d(upperBounds3, "upperBounds");
        Object objN0 = d7.r.N0(upperBounds3);
        q7.k.d(objN0, "upperBounds.first()");
        return (v) objN0;
    }

    public static final boolean y(q0 q0Var, m0 m0Var, Set set) {
        q7.k.e(q0Var, "typeParameter");
        List<v> upperBounds = q0Var.getUpperBounds();
        q7.k.d(upperBounds, "typeParameter.upperBounds");
        if (upperBounds.isEmpty()) {
            return false;
        }
        for (v vVar : upperBounds) {
            q7.k.d(vVar, "upperBound");
            if (j(vVar, q0Var.k().E0(), set) && (m0Var == null || q7.k.a(vVar.E0(), m0Var))) {
                return true;
            }
        }
        return false;
    }

    public static int z(int i2) {
        if (i2 == 1) {
            return 0;
        }
        if (i2 == 2) {
            return 1;
        }
        if (i2 == 4) {
            return 2;
        }
        if (i2 == 8) {
            return 3;
        }
        if (i2 == 16) {
            return 4;
        }
        if (i2 == 32) {
            return 5;
        }
        if (i2 == 64) {
            return 6;
        }
        if (i2 == 128) {
            return 7;
        }
        if (i2 == 256) {
            return 8;
        }
        if (i2 == 512) {
            return 9;
        }
        throw new IllegalArgumentException(n.f.c(i2, "type needs to be >= FIRST and <= LAST, type="));
    }
}
