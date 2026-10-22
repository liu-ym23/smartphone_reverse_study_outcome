package okhttp3.internal.publicsuffix;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import d.h.b.z;
import d.n.j;
import d.n.m;
import d.x;
import e.aa;
import e.g;
import e.l;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.internal.c;

/* JADX INFO: compiled from: PublicSuffixDatabase.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class PublicSuffixDatabase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f40158a = null;
    private static final byte[] f = null;
    private static final List<String> g = null;
    private static final PublicSuffixDatabase h = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f40159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CountDownLatch f40160c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private byte[] f40161d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private byte[] f40162e;

    /* JADX INFO: compiled from: PublicSuffixDatabase.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public static final /* synthetic */ String a(a r0, byte[] r1, byte[][] r2, int r3) {
            return r0.a(r1, r2, r3);
        }

        public final PublicSuffixDatabase a() {
            return PublicSuffixDatabase.a();
        }

        private final String a(byte[] r19, byte[][] r20, int r21) {
            int r2 = r19.length;
            int r4 = 0;
        L3:
            if (r4 >= r2) goto L42;
            int r5 = (r4 + r2) / 2;
        L6:
            if (r5 <= (-1)) goto L10;
            if (r19[r5] == 10) goto L10;
            r5 = r5 - 1;
        L10:
            int r6 = r5 + 1;
            int r9 = 1;
        L11:
            int r10 = r6 + r9;
            if (r19[r10] == 10) goto L14;
            r9 = r9 + 1;
            goto L11
        L14:
            int r7 = r10 - r6;
            int r11 = r21;
            boolean r12 = false;
            int r13 = 0;
            int r14 = 0;
        L16:
            if (r12 == false) goto L18;
            int r15 = 46;
            boolean r16 = false;
        L19:
            int r17 = r15 - c.a(r19[r6 + r14], 255);
            if (r17 != 0) goto L30;
            r14 = r14 + 1;
            r13 = r13 + 1;
            if (r14 == r7) goto L30;
            if (r20[r11].length == r13) goto L26;
            r12 = r16;
            goto L16
        L26:
            if (r11 == (((Object[]) ZeusTransformUtils.preCheckCast(r20, Object[].class, "com.obric.aiagent.plugin")).length - 1)) goto L30;
            r11 = r11 + 1;
            r13 = -1;
            r12 = true;
        L30:
            if (r17 < 0) goto L31;
            if (r17 > 0) goto L33;
            int r8 = r7 - r14;
            int r18 = r20[r11].length - r13;
            int r110 = r11 + 1;
            int r3 = ((Object[]) ZeusTransformUtils.preCheckCast(r20, Object[].class, "com.obric.aiagent.plugin")).length;
        L35:
            if (r110 >= r3) goto L37;
            r18 = r18 + r20[r110].length;
            r110 = r110 + 1;
            goto L35
        L37:
            if (r18 < r8) goto L31;
            if (r18 > r8) goto L33;
            Charset r1 = StandardCharsets.UTF_8;
            o.c(r1, "UTF_8");
            return new String(r19, r6, r7, r1);
        L33:
            r4 = r10 + 1;
        L31:
            r2 = r6 - 1;
            goto L3
        L18:
            r16 = r12;
            r15 = c.a(r20[r11][r13], 255);
            goto L19
        L42:
            return null;
        }
    }

    public PublicSuffixDatabase() {
        this.f40159b = new AtomicBoolean(false);
        this.f40160c = new CountDownLatch(1);
    }

    public static final /* synthetic */ PublicSuffixDatabase a() {
        return h;
    }

    public final String a(String r18) {
        o.e(r18, "domain");
        String r1 = IDN.toUnicode(r18);
        o.c(r1, "unicodeDomain");
        List<String> r2 = b(r1);
        List<String> r3 = a(r2);
        if (r2.size() != r3.size()) goto L9;
        if (((String) ZeusTransformUtils.preCheckCast(r3.get(0), String.class, "com.obric.aiagent.plugin")).charAt(0) == '!') goto L9;
        return null;
    L9:
        if (((String) ZeusTransformUtils.preCheckCast(r3.get(0), String.class, "com.obric.aiagent.plugin")).charAt(0) != '!') goto L11;
        int r4 = r2.size();
        int r5 = r3.size();
    L12:
        j r0 = p.y((Iterable) ZeusTransformUtils.preCheckCast(b(r18), Iterable.class, "com.obric.aiagent.plugin"));
        return m.a(m.b(r0, r4 - r5), (CharSequence) ZeusTransformUtils.preCheckCast(".", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null);
    L11:
        r4 = r2.size();
        r5 = r3.size() + 1;
        goto L12
    }

    private final List<String> b(String r7) {
        List<String> r8 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin"), new char[]{'.'}, false, 0, 6, null);
        if (o.a(p.m(r8), "") == true) goto L5;
        return r8;
    L5:
        return p.e(r8, 1);
    }

    private final List<String> a(List<String> r19) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.aiagent.plugin");
        if (this.f40159b.get() == false) goto L5;
    L74:
        this.f40160c.await();     // Catch: InterruptedException -> L9
    L11:
        if (this.f40161d == null) goto L13;
        boolean r3 = true;
    L14:
        if (r3 == false) goto L73;
        int r4 = r1.size();
        byte[][] r6 = new byte[r4][];
        int r7 = 0;
    L16:
        if (r7 >= r4) goto L18;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r1.get(r7), String.class, "com.obric.aiagent.plugin");
        Charset r9 = StandardCharsets.UTF_8;
        o.c(r9, "UTF_8");
        byte[] r10 = r8.getBytes(r9);
        o.c(r10, "this as java.lang.String).getBytes(charset)");
        r6[r7] = r10;
        r7 = r7 + 1;
        goto L16
    L18:
        int r2 = ((Object[]) ZeusTransformUtils.preCheckCast(r6, Object[].class, "com.obric.aiagent.plugin")).length;
        int r5 = 0;
    L19:
        String r11 = null;
        if (r5 >= r2) goto L28;
        a r12 = f40158a;
        byte[] r13 = this.f40161d;
        if (r13 != null) goto L24;
        o.c("publicSuffixListBytes");
        r13 = null;
    L24:
        String r14 = a.a(r12, r13, r6, r5);
        if (r14 != null) goto L30;
        r5 = r5 + 1;
    L30:
        if (((Object[]) ZeusTransformUtils.preCheckCast(r6, Object[].class, "com.obric.aiagent.plugin")).length <= 1) goto L40;
        byte[][] r15 = (byte[][]) ZeusTransformUtils.preCheckCast(((Object[]) ZeusTransformUtils.preCheckCast(r6, Object[].class, "com.obric.aiagent.plugin")).clone(), byte[][].class, "com.obric.aiagent.plugin");
        int r16 = ((Object[]) ZeusTransformUtils.preCheckCast(r15, Object[].class, "com.obric.aiagent.plugin")).length - 1;
        int r17 = 0;
    L32:
        if (r17 >= r16) goto L40;
        r15[r17] = f;
        a r18 = f40158a;
        byte[] r110 = this.f40161d;
        if (r110 != null) goto L36;
        o.c("publicSuffixListBytes");
        r110 = null;
    L36:
        String r111 = a.a(r18, r110, r15, r17);
        if (r111 != null) goto L41;
        r17 = r17 + 1;
    L41:
        if (r111 == null) goto L52;
        int r20 = ((Object[]) ZeusTransformUtils.preCheckCast(r6, Object[].class, "com.obric.aiagent.plugin")).length - 1;
        int r21 = 0;
    L43:
        if (r21 >= r20) goto L52;
        a r22 = f40158a;
        byte[] r112 = this.f40162e;
        if (r112 != null) goto L47;
        o.c("publicSuffixExceptionListBytes");
        r112 = null;
    L47:
        String r23 = a.a(r22, r112, r6, r21);
        if (r23 != null) goto L49;
        r21 = r21 + 1;
        goto L43
    L49:
        r11 = r23;
    L52:
        if (r11 != null) goto L54;
        if (r14 != null) goto L59;
        if (r111 != null) goto L59;
        return g;
    L59:
        if (r14 == null) goto L62;
        List<String> r24 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin"), new char[]{'.'}, false, 0, 6, null);
        if (r24 == null) goto L62;
    L63:
        if (r111 == null) goto L66;
        List<String> r0 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r111, CharSequence.class, "com.obric.aiagent.plugin"), new char[]{'.'}, false, 0, 6, null);
        if (r0 == null) goto L66;
    L68:
        if (r24.size() <= r0.size()) goto L71;
        return r24;
    L71:
        return r0;
    L66:
        r0 = p.b();
    L62:
        r24 = p.b();
        goto L63
    L54:
        return d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast('!' + r11, CharSequence.class, "com.obric.aiagent.plugin"), new char[]{'.'}, false, 0, 6, null);
    L40:
        r111 = null;
        goto L41
    L28:
        r14 = null;
        goto L30
    L73:
        throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.".toString());
    L13:
        r3 = false;
    L9:
        Thread.currentThread().interrupt();
        goto L11
    L5:
        if (this.f40159b.compareAndSet(false, true) == false) goto L74;
        b();
        goto L11
    }

    private final void b() {
        boolean r0 = false;
    L19:
        c();     // Catch: Throwable -> L7 IOException -> L9 InterruptedIOException -> L14
    L4:
        if (r0 == false) goto L23;
        Thread.currentThread().interrupt();
        return;
    L23:
        return;
    L7:
        th = move-exception;
        if (r0 == false) goto L18;
        Thread.currentThread().interrupt();
    L18:
        throw th;
    L14:
        Thread.interrupted();     // Catch: Throwable -> L7
        r0 = true;
    L9:
        e = move-exception;
        okhttp3.internal.i.h.f40147b.a().a("Failed to read public suffix list", 5, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L7
        if (r0 == false) goto L24;
        Thread.currentThread().interrupt();
        return;
    }

    /* JADX WARN: Type inference failed for: r5v5, types: [T, byte[]] */
    /* JADX WARN: Type inference failed for: r6v3, types: [T, byte[]] */
    private final void c() {
        z.f r1 = new z.f();     // Catch: Throwable -> L24
        z.f r2 = new z.f();     // Catch: Throwable -> L24
        InputStream r3 = PublicSuffixDatabase.class.getResourceAsStream("publicsuffixes.gz");     // Catch: Throwable -> L24
        if (r3 != null) goto L7;
        this.f40160c.countDown();
        return;
    L7:
        Closeable r4 = (Closeable) ZeusTransformUtils.preCheckCast(e.o.a((aa) ZeusTransformUtils.preCheckCast(new l(e.o.a(r3)), aa.class, "com.obric.aiagent.plugin")), Closeable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L24
        g r5 = (g) ZeusTransformUtils.preCheckCast(r4, g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        r1.f38504a = r5.g(r5.m());     // Catch: Throwable -> L19
        r2.f38504a = r5.g(r5.m());     // Catch: Throwable -> L19
        x r6 = x.f38692a;     // Catch: Throwable -> L19
        d.f.c.a(r4, null);     // Catch: Throwable -> L24
        monitor-enter(this);     // Catch: Throwable -> L24
        T r7 = r1.f38504a;     // Catch: Throwable -> L16
        o.a(r7);     // Catch: Throwable -> L16
        this.f40161d = (byte[]) ZeusTransformUtils.preCheckCast(r7, byte[].class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        T r8 = r2.f38504a;     // Catch: Throwable -> L16
        o.a(r8);     // Catch: Throwable -> L16
        this.f40162e = (byte[]) ZeusTransformUtils.preCheckCast(r8, byte[].class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        x r0 = x.f38692a;     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L24
        this.f40160c.countDown();
        return;
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        d.f.c.a(r4, th);     // Catch: Throwable -> L24
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        this.f40160c.countDown();
        throw th;
    }

    static {
        f40158a = new a(null);
        f = new byte[]{42};
        g = p.a("*");
        h = new PublicSuffixDatabase();
    }
}
