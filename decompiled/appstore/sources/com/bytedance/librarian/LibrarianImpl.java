package com.bytedance.librarian;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.bytedance.librarian.elf.e;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes.dex */
public class LibrarianImpl {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final LibrarianImpl f7661m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String[] f7662n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f7663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.librarian.b f7664b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f7665c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final File f7666d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f7667e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public File f7668f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ZipFile[] f7669g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f7670h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ApplicationInfo f7671i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Map f7672j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String[] f7673k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f7674l;

    public interface Constants {
        public static final int BUFFER_SIZE = 8192;
        public static final String DEFAULT_VERSION = "default.version";
        public static final String DOT = ".";
        public static final String LIB_PREFIX = "lib";
        public static final String LOCK_FILE_NAME = "process.lock";
        public static final int MAX_EXTRACT_ATTEMPTS = 3;
        public static final String SEPARATOR = "/";
        public static final String SO_SUFFIX = ".so";
        public static final String TAG = "librarian";
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f7675a;

        public a() {
            this.f7675a = false;
        }

        public String toString() {
            return Boolean.toString(this.f7675a);
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RandomAccessFile f7676a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public FileLock f7677b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public FileChannel f7678c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public File f7679d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ LibrarianImpl f7680e;

        public b(LibrarianImpl r10, File r11) {
            this.f7680e = r10;
            this.f7679d = r11;
        }

        public void a() {
            FileLock r10 = this.f7677b;
            if (r10 != null) goto L8;
        L5:
            LibrarianImpl.a(this.f7680e).a("released lock " + this.f7679d.getPath());
            LibrarianImpl.b(this.f7680e, this.f7678c);
            LibrarianImpl.b(this.f7680e, this.f7676a);
            return;
        L8:
            r10.release();     // Catch: IOException -> L7
            goto L5
        }

        public void b() {
            RandomAccessFile r10 = new RandomAccessFile(this.f7679d, "rw");
            this.f7676a = r10;
            this.f7678c = r10.getChannel();     // Catch: IOException -> L7
            LibrarianImpl.a(this.f7680e).a("blocking on lock " + this.f7679d.getPath());     // Catch: IOException -> L9
            this.f7677b = this.f7678c.lock();     // Catch: IOException -> L9
            LibrarianImpl.a(this.f7680e).a("acquired on lock " + this.f7679d.getPath());     // Catch: IOException -> L7
            return;
        L9:
            e = move-exception;
            LibrarianImpl.b(this.f7680e, this.f7678c);     // Catch: IOException -> L7
            throw e;     // Catch: IOException -> L7
        L7:
            e = move-exception;
            LibrarianImpl.b(this.f7680e, this.f7676a);
            throw e;
        }
    }

    static {
        f7662n = new String[]{"log", "m", "stdc++", "dl", "c", "z", "android", "jnigraphics", "EGL", "GLESv1_CM", "GLESv2", "GLESv3", "OpenSLES", "OpenMAXAL"};
        Context r10 = com.bytedance.librarian.a.f7681a;
        com.bytedance.librarian.a.f7681a = null;
        if (r10 == null) goto L35;
        ApplicationInfo r11 = r10.getApplicationInfo();
        File r12 = r10.getDir(Constants.TAG, 0);
        if (r12.exists() == true) goto L8;
        r12.mkdirs();
    L8:
        if (com.bytedance.librarian.a.f7682b == null) goto L10;
        String r13 = com.bytedance.librarian.a.f7682b;
    L11:
        File r14 = new File(r12, r13 + Constants.DOT + (new File(r11.sourceDir).lastModified() >> 8));
        File[] r15 = r12.listFiles();
        if (r15 == null) goto L25;
        int r16 = r15.length;
        int r17 = 0;
    L14:
        if (r17 >= r16) goto L25;
        File r18 = r15[r17];
        if (r14.getName().equals(r18.getName()) == true) goto L24;
        File[] r19 = r18.listFiles();
        if (r19 == null) goto L23;
        int r20 = r19.length;
        int r110 = 0;
    L21:
        if (r110 >= r20) goto L23;
        r19[r110].delete();
        r110 = r110 + 1;
    L23:
        r18.delete();
    L24:
        r17 = r17 + 1;
    L25:
        r14.mkdirs();
        if (r14.exists() == false) goto L32;
        com.bytedance.librarian.b r21 = com.bytedance.librarian.a.f7683c;
        if (r21 != null) goto L31;
        r21 = new com.bytedance.librarian.b();
    L31:
        f7661m = new LibrarianImpl(r11, r14, r21);
        return;
    L32:
        f7661m = null;
        return;
    L10:
        r13 = Constants.DEFAULT_VERSION;
        goto L11
    L35:
        throw new LibrarianUnsatisfiedLinkError("you should call init first or use loadLibraryForModule.");
    }

