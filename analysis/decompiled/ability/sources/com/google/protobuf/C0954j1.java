package com.google.protobuf;

import java.lang.reflect.Method;

/* renamed from: com.google.protobuf.j1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0954j1 extends C0958k1 {
    public final A0 f;
    public final Method g;
    public final Method h;
    public final boolean i;

    /* renamed from: j, reason: collision with root package name */
    public final Method f2925j;
    public final Method k;
    public final Method l;

    public C0954j1(D0 d02, String str, Class cls, Class cls2, String str2) {
        super(d02, str, cls, cls2, str2);
        this.f = d02.g();
        this.g = GeneratedMessageV3.t((Class) this.c, "valueOf", new Class[]{C0.class});
        this.h = GeneratedMessageV3.t((Class) this.c, "getValueDescriptor", new Class[0]);
        boolean zO = d02.o();
        this.i = !zO;
        if (zO) {
            return;
        }
        this.f2925j = GeneratedMessageV3.t(cls, B7.a.m("get", str, "Value"), new Class[0]);
        this.k = GeneratedMessageV3.t(cls2, B7.a.m("get", str, "Value"), new Class[0]);
        this.l = GeneratedMessageV3.t(cls2, B7.a.m("set", str, "Value"), new Class[]{Integer.TYPE});
    }

    @Override // com.google.protobuf.C0958k1, com.google.protobuf.InterfaceC0938f1
    public final Object a(GeneratedMessageV3 generatedMessageV3) {
        if (this.i) {
            return this.f.f(((Integer) GeneratedMessageV3.u(this.f2925j, generatedMessageV3, new Object[0])).intValue());
        }
        return GeneratedMessageV3.u(this.h, super.a(generatedMessageV3), new Object[0]);
    }

    @Override // com.google.protobuf.C0958k1, com.google.protobuf.InterfaceC0938f1
    public final Object c(AbstractC0926c1 abstractC0926c1) {
        if (this.i) {
            return this.f.f(((Integer) GeneratedMessageV3.u(this.k, abstractC0926c1, new Object[0])).intValue());
        }
        return GeneratedMessageV3.u(this.h, super.c(abstractC0926c1), new Object[0]);
    }

    @Override // com.google.protobuf.C0958k1, com.google.protobuf.InterfaceC0938f1
    public final void e(AbstractC0926c1 abstractC0926c1, Object obj) {
        if (this.i) {
            GeneratedMessageV3.u(this.l, abstractC0926c1, new Object[]{Integer.valueOf(((C0) obj).f2759a.e)});
        } else {
            super.e(abstractC0926c1, GeneratedMessageV3.u(this.g, null, new Object[]{obj}));
        }
    }
}
