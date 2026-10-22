package n2;

import com.bytedance.librarian.LibrarianImpl;
import java.io.File;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static File f22356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static File f22357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static File f22358c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static File f22359d;

    public static String a() {
        return System.currentTimeMillis() + "_" + UUID.randomUUID().toString() + ".log";
    }

    public static synchronized File b() {
        monitor-enter(b.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (f22357b != null) goto L14;
        File r10 = new File(f(), "flush");     // Catch: Throwable -> L9
        if (r10.exists() == true) goto L11;
        r10.mkdirs();     // Catch: Throwable -> L9
    L11:
        f22357b = r10;     // Catch: Throwable -> L9
        if (r3.a.c() == false) goto L14;
        s3.a.a(a.f22354a, "prepare FlushDirectory success. name=" + f22357b);     // Catch: Throwable -> L9
    L14:
        File r11 = f22357b;     // Catch: Throwable -> L9
        monitor-exit(b.class);
        return r11;
    }

    public static synchronized File c() {
        monitor-enter(b.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (f22358c == null) goto L7;
    L18:
        File r10 = f22358c;     // Catch: Throwable -> L9
        monitor-exit(b.class);
        return r10;
    L7:
        if (d3.a.A() == false) goto L11;
        File r11 = new File(f(), "persistent");     // Catch: Throwable -> L9
    L13:
        if (r11.exists() == true) goto L15;
        r11.mkdirs();     // Catch: Throwable -> L9
    L15:
        f22358c = r11;     // Catch: Throwable -> L9
        if (r3.a.c() == false) goto L18;
        s3.a.a(a.f22354a, "prepare PersistentDirectory success. name=" + f22358c);     // Catch: Throwable -> L9
        goto L18
    L11:
        r11 = new File(f(), "child_process_persistent");     // Catch: Throwable -> L9
        goto L13
    }

    public static synchronized File d() {
        monitor-enter(b.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (f22356a == null) goto L26;
    L21:
        File r10 = f22356a;     // Catch: Throwable -> L9
        monitor-exit(b.class);
        return r10;
    L26:
        String r11 = d3.a.m().replace(LibrarianImpl.Constants.DOT, "_").replace(":", "-") + ".bin";     // Catch: Throwable -> L9 Exception -> L11
        if (d3.a.A() == true) goto L13;
        r11 = d3.a.o() + "_" + r11;     // Catch: Throwable -> L9 Exception -> L11
    L13:
        File r12 = new File(c(), r11);     // Catch: Throwable -> L9 Exception -> L11
        if (r12.exists() == true) goto L16;
        r12.createNewFile();     // Catch: Throwable -> L9 Exception -> L11
    L16:
        f22356a = r12;     // Catch: Throwable -> L9 Exception -> L11
        if (r3.a.c() == false) goto L21;
        s3.a.a(a.f22354a, "prepare PersistentFile success. fileName=" + f22356a);     // Catch: Throwable -> L9 Exception -> L11
    L11:
        e = move-exception;
        s3.a.c(a.f22354a, "prepare PersistentFile fail.", e);     // Catch: Throwable -> L9
        goto L21
    }

    public static File e() {
        return new File(f(), "child_process_persistent");
    }

    public static synchronized File f() {
        monitor-enter(b.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (f22359d != null) goto L11;
        File r10 = new File(r3.a.b().getFilesDir(), "apm6");     // Catch: Throwable -> L9
        f22359d = r10;     // Catch: Throwable -> L9
        if (r10.exists() == true) goto L11;
        f22359d.mkdirs();     // Catch: Throwable -> L9
    L11:
        File r11 = f22359d;     // Catch: Throwable -> L9
        monitor-exit(b.class);
        return r11;
    }
}
