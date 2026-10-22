package w0;

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
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.libpag.BuildConfig;

/* renamed from: w0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1200a implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    private final File f23485a;

    /* renamed from: b, reason: collision with root package name */
    private final File f23486b;

    /* renamed from: c, reason: collision with root package name */
    private final File f23487c;

    /* renamed from: d, reason: collision with root package name */
    private final File f23488d;

    /* renamed from: e, reason: collision with root package name */
    private final int f23489e;

    /* renamed from: f, reason: collision with root package name */
    private long f23490f;

    /* renamed from: g, reason: collision with root package name */
    private final int f23491g;

    /* renamed from: i, reason: collision with root package name */
    private Writer f23493i;

    /* renamed from: k, reason: collision with root package name */
    private int f23495k;

    /* renamed from: h, reason: collision with root package name */
    private long f23492h = 0;

    /* renamed from: j, reason: collision with root package name */
    private final LinkedHashMap<String, d> f23494j = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: l, reason: collision with root package name */
    private long f23496l = 0;

    /* renamed from: m, reason: collision with root package name */
    final ThreadPoolExecutor f23497m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b(null));

    /* renamed from: n, reason: collision with root package name */
    private final Callable<Void> f23498n = new CallableC0255a();

    /* renamed from: w0.a$a, reason: collision with other inner class name */
    class CallableC0255a implements Callable<Void> {
        CallableC0255a() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() {
            synchronized (C1200a.this) {
                try {
                    if (C1200a.this.f23493i == null) {
                        return null;
                    }
                    C1200a.this.W();
                    if (C1200a.this.I()) {
                        C1200a.this.T();
                        C1200a.this.f23495k = 0;
                    }
                    return null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* renamed from: w0.a$b */
    private static final class b implements ThreadFactory {
        private b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }

        /* synthetic */ b(CallableC0255a callableC0255a) {
            this();
        }
    }

    /* renamed from: w0.a$c */
    public final class c {

        /* renamed from: a, reason: collision with root package name */
        private final d f23500a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean[] f23501b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f23502c;

        /* synthetic */ c(C1200a c1200a, d dVar, CallableC0255a callableC0255a) {
            this(dVar);
        }

        public void a() {
            C1200a.this.x(this, false);
        }

        public void b() {
            if (this.f23502c) {
                return;
            }
            try {
                a();
            } catch (IOException unused) {
            }
        }

        public void e() {
            C1200a.this.x(this, true);
            this.f23502c = true;
        }

        public File f(int i5) {
            File fileK;
            synchronized (C1200a.this) {
                try {
                    if (this.f23500a.f23509f != this) {
                        throw new IllegalStateException();
                    }
                    if (!this.f23500a.f23508e) {
                        this.f23501b[i5] = true;
                    }
                    fileK = this.f23500a.k(i5);
                    if (!C1200a.this.f23485a.exists()) {
                        C1200a.this.f23485a.mkdirs();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return fileK;
        }

        private c(d dVar) {
            this.f23500a = dVar;
            this.f23501b = dVar.f23508e ? null : new boolean[C1200a.this.f23491g];
        }
    }

    /* renamed from: w0.a$d */
    private final class d {

        /* renamed from: a, reason: collision with root package name */
        private final String f23504a;

        /* renamed from: b, reason: collision with root package name */
        private final long[] f23505b;

        /* renamed from: c, reason: collision with root package name */
        File[] f23506c;

        /* renamed from: d, reason: collision with root package name */
        File[] f23507d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f23508e;

        /* renamed from: f, reason: collision with root package name */
        private c f23509f;

        /* renamed from: g, reason: collision with root package name */
        private long f23510g;

        /* synthetic */ d(C1200a c1200a, String str, CallableC0255a callableC0255a) {
            this(str);
        }

        private IOException m(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(String[] strArr) throws IOException {
            if (strArr.length != C1200a.this.f23491g) {
                throw m(strArr);
            }
            for (int i5 = 0; i5 < strArr.length; i5++) {
                try {
                    this.f23505b[i5] = Long.parseLong(strArr[i5]);
                } catch (NumberFormatException unused) {
                    throw m(strArr);
                }
            }
        }

        public File j(int i5) {
            return this.f23506c[i5];
        }

        public File k(int i5) {
            return this.f23507d[i5];
        }

        public String l() {
            StringBuilder sb = new StringBuilder();
            for (long j5 : this.f23505b) {
                sb.append(' ');
                sb.append(j5);
            }
            return sb.toString();
        }

        private d(String str) {
            this.f23504a = str;
            this.f23505b = new long[C1200a.this.f23491g];
            this.f23506c = new File[C1200a.this.f23491g];
            this.f23507d = new File[C1200a.this.f23491g];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i5 = 0; i5 < C1200a.this.f23491g; i5++) {
                sb.append(i5);
                this.f23506c[i5] = new File(C1200a.this.f23485a, sb.toString());
                sb.append(".tmp");
                this.f23507d[i5] = new File(C1200a.this.f23485a, sb.toString());
                sb.setLength(length);
            }
        }
    }

    /* renamed from: w0.a$e */
    public final class e {

        /* renamed from: a, reason: collision with root package name */
        private final String f23512a;

        /* renamed from: b, reason: collision with root package name */
        private final long f23513b;

        /* renamed from: c, reason: collision with root package name */
        private final long[] f23514c;

        /* renamed from: d, reason: collision with root package name */
        private final File[] f23515d;

        /* synthetic */ e(C1200a c1200a, String str, long j5, File[] fileArr, long[] jArr, CallableC0255a callableC0255a) {
            this(str, j5, fileArr, jArr);
        }

        public File a(int i5) {
            return this.f23515d[i5];
        }

        private e(String str, long j5, File[] fileArr, long[] jArr) {
            this.f23512a = str;
            this.f23513b = j5;
            this.f23515d = fileArr;
            this.f23514c = jArr;
        }
    }

    private C1200a(File file, int i5, int i6, long j5) {
        this.f23485a = file;
        this.f23489e = i5;
        this.f23486b = new File(file, "journal");
        this.f23487c = new File(file, "journal.tmp");
        this.f23488d = new File(file, "journal.bkp");
        this.f23491g = i6;
        this.f23490f = j5;
    }

    private static void C(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private synchronized c E(String str, long j5) {
        w();
        d dVar = this.f23494j.get(str);
        CallableC0255a callableC0255a = null;
        if (j5 != -1 && (dVar == null || dVar.f23510g != j5)) {
            return null;
        }
        if (dVar == null) {
            dVar = new d(this, str, callableC0255a);
            this.f23494j.put(str, dVar);
        } else if (dVar.f23509f != null) {
            return null;
        }
        c cVar = new c(this, dVar, callableC0255a);
        dVar.f23509f = cVar;
        this.f23493i.append((CharSequence) "DIRTY");
        this.f23493i.append(' ');
        this.f23493i.append((CharSequence) str);
        this.f23493i.append('\n');
        this.f23493i.flush();
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean I() {
        int i5 = this.f23495k;
        return i5 >= 2000 && i5 >= this.f23494j.size();
    }

    public static C1200a L(File file, int i5, int i6, long j5) throws IOException {
        if (j5 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        if (i6 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        }
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                V(file2, file3, false);
            }
        }
        C1200a c1200a = new C1200a(file, i5, i6, j5);
        if (c1200a.f23486b.exists()) {
            try {
                c1200a.O();
                c1200a.N();
                return c1200a;
            } catch (IOException e6) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e6.getMessage() + ", removing");
                c1200a.A();
            }
        }
        file.mkdirs();
        C1200a c1200a2 = new C1200a(file, i5, i6, j5);
        c1200a2.T();
        return c1200a2;
    }

    private void N() throws IOException {
        C(this.f23487c);
        Iterator<d> it = this.f23494j.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            int i5 = 0;
            if (next.f23509f == null) {
                while (i5 < this.f23491g) {
                    this.f23492h += next.f23505b[i5];
                    i5++;
                }
            } else {
                next.f23509f = null;
                while (i5 < this.f23491g) {
                    C(next.j(i5));
                    C(next.k(i5));
                    i5++;
                }
                it.remove();
            }
        }
    }

    private void O() throws IOException {
        C1201b c1201b = new C1201b(new FileInputStream(this.f23486b), w0.c.f23523a);
        try {
            String strM = c1201b.m();
            String strM2 = c1201b.m();
            String strM3 = c1201b.m();
            String strM4 = c1201b.m();
            String strM5 = c1201b.m();
            if (!"libcore.io.DiskLruCache".equals(strM) || !"1".equals(strM2) || !Integer.toString(this.f23489e).equals(strM3) || !Integer.toString(this.f23491g).equals(strM4) || !BuildConfig.FLAVOR.equals(strM5)) {
                throw new IOException("unexpected journal header: [" + strM + ", " + strM2 + ", " + strM4 + ", " + strM5 + "]");
            }
            int i5 = 0;
            while (true) {
                try {
                    S(c1201b.m());
                    i5++;
                } catch (EOFException unused) {
                    this.f23495k = i5 - this.f23494j.size();
                    if (c1201b.f()) {
                        T();
                    } else {
                        this.f23493i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f23486b, true), w0.c.f23523a));
                    }
                    w0.c.a(c1201b);
                    return;
                }
            }
        } catch (Throwable th) {
            w0.c.a(c1201b);
            throw th;
        }
    }

    private void S(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        int i5 = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i5);
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i5);
            if (iIndexOf == 6 && str.startsWith("REMOVE")) {
                this.f23494j.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i5, iIndexOf2);
        }
        d dVar = this.f23494j.get(strSubstring);
        CallableC0255a callableC0255a = null;
        if (dVar == null) {
            dVar = new d(this, strSubstring, callableC0255a);
            this.f23494j.put(strSubstring, dVar);
        }
        if (iIndexOf2 != -1 && iIndexOf == 5 && str.startsWith("CLEAN")) {
            String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
            dVar.f23508e = true;
            dVar.f23509f = null;
            dVar.n(strArrSplit);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
            dVar.f23509f = new c(this, dVar, callableC0255a);
            return;
        }
        if (iIndexOf2 == -1 && iIndexOf == 4 && str.startsWith("READ")) {
            return;
        }
        throw new IOException("unexpected journal line: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void T() {
        try {
            Writer writer = this.f23493i;
            if (writer != null) {
                writer.close();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f23487c), w0.c.f23523a));
            try {
                bufferedWriter.write("libcore.io.DiskLruCache");
                bufferedWriter.write("\n");
                bufferedWriter.write("1");
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.f23489e));
                bufferedWriter.write("\n");
                bufferedWriter.write(Integer.toString(this.f23491g));
                bufferedWriter.write("\n");
                bufferedWriter.write("\n");
                for (d dVar : this.f23494j.values()) {
                    if (dVar.f23509f != null) {
                        bufferedWriter.write("DIRTY " + dVar.f23504a + '\n');
                    } else {
                        bufferedWriter.write("CLEAN " + dVar.f23504a + dVar.l() + '\n');
                    }
                }
                bufferedWriter.close();
                if (this.f23486b.exists()) {
                    V(this.f23486b, this.f23488d, true);
                }
                V(this.f23487c, this.f23486b, false);
                this.f23488d.delete();
                this.f23493i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f23486b, true), w0.c.f23523a));
            } catch (Throwable th) {
                bufferedWriter.close();
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private static void V(File file, File file2, boolean z5) throws IOException {
        if (z5) {
            C(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        while (this.f23492h > this.f23490f) {
            U(this.f23494j.entrySet().iterator().next().getKey());
        }
    }

    private void w() {
        if (this.f23493i == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void x(c cVar, boolean z5) {
        d dVar = cVar.f23500a;
        if (dVar.f23509f != cVar) {
            throw new IllegalStateException();
        }
        if (z5 && !dVar.f23508e) {
            for (int i5 = 0; i5 < this.f23491g; i5++) {
                if (!cVar.f23501b[i5]) {
                    cVar.a();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i5);
                }
                if (!dVar.k(i5).exists()) {
                    cVar.a();
                    return;
                }
            }
        }
        for (int i6 = 0; i6 < this.f23491g; i6++) {
            File fileK = dVar.k(i6);
            if (!z5) {
                C(fileK);
            } else if (fileK.exists()) {
                File fileJ = dVar.j(i6);
                fileK.renameTo(fileJ);
                long j5 = dVar.f23505b[i6];
                long length = fileJ.length();
                dVar.f23505b[i6] = length;
                this.f23492h = (this.f23492h - j5) + length;
            }
        }
        this.f23495k++;
        dVar.f23509f = null;
        if (dVar.f23508e || z5) {
            dVar.f23508e = true;
            this.f23493i.append((CharSequence) "CLEAN");
            this.f23493i.append(' ');
            this.f23493i.append((CharSequence) dVar.f23504a);
            this.f23493i.append((CharSequence) dVar.l());
            this.f23493i.append('\n');
            if (z5) {
                long j6 = this.f23496l;
                this.f23496l = 1 + j6;
                dVar.f23510g = j6;
            }
        } else {
            this.f23494j.remove(dVar.f23504a);
            this.f23493i.append((CharSequence) "REMOVE");
            this.f23493i.append(' ');
            this.f23493i.append((CharSequence) dVar.f23504a);
            this.f23493i.append('\n');
        }
        this.f23493i.flush();
        if (this.f23492h > this.f23490f || I()) {
            this.f23497m.submit(this.f23498n);
        }
    }

    public void A() throws IOException {
        close();
        w0.c.b(this.f23485a);
    }

    public c D(String str) {
        return E(str, -1L);
    }

    public synchronized e G(String str) {
        C1200a c1200a;
        Throwable th;
        try {
            try {
                w();
                d dVar = this.f23494j.get(str);
                if (dVar == null) {
                    return null;
                }
                if (!dVar.f23508e) {
                    return null;
                }
                for (File file : dVar.f23506c) {
                    try {
                        if (!file.exists()) {
                            return null;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        c1200a = this;
                        throw th;
                    }
                }
                this.f23495k++;
                this.f23493i.append((CharSequence) "READ");
                this.f23493i.append(' ');
                this.f23493i.append((CharSequence) str);
                this.f23493i.append('\n');
                if (I()) {
                    this.f23497m.submit(this.f23498n);
                }
                return new e(this, str, dVar.f23510g, dVar.f23506c, dVar.f23505b, null);
            } catch (Throwable th3) {
                th = th3;
                th = th;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            c1200a = this;
            th = th;
            throw th;
        }
    }

    public synchronized boolean U(String str) {
        try {
            w();
            d dVar = this.f23494j.get(str);
            if (dVar != null && dVar.f23509f == null) {
                for (int i5 = 0; i5 < this.f23491g; i5++) {
                    File fileJ = dVar.j(i5);
                    if (fileJ.exists() && !fileJ.delete()) {
                        throw new IOException("failed to delete " + fileJ);
                    }
                    this.f23492h -= dVar.f23505b[i5];
                    dVar.f23505b[i5] = 0;
                }
                this.f23495k++;
                this.f23493i.append((CharSequence) "REMOVE");
                this.f23493i.append(' ');
                this.f23493i.append((CharSequence) str);
                this.f23493i.append('\n');
                this.f23494j.remove(str);
                if (I()) {
                    this.f23497m.submit(this.f23498n);
                }
                return true;
            }
            return false;
        } finally {
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        try {
            if (this.f23493i == null) {
                return;
            }
            ArrayList arrayList = new ArrayList(this.f23494j.values());
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                Object obj = arrayList.get(i5);
                i5++;
                d dVar = (d) obj;
                if (dVar.f23509f != null) {
                    dVar.f23509f.a();
                }
            }
            W();
            this.f23493i.close();
            this.f23493i = null;
        } catch (Throwable th) {
            throw th;
        }
    }
}
