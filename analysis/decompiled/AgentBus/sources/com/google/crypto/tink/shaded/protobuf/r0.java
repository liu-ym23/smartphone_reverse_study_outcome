package com.google.crypto.tink.shaded.protobuf;

import com.google.protobuf.q2;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import sun.misc.Unsafe;

/* loaded from: classes.dex */
public final class r0 implements a1 {

    /* renamed from: o, reason: collision with root package name */
    public static final int[] f2265o = new int[0];

    /* renamed from: p, reason: collision with root package name */
    public static final Unsafe f2266p = m1.j();

    /* renamed from: a, reason: collision with root package name */
    public final int[] f2267a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f2268b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2269c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2270d;

    /* renamed from: e, reason: collision with root package name */
    public final a f2271e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f2272f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f2273g;

    /* renamed from: h, reason: collision with root package name */
    public final int[] f2274h;

    /* renamed from: i, reason: collision with root package name */
    public final int f2275i;

    /* renamed from: j, reason: collision with root package name */
    public final int f2276j;

    /* renamed from: k, reason: collision with root package name */
    public final t0 f2277k;

    /* renamed from: l, reason: collision with root package name */
    public final h0 f2278l;

    /* renamed from: m, reason: collision with root package name */
    public final e1 f2279m;

    /* renamed from: n, reason: collision with root package name */
    public final m0 f2280n;

    public r0(int[] iArr, Object[] objArr, int i2, int i10, a aVar, boolean z4, int[] iArr2, int i11, int i12, t0 t0Var, h0 h0Var, e1 e1Var, o oVar, m0 m0Var) {
        this.f2267a = iArr;
        this.f2268b = objArr;
        this.f2269c = i2;
        this.f2270d = i10;
        this.f2272f = aVar instanceof v;
        this.f2273g = z4;
        this.f2274h = iArr2;
        this.f2275i = i11;
        this.f2276j = i12;
        this.f2277k = t0Var;
        this.f2278l = h0Var;
        this.f2279m = e1Var;
        this.f2271e = aVar;
        this.f2280n = m0Var;
    }

