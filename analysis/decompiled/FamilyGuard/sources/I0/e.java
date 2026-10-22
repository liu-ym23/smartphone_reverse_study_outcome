package I0;

import H0.g;
import H0.n;
import H0.o;
import H0.r;
import java.io.InputStream;
import java.net.URL;
import z0.C1342h;

/* loaded from: classes.dex */
public class e implements n<URL, InputStream> {

    /* renamed from: a, reason: collision with root package name */
    private final n<g, InputStream> f2900a;

    public static class a implements o<URL, InputStream> {
        @Override // H0.o
        public n<URL, InputStream> a(r rVar) {
            return new e(rVar.d(g.class, InputStream.class));
        }

        @Override // H0.o
        public void b() {
        }
    }

    public e(n<g, InputStream> nVar) {
        this.f2900a = nVar;
    }

    @Override // H0.n
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<InputStream> b(URL url, int i5, int i6, C1342h c1342h) {
        return this.f2900a.b(new g(url), i5, i6, c1342h);
    }

    @Override // H0.n
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(URL url) {
        return true;
    }
}
