package Y5;

import M0.i;
import W5.c;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.stepos.aiengine.args.SingleFileBundle;
import java.util.HashMap;
import java.util.Iterator;
import v.d;
import w.h;

/* loaded from: classes3.dex */
public final class b extends SQLiteOpenHelper {
    public static b b;
    public static final /* synthetic */ int c = 0;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1564a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i, int i6) {
        super(context, str, cursorFactory, i);
        this.f1564a = i6;
    }

    private final void b(SQLiteDatabase sQLiteDatabase, int i, int i6) {
    }

    private final void c(SQLiteDatabase sQLiteDatabase, int i, int i6) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        switch (this.f1564a) {
            case 0:
                sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS 'events' (eventId INTEGER PRIMARY KEY autoincrement, rpkPkgName TEXT, appKey TEXT, encrypt INTEGER, eventSessionId TEXT, eventData TEXT, dateCreated TIMESTAMP DEFAULT CURRENT_TIMESTAMP, unique(eventId))");
                return;
            case 1:
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append("CREATE TABLE ");
                    sb.append("duplicatelog");
                    sb.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
                    HashMap map = new HashMap();
                    map.put(SingleFileBundle.KEY_PATH, "TEXT");
                    map.put("insert_time", "INTEGER");
                    map.put("ext1", "TEXT");
                    map.put("ext2", "TEXT");
                    for (String str : map.keySet()) {
                        sb.append(str);
                        sb.append(" ");
                        sb.append((String) map.get(str));
                        sb.append(",");
                    }
                    sb.delete(sb.length() - 1, sb.length());
                    sb.append(")");
                    sQLiteDatabase.execSQL(sb.toString());
                    return;
                } catch (Throwable th) {
                    int i = com.apm.insight.b.f2156a;
                    i.k("NPTH_CATCH", th);
                    return;
                }
            case 2:
                try {
                    sQLiteDatabase.execSQL("CREATE TABLE queue ( _id INTEGER PRIMARY KEY AUTOINCREMENT, value BLOB, type TEXT, timestamp INTEGER, retry_count INTEGER, retry_time INTEGER )");
                    return;
                } catch (Exception e) {
                    e.toString();
                    return;
                }
            case 3:
                try {
                    sQLiteDatabase.beginTransaction();
                    Iterator it = d.d.values().iterator();
                    while (it.hasNext()) {
                        String strA = ((v.b) it.next()).a();
                        if (strA != null) {
                            sQLiteDatabase.execSQL(strA);
                        }
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                    return;
                } catch (Throwable th2) {
                    try {
                        h.b(th2);
                        return;
                    } finally {
                        U7.a.g(sQLiteDatabase);
                    }
                }
            default:
                try {
                    sQLiteDatabase.execSQL("CREATE TABLE local_monitor_log ( _id Integer PRIMARY KEY AUTOINCREMENT, type VARCHAR, type2 VARCHAR, timestamp Integer, version_id Integer, is_sampled Integer DEFAULT 0, data TEXT, delete_flag TEXT, extra1 TEXT, extra2 TEXT, extra3 TEXT, extra4 TEXT  )");
                    sQLiteDatabase.execSQL("CREATE TABLE local_monitor_version ( _id INTEGER PRIMARY KEY AUTOINCREMENT, version_code TEXT, version_name TEXT, manifest_version_code TEXT, update_version_code TEXT, app_version TEXT, extra1 TEXT, extra2 TEXT  )");
                    sQLiteDatabase.execSQL("CREATE TABLE t_battery ( _id INTEGER PRIMARY KEY AUTOINCREMENT, version_id Integer, front Integer, timestamp Integer, type TEXT, status Integer, scene TEXT, accumulation Integer, source TEXT, delete_flag Integer DEFAULT 0, process TEXT, main_process Integer, sid TEXT, extra1 TEXT, extra2 TEXT, extra3 TEXT, extra4 TEXT  )");
                    sQLiteDatabase.execSQL("CREATE TABLE t_traffic ( _id INTEGER PRIMARY KEY AUTOINCREMENT, version_id Integer, timestamp Integer, network_type Integer, front Integer, type TEXT, type2 Integer, value Integer, send Integer, sid Integer, delete_flag Integer DEFAULT 0, content TEXT, extra1 TEXT, extra2 TEXT, extra3 TEXT, extra4 TEXT  )");
                    sQLiteDatabase.execSQL("CREATE TABLE t_apiall ( _id INTEGER PRIMARY KEY AUTOINCREMENT, version_id Integer, front Integer, timestamp Integer, hit_rules Integer DEFAULT 0, traffic_value Integer DEFAULT 0, type TEXT, type2 TEXT, type3 TEXT, type4 TEXT, network_type Integer, sid Integer, is_sampled Integer, delete_flag Integer, data TEXT, extra1 TEXT, extra2 TEXT, extra3 TEXT, extra4 TEXT  )");
                    return;
                } catch (Exception unused) {
                    return;
                }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i6) throws SQLException {
        switch (this.f1564a) {
            case 3:
                onUpgrade(sQLiteDatabase, i, i6);
                break;
            default:
                super.onDowngrade(sQLiteDatabase, i, i6);
                break;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i6) throws SQLException {
        switch (this.f1564a) {
            case 0:
                c.a("com.stepos.statsrpk.storage.b", "Upgrading database from version " + i + " to " + i6);
                return;
            case 1:
            case 2:
                return;
            case 3:
                h.a("onUpgrade, " + i + ", " + i6, null);
                try {
                    sQLiteDatabase.beginTransaction();
                    Iterator it = d.d.values().iterator();
                    while (it.hasNext()) {
                        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ((v.b) it.next()).m());
                    }
                    sQLiteDatabase.setTransactionSuccessful();
                } finally {
                    try {
                        U7.a.g(sQLiteDatabase);
                        onCreate(sQLiteDatabase);
                        return;
                    } catch (Throwable th) {
                    }
                }
                U7.a.g(sQLiteDatabase);
                onCreate(sQLiteDatabase);
                return;
            default:
                sQLiteDatabase.setVersion(1);
                return;
        }
    }
}
