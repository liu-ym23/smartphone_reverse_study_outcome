package va;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import ta.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a extends SQLiteOpenHelper {

    /* renamed from: a, reason: collision with root package name */
    public static a f13490a;

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS 'events' (eventId INTEGER PRIMARY KEY autoincrement, rpkPkgName TEXT, appKey TEXT, encrypt INTEGER, eventSessionId TEXT, eventData TEXT, dateCreated TIMESTAMP DEFAULT CURRENT_TIMESTAMP, unique(eventId))");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        c.a("com.stepos.statsrpk.storage.b", "Upgrading database from version " + i10 + " to " + i11);
    }
}
