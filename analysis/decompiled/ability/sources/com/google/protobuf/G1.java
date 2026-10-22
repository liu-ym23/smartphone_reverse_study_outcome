package com.google.protobuf;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes3.dex */
public final class G1 extends AbstractC0916a {

    /* renamed from: a, reason: collision with root package name */
    public final I1 f2834a;
    public Object b;
    public Object c;
    public boolean d;
    public boolean e;

    public G1(I1 i12, Object obj, Object obj2, boolean z10, boolean z11) {
        this.f2834a = i12;
        this.b = obj;
        this.c = obj2;
        this.d = z10;
        this.e = z11;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a A(M2 m2) {
        return this;
    }

    @Override // com.google.protobuf.AbstractC0916a
    /* renamed from: B, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final J1 k() {
        J1 j12 = new J1(this.f2834a, this.b, this.c);
        if (j12.isInitialized()) {
            return j12;
        }
        throw AbstractC0916a.x(j12);
    }

    public final void C(D0 d02) {
        C1004w0 c1004w0 = d02.h;
        I1 i12 = this.f2834a;
        if (c1004w0 == i12.k) {
            return;
        }
        throw new RuntimeException("Wrong FieldDescriptor \"" + d02.c + "\" used in message \"" + i12.k.b);
    }

    @Override // com.google.protobuf.InterfaceC0919a2
    public final Object a(D0 d02) {
        C(d02);
        Object obj = d02.b.e == 1 ? this.b : this.c;
        return d02.g == Descriptors$FieldDescriptor$Type.f ? d02.g().f(((Integer) obj).intValue()) : obj;
    }

    @Override // com.google.protobuf.InterfaceC0919a2
    public final Map b() {
        TreeMap treeMap = new TreeMap();
        for (D0 d02 : this.f2834a.k.h()) {
            if (d(d02)) {
                treeMap.put(d02, a(d02));
            }
        }
        return Collections.unmodifiableMap(treeMap);
    }

    @Override // com.google.protobuf.W1
    /* renamed from: buildPartial */
    public final X1 m() {
        return new J1(this.f2834a, this.b, this.c);
    }

    public final Object clone() {
        return new G1(this.f2834a, this.b, this.c, this.d, this.e);
    }

    @Override // com.google.protobuf.InterfaceC0919a2
    public final boolean d(D0 d02) {
        C(d02);
        return d02.b.e == 1 ? this.d : this.e;
    }

    @Override // com.google.protobuf.InterfaceC0919a2
    public final C1004w0 e() {
        return this.f2834a.k;
    }

    @Override // com.google.protobuf.InterfaceC0919a2
    public final M2 f() {
        return M2.b;
    }

    @Override // com.google.protobuf.Y1
    public final X1 getDefaultInstanceForType() {
        I1 i12 = this.f2834a;
        return new J1(i12, i12.c, i12.e);
    }

    @Override // com.google.protobuf.Y1
    public final boolean isInitialized() {
        Object obj = this.c;
        if (((WireFormat$FieldType) this.f2834a.d).f2887a == WireFormat$JavaType.MESSAGE) {
            return ((X1) obj).isInitialized();
        }
        return true;
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a j(D0 d02, Object obj) {
        throw new RuntimeException("There is no repeated field in a map entry message.");
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0924c m() {
        return new J1(this.f2834a, this.b, this.c);
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a w(D0 d02) {
        C(d02);
        if (d02.b.e == 2 && d02.g.f2824a == Descriptors$FieldDescriptor$JavaType.MESSAGE) {
            return ((AbstractC0924c) this.c).q();
        }
        throw new RuntimeException(B7.a.q(new StringBuilder("\""), d02.c, "\" is not a message value field."));
    }

    @Override // com.google.protobuf.AbstractC0916a
    public final AbstractC0916a y(D0 d02, Object obj) {
        C(d02);
        if (obj == null) {
            throw new NullPointerException(B7.a.q(new StringBuilder(), d02.c, " is null"));
        }
        if (d02.b.e == 1) {
            this.b = obj;
            this.d = true;
            return this;
        }
        Descriptors$FieldDescriptor$Type descriptors$FieldDescriptor$Type = d02.g;
        if (descriptors$FieldDescriptor$Type == Descriptors$FieldDescriptor$Type.f) {
            obj = Integer.valueOf(((C0) obj).f2759a.e);
        } else if (descriptors$FieldDescriptor$Type == Descriptors$FieldDescriptor$Type.d) {
            I1 i12 = this.f2834a;
            if (!i12.e.getClass().isInstance(obj)) {
                obj = ((AbstractC0924c) i12.e).toBuilder().t((AbstractC0924c) obj).k();
            }
        }
        this.c = obj;
        this.e = true;
        return this;
    }
}
