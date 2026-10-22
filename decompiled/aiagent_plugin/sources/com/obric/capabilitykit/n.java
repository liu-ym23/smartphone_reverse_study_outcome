package com.obric.capabilitykit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteBlobTooBigException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.capabilitykit.logger.Logger;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f32162b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f32163c = "EntityDBHelper";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f32164d = "EntityHistory.db";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f32165e = 1;
    private static final String f = "EntityHistory";
    private static final String g = "id";
    private static final String h = "entity_id";
    private static final String i = "entity_data";
    private static final String j = "entity_type";
    private static final String k = "entity_action";
    private static n l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SQLiteDatabase f32166a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        public final n a(Context r3) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r4, "context");
            n r0 = n.a();
            if (r0 != null) goto L13;
            monitor-enter(this);
            r0 = n.a();     // Catch: Throwable -> L10
            if (r0 != null) goto L8;
            r0 = new n(r4, null);     // Catch: Throwable -> L10
            a r5 = n.f32162b;     // Catch: Throwable -> L10
            n.a(r0);     // Catch: Throwable -> L10
        L8:
            monitor-exit(this);
        L10:
            th = move-exception;
            throw th;
        L13:
            return r0;
        }
    }

    static {
        f32162b = new a(null);
    }

    private n(Context r4) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin"), f32164d, null, 1);
        this.f32166a = getWritableDatabase();
    }

    public /* synthetic */ n(Context r2, d.h.b.h r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"));
    }

    private final j a(String r1) {
        return j.f32147a.a(r1);
    }

    public static final /* synthetic */ n a() {
        return l;
    }

    public static final /* synthetic */ void a(n r0) {
        l = r0;
    }

    private final boolean a(long r6) {
        int r5 = this.f32166a.delete(f, "id = ?", new String[]{String.valueOf(r6)});
        if (r5 > 0) goto L5;
        Logger.INSTANCE.e(f32163c, "delete error: " + r6);
    L5:
        if (r5 <= 0) goto L8;
        return true;
    L8:
        return false;
    }

    public static /* synthetic */ int access$000(String r0, String r1, Throwable r2) {
        return Log.w(r0, r1, r2);
    }

    public static /* synthetic */ int access$001(String r0, String r1) {
        return Log.w(r0, r1);
    }

    private final k b(String r22, int r23, String r24) {
        Cursor r1 = this.f32166a.query(f, new String[]{"id", h, i, "entity_type", k}, "entity_id = ? AND entity_type = ? AND entity_action = ?", new String[]{r22, String.valueOf(r23), r24}, null, null, "id ASC", "1");
        if (r1.moveToFirst() == false) goto L7;
        String r2 = r1.getString(r1.getColumnIndexOrThrow(k));
        d.h.b.o.c(r2, "cursor.getString(cursor.…UMN_ACTION\n            ))");
        j r20 = a(r2);
        if (r20 == null) goto L7;
        long r15 = r1.getLong(r1.getColumnIndexOrThrow("id"));
        String r3 = r1.getString(r1.getColumnIndexOrThrow(h));
        d.h.b.o.c(r3, "cursor.getString(cursor.…rThrow(COLUMN_ENTITY_ID))");
        String r4 = r1.getString(r1.getColumnIndexOrThrow(i));
        d.h.b.o.c(r4, "cursor.getString(cursor.…hrow(COLUMN_ENTITY_DATA))");
        k r0 = new k(r15, r3, r4, r1.getInt(r1.getColumnIndexOrThrow("entity_type")), r20);
    L8:
        r1.close();
        return r0;
    L7:
        r0 = null;
        goto L8
    }

    public final void a(String r3, int r4) {
        d.h.b.o.e(r3, "entityId");
        this.f32166a.delete(f, "entity_id = ? AND entity_type = ?", new String[]{r3, String.valueOf(r4)});
    }

    public final boolean a(k r5) {
        d.h.b.o.e(r5, "dao");
        SQLiteDatabase r4 = getWritableDatabase();
        ContentValues r0 = new ContentValues();
        r0.put(h, r5.b());
        r0.put(i, r5.c());
        r0.put("entity_type", Integer.valueOf(r5.d()));
        r0.put(k, r5.e().a());
        long r1 = r4.insert(f, null, r0);
        if (r1 != (-1)) goto L5;
        Logger.INSTANCE.e(f32163c, "insert error: " + r5);
    L5:
        if (r1 == (-1)) goto L7;
        return true;
    L7:
        return false;
    }

    public final boolean a(String r3, int r4, String r5) {
        d.h.b.o.e(r3, "entityId");
        d.h.b.o.e(r5, "actionType");
        k r6 = b(r3, r4, r5);
        if (r6 == null) goto L5;
        this.f32166a.delete(f, "id = ?", new String[]{String.valueOf(r6.a())});
    L5:
        return true;
    }

    public final boolean a(List<Long> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r7, "indexIds");
        this.f32166a.beginTransaction();
        Iterator r8 = r7.iterator();     // Catch: Throwable -> L16
    L4:
        boolean r2 = true;
    L6:
        if (r8.hasNext() == false) goto L13;
        long r3 = ((Number) ZeusTransformUtils.preCheckCast(r8.next(), Number.class, "com.obric.aiagent.plugin")).longValue();     // Catch: Throwable -> L16
        if (r2 == false) goto L12;
        if (a(r3) == true) goto L4;
    L12:
        r2 = false;
        goto L6
    L13:
        this.f32166a.setTransactionSuccessful();     // Catch: Throwable -> L16
        this.f32166a.endTransaction();
        return r2;
    L16:
        th = move-exception;
        this.f32166a.endTransaction();
        throw th;
    }

    public final d.m<Boolean, List<k>> b(List<k> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r9, "daoList");
        ArrayList r0 = new ArrayList();
        this.f32166a.beginTransaction();
        Iterator r10 = r9.iterator();     // Catch: Throwable -> L20
    L5:
        if (r10.hasNext() == false) goto L17;
        k r2 = (k) ZeusTransformUtils.preCheckCast(r10.next(), k.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        ContentValues r3 = new ContentValues();     // Catch: Throwable -> L20
        r3.put(h, r2.b());     // Catch: Throwable -> L20
        r3.put(i, r2.c());     // Catch: Throwable -> L20
        r3.put("entity_type", Integer.valueOf(r2.d()));     // Catch: Throwable -> L20
        r3.put(k, r2.e().a());     // Catch: Throwable -> L20
        if (this.f32166a.insert(f, null, r3) == (-1)) goto L5;
        r0.add(r2);     // Catch: Throwable -> L20
        goto L5
    L17:
        this.f32166a.setTransactionSuccessful();     // Catch: Throwable -> L20
        this.f32166a.endTransaction();
        return new d.m(Boolean.valueOf(!r0.isEmpty()), r0);
    L20:
        th = move-exception;
        this.f32166a.endTransaction();
        throw th;
    }

    public final List<k> b() {
        ArrayList r6 = new ArrayList();
        Long r0 = null;
    L4:
        if (r0 == null) goto L6;
        String[] r15 = {String.valueOf(r0.longValue())};
        String r14 = "id < ?";
    L7:
        String r1 = "id";
        Cursor r11 = this.f32166a.query(f, new String[]{"id", h, i, "entity_type", k}, r14, r15, null, null, "id DESC", "300");
        Long r12 = null;
    L43:
        if (r11.moveToNext() == false) goto L16;
        String r13 = r11.getString(r11.getColumnIndexOrThrow(k));     // Catch: Throwable -> L17 SQLiteBlobTooBigException -> L19
        d.h.b.o.c(r13, "cursor.getString(\n      …                        )");     // Catch: Throwable -> L17 SQLiteBlobTooBigException -> L19
        j r28 = a(r13);     // Catch: Throwable -> L17 SQLiteBlobTooBigException -> L19
        r12 = Long.valueOf(r11.getLong(r11.getColumnIndexOrThrow(r1)));     // Catch: Throwable -> L17 SQLiteBlobTooBigException -> L19
        if (r28 == null) goto L15;
        long r23 = r12.longValue();     // Catch: Throwable -> L17 SQLiteBlobTooBigException -> L19
        String r16 = r11.getString(r11.getColumnIndexOrThrow(h));     // Catch: Throwable -> L17 SQLiteBlobTooBigException -> L19
        d.h.b.o.c(r16, "cursor.getString(cursor.…rThrow(COLUMN_ENTITY_ID))");     // Catch: Throwable -> L17 SQLiteBlobTooBigException -> L19
        String r17 = r11.getString(r11.getColumnIndexOrThrow(i));     // Catch: Throwable -> L17 SQLiteBlobTooBigException -> L19
        d.h.b.o.c(r17, "cursor.getString(cursor.…hrow(COLUMN_ENTITY_DATA))");     // Catch: Throwable -> L17 SQLiteBlobTooBigException -> L19
        r6.add(new k(r23, r16, r17, r11.getInt(r11.getColumnIndexOrThrow("entity_type")), r28));     // Catch: Throwable -> L17 SQLiteBlobTooBigException -> L19
    L15:
        r1 = r1;
        goto L43
    L16:
        r11.close();
        r0 = r12;
        boolean r8 = false;
    L32:
        if (r8 == true) goto L36;
        if (r0 != null) goto L4;
    L36:
        return d.a.p.l(r6);
    L19:
        e = move-exception;
        Logger r7 = Logger.INSTANCE;     // Catch: Throwable -> L17
        r7.w(f32163c, "getUnprocessedEntityHistory CursorWindow overflow, clearing EntityHistory", e);     // Catch: Throwable -> L17
        INVOKESTATIC_com_obric_capabilitykit_n_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(f32163c, "getUnprocessedEntityHistory CursorWindow overflow, clearing EntityHistory", e);     // Catch: Throwable -> L17
        int r2 = this.f32166a.delete(f, null, null);     // Catch: Throwable -> L17 Exception -> L25
        r7.w(f32163c, "EntityHistory cleared, deleted=" + r2);     // Catch: Throwable -> L17 Exception -> L25
        INVOKESTATIC_com_obric_capabilitykit_n_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(f32163c, "EntityHistory cleared, deleted=" + r2);     // Catch: Throwable -> L17 Exception -> L25
    L30:
        r6.clear();     // Catch: Throwable -> L17
        r11.close();
        r0 = r12;
        r8 = true;
    L25:
        e = e;
    L29:
        Logger.INSTANCE.w(f32163c, "EntityHistory clear failed", e);     // Catch: Throwable -> L17
        INVOKESTATIC_com_obric_capabilitykit_n_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(f32163c, "EntityHistory clear failed", e);     // Catch: Throwable -> L17
    L27:
        e = e;
    L17:
        th = move-exception;
        r11.close();
        throw th;
    L6:
        r14 = null;
        r15 = null;
        goto L7
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase r1) {
        d.h.b.o.e(r1, MonitorConstants.DB);
        r1.execSQL(d.o.o.a("\n            CREATE TABLE EntityHistory (\n                id INTEGER PRIMARY KEY AUTOINCREMENT,\n                entity_id TEXT,\n                entity_data TEXT,\n                entity_type INTEGER,\n                entity_action TEXT\n            )\n        "));
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase r4, int r5, int r6) {
        d.h.b.o.e(r4, MonitorConstants.DB);
        Logger.INSTANCE.i(f32163c, "oldVersion: " + r5 + "  newVersion:" + r6);
        if (r5 != r6) goto L5;
        return;
    L5:
        int r3 = r5;
    L6:
        if (r3 >= r6) goto L8;
        Logger.INSTANCE.i(f32163c, "upgrade database form version " + r5 + " to version " + r6);
        r3 = r3 + 1;
        goto L6
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_capabilitykit_n_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_capabilitykit_n_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2, r3);
    }
}
