package o3;

import com.volcengine.tos.model.acl.ACLConst;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public final class f implements Closeable {
    public static final Pattern o = Pattern.compile("[a-z0-9_-]{1,64}");
    public static final C1759b p = new C1759b();

    /* renamed from: a, reason: collision with root package name */
    public final File f5422a;
    public final File b;
    public final File c;
    public final File d;
    public BufferedWriter i;
    public int k;
    public long h = 0;

    /* renamed from: j, reason: collision with root package name */
    public final LinkedHashMap f5423j = new LinkedHashMap(0, 0.75f, true);
    public long l = 0;
    public final ThreadPoolExecutor m = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    public final CallableC1758a n = new CallableC1758a(this);
    public final int e = 1;
    public final int g = 1;
    public final long f = 8388608;

    public f(File file) {
        this.f5422a = file;
        this.b = new File(file, "journal");
        this.c = new File(file, "journal.tmp");
        this.d = new File(file, "journal.bkp");
    }

    public static void E(File file, File file2, boolean z10) throws IOException {
        if (z10) {
            c(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public static void G(String str) {
        if (!o.matcher(str).matches()) {
            throw new IllegalArgumentException(B7.a.m("keys must match regex [a-z0-9_-]{1,64}: \"", str, "\""));
        }
    }

    public static void b(f fVar, R5.b bVar, boolean z10) {
        synchronized (fVar) {
            C1761d c1761d = (C1761d) bVar.b;
            if (c1761d.d != bVar) {
                throw new IllegalStateException();
            }
            if (z10 && !c1761d.c) {
                for (int i = 0; i < fVar.g; i++) {
                    if (!((boolean[]) bVar.c)[i]) {
                        bVar.b();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                    }
                    if (!c1761d.b(i).exists()) {
                        bVar.b();
                        return;
                    }
                }
            }
            for (int i6 = 0; i6 < fVar.g; i6++) {
                File fileB = c1761d.b(i6);
                if (!z10) {
                    c(fileB);
                } else if (fileB.exists()) {
                    File fileA = c1761d.a(i6);
                    fileB.renameTo(fileA);
                    long j5 = c1761d.b[i6];
                    long length = fileA.length();
                    c1761d.b[i6] = length;
                    fVar.h = (fVar.h - j5) + length;
                }
            }
            fVar.k++;
            c1761d.d = null;
            if (c1761d.c || z10) {
                c1761d.c = true;
                fVar.i.write("CLEAN " + c1761d.f5420a + c1761d.c() + '\n');
                if (z10) {
                    fVar.l++;
                }
            } else {
                fVar.f5423j.remove(c1761d.f5420a);
                fVar.i.write("REMOVE " + c1761d.f5420a + '\n');
            }
            fVar.i.flush();
            if (fVar.h > fVar.f || fVar.i()) {
                fVar.m.submit(fVar.n);
            }
        }
    }

    public static void c(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public static f k(File file) throws IOException {
        File file2 = new File(file, "journal.bkp");
        if (file2.exists()) {
            File file3 = new File(file, "journal");
            if (file3.exists()) {
                file2.delete();
            } else {
                E(file2, file3, false);
            }
        }
        f fVar = new f(file);
        File file4 = fVar.b;
        if (file4.exists()) {
            try {
                fVar.n();
                fVar.l();
                fVar.i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file4, true), i.f5426a));
                return fVar;
            } catch (IOException e) {
                System.out.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                fVar.close();
                i.b(fVar.f5422a);
            }
        }
        file.mkdirs();
        f fVar2 = new f(file);
        fVar2.s();
        return fVar2;
    }

    public final void F() {
        while (this.h > this.f) {
            w((String) ((Map.Entry) this.f5423j.entrySet().iterator().next()).getKey());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        try {
            if (this.i == null) {
                return;
            }
            Iterator it = new ArrayList(this.f5423j.values()).iterator();
            while (it.hasNext()) {
                R5.b bVar = ((C1761d) it.next()).d;
                if (bVar != null) {
                    bVar.b();
                }
            }
            F();
            this.i.close();
            this.i = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final R5.b f(String str) {
        synchronized (this) {
            try {
                if (this.i == null) {
                    throw new IllegalStateException("cache is closed");
                }
                G(str);
                C1761d c1761d = (C1761d) this.f5423j.get(str);
                if (c1761d == null) {
                    c1761d = new C1761d(this, str);
                    this.f5423j.put(str, c1761d);
                } else if (c1761d.d != null) {
                    return null;
                }
                R5.b bVar = new R5.b(this, c1761d);
                c1761d.d = bVar;
                this.i.write("DIRTY " + str + '\n');
                this.i.flush();
                return bVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized e g(String str) {
        InputStream inputStream;
        if (this.i == null) {
            throw new IllegalStateException("cache is closed");
        }
        G(str);
        C1761d c1761d = (C1761d) this.f5423j.get(str);
        if (c1761d == null) {
            return null;
        }
        if (!c1761d.c) {
            return null;
        }
        InputStream[] inputStreamArr = new InputStream[this.g];
        for (int i = 0; i < this.g; i++) {
            try {
                inputStreamArr[i] = new FileInputStream(c1761d.a(i));
            } catch (FileNotFoundException unused) {
                for (int i6 = 0; i6 < this.g && (inputStream = inputStreamArr[i6]) != null; i6++) {
                    i.a(inputStream);
                }
                return null;
            }
        }
        this.k++;
        this.i.append((CharSequence) ("READ " + str + '\n'));
        if (i()) {
            this.m.submit(this.n);
        }
        return new e(inputStreamArr);
    }

    public final boolean i() {
        int i = this.k;
        return i >= 2000 && i >= this.f5423j.size();
    }

    public final void l() throws IOException {
        c(this.c);
        Iterator it = this.f5423j.values().iterator();
        while (it.hasNext()) {
            C1761d c1761d = (C1761d) it.next();
            R5.b bVar = c1761d.d;
            int i = this.g;
            int i6 = 0;
            if (bVar == null) {
                while (i6 < i) {
                    this.h += c1761d.b[i6];
                    i6++;
                }
            } else {
                c1761d.d = null;
                while (i6 < i) {
                    c(c1761d.a(i6));
                    c(c1761d.b(i6));
                    i6++;
                }
                it.remove();
            }
        }
    }

    public final void n() throws IOException {
        h hVar = new h(new FileInputStream(this.b), i.f5426a);
        try {
            String strB = hVar.b();
            String strB2 = hVar.b();
            String strB3 = hVar.b();
            String strB4 = hVar.b();
            String strB5 = hVar.b();
            if (!"libcore.io.DiskLruCache".equals(strB) || !"1".equals(strB2) || !Integer.toString(this.e).equals(strB3) || !Integer.toString(this.g).equals(strB4) || !"".equals(strB5)) {
                throw new IOException("unexpected journal header: [" + strB + ", " + strB2 + ", " + strB4 + ", " + strB5 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    r(hVar.b());
                    i++;
                } catch (EOFException unused) {
                    this.k = i - this.f5423j.size();
                    i.a(hVar);
                    return;
                }
            }
        } catch (Throwable th) {
            i.a(hVar);
            throw th;
        }
    }

    public final void r(String str) throws IOException {
        String strSubstring;
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            throw new IOException("unexpected journal line: ".concat(str));
        }
        int i = iIndexOf + 1;
        int iIndexOf2 = str.indexOf(32, i);
        LinkedHashMap linkedHashMap = this.f5423j;
        if (iIndexOf2 == -1) {
            strSubstring = str.substring(i);
            if (iIndexOf == 6 && str.startsWith("REMOVE")) {
                linkedHashMap.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i, iIndexOf2);
        }
        C1761d c1761d = (C1761d) linkedHashMap.get(strSubstring);
        if (c1761d == null) {
            c1761d = new C1761d(this, strSubstring);
            linkedHashMap.put(strSubstring, c1761d);
        }
        if (iIndexOf2 == -1 || iIndexOf != 5 || !str.startsWith("CLEAN")) {
            if (iIndexOf2 == -1 && iIndexOf == 5 && str.startsWith("DIRTY")) {
                c1761d.d = new R5.b(this, c1761d);
                return;
            } else {
                if (iIndexOf2 != -1 || iIndexOf != 4 || !str.startsWith(ACLConst.PERMISSION_TYPE_READ)) {
                    throw new IOException("unexpected journal line: ".concat(str));
                }
                return;
            }
        }
        String[] strArrSplit = str.substring(iIndexOf2 + 1).split(" ");
        c1761d.c = true;
        c1761d.d = null;
        if (strArrSplit.length != c1761d.e.g) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArrSplit));
        }
        for (int i6 = 0; i6 < strArrSplit.length; i6++) {
            try {
                c1761d.b[i6] = Long.parseLong(strArrSplit[i6]);
            } catch (NumberFormatException unused) {
                throw new IOException("unexpected journal line: " + Arrays.toString(strArrSplit));
            }
        }
    }

    public final synchronized void s() {
        try {
            BufferedWriter bufferedWriter = this.i;
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.c), i.f5426a));
            try {
                bufferedWriter2.write("libcore.io.DiskLruCache");
                bufferedWriter2.write("\n");
                bufferedWriter2.write("1");
                bufferedWriter2.write("\n");
                bufferedWriter2.write(Integer.toString(this.e));
                bufferedWriter2.write("\n");
                bufferedWriter2.write(Integer.toString(this.g));
                bufferedWriter2.write("\n");
                bufferedWriter2.write("\n");
                for (C1761d c1761d : this.f5423j.values()) {
                    if (c1761d.d != null) {
                        bufferedWriter2.write("DIRTY " + c1761d.f5420a + '\n');
                    } else {
                        bufferedWriter2.write("CLEAN " + c1761d.f5420a + c1761d.c() + '\n');
                    }
                }
                bufferedWriter2.close();
                if (this.b.exists()) {
                    E(this.b, this.d, true);
                }
                E(this.c, this.b, false);
                this.d.delete();
                this.i = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.b, true), i.f5426a));
            } catch (Throwable th) {
                bufferedWriter2.close();
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void w(String str) {
        try {
            if (this.i == null) {
                throw new IllegalStateException("cache is closed");
            }
            G(str);
            C1761d c1761d = (C1761d) this.f5423j.get(str);
            if (c1761d != null && c1761d.d == null) {
                for (int i = 0; i < this.g; i++) {
                    File fileA = c1761d.a(i);
                    if (fileA.exists() && !fileA.delete()) {
                        throw new IOException("failed to delete " + fileA);
                    }
                    long j5 = this.h;
                    long[] jArr = c1761d.b;
                    this.h = j5 - jArr[i];
                    jArr[i] = 0;
                }
                this.k++;
                this.i.append((CharSequence) ("REMOVE " + str + '\n'));
                this.f5423j.remove(str);
                if (i()) {
                    this.m.submit(this.n);
                }
            }
        } finally {
        }
    }
}
