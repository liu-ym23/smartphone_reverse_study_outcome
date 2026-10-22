package u3;

import io.ktor.utils.io.h0;
import java.util.List;
import k4.o;
import k4.t;
import k4.w;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class f extends c {

    /* renamed from: f, reason: collision with root package name */
    public final byte[] f5638f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f5639g;

    public f(t3.c cVar, f4.b bVar, h4.c cVar2, byte[] bArr) {
        super(cVar);
        this.f5638f = bArr;
        this.f5632b = new d4.b(this, bVar, 1);
        this.f5633c = new h4.a(this, bArr, cVar2);
        o oVarA = cVar2.a();
        List list = t.f3636a;
        String strD = oVarA.d("Content-Length");
        Long lValueOf = strD != null ? Long.valueOf(Long.parseLong(strD)) : null;
        long length = bArr.length;
        w method = bVar.C();
        p.e(method, "method");
        if (lValueOf == null || lValueOf.longValue() < 0 || method.equals(w.d) || lValueOf.longValue() == length) {
            this.f5639g = true;
            return;
        }
        throw new IllegalStateException("Content-Length mismatch: expected " + lValueOf + " bytes, but received " + length + " bytes");
    }

    @Override // u3.c
    public final boolean c() {
        return this.f5639g;
    }

    @Override // u3.c
    public final Object f() {
        return h0.a(this.f5638f);
    }
}
