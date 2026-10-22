package b1;

import android.content.ContentValues;
import com.bytedance.apm.battery.dao.BaseDao;
import com.bytedance.apm.constant.CommonKey;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a extends BaseDao implements BaseDao.CursorGetter {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile a f5919e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f5920f = "_id <= ? ";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String[] f5921g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f5922h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f5923i;

    static {
        f5921g = new String[]{"_id", CommonKey.KEY_FRONT, "type", "timestamp", "accumulation", "version_id", "source", "status", "scene", "process", "main_process", "sid"};
        f5922h = "main_process = 1 AND delete_flag = 0";
        f5923i = "main_process = 0 AND delete_flag = 0 AND timestamp <= ? ";
    }

    public a() {
    }

    public static a j() {
        if (f5919e != null) goto L16;
        monitor-enter(a.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f5919e != null) goto L11;
        f5919e = new a();     // Catch: Throwable -> L9
    L11:
        monitor-exit(a.class);     // Catch: Throwable -> L9
    L16:
        return f5919e;
    }

    @Override // com.bytedance.apm.battery.dao.BaseDao
    public String[] a() {
        return f5921g;
    }

    @Override // com.bytedance.apm.battery.dao.BaseDao
    public String c() {
        return "t_battery";
    }

    @Override // com.bytedance.apm.battery.dao.BaseDao.CursorGetter
    public /* bridge */ /* synthetic */ Object get(BaseDao.b r10) {
        return i(r10);
    }

    public p1.a i(BaseDao.b r22) {
        long r10 = r22.c("_id");
        long r11 = r22.c(CommonKey.KEY_FRONT);
        String r12 = r22.d("type");
        long r13 = r22.c("timestamp");
        long r14 = r22.c("accumulation");
        long r15 = r22.c("version_id");
        String r16 = r22.d("source");
        long r17 = r22.c("status");
        String r18 = r22.d("scene");
        int r19 = r22.b("main_process");
        String r110 = r22.d("process");
        if (r11 == 0) goto L5;
        boolean r20 = true;
    L7:
        if (r17 == 0) goto L9;
        boolean r111 = true;
    L10:
        p1.a r21 = new p1.a(r20, r13, r12, r111, r14, r18, r16);
        r21.q(r110);
        r21.o(r10);
        r21.u(r15);
        if (r19 != 1) goto L13;
        boolean r23 = true;
    L14:
        r21.p(r23);
        r21.s(r22.d("sid"));
        return r21;
    L13:
        r23 = false;
        goto L14
    L9:
        r111 = false;
        goto L10
    L5:
        r20 = false;
        goto L7
    }

    public synchronized List k(boolean r10, long r11) {
        monitor-enter(this);
        if (r10 == false) goto L7;
        List r12 = f(f5922h, null, "_id", this);     // Catch: Throwable -> L5
    L8:
        monitor-exit(this);
        return r12;
    L7:
        r12 = f(f5923i, new String[]{String.valueOf(r11)}, "_id", this);     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        throw th;
    }

    public synchronized long l(p1.a r10) {
        monitor-enter(this);
        if (r10 != null) goto L15;
        monitor-exit(this);
        return -1;
    L15:
        ContentValues r11 = new ContentValues();     // Catch: Throwable -> L10 Exception -> L13
        r11.put(CommonKey.KEY_FRONT, Integer.valueOf(r10.k() ? 1 : 0));     // Catch: Throwable -> L10 Exception -> L13
        r11.put("source", r10.e());     // Catch: Throwable -> L10 Exception -> L13
        r11.put("type", r10.h());     // Catch: Throwable -> L10 Exception -> L13
        r11.put("timestamp", Long.valueOf(r10.g()));     // Catch: Throwable -> L10 Exception -> L13
        r11.put("accumulation", Long.valueOf(r10.a()));     // Catch: Throwable -> L10 Exception -> L13
        r11.put("version_id", Long.valueOf(r10.i()));     // Catch: Throwable -> L10 Exception -> L13
        r11.put("status", Integer.valueOf(r10.n() ? 1 : 0));     // Catch: Throwable -> L10 Exception -> L13
        r11.put("scene", r10.d());     // Catch: Throwable -> L10 Exception -> L13
        r11.put("main_process", Integer.valueOf(r10.l() ? 1 : 0));     // Catch: Throwable -> L10 Exception -> L13
        r11.put("process", r10.c());     // Catch: Throwable -> L10 Exception -> L13
        r11.put("sid", r10.f());     // Catch: Throwable -> L10 Exception -> L13
        long r12 = e(r11);     // Catch: Throwable -> L10 Exception -> L13
        monitor-exit(this);
        return r12;
    L10:
        th = move-exception;
        throw th;
    L14:
        return -1;
    }

    public synchronized void m(long r10) {
        monitor-enter(this);
        ContentValues r11 = new ContentValues();     // Catch: Throwable -> L6
        r11.put("delete_flag", 1);     // Catch: Throwable -> L6
        h(r11, f5920f, new String[]{String.valueOf(r10)});     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
