package com.stepos.ailauncher.storage.database.cipher;

import La.C0953c;
import La.D;
import Z8.C1168p;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h8.C4148a;
import h9.InterfaceC4149a;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;
import l9.b;
import net.sqlcipher.database.SQLiteDatabase;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001:\u00011B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\bJ%\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J/\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b!\u0010\u0013J\u0017\u0010\"\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\"\u0010\u0013J\u0017\u0010$\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u001dH\u0002¢\u0006\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\u001d8\u0002X\u0082T¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020\u001d8\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010'R\u0014\u0010,\u001a\u00020+8\u0002X\u0082T¢\u0006\u0006\n\u0004\b,\u0010-R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001d0.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100¨\u00062"}, d2 = {"Lcom/stepos/ailauncher/storage/database/cipher/PlainToCipherMigrator;", "", "<init>", "()V", "Ljava/io/File;", "dbFile", "", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/io/File;)Z", "f", "Landroid/content/Context;", "context", "", "passphrase", "Lcom/stepos/ailauncher/storage/database/cipher/PlainToCipherMigrator$Result;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroid/content/Context;Ljava/io/File;[B)Lcom/stepos/ailauncher/storage/database/cipher/PlainToCipherMigrator$Result;", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/io/File;)V", "plainDb", "target", "", "e", "(Landroid/content/Context;Ljava/io/File;Ljava/io/File;[B)I", "Lnet/sqlcipher/database/SQLiteDatabase;", "db", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lnet/sqlcipher/database/SQLiteDatabase;)I", "", "suffix", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/io/File;Ljava/lang/String;)Ljava/io/File;", Const.INTENT_KEY_PKGNAME, "c", UxipConstants.f30680s, Const.INTENT_KEY_UMID, "(Ljava/lang/String;)Ljava/lang/String;", "TAG", "Ljava/lang/String;", "SQLITE_MAGIC", "[B", "TMP_SUFFIX", "", "SPACE_HEADROOM", "D", "", "SIDECAR_SUFFIXES", "[Ljava/lang/String;", "Result", "storage_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PlainToCipherMigrator {
    public static final PlainToCipherMigrator INSTANCE = new PlainToCipherMigrator();
    private static final String[] SIDECAR_SUFFIXES;
    private static final double SPACE_HEADROOM = 1.2d;
    private static final byte[] SQLITE_MAGIC;
    private static final String TAG = "PlainToCipherMigrator";
    private static final String TMP_SUFFIX = ".cipher.tmp";

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/storage/database/cipher/PlainToCipherMigrator$Result;", "", "<init>", "(Ljava/lang/String;I)V", "NOT_NEEDED", "MIGRATED", "FAILED", "storage_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Result {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ Result[] $VALUES;
        public static final Result NOT_NEEDED = new Result("NOT_NEEDED", 0);
        public static final Result MIGRATED = new Result("MIGRATED", 1);
        public static final Result FAILED = new Result("FAILED", 2);

        private static final /* synthetic */ Result[] $values() {
            return new Result[]{NOT_NEEDED, MIGRATED, FAILED};
        }

        static {
            Result[] resultArr$values = $values();
            $VALUES = resultArr$values;
            $ENTRIES = kotlin.enums.a.a(resultArr$values);
        }

        private Result(String str, int i10) {
        }

        public static InterfaceC4149a<Result> getEntries() {
            return $ENTRIES;
        }

        public static Result valueOf(String str) {
            return (Result) Enum.valueOf(Result.class, str);
        }

        public static Result[] values() {
            return (Result[]) $VALUES.clone();
        }
    }

    static {
        byte[] bytes = "SQLite format 3".getBytes(C0953c.US_ASCII);
        p.h(bytes, "getBytes(...)");
        SQLITE_MAGIC = C1168p.D(bytes, (byte) 0);
        SIDECAR_SUFFIXES = new String[]{"-journal", "-wal", "-shm"};
    }

    public final void a(File dbFile) {
        Object objB;
        if (j(dbFile, "-wal").length() == 0) {
            return;
        }
        try {
            Result.Companion companion = kotlin.Result.INSTANCE;
            SQLiteDatabase sQLiteDatabaseOpenDatabase = SQLiteDatabase.openDatabase(dbFile.getAbsolutePath(), null, 0);
            try {
                Cursor cursorRawQuery = sQLiteDatabaseOpenDatabase.rawQuery("PRAGMA wal_checkpoint(TRUNCATE)", null);
                try {
                    boolean zMoveToFirst = cursorRawQuery.moveToFirst();
                    b.a(cursorRawQuery, null);
                    b.a(sQLiteDatabaseOpenDatabase, null);
                    objB = kotlin.Result.b(Boolean.valueOf(zMoveToFirst));
                } finally {
                }
            } finally {
            }
        } catch (Throwable th) {
            Result.Companion companion2 = kotlin.Result.INSTANCE;
            objB = kotlin.Result.b(C4849c.a(th));
        }
        Throwable thE = kotlin.Result.e(objB);
        if (thE != null) {
            C4148a.u(TAG, "wal checkpoint on " + dbFile.getName() + " failed: " + thE, false, 4, null);
        }
    }

    public final void b(File dbFile) {
        for (String str : SIDECAR_SUFFIXES) {
            INSTANCE.j(dbFile, str).delete();
        }
    }

    public final void c(File dbFile) {
        dbFile.delete();
        b(dbFile);
    }

    public final String d(String value) {
        return D.T(value, "'", "''", false, 4, null);
    }

    public final int e(Context context, File plainDb, File target, byte[] passphrase) {
        net.sqlcipher.database.SQLiteDatabase.loadLibs(context);
        net.sqlcipher.database.SQLiteDatabase sQLiteDatabaseOpenOrCreateDatabase = net.sqlcipher.database.SQLiteDatabase.openOrCreateDatabase(target.getAbsolutePath(), passphrase, (SQLiteDatabase.CursorFactory) null);
        try {
            String absolutePath = plainDb.getAbsolutePath();
            p.h(absolutePath, "getAbsolutePath(...)");
            sQLiteDatabaseOpenOrCreateDatabase.rawExecSQL("ATTACH DATABASE '" + d(absolutePath) + "' AS plain KEY ''");
            p.f(sQLiteDatabaseOpenOrCreateDatabase);
            int i10 = i(sQLiteDatabaseOpenOrCreateDatabase);
            sQLiteDatabaseOpenOrCreateDatabase.rawExecSQL("SELECT sqlcipher_export('main', 'plain')");
            sQLiteDatabaseOpenOrCreateDatabase.setVersion(i10);
            sQLiteDatabaseOpenOrCreateDatabase.rawExecSQL("DETACH DATABASE plain");
            return i10;
        } finally {
            sQLiteDatabaseOpenOrCreateDatabase.close();
        }
    }

    public final boolean f(File dbFile) {
        p.i(dbFile, "dbFile");
        return dbFile.isFile() && dbFile.length() > 0 && !g(dbFile);
    }

    public final boolean g(File dbFile) {
        Object objB;
        p.i(dbFile, "dbFile");
        if (!dbFile.isFile()) {
            return false;
        }
        long length = dbFile.length();
        byte[] bArr = SQLITE_MAGIC;
        if (length < bArr.length) {
            return false;
        }
        byte[] bArr2 = new byte[bArr.length];
        try {
            Result.Companion companion = kotlin.Result.INSTANCE;
            FileInputStream fileInputStream = new FileInputStream(dbFile);
            try {
                int i10 = fileInputStream.read(bArr2);
                b.a(fileInputStream, null);
                objB = kotlin.Result.b(Integer.valueOf(i10));
            } finally {
            }
        } catch (Throwable th) {
            Result.Companion companion2 = kotlin.Result.INSTANCE;
            objB = kotlin.Result.b(C4849c.a(th));
        }
        if (kotlin.Result.e(objB) != null) {
            return false;
        }
        int iIntValue = ((Number) objB).intValue();
        byte[] bArr3 = SQLITE_MAGIC;
        return iIntValue == bArr3.length && Arrays.equals(bArr2, bArr3);
    }

    public final Result h(Context context, File dbFile, byte[] passphrase) {
        p.i(context, "context");
        p.i(dbFile, "dbFile");
        p.i(passphrase, "passphrase");
        if (!dbFile.isFile() || dbFile.length() == 0) {
            return Result.NOT_NEEDED;
        }
        if (!g(dbFile)) {
            return Result.NOT_NEEDED;
        }
        File file = new File(dbFile.getParentFile(), dbFile.getName() + TMP_SUFFIX);
        c(file);
        long length = (long) (((double) dbFile.length()) * SPACE_HEADROOM);
        File parentFile = dbFile.getParentFile();
        long usableSpace = parentFile != null ? parentFile.getUsableSpace() : 0L;
        if (usableSpace < length) {
            C4148a.h(TAG, "skip " + dbFile.getName() + ": need " + length + " bytes for export but only " + usableSpace + " usable", false, 4, null);
            return Result.FAILED;
        }
        try {
            a(dbFile);
            File fileJ = j(dbFile, "-wal");
            if (fileJ.length() > 0) {
                C4148a.h(TAG, "skip " + dbFile.getName() + ": wal not checkpointed (" + fileJ.length() + " bytes)", false, 4, null);
                return Result.FAILED;
            }
            int iE = e(context, dbFile, file, passphrase);
            Files.move(file.toPath(), dbFile.toPath(), StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
            b(dbFile);
            C4148a.k(TAG, "migrated " + dbFile.getName() + " to sqlcipher, userVersion=" + iE, false, 4, null);
            return Result.MIGRATED;
        } catch (Throwable th) {
            C4148a.g(TAG, "failed to migrate " + dbFile.getName() + " to sqlcipher, keeping plaintext", th, false, 8, null);
            c(file);
            return Result.FAILED;
        }
    }

    public final int i(net.sqlcipher.database.SQLiteDatabase db2) throws IOException {
        net.sqlcipher.Cursor cursorRawQuery = db2.rawQuery("PRAGMA plain.user_version", (String[]) null);
        try {
            int i10 = cursorRawQuery.moveToFirst() ? cursorRawQuery.getInt(0) : 0;
            b.a(cursorRawQuery, null);
            return i10;
        } finally {
        }
    }

    public final File j(File dbFile, String suffix) {
        return new File(dbFile.getPath() + suffix);
    }
}
