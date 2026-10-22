package com.bytedance.android.anniex.scene.data;

import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import androidx.camera.video.AudioStats;
import com.bytedance.android.anniex.scene.connect.SceneConnectCenter;
import com.bytedance.android.anniex.scene.core.SceneManager;
import com.bytedance.android.anniex.scene.core.UrlUsageTracker;
import com.bytedance.android.anniex.scene.core.j;
import com.bytedance.android.anniex.scene.settings.SwitchCenter;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.core.h;
import com.ss.android.lark.inv.export.router.InvRouter;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class SceneDbManager {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final a f41158r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static volatile SceneDbManager f41159s;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.anniex.scene.data.a f41160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReentrantLock f41161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f41162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f41163d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f41164e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<Triple<String, String, Long>> f41165f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f41166g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f41167h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f41168i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f41169j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f41170k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final SceneDbManager$sceneCountMap$1 f41171l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f41172m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f41173n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f41174o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final double f41175p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final TimeUnit f41176q;

    public static final class a {
        public a() {
        }

        public final SceneDbManager a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            SceneDbManager r101 = SceneDbManager.f41159s;
            if (r101 != null) goto L13;
            monitor-enter(this);
            r101 = SceneDbManager.f41159s;     // Catch: Throwable -> L10
            if (r101 != null) goto L8;
            r101 = new SceneDbManager(r100);     // Catch: Throwable -> L10
            SceneDbManager.f41159s = r101;     // Catch: Throwable -> L10
        L8:
            monitor-exit(this);
        L10:
            th = move-exception;
            throw th;
        L13:
            return r101;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f41177a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f41178b;

        public b() {
            this(0, 0);
        }

        public b(int r100, int r101) {
            this.f41177a = r100;
            this.f41178b = r101;
        }
    }

    static {
        f41158r = new a();
    }

    public final SQLiteDatabase f() {
        return (SQLiteDatabase) this.f41172m.getValue();
    }

    public final void c() {
        long r100 = System.currentTimeMillis();
        Cursor r101 = f().rawQuery("SELECT COUNT(*) FROM url_records_table", null);
        if (r101.moveToFirst() == false) goto L7;
        int r102 = r101.getInt(0);
        HybridLogger r103 = HybridLogger.f246343a;
        UrlUsageTracker r104 = UrlUsageTracker.f41107n;
        StringBuilder r105 = new StringBuilder("cleanupIfNecessary total:");
        r105.append(r102);
        r105.append(", maxSize:");
        Lazy r106 = SwitchCenter.E;
        r105.append(((Number) r106.getValue()).longValue());
        HybridLogger.f("UrlUsageTracker", r105.toString(), null, 12);
        long r107 = r102;
        if (r107 <= ((Number) r106.getValue()).longValue()) goto L7;
        long r108 = r107 - ((Number) r106.getValue()).longValue();
        f().execSQL("\n                    DELETE FROM url_records_table WHERE count IN (\n                        SELECT count FROM url_records_table\n                        ORDER BY count ASC LIMIT " + r108 + "\n                    )\n                    ");
        StringBuilder r109 = new StringBuilder("cleanupIfNecessary 使用策略：count，删除记录数：");
        r109.append(r108);
        HybridLogger.f("UrlUsageTracker", r109.toString(), null, 12);
    L7:
        r101.close();
        HybridLogger r110 = HybridLogger.f246343a;
        UrlUsageTracker r111 = UrlUsageTracker.f41107n;
        HybridLogger.f("UrlUsageTracker", "cleanupIfNecessary 数据清理结束 耗时：" + (System.currentTimeMillis() - r100), null, 12);
    }

    public SceneDbManager(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        com.bytedance.android.anniex.scene.data.a.C0762a r101 = com.bytedance.android.anniex.scene.data.a.f41179a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        com.bytedance.android.anniex.scene.data.a r102 = com.bytedance.android.anniex.scene.data.a.f41180b;
        if (r102 != null) goto L13;
        monitor-enter(r101);
        r102 = com.bytedance.android.anniex.scene.data.a.f41180b;     // Catch: Throwable -> L10
        if (r102 != null) goto L8;
        r102 = new com.bytedance.android.anniex.scene.data.a(r100);     // Catch: Throwable -> L10
        com.bytedance.android.anniex.scene.data.a.f41180b = r102;     // Catch: Throwable -> L10
    L8:
        monitor-exit(r101);
    L10:
        th = move-exception;
        throw th;
    L13:
        this.f41160a = r102;
        this.f41161b = new ReentrantLock();
        this.f41162c = ((Number) SwitchCenter.f41328q.getValue()).intValue();
        this.f41163d = ((Number) SwitchCenter.f41329r.getValue()).intValue();
        this.f41164e = ((Number) SwitchCenter.f41330s.getValue()).longValue();
        this.f41165f = new ArrayList();
        this.f41167h = ((Number) SwitchCenter.f41331t.getValue()).intValue();
        this.f41168i = ((Number) SwitchCenter.f41332u.getValue()).intValue();
        this.f41169j = ((Number) SwitchCenter.f41333v.getValue()).intValue();
        int r103 = ((Number) SwitchCenter.f41320m.getValue()).intValue();
        this.f41170k = r103;
        this.f41171l = new SceneDbManager$sceneCountMap$1(this, r103);
        this.f41172m = LazyKt.lazy(new SceneDbManager$db$2(this));
        this.f41174o = ((Number) SwitchCenter.C.getValue()).intValue();
        this.f41175p = ((Number) SwitchCenter.D.getValue()).doubleValue();
        this.f41176q = TimeUnit.DAYS;
    }

    public static void i(SQLiteDatabase r100) {
        Application r101 = h.f246501h.f246503b;
        if (r101 == null) goto L6;
        final long r102 = r101.getDatabasePath("scene_recognition.db").length();
        final long r103 = r102 / ((long) 1024);
        final int r104 = g(r100, InvRouter.SCENES);
        final int r105 = g(r100, "transitions");
        SceneConnectCenter.f(r104, r105, g(r100, "url_records_table"), (int) r103);
        int r106 = za.b.f571085a;
        SceneManager r107 = SceneManager.f41088n;
        za.b.a("AnnieXSceneManager", new SceneDbManager$reportSqliteStatus$1$1(r103, r102, r104, r105));
        return;
    }

    public final boolean a(SQLiteDatabase r100) {
        r100.execSQL("DELETE FROM scenes WHERE timestamp < ?", new Long[]{Long.valueOf(System.currentTimeMillis() - this.f41164e)});
        Cursor r101 = r100.rawQuery("SELECT COUNT(*) FROM scenes", null);
        Cursor r102 = r101;     // Catch: Throwable -> L13
        if (r102.moveToFirst() == true) goto L6;
    L10:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L13
        CloseableKt.closeFinally(r101, null);
        return false;
    L6:
        if (r102.getInt(0) <= this.f41162c) goto L10;
        r100.execSQL(StringsKt.trimIndent("\n                    DELETE FROM scenes\n                    WHERE scene_id IN (\n                        SELECT scene_id\n                        FROM scenes\n                        ORDER BY timestamp ASC\n                        LIMIT " + (r102.getInt(0) - this.f41162c) + "\n                    )\n                "));     // Catch: Throwable -> L13
        int r104 = za.b.f571085a;     // Catch: Throwable -> L13
        SceneManager r105 = SceneManager.f41088n;     // Catch: Throwable -> L13
        SceneDbManager$autoCleanScenes$1$1 r106 = SceneDbManager$autoCleanScenes$1$1.INSTANCE;     // Catch: Throwable -> L13
        Intrinsics.checkNotNullParameter("AnnieXSceneManager", "tag");     // Catch: Throwable -> L13
        Intrinsics.checkNotNullParameter(r106, "message");     // Catch: Throwable -> L13
        za.b.b(5, "AnnieXSceneManager", r106);     // Catch: Throwable -> L13
        CloseableKt.closeFinally(r101, null);
        return true;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        CloseableKt.closeFinally(r101, th);
        throw th;
    }

    public final boolean b(SQLiteDatabase r100) {
        r100.execSQL("DELETE FROM transitions WHERE last_update < ?", new Long[]{Long.valueOf(System.currentTimeMillis() - this.f41164e)});
        Cursor r101 = r100.rawQuery("SELECT COUNT(*) FROM transitions", null);
        Cursor r102 = r101;     // Catch: Throwable -> L13
        if (r102.moveToFirst() == true) goto L6;
    L10:
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L13
        CloseableKt.closeFinally(r101, null);
        return false;
    L6:
        if (r102.getInt(0) <= this.f41163d) goto L10;
        r100.execSQL(StringsKt.trimIndent("\n                    DELETE FROM transitions\n                    WHERE rowid IN (\n                        SELECT rowid FROM transitions\n                        ORDER BY last_update ASC\n                        LIMIT " + (r102.getInt(0) - this.f41163d) + "\n                    )\n                "));     // Catch: Throwable -> L13
        int r104 = za.b.f571085a;     // Catch: Throwable -> L13
        SceneManager r105 = SceneManager.f41088n;     // Catch: Throwable -> L13
        za.b.a("AnnieXSceneManager", SceneDbManager$autoCleanTransitions$1$1.INSTANCE);     // Catch: Throwable -> L13
        CloseableKt.closeFinally(r101, null);
        return true;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        CloseableKt.closeFinally(r101, th);
        throw th;
    }

    public final void e(SQLiteDatabase r110) {
        Iterator r100 = ((ArrayList) this.f41165f).iterator();
    L4:
        if (r100.hasNext() == false) goto L21;
        Triple r101 = (Triple) r100.next();
        String r102 = (String) r101.component1();
        String r103 = (String) r101.component2();
        long r104 = ((Number) r101.component3()).longValue();
        long r105 = System.currentTimeMillis();
        int r111 = 0;
        Cursor r106 = r110.rawQuery(StringsKt.trimIndent("\n            SELECT count, avg_duration\n            FROM transitions\n            WHERE from_scene_id = ? AND to_scene_id = ?\n            "), new String[]{r102, r103});
        Cursor r112 = r106;     // Catch: Throwable -> L15
        if (r112.moveToFirst() == false) goto L9;
        r111 = r112.getInt(0);     // Catch: Throwable -> L15
        long r113 = r112.getLong(1);     // Catch: Throwable -> L15
    L10:
        Unit r114 = Unit.INSTANCE;     // Catch: Throwable -> L15
        CloseableKt.closeFinally(r106, null);
        if (r111 > 0) goto L13;
        SQLiteStatement r107 = r110.compileStatement(StringsKt.trimIndent("\n                INSERT INTO transitions\n                (from_scene_id, to_scene_id,\n                 count, last_update,\n                 avg_duration)\n                VALUES (?, ?, 1, ?, ?)\n                "));
        r107.bindString(1, r102);
        r107.bindString(2, r103);
        r107.bindLong(3, r105);
        r107.bindLong(4, r104);
        r107.executeInsert();
        r107.close();
        goto L4
    L13:
        long r115 = (r113 * ((long) r111)) + r104;
        long r108 = r111 + 1;
        SQLiteStatement r109 = r110.compileStatement(StringsKt.trimIndent("\n                UPDATE transitions SET\n                    count = ?,\n                    last_update = ?,\n                    avg_duration = ?\n                WHERE from_scene_id = ? AND to_scene_id = ?\n                "));
        r109.bindLong(1, r108);
        r109.bindLong(2, r105);
        r109.bindLong(3, r115 / r108);
        r109.bindString(4, r102);
        r109.bindString(5, r103);
        r109.executeUpdateDelete();
        r109.close();
        goto L4
    L9:
        r113 = 0;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        CloseableKt.closeFinally(r106, th);
        throw th;
    L21:
        ((ArrayList) this.f41165f).clear();
    }

    public final Triple<List<c>, Double, Double> h(long r210) {
        int[] r110 = {0, 1};
        ArrayList r111 = new ArrayList();
        Cursor r100 = f().rawQuery("SELECT count FROM url_records_table", null);     // Catch: Exception -> L35
        double r112 = AudioStats.AUDIO_AMPLITUDE_NONE;
    L5:
        if (r100.moveToNext() == false) goto L7;
        r112 = r112 + r100.getDouble(0);     // Catch: Exception -> L35
        goto L5
    L7:
        r100.close();     // Catch: Exception -> L35
        StringBuilder r101 = new StringBuilder();     // Catch: Exception -> L35
        r101.append(StringsKt.trimIndent("\n                SELECT url,\n                       count,\n                       last_visit_ts,\n                       status\n                FROM url_records_table\n            "));     // Catch: Exception -> L35
        r101.append(" WHERE status IN (" + ArraysKt.joinToString$default(r110, ",", null, null, 0, null, SceneDbManager$queryTopUrlsByOrderColumn$selectionArgs$placeholders$1.INSTANCE, 30, null) + ')');     // Catch: Exception -> L35
        ArrayList r102 = new ArrayList(2);     // Catch: Exception -> L35
        int r113 = 0;
    L8:
        if (r113 >= 2) goto L10;
        r102.add(String.valueOf(r110[r113]));     // Catch: Exception -> L35
        r113 = r113 + 1;     // Catch: Exception -> L35
        goto L8
    L10:
        Object[] r103 = r102.toArray(new String[0]);     // Catch: Exception -> L35
        if (r103 == null) goto L34;
        r101.append(" ORDER BY count DESC");     // Catch: Exception -> L35
        Cursor r104 = f().rawQuery(r101.toString(), (String[]) r103);     // Catch: Exception -> L35
        double r105 = AudioStats.AUDIO_AMPLITUDE_NONE;
        double r106 = AudioStats.AUDIO_AMPLITUDE_NONE;
        int r114 = 0;
    L14:
        if (r104.moveToNext() == false) goto L24;
        double r107 = r104.getDouble(1);     // Catch: Exception -> L35
        int r108 = r104.getInt(3);     // Catch: Exception -> L35
        r105 = r105 + r107;     // Catch: Exception -> L35
        if (((Boolean) SwitchCenter.S.getValue()).booleanValue() == false) goto L18;
        if (r108 != 0) goto L14;
    L18:
        r114 = r114 + 1;     // Catch: Exception -> L35
        if (r114 > r210) goto L24;
        r111.add(new c(r104.getString(0), r107, r104.getLong(2)));     // Catch: Exception -> L35
        if (r108 != 0) goto L14;
        r106 = r106 + r107;     // Catch: Exception -> L35
    L24:
        r104.close();     // Catch: Exception -> L35
        double r109 = 0;
        if (r112 <= r109) goto L27;
        double r115 = r105 / r112;     // Catch: Exception -> L35
    L29:
        if (r106 <= r109) goto L31;
        double r116 = r106 / r112;     // Catch: Exception -> L35
    L48:
        return new Triple(r111, Double.valueOf(r115), Double.valueOf(r116));
    L31:
        r116 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L48
    L27:
        r115 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L29
    L34:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");     // Catch: Exception -> L35
    L35:
        e = move-exception;
        HybridLogger r117 = HybridLogger.f246343a;
        UrlUsageTracker r118 = UrlUsageTracker.f41107n;
        HybridLogger.i("UrlUsageTracker", "queryTopUrlsByTemplateTotalSize 查询（排序字段：count）异常：" + e.getMessage(), null, 12);
        r111.clear();
        return new Triple(r111, Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE), Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE));
    }

    public static int g(SQLiteDatabase r100, String r101) {
        Cursor r102 = r100.rawQuery("SELECT COUNT(*) FROM ".concat(r101), null);
        Cursor r103 = r102;     // Catch: Throwable -> L8
        int r104 = 0;
        if (r103.moveToFirst() == false) goto L6;
        r104 = r103.getInt(0);     // Catch: Throwable -> L8
    L6:
        CloseableKt.closeFinally(r102, null);
        return r104;
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        CloseableKt.closeFinally(r102, th);
        throw th;
    }

    public final synchronized void d(j r110, Map<String, UrlUsageTracker.a> r111) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r110, "scoreModel");     // Catch: Throwable -> L37
        Intrinsics.checkNotNullParameter(r111, "cacheMap");     // Catch: Throwable -> L37
        long r100 = System.currentTimeMillis();     // Catch: Throwable -> L37
        f().beginTransaction();     // Catch: Throwable -> L37
        HybridLogger r101 = HybridLogger.f246343a;     // Catch: Throwable -> L27 Exception -> L29
        UrlUsageTracker r102 = UrlUsageTracker.f41107n;     // Catch: Throwable -> L27 Exception -> L29
        HybridLogger.f("UrlUsageTracker", "flushBatch 数据入库, cacheMap size:" + r111.size(), null, 12);     // Catch: Throwable -> L27 Exception -> L29
        int r103 = 1;
        int r104 = this.f41173n + 1;     // Catch: Throwable -> L27 Exception -> L29
        this.f41173n = r104;     // Catch: Throwable -> L27 Exception -> L29
        if ((r104 % this.f41174o) != 0) goto L9;
        c();     // Catch: Throwable -> L27 Exception -> L29
    L9:
        ArrayList r105 = new ArrayList();     // Catch: Throwable -> L27 Exception -> L29
        Iterator<Map.Entry<String, UrlUsageTracker.a>> r106 = r111.entrySet().iterator();     // Catch: Throwable -> L27 Exception -> L29
    L11:
        if (r106.hasNext() == false) goto L24;
        Map.Entry<String, UrlUsageTracker.a> r107 = r106.next();     // Catch: Throwable -> L27 Exception -> L29
        String r108 = r107.getKey();     // Catch: Throwable -> L27 Exception -> L29
        UrlUsageTracker.a r109 = r107.getValue();     // Catch: Throwable -> L27 Exception -> L29
        String r112 = r109.f41123c;     // Catch: Throwable -> L27 Exception -> L29
        if (r112 != null) goto L15;
        r112 = za.c.a(r108);     // Catch: Throwable -> L27 Exception -> L29
    L15:
        if (r112 == null) goto L17;
        double r113 = r109.f41121a;     // Catch: Throwable -> L27 Exception -> L29
        SQLiteDatabase r114 = f();     // Catch: Throwable -> L27 Exception -> L29
        String[] r115 = new String[r103];     // Catch: Throwable -> L27 Exception -> L29
        r115[0] = r112;     // Catch: Throwable -> L27 Exception -> L29
        Cursor r116 = r114.rawQuery("SELECT count, last_visit_ts FROM url_records_table WHERE url=?", r115);     // Catch: Throwable -> L27 Exception -> L29
        if (r116.moveToFirst() == false) goto L23;
        r113 = r113 + (r116.getDouble(0) * Math.exp((-this.f41175p) * this.f41176q.convert(r100 - r116.getLong(r103), TimeUnit.MILLISECONDS)));     // Catch: Throwable -> L27 Exception -> L29
    L23:
        r116.close();     // Catch: Throwable -> L27 Exception -> L29
        ContentValues r117 = new ContentValues();     // Catch: Throwable -> L27 Exception -> L29
        r117.put("url", r112);     // Catch: Throwable -> L27 Exception -> L29
        r117.put("count", Double.valueOf(r113));     // Catch: Throwable -> L27 Exception -> L29
        r117.put("status", Integer.valueOf(r109.f41124d));     // Catch: Throwable -> L27 Exception -> L29
        r117.put("last_visit_ts", Long.valueOf(r100));     // Catch: Throwable -> L27 Exception -> L29
        f().insertWithOnConflict("url_records_table", null, r117, 5);     // Catch: Throwable -> L27 Exception -> L29
        r106 = r106;
        r103 = 1;
        goto L11
    L17:
        if (SwitchCenter.c() == false) goto L11;
        r105.add(r108);     // Catch: Throwable -> L27 Exception -> L29
        goto L11
    L24:
        f().setTransactionSuccessful();     // Catch: Throwable -> L27 Exception -> L29
        SceneConnectCenter.b(r105);     // Catch: Throwable -> L27 Exception -> L29
        HybridLogger r118 = HybridLogger.f246343a;     // Catch: Throwable -> L27 Exception -> L29
        UrlUsageTracker r119 = UrlUsageTracker.f41107n;     // Catch: Throwable -> L27 Exception -> L29
        HybridLogger.f("UrlUsageTracker", "flushBatch 数据入库完毕，耗时:" + (System.currentTimeMillis() - r100), null, 12);     // Catch: Throwable -> L27 Exception -> L29
    L32:
        f().endTransaction();     // Catch: Throwable -> L37
        monitor-exit(this);
        return;
    L29:
        e = move-exception;
        HybridLogger r120 = HybridLogger.f246343a;     // Catch: Throwable -> L27
        UrlUsageTracker r121 = UrlUsageTracker.f41107n;     // Catch: Throwable -> L27
        HybridLogger.i("UrlUsageTracker", "flushBatch 数据入库异常：" + e.getMessage(), null, 12);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        f().endTransaction();     // Catch: Throwable -> L37
        throw th;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 29, insn: 0x01e4: MOVE (r2 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r29 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) (LINE:50332132), block:B:100:0x01e4 */
    /* JADX WARN: Type inference failed for: r23v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4, types: [double] */
    public final synchronized com.bytedance.android.anniex.scene.data.b j(final com.bytedance.android.anniex.scene.core.h r210, final com.bytedance.android.anniex.scene.core.h r211, long r212) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r210, "scene");     // Catch: Throwable -> L125
        int r100 = za.b.f571085a;     // Catch: Throwable -> L125
        SceneManager r101 = SceneManager.f41088n;     // Catch: Throwable -> L125
        za.b.a("AnnieXSceneManager", new SceneDbManager$saveSceneAndGetStats$1(r210));     // Catch: Throwable -> L125
        long r102 = System.currentTimeMillis();     // Catch: Throwable -> L125
        LinkedHashMap r110 = new LinkedHashMap();     // Catch: Throwable -> L125
        ReentrantLock r103 = this.f41161b;     // Catch: Throwable -> L125
        r103.lock();     // Catch: Throwable -> L125
        SQLiteDatabase r104 = f();     // Catch: Throwable -> L122
        r104.beginTransaction();     // Catch: Throwable -> L122
        int r105 = 0;
        this.f41160a.b(r210);     // Catch: Throwable -> L107 Exception -> L109
        if (r211 == null) goto L18;
        ((ArrayList) this.f41165f).add(new Triple(r211.f41140a, r210.f41140a, Long.valueOf(r212)));     // Catch: Exception -> L15 Throwable -> L107
        Integer r106 = r211.f41150k;     // Catch: Exception -> L15 Throwable -> L107
        if (r106 == null) goto L18;
        if (r106.intValue() <= 0) goto L18;
        za.b.a("AnnieXSceneManager", new SceneDbManager$saveSceneAndGetStats$2$1$1(r210, r211));     // Catch: Exception -> L15 Throwable -> L107
        this.f41160a.b(r211);     // Catch: Exception -> L15 Throwable -> L107
    L15:
        e = e;
        int r107 = 0;
    L50:
        r102 = r102;
    L106:
        ?? r108 = 0;
    L111:
        Lazy r109 = SceneConnectCenter.f41082a;     // Catch: Throwable -> L107
        String r111 = e.getMessage();     // Catch: Throwable -> L107
        if (r111 != null) goto L114;
        r111 = "";
    L114:
        SceneConnectCenter.e(r111);     // Catch: Throwable -> L107
        f().endTransaction();     // Catch: Throwable -> L122
        ?? r213 = r108;
        int r112 = r107;
        int r113 = r105;
        ?? r114 = r213;
    L116:
        Unit r115 = Unit.INSTANCE;     // Catch: Throwable -> L122
        r103.unlock();     // Catch: Throwable -> L125
        int r116 = za.b.f571085a;     // Catch: Throwable -> L125
        SceneManager r117 = SceneManager.f41088n;     // Catch: Throwable -> L125
        final long r118 = r102;
        za.b.a("AnnieXSceneManager", new SceneDbManager$saveSceneAndGetStats$3(r118));     // Catch: Throwable -> L125
        com.bytedance.android.anniex.scene.data.b r119 = new com.bytedance.android.anniex.scene.data.b(r112, r113, r114, r110);     // Catch: Throwable -> L125
        monitor-exit(this);
        return r119;
    L18:
        int r120 = 1;
        if (this.f41171l.containsKey(r210.f41140a) == false) goto L51;
        b r121 = (b) this.f41171l.get(r210.f41140a);     // Catch: Exception -> L15 Throwable -> L107
        if (r121 == null) goto L24;
        int r122 = r121.f41177a;     // Catch: Exception -> L15 Throwable -> L107
    L25:
        r107 = r122 + 1;
        b r123 = (b) this.f41171l.get(r210.f41140a);     // Catch: Exception -> L47 Throwable -> L107
        if (r123 == null) goto L29;
        int r124 = r123.f41178b;     // Catch: Exception -> L47 Throwable -> L107
    L30:
        Integer r125 = r210.f41150k;     // Catch: Exception -> L47 Throwable -> L107
        if (r125 == null) goto L34;
        int r126 = r125.intValue();     // Catch: Exception -> L47 Throwable -> L107
    L35:
        int r127 = r124 + r126;
        b r128 = (b) this.f41171l.get(r210.f41140a);     // Catch: Exception -> L45 Throwable -> L107
        if (r128 == null) goto L40;
        r128.f41177a = r107;     // Catch: Exception -> L45 Throwable -> L107
    L40:
        b r129 = (b) this.f41171l.get(r210.f41140a);     // Catch: Exception -> L45 Throwable -> L107
        if (r129 == null) goto L144;
        r129.f41178b = r127;     // Catch: Exception -> L45 Throwable -> L107
    L144:
        SQLiteDatabase r130 = f();     // Catch: Exception -> L101 Throwable -> L107
        String r131 = StringsKt.trimIndent("\n                        SELECT to_scene_id,\n                         count,\n                         avg_duration, -- 新增字段\n                         (SELECT SUM(count)\n                         FROM transitions\n                         WHERE from_scene_id = ?) as total\n                         FROM transitions\n                         WHERE from_scene_id = ?\n                     ");     // Catch: Exception -> L101 Throwable -> L107
        int r132 = 2;
        String r133 = r210.f41140a;     // Catch: Exception -> L101 Throwable -> L107
        Cursor r134 = r130.rawQuery(r131, new String[]{r133, r133});     // Catch: Exception -> L101 Throwable -> L107
        Cursor r135 = r134;     // Catch: Throwable -> L92
        double r136 = AudioStats.AUDIO_AMPLITUDE_NONE;
        double r137 = AudioStats.AUDIO_AMPLITUDE_NONE;
    L131:
    L67:
        th = th;
    L91:
        Throwable r138 = th;
    L148:
        throw r138;     // Catch: Throwable -> L95
    L95:
        th = move-exception;
        CloseableKt.closeFinally(r134, r138);     // Catch: Exception -> L99 Throwable -> L107
        throw th;     // Catch: Exception -> L99 Throwable -> L107
    L58:
        if (r135.moveToNext() == false) goto L69;
        String r139 = r135.getString(r105);     // Catch: Throwable -> L67
        int r140 = r135.getInt(r120);     // Catch: Throwable -> L67
        long r141 = r135.getLong(r132);     // Catch: Throwable -> L67
        int r142 = r135.getInt(3);     // Catch: Throwable -> L67
        if (r142 <= 0) goto L62;
        double r143 = ((double) r140) / ((double) r142);
    L128:
        r110.put(r139, TuplesKt.to(Integer.valueOf(r140), Double.valueOf(r143)));     // Catch: Throwable -> L65
        r137 = r137 + (r141 * r143);
        r136 = r136 + r143;
        r107 = r107;
        r102 = r102;
        r105 = 0;
        r120 = 1;
        r132 = 2;
    L65:
        th = th;
        goto L91
    L62:
        r143 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L128
    L69:
        int r214 = r107;
        r102 = r102;
        double r144 = r136;
        if (r144 <= 0) goto L72;
        r137 = r137 / r144;
    L72:
        double r145 = r137;
        Unit r146 = Unit.INSTANCE;     // Catch: Throwable -> L89
        CloseableKt.closeFinally(r134, null);     // Catch: Exception -> L99 Throwable -> L107
        int r147 = this.f41166g + 1;     // Catch: Exception -> L99 Throwable -> L107
        this.f41166g = r147;     // Catch: Exception -> L99 Throwable -> L107
        if ((r147 % this.f41169j) != 0) goto L79;
        e(f());     // Catch: Exception -> L99 Throwable -> L107
    L79:
        if ((this.f41166g % this.f41167h) != 0) goto L86;
        boolean r148 = a(f());     // Catch: Exception -> L99 Throwable -> L107
        boolean r149 = b(f());     // Catch: Exception -> L99 Throwable -> L107
        if (r148 == true) goto L85;
        if (r149 == true) goto L85;
        if ((this.f41166g % this.f41168i) != 0) goto L86;
    L85:
        i(f());     // Catch: Exception -> L99 Throwable -> L107
    L86:
        f().setTransactionSuccessful();     // Catch: Exception -> L99 Throwable -> L107
        f().endTransaction();     // Catch: Throwable -> L122
        r114 = r145;
        r113 = r127;
        r112 = r214;
    L89:
        th = move-exception;
        r138 = th;
    L92:
        th = move-exception;
        r138 = th;
    L101:
        e = e;
        r107 = r107;
    L103:
        r105 = r127;
    L99:
        e = e;
        r107 = r29;
        r105 = r127;
        r108 = r104;
    L45:
        e = e;
        goto L103
    L34:
        r126 = 0;
        goto L35
    L29:
        r124 = 1;
    L47:
        e = e;
        goto L50
    L24:
        r122 = 0;
        goto L25
    L51:
        Pair<Integer, Integer> r150 = this.f41160a.a(r210.f41140a);     // Catch: Throwable -> L107 Exception -> L109
        int r151 = r150.component1().intValue();     // Catch: Throwable -> L107 Exception -> L109
        int r152 = r150.component2().intValue();     // Catch: Throwable -> L107 Exception -> L109
        this.f41171l.put(r210.f41140a, new b(r151, r152));     // Catch: Exception -> L104 Throwable -> L107
        r127 = r152;
        r107 = r151;
    L104:
        e = e;
        r102 = r102;
        r105 = r152;
        r107 = r151;
    L109:
        e = e;
        r102 = r102;
        r107 = 0;
        r108 = 0;
        r105 = 0;
    L107:
        th = move-exception;
        f().endTransaction();     // Catch: Throwable -> L122
        throw th;     // Catch: Throwable -> L122
    L122:
        th = move-exception;
        r103.unlock();     // Catch: Throwable -> L125
        throw th;     // Catch: Throwable -> L125
    L125:
        th = move-exception;
        throw th;
    }
}
