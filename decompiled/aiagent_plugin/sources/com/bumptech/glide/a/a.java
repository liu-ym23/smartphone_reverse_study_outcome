package com.bumptech.glide.a;

import android.os.Build;
import android.os.StrictMode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: DiskLruCache.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final ThreadPoolExecutor f3218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f3219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final File f3220c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final File f3221d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final File f3222e;
    private final int f;
    private long g;
    private final int h;
    private long i;
    private Writer j;
    private final LinkedHashMap<String, c> k;
    private int l;
    private long m;
    private final Callable<Void> n;

    /* JADX INFO: renamed from: com.bumptech.glide.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DiskLruCache.java */
    private static final class ThreadFactoryC0082a implements ThreadFactory {
        private ThreadFactoryC0082a() {
        }

        /* synthetic */ ThreadFactoryC0082a(AnonymousClass1 r1) {
            this();
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable r3) {
            monitor-enter(this);
            Thread r0 = new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin"), "glide-disk-lru-cache-thread");     // Catch: Throwable -> L6
            r0.setPriority(1);     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: compiled from: DiskLruCache.java */
    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f3224a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final c f3225b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean[] f3226c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f3227d;

        /* synthetic */ b(a r1, c r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        static /* synthetic */ c a(b r0) {
            return r0.f3225b;
        }

        static /* synthetic */ boolean[] b(b r0) {
            return r0.f3226c;
        }

        private b(a r1, c r2) {
            this.f3224a = r1;
            this.f3225b = r2;
            if (c.d(r2) == false) goto L5;
            boolean[] r3 = null;
        L6:
            this.f3226c = r3;
            return;
        L5:
            r3 = new boolean[a.e(r1)];
            goto L6
        }

        public File a(int r4) {
            a r0 = this.f3224a;
            monitor-enter(r0);
        L16:
            th = move-exception;
            throw th;
        L5:
            if (c.a(this.f3225b) != this) goto L15;
            if (c.d(this.f3225b) == true) goto L9;
            this.f3226c[r4] = true;     // Catch: Throwable -> L16
        L9:
            File r5 = this.f3225b.b(r4);     // Catch: Throwable -> L16
            if (a.f(this.f3224a).exists() == true) goto L12;
            a.f(this.f3224a).mkdirs();     // Catch: Throwable -> L16
        L12:
            monitor-exit(r0);     // Catch: Throwable -> L16
            return r5;
        L15:
            throw new IllegalStateException();     // Catch: Throwable -> L16
        }

        public void a() {
            a.a(this.f3224a, this, true);
            this.f3227d = true;
        }

        public void b() {
            a.a(this.f3224a, this, false);
        }

        public void c() {
            if (this.f3227d == true) goto L9;
            b();     // Catch: IOException -> L6
            return;
        L10:
            return;
        }
    }

    /* JADX INFO: compiled from: DiskLruCache.java */
    private final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        File[] f3228a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        File[] f3229b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f3230c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f3231d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final long[] f3232e;
        private boolean f;
        private b g;
        private long h;

        /* synthetic */ c(a r1, String r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        static /* synthetic */ long a(c r0, long r1) {
            r0.h = r1;
            return r1;
        }

        static /* synthetic */ b a(c r0) {
            return r0.g;
        }

        static /* synthetic */ b a(c r0, b r1) {
            r0.g = r1;
            return r1;
        }

        static /* synthetic */ void a(c r0, String[] r1) {
            r0.a(r1);
        }

        static /* synthetic */ boolean a(c r0, boolean r1) {
            r0.f = r1;
            return r1;
        }

        static /* synthetic */ long[] b(c r0) {
            return r0.f3232e;
        }

        static /* synthetic */ String c(c r0) {
            return r0.f3231d;
        }

        static /* synthetic */ boolean d(c r0) {
            return r0.f;
        }

        static /* synthetic */ long e(c r2) {
            return r2.h;
        }

        private c(a r7, String r8) {
            this.f3230c = r7;
            this.f3231d = r8;
            this.f3232e = new long[a.e(r7)];
            this.f3228a = new File[a.e(r7)];
            this.f3229b = new File[a.e(r7)];
            StringBuilder r9 = new StringBuilder(r8).append('.');
            int r0 = r9.length();
            int r1 = 0;
        L4:
            if (r1 >= a.e(r7)) goto L6;
            r9.append(r1);
            this.f3228a[r1] = new File(a.f(r7), r9.toString());
            r9.append(".tmp");
            this.f3229b[r1] = new File(a.f(r7), r9.toString());
            r9.setLength(r0);
            r1 = r1 + 1;
            goto L4
        }

        public String a() {
            StringBuilder r0 = new StringBuilder();
            long[] r6 = this.f3232e;
            int r1 = r6.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L6;
            long r3 = r6[r2];
            r0.append(' ').append(r3);
            r2 = r2 + 1;
            goto L3
        L6:
            return r0.toString();
        }

        private void a(String[] r5) {
            if (r5.length != a.e(this.f3230c)) goto L13;
            int r0 = 0;
        L14:
            if (r0 >= r5.length) goto L9;
            this.f3232e[r0] = Long.parseLong(r5[r0]);     // Catch: NumberFormatException -> L10
            r0 = r0 + 1;
            goto L14
        L9:
            return;
        L11:
            throw b(r5);
        L13:
            throw b(r5);
        }

        private IOException b(String[] r3) {
            throw new IOException("unexpected journal line: " + Arrays.toString(r3));
        }

        public File a(int r1) {
            return this.f3228a[r1];
        }

        public File b(int r1) {
            return this.f3229b[r1];
        }
    }

    /* JADX INFO: compiled from: DiskLruCache.java */
    public final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f3233a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f3234b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f3235c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long[] f3236d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final File[] f3237e;

        /* synthetic */ d(a r1, String r2, long r3, File[] r5, long[] r6, AnonymousClass1 r7) {
            this(r1, r2, r3, r5, r6);
        }

        private d(a r1, String r2, long r3, File[] r5, long[] r6) {
            this.f3233a = r1;
            this.f3234b = r2;
            this.f3235c = r3;
            this.f3237e = r5;
            this.f3236d = r6;
        }

        public File a(int r1) {
            return this.f3237e[r1];
        }
    }

    static /* synthetic */ int a(a r0, int r1) {
        r0.l = r1;
        return r1;
    }

    static /* synthetic */ Writer a(a r0) {
        return r0.j;
    }

    static /* synthetic */ void a(a r0, b r1, boolean r2) {
        r0.a(r1, r2);
    }

    static /* synthetic */ void b(a r0) {
        r0.f();
    }

    static /* synthetic */ boolean c(a r0) {
        return r0.d();
    }

    static /* synthetic */ void d(a r0) {
        r0.c();
    }

    static /* synthetic */ int e(a r0) {
        return r0.h;
    }

    static /* synthetic */ File f(a r0) {
        return r0.f3219b;
    }

    private a(File r17, int r18, int r19, long r20) {
        this.i = 0;
        this.k = new LinkedHashMap(0, 0.75f, true);
        this.m = 0;
        this.f3218a = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC0082a(null));
        this.n = new AnonymousClass1(this);
        this.f3219b = r17;
        this.f = r18;
        this.f3220c = new File(r17, "journal");
        this.f3221d = new File(r17, "journal.tmp");
        this.f3222e = new File(r17, "journal.bkp");
        this.h = r19;
        this.g = r20;
    }

    public static a a(File r9, int r10, int r11, long r12) {
        if (r12 <= 0) goto L22;
        if (r11 <= 0) goto L20;
        File r0 = new File(r9, "journal.bkp");
        if (r0.exists() == false) goto L11;
        File r1 = new File(r9, "journal");
        if (r1.exists() == false) goto L10;
        r0.delete();
        goto L11
    L10:
        a(r0, r1, false);
    L11:
        a r2 = new a(r9, r10, r11, r12);
        if (r2.f3220c.exists() == true) goto L23;
    L17:
        r9.mkdirs();
        a r3 = new a(r9, r10, r11, r12);
        r3.c();
        return r3;
    L23:
        r2.a();     // Catch: IOException -> L15
        r2.b();     // Catch: IOException -> L15
        return r2;
    L15:
        e = move-exception;
        System.out.println("DiskLruCache " + r9 + " is corrupt: " + e.getMessage() + ", removing");
        r2.delete();
        goto L17
    L20:
        throw new IllegalArgumentException("valueCount <= 0");
    L22:
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private void a() {
        com.bumptech.glide.a.b r1 = new com.bumptech.glide.a.b(new FileInputStream(this.f3220c), com.bumptech.glide.a.c.f3244a);
        String r2 = r1.a();     // Catch: Throwable -> L24
        String r3 = r1.a();     // Catch: Throwable -> L24
        String r4 = r1.a();     // Catch: Throwable -> L24
        String r5 = r1.a();     // Catch: Throwable -> L24
        String r6 = r1.a();     // Catch: Throwable -> L24
        if ("libcore.io.DiskLruCache".equals(r2) == false) goto L23;
        if ("1".equals(r3) == false) goto L23;
        if (Integer.toString(this.f).equals(r4) == false) goto L23;
        if (Integer.toString(this.h).equals(r5) == false) goto L23;
        if ("".equals(r6) == false) goto L23;
        int r0 = 0;
    L28:
        d(r1.a());     // Catch: EOFException -> L16 Throwable -> L24
        r0 = r0 + 1;
        goto L28
    L16:
        this.l = r0 - this.k.size();     // Catch: Throwable -> L24
        if (r1.b() == false) goto L19;
        c();     // Catch: Throwable -> L24
    L20:
        com.bumptech.glide.a.c.a(r1);
        return;
    L19:
        this.j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f3220c, true), com.bumptech.glide.a.c.f3244a));     // Catch: Throwable -> L24
    L23:
        throw new IOException("unexpected journal header: [" + r2 + ", " + r3 + ", " + r5 + ", " + r6 + "]");     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        com.bumptech.glide.a.c.a(r1);
        throw th;
    }

    private void d(String r9) {
        int r1 = r9.indexOf(32);
        if (r1 == (-1)) goto L36;
        int r4 = r1 + 1;
        int r0 = r9.indexOf(32, r4);
        if (r0 != (-1)) goto L12;
        String r5 = r9.substring(r4);
        if (r1 == 6) goto L9;
    L13:
        c r6 = (c) ZeusTransformUtils.preCheckCast(this.k.get(r5), c.class, "com.obric.aiagent.plugin");
        AnonymousClass1 r7 = null;
        if (r6 != null) goto L17;
        r6 = new c(this, r5, r7);
        this.k.put(r5, r6);
    L17:
        if (r0 == (-1)) goto L22;
        if (r1 != 5) goto L22;
        if (r9.startsWith("CLEAN") == false) goto L22;
        String[] r10 = r9.substring(r0 + 1).split(" ");
        c.a(r6, true);
        c.a(r6, null);
        c.a(r6, r10);
        return;
    L22:
        if (r0 != (-1)) goto L27;
        if (r1 != 5) goto L27;
        if (r9.startsWith("DIRTY") == false) goto L27;
        c.a(r6, new b(this, r6, r7));
        return;
    L27:
        if (r0 != (-1)) goto L34;
        if (r1 != 4) goto L34;
        if (r9.startsWith("READ") == false) goto L34;
        return;
    L34:
        throw new IOException("unexpected journal line: " + r9);
    L9:
        if (r9.startsWith("REMOVE") == false) goto L13;
        this.k.remove(r5);
        return;
    L12:
        r5 = r9.substring(r4, r0);
        goto L13
    L36:
        throw new IOException("unexpected journal line: " + r9);
    }

    private void b() {
        a(this.f3221d);
        Iterator<c> r0 = this.k.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L15;
        c r1 = (c) ZeusTransformUtils.preCheckCast(r0.next(), c.class, "com.obric.aiagent.plugin");
        int r3 = 0;
        if (c.a(r1) == null) goto L8;
        c.a(r1, null);
    L12:
        if (r3 >= this.h) goto L14;
        a(r1.a(r3));
        a(r1.b(r3));
        r3 = r3 + 1;
        goto L12
    L14:
        r0.remove();
    L8:
        if (r3 >= this.h) goto L4;
        this.i += c.b(r1)[r3];
        r3 = r3 + 1;
        goto L8
    }

    private synchronized void c() {
        monitor-enter(this);
        Writer r0 = this.j;     // Catch: Throwable -> L24
        if (r0 == null) goto L6;
        a(r0);     // Catch: Throwable -> L24
    L6:
        BufferedWriter r1 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f3221d), com.bumptech.glide.a.c.f3244a));     // Catch: Throwable -> L24
        r1.write("libcore.io.DiskLruCache");     // Catch: Throwable -> L21
        r1.write("\n");     // Catch: Throwable -> L21
        r1.write("1");     // Catch: Throwable -> L21
        r1.write("\n");     // Catch: Throwable -> L21
        r1.write(Integer.toString(this.f));     // Catch: Throwable -> L21
        r1.write("\n");     // Catch: Throwable -> L21
        r1.write(Integer.toString(this.h));     // Catch: Throwable -> L21
        r1.write("\n");     // Catch: Throwable -> L21
        r1.write("\n");     // Catch: Throwable -> L21
        Iterator<c> r2 = this.k.values().iterator();     // Catch: Throwable -> L21
    L8:
        if (r2.hasNext() == false) goto L15;
        c r3 = (c) ZeusTransformUtils.preCheckCast(r2.next(), c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L21
        if (c.a(r3) != null) goto L12;
        r1.write("CLEAN " + c.c(r3) + r3.a() + '\n');     // Catch: Throwable -> L21
        goto L8
    L12:
        r1.write("DIRTY " + c.c(r3) + '\n');     // Catch: Throwable -> L21
        goto L8
    L15:
        a(r1);     // Catch: Throwable -> L24
        if (this.f3220c.exists() == false) goto L18;
        a(this.f3220c, this.f3222e, true);     // Catch: Throwable -> L24
    L18:
        a(this.f3221d, this.f3220c, false);     // Catch: Throwable -> L24
        this.f3222e.delete();     // Catch: Throwable -> L24
        this.j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f3220c, true), com.bumptech.glide.a.c.f3244a));     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L21:
        th = move-exception;
        a(r1);     // Catch: Throwable -> L24
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    private static void a(File r1) {
        if (r1.exists() == true) goto L5;
        return;
    L5:
        if (r1.delete() == false) goto L8;
        return;
    L8:
        throw new IOException();
    }

    private static void a(File r0, File r1, boolean r2) {
        if (r2 == false) goto L5;
        a(r1);
    L5:
        if (r0.renameTo(r1) == false) goto L8;
        return;
    L8:
        throw new IOException();
    }

    public synchronized d a(String r10) {
        monitor-enter(this);
        e();     // Catch: Throwable -> L25
        c r0 = (c) ZeusTransformUtils.preCheckCast(this.k.get(r10), c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        if (r0 != null) goto L9;
        monitor-exit(this);
        return null;
    L9:
        if (c.d(r0) == true) goto L12;
        monitor-exit(this);
        return null;
    L12:
        File[] r2 = r0.f3228a;     // Catch: Throwable -> L25
        int r3 = r2.length;     // Catch: Throwable -> L25
        int r4 = 0;
    L13:
        if (r4 >= r3) goto L19;
        if (r2[r4].exists() == false) goto L16;
        r4 = r4 + 1;
        goto L13
    L16:
        monitor-exit(this);
        return null;
    L19:
        this.l++;     // Catch: Throwable -> L25
        this.j.append("READ");     // Catch: Throwable -> L25
        this.j.append(' ');     // Catch: Throwable -> L25
        this.j.append(r10);     // Catch: Throwable -> L25
        this.j.append('\n');     // Catch: Throwable -> L25
        if (d() == false) goto L22;
        this.f3218a.submit(this.n);     // Catch: Throwable -> L25
    L22:
        d r8 = new d(this, r10, c.e(r0), r0.f3228a, c.b(r0), null);     // Catch: Throwable -> L25
        monitor-exit(this);
        return r8;
    L25:
        th = move-exception;
        throw th;
    }

    public b b(String r3) {
        return a(r3, -1);
    }

    private synchronized b a(String r6, long r7) {
        monitor-enter(this);
        e();     // Catch: Throwable -> L20
        c r0 = (c) ZeusTransformUtils.preCheckCast(this.k.get(r6), c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        AnonymousClass1 r2 = null;
        if (r7 == (-1)) goto L11;
        if (r0 != null) goto L8;
    L9:
        monitor-exit(this);
        return null;
    L8:
        if (c.e(r0) != r7) goto L9;
    L11:
        if (r0 != null) goto L14;
        r0 = new c(this, r6, r2);     // Catch: Throwable -> L20
        this.k.put(r6, r0);     // Catch: Throwable -> L20
    L17:
        b r8 = new b(this, r0, r2);     // Catch: Throwable -> L20
        c.a(r0, r8);     // Catch: Throwable -> L20
        this.j.append("DIRTY");     // Catch: Throwable -> L20
        this.j.append(' ');     // Catch: Throwable -> L20
        this.j.append(r6);     // Catch: Throwable -> L20
        this.j.append('\n');     // Catch: Throwable -> L20
        b(this.j);     // Catch: Throwable -> L20
        monitor-exit(this);
        return r8;
    L14:
        if (c.a(r0) == null) goto L17;
        monitor-exit(this);
        return null;
    L20:
        th = move-exception;
        throw th;
    }

    private synchronized void a(b r10, boolean r11) {
        monitor-enter(this);
        c r0 = b.a(r10);     // Catch: Throwable -> L46
        if (c.a(r0) != r10) goto L45;
        int r1 = 0;
        if (r11 == false) goto L23;
        if (c.d(r0) == true) goto L23;
        int r2 = 0;
    L11:
        if (r2 >= this.h) goto L23;
        if (b.b(r10)[r2] == false) goto L20;
        if (r0.b(r2).exists() == false) goto L16;
        r2 = r2 + 1;
        goto L11
    L16:
        r10.b();     // Catch: Throwable -> L46
        monitor-exit(this);
        return;
    L20:
        r10.b();     // Catch: Throwable -> L46
        throw new IllegalStateException("Newly created entry didn't create value for index " + r2);     // Catch: Throwable -> L46
    L23:
        if (r1 >= this.h) goto L31;
        File r12 = r0.b(r1);     // Catch: Throwable -> L46
        if (r11 == true) goto L27;
        a(r12);     // Catch: Throwable -> L46
    L30:
        r1 = r1 + 1;     // Catch: Throwable -> L46
        goto L23
    L27:
        if (r12.exists() == false) goto L30;
        File r3 = r0.a(r1);     // Catch: Throwable -> L46
        r12.renameTo(r3);     // Catch: Throwable -> L46
        long r4 = c.b(r0)[r1];     // Catch: Throwable -> L46
        long r5 = r3.length();     // Catch: Throwable -> L46
        c.b(r0)[r1] = r5;     // Catch: Throwable -> L46
        this.i = (this.i - r4) + r5;     // Catch: Throwable -> L46
        goto L30
    L31:
        this.l++;     // Catch: Throwable -> L46
        c.a(r0, null);     // Catch: Throwable -> L46
        if ((c.d(r0) | r11) == false) goto L36;
        c.a(r0, true);     // Catch: Throwable -> L46
        this.j.append("CLEAN");     // Catch: Throwable -> L46
        this.j.append(' ');     // Catch: Throwable -> L46
        this.j.append(c.c(r0));     // Catch: Throwable -> L46
        this.j.append(r0.a());     // Catch: Throwable -> L46
        this.j.append('\n');     // Catch: Throwable -> L46
        if (r11 == false) goto L37;
        long r13 = this.m;     // Catch: Throwable -> L46
        this.m = 1 + r13;     // Catch: Throwable -> L46
        c.a(r0, r13);     // Catch: Throwable -> L46
    L37:
        b(this.j);     // Catch: Throwable -> L46
        if (this.i <= this.g) goto L40;
    L41:
        this.f3218a.submit(this.n);     // Catch: Throwable -> L46
    L42:
        monitor-exit(this);
        return;
    L40:
        if (d() == false) goto L42;
    L36:
        this.k.remove(c.c(r0));     // Catch: Throwable -> L46
        this.j.append("REMOVE");     // Catch: Throwable -> L46
        this.j.append(' ');     // Catch: Throwable -> L46
        this.j.append(c.c(r0));     // Catch: Throwable -> L46
        this.j.append('\n');     // Catch: Throwable -> L46
        goto L37
    L45:
        throw new IllegalStateException();     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        throw th;
    }

    private boolean d() {
        int r0 = this.l;
        if (r0 >= 2000) goto L5;
    L7:
        return false;
    L5:
        if (r0 < this.k.size()) goto L7;
        return true;
    }

    public synchronized boolean c(String r7) {
        monitor-enter(this);
        e();     // Catch: Throwable -> L25
        c r0 = (c) ZeusTransformUtils.preCheckCast(this.k.get(r7), c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L25
        int r1 = 0;
        if (r0 != null) goto L6;
    L23:
        monitor-exit(this);
        return false;
    L6:
        if (c.a(r0) != null) goto L23;
    L9:
        if (r1 >= this.h) goto L18;
        File r2 = r0.a(r1);     // Catch: Throwable -> L25
        if (r2.exists() == false) goto L17;
        if (r2.delete() == true) goto L17;
        throw new IOException("failed to delete " + r2);     // Catch: Throwable -> L25
    L17:
        this.i -= c.b(r0)[r1];     // Catch: Throwable -> L25
        c.b(r0)[r1] = 0;     // Catch: Throwable -> L25
        r1 = r1 + 1;     // Catch: Throwable -> L25
        goto L9
    L18:
        this.l++;     // Catch: Throwable -> L25
        this.j.append("REMOVE");     // Catch: Throwable -> L25
        this.j.append(' ');     // Catch: Throwable -> L25
        this.j.append(r7);     // Catch: Throwable -> L25
        this.j.append('\n');     // Catch: Throwable -> L25
        this.k.remove(r7);     // Catch: Throwable -> L25
        if (d() == false) goto L21;
        this.f3218a.submit(this.n);     // Catch: Throwable -> L25
    L21:
        monitor-exit(this);
        return true;
    L25:
        th = move-exception;
        throw th;
    }

    private void e() {
        if (this.j == null) goto L6;
        return;
    L6:
        throw new IllegalStateException("cache is closed");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.j != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        Iterator r0 = new ArrayList(this.k.values()).iterator();     // Catch: Throwable -> L16
    L9:
        if (r0.hasNext() == false) goto L13;
        c r1 = (c) ZeusTransformUtils.preCheckCast(r0.next(), c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        if (c.a(r1) == null) goto L9;
        c.a(r1).b();     // Catch: Throwable -> L16
        goto L9
    L13:
        f();     // Catch: Throwable -> L16
        a(this.j);     // Catch: Throwable -> L16
        this.j = null;     // Catch: Throwable -> L16
        monitor-exit(this);
    }

    private void f() {
    L3:
        if (this.i <= this.g) goto L5;
        c((String) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(this.k.entrySet().iterator().next(), Map.Entry.class, "com.obric.aiagent.plugin")).getKey(), String.class, "com.obric.aiagent.plugin"));
        goto L3
    }

    public void delete() {
        close();
        com.bumptech.glide.a.c.a(this.f3219b);
    }

    private static void a(Writer r2) {
        if (Build.VERSION.SDK_INT >= 26) goto L6;
        r2.close();
        return;
    L6:
        StrictMode.ThreadPolicy r0 = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(r0).permitUnbufferedIo().build());
        r2.close();     // Catch: Throwable -> L10
        StrictMode.setThreadPolicy(r0);
        return;
    L10:
        th = move-exception;
        StrictMode.setThreadPolicy(r0);
        throw th;
    }

    private static void b(Writer r2) {
        if (Build.VERSION.SDK_INT >= 26) goto L6;
        r2.flush();
        return;
    L6:
        StrictMode.ThreadPolicy r0 = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(r0).permitUnbufferedIo().build());
        r2.flush();     // Catch: Throwable -> L10
        StrictMode.setThreadPolicy(r0);
        return;
    L10:
        th = move-exception;
        StrictMode.setThreadPolicy(r0);
        throw th;
    }
}
