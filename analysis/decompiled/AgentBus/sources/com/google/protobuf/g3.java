package com.google.protobuf;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* loaded from: classes.dex */
public final class g3 implements t3 {

    /* renamed from: p, reason: collision with root package name */
    public static final int[] f2364p = new int[0];

    /* renamed from: q, reason: collision with root package name */
    public static final Unsafe f2365q = i4.j();

    /* renamed from: a, reason: collision with root package name */
    public final int[] f2366a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f2367b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2368c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2369d;

    /* renamed from: e, reason: collision with root package name */
    public final MessageLite f2370e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f2371f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f2372g;

    /* renamed from: h, reason: collision with root package name */
    public final int[] f2373h;

    /* renamed from: i, reason: collision with root package name */
    public final int f2374i;

    /* renamed from: j, reason: collision with root package name */
    public final int f2375j;

    /* renamed from: k, reason: collision with root package name */
    public final l3 f2376k;

    /* renamed from: l, reason: collision with root package name */
    public final u2 f2377l;

    /* renamed from: m, reason: collision with root package name */
    public final d4 f2378m;

    /* renamed from: n, reason: collision with root package name */
    public final v1 f2379n;

    /* renamed from: o, reason: collision with root package name */
    public final c3 f2380o;

    public g3(int[] iArr, Object[] objArr, int i2, int i10, MessageLite messageLite, int[] iArr2, int i11, int i12, l3 l3Var, u2 u2Var, d4 d4Var, v1 v1Var, c3 c3Var) {
        this.f2366a = iArr;
        this.f2367b = objArr;
        this.f2368c = i2;
        this.f2369d = i10;
        this.f2372g = messageLite instanceof i2;
        this.f2371f = v1Var != null && (messageLite instanceof h2);
        this.f2373h = iArr2;
        this.f2374i = i11;
        this.f2375j = i12;
        this.f2376k = l3Var;
        this.f2377l = u2Var;
        this.f2378m = d4Var;
        this.f2379n = v1Var;
        this.f2370e = messageLite;
        this.f2380o = c3Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:127:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x03a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.protobuf.g3 B(com.google.protobuf.s3 r34, com.google.protobuf.l3 r35, com.google.protobuf.u2 r36, com.google.protobuf.d4 r37, com.google.protobuf.v1 r38, com.google.protobuf.c3 r39) {
        /*
            Method dump skipped, instructions count: 1027
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.g3.B(com.google.protobuf.s3, com.google.protobuf.l3, com.google.protobuf.u2, com.google.protobuf.d4, com.google.protobuf.v1, com.google.protobuf.c3):com.google.protobuf.g3");
    }

    public static long C(int i2) {
        return i2 & 1048575;
    }

    public static int D(long j2, Object obj) {
        return ((Integer) i4.f2400c.i(j2, obj)).intValue();
    }

    public static long E(long j2, Object obj) {
        return ((Long) i4.f2400c.i(j2, obj)).longValue();
    }

    public static Field N(Class cls, String str) {
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

    public static int T(int i2) {
        return (i2 & 267386880) >>> 20;
    }

    public static void l(Object obj) {
        if (u(obj)) {
            return;
        }
        throw new IllegalArgumentException("Mutating immutable message: " + obj);
    }

    public static int m(byte[] bArr, int i2, int i10, s4 s4Var, Class cls, g gVar) throws r2 {
        switch (s4Var.ordinal()) {
            case 0:
                gVar.f2356c = Double.valueOf(Double.longBitsToDouble(a.a.u(i2, bArr)));
                return i2 + 8;
            case 1:
                gVar.f2356c = Float.valueOf(Float.intBitsToFloat(a.a.s(i2, bArr)));
                return i2 + 4;
            case 2:
            case 3:
                int I = a.a.I(bArr, i2, gVar);
                gVar.f2356c = Long.valueOf(gVar.f2355b);
                return I;
            case 4:
            case 12:
            case 13:
                int iE = a.a.E(bArr, i2, gVar);
                gVar.f2356c = Integer.valueOf(gVar.f2354a);
                return iE;
            case 5:
            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                gVar.f2356c = Long.valueOf(a.a.u(i2, bArr));
                return i2 + 8;
            case 6:
            case y0.EDITION_FIELD_NUMBER /* 14 */:
                gVar.f2356c = Integer.valueOf(a.a.s(i2, bArr));
                return i2 + 4;
            case 7:
                int I2 = a.a.I(bArr, i2, gVar);
                gVar.f2356c = Boolean.valueOf(gVar.f2355b != 0);
                return I2;
            case 8:
                int iE2 = a.a.E(bArr, i2, gVar);
                int i11 = gVar.f2354a;
                if (i11 < 0) {
                    throw r2.e();
                }
                if (i11 == 0) {
                    gVar.f2356c = "";
                    return iE2;
                }
                gVar.f2356c = l4.f2432a.q(bArr, iE2, i11);
                return iE2 + i11;
            case 9:
            default:
                throw new RuntimeException("unsupported field type.");
            case 10:
                t3 t3VarA = q3.f2501c.a(cls);
                Object objD = t3VarA.d();
                int iY = a.a.Y(objD, t3VarA, bArr, i2, i10, gVar);
                t3VarA.b(objD);
                gVar.f2356c = objD;
                return iY;
            case 11:
                return a.a.q(bArr, i2, gVar);
            case 16:
                int iE3 = a.a.E(bArr, i2, gVar);
                gVar.f2356c = Integer.valueOf(o.b(gVar.f2354a));
                return iE3;
            case 17:
                int I3 = a.a.I(bArr, i2, gVar);
                gVar.f2356c = Long.valueOf(o.c(gVar.f2355b));
                return I3;
        }
    }

    public static c4 r(Object obj) {
        i2 i2Var = (i2) obj;
        c4 c4Var = i2Var.unknownFields;
        if (c4Var != c4.f2327f) {
            return c4Var;
        }
        c4 c4VarC = c4.c();
        i2Var.unknownFields = c4VarC;
        return c4VarC;
    }

