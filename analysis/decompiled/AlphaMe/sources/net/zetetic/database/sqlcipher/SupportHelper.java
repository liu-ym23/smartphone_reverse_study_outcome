package net.zetetic.database.sqlcipher;

import androidx.annotation.Nullable;
import k0.InterfaceC0674b;
import k0.e;
import k0.g;

/* loaded from: classes2.dex */
public class SupportHelper implements g {
    private SQLiteOpenHelper openHelper;

    public SupportHelper(e eVar, byte[] bArr, SQLiteDatabaseHook sQLiteDatabaseHook, boolean z4) {
        this(eVar, bArr, sQLiteDatabaseHook, z4, 0);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.openHelper.close();
    }

    @Nullable
    public String getDatabaseName() {
        return this.openHelper.getDatabaseName();
    }

    public InterfaceC0674b getReadableDatabase() {
        return this.openHelper.getReadableDatabase();
    }

    @Override // k0.g
    public InterfaceC0674b getWritableDatabase() {
        return this.openHelper.getWritableDatabase();
    }

    @Override // k0.g
    public void setWriteAheadLoggingEnabled(boolean z4) {
        this.openHelper.setWriteAheadLoggingEnabled(z4);
    }

    public SupportHelper(final e eVar, byte[] bArr, SQLiteDatabaseHook sQLiteDatabaseHook, boolean z4, int i4) {
        this.openHelper = new SQLiteOpenHelper(eVar.f13327a, eVar.f13328b, bArr, null, eVar.f13329c.f13321a, i4, null, sQLiteDatabaseHook, z4) { // from class: net.zetetic.database.sqlcipher.SupportHelper.1
            @Override // net.zetetic.database.sqlcipher.SQLiteOpenHelper
            public void onConfigure(SQLiteDatabase sQLiteDatabase) {
                eVar.f13329c.b(sQLiteDatabase);
            }

            @Override // net.zetetic.database.sqlcipher.SQLiteOpenHelper
            public void onCreate(SQLiteDatabase sQLiteDatabase) {
                eVar.f13329c.c(sQLiteDatabase);
            }

            @Override // net.zetetic.database.sqlcipher.SQLiteOpenHelper
            public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i5, int i6) {
                eVar.f13329c.d(sQLiteDatabase, i5, i6);
            }

            @Override // net.zetetic.database.sqlcipher.SQLiteOpenHelper
            public void onOpen(SQLiteDatabase sQLiteDatabase) {
                eVar.f13329c.e(sQLiteDatabase);
            }

            @Override // net.zetetic.database.sqlcipher.SQLiteOpenHelper
            public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i5, int i6) {
                eVar.f13329c.f(sQLiteDatabase, i5, i6);
            }
        };
    }
}
