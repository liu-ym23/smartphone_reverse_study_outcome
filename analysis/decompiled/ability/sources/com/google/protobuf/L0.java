package com.google.protobuf;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class L0 extends AbstractC0916a {

    /* renamed from: a, reason: collision with root package name */
    public final C1004w0 f2851a;
    public final W0 b;
    public final D0[] c;
    public M2 d;

    public L0(C1004w0 c1004w0) {
        this.f2851a = c1004w0;
        Y0 y02 = Y0.d;
        C0990s2 c0990s2 = new C0990s2(16);
        W0 w02 = new W0();
        w02.f2885a = c0990s2;
        w02.c = true;
        this.b = w02;
        this.d = M2.b;
        this.c = new D0[c1004w0.f2982a.f2765j.size()];
    }

    public static void F(D0 d02, Object obj) {
        int iOrdinal = d02.g.ordinal();
        if (iOrdinal == 10) {
            if (obj instanceof AbstractC0916a) {
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(d02.b.e), d02.h().f2887a, obj.getClass().getName()));
            }
        } else {
            if (iOrdinal != 13) {
                return;
            }
            obj.getClass();
            if (!(obj instanceof C0)) {
                throw new IllegalArgumentException("DynamicMessage should use EnumValueDescriptor to set Enum Value.");
            }
        }
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a A(M2 m2) {
        this.d = m2;
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public final M0 k() {
        if (isInitialized()) {
            return m();
        }
        Y0 y0B = this.b.b(false);
        D0[] d0Arr = this.c;
        throw AbstractC0916a.x(new M0(this.f2851a, y0B, (D0[]) Arrays.copyOf(d0Arr, d0Arr.length), this.d));
    }

    @Override // com.google.protobuf.AbstractC0916a
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public final M0 m() {
        C1004w0 c1004w0 = this.f2851a;
        boolean z10 = c1004w0.f2982a.F().h;
        W0 w02 = this.b;
        if (z10) {
            for (D0 d02 : c1004w0.h()) {
                if (d02.l() && !w02.g(d02)) {
                    if (d02.g.f2824a == Descriptors$FieldDescriptor$JavaType.MESSAGE) {
                        w02.m(d02, M0.t(d02.i()));
                    } else {
                        w02.m(d02, d02.f());
                    }
                }
            }
        }
        Y0 y0B = w02.b(true);
        D0[] d0Arr = this.c;
        return new M0(c1004w0, y0B, (D0[]) Arrays.copyOf(d0Arr, d0Arr.length), this.d);
    }

    public final L0 D(AbstractC0924c abstractC0924c) {
        if (!(abstractC0924c instanceof M0)) {
            super.r(abstractC0924c);
            return this;
        }
        M0 m02 = (M0) abstractC0924c;
        C1004w0 c1004w0 = m02.b;
        D0[] d0Arr = m02.d;
        if (c1004w0 != this.f2851a) {
            throw new IllegalArgumentException("mergeFrom(Message) can only merge messages of the same type.");
        }
        Y0 y02 = m02.c;
        W0 w02 = this.b;
        w02.i(y02);
        M2 m2 = m02.e;
        M2 m22 = this.d;
        I2 i2G = M2.g();
        i2G.o(m22);
        i2G.o(m2);
        this.d = i2G.k();
        int i = 0;
        while (true) {
            D0[] d0Arr2 = this.c;
            if (i >= d0Arr2.length) {
                return this;
            }
            D0 d02 = d0Arr2[i];
            if (d02 == null) {
                d0Arr2[i] = d0Arr[i];
            } else {
                D0 d03 = d0Arr[i];
                if (d03 != null && d02 != d03) {
                    w02.c(d02);
                    d0Arr2[i] = d0Arr[i];
                }
            }
            i++;
        }
    }

    public final void E(D0 d02) {
        if (d02.h != this.f2851a) {
            throw new IllegalArgumentException("FieldDescriptor does not match message type.");
        }
    }

    @Override // com.google.protobuf.InterfaceC0919a2
    public final Object a(D0 d02) {
        E(d02);
        Object objK = W0.k(d02, this.b.f(d02), true);
        return objK == null ? d02.isRepeated() ? Collections.EMPTY_LIST : d02.g.f2824a == Descriptors$FieldDescriptor$JavaType.MESSAGE ? M0.t(d02.i()) : d02.f() : objK;
    }

    @Override // com.google.protobuf.InterfaceC0919a2
    public final Map b() {
        return this.b.e();
    }

    public final Object clone() {
        L0 l02 = new L0(this.f2851a);
        l02.b.i(this.b.b(false));
        M2 m2 = this.d;
        M2 m22 = l02.d;
        I2 i2G = M2.g();
        i2G.o(m22);
        i2G.o(m2);
        l02.d = i2G.k();
        D0[] d0Arr = l02.c;
        D0[] d0Arr2 = this.c;
        System.arraycopy(d0Arr2, 0, d0Arr, 0, d0Arr2.length);
        return l02;
    }

    @Override // com.google.protobuf.InterfaceC0919a2
    public final boolean d(D0 d02) {
        E(d02);
        return this.b.g(d02);
    }

    @Override // com.google.protobuf.InterfaceC0919a2
    public final C1004w0 e() {
        return this.f2851a;
    }

    @Override // com.google.protobuf.InterfaceC0919a2
    public final M2 f() {
        return this.d;
    }

    @Override // com.google.protobuf.Y1
    public final X1 getDefaultInstanceForType() {
        return M0.t(this.f2851a);
    }

    @Override // com.google.protobuf.Y1
    public final boolean isInitialized() {
        Iterator it = this.f2851a.h().iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            W0 w02 = this.b;
            if (!zHasNext) {
                return w02.h();
            }
            D0 d02 = (D0) it.next();
            if (d02.n() && !w02.g(d02)) {
                return false;
            }
        }
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a j(D0 d02, Object obj) {
        E(d02);
        F(d02, obj);
        this.b.a(d02, obj);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a o(D0 d02) {
        AbstractC0916a builder;
        E(d02);
        if (d02.k()) {
            throw new UnsupportedOperationException("Nested builder not supported for map fields.");
        }
        if (d02.g.f2824a != Descriptors$FieldDescriptor$JavaType.MESSAGE) {
            throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
        }
        W0 w02 = this.b;
        Object objF = w02.f(d02);
        if (objF == null) {
            builder = new L0(d02.i());
        } else if (objF instanceof AbstractC0916a) {
            builder = (AbstractC0916a) objF;
        } else {
            if (!(objF instanceof AbstractC0924c)) {
                throw new IllegalArgumentException("Cannot convert " + objF.getClass() + " to Message.Builder");
            }
            builder = ((AbstractC0924c) objF).toBuilder();
        }
        w02.m(d02, builder);
        return builder;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final /* bridge */ /* synthetic */ AbstractC0916a r(AbstractC0924c abstractC0924c) {
        D(abstractC0924c);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final /* bridge */ /* synthetic */ AbstractC0916a t(AbstractC0924c abstractC0924c) {
        D(abstractC0924c);
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final void v(M2 m2) {
        M2 m22 = this.d;
        I2 i2G = M2.g();
        i2G.o(m22);
        i2G.o(m2);
        this.d = i2G.k();
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a w(D0 d02) {
        E(d02);
        if (d02.g.f2824a == Descriptors$FieldDescriptor$JavaType.MESSAGE) {
            return new L0(d02.i());
        }
        throw new IllegalArgumentException("newBuilderForField is only valid for fields with message type.");
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a y(D0 d02, Object obj) {
        E(d02);
        if (d02.isRepeated()) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                F(d02, it.next());
            }
        } else {
            F(d02, obj);
        }
        H0 h02 = d02.f2763j;
        W0 w02 = this.b;
        if (h02 != null) {
            int i = h02.f2839a;
            D0[] d0Arr = this.c;
            D0 d03 = d0Arr[i];
            if (d03 != null && d03 != d02) {
                w02.c(d03);
            }
            d0Arr[i] = d02;
        } else if (!d02.j() && !d02.isRepeated() && obj.equals(d02.f())) {
            w02.c(d02);
            return this;
        }
        w02.m(d02, obj);
        return this;
    }
}
