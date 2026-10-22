package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Streaming;

/* JADX INFO: loaded from: classes4.dex */
public final class a extends Converter.a {

    /* JADX INFO: renamed from: retrofit2.a$a, reason: collision with other inner class name */
    public static final class C0355a implements Converter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0355a f23981a = null;

        static {
            f23981a = new C0355a();
        }

        public C0355a() {
        }

        public ResponseBody a(ResponseBody r10) {
            ResponseBody r11 = i.a(r10);     // Catch: Throwable -> L5
            r10.close();
            return r11;
        L5:
            th = move-exception;
            r10.close();
            throw th;
        }

        @Override // retrofit2.Converter
        public /* bridge */ /* synthetic */ Object convert(Object r10) {
            return a((ResponseBody) r10);
        }
    }

    public static final class b implements Converter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f23982a = null;

        static {
            f23982a = new b();
        }

        public b() {
        }

        public RequestBody a(RequestBody r10) {
            return r10;
        }

        @Override // retrofit2.Converter
        public /* bridge */ /* synthetic */ Object convert(Object r10) {
            return a((RequestBody) r10);
        }
    }

    public static final class c implements Converter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f23983a = null;

        static {
            f23983a = new c();
        }

        public c() {
        }

        public ResponseBody a(ResponseBody r10) {
            return r10;
        }

        @Override // retrofit2.Converter
        public /* bridge */ /* synthetic */ Object convert(Object r10) {
            return a((ResponseBody) r10);
        }
    }

    public static final class d implements Converter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f23984a = null;

        static {
            f23984a = new d();
        }

        public d() {
        }

        public String a(Object r10) {
            return r10.toString();
        }

        @Override // retrofit2.Converter
        public /* bridge */ /* synthetic */ Object convert(Object r10) {
            return a(r10);
        }
    }

    public static final class e implements Converter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f23985a = null;

        static {
            f23985a = new e();
        }

        public e() {
        }

        public Void a(ResponseBody r10) {
            r10.close();
            return null;
        }

        @Override // retrofit2.Converter
        public /* bridge */ /* synthetic */ Object convert(Object r10) {
            return a((ResponseBody) r10);
        }
    }

    public a() {
    }

    @Override // retrofit2.Converter.a
    public Converter a(Type r10, Annotation[] r11, Annotation[] r12, Retrofit r13) {
        if (RequestBody.class.isAssignableFrom(i.j(r10)) == true) goto L5;
        return null;
    L5:
        return b.f23982a;
    }

    @Override // retrofit2.Converter.a
    public Converter b(Type r10, Annotation[] r11, Retrofit r12) {
        if (r10 != ResponseBody.class) goto L10;
        if (i.o(r11, Streaming.class) == false) goto L8;
        return c.f23983a;
    L8:
        return C0355a.f23981a;
    L10:
        if (r10 == Void.class) goto L12;
        return null;
    L12:
        return e.f23985a;
    }
}
