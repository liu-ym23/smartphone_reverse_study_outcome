package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.q.a;
import androidx.datastore.preferences.protobuf.u;
import androidx.datastore.preferences.protobuf.v;
import androidx.datastore.preferences.protobuf.z0;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class q<T extends a<T>> {

    /* renamed from: d, reason: collision with root package name */
    public static final q f1875d = new q(0);

    /* renamed from: a, reason: collision with root package name */
    public final y0 f1876a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1877b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f1878c;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface a<T extends a<T>> extends Comparable<T> {
        WireFormat$JavaType f();
    }

    public q() {
        this.f1876a = new y0(16);
    }

    public static int b(WireFormat$FieldType wireFormat$FieldType, int i10, Object obj) {
        int size;
        int iU;
        int iS = CodedOutputStream.s(i10);
        if (wireFormat$FieldType == WireFormat$FieldType.f1767d) {
            iS *= 2;
        }
        int iV = 1;
        switch (wireFormat$FieldType.ordinal()) {
            case 0:
                ((Double) obj).getClass();
                Logger logger = CodedOutputStream.f1721c;
                iV = 8;
                return iV + iS;
            case 1:
                ((Float) obj).getClass();
                Logger logger2 = CodedOutputStream.f1721c;
                iV = 4;
                return iV + iS;
            case 2:
                iV = CodedOutputStream.v(((Long) obj).longValue());
                return iV + iS;
            case 3:
                iV = CodedOutputStream.v(((Long) obj).longValue());
                return iV + iS;
            case 4:
                iV = CodedOutputStream.p(((Integer) obj).intValue());
                return iV + iS;
            case 5:
                ((Long) obj).getClass();
                Logger logger3 = CodedOutputStream.f1721c;
                iV = 8;
                return iV + iS;
            case 6:
                ((Integer) obj).getClass();
                Logger logger4 = CodedOutputStream.f1721c;
                iV = 4;
                return iV + iS;
            case 7:
                ((Boolean) obj).getClass();
                Logger logger5 = CodedOutputStream.f1721c;
                return iV + iS;
            case 8:
                if (!(obj instanceof ByteString)) {
                    iV = CodedOutputStream.r((String) obj);
                    return iV + iS;
                }
                Logger logger6 = CodedOutputStream.f1721c;
                size = ((ByteString) obj).size();
                iU = CodedOutputStream.u(size);
                iV = iU + size;
                return iV + iS;
            case 9:
                Logger logger7 = CodedOutputStream.f1721c;
                iV = ((i0) obj).c();
                return iV + iS;
            case 10:
                if (obj instanceof v) {
                    iV = CodedOutputStream.q((v) obj);
                    return iV + iS;
                }
                Logger logger8 = CodedOutputStream.f1721c;
                size = ((i0) obj).c();
                iU = CodedOutputStream.u(size);
                iV = iU + size;
                return iV + iS;
            case 11:
                if (obj instanceof ByteString) {
                    Logger logger9 = CodedOutputStream.f1721c;
                    size = ((ByteString) obj).size();
                    iU = CodedOutputStream.u(size);
                } else {
                    Logger logger10 = CodedOutputStream.f1721c;
                    size = ((byte[]) obj).length;
                    iU = CodedOutputStream.u(size);
                }
                iV = iU + size;
                return iV + iS;
            case 12:
                iV = CodedOutputStream.u(((Integer) obj).intValue());
                return iV + iS;
            case 13:
                iV = obj instanceof u.a ? CodedOutputStream.p(((u.a) obj).a()) : CodedOutputStream.p(((Integer) obj).intValue());
                return iV + iS;
            case 14:
                ((Integer) obj).getClass();
                Logger logger11 = CodedOutputStream.f1721c;
                iV = 4;
                return iV + iS;
            case 15:
                ((Long) obj).getClass();
                Logger logger12 = CodedOutputStream.f1721c;
                iV = 8;
                return iV + iS;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                iV = CodedOutputStream.u((iIntValue >> 31) ^ (iIntValue << 1));
                return iV + iS;
            case 17:
                long jLongValue = ((Long) obj).longValue();
                iV = CodedOutputStream.v((jLongValue >> 63) ^ (jLongValue << 1));
                return iV + iS;
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int c(a<?> aVar, Object obj) {
        aVar.getClass();
        return b(null, 0, obj);
    }

    public static int d(Map.Entry entry) {
        CodedOutputStream.s(1);
        a aVar = (a) entry.getKey();
        entry.getValue();
        aVar.f();
        throw null;
    }

    public static <T extends a<T>> boolean f(Map.Entry<T, Object> entry) {
        entry.getKey().f();
        throw null;
    }

    public static void j(CodedOutputStream codedOutputStream, WireFormat$FieldType wireFormat$FieldType, int i10, Object obj) {
        if (wireFormat$FieldType == WireFormat$FieldType.f1767d) {
            codedOutputStream.O(i10, 3);
            ((i0) obj).f(codedOutputStream);
            codedOutputStream.O(i10, 4);
        }
        codedOutputStream.O(i10, wireFormat$FieldType.f1770b);
        switch (wireFormat$FieldType.ordinal()) {
            case 0:
                codedOutputStream.F(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                break;
            case 1:
                codedOutputStream.D(Float.floatToRawIntBits(((Float) obj).floatValue()));
                break;
            case 2:
                codedOutputStream.S(((Long) obj).longValue());
                break;
            case 3:
                codedOutputStream.S(((Long) obj).longValue());
                break;
            case 4:
                codedOutputStream.H(((Integer) obj).intValue());
                break;
            case 5:
                codedOutputStream.F(((Long) obj).longValue());
                break;
            case 6:
                codedOutputStream.D(((Integer) obj).intValue());
                break;
            case 7:
                codedOutputStream.x(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
                break;
            case 8:
                if (!(obj instanceof ByteString)) {
                    codedOutputStream.N((String) obj);
                    break;
                } else {
                    codedOutputStream.B((ByteString) obj);
                    break;
                }
            case 9:
                ((i0) obj).f(codedOutputStream);
                break;
            case 10:
                codedOutputStream.J((i0) obj);
                break;
            case 11:
                if (!(obj instanceof ByteString)) {
                    byte[] bArr = (byte[]) obj;
                    codedOutputStream.z(bArr, bArr.length);
                    break;
                } else {
                    codedOutputStream.B((ByteString) obj);
                    break;
                }
            case 12:
                codedOutputStream.Q(((Integer) obj).intValue());
                break;
            case 13:
                if (!(obj instanceof u.a)) {
                    codedOutputStream.H(((Integer) obj).intValue());
                    break;
                } else {
                    codedOutputStream.H(((u.a) obj).a());
                    break;
                }
            case 14:
                codedOutputStream.D(((Integer) obj).intValue());
                break;
            case 15:
                codedOutputStream.F(((Long) obj).longValue());
                break;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                codedOutputStream.Q((iIntValue >> 31) ^ (iIntValue << 1));
                break;
            case 17:
                long jLongValue = ((Long) obj).longValue();
                codedOutputStream.S((jLongValue >> 63) ^ (jLongValue << 1));
                break;
        }
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final q<T> clone() {
        y0 y0Var;
        q<T> qVar = new q<>();
        int i10 = 0;
        while (true) {
            y0Var = this.f1876a;
            if (i10 >= y0Var.f1908b.size()) {
                break;
            }
            Map.Entry<Object, Object> entryC = y0Var.c(i10);
            qVar.i((a) entryC.getKey(), entryC.getValue());
            i10++;
        }
        for (Map.Entry<Object, Object> entry : y0Var.e()) {
            qVar.i((a) entry.getKey(), entry.getValue());
        }
        qVar.f1878c = this.f1878c;
        return qVar;
    }

    public final boolean e() {
        y0 y0Var = this.f1876a;
        if (y0Var.f1908b.size() > 0) {
            f(y0Var.c(0));
            throw null;
        }
        Iterator<Map.Entry<Object, Object>> it = y0Var.e().iterator();
        if (!it.hasNext()) {
            return true;
        }
        f(it.next());
        throw null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof q) {
            return this.f1876a.equals(((q) obj).f1876a);
        }
        return false;
    }

    public final Iterator<Map.Entry<T, Object>> g() {
        boolean z = this.f1878c;
        y0 y0Var = this.f1876a;
        if (!z) {
            return ((z0.d) y0Var.entrySet()).iterator();
        }
        Iterator<Map.Entry<K, Object>> it = ((z0.d) y0Var.entrySet()).iterator();
        v.b bVar = new v.b();
        bVar.f1895a = it;
        return bVar;
    }

    public final void h(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof v) {
            ((v) value).a(null);
        }
        key.getClass();
        key.f();
        throw null;
    }

    public final int hashCode() {
        return this.f1876a.hashCode();
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i(T r4, java.lang.Object r5) {
        /*
            r3 = this;
            r4.getClass()
            java.nio.charset.Charset r0 = androidx.datastore.preferences.protobuf.u.f1888a
            r5.getClass()
            r0 = 0
            androidx.datastore.preferences.protobuf.WireFormat$JavaType r0 = r0.f1769a
            int r0 = r0.ordinal()
            r1 = 1
            r2 = 0
            switch(r0) {
                case 0: goto L40;
                case 1: goto L3d;
                case 2: goto L3a;
                case 3: goto L37;
                case 4: goto L34;
                case 5: goto L31;
                case 6: goto L28;
                case 7: goto L1f;
                case 8: goto L15;
                default: goto L14;
            }
        L14:
            goto L42
        L15:
            boolean r0 = r5 instanceof androidx.datastore.preferences.protobuf.i0
            if (r0 != 0) goto L1d
            boolean r0 = r5 instanceof androidx.datastore.preferences.protobuf.v
            if (r0 == 0) goto L42
        L1d:
            r2 = r1
            goto L42
        L1f:
            boolean r0 = r5 instanceof java.lang.Integer
            if (r0 != 0) goto L1d
            boolean r0 = r5 instanceof androidx.datastore.preferences.protobuf.u.a
            if (r0 == 0) goto L42
            goto L1d
        L28:
            boolean r0 = r5 instanceof androidx.datastore.preferences.protobuf.ByteString
            if (r0 != 0) goto L1d
            boolean r0 = r5 instanceof byte[]
            if (r0 == 0) goto L42
            goto L1d
        L31:
            boolean r2 = r5 instanceof java.lang.String
            goto L42
        L34:
            boolean r2 = r5 instanceof java.lang.Boolean
            goto L42
        L37:
            boolean r2 = r5 instanceof java.lang.Double
            goto L42
        L3a:
            boolean r2 = r5 instanceof java.lang.Float
            goto L42
        L3d:
            boolean r2 = r5 instanceof java.lang.Long
            goto L42
        L40:
            boolean r2 = r5 instanceof java.lang.Integer
        L42:
            if (r2 == 0) goto L50
            boolean r0 = r5 instanceof androidx.datastore.preferences.protobuf.v
            if (r0 == 0) goto L4a
            r3.f1878c = r1
        L4a:
            androidx.datastore.preferences.protobuf.y0 r3 = r3.f1876a
            r3.h(r4, r5)
            return
        L50:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r4 = "Wrong object type used with protocol message reflection."
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.q.i(androidx.datastore.preferences.protobuf.q$a, java.lang.Object):void");
    }

    public q(int i10) {
        int i11 = z0.f1906j;
        y0 y0Var = new y0(0);
        this.f1876a = y0Var;
        if (!this.f1877b) {
            y0Var.g();
            this.f1877b = true;
        }
        if (this.f1877b) {
            return;
        }
        y0Var.g();
        this.f1877b = true;
    }
}
