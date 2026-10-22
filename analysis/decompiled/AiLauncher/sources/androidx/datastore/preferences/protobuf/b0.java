package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.C1355s;
import androidx.datastore.preferences.protobuf.C1359w;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class b0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Class<?> f13504a = B();

    /* renamed from: b, reason: collision with root package name */
    public static final f0<?, ?> f13505b = C(false);

    /* renamed from: c, reason: collision with root package name */
    public static final f0<?, ?> f13506c = C(true);

    /* renamed from: d, reason: collision with root package name */
    public static final f0<?, ?> f13507d = new h0();

    public static <UT, UB> UB A(int i10, List<Integer> list, C1359w.e eVar, UB ub2, f0<UT, UB> f0Var) {
        if (eVar == null) {
            return ub2;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                if (!eVar.isInRange(iIntValue)) {
                    ub2 = (UB) L(i10, iIntValue, ub2, f0Var);
                    it.remove();
                }
            }
            return ub2;
        }
        int size = list.size();
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            Integer num = list.get(i12);
            int iIntValue2 = num.intValue();
            if (eVar.isInRange(iIntValue2)) {
                if (i12 != i11) {
                    list.set(i11, num);
                }
                i11++;
            } else {
                ub2 = (UB) L(i10, iIntValue2, ub2, f0Var);
            }
        }
        if (i11 != size) {
            list.subList(i11, size).clear();
        }
        return ub2;
    }

    public static Class<?> B() {
        try {
            return Class.forName("androidx.datastore.preferences.protobuf.GeneratedMessageV3");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static f0<?, ?> C(boolean z10) {
        try {
            Class<?> clsD = D();
            if (clsD == null) {
                return null;
            }
            return (f0) clsD.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z10));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Class<?> D() {
        try {
            return Class.forName("androidx.datastore.preferences.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static <T, FT extends C1355s.b<FT>> void E(AbstractC1352o<FT> abstractC1352o, T t10, T t11) {
        C1355s<T> c1355sC = abstractC1352o.c(t11);
        if (c1355sC.n()) {
            return;
        }
        abstractC1352o.d(t10).u(c1355sC);
    }

    public static <T> void F(F f10, T t10, T t11, long j10) {
        j0.O(t10, j10, f10.mergeFrom(j0.A(t10, j10), j0.A(t11, j10)));
    }

    public static <T, UT, UB> void G(f0<UT, UB> f0Var, T t10, T t11) {
        f0Var.p(t10, f0Var.k(f0Var.g(t10), f0Var.g(t11)));
    }

    public static f0<?, ?> H() {
        return f13505b;
    }

    public static f0<?, ?> I() {
        return f13506c;
    }

    public static void J(Class<?> cls) {
        Class<?> cls2;
        if (!GeneratedMessageLite.class.isAssignableFrom(cls) && (cls2 = f13504a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static boolean K(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static <UT, UB> UB L(int i10, int i11, UB ub2, f0<UT, UB> f0Var) {
        if (ub2 == null) {
            ub2 = f0Var.n();
        }
        f0Var.e(ub2, i10, i11);
        return ub2;
    }

    public static f0<?, ?> M() {
        return f13507d;
    }

    public static void N(int i10, List<Boolean> list, Writer writer, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeBoolList(i10, list, z10);
    }

    public static void O(int i10, List<ByteString> list, Writer writer) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeBytesList(i10, list);
    }

    public static void P(int i10, List<Double> list, Writer writer, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeDoubleList(i10, list, z10);
    }

    public static void Q(int i10, List<Integer> list, Writer writer, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeEnumList(i10, list, z10);
    }

    public static void R(int i10, List<Integer> list, Writer writer, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeFixed32List(i10, list, z10);
    }

    public static void S(int i10, List<Long> list, Writer writer, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeFixed64List(i10, list, z10);
    }

    public static void T(int i10, List<Float> list, Writer writer, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeFloatList(i10, list, z10);
    }

    public static void U(int i10, List<?> list, Writer writer, Z z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.a(i10, list, z10);
    }

    public static void V(int i10, List<Integer> list, Writer writer, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeInt32List(i10, list, z10);
    }

    public static void W(int i10, List<Long> list, Writer writer, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeInt64List(i10, list, z10);
    }

    public static void X(int i10, List<?> list, Writer writer, Z z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.f(i10, list, z10);
    }

    public static void Y(int i10, List<Integer> list, Writer writer, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeSFixed32List(i10, list, z10);
    }

    public static void Z(int i10, List<Long> list, Writer writer, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeSFixed64List(i10, list, z10);
    }

    public static int a(int i10, List<?> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z10 ? CodedOutputStream.V(i10) + CodedOutputStream.C(size) : size * CodedOutputStream.d(i10, true);
    }

    public static void a0(int i10, List<Integer> list, Writer writer, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeSInt32List(i10, list, z10);
    }

    public static int b(List<?> list) {
        return list.size();
    }

    public static void b0(int i10, List<Long> list, Writer writer, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeSInt64List(i10, list, z10);
    }

    public static int c(int i10, List<ByteString> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iV = size * CodedOutputStream.V(i10);
        for (int i11 = 0; i11 < list.size(); i11++) {
            iV += CodedOutputStream.h(list.get(i11));
        }
        return iV;
    }

    public static void c0(int i10, List<String> list, Writer writer) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeStringList(i10, list);
    }

    public static int d(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iE = e(list);
        return z10 ? CodedOutputStream.V(i10) + CodedOutputStream.C(iE) : iE + (size * CodedOutputStream.V(i10));
    }

    public static void d0(int i10, List<Integer> list, Writer writer, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeUInt32List(i10, list, z10);
    }

    public static int e(List<Integer> list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof C1358v)) {
            int iL = 0;
            while (i10 < size) {
                iL += CodedOutputStream.l(list.get(i10).intValue());
                i10++;
            }
            return iL;
        }
        C1358v c1358v = (C1358v) list;
        int iL2 = 0;
        while (i10 < size) {
            iL2 += CodedOutputStream.l(c1358v.getInt(i10));
            i10++;
        }
        return iL2;
    }

    public static void e0(int i10, List<Long> list, Writer writer, boolean z10) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeUInt64List(i10, list, z10);
    }

    public static int f(int i10, List<?> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z10 ? CodedOutputStream.V(i10) + CodedOutputStream.C(size * 4) : size * CodedOutputStream.m(i10, 0);
    }

    public static int g(List<?> list) {
        return list.size() * 4;
    }

    public static int h(int i10, List<?> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z10 ? CodedOutputStream.V(i10) + CodedOutputStream.C(size * 8) : size * CodedOutputStream.o(i10, 0L);
    }

    public static int i(List<?> list) {
        return list.size() * 8;
    }

    public static int j(int i10, List<K> list, Z z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iS = 0;
        for (int i11 = 0; i11 < size; i11++) {
            iS += CodedOutputStream.s(i10, list.get(i11), z10);
        }
        return iS;
    }

    public static int k(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iL = l(list);
        return z10 ? CodedOutputStream.V(i10) + CodedOutputStream.C(iL) : iL + (size * CodedOutputStream.V(i10));
    }

    public static int l(List<Integer> list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof C1358v)) {
            int iW = 0;
            while (i10 < size) {
                iW += CodedOutputStream.w(list.get(i10).intValue());
                i10++;
            }
            return iW;
        }
        C1358v c1358v = (C1358v) list;
        int iW2 = 0;
        while (i10 < size) {
            iW2 += CodedOutputStream.w(c1358v.getInt(i10));
            i10++;
        }
        return iW2;
    }

    public static int m(int i10, List<Long> list, boolean z10) {
        if (list.size() == 0) {
            return 0;
        }
        int iN = n(list);
        return z10 ? CodedOutputStream.V(i10) + CodedOutputStream.C(iN) : iN + (list.size() * CodedOutputStream.V(i10));
    }

    public static int n(List<Long> list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof C)) {
            int iY = 0;
            while (i10 < size) {
                iY += CodedOutputStream.y(list.get(i10).longValue());
                i10++;
            }
            return iY;
        }
        C c10 = (C) list;
        int iY2 = 0;
        while (i10 < size) {
            iY2 += CodedOutputStream.y(c10.getLong(i10));
            i10++;
        }
        return iY2;
    }

    public static int o(int i10, Object obj, Z z10) {
        return obj instanceof C1361y ? CodedOutputStream.A(i10, (C1361y) obj) : CodedOutputStream.F(i10, (K) obj, z10);
    }

    public static int p(int i10, List<?> list, Z z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iV = CodedOutputStream.V(i10) * size;
        for (int i11 = 0; i11 < size; i11++) {
            Object obj = list.get(i11);
            iV += obj instanceof C1361y ? CodedOutputStream.B((C1361y) obj) : CodedOutputStream.H((K) obj, z10);
        }
        return iV;
    }

    public static int q(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iR = r(list);
        return z10 ? CodedOutputStream.V(i10) + CodedOutputStream.C(iR) : iR + (size * CodedOutputStream.V(i10));
    }

    public static int r(List<Integer> list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof C1358v)) {
            int iQ = 0;
            while (i10 < size) {
                iQ += CodedOutputStream.Q(list.get(i10).intValue());
                i10++;
            }
            return iQ;
        }
        C1358v c1358v = (C1358v) list;
        int iQ2 = 0;
        while (i10 < size) {
            iQ2 += CodedOutputStream.Q(c1358v.getInt(i10));
            i10++;
        }
        return iQ2;
    }

    public static int s(int i10, List<Long> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iT = t(list);
        return z10 ? CodedOutputStream.V(i10) + CodedOutputStream.C(iT) : iT + (size * CodedOutputStream.V(i10));
    }

    public static int t(List<Long> list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof C)) {
            int iS = 0;
            while (i10 < size) {
                iS += CodedOutputStream.S(list.get(i10).longValue());
                i10++;
            }
            return iS;
        }
        C c10 = (C) list;
        int iS2 = 0;
        while (i10 < size) {
            iS2 += CodedOutputStream.S(c10.getLong(i10));
            i10++;
        }
        return iS2;
    }

    public static int u(int i10, List<?> list) {
        int size = list.size();
        int i11 = 0;
        if (size == 0) {
            return 0;
        }
        int iV = CodedOutputStream.V(i10) * size;
        if (!(list instanceof A)) {
            while (i11 < size) {
                Object obj = list.get(i11);
                iV += obj instanceof ByteString ? CodedOutputStream.h((ByteString) obj) : CodedOutputStream.U((String) obj);
                i11++;
            }
            return iV;
        }
        A a10 = (A) list;
        while (i11 < size) {
            Object raw = a10.getRaw(i11);
            iV += raw instanceof ByteString ? CodedOutputStream.h((ByteString) raw) : CodedOutputStream.U((String) raw);
            i11++;
        }
        return iV;
    }

    public static int v(int i10, List<Integer> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iW = w(list);
        return z10 ? CodedOutputStream.V(i10) + CodedOutputStream.C(iW) : iW + (size * CodedOutputStream.V(i10));
    }

    public static int w(List<Integer> list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof C1358v)) {
            int iX = 0;
            while (i10 < size) {
                iX += CodedOutputStream.X(list.get(i10).intValue());
                i10++;
            }
            return iX;
        }
        C1358v c1358v = (C1358v) list;
        int iX2 = 0;
        while (i10 < size) {
            iX2 += CodedOutputStream.X(c1358v.getInt(i10));
            i10++;
        }
        return iX2;
    }

    public static int x(int i10, List<Long> list, boolean z10) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iY = y(list);
        return z10 ? CodedOutputStream.V(i10) + CodedOutputStream.C(iY) : iY + (size * CodedOutputStream.V(i10));
    }

    public static int y(List<Long> list) {
        int size = list.size();
        int i10 = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof C)) {
            int iZ = 0;
            while (i10 < size) {
                iZ += CodedOutputStream.Z(list.get(i10).longValue());
                i10++;
            }
            return iZ;
        }
        C c10 = (C) list;
        int iZ2 = 0;
        while (i10 < size) {
            iZ2 += CodedOutputStream.Z(c10.getLong(i10));
            i10++;
        }
        return iZ2;
    }

    public static <UT, UB> UB z(int i10, List<Integer> list, C1359w.d<?> dVar, UB ub2, f0<UT, UB> f0Var) {
        if (dVar == null) {
            return ub2;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                if (dVar.findValueByNumber(iIntValue) == null) {
                    ub2 = (UB) L(i10, iIntValue, ub2, f0Var);
                    it.remove();
                }
            }
            return ub2;
        }
        int size = list.size();
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            Integer num = list.get(i12);
            int iIntValue2 = num.intValue();
            if (dVar.findValueByNumber(iIntValue2) != null) {
                if (i12 != i11) {
                    list.set(i11, num);
                }
                i11++;
            } else {
                ub2 = (UB) L(i10, iIntValue2, ub2, f0Var);
            }
        }
        if (i11 != size) {
            list.subList(i11, size).clear();
        }
        return ub2;
    }
}
