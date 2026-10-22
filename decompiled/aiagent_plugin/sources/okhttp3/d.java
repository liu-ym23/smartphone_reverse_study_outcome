package okhttp3;

import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: CacheControl.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f39760a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f39761b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f39762c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f39763d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f39764e;
    private final int f;
    private final int g;
    private final boolean h;
    private final boolean i;
    private final boolean j;
    private final int k;
    private final int l;
    private final boolean m;
    private final boolean n;
    private final boolean o;
    private String p;

    /* JADX INFO: compiled from: CacheControl.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f39765a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f39766b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f39767c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f39768d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f39769e;
        private boolean f;
        private boolean g;
        private boolean h;

        private final int a(long r3) {
            if (r3 <= 2147483647L) goto L6;
            return Integer.MAX_VALUE;
        L6:
            return (int) r3;
        }

        public a() {
            this.f39767c = -1;
            this.f39768d = -1;
            this.f39769e = -1;
        }

        public final a a() {
            ((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin")).f39765a = true;
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        }

        public final a a(int r6, TimeUnit r7) {
            d.h.b.o.e(r7, "timeUnit");
            a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
            if (r6 < 0) goto L5;
            boolean r3 = true;
        L6:
            if (r3 == false) goto L10;
            r2.f39768d = r2.a(r7.toSeconds(r6));
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        L10:
            throw new IllegalArgumentException(("maxStale < 0: " + r6).toString());
        L5:
            r3 = false;
            goto L6
        }

        public final a b() {
            ((a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin")).f = true;
            return (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
        }

        public final d c() {
            int r4 = -1;
            boolean r5 = false;
            boolean r6 = false;
            boolean r7 = false;
            return new d(this.f39765a, this.f39766b, this.f39767c, r4, r5, r6, r7, this.f39768d, this.f39769e, this.f, this.g, this.h, null, null);
        }
    }

    /* JADX INFO: compiled from: CacheControl.kt */
    public static final class b {
        public /* synthetic */ b(d.h.b.h r1) {
            this();
        }

        private b() {
        }

        public final d a(u r33) {
            u r1 = r33;
            d.h.b.o.e(r1, "headers");
            int r2 = r33.a();
            boolean r6 = true;
            boolean r8 = true;
            int r7 = 0;
            String r9 = null;
            boolean r10 = false;
            boolean r11 = false;
            int r12 = -1;
            int r13 = -1;
            boolean r14 = false;
            boolean r15 = false;
            boolean r16 = false;
            int r17 = -1;
            int r18 = -1;
            boolean r19 = false;
            boolean r20 = false;
            boolean r21 = false;
        L3:
            if (r7 >= r2) goto L71;
            String r3 = r1.a(r7);
            String r5 = r1.b(r7);
            if (d.o.o.a(r3, DownloadHelper.CACHE_CONTROL, r6) == false) goto L10;
            if (r9 != null) goto L11;
            r9 = r5;
        L12:
            int r4 = 0;
        L14:
            if (r4 >= r5.length()) goto L68;
            int r22 = a(r5, "=,;", r4);
            String r23 = r5.substring(r4, r22);
            d.h.b.o.c(r23, "this as java.lang.String…ing(startIndex, endIndex)");
            int r24 = r2;
            String r25 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r23, CharSequence.class, "com.obric.aiagent.plugin")).toString();
            if (r22 == r5.length()) goto L28;
            boolean r26 = r8;
            if (r5.charAt(r22) != ',') goto L20;
        L29:
            r4 = r22 + 1;
            String r27 = null;
        L30:
            r6 = true;
            if (d.o.o.a("no-cache", r25, true) == false) goto L35;
            r10 = true;
        L33:
            r2 = r24;
            r8 = r26;
            goto L14
        L35:
            if (d.o.o.a("no-store", r25, true) == false) goto L38;
            r11 = true;
            goto L33
        L38:
            if (d.o.o.a("max-age", r25, true) == false) goto L42;
            r12 = okhttp3.internal.c.b(r27, -1);
            goto L33
        L42:
            if (d.o.o.a("s-maxage", r25, true) == false) goto L45;
            r13 = okhttp3.internal.c.b(r27, -1);
            goto L33
        L45:
            if (d.o.o.a("private", r25, true) == false) goto L48;
            r14 = true;
            goto L33
        L48:
            if (d.o.o.a("public", r25, true) == false) goto L51;
            r15 = true;
            goto L33
        L51:
            if (d.o.o.a("must-revalidate", r25, true) == false) goto L54;
            r16 = true;
            goto L33
        L54:
            if (d.o.o.a("max-stale", r25, true) == false) goto L57;
            r17 = okhttp3.internal.c.b(r27, Integer.MAX_VALUE);
            goto L33
        L57:
            if (d.o.o.a("min-fresh", r25, true) == false) goto L60;
            r18 = okhttp3.internal.c.b(r27, -1);
            goto L33
        L60:
            if (d.o.o.a("only-if-cached", r25, true) == false) goto L63;
            r19 = true;
            goto L33
        L63:
            if (d.o.o.a("no-transform", r25, true) == false) goto L66;
            r20 = true;
            goto L33
        L66:
            if (d.o.o.a("immutable", r25, true) == false) goto L33;
            r21 = true;
            goto L33
        L20:
            if (r5.charAt(r22) == ';') goto L29;
            int r28 = okhttp3.internal.c.a(r5, r22 + 1);
            if (r28 < r5.length()) goto L25;
        L27:
            r4 = a(r5, ",;", r28);
            String r29 = r5.substring(r28, r4);
            d.h.b.o.c(r29, "this as java.lang.String…ing(startIndex, endIndex)");
            r27 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r29, CharSequence.class, "com.obric.aiagent.plugin")).toString();
            goto L30
        L25:
            if (r5.charAt(r28) != '\"') goto L27;
            int r30 = r28 + 1;
            int r31 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin"), '\"', r30, false, 4, null);
            r27 = r5.substring(r30, r31);
            d.h.b.o.c(r27, "this as java.lang.String…ing(startIndex, endIndex)");
            r4 = r31 + 1;
            goto L30
        L28:
            r26 = r8;
            goto L29
        L68:
            int r210 = r2;
        L70:
            r7 = r7 + 1;
            r1 = r33;
            r2 = r210;
        L11:
            r8 = false;
            goto L12
        L10:
            if (d.o.o.a(r3, "Pragma", r6) == true) goto L11;
            r210 = r2;
            goto L70
        L71:
            if (r8 == true) goto L73;
            String r211 = null;
        L75:
            return new d(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r211, null);
        L73:
            r211 = r9;
            goto L75
        }

        private final int a(String r6, String r7, int r8) {
            int r5 = r6.length();
        L3:
            if (r8 >= r5) goto L9;
            if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"), r6.charAt(r8), false, 2, null) == true) goto L6;
            r8 = r8 + 1;
            goto L3
        L6:
            return r8;
        L9:
            return r6.length();
        }
    }

    public /* synthetic */ d(boolean r1, boolean r2, int r3, int r4, boolean r5, boolean r6, boolean r7, int r8, int r9, boolean r10, boolean r11, boolean r12, String r13, d.h.b.h r14) {
        this(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    }

    private d(boolean r1, boolean r2, int r3, int r4, boolean r5, boolean r6, boolean r7, int r8, int r9, boolean r10, boolean r11, boolean r12, String r13) {
        this.f39763d = r1;
        this.f39764e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r5;
        this.i = r6;
        this.j = r7;
        this.k = r8;
        this.l = r9;
        this.m = r10;
        this.n = r11;
        this.o = r12;
        this.p = r13;
    }

    public final boolean a() {
        return this.f39763d;
    }

    public final boolean b() {
        return this.f39764e;
    }

    public final int c() {
        return this.f;
    }

    public final boolean d() {
        return this.h;
    }

    public final boolean e() {
        return this.i;
    }

    public final boolean f() {
        return this.j;
    }

    public final int g() {
        return this.k;
    }

    public final int h() {
        return this.l;
    }

    public final boolean i() {
        return this.m;
    }

    public String toString() {
        String r0 = this.p;
        if (r0 != null) goto L49;
        StringBuilder r1 = new StringBuilder();
        if (this.f39763d == false) goto L8;
        r1.append("no-cache, ");
    L8:
        if (this.f39764e == false) goto L11;
        r1.append("no-store, ");
    L11:
        if (this.f == (-1)) goto L14;
        r1.append("max-age=").append(this.f).append(", ");
    L14:
        if (this.g == (-1)) goto L17;
        r1.append("s-maxage=").append(this.g).append(", ");
    L17:
        if (this.h == false) goto L20;
        r1.append("private, ");
    L20:
        if (this.i == false) goto L23;
        r1.append("public, ");
    L23:
        if (this.j == false) goto L26;
        r1.append("must-revalidate, ");
    L26:
        if (this.k == (-1)) goto L29;
        r1.append("max-stale=").append(this.k).append(", ");
    L29:
        if (this.l == (-1)) goto L32;
        r1.append("min-fresh=").append(this.l).append(", ");
    L32:
        if (this.m == false) goto L35;
        r1.append("only-if-cached, ");
    L35:
        if (this.n == false) goto L38;
        r1.append("no-transform, ");
    L38:
        if (this.o == false) goto L41;
        r1.append("immutable, ");
    L41:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L43;
        boolean r2 = true;
    L44:
        if (r2 == false) goto L47;
        return "";
    L47:
        r1.delete(r1.length() - 2, r1.length());
        String r3 = r1.toString();
        d.h.b.o.c(r3, "StringBuilder().apply(builderAction).toString()");
        this.p = r3;
        return r3;
    L43:
        r2 = false;
        goto L44
    L49:
        return r0;
    }

    static {
        f39760a = new b(null);
        f39761b = new a().a().c();
        f39762c = new a().b().a(Integer.MAX_VALUE, TimeUnit.SECONDS).c();
    }
}
