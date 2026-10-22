package com.amap.api.col.jmsl;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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

/* loaded from: classes.dex */
public final class C0 implements Closeable {

    /* renamed from: o, reason: collision with root package name */
    public static final Pattern f15938o = Pattern.compile("[a-z0-9_-]{1,120}");

    /* renamed from: p, reason: collision with root package name */
    public static final Charset f15939p = Charset.forName("US-ASCII");

    /* renamed from: q, reason: collision with root package name */
    public static final ThreadFactory f15940q;

    /* renamed from: r, reason: collision with root package name */
    public static ThreadPoolExecutor f15941r;

    /* renamed from: s, reason: collision with root package name */
    public static final OutputStream f15942s;

    /* renamed from: a, reason: collision with root package name */
    public final File f15943a;

    /* renamed from: b, reason: collision with root package name */
    public final File f15944b;

    /* renamed from: c, reason: collision with root package name */
    public final File f15945c;

    /* renamed from: d, reason: collision with root package name */
    public final File f15946d;

    /* renamed from: e, reason: collision with root package name */
    public final int f15947e;

    /* renamed from: f, reason: collision with root package name */
    public long f15948f;

    /* renamed from: g, reason: collision with root package name */
    public final int f15949g;

    /* renamed from: i, reason: collision with root package name */
    public Writer f15951i;

    /* renamed from: l, reason: collision with root package name */
    public int f15954l;

    /* renamed from: h, reason: collision with root package name */
    public long f15950h = 0;

    /* renamed from: j, reason: collision with root package name */
    public int f15952j = 1000;

    /* renamed from: k, reason: collision with root package name */
    public final LinkedHashMap<String, f> f15953k = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: m, reason: collision with root package name */
    public long f15955m = 0;

    /* renamed from: n, reason: collision with root package name */
    public final Callable<Void> f15956n = new b();

