package i3;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import g3.C0742e;

/* renamed from: i3.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0760b extends SQLiteOpenHelper {

    /* renamed from: a, reason: collision with root package name */
    private static final String f17620a = "com.stepos.statsrpk.storage.b";

    /* renamed from: b, reason: collision with root package name */
    private static C0760b f17621b;

    private C0760b(Context context) {
        super(context, "statsrpk.db", (SQLiteDatabase.CursorFactory) null, 1);
        C0742e.c(f17620a, "DATABASE_VERSION 1");
    }

    public static synchronized C0760b a(Context context) {
        try {
            if (f17621b == null) {
                f17621b = new C0760b(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f17621b;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS 'events' (eventId INTEGER PRIMARY KEY autoincrement, rpkPkgName TEXT, appKey TEXT, encrypt INTEGER, eventSessionId TEXT, eventData TEXT, dateCreated TIMESTAMP DEFAULT CURRENT_TIMESTAMP, unique(eventId))");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i5, int i6) {
        C0742e.c(f17620a, "Upgrading database from version " + i5 + " to " + i6);
    }
}
