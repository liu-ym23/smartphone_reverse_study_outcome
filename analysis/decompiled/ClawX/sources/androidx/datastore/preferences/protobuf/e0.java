package androidx.datastore.preferences.protobuf;

import java.nio.charset.Charset;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e0 {

    /* renamed from: b, reason: collision with root package name */
    public static final s f465b = new s(1);

    /* renamed from: a, reason: collision with root package name */
    public final Object f466a;

    public e0(l lVar) {
        x.a(lVar, "output");
        this.f466a = lVar;
        lVar.f509a = this;
    }

    public void a(int i8, Object obj, u0 u0Var) {
        l lVar = (l) this.f466a;
        lVar.J0(i8, 3);
        u0Var.e((a) obj, lVar.f509a);
        lVar.J0(i8, 4);
    }

    public e0() {
        k0 k0Var;
        r0 r0Var = r0.f559c;
        try {
            k0Var = (k0) Class.forName("androidx.datastore.preferences.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            k0Var = f465b;
        }
        k0[] k0VarArr = {s.f562b, k0Var};
        d0 d0Var = new d0();
        d0Var.f463a = k0VarArr;
        Charset charset = x.f579a;
        this.f466a = d0Var;
    }
}
