package com.bytedance.retrofit2;

import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: RequestBuilder.java */
/* JADX INFO: loaded from: classes.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f9684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final k f9685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f9686c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f9687d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private StringBuilder f9688e;
    private String f;
    private List<com.bytedance.retrofit2.b.b> g;
    private String h;
    private final boolean i;
    private final com.bytedance.retrofit2.e.c j;
    private final com.bytedance.retrofit2.e.e k;
    private com.bytedance.retrofit2.e.j l;
    private int m;
    private final int n;
    private final String o;
    private boolean p;
    private int q;
    private boolean r;
    private int s;
    private Object t;
    private final okhttp3.y.a u;
    private okhttp3.ac v;
    private boolean w;
    private final Map<Class<?>, Object> x;
    private final boolean y;

    /* JADX INFO: compiled from: RequestBuilder.java */
    private static class a extends okhttp3.ac {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final okhttp3.ac f9689a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f9690b;

        a(okhttp3.ac r1, String r2) {
            this.f9689a = r1;
            this.f9690b = r2;
        }

        @Override // okhttp3.ac
        public okhttp3.x a() {
            return okhttp3.x.c(this.f9690b);
        }

        @Override // okhttp3.ac
        public long b() {
            return this.f9689a.b();
        }

        @Override // okhttp3.ac
        public void a(e.f r3) {
            e.f r4 = (e.f) ZeusTransformUtils.wrapperContextForParams(r3, e.f.class, "com.obric.aiagent.plugin");
            this.f9689a.a(r4);
        }
    }

    /* JADX INFO: compiled from: RequestBuilder.java */
    public static class b extends com.bytedance.retrofit2.e.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final com.bytedance.retrofit2.e.j f9691e;
        private final String f;

        b(com.bytedance.retrofit2.e.j r3, String r4) {
            this.f9691e = (com.bytedance.retrofit2.e.j) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.retrofit2.e.j.class, "com.obric.aiagent.plugin");
            this.f = r4;
        }

        @Override // com.bytedance.retrofit2.e.a, com.bytedance.retrofit2.e.j
        public String a() {
            return this.f9691e.a();
        }

        @Override // com.bytedance.retrofit2.e.a, com.bytedance.retrofit2.e.j
        public String b() {
            return this.f;
        }

        @Override // com.bytedance.retrofit2.e.a, com.bytedance.retrofit2.e.j
        public long c() {
            return this.f9691e.c();
        }

        @Override // com.bytedance.retrofit2.e.a, com.bytedance.retrofit2.e.j
        public void a(OutputStream r1) {
            this.f9691e.a(r1);
        }

        @Override // com.bytedance.retrofit2.e.a, com.bytedance.retrofit2.e.j
        public String d() {
            this.f9508c = this.f9691e.d();
            return this.f9508c;
        }

        @Override // com.bytedance.retrofit2.e.a
        public boolean e() {
            if (ZeusTransformUtils.instanceOf(this.f9691e, com.bytedance.retrofit2.e.a.class) == true) goto L5;
            return false;
        L5:
            return ((com.bytedance.retrofit2.e.a) ZeusTransformUtils.preCheckCast(this.f9691e, com.bytedance.retrofit2.e.a.class, "com.obric.aiagent.plugin")).e();
        }

        @Override // com.bytedance.retrofit2.e.a
        public com.bytedance.retrofit2.e.f.b a(String r3, String r4, boolean r5) {
            if (ZeusTransformUtils.instanceOf(this.f9691e, com.bytedance.retrofit2.e.a.class) == true) goto L5;
            return null;
        L5:
            return ((com.bytedance.retrofit2.e.a) ZeusTransformUtils.preCheckCast(this.f9691e, com.bytedance.retrofit2.e.a.class, "com.obric.aiagent.plugin")).a(r3, r4, r5);
        }

        @Override // com.bytedance.retrofit2.e.a
        public String f() {
            if (ZeusTransformUtils.instanceOf(this.f9691e, com.bytedance.retrofit2.e.a.class) == true) goto L5;
            return null;
        L5:
            return ((com.bytedance.retrofit2.e.a) ZeusTransformUtils.preCheckCast(this.f9691e, com.bytedance.retrofit2.e.a.class, "com.obric.aiagent.plugin")).f();
        }
    }

    z(String r7, k r8, String r9, List<com.bytedance.retrofit2.b.b> r10, String r11, int r12, int r13, boolean r14, int r15, boolean r16, int r17, Object r18, boolean r19, boolean r20, boolean r21, String r22, boolean r23) {
        k r2 = (k) ZeusTransformUtils.wrapperContextForParams(r8, k.class, "com.obric.aiagent.plugin");
        List<com.bytedance.retrofit2.b.b> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        this.x = new LinkedHashMap();
        this.f9684a = r7;
        this.f9685b = r2;
        this.f9687d = r9;
        this.h = r11;
        this.m = r12;
        this.n = r13;
        this.p = r14;
        this.q = r15;
        this.r = r16;
        this.s = r17;
        this.t = r18;
        this.i = r19;
        this.g = r3;
        this.o = r22;
        this.y = r23;
        if (r20 == false) goto L5;
        com.bytedance.retrofit2.e.c r4 = new com.bytedance.retrofit2.e.c(r23);
        this.j = r4;
        this.k = null;
        this.l = r4;
        this.u = null;
        return;
    L5:
        if (r21 == false) goto L7;
        this.j = null;
        com.bytedance.retrofit2.e.e r1 = new com.bytedance.retrofit2.e.e();
        this.k = r1;
        this.l = r1;
        okhttp3.y.a r5 = new okhttp3.y.a();
        this.u = r5;
        r5.a(okhttp3.y.f);
        return;
    L7:
        this.j = null;
        this.k = null;
        this.u = null;
    }

    void a(Object r2) {
        Objects.requireNonNull(r2, "@Url parameter is null.");
        this.f9687d = r2.toString();
    }

    void a(String r3, String r4) {
        if (r3 == null) goto L13;
        if (DownloadHelper.CONTENT_TYPE.equalsIgnoreCase(r3) == false) goto L7;
        this.h = r4;
        return;
    L7:
        List r0 = this.g;
        if (r0 != null) goto L10;
        r0 = new ArrayList(2);
        this.g = r0;
    L10:
        r0.add(new com.bytedance.retrofit2.b.b(r3, r4));
        return;
    L13:
        throw new IllegalArgumentException("Header name must not be null.");
    }

    void b(String r4, String r5) {
        String r0 = this.f9684a;
        if (r0 == null) goto L7;
        this.f9684a = r0.replace("{" + r4 + "}", r5);
        return;
    L7:
        throw new AssertionError();
    }

    void a(String r5, String r6, boolean r7) {
        String r0 = this.f9687d;
        if (r0 == null) goto L20;
        if (r5 == null) goto L18;
        if (r6 == null) goto L16;
        if (r7 == false) goto L11;
        this.f9687d = this.f9687d.replace("{" + r5 + "}", URLEncoder.encode(String.valueOf(r6), "UTF-8").replace("+", "%20"));     // Catch: UnsupportedEncodingException -> L9
    L21:
        return;
    L11:
        this.f9687d = r0.replace("{" + r5 + "}", String.valueOf(r6));     // Catch: UnsupportedEncodingException -> L9
    L9:
        e = move-exception;
        throw new RuntimeException("Unable to convert path parameter \"" + r5 + "\" value to UTF-8:" + r6, e);
    L16:
        throw new IllegalArgumentException("Path replacement \"" + r5 + "\" value must not be null.");
    L18:
        throw new IllegalArgumentException("Path replacement name must not be null.");
    L20:
        throw new AssertionError();
    }

    void b(String r3, String r4, boolean r5) {
        if (r3 == null) goto L27;
        StringBuilder r0 = this.f9688e;     // Catch: UnsupportedEncodingException -> L23
        if (r0 != null) goto L7;
        r0 = new StringBuilder();     // Catch: UnsupportedEncodingException -> L23
        this.f9688e = r0;     // Catch: UnsupportedEncodingException -> L23
    L7:
        if (r0.length() <= 0) goto L9;
        char r2 = '&';
    L10:
        r0.append(r2);     // Catch: UnsupportedEncodingException -> L23
        if (r5 == false) goto L14;
        r3 = URLEncoder.encode(r3, "UTF-8");     // Catch: UnsupportedEncodingException -> L23
    L14:
        if (r5 == false) goto L16;
        r4 = URLEncoder.encode(r4, "UTF-8");     // Catch: UnsupportedEncodingException -> L23
    L16:
        if (r4 != null) goto L18;
    L21:
        r0.append(r3);     // Catch: UnsupportedEncodingException -> L23
        return;
    L18:
        if (r4.isEmpty() == true) goto L21;
        r0.append(r3).append('=').append(r4);     // Catch: UnsupportedEncodingException -> L23
        return;
    L9:
        r2 = '?';
    L23:
        e = move-exception;
        throw new RuntimeException("Unable to convert query parameter \"" + r3 + "\" value to UTF-8: " + r4, e);
    L27:
        throw new IllegalArgumentException("Query param name must not be null.");
    }

    void a(String r1) {
        this.f = r1;
    }

    void c(String r1, String r2, boolean r3) {
        this.j.a(r1, r3, r2, r3);
    }

    public void a(String r3, com.bytedance.retrofit2.e.j r4) {
        com.bytedance.retrofit2.e.j r5 = (com.bytedance.retrofit2.e.j) ZeusTransformUtils.wrapperContextForParams(r4, com.bytedance.retrofit2.e.j.class, "com.obric.aiagent.plugin");
        this.k.a(r3, r5);
    }

    public void a(String r3, String r4, com.bytedance.retrofit2.e.j r5) {
        com.bytedance.retrofit2.e.j r6 = (com.bytedance.retrofit2.e.j) ZeusTransformUtils.wrapperContextForParams(r5, com.bytedance.retrofit2.e.j.class, "com.obric.aiagent.plugin");
        this.k.a(r3, r4, r6);
    }

    void a(okhttp3.u r1, okhttp3.ac r2) {
        this.u.a(r1, r2);
    }

    void a(okhttp3.y.c r1) {
        this.u.a(r1);
    }

    void a(okhttp3.ac r1) {
        this.v = r1;
    }

    void a() {
        this.w = true;
    }

    public void a(int r1) {
        this.q = r1;
    }

    public void a(boolean r1) {
        this.r = r1;
    }

    public void b(Object r1) {
        this.t = r1;
    }

    public void a(com.bytedance.retrofit2.e.j r3) {
        this.l = (com.bytedance.retrofit2.e.j) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.retrofit2.e.j.class, "com.obric.aiagent.plugin");
    }

    public <T> void a(Class<? super T> r1, T r2) {
        this.x.put(r1, r1.cast(r2));
    }

    private StringBuilder c(String r2, String r3) {
        StringBuilder r1 = new StringBuilder(r2);
        if (r2.endsWith("/") == false) goto L5;
        r1.deleteCharAt(r1.length() - 1);
    L5:
        r1.append(r3);
        return r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r17v0, types: [com.bytedance.retrofit2.z] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.bytedance.retrofit2.e.c] */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v34, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r6v2, types: [com.bytedance.retrofit2.e.j] */
    com.bytedance.retrofit2.b.c a(n<?> r18) {
        n r1 = (n) ZeusTransformUtils.wrapperContextForParams(r18, n.class, "com.obric.aiagent.plugin");
        com.bytedance.retrofit2.e.e r2 = this.k;
        if (r2 != null) goto L5;
    L11:
        ?? r3 = this.f9685b.a();
        if (y.b() == false) goto L95;
        okhttp3.v r4 = okhttp3.v.c(r3);
        if (r4 == null) goto L28;
        if (r4.i() != null) goto L18;
    L22:
        okhttp3.v r5 = r4.a(this.f9687d);
        if (r5 == null) goto L26;
        r3 = new StringBuilder(r5.toString());
    L46:
        StringBuilder r6 = this.f9688e;
        if (r6 != null) goto L49;
    L56:
        String r7 = this.f;
        if (r7 == null) goto L59;
        r3.append(r7);
    L59:
        this.f9686c = r3.toString();
        if (ZeusTransformUtils.instanceOf(r1, n.class) == false) goto L62;
        r1.a(this);
    L62:
        com.bytedance.retrofit2.e.j r8 = this.l;
        List<com.bytedance.retrofit2.b.b> r9 = this.g;
        okhttp3.ac r10 = this.v;
        a r11 = null;
        if (this.w == false) goto L77;
        if (r10 != null) goto L71;
        okhttp3.y.a r12 = this.u;
        if (r12 == null) goto L69;
        r10 = r12.a();
        goto L71
    L69:
        if (this.i == false) goto L71;
        r10 = okhttp3.ac.a(null, new byte[0]);
    L71:
        if (r10 != null) goto L73;
    L75:
        List<com.bytedance.retrofit2.b.b> r13 = r9;
        okhttp3.ac r14 = r10;
        ?? r15 = r8;
    L86:
        if (r15 != 0) goto L93;
        if (an.a(this.f9684a) == false) goto L93;
        if (this.w == true) goto L93;
        r15 = new com.bytedance.retrofit2.e.c();
        r15.a("body", "null");
    L93:
        return new com.bytedance.retrofit2.b.c(this.f9684a, this.f9686c, r13, r15, r14, this.m, this.n, this.p, this.q, this.r, this.s, this.t, this.o, this.x);
    L73:
        if (this.h == null) goto L75;
        r11 = new a(r10, this.h);
    L84:
        r13 = r9;
        com.bytedance.retrofit2.e.j r16 = r8;
    L85:
        r14 = r11;
        r15 = r16;
        goto L86
    L77:
        if (this.h == null) goto L84;
        if (r8 == null) goto L80;
        r13 = r9;
        r16 = new b(r8, this.h);
        goto L85
    L80:
        com.bytedance.retrofit2.b.b r17 = new com.bytedance.retrofit2.b.b(DownloadHelper.CONTENT_TYPE, this.h);
        if (r9 != null) goto L83;
        r9 = Collections.singletonList(r17);
        goto L84
    L83:
        r9.add(r17);
        goto L84
    L49:
        if ('?' != r6.charAt(0)) goto L55;
        String r19 = this.f9687d;
        if (r19 == null) goto L55;
        if (r19.indexOf(63) == (-1)) goto L55;
        r6.setCharAt(0, '&');
    L55:
        r3.append(r6);
        goto L56
    L26:
        throw new IllegalArgumentException("Malformed URL. Base: " + r4 + ", Relative: " + this.f9687d);
    L18:
        if (r4.i().length() <= 0) goto L22;
        if ("/".equals(this.f9687d) == false) goto L22;
        r3 = c(r3, this.f9687d);
        goto L46
    L28:
        throw new IllegalArgumentException("Malformed URL. Base: " + r4 + ", Relative: " + this.f9687d);
    L95:
        URI r20 = URI.create(r3);     // Catch: Throwable -> L38
        if (r20.getPath() == null) goto L37;
        if (r20.getPath().length() < 1) goto L37;
        if ("/".equals(this.f9687d) == false) goto L37;
        r3 = c(r3, this.f9687d);     // Catch: Throwable -> L38
    L94:
    L37:
        r3 = new StringBuilder(r20.resolve(this.f9687d).toString());     // Catch: Throwable -> L38
    L38:
        String r21 = this.f9687d;
        if (r21 != null) goto L41;
    L45:
        r3 = c(r3, this.f9687d);
        goto L46
    L41:
        if (r21.startsWith("http://") == false) goto L43;
    L44:
        r3 = new StringBuilder(this.f9687d);
        goto L46
    L43:
        if (this.f9687d.startsWith("https://") == false) goto L45;
    L5:
        if (r2.e() != 0) goto L11;
        if (this.w == true) goto L11;
        throw new IllegalStateException("Multipart requests must contain at least one part.");
    }
}
