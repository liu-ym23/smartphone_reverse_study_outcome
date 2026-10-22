package com.google.protobuf;

import java.lang.reflect.Method;

/* renamed from: com.google.protobuf.m1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0966m1 extends C0958k1 {
    public final Method f;

    public C0966m1(D0 d02, String str, Class cls, Class cls2, String str2) {
        super(d02, str, cls, cls2, str2);
        GeneratedMessageV3.t(cls, B7.a.m("get", str, "Bytes"), new Class[0]);
        this.f = GeneratedMessageV3.t(cls2, B7.a.m("set", str, "Bytes"), new Class[]{ByteString.class});
    }

    @Override // com.google.protobuf.C0958k1, com.google.protobuf.InterfaceC0938f1
    public final void e(AbstractC0926c1 abstractC0926c1, Object obj) {
        if (obj instanceof ByteString) {
            GeneratedMessageV3.u(this.f, abstractC0926c1, new Object[]{obj});
        } else {
            super.e(abstractC0926c1, obj);
        }
    }
}
