package com.stepos.datacenter.fts.sqlite;

import Y8.t;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import d7.d;
import io.requery.android.database.sqlite.SQLiteDatabase;
import io.requery.android.database.sqlite.SQLiteOpenHelper;
import io.requery.android.database.sqlite.SQLiteStatement;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u0000 #2\u00020\u0001:\u0001\u001cB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0014\u0010\u000eJ\u0017\u0010\u0015\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0015\u0010\u000eJ\u0015\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\fH\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010 \u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\u001d¨\u0006$"}, d2 = {"Lcom/stepos/datacenter/fts/sqlite/a;", "Lio/requery/android/database/sqlite/SQLiteOpenHelper;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Lio/requery/android/database/sqlite/SQLiteStatement;", "l", "()Lio/requery/android/database/sqlite/SQLiteStatement;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Lio/requery/android/database/sqlite/SQLiteDatabase;", "db", "LY8/t;", "onCreate", "(Lio/requery/android/database/sqlite/SQLiteDatabase;)V", "", "oldVersion", "newVersion", "onUpgrade", "(Lio/requery/android/database/sqlite/SQLiteDatabase;II)V", "onConfigure", "onOpen", "", "tableName", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;)V", "close", "()V", Const.INTENT_KEY_APIKEY, "Lio/requery/android/database/sqlite/SQLiteStatement;", "insertDataStmt", Const.INTENT_KEY_PKGNAME, "deleteDataStmt", "c", "deleteByTableStmt", "Companion", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a extends SQLiteOpenHelper {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    public static volatile a f30089d;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public volatile SQLiteStatement insertDataStmt;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public volatile SQLiteStatement deleteDataStmt;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public volatile SQLiteStatement deleteByTableStmt;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\rR\u0014\u0010\u0013\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\rR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/datacenter/fts/sqlite/a$a;", "", "<init>", "()V", "Landroid/content/Context;", "context", "Lcom/stepos/datacenter/fts/sqlite/a;", "c", "(Landroid/content/Context;)Lcom/stepos/datacenter/fts/sqlite/a;", "", Const.INTENT_KEY_PKGNAME, "()Ljava/lang/String;", "TAG", "Ljava/lang/String;", "DATABASE_NAME", "", "DATABASE_VERSION", "I", "TABLE_FTS_CONTENT", "TABLE_FTS_DATA", "INSTANCE", "Lcom/stepos/datacenter/fts/sqlite/a;", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: com.stepos.datacenter.fts.sqlite.a$a, reason: collision with other inner class name and from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final String b() {
            File file = new File(d.f32141a.a(), "database");
            if (!file.exists()) {
                file.mkdirs();
            }
            String absolutePath = new File(file, "fts_search_v2.db").getAbsolutePath();
            p.h(absolutePath, "getAbsolutePath(...)");
            return absolutePath;
        }

        public final a c(Context context) {
            a aVar;
            p.i(context, "context");
            a aVar2 = a.f30089d;
            if (aVar2 != null) {
                return aVar2;
            }
            synchronized (this) {
                aVar = a.f30089d;
                if (aVar == null) {
                    Context applicationContext = context.getApplicationContext();
                    p.h(applicationContext, "getApplicationContext(...)");
                    aVar = new a(applicationContext, null);
                    a.f30089d = aVar;
                }
            }
            return aVar;
        }

        public Companion() {
        }
    }

    public /* synthetic */ a(Context context, i iVar) {
        this(context);
    }

    @Override // io.requery.android.database.sqlite.SQLiteOpenHelper, j1.InterfaceC4757d, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            try {
                SQLiteStatement sQLiteStatement = this.insertDataStmt;
                if (sQLiteStatement != null) {
                    sQLiteStatement.close();
                }
                this.insertDataStmt = null;
                SQLiteStatement sQLiteStatement2 = this.deleteDataStmt;
                if (sQLiteStatement2 != null) {
                    sQLiteStatement2.close();
                }
                this.deleteDataStmt = null;
                SQLiteStatement sQLiteStatement3 = this.deleteByTableStmt;
                if (sQLiteStatement3 != null) {
                    sQLiteStatement3.close();
                }
                this.deleteByTableStmt = null;
                t tVar = t.f7040a;
            } catch (Throwable th) {
                throw th;
            }
        }
        super.close();
    }

    public final void g(String tableName) {
        p.i(tableName, "tableName");
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            writableDatabase.execSQL("DELETE FROM fts_data WHERE table_name = ?", new String[]{tableName});
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
            Log.d("FtsDbHelper", "FTS index cleared for table: " + tableName);
        } catch (Throwable th) {
            writableDatabase.endTransaction();
            throw th;
        }
    }

    public final SQLiteStatement i() {
        SQLiteStatement sQLiteStatementCompileStatement;
        SQLiteStatement sQLiteStatement = this.deleteDataStmt;
        if (sQLiteStatement != null) {
            return sQLiteStatement;
        }
        synchronized (this) {
            sQLiteStatementCompileStatement = this.deleteDataStmt;
            if (sQLiteStatementCompileStatement == null) {
                sQLiteStatementCompileStatement = getWritableDatabase().compileStatement("\n                DELETE FROM fts_data WHERE doc_id = ? AND table_name = ?\n            ");
                this.deleteDataStmt = sQLiteStatementCompileStatement;
                p.h(sQLiteStatementCompileStatement, "also(...)");
            }
        }
        return sQLiteStatementCompileStatement;
    }

    public final SQLiteStatement l() {
        SQLiteStatement sQLiteStatementCompileStatement;
        SQLiteStatement sQLiteStatement = this.insertDataStmt;
        if (sQLiteStatement != null) {
            return sQLiteStatement;
        }
        synchronized (this) {
            sQLiteStatementCompileStatement = this.insertDataStmt;
            if (sQLiteStatementCompileStatement == null) {
                sQLiteStatementCompileStatement = getWritableDatabase().compileStatement("\n                INSERT OR REPLACE INTO fts_data(doc_id, table_name, content, updated_at) \n                VALUES (?, ?, ?, ?)\n            ");
                this.insertDataStmt = sQLiteStatementCompileStatement;
                p.h(sQLiteStatementCompileStatement, "also(...)");
            }
        }
        return sQLiteStatementCompileStatement;
    }

    @Override // io.requery.android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase db2) {
        p.i(db2, "db");
        super.onConfigure(db2);
        db2.enableWriteAheadLogging();
    }

    @Override // io.requery.android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase db2) throws SQLException {
        p.i(db2, "db");
        Log.d("FtsDbHelper", "Creating optimized FTS5 database...");
        db2.execSQL("\n            CREATE TABLE IF NOT EXISTS fts_data (\n                id INTEGER PRIMARY KEY,\n                doc_id INTEGER NOT NULL,\n                table_name TEXT NOT NULL,\n                content TEXT NOT NULL,\n                created_at INTEGER DEFAULT (strftime('%s', 'now') * 1000),\n                updated_at INTEGER DEFAULT (strftime('%s', 'now') * 1000),\n                UNIQUE(doc_id, table_name)\n            )\n        ");
        db2.execSQL("\n            CREATE VIRTUAL TABLE IF NOT EXISTS fts_content USING fts5(\n                content,\n                content=fts_data,\n                content_rowid=id,\n                tokenize='unicode61 remove_diacritics 2',\n                columnsize=0\n            )\n        ");
        db2.execSQL("CREATE INDEX IF NOT EXISTS idx_fts_data_doc_table ON fts_data(doc_id, table_name)");
        db2.execSQL("CREATE INDEX IF NOT EXISTS idx_fts_data_table ON fts_data(table_name)");
        db2.execSQL("\n            CREATE TRIGGER IF NOT EXISTS fts_data_ai AFTER INSERT ON fts_data BEGIN\n                INSERT INTO fts_content(rowid, content) VALUES (new.id, new.content);\n            END\n        ");
        db2.execSQL("\n            CREATE TRIGGER IF NOT EXISTS fts_data_ad AFTER DELETE ON fts_data BEGIN\n                INSERT INTO fts_content(fts_content, rowid, content) VALUES('delete', old.id, old.content);\n            END\n        ");
        db2.execSQL("\n            CREATE TRIGGER IF NOT EXISTS fts_data_au AFTER UPDATE ON fts_data BEGIN\n                INSERT INTO fts_content(fts_content, rowid, content) VALUES('delete', old.id, old.content);\n                INSERT INTO fts_content(rowid, content) VALUES (new.id, new.content);\n            END\n        ");
        Log.d("FtsDbHelper", "Optimized FTS5 database created successfully");
    }

    @Override // io.requery.android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase db2) {
        p.i(db2, "db");
        super.onOpen(db2);
        try {
            db2.execSQL("PRAGMA synchronous = NORMAL");
            db2.execSQL("PRAGMA cache_size = -8000");
            db2.execSQL("PRAGMA temp_store = MEMORY");
            db2.execSQL("PRAGMA mmap_size = 268435456");
        } catch (Exception e10) {
            Log.w("FtsDbHelper", "Failed to set PRAGMA: " + e10.getMessage());
        }
        try {
            Cursor cursorRawQuery = db2.rawQuery("SELECT 1 FROM fts_data LIMIT 1", null);
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        } catch (Exception unused) {
        }
    }

    @Override // io.requery.android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase db2, int oldVersion, int newVersion) throws SQLException {
        p.i(db2, "db");
        Log.d("FtsDbHelper", "Upgrading FTS5 database from " + oldVersion + " to " + newVersion);
        db2.execSQL("DROP TRIGGER IF EXISTS fts_data_ai");
        db2.execSQL("DROP TRIGGER IF EXISTS fts_data_ad");
        db2.execSQL("DROP TRIGGER IF EXISTS fts_data_au");
        db2.execSQL("DROP TABLE IF EXISTS fts_doc_index");
        db2.execSQL("DROP TABLE IF EXISTS fts_content");
        db2.execSQL("DROP TABLE IF EXISTS fts_data");
        onCreate(db2);
    }

    public a(Context context) {
        super(context, INSTANCE.b(), null, 2);
    }
}
