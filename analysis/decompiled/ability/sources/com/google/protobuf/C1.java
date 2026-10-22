package com.google.protobuf;

import c0.C0868b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public final class C1 extends AbstractC0926c1 {
    public int e;
    public List f;

    public C1() {
        super(null);
        this.f = Collections.EMPTY_LIST;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a A(M2 m2) {
        this.d = m2;
        L();
        return this;
    }

    @Override // com.google.protobuf.AbstractC0926c1
    public final C0868b F() {
        C0868b c0868b = A2.g;
        c0868b.g(ListValue.class, C1.class);
        return c0868b;
    }

    @Override // com.google.protobuf.AbstractC0916a
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public final ListValue m() {
        ListValue listValue = new ListValue(this);
        listValue.d = (byte) -1;
        if ((this.e & 1) != 0) {
            this.f = Collections.unmodifiableList(this.f);
            this.e &= -2;
        }
        listValue.c = this.f;
        K();
        return listValue;
    }

    public final void O(ListValue listValue) {
        if (listValue == ListValue.e) {
            return;
        }
        if (!listValue.c.isEmpty()) {
            if (this.f.isEmpty()) {
                this.f = listValue.c;
                this.e &= -2;
            } else {
                if ((this.e & 1) == 0) {
                    this.f = new ArrayList(this.f);
                    this.e |= 1;
                }
                this.f.addAll(listValue.c);
            }
            L();
        }
        I(listValue.b);
        L();
    }

    public final void P(AbstractC0972o abstractC0972o, R0 r02) {
        r02.getClass();
        boolean z10 = false;
        while (!z10) {
            try {
                try {
                    int iD = abstractC0972o.D();
                    if (iD != 0) {
                        if (iD == 10) {
                            Value value = (Value) abstractC0972o.u(Value.g, r02);
                            if ((this.e & 1) == 0) {
                                this.f = new ArrayList(this.f);
                                this.e = 1 | this.e;
                            }
                            this.f.add(value);
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
        ListValue listValueM = m();
        if (listValueM.isInitialized()) {
            return listValueM;
        }
        throw AbstractC0916a.x(listValueM);
    }

    public final Object clone() {
        return (C1) C();
    }

    @Override // com.google.protobuf.InterfaceC0919a2
    public final C1004w0 e() {
        return A2.f;
    }

    @Override // com.google.protobuf.Y1
    public final AbstractC0924c getDefaultInstanceForType() {
        return ListValue.e;
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
        ListValue listValueM = m();
        if (listValueM.isInitialized()) {
            return listValueM;
        }
        throw AbstractC0916a.x(listValueM);
    }

    @Override // com.google.protobuf.AbstractC0916a, com.google.protobuf.AbstractC0928d, com.google.protobuf.W1
    public final /* bridge */ /* synthetic */ AbstractC0928d mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        P(abstractC0972o, r02);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a r(AbstractC0924c abstractC0924c) {
        if (abstractC0924c instanceof ListValue) {
            O((ListValue) abstractC0924c);
            return this;
        }
        super.r(abstractC0924c);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    /* renamed from: s */
    public final /* bridge */ /* synthetic */ AbstractC0916a mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        P(abstractC0972o, r02);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a t(AbstractC0924c abstractC0924c) {
        if (abstractC0924c instanceof ListValue) {
            O((ListValue) abstractC0924c);
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
        return ListValue.e;
    }

    @Override // com.google.protobuf.AbstractC0916a, com.google.protobuf.W1
    public final /* bridge */ /* synthetic */ W1 mergeFrom(AbstractC0972o abstractC0972o, R0 r02) {
        P(abstractC0972o, r02);
        return this;
    }
}
