package com.amap.api.mapcore.util;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.cache.disk.DefaultDiskStorage;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
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
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes28.dex */
public final class o7 implements Closeable {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    static final Pattern f27768o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Charset f27769p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final ThreadFactory f27770q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    static ThreadPoolExecutor f27771r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final OutputStream f27772s = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final File f27773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f27774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final File f27775c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final File f27776d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f27777e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f27778f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f27779g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f27780h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Writer f27781i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f27782j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final LinkedHashMap<String, f> f27783k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f27784l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f27785m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Callable<Void> f27786n;

    public static class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AtomicInteger f27787a;

        public a() {
            this.f27787a = new AtomicInteger(1);
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r100) {
            return new PthreadThreadV2(r100, "disklrucache#" + this.f27787a.getAndIncrement());
        }
    }

    public class b implements Callable<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ o7 f27788a;

        @Override // java.util.concurrent.Callable
        public final Void call() throws Exception {
            o7 r100 = this.f27788a;
            monitor-enter(r100);
        L14:
            th = move-exception;
            throw th;
        L5:
            if (o7.a(this.f27788a) != null) goto L8;
            monitor-exit(r100);     // Catch: Throwable -> L14
            return null;
        L8:
            o7.b(this.f27788a);     // Catch: Throwable -> L14
            if (o7.c(this.f27788a) == false) goto L11;
            o7.d(this.f27788a);     // Catch: Throwable -> L14
            o7.e(this.f27788a);     // Catch: Throwable -> L14
        L11:
            monitor-exit(r100);     // Catch: Throwable -> L14
            return null;
        }

        public b(o7 r100) {
            this.f27788a = r100;
        }
    }

    public static class c extends OutputStream {
        @Override // java.io.OutputStream
        public final void write(int r100) throws IOException {
        }

        public c() {
        }
    }

    public final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final f f27789a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean[] f27790b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f27791c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ o7 f27792d;

        public class a extends FilterOutputStream {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ d f27793a;

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                ((FilterOutputStream) this).out.close();     // Catch: IOException -> L4
                return;
            L4:
                d.c(this.f27793a);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public final void flush() {
                ((FilterOutputStream) this).out.flush();     // Catch: IOException -> L4
                return;
            L4:
                d.c(this.f27793a);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(int r100) {
                ((FilterOutputStream) this).out.write(r100);     // Catch: IOException -> L4
                return;
            L4:
                d.c(this.f27793a);
            }

            private a(d r100, OutputStream r101) {
                this.f27793a = r100;
                super(r101);
            }

            public /* synthetic */ a(d r100, OutputStream r101, byte r102) {
                this(r100, r101);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(byte[] r100, int r101, int r102) {
                ((FilterOutputStream) this).out.write(r100, r101, r102);     // Catch: IOException -> L4
                return;
            L4:
                d.c(this.f27793a);
            }
        }

        public final void a() throws IOException {
            o7.a(this.f27792d, this, false);
        }

        public final void b() throws IOException {
            if (this.f27791c == false) goto L5;
            o7.a(this.f27792d, this, false);
            this.f27792d.d(f.d(this.f27789a));
            return;
        L5:
            o7.a(this.f27792d, this, true);
        }

        public static /* synthetic */ boolean[] b(d r100) {
            return r100.f27790b;
        }

        public static /* synthetic */ boolean c(d r100) {
            r100.f27791c = true;
            return true;
        }

        public final OutputStream a(int r100) throws IOException {
            if (r100 < 0) goto L29;
            if (r100 >= o7.f(this.f27792d)) goto L29;
            o7 r101 = this.f27792d;
            monitor-enter(r101);
        L25:
            th = move-exception;
            throw th;
        L8:
            if (f.b(this.f27789a) != this) goto L24;
            if (f.e(this.f27789a) == true) goto L12;
            this.f27790b[r100] = true;     // Catch: Throwable -> L25
        L12:
            File r102 = this.f27789a.b(r100);     // Catch: Throwable -> L25
            PolarisFileOutputStreamWrapper r103 = new PolarisFileOutputStreamWrapper(r102);     // Catch: FileNotFoundException -> L15 Throwable -> L25
        L17:
            a r104 = new a(this, r103, 0);     // Catch: Throwable -> L25
            monitor-exit(r101);     // Catch: Throwable -> L25
            return r104;
        L15:
            o7.g(this.f27792d).mkdirs();     // Catch: Throwable -> L25
            r103 = new PolarisFileOutputStreamWrapper(r102);     // Catch: FileNotFoundException -> L20 Throwable -> L25
        L22:
            return o7.a();
        L24:
            throw new IllegalStateException();     // Catch: Throwable -> L25
        L29:
            throw new IllegalArgumentException("Expected index " + r100 + " to be greater than 0 and less than the maximum value count of " + o7.f(this.f27792d));
        }

        public static /* synthetic */ f a(d r100) {
            return r100.f27789a;
        }

        private d(o7 r100, f r101) {
            this.f27792d = r100;
            this.f27789a = r101;
            if (f.e(r101) == false) goto L5;
            boolean[] r102 = null;
        L6:
            this.f27790b = r102;
            return;
        L5:
            r102 = new boolean[o7.f(r100)];
            goto L6
        }

        public /* synthetic */ d(o7 r100, f r101, byte r102) {
            this(r100, r101);
        }
    }

    public final class e implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final InputStream[] f27794a;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            InputStream[] r100 = this.f27794a;
            int r101 = r100.length;
            int r102 = 0;
        L3:
            if (r102 >= r101) goto L5;
            o7.a(r100[r102]);
            r102 = r102 + 1;
            goto L3
        }

        public final InputStream a(int r100) {
            return this.f27794a[r100];
        }

        private e(o7 r100, String r101, long r102, InputStream[] r103, long[] r104) {
            this.f27794a = r103;
        }

        public /* synthetic */ e(o7 r100, String r101, long r102, InputStream[] r103, long[] r104, byte r105) {
            this(r100, r101, r102, r103, r104);
        }
    }

    public final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f27795a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long[] f27796b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f27797c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private d f27798d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f27799e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ o7 f27800f;

        public final String a() throws IOException {
            StringBuilder r100 = new StringBuilder();
            long[] r101 = this.f27796b;
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

        public static /* synthetic */ long[] c(f r100) {
            return r100.f27796b;
        }

        public static /* synthetic */ String d(f r100) {
            return r100.f27795a;
        }

        public static /* synthetic */ boolean e(f r100) {
            return r100.f27797c;
        }

        public static /* synthetic */ long f(f r100) {
            return r100.f27799e;
        }

        public final File a(int r100) {
            return new PolarisFileWrapper(o7.g(this.f27800f), this.f27795a + "." + r100);
        }

        public final File b(int r100) {
            return new PolarisFileWrapper(o7.g(this.f27800f), this.f27795a + "." + r100 + DefaultDiskStorage.FileType.TEMP);
        }

        public static /* synthetic */ boolean a(f r100) {
            r100.f27797c = true;
            return true;
        }

        public static /* synthetic */ d b(f r100) {
            return r100.f27798d;
        }

        private f(o7 r100, String r101) {
            this.f27800f = r100;
            this.f27795a = r101;
            this.f27796b = new long[o7.f(r100)];
        }

        public static void a(f r100, String[] r101) throws IOException {
            if (r101.length != o7.f(r100.f27800f)) goto L13;
            int r102 = 0;
        L14:
            if (r102 >= r101.length) goto L9;
            r100.f27796b[r102] = CastLongProtector.parseLong(r101[r102]);     // Catch: NumberFormatException -> L10
            r102 = r102 + 1;
            goto L14
        L9:
            return;
        L11:
            throw new IOException("unexpected journal line: " + Arrays.toString(r101));
        L13:
            throw new IOException("unexpected journal line: " + Arrays.toString(r101));
        }

        public static /* synthetic */ long a(f r100, long r101) {
            r100.f27799e = r101;
            return r101;
        }

        public static /* synthetic */ d a(f r100, d r101) {
            r100.f27798d = r101;
            return r101;
        }

        public /* synthetic */ f(o7 r100, String r101, byte r102) {
            this(r100, r101);
        }
    }

    private synchronized void e() throws IOException {
        monitor-enter(this);
        Writer r100 = this.f27781i;     // Catch: Throwable -> L24
        if (r100 == null) goto L6;
        r100.close();     // Catch: Throwable -> L24
    L6:
        BufferedWriter r101 = new BufferedWriter(new OutputStreamWriter(new PolarisFileOutputStreamWrapper(this.f27775c), f27769p));     // Catch: Throwable -> L24
        r101.write("libcore.io.DiskLruCache");     // Catch: Throwable -> L21
        r101.write("\n");     // Catch: Throwable -> L21
        r101.write("1");     // Catch: Throwable -> L21
        r101.write("\n");     // Catch: Throwable -> L21
        r101.write(Integer.toString(this.f27777e));     // Catch: Throwable -> L21
        r101.write("\n");     // Catch: Throwable -> L21
        r101.write(Integer.toString(this.f27779g));     // Catch: Throwable -> L21
        r101.write("\n");     // Catch: Throwable -> L21
        r101.write("\n");     // Catch: Throwable -> L21
        Iterator<f> r102 = this.f27783k.values().iterator();     // Catch: Throwable -> L21
    L8:
        if (r102.hasNext() == false) goto L15;
        f r103 = r102.next();     // Catch: Throwable -> L21
        if (f.b(r103) != null) goto L12;
        r101.write("CLEAN " + f.d(r103) + r103.a() + '\n');     // Catch: Throwable -> L21
        goto L8
    L12:
        r101.write("DIRTY " + f.d(r103) + '\n');     // Catch: Throwable -> L21
        goto L8
    L15:
        r101.close();     // Catch: Throwable -> L24
        if (this.f27774b.exists() == false) goto L18;
        a(this.f27774b, this.f27776d, true);     // Catch: Throwable -> L24
    L18:
        a(this.f27775c, this.f27774b, false);     // Catch: Throwable -> L24
        this.f27776d.delete();     // Catch: Throwable -> L24
        this.f27781i = new BufferedWriter(new OutputStreamWriter(new PolarisFileOutputStreamWrapper(this.f27774b, true), f27769p));     // Catch: Throwable -> L24
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

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.f27781i != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        Iterator r100 = new ArrayList(this.f27783k.values()).iterator();     // Catch: Throwable -> L16
    L9:
        if (r100.hasNext() == false) goto L13;
        f r101 = (f) r100.next();     // Catch: Throwable -> L16
        if (f.b(r101) == null) goto L9;
        f.b(r101).a();     // Catch: Throwable -> L16
        goto L9
    L13:
        j();     // Catch: Throwable -> L16
        this.f27781i.close();     // Catch: Throwable -> L16
        this.f27781i = null;     // Catch: Throwable -> L16
        monitor-exit(this);
    }

    public final synchronized void i() throws IOException {
        monitor-enter(this);
        h();     // Catch: Throwable -> L6
        j();     // Catch: Throwable -> L6
        this.f27781i.flush();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    static {
        f27768o = PatternProtector.compile("[a-z0-9_-]{1,120}");
        f27769p = Charset.forName("US-ASCII");
        Charset.forName("UTF-8");
        a r100 = new a();
        f27770q = r100;
        f27771r = new PThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), r100);
        f27772s = new c();
    }

    private void b() throws IOException {
        p7 r100 = new p7(new PolarisFileInputStreamWrapper(this.f27774b), f27769p);
        String r101 = r100.a();     // Catch: Throwable -> L55
        String r102 = r100.a();     // Catch: Throwable -> L55
        String r103 = r100.a();     // Catch: Throwable -> L55
        String r104 = r100.a();     // Catch: Throwable -> L55
        String r105 = r100.a();     // Catch: Throwable -> L55
        if ("libcore.io.DiskLruCache".equals(r101) == false) goto L54;
        if ("1".equals(r102) == false) goto L54;
        if (Integer.toString(this.f27777e).equals(r103) == false) goto L54;
        if (Integer.toString(this.f27779g).equals(r104) == false) goto L54;
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
        f r113 = this.f27783k.get(r112);     // Catch: EOFException -> L50 Throwable -> L55
        if (r113 != null) goto L30;
        r113 = new f(this, r112, r106);     // Catch: EOFException -> L50 Throwable -> L55
        this.f27783k.put(r112, r113);     // Catch: EOFException -> L50 Throwable -> L55
    L30:
        if (r111 == (-1)) goto L35;
        if (r109 != 5) goto L35;
        if (r108.startsWith("CLEAN") == false) goto L35;
        String[] r114 = r108.substring(r111 + 1).split(" ");     // Catch: EOFException -> L50 Throwable -> L55
        f.a(r113);     // Catch: EOFException -> L50 Throwable -> L55
        f.a(r113, null);     // Catch: EOFException -> L50 Throwable -> L55
        f.a(r113, r114);     // Catch: EOFException -> L50 Throwable -> L55
    L45:
        r107 = r107 + 1;     // Catch: EOFException -> L50 Throwable -> L55
    L35:
        if (r111 != (-1)) goto L40;
        if (r109 != 5) goto L40;
        if (r108.startsWith("DIRTY") == false) goto L40;
        f.a(r113, new d(this, r113, r106));     // Catch: EOFException -> L50 Throwable -> L55
    L40:
        if (r111 != (-1)) goto L47;
        if (r109 != 4) goto L47;
        if (r108.startsWith("READ") == true) goto L45;
    L47:
        throw new IOException("unexpected journal line: ".concat(r108));     // Catch: EOFException -> L50 Throwable -> L55
    L23:
        if (r108.startsWith("REMOVE") == false) goto L26;
        this.f27783k.remove(r112);     // Catch: EOFException -> L50 Throwable -> L55
        goto L45
    L25:
        r112 = r108.substring(r110, r111);     // Catch: EOFException -> L50 Throwable -> L55
        goto L26
    L49:
        throw new IOException("unexpected journal line: ".concat(r108));     // Catch: EOFException -> L50 Throwable -> L55
    L50:
        this.f27784l = r107 - this.f27783k.size();     // Catch: Throwable -> L55
        a(r100);
        return;
    L54:
        throw new IOException("unexpected journal header: [" + r101 + ", " + r102 + ", " + r104 + ", " + r105 + "]");     // Catch: Throwable -> L55
    L55:
        th = move-exception;
        a(r100);
        throw th;
    }

    private void c() throws IOException {
        a(this.f27775c);
        Iterator<f> r100 = this.f27783k.values().iterator();
    L4:
        if (r100.hasNext() == false) goto L15;
        f r101 = r100.next();
        int r102 = 0;
        if (f.b(r101) == null) goto L8;
        f.a(r101, null);
    L12:
        if (r102 >= this.f27779g) goto L14;
        a(r101.a(r102));
        a(r101.b(r102));
        r102 = r102 + 1;
        goto L12
    L14:
        r100.remove();
    L8:
        if (r102 >= this.f27779g) goto L4;
        this.f27780h += f.c(r101)[r102];
        r102 = r102 + 1;
        goto L8
    }

    public static void d() {
        ThreadPoolExecutor r100 = f27771r;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isShutdown() == true) goto L9;
        f27771r.shutdown();
        return;
    }

    private boolean g() {
        int r100 = this.f27784l;
        if (r100 >= 2000) goto L5;
        return false;
    L5:
        if (r100 < this.f27783k.size()) goto L10;
        return true;
    L10:
        return false;
    }

    private void h() {
        if (this.f27781i == null) goto L6;
        return;
    L6:
        throw new IllegalStateException("cache is closed");
    }

    private void j() throws IOException {
    L3:
        if (this.f27780h > this.f27778f) goto L8;
        if (this.f27783k.size() > this.f27782j) goto L8;
        return;
    L8:
        d(this.f27783k.entrySet().iterator().next().getKey());
        goto L3
    }

    public static ThreadPoolExecutor l() {
        ThreadPoolExecutor r100 = f27771r;     // Catch: Throwable -> L8
        if (r100 != null) goto L5;
    L6:
        f27771r = new PThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(256), f27770q);     // Catch: Throwable -> L8
    L11:
        return f27771r;
    L5:
        if (r100.isShutdown() == false) goto L11;
    L8:
        th = move-exception;
        th.printStackTrace();
        goto L11
    }

    public final void f() throws IOException {
        close();
        b(this.f27773a);
    }

    public static /* synthetic */ OutputStream a() {
        return f27772s;
    }

    public final File k() {
        return this.f27773a;
    }

    private static void a(String r100) {
        if (f27768o.matcher(r100).matches() == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + r100 + "\"");
    }

    public static /* synthetic */ int e(o7 r100) {
        r100.f27784l = 0;
        return 0;
    }

    public static /* synthetic */ int f(o7 r100) {
        return r100.f27779g;
    }

    public static /* synthetic */ File g(o7 r100) {
        return r100.f27773a;
    }

    public final d b(String r100) throws IOException {
        monitor-enter(this);
        h();     // Catch: Throwable -> L14
        a(r100);     // Catch: Throwable -> L14
        f r101 = this.f27783k.get(r100);     // Catch: Throwable -> L14
        byte r102 = 0;
        if (r101 != null) goto L7;
        r101 = new f(this, r100, r102);     // Catch: Throwable -> L14
        this.f27783k.put(r100, r101);     // Catch: Throwable -> L14
    L10:
        d r103 = new d(this, r101, r102);     // Catch: Throwable -> L14
        f.a(r101, r103);     // Catch: Throwable -> L14
        this.f27781i.write("DIRTY " + r100 + '\n');     // Catch: Throwable -> L14
        this.f27781i.flush();     // Catch: Throwable -> L14
        monitor-exit(this);
        return r103;
    L7:
        if (f.b(r101) == null) goto L10;
        monitor-exit(this);
        return null;
    L14:
        th = move-exception;
        throw th;
    }

    public final synchronized e c(String r110) throws IOException {
        monitor-enter(this);
        h();     // Catch: Throwable -> L32
        a(r110);     // Catch: Throwable -> L32
        f r100 = this.f27783k.get(r110);     // Catch: Throwable -> L32
        if (r100 != null) goto L9;
        monitor-exit(this);
        return null;
    L9:
        if (f.e(r100) == true) goto L12;
        monitor-exit(this);
        return null;
    L12:
        InputStream[] r101 = new InputStream[this.f27779g];     // Catch: Throwable -> L32
        int r102 = 0;
        int r103 = 0;
    L36:
        if (r103 >= this.f27779g) goto L18;
        r101[r103] = new PolarisFileInputStreamWrapper(r100.a(r103));     // Catch: FileNotFoundException -> L35 Throwable -> L32
        r103 = r103 + 1;
        goto L36
    L18:
        this.f27784l++;     // Catch: Throwable -> L32
        this.f27781i.append("READ " + r110 + '\n');     // Catch: Throwable -> L32
        if (g() == false) goto L21;
        l().submit(this.f27786n);     // Catch: Throwable -> L32
    L21:
        e r104 = new e(this, r110, f.f(r100), r101, f.c(r100), 0);     // Catch: Throwable -> L32
        monitor-exit(this);
        return r104;
    L25:
        if (r102 >= this.f27779g) goto L30;
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

    public final synchronized boolean d(String r100) throws IOException {
        monitor-enter(this);
        h();     // Catch: Throwable -> L25
        a(r100);     // Catch: Throwable -> L25
        f r101 = this.f27783k.get(r100);     // Catch: Throwable -> L25
        int r102 = 0;
        if (r101 != null) goto L6;
    L23:
        monitor-exit(this);
        return false;
    L6:
        if (f.b(r101) != null) goto L23;
    L9:
        if (r102 >= this.f27779g) goto L18;
        File r103 = r101.a(r102);     // Catch: Throwable -> L25
        if (r103.exists() == false) goto L17;
        if (r103.delete() == true) goto L17;
        throw new IOException("failed to delete ".concat(String.valueOf(r103)));     // Catch: Throwable -> L25
    L17:
        this.f27780h -= f.c(r101)[r102];     // Catch: Throwable -> L25
        f.c(r101)[r102] = 0;     // Catch: Throwable -> L25
        r102 = r102 + 1;     // Catch: Throwable -> L25
        goto L9
    L18:
        this.f27784l++;     // Catch: Throwable -> L25
        this.f27781i.append("REMOVE " + r100 + '\n');     // Catch: Throwable -> L25
        this.f27783k.remove(r100);     // Catch: Throwable -> L25
        if (g() == false) goto L21;
        l().submit(this.f27786n);     // Catch: Throwable -> L25
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

    public static void b(File r100) throws IOException {
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

    public static /* synthetic */ boolean c(o7 r100) {
        return r100.g();
    }

    public static /* synthetic */ void d(o7 r100) throws IOException {
        r100.e();
    }

    public static /* synthetic */ void b(o7 r100) throws IOException {
        r100.j();
    }

    public final void a(int r100) {
        if (r100 >= 10) goto L6;
        r100 = 10;
    L8:
        this.f27782j = r100;
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

    public static /* synthetic */ Writer a(o7 r100) {
        return r100.f27781i;
    }

    public static void a(o7 r100, d r110, boolean r111) throws IOException {
        monitor-enter(r100);
        f r101 = d.a(r110);     // Catch: Throwable -> L46
        if (f.b(r101) != r110) goto L45;
        int r102 = 0;
        if (r111 == false) goto L23;
        if (f.e(r101) == true) goto L23;
        int r103 = 0;
    L11:
        if (r103 >= r100.f27779g) goto L23;
        if (d.b(r110)[r103] == false) goto L20;
        if (r101.b(r103).exists() == false) goto L16;
        r103 = r103 + 1;
        goto L11
    L16:
        r110.a();     // Catch: Throwable -> L46
        monitor-exit(r100);
        return;
    L20:
        r110.a();     // Catch: Throwable -> L46
        throw new IllegalStateException("Newly created entry didn't create value for index ".concat(String.valueOf(r103)));     // Catch: Throwable -> L46
    L23:
        if (r102 >= r100.f27779g) goto L31;
        File r112 = r101.b(r102);     // Catch: Throwable -> L46
        if (r111 == true) goto L27;
        a(r112);     // Catch: Throwable -> L46
    L30:
        r102 = r102 + 1;     // Catch: Throwable -> L46
        goto L23
    L27:
        if (r112.exists() == false) goto L30;
        File r104 = r101.a(r102);     // Catch: Throwable -> L46
        r112.renameTo(r104);     // Catch: Throwable -> L46
        long r105 = f.c(r101)[r102];     // Catch: Throwable -> L46
        long r106 = r104.length();     // Catch: Throwable -> L46
        f.c(r101)[r102] = r106;     // Catch: Throwable -> L46
        r100.f27780h = (r100.f27780h - r105) + r106;     // Catch: Throwable -> L46
        goto L30
    L31:
        r100.f27784l++;     // Catch: Throwable -> L46
        f.a(r101, null);     // Catch: Throwable -> L46
        if ((f.e(r101) | r111) == false) goto L36;
        f.a(r101);     // Catch: Throwable -> L46
        r100.f27781i.write("CLEAN " + f.d(r101) + r101.a() + '\n');     // Catch: Throwable -> L46
        if (r111 == false) goto L37;
        long r113 = r100.f27785m;     // Catch: Throwable -> L46
        r100.f27785m = 1 + r113;     // Catch: Throwable -> L46
        f.a(r101, r113);     // Catch: Throwable -> L46
    L37:
        r100.f27781i.flush();     // Catch: Throwable -> L46
        if (r100.f27780h <= r100.f27778f) goto L40;
    L41:
        l().submit(r100.f27786n);     // Catch: Throwable -> L46
    L42:
        monitor-exit(r100);
        return;
    L40:
        if (r100.g() == false) goto L42;
    L36:
        r100.f27783k.remove(f.d(r101));     // Catch: Throwable -> L46
        r100.f27781i.write("REMOVE " + f.d(r101) + '\n');     // Catch: Throwable -> L46
        goto L37
    L45:
        throw new IllegalStateException();     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        throw th;
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

    private o7(File r100, int r101, int r102, long r110) {
        this.f27780h = 0;
        this.f27782j = 1000;
        this.f27783k = new LinkedHashMap(0, 0.75f, true);
        this.f27785m = 0;
        this.f27786n = new b(this);
        this.f27773a = r100;
        this.f27777e = r101;
        this.f27774b = new PolarisFileWrapper(r100, "journal");
        this.f27775c = new PolarisFileWrapper(r100, "journal.tmp");
        this.f27776d = new PolarisFileWrapper(r100, "journal.bkp");
        this.f27779g = r102;
        this.f27778f = r110;
    }

    public static o7 a(File r100, int r110, int r111, long r112) throws IOException {
        if (r112 <= 0) goto L21;
        if (r111 <= 0) goto L19;
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100, "journal.bkp");
        if (r101.exists() == false) goto L11;
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100, "journal");
        if (r102.exists() == false) goto L10;
        r101.delete();
        goto L11
    L10:
        a(r101, r102, false);
    L11:
        o7 r103 = new o7(r100, r110, r111, r112);
        if (r103.f27774b.exists() == true) goto L22;
    L16:
        r100.mkdirs();
        o7 r104 = new o7(r100, r110, r111, r112);
        r104.e();
        return r104;
    L22:
        r103.b();     // Catch: Throwable -> L15
        r103.c();     // Catch: Throwable -> L15
        r103.f27781i = new BufferedWriter(new OutputStreamWriter(new PolarisFileOutputStreamWrapper(r103.f27774b, true), f27769p));     // Catch: Throwable -> L15
        return r103;
    L15:
        r103.close();
        b(r103.f27773a);
        goto L16
    L19:
        throw new IllegalArgumentException("valueCount <= 0");
    L21:
        throw new IllegalArgumentException("maxSize <= 0");
    }
}
