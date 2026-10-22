package H0;

import H0.n;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import java.io.File;
import java.io.InputStream;
import z0.C1342h;

/* loaded from: classes.dex */
public class u<Data> implements n<String, Data> {

    /* renamed from: a, reason: collision with root package name */
    private final n<Uri, Data> f2035a;

    public static final class a implements o<String, AssetFileDescriptor> {
        @Override // H0.o
        public n<String, AssetFileDescriptor> a(r rVar) {
            return new u(rVar.d(Uri.class, AssetFileDescriptor.class));
        }

        @Override // H0.o
        public void b() {
        }
    }

    public static class b implements o<String, ParcelFileDescriptor> {
        @Override // H0.o
        public n<String, ParcelFileDescriptor> a(r rVar) {
            return new u(rVar.d(Uri.class, ParcelFileDescriptor.class));
        }

        @Override // H0.o
        public void b() {
        }
    }

    public static class c implements o<String, InputStream> {
        @Override // H0.o
        public n<String, InputStream> a(r rVar) {
            return new u(rVar.d(Uri.class, InputStream.class));
        }

        @Override // H0.o
        public void b() {
        }
    }

    public u(n<Uri, Data> nVar) {
        this.f2035a = nVar;
    }

    private static Uri e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.charAt(0) == '/') {
            return f(str);
        }
        Uri uri = Uri.parse(str);
        return uri.getScheme() == null ? f(str) : uri;
    }

    private static Uri f(String str) {
        return Uri.fromFile(new File(str));
    }

    @Override // H0.n
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<Data> b(String str, int i5, int i6, C1342h c1342h) {
        Uri uriE = e(str);
        if (uriE == null || !this.f2035a.a(uriE)) {
            return null;
        }
        return this.f2035a.b(uriE, i5, i6, c1342h);
    }

    @Override // H0.n
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(String str) {
        return true;
    }
}
