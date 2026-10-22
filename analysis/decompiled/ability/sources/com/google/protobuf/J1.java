package com.google.protobuf;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes3.dex */
public final class J1 extends AbstractC0924c {
    public final Object b;
    public final Object c;
    public final I1 d;
    public volatile int e;

    public J1(C1004w0 c1004w0, WireFormat$FieldType wireFormat$FieldType, WireFormat$FieldType wireFormat$FieldType2, Object obj) {
        this.e = -1;
        this.b = "";
        this.c = obj;
        this.d = new I1(c1004w0, this, wireFormat$FieldType, wireFormat$FieldType2);
    }

    @Override // com.google.protobuf.InterfaceC0919a2
    public final Object a(D0 d02) {
        t(d02);
        Object obj = d02.b.e == 1 ? this.b : this.c;
        return d02.g == Descriptors$FieldDescriptor$Type.f ? d02.g().f(((Integer) obj).intValue()) : obj;
    }

    @Override // com.google.protobuf.InterfaceC0919a2
    public final Map b() {
        TreeMap treeMap = new TreeMap();
        for (D0 d02 : this.d.k.h()) {
            t(d02);
            treeMap.put(d02, a(d02));
        }
        return Collections.unmodifiableMap(treeMap);
    }

    @Override // com.google.protobuf.X1
    public final void c(C0980q c0980q) throws CodedOutputStream$OutOfSpaceException {
        K1.d(c0980q, this.d, this.b, this.c);
    }

    @Override // com.google.protobuf.InterfaceC0919a2
    public final boolean d(D0 d02) {
        t(d02);
        return true;
    }

    @Override // com.google.protobuf.InterfaceC0919a2
    public final C1004w0 e() {
        return this.d.k;
    }

    @Override // com.google.protobuf.InterfaceC0919a2
    public final M2 f() {
        return M2.b;
    }

    @Override // com.google.protobuf.Y1
    public final AbstractC0924c getDefaultInstanceForType() {
        I1 i12 = this.d;
        return new J1(i12, i12.c, i12.e);
    }

    @Override // com.google.protobuf.X1
    public final int getSerializedSize() {
        if (this.e != -1) {
            return this.e;
        }
        int iA = K1.a(this.d, this.b, this.c);
        this.e = iA;
        return iA;
    }

    @Override // com.google.protobuf.Y1
    public final boolean isInitialized() {
        if (((WireFormat$FieldType) this.d.d).f2887a == WireFormat$JavaType.MESSAGE) {
            return ((X1) this.c).isInitialized();
        }
        return true;
    }

    public final void t(D0 d02) {
        C1004w0 c1004w0 = d02.h;
        I1 i12 = this.d;
        if (c1004w0 == i12.k) {
            return;
        }
        throw new RuntimeException("Wrong FieldDescriptor \"" + d02.c + "\" used in message \"" + i12.k.b);
    }

    @Override // com.google.protobuf.AbstractC0924c
    /* renamed from: u, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final G1 q() {
        I1 i12 = this.d;
        return new G1(i12, i12.c, i12.e, false, false);
    }

    @Override // com.google.protobuf.X1
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public final G1 toBuilder() {
        return new G1(this.d, this.b, this.c, true, true);
    }

    @Override // com.google.protobuf.Y1
    public final X1 getDefaultInstanceForType() {
        I1 i12 = this.d;
        return new J1(i12, i12.c, i12.e);
    }

    public J1(I1 i12, Object obj, Object obj2) {
        this.e = -1;
        this.b = obj;
        this.c = obj2;
        this.d = i12;
    }

    public J1(AbstractC0972o abstractC0972o, R0 r02, I1 i12) throws InvalidProtocolBufferException {
        this.e = -1;
        try {
            this.d = i12;
            AbstractMap.SimpleImmutableEntry simpleImmutableEntryB = K1.b(abstractC0972o, r02, i12);
            this.b = simpleImmutableEntryB.getKey();
            this.c = simpleImmutableEntryB.getValue();
        } catch (InvalidProtocolBufferException e) {
            throw e;
        } catch (IOException e6) {
            throw new InvalidProtocolBufferException(e6.getMessage(), e6);
        }
    }
}
