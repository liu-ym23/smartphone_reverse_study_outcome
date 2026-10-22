package com.google.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;
import java.util.List;

/* renamed from: com.google.protobuf.p, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0976p implements InterfaceC0975o2 {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractC0972o f2934a;
    public int b;
    public int c;
    public int d = 0;

    public C0976p(AbstractC0972o abstractC0972o) {
        AbstractC0989s1.a(abstractC0972o, "input");
        this.f2934a = abstractC0972o;
        abstractC0972o.b = this;
    }

    public static void l(int i) throws InvalidProtocolBufferException {
        if ((i & 3) != 0) {
            throw InvalidProtocolBufferException.f();
        }
    }

    public static void m(int i) throws InvalidProtocolBufferException {
        if ((i & 7) != 0) {
            throw InvalidProtocolBufferException.f();
        }
    }

    @Override // com.google.protobuf.InterfaceC0975o2
    public final void a(List list, InterfaceC0979p2 interfaceC0979p2, R0 r02) throws InvalidProtocolBufferException.InvalidWireTypeException {
        int iD;
        int i = this.b;
        if ((i & 7) != 3) {
            throw InvalidProtocolBufferException.c();
        }
        do {
            Object objNewInstance = interfaceC0979p2.newInstance();
            f(objNewInstance, interfaceC0979p2, r02);
            interfaceC0979p2.makeImmutable(objNewInstance);
            list.add(objNewInstance);
            AbstractC0972o abstractC0972o = this.f2934a;
            if (abstractC0972o.g() || this.d != 0) {
                return;
            } else {
                iD = abstractC0972o.D();
            }
        } while (iD == i);
        this.d = iD;
    }

    @Override // com.google.protobuf.InterfaceC0975o2
    public final void b(List list, InterfaceC0979p2 interfaceC0979p2, R0 r02) throws InvalidProtocolBufferException {
        int iD;
        int i = this.b;
        if ((i & 7) != 2) {
            throw InvalidProtocolBufferException.c();
        }
        do {
            Object objNewInstance = interfaceC0979p2.newInstance();
            g(objNewInstance, interfaceC0979p2, r02);
            interfaceC0979p2.makeImmutable(objNewInstance);
            list.add(objNewInstance);
            AbstractC0972o abstractC0972o = this.f2934a;
            if (abstractC0972o.g() || this.d != 0) {
                return;
            } else {
                iD = abstractC0972o.D();
            }
        } while (iD == i);
        this.d = iD;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x005d, code lost:
    
        r10.put(r3, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0060, code lost:
    
        r1.i(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0063, code lost:
    
        return;
     */
    @Override // com.google.protobuf.InterfaceC0975o2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(java.util.Map r10, u1.d r11, com.google.protobuf.R0 r12) throws com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException {
        /*
            r9 = this;
            r0 = 2
            r9.k(r0)
            com.google.protobuf.o r1 = r9.f2934a
            int r2 = r1.E()
            int r2 = r1.j(r2)
            java.lang.Object r3 = r11.c
            java.lang.Object r4 = r11.e
            r5 = r4
        L13:
            int r6 = r9.getFieldNumber()     // Catch: java.lang.Throwable -> L37
            r7 = 2147483647(0x7fffffff, float:NaN)
            if (r6 == r7) goto L5d
            boolean r7 = r1.g()     // Catch: java.lang.Throwable -> L37
            if (r7 == 0) goto L23
            goto L5d
        L23:
            r7 = 1
            java.lang.String r8 = "Unable to parse map entry."
            if (r6 == r7) goto L46
            if (r6 == r0) goto L39
            boolean r6 = r9.skipField()     // Catch: java.lang.Throwable -> L37 com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L50
            if (r6 == 0) goto L31
            goto L13
        L31:
            com.google.protobuf.InvalidProtocolBufferException r6 = new com.google.protobuf.InvalidProtocolBufferException     // Catch: java.lang.Throwable -> L37 com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L50
            r6.<init>(r8)     // Catch: java.lang.Throwable -> L37 com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L50
            throw r6     // Catch: java.lang.Throwable -> L37 com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L50
        L37:
            r9 = move-exception
            goto L64
        L39:
            java.lang.Object r6 = r11.d     // Catch: java.lang.Throwable -> L37 com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L50
            com.google.protobuf.WireFormat$FieldType r6 = (com.google.protobuf.WireFormat$FieldType) r6     // Catch: java.lang.Throwable -> L37 com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L50
            java.lang.Class r7 = r4.getClass()     // Catch: java.lang.Throwable -> L37 com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L50
            java.lang.Object r5 = r9.h(r6, r7, r12)     // Catch: java.lang.Throwable -> L37 com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L50
            goto L13
        L46:
            java.lang.Object r6 = r11.b     // Catch: java.lang.Throwable -> L37 com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L50
            com.google.protobuf.WireFormat$FieldType r6 = (com.google.protobuf.WireFormat$FieldType) r6     // Catch: java.lang.Throwable -> L37 com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L50
            r7 = 0
            java.lang.Object r3 = r9.h(r6, r7, r7)     // Catch: java.lang.Throwable -> L37 com.google.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L50
            goto L13
        L50:
            boolean r6 = r9.skipField()     // Catch: java.lang.Throwable -> L37
            if (r6 == 0) goto L57
            goto L13
        L57:
            com.google.protobuf.InvalidProtocolBufferException r9 = new com.google.protobuf.InvalidProtocolBufferException     // Catch: java.lang.Throwable -> L37
            r9.<init>(r8)     // Catch: java.lang.Throwable -> L37
            throw r9     // Catch: java.lang.Throwable -> L37
        L5d:
            r10.put(r3, r5)     // Catch: java.lang.Throwable -> L37
            r1.i(r2)
            return
        L64:
            r1.i(r2)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.C0976p.c(java.util.Map, u1.d, com.google.protobuf.R0):void");
    }

    @Override // com.google.protobuf.InterfaceC0975o2
    public final void d(Object obj, InterfaceC0979p2 interfaceC0979p2, R0 r02) throws InvalidProtocolBufferException.InvalidWireTypeException {
        k(3);
        f(obj, interfaceC0979p2, r02);
    }

    @Override // com.google.protobuf.InterfaceC0975o2
    public final void e(Object obj, InterfaceC0979p2 interfaceC0979p2, R0 r02) throws InvalidProtocolBufferException {
        k(2);
        g(obj, interfaceC0979p2, r02);
    }

    public final void f(Object obj, InterfaceC0979p2 interfaceC0979p2, R0 r02) {
        int i = this.c;
        this.c = ((this.b >>> 3) << 3) | 4;
        try {
            interfaceC0979p2.c(obj, this, r02);
            if (this.b == this.c) {
            } else {
                throw InvalidProtocolBufferException.f();
            }
        } finally {
            this.c = i;
        }
    }

    public final void g(Object obj, InterfaceC0979p2 interfaceC0979p2, R0 r02) throws InvalidProtocolBufferException {
        AbstractC0972o abstractC0972o = this.f2934a;
        int iE = abstractC0972o.E();
        if (abstractC0972o.f2933a >= 100) {
            throw new InvalidProtocolBufferException("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        int iJ = abstractC0972o.j(iE);
        abstractC0972o.f2933a++;
        interfaceC0979p2.c(obj, this, r02);
        abstractC0972o.a(0);
        abstractC0972o.f2933a--;
        abstractC0972o.i(iJ);
    }

    @Override // com.google.protobuf.InterfaceC0975o2
    public final int getFieldNumber() {
        int i = this.d;
        if (i != 0) {
            this.b = i;
            this.d = 0;
        } else {
            this.b = this.f2934a.D();
        }
        int i6 = this.b;
        if (i6 == 0 || i6 == this.c) {
            return Integer.MAX_VALUE;
        }
        return i6 >>> 3;
    }

    @Override // com.google.protobuf.InterfaceC0975o2
    public final int getTag() {
        return this.b;
    }

    public final Object h(WireFormat$FieldType wireFormat$FieldType, Class cls, R0 r02) throws InvalidProtocolBufferException {
        switch (wireFormat$FieldType.ordinal()) {
            case 0:
                return Double.valueOf(readDouble());
            case 1:
                return Float.valueOf(readFloat());
            case 2:
                return Long.valueOf(readInt64());
            case 3:
                return Long.valueOf(readUInt64());
            case 4:
                return Integer.valueOf(readInt32());
            case 5:
                return Long.valueOf(readFixed64());
            case 6:
                return Integer.valueOf(readFixed32());
            case 7:
                return Boolean.valueOf(readBool());
            case 8:
                return readStringRequireUtf8();
            case 9:
            default:
                throw new IllegalArgumentException("unsupported field type.");
            case 10:
                k(2);
                InterfaceC0979p2 interfaceC0979p2A = C0963l2.c.a(cls);
                Object objNewInstance = interfaceC0979p2A.newInstance();
                g(objNewInstance, interfaceC0979p2A, r02);
                interfaceC0979p2A.makeImmutable(objNewInstance);
                return objNewInstance;
            case 11:
                return readBytes();
            case 12:
                return Integer.valueOf(readUInt32());
            case 13:
                return Integer.valueOf(readEnum());
            case 14:
                return Integer.valueOf(readSFixed32());
            case 15:
                return Long.valueOf(readSFixed64());
            case 16:
                return Integer.valueOf(readSInt32());
            case 17:
                return Long.valueOf(readSInt64());
        }
    }

    public final void i(List list, boolean z10) throws InvalidProtocolBufferException.InvalidWireTypeException {
        int iD;
        int iD2;
        if ((this.b & 7) != 2) {
            throw InvalidProtocolBufferException.c();
        }
        boolean z11 = list instanceof InterfaceC1009x1;
        AbstractC0972o abstractC0972o = this.f2934a;
        if (!z11 || z10) {
            do {
                list.add(z10 ? readStringRequireUtf8() : readString());
                if (abstractC0972o.g()) {
                    return;
                } else {
                    iD = abstractC0972o.D();
                }
            } while (iD == this.b);
            this.d = iD;
            return;
        }
        InterfaceC1009x1 interfaceC1009x1 = (InterfaceC1009x1) list;
        do {
            interfaceC1009x1.a(readBytes());
            if (abstractC0972o.g()) {
                return;
            } else {
                iD2 = abstractC0972o.D();
            }
        } while (iD2 == this.b);
        this.d = iD2;
    }

    public final void j(int i) throws InvalidProtocolBufferException {
        if (this.f2934a.f() != i) {
            throw InvalidProtocolBufferException.g();
        }
    }

    public final void k(int i) throws InvalidProtocolBufferException.InvalidWireTypeException {
        if ((this.b & 7) != i) {
            throw InvalidProtocolBufferException.c();
        }
    }

    @Override // com.google.protobuf.InterfaceC0975o2
    public final boolean readBool() throws InvalidProtocolBufferException.InvalidWireTypeException {
        k(0);
        return this.f2934a.k();
    }

    @Override // com.google.protobuf.InterfaceC0975o2
    public final void readBoolList(List list) throws InvalidProtocolBufferException {
        int iD;
        int iD2;
        boolean z10 = list instanceof AbstractC0952j;
        AbstractC0972o abstractC0972o = this.f2934a;
        if (!z10) {
            int i = this.b & 7;
            if (i == 0) {
                do {
                    list.add(Boolean.valueOf(abstractC0972o.k()));
                    if (abstractC0972o.g()) {
                        return;
                    } else {
                        iD = abstractC0972o.D();
                    }
                } while (iD == this.b);
                this.d = iD;
                return;
            }
            if (i != 2) {
                throw InvalidProtocolBufferException.c();
            }
            int iF = abstractC0972o.f() + abstractC0972o.E();
            do {
                list.add(Boolean.valueOf(abstractC0972o.k()));
            } while (abstractC0972o.f() < iF);
            j(iF);
            return;
        }
        AbstractC0952j abstractC0952j = (AbstractC0952j) list;
        int i6 = this.b & 7;
        if (i6 == 0) {
            do {
                abstractC0952j.addBoolean(abstractC0972o.k());
                if (abstractC0972o.g()) {
                    return;
                } else {
                    iD2 = abstractC0972o.D();
                }
            } while (iD2 == this.b);
            this.d = iD2;
            return;
        }
        if (i6 != 2) {
            throw InvalidProtocolBufferException.c();
        }
        int iF2 = abstractC0972o.f() + abstractC0972o.E();
        do {
            abstractC0952j.addBoolean(abstractC0972o.k());
        } while (abstractC0972o.f() < iF2);
        j(iF2);
    }

    @Override // com.google.protobuf.InterfaceC0975o2
    public final ByteString readBytes() throws InvalidProtocolBufferException.InvalidWireTypeException {
        k(2);
        return this.f2934a.l();
    }

    @Override // com.google.protobuf.InterfaceC0975o2
    public final void readBytesList(List list) throws InvalidProtocolBufferException.InvalidWireTypeException {
        int iD;
        if ((this.b & 7) != 2) {
            throw InvalidProtocolBufferException.c();
        }
        do {
            list.add(readBytes());
            AbstractC0972o abstractC0972o = this.f2934a;
            if (abstractC0972o.g()) {
                return;
            } else {
                iD = abstractC0972o.D();
            }
        } while (iD == this.b);
        this.d = iD;
    }

    @Override // com.google.protobuf.InterfaceC0975o2
    public final double readDouble() throws InvalidProtocolBufferException.InvalidWireTypeException {
        k(1);
        return this.f2934a.m();
    }

    @Override // com.google.protobuf.InterfaceC0975o2
    public final void readDoubleList(List list) throws InvalidProtocolBufferException {
        int iD;
        int iD2;
        boolean z10 = list instanceof K0;
        AbstractC0972o abstractC0972o = this.f2934a;
        if (!z10) {
            int i = this.b & 7;
            if (i == 1) {
                do {
                    list.add(Double.valueOf(abstractC0972o.m()));
                    if (abstractC0972o.g()) {
                        return;
                    } else {
                        iD = abstractC0972o.D();
                    }
                } while (iD == this.b);
                this.d = iD;
                return;
            }
            if (i != 2) {
                throw InvalidProtocolBufferException.c();
            }
            int iE = abstractC0972o.E();
            m(iE);
            int iF = abstractC0972o.f() + iE;
            do {
                list.add(Double.valueOf(abstractC0972o.m()));
            } while (abstractC0972o.f() < iF);
            return;
        }
        K0 k02 = (K0) list;
        int i6 = this.b & 7;
        if (i6 == 1) {
            do {
                k02.addDouble(abstractC0972o.m());
                if (abstractC0972o.g()) {
                    return;
                } else {
                    iD2 = abstractC0972o.D();
                }
            } while (iD2 == this.b);
            this.d = iD2;
            return;
        }
        if (i6 != 2) {
            throw InvalidProtocolBufferException.c();
        }
        int iE2 = abstractC0972o.E();
        m(iE2);
        int iF2 = abstractC0972o.f() + iE2;
        do {
            k02.addDouble(abstractC0972o.m());
        } while (abstractC0972o.f() < iF2);
    }

    @Override // com.google.protobuf.InterfaceC0975o2
    public final int readEnum() throws InvalidProtocolBufferException.InvalidWireTypeException {
        k(0);
        return this.f2934a.n();
    }

    @Override // com.google.protobuf.InterfaceC0975o2
    public final void readEnumList(List list) throws InvalidProtocolBufferException {
        int iD;
        int iD2;
        boolean z10 = list instanceof C0970n1;
        AbstractC0972o abstractC0972o = this.f2934a;
        if (!z10) {
            int i = this.b & 7;
            if (i == 0) {
                do {
                    list.add(Integer.valueOf(abstractC0972o.n()));
                    if (abstractC0972o.g()) {
                        return;
                    } else {
                        iD = abstractC0972o.D();
                    }
                } while (iD == this.b);
                this.d = iD;
                return;
            }
            if (i != 2) {
                throw InvalidProtocolBufferException.c();
            }
            int iF = abstractC0972o.f() + abstractC0972o.E();
            do {
                list.add(Integer.valueOf(abstractC0972o.n()));
            } while (abstractC0972o.f() < iF);
            j(iF);
            return;
        }
        C0970n1 c0970n1 = (C0970n1) list;
        int i6 = this.b & 7;
        if (i6 == 0) {
            do {
                c0970n1.addInt(abstractC0972o.n());
                if (abstractC0972o.g()) {
                    return;
                } else {
                    iD2 = abstractC0972o.D();
                }
            } while (iD2 == this.b);
            this.d = iD2;
            return;
        }
        if (i6 != 2) {
            throw InvalidProtocolBufferException.c();
        }
        int iF2 = abstractC0972o.f() + abstractC0972o.E();
        do {
            c0970n1.addInt(abstractC0972o.n());
        } while (abstractC0972o.f() < iF2);
        j(iF2);
    }

    @Override // com.google.protobuf.InterfaceC0975o2
    public final int readFixed32() throws InvalidProtocolBufferException.InvalidWireTypeException {
        k(5);
        return this.f2934a.o();
    }

    @Override // com.google.protobuf.InterfaceC0975o2
    public final void readFixed32List(List list) throws InvalidProtocolBufferException {
        int iD;
        int iD2;
        boolean z10 = list instanceof C0970n1;
        AbstractC0972o abstractC0972o = this.f2934a;
        if (!z10) {
            int i = this.b & 7;
            if (i == 2) {
                int iE = abstractC0972o.E();
                l(iE);
                int iF = abstractC0972o.f() + iE;
                do {
                    list.add(Integer.valueOf(abstractC0972o.o()));
                } while (abstractC0972o.f() < iF);
                return;
            }
            if (i != 5) {
                throw InvalidProtocolBufferException.c();
            }
            do {
                list.add(Integer.valueOf(abstractC0972o.o()));
                if (abstractC0972o.g()) {
                    return;
                } else {
                    iD = abstractC0972o.D();
                }
            } while (iD == this.b);
            this.d = iD;
            return;
        }
        C0970n1 c0970n1 = (C0970n1) list;
        int i6 = this.b & 7;
        if (i6 == 2) {
            int iE2 = abstractC0972o.E();
            l(iE2);
            int iF2 = abstractC0972o.f() + iE2;
            do {
                c0970n1.addInt(abstractC0972o.o());
            } while (abstractC0972o.f() < iF2);
            return;
        }
        if (i6 != 5) {
            throw InvalidProtocolBufferException.c();
        }
        do {
            c0970n1.addInt(abstractC0972o.o());
            if (abstractC0972o.g()) {
                return;
            } else {
                iD2 = abstractC0972o.D();
            }
        } while (iD2 == this.b);
        this.d = iD2;
    }

    @Override // com.google.protobuf.InterfaceC0975o2
    public final long readFixed64() throws InvalidProtocolBufferException.InvalidWireTypeException {
        k(1);
        return this.f2934a.p();
    }

    @Override // com.google.protobuf.InterfaceC0975o2
    public final void readFixed64List(List list) throws InvalidProtocolBufferException {
        int iD;
        int iD2;
        boolean z10 = list instanceof D1;
        AbstractC0972o abstractC0972o = this.f2934a;
        if (!z10) {
            int i = this.b & 7;
            if (i == 1) {
                do {
                    list.add(Long.valueOf(abstractC0972o.p()));
                    if (abstractC0972o.g()) {
                        return;
                    } else {
                        iD = abstractC0972o.D();
                    }
                } while (iD == this.b);
                this.d = iD;
                return;
            }
            if (i != 2) {
                throw InvalidProtocolBufferException.c();
            }
            int iE = abstractC0972o.E();
            m(iE);
            int iF = abstractC0972o.f() + iE;
            do {
                list.add(Long.valueOf(abstractC0972o.p()));
            } while (abstractC0972o.f() < iF);
            return;
        }
        D1 d12 = (D1) list;
        int i6 = this.b & 7;
        if (i6 == 1) {
            do {
                d12.addLong(abstractC0972o.p());
                if (abstractC0972o.g()) {
                    return;
                } else {
                    iD2 = abstractC0972o.D();
                }
            } while (iD2 == this.b);
            this.d = iD2;
            return;
        }
        if (i6 != 2) {
            throw InvalidProtocolBufferException.c();
        }
        int iE2 = abstractC0972o.E();
        m(iE2);
        int iF2 = abstractC0972o.f() + iE2;
        do {
            d12.addLong(abstractC0972o.p());
        } while (abstractC0972o.f() < iF2);
    }

    @Override // com.google.protobuf.InterfaceC0975o2
    public final float readFloat() throws InvalidProtocolBufferException.InvalidWireTypeException {
        k(5);
        return this.f2934a.q();
    }

    @Override // com.google.protobuf.InterfaceC0975o2
    public final void readFloatList(List list) throws InvalidProtocolBufferException {
        int iD;
        int iD2;
        boolean z10 = list instanceof Z0;
        AbstractC0972o abstractC0972o = this.f2934a;
        if (!z10) {
            int i = this.b & 7;
            if (i == 2) {
                int iE = abstractC0972o.E();
                l(iE);
                int iF = abstractC0972o.f() + iE;
                do {
                    list.add(Float.valueOf(abstractC0972o.q()));
                } while (abstractC0972o.f() < iF);
                return;
            }
            if (i != 5) {
                throw InvalidProtocolBufferException.c();
            }
            do {
                list.add(Float.valueOf(abstractC0972o.q()));
                if (abstractC0972o.g()) {
                    return;
                } else {
                    iD = abstractC0972o.D();
                }
            } while (iD == this.b);
            this.d = iD;
            return;
        }
        Z0 z02 = (Z0) list;
        int i6 = this.b & 7;
        if (i6 == 2) {
            int iE2 = abstractC0972o.E();
            l(iE2);
            int iF2 = abstractC0972o.f() + iE2;
            do {
                z02.addFloat(abstractC0972o.q());
            } while (abstractC0972o.f() < iF2);
            return;
        }
        if (i6 != 5) {
            throw InvalidProtocolBufferException.c();
        }
        do {
            z02.addFloat(abstractC0972o.q());
            if (abstractC0972o.g()) {
                return;
            } else {
                iD2 = abstractC0972o.D();
            }
        } while (iD2 == this.b);
        this.d = iD2;
    }

    @Override // com.google.protobuf.InterfaceC0975o2
    public final int readInt32() throws InvalidProtocolBufferException.InvalidWireTypeException {
        k(0);
        return this.f2934a.s();
    }

    @Override // com.google.protobuf.InterfaceC0975o2
    public final void readInt32List(List list) throws InvalidProtocolBufferException {
        int iD;
        int iD2;
        boolean z10 = list instanceof C0970n1;
        AbstractC0972o abstractC0972o = this.f2934a;
        if (!z10) {
            int i = this.b & 7;
            if (i == 0) {
                do {
                    list.add(Integer.valueOf(abstractC0972o.s()));
                    if (abstractC0972o.g()) {
                        return;
                    } else {
                        iD = abstractC0972o.D();
                    }
                } while (iD == this.b);
                this.d = iD;
                return;
            }
            if (i != 2) {
                throw InvalidProtocolBufferException.c();
            }
            int iF = abstractC0972o.f() + abstractC0972o.E();
            do {
                list.add(Integer.valueOf(abstractC0972o.s()));
            } while (abstractC0972o.f() < iF);
            j(iF);
            return;
        }
        C0970n1 c0970n1 = (C0970n1) list;
        int i6 = this.b & 7;
        if (i6 == 0) {
            do {
                c0970n1.addInt(abstractC0972o.s());
                if (abstractC0972o.g()) {
                    return;
                } else {
                    iD2 = abstractC0972o.D();
                }
            } while (iD2 == this.b);
            this.d = iD2;
            return;
        }
        if (i6 != 2) {
            throw InvalidProtocolBufferException.c();
        }
        int iF2 = abstractC0972o.f() + abstractC0972o.E();
        do {
            c0970n1.addInt(abstractC0972o.s());
        } while (abstractC0972o.f() < iF2);
        j(iF2);
    }

    @Override // com.google.protobuf.InterfaceC0975o2
    public final long readInt64() throws InvalidProtocolBufferException.InvalidWireTypeException {
        k(0);
        return this.f2934a.t();
    }

    @Override // com.google.protobuf.InterfaceC0975o2
    public final void readInt64List(List list) throws InvalidProtocolBufferException {
        int iD;
        int iD2;
        boolean z10 = list instanceof D1;
        AbstractC0972o abstractC0972o = this.f2934a;
        if (!z10) {
            int i = this.b & 7;
            if (i == 0) {
                do {
                    list.add(Long.valueOf(abstractC0972o.t()));
                    if (abstractC0972o.g()) {
                        return;
                    } else {
                        iD = abstractC0972o.D();
                    }
                } while (iD == this.b);
                this.d = iD;
                return;
            }
            if (i != 2) {
                throw InvalidProtocolBufferException.c();
            }
            int iF = abstractC0972o.f() + abstractC0972o.E();
            do {
                list.add(Long.valueOf(abstractC0972o.t()));
            } while (abstractC0972o.f() < iF);
            j(iF);
            return;
        }
        D1 d12 = (D1) list;
        int i6 = this.b & 7;
        if (i6 == 0) {
            do {
                d12.addLong(abstractC0972o.t());
                if (abstractC0972o.g()) {
                    return;
                } else {
                    iD2 = abstractC0972o.D();
                }
            } while (iD2 == this.b);
            this.d = iD2;
            return;
        }
        if (i6 != 2) {
            throw InvalidProtocolBufferException.c();
        }
        int iF2 = abstractC0972o.f() + abstractC0972o.E();
        do {
            d12.addLong(abstractC0972o.t());
        } while (abstractC0972o.f() < iF2);
        j(iF2);
    }

    @Override // com.google.protobuf.InterfaceC0975o2
    public final int readSFixed32() throws InvalidProtocolBufferException.InvalidWireTypeException {
        k(5);
        return this.f2934a.x();
    }

    @Override // com.google.protobuf.InterfaceC0975o2
    public final void readSFixed32List(List list) throws InvalidProtocolBufferException {
        int iD;
        int iD2;
        boolean z10 = list instanceof C0970n1;
        AbstractC0972o abstractC0972o = this.f2934a;
        if (!z10) {
            int i = this.b & 7;
            if (i == 2) {
                int iE = abstractC0972o.E();
                l(iE);
                int iF = abstractC0972o.f() + iE;
                do {
                    list.add(Integer.valueOf(abstractC0972o.x()));
                } while (abstractC0972o.f() < iF);
                return;
            }
            if (i != 5) {
                throw InvalidProtocolBufferException.c();
            }
            do {
                list.add(Integer.valueOf(abstractC0972o.x()));
                if (abstractC0972o.g()) {
                    return;
                } else {
                    iD = abstractC0972o.D();
                }
            } while (iD == this.b);
            this.d = iD;
            return;
        }
        C0970n1 c0970n1 = (C0970n1) list;
        int i6 = this.b & 7;
        if (i6 == 2) {
            int iE2 = abstractC0972o.E();
            l(iE2);
            int iF2 = abstractC0972o.f() + iE2;
            do {
                c0970n1.addInt(abstractC0972o.x());
            } while (abstractC0972o.f() < iF2);
            return;
        }
        if (i6 != 5) {
            throw InvalidProtocolBufferException.c();
        }
        do {
            c0970n1.addInt(abstractC0972o.x());
            if (abstractC0972o.g()) {
                return;
            } else {
                iD2 = abstractC0972o.D();
            }
        } while (iD2 == this.b);
        this.d = iD2;
    }

    @Override // com.google.protobuf.InterfaceC0975o2
    public final long readSFixed64() throws InvalidProtocolBufferException.InvalidWireTypeException {
        k(1);
        return this.f2934a.y();
    }

    @Override // com.google.protobuf.InterfaceC0975o2
    public final void readSFixed64List(List list) throws InvalidProtocolBufferException {
        int iD;
        int iD2;
        boolean z10 = list instanceof D1;
        AbstractC0972o abstractC0972o = this.f2934a;
        if (!z10) {
            int i = this.b & 7;
            if (i == 1) {
                do {
                    list.add(Long.valueOf(abstractC0972o.y()));
                    if (abstractC0972o.g()) {
                        return;
                    } else {
                        iD = abstractC0972o.D();
                    }
                } while (iD == this.b);
                this.d = iD;
                return;
            }
            if (i != 2) {
                throw InvalidProtocolBufferException.c();
            }
            int iE = abstractC0972o.E();
            m(iE);
            int iF = abstractC0972o.f() + iE;
            do {
                list.add(Long.valueOf(abstractC0972o.y()));
            } while (abstractC0972o.f() < iF);
            return;
        }
        D1 d12 = (D1) list;
        int i6 = this.b & 7;
        if (i6 == 1) {
            do {
                d12.addLong(abstractC0972o.y());
                if (abstractC0972o.g()) {
                    return;
                } else {
                    iD2 = abstractC0972o.D();
                }
            } while (iD2 == this.b);
            this.d = iD2;
            return;
        }
        if (i6 != 2) {
            throw InvalidProtocolBufferException.c();
        }
        int iE2 = abstractC0972o.E();
        m(iE2);
        int iF2 = abstractC0972o.f() + iE2;
        do {
            d12.addLong(abstractC0972o.y());
        } while (abstractC0972o.f() < iF2);
    }

    @Override // com.google.protobuf.InterfaceC0975o2
    public final int readSInt32() throws InvalidProtocolBufferException.InvalidWireTypeException {
        k(0);
        return this.f2934a.z();
    }

    @Override // com.google.protobuf.InterfaceC0975o2
    public final void readSInt32List(List list) throws InvalidProtocolBufferException {
        int iD;
        int iD2;
        boolean z10 = list instanceof C0970n1;
        AbstractC0972o abstractC0972o = this.f2934a;
        if (!z10) {
            int i = this.b & 7;
            if (i == 0) {
                do {
                    list.add(Integer.valueOf(abstractC0972o.z()));
                    if (abstractC0972o.g()) {
                        return;
                    } else {
                        iD = abstractC0972o.D();
                    }
                } while (iD == this.b);
                this.d = iD;
                return;
            }
            if (i != 2) {
                throw InvalidProtocolBufferException.c();
            }
            int iF = abstractC0972o.f() + abstractC0972o.E();
            do {
                list.add(Integer.valueOf(abstractC0972o.z()));
            } while (abstractC0972o.f() < iF);
            j(iF);
            return;
        }
        C0970n1 c0970n1 = (C0970n1) list;
        int i6 = this.b & 7;
        if (i6 == 0) {
            do {
                c0970n1.addInt(abstractC0972o.z());
                if (abstractC0972o.g()) {
                    return;
                } else {
                    iD2 = abstractC0972o.D();
                }
            } while (iD2 == this.b);
            this.d = iD2;
            return;
        }
        if (i6 != 2) {
            throw InvalidProtocolBufferException.c();
        }
        int iF2 = abstractC0972o.f() + abstractC0972o.E();
        do {
            c0970n1.addInt(abstractC0972o.z());
        } while (abstractC0972o.f() < iF2);
        j(iF2);
    }

    @Override // com.google.protobuf.InterfaceC0975o2
    public final long readSInt64() throws InvalidProtocolBufferException.InvalidWireTypeException {
        k(0);
        return this.f2934a.A();
    }

    @Override // com.google.protobuf.InterfaceC0975o2
    public final void readSInt64List(List list) throws InvalidProtocolBufferException {
        int iD;
        int iD2;
        boolean z10 = list instanceof D1;
        AbstractC0972o abstractC0972o = this.f2934a;
        if (!z10) {
            int i = this.b & 7;
            if (i == 0) {
                do {
                    list.add(Long.valueOf(abstractC0972o.A()));
                    if (abstractC0972o.g()) {
                        return;
                    } else {
                        iD = abstractC0972o.D();
                    }
                } while (iD == this.b);
                this.d = iD;
                return;
            }
            if (i != 2) {
                throw InvalidProtocolBufferException.c();
            }
            int iF = abstractC0972o.f() + abstractC0972o.E();
            do {
                list.add(Long.valueOf(abstractC0972o.A()));
            } while (abstractC0972o.f() < iF);
            j(iF);
            return;
        }
        D1 d12 = (D1) list;
        int i6 = this.b & 7;
        if (i6 == 0) {
            do {
                d12.addLong(abstractC0972o.A());
                if (abstractC0972o.g()) {
                    return;
                } else {
                    iD2 = abstractC0972o.D();
                }
            } while (iD2 == this.b);
            this.d = iD2;
            return;
        }
        if (i6 != 2) {
            throw InvalidProtocolBufferException.c();
        }
        int iF2 = abstractC0972o.f() + abstractC0972o.E();
        do {
            d12.addLong(abstractC0972o.A());
        } while (abstractC0972o.f() < iF2);
        j(iF2);
    }

    @Override // com.google.protobuf.InterfaceC0975o2
    public final String readString() throws InvalidProtocolBufferException.InvalidWireTypeException {
        k(2);
        return this.f2934a.B();
    }

    @Override // com.google.protobuf.InterfaceC0975o2
    public final void readStringList(List list) throws InvalidProtocolBufferException.InvalidWireTypeException {
        i(list, false);
    }

    @Override // com.google.protobuf.InterfaceC0975o2
    public final void readStringListRequireUtf8(List list) throws InvalidProtocolBufferException.InvalidWireTypeException {
        i(list, true);
    }

    @Override // com.google.protobuf.InterfaceC0975o2
    public final String readStringRequireUtf8() throws InvalidProtocolBufferException.InvalidWireTypeException {
        k(2);
        return this.f2934a.C();
    }

    @Override // com.google.protobuf.InterfaceC0975o2
    public final int readUInt32() throws InvalidProtocolBufferException.InvalidWireTypeException {
        k(0);
        return this.f2934a.E();
    }

    @Override // com.google.protobuf.InterfaceC0975o2
    public final void readUInt32List(List list) throws InvalidProtocolBufferException {
        int iD;
        int iD2;
        boolean z10 = list instanceof C0970n1;
        AbstractC0972o abstractC0972o = this.f2934a;
        if (!z10) {
            int i = this.b & 7;
            if (i == 0) {
                do {
                    list.add(Integer.valueOf(abstractC0972o.E()));
                    if (abstractC0972o.g()) {
                        return;
                    } else {
                        iD = abstractC0972o.D();
                    }
                } while (iD == this.b);
                this.d = iD;
                return;
            }
            if (i != 2) {
                throw InvalidProtocolBufferException.c();
            }
            int iF = abstractC0972o.f() + abstractC0972o.E();
            do {
                list.add(Integer.valueOf(abstractC0972o.E()));
            } while (abstractC0972o.f() < iF);
            j(iF);
            return;
        }
        C0970n1 c0970n1 = (C0970n1) list;
        int i6 = this.b & 7;
        if (i6 == 0) {
            do {
                c0970n1.addInt(abstractC0972o.E());
                if (abstractC0972o.g()) {
                    return;
                } else {
                    iD2 = abstractC0972o.D();
                }
            } while (iD2 == this.b);
            this.d = iD2;
            return;
        }
        if (i6 != 2) {
            throw InvalidProtocolBufferException.c();
        }
        int iF2 = abstractC0972o.f() + abstractC0972o.E();
        do {
            c0970n1.addInt(abstractC0972o.E());
        } while (abstractC0972o.f() < iF2);
        j(iF2);
    }

    @Override // com.google.protobuf.InterfaceC0975o2
    public final long readUInt64() throws InvalidProtocolBufferException.InvalidWireTypeException {
        k(0);
        return this.f2934a.F();
    }

    @Override // com.google.protobuf.InterfaceC0975o2
    public final void readUInt64List(List list) throws InvalidProtocolBufferException {
        int iD;
        int iD2;
        boolean z10 = list instanceof D1;
        AbstractC0972o abstractC0972o = this.f2934a;
        if (!z10) {
            int i = this.b & 7;
            if (i == 0) {
                do {
                    list.add(Long.valueOf(abstractC0972o.F()));
                    if (abstractC0972o.g()) {
                        return;
                    } else {
                        iD = abstractC0972o.D();
                    }
                } while (iD == this.b);
                this.d = iD;
                return;
            }
            if (i != 2) {
                throw InvalidProtocolBufferException.c();
            }
            int iF = abstractC0972o.f() + abstractC0972o.E();
            do {
                list.add(Long.valueOf(abstractC0972o.F()));
            } while (abstractC0972o.f() < iF);
            j(iF);
            return;
        }
        D1 d12 = (D1) list;
        int i6 = this.b & 7;
        if (i6 == 0) {
            do {
                d12.addLong(abstractC0972o.F());
                if (abstractC0972o.g()) {
                    return;
                } else {
                    iD2 = abstractC0972o.D();
                }
            } while (iD2 == this.b);
            this.d = iD2;
            return;
        }
        if (i6 != 2) {
            throw InvalidProtocolBufferException.c();
        }
        int iF2 = abstractC0972o.f() + abstractC0972o.E();
        do {
            d12.addLong(abstractC0972o.F());
        } while (abstractC0972o.f() < iF2);
        j(iF2);
    }

    @Override // com.google.protobuf.InterfaceC0975o2
    public final boolean skipField() {
        int i;
        AbstractC0972o abstractC0972o = this.f2934a;
        if (abstractC0972o.g() || (i = this.b) == this.c) {
            return false;
        }
        return abstractC0972o.G(i);
    }
}
