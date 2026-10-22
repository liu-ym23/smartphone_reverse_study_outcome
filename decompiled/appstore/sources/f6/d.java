package f6;

import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.retrofit2.Endpoint;
import com.bytedance.retrofit2.ExpandCallback;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.bytedanceos.common.toolbox.ServerElements;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.h;
import okio.BufferedSink;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final char[] f19499x = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f19500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Endpoint f19501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f19502c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f19503d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public StringBuilder f19504e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f19505f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List f19506g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f19507h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f19508i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final h6.c f19509j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final h6.e f19510k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TypedOutput f19511l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f19512m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f19513n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f19514o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f19515p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f19516q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f19517r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Object f19518s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public h.a f19519t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public RequestBody f19520u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f19521v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Map f19522w;

    public static class a extends RequestBody {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RequestBody f19523a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f19524b;

        public a(RequestBody r10, String r11) {
            this.f19523a = r10;
            this.f19524b = r11;
        }

        @Override // okhttp3.RequestBody
        public long a() {
            return this.f19523a.a();
        }

        @Override // okhttp3.RequestBody
        public MediaType b() {
            return MediaType.c(this.f19524b);
        }

        @Override // okhttp3.RequestBody
        public void g(BufferedSink r10) {
            this.f19523a.g(r10);
        }
    }

    public static class b extends h6.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TypedOutput f19525a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f19526b;

        public b(TypedOutput r10, String r11) {
            this.f19525a = r10;
            this.f19526b = r11;
        }

        @Override // h6.a
        public boolean a() {
            TypedOutput r10 = this.f19525a;
            if ((r10 instanceof h6.a) == true) goto L5;
            return false;
        L5:
            return ((h6.a) r10).a();
        }

        @Override // com.bytedance.retrofit2.mime.TypedOutput
        public String fileName() {
            return this.f19525a.fileName();
        }

        @Override // com.bytedance.retrofit2.mime.TypedOutput
        public long length() {
            return this.f19525a.length();
        }

        @Override // com.bytedance.retrofit2.mime.TypedOutput
        public String md5Stub() {
            return this.f19525a.md5Stub();
        }

        @Override // com.bytedance.retrofit2.mime.TypedOutput
        public String mimeType() {
            return this.f19526b;
        }

        @Override // com.bytedance.retrofit2.mime.TypedOutput
        public void writeTo(OutputStream r10) {
            this.f19525a.writeTo(r10);
        }
    }

    static {
        f19499x = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public d(String r10, Endpoint r11, String r12, List r13, String r14, int r15, int r16, boolean r17, int r18, boolean r19, Object r110, boolean r111, boolean r112, boolean r113, String r114) {
        this.f19522w = new LinkedHashMap();
        this.f19500a = r10;
        this.f19501b = r11;
        this.f19503d = r12;
        this.f19507h = r14;
        this.f19512m = r15;
        this.f19513n = r16;
        this.f19515p = r17;
        this.f19516q = r18;
        this.f19517r = r19;
        this.f19518s = r110;
        this.f19508i = r111;
        this.f19506g = r13;
        this.f19514o = r114;
        if (r112 == false) goto L5;
        h6.c r20 = new h6.c();
        this.f19509j = r20;
        this.f19510k = null;
        this.f19511l = r20;
        this.f19519t = null;
        return;
    L5:
        if (r113 == false) goto L7;
        this.f19509j = null;
        h6.e r21 = new h6.e();
        this.f19510k = r21;
        this.f19511l = r21;
        h.a r22 = new h.a();
        this.f19519t = r22;
        r22.d(h.f22953j);
        return;
    L7:
        this.f19509j = null;
        this.f19510k = null;
        this.f19519t = null;
    }

    public void a(String r10, String r11, boolean r12) {
        this.f19509j.c(r10, r12, r11.toString(), r12);
    }

    public void b(String r10, String r11) {
        if (r10 == null) goto L13;
        if ("Content-Type".equalsIgnoreCase(r10) == false) goto L7;
        this.f19507h = r11;
        return;
    L7:
        List r12 = this.f19506g;
        if (r12 != null) goto L10;
        r12 = new ArrayList(2);
        this.f19506g = r12;
    L10:
        r12.add(new g6.a(r10, r11));
        return;
    L13:
        throw new IllegalArgumentException("Header name must not be null.");
    }

    public void c(String r10, TypedOutput r11) {
        this.f19510k.c(r10, r11);
    }

    public void d(String r10, String r11, TypedOutput r12) {
        this.f19510k.d(r10, r11, r12);
    }

    public void e(Headers r10, RequestBody r11) {
        this.f19519t.a(r10, r11);
    }

    public void f(h.b r10) {
        this.f19519t.b(r10);
    }

    public void g(String r10, String r11, boolean r12) {
        String r13 = this.f19503d;
        if (r13 == null) goto L20;
        if (r10 == null) goto L18;
        if (r11 == null) goto L16;
        if (r12 == false) goto L11;
        String r14 = URLEncoder.encode(r11, "UTF-8").replace("+", "%20");     // Catch: UnsupportedEncodingException -> L9
        this.f19503d = this.f19503d.replace("{" + r10 + "}", r14);     // Catch: UnsupportedEncodingException -> L9
    L21:
        return;
    L11:
        this.f19503d = r13.replace("{" + r10 + "}", r11);     // Catch: UnsupportedEncodingException -> L9
    L9:
        e = move-exception;
        throw new RuntimeException("Unable to convert path parameter \"" + r10 + "\" value to UTF-8:" + r11, e);
    L16:
        throw new IllegalArgumentException("Path replacement \"" + r10 + "\" value must not be null.");
    L18:
        throw new IllegalArgumentException("Path replacement name must not be null.");
    L20:
        throw new AssertionError();
    }

    public void h(String r10, String r11, boolean r12) {
        if (r10 == null) goto L28;
        StringBuilder r13 = this.f19504e;     // Catch: UnsupportedEncodingException -> L6
        if (r13 != null) goto L9;
        r13 = new StringBuilder();     // Catch: UnsupportedEncodingException -> L6
        this.f19504e = r13;     // Catch: UnsupportedEncodingException -> L6
    L9:
        if (r13.length() <= 0) goto L11;
        char r14 = '&';
    L12:
        r13.append(r14);     // Catch: UnsupportedEncodingException -> L6
        if (r12 == false) goto L16;
        r10 = URLEncoder.encode(r10, "UTF-8");     // Catch: UnsupportedEncodingException -> L6
    L16:
        if (r12 == false) goto L18;
        r11 = URLEncoder.encode(r11, "UTF-8");     // Catch: UnsupportedEncodingException -> L6
    L18:
        if (r11 != null) goto L20;
    L23:
        r13.append(r10);     // Catch: UnsupportedEncodingException -> L6
        return;
    L20:
        if (r11.isEmpty() == true) goto L23;
        r13.append(r10);     // Catch: UnsupportedEncodingException -> L6
        r13.append('=');     // Catch: UnsupportedEncodingException -> L6
        r13.append(r11);     // Catch: UnsupportedEncodingException -> L6
        return;
    L11:
        r14 = '?';
    L6:
        e = move-exception;
        throw new RuntimeException("Unable to convert query parameter \"" + r10 + "\" value to UTF-8: " + r11, e);
    L28:
        throw new IllegalArgumentException("Query param name must not be null.");
    }

    public void i(Class r10, Object r11) {
        this.f19522w.put(r10, r10.cast(r11));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r14v0, types: [f6.d] */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v6, types: [h6.c] */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.bytedance.retrofit2.mime.TypedOutput] */
    public g6.b j(ExpandCallback r15) {
        h6.e r10 = this.f19510k;
        if (r10 != null) goto L5;
    L11:
        ?? r11 = this.f19501b.getUrl();
        if (com.bytedance.retrofit2.e.h() == false) goto L95;
        HttpUrl r12 = HttpUrl.r(r11);
        if (r12 == null) goto L28;
        if (r12.h() != null) goto L18;
    L22:
        HttpUrl r13 = r12.F(this.f19503d);
        if (r13 == null) goto L26;
        r11 = new StringBuilder(r13.toString());
    L46:
        StringBuilder r14 = this.f19504e;
        if (r14 != null) goto L49;
    L56:
        String r16 = this.f19505f;
        if (r16 == null) goto L59;
        r11.append(r16);
    L59:
        this.f19502c = r11.toString();
        if (r15 == null) goto L62;
        r15.onAsyncPreRequest(this);
    L62:
        TypedOutput r17 = this.f19511l;
        List r18 = this.f19506g;
        RequestBody r19 = this.f19520u;
        a r20 = null;
        if (this.f19521v == false) goto L78;
        if (r19 != null) goto L71;
        h.a r21 = this.f19519t;
        if (r21 == null) goto L69;
        r19 = r21.c();
        goto L71
    L69:
        if (this.f19508i == false) goto L71;
        r19 = RequestBody.e(null, new byte[0]);
    L71:
        if (r19 == null) goto L77;
        String r22 = this.f19507h;
        if (r22 == null) goto L77;
        r20 = new a(r19, r22);
    L75:
        List r23 = r18;
        TypedOutput r110 = r17;
    L76:
        RequestBody r24 = r20;
        ?? r111 = r110;
    L86:
        if (r111 != 0) goto L93;
        if (g.p(this.f19500a) == false) goto L93;
        if (this.f19521v == true) goto L93;
        r111 = new h6.c();
        r111.b(ServerElements.BODY, "null");
    L93:
        return new g6.b(this.f19500a, this.f19502c, r23, r111, r24, this.f19512m, this.f19513n, this.f19515p, this.f19516q, this.f19517r, this.f19518s, this.f19514o, this.f19522w);
    L77:
        r23 = r18;
        r24 = r19;
        r111 = r17;
        goto L86
    L78:
        String r25 = this.f19507h;
        if (r25 == null) goto L75;
        if (r17 == null) goto L82;
        r23 = r18;
        r110 = new b(r17, r25);
        goto L76
    L82:
        g6.a r26 = new g6.a("Content-Type", r25);
        if (r18 != null) goto L85;
        r18 = Collections.singletonList(r26);
        goto L75
    L85:
        r18.add(r26);
        goto L75
    L49:
        if ('?' != r14.charAt(0)) goto L55;
        String r27 = this.f19503d;
        if (r27 == null) goto L55;
        if (r27.indexOf(63) == (-1)) goto L55;
        r14.setCharAt(0, '&');
    L55:
        r11.append(r14);
        goto L56
    L26:
        throw new IllegalArgumentException("Malformed URL. Base: " + r12 + ", Relative: " + this.f19503d);
    L18:
        if (r12.h().length() <= 0) goto L22;
        if (LibrarianImpl.Constants.SEPARATOR.equals(this.f19503d) == false) goto L22;
        r11 = k(r11, this.f19503d);
        goto L46
    L28:
        throw new IllegalArgumentException("Malformed URL. Base: " + r12 + ", Relative: " + this.f19503d);
    L95:
        URI r28 = URI.create(r11);     // Catch: Throwable -> L38
        if (r28.getPath() == null) goto L37;
        if (r28.getPath().length() < 1) goto L37;
        if (LibrarianImpl.Constants.SEPARATOR.equals(this.f19503d) == false) goto L37;
        r11 = k(r11, this.f19503d);     // Catch: Throwable -> L38
    L94:
    L37:
        r11 = new StringBuilder(r28.resolve(this.f19503d).toString());     // Catch: Throwable -> L38
    L38:
        String r29 = this.f19503d;
        if (r29 != null) goto L41;
    L45:
        r11 = k(r11, this.f19503d);
        goto L46
    L41:
        if (r29.startsWith("http://") == false) goto L43;
    L44:
        r11 = new StringBuilder(this.f19503d);
        goto L46
    L43:
        if (this.f19503d.startsWith("https://") == false) goto L45;
    L5:
        if (r10.g() != 0) goto L11;
        if (this.f19521v == true) goto L11;
        throw new IllegalStateException("Multipart requests must contain at least one part.");
    }

    public final StringBuilder k(String r10, String r11) {
        StringBuilder r12 = new StringBuilder(r10);
        if (r10.endsWith(LibrarianImpl.Constants.SEPARATOR) == false) goto L5;
        r12.deleteCharAt(r12.length() - 1);
    L5:
        r12.append(r11);
        return r12;
    }

    public void l(boolean r10) {
        this.f19517r = r10;
    }

    public void m(TypedOutput r10) {
        this.f19511l = r10;
    }

    public void n(RequestBody r10) {
        this.f19520u = r10;
    }

    public void o(Object r10) {
        this.f19518s = r10;
    }

    public void p(int r10) {
        this.f19516q = r10;
    }

    public void q(String r10, String r11) {
        String r12 = this.f19500a;
        if (r12 == null) goto L7;
        this.f19500a = r12.replace("{" + r10 + "}", r11);
        return;
    L7:
        throw new AssertionError();
    }

    public void r(String r10) {
        this.f19505f = r10;
    }

    public void s(Object r10) {
        if (r10 == null) goto L6;
        this.f19503d = r10.toString();
        return;
    L6:
        throw new NullPointerException("@Url parameter is null.");
    }

    public void t() {
        this.f19521v = true;
    }
}
