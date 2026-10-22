package androidx.room;

import android.content.Context;
import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.Callable;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: SQLiteCopyOpenHelper.java */
/* JADX INFO: loaded from: classes.dex */
class t implements d, androidx.sqlite.db.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f2695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f2696b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final File f2697c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Callable<InputStream> f2698d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f2699e;
    private final androidx.sqlite.db.d f;
    private c g;
    private boolean h;

    t(Context r3, String r4, File r5, Callable<InputStream> r6, int r7, androidx.sqlite.db.d r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        Callable<InputStream> r10 = (Callable) ZeusTransformUtils.wrapperContextForParams(r6, Callable.class, "com.obric.aiagent.plugin");
        androidx.sqlite.db.d r11 = (androidx.sqlite.db.d) ZeusTransformUtils.wrapperContextForParams(r8, androidx.sqlite.db.d.class, "com.obric.aiagent.plugin");
        this.f2695a = ZeusTransformUtils.wrapperContext(r9, "com.obric.aiagent.plugin");
        this.f2696b = r4;
        this.f2697c = r5;
        this.f2698d = r10;
        this.f2699e = r7;
        this.f = r11;
    }

    @Override // androidx.sqlite.db.d
    public String a() {
        return this.f.a();
    }

    @Override // androidx.sqlite.db.d
    public void a(boolean r1) {
        this.f.a(r1);
    }

    @Override // androidx.sqlite.db.d
    public synchronized androidx.sqlite.db.c b() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.h == true) goto L6;
        b(true);     // Catch: Throwable -> L9
        this.h = true;     // Catch: Throwable -> L9
    L6:
        androidx.sqlite.db.c r0 = this.f.b();     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    @Override // androidx.sqlite.db.d
    public synchronized androidx.sqlite.db.c c() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.h == true) goto L6;
        b(false);     // Catch: Throwable -> L9
        this.h = true;     // Catch: Throwable -> L9
    L6:
        androidx.sqlite.db.c r0 = this.f.c();     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    @Override // androidx.sqlite.db.d, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        monitor-enter(this);
        this.f.close();     // Catch: Throwable -> L6
        this.h = false;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // androidx.room.d
    public androidx.sqlite.db.d e() {
        return this.f;
    }

    void a(c r1) {
        this.g = r1;
    }

    private void b(boolean r9) {
        String r1 = a();
        File r2 = this.f2695a.getDatabasePath(r1);
        c r3 = this.g;
        if (r3 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        androidx.room.b.a r5 = new androidx.room.b.a(r1, this.f2695a.getFilesDir(), r4);
        r5.a();     // Catch: Throwable -> L45
        if (r2.exists() == true) goto L20;
        a(r2, r9);     // Catch: IOException -> L16 Throwable -> L45
        r5.b();
        return;
    L16:
        e = move-exception;
        throw new RuntimeException("Unable to copy database file.", e);     // Catch: Throwable -> L45
    L20:
        if (this.g != null) goto L53;
        r5.b();
        return;
    L53:
        int r6 = androidx.room.b.c.a(r2);     // Catch: IOException -> L41 Throwable -> L45
        int r7 = this.f2699e;     // Catch: Throwable -> L45
        if (r6 != r7) goto L29;
        r5.b();
        return;
    L29:
        if (this.g.a(r6, r7) == false) goto L33;
        r5.b();
        return;
    L33:
        if (this.f2695a.deleteDatabase(r1) == true) goto L48;
        a("ROOM", "Failed to delete database file (" + r1 + ") for a copy destructive migration.");     // Catch: Throwable -> L45
    L39:
        r5.b();
        return;
    L48:
        a(r2, r9);     // Catch: IOException -> L36 Throwable -> L45
    L36:
        e = move-exception;
        a("ROOM", "Unable to copy database file.", e);     // Catch: Throwable -> L45
        goto L39
    L41:
        e = move-exception;
        a("ROOM", "Unable to read database version.", e);     // Catch: Throwable -> L45
        r5.b();
        return;
    L45:
        th = move-exception;
        r5.b();
        throw th;
    L5:
        if (r3.m == true) goto L8;
        r4 = false;
        goto L9
    }

    private void a(File r5, boolean r6) {
        if (this.f2696b == null) goto L6;
        ReadableByteChannel r0 = Channels.newChannel(this.f2695a.getAssets().open(this.f2696b));
    L12:
        File r1 = File.createTempFile("room-copy-helper", ".tmp", this.f2695a.getCacheDir());
        r1.deleteOnExit();
        androidx.room.b.d.a(r0, new FileOutputStream(r1).getChannel());
        File r2 = r5.getParentFile();
        if (r2 != null) goto L15;
    L21:
        b(r1, r6);
        if (r1.renameTo(r5) == false) goto L25;
        return;
    L25:
        throw new IOException("Failed to move intermediate file (" + r1.getAbsolutePath() + ") to destination (" + r5.getAbsolutePath() + ").");
    L15:
        if (r2.exists() == true) goto L21;
        if (r2.mkdirs() == true) goto L21;
        throw new IOException("Failed to create directories for " + r5.getAbsolutePath());
    L6:
        if (this.f2697c == null) goto L8;
        r0 = new FileInputStream(this.f2697c).getChannel();
        goto L12
    L8:
        Callable<InputStream> r3 = this.f2698d;
        if (r3 == null) goto L30;
        r0 = Channels.newChannel((InputStream) ZeusTransformUtils.preCheckCast(r3.call(), InputStream.class, "com.obric.aiagent.plugin"));
    L26:
        e = move-exception;
        throw new IOException("inputStreamCallable exception on call", e);
    L30:
        throw new IllegalStateException("copyFromAssetPath, copyFromFile and copyFromInputStream are all null!");
    }

    private void b(File r2, boolean r3) {
        c r0 = this.g;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.f == null) goto L20;
        androidx.sqlite.db.d r4 = a(r2);
        if (r3 == false) goto L10;
        androidx.sqlite.db.c r5 = r4.b();     // Catch: Throwable -> L14
    L11:
        this.g.f.a(r5);     // Catch: Throwable -> L14
        r4.close();
        return;
    L10:
        r5 = r4.c();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        r4.close();
        throw th;
    }

    private androidx.sqlite.db.d a(File r5) {
        int r0 = androidx.room.b.c.a(r5);     // Catch: IOException -> L5
        androidx.sqlite.db.framework.b r1 = new androidx.sqlite.db.framework.b();
        androidx.sqlite.db.d.b.a r6 = androidx.sqlite.db.d.b.a(this.f2695a).a(r5.getAbsolutePath());
        final int r2 = Math.max(r0, 1);
        return r1.b(r6.a(new AnonymousClass1(this, r2)).a());
    L5:
        e = move-exception;
        throw new RuntimeException("Malformed database file, unable to read version.", e);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({com.obric.aiagent.apm.impl.BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2, r3);
    }
}
