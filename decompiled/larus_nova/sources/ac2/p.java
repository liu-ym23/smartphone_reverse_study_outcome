package ac2;

import com.bytedance.retrofit2.Converter;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes9.dex */
public abstract class p<T> {

    public static final class a<T> extends p<T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Charset f2591c = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Converter<T, TypedOutput> f2592a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Type f2593b;

        static {
            f2591c = Charset.forName("UTF-8");
        }

        public a(Converter r100, Type r101) {
            this.f2592a = r100;
            this.f2593b = r101;
        }

        @Override // ac2.p
        public final void a(w r100, final T r101) {
            if (r101 == null) goto L6;
            r100.f2653c = "application/json; charset=UTF-8";
            r100.f2657g = new o(this, r101);
            return;
        L6:
            throw new IllegalArgumentException("Body parameter value must not be null.");
        }
    }

    public static final class b<T> extends p<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f2594a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Converter<T, String> f2595b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f2596c;

        @Override // ac2.p
        public final void a(w r100, T r101) throws IOException {
            if (r101 != null) goto L4;
            return;
        L4:
            r100.a(this.f2594a, this.f2595b.convert(r101), this.f2596c);
        }

        public b(String r100, Converter<T, String> r101, boolean r102) {
            if (r100 == null) goto L7;
            this.f2594a = r100;
            this.f2595b = r101;
            this.f2596c = r102;
            return;
        L7:
            throw new NullPointerException("name == null");
        }
    }

    public static final class c<T> extends p<Map<String, T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Converter<T, String> f2597a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f2598b;

        public c(Converter<T, String> r100, boolean r101) {
            this.f2597a = r100;
            this.f2598b = r101;
        }

        @Override // ac2.p
        public final void a(w r100, Object r101) throws IOException {
            Map r102 = (Map) r101;
            if (r102 == null) goto L18;
            Iterator r103 = r102.entrySet().iterator();
        L6:
            if (r103.hasNext() == false) goto L16;
            Map.Entry r104 = (Map.Entry) r103.next();
            String r105 = (String) r104.getKey();
            if (r105 == null) goto L15;
            Object r106 = r104.getValue();
            if (r106 == null) goto L13;
            r100.a(r105, this.f2597a.convert((T) r106), this.f2598b);
            goto L6
        L13:
            throw new IllegalArgumentException("Field map contained null value for key '" + r105 + "'.");
        L15:
            throw new IllegalArgumentException("Field map contained null key.");
        L16:
            return;
        L18:
            throw new IllegalArgumentException("Field map was null.");
        }
    }

    public static final class d<T> extends p<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f2599a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Converter<T, String> f2600b;

        public d(String r100, Converter<T, String> r101) {
            this.f2599a = r100;
            this.f2600b = r101;
        }

        @Override // ac2.p
        public final void a(w r100, T r101) throws IOException {
            String r102 = this.f2599a;
            if (r102 == null) goto L8;
            if (r101 == null) goto L9;
            r100.b(r102, this.f2600b.convert(r101));
            return;
        L9:
            return;
        }
    }

    public static final class e<T> extends p<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f2601a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Converter<T, String> f2602b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f2603c;

        @Override // ac2.p
        public final void a(w r100, T r101) throws IOException {
            if (r101 != null) goto L4;
            return;
        L4:
            r100.c(this.f2601a, this.f2602b.convert(r101), this.f2603c);
        }

        public e(String r100, Converter<T, String> r101, boolean r102) {
            if (r100 == null) goto L7;
            this.f2601a = r100;
            this.f2602b = r101;
            this.f2603c = r102;
            return;
        L7:
            throw new NullPointerException("name == null");
        }
    }

    public static final class f<T> extends p<Map<String, T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Converter<T, String> f2604a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f2605b;

        public f(Converter<T, String> r100, boolean r101) {
            this.f2604a = r100;
            this.f2605b = r101;
        }

        @Override // ac2.p
        public final void a(w r100, Object r101) throws IOException {
            Map r102 = (Map) r101;
            if (r102 == null) goto L16;
            Iterator r103 = r102.entrySet().iterator();
        L7:
            if (r103.hasNext() == false) goto L23;
            Map.Entry r104 = (Map.Entry) r103.next();
            String r105 = (String) r104.getKey();
            if (r105 == null) goto L15;
            Object r106 = r104.getValue();
            if (r106 == null) goto L7;
            r100.c(r105, this.f2604a.convert((T) r106), this.f2605b);
            goto L7
        L15:
            throw new IllegalArgumentException("Query map contained null key.");
        L23:
            return;
        }
    }

    public static final class g extends p<Object> {
        public g() {
        }

        @Override // ac2.p
        public final void a(w r100, Object r101) {
            String r102 = r101.toString();
            if (r102 == null) goto L7;
            r100.f2651a = r102.toString();
            return;
        L7:
            throw new NullPointerException("@Url parameter is null.");
        }
    }

    public static final class h extends p<RequestBody> {
        public h() {
        }

        @Override // ac2.p
        public final void a(final w r100, RequestBody r101) throws IOException {
            final RequestBody r102 = r101;
            r100.f2657g = new q(r102, r100);
        }
    }

    public p() {
    }

    public abstract void a(w r100, T r101) throws IOException;
}
