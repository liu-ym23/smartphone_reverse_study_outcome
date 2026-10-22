package retrofit2;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;

/* JADX INFO: loaded from: classes4.dex */
public final class g {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final char[] f24068k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f24069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HttpUrl f24070b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f24071c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public HttpUrl.Builder f24072d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Request.a f24073e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public MediaType f24074f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f24075g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public okhttp3.h.a f24076h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public okhttp3.g.a f24077i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public RequestBody f24078j;

    public static class a extends RequestBody {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RequestBody f24079a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MediaType f24080b;

        public a(RequestBody r10, MediaType r11) {
            this.f24079a = r10;
            this.f24080b = r11;
        }

        @Override // okhttp3.RequestBody
        public long a() {
            return this.f24079a.a();
        }

        @Override // okhttp3.RequestBody
        public MediaType b() {
            return this.f24080b;
        }

        @Override // okhttp3.RequestBody
        public void g(BufferedSink r10) {
            this.f24079a.g(r10);
        }
    }

    static {
        f24068k = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public g(String r10, HttpUrl r11, String r12, Headers r13, MediaType r14, boolean r15, boolean r16, boolean r17) {
        this.f24069a = r10;
        this.f24070b = r11;
        this.f24071c = r12;
        Request.a r18 = new Request.a();
        this.f24073e = r18;
        this.f24074f = r14;
        this.f24075g = r15;
        if (r13 == null) goto L5;
        r18.e(r13);
    L5:
        if (r16 == false) goto L7;
        this.f24077i = new okhttp3.g.a();
        return;
    L7:
        if (r17 == false) goto L11;
        okhttp3.h.a r19 = new okhttp3.h.a();
        this.f24076h = r19;
        r19.d(okhttp3.h.f22953j);
        return;
    }

    public static String h(String r10, boolean r11) {
        int r12 = r10.length();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L27;
        int r14 = r10.codePointAt(r13);
        if (r14 < 32) goto L17;
        if (r14 >= 127) goto L17;
        if (" \"<>^`{}|\\?#".indexOf(r14) != (-1)) goto L17;
        if (r11 == true) goto L16;
        if (r14 == 47) goto L17;
        if (r14 == 37) goto L17;
    L16:
        r13 = r13 + Character.charCount(r14);
    L17:
        Buffer r15 = new Buffer();
        r15.F(r10, 0, r13);
        i(r15, r10, r13, r12, r11);
        return r15.readUtf8();
    L27:
        return r10;
    }

    public static void i(Buffer r10, String r11, int r12, int r13, boolean r14) {
        Buffer r15 = null;
    L3:
        if (r12 >= r13) goto L34;
        int r16 = r11.codePointAt(r12);
        if (r14 == false) goto L16;
        if (r16 == 9) goto L33;
        if (r16 == 10) goto L33;
        if (r16 == 12) goto L33;
        if (r16 != 13) goto L16;
    L33:
        r12 = r12 + Character.charCount(r16);
    L16:
        if (r16 >= 32) goto L18;
    L27:
        if (r15 != null) goto L29;
        r15 = new Buffer();
    L29:
        r15.G(r16);
    L31:
        if (r15.exhausted() == true) goto L33;
        byte r17 = r15.readByte();
        int r18 = r17 & UnsignedBytes.MAX_VALUE;
        r10.t(37);
        char[] r19 = f24068k;
        r10.t(r19[(r18 >> 4) & 15]);
        r10.t(r19[r17 & Ascii.SI]);
        goto L31
    L18:
        if (r16 >= 127) goto L27;
        if (" \"<>^`{}|\\?#".indexOf(r16) != (-1)) goto L27;
        if (r14 == false) goto L23;
    L26:
        r10.G(r16);
        goto L33
    L23:
        if (r16 == 47) goto L27;
        if (r16 != 37) goto L26;
    }

    public void a(String r10, String r11, boolean r12) {
        if (r12 == false) goto L4;
        this.f24077i.b(r10, r11);
        return;
    L4:
        this.f24077i.a(r10, r11);
    }

    public void b(String r10, String r11) {
        if ("Content-Type".equalsIgnoreCase(r10) == false) goto L9;
        MediaType r12 = MediaType.c(r11);
        if (r12 == null) goto L8;
        this.f24074f = r12;
        return;
    L8:
        throw new IllegalArgumentException("Malformed content type: " + r11);
    L9:
        this.f24073e.a(r10, r11);
    }

    public void c(Headers r10, RequestBody r11) {
        this.f24076h.a(r10, r11);
    }

    public void d(okhttp3.h.b r10) {
        this.f24076h.b(r10);
    }

    public void e(String r10, String r11, boolean r12) {
        String r13 = this.f24071c;
        if (r13 == null) goto L7;
        this.f24071c = r13.replace("{" + r10 + "}", h(r11, r12));
        return;
    L7:
        throw new AssertionError();
    }

    public void f(String r10, String r11, boolean r12) {
        String r13 = this.f24071c;
        if (r13 == null) goto L9;
        HttpUrl.Builder r14 = this.f24070b.q(r13);
        this.f24072d = r14;
        if (r14 == null) goto L8;
        this.f24071c = null;
        goto L9
    L8:
        throw new IllegalArgumentException("Malformed URL. Base: " + this.f24070b + ", Relative: " + this.f24071c);
    L9:
        if (r12 == false) goto L11;
        this.f24072d.a(r10, r11);
        return;
    L11:
        this.f24072d.b(r10, r11);
    }

    public Request g() {
        HttpUrl.Builder r10 = this.f24072d;
        if (r10 == null) goto L5;
        HttpUrl r11 = r10.c();
    L7:
        RequestBody r12 = this.f24078j;
        if (r12 != null) goto L18;
        okhttp3.g.a r13 = this.f24077i;
        if (r13 == null) goto L12;
        r12 = r13.c();
        goto L18
    L12:
        okhttp3.h.a r14 = this.f24076h;
        if (r14 == null) goto L16;
        r12 = r14.c();
        goto L18
    L16:
        if (this.f24075g == false) goto L18;
        r12 = RequestBody.e(null, new byte[0]);
    L18:
        MediaType r15 = this.f24074f;
        if (r15 == null) goto L24;
        if (r12 == null) goto L22;
        r12 = new a(r12, r15);
        goto L24
    L22:
        this.f24073e.a("Content-Type", r15.toString());
    L24:
        return this.f24073e.k(r11).f(this.f24069a, r12).b();
    L5:
        r11 = this.f24070b.F(this.f24071c);
        if (r11 != null) goto L7;
        throw new IllegalArgumentException("Malformed URL. Base: " + this.f24070b + ", Relative: " + this.f24071c);
    }

    public void j(RequestBody r10) {
        this.f24078j = r10;
    }

    public void k(Object r10) {
        this.f24071c = r10.toString();
    }
}
