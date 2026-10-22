package okhttp3;

import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: MultipartBody.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class y extends ac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f40225a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final x f40226b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final x f40227c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final x f40228d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final x f40229e = null;
    public static final x f = null;
    private static final byte[] m = null;
    private static final byte[] n = null;
    private static final byte[] o = null;
    private final e.h h;
    private final x i;
    private final List<c> j;
    private final x k;
    private long l;

    /* JADX INFO: compiled from: MultipartBody.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final e.h f40230a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private x f40231b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List<c> f40232c;

        /* JADX WARN: Multi-variable type inference failed */
        public a() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public a(String r3) {
            d.h.b.o.e(r3, "boundary");
            this.f40230a = e.h.f38722a.a(r3);
            this.f40231b = y.f40226b;
            this.f40232c = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
        }

        public /* synthetic */ a(String r1, int r2, d.h.b.h r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = UUID.randomUUID().toString();
            d.h.b.o.c(r1, "randomUUID().toString()");
        L5:
            this(r1);
        }

        public final a a(x r6) {
            d.h.b.o.e(r6, "type");
            a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(r6.a(), "multipart") == false) goto L7;
            r2.f40231b = r6;
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        L7:
            throw new IllegalArgumentException(("multipart != " + r6).toString());
        }

        public final a a(u r5, ac r6) {
            d.h.b.o.e(r6, "body");
            ((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin")).a(c.f40233a.a(r5, r6));
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        }

        public final a a(c r5) {
            d.h.b.o.e(r5, "part");
            ((Collection) ZeusTransformUtils.preCheckCast(((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin")).f40232c, Collection.class, "com.obric.aiagent.plugin")).add(r5);
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        }

        public final y a() {
            if ((!((Collection) ZeusTransformUtils.preCheckCast(this.f40232c, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == false) goto L7;
            return new y(this.f40230a, this.f40231b, okhttp3.internal.c.b(this.f40232c));
        L7:
            throw new IllegalStateException("Multipart body must have at least one part.".toString());
        }
    }

    /* JADX INFO: compiled from: MultipartBody.kt */
    public static final class b {
        public /* synthetic */ b(d.h.b.h r1) {
            this();
        }

        private b() {
        }
    }

    /* JADX INFO: compiled from: MultipartBody.kt */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f40233a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final u f40234b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ac f40235c;

        /* JADX INFO: compiled from: MultipartBody.kt */
        public static final class a {
            public /* synthetic */ a(d.h.b.h r1) {
                this();
            }

            private a() {
            }

            public final c a(u r4, ac r5) {
                d.h.b.o.e(r5, "body");
                d.h.b.h r3 = null;
                if (r4 == null) goto L5;
                String r0 = r4.a(DownloadHelper.CONTENT_TYPE);
            L6:
                boolean r1 = true;
                if (r0 != null) goto L9;
                boolean r2 = true;
            L10:
                if (r2 == false) goto L23;
                if (r4 == null) goto L13;
                String r6 = r4.a(DownloadUtils.CONTENT_LENGTH);
            L14:
                if (r6 == null) goto L17;
                r1 = false;
            L17:
                if (r1 == false) goto L21;
                return new c(r4, r5, r3);
            L21:
                throw new IllegalArgumentException("Unexpected header: Content-Length".toString());
            L13:
                r6 = null;
                goto L14
            L23:
                throw new IllegalArgumentException("Unexpected header: Content-Type".toString());
            L9:
                r2 = false;
                goto L10
            L5:
                r0 = null;
                goto L6
            }
        }

        static {
            f40233a = new a(null);
        }

        public /* synthetic */ c(u r1, ac r2, d.h.b.h r3) {
            this(r1, r2);
        }

        private c(u r1, ac r2) {
            this.f40234b = r1;
            this.f40235c = r2;
        }

        public final u a() {
            return this.f40234b;
        }

        public final ac b() {
            return this.f40235c;
        }
    }

    public y(e.h r3, x r4, List<c> r5) {
        List<c> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "boundaryByteString");
        d.h.b.o.e(r4, "type");
        d.h.b.o.e(r6, "parts");
        this.h = r3;
        this.i = r4;
        this.j = r6;
        this.k = x.f40220a.a(r4 + "; boundary=" + c());
        this.l = -1;
    }

    public final String c() {
        return this.h.d();
    }

    @Override // okhttp3.ac
    public x a() {
        return this.k;
    }

    @Override // okhttp3.ac
    public long b() {
        long r0 = this.l;
        if (r0 != (-1)) goto L6;
        long r1 = a(null, true);
        this.l = r1;
        return r1;
    L6:
        return r0;
    }

    @Override // okhttp3.ac
    public void a(e.f r3) {
        e.f r4 = (e.f) ZeusTransformUtils.wrapperContextForParams(r3, e.f.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "sink");
        a(r4, false);
    }

    private final long a(e.f r17, boolean r18) {
        e.f r1 = (e.f) ZeusTransformUtils.wrapperContextForParams(r17, e.f.class, "com.obric.aiagent.plugin");
        if (r18 == false) goto L5;
        e.e r2 = new e.e();
        e.e r3 = r2;
        r1 = (e.f) ZeusTransformUtils.preCheckCast(r2, e.f.class, "com.obric.aiagent.plugin");
    L6:
        int r4 = this.j.size();
        long r6 = 0;
        int r8 = 0;
    L7:
        if (r8 >= r4) goto L27;
        c r9 = (c) ZeusTransformUtils.preCheckCast(this.j.get(r8), c.class, "com.obric.aiagent.plugin");
        u r10 = r9.a();
        ac r11 = r9.b();
        d.h.b.o.a(r1);
        r1.c(o);
        r1.c(this.h);
        r1.c(n);
        if (r10 == null) goto L13;
        int r12 = r10.a();
        int r13 = 0;
    L11:
        if (r13 >= r12) goto L13;
        r1.b(r10.a(r13)).c(m).b(r10.b(r13)).c(n);
        r13 = r13 + 1;
    L13:
        x r14 = r11.a();
        if (r14 == null) goto L16;
        r1.b("Content-Type: ").b(r14.toString()).c(n);
    L16:
        long r15 = r11.b();
        if (r15 == (-1)) goto L19;
        r1.b("Content-Length: ").n(r15).c(n);
    L22:
        byte[] r16 = n;
        r1.c(r16);
        if (r18 == false) goto L25;
        r6 = r6 + r15;
    L26:
        r1.c(r16);
        r8 = r8 + 1;
        goto L7
    L25:
        r11.a(r1);
        goto L26
    L19:
        if (r18 == false) goto L22;
        d.h.b.o.a(r3);
        r3.x();
        return -1;
    L27:
        d.h.b.o.a(r1);
        byte[] r5 = o;
        r1.c(r5);
        r1.c(this.h);
        r1.c(r5);
        r1.c(n);
        if (r18 == false) goto L36;
        d.h.b.o.a(r3);
        long r7 = r6 + r3.b();
        r3.x();
        return r7;
    L36:
        return r6;
    L5:
        r3 = null;
        goto L6
    }

    static {
        f40225a = new b(null);
        f40226b = x.f40220a.a("multipart/mixed");
        f40227c = x.f40220a.a("multipart/alternative");
        f40228d = x.f40220a.a("multipart/digest");
        f40229e = x.f40220a.a("multipart/parallel");
        f = x.f40220a.a("multipart/form-data");
        m = new byte[]{58, 32};
        n = new byte[]{13, 10};
        o = new byte[]{45, 45};
    }
}
