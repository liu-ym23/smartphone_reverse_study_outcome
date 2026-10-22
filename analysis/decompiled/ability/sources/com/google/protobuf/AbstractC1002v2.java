package com.google.protobuf;

import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2.FastDoubleMath;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.protobuf.v2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC1002v2 implements InterfaceC0920b {

    /* renamed from: a, reason: collision with root package name */
    public static final C0994t2 f2981a = new C0994t2();
    public static final C0998u2 b = new C0998u2();

    public static boolean B(byte b5) {
        return b5 > -65;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean D(com.google.protobuf.AbstractC0972o r7, com.google.protobuf.I2 r8, com.google.protobuf.R0 r9, com.google.protobuf.C1004w0 r10, com.google.protobuf.InterfaceC0927c2 r11, int r12) {
        /*
            Method dump skipped, instructions count: 378
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.AbstractC1002v2.D(com.google.protobuf.o, com.google.protobuf.I2, com.google.protobuf.R0, com.google.protobuf.w0, com.google.protobuf.c2, int):boolean");
    }

    public static int E(Object obj, InterfaceC0979p2 interfaceC0979p2, byte[] bArr, int i, int i6, C0948i c0948i) throws InvalidProtocolBufferException {
        int iP = i + 1;
        int i10 = bArr[i];
        if (i10 < 0) {
            iP = p(i10, bArr, iP, c0948i);
            i10 = c0948i.f2923a;
        }
        int i11 = iP;
        if (i10 < 0 || i10 > i6 - i11) {
            throw InvalidProtocolBufferException.g();
        }
        int i12 = i11 + i10;
        interfaceC0979p2.d(obj, bArr, i11, i12, c0948i);
        c0948i.c = obj;
        return i12;
    }

    public static Object G(AbstractC0972o abstractC0972o, WireFormat$FieldType wireFormat$FieldType, WireFormat$Utf8Validation wireFormat$Utf8Validation) {
        switch (wireFormat$FieldType.ordinal()) {
            case 0:
                return Double.valueOf(abstractC0972o.m());
            case 1:
                return Float.valueOf(abstractC0972o.q());
            case 2:
                return Long.valueOf(abstractC0972o.t());
            case 3:
                return Long.valueOf(abstractC0972o.F());
            case 4:
                return Integer.valueOf(abstractC0972o.s());
            case 5:
                return Long.valueOf(abstractC0972o.p());
            case 6:
                return Integer.valueOf(abstractC0972o.o());
            case 7:
                return Boolean.valueOf(abstractC0972o.k());
            case 8:
                return wireFormat$Utf8Validation.a(abstractC0972o);
            case 9:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            case 10:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            case 11:
                return abstractC0972o.l();
            case 12:
                return Integer.valueOf(abstractC0972o.E());
            case 13:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
            case 14:
                return Integer.valueOf(abstractC0972o.x());
            case 15:
                return Long.valueOf(abstractC0972o.y());
            case 16:
                return Integer.valueOf(abstractC0972o.z());
            case 17:
                return Long.valueOf(abstractC0972o.A());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int H(int i, byte[] bArr, int i6, int i10, C0948i c0948i) throws InvalidProtocolBufferException {
        if ((i >>> 3) == 0) {
            throw InvalidProtocolBufferException.a();
        }
        int i11 = i & 7;
        if (i11 == 0) {
            return s(bArr, i6, c0948i);
        }
        if (i11 == 1) {
            return i6 + 8;
        }
        if (i11 == 2) {
            return q(bArr, i6, c0948i) + c0948i.f2923a;
        }
        if (i11 != 3) {
            if (i11 == 5) {
                return i6 + 4;
            }
            throw InvalidProtocolBufferException.a();
        }
        int i12 = (i & (-8)) | 4;
        int i13 = 0;
        while (i6 < i10) {
            i6 = q(bArr, i6, c0948i);
            i13 = c0948i.f2923a;
            if (i13 == i12) {
                break;
            }
            i6 = H(i13, bArr, i6, i10, c0948i);
        }
        if (i6 > i10 || i13 != i12) {
            throw InvalidProtocolBufferException.f();
        }
        return i6;
    }

    public static String I(String str, D0 d02, int i) {
        StringBuilder sb = new StringBuilder(str);
        if (d02.b.L()) {
            sb.append('(');
            sb.append(d02.c);
            sb.append(')');
        } else {
            sb.append(d02.b.H());
        }
        if (i != -1) {
            sb.append('[');
            sb.append(i);
            sb.append(']');
        }
        sb.append('.');
        return sb.toString();
    }

    public static void a(byte b5, byte b10, byte b11, byte b12, char[] cArr, int i) throws InvalidProtocolBufferException {
        if (!B(b10)) {
            if ((((b10 + 112) + (b5 << 28)) >> 30) == 0 && !B(b11) && !B(b12)) {
                int i6 = ((b5 & 7) << 18) | ((b10 & 63) << 12) | ((b11 & 63) << 6) | (b12 & 63);
                cArr[i] = (char) ((i6 >>> 10) + 55232);
                cArr[i + 1] = (char) ((i6 & FastDoubleMath.DOUBLE_EXPONENT_BIAS) + GeneratorBase.SURR2_FIRST);
                return;
            }
        }
        throw InvalidProtocolBufferException.b();
    }

    public static void b(byte b5, byte b10, char[] cArr, int i) throws InvalidProtocolBufferException {
        if (b5 < -62 || B(b10)) {
            throw InvalidProtocolBufferException.b();
        }
        cArr[i] = (char) (((b5 & 31) << 6) | (b10 & 63));
    }

    public static void c(byte b5, byte b10, byte b11, char[] cArr, int i) throws InvalidProtocolBufferException {
        if (B(b10) || ((b5 == -32 && b10 < -96) || ((b5 == -19 && b10 >= -96) || B(b11)))) {
            throw InvalidProtocolBufferException.b();
        }
        cArr[i] = (char) (((b5 & 15) << 12) | ((b10 & 63) << 6) | (b11 & 63));
    }

    public static int g(byte[] bArr, int i, C0948i c0948i) throws InvalidProtocolBufferException {
        int iQ = q(bArr, i, c0948i);
        int i6 = c0948i.f2923a;
        if (i6 < 0) {
            throw InvalidProtocolBufferException.e();
        }
        if (i6 > bArr.length - iQ) {
            throw InvalidProtocolBufferException.g();
        }
        if (i6 == 0) {
            c0948i.c = ByteString.b;
            return iQ;
        }
        c0948i.c = ByteString.e(bArr, iQ, i6);
        return iQ + i6;
    }

    public static int i(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public static long j(byte[] bArr, int i) {
        return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    public static int k(InterfaceC0979p2 interfaceC0979p2, int i, byte[] bArr, int i6, int i10, InterfaceC0985r1 interfaceC0985r1, C0948i c0948i) throws InvalidProtocolBufferException {
        Object objNewInstance = interfaceC0979p2.newInstance();
        InterfaceC0979p2 interfaceC0979p22 = interfaceC0979p2;
        byte[] bArr2 = bArr;
        int i11 = i10;
        C0948i c0948i2 = c0948i;
        int iE = E(objNewInstance, interfaceC0979p22, bArr2, i6, i11, c0948i2);
        interfaceC0979p22.makeImmutable(objNewInstance);
        c0948i2.c = objNewInstance;
        interfaceC0985r1.add(objNewInstance);
        while (iE < i11) {
            C0948i c0948i3 = c0948i2;
            int i12 = i11;
            int iQ = q(bArr2, iE, c0948i3);
            if (i != c0948i3.f2923a) {
                break;
            }
            byte[] bArr3 = bArr2;
            InterfaceC0979p2 interfaceC0979p23 = interfaceC0979p22;
            Object objNewInstance2 = interfaceC0979p23.newInstance();
            iE = E(objNewInstance2, interfaceC0979p23, bArr3, iQ, i12, c0948i3);
            interfaceC0979p22 = interfaceC0979p23;
            bArr2 = bArr3;
            i11 = i12;
            c0948i2 = c0948i3;
            interfaceC0979p22.makeImmutable(objNewInstance2);
            c0948i2.c = objNewInstance2;
            interfaceC0985r1.add(objNewInstance2);
        }
        return iE;
    }

    public static int l(int i, byte[] bArr, int i6, int i10, N2 n22, C0948i c0948i) throws InvalidProtocolBufferException {
        if ((i >>> 3) == 0) {
            throw InvalidProtocolBufferException.a();
        }
        int i11 = i & 7;
        if (i11 == 0) {
            int iS = s(bArr, i6, c0948i);
            n22.d(i, Long.valueOf(c0948i.b));
            return iS;
        }
        if (i11 == 1) {
            n22.d(i, Long.valueOf(j(bArr, i6)));
            return i6 + 8;
        }
        if (i11 == 2) {
            int iQ = q(bArr, i6, c0948i);
            int i12 = c0948i.f2923a;
            if (i12 < 0) {
                throw InvalidProtocolBufferException.e();
            }
            if (i12 > bArr.length - iQ) {
                throw InvalidProtocolBufferException.g();
            }
            if (i12 == 0) {
                n22.d(i, ByteString.b);
            } else {
                n22.d(i, ByteString.e(bArr, iQ, i12));
            }
            return iQ + i12;
        }
        if (i11 != 3) {
            if (i11 != 5) {
                throw InvalidProtocolBufferException.a();
            }
            n22.d(i, Integer.valueOf(i(bArr, i6)));
            return i6 + 4;
        }
        N2 n2C = N2.c();
        int i13 = (i & (-8)) | 4;
        int i14 = 0;
        while (true) {
            if (i6 >= i10) {
                break;
            }
            int iQ2 = q(bArr, i6, c0948i);
            i14 = c0948i.f2923a;
            if (i14 == i13) {
                i6 = iQ2;
                break;
            }
            i6 = l(i14, bArr, iQ2, i10, n2C, c0948i);
        }
        if (i6 > i10 || i14 != i13) {
            throw InvalidProtocolBufferException.f();
        }
        n22.d(i, n2C);
        return i6;
    }

    public static String n(ByteBuffer byteBuffer, int i, int i6) throws InvalidProtocolBufferException {
        if ((i | i6 | ((byteBuffer.limit() - i) - i6)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i), Integer.valueOf(i6)));
        }
        int i10 = i + i6;
        char[] cArr = new char[i6];
        int i11 = 0;
        while (i < i10) {
            byte b5 = byteBuffer.get(i);
            if (b5 < 0) {
                break;
            }
            i++;
            cArr[i11] = (char) b5;
            i11++;
        }
        int i12 = i11;
        while (i < i10) {
            int i13 = i + 1;
            byte b10 = byteBuffer.get(i);
            if (b10 >= 0) {
                int i14 = i12 + 1;
                cArr[i12] = (char) b10;
                int i15 = i13;
                while (i15 < i10) {
                    byte b11 = byteBuffer.get(i15);
                    if (b11 < 0) {
                        break;
                    }
                    i15++;
                    cArr[i14] = (char) b11;
                    i14++;
                }
                i12 = i14;
                i = i15;
            } else if (b10 < -32) {
                if (i13 >= i10) {
                    throw InvalidProtocolBufferException.b();
                }
                i += 2;
                b(b10, byteBuffer.get(i13), cArr, i12);
                i12++;
            } else if (b10 < -16) {
                if (i13 >= i10 - 1) {
                    throw InvalidProtocolBufferException.b();
                }
                int i16 = i + 2;
                i += 3;
                c(b10, byteBuffer.get(i13), byteBuffer.get(i16), cArr, i12);
                i12++;
            } else {
                if (i13 >= i10 - 2) {
                    throw InvalidProtocolBufferException.b();
                }
                byte b12 = byteBuffer.get(i13);
                int i17 = i + 3;
                byte b13 = byteBuffer.get(i + 2);
                i += 4;
                a(b10, b12, b13, byteBuffer.get(i17), cArr, i12);
                i12 += 2;
            }
        }
        return new String(cArr, 0, i12);
    }

    public static int p(int i, byte[] bArr, int i6, C0948i c0948i) {
        int i10 = i & 127;
        int i11 = i6 + 1;
        byte b5 = bArr[i6];
        if (b5 >= 0) {
            c0948i.f2923a = i10 | (b5 << 7);
            return i11;
        }
        int i12 = i10 | ((b5 & 127) << 7);
        int i13 = i6 + 2;
        byte b10 = bArr[i11];
        if (b10 >= 0) {
            c0948i.f2923a = i12 | (b10 << 14);
            return i13;
        }
        int i14 = i12 | ((b10 & 127) << 14);
        int i15 = i6 + 3;
        byte b11 = bArr[i13];
        if (b11 >= 0) {
            c0948i.f2923a = i14 | (b11 << 21);
            return i15;
        }
        int i16 = i14 | ((b11 & 127) << 21);
        int i17 = i6 + 4;
        byte b12 = bArr[i15];
        if (b12 >= 0) {
            c0948i.f2923a = i16 | (b12 << 28);
            return i17;
        }
        int i18 = i16 | ((b12 & 127) << 28);
        while (true) {
            int i19 = i17 + 1;
            if (bArr[i17] >= 0) {
                c0948i.f2923a = i18;
                return i19;
            }
            i17 = i19;
        }
    }

    public static int q(byte[] bArr, int i, C0948i c0948i) {
        int i6 = i + 1;
        byte b5 = bArr[i];
        if (b5 < 0) {
            return p(b5, bArr, i6, c0948i);
        }
        c0948i.f2923a = b5;
        return i6;
    }

    public static int r(int i, byte[] bArr, int i6, int i10, InterfaceC0985r1 interfaceC0985r1, C0948i c0948i) {
        C0970n1 c0970n1 = (C0970n1) interfaceC0985r1;
        int iQ = q(bArr, i6, c0948i);
        c0970n1.addInt(c0948i.f2923a);
        while (iQ < i10) {
            int iQ2 = q(bArr, iQ, c0948i);
            if (i != c0948i.f2923a) {
                break;
            }
            iQ = q(bArr, iQ2, c0948i);
            c0970n1.addInt(c0948i.f2923a);
        }
        return iQ;
    }

    public static int s(byte[] bArr, int i, C0948i c0948i) {
        int i6 = i + 1;
        long j5 = bArr[i];
        if (j5 >= 0) {
            c0948i.b = j5;
            return i6;
        }
        int i10 = i + 2;
        byte b5 = bArr[i6];
        long j6 = (j5 & 127) | ((b5 & 127) << 7);
        int i11 = 7;
        while (b5 < 0) {
            int i12 = i10 + 1;
            i11 += 7;
            j6 |= (r10 & 127) << i11;
            b5 = bArr[i10];
            i10 = i12;
        }
        c0948i.b = j6;
        return i10;
    }

    public static String u(ByteString byteString) {
        return v(new F1(byteString, 7));
    }

    public static String v(F1 f12) {
        byte b5;
        StringBuilder sb = new StringBuilder(f12.m());
        for (int i = 0; i < f12.m(); i++) {
            switch (f12.f2829a) {
                case 7:
                    b5 = ((ByteString) f12.b).b(i);
                    break;
                default:
                    b5 = ((byte[]) f12.b)[i];
                    break;
            }
            if (b5 == 34) {
                sb.append("\\\"");
            } else if (b5 == 39) {
                sb.append("\\'");
            } else if (b5 != 92) {
                switch (b5) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (b5 < 32 || b5 > 126) {
                            sb.append('\\');
                            sb.append((char) (((b5 >>> 6) & 3) + 48));
                            sb.append((char) (((b5 >>> 3) & 7) + 48));
                            sb.append((char) ((b5 & 7) + 48));
                            break;
                        } else {
                            sb.append((char) b5);
                            break;
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    public static void w(InterfaceC0919a2 interfaceC0919a2, String str, ArrayList arrayList) {
        for (D0 d02 : interfaceC0919a2.e().h()) {
            if (d02.n() && !interfaceC0919a2.d(d02)) {
                StringBuilder sbV = androidx.compose.foundation.b.v(str);
                sbV.append(d02.b.H());
                arrayList.add(sbV.toString());
            }
        }
        for (Map.Entry entry : interfaceC0919a2.b().entrySet()) {
            D0 d03 = (D0) entry.getKey();
            Object value = entry.getValue();
            if (d03.g.f2824a == Descriptors$FieldDescriptor$JavaType.MESSAGE) {
                if (d03.isRepeated()) {
                    Iterator it = ((List) value).iterator();
                    int i = 0;
                    while (it.hasNext()) {
                        w((InterfaceC0919a2) it.next(), I(str, d03, i), arrayList);
                        i++;
                    }
                } else if (interfaceC0919a2.d(d03)) {
                    w((InterfaceC0919a2) value, I(str, d03, -1), arrayList);
                }
            }
        }
    }

    public abstract List A();

    public boolean C(byte[] bArr, int i, int i6) {
        return F(bArr, i, i6) == 0;
    }

    public abstract int F(byte[] bArr, int i, int i6);

    public abstract void d(Iterable iterable);

    public abstract void e(AbstractC0924c abstractC0924c);

    public abstract List f();

    public abstract String m(byte[] bArr, int i, int i6);

    public abstract String o(ByteBuffer byteBuffer, int i, int i6);

    public abstract int t(String str, byte[] bArr, int i, int i6);

    public abstract List x();

    public abstract J1 y();

    public abstract AbstractC0924c z(int i);
}
