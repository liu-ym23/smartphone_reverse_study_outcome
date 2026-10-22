package com.google.protobuf;

import java.lang.reflect.Method;

/* renamed from: com.google.protobuf.i1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0950i1 extends O2.a {
    public final Method d;

    public C0950i1(String str, Class cls, Class cls2) {
        super(str, cls, cls2);
        this.d = GeneratedMessageV3.t((Class) this.b, "newBuilder", new Class[0]);
        GeneratedMessageV3.t(cls2, B7.a.m("get", str, "Builder"), new Class[]{Integer.TYPE});
    }

    @Override // O2.a, com.google.protobuf.InterfaceC0938f1
    public final void g(AbstractC0926c1 abstractC0926c1, Object obj) {
        if (!((Class) this.b).isInstance(obj)) {
            obj = ((AbstractC0916a) GeneratedMessageV3.u(this.d, null, new Object[0])).t((AbstractC0924c) obj).k();
        }
        super.g(abstractC0926c1, obj);
    }

    @Override // O2.a, com.google.protobuf.InterfaceC0938f1
    public final AbstractC0916a h() {
        return (AbstractC0916a) GeneratedMessageV3.u(this.d, null, new Object[0]);
    }
}