    public static boolean u(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof i2) {
            return ((i2) obj).h();
        }
        return true;
    }

    public final Object A(int i2, int i10, Object obj) {
        t3 t3VarQ = q(i10);
        if (!v(i2, i10, obj)) {
            return t3VarQ.d();
        }
        Object object = f2365q.getObject(obj, U(i10) & 1048575);
        if (u(object)) {
            return object;
        }
        Object objD = t3VarQ.d();
        if (object != null) {
            t3VarQ.a(objD, object);
        }
        return objD;
    }

    public final int F(Object obj, byte[] bArr, int i2, int i10, int i11, long j2, g gVar) throws r2 {
        int iM;
        Unsafe unsafe = f2365q;
        Object objP = p(i11);
        Object object = unsafe.getObject(obj, j2);
        this.f2380o.getClass();
        if (!((b3) object).f2321f) {
            b3 b3VarC = b3.f2320g.c();
            c3.a(b3VarC, object);
            unsafe.putObject(obj, j2, b3VarC);
            object = b3VarC;
        }
        i5.l lVar = ((a3) objP).f2304a;
        b3 b3Var = (b3) object;
        int iE = a.a.E(bArr, i2, gVar);
        int i12 = gVar.f2354a;
        if (i12 < 0 || i12 > i10 - iE) {
            throw r2.g();
        }
        int i13 = iE + i12;
        Object obj2 = lVar.f4689i;
        Object obj3 = "";
        Object obj4 = obj2;
        while (iE < i13) {
            int iC = iE + 1;
            int i14 = bArr[iE];
            if (i14 < 0) {
                iC = a.a.C(i14, bArr, iC, gVar);
                i14 = gVar.f2354a;
            }
            int i15 = i14 >>> 3;
            int i16 = i14 & 7;
            if (i15 != 1) {
                if (i15 == 2) {
                    s4 s4Var = (s4) lVar.f4688h;
                    if (i16 == s4Var.f2529g) {
                        iM = m(bArr, iC, i10, s4Var, obj2.getClass(), gVar);
                        obj4 = gVar.f2356c;
                        iE = iM;
                    }
                }
                iE = a.a.l0(i14, bArr, iC, i10, gVar);
            } else {
                s4 s4Var2 = (s4) lVar.f4687g;
                if (i16 == s4Var2.f2529g) {
                    iM = m(bArr, iC, i10, s4Var2, null, gVar);
                    obj3 = gVar.f2356c;
                    iE = iM;
                } else {
                    iE = a.a.l0(i14, bArr, iC, i10, gVar);
                }
            }
        }
        if (iE != i13) {
            throw r2.f();
        }
        b3Var.put(obj3, obj4);
        return i13;
    }

    public final int G(Object obj, byte[] bArr, int i2, int i10, int i11, g gVar) {
        Object obj2;
        int i12;
        int i13;
        Unsafe unsafe;
        g3 g3Var;
        int i14;
        int i15;
        int i16;
        int iQ;
        int i17;
        u1 u1Var;
        int i18;
        u1 u1Var2;
        int iA;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        g gVar2;
        int i24;
        Unsafe unsafe2;
        byte[] bArr2;
        int i25;
        g gVar3;
        Object obj3;
        byte[] bArr3;
        int i26;
        int I;
        Unsafe unsafe3;
        int i27;
        byte[] bArr4;
        int i28;
        int i29;
        Unsafe unsafe4;
        g gVar4;
        byte[] bArr5;
        int i30;
        int i31;
        Unsafe unsafe5;
        g gVar5;
        int i32;
        int i33;
        int i34;
        int i35;
        g3 g3Var2 = this;
        Object obj4 = obj;
        byte[] bArr6 = bArr;
        int i36 = i10;
        g gVar6 = gVar;
        u1 u1Var3 = gVar6.f2357d;
        l(obj4);
        Unsafe unsafe6 = f2365q;
        int iQ2 = i2;
        int i37 = -1;
        int i38 = 0;
        int i39 = 1048575;
        int i40 = 0;
        int i41 = 0;
        while (true) {
            if (iQ2 < i36) {
                int iC = iQ2 + 1;
                int i42 = bArr6[iQ2];
                if (i42 < 0) {
                    iC = a.a.C(i42, bArr6, iC, gVar6);
                    i42 = gVar6.f2354a;
                }
                int i43 = iC;
                int i44 = i42;
                int i45 = i44 >>> 3;
                int i46 = i38;
                int i47 = i44 & 7;
                int i48 = g3Var2.f2369d;
                int i49 = g3Var2.f2368c;
                if (i45 > i37) {
                    iQ = (i45 < i49 || i45 > i48) ? -1 : g3Var2.Q(i45, i46 / 3);
                    i16 = 0;
                } else if (i45 < i49 || i45 > i48) {
                    i16 = 0;
                    iQ = -1;
                } else {
                    i16 = 0;
                    iQ = g3Var2.Q(i45, 0);
                }
                if (iQ == -1) {
                    i17 = i43;
                    i13 = i39;
                    u1Var = u1Var3;
                    unsafe = unsafe6;
                    i38 = i16;
                    i37 = i45;
                    g3Var = g3Var2;
                    obj2 = obj4;
                    i18 = i44;
                } else {
                    int[] iArr = g3Var2.f2366a;
                    int i50 = iArr[iQ + 1];
                    int iT = T(i50);
                    long j2 = i50 & 1048575;
                    if (iT <= 17) {
                        int i51 = iArr[iQ + 2];
                        int i52 = 1 << (i51 >>> 20);
                        int i53 = i51 & 1048575;
                        if (i53 != i39) {
                            int i54 = 1048575;
                            if (i39 != 1048575) {
                                unsafe6.putInt(obj4, i39, i40);
                                i54 = 1048575;
                            }
                            if (i53 == i54) {
                                i20 = i47;
                                i32 = 0;
                            } else {
                                i20 = i47;
                                i32 = unsafe6.getInt(obj4, i53);
                            }
                            i22 = i53;
                            i21 = i32;
                        } else {
                            i20 = i47;
                            i21 = i40;
                            i22 = i39;
                        }
                        switch (iT) {
                            case 0:
                                i23 = i43;
                                i41 = i44;
                                i24 = iQ;
                                unsafe2 = unsafe6;
                                if (i20 != 1) {
                                    unsafe3 = unsafe2;
                                    g3Var = g3Var2;
                                    unsafe = unsafe3;
                                    u1Var = u1Var3;
                                    i38 = i24;
                                    i17 = i23;
                                    i37 = i45;
                                    i13 = i22;
                                    i18 = i41;
                                    i40 = i21;
                                    obj2 = obj4;
                                    break;
                                } else {
                                    i4.f2400c.m(obj, j2, Double.longBitsToDouble(a.a.u(i23, bArr)));
                                    obj4 = obj;
                                    iQ2 = i23 + 8;
                                    i36 = i10;
                                    gVar6 = gVar;
                                    i37 = i45;
                                    i39 = i22;
                                    i40 = i21 | i52;
                                    bArr6 = bArr;
                                    unsafe6 = unsafe2;
                                    i38 = i24;
                                    break;
                                }
                            case 1:
                                i23 = i43;
                                gVar2 = gVar;
                                i41 = i44;
                                i24 = iQ;
                                unsafe2 = unsafe6;
                                bArr2 = bArr;
                                if (i20 != 5) {
                                    unsafe3 = unsafe2;
                                    g3Var = g3Var2;
                                    unsafe = unsafe3;
                                    u1Var = u1Var3;
                                    i38 = i24;
                                    i17 = i23;
                                    i37 = i45;
                                    i13 = i22;
                                    i18 = i41;
                                    i40 = i21;
                                    obj2 = obj4;
                                    break;
                                } else {
                                    i4.f2400c.n(obj4, j2, Float.intBitsToFloat(a.a.s(i23, bArr2)));
                                    iQ2 = i23 + 4;
                                    i25 = i21 | i52;
                                    byte[] bArr7 = bArr2;
                                    unsafe6 = unsafe2;
                                    bArr6 = bArr7;
                                    gVar6 = gVar2;
                                    i38 = i24;
                                    i37 = i45;
                                    i39 = i22;
                                    i40 = i25;
                                    i36 = i10;
                                    break;
                                }
                            case 2:
                            case 3:
                                i23 = i43;
                                i41 = i44;
                                i24 = iQ;
                                unsafe2 = unsafe6;
                                if (i20 != 0) {
                                    unsafe3 = unsafe2;
                                    g3Var = g3Var2;
                                    unsafe = unsafe3;
                                    u1Var = u1Var3;
                                    i38 = i24;
                                    i17 = i23;
                                    i37 = i45;
                                    i13 = i22;
                                    i18 = i41;
                                    i40 = i21;
                                    obj2 = obj4;
                                    break;
                                } else {
                                    int I2 = a.a.I(bArr, i23, gVar);
                                    Object obj5 = obj4;
                                    unsafe2.putLong(obj5, j2, gVar.f2355b);
                                    obj4 = obj5;
                                    unsafe6 = unsafe2;
                                    bArr6 = bArr;
                                    i36 = i10;
                                    gVar6 = gVar;
                                    i37 = i45;
                                    i39 = i22;
                                    i40 = i21 | i52;
                                    iQ2 = I2;
                                    i38 = i24;
                                    break;
                                }
                            case 4:
                            case 11:
                                i23 = i43;
                                i41 = i44;
                                i24 = iQ;
                                unsafe2 = unsafe6;
                                if (i20 != 0) {
                                    unsafe3 = unsafe2;
                                    g3Var = g3Var2;
                                    unsafe = unsafe3;
                                    u1Var = u1Var3;
                                    i38 = i24;
                                    i17 = i23;
                                    i37 = i45;
                                    i13 = i22;
                                    i18 = i41;
                                    i40 = i21;
                                    obj2 = obj4;
                                    break;
                                } else {
                                    int iE = a.a.E(bArr, i23, gVar);
                                    unsafe2.putInt(obj4, j2, gVar.f2354a);
                                    unsafe6 = unsafe2;
                                    bArr6 = bArr;
                                    int i55 = i22;
                                    i40 = i21 | i52;
                                    iQ2 = iE;
                                    gVar6 = gVar;
                                    i39 = i55;
                                    i36 = i10;
                                    i38 = i24;
                                    i37 = i45;
                                    break;
                                }
                            case 5:
                            case y0.EDITION_FIELD_NUMBER /* 14 */:
                                Object obj6 = obj4;
                                i41 = i44;
                                i24 = iQ;
                                if (i20 != 1) {
                                    i23 = i43;
                                    unsafe2 = unsafe6;
                                    obj4 = obj6;
                                    unsafe3 = unsafe2;
                                    g3Var = g3Var2;
                                    unsafe = unsafe3;
                                    u1Var = u1Var3;
                                    i38 = i24;
                                    i17 = i23;
                                    i37 = i45;
                                    i13 = i22;
                                    i18 = i41;
                                    i40 = i21;
                                    obj2 = obj4;
                                    break;
                                } else {
                                    Unsafe unsafe7 = unsafe6;
                                    bArr2 = bArr;
                                    gVar2 = gVar;
                                    unsafe7.putLong(obj6, j2, a.a.u(i43, bArr));
                                    unsafe2 = unsafe7;
                                    obj4 = obj6;
                                    iQ2 = i43 + 8;
                                    i25 = i21 | i52;
                                    byte[] bArr72 = bArr2;
                                    unsafe6 = unsafe2;
                                    bArr6 = bArr72;
                                    gVar6 = gVar2;
                                    i38 = i24;
                                    i37 = i45;
                                    i39 = i22;
                                    i40 = i25;
                                    i36 = i10;
                                    break;
                                }
                            case 6:
                            case 13:
                                gVar3 = gVar;
                                obj3 = obj4;
                                i41 = i44;
                                bArr3 = bArr;
                                i24 = iQ;
                                i26 = i43;
                                if (i20 != 5) {
                                    i23 = i26;
                                    unsafe3 = unsafe6;
                                    obj4 = obj3;
                                    g3Var = g3Var2;
                                    unsafe = unsafe3;
                                    u1Var = u1Var3;
                                    i38 = i24;
                                    i17 = i23;
                                    i37 = i45;
                                    i13 = i22;
                                    i18 = i41;
                                    i40 = i21;
                                    obj2 = obj4;
                                    break;
                                } else {
                                    unsafe6.putInt(obj3, j2, a.a.s(i26, bArr3));
                                    I = i26 + 4;
                                    i25 = i21 | i52;
                                    gVar6 = gVar3;
                                    i38 = i24;
                                    i37 = i45;
                                    iQ2 = I;
                                    bArr6 = bArr3;
                                    obj4 = obj3;
                                    i39 = i22;
                                    i40 = i25;
                                    i36 = i10;
                                    break;
                                }
                            case 7:
                                int i56 = iQ;
                                i26 = i43;
                                gVar3 = gVar;
                                obj3 = obj4;
                                bArr3 = bArr;
                                if (i20 != 0) {
                                    i41 = i44;
                                    i24 = i56;
                                    i23 = i26;
                                    unsafe3 = unsafe6;
                                    obj4 = obj3;
                                    g3Var = g3Var2;
                                    unsafe = unsafe3;
                                    u1Var = u1Var3;
                                    i38 = i24;
                                    i17 = i23;
                                    i37 = i45;
                                    i13 = i22;
                                    i18 = i41;
                                    i40 = i21;
                                    obj2 = obj4;
                                    break;
                                } else {
                                    I = a.a.I(bArr3, i26, gVar3);
                                    i41 = i44;
                                    i4.f2400c.k(obj3, j2, gVar3.f2355b != 0);
                                    i25 = i21 | i52;
                                    i38 = i56;
                                    gVar6 = gVar3;
                                    i37 = i45;
                                    iQ2 = I;
                                    bArr6 = bArr3;
                                    obj4 = obj3;
                                    i39 = i22;
                                    i40 = i25;
                                    i36 = i10;
                                    break;
                                }
                            case 8:
                                int i57 = iQ;
                                gVar3 = gVar;
                                obj3 = obj4;
                                bArr3 = bArr;
                                if (i20 != 2) {
                                    i23 = i43;
                                    unsafe3 = unsafe6;
                                    i41 = i44;
                                    i24 = i57;
                                    obj4 = obj3;
                                    g3Var = g3Var2;
                                    unsafe = unsafe3;
                                    u1Var = u1Var3;
                                    i38 = i24;
                                    i17 = i23;
                                    i37 = i45;
                                    i13 = i22;
                                    i18 = i41;
                                    i40 = i21;
                                    obj2 = obj4;
                                    break;
                                } else if ((536870912 & i50) != 0) {
                                    I = a.a.E(bArr3, i43, gVar3);
                                    i27 = gVar3.f2354a;
                                    if (i27 < 0) {
                                        throw r2.e();
                                    }
                                    if (i27 == 0) {
                                        gVar3.f2356c = "";
                                        unsafe6.putObject(obj3, j2, gVar3.f2356c);
                                        i25 = i21 | i52;
                                        i38 = i57;
                                        gVar6 = gVar3;
                                        i41 = i44;
                                        i37 = i45;
                                        iQ2 = I;
                                        bArr6 = bArr3;
                                        obj4 = obj3;
                                        i39 = i22;
                                        i40 = i25;
                                        i36 = i10;
                                        break;
                                    } else {
                                        gVar3.f2356c = l4.f2432a.q(bArr3, I, i27);
                                        I += i27;
                                        unsafe6.putObject(obj3, j2, gVar3.f2356c);
                                        i25 = i21 | i52;
                                        i38 = i57;
                                        gVar6 = gVar3;
                                        i41 = i44;
                                        i37 = i45;
                                        iQ2 = I;
                                        bArr6 = bArr3;
                                        obj4 = obj3;
                                        i39 = i22;
                                        i40 = i25;
                                        i36 = i10;
                                    }
                                } else {
                                    I = a.a.E(bArr3, i43, gVar3);
                                    i27 = gVar3.f2354a;
                                    if (i27 < 0) {
                                        throw r2.e();
                                    }
                                    if (i27 == 0) {
                                        gVar3.f2356c = "";
                                        unsafe6.putObject(obj3, j2, gVar3.f2356c);
                                        i25 = i21 | i52;
                                        i38 = i57;
                                        gVar6 = gVar3;
                                        i41 = i44;
                                        i37 = i45;
                                        iQ2 = I;
                                        bArr6 = bArr3;
                                        obj4 = obj3;
                                        i39 = i22;
                                        i40 = i25;
                                        i36 = i10;
                                    } else {
                                        gVar3.f2356c = new String(bArr3, I, i27, p2.f2495a);
                                        I += i27;
                                        unsafe6.putObject(obj3, j2, gVar3.f2356c);
                                        i25 = i21 | i52;
                                        i38 = i57;
                                        gVar6 = gVar3;
                                        i41 = i44;
                                        i37 = i45;
                                        iQ2 = I;
                                        bArr6 = bArr3;
                                        obj4 = obj3;
                                        i39 = i22;
                                        i40 = i25;
                                        i36 = i10;
                                    }
                                }
                            case 9:
                                int i58 = iQ;
                                Unsafe unsafe8 = unsafe6;
                                if (i20 != 2) {
                                    obj3 = obj4;
                                    gVar3 = gVar;
                                    i23 = i43;
                                    unsafe3 = unsafe8;
                                    i41 = i44;
                                    i24 = i58;
                                    obj4 = obj3;
                                    g3Var = g3Var2;
                                    unsafe = unsafe3;
                                    u1Var = u1Var3;
                                    i38 = i24;
                                    i17 = i23;
                                    i37 = i45;
                                    i13 = i22;
                                    i18 = i41;
                                    i40 = i21;
                                    obj2 = obj4;
                                    break;
                                } else {
                                    Object obj7 = obj4;
                                    Object objZ = g3Var2.z(i58, obj7);
                                    unsafe6 = unsafe8;
                                    i38 = i58;
                                    obj3 = obj7;
                                    I = a.a.Y(objZ, g3Var2.q(i58), bArr, i43, i10, gVar);
                                    bArr3 = bArr;
                                    gVar3 = gVar;
                                    g3Var2.R(i38, obj3, objZ);
                                    i25 = i21 | i52;
                                    gVar6 = gVar3;
                                    i41 = i44;
                                    i37 = i45;
                                    iQ2 = I;
                                    bArr6 = bArr3;
                                    obj4 = obj3;
                                    i39 = i22;
                                    i40 = i25;
                                    i36 = i10;
                                    break;
                                }
                            case 10:
                                bArr4 = bArr;
                                i28 = i43;
                                i29 = iQ;
                                unsafe4 = unsafe6;
                                gVar4 = gVar;
                                if (i20 != 2) {
                                    unsafe3 = unsafe4;
                                    i23 = i28;
                                    i41 = i44;
                                    i24 = i29;
                                    g3Var = g3Var2;
                                    unsafe = unsafe3;
                                    u1Var = u1Var3;
                                    i38 = i24;
                                    i17 = i23;
                                    i37 = i45;
                                    i13 = i22;
                                    i18 = i41;
                                    i40 = i21;
                                    obj2 = obj4;
                                    break;
                                } else {
                                    iQ2 = a.a.q(bArr4, i28, gVar4);
                                    unsafe4.putObject(obj4, j2, gVar4.f2356c);
                                    unsafe6 = unsafe4;
                                    bArr6 = bArr4;
                                    i39 = i22;
                                    i40 = i21 | i52;
                                    gVar6 = gVar4;
                                    i38 = i29;
                                    i41 = i44;
                                    i37 = i45;
                                    i36 = i10;
                                    break;
                                }
                            case 12:
                                bArr4 = bArr;
                                i28 = i43;
                                i29 = iQ;
                                unsafe4 = unsafe6;
                                gVar4 = gVar;
                                if (i20 != 0) {
                                    unsafe3 = unsafe4;
                                    i23 = i28;
                                    i41 = i44;
                                    i24 = i29;
                                    g3Var = g3Var2;
                                    unsafe = unsafe3;
                                    u1Var = u1Var3;
                                    i38 = i24;
                                    i17 = i23;
                                    i37 = i45;
                                    i13 = i22;
                                    i18 = i41;
                                    i40 = i21;
                                    obj2 = obj4;
                                    break;
                                } else {
                                    int iE2 = a.a.E(bArr4, i28, gVar4);
                                    int i59 = gVar4.f2354a;
                                    l2 l2VarO = g3Var2.o(i29);
                                    if ((i50 & Integer.MIN_VALUE) != 0 && l2VarO != null && !l2VarO.a(i59)) {
                                        r(obj4).d(i44, Long.valueOf(i59));
                                        iQ2 = iE2;
                                        i38 = i29;
                                        gVar6 = gVar4;
                                        i41 = i44;
                                        i37 = i45;
                                        i36 = i10;
                                        unsafe6 = unsafe4;
                                        bArr6 = bArr4;
                                        i39 = i22;
                                        i40 = i21;
                                        break;
                                    } else {
                                        unsafe4.putInt(obj4, j2, i59);
                                        i38 = i29;
                                        gVar6 = gVar4;
                                        i41 = i44;
                                        i37 = i45;
                                        i36 = i10;
                                        unsafe6 = unsafe4;
                                        bArr6 = bArr4;
                                        i39 = i22;
                                        i40 = i21 | i52;
                                        iQ2 = iE2;
                                        break;
                                    }
                                }
                                break;
                            case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                                bArr5 = bArr;
                                i30 = i43;
                                i31 = iQ;
                                unsafe5 = unsafe6;
                                gVar5 = gVar;
                                if (i20 != 0) {
                                    unsafe3 = unsafe5;
                                    i41 = i44;
                                    i24 = i31;
                                    i23 = i30;
                                    g3Var = g3Var2;
                                    unsafe = unsafe3;
                                    u1Var = u1Var3;
                                    i38 = i24;
                                    i17 = i23;
                                    i37 = i45;
                                    i13 = i22;
                                    i18 = i41;
                                    i40 = i21;
                                    obj2 = obj4;
                                    break;
                                } else {
                                    iQ2 = a.a.E(bArr5, i30, gVar5);
                                    unsafe5.putInt(obj4, j2, o.b(gVar5.f2354a));
                                    i25 = i21 | i52;
                                    gVar6 = gVar5;
                                    i41 = i44;
                                    i38 = i31;
                                    i37 = i45;
                                    unsafe6 = unsafe5;
                                    bArr6 = bArr5;
                                    i39 = i22;
                                    i40 = i25;
                                    i36 = i10;
                                    break;
                                }
                            case 16:
                                bArr5 = bArr;
                                i30 = i43;
                                i31 = iQ;
                                if (i20 != 0) {
                                    Unsafe unsafe9 = unsafe6;
                                    gVar5 = gVar;
                                    unsafe5 = unsafe9;
                                    unsafe3 = unsafe5;
                                    i41 = i44;
                                    i24 = i31;
                                    i23 = i30;
                                    g3Var = g3Var2;
                                    unsafe = unsafe3;
                                    u1Var = u1Var3;
                                    i38 = i24;
                                    i17 = i23;
                                    i37 = i45;
                                    i13 = i22;
                                    i18 = i41;
                                    i40 = i21;
                                    obj2 = obj4;
                                    break;
                                } else {
                                    int I3 = a.a.I(bArr5, i30, gVar);
                                    Object obj8 = obj4;
                                    Unsafe unsafe10 = unsafe6;
                                    unsafe10.putLong(obj8, j2, o.c(gVar.f2355b));
                                    obj4 = obj8;
                                    i36 = i10;
                                    gVar6 = gVar;
                                    i41 = i44;
                                    i37 = i45;
                                    unsafe6 = unsafe10;
                                    bArr6 = bArr5;
                                    i39 = i22;
                                    i40 = i21 | i52;
                                    iQ2 = I3;
                                    i38 = i31;
                                    break;
                                }
                            case 17:
                                if (i20 != 3) {
                                    i23 = i43;
                                    unsafe3 = unsafe6;
                                    i41 = i44;
                                    i24 = iQ;
                                    g3Var = g3Var2;
                                    unsafe = unsafe3;
                                    u1Var = u1Var3;
                                    i38 = i24;
                                    i17 = i23;
                                    i37 = i45;
                                    i13 = i22;
                                    i18 = i41;
                                    i40 = i21;
                                    obj2 = obj4;
                                    break;
                                } else {
                                    Object objZ2 = g3Var2.z(iQ, obj4);
                                    int i60 = iQ;
                                    iQ2 = a.a.W(objZ2, g3Var2.q(iQ), bArr, i43, i10, (i45 << 3) | 4, gVar);
                                    g3Var2.R(i60, obj4, objZ2);
                                    i25 = i21 | i52;
                                    gVar6 = gVar;
                                    bArr6 = bArr;
                                    i41 = i44;
                                    i38 = i60;
                                    i37 = i45;
                                    i39 = i22;
                                    i40 = i25;
                                    i36 = i10;
                                    break;
                                }
                            default:
                                i23 = i43;
                                unsafe3 = unsafe6;
                                i41 = i44;
                                i24 = iQ;
                                g3Var = g3Var2;
                                unsafe = unsafe3;
                                u1Var = u1Var3;
                                i38 = i24;
                                i17 = i23;
                                i37 = i45;
                                i13 = i22;
                                i18 = i41;
                                i40 = i21;
                                obj2 = obj4;
                                break;
                        }
                    } else {
                        i41 = i44;
                        int i61 = iQ;
                        Unsafe unsafe11 = unsafe6;
                        if (iT != 27) {
                            if (iT <= 49) {
                                u1Var = u1Var3;
                                unsafe = unsafe11;
                                i13 = i39;
                                i34 = i40;
                                int I4 = g3Var2.I(obj, bArr, i43, i10, i41, i45, i47, i61, i50, iT, j2, gVar);
                                i61 = i61;
                                if (I4 != i43) {
                                    g3Var2 = this;
                                    obj4 = obj;
                                    bArr6 = bArr;
                                    i36 = i10;
                                    gVar6 = gVar;
                                    iQ2 = I4;
                                    i37 = i45;
                                } else {
                                    g3Var = this;
                                    i17 = I4;
                                    i37 = i45;
                                    i38 = i61;
                                    i18 = i41;
                                    i40 = i34;
                                    obj2 = obj;
                                }
                            } else {
                                i13 = i39;
                                u1Var = u1Var3;
                                unsafe = unsafe11;
                                i33 = i45;
                                i34 = i40;
                                i35 = i43;
                                if (iT == 50) {
                                    if (i47 == 2) {
                                        int iF = F(obj, bArr, i35, i10, i61, j2, gVar);
                                        if (iF != i35) {
                                            g3Var2 = this;
                                            obj4 = obj;
                                            bArr6 = bArr;
                                            i36 = i10;
                                            gVar6 = gVar;
                                            iQ2 = iF;
                                            i37 = i33;
                                        } else {
                                            g3Var = this;
                                            obj2 = obj;
                                            i17 = iF;
                                        }
                                    }
                                    i37 = i33;
                                    i38 = i61;
                                    i18 = i41;
                                    i40 = i34;
                                } else {
                                    i37 = i33;
                                    int iH = H(obj, bArr, i35, i10, i41, i37, i47, i50, iT, j2, i61, gVar);
                                    g3Var = this;
                                    obj2 = obj;
                                    i18 = i41;
                                    i61 = i61;
                                    if (iH != i35) {
                                        bArr6 = bArr;
                                        i36 = i10;
                                        gVar6 = gVar;
                                        i41 = i18;
                                        iQ2 = iH;
                                        g3Var2 = g3Var;
                                        obj4 = obj2;
                                    } else {
                                        i17 = iH;
                                        i38 = i61;
                                        i40 = i34;
                                    }
                                }
                            }
                            i38 = i61;
                            i39 = i13;
                            i40 = i34;
                            u1Var3 = u1Var;
                            unsafe6 = unsafe;
                        } else if (i47 == 2) {
                            o2 o2VarMutableCopyWithCapacity = (o2) unsafe11.getObject(obj4, j2);
                            if (!o2VarMutableCopyWithCapacity.isModifiable()) {
                                int size = o2VarMutableCopyWithCapacity.size();
                                o2VarMutableCopyWithCapacity = o2VarMutableCopyWithCapacity.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
                                unsafe11.putObject(obj4, j2, o2VarMutableCopyWithCapacity);
                            }
                            unsafe6 = unsafe11;
                            bArr6 = bArr;
                            i36 = i10;
                            gVar6 = gVar;
                            iQ2 = a.a.w(g3Var2.q(i61), i41, bArr, i43, i10, o2VarMutableCopyWithCapacity, gVar);
                            i38 = i61;
                            i37 = i45;
                            obj4 = obj;
                        } else {
                            i35 = i43;
                            unsafe = unsafe11;
                            i13 = i39;
                            u1Var = u1Var3;
                            i33 = i45;
                            i34 = i40;
                        }
                        g3Var = this;
                        obj2 = obj;
                        i17 = i35;
                        i37 = i33;
                        i38 = i61;
                        i18 = i41;
                        i40 = i34;
                    }
                }
                if (i18 != i11 || i11 == 0) {
                    if (g3Var.f2371f) {
                        u1Var2 = u1Var;
                        if (u1Var2 != u1.b()) {
                            u1Var2.a(i37, g3Var.f2370e);
                            iA = a.a.A(i18, bArr, i17, i10, r(obj2), gVar);
                            i19 = i10;
                            i41 = i18;
                        }
                        iQ2 = iA;
                        bArr6 = bArr;
                        gVar6 = gVar;
                        g3Var2 = g3Var;
                        obj4 = obj2;
                        u1Var3 = u1Var2;
                        i36 = i19;
                        i39 = i13;
                        unsafe6 = unsafe;
                    } else {
                        u1Var2 = u1Var;
                    }
                    i41 = i18;
                    iA = a.a.A(i41, bArr, i17, i10, r(obj2), gVar);
                    i19 = i10;
                    iQ2 = iA;
                    bArr6 = bArr;
                    gVar6 = gVar;
                    g3Var2 = g3Var;
                    obj4 = obj2;
                    u1Var3 = u1Var2;
                    i36 = i19;
                    i39 = i13;
                    unsafe6 = unsafe;
                } else {
                    i12 = i10;
                    i15 = i18;
                    i14 = i17;
                }
            } else {
                obj2 = obj4;
                i12 = i36;
                i13 = i39;
                unsafe = unsafe6;
                g3Var = g3Var2;
                i14 = iQ2;
                i15 = i41;
            }
        }
        int i62 = i13;
        if (i62 != 1048575) {
            unsafe.putInt(obj2, i62, i40);
        }
        c4 c4Var = null;
        int i63 = g3Var.f2374i;
        while (i63 < g3Var.f2375j) {
            c4Var = (c4) g3Var.n(obj2, g3Var.f2373h[i63], c4Var, g3Var.f2378m, obj);
            i63++;
            obj2 = obj;
        }
        g3 g3Var3 = g3Var;
        if (c4Var != null) {
            g3Var3.f2378m.getClass();
            ((i2) obj).unknownFields = c4Var;
        }
        if (i11 == 0) {
            if (i14 != i12) {
                throw r2.f();
            }
        } else if (i14 > i12 || i15 != i11) {
            throw r2.f();
        }
        return i14;
    }

    public final int H(Object obj, byte[] bArr, int i2, int i10, int i11, int i12, int i13, int i14, int i15, long j2, int i16, g gVar) throws r2 {
        Unsafe unsafe = f2365q;
        long j4 = this.f2366a[i16 + 2] & 1048575;
        switch (i15) {
            case 51:
                if (i13 != 1) {
                    return i2;
                }
                unsafe.putObject(obj, j2, Double.valueOf(Double.longBitsToDouble(a.a.u(i2, bArr))));
                int i17 = i2 + 8;
                unsafe.putInt(obj, j4, i12);
                return i17;
            case 52:
                if (i13 != 5) {
                    return i2;
                }
                unsafe.putObject(obj, j2, Float.valueOf(Float.intBitsToFloat(a.a.s(i2, bArr))));
                int i18 = i2 + 4;
                unsafe.putInt(obj, j4, i12);
                return i18;
            case 53:
            case 54:
                if (i13 != 0) {
                    return i2;
                }
                int I = a.a.I(bArr, i2, gVar);
                unsafe.putObject(obj, j2, Long.valueOf(gVar.f2355b));
                unsafe.putInt(obj, j4, i12);
                return I;
            case 55:
            case 62:
                if (i13 != 0) {
                    return i2;
                }
                int iE = a.a.E(bArr, i2, gVar);
                unsafe.putObject(obj, j2, Integer.valueOf(gVar.f2354a));
                unsafe.putInt(obj, j4, i12);
                return iE;
            case 56:
            case 65:
                if (i13 != 1) {
                    return i2;
                }
                unsafe.putObject(obj, j2, Long.valueOf(a.a.u(i2, bArr)));
                int i19 = i2 + 8;
                unsafe.putInt(obj, j4, i12);
                return i19;
            case 57:
            case 64:
                if (i13 != 5) {
                    return i2;
                }
                unsafe.putObject(obj, j2, Integer.valueOf(a.a.s(i2, bArr)));
                int i20 = i2 + 4;
                unsafe.putInt(obj, j4, i12);
                return i20;
            case 58:
                if (i13 != 0) {
                    return i2;
                }
                int I2 = a.a.I(bArr, i2, gVar);
                unsafe.putObject(obj, j2, Boolean.valueOf(gVar.f2355b != 0));
                unsafe.putInt(obj, j4, i12);
                return I2;
            case 59:
                if (i13 != 2) {
                    return i2;
                }
                int iE2 = a.a.E(bArr, i2, gVar);
                int i21 = gVar.f2354a;
                if (i21 == 0) {
                    unsafe.putObject(obj, j2, "");
                } else {
                    if ((i14 & 536870912) != 0) {
                        if (l4.f2432a.H(bArr, iE2, iE2 + i21) != 0) {
                            throw r2.b();
                        }
                    }
                    unsafe.putObject(obj, j2, new String(bArr, iE2, i21, p2.f2495a));
                    iE2 += i21;
                }
                unsafe.putInt(obj, j4, i12);
                return iE2;
            case 60:
                if (i13 != 2) {
                    return i2;
                }
                Object objA = A(i12, i16, obj);
                int iY = a.a.Y(objA, q(i16), bArr, i2, i10, gVar);
                S(i12, i16, obj, objA);
                return iY;
            case 61:
                if (i13 != 2) {
                    return i2;
                }
                int iQ = a.a.q(bArr, i2, gVar);
                unsafe.putObject(obj, j2, gVar.f2356c);
                unsafe.putInt(obj, j4, i12);
                return iQ;
            case 63:
                if (i13 != 0) {
                    return i2;
                }
                int iE3 = a.a.E(bArr, i2, gVar);
                int i22 = gVar.f2354a;
                l2 l2VarO = o(i16);
                if (l2VarO != null && !l2VarO.a(i22)) {
                    r(obj).d(i11, Long.valueOf(i22));
                    return iE3;
                }
                unsafe.putObject(obj, j2, Integer.valueOf(i22));
                unsafe.putInt(obj, j4, i12);
                return iE3;
            case 66:
                if (i13 != 0) {
                    return i2;
                }
                int iE4 = a.a.E(bArr, i2, gVar);
                unsafe.putObject(obj, j2, Integer.valueOf(o.b(gVar.f2354a)));
                unsafe.putInt(obj, j4, i12);
                return iE4;
            case 67:
                if (i13 != 0) {
                    return i2;
                }
                int I3 = a.a.I(bArr, i2, gVar);
                unsafe.putObject(obj, j2, Long.valueOf(o.c(gVar.f2355b)));
                unsafe.putInt(obj, j4, i12);
                return I3;
            case 68:
                if (i13 == 3) {
                    Object objA2 = A(i12, i16, obj);
                    int iW = a.a.W(objA2, q(i16), bArr, i2, i10, (i11 & (-8)) | 4, gVar);
                    S(i12, i16, obj, objA2);
                    return iW;
                }
                break;
        }
        return i2;
    }

    public final int I(Object obj, byte[] bArr, int i2, int i10, int i11, int i12, int i13, int i14, long j2, int i15, long j4, g gVar) throws r2 {
        int i16;
        int i17;
        int iG;
        Unsafe unsafe = f2365q;
        o2 o2VarMutableCopyWithCapacity = (o2) unsafe.getObject(obj, j4);
        if (!o2VarMutableCopyWithCapacity.isModifiable()) {
            o2VarMutableCopyWithCapacity = o2VarMutableCopyWithCapacity.mutableCopyWithCapacity(o2VarMutableCopyWithCapacity.size() * 2);
            unsafe.putObject(obj, j4, o2VarMutableCopyWithCapacity);
        }
        o2 o2Var = o2VarMutableCopyWithCapacity;
        switch (i15) {
            case a1.PY_GENERIC_SERVICES_FIELD_NUMBER /* 18 */:
            case g1.FEATURES_FIELD_NUMBER /* 35 */:
                if (i13 != 2) {
                    if (i13 != 1) {
                        return i2;
                    }
                    p1 p1Var = (p1) o2Var;
                    p1Var.addDouble(Double.longBitsToDouble(a.a.u(i2, bArr)));
                    int i18 = i2 + 8;
                    while (i18 < i10) {
                        int iE = a.a.E(bArr, i18, gVar);
                        if (i11 != gVar.f2354a) {
                            return i18;
                        }
                        p1Var.addDouble(Double.longBitsToDouble(a.a.u(iE, bArr)));
                        i18 = iE + 8;
                    }
                    return i18;
                }
                p1 p1Var2 = (p1) o2Var;
                int iE2 = a.a.E(bArr, i2, gVar);
                int i19 = gVar.f2354a;
                int i20 = iE2 + i19;
                if (i20 > bArr.length) {
                    throw r2.g();
                }
                p1Var2.getClass();
                int i21 = (i19 / 8) + 0;
                double[] dArr = p1Var2.f2494g;
                if (i21 > dArr.length) {
                    if (dArr.length == 0) {
                        p1Var2.f2494g = new double[Math.max(i21, 10)];
                    } else {
                        int length = dArr.length;
                        while (length < i21) {
                            length = a1.a.d(length, 3, 2, 1, 10);
                        }
                        p1Var2.f2494g = Arrays.copyOf(p1Var2.f2494g, length);
                    }
                }
                while (iE2 < i20) {
                    p1Var2.addDouble(Double.longBitsToDouble(a.a.u(iE2, bArr)));
                    iE2 += 8;
                }
                if (iE2 == i20) {
                    return iE2;
                }
                throw r2.g();
            case x0.TARGETS_FIELD_NUMBER /* 19 */:
            case a1.OBJC_CLASS_PREFIX_FIELD_NUMBER /* 36 */:
                if (i13 != 2) {
                    if (i13 != 5) {
                        return i2;
                    }
                    d2 d2Var = (d2) o2Var;
                    d2Var.addFloat(Float.intBitsToFloat(a.a.s(i2, bArr)));
                    int i22 = i2 + 4;
                    while (i22 < i10) {
                        int iE3 = a.a.E(bArr, i22, gVar);
                        if (i11 != gVar.f2354a) {
                            return i22;
                        }
                        d2Var.addFloat(Float.intBitsToFloat(a.a.s(iE3, bArr)));
                        i22 = iE3 + 4;
                    }
                    return i22;
                }
                d2 d2Var2 = (d2) o2Var;
                int iE4 = a.a.E(bArr, i2, gVar);
                int i23 = gVar.f2354a;
                int i24 = iE4 + i23;
                if (i24 > bArr.length) {
                    throw r2.g();
                }
                d2Var2.getClass();
                int i25 = (i23 / 4) + 0;
                float[] fArr = d2Var2.f2334g;
                if (i25 > fArr.length) {
                    if (fArr.length == 0) {
                        d2Var2.f2334g = new float[Math.max(i25, 10)];
                    } else {
                        int length2 = fArr.length;
                        while (length2 < i25) {
                            length2 = a1.a.d(length2, 3, 2, 1, 10);
                        }
                        d2Var2.f2334g = Arrays.copyOf(d2Var2.f2334g, length2);
                    }
                }
                while (iE4 < i24) {
                    d2Var2.addFloat(Float.intBitsToFloat(a.a.s(iE4, bArr)));
                    iE4 += 4;
                }
                if (iE4 == i24) {
                    return iE4;
                }
                throw r2.g();
            case 20:
            case x0.FEATURES_FIELD_NUMBER /* 21 */:
            case a1.CSHARP_NAMESPACE_FIELD_NUMBER /* 37 */:
            case 38:
                if (i13 == 2) {
                    x2 x2Var = (x2) o2Var;
                    int iE5 = a.a.E(bArr, i2, gVar);
                    int i26 = gVar.f2354a + iE5;
                    while (iE5 < i26) {
                        iE5 = a.a.I(bArr, iE5, gVar);
                        x2Var.addLong(gVar.f2355b);
                    }
                    if (iE5 == i26) {
                        return iE5;
                    }
                    throw r2.g();
                }
                if (i13 != 0) {
                    return i2;
                }
                x2 x2Var2 = (x2) o2Var;
                int I = a.a.I(bArr, i2, gVar);
                x2Var2.addLong(gVar.f2355b);
                while (I < i10) {
                    int iE6 = a.a.E(bArr, I, gVar);
                    if (i11 != gVar.f2354a) {
                        return I;
                    }
                    I = a.a.I(bArr, iE6, gVar);
                    x2Var2.addLong(gVar.f2355b);
                }
                return I;
            case x0.FEATURE_SUPPORT_FIELD_NUMBER /* 22 */:
            case 29:
            case a1.SWIFT_PREFIX_FIELD_NUMBER /* 39 */:
            case 43:
                if (i13 != 2) {
                    return i13 == 0 ? a.a.G(i11, bArr, i2, i10, o2Var, gVar) : i2;
                }
                j2 j2Var = (j2) o2Var;
                int iE7 = a.a.E(bArr, i2, gVar);
                int i27 = gVar.f2354a + iE7;
                while (iE7 < i27) {
                    iE7 = a.a.E(bArr, iE7, gVar);
                    j2Var.addInt(gVar.f2354a);
                }
                if (iE7 == i27) {
                    return iE7;
                }
                throw r2.g();
            case a1.DEPRECATED_FIELD_NUMBER /* 23 */:
            case 32:
            case a1.PHP_CLASS_PREFIX_FIELD_NUMBER /* 40 */:
            case 46:
                if (i13 != 2) {
                    if (i13 != 1) {
                        return i2;
                    }
                    x2 x2Var3 = (x2) o2Var;
                    x2Var3.addLong(a.a.u(i2, bArr));
                    int i28 = i2 + 8;
                    while (i28 < i10) {
                        int iE8 = a.a.E(bArr, i28, gVar);
                        if (i11 != gVar.f2354a) {
                            return i28;
                        }
                        x2Var3.addLong(a.a.u(iE8, bArr));
                        i28 = iE8 + 8;
                    }
                    return i28;
                }
                x2 x2Var4 = (x2) o2Var;
                int iE9 = a.a.E(bArr, i2, gVar);
                int i29 = gVar.f2354a;
                int i30 = iE9 + i29;
                if (i30 > bArr.length) {
                    throw r2.g();
                }
                x2Var4.getClass();
                int i31 = (i29 / 8) + 0;
                long[] jArr = x2Var4.f2627g;
                if (i31 > jArr.length) {
                    if (jArr.length == 0) {
                        x2Var4.f2627g = new long[Math.max(i31, 10)];
                    } else {
                        int length3 = jArr.length;
                        while (length3 < i31) {
                            length3 = a1.a.d(length3, 3, 2, 1, 10);
                        }
                        x2Var4.f2627g = Arrays.copyOf(x2Var4.f2627g, length3);
                    }
                }
                while (iE9 < i30) {
                    x2Var4.addLong(a.a.u(iE9, bArr));
                    iE9 += 8;
                }
                if (iE9 == i30) {
                    return iE9;
                }
                throw r2.g();
            case 24:
            case a1.CC_ENABLE_ARENAS_FIELD_NUMBER /* 31 */:
            case a1.PHP_NAMESPACE_FIELD_NUMBER /* 41 */:
            case a1.RUBY_PACKAGE_FIELD_NUMBER /* 45 */:
                if (i13 != 2) {
                    if (i13 != 5) {
                        return i2;
                    }
                    j2 j2Var2 = (j2) o2Var;
                    j2Var2.addInt(a.a.s(i2, bArr));
                    int i32 = i2 + 4;
                    while (i32 < i10) {
                        int iE10 = a.a.E(bArr, i32, gVar);
                        if (i11 != gVar.f2354a) {
                            return i32;
                        }
                        j2Var2.addInt(a.a.s(iE10, bArr));
                        i32 = iE10 + 4;
                    }
                    return i32;
                }
                j2 j2Var3 = (j2) o2Var;
                int iE11 = a.a.E(bArr, i2, gVar);
                int i33 = gVar.f2354a;
                int i34 = iE11 + i33;
                if (i34 > bArr.length) {
                    throw r2.g();
                }
                int i35 = (i33 / 4) + j2Var3.f2415h;
                int[] iArr = j2Var3.f2414g;
                if (i35 > iArr.length) {
                    if (iArr.length == 0) {
                        j2Var3.f2414g = new int[Math.max(i35, 10)];
                    } else {
                        int length4 = iArr.length;
                        while (length4 < i35) {
                            length4 = a1.a.d(length4, 3, 2, 1, 10);
                        }
                        j2Var3.f2414g = Arrays.copyOf(j2Var3.f2414g, length4);
                    }
                }
                while (iE11 < i34) {
                    j2Var3.addInt(a.a.s(iE11, bArr));
                    iE11 += 4;
                }
                if (iE11 == i34) {
                    return iE11;
                }
                throw r2.g();
            case 25:
            case 42:
                if (i13 == 2) {
                    h hVar = (h) o2Var;
                    int iE12 = a.a.E(bArr, i2, gVar);
                    int i36 = gVar.f2354a + iE12;
                    while (iE12 < i36) {
                        iE12 = a.a.I(bArr, iE12, gVar);
                        hVar.addBoolean(gVar.f2355b != 0);
                    }
                    if (iE12 == i36) {
                        return iE12;
                    }
                    throw r2.g();
                }
                if (i13 != 0) {
                    return i2;
                }
                h hVar2 = (h) o2Var;
                int I2 = a.a.I(bArr, i2, gVar);
                hVar2.addBoolean(gVar.f2355b != 0);
                while (I2 < i10) {
                    int iE13 = a.a.E(bArr, I2, gVar);
                    if (i11 != gVar.f2354a) {
                        return I2;
                    }
                    I2 = a.a.I(bArr, iE13, gVar);
                    hVar2.addBoolean(gVar.f2355b != 0);
                }
                return I2;
            case 26:
                if (i13 != 2) {
                    return i2;
                }
                if ((j2 & 536870912) == 0) {
                    int iE14 = a.a.E(bArr, i2, gVar);
                    int i37 = gVar.f2354a;
                    if (i37 < 0) {
                        throw r2.e();
                    }
                    if (i37 == 0) {
                        o2Var.add("");
                    } else {
                        o2Var.add(new String(bArr, iE14, i37, p2.f2495a));
                        iE14 += i37;
                    }
                    while (iE14 < i10) {
                        int iE15 = a.a.E(bArr, iE14, gVar);
                        if (i11 != gVar.f2354a) {
                            return iE14;
                        }
                        iE14 = a.a.E(bArr, iE15, gVar);
                        int i38 = gVar.f2354a;
                        if (i38 < 0) {
                            throw r2.e();
                        }
                        if (i38 == 0) {
                            o2Var.add("");
                        } else {
                            o2Var.add(new String(bArr, iE14, i38, p2.f2495a));
                            iE14 += i38;
                        }
                    }
                    return iE14;
                }
                int iE16 = a.a.E(bArr, i2, gVar);
                int i39 = gVar.f2354a;
                if (i39 < 0) {
                    throw r2.e();
                }
                if (i39 == 0) {
                    o2Var.add("");
                } else {
                    int i40 = iE16 + i39;
                    if (l4.f2432a.H(bArr, iE16, i40) != 0) {
                        throw r2.b();
                    }
                    o2Var.add(new String(bArr, iE16, i39, p2.f2495a));
                    iE16 = i40;
                }
                while (iE16 < i10) {
                    int iE17 = a.a.E(bArr, iE16, gVar);
                    if (i11 != gVar.f2354a) {
                        return iE16;
                    }
                    iE16 = a.a.E(bArr, iE17, gVar);
                    int i41 = gVar.f2354a;
                    if (i41 < 0) {
                        throw r2.e();
                    }
                    if (i41 == 0) {
                        o2Var.add("");
                    } else {
                        int i42 = iE16 + i41;
                        if (l4.f2432a.H(bArr, iE16, i42) != 0) {
                            throw r2.b();
                        }
                        o2Var.add(new String(bArr, iE16, i41, p2.f2495a));
                        iE16 = i42;
                    }
                }
                return iE16;
            case a1.JAVA_STRING_CHECK_UTF8_FIELD_NUMBER /* 27 */:
                i16 = i2;
                if (i13 == 2) {
                    return a.a.w(q(i14), i11, bArr, i16, i10, o2Var, gVar);
                }
                return i16;
            case 28:
                i16 = i2;
                if (i13 == 2) {
                    int iE18 = a.a.E(bArr, i16, gVar);
                    int i43 = gVar.f2354a;
                    if (i43 < 0) {
                        throw r2.e();
                    }
                    if (i43 > bArr.length - iE18) {
                        throw r2.g();
                    }
                    if (i43 == 0) {
                        o2Var.add(l.f2424g);
                    } else {
                        o2Var.add(l.h(bArr, iE18, i43));
                        iE18 += i43;
                    }
                    while (iE18 < i10) {
                        int iE19 = a.a.E(bArr, iE18, gVar);
                        if (i11 != gVar.f2354a) {
                            return iE18;
                        }
                        iE18 = a.a.E(bArr, iE19, gVar);
                        int i44 = gVar.f2354a;
                        if (i44 < 0) {
                            throw r2.e();
                        }
                        if (i44 > bArr.length - iE18) {
                            throw r2.g();
                        }
                        if (i44 == 0) {
                            o2Var.add(l.f2424g);
                        } else {
                            o2Var.add(l.h(bArr, iE18, i44));
                            iE18 += i44;
                        }
                    }
                    return iE18;
                }
                return i16;
            case 30:
            case a1.PHP_METADATA_NAMESPACE_FIELD_NUMBER /* 44 */:
                i17 = i2;
                if (i13 != 2) {
                    if (i13 == 0) {
                        iG = a.a.G(i11, bArr, i17, i10, o2Var, gVar);
                    }
                    return i17;
                }
                j2 j2Var4 = (j2) o2Var;
                iG = a.a.E(bArr, i17, gVar);
                int i45 = gVar.f2354a + iG;
                while (iG < i45) {
                    iG = a.a.E(bArr, iG, gVar);
                    j2Var4.addInt(gVar.f2354a);
                }
                if (iG != i45) {
                    throw r2.g();
                }
                u3.j(obj, i12, o2Var, o(i14), null, this.f2378m);
                return iG;
            case 33:
            case 47:
                i17 = i2;
                if (i13 == 2) {
                    j2 j2Var5 = (j2) o2Var;
                    int iE20 = a.a.E(bArr, i17, gVar);
                    int i46 = gVar.f2354a + iE20;
                    while (iE20 < i46) {
                        iE20 = a.a.E(bArr, iE20, gVar);
                        j2Var5.addInt(o.b(gVar.f2354a));
                    }
                    if (iE20 == i46) {
                        return iE20;
                    }
                    throw r2.g();
                }
                if (i13 == 0) {
                    j2 j2Var6 = (j2) o2Var;
                    int iE21 = a.a.E(bArr, i17, gVar);
                    j2Var6.addInt(o.b(gVar.f2354a));
                    while (iE21 < i10) {
                        int iE22 = a.a.E(bArr, iE21, gVar);
                        if (i11 != gVar.f2354a) {
                            return iE21;
                        }
                        iE21 = a.a.E(bArr, iE22, gVar);
                        j2Var6.addInt(o.b(gVar.f2354a));
                    }
                    return iE21;
                }
                return i17;
            case 34:
            case 48:
                i17 = i2;
                if (i13 == 2) {
                    x2 x2Var5 = (x2) o2Var;
                    int iE23 = a.a.E(bArr, i17, gVar);
                    int i47 = gVar.f2354a + iE23;
                    while (iE23 < i47) {
                        iE23 = a.a.I(bArr, iE23, gVar);
                        x2Var5.addLong(o.c(gVar.f2355b));
                    }
                    if (iE23 == i47) {
                        return iE23;
                    }
                    throw r2.g();
                }
                if (i13 == 0) {
                    x2 x2Var6 = (x2) o2Var;
                    int I3 = a.a.I(bArr, i17, gVar);
                    x2Var6.addLong(o.c(gVar.f2355b));
                    while (I3 < i10) {
                        int iE24 = a.a.E(bArr, I3, gVar);
                        if (i11 != gVar.f2354a) {
                            return I3;
                        }
                        I3 = a.a.I(bArr, iE24, gVar);
                        x2Var6.addLong(o.c(gVar.f2355b));
                    }
                    return I3;
                }
                return i17;
            case 49:
                if (i13 == 3) {
                    t3 t3VarQ = q(i14);
                    int i48 = (i11 & (-8)) | 4;
                    Object objD = t3VarQ.d();
                    int iW = a.a.W(objD, t3VarQ, bArr, i2, i10, i48, gVar);
                    byte[] bArr2 = bArr;
                    int i49 = i48;
                    t3VarQ.b(objD);
                    gVar.f2356c = objD;
                    o2Var.add(objD);
                    while (iW < i10) {
                        int iE25 = a.a.E(bArr2, iW, gVar);
                        if (i11 != gVar.f2354a) {
                            return iW;
                        }
                        Object objD2 = t3VarQ.d();
                        byte[] bArr3 = bArr2;
                        int i50 = i49;
                        iW = a.a.W(objD2, t3VarQ, bArr3, iE25, i10, i50, gVar);
                        t3VarQ.b(objD2);
                        gVar.f2356c = objD2;
                        o2Var.add(objD2);
                        i49 = i50;
                        bArr2 = bArr3;
                    }
                    return iW;
                }
            default:
                return i2;
        }
    }

    public final void J(Object obj, long j2, androidx.datastore.preferences.protobuf.k kVar, t3 t3Var, u1 u1Var) throws q2 {
        int iX;
        this.f2377l.getClass();
        o2 o2VarA = u2.a(j2, obj);
        o oVar = (o) kVar.f896e;
        int i2 = kVar.f893b;
        if ((i2 & 7) != 3) {
            throw r2.c();
        }
        do {
            Object objD = t3Var.d();
            kVar.f(objD, t3Var, u1Var);
            t3Var.b(objD);
            o2VarA.add(objD);
            if (oVar.e() || kVar.f895d != 0) {
                return;
            } else {
                iX = oVar.x();
            }
        } while (iX == i2);
        kVar.f895d = iX;
    }

    public final void K(Object obj, int i2, androidx.datastore.preferences.protobuf.k kVar, t3 t3Var, u1 u1Var) throws r2 {
        int iX;
        this.f2377l.getClass();
        o2 o2VarA = u2.a(i2 & 1048575, obj);
        o oVar = (o) kVar.f896e;
        int i10 = kVar.f893b;
        if ((i10 & 7) != 2) {
            throw r2.c();
        }
        do {
            Object objD = t3Var.d();
            kVar.i(objD, t3Var, u1Var);
            t3Var.b(objD);
            o2VarA.add(objD);
            if (oVar.e() || kVar.f895d != 0) {
                return;
            } else {
                iX = oVar.x();
            }
        } while (iX == i10);
        kVar.f895d = iX;
    }

    public final void L(int i2, androidx.datastore.preferences.protobuf.k kVar, Object obj) throws androidx.datastore.preferences.protobuf.z, com.google.crypto.tink.shaded.protobuf.a0, q2 {
        if ((536870912 & i2) != 0) {
            kVar.V(2);
            i4.p(i2 & 1048575, obj, ((o) kVar.f896e).w());
        } else if (!this.f2372g) {
            i4.p(i2 & 1048575, obj, kVar.n());
        } else {
            kVar.V(2);
            i4.p(i2 & 1048575, obj, ((o) kVar.f896e).v());
        }
    }

    public final void M(int i2, androidx.datastore.preferences.protobuf.k kVar, Object obj) throws androidx.datastore.preferences.protobuf.z, com.google.crypto.tink.shaded.protobuf.a0, q2 {
        int i10 = 536870912 & i2;
        u2 u2Var = this.f2377l;
        if (i10 != 0) {
            u2Var.getClass();
            kVar.O(u2.a(i2 & 1048575, obj), true);
        } else {
            u2Var.getClass();
            kVar.O(u2.a(i2 & 1048575, obj), false);
        }
    }

    public final void O(int i2, Object obj) {
        int i10 = this.f2366a[i2 + 2];
        long j2 = 1048575 & i10;
        if (j2 == 1048575) {
            return;
        }
        i4.n((1 << (i10 >>> 20)) | i4.f2400c.g(j2, obj), j2, obj);
    }

    public final void P(int i2, int i10, Object obj) {
        i4.n(i2, this.f2366a[i10 + 2] & 1048575, obj);
    }

    public final int Q(int i2, int i10) {
        int[] iArr = this.f2366a;
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

    public final void R(int i2, Object obj, Object obj2) {
        f2365q.putObject(obj, U(i2) & 1048575, obj2);
        O(i2, obj);
    }

    public final void S(int i2, int i10, Object obj, Object obj2) {
        f2365q.putObject(obj, U(i10) & 1048575, obj2);
        P(i2, i10, obj);
    }

    public final int U(int i2) {
        return this.f2366a[i2 + 1];
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v1, types: [long] */
    /* JADX WARN: Type inference failed for: r17v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void V(java.lang.Object r23, com.google.protobuf.z2 r24) {
        /*
            Method dump skipped, instructions count: 1990
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.g3.V(java.lang.Object, com.google.protobuf.z2):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0022  */
    @Override // com.google.protobuf.t3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.lang.Object r11, java.lang.Object r12) {
        /*
            Method dump skipped, instructions count: 648
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.g3.a(java.lang.Object, java.lang.Object):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x007b  */
    @Override // com.google.protobuf.t3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(java.lang.Object r10) {
        /*
            r9 = this;
            boolean r0 = u(r10)
            if (r0 != 0) goto L8
            goto Lb3
        L8:
            boolean r0 = r10 instanceof com.google.protobuf.i2
            r1 = 0
            if (r0 == 0) goto L1b
            r0 = r10
            com.google.protobuf.i2 r0 = (com.google.protobuf.i2) r0
            r2 = 2147483647(0x7fffffff, float:NaN)
            r0.o(r2)
            r0.memoizedHashCode = r1
            r0.j()
        L1b:
            int[] r0 = r9.f2366a
            int r2 = r0.length
            r3 = r1
        L1f:
            if (r3 >= r2) goto L91
            int r4 = r9.U(r3)
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r4
            long r5 = (long) r5
            int r4 = T(r4)
            r7 = 9
            if (r4 == r7) goto L7b
            r7 = 60
            if (r4 == r7) goto L65
            r7 = 68
            if (r4 == r7) goto L65
            switch(r4) {
                case 17: goto L7b;
                case 18: goto L54;
                case 19: goto L54;
                case 20: goto L54;
                case 21: goto L54;
                case 22: goto L54;
                case 23: goto L54;
                case 24: goto L54;
                case 25: goto L54;
                case 26: goto L54;
                case 27: goto L54;
                case 28: goto L54;
                case 29: goto L54;
                case 30: goto L54;
                case 31: goto L54;
                case 32: goto L54;
                case 33: goto L54;
                case 34: goto L54;
                case 35: goto L54;
                case 36: goto L54;
                case 37: goto L54;
                case 38: goto L54;
                case 39: goto L54;
                case 40: goto L54;
                case 41: goto L54;
                case 42: goto L54;
                case 43: goto L54;
                case 44: goto L54;
                case 45: goto L54;
                case 46: goto L54;
                case 47: goto L54;
                case 48: goto L54;
                case 49: goto L54;
                case 50: goto L3e;
                default: goto L3d;
            }
        L3d:
            goto L8e
        L3e:
            sun.misc.Unsafe r4 = com.google.protobuf.g3.f2365q
            java.lang.Object r7 = r4.getObject(r10, r5)
            if (r7 == 0) goto L8e
            com.google.protobuf.c3 r8 = r9.f2380o
            r8.getClass()
            r8 = r7
            com.google.protobuf.b3 r8 = (com.google.protobuf.b3) r8
            r8.f2321f = r1
            r4.putObject(r10, r5, r7)
            goto L8e
        L54:
            com.google.protobuf.u2 r4 = r9.f2377l
            r4.getClass()
            com.google.protobuf.h4 r4 = com.google.protobuf.i4.f2400c
            java.lang.Object r4 = r4.i(r5, r10)
            com.google.protobuf.o2 r4 = (com.google.protobuf.o2) r4
            r4.makeImmutable()
            goto L8e
        L65:
            r4 = r0[r3]
            boolean r4 = r9.v(r4, r3, r10)
            if (r4 == 0) goto L8e
            com.google.protobuf.t3 r4 = r9.q(r3)
            sun.misc.Unsafe r7 = com.google.protobuf.g3.f2365q
            java.lang.Object r5 = r7.getObject(r10, r5)
            r4.b(r5)
            goto L8e
        L7b:
            boolean r4 = r9.s(r3, r10)
            if (r4 == 0) goto L8e
            com.google.protobuf.t3 r4 = r9.q(r3)
            sun.misc.Unsafe r7 = com.google.protobuf.g3.f2365q
            java.lang.Object r5 = r7.getObject(r10, r5)
            r4.b(r5)
        L8e:
            int r3 = r3 + 3
            goto L1f
        L91:
            com.google.protobuf.d4 r0 = r9.f2378m
            r0.getClass()
            r0 = r10
            com.google.protobuf.i2 r0 = (com.google.protobuf.i2) r0
            com.google.protobuf.c4 r0 = r0.unknownFields
            boolean r2 = r0.f2332e
            if (r2 == 0) goto La1
            r0.f2332e = r1
        La1:
            boolean r0 = r9.f2371f
            if (r0 == 0) goto Lb3
            com.google.protobuf.v1 r9 = r9.f2379n
            com.google.protobuf.w1 r9 = (com.google.protobuf.w1) r9
            r9.getClass()
            com.google.protobuf.h2 r10 = (com.google.protobuf.h2) r10
            com.google.protobuf.b2 r9 = r10.extensions
            r9.e()
        Lb3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.g3.b(java.lang.Object):void");
    }

    @Override // com.google.protobuf.t3
    public final boolean c(Object obj) {
        int i2;
        int i10;
        int i11;
        int i12 = 1048575;
        int i13 = 0;
        int i14 = 0;
        while (i14 < this.f2374i) {
            int i15 = this.f2373h[i14];
            int[] iArr = this.f2366a;
            int i16 = iArr[i15];
            int iU = U(i15);
            int i17 = iArr[i15 + 2];
            int i18 = i17 & 1048575;
            int i19 = 1 << (i17 >>> 20);
            if (i18 != i12) {
                if (i18 != 1048575) {
                    i13 = f2365q.getInt(obj, i18);
                }
                i10 = i15;
                i11 = i13;
                i2 = i18;
            } else {
                int i20 = i13;
                i2 = i12;
                i10 = i15;
                i11 = i20;
            }
            if ((268435456 & iU) == 0 || t(obj, i10, i2, i11, i19)) {
                int iT = T(iU);
                if (iT == 9 || iT == 17) {
                    if (t(obj, i10, i2, i11, i19)) {
                        if (!q(i10).c(i4.f2400c.i(iU & 1048575, obj))) {
                        }
                    } else {
                        continue;
                    }
                    i14++;
                    i12 = i2;
                    i13 = i11;
                } else {
                    if (iT != 27) {
                        if (iT == 60 || iT == 68) {
                            if (v(i16, i10, obj)) {
                                if (!q(i10).c(i4.f2400c.i(iU & 1048575, obj))) {
                                }
                            } else {
                                continue;
                            }
                            i14++;
                            i12 = i2;
                            i13 = i11;
                        } else if (iT != 49) {
                            if (iT != 50) {
                                continue;
                            } else {
                                Object objI = i4.f2400c.i(iU & 1048575, obj);
                                this.f2380o.getClass();
                                b3 b3Var = (b3) objI;
                                if (!b3Var.isEmpty() && ((s4) ((a3) p(i10)).f2304a.f4688h).f2528f == t4.f2551n) {
                                    t3 t3VarA = null;
                                    for (Object obj2 : b3Var.values()) {
                                        if (t3VarA == null) {
                                            t3VarA = q3.f2501c.a(obj2.getClass());
                                        }
                                        if (!t3VarA.c(obj2)) {
                                        }
                                    }
                                }
                            }
                            i14++;
                            i12 = i2;
                            i13 = i11;
                        }
                    }
                    List list = (List) i4.f2400c.i(iU & 1048575, obj);
                    if (list.isEmpty()) {
                        continue;
                    } else {
                        t3 t3VarQ = q(i10);
                        for (int i21 = 0; i21 < list.size(); i21++) {
                            if (t3VarQ.c(list.get(i21))) {
                            }
                        }
                    }
                    i14++;
                    i12 = i2;
                    i13 = i11;
                }
            }
            return false;
        }
        if (this.f2371f) {
            ((w1) this.f2379n).getClass();
            ((h2) obj).extensions.c();
        }
        return true;
    }

    @Override // com.google.protobuf.t3
    public final Object d() {
        this.f2376k.getClass();
        return ((i2) this.f2370e).k();
    }

    /* JADX WARN: Removed duplicated region for block: B:143:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01c1  */
    @Override // com.google.protobuf.t3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int e(com.google.protobuf.i2 r17) {
        /*
            Method dump skipped, instructions count: 1958
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.g3.e(com.google.protobuf.i2):int");
    }

    @Override // com.google.protobuf.t3
    public final void f(Object obj, z2 z2Var) {
        z2Var.getClass();
        V(obj, z2Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    @Override // com.google.protobuf.t3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean g(com.google.protobuf.i2 r12, com.google.protobuf.i2 r13) {
        /*
            Method dump skipped, instructions count: 688
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.g3.g(com.google.protobuf.i2, com.google.protobuf.i2):boolean");
    }

    @Override // com.google.protobuf.t3
    public final void h(Object obj, byte[] bArr, int i2, int i10, g gVar) {
        G(obj, bArr, i2, i10, 0, gVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00e1 A[PHI: r3
      0x00e1: PHI (r3v32 int) = (r3v10 int), (r3v33 int) binds: [B:83:0x0216, B:41:0x00df] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.protobuf.t3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int i(com.google.protobuf.i2 r12) {
        /*
            Method dump skipped, instructions count: 818
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.g3.i(com.google.protobuf.i2):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:345:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008e, code lost:
    
        com.google.protobuf.d4.c(r6, r4);
     */
    /* JADX WARN: Removed duplicated region for block: B:248:0x08de A[Catch: all -> 0x0574, TryCatch #9 {all -> 0x0574, blocks: (B:246:0x08d9, B:248:0x08de, B:249:0x08e3, B:187:0x0565, B:190:0x0577, B:191:0x058c, B:199:0x05b3, B:200:0x05b8, B:201:0x05d0, B:202:0x05e8, B:203:0x0600, B:204:0x0618, B:205:0x0630, B:206:0x0648, B:207:0x0660, B:208:0x0678, B:209:0x0696, B:210:0x06b7, B:211:0x06d8, B:212:0x06f9, B:213:0x071a, B:215:0x0736, B:218:0x073d, B:219:0x0743, B:220:0x074f, B:221:0x0770, B:222:0x0789, B:223:0x07a7, B:224:0x07b8, B:225:0x07db, B:226:0x07fc, B:227:0x081d, B:228:0x083e, B:229:0x085f, B:230:0x087f, B:231:0x08a1, B:237:0x08c3), top: B:278:0x08d9 }] */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0916 A[LOOP:3: B:263:0x0914->B:264:0x0916, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0925  */
    /* JADX WARN: Removed duplicated region for block: B:333:0x08ea A[SYNTHETIC] */
    @Override // com.google.protobuf.t3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j(java.lang.Object r19, androidx.datastore.preferences.protobuf.k r20, com.google.protobuf.u1 r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 2490
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.g3.j(java.lang.Object, androidx.datastore.preferences.protobuf.k, com.google.protobuf.u1):void");
    }

    public final boolean k(i2 i2Var, i2 i2Var2, int i2) {
        return s(i2, i2Var) == s(i2, i2Var2);
    }

    public final Object n(Object obj, int i2, Object obj2, d4 d4Var, Object obj3) {
        l2 l2VarO;
        int i10 = this.f2366a[i2];
        Object objI = i4.f2400c.i(U(i2) & 1048575, obj);
        if (objI == null || (l2VarO = o(i2)) == null) {
            return obj2;
        }
        this.f2380o.getClass();
        i5.l lVar = ((a3) p(i2)).f2304a;
        Iterator it = ((b3) objI).entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (!l2VarO.a(((Integer) entry.getValue()).intValue())) {
                if (obj2 == null) {
                    d4Var.getClass();
                    obj2 = d4.a(obj3);
                }
                int iA = a3.a(lVar, entry.getKey(), entry.getValue());
                byte[] bArr = new byte[iA];
                Logger logger = r.f2504b;
                p pVar = new p(iA, bArr);
                try {
                    a3.b(pVar, lVar, entry.getKey(), entry.getValue());
                    if (pVar.u0() != 0) {
                        throw new IllegalStateException("Did not write as much data as expected.");
                    }
                    k kVar = new k(bArr);
                    d4Var.getClass();
                    ((c4) obj2).d((i10 << 3) | 2, kVar);
                    it.remove();
                } catch (IOException e10) {
                    throw new RuntimeException(e10);
                }
            }
        }
        return obj2;
    }

    public final l2 o(int i2) {
        return (l2) this.f2367b[((i2 / 3) * 2) + 1];
    }

    public final Object p(int i2) {
        return this.f2367b[(i2 / 3) * 2];
    }

    public final t3 q(int i2) {
        int i10 = (i2 / 3) * 2;
        Object[] objArr = this.f2367b;
        t3 t3Var = (t3) objArr[i10];
        if (t3Var != null) {
            return t3Var;
        }
        t3 t3VarA = q3.f2501c.a((Class) objArr[i10 + 1]);
        objArr[i10] = t3VarA;
        return t3VarA;
    }

    public final boolean s(int i2, Object obj) {
        int i10 = this.f2366a[i2 + 2];
        long j2 = i10 & 1048575;
        if (j2 == 1048575) {
            int iU = U(i2);
            long j4 = iU & 1048575;
            switch (T(iU)) {
                case 0:
                    if (Double.doubleToRawLongBits(i4.f2400c.e(j4, obj)) == 0) {
                        return false;
                    }
                    break;
                case 1:
                    if (Float.floatToRawIntBits(i4.f2400c.f(j4, obj)) == 0) {
                        return false;
                    }
                    break;
                case 2:
                    if (i4.f2400c.h(j4, obj) == 0) {
                        return false;
                    }
                    break;
                case 3:
                    if (i4.f2400c.h(j4, obj) == 0) {
                        return false;
                    }
                    break;
                case 4:
                    if (i4.f2400c.g(j4, obj) == 0) {
                        return false;
                    }
                    break;
                case 5:
                    if (i4.f2400c.h(j4, obj) == 0) {
                        return false;
                    }
                    break;
                case 6:
                    if (i4.f2400c.g(j4, obj) == 0) {
                        return false;
                    }
                    break;
                case 7:
                    return i4.f2400c.c(j4, obj);
                case 8:
                    Object objI = i4.f2400c.i(j4, obj);
                    if (objI instanceof String) {
                        return !((String) objI).isEmpty();
                    }
                    if (objI instanceof l) {
                        return !l.f2424g.equals(objI);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    if (i4.f2400c.i(j4, obj) == null) {
                        return false;
                    }
                    break;
                case 10:
                    return !l.f2424g.equals(i4.f2400c.i(j4, obj));
                case 11:
                    if (i4.f2400c.g(j4, obj) == 0) {
                        return false;
                    }
                    break;
                case 12:
                    if (i4.f2400c.g(j4, obj) == 0) {
                        return false;
                    }
                    break;
                case 13:
                    if (i4.f2400c.g(j4, obj) == 0) {
                        return false;
                    }
                    break;
                case y0.EDITION_FIELD_NUMBER /* 14 */:
                    if (i4.f2400c.h(j4, obj) == 0) {
                        return false;
                    }
                    break;
                case x0.UNVERIFIED_LAZY_FIELD_NUMBER /* 15 */:
                    if (i4.f2400c.g(j4, obj) == 0) {
                        return false;
                    }
                    break;
                case 16:
                    if (i4.f2400c.h(j4, obj) == 0) {
                        return false;
                    }
                    break;
                case 17:
                    if (i4.f2400c.i(j4, obj) == null) {
                        return false;
                    }
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        } else if (((1 << (i10 >>> 20)) & i4.f2400c.g(j2, obj)) == 0) {
            return false;
        }
        return true;
    }

    public final boolean t(Object obj, int i2, int i10, int i11, int i12) {
        return i10 == 1048575 ? s(i2, obj) : (i11 & i12) != 0;
    }

    public final boolean v(int i2, int i10, Object obj) {
        return i4.f2400c.g((long) (this.f2366a[i10 + 2] & 1048575), obj) == i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x009f, code lost:
    
        r9.put(r2, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a2, code lost:
    
        r10.g(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a5, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void w(java.lang.Object r8, int r9, java.lang.Object r10, com.google.protobuf.u1 r11, androidx.datastore.preferences.protobuf.k r12) throws androidx.datastore.preferences.protobuf.z, com.google.crypto.tink.shaded.protobuf.a0, com.google.protobuf.q2 {
        /*
            r7 = this;
            int r9 = r7.U(r9)
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r9 = r9 & r0
            long r0 = (long) r9
            com.google.protobuf.h4 r9 = com.google.protobuf.i4.f2400c
            java.lang.Object r9 = r9.i(r0, r8)
            com.google.protobuf.c3 r7 = r7.f2380o
            if (r9 != 0) goto L20
            r7.getClass()
            com.google.protobuf.b3 r9 = com.google.protobuf.b3.f2320g
            com.google.protobuf.b3 r9 = r9.c()
            com.google.protobuf.i4.p(r0, r8, r9)
            goto L37
        L20:
            r7.getClass()
            r2 = r9
            com.google.protobuf.b3 r2 = (com.google.protobuf.b3) r2
            boolean r2 = r2.f2321f
            if (r2 != 0) goto L37
            com.google.protobuf.b3 r2 = com.google.protobuf.b3.f2320g
            com.google.protobuf.b3 r2 = r2.c()
            com.google.protobuf.c3.a(r2, r9)
            com.google.protobuf.i4.p(r0, r8, r2)
            r9 = r2
        L37:
            r7.getClass()
            com.google.protobuf.b3 r9 = (com.google.protobuf.b3) r9
            com.google.protobuf.a3 r10 = (com.google.protobuf.a3) r10
            i5.l r7 = r10.f2304a
            r8 = 2
            r12.V(r8)
            java.lang.Object r10 = r12.f896e
            com.google.protobuf.o r10 = (com.google.protobuf.o) r10
            int r0 = r10.y()
            int r0 = r10.h(r0)
            java.lang.Object r1 = r7.f4689i
            java.lang.String r2 = ""
            r3 = r1
        L55:
            int r4 = r12.a()     // Catch: java.lang.Throwable -> L79
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L9f
            boolean r5 = r10.e()     // Catch: java.lang.Throwable -> L79
            if (r5 == 0) goto L65
            goto L9f
        L65:
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L88
            if (r4 == r8) goto L7b
            boolean r4 = r12.W()     // Catch: java.lang.Throwable -> L79 com.google.protobuf.q2 -> L92
            if (r4 == 0) goto L73
            goto L55
        L73:
            com.google.protobuf.r2 r4 = new com.google.protobuf.r2     // Catch: java.lang.Throwable -> L79 com.google.protobuf.q2 -> L92
            r4.<init>(r6)     // Catch: java.lang.Throwable -> L79 com.google.protobuf.q2 -> L92
            throw r4     // Catch: java.lang.Throwable -> L79 com.google.protobuf.q2 -> L92
        L79:
            r7 = move-exception
            goto La6
        L7b:
            java.lang.Object r4 = r7.f4688h     // Catch: java.lang.Throwable -> L79 com.google.protobuf.q2 -> L92
            com.google.protobuf.s4 r4 = (com.google.protobuf.s4) r4     // Catch: java.lang.Throwable -> L79 com.google.protobuf.q2 -> L92
            java.lang.Class r5 = r1.getClass()     // Catch: java.lang.Throwable -> L79 com.google.protobuf.q2 -> L92
            java.lang.Object r3 = r12.v(r4, r5, r11)     // Catch: java.lang.Throwable -> L79 com.google.protobuf.q2 -> L92
            goto L55
        L88:
            java.lang.Object r4 = r7.f4687g     // Catch: java.lang.Throwable -> L79 com.google.protobuf.q2 -> L92
            com.google.protobuf.s4 r4 = (com.google.protobuf.s4) r4     // Catch: java.lang.Throwable -> L79 com.google.protobuf.q2 -> L92
            r5 = 0
            java.lang.Object r2 = r12.v(r4, r5, r5)     // Catch: java.lang.Throwable -> L79 com.google.protobuf.q2 -> L92
            goto L55
        L92:
            boolean r4 = r12.W()     // Catch: java.lang.Throwable -> L79
            if (r4 == 0) goto L99
            goto L55
        L99:
            com.google.protobuf.r2 r7 = new com.google.protobuf.r2     // Catch: java.lang.Throwable -> L79
            r7.<init>(r6)     // Catch: java.lang.Throwable -> L79
            throw r7     // Catch: java.lang.Throwable -> L79
        L9f:
            r9.put(r2, r3)     // Catch: java.lang.Throwable -> L79
            r10.g(r0)
            return
        La6:
            r10.g(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.g3.w(java.lang.Object, int, java.lang.Object, com.google.protobuf.u1, androidx.datastore.preferences.protobuf.k):void");
    }

    public final void x(int i2, Object obj, Object obj2) {
        if (s(i2, obj2)) {
            long jU = U(i2) & 1048575;
            Unsafe unsafe = f2365q;
            Object object = unsafe.getObject(obj2, jU);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.f2366a[i2] + " is present but null: " + obj2);
            }
            t3 t3VarQ = q(i2);
            if (!s(i2, obj)) {
                if (u(object)) {
                    Object objD = t3VarQ.d();
                    t3VarQ.a(objD, object);
                    unsafe.putObject(obj, jU, objD);
                } else {
                    unsafe.putObject(obj, jU, object);
                }
                O(i2, obj);
                return;
            }
            Object object2 = unsafe.getObject(obj, jU);
            if (!u(object2)) {
                Object objD2 = t3VarQ.d();
                t3VarQ.a(objD2, object2);
                unsafe.putObject(obj, jU, objD2);
                object2 = objD2;
            }
            t3VarQ.a(object2, object);
        }
    }

    public final void y(int i2, Object obj, Object obj2) {
        int[] iArr = this.f2366a;
        int i10 = iArr[i2];
        if (v(i10, i2, obj2)) {
            long jU = U(i2) & 1048575;
            Unsafe unsafe = f2365q;
            Object object = unsafe.getObject(obj2, jU);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + iArr[i2] + " is present but null: " + obj2);
            }
            t3 t3VarQ = q(i2);
            if (!v(i10, i2, obj)) {
                if (u(object)) {
                    Object objD = t3VarQ.d();
                    t3VarQ.a(objD, object);
                    unsafe.putObject(obj, jU, objD);
                } else {
                    unsafe.putObject(obj, jU, object);
                }
                P(i10, i2, obj);
                return;
            }
            Object object2 = unsafe.getObject(obj, jU);
            if (!u(object2)) {
                Object objD2 = t3VarQ.d();
                t3VarQ.a(objD2, object2);
                unsafe.putObject(obj, jU, objD2);
                object2 = objD2;
            }
            t3VarQ.a(object2, object);
        }
    }

    public final Object z(int i2, Object obj) {
        t3 t3VarQ = q(i2);
        long jU = U(i2) & 1048575;
        if (!s(i2, obj)) {
            return t3VarQ.d();
        }
        Object object = f2365q.getObject(obj, jU);
        if (u(object)) {
            return object;
        }
        Object objD = t3VarQ.d();
        if (object != null) {
            t3VarQ.a(objD, object);
        }
        return objD;
    }
}
