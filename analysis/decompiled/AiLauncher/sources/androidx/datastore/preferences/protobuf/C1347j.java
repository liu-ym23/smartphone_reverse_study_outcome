package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.E;
import androidx.datastore.preferences.protobuf.WireFormat;
import androidx.datastore.preferences.protobuf.Writer;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: androidx.datastore.preferences.protobuf.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1347j implements Writer {

    /* renamed from: a, reason: collision with root package name */
    public final CodedOutputStream f13588a;

    /* renamed from: androidx.datastore.preferences.protobuf.j$a */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13589a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f13589a = iArr;
            try {
                iArr[WireFormat.FieldType.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13589a[WireFormat.FieldType.FIXED32.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13589a[WireFormat.FieldType.INT32.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13589a[WireFormat.FieldType.SFIXED32.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f13589a[WireFormat.FieldType.SINT32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f13589a[WireFormat.FieldType.UINT32.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f13589a[WireFormat.FieldType.FIXED64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f13589a[WireFormat.FieldType.INT64.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f13589a[WireFormat.FieldType.SFIXED64.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f13589a[WireFormat.FieldType.SINT64.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f13589a[WireFormat.FieldType.UINT64.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f13589a[WireFormat.FieldType.STRING.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public C1347j(CodedOutputStream codedOutputStream) {
        CodedOutputStream codedOutputStream2 = (CodedOutputStream) C1359w.b(codedOutputStream, "output");
        this.f13588a = codedOutputStream2;
        codedOutputStream2.f13424a = this;
    }

    public static C1347j g(CodedOutputStream codedOutputStream) {
        C1347j c1347j = codedOutputStream.f13424a;
        return c1347j != null ? c1347j : new C1347j(codedOutputStream);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void a(int i10, List<?> list, Z z10) throws IOException {
        for (int i11 = 0; i11 < list.size(); i11++) {
            e(i10, list.get(i11), z10);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void b(int i10, ByteString byteString) throws IOException {
        this.f13588a.o0(i10, byteString);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void c(int i10, Object obj, Z z10) throws IOException {
        this.f13588a.I0(i10, (K) obj, z10);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public <K, V> void d(int i10, E.a<K, V> aVar, Map<K, V> map) throws IOException {
        if (this.f13588a.e0()) {
            k(i10, aVar, map);
            return;
        }
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.f13588a.W0(i10, 2);
            this.f13588a.Y0(E.b(aVar, entry.getKey(), entry.getValue()));
            E.e(this.f13588a, aVar, entry.getKey(), entry.getValue());
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void e(int i10, Object obj, Z z10) throws IOException {
        this.f13588a.B0(i10, (K) obj, z10);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void f(int i10, List<?> list, Z z10) throws IOException {
        for (int i11 = 0; i11 < list.size(); i11++) {
            c(i10, list.get(i11), z10);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public Writer.FieldOrder fieldOrder() {
        return Writer.FieldOrder.ASCENDING;
    }

    public final <V> void h(int i10, boolean z10, V v10, E.a<Boolean, V> aVar) throws IOException {
        this.f13588a.W0(i10, 2);
        this.f13588a.Y0(E.b(aVar, Boolean.valueOf(z10), v10));
        E.e(this.f13588a, aVar, Boolean.valueOf(z10), v10);
    }

    public final <V> void i(int i10, E.a<Integer, V> aVar, Map<Integer, V> map) throws IOException {
        int size = map.size();
        int[] iArr = new int[size];
        Iterator<Integer> it = map.keySet().iterator();
        int i11 = 0;
        while (it.hasNext()) {
            iArr[i11] = it.next().intValue();
            i11++;
        }
        Arrays.sort(iArr);
        for (int i12 = 0; i12 < size; i12++) {
            int i13 = iArr[i12];
            V v10 = map.get(Integer.valueOf(i13));
            this.f13588a.W0(i10, 2);
            this.f13588a.Y0(E.b(aVar, Integer.valueOf(i13), v10));
            E.e(this.f13588a, aVar, Integer.valueOf(i13), v10);
        }
    }

    public final <V> void j(int i10, E.a<Long, V> aVar, Map<Long, V> map) throws IOException {
        int size = map.size();
        long[] jArr = new long[size];
        Iterator<Long> it = map.keySet().iterator();
        int i11 = 0;
        while (it.hasNext()) {
            jArr[i11] = it.next().longValue();
            i11++;
        }
        Arrays.sort(jArr);
        for (int i12 = 0; i12 < size; i12++) {
            long j10 = jArr[i12];
            V v10 = map.get(Long.valueOf(j10));
            this.f13588a.W0(i10, 2);
            this.f13588a.Y0(E.b(aVar, Long.valueOf(j10), v10));
            E.e(this.f13588a, aVar, Long.valueOf(j10), v10);
        }
    }

    public final <K, V> void k(int i10, E.a<K, V> aVar, Map<K, V> map) throws IOException {
        switch (a.f13589a[aVar.f13441a.ordinal()]) {
            case 1:
                V v10 = map.get(Boolean.FALSE);
                if (v10 != null) {
                    h(i10, false, v10, aVar);
                }
                V v11 = map.get(Boolean.TRUE);
                if (v11 != null) {
                    h(i10, true, v11, aVar);
                    return;
                }
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                i(i10, aVar, map);
                return;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                j(i10, aVar, map);
                return;
            case 12:
                l(i10, aVar, map);
                return;
            default:
                throw new IllegalArgumentException("does not support key type: " + aVar.f13441a);
        }
    }

    public final <V> void l(int i10, E.a<String, V> aVar, Map<String, V> map) throws IOException {
        int size = map.size();
        String[] strArr = new String[size];
        Iterator<String> it = map.keySet().iterator();
        int i11 = 0;
        while (it.hasNext()) {
            strArr[i11] = it.next();
            i11++;
        }
        Arrays.sort(strArr);
        for (int i12 = 0; i12 < size; i12++) {
            String str = strArr[i12];
            V v10 = map.get(str);
            this.f13588a.W0(i10, 2);
            this.f13588a.Y0(E.b(aVar, str, v10));
            E.e(this.f13588a, aVar, str, v10);
        }
    }

    public final void m(int i10, Object obj) throws IOException {
        if (obj instanceof String) {
            this.f13588a.U0(i10, (String) obj);
        } else {
            this.f13588a.o0(i10, (ByteString) obj);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeBool(int i10, boolean z10) throws IOException {
        this.f13588a.k0(i10, z10);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeBoolList(int i10, List<Boolean> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f13588a.k0(i10, list.get(i11).booleanValue());
                i11++;
            }
            return;
        }
        this.f13588a.W0(i10, 2);
        int iE = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iE += CodedOutputStream.e(list.get(i12).booleanValue());
        }
        this.f13588a.Y0(iE);
        while (i11 < list.size()) {
            this.f13588a.l0(list.get(i11).booleanValue());
            i11++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeBytesList(int i10, List<ByteString> list) throws IOException {
        for (int i11 = 0; i11 < list.size(); i11++) {
            this.f13588a.o0(i10, list.get(i11));
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeDouble(int i10, double d10) throws IOException {
        this.f13588a.q0(i10, d10);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeDoubleList(int i10, List<Double> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f13588a.q0(i10, list.get(i11).doubleValue());
                i11++;
            }
            return;
        }
        this.f13588a.W0(i10, 2);
        int iJ = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iJ += CodedOutputStream.j(list.get(i12).doubleValue());
        }
        this.f13588a.Y0(iJ);
        while (i11 < list.size()) {
            this.f13588a.r0(list.get(i11).doubleValue());
            i11++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeEndGroup(int i10) throws IOException {
        this.f13588a.W0(i10, 4);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeEnum(int i10, int i11) throws IOException {
        this.f13588a.s0(i10, i11);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeEnumList(int i10, List<Integer> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f13588a.s0(i10, list.get(i11).intValue());
                i11++;
            }
            return;
        }
        this.f13588a.W0(i10, 2);
        int iL = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iL += CodedOutputStream.l(list.get(i12).intValue());
        }
        this.f13588a.Y0(iL);
        while (i11 < list.size()) {
            this.f13588a.t0(list.get(i11).intValue());
            i11++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeFixed32(int i10, int i11) throws IOException {
        this.f13588a.u0(i10, i11);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeFixed32List(int i10, List<Integer> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f13588a.u0(i10, list.get(i11).intValue());
                i11++;
            }
            return;
        }
        this.f13588a.W0(i10, 2);
        int iN = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iN += CodedOutputStream.n(list.get(i12).intValue());
        }
        this.f13588a.Y0(iN);
        while (i11 < list.size()) {
            this.f13588a.v0(list.get(i11).intValue());
            i11++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeFixed64(int i10, long j10) throws IOException {
        this.f13588a.w0(i10, j10);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeFixed64List(int i10, List<Long> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f13588a.w0(i10, list.get(i11).longValue());
                i11++;
            }
            return;
        }
        this.f13588a.W0(i10, 2);
        int iP = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iP += CodedOutputStream.p(list.get(i12).longValue());
        }
        this.f13588a.Y0(iP);
        while (i11 < list.size()) {
            this.f13588a.x0(list.get(i11).longValue());
            i11++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeFloat(int i10, float f10) throws IOException {
        this.f13588a.y0(i10, f10);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeFloatList(int i10, List<Float> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f13588a.y0(i10, list.get(i11).floatValue());
                i11++;
            }
            return;
        }
        this.f13588a.W0(i10, 2);
        int iR = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iR += CodedOutputStream.r(list.get(i12).floatValue());
        }
        this.f13588a.Y0(iR);
        while (i11 < list.size()) {
            this.f13588a.z0(list.get(i11).floatValue());
            i11++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeInt32(int i10, int i11) throws IOException {
        this.f13588a.E0(i10, i11);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeInt32List(int i10, List<Integer> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f13588a.E0(i10, list.get(i11).intValue());
                i11++;
            }
            return;
        }
        this.f13588a.W0(i10, 2);
        int iW = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iW += CodedOutputStream.w(list.get(i12).intValue());
        }
        this.f13588a.Y0(iW);
        while (i11 < list.size()) {
            this.f13588a.F0(list.get(i11).intValue());
            i11++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeInt64(int i10, long j10) throws IOException {
        this.f13588a.G0(i10, j10);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeInt64List(int i10, List<Long> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f13588a.G0(i10, list.get(i11).longValue());
                i11++;
            }
            return;
        }
        this.f13588a.W0(i10, 2);
        int iY = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iY += CodedOutputStream.y(list.get(i12).longValue());
        }
        this.f13588a.Y0(iY);
        while (i11 < list.size()) {
            this.f13588a.H0(list.get(i11).longValue());
            i11++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void writeMessageSetItem(int i10, Object obj) throws IOException {
        if (obj instanceof ByteString) {
            this.f13588a.L0(i10, (ByteString) obj);
        } else {
            this.f13588a.K0(i10, (K) obj);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeSFixed32(int i10, int i11) throws IOException {
        this.f13588a.M0(i10, i11);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeSFixed32List(int i10, List<Integer> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f13588a.M0(i10, list.get(i11).intValue());
                i11++;
            }
            return;
        }
        this.f13588a.W0(i10, 2);
        int iM = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iM += CodedOutputStream.M(list.get(i12).intValue());
        }
        this.f13588a.Y0(iM);
        while (i11 < list.size()) {
            this.f13588a.N0(list.get(i11).intValue());
            i11++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeSFixed64(int i10, long j10) throws IOException {
        this.f13588a.O0(i10, j10);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeSFixed64List(int i10, List<Long> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f13588a.O0(i10, list.get(i11).longValue());
                i11++;
            }
            return;
        }
        this.f13588a.W0(i10, 2);
        int iO = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iO += CodedOutputStream.O(list.get(i12).longValue());
        }
        this.f13588a.Y0(iO);
        while (i11 < list.size()) {
            this.f13588a.P0(list.get(i11).longValue());
            i11++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeSInt32(int i10, int i11) throws IOException {
        this.f13588a.Q0(i10, i11);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeSInt32List(int i10, List<Integer> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f13588a.Q0(i10, list.get(i11).intValue());
                i11++;
            }
            return;
        }
        this.f13588a.W0(i10, 2);
        int iQ = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iQ += CodedOutputStream.Q(list.get(i12).intValue());
        }
        this.f13588a.Y0(iQ);
        while (i11 < list.size()) {
            this.f13588a.R0(list.get(i11).intValue());
            i11++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeSInt64(int i10, long j10) throws IOException {
        this.f13588a.S0(i10, j10);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeSInt64List(int i10, List<Long> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f13588a.S0(i10, list.get(i11).longValue());
                i11++;
            }
            return;
        }
        this.f13588a.W0(i10, 2);
        int iS = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iS += CodedOutputStream.S(list.get(i12).longValue());
        }
        this.f13588a.Y0(iS);
        while (i11 < list.size()) {
            this.f13588a.T0(list.get(i11).longValue());
            i11++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeStartGroup(int i10) throws IOException {
        this.f13588a.W0(i10, 3);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeString(int i10, String str) throws IOException {
        this.f13588a.U0(i10, str);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeStringList(int i10, List<String> list) throws IOException {
        int i11 = 0;
        if (!(list instanceof A)) {
            while (i11 < list.size()) {
                this.f13588a.U0(i10, list.get(i11));
                i11++;
            }
        } else {
            A a10 = (A) list;
            while (i11 < list.size()) {
                m(i10, a10.getRaw(i11));
                i11++;
            }
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeUInt32(int i10, int i11) throws IOException {
        this.f13588a.X0(i10, i11);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeUInt32List(int i10, List<Integer> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f13588a.X0(i10, list.get(i11).intValue());
                i11++;
            }
            return;
        }
        this.f13588a.W0(i10, 2);
        int iX = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iX += CodedOutputStream.X(list.get(i12).intValue());
        }
        this.f13588a.Y0(iX);
        while (i11 < list.size()) {
            this.f13588a.Y0(list.get(i11).intValue());
            i11++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeUInt64(int i10, long j10) throws IOException {
        this.f13588a.Z0(i10, j10);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public void writeUInt64List(int i10, List<Long> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f13588a.Z0(i10, list.get(i11).longValue());
                i11++;
            }
            return;
        }
        this.f13588a.W0(i10, 2);
        int iZ = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iZ += CodedOutputStream.Z(list.get(i12).longValue());
        }
        this.f13588a.Y0(iZ);
        while (i11 < list.size()) {
            this.f13588a.a1(list.get(i11).longValue());
            i11++;
        }
    }
}
