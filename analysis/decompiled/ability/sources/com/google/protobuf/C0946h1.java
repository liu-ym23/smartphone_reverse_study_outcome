package com.google.protobuf;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

/* renamed from: com.google.protobuf.h1, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0946h1 extends O2.a {
    public final A0 d;
    public final Method e;
    public final Method f;
    public final boolean g;
    public final Method h;
    public final Method i;

    /* renamed from: j, reason: collision with root package name */
    public final Method f2922j;

    public C0946h1(D0 d02, String str, Class cls, Class cls2) {
        super(str, cls, cls2);
        this.d = d02.g();
        this.e = GeneratedMessageV3.t((Class) this.b, "valueOf", new Class[]{C0.class});
        this.f = GeneratedMessageV3.t((Class) this.b, "getValueDescriptor", new Class[0]);
        boolean zO = d02.o();
        this.g = !zO;
        if (zO) {
            return;
        }
        String strM = B7.a.m("get", str, "Value");
        Class cls3 = Integer.TYPE;
        this.h = GeneratedMessageV3.t(cls, strM, new Class[]{cls3});
        this.i = GeneratedMessageV3.t(cls2, B7.a.m("get", str, "Value"), new Class[]{cls3});
        GeneratedMessageV3.t(cls2, B7.a.m("set", str, "Value"), new Class[]{cls3, cls3});
        this.f2922j = GeneratedMessageV3.t(cls2, B7.a.m("add", str, "Value"), new Class[]{cls3});
    }

    @Override // O2.a, com.google.protobuf.InterfaceC0938f1
    public final Object a(GeneratedMessageV3 generatedMessageV3) {
        ArrayList arrayList = new ArrayList();
        C5.f fVar = (C5.f) this.c;
        int iIntValue = ((Integer) GeneratedMessageV3.u((Method) fVar.f, generatedMessageV3, new Object[0])).intValue();
        for (int i = 0; i < iIntValue; i++) {
            arrayList.add(this.g ? this.d.f(((Integer) GeneratedMessageV3.u(this.h, generatedMessageV3, new Object[]{Integer.valueOf(i)})).intValue()) : GeneratedMessageV3.u(this.f, GeneratedMessageV3.u((Method) fVar.c, generatedMessageV3, new Object[]{Integer.valueOf(i)}), new Object[0]));
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Override // O2.a, com.google.protobuf.InterfaceC0938f1
    public final Object c(AbstractC0926c1 abstractC0926c1) {
        ArrayList arrayList = new ArrayList();
        C5.f fVar = (C5.f) this.c;
        int iIntValue = ((Integer) GeneratedMessageV3.u((Method) fVar.g, abstractC0926c1, new Object[0])).intValue();
        for (int i = 0; i < iIntValue; i++) {
            arrayList.add(this.g ? this.d.f(((Integer) GeneratedMessageV3.u(this.i, abstractC0926c1, new Object[]{Integer.valueOf(i)})).intValue()) : GeneratedMessageV3.u(this.f, GeneratedMessageV3.u((Method) fVar.d, abstractC0926c1, new Object[]{Integer.valueOf(i)}), new Object[0]));
        }
        return Collections.unmodifiableList(arrayList);
    }

    @Override // O2.a, com.google.protobuf.InterfaceC0938f1
    public final void g(AbstractC0926c1 abstractC0926c1, Object obj) {
        if (this.g) {
            GeneratedMessageV3.u(this.f2922j, abstractC0926c1, new Object[]{Integer.valueOf(((C0) obj).f2759a.e)});
        } else {
            super.g(abstractC0926c1, GeneratedMessageV3.u(this.e, null, new Object[]{obj}));
        }
    }
}
