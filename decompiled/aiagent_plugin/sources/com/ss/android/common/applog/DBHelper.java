package com.ss.android.common.applog;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteBlobTooBigException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteFullException;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class DBHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static volatile String f37103a = "ss_app_log.db";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f37104b = 200;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final String[] f37105c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final String[] f37106d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final String[] f37107e = null;
    static final String[] f = null;
    static final String[] g = null;
    static final String[] h = null;
    private static final String[] k = null;
    private static final Object l = null;
    private static DBHelper m;
    final Set<Long> i;
    final Set<Long> j;
    private SQLiteDatabase n;
    private final Context o;

    private static class OpenHelper extends SQLiteOpenHelper {
        static final String createTableEvent = "CREATE TABLE IF NOT EXISTS event ( _id INTEGER PRIMARY KEY AUTOINCREMENT, category VARCHAR, tag VARCHAR, label VARCHAR, value INTEGER, ext_value INTEGER, ext_json TEXT, user_id INTEGER, timestamp INTEGER, session_id INTEGER, event_index INTEGER NOT NULL DEFAULT 0, user_type INTEGER NOT NULL DEFAULT 0, user_is_login INTEGER NOT NULL DEFAULT 0, user_is_auth INTEGER NOT NULL DEFAULT 0, uid INTEGER NOT NULL DEFAULT 0, disable_personalization VARCHAR, _event_id INTEGER NOT NULL DEFAULT 0 )";
        static final String createTableMiscLog = "CREATE TABLE IF NOT EXISTS misc_log ( _id INTEGER PRIMARY KEY AUTOINCREMENT, log_type VARCHAR, value TEXT, session_id INTEGER, _event_id INTEGER NOT NULL DEFAULT 0 )";
        static final String createTablePage = "CREATE TABLE IF NOT EXISTS page ( _id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, duration INTEGER, session_id INTEGER )";
        static final String createTableQueue = "CREATE TABLE IF NOT EXISTS queue ( _id INTEGER PRIMARY KEY AUTOINCREMENT, value TEXT, is_crash INTEGER NOT NULL DEFAULT 0, log_type INTEGER NOT NULL DEFAULT 0, timestamp INTEGER, retry_count INTEGER, retry_time INTEGER )";
        static final String createTableSession = "CREATE TABLE IF NOT EXISTS session ( _id INTEGER PRIMARY KEY AUTOINCREMENT, value VARCHAR NOT NULL, timestamp INTEGER, duration INTEGER, non_page INTEGER, app_version VARCHAR, version_code INTEGER, pausetime INTEGER,launch_sent INTEGER NOT NULL DEFAULT 0, event_index INTEGER NOT NULL DEFAULT 0  )";
        static final String createTableSuccRate = "CREATE TABLE IF NOT EXISTS succ_rate ( _id INTEGER PRIMARY KEY AUTOINCREMENT, event_name VARCHAR, event_fail_reason INTEGER, event_fail_cnt INTEGER NOT NULL DEFAULT 0, event_date INTEGER )";

        public OpenHelper(Context r4) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin"), DBHelper.f37103a, null, 14);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase r1) {
            r1.execSQL(createTableSession);     // Catch: Exception -> L4
            r1.execSQL(createTableEvent);     // Catch: Exception -> L4
            r1.execSQL(createTablePage);     // Catch: Exception -> L4
            r1.execSQL(createTableQueue);     // Catch: Exception -> L4
            r1.execSQL(createTableMiscLog);     // Catch: Exception -> L4
            r1.execSQL(createTableSuccRate);     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            com.ss.android.common.util.e.e("AppLogcreate db exception ", e);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase r2, int r3, int r4) {
            if (r3 >= 2) goto L6;
            r2.execSQL("ALTER TABLE event ADD COLUMN user_id INTEGER");
        L6:
            if (r3 >= 3) goto L9;
            r2.execSQL("ALTER TABLE session ADD COLUMN launch_sent INTEGER NOT NULL DEFAULT 0");
        L9:
            if (r3 >= 4) goto L12;
            r2.execSQL("ALTER TABLE queue ADD COLUMN is_crash INTEGER NOT NULL DEFAULT 0");
        L12:
            if (r3 >= 5) goto L15;
            r2.execSQL("ALTER TABLE event ADD COLUMN ext_json TEXT");
        L15:
            if (r3 >= 6) goto L18;
            r2.execSQL("ALTER TABLE queue ADD COLUMN log_type INTEGER NOT NULL DEFAULT 0");
        L18:
            if (r3 >= 7) goto L21;
            r2.execSQL(createTableMiscLog);
        L21:
            if (r3 >= 8) goto L24;
            r2.execSQL("ALTER TABLE event ADD COLUMN event_index INTEGER NOT NULL DEFAULT 0");
        L24:
            if (r3 >= 9) goto L27;
            r2.execSQL("ALTER TABLE session ADD COLUMN event_index INTEGER NOT NULL DEFAULT 0");
        L27:
            if (r3 >= 10) goto L30;
            r2.execSQL(createTableSuccRate);
        L30:
            if (r3 < 12) goto L57;
        L35:
            if (r3 >= 12) goto L41;
            r2.execSQL("ALTER TABLE event ADD COLUMN uid INTEGER NOT NULL DEFAULT 0");     // Catch: Throwable -> L38
        L38:
            th = move-exception;
            com.ss.android.common.util.e.e("alter table add column failed", th);
        L41:
            if (r3 >= 13) goto L47;
            r2.execSQL("ALTER TABLE event ADD COLUMN disable_personalization VARCHAR");     // Catch: Throwable -> L44
        L44:
            th = move-exception;
            com.ss.android.common.util.e.e("alter table add column failed", th);
        L47:
            if (r3 >= 14) goto L67;
            r2.execSQL("ALTER TABLE event ADD COLUMN _event_id INTEGER NOT NULL DEFAULT 0");     // Catch: Throwable -> L50
        L59:
            r2.execSQL("ALTER TABLE misc_log ADD COLUMN _event_id INTEGER NOT NULL DEFAULT 0");     // Catch: Throwable -> L54
            return;
        L54:
            th = move-exception;
            com.ss.android.common.util.e.e("alter table add column failed", th);
            return;
        L50:
            th = move-exception;
            com.ss.android.common.util.e.e("alter table add column failed", th);
            goto L59
        L67:
            return;
        L57:
            r2.execSQL("ALTER TABLE event ADD COLUMN user_type INTEGER NOT NULL DEFAULT 0");     // Catch: Throwable -> L33
            r2.execSQL("ALTER TABLE event ADD COLUMN user_is_login INTEGER NOT NULL DEFAULT 0");     // Catch: Throwable -> L33
            r2.execSQL("ALTER TABLE event ADD COLUMN user_is_auth INTEGER NOT NULL DEFAULT 0");     // Catch: Throwable -> L33
        L33:
            th = move-exception;
            com.ss.android.common.util.e.e("alter table add column failed", th);
            goto L35
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase r6, int r7, int r8) {
            String[] r9 = DBHelper.c();
            int r10 = r9.length;
            int r0 = 0;
        L3:
            if (r0 >= r10) goto L10;
            String r1 = r9[r0];
            r6.execSQL("DROP TABLE IF EXISTS " + r1);     // Catch: Throwable -> L7
        L9:
            r0 = r0 + 1;
        L7:
            th = move-exception;
            com.ss.android.common.util.e.e("drop table failed, " + r1, th);
            goto L9
        L10:
            onCreate(r6);
        }
    }

    static /* synthetic */ String[] c() {
        return k;
    }

    static {
        k = new String[]{"event", "page", SensitiveType.SESSION, "misc_log", "succ_rate", "queue"};
        f37105c = new String[]{"_id", "name", "duration", "session_id"};
        f37106d = new String[]{"_id", "value", "is_crash", com.bytedance.apm.battery.dao.DBHelper.COL_TIME, "retry_count", "retry_time", "log_type"};
        f37107e = new String[]{"_id", "value", com.bytedance.apm.battery.dao.DBHelper.COL_TIME, "duration", "non_page", WsConstants.KEY_APP_VERSION, "version_code", "pausetime", "launch_sent", "event_index"};
        f = new String[]{"_id", "category", "tag", "label", "value", "ext_value", "ext_json", "user_id", com.bytedance.apm.battery.dao.DBHelper.COL_TIME, "session_id", "event_index", "user_type", "user_is_login", "user_is_auth", "uid", "disable_personalization", "_event_id"};
        g = new String[]{"_id", "log_type", "value", "session_id", "_event_id"};
        h = new String[]{"_id", "log_type", "value"};
        l = new Object();
    }

    public static DBHelper a(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        Object r0 = l;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (m != null) goto L7;
        m = new DBHelper((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L10
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return m;
    }

    public static void a(Cursor r2) {
        Cursor r3 = (Cursor) ZeusTransformUtils.wrapperContextForParams(r2, Cursor.class, "com.obric.aiagent.plugin");
        if (r3 == null) goto L11;
        if (r3.isClosed() == true) goto L12;
        r3.close();     // Catch: Throwable -> L8
        return;
    L12:
        return;
    L13:
        return;
    }

    public static synchronized void a(Cursor r3, SQLiteDatabase r4) {
        monitor-enter(DBHelper.class);
        a((Cursor) ZeusTransformUtils.wrapperContextForParams(r3, Cursor.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L19
        if (r4 != null) goto L25;
    L17:
        monitor-exit(DBHelper.class);
        return;
    L25:
    L10:
        th = move-exception;
        com.ss.android.common.util.e.e("safeCloseCursorAndEndTX failed: " + th.getMessage(), th);     // Catch: Throwable -> L19
        if (ZeusTransformUtils.instanceOf(th, SQLiteFullException.class) == false) goto L17;
        r4.execSQL("VACUUM");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        com.ss.android.common.util.e.e("VACUUM failed:" + th.getMessage(), th);     // Catch: Throwable -> L19
        goto L17
    L7:
        if (r4.inTransaction() == false) goto L17;
        r4.endTransaction();     // Catch: Throwable -> L10
    L19:
        th = move-exception;
        throw th;
    }

    private DBHelper(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        this.i = new HashSet();
        this.j = new HashSet();
        this.n = new OpenHelper(r4).getWritableDatabase();
        this.o = ZeusTransformUtils.wrapperContext(r4, "com.obric.aiagent.plugin");
    }

    public synchronized long a(p r5) {
        monitor-enter(this);
        SQLiteDatabase r0 = this.n;     // Catch: Throwable -> L24
        if (r0 != null) goto L6;
    L20:
        com.ss.android.common.util.e.d("AppLog db not establish and open");     // Catch: Throwable -> L24
        monitor-exit(this);
        return -1;
    L6:
        if (r0.isOpen() == false) goto L20;
        ContentValues r1 = new ContentValues();     // Catch: Throwable -> L24
        r1.put("category", r5.f37198b);     // Catch: Throwable -> L24
        r1.put("tag", r5.f37199c);     // Catch: Throwable -> L24
        if (com.bytedance.common.utility.j.a(r5.f37200d) == true) goto L11;
        r1.put("label", r5.f37200d);     // Catch: Throwable -> L24
    L11:
        r1.put("value", Long.valueOf(r5.f37201e));     // Catch: Throwable -> L24
        r1.put("ext_value", Long.valueOf(r5.f));     // Catch: Throwable -> L24
        if (com.bytedance.common.utility.j.a(r5.o) == true) goto L14;
        r1.put("ext_json", r5.o);     // Catch: Throwable -> L24
    L14:
        r1.put("user_id", Long.valueOf(r5.h));     // Catch: Throwable -> L24
        r1.put(com.bytedance.apm.battery.dao.DBHelper.COL_TIME, Long.valueOf(r5.m));     // Catch: Throwable -> L24
        r1.put("session_id", Long.valueOf(r5.n));     // Catch: Throwable -> L24
        r1.put("event_index", Long.valueOf(r5.r));     // Catch: Throwable -> L24
        r1.put("user_type", Integer.valueOf(r5.g));     // Catch: Throwable -> L24
        r1.put("user_is_login", Integer.valueOf(r5.j));     // Catch: Throwable -> L24
        r1.put("user_is_auth", Integer.valueOf(r5.k));     // Catch: Throwable -> L24
        r1.put("uid", Long.valueOf(r5.i));     // Catch: Throwable -> L24
        if (r5.l == null) goto L17;
        r1.put("disable_personalization", String.valueOf(r5.l));     // Catch: Throwable -> L24
    L17:
        r1.put("_event_id", Long.valueOf(r5.f37197a));     // Catch: Throwable -> L24
        long r2 = this.n.insert("event", null, r1);     // Catch: Throwable -> L24
        monitor-exit(this);
        return r2;
    L24:
        th = move-exception;
        throw th;
    }

    public synchronized long a(r r4, long r5) {
        monitor-enter(this);
        SQLiteDatabase r0 = this.n;     // Catch: Throwable -> L24
        if (r0 != null) goto L6;
    L20:
        com.ss.android.common.util.e.d("AppLog db not establish and open");     // Catch: Throwable -> L24
        monitor-exit(this);
        return -1;
    L6:
        if (r0.isOpen() == false) goto L20;
        ContentValues r1 = new ContentValues();     // Catch: Exception -> L10 Throwable -> L24
        r1.put("pausetime", Long.valueOf(r5));     // Catch: Exception -> L10 Throwable -> L24
        this.n.update(SensitiveType.SESSION, r1, "_id = ?", new String[]{String.valueOf(r4.f37209c)});     // Catch: Exception -> L10 Throwable -> L24
    L30:
        ContentValues r6 = new ContentValues();     // Catch: Exception -> L15 Throwable -> L24
        r6.put("name", r4.f37207a);     // Catch: Exception -> L15 Throwable -> L24
        r6.put("duration", Integer.valueOf(r4.f37208b));     // Catch: Exception -> L15 Throwable -> L24
        r6.put("session_id", Long.valueOf(r4.f37209c));     // Catch: Exception -> L15 Throwable -> L24
        long r7 = this.n.insert("page", null, r6);     // Catch: Exception -> L15 Throwable -> L24
        monitor-exit(this);
        return r7;
    L15:
        e = move-exception;
        com.ss.android.common.util.e.d("AppLog insert page exception: ", e);     // Catch: Throwable -> L24
        return 0;
    L10:
        e = move-exception;
        com.ss.android.common.util.e.d("AppLog update session pausetime exception: ", e);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }

    public synchronized long a(x r6) {
        monitor-enter(this);
        SQLiteDatabase r0 = this.n;     // Catch: Throwable -> L15
        if (r0 != null) goto L6;
    L11:
        com.ss.android.common.util.e.d("AppLog db not establish and open");     // Catch: Throwable -> L15
        monitor-exit(this);
        return -1;
    L6:
        if (r0.isOpen() == false) goto L11;
        boolean r1 = r6.i;     // Catch: Throwable -> L15
        ContentValues r2 = new ContentValues();     // Catch: Throwable -> L15
        r2.put("value", r6.f37251b);     // Catch: Throwable -> L15
        r2.put(com.bytedance.apm.battery.dao.DBHelper.COL_TIME, Long.valueOf(r6.f37252c));     // Catch: Throwable -> L15
        r2.put("duration", Integer.valueOf(r6.f37254e));     // Catch: Throwable -> L15
        r2.put("non_page", Integer.valueOf(r1 ? 1 : 0));     // Catch: Throwable -> L15
        r2.put(WsConstants.KEY_APP_VERSION, r6.f);     // Catch: Throwable -> L15
        r2.put("version_code", Integer.valueOf(r6.g));     // Catch: Throwable -> L15
        r2.put("event_index", Long.valueOf(r6.f37253d));     // Catch: Throwable -> L15
        long r3 = this.n.insert(SensitiveType.SESSION, null, r2);     // Catch: Throwable -> L15
        monitor-exit(this);
        return r3;
    L15:
        th = move-exception;
        throw th;
    }

    public long a(String r2) {
        return a(r2, 0);
    }

    synchronized long a(String r4, int r5) {
        monitor-enter(this);
        ContentValues r0 = new ContentValues();     // Catch: Throwable -> L6
        r0.put("value", r4);     // Catch: Throwable -> L6
        r0.put(com.bytedance.apm.battery.dao.DBHelper.COL_TIME, Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L6
        r0.put("retry_count", 0);     // Catch: Throwable -> L6
        r0.put("retry_time", 0L);     // Catch: Throwable -> L6
        r0.put("log_type", Integer.valueOf(r5));     // Catch: Throwable -> L6
        long r6 = this.n.insert("queue", null, r0);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r6;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized void a(long r6, String r8) {
        monitor-enter(this);
        ContentValues r0 = new ContentValues();     // Catch: Throwable -> L6
        r0.put("value", r8);     // Catch: Throwable -> L6
        this.n.update("queue", r0, "_id = ?", new String[]{String.valueOf(r6)});     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized long a(long r3, String r5, String r6, long r7) {
        monitor-enter(this);
        ContentValues r0 = new ContentValues();     // Catch: Throwable -> L6
        r0.put("log_type", r5);     // Catch: Throwable -> L6
        r0.put("value", r6);     // Catch: Throwable -> L6
        r0.put("session_id", Long.valueOf(r3));     // Catch: Throwable -> L6
        r0.put("_event_id", Long.valueOf(r7));     // Catch: Throwable -> L6
        long r4 = this.n.insert("misc_log", null, r0);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r4;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean a(long r12, boolean r14) {
        monitor-enter(this);
        SQLiteDatabase r0 = this.n;     // Catch: Throwable -> L50
        boolean r1 = false;
        if (r0 != null) goto L6;
    L47:
        com.ss.android.common.util.e.d("AppLog db not establish and open");     // Catch: Throwable -> L50
        monitor-exit(this);
        return false;
    L6:
        if (r0.isOpen() == false) goto L47;
        if (r12 > 0) goto L12;
        monitor-exit(this);
        return false;
    L12:
        boolean r2 = true;
        String[] r10 = {String.valueOf(r12)};     // Catch: Throwable -> L50
        if (r14 == true) goto L38;
        Cursor r15 = null;
        r15 = this.n.query("queue", new String[]{com.bytedance.apm.battery.dao.DBHelper.COL_TIME, "retry_count", "retry_time"}, "_id = ?", r10, null, null, null);     // Catch: Throwable -> L31 Exception -> L33
        if (r15.moveToNext() == true) goto L21;
        a(r15);     // Catch: Throwable -> L50
        monitor-exit(this);
        return false;
    L21:
        long r3 = r15.getLong(0);     // Catch: Throwable -> L31 Exception -> L33
        int r4 = r15.getInt(1);     // Catch: Throwable -> L31 Exception -> L33
        long r5 = System.currentTimeMillis();     // Catch: Throwable -> L31 Exception -> L33
        if ((r5 - r3) < a.f37114d) goto L24;
    L29:
        a(r15);     // Catch: Throwable -> L50
        boolean r16 = true;
    L39:
        if (r16 == true) goto L41;
    L43:
        if (r2 == false) goto L45;
        r1 = e(r12);     // Catch: Throwable -> L50
    L45:
        monitor-exit(this);
        return r1;
    L41:
        if (Logger.debug() == false) goto L43;
        o.a(this.o, r12);     // Catch: Throwable -> L50
        goto L43
    L24:
        if (r4 >= a.f37115e) goto L29;
        ContentValues r6 = new ContentValues();     // Catch: Throwable -> L31 Exception -> L33
        r6.put("retry_count", Integer.valueOf(r4 + 1));     // Catch: Throwable -> L31 Exception -> L33
        r6.put("retry_time", Long.valueOf(r5));     // Catch: Throwable -> L31 Exception -> L33
        this.n.update("queue", r6, "_id = ?", r10);     // Catch: Throwable -> L31 Exception -> L33
        a(r15);     // Catch: Throwable -> L50
        monitor-exit(this);
        return false;
    L33:
        e = move-exception;
        c.a().increaseStats(com.bytedance.applog.monitor.v3.j.G);     // Catch: Throwable -> L31
        com.ss.android.common.util.e.d("AppLog onLogSent excepiton: ", e);     // Catch: Throwable -> L31
        a(r15);     // Catch: Throwable -> L50
        r16 = false;
        r2 = false;
        goto L39
    L31:
        th = move-exception;
        a(r15);     // Catch: Throwable -> L50
        throw th;     // Catch: Throwable -> L50
    L38:
        r16 = false;
    L50:
        th = move-exception;
        throw th;
    }

    private boolean e(long r10) {
        com.ss.android.common.util.e.b("delete app_log: " + r10);
        String[] r4 = {String.valueOf(r10)};
        int r5 = this.n.delete("queue", "_id = ?", r4);     // Catch: Throwable -> L10
        if (r5 > 0) goto L6;
        c.a().increaseStats(com.bytedance.applog.monitor.v3.j.G);     // Catch: Throwable -> L10
    L6:
        if (r5 <= 0) goto L9;
        return true;
    L9:
        return false;
    L10:
        th = move-exception;
        com.ss.android.common.util.e.e("delete app_log: " + r10 + " failed", th);
        if (ZeusTransformUtils.instanceOf(th, SQLiteFullException.class) == true) goto L23;
    L20:
        return false;
    L23:
        this.n.execSQL("VACUUM");     // Catch: Throwable -> L18
        com.ss.android.common.util.e.b("try delete app_log: " + r10 + " again after vacuum");     // Catch: Throwable -> L18
        if (this.n.delete("queue", "_id = ?", r4) <= 0) goto L17;
        return true;
    L17:
        return false;
    L18:
        th = move-exception;
        com.ss.android.common.util.e.e("VACUUM failed:" + th.getMessage(), th);
        goto L20
    }

    public synchronized void a() {
        monitor-enter(this);
        SQLiteDatabase r0 = this.n;     // Catch: Throwable -> L36
        if (r0 != null) goto L6;
    L33:
        com.ss.android.common.util.e.d("AppLog db not establish and open");     // Catch: Throwable -> L36
        monitor-exit(this);
        return;
    L6:
        if (r0.isOpen() == false) goto L33;
        String r1 = "timestamp <= ? OR retry_count > " + a.f37115e;     // Catch: Throwable -> L36
        String[] r9 = {String.valueOf(System.currentTimeMillis() - a.f37114d)};     // Catch: Throwable -> L36
        Cursor r11 = null;
        r11 = this.n.query("queue", new String[]{"value"}, r1, r9, null, null, null);     // Catch: Throwable -> L21
    L11:
        if (r11 == null) goto L19;
        if (r11.moveToNext() == false) goto L19;
        a(new JSONObject(r11.getString(0)));     // Catch: Throwable -> L17
    L17:
        c.a().increaseStats(com.bytedance.applog.monitor.v3.j.P);     // Catch: Throwable -> L21
        goto L11
    L19:
        a(r11);     // Catch: Throwable -> L36
        this.n.delete("queue", r1, r9);     // Catch: Exception -> L26 Throwable -> L36
    L28:
        monitor-exit(this);
        return;
    L26:
        e = move-exception;
        c.a().increaseStats(com.bytedance.applog.monitor.v3.j.G);     // Catch: Throwable -> L36
        com.ss.android.common.util.e.d("AppLog delete expire log error:", e);     // Catch: Throwable -> L36
    L21:
        th = move-exception;
        com.ss.android.common.util.e.d("AppLog count expire log error:", th);     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        a(r11);     // Catch: Throwable -> L36
        throw th;     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        throw th;
    }

    public synchronized boolean a(long r13) {
        monitor-enter(this);
        SQLiteDatabase r0 = this.n;     // Catch: Throwable -> L23
        boolean r9 = false;
        if (r0 != null) goto L8;
        monitor-exit(this);
        return false;
    L8:
        Cursor r10 = null;
        r10 = r0.query("queue", new String[]{"_id"}, "_id = ?", new String[]{String.valueOf(r13)}, null, null, null, "1");     // Catch: Throwable -> L15
        if (r10.getCount() <= 0) goto L12;
        r9 = true;
    L12:
        a(r10);     // Catch: Throwable -> L23
        monitor-exit(this);
        return r9;
    L15:
        th = move-exception;
        c.a().increaseStats(com.bytedance.applog.monitor.v3.j.G);     // Catch: Throwable -> L20
        com.ss.android.common.util.e.d("AppLog existsLogByQuery exception ", th);     // Catch: Throwable -> L20
        a(r10);     // Catch: Throwable -> L23
        return false;
    L20:
        th = move-exception;
        a(r10);     // Catch: Throwable -> L23
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }

    public synchronized q b(long r12) {
        monitor-enter(this);
        SQLiteDatabase r0 = this.n;     // Catch: Throwable -> L33
        Cursor r1 = null;
        q r2 = null;
        if (r0 != null) goto L6;
    L30:
        com.ss.android.common.util.e.d("AppLog db not establish and open");     // Catch: Throwable -> L33
        monitor-exit(this);
        return null;
    L6:
        if (r0.isOpen() == false) goto L30;
        Cursor r13 = this.n.query("queue", f37106d, "_id > ?", new String[]{String.valueOf(r12)}, null, null, "_id ASC", "1");     // Catch: Throwable -> L18 Exception -> L20
    L16:
        e = e;
    L22:
        c.a().increaseStats(com.bytedance.applog.monitor.v3.j.G);     // Catch: Throwable -> L26
        com.ss.android.common.util.e.d("AppLog getLog exception ", e);     // Catch: Throwable -> L26
        a(r13);     // Catch: Throwable -> L33
        monitor-exit(this);
        return null;
    L26:
        th = th;
        r1 = r13;
    L28:
        a(r1);     // Catch: Throwable -> L33
        throw th;     // Catch: Throwable -> L33
    L10:
        if (r13.moveToNext() == false) goto L13;
        q r3 = new q();     // Catch: Exception -> L16 Throwable -> L26
        r3.f37202a = r13.getInt(0);     // Catch: Exception -> L16 Throwable -> L26
        r3.f37203b = r13.getString(1);     // Catch: Exception -> L16 Throwable -> L26
        r3.f37204c = r13.getLong(3);     // Catch: Exception -> L16 Throwable -> L26
        r3.f37205d = r13.getInt(4);     // Catch: Exception -> L16 Throwable -> L26
        r3.f37206e = r13.getLong(5);     // Catch: Exception -> L16 Throwable -> L26
        r3.f = r13.getInt(6);     // Catch: Exception -> L16 Throwable -> L26
        r2 = r3;
    L13:
        a(r13);     // Catch: Throwable -> L33
        monitor-exit(this);
        return r2;
    L20:
        e = e;
        r13 = null;
    L18:
        th = th;
    L33:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x00ad: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:40:0x00ad */
    public synchronized x c(long r15) {
        monitor-enter(this);
        SQLiteDatabase r0 = this.n;     // Catch: Throwable -> L46
        Cursor r2 = null;
        x r3 = null;
        if (r0 != null) goto L50;
    L43:
        com.ss.android.common.util.e.d("AppLog db not establish and open");     // Catch: Throwable -> L46
        monitor-exit(this);
        return null;
    L50:
        if (r0.isOpen() == false) goto L43;
        boolean r12 = true;
        if (r15 > 0) goto L53;
        String r6 = null;
        String[] r7 = null;
    L13:
        Cursor r4 = this.n.query(SensitiveType.SESSION, f37107e, r6, r7, null, null, "_id DESC", "1");     // Catch: Throwable -> L31 Exception -> L33
    L29:
        e = e;
    L35:
        c.a().increaseStats(com.bytedance.applog.monitor.v3.j.G);     // Catch: Throwable -> L39
        com.ss.android.common.util.e.d("AppLog getLastSession exception ", e);     // Catch: Throwable -> L39
        a(r4);     // Catch: Throwable -> L46
        monitor-exit(this);
        return null;
    L15:
        if (r4.moveToNext() == false) goto L26;
        x r1 = new x();     // Catch: Exception -> L29 Throwable -> L39
        r1.f37250a = r4.getInt(0);     // Catch: Exception -> L29 Throwable -> L39
        r1.f37251b = r4.getString(1);     // Catch: Exception -> L29 Throwable -> L39
        r1.f37252c = r4.getLong(2);     // Catch: Exception -> L29 Throwable -> L39
        if (r4.getInt(4) <= 0) goto L19;
        boolean r5 = true;
    L20:
        r1.i = r5;     // Catch: Exception -> L29 Throwable -> L39
        r1.f = r4.getString(5);     // Catch: Exception -> L29 Throwable -> L39
        r1.g = r4.getInt(6);     // Catch: Exception -> L29 Throwable -> L39
        r1.h = r4.getInt(7);     // Catch: Exception -> L29 Throwable -> L39
        if (r4.getInt(8) > 0) goto L24;
        r12 = false;
    L24:
        r1.j = r12;     // Catch: Exception -> L29 Throwable -> L39
        r1.f37253d = r4.getLong(9);     // Catch: Exception -> L29 Throwable -> L39
        r1.k = false;     // Catch: Exception -> L29 Throwable -> L39
        r3 = r1;
        goto L26
    L19:
        r5 = false;
    L26:
        a(r4);     // Catch: Throwable -> L46
        monitor-exit(this);
        return r3;
    L33:
        e = e;
        r4 = null;
    L31:
        th = th;
    L41:
        a(r2);     // Catch: Throwable -> L46
        throw th;     // Catch: Throwable -> L46
    L53:
        r6 = "_id < ?";
        r7 = new String[]{String.valueOf(r15)};     // Catch: Throwable -> L31 Exception -> L33
    L39:
        th = th;
        r2 = r3;
    L46:
        th = move-exception;
        throw th;
    }

    public synchronized void d(long r5) {
        monitor-enter(this);
        SQLiteDatabase r0 = this.n;     // Catch: Throwable -> L17
        if (r0 != null) goto L6;
    L14:
        com.ss.android.common.util.e.d("AppLog db not establish and open");     // Catch: Throwable -> L17
        monitor-exit(this);
        return;
    L6:
        if (r0.isOpen() == false) goto L14;
        String[] r2 = {String.valueOf(r5)};     // Catch: Exception -> L10 Throwable -> L17
        ContentValues r6 = new ContentValues();     // Catch: Exception -> L10 Throwable -> L17
        r6.put("launch_sent", 1);     // Catch: Exception -> L10 Throwable -> L17
        this.n.update(SensitiveType.SESSION, r6, "_id=?", r2);     // Catch: Exception -> L10 Throwable -> L17
    L12:
        monitor-exit(this);
        return;
    L10:
        e = move-exception;
        c.a().increaseStats(com.bytedance.applog.monitor.v3.j.G);     // Catch: Throwable -> L17
        com.ss.android.common.util.e.d("AppLog setSessionLaunchSent exception: ", e);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 6 */
    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 27131. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public synchronized long a(com.ss.android.common.applog.x r53, com.ss.android.common.applog.x r54, org.json.JSONObject r55, boolean r56, long[] r57, java.lang.String[] r58, java.util.List<com.ss.android.common.applog.a.j> r59, boolean r60, org.json.JSONObject r61, boolean r62) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0002: MOVE (r9v0 ?? I:??[OBJECT, ARRAY]) = (r53v0 ?? I:??[OBJECT, ARRAY]) A[DECLARE_VAR] in method: com.ss.android.common.applog.DBHelper.a(com.ss.android.common.applog.x, com.ss.android.common.applog.x, org.json.JSONObject, boolean, long[], java.lang.String[], java.util.List<com.ss.android.common.applog.a$j>, boolean, org.json.JSONObject, boolean):long, file: classes4.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 2713
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.common.applog.DBHelper.a(com.ss.android.common.applog.x, com.ss.android.common.applog.x, org.json.JSONObject, boolean, long[], java.lang.String[], java.util.List, boolean, org.json.JSONObject, boolean):long");
    }

    private void a(List<a.j> r4, long r5, String r7, JSONObject r8) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
        return;
    L5:
        monitor-enter(r3);
        Iterator r6 = r3.iterator();     // Catch: Throwable -> L16
    L8:
        if (r6.hasNext() == false) goto L14;
        ((a.j) ZeusTransformUtils.preCheckCast(r6.next(), a.j.class, "com.obric.aiagent.plugin")).b(r5, r7, r8);     // Catch: Exception -> L12 Throwable -> L16
    L12:
        e = move-exception;
        com.ss.android.common.util.e.d("AppLog onLogSessionBatchEvent exception: ", e);     // Catch: Throwable -> L16
        goto L8
    L14:
        monitor-exit(r3);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    private void b(List<a.j> r4, long r5, String r7, JSONObject r8) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L5;
        return;
    L5:
        monitor-enter(r3);
        Iterator r6 = r3.iterator();     // Catch: Throwable -> L16
    L8:
        if (r6.hasNext() == false) goto L14;
        ((a.j) ZeusTransformUtils.preCheckCast(r6.next(), a.j.class, "com.obric.aiagent.plugin")).a(r5, r7, r8);     // Catch: Exception -> L12 Throwable -> L16
    L12:
        e = move-exception;
        com.ss.android.common.util.e.d("AppLog onLogSessionTerminate exception: ", e);     // Catch: Throwable -> L16
        goto L8
    L14:
        monitor-exit(r3);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    private JSONArray a(boolean r31, long r32, String r34, JSONObject r35, JSONObject r36) {
        int r12 = 0;
        boolean r11 = true;
        String[] r15 = {"0", String.valueOf(r32)};
        String r10 = "_id<= ? ";
        String[] r9 = {"0"};
        JSONArray r20 = null;
        Cursor r21 = null;
        long r22 = 0;
    L96:
        r15[r12] = String.valueOf(r22);     // Catch: Throwable -> L77 Exception -> L79
        JSONArray r0 = new JSONArray();     // Catch: Throwable -> L77 Exception -> L79
        String[] r26 = r9;
        String r27 = r10;
        int r14 = r12;
        Cursor r4 = this.n.query("misc_log", g, "_id > ? AND session_id=?", r15, null, null, "_id ASC", "100");     // Catch: Exception -> L74 Throwable -> L77
        r4.getCount();     // Catch: Throwable -> L70 Exception -> L72
        long r5 = 0;
    L7:
        if (r4.moveToNext() == false) goto L38;
        long r7 = r4.getLong(r14);     // Catch: Exception -> L36 Throwable -> L70
        if (r7 <= 0) goto L7;
        if (r7 <= r5) goto L15;
        r5 = r7;
    L15:
        String r13 = r4.getString(1);     // Catch: Exception -> L36 Throwable -> L70
        String r16 = r4.getString(2);     // Catch: Exception -> L36 Throwable -> L70
        if (r4.isNull(3) == false) goto L113;
        long r17 = 0;
    L115:
    L34:
        e = e;
        r21 = r4;
        String[] r8 = r26;
        String r18 = r27;
        int r19 = 0;
    L81:
        com.ss.android.common.util.e.e("pack misc log", e);     // Catch: Throwable -> L77
        c.a().increaseStats(com.bytedance.applog.monitor.v3.j.G);     // Catch: Throwable -> L77
        c.a().increaseStats(com.bytedance.applog.monitor.v3.j.f5823J);     // Catch: Throwable -> L77
        if (ZeusTransformUtils.instanceOf(e, SQLiteBlobTooBigException.class) == false) goto L89;
        if (a.M() == false) goto L89;
        if (d() == true) goto L90;
    L92:
        a(r21);
    L93:
        r15 = r15;
        r12 = r19;
        r10 = r18;
        r11 = true;
        r9 = r8;
    L90:
        a(r21);
    L91:
        return r20;
    L89:
        if (a.L() == false) goto L92;
    L23:
        if (com.bytedance.common.utility.j.a(r16) == false) goto L25;
    L33:
        r15 = r15;
        r14 = 0;
        goto L7
    L25:
        if (com.bytedance.common.utility.j.a(r13) == true) goto L33;
        JSONObject r110 = new JSONObject(r16);     // Catch: Exception -> L32 Throwable -> L70
        r110.put("log_id", r7);     // Catch: Exception -> L32 Throwable -> L70
        if (com.bytedance.common.utility.j.a(r13) == true) goto L30;
        r110.put("log_type", r13);     // Catch: Exception -> L32 Throwable -> L70
    L30:
        r110.put("event_id", r17);     // Catch: Exception -> L32 Throwable -> L70
        r0.put(r110);     // Catch: Exception -> L32 Throwable -> L70
    L32:
        c.a().increaseStats(com.bytedance.applog.monitor.v3.j.P);     // Catch: Exception -> L34 Throwable -> L70
        goto L33
    L113:
        r17 = r4.getLong(3);     // Catch: Exception -> L19 Throwable -> L70
    L19:
        e = e;
        r21 = r4;
    L75:
        r19 = r14;
        r15 = r15;
    L76:
        r8 = r26;
        r18 = r27;
    L36:
        e = e;
        r15 = r15;
        r21 = r4;
        r19 = r14;
        goto L76
    L38:
        r15 = r15;
        if (r22 != 0) goto L41;
        r20 = r0;
        boolean r111 = false;
    L43:
        if (r22 >= r5) goto L44;
        r8 = r26;
        r19 = 0;
        r8[0] = String.valueOf(r5);     // Catch: Exception -> L65 Throwable -> L70
        r18 = r27;
        this.n.delete("misc_log", r18, r8);     // Catch: Exception -> L63 Throwable -> L70
        if (r111 == true) goto L52;
    L62:
        a(r4);
        r21 = r4;
        r22 = r5;
        goto L93
    L52:
        if (r0.length() <= 0) goto L62;
        JSONObject r23 = new JSONObject();     // Catch: Exception -> L63 Throwable -> L70
        r23.put("magic_tag", "ss_app_log");     // Catch: Exception -> L63 Throwable -> L70
        if (r36 == null) goto L56;
        r23.put("time_sync", r36);     // Catch: Exception -> L63 Throwable -> L70
    L56:
        r23.put("log_data", r0);     // Catch: Exception -> L63 Throwable -> L70
        if (r35 == null) goto L59;
        r23.put("header", r35);     // Catch: Exception -> L63 Throwable -> L70
    L59:
        r23.put("_gen_time", System.currentTimeMillis());     // Catch: Exception -> L63 Throwable -> L70
        if (a(r23.toString()) >= 0) goto L62;
        c.a().increaseStats(com.bytedance.applog.monitor.v3.j.G);     // Catch: Exception -> L63 Throwable -> L70
    L63:
        e = e;
    L69:
        r21 = r4;
        r22 = r5;
    L65:
        e = e;
        r18 = r27;
    L67:
        e = e;
        r8 = r26;
        r18 = r27;
        r19 = 0;
        goto L69
    L44:
        a(r4);
        goto L91
    L41:
        r111 = true;
    L72:
        e = e;
        r19 = r14;
        r15 = r15;
        r8 = r26;
        r18 = r27;
        r21 = r4;
    L70:
        th = th;
        r21 = r4;
    L94:
        a(r21);
        throw th;
    L74:
        e = e;
        goto L75
    L77:
        th = th;
    L79:
        e = e;
        r8 = r9;
        r18 = r10;
        r19 = r12;
        r15 = r15;
        goto L81
    }

    private boolean d() {
        Field r0 = CursorWindow.class.getDeclaredField("sCursorWindowSize");     // Catch: Throwable -> L10
        r0.setAccessible(true);     // Catch: Throwable -> L10
        int r3 = r0.getInt(null);     // Catch: Throwable -> L10
        if (r3 <= 0) goto L8;
        if (r3 > 8388608) goto L8;
        r0.setInt(null, r3 * 2);     // Catch: Throwable -> L10
        return false;
    L8:
        if (r3 > 8388608) goto L16;
        return false;
    L16:
        return true;
    L10:
        th = move-exception;
        com.ss.android.common.util.e.e("tryIncreaseCursorWindowSize", th);
        return false;
    }

    synchronized void b() {
        monitor-enter(this);
        SQLiteDatabase r0 = this.n;     // Catch: Throwable -> L21
        if (r0 != null) goto L6;
    L18:
        com.ss.android.common.util.e.d("AppLogdb not establish and open");     // Catch: Throwable -> L21
        monitor-exit(this);
        return;
    L6:
        if (r0.isOpen() == false) goto L18;
        String[] r1 = k;     // Catch: Throwable -> L21
        int r2 = r1.length;     // Catch: Throwable -> L21
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L16;
        String r4 = r1[r3];     // Catch: Throwable -> L21
        this.n.delete(r4, null, null);     // Catch: Throwable -> L13
    L15:
        r3 = r3 + 1;
    L13:
        th = move-exception;
        c.a().increaseStats(com.bytedance.applog.monitor.v3.j.G);     // Catch: Throwable -> L21
        com.ss.android.common.util.e.d("AppLogdelete table failed, " + r4, th);     // Catch: Throwable -> L21
        goto L15
    L16:
        monitor-exit(this);
        return;
    L21:
        th = move-exception;
        throw th;
    }

    public static void a(JSONObject r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        if (c.a().isEnabled() == false) goto L27;
        JSONArray r0 = r6.optJSONArray("event_v3");
        JSONArray r1 = r6.optJSONArray("event");
        JSONArray r2 = r6.optJSONArray("log_data");
        JSONArray r3 = r6.optJSONArray("launch");
        JSONArray r7 = r6.optJSONArray("terminate");
        if (r3 != null) goto L9;
    L11:
        if (r7 != null) goto L13;
    L15:
        int r8 = 0;
        if (r0 == null) goto L18;
        r8 = 0 + r0.length();
    L18:
        if (r1 == null) goto L20;
        r8 = r8 + r1.length();
    L20:
        if (r2 == null) goto L22;
        r8 = r8 + r2.length();
    L22:
        if (r8 <= 0) goto L26;
        c.a().increaseStats(com.bytedance.applog.monitor.v3.j.z, r8);
        return;
    L26:
        return;
    L13:
        if (r7.length() <= 0) goto L15;
        c.a().increaseStats(com.bytedance.applog.monitor.v3.j.B, r7.length());
        goto L15
    L9:
        if (r3.length() <= 0) goto L11;
        c.a().increaseStats(com.bytedance.applog.monitor.v3.j.A, r3.length());
        goto L11
    }
}
