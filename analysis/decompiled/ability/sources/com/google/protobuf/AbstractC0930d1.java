package com.google.protobuf;

import com.google.protobuf.GeneratedMessageV3;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/* renamed from: com.google.protobuf.d1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC0930d1 extends AbstractC0926c1 {
    public W0 e;

    public final void N(D0 d02, Object obj) {
        if (!d02.b.L()) {
            B(d02, obj);
            return;
        }
        S(d02);
        if (this.e == null) {
            Y0 y02 = Y0.d;
            C0990s2 c0990s2 = new C0990s2(16);
            W0 w02 = new W0();
            w02.f2885a = c0990s2;
            w02.c = true;
            this.e = w02;
        }
        this.e.a(d02, obj);
        L();
    }

    public final boolean O() {
        W0 w02 = this.e;
        return w02 == null || w02.h();
    }

    public final void P(GeneratedMessageV3.ExtendableMessage extendableMessage) {
        if (extendableMessage.c != null) {
            if (this.e == null) {
                Y0 y02 = Y0.d;
                C0990s2 c0990s2 = new C0990s2(16);
                W0 w02 = new W0();
                w02.f2885a = c0990s2;
                w02.c = true;
                this.e = w02;
            }
            this.e.i(extendableMessage.c);
            L();
        }
    }

    public final boolean Q(AbstractC0972o abstractC0972o, R0 r02, int i) {
        int i6 = 1;
        if (this.e == null) {
            Y0 y02 = Y0.d;
            C0990s2 c0990s2 = new C0990s2(16);
            W0 w02 = new W0();
            w02.f2885a = c0990s2;
            w02.c = true;
            this.e = w02;
        }
        abstractC0972o.getClass();
        return AbstractC1002v2.D(abstractC0972o, p(), r02, e(), new F1(this.e, i6), i);
    }

    public final void R(D0 d02, Object obj) {
        if (!d02.b.L()) {
            M(d02, obj);
            return;
        }
        S(d02);
        if (this.e == null) {
            Y0 y02 = Y0.d;
            C0990s2 c0990s2 = new C0990s2(16);
            W0 w02 = new W0();
            w02.f2885a = c0990s2;
            w02.c = true;
            this.e = w02;
        }
        this.e.m(d02, obj);
        L();
    }

    public final void S(D0 d02) {
        if (d02.h != e()) {
            throw new IllegalArgumentException("FieldDescriptor does not match message type.");
        }
    }

    @Override // com.google.protobuf.AbstractC0926c1, com.google.protobuf.InterfaceC0919a2
    public final Object a(D0 d02) {
        if (!d02.b.L()) {
            return super.a(d02);
        }
        S(d02);
        W0 w02 = this.e;
        Object objK = w02 == null ? null : W0.k(d02, w02.f(d02), true);
        return objK == null ? d02.g.f2824a == Descriptors$FieldDescriptor$JavaType.MESSAGE ? M0.t(d02.i()) : d02.f() : objK;
    }

    @Override // com.google.protobuf.AbstractC0926c1, com.google.protobuf.InterfaceC0919a2
    public final Map b() {
        TreeMap treeMapD = D();
        W0 w02 = this.e;
        if (w02 != null) {
            treeMapD.putAll(w02.e());
        }
        return Collections.unmodifiableMap(treeMapD);
    }

    @Override // com.google.protobuf.AbstractC0926c1, com.google.protobuf.InterfaceC0919a2
    public final boolean d(D0 d02) {
        if (!d02.b.L()) {
            return super.d(d02);
        }
        S(d02);
        W0 w02 = this.e;
        return w02 != null && w02.g(d02);
    }

    @Override // com.google.protobuf.AbstractC0926c1, com.google.protobuf.AbstractC0916a
    public final AbstractC0916a o(D0 d02) {
        if (!d02.b.L()) {
            return super.o(d02);
        }
        S(d02);
        if (d02.g.f2824a != Descriptors$FieldDescriptor$JavaType.MESSAGE) {
            throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
        }
        if (this.e == null) {
            Y0 y02 = Y0.d;
            C0990s2 c0990s2 = new C0990s2(16);
            W0 w02 = new W0();
            w02.f2885a = c0990s2;
            w02.c = true;
            this.e = w02;
        }
        Object objF = this.e.f(d02);
        if (objF == null) {
            L0 l02 = new L0(d02.i());
            this.e.m(d02, l02);
            L();
            return l02;
        }
        if (objF instanceof AbstractC0916a) {
            return (AbstractC0916a) objF;
        }
        if (!(objF instanceof AbstractC0924c)) {
            throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
        }
        AbstractC0916a builder = ((AbstractC0924c) objF).toBuilder();
        this.e.m(d02, builder);
        L();
        return builder;
    }

    @Override // com.google.protobuf.AbstractC0926c1, com.google.protobuf.AbstractC0916a
    public final AbstractC0916a w(D0 d02) {
        return d02.b.L() ? new L0(d02.i()) : super.w(d02);
    }
}
