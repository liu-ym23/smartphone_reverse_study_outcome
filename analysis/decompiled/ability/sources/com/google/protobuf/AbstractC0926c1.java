package com.google.protobuf;

import c0.C0868b;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* renamed from: com.google.protobuf.c1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC0926c1 extends AbstractC0916a {

    /* renamed from: a, reason: collision with root package name */
    public F1 f2911a;
    public F1 b;
    public boolean c;
    public Y1 d = M2.b;

    public AbstractC0926c1(F1 f12) {
        this.f2911a = f12;
    }

    public final void B(D0 d02, Object obj) {
        C0868b.f(F(), d02).g(this, obj);
    }

    public final AbstractC0926c1 C() {
        AbstractC0926c1 abstractC0926c1 = (AbstractC0926c1) getDefaultInstanceForType().q();
        abstractC0926c1.r(m());
        return abstractC0926c1;
    }

    public final TreeMap D() {
        TreeMap treeMap = new TreeMap();
        List listH = ((C1004w0) F().b).h();
        int i = 0;
        while (i < listH.size()) {
            D0 d0C = (D0) listH.get(i);
            H0 h02 = d0C.f2763j;
            if (h02 != null) {
                i += h02.f - 1;
                if (C0868b.e(F(), h02).d(this)) {
                    d0C = C0868b.e(F(), h02).c(this);
                    treeMap.put(d0C, a(d0C));
                }
            } else if (d0C.isRepeated()) {
                List list = (List) a(d0C);
                if (!list.isEmpty()) {
                    treeMap.put(d0C, list);
                }
            } else if (d(d0C)) {
                treeMap.put(d0C, a(d0C));
            }
            i++;
        }
        return treeMap;
    }

    public final F1 E() {
        if (this.b == null) {
            this.b = new F1(this, 4);
        }
        return this.b;
    }

    public abstract C0868b F();

    public AbstractC1002v2 G(int i) {
        throw new IllegalArgumentException("No map fields found in ".concat(getClass().getName()));
    }

    public AbstractC1002v2 H(int i) {
        throw new IllegalArgumentException("No map fields found in ".concat(getClass().getName()));
    }

    public final void I(M2 m2) {
        M2 m22 = M2.b;
        if (m22.equals(m2)) {
            return;
        }
        if (m22.equals(this.d)) {
            this.d = m2;
            L();
        } else {
            p().o(m2);
            L();
        }
    }

    public final void J(int i, int i6) {
        p().p(i, i6);
    }

    public final void K() {
        if (this.f2911a != null) {
            this.c = true;
        }
    }

    public final void L() {
        F1 f12;
        if (!this.c || (f12 = this.f2911a) == null) {
            return;
        }
        f12.h();
        this.c = false;
    }

    public final void M(D0 d02, Object obj) {
        C0868b.f(F(), d02).e(this, obj);
    }

    @Override // com.google.protobuf.InterfaceC0919a2
    public Object a(D0 d02) {
        Object objC = C0868b.f(F(), d02).c(this);
        return d02.isRepeated() ? Collections.unmodifiableList((List) objC) : objC;
    }

    @Override // com.google.protobuf.InterfaceC0919a2
    public Map b() {
        return Collections.unmodifiableMap(D());
    }

    @Override // com.google.protobuf.InterfaceC0919a2
    public boolean d(D0 d02) {
        return C0868b.f(F(), d02).d(this);
    }

    @Override // com.google.protobuf.InterfaceC0919a2
    public final M2 f() {
        Y1 y12 = this.d;
        return y12 instanceof M2 ? (M2) y12 : ((I2) y12).k();
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final void n() {
        this.f2911a = null;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public AbstractC0916a o(D0 d02) {
        return C0868b.f(F(), d02).f(this);
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final I2 p() {
        Y1 y12 = this.d;
        if (y12 instanceof M2) {
            M2 m2 = (M2) y12;
            m2.getClass();
            I2 i2G = M2.g();
            i2G.o(m2);
            this.d = i2G;
        }
        L();
        return (I2) this.d;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final void q() {
        this.c = true;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public AbstractC0916a w(D0 d02) {
        return C0868b.f(F(), d02).h();
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final void z(I2 i22) {
        this.d = i22;
        L();
    }
}
