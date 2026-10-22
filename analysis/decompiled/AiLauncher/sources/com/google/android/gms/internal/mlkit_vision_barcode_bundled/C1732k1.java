package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.Arrays;
import sun.misc.Unsafe;

/* renamed from: com.google.android.gms.internal.mlkit_vision_barcode_bundled.k1, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C1732k1<T> implements InterfaceC1791z1<T> {

    /* renamed from: l, reason: collision with root package name */
    public static final int[] f20093l = new int[0];

    /* renamed from: m, reason: collision with root package name */
    public static final Unsafe f20094m = T1.l();

    /* renamed from: a, reason: collision with root package name */
    public final int[] f20095a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f20096b;

    /* renamed from: c, reason: collision with root package name */
    public final int f20097c;

    /* renamed from: d, reason: collision with root package name */
    public final int f20098d;

    /* renamed from: e, reason: collision with root package name */
    public final InterfaceC1720h1 f20099e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f20100f;

    /* renamed from: g, reason: collision with root package name */
    public final int[] f20101g;

    /* renamed from: h, reason: collision with root package name */
    public final int f20102h;

    /* renamed from: i, reason: collision with root package name */
    public final int f20103i;

    /* renamed from: j, reason: collision with root package name */
    public final M1 f20104j;

    /* renamed from: k, reason: collision with root package name */
    public final AbstractC1762s0 f20105k;

    public C1732k1(int[] iArr, Object[] objArr, int i10, int i11, InterfaceC1720h1 interfaceC1720h1, boolean z10, int[] iArr2, int i12, int i13, C1744n1 c1744n1, U0 u02, M1 m12, AbstractC1762s0 abstractC1762s0, C1697c1 c1697c1) {
        this.f20095a = iArr;
        this.f20096b = objArr;
        this.f20097c = i10;
        this.f20098d = i11;
        boolean z11 = false;
        if (abstractC1762s0 != null && (interfaceC1720h1 instanceof C0)) {
            z11 = true;
        }
        this.f20100f = z11;
        this.f20101g = iArr2;
        this.f20102h = i12;
        this.f20103i = i13;
        this.f20104j = m12;
        this.f20105k = abstractC1762s0;
        this.f20099e = interfaceC1720h1;
    }

    public static double A(Object obj, long j10) {
        return ((Double) T1.k(obj, j10)).doubleValue();
    }

    public static float B(Object obj, long j10) {
        return ((Float) T1.k(obj, j10)).floatValue();
    }

    public static int C(Object obj, long j10) {
        return ((Integer) T1.k(obj, j10)).intValue();
    }

    public static int F(int i10) {
        return (i10 >>> 20) & 255;
    }

    public static long H(Object obj, long j10) {
        return ((Long) T1.k(obj, j10)).longValue();
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

    public static void i(Object obj) {
        if (!t(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    public static boolean s(Object obj, int i10, InterfaceC1791z1 interfaceC1791z1) {
        return interfaceC1791z1.h(T1.k(obj, i10 & 1048575));
    }

    public static boolean t(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof F0) {
            return ((F0) obj).C();
        }
        return true;
    }

    public static boolean v(Object obj, long j10) {
        return ((Boolean) T1.k(obj, j10)).booleanValue();
    }

    public static final void w(int i10, Object obj, Z1 z12) throws IOException {
        if (obj instanceof String) {
            z12.b(i10, (String) obj);
        } else {
            z12.j(i10, (zzdf) obj);
        }
    }

    public static N1 y(Object obj) {
        F0 f02 = (F0) obj;
        N1 n12 = f02.zzc;
        if (n12 != N1.c()) {
            return n12;
        }
        N1 n1F = N1.f();
        f02.zzc = n1F;
        return n1F;
    }

    /* JADX WARN: Removed duplicated region for block: B:126:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x03a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.internal.mlkit_vision_barcode_bundled.C1732k1 z(java.lang.Class r32, com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1707e1 r33, com.google.android.gms.internal.mlkit_vision_barcode_bundled.C1744n1 r34, com.google.android.gms.internal.mlkit_vision_barcode_bundled.U0 r35, com.google.android.gms.internal.mlkit_vision_barcode_bundled.M1 r36, com.google.android.gms.internal.mlkit_vision_barcode_bundled.AbstractC1762s0 r37, com.google.android.gms.internal.mlkit_vision_barcode_bundled.C1697c1 r38) {
        /*
            Method dump skipped, instructions count: 1046
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode_bundled.C1732k1.z(java.lang.Class, com.google.android.gms.internal.mlkit_vision_barcode_bundled.e1, com.google.android.gms.internal.mlkit_vision_barcode_bundled.n1, com.google.android.gms.internal.mlkit_vision_barcode_bundled.U0, com.google.android.gms.internal.mlkit_vision_barcode_bundled.M1, com.google.android.gms.internal.mlkit_vision_barcode_bundled.s0, com.google.android.gms.internal.mlkit_vision_barcode_bundled.c1):com.google.android.gms.internal.mlkit_vision_barcode_bundled.k1");
    }

    public final int D(int i10) {
        return this.f20095a[i10 + 2];
    }

    public final int E(int i10, int i11) {
        int length = (this.f20095a.length / 3) - 1;
        while (i11 <= length) {
            int i12 = (length + i11) >>> 1;
            int i13 = i12 * 3;
            int i14 = this.f20095a[i13];
            if (i10 == i14) {
                return i13;
            }
            if (i10 < i14) {
                length = i12 - 1;
            } else {
                i11 = i12 + 1;
            }
        }
        return -1;
    }

    public final int G(int i10) {
        return this.f20095a[i10 + 1];
    }

    public final J0 I(int i10) {
        int i11 = i10 / 3;
        return (J0) this.f20096b[i11 + i11 + 1];
    }

    public final InterfaceC1791z1 J(int i10) {
        Object[] objArr = this.f20096b;
        int i11 = i10 / 3;
        int i12 = i11 + i11;
        InterfaceC1791z1 interfaceC1791z1 = (InterfaceC1791z1) objArr[i12];
        if (interfaceC1791z1 != null) {
            return interfaceC1791z1;
        }
        InterfaceC1791z1 interfaceC1791z1B = C1752p1.a().b((Class) objArr[i12 + 1]);
        this.f20096b[i12] = interfaceC1791z1B;
        return interfaceC1791z1B;
    }

    public final Object K(int i10) {
        int i11 = i10 / 3;
        return this.f20096b[i11 + i11];
    }

    public final Object L(Object obj, int i10) {
        InterfaceC1791z1 interfaceC1791z1J = J(i10);
        int iG = G(i10) & 1048575;
        if (!q(obj, i10)) {
            return interfaceC1791z1J.zze();
        }
        Object object = f20094m.getObject(obj, iG);
        if (t(object)) {
            return object;
        }
        Object objZze = interfaceC1791z1J.zze();
        if (object != null) {
            interfaceC1791z1J.e(objZze, object);
        }
        return objZze;
    }

    public final Object M(Object obj, int i10, int i11) {
        InterfaceC1791z1 interfaceC1791z1J = J(i11);
        if (!u(obj, i10, i11)) {
            return interfaceC1791z1J.zze();
        }
        Object object = f20094m.getObject(obj, G(i11) & 1048575);
        if (t(object)) {
            return object;
        }
        Object objZze = interfaceC1791z1J.zze();
        if (object != null) {
            interfaceC1791z1J.e(objZze, object);
        }
        return objZze;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0071  */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1791z1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.lang.Object r8) {
        /*
            r7 = this;
            boolean r0 = t(r8)
            if (r0 != 0) goto L8
            goto L95
        L8:
            boolean r0 = r8 instanceof com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0
            r1 = 0
            if (r0 == 0) goto L1b
            r0 = r8
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0 r0 = (com.google.android.gms.internal.mlkit_vision_barcode_bundled.F0) r0
            r2 = 2147483647(0x7fffffff, float:NaN)
            r0.A(r2)
            r0.zza = r1
            r0.y()
        L1b:
            int[] r0 = r7.f20095a
        L1d:
            int r2 = r0.length
            if (r1 >= r2) goto L87
            int r2 = r7.G(r1)
            r3 = 1048575(0xfffff, float:1.469367E-39)
            r3 = r3 & r2
            int r2 = F(r2)
            long r3 = (long) r3
            r5 = 9
            if (r2 == r5) goto L71
            r5 = 60
            if (r2 == r5) goto L59
            r5 = 68
            if (r2 == r5) goto L59
            switch(r2) {
                case 17: goto L71;
                case 18: goto L4f;
                case 19: goto L4f;
                case 20: goto L4f;
                case 21: goto L4f;
                case 22: goto L4f;
                case 23: goto L4f;
                case 24: goto L4f;
                case 25: goto L4f;
                case 26: goto L4f;
                case 27: goto L4f;
                case 28: goto L4f;
                case 29: goto L4f;
                case 30: goto L4f;
                case 31: goto L4f;
                case 32: goto L4f;
                case 33: goto L4f;
                case 34: goto L4f;
                case 35: goto L4f;
                case 36: goto L4f;
                case 37: goto L4f;
                case 38: goto L4f;
                case 39: goto L4f;
                case 40: goto L4f;
                case 41: goto L4f;
                case 42: goto L4f;
                case 43: goto L4f;
                case 44: goto L4f;
                case 45: goto L4f;
                case 46: goto L4f;
                case 47: goto L4f;
                case 48: goto L4f;
                case 49: goto L4f;
                case 50: goto L3d;
                default: goto L3c;
            }
        L3c:
            goto L84
        L3d:
            sun.misc.Unsafe r2 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.C1732k1.f20094m
            java.lang.Object r5 = r2.getObject(r8, r3)
            if (r5 == 0) goto L84
            r6 = r5
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfg r6 = (com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfg) r6
            r6.h()
            r2.putObject(r8, r3, r5)
            goto L84
        L4f:
            java.lang.Object r2 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.T1.k(r8, r3)
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.M0 r2 = (com.google.android.gms.internal.mlkit_vision_barcode_bundled.M0) r2
            r2.zzb()
            goto L84
        L59:
            int[] r2 = r7.f20095a
            r2 = r2[r1]
            boolean r2 = r7.u(r8, r2, r1)
            if (r2 == 0) goto L84
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.z1 r2 = r7.J(r1)
            sun.misc.Unsafe r5 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.C1732k1.f20094m
            java.lang.Object r3 = r5.getObject(r8, r3)
            r2.a(r3)
            goto L84
        L71:
            boolean r2 = r7.q(r8, r1)
            if (r2 == 0) goto L84
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.z1 r2 = r7.J(r1)
            sun.misc.Unsafe r5 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.C1732k1.f20094m
            java.lang.Object r3 = r5.getObject(r8, r3)
            r2.a(r3)
        L84:
            int r1 = r1 + 3
            goto L1d
        L87:
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.M1 r0 = r7.f20104j
            r0.a(r8)
            boolean r0 = r7.f20100f
            if (r0 == 0) goto L95
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.s0 r7 = r7.f20105k
            r7.a(r8)
        L95:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode_bundled.C1732k1.a(java.lang.Object):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0023  */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1791z1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(java.lang.Object r21, com.google.android.gms.internal.mlkit_vision_barcode_bundled.Z1 r22) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1522
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode_bundled.C1732k1.b(java.lang.Object, com.google.android.gms.internal.mlkit_vision_barcode_bundled.Z1):void");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1791z1
    public final int c(Object obj) {
        int i10;
        long jDoubleToLongBits;
        int iFloatToIntBits;
        int i11;
        int i12 = 0;
        for (int i13 = 0; i13 < this.f20095a.length; i13 += 3) {
            int iG = G(i13);
            int[] iArr = this.f20095a;
            int i14 = 1048575 & iG;
            int iF = F(iG);
            int i15 = iArr[i13];
            long j10 = i14;
            int iHashCode = 37;
            switch (iF) {
                case 0:
                    i10 = i12 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(T1.f(obj, j10));
                    Charset charset = N0.f20038a;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i12 = i10 + iFloatToIntBits;
                    break;
                case 1:
                    i10 = i12 * 53;
                    iFloatToIntBits = Float.floatToIntBits(T1.g(obj, j10));
                    i12 = i10 + iFloatToIntBits;
                    break;
                case 2:
                    i10 = i12 * 53;
                    jDoubleToLongBits = T1.i(obj, j10);
                    Charset charset2 = N0.f20038a;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i12 = i10 + iFloatToIntBits;
                    break;
                case 3:
                    i10 = i12 * 53;
                    jDoubleToLongBits = T1.i(obj, j10);
                    Charset charset3 = N0.f20038a;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i12 = i10 + iFloatToIntBits;
                    break;
                case 4:
                    i10 = i12 * 53;
                    iFloatToIntBits = T1.h(obj, j10);
                    i12 = i10 + iFloatToIntBits;
                    break;
                case 5:
                    i10 = i12 * 53;
                    jDoubleToLongBits = T1.i(obj, j10);
                    Charset charset4 = N0.f20038a;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i12 = i10 + iFloatToIntBits;
                    break;
                case 6:
                    i10 = i12 * 53;
                    iFloatToIntBits = T1.h(obj, j10);
                    i12 = i10 + iFloatToIntBits;
                    break;
                case 7:
                    i10 = i12 * 53;
                    iFloatToIntBits = N0.a(T1.B(obj, j10));
                    i12 = i10 + iFloatToIntBits;
                    break;
                case 8:
                    i10 = i12 * 53;
                    iFloatToIntBits = ((String) T1.k(obj, j10)).hashCode();
                    i12 = i10 + iFloatToIntBits;
                    break;
                case 9:
                    i11 = i12 * 53;
                    Object objK = T1.k(obj, j10);
                    if (objK != null) {
                        iHashCode = objK.hashCode();
                    }
                    i12 = i11 + iHashCode;
                    break;
                case 10:
                    i10 = i12 * 53;
                    iFloatToIntBits = T1.k(obj, j10).hashCode();
                    i12 = i10 + iFloatToIntBits;
                    break;
                case 11:
                    i10 = i12 * 53;
                    iFloatToIntBits = T1.h(obj, j10);
                    i12 = i10 + iFloatToIntBits;
                    break;
                case 12:
                    i10 = i12 * 53;
                    iFloatToIntBits = T1.h(obj, j10);
                    i12 = i10 + iFloatToIntBits;
                    break;
                case 13:
                    i10 = i12 * 53;
                    iFloatToIntBits = T1.h(obj, j10);
                    i12 = i10 + iFloatToIntBits;
                    break;
                case 14:
                    i10 = i12 * 53;
                    jDoubleToLongBits = T1.i(obj, j10);
                    Charset charset5 = N0.f20038a;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i12 = i10 + iFloatToIntBits;
                    break;
                case 15:
                    i10 = i12 * 53;
                    iFloatToIntBits = T1.h(obj, j10);
                    i12 = i10 + iFloatToIntBits;
                    break;
                case 16:
                    i10 = i12 * 53;
                    jDoubleToLongBits = T1.i(obj, j10);
                    Charset charset6 = N0.f20038a;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i12 = i10 + iFloatToIntBits;
                    break;
                case 17:
                    i11 = i12 * 53;
                    Object objK2 = T1.k(obj, j10);
                    if (objK2 != null) {
                        iHashCode = objK2.hashCode();
                    }
                    i12 = i11 + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i10 = i12 * 53;
                    iFloatToIntBits = T1.k(obj, j10).hashCode();
                    i12 = i10 + iFloatToIntBits;
                    break;
                case 50:
                    i10 = i12 * 53;
                    iFloatToIntBits = T1.k(obj, j10).hashCode();
                    i12 = i10 + iFloatToIntBits;
                    break;
                case 51:
                    if (u(obj, i15, i13)) {
                        i10 = i12 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(A(obj, j10));
                        Charset charset7 = N0.f20038a;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i12 = i10 + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (u(obj, i15, i13)) {
                        i10 = i12 * 53;
                        iFloatToIntBits = Float.floatToIntBits(B(obj, j10));
                        i12 = i10 + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (u(obj, i15, i13)) {
                        i10 = i12 * 53;
                        jDoubleToLongBits = H(obj, j10);
                        Charset charset8 = N0.f20038a;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i12 = i10 + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (u(obj, i15, i13)) {
                        i10 = i12 * 53;
                        jDoubleToLongBits = H(obj, j10);
                        Charset charset9 = N0.f20038a;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i12 = i10 + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (u(obj, i15, i13)) {
                        i10 = i12 * 53;
                        iFloatToIntBits = C(obj, j10);
                        i12 = i10 + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (u(obj, i15, i13)) {
                        i10 = i12 * 53;
                        jDoubleToLongBits = H(obj, j10);
                        Charset charset10 = N0.f20038a;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i12 = i10 + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (u(obj, i15, i13)) {
                        i10 = i12 * 53;
                        iFloatToIntBits = C(obj, j10);
                        i12 = i10 + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (u(obj, i15, i13)) {
                        i10 = i12 * 53;
                        iFloatToIntBits = N0.a(v(obj, j10));
                        i12 = i10 + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (u(obj, i15, i13)) {
                        i10 = i12 * 53;
                        iFloatToIntBits = ((String) T1.k(obj, j10)).hashCode();
                        i12 = i10 + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (u(obj, i15, i13)) {
                        i10 = i12 * 53;
                        iFloatToIntBits = T1.k(obj, j10).hashCode();
                        i12 = i10 + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (u(obj, i15, i13)) {
                        i10 = i12 * 53;
                        iFloatToIntBits = T1.k(obj, j10).hashCode();
                        i12 = i10 + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (u(obj, i15, i13)) {
                        i10 = i12 * 53;
                        iFloatToIntBits = C(obj, j10);
                        i12 = i10 + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (u(obj, i15, i13)) {
                        i10 = i12 * 53;
                        iFloatToIntBits = C(obj, j10);
                        i12 = i10 + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (u(obj, i15, i13)) {
                        i10 = i12 * 53;
                        iFloatToIntBits = C(obj, j10);
                        i12 = i10 + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (u(obj, i15, i13)) {
                        i10 = i12 * 53;
                        jDoubleToLongBits = H(obj, j10);
                        Charset charset11 = N0.f20038a;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i12 = i10 + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (u(obj, i15, i13)) {
                        i10 = i12 * 53;
                        iFloatToIntBits = C(obj, j10);
                        i12 = i10 + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (u(obj, i15, i13)) {
                        i10 = i12 * 53;
                        jDoubleToLongBits = H(obj, j10);
                        Charset charset12 = N0.f20038a;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i12 = i10 + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (u(obj, i15, i13)) {
                        i10 = i12 * 53;
                        iFloatToIntBits = T1.k(obj, j10).hashCode();
                        i12 = i10 + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int iHashCode2 = (i12 * 53) + ((F0) obj).zzc.hashCode();
        return this.f20100f ? (iHashCode2 * 53) + ((C0) obj).zzb.f20143a.hashCode() : iHashCode2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0481  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0714 A[PHI: r0
      0x0714: PHI (r0v9 com.google.android.gms.internal.mlkit_vision_barcode_bundled.k1<T>) = 
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.k1<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.k1<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.k1<T>)
      (r0v46 com.google.android.gms.internal.mlkit_vision_barcode_bundled.k1<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.k1<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.k1<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.k1<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.k1<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.k1<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.k1<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.k1<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.k1<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.k1<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.k1<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.k1<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.k1<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.k1<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.k1<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.k1<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.k1<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.k1<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.k1<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.k1<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.k1<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.k1<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.k1<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.k1<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.k1<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.k1<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.k1<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.k1<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.k1<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.k1<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.k1<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.k1<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.k1<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.k1<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.k1<T>)
      (r0v1 com.google.android.gms.internal.mlkit_vision_barcode_bundled.k1<T>)
     binds: [B:18:0x004f, B:278:0x0707, B:248:0x0643, B:225:0x05b3, B:218:0x0580, B:138:0x036e, B:135:0x0356, B:132:0x033e, B:129:0x0326, B:126:0x030e, B:123:0x02f6, B:120:0x02de, B:117:0x02c6, B:114:0x02ad, B:111:0x0296, B:108:0x027f, B:105:0x0268, B:102:0x0251, B:97:0x0235, B:83:0x01e1, B:85:0x01ef, B:80:0x01c7, B:77:0x01b9, B:74:0x01a3, B:71:0x018d, B:68:0x0176, B:65:0x0168, B:62:0x015a, B:59:0x014b, B:53:0x0120, B:50:0x010c, B:46:0x00ee, B:43:0x00d9, B:40:0x00c3, B:36:0x00b4, B:32:0x00a5, B:29:0x008b, B:25:0x0070, B:21:0x0058] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1791z1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int d(java.lang.Object r18) {
        /*
            Method dump skipped, instructions count: 2064
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode_bundled.C1732k1.d(java.lang.Object):int");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1791z1
    public final void e(Object obj, Object obj2) {
        i(obj);
        obj2.getClass();
        for (int i10 = 0; i10 < this.f20095a.length; i10 += 3) {
            int iG = G(i10);
            int i11 = 1048575 & iG;
            int[] iArr = this.f20095a;
            int iF = F(iG);
            int i12 = iArr[i10];
            long j10 = i11;
            switch (iF) {
                case 0:
                    if (q(obj2, i10)) {
                        T1.t(obj, j10, T1.f(obj2, j10));
                        l(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (q(obj2, i10)) {
                        T1.u(obj, j10, T1.g(obj2, j10));
                        l(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (q(obj2, i10)) {
                        T1.w(obj, j10, T1.i(obj2, j10));
                        l(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (q(obj2, i10)) {
                        T1.w(obj, j10, T1.i(obj2, j10));
                        l(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (q(obj2, i10)) {
                        T1.v(obj, j10, T1.h(obj2, j10));
                        l(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (q(obj2, i10)) {
                        T1.w(obj, j10, T1.i(obj2, j10));
                        l(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (q(obj2, i10)) {
                        T1.v(obj, j10, T1.h(obj2, j10));
                        l(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (q(obj2, i10)) {
                        T1.r(obj, j10, T1.B(obj2, j10));
                        l(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (q(obj2, i10)) {
                        T1.x(obj, j10, T1.k(obj2, j10));
                        l(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    j(obj, obj2, i10);
                    break;
                case 10:
                    if (q(obj2, i10)) {
                        T1.x(obj, j10, T1.k(obj2, j10));
                        l(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (q(obj2, i10)) {
                        T1.v(obj, j10, T1.h(obj2, j10));
                        l(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (q(obj2, i10)) {
                        T1.v(obj, j10, T1.h(obj2, j10));
                        l(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (q(obj2, i10)) {
                        T1.v(obj, j10, T1.h(obj2, j10));
                        l(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (q(obj2, i10)) {
                        T1.w(obj, j10, T1.i(obj2, j10));
                        l(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (q(obj2, i10)) {
                        T1.v(obj, j10, T1.h(obj2, j10));
                        l(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (q(obj2, i10)) {
                        T1.w(obj, j10, T1.i(obj2, j10));
                        l(obj, i10);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    j(obj, obj2, i10);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    M0 m0G = (M0) T1.k(obj, j10);
                    M0 m02 = (M0) T1.k(obj2, j10);
                    int size = m0G.size();
                    int size2 = m02.size();
                    if (size > 0 && size2 > 0) {
                        if (!m0G.zzc()) {
                            m0G = m0G.g(size2 + size);
                        }
                        m0G.addAll(m02);
                    }
                    if (size > 0) {
                        m02 = m0G;
                    }
                    T1.x(obj, j10, m02);
                    break;
                case 50:
                    M1 m12 = B1.f20009a;
                    T1.x(obj, j10, C1697c1.a(T1.k(obj, j10), T1.k(obj2, j10)));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (u(obj2, i12, i10)) {
                        T1.x(obj, j10, T1.k(obj2, j10));
                        m(obj, i12, i10);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    k(obj, obj2, i10);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (u(obj2, i12, i10)) {
                        T1.x(obj, j10, T1.k(obj2, j10));
                        m(obj, i12, i10);
                        break;
                    } else {
                        break;
                    }
                case 68:
                    k(obj, obj2, i10);
                    break;
            }
        }
        B1.u(this.f20104j, obj, obj2);
        if (this.f20100f) {
            B1.t(this.f20105k, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1791z1
    public final boolean f(Object obj, Object obj2) {
        boolean zE;
        for (int i10 = 0; i10 < this.f20095a.length; i10 += 3) {
            int iG = G(i10);
            long j10 = iG & 1048575;
            switch (F(iG)) {
                case 0:
                    if (!p(obj, obj2, i10) || Double.doubleToLongBits(T1.f(obj, j10)) != Double.doubleToLongBits(T1.f(obj2, j10))) {
                        return false;
                    }
                    continue;
                    break;
                case 1:
                    if (!p(obj, obj2, i10) || Float.floatToIntBits(T1.g(obj, j10)) != Float.floatToIntBits(T1.g(obj2, j10))) {
                        return false;
                    }
                    continue;
                    break;
                case 2:
                    if (!p(obj, obj2, i10) || T1.i(obj, j10) != T1.i(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                case 3:
                    if (!p(obj, obj2, i10) || T1.i(obj, j10) != T1.i(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                case 4:
                    if (!p(obj, obj2, i10) || T1.h(obj, j10) != T1.h(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                case 5:
                    if (!p(obj, obj2, i10) || T1.i(obj, j10) != T1.i(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                case 6:
                    if (!p(obj, obj2, i10) || T1.h(obj, j10) != T1.h(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                case 7:
                    if (!p(obj, obj2, i10) || T1.B(obj, j10) != T1.B(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                case 8:
                    if (!p(obj, obj2, i10) || !B1.e(T1.k(obj, j10), T1.k(obj2, j10))) {
                        return false;
                    }
                    continue;
                    break;
                case 9:
                    if (!p(obj, obj2, i10) || !B1.e(T1.k(obj, j10), T1.k(obj2, j10))) {
                        return false;
                    }
                    continue;
                    break;
                case 10:
                    if (!p(obj, obj2, i10) || !B1.e(T1.k(obj, j10), T1.k(obj2, j10))) {
                        return false;
                    }
                    continue;
                    break;
                case 11:
                    if (!p(obj, obj2, i10) || T1.h(obj, j10) != T1.h(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                case 12:
                    if (!p(obj, obj2, i10) || T1.h(obj, j10) != T1.h(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                case 13:
                    if (!p(obj, obj2, i10) || T1.h(obj, j10) != T1.h(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                case 14:
                    if (!p(obj, obj2, i10) || T1.i(obj, j10) != T1.i(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                case 15:
                    if (!p(obj, obj2, i10) || T1.h(obj, j10) != T1.h(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                case 16:
                    if (!p(obj, obj2, i10) || T1.i(obj, j10) != T1.i(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                case 17:
                    if (!p(obj, obj2, i10) || !B1.e(T1.k(obj, j10), T1.k(obj2, j10))) {
                        return false;
                    }
                    continue;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    zE = B1.e(T1.k(obj, j10), T1.k(obj2, j10));
                    break;
                case 50:
                    zE = B1.e(T1.k(obj, j10), T1.k(obj2, j10));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long jD = D(i10) & 1048575;
                    if (T1.h(obj, jD) != T1.h(obj2, jD) || !B1.e(T1.k(obj, j10), T1.k(obj2, j10))) {
                        return false;
                    }
                    continue;
                    break;
                default:
            }
            if (!zE) {
                return false;
            }
        }
        if (!((F0) obj).zzc.equals(((F0) obj2).zzc)) {
            return false;
        }
        if (this.f20100f) {
            return ((C0) obj).zzb.equals(((C0) obj2).zzb);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1791z1
    public final void g(Object obj, byte[] bArr, int i10, int i11, X x10) throws IOException {
        x(obj, bArr, i10, i11, 0, x10);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x008d  */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1791z1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean h(java.lang.Object r15) {
        /*
            Method dump skipped, instructions count: 225
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode_bundled.C1732k1.h(java.lang.Object):boolean");
    }

    public final void j(Object obj, Object obj2, int i10) {
        if (q(obj2, i10)) {
            int iG = G(i10) & 1048575;
            Unsafe unsafe = f20094m;
            long j10 = iG;
            Object object = unsafe.getObject(obj2, j10);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.f20095a[i10] + " is present but null: " + obj2.toString());
            }
            InterfaceC1791z1 interfaceC1791z1J = J(i10);
            if (!q(obj, i10)) {
                if (t(object)) {
                    Object objZze = interfaceC1791z1J.zze();
                    interfaceC1791z1J.e(objZze, object);
                    unsafe.putObject(obj, j10, objZze);
                } else {
                    unsafe.putObject(obj, j10, object);
                }
                l(obj, i10);
                return;
            }
            Object object2 = unsafe.getObject(obj, j10);
            if (!t(object2)) {
                Object objZze2 = interfaceC1791z1J.zze();
                interfaceC1791z1J.e(objZze2, object2);
                unsafe.putObject(obj, j10, objZze2);
                object2 = objZze2;
            }
            interfaceC1791z1J.e(object2, object);
        }
    }

    public final void k(Object obj, Object obj2, int i10) {
        int i11 = this.f20095a[i10];
        if (u(obj2, i11, i10)) {
            int iG = G(i10) & 1048575;
            Unsafe unsafe = f20094m;
            long j10 = iG;
            Object object = unsafe.getObject(obj2, j10);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.f20095a[i10] + " is present but null: " + obj2.toString());
            }
            InterfaceC1791z1 interfaceC1791z1J = J(i10);
            if (!u(obj, i11, i10)) {
                if (t(object)) {
                    Object objZze = interfaceC1791z1J.zze();
                    interfaceC1791z1J.e(objZze, object);
                    unsafe.putObject(obj, j10, objZze);
                } else {
                    unsafe.putObject(obj, j10, object);
                }
                m(obj, i11, i10);
                return;
            }
            Object object2 = unsafe.getObject(obj, j10);
            if (!t(object2)) {
                Object objZze2 = interfaceC1791z1J.zze();
                interfaceC1791z1J.e(objZze2, object2);
                unsafe.putObject(obj, j10, objZze2);
                object2 = objZze2;
            }
            interfaceC1791z1J.e(object2, object);
        }
    }

    public final void l(Object obj, int i10) {
        int iD = D(i10);
        long j10 = 1048575 & iD;
        if (j10 == 1048575) {
            return;
        }
        T1.v(obj, j10, (1 << (iD >>> 20)) | T1.h(obj, j10));
    }

    public final void m(Object obj, int i10, int i11) {
        T1.v(obj, D(i11) & 1048575, i10);
    }

    public final void n(Object obj, int i10, Object obj2) {
        f20094m.putObject(obj, G(i10) & 1048575, obj2);
        l(obj, i10);
    }

    public final void o(Object obj, int i10, int i11, Object obj2) {
        f20094m.putObject(obj, G(i11) & 1048575, obj2);
        m(obj, i10, i11);
    }

    public final boolean p(Object obj, Object obj2, int i10) {
        return q(obj, i10) == q(obj2, i10);
    }

    public final boolean q(Object obj, int i10) {
        int iD = D(i10);
        long j10 = iD & 1048575;
        if (j10 != 1048575) {
            return ((1 << (iD >>> 20)) & T1.h(obj, j10)) != 0;
        }
        int iG = G(i10);
        long j11 = iG & 1048575;
        switch (F(iG)) {
            case 0:
                return Double.doubleToRawLongBits(T1.f(obj, j11)) != 0;
            case 1:
                return Float.floatToRawIntBits(T1.g(obj, j11)) != 0;
            case 2:
                return T1.i(obj, j11) != 0;
            case 3:
                return T1.i(obj, j11) != 0;
            case 4:
                return T1.h(obj, j11) != 0;
            case 5:
                return T1.i(obj, j11) != 0;
            case 6:
                return T1.h(obj, j11) != 0;
            case 7:
                return T1.B(obj, j11);
            case 8:
                Object objK = T1.k(obj, j11);
                if (objK instanceof String) {
                    return !((String) objK).isEmpty();
                }
                if (objK instanceof zzdf) {
                    return !zzdf.f20159b.equals(objK);
                }
                throw new IllegalArgumentException();
            case 9:
                return T1.k(obj, j11) != null;
            case 10:
                return !zzdf.f20159b.equals(T1.k(obj, j11));
            case 11:
                return T1.h(obj, j11) != 0;
            case 12:
                return T1.h(obj, j11) != 0;
            case 13:
                return T1.h(obj, j11) != 0;
            case 14:
                return T1.i(obj, j11) != 0;
            case 15:
                return T1.h(obj, j11) != 0;
            case 16:
                return T1.i(obj, j11) != 0;
            case 17:
                return T1.k(obj, j11) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    public final boolean r(Object obj, int i10, int i11, int i12, int i13) {
        return i11 == 1048575 ? q(obj, i10) : (i12 & i13) != 0;
    }

    public final boolean u(Object obj, int i10, int i11) {
        return T1.h(obj, (long) (D(i11) & 1048575)) == i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:561:0x0e26  */
    /* JADX WARN: Removed duplicated region for block: B:568:0x0e5d  */
    /* JADX WARN: Removed duplicated region for block: B:632:0x0b6e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:635:0x0df6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:638:0x0052 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:665:0x0b82 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:676:0x0e0b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0272  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int x(java.lang.Object r34, byte[] r35, int r36, int r37, int r38, com.google.android.gms.internal.mlkit_vision_barcode_bundled.X r39) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 3948
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode_bundled.C1732k1.x(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.mlkit_vision_barcode_bundled.X):int");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.InterfaceC1791z1
    public final Object zze() {
        return ((F0) this.f20099e).o();
    }
}
