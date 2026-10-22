package nb;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Trace;
import android.util.Log;
import b0.p;
import b0.z1;
import com.google.protobuf.a1;
import com.google.protobuf.x0;
import com.google.protobuf.y0;
import f8.l0;
import f8.t;
import f9.n;
import fi.iki.elonen.NanoHTTPD;
import i8.r0;
import ia.a2;
import ia.d0;
import ia.k0;
import ia.v;
import java.lang.annotation.Annotation;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import n7.m;
import na.r;
import nb.i;
import o4.f2;
import q7.w;
import q7.z;
import u0.c0;
import u0.q;
import w7.e0;
import x8.o;
import z8.f0;

/* loaded from: classes.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public static volatile a5.a f6978a;

    /* renamed from: b, reason: collision with root package name */
    public static volatile a5.a f6979b;

    /* renamed from: c, reason: collision with root package name */
    public static volatile a5.a f6980c;

    public static final f8.c A(f8.c cVar) {
        q7.k.e(cVar, "<this>");
        f8.c cVarZ = z(cVar);
        if (cVarZ != null) {
            return cVarZ;
        }
        int i2 = o8.f.f7813l;
        e9.f name = cVar.getName();
        q7.k.d(name, "name");
        if (o8.f.b(name)) {
            return l9.d.b(cVar, o8.e.f7805n);
        }
        return null;
    }

    public static final o B(f0 f0Var, b9.f fVar, b9.g gVar, boolean z4, boolean z10, boolean z11) {
        q7.k.e(f0Var, "proto");
        q7.k.e(fVar, "nameResolver");
        n nVar = c9.l.f2165d;
        q7.k.d(nVar, "propertySignature");
        c9.f fVar2 = (c9.f) e0.A(f0Var, nVar);
        if (fVar2 != null) {
            if (z4) {
                f9.h hVar = d9.h.f3015a;
                d9.d dVarB = d9.h.b(f0Var, fVar, gVar, z11);
                if (dVarB != null) {
                    return m.q(dVarB);
                }
            } else if (z10 && (fVar2.f2117g & 2) == 2) {
                c9.d dVar = fVar2.f2119i;
                q7.k.d(dVar, "signature.syntheticMethod");
                return new o(fVar.getString(dVar.f2104h).concat(fVar.getString(dVar.f2105i)));
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0144, code lost:
    
        if (r6 == null) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x014b, code lost:
    
        return !c8.h.z(r12);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean D(f8.e r12, f8.c r13) {
        /*
            Method dump skipped, instructions count: 366
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: nb.i.D(f8.e, f8.c):boolean");
    }

    public static final boolean E(l0 l0Var) {
        q7.k.e(l0Var, "<this>");
        return l0Var.b() == null;
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x016d A[PHI: r20 r21 r22 r23 r24 r25 r26 r27 r28
      0x016d: PHI (r20v6 o0.c) = (r20v5 o0.c), (r20v7 o0.c) binds: [B:10:0x004e, B:62:0x016b] A[DONT_GENERATE, DONT_INLINE]
      0x016d: PHI (r21v6 boolean) = (r21v5 boolean), (r21v7 boolean) binds: [B:10:0x004e, B:62:0x016b] A[DONT_GENERATE, DONT_INLINE]
      0x016d: PHI (r22v11 r1.a) = (r22v10 r1.a), (r22v12 r1.a) binds: [B:10:0x004e, B:62:0x016b] A[DONT_GENERATE, DONT_INLINE]
      0x016d: PHI (r23v6 o0.k) = (r23v5 o0.k), (r23v7 o0.k) binds: [B:10:0x004e, B:62:0x016b] A[DONT_GENERATE, DONT_INLINE]
      0x016d: PHI (r24v6 java.lang.Boolean) = (r24v5 java.lang.Boolean), (r24v7 java.lang.Boolean) binds: [B:10:0x004e, B:62:0x016b] A[DONT_GENERATE, DONT_INLINE]
      0x016d: PHI (r25v6 p1.f) = (r25v5 p1.f), (r25v7 p1.f) binds: [B:10:0x004e, B:62:0x016b] A[DONT_GENERATE, DONT_INLINE]
      0x016d: PHI (r26v6 boolean) = (r26v5 boolean), (r26v7 boolean) binds: [B:10:0x004e, B:62:0x016b] A[DONT_GENERATE, DONT_INLINE]
      0x016d: PHI (r27v6 java.lang.Integer) = (r27v5 java.lang.Integer), (r27v7 java.lang.Integer) binds: [B:10:0x004e, B:62:0x016b] A[DONT_GENERATE, DONT_INLINE]
      0x016d: PHI (r28v12 s1.e) = (r28v11 s1.e), (r28v13 s1.e) binds: [B:10:0x004e, B:62:0x016b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void F(android.view.ViewStructure r38, i1.f0 r39, android.view.autofill.AutofillId r40, java.lang.String r41, q1.a r42) {
        /*
            Method dump skipped, instructions count: 940
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: nb.i.F(android.view.ViewStructure, i1.f0, android.view.autofill.AutofillId, java.lang.String, q1.a):void");
    }

    public static LinkedHashSet G(e9.f fVar, Collection collection, Collection collection2, f8.e eVar, r9.l lVar, h9.l lVar2, boolean z4) {
        if (fVar == null) {
            a(12);
            throw null;
        }
        if (collection == null) {
            a(13);
            throw null;
        }
        if (eVar == null) {
            a(15);
            throw null;
        }
        if (lVar == null) {
            a(16);
            throw null;
        }
        if (lVar2 == null) {
            a(17);
            throw null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        lVar2.h(fVar, collection, collection2, eVar, new p8.a(lVar, linkedHashSet, z4));
        return linkedHashSet;
    }

    public static LinkedHashSet H(e9.f fVar, AbstractCollection abstractCollection, Collection collection, f8.e eVar, r9.l lVar, h9.l lVar2) {
        if (fVar == null) {
            a(0);
            throw null;
        }
        if (eVar == null) {
            a(3);
            throw null;
        }
        if (lVar == null) {
            a(4);
            throw null;
        }
        if (lVar2 != null) {
            return G(fVar, abstractCollection, collection, eVar, lVar, lVar2, false);
        }
        a(5);
        throw null;
    }

    public static LinkedHashSet I(e9.f fVar, Collection collection, AbstractCollection abstractCollection, s8.j jVar, r9.l lVar, h9.l lVar2) {
        if (fVar == null) {
            a(6);
            throw null;
        }
        if (collection == null) {
            a(7);
            throw null;
        }
        if (jVar == null) {
            a(9);
            throw null;
        }
        if (lVar == null) {
            a(10);
            throw null;
        }
        if (lVar2 != null) {
            return G(fVar, collection, abstractCollection, jVar, lVar, lVar2, true);
        }
        a(11);
        throw null;
    }

    public static ArrayList J(PackageInfo packageInfo) {
        try {
            SigningInfo signingInfo = packageInfo.signingInfo;
            if (signingInfo == null) {
                return null;
            }
            Signature[] apkContentsSigners = signingInfo.hasMultipleSigners() ? signingInfo.getApkContentsSigners() : signingInfo.getSigningCertificateHistory();
            if (apkContentsSigners == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(apkContentsSigners.length);
            for (Signature signature : apkContentsSigners) {
                arrayList.add(signature.toByteArray());
            }
            return arrayList;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final Object K(r rVar, boolean z4, r rVar2, p7.n nVar) throws Throwable {
        Object vVar;
        Object objY;
        try {
            if (nVar instanceof i7.a) {
                z.c(2, nVar);
                vVar = nVar.invoke(rVar2, rVar);
            } else {
                vVar = ib.k.X(nVar, rVar2, rVar);
            }
        } catch (k0 e10) {
            Throwable th = e10.f4965f;
            rVar.X(new v(th, false));
            throw th;
        } catch (Throwable th2) {
            vVar = new v(th2, false);
        }
        h7.a aVar = h7.a.f4212f;
        if (vVar == aVar || (objY = rVar.Y(vVar)) == d0.f4939e) {
            return aVar;
        }
        rVar.o0();
        if (!(objY instanceof v)) {
            return d0.z(objY);
        }
        if (!z4) {
            Throwable th3 = ((v) objY).f5011a;
            if ((th3 instanceof a2) && ((a2) th3).f4918f == rVar) {
                if (vVar instanceof v) {
                    throw ((v) vVar).f5011a;
                }
                return vVar;
            }
        }
        throw ((v) objY).f5011a;
    }

    public static v7.b L(v7.d dVar, int i2) {
        q7.k.e(dVar, "<this>");
        boolean z4 = i2 > 0;
        Integer numValueOf = Integer.valueOf(i2);
        if (!z4) {
            throw new IllegalArgumentException("Step must be positive, was: " + numValueOf + '.');
        }
        int i10 = dVar.f10523f;
        int i11 = dVar.f10524g;
        if (dVar.f10525h <= 0) {
            i2 = -i2;
        }
        return new v7.b(i10, i11, i2);
    }

    public static void M(ob.g gVar, byte[] bArr) {
        long j2;
        q7.k.e(gVar, "cursor");
        q7.k.e(bArr, "key");
        int length = bArr.length;
        int i2 = 0;
        do {
            byte[] bArr2 = gVar.f7986j;
            int i10 = gVar.f7987k;
            int i11 = gVar.f7988l;
            if (bArr2 != null) {
                while (i10 < i11) {
                    int i12 = i2 % length;
                    bArr2[i10] = (byte) (bArr2[i10] ^ bArr[i12]);
                    i10++;
                    i2 = i12 + 1;
                }
            }
            long j4 = gVar.f7985i;
            ob.h hVar = gVar.f7982f;
            q7.k.b(hVar);
            if (j4 == hVar.f7993g) {
                throw new IllegalStateException("no more bytes");
            }
            j2 = gVar.f7985i;
        } while (gVar.b(j2 == -1 ? 0L : j2 + (gVar.f7988l - gVar.f7987k)) != -1);
    }

    public static v7.d N(int i2, int i10) {
        if (i10 > Integer.MIN_VALUE) {
            return new v7.d(i2, i10 - 1, 1);
        }
        v7.d dVar = v7.d.f10530i;
        return v7.d.f10530i;
    }

    public static /* synthetic */ void a(int i2) {
        String str = i2 != 18 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i2 != 18 ? 3 : 2];
        switch (i2) {
            case 1:
            case 7:
            case 13:
                objArr[0] = "membersFromSupertypes";
                break;
            case 2:
            case 8:
            case y0.EDITION_FIELD_NUMBER /* 14 */:
                objArr[0] = "membersFromCurrent";
                break;
            case 3:
            case 9:
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                objArr[0] = "classDescriptor";
                break;
            case 4:
            case 10:
            case 16:
                objArr[0] = "errorReporter";
                break;
            case 5:
            case 11:
            case 17:
                objArr[0] = "overridingUtil";
                break;
            case 6:
            case 12:
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
            default:
                objArr[0] = "name";
                break;
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils";
                break;
            case 20:
                objArr[0] = "annotationClass";
                break;
        }
        if (i2 != 18) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils";
        } else {
            objArr[1] = "resolveOverrides";
        }
        switch (i2) {
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                objArr[2] = "resolveOverridesForStaticMembers";
                break;
            case 12:
            case 13:
            case y0.EDITION_FIELD_NUMBER /* 14 */:
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
            case 16:
            case 17:
                objArr[2] = "resolveOverrides";
                break;
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
                break;
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
            case 20:
                objArr[2] = "getAnnotationParameterByName";
                break;
            default:
                objArr[2] = "resolveOverridesForNonStaticMembers";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i2 == 18) {
            throw new IllegalStateException(str2);
        }
    }

    public static long b(float f10) {
        return (Float.floatToRawIntBits(f10) << 32) | (Float.floatToRawIntBits(f10) & 4294967295L);
    }

    public static final void c(final Boolean bool, final Object obj, androidx.lifecycle.v vVar, final p7.k kVar, p pVar, final int i2) {
        int i10;
        pVar.T(696924721);
        if ((i2 & 6) == 0) {
            i10 = (pVar.h(bool) ? 4 : 2) | i2;
        } else {
            i10 = i2;
        }
        int i11 = i10 | (pVar.h(obj) ? 32 : 16) | 128 | (pVar.h(kVar) ? 2048 : NanoHTTPD.HTTPSession.MAX_HEADER_SIZE);
        if (pVar.L(i11 & 1, (i11 & 1171) != 1170)) {
            pVar.Q();
            if ((i2 & 1) == 0 || pVar.x()) {
                vVar = (androidx.lifecycle.v) pVar.j(z2.f.f11798a);
            } else {
                pVar.O();
            }
            int i12 = i11 & (-897);
            pVar.r();
            boolean zF = pVar.f(bool) | pVar.f(obj) | pVar.f(vVar);
            Object objJ = pVar.J();
            if (zF || objJ == b0.k.f1229a) {
                objJ = new z2.e(vVar.a());
                pVar.b0(objJ);
            }
            d(vVar, (z2.e) objJ, kVar, pVar, (i12 >> 3) & 896);
        } else {
            pVar.O();
        }
        final androidx.lifecycle.v vVar2 = vVar;
        z1 z1VarS = pVar.s();
        if (z1VarS != null) {
            z1VarS.f1444d = new p7.n() { // from class: z2.a
                @Override // p7.n
                public final Object invoke(Object obj2, Object obj3) {
                    ((Integer) obj3).getClass();
                    i.c(bool, obj, vVar2, kVar, (p) obj2, b0.b.s(i2 | 1));
                    return c7.r.f1986a;
                }
            };
        }
    }

    public static final void d(androidx.lifecycle.v vVar, z2.e eVar, p7.k kVar, p pVar, int i2) {
        int i10;
        pVar.T(228371534);
        if ((i2 & 6) == 0) {
            i10 = (pVar.h(vVar) ? 4 : 2) | i2;
        } else {
            i10 = i2;
        }
        if ((i2 & 48) == 0) {
            i10 |= pVar.h(eVar) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i10 |= pVar.h(kVar) ? 256 : 128;
        }
        if (pVar.L(i10 & 1, (i10 & 147) != 146)) {
            boolean zH = pVar.h(eVar) | ((i10 & 896) == 256) | pVar.h(vVar);
            Object objJ = pVar.J();
            if (zH || objJ == b0.k.f1229a) {
                objJ = new f2(vVar, eVar, kVar, 1);
                pVar.b0(objJ);
            }
            b0.b.c(vVar, eVar, (p7.k) objJ, pVar);
        } else {
            pVar.O();
        }
        z1 z1VarS = pVar.s();
        if (z1VarS != null) {
            z1VarS.f1444d = new j0.b(vVar, eVar, kVar, i2, 1);
        }
    }

    public static final long e(float f10, float f11) {
        return (Float.floatToRawIntBits(f11) & 4294967295L) | (Float.floatToRawIntBits(f10) << 32);
    }

    public static void f(String str) {
        if (str.length() > 127) {
            str = str.substring(0, 127);
        }
        Trace.beginSection(str);
    }

    public static final int g(float f10) {
        return Math.round((float) Math.ceil(f10));
    }

    public static final n0.m h(n0.m mVar, c0 c0Var) {
        long j2 = u0.f0.f9906a;
        long j4 = q.f9922a;
        return androidx.compose.ui.graphics.a.c(mVar, 0.0f, j2, c0Var, true, j4, j4);
    }

    public static double i(double d6, double d10, double d11) {
        if (d10 <= d11) {
            return d6 < d10 ? d10 : d6 > d11 ? d11 : d6;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + d11 + " is less than minimum " + d10 + '.');
    }

    public static float j(float f10, float f11, float f12) {
        if (f11 <= f12) {
            return f10 < f11 ? f11 : f10 > f12 ? f12 : f10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f12 + " is less than minimum " + f11 + '.');
    }

    public static int k(int i2, int i10, int i11) {
        if (i10 <= i11) {
            return i2 < i10 ? i10 : i2 > i11 ? i11 : i2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i11 + " is less than minimum " + i10 + '.');
    }

    public static long l(long j2, long j4, long j10) {
        if (j4 <= j10) {
            return j2 < j4 ? j4 : j2 > j10 ? j10 : j2;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j10 + " is less than minimum " + j4 + '.');
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String m(f8.t r5, int r6) {
        /*
            r0 = r6 & 1
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L8
            r0 = r2
            goto L9
        L8:
            r0 = r1
        L9:
            r6 = r6 & 2
            if (r6 == 0) goto Le
            r1 = r2
        Le:
            java.lang.String r6 = "<this>"
            q7.k.e(r5, r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            if (r1 == 0) goto L34
            boolean r1 = r5 instanceof f8.i
            if (r1 == 0) goto L21
            java.lang.String r1 = "<init>"
            goto L31
        L21:
            r1 = r5
            i8.m r1 = (i8.m) r1
            e9.f r1 = r1.getName()
            java.lang.String r1 = r1.b()
            java.lang.String r2 = "name.asString()"
            q7.k.d(r1, r2)
        L31:
            r6.append(r1)
        L34:
            java.lang.String r1 = "("
            r6.append(r1)
            i8.v r1 = r5.I()
            ea.c r2 = ea.c.f3228g
            if (r1 == 0) goto L50
            v9.v r1 = r1.getType()
            x8.q r3 = x8.q.f11275k
            java.lang.Object r1 = n7.a.r(r1, r3, r2)
            x8.j r1 = (x8.j) r1
            r6.append(r1)
        L50:
            java.util.List r1 = r5.x0()
            java.util.Iterator r1 = r1.iterator()
        L58:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L7b
            java.lang.Object r3 = r1.next()
            i8.r0 r3 = (i8.r0) r3
            i8.s0 r3 = (i8.s0) r3
            v9.v r3 = r3.getType()
            java.lang.String r4 = "parameter.type"
            q7.k.d(r3, r4)
            x8.q r4 = x8.q.f11275k
            java.lang.Object r3 = n7.a.r(r3, r4, r2)
            x8.j r3 = (x8.j) r3
            r6.append(r3)
            goto L58
        L7b:
            java.lang.String r1 = ")"
            r6.append(r1)
            if (r0 == 0) goto Lc1
            boolean r0 = r5 instanceof f8.i
            if (r0 == 0) goto L87
            goto La9
        L87:
            v9.v r0 = r5.f()
            q7.k.b(r0)
            e9.f r1 = c8.h.f1999e
            e9.e r1 = c8.m.f2033d
            boolean r0 = c8.h.D(r0, r1)
            if (r0 == 0) goto Laf
            v9.v r0 = r5.f()
            q7.k.b(r0)
            boolean r0 = v9.x0.e(r0)
            if (r0 != 0) goto Laf
            boolean r0 = r5 instanceof i8.j0
            if (r0 != 0) goto Laf
        La9:
            java.lang.String r5 = "V"
            r6.append(r5)
            goto Lc1
        Laf:
            v9.v r5 = r5.f()
            q7.k.b(r5)
            x8.q r0 = x8.q.f11275k
            java.lang.Object r5 = n7.a.r(r5, r0, r2)
            x8.j r5 = (x8.j) r5
            r6.append(r5)
        Lc1:
            java.lang.String r5 = r6.toString()
            java.lang.String r6 = "StringBuilder().apply(builderAction).toString()"
            q7.k.d(r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: nb.i.m(f8.t, int):java.lang.String");
    }

    public static final String n(f8.b bVar) {
        q7.k.e(bVar, "<this>");
        if (!h9.f.o(bVar)) {
            f8.j jVarP = bVar.p();
            f8.e eVar = jVarP instanceof f8.e ? (f8.e) jVarP : null;
            if (eVar != null && !eVar.getName().f3198g) {
                f8.b bVarA = bVar.a();
                i8.l0 l0Var = bVarA instanceof i8.l0 ? (i8.l0) bVarA : null;
                if (l0Var != null) {
                    return n7.o.A(eVar, m(l0Var, 3));
                }
            }
        }
        return null;
    }

    public static x2.o o(Context context) {
        ProviderInfo providerInfo;
        m2.c cVar;
        ApplicationInfo applicationInfo;
        PackageManager packageManager = context.getPackageManager();
        ib.c.n(packageManager, "Package manager required to locate emoji font provider");
        Iterator<ResolveInfo> it = packageManager.queryIntentContentProviders(new Intent("androidx.content.action.LOAD_EMOJI_FONT"), 0).iterator();
        while (true) {
            if (!it.hasNext()) {
                providerInfo = null;
                break;
            }
            providerInfo = it.next().providerInfo;
            if (providerInfo != null && (applicationInfo = providerInfo.applicationInfo) != null && (applicationInfo.flags & 1) == 1) {
                break;
            }
        }
        if (providerInfo == null) {
            cVar = null;
        } else {
            try {
                String str = providerInfo.authority;
                String str2 = providerInfo.packageName;
                Signature[] signatureArr = packageManager.getPackageInfo(str2, 64).signatures;
                ArrayList arrayList = new ArrayList();
                for (Signature signature : signatureArr) {
                    arrayList.add(signature.toByteArray());
                }
                cVar = new m2.c(str, str2, "emojicompat-emoji-font", Collections.singletonList(arrayList), null, null);
            } catch (PackageManager.NameNotFoundException e10) {
                Log.wtf("emoji2.text.DefaultEmojiConfig", e10);
            }
        }
        if (cVar == null) {
            return null;
        }
        return new x2.o(new x2.n(context, cVar));
    }

    public static final w7.d p(Annotation annotation) {
        q7.k.e(annotation, "<this>");
        Class<? extends Annotation> clsAnnotationType = annotation.annotationType();
        q7.k.d(clsAnnotationType, "annotationType(...)");
        return x(clsAnnotationType);
    }

    public static r0 q(e9.f fVar, f8.e eVar) {
        if (fVar == null) {
            a(19);
            throw null;
        }
        if (eVar == null) {
            a(20);
            throw null;
        }
        Collection collectionE = eVar.E();
        if (collectionE.size() != 1) {
            return null;
        }
        for (r0 r0Var : ((i8.i) collectionE.iterator().next()).x0()) {
            if (r0Var.getName().equals(fVar)) {
                return r0Var;
            }
        }
        return null;
    }

    public static final long r(long j2) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j2 >> 32)) / 2.0f;
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j2 & 4294967295L)) / 2.0f;
        return (Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32);
    }

    public static final e9.b s(b9.f fVar, int i2) {
        q7.k.e(fVar, "<this>");
        return e9.b.e(fVar.r0(i2), fVar.a0(i2));
    }

    public static final Class t(w7.d dVar) {
        q7.k.e(dVar, "<this>");
        Class clsC = ((q7.d) dVar).c();
        q7.k.c(clsC, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return clsC;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    public static final Class u(w7.d dVar) {
        q7.k.e(dVar, "<this>");
        Class clsC = ((q7.d) dVar).c();
        if (!clsC.isPrimitive()) {
            return clsC;
        }
        String name = clsC.getName();
        switch (name.hashCode()) {
            case -1325958191:
                if (!name.equals("double")) {
                }
                break;
            case 104431:
                if (!name.equals("int")) {
                }
                break;
            case 3039496:
                if (!name.equals("byte")) {
                }
                break;
            case 3052374:
                if (!name.equals("char")) {
                }
                break;
            case 3327612:
                if (!name.equals("long")) {
                }
                break;
            case 3625364:
                if (!name.equals("void")) {
                }
                break;
            case 64711720:
                if (!name.equals("boolean")) {
                }
                break;
            case 97526364:
                if (!name.equals("float")) {
                }
                break;
            case 109413500:
                if (!name.equals("short")) {
                }
                break;
        }
        return clsC;
    }

    public static final Class v(w7.d dVar) {
        q7.k.e(dVar, "<this>");
        Class clsC = ((q7.d) dVar).c();
        if (clsC.isPrimitive()) {
            return clsC;
        }
        String name = clsC.getName();
        switch (name.hashCode()) {
            case -2056817302:
                if (name.equals("java.lang.Integer")) {
                    return Integer.TYPE;
                }
                return null;
            case -527879800:
                if (name.equals("java.lang.Float")) {
                    return Float.TYPE;
                }
                return null;
            case -515992664:
                if (name.equals("java.lang.Short")) {
                    return Short.TYPE;
                }
                return null;
            case 155276373:
                if (name.equals("java.lang.Character")) {
                    return Character.TYPE;
                }
                return null;
            case 344809556:
                if (name.equals("java.lang.Boolean")) {
                    return Boolean.TYPE;
                }
                return null;
            case 398507100:
                if (name.equals("java.lang.Byte")) {
                    return Byte.TYPE;
                }
                return null;
            case 398795216:
                if (name.equals("java.lang.Long")) {
                    return Long.TYPE;
                }
                return null;
            case 399092968:
                if (name.equals("java.lang.Void")) {
                    return Void.TYPE;
                }
                return null;
            case 761287205:
                if (name.equals("java.lang.Double")) {
                    return Double.TYPE;
                }
                return null;
            default:
                return null;
        }
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Object, java.util.Map] */
    public static final String w(t tVar) {
        e9.f fVar;
        f8.c cVarZ = c8.h.z(tVar) ? z(tVar) : null;
        if (cVarZ != null) {
            f8.c cVarK = l9.d.k(cVarZ);
            if (cVarK instanceof l0) {
                c8.h.z(cVarK);
                f8.c cVarB = l9.d.b(l9.d.k(cVarK), o8.e.f7801j);
                if (cVarB != null && (fVar = (e9.f) o8.g.f7825a.get(l9.d.g(cVarB))) != null) {
                    return fVar.b();
                }
            } else if (cVarK instanceof i8.l0) {
                int i2 = o8.d.f7798l;
                LinkedHashMap linkedHashMap = o8.f0.f7822i;
                String strN = n((i8.l0) cVarK);
                e9.f fVar2 = strN == null ? null : (e9.f) linkedHashMap.get(strN);
                if (fVar2 != null) {
                    return fVar2.b();
                }
            }
        }
        return null;
    }

    public static final w7.d x(Class cls) {
        q7.k.e(cls, "<this>");
        return w.f8821a.b(cls);
    }

    public static final e9.f y(b9.f fVar, int i2) {
        q7.k.e(fVar, "<this>");
        return e9.f.d(fVar.getString(i2));
    }

    public static final f8.c z(f8.c cVar) {
        q7.k.e(cVar, "<this>");
        if (!o8.f0.f7823j.contains(cVar.getName()) && !o8.g.f7828d.contains(l9.d.k(cVar).getName())) {
            return null;
        }
        if (cVar instanceof l0 ? true : cVar instanceof f8.k0) {
            return l9.d.b(cVar, o8.e.f7803l);
        }
        if (cVar instanceof i8.l0) {
            return l9.d.b(cVar, o8.e.f7804m);
        }
        return null;
    }
}
