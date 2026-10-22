package net.zetetic.database.sqlcipher;

import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

/* loaded from: classes4.dex */
public class SupportHelper implements SupportSQLiteOpenHelper {

    /* renamed from: a, reason: collision with root package name */
    public final SQLiteOpenHelper f5409a;

    public SupportHelper(SupportSQLiteOpenHelper.Configuration configuration, byte[] bArr, SQLiteDatabaseHook sQLiteDatabaseHook, boolean z10) {
        this(configuration, bArr, sQLiteDatabaseHook, z10, 0);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f5409a.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    /* renamed from: getDatabaseName */
    public final String getName() {
        return this.f5409a.b;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public final SupportSQLiteDatabase getReadableDatabase() {
        SQLiteDatabase sQLiteDatabaseB;
        SQLiteOpenHelper sQLiteOpenHelper = this.f5409a;
        synchronized (sQLiteOpenHelper) {
            sQLiteDatabaseB = sQLiteOpenHelper.b(false);
        }
        return sQLiteDatabaseB;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public final SupportSQLiteDatabase getWritableDatabase() {
        SQLiteDatabase sQLiteDatabaseB;
        SQLiteOpenHelper sQLiteOpenHelper = this.f5409a;
        synchronized (sQLiteOpenHelper) {
            sQLiteDatabaseB = sQLiteOpenHelper.b(true);
        }
        return sQLiteDatabaseB;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public final void setWriteAheadLoggingEnabled(boolean z10) {
        this.f5409a.setWriteAheadLoggingEnabled(z10);
    }

    public SupportHelper(final SupportSQLiteOpenHelper.Configuration configuration, byte[] bArr, SQLiteDatabaseHook sQLiteDatabaseHook, boolean z10, int i) {
        this.f5409a = new SQLiteOpenHelper(configuration.context, configuration.name, bArr, configuration.callback.version, i, sQLiteDatabaseHook, z10) { // from class: net.zetetic.database.sqlcipher.SupportHelper.1
            @Override // net.zetetic.database.sqlcipher.SQLiteOpenHelper
            public final void c(SQLiteDatabase sQLiteDatabase) {
                configuration.callback.onConfigure(sQLiteDatabase);
            }

            @Override // net.zetetic.database.sqlcipher.SQLiteOpenHelper
            public final void f(SQLiteDatabase sQLiteDatabase) {
                configuration.callback.onCreate(sQLiteDatabase);
            }

            @Override // net.zetetic.database.sqlcipher.SQLiteOpenHelper
            public final void g(SQLiteDatabase sQLiteDatabase, int i6, int i10) {
                configuration.callback.onDowngrade(sQLiteDatabase, i6, i10);
            }

            @Override // net.zetetic.database.sqlcipher.SQLiteOpenHelper
            public final void i(SQLiteDatabase sQLiteDatabase) {
                configuration.callback.onOpen(sQLiteDatabase);
            }

            @Override // net.zetetic.database.sqlcipher.SQLiteOpenHelper
            public final void k(SQLiteDatabase sQLiteDatabase, int i6, int i10) {
                configuration.callback.onUpgrade(sQLiteDatabase, i6, i10);
            }
        };
    }
}
