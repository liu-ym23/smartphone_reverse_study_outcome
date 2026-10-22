package okhttp3;

import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class h extends RequestBody {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final MediaType f22949f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final MediaType f22950g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final MediaType f22951h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final MediaType f22952i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final MediaType f22953j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final byte[] f22954k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final byte[] f22955l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final byte[] f22956m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteString f22957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MediaType f22958b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MediaType f22959c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f22960d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f22961e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ByteString f22962a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public MediaType f22963b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List f22964c;

        public a() {
            this(UUID.randomUUID().toString());
        }

        public a a(Headers r10, RequestBody r11) {
            return b(b.a(r10, r11));
        }

        public a b(b r10) {
            if (r10 == null) goto L6;
            this.f22964c.add(r10);
            return this;
        L6:
            throw new NullPointerException("part == null");
        }

        public h c() {
            if (this.f22964c.isEmpty() == true) goto L7;
            return new h(this.f22962a, this.f22963b, this.f22964c);
        L7:
            throw new IllegalStateException("Multipart body must have at least one part.");
        }

        public a d(MediaType r10) {
            if (r10 == null) goto L10;
            if (r10.d().equals("multipart") == false) goto L8;
            this.f22963b = r10;
            return this;
        L8:
            throw new IllegalArgumentException("multipart != " + r10);
        L10:
            throw new NullPointerException("type == null");
        }

        public a(String r10) {
            this.f22963b = h.f22949f;
            this.f22964c = new ArrayList();
            this.f22962a = ByteString.encodeUtf8(r10);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Headers f22965a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final RequestBody f22966b;

        public b(Headers r10, RequestBody r11) {
            this.f22965a = r10;
            this.f22966b = r11;
        }

        public static b a(Headers r10, RequestBody r11) {
            if (r11 == null) goto L18;
            if (r10 != null) goto L5;
        L9:
            if (r10 == null) goto L16;
            if (r10.b("Content-Length") == null) goto L16;
            throw new IllegalArgumentException("Unexpected header: Content-Length");
        L16:
            return new b(r10, r11);
        L5:
            if (r10.b("Content-Type") == null) goto L9;
            throw new IllegalArgumentException("Unexpected header: Content-Type");
        L18:
            throw new NullPointerException("body == null");
        }
    }

    static {
        f22949f = MediaType.c("multipart/mixed");
        f22950g = MediaType.c("multipart/alternative");
        f22951h = MediaType.c("multipart/digest");
        f22952i = MediaType.c("multipart/parallel");
        f22953j = MediaType.c("multipart/form-data");
        f22954k = new byte[]{58, 32};
        f22955l = new byte[]{Ascii.CR, 10};
        f22956m = new byte[]{45, 45};
    }

    public h(ByteString r10, MediaType r11, List r12) {
        this.f22961e = -1;
        this.f22957a = r10;
        this.f22958b = r11;
        this.f22959c = MediaType.c(r11 + "; boundary=" + r10.utf8());
        this.f22960d = Util.immutableList(r12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private long h(BufferedSink r13, boolean r14) {
        if (r14 == false) goto L4;
        r13 = new Buffer();
        Buffer r10 = r13;
    L5:
        int r11 = this.f22960d.size();
        long r12 = 0;
        int r15 = 0;
    L6:
        if (r15 >= r11) goto L26;
        b r16 = (b) this.f22960d.get(r15);
        Headers r17 = r16.f22965a;
        RequestBody r18 = r16.f22966b;
        r13.write(f22956m);
        r13.write(this.f22957a);
        r13.write(f22955l);
        if (r17 == null) goto L12;
        int r19 = r17.h();
        int r20 = 0;
    L10:
        if (r20 >= r19) goto L12;
        r13.writeUtf8(r17.d(r20)).write(f22954k).writeUtf8(r17.j(r20)).write(f22955l);
        r20 = r20 + 1;
    L12:
        MediaType r21 = r18.b();
        if (r21 == null) goto L15;
        r13.writeUtf8("Content-Type: ").writeUtf8(r21.toString()).write(f22955l);
    L15:
        long r22 = r18.a();
        if (r22 == (-1)) goto L18;
        r13.writeUtf8("Content-Length: ").writeDecimalLong(r22).write(f22955l);
    L21:
        byte[] r23 = f22955l;
        r13.write(r23);
        if (r14 == false) goto L24;
        r12 = r12 + r22;
    L25:
        r13.write(r23);
        r15 = r15 + 1;
        goto L6
    L24:
        r18.g(r13);
        goto L25
    L18:
        if (r14 == false) goto L21;
        r10.a();
        return -1;
    L26:
        byte[] r24 = f22956m;
        r13.write(r24);
        r13.write(this.f22957a);
        r13.write(r24);
        r13.write(f22955l);
        if (r14 == false) goto L35;
        long r25 = r12 + r10.size();
        r10.a();
        return r25;
    L35:
        return r12;
    L4:
        r10 = 0;
        goto L5
    }

    @Override // okhttp3.RequestBody
    public long a() {
        long r10 = this.f22961e;
        if (r10 == (-1)) goto L5;
        return r10;
    L5:
        long r11 = h(null, true);
        this.f22961e = r11;
        return r11;
    }

    @Override // okhttp3.RequestBody
    public MediaType b() {
        return this.f22959c;
    }

    @Override // okhttp3.RequestBody
    public void g(BufferedSink r10) {
        h(r10, false);
    }
}
