package okhttp3.internal.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.h.b.p;
import d.o.k;
import d.x;
import e.aa;
import e.g;
import e.j;
import e.y;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: DiskLruCache.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d implements Closeable, Flushable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f39805a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f39806b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f39807c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f39808d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f39809e = null;
    public static final String f = null;
    public static final long g = 0;
    public static final k h = null;
    public static final String i = null;
    public static final String j = null;
    public static final String k = null;
    public static final String l = null;
    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private long E;
    private final okhttp3.internal.c.c F;
    private final e G;
    private final okhttp3.internal.h.a m;
    private final File n;
    private final int o;
    private final int p;
    private long q;
    private final File r;
    private final File s;
    private final File t;
    private long u;
    private e.f v;
    private final LinkedHashMap<String, c> w;
    private int x;
    private boolean y;
    private boolean z;

    /* JADX INFO: compiled from: DiskLruCache.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: DiskLruCache.kt */
    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f39810a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final c f39811b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean[] f39812c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f39813d;

        /* JADX INFO: compiled from: DiskLruCache.kt */
        static final class a extends p implements d.h.a.b<IOException, x> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ d f39814a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ b f39815b;

            a(d r1, b r2) {
                this.f39814a = r1;
                this.f39815b = r2;
                super(1);
            }

            @Override // d.h.a.b
            public /* synthetic */ x invoke(IOException r3) {
                a((IOException) ZeusTransformUtils.preCheckCast(r3, IOException.class, "com.obric.aiagent.plugin"));
                return x.f38692a;
            }

            public final void a(IOException r2) {
                o.e(r2, "it");
                d r3 = this.f39814a;
                b r1 = this.f39815b;
                monitor-enter(r3);
                r1.c();     // Catch: Throwable -> L7
                x r4 = x.f38692a;     // Catch: Throwable -> L7
                monitor-exit(r3);
                return;
            L7:
                th = move-exception;
                throw th;
            }
        }

        public b(d r2, c r3) {
            o.e(r3, "entry");
            this.f39810a = r2;
            this.f39811b = r3;
            if (r3.e() == false) goto L5;
            boolean[] r4 = null;
        L6:
            this.f39812c = r4;
            return;
        L5:
            r4 = new boolean[r2.c()];
            goto L6
        }

        public final c a() {
            return this.f39811b;
        }

        public final boolean[] b() {
            return this.f39812c;
        }

        public final void c() {
            if (o.a(this.f39811b.g(), this) == true) goto L5;
            return;
        L5:
            if (d.a(this.f39810a) == false) goto L7;
            this.f39810a.a(this, false);
            return;
        L7:
            this.f39811b.b(true);
        }

        public final y a(int r5) {
            d r0 = this.f39810a;
            monitor-enter(r0);
        L24:
            th = move-exception;
            throw th;
        L5:
            if ((!this.f39813d) == false) goto L23;
            if (o.a(this.f39811b.g(), this) == true) goto L12;
            y r4 = e.o.a();     // Catch: Throwable -> L24
            monitor-exit(r0);
            return r4;
        L12:
            if (this.f39811b.e() == true) goto L28;
            boolean[] r1 = this.f39812c;     // Catch: Throwable -> L24
            o.a(r1);     // Catch: Throwable -> L24
            r1[r5] = true;     // Catch: Throwable -> L24
        L28:
            y r6 = (y) ZeusTransformUtils.preCheckCast(new okhttp3.internal.b.e(r0.a().b((File) ZeusTransformUtils.preCheckCast(this.f39811b.d().get(r5), File.class, "com.obric.aiagent.plugin")), (d.h.a.b) ZeusTransformUtils.preCheckCast(new a(r0, this), d.h.a.b.class, "com.obric.aiagent.plugin")), y.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L24
            monitor-exit(r0);
            return r6;
        L21:
            return e.o.a();
        L23:
            throw new IllegalStateException("Check failed.".toString());     // Catch: Throwable -> L24
        }

        public final void d() {
            d r0 = this.f39810a;
            monitor-enter(r0);
        L14:
            th = move-exception;
            throw th;
        L5:
            if ((!this.f39813d) == false) goto L13;
            if (o.a(this.f39811b.g(), this) == false) goto L9;
            r0.a(this, true);     // Catch: Throwable -> L14
        L9:
            this.f39813d = true;     // Catch: Throwable -> L14
            x r3 = x.f38692a;     // Catch: Throwable -> L14
            monitor-exit(r0);
            return;
        L13:
            throw new IllegalStateException("Check failed.".toString());     // Catch: Throwable -> L14
        }

        public final void e() {
            d r0 = this.f39810a;
            monitor-enter(r0);
        L14:
            th = move-exception;
            throw th;
        L5:
            if ((!this.f39813d) == false) goto L13;
            if (o.a(this.f39811b.g(), this) == false) goto L9;
            r0.a(this, false);     // Catch: Throwable -> L14
        L9:
            this.f39813d = true;     // Catch: Throwable -> L14
            x r3 = x.f38692a;     // Catch: Throwable -> L14
            monitor-exit(r0);
            return;
        L13:
            throw new IllegalStateException("Check failed.".toString());     // Catch: Throwable -> L14
        }
    }

    /* JADX INFO: compiled from: DiskLruCache.kt */
    public final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f39816a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f39817b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long[] f39818c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List<File> f39819d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final List<File> f39820e;
        private boolean f;
        private boolean g;
        private b h;
        private int i;
        private long j;

        /* JADX INFO: compiled from: DiskLruCache.kt */
        public static final class a extends j {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ d f39821a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ c f39822b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private boolean f39823c;

            a(aa r3, d r4, c r5) {
                aa r6 = (aa) ZeusTransformUtils.wrapperContextForParams(r3, aa.class, "com.obric.aiagent.plugin");
                this.f39821a = r4;
                this.f39822b = r5;
                super(r6);
            }

            @Override // e.j, e.aa, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                super.close();
                if (this.f39823c == true) goto L17;
                this.f39823c = true;
                d r0 = this.f39821a;
                c r2 = this.f39822b;
                monitor-enter(r0);
                r2.a(r2.h() - 1);     // Catch: Throwable -> L14
                if (r2.h() == 0) goto L9;
            L11:
                x r3 = x.f38692a;     // Catch: Throwable -> L14
                monitor-exit(r0);
                return;
            L9:
                if (r2.f() == false) goto L11;
                r0.a(r2);     // Catch: Throwable -> L14
            L14:
                th = move-exception;
                throw th;
            }
        }

        public c(d r8, String r9) {
            o.e(r9, "key");
            this.f39816a = r8;
            this.f39817b = r9;
            this.f39818c = new long[r8.c()];
            this.f39819d = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
            this.f39820e = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
            StringBuilder r10 = new StringBuilder(r9).append('.');
            int r0 = r10.length();
            int r11 = r8.c();
            int r1 = 0;
        L3:
            if (r1 >= r11) goto L5;
            r10.append(r1);
            ((Collection) ZeusTransformUtils.preCheckCast(this.f39819d, Collection.class, "com.obric.aiagent.plugin")).add(new File(this.f39816a.b(), r10.toString()));
            r10.append(".tmp");
            ((Collection) ZeusTransformUtils.preCheckCast(this.f39820e, Collection.class, "com.obric.aiagent.plugin")).add(new File(this.f39816a.b(), r10.toString()));
            r10.setLength(r0);
            r1 = r1 + 1;
            goto L3
        }

        public final String a() {
            return this.f39817b;
        }

        public final long[] b() {
            return this.f39818c;
        }

        public final List<File> c() {
            return this.f39819d;
        }

        public final List<File> d() {
            return this.f39820e;
        }

        public final void a(boolean r1) {
            this.f = r1;
        }

        public final boolean e() {
            return this.f;
        }

        public final void b(boolean r1) {
            this.g = r1;
        }

        public final boolean f() {
            return this.g;
        }

        public final void a(b r1) {
            this.h = r1;
        }

        public final b g() {
            return this.h;
        }

        public final void a(int r1) {
            this.i = r1;
        }

        public final int h() {
            return this.i;
        }

        public final void a(long r1) {
            this.j = r1;
        }

        public final long i() {
            return this.j;
        }

        public final void a(List<String> r7) {
            List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
            o.e(r8, "strings");
            if (r8.size() != this.f39816a.c()) goto L12;
            int r0 = 0;
            int r2 = r8.size();     // Catch: NumberFormatException -> L10
        L6:
            if (r0 >= r2) goto L9;
            this.f39818c[r0] = Long.parseLong((String) ZeusTransformUtils.preCheckCast(r8.get(r0), String.class, "com.obric.aiagent.plugin"));     // Catch: NumberFormatException -> L10
            r0 = r0 + 1;
            goto L6
        L9:
            return;
        L10:
            b(r8);
            throw new d.d();
        L12:
            b(r8);
            throw new d.d();
        }

        public final void a(e.f r6) {
            e.f r7 = (e.f) ZeusTransformUtils.wrapperContextForParams(r6, e.f.class, "com.obric.aiagent.plugin");
            o.e(r7, "writer");
            long[] r5 = this.f39818c;
            int r0 = r5.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            long r2 = r5[r1];
            r7.h(32).n(r2);
            r1 = r1 + 1;
            goto L3
        }

        private final Void b(List<String> r3) {
            throw new IOException("unexpected journal line: " + ((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin")));
        }

        public final C1074d j() {
            d r0 = this.f39816a;
            if (okhttp3.internal.c.f == false) goto L10;
            if (Thread.holdsLock(r0) == true) goto L10;
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + r0);
        L10:
            if (this.f == true) goto L13;
            return null;
        L13:
            if (d.a(this.f39816a) == false) goto L15;
        L19:
            List r1 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
            long[] r10 = (long[]) ZeusTransformUtils.preCheckCast(this.f39818c.clone(), long[].class, "com.obric.aiagent.plugin");
            int r2 = 0;
            int r4 = this.f39816a.c();     // Catch: FileNotFoundException -> L25
        L21:
            if (r2 >= r4) goto L23;
            ((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.aiagent.plugin")).add(b(r2));     // Catch: FileNotFoundException -> L25
            r2 = r2 + 1;     // Catch: FileNotFoundException -> L25
            goto L21
        L23:
            return new C1074d(this.f39816a, this.f39817b, this.j, r1, r10);
        L25:
            Iterator r3 = r1.iterator();
        L27:
            if (r3.hasNext() == false) goto L34;
            okhttp3.internal.c.a((Closeable) ZeusTransformUtils.preCheckCast((aa) ZeusTransformUtils.preCheckCast(r3.next(), aa.class, "com.obric.aiagent.plugin"), Closeable.class, "com.obric.aiagent.plugin"));
            goto L27
        L34:
            this.f39816a.a(this);     // Catch: IOException -> L31
        L30:
            return null;
        L15:
            if (this.h == null) goto L17;
        L18:
            return null;
        L17:
            if (this.g == false) goto L19;
            goto L18
        }

        private final aa b(int r4) {
            aa r5 = this.f39816a.a().a((File) ZeusTransformUtils.preCheckCast(this.f39819d.get(r4), File.class, "com.obric.aiagent.plugin"));
            if (d.a(this.f39816a) == false) goto L5;
            return r5;
        L5:
            this.i++;
            return (aa) ZeusTransformUtils.preCheckCast(new a(r5, this.f39816a, this), aa.class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: renamed from: okhttp3.internal.b.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DiskLruCache.kt */
    public final class C1074d implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f39824a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f39825b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f39826c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List<aa> f39827d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final long[] f39828e;

        public C1074d(d r3, String r4, long r5, List<? extends aa> r7, long[] r8) {
            List<aa> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
            o.e(r4, "key");
            o.e(r9, "sources");
            o.e(r8, "lengths");
            this.f39824a = r3;
            this.f39825b = r4;
            this.f39826c = r5;
            this.f39827d = r9;
            this.f39828e = r8;
        }

        public final b a() {
            return this.f39824a.a(this.f39825b, this.f39826c);
        }

        public final aa a(int r2) {
            return (aa) ZeusTransformUtils.preCheckCast(this.f39827d.get(r2), aa.class, "com.obric.aiagent.plugin");
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Iterator<aa> r3 = this.f39827d.iterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            okhttp3.internal.c.a((Closeable) ZeusTransformUtils.preCheckCast((aa) ZeusTransformUtils.preCheckCast(r3.next(), aa.class, "com.obric.aiagent.plugin"), Closeable.class, "com.obric.aiagent.plugin"));
            goto L4
        }
    }

    /* JADX INFO: compiled from: DiskLruCache.kt */
    public static final class e extends okhttp3.internal.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f39829a;

        @Override // okhttp3.internal.c.a
        public long a() {
            d r4 = this.f39829a;
            monitor-enter(r4);
        L22:
            th = move-exception;
            throw th;
        L5:
            if (d.b(r4) == true) goto L7;
        L20:
            monitor-exit(r4);
            return -1;
        L7:
            if (r4.d() == true) goto L20;
            r4.g();     // Catch: IOException -> L12 Throwable -> L22
        L27:
        L17:
            d.c(r4, true);     // Catch: Throwable -> L22
            d.a(r4, e.o.a(e.o.a()));     // Catch: Throwable -> L22
        L18:
            monitor-exit(r4);
            return -1;
        L14:
            if (d.c(r4) == false) goto L18;
            r4.f();     // Catch: IOException -> L17 Throwable -> L22
            d.a(r4, 0);     // Catch: IOException -> L17 Throwable -> L22
        L12:
            d.b(r4, true);     // Catch: Throwable -> L22
            goto L27
        }
    }

    /* JADX INFO: compiled from: DiskLruCache.kt */
    static final class f extends p implements d.h.a.b<IOException, x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f39830a;

        f(d r1) {
            this.f39830a = r1;
            super(1);
        }

        @Override // d.h.a.b
        public /* synthetic */ x invoke(IOException r3) {
            a((IOException) ZeusTransformUtils.preCheckCast(r3, IOException.class, "com.obric.aiagent.plugin"));
            return x.f38692a;
        }

        public final void a(IOException r3) {
            o.e(r3, "it");
            d r4 = this.f39830a;
            if (okhttp3.internal.c.f == true) goto L5;
        L9:
            d.a(this.f39830a, true);
            return;
        L5:
            if (Thread.holdsLock(r4) == true) goto L9;
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + r4);
        }
    }

    public static final /* synthetic */ void a(d r0, int r1) {
        r0.x = r1;
    }

    public static final /* synthetic */ void a(d r2, e.f r3) {
        r2.v = (e.f) ZeusTransformUtils.wrapperContextForParams(r3, e.f.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ void a(d r0, boolean r1) {
        r0.y = r1;
    }

    public static final /* synthetic */ boolean a(d r0) {
        return r0.z;
    }

    public static final /* synthetic */ void b(d r0, boolean r1) {
        r0.C = r1;
    }

    public static final /* synthetic */ boolean b(d r0) {
        return r0.A;
    }

    public static final /* synthetic */ void c(d r0, boolean r1) {
        r0.D = r1;
    }

    public static final /* synthetic */ boolean c(d r0) {
        return r0.k();
    }

    public final okhttp3.internal.h.a a() {
        return this.m;
    }

    public final File b() {
        return this.n;
    }

    public final int c() {
        return this.p;
    }

    public final boolean d() {
        return this.B;
    }

    private final void h() {
        Closeable r1 = (Closeable) ZeusTransformUtils.preCheckCast(e.o.a(this.m.a(this.r)), Closeable.class, "com.obric.aiagent.plugin");
        g r2 = (g) ZeusTransformUtils.preCheckCast(r1, g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L28
        String r4 = r2.v();     // Catch: Throwable -> L28
        String r5 = r2.v();     // Catch: Throwable -> L28
        String r6 = r2.v();     // Catch: Throwable -> L28
        String r7 = r2.v();     // Catch: Throwable -> L28
        String r8 = r2.v();     // Catch: Throwable -> L28
        if (o.a(f39809e, r4) == false) goto L27;
        if (o.a(f, r5) == false) goto L27;
        if (o.a(String.valueOf(this.o), r6) == false) goto L27;
        if (o.a(String.valueOf(this.p), r7) == false) goto L27;
        int r9 = 0;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L15;
        boolean r3 = true;
    L16:
        if (r3 == true) goto L27;
    L36:
        c(r2.v());     // Catch: EOFException -> L19 Throwable -> L28
        r9 = r9 + 1;
        goto L36
    L19:
        this.x = r9 - this.w.size();     // Catch: Throwable -> L28
        if (r2.h() == true) goto L22;
        f();     // Catch: Throwable -> L28
    L23:
        x r10 = x.f38692a;     // Catch: Throwable -> L28
        d.f.c.a(r1, null);
        return;
    L22:
        this.v = i();     // Catch: Throwable -> L28
        goto L23
    L15:
        r3 = false;
    L27:
        throw new IOException("unexpected journal header: [" + r4 + ", " + r5 + ", " + r7 + ", " + r8 + ']');     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        d.f.c.a(r1, th);
        throw th;
    }

    private final e.f i() {
        return e.o.a((y) ZeusTransformUtils.preCheckCast(new okhttp3.internal.b.e(this.m.c(this.r), (d.h.a.b) ZeusTransformUtils.preCheckCast(new f(this), d.h.a.b.class, "com.obric.aiagent.plugin")), y.class, "com.obric.aiagent.plugin"));
    }

    private final void c(String r14) {
        int r0 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin"), ' ', 0, false, 6, null);
        if (r0 == (-1)) goto L37;
        int r10 = r0 + 1;
        int r4 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin"), ' ', r10, false, 4, null);
        if (r4 != (-1)) goto L12;
        String r9 = r14.substring(r10);
        o.c(r9, "this as java.lang.String).substring(startIndex)");
        String r11 = k;
        if (r0 == r11.length()) goto L9;
    L13:
        c r12 = (c) ZeusTransformUtils.preCheckCast(this.w.get(r9), c.class, "com.obric.aiagent.plugin");
        if (r12 != null) goto L16;
        r12 = new c(this, r9);
        ((Map) ZeusTransformUtils.preCheckCast(this.w, Map.class, "com.obric.aiagent.plugin")).put(r9, r12);
    L16:
        if (r4 == (-1)) goto L22;
        String r13 = i;
        if (r0 != r13.length()) goto L22;
        if (d.o.o.b(r14, r13, false, 2, null) == false) goto L22;
        String r15 = r14.substring(r4 + 1);
        o.c(r15, "this as java.lang.String).substring(startIndex)");
        List<String> r16 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r15, CharSequence.class, "com.obric.aiagent.plugin"), new char[]{' '}, false, 0, 6, null);
        r12.a(true);
        r12.a(null);
        r12.a(r16);
        return;
    L22:
        if (r4 != (-1)) goto L28;
        String r1 = j;
        if (r0 != r1.length()) goto L28;
        if (d.o.o.b(r14, r1, false, 2, null) == false) goto L28;
        r12.a(new b(this, r12));
        return;
    L28:
        if (r4 != (-1)) goto L35;
        String r17 = l;
        if (r0 != r17.length()) goto L35;
        if (d.o.o.b(r14, r17, false, 2, null) == false) goto L35;
        return;
    L35:
        throw new IOException("unexpected journal line: " + r14);
    L9:
        if (d.o.o.b(r14, r11, false, 2, null) == false) goto L13;
        this.w.remove(r9);
        return;
    L12:
        r9 = r14.substring(r10, r4);
        o.c(r9, "this as java.lang.String…ing(startIndex, endIndex)");
        goto L13
    L37:
        throw new IOException("unexpected journal line: " + r14);
    }

    private final void j() {
        this.m.delete(this.s);
        Iterator<c> r0 = this.w.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L14;
        c r1 = r0.next();
        o.c(r1, "i.next()");
        c r2 = (c) ZeusTransformUtils.preCheckCast(r1, c.class, "com.obric.aiagent.plugin");
        int r4 = 0;
        if (r2.g() == null) goto L7;
        r2.a(null);
        int r3 = this.p;
    L11:
        if (r4 >= r3) goto L13;
        this.m.delete((File) ZeusTransformUtils.preCheckCast(r2.c().get(r4), File.class, "com.obric.aiagent.plugin"));
        this.m.delete((File) ZeusTransformUtils.preCheckCast(r2.d().get(r4), File.class, "com.obric.aiagent.plugin"));
        r4 = r4 + 1;
        goto L11
    L13:
        r0.remove();
        goto L4
    L7:
        int r5 = this.p;
    L8:
        if (r4 >= r5) goto L4;
        this.u += r2.b()[r4];
        r4 = r4 + 1;
        goto L8
    }

    public final synchronized void f() {
        monitor-enter(this);
        e.f r0 = this.v;     // Catch: Throwable -> L27
        if (r0 == null) goto L6;
        r0.close();     // Catch: Throwable -> L27
    L6:
        Closeable r1 = (Closeable) ZeusTransformUtils.preCheckCast(e.o.a(this.m.b(this.s)), Closeable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L27
        e.f r2 = (e.f) ZeusTransformUtils.preCheckCast(r1, e.f.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        r2.b(f39809e).h(10);     // Catch: Throwable -> L22
        r2.b(f).h(10);     // Catch: Throwable -> L22
        r2.n(this.o).h(10);     // Catch: Throwable -> L22
        r2.n(this.p).h(10);     // Catch: Throwable -> L22
        r2.h(10);     // Catch: Throwable -> L22
        Iterator<c> r3 = this.w.values().iterator();     // Catch: Throwable -> L22
    L10:
        if (r3.hasNext() == false) goto L15;
        c r5 = (c) ZeusTransformUtils.preCheckCast(r3.next(), c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        if (r5.g() != null) goto L13;
        r2.b(i).h(32);     // Catch: Throwable -> L22
        r2.b(r5.a());     // Catch: Throwable -> L22
        r5.a(r2);     // Catch: Throwable -> L22
        r2.h(10);     // Catch: Throwable -> L22
        goto L10
    L13:
        r2.b(j).h(32);     // Catch: Throwable -> L22
        r2.b(r5.a());     // Catch: Throwable -> L22
        r2.h(10);     // Catch: Throwable -> L22
        goto L10
    L15:
        x r4 = x.f38692a;     // Catch: Throwable -> L22
        d.f.c.a(r1, null);     // Catch: Throwable -> L27
        if (this.m.d(this.r) == false) goto L19;
        this.m.a(this.r, this.t);     // Catch: Throwable -> L27
    L19:
        this.m.a(this.s, this.r);     // Catch: Throwable -> L27
        this.m.delete(this.t);     // Catch: Throwable -> L27
        this.v = i();     // Catch: Throwable -> L27
        this.y = false;     // Catch: Throwable -> L27
        this.D = false;     // Catch: Throwable -> L27
        monitor-exit(this);
        return;
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        d.f.c.a(r1, th);     // Catch: Throwable -> L27
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    }

    public final synchronized C1074d a(String r8) {
        monitor-enter(this);
        o.e(r8, "key");     // Catch: Throwable -> L17
        e();     // Catch: Throwable -> L17
        l();     // Catch: Throwable -> L17
        d(r8);     // Catch: Throwable -> L17
        c r0 = (c) ZeusTransformUtils.preCheckCast(this.w.get(r8), c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L17
        if (r0 != null) goto L8;
        monitor-exit(this);
        return null;
    L8:
        C1074d r1 = r0.j();     // Catch: Throwable -> L17
        if (r1 != null) goto L12;
        monitor-exit(this);
        return null;
    L12:
        this.x++;     // Catch: Throwable -> L17
        e.f r2 = this.v;     // Catch: Throwable -> L17
        o.a(r2);     // Catch: Throwable -> L17
        r2.b(l).h(32).b(r8).h(10);     // Catch: Throwable -> L17
        if (k() == false) goto L15;
        okhttp3.internal.c.c.a(this.F, (okhttp3.internal.c.a) ZeusTransformUtils.preCheckCast(this.G, okhttp3.internal.c.a.class, "com.obric.aiagent.plugin"), 0, 2, null);     // Catch: Throwable -> L17
    L15:
        monitor-exit(this);
        return r1;
    L17:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ b a(d r0, String r1, long r2, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = g;
    L6:
        return r0.a(r1, r2);
    }

    public final synchronized b a(String r10, long r11) {
        monitor-enter(this);
        o.e(r10, "key");     // Catch: Throwable -> L40
        e();     // Catch: Throwable -> L40
        l();     // Catch: Throwable -> L40
        d(r10);     // Catch: Throwable -> L40
        c r0 = (c) ZeusTransformUtils.preCheckCast(this.w.get(r10), c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L40
        if (r11 == g) goto L11;
        if (r0 != null) goto L8;
    L9:
        monitor-exit(this);
        return null;
    L8:
        if (r0.i() != r11) goto L9;
    L11:
        if (r0 == null) goto L14;
        b r12 = r0.g();     // Catch: Throwable -> L40
    L15:
        if (r12 == null) goto L18;
        monitor-exit(this);
        return null;
    L18:
        if (r0 == null) goto L24;
        if (r0.h() == 0) goto L24;
        monitor-exit(this);
        return null;
    L24:
        if (this.C == false) goto L26;
    L37:
        okhttp3.internal.c.c.a(this.F, (okhttp3.internal.c.a) ZeusTransformUtils.preCheckCast(this.G, okhttp3.internal.c.a.class, "com.obric.aiagent.plugin"), 0, 2, null);     // Catch: Throwable -> L40
        monitor-exit(this);
        return null;
    L26:
        if (this.D == true) goto L37;
        e.f r13 = this.v;     // Catch: Throwable -> L40
        o.a(r13);     // Catch: Throwable -> L40
        r13.b(j).h(32).b(r10).h(10);     // Catch: Throwable -> L40
        r13.flush();     // Catch: Throwable -> L40
        if (this.y == false) goto L32;
        monitor-exit(this);
        return null;
    L32:
        if (r0 != null) goto L34;
        r0 = new c(this, r10);     // Catch: Throwable -> L40
        ((Map) ZeusTransformUtils.preCheckCast(this.w, Map.class, "com.obric.aiagent.plugin")).put(r10, r0);     // Catch: Throwable -> L40
    L34:
        b r14 = new b(this, r0);     // Catch: Throwable -> L40
        r0.a(r14);     // Catch: Throwable -> L40
        monitor-exit(this);
        return r14;
    L14:
        r12 = null;
    L40:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(b r9, boolean r10) {
        monitor-enter(this);
        o.e(r9, "editor");     // Catch: Throwable -> L54
        c r0 = r9.a();     // Catch: Throwable -> L54
        if (o.a(r0.g(), r9) == false) goto L53;
        int r1 = 0;
        if (r10 == true) goto L8;
    L21:
        int r11 = this.p;     // Catch: Throwable -> L54
    L22:
        if (r1 >= r11) goto L32;
        File r2 = (File) ZeusTransformUtils.preCheckCast(r0.d().get(r1), File.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L54
        if (r10 == true) goto L26;
    L30:
        this.m.delete(r2);     // Catch: Throwable -> L54
    L31:
        r1 = r1 + 1;     // Catch: Throwable -> L54
        goto L22
    L26:
        if (r0.f() == true) goto L30;
        if (this.m.d(r2) == false) goto L31;
        File r3 = (File) ZeusTransformUtils.preCheckCast(r0.c().get(r1), File.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L54
        this.m.a(r2, r3);     // Catch: Throwable -> L54
        long r4 = r0.b()[r1];     // Catch: Throwable -> L54
        long r5 = this.m.e(r3);     // Catch: Throwable -> L54
        r0.b()[r1] = r5;     // Catch: Throwable -> L54
        this.u = (this.u - r4) + r5;     // Catch: Throwable -> L54
        goto L31
    L32:
        r0.a(null);     // Catch: Throwable -> L54
        if (r0.f() == false) goto L37;
        a(r0);     // Catch: Throwable -> L54
        monitor-exit(this);
        return;
    L37:
        this.x++;     // Catch: Throwable -> L54
        e.f r12 = this.v;     // Catch: Throwable -> L54
        o.a(r12);     // Catch: Throwable -> L54
        if (r0.e() == true) goto L42;
        if (r10 == true) goto L42;
        this.w.remove(r0.a());     // Catch: Throwable -> L54
        r12.b(k).h(32);     // Catch: Throwable -> L54
        r12.b(r0.a());     // Catch: Throwable -> L54
        r12.h(10);     // Catch: Throwable -> L54
    L45:
        r12.flush();     // Catch: Throwable -> L54
        if (this.u <= this.q) goto L48;
    L49:
        okhttp3.internal.c.c.a(this.F, (okhttp3.internal.c.a) ZeusTransformUtils.preCheckCast(this.G, okhttp3.internal.c.a.class, "com.obric.aiagent.plugin"), 0, 2, null);     // Catch: Throwable -> L54
    L50:
        monitor-exit(this);
        return;
    L48:
        if (k() == false) goto L50;
    L42:
        r0.a(true);     // Catch: Throwable -> L54
        r12.b(i).h(32);     // Catch: Throwable -> L54
        r12.b(r0.a());     // Catch: Throwable -> L54
        r0.a(r12);     // Catch: Throwable -> L54
        r12.h(10);     // Catch: Throwable -> L54
        if (r10 == false) goto L45;
        long r6 = this.E;     // Catch: Throwable -> L54
        this.E = 1 + r6;     // Catch: Throwable -> L54
        r0.a(r6);     // Catch: Throwable -> L54
        goto L45
    L8:
        if (r0.e() == true) goto L21;
        int r7 = this.p;     // Catch: Throwable -> L54
        int r8 = 0;
    L10:
        if (r8 >= r7) goto L21;
        boolean[] r13 = r9.b();     // Catch: Throwable -> L54
        o.a(r13);     // Catch: Throwable -> L54
        if (r13[r8] == false) goto L19;
        if (this.m.d((File) ZeusTransformUtils.preCheckCast(r0.d().get(r8), File.class, "com.obric.aiagent.plugin")) == false) goto L15;
        r8 = r8 + 1;
        goto L10
    L15:
        r9.e();     // Catch: Throwable -> L54
        monitor-exit(this);
        return;
    L19:
        r9.e();     // Catch: Throwable -> L54
        throw new IllegalStateException("Newly created entry didn't create value for index " + r8);     // Catch: Throwable -> L54
    L53:
        throw new IllegalStateException("Check failed.".toString());     // Catch: Throwable -> L54
    L54:
        th = move-exception;
        throw th;
    }

    private final boolean k() {
        int r0 = this.x;
        if (r0 >= 2000) goto L5;
    L7:
        return false;
    L5:
        if (r0 < this.w.size()) goto L7;
        return true;
    }

    public final synchronized boolean b(String r6) {
        monitor-enter(this);
        o.e(r6, "key");     // Catch: Throwable -> L15
        e();     // Catch: Throwable -> L15
        l();     // Catch: Throwable -> L15
        d(r6);     // Catch: Throwable -> L15
        c r7 = (c) ZeusTransformUtils.preCheckCast(this.w.get(r6), c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L15
        if (r7 != null) goto L8;
        monitor-exit(this);
        return false;
    L8:
        boolean r8 = a(r7);     // Catch: Throwable -> L15
        if (r8 == true) goto L11;
    L13:
        monitor-exit(this);
        return r8;
    L11:
        if (this.u > this.q) goto L13;
        this.C = false;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public final boolean a(c r13) {
        o.e(r13, "entry");
        if (this.z == false) goto L5;
    L15:
        b r0 = r13.g();
        if (r0 == null) goto L18;
        r0.c();
    L18:
        int r1 = 0;
        int r4 = this.p;
    L20:
        if (r1 >= r4) goto L22;
        this.m.delete((File) ZeusTransformUtils.preCheckCast(r13.c().get(r1), File.class, "com.obric.aiagent.plugin"));
        this.u -= r13.b()[r1];
        r13.b()[r1] = 0;
        r1 = r1 + 1;
        goto L20
    L22:
        this.x++;
        e.f r2 = this.v;
        if (r2 == null) goto L25;
        r2.b(k);
        r2.h(32);
        r2.b(r13.a());
        r2.h(10);
    L25:
        this.w.remove(r13.a());
        if (k() == false) goto L28;
        okhttp3.internal.c.c.a(this.F, (okhttp3.internal.c.a) ZeusTransformUtils.preCheckCast(this.G, okhttp3.internal.c.a.class, "com.obric.aiagent.plugin"), 0, 2, null);
    L28:
        return true;
    L5:
        if (r13.h() <= 0) goto L10;
        e.f r3 = this.v;
        if (r3 == null) goto L10;
        r3.b(j);
        r3.h(32);
        r3.b(r13.a());
        r3.h(10);
        r3.flush();
    L10:
        if (r13.h() <= 0) goto L12;
    L13:
        r13.b(true);
        return true;
    L12:
        if (r13.g() == null) goto L15;
        goto L13
    }

    private final synchronized void l() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L5:
        if ((!this.B) == false) goto L9;
        monitor-exit(this);
        return;
    L9:
        throw new IllegalStateException("cache is closed".toString());     // Catch: Throwable -> L10
    }

    @Override // java.io.Flushable
    public synchronized void flush() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.A == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        l();     // Catch: Throwable -> L10
        g();     // Catch: Throwable -> L10
        e.f r0 = this.v;     // Catch: Throwable -> L10
        o.a(r0);     // Catch: Throwable -> L10
        r0.flush();     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L4:
        if (this.A == true) goto L6;
    L19:
        this.B = true;     // Catch: Throwable -> L22
        monitor-exit(this);
        return;
    L6:
        if (this.B == true) goto L19;
        Collection<c> r0 = this.w.values();     // Catch: Throwable -> L22
        o.c(r0, "lruEntries.values");     // Catch: Throwable -> L22
        int r2 = 0;
        c[] r1 = (c[]) ZeusTransformUtils.preCheckCast(r0.toArray(new c[0]), c[].class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22
        int r3 = r1.length;     // Catch: Throwable -> L22
    L9:
        if (r2 >= r3) goto L16;
        c r4 = r1[r2];     // Catch: Throwable -> L22
        if (r4.g() == null) goto L15;
        b r5 = r4.g();     // Catch: Throwable -> L22
        if (r5 == null) goto L15;
        r5.c();     // Catch: Throwable -> L22
    L15:
        r2 = r2 + 1;     // Catch: Throwable -> L22
        goto L9
    L16:
        g();     // Catch: Throwable -> L22
        e.f r6 = this.v;     // Catch: Throwable -> L22
        o.a(r6);     // Catch: Throwable -> L22
        r6.close();     // Catch: Throwable -> L22
        this.v = null;     // Catch: Throwable -> L22
        this.B = true;     // Catch: Throwable -> L22
        monitor-exit(this);
    }

    public final void g() {
    L3:
        if (this.u <= this.q) goto L7;
        if (m() == true) goto L3;
        return;
    L7:
        this.C = false;
    }

    private final boolean m() {
        Iterator<c> r0 = this.w.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        c r1 = (c) ZeusTransformUtils.preCheckCast(r0.next(), c.class, "com.obric.aiagent.plugin");
        if (r1.f() == true) goto L4;
        o.c(r1, "toEvict");
        a(r1);
        return true;
    L9:
        return false;
    }

    public final void delete() {
        close();
        this.m.f(this.n);
    }

    private final void d(String r3) {
        if (h.a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(("keys must match regex [a-z0-9_-]{1,120}: \"" + r3 + '\"').toString());
    }

    static {
        f39805a = new a(null);
        f39806b = "journal";
        f39807c = "journal.tmp";
        f39808d = "journal.bkp";
        f39809e = "libcore.io.DiskLruCache";
        f = "1";
        g = -1;
        h = new k("[a-z0-9_-]{1,120}");
        i = "CLEAN";
        j = "DIRTY";
        k = "REMOVE";
        l = "READ";
    }

    public final synchronized void e() {
        monitor-enter(this);
    L37:
        th = move-exception;
        throw th;
    L4:
        if (okhttp3.internal.c.f == false) goto L11;
        if (Thread.holdsLock(this) == true) goto L11;
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);     // Catch: Throwable -> L37
    L11:
        if (this.A == false) goto L15;
        monitor-exit(this);
        return;
    L15:
        if (this.m.d(this.t) == true) goto L17;
    L20:
        this.z = okhttp3.internal.c.a(this.m, this.t);     // Catch: Throwable -> L37
        if (this.m.d(this.r) == true) goto L43;
    L34:
        f();     // Catch: Throwable -> L37
        this.A = true;     // Catch: Throwable -> L37
        monitor-exit(this);
        return;
    L43:
        h();     // Catch: IOException -> L26 Throwable -> L37
        j();     // Catch: IOException -> L26 Throwable -> L37
        this.A = true;     // Catch: IOException -> L26 Throwable -> L37
        monitor-exit(this);
        return;
    L26:
        e = move-exception;
        okhttp3.internal.i.h.f40147b.a().a("DiskLruCache " + this.n + " is corrupt: " + e.getMessage() + ", removing", 5, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L37
        delete();     // Catch: Throwable -> L31
        this.B = false;     // Catch: Throwable -> L37
        goto L34
    L31:
        th = move-exception;
        this.B = false;     // Catch: Throwable -> L37
        throw th;     // Catch: Throwable -> L37
    L17:
        if (this.m.d(this.r) == false) goto L19;
        this.m.delete(this.t);     // Catch: Throwable -> L37
        goto L20
    L19:
        this.m.a(this.t, this.r);     // Catch: Throwable -> L37
        goto L20
    }
}
