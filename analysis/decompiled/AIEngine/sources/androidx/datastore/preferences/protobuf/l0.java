package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.ByteString;
import androidx.datastore.preferences.protobuf.CodedOutputStream;
import androidx.datastore.preferences.protobuf.c0;
import androidx.datastore.preferences.protobuf.g1;
import androidx.datastore.preferences.protobuf.q;
import androidx.datastore.preferences.protobuf.u;
import com.stepos.deepbinder.core.exception.ErrorCodes;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class l0<T> implements w0<T> {

    /* renamed from: q, reason: collision with root package name */
    public static final int[] f1846q = new int[0];
    public static final Unsafe r = g1.i();

    /* renamed from: a, reason: collision with root package name */
    public final int[] f1847a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f1848b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1849c;

    /* renamed from: d, reason: collision with root package name */
    public final int f1850d;

    /* renamed from: e, reason: collision with root package name */
    public final i0 f1851e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f1852f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f1853g;
    public final boolean h;

    /* renamed from: i, reason: collision with root package name */
    public final int[] f1854i;

    /* renamed from: j, reason: collision with root package name */
    public final int f1855j;

    /* renamed from: k, reason: collision with root package name */
    public final int f1856k;

    /* renamed from: l, reason: collision with root package name */
    public final n0 f1857l;

    /* renamed from: m, reason: collision with root package name */
    public final z f1858m;

    /* renamed from: n, reason: collision with root package name */
    public final c1<?, ?> f1859n;

    /* renamed from: o, reason: collision with root package name */
    public final n<?> f1860o;

    /* renamed from: p, reason: collision with root package name */
    public final d0 f1861p;

    public l0(int[] iArr, Object[] objArr, int i10, int i11, i0 i0Var, boolean z, int[] iArr2, int i12, int i13, n0 n0Var, z zVar, c1 c1Var, n nVar, d0 d0Var) {
        this.f1847a = iArr;
        this.f1848b = objArr;
        this.f1849c = i10;
        this.f1850d = i11;
        this.f1853g = i0Var instanceof GeneratedMessageLite;
        this.h = z;
        this.f1852f = nVar != null && nVar.e(i0Var);
        this.f1854i = iArr2;
        this.f1855j = i12;
        this.f1856k = i13;
        this.f1857l = n0Var;
        this.f1858m = zVar;
        this.f1859n = c1Var;
        this.f1860o = nVar;
        this.f1851e = i0Var;
        this.f1861p = d0Var;
    }

    public static long A(long j10, Object obj) {
        return ((Long) g1.f1818d.i(j10, obj)).longValue();
    }

    public static Field C(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            StringBuilder sbQ = a0.a.q("Field ", str, " for ");
            sbQ.append(cls.getName());
            sbQ.append(" not found. Known fields are ");
            sbQ.append(Arrays.toString(declaredFields));
            throw new RuntimeException(sbQ.toString());
        }
    }

    public static int F(int i10) {
        return (i10 & 267386880) >>> 20;
    }

    public static void J(int i10, Object obj, h1 h1Var) {
        if (obj instanceof String) {
            ((j) h1Var).f1844a.M(i10, (String) obj);
        } else {
            ((j) h1Var).a(i10, (ByteString) obj);
        }
    }

    public static List s(long j10, Object obj) {
        return (List) g1.f1818d.i(j10, obj);
    }

    public static l0 w(g0 g0Var, n0 n0Var, z zVar, c1 c1Var, n nVar, d0 d0Var) {
        if (g0Var instanceof u0) {
            return x((u0) g0Var, n0Var, zVar, c1Var, nVar, d0Var);
        }
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x03a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static <T> androidx.datastore.preferences.protobuf.l0<T> x(androidx.datastore.preferences.protobuf.u0 r35, androidx.datastore.preferences.protobuf.n0 r36, androidx.datastore.preferences.protobuf.z r37, androidx.datastore.preferences.protobuf.c1<?, ?> r38, androidx.datastore.preferences.protobuf.n<?> r39, androidx.datastore.preferences.protobuf.d0 r40) {
        /*
            Method dump skipped, instructions count: 1041
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.l0.x(androidx.datastore.preferences.protobuf.u0, androidx.datastore.preferences.protobuf.n0, androidx.datastore.preferences.protobuf.z, androidx.datastore.preferences.protobuf.c1, androidx.datastore.preferences.protobuf.n, androidx.datastore.preferences.protobuf.d0):androidx.datastore.preferences.protobuf.l0");
    }

    public static long y(int i10) {
        return i10 & 1048575;
    }

    public static int z(long j10, Object obj) {
        return ((Integer) g1.f1818d.i(j10, obj)).intValue();
    }

    public final void B(Object obj, int i10, v0 v0Var) {
        if ((536870912 & i10) != 0) {
            g1.o(i10 & 1048575, obj, v0Var.M());
        } else if (this.f1853g) {
            g1.o(i10 & 1048575, obj, v0Var.C());
        } else {
            g1.o(i10 & 1048575, obj, v0Var.o());
        }
    }

    public final void D(int i10, Object obj) {
        if (this.h) {
            return;
        }
        int i11 = this.f1847a[i10 + 2];
        long j10 = i11 & 1048575;
        g1.m(j10, g1.f1818d.g(j10, obj) | (1 << (i11 >>> 20)), obj);
    }

    public final void E(int i10, int i11, Object obj) {
        g1.m(this.f1847a[i11 + 2] & 1048575, i10, obj);
    }

    public final int G(int i10) {
        return this.f1847a[i10 + 1];
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0023  */
    /* JADX WARN: Type inference failed for: r19v0 */
    /* JADX WARN: Type inference failed for: r19v1, types: [long] */
    /* JADX WARN: Type inference failed for: r19v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void H(T r24, androidx.datastore.preferences.protobuf.h1 r25) {
        /*
            Method dump skipped, instructions count: 1518
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.l0.H(java.lang.Object, androidx.datastore.preferences.protobuf.h1):void");
    }

    public final <K, V> void I(h1 h1Var, int i10, Object obj, int i11) {
        if (obj != null) {
            Object objM = m(i11);
            d0 d0Var = this.f1861p;
            c0.a<?, ?> aVarB = d0Var.b(objM);
            MapFieldLite mapFieldLiteD = d0Var.d(obj);
            CodedOutputStream codedOutputStream = ((j) h1Var).f1844a;
            codedOutputStream.getClass();
            for (Map.Entry<K, V> entry : mapFieldLiteD.entrySet()) {
                codedOutputStream.O(i10, 2);
                codedOutputStream.Q(c0.a(aVarB, entry.getKey(), entry.getValue()));
                c0.b(codedOutputStream, aVarB, entry.getKey(), entry.getValue());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:188:0x0685 A[Catch: all -> 0x025c, TryCatch #11 {all -> 0x025c, blocks: (B:186:0x0680, B:188:0x0685, B:189:0x068a, B:94:0x024a, B:97:0x025f, B:98:0x026e, B:99:0x027d, B:100:0x028c, B:101:0x029b, B:102:0x02b4, B:103:0x02c3, B:104:0x02d3, B:105:0x02e3, B:106:0x02f3, B:107:0x0303, B:108:0x0313, B:109:0x0323, B:110:0x0333, B:111:0x0343, B:112:0x0353, B:113:0x0363, B:114:0x0373, B:115:0x0383, B:116:0x039c, B:117:0x03ac, B:118:0x03bc, B:119:0x03d4, B:121:0x03e1, B:122:0x03ed, B:123:0x03f9, B:124:0x0409, B:125:0x0419, B:126:0x0429, B:127:0x0439, B:128:0x0449, B:129:0x0459, B:130:0x0469), top: B:216:0x0680 }] */
    /* JADX WARN: Removed duplicated region for block: B:200:0x06ab A[LOOP:4: B:199:0x06a9->B:200:0x06ab, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:202:0x06b6  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x009b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:232:0x004a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0690 A[SYNTHETIC] */
    @Override // androidx.datastore.preferences.protobuf.w0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(T r18, androidx.datastore.preferences.protobuf.v0 r19, androidx.datastore.preferences.protobuf.m r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1864
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.l0.a(java.lang.Object, androidx.datastore.preferences.protobuf.v0, androidx.datastore.preferences.protobuf.m):void");
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public final void b(T t8) {
        int[] iArr;
        int i10;
        int i11 = this.f1855j;
        while (true) {
            iArr = this.f1854i;
            i10 = this.f1856k;
            if (i11 >= i10) {
                break;
            }
            long jG = G(iArr[i11]) & 1048575;
            Object objI = g1.f1818d.i(jG, t8);
            if (objI != null) {
                g1.o(jG, t8, this.f1861p.e(objI));
            }
            i11++;
        }
        int length = iArr.length;
        while (i10 < length) {
            this.f1858m.a(iArr[i10], t8);
            i10++;
        }
        this.f1859n.j(t8);
        if (this.f1852f) {
            this.f1860o.f(t8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.datastore.preferences.protobuf.w0
    public final int c(a aVar) {
        return this.h ? p(aVar) : o(aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0049  */
    /* JADX WARN: Type inference failed for: r4v3, types: [androidx.datastore.preferences.protobuf.w0] */
    /* JADX WARN: Type inference failed for: r4v5, types: [androidx.datastore.preferences.protobuf.w0] */
    /* JADX WARN: Type inference failed for: r4v6, types: [androidx.datastore.preferences.protobuf.w0] */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v26, types: [androidx.datastore.preferences.protobuf.w0] */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v30 */
    @Override // androidx.datastore.preferences.protobuf.w0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean d(T r15) {
        /*
            Method dump skipped, instructions count: 308
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.l0.d(java.lang.Object):boolean");
    }

    @Override // androidx.datastore.preferences.protobuf.w0
    public final T e() {
        return (T) this.f1857l.a(this.f1851e);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001f  */
    @Override // androidx.datastore.preferences.protobuf.w0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(androidx.datastore.preferences.protobuf.GeneratedMessageLite r11, androidx.datastore.preferences.protobuf.GeneratedMessageLite r12) {
        /*
            Method dump skipped, instructions count: 612
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.l0.f(androidx.datastore.preferences.protobuf.GeneratedMessageLite, androidx.datastore.preferences.protobuf.GeneratedMessageLite):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00e1 A[PHI: r3
      0x00e1: PHI (r3v32 int) = (r3v10 int), (r3v33 int) binds: [B:83:0x0216, B:41:0x00df] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.datastore.preferences.protobuf.w0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int g(androidx.datastore.preferences.protobuf.GeneratedMessageLite r12) {
        /*
            Method dump skipped, instructions count: 812
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.l0.g(androidx.datastore.preferences.protobuf.GeneratedMessageLite):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x002b  */
    @Override // androidx.datastore.preferences.protobuf.w0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(T r18, androidx.datastore.preferences.protobuf.h1 r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 2004
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.l0.h(java.lang.Object, androidx.datastore.preferences.protobuf.h1):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    @Override // androidx.datastore.preferences.protobuf.w0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean i(androidx.datastore.preferences.protobuf.GeneratedMessageLite r12, androidx.datastore.preferences.protobuf.GeneratedMessageLite r13) {
        /*
            Method dump skipped, instructions count: 680
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.l0.i(androidx.datastore.preferences.protobuf.GeneratedMessageLite, androidx.datastore.preferences.protobuf.GeneratedMessageLite):boolean");
    }

    public final boolean j(GeneratedMessageLite generatedMessageLite, Object obj, int i10) {
        return q(i10, generatedMessageLite) == q(i10, obj);
    }

    public final <UT, UB> UB k(Object obj, int i10, UB ub2, c1<UT, UB> c1Var) {
        u.b bVarL;
        int i11 = this.f1847a[i10];
        Object objI = g1.f1818d.i(G(i10) & 1048575, obj);
        if (objI == null || (bVarL = l(i10)) == null) {
            return ub2;
        }
        d0 d0Var = this.f1861p;
        MapFieldLite mapFieldLiteC = d0Var.c(objI);
        c0.a<?, ?> aVarB = d0Var.b(m(i10));
        Iterator it = mapFieldLiteC.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            ((Integer) entry.getValue()).getClass();
            if (!bVarL.a()) {
                if (ub2 == null) {
                    ub2 = (UB) c1Var.m();
                }
                int iA = c0.a(aVarB, entry.getKey(), entry.getValue());
                byte[] bArr = new byte[iA];
                Logger logger = CodedOutputStream.f1721c;
                CodedOutputStream.b bVar = new CodedOutputStream.b(bArr, iA);
                try {
                    c0.b(bVar, aVarB, entry.getKey(), entry.getValue());
                    if (bVar.f1728f - bVar.f1729g != 0) {
                        throw new IllegalStateException("Did not write as much data as expected.");
                    }
                    c1Var.d(ub2, i11, new ByteString.LiteralByteString(bArr));
                    it.remove();
                } catch (IOException e10) {
                    throw new RuntimeException(e10);
                }
            }
        }
        return ub2;
    }

    public final u.b l(int i10) {
        return (u.b) this.f1848b[((i10 / 3) * 2) + 1];
    }

    public final Object m(int i10) {
        return this.f1848b[(i10 / 3) * 2];
    }

    public final w0 n(int i10) {
        int i11 = (i10 / 3) * 2;
        Object[] objArr = this.f1848b;
        w0 w0Var = (w0) objArr[i11];
        if (w0Var != null) {
            return w0Var;
        }
        w0<T> w0VarA = s0.f1880c.a((Class) objArr[i11 + 1]);
        objArr[i11] = w0VarA;
        return w0VarA;
    }

    public final int o(T t8) {
        int i10;
        int iS;
        int iV;
        int iS2;
        int iP;
        int iN;
        int iS3;
        int iR;
        int iE;
        int iS4;
        int iO;
        Unsafe unsafe = r;
        int i11 = -1;
        int i12 = 0;
        int iB = 0;
        int i13 = 0;
        while (true) {
            int[] iArr = this.f1847a;
            if (i12 >= iArr.length) {
                c1<?, ?> c1Var = this.f1859n;
                int iH = c1Var.h(c1Var.g(t8)) + iB;
                if (!this.f1852f) {
                    return iH;
                }
                y0 y0Var = this.f1860o.c(t8).f1876a;
                int iC = 0;
                for (int i14 = 0; i14 < y0Var.f1908b.size(); i14++) {
                    Map.Entry<Object, Object> entryC = y0Var.c(i14);
                    iC += q.c((q.a) entryC.getKey(), entryC.getValue());
                }
                for (Map.Entry<Object, Object> entry : y0Var.e()) {
                    iC += q.c((q.a) entry.getKey(), entry.getValue());
                }
                return iH + iC;
            }
            int iG = G(i12);
            int i15 = iArr[i12];
            int iF = F(iG);
            if (iF <= 17) {
                int i16 = iArr[i12 + 2];
                int i17 = i16 & 1048575;
                i10 = 1 << (i16 >>> 20);
                if (i17 != i11) {
                    i13 = unsafe.getInt(t8, i17);
                    i11 = i17;
                }
            } else {
                i10 = 0;
            }
            long j10 = iG & 1048575;
            switch (iF) {
                case 0:
                    if ((i10 & i13) != 0) {
                        iB = a0.a.b(i15, 8, iB);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if ((i13 & i10) != 0) {
                        iB = a0.a.b(i15, 4, iB);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if ((i13 & i10) != 0) {
                        long j11 = unsafe.getLong(t8, j10);
                        iS = CodedOutputStream.s(i15);
                        iV = CodedOutputStream.v(j11);
                        iS4 = iV + iS;
                        iB += iS4;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if ((i13 & i10) != 0) {
                        long j12 = unsafe.getLong(t8, j10);
                        iS = CodedOutputStream.s(i15);
                        iV = CodedOutputStream.v(j12);
                        iS4 = iV + iS;
                        iB += iS4;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if ((i13 & i10) != 0) {
                        int i18 = unsafe.getInt(t8, j10);
                        iS2 = CodedOutputStream.s(i15);
                        iP = CodedOutputStream.p(i18);
                        iN = iP + iS2;
                        iB += iN;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if ((i13 & i10) != 0) {
                        iN = CodedOutputStream.n(i15);
                        iB += iN;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if ((i13 & i10) != 0) {
                        iN = CodedOutputStream.m(i15);
                        iB += iN;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if ((i13 & i10) != 0) {
                        iB = a0.a.b(i15, 1, iB);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if ((i13 & i10) == 0) {
                        break;
                    } else {
                        Object object = unsafe.getObject(t8, j10);
                        if (object instanceof ByteString) {
                            int iS5 = CodedOutputStream.s(i15);
                            int size = ((ByteString) object).size();
                            iE = ai.onnxruntime.a.e(size, size, iS5, iB);
                            iB = iE;
                            break;
                        } else {
                            iS3 = CodedOutputStream.s(i15);
                            iR = CodedOutputStream.r((String) object);
                            iE = iR + iS3 + iB;
                            iB = iE;
                        }
                    }
                case 9:
                    if ((i13 & i10) != 0) {
                        iN = x0.l(i15, unsafe.getObject(t8, j10), n(i12));
                        iB += iN;
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if ((i13 & i10) != 0) {
                        iN = CodedOutputStream.k(i15, (ByteString) unsafe.getObject(t8, j10));
                        iB += iN;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if ((i13 & i10) != 0) {
                        iN = CodedOutputStream.t(i15, unsafe.getInt(t8, j10));
                        iB += iN;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if ((i13 & i10) != 0) {
                        int i19 = unsafe.getInt(t8, j10);
                        iS2 = CodedOutputStream.s(i15);
                        iP = CodedOutputStream.p(i19);
                        iN = iP + iS2;
                        iB += iN;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if ((i13 & i10) != 0) {
                        iB = a0.a.b(i15, 4, iB);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if ((i10 & i13) != 0) {
                        iB = a0.a.b(i15, 8, iB);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if ((i13 & i10) != 0) {
                        int i20 = unsafe.getInt(t8, j10);
                        iS2 = CodedOutputStream.s(i15);
                        iP = CodedOutputStream.u((i20 >> 31) ^ (i20 << 1));
                        iN = iP + iS2;
                        iB += iN;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if ((i13 & i10) != 0) {
                        long j13 = unsafe.getLong(t8, j10);
                        iS = CodedOutputStream.s(i15);
                        iV = CodedOutputStream.v((j13 >> 63) ^ (j13 << 1));
                        iS4 = iV + iS;
                        iB += iS4;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if ((i13 & i10) != 0) {
                        iN = CodedOutputStream.o(i15, (i0) unsafe.getObject(t8, j10), n(i12));
                        iB += iN;
                        break;
                    } else {
                        break;
                    }
                case 18:
                    iN = x0.f(i15, (List) unsafe.getObject(t8, j10));
                    iB += iN;
                    break;
                case 19:
                    iN = x0.d(i15, (List) unsafe.getObject(t8, j10));
                    iB += iN;
                    break;
                case 20:
                    iN = x0.j(i15, (List) unsafe.getObject(t8, j10));
                    iB += iN;
                    break;
                case 21:
                    iN = x0.u(i15, (List) unsafe.getObject(t8, j10));
                    iB += iN;
                    break;
                case 22:
                    iN = x0.h(i15, (List) unsafe.getObject(t8, j10));
                    iB += iN;
                    break;
                case 23:
                    iN = x0.f(i15, (List) unsafe.getObject(t8, j10));
                    iB += iN;
                    break;
                case ErrorCodes.GET_INSTANCE_METHOD_INVOCATION_ERROR /* 24 */:
                    iN = x0.d(i15, (List) unsafe.getObject(t8, j10));
                    iB += iN;
                    break;
                case 25:
                    List list = (List) unsafe.getObject(t8, j10);
                    Class<?> cls = x0.f1899a;
                    int size2 = list.size();
                    iS4 = size2 == 0 ? 0 : (CodedOutputStream.s(i15) + 1) * size2;
                    iB += iS4;
                    break;
                case 26:
                    iN = x0.r(i15, (List) unsafe.getObject(t8, j10));
                    iB += iN;
                    break;
                case 27:
                    iN = x0.m(i15, (List) unsafe.getObject(t8, j10), n(i12));
                    iB += iN;
                    break;
                case ErrorCodes.GET_CONTENT_URI_ERROR /* 28 */:
                    iN = x0.a(i15, (List) unsafe.getObject(t8, j10));
                    iB += iN;
                    break;
                case ErrorCodes.GET_PACKAGE_INFO_ERROR /* 29 */:
                    iN = x0.s(i15, (List) unsafe.getObject(t8, j10));
                    iB += iN;
                    break;
                case 30:
                    iN = x0.b(i15, (List) unsafe.getObject(t8, j10));
                    iB += iN;
                    break;
                case 31:
                    iN = x0.d(i15, (List) unsafe.getObject(t8, j10));
                    iB += iN;
                    break;
                case 32:
                    iN = x0.f(i15, (List) unsafe.getObject(t8, j10));
                    iB += iN;
                    break;
                case 33:
                    iN = x0.n(i15, (List) unsafe.getObject(t8, j10));
                    iB += iN;
                    break;
                case 34:
                    iN = x0.p(i15, (List) unsafe.getObject(t8, j10));
                    iB += iN;
                    break;
                case 35:
                    int iG2 = x0.g((List) unsafe.getObject(t8, j10));
                    if (iG2 > 0) {
                        iB = ai.onnxruntime.a.e(iG2, CodedOutputStream.s(i15), iG2, iB);
                        break;
                    } else {
                        break;
                    }
                case 36:
                    int iE2 = x0.e((List) unsafe.getObject(t8, j10));
                    if (iE2 > 0) {
                        iB = ai.onnxruntime.a.e(iE2, CodedOutputStream.s(i15), iE2, iB);
                        break;
                    } else {
                        break;
                    }
                case 37:
                    int iK = x0.k((List) unsafe.getObject(t8, j10));
                    if (iK > 0) {
                        iB = ai.onnxruntime.a.e(iK, CodedOutputStream.s(i15), iK, iB);
                        break;
                    } else {
                        break;
                    }
                case 38:
                    int iV2 = x0.v((List) unsafe.getObject(t8, j10));
                    if (iV2 > 0) {
                        iB = ai.onnxruntime.a.e(iV2, CodedOutputStream.s(i15), iV2, iB);
                        break;
                    } else {
                        break;
                    }
                case 39:
                    int i21 = x0.i((List) unsafe.getObject(t8, j10));
                    if (i21 > 0) {
                        iB = ai.onnxruntime.a.e(i21, CodedOutputStream.s(i15), i21, iB);
                        break;
                    } else {
                        break;
                    }
                case 40:
                    int iG3 = x0.g((List) unsafe.getObject(t8, j10));
                    if (iG3 > 0) {
                        iB = ai.onnxruntime.a.e(iG3, CodedOutputStream.s(i15), iG3, iB);
                        break;
                    } else {
                        break;
                    }
                case 41:
                    int iE3 = x0.e((List) unsafe.getObject(t8, j10));
                    if (iE3 > 0) {
                        iB = ai.onnxruntime.a.e(iE3, CodedOutputStream.s(i15), iE3, iB);
                        break;
                    } else {
                        break;
                    }
                case 42:
                    List list2 = (List) unsafe.getObject(t8, j10);
                    Class<?> cls2 = x0.f1899a;
                    int size3 = list2.size();
                    if (size3 > 0) {
                        iB = ai.onnxruntime.a.e(size3, CodedOutputStream.s(i15), size3, iB);
                        break;
                    } else {
                        break;
                    }
                case ErrorCodes.API_VERSION_CODE_TOO_HIGH /* 43 */:
                    int iT = x0.t((List) unsafe.getObject(t8, j10));
                    if (iT > 0) {
                        iB = ai.onnxruntime.a.e(iT, CodedOutputStream.s(i15), iT, iB);
                        break;
                    } else {
                        break;
                    }
                case ErrorCodes.NOT_SET_VERSION_CODE_ERROR /* 44 */:
                    int iC2 = x0.c((List) unsafe.getObject(t8, j10));
                    if (iC2 > 0) {
                        iB = ai.onnxruntime.a.e(iC2, CodedOutputStream.s(i15), iC2, iB);
                        break;
                    } else {
                        break;
                    }
                case ErrorCodes.CALLER_NOT_IN_METHOD_WHITE_LIST_ERROR /* 45 */:
                    int iE4 = x0.e((List) unsafe.getObject(t8, j10));
                    if (iE4 > 0) {
                        iB = ai.onnxruntime.a.e(iE4, CodedOutputStream.s(i15), iE4, iB);
                        break;
                    } else {
                        break;
                    }
                case ErrorCodes.CALLER_IN_METHOD_BLACK_LIST_ERROR /* 46 */:
                    int iG4 = x0.g((List) unsafe.getObject(t8, j10));
                    if (iG4 > 0) {
                        iB = ai.onnxruntime.a.e(iG4, CodedOutputStream.s(i15), iG4, iB);
                        break;
                    } else {
                        break;
                    }
                case ErrorCodes.CALLER_NOT_IN_SERVICE_WHITE_LIST_ERROR /* 47 */:
                    int iO2 = x0.o((List) unsafe.getObject(t8, j10));
                    if (iO2 > 0) {
                        iB = ai.onnxruntime.a.e(iO2, CodedOutputStream.s(i15), iO2, iB);
                        break;
                    } else {
                        break;
                    }
                case ErrorCodes.CALLER_IN_SERVICE_BLACK_LIST_ERROR /* 48 */:
                    int iQ = x0.q((List) unsafe.getObject(t8, j10));
                    if (iQ > 0) {
                        iB = ai.onnxruntime.a.e(iQ, CodedOutputStream.s(i15), iQ, iB);
                        break;
                    } else {
                        break;
                    }
                case ErrorCodes.PRE_SERVICE_METHOD_INTERCEPT_ERROR /* 49 */:
                    List list3 = (List) unsafe.getObject(t8, j10);
                    w0 w0VarN = n(i12);
                    Class<?> cls3 = x0.f1899a;
                    int size4 = list3.size();
                    if (size4 == 0) {
                        iO = 0;
                    } else {
                        iO = 0;
                        for (int i22 = 0; i22 < size4; i22++) {
                            iO += CodedOutputStream.o(i15, (i0) list3.get(i22), w0VarN);
                        }
                    }
                    iB += iO;
                    break;
                case ErrorCodes.AFTER_SERVICE_METHOD_INTERCEPT_ERROR /* 50 */:
                    iN = this.f1861p.g(i15, unsafe.getObject(t8, j10), m(i12));
                    iB += iN;
                    break;
                case ErrorCodes.SERVICE_RECYCLE_ERROR /* 51 */:
                    if (r(i15, i12, t8)) {
                        iB = a0.a.b(i15, 8, iB);
                        break;
                    } else {
                        break;
                    }
                case ErrorCodes.CALLER_PROTOCOL_VERSION_TOO_HIGH /* 52 */:
                    if (r(i15, i12, t8)) {
                        iB = a0.a.b(i15, 4, iB);
                        break;
                    } else {
                        break;
                    }
                case ErrorCodes.CALLBACK_RECYCLE_ERROR /* 53 */:
                    if (r(i15, i12, t8)) {
                        long jA = A(j10, t8);
                        iS = CodedOutputStream.s(i15);
                        iV = CodedOutputStream.v(jA);
                        iS4 = iV + iS;
                        iB += iS4;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (r(i15, i12, t8)) {
                        long jA2 = A(j10, t8);
                        iS = CodedOutputStream.s(i15);
                        iV = CodedOutputStream.v(jA2);
                        iS4 = iV + iS;
                        iB += iS4;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (r(i15, i12, t8)) {
                        int iZ = z(j10, t8);
                        iS2 = CodedOutputStream.s(i15);
                        iP = CodedOutputStream.p(iZ);
                        iN = iP + iS2;
                        iB += iN;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (r(i15, i12, t8)) {
                        iN = CodedOutputStream.n(i15);
                        iB += iN;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (r(i15, i12, t8)) {
                        iN = CodedOutputStream.m(i15);
                        iB += iN;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (r(i15, i12, t8)) {
                        iB = a0.a.b(i15, 1, iB);
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (!r(i15, i12, t8)) {
                        break;
                    } else {
                        Object object2 = unsafe.getObject(t8, j10);
                        if (object2 instanceof ByteString) {
                            int iS6 = CodedOutputStream.s(i15);
                            int size5 = ((ByteString) object2).size();
                            iE = ai.onnxruntime.a.e(size5, size5, iS6, iB);
                            iB = iE;
                            break;
                        } else {
                            iS3 = CodedOutputStream.s(i15);
                            iR = CodedOutputStream.r((String) object2);
                            iE = iR + iS3 + iB;
                            iB = iE;
                        }
                    }
                case 60:
                    if (r(i15, i12, t8)) {
                        iN = x0.l(i15, unsafe.getObject(t8, j10), n(i12));
                        iB += iN;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (r(i15, i12, t8)) {
                        iN = CodedOutputStream.k(i15, (ByteString) unsafe.getObject(t8, j10));
                        iB += iN;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (r(i15, i12, t8)) {
                        iN = CodedOutputStream.t(i15, z(j10, t8));
                        iB += iN;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (r(i15, i12, t8)) {
                        int iZ2 = z(j10, t8);
                        iS2 = CodedOutputStream.s(i15);
                        iP = CodedOutputStream.p(iZ2);
                        iN = iP + iS2;
                        iB += iN;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (r(i15, i12, t8)) {
                        iB = a0.a.b(i15, 4, iB);
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (r(i15, i12, t8)) {
                        iB = a0.a.b(i15, 8, iB);
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (r(i15, i12, t8)) {
                        int iZ3 = z(j10, t8);
                        iS2 = CodedOutputStream.s(i15);
                        iP = CodedOutputStream.u((iZ3 >> 31) ^ (iZ3 << 1));
                        iN = iP + iS2;
                        iB += iN;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (r(i15, i12, t8)) {
                        long jA3 = A(j10, t8);
                        iS = CodedOutputStream.s(i15);
                        iV = CodedOutputStream.v((jA3 >> 63) ^ (jA3 << 1));
                        iS4 = iV + iS;
                        iB += iS4;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (r(i15, i12, t8)) {
                        iN = CodedOutputStream.o(i15, (i0) unsafe.getObject(t8, j10), n(i12));
                        iB += iN;
                        break;
                    } else {
                        break;
                    }
            }
            i12 += 3;
        }
    }

    public final int p(T t8) {
        int iS;
        int iV;
        int iS2;
        int iP;
        int iN;
        int iS3;
        int iR;
        int iS4;
        int iV2;
        int iO;
        Unsafe unsafe = r;
        int i10 = 0;
        int iB = 0;
        while (true) {
            int[] iArr = this.f1847a;
            if (i10 >= iArr.length) {
                c1<?, ?> c1Var = this.f1859n;
                return c1Var.h(c1Var.g(t8)) + iB;
            }
            int iG = G(i10);
            int iF = F(iG);
            int i11 = iArr[i10];
            long j10 = iG & 1048575;
            if (iF >= FieldType.f1730b.f1734a && iF <= FieldType.f1731c.f1734a) {
                int i12 = iArr[i10 + 2];
            }
            switch (iF) {
                case 0:
                    if (q(i10, t8)) {
                        iB = a0.a.b(i11, 8, iB);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (q(i10, t8)) {
                        iB = a0.a.b(i11, 4, iB);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (q(i10, t8)) {
                        long jH = g1.f1818d.h(j10, t8);
                        iS = CodedOutputStream.s(i11);
                        iV = CodedOutputStream.v(jH);
                        iN = iV + iS;
                        iB += iN;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (q(i10, t8)) {
                        long jH2 = g1.f1818d.h(j10, t8);
                        iS = CodedOutputStream.s(i11);
                        iV = CodedOutputStream.v(jH2);
                        iN = iV + iS;
                        iB += iN;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (q(i10, t8)) {
                        int iG2 = g1.f1818d.g(j10, t8);
                        iS2 = CodedOutputStream.s(i11);
                        iP = CodedOutputStream.p(iG2);
                        iN = iP + iS2;
                        iB += iN;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (q(i10, t8)) {
                        iN = CodedOutputStream.n(i11);
                        iB += iN;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (q(i10, t8)) {
                        iN = CodedOutputStream.m(i11);
                        iB += iN;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (q(i10, t8)) {
                        iB = a0.a.b(i11, 1, iB);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (q(i10, t8)) {
                        Object objI = g1.f1818d.i(j10, t8);
                        if (objI instanceof ByteString) {
                            int iS5 = CodedOutputStream.s(i11);
                            int size = ((ByteString) objI).size();
                            iB = ai.onnxruntime.a.e(size, size, iS5, iB);
                            break;
                        } else {
                            iS3 = CodedOutputStream.s(i11);
                            iR = CodedOutputStream.r((String) objI);
                            iB = iR + iS3 + iB;
                            break;
                        }
                    } else {
                        break;
                    }
                case 9:
                    if (q(i10, t8)) {
                        iN = x0.l(i11, g1.f1818d.i(j10, t8), n(i10));
                        iB += iN;
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (q(i10, t8)) {
                        iN = CodedOutputStream.k(i11, (ByteString) g1.f1818d.i(j10, t8));
                        iB += iN;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (q(i10, t8)) {
                        iN = CodedOutputStream.t(i11, g1.f1818d.g(j10, t8));
                        iB += iN;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (q(i10, t8)) {
                        int iG3 = g1.f1818d.g(j10, t8);
                        iS2 = CodedOutputStream.s(i11);
                        iP = CodedOutputStream.p(iG3);
                        iN = iP + iS2;
                        iB += iN;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (q(i10, t8)) {
                        iB = a0.a.b(i11, 4, iB);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (q(i10, t8)) {
                        iB = a0.a.b(i11, 8, iB);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (q(i10, t8)) {
                        int iG4 = g1.f1818d.g(j10, t8);
                        iS2 = CodedOutputStream.s(i11);
                        iP = CodedOutputStream.u((iG4 >> 31) ^ (iG4 << 1));
                        iN = iP + iS2;
                        iB += iN;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (q(i10, t8)) {
                        long jH3 = g1.f1818d.h(j10, t8);
                        iS4 = CodedOutputStream.s(i11);
                        iV2 = CodedOutputStream.v((jH3 >> 63) ^ (jH3 << 1));
                        iN = iV2 + iS4;
                        iB += iN;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (q(i10, t8)) {
                        iN = CodedOutputStream.o(i11, (i0) g1.f1818d.i(j10, t8), n(i10));
                        iB += iN;
                        break;
                    } else {
                        break;
                    }
                case 18:
                    iN = x0.f(i11, s(j10, t8));
                    iB += iN;
                    break;
                case 19:
                    iN = x0.d(i11, s(j10, t8));
                    iB += iN;
                    break;
                case 20:
                    iN = x0.j(i11, s(j10, t8));
                    iB += iN;
                    break;
                case 21:
                    iN = x0.u(i11, s(j10, t8));
                    iB += iN;
                    break;
                case 22:
                    iN = x0.h(i11, s(j10, t8));
                    iB += iN;
                    break;
                case 23:
                    iN = x0.f(i11, s(j10, t8));
                    iB += iN;
                    break;
                case ErrorCodes.GET_INSTANCE_METHOD_INVOCATION_ERROR /* 24 */:
                    iN = x0.d(i11, s(j10, t8));
                    iB += iN;
                    break;
                case 25:
                    List listS = s(j10, t8);
                    Class<?> cls = x0.f1899a;
                    int size2 = listS.size();
                    iB += size2 == 0 ? 0 : (CodedOutputStream.s(i11) + 1) * size2;
                    break;
                case 26:
                    iN = x0.r(i11, s(j10, t8));
                    iB += iN;
                    break;
                case 27:
                    iN = x0.m(i11, s(j10, t8), n(i10));
                    iB += iN;
                    break;
                case ErrorCodes.GET_CONTENT_URI_ERROR /* 28 */:
                    iN = x0.a(i11, s(j10, t8));
                    iB += iN;
                    break;
                case ErrorCodes.GET_PACKAGE_INFO_ERROR /* 29 */:
                    iN = x0.s(i11, s(j10, t8));
                    iB += iN;
                    break;
                case 30:
                    iN = x0.b(i11, s(j10, t8));
                    iB += iN;
                    break;
                case 31:
                    iN = x0.d(i11, s(j10, t8));
                    iB += iN;
                    break;
                case 32:
                    iN = x0.f(i11, s(j10, t8));
                    iB += iN;
                    break;
                case 33:
                    iN = x0.n(i11, s(j10, t8));
                    iB += iN;
                    break;
                case 34:
                    iN = x0.p(i11, s(j10, t8));
                    iB += iN;
                    break;
                case 35:
                    int iG5 = x0.g((List) unsafe.getObject(t8, j10));
                    if (iG5 > 0) {
                        iB = ai.onnxruntime.a.e(iG5, CodedOutputStream.s(i11), iG5, iB);
                        break;
                    } else {
                        break;
                    }
                case 36:
                    int iE = x0.e((List) unsafe.getObject(t8, j10));
                    if (iE > 0) {
                        iB = ai.onnxruntime.a.e(iE, CodedOutputStream.s(i11), iE, iB);
                        break;
                    } else {
                        break;
                    }
                case 37:
                    int iK = x0.k((List) unsafe.getObject(t8, j10));
                    if (iK > 0) {
                        iB = ai.onnxruntime.a.e(iK, CodedOutputStream.s(i11), iK, iB);
                        break;
                    } else {
                        break;
                    }
                case 38:
                    int iV3 = x0.v((List) unsafe.getObject(t8, j10));
                    if (iV3 > 0) {
                        iB = ai.onnxruntime.a.e(iV3, CodedOutputStream.s(i11), iV3, iB);
                        break;
                    } else {
                        break;
                    }
                case 39:
                    int i13 = x0.i((List) unsafe.getObject(t8, j10));
                    if (i13 > 0) {
                        iB = ai.onnxruntime.a.e(i13, CodedOutputStream.s(i11), i13, iB);
                        break;
                    } else {
                        break;
                    }
                case 40:
                    int iG6 = x0.g((List) unsafe.getObject(t8, j10));
                    if (iG6 > 0) {
                        iB = ai.onnxruntime.a.e(iG6, CodedOutputStream.s(i11), iG6, iB);
                        break;
                    } else {
                        break;
                    }
                case 41:
                    int iE2 = x0.e((List) unsafe.getObject(t8, j10));
                    if (iE2 > 0) {
                        iB = ai.onnxruntime.a.e(iE2, CodedOutputStream.s(i11), iE2, iB);
                        break;
                    } else {
                        break;
                    }
                case 42:
                    List list = (List) unsafe.getObject(t8, j10);
                    Class<?> cls2 = x0.f1899a;
                    int size3 = list.size();
                    if (size3 > 0) {
                        iB = ai.onnxruntime.a.e(size3, CodedOutputStream.s(i11), size3, iB);
                        break;
                    } else {
                        break;
                    }
                case ErrorCodes.API_VERSION_CODE_TOO_HIGH /* 43 */:
                    int iT = x0.t((List) unsafe.getObject(t8, j10));
                    if (iT > 0) {
                        iB = ai.onnxruntime.a.e(iT, CodedOutputStream.s(i11), iT, iB);
                        break;
                    } else {
                        break;
                    }
                case ErrorCodes.NOT_SET_VERSION_CODE_ERROR /* 44 */:
                    int iC = x0.c((List) unsafe.getObject(t8, j10));
                    if (iC > 0) {
                        iB = ai.onnxruntime.a.e(iC, CodedOutputStream.s(i11), iC, iB);
                        break;
                    } else {
                        break;
                    }
                case ErrorCodes.CALLER_NOT_IN_METHOD_WHITE_LIST_ERROR /* 45 */:
                    int iE3 = x0.e((List) unsafe.getObject(t8, j10));
                    if (iE3 > 0) {
                        iB = ai.onnxruntime.a.e(iE3, CodedOutputStream.s(i11), iE3, iB);
                        break;
                    } else {
                        break;
                    }
                case ErrorCodes.CALLER_IN_METHOD_BLACK_LIST_ERROR /* 46 */:
                    int iG7 = x0.g((List) unsafe.getObject(t8, j10));
                    if (iG7 > 0) {
                        iB = ai.onnxruntime.a.e(iG7, CodedOutputStream.s(i11), iG7, iB);
                        break;
                    } else {
                        break;
                    }
                case ErrorCodes.CALLER_NOT_IN_SERVICE_WHITE_LIST_ERROR /* 47 */:
                    int iO2 = x0.o((List) unsafe.getObject(t8, j10));
                    if (iO2 > 0) {
                        iB = ai.onnxruntime.a.e(iO2, CodedOutputStream.s(i11), iO2, iB);
                        break;
                    } else {
                        break;
                    }
                case ErrorCodes.CALLER_IN_SERVICE_BLACK_LIST_ERROR /* 48 */:
                    int iQ = x0.q((List) unsafe.getObject(t8, j10));
                    if (iQ > 0) {
                        iB = ai.onnxruntime.a.e(iQ, CodedOutputStream.s(i11), iQ, iB);
                        break;
                    } else {
                        break;
                    }
                case ErrorCodes.PRE_SERVICE_METHOD_INTERCEPT_ERROR /* 49 */:
                    List listS2 = s(j10, t8);
                    w0 w0VarN = n(i10);
                    Class<?> cls3 = x0.f1899a;
                    int size4 = listS2.size();
                    if (size4 == 0) {
                        iO = 0;
                    } else {
                        iO = 0;
                        for (int i14 = 0; i14 < size4; i14++) {
                            iO += CodedOutputStream.o(i11, (i0) listS2.get(i14), w0VarN);
                        }
                    }
                    iB += iO;
                    break;
                case ErrorCodes.AFTER_SERVICE_METHOD_INTERCEPT_ERROR /* 50 */:
                    iN = this.f1861p.g(i11, g1.f1818d.i(j10, t8), m(i10));
                    iB += iN;
                    break;
                case ErrorCodes.SERVICE_RECYCLE_ERROR /* 51 */:
                    if (r(i11, i10, t8)) {
                        iB = a0.a.b(i11, 8, iB);
                        break;
                    } else {
                        break;
                    }
                case ErrorCodes.CALLER_PROTOCOL_VERSION_TOO_HIGH /* 52 */:
                    if (r(i11, i10, t8)) {
                        iB = a0.a.b(i11, 4, iB);
                        break;
                    } else {
                        break;
                    }
                case ErrorCodes.CALLBACK_RECYCLE_ERROR /* 53 */:
                    if (r(i11, i10, t8)) {
                        long jA = A(j10, t8);
                        iS = CodedOutputStream.s(i11);
                        iV = CodedOutputStream.v(jA);
                        iN = iV + iS;
                        iB += iN;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (r(i11, i10, t8)) {
                        long jA2 = A(j10, t8);
                        iS = CodedOutputStream.s(i11);
                        iV = CodedOutputStream.v(jA2);
                        iN = iV + iS;
                        iB += iN;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (r(i11, i10, t8)) {
                        int iZ = z(j10, t8);
                        iS2 = CodedOutputStream.s(i11);
                        iP = CodedOutputStream.p(iZ);
                        iN = iP + iS2;
                        iB += iN;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (r(i11, i10, t8)) {
                        iN = CodedOutputStream.n(i11);
                        iB += iN;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (r(i11, i10, t8)) {
                        iN = CodedOutputStream.m(i11);
                        iB += iN;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (r(i11, i10, t8)) {
                        iB = a0.a.b(i11, 1, iB);
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (r(i11, i10, t8)) {
                        Object objI2 = g1.f1818d.i(j10, t8);
                        if (objI2 instanceof ByteString) {
                            int iS6 = CodedOutputStream.s(i11);
                            int size5 = ((ByteString) objI2).size();
                            iB = ai.onnxruntime.a.e(size5, size5, iS6, iB);
                            break;
                        } else {
                            iS3 = CodedOutputStream.s(i11);
                            iR = CodedOutputStream.r((String) objI2);
                            iB = iR + iS3 + iB;
                            break;
                        }
                    } else {
                        break;
                    }
                case 60:
                    if (r(i11, i10, t8)) {
                        iN = x0.l(i11, g1.f1818d.i(j10, t8), n(i10));
                        iB += iN;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (r(i11, i10, t8)) {
                        iN = CodedOutputStream.k(i11, (ByteString) g1.f1818d.i(j10, t8));
                        iB += iN;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (r(i11, i10, t8)) {
                        iN = CodedOutputStream.t(i11, z(j10, t8));
                        iB += iN;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (r(i11, i10, t8)) {
                        int iZ2 = z(j10, t8);
                        iS2 = CodedOutputStream.s(i11);
                        iP = CodedOutputStream.p(iZ2);
                        iN = iP + iS2;
                        iB += iN;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (r(i11, i10, t8)) {
                        iB = a0.a.b(i11, 4, iB);
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (r(i11, i10, t8)) {
                        iB = a0.a.b(i11, 8, iB);
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (r(i11, i10, t8)) {
                        int iZ3 = z(j10, t8);
                        iS2 = CodedOutputStream.s(i11);
                        iP = CodedOutputStream.u((iZ3 >> 31) ^ (iZ3 << 1));
                        iN = iP + iS2;
                        iB += iN;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (r(i11, i10, t8)) {
                        long jA3 = A(j10, t8);
                        iS4 = CodedOutputStream.s(i11);
                        iV2 = CodedOutputStream.v((jA3 >> 63) ^ (jA3 << 1));
                        iN = iV2 + iS4;
                        iB += iN;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (r(i11, i10, t8)) {
                        iN = CodedOutputStream.o(i11, (i0) g1.f1818d.i(j10, t8), n(i10));
                        iB += iN;
                        break;
                    } else {
                        break;
                    }
            }
            i10 += 3;
        }
    }

    public final boolean q(int i10, Object obj) {
        if (this.h) {
            int iG = G(i10);
            long j10 = iG & 1048575;
            switch (F(iG)) {
                case 0:
                    if (g1.f1818d.e(j10, obj) == 0.0d) {
                        return false;
                    }
                    break;
                case 1:
                    if (g1.f1818d.f(j10, obj) == 0.0f) {
                        return false;
                    }
                    break;
                case 2:
                    if (g1.f1818d.h(j10, obj) == 0) {
                        return false;
                    }
                    break;
                case 3:
                    if (g1.f1818d.h(j10, obj) == 0) {
                        return false;
                    }
                    break;
                case 4:
                    if (g1.f1818d.g(j10, obj) == 0) {
                        return false;
                    }
                    break;
                case 5:
                    if (g1.f1818d.h(j10, obj) == 0) {
                        return false;
                    }
                    break;
                case 6:
                    if (g1.f1818d.g(j10, obj) == 0) {
                        return false;
                    }
                    break;
                case 7:
                    return g1.f1818d.c(j10, obj);
                case 8:
                    Object objI = g1.f1818d.i(j10, obj);
                    if (objI instanceof String) {
                        return !((String) objI).isEmpty();
                    }
                    if (objI instanceof ByteString) {
                        return !ByteString.f1717b.equals(objI);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    if (g1.f1818d.i(j10, obj) == null) {
                        return false;
                    }
                    break;
                case 10:
                    return !ByteString.f1717b.equals(g1.f1818d.i(j10, obj));
                case 11:
                    if (g1.f1818d.g(j10, obj) == 0) {
                        return false;
                    }
                    break;
                case 12:
                    if (g1.f1818d.g(j10, obj) == 0) {
                        return false;
                    }
                    break;
                case 13:
                    if (g1.f1818d.g(j10, obj) == 0) {
                        return false;
                    }
                    break;
                case 14:
                    if (g1.f1818d.h(j10, obj) == 0) {
                        return false;
                    }
                    break;
                case 15:
                    if (g1.f1818d.g(j10, obj) == 0) {
                        return false;
                    }
                    break;
                case 16:
                    if (g1.f1818d.h(j10, obj) == 0) {
                        return false;
                    }
                    break;
                case 17:
                    if (g1.f1818d.i(j10, obj) == null) {
                        return false;
                    }
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            if ((g1.f1818d.g(r5 & 1048575, obj) & (1 << (this.f1847a[i10 + 2] >>> 20))) == 0) {
                return false;
            }
        }
        return true;
    }

    public final boolean r(int i10, int i11, Object obj) {
        return g1.f1818d.g((long) (this.f1847a[i11 + 2] & 1048575), obj) == i10;
    }

    public final <K, V> void t(Object obj, int i10, Object obj2, m mVar, v0 v0Var) {
        long jG = G(i10) & 1048575;
        Object objI = g1.f1818d.i(jG, obj);
        d0 d0Var = this.f1861p;
        if (objI == null) {
            objI = d0Var.f();
            g1.o(jG, obj, objI);
        } else if (d0Var.h(objI)) {
            MapFieldLite mapFieldLiteF = d0Var.f();
            d0Var.a(mapFieldLiteF, objI);
            g1.o(jG, obj, mapFieldLiteF);
            objI = mapFieldLiteF;
        }
        v0Var.z(d0Var.c(objI), d0Var.b(obj2), mVar);
    }

    public final void u(int i10, Object obj, Object obj2) {
        long jG = G(i10) & 1048575;
        if (q(i10, obj2)) {
            g1.e eVar = g1.f1818d;
            Object objI = eVar.i(jG, obj);
            Object objI2 = eVar.i(jG, obj2);
            if (objI != null && objI2 != null) {
                g1.o(jG, obj, u.c(objI, objI2));
                D(i10, obj);
            } else if (objI2 != null) {
                g1.o(jG, obj, objI2);
                D(i10, obj);
            }
        }
    }

    public final void v(int i10, Object obj, Object obj2) {
        int iG = G(i10);
        int i11 = this.f1847a[i10];
        long j10 = iG & 1048575;
        if (r(i11, i10, obj2)) {
            g1.e eVar = g1.f1818d;
            Object objI = eVar.i(j10, obj);
            Object objI2 = eVar.i(j10, obj2);
            if (objI != null && objI2 != null) {
                g1.o(j10, obj, u.c(objI, objI2));
                E(i11, i10, obj);
            } else if (objI2 != null) {
                g1.o(j10, obj, objI2);
                E(i11, i10, obj);
            }
        }
    }
}
