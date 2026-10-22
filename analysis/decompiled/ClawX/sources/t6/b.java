package t6;

import c7.k;
import c7.v;
import c7.x;
import java.io.IOException;
import kotlin.jvm.internal.p;
import n6.m;
import n6.q;
import s6.g;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class b implements v {

    /* renamed from: a, reason: collision with root package name */
    public final m f5586a;

    /* renamed from: b, reason: collision with root package name */
    public final k f5587b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f5588c;
    public final /* synthetic */ f d;

    public b(f fVar, m url) {
        p.e(url, "url");
        this.d = fVar;
        this.f5586a = url;
        x delegate = ((c7.p) fVar.f5598c.f97c).f1184a.d();
        p.e(delegate, "delegate");
        k kVar = new k();
        kVar.f1171e = delegate;
        this.f5587b = kVar;
    }

    public final void a(n6.k trailers) throws NumberFormatException {
        q qVar;
        n6.b bVar;
        p.e(trailers, "trailers");
        f fVar = this.d;
        int i8 = fVar.d;
        if (i8 == 6) {
            return;
        }
        if (i8 != 5) {
            throw new IllegalStateException("state: " + fVar.d);
        }
        k kVar = this.f5587b;
        x xVar = kVar.f1171e;
        kVar.f1171e = x.d;
        xVar.a();
        xVar.b();
        fVar.d = 6;
        if (trailers.size() <= 0 || (qVar = fVar.f5596a) == null || (bVar = qVar.f4104j) == null) {
            return;
        }
        g.b(bVar, this.f5586a, trailers);
    }

    @Override // c7.v, c7.t
    public final x d() {
        return this.f5587b;
    }

    @Override // c7.v
    public long h(long j4, c7.f sink) throws NumberFormatException, IOException {
        f fVar = this.d;
        p.e(sink, "sink");
        try {
            return ((c7.p) fVar.f5598c.f97c).h(j4, sink);
        } catch (IOException e9) {
            fVar.f5597b.g();
            this.a(f.f5595f);
            throw e9;
        }
    }
}
