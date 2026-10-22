package okhttp3.internal.g;

import com.bytedance.apm.battery.dao.DBHelper;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import e.aa;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: Hpack.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f39973a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final c[] f39974b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<e.h, Integer> f39975c = null;

    /* JADX INFO: compiled from: Hpack.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c[] f39976a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f39977b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f39978c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f39979d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f39980e;
        private final List<c> f;
        private final e.g g;
        private int h;

        public a(aa r3, int r4, int r5) {
            aa r6 = (aa) ZeusTransformUtils.wrapperContextForParams(r3, aa.class, "com.obric.aiagent.plugin");
            o.e(r6, DBHelper.BATTERY_COL_SOURCE);
            this.f39979d = r4;
            this.f39980e = r5;
            this.f = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
            this.g = e.o.a(r6);
            c[] r7 = new c[8];
            this.f39976a = r7;
            this.h = r7.length - 1;
        }

        public /* synthetic */ a(aa r2, int r3, int r4, int r5, d.h.b.h r6) {
            aa r7 = (aa) ZeusTransformUtils.wrapperContextForParams(r2, aa.class, "com.obric.aiagent.plugin");
            if ((r5 & 4) == 0) goto L5;
            r4 = r3;
        L5:
            this(r7, r3, r4);
        }

        public final List<c> a() {
            List<c> r0 = p.o((Iterable) ZeusTransformUtils.preCheckCast(this.f, Iterable.class, "com.obric.aiagent.plugin"));
            this.f.clear();
            return r0;
        }

        private final void d() {
            int r0 = this.f39980e;
            int r1 = this.f39978c;
            if (r0 >= r1) goto L8;
            if (r0 != 0) goto L6;
            e();
            return;
        L6:
            a(r1 - r0);
            return;
        }

        private final void e() {
            d.a.i.a(this.f39976a, null, 0, 0, 6, null);
            this.h = this.f39976a.length - 1;
            this.f39977b = 0;
            this.f39978c = 0;
        }

        private final int a(int r5) {
            int r0 = 0;
            if (r5 <= 0) goto L10;
            int r1 = this.f39976a.length;
        L5:
            r1 = r1 - 1;
            int r2 = this.h;
            if (r1 < r2) goto L9;
            if (r5 <= 0) goto L9;
            c r3 = this.f39976a[r1];
            o.a(r3);
            r5 = r5 - r3.f39972d;
            this.f39978c -= r3.f39972d;
            this.f39977b--;
            r0 = r0 + 1;
        L9:
            c[] r6 = this.f39976a;
            System.arraycopy(r6, r2 + 1, r6, (r2 + 1) + r0, this.f39977b);
            this.h += r0;
        L10:
            return r0;
        }

        public final void b() {
        L3:
            if (this.g.h() == true) goto L32;
            int r0 = okhttp3.internal.c.a(this.g.k(), 255);
            if (r0 == 128) goto L31;
            if ((r0 & 128) == 128) goto L8;
            if (r0 == 64) goto L11;
            if ((r0 & 64) == 64) goto L14;
            if ((r0 & 32) == 32) goto L17;
            if (r0 == 16) goto L29;
            if (r0 == 0) goto L29;
            d(a(r0, 15) - 1);
        L29:
            f();
            goto L3
        L17:
            int r1 = a(r0, 31);
            this.f39980e = r1;
            if (r1 < 0) goto L23;
            if (r1 > this.f39979d) goto L23;
            d();
        L23:
            throw new IOException("Invalid dynamic table size update " + this.f39980e);
        L14:
            e(a(r0, 63) - 1);
            goto L3
        L11:
            g();
            goto L3
        L8:
            b(a(r0, 127) - 1);
            goto L3
        L31:
            throw new IOException("index == 0");
        }

        private final void b(int r4) {
            if (g(r4) == false) goto L5;
            this.f.add(d.f39973a.a()[r4]);
            return;
        L5:
            int r0 = c(r4 - d.f39973a.a().length);
            if (r0 < 0) goto L12;
            if (r0 >= this.f39976a.length) goto L12;
            Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(this.f, Collection.class, "com.obric.aiagent.plugin");
            c r3 = this.f39976a[r0];
            o.a(r3);
            r5.add(r3);
            return;
        L12:
            throw new IOException("Header index too large " + (r4 + 1));
        }

        private final int c(int r1) {
            return (this.h + 1) + r1;
        }

        private final void d(int r3) {
            e.h r4 = f(r3);
            e.h r0 = c();
            this.f.add(new c(r4, r0));
        }

        private final void f() {
            e.h r0 = d.f39973a.a(c());
            e.h r1 = c();
            this.f.add(new c(r0, r1));
        }

        private final void e(int r3) {
            a(-1, new c(f(r3), c()));
        }

        private final void g() {
            a(-1, new c(d.f39973a.a(c()), c()));
        }

        private final e.h f(int r3) {
            if (g(r3) == true) goto L13;
            int r0 = c(r3 - d.f39973a.a().length);
            if (r0 < 0) goto L12;
            c[] r2 = this.f39976a;
            if (r0 >= r2.length) goto L12;
            c r4 = r2[r0];
            o.a(r4);
            return r4.f39970b;
        L12:
            throw new IOException("Header index too large " + (r3 + 1));
        L13:
            return d.f39973a.a()[r3].f39970b;
        }

        private final boolean g(int r2) {
            if (r2 >= 0) goto L5;
        L7:
            return false;
        L5:
            if (r2 > (d.f39973a.a().length - 1)) goto L7;
            return true;
        }

        private final void a(int r6, c r7) {
            this.f.add(r7);
            int r0 = r7.f39972d;
            if (r6 == (-1)) goto L5;
            c r2 = this.f39976a[c(r6)];
            o.a(r2);
            r0 = r0 - r2.f39972d;
        L5:
            int r3 = this.f39980e;
            if (r0 <= r3) goto L9;
            e();
            return;
        L9:
            int r4 = a((this.f39978c + r0) - r3);
            if (r6 != (-1)) goto L15;
            int r8 = this.f39977b + 1;
            c[] r1 = this.f39976a;
            if (r8 <= r1.length) goto L14;
            c[] r9 = new c[r1.length * 2];
            System.arraycopy(r1, 0, r9, r1.length, r1.length);
            this.h = this.f39976a.length - 1;
            this.f39976a = r9;
        L14:
            int r10 = this.h;
            this.h = r10 - 1;
            this.f39976a[r10] = r7;
            this.f39977b++;
        L16:
            this.f39978c += r0;
            return;
        L15:
            this.f39976a[r6 + (c(r6) + r4)] = r7;
            goto L16
        }

        private final int h() {
            return okhttp3.internal.c.a(this.g.k(), 255);
        }

        public final int a(int r3, int r4) {
            int r5 = r3 & r4;
            if (r5 >= r4) goto L5;
            return r5;
        L5:
            int r6 = 0;
        L6:
            int r0 = h();
            if ((r0 & 128) == 0) goto L10;
            r4 = r4 + ((r0 & 127) << r6);
            r6 = r6 + 7;
            goto L6
        L10:
            return r4 + (r0 << r6);
        }

        public final e.h c() {
            int r0 = h();
            if ((r0 & 128) != 128) goto L5;
            boolean r1 = true;
        L6:
            long r2 = a(r0, 127);
            if (r1 == false) goto L10;
            e.e r3 = new e.e();
            k.f40074a.a(this.g, r2, (e.f) ZeusTransformUtils.preCheckCast(r3, e.f.class, "com.obric.aiagent.plugin"));
            return r3.t();
        L10:
            return this.g.d(r2);
        L5:
            r1 = false;
            goto L6
        }
    }

    /* JADX INFO: compiled from: Hpack.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f39981a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f39982b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public c[] f39983c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f39984d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f39985e;
        private final boolean f;
        private final e.e g;
        private int h;
        private boolean i;
        private int j;

        public b(int r2, boolean r3, e.e r4) {
            o.e(r4, "out");
            this.f39981a = r2;
            this.f = r3;
            this.g = r4;
            this.h = Integer.MAX_VALUE;
            this.f39982b = r2;
            c[] r5 = new c[8];
            this.f39983c = r5;
            this.j = r5.length - 1;
        }

        public /* synthetic */ b(int r1, boolean r2, e.e r3, int r4, d.h.b.h r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = 4096;
        L6:
            if ((r4 & 2) == 0) goto L8;
            r2 = true;
        L8:
            this(r1, r2, r3);
        }

        private final void a() {
            d.a.i.a(this.f39983c, null, 0, 0, 6, null);
            this.j = this.f39983c.length - 1;
            this.f39984d = 0;
            this.f39985e = 0;
        }

        private final int b(int r5) {
            int r0 = 0;
            if (r5 <= 0) goto L10;
            int r1 = this.f39983c.length;
        L5:
            r1 = r1 - 1;
            int r2 = this.j;
            if (r1 < r2) goto L9;
            if (r5 <= 0) goto L9;
            c r3 = this.f39983c[r1];
            o.a(r3);
            r5 = r5 - r3.f39972d;
            int r4 = this.f39985e;
            c r6 = this.f39983c[r1];
            o.a(r6);
            this.f39985e = r4 - r6.f39972d;
            this.f39984d--;
            r0 = r0 + 1;
        L9:
            c[] r7 = this.f39983c;
            System.arraycopy(r7, r2 + 1, r7, (r2 + 1) + r0, this.f39984d);
            c[] r8 = this.f39983c;
            int r9 = this.j;
            Arrays.fill(r8, r9 + 1, (r9 + 1) + r0, null);
            this.j += r0;
        L10:
            return r0;
        }

        private final void a(c r7) {
            int r0 = r7.f39972d;
            int r1 = this.f39982b;
            if (r0 <= r1) goto L6;
            a();
            return;
        L6:
            b((this.f39985e + r0) - r1);
            int r2 = this.f39984d + 1;
            c[] r3 = this.f39983c;
            if (r2 <= r3.length) goto L9;
            c[] r4 = new c[r3.length * 2];
            System.arraycopy(r3, 0, r4, r3.length, r3.length);
            this.j = this.f39983c.length - 1;
            this.f39983c = r4;
        L9:
            int r5 = this.j;
            this.j = r5 - 1;
            this.f39983c[r5] = r7;
            this.f39984d++;
            this.f39985e += r0;
        }

        public final void a(List<c> r15) {
            List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.aiagent.plugin");
            o.e(r16, "headerBlock");
            if (this.i == false) goto L8;
            int r0 = this.h;
            if (r0 >= this.f39982b) goto L7;
            a(r0, 31, 32);
        L7:
            this.i = false;
            this.h = Integer.MAX_VALUE;
            a(this.f39982b, 31, 32);
        L8:
            int r1 = r16.size();
            int r3 = 0;
        L9:
            if (r3 >= r1) goto L51;
            c r4 = (c) ZeusTransformUtils.preCheckCast(r16.get(r3), c.class, "com.obric.aiagent.plugin");
            e.h r5 = r4.f39970b.j();
            e.h r6 = r4.f39971c;
            Integer r7 = (Integer) ZeusTransformUtils.preCheckCast(d.f39973a.b().get(r5), Integer.class, "com.obric.aiagent.plugin");
            if (r7 == null) goto L26;
            int r8 = r7.intValue() + 1;
            if (2 <= r8) goto L15;
        L17:
            boolean r10 = false;
        L18:
            if (r10 == true) goto L20;
        L25:
            int r11 = r8;
            r8 = -1;
        L28:
            if (r8 != (-1)) goto L39;
            int r12 = this.j + 1;
            int r9 = this.f39983c.length;
        L30:
            if (r12 >= r9) goto L39;
            c r13 = this.f39983c[r12];
            o.a(r13);
            if (o.a(r13.f39970b, r5) == false) goto L38;
            c r14 = this.f39983c[r12];
            o.a(r14);
            if (o.a(r14.f39971c, r6) == true) goto L35;
            if (r11 != (-1)) goto L38;
            r11 = (r12 - this.j) + d.f39973a.a().length;
            goto L38
        L35:
            r8 = d.f39973a.a().length + (r12 - this.j);
        L38:
            r12 = r12 + 1;
        L39:
            if (r8 == (-1)) goto L42;
            a(r8, 127, 128);
        L50:
            r3 = r3 + 1;
            goto L9
        L42:
            if (r11 != (-1)) goto L45;
            this.g.b(64);
            a(r5);
            a(r6);
            a(r4);
            goto L50
        L45:
            if (r5.a(c.f39969e) == true) goto L47;
        L49:
            a(r11, 63, 64);
            a(r6);
            a(r4);
            goto L50
        L47:
            if (o.a(c.j, r5) == true) goto L49;
            a(r11, 15, 0);
            a(r6);
            goto L50
        L20:
            if (o.a(d.f39973a.a()[r8 - 1].f39971c, r6) == false) goto L23;
        L27:
            r11 = r8;
            goto L28
        L23:
            if (o.a(d.f39973a.a()[r8].f39971c, r6) == false) goto L25;
            r11 = r8;
            r8 = r8 + 1;
            goto L28
        L15:
            if (r8 >= 8) goto L17;
            r10 = true;
            goto L18
        L26:
            r8 = -1;
            goto L27
        }

        public final void a(int r2, int r3, int r4) {
            if (r2 >= r3) goto L5;
            this.g.b(r2 | r4);
            return;
        L5:
            this.g.b(r4 | r3);
            int r5 = r2 - r3;
        L7:
            if (r5 < 128) goto L9;
            this.g.b(128 | (r5 & 127));
            r5 = r5 >>> 7;
            goto L7
        L9:
            this.g.b(r5);
        }

        public final void a(e.h r6) {
            o.e(r6, "data");
            if (this.f == true) goto L5;
        L7:
            a(r6.k(), 127, 0);
            this.g.a(r6);
            return;
        L5:
            if (k.f40074a.a(r6) >= r6.k()) goto L7;
            e.e r0 = new e.e();
            k.f40074a.a(r6, (e.f) ZeusTransformUtils.preCheckCast(r0, e.f.class, "com.obric.aiagent.plugin"));
            e.h r7 = r0.t();
            a(r7.k(), 127, 128);
            this.g.a(r7);
        }

        public final void a(int r2) {
            this.f39981a = r2;
            int r3 = Math.min(r2, 16384);
            int r0 = this.f39982b;
            if (r0 != r3) goto L5;
            return;
        L5:
            if (r3 >= r0) goto L7;
            this.h = Math.min(this.h, r3);
        L7:
            this.i = true;
            this.f39982b = r3;
            b();
        }

        private final void b() {
            int r0 = this.f39982b;
            int r1 = this.f39985e;
            if (r0 >= r1) goto L8;
            if (r0 != 0) goto L6;
            a();
            return;
        L6:
            b(r1 - r0);
            return;
        }
    }

    private d() {
    }

    public final c[] a() {
        return f39974b;
    }

    static {
        d r0 = new d();
        f39973a = r0;
        f39974b = new c[]{new c(c.j, ""), new c(c.g, "GET"), new c(c.g, "POST"), new c(c.h, "/"), new c(c.h, "/index.html"), new c(c.i, "http"), new c(c.i, "https"), new c(c.f, "200"), new c(c.f, "204"), new c(c.f, "206"), new c(c.f, "304"), new c(c.f, "400"), new c(c.f, "404"), new c(c.f, "500"), new c("accept-charset", ""), new c("accept-encoding", "gzip, deflate"), new c("accept-language", ""), new c("accept-ranges", ""), new c("accept", ""), new c("access-control-allow-origin", ""), new c("age", ""), new c("allow", ""), new c("authorization", ""), new c("cache-control", ""), new c("content-disposition", ""), new c("content-encoding", ""), new c("content-language", ""), new c("content-length", ""), new c("content-location", ""), new c("content-range", ""), new c("content-type", ""), new c("cookie", ""), new c("date", ""), new c("etag", ""), new c("expect", ""), new c("expires", ""), new c("from", ""), new c("host", ""), new c("if-match", ""), new c(DownloadHelper.IF_MODIFIED_SINCE, ""), new c("if-none-match", ""), new c("if-range", ""), new c("if-unmodified-since", ""), new c("last-modified", ""), new c("link", ""), new c("location", ""), new c("max-forwards", ""), new c("proxy-authenticate", ""), new c("proxy-authorization", ""), new c("range", ""), new c("referer", ""), new c("refresh", ""), new c("retry-after", ""), new c("server", ""), new c("set-cookie", ""), new c("strict-transport-security", ""), new c("transfer-encoding", ""), new c("user-agent", ""), new c("vary", ""), new c("via", ""), new c("www-authenticate", "")};
        f39975c = r0.c();
    }

    public final Map<e.h, Integer> b() {
        return f39975c;
    }

    private final Map<e.h, Integer> c() {
        c[] r0 = f39974b;
        LinkedHashMap r6 = new LinkedHashMap(r0.length);
        int r1 = r0.length;
        int r2 = 0;
    L4:
        if (r2 >= r1) goto L9;
        c[] r3 = f39974b;
        if (r6.containsKey(r3[r2].f39970b) == true) goto L8;
        Integer r4 = Integer.valueOf(r2);
        ((Map) ZeusTransformUtils.preCheckCast(r6, Map.class, "com.obric.aiagent.plugin")).put(r3[r2].f39970b, r4);
    L8:
        r2 = r2 + 1;
        goto L4
    L9:
        Map<e.h, Integer> r7 = Collections.unmodifiableMap((Map) ZeusTransformUtils.preCheckCast(r6, Map.class, "com.obric.aiagent.plugin"));
        o.c(r7, "unmodifiableMap(result)");
        return r7;
    }

    public final e.h a(e.h r5) {
        o.e(r5, "name");
        int r4 = r5.k();
        int r1 = 0;
    L3:
        if (r1 >= r4) goto L14;
        byte r2 = r5.c(r1);
        if (65 <= r2) goto L7;
    L9:
        boolean r3 = false;
    L10:
        if (r3 == true) goto L13;
        r1 = r1 + 1;
        goto L3
    L13:
        throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + r5.d());
    L7:
        if (r2 >= 91) goto L9;
        r3 = true;
        goto L10
    L14:
        return r5;
    }
}
