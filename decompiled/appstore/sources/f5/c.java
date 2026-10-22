package f5;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.bytedance.apm.constant.CommonKey;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f19485b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static c f19486c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SQLiteDatabase f19487a;

    static {
        f19485b = new String[]{"_id", CommonKey.KEY_VALUE, "type", "timestamp", "retry_count", "retry_time"};
    }

    public c(Context r10) {
        if (r10 != null) goto L8;
        return;
    L8:
        this.f19487a = a5.a.a(r10).getWritableDatabase();     // Catch: Throwable -> L7
        return;
    }

    public static c c(Context r10) {
        if (f19486c != null) goto L16;
        monitor-enter(c.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f19486c != null) goto L11;
        f19486c = new c(r10);     // Catch: Throwable -> L9
    L11:
        monitor-exit(c.class);     // Catch: Throwable -> L9
    L16:
        return f19486c;
    }

    public static void i(Cursor r10) {
        if (r10 == null) goto L10;
        if (r10.isClosed() == true) goto L11;
        r10.close();     // Catch: Exception -> L7
        return;
    L11:
        return;
    L12:
        return;
    }

    public synchronized void a(String r10, int r11, long r12) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (f() == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        long r13 = System.currentTimeMillis() - r12;     // Catch: Throwable -> L10
        if (TextUtils.isEmpty(r10) == false) goto L12;
        String r14 = "timestamp <= ? ";
        String[] r15 = {String.valueOf(r13)};     // Catch: Throwable -> L10
    L22:
        this.f19487a.delete("queue", r14, r15);     // Catch: Throwable -> L10 Exception -> L16
    L18:
        monitor-exit(this);
        return;
    L16:
        e = move-exception;
        b.f("delete expire log error:" + e);     // Catch: Throwable -> L10
        goto L18
    L12:
        String r16 = "(timestamp <= ? OR retry_count > " + r11 + ") and type = ?";     // Catch: Throwable -> L10
        r15 = new String[]{String.valueOf(r13), r10};     // Catch: Throwable -> L10
        r14 = r16;
        goto L22
    }

    public synchronized long b(String r10) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        long r11 = 0;
        if (f() == true) goto L8;
        monitor-exit(this);
        return 0;
    L8:
        Cursor r12 = null;
        String r13 = "select count(*) from queue";
        if (TextUtils.isEmpty(r10) == true) goto L12;
        r13 = "select count(*) from queue " + r10;     // Catch: Throwable -> L23
    L12:
        r12 = this.f19487a.rawQuery(r13, null);     // Catch: Throwable -> L23
        if (r12.moveToNext() == false) goto L15;
        r11 = r12.getLong(0);     // Catch: Throwable -> L23
    L15:
        i(r12);     // Catch: Throwable -> L17
        monitor-exit(this);
        return r11;
    }

    public synchronized a d(long r12) {
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L4:
        Cursor r10 = null;
        a r11 = null;
        r10 = null;
        if (f() == true) goto L40;
        monitor-exit(this);
        return null;
    L40:
        Cursor r13 = this.f19487a.query("queue", f19485b, "_id > ?", new String[]{String.valueOf(r12)}, null, null, "_id ASC", "1");     // Catch: Throwable -> L25 Exception -> L27
    L15:
        th = th;
        r10 = r13;
    L34:
        i(r10);     // Catch: Throwable -> L23
        throw th;     // Catch: Throwable -> L23
    L19:
        e = e;
        a r14 = null;
    L18:
        r10 = r13;
    L29:
        b.f("getLog exception " + e);     // Catch: Throwable -> L25
        i(r10);     // Catch: Throwable -> L23
        r11 = r14;
    L32:
        monitor-exit(this);
        return r11;
    L10:
        if (r13.moveToNext() == false) goto L21;
        r14 = new a();     // Catch: Throwable -> L15 Exception -> L19
        r14.f19473a = r13.getLong(0);     // Catch: Throwable -> L15 Exception -> L17
        r14.f19474b = r13.getBlob(1);     // Catch: Throwable -> L15 Exception -> L17
        r14.f19478f = r13.getString(2);     // Catch: Throwable -> L15 Exception -> L17
        r14.f19475c = r13.getLong(3);     // Catch: Throwable -> L15 Exception -> L17
        r14.f19476d = r13.getInt(4);     // Catch: Throwable -> L15 Exception -> L17
        r14.f19477e = r13.getLong(5);     // Catch: Throwable -> L15 Exception -> L17
        r11 = r14;
        goto L21
    L17:
        e = e;
    L21:
        i(r13);     // Catch: Throwable -> L23
    L27:
        e = e;
        r14 = null;
    L25:
        th = th;
        goto L34
    }

    public synchronized long e(String r10, byte[] r11) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (f() == false) goto L14;
        if (r11 == null) goto L14;
        if (r11.length <= 0) goto L14;
        ContentValues r12 = new ContentValues();     // Catch: Throwable -> L12
        r12.put(CommonKey.KEY_VALUE, r11);     // Catch: Throwable -> L12
        r12.put("type", r10);     // Catch: Throwable -> L12
        r12.put("timestamp", Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L12
        r12.put("retry_count", 0);     // Catch: Throwable -> L12
        r12.put("retry_time", 0L);     // Catch: Throwable -> L12
        long r13 = this.f19487a.insert("queue", null, r12);     // Catch: Throwable -> L12
        monitor-exit(this);
        return r13;
    L14:
        monitor-exit(this);
        return -1;
    }

    public synchronized boolean f() {
        monitor-enter(this);
        SQLiteDatabase r10 = this.f19487a;     // Catch: Throwable -> L11
        if (r10 != null) goto L6;
    L13:
        b.f("db not establish and open");     // Catch: Throwable -> L11
        monitor-exit(this);
        return false;
    L6:
        if (r10.isOpen() == false) goto L13;
        monitor-exit(this);
        return true;
    L11:
        th = move-exception;
        throw th;
    }

    public synchronized boolean g(long r15, boolean r17, long r18, int r20) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (f() == true) goto L7;
    L43:
        monitor-exit(this);
        return false;
    L7:
        if (r15 <= 0) goto L43;
        String[] r10 = {String.valueOf(r15)};     // Catch: Throwable -> L17
        if (r17 == true) goto L50;
        Cursor r13 = null;
        r13 = this.f19487a.query("queue", new String[]{"timestamp", "retry_count"}, "_id = ?", r10, null, null, null);     // Catch: Throwable -> L27 Exception -> L29
        if (r13.moveToNext() == true) goto L19;
        i(r13);     // Catch: Throwable -> L17
        monitor-exit(this);
        return false;
    L19:
        long r11 = r13.getLong(0);     // Catch: Throwable -> L27 Exception -> L29
        int r12 = r13.getInt(1);     // Catch: Throwable -> L27 Exception -> L29
        long r14 = System.currentTimeMillis();     // Catch: Throwable -> L27 Exception -> L29
        if ((r14 - r11) < r18) goto L22;
    L31:
        i(r13);     // Catch: Throwable -> L17
        goto L50
    L22:
        if (r12 >= r20) goto L31;
        ContentValues r16 = new ContentValues();     // Catch: Throwable -> L27 Exception -> L29
        r16.put("retry_count", Integer.valueOf(r12 + 1));     // Catch: Throwable -> L27 Exception -> L29
        r16.put("retry_time", Long.valueOf(r14));     // Catch: Throwable -> L27 Exception -> L29
        this.f19487a.update("queue", r16, "_id = ?", r10);     // Catch: Throwable -> L27 Exception -> L29
        i(r13);     // Catch: Throwable -> L17
        monitor-exit(this);
        return true;
    L29:
        e = move-exception;
        b.f("onLogSent exception: " + e);     // Catch: Throwable -> L27
        i(r13);     // Catch: Throwable -> L17
        return false;
    L27:
        th = move-exception;
        i(r13);     // Catch: Throwable -> L17
        throw th;     // Catch: Throwable -> L17
    L50:
        this.f19487a.delete("queue", "_id = ?", r10);     // Catch: Throwable -> L47
    L40:
        b.f("delete app_log: " + r15);     // Catch: Throwable -> L17
        monitor-exit(this);
        return false;
    }

    public synchronized void h() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (f() == true) goto L17;
        monitor-exit(this);
        return;
    L17:
        this.f19487a.execSQL("DROP TABLE IF EXISTS queue");     // Catch: Throwable -> L9 Exception -> L11
        this.f19487a.execSQL("CREATE TABLE queue ( _id INTEGER PRIMARY KEY AUTOINCREMENT, value BLOB, type TEXT, timestamp INTEGER, retry_count INTEGER, retry_time INTEGER )");     // Catch: Throwable -> L9 Exception -> L11
    L13:
        monitor-exit(this);
        return;
    L11:
        e = move-exception;
        b.f("recreateTableQueue db exception " + e);     // Catch: Throwable -> L9
        goto L13
    }
}
