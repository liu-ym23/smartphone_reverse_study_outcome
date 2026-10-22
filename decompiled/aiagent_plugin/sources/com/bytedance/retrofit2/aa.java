package com.bytedance.retrofit2;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
import retrofit2.http.Headers;
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
import retrofit2.http.Streaming;
import retrofit2.http.Tag;
import retrofit2.http.Url;

/* JADX INFO: compiled from: RequestFactory.java */
/* JADX INFO: loaded from: classes.dex */
final class aa<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final boolean f9378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final com.bytedance.retrofit2.b.a.InterfaceC0216a f9379b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final List<com.bytedance.retrofit2.d.b> f9380c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Executor f9381d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int f9382e;
    final int f;
    final String g;
    final boolean h;
    final int i;
    final boolean j;
    final int k;
    final Object l;
    final Method m;
    final com.bytedance.retrofit2.a.a n;
    public i<com.bytedance.retrofit2.e.i, T> o;
    final String p;
    private final k q;
    private final String r;
    private final boolean s;
    private final boolean t;
    private final boolean u;
    private final x<?>[] v;
    private final List<com.bytedance.retrofit2.b.b> w;
    private final String x;
    private af y;
    private final boolean z;

    /* JADX INFO: compiled from: RequestFactory.java */
    static final class a<T> {
        private static final Pattern L = null;
        private static final Pattern M = null;
        boolean A;
        boolean B;
        String C;
        List<com.bytedance.retrofit2.b.b> D;
        String E;
        Set<String> F;
        String G;
        x<?>[] H;
        i<com.bytedance.retrofit2.e.i, T> I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        boolean f9383J;
        boolean K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ab f9384a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Method f9385b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Annotation[] f9386c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Annotation[][] f9387d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final Type[] f9388e;
        final af f;
        int g;
        String h;
        boolean i;
        int j;
        boolean k;
        int l;
        boolean m;
        Object n;
        int o;
        boolean p;
        boolean q;
        boolean r;
        boolean s;
        boolean t;
        boolean u;
        boolean v;
        boolean w;
        boolean x;
        String y;
        boolean z;

        static {
            L = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");
            M = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");
        }

        a(ab r4, Method r5, af r6) {
            this.g = 1;
            this.h = "";
            this.i = false;
            this.j = -1;
            this.k = true;
            this.l = 0;
            this.m = false;
            this.n = null;
            this.o = 3;
            this.f9384a = r4;
            this.f9385b = r5;
            this.f9386c = r5.getAnnotations();
            this.f9388e = r5.getGenericParameterTypes();
            this.f9387d = r5.getParameterAnnotations();
            this.f = r6;
        }

        aa a() {
            Annotation[] r0 = this.f9386c;
            int r1 = r0.length;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L9;
            Annotation r4 = r0[r3];
            a(r4);
            if (y.b() == false) goto L7;
            b(r4);
        L7:
            r3 = r3 + 1;
            goto L3
        L9:
            if (this.y == null) goto L67;
            if (this.z == false) goto L13;
        L23:
            int r2 = this.f9387d.length;
            this.H = new x[r2];
            int r5 = r2 - 1;
            int r6 = 0;
        L24:
            boolean r7 = true;
            if (r6 >= r2) goto L32;
            x<?>[] r8 = this.H;
            Type r9 = this.f9388e[r6];
            Annotation[] r10 = this.f9387d[r6];
            if (r6 == r5) goto L30;
            r7 = false;
        L30:
            r8[r6] = a(r6, r9, r10, r7);
            r6 = r6 + 1;
            goto L24
        L32:
            if (this.C == null) goto L34;
        L38:
            boolean r11 = this.A;
            if (r11 == false) goto L41;
        L51:
            if (r11 == false) goto L58;
            if (this.p == true) goto L58;
            throw an.a(this.f9385b, "Form-encoded method must contain at least one @Field.", new Object[0]);
        L58:
            if (this.B == false) goto L65;
            if (this.q == true) goto L65;
            throw an.a(this.f9385b, "Multipart method must contain at least one @Part.", new Object[0]);
        L65:
            return new aa(this);
        L41:
            if (this.B == true) goto L51;
            if (this.z == true) goto L51;
            if (this.m == true) goto L51;
            if (this.r == false) goto L51;
            throw an.a(this.f9385b, "Non-body HTTP method cannot contain @Body.", new Object[0]);
        L34:
            if (this.w == true) goto L38;
            throw an.a(this.f9385b, "Missing either @%s URL or @Url parameter.", new Object[]{this.y});
        L13:
            if (this.m == true) goto L23;
            if (this.B == true) goto L22;
            if (this.A == false) goto L23;
            throw an.a(this.f9385b, "FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
        L22:
            throw an.a(this.f9385b, "Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
        L67:
            throw an.a(this.f9385b, "HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
        }

        private void a(Annotation r6) {
            Annotation r7 = (Annotation) ZeusTransformUtils.wrapperContextForParams(r6, Annotation.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r7, com.bytedance.retrofit2.c.c.class) == false) goto L6;
            a("DELETE", ((com.bytedance.retrofit2.c.c) ZeusTransformUtils.preCheckCast(r7, com.bytedance.retrofit2.c.c.class, "com.obric.aiagent.plugin")).a(), false);
            return;
        L6:
            if (ZeusTransformUtils.instanceOf(r7, com.bytedance.retrofit2.c.h.class) == false) goto L9;
            a("GET", ((com.bytedance.retrofit2.c.h) ZeusTransformUtils.preCheckCast(r7, com.bytedance.retrofit2.c.h.class, "com.obric.aiagent.plugin")).a(), false);
            return;
        L9:
            if (ZeusTransformUtils.instanceOf(r7, com.bytedance.retrofit2.c.i.class) == false) goto L12;
            a("HEAD", ((com.bytedance.retrofit2.c.i) ZeusTransformUtils.preCheckCast(r7, com.bytedance.retrofit2.c.i.class, "com.obric.aiagent.plugin")).a(), false);
            return;
        L12:
            if (ZeusTransformUtils.instanceOf(r7, com.bytedance.retrofit2.c.s.class) == false) goto L15;
            a("PATCH", ((com.bytedance.retrofit2.c.s) ZeusTransformUtils.preCheckCast(r7, com.bytedance.retrofit2.c.s.class, "com.obric.aiagent.plugin")).a(), true);
            return;
        L15:
            if (ZeusTransformUtils.instanceOf(r7, com.bytedance.retrofit2.c.t.class) == false) goto L18;
            a("POST", ((com.bytedance.retrofit2.c.t) ZeusTransformUtils.preCheckCast(r7, com.bytedance.retrofit2.c.t.class, "com.obric.aiagent.plugin")).a(), true);
            return;
        L18:
            if (ZeusTransformUtils.instanceOf(r7, com.bytedance.retrofit2.c.u.class) == false) goto L21;
            a("PUT", ((com.bytedance.retrofit2.c.u) ZeusTransformUtils.preCheckCast(r7, com.bytedance.retrofit2.c.u.class, "com.obric.aiagent.plugin")).a(), true);
            return;
        L21:
            if (ZeusTransformUtils.instanceOf(r7, com.bytedance.retrofit2.c.r.class) == false) goto L24;
            a("OPTIONS", ((com.bytedance.retrofit2.c.r) ZeusTransformUtils.preCheckCast(r7, com.bytedance.retrofit2.c.r.class, "com.obric.aiagent.plugin")).a(), false);
            return;
        L24:
            if (ZeusTransformUtils.instanceOf(r7, com.bytedance.retrofit2.c.j.class) == false) goto L27;
            com.bytedance.retrofit2.c.j r8 = (com.bytedance.retrofit2.c.j) ZeusTransformUtils.preCheckCast(r7, com.bytedance.retrofit2.c.j.class, "com.obric.aiagent.plugin");
            a(r8.a(), r8.b(), r8.c());
            return;
        L27:
            if (ZeusTransformUtils.instanceOf(r7, com.bytedance.retrofit2.c.n.class) == false) goto L34;
            String[] r9 = ((com.bytedance.retrofit2.c.n) ZeusTransformUtils.preCheckCast(r7, com.bytedance.retrofit2.c.n.class, "com.obric.aiagent.plugin")).a();
            if (r9.length == 0) goto L32;
            this.D = a(r9);
            return;
        L32:
            throw an.a(this.f9385b, "@Headers annotation is empty.", new Object[0]);
        L34:
            if (ZeusTransformUtils.instanceOf(r7, com.bytedance.retrofit2.c.q.class) == false) goto L41;
            if (this.A == true) goto L39;
            this.B = true;
            return;
        L39:
            throw an.a(this.f9385b, "Only one encoding annotation is allowed.", new Object[0]);
        L41:
            if (ZeusTransformUtils.instanceOf(r7, com.bytedance.retrofit2.c.g.class) == false) goto L48;
            if (this.B == true) goto L46;
            this.A = true;
            this.K = ((com.bytedance.retrofit2.c.g) ZeusTransformUtils.preCheckCast(r7, com.bytedance.retrofit2.c.g.class, "com.obric.aiagent.plugin")).a();
            return;
        L46:
            throw an.a(this.f9385b, "Only one encoding annotation is allowed.", new Object[0]);
        L48:
            if (ZeusTransformUtils.instanceOf(r7, com.bytedance.retrofit2.c.ae.class) == false) goto L51;
            this.i = true;
            return;
        L51:
            if (ZeusTransformUtils.instanceOf(r7, com.bytedance.retrofit2.c.y.class) == false) goto L54;
            this.g = ((com.bytedance.retrofit2.c.y) ZeusTransformUtils.preCheckCast(r7, com.bytedance.retrofit2.c.y.class, "com.obric.aiagent.plugin")).a();
            return;
        L54:
            if (ZeusTransformUtils.instanceOf(r7, com.bytedance.retrofit2.c.ad.class) == false) goto L57;
            this.h = ((com.bytedance.retrofit2.c.ad) ZeusTransformUtils.preCheckCast(r7, com.bytedance.retrofit2.c.ad.class, "com.obric.aiagent.plugin")).a();
            return;
        L57:
            if (ZeusTransformUtils.instanceOf(r7, com.bytedance.retrofit2.c.ac.class) == false) goto L74;
            this.o = ((com.bytedance.retrofit2.c.ac) ZeusTransformUtils.preCheckCast(r7, com.bytedance.retrofit2.c.ac.class, "com.obric.aiagent.plugin")).a();
            return;
        }

        private void b(Annotation r5) {
            Annotation r6 = (Annotation) ZeusTransformUtils.wrapperContextForParams(r5, Annotation.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r6, DELETE.class) == false) goto L6;
            a("DELETE", ((DELETE) ZeusTransformUtils.preCheckCast(r6, DELETE.class, "com.obric.aiagent.plugin")).value(), false);
            return;
        L6:
            if (ZeusTransformUtils.instanceOf(r6, GET.class) == false) goto L9;
            a("GET", ((GET) ZeusTransformUtils.preCheckCast(r6, GET.class, "com.obric.aiagent.plugin")).value(), false);
            return;
        L9:
            if (ZeusTransformUtils.instanceOf(r6, HEAD.class) == false) goto L12;
            a("HEAD", ((HEAD) ZeusTransformUtils.preCheckCast(r6, HEAD.class, "com.obric.aiagent.plugin")).value(), false);
            return;
        L12:
            if (ZeusTransformUtils.instanceOf(r6, PATCH.class) == false) goto L15;
            a("PATCH", ((PATCH) ZeusTransformUtils.preCheckCast(r6, PATCH.class, "com.obric.aiagent.plugin")).value(), true);
            return;
        L15:
            if (ZeusTransformUtils.instanceOf(r6, POST.class) == false) goto L18;
            a("POST", ((POST) ZeusTransformUtils.preCheckCast(r6, POST.class, "com.obric.aiagent.plugin")).value(), true);
            return;
        L18:
            if (ZeusTransformUtils.instanceOf(r6, PUT.class) == false) goto L21;
            a("PUT", ((PUT) ZeusTransformUtils.preCheckCast(r6, PUT.class, "com.obric.aiagent.plugin")).value(), true);
            return;
        L21:
            if (ZeusTransformUtils.instanceOf(r6, OPTIONS.class) == false) goto L24;
            a("OPTIONS", ((OPTIONS) ZeusTransformUtils.preCheckCast(r6, OPTIONS.class, "com.obric.aiagent.plugin")).value(), false);
            return;
        L24:
            if (ZeusTransformUtils.instanceOf(r6, HTTP.class) == false) goto L27;
            HTTP r7 = (HTTP) ZeusTransformUtils.preCheckCast(r6, HTTP.class, "com.obric.aiagent.plugin");
            a(r7.method(), r7.path(), r7.hasBody());
            return;
        L27:
            if (ZeusTransformUtils.instanceOf(r6, Headers.class) == false) goto L34;
            String[] r8 = ((Headers) ZeusTransformUtils.preCheckCast(r6, Headers.class, "com.obric.aiagent.plugin")).value();
            if (r8.length == 0) goto L32;
            this.D = a(r8);
            return;
        L32:
            throw an.a(this.f9385b, "@Headers annotation is empty.", new Object[0]);
        L34:
            if (ZeusTransformUtils.instanceOf(r6, Multipart.class) == false) goto L41;
            if (this.A == true) goto L39;
            this.B = true;
            return;
        L39:
            throw an.a(this.f9385b, "Only one encoding annotation is allowed.", new Object[0]);
        L41:
            if (ZeusTransformUtils.instanceOf(r6, FormUrlEncoded.class) == false) goto L48;
            if (this.B == true) goto L46;
            this.A = true;
            return;
        L46:
            throw an.a(this.f9385b, "Only one encoding annotation is allowed.", new Object[0]);
        L48:
            if (ZeusTransformUtils.instanceOf(r6, Streaming.class) == false) goto L62;
            this.i = true;
            return;
        }

        private void a(String r4, String r5, boolean r6) {
            String r0 = this.y;
            if (r0 != null) goto L31;
            this.y = r4;
            if (r4 == null) goto L8;
            this.G = b(r4);
        L8:
            if (this.G == null) goto L10;
            this.m = true;
        L10:
            this.z = r6;
            if (r5.isEmpty() == false) goto L13;
            return;
        L13:
            int r7 = r5.indexOf(63);
            if (r7 != (-1)) goto L16;
        L28:
            this.C = r5;
            this.F = a(r5);
            return;
        L16:
            if (r7 >= (r5.length() - 1)) goto L28;
            String r8 = r5.substring(r7 + 1);     // Catch: IllegalArgumentException -> L23
            if (L.matcher(r8).find() == false) goto L28;
            throw an.a(this.f9385b, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", new Object[]{r8});     // Catch: IllegalArgumentException -> L23
        L23:
            e = move-exception;
            if (e.getMessage().contains("URL query string") == false) goto L28;
            throw e;
        L31:
            throw an.a(this.f9385b, "Only one HTTP method is allowed. Found: %s and %s.", new Object[]{r0, r4});
        }

        private List<com.bytedance.retrofit2.b.b> a(String[] r9) {
            ArrayList r0 = new ArrayList();
            int r1 = r9.length;
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L16;
            String r4 = r9[r3];
            int r5 = r4.indexOf(58);
            if (r5 == (-1)) goto L15;
            if (r5 == 0) goto L15;
            if (r5 == (r4.length() - 1)) goto L15;
            String r6 = r4.substring(0, r5);
            String r7 = r4.substring(r5 + 1).trim();
            if (DownloadHelper.CONTENT_TYPE.equalsIgnoreCase(r6) == false) goto L12;
            this.E = r7;
        L13:
            r3 = r3 + 1;
            goto L3
        L12:
            r0.add(new com.bytedance.retrofit2.b.b(r6, r7));
        L15:
            throw an.a(this.f9385b, "@Headers value must be in the form \"Name: Value\". Found: \"%s\"", new Object[]{r4});
        L16:
            return r0;
        }

        private x<?> a(int r9, Type r10, Annotation[] r11, boolean r12) {
            Type r13 = (Type) ZeusTransformUtils.wrapperContextForParams(r10, Type.class, "com.obric.aiagent.plugin");
            if (r11 == null) goto L18;
            int r2 = r11.length;
            x<?> r4 = null;
            int r3 = 0;
        L5:
            if (r3 >= r2) goto L19;
            Annotation r5 = r11[r3];
            x<?> r6 = a(r9, r13, r11, r5);
            if (r6 == null) goto L9;
        L11:
            if (r6 == null) goto L15;
            if (r4 != null) goto L17;
            r4 = r6;
            goto L15
        L17:
            throw an.a(this.f9385b, r9, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
        L15:
            r3 = r3 + 1;
            goto L5
        L9:
            if (y.b() == false) goto L11;
            r6 = b(r9, r13, r11, r5);
        L19:
            if (r4 != null) goto L27;
            if (r12 == false) goto L26;
            if (an.a(r13) != d.c.d.class) goto L26;
            this.f9383J = true;     // Catch: NoClassDefFoundError -> L28
            return null;
        L26:
            throw an.a(this.f9385b, r9, "No Retrofit annotation found.", new Object[0]);
        L27:
            return r4;
        L18:
            r4 = null;
            goto L19
        }

        private x<?> a(int r8, Type r9, Annotation[] r10, Annotation r11) {
            Type r12 = (Type) ZeusTransformUtils.wrapperContextForParams(r9, Type.class, "com.obric.aiagent.plugin");
            Annotation r13 = (Annotation) ZeusTransformUtils.wrapperContextForParams(r11, Annotation.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r13, com.bytedance.retrofit2.c.ag.class) == false) goto L42;
            a(r8, r12);
            if (this.w == true) goto L40;
            if (this.s == true) goto L38;
            if (this.t == true) goto L36;
            if (this.C != null) goto L34;
            if (this.u == true) goto L32;
            if (this.v == true) goto L30;
            this.w = true;
            if (r12 == String.class) goto L28;
            if (r12 == URI.class) goto L28;
            if (ZeusTransformUtils.instanceOf(r12, Class.class) == false) goto L26;
            if ("android.net.Uri".equals(((Class) ZeusTransformUtils.preCheckCast(r12, Class.class, "com.obric.aiagent.plugin")).getName()) == true) goto L28;
        L26:
            throw an.a(this.f9385b, r8, "@Url must be String, java.net.URI, or android.net.Uri type.", new Object[0]);
        L28:
            return new x.v(this.f9385b, r8);
        L30:
            throw an.a(this.f9385b, r8, "A @Url parameter must not come after a @QueryMap.", new Object[0]);
        L32:
            throw an.a(this.f9385b, r8, "A @Url parameter must not come after a @QueryName.", new Object[0]);
        L34:
            throw an.a(this.f9385b, r8, "@Url cannot be used with @%s URL", new Object[]{this.y});
        L36:
            throw an.a(this.f9385b, r8, "A @Url parameter must not come after a @Query.", new Object[0]);
        L38:
            throw an.a(this.f9385b, r8, "@Path parameters may not be used with @Url.", new Object[0]);
        L40:
            throw an.a(this.f9385b, r8, "Multiple @Url method annotations found.", new Object[0]);
        L42:
            if (ZeusTransformUtils.instanceOf(r13, com.bytedance.retrofit2.c.x.class) == false) goto L66;
            a(r8, r12);
            if (this.t == true) goto L64;
            if (this.w == true) goto L62;
            if (this.C == null) goto L60;
            if (this.u == true) goto L58;
            if (this.v == true) goto L56;
            this.s = true;
            com.bytedance.retrofit2.c.x r14 = (com.bytedance.retrofit2.c.x) ZeusTransformUtils.preCheckCast(r13, com.bytedance.retrofit2.c.x.class, "com.obric.aiagent.plugin");
            String r3 = r14.a();
            b(r8, r3);
            return new x.q(this.f9385b, r8, r3, this.f9384a.d(r12, r10), r14.b());
        L56:
            throw an.a(this.f9385b, r8, "A @Path parameter must not come after a @QueryMap.", new Object[0]);
        L58:
            throw an.a(this.f9385b, r8, "A @Path parameter must not come after a @QueryName.", new Object[0]);
        L60:
            throw an.a(this.f9385b, r8, "@Path can only be used with relative url on @%s", new Object[]{this.y});
        L62:
            throw an.a(this.f9385b, r8, "@Path parameters may not be used with @Url.", new Object[0]);
        L64:
            throw an.a(this.f9385b, r8, "A @Path parameter must not come after a @Query.", new Object[0]);
        L66:
            if (ZeusTransformUtils.instanceOf(r13, com.bytedance.retrofit2.c.z.class) == false) goto L82;
            a(r8, r12);
            com.bytedance.retrofit2.c.z r15 = (com.bytedance.retrofit2.c.z) ZeusTransformUtils.preCheckCast(r13, com.bytedance.retrofit2.c.z.class, "com.obric.aiagent.plugin");
            String r0 = r15.a();
            boolean r16 = r15.b();
            Class<?> r6 = an.a(r12);
            this.t = true;
            if (Iterable.class.isAssignableFrom(r6) == false) goto L76;
            if (ZeusTransformUtils.instanceOf(r12, ParameterizedType.class) == false) goto L74;
            return new x.r(r0, this.f9384a.d(an.a(0, (ParameterizedType) ZeusTransformUtils.preCheckCast(r12, ParameterizedType.class, "com.obric.aiagent.plugin")), r10), r16).a();
        L74:
            throw an.a(this.f9385b, r8, r6.getSimpleName() + " must include generic type (e.g., " + r6.getSimpleName() + "<String>)", new Object[0]);
        L76:
            if (r6.isArray() == false) goto L80;
            return new x.r(r0, this.f9384a.d(a(r6.getComponentType()), r10), r16).b();
        L80:
            return new x.r(r0, this.f9384a.d(r12, r10), r16);
        L82:
            if (ZeusTransformUtils.instanceOf(r13, com.bytedance.retrofit2.c.ab.class) == false) goto L98;
            a(r8, r12);
            boolean r17 = ((com.bytedance.retrofit2.c.ab) ZeusTransformUtils.preCheckCast(r13, com.bytedance.retrofit2.c.ab.class, "com.obric.aiagent.plugin")).a();
            Class<?> r1 = an.a(r12);
            this.u = true;
            if (Iterable.class.isAssignableFrom(r1) == false) goto L92;
            if (ZeusTransformUtils.instanceOf(r12, ParameterizedType.class) == false) goto L90;
            return new x.t(this.f9384a.d(an.a(0, (ParameterizedType) ZeusTransformUtils.preCheckCast(r12, ParameterizedType.class, "com.obric.aiagent.plugin")), r10), r17).a();
        L90:
            throw an.a(this.f9385b, r8, r1.getSimpleName() + " must include generic type (e.g., " + r1.getSimpleName() + "<String>)", new Object[0]);
        L92:
            if (r1.isArray() == false) goto L96;
            return new x.t(this.f9384a.d(a(r1.getComponentType()), r10), r17).b();
        L96:
            return new x.t(this.f9384a.d(r12, r10), r17);
        L98:
            if (ZeusTransformUtils.instanceOf(r13, com.bytedance.retrofit2.c.aa.class) == false) goto L114;
            a(r8, r12);
            Class<?> r2 = an.a(r12);
            this.v = true;
            if (Map.class.isAssignableFrom(r2) == false) goto L112;
            Type r18 = an.b(r12, r2, Map.class);
            if (ZeusTransformUtils.instanceOf(r18, ParameterizedType.class) == false) goto L110;
            ParameterizedType r19 = (ParameterizedType) ZeusTransformUtils.preCheckCast(r18, ParameterizedType.class, "com.obric.aiagent.plugin");
            Type r4 = an.a(0, r19);
            if (String.class != r4) goto L108;
            return new x.s(this.f9385b, r8, this.f9384a.d(an.a(1, r19), r10), ((com.bytedance.retrofit2.c.aa) ZeusTransformUtils.preCheckCast(r13, com.bytedance.retrofit2.c.aa.class, "com.obric.aiagent.plugin")).a());
        L108:
            throw an.a(this.f9385b, r8, "@QueryMap keys must be of type String: " + r4, new Object[0]);
        L110:
            throw an.a(this.f9385b, r8, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L112:
            throw an.a(this.f9385b, r8, "@QueryMap parameter type must be Map.", new Object[0]);
        L114:
            if (ZeusTransformUtils.instanceOf(r13, com.bytedance.retrofit2.c.k.class) == false) goto L130;
            a(r8, r12);
            String r110 = ((com.bytedance.retrofit2.c.k) ZeusTransformUtils.preCheckCast(r13, com.bytedance.retrofit2.c.k.class, "com.obric.aiagent.plugin")).a();
            Class<?> r5 = an.a(r12);
            if (Iterable.class.isAssignableFrom(r5) == false) goto L124;
            if (ZeusTransformUtils.instanceOf(r12, ParameterizedType.class) == false) goto L122;
            return new x.j(r110, this.f9384a.d(an.a(0, (ParameterizedType) ZeusTransformUtils.preCheckCast(r12, ParameterizedType.class, "com.obric.aiagent.plugin")), r10)).a();
        L122:
            throw an.a(this.f9385b, r8, r5.getSimpleName() + " must include generic type (e.g., " + r5.getSimpleName() + "<String>)", new Object[0]);
        L124:
            if (r5.isArray() == false) goto L128;
            return new x.j(r110, this.f9384a.d(a(r5.getComponentType()), r10)).b();
        L128:
            return new x.j(r110, this.f9384a.d(r12, r10));
        L130:
            if (ZeusTransformUtils.instanceOf(r13, com.bytedance.retrofit2.c.l.class) == false) goto L146;
            Class<?> r111 = an.a(r12);
            if (List.class.isAssignableFrom(r111) == false) goto L144;
            Type r20 = an.b(r12, r111, List.class);
            if (ZeusTransformUtils.instanceOf(r20, ParameterizedType.class) == false) goto L142;
            Type r21 = an.a(0, (ParameterizedType) ZeusTransformUtils.preCheckCast(r20, ParameterizedType.class, "com.obric.aiagent.plugin"));
            if (com.bytedance.retrofit2.b.b.class != r21) goto L140;
            return new x.k(this.f9384a.e(r21, r10));
        L140:
            throw an.a(this.f9385b, r8, "@HeaderList keys must be of type retrofit.client.Header: " + r21, new Object[0]);
        L142:
            throw an.a(this.f9385b, r8, "List must include generic types (e.g., List<Header>)", new Object[0]);
        L144:
            throw an.a(this.f9385b, r8, "@HeaderList parameter type must be List.", new Object[0]);
        L146:
            if (ZeusTransformUtils.instanceOf(r13, com.bytedance.retrofit2.c.m.class) == false) goto L162;
            a(r8, r12);
            Class<?> r112 = an.a(r12);
            if (Map.class.isAssignableFrom(r112) == false) goto L160;
            Type r22 = an.b(r12, r112, Map.class);
            if (ZeusTransformUtils.instanceOf(r22, ParameterizedType.class) == false) goto L158;
            ParameterizedType r23 = (ParameterizedType) ZeusTransformUtils.preCheckCast(r22, ParameterizedType.class, "com.obric.aiagent.plugin");
            Type r113 = an.a(0, r23);
            if (String.class != r113) goto L156;
            return new x.l(this.f9385b, r8, this.f9384a.d(an.a(1, r23), r10));
        L156:
            throw an.a(this.f9385b, r8, "@HeaderMap keys must be of type String: " + r113, new Object[0]);
        L158:
            throw an.a(this.f9385b, r8, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L160:
            throw an.a(this.f9385b, r8, "@HeaderMap parameter type must be Map.", new Object[0]);
        L162:
            if (ZeusTransformUtils.instanceOf(r13, com.bytedance.retrofit2.c.e.class) == false) goto L182;
            a(r8, r12);
            if (this.A == false) goto L180;
            com.bytedance.retrofit2.c.e r114 = (com.bytedance.retrofit2.c.e) ZeusTransformUtils.preCheckCast(r13, com.bytedance.retrofit2.c.e.class, "com.obric.aiagent.plugin");
            String r7 = r114.a();
            boolean r115 = r114.b();
            this.p = true;
            Class<?> r24 = an.a(r12);
            if (Iterable.class.isAssignableFrom(r24) == false) goto L174;
            if (ZeusTransformUtils.instanceOf(r12, ParameterizedType.class) == false) goto L172;
            return new x.h(r7, this.f9384a.d(an.a(0, (ParameterizedType) ZeusTransformUtils.preCheckCast(r12, ParameterizedType.class, "com.obric.aiagent.plugin")), r10), r115).a();
        L172:
            throw an.a(this.f9385b, r8, r24.getSimpleName() + " must include generic type (e.g., " + r24.getSimpleName() + "<String>)", new Object[0]);
        L174:
            if (r24.isArray() == false) goto L178;
            return new x.h(r7, this.f9384a.d(a(r24.getComponentType()), r10), r115).b();
        L178:
            return new x.h(r7, this.f9384a.d(r12, r10), r115);
        L180:
            throw an.a(this.f9385b, r8, "@Field parameters can only be used with form encoding.", new Object[0]);
        L182:
            if (ZeusTransformUtils.instanceOf(r13, com.bytedance.retrofit2.c.f.class) == false) goto L202;
            a(r8, r12);
            if (this.A == false) goto L200;
            Class<?> r25 = an.a(r12);
            if (Map.class.isAssignableFrom(r25) == false) goto L198;
            Type r26 = an.b(r12, r25, Map.class);
            if (ZeusTransformUtils.instanceOf(r26, ParameterizedType.class) == false) goto L196;
            ParameterizedType r27 = (ParameterizedType) ZeusTransformUtils.preCheckCast(r26, ParameterizedType.class, "com.obric.aiagent.plugin");
            Type r28 = an.a(0, r27);
            if (String.class != r28) goto L194;
            i<T, String> r29 = this.f9384a.d(an.a(1, r27), r10);
            this.p = true;
            return new x.i(this.f9385b, r8, r29, ((com.bytedance.retrofit2.c.f) ZeusTransformUtils.preCheckCast(r13, com.bytedance.retrofit2.c.f.class, "com.obric.aiagent.plugin")).a());
        L194:
            throw an.a(this.f9385b, r8, "@FieldMap keys must be of type String: " + r28, new Object[0]);
        L196:
            throw an.a(this.f9385b, r8, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L198:
            throw an.a(this.f9385b, r8, "@FieldMap parameter type must be Map.", new Object[0]);
        L200:
            throw an.a(this.f9385b, r8, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
        L202:
            if (ZeusTransformUtils.instanceOf(r13, com.bytedance.retrofit2.c.v.class) == false) goto L213;
            if (this.B == false) goto L211;
            com.bytedance.retrofit2.c.v r116 = (com.bytedance.retrofit2.c.v) ZeusTransformUtils.preCheckCast(r13, com.bytedance.retrofit2.c.v.class, "com.obric.aiagent.plugin");
            this.q = true;
            x<?> r30 = a(r12, r116.a(), r116.b());
            if (r30 == null) goto L209;
            return r30;
        L209:
            return new x.o(this.f9385b, r8, r116.a(), this.f9384a.a(r12, r10, this.f9386c));
        L211:
            throw an.a(this.f9385b, r8, "@Part parameters can only be used with multipart encoding.", new Object[0]);
        L213:
            if (ZeusTransformUtils.instanceOf(r13, com.bytedance.retrofit2.c.w.class) == false) goto L236;
            a(r8, r12);
            if (this.B == false) goto L234;
            this.q = true;
            Class<?> r31 = an.a(r12);
            if (Map.class.isAssignableFrom(r31) == false) goto L232;
            Type r32 = an.b(r12, r31, Map.class);
            if (ZeusTransformUtils.instanceOf(r32, ParameterizedType.class) == false) goto L230;
            ParameterizedType r33 = (ParameterizedType) ZeusTransformUtils.preCheckCast(r32, ParameterizedType.class, "com.obric.aiagent.plugin");
            Type r34 = an.a(0, r33);
            if (String.class != r34) goto L228;
            x<?> r35 = a(r33, r13);
            if (r35 == null) goto L226;
            return r35;
        L226:
            return new x.p(this.f9385b, r8, this.f9384a.a(an.a(1, r33), r10, this.f9386c), ((com.bytedance.retrofit2.c.w) ZeusTransformUtils.preCheckCast(r13, com.bytedance.retrofit2.c.w.class, "com.obric.aiagent.plugin")).a());
        L228:
            throw an.a(this.f9385b, r8, "@PartMap keys must be of type String: " + r34, new Object[0]);
        L230:
            throw an.a(this.f9385b, r8, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L232:
            throw an.a(this.f9385b, r8, "@PartMap parameter type must be Map.", new Object[0]);
        L234:
            throw an.a(this.f9385b, r8, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
        L236:
            if (ZeusTransformUtils.instanceOf(r13, com.bytedance.retrofit2.c.b.class) == false) goto L258;
            a(r8, r12);
            if (this.A == true) goto L256;
            if (this.B == true) goto L256;
            if (this.r == true) goto L254;
            x<?> r117 = a(r12);
            if (r117 == null) goto L316;
            this.r = true;
            return r117;
        L316:
            i<T, com.bytedance.retrofit2.e.j> r36 = this.f9384a.a(r12, r10, this.f9386c);     // Catch: RuntimeException -> L250
            this.r = true;
            return new x.b(this.f9385b, r8, this.m, r36);
        L250:
            e = move-exception;
            throw an.a(this.f9385b, e, r8, "Unable to create @Body converter for %s", new Object[]{r12});
        L254:
            throw an.a(this.f9385b, r8, "Multiple @Body method annotations found.", new Object[0]);
        L256:
            throw an.a(this.f9385b, r8, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
        L258:
            if (ZeusTransformUtils.instanceOf(r13, com.bytedance.retrofit2.c.p.class) == false) goto L266;
            if (this.x == true) goto L264;
            this.x = true;
            String r118 = ((com.bytedance.retrofit2.c.p) ZeusTransformUtils.preCheckCast(r13, com.bytedance.retrofit2.c.p.class, "com.obric.aiagent.plugin")).a();
            a(r8, r118);
            return new x.n(r118, this.f9384a.d(r12, r10));
        L264:
            throw an.a(this.f9385b, r8, "Multiple @Method method annotations found.", new Object[0]);
        L266:
            if (ZeusTransformUtils.instanceOf(r13, com.bytedance.retrofit2.c.o.class) == false) goto L274;
            return new x.m(this.f9384a.d(r12, r10));
        L270:
            e = move-exception;
            throw an.a(this.f9385b, e, r8, "Unable to create @MaxLength converter for %s", new Object[]{r12});
        L274:
            if (ZeusTransformUtils.instanceOf(r13, com.bytedance.retrofit2.c.a.class) == false) goto L283;
            this.l = ((com.bytedance.retrofit2.c.a) ZeusTransformUtils.preCheckCast(r13, com.bytedance.retrofit2.c.a.class, "com.obric.aiagent.plugin")).a();
            return new x.a(this.f9384a.d(r12, r10));
        L279:
            e = move-exception;
            throw an.a(this.f9385b, e, r8, "Unable to create @AddCommonParam converter for %s", new Object[]{r12});
        L283:
            if (ZeusTransformUtils.instanceOf(r13, com.bytedance.retrofit2.c.d.class) == false) goto L291;
            return new x.g(this.f9384a.c(r12, r10));
        L287:
            e = move-exception;
            throw an.a(this.f9385b, e, r8, "Unable to create @ExtraInfo converter for %s", new Object[]{r12});
        L291:
            if (ZeusTransformUtils.instanceOf(r13, com.bytedance.retrofit2.c.a.a.class) == false) goto L299;
            if (com.bytedance.retrofit2.c.a.b.class.isAssignableFrom(an.a(r12)) == false) goto L297;
            return new x.u();
        L297:
            throw an.a(this.f9385b, r8, "Unable to create @QueryObject for %s not QueryParamObject type", new Object[]{r12});
        L299:
            if (ZeusTransformUtils.instanceOf(r13, com.bytedance.retrofit2.c.af.class) == false) goto L312;
            a(r8, r12);
            Class<?> r37 = an.a(r12);
            int r119 = r8 - 1;
        L301:
            if (r119 < 0) goto L311;
            x<?> r120 = this.H[r119];
            if (ZeusTransformUtils.instanceOf(r120, x.w.class) == false) goto L309;
            if (((x.w) ZeusTransformUtils.preCheckCast(r120, x.w.class, "com.obric.aiagent.plugin")).f9680a.equals(r37) == false) goto L309;
            throw an.a(this.f9385b, r8, "@Tag type " + r37.getName() + " is duplicate of parameter #" + (r119 + 1) + " and would always overwrite its value.", new Object[0]);
        L309:
            r119 = r119 - 1;
            goto L301
        L311:
            return new x.w(r37);
        L312:
            return null;
        }

        private x<?> b(int r11, Type r12, Annotation[] r13, Annotation r14) {
            Type r15 = (Type) ZeusTransformUtils.wrapperContextForParams(r12, Type.class, "com.obric.aiagent.plugin");
            Annotation r16 = (Annotation) ZeusTransformUtils.wrapperContextForParams(r14, Annotation.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r16, Url.class) == false) goto L42;
            a(r11, r15);
            if (this.w == true) goto L40;
            if (this.s == true) goto L38;
            if (this.t == true) goto L36;
            if (this.u == true) goto L34;
            if (this.v == true) goto L32;
            if (this.C != null) goto L30;
            this.w = true;
            if (r15 == String.class) goto L28;
            if (r15 == URI.class) goto L28;
            if (ZeusTransformUtils.instanceOf(r15, Class.class) == false) goto L26;
            if ("android.net.Uri".equals(((Class) ZeusTransformUtils.preCheckCast(r15, Class.class, "com.obric.aiagent.plugin")).getName()) == true) goto L28;
        L26:
            throw an.a(this.f9385b, r11, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
        L28:
            return new x.v(this.f9385b, r11);
        L30:
            throw an.a(this.f9385b, r11, "@Url cannot be used with @%s URL", new Object[]{this.y});
        L32:
            throw an.a(this.f9385b, r11, "A @Url parameter must not come after a @QueryMap.", new Object[0]);
        L34:
            throw an.a(this.f9385b, r11, "A @Url parameter must not come after a @QueryName.", new Object[0]);
        L36:
            throw an.a(this.f9385b, r11, "A @Url parameter must not come after a @Query.", new Object[0]);
        L38:
            throw an.a(this.f9385b, r11, "@Path parameters may not be used with @Url.", new Object[0]);
        L40:
            throw an.a(this.f9385b, r11, "Multiple @Url method annotations found.", new Object[0]);
        L42:
            if (ZeusTransformUtils.instanceOf(r16, Path.class) == false) goto L66;
            a(r11, r15);
            if (this.t == true) goto L64;
            if (this.u == true) goto L62;
            if (this.v == true) goto L60;
            if (this.w == true) goto L58;
            if (this.C == null) goto L56;
            this.s = true;
            Path r17 = (Path) ZeusTransformUtils.preCheckCast(r16, Path.class, "com.obric.aiagent.plugin");
            String r7 = r17.value();
            b(r11, r7);
            return new x.q(this.f9385b, r11, r7, this.f9384a.d(r15, r13), !r17.encoded());
        L56:
            throw an.a(this.f9385b, r11, "@Path can only be used with relative url on @%s", new Object[]{this.y});
        L58:
            throw an.a(this.f9385b, r11, "@Path parameters may not be used with @Url.", new Object[0]);
        L60:
            throw an.a(this.f9385b, r11, "A @Path parameter must not come after a @QueryMap.", new Object[0]);
        L62:
            throw an.a(this.f9385b, r11, "A @Path parameter must not come after a @QueryName.", new Object[0]);
        L64:
            throw an.a(this.f9385b, r11, "A @Path parameter must not come after a @Query.", new Object[0]);
        L66:
            if (ZeusTransformUtils.instanceOf(r16, Query.class) == false) goto L82;
            a(r11, r15);
            Query r18 = (Query) ZeusTransformUtils.preCheckCast(r16, Query.class, "com.obric.aiagent.plugin");
            String r0 = r18.value();
            boolean r19 = r18.encoded();
            Class<?> r6 = an.a(r15);
            this.t = true;
            if (Iterable.class.isAssignableFrom(r6) == false) goto L76;
            if (ZeusTransformUtils.instanceOf(r15, ParameterizedType.class) == false) goto L74;
            return new x.r(r0, this.f9384a.d(an.a(0, (ParameterizedType) ZeusTransformUtils.preCheckCast(r15, ParameterizedType.class, "com.obric.aiagent.plugin")), r13), !r19).a();
        L74:
            throw an.a(this.f9385b, r11, r6.getSimpleName() + " must include generic type (e.g., " + r6.getSimpleName() + "<String>)", new Object[0]);
        L76:
            if (r6.isArray() == false) goto L80;
            return new x.r(r0, this.f9384a.d(a(r6.getComponentType()), r13), !r19).b();
        L80:
            return new x.r(r0, this.f9384a.d(r15, r13), !r19);
        L82:
            if (ZeusTransformUtils.instanceOf(r16, QueryName.class) == false) goto L98;
            a(r11, r15);
            boolean r110 = ((QueryName) ZeusTransformUtils.preCheckCast(r16, QueryName.class, "com.obric.aiagent.plugin")).encoded();
            Class<?> r1 = an.a(r15);
            this.u = true;
            if (Iterable.class.isAssignableFrom(r1) == false) goto L92;
            if (ZeusTransformUtils.instanceOf(r15, ParameterizedType.class) == false) goto L90;
            return new x.t(this.f9384a.d(an.a(0, (ParameterizedType) ZeusTransformUtils.preCheckCast(r15, ParameterizedType.class, "com.obric.aiagent.plugin")), r13), r110).a();
        L90:
            throw an.a(this.f9385b, r11, r1.getSimpleName() + " must include generic type (e.g., " + r1.getSimpleName() + "<String>)", new Object[0]);
        L92:
            if (r1.isArray() == false) goto L96;
            return new x.t(this.f9384a.d(a(r1.getComponentType()), r13), r110).b();
        L96:
            return new x.t(this.f9384a.d(r15, r13), r110);
        L98:
            if (ZeusTransformUtils.instanceOf(r16, QueryMap.class) == false) goto L114;
            a(r11, r15);
            Class<?> r2 = an.a(r15);
            this.v = true;
            if (Map.class.isAssignableFrom(r2) == false) goto L112;
            Type r111 = an.b(r15, r2, Map.class);
            if (ZeusTransformUtils.instanceOf(r111, ParameterizedType.class) == false) goto L110;
            ParameterizedType r112 = (ParameterizedType) ZeusTransformUtils.preCheckCast(r111, ParameterizedType.class, "com.obric.aiagent.plugin");
            Type r3 = an.a(0, r112);
            if (String.class != r3) goto L108;
            return new x.s(this.f9385b, r11, this.f9384a.d(an.a(1, r112), r13), !((QueryMap) ZeusTransformUtils.preCheckCast(r16, QueryMap.class, "com.obric.aiagent.plugin")).encoded());
        L108:
            throw an.a(this.f9385b, r11, "@QueryMap keys must be of type String: " + r3, new Object[0]);
        L110:
            throw an.a(this.f9385b, r11, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L112:
            throw an.a(this.f9385b, r11, "@QueryMap parameter type must be Map.", new Object[0]);
        L114:
            if (ZeusTransformUtils.instanceOf(r16, Header.class) == false) goto L130;
            a(r11, r15);
            String r113 = ((Header) ZeusTransformUtils.preCheckCast(r16, Header.class, "com.obric.aiagent.plugin")).value();
            Class<?> r4 = an.a(r15);
            if (Iterable.class.isAssignableFrom(r4) == false) goto L124;
            if (ZeusTransformUtils.instanceOf(r15, ParameterizedType.class) == false) goto L122;
            return new x.j(r113, this.f9384a.d(an.a(0, (ParameterizedType) ZeusTransformUtils.preCheckCast(r15, ParameterizedType.class, "com.obric.aiagent.plugin")), r13)).a();
        L122:
            throw an.a(this.f9385b, r11, r4.getSimpleName() + " must include generic type (e.g., " + r4.getSimpleName() + "<String>)", new Object[0]);
        L124:
            if (r4.isArray() == false) goto L128;
            return new x.j(r113, this.f9384a.d(a(r4.getComponentType()), r13)).b();
        L128:
            return new x.j(r113, this.f9384a.d(r15, r13));
        L130:
            if (ZeusTransformUtils.instanceOf(r16, HeaderMap.class) == false) goto L146;
            a(r11, r15);
            Class<?> r114 = an.a(r15);
            if (Map.class.isAssignableFrom(r114) == false) goto L144;
            Type r115 = an.b(r15, r114, Map.class);
            if (ZeusTransformUtils.instanceOf(r115, ParameterizedType.class) == false) goto L142;
            ParameterizedType r116 = (ParameterizedType) ZeusTransformUtils.preCheckCast(r115, ParameterizedType.class, "com.obric.aiagent.plugin");
            Type r117 = an.a(0, r116);
            if (String.class != r117) goto L140;
            return new x.l(this.f9385b, r11, this.f9384a.d(an.a(1, r116), r13));
        L140:
            throw an.a(this.f9385b, r11, "@HeaderMap keys must be of type String: " + r117, new Object[0]);
        L142:
            throw an.a(this.f9385b, r11, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L144:
            throw an.a(this.f9385b, r11, "@HeaderMap parameter type must be Map.", new Object[0]);
        L146:
            if (ZeusTransformUtils.instanceOf(r16, Field.class) == false) goto L166;
            a(r11, r15);
            if (this.A == false) goto L164;
            Field r118 = (Field) ZeusTransformUtils.preCheckCast(r16, Field.class, "com.obric.aiagent.plugin");
            String r5 = r118.value();
            boolean r119 = r118.encoded();
            this.p = true;
            Class<?> r8 = an.a(r15);
            if (Iterable.class.isAssignableFrom(r8) == false) goto L158;
            if (ZeusTransformUtils.instanceOf(r15, ParameterizedType.class) == false) goto L156;
            return new x.h(r5, this.f9384a.d(an.a(0, (ParameterizedType) ZeusTransformUtils.preCheckCast(r15, ParameterizedType.class, "com.obric.aiagent.plugin")), r13), !r119).a();
        L156:
            throw an.a(this.f9385b, r11, r8.getSimpleName() + " must include generic type (e.g., " + r8.getSimpleName() + "<String>)", new Object[0]);
        L158:
            if (r8.isArray() == false) goto L162;
            return new x.h(r5, this.f9384a.d(a(r8.getComponentType()), r13), !r119).b();
        L162:
            return new x.h(r5, this.f9384a.d(r15, r13), !r119);
        L164:
            throw an.a(this.f9385b, r11, "@Field parameters can only be used with form encoding.", new Object[0]);
        L166:
            if (ZeusTransformUtils.instanceOf(r16, FieldMap.class) == false) goto L186;
            a(r11, r15);
            if (this.A == false) goto L184;
            Class<?> r9 = an.a(r15);
            if (Map.class.isAssignableFrom(r9) == false) goto L182;
            Type r120 = an.b(r15, r9, Map.class);
            if (ZeusTransformUtils.instanceOf(r120, ParameterizedType.class) == false) goto L180;
            ParameterizedType r121 = (ParameterizedType) ZeusTransformUtils.preCheckCast(r120, ParameterizedType.class, "com.obric.aiagent.plugin");
            Type r10 = an.a(0, r121);
            if (String.class != r10) goto L178;
            i<T, String> r122 = this.f9384a.d(an.a(1, r121), r13);
            this.p = true;
            return new x.i(this.f9385b, r11, r122, !((FieldMap) ZeusTransformUtils.preCheckCast(r16, FieldMap.class, "com.obric.aiagent.plugin")).encoded());
        L178:
            throw an.a(this.f9385b, r11, "@FieldMap keys must be of type String: " + r10, new Object[0]);
        L180:
            throw an.a(this.f9385b, r11, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L182:
            throw an.a(this.f9385b, r11, "@FieldMap parameter type must be Map.", new Object[0]);
        L184:
            throw an.a(this.f9385b, r11, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
        L186:
            if (ZeusTransformUtils.instanceOf(r16, Part.class) == false) goto L197;
            if (this.B == false) goto L195;
            Part r123 = (Part) ZeusTransformUtils.preCheckCast(r16, Part.class, "com.obric.aiagent.plugin");
            this.q = true;
            x<?> r20 = a(r15, r123.value(), r123.encoding());
            if (r20 == null) goto L193;
            return r20;
        L193:
            return new x.o(this.f9385b, r11, r123.value(), this.f9384a.a(r15, r13, this.f9386c));
        L195:
            throw an.a(this.f9385b, r11, "@Part parameters can only be used with multipart encoding.", new Object[0]);
        L197:
            if (ZeusTransformUtils.instanceOf(r16, PartMap.class) == false) goto L221;
            a(r11, r15);
            if (this.B == false) goto L219;
            this.q = true;
            Class<?> r21 = an.a(r15);
            if (Map.class.isAssignableFrom(r21) == false) goto L217;
            Type r124 = an.b(r15, r21, Map.class);
            if (ZeusTransformUtils.instanceOf(r124, ParameterizedType.class) == false) goto L215;
            ParameterizedType r125 = (ParameterizedType) ZeusTransformUtils.preCheckCast(r124, ParameterizedType.class, "com.obric.aiagent.plugin");
            Type r22 = an.a(0, r125);
            if (String.class != r22) goto L213;
            Type r126 = an.a(1, r125);
            if (okhttp3.y.c.class.isAssignableFrom(an.a(r126)) == true) goto L211;
            return new x.p(this.f9385b, r11, this.f9384a.a(r126, r13, this.f9386c), ((PartMap) ZeusTransformUtils.preCheckCast(r16, PartMap.class, "com.obric.aiagent.plugin")).encoding());
        L211:
            throw an.a(this.f9385b, r11, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
        L213:
            throw an.a(this.f9385b, r11, "@PartMap keys must be of type String: " + r22, new Object[0]);
        L215:
            throw an.a(this.f9385b, r11, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
        L217:
            throw an.a(this.f9385b, r11, "@PartMap parameter type must be Map.", new Object[0]);
        L219:
            throw an.a(this.f9385b, r11, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
        L221:
            if (ZeusTransformUtils.instanceOf(r16, Body.class) == false) goto L243;
            a(r11, r15);
            if (this.A == true) goto L241;
            if (this.B == true) goto L241;
            if (this.r == true) goto L239;
            x<?> r127 = a(r15);
            if (r127 == null) goto L258;
            this.r = true;
            return r127;
        L258:
            i<T, com.bytedance.retrofit2.e.j> r128 = this.f9384a.a(r15, r13, this.f9386c);     // Catch: RuntimeException -> L235
            this.r = true;
            return new x.b(this.f9385b, r11, this.m, r128);
        L235:
            e = move-exception;
            throw an.a(this.f9385b, e, r11, "Unable to create @Body converter for %s", new Object[]{r15});
        L239:
            throw an.a(this.f9385b, r11, "Multiple @Body method annotations found.", new Object[0]);
        L241:
            throw an.a(this.f9385b, r11, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
        L243:
            if (ZeusTransformUtils.instanceOf(r16, Tag.class) == false) goto L256;
            a(r11, r15);
            Class<?> r129 = an.a(r15);
            int r130 = r11 - 1;
        L245:
            if (r130 < 0) goto L255;
            x<?> r131 = this.H[r130];
            if (ZeusTransformUtils.instanceOf(r131, x.w.class) == false) goto L253;
            if (((x.w) ZeusTransformUtils.preCheckCast(r131, x.w.class, "com.obric.aiagent.plugin")).f9680a.equals(r129) == false) goto L253;
            throw an.a(this.f9385b, r11, "@Tag type " + r129.getName() + " is duplicate of parameter #" + (r130 + 1) + " and would always overwrite its value.", new Object[0]);
        L253:
            r130 = r130 - 1;
            goto L245
        L255:
            return new x.w(r129);
        L256:
            return null;
        }

        private x<?> a(Type r6, String r7, String r8) {
            Type r9 = (Type) ZeusTransformUtils.wrapperContextForParams(r6, Type.class, "com.obric.aiagent.plugin");
            Class<?> r0 = an.a(r9);
            if (TextUtils.isEmpty(r7) == false) goto L24;
            if (Iterable.class.isAssignableFrom(r0) == false) goto L14;
            if (ZeusTransformUtils.instanceOf(r9, ParameterizedType.class) == true) goto L10;
            return null;
        L10:
            if (okhttp3.y.c.class.isAssignableFrom(an.a(an.a(0, (ParameterizedType) ZeusTransformUtils.preCheckCast(r9, ParameterizedType.class, "com.obric.aiagent.plugin")))) == true) goto L12;
        L42:
            return null;
        L12:
            return x.f.f9638a.a();
        L14:
            if (r0.isArray() == false) goto L20;
            if (okhttp3.y.c.class.isAssignableFrom(r0.getComponentType()) == false) goto L42;
            return x.f.f9638a.b();
        L20:
            if (okhttp3.y.c.class.isAssignableFrom(r0) == false) goto L42;
            return x.f.f9638a;
        L24:
            if (Iterable.class.isAssignableFrom(r0) == false) goto L33;
            if (ZeusTransformUtils.instanceOf(r9, ParameterizedType.class) == true) goto L29;
            return null;
        L29:
            if (okhttp3.ac.class.isAssignableFrom(an.a(an.a(0, (ParameterizedType) ZeusTransformUtils.preCheckCast(r9, ParameterizedType.class, "com.obric.aiagent.plugin")))) == false) goto L42;
            return new x.d(a(r7, r8)).a();
        L33:
            if (r0.isArray() == false) goto L39;
            if (okhttp3.ac.class.isAssignableFrom(a(r0.getComponentType())) == false) goto L42;
            return new x.d(a(r7, r8)).b();
        L39:
            if (okhttp3.ac.class.isAssignableFrom(r0) == false) goto L42;
            return new x.d(a(r7, r8));
        }

        private x<?> a(ParameterizedType r2, Annotation r3) {
            ParameterizedType r1 = (ParameterizedType) ZeusTransformUtils.wrapperContextForParams(r2, ParameterizedType.class, "com.obric.aiagent.plugin");
            Annotation r4 = (Annotation) ZeusTransformUtils.wrapperContextForParams(r3, Annotation.class, "com.obric.aiagent.plugin");
            if (okhttp3.ac.class.isAssignableFrom(an.a(an.a(1, r1))) == true) goto L5;
            return null;
        L5:
            return new x.e(((com.bytedance.retrofit2.c.w) ZeusTransformUtils.preCheckCast(r4, com.bytedance.retrofit2.c.w.class, "com.obric.aiagent.plugin")).a());
        }

        private x<?> a(Type r2) {
            if (okhttp3.ac.class.isAssignableFrom(an.a((Type) ZeusTransformUtils.wrapperContextForParams(r2, Type.class, "com.obric.aiagent.plugin"))) == true) goto L5;
            return null;
        L5:
            return x.c.f9635a;
        }

        private okhttp3.u a(String r3, String r4) {
            return okhttp3.u.a(new String[]{"Content-Disposition", "form-data; name=\"" + r3 + "\"", "Content-Transfer-Encoding", r4});
        }

        private void a(int r8, String r9) {
            /*  JADX ERROR: Simple mode code generation failed
                java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
                	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
                	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
                	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
                	at java.base/java.util.Objects.checkIndex(Objects.java:365)
                	at java.base/java.util.ArrayList.get(ArrayList.java:428)
                	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
                	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:297)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                */
            /*
                this = this;
                r0 = 1
                r1 = 0
                r2 = 2
                java.util.regex.Pattern r3 = com.bytedance.retrofit2.aa.a.M     // Catch: java.lang.IllegalArgumentException -> L25
                java.util.regex.Matcher r3 = r3.matcher(r9)     // Catch: java.lang.IllegalArgumentException -> L25
                boolean r3 = r3.matches()     // Catch: java.lang.IllegalArgumentException -> L25
                if (r3 == 0) goto L10
                goto L32
            L10:
                java.lang.reflect.Method r3 = r7.f9385b     // Catch: java.lang.IllegalArgumentException -> L25
                java.lang.String r4 = "@Method parameter name must match %s. Found: %s"
                java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch: java.lang.IllegalArgumentException -> L25
                java.util.regex.Pattern r6 = com.bytedance.retrofit2.aa.a.L     // Catch: java.lang.IllegalArgumentException -> L25
                java.lang.String r6 = r6.pattern()     // Catch: java.lang.IllegalArgumentException -> L25
                r5[r1] = r6     // Catch: java.lang.IllegalArgumentException -> L25
                r5[r0] = r9     // Catch: java.lang.IllegalArgumentException -> L25
                java.lang.RuntimeException r3 = com.bytedance.retrofit2.an.a(r3, r8, r4, r5)     // Catch: java.lang.IllegalArgumentException -> L25
                throw r3     // Catch: java.lang.IllegalArgumentException -> L25
            L25:
                r3 = move-exception
                java.lang.String r4 = r3.getMessage()
                java.lang.String r5 = "@Method parameter name must match"
                boolean r4 = r4.contains(r5)
                if (r4 != 0) goto L4f
            L32:
                java.lang.String r3 = r7.G
                if (r3 == 0) goto L4e
                boolean r3 = r3.equals(r9)
                if (r3 == 0) goto L3d
                goto L4e
            L3d:
                java.lang.reflect.Method r3 = r7.f9385b
                java.lang.Object[] r2 = new java.lang.Object[r2]
                java.lang.String r7 = r7.y
                r2[r1] = r7
                r2[r0] = r9
                java.lang.String r7 = "Method \"%s\" does not contain \"{%s}\"."
                java.lang.RuntimeException r7 = com.bytedance.retrofit2.an.a(r3, r8, r7, r2)
                throw r7
            L4e:
                return
            L4f:
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.retrofit2.aa.a.a(int, java.lang.String):void");
        }

        private void b(int r8, String r9) {
        L8:
            e = move-exception;
            if (e.getMessage().contains("@Path parameter name must match") == false) goto L12;
            throw e;
        L12:
            if (this.F.contains(r9) == false) goto L15;
            return;
        L15:
            throw an.a(this.f9385b, r8, "URL \"%s\" does not contain \"{%s}\".", new Object[]{this.C, r9});
        L4:
            if (M.matcher(r9).matches() == true) goto L12;
            throw an.a(this.f9385b, r8, "@Path parameter name must match %s. Found: %s", new Object[]{L.pattern(), r9});     // Catch: IllegalArgumentException -> L8
        }

        private void a(int r3, Type r4) {
            Type r5 = (Type) ZeusTransformUtils.wrapperContextForParams(r4, Type.class, "com.obric.aiagent.plugin");
            if (an.d(r5) == true) goto L6;
            return;
        L6:
            throw an.a(this.f9385b, r3, "Parameter type must not include a type variable or wildcard: %s", new Object[]{r5});
        }

        static Set<String> a(String r2) {
            LinkedHashSet r0 = new LinkedHashSet();
            Matcher r3 = L.matcher(r2);     // Catch: IllegalArgumentException -> L9
        L5:
            if (r3.find() == false) goto L8;
            r0.add(r3.group(1));     // Catch: IllegalArgumentException -> L9
        L8:
            return r0;
        }

        static String b(String r1) {
            Matcher r2 = L.matcher(r1);     // Catch: IllegalArgumentException -> L8
            if (r2.find() == false) goto L6;
            return r2.group(1);
        L6:
            return null;
        L11:
            return null;
        }

        private static Class<?> a(Class<?> r1) {
            if (Boolean.TYPE != r1) goto L7;
            return Boolean.class;
        L7:
            if (Byte.TYPE != r1) goto L11;
            return Byte.class;
        L11:
            if (Character.TYPE != r1) goto L15;
            return Character.class;
        L15:
            if (Double.TYPE != r1) goto L19;
            return Double.class;
        L19:
            if (Float.TYPE != r1) goto L23;
            return Float.class;
        L23:
            if (Integer.TYPE != r1) goto L27;
            return Integer.class;
        L27:
            if (Long.TYPE != r1) goto L31;
            return Long.class;
        L31:
            if (Short.TYPE != r1) goto L34;
            return Short.class;
        L34:
            return r1;
        }
    }

    static aa a(ab r1, Method r2, af r3) {
        return new a(r1, r2, r3).a();
    }

    aa(a r3) {
        this.f9379b = r3.f9384a.a();
        this.f9380c = r3.f9384a.c();
        this.f9381d = r3.f9384a.b();
        this.q = r3.f9384a.e();
        this.o = r3.I;
        this.p = r3.y;
        this.r = r3.C;
        this.s = r3.z;
        this.t = r3.A;
        this.u = r3.B;
        this.v = r3.H;
        this.w = r3.D;
        this.x = r3.E;
        this.f9382e = r3.g;
        this.f = r3.o;
        this.g = r3.h;
        boolean r0 = r3.i;
        this.h = r0;
        this.i = r3.j;
        this.j = r3.k;
        this.k = r3.l;
        this.l = r3.n;
        this.m = r3.f9385b;
        this.n = r3.f9384a.d();
        this.f9378a = r3.f9383J;
        af r1 = r3.f;
        this.y = r1;
        r1.f9433c = r0;
        this.z = r3.K;
    }

    public af a() {
        return this.y;
    }

    public void a(af r1) {
        this.y = r1;
    }

    com.bytedance.retrofit2.b.c a(n r23, Object... r24) {
        n<?> r2 = (n) ZeusTransformUtils.wrapperContextForParams(r23, n.class, "com.obric.aiagent.plugin");
        z r15 = new z(this.p, this.q, this.r, this.w, this.x, this.f9382e, this.f, this.h, this.i, this.j, this.k, this.l, this.s, this.t, this.u, this.g, this.z);
        x<?>[] r3 = this.v;
        int r4 = 0;
        if (r24 == null) goto L5;
        int r5 = r24.length;
    L7:
        if (r5 != r3.length) goto L17;
        if (this.f9378a == false) goto L11;
        r5 = r5 - 1;
    L11:
        ArrayList r6 = new ArrayList(r5);
    L12:
        if (r4 >= r5) goto L14;
        r6.add(r24[r4]);
        r3[r4].a(r15, r24[r4]);
        r4 = r4 + 1;
        goto L12
    L14:
        r15.a(s.class, new s(this.m, r6));
        return r15.a(r2);
    L17:
        throw new IllegalArgumentException("Argument count (" + r5 + ") doesn't match expected count (" + r3.length + ")");
    L5:
        r5 = 0;
        goto L7
    }

    T a(com.bytedance.retrofit2.e.i r3) {
        com.bytedance.retrofit2.e.i r4 = (com.bytedance.retrofit2.e.i) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.retrofit2.e.i.class, "com.obric.aiagent.plugin");
        return this.o.b(r4);
    }
}
