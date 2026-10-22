package com.bytedance.android.gamecp.base.cache;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWriterWrapper;
import com.facebook.cache.disk.DefaultDiskStorage;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f51374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PolarisFileWrapper f51375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PolarisFileWrapper f51376c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f51377d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f51378e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f51379f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f51380g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Writer f51381h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LinkedHashMap<String, c> f51382i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f51383j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f51384k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ExecutorService f51385l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final a f51386m;

    public class a implements Callable<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f51387a;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public Void call2() throws Exception {
            b r100 = this.f51387a;
            monitor-enter(r100);
            b r101 = this.f51387a;     // Catch: Throwable -> L13
            if (r101.f51381h != null) goto L8;
            monitor-exit(r100);     // Catch: Throwable -> L13
            return null;
        L8:
            r101.p();     // Catch: Throwable -> L13
            if (this.f51387a.g() == false) goto L11;
            this.f51387a.m();     // Catch: Throwable -> L13
            this.f51387a.f51383j = 0;     // Catch: Throwable -> L13
        L11:
            monitor-exit(r100);     // Catch: Throwable -> L13
            return null;
        L13:
            th = move-exception;
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Void call() throws Exception {
            return call2();
        }

        public a(b r100) {
            this.f51387a = r100;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.gamecp.base.cache.b$b, reason: collision with other inner class name */
    public final class C0872b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f51388a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f51389b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f51390c;

        /* JADX INFO: renamed from: com.bytedance.android.gamecp.base.cache.b$b$a */
        public class a extends FilterOutputStream {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ C0872b f51391a;

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                ((FilterOutputStream) this).out.close();     // Catch: IOException -> L4
                return;
            L4:
                this.f51391a.f51389b = true;
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public final void flush() {
                ((FilterOutputStream) this).out.flush();     // Catch: IOException -> L4
                return;
            L4:
                this.f51391a.f51389b = true;
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(int r100) {
                ((FilterOutputStream) this).out.write(r100);     // Catch: IOException -> L4
                return;
            L4:
                this.f51391a.f51389b = true;
            }

            public a(C0872b r100, PolarisFileOutputStreamWrapper r101) {
                this.f51391a = r100;
                super(r101);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(byte[] r100, int r101, int r102) {
                ((FilterOutputStream) this).out.write(r100, r101, r102);     // Catch: IOException -> L4
                return;
            L4:
                this.f51391a.f51389b = true;
            }
        }

        public final void a() throws IOException {
            b.a(this.f51390c, this, false);
        }

        public final a b() throws IOException {
            b r100 = this.f51390c;
            monitor-enter(r100);
        L11:
            th = move-exception;
            throw th;
        L5:
            if (this.f51388a.f51395d != this) goto L10;
            a r101 = new a(this, new PolarisFileOutputStreamWrapper(this.f51388a.b(0)));     // Catch: Throwable -> L11
            monitor-exit(r100);     // Catch: Throwable -> L11
            return r101;
        L10:
            throw new IllegalStateException();     // Catch: Throwable -> L11
        }

        public C0872b(b r100, c r101) {
            this.f51390c = r100;
            this.f51388a = r101;
        }
    }

    public final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f51392a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long[] f51393b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f51394c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public C0872b f51395d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ b f51396e;

        public final String c() throws IOException {
            StringBuilder r100 = new StringBuilder();
            long[] r101 = this.f51393b;
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

        public final PolarisFileWrapper a(int r100) {
            return new PolarisFileWrapper(this.f51396e.f51374a, this.f51392a + "." + r100);
        }

        public final PolarisFileWrapper b(int r100) {
            return new PolarisFileWrapper(this.f51396e.f51374a, this.f51392a + "." + r100 + DefaultDiskStorage.FileType.TEMP);
        }

        public c(b r100, String r101) {
            this.f51396e = r100;
            this.f51392a = r101;
            this.f51393b = new long[r100.f51379f];
        }
    }

    public final class d implements Closeable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InputStream[] f51397a;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() {
            InputStream[] r100 = this.f51397a;
            int r101 = r100.length;
            int r102 = 0;
        L3:
            if (r102 >= r101) goto L11;
            InputStream r103 = r100[r102];
            if (r103 == null) goto L10;
            r103.close();     // Catch: RuntimeException -> L8 Exception -> L12
        L8:
            e = move-exception;
            throw e;
        L10:
            r102 = r102 + 1;
            goto L3
        }

        public d(InputStream[] r100) {
            this.f51397a = r100;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.f51381h != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        Iterator r100 = new ArrayList(this.f51382i.values()).iterator();     // Catch: Throwable -> L16
    L9:
        if (r100.hasNext() == false) goto L13;
        C0872b r101 = ((c) r100.next()).f51395d;     // Catch: Throwable -> L16
        if (r101 == null) goto L9;
        r101.a();     // Catch: Throwable -> L16
        goto L9
    L13:
        p();     // Catch: Throwable -> L16
        this.f51381h.close();     // Catch: Throwable -> L16
        this.f51381h = null;     // Catch: Throwable -> L16
        monitor-exit(this);
    }

    public final synchronized void flush() throws IOException {
        monitor-enter(this);
        b();     // Catch: Throwable -> L6
        p();     // Catch: Throwable -> L6
        this.f51381h.flush();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void m() throws IOException {
        monitor-enter(this);
        Writer r100 = this.f51381h;     // Catch: Throwable -> L16
        if (r100 == null) goto L6;
        r100.close();     // Catch: Throwable -> L16
    L6:
        BufferedWriter r101 = new BufferedWriter(new PolarisFileWriterWrapper(this.f51376c), 8192);     // Catch: Throwable -> L16
        r101.write("libcore.io.DiskLruCache");     // Catch: Throwable -> L16
        r101.write("\n");     // Catch: Throwable -> L16
        r101.write("1");     // Catch: Throwable -> L16
        r101.write("\n");     // Catch: Throwable -> L16
        r101.write(Integer.toString(this.f51377d));     // Catch: Throwable -> L16
        r101.write("\n");     // Catch: Throwable -> L16
        r101.write(Integer.toString(this.f51379f));     // Catch: Throwable -> L16
        r101.write("\n");     // Catch: Throwable -> L16
        r101.write("\n");     // Catch: Throwable -> L16
        Iterator<c> r102 = this.f51382i.values().iterator();     // Catch: Throwable -> L16
    L8:
        if (r102.hasNext() == false) goto L13;
        c r103 = r102.next();     // Catch: Throwable -> L16
        if (r103.f51395d != null) goto L11;
        r101.write("CLEAN " + r103.f51392a + r103.c() + '\n');     // Catch: Throwable -> L16
        goto L8
    L11:
        r101.write("DIRTY " + r103.f51392a + '\n');     // Catch: Throwable -> L16
        goto L8
    L13:
        r101.close();     // Catch: Throwable -> L16
        this.f51376c.renameTo(this.f51375b);     // Catch: Throwable -> L16
        this.f51381h = new BufferedWriter(new PolarisFileWriterWrapper(this.f51375b, true), 8192);     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    static {
        Charset.forName("UTF-8");
    }

    public final void b() {
        if (this.f51381h == null) goto L6;
        return;
    L6:
        throw new IllegalStateException("cache is closed");
    }

    public final boolean g() {
        int r100 = this.f51383j;
        if (r100 >= 2000) goto L5;
    L7:
        return false;
    L5:
        if (r100 < this.f51382i.size()) goto L7;
        return true;
    }

    public final void i() throws IOException {
        d(this.f51376c);
        Iterator<c> r100 = this.f51382i.values().iterator();
    L4:
        if (r100.hasNext() == false) goto L15;
        c r101 = r100.next();
        int r102 = 0;
        if (r101.f51395d == null) goto L8;
        r101.f51395d = null;
    L12:
        if (r102 >= this.f51379f) goto L14;
        d(r101.a(r102));
        d(r101.b(r102));
        r102 = r102 + 1;
        goto L12
    L14:
        r100.remove();
    L8:
        if (r102 >= this.f51379f) goto L4;
        this.f51380g += r101.f51393b[r102];
        r102 = r102 + 1;
        goto L8
    }

    public final void k() throws IOException {
        BufferedInputStream r100 = new BufferedInputStream(new PolarisFileInputStreamWrapper(this.f51375b), 8192);
        String r101 = j(r100);     // Catch: Throwable -> L21
        String r102 = j(r100);     // Catch: Throwable -> L21
        String r103 = j(r100);     // Catch: Throwable -> L21
        String r104 = j(r100);     // Catch: Throwable -> L21
        String r105 = j(r100);     // Catch: Throwable -> L21
        if ("libcore.io.DiskLruCache".equals(r101) == false) goto L20;
        if ("1".equals(r102) == false) goto L20;
        if (Integer.toString(this.f51377d).equals(r103) == false) goto L20;
        if (Integer.toString(this.f51379f).equals(r104) == false) goto L20;
        if ("".equals(r105) == false) goto L20;
    L28:
        l(j(r100));     // Catch: EOFException -> L15 Throwable -> L21
    L15:
        r100.close();     // Catch: Exception -> L26 RuntimeException -> L17
        return;
    L17:
        e = move-exception;
        throw e;
    L35:
        return;
    L20:
        throw new IOException("unexpected journal header: [" + r101 + ", " + r102 + ", " + r104 + ", " + r105 + "]");     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        r100.close();     // Catch: Exception -> L27 RuntimeException -> L24
    L24:
        e = move-exception;
        throw e;
    L23:
        throw th;
    }

    public final void p() throws IOException {
    L3:
        if (this.f51380g <= this.f51378e) goto L5;
        n(this.f51382i.entrySet().iterator().next().getKey());
        goto L3
    }

    public void delete() throws IOException {
        close();
        c(this.f51374a);
    }

    public b(PolarisFileWrapper r100) {
        this.f51380g = 0;
        this.f51382i = new LinkedHashMap(0, 0.75f, true);
        this.f51384k = 0;
        this.f51385l = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("/DiskLruCache"));
        this.f51386m = new a(this);
        this.f51374a = r100;
        this.f51377d = 1;
        this.f51375b = new PolarisFileWrapper(r100, "journal");
        this.f51376c = new PolarisFileWrapper(r100, "journal.tmp");
        this.f51379f = 1;
        this.f51378e = 1048576;
    }

    public static void c(File r100) throws IOException {
        File[] r101 = r100.listFiles();
        if (r101 == null) goto L16;
        int r102 = r101.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L14;
        File r104 = r101[r103];
        if (r104.isDirectory() == false) goto L10;
        c(r104);
    L10:
        if (r104.delete() == false) goto L13;
        r103 = r103 + 1;
        goto L5
    L13:
        throw new IOException("failed to delete file: " + r104);
    L14:
        return;
    L16:
        throw new IllegalArgumentException("not a directory: " + r100);
    }

    public static void d(PolarisFileWrapper r100) throws IOException {
        if (r100.exists() == true) goto L5;
        return;
    L5:
        if (r100.delete() == false) goto L8;
        return;
    L8:
        throw new IOException();
    }

    public static b h(PolarisFileWrapper r100) throws IOException {
        b r101 = new b(r100);
        if (r101.f51375b.exists() == true) goto L9;
    L7:
        r100.mkdirs();
        b r102 = new b(r100);
        r102.m();
        return r102;
    L9:
        r101.k();     // Catch: IOException -> L6
        r101.i();     // Catch: IOException -> L6
        r101.f51381h = new BufferedWriter(new PolarisFileWriterWrapper(r101.f51375b, true), 8192);     // Catch: IOException -> L6
        return r101;
    L6:
        r101.delete();
        goto L7
    }

    public static String j(InputStream r100) throws IOException {
        StringBuilder r101 = new StringBuilder(80);
    L3:
        int r102 = r100.read();
        if (r102 == (-1)) goto L16;
        if (r102 == 10) goto L7;
        r101.append((char) r102);
        goto L3
    L7:
        int r103 = r101.length();
        if (r103 <= 0) goto L13;
        int r104 = r103 - 1;
        if (r101.charAt(r104) != '\r') goto L13;
        r101.setLength(r104);
    L13:
        return r101.toString();
    L16:
        throw new EOFException();
    }

    public static void q(String r100) {
        if (r100.contains(" ") == true) goto L10;
        if (r100.contains("\n") == true) goto L10;
        if (r100.contains("\r") == true) goto L10;
        return;
    L10:
        throw new IllegalArgumentException("keys must not contain spaces or newlines: \"" + r100 + "\"");
    }

    public final C0872b e(String r100) throws IOException {
        monitor-enter(this);
        b();     // Catch: Throwable -> L15
        q(r100);     // Catch: Throwable -> L15
        c r101 = this.f51382i.get(r100);     // Catch: Throwable -> L15
        if (r101 != null) goto L8;
        r101 = new c(this, r100);     // Catch: Throwable -> L15
        this.f51382i.put(r100, r101);     // Catch: Throwable -> L15
    L11:
        C0872b r102 = new C0872b(this, r101);     // Catch: Throwable -> L15
        r101.f51395d = r102;     // Catch: Throwable -> L15
        this.f51381h.write("DIRTY " + r100 + '\n');     // Catch: Throwable -> L15
        this.f51381h.flush();     // Catch: Throwable -> L15
        monitor-exit(this);
        return r102;
    L8:
        if (r101.f51395d == null) goto L11;
        monitor-exit(this);
        return null;
    L15:
        th = move-exception;
        throw th;
    }

    public final synchronized d f(String r100) throws IOException {
        monitor-enter(this);
        b();     // Catch: Throwable -> L35
        q(r100);     // Catch: Throwable -> L35
        c r101 = this.f51382i.get(r100);     // Catch: Throwable -> L35
        if (r101 != null) goto L9;
        monitor-exit(this);
        return null;
    L9:
        if (r101.f51394c == true) goto L12;
        monitor-exit(this);
        return null;
    L12:
        int r102 = this.f51379f;     // Catch: Throwable -> L35
        InputStream[] r103 = new InputStream[r102];     // Catch: Throwable -> L35
        int r104 = 0;
        int r105 = 0;
    L40:
        if (r105 >= this.f51379f) goto L18;
        r103[r105] = new PolarisFileInputStreamWrapper(r101.a(r105));     // Catch: FileNotFoundException -> L24 Throwable -> L35
        r105 = r105 + 1;
        goto L40
        goto L25
    L18:
        this.f51383j++;     // Catch: Throwable -> L35
        this.f51381h.append("READ " + r100 + '\n');     // Catch: Throwable -> L35
        if (g() == false) goto L21;
        this.f51385l.submit(this.f51386m);     // Catch: Throwable -> L35
    L21:
        d r106 = new d(r103);     // Catch: Throwable -> L35
        monitor-exit(this);
        return r106;
    L25:
        if (r104 >= r102) goto L34;
        InputStream r107 = r103[r104];     // Catch: Throwable -> L35
        if (r107 == null) goto L32;
        r107.close();     // Catch: RuntimeException -> L30 Exception -> L38 Throwable -> L35
    L30:
        e = move-exception;
        throw e;     // Catch: Throwable -> L35
    L32:
        r104 = r104 + 1;
        goto L25
    L34:
        return null;
    L35:
        th = move-exception;
        throw th;
    }

    public final void l(String r100) throws IOException {
        String[] r101 = r100.split(" ");
        if (r101.length < 2) goto L47;
        String r102 = r101[1];
        int r103 = 0;
        if (r101[0].equals("REMOVE") == true) goto L7;
    L10:
        c r104 = this.f51382i.get(r102);
        if (r104 != null) goto L14;
        r104 = new c(this, r102);
        this.f51382i.put(r102, r104);
    L14:
        if (r101[0].equals("CLEAN") == false) goto L35;
        if (r101.length != (this.f51379f + 2)) goto L35;
        r104.f51394c = true;
        r104.f51395d = null;
        int r105 = r101.length;
        int r106 = r101.length;
        if (2 > r105) goto L33;
        if (2 > r106) goto L31;
        int r107 = r105 - 2;
        int r108 = Math.min(r107, r106 - 2);
        Object[] r109 = (Object[]) Array.newInstance(r101.getClass().getComponentType(), r107);
        System.arraycopy(r101, 2, r109, 0, r108);
        String[] r110 = (String[]) r109;
        if (r110.length != r104.f51396e.f51379f) goto L29;
    L48:
        if (r103 >= r110.length) goto L52;
        r104.f51393b[r103] = CastLongProtector.parseLong(r110[r103]);     // Catch: NumberFormatException -> L26
        r103 = r103 + 1;
        goto L48
    L52:
        return;
    L27:
        throw new IOException("unexpected journal line: " + Arrays.toString(r110));
    L29:
        throw new IOException("unexpected journal line: " + Arrays.toString(r110));
    L31:
        throw new ArrayIndexOutOfBoundsException();
    L33:
        throw new IllegalArgumentException();
    L35:
        if (r101[0].equals("DIRTY") == false) goto L40;
        if (r101.length != 2) goto L40;
        r104.f51395d = new C0872b(this, r104);
        return;
    L40:
        if (r101[0].equals("READ") == false) goto L45;
        if (r101.length != 2) goto L45;
        return;
    L45:
        throw new IOException("unexpected journal line: ".concat(r100));
    L7:
        if (r101.length != 2) goto L10;
        this.f51382i.remove(r102);
        return;
    L47:
        throw new IOException("unexpected journal line: ".concat(r100));
    }

    public final synchronized void n(String r100) throws IOException {
        monitor-enter(this);
        b();     // Catch: Throwable -> L23
        q(r100);     // Catch: Throwable -> L23
        c r101 = this.f51382i.get(r100);     // Catch: Throwable -> L23
        if (r101 != null) goto L6;
    L21:
        monitor-exit(this);
        return;
    L6:
        if (r101.f51395d != null) goto L21;
        int r102 = 0;
    L10:
        if (r102 >= this.f51379f) goto L16;
        PolarisFileWrapper r103 = r101.a(r102);     // Catch: Throwable -> L23
        if (r103.delete() == false) goto L15;
        long r104 = this.f51380g;     // Catch: Throwable -> L23
        long[] r105 = r101.f51393b;     // Catch: Throwable -> L23
        this.f51380g = r104 - r105[r102];     // Catch: Throwable -> L23
        r105[r102] = 0;     // Catch: Throwable -> L23
        r102 = r102 + 1;     // Catch: Throwable -> L23
        goto L10
    L15:
        throw new IOException("failed to delete " + r103);     // Catch: Throwable -> L23
    L16:
        this.f51383j++;     // Catch: Throwable -> L23
        this.f51381h.append("REMOVE " + r100 + '\n');     // Catch: Throwable -> L23
        this.f51382i.remove(r100);     // Catch: Throwable -> L23
        if (g() == false) goto L19;
        this.f51385l.submit(this.f51386m);     // Catch: Throwable -> L23
    L19:
        monitor-exit(this);
        return;
    L23:
        th = move-exception;
        throw th;
    }

    public static void a(b r100, C0872b r110, boolean r111) throws IOException {
        monitor-enter(r100);
        c r101 = r110.f51388a;     // Catch: Throwable -> L41
        if (r101.f51395d != r110) goto L40;
        int r102 = 0;
        if (r111 == false) goto L18;
        if (r101.f51394c == true) goto L18;
        int r103 = 0;
    L11:
        if (r103 >= r100.f51379f) goto L18;
        if (r101.b(r103).exists() == false) goto L15;
        r103 = r103 + 1;     // Catch: Throwable -> L41
        goto L11
    L15:
        r110.a();     // Catch: Throwable -> L41
        throw new IllegalStateException("edit didn't create file " + r103);     // Catch: Throwable -> L41
    L18:
        if (r102 >= r100.f51379f) goto L26;
        PolarisFileWrapper r112 = r101.b(r102);     // Catch: Throwable -> L41
        if (r111 == true) goto L22;
        d(r112);     // Catch: Throwable -> L41
    L25:
        r102 = r102 + 1;     // Catch: Throwable -> L41
        goto L18
    L22:
        if (r112.exists() == false) goto L25;
        PolarisFileWrapper r104 = r101.a(r102);     // Catch: Throwable -> L41
        r112.renameTo(r104);     // Catch: Throwable -> L41
        long r105 = r101.f51393b[r102];     // Catch: Throwable -> L41
        long r106 = r104.length();     // Catch: Throwable -> L41
        r101.f51393b[r102] = r106;     // Catch: Throwable -> L41
        r100.f51380g = (r100.f51380g - r105) + r106;     // Catch: Throwable -> L41
        goto L25
    L26:
        r100.f51383j++;     // Catch: Throwable -> L41
        r101.f51395d = null;     // Catch: Throwable -> L41
        if ((r101.f51394c | r111) == false) goto L31;
        r101.f51394c = true;     // Catch: Throwable -> L41
        r100.f51381h.write("CLEAN " + r101.f51392a + r101.c() + '\n');     // Catch: Throwable -> L41
        if (r111 == false) goto L33;
        r100.f51384k++;     // Catch: Throwable -> L41
        r101.getClass();     // Catch: Throwable -> L41
    L33:
        if (r100.f51380g <= r100.f51378e) goto L35;
    L36:
        r100.f51385l.submit(r100.f51386m);     // Catch: Throwable -> L41
    L37:
        monitor-exit(r100);
        return;
    L35:
        if (r100.g() == false) goto L37;
    L31:
        r100.f51382i.remove(r101.f51392a);     // Catch: Throwable -> L41
        r100.f51381h.write("REMOVE " + r101.f51392a + '\n');     // Catch: Throwable -> L41
        goto L33
    L40:
        throw new IllegalStateException();     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        throw th;
    }
}
