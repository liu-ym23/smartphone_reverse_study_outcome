package com.google.crypto.tink.shaded.protobuf;

import com.stepos.stepclaw.SecurePrefs;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import org.bouncycastle.asn1.BERTags;
import org.bouncycastle.crypto.params.SkeinParameters;
import sun.misc.Unsafe;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class s0 implements b1 {

    /* renamed from: o, reason: collision with root package name */
    public static final int[] f1516o = new int[0];

    /* renamed from: p, reason: collision with root package name */
    public static final Unsafe f1517p = n1.j();

    /* renamed from: a, reason: collision with root package name */
    public final int[] f1518a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f1519b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1520c;
    public final int d;

    /* renamed from: e, reason: collision with root package name */
    public final a f1521e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f1522f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f1523g;

    /* renamed from: h, reason: collision with root package name */
    public final int[] f1524h;

    /* renamed from: i, reason: collision with root package name */
    public final int f1525i;

    /* renamed from: j, reason: collision with root package name */
    public final int f1526j;

    /* renamed from: k, reason: collision with root package name */
    public final u0 f1527k;

    /* renamed from: l, reason: collision with root package name */
    public final i0 f1528l;

    /* renamed from: m, reason: collision with root package name */
    public final f1 f1529m;

    /* renamed from: n, reason: collision with root package name */
    public final n0 f1530n;

    public s0(int[] iArr, Object[] objArr, int i8, int i9, a aVar, boolean z, int[] iArr2, int i10, int i11, u0 u0Var, i0 i0Var, f1 f1Var, p pVar, n0 n0Var) {
        this.f1518a = iArr;
        this.f1519b = objArr;
        this.f1520c = i8;
        this.d = i9;
        this.f1522f = aVar instanceof w;
        this.f1523g = z;
        this.f1524h = iArr2;
        this.f1525i = i10;
        this.f1526j = i11;
        this.f1527k = u0Var;
        this.f1528l = i0Var;
        this.f1529m = f1Var;
        this.f1521e = aVar;
        this.f1530n = n0Var;
    }

    public static s0 B(a1 a1Var, u0 u0Var, i0 i0Var, f1 f1Var, p pVar, n0 n0Var) {
        if (a1Var instanceof a1) {
            return C(a1Var, u0Var, i0Var, f1Var, pVar, n0Var);
        }
        a1Var.getClass();
        throw new ClassCastException();
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0375  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.crypto.tink.shaded.protobuf.s0 C(com.google.crypto.tink.shaded.protobuf.a1 r34, com.google.crypto.tink.shaded.protobuf.u0 r35, com.google.crypto.tink.shaded.protobuf.i0 r36, com.google.crypto.tink.shaded.protobuf.f1 r37, com.google.crypto.tink.shaded.protobuf.p r38, com.google.crypto.tink.shaded.protobuf.n0 r39) {
        /*
            Method dump skipped, instructions count: 986
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.s0.C(com.google.crypto.tink.shaded.protobuf.a1, com.google.crypto.tink.shaded.protobuf.u0, com.google.crypto.tink.shaded.protobuf.i0, com.google.crypto.tink.shaded.protobuf.f1, com.google.crypto.tink.shaded.protobuf.p, com.google.crypto.tink.shaded.protobuf.n0):com.google.crypto.tink.shaded.protobuf.s0");
    }

    public static long D(int i8) {
        return i8 & 1048575;
    }

    public static int E(Object obj, long j4) {
        return ((Integer) n1.f1499c.i(obj, j4)).intValue();
    }

    public static long F(Object obj, long j4) {
        return ((Long) n1.f1499c.i(obj, j4)).longValue();
    }

    public static Field O(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    public static int U(int i8) {
        return (i8 & 267386880) >>> 20;
    }

    public static void X(int i8, Object obj, l0 l0Var) throws androidx.datastore.preferences.protobuf.k {
        if (!(obj instanceof String)) {
            l0Var.a(i8, (i) obj);
            return;
        }
        String str = (String) obj;
        l lVar = (l) l0Var.f1492a;
        lVar.j0(i8, 2);
        int i9 = lVar.f1489e;
        byte[] bArr = lVar.d;
        int i10 = lVar.f1490f;
        try {
            int iA0 = l.a0(str.length() * 3);
            int iA02 = l.a0(str.length());
            if (iA02 != iA0) {
                lVar.k0(q1.b(str));
                int i11 = lVar.f1490f;
                lVar.f1490f = q1.f1510a.E(str, bArr, i11, i9 - i11);
                return;
            }
            int i12 = i10 + iA02;
            lVar.f1490f = i12;
            int iE = q1.f1510a.E(str, bArr, i12, i9 - i12);
            lVar.f1490f = i10;
            lVar.k0((iE - i10) - iA02);
            lVar.f1490f = iE;
        } catch (p1 e9) {
            lVar.f1490f = i10;
            l.f1486g.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) e9);
            byte[] bytes = str.getBytes(a0.f1428a);
            try {
                lVar.k0(bytes.length);
                lVar.d0(bytes, 0, bytes.length);
            } catch (IndexOutOfBoundsException e10) {
                throw new androidx.datastore.preferences.protobuf.k(e10);
            }
        } catch (IndexOutOfBoundsException e11) {
            throw new androidx.datastore.preferences.protobuf.k(e11);
        }
    }

    public static void l(Object obj) {
        if (!t(obj)) {
            throw new IllegalArgumentException(a8.b.m(obj, "Mutating immutable message: "));
        }
    }

    public static boolean t(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof w) {
            return ((w) obj).n();
        }
        return true;
    }

    public static List v(w wVar, long j4) {
        return (List) n1.f1499c.i(wVar, j4);
    }

    public final Object A(Object obj, int i8, int i9) {
        b1 b1VarP = p(i9);
        if (!u(obj, i8, i9)) {
            return b1VarP.d();
        }
        Object object = f1517p.getObject(obj, V(i9) & 1048575);
        if (t(object)) {
            return object;
        }
        Object objD = b1VarP.d();
        if (object != null) {
            b1VarP.a(objD, object);
        }
        return objD;
    }

    public final void G(int i8, long j4, Object obj) {
        Unsafe unsafe = f1517p;
        Object objO = o(i8);
        Object object = unsafe.getObject(obj, j4);
        this.f1530n.getClass();
        if (!((m0) object).f1494a) {
            m0 m0VarC = m0.f1493b.c();
            n0.b(m0VarC, object);
            unsafe.putObject(obj, j4, m0VarC);
        }
        a8.b.x(objO);
        throw null;
    }

    public final int H(Object obj, byte[] bArr, int i8, int i9, int i10, int i11, int i12, int i13, int i14, long j4, int i15, d dVar) throws c0 {
        int i16;
        Unsafe unsafe = f1517p;
        long j8 = this.f1518a[i15 + 2] & 1048575;
        switch (i14) {
            case 51:
                if (i12 != 1) {
                    return i8;
                }
                unsafe.putObject(obj, j4, Double.valueOf(Double.longBitsToDouble(a.a.t(bArr, i8))));
                int i17 = i8 + 8;
                unsafe.putInt(obj, j8, i11);
                return i17;
            case 52:
                if (i12 != 5) {
                    return i8;
                }
                unsafe.putObject(obj, j4, Float.valueOf(Float.intBitsToFloat(a.a.s(bArr, i8))));
                int i18 = i8 + 4;
                unsafe.putInt(obj, j8, i11);
                return i18;
            case 53:
            case 54:
                if (i12 != 0) {
                    return i8;
                }
                int iC = a.a.C(bArr, i8, dVar);
                unsafe.putObject(obj, j4, Long.valueOf(dVar.f1442c));
                unsafe.putInt(obj, j8, i11);
                return iC;
            case 55:
            case 62:
                if (i12 != 0) {
                    return i8;
                }
                int iA = a.a.A(bArr, i8, dVar);
                unsafe.putObject(obj, j4, Integer.valueOf(dVar.f1441b));
                unsafe.putInt(obj, j8, i11);
                return iA;
            case 56:
            case 65:
                if (i12 != 1) {
                    return i8;
                }
                unsafe.putObject(obj, j4, Long.valueOf(a.a.t(bArr, i8)));
                int i19 = i8 + 8;
                unsafe.putInt(obj, j8, i11);
                return i19;
            case 57:
            case 64:
                if (i12 != 5) {
                    return i8;
                }
                unsafe.putObject(obj, j4, Integer.valueOf(a.a.s(bArr, i8)));
                int i20 = i8 + 4;
                unsafe.putInt(obj, j8, i11);
                return i20;
            case 58:
                if (i12 != 0) {
                    return i8;
                }
                int iC2 = a.a.C(bArr, i8, dVar);
                unsafe.putObject(obj, j4, Boolean.valueOf(dVar.f1442c != 0));
                unsafe.putInt(obj, j8, i11);
                return iC2;
            case 59:
                if (i12 != 2) {
                    return i8;
                }
                int iA2 = a.a.A(bArr, i8, dVar);
                int i21 = dVar.f1441b;
                if (i21 == 0) {
                    unsafe.putObject(obj, j4, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID);
                } else {
                    if ((i13 & 536870912) != 0) {
                        if (!q1.f1510a.R(iA2, iA2 + i21, bArr)) {
                            throw c0.b();
                        }
                    }
                    unsafe.putObject(obj, j4, new String(bArr, iA2, i21, a0.f1428a));
                    iA2 += i21;
                }
                unsafe.putInt(obj, j8, i11);
                return iA2;
            case 60:
                i16 = i8;
                if (i12 == 2) {
                    Object objA = A(obj, i11, i15);
                    int iV = a.a.V(objA, p(i15), bArr, i16, i9, dVar);
                    T(obj, i11, i15, objA);
                    return iV;
                }
                return i16;
            case 61:
                i16 = i8;
                if (i12 == 2) {
                    int iR = a.a.r(bArr, i16, dVar);
                    unsafe.putObject(obj, j4, dVar.d);
                    unsafe.putInt(obj, j8, i11);
                    return iR;
                }
                return i16;
            case SkeinParameters.PARAM_TYPE_OUTPUT /* 63 */:
                i16 = i8;
                if (i12 == 0) {
                    int iA3 = a.a.A(bArr, i16, dVar);
                    int i22 = dVar.f1441b;
                    n(i15);
                    unsafe.putObject(obj, j4, Integer.valueOf(i22));
                    unsafe.putInt(obj, j8, i11);
                    return iA3;
                }
                return i16;
            case 66:
                i16 = i8;
                if (i12 == 0) {
                    int iA4 = a.a.A(bArr, i16, dVar);
                    unsafe.putObject(obj, j4, Integer.valueOf(a2.e.d(dVar.f1441b)));
                    unsafe.putInt(obj, j8, i11);
                    return iA4;
                }
                return i16;
            case 67:
                i16 = i8;
                if (i12 == 0) {
                    int iC3 = a.a.C(bArr, i16, dVar);
                    unsafe.putObject(obj, j4, Long.valueOf(a2.e.e(dVar.f1442c)));
                    unsafe.putInt(obj, j8, i11);
                    return iC3;
                }
                return i16;
            case 68:
                if (i12 == 3) {
                    Object objA2 = A(obj, i11, i15);
                    int I = ((s0) p(i15)).I(objA2, bArr, i8, i9, (i10 & (-8)) | 4, dVar);
                    dVar.d = objA2;
                    T(obj, i11, i15, objA2);
                    return I;
                }
            default:
                return i8;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0142, code lost:
    
        r4 = r9;
        r9 = r25 | r23;
        r3 = r7;
        r7 = r13;
        r13 = r4;
        r4 = r33;
        r5 = r2;
        r2 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x025a, code lost:
    
        r4 = r9;
        r9 = r25 | r23;
        r3 = r4;
        r4 = r13;
        r13 = r7;
        r7 = r4;
        r4 = r33;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int I(java.lang.Object r30, byte[] r31, int r32, int r33, int r34, com.google.crypto.tink.shaded.protobuf.d r35) throws com.google.crypto.tink.shaded.protobuf.c0 {
        /*
            Method dump skipped, instructions count: 1216
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.s0.I(java.lang.Object, byte[], int, int, int, com.google.crypto.tink.shaded.protobuf.d):int");
    }

    public final void J(Object obj, byte[] bArr, int i8, int i9, d dVar) throws c0 {
        int i10;
        int iR;
        Object obj2;
        int i11;
        Unsafe unsafe;
        int i12;
        int i13;
        int i14;
        int i15;
        char c3;
        Unsafe unsafe2;
        Object obj3;
        byte[] bArr2;
        int i16;
        byte[] bArr3;
        Object obj4;
        byte[] bArr4;
        Unsafe unsafe3;
        int i17;
        Object obj5;
        Object obj6;
        int i18;
        int i19;
        int i20;
        s0 s0Var = this;
        Object obj7 = obj;
        byte[] bArr5 = bArr;
        int i21 = i9;
        d dVar2 = dVar;
        l(obj7);
        Unsafe unsafe4 = f1517p;
        int iC = i8;
        int i22 = -1;
        int i23 = 0;
        int i24 = 1048575;
        int i25 = 0;
        while (iC < i21) {
            int iZ = iC + 1;
            int i26 = bArr5[iC];
            if (i26 < 0) {
                iZ = a.a.z(i26, bArr5, iZ, dVar2);
                i26 = dVar2.f1441b;
            }
            int i27 = i26 >>> 3;
            int i28 = i26 & 7;
            int i29 = s0Var.d;
            int i30 = s0Var.f1520c;
            if (i27 > i22) {
                iR = (i27 < i30 || i27 > i29) ? -1 : s0Var.R(i27, i23 / 3);
                i10 = 0;
            } else if (i27 < i30 || i27 > i29) {
                i10 = 0;
                iR = -1;
            } else {
                i10 = 0;
                iR = s0Var.R(i27, 0);
            }
            int i31 = iR;
            if (i31 == -1) {
                int i32 = iZ;
                obj2 = obj7;
                i11 = i32;
                unsafe = unsafe4;
                i12 = i26;
                i13 = i27;
                i14 = i10;
            } else {
                int[] iArr = s0Var.f1518a;
                int i33 = iArr[i31 + 1];
                int iU = U(i33);
                int i34 = i26;
                long j4 = i33 & 1048575;
                if (iU <= 17) {
                    int i35 = iArr[i31 + 2];
                    int i36 = 1 << (i35 >>> 20);
                    int i37 = i35 & 1048575;
                    if (i37 != i24) {
                        int i38 = 1048575;
                        i15 = i33;
                        if (i24 != 1048575) {
                            unsafe4.putInt(obj7, i24, i25);
                            i38 = 1048575;
                        }
                        if (i37 != i38) {
                            i25 = unsafe4.getInt(obj7, i37);
                        }
                        i24 = i37;
                    } else {
                        i15 = i33;
                    }
                    switch (iU) {
                        case 0:
                            unsafe2 = unsafe4;
                            bArr2 = bArr5;
                            c3 = 65535;
                            i16 = iZ;
                            if (i28 != 1) {
                                obj3 = obj7;
                                i12 = i34;
                                obj2 = obj3;
                                i11 = i16;
                                unsafe = unsafe2;
                                i13 = i27;
                                i14 = i31;
                                break;
                            } else {
                                n1.f1499c.m(obj7, j4, Double.longBitsToDouble(a.a.t(bArr2, i16)));
                                iC = i16 + 8;
                                i25 |= i36;
                                bArr5 = bArr2;
                                i23 = i31;
                                i22 = i27;
                                unsafe4 = unsafe2;
                                i21 = i9;
                                break;
                            }
                        case 1:
                            unsafe2 = unsafe4;
                            bArr2 = bArr5;
                            c3 = 65535;
                            i16 = iZ;
                            if (i28 != 5) {
                                obj3 = obj7;
                                i12 = i34;
                                obj2 = obj3;
                                i11 = i16;
                                unsafe = unsafe2;
                                i13 = i27;
                                i14 = i31;
                                break;
                            } else {
                                n1.f1499c.n(obj7, j4, Float.intBitsToFloat(a.a.s(bArr2, i16)));
                                iC = i16 + 4;
                                i25 |= i36;
                                bArr5 = bArr2;
                                i23 = i31;
                                i22 = i27;
                                unsafe4 = unsafe2;
                                i21 = i9;
                                break;
                            }
                        case 2:
                        case 3:
                            bArr3 = bArr5;
                            c3 = 65535;
                            i16 = iZ;
                            if (i28 != 0) {
                                unsafe2 = unsafe4;
                                obj3 = obj7;
                                i12 = i34;
                                obj2 = obj3;
                                i11 = i16;
                                unsafe = unsafe2;
                                i13 = i27;
                                i14 = i31;
                                break;
                            } else {
                                int iC2 = a.a.C(bArr3, i16, dVar2);
                                unsafe4.putLong(obj7, j4, dVar2.f1442c);
                                i25 |= i36;
                                iC = iC2;
                                bArr5 = bArr3;
                                i23 = i31;
                                i22 = i27;
                                i21 = i9;
                                break;
                            }
                        case 4:
                        case BERTags.EMBEDDED_PDV /* 11 */:
                            bArr3 = bArr5;
                            c3 = 65535;
                            i16 = iZ;
                            if (i28 != 0) {
                                unsafe2 = unsafe4;
                                obj3 = obj7;
                                i12 = i34;
                                obj2 = obj3;
                                i11 = i16;
                                unsafe = unsafe2;
                                i13 = i27;
                                i14 = i31;
                                break;
                            } else {
                                int iA = a.a.A(bArr3, i16, dVar2);
                                unsafe4.putInt(obj7, j4, dVar2.f1441b);
                                i25 |= i36;
                                iC = iA;
                                bArr5 = bArr3;
                                i23 = i31;
                                i22 = i27;
                                i21 = i9;
                                break;
                            }
                        case 5:
                        case BERTags.TIME /* 14 */:
                            Object obj8 = obj7;
                            bArr3 = bArr5;
                            c3 = 65535;
                            Unsafe unsafe5 = unsafe4;
                            int i39 = iZ;
                            if (i28 != 1) {
                                i16 = i39;
                                unsafe2 = unsafe5;
                                obj3 = obj8;
                                i12 = i34;
                                obj2 = obj3;
                                i11 = i16;
                                unsafe = unsafe2;
                                i13 = i27;
                                i14 = i31;
                                break;
                            } else {
                                long jT = a.a.t(bArr3, i39);
                                unsafe4 = unsafe5;
                                obj7 = obj8;
                                unsafe4.putLong(obj7, j4, jT);
                                iC = i39 + 8;
                                i25 |= i36;
                                bArr5 = bArr3;
                                i23 = i31;
                                i22 = i27;
                                i21 = i9;
                                break;
                            }
                        case 6:
                        case BERTags.RELATIVE_OID /* 13 */:
                            obj4 = obj7;
                            bArr4 = bArr5;
                            c3 = 65535;
                            unsafe3 = unsafe4;
                            i17 = iZ;
                            if (i28 != 5) {
                                Unsafe unsafe6 = unsafe3;
                                i16 = i17;
                                obj3 = obj4;
                                unsafe2 = unsafe6;
                                i12 = i34;
                                obj2 = obj3;
                                i11 = i16;
                                unsafe = unsafe2;
                                i13 = i27;
                                i14 = i31;
                                break;
                            } else {
                                unsafe3.putInt(obj4, j4, a.a.s(bArr4, i17));
                                iC = i17 + 4;
                                i25 |= i36;
                                unsafe4 = unsafe3;
                                bArr5 = bArr4;
                                i23 = i31;
                                i22 = i27;
                                obj7 = obj4;
                                i21 = i9;
                                break;
                            }
                        case 7:
                            obj4 = obj7;
                            bArr4 = bArr5;
                            c3 = 65535;
                            unsafe3 = unsafe4;
                            i17 = iZ;
                            if (i28 != 0) {
                                Unsafe unsafe62 = unsafe3;
                                i16 = i17;
                                obj3 = obj4;
                                unsafe2 = unsafe62;
                                i12 = i34;
                                obj2 = obj3;
                                i11 = i16;
                                unsafe = unsafe2;
                                i13 = i27;
                                i14 = i31;
                                break;
                            } else {
                                iC = a.a.C(bArr4, i17, dVar2);
                                n1.f1499c.k(obj4, j4, dVar2.f1442c != 0);
                                i25 |= i36;
                                unsafe4 = unsafe3;
                                bArr5 = bArr4;
                                i23 = i31;
                                i22 = i27;
                                obj7 = obj4;
                                i21 = i9;
                                break;
                            }
                        case 8:
                            obj4 = obj7;
                            bArr4 = bArr5;
                            c3 = 65535;
                            unsafe3 = unsafe4;
                            i17 = iZ;
                            if (i28 != 2) {
                                Unsafe unsafe622 = unsafe3;
                                i16 = i17;
                                obj3 = obj4;
                                unsafe2 = unsafe622;
                                i12 = i34;
                                obj2 = obj3;
                                i11 = i16;
                                unsafe = unsafe2;
                                i13 = i27;
                                i14 = i31;
                                break;
                            } else {
                                iC = (i15 & 536870912) == 0 ? a.a.v(bArr4, i17, dVar2) : a.a.w(bArr4, i17, dVar2);
                                unsafe3.putObject(obj4, j4, dVar2.d);
                                i25 |= i36;
                                unsafe4 = unsafe3;
                                bArr5 = bArr4;
                                i23 = i31;
                                i22 = i27;
                                obj7 = obj4;
                                i21 = i9;
                                break;
                            }
                        case 9:
                            obj4 = obj7;
                            c3 = 65535;
                            if (i28 != 2) {
                                Unsafe unsafe7 = unsafe4;
                                obj3 = obj4;
                                unsafe2 = unsafe7;
                                i16 = iZ;
                                i12 = i34;
                                obj2 = obj3;
                                i11 = i16;
                                unsafe = unsafe2;
                                i13 = i27;
                                i14 = i31;
                                break;
                            } else {
                                Unsafe unsafe8 = unsafe4;
                                Object objZ = s0Var.z(i31, obj4);
                                byte[] bArr6 = bArr5;
                                unsafe3 = unsafe8;
                                int iV = a.a.V(objZ, s0Var.p(i31), bArr6, iZ, i21, dVar2);
                                bArr4 = bArr6;
                                s0Var.S(obj4, i31, objZ);
                                i25 |= i36;
                                iC = iV;
                                unsafe4 = unsafe3;
                                bArr5 = bArr4;
                                i23 = i31;
                                i22 = i27;
                                obj7 = obj4;
                                i21 = i9;
                                break;
                            }
                        case 10:
                            obj5 = obj7;
                            c3 = 65535;
                            if (i28 != 2) {
                                Object obj9 = obj5;
                                unsafe2 = unsafe4;
                                obj3 = obj9;
                                i16 = iZ;
                                i12 = i34;
                                obj2 = obj3;
                                i11 = i16;
                                unsafe = unsafe2;
                                i13 = i27;
                                i14 = i31;
                                break;
                            } else {
                                iC = a.a.r(bArr5, iZ, dVar2);
                                unsafe4.putObject(obj5, j4, dVar2.d);
                                i25 |= i36;
                                i23 = i31;
                                i22 = i27;
                                obj7 = obj5;
                                break;
                            }
                        case 12:
                            obj5 = obj7;
                            c3 = 65535;
                            if (i28 != 0) {
                                Object obj92 = obj5;
                                unsafe2 = unsafe4;
                                obj3 = obj92;
                                i16 = iZ;
                                i12 = i34;
                                obj2 = obj3;
                                i11 = i16;
                                unsafe = unsafe2;
                                i13 = i27;
                                i14 = i31;
                                break;
                            } else {
                                iC = a.a.A(bArr5, iZ, dVar2);
                                unsafe4.putInt(obj5, j4, dVar2.f1441b);
                                i25 |= i36;
                                i23 = i31;
                                i22 = i27;
                                obj7 = obj5;
                                break;
                            }
                        case 15:
                            obj5 = obj7;
                            c3 = 65535;
                            if (i28 != 0) {
                                Object obj922 = obj5;
                                unsafe2 = unsafe4;
                                obj3 = obj922;
                                i16 = iZ;
                                i12 = i34;
                                obj2 = obj3;
                                i11 = i16;
                                unsafe = unsafe2;
                                i13 = i27;
                                i14 = i31;
                                break;
                            } else {
                                iC = a.a.A(bArr5, iZ, dVar2);
                                unsafe4.putInt(obj5, j4, a2.e.d(dVar2.f1441b));
                                i25 |= i36;
                                i23 = i31;
                                i22 = i27;
                                obj7 = obj5;
                                break;
                            }
                        case 16:
                            if (i28 != 0) {
                                c3 = 65535;
                                unsafe2 = unsafe4;
                                obj3 = obj7;
                                i16 = iZ;
                                i12 = i34;
                                obj2 = obj3;
                                i11 = i16;
                                unsafe = unsafe2;
                                i13 = i27;
                                i14 = i31;
                                break;
                            } else {
                                int iC3 = a.a.C(bArr5, iZ, dVar2);
                                unsafe4.putLong(obj7, j4, a2.e.e(dVar2.f1442c));
                                i25 |= i36;
                                i23 = i31;
                                i22 = i27;
                                iC = iC3;
                                break;
                            }
                        default:
                            unsafe2 = unsafe4;
                            obj3 = obj7;
                            c3 = 65535;
                            i16 = iZ;
                            i12 = i34;
                            obj2 = obj3;
                            i11 = i16;
                            unsafe = unsafe2;
                            i13 = i27;
                            i14 = i31;
                            break;
                    }
                } else {
                    Object obj10 = obj7;
                    Unsafe unsafe9 = unsafe4;
                    byte[] bArr7 = bArr5;
                    int i40 = iZ;
                    if (iU != 27) {
                        i12 = i34;
                        i18 = i40;
                        if (iU <= 49) {
                            unsafe = unsafe9;
                            i13 = i27;
                            int i41 = i24;
                            int i42 = i25;
                            int iK = s0Var.K(obj, bArr, i18, i9, i12, i28, i31, i33, iU, j4, dVar);
                            i14 = i31;
                            if (iK != i18) {
                                bArr5 = bArr;
                                i21 = i9;
                                dVar2 = dVar;
                                obj7 = obj;
                                iC = iK;
                                i23 = i14;
                                i24 = i41;
                                i25 = i42;
                                i22 = i13;
                                unsafe4 = unsafe;
                            } else {
                                i11 = iK;
                                i24 = i41;
                                i25 = i42;
                                obj2 = obj;
                            }
                        } else {
                            unsafe = unsafe9;
                            i19 = i24;
                            i13 = i27;
                            obj6 = obj;
                            i14 = i31;
                            i20 = i25;
                            if (iU != 50) {
                                int iH = s0Var.H(obj6, bArr, i18, i9, i12, i13, i28, i33, iU, j4, i14, dVar);
                                obj2 = obj6;
                                if (iH != i18) {
                                    s0Var = this;
                                    i21 = i9;
                                    dVar2 = dVar;
                                    obj7 = obj2;
                                    iC = iH;
                                    i23 = i14;
                                    i24 = i19;
                                    i25 = i20;
                                    i22 = i13;
                                    unsafe4 = unsafe;
                                    bArr5 = bArr;
                                } else {
                                    i11 = iH;
                                    i24 = i19;
                                    i25 = i20;
                                }
                            } else if (i28 == 2) {
                                s0Var.G(i14, j4, obj6);
                                throw null;
                            }
                        }
                    } else if (i28 == 2) {
                        z zVarA = (z) unsafe9.getObject(obj10, j4);
                        if (!((b) zVarA).f1433a) {
                            int size = zVarA.size();
                            zVarA = zVarA.a(size == 0 ? 10 : size * 2);
                            unsafe9.putObject(obj10, j4, zVarA);
                        }
                        int iU2 = a.a.u(s0Var.p(i31), i34, bArr7, i40, i9, zVarA, dVar2);
                        obj7 = obj;
                        bArr5 = bArr;
                        dVar2 = dVar;
                        iC = iU2;
                        unsafe4 = unsafe9;
                        i23 = i31;
                        i22 = i27;
                        i21 = i9;
                    } else {
                        obj6 = obj;
                        i12 = i34;
                        unsafe = unsafe9;
                        i18 = i40;
                        i19 = i24;
                        i20 = i25;
                        i13 = i27;
                        i14 = i31;
                    }
                    i11 = i18;
                    obj2 = obj6;
                    i24 = i19;
                    i25 = i20;
                }
            }
            w wVar = (w) obj2;
            e1 e1VarC = wVar.unknownFields;
            if (e1VarC == e1.f1454f) {
                e1VarC = e1.c();
                wVar.unknownFields = e1VarC;
            }
            int iX = a.a.x(i12, bArr, i11, i9, e1VarC, dVar);
            bArr5 = bArr;
            dVar2 = dVar;
            i21 = i9;
            obj7 = obj2;
            i23 = i14;
            i22 = i13;
            unsafe4 = unsafe;
            iC = iX;
            s0Var = this;
        }
        Unsafe unsafe10 = unsafe4;
        Object obj11 = obj7;
        int i43 = i21;
        int i44 = i24;
        int i45 = i25;
        if (i44 != 1048575) {
            unsafe10.putInt(obj11, i44, i45);
        }
        if (iC != i43) {
            throw c0.f();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final int K(Object obj, byte[] bArr, int i8, int i9, int i10, int i11, int i12, long j4, int i13, long j8, d dVar) throws c0 {
        int iB;
        Unsafe unsafe = f1517p;
        z zVarA = (z) unsafe.getObject(obj, j8);
        if (!((b) zVarA).f1433a) {
            int size = zVarA.size();
            zVarA = zVarA.a(size == 0 ? 10 : size * 2);
            unsafe.putObject(obj, j8, zVarA);
        }
        z zVar = zVarA;
        switch (i13) {
            case BERTags.NUMERIC_STRING /* 18 */:
            case BERTags.OBJECT_IDENTIFIER_IRI /* 35 */:
                if (i11 == 2) {
                    m mVar = (m) zVar;
                    int iA = a.a.A(bArr, i8, dVar);
                    int i14 = dVar.f1441b + iA;
                    while (iA < i14) {
                        mVar.g(Double.longBitsToDouble(a.a.t(bArr, iA)));
                        iA += 8;
                    }
                    if (iA == i14) {
                        return iA;
                    }
                    throw c0.g();
                }
                if (i11 == 1) {
                    m mVar2 = (m) zVar;
                    mVar2.g(Double.longBitsToDouble(a.a.t(bArr, i8)));
                    i8 += 8;
                    while (i8 < i9) {
                        int iA2 = a.a.A(bArr, i8, dVar);
                        if (i10 == dVar.f1441b) {
                            mVar2.g(Double.longBitsToDouble(a.a.t(bArr, iA2)));
                            i8 = iA2 + 8;
                        }
                    }
                }
                return i8;
            case 19:
            case BERTags.RELATIVE_OID_IRI /* 36 */:
                if (i11 == 2) {
                    s sVar = (s) zVar;
                    int iA3 = a.a.A(bArr, i8, dVar);
                    int i15 = dVar.f1441b + iA3;
                    while (iA3 < i15) {
                        sVar.g(Float.intBitsToFloat(a.a.s(bArr, iA3)));
                        iA3 += 4;
                    }
                    if (iA3 == i15) {
                        return iA3;
                    }
                    throw c0.g();
                }
                if (i11 == 5) {
                    s sVar2 = (s) zVar;
                    sVar2.g(Float.intBitsToFloat(a.a.s(bArr, i8)));
                    int i16 = i8 + 4;
                    while (i16 < i9) {
                        int iA4 = a.a.A(bArr, i16, dVar);
                        if (i10 != dVar.f1441b) {
                            return i16;
                        }
                        sVar2.g(Float.intBitsToFloat(a.a.s(bArr, iA4)));
                        i16 = iA4 + 4;
                    }
                    return i16;
                }
                return i8;
            case 20:
            case BERTags.VIDEOTEX_STRING /* 21 */:
            case 37:
            case 38:
                if (i11 == 2) {
                    j0 j0Var = (j0) zVar;
                    int iA5 = a.a.A(bArr, i8, dVar);
                    int i17 = dVar.f1441b + iA5;
                    while (iA5 < i17) {
                        iA5 = a.a.C(bArr, iA5, dVar);
                        j0Var.g(dVar.f1442c);
                    }
                    if (iA5 == i17) {
                        return iA5;
                    }
                    throw c0.g();
                }
                if (i11 == 0) {
                    j0 j0Var2 = (j0) zVar;
                    int iC = a.a.C(bArr, i8, dVar);
                    j0Var2.g(dVar.f1442c);
                    while (iC < i9) {
                        int iA6 = a.a.A(bArr, iC, dVar);
                        if (i10 != dVar.f1441b) {
                            return iC;
                        }
                        iC = a.a.C(bArr, iA6, dVar);
                        j0Var2.g(dVar.f1442c);
                    }
                    return iC;
                }
                return i8;
            case BERTags.IA5_STRING /* 22 */:
            case BERTags.UNRESTRICTED_STRING /* 29 */:
            case 39:
            case 43:
                if (i11 != 2) {
                    if (i11 == 0) {
                        return a.a.B(i10, bArr, i8, i9, zVar, dVar);
                    }
                    return i8;
                }
                x xVar = (x) zVar;
                int iA7 = a.a.A(bArr, i8, dVar);
                int i18 = dVar.f1441b + iA7;
                while (iA7 < i18) {
                    iA7 = a.a.A(bArr, iA7, dVar);
                    xVar.g(dVar.f1441b);
                }
                if (iA7 == i18) {
                    return iA7;
                }
                throw c0.g();
            case BERTags.UTC_TIME /* 23 */:
            case 32:
            case 40:
            case 46:
                if (i11 == 2) {
                    j0 j0Var3 = (j0) zVar;
                    int iA8 = a.a.A(bArr, i8, dVar);
                    int i19 = dVar.f1441b + iA8;
                    while (iA8 < i19) {
                        j0Var3.g(a.a.t(bArr, iA8));
                        iA8 += 8;
                    }
                    if (iA8 == i19) {
                        return iA8;
                    }
                    throw c0.g();
                }
                if (i11 == 1) {
                    j0 j0Var4 = (j0) zVar;
                    j0Var4.g(a.a.t(bArr, i8));
                    int i20 = i8 + 8;
                    while (i20 < i9) {
                        int iA9 = a.a.A(bArr, i20, dVar);
                        if (i10 != dVar.f1441b) {
                            return i20;
                        }
                        j0Var4.g(a.a.t(bArr, iA9));
                        i20 = iA9 + 8;
                    }
                    return i20;
                }
                return i8;
            case 24:
            case BERTags.DATE /* 31 */:
            case 41:
            case 45:
                if (i11 == 2) {
                    x xVar2 = (x) zVar;
                    int iA10 = a.a.A(bArr, i8, dVar);
                    int i21 = dVar.f1441b + iA10;
                    while (iA10 < i21) {
                        xVar2.g(a.a.s(bArr, iA10));
                        iA10 += 4;
                    }
                    if (iA10 == i21) {
                        return iA10;
                    }
                    throw c0.g();
                }
                if (i11 == 5) {
                    x xVar3 = (x) zVar;
                    xVar3.g(a.a.s(bArr, i8));
                    int i22 = i8 + 4;
                    while (i22 < i9) {
                        int iA11 = a.a.A(bArr, i22, dVar);
                        if (i10 != dVar.f1441b) {
                            return i22;
                        }
                        xVar3.g(a.a.s(bArr, iA11));
                        i22 = iA11 + 4;
                    }
                    return i22;
                }
                return i8;
            case BERTags.GRAPHIC_STRING /* 25 */:
            case 42:
                if (i11 == 2) {
                    e eVar = (e) zVar;
                    int iA12 = a.a.A(bArr, i8, dVar);
                    int i23 = dVar.f1441b + iA12;
                    while (iA12 < i23) {
                        iA12 = a.a.C(bArr, iA12, dVar);
                        eVar.g(dVar.f1442c != 0);
                    }
                    if (iA12 == i23) {
                        return iA12;
                    }
                    throw c0.g();
                }
                if (i11 == 0) {
                    e eVar2 = (e) zVar;
                    int iC2 = a.a.C(bArr, i8, dVar);
                    eVar2.g(dVar.f1442c != 0);
                    while (iC2 < i9) {
                        int iA13 = a.a.A(bArr, iC2, dVar);
                        if (i10 != dVar.f1441b) {
                            return iC2;
                        }
                        iC2 = a.a.C(bArr, iA13, dVar);
                        eVar2.g(dVar.f1442c != 0);
                    }
                    return iC2;
                }
                return i8;
            case BERTags.VISIBLE_STRING /* 26 */:
                if (i11 == 2) {
                    if ((j4 & 536870912) == 0) {
                        int iA14 = a.a.A(bArr, i8, dVar);
                        int i24 = dVar.f1441b;
                        if (i24 < 0) {
                            throw c0.e();
                        }
                        if (i24 == 0) {
                            zVar.add(SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID);
                        } else {
                            zVar.add(new String(bArr, iA14, i24, a0.f1428a));
                            iA14 += i24;
                        }
                        while (iA14 < i9) {
                            int iA15 = a.a.A(bArr, iA14, dVar);
                            if (i10 != dVar.f1441b) {
                                return iA14;
                            }
                            iA14 = a.a.A(bArr, iA15, dVar);
                            int i25 = dVar.f1441b;
                            if (i25 < 0) {
                                throw c0.e();
                            }
                            if (i25 == 0) {
                                zVar.add(SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID);
                            } else {
                                zVar.add(new String(bArr, iA14, i25, a0.f1428a));
                                iA14 += i25;
                            }
                        }
                        return iA14;
                    }
                    int iA16 = a.a.A(bArr, i8, dVar);
                    int i26 = dVar.f1441b;
                    if (i26 < 0) {
                        throw c0.e();
                    }
                    if (i26 == 0) {
                        zVar.add(SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID);
                    } else {
                        int i27 = iA16 + i26;
                        if (!q1.f1510a.R(iA16, i27, bArr)) {
                            throw c0.b();
                        }
                        zVar.add(new String(bArr, iA16, i26, a0.f1428a));
                        iA16 = i27;
                    }
                    while (iA16 < i9) {
                        int iA17 = a.a.A(bArr, iA16, dVar);
                        if (i10 != dVar.f1441b) {
                            return iA16;
                        }
                        iA16 = a.a.A(bArr, iA17, dVar);
                        int i28 = dVar.f1441b;
                        if (i28 < 0) {
                            throw c0.e();
                        }
                        if (i28 == 0) {
                            zVar.add(SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID);
                        } else {
                            int i29 = iA16 + i28;
                            if (!q1.f1510a.R(iA16, i29, bArr)) {
                                throw c0.b();
                            }
                            zVar.add(new String(bArr, iA16, i28, a0.f1428a));
                            iA16 = i29;
                        }
                    }
                    return iA16;
                }
                return i8;
            case BERTags.GENERAL_STRING /* 27 */:
                if (i11 == 2) {
                    return a.a.u(p(i12), i10, bArr, i8, i9, zVar, dVar);
                }
                return i8;
            case BERTags.UNIVERSAL_STRING /* 28 */:
                if (i11 == 2) {
                    int iA18 = a.a.A(bArr, i8, dVar);
                    int i30 = dVar.f1441b;
                    if (i30 < 0) {
                        throw c0.e();
                    }
                    if (i30 > bArr.length - iA18) {
                        throw c0.g();
                    }
                    if (i30 == 0) {
                        zVar.add(i.f1465b);
                    } else {
                        zVar.add(i.h(iA18, i30, bArr));
                        iA18 += i30;
                    }
                    while (iA18 < i9) {
                        int iA19 = a.a.A(bArr, iA18, dVar);
                        if (i10 != dVar.f1441b) {
                            return iA18;
                        }
                        iA18 = a.a.A(bArr, iA19, dVar);
                        int i31 = dVar.f1441b;
                        if (i31 < 0) {
                            throw c0.e();
                        }
                        if (i31 > bArr.length - iA18) {
                            throw c0.g();
                        }
                        if (i31 == 0) {
                            zVar.add(i.f1465b);
                        } else {
                            zVar.add(i.h(iA18, i31, bArr));
                            iA18 += i31;
                        }
                    }
                    return iA18;
                }
                return i8;
            case 30:
            case 44:
                if (i11 != 2) {
                    if (i11 == 0) {
                        iB = a.a.B(i10, bArr, i8, i9, zVar, dVar);
                    }
                    return i8;
                }
                x xVar4 = (x) zVar;
                iB = a.a.A(bArr, i8, dVar);
                int i32 = dVar.f1441b + iB;
                while (iB < i32) {
                    iB = a.a.A(bArr, iB, dVar);
                    xVar4.g(dVar.f1441b);
                }
                if (iB != i32) {
                    throw c0.g();
                }
                n(i12);
                Class cls = c1.f1437a;
                return iB;
            case BERTags.DATE_TIME /* 33 */:
            case 47:
                if (i11 == 2) {
                    x xVar5 = (x) zVar;
                    int iA20 = a.a.A(bArr, i8, dVar);
                    int i33 = dVar.f1441b + iA20;
                    while (iA20 < i33) {
                        iA20 = a.a.A(bArr, iA20, dVar);
                        xVar5.g(a2.e.d(dVar.f1441b));
                    }
                    if (iA20 == i33) {
                        return iA20;
                    }
                    throw c0.g();
                }
                if (i11 == 0) {
                    x xVar6 = (x) zVar;
                    int iA21 = a.a.A(bArr, i8, dVar);
                    xVar6.g(a2.e.d(dVar.f1441b));
                    while (iA21 < i9) {
                        int iA22 = a.a.A(bArr, iA21, dVar);
                        if (i10 != dVar.f1441b) {
                            return iA21;
                        }
                        iA21 = a.a.A(bArr, iA22, dVar);
                        xVar6.g(a2.e.d(dVar.f1441b));
                    }
                    return iA21;
                }
                return i8;
            case BERTags.DURATION /* 34 */:
            case 48:
                if (i11 == 2) {
                    j0 j0Var5 = (j0) zVar;
                    int iA23 = a.a.A(bArr, i8, dVar);
                    int i34 = dVar.f1441b + iA23;
                    while (iA23 < i34) {
                        iA23 = a.a.C(bArr, iA23, dVar);
                        j0Var5.g(a2.e.e(dVar.f1442c));
                    }
                    if (iA23 == i34) {
                        return iA23;
                    }
                    throw c0.g();
                }
                if (i11 == 0) {
                    j0 j0Var6 = (j0) zVar;
                    int iC3 = a.a.C(bArr, i8, dVar);
                    j0Var6.g(a2.e.e(dVar.f1442c));
                    while (iC3 < i9) {
                        int iA24 = a.a.A(bArr, iC3, dVar);
                        if (i10 != dVar.f1441b) {
                            return iC3;
                        }
                        iC3 = a.a.C(bArr, iA24, dVar);
                        j0Var6.g(a2.e.e(dVar.f1442c));
                    }
                    return iC3;
                }
                return i8;
            case 49:
                if (i11 == 3) {
                    b1 b1VarP = p(i12);
                    int i35 = (i10 & (-8)) | 4;
                    Object objD = b1VarP.d();
                    s0 s0Var = (s0) b1VarP;
                    int I = s0Var.I(objD, bArr, i8, i9, i35, dVar);
                    dVar.d = objD;
                    b1VarP.b(objD);
                    dVar.d = objD;
                    zVar.add(objD);
                    while (I < i9) {
                        int iA25 = a.a.A(bArr, I, dVar);
                        if (i10 != dVar.f1441b) {
                            return I;
                        }
                        Object objD2 = b1VarP.d();
                        I = s0Var.I(objD2, bArr, iA25, i9, i35, dVar);
                        dVar.d = objD2;
                        b1VarP.b(objD2);
                        dVar.d = objD2;
                        zVar.add(objD2);
                    }
                    return I;
                }
                return i8;
            default:
                return i8;
        }
    }

    public final void L(Object obj, long j4, androidx.datastore.preferences.protobuf.j jVar, b1 b1Var, o oVar) throws b0 {
        int iC;
        List listC = this.f1528l.c(obj, j4);
        a2.e eVar = (a2.e) jVar.f503e;
        int i8 = jVar.f501b;
        if ((i8 & 7) != 3) {
            throw c0.c();
        }
        do {
            Object objD = b1Var.d();
            jVar.c(objD, b1Var, oVar);
            b1Var.b(objD);
            listC.add(objD);
            if (eVar.g() || jVar.d != 0) {
                return;
            } else {
                iC = eVar.C();
            }
        } while (iC == i8);
        jVar.d = iC;
    }

    public final void M(Object obj, int i8, androidx.datastore.preferences.protobuf.j jVar, b1 b1Var, o oVar) throws c0 {
        int iC;
        List listC = this.f1528l.c(obj, i8 & 1048575);
        a2.e eVar = (a2.e) jVar.f503e;
        int i9 = jVar.f501b;
        if ((i9 & 7) != 2) {
            throw c0.c();
        }
        do {
            Object objD = b1Var.d();
            jVar.e(objD, b1Var, oVar);
            b1Var.b(objD);
            listC.add(objD);
            if (eVar.g() || jVar.d != 0) {
                return;
            } else {
                iC = eVar.C();
            }
        } while (iC == i9);
        jVar.d = iC;
    }

    public final void N(int i8, androidx.datastore.preferences.protobuf.j jVar, Object obj) throws androidx.datastore.preferences.protobuf.y, b0 {
        if ((536870912 & i8) != 0) {
            jVar.P(2);
            n1.p(i8 & 1048575, obj, ((a2.e) jVar.f503e).B());
        } else if (!this.f1522f) {
            n1.p(i8 & 1048575, obj, jVar.i());
        } else {
            jVar.P(2);
            n1.p(i8 & 1048575, obj, ((a2.e) jVar.f503e).A());
        }
    }

    public final void P(int i8, Object obj) {
        int i9 = this.f1518a[i8 + 2];
        long j4 = 1048575 & i9;
        if (j4 == 1048575) {
            return;
        }
        n1.n((1 << (i9 >>> 20)) | n1.f1499c.g(obj, j4), j4, obj);
    }

    public final void Q(Object obj, int i8, int i9) {
        n1.n(i8, this.f1518a[i9 + 2] & 1048575, obj);
    }

    public final int R(int i8, int i9) {
        int[] iArr = this.f1518a;
        int length = (iArr.length / 3) - 1;
        while (i9 <= length) {
            int i10 = (length + i9) >>> 1;
            int i11 = i10 * 3;
            int i12 = iArr[i11];
            if (i8 == i12) {
                return i11;
            }
            if (i8 < i12) {
                length = i10 - 1;
            } else {
                i9 = i10 + 1;
            }
        }
        return -1;
    }

    public final void S(Object obj, int i8, Object obj2) {
        f1517p.putObject(obj, V(i8) & 1048575, obj2);
        P(i8, obj);
    }

    public final void T(Object obj, int i8, int i9, Object obj2) {
        f1517p.putObject(obj, V(i9) & 1048575, obj2);
        Q(obj, i8, i9);
    }

    public final int V(int i8) {
        return this.f1518a[i8 + 1];
    }

    public final void W(Object obj, l0 l0Var) throws androidx.datastore.preferences.protobuf.k {
        int i8;
        int i9;
        int i10;
        int[] iArr = this.f1518a;
        int length = iArr.length;
        Unsafe unsafe = f1517p;
        int i11 = 1048575;
        int i12 = 0;
        for (int i13 = 0; i13 < length; i13 = i10 + 3) {
            int iV = V(i13);
            int i14 = iArr[i13];
            int iU = U(iV);
            if (iU <= 17) {
                int i15 = iArr[i13 + 2];
                i8 = 1048575;
                int i16 = i15 & 1048575;
                if (i16 != i11) {
                    i12 = unsafe.getInt(obj, i16);
                    i11 = i16;
                }
                i9 = 1 << (i15 >>> 20);
            } else {
                i8 = 1048575;
                i9 = 0;
            }
            int i17 = i13;
            long j4 = iV & i8;
            switch (iU) {
                case 0:
                    i10 = i17;
                    if ((i9 & i12) != 0) {
                        double dE = n1.f1499c.e(obj, j4);
                        l lVar = (l) l0Var.f1492a;
                        lVar.getClass();
                        lVar.g0(i14, Double.doubleToRawLongBits(dE));
                        continue;
                    }
                case 1:
                    i10 = i17;
                    if ((i9 & i12) != 0) {
                        float f3 = n1.f1499c.f(obj, j4);
                        l lVar2 = (l) l0Var.f1492a;
                        lVar2.getClass();
                        lVar2.e0(i14, Float.floatToRawIntBits(f3));
                    } else {
                        continue;
                    }
                case 2:
                    i10 = i17;
                    if ((i9 & i12) != 0) {
                        ((l) l0Var.f1492a).l0(i14, unsafe.getLong(obj, j4));
                    } else {
                        continue;
                    }
                case 3:
                    i10 = i17;
                    if ((i9 & i12) != 0) {
                        ((l) l0Var.f1492a).l0(i14, unsafe.getLong(obj, j4));
                    } else {
                        continue;
                    }
                case 4:
                    i10 = i17;
                    if ((i9 & i12) != 0) {
                        int i18 = unsafe.getInt(obj, j4);
                        l lVar3 = (l) l0Var.f1492a;
                        lVar3.j0(i14, 0);
                        lVar3.i0(i18);
                    }
                    break;
                case 5:
                    i10 = i17;
                    if ((i9 & i12) != 0) {
                        ((l) l0Var.f1492a).g0(i14, unsafe.getLong(obj, j4));
                        break;
                    }
                    break;
                case 6:
                    i10 = i17;
                    if ((i9 & i12) != 0) {
                        ((l) l0Var.f1492a).e0(i14, unsafe.getInt(obj, j4));
                        break;
                    }
                    break;
                case 7:
                    i10 = i17;
                    if ((i9 & i12) != 0) {
                        boolean zC = n1.f1499c.c(obj, j4);
                        l lVar4 = (l) l0Var.f1492a;
                        lVar4.j0(i14, 0);
                        lVar4.c0(zC ? (byte) 1 : (byte) 0);
                        break;
                    }
                    break;
                case 8:
                    i10 = i17;
                    if ((i9 & i12) != 0) {
                        X(i14, unsafe.getObject(obj, j4), l0Var);
                        break;
                    }
                    break;
                case 9:
                    i10 = i17;
                    if ((i9 & i12) != 0) {
                        l0Var.c(i14, unsafe.getObject(obj, j4), p(i10));
                        break;
                    }
                    break;
                case 10:
                    i10 = i17;
                    if ((i9 & i12) != 0) {
                        l0Var.a(i14, (i) unsafe.getObject(obj, j4));
                        break;
                    }
                    break;
                case BERTags.EMBEDDED_PDV /* 11 */:
                    i10 = i17;
                    if ((i9 & i12) != 0) {
                        int i19 = unsafe.getInt(obj, j4);
                        l lVar5 = (l) l0Var.f1492a;
                        lVar5.j0(i14, 0);
                        lVar5.k0(i19);
                        break;
                    }
                    break;
                case 12:
                    i10 = i17;
                    if ((i9 & i12) != 0) {
                        int i20 = unsafe.getInt(obj, j4);
                        l lVar6 = (l) l0Var.f1492a;
                        lVar6.j0(i14, 0);
                        lVar6.i0(i20);
                    }
                    break;
                case BERTags.RELATIVE_OID /* 13 */:
                    i10 = i17;
                    if ((i9 & i12) != 0) {
                        ((l) l0Var.f1492a).e0(i14, unsafe.getInt(obj, j4));
                        break;
                    }
                    break;
                case BERTags.TIME /* 14 */:
                    i10 = i17;
                    if ((i9 & i12) != 0) {
                        ((l) l0Var.f1492a).g0(i14, unsafe.getLong(obj, j4));
                        break;
                    }
                    break;
                case 15:
                    i10 = i17;
                    if ((i9 & i12) != 0) {
                        int i21 = unsafe.getInt(obj, j4);
                        l lVar7 = (l) l0Var.f1492a;
                        lVar7.j0(i14, 0);
                        lVar7.k0((i21 >> 31) ^ (i21 << 1));
                        break;
                    }
                    break;
                case 16:
                    i10 = i17;
                    if ((i9 & i12) != 0) {
                        long j8 = unsafe.getLong(obj, j4);
                        ((l) l0Var.f1492a).l0(i14, (j8 << 1) ^ (j8 >> 63));
                        break;
                    }
                    break;
                case 17:
                    i10 = i17;
                    if ((i9 & i12) != 0) {
                        l0Var.b(i14, unsafe.getObject(obj, j4), p(i10));
                        break;
                    }
                    break;
                case BERTags.NUMERIC_STRING /* 18 */:
                    i10 = i17;
                    c1.A(iArr[i10], (List) unsafe.getObject(obj, j4), l0Var, false);
                    break;
                case 19:
                    i10 = i17;
                    c1.E(iArr[i10], (List) unsafe.getObject(obj, j4), l0Var, false);
                    continue;
                case 20:
                    i10 = i17;
                    c1.H(iArr[i10], (List) unsafe.getObject(obj, j4), l0Var, false);
                    continue;
                case BERTags.VIDEOTEX_STRING /* 21 */:
                    i10 = i17;
                    c1.P(iArr[i10], (List) unsafe.getObject(obj, j4), l0Var, false);
                    continue;
                case BERTags.IA5_STRING /* 22 */:
                    i10 = i17;
                    c1.G(iArr[i10], (List) unsafe.getObject(obj, j4), l0Var, false);
                    continue;
                case BERTags.UTC_TIME /* 23 */:
                    i10 = i17;
                    c1.D(iArr[i10], (List) unsafe.getObject(obj, j4), l0Var, false);
                    continue;
                case 24:
                    i10 = i17;
                    c1.C(iArr[i10], (List) unsafe.getObject(obj, j4), l0Var, false);
                    continue;
                case BERTags.GRAPHIC_STRING /* 25 */:
                    i10 = i17;
                    c1.y(iArr[i10], (List) unsafe.getObject(obj, j4), l0Var, false);
                    continue;
                case BERTags.VISIBLE_STRING /* 26 */:
                    i10 = i17;
                    c1.N(iArr[i10], (List) unsafe.getObject(obj, j4), l0Var);
                    break;
                case BERTags.GENERAL_STRING /* 27 */:
                    i10 = i17;
                    c1.I(iArr[i10], (List) unsafe.getObject(obj, j4), l0Var, p(i10));
                    break;
                case BERTags.UNIVERSAL_STRING /* 28 */:
                    i10 = i17;
                    c1.z(iArr[i10], (List) unsafe.getObject(obj, j4), l0Var);
                    break;
                case BERTags.UNRESTRICTED_STRING /* 29 */:
                    i10 = i17;
                    c1.O(iArr[i10], (List) unsafe.getObject(obj, j4), l0Var, false);
                    break;
                case 30:
                    i10 = i17;
                    c1.B(iArr[i10], (List) unsafe.getObject(obj, j4), l0Var, false);
                    continue;
                case BERTags.DATE /* 31 */:
                    i10 = i17;
                    c1.J(iArr[i10], (List) unsafe.getObject(obj, j4), l0Var, false);
                    continue;
                case 32:
                    i10 = i17;
                    c1.K(iArr[i10], (List) unsafe.getObject(obj, j4), l0Var, false);
                    continue;
                case BERTags.DATE_TIME /* 33 */:
                    i10 = i17;
                    c1.L(iArr[i10], (List) unsafe.getObject(obj, j4), l0Var, false);
                    continue;
                case BERTags.DURATION /* 34 */:
                    i10 = i17;
                    c1.M(iArr[i10], (List) unsafe.getObject(obj, j4), l0Var, false);
                    continue;
                case BERTags.OBJECT_IDENTIFIER_IRI /* 35 */:
                    i10 = i17;
                    c1.A(iArr[i10], (List) unsafe.getObject(obj, j4), l0Var, true);
                    break;
                case BERTags.RELATIVE_OID_IRI /* 36 */:
                    i10 = i17;
                    c1.E(iArr[i10], (List) unsafe.getObject(obj, j4), l0Var, true);
                    break;
                case 37:
                    i10 = i17;
                    c1.H(iArr[i10], (List) unsafe.getObject(obj, j4), l0Var, true);
                    break;
                case 38:
                    i10 = i17;
                    c1.P(iArr[i10], (List) unsafe.getObject(obj, j4), l0Var, true);
                    break;
                case 39:
                    i10 = i17;
                    c1.G(iArr[i10], (List) unsafe.getObject(obj, j4), l0Var, true);
                    break;
                case 40:
                    i10 = i17;
                    c1.D(iArr[i10], (List) unsafe.getObject(obj, j4), l0Var, true);
                    break;
                case 41:
                    i10 = i17;
                    c1.C(iArr[i10], (List) unsafe.getObject(obj, j4), l0Var, true);
                    break;
                case 42:
                    i10 = i17;
                    c1.y(iArr[i10], (List) unsafe.getObject(obj, j4), l0Var, true);
                    break;
                case 43:
                    i10 = i17;
                    c1.O(iArr[i10], (List) unsafe.getObject(obj, j4), l0Var, true);
                    break;
                case 44:
                    i10 = i17;
                    c1.B(iArr[i10], (List) unsafe.getObject(obj, j4), l0Var, true);
                    break;
                case 45:
                    i10 = i17;
                    c1.J(iArr[i10], (List) unsafe.getObject(obj, j4), l0Var, true);
                    break;
                case 46:
                    i10 = i17;
                    c1.K(iArr[i10], (List) unsafe.getObject(obj, j4), l0Var, true);
                    break;
                case 47:
                    i10 = i17;
                    c1.L(iArr[i10], (List) unsafe.getObject(obj, j4), l0Var, true);
                    break;
                case 48:
                    i10 = i17;
                    c1.M(iArr[i10], (List) unsafe.getObject(obj, j4), l0Var, true);
                    break;
                case 49:
                    i10 = i17;
                    c1.F(iArr[i10], (List) unsafe.getObject(obj, j4), l0Var, p(i10));
                    break;
                case 50:
                    i10 = i17;
                    if (unsafe.getObject(obj, j4) != null) {
                        Object objO = o(i10);
                        this.f1530n.getClass();
                        a8.b.x(objO);
                        throw null;
                    }
                    break;
                case 51:
                    i10 = i17;
                    if (u(obj, i14, i10)) {
                        double dDoubleValue = ((Double) n1.f1499c.i(obj, j4)).doubleValue();
                        l lVar8 = (l) l0Var.f1492a;
                        lVar8.getClass();
                        lVar8.g0(i14, Double.doubleToRawLongBits(dDoubleValue));
                        break;
                    }
                    break;
                case 52:
                    i10 = i17;
                    if (u(obj, i14, i10)) {
                        float fFloatValue = ((Float) n1.f1499c.i(obj, j4)).floatValue();
                        l lVar9 = (l) l0Var.f1492a;
                        lVar9.getClass();
                        lVar9.e0(i14, Float.floatToRawIntBits(fFloatValue));
                        break;
                    }
                    break;
                case 53:
                    i10 = i17;
                    if (u(obj, i14, i10)) {
                        ((l) l0Var.f1492a).l0(i14, F(obj, j4));
                        break;
                    }
                    break;
                case 54:
                    i10 = i17;
                    if (u(obj, i14, i10)) {
                        ((l) l0Var.f1492a).l0(i14, F(obj, j4));
                        break;
                    }
                    break;
                case 55:
                    i10 = i17;
                    if (u(obj, i14, i10)) {
                        int iE = E(obj, j4);
                        l lVar10 = (l) l0Var.f1492a;
                        lVar10.j0(i14, 0);
                        lVar10.i0(iE);
                        break;
                    }
                    break;
                case 56:
                    i10 = i17;
                    if (u(obj, i14, i10)) {
                        ((l) l0Var.f1492a).g0(i14, F(obj, j4));
                        break;
                    }
                    break;
                case 57:
                    i10 = i17;
                    if (u(obj, i14, i10)) {
                        ((l) l0Var.f1492a).e0(i14, E(obj, j4));
                        break;
                    }
                    break;
                case 58:
                    i10 = i17;
                    if (u(obj, i14, i10)) {
                        boolean zBooleanValue = ((Boolean) n1.f1499c.i(obj, j4)).booleanValue();
                        l lVar11 = (l) l0Var.f1492a;
                        lVar11.j0(i14, 0);
                        lVar11.c0(zBooleanValue ? (byte) 1 : (byte) 0);
                        break;
                    }
                    break;
                case 59:
                    i10 = i17;
                    if (u(obj, i14, i10)) {
                        X(i14, unsafe.getObject(obj, j4), l0Var);
                        break;
                    }
                    break;
                case 60:
                    i10 = i17;
                    if (u(obj, i14, i10)) {
                        l0Var.c(i14, unsafe.getObject(obj, j4), p(i10));
                        break;
                    }
                    break;
                case 61:
                    i10 = i17;
                    if (u(obj, i14, i10)) {
                        l0Var.a(i14, (i) unsafe.getObject(obj, j4));
                        break;
                    }
                    break;
                case 62:
                    i10 = i17;
                    if (u(obj, i14, i10)) {
                        int iE2 = E(obj, j4);
                        l lVar12 = (l) l0Var.f1492a;
                        lVar12.j0(i14, 0);
                        lVar12.k0(iE2);
                        break;
                    }
                    break;
                case SkeinParameters.PARAM_TYPE_OUTPUT /* 63 */:
                    i10 = i17;
                    if (u(obj, i14, i10)) {
                        int iE3 = E(obj, j4);
                        l lVar13 = (l) l0Var.f1492a;
                        lVar13.j0(i14, 0);
                        lVar13.i0(iE3);
                    }
                    break;
                case 64:
                    i10 = i17;
                    if (u(obj, i14, i10)) {
                        ((l) l0Var.f1492a).e0(i14, E(obj, j4));
                        break;
                    }
                    break;
                case 65:
                    i10 = i17;
                    if (u(obj, i14, i10)) {
                        ((l) l0Var.f1492a).g0(i14, F(obj, j4));
                        break;
                    }
                    break;
                case 66:
                    i10 = i17;
                    if (u(obj, i14, i10)) {
                        int iE4 = E(obj, j4);
                        l lVar14 = (l) l0Var.f1492a;
                        lVar14.j0(i14, 0);
                        lVar14.k0((iE4 >> 31) ^ (iE4 << 1));
                        break;
                    }
                    break;
                case 67:
                    i10 = i17;
                    if (u(obj, i14, i10)) {
                        long jF = F(obj, j4);
                        ((l) l0Var.f1492a).l0(i14, (jF << 1) ^ (jF >> 63));
                        break;
                    }
                    break;
                case 68:
                    i10 = i17;
                    if (u(obj, i14, i10)) {
                        l0Var.b(i14, unsafe.getObject(obj, j4), p(i10));
                        break;
                    }
                    break;
                default:
                    i10 = i17;
                    break;
            }
        }
        this.f1529m.getClass();
        ((w) obj).unknownFields.e(l0Var);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0022  */
    @Override // com.google.crypto.tink.shaded.protobuf.b1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.lang.Object r11, java.lang.Object r12) {
        /*
            Method dump skipped, instructions count: 590
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.s0.a(java.lang.Object, java.lang.Object):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0051  */
    @Override // com.google.crypto.tink.shaded.protobuf.b1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(java.lang.Object r9) {
        /*
            r8 = this;
            boolean r0 = t(r9)
            if (r0 != 0) goto L7
            return
        L7:
            boolean r0 = r9 instanceof com.google.crypto.tink.shaded.protobuf.w
            r1 = 0
            if (r0 == 0) goto L1a
            r0 = r9
            com.google.crypto.tink.shaded.protobuf.w r0 = (com.google.crypto.tink.shaded.protobuf.w) r0
            r2 = 2147483647(0x7fffffff, float:NaN)
            r0.u(r2)
            r0.memoizedHashCode = r1
            r0.o()
        L1a:
            int[] r0 = r8.f1518a
            int r0 = r0.length
            r2 = r1
        L1e:
            if (r2 >= r0) goto L67
            int r3 = r8.V(r2)
            r4 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r4 & r3
            long r4 = (long) r4
            int r3 = U(r3)
            r6 = 9
            if (r3 == r6) goto L51
            switch(r3) {
                case 17: goto L51;
                case 18: goto L4b;
                case 19: goto L4b;
                case 20: goto L4b;
                case 21: goto L4b;
                case 22: goto L4b;
                case 23: goto L4b;
                case 24: goto L4b;
                case 25: goto L4b;
                case 26: goto L4b;
                case 27: goto L4b;
                case 28: goto L4b;
                case 29: goto L4b;
                case 30: goto L4b;
                case 31: goto L4b;
                case 32: goto L4b;
                case 33: goto L4b;
                case 34: goto L4b;
                case 35: goto L4b;
                case 36: goto L4b;
                case 37: goto L4b;
                case 38: goto L4b;
                case 39: goto L4b;
                case 40: goto L4b;
                case 41: goto L4b;
                case 42: goto L4b;
                case 43: goto L4b;
                case 44: goto L4b;
                case 45: goto L4b;
                case 46: goto L4b;
                case 47: goto L4b;
                case 48: goto L4b;
                case 49: goto L4b;
                case 50: goto L35;
                default: goto L34;
            }
        L34:
            goto L64
        L35:
            sun.misc.Unsafe r3 = com.google.crypto.tink.shaded.protobuf.s0.f1517p
            java.lang.Object r6 = r3.getObject(r9, r4)
            if (r6 == 0) goto L64
            com.google.crypto.tink.shaded.protobuf.n0 r7 = r8.f1530n
            r7.getClass()
            r7 = r6
            com.google.crypto.tink.shaded.protobuf.m0 r7 = (com.google.crypto.tink.shaded.protobuf.m0) r7
            r7.f1494a = r1
            r3.putObject(r9, r4, r6)
            goto L64
        L4b:
            com.google.crypto.tink.shaded.protobuf.i0 r3 = r8.f1528l
            r3.a(r9, r4)
            goto L64
        L51:
            boolean r3 = r8.s(r2, r9)
            if (r3 == 0) goto L64
            com.google.crypto.tink.shaded.protobuf.b1 r3 = r8.p(r2)
            sun.misc.Unsafe r6 = com.google.crypto.tink.shaded.protobuf.s0.f1517p
            java.lang.Object r4 = r6.getObject(r9, r4)
            r3.b(r4)
        L64:
            int r2 = r2 + 3
            goto L1e
        L67:
            com.google.crypto.tink.shaded.protobuf.f1 r8 = r8.f1529m
            r8.getClass()
            com.google.crypto.tink.shaded.protobuf.w r9 = (com.google.crypto.tink.shaded.protobuf.w) r9
            com.google.crypto.tink.shaded.protobuf.e1 r8 = r9.unknownFields
            r8.f1458e = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.s0.b(java.lang.Object):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0045  */
    @Override // com.google.crypto.tink.shaded.protobuf.b1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c(java.lang.Object r14) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.s0.c(java.lang.Object):boolean");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.b1
    public final Object d() {
        this.f1527k.getClass();
        return ((w) this.f1521e).q();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.b1
    public final int e(w wVar) {
        return this.f1523g ? r(wVar) : q(wVar);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.b1
    public final void f(Object obj, byte[] bArr, int i8, int i9, d dVar) throws c0 {
        if (this.f1523g) {
            J(obj, bArr, i8, i9, dVar);
        } else {
            I(obj, bArr, i8, i9, 0, dVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    @Override // com.google.crypto.tink.shaded.protobuf.b1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g(com.google.crypto.tink.shaded.protobuf.w r12, com.google.crypto.tink.shaded.protobuf.w r13) {
        /*
            Method dump skipped, instructions count: 660
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.s0.g(com.google.crypto.tink.shaded.protobuf.w, com.google.crypto.tink.shaded.protobuf.w):boolean");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.b1
    public final void h(Object obj, l0 l0Var) throws androidx.datastore.preferences.protobuf.k {
        l0Var.getClass();
        l lVar = (l) l0Var.f1492a;
        if (!this.f1523g) {
            W(obj, l0Var);
            return;
        }
        int[] iArr = this.f1518a;
        int length = iArr.length;
        for (int i8 = 0; i8 < length; i8 += 3) {
            int iV = V(i8);
            int i9 = iArr[i8];
            switch (U(iV)) {
                case 0:
                    if (s(i8, obj)) {
                        double dE = n1.f1499c.e(obj, iV & 1048575);
                        lVar.getClass();
                        lVar.g0(i9, Double.doubleToRawLongBits(dE));
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (s(i8, obj)) {
                        float f3 = n1.f1499c.f(obj, iV & 1048575);
                        lVar.getClass();
                        lVar.e0(i9, Float.floatToRawIntBits(f3));
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (s(i8, obj)) {
                        lVar.l0(i9, n1.f1499c.h(obj, iV & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (s(i8, obj)) {
                        lVar.l0(i9, n1.f1499c.h(obj, iV & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (s(i8, obj)) {
                        int iG = n1.f1499c.g(obj, iV & 1048575);
                        lVar.j0(i9, 0);
                        lVar.i0(iG);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (s(i8, obj)) {
                        lVar.g0(i9, n1.f1499c.h(obj, iV & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (s(i8, obj)) {
                        lVar.e0(i9, n1.f1499c.g(obj, iV & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (s(i8, obj)) {
                        boolean zC = n1.f1499c.c(obj, iV & 1048575);
                        lVar.j0(i9, 0);
                        lVar.c0(zC ? (byte) 1 : (byte) 0);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (s(i8, obj)) {
                        X(i9, n1.f1499c.i(obj, iV & 1048575), l0Var);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if (s(i8, obj)) {
                        l0Var.c(i9, n1.f1499c.i(obj, iV & 1048575), p(i8));
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (s(i8, obj)) {
                        l0Var.a(i9, (i) n1.f1499c.i(obj, iV & 1048575));
                        break;
                    } else {
                        break;
                    }
                case BERTags.EMBEDDED_PDV /* 11 */:
                    if (s(i8, obj)) {
                        int iG2 = n1.f1499c.g(obj, iV & 1048575);
                        lVar.j0(i9, 0);
                        lVar.k0(iG2);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (s(i8, obj)) {
                        int iG3 = n1.f1499c.g(obj, iV & 1048575);
                        lVar.j0(i9, 0);
                        lVar.i0(iG3);
                        break;
                    } else {
                        break;
                    }
                case BERTags.RELATIVE_OID /* 13 */:
                    if (s(i8, obj)) {
                        lVar.e0(i9, n1.f1499c.g(obj, iV & 1048575));
                        break;
                    } else {
                        break;
                    }
                case BERTags.TIME /* 14 */:
                    if (s(i8, obj)) {
                        lVar.g0(i9, n1.f1499c.h(obj, iV & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (s(i8, obj)) {
                        int iG4 = n1.f1499c.g(obj, iV & 1048575);
                        lVar.j0(i9, 0);
                        lVar.k0((iG4 >> 31) ^ (iG4 << 1));
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (s(i8, obj)) {
                        long jH = n1.f1499c.h(obj, iV & 1048575);
                        lVar.l0(i9, (jH >> 63) ^ (jH << 1));
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (s(i8, obj)) {
                        l0Var.b(i9, n1.f1499c.i(obj, iV & 1048575), p(i8));
                        break;
                    } else {
                        break;
                    }
                case BERTags.NUMERIC_STRING /* 18 */:
                    c1.A(iArr[i8], (List) n1.f1499c.i(obj, iV & 1048575), l0Var, false);
                    break;
                case 19:
                    c1.E(iArr[i8], (List) n1.f1499c.i(obj, iV & 1048575), l0Var, false);
                    break;
                case 20:
                    c1.H(iArr[i8], (List) n1.f1499c.i(obj, iV & 1048575), l0Var, false);
                    break;
                case BERTags.VIDEOTEX_STRING /* 21 */:
                    c1.P(iArr[i8], (List) n1.f1499c.i(obj, iV & 1048575), l0Var, false);
                    break;
                case BERTags.IA5_STRING /* 22 */:
                    c1.G(iArr[i8], (List) n1.f1499c.i(obj, iV & 1048575), l0Var, false);
                    break;
                case BERTags.UTC_TIME /* 23 */:
                    c1.D(iArr[i8], (List) n1.f1499c.i(obj, iV & 1048575), l0Var, false);
                    break;
                case 24:
                    c1.C(iArr[i8], (List) n1.f1499c.i(obj, iV & 1048575), l0Var, false);
                    break;
                case BERTags.GRAPHIC_STRING /* 25 */:
                    c1.y(iArr[i8], (List) n1.f1499c.i(obj, iV & 1048575), l0Var, false);
                    break;
                case BERTags.VISIBLE_STRING /* 26 */:
                    c1.N(iArr[i8], (List) n1.f1499c.i(obj, iV & 1048575), l0Var);
                    break;
                case BERTags.GENERAL_STRING /* 27 */:
                    c1.I(iArr[i8], (List) n1.f1499c.i(obj, iV & 1048575), l0Var, p(i8));
                    break;
                case BERTags.UNIVERSAL_STRING /* 28 */:
                    c1.z(iArr[i8], (List) n1.f1499c.i(obj, iV & 1048575), l0Var);
                    break;
                case BERTags.UNRESTRICTED_STRING /* 29 */:
                    c1.O(iArr[i8], (List) n1.f1499c.i(obj, iV & 1048575), l0Var, false);
                    break;
                case 30:
                    c1.B(iArr[i8], (List) n1.f1499c.i(obj, iV & 1048575), l0Var, false);
                    break;
                case BERTags.DATE /* 31 */:
                    c1.J(iArr[i8], (List) n1.f1499c.i(obj, iV & 1048575), l0Var, false);
                    break;
                case 32:
                    c1.K(iArr[i8], (List) n1.f1499c.i(obj, iV & 1048575), l0Var, false);
                    break;
                case BERTags.DATE_TIME /* 33 */:
                    c1.L(iArr[i8], (List) n1.f1499c.i(obj, iV & 1048575), l0Var, false);
                    break;
                case BERTags.DURATION /* 34 */:
                    c1.M(iArr[i8], (List) n1.f1499c.i(obj, iV & 1048575), l0Var, false);
                    break;
                case BERTags.OBJECT_IDENTIFIER_IRI /* 35 */:
                    c1.A(iArr[i8], (List) n1.f1499c.i(obj, iV & 1048575), l0Var, true);
                    break;
                case BERTags.RELATIVE_OID_IRI /* 36 */:
                    c1.E(iArr[i8], (List) n1.f1499c.i(obj, iV & 1048575), l0Var, true);
                    break;
                case 37:
                    c1.H(iArr[i8], (List) n1.f1499c.i(obj, iV & 1048575), l0Var, true);
                    break;
                case 38:
                    c1.P(iArr[i8], (List) n1.f1499c.i(obj, iV & 1048575), l0Var, true);
                    break;
                case 39:
                    c1.G(iArr[i8], (List) n1.f1499c.i(obj, iV & 1048575), l0Var, true);
                    break;
                case 40:
                    c1.D(iArr[i8], (List) n1.f1499c.i(obj, iV & 1048575), l0Var, true);
                    break;
                case 41:
                    c1.C(iArr[i8], (List) n1.f1499c.i(obj, iV & 1048575), l0Var, true);
                    break;
                case 42:
                    c1.y(iArr[i8], (List) n1.f1499c.i(obj, iV & 1048575), l0Var, true);
                    break;
                case 43:
                    c1.O(iArr[i8], (List) n1.f1499c.i(obj, iV & 1048575), l0Var, true);
                    break;
                case 44:
                    c1.B(iArr[i8], (List) n1.f1499c.i(obj, iV & 1048575), l0Var, true);
                    break;
                case 45:
                    c1.J(iArr[i8], (List) n1.f1499c.i(obj, iV & 1048575), l0Var, true);
                    break;
                case 46:
                    c1.K(iArr[i8], (List) n1.f1499c.i(obj, iV & 1048575), l0Var, true);
                    break;
                case 47:
                    c1.L(iArr[i8], (List) n1.f1499c.i(obj, iV & 1048575), l0Var, true);
                    break;
                case 48:
                    c1.M(iArr[i8], (List) n1.f1499c.i(obj, iV & 1048575), l0Var, true);
                    break;
                case 49:
                    c1.F(iArr[i8], (List) n1.f1499c.i(obj, iV & 1048575), l0Var, p(i8));
                    break;
                case 50:
                    if (n1.f1499c.i(obj, iV & 1048575) != null) {
                        Object objO = o(i8);
                        this.f1530n.getClass();
                        a8.b.x(objO);
                        throw null;
                    }
                    break;
                case 51:
                    if (u(obj, i9, i8)) {
                        double dDoubleValue = ((Double) n1.f1499c.i(obj, iV & 1048575)).doubleValue();
                        lVar.getClass();
                        lVar.g0(i9, Double.doubleToRawLongBits(dDoubleValue));
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (u(obj, i9, i8)) {
                        float fFloatValue = ((Float) n1.f1499c.i(obj, iV & 1048575)).floatValue();
                        lVar.getClass();
                        lVar.e0(i9, Float.floatToRawIntBits(fFloatValue));
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (u(obj, i9, i8)) {
                        lVar.l0(i9, F(obj, iV & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (u(obj, i9, i8)) {
                        lVar.l0(i9, F(obj, iV & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (u(obj, i9, i8)) {
                        int iE = E(obj, iV & 1048575);
                        lVar.j0(i9, 0);
                        lVar.i0(iE);
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (u(obj, i9, i8)) {
                        lVar.g0(i9, F(obj, iV & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (u(obj, i9, i8)) {
                        lVar.e0(i9, E(obj, iV & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (u(obj, i9, i8)) {
                        boolean zBooleanValue = ((Boolean) n1.f1499c.i(obj, iV & 1048575)).booleanValue();
                        lVar.j0(i9, 0);
                        lVar.c0(zBooleanValue ? (byte) 1 : (byte) 0);
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (u(obj, i9, i8)) {
                        X(i9, n1.f1499c.i(obj, iV & 1048575), l0Var);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (u(obj, i9, i8)) {
                        l0Var.c(i9, n1.f1499c.i(obj, iV & 1048575), p(i8));
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (u(obj, i9, i8)) {
                        l0Var.a(i9, (i) n1.f1499c.i(obj, iV & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (u(obj, i9, i8)) {
                        int iE2 = E(obj, iV & 1048575);
                        lVar.j0(i9, 0);
                        lVar.k0(iE2);
                        break;
                    } else {
                        break;
                    }
                case SkeinParameters.PARAM_TYPE_OUTPUT /* 63 */:
                    if (u(obj, i9, i8)) {
                        int iE3 = E(obj, iV & 1048575);
                        lVar.j0(i9, 0);
                        lVar.i0(iE3);
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (u(obj, i9, i8)) {
                        lVar.e0(i9, E(obj, iV & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (u(obj, i9, i8)) {
                        lVar.g0(i9, F(obj, iV & 1048575));
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (u(obj, i9, i8)) {
                        int iE4 = E(obj, iV & 1048575);
                        lVar.j0(i9, 0);
                        lVar.k0((iE4 >> 31) ^ (iE4 << 1));
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (u(obj, i9, i8)) {
                        long jF = F(obj, iV & 1048575);
                        lVar.l0(i9, (jF >> 63) ^ (jF << 1));
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (u(obj, i9, i8)) {
                        l0Var.b(i9, n1.f1499c.i(obj, iV & 1048575), p(i8));
                        break;
                    } else {
                        break;
                    }
            }
        }
        this.f1529m.getClass();
        ((w) obj).unknownFields.e(l0Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00e1 A[PHI: r3
      0x00e1: PHI (r3v32 int) = (r3v10 int), (r3v33 int) binds: [B:83:0x0216, B:41:0x00df] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.crypto.tink.shaded.protobuf.b1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int i(com.google.crypto.tink.shaded.protobuf.w r12) {
        /*
            Method dump skipped, instructions count: 794
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.s0.i(com.google.crypto.tink.shaded.protobuf.w):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:147:0x063a A[Catch: all -> 0x0468, TryCatch #3 {all -> 0x0468, blocks: (B:145:0x0635, B:147:0x063a, B:148:0x063f, B:115:0x045c, B:120:0x0470, B:121:0x048c, B:122:0x04a9, B:123:0x04c6, B:124:0x04e5, B:125:0x0501, B:126:0x0516, B:127:0x0531, B:128:0x053e, B:129:0x055c, B:130:0x0579, B:131:0x0596, B:132:0x05b2, B:133:0x05ce, B:134:0x05ea, B:135:0x0608, B:139:0x0626), top: B:168:0x0635 }] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0661 A[LOOP:3: B:158:0x065f->B:159:0x0661, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x066b  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0645 A[SYNTHETIC] */
    @Override // com.google.crypto.tink.shaded.protobuf.b1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j(java.lang.Object r20, androidx.datastore.preferences.protobuf.j r21, com.google.crypto.tink.shaded.protobuf.o r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1794
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.s0.j(java.lang.Object, androidx.datastore.preferences.protobuf.j, com.google.crypto.tink.shaded.protobuf.o):void");
    }

    public final boolean k(w wVar, w wVar2, int i8) {
        return s(i8, wVar) == s(i8, wVar2);
    }

    public final void m(Object obj, int i8, Object obj2) {
        int i9 = this.f1518a[i8];
        if (n1.f1499c.i(obj, V(i8) & 1048575) == null) {
            return;
        }
        n(i8);
    }

    public final void n(int i8) {
        if (this.f1519b[((i8 / 3) * 2) + 1] != null) {
            throw new ClassCastException();
        }
    }

    public final Object o(int i8) {
        return this.f1519b[(i8 / 3) * 2];
    }

    public final b1 p(int i8) {
        int i9 = (i8 / 3) * 2;
        Object[] objArr = this.f1519b;
        b1 b1Var = (b1) objArr[i9];
        if (b1Var != null) {
            return b1Var;
        }
        b1 b1VarA = y0.f1540c.a((Class) objArr[i9 + 1]);
        objArr[i9] = b1VarA;
        return b1VarA;
    }

    public final int q(w wVar) {
        int i8;
        int iZ;
        int iB0;
        int iZ2;
        int iX;
        int iV;
        int iZ3;
        int iY;
        int iD;
        int iW;
        Unsafe unsafe = f1517p;
        int i9 = 1048575;
        int i10 = 1048575;
        int i11 = 0;
        int iC = 0;
        int i12 = 0;
        while (true) {
            int[] iArr = this.f1518a;
            if (i11 >= iArr.length) {
                this.f1529m.getClass();
                return wVar.unknownFields.b() + iC;
            }
            int iV2 = V(i11);
            int i13 = iArr[i11];
            int iU = U(iV2);
            if (iU <= 17) {
                int i14 = iArr[i11 + 2];
                int i15 = i14 & i9;
                i8 = 1 << (i14 >>> 20);
                if (i15 != i10) {
                    i12 = unsafe.getInt(wVar, i15);
                    i10 = i15;
                }
            } else {
                i8 = 0;
            }
            long j4 = iV2 & i9;
            switch (iU) {
                case 0:
                    if ((i12 & i8) != 0) {
                        iC = a8.b.c(i13, 8, iC);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if ((i12 & i8) != 0) {
                        iC = a8.b.c(i13, 4, iC);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if ((i8 & i12) != 0) {
                        long j8 = unsafe.getLong(wVar, j4);
                        iZ = l.Z(i13);
                        iB0 = l.b0(j8);
                        iV = iB0 + iZ;
                        iC += iV;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if ((i8 & i12) != 0) {
                        long j9 = unsafe.getLong(wVar, j4);
                        iZ = l.Z(i13);
                        iB0 = l.b0(j9);
                        iV = iB0 + iZ;
                        iC += iV;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if ((i8 & i12) != 0) {
                        int i16 = unsafe.getInt(wVar, j4);
                        iZ2 = l.Z(i13);
                        iX = l.X(i16);
                        iV = iX + iZ2;
                        iC += iV;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if ((i12 & i8) != 0) {
                        iV = l.V(i13);
                        iC += iV;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if ((i12 & i8) != 0) {
                        iV = l.U(i13);
                        iC += iV;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if ((i12 & i8) != 0) {
                        iC = a8.b.c(i13, 1, iC);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if ((i8 & i12) == 0) {
                        break;
                    } else {
                        Object object = unsafe.getObject(wVar, j4);
                        if (object instanceof i) {
                            int iZ4 = l.Z(i13);
                            int size = ((i) object).size();
                            iD = a8.b.d(size, size, iZ4, iC);
                            iC = iD;
                            break;
                        } else {
                            iZ3 = l.Z(i13);
                            iY = l.Y((String) object);
                            iD = iY + iZ3 + iC;
                            iC = iD;
                        }
                    }
                case 9:
                    if ((i8 & i12) != 0) {
                        Object object2 = unsafe.getObject(wVar, j4);
                        b1 b1VarP = p(i11);
                        Class cls = c1.f1437a;
                        int iZ5 = l.Z(i13);
                        int iB = ((a) object2).b(b1VarP);
                        iC = a8.b.d(iB, iB, iZ5, iC);
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if ((i8 & i12) != 0) {
                        iV = l.S(i13, (i) unsafe.getObject(wVar, j4));
                        iC += iV;
                        break;
                    } else {
                        break;
                    }
                case BERTags.EMBEDDED_PDV /* 11 */:
                    if ((i8 & i12) != 0) {
                        int i17 = unsafe.getInt(wVar, j4);
                        iZ2 = l.Z(i13);
                        iX = l.a0(i17);
                        iV = iX + iZ2;
                        iC += iV;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if ((i8 & i12) != 0) {
                        int i18 = unsafe.getInt(wVar, j4);
                        iZ2 = l.Z(i13);
                        iX = l.X(i18);
                        iV = iX + iZ2;
                        iC += iV;
                        break;
                    } else {
                        break;
                    }
                case BERTags.RELATIVE_OID /* 13 */:
                    if ((i12 & i8) != 0) {
                        iC = a8.b.c(i13, 4, iC);
                        break;
                    } else {
                        break;
                    }
                case BERTags.TIME /* 14 */:
                    if ((i12 & i8) != 0) {
                        iC = a8.b.c(i13, 8, iC);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if ((i8 & i12) != 0) {
                        int i19 = unsafe.getInt(wVar, j4);
                        iZ2 = l.Z(i13);
                        iX = l.a0((i19 >> 31) ^ (i19 << 1));
                        iV = iX + iZ2;
                        iC += iV;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if ((i8 & i12) != 0) {
                        long j10 = unsafe.getLong(wVar, j4);
                        iZ = l.Z(i13);
                        iB0 = l.b0((j10 >> 63) ^ (j10 << 1));
                        iV = iB0 + iZ;
                        iC += iV;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if ((i8 & i12) != 0) {
                        iV = l.W(i13, (a) unsafe.getObject(wVar, j4), p(i11));
                        iC += iV;
                        break;
                    } else {
                        break;
                    }
                case BERTags.NUMERIC_STRING /* 18 */:
                    iV = c1.f(i13, (List) unsafe.getObject(wVar, j4));
                    iC += iV;
                    break;
                case 19:
                    iV = c1.d(i13, (List) unsafe.getObject(wVar, j4));
                    iC += iV;
                    break;
                case 20:
                    iV = c1.j(i13, (List) unsafe.getObject(wVar, j4));
                    iC += iV;
                    break;
                case BERTags.VIDEOTEX_STRING /* 21 */:
                    iV = c1.t(i13, (List) unsafe.getObject(wVar, j4));
                    iC += iV;
                    break;
                case BERTags.IA5_STRING /* 22 */:
                    iV = c1.h(i13, (List) unsafe.getObject(wVar, j4));
                    iC += iV;
                    break;
                case BERTags.UTC_TIME /* 23 */:
                    iV = c1.f(i13, (List) unsafe.getObject(wVar, j4));
                    iC += iV;
                    break;
                case 24:
                    iV = c1.d(i13, (List) unsafe.getObject(wVar, j4));
                    iC += iV;
                    break;
                case BERTags.GRAPHIC_STRING /* 25 */:
                    List list = (List) unsafe.getObject(wVar, j4);
                    Class cls2 = c1.f1437a;
                    int size2 = list.size();
                    iC += size2 == 0 ? 0 : (l.Z(i13) + 1) * size2;
                    break;
                case BERTags.VISIBLE_STRING /* 26 */:
                    iV = c1.q(i13, (List) unsafe.getObject(wVar, j4));
                    iC += iV;
                    break;
                case BERTags.GENERAL_STRING /* 27 */:
                    iV = c1.l(i13, (List) unsafe.getObject(wVar, j4), p(i11));
                    iC += iV;
                    break;
                case BERTags.UNIVERSAL_STRING /* 28 */:
                    iV = c1.a(i13, (List) unsafe.getObject(wVar, j4));
                    iC += iV;
                    break;
                case BERTags.UNRESTRICTED_STRING /* 29 */:
                    iV = c1.r(i13, (List) unsafe.getObject(wVar, j4));
                    iC += iV;
                    break;
                case 30:
                    iV = c1.b(i13, (List) unsafe.getObject(wVar, j4));
                    iC += iV;
                    break;
                case BERTags.DATE /* 31 */:
                    iV = c1.d(i13, (List) unsafe.getObject(wVar, j4));
                    iC += iV;
                    break;
                case 32:
                    iV = c1.f(i13, (List) unsafe.getObject(wVar, j4));
                    iC += iV;
                    break;
                case BERTags.DATE_TIME /* 33 */:
                    iV = c1.m(i13, (List) unsafe.getObject(wVar, j4));
                    iC += iV;
                    break;
                case BERTags.DURATION /* 34 */:
                    iV = c1.o(i13, (List) unsafe.getObject(wVar, j4));
                    iC += iV;
                    break;
                case BERTags.OBJECT_IDENTIFIER_IRI /* 35 */:
                    int iG = c1.g((List) unsafe.getObject(wVar, j4));
                    if (iG > 0) {
                        iC = a8.b.d(iG, l.Z(i13), iG, iC);
                        break;
                    } else {
                        break;
                    }
                case BERTags.RELATIVE_OID_IRI /* 36 */:
                    int iE = c1.e((List) unsafe.getObject(wVar, j4));
                    if (iE > 0) {
                        iC = a8.b.d(iE, l.Z(i13), iE, iC);
                        break;
                    } else {
                        break;
                    }
                case 37:
                    int iK = c1.k((List) unsafe.getObject(wVar, j4));
                    if (iK > 0) {
                        iC = a8.b.d(iK, l.Z(i13), iK, iC);
                        break;
                    } else {
                        break;
                    }
                case 38:
                    int iU2 = c1.u((List) unsafe.getObject(wVar, j4));
                    if (iU2 > 0) {
                        iC = a8.b.d(iU2, l.Z(i13), iU2, iC);
                        break;
                    } else {
                        break;
                    }
                case 39:
                    int i20 = c1.i((List) unsafe.getObject(wVar, j4));
                    if (i20 > 0) {
                        iC = a8.b.d(i20, l.Z(i13), i20, iC);
                        break;
                    } else {
                        break;
                    }
                case 40:
                    int iG2 = c1.g((List) unsafe.getObject(wVar, j4));
                    if (iG2 > 0) {
                        iC = a8.b.d(iG2, l.Z(i13), iG2, iC);
                        break;
                    } else {
                        break;
                    }
                case 41:
                    int iE2 = c1.e((List) unsafe.getObject(wVar, j4));
                    if (iE2 > 0) {
                        iC = a8.b.d(iE2, l.Z(i13), iE2, iC);
                        break;
                    } else {
                        break;
                    }
                case 42:
                    List list2 = (List) unsafe.getObject(wVar, j4);
                    Class cls3 = c1.f1437a;
                    int size3 = list2.size();
                    if (size3 > 0) {
                        iC = a8.b.d(size3, l.Z(i13), size3, iC);
                        break;
                    } else {
                        break;
                    }
                case 43:
                    int iS = c1.s((List) unsafe.getObject(wVar, j4));
                    if (iS > 0) {
                        iC = a8.b.d(iS, l.Z(i13), iS, iC);
                        break;
                    } else {
                        break;
                    }
                case 44:
                    int iC2 = c1.c((List) unsafe.getObject(wVar, j4));
                    if (iC2 > 0) {
                        iC = a8.b.d(iC2, l.Z(i13), iC2, iC);
                        break;
                    } else {
                        break;
                    }
                case 45:
                    int iE3 = c1.e((List) unsafe.getObject(wVar, j4));
                    if (iE3 > 0) {
                        iC = a8.b.d(iE3, l.Z(i13), iE3, iC);
                        break;
                    } else {
                        break;
                    }
                case 46:
                    int iG3 = c1.g((List) unsafe.getObject(wVar, j4));
                    if (iG3 > 0) {
                        iC = a8.b.d(iG3, l.Z(i13), iG3, iC);
                        break;
                    } else {
                        break;
                    }
                case 47:
                    int iN = c1.n((List) unsafe.getObject(wVar, j4));
                    if (iN > 0) {
                        iC = a8.b.d(iN, l.Z(i13), iN, iC);
                        break;
                    } else {
                        break;
                    }
                case 48:
                    int iP = c1.p((List) unsafe.getObject(wVar, j4));
                    if (iP > 0) {
                        iC = a8.b.d(iP, l.Z(i13), iP, iC);
                        break;
                    } else {
                        break;
                    }
                case 49:
                    List list3 = (List) unsafe.getObject(wVar, j4);
                    b1 b1VarP2 = p(i11);
                    Class cls4 = c1.f1437a;
                    int size4 = list3.size();
                    if (size4 == 0) {
                        iW = 0;
                    } else {
                        iW = 0;
                        for (int i21 = 0; i21 < size4; i21++) {
                            iW += l.W(i13, (a) list3.get(i21), b1VarP2);
                        }
                    }
                    iC += iW;
                    break;
                case 50:
                    Object object3 = unsafe.getObject(wVar, j4);
                    Object objO = o(i11);
                    this.f1530n.getClass();
                    n0.a(object3, objO);
                    break;
                case 51:
                    if (u(wVar, i13, i11)) {
                        iC = a8.b.c(i13, 8, iC);
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (u(wVar, i13, i11)) {
                        iC = a8.b.c(i13, 4, iC);
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (u(wVar, i13, i11)) {
                        long jF = F(wVar, j4);
                        iZ = l.Z(i13);
                        iB0 = l.b0(jF);
                        iV = iB0 + iZ;
                        iC += iV;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (u(wVar, i13, i11)) {
                        long jF2 = F(wVar, j4);
                        iZ = l.Z(i13);
                        iB0 = l.b0(jF2);
                        iV = iB0 + iZ;
                        iC += iV;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (u(wVar, i13, i11)) {
                        int iE4 = E(wVar, j4);
                        iZ2 = l.Z(i13);
                        iX = l.X(iE4);
                        iV = iX + iZ2;
                        iC += iV;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (u(wVar, i13, i11)) {
                        iV = l.V(i13);
                        iC += iV;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (u(wVar, i13, i11)) {
                        iV = l.U(i13);
                        iC += iV;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (u(wVar, i13, i11)) {
                        iC = a8.b.c(i13, 1, iC);
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (!u(wVar, i13, i11)) {
                        break;
                    } else {
                        Object object4 = unsafe.getObject(wVar, j4);
                        if (object4 instanceof i) {
                            int iZ6 = l.Z(i13);
                            int size5 = ((i) object4).size();
                            iD = a8.b.d(size5, size5, iZ6, iC);
                            iC = iD;
                            break;
                        } else {
                            iZ3 = l.Z(i13);
                            iY = l.Y((String) object4);
                            iD = iY + iZ3 + iC;
                            iC = iD;
                        }
                    }
                case 60:
                    if (u(wVar, i13, i11)) {
                        Object object5 = unsafe.getObject(wVar, j4);
                        b1 b1VarP3 = p(i11);
                        Class cls5 = c1.f1437a;
                        int iZ7 = l.Z(i13);
                        int iB2 = ((a) object5).b(b1VarP3);
                        iC = a8.b.d(iB2, iB2, iZ7, iC);
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (u(wVar, i13, i11)) {
                        iV = l.S(i13, (i) unsafe.getObject(wVar, j4));
                        iC += iV;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (u(wVar, i13, i11)) {
                        int iE5 = E(wVar, j4);
                        iZ2 = l.Z(i13);
                        iX = l.a0(iE5);
                        iV = iX + iZ2;
                        iC += iV;
                        break;
                    } else {
                        break;
                    }
                case SkeinParameters.PARAM_TYPE_OUTPUT /* 63 */:
                    if (u(wVar, i13, i11)) {
                        int iE6 = E(wVar, j4);
                        iZ2 = l.Z(i13);
                        iX = l.X(iE6);
                        iV = iX + iZ2;
                        iC += iV;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (u(wVar, i13, i11)) {
                        iC = a8.b.c(i13, 4, iC);
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (u(wVar, i13, i11)) {
                        iC = a8.b.c(i13, 8, iC);
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (u(wVar, i13, i11)) {
                        int iE7 = E(wVar, j4);
                        iZ2 = l.Z(i13);
                        iX = l.a0((iE7 >> 31) ^ (iE7 << 1));
                        iV = iX + iZ2;
                        iC += iV;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (u(wVar, i13, i11)) {
                        long jF3 = F(wVar, j4);
                        iZ = l.Z(i13);
                        iB0 = l.b0((jF3 >> 63) ^ (jF3 << 1));
                        iV = iB0 + iZ;
                        iC += iV;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (u(wVar, i13, i11)) {
                        iV = l.W(i13, (a) unsafe.getObject(wVar, j4), p(i11));
                        iC += iV;
                        break;
                    } else {
                        break;
                    }
            }
            i11 += 3;
            i9 = 1048575;
        }
    }

    public final int r(w wVar) {
        int iZ;
        int iB0;
        int iZ2;
        int iX;
        int iV;
        int iZ3;
        int iY;
        int iZ4;
        int iB02;
        int iW;
        Unsafe unsafe = f1517p;
        int i8 = 0;
        int iC = 0;
        while (true) {
            int[] iArr = this.f1518a;
            if (i8 >= iArr.length) {
                this.f1529m.getClass();
                return wVar.unknownFields.b() + iC;
            }
            int iV2 = V(i8);
            int iU = U(iV2);
            int i9 = iArr[i8];
            long j4 = iV2 & 1048575;
            if (iU >= r.f1511b.f1514a && iU <= r.f1512c.f1514a) {
                int i10 = iArr[i8 + 2];
            }
            switch (iU) {
                case 0:
                    if (s(i8, wVar)) {
                        iC = a8.b.c(i9, 8, iC);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (s(i8, wVar)) {
                        iC = a8.b.c(i9, 4, iC);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (s(i8, wVar)) {
                        long jH = n1.f1499c.h(wVar, j4);
                        iZ = l.Z(i9);
                        iB0 = l.b0(jH);
                        iV = iB0 + iZ;
                        iC += iV;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (s(i8, wVar)) {
                        long jH2 = n1.f1499c.h(wVar, j4);
                        iZ = l.Z(i9);
                        iB0 = l.b0(jH2);
                        iV = iB0 + iZ;
                        iC += iV;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (s(i8, wVar)) {
                        int iG = n1.f1499c.g(wVar, j4);
                        iZ2 = l.Z(i9);
                        iX = l.X(iG);
                        iV = iX + iZ2;
                        iC += iV;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (s(i8, wVar)) {
                        iV = l.V(i9);
                        iC += iV;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (s(i8, wVar)) {
                        iV = l.U(i9);
                        iC += iV;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (s(i8, wVar)) {
                        iC = a8.b.c(i9, 1, iC);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (s(i8, wVar)) {
                        Object objI = n1.f1499c.i(wVar, j4);
                        if (objI instanceof i) {
                            int iZ5 = l.Z(i9);
                            int size = ((i) objI).size();
                            iC = a8.b.d(size, size, iZ5, iC);
                            break;
                        } else {
                            iZ3 = l.Z(i9);
                            iY = l.Y((String) objI);
                            iC = iY + iZ3 + iC;
                            break;
                        }
                    } else {
                        break;
                    }
                case 9:
                    if (s(i8, wVar)) {
                        Object objI2 = n1.f1499c.i(wVar, j4);
                        b1 b1VarP = p(i8);
                        Class cls = c1.f1437a;
                        int iZ6 = l.Z(i9);
                        int iB = ((a) objI2).b(b1VarP);
                        iC = a8.b.d(iB, iB, iZ6, iC);
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (s(i8, wVar)) {
                        iV = l.S(i9, (i) n1.f1499c.i(wVar, j4));
                        iC += iV;
                        break;
                    } else {
                        break;
                    }
                case BERTags.EMBEDDED_PDV /* 11 */:
                    if (s(i8, wVar)) {
                        int iG2 = n1.f1499c.g(wVar, j4);
                        iZ2 = l.Z(i9);
                        iX = l.a0(iG2);
                        iV = iX + iZ2;
                        iC += iV;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (s(i8, wVar)) {
                        int iG3 = n1.f1499c.g(wVar, j4);
                        iZ2 = l.Z(i9);
                        iX = l.X(iG3);
                        iV = iX + iZ2;
                        iC += iV;
                        break;
                    } else {
                        break;
                    }
                case BERTags.RELATIVE_OID /* 13 */:
                    if (s(i8, wVar)) {
                        iC = a8.b.c(i9, 4, iC);
                        break;
                    } else {
                        break;
                    }
                case BERTags.TIME /* 14 */:
                    if (s(i8, wVar)) {
                        iC = a8.b.c(i9, 8, iC);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (s(i8, wVar)) {
                        int iG4 = n1.f1499c.g(wVar, j4);
                        iZ2 = l.Z(i9);
                        iX = l.a0((iG4 >> 31) ^ (iG4 << 1));
                        iV = iX + iZ2;
                        iC += iV;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (s(i8, wVar)) {
                        long jH3 = n1.f1499c.h(wVar, j4);
                        iZ4 = l.Z(i9);
                        iB02 = l.b0((jH3 >> 63) ^ (jH3 << 1));
                        iV = iB02 + iZ4;
                        iC += iV;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (s(i8, wVar)) {
                        iV = l.W(i9, (a) n1.f1499c.i(wVar, j4), p(i8));
                        iC += iV;
                        break;
                    } else {
                        break;
                    }
                case BERTags.NUMERIC_STRING /* 18 */:
                    iV = c1.f(i9, v(wVar, j4));
                    iC += iV;
                    break;
                case 19:
                    iV = c1.d(i9, v(wVar, j4));
                    iC += iV;
                    break;
                case 20:
                    iV = c1.j(i9, v(wVar, j4));
                    iC += iV;
                    break;
                case BERTags.VIDEOTEX_STRING /* 21 */:
                    iV = c1.t(i9, v(wVar, j4));
                    iC += iV;
                    break;
                case BERTags.IA5_STRING /* 22 */:
                    iV = c1.h(i9, v(wVar, j4));
                    iC += iV;
                    break;
                case BERTags.UTC_TIME /* 23 */:
                    iV = c1.f(i9, v(wVar, j4));
                    iC += iV;
                    break;
                case 24:
                    iV = c1.d(i9, v(wVar, j4));
                    iC += iV;
                    break;
                case BERTags.GRAPHIC_STRING /* 25 */:
                    List listV = v(wVar, j4);
                    Class cls2 = c1.f1437a;
                    int size2 = listV.size();
                    iC += size2 == 0 ? 0 : (l.Z(i9) + 1) * size2;
                    break;
                case BERTags.VISIBLE_STRING /* 26 */:
                    iV = c1.q(i9, v(wVar, j4));
                    iC += iV;
                    break;
                case BERTags.GENERAL_STRING /* 27 */:
                    iV = c1.l(i9, v(wVar, j4), p(i8));
                    iC += iV;
                    break;
                case BERTags.UNIVERSAL_STRING /* 28 */:
                    iV = c1.a(i9, v(wVar, j4));
                    iC += iV;
                    break;
                case BERTags.UNRESTRICTED_STRING /* 29 */:
                    iV = c1.r(i9, v(wVar, j4));
                    iC += iV;
                    break;
                case 30:
                    iV = c1.b(i9, v(wVar, j4));
                    iC += iV;
                    break;
                case BERTags.DATE /* 31 */:
                    iV = c1.d(i9, v(wVar, j4));
                    iC += iV;
                    break;
                case 32:
                    iV = c1.f(i9, v(wVar, j4));
                    iC += iV;
                    break;
                case BERTags.DATE_TIME /* 33 */:
                    iV = c1.m(i9, v(wVar, j4));
                    iC += iV;
                    break;
                case BERTags.DURATION /* 34 */:
                    iV = c1.o(i9, v(wVar, j4));
                    iC += iV;
                    break;
                case BERTags.OBJECT_IDENTIFIER_IRI /* 35 */:
                    int iG5 = c1.g((List) unsafe.getObject(wVar, j4));
                    if (iG5 > 0) {
                        iC = a8.b.d(iG5, l.Z(i9), iG5, iC);
                        break;
                    } else {
                        break;
                    }
                case BERTags.RELATIVE_OID_IRI /* 36 */:
                    int iE = c1.e((List) unsafe.getObject(wVar, j4));
                    if (iE > 0) {
                        iC = a8.b.d(iE, l.Z(i9), iE, iC);
                        break;
                    } else {
                        break;
                    }
                case 37:
                    int iK = c1.k((List) unsafe.getObject(wVar, j4));
                    if (iK > 0) {
                        iC = a8.b.d(iK, l.Z(i9), iK, iC);
                        break;
                    } else {
                        break;
                    }
                case 38:
                    int iU2 = c1.u((List) unsafe.getObject(wVar, j4));
                    if (iU2 > 0) {
                        iC = a8.b.d(iU2, l.Z(i9), iU2, iC);
                        break;
                    } else {
                        break;
                    }
                case 39:
                    int i11 = c1.i((List) unsafe.getObject(wVar, j4));
                    if (i11 > 0) {
                        iC = a8.b.d(i11, l.Z(i9), i11, iC);
                        break;
                    } else {
                        break;
                    }
                case 40:
                    int iG6 = c1.g((List) unsafe.getObject(wVar, j4));
                    if (iG6 > 0) {
                        iC = a8.b.d(iG6, l.Z(i9), iG6, iC);
                        break;
                    } else {
                        break;
                    }
                case 41:
                    int iE2 = c1.e((List) unsafe.getObject(wVar, j4));
                    if (iE2 > 0) {
                        iC = a8.b.d(iE2, l.Z(i9), iE2, iC);
                        break;
                    } else {
                        break;
                    }
                case 42:
                    List list = (List) unsafe.getObject(wVar, j4);
                    Class cls3 = c1.f1437a;
                    int size3 = list.size();
                    if (size3 > 0) {
                        iC = a8.b.d(size3, l.Z(i9), size3, iC);
                        break;
                    } else {
                        break;
                    }
                case 43:
                    int iS = c1.s((List) unsafe.getObject(wVar, j4));
                    if (iS > 0) {
                        iC = a8.b.d(iS, l.Z(i9), iS, iC);
                        break;
                    } else {
                        break;
                    }
                case 44:
                    int iC2 = c1.c((List) unsafe.getObject(wVar, j4));
                    if (iC2 > 0) {
                        iC = a8.b.d(iC2, l.Z(i9), iC2, iC);
                        break;
                    } else {
                        break;
                    }
                case 45:
                    int iE3 = c1.e((List) unsafe.getObject(wVar, j4));
                    if (iE3 > 0) {
                        iC = a8.b.d(iE3, l.Z(i9), iE3, iC);
                        break;
                    } else {
                        break;
                    }
                case 46:
                    int iG7 = c1.g((List) unsafe.getObject(wVar, j4));
                    if (iG7 > 0) {
                        iC = a8.b.d(iG7, l.Z(i9), iG7, iC);
                        break;
                    } else {
                        break;
                    }
                case 47:
                    int iN = c1.n((List) unsafe.getObject(wVar, j4));
                    if (iN > 0) {
                        iC = a8.b.d(iN, l.Z(i9), iN, iC);
                        break;
                    } else {
                        break;
                    }
                case 48:
                    int iP = c1.p((List) unsafe.getObject(wVar, j4));
                    if (iP > 0) {
                        iC = a8.b.d(iP, l.Z(i9), iP, iC);
                        break;
                    } else {
                        break;
                    }
                case 49:
                    List listV2 = v(wVar, j4);
                    b1 b1VarP2 = p(i8);
                    Class cls4 = c1.f1437a;
                    int size4 = listV2.size();
                    if (size4 == 0) {
                        iW = 0;
                    } else {
                        iW = 0;
                        for (int i12 = 0; i12 < size4; i12++) {
                            iW += l.W(i9, (a) listV2.get(i12), b1VarP2);
                        }
                    }
                    iC += iW;
                    break;
                case 50:
                    Object objI3 = n1.f1499c.i(wVar, j4);
                    Object objO = o(i8);
                    this.f1530n.getClass();
                    n0.a(objI3, objO);
                    break;
                case 51:
                    if (u(wVar, i9, i8)) {
                        iC = a8.b.c(i9, 8, iC);
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (u(wVar, i9, i8)) {
                        iC = a8.b.c(i9, 4, iC);
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (u(wVar, i9, i8)) {
                        long jF = F(wVar, j4);
                        iZ = l.Z(i9);
                        iB0 = l.b0(jF);
                        iV = iB0 + iZ;
                        iC += iV;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (u(wVar, i9, i8)) {
                        long jF2 = F(wVar, j4);
                        iZ = l.Z(i9);
                        iB0 = l.b0(jF2);
                        iV = iB0 + iZ;
                        iC += iV;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (u(wVar, i9, i8)) {
                        int iE4 = E(wVar, j4);
                        iZ2 = l.Z(i9);
                        iX = l.X(iE4);
                        iV = iX + iZ2;
                        iC += iV;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (u(wVar, i9, i8)) {
                        iV = l.V(i9);
                        iC += iV;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (u(wVar, i9, i8)) {
                        iV = l.U(i9);
                        iC += iV;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (u(wVar, i9, i8)) {
                        iC = a8.b.c(i9, 1, iC);
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (u(wVar, i9, i8)) {
                        Object objI4 = n1.f1499c.i(wVar, j4);
                        if (objI4 instanceof i) {
                            int iZ7 = l.Z(i9);
                            int size5 = ((i) objI4).size();
                            iC = a8.b.d(size5, size5, iZ7, iC);
                            break;
                        } else {
                            iZ3 = l.Z(i9);
                            iY = l.Y((String) objI4);
                            iC = iY + iZ3 + iC;
                            break;
                        }
                    } else {
                        break;
                    }
                case 60:
                    if (u(wVar, i9, i8)) {
                        Object objI5 = n1.f1499c.i(wVar, j4);
                        b1 b1VarP3 = p(i8);
                        Class cls5 = c1.f1437a;
                        int iZ8 = l.Z(i9);
                        int iB2 = ((a) objI5).b(b1VarP3);
                        iC = a8.b.d(iB2, iB2, iZ8, iC);
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (u(wVar, i9, i8)) {
                        iV = l.S(i9, (i) n1.f1499c.i(wVar, j4));
                        iC += iV;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (u(wVar, i9, i8)) {
                        int iE5 = E(wVar, j4);
                        iZ2 = l.Z(i9);
                        iX = l.a0(iE5);
                        iV = iX + iZ2;
                        iC += iV;
                        break;
                    } else {
                        break;
                    }
                case SkeinParameters.PARAM_TYPE_OUTPUT /* 63 */:
                    if (u(wVar, i9, i8)) {
                        int iE6 = E(wVar, j4);
                        iZ2 = l.Z(i9);
                        iX = l.X(iE6);
                        iV = iX + iZ2;
                        iC += iV;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (u(wVar, i9, i8)) {
                        iC = a8.b.c(i9, 4, iC);
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (u(wVar, i9, i8)) {
                        iC = a8.b.c(i9, 8, iC);
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (u(wVar, i9, i8)) {
                        int iE7 = E(wVar, j4);
                        iZ2 = l.Z(i9);
                        iX = l.a0((iE7 >> 31) ^ (iE7 << 1));
                        iV = iX + iZ2;
                        iC += iV;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (u(wVar, i9, i8)) {
                        long jF3 = F(wVar, j4);
                        iZ4 = l.Z(i9);
                        iB02 = l.b0((jF3 >> 63) ^ (jF3 << 1));
                        iV = iB02 + iZ4;
                        iC += iV;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (u(wVar, i9, i8)) {
                        iV = l.W(i9, (a) n1.f1499c.i(wVar, j4), p(i8));
                        iC += iV;
                        break;
                    } else {
                        break;
                    }
            }
            i8 += 3;
        }
    }

    public final boolean s(int i8, Object obj) {
        int i9 = this.f1518a[i8 + 2];
        long j4 = i9 & 1048575;
        if (j4 == 1048575) {
            int iV = V(i8);
            long j8 = iV & 1048575;
            switch (U(iV)) {
                case 0:
                    if (Double.doubleToRawLongBits(n1.f1499c.e(obj, j8)) == 0) {
                        return false;
                    }
                    break;
                case 1:
                    if (Float.floatToRawIntBits(n1.f1499c.f(obj, j8)) == 0) {
                        return false;
                    }
                    break;
                case 2:
                    if (n1.f1499c.h(obj, j8) == 0) {
                        return false;
                    }
                    break;
                case 3:
                    if (n1.f1499c.h(obj, j8) == 0) {
                        return false;
                    }
                    break;
                case 4:
                    if (n1.f1499c.g(obj, j8) == 0) {
                        return false;
                    }
                    break;
                case 5:
                    if (n1.f1499c.h(obj, j8) == 0) {
                        return false;
                    }
                    break;
                case 6:
                    if (n1.f1499c.g(obj, j8) == 0) {
                        return false;
                    }
                    break;
                case 7:
                    return n1.f1499c.c(obj, j8);
                case 8:
                    Object objI = n1.f1499c.i(obj, j8);
                    if (objI instanceof String) {
                        return !((String) objI).isEmpty();
                    }
                    if (objI instanceof i) {
                        return !i.f1465b.equals(objI);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    if (n1.f1499c.i(obj, j8) == null) {
                        return false;
                    }
                    break;
                case 10:
                    return !i.f1465b.equals(n1.f1499c.i(obj, j8));
                case BERTags.EMBEDDED_PDV /* 11 */:
                    if (n1.f1499c.g(obj, j8) == 0) {
                        return false;
                    }
                    break;
                case 12:
                    if (n1.f1499c.g(obj, j8) == 0) {
                        return false;
                    }
                    break;
                case BERTags.RELATIVE_OID /* 13 */:
                    if (n1.f1499c.g(obj, j8) == 0) {
                        return false;
                    }
                    break;
                case BERTags.TIME /* 14 */:
                    if (n1.f1499c.h(obj, j8) == 0) {
                        return false;
                    }
                    break;
                case 15:
                    if (n1.f1499c.g(obj, j8) == 0) {
                        return false;
                    }
                    break;
                case 16:
                    if (n1.f1499c.h(obj, j8) == 0) {
                        return false;
                    }
                    break;
                case 17:
                    if (n1.f1499c.i(obj, j8) == null) {
                        return false;
                    }
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        } else if (((1 << (i9 >>> 20)) & n1.f1499c.g(obj, j4)) == 0) {
            return false;
        }
        return true;
    }

    public final boolean u(Object obj, int i8, int i9) {
        return n1.f1499c.g(obj, (long) (this.f1518a[i9 + 2] & 1048575)) == i8;
    }

    public final void w(Object obj, int i8, Object obj2) {
        long jV = V(i8) & 1048575;
        Object objI = n1.f1499c.i(obj, jV);
        n0 n0Var = this.f1530n;
        if (objI != null) {
            n0Var.getClass();
            if (!((m0) objI).f1494a) {
                m0 m0VarC = m0.f1493b.c();
                n0.b(m0VarC, objI);
                n1.p(jV, obj, m0VarC);
                objI = m0VarC;
            }
        } else {
            n0Var.getClass();
            objI = m0.f1493b.c();
            n1.p(jV, obj, objI);
        }
        n0Var.getClass();
        a8.b.x(obj2);
        throw null;
    }

    public final void x(Object obj, int i8, Object obj2) {
        if (s(i8, obj2)) {
            long jV = V(i8) & 1048575;
            Unsafe unsafe = f1517p;
            Object object = unsafe.getObject(obj2, jV);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.f1518a[i8] + " is present but null: " + obj2);
            }
            b1 b1VarP = p(i8);
            if (!s(i8, obj)) {
                if (t(object)) {
                    Object objD = b1VarP.d();
                    b1VarP.a(objD, object);
                    unsafe.putObject(obj, jV, objD);
                } else {
                    unsafe.putObject(obj, jV, object);
                }
                P(i8, obj);
                return;
            }
            Object object2 = unsafe.getObject(obj, jV);
            if (!t(object2)) {
                Object objD2 = b1VarP.d();
                b1VarP.a(objD2, object2);
                unsafe.putObject(obj, jV, objD2);
                object2 = objD2;
            }
            b1VarP.a(object2, object);
        }
    }

    public final void y(Object obj, int i8, Object obj2) {
        int[] iArr = this.f1518a;
        int i9 = iArr[i8];
        if (u(obj2, i9, i8)) {
            long jV = V(i8) & 1048575;
            Unsafe unsafe = f1517p;
            Object object = unsafe.getObject(obj2, jV);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + iArr[i8] + " is present but null: " + obj2);
            }
            b1 b1VarP = p(i8);
            if (!u(obj, i9, i8)) {
                if (t(object)) {
                    Object objD = b1VarP.d();
                    b1VarP.a(objD, object);
                    unsafe.putObject(obj, jV, objD);
                } else {
                    unsafe.putObject(obj, jV, object);
                }
                Q(obj, i9, i8);
                return;
            }
            Object object2 = unsafe.getObject(obj, jV);
            if (!t(object2)) {
                Object objD2 = b1VarP.d();
                b1VarP.a(objD2, object2);
                unsafe.putObject(obj, jV, objD2);
                object2 = objD2;
            }
            b1VarP.a(object2, object);
        }
    }

    public final Object z(int i8, Object obj) {
        b1 b1VarP = p(i8);
        long jV = V(i8) & 1048575;
        if (!s(i8, obj)) {
            return b1VarP.d();
        }
        Object object = f1517p.getObject(obj, jV);
        if (t(object)) {
            return object;
        }
        Object objD = b1VarP.d();
        if (object != null) {
            b1VarP.a(objD, object);
        }
        return objD;
    }
}
