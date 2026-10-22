package com.google.protobuf;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public final class M0 extends AbstractC0924c {
    public final C1004w0 b;
    public final Y0 c;
    public final D0[] d;
    public final M2 e;
    public int f = -1;

    public M0(C1004w0 c1004w0, Y0 y02, D0[] d0Arr, M2 m2) {
        this.b = c1004w0;
        this.c = y02;
        this.d = d0Arr;
        this.e = m2;
    }

    public static M0 t(C1004w0 c1004w0) {
        return new M0(c1004w0, Y0.d, new D0[c1004w0.f2982a.f2765j.size()], M2.b);
    }

    @Override // com.google.protobuf.InterfaceC0919a2
    public final Object a(D0 d02) {
        if (d02.h != this.b) {
            throw new IllegalArgumentException("FieldDescriptor does not match message type.");
        }
        Object obj = this.c.f2903a.get(d02);
        return obj == null ? d02.isRepeated() ? Collections.EMPTY_LIST : d02.g.f2824a == Descriptors$FieldDescriptor$JavaType.MESSAGE ? t(d02.i()) : d02.f() : obj;
    }

    @Override // com.google.protobuf.InterfaceC0919a2
    public final Map b() {
        return this.c.h();
    }

    @Override // com.google.protobuf.X1
    public final void c(C0980q c0980q) throws CodedOutputStream$OutOfSpaceException {
        boolean z10 = this.b.f2982a.F().e;
        M2 m2 = this.e;
        int i = 0;
        Y0 y02 = this.c;
        if (!z10) {
            C0990s2 c0990s2 = y02.f2903a;
            while (i < c0990s2.b.size()) {
                Map.Entry entryD = c0990s2.d(i);
                Y0.w((X0) entryD.getKey(), entryD.getValue(), c0980q);
                i++;
            }
            for (Map.Entry entry : c0990s2.e()) {
                Y0.w((X0) entry.getKey(), entry.getValue(), c0980q);
            }
            m2.c(c0980q);
            return;
        }
        C0990s2 c0990s22 = y02.f2903a;
        while (i < c0990s22.b.size()) {
            Y0.x(c0990s22.d(i), c0980q);
            i++;
        }
        Iterator it = c0990s22.e().iterator();
        while (it.hasNext()) {
            Y0.x((Map.Entry) it.next(), c0980q);
        }
        for (Map.Entry entry2 : m2.f2854a.entrySet()) {
            K2 k22 = (K2) entry2.getValue();
            int iIntValue = ((Integer) entry2.getKey()).intValue();
            Iterator it2 = k22.d.iterator();
            while (it2.hasNext()) {
                c0980q.i0(iIntValue, (ByteString) it2.next());
            }
        }
    }

    @Override // com.google.protobuf.InterfaceC0919a2
    public final boolean d(D0 d02) {
        if (d02.h == this.b) {
            return this.c.l(d02);
        }
        throw new IllegalArgumentException("FieldDescriptor does not match message type.");
    }

    @Override // com.google.protobuf.InterfaceC0919a2
    public final C1004w0 e() {
        return this.b;
    }

    @Override // com.google.protobuf.InterfaceC0919a2
    public final M2 f() {
        return this.e;
    }

    @Override // com.google.protobuf.Y1
    public final AbstractC0924c getDefaultInstanceForType() {
        return t(this.b);
    }

    @Override // com.google.protobuf.X1
    public final int getSerializedSize() {
        int iK;
        int i = this.f;
        if (i != -1) {
            return i;
        }
        boolean z10 = this.b.f2982a.F().e;
        M2 m2 = this.e;
        Y0 y02 = this.c;
        if (z10) {
            int i6 = y02.i();
            int i10 = 0;
            for (Map.Entry entry : m2.f2854a.entrySet()) {
                K2 k22 = (K2) entry.getValue();
                int iIntValue = ((Integer) entry.getKey()).intValue();
                Iterator it = k22.d.iterator();
                int iK2 = 0;
                while (it.hasNext()) {
                    iK2 += C0980q.K(3, (ByteString) it.next()) + C0980q.S(iIntValue) + C0980q.R(2) + (C0980q.R(1) * 2);
                }
                i10 += iK2;
            }
            iK = i6 + i10;
        } else {
            iK = y02.k() + m2.getSerializedSize();
        }
        this.f = iK;
        return iK;
    }

    @Override // com.google.protobuf.Y1
    public final boolean isInitialized() {
        Iterator it = this.b.h().iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            Y0 y02 = this.c;
            if (!zHasNext) {
                return y02.m();
            }
            D0 d02 = (D0) it.next();
            if (d02.n() && !y02.l(d02)) {
                return false;
            }
        }
    }

    @Override // com.google.protobuf.X1
    /* renamed from: newBuilderForType */
    public final W1 q() {
        return new L0(this.b);
    }

    @Override // com.google.protobuf.AbstractC0924c
    public final AbstractC0916a q() {
        return new L0(this.b);
    }

    @Override // com.google.protobuf.AbstractC0924c
    /* renamed from: s */
    public final AbstractC0916a toBuilder() {
        L0 l02 = new L0(this.b);
        l02.D(this);
        return l02;
    }

    @Override // com.google.protobuf.X1
    public final W1 toBuilder() {
        L0 l02 = new L0(this.b);
        l02.D(this);
        return l02;
    }

    @Override // com.google.protobuf.Y1
    public final X1 getDefaultInstanceForType() {
        return t(this.b);
    }
}
