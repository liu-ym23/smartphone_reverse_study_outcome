package a77;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.push.utils.f;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f2037d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f2038e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile c f2039f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SQLiteDatabase f2040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f2041b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f2042c;

    public static class a extends SQLiteOpenHelper {
        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase r100, int r101, int r102) {
        }

        public a(Context r100) {
            super(r100, "ss_push_monitor.db", null, 1);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase r100) {
            r100.execSQL("CREATE TABLE event ( _id INTEGER PRIMARY KEY AUTOINCREMENT, service_name VARCHAR, category VARCHAR, metric VARCHAR, extra VARCHAR )");     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            f.e("MultiProcessMonitorDBHelper", "create db exception " + e);
        }
    }

    public final synchronized List b() {
        monitor-enter(this);
        ArrayList r100 = new ArrayList();     // Catch: Throwable -> L34
        SQLiteDatabase r101 = e();     // Catch: Throwable -> L26
        if (r101 != null) goto L7;
    L22:
        f.i("MultiProcessMonitorDBHelper", "[deleteEvent] db not establish and open");     // Catch: Throwable -> L26
        a();     // Catch: Throwable -> L34
        monitor-exit(this);
        return r100;
    L7:
        if (r101.isOpen() == false) goto L22;
        Cursor r110 = null;
        r110 = r101.query("event", f2037d, null, null, null, null, "_id ASC", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);     // Catch: Throwable -> L16
    L13:
        if (r110.moveToNext() == false) goto L18;
        r100.add(new b(r110));     // Catch: Throwable -> L16
    L18:
        f(r110);     // Catch: Throwable -> L26
    L28:
        a();     // Catch: Throwable -> L34
        monitor-exit(this);
        return r100;
    L16:
        th = move-exception;
        f.f("MultiProcessMonitorDBHelper", "[getEvents] error when sqLiteDatabase.query ", th);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        f(r110);     // Catch: Throwable -> L26
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        f.f("MultiProcessMonitorDBHelper", "[getEvents] error when getEvents ", th);     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        a();     // Catch: Throwable -> L34
        throw th;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        throw th;
    }

    public final synchronized SQLiteDatabase e() {
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L4:
        if (this.f2040a != null) goto L18;
        monitor-enter(this);     // Catch: Throwable -> L21
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L7:
        if (this.f2040a != null) goto L13;
        f.b("MultiProcessMonitorDBHelper", "lock file for open db");     // Catch: Throwable -> L15
        s67.a.a("push_monitor_db.lock").b(this.f2041b);     // Catch: Throwable -> L15
        this.f2040a = this.f2042c.getWritableDatabase();     // Catch: Throwable -> L11
        f.b("MultiProcessMonitorDBHelper", "success lock file and open db");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        f.f("MultiProcessMonitorDBHelper", "error when open db", th);     // Catch: Throwable -> L15
    L13:
        monitor-exit(this);     // Catch: Throwable -> L15
    L18:
        SQLiteDatabase r100 = this.f2040a;     // Catch: Throwable -> L21
        monitor-exit(this);
        return r100;
    }

    public final synchronized void a() {
        monitor-enter(this);
        SQLiteDatabase r100 = this.f2040a;     // Catch: Throwable -> L10
        if (r100 != null) goto L7;
    L12:
        monitor-exit(this);
        return;
    L7:
        if (r100.isOpen() == false) goto L12;
        f.b("MultiProcessMonitorDBHelper", "close db and  unlock file");     // Catch: Throwable -> L10
        this.f2040a.close();     // Catch: Throwable -> L10
        this.f2040a = null;     // Catch: Throwable -> L10
        s67.a.a("push_monitor_db.lock").d();     // Catch: Throwable -> L10
        f.b("MultiProcessMonitorDBHelper", "success close db and unlock file");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        f.e("MultiProcessMonitorDBHelper", "error when close db: " + th);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    static {
        f2037d = new String[]{DBDefinition.ID, "service_name", "category", "metric", "extra"};
        f2038e = new Object();
    }

    public c(Context r100) {
        this.f2041b = r100;
        this.f2042c = new a(r100);
    }

    public static c c(Context r100) {
        if (f2039f != null) goto L15;
        Object r101 = f2038e;
        monitor-enter(r101);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f2039f != null) goto L9;
        f2039f = new c(r100.getApplicationContext());     // Catch: Throwable -> L11
    L9:
        monitor-exit(r101);     // Catch: Throwable -> L11
    L15:
        return f2039f;
    }

    public static void f(Cursor r100) {
        if (r100 == null) goto L10;
        if (r100.isClosed() == true) goto L11;
        r100.close();     // Catch: Exception -> L7
        return;
    L11:
        return;
    L12:
        return;
    }

    public final synchronized long d(b r100) {
        monitor-enter(this);
        SQLiteDatabase r101 = e();     // Catch: Throwable -> L18
        if (r101 != null) goto L7;
    L12:
        f.i("MultiProcessMonitorDBHelper", "[insertEvent] db not establish and open");     // Catch: Throwable -> L18
        a();     // Catch: Throwable -> L16
        monitor-exit(this);
        return -1;
    L7:
        if (r101.isOpen() == false) goto L12;
        ContentValues r102 = new ContentValues();     // Catch: Throwable -> L18
        r102.put("service_name", r100.f2033b);     // Catch: Throwable -> L18
        r102.put("category", r100.f2034c);     // Catch: Throwable -> L18
        r102.put("metric", r100.f2035d);     // Catch: Throwable -> L18
        r102.put("extra", r100.f2036e);     // Catch: Throwable -> L18
        long r103 = r101.insert("event", null, r102);     // Catch: Throwable -> L18
        a();     // Catch: Throwable -> L16
        monitor-exit(this);
        return r103;
    L16:
        th = move-exception;
        throw th;
    L18:
        th = move-exception;
        f.f("MultiProcessMonitorDBHelper", "[insertEvent] error when insert monitor event to db ", th);     // Catch: Throwable -> L23
        a();     // Catch: Throwable -> L16
        return -1;
    L23:
        th = move-exception;
        a();     // Catch: Throwable -> L16
        throw th;     // Catch: Throwable -> L16
    }
}
