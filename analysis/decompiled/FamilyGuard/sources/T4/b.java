package T4;

import A1.e;
import A1.t;
import C4.E;
import C4.y;
import R4.f;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
final class b<T> implements f<T, E> {

    /* renamed from: c, reason: collision with root package name */
    private static final y f5426c = y.b("application/json; charset=UTF-8");

    /* renamed from: d, reason: collision with root package name */
    private static final Charset f5427d = Charset.forName("UTF-8");

    /* renamed from: a, reason: collision with root package name */
    private final e f5428a;

    /* renamed from: b, reason: collision with root package name */
    private final t<T> f5429b;

    b(e eVar, t<T> tVar) {
        this.f5428a = eVar;
        this.f5429b = tVar;
    }

    @Override // R4.f
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public E a(T t5) throws IOException {
        L4.e eVar = new L4.e();
        G1.c cVarP = this.f5428a.p(new OutputStreamWriter(eVar.D(), f5427d));
        this.f5429b.d(cVarP, t5);
        cVarP.close();
        return E.c(f5426c, eVar.G());
    }
}
