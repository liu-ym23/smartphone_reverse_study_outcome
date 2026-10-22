package com.bytedance.librarian;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.bytedance.librarian.a.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import dalvik.system.BaseDexClassLoader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
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

/* JADX INFO: compiled from: LibrarianImpl.java */
/* JADX INFO: loaded from: classes.dex */
class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final b f8748a = null;
    private static final String[] o = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final String[] f8749b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final File f8750c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c f8751d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map<String, a> f8752e;
    private final File f;
    private File g;
    private volatile boolean h;
    private ZipFile[] i;
    private String j;
    private ApplicationInfo k;
    private Map<String, String> l;
    private String[] m;
    private String n;

    /* JADX INFO: compiled from: LibrarianImpl.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f8753a;

        a() {
            this.f8753a = false;
        }

        public String toString() {
            return Boolean.toString(this.f8753a);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.librarian.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: LibrarianImpl.java */
    class C0198b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f8754a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private RandomAccessFile f8755b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private FileLock f8756c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private FileChannel f8757d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private File f8758e;

        C0198b(b r1, File r2) {
            this.f8754a = r1;
            this.f8758e = r2;
        }

        void a() {
            RandomAccessFile r0 = new RandomAccessFile(this.f8758e, "rw");
            this.f8755b = r0;
            this.f8757d = r0.getChannel();     // Catch: IOException -> L10
            b.a(this.f8754a).a("blocking on lock " + this.f8758e.getPath());     // Catch: IOException -> L7
            this.f8756c = this.f8757d.lock();     // Catch: IOException -> L7
            b.a(this.f8754a).a("acquired on lock " + this.f8758e.getPath());     // Catch: IOException -> L10
            return;
        L7:
            e = move-exception;
            b.a(this.f8754a, this.f8757d);     // Catch: IOException -> L10
            throw e;     // Catch: IOException -> L10
        L10:
            e = move-exception;
            b.a(this.f8754a, this.f8755b);
            throw e;
        }

        void b() {
            FileLock r0 = this.f8756c;
            if (r0 != null) goto L8;
        L5:
            b.a(this.f8754a).a("released lock " + this.f8758e.getPath());
            b.a(this.f8754a, this.f8757d);
            b.a(this.f8754a, this.f8755b);
            return;
        L8:
            r0.release();     // Catch: IOException -> L7
            goto L5
        }
    }

    static /* synthetic */ c a(b r0) {
        return r0.f8751d;
    }

    static /* synthetic */ void a(b r2, Closeable r3) {
        r2.a((Closeable) ZeusTransformUtils.wrapperContextForParams(r3, Closeable.class, "com.obric.aiagent.plugin"));
    }

    static {
        o = new String[]{"log", "m", "stdc++", "dl", "c", "z", "android", "jnigraphics", "EGL", "GLESv1_CM", "GLESv2", "GLESv3", "OpenSLES", "OpenMAXAL"};
        Context r0 = com.bytedance.librarian.a.f8730a;
        com.bytedance.librarian.a.f8730a = null;
        if (r0 == null) goto L35;
        ApplicationInfo r2 = r0.getApplicationInfo();
        File r1 = r0.getDir("librarian", 0);
        if (r1.exists() == true) goto L8;
        r1.mkdirs();
    L8:
        if (com.bytedance.librarian.a.f8731b == null) goto L10;
        String r3 = com.bytedance.librarian.a.f8731b;
    L11:
        File r5 = new File(r1, r3 + "." + (new File(r2.sourceDir).lastModified() >> 8));
        File[] r4 = r1.listFiles();
        if (r4 == null) goto L25;
        int r6 = r4.length;
        int r7 = 0;
    L14:
        if (r7 >= r6) goto L25;
        File r8 = r4[r7];
        if (r5.getName().equals(r8.getName()) == true) goto L24;
        File[] r9 = r8.listFiles();
        if (r9 == null) goto L23;
        int r10 = r9.length;
        int r11 = 0;
    L21:
        if (r11 >= r10) goto L23;
        r9[r11].delete();
        r11 = r11 + 1;
    L23:
        r8.delete();
    L24:
        r7 = r7 + 1;
    L25:
        r5.mkdirs();
        if (r5.exists() == true) goto L28;
        f8748a = null;
        return;
    L28:
        if (com.bytedance.librarian.a.f8732c == null) goto L30;
        c r12 = com.bytedance.librarian.a.f8732c;
    L31:
        f8748a = new b(r2, r5, r12);
        return;
    L30:
        r12 = new c();
        goto L31
    L10:
        r3 = "default.version";
        goto L11
    L35:
        throw new d("you should call init first or use loadLibraryForModule.");
    }

    private b(ApplicationInfo r3, File r4, c r5) {
        this.f8749b = new String[]{"/system/lib64", "/vendor/lib64"};
        this.f8750c = r4;
        this.f8751d = r5;
        this.k = r3;
        this.f = new File(r4, "process.lock");
        this.f8752e = new HashMap();
    }

    void a(String r5, boolean r6) {
        Map<String, a> r0 = this.f8752e;
        monitor-enter(r0);
        a r1 = (a) ZeusTransformUtils.preCheckCast(this.f8752e.get(r5), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L24
        if (r1 != null) goto L7;
        r1 = new a();     // Catch: Throwable -> L24
        this.f8752e.put(r5, r1);     // Catch: Throwable -> L24
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L24
        monitor-enter(r1);
    L21:
        th = move-exception;
        throw th;
    L14:
        if (r1.f8753a == false) goto L18;
        this.f8751d.a("lib was already loaded before: " + r5);     // Catch: Throwable -> L21
        monitor-exit(r1);     // Catch: Throwable -> L21
        return;
    L18:
        b(r5, r6);     // Catch: Throwable -> L21
        r1.f8753a = true;     // Catch: Throwable -> L21
        monitor-exit(r1);     // Catch: Throwable -> L21
        return;
    L7:
        if (r1.f8753a == false) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L24
        return;
    L24:
        th = move-exception;
        throw th;
    }

    private void b(String r7, boolean r8) {
        if (Build.VERSION.SDK_INT < 18) goto L5;
        boolean r0 = true;
    L6:
        File r3 = new File(this.f8750c, f(r7));
        if (r0 == true) goto L9;
        if (r8 == false) goto L29;
    L31:
        a();
        a(r3, r8);
        b(r3, r8);
    L32:
        a(r3, r7, true);
        return;
    L29:
        if (a(r7, "preload lower version device") == false) goto L31;
        return;
    L9:
        if (a(r7, "preload") == false) goto L12;
        return;
    L12:
        if (r3.exists() == true) goto L14;
    L16:
        a();
        if (a(r7) == true) goto L19;
    L21:
        File r1 = a(r7, r3, r8);
        b(r1, r8);
        if (r1 == r3) goto L32;
        if (a(r7, "after loading dep libs") == false) goto L26;
        return;
    L26:
        a(r3, r8);
        goto L32
    L19:
        if (a(r7, "lollipop") == false) goto L21;
        return;
    L14:
        if (a(r3, r7, false) == false) goto L16;
        return;
    L5:
        r0 = false;
        goto L6
    }

    private File a(String r3, File r4, boolean r5) {
        File r0 = new File(this.g, f(r3));
        if (a(r0) == false) goto L5;
        return r0;
    L5:
        a(r4, r5);
        return r4;
    }

    private void a(File r5, boolean r6) {
        String r0 = r5.getName();
        monitor-enter(this);
        C0198b r1 = new C0198b(this, this.f);     // Catch: Throwable -> L21
        r1.a();     // Catch: Throwable -> L14 IOException -> L16
        if (d(r5) == true) goto L11;
        if (r6 == false) goto L10;
        this.f8751d.a("may be system lib, no found " + r0);     // Catch: Throwable -> L14 IOException -> L16
        goto L11
    L10:
        throw new d("fail to extract " + r0);     // Catch: Throwable -> L14 IOException -> L16
    L11:
        r1.b();     // Catch: Throwable -> L21
        monitor-exit(this);     // Catch: Throwable -> L21
        return;
    L16:
        e = move-exception;
        throw new d("fail to extract " + r0, e);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        r1.b();     // Catch: Throwable -> L21
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    }

    private boolean a(File r9) {
        if (r9.exists() == true) goto L6;
        this.f8751d.b("file is not exist: " + r9.getPath());
        return false;
    L6:
        d(r9.getName());
        long r2 = 0;
        String r0 = "lib/" + this.n + "/" + r9.getName();
        ZipFile[] r4 = this.i;
        int r5 = r4.length;
        int r6 = 0;
    L7:
        if (r6 >= r5) goto L12;
        ZipEntry r7 = r4[r6].getEntry(r0);
        if (r7 != null) goto L10;
        r6 = r6 + 1;
        goto L7
    L10:
        r2 = r7.getCrc();
    L12:
        long r8 = c(r9);
        if (r2 != r8) goto L16;
        this.f8751d.a(r0 + " compare crc ok: entry is " + r2 + ", file is " + r8);
        return true;
    L16:
        this.f8751d.b(r0 + " crc is wrong: entry is " + r2 + ", file is " + r8);
        return false;
    }

    private boolean a(String r5, String r6) {
        this.f8751d.c(r5);     // Catch: UnsatisfiedLinkError -> L6
        this.f8751d.a("loaded the origin lib " + r5 + ", tag: " + r6);     // Catch: UnsatisfiedLinkError -> L6
        return true;
    L6:
        e = move-exception;
        this.f8751d.a("fail to load " + r5 + ", tag: " + r6, e);
        return false;
    }

    private boolean a(File r4, String r5, boolean r6) {
        this.f8751d.d(r4.getPath());     // Catch: UnsatisfiedLinkError -> L5
        this.f8751d.a("loaded the extracted lib " + r5);     // Catch: UnsatisfiedLinkError -> L5
        return true;
    L5:
        e = move-exception;
        if (r6 == true) goto L10;
        this.f8751d.a("fail to load " + r4.getName() + ", out lib exists", e);
        return false;
    L10:
        throw new d("finally fail to load " + r4.getPath(), e);
    }

    private void b(File r5, boolean r6) {
        Iterator<String> r7 = b(r5).iterator();     // Catch: IOException -> L10
    L4:
        if (r7.hasNext() == false) goto L9;
        String r0 = g((String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.aiagent.plugin"));     // Catch: IOException -> L10
        if (c(r0) == true) goto L4;
        this.f8751d.a("to load depended lib " + r0);     // Catch: IOException -> L10
        a(r0, r6);     // Catch: IOException -> L10
        goto L4
    L9:
        return;
    L10:
        e = move-exception;
        throw new d("fail to load depended lib", e);
    }

    private void a() {
        if (this.h == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L43:
        th = move-exception;
        throw th;
    L7:
        if (this.h == false) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L43
        return;
    L10:
        File r0 = new File(this.k.sourceDir);     // Catch: Throwable -> L43
        ArrayList r1 = new ArrayList();     // Catch: Throwable -> L43
        r1.add(r0);     // Catch: Throwable -> L43
        if (Build.VERSION.SDK_INT < 21) goto L19;
        String[] r2 = this.k.splitSourceDirs;     // Catch: Throwable -> L43
        if (r2 == null) goto L19;
        if (r2.length == 0) goto L19;
        int r4 = r2.length;     // Catch: Throwable -> L43
        int r5 = 0;
    L17:
        if (r5 >= r4) goto L19;
        r1.add(new File(r2[r5]));     // Catch: Throwable -> L43
        r5 = r5 + 1;     // Catch: Throwable -> L43
    L19:
        ZipFile[] r3 = new ZipFile[r1.size()];     // Catch: Throwable -> L43
        Iterator r6 = r1.iterator();     // Catch: Throwable -> L43
        int r7 = 0;
    L21:
        if (r6.hasNext() == false) goto L29;
        File r8 = (File) ZeusTransformUtils.preCheckCast(r6.next(), File.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L43
        int r9 = r7 + 1;
        r3[r7] = new ZipFile(r8);     // Catch: IOException -> L26 Throwable -> L43
    L28:
        r7 = r9;
    L26:
        e = move-exception;
        new d("fail to get zip file " + r8.getName() + ", size " + r8.length() + ", exists " + r8.exists(), e).printStackTrace();     // Catch: Throwable -> L43
        goto L28
    L29:
        this.i = r3;     // Catch: Throwable -> L43
        this.g = new File(this.k.nativeLibraryDir);     // Catch: Throwable -> L43
        HashMap r10 = new HashMap();     // Catch: Throwable -> L43
        this.l = r10;     // Catch: Throwable -> L43
        r10.put("arm64-v8a", "arm64");     // Catch: Throwable -> L43
        this.l.put("armeabi-v7a", "arm");     // Catch: Throwable -> L43
        this.l.put("armeabi", "arm");     // Catch: Throwable -> L43
        String r11 = null;
        if (Build.VERSION.SDK_INT >= 21) goto L48;
    L36:
        this.j = r11;     // Catch: Throwable -> L43
        this.f8751d.a("vm instruction set: " + this.j);     // Catch: Throwable -> L43
        if (Build.VERSION.SDK_INT >= 21) goto L39;
        String[] r12 = {Build.CPU_ABI, Build.CPU_ABI2};     // Catch: Throwable -> L43
    L40:
        this.m = r12;     // Catch: Throwable -> L43
        this.h = true;     // Catch: Throwable -> L43
        monitor-exit(this);     // Catch: Throwable -> L43
        return;
    L39:
        r12 = Build.SUPPORTED_ABIS;     // Catch: Throwable -> L43
        goto L40
    L48:
        Class r13 = ZeusTransformUtils.forName("dalvik.system.VMRuntime", "com.obric.aiagent.plugin");     // Catch: Exception -> L34 Throwable -> L43
        r11 = (String) ZeusTransformUtils.preCheckCast(r13.getDeclaredMethod("vmInstructionSet", new Class[0]).invoke(r13.getDeclaredMethod("getRuntime", new Class[0]).invoke(null, new Object[0]), new Object[0]), String.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L34 Throwable -> L43
        goto L36
    L34:
        e = move-exception;
        this.f8751d.a("fail to process vm abi previously", new d("reflect err", e));     // Catch: Throwable -> L43
        goto L36
    }

    private boolean a(String r17) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L10;
        return false;
    L10:
        String r3 = this.j;
        if (r3 != null) goto L13;
    L15:
        boolean r4 = false;
    L16:
        if (r4 == true) goto L18;
        return false;
    L18:
        this.f8751d.a("try to opt native lib dirs on L");
        BaseDexClassLoader r5 = (BaseDexClassLoader) ZeusTransformUtils.preCheckCast(getClass().getClassLoader(), BaseDexClassLoader.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L56
        Field r6 = BaseDexClassLoader.class.getDeclaredField("pathList");     // Catch: Exception -> L56
        r6.setAccessible(true);     // Catch: Exception -> L56
        Object r7 = r6.get(r5);     // Catch: Exception -> L56
        Field r8 = r7.getClass().getDeclaredField("nativeLibraryDirectories");     // Catch: Exception -> L56
        r8.setAccessible(true);     // Catch: Exception -> L56
        File[] r0 = (File[]) ZeusTransformUtils.preCheckCast((File[]) ZeusTransformUtils.preCheckCast(r8.get(r7), File[].class, "com.obric.aiagent.plugin"), File[].class, "com.obric.aiagent.plugin");     // Catch: Exception -> L56
        int r9 = r0.length;     // Catch: Exception -> L56
        File[] r10 = new File[r9];     // Catch: Exception -> L56
        System.arraycopy(r0, 0, r10, 0, r9);     // Catch: Exception -> L56
        int r11 = -1;
        int r12 = -1;
        int r13 = -1;
        int r14 = 0;
    L20:
        if (r14 >= r9) goto L31;
        File r15 = r10[r14];     // Catch: Exception -> L56
        if (this.f8750c.equals(r15) == false) goto L25;
        r11 = r14;
    L30:
        r14 = r14 + 1;     // Catch: Exception -> L56
        goto L20
    L25:
        if (this.g.equals(r15) == false) goto L28;
        r13 = r14;
        goto L30
    L28:
        if (new File(r15, f(r17)).exists() == false) goto L30;
        r12 = r14;
        goto L30
    L31:
        if (r11 == (-1)) goto L33;
        File[] r16 = new File[r9];     // Catch: Exception -> L56
        a(r10, 0, r11);     // Catch: Exception -> L56
        int r18 = 1;
    L34:
        if (r12 == (-1)) goto L36;
        a(r10, r18, r12);     // Catch: Exception -> L56
        r18 = r18 + 1;     // Catch: Exception -> L56
    L36:
        if (r13 == (-1)) goto L38;
        a(r10, r18, r13);     // Catch: Exception -> L56
        r18 = r18 + 1;     // Catch: Exception -> L56
    L38:
        int r19 = r9 - this.f8749b.length;     // Catch: Exception -> L56
    L39:
        if (r19 >= r9) goto L51;
        if (b(r10[r19].getAbsolutePath()) == true) goto L50;
        int r110 = r18;
    L45:
        if (r110 >= (r9 - 2)) goto L50;
        if (b(r10[r110].getAbsolutePath()) == false) goto L49;
        a(r10, r19, r110);     // Catch: Exception -> L56
    L49:
        r110 = r110 + 1;     // Catch: Exception -> L56
    L50:
        r19 = r19 + 1;     // Catch: Exception -> L56
        goto L39
    L51:
        if (r11 == (-1)) goto L53;
        System.arraycopy(r10, 0, r16, 0, r9);     // Catch: Exception -> L56
    L54:
        r8.set(r7, r16);     // Catch: Exception -> L56
        this.f8751d.a("success to insert path " + r5);     // Catch: Exception -> L56
        return true;
    L53:
        System.arraycopy(r10, 0, r16, 1, r9);     // Catch: Exception -> L56
        goto L54
    L33:
        r16 = new File[r9 + 1];     // Catch: Exception -> L56
        r16[0] = this.f8750c;     // Catch: Exception -> L56
        r18 = 0;
    L56:
        e = move-exception;
        this.f8751d.a("fail to insert path", new d("opt lib dir err", e));
        return false;
    L13:
        if (r3.contains("64") == false) goto L15;
        r4 = true;
        goto L16
    L5:
        if (Build.VERSION.SDK_INT >= 23) goto L7;
        r2 = true;
        goto L8
    }

    private void a(File[] r2, int r3, int r4) {
        if (r3 != r4) goto L4;
        return;
    L4:
        File r1 = r2[r3];
        r2[r3] = r2[r4];
        r2[r4] = r1;
    }

    private boolean b(String r5) {
        String[] r4 = this.f8749b;
        int r0 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (r4[r2].equals(r5) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private boolean c(String r5) {
        String[] r4 = o;
        int r0 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (r4[r2].equals(r5) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private List<String> b(File r3) {
        Closeable r0 = null;
        f r1 = new f(r3);     // Catch: Throwable -> L9
        List<String> r4 = r1.b();     // Catch: Throwable -> L7
        Collections.sort(r4);     // Catch: Throwable -> L7
        a(r1);
        return r4;
    L7:
        th = th;
        r0 = r1;
    L10:
        a(r0);
        throw th;
    L9:
        th = th;
        goto L10
    }

    private long c(File r6) {
        byte[] r0 = new byte[8192];
        Closeable r1 = null;
        CheckedInputStream r2 = new CheckedInputStream(new FileInputStream(r6), new CRC32());     // Catch: Throwable -> L13 IOException -> L15
    L25:
    L11:
        e = e;
        r1 = r2;
    L16:
        this.f8751d.a("fail to check sum for " + r6.getPath(), e);     // Catch: Throwable -> L13
        a(r1);
        return 0;
    L9:
        th = th;
        r1 = r2;
    L19:
        a(r1);
        throw th;
    L5:
        if (r2.read(r0) >= 0) goto L25;
        long r3 = r2.getChecksum().getValue();     // Catch: Throwable -> L9 IOException -> L11
        a(r2);
        return r3;
    L13:
        th = th;
    L15:
        e = e;
        goto L16
    }

    private boolean d(File r8) {
        d(r8.getName());
        String r0 = "lib/" + this.n + "/" + r8.getName();
        ZipFile[] r1 = this.i;
        int r2 = r1.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L14;
        ZipFile r5 = r1[r4];
        ZipEntry r6 = r5.getEntry(r0);
        if (r6 != null) goto L7;
        r4 = r4 + 1;
        goto L3
    L7:
        InputStream r3 = r5.getInputStream(r6);
        a(r3, r8);     // Catch: Throwable -> L11
        this.f8751d.a("get lib file " + r8.getPath() + " from " + r0 + " of " + r5.getName());     // Catch: Throwable -> L11
        a(r3);
        return true;
    L11:
        th = move-exception;
        a(r3);
        throw th;
    L14:
        return false;
    }

    private void d(String r11) {
        if (this.n == null) goto L5;
        return;
    L5:
        String[] r0 = this.m;
        int r1 = r0.length;
        int r3 = 0;
    L6:
        if (r3 >= r1) goto L21;
        String r4 = r0[r3];
        if (e(r4) == false) goto L19;
        String r5 = "lib/" + r4 + "/" + r11;
        ZipFile[] r6 = this.i;
        int r7 = r6.length;
        int r8 = 0;
    L11:
        if (r8 >= r7) goto L19;
        ZipFile r9 = r6[r8];
        if (r9 == null) goto L18;
        if (r9.getEntry(r5) == null) goto L18;
        this.n = r4;
        this.f8751d.a("ensure that abi is " + r4);
        return;
    L18:
        r8 = r8 + 1;
    L19:
        r3 = r3 + 1;
        goto L6
    L21:
        throw new d("can not ensure abi for " + r11 + ", check " + this.j + ", apks " + b());
    }

    private String b() {
        StringBuilder r0 = new StringBuilder();
        r0.append("[");
        ZipFile[] r7 = this.i;
        int r1 = r7.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        ZipFile r3 = r7[r2];
        if (r3 == null) goto L7;
        String r4 = r3.getName();
        File r5 = new File(r4);
        r0.append(r4).append("#").append(r3.size()).append(":").append(r5.length()).append("|");
    L7:
        r2 = r2 + 1;
        goto L3
    L8:
        r0.append("]");
        return r0.toString();
    }

    private boolean e(String r4) {
        if (this.j != null) goto L6;
        return true;
    L6:
        String r0 = (String) ZeusTransformUtils.preCheckCast(this.l.get(r4), String.class, "com.obric.aiagent.plugin");
        String r3 = this.j;
        if (r0 == null) goto L10;
        r4 = r0;
    L10:
        return r3.equals(r4);
    }

    private static String f(String r2) {
        return "lib" + r2 + ".so";
    }

    private static String g(String r2) {
        return r2.substring(3, r2.length() - 3);
    }

    private File a(InputStream r6, File r7) {
        File r0 = File.createTempFile("tmp-", r7.getName(), r7.getParentFile());
        this.f8751d.a("extracting " + r0.getPath());
        FileOutputStream r1 = new FileOutputStream(r0);
        byte[] r2 = new byte[8192];     // Catch: Throwable -> L17
        int r3 = r6.read(r2);     // Catch: Throwable -> L17
    L5:
        if (r3 == (-1)) goto L8;
        r1.write(r2, 0, r3);     // Catch: Throwable -> L17
        r3 = r6.read(r2);     // Catch: Throwable -> L17
        goto L5
    L8:
        if (r0.setReadOnly() == false) goto L16;
        this.f8751d.a("renaming to " + r7.getPath());     // Catch: Throwable -> L17
        if (r0.renameTo(r7) == false) goto L14;
        a(r1);
        r0.delete();
        return r7;
    L14:
        throw new IOException("failed to rename \"" + r0.getAbsolutePath() + "\" to \"" + r7.getAbsolutePath() + "\"");     // Catch: Throwable -> L17
    L16:
        throw new IOException("failed to mark readonly \"" + r0.getAbsolutePath() + "\" (tmp of \"" + r7.getAbsolutePath() + "\")");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        a(r1);
        r0.delete();
        throw th;
    }

    private void a(Closeable r3) {
        Closeable r4 = (Closeable) ZeusTransformUtils.wrapperContextForParams(r3, Closeable.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L10;
        return;
    L10:
        r4.close();     // Catch: IOException -> L7
        return;
    L7:
        e = move-exception;
        this.f8751d.a("failed to close resource", e);
    }
}
