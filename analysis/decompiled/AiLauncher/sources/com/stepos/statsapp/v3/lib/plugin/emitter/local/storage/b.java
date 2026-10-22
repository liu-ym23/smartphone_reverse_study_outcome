package com.stepos.statsapp.v3.lib.plugin.emitter.local.storage;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.stepos.statsapp.v3.lib.plugin.utils.ProcessUtils;
import com.stepos.statsapp.v3.utils.log.Logger;

/* loaded from: classes2.dex */
public class b extends SQLiteOpenHelper {

    /* renamed from: a, reason: collision with root package name */
    private static final String f30734a = "com.stepos.statsapp.v3.lib.plugin.emitter.local.storage.b";

    /* renamed from: b, reason: collision with root package name */
    public static final String f30735b = "events";

    /* renamed from: c, reason: collision with root package name */
    public static final String f30736c = "encrypt";

    /* renamed from: d, reason: collision with root package name */
    public static final String f30737d = "eventId";

    /* renamed from: e, reason: collision with root package name */
    public static final String f30738e = "eventSessionId";

    /* renamed from: f, reason: collision with root package name */
    public static final String f30739f = "eventSource";

    /* renamed from: g, reason: collision with root package name */
    public static final String f30740g = "eventData";

    /* renamed from: h, reason: collision with root package name */
    public static final String f30741h = "dateCreated";

    /* renamed from: i, reason: collision with root package name */
    public static final String f30742i = "emitterMiscellaneous";

    /* renamed from: j, reason: collision with root package name */
    public static final String f30743j = "lastResetTime";

    /* renamed from: k, reason: collision with root package name */
    public static final String f30744k = "traffic";

    /* renamed from: l, reason: collision with root package name */
    public static final String f30745l = "statsapp_v3.db";

    /* renamed from: m, reason: collision with root package name */
    private static final int f30746m = 1;

    /* renamed from: n, reason: collision with root package name */
    private static final String f30747n = "CREATE TABLE IF NOT EXISTS 'events' (eventId INTEGER PRIMARY KEY autoincrement, encrypt INTEGER, eventSessionId TEXT, eventSource TEXT, eventData TEXT, dateCreated TIMESTAMP DEFAULT CURRENT_TIMESTAMP)";

    /* renamed from: o, reason: collision with root package name */
    private static final String f30748o = "CREATE TABLE IF NOT EXISTS 'emitterMiscellaneous' (lastResetTime BIGINT, traffic INTEGER)";

    /* renamed from: p, reason: collision with root package name */
    private static b f30749p;

    private b(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
    }

    public static synchronized b a(Context context) {
        String str;
        try {
            if (f30749p == null) {
                String currentProcessName = ProcessUtils.getCurrentProcessName(context);
                if (currentProcessName == null || currentProcessName.equals(context.getPackageName())) {
                    str = f30745l;
                } else {
                    str = "statsapp_v3.db_" + currentProcessName;
                }
                f30749p = new b(context, str);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f30749p;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL(f30747n);
        sQLiteDatabase.execSQL(f30748o);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        Logger.d(f30734a, "Upgrading database from version " + i10 + " to " + i11);
    }
}
