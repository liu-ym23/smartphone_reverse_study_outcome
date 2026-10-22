package com.google.crypto.tink.shaded.protobuf;

import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class k0 {

    /* renamed from: b, reason: collision with root package name */
    public static final s f2238b = new s(1);

    /* renamed from: a, reason: collision with root package name */
    public final Object f2239a;

    public k0(k kVar) {
        z.a(kVar, "output");
        this.f2239a = kVar;
        kVar.f2234a = this;
    }

    public void a(int i2, h hVar) {
        k kVar = (k) this.f2239a;
        kVar.h0(i2, 2);
        kVar.i0(hVar.size());
        g gVar = (g) hVar;
        kVar.b0(gVar.f2207i, gVar.k(), gVar.size());
    }

    public void b(int i2, Object obj, a1 a1Var) throws androidx.datastore.preferences.protobuf.l {
        k kVar = (k) this.f2239a;
        kVar.h0(i2, 3);
        a1Var.h((a) obj, kVar.f2234a);
        kVar.h0(i2, 4);
    }

    public void c(int i2, Object obj, a1 a1Var) throws androidx.datastore.preferences.protobuf.l {
        k kVar = (k) this.f2239a;
        a aVar = (a) obj;
        kVar.h0(i2, 2);
        kVar.i0(aVar.a(a1Var));
        a1Var.h(aVar, kVar.f2234a);
    }

    public k0() {
        o0 o0Var;
        try {
            o0Var = (o0) Class.forName("com.google.crypto.tink.shaded.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            o0Var = f2238b;
        }
        o0[] o0VarArr = {s.f2281b, o0Var};
        j0 j0Var = new j0();
        j0Var.f2230a = o0VarArr;
        Charset charset = z.f2296a;
        this.f2239a = j0Var;
    }
}
