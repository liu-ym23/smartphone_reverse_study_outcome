package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.E;
import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException;
import androidx.datastore.preferences.protobuf.WireFormat;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

/* renamed from: androidx.datastore.preferences.protobuf.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1342e implements Y {

    /* renamed from: androidx.datastore.preferences.protobuf.e$a */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13537a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f13537a = iArr;
            try {
                iArr[WireFormat.FieldType.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13537a[WireFormat.FieldType.BYTES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13537a[WireFormat.FieldType.DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13537a[WireFormat.FieldType.ENUM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f13537a[WireFormat.FieldType.FIXED32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f13537a[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f13537a[WireFormat.FieldType.FLOAT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f13537a[WireFormat.FieldType.INT32.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f13537a[WireFormat.FieldType.INT64.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f13537a[WireFormat.FieldType.MESSAGE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f13537a[WireFormat.FieldType.SFIXED32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f13537a[WireFormat.FieldType.SFIXED64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f13537a[WireFormat.FieldType.SINT32.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f13537a[WireFormat.FieldType.SINT64.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f13537a[WireFormat.FieldType.STRING.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f13537a[WireFormat.FieldType.UINT32.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f13537a[WireFormat.FieldType.UINT64.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    /* renamed from: androidx.datastore.preferences.protobuf.e$b */
    public static final class b extends AbstractC1342e {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f13538a;

        /* renamed from: b, reason: collision with root package name */
        public final byte[] f13539b;

        /* renamed from: c, reason: collision with root package name */
        public int f13540c;

        /* renamed from: d, reason: collision with root package name */
        public final int f13541d;

        /* renamed from: e, reason: collision with root package name */
        public int f13542e;

        /* renamed from: f, reason: collision with root package name */
        public int f13543f;

        /* renamed from: g, reason: collision with root package name */
        public int f13544g;

        public b(ByteBuffer byteBuffer, boolean z10) {
            super(null);
            this.f13538a = z10;
            this.f13539b = byteBuffer.array();
            int iArrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
            this.f13540c = iArrayOffset;
            this.f13541d = iArrayOffset;
            this.f13542e = byteBuffer.arrayOffset() + byteBuffer.limit();
        }

        public final void A() throws IOException {
            int i10 = this.f13544g;
            this.f13544g = WireFormat.c(WireFormat.a(this.f13543f), 4);
            while (getFieldNumber() != Integer.MAX_VALUE && skipField()) {
            }
            if (this.f13543f != this.f13544g) {
                throw InvalidProtocolBufferException.g();
            }
            this.f13544g = i10;
        }

        public final void B() throws IOException {
            int i10 = this.f13542e;
            int i11 = this.f13540c;
            if (i10 - i11 >= 10) {
                byte[] bArr = this.f13539b;
                int i12 = 0;
                while (i12 < 10) {
                    int i13 = i11 + 1;
                    if (bArr[i11] >= 0) {
                        this.f13540c = i13;
                        return;
                    } else {
                        i12++;
                        i11 = i13;
                    }
                }
            }
            C();
        }

        public final void C() throws IOException {
            for (int i10 = 0; i10 < 10; i10++) {
                if (j() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.e();
        }

        public final void D(int i10) throws IOException {
            w(i10);
            if ((i10 & 3) != 0) {
                throw InvalidProtocolBufferException.g();
            }
        }

        public final void E(int i10) throws IOException {
            w(i10);
            if ((i10 & 7) != 0) {
                throw InvalidProtocolBufferException.g();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.Y
        public <T> T a(Z<T> z10, C1351n c1351n) throws IOException {
            y(2);
            return (T) q(z10, c1351n);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.datastore.preferences.protobuf.Y
        public <T> void b(List<T> list, Z<T> z10, C1351n c1351n) throws IOException {
            int i10;
            if (WireFormat.b(this.f13543f) != 2) {
                throw InvalidProtocolBufferException.d();
            }
            int i11 = this.f13543f;
            do {
                list.add(q(z10, c1351n));
                if (i()) {
                    return;
                } else {
                    i10 = this.f13540c;
                }
            } while (t() == i11);
            this.f13540c = i10;
        }

        @Override // androidx.datastore.preferences.protobuf.Y
        public <T> T c(Z<T> z10, C1351n c1351n) throws IOException {
            y(3);
            return (T) l(z10, c1351n);
        }

        @Override // androidx.datastore.preferences.protobuf.Y
        public <T> T d(Class<T> cls, C1351n c1351n) throws IOException {
            y(2);
            return (T) q(V.a().d(cls), c1351n);
        }

        @Override // androidx.datastore.preferences.protobuf.Y
        public <T> T e(Class<T> cls, C1351n c1351n) throws IOException {
            y(3);
            return (T) l(V.a().d(cls), c1351n);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.datastore.preferences.protobuf.Y
        public <K, V> void f(Map<K, V> map, E.a<K, V> aVar, C1351n c1351n) throws IOException {
            y(2);
            int iT = t();
            w(iT);
            int i10 = this.f13542e;
            this.f13542e = this.f13540c + iT;
            try {
                Object objK = aVar.f13442b;
                Object objK2 = aVar.f13444d;
                while (true) {
                    int fieldNumber = getFieldNumber();
                    if (fieldNumber == Integer.MAX_VALUE) {
                        map.put(objK, objK2);
                        return;
                    }
                    if (fieldNumber == 1) {
                        objK = k(aVar.f13441a, null, null);
                    } else if (fieldNumber != 2) {
                        try {
                            if (!skipField()) {
                                throw new InvalidProtocolBufferException("Unable to parse map entry.");
                            }
                        } catch (InvalidProtocolBufferException.InvalidWireTypeException unused) {
                            if (!skipField()) {
                                throw new InvalidProtocolBufferException("Unable to parse map entry.");
                            }
                        }
                    } else {
                        objK2 = k(aVar.f13443c, aVar.f13444d.getClass(), c1351n);
                    }
                }
            } finally {
                this.f13542e = i10;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.datastore.preferences.protobuf.Y
        public <T> void g(List<T> list, Z<T> z10, C1351n c1351n) throws IOException {
            int i10;
            if (WireFormat.b(this.f13543f) != 3) {
                throw InvalidProtocolBufferException.d();
            }
            int i11 = this.f13543f;
            do {
                list.add(l(z10, c1351n));
                if (i()) {
                    return;
                } else {
                    i10 = this.f13540c;
                }
            } while (t() == i11);
            this.f13540c = i10;
        }

        @Override // androidx.datastore.preferences.protobuf.Y
        public int getFieldNumber() throws IOException {
            if (i()) {
                return Integer.MAX_VALUE;
            }
            int iT = t();
            this.f13543f = iT;
            if (iT == this.f13544g) {
                return Integer.MAX_VALUE;
            }
            return WireFormat.a(iT);
        }

        @Override // androidx.datastore.preferences.protobuf.Y
        public int getTag() {
            return this.f13543f;
        }

        public final boolean i() {
            return this.f13540c == this.f13542e;
        }

        public final byte j() throws IOException {
            int i10 = this.f13540c;
            if (i10 == this.f13542e) {
                throw InvalidProtocolBufferException.k();
            }
            byte[] bArr = this.f13539b;
            this.f13540c = i10 + 1;
            return bArr[i10];
        }

        public final Object k(WireFormat.FieldType fieldType, Class<?> cls, C1351n c1351n) throws IOException {
            switch (a.f13537a[fieldType.ordinal()]) {
                case 1:
                    return Boolean.valueOf(readBool());
                case 2:
                    return readBytes();
                case 3:
                    return Double.valueOf(readDouble());
                case 4:
                    return Integer.valueOf(readEnum());
                case 5:
                    return Integer.valueOf(readFixed32());
                case 6:
                    return Long.valueOf(readFixed64());
                case 7:
                    return Float.valueOf(readFloat());
                case 8:
                    return Integer.valueOf(readInt32());
                case 9:
                    return Long.valueOf(readInt64());
                case 10:
                    return d(cls, c1351n);
                case 11:
                    return Integer.valueOf(readSFixed32());
                case 12:
                    return Long.valueOf(readSFixed64());
                case 13:
                    return Integer.valueOf(readSInt32());
                case 14:
                    return Long.valueOf(readSInt64());
                case 15:
                    return readStringRequireUtf8();
                case 16:
                    return Integer.valueOf(readUInt32());
                case 17:
                    return Long.valueOf(readUInt64());
                default:
                    throw new RuntimeException("unsupported field type.");
            }
        }

        public final <T> T l(Z<T> z10, C1351n c1351n) throws IOException {
            int i10 = this.f13544g;
            this.f13544g = WireFormat.c(WireFormat.a(this.f13543f), 4);
            try {
                T tNewInstance = z10.newInstance();
                z10.a(tNewInstance, this, c1351n);
                z10.makeImmutable(tNewInstance);
                if (this.f13543f == this.f13544g) {
                    return tNewInstance;
                }
                throw InvalidProtocolBufferException.g();
            } finally {
                this.f13544g = i10;
            }
        }

        public final int m() throws IOException {
            w(4);
            return n();
        }

        public final int n() {
            int i10 = this.f13540c;
            byte[] bArr = this.f13539b;
            this.f13540c = i10 + 4;
            return (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16) | ((bArr[i10 + 3] & 255) << 24);
        }

        public final long o() throws IOException {
            w(8);
            return p();
        }

        public final long p() {
            int i10 = this.f13540c;
            byte[] bArr = this.f13539b;
            this.f13540c = i10 + 8;
            return ((bArr[i10 + 7] & 255) << 56) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16) | ((bArr[i10 + 3] & 255) << 24) | ((bArr[i10 + 4] & 255) << 32) | ((bArr[i10 + 5] & 255) << 40) | ((bArr[i10 + 6] & 255) << 48);
        }

        public final <T> T q(Z<T> z10, C1351n c1351n) throws IOException {
            int iT = t();
            w(iT);
            int i10 = this.f13542e;
            int i11 = this.f13540c + iT;
            this.f13542e = i11;
            try {
                T tNewInstance = z10.newInstance();
                z10.a(tNewInstance, this, c1351n);
                z10.makeImmutable(tNewInstance);
                if (this.f13540c == i11) {
                    return tNewInstance;
                }
                throw InvalidProtocolBufferException.g();
            } finally {
                this.f13542e = i10;
            }
        }

        public String r(boolean z10) throws IOException {
            y(2);
            int iT = t();
            if (iT == 0) {
                return "";
            }
            w(iT);
            if (z10) {
                byte[] bArr = this.f13539b;
                int i10 = this.f13540c;
                if (!Utf8.n(bArr, i10, i10 + iT)) {
                    throw InvalidProtocolBufferException.c();
                }
            }
            String str = new String(this.f13539b, this.f13540c, iT, C1359w.f13642a);
            this.f13540c += iT;
            return str;
        }

        @Override // androidx.datastore.preferences.protobuf.Y
        public boolean readBool() throws IOException {
            y(0);
            return t() != 0;
        }

        @Override // androidx.datastore.preferences.protobuf.Y
        public void readBoolList(List<Boolean> list) throws IOException {
            int i10;
            int i11;
            if (!(list instanceof C1343f)) {
                int iB = WireFormat.b(this.f13543f);
                if (iB != 0) {
                    if (iB != 2) {
                        throw InvalidProtocolBufferException.d();
                    }
                    int iT = this.f13540c + t();
                    while (this.f13540c < iT) {
                        list.add(Boolean.valueOf(t() != 0));
                    }
                    x(iT);
                    return;
                }
                do {
                    list.add(Boolean.valueOf(readBool()));
                    if (i()) {
                        return;
                    } else {
                        i10 = this.f13540c;
                    }
                } while (t() == this.f13543f);
                this.f13540c = i10;
                return;
            }
            C1343f c1343f = (C1343f) list;
            int iB2 = WireFormat.b(this.f13543f);
            if (iB2 != 0) {
                if (iB2 != 2) {
                    throw InvalidProtocolBufferException.d();
                }
                int iT2 = this.f13540c + t();
                while (this.f13540c < iT2) {
                    c1343f.addBoolean(t() != 0);
                }
                x(iT2);
                return;
            }
            do {
                c1343f.addBoolean(readBool());
                if (i()) {
                    return;
                } else {
                    i11 = this.f13540c;
                }
            } while (t() == this.f13543f);
            this.f13540c = i11;
        }

        @Override // androidx.datastore.preferences.protobuf.Y
        public ByteString readBytes() throws IOException {
            y(2);
            int iT = t();
            if (iT == 0) {
                return ByteString.f13407b;
            }
            w(iT);
            ByteString byteStringK = this.f13538a ? ByteString.K(this.f13539b, this.f13540c, iT) : ByteString.j(this.f13539b, this.f13540c, iT);
            this.f13540c += iT;
            return byteStringK;
        }

        @Override // androidx.datastore.preferences.protobuf.Y
        public void readBytesList(List<ByteString> list) throws IOException {
            int i10;
            if (WireFormat.b(this.f13543f) != 2) {
                throw InvalidProtocolBufferException.d();
            }
            do {
                list.add(readBytes());
                if (i()) {
                    return;
                } else {
                    i10 = this.f13540c;
                }
            } while (t() == this.f13543f);
            this.f13540c = i10;
        }

        @Override // androidx.datastore.preferences.protobuf.Y
        public double readDouble() throws IOException {
            y(1);
            return Double.longBitsToDouble(o());
        }

        @Override // androidx.datastore.preferences.protobuf.Y
        public void readDoubleList(List<Double> list) throws IOException {
            int i10;
            int i11;
            if (!(list instanceof C1348k)) {
                int iB = WireFormat.b(this.f13543f);
                if (iB == 1) {
                    do {
                        list.add(Double.valueOf(readDouble()));
                        if (i()) {
                            return;
                        } else {
                            i10 = this.f13540c;
                        }
                    } while (t() == this.f13543f);
                    this.f13540c = i10;
                    return;
                }
                if (iB != 2) {
                    throw InvalidProtocolBufferException.d();
                }
                int iT = t();
                E(iT);
                int i12 = this.f13540c + iT;
                while (this.f13540c < i12) {
                    list.add(Double.valueOf(Double.longBitsToDouble(p())));
                }
                return;
            }
            C1348k c1348k = (C1348k) list;
            int iB2 = WireFormat.b(this.f13543f);
            if (iB2 == 1) {
                do {
                    c1348k.addDouble(readDouble());
                    if (i()) {
                        return;
                    } else {
                        i11 = this.f13540c;
                    }
                } while (t() == this.f13543f);
                this.f13540c = i11;
                return;
            }
            if (iB2 != 2) {
                throw InvalidProtocolBufferException.d();
            }
            int iT2 = t();
            E(iT2);
            int i13 = this.f13540c + iT2;
            while (this.f13540c < i13) {
                c1348k.addDouble(Double.longBitsToDouble(p()));
            }
        }

        @Override // androidx.datastore.preferences.protobuf.Y
        public int readEnum() throws IOException {
            y(0);
            return t();
        }

        @Override // androidx.datastore.preferences.protobuf.Y
        public void readEnumList(List<Integer> list) throws IOException {
            int i10;
            int i11;
            if (!(list instanceof C1358v)) {
                int iB = WireFormat.b(this.f13543f);
                if (iB != 0) {
                    if (iB != 2) {
                        throw InvalidProtocolBufferException.d();
                    }
                    int iT = this.f13540c + t();
                    while (this.f13540c < iT) {
                        list.add(Integer.valueOf(t()));
                    }
                    return;
                }
                do {
                    list.add(Integer.valueOf(readEnum()));
                    if (i()) {
                        return;
                    } else {
                        i10 = this.f13540c;
                    }
                } while (t() == this.f13543f);
                this.f13540c = i10;
                return;
            }
            C1358v c1358v = (C1358v) list;
            int iB2 = WireFormat.b(this.f13543f);
            if (iB2 != 0) {
                if (iB2 != 2) {
                    throw InvalidProtocolBufferException.d();
                }
                int iT2 = this.f13540c + t();
                while (this.f13540c < iT2) {
                    c1358v.addInt(t());
                }
                return;
            }
            do {
                c1358v.addInt(readEnum());
                if (i()) {
                    return;
                } else {
                    i11 = this.f13540c;
                }
            } while (t() == this.f13543f);
            this.f13540c = i11;
        }

        @Override // androidx.datastore.preferences.protobuf.Y
        public int readFixed32() throws IOException {
            y(5);
            return m();
        }

        @Override // androidx.datastore.preferences.protobuf.Y
        public void readFixed32List(List<Integer> list) throws IOException {
            int i10;
            int i11;
            if (!(list instanceof C1358v)) {
                int iB = WireFormat.b(this.f13543f);
                if (iB == 2) {
                    int iT = t();
                    D(iT);
                    int i12 = this.f13540c + iT;
                    while (this.f13540c < i12) {
                        list.add(Integer.valueOf(n()));
                    }
                    return;
                }
                if (iB != 5) {
                    throw InvalidProtocolBufferException.d();
                }
                do {
                    list.add(Integer.valueOf(readFixed32()));
                    if (i()) {
                        return;
                    } else {
                        i10 = this.f13540c;
                    }
                } while (t() == this.f13543f);
                this.f13540c = i10;
                return;
            }
            C1358v c1358v = (C1358v) list;
            int iB2 = WireFormat.b(this.f13543f);
            if (iB2 == 2) {
                int iT2 = t();
                D(iT2);
                int i13 = this.f13540c + iT2;
                while (this.f13540c < i13) {
                    c1358v.addInt(n());
                }
                return;
            }
            if (iB2 != 5) {
                throw InvalidProtocolBufferException.d();
            }
            do {
                c1358v.addInt(readFixed32());
                if (i()) {
                    return;
                } else {
                    i11 = this.f13540c;
                }
            } while (t() == this.f13543f);
            this.f13540c = i11;
        }

        @Override // androidx.datastore.preferences.protobuf.Y
        public long readFixed64() throws IOException {
            y(1);
            return o();
        }

        @Override // androidx.datastore.preferences.protobuf.Y
        public void readFixed64List(List<Long> list) throws IOException {
            int i10;
            int i11;
            if (!(list instanceof C)) {
                int iB = WireFormat.b(this.f13543f);
                if (iB == 1) {
                    do {
                        list.add(Long.valueOf(readFixed64()));
                        if (i()) {
                            return;
                        } else {
                            i10 = this.f13540c;
                        }
                    } while (t() == this.f13543f);
                    this.f13540c = i10;
                    return;
                }
                if (iB != 2) {
                    throw InvalidProtocolBufferException.d();
                }
                int iT = t();
                E(iT);
                int i12 = this.f13540c + iT;
                while (this.f13540c < i12) {
                    list.add(Long.valueOf(p()));
                }
                return;
            }
            C c10 = (C) list;
            int iB2 = WireFormat.b(this.f13543f);
            if (iB2 == 1) {
                do {
                    c10.addLong(readFixed64());
                    if (i()) {
                        return;
                    } else {
                        i11 = this.f13540c;
                    }
                } while (t() == this.f13543f);
                this.f13540c = i11;
                return;
            }
            if (iB2 != 2) {
                throw InvalidProtocolBufferException.d();
            }
            int iT2 = t();
            E(iT2);
            int i13 = this.f13540c + iT2;
            while (this.f13540c < i13) {
                c10.addLong(p());
            }
        }

        @Override // androidx.datastore.preferences.protobuf.Y
        public float readFloat() throws IOException {
            y(5);
            return Float.intBitsToFloat(m());
        }

        @Override // androidx.datastore.preferences.protobuf.Y
        public void readFloatList(List<Float> list) throws IOException {
            int i10;
            int i11;
            if (!(list instanceof C1356t)) {
                int iB = WireFormat.b(this.f13543f);
                if (iB == 2) {
                    int iT = t();
                    D(iT);
                    int i12 = this.f13540c + iT;
                    while (this.f13540c < i12) {
                        list.add(Float.valueOf(Float.intBitsToFloat(n())));
                    }
                    return;
                }
                if (iB != 5) {
                    throw InvalidProtocolBufferException.d();
                }
                do {
                    list.add(Float.valueOf(readFloat()));
                    if (i()) {
                        return;
                    } else {
                        i10 = this.f13540c;
                    }
                } while (t() == this.f13543f);
                this.f13540c = i10;
                return;
            }
            C1356t c1356t = (C1356t) list;
            int iB2 = WireFormat.b(this.f13543f);
            if (iB2 == 2) {
                int iT2 = t();
                D(iT2);
                int i13 = this.f13540c + iT2;
                while (this.f13540c < i13) {
                    c1356t.addFloat(Float.intBitsToFloat(n()));
                }
                return;
            }
            if (iB2 != 5) {
                throw InvalidProtocolBufferException.d();
            }
            do {
                c1356t.addFloat(readFloat());
                if (i()) {
                    return;
                } else {
                    i11 = this.f13540c;
                }
            } while (t() == this.f13543f);
            this.f13540c = i11;
        }

        @Override // androidx.datastore.preferences.protobuf.Y
        public int readInt32() throws IOException {
            y(0);
            return t();
        }

        @Override // androidx.datastore.preferences.protobuf.Y
        public void readInt32List(List<Integer> list) throws IOException {
            int i10;
            int i11;
            if (!(list instanceof C1358v)) {
                int iB = WireFormat.b(this.f13543f);
                if (iB == 0) {
                    do {
                        list.add(Integer.valueOf(readInt32()));
                        if (i()) {
                            return;
                        } else {
                            i10 = this.f13540c;
                        }
                    } while (t() == this.f13543f);
                    this.f13540c = i10;
                    return;
                }
                if (iB != 2) {
                    throw InvalidProtocolBufferException.d();
                }
                int iT = this.f13540c + t();
                while (this.f13540c < iT) {
                    list.add(Integer.valueOf(t()));
                }
                x(iT);
                return;
            }
            C1358v c1358v = (C1358v) list;
            int iB2 = WireFormat.b(this.f13543f);
            if (iB2 == 0) {
                do {
                    c1358v.addInt(readInt32());
                    if (i()) {
                        return;
                    } else {
                        i11 = this.f13540c;
                    }
                } while (t() == this.f13543f);
                this.f13540c = i11;
                return;
            }
            if (iB2 != 2) {
                throw InvalidProtocolBufferException.d();
            }
            int iT2 = this.f13540c + t();
            while (this.f13540c < iT2) {
                c1358v.addInt(t());
            }
            x(iT2);
        }

        @Override // androidx.datastore.preferences.protobuf.Y
        public long readInt64() throws IOException {
            y(0);
            return u();
        }

        @Override // androidx.datastore.preferences.protobuf.Y
        public void readInt64List(List<Long> list) throws IOException {
            int i10;
            int i11;
            if (!(list instanceof C)) {
                int iB = WireFormat.b(this.f13543f);
                if (iB == 0) {
                    do {
                        list.add(Long.valueOf(readInt64()));
                        if (i()) {
                            return;
                        } else {
                            i10 = this.f13540c;
                        }
                    } while (t() == this.f13543f);
                    this.f13540c = i10;
                    return;
                }
                if (iB != 2) {
                    throw InvalidProtocolBufferException.d();
                }
                int iT = this.f13540c + t();
                while (this.f13540c < iT) {
                    list.add(Long.valueOf(u()));
                }
                x(iT);
                return;
            }
            C c10 = (C) list;
            int iB2 = WireFormat.b(this.f13543f);
            if (iB2 == 0) {
                do {
                    c10.addLong(readInt64());
                    if (i()) {
                        return;
                    } else {
                        i11 = this.f13540c;
                    }
                } while (t() == this.f13543f);
                this.f13540c = i11;
                return;
            }
            if (iB2 != 2) {
                throw InvalidProtocolBufferException.d();
            }
            int iT2 = this.f13540c + t();
            while (this.f13540c < iT2) {
                c10.addLong(u());
            }
            x(iT2);
        }

        @Override // androidx.datastore.preferences.protobuf.Y
        public int readSFixed32() throws IOException {
            y(5);
            return m();
        }

        @Override // androidx.datastore.preferences.protobuf.Y
        public void readSFixed32List(List<Integer> list) throws IOException {
            int i10;
            int i11;
            if (!(list instanceof C1358v)) {
                int iB = WireFormat.b(this.f13543f);
                if (iB == 2) {
                    int iT = t();
                    D(iT);
                    int i12 = this.f13540c + iT;
                    while (this.f13540c < i12) {
                        list.add(Integer.valueOf(n()));
                    }
                    return;
                }
                if (iB != 5) {
                    throw InvalidProtocolBufferException.d();
                }
                do {
                    list.add(Integer.valueOf(readSFixed32()));
                    if (i()) {
                        return;
                    } else {
                        i10 = this.f13540c;
                    }
                } while (t() == this.f13543f);
                this.f13540c = i10;
                return;
            }
            C1358v c1358v = (C1358v) list;
            int iB2 = WireFormat.b(this.f13543f);
            if (iB2 == 2) {
                int iT2 = t();
                D(iT2);
                int i13 = this.f13540c + iT2;
                while (this.f13540c < i13) {
                    c1358v.addInt(n());
                }
                return;
            }
            if (iB2 != 5) {
                throw InvalidProtocolBufferException.d();
            }
            do {
                c1358v.addInt(readSFixed32());
                if (i()) {
                    return;
                } else {
                    i11 = this.f13540c;
                }
            } while (t() == this.f13543f);
            this.f13540c = i11;
        }

        @Override // androidx.datastore.preferences.protobuf.Y
        public long readSFixed64() throws IOException {
            y(1);
            return o();
        }

        @Override // androidx.datastore.preferences.protobuf.Y
        public void readSFixed64List(List<Long> list) throws IOException {
            int i10;
            int i11;
            if (!(list instanceof C)) {
                int iB = WireFormat.b(this.f13543f);
                if (iB == 1) {
                    do {
                        list.add(Long.valueOf(readSFixed64()));
                        if (i()) {
                            return;
                        } else {
                            i10 = this.f13540c;
                        }
                    } while (t() == this.f13543f);
                    this.f13540c = i10;
                    return;
                }
                if (iB != 2) {
                    throw InvalidProtocolBufferException.d();
                }
                int iT = t();
                E(iT);
                int i12 = this.f13540c + iT;
                while (this.f13540c < i12) {
                    list.add(Long.valueOf(p()));
                }
                return;
            }
            C c10 = (C) list;
            int iB2 = WireFormat.b(this.f13543f);
            if (iB2 == 1) {
                do {
                    c10.addLong(readSFixed64());
                    if (i()) {
                        return;
                    } else {
                        i11 = this.f13540c;
                    }
                } while (t() == this.f13543f);
                this.f13540c = i11;
                return;
            }
            if (iB2 != 2) {
                throw InvalidProtocolBufferException.d();
            }
            int iT2 = t();
            E(iT2);
            int i13 = this.f13540c + iT2;
            while (this.f13540c < i13) {
                c10.addLong(p());
            }
        }

        @Override // androidx.datastore.preferences.protobuf.Y
        public int readSInt32() throws IOException {
            y(0);
            return AbstractC1345h.b(t());
        }

        @Override // androidx.datastore.preferences.protobuf.Y
        public void readSInt32List(List<Integer> list) throws IOException {
            int i10;
            int i11;
            if (!(list instanceof C1358v)) {
                int iB = WireFormat.b(this.f13543f);
                if (iB != 0) {
                    if (iB != 2) {
                        throw InvalidProtocolBufferException.d();
                    }
                    int iT = this.f13540c + t();
                    while (this.f13540c < iT) {
                        list.add(Integer.valueOf(AbstractC1345h.b(t())));
                    }
                    return;
                }
                do {
                    list.add(Integer.valueOf(readSInt32()));
                    if (i()) {
                        return;
                    } else {
                        i10 = this.f13540c;
                    }
                } while (t() == this.f13543f);
                this.f13540c = i10;
                return;
            }
            C1358v c1358v = (C1358v) list;
            int iB2 = WireFormat.b(this.f13543f);
            if (iB2 != 0) {
                if (iB2 != 2) {
                    throw InvalidProtocolBufferException.d();
                }
                int iT2 = this.f13540c + t();
                while (this.f13540c < iT2) {
                    c1358v.addInt(AbstractC1345h.b(t()));
                }
                return;
            }
            do {
                c1358v.addInt(readSInt32());
                if (i()) {
                    return;
                } else {
                    i11 = this.f13540c;
                }
            } while (t() == this.f13543f);
            this.f13540c = i11;
        }

        @Override // androidx.datastore.preferences.protobuf.Y
        public long readSInt64() throws IOException {
            y(0);
            return AbstractC1345h.c(u());
        }

        @Override // androidx.datastore.preferences.protobuf.Y
        public void readSInt64List(List<Long> list) throws IOException {
            int i10;
            int i11;
            if (!(list instanceof C)) {
                int iB = WireFormat.b(this.f13543f);
                if (iB != 0) {
                    if (iB != 2) {
                        throw InvalidProtocolBufferException.d();
                    }
                    int iT = this.f13540c + t();
                    while (this.f13540c < iT) {
                        list.add(Long.valueOf(AbstractC1345h.c(u())));
                    }
                    return;
                }
                do {
                    list.add(Long.valueOf(readSInt64()));
                    if (i()) {
                        return;
                    } else {
                        i10 = this.f13540c;
                    }
                } while (t() == this.f13543f);
                this.f13540c = i10;
                return;
            }
            C c10 = (C) list;
            int iB2 = WireFormat.b(this.f13543f);
            if (iB2 != 0) {
                if (iB2 != 2) {
                    throw InvalidProtocolBufferException.d();
                }
                int iT2 = this.f13540c + t();
                while (this.f13540c < iT2) {
                    c10.addLong(AbstractC1345h.c(u()));
                }
                return;
            }
            do {
                c10.addLong(readSInt64());
                if (i()) {
                    return;
                } else {
                    i11 = this.f13540c;
                }
            } while (t() == this.f13543f);
            this.f13540c = i11;
        }

        @Override // androidx.datastore.preferences.protobuf.Y
        public String readString() throws IOException {
            return r(false);
        }

        @Override // androidx.datastore.preferences.protobuf.Y
        public void readStringList(List<String> list) throws IOException {
            s(list, false);
        }

        @Override // androidx.datastore.preferences.protobuf.Y
        public void readStringListRequireUtf8(List<String> list) throws IOException {
            s(list, true);
        }

        @Override // androidx.datastore.preferences.protobuf.Y
        public String readStringRequireUtf8() throws IOException {
            return r(true);
        }

        @Override // androidx.datastore.preferences.protobuf.Y
        public int readUInt32() throws IOException {
            y(0);
            return t();
        }

        @Override // androidx.datastore.preferences.protobuf.Y
        public void readUInt32List(List<Integer> list) throws IOException {
            int i10;
            int i11;
            if (!(list instanceof C1358v)) {
                int iB = WireFormat.b(this.f13543f);
                if (iB != 0) {
                    if (iB != 2) {
                        throw InvalidProtocolBufferException.d();
                    }
                    int iT = this.f13540c + t();
                    while (this.f13540c < iT) {
                        list.add(Integer.valueOf(t()));
                    }
                    return;
                }
                do {
                    list.add(Integer.valueOf(readUInt32()));
                    if (i()) {
                        return;
                    } else {
                        i10 = this.f13540c;
                    }
                } while (t() == this.f13543f);
                this.f13540c = i10;
                return;
            }
            C1358v c1358v = (C1358v) list;
            int iB2 = WireFormat.b(this.f13543f);
            if (iB2 != 0) {
                if (iB2 != 2) {
                    throw InvalidProtocolBufferException.d();
                }
                int iT2 = this.f13540c + t();
                while (this.f13540c < iT2) {
                    c1358v.addInt(t());
                }
                return;
            }
            do {
                c1358v.addInt(readUInt32());
                if (i()) {
                    return;
                } else {
                    i11 = this.f13540c;
                }
            } while (t() == this.f13543f);
            this.f13540c = i11;
        }

        @Override // androidx.datastore.preferences.protobuf.Y
        public long readUInt64() throws IOException {
            y(0);
            return u();
        }

        @Override // androidx.datastore.preferences.protobuf.Y
        public void readUInt64List(List<Long> list) throws IOException {
            int i10;
            int i11;
            if (!(list instanceof C)) {
                int iB = WireFormat.b(this.f13543f);
                if (iB == 0) {
                    do {
                        list.add(Long.valueOf(readUInt64()));
                        if (i()) {
                            return;
                        } else {
                            i10 = this.f13540c;
                        }
                    } while (t() == this.f13543f);
                    this.f13540c = i10;
                    return;
                }
                if (iB != 2) {
                    throw InvalidProtocolBufferException.d();
                }
                int iT = this.f13540c + t();
                while (this.f13540c < iT) {
                    list.add(Long.valueOf(u()));
                }
                x(iT);
                return;
            }
            C c10 = (C) list;
            int iB2 = WireFormat.b(this.f13543f);
            if (iB2 == 0) {
                do {
                    c10.addLong(readUInt64());
                    if (i()) {
                        return;
                    } else {
                        i11 = this.f13540c;
                    }
                } while (t() == this.f13543f);
                this.f13540c = i11;
                return;
            }
            if (iB2 != 2) {
                throw InvalidProtocolBufferException.d();
            }
            int iT2 = this.f13540c + t();
            while (this.f13540c < iT2) {
                c10.addLong(u());
            }
            x(iT2);
        }

        public void s(List<String> list, boolean z10) throws IOException {
            int i10;
            int i11;
            if (WireFormat.b(this.f13543f) != 2) {
                throw InvalidProtocolBufferException.d();
            }
            if (!(list instanceof A) || z10) {
                do {
                    list.add(r(z10));
                    if (i()) {
                        return;
                    } else {
                        i10 = this.f13540c;
                    }
                } while (t() == this.f13543f);
                this.f13540c = i10;
                return;
            }
            A a10 = (A) list;
            do {
                a10.F(readBytes());
                if (i()) {
                    return;
                } else {
                    i11 = this.f13540c;
                }
            } while (t() == this.f13543f);
            this.f13540c = i11;
        }

        @Override // androidx.datastore.preferences.protobuf.Y
        public boolean skipField() throws IOException {
            int i10;
            if (i() || (i10 = this.f13543f) == this.f13544g) {
                return false;
            }
            int iB = WireFormat.b(i10);
            if (iB == 0) {
                B();
                return true;
            }
            if (iB == 1) {
                z(8);
                return true;
            }
            if (iB == 2) {
                z(t());
                return true;
            }
            if (iB == 3) {
                A();
                return true;
            }
            if (iB != 5) {
                throw InvalidProtocolBufferException.d();
            }
            z(4);
            return true;
        }

        public final int t() throws IOException {
            int i10;
            int i11 = this.f13540c;
            int i12 = this.f13542e;
            if (i12 == i11) {
                throw InvalidProtocolBufferException.k();
            }
            byte[] bArr = this.f13539b;
            int i13 = i11 + 1;
            byte b10 = bArr[i11];
            if (b10 >= 0) {
                this.f13540c = i13;
                return b10;
            }
            if (i12 - i13 < 9) {
                return (int) v();
            }
            int i14 = i11 + 2;
            int i15 = (bArr[i13] << 7) ^ b10;
            if (i15 < 0) {
                i10 = i15 ^ (-128);
            } else {
                int i16 = i11 + 3;
                int i17 = (bArr[i14] << 14) ^ i15;
                if (i17 >= 0) {
                    i10 = i17 ^ 16256;
                } else {
                    int i18 = i11 + 4;
                    int i19 = i17 ^ (bArr[i16] << 21);
                    if (i19 < 0) {
                        i10 = (-2080896) ^ i19;
                    } else {
                        i16 = i11 + 5;
                        byte b11 = bArr[i18];
                        int i20 = (i19 ^ (b11 << 28)) ^ 266354560;
                        if (b11 < 0) {
                            i18 = i11 + 6;
                            if (bArr[i16] < 0) {
                                i16 = i11 + 7;
                                if (bArr[i18] < 0) {
                                    i18 = i11 + 8;
                                    if (bArr[i16] < 0) {
                                        i16 = i11 + 9;
                                        if (bArr[i18] < 0) {
                                            int i21 = i11 + 10;
                                            if (bArr[i16] < 0) {
                                                throw InvalidProtocolBufferException.e();
                                            }
                                            i14 = i21;
                                            i10 = i20;
                                        }
                                    }
                                }
                            }
                            i10 = i20;
                        }
                        i10 = i20;
                    }
                    i14 = i18;
                }
                i14 = i16;
            }
            this.f13540c = i14;
            return i10;
        }

        public long u() throws IOException {
            long j10;
            long j11;
            long j12;
            int i10 = this.f13540c;
            int i11 = this.f13542e;
            if (i11 == i10) {
                throw InvalidProtocolBufferException.k();
            }
            byte[] bArr = this.f13539b;
            int i12 = i10 + 1;
            byte b10 = bArr[i10];
            if (b10 >= 0) {
                this.f13540c = i12;
                return b10;
            }
            if (i11 - i12 < 9) {
                return v();
            }
            int i13 = i10 + 2;
            int i14 = (bArr[i12] << 7) ^ b10;
            if (i14 < 0) {
                j10 = i14 ^ (-128);
            } else {
                int i15 = i10 + 3;
                int i16 = (bArr[i13] << 14) ^ i14;
                if (i16 >= 0) {
                    j10 = i16 ^ 16256;
                    i13 = i15;
                } else {
                    int i17 = i10 + 4;
                    int i18 = i16 ^ (bArr[i15] << 21);
                    if (i18 < 0) {
                        long j13 = (-2080896) ^ i18;
                        i13 = i17;
                        j10 = j13;
                    } else {
                        long j14 = i18;
                        i13 = i10 + 5;
                        long j15 = j14 ^ (bArr[i17] << 28);
                        if (j15 >= 0) {
                            j12 = 266354560;
                        } else {
                            int i19 = i10 + 6;
                            long j16 = j15 ^ (bArr[i13] << 35);
                            if (j16 < 0) {
                                j11 = -34093383808L;
                            } else {
                                i13 = i10 + 7;
                                j15 = j16 ^ (bArr[i19] << 42);
                                if (j15 >= 0) {
                                    j12 = 4363953127296L;
                                } else {
                                    i19 = i10 + 8;
                                    j16 = j15 ^ (bArr[i13] << 49);
                                    if (j16 < 0) {
                                        j11 = -558586000294016L;
                                    } else {
                                        i13 = i10 + 9;
                                        long j17 = (j16 ^ (bArr[i19] << 56)) ^ 71499008037633920L;
                                        if (j17 < 0) {
                                            int i20 = i10 + 10;
                                            if (bArr[i13] < 0) {
                                                throw InvalidProtocolBufferException.e();
                                            }
                                            i13 = i20;
                                        }
                                        j10 = j17;
                                    }
                                }
                            }
                            j10 = j16 ^ j11;
                            i13 = i19;
                        }
                        j10 = j15 ^ j12;
                    }
                }
            }
            this.f13540c = i13;
            return j10;
        }

        public final long v() throws IOException {
            long j10 = 0;
            for (int i10 = 0; i10 < 64; i10 += 7) {
                j10 |= (r3 & 127) << i10;
                if ((j() & 128) == 0) {
                    return j10;
                }
            }
            throw InvalidProtocolBufferException.e();
        }

        public final void w(int i10) throws IOException {
            if (i10 < 0 || i10 > this.f13542e - this.f13540c) {
                throw InvalidProtocolBufferException.k();
            }
        }

        public final void x(int i10) throws IOException {
            if (this.f13540c != i10) {
                throw InvalidProtocolBufferException.k();
            }
        }

        public final void y(int i10) throws IOException {
            if (WireFormat.b(this.f13543f) != i10) {
                throw InvalidProtocolBufferException.d();
            }
        }

        public final void z(int i10) throws IOException {
            w(i10);
            this.f13540c += i10;
        }
    }

    public /* synthetic */ AbstractC1342e(a aVar) {
        this();
    }

    public static AbstractC1342e h(ByteBuffer byteBuffer, boolean z10) {
        if (byteBuffer.hasArray()) {
            return new b(byteBuffer, z10);
        }
        throw new IllegalArgumentException("Direct buffers not yet supported");
    }

    public AbstractC1342e() {
    }
}