    public LibrarianImpl(ApplicationInfo r10, File r11, com.bytedance.librarian.b r12) {
        this.f7663a = r11;
        this.f7664b = r12;
        this.f7671i = r10;
        this.f7666d = new File(r11, Constants.LOCK_FILE_NAME);
        this.f7665c = new HashMap();
    }

    public static /* synthetic */ com.bytedance.librarian.b a(LibrarianImpl r10) {
        return r10.f7664b;
    }

    public static /* synthetic */ void b(LibrarianImpl r10, Closeable r11) {
        r10.f(r11);
    }

    public static String k(String r10) {
        return Constants.LIB_PREFIX + r10 + Constants.SO_SUFFIX;
    }

    public final void c() {
        if (this.f7667e == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L7:
        if (this.f7667e == true) goto L34;
        File r10 = new File(this.f7671i.sourceDir);     // Catch: Throwable -> L15
        ArrayList r11 = new ArrayList();     // Catch: Throwable -> L15
        r11.add(r10);     // Catch: Throwable -> L15
        String[] r12 = this.f7671i.splitSourceDirs;     // Catch: Throwable -> L15
        int r13 = 0;
        if (r12 != null) goto L11;
    L17:
        ZipFile[] r14 = new ZipFile[r11.size()];     // Catch: Throwable -> L15
        Iterator r15 = r11.iterator();     // Catch: Throwable -> L15
    L19:
        if (r15.hasNext() == false) goto L27;
        File r16 = (File) r15.next();     // Catch: Throwable -> L15
        int r17 = r13 + 1;
        r14[r13] = new ZipFile(r16);     // Catch: Throwable -> L15 IOException -> L24
    L26:
        r13 = r17;
    L24:
        e = move-exception;
        new LibrarianUnsatisfiedLinkError("fail to get zip file " + r16.getName(), e).printStackTrace();     // Catch: Throwable -> L15
        goto L26
    L27:
        this.f7669g = r14;     // Catch: Throwable -> L15
        this.f7668f = new File(this.f7671i.nativeLibraryDir);     // Catch: Throwable -> L15
        HashMap r18 = new HashMap();     // Catch: Throwable -> L15
        this.f7672j = r18;     // Catch: Throwable -> L15
        r18.put("arm64-v8a", "arm64");     // Catch: Throwable -> L15
        this.f7672j.put("armeabi-v7a", "arm");     // Catch: Throwable -> L15
        this.f7672j.put("armeabi", "arm");     // Catch: Throwable -> L15
        String r19 = null;
        Class<?> r20 = Class.forName("dalvik.system.VMRuntime");     // Catch: Throwable -> L15 Exception -> L31
        r19 = (String) r20.getDeclaredMethod("vmInstructionSet", null).invoke(r20.getDeclaredMethod("getRuntime", null).invoke(null, null), null);     // Catch: Throwable -> L15 Exception -> L31
    L33:
        this.f7670h = r19;     // Catch: Throwable -> L15
        this.f7664b.a("vm instruction set: " + this.f7670h);     // Catch: Throwable -> L15
        this.f7673k = Build.SUPPORTED_ABIS;     // Catch: Throwable -> L15
        this.f7667e = true;     // Catch: Throwable -> L15
        goto L34
    L31:
        e = move-exception;
        this.f7664b.c("fail to get vm instruction set", e);     // Catch: Throwable -> L15
        goto L33
    L11:
        if (r12.length == 0) goto L17;
        int r21 = r12.length;     // Catch: Throwable -> L15
        int r22 = 0;
    L13:
        if (r22 >= r21) goto L17;
        r11.add(new File(r12[r22]));     // Catch: Throwable -> L15
        r22 = r22 + 1;     // Catch: Throwable -> L15
    L34:
        monitor-exit(this);     // Catch: Throwable -> L15
    }

    public final boolean d(File r10) {
        if (r10.exists() == true) goto L6;
        this.f7664b.b("file is not exist: " + r10.getPath());
        return false;
    L6:
        h(r10.getName());
        String r11 = "lib/" + this.f7674l + Constants.SEPARATOR + r10.getName();
        ZipFile[] r12 = this.f7669g;
        int r13 = r12.length;
        int r14 = 0;
    L7:
        if (r14 >= r13) goto L12;
        ZipEntry r15 = r12[r14].getEntry(r11);
        if (r15 != null) goto L10;
        r14 = r14 + 1;
        goto L7
    L10:
        long r16 = r15.getCrc();
    L13:
        long r17 = g(r10);
        if (r16 != r17) goto L17;
        this.f7664b.a(r11 + " compare crc ok: entry is " + r16 + ", file is " + r17);
        return true;
    L17:
        this.f7664b.b(r11 + " crc is wrong: entry is " + r16 + ", file is " + r17);
        return false;
    L12:
        r16 = 0;
        goto L13
    }

    public final boolean e(String r10) {
        if (this.f7670h != null) goto L6;
        return true;
    L6:
        String r11 = (String) this.f7672j.get(r10);
        String r12 = this.f7670h;
        if (r11 == null) goto L10;
        r10 = r11;
    L10:
        return r12.equals(r10);
    }

    public final void f(Closeable r10) {
        if (r10 != null) goto L9;
        return;
    L9:
        r10.close();     // Catch: IOException -> L6
        return;
    L6:
        e = move-exception;
        this.f7664b.c("failed to close resource", e);
    }

    public final long g(File r10) {
        byte[] r11 = new byte[8192];
        Closeable r12 = null;
        CheckedInputStream r13 = new CheckedInputStream(new FileInputStream(r10), new CRC32());     // Catch: Throwable -> L13 IOException -> L15
    L25:
    L11:
        e = e;
        r12 = r13;
    L16:
        this.f7664b.c("fail to check sum for " + r10.getPath(), e);     // Catch: Throwable -> L13
        f(r12);
        return 0;
    L9:
        th = th;
        r12 = r13;
    L19:
        f(r12);
        throw th;
    L5:
        if (r13.read(r11) >= 0) goto L25;
        long r14 = r13.getChecksum().getValue();     // Catch: Throwable -> L9 IOException -> L11
        f(r13);
        return r14;
    L13:
        th = th;
    L15:
        e = e;
        goto L16
    }

    public final void h(String r11) {
        if (this.f7674l == null) goto L5;
        return;
    L5:
        String[] r10 = this.f7673k;
        int r12 = r10.length;
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L19;
        String r14 = r10[r13];
        if (e(r14) == false) goto L17;
        String r15 = "lib/" + r14 + Constants.SEPARATOR + r11;
        ZipFile[] r16 = this.f7669g;
        int r17 = r16.length;
        int r18 = 0;
    L11:
        if (r18 >= r17) goto L17;
        if (r16[r18].getEntry(r15) != null) goto L14;
        r18 = r18 + 1;
        goto L11
    L14:
        this.f7674l = r14;
        this.f7664b.a("ensure that abi is " + r14);
        return;
    L17:
        r13 = r13 + 1;
        goto L6
    L19:
        throw new LibrarianUnsatisfiedLinkError("can not ensure abi for " + r11 + ", check " + this.f7670h + ", apks " + j());
    }

    public final boolean i(File r10) {
        h(r10.getName());
        String r11 = "lib/" + this.f7674l + Constants.SEPARATOR + r10.getName();
        ZipFile[] r12 = this.f7669g;
        int r13 = r12.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L14;
        ZipFile r15 = r12[r14];
        ZipEntry r16 = r15.getEntry(r11);
        if (r16 != null) goto L7;
        r14 = r14 + 1;
        goto L3
    L7:
        InputStream r17 = r15.getInputStream(r16);
        o(r17, r10);     // Catch: Throwable -> L11
        this.f7664b.a("get lib file " + r10.getPath() + " from " + r11 + " of " + r15.getName());     // Catch: Throwable -> L11
        f(r17);
        return true;
    L11:
        th = move-exception;
        f(r17);
        throw th;
    L14:
        return false;
    }

    public final String j() {
        StringBuilder r10 = new StringBuilder();
        r10.append("[");
        ZipFile[] r11 = this.f7669g;
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        ZipFile r14 = r11[r13];
        String r15 = r14.getName();
        File r16 = new File(r15);
        r10.append(r15);
        r10.append("#");
        r10.append(r14.size());
        r10.append(":");
        r10.append(r16.length());
        r10.append(" ");
        r13 = r13 + 1;
        goto L3
    L5:
        r10.append("]");
        return r10.toString();
    }

    public final boolean l(String r10) {
        String[] r11 = f7662n;
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        if (r11[r13].equals(r10) == true) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r2v10, types: [com.bytedance.librarian.LibrarianImpl$b] */
    /* JADX WARN: Type inference failed for: r2v8, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r2v9, types: [com.bytedance.librarian.LibrarianImpl$b] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.bytedance.librarian.LibrarianImpl] */
    public void m(String r10, boolean r11) {
        Map r12 = this.f7665c;
        monitor-enter(r12);
        a r13 = (a) this.f7665c.get(r10);     // Catch: Throwable -> L10
        if (r13 != null) goto L7;
        r13 = new a();     // Catch: Throwable -> L10
        this.f7665c.put(r10, r13);     // Catch: Throwable -> L10
    L13:
        monitor-exit(r12);     // Catch: Throwable -> L10
        monitor-enter(r13);
    L20:
        th = move-exception;
        throw th;
    L16:
        if (r13.f7675a == false) goto L22;
        this.f7664b.a("lib was already loaded before: " + r10);     // Catch: Throwable -> L20
        monitor-exit(r13);     // Catch: Throwable -> L20
        return;
    L22:
        File r14 = new File(this.f7663a, k(r10));     // Catch: Throwable -> L20
        boolean r15 = r14.exists();     // Catch: Throwable -> L20
        if (r11 == false) goto L82;
    L34:
        c();     // Catch: Throwable -> L20
        ?? r16 = r14;
        if (r15 == true) goto L88;
        ?? r17 = new File(this.f7668f, k(r10));     // Catch: Throwable -> L20
        if (d(r17) == false) goto L85;
        r16 = r17;
        goto L88
    L85:
        r17 = new b(this, this.f7666d);     // Catch: Throwable -> L20
        r17.b();     // Catch: Throwable -> L46 IOException -> L48
        if (i(r14) == true) goto L52;
        if (r11 == false) goto L51;
        this.f7664b.a("may be system lib, no found " + r10);     // Catch: Throwable -> L46 IOException -> L48
        r17.a();     // Catch: Throwable -> L20
        monitor-exit(r13);     // Catch: Throwable -> L20
        return;
    L51:
        throw new LibrarianUnsatisfiedLinkError("fail to find " + r10);     // Catch: Throwable -> L46 IOException -> L48
    L52:
        r17.a();     // Catch: Throwable -> L20
        r16 = r14;
    L48:
        e = move-exception;
        throw new LibrarianUnsatisfiedLinkError("fail to extract " + r10, e);     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        r17.a();     // Catch: Throwable -> L20
        throw th;     // Catch: Throwable -> L20
    L88:
        Iterator r18 = n(r16).iterator();     // Catch: Throwable -> L20 IOException -> L66
    L61:
        if (r18.hasNext() == false) goto L86;
        String r19 = (String) r18.next();     // Catch: Throwable -> L20 IOException -> L66
        String r20 = r19.substring(3, r19.length() - 3);     // Catch: Throwable -> L20 IOException -> L66
        if (l(r20) == true) goto L61;
        this.f7664b.a("to load depended lib " + r20);     // Catch: Throwable -> L20 IOException -> L66
        m(r20, r11);     // Catch: Throwable -> L20 IOException -> L66
    L86:
        this.f7664b.d(r16.getPath());     // Catch: Throwable -> L20 UnsatisfiedLinkError -> L72
        this.f7664b.a("loaded the lib " + r10);     // Catch: Throwable -> L20 UnsatisfiedLinkError -> L72
        r13.f7675a = true;     // Catch: Throwable -> L20
        monitor-exit(r13);     // Catch: Throwable -> L20
        return;
    L72:
        e = move-exception;
        throw new LibrarianUnsatisfiedLinkError("finally fail to load " + r16.getPath(), e);     // Catch: Throwable -> L20
    L66:
        e = move-exception;
        throw new LibrarianUnsatisfiedLinkError("fail to load depended lib", e);     // Catch: Throwable -> L20
    L82:
        if (r15 == false) goto L29;
        this.f7664b.d(r14.getPath());     // Catch: Throwable -> L20 UnsatisfiedLinkError -> L27
    L30:
        this.f7664b.a("lib is loaded: " + r10);     // Catch: Throwable -> L20 UnsatisfiedLinkError -> L27
        r13.f7675a = true;     // Catch: Throwable -> L20 UnsatisfiedLinkError -> L27
        monitor-exit(r13);     // Catch: Throwable -> L20
        return;
    L29:
        this.f7664b.e(r10);     // Catch: Throwable -> L20 UnsatisfiedLinkError -> L27
    L27:
        e = move-exception;
        this.f7664b.c("fail to load " + r14.getName() + ", out lib exists: " + r15, e);     // Catch: Throwable -> L20
        goto L34
    L7:
        if (r13.f7675a == false) goto L13;
        monitor-exit(r12);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final List n(File r10) {
        Closeable r11 = null;
        e r12 = new e(r10);     // Catch: Throwable -> L9
        List r13 = r12.c();     // Catch: Throwable -> L7
        Collections.sort(r13);     // Catch: Throwable -> L7
        f(r12);
        return r13;
    L7:
        th = th;
        r11 = r12;
    L10:
        f(r11);
        throw th;
    L9:
        th = th;
        goto L10
    }

    public final File o(InputStream r10, File r11) {
        File r12 = File.createTempFile("tmp-", r11.getName(), r11.getParentFile());
        this.f7664b.a("extracting " + r12.getPath());
        FileOutputStream r13 = new FileOutputStream(r12);
        byte[] r14 = new byte[8192];     // Catch: Throwable -> L7
        int r15 = r10.read(r14);     // Catch: Throwable -> L7
    L5:
        if (r15 == (-1)) goto L10;
        r13.write(r14, 0, r15);     // Catch: Throwable -> L7
        r15 = r10.read(r14);     // Catch: Throwable -> L7
        goto L5
    L10:
        if (r12.setReadOnly() == false) goto L18;
        this.f7664b.a("renaming to " + r11.getPath());     // Catch: Throwable -> L7
        if (r12.renameTo(r11) == false) goto L16;
        f(r13);
        r12.delete();
        return r11;
    L16:
        throw new IOException("failed to rename \"" + r12.getAbsolutePath() + "\" to \"" + r11.getAbsolutePath() + "\"");     // Catch: Throwable -> L7
    L18:
        throw new IOException("failed to mark readonly \"" + r12.getAbsolutePath() + "\" (tmp of \"" + r11.getAbsolutePath() + "\")");     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        f(r13);
        r12.delete();
        throw th;
    }
}
