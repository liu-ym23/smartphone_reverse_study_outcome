package androidx.datastore.preferences.protobuf;

import java.io.IOException;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class i0 {

    /* renamed from: b, reason: collision with root package name */
    public static final t f879b = new t(1);

    /* renamed from: a, reason: collision with root package name */
    public final Object f880a;

    public i0(m mVar) {
        y.a(mVar, "output");
        this.f880a = mVar;
        mVar.f903c = this;
    }

    public void a(int i2, g gVar) throws IOException {
        ((m) this.f880a).A(i2, gVar);
    }

    public void b(int i2, Object obj, z0 z0Var) throws IOException {
        m mVar = (m) this.f880a;
        mVar.L(i2, 3);
        z0Var.e((a) obj, mVar.f903c);
        mVar.L(i2, 4);
    }

    public i0() {
        o0 o0Var;
        try {
            o0Var = (o0) Class.forName("androidx.datastore.preferences.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            o0Var = f879b;
        }
        o0[] o0VarArr = {t.f954b, o0Var};
        h0 h0Var = new h0();
        h0Var.f868a = o0VarArr;
        Charset charset = y.f968a;
        this.f880a = h0Var;
    }
}
