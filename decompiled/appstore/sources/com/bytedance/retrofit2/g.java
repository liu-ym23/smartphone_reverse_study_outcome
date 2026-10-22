package com.bytedance.retrofit2;

import android.text.TextUtils;
import com.android.volley.toolbox.HttpClientStack;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.retrofit2.cache.ICacheServer;
import com.bytedance.retrofit2.client.Client;
import com.bytedance.retrofit2.http.AddCommonParam;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.DELETE;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.Field;
import com.bytedance.retrofit2.http.FieldMap;
import com.bytedance.retrofit2.http.FormUrlEncoded;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HEAD;
import com.bytedance.retrofit2.http.HTTP;
import com.bytedance.retrofit2.http.Header;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.HeaderMap;
import com.bytedance.retrofit2.http.MaxLength;
import com.bytedance.retrofit2.http.Multipart;
import com.bytedance.retrofit2.http.OPTIONS;
import com.bytedance.retrofit2.http.PATCH;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.PUT;
import com.bytedance.retrofit2.http.Part;
import com.bytedance.retrofit2.http.PartMap;
import com.bytedance.retrofit2.http.Path;
import com.bytedance.retrofit2.http.Priority;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.retrofit2.http.QueryMap;
import com.bytedance.retrofit2.http.QueryName;
import com.bytedance.retrofit2.http.RequestPriority;
import com.bytedance.retrofit2.http.ServiceType;
import com.bytedance.retrofit2.http.Streaming;
import com.bytedance.retrofit2.http.Tag;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.http.ext.QueryObject;
import com.bytedance.retrofit2.http.ext.QueryParamObject;
import com.bytedance.retrofit2.mime.TypedInput;
import com.google.common.net.HttpHeaders;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.Headers;
import okhttp3.RequestBody;
import okhttp3.h;

/* JADX INFO: loaded from: classes.dex */
public final class g {
    public static final Pattern A = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final Pattern f8025z = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Client.Provider f8026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CallAdapter f8027b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f8028c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Executor f8029d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f8030e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f8031f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f8032g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f8033h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f8034i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f8035j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Object f8036k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Method f8037l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ICacheServer f8038m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Endpoint f8039n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Converter f8040o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f8041p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f8042q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f8043r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f8044s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f8045t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final boolean f8046u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final d[] f8047v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public List f8048w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f8049x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public RetrofitMetrics f8050y;

    public static final class a {
        public List A;
        public String B;
        public Set C;
        public String D;
        public d[] E;
        public Converter F;
        public CallAdapter G;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f f8051a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f8052b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Annotation[] f8053c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Annotation[][] f8054d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Type[] f8055e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f8056f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f8057g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f8058h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f8059i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f8060j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f8061k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public Object f8062l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f8063m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Type f8064n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f8065o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f8066p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f8067q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public boolean f8068r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public boolean f8069s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public boolean f8070t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public boolean f8071u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public String f8072v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public boolean f8073w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public boolean f8074x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public boolean f8075y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public String f8076z;

        public a(f r10, Method r11) {
            this.f8056f = 1;
            this.f8057g = "";
            this.f8058h = false;
            this.f8059i = -1;
            this.f8060j = true;
            this.f8061k = false;
            this.f8062l = null;
            this.f8063m = 3;
            this.f8051a = r10;
            this.f8052b = r11;
            this.f8053c = r11.getAnnotations();
            this.f8055e = r11.getGenericParameterTypes();
            this.f8054d = r11.getParameterAnnotations();
        }

        public final d a(Type r10) {
            if (RequestBody.class.isAssignableFrom(f6.g.j(r10)) == true) goto L5;
            return null;
        L5:
            return d.e.f7965a;
        }

