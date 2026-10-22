package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.WireFormat;
import java.io.IOException;
import java.util.List;

/* renamed from: androidx.datastore.preferences.protobuf.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1346i implements Y {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC1345h f13577a;

    /* renamed from: b, reason: collision with root package name */
    public int f13578b;

    /* renamed from: c, reason: collision with root package name */
    public int f13579c;

    /* renamed from: d, reason: collision with root package name */
    public int f13580d = 0;

    /* renamed from: androidx.datastore.preferences.protobuf.i$a */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f13581a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f13581a = iArr;
            try {
                iArr[WireFormat.FieldType.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13581a[WireFormat.FieldType.BYTES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13581a[WireFormat.FieldType.DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13581a[WireFormat.FieldType.ENUM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f13581a[WireFormat.FieldType.FIXED32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f13581a[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f13581a[WireFormat.FieldType.FLOAT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f13581a[WireFormat.FieldType.INT32.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f13581a[WireFormat.FieldType.INT64.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f13581a[WireFormat.FieldType.MESSAGE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f13581a[WireFormat.FieldType.SFIXED32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f13581a[WireFormat.FieldType.SFIXED64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f13581a[WireFormat.FieldType.SINT32.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f13581a[WireFormat.FieldType.SINT64.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f13581a[WireFormat.FieldType.STRING.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f13581a[WireFormat.FieldType.UINT32.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f13581a[WireFormat.FieldType.UINT64.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    public C1346i(AbstractC1345h abstractC1345h) {
        AbstractC1345h abstractC1345h2 = (AbstractC1345h) C1359w.b(abstractC1345h, "input");
        this.f13577a = abstractC1345h2;
        abstractC1345h2.f13558d = this;
    }

    public static C1346i h(AbstractC1345h abstractC1345h) {
        C1346i c1346i = abstractC1345h.f13558d;
        return c1346i != null ? c1346i : new C1346i(abstractC1345h);
    }

    private Object i(WireFormat.FieldType fieldType, Class<?> cls, C1351n c1351n) throws IOException {
        switch (a.f13581a[fieldType.ordinal()]) {
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

    private <T> T j(Z<T> z10, C1351n c1351n) throws IOException {
        int i10 = this.f13579c;
        this.f13579c = WireFormat.c(WireFormat.a(this.f13578b), 4);
        try {
            T tNewInstance = z10.newInstance();
            z10.a(tNewInstance, this, c1351n);
            z10.makeImmutable(tNewInstance);
            if (this.f13578b == this.f13579c) {
                return tNewInstance;
            }
            throw InvalidProtocolBufferException.g();
        } finally {
            this.f13579c = i10;
        }
    }

    private <T> T k(Z<T> z10, C1351n c1351n) throws IOException {
        int iC = this.f13577a.C();
        AbstractC1345h abstractC1345h = this.f13577a;
        if (abstractC1345h.f13555a >= abstractC1345h.f13556b) {
            throw InvalidProtocolBufferException.h();
        }
        int iL = abstractC1345h.l(iC);
        T tNewInstance = z10.newInstance();
        this.f13577a.f13555a++;
        z10.a(tNewInstance, this, c1351n);
        z10.makeImmutable(tNewInstance);
        this.f13577a.a(0);
        r4.f13555a--;
        this.f13577a.k(iL);
        return tNewInstance;
    }

    private void m(int i10) throws IOException {
        if (this.f13577a.d() != i10) {
            throw InvalidProtocolBufferException.k();
        }
    }

    private void n(int i10) throws IOException {
        if (WireFormat.b(this.f13578b) != i10) {
            throw InvalidProtocolBufferException.d();
        }
    }

    private void o(int i10) throws IOException {
        if ((i10 & 3) != 0) {
            throw InvalidProtocolBufferException.g();
        }
    }

    private void p(int i10) throws IOException {
        if ((i10 & 7) != 0) {
            throw InvalidProtocolBufferException.g();
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Y
    public <T> T a(Z<T> z10, C1351n c1351n) throws IOException {
        n(2);
        return (T) k(z10, c1351n);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.datastore.preferences.protobuf.Y
    public <T> void b(List<T> list, Z<T> z10, C1351n c1351n) throws IOException {
        int iB;
        if (WireFormat.b(this.f13578b) != 2) {
            throw InvalidProtocolBufferException.d();
        }
        int i10 = this.f13578b;
        do {
            list.add(k(z10, c1351n));
            if (this.f13577a.e() || this.f13580d != 0) {
                return;
            } else {
                iB = this.f13577a.B();
            }
        } while (iB == i10);
        this.f13580d = iB;
    }

    @Override // androidx.datastore.preferences.protobuf.Y
    public <T> T c(Z<T> z10, C1351n c1351n) throws IOException {
        n(3);
        return (T) j(z10, c1351n);
    }

    @Override // androidx.datastore.preferences.protobuf.Y
    public <T> T d(Class<T> cls, C1351n c1351n) throws IOException {
        n(2);
        return (T) k(V.a().d(cls), c1351n);
    }

    @Override // androidx.datastore.preferences.protobuf.Y
    public <T> T e(Class<T> cls, C1351n c1351n) throws IOException {
        n(3);
        return (T) j(V.a().d(cls), c1351n);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x005e, code lost:
    
        r8.put(r2, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0061, code lost:
    
        r7.f13577a.k(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0066, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.datastore.preferences.protobuf.Y
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <K, V> void f(java.util.Map<K, V> r8, androidx.datastore.preferences.protobuf.E.a<K, V> r9, androidx.datastore.preferences.protobuf.C1351n r10) throws java.io.IOException {
        /*
            r7 = this;
            r0 = 2
            r7.n(r0)
            androidx.datastore.preferences.protobuf.h r1 = r7.f13577a
            int r1 = r1.C()
            androidx.datastore.preferences.protobuf.h r2 = r7.f13577a
            int r1 = r2.l(r1)
            K r2 = r9.f13442b
            V r3 = r9.f13444d
        L14:
            int r4 = r7.getFieldNumber()     // Catch: java.lang.Throwable -> L3a
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L5e
            androidx.datastore.preferences.protobuf.h r5 = r7.f13577a     // Catch: java.lang.Throwable -> L3a
            boolean r5 = r5.e()     // Catch: java.lang.Throwable -> L3a
            if (r5 == 0) goto L26
            goto L5e
        L26:
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L49
            if (r4 == r0) goto L3c
            boolean r4 = r7.skipField()     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            if (r4 == 0) goto L34
            goto L14
        L34:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r4 = new androidx.datastore.preferences.protobuf.InvalidProtocolBufferException     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            r4.<init>(r6)     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            throw r4     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
        L3a:
            r8 = move-exception
            goto L67
        L3c:
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r4 = r9.f13443c     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            V r5 = r9.f13444d     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            java.lang.Class r5 = r5.getClass()     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            java.lang.Object r3 = r7.i(r4, r5, r10)     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            goto L14
        L49:
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r4 = r9.f13441a     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            r5 = 0
            java.lang.Object r2 = r7.i(r4, r5, r5)     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L51
            goto L14
        L51:
            boolean r4 = r7.skipField()     // Catch: java.lang.Throwable -> L3a
            if (r4 == 0) goto L58
            goto L14
        L58:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r8 = new androidx.datastore.preferences.protobuf.InvalidProtocolBufferException     // Catch: java.lang.Throwable -> L3a
            r8.<init>(r6)     // Catch: java.lang.Throwable -> L3a
            throw r8     // Catch: java.lang.Throwable -> L3a
        L5e:
            r8.put(r2, r3)     // Catch: java.lang.Throwable -> L3a
            androidx.datastore.preferences.protobuf.h r7 = r7.f13577a
            r7.k(r1)
            return
        L67:
            androidx.datastore.preferences.protobuf.h r7 = r7.f13577a
            r7.k(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.C1346i.f(java.util.Map, androidx.datastore.preferences.protobuf.E$a, androidx.datastore.preferences.protobuf.n):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.datastore.preferences.protobuf.Y
    public <T> void g(List<T> list, Z<T> z10, C1351n c1351n) throws IOException {
        int iB;
        if (WireFormat.b(this.f13578b) != 3) {
            throw InvalidProtocolBufferException.d();
        }
        int i10 = this.f13578b;
        do {
            list.add(j(z10, c1351n));
            if (this.f13577a.e() || this.f13580d != 0) {
                return;
            } else {
                iB = this.f13577a.B();
            }
        } while (iB == i10);
        this.f13580d = iB;
    }

    @Override // androidx.datastore.preferences.protobuf.Y
    public int getFieldNumber() throws IOException {
        int i10 = this.f13580d;
        if (i10 != 0) {
            this.f13578b = i10;
            this.f13580d = 0;
        } else {
            this.f13578b = this.f13577a.B();
        }
        int i11 = this.f13578b;
        if (i11 == 0 || i11 == this.f13579c) {
            return Integer.MAX_VALUE;
        }
        return WireFormat.a(i11);
    }

    @Override // androidx.datastore.preferences.protobuf.Y
    public int getTag() {
        return this.f13578b;
    }

    public void l(List<String> list, boolean z10) throws IOException {
        int iB;
        int iB2;
        if (WireFormat.b(this.f13578b) != 2) {
            throw InvalidProtocolBufferException.d();
        }
        if (!(list instanceof A) || z10) {
            do {
                list.add(z10 ? readStringRequireUtf8() : readString());
                if (this.f13577a.e()) {
                    return;
                } else {
                    iB = this.f13577a.B();
                }
            } while (iB == this.f13578b);
            this.f13580d = iB;
            return;
        }
        A a10 = (A) list;
        do {
            a10.F(readBytes());
            if (this.f13577a.e()) {
                return;
            } else {
                iB2 = this.f13577a.B();
            }
        } while (iB2 == this.f13578b);
        this.f13580d = iB2;
    }

    @Override // androidx.datastore.preferences.protobuf.Y
    public boolean readBool() throws IOException {
        n(0);
        return this.f13577a.m();
    }

    @Override // androidx.datastore.preferences.protobuf.Y
    public void readBoolList(List<Boolean> list) throws IOException {
        int iB;
        int iB2;
        if (!(list instanceof C1343f)) {
            int iB3 = WireFormat.b(this.f13578b);
            if (iB3 == 0) {
                do {
                    list.add(Boolean.valueOf(this.f13577a.m()));
                    if (this.f13577a.e()) {
                        return;
                    } else {
                        iB = this.f13577a.B();
                    }
                } while (iB == this.f13578b);
                this.f13580d = iB;
                return;
            }
            if (iB3 != 2) {
                throw InvalidProtocolBufferException.d();
            }
            int iD = this.f13577a.d() + this.f13577a.C();
            do {
                list.add(Boolean.valueOf(this.f13577a.m()));
            } while (this.f13577a.d() < iD);
            m(iD);
            return;
        }
        C1343f c1343f = (C1343f) list;
        int iB4 = WireFormat.b(this.f13578b);
        if (iB4 == 0) {
            do {
                c1343f.addBoolean(this.f13577a.m());
                if (this.f13577a.e()) {
                    return;
                } else {
                    iB2 = this.f13577a.B();
                }
            } while (iB2 == this.f13578b);
            this.f13580d = iB2;
            return;
        }
        if (iB4 != 2) {
            throw InvalidProtocolBufferException.d();
        }
        int iD2 = this.f13577a.d() + this.f13577a.C();
        do {
            c1343f.addBoolean(this.f13577a.m());
        } while (this.f13577a.d() < iD2);
        m(iD2);
    }

    @Override // androidx.datastore.preferences.protobuf.Y
    public ByteString readBytes() throws IOException {
        n(2);
        return this.f13577a.n();
    }

    @Override // androidx.datastore.preferences.protobuf.Y
    public void readBytesList(List<ByteString> list) throws IOException {
        int iB;
        if (WireFormat.b(this.f13578b) != 2) {
            throw InvalidProtocolBufferException.d();
        }
        do {
            list.add(readBytes());
            if (this.f13577a.e()) {
                return;
            } else {
                iB = this.f13577a.B();
            }
        } while (iB == this.f13578b);
        this.f13580d = iB;
    }

    @Override // androidx.datastore.preferences.protobuf.Y
    public double readDouble() throws IOException {
        n(1);
        return this.f13577a.o();
    }

    @Override // androidx.datastore.preferences.protobuf.Y
    public void readDoubleList(List<Double> list) throws IOException {
        int iB;
        int iB2;
        if (!(list instanceof C1348k)) {
            int iB3 = WireFormat.b(this.f13578b);
            if (iB3 == 1) {
                do {
                    list.add(Double.valueOf(this.f13577a.o()));
                    if (this.f13577a.e()) {
                        return;
                    } else {
                        iB = this.f13577a.B();
                    }
                } while (iB == this.f13578b);
                this.f13580d = iB;
                return;
            }
            if (iB3 != 2) {
                throw InvalidProtocolBufferException.d();
            }
            int iC = this.f13577a.C();
            p(iC);
            int iD = this.f13577a.d() + iC;
            do {
                list.add(Double.valueOf(this.f13577a.o()));
            } while (this.f13577a.d() < iD);
            return;
        }
        C1348k c1348k = (C1348k) list;
        int iB4 = WireFormat.b(this.f13578b);
        if (iB4 == 1) {
            do {
                c1348k.addDouble(this.f13577a.o());
                if (this.f13577a.e()) {
                    return;
                } else {
                    iB2 = this.f13577a.B();
                }
            } while (iB2 == this.f13578b);
            this.f13580d = iB2;
            return;
        }
        if (iB4 != 2) {
            throw InvalidProtocolBufferException.d();
        }
        int iC2 = this.f13577a.C();
        p(iC2);
        int iD2 = this.f13577a.d() + iC2;
        do {
            c1348k.addDouble(this.f13577a.o());
        } while (this.f13577a.d() < iD2);
    }

    @Override // androidx.datastore.preferences.protobuf.Y
    public int readEnum() throws IOException {
        n(0);
        return this.f13577a.p();
    }

    @Override // androidx.datastore.preferences.protobuf.Y
    public void readEnumList(List<Integer> list) throws IOException {
        int iB;
        int iB2;
        if (!(list instanceof C1358v)) {
            int iB3 = WireFormat.b(this.f13578b);
            if (iB3 == 0) {
                do {
                    list.add(Integer.valueOf(this.f13577a.p()));
                    if (this.f13577a.e()) {
                        return;
                    } else {
                        iB = this.f13577a.B();
                    }
                } while (iB == this.f13578b);
                this.f13580d = iB;
                return;
            }
            if (iB3 != 2) {
                throw InvalidProtocolBufferException.d();
            }
            int iD = this.f13577a.d() + this.f13577a.C();
            do {
                list.add(Integer.valueOf(this.f13577a.p()));
            } while (this.f13577a.d() < iD);
            m(iD);
            return;
        }
        C1358v c1358v = (C1358v) list;
        int iB4 = WireFormat.b(this.f13578b);
        if (iB4 == 0) {
            do {
                c1358v.addInt(this.f13577a.p());
                if (this.f13577a.e()) {
                    return;
                } else {
                    iB2 = this.f13577a.B();
                }
            } while (iB2 == this.f13578b);
            this.f13580d = iB2;
            return;
        }
        if (iB4 != 2) {
            throw InvalidProtocolBufferException.d();
        }
        int iD2 = this.f13577a.d() + this.f13577a.C();
        do {
            c1358v.addInt(this.f13577a.p());
        } while (this.f13577a.d() < iD2);
        m(iD2);
    }

    @Override // androidx.datastore.preferences.protobuf.Y
    public int readFixed32() throws IOException {
        n(5);
        return this.f13577a.q();
    }

    @Override // androidx.datastore.preferences.protobuf.Y
    public void readFixed32List(List<Integer> list) throws IOException {
        int iB;
        int iB2;
        if (!(list instanceof C1358v)) {
            int iB3 = WireFormat.b(this.f13578b);
            if (iB3 == 2) {
                int iC = this.f13577a.C();
                o(iC);
                int iD = this.f13577a.d() + iC;
                do {
                    list.add(Integer.valueOf(this.f13577a.q()));
                } while (this.f13577a.d() < iD);
                return;
            }
            if (iB3 != 5) {
                throw InvalidProtocolBufferException.d();
            }
            do {
                list.add(Integer.valueOf(this.f13577a.q()));
                if (this.f13577a.e()) {
                    return;
                } else {
                    iB = this.f13577a.B();
                }
            } while (iB == this.f13578b);
            this.f13580d = iB;
            return;
        }
        C1358v c1358v = (C1358v) list;
        int iB4 = WireFormat.b(this.f13578b);
        if (iB4 == 2) {
            int iC2 = this.f13577a.C();
            o(iC2);
            int iD2 = this.f13577a.d() + iC2;
            do {
                c1358v.addInt(this.f13577a.q());
            } while (this.f13577a.d() < iD2);
            return;
        }
        if (iB4 != 5) {
            throw InvalidProtocolBufferException.d();
        }
        do {
            c1358v.addInt(this.f13577a.q());
            if (this.f13577a.e()) {
                return;
            } else {
                iB2 = this.f13577a.B();
            }
        } while (iB2 == this.f13578b);
        this.f13580d = iB2;
    }

    @Override // androidx.datastore.preferences.protobuf.Y
    public long readFixed64() throws IOException {
        n(1);
        return this.f13577a.r();
    }

    @Override // androidx.datastore.preferences.protobuf.Y
    public void readFixed64List(List<Long> list) throws IOException {
        int iB;
        int iB2;
        if (!(list instanceof C)) {
            int iB3 = WireFormat.b(this.f13578b);
            if (iB3 == 1) {
                do {
                    list.add(Long.valueOf(this.f13577a.r()));
                    if (this.f13577a.e()) {
                        return;
                    } else {
                        iB = this.f13577a.B();
                    }
                } while (iB == this.f13578b);
                this.f13580d = iB;
                return;
            }
            if (iB3 != 2) {
                throw InvalidProtocolBufferException.d();
            }
            int iC = this.f13577a.C();
            p(iC);
            int iD = this.f13577a.d() + iC;
            do {
                list.add(Long.valueOf(this.f13577a.r()));
            } while (this.f13577a.d() < iD);
            return;
        }
        C c10 = (C) list;
        int iB4 = WireFormat.b(this.f13578b);
        if (iB4 == 1) {
            do {
                c10.addLong(this.f13577a.r());
                if (this.f13577a.e()) {
                    return;
                } else {
                    iB2 = this.f13577a.B();
                }
            } while (iB2 == this.f13578b);
            this.f13580d = iB2;
            return;
        }
        if (iB4 != 2) {
            throw InvalidProtocolBufferException.d();
        }
        int iC2 = this.f13577a.C();
        p(iC2);
        int iD2 = this.f13577a.d() + iC2;
        do {
            c10.addLong(this.f13577a.r());
        } while (this.f13577a.d() < iD2);
    }

    @Override // androidx.datastore.preferences.protobuf.Y
    public float readFloat() throws IOException {
        n(5);
        return this.f13577a.s();
    }

    @Override // androidx.datastore.preferences.protobuf.Y
    public void readFloatList(List<Float> list) throws IOException {
        int iB;
        int iB2;
        if (!(list instanceof C1356t)) {
            int iB3 = WireFormat.b(this.f13578b);
            if (iB3 == 2) {
                int iC = this.f13577a.C();
                o(iC);
                int iD = this.f13577a.d() + iC;
                do {
                    list.add(Float.valueOf(this.f13577a.s()));
                } while (this.f13577a.d() < iD);
                return;
            }
            if (iB3 != 5) {
                throw InvalidProtocolBufferException.d();
            }
            do {
                list.add(Float.valueOf(this.f13577a.s()));
                if (this.f13577a.e()) {
                    return;
                } else {
                    iB = this.f13577a.B();
                }
            } while (iB == this.f13578b);
            this.f13580d = iB;
            return;
        }
        C1356t c1356t = (C1356t) list;
        int iB4 = WireFormat.b(this.f13578b);
        if (iB4 == 2) {
            int iC2 = this.f13577a.C();
            o(iC2);
            int iD2 = this.f13577a.d() + iC2;
            do {
                c1356t.addFloat(this.f13577a.s());
            } while (this.f13577a.d() < iD2);
            return;
        }
        if (iB4 != 5) {
            throw InvalidProtocolBufferException.d();
        }
        do {
            c1356t.addFloat(this.f13577a.s());
            if (this.f13577a.e()) {
                return;
            } else {
                iB2 = this.f13577a.B();
            }
        } while (iB2 == this.f13578b);
        this.f13580d = iB2;
    }

    @Override // androidx.datastore.preferences.protobuf.Y
    public int readInt32() throws IOException {
        n(0);
        return this.f13577a.t();
    }

    @Override // androidx.datastore.preferences.protobuf.Y
    public void readInt32List(List<Integer> list) throws IOException {
        int iB;
        int iB2;
        if (!(list instanceof C1358v)) {
            int iB3 = WireFormat.b(this.f13578b);
            if (iB3 == 0) {
                do {
                    list.add(Integer.valueOf(this.f13577a.t()));
                    if (this.f13577a.e()) {
                        return;
                    } else {
                        iB = this.f13577a.B();
                    }
                } while (iB == this.f13578b);
                this.f13580d = iB;
                return;
            }
            if (iB3 != 2) {
                throw InvalidProtocolBufferException.d();
            }
            int iD = this.f13577a.d() + this.f13577a.C();
            do {
                list.add(Integer.valueOf(this.f13577a.t()));
            } while (this.f13577a.d() < iD);
            m(iD);
            return;
        }
        C1358v c1358v = (C1358v) list;
        int iB4 = WireFormat.b(this.f13578b);
        if (iB4 == 0) {
            do {
                c1358v.addInt(this.f13577a.t());
                if (this.f13577a.e()) {
                    return;
                } else {
                    iB2 = this.f13577a.B();
                }
            } while (iB2 == this.f13578b);
            this.f13580d = iB2;
            return;
        }
        if (iB4 != 2) {
            throw InvalidProtocolBufferException.d();
        }
        int iD2 = this.f13577a.d() + this.f13577a.C();
        do {
            c1358v.addInt(this.f13577a.t());
        } while (this.f13577a.d() < iD2);
        m(iD2);
    }

    @Override // androidx.datastore.preferences.protobuf.Y
    public long readInt64() throws IOException {
        n(0);
        return this.f13577a.u();
    }

    @Override // androidx.datastore.preferences.protobuf.Y
    public void readInt64List(List<Long> list) throws IOException {
        int iB;
        int iB2;
        if (!(list instanceof C)) {
            int iB3 = WireFormat.b(this.f13578b);
            if (iB3 == 0) {
                do {
                    list.add(Long.valueOf(this.f13577a.u()));
                    if (this.f13577a.e()) {
                        return;
                    } else {
                        iB = this.f13577a.B();
                    }
                } while (iB == this.f13578b);
                this.f13580d = iB;
                return;
            }
            if (iB3 != 2) {
                throw InvalidProtocolBufferException.d();
            }
            int iD = this.f13577a.d() + this.f13577a.C();
            do {
                list.add(Long.valueOf(this.f13577a.u()));
            } while (this.f13577a.d() < iD);
            m(iD);
            return;
        }
        C c10 = (C) list;
        int iB4 = WireFormat.b(this.f13578b);
        if (iB4 == 0) {
            do {
                c10.addLong(this.f13577a.u());
                if (this.f13577a.e()) {
                    return;
                } else {
                    iB2 = this.f13577a.B();
                }
            } while (iB2 == this.f13578b);
            this.f13580d = iB2;
            return;
        }
        if (iB4 != 2) {
            throw InvalidProtocolBufferException.d();
        }
        int iD2 = this.f13577a.d() + this.f13577a.C();
        do {
            c10.addLong(this.f13577a.u());
        } while (this.f13577a.d() < iD2);
        m(iD2);
    }

    @Override // androidx.datastore.preferences.protobuf.Y
    public int readSFixed32() throws IOException {
        n(5);
        return this.f13577a.v();
    }

    @Override // androidx.datastore.preferences.protobuf.Y
    public void readSFixed32List(List<Integer> list) throws IOException {
        int iB;
        int iB2;
        if (!(list instanceof C1358v)) {
            int iB3 = WireFormat.b(this.f13578b);
            if (iB3 == 2) {
                int iC = this.f13577a.C();
                o(iC);
                int iD = this.f13577a.d() + iC;
                do {
                    list.add(Integer.valueOf(this.f13577a.v()));
                } while (this.f13577a.d() < iD);
                return;
            }
            if (iB3 != 5) {
                throw InvalidProtocolBufferException.d();
            }
            do {
                list.add(Integer.valueOf(this.f13577a.v()));
                if (this.f13577a.e()) {
                    return;
                } else {
                    iB = this.f13577a.B();
                }
            } while (iB == this.f13578b);
            this.f13580d = iB;
            return;
        }
        C1358v c1358v = (C1358v) list;
        int iB4 = WireFormat.b(this.f13578b);
        if (iB4 == 2) {
            int iC2 = this.f13577a.C();
            o(iC2);
            int iD2 = this.f13577a.d() + iC2;
            do {
                c1358v.addInt(this.f13577a.v());
            } while (this.f13577a.d() < iD2);
            return;
        }
        if (iB4 != 5) {
            throw InvalidProtocolBufferException.d();
        }
        do {
            c1358v.addInt(this.f13577a.v());
            if (this.f13577a.e()) {
                return;
            } else {
                iB2 = this.f13577a.B();
            }
        } while (iB2 == this.f13578b);
        this.f13580d = iB2;
    }

    @Override // androidx.datastore.preferences.protobuf.Y
    public long readSFixed64() throws IOException {
        n(1);
        return this.f13577a.w();
    }

    @Override // androidx.datastore.preferences.protobuf.Y
    public void readSFixed64List(List<Long> list) throws IOException {
        int iB;
        int iB2;
        if (!(list instanceof C)) {
            int iB3 = WireFormat.b(this.f13578b);
            if (iB3 == 1) {
                do {
                    list.add(Long.valueOf(this.f13577a.w()));
                    if (this.f13577a.e()) {
                        return;
                    } else {
                        iB = this.f13577a.B();
                    }
                } while (iB == this.f13578b);
                this.f13580d = iB;
                return;
            }
            if (iB3 != 2) {
                throw InvalidProtocolBufferException.d();
            }
            int iC = this.f13577a.C();
            p(iC);
            int iD = this.f13577a.d() + iC;
            do {
                list.add(Long.valueOf(this.f13577a.w()));
            } while (this.f13577a.d() < iD);
            return;
        }
        C c10 = (C) list;
        int iB4 = WireFormat.b(this.f13578b);
        if (iB4 == 1) {
            do {
                c10.addLong(this.f13577a.w());
                if (this.f13577a.e()) {
                    return;
                } else {
                    iB2 = this.f13577a.B();
                }
            } while (iB2 == this.f13578b);
            this.f13580d = iB2;
            return;
        }
        if (iB4 != 2) {
            throw InvalidProtocolBufferException.d();
        }
        int iC2 = this.f13577a.C();
        p(iC2);
        int iD2 = this.f13577a.d() + iC2;
        do {
            c10.addLong(this.f13577a.w());
        } while (this.f13577a.d() < iD2);
    }

    @Override // androidx.datastore.preferences.protobuf.Y
    public int readSInt32() throws IOException {
        n(0);
        return this.f13577a.x();
    }

    @Override // androidx.datastore.preferences.protobuf.Y
    public void readSInt32List(List<Integer> list) throws IOException {
        int iB;
        int iB2;
        if (!(list instanceof C1358v)) {
            int iB3 = WireFormat.b(this.f13578b);
            if (iB3 == 0) {
                do {
                    list.add(Integer.valueOf(this.f13577a.x()));
                    if (this.f13577a.e()) {
                        return;
                    } else {
                        iB = this.f13577a.B();
                    }
                } while (iB == this.f13578b);
                this.f13580d = iB;
                return;
            }
            if (iB3 != 2) {
                throw InvalidProtocolBufferException.d();
            }
            int iD = this.f13577a.d() + this.f13577a.C();
            do {
                list.add(Integer.valueOf(this.f13577a.x()));
            } while (this.f13577a.d() < iD);
            m(iD);
            return;
        }
        C1358v c1358v = (C1358v) list;
        int iB4 = WireFormat.b(this.f13578b);
        if (iB4 == 0) {
            do {
                c1358v.addInt(this.f13577a.x());
                if (this.f13577a.e()) {
                    return;
                } else {
                    iB2 = this.f13577a.B();
                }
            } while (iB2 == this.f13578b);
            this.f13580d = iB2;
            return;
        }
        if (iB4 != 2) {
            throw InvalidProtocolBufferException.d();
        }
        int iD2 = this.f13577a.d() + this.f13577a.C();
        do {
            c1358v.addInt(this.f13577a.x());
        } while (this.f13577a.d() < iD2);
        m(iD2);
    }

    @Override // androidx.datastore.preferences.protobuf.Y
    public long readSInt64() throws IOException {
        n(0);
        return this.f13577a.y();
    }

    @Override // androidx.datastore.preferences.protobuf.Y
    public void readSInt64List(List<Long> list) throws IOException {
        int iB;
        int iB2;
        if (!(list instanceof C)) {
            int iB3 = WireFormat.b(this.f13578b);
            if (iB3 == 0) {
                do {
                    list.add(Long.valueOf(this.f13577a.y()));
                    if (this.f13577a.e()) {
                        return;
                    } else {
                        iB = this.f13577a.B();
                    }
                } while (iB == this.f13578b);
                this.f13580d = iB;
                return;
            }
            if (iB3 != 2) {
                throw InvalidProtocolBufferException.d();
            }
            int iD = this.f13577a.d() + this.f13577a.C();
            do {
                list.add(Long.valueOf(this.f13577a.y()));
            } while (this.f13577a.d() < iD);
            m(iD);
            return;
        }
        C c10 = (C) list;
        int iB4 = WireFormat.b(this.f13578b);
        if (iB4 == 0) {
            do {
                c10.addLong(this.f13577a.y());
                if (this.f13577a.e()) {
                    return;
                } else {
                    iB2 = this.f13577a.B();
                }
            } while (iB2 == this.f13578b);
            this.f13580d = iB2;
            return;
        }
        if (iB4 != 2) {
            throw InvalidProtocolBufferException.d();
        }
        int iD2 = this.f13577a.d() + this.f13577a.C();
        do {
            c10.addLong(this.f13577a.y());
        } while (this.f13577a.d() < iD2);
        m(iD2);
    }

    @Override // androidx.datastore.preferences.protobuf.Y
    public String readString() throws IOException {
        n(2);
        return this.f13577a.z();
    }

    @Override // androidx.datastore.preferences.protobuf.Y
    public void readStringList(List<String> list) throws IOException {
        l(list, false);
    }

    @Override // androidx.datastore.preferences.protobuf.Y
    public void readStringListRequireUtf8(List<String> list) throws IOException {
        l(list, true);
    }

    @Override // androidx.datastore.preferences.protobuf.Y
    public String readStringRequireUtf8() throws IOException {
        n(2);
        return this.f13577a.A();
    }

    @Override // androidx.datastore.preferences.protobuf.Y
    public int readUInt32() throws IOException {
        n(0);
        return this.f13577a.C();
    }

    @Override // androidx.datastore.preferences.protobuf.Y
    public void readUInt32List(List<Integer> list) throws IOException {
        int iB;
        int iB2;
        if (!(list instanceof C1358v)) {
            int iB3 = WireFormat.b(this.f13578b);
            if (iB3 == 0) {
                do {
                    list.add(Integer.valueOf(this.f13577a.C()));
                    if (this.f13577a.e()) {
                        return;
                    } else {
                        iB = this.f13577a.B();
                    }
                } while (iB == this.f13578b);
                this.f13580d = iB;
                return;
            }
            if (iB3 != 2) {
                throw InvalidProtocolBufferException.d();
            }
            int iD = this.f13577a.d() + this.f13577a.C();
            do {
                list.add(Integer.valueOf(this.f13577a.C()));
            } while (this.f13577a.d() < iD);
            m(iD);
            return;
        }
        C1358v c1358v = (C1358v) list;
        int iB4 = WireFormat.b(this.f13578b);
        if (iB4 == 0) {
            do {
                c1358v.addInt(this.f13577a.C());
                if (this.f13577a.e()) {
                    return;
                } else {
                    iB2 = this.f13577a.B();
                }
            } while (iB2 == this.f13578b);
            this.f13580d = iB2;
            return;
        }
        if (iB4 != 2) {
            throw InvalidProtocolBufferException.d();
        }
        int iD2 = this.f13577a.d() + this.f13577a.C();
        do {
            c1358v.addInt(this.f13577a.C());
        } while (this.f13577a.d() < iD2);
        m(iD2);
    }

    @Override // androidx.datastore.preferences.protobuf.Y
    public long readUInt64() throws IOException {
        n(0);
        return this.f13577a.D();
    }

    @Override // androidx.datastore.preferences.protobuf.Y
    public void readUInt64List(List<Long> list) throws IOException {
        int iB;
        int iB2;
        if (!(list instanceof C)) {
            int iB3 = WireFormat.b(this.f13578b);
            if (iB3 == 0) {
                do {
                    list.add(Long.valueOf(this.f13577a.D()));
                    if (this.f13577a.e()) {
                        return;
                    } else {
                        iB = this.f13577a.B();
                    }
                } while (iB == this.f13578b);
                this.f13580d = iB;
                return;
            }
            if (iB3 != 2) {
                throw InvalidProtocolBufferException.d();
            }
            int iD = this.f13577a.d() + this.f13577a.C();
            do {
                list.add(Long.valueOf(this.f13577a.D()));
            } while (this.f13577a.d() < iD);
            m(iD);
            return;
        }
        C c10 = (C) list;
        int iB4 = WireFormat.b(this.f13578b);
        if (iB4 == 0) {
            do {
                c10.addLong(this.f13577a.D());
                if (this.f13577a.e()) {
                    return;
                } else {
                    iB2 = this.f13577a.B();
                }
            } while (iB2 == this.f13578b);
            this.f13580d = iB2;
            return;
        }
        if (iB4 != 2) {
            throw InvalidProtocolBufferException.d();
        }
        int iD2 = this.f13577a.d() + this.f13577a.C();
        do {
            c10.addLong(this.f13577a.D());
        } while (this.f13577a.d() < iD2);
        m(iD2);
    }

    @Override // androidx.datastore.preferences.protobuf.Y
    public boolean skipField() throws IOException {
        int i10;
        if (this.f13577a.e() || (i10 = this.f13578b) == this.f13579c) {
            return false;
        }
        return this.f13577a.E(i10);
    }
}
