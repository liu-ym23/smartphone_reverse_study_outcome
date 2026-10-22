package com.google.protobuf;

import c0.C0868b;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: com.google.protobuf.y2, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1014y2 extends AbstractC0926c1 {
    public static final C0956k g = new C0956k(5);
    public int e;
    public P1 f;

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a A(M2 m2) {
        this.d = m2;
        L();
        return this;
    }

    @Override // com.google.protobuf.AbstractC0926c1
    public final C0868b F() {
        C0868b c0868b = A2.b;
        c0868b.g(Struct.class, C1014y2.class);
        return c0868b;
    }

    @Override // com.google.protobuf.AbstractC0926c1
    public final AbstractC1002v2 G(int i) {
        if (i != 1) {
            throw new RuntimeException(B7.a.h(i, "Invalid map field number: "));
        }
        P1 p1 = this.f;
        return p1 == null ? new P1() : p1;
    }

    @Override // com.google.protobuf.AbstractC0926c1
    public final AbstractC1002v2 H(int i) {
        if (i == 1) {
            return O();
        }
        throw new RuntimeException(B7.a.h(i, "Invalid map field number: "));
    }

    @Override // com.google.protobuf.AbstractC0916a
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public final Struct m() {
        Value valueN;
        Struct struct = new Struct(this);
        struct.d = (byte) -1;
        int i = this.e;
        if (i != 0 && (i & 1) != 0) {
            P1 p1 = this.f;
            if (p1 == null) {
                p1 = new P1();
            }
            O1 o12 = new O1(AbstractC1018z2.f2989a, new LinkedHashMap());
            N1 n1N = o12.N();
            for (Map.Entry entry : p1.J().entrySet()) {
                Object key = entry.getKey();
                C0956k c0956k = p1.e;
                InterfaceC0919a2 interfaceC0919a2 = (InterfaceC0919a2) entry.getValue();
                c0956k.getClass();
                b3 b3Var = (b3) interfaceC0919a2;
                if (b3Var instanceof Value) {
                    valueN = (Value) b3Var;
                } else {
                    valueN = ((a3) b3Var).m();
                    if (!valueN.isInitialized()) {
                        throw AbstractC0916a.x(valueN);
                    }
                }
                n1N.put(key, valueN);
            }
            o12.c = false;
            struct.c = o12;
        }
        K();
        return struct;
    }

    public final P1 O() {
        if (this.f == null) {
            this.f = new P1();
        }
        this.e |= 1;
        L();
        return this.f;
    }

    public final C1014y2 P(Struct struct) {
        if (struct == Struct.e) {
            return this;
        }
        O().J().putAll(MapFieldLite.d(struct.E().M()));
        this.e |= 1;
        I(struct.b);
        L();
        return this;
    }

    public final void Q(AbstractC0972o abstractC0972o, R0 r02) {
        r02.getClass();
        boolean z10 = false;
        while (!z10) {
            try {
                try {
                    int iD = abstractC0972o.D();
                    if (iD != 0) {
                        if (iD == 10) {
                            J1 j12 = (J1) abstractC0972o.u(AbstractC1018z2.f2989a.d.l, r02);
                            O().J().put((String) j12.b, (b3) j12.c);
                            this.e |= 1;
                        } else if (!p().m(iD, abstractC0972o)) {
                        }
                    }
                    z10 = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.h();
                }
            } finally {
                L();
            }
        }
    }

    @Override // com.google.protobuf.W1
    /* renamed from: build */
    public final X1 k() {
        Struct structM = m();
        if (structM.isInitialized()) {
            return structM;
        }
        throw AbstractC0916a.x(structM);
    }

    public final Object clone() {
        return (C1014y2) C();
    }

    @Override // com.google.protobuf.InterfaceC0919a2
    public final C1004w0 e() {
        return A2.f2757a;
    }

    @Override // com.google.protobuf.Y1
    public final AbstractC0924c getDefaultInstanceForType() {
        return Struct.e;
    }

    @Override // com.google.protobuf.Y1
    public final boolean isInitialized() {
        return true;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a j(D0 d02, Object obj) {
        B(d02, obj);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0924c k() {
        Struct structM = m();
        if (structM.isInitialized()) {
            return structM;
        }
        throw AbstractC0916a.x(structM);
    }

    @Override // com.google.protobuf.AbstractC0916a, com.google.protobuf.AbstractC0928d, com.google.protobuf.W1
    public final /* bridge */ /* synthetic */ AbstractC0928d mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        Q(abstractC0972o, r02);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a r(AbstractC0924c abstractC0924c) {
        if (abstractC0924c instanceof Struct) {
            P((Struct) abstractC0924c);
            return this;
        }
        super.r(abstractC0924c);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    /* renamed from: s */
    public final /* bridge */ /* synthetic */ AbstractC0916a mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        Q(abstractC0972o, r02);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a t(AbstractC0924c abstractC0924c) {
        if (abstractC0924c instanceof Struct) {
            P((Struct) abstractC0924c);
            return this;
        }
        super.r(abstractC0924c);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final void v(M2 m2) {
        I(m2);
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a y(D0 d02, Object obj) {
        M(d02, obj);
        return this;
    }

    @Override // com.google.protobuf.Y1
    public final X1 getDefaultInstanceForType() {
        return Struct.e;
    }

    @Override // com.google.protobuf.AbstractC0916a, com.google.protobuf.W1
    public final /* bridge */ /* synthetic */ W1 mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        Q(abstractC0972o, r02);
        return this;
    }
}
