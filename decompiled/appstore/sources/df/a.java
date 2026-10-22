package df;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.e;
import com.bytedanceos.common.toolbox.ServerElements;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f19181b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f19182c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static a f19183d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SQLiteDatabase f19184a;

    /* JADX INFO: renamed from: df.a$a, reason: collision with other inner class name */
    public static class C0236a extends SQLiteOpenHelper {
        public C0236a(Context r10) {
            super(r10, "ss_push_log.db", null, 1);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase r10) {
            r10.execSQL("CREATE TABLE event ( _id INTEGER PRIMARY KEY AUTOINCREMENT, category VARCHAR, tag VARCHAR, label VARCHAR, value INTEGER, ext_value INTEGER, ext_json TEXT )");     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            Logger.e("PushLog", "create db exception " + e);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase r10, int r11, int r12) {
        }
    }

    static {
        f19181b = new String[]{"_id", "category", "tag", ServerElements.LABEL, CommonKey.KEY_VALUE, "ext_value", "ext_json"};
        f19182c = new Object();
    }

    public a(Context r10) {
        this.f19184a = new C0236a(r10).getWritableDatabase();
    }

    public static void a() {
        Object r10 = f19182c;
        monitor-enter(r10);
        a r11 = f19183d;     // Catch: Throwable -> L7
        if (r11 == null) goto L9;
        r11.b();     // Catch: Throwable -> L7
    L9:
        f19183d = null;     // Catch: Throwable -> L7
        monitor-exit(r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static a e(Context r10) {
        Object r11 = f19182c;
        monitor-enter(r11);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (f19183d != null) goto L9;
        f19183d = new a(r10.getApplicationContext());     // Catch: Throwable -> L7
    L9:
        monitor-exit(r11);     // Catch: Throwable -> L7
        return f19183d;
    }

    public static void g(Cursor r10) {
        if (r10 == null) goto L10;
        if (r10.isClosed() == true) goto L11;
        r10.close();     // Catch: Exception -> L7
        return;
    L11:
        return;
    L12:
        return;
    }

    public final synchronized void b() {
        monitor-enter(this);
        SQLiteDatabase r10 = this.f19184a;     // Catch: Throwable -> L9
        if (r10 != null) goto L6;
    L11:
        monitor-exit(this);
        return;
    L6:
        if (r10.isOpen() == false) goto L11;
        this.f19184a.close();     // Catch: Throwable -> L9
        this.f19184a = null;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Logger.w("PushLog", "closeDatabase error: " + th);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public synchronized boolean c(long r10) {
        monitor-enter(this);
        SQLiteDatabase r11 = this.f19184a;     // Catch: Throwable -> L13
        boolean r12 = false;
        if (r11 != null) goto L6;
    L15:
        Logger.w("PushLog", "db not establish and open");     // Catch: Throwable -> L13
        monitor-exit(this);
        return false;
    L6:
        if (r11.isOpen() == false) goto L15;
        String[] r13 = {String.valueOf(r10)};     // Catch: Throwable -> L13
        if (this.f19184a.delete("event", "_id = ?", r13) <= 0) goto L11;
        r12 = true;
    L11:
        monitor-exit(this);
        return r12;
    L13:
        th = move-exception;
        throw th;
    }

    public synchronized JSONArray d(long r20, int r22) {
        monitor-enter(this);
        String r10 = "" + r22;     // Catch: Throwable -> L47
        String[] r11 = {String.valueOf(r20)};     // Catch: Throwable -> L47
        JSONArray r12 = new JSONArray();     // Catch: Throwable -> L47
        int r13 = 0;
        Cursor r14 = this.f19184a.query("event", f19181b, "_id > ? ", r11, null, null, "_id ASC", r10);     // Catch: Throwable -> L49
        int r15 = 0;
        long r16 = 0;
    L66:
        if (r14.moveToNext() == false) goto L45;
        long r17 = r14.getLong(r13);     // Catch: Throwable -> L13
        String r18 = r14.getString(1);     // Catch: Throwable -> L13
        String r19 = r14.getString(2);     // Catch: Throwable -> L13
        if (r14.isNull(3) == true) goto L15;
        String r110 = r14.getString(3);     // Catch: Throwable -> L13
    L17:
        if (r14.isNull(4) == true) goto L19;
        long r111 = r14.getLong(4);     // Catch: Throwable -> L13
    L21:
        if (r14.isNull(5) == true) goto L23;
        long r112 = r14.getLong(5);     // Catch: Throwable -> L13
    L25:
        if (r14.isNull(6) == true) goto L27;
        String r113 = r14.getString(6);     // Catch: Throwable -> L13
    L29:
        if (r16 >= r17) goto L31;
        r16 = r17;
    L31:
        JSONObject r21 = new JSONObject();     // Catch: Throwable -> L13
        r21.put("_id", r17);     // Catch: Throwable -> L13
        if (e.b(r113) == true) goto L34;
        r21.put("ext_json", r113);     // Catch: Throwable -> L13
    L34:
        r21.put("category", r18);     // Catch: Throwable -> L13
        r21.put("tag", r19);     // Catch: Throwable -> L13
        if (e.b(r110) == true) goto L38;
        r21.put(ServerElements.LABEL, r110);     // Catch: Throwable -> L13
    L38:
        if (r111 == 0) goto L40;
        r21.put(CommonKey.KEY_VALUE, r111);     // Catch: Throwable -> L13
    L40:
        long r114 = r112;
        if (r114 == 0) goto L43;
        r21.put("ext_value", r114);     // Catch: Throwable -> L13
    L43:
        r12.put(r21);     // Catch: Throwable -> L13
        r15 = r15 + 1;
        r13 = 0;
        goto L66
    L27:
        r113 = null;
        goto L29
    L23:
        r112 = 0;
        goto L25
    L19:
        r111 = 0;
        goto L21
    L15:
        r110 = null;
        goto L17
    L45:
        g(r14);     // Catch: Throwable -> L47
    L54:
        if (r15 <= 0) goto L57;
        monitor-exit(this);
        return r12;
    L57:
        monitor-exit(this);
        return null;
    L13:
        th = th;
        int r115 = r15;
    L71:
        th.printStackTrace();     // Catch: Throwable -> L60
        g(r14);     // Catch: Throwable -> L47
        r15 = r115;
        goto L54
    L60:
        th = move-exception;
        g(r14);     // Catch: Throwable -> L47
        throw th;     // Catch: Throwable -> L47
    L49:
        th = th;
        r14 = null;
        r115 = 0;
    L47:
        th = move-exception;
        throw th;
    }

    public synchronized long f(b r10) {
        monitor-enter(this);
        SQLiteDatabase r11 = this.f19184a;     // Catch: Throwable -> L11
        if (r11 != null) goto L6;
    L19:
        Logger.w("PushLog", "db not establish and open");     // Catch: Throwable -> L11
        monitor-exit(this);
        return -1;
    L6:
        if (r11.isOpen() == false) goto L19;
        ContentValues r12 = new ContentValues();     // Catch: Throwable -> L11
        r12.put("category", r10.f19185a);     // Catch: Throwable -> L11
        r12.put("tag", r10.f19186b);     // Catch: Throwable -> L11
        if (e.b(r10.f19187c) == true) goto L13;
        r12.put(ServerElements.LABEL, r10.f19187c);     // Catch: Throwable -> L11
    L13:
        r12.put(CommonKey.KEY_VALUE, Long.valueOf(r10.f19188d));     // Catch: Throwable -> L11
        r12.put("ext_value", Long.valueOf(r10.f19189e));     // Catch: Throwable -> L11
        if (e.b(r10.f19190f) == true) goto L16;
        r12.put("ext_json", r10.f19190f);     // Catch: Throwable -> L11
    L16:
        long r13 = this.f19184a.insert("event", null, r12);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r13;
    L11:
        th = move-exception;
        throw th;
    }
}
