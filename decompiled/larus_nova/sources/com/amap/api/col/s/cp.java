package com.amap.api.col.s;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.cache.disk.DefaultDiskStorage;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes28.dex */
public final class cp implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Pattern f26428a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Charset f26429b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final Charset f26430c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static ThreadPoolExecutor f26431d;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final ThreadFactory f26432r = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final OutputStream f26433t = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final File f26434e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final File f26435f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final File f26436g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final File f26437h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f26438i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f26439j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f26440k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f26441l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Writer f26442m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f26443n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final LinkedHashMap<String, c> f26444o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f26445p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f26446q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Callable<Void> f26447s;

    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ cp f26450a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final c f26451b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean[] f26452c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f26453d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f26454e;

        /* JADX INFO: renamed from: com.amap.api.col.s.cp$a$a, reason: collision with other inner class name */
        public class C0502a extends FilterOutputStream {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ a f26455a;

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                ((FilterOutputStream) this).out.close();     // Catch: IOException -> L4
                return;
            L4:
                a.c(this.f26455a);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public final void flush() {
                ((FilterOutputStream) this).out.flush();     // Catch: IOException -> L4
                return;
            L4:
                a.c(this.f26455a);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(int r100) {
                ((FilterOutputStream) this).out.write(r100);     // Catch: IOException -> L4
                return;
            L4:
                a.c(this.f26455a);
            }

            private C0502a(a r100, OutputStream r101) {
                this.f26455a = r100;
                super(r101);
            }

            public /* synthetic */ C0502a(a r100, OutputStream r101, byte r102) {
                this(r100, r101);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(byte[] r100, int r101, int r102) {
                ((FilterOutputStream) this).out.write(r100, r101, r102);     // Catch: IOException -> L4
                return;
            L4:
                a.c(this.f26455a);
            }
        }

        public final OutputStream a() throws IOException {
            if (cp.f(this.f26450a) <= 0) goto L28;
            cp r100 = this.f26450a;
            monitor-enter(r100);
        L24:
            th = move-exception;
            throw th;
        L7:
            if (c.b(this.f26451b) != this) goto L23;
            byte r101 = 0;
            if (c.e(this.f26451b) == true) goto L11;
            this.f26452c[0] = true;     // Catch: Throwable -> L24
        L11:
            File r102 = this.f26451b.b(0);     // Catch: Throwable -> L24
            PolarisFileOutputStreamWrapper r103 = new PolarisFileOutputStreamWrapper(r102);     // Catch: FileNotFoundException -> L14 Throwable -> L24
        L16:
            C0502a r104 = new C0502a(this, r103, r101);     // Catch: Throwable -> L24
            monitor-exit(r100);     // Catch: Throwable -> L24
            return r104;
        L14:
            cp.g(this.f26450a).mkdirs();     // Catch: Throwable -> L24
            r103 = new PolarisFileOutputStreamWrapper(r102);     // Catch: FileNotFoundException -> L19 Throwable -> L24
        L21:
            return cp.d();
        L23:
            throw new IllegalStateException();     // Catch: Throwable -> L24
        L28:
            throw new IllegalArgumentException("Expected index 0 to be greater than 0 and less than the maximum value count of " + cp.f(this.f26450a));
        }

        public final void b() throws IOException {
            if (this.f26453d == false) goto L5;
            cp.a(this.f26450a, this, false);
            this.f26450a.c(c.d(this.f26451b));
        L6:
            this.f26454e = true;
            return;
        L5:
            cp.a(this.f26450a, this, true);
            goto L6
        }

        public final void c() throws IOException {
            cp.a(this.f26450a, this, false);
        }

        public static /* synthetic */ c a(a r100) {
            return r100.f26451b;
        }

        public static /* synthetic */ boolean[] b(a r100) {
            return r100.f26452c;
        }

        public static /* synthetic */ boolean c(a r100) {
            r100.f26453d = true;
            return true;
        }

        private a(cp r100, c r101) {
            this.f26450a = r100;
            this.f26451b = r101;
            if (c.e(r101) == false) goto L5;
            boolean[] r102 = null;
        L6:
            this.f26452c = r102;
            return;
        L5:
            r102 = new boolean[cp.f(r100)];
            goto L6
        }

        public /* synthetic */ a(cp r100, c r101, byte r102) {
            this(r100, r101);
        }
    }

    public final class b implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ cp f26456a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f26457b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f26458c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final InputStream[] f26459d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final long[] f26460e;

        public final InputStream a() {
            return this.f26459d[0];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            InputStream[] r100 = this.f26459d;
            int r101 = r100.length;
            int r102 = 0;
        L3:
            if (r102 >= r101) goto L5;
            cp.a(r100[r102]);
            r102 = r102 + 1;
            goto L3
        }

        private b(cp r100, String r101, long r102, InputStream[] r103, long[] r104) {
            this.f26456a = r100;
            this.f26457b = r101;
            this.f26458c = r102;
            this.f26459d = r103;
            this.f26460e = r104;
        }

        public /* synthetic */ b(cp r100, String r101, long r102, InputStream[] r103, long[] r104, byte r105) {
            this(r100, r101, r102, r103, r104);
        }
    }

    public final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ cp f26461a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f26462b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long[] f26463c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f26464d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private a f26465e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f26466f;

        public final String a() throws IOException {
            StringBuilder r100 = new StringBuilder();
            long[] r101 = this.f26463c;
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L6;
            long r104 = r101[r103];
            r100.append(' ');
            r100.append(r104);
            r103 = r103 + 1;
            goto L3
        L6:
            return r100.toString();
        }

        public static /* synthetic */ long[] c(c r100) {
            return r100.f26463c;
        }

        public static /* synthetic */ String d(c r100) {
            return r100.f26462b;
        }

        public static /* synthetic */ boolean e(c r100) {
            return r100.f26464d;
        }

        public static /* synthetic */ long f(c r100) {
            return r100.f26466f;
        }

        public final File a(int r100) {
            return new PolarisFileWrapper(cp.g(this.f26461a), this.f26462b + "." + r100);
        }

        public final File b(int r100) {
            return new PolarisFileWrapper(cp.g(this.f26461a), this.f26462b + "." + r100 + DefaultDiskStorage.FileType.TEMP);
        }

        private static IOException a(String[] r100) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(r100));
        }

        public static /* synthetic */ a b(c r100) {
            return r100.f26465e;
        }

        public static /* synthetic */ boolean a(c r100) {
            r100.f26464d = true;
            return true;
        }

        private c(cp r100, String r101) {
            this.f26461a = r100;
            this.f26462b = r101;
            this.f26463c = new long[cp.f(r100)];
        }

        public static /* synthetic */ void a(c r100, String[] r101) throws IOException {
            if (r101.length != cp.f(r100.f26461a)) goto L13;
            int r102 = 0;
        L14:
            if (r102 >= r101.length) goto L9;
            r100.f26463c[r102] = CastLongProtector.parseLong(r101[r102]);     // Catch: NumberFormatException -> L10
            r102 = r102 + 1;
            goto L14
        L9:
            return;
        L11:
            throw a(r101);
        L13:
            throw a(r101);
        }

        public static /* synthetic */ long a(c r100, long r101) {
            r100.f26466f = r101;
            return r101;
        }

        public static /* synthetic */ a a(c r100, a r101) {
            r100.f26465e = r101;
            return r101;
        }

        public /* synthetic */ c(cp r100, String r101, byte r102) {
            this(r100, r101);
        }
    }

    private synchronized void h() throws IOException {
        monitor-enter(this);
        Writer r100 = this.f26442m;     // Catch: Throwable -> L24
        if (r100 == null) goto L6;
        r100.close();     // Catch: Throwable -> L24
    L6:
        BufferedWriter r101 = new BufferedWriter(new OutputStreamWriter(new PolarisFileOutputStreamWrapper(this.f26436g), f26429b));     // Catch: Throwable -> L24
        r101.write("libcore.io.DiskLruCache");     // Catch: Throwable -> L21
        r101.write("\n");     // Catch: Throwable -> L21
        r101.write("1");     // Catch: Throwable -> L21
        r101.write("\n");     // Catch: Throwable -> L21
        r101.write(Integer.toString(this.f26438i));     // Catch: Throwable -> L21
        r101.write("\n");     // Catch: Throwable -> L21
        r101.write(Integer.toString(this.f26440k));     // Catch: Throwable -> L21
        r101.write("\n");     // Catch: Throwable -> L21
        r101.write("\n");     // Catch: Throwable -> L21
        Iterator<c> r102 = this.f26444o.values().iterator();     // Catch: Throwable -> L21
    L8:
        if (r102.hasNext() == false) goto L15;
        c r103 = r102.next();     // Catch: Throwable -> L21
        if (c.b(r103) != null) goto L12;
        r101.write("CLEAN " + c.d(r103) + r103.a() + '\n');     // Catch: Throwable -> L21
        goto L8
    L12:
        r101.write("DIRTY " + c.d(r103) + '\n');     // Catch: Throwable -> L21
        goto L8
    L15:
        r101.close();     // Catch: Throwable -> L24
        if (this.f26435f.exists() == false) goto L18;
        a(this.f26435f, this.f26437h, true);     // Catch: Throwable -> L24
    L18:
        a(this.f26436g, this.f26435f, false);     // Catch: Throwable -> L24
        this.f26437h.delete();     // Catch: Throwable -> L24
        this.f26442m = new BufferedWriter(new OutputStreamWriter(new PolarisFileOutputStreamWrapper(this.f26435f, true), f26429b));     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L21:
        th = move-exception;
        r101.close();     // Catch: Throwable -> L24
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    public final synchronized void b() throws IOException {
        monitor-enter(this);
        j();     // Catch: Throwable -> L6
        k();     // Catch: Throwable -> L6
        this.f26442m.flush();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.f26442m != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        Iterator r100 = new ArrayList(this.f26444o.values()).iterator();     // Catch: Throwable -> L16
    L9:
        if (r100.hasNext() == false) goto L13;
        c r101 = (c) r100.next();     // Catch: Throwable -> L16
        if (c.b(r101) == null) goto L9;
        c.b(r101).c();     // Catch: Throwable -> L16
        goto L9
    L13:
        k();     // Catch: Throwable -> L16
        this.f26442m.close();     // Catch: Throwable -> L16
        this.f26442m = null;     // Catch: Throwable -> L16
        monitor-exit(this);
    }

    static {
        f26428a = PatternProtector.compile("[a-z0-9_-]{1,120}");
        f26429b = Charset.forName("US-ASCII");
        f26430c = Charset.forName("UTF-8");
        ThreadFactory r100 = new AnonymousClass1();
        f26432r = r100;
        f26431d = new PThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), r100);
        f26433t = new AnonymousClass3();
    }

    private static ThreadPoolExecutor e() {
        ThreadPoolExecutor r100 = f26431d;     // Catch: Throwable -> L8
        if (r100 != null) goto L5;
    L6:
        f26431d = new PThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(256), f26432r);     // Catch: Throwable -> L8
    L11:
        return f26431d;
    L5:
        if (r100.isShutdown() == false) goto L11;
    L8:
        th = move-exception;
        th.printStackTrace();
        goto L11
    }

    private void f() throws IOException {
        cq r100 = new cq(new PolarisFileInputStreamWrapper(this.f26435f), f26429b);
        String r101 = r100.a();     // Catch: Throwable -> L55
        String r102 = r100.a();     // Catch: Throwable -> L55
        String r103 = r100.a();     // Catch: Throwable -> L55
        String r104 = r100.a();     // Catch: Throwable -> L55
        String r105 = r100.a();     // Catch: Throwable -> L55
        if ("libcore.io.DiskLruCache".equals(r101) == false) goto L54;
        if ("1".equals(r102) == false) goto L54;
        if (Integer.toString(this.f26438i).equals(r103) == false) goto L54;
        if (Integer.toString(this.f26440k).equals(r104) == false) goto L54;
        if ("".equals(r105) == false) goto L54;
        byte r106 = 0;
        int r107 = 0;
    L59:
        String r108 = r100.a();     // Catch: EOFException -> L50 Throwable -> L55
        int r109 = r108.indexOf(32);     // Catch: EOFException -> L50 Throwable -> L55
        if (r109 == (-1)) goto L49;
        int r110 = r109 + 1;
        int r111 = r108.indexOf(32, r110);     // Catch: EOFException -> L50 Throwable -> L55
        if (r111 != (-1)) goto L25;
        String r112 = r108.substring(r110);     // Catch: EOFException -> L50 Throwable -> L55
        if (r109 == 6) goto L23;
    L26:
        c r113 = this.f26444o.get(r112);     // Catch: EOFException -> L50 Throwable -> L55
        if (r113 != null) goto L30;
        r113 = new c(this, r112, r106);     // Catch: EOFException -> L50 Throwable -> L55
        this.f26444o.put(r112, r113);     // Catch: EOFException -> L50 Throwable -> L55
    L30:
        if (r111 == (-1)) goto L35;
        if (r109 != 5) goto L35;
        if (r108.startsWith("CLEAN") == false) goto L35;
        String[] r114 = r108.substring(r111 + 1).split(" ");     // Catch: EOFException -> L50 Throwable -> L55
        c.a(r113);     // Catch: EOFException -> L50 Throwable -> L55
        c.a(r113, null);     // Catch: EOFException -> L50 Throwable -> L55
        c.a(r113, r114);     // Catch: EOFException -> L50 Throwable -> L55
    L45:
        r107 = r107 + 1;     // Catch: EOFException -> L50 Throwable -> L55
    L35:
        if (r111 != (-1)) goto L40;
        if (r109 != 5) goto L40;
        if (r108.startsWith("DIRTY") == false) goto L40;
        c.a(r113, new a(this, r113, r106));     // Catch: EOFException -> L50 Throwable -> L55
    L40:
        if (r111 != (-1)) goto L47;
        if (r109 != 4) goto L47;
        if (r108.startsWith("READ") == true) goto L45;
    L47:
        throw new IOException("unexpected journal line: ".concat(r108));     // Catch: EOFException -> L50 Throwable -> L55
    L23:
        if (r108.startsWith("REMOVE") == false) goto L26;
        this.f26444o.remove(r112);     // Catch: EOFException -> L50 Throwable -> L55
        goto L45
    L25:
        r112 = r108.substring(r110, r111);     // Catch: EOFException -> L50 Throwable -> L55
        goto L26
    L49:
        throw new IOException("unexpected journal line: ".concat(r108));     // Catch: EOFException -> L50 Throwable -> L55
    L50:
        this.f26445p = r107 - this.f26444o.size();     // Catch: Throwable -> L55
        a(r100);
        return;
    L54:
        throw new IOException("unexpected journal header: [" + r101 + ", " + r102 + ", " + r104 + ", " + r105 + "]");     // Catch: Throwable -> L55
    L55:
        th = move-exception;
        a(r100);
        throw th;
    }

    private void g() throws IOException {
        a(this.f26436g);
        Iterator<c> r100 = this.f26444o.values().iterator();
    L4:
        if (r100.hasNext() == false) goto L15;
        c r101 = r100.next();
        int r102 = 0;
        if (c.b(r101) == null) goto L8;
        c.a(r101, null);
    L12:
        if (r102 >= this.f26440k) goto L14;
        a(r101.a(r102));
        a(r101.b(r102));
        r102 = r102 + 1;
        goto L12
    L14:
        r100.remove();
    L8:
        if (r102 >= this.f26440k) goto L4;
        this.f26441l += c.c(r101)[r102];
        r102 = r102 + 1;
        goto L8
    }

    private boolean i() {
        int r100 = this.f26445p;
        if (r100 >= 2000) goto L5;
        return false;
    L5:
        if (r100 < this.f26444o.size()) goto L10;
        return true;
    L10:
        return false;
    }

    private void j() {
        if (this.f26442m == null) goto L6;
        return;
    L6:
        throw new IllegalStateException("cache is closed");
    }

    private void k() throws IOException {
    L3:
        if (this.f26441l > this.f26439j) goto L8;
        if (this.f26444o.size() > this.f26443n) goto L8;
        return;
    L8:
        c(this.f26444o.entrySet().iterator().next().getKey());
        goto L3
    }

    public final void c() throws IOException {
        close();
        b(this.f26434e);
    }

    public static /* synthetic */ OutputStream d() {
        return f26433t;
    }

    public final File a() {
        return this.f26434e;
    }

    private static void b(File r100) throws IOException {
        File[] r101 = r100.listFiles();
        if (r101 == null) goto L16;
        int r102 = r101.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L14;
        File r104 = r101[r103];
        if (r104.isDirectory() == false) goto L10;
        b(r104);
    L10:
        if (r104.delete() == false) goto L13;
        r103 = r103 + 1;
        goto L5
    L13:
        throw new IOException("failed to delete file: ".concat(String.valueOf(r104)));
    L14:
        return;
    L16:
        throw new IOException("not a readable directory: ".concat(String.valueOf(r100)));
    }

    private synchronized a d(String r100) throws IOException {
        monitor-enter(this);
        j();     // Catch: Throwable -> L14
        e(r100);     // Catch: Throwable -> L14
        c r101 = this.f26444o.get(r100);     // Catch: Throwable -> L14
        byte r102 = 0;
        if (r101 != null) goto L7;
        r101 = new c(this, r100, r102);     // Catch: Throwable -> L14
        this.f26444o.put(r100, r101);     // Catch: Throwable -> L14
    L11:
        a r103 = new a(this, r101, r102);     // Catch: Throwable -> L14
        c.a(r101, r103);     // Catch: Throwable -> L14
        this.f26442m.write("DIRTY " + r100 + '\n');     // Catch: Throwable -> L14
        this.f26442m.flush();     // Catch: Throwable -> L14
        monitor-exit(this);
        return r103;
    L7:
        if (c.b(r101) == null) goto L11;
        monitor-exit(this);
        return null;
    L14:
        th = move-exception;
        throw th;
    }

    private static void e(String r100) {
        if (f26428a.matcher(r100).matches() == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + r100 + "\"");
    }

    public static /* synthetic */ int f(cp r100) {
        return r100.f26440k;
    }

    public static /* synthetic */ File g(cp r100) {
        return r100.f26434e;
    }

    public final synchronized b a(String r110) throws IOException {
        monitor-enter(this);
        j();     // Catch: Throwable -> L32
        e(r110);     // Catch: Throwable -> L32
        c r100 = this.f26444o.get(r110);     // Catch: Throwable -> L32
        if (r100 != null) goto L9;
        monitor-exit(this);
        return null;
    L9:
        if (c.e(r100) == true) goto L12;
        monitor-exit(this);
        return null;
    L12:
        InputStream[] r101 = new InputStream[this.f26440k];     // Catch: Throwable -> L32
        int r102 = 0;
        int r103 = 0;
    L36:
        if (r103 >= this.f26440k) goto L18;
        r101[r103] = new PolarisFileInputStreamWrapper(r100.a(r103));     // Catch: FileNotFoundException -> L35 Throwable -> L32
        r103 = r103 + 1;
        goto L36
    L18:
        this.f26445p++;     // Catch: Throwable -> L32
        this.f26442m.append("READ " + r110 + '\n');     // Catch: Throwable -> L32
        if (i() == false) goto L21;
        e().submit(this.f26447s);     // Catch: Throwable -> L32
    L21:
        b r104 = new b(this, r110, c.f(r100), r101, c.c(r100), 0);     // Catch: Throwable -> L32
        monitor-exit(this);
        return r104;
    L25:
        if (r102 >= this.f26440k) goto L30;
        InputStream r111 = r101[r102];     // Catch: Throwable -> L32
        if (r111 == null) goto L30;
        a(r111);     // Catch: Throwable -> L32
        r102 = r102 + 1;
    L30:
        monitor-exit(this);
        return null;
    L32:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean c(String r100) throws IOException {
        monitor-enter(this);
        j();     // Catch: Throwable -> L25
        e(r100);     // Catch: Throwable -> L25
        c r101 = this.f26444o.get(r100);     // Catch: Throwable -> L25
        int r102 = 0;
        if (r101 != null) goto L6;
    L23:
        monitor-exit(this);
        return false;
    L6:
        if (c.b(r101) != null) goto L23;
    L9:
        if (r102 >= this.f26440k) goto L18;
        File r103 = r101.a(r102);     // Catch: Throwable -> L25
        if (r103.exists() == false) goto L17;
        if (r103.delete() == true) goto L17;
        throw new IOException("failed to delete ".concat(String.valueOf(r103)));     // Catch: Throwable -> L25
    L17:
        this.f26441l -= c.c(r101)[r102];     // Catch: Throwable -> L25
        c.c(r101)[r102] = 0;     // Catch: Throwable -> L25
        r102 = r102 + 1;     // Catch: Throwable -> L25
        goto L9
    L18:
        this.f26445p++;     // Catch: Throwable -> L25
        this.f26442m.append("REMOVE " + r100 + '\n');     // Catch: Throwable -> L25
        this.f26444o.remove(r100);     // Catch: Throwable -> L25
        if (i() == false) goto L21;
        e().submit(this.f26447s);     // Catch: Throwable -> L25
    L21:
        monitor-exit(this);
        return true;
    L25:
        th = move-exception;
        throw th;
    }

    private static void a(File r100) throws IOException {
        if (r100.exists() == true) goto L5;
        return;
    L5:
        if (r100.delete() == false) goto L8;
        return;
    L8:
        throw new IOException();
    }

    public static /* synthetic */ boolean c(cp r100) {
        return r100.i();
    }

    public static /* synthetic */ void d(cp r100) throws IOException {
        r100.h();
    }

    public static /* synthetic */ int e(cp r100) {
        r100.f26445p = 0;
        return 0;
    }

    public final a b(String r100) throws IOException {
        return d(r100);
    }

    public static /* synthetic */ void b(cp r100) throws IOException {
        r100.k();
    }

    public final void a(int r100) {
        if (r100 >= 10) goto L6;
        r100 = 10;
    L8:
        this.f26443n = r100;
        return;
    L6:
        if (r100 <= 10000) goto L8;
        r100 = 10000;
        goto L8
    }

    public static void a(Closeable r100) {
        if (r100 != null) goto L9;
        return;
    L9:
        r100.close();     // Catch: RuntimeException -> L5 Exception -> L8
        return;
    L5:
        e = move-exception;
        throw e;
    }

    public static /* synthetic */ Writer a(cp r100) {
        return r100.f26442m;
    }

    private cp(File r100, long r101) {
        this.f26441l = 0;
        this.f26443n = 1000;
        this.f26444o = new LinkedHashMap(0, 0.75f, true);
        this.f26446q = 0;
        this.f26447s = new AnonymousClass2(this);
        this.f26434e = r100;
        this.f26438i = 1;
        this.f26435f = new PolarisFileWrapper(r100, "journal");
        this.f26436g = new PolarisFileWrapper(r100, "journal.tmp");
        this.f26437h = new PolarisFileWrapper(r100, "journal.bkp");
        this.f26440k = 1;
        this.f26439j = r101;
    }

    private synchronized void a(a r110, boolean r111) throws IOException {
        monitor-enter(this);
        c r100 = a.a(r110);     // Catch: Throwable -> L46
        if (c.b(r100) != r110) goto L45;
        int r101 = 0;
        if (r111 == false) goto L23;
        if (c.e(r100) == true) goto L23;
        int r102 = 0;
    L11:
        if (r102 >= this.f26440k) goto L23;
        if (a.b(r110)[r102] == false) goto L20;
        if (r100.b(r102).exists() == false) goto L16;
        r102 = r102 + 1;
        goto L11
    L16:
        r110.c();     // Catch: Throwable -> L46
        monitor-exit(this);
        return;
    L20:
        r110.c();     // Catch: Throwable -> L46
        throw new IllegalStateException("Newly created entry didn't create value for index ".concat(String.valueOf(r102)));     // Catch: Throwable -> L46
    L23:
        if (r101 >= this.f26440k) goto L31;
        File r112 = r100.b(r101);     // Catch: Throwable -> L46
        if (r111 == true) goto L27;
        a(r112);     // Catch: Throwable -> L46
    L30:
        r101 = r101 + 1;     // Catch: Throwable -> L46
        goto L23
    L27:
        if (r112.exists() == false) goto L30;
        File r103 = r100.a(r101);     // Catch: Throwable -> L46
        r112.renameTo(r103);     // Catch: Throwable -> L46
        long r104 = c.c(r100)[r101];     // Catch: Throwable -> L46
        long r105 = r103.length();     // Catch: Throwable -> L46
        c.c(r100)[r101] = r105;     // Catch: Throwable -> L46
        this.f26441l = (this.f26441l - r104) + r105;     // Catch: Throwable -> L46
        goto L30
    L31:
        this.f26445p++;     // Catch: Throwable -> L46
        c.a(r100, null);     // Catch: Throwable -> L46
        if ((c.e(r100) | r111) == false) goto L36;
        c.a(r100);     // Catch: Throwable -> L46
        this.f26442m.write("CLEAN " + c.d(r100) + r100.a() + '\n');     // Catch: Throwable -> L46
        if (r111 == false) goto L37;
        long r113 = this.f26446q;     // Catch: Throwable -> L46
        this.f26446q = 1 + r113;     // Catch: Throwable -> L46
        c.a(r100, r113);     // Catch: Throwable -> L46
    L37:
        this.f26442m.flush();     // Catch: Throwable -> L46
        if (this.f26441l <= this.f26439j) goto L40;
    L41:
        e().submit(this.f26447s);     // Catch: Throwable -> L46
    L42:
        monitor-exit(this);
        return;
    L40:
        if (i() == false) goto L42;
    L36:
        this.f26444o.remove(c.d(r100));     // Catch: Throwable -> L46
        this.f26442m.write("REMOVE " + c.d(r100) + '\n');     // Catch: Throwable -> L46
        goto L37
    L45:
        throw new IllegalStateException();     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        throw th;
    }

    public static cp a(File r100, long r101) throws IOException {
        if (r101 <= 0) goto L18;
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100, "journal.bkp");
        if (r102.exists() == false) goto L10;
        PolarisFileWrapper r103 = new PolarisFileWrapper(r100, "journal");
        if (r103.exists() == false) goto L9;
        r102.delete();
        goto L10
    L9:
        a(r102, r103, false);
    L10:
        cp r104 = new cp(r100, r101);
        if (r104.f26435f.exists() == true) goto L19;
    L15:
        r100.mkdirs();
        cp r105 = new cp(r100, r101);
        r105.h();
        return r105;
    L19:
        r104.f();     // Catch: Throwable -> L14
        r104.g();     // Catch: Throwable -> L14
        r104.f26442m = new BufferedWriter(new OutputStreamWriter(new PolarisFileOutputStreamWrapper(r104.f26435f, true), f26429b));     // Catch: Throwable -> L14
        return r104;
    L14:
        r104.c();
        goto L15
    L18:
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private static void a(File r100, File r101, boolean r102) throws IOException {
        if (r102 == false) goto L5;
        a(r101);
    L5:
        if (r100.renameTo(r101) == false) goto L8;
        return;
    L8:
        throw new IOException();
    }

    public static /* synthetic */ void a(cp r100, a r101, boolean r102) throws IOException {
        r100.a(r101, r102);
    }
}
