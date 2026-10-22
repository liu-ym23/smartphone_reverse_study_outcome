package androidx.room;

import android.content.Context;
import android.util.Log;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class u0 implements SupportSQLiteOpenHelper, DelegatingOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4667b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final File f4668c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Callable f4669d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f4670e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SupportSQLiteOpenHelper f4671f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public h f4672g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f4673h;

    public u0(Context r10, String r11, File r12, Callable r13, int r14, SupportSQLiteOpenHelper r15) {
        kotlin.jvm.internal.q.g(r10, "context");
        kotlin.jvm.internal.q.g(r15, "delegate");
        this.f4666a = r10;
        this.f4667b = r11;
        this.f4668c = r12;
        this.f4669d = r13;
        this.f4670e = r14;
        this.f4671f = r15;
    }

    public final void a(File r10, boolean r11) {
        if (this.f4667b == null) goto L6;
        ReadableByteChannel r12 = Channels.newChannel(this.f4666a.getAssets().open(this.f4667b));
        kotlin.jvm.internal.q.f(r12, "newChannel(context.assets.open(copyFromAssetPath))");
    L12:
        File r13 = File.createTempFile("room-copy-helper", ".tmp", this.f4666a.getCacheDir());
        r13.deleteOnExit();
        FileChannel r14 = new FileOutputStream(r13).getChannel();
        kotlin.jvm.internal.q.f(r14, "output");
        b0.c.a(r12, r14);
        File r15 = r10.getParentFile();
        if (r15 != null) goto L15;
    L21:
        kotlin.jvm.internal.q.f(r13, "intermediateFile");
        b(r13, r11);
        if (r13.renameTo(r10) == false) goto L25;
        return;
    L25:
        throw new IOException("Failed to move intermediate file (" + r13.getAbsolutePath() + ") to destination (" + r10.getAbsolutePath() + ").");
    L15:
        if (r15.exists() == true) goto L21;
        if (r15.mkdirs() == true) goto L21;
        throw new IOException("Failed to create directories for " + r10.getAbsolutePath());
    L6:
        if (this.f4668c == null) goto L8;
        r12 = new FileInputStream(this.f4668c).getChannel();
        kotlin.jvm.internal.q.f(r12, "FileInputStream(copyFromFile).channel");
        goto L12
    L8:
        Callable r16 = this.f4669d;
        if (r16 == null) goto L30;
        r12 = Channels.newChannel((InputStream) r16.call());
        kotlin.jvm.internal.q.f(r12, "newChannel(inputStream)");
    L26:
        e = move-exception;
        throw new IOException("inputStreamCallable exception on call", e);
    L30:
        throw new IllegalStateException("copyFromAssetPath, copyFromFile and copyFromInputStream are all null!");
    }

    public final void b(File r10, boolean r11) {
        h r12 = this.f4672g;
        if (r12 != null) goto L5;
        kotlin.jvm.internal.q.y("databaseConfiguration");
        r12 = null;
    L5:
        r12.getClass();
    }

    public final void c(h r10) {
        kotlin.jvm.internal.q.g(r10, "databaseConfiguration");
        this.f4672g = r10;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        monitor-enter(this);
        getDelegate().close();     // Catch: Throwable -> L6
        this.f4673h = false;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final void d(boolean r10) {
        String r11 = getDatabaseName();
        if (r11 == null) goto L48;
        File r12 = this.f4666a.getDatabasePath(r11);
        h r13 = this.f4672g;
        h r14 = null;
        if (r13 != null) goto L7;
        kotlin.jvm.internal.q.y("databaseConfiguration");
        r13 = null;
    L7:
        d0.a r15 = new d0.a(r11, this.f4666a.getFilesDir(), r13.f4572s);
        d0.a.c(r15, false, 1, null);     // Catch: Throwable -> L14
        if (r12.exists() == false) goto L53;
        kotlin.jvm.internal.q.f(r12, "databaseFile");     // Catch: Throwable -> L14 IOException -> L41
        int r16 = b0.b.d(r12);     // Catch: Throwable -> L14 IOException -> L41
    L21:
        if (r16 != this.f4670e) goto L24;
        r15.d();
        return;
    L24:
        h r17 = this.f4672g;     // Catch: Throwable -> L14
        if (r17 != null) goto L27;
        kotlin.jvm.internal.q.y("databaseConfiguration");     // Catch: Throwable -> L14
    L29:
        if (r14.a(r16, this.f4670e) == false) goto L33;
        r15.d();
        return;
    L33:
        if (this.f4666a.deleteDatabase(r11) == true) goto L51;
        Log.w("ROOM", "Failed to delete database file (" + r11 + ") for a copy destructive migration.");     // Catch: Throwable -> L14
    L39:
        r15.d();
        return;
    L51:
        a(r12, r10);     // Catch: Throwable -> L14 IOException -> L36
    L36:
        e = move-exception;
        Log.w("ROOM", "Unable to copy database file.", e);     // Catch: Throwable -> L14
        goto L39
    L27:
        r14 = r17;
    L41:
        e = move-exception;
        Log.w("ROOM", "Unable to read database version.", e);     // Catch: Throwable -> L14
        r15.d();
        return;
    L53:
        kotlin.jvm.internal.q.f(r12, "databaseFile");     // Catch: Throwable -> L14 IOException -> L16
        a(r12, r10);     // Catch: Throwable -> L14 IOException -> L16
        r15.d();
        return;
    L16:
        e = move-exception;
        throw new RuntimeException("Unable to copy database file.", e);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        r15.d();
        throw th;
    L48:
        throw new IllegalStateException("Required value was null.");
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public String getDatabaseName() {
        return getDelegate().getDatabaseName();
    }

    @Override // androidx.room.DelegatingOpenHelper
    public SupportSQLiteOpenHelper getDelegate() {
        return this.f4671f;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getReadableDatabase() {
        if (this.f4673h == true) goto L6;
        d(false);
        this.f4673h = true;
    L6:
        return getDelegate().getReadableDatabase();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getWritableDatabase() {
        if (this.f4673h == true) goto L6;
        d(true);
        this.f4673h = true;
    L6:
        return getDelegate().getWritableDatabase();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public void setWriteAheadLoggingEnabled(boolean r10) {
        getDelegate().setWriteAheadLoggingEnabled(r10);
    }
}
