package H0;

import H0.n;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import java.io.InputStream;
import z0.C1342h;

/* loaded from: classes.dex */
public class a<Data> implements n<Uri, Data> {

    /* renamed from: c, reason: collision with root package name */
    private static final int f1953c = 22;

    /* renamed from: a, reason: collision with root package name */
    private final AssetManager f1954a;

    /* renamed from: b, reason: collision with root package name */
    private final InterfaceC0031a<Data> f1955b;

    /* renamed from: H0.a$a, reason: collision with other inner class name */
    public interface InterfaceC0031a<Data> {
        A0.d<Data> c(AssetManager assetManager, String str);
    }

    public static class b implements o<Uri, ParcelFileDescriptor>, InterfaceC0031a<ParcelFileDescriptor> {

        /* renamed from: a, reason: collision with root package name */
        private final AssetManager f1956a;

        public b(AssetManager assetManager) {
            this.f1956a = assetManager;
        }

        @Override // H0.o
        public n<Uri, ParcelFileDescriptor> a(r rVar) {
            return new a(this.f1956a, this);
        }

        @Override // H0.o
        public void b() {
        }

        @Override // H0.a.InterfaceC0031a
        public A0.d<ParcelFileDescriptor> c(AssetManager assetManager, String str) {
            return new A0.h(assetManager, str);
        }
    }

    public static class c implements o<Uri, InputStream>, InterfaceC0031a<InputStream> {

        /* renamed from: a, reason: collision with root package name */
        private final AssetManager f1957a;

        public c(AssetManager assetManager) {
            this.f1957a = assetManager;
        }

        @Override // H0.o
        public n<Uri, InputStream> a(r rVar) {
            return new a(this.f1957a, this);
        }

        @Override // H0.o
        public void b() {
        }

        @Override // H0.a.InterfaceC0031a
        public A0.d<InputStream> c(AssetManager assetManager, String str) {
            return new A0.m(assetManager, str);
        }
    }

    public a(AssetManager assetManager, InterfaceC0031a<Data> interfaceC0031a) {
        this.f1954a = assetManager;
        this.f1955b = interfaceC0031a;
    }

    @Override // H0.n
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<Data> b(Uri uri, int i5, int i6, C1342h c1342h) {
        return new n.a<>(new W0.b(uri), this.f1955b.c(this.f1954a, uri.toString().substring(f1953c)));
    }

    @Override // H0.n
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri) {
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
    }
}
