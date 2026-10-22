package com.bytedance.applog.store;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteBlobTooBigException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.bytedance.applog.engine.Engine;
import com.bytedance.applog.log.l;
import com.bytedance.applog.monitor.v3.MonitorV3Helper;
import com.bytedance.applog.monitor.v3.j;
import com.bytedance.applog.util.p;
import com.bytedance.common.wschannel.WsConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class DbStore {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Engine f5986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DbOpenHelper f5987b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HashMap<String, a> f5988c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a[] f5989d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Set<String> f5990e;
    private int f;
    private int g;
    private int h;
    private int i;

    private class DbOpenHelper extends SQLiteOpenHelper {
        private long dbInitSize;
        final /* synthetic */ DbStore this$0;

        DbOpenHelper(DbStore r3, Context r4, String r5, SQLiteDatabase.CursorFactory r6, int r7) {
            Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            SQLiteDatabase.CursorFactory r9 = (SQLiteDatabase.CursorFactory) ZeusTransformUtils.wrapperContextForParams(r6, SQLiteDatabase.CursorFactory.class, "com.obric.aiagent.plugin");
            this.this$0 = r3;
            super(r8, r5, r9, r7);
            long r10 = 0;
            this.dbInitSize = 0;
            File r11 = r8.getDatabasePath(r5);
            if (r11 == null) goto L5;
            r10 = r11.length();
        L5:
            this.dbInitSize = r10;
        }

        public int getDbInitSizeInKb() {
            long r0 = this.dbInitSize;
            if (r0 > 0) goto L7;
            return 0;
        L7:
            return Math.toIntExact(r0 / 1024);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase r6) {
            r6.beginTransaction();     // Catch: Throwable -> L10
            Iterator r0 = DbStore.a(this.this$0).values().iterator();     // Catch: Throwable -> L10
        L4:
            if (r0.hasNext() == false) goto L8;
            String r1 = ((a) ZeusTransformUtils.preCheckCast(r0.next(), a.class, "com.obric.aiagent.plugin")).g();     // Catch: Throwable -> L10
            if (r1 == null) goto L4;
            r6.execSQL(r1);     // Catch: Throwable -> L10
            goto L4
        L8:
            r6.setTransactionSuccessful();     // Catch: Throwable -> L10
        L9:
            p.a(r6);
            return;
        L10:
            th = move-exception;
            DbStore.b(this.this$0).a(5, "create db failed", th, new Object[0]);     // Catch: Throwable -> L14
            DbStore.c(this.this$0).getAppLog().N().sendError("DBHelper onCreate failed", th);     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            p.a(r6);
            throw th;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase r5, int r6, int r7) {
            DbStore.b(this.this$0).c(5, "onUpgrade: v{} -> v{}", new Object[]{Integer.valueOf(r6), Integer.valueOf(r7)});
            r5.beginTransaction();     // Catch: Throwable -> L9
            Iterator r8 = DbStore.a(this.this$0).values().iterator();     // Catch: Throwable -> L9
        L5:
            if (r8.hasNext() == false) goto L7;
            r5.execSQL("DROP TABLE IF EXISTS " + ((a) ZeusTransformUtils.preCheckCast(r8.next(), a.class, "com.obric.aiagent.plugin")).h());     // Catch: Throwable -> L9
            goto L5
        L7:
            r5.setTransactionSuccessful();     // Catch: Throwable -> L9
        L8:
            p.a(r5);
            onCreate(r5);
            return;
        L9:
            th = move-exception;
            DbStore.b(this.this$0).a(5, "upgrade db failed", th, new Object[0]);     // Catch: Throwable -> L14
            DbStore.c(this.this$0).getAppLog().N().sendError("DBHelper onUpgrade failed", th);     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            p.a(r5);
            throw th;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase r1, int r2, int r3) {
            onUpgrade(r1, r2, r3);
        }
    }

    static /* synthetic */ HashMap a(DbStore r0) {
        return r0.f5988c;
    }

    static /* synthetic */ com.bytedance.applog.log.f b(DbStore r0) {
        return r0.i();
    }

    static /* synthetic */ Engine c(DbStore r0) {
        return r0.f5986a;
    }

    public DbStore(Engine r10, String r11) {
        this.f5988c = new HashMap();
        a[] r0 = a.d();
        this.f5989d = r0;
        this.f5990e = new HashSet();
        int r1 = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.f5987b = new DbOpenHelper(this, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r11, null, 56);
        this.f5986a = r10;
        a(new h());
        a(new f());
        a(new i());
        a(new g());
        a(new e());
        int r12 = r0.length;
    L3:
        if (r1 >= r12) goto L5;
        a(r0[r1]);
        r1 = r1 + 1;
        goto L3
    L5:
        h();
    }

    public int a() {
        return this.f;
    }

    public int b() {
        return this.g;
    }

    public int c() {
        return this.h;
    }

    public int d() {
        return this.i;
    }

    public int e() {
        return this.f5987b.getDbInitSizeInKb();
    }

    private com.bytedance.applog.log.f i() {
        return this.f5986a.getAppLog().Z();
    }

    private String a(int r2) {
        return "SELECT * FROM launch ORDER BY _id DESC LIMIT " + r2;
    }

    private String a(String r2, boolean r3) {
        StringBuilder r1 = new StringBuilder().append("SELECT * FROM page WHERE session_id");
        if (r3 == false) goto L5;
        String r0 = "='";
    L6:
        StringBuilder r4 = r1.append(r0).append(r2).append("' ORDER BY ");
        if (r3 == false) goto L9;
        String r5 = "session_id,";
    L11:
        return r4.append(r5).append("duration").append(" DESC LIMIT 1000").toString();
    L9:
        r5 = "";
        goto L11
    L5:
        r0 = "!='";
        goto L6
    }

    private String b(String r2, boolean r3) {
        StringBuilder r1 = new StringBuilder().append("DELETE FROM page WHERE session_id");
        if (r3 == false) goto L5;
        String r4 = "='";
    L7:
        return r1.append(r4).append(r2).append("'").toString();
    L5:
        r4 = "!='";
        goto L7
    }

    private String a(a r3, String r4, boolean r5, int r6, com.bytedance.applog.priority.b r7) {
        StringBuilder r2 = new StringBuilder("SELECT * FROM " + r3.h() + " WHERE session_id");
        if (r5 == false) goto L5;
        r2.append("='");
    L6:
        r2.append(r4);
        if (r7 == null) goto L12;
        int r8 = r7.a();
        if ((-1) != r8) goto L11;
        r2.append("' AND (priority=" + r8 + " OR priority>" + r7.b() + ")");
    L13:
        r2.append(" ORDER BY _id LIMIT " + r6);
        return r2.toString();
    L11:
        r2.append("' AND priority=" + r8);
        goto L13
    L12:
        r2.append("'");
        goto L13
    L5:
        r2.append("!='");
        goto L6
    }

    private String a(a r2, int r3, int r4) {
        return "SELECT * FROM " + r2.h() + " WHERE priority=" + r4 + " ORDER BY _id LIMIT " + r3;
    }

    private String a(String r3, String r4, boolean r5, long r6, com.bytedance.applog.priority.b r8) {
        StringBuilder r2 = new StringBuilder("DELETE FROM " + r3 + " WHERE session_id");
        if (r5 == false) goto L5;
        r2.append("='");
    L6:
        r2.append(r4 + "' AND _id<=" + r6);
        if (r8 == null) goto L13;
        int r7 = r8.a();
        if ((-1) != r7) goto L11;
        r2.append(" AND (priority=" + r7 + " OR priority>" + r8.b() + ")");
        goto L13
    L11:
        r2.append(" AND priority=" + r7);
    L13:
        return r2.toString();
    L5:
        r2.append("!='");
        goto L6
    }

    private String a(String r2, long r3, int r5) {
        return "DELETE FROM " + r2 + " WHERE _id<=" + r3 + " AND priority=" + r5;
    }

    private String b(int r4, com.bytedance.applog.priority.b r5) {
        StringBuilder r3 = new StringBuilder("SELECT * FROM pack");
        if (r5 == null) goto L8;
        int r0 = r5.a();
        if ((-1) != r0) goto L7;
        r3.append(" WHERE priority=" + r0 + " OR priority>" + r5.b());
        goto L8
    L7:
        r3.append(" WHERE priority=" + r0);
    L8:
        r3.append(" ORDER BY _id DESC LIMIT " + r4);
        return r3.toString();
    }

    private String a(long r2, int r4) {
        return "UPDATE pack SET _fail=" + r4 + " WHERE _id=" + r2;
    }

    private void a(a r2) {
        this.f5988c.put(r2.h(), r2);
    }

    private boolean a(String r6) {
        if (this.f5990e.contains(r6) == true) goto L5;
        this.f5990e.add(r6);
        boolean r0 = true;
    L6:
        i().c(5, "session id:{} needLaunch:{}", new Object[]{r6, Boolean.valueOf(r0)});
        return r0;
    L5:
        r0 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public synchronized void a(JSONObject r28, com.bytedance.applog.priority.b r29, int r30, boolean r31) {
        monitor-enter(this);
        f r0 = (f) ZeusTransformUtils.preCheckCast(this.f5988c.get("launch"), f.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L115
        i r14 = (i) ZeusTransformUtils.preCheckCast(this.f5988c.get("terminate"), i.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L115
        h r15 = (h) ZeusTransformUtils.preCheckCast(this.f5988c.get("page"), h.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L115
        g r12 = (g) ZeusTransformUtils.preCheckCast(this.f5988c.get("pack"), g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L115
        SQLiteDatabase r2 = null;
        int r11 = 0;
        JSONArray[] r9 = new JSONArray[3];     // Catch: Throwable -> L93
        long[] r8 = new long[3];     // Catch: Throwable -> L93
        HashMap<String, JSONObject> r7 = new HashMap();     // Catch: Throwable -> L93
        i().c(5, "DbStore pack before collect impression.", new Object[0]);     // Catch: Throwable -> L93
        SQLiteDatabase r6 = this.f5987b.getWritableDatabase();     // Catch: Throwable -> L93
        a(r6, r7);     // Catch: Throwable -> L90
        i().c(5, "DbStore pack after collect impression.", new Object[0]);     // Catch: Throwable -> L90
        r6.beginTransaction();     // Catch: Throwable -> L90
        Cursor r5 = r6.rawQuery(a(5), null);     // Catch: Throwable -> L90
        com.bytedance.applog.engine.e r1 = this.f5986a.getSession();     // Catch: Throwable -> L88
        String r4 = r1.b();     // Catch: Throwable -> L88
        boolean r16 = r1.e();     // Catch: Throwable -> L88
        ArrayList r3 = new ArrayList();     // Catch: Throwable -> L88
        if (r31 == true) goto L151;
        boolean r10 = r5.moveToLast();     // Catch: Throwable -> L88
    L15:
        JSONObject r13 = r28;
    L16:
        boolean r17 = 1;
        if (r10 == false) goto L45;
        r0.a(r5);     // Catch: Throwable -> L41
        r12.f5994d = r0.f5994d;     // Catch: Throwable -> L41
        JSONObject r18 = a(r0, r28);     // Catch: Throwable -> L41
        if (TextUtils.equals(r0.f5994d, r4) == false) goto L29;
        if (r16 == false) goto L23;
        r17 = r11;
    L23:
        r0.w = r17;     // Catch: Throwable -> L41
        ArrayList r19 = r3;
        Cursor r20 = r5;
        SQLiteDatabase r21 = r6;
        HashMap<String, JSONObject> r22 = r7;
        long[] r23 = r8;
        JSONArray[] r24 = r9;
        a(r18, r0, r12, r6, r9, r8, r22, r29, r30);     // Catch: Throwable -> L27
        ArrayList r110 = r19;
        int r111 = 0;
    L33:
        if (r31 == true) goto L136;
        r10 = r20.moveToPrevious();     // Catch: Throwable -> L37
    L36:
        r11 = r111;
        r3 = r110;
        r13 = r18;
        r4 = r4;
        r5 = r20;
        r6 = r21;
        r7 = r22;
        r8 = r23;
        r9 = r24;
        r15 = r15;
        r12 = r12;
        goto L16
    L136:
        r10 = r20.moveToNext();     // Catch: Throwable -> L37
    L37:
        th = th;
    L43:
        r2 = r21;
    L44:
        int r112 = 5;
    L126:
        this.f5986a.getAppLog().N().increaseStats(j.f5823J);     // Catch: Throwable -> L105
        this.f5986a.getAppLog().N().sendError("pack failed", th);     // Catch: Throwable -> L105
        i().a(r112, "pack failed", th, new Object[r111]);     // Catch: Throwable -> L105
        if (r20 != null) goto L140;
    L102:
        p.a(r2);     // Catch: Throwable -> L115
    L103:
        monitor-exit(this);
        return;
    L140:
        r20.close();     // Catch: Throwable -> L99
    L99:
        th = move-exception;
        i().a(r112, "close cursor failed", th, new Object[r111]);     // Catch: Throwable -> L115
        goto L102
    L105:
        th = move-exception;
        if (r20 != null) goto L130;
    L113:
        p.a(r2);     // Catch: Throwable -> L115
        throw th;     // Catch: Throwable -> L115
    L130:
        r20.close();     // Catch: Throwable -> L110
    L110:
        th = move-exception;
        i().a(r112, "close cursor failed", th, new Object[r111]);     // Catch: Throwable -> L115
    L27:
        th = th;
        r2 = r21;
        r112 = 5;
        r111 = 0;
        goto L126
    L29:
        ArrayList r113 = r3;
        r20 = r5;
        r21 = r6;
        r22 = r7;
        r23 = r8;
        r24 = r9;
        r113.add(Long.valueOf(r0.f5991a));     // Catch: Throwable -> L39
        h r25 = r15;
        r110 = r113;
        r111 = 0;
        a(r18, r0, r12, r25, r14, r21, r24, r23, r22, r29, r30);     // Catch: Throwable -> L37
    L39:
        th = th;
        r111 = 0;
    L41:
        th = th;
        r20 = r5;
        r21 = r6;
        r111 = r11;
        goto L43
    L45:
        ArrayList r114 = r3;
        String r115 = r4;
        r20 = r5;
        SQLiteDatabase r26 = r6;
        long[] r27 = r8;
        JSONArray[] r210 = r9;
        g r211 = r12;
        h r212 = r15;
        r111 = r11;
        if (r114.isEmpty() == false) goto L122;
    L60:
        SQLiteDatabase r116 = r26;
        if (r20.getCount() < 5) goto L149;
    L71:
        r112 = 5;
        SQLiteDatabase r117 = r116;
    L72:
        r117.setTransactionSuccessful();     // Catch: Throwable -> L81
        if (r20 != null) goto L134;
    L79:
        p.a(r117);     // Catch: Throwable -> L115
        goto L103
    L134:
        r20.close();     // Catch: Throwable -> L76
    L76:
        th = move-exception;
        i().a(r112, "close cursor failed", th, new Object[r111]);     // Catch: Throwable -> L115
    L81:
        th = th;
    L92:
        r2 = r117;
        goto L126
    L149:
    L69:
        th = th;
        r112 = 5;
        r117 = r116;
        goto L92
    L65:
        if (TextUtils.isEmpty(r115) == true) goto L71;
        r112 = 5;
        r117 = r116;
        a(r13, (f) ZeusTransformUtils.preCheckCast(r0.l(), f.class, "com.obric.aiagent.plugin"), r14, r212, r211, r116, r115, r210, r27, r29, r30);     // Catch: Throwable -> L81
    L83:
        th = th;
        r117 = r116;
    L87:
        r112 = 5;
        goto L92
    L122:
        Iterator r32 = r114.iterator();     // Catch: Throwable -> L57
    L50:
        if (r32.hasNext() == false) goto L60;
        String[] r33 = new String[1];     // Catch: Throwable -> L57
        r33[r111] = String.valueOf((Long) ZeusTransformUtils.preCheckCast(r32.next(), Long.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L57
        SQLiteDatabase r118 = r26;
        r118.execSQL("DELETE FROM launch WHERE _id=?", r33);     // Catch: Throwable -> L55
        r26 = r118;
    L55:
        th = th;
    L59:
        r2 = r118;
    L57:
        th = th;
        r118 = r26;
    L85:
        th = th;
        r117 = r26;
        goto L87
    L151:
        r10 = r5.moveToFirst();     // Catch: Throwable -> L12
    L12:
        th = th;
        r20 = r5;
        r2 = r6;
        r112 = 5;
        r111 = 0;
    L88:
        th = th;
        r20 = r5;
        r117 = r6;
        r112 = 5;
        r111 = 0;
    L90:
        th = th;
        r117 = r6;
        r112 = 5;
        r111 = 0;
        r20 = null;
    L93:
        th = th;
        r112 = 5;
        r111 = 0;
        r20 = null;
    L115:
        th = move-exception;
        throw th;
    }

    public synchronized void a(JSONObject r18, com.bytedance.applog.priority.b r19, int r20) {
        monitor-enter(this);
        SQLiteDatabase r2 = null;
        JSONArray[] r14 = new JSONArray[3];     // Catch: Throwable -> L14
        long[] r0 = new long[3];     // Catch: Throwable -> L14
        r2 = this.f5987b.getWritableDatabase();     // Catch: Throwable -> L14
        r2.beginTransaction();     // Catch: Throwable -> L14
        int r15 = 200;
        int r3 = 200;
    L6:
        if (r3 < r15) goto L11;
        a(r2, r14, r0, r19.a());     // Catch: Throwable -> L14
        int r16 = r14[1].length();     // Catch: Throwable -> L14
        if (r16 == 0) goto L11;
        g r13 = new g();     // Catch: Throwable -> L14
        r13.a(this.f5986a.getAppLog().b(), r18, null, null, null, r14, r0, null, r19, r20);     // Catch: Throwable -> L14
        a(r13, r2, r19.a());     // Catch: Throwable -> L14
        r3 = r16;
        r15 = 200;
    L11:
        r2.setTransactionSuccessful();     // Catch: Throwable -> L14
    L12:
        p.a(r2);     // Catch: Throwable -> L22
        monitor-exit(this);
        return;
    L14:
        th = move-exception;
        this.f5986a.getAppLog().N().increaseStats(j.f5823J);     // Catch: Throwable -> L19
        this.f5986a.getAppLog().N().sendError("packByPriority failed", th);     // Catch: Throwable -> L19
        i().a(5, "pack by priority failed", th, new Object[0]);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        p.a(r2);     // Catch: Throwable -> L22
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    public synchronized List<e> f() {
        monitor-enter(this);
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L20
        Cursor r1 = null;
        r1 = this.f5987b.getWritableDatabase().rawQuery("SELECT * FROM forward_eventv3 ORDER BY _id ASC LIMIT 1000", null);     // Catch: Throwable -> L12
    L7:
        if (r1.moveToNext() == false) goto L10;
        e r2 = new e();     // Catch: Throwable -> L12
        r2.a(r1);     // Catch: Throwable -> L12
        r0.add(r2);     // Catch: Throwable -> L12
    L10:
        p.a(r1);     // Catch: Throwable -> L20
        monitor-exit(this);
        return r0;
    L12:
        th = move-exception;
        i().a(5, "pack forward events failed", th, new Object[0]);     // Catch: Throwable -> L17
        this.f5986a.getAppLog().N().sendError("queryForwardEvents failed", th);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        p.a(r1);     // Catch: Throwable -> L20
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    private JSONObject a(f r5, JSONObject r6) {
        if (TextUtils.equals(r5.v, this.f5986a.getDm().c()) == true) goto L5;
    L11:
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L8
        p.b(r0, r6);     // Catch: JSONException -> L8
        r0.put(WsConstants.KEY_APP_VERSION, r5.v);     // Catch: JSONException -> L8
        r0.put("version_code", r5.u);     // Catch: JSONException -> L8
        return r0;
    L8:
        e = move-exception;
        i().a(5, "check version failed", e, new Object[0]);
        return r6;
    L5:
        if (r5.u != this.f5986a.getDm().b()) goto L11;
        return r6;
    }

    private void a(JSONObject r23, f r24, g r25, SQLiteDatabase r26, JSONArray[] r27, long[] r28, HashMap<String, JSONObject> r29, com.bytedance.applog.priority.b r30, int r31) {
        JSONObject r15 = r23;
        f r14 = r24;
        long[] r11 = r28;
        i().c(5, "packCurrentData sid:{}", new Object[]{r14.f5994d});
        com.bytedance.applog.a.a r7 = new com.bytedance.applog.a.a();
        r7.a(r15);
        com.bytedance.applog.a.a r21 = r7;
        int r0 = a(0, r26, r14.f5994d, true, r27, r28, r30, r21);
        boolean r1 = a(r14.f5994d);
        JSONArray r18 = a(r14.f5994d, r29);
        if (r1 == false) goto L5;
    L9:
        String r2 = this.f5986a.getAppLog().b();
        if (r1 == false) goto L12;
        f r3 = r14;
    L13:
        com.bytedance.applog.priority.b r8 = r30;
        SQLiteDatabase r6 = r26;
        g r5 = r25;
        r25.a(r2, r23, r3, null, null, r27, r28, r18, r30, r31);
        boolean r16 = true;
        a(r5, true, r6, r8);
    L14:
        int r4 = r0;
    L16:
        if (r4 >= this.f5989d.length) goto L22;
        com.bytedance.applog.a.a r17 = r21;
        r17.a(r15);
        g r13 = r5;
        SQLiteDatabase r12 = r6;
        com.bytedance.applog.priority.b r10 = r8;
        r4 = a(r4, r26, r14.f5994d, true, r27, r28, r30, r17);
        if (a(r11) == false) goto L20;
        com.bytedance.applog.priority.b r9 = r10;
        SQLiteDatabase r19 = r12;
        g r20 = r13;
        boolean r22 = r16;
        r25.a(this.f5986a.getAppLog().b(), r23, null, null, null, r27, r28, null, r30, r31);
        a(r20, r22, r19, r9);
    L21:
        r11 = r28;
        r21 = r17;
        r16 = r22;
        r8 = r9;
        r5 = r20;
        r15 = r23;
        r14 = r24;
        r6 = r19;
        goto L16
    L20:
        r9 = r10;
        r19 = r12;
        r20 = r13;
        r22 = r16;
        goto L21
    L22:
        return;
    L12:
        r3 = null;
        goto L13
    L5:
        if (a(r11) == true) goto L9;
        if (r18 != null) goto L9;
        r8 = r30;
        r6 = r26;
        r5 = r25;
        r16 = true;
        goto L14
    }

    private void a(JSONObject r23, f r24, g r25, h r26, i r27, SQLiteDatabase r28, JSONArray[] r29, long[] r30, HashMap<String, JSONObject> r31, com.bytedance.applog.priority.b r32, int r33) {
        boolean r16 = false;
        i().c(5, "packHistoryData sid:{}", new Object[]{r24.f5994d});
        com.bytedance.applog.a.a r7 = new com.bytedance.applog.a.a();
        r7.a(r23);
        com.bytedance.applog.a.a r21 = r7;
        int r8 = a(0, r28, r24.f5994d, true, r29, r30, r32, r21);
        JSONArray r0 = a(r24, true, r27, r26, r28, r32, a(r30));
        if (r0.length() <= 0) goto L5;
        boolean r1 = true;
    L6:
        r24.w = !r1;
        JSONArray r18 = a(r24.f5994d, r31);
        if (r24.w == true) goto L9;
        JSONObject r2 = r23;
        com.bytedance.applog.priority.b r9 = r32;
        long[] r6 = r30;
        SQLiteDatabase r5 = r28;
        g r4 = r25;
        f r3 = r24;
        boolean r10 = true;
        r25.a(this.f5986a.getAppLog().b(), r23, null, r27, r0, r29, r30, r18, r32, r33);
    L21:
        r16 = r10;
    L22:
        if (r16 == false) goto L25;
        a(r4, r10, r5, r9);
    L25:
        if (r8 >= this.f5989d.length) goto L31;
        com.bytedance.applog.a.a r15 = r21;
        r15.a(r2);
        boolean r14 = r10;
        g r13 = r4;
        SQLiteDatabase r12 = r5;
        com.bytedance.applog.priority.b r11 = r9;
        r8 = a(r8, r28, r3.f5994d, true, r29, r30, r32, r15);
        if (a(r6) == false) goto L29;
        com.bytedance.applog.priority.b r17 = r11;
        SQLiteDatabase r19 = r12;
        g r20 = r13;
        boolean r22 = r14;
        r25.a(this.f5986a.getAppLog().b(), r23, null, null, null, r29, r30, null, r32, r33);
        a(r20, r22, r19, r17);
    L30:
        r3 = r24;
        r6 = r30;
        r21 = r15;
        r9 = r17;
        r4 = r20;
        r5 = r19;
        r10 = r22;
        r2 = r23;
        goto L25
    L29:
        r17 = r11;
        r19 = r12;
        r20 = r13;
        r22 = r14;
        goto L30
    L31:
        return;
    L9:
        if (a(r24.f5994d) == false) goto L12;
        r9 = r32;
        r6 = r30;
        r5 = r28;
        r4 = r25;
        r3 = r24;
        r2 = r23;
        boolean r34 = true;
        r25.a(this.f5986a.getAppLog().b(), r23, r24, null, null, r29, r30, r18, r32, r33);
    L11:
        r10 = r34;
        goto L21
    L12:
        r2 = r23;
        r9 = r32;
        r6 = r30;
        r5 = r28;
        r4 = r25;
        r3 = r24;
        r34 = true;
        if (a(r6) == true) goto L19;
        if (r18 != null) goto L16;
    L18:
        r10 = true;
        goto L22
    L16:
        if (r18.length() <= 0) goto L18;
    L19:
        r25.a(this.f5986a.getAppLog().b(), r23, null, null, null, r29, r30, r18, r32, r33);
        goto L11
    L5:
        r1 = false;
        goto L6
    }

    private void a(JSONObject r23, f r24, i r25, h r26, g r27, SQLiteDatabase r28, String r29, JSONArray[] r30, long[] r31, com.bytedance.applog.priority.b r32, int r33) {
        JSONObject r15 = r23;
        long[] r11 = r31;
        i().c(5, "packLostData exclude sid:{}", new Object[]{r29});
        r24.f5994d = r29;
        r27.f5994d = r29;
        com.bytedance.applog.a.a r5 = new com.bytedance.applog.a.a();
        r5.a(r15);
        com.bytedance.applog.a.a r21 = r5;
        int r8 = a(0, r28, r29, false, r30, r31, r32, r21);
        JSONArray r0 = a(r24, false, r25, r26, r28, r32, a(r11));
        if (r0.length() <= 0) goto L5;
        boolean r7 = true;
    L6:
        r24.w = !r7;
        if (a(r11) == false) goto L9;
    L12:
        String r1 = this.f5986a.getAppLog().b();
        JSONArray r4 = null;
        if (r24.w == true) goto L15;
        i r3 = r25;
    L17:
        if (r24.w == true) goto L19;
        r4 = r0;
    L19:
        SQLiteDatabase r6 = r28;
        g r9 = r27;
        r27.a(r1, r23, null, r3, r4, r30, r31, null, r32, r33);
        com.bytedance.applog.priority.b r16 = r32;
        boolean r14 = false;
        a(r9, false, r6, r16);
    L20:
        int r2 = r8;
    L22:
        if (r2 >= this.f5989d.length) goto L28;
        com.bytedance.applog.a.a r13 = r21;
        r13.a(r15);
        g r12 = r9;
        SQLiteDatabase r17 = r6;
        r2 = a(r2, r28, r29, false, r30, r31, r32, r13);
        if (a(r11) == false) goto L26;
        SQLiteDatabase r10 = r17;
        g r18 = r12;
        boolean r19 = r14;
        com.bytedance.applog.priority.b r20 = r16;
        r27.a(this.f5986a.getAppLog().b(), r23, null, null, null, r30, r31, null, r32, r33);
        a(r18, r19, r10, r20);
    L27:
        r11 = r31;
        r14 = r19;
        r16 = r20;
        r21 = r13;
        r15 = r23;
        r6 = r10;
        r9 = r18;
        goto L22
    L26:
        r10 = r17;
        r18 = r12;
        r19 = r14;
        r20 = r16;
        goto L27
    L28:
        return;
    L15:
        r3 = null;
        goto L17
    L9:
        if (r24.w == false) goto L12;
        r6 = r28;
        r9 = r27;
        r14 = false;
        r16 = r32;
        goto L20
    L5:
        r7 = false;
        goto L6
    }

    private boolean a(long[] r7) {
        if (r7[0] > 0) goto L9;
        if (r7[1] > 0) goto L9;
        if (r7[2] > 0) goto L9;
        return false;
    L9:
        return true;
    }

    private void a(SQLiteDatabase r11, HashMap<String, JSONObject> r12) {
        f r1 = (f) ZeusTransformUtils.preCheckCast(this.f5988c.get("launch"), f.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
        return;
    L5:
        Cursor r3 = null;
        r3 = r11.rawQuery(a(3), null);     // Catch: Throwable -> L20
        boolean r13 = r3.moveToLast();     // Catch: Throwable -> L20
    L7:
        if (r13 == false) goto L15;
        r1.a(r3);     // Catch: Throwable -> L20
        JSONObject r14 = new JSONObject();     // Catch: Throwable -> L20
        this.f5986a.getAppLog().R().b(r1.f5991a, r1.f5994d, r14);     // Catch: Throwable -> L11
    L13:
        r12.put(r1.f5994d, r14);     // Catch: Throwable -> L20
        r13 = r3.moveToPrevious();     // Catch: Throwable -> L20
    L11:
        th = move-exception;
        i().c(5, "onSessionBatchEvent failed", new Object[]{th});     // Catch: Throwable -> L20
        this.f5986a.getAppLog().N().sendError("collectImpression onSessionBatchEvent failed", th);     // Catch: Throwable -> L20
        goto L13
    L15:
        if (r3 == null) goto L50;
        r3.close();     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        i().c(5, "close cursor failed", new Object[]{th});
        return;
    L50:
        return;
    L20:
        th = move-exception;
        i().c(5, "collect impression failed", new Object[]{th});     // Catch: Throwable -> L28
        this.f5986a.getAppLog().N().increaseStats(j.ag);     // Catch: Throwable -> L28
        this.f5986a.getAppLog().N().sendError("collectImpression failed", th);     // Catch: Throwable -> L28
        if (r3 == null) goto L52;
        r3.close();     // Catch: Throwable -> L25
        return;
    L25:
        th = move-exception;
        i().c(5, "close cursor failed", new Object[]{th});
        return;
    L52:
        return;
    L28:
        th = move-exception;
        if (r3 != null) goto L39;
    L34:
        throw th;
    L39:
        r3.close();     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        i().c(5, "close cursor failed", new Object[]{th});
        goto L34
    }

    private JSONArray a(String r3, HashMap<String, JSONObject> r4) {
        JSONObject r5 = (JSONObject) ZeusTransformUtils.preCheckCast(r4.remove(r3), JSONObject.class, "com.obric.aiagent.plugin");
        JSONArray r0 = null;
        if (r5 == null) goto L11;
        JSONArray r6 = r5.optJSONArray("item_impression");
        if (r6 != null) goto L7;
    L9:
        r0 = r6;
        goto L11
    L7:
        if (r6.length() != 0) goto L9;
    L11:
        if (com.bytedance.applog.util.h.a(this.f5986a.getAppLog().b()) == false) goto L14;
        if (r0 == null) goto L14;
        com.bytedance.applog.util.h.a(this.f5986a.getAppLog().b(), "item_impression", r0);
    L14:
        return r0;
    }

    private List<g> b(g r7) {
        ArrayList r0 = new ArrayList();
        if (this.f5986a.getAppLog().F() == true) goto L5;
    L10:
        r0.add(r7);
    L12:
        if (this.f5986a.getConfig().A() == false) goto L18;
        ArrayList r8 = new ArrayList();
        Iterator r1 = r0.iterator();
    L15:
        if (r1.hasNext() == false) goto L17;
        r8.addAll(((g) ZeusTransformUtils.preCheckCast(r1.next(), g.class, "com.obric.aiagent.plugin")).c(this.f5986a.getConfig().z()));
        goto L15
    L17:
        return r8;
    L18:
        return r0;
    L5:
        if (this.f5986a.getAppLog().G() == null) goto L10;
        Collection<g> r2 = r7.a(this.f5986a.getAppLog().G());
        if (r2 == null) goto L9;
        i().c(5, "Pack split to {} packs for data isolate: {}", new Object[]{Integer.valueOf(r2.size()), this.f5986a.getAppLog().G()});
        r0.addAll(r2);
        goto L12
    L9:
        r0.add(r7);
        goto L12
    }

    public long a(g r5) {
        long r0 = this.f5987b.getWritableDatabase().insert("pack", null, r5.b(null));
        if (r0 >= 0) goto L5;
        this.f5986a.getAppLog().N().increaseStats(j.aa);
    L5:
        return r0;
    }

    public void a(g r17, boolean r18, SQLiteDatabase r19, com.bytedance.applog.priority.b r20) {
        if (r19 == null) goto L37;
        SQLiteDatabase r11 = r19;
        boolean r12 = false;
    L9:
        if (r12 == true) goto L39;
    L11:
        Iterator<g> r1 = b(r17).iterator();     // Catch: Throwable -> L28
    L13:
        if (r1.hasNext() == false) goto L16;
        a(r11, (g) ZeusTransformUtils.preCheckCast(r1.next(), g.class, "com.obric.aiagent.plugin"), r18);     // Catch: Throwable -> L28
        goto L13
    L16:
        if (r17.y <= 0) goto L19;
        r11.execSQL(a("event", r17.f5994d, r18, r17.y, r20));     // Catch: Throwable -> L28
    L19:
        if (r17.A <= 0) goto L22;
        r11.execSQL(a("eventv3", r17.f5994d, r18, r17.A, r20));     // Catch: Throwable -> L28
    L22:
        if (r17.F <= 0) goto L24;
        r11.execSQL(a("event_misc", r17.f5994d, r18, r17.F, r20));     // Catch: Throwable -> L28
    L24:
        if (r12 == false) goto L26;
        r11.setTransactionSuccessful();     // Catch: Throwable -> L28
    L28:
        th = th;
    L41:
        i().c(5, "delete pack data failed", new Object[]{th});     // Catch: Throwable -> L33
        this.f5986a.getAppLog().N().increaseStats(j.G);     // Catch: Throwable -> L33
        this.f5986a.getAppLog().N().sendError("saveAndDeleteDataFromPack failed", th);     // Catch: Throwable -> L33
        if (r12 == false) goto L45;
    L27:
        p.a(r11);
        return;
    L45:
        return;
    L33:
        th = move-exception;
        if (r12 == false) goto L36;
        p.a(r11);
    L36:
        throw th;
    L26:
        if (r12 == true) goto L27;
        return;
    L39:
        r11.beginTransaction();     // Catch: Throwable -> L28
        goto L11
    L37:
        r11 = this.f5987b.getWritableDatabase();     // Catch: Throwable -> L6
        r12 = true;
    L6:
        th = th;
        r11 = r19;
        r12 = false;
        goto L41
    }

    private void a(g r8, SQLiteDatabase r9, int r10) {
        if (r9 == null) goto L35;
        boolean r2 = false;
    L9:
        if (r2 == true) goto L31;
    L11:
        Iterator<g> r3 = b(r8).iterator();     // Catch: Throwable -> L22
    L13:
        if (r3.hasNext() == false) goto L16;
        a(r9, (g) ZeusTransformUtils.preCheckCast(r3.next(), g.class, "com.obric.aiagent.plugin"), false);     // Catch: Throwable -> L22
        goto L13
    L16:
        if (r8.A <= 0) goto L18;
        r9.execSQL(a("eventv3", r8.A, r10));     // Catch: Throwable -> L22
    L18:
        if (r2 == false) goto L20;
        r9.setTransactionSuccessful();     // Catch: Throwable -> L22
    L22:
        th = th;
    L33:
        i().c(5, "delete pack data failed", new Object[]{th});     // Catch: Throwable -> L27
        this.f5986a.getAppLog().N().increaseStats(j.G);     // Catch: Throwable -> L27
        this.f5986a.getAppLog().N().sendError("saveAndDeleteDataFromPriorityPack " + r10 + " failed", th);     // Catch: Throwable -> L27
        if (r2 == false) goto L39;
    L21:
        p.a(r9);
        return;
    L39:
        return;
    L27:
        th = move-exception;
        if (r2 == false) goto L30;
        p.a(r9);
    L30:
        throw th;
    L20:
        if (r2 == true) goto L21;
        return;
    L31:
        r9.beginTransaction();     // Catch: Throwable -> L22
        goto L11
    L35:
        r9 = this.f5987b.getWritableDatabase();     // Catch: Throwable -> L6
        r2 = true;
    L6:
        th = th;
        r2 = false;
        goto L33
    }

    private void a(SQLiteDatabase r12, g r13, boolean r14) {
        if (r13.A() == false) goto L7;
        i().d(5, "no need insert to db for empty pack: {}, matchSid: {}", new Object[]{r13, Boolean.valueOf(r14)});
        return;
    L7:
        if (this.f5986a.getAppLog().N().isStageEnabled() == false) goto L12;
        Iterator<com.bytedance.applog.monitor.v3.h> r0 = r13.u().iterator();
    L10:
        if (r0.hasNext() == false) goto L12;
        com.bytedance.applog.monitor.c.a(this.f5986a.getAppLog().N(), com.bytedance.applog.monitor.v3.a.D, (com.bytedance.applog.monitor.v3.h) ZeusTransformUtils.preCheckCast(r0.next(), com.bytedance.applog.monitor.v3.h.class, "com.obric.aiagent.plugin"));
    L12:
        long r6 = r12.insert("pack", null, r13.b(null));
        if (r6 >= 0) goto L20;
        if (r13.B == null) goto L17;
        this.f5990e.remove(r13.B.f5994d);
    L17:
        r13.x();
        i().e(5, "insert to db failed, pack: {}, result: {}", new Object[]{r13, Long.valueOf(r6)});
        this.f5986a.getAppLog().N().increaseStats(j.aa);
        this.f5986a.getAppLog().N().sendError("pack insert failed for db id < 0", null);
        throw new SQLiteException("insert pack to db failed for result id < 0.");
    L20:
        if (this.f5986a.getAppLog().N().isStageEnabled() == false) goto L25;
        Iterator<com.bytedance.applog.monitor.v3.h> r1 = r13.u().iterator();
    L23:
        if (r1.hasNext() == false) goto L25;
        com.bytedance.applog.monitor.c.a(this.f5986a.getAppLog().N(), com.bytedance.applog.monitor.v3.a.F, (com.bytedance.applog.monitor.v3.h) ZeusTransformUtils.preCheckCast(r1.next(), com.bytedance.applog.monitor.v3.h.class, "com.obric.aiagent.plugin"));
    L25:
        r13.f5991a = r6;
        i().b(5, "pack: {} insert to db success!", new Object[]{r13, Long.valueOf(r6)});
        if (r13.D != null) goto L28;
        return;
    L28:
        if (r13.C != null) goto L30;
        return;
    L30:
        if (r13.C.length() <= 0) goto L37;
        r12.execSQL(b(r13.f5994d, r14));
        return;
    }

    private int a(int r19, SQLiteDatabase r20, String r21, boolean r22, JSONArray[] r23, long[] r24, com.bytedance.applog.priority.b r25, com.bytedance.applog.a.a r26) {
        int r0 = 0;
    L4:
        if (r0 >= r19) goto L7;
        r23[r0] = null;
        r24[r0] = 0;
        r0 = r0 + 1;
        goto L4
    L7:
        if (r26.a() == false) goto L9;
        int r1 = com.bytedance.applog.a.b.f5496b;
    L10:
        int r15 = r1;
        int r10 = r0;
        int r16 = r15;
    L11:
        if (r16 <= 0) goto L23;
        if (r10 >= this.f5989d.length) goto L23;
        int r17 = r10;
        a(r20, r21, r16, r10, r22, r23, r24, r25, r15, r26);
        if (r26.a() == true) goto L17;
    L19:
        r16 = r16 - r23[r17].length();
        if (r16 > 0) goto L21;
        r10 = r17;
        goto L11
    L21:
        r10 = r17 + 1;
        goto L11
    L17:
        if (r26.b() == false) goto L19;
    L24:
        int r11 = r17 + 1;
    L26:
        if (r11 >= r23.length) goto L28;
        r23[r11] = null;
        r24[r11] = 0;
        r11 = r11 + 1;
        goto L26
    L28:
        return r17;
    L23:
        r17 = r10;
        goto L24
    L9:
        r1 = 200;
        goto L10
    }

    private void a(SQLiteDatabase r15, String r16, int r17, int r18, boolean r19, JSONArray[] r20, long[] r21, com.bytedance.applog.priority.b r22, int r23, com.bytedance.applog.a.a r24) {
        a r8 = this.f5989d[r18];
        JSONArray r9 = new JSONArray();
        Cursor r11 = null;
        long r12 = 0;
        r11 = r15.rawQuery(a(r8, r16, r19, r17, r22), null);     // Catch: Throwable -> L26
        int r1 = 0;
    L5:
        if (r11.moveToNext() == false) goto L24;
        if (r1 > r23) goto L24;
        r8.a(r11);     // Catch: Throwable -> L26
        JSONObject r3 = r8.k();     // Catch: Throwable -> L26
        if (r24.a() == true) goto L11;
    L19:
        r9.put(r3);     // Catch: Throwable -> L26
        if (r8.f5991a <= r12) goto L23;
        r12 = r8.f5991a;     // Catch: Throwable -> L26
    L23:
        r1 = r1 + 1;
        goto L5
    L11:
        if (ZeusTransformUtils.instanceOf(r8, d.class) == false) goto L14;
        boolean r4 = r24.b(r3);     // Catch: Throwable -> L26
    L17:
        if (r4 == true) goto L19;
        r24.a(true);     // Catch: Throwable -> L26
        goto L24
    L14:
        if (ZeusTransformUtils.instanceOf(r8, b.class) == false) goto L16;
        r4 = r24.c(r3);     // Catch: Throwable -> L26
        goto L17
    L16:
        r4 = r24.d(r3);     // Catch: Throwable -> L26
    L24:
        if (r11 == null) goto L42;
    L25:
        r11.close();
    L42:
        r20[r18] = r9;
        r21[r18] = r12;
        return;
    L26:
        th = move-exception;
    L44:
        th = move-exception;
        if (r11 == null) goto L47;
        r11.close();
    L47:
        throw th;
    L28:
        if (ZeusTransformUtils.instanceOf(r8, d.class) == false) goto L31;
        this.f5986a.getAppLog().N().increaseStats(j.ab);     // Catch: Throwable -> L44
    L36:
        this.f5986a.getAppLog().N().sendError("queryEvent failed", th);     // Catch: Throwable -> L44
        if (ZeusTransformUtils.instanceOf(th, SQLiteBlobTooBigException.class) == false) goto L39;
        j();     // Catch: Throwable -> L44
    L39:
        i().a(5, "query event failed", th, new Object[0]);     // Catch: Throwable -> L44
        if (r11 == null) goto L42;
    L31:
        if (ZeusTransformUtils.instanceOf(r8, b.class) == false) goto L34;
        this.f5986a.getAppLog().N().increaseStats(j.ac);     // Catch: Throwable -> L44
        goto L36
    L34:
        if (ZeusTransformUtils.instanceOf(r8, c.class) == false) goto L36;
        this.f5986a.getAppLog().N().increaseStats(j.ad);     // Catch: Throwable -> L44
        goto L36
    }

    private void a(SQLiteDatabase r11, JSONArray[] r12, long[] r13, int r14) {
        a r0 = this.f5989d[1];
        JSONArray r2 = new JSONArray();
        Cursor r5 = null;
        long r6 = 0;
        r5 = r11.rawQuery(a(r0, 200, r14), null);     // Catch: Throwable -> L13
        int r15 = 0;
    L5:
        if (r5.moveToNext() == false) goto L11;
        if (r15 > 200) goto L11;
        r0.a(r5);     // Catch: Throwable -> L13
        r2.put(r0.k());     // Catch: Throwable -> L13
        if (r0.f5991a <= r6) goto L10;
        r6 = r0.f5991a;     // Catch: Throwable -> L13
    L10:
        r15 = r15 + 1;
    L11:
        if (r5 == null) goto L29;
    L12:
        r5.close();
    L29:
        r12[1] = r2;
        r13[1] = r6;
        return;
    L13:
        th = move-exception;
    L31:
        th = move-exception;
        if (r5 == null) goto L34;
        r5.close();
    L34:
        throw th;
    L15:
        if (ZeusTransformUtils.instanceOf(r0, d.class) == false) goto L18;
        this.f5986a.getAppLog().N().increaseStats(j.ab);     // Catch: Throwable -> L31
    L23:
        this.f5986a.getAppLog().N().sendError("queryEventByPriority failed", th);     // Catch: Throwable -> L31
        if (ZeusTransformUtils.instanceOf(th, SQLiteBlobTooBigException.class) == false) goto L26;
        j();     // Catch: Throwable -> L31
    L26:
        i().a(5, "query event failed", th, new Object[0]);     // Catch: Throwable -> L31
        if (r5 == null) goto L29;
    L18:
        if (ZeusTransformUtils.instanceOf(r0, b.class) == false) goto L21;
        this.f5986a.getAppLog().N().increaseStats(j.ac);     // Catch: Throwable -> L31
        goto L23
    L21:
        if (ZeusTransformUtils.instanceOf(r0, c.class) == false) goto L23;
        this.f5986a.getAppLog().N().increaseStats(j.ad);     // Catch: Throwable -> L31
        goto L23
    }

    private JSONArray a(f r22, boolean r23, i r24, h r25, SQLiteDatabase r26, com.bytedance.applog.priority.b r27, boolean r28) {
        JSONArray r6 = new JSONArray();
        if (r27 == null) goto L88;
        int r7 = r27.a();
        if (r7 != 0) goto L7;
    L9:
        return r6;
    L7:
        if ((-1) == r7) goto L88;
        if (r28 == false) goto L9;
    L88:
        Cursor r14 = r26.rawQuery(a(r22.f5994d, r23), null);     // Catch: Throwable -> L47
        HashMap r15 = new HashMap(8);     // Catch: Throwable -> L45
        String r13 = null;
        long r16 = 0;
        String r18 = null;
        String r19 = null;
    L84:
        if (r14.moveToNext() == false) goto L40;
        r25.a(r14);     // Catch: Throwable -> L43
        int r11 = 1;
        i().c(5, "queryPage: {}", new Object[]{r25});     // Catch: Throwable -> L43
        Integer r8 = (Integer) ZeusTransformUtils.preCheckCast(r15.get(r25.w), Integer.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L43
        if (r25.r() == false) goto L18;
        if (r8 != null) goto L34;
        r25.u = 1000;     // Catch: Throwable -> L43
        r16 = r16 + r25.u;     // Catch: Throwable -> L43
        r6.put(r25.k());     // Catch: Throwable -> L43
        goto L84
    L34:
        Integer r9 = Integer.valueOf(r8.intValue() - 1);     // Catch: Throwable -> L43
        if (r9.intValue() > 0) goto L36;
        r15.remove(r25.w);     // Catch: Throwable -> L43
        goto L84
    L36:
        r15.put(r25.w, r9);     // Catch: Throwable -> L43
        goto L84
    L18:
        String r10 = r25.w;     // Catch: Throwable -> L43
        if (r8 == null) goto L21;
        r11 = 1 + r8.intValue();     // Catch: Throwable -> L43
    L21:
        r15.put(r10, Integer.valueOf(r11));     // Catch: Throwable -> L43
        if (r25.u < 1000) goto L24;
        r16 = r16 + r25.u;     // Catch: Throwable -> L43
    L25:
        r6.put(r25.k());     // Catch: Throwable -> L43
        if (TextUtils.isEmpty(r25.y) == true) goto L32;
        String r12 = r25.y;     // Catch: Throwable -> L43
        r18 = r12;
        r19 = r25.g;     // Catch: Throwable -> L30
    L30:
        th = th;
        r18 = r12;
    L92:
        i().a(5, "query page failed", th, new Object[0]);     // Catch: Throwable -> L78
        this.f5986a.getAppLog().N().increaseStats(j.af);     // Catch: Throwable -> L78
        this.f5986a.getAppLog().N().sendError("query page failed", th);     // Catch: Throwable -> L78
        if (r14 != null) goto L41;
    L42:
        String r0 = r18;
        String r5 = r19;
        if (r6.length() > 0) goto L56;
    L77:
        return r6;
    L56:
        if (r16 <= 1000) goto L58;
        long r17 = r16;
    L59:
        r24.a();
        r24.a(this.f5986a.getAppLog().b());
        r24.u = r17;
        if (r23 == false) goto L62;
        r24.f5994d = r22.f5994d;
        r24.a(r22.f5992b);
    L63:
        this.f5986a.getSession().a(r24, r22.f5995e);
        r24.g = r22.g;
        r24.v = r24.f5992b + r17;
        r24.f5993c = this.f5986a.getSession().g();
        r24.w = null;
        if (TextUtils.isEmpty(r22.x) == true) goto L67;
        r24.w = r22.x;
    L69:
        r24.s = com.bytedance.applog.monitor.c.c(this.f5986a.getAppLog().N(), r24);
        r24.B = r13;
        this.f5986a.getAppLog().N().increaseStats(j.f5827d);
        if (r24.s <= 0) goto L90;
        com.bytedance.applog.monitor.c.a(this.f5986a.getAppLog().N(), com.bytedance.applog.monitor.v3.a.f5768b, r24);
    L90:
        this.f5986a.getAppLog().R().a(-1, r24.f5994d, r24.k());     // Catch: Throwable -> L74
    L76:
        l.a("event_receive", r24);
    L74:
        th = move-exception;
        i().a(5, "notify session terminate failed", th, new Object[0]);
        this.f5986a.getAppLog().N().sendError("notify onSessionTerminate failed", th);
        goto L76
    L67:
        if (TextUtils.isEmpty(r0) == true) goto L69;
        r24.w = r0;
        r24.g = r5;
        goto L69
    L62:
        r24.f5994d = UUID.randomUUID().toString();
        r24.a(0);
        goto L63
    L58:
        r17 = 1000;
    L41:
        r14.close();
    L78:
        th = move-exception;
        if (r14 == null) goto L81;
        r14.close();
    L81:
        throw th;
    L32:
        r13 = r25.z;     // Catch: Throwable -> L43
        goto L84
    L24:
        r16 = r16 + 1000;     // Catch: Throwable -> L43
        goto L25
    L40:
        if (r14 == null) goto L42;
    L43:
        th = th;
    L45:
        th = th;
        r13 = null;
    L49:
        r16 = 0;
        r18 = null;
        r19 = null;
    L47:
        th = th;
        r13 = null;
        r14 = null;
        goto L49
    }

    public ArrayList<g> a(int r6, com.bytedance.applog.priority.b r7) {
        g r1 = (g) ZeusTransformUtils.preCheckCast(this.f5988c.get("pack"), g.class, "com.obric.aiagent.plugin");
        Cursor r2 = null;
        r2 = this.f5987b.getWritableDatabase().rawQuery(b(r6, r7), null);     // Catch: Throwable -> L11
        ArrayList<g> r8 = new ArrayList();     // Catch: Throwable -> L11
    L5:
        if (r2.moveToNext() == false) goto L8;
        r1 = (g) ZeusTransformUtils.preCheckCast(r1.l(), g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L11
        r1.a(r2);     // Catch: Throwable -> L11
        r8.add(r1);     // Catch: Throwable -> L11
        goto L5
    L8:
        if (r2 == null) goto L10;
        r2.close();
    L10:
        return r8;
    L11:
        th = move-exception;
        boolean r9 = ZeusTransformUtils.instanceOf(th, SQLiteBlobTooBigException.class);     // Catch: Throwable -> L19
        i().a(5, "query pack failed", th, new Object[0]);     // Catch: Throwable -> L19
        this.f5986a.getAppLog().N().increaseStats(j.G);     // Catch: Throwable -> L19
        this.f5986a.getAppLog().N().sendError("query pack failed", th);     // Catch: Throwable -> L19
        if (r2 == null) goto L15;
        r2.close();
    L15:
        if (r9 == false) goto L18;
        j();
    L18:
        return new ArrayList();
    L19:
        th = move-exception;
        if (r2 == null) goto L22;
        r2.close();
    L22:
        throw th;
    }

    private void j() {
        Field r0 = CursorWindow.class.getDeclaredField("sCursorWindowSize");     // Catch: Throwable -> L8
        r0.setAccessible(true);     // Catch: Throwable -> L8
        int r2 = r0.getInt(null);     // Catch: Throwable -> L8
        if (r2 > 0) goto L5;
        return;
    L5:
        if (r2 > 8388608) goto L14;
        r0.setInt(null, r2 * 2);     // Catch: Throwable -> L8
        return;
    L14:
        return;
    L8:
        th = move-exception;
        i().a(5, "tryIncreaseCursorWindowSize", th, new Object[0]);
    }

    public void setResult(List<g> r17, List<g> r18) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.aiagent.plugin");
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.aiagent.plugin");
        i().c(5, "setResult: del -> {}, fail -> {}", new Object[]{r0, r3});
        Iterator r4 = r3.iterator();
        ArrayList r6 = new ArrayList();
        com.bytedance.applog.l.b r10 = this.f5986a.getAppLog().Y();
    L4:
        if (r4.hasNext() == false) goto L34;
        g r11 = (g) ZeusTransformUtils.preCheckCast(r4.next(), g.class, "com.obric.aiagent.plugin");
        long r12 = r10.b();
        if (r12 > 0) goto L8;
    L10:
        int r7 = r10.c();
        if (r7 < 0) goto L4;
        if (r11.v < r7) goto L4;
        r0.add(r11);
        r6.add(r11);
        r4.remove();
        goto L4
    L8:
        if (Math.abs(System.currentTimeMillis() - r11.f5992b) < r12) goto L10;
        r0.add(r11);
        r6.add(r11);
        r4.remove();
        goto L4
    L34:
        SQLiteDatabase r5 = this.f5987b.getWritableDatabase();     // Catch: Throwable -> L27
        Iterator r1 = r0.iterator();     // Catch: Throwable -> L27
    L18:
        if (r1.hasNext() == false) goto L22;
        g r8 = (g) ZeusTransformUtils.preCheckCast(r1.next(), g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L27
        int r9 = r5.delete("pack", "_id = ?", new String[]{String.valueOf(r8.f5991a)});     // Catch: Throwable -> L27
        if (r9 > 0) goto L18;
        i().e(5, "delete from db failed, pack: {}, rows: {}", new Object[]{r8, Integer.valueOf(r9)});     // Catch: Throwable -> L27
        this.f5986a.getAppLog().N().increaseStats(j.G);     // Catch: Throwable -> L27
        this.f5986a.getAppLog().ae().b("DB_DELETE_LOG_FAILED", "fail delete pack:" + r8.f5991a);     // Catch: Throwable -> L27
        this.f5986a.getAppLog().N().sendError("delete pack failed for zero", null);     // Catch: Throwable -> L27
        goto L18
    L22:
        Iterator r2 = r3.iterator();     // Catch: Throwable -> L27
    L23:
        if (r2.hasNext() == false) goto L29;
        g r13 = (g) ZeusTransformUtils.preCheckCast(r2.next(), g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L27
        long r14 = r13.f5991a;     // Catch: Throwable -> L27
        int r15 = r13.v + 1;     // Catch: Throwable -> L27
        r13.v = r15;     // Catch: Throwable -> L27
        r5.execSQL(a(r14, r15));     // Catch: Throwable -> L27
    L29:
        Iterator r16 = r6.iterator();
    L31:
        if (r16.hasNext() == false) goto L33;
        ((g) ZeusTransformUtils.preCheckCast(r16.next(), g.class, "com.obric.aiagent.plugin")).x();
        goto L31
    L33:
        return;
    L27:
        th = move-exception;
        i().a(5, "set result failed", th, new Object[0]);
        this.f5986a.getAppLog().N().increaseStats(j.G);
        this.f5986a.getAppLog().ae().a("DB_DELETE_LOG_ERROR", th);
        this.f5986a.getAppLog().N().sendError("handle pack send result failed", th);
        goto L29
    }

    public void a(ArrayList<a> r17) {
        ArrayList r3 = new ArrayList(4);
        ArrayList r4 = new ArrayList(4);
        ArrayList r5 = new ArrayList(4);
        SQLiteDatabase r0 = this.f5987b.getWritableDatabase();     // Catch: Throwable -> L61
        Iterator<a> r8 = r17.iterator();     // Catch: Throwable -> L61
        ContentValues r10 = null;
    L5:
        if (r8.hasNext() == false) goto L55;
        a r11 = (a) ZeusTransformUtils.preCheckCast(r8.next(), a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L61
        if (TextUtils.isEmpty(r11.m) == false) goto L10;
        r11.a(this.f5986a.getAppLog().b());     // Catch: Throwable -> L61
    L10:
        if (r11.s <= 0) goto L12;
        com.bytedance.applog.monitor.c.a(this.f5986a.getAppLog().N(), com.bytedance.applog.monitor.v3.a.y, r11);     // Catch: Throwable -> L61
    L12:
        String r12 = r11.h();     // Catch: Throwable -> L61
        r10 = r11.b(r10);     // Catch: Throwable -> L61
        r11.f5991a = r0.insert(r12, null, r10);     // Catch: Throwable -> L61
        if (r11.f5991a < 0) goto L15;
        boolean r13 = true;
    L17:
        if (r11.s <= 0) goto L23;
        MonitorV3Helper r14 = this.f5986a.getAppLog().N();     // Catch: Throwable -> L61
        if (r13 == false) goto L21;
        com.bytedance.applog.monitor.v3.a r15 = com.bytedance.applog.monitor.v3.a.A;     // Catch: Throwable -> L61
    L22:
        com.bytedance.applog.monitor.c.a(r14, r15, r11);     // Catch: Throwable -> L61
        goto L23
    L21:
        r15 = com.bytedance.applog.monitor.v3.a.z;     // Catch: Throwable -> L61
    L23:
        if (r13 == true) goto L26;
        this.f5986a.getAppLog().N().increaseStats(j.G);     // Catch: Throwable -> L61
    L26:
        if (ZeusTransformUtils.instanceOf(r11, b.class) == true) goto L27;
        if (ZeusTransformUtils.instanceOf(r11, d.class) == true) goto L32;
        if (ZeusTransformUtils.instanceOf(r11, c.class) == true) goto L37;
        if (ZeusTransformUtils.instanceOf(r11, f.class) == true) goto L42;
        if (ZeusTransformUtils.instanceOf(r11, i.class) == true) goto L47;
        if (ZeusTransformUtils.instanceOf(r11, h.class) == false) goto L5;
        if (r13 == true) goto L5;
        this.f5986a.getAppLog().N().increaseStats(j.Z);     // Catch: Throwable -> L61
        goto L5
    L47:
        r5.add((i) ZeusTransformUtils.preCheckCast(r11, i.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L61
        if (r13 == true) goto L5;
        this.f5986a.getAppLog().N().increaseStats(j.Y);     // Catch: Throwable -> L61
        goto L5
    L42:
        r3.add((f) ZeusTransformUtils.preCheckCast(r11, f.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L61
        if (r13 == true) goto L5;
        this.f5986a.getAppLog().N().increaseStats(j.Y);     // Catch: Throwable -> L61
        goto L5
    L37:
        r4.add(r11);     // Catch: Throwable -> L61
        if (r13 == true) goto L5;
        this.f5986a.getAppLog().N().increaseStats(j.X);     // Catch: Throwable -> L61
        goto L5
    L32:
        r4.add(r11);     // Catch: Throwable -> L61
        if (r13 == true) goto L5;
        this.f5986a.getAppLog().N().increaseStats(j.V);     // Catch: Throwable -> L61
        goto L5
    L27:
        r4.add(r11);     // Catch: Throwable -> L61
        if (r13 == true) goto L5;
        this.f5986a.getAppLog().N().increaseStats(j.W);     // Catch: Throwable -> L61
        goto L5
    L15:
        r13 = false;
        goto L17
    L55:
        if (l.a() == true) goto L63;
        Iterator<a> r1 = r17.iterator();     // Catch: Throwable -> L61
    L57:
        if (r1.hasNext() == false) goto L63;
        l.a("event_save_db", (a) ZeusTransformUtils.preCheckCast(r1.next(), a.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L61
    L63:
        a(r4);
        Iterator r2 = r3.iterator();     // Catch: Throwable -> L73
    L66:
        if (r2.hasNext() == false) goto L68;
        f r6 = (f) ZeusTransformUtils.preCheckCast(r2.next(), f.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L73
        this.f5986a.getAppLog().R().a(r6.f5991a, r6.f5994d);     // Catch: Throwable -> L73
        goto L66
    L68:
        Iterator r7 = r5.iterator();     // Catch: Throwable -> L73
    L69:
        if (r7.hasNext() == false) goto L115;
        i r9 = (i) ZeusTransformUtils.preCheckCast(r7.next(), i.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L73
        this.f5986a.getAppLog().R().a(r9.f5991a, r9.f5994d, r9.k());     // Catch: Throwable -> L73
        goto L69
    L115:
        return;
    L73:
        th = move-exception;
        i().a(5, "onSessionStart failed", th, new Object[0]);
        this.f5986a.getAppLog().N().sendError("notify onSessionStart or onSessionTerminate failed", th);
        return;
    L61:
        th = move-exception;
        i().a(5, "save db failed", th, new Object[0]);
        this.f5986a.getAppLog().N().increaseStats(j.G);
        this.f5986a.getAppLog().N().sendError("save base data list failed", th);
        goto L63
    }

    public void a(List<a> r15) {
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.aiagent.plugin");
        if (this.f5986a.getAppLog().S().a(0) == false) goto L5;
        return;
    L5:
        Iterator r17 = r16.iterator();
    L7:
        if (r17.hasNext() == false) goto L21;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r17.next(), a.class, "com.obric.aiagent.plugin");
        if ("event".equals(r0.h()) == true) goto L11;
        if ("eventv3".equals(r0.h()) == true) goto L14;
        if ("event_misc".equals(r0.h()) == false) goto L7;
        c r1 = (c) ZeusTransformUtils.preCheckCast(r0, c.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        this.f5986a.getAppLog().S().b(0, r1.r(), r1.n());     // Catch: Throwable -> L19
        goto L7
    L14:
        d r2 = (d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        this.f5986a.getAppLog().S().a(0, r2.s(), r2.n());     // Catch: Throwable -> L19
        goto L7
    L11:
        b r3 = (b) ZeusTransformUtils.preCheckCast(r0, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        this.f5986a.getAppLog().S().a(0, r3.u, r3.v, r3.w, r3.y, r3.z, r3.x);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        i().a(5, "notify event observer before store failed", th, new Object[0]);
        this.f5986a.getAppLog().N().sendError("notify event observer failed", th);
        goto L7
    }

    public void g() {
        SQLiteDatabase r1 = this.f5987b.getWritableDatabase();     // Catch: Throwable -> L12
        r1.beginTransaction();     // Catch: Throwable -> L10
        Iterator<a> r2 = this.f5988c.values().iterator();     // Catch: Throwable -> L10
    L6:
        if (r2.hasNext() == false) goto L8;
        r1.delete(((a) ZeusTransformUtils.preCheckCast(r2.next(), a.class, "com.obric.aiagent.plugin")).h(), null, null);     // Catch: Throwable -> L10
        goto L6
    L8:
        r1.setTransactionSuccessful();     // Catch: Throwable -> L10
    L9:
        p.a(r1);
        return;
    L10:
        Throwable th = th;
    L24:
        i().a(5, "clear tables failed", th, new Object[0]);     // Catch: Throwable -> L17
        this.f5986a.getAppLog().N().increaseStats(j.G);     // Catch: Throwable -> L17
        this.f5986a.getAppLog().N().sendError("clearAllTables failed", th);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        p.a(r1);
        throw th;
    L12:
        th = move-exception;
        r1 = null;
        th = th;
        goto L24
    }

    public void b(List<e> r7) {
        Iterator r8 = ((List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin")).iterator();
        long r2 = 0;
    L4:
        if (r8.hasNext() == false) goto L14;
        e r0 = (e) ZeusTransformUtils.preCheckCast(r8.next(), e.class, "com.obric.aiagent.plugin");
        if (r0.f5991a <= r2) goto L4;
        r2 = r0.f5991a;
        goto L4
    L14:
        this.f5987b.getWritableDatabase().delete("forward_eventv3", "_id <= ?", new String[]{String.valueOf(r2)});     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        i().a(5, "delete forward events failed", th, new Object[0]);
        this.f5986a.getAppLog().N().sendError("deleteForwardEvents failed", th);
    }

    public void h() {
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        Cursor r1 = null;
        SQLiteDatabase r2 = this.f5987b.getReadableDatabase();     // Catch: Throwable -> L25
        Iterator r3 = Arrays.asList(new String[]{"event", "eventv3", "event_misc"}).iterator();     // Catch: Throwable -> L25
        Cursor r4 = null;
    L35:
    L23:
        Throwable th = th;
    L39:
        i().a(5, "count all events failed", th, new Object[0]);     // Catch: Throwable -> L30
        this.f5986a.getAppLog().N().sendError("readPiledUpEventCount failed", th);     // Catch: Throwable -> L30
        p.a(r4);
        return;
    L30:
        th = move-exception;
        p.a(r4);
        throw th;
    L6:
        if (r3.hasNext() == false) goto L15;
        r4 = r2.rawQuery("select count(1) from " + ((String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.aiagent.plugin")), null);     // Catch: Throwable -> L14
        if (r4 == null) goto L35;
        if (r4.moveToFirst() == false) goto L35;
        this.f += r4.getInt(0);     // Catch: Throwable -> L14
    L14:
        p.a(r4);     // Catch: Throwable -> L23
        goto L35
    L15:
        r1 = r2.rawQuery("select _launch_count, _terminate_count, _event_v1_count, _event_v3_count, _event_misc_count, _impression_count from pack", null);     // Catch: Throwable -> L23
        if (r1 == null) goto L22;
        this.i = r1.getCount();     // Catch: Throwable -> L25
    L19:
        if (r1.moveToNext() == false) goto L22;
        this.g += r1.getInt(0);     // Catch: Throwable -> L25
        this.h += r1.getInt(1);     // Catch: Throwable -> L25
        int r5 = this.f + r1.getInt(2);     // Catch: Throwable -> L25
        this.f = r5;     // Catch: Throwable -> L25
        int r6 = r5 + r1.getInt(3);     // Catch: Throwable -> L25
        this.f = r6;     // Catch: Throwable -> L25
        this.f = r6 + r1.getInt(4);     // Catch: Throwable -> L25
    L22:
        p.a(r1);
        return;
    L25:
        th = move-exception;
        r4 = r1;
        th = th;
        goto L39
    }
}