    public static r0 B(z0 z0Var, t0 t0Var, h0 h0Var, e1 e1Var, o oVar, m0 m0Var) {
        if (z0Var instanceof z0) {
            return C(z0Var, t0Var, h0Var, e1Var, oVar, m0Var);
        }
        z0Var.getClass();
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
    public static com.google.crypto.tink.shaded.protobuf.r0 C(com.google.crypto.tink.shaded.protobuf.z0 r34, com.google.crypto.tink.shaded.protobuf.t0 r35, com.google.crypto.tink.shaded.protobuf.h0 r36, com.google.crypto.tink.shaded.protobuf.e1 r37, com.google.crypto.tink.shaded.protobuf.o r38, com.google.crypto.tink.shaded.protobuf.m0 r39) {
        /*
            Method dump skipped, instructions count: 986
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.r0.C(com.google.crypto.tink.shaded.protobuf.z0, com.google.crypto.tink.shaded.protobuf.t0, com.google.crypto.tink.shaded.protobuf.h0, com.google.crypto.tink.shaded.protobuf.e1, com.google.crypto.tink.shaded.protobuf.o, com.google.crypto.tink.shaded.protobuf.m0):com.google.crypto.tink.shaded.protobuf.r0");
    }

    public static long D(int i2) {
        return i2 & 1048575;
    }

    public static int E(long j2, Object obj) {
        return ((Integer) m1.f2246c.i(j2, obj)).intValue();
    }

    public static long F(long j2, Object obj) {
        return ((Long) m1.f2246c.i(j2, obj)).longValue();
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

    public static int U(int i2) {
        return (i2 & 267386880) >>> 20;
    }

    public static void X(int i2, Object obj, k0 k0Var) throws androidx.datastore.preferences.protobuf.l {
        if (!(obj instanceof String)) {
            k0Var.a(i2, (h) obj);
            return;
        }
        String str = (String) obj;
        k kVar = (k) k0Var.f2239a;
        kVar.h0(i2, 2);
        int i10 = kVar.f2236c;
        byte[] bArr = kVar.f2235b;
        int i11 = kVar.f2237d;
        try {
            int iY = k.Y(str.length() * 3);
            int iY2 = k.Y(str.length());
            if (iY2 != iY) {
                kVar.i0(p1.b(str));
                int i12 = kVar.f2237d;
                kVar.f2237d = p1.f2258a.r(i12, i10 - i12, str, bArr);
                return;
            }
            int i13 = i11 + iY2;
            kVar.f2237d = i13;
            int iR = p1.f2258a.r(i13, i10 - i13, str, bArr);
            kVar.f2237d = i11;
            kVar.i0((iR - i11) - iY2);
            kVar.f2237d = iR;
        } catch (o1 e10) {
            kVar.f2237d = i11;
            k.f2232e.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) e10);
            byte[] bytes = str.getBytes(z.f2296a);
            try {
                kVar.i0(bytes.length);
                kVar.b0(bytes, 0, bytes.length);
            } catch (IndexOutOfBoundsException e11) {
                throw new androidx.datastore.preferences.protobuf.l(e11);
            }
        } catch (IndexOutOfBoundsException e12) {
            throw new androidx.datastore.preferences.protobuf.l(e12);
        }
    }

    public static void l(Object obj) {
        if (t(obj)) {
            return;
        }
        throw new IllegalArgumentException("Mutating immutable message: " + obj);
    }

    public static boolean t(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof v) {
            return ((v) obj).m();
        }
        return true;
    }

    public static List v(v vVar, long j2) {
        return (List) m1.f2246c.i(j2, vVar);
    }

    public final Object A(int i2, int i10, Object obj) {
        a1 a1VarP = p(i10);
        if (!u(i2, i10, obj)) {
            return a1VarP.d();
        }
        Object object = f2266p.getObject(obj, V(i10) & 1048575);
        if (t(object)) {
            return object;
        }
        Object objD = a1VarP.d();
        if (object != null) {
            a1VarP.a(objD, object);
        }
        return objD;
    }

    public final void G(int i2, long j2, Object obj) {
        Unsafe unsafe = f2266p;
        Object objO = o(i2);
        Object object = unsafe.getObject(obj, j2);
        this.f2280n.getClass();
        if (!((l0) object).f2241f) {
            l0 l0VarC = l0.f2240g.c();
            m0.b(l0VarC, object);
            unsafe.putObject(obj, j2, l0VarC);
        }
        a1.a.t(objO);
        throw null;
    }

    public final int H(Object obj, byte[] bArr, int i2, int i10, int i11, int i12, int i13, int i14, int i15, long j2, int i16, a7.e eVar) throws b0 {
        int i17;
        Unsafe unsafe = f2266p;
        long j4 = this.f2267a[i16 + 2] & 1048575;
        switch (i15) {
            case 51:
                if (i13 != 1) {
                    return i2;
                }
                unsafe.putObject(obj, j2, Double.valueOf(Double.longBitsToDouble(a.a.t(i2, bArr))));
                int i18 = i2 + 8;
                unsafe.putInt(obj, j4, i12);
                return i18;
            case 52:
                if (i13 != 5) {
                    return i2;
                }
                unsafe.putObject(obj, j2, Float.valueOf(Float.intBitsToFloat(a.a.r(i2, bArr))));
                int i19 = i2 + 4;
                unsafe.putInt(obj, j4, i12);
                return i19;
            case 53:
            case 54:
                if (i13 != 0) {
                    return i2;
                }
                int iH = a.a.H(bArr, i2, eVar);
                unsafe.putObject(obj, j2, Long.valueOf(eVar.f414c));
                unsafe.putInt(obj, j4, i12);
                return iH;
            case 55:
            case 62:
                if (i13 != 0) {
                    return i2;
                }
                int iD = a.a.D(bArr, i2, eVar);
                unsafe.putObject(obj, j2, Integer.valueOf(eVar.f413b));
                unsafe.putInt(obj, j4, i12);
                return iD;
            case 56:
            case 65:
                if (i13 != 1) {
                    return i2;
                }
                unsafe.putObject(obj, j2, Long.valueOf(a.a.t(i2, bArr)));
                int i20 = i2 + 8;
                unsafe.putInt(obj, j4, i12);
                return i20;
            case 57:
            case 64:
                if (i13 != 5) {
                    return i2;
                }
                unsafe.putObject(obj, j2, Integer.valueOf(a.a.r(i2, bArr)));
                int i21 = i2 + 4;
                unsafe.putInt(obj, j4, i12);
                return i21;
            case 58:
                if (i13 != 0) {
                    return i2;
                }
                int iH2 = a.a.H(bArr, i2, eVar);
                unsafe.putObject(obj, j2, Boolean.valueOf(eVar.f414c != 0));
                unsafe.putInt(obj, j4, i12);
                return iH2;
            case 59:
                if (i13 != 2) {
                    return i2;
                }
                int iD2 = a.a.D(bArr, i2, eVar);
                int i22 = eVar.f413b;
                if (i22 == 0) {
                    unsafe.putObject(obj, j2, "");
                } else {
                    if ((i14 & 536870912) != 0) {
                        if (!p1.f2258a.G(bArr, iD2, iD2 + i22)) {
                            throw b0.b();
                        }
                    }
                    unsafe.putObject(obj, j2, new String(bArr, iD2, i22, z.f2296a));
                    iD2 += i22;
                }
                unsafe.putInt(obj, j4, i12);
                return iD2;
            case 60:
                i17 = i2;
                if (i13 == 2) {
                    Object objA = A(i12, i16, obj);
                    int iX = a.a.X(objA, p(i16), bArr, i17, i10, eVar);
                    T(i12, i16, obj, objA);
                    return iX;
                }
                return i17;
            case 61:
                i17 = i2;
                if (i13 == 2) {
                    int iP = a.a.p(bArr, i17, eVar);
                    unsafe.putObject(obj, j2, eVar.f415d);
                    unsafe.putInt(obj, j4, i12);
                    return iP;
                }
                return i17;
            case 63:
                i17 = i2;
                if (i13 == 0) {
                    int iD3 = a.a.D(bArr, i17, eVar);
                    int i23 = eVar.f413b;
                    n(i16);
                    unsafe.putObject(obj, j2, Integer.valueOf(i23));
                    unsafe.putInt(obj, j4, i12);
                    return iD3;
                }
                return i17;
            case 66:
                i17 = i2;
                if (i13 == 0) {
                    int iD4 = a.a.D(bArr, i17, eVar);
                    unsafe.putObject(obj, j2, Integer.valueOf(androidx.datastore.preferences.protobuf.j.d(eVar.f413b)));
                    unsafe.putInt(obj, j4, i12);
                    return iD4;
                }
                return i17;
            case 67:
                i17 = i2;
                if (i13 == 0) {
                    int iH3 = a.a.H(bArr, i17, eVar);
                    unsafe.putObject(obj, j2, Long.valueOf(androidx.datastore.preferences.protobuf.j.e(eVar.f414c)));
                    unsafe.putInt(obj, j4, i12);
                    return iH3;
                }
                return i17;
            case 68:
                if (i13 == 3) {
                    Object objA2 = A(i12, i16, obj);
                    int I = ((r0) p(i16)).I(objA2, bArr, i2, i10, (i11 & (-8)) | 4, eVar);
                    eVar.f415d = objA2;
                    T(i12, i16, obj, objA2);
                    return I;
                }
            default:
                return i2;
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
    public final int I(java.lang.Object r30, byte[] r31, int r32, int r33, int r34, a7.e r35) throws com.google.crypto.tink.shaded.protobuf.b0 {
        /*
            Method dump skipped, instructions count: 1216
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.r0.I(java.lang.Object, byte[], int, int, int, a7.e):int");
    }

    public final void J(Object obj, byte[] bArr, int i2, int i10, a7.e eVar) throws b0 {
        int i11;
        int iR;
        Object obj2;
        int i12;
        Unsafe unsafe;
        int i13;
        int i14;
        int i15;
        int i16;
        char c10;
        Unsafe unsafe2;
        Object obj3;
        byte[] bArr2;
        int i17;
        byte[] bArr3;
        Object obj4;
        byte[] bArr4;
        Unsafe unsafe3;
        int i18;
        Object obj5;
        Object obj6;
        int i19;
        int i20;
        int i21;
        r0 r0Var = this;
        Object obj7 = obj;
        byte[] bArr5 = bArr;
        int i22 = i10;
        a7.e eVar2 = eVar;
        l(obj7);
        Unsafe unsafe4 = f2266p;
        int iH = i2;
        int i23 = -1;
        int i24 = 0;
        int i25 = 1048575;
        int i26 = 0;
        while (iH < i22) {
            int iB = iH + 1;
            int i27 = bArr5[iH];
            if (i27 < 0) {
                iB = a.a.B(i27, bArr5, iB, eVar2);
                i27 = eVar2.f413b;
            }
            int i28 = i27 >>> 3;
            int i29 = i27 & 7;
            int i30 = r0Var.f2270d;
            int i31 = r0Var.f2269c;
            if (i28 > i23) {
                iR = (i28 < i31 || i28 > i30) ? -1 : r0Var.R(i28, i24 / 3);
                i11 = 0;
            } else if (i28 < i31 || i28 > i30) {
                i11 = 0;
                iR = -1;
            } else {
                i11 = 0;
                iR = r0Var.R(i28, 0);
            }
            int i32 = iR;
            if (i32 == -1) {
                int i33 = iB;
                obj2 = obj7;
                i12 = i33;
                unsafe = unsafe4;
                i13 = i27;
                i14 = i28;
                i15 = i11;
            } else {
                int[] iArr = r0Var.f2267a;
                int i34 = iArr[i32 + 1];
                int iU = U(i34);
                int i35 = i27;
                long j2 = i34 & 1048575;
                if (iU <= 17) {
                    int i36 = iArr[i32 + 2];
                    int i37 = 1 << (i36 >>> 20);
                    int i38 = i36 & 1048575;
                    if (i38 != i25) {
                        int i39 = 1048575;
                        i16 = i34;
                        if (i25 != 1048575) {
                            unsafe4.putInt(obj7, i25, i26);
                            i39 = 1048575;
                        }
                        if (i38 != i39) {
                            i26 = unsafe4.getInt(obj7, i38);
                        }
                        i25 = i38;
                    } else {
                        i16 = i34;
                    }
                    switch (iU) {
                        case 0:
                            unsafe2 = unsafe4;
                            bArr2 = bArr5;
                            c10 = 65535;
                            i17 = iB;
                            if (i29 != 1) {
                                obj3 = obj7;
                                i13 = i35;
                                obj2 = obj3;
                                i12 = i17;
                                unsafe = unsafe2;
                                i14 = i28;
                                i15 = i32;
                                break;
                            } else {
                                m1.f2246c.m(obj7, j2, Double.longBitsToDouble(a.a.t(i17, bArr2)));
                                iH = i17 + 8;
                                i26 |= i37;
                                bArr5 = bArr2;
                                i24 = i32;
                                i23 = i28;
                                unsafe4 = unsafe2;
                                i22 = i10;
                                break;
                            }
                        case 1:
                            unsafe2 = unsafe4;
                            bArr2 = bArr5;
                            c10 = 65535;
                            i17 = iB;
                            if (i29 != 5) {
                                obj3 = obj7;
                                i13 = i35;
                                obj2 = obj3;
                                i12 = i17;
                                unsafe = unsafe2;
                                i14 = i28;
                                i15 = i32;
                                break;
                            } else {
                                m1.f2246c.n(obj7, j2, Float.intBitsToFloat(a.a.r(i17, bArr2)));
                                iH = i17 + 4;
                                i26 |= i37;
                                bArr5 = bArr2;
                                i24 = i32;
                                i23 = i28;
                                unsafe4 = unsafe2;
                                i22 = i10;
                                break;
                            }
                        case 2:
                        case 3:
                            bArr3 = bArr5;
                            c10 = 65535;
                            i17 = iB;
                            if (i29 != 0) {
                                unsafe2 = unsafe4;
                                obj3 = obj7;
                                i13 = i35;
                                obj2 = obj3;
                                i12 = i17;
                                unsafe = unsafe2;
                                i14 = i28;
                                i15 = i32;
                                break;
                            } else {
                                int iH2 = a.a.H(bArr3, i17, eVar2);
                                unsafe4.putLong(obj7, j2, eVar2.f414c);
                                i26 |= i37;
                                iH = iH2;
                                bArr5 = bArr3;
                                i24 = i32;
                                i23 = i28;
                                i22 = i10;
                                break;
                            }
                        case 4:
                        case 11:
                            bArr3 = bArr5;
                            c10 = 65535;
                            i17 = iB;
                            if (i29 != 0) {
                                unsafe2 = unsafe4;
                                obj3 = obj7;
                                i13 = i35;
                                obj2 = obj3;
                                i12 = i17;
                                unsafe = unsafe2;
                                i14 = i28;
                                i15 = i32;
                                break;
                            } else {
                                int iD = a.a.D(bArr3, i17, eVar2);
                                unsafe4.putInt(obj7, j2, eVar2.f413b);
                                i26 |= i37;
                                iH = iD;
                                bArr5 = bArr3;
                                i24 = i32;
                                i23 = i28;
                                i22 = i10;
                                break;
                            }
                        case 5:
                        case com.google.protobuf.y0.EDITION_FIELD_NUMBER /* 14 */:
                            Object obj8 = obj7;
                            bArr3 = bArr5;
                            c10 = 65535;
                            Unsafe unsafe5 = unsafe4;
                            int i40 = iB;
                            if (i29 != 1) {
                                i17 = i40;
                                unsafe2 = unsafe5;
                                obj3 = obj8;
                                i13 = i35;
                                obj2 = obj3;
                                i12 = i17;
                                unsafe = unsafe2;
                                i14 = i28;
                                i15 = i32;
                                break;
                            } else {
                                long jT = a.a.t(i40, bArr3);
                                unsafe4 = unsafe5;
                                obj7 = obj8;
                                unsafe4.putLong(obj7, j2, jT);
                                iH = i40 + 8;
                                i26 |= i37;
                                bArr5 = bArr3;
                                i24 = i32;
                                i23 = i28;
                                i22 = i10;
                                break;
                            }
                        case 6:
                        case 13:
                            obj4 = obj7;
                            bArr4 = bArr5;
                            c10 = 65535;
                            unsafe3 = unsafe4;
                            i18 = iB;
                            if (i29 != 5) {
                                Unsafe unsafe6 = unsafe3;
                                i17 = i18;
                                obj3 = obj4;
                                unsafe2 = unsafe6;
                                i13 = i35;
                                obj2 = obj3;
                                i12 = i17;
                                unsafe = unsafe2;
                                i14 = i28;
                                i15 = i32;
                                break;
                            } else {
                                unsafe3.putInt(obj4, j2, a.a.r(i18, bArr4));
                                iH = i18 + 4;
                                i26 |= i37;
                                unsafe4 = unsafe3;
                                bArr5 = bArr4;
                                i24 = i32;
                                i23 = i28;
                                obj7 = obj4;
                                i22 = i10;
                                break;
                            }
                        case 7:
                            obj4 = obj7;
                            bArr4 = bArr5;
                            c10 = 65535;
                            unsafe3 = unsafe4;
                            i18 = iB;
                            if (i29 != 0) {
                                Unsafe unsafe62 = unsafe3;
                                i17 = i18;
                                obj3 = obj4;
                                unsafe2 = unsafe62;
                                i13 = i35;
                                obj2 = obj3;
                                i12 = i17;
                                unsafe = unsafe2;
                                i14 = i28;
                                i15 = i32;
                                break;
                            } else {
                                iH = a.a.H(bArr4, i18, eVar2);
                                m1.f2246c.k(obj4, j2, eVar2.f414c != 0);
                                i26 |= i37;
                                unsafe4 = unsafe3;
                                bArr5 = bArr4;
                                i24 = i32;
                                i23 = i28;
                                obj7 = obj4;
                                i22 = i10;
                                break;
                            }
                        case 8:
                            obj4 = obj7;
                            bArr4 = bArr5;
                            c10 = 65535;
                            unsafe3 = unsafe4;
                            i18 = iB;
                            if (i29 != 2) {
                                Unsafe unsafe622 = unsafe3;
                                i17 = i18;
                                obj3 = obj4;
                                unsafe2 = unsafe622;
                                i13 = i35;
                                obj2 = obj3;
                                i12 = i17;
                                unsafe = unsafe2;
                                i14 = i28;
                                i15 = i32;
                                break;
                            } else {
                                iH = (i16 & 536870912) == 0 ? a.a.x(bArr4, i18, eVar2) : a.a.y(bArr4, i18, eVar2);
                                unsafe3.putObject(obj4, j2, eVar2.f415d);
                                i26 |= i37;
                                unsafe4 = unsafe3;
                                bArr5 = bArr4;
                                i24 = i32;
                                i23 = i28;
                                obj7 = obj4;
                                i22 = i10;
                                break;
                            }
                        case 9:
                            obj4 = obj7;
                            c10 = 65535;
                            if (i29 != 2) {
                                Unsafe unsafe7 = unsafe4;
                                obj3 = obj4;
                                unsafe2 = unsafe7;
                                i17 = iB;
                                i13 = i35;
                                obj2 = obj3;
                                i12 = i17;
                                unsafe = unsafe2;
                                i14 = i28;
                                i15 = i32;
                                break;
                            } else {
                                Unsafe unsafe8 = unsafe4;
                                Object objZ = r0Var.z(i32, obj4);
                                byte[] bArr6 = bArr5;
                                unsafe3 = unsafe8;
                                int iX = a.a.X(objZ, r0Var.p(i32), bArr6, iB, i22, eVar2);
                                bArr4 = bArr6;
                                r0Var.S(i32, obj4, objZ);
                                i26 |= i37;
                                iH = iX;
                                unsafe4 = unsafe3;
                                bArr5 = bArr4;
                                i24 = i32;
                                i23 = i28;
                                obj7 = obj4;
                                i22 = i10;
                                break;
                            }
                        case 10:
                            obj5 = obj7;
                            c10 = 65535;
                            if (i29 != 2) {
                                Object obj9 = obj5;
                                unsafe2 = unsafe4;
                                obj3 = obj9;
                                i17 = iB;
                                i13 = i35;
                                obj2 = obj3;
                                i12 = i17;
                                unsafe = unsafe2;
                                i14 = i28;
                                i15 = i32;
                                break;
                            } else {
                                iH = a.a.p(bArr5, iB, eVar2);
                                unsafe4.putObject(obj5, j2, eVar2.f415d);
                                i26 |= i37;
                                i24 = i32;
                                i23 = i28;
                                obj7 = obj5;
                                break;
                            }
                        case 12:
                            obj5 = obj7;
                            c10 = 65535;
                            if (i29 != 0) {
                                Object obj92 = obj5;
                                unsafe2 = unsafe4;
                                obj3 = obj92;
                                i17 = iB;
                                i13 = i35;
                                obj2 = obj3;
                                i12 = i17;
                                unsafe = unsafe2;
                                i14 = i28;
                                i15 = i32;
                                break;
                            } else {
                                iH = a.a.D(bArr5, iB, eVar2);
                                unsafe4.putInt(obj5, j2, eVar2.f413b);
                                i26 |= i37;
                                i24 = i32;
                                i23 = i28;
                                obj7 = obj5;
                                break;
                            }
                        case com.google.protobuf.x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                            obj5 = obj7;
                            c10 = 65535;
                            if (i29 != 0) {
                                Object obj922 = obj5;
                                unsafe2 = unsafe4;
                                obj3 = obj922;
                                i17 = iB;
                                i13 = i35;
                                obj2 = obj3;
                                i12 = i17;
                                unsafe = unsafe2;
                                i14 = i28;
                                i15 = i32;
                                break;
                            } else {
                                iH = a.a.D(bArr5, iB, eVar2);
                                unsafe4.putInt(obj5, j2, androidx.datastore.preferences.protobuf.j.d(eVar2.f413b));
                                i26 |= i37;
                                i24 = i32;
                                i23 = i28;
                                obj7 = obj5;
                                break;
                            }
                        case 16:
                            if (i29 != 0) {
                                c10 = 65535;
                                unsafe2 = unsafe4;
                                obj3 = obj7;
                                i17 = iB;
                                i13 = i35;
                                obj2 = obj3;
                                i12 = i17;
                                unsafe = unsafe2;
                                i14 = i28;
                                i15 = i32;
                                break;
                            } else {
                                int iH3 = a.a.H(bArr5, iB, eVar2);
                                unsafe4.putLong(obj7, j2, androidx.datastore.preferences.protobuf.j.e(eVar2.f414c));
                                i26 |= i37;
                                i24 = i32;
                                i23 = i28;
                                iH = iH3;
                                break;
                            }
                        default:
                            unsafe2 = unsafe4;
                            obj3 = obj7;
                            c10 = 65535;
                            i17 = iB;
                            i13 = i35;
                            obj2 = obj3;
                            i12 = i17;
                            unsafe = unsafe2;
                            i14 = i28;
                            i15 = i32;
                            break;
                    }
                } else {
                    Object obj10 = obj7;
                    Unsafe unsafe9 = unsafe4;
                    byte[] bArr7 = bArr5;
                    int i41 = iB;
                    if (iU != 27) {
                        i13 = i35;
                        i19 = i41;
                        if (iU <= 49) {
                            unsafe = unsafe9;
                            i14 = i28;
                            int i42 = i25;
                            int i43 = i26;
                            int iK = r0Var.K(obj, bArr, i19, i10, i13, i29, i32, i34, iU, j2, eVar);
                            i15 = i32;
                            if (iK != i19) {
                                bArr5 = bArr;
                                i22 = i10;
                                eVar2 = eVar;
                                obj7 = obj;
                                iH = iK;
                                i24 = i15;
                                i25 = i42;
                                i26 = i43;
                                i23 = i14;
                                unsafe4 = unsafe;
                            } else {
                                i12 = iK;
                                i25 = i42;
                                i26 = i43;
                                obj2 = obj;
                            }
                        } else {
                            unsafe = unsafe9;
                            i20 = i25;
                            i14 = i28;
                            obj6 = obj;
                            i15 = i32;
                            i21 = i26;
                            if (iU != 50) {
                                int iH4 = r0Var.H(obj6, bArr, i19, i10, i13, i14, i29, i34, iU, j2, i15, eVar);
                                obj2 = obj6;
                                if (iH4 != i19) {
                                    r0Var = this;
                                    i22 = i10;
                                    eVar2 = eVar;
                                    obj7 = obj2;
                                    iH = iH4;
                                    i24 = i15;
                                    i25 = i20;
                                    i26 = i21;
                                    i23 = i14;
                                    unsafe4 = unsafe;
                                    bArr5 = bArr;
                                } else {
                                    i12 = iH4;
                                    i25 = i20;
                                    i26 = i21;
                                }
                            } else if (i29 == 2) {
                                r0Var.G(i15, j2, obj6);
                                throw null;
                            }
                        }
                    } else if (i29 == 2) {
                        y yVarMutableCopyWithCapacity = (y) unsafe9.getObject(obj10, j2);
                        if (!((b) yVarMutableCopyWithCapacity).f2176f) {
                            int size = yVarMutableCopyWithCapacity.size();
                            yVarMutableCopyWithCapacity = yVarMutableCopyWithCapacity.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
                            unsafe9.putObject(obj10, j2, yVarMutableCopyWithCapacity);
                        }
                        int iV = a.a.v(r0Var.p(i32), i35, bArr7, i41, i10, yVarMutableCopyWithCapacity, eVar2);
                        obj7 = obj;
                        bArr5 = bArr;
                        eVar2 = eVar;
                        iH = iV;
                        unsafe4 = unsafe9;
                        i24 = i32;
                        i23 = i28;
                        i22 = i10;
                    } else {
                        obj6 = obj;
                        i13 = i35;
                        unsafe = unsafe9;
                        i19 = i41;
                        i20 = i25;
                        i21 = i26;
                        i14 = i28;
                        i15 = i32;
                    }
                    i12 = i19;
                    obj2 = obj6;
                    i25 = i20;
                    i26 = i21;
                }
            }
            v vVar = (v) obj2;
            d1 d1VarC = vVar.unknownFields;
            if (d1VarC == d1.f2196f) {
                d1VarC = d1.c();
                vVar.unknownFields = d1VarC;
            }
            int iZ = a.a.z(i13, bArr, i12, i10, d1VarC, eVar);
            bArr5 = bArr;
            eVar2 = eVar;
            i22 = i10;
            obj7 = obj2;
            i24 = i15;
            i23 = i14;
            unsafe4 = unsafe;
            iH = iZ;
            r0Var = this;
        }
        Unsafe unsafe10 = unsafe4;
        Object obj11 = obj7;
        int i44 = i22;
        int i45 = i25;
        int i46 = i26;
        if (i45 != 1048575) {
            unsafe10.putInt(obj11, i45, i46);
        }
        if (iH != i44) {
            throw b0.f();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final int K(Object obj, byte[] bArr, int i2, int i10, int i11, int i12, int i13, long j2, int i14, long j4, a7.e eVar) throws b0 {
        int iF;
        Unsafe unsafe = f2266p;
        y yVarMutableCopyWithCapacity = (y) unsafe.getObject(obj, j4);
        if (!((b) yVarMutableCopyWithCapacity).f2176f) {
            int size = yVarMutableCopyWithCapacity.size();
            yVarMutableCopyWithCapacity = yVarMutableCopyWithCapacity.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
            unsafe.putObject(obj, j4, yVarMutableCopyWithCapacity);
        }
        y yVar = yVarMutableCopyWithCapacity;
        switch (i14) {
            case com.google.protobuf.a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
            case com.google.protobuf.g1.FEATURES_FIELD_NUMBER /* 35 */:
                if (i12 == 2) {
                    l lVar = (l) yVar;
                    int iD = a.a.D(bArr, i2, eVar);
                    int i15 = eVar.f413b + iD;
                    while (iD < i15) {
                        lVar.addDouble(Double.longBitsToDouble(a.a.t(iD, bArr)));
                        iD += 8;
                    }
                    if (iD == i15) {
                        return iD;
                    }
                    throw b0.g();
                }
                if (i12 == 1) {
                    l lVar2 = (l) yVar;
                    lVar2.addDouble(Double.longBitsToDouble(a.a.t(i2, bArr)));
                    i2 += 8;
                    while (i2 < i10) {
                        int iD2 = a.a.D(bArr, i2, eVar);
                        if (i11 == eVar.f413b) {
                            lVar2.addDouble(Double.longBitsToDouble(a.a.t(iD2, bArr)));
                            i2 = iD2 + 8;
                        }
                    }
                }
                return i2;
            case com.google.protobuf.x0.TARGETS_FIELD_NUMBER /* 19 */:
            case com.google.protobuf.a1.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
                if (i12 == 2) {
                    r rVar = (r) yVar;
                    int iD3 = a.a.D(bArr, i2, eVar);
                    int i16 = eVar.f413b + iD3;
                    while (iD3 < i16) {
                        rVar.addFloat(Float.intBitsToFloat(a.a.r(iD3, bArr)));
                        iD3 += 4;
                    }
                    if (iD3 == i16) {
                        return iD3;
                    }
                    throw b0.g();
                }
                if (i12 == 5) {
                    r rVar2 = (r) yVar;
                    rVar2.addFloat(Float.intBitsToFloat(a.a.r(i2, bArr)));
                    int i17 = i2 + 4;
                    while (i17 < i10) {
                        int iD4 = a.a.D(bArr, i17, eVar);
                        if (i11 != eVar.f413b) {
                            return i17;
                        }
                        rVar2.addFloat(Float.intBitsToFloat(a.a.r(iD4, bArr)));
                        i17 = iD4 + 4;
                    }
                    return i17;
                }
                return i2;
            case 20:
            case com.google.protobuf.x0.FEATURES_FIELD_NUMBER /* 21 */:
            case com.google.protobuf.a1.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
            case 38:
                if (i12 == 2) {
                    i0 i0Var = (i0) yVar;
                    int iD5 = a.a.D(bArr, i2, eVar);
                    int i18 = eVar.f413b + iD5;
                    while (iD5 < i18) {
                        iD5 = a.a.H(bArr, iD5, eVar);
                        i0Var.addLong(eVar.f414c);
                    }
                    if (iD5 == i18) {
                        return iD5;
                    }
                    throw b0.g();
                }
                if (i12 == 0) {
                    i0 i0Var2 = (i0) yVar;
                    int iH = a.a.H(bArr, i2, eVar);
                    i0Var2.addLong(eVar.f414c);
                    while (iH < i10) {
                        int iD6 = a.a.D(bArr, iH, eVar);
                        if (i11 != eVar.f413b) {
                            return iH;
                        }
                        iH = a.a.H(bArr, iD6, eVar);
                        i0Var2.addLong(eVar.f414c);
                    }
                    return iH;
                }
                return i2;
            case com.google.protobuf.x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
            case 29:
            case com.google.protobuf.a1.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
            case 43:
                if (i12 != 2) {
                    if (i12 == 0) {
                        return a.a.F(i11, bArr, i2, i10, yVar, eVar);
                    }
                    return i2;
                }
                w wVar = (w) yVar;
                int iD7 = a.a.D(bArr, i2, eVar);
                int i19 = eVar.f413b + iD7;
                while (iD7 < i19) {
                    iD7 = a.a.D(bArr, iD7, eVar);
                    wVar.addInt(eVar.f413b);
                }
                if (iD7 == i19) {
                    return iD7;
                }
                throw b0.g();
            case com.google.protobuf.a1.DEPRECATED_FIELD_NUMBER /* 23 */:
            case 32:
            case com.google.protobuf.a1.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
            case 46:
                if (i12 == 2) {
                    i0 i0Var3 = (i0) yVar;
                    int iD8 = a.a.D(bArr, i2, eVar);
                    int i20 = eVar.f413b + iD8;
                    while (iD8 < i20) {
                        i0Var3.addLong(a.a.t(iD8, bArr));
                        iD8 += 8;
                    }
                    if (iD8 == i20) {
                        return iD8;
                    }
                    throw b0.g();
                }
                if (i12 == 1) {
                    i0 i0Var4 = (i0) yVar;
                    i0Var4.addLong(a.a.t(i2, bArr));
                    int i21 = i2 + 8;
                    while (i21 < i10) {
                        int iD9 = a.a.D(bArr, i21, eVar);
                        if (i11 != eVar.f413b) {
                            return i21;
                        }
                        i0Var4.addLong(a.a.t(iD9, bArr));
                        i21 = iD9 + 8;
                    }
                    return i21;
                }
                return i2;
            case 24:
            case com.google.protobuf.a1.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
            case com.google.protobuf.a1.PHP_NAMESPACE_FIELD_NUMBER /* 41 */:
            case com.google.protobuf.a1.RUBY_PACKAGE_FIELD_NUMBER /* 45 */:
                if (i12 == 2) {
                    w wVar2 = (w) yVar;
                    int iD10 = a.a.D(bArr, i2, eVar);
                    int i22 = eVar.f413b + iD10;
                    while (iD10 < i22) {
                        wVar2.addInt(a.a.r(iD10, bArr));
                        iD10 += 4;
                    }
                    if (iD10 == i22) {
                        return iD10;
                    }
                    throw b0.g();
                }
                if (i12 == 5) {
                    w wVar3 = (w) yVar;
                    wVar3.addInt(a.a.r(i2, bArr));
                    int i23 = i2 + 4;
                    while (i23 < i10) {
                        int iD11 = a.a.D(bArr, i23, eVar);
                        if (i11 != eVar.f413b) {
                            return i23;
                        }
                        wVar3.addInt(a.a.r(iD11, bArr));
                        i23 = iD11 + 4;
                    }
                    return i23;
                }
                return i2;
            case 25:
            case 42:
                if (i12 == 2) {
                    d dVar = (d) yVar;
                    int iD12 = a.a.D(bArr, i2, eVar);
                    int i24 = eVar.f413b + iD12;
                    while (iD12 < i24) {
                        iD12 = a.a.H(bArr, iD12, eVar);
                        dVar.addBoolean(eVar.f414c != 0);
                    }
                    if (iD12 == i24) {
                        return iD12;
                    }
                    throw b0.g();
                }
                if (i12 == 0) {
                    d dVar2 = (d) yVar;
                    int iH2 = a.a.H(bArr, i2, eVar);
                    dVar2.addBoolean(eVar.f414c != 0);
                    while (iH2 < i10) {
                        int iD13 = a.a.D(bArr, iH2, eVar);
                        if (i11 != eVar.f413b) {
                            return iH2;
                        }
                        iH2 = a.a.H(bArr, iD13, eVar);
                        dVar2.addBoolean(eVar.f414c != 0);
                    }
                    return iH2;
                }
                return i2;
            case 26:
                if (i12 == 2) {
                    if ((j2 & 536870912) == 0) {
                        int iD14 = a.a.D(bArr, i2, eVar);
                        int i25 = eVar.f413b;
                        if (i25 < 0) {
                            throw b0.e();
                        }
                        if (i25 == 0) {
                            yVar.add("");
                        } else {
                            yVar.add(new String(bArr, iD14, i25, z.f2296a));
                            iD14 += i25;
                        }
                        while (iD14 < i10) {
                            int iD15 = a.a.D(bArr, iD14, eVar);
                            if (i11 != eVar.f413b) {
                                return iD14;
                            }
                            iD14 = a.a.D(bArr, iD15, eVar);
                            int i26 = eVar.f413b;
                            if (i26 < 0) {
                                throw b0.e();
                            }
                            if (i26 == 0) {
                                yVar.add("");
                            } else {
                                yVar.add(new String(bArr, iD14, i26, z.f2296a));
                                iD14 += i26;
                            }
                        }
                        return iD14;
                    }
                    int iD16 = a.a.D(bArr, i2, eVar);
                    int i27 = eVar.f413b;
                    if (i27 < 0) {
                        throw b0.e();
                    }
                    if (i27 == 0) {
                        yVar.add("");
                    } else {
                        int i28 = iD16 + i27;
                        if (!p1.f2258a.G(bArr, iD16, i28)) {
                            throw b0.b();
                        }
                        yVar.add(new String(bArr, iD16, i27, z.f2296a));
                        iD16 = i28;
                    }
                    while (iD16 < i10) {
                        int iD17 = a.a.D(bArr, iD16, eVar);
                        if (i11 != eVar.f413b) {
                            return iD16;
                        }
                        iD16 = a.a.D(bArr, iD17, eVar);
                        int i29 = eVar.f413b;
                        if (i29 < 0) {
                            throw b0.e();
                        }
                        if (i29 == 0) {
                            yVar.add("");
                        } else {
                            int i30 = iD16 + i29;
                            if (!p1.f2258a.G(bArr, iD16, i30)) {
                                throw b0.b();
                            }
                            yVar.add(new String(bArr, iD16, i29, z.f2296a));
                            iD16 = i30;
                        }
                    }
                    return iD16;
                }
                return i2;
            case com.google.protobuf.a1.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                if (i12 == 2) {
                    return a.a.v(p(i13), i11, bArr, i2, i10, yVar, eVar);
                }
                return i2;
            case 28:
                if (i12 == 2) {
                    int iD18 = a.a.D(bArr, i2, eVar);
                    int i31 = eVar.f413b;
                    if (i31 < 0) {
                        throw b0.e();
                    }
                    if (i31 > bArr.length - iD18) {
                        throw b0.g();
                    }
                    if (i31 == 0) {
                        yVar.add(h.f2209g);
                    } else {
                        yVar.add(h.h(bArr, iD18, i31));
                        iD18 += i31;
                    }
                    while (iD18 < i10) {
                        int iD19 = a.a.D(bArr, iD18, eVar);
                        if (i11 != eVar.f413b) {
                            return iD18;
                        }
                        iD18 = a.a.D(bArr, iD19, eVar);
                        int i32 = eVar.f413b;
                        if (i32 < 0) {
                            throw b0.e();
                        }
                        if (i32 > bArr.length - iD18) {
                            throw b0.g();
                        }
                        if (i32 == 0) {
                            yVar.add(h.f2209g);
                        } else {
                            yVar.add(h.h(bArr, iD18, i32));
                            iD18 += i32;
                        }
                    }
                    return iD18;
                }
                return i2;
            case 30:
            case com.google.protobuf.a1.PHP_METADATA_NAMESPACE_FIELD_NUMBER /* 44 */:
                if (i12 != 2) {
                    if (i12 == 0) {
                        iF = a.a.F(i11, bArr, i2, i10, yVar, eVar);
                    }
                    return i2;
                }
                w wVar4 = (w) yVar;
                iF = a.a.D(bArr, i2, eVar);
                int i33 = eVar.f413b + iF;
                while (iF < i33) {
                    iF = a.a.D(bArr, iF, eVar);
                    wVar4.addInt(eVar.f413b);
                }
                if (iF != i33) {
                    throw b0.g();
                }
                n(i13);
                Class cls = b1.f2178a;
                return iF;
            case 33:
            case 47:
                if (i12 == 2) {
                    w wVar5 = (w) yVar;
                    int iD20 = a.a.D(bArr, i2, eVar);
                    int i34 = eVar.f413b + iD20;
                    while (iD20 < i34) {
                        iD20 = a.a.D(bArr, iD20, eVar);
                        wVar5.addInt(androidx.datastore.preferences.protobuf.j.d(eVar.f413b));
                    }
                    if (iD20 == i34) {
                        return iD20;
                    }
                    throw b0.g();
                }
                if (i12 == 0) {
                    w wVar6 = (w) yVar;
                    int iD21 = a.a.D(bArr, i2, eVar);
                    wVar6.addInt(androidx.datastore.preferences.protobuf.j.d(eVar.f413b));
                    while (iD21 < i10) {
                        int iD22 = a.a.D(bArr, iD21, eVar);
                        if (i11 != eVar.f413b) {
                            return iD21;
                        }
                        iD21 = a.a.D(bArr, iD22, eVar);
                        wVar6.addInt(androidx.datastore.preferences.protobuf.j.d(eVar.f413b));
                    }
                    return iD21;
                }
                return i2;
            case 34:
            case 48:
                if (i12 == 2) {
                    i0 i0Var5 = (i0) yVar;
                    int iD23 = a.a.D(bArr, i2, eVar);
                    int i35 = eVar.f413b + iD23;
                    while (iD23 < i35) {
                        iD23 = a.a.H(bArr, iD23, eVar);
                        i0Var5.addLong(androidx.datastore.preferences.protobuf.j.e(eVar.f414c));
                    }
                    if (iD23 == i35) {
                        return iD23;
                    }
                    throw b0.g();
                }
                if (i12 == 0) {
                    i0 i0Var6 = (i0) yVar;
                    int iH3 = a.a.H(bArr, i2, eVar);
                    i0Var6.addLong(androidx.datastore.preferences.protobuf.j.e(eVar.f414c));
                    while (iH3 < i10) {
                        int iD24 = a.a.D(bArr, iH3, eVar);
                        if (i11 != eVar.f413b) {
                            return iH3;
                        }
                        iH3 = a.a.H(bArr, iD24, eVar);
                        i0Var6.addLong(androidx.datastore.preferences.protobuf.j.e(eVar.f414c));
                    }
                    return iH3;
                }
                return i2;
            case 49:
                if (i12 == 3) {
                    a1 a1VarP = p(i13);
                    int i36 = (i11 & (-8)) | 4;
                    Object objD = a1VarP.d();
                    r0 r0Var = (r0) a1VarP;
                    int I = r0Var.I(objD, bArr, i2, i10, i36, eVar);
                    eVar.f415d = objD;
                    a1VarP.b(objD);
                    eVar.f415d = objD;
                    yVar.add(objD);
                    while (I < i10) {
                        int iD25 = a.a.D(bArr, I, eVar);
                        if (i11 != eVar.f413b) {
                            return I;
                        }
                        Object objD2 = a1VarP.d();
                        I = r0Var.I(objD2, bArr, iD25, i10, i36, eVar);
                        eVar.f415d = objD2;
                        a1VarP.b(objD2);
                        eVar.f415d = objD2;
                        yVar.add(objD2);
                    }
                    return I;
                }
                return i2;
            default:
                return i2;
        }
    }

    public final void L(Object obj, long j2, androidx.datastore.preferences.protobuf.k kVar, a1 a1Var, n nVar) throws a0 {
        int iC;
        List listC = this.f2278l.c(j2, obj);
        androidx.datastore.preferences.protobuf.j jVar = (androidx.datastore.preferences.protobuf.j) kVar.f896e;
        int i2 = kVar.f893b;
        if ((i2 & 7) != 3) {
            throw b0.c();
        }
        do {
            Object objD = a1Var.d();
            kVar.e(objD, a1Var, nVar);
            a1Var.b(objD);
            listC.add(objD);
            if (jVar.g() || kVar.f895d != 0) {
                return;
            } else {
                iC = jVar.C();
            }
        } while (iC == i2);
        kVar.f895d = iC;
    }

    public final void M(Object obj, int i2, androidx.datastore.preferences.protobuf.k kVar, a1 a1Var, n nVar) throws b0 {
        int iC;
        List listC = this.f2278l.c(i2 & 1048575, obj);
        androidx.datastore.preferences.protobuf.j jVar = (androidx.datastore.preferences.protobuf.j) kVar.f896e;
        int i10 = kVar.f893b;
        if ((i10 & 7) != 2) {
            throw b0.c();
        }
        do {
            Object objD = a1Var.d();
            kVar.h(objD, a1Var, nVar);
            a1Var.b(objD);
            listC.add(objD);
            if (jVar.g() || kVar.f895d != 0) {
                return;
            } else {
                iC = jVar.C();
            }
        } while (iC == i10);
        kVar.f895d = iC;
    }

    public final void N(int i2, androidx.datastore.preferences.protobuf.k kVar, Object obj) throws androidx.datastore.preferences.protobuf.z, a0, q2 {
        if ((536870912 & i2) != 0) {
            kVar.V(2);
            m1.p(i2 & 1048575, obj, ((androidx.datastore.preferences.protobuf.j) kVar.f896e).B());
        } else if (!this.f2272f) {
            m1.p(i2 & 1048575, obj, kVar.m());
        } else {
            kVar.V(2);
            m1.p(i2 & 1048575, obj, ((androidx.datastore.preferences.protobuf.j) kVar.f896e).A());
        }
    }

    public final void P(int i2, Object obj) {
        int i10 = this.f2267a[i2 + 2];
        long j2 = 1048575 & i10;
        if (j2 == 1048575) {
            return;
        }
        m1.n((1 << (i10 >>> 20)) | m1.f2246c.g(j2, obj), j2, obj);
    }

    public final void Q(int i2, int i10, Object obj) {
        m1.n(i2, this.f2267a[i10 + 2] & 1048575, obj);
    }

    public final int R(int i2, int i10) {
        int[] iArr = this.f2267a;
        int length = (iArr.length / 3) - 1;
        while (i10 <= length) {
            int i11 = (length + i10) >>> 1;
            int i12 = i11 * 3;
            int i13 = iArr[i12];
            if (i2 == i13) {
                return i12;
            }
            if (i2 < i13) {
                length = i11 - 1;
            } else {
                i10 = i11 + 1;
            }
        }
        return -1;
    }

    public final void S(int i2, Object obj, Object obj2) {
        f2266p.putObject(obj, V(i2) & 1048575, obj2);
        P(i2, obj);
    }

    public final void T(int i2, int i10, Object obj, Object obj2) {
        f2266p.putObject(obj, V(i10) & 1048575, obj2);
        Q(i2, i10, obj);
    }

    public final int V(int i2) {
        return this.f2267a[i2 + 1];
    }

    public final void W(Object obj, k0 k0Var) throws androidx.datastore.preferences.protobuf.l {
        int i2;
        int i10;
        int i11;
        int[] iArr = this.f2267a;
        int length = iArr.length;
        Unsafe unsafe = f2266p;
        int i12 = 1048575;
        int i13 = 0;
        for (int i14 = 0; i14 < length; i14 = i11 + 3) {
            int iV = V(i14);
            int i15 = iArr[i14];
            int iU = U(iV);
            if (iU <= 17) {
                int i16 = iArr[i14 + 2];
                i2 = 1048575;
                int i17 = i16 & 1048575;
                if (i17 != i12) {
                    i13 = unsafe.getInt(obj, i17);
                    i12 = i17;
                }
                i10 = 1 << (i16 >>> 20);
            } else {
                i2 = 1048575;
                i10 = 0;
            }
            int i18 = i14;
            long j2 = iV & i2;
            switch (iU) {
                case 0:
                    i11 = i18;
                    if ((i10 & i13) != 0) {
                        double dE = m1.f2246c.e(j2, obj);
                        k kVar = (k) k0Var.f2239a;
                        kVar.getClass();
                        kVar.e0(i15, Double.doubleToRawLongBits(dE));
                        continue;
                    }
                case 1:
                    i11 = i18;
                    if ((i10 & i13) != 0) {
                        float f10 = m1.f2246c.f(j2, obj);
                        k kVar2 = (k) k0Var.f2239a;
                        kVar2.getClass();
                        kVar2.c0(i15, Float.floatToRawIntBits(f10));
                    } else {
                        continue;
                    }
                case 2:
                    i11 = i18;
                    if ((i10 & i13) != 0) {
                        ((k) k0Var.f2239a).j0(i15, unsafe.getLong(obj, j2));
                    } else {
                        continue;
                    }
                case 3:
                    i11 = i18;
                    if ((i10 & i13) != 0) {
                        ((k) k0Var.f2239a).j0(i15, unsafe.getLong(obj, j2));
                    } else {
                        continue;
                    }
                case 4:
                    i11 = i18;
                    if ((i10 & i13) != 0) {
                        int i19 = unsafe.getInt(obj, j2);
                        k kVar3 = (k) k0Var.f2239a;
                        kVar3.h0(i15, 0);
                        kVar3.g0(i19);
                    }
                    break;
                case 5:
                    i11 = i18;
                    if ((i10 & i13) != 0) {
                        ((k) k0Var.f2239a).e0(i15, unsafe.getLong(obj, j2));
                        break;
                    }
                    break;
                case 6:
                    i11 = i18;
                    if ((i10 & i13) != 0) {
                        ((k) k0Var.f2239a).c0(i15, unsafe.getInt(obj, j2));
                        break;
                    }
                    break;
                case 7:
                    i11 = i18;
                    if ((i10 & i13) != 0) {
                        boolean zC = m1.f2246c.c(j2, obj);
                        k kVar4 = (k) k0Var.f2239a;
                        kVar4.h0(i15, 0);
                        kVar4.a0(zC ? (byte) 1 : (byte) 0);
                        break;
                    }
                    break;
                case 8:
                    i11 = i18;
                    if ((i10 & i13) != 0) {
                        X(i15, unsafe.getObject(obj, j2), k0Var);
                        break;
                    }
                    break;
                case 9:
                    i11 = i18;
                    if ((i10 & i13) != 0) {
                        k0Var.c(i15, unsafe.getObject(obj, j2), p(i11));
                        break;
                    }
                    break;
                case 10:
                    i11 = i18;
                    if ((i10 & i13) != 0) {
                        k0Var.a(i15, (h) unsafe.getObject(obj, j2));
                        break;
                    }
                    break;
                case 11:
                    i11 = i18;
                    if ((i10 & i13) != 0) {
                        int i20 = unsafe.getInt(obj, j2);
                        k kVar5 = (k) k0Var.f2239a;
                        kVar5.h0(i15, 0);
                        kVar5.i0(i20);
                        break;
                    }
                    break;
                case 12:
                    i11 = i18;
                    if ((i10 & i13) != 0) {
                        int i21 = unsafe.getInt(obj, j2);
                        k kVar6 = (k) k0Var.f2239a;
                        kVar6.h0(i15, 0);
                        kVar6.g0(i21);
                    }
                    break;
                case 13:
                    i11 = i18;
                    if ((i10 & i13) != 0) {
                        ((k) k0Var.f2239a).c0(i15, unsafe.getInt(obj, j2));
                        break;
                    }
                    break;
                case com.google.protobuf.y0.EDITION_FIELD_NUMBER /* 14 */:
                    i11 = i18;
                    if ((i10 & i13) != 0) {
                        ((k) k0Var.f2239a).e0(i15, unsafe.getLong(obj, j2));
                        break;
                    }
                    break;
                case com.google.protobuf.x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                    i11 = i18;
                    if ((i10 & i13) != 0) {
                        int i22 = unsafe.getInt(obj, j2);
                        k kVar7 = (k) k0Var.f2239a;
                        kVar7.h0(i15, 0);
                        kVar7.i0((i22 >> 31) ^ (i22 << 1));
                        break;
                    }
                    break;
                case 16:
                    i11 = i18;
                    if ((i10 & i13) != 0) {
                        long j4 = unsafe.getLong(obj, j2);
                        ((k) k0Var.f2239a).j0(i15, (j4 << 1) ^ (j4 >> 63));
                        break;
                    }
                    break;
                case 17:
                    i11 = i18;
                    if ((i10 & i13) != 0) {
                        k0Var.b(i15, unsafe.getObject(obj, j2), p(i11));
                        break;
                    }
                    break;
                case com.google.protobuf.a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
                    i11 = i18;
                    b1.A(iArr[i11], (List) unsafe.getObject(obj, j2), k0Var, false);
                    break;
                case com.google.protobuf.x0.TARGETS_FIELD_NUMBER /* 19 */:
                    i11 = i18;
                    b1.E(iArr[i11], (List) unsafe.getObject(obj, j2), k0Var, false);
                    continue;
                case 20:
                    i11 = i18;
                    b1.H(iArr[i11], (List) unsafe.getObject(obj, j2), k0Var, false);
                    continue;
                case com.google.protobuf.x0.FEATURES_FIELD_NUMBER /* 21 */:
                    i11 = i18;
                    b1.P(iArr[i11], (List) unsafe.getObject(obj, j2), k0Var, false);
                    continue;
                case com.google.protobuf.x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
                    i11 = i18;
                    b1.G(iArr[i11], (List) unsafe.getObject(obj, j2), k0Var, false);
                    continue;
                case com.google.protobuf.a1.DEPRECATED_FIELD_NUMBER /* 23 */:
                    i11 = i18;
                    b1.D(iArr[i11], (List) unsafe.getObject(obj, j2), k0Var, false);
                    continue;
                case 24:
                    i11 = i18;
                    b1.C(iArr[i11], (List) unsafe.getObject(obj, j2), k0Var, false);
                    continue;
                case 25:
                    i11 = i18;
                    b1.y(iArr[i11], (List) unsafe.getObject(obj, j2), k0Var, false);
                    continue;
                case 26:
                    i11 = i18;
                    b1.N(iArr[i11], (List) unsafe.getObject(obj, j2), k0Var);
                    break;
                case com.google.protobuf.a1.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                    i11 = i18;
                    b1.I(iArr[i11], (List) unsafe.getObject(obj, j2), k0Var, p(i11));
                    break;
                case 28:
                    i11 = i18;
                    b1.z(iArr[i11], (List) unsafe.getObject(obj, j2), k0Var);
                    break;
                case 29:
                    i11 = i18;
                    b1.O(iArr[i11], (List) unsafe.getObject(obj, j2), k0Var, false);
                    break;
                case 30:
                    i11 = i18;
                    b1.B(iArr[i11], (List) unsafe.getObject(obj, j2), k0Var, false);
                    continue;
                case com.google.protobuf.a1.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
                    i11 = i18;
                    b1.J(iArr[i11], (List) unsafe.getObject(obj, j2), k0Var, false);
                    continue;
                case 32:
                    i11 = i18;
                    b1.K(iArr[i11], (List) unsafe.getObject(obj, j2), k0Var, false);
                    continue;
                case 33:
                    i11 = i18;
                    b1.L(iArr[i11], (List) unsafe.getObject(obj, j2), k0Var, false);
                    continue;
                case 34:
                    i11 = i18;
                    b1.M(iArr[i11], (List) unsafe.getObject(obj, j2), k0Var, false);
                    continue;
                case com.google.protobuf.g1.FEATURES_FIELD_NUMBER /* 35 */:
                    i11 = i18;
                    b1.A(iArr[i11], (List) unsafe.getObject(obj, j2), k0Var, true);
                    break;
                case com.google.protobuf.a1.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
                    i11 = i18;
                    b1.E(iArr[i11], (List) unsafe.getObject(obj, j2), k0Var, true);
                    break;
                case com.google.protobuf.a1.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
                    i11 = i18;
                    b1.H(iArr[i11], (List) unsafe.getObject(obj, j2), k0Var, true);
                    break;
                case 38:
                    i11 = i18;
                    b1.P(iArr[i11], (List) unsafe.getObject(obj, j2), k0Var, true);
                    break;
                case com.google.protobuf.a1.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
                    i11 = i18;
                    b1.G(iArr[i11], (List) unsafe.getObject(obj, j2), k0Var, true);
                    break;
                case com.google.protobuf.a1.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
                    i11 = i18;
                    b1.D(iArr[i11], (List) unsafe.getObject(obj, j2), k0Var, true);
                    break;
                case com.google.protobuf.a1.PHP_NAMESPACE_FIELD_NUMBER /* 41 */:
                    i11 = i18;
                    b1.C(iArr[i11], (List) unsafe.getObject(obj, j2), k0Var, true);
                    break;
                case 42:
                    i11 = i18;
                    b1.y(iArr[i11], (List) unsafe.getObject(obj, j2), k0Var, true);
                    break;
                case 43:
                    i11 = i18;
                    b1.O(iArr[i11], (List) unsafe.getObject(obj, j2), k0Var, true);
                    break;
                case com.google.protobuf.a1.PHP_METADATA_NAMESPACE_FIELD_NUMBER /* 44 */:
                    i11 = i18;
                    b1.B(iArr[i11], (List) unsafe.getObject(obj, j2), k0Var, true);
                    break;
                case com.google.protobuf.a1.RUBY_PACKAGE_FIELD_NUMBER /* 45 */:
                    i11 = i18;
                    b1.J(iArr[i11], (List) unsafe.getObject(obj, j2), k0Var, true);
                    break;
                case 46:
                    i11 = i18;
                    b1.K(iArr[i11], (List) unsafe.getObject(obj, j2), k0Var, true);
                    break;
                case 47:
                    i11 = i18;
                    b1.L(iArr[i11], (List) unsafe.getObject(obj, j2), k0Var, true);
                    break;
                case 48:
                    i11 = i18;
                    b1.M(iArr[i11], (List) unsafe.getObject(obj, j2), k0Var, true);
                    break;
                case 49:
                    i11 = i18;
                    b1.F(iArr[i11], (List) unsafe.getObject(obj, j2), k0Var, p(i11));
                    break;
                case 50:
                    i11 = i18;
                    if (unsafe.getObject(obj, j2) != null) {
                        Object objO = o(i11);
                        this.f2280n.getClass();
                        a1.a.t(objO);
                        throw null;
                    }
                    break;
                case 51:
                    i11 = i18;
                    if (u(i15, i11, obj)) {
                        double dDoubleValue = ((Double) m1.f2246c.i(j2, obj)).doubleValue();
                        k kVar8 = (k) k0Var.f2239a;
                        kVar8.getClass();
                        kVar8.e0(i15, Double.doubleToRawLongBits(dDoubleValue));
                        break;
                    }
                    break;
                case 52:
                    i11 = i18;
                    if (u(i15, i11, obj)) {
                        float fFloatValue = ((Float) m1.f2246c.i(j2, obj)).floatValue();
                        k kVar9 = (k) k0Var.f2239a;
                        kVar9.getClass();
                        kVar9.c0(i15, Float.floatToRawIntBits(fFloatValue));
                        break;
                    }
                    break;
                case 53:
                    i11 = i18;
                    if (u(i15, i11, obj)) {
                        ((k) k0Var.f2239a).j0(i15, F(j2, obj));
                        break;
                    }
                    break;
                case 54:
                    i11 = i18;
                    if (u(i15, i11, obj)) {
                        ((k) k0Var.f2239a).j0(i15, F(j2, obj));
                        break;
                    }
                    break;
                case 55:
                    i11 = i18;
                    if (u(i15, i11, obj)) {
                        int iE = E(j2, obj);
                        k kVar10 = (k) k0Var.f2239a;
                        kVar10.h0(i15, 0);
                        kVar10.g0(iE);
                        break;
                    }
                    break;
                case 56:
                    i11 = i18;
                    if (u(i15, i11, obj)) {
                        ((k) k0Var.f2239a).e0(i15, F(j2, obj));
                        break;
                    }
                    break;
                case 57:
                    i11 = i18;
                    if (u(i15, i11, obj)) {
                        ((k) k0Var.f2239a).c0(i15, E(j2, obj));
                        break;
                    }
                    break;
                case 58:
                    i11 = i18;
                    if (u(i15, i11, obj)) {
                        boolean zBooleanValue = ((Boolean) m1.f2246c.i(j2, obj)).booleanValue();
                        k kVar11 = (k) k0Var.f2239a;
                        kVar11.h0(i15, 0);
                        kVar11.a0(zBooleanValue ? (byte) 1 : (byte) 0);
                        break;
                    }
                    break;
                case 59:
                    i11 = i18;
                    if (u(i15, i11, obj)) {
                        X(i15, unsafe.getObject(obj, j2), k0Var);
                        break;
                    }
                    break;
                case 60:
                    i11 = i18;
                    if (u(i15, i11, obj)) {
                        k0Var.c(i15, unsafe.getObject(obj, j2), p(i11));
                        break;
                    }
                    break;
                case 61:
                    i11 = i18;
                    if (u(i15, i11, obj)) {
                        k0Var.a(i15, (h) unsafe.getObject(obj, j2));
                        break;
                    }
                    break;
                case 62:
                    i11 = i18;
                    if (u(i15, i11, obj)) {
                        int iE2 = E(j2, obj);
                        k kVar12 = (k) k0Var.f2239a;
                        kVar12.h0(i15, 0);
                        kVar12.i0(iE2);
                        break;
                    }
                    break;
                case 63:
                    i11 = i18;
                    if (u(i15, i11, obj)) {
                        int iE3 = E(j2, obj);
                        k kVar13 = (k) k0Var.f2239a;
                        kVar13.h0(i15, 0);
                        kVar13.g0(iE3);
                    }
                    break;
                case 64:
                    i11 = i18;
                    if (u(i15, i11, obj)) {
                        ((k) k0Var.f2239a).c0(i15, E(j2, obj));
                        break;
                    }
                    break;
                case 65:
                    i11 = i18;
                    if (u(i15, i11, obj)) {
                        ((k) k0Var.f2239a).e0(i15, F(j2, obj));
                        break;
                    }
                    break;
                case 66:
                    i11 = i18;
                    if (u(i15, i11, obj)) {
                        int iE4 = E(j2, obj);
                        k kVar14 = (k) k0Var.f2239a;
                        kVar14.h0(i15, 0);
                        kVar14.i0((iE4 >> 31) ^ (iE4 << 1));
                        break;
                    }
                    break;
                case 67:
                    i11 = i18;
                    if (u(i15, i11, obj)) {
                        long jF = F(j2, obj);
                        ((k) k0Var.f2239a).j0(i15, (jF << 1) ^ (jF >> 63));
                        break;
                    }
                    break;
                case 68:
                    i11 = i18;
                    if (u(i15, i11, obj)) {
                        k0Var.b(i15, unsafe.getObject(obj, j2), p(i11));
                        break;
                    }
                    break;
                default:
                    i11 = i18;
                    break;
            }
        }
        this.f2279m.getClass();
        ((v) obj).unknownFields.e(k0Var);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0022  */
    @Override // com.google.crypto.tink.shaded.protobuf.a1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.lang.Object r11, java.lang.Object r12) {
        /*
            Method dump skipped, instructions count: 590
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.r0.a(java.lang.Object, java.lang.Object):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0051  */
    @Override // com.google.crypto.tink.shaded.protobuf.a1
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
            boolean r0 = r9 instanceof com.google.crypto.tink.shaded.protobuf.v
            r1 = 0
            if (r0 == 0) goto L1a
            r0 = r9
            com.google.crypto.tink.shaded.protobuf.v r0 = (com.google.crypto.tink.shaded.protobuf.v) r0
            r2 = 2147483647(0x7fffffff, float:NaN)
            r0.t(r2)
            r0.memoizedHashCode = r1
            r0.n()
        L1a:
            int[] r0 = r8.f2267a
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
            sun.misc.Unsafe r3 = com.google.crypto.tink.shaded.protobuf.r0.f2266p
            java.lang.Object r6 = r3.getObject(r9, r4)
            if (r6 == 0) goto L64
            com.google.crypto.tink.shaded.protobuf.m0 r7 = r8.f2280n
            r7.getClass()
            r7 = r6
            com.google.crypto.tink.shaded.protobuf.l0 r7 = (com.google.crypto.tink.shaded.protobuf.l0) r7
            r7.f2241f = r1
            r3.putObject(r9, r4, r6)
            goto L64
        L4b:
            com.google.crypto.tink.shaded.protobuf.h0 r3 = r8.f2278l
            r3.a(r4, r9)
            goto L64
        L51:
            boolean r3 = r8.s(r2, r9)
            if (r3 == 0) goto L64
            com.google.crypto.tink.shaded.protobuf.a1 r3 = r8.p(r2)
            sun.misc.Unsafe r6 = com.google.crypto.tink.shaded.protobuf.r0.f2266p
            java.lang.Object r4 = r6.getObject(r9, r4)
            r3.b(r4)
        L64:
            int r2 = r2 + 3
            goto L1e
        L67:
            com.google.crypto.tink.shaded.protobuf.e1 r8 = r8.f2279m
            r8.getClass()
            com.google.crypto.tink.shaded.protobuf.v r9 = (com.google.crypto.tink.shaded.protobuf.v) r9
            com.google.crypto.tink.shaded.protobuf.d1 r8 = r9.unknownFields
            r8.f2201e = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.r0.b(java.lang.Object):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0045  */
    @Override // com.google.crypto.tink.shaded.protobuf.a1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c(java.lang.Object r14) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.r0.c(java.lang.Object):boolean");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.a1
    public final Object d() {
        this.f2277k.getClass();
        return ((v) this.f2271e).p();
    }

    @Override // com.google.crypto.tink.shaded.protobuf.a1
    public final int e(v vVar) {
        return this.f2273g ? r(vVar) : q(vVar);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.a1
    public final void f(Object obj, byte[] bArr, int i2, int i10, a7.e eVar) throws b0 {
        if (this.f2273g) {
            J(obj, bArr, i2, i10, eVar);
        } else {
            I(obj, bArr, i2, i10, 0, eVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    @Override // com.google.crypto.tink.shaded.protobuf.a1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g(com.google.crypto.tink.shaded.protobuf.v r12, com.google.crypto.tink.shaded.protobuf.v r13) {
        /*
            Method dump skipped, instructions count: 660
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.r0.g(com.google.crypto.tink.shaded.protobuf.v, com.google.crypto.tink.shaded.protobuf.v):boolean");
    }

    @Override // com.google.crypto.tink.shaded.protobuf.a1
    public final void h(Object obj, k0 k0Var) throws androidx.datastore.preferences.protobuf.l {
        k0Var.getClass();
        k kVar = (k) k0Var.f2239a;
        if (!this.f2273g) {
            W(obj, k0Var);
            return;
        }
        int[] iArr = this.f2267a;
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2 += 3) {
            int iV = V(i2);
            int i10 = iArr[i2];
            switch (U(iV)) {
                case 0:
                    if (s(i2, obj)) {
                        double dE = m1.f2246c.e(iV & 1048575, obj);
                        kVar.getClass();
                        kVar.e0(i10, Double.doubleToRawLongBits(dE));
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (s(i2, obj)) {
                        float f10 = m1.f2246c.f(iV & 1048575, obj);
                        kVar.getClass();
                        kVar.c0(i10, Float.floatToRawIntBits(f10));
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (s(i2, obj)) {
                        kVar.j0(i10, m1.f2246c.h(iV & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (s(i2, obj)) {
                        kVar.j0(i10, m1.f2246c.h(iV & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (s(i2, obj)) {
                        int iG = m1.f2246c.g(iV & 1048575, obj);
                        kVar.h0(i10, 0);
                        kVar.g0(iG);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (s(i2, obj)) {
                        kVar.e0(i10, m1.f2246c.h(iV & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (s(i2, obj)) {
                        kVar.c0(i10, m1.f2246c.g(iV & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (s(i2, obj)) {
                        boolean zC = m1.f2246c.c(iV & 1048575, obj);
                        kVar.h0(i10, 0);
                        kVar.a0(zC ? (byte) 1 : (byte) 0);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (s(i2, obj)) {
                        X(i10, m1.f2246c.i(iV & 1048575, obj), k0Var);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if (s(i2, obj)) {
                        k0Var.c(i10, m1.f2246c.i(iV & 1048575, obj), p(i2));
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (s(i2, obj)) {
                        k0Var.a(i10, (h) m1.f2246c.i(iV & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (s(i2, obj)) {
                        int iG2 = m1.f2246c.g(iV & 1048575, obj);
                        kVar.h0(i10, 0);
                        kVar.i0(iG2);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (s(i2, obj)) {
                        int iG3 = m1.f2246c.g(iV & 1048575, obj);
                        kVar.h0(i10, 0);
                        kVar.g0(iG3);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (s(i2, obj)) {
                        kVar.c0(i10, m1.f2246c.g(iV & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case com.google.protobuf.y0.EDITION_FIELD_NUMBER /* 14 */:
                    if (s(i2, obj)) {
                        kVar.e0(i10, m1.f2246c.h(iV & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case com.google.protobuf.x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                    if (s(i2, obj)) {
                        int iG4 = m1.f2246c.g(iV & 1048575, obj);
                        kVar.h0(i10, 0);
                        kVar.i0((iG4 >> 31) ^ (iG4 << 1));
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (s(i2, obj)) {
                        long jH = m1.f2246c.h(iV & 1048575, obj);
                        kVar.j0(i10, (jH >> 63) ^ (jH << 1));
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (s(i2, obj)) {
                        k0Var.b(i10, m1.f2246c.i(iV & 1048575, obj), p(i2));
                        break;
                    } else {
                        break;
                    }
                case com.google.protobuf.a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
                    b1.A(iArr[i2], (List) m1.f2246c.i(iV & 1048575, obj), k0Var, false);
                    break;
                case com.google.protobuf.x0.TARGETS_FIELD_NUMBER /* 19 */:
                    b1.E(iArr[i2], (List) m1.f2246c.i(iV & 1048575, obj), k0Var, false);
                    break;
                case 20:
                    b1.H(iArr[i2], (List) m1.f2246c.i(iV & 1048575, obj), k0Var, false);
                    break;
                case com.google.protobuf.x0.FEATURES_FIELD_NUMBER /* 21 */:
                    b1.P(iArr[i2], (List) m1.f2246c.i(iV & 1048575, obj), k0Var, false);
                    break;
                case com.google.protobuf.x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
                    b1.G(iArr[i2], (List) m1.f2246c.i(iV & 1048575, obj), k0Var, false);
                    break;
                case com.google.protobuf.a1.DEPRECATED_FIELD_NUMBER /* 23 */:
                    b1.D(iArr[i2], (List) m1.f2246c.i(iV & 1048575, obj), k0Var, false);
                    break;
                case 24:
                    b1.C(iArr[i2], (List) m1.f2246c.i(iV & 1048575, obj), k0Var, false);
                    break;
                case 25:
                    b1.y(iArr[i2], (List) m1.f2246c.i(iV & 1048575, obj), k0Var, false);
                    break;
                case 26:
                    b1.N(iArr[i2], (List) m1.f2246c.i(iV & 1048575, obj), k0Var);
                    break;
                case com.google.protobuf.a1.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                    b1.I(iArr[i2], (List) m1.f2246c.i(iV & 1048575, obj), k0Var, p(i2));
                    break;
                case 28:
                    b1.z(iArr[i2], (List) m1.f2246c.i(iV & 1048575, obj), k0Var);
                    break;
                case 29:
                    b1.O(iArr[i2], (List) m1.f2246c.i(iV & 1048575, obj), k0Var, false);
                    break;
                case 30:
                    b1.B(iArr[i2], (List) m1.f2246c.i(iV & 1048575, obj), k0Var, false);
                    break;
                case com.google.protobuf.a1.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
                    b1.J(iArr[i2], (List) m1.f2246c.i(iV & 1048575, obj), k0Var, false);
                    break;
                case 32:
                    b1.K(iArr[i2], (List) m1.f2246c.i(iV & 1048575, obj), k0Var, false);
                    break;
                case 33:
                    b1.L(iArr[i2], (List) m1.f2246c.i(iV & 1048575, obj), k0Var, false);
                    break;
                case 34:
                    b1.M(iArr[i2], (List) m1.f2246c.i(iV & 1048575, obj), k0Var, false);
                    break;
                case com.google.protobuf.g1.FEATURES_FIELD_NUMBER /* 35 */:
                    b1.A(iArr[i2], (List) m1.f2246c.i(iV & 1048575, obj), k0Var, true);
                    break;
                case com.google.protobuf.a1.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
                    b1.E(iArr[i2], (List) m1.f2246c.i(iV & 1048575, obj), k0Var, true);
                    break;
                case com.google.protobuf.a1.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
                    b1.H(iArr[i2], (List) m1.f2246c.i(iV & 1048575, obj), k0Var, true);
                    break;
                case 38:
                    b1.P(iArr[i2], (List) m1.f2246c.i(iV & 1048575, obj), k0Var, true);
                    break;
                case com.google.protobuf.a1.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
                    b1.G(iArr[i2], (List) m1.f2246c.i(iV & 1048575, obj), k0Var, true);
                    break;
                case com.google.protobuf.a1.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
                    b1.D(iArr[i2], (List) m1.f2246c.i(iV & 1048575, obj), k0Var, true);
                    break;
                case com.google.protobuf.a1.PHP_NAMESPACE_FIELD_NUMBER /* 41 */:
                    b1.C(iArr[i2], (List) m1.f2246c.i(iV & 1048575, obj), k0Var, true);
                    break;
                case 42:
                    b1.y(iArr[i2], (List) m1.f2246c.i(iV & 1048575, obj), k0Var, true);
                    break;
                case 43:
                    b1.O(iArr[i2], (List) m1.f2246c.i(iV & 1048575, obj), k0Var, true);
                    break;
                case com.google.protobuf.a1.PHP_METADATA_NAMESPACE_FIELD_NUMBER /* 44 */:
                    b1.B(iArr[i2], (List) m1.f2246c.i(iV & 1048575, obj), k0Var, true);
                    break;
                case com.google.protobuf.a1.RUBY_PACKAGE_FIELD_NUMBER /* 45 */:
                    b1.J(iArr[i2], (List) m1.f2246c.i(iV & 1048575, obj), k0Var, true);
                    break;
                case 46:
                    b1.K(iArr[i2], (List) m1.f2246c.i(iV & 1048575, obj), k0Var, true);
                    break;
                case 47:
                    b1.L(iArr[i2], (List) m1.f2246c.i(iV & 1048575, obj), k0Var, true);
                    break;
                case 48:
                    b1.M(iArr[i2], (List) m1.f2246c.i(iV & 1048575, obj), k0Var, true);
                    break;
                case 49:
                    b1.F(iArr[i2], (List) m1.f2246c.i(iV & 1048575, obj), k0Var, p(i2));
                    break;
                case 50:
                    if (m1.f2246c.i(iV & 1048575, obj) != null) {
                        Object objO = o(i2);
                        this.f2280n.getClass();
                        a1.a.t(objO);
                        throw null;
                    }
                    break;
                case 51:
                    if (u(i10, i2, obj)) {
                        double dDoubleValue = ((Double) m1.f2246c.i(iV & 1048575, obj)).doubleValue();
                        kVar.getClass();
                        kVar.e0(i10, Double.doubleToRawLongBits(dDoubleValue));
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (u(i10, i2, obj)) {
                        float fFloatValue = ((Float) m1.f2246c.i(iV & 1048575, obj)).floatValue();
                        kVar.getClass();
                        kVar.c0(i10, Float.floatToRawIntBits(fFloatValue));
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (u(i10, i2, obj)) {
                        kVar.j0(i10, F(iV & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (u(i10, i2, obj)) {
                        kVar.j0(i10, F(iV & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (u(i10, i2, obj)) {
                        int iE = E(iV & 1048575, obj);
                        kVar.h0(i10, 0);
                        kVar.g0(iE);
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (u(i10, i2, obj)) {
                        kVar.e0(i10, F(iV & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (u(i10, i2, obj)) {
                        kVar.c0(i10, E(iV & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (u(i10, i2, obj)) {
                        boolean zBooleanValue = ((Boolean) m1.f2246c.i(iV & 1048575, obj)).booleanValue();
                        kVar.h0(i10, 0);
                        kVar.a0(zBooleanValue ? (byte) 1 : (byte) 0);
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (u(i10, i2, obj)) {
                        X(i10, m1.f2246c.i(iV & 1048575, obj), k0Var);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (u(i10, i2, obj)) {
                        k0Var.c(i10, m1.f2246c.i(iV & 1048575, obj), p(i2));
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (u(i10, i2, obj)) {
                        k0Var.a(i10, (h) m1.f2246c.i(iV & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (u(i10, i2, obj)) {
                        int iE2 = E(iV & 1048575, obj);
                        kVar.h0(i10, 0);
                        kVar.i0(iE2);
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (u(i10, i2, obj)) {
                        int iE3 = E(iV & 1048575, obj);
                        kVar.h0(i10, 0);
                        kVar.g0(iE3);
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (u(i10, i2, obj)) {
                        kVar.c0(i10, E(iV & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (u(i10, i2, obj)) {
                        kVar.e0(i10, F(iV & 1048575, obj));
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (u(i10, i2, obj)) {
                        int iE4 = E(iV & 1048575, obj);
                        kVar.h0(i10, 0);
                        kVar.i0((iE4 >> 31) ^ (iE4 << 1));
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (u(i10, i2, obj)) {
                        long jF = F(iV & 1048575, obj);
                        kVar.j0(i10, (jF >> 63) ^ (jF << 1));
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (u(i10, i2, obj)) {
                        k0Var.b(i10, m1.f2246c.i(iV & 1048575, obj), p(i2));
                        break;
                    } else {
                        break;
                    }
            }
        }
        this.f2279m.getClass();
        ((v) obj).unknownFields.e(k0Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00e1 A[PHI: r3
      0x00e1: PHI (r3v32 int) = (r3v10 int), (r3v33 int) binds: [B:83:0x0216, B:41:0x00df] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.crypto.tink.shaded.protobuf.a1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int i(com.google.crypto.tink.shaded.protobuf.v r12) {
        /*
            Method dump skipped, instructions count: 794
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.r0.i(com.google.crypto.tink.shaded.protobuf.v):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:147:0x063a A[Catch: all -> 0x0468, TryCatch #6 {all -> 0x0468, blocks: (B:145:0x0635, B:147:0x063a, B:148:0x063f, B:115:0x045c, B:120:0x0470, B:121:0x048c, B:122:0x04a9, B:123:0x04c6, B:124:0x04e5, B:125:0x0501, B:126:0x0516, B:127:0x0531, B:128:0x053e, B:129:0x055c, B:130:0x0579, B:131:0x0596, B:132:0x05b2, B:133:0x05ce, B:134:0x05ea, B:135:0x0608, B:139:0x0626), top: B:174:0x0635 }] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0661 A[LOOP:3: B:158:0x065f->B:159:0x0661, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x066b  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0645 A[SYNTHETIC] */
    @Override // com.google.crypto.tink.shaded.protobuf.a1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j(java.lang.Object r20, androidx.datastore.preferences.protobuf.k r21, com.google.crypto.tink.shaded.protobuf.n r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1794
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.r0.j(java.lang.Object, androidx.datastore.preferences.protobuf.k, com.google.crypto.tink.shaded.protobuf.n):void");
    }

    public final boolean k(v vVar, v vVar2, int i2) {
        return s(i2, vVar) == s(i2, vVar2);
    }

    public final void m(int i2, Object obj, Object obj2) {
        int i10 = this.f2267a[i2];
        if (m1.f2246c.i(V(i2) & 1048575, obj) == null) {
            return;
        }
        n(i2);
    }

    public final void n(int i2) {
        if (this.f2268b[((i2 / 3) * 2) + 1] != null) {
            throw new ClassCastException();
        }
    }

    public final Object o(int i2) {
        return this.f2268b[(i2 / 3) * 2];
    }

    public final a1 p(int i2) {
        int i10 = (i2 / 3) * 2;
        Object[] objArr = this.f2268b;
        a1 a1Var = (a1) objArr[i10];
        if (a1Var != null) {
            return a1Var;
        }
        a1 a1VarA = x0.f2290c.a((Class) objArr[i10 + 1]);
        objArr[i10] = a1VarA;
        return a1VarA;
    }

    public final int q(v vVar) {
        int i2;
        int iX;
        int iZ;
        int iX2;
        int iV;
        int iT;
        int iX3;
        int iW;
        int iV2;
        int iU;
        Unsafe unsafe = f2266p;
        int i10 = 1048575;
        int i11 = 1048575;
        int i12 = 0;
        int iU2 = 0;
        int i13 = 0;
        while (true) {
            int[] iArr = this.f2267a;
            if (i12 >= iArr.length) {
                this.f2279m.getClass();
                return vVar.unknownFields.b() + iU2;
            }
            int iV3 = V(i12);
            int i14 = iArr[i12];
            int iU3 = U(iV3);
            if (iU3 <= 17) {
                int i15 = iArr[i12 + 2];
                int i16 = i15 & i10;
                i2 = 1 << (i15 >>> 20);
                if (i16 != i11) {
                    i13 = unsafe.getInt(vVar, i16);
                    i11 = i16;
                }
            } else {
                i2 = 0;
            }
            long j2 = iV3 & i10;
            switch (iU3) {
                case 0:
                    if ((i13 & i2) != 0) {
                        iU2 = a1.a.u(i14, 8, iU2);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if ((i13 & i2) != 0) {
                        iU2 = a1.a.u(i14, 4, iU2);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if ((i2 & i13) != 0) {
                        long j4 = unsafe.getLong(vVar, j2);
                        iX = k.X(i14);
                        iZ = k.Z(j4);
                        iT = iZ + iX;
                        iU2 += iT;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if ((i2 & i13) != 0) {
                        long j10 = unsafe.getLong(vVar, j2);
                        iX = k.X(i14);
                        iZ = k.Z(j10);
                        iT = iZ + iX;
                        iU2 += iT;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if ((i2 & i13) != 0) {
                        int i17 = unsafe.getInt(vVar, j2);
                        iX2 = k.X(i14);
                        iV = k.V(i17);
                        iT = iV + iX2;
                        iU2 += iT;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if ((i13 & i2) != 0) {
                        iT = k.T(i14);
                        iU2 += iT;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if ((i13 & i2) != 0) {
                        iT = k.S(i14);
                        iU2 += iT;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if ((i13 & i2) != 0) {
                        iU2 = a1.a.u(i14, 1, iU2);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if ((i2 & i13) == 0) {
                        break;
                    } else {
                        Object object = unsafe.getObject(vVar, j2);
                        if (object instanceof h) {
                            int iX4 = k.X(i14);
                            int size = ((h) object).size();
                            iV2 = a1.a.v(size, size, iX4, iU2);
                            iU2 = iV2;
                            break;
                        } else {
                            iX3 = k.X(i14);
                            iW = k.W((String) object);
                            iV2 = iW + iX3 + iU2;
                            iU2 = iV2;
                        }
                    }
                case 9:
                    if ((i2 & i13) != 0) {
                        Object object2 = unsafe.getObject(vVar, j2);
                        a1 a1VarP = p(i12);
                        Class cls = b1.f2178a;
                        int iX5 = k.X(i14);
                        int iA = ((a) object2).a(a1VarP);
                        iU2 = a1.a.v(iA, iA, iX5, iU2);
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if ((i2 & i13) != 0) {
                        iT = k.Q(i14, (h) unsafe.getObject(vVar, j2));
                        iU2 += iT;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if ((i2 & i13) != 0) {
                        int i18 = unsafe.getInt(vVar, j2);
                        iX2 = k.X(i14);
                        iV = k.Y(i18);
                        iT = iV + iX2;
                        iU2 += iT;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if ((i2 & i13) != 0) {
                        int i19 = unsafe.getInt(vVar, j2);
                        iX2 = k.X(i14);
                        iV = k.V(i19);
                        iT = iV + iX2;
                        iU2 += iT;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if ((i13 & i2) != 0) {
                        iU2 = a1.a.u(i14, 4, iU2);
                        break;
                    } else {
                        break;
                    }
                case com.google.protobuf.y0.EDITION_FIELD_NUMBER /* 14 */:
                    if ((i13 & i2) != 0) {
                        iU2 = a1.a.u(i14, 8, iU2);
                        break;
                    } else {
                        break;
                    }
                case com.google.protobuf.x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                    if ((i2 & i13) != 0) {
                        int i20 = unsafe.getInt(vVar, j2);
                        iX2 = k.X(i14);
                        iV = k.Y((i20 >> 31) ^ (i20 << 1));
                        iT = iV + iX2;
                        iU2 += iT;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if ((i2 & i13) != 0) {
                        long j11 = unsafe.getLong(vVar, j2);
                        iX = k.X(i14);
                        iZ = k.Z((j11 >> 63) ^ (j11 << 1));
                        iT = iZ + iX;
                        iU2 += iT;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if ((i2 & i13) != 0) {
                        iT = k.U(i14, (a) unsafe.getObject(vVar, j2), p(i12));
                        iU2 += iT;
                        break;
                    } else {
                        break;
                    }
                case com.google.protobuf.a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
                    iT = b1.f(i14, (List) unsafe.getObject(vVar, j2));
                    iU2 += iT;
                    break;
                case com.google.protobuf.x0.TARGETS_FIELD_NUMBER /* 19 */:
                    iT = b1.d(i14, (List) unsafe.getObject(vVar, j2));
                    iU2 += iT;
                    break;
                case 20:
                    iT = b1.j(i14, (List) unsafe.getObject(vVar, j2));
                    iU2 += iT;
                    break;
                case com.google.protobuf.x0.FEATURES_FIELD_NUMBER /* 21 */:
                    iT = b1.t(i14, (List) unsafe.getObject(vVar, j2));
                    iU2 += iT;
                    break;
                case com.google.protobuf.x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
                    iT = b1.h(i14, (List) unsafe.getObject(vVar, j2));
                    iU2 += iT;
                    break;
                case com.google.protobuf.a1.DEPRECATED_FIELD_NUMBER /* 23 */:
                    iT = b1.f(i14, (List) unsafe.getObject(vVar, j2));
                    iU2 += iT;
                    break;
                case 24:
                    iT = b1.d(i14, (List) unsafe.getObject(vVar, j2));
                    iU2 += iT;
                    break;
                case 25:
                    List list = (List) unsafe.getObject(vVar, j2);
                    Class cls2 = b1.f2178a;
                    int size2 = list.size();
                    iU2 += size2 == 0 ? 0 : (k.X(i14) + 1) * size2;
                    break;
                case 26:
                    iT = b1.q(i14, (List) unsafe.getObject(vVar, j2));
                    iU2 += iT;
                    break;
                case com.google.protobuf.a1.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                    iT = b1.l(i14, (List) unsafe.getObject(vVar, j2), p(i12));
                    iU2 += iT;
                    break;
                case 28:
                    iT = b1.a(i14, (List) unsafe.getObject(vVar, j2));
                    iU2 += iT;
                    break;
                case 29:
                    iT = b1.r(i14, (List) unsafe.getObject(vVar, j2));
                    iU2 += iT;
                    break;
                case 30:
                    iT = b1.b(i14, (List) unsafe.getObject(vVar, j2));
                    iU2 += iT;
                    break;
                case com.google.protobuf.a1.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
                    iT = b1.d(i14, (List) unsafe.getObject(vVar, j2));
                    iU2 += iT;
                    break;
                case 32:
                    iT = b1.f(i14, (List) unsafe.getObject(vVar, j2));
                    iU2 += iT;
                    break;
                case 33:
                    iT = b1.m(i14, (List) unsafe.getObject(vVar, j2));
                    iU2 += iT;
                    break;
                case 34:
                    iT = b1.o(i14, (List) unsafe.getObject(vVar, j2));
                    iU2 += iT;
                    break;
                case com.google.protobuf.g1.FEATURES_FIELD_NUMBER /* 35 */:
                    int iG = b1.g((List) unsafe.getObject(vVar, j2));
                    if (iG > 0) {
                        iU2 = a1.a.v(iG, k.X(i14), iG, iU2);
                        break;
                    } else {
                        break;
                    }
                case com.google.protobuf.a1.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
                    int iE = b1.e((List) unsafe.getObject(vVar, j2));
                    if (iE > 0) {
                        iU2 = a1.a.v(iE, k.X(i14), iE, iU2);
                        break;
                    } else {
                        break;
                    }
                case com.google.protobuf.a1.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
                    int iK = b1.k((List) unsafe.getObject(vVar, j2));
                    if (iK > 0) {
                        iU2 = a1.a.v(iK, k.X(i14), iK, iU2);
                        break;
                    } else {
                        break;
                    }
                case 38:
                    int iU4 = b1.u((List) unsafe.getObject(vVar, j2));
                    if (iU4 > 0) {
                        iU2 = a1.a.v(iU4, k.X(i14), iU4, iU2);
                        break;
                    } else {
                        break;
                    }
                case com.google.protobuf.a1.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
                    int i21 = b1.i((List) unsafe.getObject(vVar, j2));
                    if (i21 > 0) {
                        iU2 = a1.a.v(i21, k.X(i14), i21, iU2);
                        break;
                    } else {
                        break;
                    }
                case com.google.protobuf.a1.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
                    int iG2 = b1.g((List) unsafe.getObject(vVar, j2));
                    if (iG2 > 0) {
                        iU2 = a1.a.v(iG2, k.X(i14), iG2, iU2);
                        break;
                    } else {
                        break;
                    }
                case com.google.protobuf.a1.PHP_NAMESPACE_FIELD_NUMBER /* 41 */:
                    int iE2 = b1.e((List) unsafe.getObject(vVar, j2));
                    if (iE2 > 0) {
                        iU2 = a1.a.v(iE2, k.X(i14), iE2, iU2);
                        break;
                    } else {
                        break;
                    }
                case 42:
                    List list2 = (List) unsafe.getObject(vVar, j2);
                    Class cls3 = b1.f2178a;
                    int size3 = list2.size();
                    if (size3 > 0) {
                        iU2 = a1.a.v(size3, k.X(i14), size3, iU2);
                        break;
                    } else {
                        break;
                    }
                case 43:
                    int iS = b1.s((List) unsafe.getObject(vVar, j2));
                    if (iS > 0) {
                        iU2 = a1.a.v(iS, k.X(i14), iS, iU2);
                        break;
                    } else {
                        break;
                    }
                case com.google.protobuf.a1.PHP_METADATA_NAMESPACE_FIELD_NUMBER /* 44 */:
                    int iC = b1.c((List) unsafe.getObject(vVar, j2));
                    if (iC > 0) {
                        iU2 = a1.a.v(iC, k.X(i14), iC, iU2);
                        break;
                    } else {
                        break;
                    }
                case com.google.protobuf.a1.RUBY_PACKAGE_FIELD_NUMBER /* 45 */:
                    int iE3 = b1.e((List) unsafe.getObject(vVar, j2));
                    if (iE3 > 0) {
                        iU2 = a1.a.v(iE3, k.X(i14), iE3, iU2);
                        break;
                    } else {
                        break;
                    }
                case 46:
                    int iG3 = b1.g((List) unsafe.getObject(vVar, j2));
                    if (iG3 > 0) {
                        iU2 = a1.a.v(iG3, k.X(i14), iG3, iU2);
                        break;
                    } else {
                        break;
                    }
                case 47:
                    int iN = b1.n((List) unsafe.getObject(vVar, j2));
                    if (iN > 0) {
                        iU2 = a1.a.v(iN, k.X(i14), iN, iU2);
                        break;
                    } else {
                        break;
                    }
                case 48:
                    int iP = b1.p((List) unsafe.getObject(vVar, j2));
                    if (iP > 0) {
                        iU2 = a1.a.v(iP, k.X(i14), iP, iU2);
                        break;
                    } else {
                        break;
                    }
                case 49:
                    List list3 = (List) unsafe.getObject(vVar, j2);
                    a1 a1VarP2 = p(i12);
                    Class cls4 = b1.f2178a;
                    int size4 = list3.size();
                    if (size4 == 0) {
                        iU = 0;
                    } else {
                        iU = 0;
                        for (int i22 = 0; i22 < size4; i22++) {
                            iU += k.U(i14, (a) list3.get(i22), a1VarP2);
                        }
                    }
                    iU2 += iU;
                    break;
                case 50:
                    Object object3 = unsafe.getObject(vVar, j2);
                    Object objO = o(i12);
                    this.f2280n.getClass();
                    m0.a(object3, objO);
                    break;
                case 51:
                    if (u(i14, i12, vVar)) {
                        iU2 = a1.a.u(i14, 8, iU2);
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (u(i14, i12, vVar)) {
                        iU2 = a1.a.u(i14, 4, iU2);
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (u(i14, i12, vVar)) {
                        long jF = F(j2, vVar);
                        iX = k.X(i14);
                        iZ = k.Z(jF);
                        iT = iZ + iX;
                        iU2 += iT;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (u(i14, i12, vVar)) {
                        long jF2 = F(j2, vVar);
                        iX = k.X(i14);
                        iZ = k.Z(jF2);
                        iT = iZ + iX;
                        iU2 += iT;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (u(i14, i12, vVar)) {
                        int iE4 = E(j2, vVar);
                        iX2 = k.X(i14);
                        iV = k.V(iE4);
                        iT = iV + iX2;
                        iU2 += iT;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (u(i14, i12, vVar)) {
                        iT = k.T(i14);
                        iU2 += iT;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (u(i14, i12, vVar)) {
                        iT = k.S(i14);
                        iU2 += iT;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (u(i14, i12, vVar)) {
                        iU2 = a1.a.u(i14, 1, iU2);
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (!u(i14, i12, vVar)) {
                        break;
                    } else {
                        Object object4 = unsafe.getObject(vVar, j2);
                        if (object4 instanceof h) {
                            int iX6 = k.X(i14);
                            int size5 = ((h) object4).size();
                            iV2 = a1.a.v(size5, size5, iX6, iU2);
                            iU2 = iV2;
                            break;
                        } else {
                            iX3 = k.X(i14);
                            iW = k.W((String) object4);
                            iV2 = iW + iX3 + iU2;
                            iU2 = iV2;
                        }
                    }
                case 60:
                    if (u(i14, i12, vVar)) {
                        Object object5 = unsafe.getObject(vVar, j2);
                        a1 a1VarP3 = p(i12);
                        Class cls5 = b1.f2178a;
                        int iX7 = k.X(i14);
                        int iA2 = ((a) object5).a(a1VarP3);
                        iU2 = a1.a.v(iA2, iA2, iX7, iU2);
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (u(i14, i12, vVar)) {
                        iT = k.Q(i14, (h) unsafe.getObject(vVar, j2));
                        iU2 += iT;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (u(i14, i12, vVar)) {
                        int iE5 = E(j2, vVar);
                        iX2 = k.X(i14);
                        iV = k.Y(iE5);
                        iT = iV + iX2;
                        iU2 += iT;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (u(i14, i12, vVar)) {
                        int iE6 = E(j2, vVar);
                        iX2 = k.X(i14);
                        iV = k.V(iE6);
                        iT = iV + iX2;
                        iU2 += iT;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (u(i14, i12, vVar)) {
                        iU2 = a1.a.u(i14, 4, iU2);
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (u(i14, i12, vVar)) {
                        iU2 = a1.a.u(i14, 8, iU2);
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (u(i14, i12, vVar)) {
                        int iE7 = E(j2, vVar);
                        iX2 = k.X(i14);
                        iV = k.Y((iE7 >> 31) ^ (iE7 << 1));
                        iT = iV + iX2;
                        iU2 += iT;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (u(i14, i12, vVar)) {
                        long jF3 = F(j2, vVar);
                        iX = k.X(i14);
                        iZ = k.Z((jF3 >> 63) ^ (jF3 << 1));
                        iT = iZ + iX;
                        iU2 += iT;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (u(i14, i12, vVar)) {
                        iT = k.U(i14, (a) unsafe.getObject(vVar, j2), p(i12));
                        iU2 += iT;
                        break;
                    } else {
                        break;
                    }
            }
            i12 += 3;
            i10 = 1048575;
        }
    }

    public final int r(v vVar) {
        int iX;
        int iZ;
        int iX2;
        int iV;
        int iT;
        int iX3;
        int iW;
        int iX4;
        int iZ2;
        int iU;
        Unsafe unsafe = f2266p;
        int i2 = 0;
        int iU2 = 0;
        while (true) {
            int[] iArr = this.f2267a;
            if (i2 >= iArr.length) {
                this.f2279m.getClass();
                return vVar.unknownFields.b() + iU2;
            }
            int iV2 = V(i2);
            int iU3 = U(iV2);
            int i10 = iArr[i2];
            long j2 = iV2 & 1048575;
            if (iU3 >= q.f2259g.f2263f && iU3 <= q.f2260h.f2263f) {
                int i11 = iArr[i2 + 2];
            }
            switch (iU3) {
                case 0:
                    if (s(i2, vVar)) {
                        iU2 = a1.a.u(i10, 8, iU2);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (s(i2, vVar)) {
                        iU2 = a1.a.u(i10, 4, iU2);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (s(i2, vVar)) {
                        long jH = m1.f2246c.h(j2, vVar);
                        iX = k.X(i10);
                        iZ = k.Z(jH);
                        iT = iZ + iX;
                        iU2 += iT;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (s(i2, vVar)) {
                        long jH2 = m1.f2246c.h(j2, vVar);
                        iX = k.X(i10);
                        iZ = k.Z(jH2);
                        iT = iZ + iX;
                        iU2 += iT;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (s(i2, vVar)) {
                        int iG = m1.f2246c.g(j2, vVar);
                        iX2 = k.X(i10);
                        iV = k.V(iG);
                        iT = iV + iX2;
                        iU2 += iT;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (s(i2, vVar)) {
                        iT = k.T(i10);
                        iU2 += iT;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (s(i2, vVar)) {
                        iT = k.S(i10);
                        iU2 += iT;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (s(i2, vVar)) {
                        iU2 = a1.a.u(i10, 1, iU2);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (s(i2, vVar)) {
                        Object objI = m1.f2246c.i(j2, vVar);
                        if (objI instanceof h) {
                            int iX5 = k.X(i10);
                            int size = ((h) objI).size();
                            iU2 = a1.a.v(size, size, iX5, iU2);
                            break;
                        } else {
                            iX3 = k.X(i10);
                            iW = k.W((String) objI);
                            iU2 = iW + iX3 + iU2;
                            break;
                        }
                    } else {
                        break;
                    }
                case 9:
                    if (s(i2, vVar)) {
                        Object objI2 = m1.f2246c.i(j2, vVar);
                        a1 a1VarP = p(i2);
                        Class cls = b1.f2178a;
                        int iX6 = k.X(i10);
                        int iA = ((a) objI2).a(a1VarP);
                        iU2 = a1.a.v(iA, iA, iX6, iU2);
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (s(i2, vVar)) {
                        iT = k.Q(i10, (h) m1.f2246c.i(j2, vVar));
                        iU2 += iT;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (s(i2, vVar)) {
                        int iG2 = m1.f2246c.g(j2, vVar);
                        iX2 = k.X(i10);
                        iV = k.Y(iG2);
                        iT = iV + iX2;
                        iU2 += iT;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (s(i2, vVar)) {
                        int iG3 = m1.f2246c.g(j2, vVar);
                        iX2 = k.X(i10);
                        iV = k.V(iG3);
                        iT = iV + iX2;
                        iU2 += iT;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (s(i2, vVar)) {
                        iU2 = a1.a.u(i10, 4, iU2);
                        break;
                    } else {
                        break;
                    }
                case com.google.protobuf.y0.EDITION_FIELD_NUMBER /* 14 */:
                    if (s(i2, vVar)) {
                        iU2 = a1.a.u(i10, 8, iU2);
                        break;
                    } else {
                        break;
                    }
                case com.google.protobuf.x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                    if (s(i2, vVar)) {
                        int iG4 = m1.f2246c.g(j2, vVar);
                        iX2 = k.X(i10);
                        iV = k.Y((iG4 >> 31) ^ (iG4 << 1));
                        iT = iV + iX2;
                        iU2 += iT;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (s(i2, vVar)) {
                        long jH3 = m1.f2246c.h(j2, vVar);
                        iX4 = k.X(i10);
                        iZ2 = k.Z((jH3 >> 63) ^ (jH3 << 1));
                        iT = iZ2 + iX4;
                        iU2 += iT;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (s(i2, vVar)) {
                        iT = k.U(i10, (a) m1.f2246c.i(j2, vVar), p(i2));
                        iU2 += iT;
                        break;
                    } else {
                        break;
                    }
                case com.google.protobuf.a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
                    iT = b1.f(i10, v(vVar, j2));
                    iU2 += iT;
                    break;
                case com.google.protobuf.x0.TARGETS_FIELD_NUMBER /* 19 */:
                    iT = b1.d(i10, v(vVar, j2));
                    iU2 += iT;
                    break;
                case 20:
                    iT = b1.j(i10, v(vVar, j2));
                    iU2 += iT;
                    break;
                case com.google.protobuf.x0.FEATURES_FIELD_NUMBER /* 21 */:
                    iT = b1.t(i10, v(vVar, j2));
                    iU2 += iT;
                    break;
                case com.google.protobuf.x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
                    iT = b1.h(i10, v(vVar, j2));
                    iU2 += iT;
                    break;
                case com.google.protobuf.a1.DEPRECATED_FIELD_NUMBER /* 23 */:
                    iT = b1.f(i10, v(vVar, j2));
                    iU2 += iT;
                    break;
                case 24:
                    iT = b1.d(i10, v(vVar, j2));
                    iU2 += iT;
                    break;
                case 25:
                    List listV = v(vVar, j2);
                    Class cls2 = b1.f2178a;
                    int size2 = listV.size();
                    iU2 += size2 == 0 ? 0 : (k.X(i10) + 1) * size2;
                    break;
                case 26:
                    iT = b1.q(i10, v(vVar, j2));
                    iU2 += iT;
                    break;
                case com.google.protobuf.a1.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                    iT = b1.l(i10, v(vVar, j2), p(i2));
                    iU2 += iT;
                    break;
                case 28:
                    iT = b1.a(i10, v(vVar, j2));
                    iU2 += iT;
                    break;
                case 29:
                    iT = b1.r(i10, v(vVar, j2));
                    iU2 += iT;
                    break;
                case 30:
                    iT = b1.b(i10, v(vVar, j2));
                    iU2 += iT;
                    break;
                case com.google.protobuf.a1.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
                    iT = b1.d(i10, v(vVar, j2));
                    iU2 += iT;
                    break;
                case 32:
                    iT = b1.f(i10, v(vVar, j2));
                    iU2 += iT;
                    break;
                case 33:
                    iT = b1.m(i10, v(vVar, j2));
                    iU2 += iT;
                    break;
                case 34:
                    iT = b1.o(i10, v(vVar, j2));
                    iU2 += iT;
                    break;
                case com.google.protobuf.g1.FEATURES_FIELD_NUMBER /* 35 */:
                    int iG5 = b1.g((List) unsafe.getObject(vVar, j2));
                    if (iG5 > 0) {
                        iU2 = a1.a.v(iG5, k.X(i10), iG5, iU2);
                        break;
                    } else {
                        break;
                    }
                case com.google.protobuf.a1.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
                    int iE = b1.e((List) unsafe.getObject(vVar, j2));
                    if (iE > 0) {
                        iU2 = a1.a.v(iE, k.X(i10), iE, iU2);
                        break;
                    } else {
                        break;
                    }
                case com.google.protobuf.a1.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
                    int iK = b1.k((List) unsafe.getObject(vVar, j2));
                    if (iK > 0) {
                        iU2 = a1.a.v(iK, k.X(i10), iK, iU2);
                        break;
                    } else {
                        break;
                    }
                case 38:
                    int iU4 = b1.u((List) unsafe.getObject(vVar, j2));
                    if (iU4 > 0) {
                        iU2 = a1.a.v(iU4, k.X(i10), iU4, iU2);
                        break;
                    } else {
                        break;
                    }
                case com.google.protobuf.a1.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
                    int i12 = b1.i((List) unsafe.getObject(vVar, j2));
                    if (i12 > 0) {
                        iU2 = a1.a.v(i12, k.X(i10), i12, iU2);
                        break;
                    } else {
                        break;
                    }
                case com.google.protobuf.a1.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
                    int iG6 = b1.g((List) unsafe.getObject(vVar, j2));
                    if (iG6 > 0) {
                        iU2 = a1.a.v(iG6, k.X(i10), iG6, iU2);
                        break;
                    } else {
                        break;
                    }
                case com.google.protobuf.a1.PHP_NAMESPACE_FIELD_NUMBER /* 41 */:
                    int iE2 = b1.e((List) unsafe.getObject(vVar, j2));
                    if (iE2 > 0) {
                        iU2 = a1.a.v(iE2, k.X(i10), iE2, iU2);
                        break;
                    } else {
                        break;
                    }
                case 42:
                    List list = (List) unsafe.getObject(vVar, j2);
                    Class cls3 = b1.f2178a;
                    int size3 = list.size();
                    if (size3 > 0) {
                        iU2 = a1.a.v(size3, k.X(i10), size3, iU2);
                        break;
                    } else {
                        break;
                    }
                case 43:
                    int iS = b1.s((List) unsafe.getObject(vVar, j2));
                    if (iS > 0) {
                        iU2 = a1.a.v(iS, k.X(i10), iS, iU2);
                        break;
                    } else {
                        break;
                    }
                case com.google.protobuf.a1.PHP_METADATA_NAMESPACE_FIELD_NUMBER /* 44 */:
                    int iC = b1.c((List) unsafe.getObject(vVar, j2));
                    if (iC > 0) {
                        iU2 = a1.a.v(iC, k.X(i10), iC, iU2);
                        break;
                    } else {
                        break;
                    }
                case com.google.protobuf.a1.RUBY_PACKAGE_FIELD_NUMBER /* 45 */:
                    int iE3 = b1.e((List) unsafe.getObject(vVar, j2));
                    if (iE3 > 0) {
                        iU2 = a1.a.v(iE3, k.X(i10), iE3, iU2);
                        break;
                    } else {
                        break;
                    }
                case 46:
                    int iG7 = b1.g((List) unsafe.getObject(vVar, j2));
                    if (iG7 > 0) {
                        iU2 = a1.a.v(iG7, k.X(i10), iG7, iU2);
                        break;
                    } else {
                        break;
                    }
                case 47:
                    int iN = b1.n((List) unsafe.getObject(vVar, j2));
                    if (iN > 0) {
                        iU2 = a1.a.v(iN, k.X(i10), iN, iU2);
                        break;
                    } else {
                        break;
                    }
                case 48:
                    int iP = b1.p((List) unsafe.getObject(vVar, j2));
                    if (iP > 0) {
                        iU2 = a1.a.v(iP, k.X(i10), iP, iU2);
                        break;
                    } else {
                        break;
                    }
                case 49:
                    List listV2 = v(vVar, j2);
                    a1 a1VarP2 = p(i2);
                    Class cls4 = b1.f2178a;
                    int size4 = listV2.size();
                    if (size4 == 0) {
                        iU = 0;
                    } else {
                        iU = 0;
                        for (int i13 = 0; i13 < size4; i13++) {
                            iU += k.U(i10, (a) listV2.get(i13), a1VarP2);
                        }
                    }
                    iU2 += iU;
                    break;
                case 50:
                    Object objI3 = m1.f2246c.i(j2, vVar);
                    Object objO = o(i2);
                    this.f2280n.getClass();
                    m0.a(objI3, objO);
                    break;
                case 51:
                    if (u(i10, i2, vVar)) {
                        iU2 = a1.a.u(i10, 8, iU2);
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (u(i10, i2, vVar)) {
                        iU2 = a1.a.u(i10, 4, iU2);
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (u(i10, i2, vVar)) {
                        long jF = F(j2, vVar);
                        iX = k.X(i10);
                        iZ = k.Z(jF);
                        iT = iZ + iX;
                        iU2 += iT;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (u(i10, i2, vVar)) {
                        long jF2 = F(j2, vVar);
                        iX = k.X(i10);
                        iZ = k.Z(jF2);
                        iT = iZ + iX;
                        iU2 += iT;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (u(i10, i2, vVar)) {
                        int iE4 = E(j2, vVar);
                        iX2 = k.X(i10);
                        iV = k.V(iE4);
                        iT = iV + iX2;
                        iU2 += iT;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (u(i10, i2, vVar)) {
                        iT = k.T(i10);
                        iU2 += iT;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (u(i10, i2, vVar)) {
                        iT = k.S(i10);
                        iU2 += iT;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (u(i10, i2, vVar)) {
                        iU2 = a1.a.u(i10, 1, iU2);
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (u(i10, i2, vVar)) {
                        Object objI4 = m1.f2246c.i(j2, vVar);
                        if (objI4 instanceof h) {
                            int iX7 = k.X(i10);
                            int size5 = ((h) objI4).size();
                            iU2 = a1.a.v(size5, size5, iX7, iU2);
                            break;
                        } else {
                            iX3 = k.X(i10);
                            iW = k.W((String) objI4);
                            iU2 = iW + iX3 + iU2;
                            break;
                        }
                    } else {
                        break;
                    }
                case 60:
                    if (u(i10, i2, vVar)) {
                        Object objI5 = m1.f2246c.i(j2, vVar);
                        a1 a1VarP3 = p(i2);
                        Class cls5 = b1.f2178a;
                        int iX8 = k.X(i10);
                        int iA2 = ((a) objI5).a(a1VarP3);
                        iU2 = a1.a.v(iA2, iA2, iX8, iU2);
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (u(i10, i2, vVar)) {
                        iT = k.Q(i10, (h) m1.f2246c.i(j2, vVar));
                        iU2 += iT;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (u(i10, i2, vVar)) {
                        int iE5 = E(j2, vVar);
                        iX2 = k.X(i10);
                        iV = k.Y(iE5);
                        iT = iV + iX2;
                        iU2 += iT;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (u(i10, i2, vVar)) {
                        int iE6 = E(j2, vVar);
                        iX2 = k.X(i10);
                        iV = k.V(iE6);
                        iT = iV + iX2;
                        iU2 += iT;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (u(i10, i2, vVar)) {
                        iU2 = a1.a.u(i10, 4, iU2);
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (u(i10, i2, vVar)) {
                        iU2 = a1.a.u(i10, 8, iU2);
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (u(i10, i2, vVar)) {
                        int iE7 = E(j2, vVar);
                        iX2 = k.X(i10);
                        iV = k.Y((iE7 >> 31) ^ (iE7 << 1));
                        iT = iV + iX2;
                        iU2 += iT;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (u(i10, i2, vVar)) {
                        long jF3 = F(j2, vVar);
                        iX4 = k.X(i10);
                        iZ2 = k.Z((jF3 >> 63) ^ (jF3 << 1));
                        iT = iZ2 + iX4;
                        iU2 += iT;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (u(i10, i2, vVar)) {
                        iT = k.U(i10, (a) m1.f2246c.i(j2, vVar), p(i2));
                        iU2 += iT;
                        break;
                    } else {
                        break;
                    }
            }
            i2 += 3;
        }
    }

    public final boolean s(int i2, Object obj) {
        int i10 = this.f2267a[i2 + 2];
        long j2 = i10 & 1048575;
        if (j2 == 1048575) {
            int iV = V(i2);
            long j4 = iV & 1048575;
            switch (U(iV)) {
                case 0:
                    if (Double.doubleToRawLongBits(m1.f2246c.e(j4, obj)) == 0) {
                        return false;
                    }
                    break;
                case 1:
                    if (Float.floatToRawIntBits(m1.f2246c.f(j4, obj)) == 0) {
                        return false;
                    }
                    break;
                case 2:
                    if (m1.f2246c.h(j4, obj) == 0) {
                        return false;
                    }
                    break;
                case 3:
                    if (m1.f2246c.h(j4, obj) == 0) {
                        return false;
                    }
                    break;
                case 4:
                    if (m1.f2246c.g(j4, obj) == 0) {
                        return false;
                    }
                    break;
                case 5:
                    if (m1.f2246c.h(j4, obj) == 0) {
                        return false;
                    }
                    break;
                case 6:
                    if (m1.f2246c.g(j4, obj) == 0) {
                        return false;
                    }
                    break;
                case 7:
                    return m1.f2246c.c(j4, obj);
                case 8:
                    Object objI = m1.f2246c.i(j4, obj);
                    if (objI instanceof String) {
                        return !((String) objI).isEmpty();
                    }
                    if (objI instanceof h) {
                        return !h.f2209g.equals(objI);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    if (m1.f2246c.i(j4, obj) == null) {
                        return false;
                    }
                    break;
                case 10:
                    return !h.f2209g.equals(m1.f2246c.i(j4, obj));
                case 11:
                    if (m1.f2246c.g(j4, obj) == 0) {
                        return false;
                    }
                    break;
                case 12:
                    if (m1.f2246c.g(j4, obj) == 0) {
                        return false;
                    }
                    break;
                case 13:
                    if (m1.f2246c.g(j4, obj) == 0) {
                        return false;
                    }
                    break;
                case com.google.protobuf.y0.EDITION_FIELD_NUMBER /* 14 */:
                    if (m1.f2246c.h(j4, obj) == 0) {
                        return false;
                    }
                    break;
                case com.google.protobuf.x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                    if (m1.f2246c.g(j4, obj) == 0) {
                        return false;
                    }
                    break;
                case 16:
                    if (m1.f2246c.h(j4, obj) == 0) {
                        return false;
                    }
                    break;
                case 17:
                    if (m1.f2246c.i(j4, obj) == null) {
                        return false;
                    }
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        } else if (((1 << (i10 >>> 20)) & m1.f2246c.g(j2, obj)) == 0) {
            return false;
        }
        return true;
    }

    public final boolean u(int i2, int i10, Object obj) {
        return m1.f2246c.g((long) (this.f2267a[i10 + 2] & 1048575), obj) == i2;
    }

    public final void w(int i2, Object obj, Object obj2) {
        long jV = V(i2) & 1048575;
        Object objI = m1.f2246c.i(jV, obj);
        m0 m0Var = this.f2280n;
        if (objI != null) {
            m0Var.getClass();
            if (!((l0) objI).f2241f) {
                l0 l0VarC = l0.f2240g.c();
                m0.b(l0VarC, objI);
                m1.p(jV, obj, l0VarC);
                objI = l0VarC;
            }
        } else {
            m0Var.getClass();
            objI = l0.f2240g.c();
            m1.p(jV, obj, objI);
        }
        m0Var.getClass();
        a1.a.t(obj2);
        throw null;
    }

    public final void x(int i2, Object obj, Object obj2) {
        if (s(i2, obj2)) {
            long jV = V(i2) & 1048575;
            Unsafe unsafe = f2266p;
            Object object = unsafe.getObject(obj2, jV);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.f2267a[i2] + " is present but null: " + obj2);
            }
            a1 a1VarP = p(i2);
            if (!s(i2, obj)) {
                if (t(object)) {
                    Object objD = a1VarP.d();
                    a1VarP.a(objD, object);
                    unsafe.putObject(obj, jV, objD);
                } else {
                    unsafe.putObject(obj, jV, object);
                }
                P(i2, obj);
                return;
            }
            Object object2 = unsafe.getObject(obj, jV);
            if (!t(object2)) {
                Object objD2 = a1VarP.d();
                a1VarP.a(objD2, object2);
                unsafe.putObject(obj, jV, objD2);
                object2 = objD2;
            }
            a1VarP.a(object2, object);
        }
    }

    public final void y(int i2, Object obj, Object obj2) {
        int[] iArr = this.f2267a;
        int i10 = iArr[i2];
        if (u(i10, i2, obj2)) {
            long jV = V(i2) & 1048575;
            Unsafe unsafe = f2266p;
            Object object = unsafe.getObject(obj2, jV);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + iArr[i2] + " is present but null: " + obj2);
            }
            a1 a1VarP = p(i2);
            if (!u(i10, i2, obj)) {
                if (t(object)) {
                    Object objD = a1VarP.d();
                    a1VarP.a(objD, object);
                    unsafe.putObject(obj, jV, objD);
                } else {
                    unsafe.putObject(obj, jV, object);
                }
                Q(i10, i2, obj);
                return;
            }
            Object object2 = unsafe.getObject(obj, jV);
            if (!t(object2)) {
                Object objD2 = a1VarP.d();
                a1VarP.a(objD2, object2);
                unsafe.putObject(obj, jV, objD2);
                object2 = objD2;
            }
            a1VarP.a(object2, object);
        }
    }

    public final Object z(int i2, Object obj) {
        a1 a1VarP = p(i2);
        long jV = V(i2) & 1048575;
        if (!s(i2, obj)) {
            return a1VarP.d();
        }
        Object object = f2266p.getObject(obj, jV);
        if (t(object)) {
            return object;
        }
        Object objD = a1VarP.d();
        if (object != null) {
            a1VarP.a(objD, object);
        }
        return objD;
    }
}
