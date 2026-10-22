package okhttp3.internal.b;

import com.obric.capabilitykit.common.Ext;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import d.h.b.h;
import d.h.b.o;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import okhttp3.ab;
import okhttp3.ad;
import okhttp3.u;

/* JADX INFO: compiled from: CacheStrategy.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f39797a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ab f39798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ad f39799c;

    /* JADX INFO: compiled from: CacheStrategy.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final boolean a(ad r4, ab r5) {
            o.e(r4, "response");
            o.e(r5, Ext.KEY_REQUEST);
            int r3 = r4.d();
            if (r3 == 200) goto L34;
            if (r3 == 410) goto L34;
            if (r3 == 414) goto L34;
            if (r3 == 501) goto L34;
            if (r3 == 203) goto L34;
            if (r3 == 204) goto L34;
            if (r3 == 307) goto L25;
            if (r3 == 308) goto L34;
            if (r3 == 404) goto L34;
            if (r3 == 405) goto L34;
            switch(r3) {
                case 300: goto L34;
                case 301: goto L34;
                case 302: goto L25;
                default: goto L23;
            };
        L23:
            return false;
        L25:
            if (ad.a(r4, "Expires", null, 2, null) != null) goto L34;
            if (r4.r().c() != (-1)) goto L34;
            if (r4.r().e() == true) goto L34;
            if (r4.r().d() == true) goto L34;
            return false;
        L34:
            if (r4.r().b() == false) goto L36;
            return false;
        L36:
            if (r5.i().b() == true) goto L40;
            return true;
        L40:
            return false;
        }
    }

    /* JADX INFO: compiled from: CacheStrategy.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f39800a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ab f39801b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ad f39802c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Date f39803d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f39804e;
        private Date f;
        private String g;
        private Date h;
        private long i;
        private long j;
        private String k;
        private int l;

        public b(long r5, ab r7, ad r8) {
            o.e(r7, Ext.KEY_REQUEST);
            this.f39800a = r5;
            this.f39801b = r7;
            this.f39802c = r8;
            this.l = -1;
            if (r8 == null) goto L22;
            this.i = r8.k();
            this.j = r8.l();
            u r6 = r8.f();
            int r9 = 0;
            int r10 = r6.a();
        L5:
            if (r9 >= r10) goto L30;
            String r0 = r6.a(r9);
            String r1 = r6.b(r9);
            if (d.o.o.a(r0, "Date", true) == false) goto L10;
            this.f39803d = okhttp3.internal.e.c.a(r1);
            this.f39804e = r1;
        L21:
            r9 = r9 + 1;
            goto L5
        L10:
            if (d.o.o.a(r0, "Expires", true) == false) goto L13;
            this.h = okhttp3.internal.e.c.a(r1);
            goto L21
        L13:
            if (d.o.o.a(r0, DownloadHelper.LAST_MODIFIED_CASE, true) == false) goto L16;
            this.f = okhttp3.internal.e.c.a(r1);
            this.g = r1;
            goto L21
        L16:
            if (d.o.o.a(r0, "ETag", true) == false) goto L19;
            this.k = r1;
            goto L21
        L19:
            if (d.o.o.a(r0, "Age", true) == false) goto L21;
            this.l = okhttp3.internal.c.b(r1, -1);
            goto L21
        L30:
            return;
        }

        private final boolean b() {
            ad r0 = this.f39802c;
            o.a(r0);
            if (r0.r().c() == (-1)) goto L5;
        L7:
            return false;
        L5:
            if (this.h != null) goto L7;
            return true;
        }

        public final c a() {
            c r0 = c();
            if (r0.a() != null) goto L5;
        L8:
            return r0;
        L5:
            if (this.f39801b.i().i() == false) goto L8;
            return new c(null, null);
        }

        private final c c() {
            if (this.f39802c != null) goto L7;
            return new c(this.f39801b, null);
        L7:
            if (this.f39801b.f() == false) goto L13;
            if (this.f39802c.e() != null) goto L13;
            return new c(this.f39801b, null);
        L13:
            if (c.f39797a.a(this.f39802c, this.f39801b) == false) goto L15;
            okhttp3.d r0 = this.f39801b.i();
            if (r0.a() == true) goto L61;
            if (a(this.f39801b) == true) goto L61;
            okhttp3.d r2 = this.f39802c.r();
            long r3 = e();
            long r5 = d();
            if (r0.c() == (-1)) goto L24;
            r5 = Math.min(r5, TimeUnit.SECONDS.toMillis(r0.c()));
        L24:
            long r9 = 0;
            if (r0.h() == (-1)) goto L27;
            long r11 = TimeUnit.SECONDS.toMillis(r0.h());
        L29:
            if (r2.f() == true) goto L34;
            if (r0.g() == (-1)) goto L34;
            r9 = TimeUnit.SECONDS.toMillis(r0.g());
        L34:
            if (r2.a() == true) goto L47;
            long r12 = r11 + r3;
            if (r12 >= (r9 + r5)) goto L47;
            ad.a r1 = this.f39802c.o();
            if (r12 < r5) goto L41;
            r1.b("Warning", "110 HttpURLConnection \"Response is stale\"");
        L41:
            if (r3 <= 86400000) goto L46;
            if (b() == false) goto L46;
            r1.b("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
        L46:
            return new c(null, r1.b());
        L47:
            String r4 = this.k;
            String r6 = "If-Modified-Since";
            if (r4 == null) goto L51;
            r6 = DownloadHelper.IF_NONE_MATCH;
        L56:
            u.a r7 = this.f39801b.c().d();
            o.a(r4);
            r7.b(r6, r4);
            return new c(this.f39801b.h().a(r7.b()).b(), this.f39802c);
        L51:
            if (this.f == null) goto L54;
            r4 = this.g;
            goto L56
        L54:
            if (this.f39803d == null) goto L59;
            r4 = this.f39804e;
            goto L56
        L59:
            return new c(this.f39801b, null);
        L27:
            r11 = 0;
        L61:
            return new c(this.f39801b, null);
        L15:
            return new c(this.f39801b, null);
        }

        private final long d() {
            ad r0 = this.f39802c;
            o.a(r0);
            okhttp3.d r1 = r0.r();
            if (r1.c() != (-1)) goto L5;
            Date r2 = this.h;
            if (r2 == null) goto L17;
            Date r3 = this.f39803d;
            if (r3 == null) goto L11;
            long r4 = r3.getTime();
        L12:
            long r5 = r2.getTime() - r4;
            if (r5 > 0) goto L15;
            return 0;
        L15:
            return r5;
        L11:
            r4 = this.j;
            goto L12
        L17:
            if (this.f != null) goto L19;
            return 0;
        L19:
            if (this.f39802c.a().a().query() != null) goto L30;
            Date r6 = this.f39803d;
            if (r6 == null) goto L23;
            long r7 = r6.getTime();
        L24:
            Date r8 = this.f;
            o.a(r8);
            long r9 = r7 - r8.getTime();
            if (r9 > 0) goto L27;
            return 0;
        L27:
            return r9 / ((long) 10);
        L23:
            r7 = this.i;
            goto L24
        L30:
            return 0;
        L5:
            return TimeUnit.SECONDS.toMillis(r1.c());
        }

        private final long e() {
            Date r0 = this.f39803d;
            long r1 = 0;
            if (r0 == null) goto L6;
            r1 = Math.max(0, this.j - r0.getTime());
        L6:
            if (this.l == (-1)) goto L8;
            r1 = Math.max(r1, TimeUnit.SECONDS.toMillis(this.l));
        L8:
            long r3 = this.j;
            return (r1 + (r3 - this.i)) + (this.f39800a - r3);
        }

        private final boolean a(ab r1) {
            if (r1.a("If-Modified-Since") == null) goto L5;
        L8:
            return true;
        L5:
            if (r1.a(DownloadHelper.IF_NONE_MATCH) != null) goto L8;
            return false;
        }
    }

    static {
        f39797a = new a(null);
    }

    public c(ab r1, ad r2) {
        this.f39798b = r1;
        this.f39799c = r2;
    }

    public final ab a() {
        return this.f39798b;
    }

    public final ad b() {
        return this.f39799c;
    }
}
