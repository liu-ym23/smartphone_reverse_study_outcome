package I0;

import H0.n;
import H0.o;
import H0.r;
import K0.s;
import android.content.Context;
import android.net.Uri;
import java.io.InputStream;
import z0.C1342h;

/* loaded from: classes.dex */
public class d implements n<Uri, InputStream> {

    /* renamed from: a, reason: collision with root package name */
    private final Context f2898a;

    public static class a implements o<Uri, InputStream> {

        /* renamed from: a, reason: collision with root package name */
        private final Context f2899a;

        public a(Context context) {
            this.f2899a = context;
        }

        @Override // H0.o
        public n<Uri, InputStream> a(r rVar) {
            return new d(this.f2899a);
        }

        @Override // H0.o
        public void b() {
        }
    }

    public d(Context context) {
        this.f2898a = context.getApplicationContext();
    }

    private boolean e(C1342h c1342h) {
        Long l5 = (Long) c1342h.c(s.f3572d);
        return l5 != null && l5.longValue() == -1;
    }

    @Override // H0.n
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<InputStream> b(Uri uri, int i5, int i6, C1342h c1342h) {
        if (B0.b.d(i5, i6) && e(c1342h)) {
            return new n.a<>(new W0.b(uri), B0.c.g(this.f2898a, uri));
        }
        return null;
    }

    @Override // H0.n
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri) {
        return B0.b.c(uri);
    }
}
