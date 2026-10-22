package net.sqlcipher.database;

import android.database.sqlite.SQLiteException;
import j1.InterfaceC4756c;
import j1.InterfaceC4757d;

/* loaded from: classes5.dex */
public class SupportHelper implements InterfaceC4757d {
    private final boolean clearPassphrase;
    private byte[] passphrase;
    private SQLiteOpenHelper standardHelper;

    public SupportHelper(final InterfaceC4757d.b bVar, byte[] bArr, SQLiteDatabaseHook sQLiteDatabaseHook, boolean z10) {
        SQLiteDatabase.loadLibs(bVar.context);
        this.passphrase = bArr;
        this.clearPassphrase = z10;
        this.standardHelper = new SQLiteOpenHelper(bVar.context, bVar.name, null, bVar.callback.version, sQLiteDatabaseHook) { // from class: net.sqlcipher.database.SupportHelper.1
            @Override // net.sqlcipher.database.SQLiteOpenHelper
            public void onConfigure(SQLiteDatabase sQLiteDatabase) {
                bVar.callback.b(sQLiteDatabase);
            }

            @Override // net.sqlcipher.database.SQLiteOpenHelper
            public void onCreate(SQLiteDatabase sQLiteDatabase) {
                bVar.callback.d(sQLiteDatabase);
            }

            @Override // net.sqlcipher.database.SQLiteOpenHelper
            public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
                bVar.callback.e(sQLiteDatabase, i10, i11);
            }

            @Override // net.sqlcipher.database.SQLiteOpenHelper
            public void onOpen(SQLiteDatabase sQLiteDatabase) {
                bVar.callback.f(sQLiteDatabase);
            }

            @Override // net.sqlcipher.database.SQLiteOpenHelper
            public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
                bVar.callback.g(sQLiteDatabase, i10, i11);
            }
        };
    }

    @Override // j1.InterfaceC4757d, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.standardHelper.close();
    }

    @Override // j1.InterfaceC4757d
    public String getDatabaseName() {
        return this.standardHelper.getDatabaseName();
    }

    @Override // j1.InterfaceC4757d
    public InterfaceC4756c getReadableDatabase() {
        return getWritableDatabase();
    }

    @Override // j1.InterfaceC4757d
    public InterfaceC4756c getWritableDatabase() {
        try {
            SQLiteDatabase writableDatabase = this.standardHelper.getWritableDatabase(this.passphrase);
            if (this.clearPassphrase && this.passphrase != null) {
                int i10 = 0;
                while (true) {
                    byte[] bArr = this.passphrase;
                    if (i10 >= bArr.length) {
                        break;
                    }
                    bArr[i10] = 0;
                    i10++;
                }
            }
            return writableDatabase;
        } catch (SQLiteException e10) {
            byte[] bArr2 = this.passphrase;
            if (bArr2 != null) {
                boolean z10 = true;
                for (byte b10 : bArr2) {
                    z10 = z10 && b10 == 0;
                }
                if (z10) {
                    throw new IllegalStateException("The passphrase appears to be cleared. This happens by default the first time you use the factory to open a database, so we can remove the cleartext passphrase from memory. If you close the database yourself, please use a fresh SupportFactory to reopen it. If something else (e.g., Room) closed the database, and you cannot control that, use SupportFactory boolean constructor option to opt out of the automatic password clearing step. See the project README for more information.", e10);
                }
            }
            throw e10;
        }
    }

    @Override // j1.InterfaceC4757d
    public void setWriteAheadLoggingEnabled(boolean z10) {
        this.standardHelper.setWriteAheadLoggingEnabled(z10);
    }
}
