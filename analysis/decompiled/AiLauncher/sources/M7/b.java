package M7;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.stepos.statsapp.v3.utils.log.Logger;

/* loaded from: classes2.dex */
public class b extends SQLiteOpenHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final String f4650a = "com.stepos.statsrpk.storage.b";

    /* renamed from: b, reason: collision with root package name */
    public static b f4651b;

    public b(Context context) {
        super(context, "statsrpk.db", (SQLiteDatabase.CursorFactory) null, 1);
        Logger.d(f4650a, "DATABASE_VERSION 1");
    }

    public static synchronized b b(Context context) {
        try {
            if (f4651b == null) {
                f4651b = new b(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f4651b;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS 'events' (eventId INTEGER PRIMARY KEY autoincrement, rpkPkgName TEXT, appKey TEXT, encrypt INTEGER, eventSessionId TEXT, eventData TEXT, dateCreated TIMESTAMP DEFAULT CURRENT_TIMESTAMP, unique(eventId))");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        Logger.d(f4650a, "Upgrading database from version " + i10 + " to " + i11);
    }
}
