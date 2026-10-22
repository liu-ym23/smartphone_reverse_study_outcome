package I0;

import H0.n;
import H0.o;
import H0.r;
import android.content.Context;
import android.net.Uri;
import java.io.InputStream;
import z0.C1342h;

/* loaded from: classes.dex */
public class c implements n<Uri, InputStream> {

    /* renamed from: a, reason: collision with root package name */
    private final Context f2896a;

    public static class a implements o<Uri, InputStream> {

        /* renamed from: a, reason: collision with root package name */
        private final Context f2897a;

        public a(Context context) {
            this.f2897a = context;
        }

        @Override // H0.o
        public n<Uri, InputStream> a(r rVar) {
            return new c(this.f2897a);
        }

        @Override // H0.o
        public void b() {
        }
    }

    public c(Context context) {
        this.f2896a = context.getApplicationContext();
    }

    @Override // H0.n
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<InputStream> b(Uri uri, int i5, int i6, C1342h c1342h) {
        if (B0.b.d(i5, i6)) {
            return new n.a<>(new W0.b(uri), B0.c.f(this.f2896a, uri));
        }
        return null;
    }

    @Override // H0.n
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri) {
        return B0.b.a(uri);
    }
}
