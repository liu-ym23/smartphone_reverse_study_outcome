package com.bytedance.android.live.effect.composer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Handler;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.android.ugc.effectmanager.MobConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class l extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f67967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f67968b;

    public static final class a {
        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L8;
            a r101 = (a) r100;
            r101.getClass();
            if (Intrinsics.areEqual(null, null) == false) goto L12;
            r101.getClass();
            return true;
        L12:
            return false;
        L8:
            return false;
        }

        public final int getType() {
            return 0;
        }

        public final int hashCode() {
            return (0 * 31) + 0;
        }

        public final String toString() {
            return "ChangInfo(node=null, type=0)";
        }
    }

    public static final class b {
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f67969a;

        public c(l r100) {
            this.f67969a = r100;
        }

        public final void a() {
            l r100 = this.f67969a;
            if (((ArrayList) r100.f67967a).size() == 0) goto L23;
            List r101 = CollectionsKt.toList(r100.f67967a);
            SQLiteDatabase r102 = r100.getWritableDatabase();
            r102.beginTransaction();
            Iterator r103 = r101.iterator();     // Catch: Throwable -> L16 SQLiteException -> L18
        L7:
            if (r103.hasNext() == false) goto L14;
            a r104 = (a) r103.next();     // Catch: Throwable -> L16 SQLiteException -> L18
            switch(r104.getType()) {
                case 10001: goto L13;
                case 10002: goto L12;
                case 10003: goto L11;
                default: goto L7;
            };     // Catch: Throwable -> L16 SQLiteException -> L18
        L11:
            r104.getClass();     // Catch: Throwable -> L16 SQLiteException -> L18
            r100.d(null, r102);     // Catch: Throwable -> L16 SQLiteException -> L18
            goto L7
        L12:
            r104.getClass();     // Catch: Throwable -> L16 SQLiteException -> L18
            r100.a(null, r102);     // Catch: Throwable -> L16 SQLiteException -> L18
            goto L7
        L13:
            r104.getClass();     // Catch: Throwable -> L16 SQLiteException -> L18
            r100.b(null, r102);     // Catch: Throwable -> L16 SQLiteException -> L18
            goto L7
        L14:
            r102.setTransactionSuccessful();     // Catch: Throwable -> L16 SQLiteException -> L18
        L20:
            r102.endTransaction();
            r102.close();
            ((ArrayList) r100.f67967a).clear();
            goto L23
        L18:
            e = move-exception;
            ALogger.e("LiveComposerSQLiteHelper", e);     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            r102.endTransaction();
            r102.close();
            throw th;
        L23:
            r100.getClass();
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase r100) {
        c(true, "");
        if (r100 == null) goto L5;
        r100.execSQL("CREATE TABLE IF NOT EXISTS live_composer_node (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,panel TEXT,effect_id TEXT,resource_id TEXT,path TEXT,update_time INTEGER,use INTEGER,is_high_cost INTEGER)");
    L5:
        if (r100 == null) goto L7;
        r100.execSQL("CREATE TABLE IF NOT EXISTS live_composer_tag_node(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,tag TEXT,value REAL,node_id INTEGER)");
    L7:
        c(false, WidgetCostModule.TYPE_ON_CREATE);
    }

    public l(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "dbName");
        super(r100, r101, null, 3);
        this.f67967a = new ArrayList();
        PthreadHandlerThreadV2 r102 = new PthreadHandlerThreadV2("ComposerSQLiteHelperThread");
        ThreadMethodProxy.start(r102);
        new Handler(r102.getLooper());
        new c(this);
    }

    public final void a(n r110, SQLiteDatabase r111) {
        c(true, "");
        Cursor r100 = r111.query("live_composer_node", new String[]{"id"}, "effect_id = ?", new String[]{r110.f67972b}, null, null, null);     // Catch: SQLiteException -> L11
        if (r100.moveToFirst() == false) goto L6;
        int r101 = r100.getInt(r100.getColumnIndex("id"));     // Catch: SQLiteException -> L11
    L7:
        r100.close();     // Catch: SQLiteException -> L11
        r111.delete("live_composer_node", "effect_id = ?", new String[]{r110.f67972b});     // Catch: SQLiteException -> L11
        if (r101 == (-1)) goto L13;
        r111.delete("live_composer_tag_node", "node_id = ?", new String[]{String.valueOf(r101)});     // Catch: SQLiteException -> L11
    L13:
        c(false, "deleteComposerNode");
        return;
    L6:
        r101 = -1;
    L11:
        e = move-exception;
        ALogger.e("LiveComposerSQLiteHelper", e);
        goto L13
    }

    public final void b(n r100, SQLiteDatabase r110) {
        int r101 = 1;
        c(true, "");
        ContentValues r102 = new ContentValues();     // Catch: SQLiteException -> L16
        r102.put("panel", r100.f67971a);     // Catch: SQLiteException -> L16
        r102.put(MobConstants.EFFECT_ID, r100.f67972b);     // Catch: SQLiteException -> L16
        r102.put("resource_id", r100.f67973c);     // Catch: SQLiteException -> L16
        r102.put("path", r100.f67974d);     // Catch: SQLiteException -> L16
        r102.put("update_time", Long.valueOf(r100.f67977g));     // Catch: SQLiteException -> L16
        if (r100.f67980j == false) goto L6;
        int r103 = 1;
    L7:
        r102.put(NameKeys.LoadStrategy_Use, Integer.valueOf(r103));     // Catch: SQLiteException -> L16
        if (r100.f67976f == true) goto L11;
        r101 = 0;
    L11:
        r102.put("is_high_cost", Integer.valueOf(r101));     // Catch: SQLiteException -> L16
        long r104 = r110.insert("live_composer_node", null, r102);     // Catch: SQLiteException -> L16
        Iterator r105 = ((ArrayList) r100.f67979i).iterator();     // Catch: SQLiteException -> L16
    L13:
        if (r105.hasNext() == false) goto L18;
        p r106 = (p) r105.next();     // Catch: SQLiteException -> L16
        ContentValues r107 = new ContentValues();     // Catch: SQLiteException -> L16
        r107.put("tag", r106.f67984b);     // Catch: SQLiteException -> L16
        r107.put("value", r106.f67983a);     // Catch: SQLiteException -> L16
        r107.put("node_id", Long.valueOf(r104));     // Catch: SQLiteException -> L16
        r110.insert("live_composer_tag_node", null, r107);     // Catch: SQLiteException -> L16
    L18:
        c(false, "saveComposerNode");
        return;
    L6:
        r103 = 0;
    L16:
        e = move-exception;
        ALogger.e("LiveComposerSQLiteHelper", e);
        goto L18
    }

    public final void c(boolean r100, String r101) {
        if (r100 == false) goto L5;
        this.f67968b = System.currentTimeMillis();
        return;
    L5:
        ALogger.d("LiveUxTracer", "compose sql, duration of " + r101 + ": " + (System.currentTimeMillis() - this.f67968b) + ", thread: " + ThreadMethodProxy.currentThread().getName());
    }

    public final void d(n r110, SQLiteDatabase r111) {
        c(true, "");
        Cursor r100 = r111.query("live_composer_node", new String[]{"id"}, "effect_id = ?", new String[]{r110.f67972b}, null, null, null);     // Catch: SQLiteException -> L14
        if (r100.moveToFirst() == false) goto L6;
        int r101 = r100.getInt(r100.getColumnIndex("id"));     // Catch: SQLiteException -> L14
    L7:
        r100.close();     // Catch: SQLiteException -> L14
        ContentValues r102 = new ContentValues();     // Catch: SQLiteException -> L14
        r102.put("update_time", Long.valueOf(r110.f67977g));     // Catch: SQLiteException -> L14
        r111.update("live_composer_node", r102, "effect_id = ?", new String[]{r110.f67972b});     // Catch: SQLiteException -> L14
        if (r101 == (-1)) goto L16;
        Iterator r112 = new ArrayList(r110.f67979i).iterator();     // Catch: SQLiteException -> L14
    L10:
        if (r112.hasNext() == false) goto L16;
        p r103 = (p) r112.next();     // Catch: SQLiteException -> L14
        ContentValues r104 = new ContentValues();     // Catch: SQLiteException -> L14
        r104.put("value", r103.f67983a);     // Catch: SQLiteException -> L14
        r111.update("live_composer_tag_node", r104, "node_id = ? and tag = ?", new String[]{String.valueOf(r101), r103.f67984b});     // Catch: SQLiteException -> L14
    L16:
        c(false, "updateComposerNode");
        return;
    L6:
        r101 = -1;
    L14:
        e = move-exception;
        ALogger.e("LiveComposerSQLiteHelper", e);
        goto L16
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase r100, int r101, int r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.execSQL("Drop Table if exists live_composer_node");
        r100.execSQL("Drop Table if exists live_composer_tag_node");
        onCreate(r100);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase r100, int r101, int r102) {
        if (r101 >= 2) goto L7;
        if (r100 == null) goto L7;
        r100.execSQL("ALTER TABLE live_composer_node ADD COLUMN resource_id TEXT DEFAULT \"\" NOT NULL;");
    L7:
        if (r101 >= 3) goto L11;
        if (r100 == null) goto L12;
        r100.execSQL("ALTER TABLE live_composer_node ADD COLUMN is_high_cost INTEGER DEFAULT 0 NOT NULL;");
        return;
    L12:
        return;
    }
}
