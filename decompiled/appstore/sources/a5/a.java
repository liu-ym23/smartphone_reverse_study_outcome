package a5;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.framwork.core.sdkmonitor.h;

/* JADX INFO: loaded from: classes.dex */
public class a extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f28a;

    static {
    }

    public a(Context r10, String r11) {
        super(r10, r11, null, 1);
    }

    public static a a(Context r10) {
        if (f28a != null) goto L16;
        monitor-enter(a.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f28a != null) goto L11;
        f28a = new a(r10, h.a(r10) + "sdkmon_v2.db");     // Catch: Throwable -> L9
    L11:
        monitor-exit(a.class);     // Catch: Throwable -> L9
    L16:
        return f28a;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase r10) {
        r10.execSQL("CREATE TABLE monitor_log ( _id Integer PRIMARY KEY AUTOINCREMENT, aid Integer, type VARCHAR, type2 VARCHAR, time Integer, data TEXT, data2 TEXT, data3 TEXT  )");     // Catch: Exception -> L4
        r10.execSQL("CREATE TABLE queue ( _id INTEGER PRIMARY KEY AUTOINCREMENT, value BLOB, type TEXT, timestamp INTEGER, retry_count INTEGER, retry_time INTEGER )");     // Catch: Exception -> L4
        return;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase r10, int r11, int r12) {
    }
}
