package com.google.protobuf;

import java.lang.reflect.Method;

/* renamed from: com.google.protobuf.l1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0962l1 extends C0958k1 {
    public final Method f;
    public final Method g;

    public C0962l1(D0 d02, String str, Class cls, Class cls2, String str2) {
        super(d02, str, cls, cls2, str2);
        this.f = GeneratedMessageV3.t((Class) this.c, "newBuilder", new Class[0]);
        this.g = GeneratedMessageV3.t(cls2, B7.a.m("get", str, "Builder"), new Class[0]);
    }

    @Override // com.google.protobuf.C0958k1, com.google.protobuf.InterfaceC0938f1
    public final void e(AbstractC0926c1 abstractC0926c1, Object obj) {
        if (!((Class) this.c).isInstance(obj)) {
            obj = ((AbstractC0916a) GeneratedMessageV3.u(this.f, null, new Object[0])).t((AbstractC0924c) obj).m();
        }
        super.e(abstractC0926c1, obj);
    }

    @Override // com.google.protobuf.C0958k1, com.google.protobuf.InterfaceC0938f1
    public final AbstractC0916a f(AbstractC0926c1 abstractC0926c1) {
        return (AbstractC0916a) GeneratedMessageV3.u(this.g, abstractC0926c1, new Object[0]);
    }

    @Override // com.google.protobuf.C0958k1, com.google.protobuf.InterfaceC0938f1
    public final AbstractC0916a h() {
        return (AbstractC0916a) GeneratedMessageV3.u(this.f, null, new Object[0]);
    }
}
