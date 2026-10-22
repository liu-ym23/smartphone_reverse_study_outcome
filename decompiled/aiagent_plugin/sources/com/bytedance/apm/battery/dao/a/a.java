package com.bytedance.apm.battery.dao.a;

import android.content.ContentValues;
import com.bytedance.apm.battery.dao.DBHelper;
import java.util.List;

/* JADX INFO: compiled from: BatteryTmpLogDao.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends com.bytedance.apm.battery.dao.a<com.bytedance.apm.e.a> implements com.bytedance.apm.battery.dao.a.InterfaceC0110a<com.bytedance.apm.e.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f4330a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f4331b = "_id <= ? ";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f4332c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f4333d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f4334e;

    @Override // com.bytedance.apm.battery.dao.a
    public String b() {
        return DBHelper.T_BATTERY;
    }

    @Override // com.bytedance.apm.battery.dao.a.InterfaceC0110a
    public /* synthetic */ com.bytedance.apm.e.a a(com.bytedance.apm.battery.dao.a.b r1) {
        return b(r1);
    }

    private a() {
    }

    public static a e() {
        if (f4330a != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f4330a != null) goto L9;
        f4330a = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f4330a;
    }

    @Override // com.bytedance.apm.battery.dao.a
    public String[] c() {
        return f4332c;
    }

    public com.bytedance.apm.e.a b(com.bytedance.apm.battery.dao.a.b r22) {
        long r1 = r22.a("_id");
        long r3 = r22.a(DBHelper.COL_FRONT);
        String r10 = r22.c("type");
        long r8 = r22.a(DBHelper.COL_TIME);
        long r12 = r22.a(DBHelper.BATTERY_COL_ACCUMULATION);
        long r14 = r22.a(DBHelper.COL_VERSION_ID);
        String r5 = r22.c(DBHelper.BATTERY_COL_SOURCE);
        long r6 = r22.a("status");
        String r16 = r22.c(DBHelper.BATTERY_COL_SCENE);
        int r11 = r22.b(DBHelper.BATTERY_COL_MAIN_PROCESS);
        String r13 = r22.c(DBHelper.BATTERY_COL_PROCESS_NAME);
        if (r3 == 0) goto L5;
        boolean r4 = true;
    L7:
        if (r6 == 0) goto L9;
        boolean r17 = true;
    L10:
        com.bytedance.apm.e.a r0 = new com.bytedance.apm.e.a(r4, r8, r10, r17, r12, r16, r5);
        r0.b(r13);
        r0.b(r1);
        r0.a(r14);
        if (r11 != 1) goto L13;
        boolean r7 = true;
    L14:
        r0.b(r7);
        r0.c(r22.c("sid"));
        return r0;
    L13:
        r7 = false;
        goto L14
    L9:
        r17 = false;
        goto L10
    L5:
        r4 = false;
        goto L7
    }

    public synchronized long a(com.bytedance.apm.e.a r10) {
        monitor-enter(this);
        if (r10 != null) goto L27;
        monitor-exit(this);
        return -1;
    L27:
        ContentValues r2 = new ContentValues();     // Catch: Throwable -> L22 Exception -> L25
        int r5 = 1;
        if (r10.a() == false) goto L10;
        int r4 = 1;
    L11:
        r2.put(DBHelper.COL_FRONT, Integer.valueOf(r4));     // Catch: Throwable -> L22 Exception -> L25
        r2.put(DBHelper.BATTERY_COL_SOURCE, r10.h());     // Catch: Throwable -> L22 Exception -> L25
        r2.put("type", r10.getType());     // Catch: Throwable -> L22 Exception -> L25
        r2.put(DBHelper.COL_TIME, Long.valueOf(r10.e()));     // Catch: Throwable -> L22 Exception -> L25
        r2.put(DBHelper.BATTERY_COL_ACCUMULATION, Long.valueOf(r10.d()));     // Catch: Throwable -> L22 Exception -> L25
        r2.put(DBHelper.COL_VERSION_ID, Long.valueOf(r10.i()));     // Catch: Throwable -> L22 Exception -> L25
        if (r10.f() == false) goto L14;
        int r6 = 1;
    L15:
        r2.put("status", Integer.valueOf(r6));     // Catch: Throwable -> L22 Exception -> L25
        r2.put(DBHelper.BATTERY_COL_SCENE, r10.g());     // Catch: Throwable -> L22 Exception -> L25
        if (r10.k() == true) goto L19;
        r5 = 0;
    L19:
        r2.put(DBHelper.BATTERY_COL_MAIN_PROCESS, Integer.valueOf(r5));     // Catch: Throwable -> L22 Exception -> L25
        r2.put(DBHelper.BATTERY_COL_PROCESS_NAME, r10.j());     // Catch: Throwable -> L22 Exception -> L25
        r2.put("sid", r10.l());     // Catch: Throwable -> L22 Exception -> L25
        long r0 = insert(r2);     // Catch: Throwable -> L22 Exception -> L25
        monitor-exit(this);
        return r0;
        goto L26
    L14:
        r6 = 0;
        goto L15
    L10:
        r4 = 0;
    L22:
        th = move-exception;
        throw th;
    L26:
        return -1;
    }

    public synchronized List<com.bytedance.apm.e.a> a(boolean r3, long r4) {
        monitor-enter(this);
        if (r3 == false) goto L5;
        List<com.bytedance.apm.e.a> r5 = query(f4333d, null, "_id", this);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return r5;
    L5:
        r5 = query(f4334e, new String[]{String.valueOf(r4)}, "_id", this);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    public synchronized void a(long r5) {
        monitor-enter(this);
        ContentValues r0 = new ContentValues();     // Catch: Throwable -> L6
        r0.put(DBHelper.COL_DELETE, 1);     // Catch: Throwable -> L6
        update(r0, f4331b, new String[]{String.valueOf(r5)});     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    static {
        f4332c = new String[]{"_id", DBHelper.COL_FRONT, "type", DBHelper.COL_TIME, DBHelper.BATTERY_COL_ACCUMULATION, DBHelper.COL_VERSION_ID, DBHelper.BATTERY_COL_SOURCE, "status", DBHelper.BATTERY_COL_SCENE, DBHelper.BATTERY_COL_PROCESS_NAME, DBHelper.BATTERY_COL_MAIN_PROCESS, "sid"};
        f4333d = "main_process = 1 AND delete_flag = 0";
        f4334e = "main_process = 0 AND delete_flag = 0 AND timestamp <= ? ";
    }
}
