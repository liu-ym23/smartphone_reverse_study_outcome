package retrofit2;

import com.android.volley.toolbox.HttpClientStack;
import com.bytedance.librarian.LibrarianImpl;
import com.google.common.net.HttpHeaders;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.OPTIONS;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.QueryName;
import retrofit2.http.Url;

/* JADX INFO: loaded from: classes4.dex */
public final class h {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Pattern f24081m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Pattern f24082n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final okhttp3.Call.Factory f24083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CallAdapter f24084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HttpUrl f24085c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Converter f24086d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f24087e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f24088f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Headers f24089g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MediaType f24090h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f24091i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f24092j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f24093k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final e[] f24094l;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Retrofit f24095a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f24096b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Annotation[] f24097c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Annotation[][] f24098d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Type[] f24099e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Type f24100f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f24101g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f24102h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f24103i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f24104j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f24105k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f24106l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public String f24107m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f24108n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f24109o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f24110p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public String f24111q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public Headers f24112r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public MediaType f24113s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public Set f24114t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public e[] f24115u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public Converter f24116v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public CallAdapter f24117w;

        public a(Retrofit r10, Method r11) {
            this.f24095a = r10;
            this.f24096b = r11;
            this.f24097c = r11.getAnnotations();
            this.f24099e = r11.getGenericParameterTypes();
            this.f24098d = r11.getParameterAnnotations();
        }