    public static class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicInteger f15957a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "disklrucache#" + this.f15957a.getAndIncrement());
        }
    }

    public class b implements Callable<Void> {
        public b() {
        }

        @Override // java.util.concurrent.Callable
        public final Void call() throws Exception {
            synchronized (C0.this) {
                try {
                    if (C0.this.f15951i == null) {
                        return null;
                    }
                    C0.this.h1();
                    if (C0.this.a1()) {
                        C0.this.N0();
                        C0.I0(C0.this);
                    }
                    return null;
                } finally {
                }
            }
        }
    }

    public static class c extends OutputStream {
        @Override // java.io.OutputStream
        public final void write(int i10) throws IOException {
        }
    }

    public final class d {

        /* renamed from: a, reason: collision with root package name */
        public final f f15959a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean[] f15960b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f15961c;

        public class a extends FilterOutputStream {
            public /* synthetic */ a(d dVar, OutputStream outputStream, byte b10) {
                this(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public final void close() throws IOException {
                try {
                    ((FilterOutputStream) this).out.close();
                } catch (IOException unused) {
                    d.f(d.this);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
            public final void flush() throws IOException {
                try {
                    ((FilterOutputStream) this).out.flush();
                } catch (IOException unused) {
                    d.f(d.this);
                }
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(int i10) throws IOException {
                try {
                    ((FilterOutputStream) this).out.write(i10);
                } catch (IOException unused) {
                    d.f(d.this);
                }
            }

            public a(OutputStream outputStream) {
                super(outputStream);
            }

            @Override // java.io.FilterOutputStream, java.io.OutputStream
            public final void write(byte[] bArr, int i10, int i11) throws IOException {
                try {
                    ((FilterOutputStream) this).out.write(bArr, i10, i11);
                } catch (IOException unused) {
                    d.f(d.this);
                }
            }
        }

        public /* synthetic */ d(C0 c02, f fVar, byte b10) {
            this(fVar);
        }

        public static /* synthetic */ boolean f(d dVar) {
            dVar.f15961c = true;
            return true;
        }

        public final OutputStream b(int i10) throws IOException {
            FileOutputStream fileOutputStream;
            a aVar;
            if (i10 < 0 || i10 >= C0.this.f15949g) {
                throw new IllegalArgumentException("Expected index " + i10 + " to be greater than 0 and less than the maximum value count of " + C0.this.f15949g);
            }
            synchronized (C0.this) {
                try {
                    if (this.f15959a.f15968d != this) {
                        throw new IllegalStateException();
                    }
                    if (!this.f15959a.f15967c) {
                        this.f15960b[i10] = true;
                    }
                    File fileH = this.f15959a.h(i10);
                    try {
                        fileOutputStream = new FileOutputStream(fileH);
                    } catch (FileNotFoundException unused) {
                        C0.this.f15943a.mkdirs();
                        try {
                            fileOutputStream = new FileOutputStream(fileH);
                        } catch (FileNotFoundException unused2) {
                            return C0.f15942s;
                        }
                    }
                    aVar = new a(this, fileOutputStream, (byte) 0);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return aVar;
        }

        public final void c() throws IOException {
            C0.l(C0.this, this, false);
        }

        public final void d() throws IOException {
            if (!this.f15961c) {
                C0.l(C0.this, this, true);
            } else {
                C0.l(C0.this, this, false);
                C0.this.D0(this.f15959a.f15965a);
            }
        }

        public d(f fVar) {
            this.f15959a = fVar;
            this.f15960b = fVar.f15967c ? null : new boolean[C0.this.f15949g];
        }
    }

    public final class e implements Closeable {

        /* renamed from: a, reason: collision with root package name */
        public final InputStream[] f15964a;

        public /* synthetic */ e(C0 c02, String str, long j10, InputStream[] inputStreamArr, long[] jArr, byte b10) {
            this(c02, str, j10, inputStreamArr, jArr);
        }

        public final InputStream b(int i10) {
            return this.f15964a[i10];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            for (InputStream inputStream : this.f15964a) {
                C0.m(inputStream);
            }
        }

        public e(C0 c02, String str, long j10, InputStream[] inputStreamArr, long[] jArr) {
            this.f15964a = inputStreamArr;
        }
    }

    public final class f {

        /* renamed from: a, reason: collision with root package name */
        public final String f15965a;

        /* renamed from: b, reason: collision with root package name */
        public final long[] f15966b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f15967c;

        /* renamed from: d, reason: collision with root package name */
        public d f15968d;

        /* renamed from: e, reason: collision with root package name */
        public long f15969e;

        public /* synthetic */ f(C0 c02, String str, byte b10) {
            this(str);
        }

        public static void e(f fVar, String[] strArr) throws IOException {
            if (strArr.length != C0.this.f15949g) {
                throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
            }
            for (int i10 = 0; i10 < strArr.length; i10++) {
                try {
                    fVar.f15966b[i10] = Long.parseLong(strArr[i10]);
                } catch (NumberFormatException unused) {
                    throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
                }
            }
        }

        public static /* synthetic */ boolean f(f fVar) {
            fVar.f15967c = true;
            return true;
        }

        public final File c(int i10) {
            return new File(C0.this.f15943a, this.f15965a + "." + i10);
        }

        public final String d() throws IOException {
            StringBuilder sb2 = new StringBuilder();
            for (long j10 : this.f15966b) {
                sb2.append(' ');
                sb2.append(j10);
            }
            return sb2.toString();
        }

        public final File h(int i10) {
            return new File(C0.this.f15943a, this.f15965a + "." + i10 + ".tmp");
        }

        public f(String str) {
            this.f15965a = str;
            this.f15966b = new long[C0.this.f15949g];
        }
    }

    static {
        Charset.forName("UTF-8");
        a aVar = new a();
        f15940q = aVar;
        f15941r = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), aVar);
        f15942s = new c();
    }

    public C0(File file, int i10, int i11, long j10) {
        this.f15943a = file;
        this.f15947e = i10;
        this.f15944b = new File(file, "journal");
        this.f15945c = new File(file, "journal.tmp");
        this.f15946d = new File(file, "journal.bkp");
        this.f15949g = i11;
        this.f15948f = j10;
    }

    public static void A(File file, File file2, boolean z10) throws IOException {
        if (z10) {
            n(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public static void G(String str) {
        if (f15938o.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
    }

    public static /* synthetic */ int I0(C0 c02) {
        c02.f15954l = 0;
        return 0;
    }

    public static void Y(File file) throws IOException {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            throw new IOException("not a readable directory: ".concat(String.valueOf(file)));
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                Y(file2);
            }
            if (!file2.delete()) {
                throw new IOException("failed to delete file: ".concat(String.valueOf(file2)));
            }
        }
    }

    public static C0 b(File file, int i10, int i11, long j10) throws IOException {
        if (j10 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i11 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                A(file2, file3, false);
            }
        }
        C0 c02 = new C0(file, i10, i11, j10);
        if (c02.f15944b.exists()) {
            try {
                c02.U();
                c02.g0();
                c02.f15951i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(c02.f15944b, true), f15939p));
                return c02;
            } catch (Throwable unused) {
                c02.close();
                Y(c02.f15943a);
            }
        }
        file.mkdirs();
        C0 c03 = new C0(file, i10, i11, j10);
        c03.N0();
        return c03;
    }

    public static void l(C0 c02, d dVar, boolean z10) throws IOException {
        synchronized (c02) {
            f fVar = dVar.f15959a;
            if (fVar.f15968d != dVar) {
                throw new IllegalStateException();
            }
            if (z10 && !fVar.f15967c) {
                for (int i10 = 0; i10 < c02.f15949g; i10++) {
                    if (!dVar.f15960b[i10]) {
                        dVar.c();
                        throw new IllegalStateException("Newly created entry didn't create value for index ".concat(String.valueOf(i10)));
                    }
                    if (!fVar.h(i10).exists()) {
                        dVar.c();
                        return;
                    }
                }
            }
            for (int i11 = 0; i11 < c02.f15949g; i11++) {
                File fileH = fVar.h(i11);
                if (!z10) {
                    n(fileH);
                } else if (fileH.exists()) {
                    File fileC = fVar.c(i11);
                    fileH.renameTo(fileC);
                    long j10 = fVar.f15966b[i11];
                    long length = fileC.length();
                    fVar.f15966b[i11] = length;
                    c02.f15950h = (c02.f15950h - j10) + length;
                }
            }
            c02.f15954l++;
            fVar.f15968d = null;
            if (fVar.f15967c || z10) {
                f.f(fVar);
                c02.f15951i.write("CLEAN " + fVar.f15965a + fVar.d() + '\n');
                if (z10) {
                    long j11 = c02.f15955m;
                    c02.f15955m = 1 + j11;
                    fVar.f15969e = j11;
                }
            } else {
                c02.f15953k.remove(fVar.f15965a);
                c02.f15951i.write("REMOVE " + fVar.f15965a + '\n');
            }
            c02.f15951i.flush();
            if (c02.f15950h > c02.f15948f || c02.a1()) {
                l1().submit(c02.f15956n);
            }
        }
    }

    public static ThreadPoolExecutor l1() {
        try {
            ThreadPoolExecutor threadPoolExecutor = f15941r;
            if (threadPoolExecutor == null || threadPoolExecutor.isShutdown()) {
                f15941r = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(256), f15940q);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return f15941r;
    }

    public static void m(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e10) {
                throw e10;
            } catch (Exception unused) {
            }
        }
    }

    public static void n(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public final synchronized boolean D0(String str) throws IOException {
        try {
            b1();
            G(str);
            f fVar = this.f15953k.get(str);
            if (fVar != null && fVar.f15968d == null) {
                for (int i10 = 0; i10 < this.f15949g; i10++) {
                    File fileC = fVar.c(i10);
                    if (fileC.exists() && !fileC.delete()) {
                        throw new IOException("failed to delete ".concat(String.valueOf(fileC)));
                    }
                    this.f15950h -= fVar.f15966b[i10];
                    fVar.f15966b[i10] = 0;
                }
                this.f15954l++;
                this.f15951i.append((CharSequence) ("REMOVE " + str + '\n'));
                this.f15953k.remove(str);
                if (a1()) {
                    l1().submit(this.f15956n);
                }
                return true;
            }
            return false;
        } finally {
        }
    }

    public final d J(String str) throws IOException {
        synchronized (this) {
            try {
                b1();
                G(str);
                f fVar = this.f15953k.get(str);
                byte b10 = 0;
                if (fVar == null) {
                    fVar = new f(this, str, b10);
                    this.f15953k.put(str, fVar);
                } else if (fVar.f15968d != null) {
                    return null;
                }
                d dVar = new d(this, fVar, b10);
                fVar.f15968d = dVar;
                this.f15951i.write("DIRTY " + str + '\n');
                this.f15951i.flush();
                return dVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized void N0() throws IOException {
        try {
            Writer writer = this.f15951i;
            if (writer != null) {
                writer.close();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f15945c), f15939p));
            try {
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write("\n");
                bufferedWriter.write("1");
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.f15947e));
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.f15949g));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                for (f fVar : this.f15953k.values()) {
                    if (fVar.f15968d != null) {
                        bufferedWriter.write("DIRTY " + fVar.f15965a + '\n');
                    } else {
                        bufferedWriter.write("CLEAN " + fVar.f15965a + fVar.d() + '\n');
                    }
                }
                bufferedWriter.close();
                if (this.f15944b.exists()) {
                    A(this.f15944b, this.f15946d, true);
                }
                A(this.f15945c, this.f15944b, false);
                this.f15946d.delete();
                this.f15951i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f15944b, true), f15939p));
            } catch (Throwable th) {
                bufferedWriter.close();
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void T0() throws IOException {
        close();
        Y(this.f15943a);
    }

    public final void U() throws IOException {
        String strB;
        String strSubstring;
        L0 l02 = new L0(new FileInputStream(this.f15944b), f15939p);
        try {
            String strB2 = l02.b();
            String strB3 = l02.b();
            String strB4 = l02.b();
            String strB5 = l02.b();
            String strB6 = l02.b();
            if (!"libcore.io.DiskLruCache".equals(strB2) || !"1".equals(strB3) || !Integer.toString(this.f15947e).equals(strB4) || !Integer.toString(this.f15949g).equals(strB5) || !"".equals(strB6)) {
                throw new IOException("unexpected journal header: [" + strB2 + ", " + strB3 + ", " + strB5 + ", " + strB6 + "]");
            }
            byte b10 = 0;
            int i10 = 0;
            while (true) {
                try {
                    strB = l02.b();
                    int iIndexOf = strB.indexOf(32);
                    if (iIndexOf == -1) {
                        throw new IOException("unexpected journal line: ".concat(strB));
                    }
                    int i11 = iIndexOf + 1;
                    int iIndexOf2 = strB.indexOf(32, i11);
                    if (iIndexOf2 == -1) {
                        strSubstring = strB.substring(i11);
                        if (iIndexOf == 6 && strB.startsWith("REMOVE")) {
                            this.f15953k.remove(strSubstring);
                        }
                        i10++;
                    } else {
                        strSubstring = strB.substring(i11, iIndexOf2);
                    }
                    f fVar = this.f15953k.get(strSubstring);
                    if (fVar == null) {
                        fVar = new f(this, strSubstring, b10);
                        this.f15953k.put(strSubstring, fVar);
                    }
                    if (iIndexOf2 != -1 && iIndexOf == 5 && strB.startsWith("CLEAN")) {
                        String[] strArrSplit = strB.substring(iIndexOf2 + 1).split(" ");
                        f.f(fVar);
                        fVar.f15968d = null;
                        f.e(fVar, strArrSplit);
                    } else if (iIndexOf2 == -1 && iIndexOf == 5 && strB.startsWith("DIRTY")) {
                        fVar.f15968d = new d(this, fVar, b10);
                    } else if (iIndexOf2 != -1 || iIndexOf != 4 || !strB.startsWith("READ")) {
                        break;
                    }
                    i10++;
                } catch (EOFException unused) {
                    this.f15954l = i10 - this.f15953k.size();
                    m(l02);
                    return;
                }
            }
            throw new IOException("unexpected journal line: ".concat(strB));
        } catch (Throwable th) {
            m(l02);
            throw th;
        }
    }

    public final boolean a1() {
        int i10 = this.f15954l;
        return i10 >= 2000 && i10 >= this.f15953k.size();
    }

    public final void b1() {
        if (this.f15951i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        try {
            if (this.f15951i == null) {
                return;
            }
            Iterator it = new ArrayList(this.f15953k.values()).iterator();
            while (it.hasNext()) {
                f fVar = (f) it.next();
                if (fVar.f15968d != null) {
                    fVar.f15968d.c();
                }
            }
            h1();
            this.f15951i.close();
            this.f15951i = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6, types: [int] */
    /* JADX WARN: Type inference failed for: r4v9, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.io.InputStream[]] */
    public final synchronized e e0(String str) throws Throwable {
        ?? fileInputStream;
        Throwable th;
        C0 c02;
        f fVar;
        ?? r11;
        try {
            b1();
            G(str);
            fVar = this.f15953k.get(str);
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = this;
        }
        if (fVar == null) {
            return null;
        }
        if (!fVar.f15967c) {
            return null;
        }
        ?? r82 = new InputStream[this.f15949g];
        int i10 = 0;
        while (true) {
            try {
                try {
                    fileInputStream = this.f15949g;
                    if (i10 >= fileInputStream) {
                        break;
                    }
                    try {
                        fileInputStream = new FileInputStream(fVar.c(i10));
                        r82[i10] = fileInputStream;
                        i10++;
                    } catch (Throwable th3) {
                        th = th3;
                        c02 = this;
                    }
                    th = th3;
                    c02 = this;
                } catch (FileNotFoundException unused) {
                    for (int i11 = 0; i11 < this.f15949g && (r11 = r82[i11]) != 0; i11++) {
                        m(r11);
                    }
                    return null;
                }
            } catch (Throwable th4) {
                th = th4;
                th = th;
                c02 = fileInputStream;
                throw th;
            }
            throw th;
        }
        this.f15954l++;
        this.f15951i.append((CharSequence) ("READ " + str + '\n'));
        if (a1()) {
            l1().submit(this.f15956n);
        }
        return new e(this, str, fVar.f15969e, r82, fVar.f15966b, (byte) 0);
    }

    public final synchronized void f1() throws IOException {
        b1();
        h1();
        this.f15951i.flush();
    }

    public final void g0() throws IOException {
        n(this.f15945c);
        Iterator<f> it = this.f15953k.values().iterator();
        while (it.hasNext()) {
            f next = it.next();
            int i10 = 0;
            if (next.f15968d == null) {
                while (i10 < this.f15949g) {
                    this.f15950h += next.f15966b[i10];
                    i10++;
                }
            } else {
                next.f15968d = null;
                while (i10 < this.f15949g) {
                    n(next.c(i10));
                    n(next.h(i10));
                    i10++;
                }
                it.remove();
            }
        }
    }

    public final void h1() throws IOException {
        while (true) {
            if (this.f15950h <= this.f15948f && this.f15953k.size() <= this.f15952j) {
                return;
            } else {
                D0(this.f15953k.entrySet().iterator().next().getKey());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0004 A[PHI: r0
      0x0004: PHI (r0v2 int) = (r0v0 int), (r0v1 int) binds: [B:3:0x0002, B:6:0x0008] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i(int r2) {
        /*
            r1 = this;
            r0 = 10
            if (r2 >= r0) goto L6
        L4:
            r2 = r0
            goto Lb
        L6:
            r0 = 10000(0x2710, float:1.4013E-41)
            if (r2 <= r0) goto Lb
            goto L4
        Lb:
            r1.f15952j = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.jmsl.C0.i(int):void");
    }

    public final File k1() {
        return this.f15943a;
    }
}