        public g b() {
            CallAdapter r10 = c();
            this.G = r10;
            Type r11 = r10.responseType();
            this.f8064n = r11;
            if (r11 == g6.c.class) goto L74;
            this.F = d();
            Annotation[] r12 = this.f8053c;
            int r13 = r12.length;
            int r14 = 0;
        L5:
            if (r14 >= r13) goto L11;
            Annotation r15 = r12[r14];
            m(r15);
            if (e.h() == false) goto L9;
            p(r15);
        L9:
            r14 = r14 + 1;
            goto L5
        L11:
            if (this.f8072v == null) goto L72;
            if (this.f8073w == false) goto L15;
        L25:
            int r16 = this.f8054d.length;
            this.E = new d[r16];
            int r17 = 0;
        L26:
            if (r17 >= r16) goto L37;
            Type r18 = this.f8055e[r17];
            if (f6.g.l(r18) == true) goto L35;
            Annotation[] r19 = this.f8054d[r17];
            if (r19 == null) goto L33;
            this.E[r17] = n(r17, r18, r19);
            r17 = r17 + 1;
            goto L26
        L33:
            throw i(r17, "No Retrofit annotation found.", new Object[0]);
        L35:
            throw i(r17, "Parameter type must not include a type variable or wildcard: %s", new Object[]{r18});
        L37:
            if (this.f8076z == null) goto L39;
        L43:
            boolean r20 = this.f8074x;
            if (r20 == false) goto L46;
        L56:
            if (r20 == false) goto L63;
            if (this.f8065o == true) goto L63;
            throw g("Form-encode method must contain at least one @Field.", new Object[0]);
        L63:
            if (this.f8075y == false) goto L70;
            if (this.f8066p == true) goto L70;
            throw g("Multipart method must contain at least one @Part.", new Object[0]);
        L70:
            return new g(this);
        L46:
            if (this.f8075y == true) goto L56;
            if (this.f8073w == true) goto L56;
            if (this.f8061k == true) goto L56;
            if (this.f8067q == false) goto L56;
            throw g("Non-body HTTP method cannot contain @Body.", new Object[0]);
        L39:
            if (this.f8070t == true) goto L43;
            throw g("Missing either @%s URL or @Url parameter.", new Object[]{this.f8072v});
        L15:
            if (this.f8061k == true) goto L25;
            if (this.f8075y == true) goto L24;
            if (this.f8074x == false) goto L25;
            throw g("FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
        L24:
            throw g("Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
        L72:
            throw g("HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
        L74:
            throw g("'" + f6.g.j(this.f8064n).getName() + "' is not a valid response body type.", new Object[0]);
        }

        public final CallAdapter c() {
            Type r10 = this.f8052b.getGenericReturnType();
            if (f6.g.l(r10) == true) goto L15;
            if (r10 == Void.TYPE) goto L13;
            Annotation[] r11 = this.f8052b.getAnnotations();
            return this.f8051a.c(r10, r11);
        L9:
            e = move-exception;
            throw h(e, "Unable to create call adapter for %s", new Object[]{r10});
        L13:
            throw g("Service methods cannot return void.", new Object[0]);
        L15:
            throw g("Method return type must not include a type variable or wildcard: %s", new Object[]{r10});
        }

        public final Converter d() {
            Annotation[] r10 = this.f8052b.getAnnotations();
            return this.f8051a.p(this.f8064n, r10);
        L5:
            e = move-exception;
            throw h(e, "Unable to create converter for %s", new Object[]{this.f8064n});
        }

        public final d e(int r10, Type r11, Annotation[] r12, boolean r13, String r14, boolean r15) {
            Class r16 = f6.g.j(r11);
            this.f8069s = true;
            if (Iterable.class.isAssignableFrom(r16) == false) goto L15;
            if ((r11 instanceof ParameterizedType) == false) goto L13;
            Converter r17 = this.f8051a.s(f6.g.i(0, (ParameterizedType) r11), r12);
            if (r13 == false) goto L11;
            return new d.v(r17, r15).c();
        L11:
            return new d.t(r14, r17, r15).c();
        L13:
            throw i(r10, r16.getSimpleName() + " must include generic type (e.g., " + r16.getSimpleName() + "<String>)", new Object[0]);
        L15:
            if (r16.isArray() == false) goto L22;
            Converter r18 = this.f8051a.s(g.a(r16.getComponentType()), r12);
            if (r13 == false) goto L21;
            return new d.v(r18, r15).b();
        L21:
            return new d.t(r14, r18, r15).b();
        L22:
            Converter r19 = this.f8051a.s(r11, r12);
            if (r13 == false) goto L27;
            return new d.v(r19, r15);
        L27:
            return new d.t(r14, r19, r15);
        }

        public final Headers f(String r10, String r11) {
            return Headers.g(new String[]{HttpHeaders.CONTENT_DISPOSITION, "form-data; name=\"" + r10 + "\"", "Content-Transfer-Encoding", r11});
        }

        public final RuntimeException g(String r10, Object... r11) {
            return h(null, r10, r11);
        }

        public final RuntimeException h(Throwable r10, String r11, Object... r12) {
            return new IllegalArgumentException(String.format(r11, r12) + "\n    for method " + this.f8052b.getDeclaringClass().getSimpleName() + LibrarianImpl.Constants.DOT + this.f8052b.getName(), r10);
        }

        public final RuntimeException i(int r10, String r11, Object... r12) {
            return g(r11 + " (parameter #" + (r10 + 1) + ")", r12);
        }

        public final RuntimeException j(Throwable r10, int r11, String r12, Object... r13) {
            return h(r10, r12 + " (parameter #" + (r11 + 1) + ")", r13);
        }

        public final List k(String[] r10) {
            ArrayList r11 = new ArrayList();
            int r12 = r10.length;
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L16;
            String r14 = r10[r13];
            int r15 = r14.indexOf(58);
            if (r15 == (-1)) goto L15;
            if (r15 == 0) goto L15;
            if (r15 == (r14.length() - 1)) goto L15;
            String r16 = r14.substring(0, r15);
            String r17 = r14.substring(r15 + 1).trim();
            if ("Content-Type".equalsIgnoreCase(r16) == false) goto L12;
            this.B = r17;
        L13:
            r13 = r13 + 1;
            goto L3
        L12:
            r11.add(new g6.a(r16, r17));
        L15:
            throw g("@Headers value must be in the form \"Name: Value\". Found: \"%s\"", new Object[]{r14});
        L16:
            return r11;
        }

        public final void l(String r10, String r11, boolean r12) {
            String r13 = this.f8072v;
            if (r13 != null) goto L25;
            this.f8072v = r10;
            if (r10 == null) goto L8;
            this.D = g.c(r10);
        L8:
            if (this.D == null) goto L10;
            this.f8061k = true;
        L10:
            this.f8073w = r12;
            if (r11.isEmpty() == false) goto L13;
            return;
        L13:
            int r14 = r11.indexOf(63);
            if (r14 != (-1)) goto L16;
        L22:
            this.f8076z = r11;
            this.C = g.d(r11);
            return;
        L16:
            if (r14 >= (r11.length() - 1)) goto L22;
            String r15 = r11.substring(r14 + 1);
            if (g.f8025z.matcher(r15).find() == false) goto L22;
            throw g("URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", new Object[]{r15});
        L25:
            throw g("Only one HTTP method is allowed. Found: %s and %s.", new Object[]{r13, r10});
        }

        public final void m(Annotation r10) {
            if ((r10 instanceof DELETE) == false) goto L6;
            l("DELETE", ((DELETE) r10).value(), false);
            return;
        L6:
            if ((r10 instanceof GET) == false) goto L9;
            l("GET", ((GET) r10).value(), false);
            return;
        L9:
            if ((r10 instanceof HEAD) == false) goto L16;
            l("HEAD", ((HEAD) r10).value(), false);
            if (Void.class.equals(this.f8064n) == false) goto L14;
            return;
        L14:
            throw g("HEAD method must use Void as response type.", new Object[0]);
        L16:
            if ((r10 instanceof PATCH) == false) goto L19;
            l(HttpClientStack.HttpPatch.METHOD_NAME, ((PATCH) r10).value(), true);
            return;
        L19:
            if ((r10 instanceof POST) == false) goto L22;
            l("POST", ((POST) r10).value(), true);
            return;
        L22:
            if ((r10 instanceof PUT) == false) goto L25;
            l("PUT", ((PUT) r10).value(), true);
            return;
        L25:
            if ((r10 instanceof OPTIONS) == false) goto L28;
            l("OPTIONS", ((OPTIONS) r10).value(), false);
            return;
        L28:
            if ((r10 instanceof HTTP) == false) goto L31;
            HTTP r11 = (HTTP) r10;
            l(r11.method(), r11.path(), r11.hasBody());
            return;
        L31:
            if ((r10 instanceof com.bytedance.retrofit2.http.Headers) == false) goto L38;
            String[] r12 = ((com.bytedance.retrofit2.http.Headers) r10).value();
            if (r12.length == 0) goto L36;
            this.A = k(r12);
            return;
        L36:
            throw g("@Headers annotation is empty.", new Object[0]);
        L38:
            if ((r10 instanceof Multipart) == false) goto L45;
            if (this.f8074x == true) goto L43;
            this.f8075y = true;
            return;
        L43:
            throw g("Only one encoding annotation is allowed.", new Object[0]);
        L45:
            if ((r10 instanceof FormUrlEncoded) == false) goto L52;
            if (this.f8075y == true) goto L50;
            this.f8074x = true;
            return;
        L50:
            throw g("Only one encoding annotation is allowed.", new Object[0]);
        L52:
            if ((r10 instanceof Streaming) == false) goto L55;
            this.f8058h = true;
            return;
        L55:
            if ((r10 instanceof Priority) == false) goto L58;
            this.f8056f = ((Priority) r10).value();
            return;
        L58:
            if ((r10 instanceof ServiceType) == false) goto L61;
            this.f8057g = ((ServiceType) r10).value();
            return;
        L61:
            if ((r10 instanceof RequestPriority) == false) goto L77;
            this.f8063m = ((RequestPriority) r10).value();
            return;
        }

        public final d n(int r10, Type r11, Annotation[] r12) {
            int r13 = r12.length;
            d r14 = null;
            int r15 = 0;
        L3:
            if (r15 >= r13) goto L16;
            Annotation r16 = r12[r15];
            d r17 = o(r10, r11, r12, r16);
            if (r17 == null) goto L7;
        L9:
            if (r17 == null) goto L13;
            if (r14 != null) goto L15;
            r14 = r17;
            goto L13
        L15:
            throw i(r10, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
        L13:
            r15 = r15 + 1;
            goto L3
        L7:
            if (e.h() == false) goto L9;
            r17 = q(r10, r11, r12, r16);
            goto L9
        L16:
            if (r14 == null) goto L19;
            return r14;
        L19:
            throw i(r10, "No Retrofit annotation found.", new Object[0]);
        }

        public final d o(int r10, Type r11, Annotation[] r12, Annotation r13) {
            if ((r13 instanceof Url) == false) goto L34;
            if (this.f8070t == true) goto L32;
            if (this.f8068r == true) goto L30;
            if (this.f8069s == true) goto L28;
            if (this.f8076z != null) goto L26;
            this.f8070t = true;
            if (r11 == String.class) goto L24;
            if (r11 == URI.class) goto L24;
            if ((r11 instanceof Class) == false) goto L22;
            if ("android.net.Uri".equals(((Class) r11).getName()) == true) goto L24;
        L22:
            throw i(r10, "@Url must be String, java.net.URI, or android.net.Uri type.", new Object[0]);
        L24:
            return new d.x();
        L26:
            throw i(r10, "@Url cannot be used with @%s URL", new Object[]{this.f8072v});
        L28:
            throw i(r10, "A @Url parameter must not come after a @Query", new Object[0]);
        L30:
            throw i(r10, "@Path parameters may not be used with @Url.", new Object[0]);
        L32:
            throw i(r10, "Multiple @Url method annotations found.", new Object[0]);
        L34:
            if ((r13 instanceof Path) == false) goto L50;
            if (this.f8069s == true) goto L48;
            if (this.f8070t == true) goto L46;
            if (this.f8076z == null) goto L44;
            this.f8068r = true;
            Path r14 = (Path) r13;
            String r15 = r14.value();
            u(r10, r15);
            return new d.s(r15, this.f8051a.s(r11, r12), r14.encode());
        L44:
            throw i(r10, "@Path can only be used with relative url on @%s", new Object[]{this.f8072v});
        L46:
            throw i(r10, "@Path parameters may not be used with @Url.", new Object[0]);
        L48:
            throw i(r10, "A @Path parameter must not come after a @Query.", new Object[0]);
        L50:
            if ((r13 instanceof Query) == false) goto L54;
            Query r16 = (Query) r13;
            return e(r10, r11, r12, false, r16.value(), r16.encode());
        L54:
            if ((r13 instanceof QueryName) == false) goto L58;
            return e(r10, r11, r12, true, null, ((QueryName) r13).encoded());
        L58:
            if ((r13 instanceof QueryMap) == false) goto L74;
            Class r17 = f6.g.j(r11);
            if (Map.class.isAssignableFrom(r17) == false) goto L72;
            Type r18 = f6.g.k(r11, r17, Map.class);
            if ((r18 instanceof ParameterizedType) == false) goto L70;
            ParameterizedType r19 = (ParameterizedType) r18;
            Type r20 = f6.g.i(0, r19);
            if (String.class != r20) goto L68;
            return new d.u(this.f8051a.s(f6.g.i(1, r19), r12), ((QueryMap) r13).encode());
        L68:
            throw i(r10, "@QueryMap keys must be of type String: " + r20, new Object[0]);
        L70:
            throw i(r10, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L72:
            throw i(r10, "@QueryMap parameter type must be Map.", new Object[0]);
        L74:
            if ((r13 instanceof Header) == false) goto L90;
            String r110 = ((Header) r13).value();
            Class r21 = f6.g.j(r11);
            if (Iterable.class.isAssignableFrom(r21) == false) goto L84;
            if ((r11 instanceof ParameterizedType) == false) goto L82;
            return new d.l(r110, this.f8051a.s(f6.g.i(0, (ParameterizedType) r11), r12)).c();
        L82:
            throw i(r10, r21.getSimpleName() + " must include generic type (e.g., " + r21.getSimpleName() + "<String>)", new Object[0]);
        L84:
            if (r21.isArray() == false) goto L88;
            return new d.l(r110, this.f8051a.s(g.a(r21.getComponentType()), r12)).b();
        L88:
            return new d.l(r110, this.f8051a.s(r11, r12));
        L90:
            if ((r13 instanceof HeaderList) == false) goto L106;
            Class r111 = f6.g.j(r11);
            if (List.class.isAssignableFrom(r111) == false) goto L104;
            Type r112 = f6.g.k(r11, r111, List.class);
            if ((r112 instanceof ParameterizedType) == false) goto L102;
            Type r113 = f6.g.i(0, (ParameterizedType) r112);
            if (g6.a.class != r113) goto L100;
            return new d.m(this.f8051a.g(r113, r12));
        L100:
            throw i(r10, "@HeaderList keys must be of type retrofit.client.Header: " + r113, new Object[0]);
        L102:
            throw i(r10, "List must include generic types (e.g., List<Header>)", new Object[0]);
        L104:
            throw i(r10, "@HeaderList parameter type must be List.", new Object[0]);
        L106:
            if ((r13 instanceof HeaderMap) == false) goto L122;
            Class r114 = f6.g.j(r11);
            if (Map.class.isAssignableFrom(r114) == false) goto L120;
            Type r115 = f6.g.k(r11, r114, Map.class);
            if ((r115 instanceof ParameterizedType) == false) goto L118;
            ParameterizedType r116 = (ParameterizedType) r115;
            Type r117 = f6.g.i(0, r116);
            if (String.class != r117) goto L116;
            return new d.n(this.f8051a.s(f6.g.i(1, r116), r12));
        L116:
            throw i(r10, "@HeaderMap keys must be of type String: " + r117, new Object[0]);
        L118:
            throw i(r10, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L120:
            throw i(r10, "@HeaderMap parameter type must be Map.", new Object[0]);
        L122:
            if ((r13 instanceof Field) == false) goto L142;
            if (this.f8074x == false) goto L140;
            Field r118 = (Field) r13;
            String r22 = r118.value();
            boolean r119 = r118.encode();
            this.f8065o = true;
            Class r23 = f6.g.j(r11);
            if (Iterable.class.isAssignableFrom(r23) == false) goto L134;
            if ((r11 instanceof ParameterizedType) == false) goto L132;
            return new d.j(r22, this.f8051a.s(f6.g.i(0, (ParameterizedType) r11), r12), r119).c();
        L132:
            throw i(r10, r23.getSimpleName() + " must include generic type (e.g., " + r23.getSimpleName() + "<String>)", new Object[0]);
        L134:
            if (r23.isArray() == false) goto L138;
            return new d.j(r22, this.f8051a.s(g.a(r23.getComponentType()), r12), r119).b();
        L138:
            return new d.j(r22, this.f8051a.s(r11, r12), r119);
        L140:
            throw i(r10, "@Field parameters can only be used with form encoding.", new Object[0]);
        L142:
            if ((r13 instanceof FieldMap) == false) goto L162;
            if (this.f8074x == false) goto L160;
            Class r24 = f6.g.j(r11);
            if (Map.class.isAssignableFrom(r24) == false) goto L158;
            Type r120 = f6.g.k(r11, r24, Map.class);
            if ((r120 instanceof ParameterizedType) == false) goto L156;
            ParameterizedType r121 = (ParameterizedType) r120;
            Type r25 = f6.g.i(0, r121);
            if (String.class != r25) goto L154;
            Converter r122 = this.f8051a.s(f6.g.i(1, r121), r12);
            this.f8065o = true;
            return new d.k(r122, ((FieldMap) r13).encode());
        L154:
            throw i(r10, "@FieldMap keys must be of type String: " + r25, new Object[0]);
        L156:
            throw i(r10, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L158:
            throw i(r10, "@FieldMap parameter type must be Map.", new Object[0]);
        L160:
            throw i(r10, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
        L162:
            if ((r13 instanceof Part) == false) goto L173;
            if (this.f8075y == false) goto L171;
            Part r123 = (Part) r13;
            this.f8066p = true;
            d r124 = r(r11, r123.value(), r123.encoding());
            if (r124 == null) goto L169;
            return r124;
        L169:
            return new d.q(r123.value(), this.f8051a.o(r11, r12, this.f8053c));
        L171:
            throw i(r10, "@Part parameters can only be used with multipart encoding.", new Object[0]);
        L173:
            if ((r13 instanceof PartMap) == false) goto L196;
            if (this.f8075y == false) goto L194;
            this.f8066p = true;
            Class r26 = f6.g.j(r11);
            if (Map.class.isAssignableFrom(r26) == false) goto L192;
            Type r125 = f6.g.k(r11, r26, Map.class);
            if ((r125 instanceof ParameterizedType) == false) goto L190;
            ParameterizedType r126 = (ParameterizedType) r125;
            Type r27 = f6.g.i(0, r126);
            if (String.class != r27) goto L188;
            d r127 = s(r126, r13);
            if (r127 == null) goto L186;
            return r127;
        L186:
            return new d.r(this.f8051a.o(f6.g.i(1, r126), r12, this.f8053c), ((PartMap) r13).encoding());
        L188:
            throw i(r10, "@PartMap keys must be of type String: " + r27, new Object[0]);
        L190:
            throw i(r10, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L192:
            throw i(r10, "@PartMap parameter type must be Map.", new Object[0]);
        L194:
            throw i(r10, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
        L196:
            if ((r13 instanceof Body) == false) goto L218;
            if (this.f8074x == true) goto L216;
            if (this.f8075y == true) goto L216;
            if (this.f8067q == true) goto L214;
            d r128 = a(r11);
            if (r128 == null) goto L275;
            this.f8067q = true;
            return r128;
        L275:
            Converter r129 = this.f8051a.o(r11, r12, this.f8053c);     // Catch: RuntimeException -> L210
            this.f8067q = true;
            return new d.C0102d(this.f8061k, r129);
        L210:
            e = move-exception;
            throw j(e, r10, "Unable to create @Body converter for %s", new Object[]{r11});
        L214:
            throw i(r10, "Multiple @Body method annotations found.", new Object[0]);
        L216:
            throw i(r10, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
        L218:
            if ((r13 instanceof com.bytedance.retrofit2.http.Method) == false) goto L226;
            if (this.f8071u == true) goto L224;
            this.f8071u = true;
            String r130 = ((com.bytedance.retrofit2.http.Method) r13).value();
            t(r10, r130);
            return new d.p(r130, this.f8051a.s(r11, r12));
        L224:
            throw i(r10, "Multiple @Method method annotations found.", new Object[0]);
        L226:
            if ((r13 instanceof MaxLength) == false) goto L234;
            return new d.o(this.f8051a.s(r11, r12));
        L230:
            e = move-exception;
            throw j(e, r10, "Unable to create @MaxLength converter for %s", new Object[]{r11});
        L234:
            if ((r13 instanceof AddCommonParam) == false) goto L242;
            return new d.c(this.f8051a.s(r11, r12));
        L238:
            e = move-exception;
            throw j(e, r10, "Unable to create @AddCommonParam converter for %s", new Object[]{r11});
        L242:
            if ((r13 instanceof ExtraInfo) == false) goto L250;
            return new d.i(this.f8051a.n(r11, r12));
        L246:
            e = move-exception;
            throw j(e, r10, "Unable to create @ExtraInfo converter for %s", new Object[]{r11});
        L250:
            if ((r13 instanceof QueryObject) == false) goto L258;
            if (QueryParamObject.class.isAssignableFrom(f6.g.j(r11)) == false) goto L256;
            return new d.w();
        L256:
            throw i(r10, "Unable to create @QueryObject for %s not QueryParamObject type", new Object[]{r11});
        L258:
            if ((r13 instanceof Tag) == false) goto L271;
            Class r131 = f6.g.j(r11);
            int r132 = r10 - 1;
        L260:
            if (r132 < 0) goto L270;
            d r133 = this.E[r132];
            if ((r133 instanceof d.y) == false) goto L268;
            if (((d.y) r133).f7996a.equals(r131) == false) goto L268;
            throw i(r10, "@Tag type " + r131.getName() + " is duplicate of parameter #" + (r132 + 1) + " and would always overwrite its value.", new Object[0]);
        L268:
            r132 = r132 - 1;
            goto L260
        L270:
            return new d.y(r131);
        L271:
            return null;
        }

        public final void p(Annotation r10) {
            if ((r10 instanceof retrofit2.http.DELETE) == false) goto L6;
            l("DELETE", ((retrofit2.http.DELETE) r10).value(), false);
            return;
        L6:
            if ((r10 instanceof retrofit2.http.GET) == false) goto L9;
            l("GET", ((retrofit2.http.GET) r10).value(), false);
            return;
        L9:
            if ((r10 instanceof retrofit2.http.HEAD) == false) goto L16;
            l("HEAD", ((retrofit2.http.HEAD) r10).value(), false);
            if (Void.class.equals(this.f8064n) == false) goto L14;
            return;
        L14:
            throw g("HEAD method must use Void as response type.", new Object[0]);
        L16:
            if ((r10 instanceof retrofit2.http.PATCH) == false) goto L19;
            l(HttpClientStack.HttpPatch.METHOD_NAME, ((retrofit2.http.PATCH) r10).value(), true);
            return;
        L19:
            if ((r10 instanceof retrofit2.http.POST) == false) goto L22;
            l("POST", ((retrofit2.http.POST) r10).value(), true);
            return;
        L22:
            if ((r10 instanceof retrofit2.http.PUT) == false) goto L25;
            l("PUT", ((retrofit2.http.PUT) r10).value(), true);
            return;
        L25:
            if ((r10 instanceof retrofit2.http.OPTIONS) == false) goto L28;
            l("OPTIONS", ((retrofit2.http.OPTIONS) r10).value(), false);
            return;
        L28:
            if ((r10 instanceof retrofit2.http.HTTP) == false) goto L31;
            retrofit2.http.HTTP r11 = (retrofit2.http.HTTP) r10;
            l(r11.method(), r11.path(), r11.hasBody());
            return;
        L31:
            if ((r10 instanceof retrofit2.http.Headers) == false) goto L38;
            String[] r12 = ((retrofit2.http.Headers) r10).value();
            if (r12.length == 0) goto L36;
            this.A = k(r12);
            return;
        L36:
            throw g("@Headers annotation is empty.", new Object[0]);
        L38:
            if ((r10 instanceof retrofit2.http.Multipart) == false) goto L45;
            if (this.f8074x == true) goto L43;
            this.f8075y = true;
            return;
        L43:
            throw g("Only one encoding annotation is allowed.", new Object[0]);
        L45:
            if ((r10 instanceof retrofit2.http.FormUrlEncoded) == false) goto L52;
            if (this.f8075y == true) goto L50;
            this.f8074x = true;
            return;
        L50:
            throw g("Only one encoding annotation is allowed.", new Object[0]);
        L52:
            if ((r10 instanceof retrofit2.http.Streaming) == false) goto L65;
            this.f8058h = true;
            return;
        }

        public final d q(int r10, Type r11, Annotation[] r12, Annotation r13) {
            if ((r13 instanceof retrofit2.http.Url) == false) goto L34;
            if (this.f8070t == true) goto L32;
            if (this.f8068r == true) goto L30;
            if (this.f8069s == true) goto L28;
            if (this.f8076z != null) goto L26;
            this.f8070t = true;
            if (r11 == String.class) goto L24;
            if (r11 == URI.class) goto L24;
            if ((r11 instanceof Class) == false) goto L22;
            if ("android.net.Uri".equals(((Class) r11).getName()) == true) goto L24;
        L22:
            throw i(r10, "@Url must be String, java.net.URI, or android.net.Uri type.", new Object[0]);
        L24:
            return new d.x();
        L26:
            throw i(r10, "@Url cannot be used with @%s URL", new Object[]{this.f8072v});
        L28:
            throw i(r10, "A @Url parameter must not come after a @Query", new Object[0]);
        L30:
            throw i(r10, "@Path parameters may not be used with @Url.", new Object[0]);
        L32:
            throw i(r10, "Multiple @Url method annotations found.", new Object[0]);
        L34:
            if ((r13 instanceof retrofit2.http.Path) == false) goto L50;
            if (this.f8069s == true) goto L48;
            if (this.f8070t == true) goto L46;
            if (this.f8076z == null) goto L44;
            this.f8068r = true;
            retrofit2.http.Path r14 = (retrofit2.http.Path) r13;
            String r15 = r14.value();
            u(r10, r15);
            return new d.s(r15, this.f8051a.s(r11, r12), !r14.encoded());
        L44:
            throw i(r10, "@Path can only be used with relative url on @%s", new Object[]{this.f8072v});
        L46:
            throw i(r10, "@Path parameters may not be used with @Url.", new Object[0]);
        L48:
            throw i(r10, "A @Path parameter must not come after a @Query.", new Object[0]);
        L50:
            if ((r13 instanceof retrofit2.http.Query) == false) goto L66;
            retrofit2.http.Query r16 = (retrofit2.http.Query) r13;
            String r17 = r16.value();
            boolean r18 = r16.encoded();
            Class r19 = f6.g.j(r11);
            this.f8069s = true;
            if (Iterable.class.isAssignableFrom(r19) == false) goto L60;
            if ((r11 instanceof ParameterizedType) == false) goto L58;
            return new d.t(r17, this.f8051a.s(f6.g.i(0, (ParameterizedType) r11), r12), !r18).c();
        L58:
            throw i(r10, r19.getSimpleName() + " must include generic type (e.g., " + r19.getSimpleName() + "<String>)", new Object[0]);
        L60:
            if (r19.isArray() == false) goto L64;
            return new d.t(r17, this.f8051a.s(g.a(r19.getComponentType()), r12), !r18).b();
        L64:
            return new d.t(r17, this.f8051a.s(r11, r12), !r18);
        L66:
            if ((r13 instanceof retrofit2.http.QueryName) == false) goto L82;
            boolean r110 = ((retrofit2.http.QueryName) r13).encoded();
            Class r20 = f6.g.j(r11);
            this.f8069s = true;
            if (Iterable.class.isAssignableFrom(r20) == false) goto L76;
            if ((r11 instanceof ParameterizedType) == false) goto L74;
            return new d.v(this.f8051a.s(f6.g.i(0, (ParameterizedType) r11), r12), r110).c();
        L74:
            throw i(r10, r20.getSimpleName() + " must include generic type (e.g., " + r20.getSimpleName() + "<String>)", new Object[0]);
        L76:
            if (r20.isArray() == false) goto L80;
            return new d.v(this.f8051a.s(g.a(r20.getComponentType()), r12), r110).b();
        L80:
            return new d.v(this.f8051a.s(r11, r12), r110);
        L82:
            if ((r13 instanceof retrofit2.http.QueryMap) == false) goto L98;
            Class r21 = f6.g.j(r11);
            if (Map.class.isAssignableFrom(r21) == false) goto L96;
            Type r111 = f6.g.k(r11, r21, Map.class);
            if ((r111 instanceof ParameterizedType) == false) goto L94;
            ParameterizedType r112 = (ParameterizedType) r111;
            Type r22 = f6.g.i(0, r112);
            if (String.class != r22) goto L92;
            return new d.u(this.f8051a.s(f6.g.i(1, r112), r12), !((retrofit2.http.QueryMap) r13).encoded());
        L92:
            throw i(r10, "@QueryMap keys must be of type String: " + r22, new Object[0]);
        L94:
            throw i(r10, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L96:
            throw i(r10, "@QueryMap parameter type must be Map.", new Object[0]);
        L98:
            if ((r13 instanceof retrofit2.http.Header) == false) goto L114;
            String r113 = ((retrofit2.http.Header) r13).value();
            Class r23 = f6.g.j(r11);
            if (Iterable.class.isAssignableFrom(r23) == false) goto L108;
            if ((r11 instanceof ParameterizedType) == false) goto L106;
            return new d.l(r113, this.f8051a.s(f6.g.i(0, (ParameterizedType) r11), r12)).c();
        L106:
            throw i(r10, r23.getSimpleName() + " must include generic type (e.g., " + r23.getSimpleName() + "<String>)", new Object[0]);
        L108:
            if (r23.isArray() == false) goto L112;
            return new d.l(r113, this.f8051a.s(g.a(r23.getComponentType()), r12)).b();
        L112:
            return new d.l(r113, this.f8051a.s(r11, r12));
        L114:
            if ((r13 instanceof retrofit2.http.HeaderMap) == false) goto L130;
            Class r114 = f6.g.j(r11);
            if (Map.class.isAssignableFrom(r114) == false) goto L128;
            Type r115 = f6.g.k(r11, r114, Map.class);
            if ((r115 instanceof ParameterizedType) == false) goto L126;
            ParameterizedType r116 = (ParameterizedType) r115;
            Type r117 = f6.g.i(0, r116);
            if (String.class != r117) goto L124;
            return new d.n(this.f8051a.s(f6.g.i(1, r116), r12));
        L124:
            throw i(r10, "@HeaderMap keys must be of type String: " + r117, new Object[0]);
        L126:
            throw i(r10, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L128:
            throw i(r10, "@HeaderMap parameter type must be Map.", new Object[0]);
        L130:
            if ((r13 instanceof retrofit2.http.Field) == false) goto L150;
            if (this.f8074x == false) goto L148;
            retrofit2.http.Field r118 = (retrofit2.http.Field) r13;
            String r24 = r118.value();
            boolean r119 = r118.encoded();
            this.f8065o = true;
            Class r25 = f6.g.j(r11);
            if (Iterable.class.isAssignableFrom(r25) == false) goto L142;
            if ((r11 instanceof ParameterizedType) == false) goto L140;
            return new d.j(r24, this.f8051a.s(f6.g.i(0, (ParameterizedType) r11), r12), !r119).c();
        L140:
            throw i(r10, r25.getSimpleName() + " must include generic type (e.g., " + r25.getSimpleName() + "<String>)", new Object[0]);
        L142:
            if (r25.isArray() == false) goto L146;
            return new d.j(r24, this.f8051a.s(g.a(r25.getComponentType()), r12), !r119).b();
        L146:
            return new d.j(r24, this.f8051a.s(r11, r12), !r119);
        L148:
            throw i(r10, "@Field parameters can only be used with form encoding.", new Object[0]);
        L150:
            if ((r13 instanceof retrofit2.http.FieldMap) == false) goto L170;
            if (this.f8074x == false) goto L168;
            Class r26 = f6.g.j(r11);
            if (Map.class.isAssignableFrom(r26) == false) goto L166;
            Type r120 = f6.g.k(r11, r26, Map.class);
            if ((r120 instanceof ParameterizedType) == false) goto L164;
            ParameterizedType r121 = (ParameterizedType) r120;
            Type r27 = f6.g.i(0, r121);
            if (String.class != r27) goto L162;
            Converter r122 = this.f8051a.s(f6.g.i(1, r121), r12);
            this.f8065o = true;
            return new d.k(r122, !((retrofit2.http.FieldMap) r13).encoded());
        L162:
            throw i(r10, "@FieldMap keys must be of type String: " + r27, new Object[0]);
        L164:
            throw i(r10, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L166:
            throw i(r10, "@FieldMap parameter type must be Map.", new Object[0]);
        L168:
            throw i(r10, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
        L170:
            if ((r13 instanceof retrofit2.http.Part) == false) goto L181;
            if (this.f8075y == false) goto L179;
            retrofit2.http.Part r123 = (retrofit2.http.Part) r13;
            this.f8066p = true;
            d r124 = r(r11, r123.value(), r123.encoding());
            if (r124 == null) goto L177;
            return r124;
        L177:
            return new d.q(r123.value(), this.f8051a.o(r11, r12, this.f8053c));
        L179:
            throw i(r10, "@Part parameters can only be used with multipart encoding.", new Object[0]);
        L181:
            if ((r13 instanceof retrofit2.http.PartMap) == false) goto L204;
            if (this.f8075y == false) goto L202;
            this.f8066p = true;
            Class r28 = f6.g.j(r11);
            if (Map.class.isAssignableFrom(r28) == false) goto L200;
            Type r125 = f6.g.k(r11, r28, Map.class);
            if ((r125 instanceof ParameterizedType) == false) goto L198;
            ParameterizedType r126 = (ParameterizedType) r125;
            Type r29 = f6.g.i(0, r126);
            if (String.class != r29) goto L196;
            d r127 = s(r126, r13);
            if (r127 == null) goto L194;
            return r127;
        L194:
            return new d.r(this.f8051a.o(f6.g.i(1, r126), r12, this.f8053c), ((retrofit2.http.PartMap) r13).encoding());
        L196:
            throw i(r10, "@PartMap keys must be of type String: " + r29, new Object[0]);
        L198:
            throw i(r10, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L200:
            throw i(r10, "@PartMap parameter type must be Map.", new Object[0]);
        L202:
            throw i(r10, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
        L204:
            if ((r13 instanceof retrofit2.http.Body) == true) goto L206;
            return null;
        L206:
            if (this.f8074x == true) goto L224;
            if (this.f8075y == true) goto L224;
            if (this.f8067q == true) goto L222;
            d r128 = a(r11);
            if (r128 == null) goto L227;
            this.f8067q = true;
            return r128;
        L227:
            Converter r129 = this.f8051a.o(r11, r12, this.f8053c);     // Catch: RuntimeException -> L218
            this.f8067q = true;
            return new d.C0102d(this.f8061k, r129);
        L218:
            e = move-exception;
            throw j(e, r10, "Unable to create @Body converter for %s", new Object[]{r11});
        L222:
            throw i(r10, "Multiple @Body method annotations found.", new Object[0]);
        L224:
            throw i(r10, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
        }

        public final d r(Type r10, String r11, String r12) {
            Class r13 = f6.g.j(r10);
            if (TextUtils.isEmpty(r11) == false) goto L24;
            if (Iterable.class.isAssignableFrom(r13) == false) goto L14;
            if ((r10 instanceof ParameterizedType) == true) goto L10;
            return null;
        L10:
            if (h.b.class.isAssignableFrom(f6.g.j(f6.g.i(0, (ParameterizedType) r10))) == true) goto L12;
        L42:
            return null;
        L12:
            return d.h.f7968a.c();
        L14:
            if (r13.isArray() == false) goto L20;
            if (h.b.class.isAssignableFrom(r13.getComponentType()) == false) goto L42;
            return d.h.f7968a.b();
        L20:
            if (h.b.class.isAssignableFrom(r13) == false) goto L42;
            return d.h.f7968a;
        L24:
            if (Iterable.class.isAssignableFrom(r13) == false) goto L33;
            if ((r10 instanceof ParameterizedType) == true) goto L29;
            return null;
        L29:
            if (RequestBody.class.isAssignableFrom(f6.g.j(f6.g.i(0, (ParameterizedType) r10))) == false) goto L42;
            return new d.f(f(r11, r12)).c();
        L33:
            if (r13.isArray() == false) goto L39;
            if (RequestBody.class.isAssignableFrom(g.a(r13.getComponentType())) == false) goto L42;
            return new d.f(f(r11, r12)).b();
        L39:
            if (RequestBody.class.isAssignableFrom(r13) == false) goto L42;
            return new d.f(f(r11, r12));
        }

        public final d s(ParameterizedType r10, Annotation r11) {
            if (RequestBody.class.isAssignableFrom(f6.g.j(f6.g.i(1, r10))) == true) goto L5;
            return null;
        L5:
            return new d.g(((PartMap) r11).encoding());
        }

        public final void t(int r10, String r11) {
            if (g.A.matcher(r11).matches() == false) goto L13;
            String r12 = this.D;
            if (r12 != null) goto L7;
            return;
        L7:
            if (r12.equals(r11) == false) goto L10;
            return;
        L10:
            throw i(r10, "Method \"%s\" does not contain \"{%s}\".", new Object[]{this.f8072v, r11});
        L13:
            throw i(r10, "@Method parameter name must match %s. Found: %s", new Object[]{g.f8025z.pattern(), r11});
        }

        public final void u(int r10, String r11) {
            if (g.A.matcher(r11).matches() == false) goto L10;
            if (this.C.contains(r11) == false) goto L8;
            return;
        L8:
            throw i(r10, "URL \"%s\" does not contain \"{%s}\".", new Object[]{this.f8076z, r11});
        L10:
            throw i(r10, "@Path parameter name must match %s. Found: %s", new Object[]{g.f8025z.pattern(), r11});
        }
    }

    static {
        f8025z = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");
        A = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");
    }

    public g(a r10) {
        this.f8026a = r10.f8051a.d();
        this.f8027b = r10.G;
        this.f8028c = r10.f8051a.i();
        this.f8029d = r10.f8051a.h();
        this.f8039n = r10.f8051a.q();
        this.f8040o = r10.F;
        this.f8041p = r10.f8072v;
        this.f8042q = r10.f8076z;
        this.f8044s = r10.f8073w;
        this.f8045t = r10.f8074x;
        this.f8046u = r10.f8075y;
        this.f8047v = r10.E;
        this.f8048w = r10.A;
        this.f8049x = r10.B;
        this.f8030e = r10.f8056f;
        this.f8031f = r10.f8063m;
        this.f8032g = r10.f8057g;
        this.f8033h = r10.f8058h;
        this.f8034i = r10.f8059i;
        this.f8035j = r10.f8060j;
        this.f8043r = r10.f8061k;
        this.f8036k = r10.f8062l;
        this.f8037l = r10.f8052b;
        this.f8038m = r10.f8051a.b();
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

    public static String c(String r10) {
        Matcher r11 = f8025z.matcher(r10);
        if (r11.find() == true) goto L5;
        return null;
    L5:
        return r11.group(1);
    }

    public static Set d(String r10) {
        Matcher r11 = f8025z.matcher(r10);
        LinkedHashSet r12 = new LinkedHashSet();
    L4:
        if (r11.find() == false) goto L6;
        r12.add(r11.group(1));
        goto L4
    L6:
        return r12;
    }

    public RetrofitMetrics b() {
        return this.f8050y;
    }

    public void e(RetrofitMetrics r10) {
        this.f8050y = r10;
    }

    public g6.b f(ExpandCallback r20, Object... r21) {
        f6.d r15 = new f6.d(this.f8041p, this.f8039n, this.f8042q, this.f8048w, this.f8049x, this.f8030e, this.f8031f, this.f8033h, this.f8034i, this.f8035j, this.f8036k, this.f8044s, this.f8045t, this.f8046u, this.f8032g);
        d[] r10 = this.f8047v;
        int r11 = 0;
        if (r21 == null) goto L5;
        int r12 = r21.length;
    L7:
        if (r12 != r10.length) goto L14;
        ArrayList r13 = new ArrayList(r12);
    L9:
        if (r11 >= r12) goto L11;
        r13.add(r21[r11]);
        r10[r11].a(r15, r21[r11]);
        r11 = r11 + 1;
        goto L9
    L11:
        r15.i(f6.c.class, new f6.c(this.f8037l, r13));
        return r15.j(r20);
    L14:
        throw new IllegalArgumentException("Argument count (" + r12 + ") doesn't match expected count (" + r10.length + ")");
    L5:
        r12 = 0;
        goto L7
    }

    public Object g(TypedInput r10) {
        return this.f8040o.convert(r10);
    }
}