        public h a() {
            CallAdapter r10 = b();
            this.f24117w = r10;
            Type r11 = r10.responseType();
            this.f24100f = r11;
            if (r11 == Response.class) goto L69;
            if (r11 == okhttp3.Response.class) goto L69;
            this.f24116v = c();
            Annotation[] r12 = this.f24097c;
            int r13 = r12.length;
            int r14 = 0;
        L7:
            if (r14 >= r13) goto L10;
            j(r12[r14]);
            r14 = r14 + 1;
            goto L7
        L10:
            if (this.f24107m == null) goto L67;
            if (this.f24108n == false) goto L14;
        L22:
            int r15 = this.f24098d.length;
            this.f24115u = new e[r15];
            int r16 = 0;
        L23:
            if (r16 >= r15) goto L34;
            Type r17 = this.f24099e[r16];
            if (i.l(r17) == true) goto L32;
            Annotation[] r18 = this.f24098d[r16];
            if (r18 == null) goto L30;
            this.f24115u[r16] = k(r16, r17, r18);
            r16 = r16 + 1;
            goto L23
        L30:
            throw f(r16, "No Retrofit annotation found.", new Object[0]);
        L32:
            throw f(r16, "Parameter type must not include a type variable or wildcard: %s", new Object[]{r17});
        L34:
            if (this.f24111q == null) goto L36;
        L40:
            boolean r19 = this.f24109o;
            if (r19 == false) goto L43;
        L51:
            if (r19 == false) goto L58;
            if (this.f24101g == true) goto L58;
            throw d("Form-encoded method must contain at least one @Field.", new Object[0]);
        L58:
            if (this.f24110p == false) goto L65;
            if (this.f24102h == true) goto L65;
            throw d("Multipart method must contain at least one @Part.", new Object[0]);
        L65:
            return new h(this);
        L43:
            if (this.f24110p == true) goto L51;
            if (this.f24108n == true) goto L51;
            if (this.f24103i == false) goto L51;
            throw d("Non-body HTTP method cannot contain @Body.", new Object[0]);
        L36:
            if (this.f24106l == true) goto L40;
            throw d("Missing either @%s URL or @Url parameter.", new Object[]{this.f24107m});
        L14:
            if (this.f24110p == true) goto L21;
            if (this.f24109o == false) goto L22;
            throw d("FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
        L21:
            throw d("Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
        L67:
            throw d("HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
        L69:
            throw d("'" + i.j(this.f24100f).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
        }

        public final CallAdapter b() {
            Type r10 = this.f24096b.getGenericReturnType();
            if (i.l(r10) == true) goto L15;
            if (r10 == Void.TYPE) goto L13;
            Annotation[] r11 = this.f24096b.getAnnotations();
            return this.f24095a.b(r10, r11);
        L9:
            e = move-exception;
            throw e(e, "Unable to create call adapter for %s", new Object[]{r10});
        L13:
            throw d("Service methods cannot return void.", new Object[0]);
        L15:
            throw d("Method return type must not include a type variable or wildcard: %s", new Object[]{r10});
        }

        public final Converter c() {
            Annotation[] r10 = this.f24096b.getAnnotations();
            return this.f24095a.k(this.f24100f, r10);
        L5:
            e = move-exception;
            throw e(e, "Unable to create converter for %s", new Object[]{this.f24100f});
        }

        public final RuntimeException d(String r10, Object... r11) {
            return e(null, r10, r11);
        }

        public final RuntimeException e(Throwable r10, String r11, Object... r12) {
            return new IllegalArgumentException(String.format(r11, r12) + "\n    for method " + this.f24096b.getDeclaringClass().getSimpleName() + LibrarianImpl.Constants.DOT + this.f24096b.getName(), r10);
        }

        public final RuntimeException f(int r10, String r11, Object... r12) {
            return d(r11 + " (parameter #" + (r10 + 1) + ")", r12);
        }

        public final RuntimeException g(Throwable r10, int r11, String r12, Object... r13) {
            return e(r10, r12 + " (parameter #" + (r11 + 1) + ")", r13);
        }

        public final Headers h(String[] r10) {
            Headers.Builder r11 = new Headers.Builder();
            int r12 = r10.length;
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L21;
            String r14 = r10[r13];
            int r15 = r14.indexOf(58);
            if (r15 == (-1)) goto L19;
            if (r15 == 0) goto L19;
            if (r15 == (r14.length() - 1)) goto L19;
            String r16 = r14.substring(0, r15);
            String r17 = r14.substring(r15 + 1).trim();
            if ("Content-Type".equalsIgnoreCase(r16) == false) goto L16;
            MediaType r18 = MediaType.c(r17);
            if (r18 == null) goto L15;
            this.f24113s = r18;
        L17:
            r13 = r13 + 1;
            goto L3
        L15:
            throw d("Malformed content type: %s", new Object[]{r17});
        L16:
            r11.a(r16, r17);
        L19:
            throw d("@Headers value must be in the form \"Name: Value\". Found: \"%s\"", new Object[]{r14});
        L21:
            return r11.d();
        }

        public final void i(String r10, String r11, boolean r12) {
            String r13 = this.f24107m;
            if (r13 != null) goto L19;
            this.f24107m = r10;
            this.f24108n = r12;
            if (r11.isEmpty() == false) goto L7;
            return;
        L7:
            int r14 = r11.indexOf(63);
            if (r14 != (-1)) goto L10;
        L16:
            this.f24111q = r11;
            this.f24114t = h.b(r11);
            return;
        L10:
            if (r14 >= (r11.length() - 1)) goto L16;
            String r15 = r11.substring(r14 + 1);
            if (h.f24081m.matcher(r15).find() == false) goto L16;
            throw d("URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", new Object[]{r15});
        L19:
            throw d("Only one HTTP method is allowed. Found: %s and %s.", new Object[]{r13, r10});
        }

        public final void j(Annotation r10) {
            if ((r10 instanceof DELETE) == false) goto L6;
            i("DELETE", ((DELETE) r10).value(), false);
            return;
        L6:
            if ((r10 instanceof GET) == false) goto L9;
            i("GET", ((GET) r10).value(), false);
            return;
        L9:
            if ((r10 instanceof HEAD) == false) goto L16;
            i("HEAD", ((HEAD) r10).value(), false);
            if (Void.class.equals(this.f24100f) == false) goto L14;
            return;
        L14:
            throw d("HEAD method must use Void as response type.", new Object[0]);
        L16:
            if ((r10 instanceof PATCH) == false) goto L19;
            i(HttpClientStack.HttpPatch.METHOD_NAME, ((PATCH) r10).value(), true);
            return;
        L19:
            if ((r10 instanceof POST) == false) goto L22;
            i("POST", ((POST) r10).value(), true);
            return;
        L22:
            if ((r10 instanceof PUT) == false) goto L25;
            i("PUT", ((PUT) r10).value(), true);
            return;
        L25:
            if ((r10 instanceof OPTIONS) == false) goto L28;
            i("OPTIONS", ((OPTIONS) r10).value(), false);
            return;
        L28:
            if ((r10 instanceof HTTP) == false) goto L31;
            HTTP r11 = (HTTP) r10;
            i(r11.method(), r11.path(), r11.hasBody());
            return;
        L31:
            if ((r10 instanceof retrofit2.http.Headers) == false) goto L38;
            String[] r12 = ((retrofit2.http.Headers) r10).value();
            if (r12.length == 0) goto L36;
            this.f24112r = h(r12);
            return;
        L36:
            throw d("@Headers annotation is empty.", new Object[0]);
        L38:
            if ((r10 instanceof Multipart) == false) goto L45;
            if (this.f24109o == true) goto L43;
            this.f24110p = true;
            return;
        L43:
            throw d("Only one encoding annotation is allowed.", new Object[0]);
        L45:
            if ((r10 instanceof FormUrlEncoded) == true) goto L47;
            return;
        L47:
            if (this.f24110p == true) goto L50;
            this.f24109o = true;
            return;
        L50:
            throw d("Only one encoding annotation is allowed.", new Object[0]);
        }

        public final e k(int r10, Type r11, Annotation[] r12) {
            int r13 = r12.length;
            e r14 = null;
            int r15 = 0;
        L3:
            if (r15 >= r13) goto L12;
            e r16 = l(r10, r11, r12, r12[r15]);
            if (r16 == null) goto L9;
            if (r14 != null) goto L11;
            r14 = r16;
            goto L9
        L11:
            throw f(r10, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
        L9:
            r15 = r15 + 1;
            goto L3
        L12:
            if (r14 == null) goto L15;
            return r14;
        L15:
            throw f(r10, "No Retrofit annotation found.", new Object[0]);
        }

        public final e l(int r11, Type r12, Annotation[] r13, Annotation r14) {
            if ((r14 instanceof Url) == false) goto L35;
            if (this.f24106l == true) goto L33;
            if (this.f24104j == true) goto L31;
            if (this.f24105k == true) goto L29;
            if (this.f24111q != null) goto L27;
            this.f24106l = true;
            if (r12 == HttpUrl.class) goto L25;
            if (r12 == String.class) goto L25;
            if (r12 == URI.class) goto L25;
            if ((r12 instanceof Class) == false) goto L23;
            if ("android.net.Uri".equals(((Class) r12).getName()) == true) goto L25;
        L23:
            throw f(r11, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
        L25:
            return new e.o();
        L27:
            throw f(r11, "@Url cannot be used with @%s URL", new Object[]{this.f24107m});
        L29:
            throw f(r11, "A @Url parameter must not come after a @Query", new Object[0]);
        L31:
            throw f(r11, "@Path parameters may not be used with @Url.", new Object[0]);
        L33:
            throw f(r11, "Multiple @Url method annotations found.", new Object[0]);
        L35:
            if ((r14 instanceof Path) == false) goto L51;
            if (this.f24105k == true) goto L49;
            if (this.f24106l == true) goto L47;
            if (this.f24111q == null) goto L45;
            this.f24104j = true;
            Path r15 = (Path) r14;
            String r10 = r15.value();
            m(r11, r10);
            return new e.j(r10, this.f24095a.l(r12, r13), r15.encoded());
        L45:
            throw f(r11, "@Path can only be used with relative url on @%s", new Object[]{this.f24107m});
        L47:
            throw f(r11, "@Path parameters may not be used with @Url.", new Object[0]);
        L49:
            throw f(r11, "A @Path parameter must not come after a @Query.", new Object[0]);
        L51:
            if ((r14 instanceof Query) == false) goto L67;
            Query r16 = (Query) r14;
            String r17 = r16.value();
            boolean r18 = r16.encoded();
            Class r19 = i.j(r12);
            this.f24105k = true;
            if (Iterable.class.isAssignableFrom(r19) == false) goto L61;
            if ((r12 instanceof ParameterizedType) == false) goto L59;
            return new e.k(r17, this.f24095a.l(i.i(0, (ParameterizedType) r12), r13), r18).c();
        L59:
            throw f(r11, r19.getSimpleName() + " must include generic type (e.g., " + r19.getSimpleName() + "<String>)", new Object[0]);
        L61:
            if (r19.isArray() == false) goto L65;
            return new e.k(r17, this.f24095a.l(h.a(r19.getComponentType()), r13), r18).b();
        L65:
            return new e.k(r17, this.f24095a.l(r12, r13), r18);
        L67:
            if ((r14 instanceof QueryName) == false) goto L83;
            boolean r110 = ((QueryName) r14).encoded();
            Class r20 = i.j(r12);
            this.f24105k = true;
            if (Iterable.class.isAssignableFrom(r20) == false) goto L77;
            if ((r12 instanceof ParameterizedType) == false) goto L75;
            return new e.m(this.f24095a.l(i.i(0, (ParameterizedType) r12), r13), r110).c();
        L75:
            throw f(r11, r20.getSimpleName() + " must include generic type (e.g., " + r20.getSimpleName() + "<String>)", new Object[0]);
        L77:
            if (r20.isArray() == false) goto L81;
            return new e.m(this.f24095a.l(h.a(r20.getComponentType()), r13), r110).b();
        L81:
            return new e.m(this.f24095a.l(r12, r13), r110);
        L83:
            if ((r14 instanceof QueryMap) == false) goto L99;
            Class r21 = i.j(r12);
            if (Map.class.isAssignableFrom(r21) == false) goto L97;
            Type r111 = i.k(r12, r21, Map.class);
            if ((r111 instanceof ParameterizedType) == false) goto L95;
            ParameterizedType r112 = (ParameterizedType) r111;
            Type r22 = i.i(0, r112);
            if (String.class != r22) goto L93;
            return new e.l(this.f24095a.l(i.i(1, r112), r13), ((QueryMap) r14).encoded());
        L93:
            throw f(r11, "@QueryMap keys must be of type String: " + r22, new Object[0]);
        L95:
            throw f(r11, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L97:
            throw f(r11, "@QueryMap parameter type must be Map.", new Object[0]);
        L99:
            if ((r14 instanceof Header) == false) goto L115;
            String r113 = ((Header) r14).value();
            Class r23 = i.j(r12);
            if (Iterable.class.isAssignableFrom(r23) == false) goto L109;
            if ((r12 instanceof ParameterizedType) == false) goto L107;
            return new e.f(r113, this.f24095a.l(i.i(0, (ParameterizedType) r12), r13)).c();
        L107:
            throw f(r11, r23.getSimpleName() + " must include generic type (e.g., " + r23.getSimpleName() + "<String>)", new Object[0]);
        L109:
            if (r23.isArray() == false) goto L113;
            return new e.f(r113, this.f24095a.l(h.a(r23.getComponentType()), r13)).b();
        L113:
            return new e.f(r113, this.f24095a.l(r12, r13));
        L115:
            if ((r14 instanceof HeaderMap) == false) goto L131;
            Class r114 = i.j(r12);
            if (Map.class.isAssignableFrom(r114) == false) goto L129;
            Type r115 = i.k(r12, r114, Map.class);
            if ((r115 instanceof ParameterizedType) == false) goto L127;
            ParameterizedType r116 = (ParameterizedType) r115;
            Type r117 = i.i(0, r116);
            if (String.class != r117) goto L125;
            return new e.g(this.f24095a.l(i.i(1, r116), r13));
        L125:
            throw f(r11, "@HeaderMap keys must be of type String: " + r117, new Object[0]);
        L127:
            throw f(r11, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L129:
            throw f(r11, "@HeaderMap parameter type must be Map.", new Object[0]);
        L131:
            if ((r14 instanceof Field) == false) goto L151;
            if (this.f24109o == false) goto L149;
            Field r118 = (Field) r14;
            String r24 = r118.value();
            boolean r119 = r118.encoded();
            this.f24101g = true;
            Class r25 = i.j(r12);
            if (Iterable.class.isAssignableFrom(r25) == false) goto L143;
            if ((r12 instanceof ParameterizedType) == false) goto L141;
            return new e.d(r24, this.f24095a.l(i.i(0, (ParameterizedType) r12), r13), r119).c();
        L141:
            throw f(r11, r25.getSimpleName() + " must include generic type (e.g., " + r25.getSimpleName() + "<String>)", new Object[0]);
        L143:
            if (r25.isArray() == false) goto L147;
            return new e.d(r24, this.f24095a.l(h.a(r25.getComponentType()), r13), r119).b();
        L147:
            return new e.d(r24, this.f24095a.l(r12, r13), r119);
        L149:
            throw f(r11, "@Field parameters can only be used with form encoding.", new Object[0]);
        L151:
            if ((r14 instanceof FieldMap) == false) goto L171;
            if (this.f24109o == false) goto L169;
            Class r26 = i.j(r12);
            if (Map.class.isAssignableFrom(r26) == false) goto L167;
            Type r120 = i.k(r12, r26, Map.class);
            if ((r120 instanceof ParameterizedType) == false) goto L165;
            ParameterizedType r121 = (ParameterizedType) r120;
            Type r27 = i.i(0, r121);
            if (String.class != r27) goto L163;
            Converter r122 = this.f24095a.l(i.i(1, r121), r13);
            this.f24101g = true;
            return new e.C0359e(r122, ((FieldMap) r14).encoded());
        L163:
            throw f(r11, "@FieldMap keys must be of type String: " + r27, new Object[0]);
        L165:
            throw f(r11, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L167:
            throw f(r11, "@FieldMap parameter type must be Map.", new Object[0]);
        L169:
            throw f(r11, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
        L171:
            if ((r14 instanceof Part) == false) goto L231;
            if (this.f24110p == false) goto L229;
            Part r123 = (Part) r14;
            this.f24102h = true;
            String r28 = r123.value();
            Class r29 = i.j(r12);
            if (r28.isEmpty() == true) goto L177;
            Headers r124 = Headers.g(new String[]{HttpHeaders.CONTENT_DISPOSITION, "form-data; name=\"" + r28 + "\"", "Content-Transfer-Encoding", r123.encoding()});
            if (Iterable.class.isAssignableFrom(r29) == false) goto L215;
            if ((r12 instanceof ParameterizedType) == false) goto L213;
            Type r125 = i.i(0, (ParameterizedType) r12);
            if (okhttp3.h.b.class.isAssignableFrom(i.j(r125)) == true) goto L211;
            return new e.h(r124, this.f24095a.j(r125, r13, this.f24097c)).c();
        L211:
            throw f(r11, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
        L213:
            throw f(r11, r29.getSimpleName() + " must include generic type (e.g., " + r29.getSimpleName() + "<String>)", new Object[0]);
        L215:
            if (r29.isArray() == false) goto L223;
            Class r126 = h.a(r29.getComponentType());
            if (okhttp3.h.b.class.isAssignableFrom(r126) == true) goto L221;
            return new e.h(r124, this.f24095a.j(r126, r13, this.f24097c)).b();
        L221:
            throw f(r11, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
        L223:
            if (okhttp3.h.b.class.isAssignableFrom(r29) == true) goto L227;
            return new e.h(r124, this.f24095a.j(r12, r13, this.f24097c));
        L227:
            throw f(r11, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
        L177:
            if (Iterable.class.isAssignableFrom(r29) == false) goto L189;
            if ((r12 instanceof ParameterizedType) == false) goto L187;
            if (okhttp3.h.b.class.isAssignableFrom(i.j(i.i(0, (ParameterizedType) r12))) == false) goto L185;
            return e.n.f24065a.c();
        L185:
            throw f(r11, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
        L187:
            throw f(r11, r29.getSimpleName() + " must include generic type (e.g., " + r29.getSimpleName() + "<String>)", new Object[0]);
        L189:
            if (r29.isArray() == false) goto L197;
            if (okhttp3.h.b.class.isAssignableFrom(r29.getComponentType()) == false) goto L195;
            return e.n.f24065a.b();
        L195:
            throw f(r11, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
        L197:
            if (okhttp3.h.b.class.isAssignableFrom(r29) == false) goto L201;
            return e.n.f24065a;
        L201:
            throw f(r11, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
        L229:
            throw f(r11, "@Part parameters can only be used with multipart encoding.", new Object[0]);
        L231:
            if ((r14 instanceof PartMap) == false) goto L255;
            if (this.f24110p == false) goto L253;
            this.f24102h = true;
            Class r30 = i.j(r12);
            if (Map.class.isAssignableFrom(r30) == false) goto L251;
            Type r127 = i.k(r12, r30, Map.class);
            if ((r127 instanceof ParameterizedType) == false) goto L249;
            ParameterizedType r128 = (ParameterizedType) r127;
            Type r31 = i.i(0, r128);
            if (String.class != r31) goto L247;
            Type r129 = i.i(1, r128);
            if (okhttp3.h.b.class.isAssignableFrom(i.j(r129)) == true) goto L245;
            return new e.i(this.f24095a.j(r129, r13, this.f24097c), ((PartMap) r14).encoding());
        L245:
            throw f(r11, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
        L247:
            throw f(r11, "@PartMap keys must be of type String: " + r31, new Object[0]);
        L249:
            throw f(r11, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L251:
            throw f(r11, "@PartMap parameter type must be Map.", new Object[0]);
        L253:
            throw f(r11, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
        L255:
            if ((r14 instanceof Body) == true) goto L257;
            return null;
        L257:
            if (this.f24109o == true) goto L271;
            if (this.f24110p == true) goto L271;
            if (this.f24103i == true) goto L269;
            Converter r130 = this.f24095a.j(r12, r13, this.f24097c);     // Catch: RuntimeException -> L265
            this.f24103i = true;
            return new e.c(r130);
        L265:
            e = move-exception;
            throw g(e, r11, "Unable to create @Body converter for %s", new Object[]{r12});
        L269:
            throw f(r11, "Multiple @Body method annotations found.", new Object[0]);
        L271:
            throw f(r11, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
        }

        public final void m(int r10, String r11) {
            if (h.f24082n.matcher(r11).matches() == false) goto L10;
            if (this.f24114t.contains(r11) == false) goto L8;
            return;
        L8:
            throw f(r10, "URL \"%s\" does not contain \"{%s}\".", new Object[]{this.f24111q, r11});
        L10:
            throw f(r10, "@Path parameter name must match %s. Found: %s", new Object[]{h.f24081m.pattern(), r11});
        }
    }

    static {
        f24081m = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");
        f24082n = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");
    }

    public h(a r10) {
        this.f24083a = r10.f24095a.c();
        this.f24084b = r10.f24117w;
        this.f24085c = r10.f24095a.a();
        this.f24086d = r10.f24116v;
        this.f24087e = r10.f24107m;
        this.f24088f = r10.f24111q;
        this.f24089g = r10.f24112r;
        this.f24090h = r10.f24113s;
        this.f24091i = r10.f24108n;
        this.f24092j = r10.f24109o;
        this.f24093k = r10.f24110p;
        this.f24094l = r10.f24115u;
    }

    public static Class a(Class r10) {
        if (Boolean.TYPE != r10) goto L7;
        return Boolean.class;
    L7:
        if (Byte.TYPE != r10) goto L11;
        return Byte.class;
    L11:
        if (Character.TYPE != r10) goto L15;
        return Character.class;
    L15:
        if (Double.TYPE != r10) goto L19;
        return Double.class;
    L19:
        if (Float.TYPE != r10) goto L23;
        return Float.class;
    L23:
        if (Integer.TYPE != r10) goto L27;
        return Integer.class;
    L27:
        if (Long.TYPE != r10) goto L31;
        return Long.class;
    L31:
        if (Short.TYPE != r10) goto L34;
        return Short.class;
    L34:
        return r10;
    }

    public static Set b(String r10) {
        Matcher r11 = f24081m.matcher(r10);
        LinkedHashSet r12 = new LinkedHashSet();
    L4:
        if (r11.find() == false) goto L6;
        r12.add(r11.group(1));
        goto L4
    L6:
        return r12;
    }

    public Request c(Object... r11) {
        g r10 = new g(this.f24087e, this.f24085c, this.f24088f, this.f24089g, this.f24090h, this.f24091i, this.f24092j, this.f24093k);
        e[] r12 = this.f24094l;
        int r13 = 0;
        if (r11 == null) goto L5;
        int r14 = r11.length;
    L7:
        if (r14 != r12.length) goto L13;
    L8:
        if (r13 >= r14) goto L11;
        r12[r13].a(r10, r11[r13]);
        r13 = r13 + 1;
        goto L8
    L11:
        return r10.g();
    L13:
        throw new IllegalArgumentException("Argument count (" + r14 + ") doesn't match expected count (" + r12.length + ")");
    L5:
        r14 = 0;
        goto L7
    }

    public Object d(ResponseBody r10) {
        return this.f24086d.convert(r10);
    }
}
