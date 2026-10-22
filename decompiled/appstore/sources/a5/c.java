package a5;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.bytedance.framwork.core.sdklib.util.ListUtils;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f40f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f41g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static long f42h = 5000;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String[] f43i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static c f44j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static String f45k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static String f46l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map f47a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f48b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f49c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SQLiteDatabase f50d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f51e;

    static {
        f43i = new String[]{"_id", "data"};
        f44j = null;
        f45k = "SELECT count(*) FROM monitor_log WHERE aid = ?";
        f46l = "SELECT count(*) FROM monitor_log";
    }

    public c(Context r10) {
        this.f47a = new HashMap(2);
        this.f48b = 0;
        this.f51e = "INSERT INTO monitor_log(aid,type,type2,time,data) VALUES ( ?, ?, ?, ?, ?)";
        this.f49c = r10;
        this.f50d = a.a(r10).getWritableDatabase();
    }

    public static c e(Context r10) {
        if (f44j != null) goto L16;
        monitor-enter(a.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f44j != null) goto L11;
        f44j = new c(r10);     // Catch: Throwable -> L9
    L11:
        monitor-exit(a.class);     // Catch: Throwable -> L9
    L16:
        return f44j;
    }

    public static void k(Cursor r10) {
        if (r10 == null) goto L10;
        if (r10.isClosed() == true) goto L11;
        r10.close();     // Catch: Exception -> L7
        return;
    L11:
        return;
    L12:
        return;
    }

    public final void a(String r10, int r11) {
        if (this.f47a.containsKey(r10) == true) goto L6;
        if (r11 <= 0) goto L6;
        this.f47a.put(r10, Integer.valueOf(r11));
        return;
    L6:
        int r12 = Math.max(0, r11 + ((Integer) this.f47a.get(r10)).intValue());
        this.f47a.put(r10, Integer.valueOf(r12));
    }

    public final void b(String r10) {
        File r11 = this.f49c.getDatabasePath(r10 + ".db");     // Catch: Exception -> L6
        if (r11.exists() == false) goto L9;
        r11.delete();     // Catch: Exception -> L6
        return;
    L9:
        return;
    }

    public final void c() {
        b("psdkmon");
    }

    public synchronized int d(String r10, long r11) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f50d != null) goto L6;
    L13:
        monitor-exit(this);
        return -1;
    L6:
        if (r11 < 0) goto L13;
        String[] r12 = {r10, String.valueOf(r11)};     // Catch: Throwable -> L11
        int r13 = this.f50d.delete(CloudControlInf.MONITOR_LOG, "aid = ? AND _id<= ? ", r12);     // Catch: Throwable -> L11
        a(r10, r13 * (-1));     // Catch: Throwable -> L11
        monitor-exit(this);
        return r13;
    }

    public synchronized int f(String r10) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.f48b <= 10) goto L6;
    L11:
        int r11 = h(r10);     // Catch: Throwable -> L9
        this.f47a.put(r10, Integer.valueOf(r11));     // Catch: Throwable -> L9
        this.f48b = 0;     // Catch: Throwable -> L9
        int r12 = r11;
    L13:
        monitor-exit(this);
        return r12;
    L6:
        if (this.f47a.containsKey(r10) == false) goto L11;
        r12 = ((Integer) this.f47a.get(r10)).intValue();     // Catch: Throwable -> L9
        this.f48b++;     // Catch: Throwable -> L9
        goto L13
    }

    public final synchronized int g() {
        monitor-enter(this);
        SQLiteDatabase r10 = this.f50d;     // Catch: Throwable -> L16
        int r11 = -1;
        if (r10 != null) goto L6;
    L22:
        monitor-exit(this);
        return -1;
    L6:
        if (r10.isOpen() == false) goto L22;
        Cursor r12 = null;
        r12 = this.f50d.rawQuery(f46l, null);     // Catch: Throwable -> L13 Exception -> L26
        if (r12.moveToNext() == false) goto L15;
        r11 = r12.getInt(0);     // Catch: Throwable -> L13 Exception -> L26
    L13:
        th = move-exception;
        k(r12);     // Catch: Throwable -> L16
        throw th;     // Catch: Throwable -> L16
    L15:
        k(r12);     // Catch: Throwable -> L16
        monitor-exit(this);
        return r11;
    L16:
        th = move-exception;
        throw th;
    }

    public final synchronized int h(String r10) {
        monitor-enter(this);
        SQLiteDatabase r11 = this.f50d;     // Catch: Throwable -> L16
        int r12 = -1;
        if (r11 != null) goto L6;
    L22:
        monitor-exit(this);
        return -1;
    L6:
        if (r11.isOpen() == false) goto L22;
        Cursor r13 = null;
        r13 = this.f50d.rawQuery(f45k, new String[]{r10});     // Catch: Throwable -> L13 Exception -> L26
        if (r13.moveToNext() == false) goto L15;
        r12 = r13.getInt(0);     // Catch: Throwable -> L13 Exception -> L26
    L13:
        th = move-exception;
        k(r13);     // Catch: Throwable -> L16
        throw th;     // Catch: Throwable -> L16
    L15:
        k(r13);     // Catch: Throwable -> L16
        monitor-exit(this);
        return r12;
    L16:
        th = move-exception;
        throw th;
    }

    public List i(int r11, int r12) {
        Cursor r10 = null;
        Cursor r13 = this.f50d.query(CloudControlInf.MONITOR_LOG, f43i, "aid= ?", new String[]{String.valueOf(r11)}, null, null, "_id ASC ", r12 + "");     // Catch: Throwable -> L18
    L13:
        r10 = r13;
        goto L16
    L5:
        if (r13.getCount() != 0) goto L8;
        k(r13);
        return null;
    L8:
        LinkedList r14 = new LinkedList();     // Catch: Throwable -> L13
    L10:
        if (r13.moveToNext() == false) goto L14;
        r14.add(new c5.a(r13.getLong(r13.getColumnIndex("_id")), r13.getString(r13.getColumnIndex("data"))));     // Catch: Throwable -> L13
        goto L10
    L14:
        k(r13);
        return r14;
    L16:
        k(r10);
        return Collections.emptyList();
    }

    public synchronized void j(String r10, List r11) {
        monitor-enter(this);
    L30:
        th = move-exception;
        throw th;
    L4:
        if (this.f50d != null) goto L6;
    L39:
        monitor-exit(this);
        return;
    L6:
        if (ListUtils.a(r11) == true) goto L39;
        l();     // Catch: Throwable -> L30
        this.f50d.beginTransaction();     // Catch: Throwable -> L30
        SQLiteStatement r12 = this.f50d.compileStatement(this.f51e);     // Catch: Throwable -> L15 Exception -> L17
        Iterator r13 = r11.iterator();     // Catch: Throwable -> L15 Exception -> L17
    L11:
        if (r13.hasNext() == false) goto L26;
        c5.a r14 = (c5.a) r13.next();     // Catch: Throwable -> L15 Exception -> L17
        r12.bindString(1, String.valueOf(r14.f6057b));     // Catch: Throwable -> L15 Exception -> L17
        String r15 = r14.f6058c;     // Catch: Throwable -> L15 Exception -> L17
        if (r15 != null) goto L19;
        r15 = "";
    L19:
        r12.bindString(2, r15);     // Catch: Throwable -> L15 Exception -> L17
        String r16 = r14.f6059d;     // Catch: Throwable -> L15 Exception -> L17
        if (r16 != null) goto L22;
        r16 = "";
    L22:
        r12.bindString(3, r16);     // Catch: Throwable -> L15 Exception -> L17
        r12.bindLong(4, r14.f6061f);     // Catch: Throwable -> L15 Exception -> L17
        String r17 = r14.f6060e;     // Catch: Throwable -> L15 Exception -> L17
        if (r17 != null) goto L25;
        r17 = "";
    L25:
        r12.bindString(5, r17);     // Catch: Throwable -> L15 Exception -> L17
        r12.executeInsert();     // Catch: Throwable -> L15 Exception -> L17
        goto L11
    L26:
        this.f50d.setTransactionSuccessful();     // Catch: Throwable -> L15 Exception -> L17
        a(r10, r11.size());     // Catch: Throwable -> L15 Exception -> L17
        SQLiteDatabase r18 = this.f50d;     // Catch: Throwable -> L30
    L28:
        r18.endTransaction();     // Catch: Throwable -> L30
        monitor-exit(this);
        return;
    L17:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L15
        r18 = this.f50d;     // Catch: Throwable -> L30
        goto L28
    L15:
        th = move-exception;
        this.f50d.endTransaction();     // Catch: Throwable -> L30
        throw th;     // Catch: Throwable -> L30
    }

    public final synchronized void l() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (f41g == true) goto L11;
        f41g = true;     // Catch: Throwable -> L8
        if (g() < f42h) goto L11;
        m(500);     // Catch: Throwable -> L8
    L11:
        if (f40f == true) goto L13;
        f40f = true;     // Catch: Throwable -> L8
        c();     // Catch: Throwable -> L8
    L13:
        monitor-exit(this);
    }

    public synchronized void m(long r10) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.f50d != null) goto L6;
    L16:
        monitor-exit(this);
        return;
    L6:
        if (r10 <= 0) goto L16;
        this.f50d.execSQL(" DELETE FROM monitor_log WHERE _id IN (SELECT _id FROM monitor_log ORDER BY _id ASC LIMIT " + r10 + ")");     // Catch: Throwable -> L10 Exception -> L12
    L14:
        monitor-exit(this);
        return;
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L10
        goto L14
    }
}
