package I0;

import H0.g;
import H0.n;
import H0.o;
import H0.r;
import android.net.Uri;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import z0.C1342h;

/* loaded from: classes.dex */
public class b implements n<Uri, InputStream> {

    /* renamed from: b, reason: collision with root package name */
    private static final Set<String> f2894b = Collections.unmodifiableSet(new HashSet(Arrays.asList("http", "https")));

    /* renamed from: a, reason: collision with root package name */
    private final n<g, InputStream> f2895a;

    public static class a implements o<Uri, InputStream> {
        @Override // H0.o
        public n<Uri, InputStream> a(r rVar) {
            return new b(rVar.d(g.class, InputStream.class));
        }

        @Override // H0.o
        public void b() {
        }
    }

    public b(n<g, InputStream> nVar) {
        this.f2895a = nVar;
    }

    @Override // H0.n
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<InputStream> b(Uri uri, int i5, int i6, C1342h c1342h) {
        return this.f2895a.b(new g(uri.toString()), i5, i6, c1342h);
    }

    @Override // H0.n
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri) {
        return f2894b.contains(uri.getScheme());
    }
}
