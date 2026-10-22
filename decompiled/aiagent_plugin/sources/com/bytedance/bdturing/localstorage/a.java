package com.bytedance.bdturing.localstorage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.bytedance.bdturing.g;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: DbManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    private static final String TAG = "DbManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6593a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static DbHelper f6594b;

    static {
        f6593a = new a();
    }

    private a() {
    }

    public final void a(String r2) {
        if (r2 == null) goto L5;
        a("settings", r2);
        return;
    }

    public final String a() {
        return query("settings");
    }

    public final void a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        o.d(r4, "context");
        monitor-enter(this);
        f6594b = new DbHelper(r4);     // Catch: Throwable -> L7
        x r5 = x.f38692a;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final long insert(String r8, String r9) {
        o.d(r8, "key");
        o.d(r9, "content");
        monitor-enter(this);
        g.a(TAG, "insert: " + r8);     // Catch: Throwable -> L16
        g.g(TAG, "content: " + r9);     // Catch: Throwable -> L16
        SQLiteDatabase r0 = f6593a.b();     // Catch: Throwable -> L16
        Long r3 = null;
        Long r1 = (Long) ZeusTransformUtils.preCheckCast(null, Long.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        if (r0 != null) goto L19;
    L9:
        r1 = r3;
    L10:
        if (r1 == null) goto L13;
        long r10 = r1.longValue();     // Catch: Throwable -> L16
    L14:
        monitor-exit(this);
        return r10;
    L13:
        r10 = -1;
        goto L14
    L19:
        ContentValues r4 = new ContentValues();     // Catch: SQLException -> L8 Throwable -> L16
        r4.put(DbHelper.COL_KEY, r8);     // Catch: SQLException -> L8 Throwable -> L16
        r4.put(DbHelper.COL_TIME_STAMP, Long.valueOf(System.currentTimeMillis()));     // Catch: SQLException -> L8 Throwable -> L16
        r4.put("content", r9);     // Catch: SQLException -> L8 Throwable -> L16
        r3 = Long.valueOf(r0.insert(DbHelper.TABLE_H5_STORAGE, null, r4));     // Catch: SQLException -> L8 Throwable -> L16
    L8:
        g.e(TAG, "insert fail!");     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    private final SQLiteDatabase b() {
        SQLiteDatabase r3 = (SQLiteDatabase) ZeusTransformUtils.preCheckCast(null, SQLiteDatabase.class, "com.obric.aiagent.plugin");
        DbHelper r4 = f6594b;     // Catch: SQLiteException -> L7
        if (r4 == null) goto L12;
        return r4.getWritableDatabase();
    L12:
        return null;
    L7:
        e = move-exception;
        g.a((Exception) ZeusTransformUtils.preCheckCast(e, Exception.class, "com.obric.aiagent.plugin"));
        return (SQLiteDatabase) ZeusTransformUtils.preCheckCast(null, SQLiteDatabase.class, "com.obric.aiagent.plugin");
    }

    private final long a(String r10, String r11) {
        monitor-enter(this);
        g.a(TAG, "insertOrUpdate: " + r10);     // Catch: Throwable -> L20
        g.g(TAG, "content: " + r11);     // Catch: Throwable -> L20
        ContentValues r0 = new ContentValues();     // Catch: Throwable -> L20
        r0.put(DbHelper.COL_KEY, r10);     // Catch: Throwable -> L20
        r0.put(DbHelper.COL_TIME_STAMP, Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L20
        r0.put("content", r11);     // Catch: Throwable -> L20
        SQLiteDatabase r12 = f6593a.b();     // Catch: Throwable -> L20
        Long r3 = null;
        Long r1 = (Long) ZeusTransformUtils.preCheckCast(null, Long.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        long r4 = 0;
        if (r12 != null) goto L25;
        r1 = null;
    L8:
        if (r1 != null) goto L11;
    L16:
        if (r1 == null) goto L18;
        r4 = r1.longValue();     // Catch: Throwable -> L20
    L18:
        monitor-exit(this);
        return r4;
    L11:
        if (r1.longValue() != 0) goto L16;
        if (r12 == null) goto L14;
        r3 = Long.valueOf(r12.insert(DbHelper.TABLE_H5_STORAGE, null, r0));     // Catch: SQLException -> L15 Throwable -> L20
    L15:
        g.e(TAG, "insertOrUpdate fail!");     // Catch: Throwable -> L20
    L14:
        r1 = r3;
        goto L16
    L25:
        r1 = Long.valueOf(r12.update(DbHelper.TABLE_H5_STORAGE, r0, "primary_key=?", new String[]{r10}));     // Catch: SQLException -> L15 Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    private final String query(String r14) {
        monitor-enter(this);
        g.g(TAG, DownloadConstants.QUERY_KEY);     // Catch: Throwable -> L27
        SQLiteDatabase r1 = f6593a.b();     // Catch: Throwable -> L27
        Cursor r3 = null;
        String r0 = (String) ZeusTransformUtils.preCheckCast(null, String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L27
        Cursor r10 = (Cursor) ZeusTransformUtils.preCheckCast(null, Cursor.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L27
        if (r1 != null) goto L40;
    L10:
        if (r3 != null) goto L42;
    L23:
        if (r3 == null) goto L25;
        r3.close();     // Catch: Throwable -> L30
    L33:
        goto L25
    L42:
    L20:
        r10 = r3;
    L21:
        if (r10 == null) goto L25;
        r10.close();     // Catch: Throwable -> L30
    L15:
        th = th;
        r10 = r3;
    L17:
        if (r10 != null) goto L38;
    L19:
        throw th;     // Catch: Throwable -> L27
    L38:
        r10.close();     // Catch: Throwable -> L31
        goto L19
    L12:
        if (r3.moveToFirst() != true) goto L23;
        r0 = r3.getString(0);     // Catch: Throwable -> L15 Exception -> L20
    L40:
        r3 = r1.query(DbHelper.TABLE_H5_STORAGE, new String[]{"content"}, "primary_key=?", new String[]{r14}, null, null, null, "1");     // Catch: Throwable -> L8 Exception -> L32
    L8:
        th = th;
    L25:
        monitor-exit(this);
        return r0;
    L27:
        th = move-exception;
        throw th;
    }

    private final int delete(int r7) {
        monitor-enter(this);
        g.a(TAG, "delete: " + r7);     // Catch: Throwable -> L14
        SQLiteDatabase r0 = f6593a.b();     // Catch: Throwable -> L14
        Integer r3 = null;
        Integer r1 = (Integer) ZeusTransformUtils.preCheckCast(null, Integer.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        int r2 = 0;
        if (r0 != null) goto L17;
    L9:
        r1 = r3;
    L10:
        if (r1 == null) goto L12;
        r2 = r1.intValue();     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);
        return r2;
    L17:
        r3 = Integer.valueOf(r0.delete(DbHelper.TABLE_H5_STORAGE, "id=?", new String[]{String.valueOf(r7)}));     // Catch: SQLException -> L8 Throwable -> L14
    L8:
        g.e(TAG, "delete fail!");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }
}
