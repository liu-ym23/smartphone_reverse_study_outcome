package H0;

import H0.n;
import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import z0.C1342h;

/* loaded from: classes.dex */
public class w<Data> implements n<Uri, Data> {

    /* renamed from: b, reason: collision with root package name */
    private static final Set<String> f2039b = Collections.unmodifiableSet(new HashSet(Arrays.asList("file", "android.resource", "content")));

    /* renamed from: a, reason: collision with root package name */
    private final c<Data> f2040a;

    public static final class a implements o<Uri, AssetFileDescriptor>, c<AssetFileDescriptor> {

        /* renamed from: a, reason: collision with root package name */
        private final ContentResolver f2041a;

        public a(ContentResolver contentResolver) {
            this.f2041a = contentResolver;
        }

        @Override // H0.o
        public n<Uri, AssetFileDescriptor> a(r rVar) {
            return new w(this);
        }

        @Override // H0.o
        public void b() {
        }

        @Override // H0.w.c
        public A0.d<AssetFileDescriptor> c(Uri uri) {
            return new A0.a(this.f2041a, uri);
        }
    }

    public static class b implements o<Uri, ParcelFileDescriptor>, c<ParcelFileDescriptor> {

        /* renamed from: a, reason: collision with root package name */
        private final ContentResolver f2042a;

        public b(ContentResolver contentResolver) {
            this.f2042a = contentResolver;
        }

        @Override // H0.o
        public n<Uri, ParcelFileDescriptor> a(r rVar) {
            return new w(this);
        }

        @Override // H0.o
        public void b() {
        }

        @Override // H0.w.c
        public A0.d<ParcelFileDescriptor> c(Uri uri) {
            return new A0.i(this.f2042a, uri);
        }
    }

    public interface c<Data> {
        A0.d<Data> c(Uri uri);
    }

    public static class d implements o<Uri, InputStream>, c<InputStream> {

        /* renamed from: a, reason: collision with root package name */
        private final ContentResolver f2043a;

        public d(ContentResolver contentResolver) {
            this.f2043a = contentResolver;
        }

        @Override // H0.o
        public n<Uri, InputStream> a(r rVar) {
            return new w(this);
        }

        @Override // H0.o
        public void b() {
        }

        @Override // H0.w.c
        public A0.d<InputStream> c(Uri uri) {
            return new A0.n(this.f2043a, uri);
        }
    }

    public w(c<Data> cVar) {
        this.f2040a = cVar;
    }

    @Override // H0.n
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<Data> b(Uri uri, int i5, int i6, C1342h c1342h) {
        return new n.a<>(new W0.b(uri), this.f2040a.c(uri));
    }

    @Override // H0.n
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri) {
        return f2039b.contains(uri.getScheme());
    }
}
