package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.C1355s.b;
import androidx.datastore.preferences.protobuf.C1359w;
import androidx.datastore.preferences.protobuf.C1360x;
import androidx.datastore.preferences.protobuf.K;
import androidx.datastore.preferences.protobuf.WireFormat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: androidx.datastore.preferences.protobuf.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1355s<T extends b<T>> {

    /* renamed from: d, reason: collision with root package name */
    public static final C1355s f13629d = new C1355s(true);

    /* renamed from: a, reason: collision with root package name */
    public final c0<T, Object> f13630a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f13631b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f13632c;

    /* renamed from: androidx.datastore.preferences.protobuf.s$a */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13633a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f13634b;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f13634b = iArr;
            try {
                iArr[WireFormat.FieldType.DOUBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13634b[WireFormat.FieldType.FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13634b[WireFormat.FieldType.INT64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13634b[WireFormat.FieldType.UINT64.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f13634b[WireFormat.FieldType.INT32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f13634b[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f13634b[WireFormat.FieldType.FIXED32.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f13634b[WireFormat.FieldType.BOOL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f13634b[WireFormat.FieldType.GROUP.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f13634b[WireFormat.FieldType.MESSAGE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f13634b[WireFormat.FieldType.STRING.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f13634b[WireFormat.FieldType.BYTES.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f13634b[WireFormat.FieldType.UINT32.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f13634b[WireFormat.FieldType.SFIXED32.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f13634b[WireFormat.FieldType.SFIXED64.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f13634b[WireFormat.FieldType.SINT32.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f13634b[WireFormat.FieldType.SINT64.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f13634b[WireFormat.FieldType.ENUM.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr2 = new int[WireFormat.JavaType.values().length];
            f13633a = iArr2;
            try {
                iArr2[WireFormat.JavaType.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f13633a[WireFormat.JavaType.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f13633a[WireFormat.JavaType.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f13633a[WireFormat.JavaType.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f13633a[WireFormat.JavaType.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f13633a[WireFormat.JavaType.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f13633a[WireFormat.JavaType.BYTE_STRING.ordinal()] = 7;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f13633a[WireFormat.JavaType.ENUM.ordinal()] = 8;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f13633a[WireFormat.JavaType.MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    /* renamed from: androidx.datastore.preferences.protobuf.s$b */
    public interface b<T extends b<T>> extends Comparable<T> {
        K.a d(K.a aVar, K k10);

        WireFormat.JavaType getLiteJavaType();

        WireFormat.FieldType getLiteType();

        int getNumber();

        boolean isPacked();

        boolean isRepeated();
    }

    public C1355s() {
        this.f13630a = c0.t(16);
    }

    public static void A(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, Object obj) throws IOException {
        switch (a.f13634b[fieldType.ordinal()]) {
            case 1:
                codedOutputStream.r0(((Double) obj).doubleValue());
                break;
            case 2:
                codedOutputStream.z0(((Float) obj).floatValue());
                break;
            case 3:
                codedOutputStream.H0(((Long) obj).longValue());
                break;
            case 4:
                codedOutputStream.a1(((Long) obj).longValue());
                break;
            case 5:
                codedOutputStream.F0(((Integer) obj).intValue());
                break;
            case 6:
                codedOutputStream.x0(((Long) obj).longValue());
                break;
            case 7:
                codedOutputStream.v0(((Integer) obj).intValue());
                break;
            case 8:
                codedOutputStream.l0(((Boolean) obj).booleanValue());
                break;
            case 9:
                codedOutputStream.C0((K) obj);
                break;
            case 10:
                codedOutputStream.J0((K) obj);
                break;
            case 11:
                if (!(obj instanceof ByteString)) {
                    codedOutputStream.V0((String) obj);
                    break;
                } else {
                    codedOutputStream.p0((ByteString) obj);
                    break;
                }
            case 12:
                if (!(obj instanceof ByteString)) {
                    codedOutputStream.m0((byte[]) obj);
                    break;
                } else {
                    codedOutputStream.p0((ByteString) obj);
                    break;
                }
            case 13:
                codedOutputStream.Y0(((Integer) obj).intValue());
                break;
            case 14:
                codedOutputStream.N0(((Integer) obj).intValue());
                break;
            case 15:
                codedOutputStream.P0(((Long) obj).longValue());
                break;
            case 16:
                codedOutputStream.R0(((Integer) obj).intValue());
                break;
            case 17:
                codedOutputStream.T0(((Long) obj).longValue());
                break;
            case 18:
                if (!(obj instanceof C1359w.c)) {
                    codedOutputStream.t0(((Integer) obj).intValue());
                    break;
                } else {
                    codedOutputStream.t0(((C1359w.c) obj).getNumber());
                    break;
                }
        }
    }

    public static Object c(Object obj) {
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public static int d(WireFormat.FieldType fieldType, int i10, Object obj) {
        int iV = CodedOutputStream.V(i10);
        if (fieldType == WireFormat.FieldType.GROUP) {
            iV *= 2;
        }
        return iV + e(fieldType, obj);
    }

    public static int e(WireFormat.FieldType fieldType, Object obj) {
        switch (a.f13634b[fieldType.ordinal()]) {
            case 1:
                return CodedOutputStream.j(((Double) obj).doubleValue());
            case 2:
                return CodedOutputStream.r(((Float) obj).floatValue());
            case 3:
                return CodedOutputStream.y(((Long) obj).longValue());
            case 4:
                return CodedOutputStream.Z(((Long) obj).longValue());
            case 5:
                return CodedOutputStream.w(((Integer) obj).intValue());
            case 6:
                return CodedOutputStream.p(((Long) obj).longValue());
            case 7:
                return CodedOutputStream.n(((Integer) obj).intValue());
            case 8:
                return CodedOutputStream.e(((Boolean) obj).booleanValue());
            case 9:
                return CodedOutputStream.t((K) obj);
            case 10:
                return obj instanceof C1360x ? CodedOutputStream.B((C1360x) obj) : CodedOutputStream.G((K) obj);
            case 11:
                return obj instanceof ByteString ? CodedOutputStream.h((ByteString) obj) : CodedOutputStream.U((String) obj);
            case 12:
                return obj instanceof ByteString ? CodedOutputStream.h((ByteString) obj) : CodedOutputStream.f((byte[]) obj);
            case 13:
                return CodedOutputStream.X(((Integer) obj).intValue());
            case 14:
                return CodedOutputStream.M(((Integer) obj).intValue());
            case 15:
                return CodedOutputStream.O(((Long) obj).longValue());
            case 16:
                return CodedOutputStream.Q(((Integer) obj).intValue());
            case 17:
                return CodedOutputStream.S(((Long) obj).longValue());
            case 18:
                return obj instanceof C1359w.c ? CodedOutputStream.l(((C1359w.c) obj).getNumber()) : CodedOutputStream.l(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int f(b<?> bVar, Object obj) {
        WireFormat.FieldType liteType = bVar.getLiteType();
        int number = bVar.getNumber();
        if (!bVar.isRepeated()) {
            return d(liteType, number, obj);
        }
        int iD = 0;
        if (bVar.isPacked()) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                iD += e(liteType, it.next());
            }
            return CodedOutputStream.V(number) + iD + CodedOutputStream.K(iD);
        }
        Iterator it2 = ((List) obj).iterator();
        while (it2.hasNext()) {
            iD += d(liteType, number, it2.next());
        }
        return iD;
    }

    public static <T extends b<T>> C1355s<T> h() {
        return f13629d;
    }

    public static int m(WireFormat.FieldType fieldType, boolean z10) {
        if (z10) {
            return 2;
        }
        return fieldType.getWireType();
    }

    public static <T extends b<T>> boolean q(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.getLiteJavaType() == WireFormat.JavaType.MESSAGE) {
            if (key.isRepeated()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (!((K) it.next()).isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (!(value instanceof K)) {
                    if (value instanceof C1360x) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
                if (!((K) value).isInitialized()) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean r(WireFormat.FieldType fieldType, Object obj) {
        C1359w.a(obj);
        switch (a.f13633a[fieldType.getJavaType().ordinal()]) {
            case 7:
                if ((obj instanceof ByteString) || (obj instanceof byte[])) {
                }
                break;
            case 8:
                if ((obj instanceof Integer) || (obj instanceof C1359w.c)) {
                }
                break;
            case 9:
                if ((obj instanceof K) || (obj instanceof C1360x)) {
                }
                break;
        }
        return false;
    }

    public static <T extends b<T>> C1355s<T> w() {
        return new C1355s<>();
    }

    public static void z(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, int i10, Object obj) throws IOException {
        if (fieldType == WireFormat.FieldType.GROUP) {
            codedOutputStream.A0(i10, (K) obj);
        } else {
            codedOutputStream.W0(i10, m(fieldType, false));
            A(codedOutputStream, fieldType, obj);
        }
    }

    public void a(T t10, Object obj) {
        List arrayList;
        if (!t10.isRepeated()) {
            throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        }
        y(t10.getLiteType(), obj);
        Object objI = i(t10);
        if (objI == null) {
            arrayList = new ArrayList();
            this.f13630a.put(t10, arrayList);
        } else {
            arrayList = (List) objI;
        }
        arrayList.add(obj);
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C1355s<T> clone() {
        C1355s<T> c1355sW = w();
        for (int i10 = 0; i10 < this.f13630a.n(); i10++) {
            Map.Entry<K, Object> entryM = this.f13630a.m(i10);
            c1355sW.x((b) entryM.getKey(), entryM.getValue());
        }
        Iterator it = this.f13630a.p().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            c1355sW.x((b) entry.getKey(), entry.getValue());
        }
        c1355sW.f13632c = this.f13632c;
        return c1355sW;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C1355s) {
            return this.f13630a.equals(((C1355s) obj).f13630a);
        }
        return false;
    }

    public Iterator<Map.Entry<T, Object>> g() {
        return this.f13632c ? new C1360x.c(this.f13630a.j().iterator()) : this.f13630a.j().iterator();
    }

    public int hashCode() {
        return this.f13630a.hashCode();
    }

    public Object i(T t10) {
        Object obj = this.f13630a.get(t10);
        return obj instanceof C1360x ? ((C1360x) obj).f() : obj;
    }

    public int j() {
        int iK = 0;
        for (int i10 = 0; i10 < this.f13630a.n(); i10++) {
            iK += k(this.f13630a.m(i10));
        }
        Iterator it = this.f13630a.p().iterator();
        while (it.hasNext()) {
            iK += k((Map.Entry) it.next());
        }
        return iK;
    }

    public final int k(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        return (key.getLiteJavaType() != WireFormat.JavaType.MESSAGE || key.isRepeated() || key.isPacked()) ? f(key, value) : value instanceof C1360x ? CodedOutputStream.z(entry.getKey().getNumber(), (C1360x) value) : CodedOutputStream.D(entry.getKey().getNumber(), (K) value);
    }

    public int l() {
        int iF = 0;
        for (int i10 = 0; i10 < this.f13630a.n(); i10++) {
            Map.Entry<K, Object> entryM = this.f13630a.m(i10);
            iF += f((b) entryM.getKey(), entryM.getValue());
        }
        Iterator it = this.f13630a.p().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            iF += f((b) entry.getKey(), entry.getValue());
        }
        return iF;
    }

    public boolean n() {
        return this.f13630a.isEmpty();
    }

    public boolean o() {
        return this.f13631b;
    }

    public boolean p() {
        for (int i10 = 0; i10 < this.f13630a.n(); i10++) {
            if (!q(this.f13630a.m(i10))) {
                return false;
            }
        }
        Iterator it = this.f13630a.p().iterator();
        while (it.hasNext()) {
            if (!q((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public Iterator<Map.Entry<T, Object>> s() {
        return this.f13632c ? new C1360x.c(this.f13630a.entrySet().iterator()) : this.f13630a.entrySet().iterator();
    }

    public void t() {
        if (this.f13631b) {
            return;
        }
        this.f13630a.s();
        this.f13631b = true;
    }

    public void u(C1355s<T> c1355s) {
        for (int i10 = 0; i10 < c1355s.f13630a.n(); i10++) {
            v(c1355s.f13630a.m(i10));
        }
        Iterator it = c1355s.f13630a.p().iterator();
        while (it.hasNext()) {
            v((Map.Entry) it.next());
        }
    }

    public final void v(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof C1360x) {
            value = ((C1360x) value).f();
        }
        if (key.isRepeated()) {
            Object objI = i(key);
            if (objI == null) {
                objI = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) objI).add(c(it.next()));
            }
            this.f13630a.put(key, objI);
            return;
        }
        if (key.getLiteJavaType() != WireFormat.JavaType.MESSAGE) {
            this.f13630a.put(key, c(value));
            return;
        }
        Object objI2 = i(key);
        if (objI2 == null) {
            this.f13630a.put(key, c(value));
        } else {
            this.f13630a.put(key, key.d(((K) objI2).toBuilder(), (K) value).build());
        }
    }

    public void x(T t10, Object obj) {
        if (!t10.isRepeated()) {
            y(t10.getLiteType(), obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                y(t10.getLiteType(), it.next());
            }
            obj = arrayList;
        }
        if (obj instanceof C1360x) {
            this.f13632c = true;
        }
        this.f13630a.put(t10, obj);
    }

    public final void y(WireFormat.FieldType fieldType, Object obj) {
        if (!r(fieldType, obj)) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    public C1355s(boolean z10) {
        this(c0.t(0));
        t();
    }

    public C1355s(c0<T, Object> c0Var) {
        this.f13630a = c0Var;
        t();
    }
}
