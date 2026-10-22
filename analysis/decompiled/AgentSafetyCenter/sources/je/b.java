package je;

import ad.a0;
import ad.s;
import id.k;
import ie.l;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.invoke.VarHandle;
import java.nio.charset.Charset;
import java.util.regex.Pattern;
import m7.e;
import m7.n;
import od.h;
import od.i;
import u7.c;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class b implements l {

    /* renamed from: g, reason: collision with root package name */
    public static final s f6793g;

    /* renamed from: h, reason: collision with root package name */
    public static final Charset f6794h;

    /* renamed from: c, reason: collision with root package name */
    public e f6795c;

    /* renamed from: f, reason: collision with root package name */
    public n f6796f;

    static {
        Pattern pattern = s.f568d;
        f6793g = k.t("application/json; charset=UTF-8");
        f6794h = Charset.forName("UTF-8");
    }

    @Override // ie.l
    public final Object convert(Object obj) throws IOException {
        i iVar = new i();
        c cVarD = this.f6795c.d(new OutputStreamWriter(new h(iVar), f6794h));
        this.f6796f.write(cVarD, obj);
        cVarD.close();
        od.l lVarP = iVar.P(iVar.f9454f);
        a0 a0Var = new a0(0);
        a0Var.f431b = f6793g;
        a0Var.f432c = lVarP;
        VarHandle.storeStoreFence();
        return a0Var;
    }
}
