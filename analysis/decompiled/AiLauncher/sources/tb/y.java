package tb;

import Mb.C0966d;
import Mb.InterfaceC0967e;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.core.JsonFactory;
import io.ktor.http.ContentDisposition;
import io.ktor.http.ContentType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import okio.ByteString;
import tb.u;
import tb.x;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0003\u001d\u0016\u0014B'\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ!\u0010\u0010\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u001bR\u0017\u0010\u0005\u001a\u00020\u00048\u0007¢\u0006\f\n\u0004\b\u0014\u0010\u001c\u001a\u0004\b\u0005\u0010\u0015R\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0007¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\b\u0010\u001fR\u0014\u0010!\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u001cR\u0016\u0010$\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0011\u0010(\u001a\u00020%8G¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006)"}, d2 = {"Ltb/y;", "Ltb/B;", "Lokio/ByteString;", "boundaryByteString", "Ltb/x;", "type", "", "Ltb/y$c;", "parts", "<init>", "(Lokio/ByteString;Ltb/x;Ljava/util/List;)V", "LMb/e;", "sink", "", "countBytes", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(LMb/e;Z)J", "f", "()Z", Const.INTENT_KEY_PKGNAME, "()Ltb/x;", Const.INTENT_KEY_APIKEY, "()J", "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(LMb/e;)V", "Lokio/ByteString;", "Ltb/x;", "c", "Ljava/util/List;", "()Ljava/util/List;", Const.INTENT_KEY_UMID, "contentType", "e", "J", "contentLength", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Ljava/lang/String;", "boundary", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class y extends AbstractC5529B {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: g, reason: collision with root package name */
    public static final x f42270g;

    /* renamed from: h, reason: collision with root package name */
    public static final x f42271h;

    /* renamed from: i, reason: collision with root package name */
    public static final x f42272i;

    /* renamed from: j, reason: collision with root package name */
    public static final x f42273j;

    /* renamed from: k, reason: collision with root package name */
    public static final x f42274k;

    /* renamed from: l, reason: collision with root package name */
    public static final byte[] f42275l;

    /* renamed from: m, reason: collision with root package name */
    public static final byte[] f42276m;

    /* renamed from: n, reason: collision with root package name */
    public static final byte[] f42277n;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final ByteString boundaryByteString;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final x type;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final List<c> parts;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final x contentType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public long contentLength;

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0003\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0018R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0019R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00100\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u001b¨\u0006\u001d"}, d2 = {"Ltb/y$a;", "", "", "boundary", "<init>", "(Ljava/lang/String;)V", "Ltb/x;", "type", Const.INTENT_KEY_UMID, "(Ltb/x;)Ltb/y$a;", "Ltb/u;", "headers", "Ltb/B;", "body", Const.INTENT_KEY_APIKEY, "(Ltb/u;Ltb/B;)Ltb/y$a;", "Ltb/y$c;", "part", Const.INTENT_KEY_PKGNAME, "(Ltb/y$c;)Ltb/y$a;", "Ltb/y;", "c", "()Ltb/y;", "Lokio/ByteString;", "Lokio/ByteString;", "Ltb/x;", "", "Ljava/util/List;", "parts", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final ByteString boundary;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public x type;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public final List<c> parts;

        /* JADX WARN: Multi-variable type inference failed */
        public a() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public final a a(u headers, AbstractC5529B body) {
            kotlin.jvm.internal.p.i(body, "body");
            b(c.INSTANCE.a(headers, body));
            return this;
        }

        public final a b(c part) {
            kotlin.jvm.internal.p.i(part, "part");
            this.parts.add(part);
            return this;
        }

        public final y c() {
            if (this.parts.isEmpty()) {
                throw new IllegalStateException("Multipart body must have at least one part.");
            }
            return new y(this.boundary, this.type, ub.q.w(this.parts));
        }

        public final a d(x type) {
            kotlin.jvm.internal.p.i(type, "type");
            if (kotlin.jvm.internal.p.d(type.getType(), ContentType.MultiPart.TYPE)) {
                this.type = type;
                return this;
            }
            throw new IllegalArgumentException(("multipart != " + type).toString());
        }

        public a(String boundary) {
            kotlin.jvm.internal.p.i(boundary, "boundary");
            this.boundary = ByteString.INSTANCE.d(boundary);
            this.type = y.f42270g;
            this.parts = new ArrayList();
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ a(String str, int i10, kotlin.jvm.internal.i iVar) {
            if ((i10 & 1) != 0) {
                str = UUID.randomUUID().toString();
                kotlin.jvm.internal.p.h(str, "toString(...)");
            }
            this(str);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b*\u00060\u0004j\u0002`\u00052\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\rR\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014¨\u0006\u0017"}, d2 = {"Ltb/y$b;", "", "<init>", "()V", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "", "key", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/StringBuilder;Ljava/lang/String;)V", "Ltb/x;", "MIXED", "Ltb/x;", "ALTERNATIVE", "DIGEST", "PARALLEL", "FORM", "", "COLONSPACE", "[B", "CRLF", "DASHDASH", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: tb.y$b, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final void a(StringBuilder sb2, String key) {
            kotlin.jvm.internal.p.i(sb2, "<this>");
            kotlin.jvm.internal.p.i(key, "key");
            sb2.append(JsonFactory.DEFAULT_QUOTE_CHAR);
            int length = key.length();
            for (int i10 = 0; i10 < length; i10++) {
                char cCharAt = key.charAt(i10);
                if (cCharAt == '\n') {
                    sb2.append("%0A");
                } else if (cCharAt == '\r') {
                    sb2.append("%0D");
                } else if (cCharAt != '\"') {
                    sb2.append(cCharAt);
                } else {
                    sb2.append("%22");
                }
            }
            sb2.append(JsonFactory.DEFAULT_QUOTE_CHAR);
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u000e2\u00020\u0001:\u0001\bB\u001b\b\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0007¢\u0006\f\n\u0004\b\n\u0010\f\u001a\u0004\b\b\u0010\r¨\u0006\u000f"}, d2 = {"Ltb/y$c;", "", "Ltb/u;", "headers", "Ltb/B;", "body", "<init>", "(Ltb/u;Ltb/B;)V", Const.INTENT_KEY_APIKEY, "Ltb/u;", Const.INTENT_KEY_PKGNAME, "()Ltb/u;", "Ltb/B;", "()Ltb/B;", "c", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c {

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final u headers;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final AbstractC5529B body;

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ)\u0010\u000e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Ltb/y$c$a;", "", "<init>", "()V", "Ltb/u;", "headers", "Ltb/B;", "body", "Ltb/y$c;", Const.INTENT_KEY_APIKEY, "(Ltb/u;Ltb/B;)Ltb/y$c;", "", "name", ContentDisposition.Parameters.FileName, Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;Ltb/B;)Ltb/y$c;", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* renamed from: tb.y$c$a, reason: from kotlin metadata */
        public static final class Companion {
            public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
                this();
            }

            public final c a(u headers, AbstractC5529B body) {
                kotlin.jvm.internal.p.i(body, "body");
                kotlin.jvm.internal.i iVar = null;
                if ((headers != null ? headers.b("Content-Type") : null) != null) {
                    throw new IllegalArgumentException("Unexpected header: Content-Type");
                }
                if ((headers != null ? headers.b("Content-Length") : null) == null) {
                    return new c(headers, body, iVar);
                }
                throw new IllegalArgumentException("Unexpected header: Content-Length");
            }

            public final c b(String name, String filename, AbstractC5529B body) {
                kotlin.jvm.internal.p.i(name, "name");
                kotlin.jvm.internal.p.i(body, "body");
                StringBuilder sb2 = new StringBuilder();
                sb2.append("form-data; name=");
                Companion companion = y.INSTANCE;
                companion.a(sb2, name);
                if (filename != null) {
                    sb2.append("; filename=");
                    companion.a(sb2, filename);
                }
                return a(new u.a().e("Content-Disposition", sb2.toString()).f(), body);
            }

            public Companion() {
            }
        }

        public /* synthetic */ c(u uVar, AbstractC5529B abstractC5529B, kotlin.jvm.internal.i iVar) {
            this(uVar, abstractC5529B);
        }

        /* renamed from: a, reason: from getter */
        public final AbstractC5529B getBody() {
            return this.body;
        }

        /* renamed from: b, reason: from getter */
        public final u getHeaders() {
            return this.headers;
        }

        public c(u uVar, AbstractC5529B abstractC5529B) {
            this.headers = uVar;
            this.body = abstractC5529B;
        }
    }

    static {
        x.Companion companion = x.INSTANCE;
        f42270g = companion.a("multipart/mixed");
        f42271h = companion.a("multipart/alternative");
        f42272i = companion.a("multipart/digest");
        f42273j = companion.a("multipart/parallel");
        f42274k = companion.a("multipart/form-data");
        f42275l = new byte[]{58, 32};
        f42276m = new byte[]{13, 10};
        f42277n = new byte[]{45, 45};
    }

    public y(ByteString boundaryByteString, x type, List<c> parts) {
        kotlin.jvm.internal.p.i(boundaryByteString, "boundaryByteString");
        kotlin.jvm.internal.p.i(type, "type");
        kotlin.jvm.internal.p.i(parts, "parts");
        this.boundaryByteString = boundaryByteString;
        this.type = type;
        this.parts = parts;
        this.contentType = x.INSTANCE.a(type + "; boundary=" + h());
        this.contentLength = -1L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final long i(InterfaceC0967e sink, boolean countBytes) throws IOException {
        C0966d c0966d;
        if (countBytes) {
            sink = new C0966d();
            c0966d = sink;
        } else {
            c0966d = 0;
        }
        int size = this.parts.size();
        long j10 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            c cVar = this.parts.get(i10);
            u headers = cVar.getHeaders();
            AbstractC5529B body = cVar.getBody();
            kotlin.jvm.internal.p.f(sink);
            sink.write(f42277n);
            sink.j1(this.boundaryByteString);
            sink.write(f42276m);
            if (headers != null) {
                int size2 = headers.size();
                for (int i11 = 0; i11 < size2; i11++) {
                    sink.L(headers.f(i11)).write(f42275l).L(headers.k(i11)).write(f42276m);
                }
            }
            x contentType = body.getContentType();
            if (contentType != null) {
                sink.L("Content-Type: ").L(contentType.getMediaType()).write(f42276m);
            }
            long jA = body.a();
            if (jA == -1 && countBytes) {
                kotlin.jvm.internal.p.f(c0966d);
                c0966d.g();
                return -1L;
            }
            byte[] bArr = f42276m;
            sink.write(bArr);
            if (countBytes) {
                j10 += jA;
            } else {
                body.g(sink);
            }
            sink.write(bArr);
        }
        kotlin.jvm.internal.p.f(sink);
        byte[] bArr2 = f42277n;
        sink.write(bArr2);
        sink.j1(this.boundaryByteString);
        sink.write(bArr2);
        sink.write(f42276m);
        if (!countBytes) {
            return j10;
        }
        kotlin.jvm.internal.p.f(c0966d);
        long size3 = j10 + c0966d.getSize();
        c0966d.g();
        return size3;
    }

    @Override // tb.AbstractC5529B
    public long a() throws IOException {
        long j10 = this.contentLength;
        if (j10 != -1) {
            return j10;
        }
        long jI = i(null, true);
        this.contentLength = jI;
        return jI;
    }

    @Override // tb.AbstractC5529B
    /* renamed from: b, reason: from getter */
    public x getContentType() {
        return this.contentType;
    }

    @Override // tb.AbstractC5529B
    public boolean f() {
        List<c> list = this.parts;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (((c) it.next()).getBody().f()) {
                return true;
            }
        }
        return false;
    }

    @Override // tb.AbstractC5529B
    public void g(InterfaceC0967e sink) throws IOException {
        kotlin.jvm.internal.p.i(sink, "sink");
        i(sink, false);
    }

    public final String h() {
        return this.boundaryByteString.Q();
    }
}
