package H0;

import A0.d;
import H0.n;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import z0.C1342h;
import z0.EnumC1335a;

/* loaded from: classes.dex */
public class f<Data> implements n<File, Data> {

    /* renamed from: a, reason: collision with root package name */
    private final d<Data> f1970a;

    public static class a<Data> implements o<File, Data> {

        /* renamed from: a, reason: collision with root package name */
        private final d<Data> f1971a;

        public a(d<Data> dVar) {
            this.f1971a = dVar;
        }

        @Override // H0.o
        public final n<File, Data> a(r rVar) {
            return new f(this.f1971a);
        }

        @Override // H0.o
        public final void b() {
        }
    }

    public static class b extends a<ParcelFileDescriptor> {

        class a implements d<ParcelFileDescriptor> {
            a() {
            }

            @Override // H0.f.d
            public Class<ParcelFileDescriptor> a() {
                return ParcelFileDescriptor.class;
            }

            @Override // H0.f.d
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public void b(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
                parcelFileDescriptor.close();
            }

            @Override // H0.f.d
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public ParcelFileDescriptor c(File file) {
                return ParcelFileDescriptor.open(file, 268435456);
            }
        }

        public b() {
            super(new a());
        }
    }

    private static final class c<Data> implements A0.d<Data> {

        /* renamed from: a, reason: collision with root package name */
        private final File f1972a;

        /* renamed from: b, reason: collision with root package name */
        private final d<Data> f1973b;

        /* renamed from: c, reason: collision with root package name */
        private Data f1974c;

        c(File file, d<Data> dVar) {
            this.f1972a = file;
            this.f1973b = dVar;
        }

        @Override // A0.d
        public Class<Data> a() {
            return this.f1973b.a();
        }

        @Override // A0.d
        public void b() {
            Data data = this.f1974c;
            if (data != null) {
                try {
                    this.f1973b.b(data);
                } catch (IOException unused) {
                }
            }
        }

        @Override // A0.d
        public void cancel() {
        }

        @Override // A0.d
        public EnumC1335a d() {
            return EnumC1335a.LOCAL;
        }

        /* JADX WARN: Type inference failed for: r2v5, types: [Data, java.lang.Object] */
        @Override // A0.d
        public void e(v0.g gVar, d.a<? super Data> aVar) {
            try {
                Data dataC = this.f1973b.c(this.f1972a);
                this.f1974c = dataC;
                aVar.f(dataC);
            } catch (FileNotFoundException e6) {
                if (Log.isLoggable("FileLoader", 3)) {
                    Log.d("FileLoader", "Failed to open file", e6);
                }
                aVar.c(e6);
            }
        }
    }

    public interface d<Data> {
        Class<Data> a();

        void b(Data data);

        Data c(File file);
    }

    public static class e extends a<InputStream> {

        class a implements d<InputStream> {
            a() {
            }

            @Override // H0.f.d
            public Class<InputStream> a() {
                return InputStream.class;
            }

            @Override // H0.f.d
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public void b(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            @Override // H0.f.d
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public InputStream c(File file) {
                return new FileInputStream(file);
            }
        }

        public e() {
            super(new a());
        }
    }

    public f(d<Data> dVar) {
        this.f1970a = dVar;
    }

    @Override // H0.n
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<Data> b(File file, int i5, int i6, C1342h c1342h) {
        return new n.a<>(new W0.b(file), new c(file, this.f1970a));
    }

    @Override // H0.n
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(File file) {
        return true;
    }
}
