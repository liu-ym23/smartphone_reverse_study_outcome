package androidx.room;

import android.content.Context;
import android.util.Log;
import androidx.room.util.CopyLock;
import androidx.room.util.DBUtil;
import androidx.room.util.FileUtil;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
class SQLiteCopyOpenHelper implements SupportSQLiteOpenHelper, DelegatingOpenHelper {
    private final Context mContext;
    private final String mCopyFromAssetPath;
    private final File mCopyFromFile;
    private final Callable<InputStream> mCopyFromInputStream;
    private DatabaseConfiguration mDatabaseConfiguration;
    private final int mDatabaseVersion;
    private final SupportSQLiteOpenHelper mDelegate;
    private boolean mVerified;

    SQLiteCopyOpenHelper(Context context, String copyFromAssetPath, File copyFromFile, Callable<InputStream> copyFromInputStream, int databaseVersion, SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        this.mContext = context;
        this.mCopyFromAssetPath = copyFromAssetPath;
        this.mCopyFromFile = copyFromFile;
        this.mCopyFromInputStream = copyFromInputStream;
        this.mDatabaseVersion = databaseVersion;
        this.mDelegate = supportSQLiteOpenHelper;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public String getDatabaseName() {
        return this.mDelegate.getDatabaseName();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public void setWriteAheadLoggingEnabled(boolean enabled) {
        this.mDelegate.setWriteAheadLoggingEnabled(enabled);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public synchronized SupportSQLiteDatabase getWritableDatabase() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.mVerified == true) goto L6;
        verifyDatabaseFile(true);     // Catch: Throwable -> L9
        this.mVerified = true;     // Catch: Throwable -> L9
    L6:
        SupportSQLiteDatabase r0 = this.mDelegate.getWritableDatabase();     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public synchronized SupportSQLiteDatabase getReadableDatabase() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.mVerified == true) goto L6;
        verifyDatabaseFile(false);     // Catch: Throwable -> L9
        this.mVerified = true;     // Catch: Throwable -> L9
    L6:
        SupportSQLiteDatabase r0 = this.mDelegate.getReadableDatabase();     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        monitor-enter(this);
        this.mDelegate.close();     // Catch: Throwable -> L6
        this.mVerified = false;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // androidx.room.DelegatingOpenHelper
    public SupportSQLiteOpenHelper getDelegate() {
        return this.mDelegate;
    }

    void setDatabaseConfiguration(DatabaseConfiguration databaseConfiguration) {
        this.mDatabaseConfiguration = databaseConfiguration;
    }

    private void verifyDatabaseFile(boolean writable) {
        String r2 = getDatabaseName();
        File r3 = this.mContext.getDatabasePath(r2);
        DatabaseConfiguration r4 = this.mDatabaseConfiguration;
        if (r4 != null) goto L5;
    L8:
        boolean r5 = true;
    L9:
        CopyLock r6 = new CopyLock(r2, this.mContext.getFilesDir(), r5);
        r6.lock();     // Catch: Throwable -> L45
        if (r3.exists() == true) goto L20;
        copyDatabaseFile(r3, writable);     // Catch: IOException -> L16 Throwable -> L45
        r6.unlock();
        return;
    L16:
        e = move-exception;
        throw new RuntimeException("Unable to copy database file.", e);     // Catch: Throwable -> L45
    L20:
        if (this.mDatabaseConfiguration != null) goto L48;
        r6.unlock();
        return;
    L48:
        int r7 = DBUtil.readVersion(r3);     // Catch: IOException -> L41 Throwable -> L45
        int r8 = this.mDatabaseVersion;     // Catch: Throwable -> L45
        if (r7 != r8) goto L29;
        r6.unlock();
        return;
    L29:
        if (this.mDatabaseConfiguration.isMigrationRequired(r7, r8) == false) goto L33;
        r6.unlock();
        return;
    L33:
        if (this.mContext.deleteDatabase(r2) == true) goto L50;
        Log.w("ROOM", "Failed to delete database file (" + r2 + ") for a copy destructive migration.");     // Catch: Throwable -> L45
    L39:
        r6.unlock();
        return;
    L50:
        copyDatabaseFile(r3, writable);     // Catch: IOException -> L36 Throwable -> L45
    L36:
        e = move-exception;
        Log.w("ROOM", "Unable to copy database file.", e);     // Catch: Throwable -> L45
        goto L39
    L41:
        e = move-exception;
        Log.w("ROOM", "Unable to read database version.", e);     // Catch: Throwable -> L45
        r6.unlock();
        return;
    L45:
        th = move-exception;
        r6.unlock();
        throw th;
    L5:
        if (r4.multiInstanceInvalidation == true) goto L8;
        r5 = false;
        goto L9
    }

    private void copyDatabaseFile(File destinationFile, boolean writable) throws IOException {
        if (this.mCopyFromAssetPath == null) goto L6;
        ReadableByteChannel r0 = Channels.newChannel(this.mContext.getAssets().open(this.mCopyFromAssetPath));
    L12:
        File r1 = File.createTempFile("room-copy-helper", ".tmp", this.mContext.getCacheDir());
        r1.deleteOnExit();
        FileUtil.copy(r0, new FileOutputStream(r1).getChannel());
        File r2 = destinationFile.getParentFile();
        if (r2 != null) goto L15;
    L21:
        dispatchOnOpenPrepackagedDatabase(r1, writable);
        if (r1.renameTo(destinationFile) == false) goto L25;
        return;
    L25:
        throw new IOException("Failed to move intermediate file (" + r1.getAbsolutePath() + ") to destination (" + destinationFile.getAbsolutePath() + ").");
    L15:
        if (r2.exists() == true) goto L21;
        if (r2.mkdirs() == true) goto L21;
        throw new IOException("Failed to create directories for " + destinationFile.getAbsolutePath());
    L6:
        if (this.mCopyFromFile == null) goto L8;
        r0 = new FileInputStream(this.mCopyFromFile).getChannel();
        goto L12
    L8:
        Callable<InputStream> r3 = this.mCopyFromInputStream;
        if (r3 == null) goto L30;
        r0 = Channels.newChannel(r3.call());
    L26:
        e = move-exception;
        throw new IOException("inputStreamCallable exception on call", e);
    L30:
        throw new IllegalStateException("copyFromAssetPath, copyFromFile and copyFromInputStream are all null!");
    }

    private void dispatchOnOpenPrepackagedDatabase(File databaseFile, boolean writable) {
        DatabaseConfiguration r0 = this.mDatabaseConfiguration;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.prepackagedDatabaseCallback == null) goto L20;
        SupportSQLiteOpenHelper r2 = createFrameworkOpenHelper(databaseFile);
        if (writable == false) goto L10;
        SupportSQLiteDatabase r3 = r2.getWritableDatabase();     // Catch: Throwable -> L14
    L11:
        this.mDatabaseConfiguration.prepackagedDatabaseCallback.onOpenPrepackagedDatabase(r3);     // Catch: Throwable -> L14
        r2.close();
        return;
    L10:
        r3 = r2.getReadableDatabase();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        r2.close();
        throw th;
    }

    private SupportSQLiteOpenHelper createFrameworkOpenHelper(File databaseFile) {
        String r0 = databaseFile.getName();
        final int r4 = DBUtil.readVersion(databaseFile);     // Catch: IOException -> L6
        return new FrameworkSQLiteOpenHelperFactory().create(SupportSQLiteOpenHelper.Configuration.builder(this.mContext).name(r0).callback(new AnonymousClass1(this, r4)).build());
    L6:
        e = move-exception;
        throw new RuntimeException("Malformed database file, unable to read version.", e);
    }
}
