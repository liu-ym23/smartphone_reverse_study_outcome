package com.google.crypto.tink.shaded.protobuf;

import java.nio.charset.Charset;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class l0 {

    /* renamed from: b, reason: collision with root package name */
    public static final t f1491b = new t(1);

    /* renamed from: a, reason: collision with root package name */
    public final Object f1492a;

    public l0(l lVar) {
        a0.a(lVar, "output");
        this.f1492a = lVar;
        lVar.f1488c = this;
    }

    public void a(int i8, i iVar) {
        l lVar = (l) this.f1492a;
        lVar.j0(i8, 2);
        lVar.k0(iVar.size());
        h hVar = (h) iVar;
        lVar.d0(hVar.d, hVar.k(), hVar.size());
    }

    public void b(int i8, Object obj, b1 b1Var) throws androidx.datastore.preferences.protobuf.k {
        l lVar = (l) this.f1492a;
        lVar.j0(i8, 3);
        b1Var.h((a) obj, lVar.f1488c);
        lVar.j0(i8, 4);
    }

    public void c(int i8, Object obj, b1 b1Var) throws androidx.datastore.preferences.protobuf.k {
        l lVar = (l) this.f1492a;
        a aVar = (a) obj;
        lVar.j0(i8, 2);
        lVar.k0(aVar.b(b1Var));
        b1Var.h(aVar, lVar.f1488c);
    }

    public l0() {
        p0 p0Var;
        try {
            p0Var = (p0) Class.forName("com.google.crypto.tink.shaded.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            p0Var = f1491b;
        }
        p0[] p0VarArr = {t.f1531b, p0Var};
        k0 k0Var = new k0();
        k0Var.f1484a = p0VarArr;
        Charset charset = a0.f1428a;
        this.f1492a = k0Var;
    }
}
