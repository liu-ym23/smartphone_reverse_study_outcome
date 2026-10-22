package H0;

import A0.d;
import H0.n;
import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import z0.C1342h;
import z0.EnumC1335a;

/* loaded from: classes.dex */
public final class e<Model, Data> implements n<Model, Data> {

    /* renamed from: a, reason: collision with root package name */
    private final a<Data> f1964a;

    public interface a<Data> {
        Class<Data> a();

        void b(Data data);

        Data c(String str);
    }

    private static final class b<Data> implements A0.d<Data> {

        /* renamed from: a, reason: collision with root package name */
        private final String f1965a;

        /* renamed from: b, reason: collision with root package name */
        private final a<Data> f1966b;

        /* renamed from: c, reason: collision with root package name */
        private Data f1967c;

        b(String str, a<Data> aVar) {
            this.f1965a = str;
            this.f1966b = aVar;
        }

        @Override // A0.d
        public Class<Data> a() {
            return this.f1966b.a();
        }

        @Override // A0.d
        public void b() {
            try {
                this.f1966b.b(this.f1967c);
            } catch (IOException unused) {
            }
        }

        @Override // A0.d
        public void cancel() {
        }

        @Override // A0.d
        public EnumC1335a d() {
            return EnumC1335a.LOCAL;
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [Data, java.lang.Object] */
        @Override // A0.d
        public void e(v0.g gVar, d.a<? super Data> aVar) {
            try {
                Data dataC = this.f1966b.c(this.f1965a);
                this.f1967c = dataC;
                aVar.f(dataC);
            } catch (IllegalArgumentException e6) {
                aVar.c(e6);
            }
        }
    }

    public static final class c<Model> implements o<Model, InputStream> {

        /* renamed from: a, reason: collision with root package name */
        private final a<InputStream> f1968a = new a();

        class a implements a<InputStream> {
            a() {
            }

            @Override // H0.e.a
            public Class<InputStream> a() {
                return InputStream.class;
            }

            @Override // H0.e.a
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public void b(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            @Override // H0.e.a
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public InputStream c(String str) {
                if (!str.startsWith("data:image")) {
                    throw new IllegalArgumentException("Not a valid image data URL.");
                }
                int iIndexOf = str.indexOf(44);
                if (iIndexOf == -1) {
                    throw new IllegalArgumentException("Missing comma in data URL.");
                }
                if (str.substring(0, iIndexOf).endsWith(";base64")) {
                    return new ByteArrayInputStream(Base64.decode(str.substring(iIndexOf + 1), 0));
                }
                throw new IllegalArgumentException("Not a base64 image data URL.");
            }
        }

        @Override // H0.o
        public n<Model, InputStream> a(r rVar) {
            return new e(this.f1968a);
        }

        @Override // H0.o
        public void b() {
        }
    }

    public e(a<Data> aVar) {
        this.f1964a = aVar;
    }

    @Override // H0.n
    public boolean a(Model model) {
        return model.toString().startsWith("data:image");
    }

    @Override // H0.n
    public n.a<Data> b(Model model, int i5, int i6, C1342h c1342h) {
        return new n.a<>(new W0.b(model), new b(model.toString(), this.f1964a));
    }
}
