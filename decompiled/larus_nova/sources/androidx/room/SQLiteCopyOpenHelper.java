package androidx.room;

import android.content.Context;
import androidx.room.util.CopyLock;
import androidx.room.util.DBUtil;
import androidx.room.util.FileUtil;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import com.facebook.cache.disk.DefaultDiskStorage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
class SQLiteCopyOpenHelper implements SupportSQLiteOpenHelper, DelegatingOpenHelper {
    private final Context mContext;
    private final String mCopyFromAssetPath;
    private final File mCopyFromFile;
    private final Callable<InputStream> mCopyFromInputStream;
    private DatabaseConfiguration mDatabaseConfiguration;
    private final int mDatabaseVersion;
    private final SupportSQLiteOpenHelper mDelegate;
    private boolean mVerified;

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
        SupportSQLiteDatabase r100 = this.mDelegate.getReadableDatabase();     // Catch: Throwable -> L9
        monitor-exit(this);
        return r100;
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
        SupportSQLiteDatabase r100 = this.mDelegate.getWritableDatabase();     // Catch: Throwable -> L9
        monitor-exit(this);
        return r100;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public String getDatabaseName() {
        return this.mDelegate.getDatabaseName();
    }

    @Override // androidx.room.DelegatingOpenHelper
    public SupportSQLiteOpenHelper getDelegate() {
        return this.mDelegate;
    }

    private SupportSQLiteOpenHelper createFrameworkOpenHelper(File r100) {
        int r101 = DBUtil.readVersion(r100);     // Catch: IOException -> L5
        FrameworkSQLiteOpenHelperFactory r102 = new FrameworkSQLiteOpenHelperFactory();
        SupportSQLiteOpenHelper.Configuration.Builder r103 = SupportSQLiteOpenHelper.Configuration.builder(this.mContext).name(r100.getAbsolutePath());
        final int r104 = Math.max(r101, 1);
        return r102.create(r103.callback(new AnonymousClass1(this, r104)).build());
    L5:
        e = move-exception;
        throw new RuntimeException("Malformed database file, unable to read version.", e);
    }

    private void verifyDatabaseFile(boolean r100) {
        String r101 = getDatabaseName();
        File r102 = this.mContext.getDatabasePath(r101);
        DatabaseConfiguration r103 = this.mDatabaseConfiguration;
        if (r103 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        CopyLock r105 = new CopyLock(r101, this.mContext.getFilesDir(), r104);
        r105.lock();     // Catch: Throwable -> L40
        if (r102.exists() == true) goto L19;
        copyDatabaseFile(r102, r100);     // Catch: IOException -> L15 Throwable -> L40
        r105.unlock();
        return;
    L15:
        e = move-exception;
        throw new RuntimeException("Unable to copy database file.", e);     // Catch: Throwable -> L40
    L19:
        if (this.mDatabaseConfiguration != null) goto L49;
        r105.unlock();
        return;
    L49:
        int r106 = DBUtil.readVersion(r102);     // Catch: IOException -> L38 Throwable -> L40
        int r107 = this.mDatabaseVersion;     // Catch: Throwable -> L40
        if (r106 != r107) goto L28;
        r105.unlock();
        return;
    L28:
        if (this.mDatabaseConfiguration.isMigrationRequired(r106, r107) == false) goto L32;
        r105.unlock();
        return;
    L32:
        if (this.mContext.deleteDatabase(r101) == false) goto L36;
        copyDatabaseFile(r102, r100);     // Catch: IOException -> L43 Throwable -> L40
    L36:
        r105.unlock();
        return;
    L38:
        r105.unlock();
        return;
    L40:
        th = move-exception;
        r105.unlock();
        throw th;
    L5:
        if (r103.multiInstanceInvalidation == true) goto L8;
        r104 = false;
        goto L9
    }

    public void setDatabaseConfiguration(DatabaseConfiguration r100) {
        this.mDatabaseConfiguration = r100;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public void setWriteAheadLoggingEnabled(boolean r100) {
        this.mDelegate.setWriteAheadLoggingEnabled(r100);
    }

    private void copyDatabaseFile(File r100, boolean r101) throws IOException {
        if (this.mCopyFromAssetPath == null) goto L6;
        ReadableByteChannel r102 = Channels.newChannel(this.mContext.getAssets().open(this.mCopyFromAssetPath));
    L12:
        File r103 = File.createTempFile("room-copy-helper", DefaultDiskStorage.FileType.TEMP, this.mContext.getCacheDir());
        r103.deleteOnExit();
        FileUtil.copy(r102, new FileOutputStream(r103).getChannel());
        File r104 = r100.getParentFile();
        if (r104 != null) goto L15;
    L21:
        dispatchOnOpenPrepackagedDatabase(r103, r101);
        if (r103.renameTo(r100) == false) goto L25;
        return;
    L25:
        throw new IOException("Failed to move intermediate file (" + r103.getAbsolutePath() + ") to destination (" + r100.getAbsolutePath() + ").");
    L15:
        if (r104.exists() == true) goto L21;
        if (r104.mkdirs() == true) goto L21;
        throw new IOException("Failed to create directories for " + r100.getAbsolutePath());
    L6:
        if (this.mCopyFromFile == null) goto L8;
        r102 = new FileInputStream(this.mCopyFromFile).getChannel();
        goto L12
    L8:
        Callable<InputStream> r105 = this.mCopyFromInputStream;
        if (r105 == null) goto L30;
        r102 = Channels.newChannel(r105.call());
    L26:
        e = move-exception;
        throw new IOException("inputStreamCallable exception on call", e);
    L30:
        throw new IllegalStateException("copyFromAssetPath, copyFromFile and copyFromInputStream are all null!");
    }

    private void dispatchOnOpenPrepackagedDatabase(File r100, boolean r101) {
        DatabaseConfiguration r102 = this.mDatabaseConfiguration;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.prepackagedDatabaseCallback == null) goto L20;
        SupportSQLiteOpenHelper r103 = createFrameworkOpenHelper(r100);
        if (r101 == false) goto L10;
        SupportSQLiteDatabase r104 = r103.getWritableDatabase();     // Catch: Throwable -> L14
    L11:
        this.mDatabaseConfiguration.prepackagedDatabaseCallback.onOpenPrepackagedDatabase(r104);     // Catch: Throwable -> L14
        r103.close();
        return;
    L10:
        r104 = r103.getReadableDatabase();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        r103.close();
        throw th;
    }

    public SQLiteCopyOpenHelper(Context r100, String r101, File r102, Callable<InputStream> r103, int r104, SupportSQLiteOpenHelper r105) {
        this.mContext = r100;
        this.mCopyFromAssetPath = r101;
        this.mCopyFromFile = r102;
        this.mCopyFromInputStream = r103;
        this.mDatabaseVersion = r104;
        this.mDelegate = r105;
    }
}
