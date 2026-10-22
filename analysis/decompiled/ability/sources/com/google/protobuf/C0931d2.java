package com.google.protobuf;

import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.protobuf.ByteString;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* renamed from: com.google.protobuf.d2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0931d2 implements InterfaceC0979p2 {

    /* renamed from: q, reason: collision with root package name */
    public static final int[] f2912q = new int[0];

    /* renamed from: r, reason: collision with root package name */
    public static final Unsafe f2913r = W2.j();

    /* renamed from: a, reason: collision with root package name */
    public final int[] f2914a;
    public final Object[] b;
    public final int c;
    public final int d;
    public final X1 e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final int[] i;

    /* renamed from: j, reason: collision with root package name */
    public final int f2915j;
    public final int k;
    public final InterfaceC0939f2 l;
    public final A1 m;
    public final H2 n;
    public final S0 o;
    public final Q1 p;

    public C0931d2(int[] iArr, Object[] objArr, int i, int i6, X1 x12, boolean z10, int[] iArr2, int i10, int i11, InterfaceC0939f2 interfaceC0939f2, A1 a12, H2 h22, S0 s0, Q1 q1) {
        this.f2914a = iArr;
        this.b = objArr;
        this.c = i;
        this.d = i6;
        this.g = x12 instanceof GeneratedMessageLite;
        this.f = s0 != null && s0.e(x12);
        this.h = z10;
        this.i = iArr2;
        this.f2915j = i10;
        this.k = i11;
        this.l = interfaceC0939f2;
        this.m = a12;
        this.n = h22;
        this.o = s0;
        this.e = x12;
        this.p = q1;
    }

    public static long A(Object obj, long j5) {
        return ((Long) W2.c.k(obj, j5)).longValue();
    }

    public static Field G(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            StringBuilder sbV = B7.a.v("Field ", str, " for ");
            androidx.constraintlayout.core.dsl.a.z(sbV, cls, " not found. Known fields are ");
            sbV.append(Arrays.toString(declaredFields));
            throw new RuntimeException(sbV.toString());
        }
    }

    public static int M(int i) {
        return (i & 267386880) >>> 20;
    }

    public static void h(Object obj) {
        if (!q(obj)) {
            throw new IllegalArgumentException(androidx.appfunctions.metadata.a.j(obj, "Mutating immutable message: "));
        }
    }

    public static int i(byte[] bArr, int i, int i6, WireFormat$FieldType wireFormat$FieldType, Class cls, C0948i c0948i) throws InvalidProtocolBufferException {
        switch (wireFormat$FieldType.ordinal()) {
            case 0:
                c0948i.c = Double.valueOf(Double.longBitsToDouble(AbstractC1002v2.j(bArr, i)));
                return i + 8;
            case 1:
                c0948i.c = Float.valueOf(Float.intBitsToFloat(AbstractC1002v2.i(bArr, i)));
                return i + 4;
            case 2:
            case 3:
                int iS = AbstractC1002v2.s(bArr, i, c0948i);
                c0948i.c = Long.valueOf(c0948i.b);
                return iS;
            case 4:
            case 12:
            case 13:
                int iQ = AbstractC1002v2.q(bArr, i, c0948i);
                c0948i.c = Integer.valueOf(c0948i.f2923a);
                return iQ;
            case 5:
            case 15:
                c0948i.c = Long.valueOf(AbstractC1002v2.j(bArr, i));
                return i + 8;
            case 6:
            case 14:
                c0948i.c = Integer.valueOf(AbstractC1002v2.i(bArr, i));
                return i + 4;
            case 7:
                int iS2 = AbstractC1002v2.s(bArr, i, c0948i);
                c0948i.c = Boolean.valueOf(c0948i.b != 0);
                return iS2;
            case 8:
                int iQ2 = AbstractC1002v2.q(bArr, i, c0948i);
                int i10 = c0948i.f2923a;
                if (i10 < 0) {
                    throw InvalidProtocolBufferException.e();
                }
                if (i10 == 0) {
                    c0948i.c = "";
                    return iQ2;
                }
                c0948i.c = Y2.f2904a.m(bArr, iQ2, i10);
                return iQ2 + i10;
            case 9:
            default:
                throw new RuntimeException("unsupported field type.");
            case 10:
                InterfaceC0979p2 interfaceC0979p2A = C0963l2.c.a(cls);
                Object objNewInstance = interfaceC0979p2A.newInstance();
                int iE = AbstractC1002v2.E(objNewInstance, interfaceC0979p2A, bArr, i, i6, c0948i);
                interfaceC0979p2A.makeImmutable(objNewInstance);
                c0948i.c = objNewInstance;
                return iE;
            case 11:
                return AbstractC1002v2.g(bArr, i, c0948i);
            case 16:
                int iQ3 = AbstractC1002v2.q(bArr, i, c0948i);
                c0948i.c = Integer.valueOf(AbstractC0972o.c(c0948i.f2923a));
                return iQ3;
            case 17:
                int iS3 = AbstractC1002v2.s(bArr, i, c0948i);
                c0948i.c = Long.valueOf(AbstractC0972o.d(c0948i.b));
                return iS3;
        }
    }

    public static N2 n(Object obj) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        N2 n22 = generatedMessageLite.unknownFields;
        if (n22 != N2.f) {
            return n22;
        }
        N2 n2C = N2.c();
        generatedMessageLite.unknownFields = n2C;
        return n2C;
    }

    public static boolean q(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof GeneratedMessageLite) {
            return ((GeneratedMessageLite) obj).v();
        }
        return true;
    }

    public static C0931d2 x(U1 u12, InterfaceC0939f2 interfaceC0939f2, A1 a12, H2 h22, S0 s0, Q1 q1) {
        if (u12 instanceof C0971n2) {
            return y((C0971n2) u12, interfaceC0939f2, a12, h22, s0, q1);
        }
        ((B2) u12).getClass();
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0370  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.protobuf.C0931d2 y(com.google.protobuf.C0971n2 r33, com.google.protobuf.InterfaceC0939f2 r34, com.google.protobuf.A1 r35, com.google.protobuf.H2 r36, com.google.protobuf.S0 r37, com.google.protobuf.Q1 r38) {
        /*
            Method dump skipped, instructions count: 992
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C0931d2.y(com.google.protobuf.n2, com.google.protobuf.f2, com.google.protobuf.A1, com.google.protobuf.H2, com.google.protobuf.S0, com.google.protobuf.Q1):com.google.protobuf.d2");
    }

    public static int z(Object obj, long j5) {
        return ((Integer) W2.c.k(obj, j5)).intValue();
    }

    public final int B(Object obj, byte[] bArr, int i, int i6, int i10, long j5, C0948i c0948i) throws InvalidProtocolBufferException {
        byte[] bArr2;
        C0948i c0948i2;
        int i11;
        Unsafe unsafe = f2913r;
        Object objL = l(i10);
        Object object = unsafe.getObject(obj, j5);
        Q1 q1 = this.p;
        if (q1.isImmutable(object)) {
            Object objNewMapField = q1.newMapField(objL);
            q1.mergeFrom(objNewMapField, object);
            unsafe.putObject(obj, j5, objNewMapField);
            object = objNewMapField;
        }
        u1.d dVarForMapMetadata = q1.forMapMetadata(objL);
        Map mapForMutableMapData = q1.forMutableMapData(object);
        int iQ = AbstractC1002v2.q(bArr, i, c0948i);
        int i12 = c0948i.f2923a;
        if (i12 < 0 || i12 > i6 - iQ) {
            throw InvalidProtocolBufferException.g();
        }
        int i13 = i12 + iQ;
        Object obj2 = dVarForMapMetadata.c;
        Object obj3 = dVarForMapMetadata.e;
        Object obj4 = obj3;
        while (iQ < i13) {
            int iP = iQ + 1;
            int i14 = bArr[iQ];
            if (i14 < 0) {
                iP = AbstractC1002v2.p(i14, bArr, iP, c0948i);
                i14 = c0948i.f2923a;
            }
            int i15 = iP;
            int i16 = i14 >>> 3;
            int i17 = i14 & 7;
            if (i16 != 1) {
                if (i16 == 2) {
                    WireFormat$FieldType wireFormat$FieldType = (WireFormat$FieldType) dVarForMapMetadata.d;
                    if (i17 == wireFormat$FieldType.b) {
                        byte[] bArr3 = bArr;
                        int i18 = i6;
                        C0948i c0948i3 = c0948i;
                        iQ = i(bArr3, i15, i18, wireFormat$FieldType, obj3.getClass(), c0948i3);
                        obj4 = c0948i3.c;
                        i6 = i18;
                        bArr = bArr3;
                    }
                }
                bArr2 = bArr;
                i11 = i6;
                c0948i2 = c0948i;
            } else {
                bArr2 = bArr;
                int i19 = i6;
                c0948i2 = c0948i;
                WireFormat$FieldType wireFormat$FieldType2 = (WireFormat$FieldType) dVarForMapMetadata.b;
                if (i17 == wireFormat$FieldType2.b) {
                    i11 = i19;
                    iQ = i(bArr2, i15, i11, wireFormat$FieldType2, null, c0948i2);
                    obj2 = c0948i2.c;
                    bArr = bArr2;
                    i6 = i11;
                    c0948i = c0948i2;
                } else {
                    i11 = i19;
                }
            }
            iQ = AbstractC1002v2.H(i14, bArr2, i15, i11, c0948i2);
            bArr = bArr2;
            i6 = i11;
            c0948i = c0948i2;
        }
        if (iQ != i13) {
            throw InvalidProtocolBufferException.f();
        }
        mapForMutableMapData.put(obj2, obj4);
        return i13;
    }

    /* JADX WARN: Code restructure failed: missing block: B:169:0x0558, code lost:
    
        r0 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x05c5, code lost:
    
        if (r0 == 1048575) goto L187;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x05c7, code lost:
    
        r26.putInt(r9, r0, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x05cd, code lost:
    
        r3 = null;
        r10 = r8.f2915j;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x05d4, code lost:
    
        if (r10 >= r8.k) goto L270;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x05d6, code lost:
    
        r3 = (com.google.protobuf.N2) r8.j(r9, r8.i[r10], r3, r8.n, r30);
        r10 = r10 + 1;
        r9 = r30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x05ec, code lost:
    
        r0 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x05ed, code lost:
    
        if (r3 == null) goto L194;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x05ef, code lost:
    
        ((com.google.protobuf.O2) r0.n).getClass();
        ((com.google.protobuf.GeneratedMessageLite) r30).unknownFields = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x05fc, code lost:
    
        if (r34 != 0) goto L199;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x05fe, code lost:
    
        if (r6 != r11) goto L197;
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x0605, code lost:
    
        throw com.google.protobuf.InvalidProtocolBufferException.f();
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x0606, code lost:
    
        if (r6 > r11) goto L202;
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x0608, code lost:
    
        if (r7 != r34) goto L202;
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x060a, code lost:
    
        return r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x060f, code lost:
    
        throw com.google.protobuf.InvalidProtocolBufferException.f();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int C(java.lang.Object r30, byte[] r31, int r32, int r33, int r34, com.google.protobuf.C0948i r35) throws com.google.protobuf.InvalidProtocolBufferException {
        /*
            Method dump skipped, instructions count: 1592
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C0931d2.C(java.lang.Object, byte[], int, int, int, com.google.protobuf.i):int");
    }

    public final int D(Object obj, byte[] bArr, int i, int i6, int i10, int i11, int i12, int i13, int i14, long j5, int i15, C0948i c0948i) throws InvalidProtocolBufferException {
        int i16;
        Unsafe unsafe = f2913r;
        long j6 = this.f2914a[i15 + 2] & 1048575;
        switch (i14) {
            case 51:
                if (i12 != 1) {
                    return i;
                }
                unsafe.putObject(obj, j5, Double.valueOf(Double.longBitsToDouble(AbstractC1002v2.j(bArr, i))));
                int i17 = i + 8;
                unsafe.putInt(obj, j6, i11);
                return i17;
            case 52:
                if (i12 != 5) {
                    return i;
                }
                unsafe.putObject(obj, j5, Float.valueOf(Float.intBitsToFloat(AbstractC1002v2.i(bArr, i))));
                int i18 = i + 4;
                unsafe.putInt(obj, j6, i11);
                return i18;
            case 53:
            case 54:
                if (i12 != 0) {
                    return i;
                }
                int iS = AbstractC1002v2.s(bArr, i, c0948i);
                unsafe.putObject(obj, j5, Long.valueOf(c0948i.b));
                unsafe.putInt(obj, j6, i11);
                return iS;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
            case 62:
                if (i12 != 0) {
                    return i;
                }
                int iQ = AbstractC1002v2.q(bArr, i, c0948i);
                unsafe.putObject(obj, j5, Integer.valueOf(c0948i.f2923a));
                unsafe.putInt(obj, j6, i11);
                return iQ;
            case 56:
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                if (i12 != 1) {
                    return i;
                }
                unsafe.putObject(obj, j5, Long.valueOf(AbstractC1002v2.j(bArr, i)));
                int i19 = i + 8;
                unsafe.putInt(obj, j6, i11);
                return i19;
            case 57:
            case 64:
                if (i12 != 5) {
                    return i;
                }
                unsafe.putObject(obj, j5, Integer.valueOf(AbstractC1002v2.i(bArr, i)));
                int i20 = i + 4;
                unsafe.putInt(obj, j6, i11);
                return i20;
            case 58:
                if (i12 != 0) {
                    return i;
                }
                int iS2 = AbstractC1002v2.s(bArr, i, c0948i);
                unsafe.putObject(obj, j5, Boolean.valueOf(c0948i.b != 0));
                unsafe.putInt(obj, j6, i11);
                return iS2;
            case 59:
                if (i12 != 2) {
                    return i;
                }
                int iQ2 = AbstractC1002v2.q(bArr, i, c0948i);
                int i21 = c0948i.f2923a;
                if (i21 == 0) {
                    unsafe.putObject(obj, j5, "");
                } else {
                    if ((i13 & 536870912) != 0) {
                        if (!Y2.f2904a.C(bArr, iQ2, iQ2 + i21)) {
                            throw InvalidProtocolBufferException.b();
                        }
                    }
                    unsafe.putObject(obj, j5, new String(bArr, iQ2, i21, AbstractC0989s1.f2940a));
                    iQ2 += i21;
                }
                unsafe.putInt(obj, j6, i11);
                return iQ2;
            case 60:
                i16 = i;
                if (i12 == 2) {
                    Object objW = w(i11, i15, obj);
                    int iE = AbstractC1002v2.E(objW, m(i15), bArr, i16, i6, c0948i);
                    L(i11, i15, obj, objW);
                    return iE;
                }
                return i16;
            case o7.s.MESSAGE_POST_FIELD_NUMBER /* 61 */:
                i16 = i;
                if (i12 == 2) {
                    int iG = AbstractC1002v2.g(bArr, i16, c0948i);
                    unsafe.putObject(obj, j5, c0948i.c);
                    unsafe.putInt(obj, j6, i11);
                    return iG;
                }
                return i16;
            case 63:
                i16 = i;
                if (i12 == 0) {
                    int iQ3 = AbstractC1002v2.q(bArr, i16, c0948i);
                    int i22 = c0948i.f2923a;
                    InterfaceC0978p1 interfaceC0978p1K = k(i15);
                    if (interfaceC0978p1K != null && !interfaceC0978p1K.isInRange(i22)) {
                        n(obj).d(i10, Long.valueOf(i22));
                        return iQ3;
                    }
                    unsafe.putObject(obj, j5, Integer.valueOf(i22));
                    unsafe.putInt(obj, j6, i11);
                    return iQ3;
                }
                return i16;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                i16 = i;
                if (i12 == 0) {
                    int iQ4 = AbstractC1002v2.q(bArr, i16, c0948i);
                    unsafe.putObject(obj, j5, Integer.valueOf(AbstractC0972o.c(c0948i.f2923a)));
                    unsafe.putInt(obj, j6, i11);
                    return iQ4;
                }
                return i16;
            case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                i16 = i;
                if (i12 == 0) {
                    int iS3 = AbstractC1002v2.s(bArr, i16, c0948i);
                    unsafe.putObject(obj, j5, Long.valueOf(AbstractC0972o.d(c0948i.b)));
                    unsafe.putInt(obj, j6, i11);
                    return iS3;
                }
                return i16;
            case 68:
                if (i12 == 3) {
                    Object objW2 = w(i11, i15, obj);
                    int iC = ((C0931d2) m(i15)).C(objW2, bArr, i, i6, (i10 & (-8)) | 4, c0948i);
                    c0948i.c = objW2;
                    L(i11, i15, obj, objW2);
                    return iC;
                }
            default:
                return i;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final int E(Object obj, byte[] bArr, int i, int i6, int i10, int i11, int i12, int i13, long j5, int i14, long j6, C0948i c0948i) throws InvalidProtocolBufferException {
        int iR;
        Unsafe unsafe = f2913r;
        InterfaceC0985r1 interfaceC0985r1MutableCopyWithCapacity = (InterfaceC0985r1) unsafe.getObject(obj, j6);
        if (!((AbstractC0940g) interfaceC0985r1MutableCopyWithCapacity).f2920a) {
            int size = interfaceC0985r1MutableCopyWithCapacity.size();
            interfaceC0985r1MutableCopyWithCapacity = interfaceC0985r1MutableCopyWithCapacity.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
            unsafe.putObject(obj, j6, interfaceC0985r1MutableCopyWithCapacity);
        }
        InterfaceC0985r1 interfaceC0985r1 = interfaceC0985r1MutableCopyWithCapacity;
        switch (i14) {
            case 18:
            case 35:
                if (i12 == 2) {
                    K0 k02 = (K0) interfaceC0985r1;
                    int iQ = AbstractC1002v2.q(bArr, i, c0948i);
                    int i15 = c0948i.f2923a + iQ;
                    while (iQ < i15) {
                        k02.addDouble(Double.longBitsToDouble(AbstractC1002v2.j(bArr, iQ)));
                        iQ += 8;
                    }
                    if (iQ == i15) {
                        return iQ;
                    }
                    throw InvalidProtocolBufferException.g();
                }
                if (i12 == 1) {
                    K0 k03 = (K0) interfaceC0985r1;
                    k03.addDouble(Double.longBitsToDouble(AbstractC1002v2.j(bArr, i)));
                    int i16 = i + 8;
                    while (i16 < i6) {
                        int iQ2 = AbstractC1002v2.q(bArr, i16, c0948i);
                        if (i10 != c0948i.f2923a) {
                            return i16;
                        }
                        k03.addDouble(Double.longBitsToDouble(AbstractC1002v2.j(bArr, iQ2)));
                        i16 = iQ2 + 8;
                    }
                    return i16;
                }
                return i;
            case 19:
            case 36:
                if (i12 == 2) {
                    Z0 z02 = (Z0) interfaceC0985r1;
                    int iQ3 = AbstractC1002v2.q(bArr, i, c0948i);
                    int i17 = c0948i.f2923a + iQ3;
                    while (iQ3 < i17) {
                        z02.addFloat(Float.intBitsToFloat(AbstractC1002v2.i(bArr, iQ3)));
                        iQ3 += 4;
                    }
                    if (iQ3 == i17) {
                        return iQ3;
                    }
                    throw InvalidProtocolBufferException.g();
                }
                if (i12 == 5) {
                    Z0 z03 = (Z0) interfaceC0985r1;
                    z03.addFloat(Float.intBitsToFloat(AbstractC1002v2.i(bArr, i)));
                    int i18 = i + 4;
                    while (i18 < i6) {
                        int iQ4 = AbstractC1002v2.q(bArr, i18, c0948i);
                        if (i10 != c0948i.f2923a) {
                            return i18;
                        }
                        z03.addFloat(Float.intBitsToFloat(AbstractC1002v2.i(bArr, iQ4)));
                        i18 = iQ4 + 4;
                    }
                    return i18;
                }
                return i;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i12 == 2) {
                    D1 d12 = (D1) interfaceC0985r1;
                    int iQ5 = AbstractC1002v2.q(bArr, i, c0948i);
                    int i19 = c0948i.f2923a + iQ5;
                    while (iQ5 < i19) {
                        iQ5 = AbstractC1002v2.s(bArr, iQ5, c0948i);
                        d12.addLong(c0948i.b);
                    }
                    if (iQ5 == i19) {
                        return iQ5;
                    }
                    throw InvalidProtocolBufferException.g();
                }
                if (i12 == 0) {
                    D1 d13 = (D1) interfaceC0985r1;
                    int iS = AbstractC1002v2.s(bArr, i, c0948i);
                    d13.addLong(c0948i.b);
                    while (iS < i6) {
                        int iQ6 = AbstractC1002v2.q(bArr, iS, c0948i);
                        if (i10 != c0948i.f2923a) {
                            return iS;
                        }
                        iS = AbstractC1002v2.s(bArr, iQ6, c0948i);
                        d13.addLong(c0948i.b);
                    }
                    return iS;
                }
                return i;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i12 != 2) {
                    if (i12 == 0) {
                        return AbstractC1002v2.r(i10, bArr, i, i6, interfaceC0985r1, c0948i);
                    }
                    return i;
                }
                C0970n1 c0970n1 = (C0970n1) interfaceC0985r1;
                int iQ7 = AbstractC1002v2.q(bArr, i, c0948i);
                int i20 = c0948i.f2923a + iQ7;
                while (iQ7 < i20) {
                    iQ7 = AbstractC1002v2.q(bArr, iQ7, c0948i);
                    c0970n1.addInt(c0948i.f2923a);
                }
                if (iQ7 == i20) {
                    return iQ7;
                }
                throw InvalidProtocolBufferException.g();
            case 23:
            case 32:
            case 40:
            case 46:
                if (i12 == 2) {
                    D1 d14 = (D1) interfaceC0985r1;
                    int iQ8 = AbstractC1002v2.q(bArr, i, c0948i);
                    int i21 = c0948i.f2923a + iQ8;
                    while (iQ8 < i21) {
                        d14.addLong(AbstractC1002v2.j(bArr, iQ8));
                        iQ8 += 8;
                    }
                    if (iQ8 == i21) {
                        return iQ8;
                    }
                    throw InvalidProtocolBufferException.g();
                }
                if (i12 == 1) {
                    D1 d15 = (D1) interfaceC0985r1;
                    d15.addLong(AbstractC1002v2.j(bArr, i));
                    int i22 = i + 8;
                    while (i22 < i6) {
                        int iQ9 = AbstractC1002v2.q(bArr, i22, c0948i);
                        if (i10 != c0948i.f2923a) {
                            return i22;
                        }
                        d15.addLong(AbstractC1002v2.j(bArr, iQ9));
                        i22 = iQ9 + 8;
                    }
                    return i22;
                }
                return i;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i12 == 2) {
                    C0970n1 c0970n12 = (C0970n1) interfaceC0985r1;
                    int iQ10 = AbstractC1002v2.q(bArr, i, c0948i);
                    int i23 = c0948i.f2923a + iQ10;
                    while (iQ10 < i23) {
                        c0970n12.addInt(AbstractC1002v2.i(bArr, iQ10));
                        iQ10 += 4;
                    }
                    if (iQ10 == i23) {
                        return iQ10;
                    }
                    throw InvalidProtocolBufferException.g();
                }
                if (i12 == 5) {
                    C0970n1 c0970n13 = (C0970n1) interfaceC0985r1;
                    c0970n13.addInt(AbstractC1002v2.i(bArr, i));
                    int i24 = i + 4;
                    while (i24 < i6) {
                        int iQ11 = AbstractC1002v2.q(bArr, i24, c0948i);
                        if (i10 != c0948i.f2923a) {
                            return i24;
                        }
                        c0970n13.addInt(AbstractC1002v2.i(bArr, iQ11));
                        i24 = iQ11 + 4;
                    }
                    return i24;
                }
                return i;
            case 25:
            case 42:
                if (i12 == 2) {
                    AbstractC0952j abstractC0952j = (AbstractC0952j) interfaceC0985r1;
                    int iQ12 = AbstractC1002v2.q(bArr, i, c0948i);
                    int i25 = c0948i.f2923a + iQ12;
                    while (iQ12 < i25) {
                        iQ12 = AbstractC1002v2.s(bArr, iQ12, c0948i);
                        abstractC0952j.addBoolean(c0948i.b != 0);
                    }
                    if (iQ12 == i25) {
                        return iQ12;
                    }
                    throw InvalidProtocolBufferException.g();
                }
                if (i12 == 0) {
                    AbstractC0952j abstractC0952j2 = (AbstractC0952j) interfaceC0985r1;
                    int iS2 = AbstractC1002v2.s(bArr, i, c0948i);
                    abstractC0952j2.addBoolean(c0948i.b != 0);
                    while (iS2 < i6) {
                        int iQ13 = AbstractC1002v2.q(bArr, iS2, c0948i);
                        if (i10 != c0948i.f2923a) {
                            return iS2;
                        }
                        iS2 = AbstractC1002v2.s(bArr, iQ13, c0948i);
                        abstractC0952j2.addBoolean(c0948i.b != 0);
                    }
                    return iS2;
                }
                return i;
            case 26:
                if (i12 == 2) {
                    if ((j5 & 536870912) == 0) {
                        int iQ14 = AbstractC1002v2.q(bArr, i, c0948i);
                        int i26 = c0948i.f2923a;
                        if (i26 < 0) {
                            throw InvalidProtocolBufferException.e();
                        }
                        if (i26 == 0) {
                            interfaceC0985r1.add("");
                        } else {
                            interfaceC0985r1.add(new String(bArr, iQ14, i26, AbstractC0989s1.f2940a));
                            iQ14 += i26;
                        }
                        while (iQ14 < i6) {
                            int iQ15 = AbstractC1002v2.q(bArr, iQ14, c0948i);
                            if (i10 != c0948i.f2923a) {
                                return iQ14;
                            }
                            iQ14 = AbstractC1002v2.q(bArr, iQ15, c0948i);
                            int i27 = c0948i.f2923a;
                            if (i27 < 0) {
                                throw InvalidProtocolBufferException.e();
                            }
                            if (i27 == 0) {
                                interfaceC0985r1.add("");
                            } else {
                                interfaceC0985r1.add(new String(bArr, iQ14, i27, AbstractC0989s1.f2940a));
                                iQ14 += i27;
                            }
                        }
                        return iQ14;
                    }
                    int iQ16 = AbstractC1002v2.q(bArr, i, c0948i);
                    int i28 = c0948i.f2923a;
                    if (i28 < 0) {
                        throw InvalidProtocolBufferException.e();
                    }
                    if (i28 == 0) {
                        interfaceC0985r1.add("");
                    } else {
                        int i29 = iQ16 + i28;
                        if (!Y2.f2904a.C(bArr, iQ16, i29)) {
                            throw InvalidProtocolBufferException.b();
                        }
                        interfaceC0985r1.add(new String(bArr, iQ16, i28, AbstractC0989s1.f2940a));
                        iQ16 = i29;
                    }
                    while (iQ16 < i6) {
                        int iQ17 = AbstractC1002v2.q(bArr, iQ16, c0948i);
                        if (i10 != c0948i.f2923a) {
                            return iQ16;
                        }
                        iQ16 = AbstractC1002v2.q(bArr, iQ17, c0948i);
                        int i30 = c0948i.f2923a;
                        if (i30 < 0) {
                            throw InvalidProtocolBufferException.e();
                        }
                        if (i30 == 0) {
                            interfaceC0985r1.add("");
                        } else {
                            int i31 = iQ16 + i30;
                            if (!Y2.f2904a.C(bArr, iQ16, i31)) {
                                throw InvalidProtocolBufferException.b();
                            }
                            interfaceC0985r1.add(new String(bArr, iQ16, i30, AbstractC0989s1.f2940a));
                            iQ16 = i31;
                        }
                    }
                    return iQ16;
                }
                return i;
            case 27:
                if (i12 == 2) {
                    return AbstractC1002v2.k(m(i13), i10, bArr, i, i6, interfaceC0985r1, c0948i);
                }
                return i;
            case 28:
                if (i12 == 2) {
                    int iQ18 = AbstractC1002v2.q(bArr, i, c0948i);
                    int i32 = c0948i.f2923a;
                    if (i32 < 0) {
                        throw InvalidProtocolBufferException.e();
                    }
                    if (i32 > bArr.length - iQ18) {
                        throw InvalidProtocolBufferException.g();
                    }
                    if (i32 == 0) {
                        interfaceC0985r1.add(ByteString.b);
                    } else {
                        interfaceC0985r1.add(ByteString.e(bArr, iQ18, i32));
                        iQ18 += i32;
                    }
                    while (iQ18 < i6) {
                        int iQ19 = AbstractC1002v2.q(bArr, iQ18, c0948i);
                        if (i10 != c0948i.f2923a) {
                            return iQ18;
                        }
                        iQ18 = AbstractC1002v2.q(bArr, iQ19, c0948i);
                        int i33 = c0948i.f2923a;
                        if (i33 < 0) {
                            throw InvalidProtocolBufferException.e();
                        }
                        if (i33 > bArr.length - iQ18) {
                            throw InvalidProtocolBufferException.g();
                        }
                        if (i33 == 0) {
                            interfaceC0985r1.add(ByteString.b);
                        } else {
                            interfaceC0985r1.add(ByteString.e(bArr, iQ18, i33));
                            iQ18 += i33;
                        }
                    }
                    return iQ18;
                }
                return i;
            case 30:
            case 44:
                if (i12 != 2) {
                    if (i12 == 0) {
                        iR = AbstractC1002v2.r(i10, bArr, i, i6, interfaceC0985r1, c0948i);
                    }
                    return i;
                }
                C0970n1 c0970n14 = (C0970n1) interfaceC0985r1;
                iR = AbstractC1002v2.q(bArr, i, c0948i);
                int i34 = c0948i.f2923a + iR;
                while (iR < i34) {
                    iR = AbstractC1002v2.q(bArr, iR, c0948i);
                    c0970n14.addInt(c0948i.f2923a);
                }
                if (iR != i34) {
                    throw InvalidProtocolBufferException.g();
                }
                AbstractC0983q2.j(obj, i11, interfaceC0985r1, k(i13), null, this.n);
                return iR;
            case 33:
            case 47:
                if (i12 == 2) {
                    C0970n1 c0970n15 = (C0970n1) interfaceC0985r1;
                    int iQ20 = AbstractC1002v2.q(bArr, i, c0948i);
                    int i35 = c0948i.f2923a + iQ20;
                    while (iQ20 < i35) {
                        iQ20 = AbstractC1002v2.q(bArr, iQ20, c0948i);
                        c0970n15.addInt(AbstractC0972o.c(c0948i.f2923a));
                    }
                    if (iQ20 == i35) {
                        return iQ20;
                    }
                    throw InvalidProtocolBufferException.g();
                }
                if (i12 == 0) {
                    C0970n1 c0970n16 = (C0970n1) interfaceC0985r1;
                    int iQ21 = AbstractC1002v2.q(bArr, i, c0948i);
                    c0970n16.addInt(AbstractC0972o.c(c0948i.f2923a));
                    while (iQ21 < i6) {
                        int iQ22 = AbstractC1002v2.q(bArr, iQ21, c0948i);
                        if (i10 != c0948i.f2923a) {
                            return iQ21;
                        }
                        iQ21 = AbstractC1002v2.q(bArr, iQ22, c0948i);
                        c0970n16.addInt(AbstractC0972o.c(c0948i.f2923a));
                    }
                    return iQ21;
                }
                return i;
            case 34:
            case 48:
                if (i12 == 2) {
                    D1 d16 = (D1) interfaceC0985r1;
                    int iQ23 = AbstractC1002v2.q(bArr, i, c0948i);
                    int i36 = c0948i.f2923a + iQ23;
                    while (iQ23 < i36) {
                        iQ23 = AbstractC1002v2.s(bArr, iQ23, c0948i);
                        d16.addLong(AbstractC0972o.d(c0948i.b));
                    }
                    if (iQ23 == i36) {
                        return iQ23;
                    }
                    throw InvalidProtocolBufferException.g();
                }
                if (i12 == 0) {
                    D1 d17 = (D1) interfaceC0985r1;
                    int iS3 = AbstractC1002v2.s(bArr, i, c0948i);
                    d17.addLong(AbstractC0972o.d(c0948i.b));
                    while (iS3 < i6) {
                        int iQ24 = AbstractC1002v2.q(bArr, iS3, c0948i);
                        if (i10 != c0948i.f2923a) {
                            return iS3;
                        }
                        iS3 = AbstractC1002v2.s(bArr, iQ24, c0948i);
                        d17.addLong(AbstractC0972o.d(c0948i.b));
                    }
                    return iS3;
                }
                return i;
            case 49:
                if (i12 == 3) {
                    InterfaceC0979p2 interfaceC0979p2M = m(i13);
                    int i37 = (i10 & (-8)) | 4;
                    Object objNewInstance = interfaceC0979p2M.newInstance();
                    C0931d2 c0931d2 = (C0931d2) interfaceC0979p2M;
                    int iC = c0931d2.C(objNewInstance, bArr, i, i6, i37, c0948i);
                    int i38 = i37;
                    c0948i.c = objNewInstance;
                    interfaceC0979p2M.makeImmutable(objNewInstance);
                    c0948i.c = objNewInstance;
                    interfaceC0985r1.add(objNewInstance);
                    while (iC < i6) {
                        int iQ25 = AbstractC1002v2.q(bArr, iC, c0948i);
                        if (i10 != c0948i.f2923a) {
                            return iC;
                        }
                        Object objNewInstance2 = interfaceC0979p2M.newInstance();
                        int i39 = i38;
                        iC = c0931d2.C(objNewInstance2, bArr, iQ25, i6, i39, c0948i);
                        c0948i.c = objNewInstance2;
                        interfaceC0979p2M.makeImmutable(objNewInstance2);
                        c0948i.c = objNewInstance2;
                        interfaceC0985r1.add(objNewInstance2);
                        i38 = i39;
                    }
                    return iC;
                }
                return i;
            default:
                return i;
        }
    }

    public final void F(Object obj, int i, InterfaceC0975o2 interfaceC0975o2) {
        if ((536870912 & i) != 0) {
            W2.p(obj, i & 1048575, interfaceC0975o2.readStringRequireUtf8());
        } else if (this.g) {
            W2.p(obj, i & 1048575, interfaceC0975o2.readString());
        } else {
            W2.p(obj, i & 1048575, interfaceC0975o2.readBytes());
        }
    }

    public final void H(Object obj, int i) {
        int i6 = this.f2914a[i + 2];
        long j5 = 1048575 & i6;
        if (j5 == 1048575) {
            return;
        }
        W2.n(obj, j5, (1 << (i6 >>> 20)) | W2.c.i(obj, j5));
    }

    public final void I(Object obj, int i, int i6) {
        W2.n(obj, this.f2914a[i6 + 2] & 1048575, i);
    }

    public final int J(int i, int i6) {
        int[] iArr = this.f2914a;
        int length = (iArr.length / 3) - 1;
        while (i6 <= length) {
            int i10 = (length + i6) >>> 1;
            int i11 = i10 * 3;
            int i12 = iArr[i11];
            if (i == i12) {
                return i11;
            }
            if (i < i12) {
                length = i10 - 1;
            } else {
                i6 = i10 + 1;
            }
        }
        return -1;
    }

    public final void K(int i, Object obj, Object obj2) {
        f2913r.putObject(obj, N(i) & 1048575, obj2);
        H(obj, i);
    }

    public final void L(int i, int i6, Object obj, Object obj2) {
        f2913r.putObject(obj, N(i6) & 1048575, obj2);
        I(obj, i, i6);
    }

    public final int N(int i) {
        return this.f2914a[i + 1];
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0024  */
    /* JADX WARN: Type inference failed for: r18v0 */
    /* JADX WARN: Type inference failed for: r18v1, types: [long] */
    /* JADX WARN: Type inference failed for: r18v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void O(java.lang.Object r23, com.google.protobuf.F1 r24) throws com.google.protobuf.CodedOutputStream$OutOfSpaceException {
        /*
            Method dump skipped, instructions count: 1838
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C0931d2.O(java.lang.Object, com.google.protobuf.F1):void");
    }

    @Override // com.google.protobuf.InterfaceC0979p2
    public final void a(Object obj, F1 f12) throws CodedOutputStream$OutOfSpaceException {
        f12.getClass();
        O(obj, f12);
    }

    /* JADX WARN: Removed duplicated region for block: B:170:0x03a2  */
    @Override // com.google.protobuf.InterfaceC0979p2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int b(com.google.protobuf.AbstractC0932e r18) {
        /*
            Method dump skipped, instructions count: 1914
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C0931d2.b(com.google.protobuf.e):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:308:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x008b, code lost:
    
        r12.c(r5, r4);
     */
    /* JADX WARN: Removed duplicated region for block: B:244:0x06c7 A[LOOP:3: B:243:0x06c5->B:244:0x06c7, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:246:0x06d8  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x068b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:297:0x0696 A[SYNTHETIC] */
    @Override // com.google.protobuf.InterfaceC0979p2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(java.lang.Object r18, com.google.protobuf.InterfaceC0975o2 r19, com.google.protobuf.R0 r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1898
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C0931d2.c(java.lang.Object, com.google.protobuf.o2, com.google.protobuf.R0):void");
    }

    @Override // com.google.protobuf.InterfaceC0979p2
    public final void d(Object obj, byte[] bArr, int i, int i6, C0948i c0948i) throws InvalidProtocolBufferException {
        C(obj, bArr, i, i6, 0, c0948i);
    }

    @Override // com.google.protobuf.InterfaceC0979p2
    public final int e(GeneratedMessageLite generatedMessageLite) {
        int i;
        int iC;
        int[] iArr = this.f2914a;
        int length = iArr.length;
        int i6 = 0;
        for (int i10 = 0; i10 < length; i10 += 3) {
            int iN = N(i10);
            int i11 = iArr[i10];
            long j5 = 1048575 & iN;
            int iHashCode = 37;
            switch (M(iN)) {
                case 0:
                    i = i6 * 53;
                    iC = AbstractC0989s1.c(Double.doubleToLongBits(W2.c.g(generatedMessageLite, j5)));
                    i6 = iC + i;
                    break;
                case 1:
                    i = i6 * 53;
                    iC = Float.floatToIntBits(W2.c.h(generatedMessageLite, j5));
                    i6 = iC + i;
                    break;
                case 2:
                    i = i6 * 53;
                    iC = AbstractC0989s1.c(W2.c.j(generatedMessageLite, j5));
                    i6 = iC + i;
                    break;
                case 3:
                    i = i6 * 53;
                    iC = AbstractC0989s1.c(W2.c.j(generatedMessageLite, j5));
                    i6 = iC + i;
                    break;
                case 4:
                    i = i6 * 53;
                    iC = W2.c.i(generatedMessageLite, j5);
                    i6 = iC + i;
                    break;
                case 5:
                    i = i6 * 53;
                    iC = AbstractC0989s1.c(W2.c.j(generatedMessageLite, j5));
                    i6 = iC + i;
                    break;
                case 6:
                    i = i6 * 53;
                    iC = W2.c.i(generatedMessageLite, j5);
                    i6 = iC + i;
                    break;
                case 7:
                    i = i6 * 53;
                    iC = AbstractC0989s1.b(W2.c.d(generatedMessageLite, j5));
                    i6 = iC + i;
                    break;
                case 8:
                    i = i6 * 53;
                    iC = ((String) W2.c.k(generatedMessageLite, j5)).hashCode();
                    i6 = iC + i;
                    break;
                case 9:
                    Object objK = W2.c.k(generatedMessageLite, j5);
                    if (objK != null) {
                        iHashCode = objK.hashCode();
                    }
                    i6 = (i6 * 53) + iHashCode;
                    break;
                case 10:
                    i = i6 * 53;
                    iC = W2.c.k(generatedMessageLite, j5).hashCode();
                    i6 = iC + i;
                    break;
                case 11:
                    i = i6 * 53;
                    iC = W2.c.i(generatedMessageLite, j5);
                    i6 = iC + i;
                    break;
                case 12:
                    i = i6 * 53;
                    iC = W2.c.i(generatedMessageLite, j5);
                    i6 = iC + i;
                    break;
                case 13:
                    i = i6 * 53;
                    iC = W2.c.i(generatedMessageLite, j5);
                    i6 = iC + i;
                    break;
                case 14:
                    i = i6 * 53;
                    iC = AbstractC0989s1.c(W2.c.j(generatedMessageLite, j5));
                    i6 = iC + i;
                    break;
                case 15:
                    i = i6 * 53;
                    iC = W2.c.i(generatedMessageLite, j5);
                    i6 = iC + i;
                    break;
                case 16:
                    i = i6 * 53;
                    iC = AbstractC0989s1.c(W2.c.j(generatedMessageLite, j5));
                    i6 = iC + i;
                    break;
                case 17:
                    Object objK2 = W2.c.k(generatedMessageLite, j5);
                    if (objK2 != null) {
                        iHashCode = objK2.hashCode();
                    }
                    i6 = (i6 * 53) + iHashCode;
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
                    i = i6 * 53;
                    iC = W2.c.k(generatedMessageLite, j5).hashCode();
                    i6 = iC + i;
                    break;
                case 50:
                    i = i6 * 53;
                    iC = W2.c.k(generatedMessageLite, j5).hashCode();
                    i6 = iC + i;
                    break;
                case 51:
                    if (r(generatedMessageLite, i11, i10)) {
                        i = i6 * 53;
                        iC = AbstractC0989s1.c(Double.doubleToLongBits(((Double) W2.c.k(generatedMessageLite, j5)).doubleValue()));
                        i6 = iC + i;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (r(generatedMessageLite, i11, i10)) {
                        i = i6 * 53;
                        iC = Float.floatToIntBits(((Float) W2.c.k(generatedMessageLite, j5)).floatValue());
                        i6 = iC + i;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (r(generatedMessageLite, i11, i10)) {
                        i = i6 * 53;
                        iC = AbstractC0989s1.c(A(generatedMessageLite, j5));
                        i6 = iC + i;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (r(generatedMessageLite, i11, i10)) {
                        i = i6 * 53;
                        iC = AbstractC0989s1.c(A(generatedMessageLite, j5));
                        i6 = iC + i;
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BASELINE /* 55 */:
                    if (r(generatedMessageLite, i11, i10)) {
                        i = i6 * 53;
                        iC = z(generatedMessageLite, j5);
                        i6 = iC + i;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (r(generatedMessageLite, i11, i10)) {
                        i = i6 * 53;
                        iC = AbstractC0989s1.c(A(generatedMessageLite, j5));
                        i6 = iC + i;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (r(generatedMessageLite, i11, i10)) {
                        i = i6 * 53;
                        iC = z(generatedMessageLite, j5);
                        i6 = iC + i;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (r(generatedMessageLite, i11, i10)) {
                        i = i6 * 53;
                        iC = AbstractC0989s1.b(((Boolean) W2.c.k(generatedMessageLite, j5)).booleanValue());
                        i6 = iC + i;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (r(generatedMessageLite, i11, i10)) {
                        i = i6 * 53;
                        iC = ((String) W2.c.k(generatedMessageLite, j5)).hashCode();
                        i6 = iC + i;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (r(generatedMessageLite, i11, i10)) {
                        i = i6 * 53;
                        iC = W2.c.k(generatedMessageLite, j5).hashCode();
                        i6 = iC + i;
                        break;
                    } else {
                        break;
                    }
                case o7.s.MESSAGE_POST_FIELD_NUMBER /* 61 */:
                    if (r(generatedMessageLite, i11, i10)) {
                        i = i6 * 53;
                        iC = W2.c.k(generatedMessageLite, j5).hashCode();
                        i6 = iC + i;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (r(generatedMessageLite, i11, i10)) {
                        i = i6 * 53;
                        iC = z(generatedMessageLite, j5);
                        i6 = iC + i;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (r(generatedMessageLite, i11, i10)) {
                        i = i6 * 53;
                        iC = z(generatedMessageLite, j5);
                        i6 = iC + i;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (r(generatedMessageLite, i11, i10)) {
                        i = i6 * 53;
                        iC = z(generatedMessageLite, j5);
                        i6 = iC + i;
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                    if (r(generatedMessageLite, i11, i10)) {
                        i = i6 * 53;
                        iC = AbstractC0989s1.c(A(generatedMessageLite, j5));
                        i6 = iC + i;
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    if (r(generatedMessageLite, i11, i10)) {
                        i = i6 * 53;
                        iC = z(generatedMessageLite, j5);
                        i6 = iC + i;
                        break;
                    } else {
                        break;
                    }
                case ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL /* 67 */:
                    if (r(generatedMessageLite, i11, i10)) {
                        i = i6 * 53;
                        iC = AbstractC0989s1.c(A(generatedMessageLite, j5));
                        i6 = iC + i;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (r(generatedMessageLite, i11, i10)) {
                        i = i6 * 53;
                        iC = W2.c.k(generatedMessageLite, j5).hashCode();
                        i6 = iC + i;
                        break;
                    } else {
                        break;
                    }
            }
        }
        ((O2) this.n).getClass();
        int iHashCode2 = generatedMessageLite.unknownFields.hashCode() + (i6 * 53);
        if (!this.f) {
            return iHashCode2;
        }
        return this.o.c(generatedMessageLite).f2903a.hashCode() + (iHashCode2 * 53);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    @Override // com.google.protobuf.InterfaceC0979p2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean f(com.google.protobuf.GeneratedMessageLite r12, com.google.protobuf.GeneratedMessageLite r13) {
        /*
            Method dump skipped, instructions count: 684
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C0931d2.f(com.google.protobuf.GeneratedMessageLite, com.google.protobuf.GeneratedMessageLite):boolean");
    }

    public final boolean g(GeneratedMessageLite generatedMessageLite, GeneratedMessageLite generatedMessageLite2, int i) {
        return p(generatedMessageLite, i) == p(generatedMessageLite2, i);
    }

    @Override // com.google.protobuf.InterfaceC0979p2
    public final boolean isInitialized(Object obj) {
        int i;
        int i6;
        int i10;
        int i11 = 1048575;
        int i12 = 0;
        int i13 = 0;
        loop0: while (true) {
            if (i13 < this.f2915j) {
                int i14 = this.i[i13];
                int[] iArr = this.f2914a;
                int i15 = iArr[i14];
                int iN = N(i14);
                int i16 = iArr[i14 + 2];
                int i17 = i16 & 1048575;
                int i18 = 1 << (i16 >>> 20);
                if (i17 != i11) {
                    if (i17 != 1048575) {
                        i12 = f2913r.getInt(obj, i17);
                    }
                    i6 = i14;
                    i10 = i12;
                    i = i17;
                } else {
                    int i19 = i12;
                    i = i11;
                    i6 = i14;
                    i10 = i19;
                }
                if ((268435456 & iN) != 0 && !o(i6, obj, i, i10, i18)) {
                    break;
                }
                int iM = M(iN);
                if (iM == 9 || iM == 17) {
                    if (o(i6, obj, i, i10, i18)) {
                        if (!m(i6).isInitialized(W2.c.k(obj, iN & 1048575))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                    i13++;
                    i11 = i;
                    i12 = i10;
                } else {
                    if (iM != 27) {
                        if (iM == 60 || iM == 68) {
                            if (r(obj, i15, i6)) {
                                if (!m(i6).isInitialized(W2.c.k(obj, iN & 1048575))) {
                                    break;
                                }
                            } else {
                                continue;
                            }
                            i13++;
                            i11 = i;
                            i12 = i10;
                        } else if (iM != 49) {
                            if (iM != 50) {
                                continue;
                            } else {
                                Object objK = W2.c.k(obj, iN & 1048575);
                                Q1 q1 = this.p;
                                Map mapForMapData = q1.forMapData(objK);
                                if (!mapForMapData.isEmpty() && ((WireFormat$FieldType) q1.forMapMetadata(l(i6)).d).f2887a == WireFormat$JavaType.MESSAGE) {
                                    InterfaceC0979p2 interfaceC0979p2A = null;
                                    for (Object obj2 : mapForMapData.values()) {
                                        if (interfaceC0979p2A == null) {
                                            interfaceC0979p2A = C0963l2.c.a(obj2.getClass());
                                        }
                                        if (!interfaceC0979p2A.isInitialized(obj2)) {
                                            break loop0;
                                        }
                                    }
                                }
                            }
                            i13++;
                            i11 = i;
                            i12 = i10;
                        }
                    }
                    List list = (List) W2.c.k(obj, iN & 1048575);
                    if (list.isEmpty()) {
                        continue;
                    } else {
                        InterfaceC0979p2 interfaceC0979p2M = m(i6);
                        for (int i20 = 0; i20 < list.size(); i20++) {
                            if (!interfaceC0979p2M.isInitialized(list.get(i20))) {
                                break loop0;
                            }
                        }
                    }
                    i13++;
                    i11 = i;
                    i12 = i10;
                }
            } else if (!this.f || this.o.c(obj).m()) {
                return true;
            }
        }
        return false;
    }

    public final Object j(Object obj, int i, Object obj2, H2 h22, Object obj3) {
        InterfaceC0978p1 interfaceC0978p1K;
        int i6 = this.f2914a[i];
        Object objK = W2.c.k(obj, N(i) & 1048575);
        if (objK == null || (interfaceC0978p1K = k(i)) == null) {
            return obj2;
        }
        Q1 q1 = this.p;
        Map mapForMutableMapData = q1.forMutableMapData(objK);
        u1.d dVarForMapMetadata = q1.forMapMetadata(l(i));
        Iterator it = mapForMutableMapData.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (!interfaceC0978p1K.isInRange(((Integer) entry.getValue()).intValue())) {
                if (obj2 == null) {
                    obj2 = h22.a(obj3);
                }
                int iA = K1.a(dVarForMapMetadata, entry.getKey(), entry.getValue());
                byte[] bArr = new byte[iA];
                C0980q c0980q = new C0980q(bArr, iA);
                try {
                    K1.d(c0980q, dVarForMapMetadata, entry.getKey(), entry.getValue());
                    if (c0980q.e - c0980q.f != 0) {
                        throw new IllegalStateException("Did not write as much data as expected.");
                    }
                    ByteString.LiteralByteString literalByteString = new ByteString.LiteralByteString(bArr);
                    ((O2) h22).getClass();
                    ((N2) obj2).d((i6 << 3) | 2, literalByteString);
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return obj2;
    }

    public final InterfaceC0978p1 k(int i) {
        return (InterfaceC0978p1) this.b[((i / 3) * 2) + 1];
    }

    public final Object l(int i) {
        return this.b[(i / 3) * 2];
    }

    public final InterfaceC0979p2 m(int i) {
        int i6 = (i / 3) * 2;
        Object[] objArr = this.b;
        InterfaceC0979p2 interfaceC0979p2 = (InterfaceC0979p2) objArr[i6];
        if (interfaceC0979p2 != null) {
            return interfaceC0979p2;
        }
        InterfaceC0979p2 interfaceC0979p2A = C0963l2.c.a((Class) objArr[i6 + 1]);
        objArr[i6] = interfaceC0979p2A;
        return interfaceC0979p2A;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006c  */
    @Override // com.google.protobuf.InterfaceC0979p2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void makeImmutable(java.lang.Object r10) {
        /*
            r9 = this;
            boolean r0 = q(r10)
            if (r0 != 0) goto L8
            goto L9d
        L8:
            boolean r0 = r10 instanceof com.google.protobuf.GeneratedMessageLite
            r1 = 0
            if (r0 == 0) goto L1b
            r0 = r10
            com.google.protobuf.GeneratedMessageLite r0 = (com.google.protobuf.GeneratedMessageLite) r0
            r2 = 2147483647(0x7fffffff, float:NaN)
            r0.l(r2)
            r0.memoizedHashCode = r1
            r0.w()
        L1b:
            int[] r0 = r9.f2914a
            int r2 = r0.length
            r3 = r1
        L1f:
            if (r3 >= r2) goto L82
            int r4 = r9.N(r3)
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r4
            long r5 = (long) r5
            int r4 = M(r4)
            r7 = 9
            if (r4 == r7) goto L6c
            r7 = 60
            if (r4 == r7) goto L56
            r7 = 68
            if (r4 == r7) goto L56
            switch(r4) {
                case 17: goto L6c;
                case 18: goto L50;
                case 19: goto L50;
                case 20: goto L50;
                case 21: goto L50;
                case 22: goto L50;
                case 23: goto L50;
                case 24: goto L50;
                case 25: goto L50;
                case 26: goto L50;
                case 27: goto L50;
                case 28: goto L50;
                case 29: goto L50;
                case 30: goto L50;
                case 31: goto L50;
                case 32: goto L50;
                case 33: goto L50;
                case 34: goto L50;
                case 35: goto L50;
                case 36: goto L50;
                case 37: goto L50;
                case 38: goto L50;
                case 39: goto L50;
                case 40: goto L50;
                case 41: goto L50;
                case 42: goto L50;
                case 43: goto L50;
                case 44: goto L50;
                case 45: goto L50;
                case 46: goto L50;
                case 47: goto L50;
                case 48: goto L50;
                case 49: goto L50;
                case 50: goto L3e;
                default: goto L3d;
            }
        L3d:
            goto L7f
        L3e:
            sun.misc.Unsafe r4 = com.google.protobuf.C0931d2.f2913r
            java.lang.Object r7 = r4.getObject(r10, r5)
            if (r7 == 0) goto L7f
            com.google.protobuf.Q1 r8 = r9.p
            java.lang.Object r7 = r8.toImmutable(r7)
            r4.putObject(r10, r5, r7)
            goto L7f
        L50:
            com.google.protobuf.A1 r4 = r9.m
            r4.a(r10, r5)
            goto L7f
        L56:
            r4 = r0[r3]
            boolean r4 = r9.r(r10, r4, r3)
            if (r4 == 0) goto L7f
            com.google.protobuf.p2 r4 = r9.m(r3)
            sun.misc.Unsafe r7 = com.google.protobuf.C0931d2.f2913r
            java.lang.Object r5 = r7.getObject(r10, r5)
            r4.makeImmutable(r5)
            goto L7f
        L6c:
            boolean r4 = r9.p(r10, r3)
            if (r4 == 0) goto L7f
            com.google.protobuf.p2 r4 = r9.m(r3)
            sun.misc.Unsafe r7 = com.google.protobuf.C0931d2.f2913r
            java.lang.Object r5 = r7.getObject(r10, r5)
            r4.makeImmutable(r5)
        L7f:
            int r3 = r3 + 3
            goto L1f
        L82:
            com.google.protobuf.H2 r0 = r9.n
            com.google.protobuf.O2 r0 = (com.google.protobuf.O2) r0
            r0.getClass()
            r0 = r10
            com.google.protobuf.GeneratedMessageLite r0 = (com.google.protobuf.GeneratedMessageLite) r0
            com.google.protobuf.N2 r0 = r0.unknownFields
            boolean r2 = r0.e
            if (r2 == 0) goto L94
            r0.e = r1
        L94:
            boolean r0 = r9.f
            if (r0 == 0) goto L9d
            com.google.protobuf.S0 r9 = r9.o
            r9.f(r10)
        L9d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C0931d2.makeImmutable(java.lang.Object):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0022  */
    @Override // com.google.protobuf.InterfaceC0979p2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void mergeFrom(java.lang.Object r11, java.lang.Object r12) {
        /*
            Method dump skipped, instructions count: 596
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C0931d2.mergeFrom(java.lang.Object, java.lang.Object):void");
    }

    @Override // com.google.protobuf.InterfaceC0979p2
    public final Object newInstance() {
        return this.l.newInstance(this.e);
    }

    public final boolean o(int i, Object obj, int i6, int i10, int i11) {
        return i6 == 1048575 ? p(obj, i) : (i10 & i11) != 0;
    }

    public final boolean p(Object obj, int i) {
        int i6 = this.f2914a[i + 2];
        long j5 = i6 & 1048575;
        if (j5 == 1048575) {
            int iN = N(i);
            long j6 = iN & 1048575;
            switch (M(iN)) {
                case 0:
                    if (Double.doubleToRawLongBits(W2.c.g(obj, j6)) == 0) {
                        return false;
                    }
                    break;
                case 1:
                    if (Float.floatToRawIntBits(W2.c.h(obj, j6)) == 0) {
                        return false;
                    }
                    break;
                case 2:
                    if (W2.c.j(obj, j6) == 0) {
                        return false;
                    }
                    break;
                case 3:
                    if (W2.c.j(obj, j6) == 0) {
                        return false;
                    }
                    break;
                case 4:
                    if (W2.c.i(obj, j6) == 0) {
                        return false;
                    }
                    break;
                case 5:
                    if (W2.c.j(obj, j6) == 0) {
                        return false;
                    }
                    break;
                case 6:
                    if (W2.c.i(obj, j6) == 0) {
                        return false;
                    }
                    break;
                case 7:
                    return W2.c.d(obj, j6);
                case 8:
                    Object objK = W2.c.k(obj, j6);
                    if (objK instanceof String) {
                        return !((String) objK).isEmpty();
                    }
                    if (objK instanceof ByteString) {
                        return !ByteString.b.equals(objK);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    if (W2.c.k(obj, j6) == null) {
                        return false;
                    }
                    break;
                case 10:
                    return !ByteString.b.equals(W2.c.k(obj, j6));
                case 11:
                    if (W2.c.i(obj, j6) == 0) {
                        return false;
                    }
                    break;
                case 12:
                    if (W2.c.i(obj, j6) == 0) {
                        return false;
                    }
                    break;
                case 13:
                    if (W2.c.i(obj, j6) == 0) {
                        return false;
                    }
                    break;
                case 14:
                    if (W2.c.j(obj, j6) == 0) {
                        return false;
                    }
                    break;
                case 15:
                    if (W2.c.i(obj, j6) == 0) {
                        return false;
                    }
                    break;
                case 16:
                    if (W2.c.j(obj, j6) == 0) {
                        return false;
                    }
                    break;
                case 17:
                    if (W2.c.k(obj, j6) == null) {
                        return false;
                    }
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        } else if (((1 << (i6 >>> 20)) & W2.c.i(obj, j5)) == 0) {
            return false;
        }
        return true;
    }

    public final boolean r(Object obj, int i, int i6) {
        return W2.c.i(obj, (long) (this.f2914a[i6 + 2] & 1048575)) == i;
    }

    public final void s(Object obj, int i, Object obj2, R0 r02, InterfaceC0975o2 interfaceC0975o2) {
        long jN = N(i) & 1048575;
        Object objK = W2.c.k(obj, jN);
        Q1 q1 = this.p;
        if (objK == null) {
            objK = q1.newMapField(obj2);
            W2.p(obj, jN, objK);
        } else if (q1.isImmutable(objK)) {
            Object objNewMapField = q1.newMapField(obj2);
            q1.mergeFrom(objNewMapField, objK);
            W2.p(obj, jN, objNewMapField);
            objK = objNewMapField;
        }
        interfaceC0975o2.c(q1.forMutableMapData(objK), q1.forMapMetadata(obj2), r02);
    }

    public final void t(Object obj, Object obj2, int i) {
        if (p(obj2, i)) {
            long jN = N(i) & 1048575;
            Unsafe unsafe = f2913r;
            Object object = unsafe.getObject(obj2, jN);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.f2914a[i] + " is present but null: " + obj2);
            }
            InterfaceC0979p2 interfaceC0979p2M = m(i);
            if (!p(obj, i)) {
                if (q(object)) {
                    Object objNewInstance = interfaceC0979p2M.newInstance();
                    interfaceC0979p2M.mergeFrom(objNewInstance, object);
                    unsafe.putObject(obj, jN, objNewInstance);
                } else {
                    unsafe.putObject(obj, jN, object);
                }
                H(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, jN);
            if (!q(object2)) {
                Object objNewInstance2 = interfaceC0979p2M.newInstance();
                interfaceC0979p2M.mergeFrom(objNewInstance2, object2);
                unsafe.putObject(obj, jN, objNewInstance2);
                object2 = objNewInstance2;
            }
            interfaceC0979p2M.mergeFrom(object2, object);
        }
    }

    public final void u(Object obj, Object obj2, int i) {
        int[] iArr = this.f2914a;
        int i6 = iArr[i];
        if (r(obj2, i6, i)) {
            long jN = N(i) & 1048575;
            Unsafe unsafe = f2913r;
            Object object = unsafe.getObject(obj2, jN);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + iArr[i] + " is present but null: " + obj2);
            }
            InterfaceC0979p2 interfaceC0979p2M = m(i);
            if (!r(obj, i6, i)) {
                if (q(object)) {
                    Object objNewInstance = interfaceC0979p2M.newInstance();
                    interfaceC0979p2M.mergeFrom(objNewInstance, object);
                    unsafe.putObject(obj, jN, objNewInstance);
                } else {
                    unsafe.putObject(obj, jN, object);
                }
                I(obj, i6, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, jN);
            if (!q(object2)) {
                Object objNewInstance2 = interfaceC0979p2M.newInstance();
                interfaceC0979p2M.mergeFrom(objNewInstance2, object2);
                unsafe.putObject(obj, jN, objNewInstance2);
                object2 = objNewInstance2;
            }
            interfaceC0979p2M.mergeFrom(object2, object);
        }
    }

    public final Object v(int i, Object obj) {
        InterfaceC0979p2 interfaceC0979p2M = m(i);
        long jN = N(i) & 1048575;
        if (!p(obj, i)) {
            return interfaceC0979p2M.newInstance();
        }
        Object object = f2913r.getObject(obj, jN);
        if (q(object)) {
            return object;
        }
        Object objNewInstance = interfaceC0979p2M.newInstance();
        if (object != null) {
            interfaceC0979p2M.mergeFrom(objNewInstance, object);
        }
        return objNewInstance;
    }

    public final Object w(int i, int i6, Object obj) {
        InterfaceC0979p2 interfaceC0979p2M = m(i6);
        if (!r(obj, i, i6)) {
            return interfaceC0979p2M.newInstance();
        }
        Object object = f2913r.getObject(obj, N(i6) & 1048575);
        if (q(object)) {
            return object;
        }
        Object objNewInstance = interfaceC0979p2M.newInstance();
        if (object != null) {
            interfaceC0979p2M.mergeFrom(objNewInstance, object);
        }
        return objNewInstance;
    }
}
