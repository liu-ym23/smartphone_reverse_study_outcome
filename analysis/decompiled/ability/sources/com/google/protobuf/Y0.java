package com.google.protobuf;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public final class Y0 {
    public static final Y0 d;

    /* renamed from: a, reason: collision with root package name */
    public final C0990s2 f2903a;
    public boolean b;
    public boolean c;

    static {
        Y0 y02 = new Y0(new C0990s2(0));
        y02.q();
        d = y02;
    }

    public Y0() {
        this.f2903a = new C0990s2(16);
    }

    public static C0990s2 b(C0990s2 c0990s2, boolean z10) {
        C0990s2 c0990s22 = new C0990s2(16);
        for (int i = 0; i < c0990s2.b.size(); i++) {
            c(c0990s22, c0990s2.d(i), z10);
        }
        Iterator it = c0990s2.e().iterator();
        while (it.hasNext()) {
            c(c0990s22, (Map.Entry) it.next(), z10);
        }
        return c0990s22;
    }

    public static void c(C0990s2 c0990s2, Map.Entry entry, boolean z10) {
        X0 x02 = (X0) entry.getKey();
        Object value = entry.getValue();
        if (z10 && (value instanceof List)) {
            c0990s2.put(x02, new ArrayList((List) value));
        } else {
            c0990s2.put(x02, value);
        }
    }

    public static Object d(Object obj) {
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public static int e(WireFormat$FieldType wireFormat$FieldType, int i, Object obj) {
        int iR = C0980q.R(i);
        if (wireFormat$FieldType == WireFormat$FieldType.d) {
            iR *= 2;
        }
        return f(wireFormat$FieldType, obj) + iR;
    }

    public static int f(WireFormat$FieldType wireFormat$FieldType, Object obj) {
        int serializedSize;
        int iS;
        switch (wireFormat$FieldType.ordinal()) {
            case 0:
                ((Double) obj).getClass();
                Logger logger = C0980q.g;
                return 8;
            case 1:
                ((Float) obj).getClass();
                Logger logger2 = C0980q.g;
                return 4;
            case 2:
                return C0980q.T(((Long) obj).longValue());
            case 3:
                return C0980q.T(((Long) obj).longValue());
            case 4:
                return C0980q.O(((Integer) obj).intValue());
            case 5:
                ((Long) obj).getClass();
                Logger logger3 = C0980q.g;
                return 8;
            case 6:
                ((Integer) obj).getClass();
                Logger logger4 = C0980q.g;
                return 4;
            case 7:
                ((Boolean) obj).getClass();
                Logger logger5 = C0980q.g;
                return 1;
            case 8:
                return obj instanceof ByteString ? C0980q.L((ByteString) obj) : C0980q.Q((String) obj);
            case 9:
                Logger logger6 = C0980q.g;
                return ((X1) obj).getSerializedSize();
            case 10:
                Logger logger7 = C0980q.g;
                serializedSize = ((X1) obj).getSerializedSize();
                iS = C0980q.S(serializedSize);
                break;
            case 11:
                if (!(obj instanceof ByteString)) {
                    Logger logger8 = C0980q.g;
                    serializedSize = ((byte[]) obj).length;
                    iS = C0980q.S(serializedSize);
                    break;
                } else {
                    return C0980q.L((ByteString) obj);
                }
            case 12:
                return C0980q.S(((Integer) obj).intValue());
            case 13:
                return obj instanceof InterfaceC0974o1 ? C0980q.O(((InterfaceC0974o1) obj).getNumber()) : C0980q.O(((Integer) obj).intValue());
            case 14:
                ((Integer) obj).getClass();
                Logger logger9 = C0980q.g;
                return 4;
            case 15:
                ((Long) obj).getClass();
                Logger logger10 = C0980q.g;
                return 8;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                return C0980q.S((iIntValue >> 31) ^ (iIntValue << 1));
            case 17:
                long jLongValue = ((Long) obj).longValue();
                return C0980q.T((jLongValue >> 63) ^ (jLongValue << 1));
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
        return iS + serializedSize;
    }

    public static int g(X0 x02, Object obj) {
        D0 d02 = (D0) x02;
        WireFormat$FieldType wireFormat$FieldTypeH = d02.h();
        int i = d02.b.e;
        if (!d02.isRepeated()) {
            return e(wireFormat$FieldTypeH, i, obj);
        }
        List list = (List) obj;
        int iE = 0;
        if (!d02.isPacked()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                iE += e(wireFormat$FieldTypeH, i, it.next());
            }
            return iE;
        }
        if (list.isEmpty()) {
            return 0;
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            iE += f(wireFormat$FieldTypeH, it2.next());
        }
        return C0980q.S(iE) + C0980q.R(i) + iE;
    }

    public static int j(Map.Entry entry) {
        int iR = C0980q.R(1);
        X0 x02 = (X0) entry.getKey();
        Object value = entry.getValue();
        D0 d02 = (D0) x02;
        if (d02.h().f2887a != WireFormat$JavaType.MESSAGE || d02.isRepeated() || d02.isPacked()) {
            return g(x02, value);
        }
        int i = ((D0) ((X0) entry.getKey())).b.e;
        return C0980q.P(3, (X1) value) + C0980q.S(i) + C0980q.R(2) + (iR * 2);
    }

    public static boolean n(Map.Entry entry) {
        D0 d02 = (D0) ((X0) entry.getKey());
        if (d02.h().f2887a != WireFormat$JavaType.MESSAGE) {
            return true;
        }
        if (!d02.isRepeated()) {
            Object value = entry.getValue();
            if (value instanceof Y1) {
                return ((Y1) value).isInitialized();
            }
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        for (Object obj : (List) entry.getValue()) {
            if (!(obj instanceof Y1)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            if (!((Y1) obj).isInitialized()) {
                return false;
            }
        }
        return true;
    }

    public static boolean o(WireFormat$FieldType wireFormat$FieldType, Object obj) {
        Charset charset = AbstractC0989s1.f2940a;
        obj.getClass();
        switch (wireFormat$FieldType.f2887a) {
            case BYTE_STRING:
                if ((obj instanceof ByteString) || (obj instanceof byte[])) {
                }
                break;
            case ENUM:
                if ((obj instanceof Integer) || (obj instanceof InterfaceC0974o1)) {
                }
                break;
            case MESSAGE:
                if ((obj instanceof X1) || (obj instanceof AbstractC1001v1)) {
                }
                break;
        }
        return false;
    }

    public static void t(X0 x02, Object obj) {
        D0 d02 = (D0) x02;
        if (!o(d02.h(), obj)) {
            throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(d02.b.e), d02.h().f2887a, obj.getClass().getName()));
        }
    }

    public static void u(C0980q c0980q, WireFormat$FieldType wireFormat$FieldType, int i, Object obj) throws CodedOutputStream$OutOfSpaceException {
        if (wireFormat$FieldType == WireFormat$FieldType.d) {
            c0980q.c0(i, (X1) obj);
        } else {
            c0980q.k0(i, wireFormat$FieldType.b);
            v(c0980q, wireFormat$FieldType, obj);
        }
    }

    public static void v(C0980q c0980q, WireFormat$FieldType wireFormat$FieldType, Object obj) throws CodedOutputStream$OutOfSpaceException {
        switch (wireFormat$FieldType.ordinal()) {
            case 0:
                double dDoubleValue = ((Double) obj).doubleValue();
                c0980q.getClass();
                c0980q.b0(Double.doubleToRawLongBits(dDoubleValue));
                break;
            case 1:
                float fFloatValue = ((Float) obj).floatValue();
                c0980q.getClass();
                c0980q.Z(Float.floatToRawIntBits(fFloatValue));
                break;
            case 2:
                c0980q.n0(((Long) obj).longValue());
                break;
            case 3:
                c0980q.n0(((Long) obj).longValue());
                break;
            case 4:
                c0980q.e0(((Integer) obj).intValue());
                break;
            case 5:
                c0980q.b0(((Long) obj).longValue());
                break;
            case 6:
                c0980q.Z(((Integer) obj).intValue());
                break;
            case 7:
                c0980q.U(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
                break;
            case 8:
                if (!(obj instanceof ByteString)) {
                    c0980q.j0((String) obj);
                    break;
                } else {
                    ByteString byteString = (ByteString) obj;
                    c0980q.getClass();
                    c0980q.l0(byteString.size());
                    byteString.r(c0980q);
                    break;
                }
            case 9:
                c0980q.getClass();
                ((X1) obj).c(c0980q);
                break;
            case 10:
                c0980q.g0((X1) obj);
                break;
            case 11:
                if (!(obj instanceof ByteString)) {
                    byte[] bArr = (byte[]) obj;
                    c0980q.getClass();
                    int length = bArr.length;
                    c0980q.l0(length);
                    c0980q.V(bArr, 0, length);
                    break;
                } else {
                    ByteString byteString2 = (ByteString) obj;
                    c0980q.getClass();
                    c0980q.l0(byteString2.size());
                    byteString2.r(c0980q);
                    break;
                }
            case 12:
                c0980q.l0(((Integer) obj).intValue());
                break;
            case 13:
                if (!(obj instanceof InterfaceC0974o1)) {
                    c0980q.e0(((Integer) obj).intValue());
                    break;
                } else {
                    c0980q.e0(((InterfaceC0974o1) obj).getNumber());
                    break;
                }
            case 14:
                c0980q.Z(((Integer) obj).intValue());
                break;
            case 15:
                c0980q.b0(((Long) obj).longValue());
                break;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                c0980q.l0((iIntValue >> 31) ^ (iIntValue << 1));
                break;
            case 17:
                long jLongValue = ((Long) obj).longValue();
                c0980q.n0((jLongValue >> 63) ^ (jLongValue << 1));
                break;
        }
    }

    public static void w(X0 x02, Object obj, C0980q c0980q) throws CodedOutputStream$OutOfSpaceException {
        D0 d02 = (D0) x02;
        WireFormat$FieldType wireFormat$FieldTypeH = d02.h();
        int i = d02.b.e;
        if (!d02.isRepeated()) {
            if (obj instanceof AbstractC1001v1) {
                u(c0980q, wireFormat$FieldTypeH, i, ((AbstractC1001v1) obj).a());
                return;
            } else {
                u(c0980q, wireFormat$FieldTypeH, i, obj);
                return;
            }
        }
        List list = (List) obj;
        if (!d02.isPacked()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                u(c0980q, wireFormat$FieldTypeH, i, it.next());
            }
        } else {
            if (list.isEmpty()) {
                return;
            }
            c0980q.k0(i, 2);
            Iterator it2 = list.iterator();
            int iF = 0;
            while (it2.hasNext()) {
                iF += f(wireFormat$FieldTypeH, it2.next());
            }
            c0980q.l0(iF);
            Iterator it3 = list.iterator();
            while (it3.hasNext()) {
                v(c0980q, wireFormat$FieldTypeH, it3.next());
            }
        }
    }

    public static void x(Map.Entry entry, C0980q c0980q) throws CodedOutputStream$OutOfSpaceException {
        X0 x02 = (X0) entry.getKey();
        D0 d02 = (D0) x02;
        if (d02.h().f2887a != WireFormat$JavaType.MESSAGE || d02.isRepeated() || d02.isPacked()) {
            w(x02, entry.getValue(), c0980q);
        } else {
            c0980q.h0(((D0) ((X0) entry.getKey())).b.e, (X1) entry.getValue());
        }
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Y0 clone() {
        C0990s2 c0990s2;
        Y0 y02 = new Y0();
        int i = 0;
        while (true) {
            c0990s2 = this.f2903a;
            if (i >= c0990s2.b.size()) {
                break;
            }
            Map.Entry entryD = c0990s2.d(i);
            y02.s((X0) entryD.getKey(), entryD.getValue());
            i++;
        }
        for (Map.Entry entry : c0990s2.e()) {
            y02.s((X0) entry.getKey(), entry.getValue());
        }
        y02.c = this.c;
        return y02;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Y0) {
            return this.f2903a.equals(((Y0) obj).f2903a);
        }
        return false;
    }

    public final Map h() {
        boolean z10 = this.c;
        C0990s2 c0990s2 = this.f2903a;
        if (!z10) {
            return c0990s2.d ? c0990s2 : Collections.unmodifiableMap(c0990s2);
        }
        C0990s2 c0990s2B = b(c0990s2, false);
        if (c0990s2.d) {
            c0990s2B.g();
        }
        return c0990s2B;
    }

    public final int hashCode() {
        return this.f2903a.hashCode();
    }

    public final int i() {
        C0990s2 c0990s2;
        int i = 0;
        int iJ = 0;
        while (true) {
            c0990s2 = this.f2903a;
            if (i >= c0990s2.b.size()) {
                break;
            }
            iJ += j(c0990s2.d(i));
            i++;
        }
        Iterator it = c0990s2.e().iterator();
        while (it.hasNext()) {
            iJ += j((Map.Entry) it.next());
        }
        return iJ;
    }

    public final int k() {
        C0990s2 c0990s2;
        int i = 0;
        int iG = 0;
        while (true) {
            c0990s2 = this.f2903a;
            if (i >= c0990s2.b.size()) {
                break;
            }
            Map.Entry entryD = c0990s2.d(i);
            iG += g((X0) entryD.getKey(), entryD.getValue());
            i++;
        }
        for (Map.Entry entry : c0990s2.e()) {
            iG += g((X0) entry.getKey(), entry.getValue());
        }
        return iG;
    }

    public final boolean l(D0 d02) {
        if (d02.isRepeated()) {
            throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        }
        return this.f2903a.get(d02) != null;
    }

    public final boolean m() {
        int i = 0;
        while (true) {
            C0990s2 c0990s2 = this.f2903a;
            if (i >= c0990s2.b.size()) {
                Iterator it = c0990s2.e().iterator();
                while (it.hasNext()) {
                    if (!n((Map.Entry) it.next())) {
                        return false;
                    }
                }
                return true;
            }
            if (!n(c0990s2.d(i))) {
                return false;
            }
            i++;
        }
    }

    public final Iterator p() {
        boolean z10 = this.c;
        C0990s2 c0990s2 = this.f2903a;
        if (!z10) {
            return ((H8.D) c0990s2.entrySet()).iterator();
        }
        Iterator it = ((H8.D) c0990s2.entrySet()).iterator();
        C0997u1 c0997u1 = new C0997u1(0);
        c0997u1.b = it;
        return c0997u1;
    }

    public final void q() {
        if (this.b) {
            return;
        }
        int i = 0;
        while (true) {
            C0990s2 c0990s2 = this.f2903a;
            if (i >= c0990s2.b.size()) {
                c0990s2.g();
                this.b = true;
                return;
            }
            Map.Entry entryD = c0990s2.d(i);
            if (entryD.getValue() instanceof GeneratedMessageLite) {
                GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) entryD.getValue();
                generatedMessageLite.getClass();
                C0963l2 c0963l2 = C0963l2.c;
                c0963l2.getClass();
                c0963l2.a(generatedMessageLite.getClass()).makeImmutable(generatedMessageLite);
                generatedMessageLite.w();
            }
            i++;
        }
    }

    public final void r(Map.Entry entry) {
        X0 x02 = (X0) entry.getKey();
        Object value = entry.getValue();
        D0 d02 = (D0) x02;
        boolean zIsRepeated = d02.isRepeated();
        C0990s2 c0990s2 = this.f2903a;
        if (zIsRepeated) {
            Object arrayList = c0990s2.get(d02);
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) arrayList).add(d(it.next()));
            }
            c0990s2.put(d02, arrayList);
            return;
        }
        if (d02.h().f2887a != WireFormat$JavaType.MESSAGE) {
            c0990s2.put(d02, d(value));
            return;
        }
        Object obj = c0990s2.get(d02);
        if (obj == null) {
            c0990s2.put(d02, d(value));
        } else {
            c0990s2.put(d02, ((AbstractC0916a) ((X1) obj).toBuilder()).t((AbstractC0924c) ((X1) value)).k());
        }
    }

    public final void s(X0 x02, Object obj) {
        D0 d02 = (D0) x02;
        if (!d02.isRepeated()) {
            t(d02, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                t(d02, it.next());
            }
            obj = arrayList;
        }
        this.f2903a.put(d02, obj);
    }

    public Y0(C0990s2 c0990s2) {
        this.f2903a = c0990s2;
        q();
    }
}
