package com.google.protobuf;

import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class z2 {

    /* renamed from: b, reason: collision with root package name */
    public static final e2 f2664b = new e2(1);

    /* renamed from: a, reason: collision with root package name */
    public final Object f2665a;

    public z2(r rVar) {
        Charset charset = p2.f2495a;
        this.f2665a = rVar;
        rVar.f2506a = this;
    }

    public void a(int i2, Object obj, t3 t3Var) {
        r rVar = (r) this.f2665a;
        rVar.p0(i2, 3);
        t3Var.f((MessageLite) obj, rVar.f2506a);
        rVar.p0(i2, 4);
    }

    public z2() {
        e3 e3Var;
        q3 q3Var = q3.f2501c;
        try {
            e3Var = (e3) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            e3Var = f2664b;
        }
        e3[] e3VarArr = {e2.f2343b, e3Var};
        y2 y2Var = new y2();
        y2Var.f2635a = e3VarArr;
        Charset charset = p2.f2495a;
        this.f2665a = y2Var;
    }
}
