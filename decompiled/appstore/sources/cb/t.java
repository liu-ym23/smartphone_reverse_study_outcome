package cb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteBlobTooBigException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.obric.capabilitykit.EntityProvider;
import com.obric.capabilitykit.logger.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.b0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt__IndentKt;

/* JADX INFO: loaded from: classes3.dex */
public final class t extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f6104b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static t f6105c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SQLiteDatabase f6106a;

    public static final class a {
        public a() {
        }

        public final t a(Context r10) {
            kotlin.jvm.internal.q.g(r10, "context");
            t r11 = t.a();
            if (r11 != null) goto L15;
            monitor-enter(this);
            r11 = t.a();     // Catch: Throwable -> L9
            if (r11 != null) goto L11;
            r11 = new t(r10, null);     // Catch: Throwable -> L9
            t.c(r11);     // Catch: Throwable -> L9
        L11:
            monitor-exit(this);
        L9:
            th = move-exception;
            throw th;
        L15:
            return r11;
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        f6104b = new a(null);
    }

    public t(Context r10) {
        super(r10, "EntityHistory.db", null, 1);
        this.f6106a = getWritableDatabase();
    }

    public static final /* synthetic */ t a() {
        return f6105c;
    }

    public static final /* synthetic */ void c(t r10) {
        f6105c = r10;
    }

    public final com.obric.capabilitykit.m b(String r10) {
        return com.obric.capabilitykit.m.f11370b.a(r10);
    }

    public final void d(String r10, int r11) {
        kotlin.jvm.internal.q.g(r10, "entityId");
        String[] r12 = {r10, String.valueOf(r11)};
        this.f6106a.delete("EntityHistory", "entity_id = ? AND entity_type = ?", r12);
    }

    public final boolean e(long r10) {
        int r11 = this.f6106a.delete("EntityHistory", "id = ?", new String[]{String.valueOf(r10)});
        if (r11 > 0) goto L5;
        Logger.INSTANCE.e("EntityDBHelper", "delete error: " + r10);
    L5:
        if (r11 <= 0) goto L7;
        return true;
    L7:
        return false;
    }

    public final boolean f(String r10, int r11, String r12) {
        kotlin.jvm.internal.q.g(r10, "entityId");
        kotlin.jvm.internal.q.g(r12, "actionType");
        u r13 = h(r10, r11, r12);
        if (r13 == null) goto L7;
        String[] r14 = {String.valueOf(r13.d())};
        this.f6106a.delete("EntityHistory", "id = ?", r14);
        return true;
    L7:
        return true;
    }

    public final boolean g(List r10) {
        kotlin.jvm.internal.q.g(r10, "indexIds");
        this.f6106a.beginTransaction();
        Iterator r11 = r10.iterator();     // Catch: Throwable -> L12
    L4:
        boolean r12 = true;
    L6:
        if (r11.hasNext() == false) goto L15;
        long r13 = ((Number) r11.next()).longValue();     // Catch: Throwable -> L12
        if (r12 == false) goto L14;
        if (e(r13) == true) goto L4;
    L14:
        r12 = false;
        goto L6
    L15:
        this.f6106a.setTransactionSuccessful();     // Catch: Throwable -> L12
        this.f6106a.endTransaction();
        return r12;
    L12:
        th = move-exception;
        this.f6106a.endTransaction();
        throw th;
    }

    public final u h(String r22, int r23, String r24) {
        Cursor r10 = this.f6106a.query("EntityHistory", new String[]{"id", "entity_id", "entity_data", EntityProvider.KEY_ENTITY_TYPE, "entity_action"}, "entity_id = ? AND entity_type = ? AND entity_action = ?", new String[]{r22, String.valueOf(r23), r24}, null, null, "id ASC", "1");
        if (r10.moveToFirst() == false) goto L7;
        String r11 = r10.getString(r10.getColumnIndexOrThrow("entity_action"));
        kotlin.jvm.internal.q.f(r11, "cursor.getString(cursor.…UMN_ACTION\n            ))");
        com.obric.capabilitykit.m r20 = b(r11);
        if (r20 == null) goto L7;
        long r15 = r10.getLong(r10.getColumnIndexOrThrow("id"));
        String r12 = r10.getString(r10.getColumnIndexOrThrow("entity_id"));
        kotlin.jvm.internal.q.f(r12, "cursor.getString(cursor.…rThrow(COLUMN_ENTITY_ID))");
        String r13 = r10.getString(r10.getColumnIndexOrThrow("entity_data"));
        kotlin.jvm.internal.q.f(r13, "cursor.getString(cursor.…hrow(COLUMN_ENTITY_DATA))");
        u r14 = new u(r15, r12, r13, r10.getInt(r10.getColumnIndexOrThrow(EntityProvider.KEY_ENTITY_TYPE)), r20);
    L8:
        r10.close();
        return r14;
    L7:
        r14 = null;
        goto L8
    }

    public final List i() {
        ArrayList r10 = new ArrayList();
        Long r11 = null;
    L4:
        if (r11 == null) goto L6;
        String[] r15 = {String.valueOf(r11.longValue())};
        String r14 = "id < ?";
    L7:
        String r12 = "id";
        Cursor r13 = this.f6106a.query("EntityHistory", new String[]{"id", "entity_id", "entity_data", EntityProvider.KEY_ENTITY_TYPE, "entity_action"}, r14, r15, null, null, "id DESC", "300");
        Long r16 = null;
    L44:
        if (r13.moveToNext() == false) goto L20;
        String r17 = r13.getString(r13.getColumnIndexOrThrow("entity_action"));     // Catch: Throwable -> L14 SQLiteBlobTooBigException -> L16
        kotlin.jvm.internal.q.f(r17, "cursor.getString(\n      …                        )");     // Catch: Throwable -> L14 SQLiteBlobTooBigException -> L16
        com.obric.capabilitykit.m r28 = b(r17);     // Catch: Throwable -> L14 SQLiteBlobTooBigException -> L16
        long r23 = r13.getLong(r13.getColumnIndexOrThrow(r12));     // Catch: Throwable -> L14 SQLiteBlobTooBigException -> L16
        r16 = Long.valueOf(r23);     // Catch: Throwable -> L14 SQLiteBlobTooBigException -> L16
        if (r28 == null) goto L19;
        String r18 = r13.getString(r13.getColumnIndexOrThrow("entity_id"));     // Catch: Throwable -> L14 SQLiteBlobTooBigException -> L16
        kotlin.jvm.internal.q.f(r18, "cursor.getString(cursor.…rThrow(COLUMN_ENTITY_ID))");     // Catch: Throwable -> L14 SQLiteBlobTooBigException -> L16
        String r19 = r13.getString(r13.getColumnIndexOrThrow("entity_data"));     // Catch: Throwable -> L14 SQLiteBlobTooBigException -> L16
        kotlin.jvm.internal.q.f(r19, "cursor.getString(cursor.…hrow(COLUMN_ENTITY_DATA))");     // Catch: Throwable -> L14 SQLiteBlobTooBigException -> L16
        r10.add(new u(r23, r18, r19, r13.getInt(r13.getColumnIndexOrThrow(EntityProvider.KEY_ENTITY_TYPE)), r28));     // Catch: Throwable -> L14 SQLiteBlobTooBigException -> L16
    L19:
        r12 = r12;
        goto L44
    L20:
        r13.close();
        r11 = r16;
        boolean r20 = false;
    L33:
        if (r20 == true) goto L37;
        if (r11 != null) goto L4;
    L37:
        return b0.p0(r10);
    L14:
        th = move-exception;
        r13.close();
        throw th;
    L16:
        e = move-exception;
        Logger r21 = Logger.INSTANCE;     // Catch: Throwable -> L14
        r21.w("EntityDBHelper", "getUnprocessedEntityHistory CursorWindow overflow, clearing EntityHistory", e);     // Catch: Throwable -> L14
        Log.w("EntityDBHelper", "getUnprocessedEntityHistory CursorWindow overflow, clearing EntityHistory", e);     // Catch: Throwable -> L14
        int r22 = this.f6106a.delete("EntityHistory", null, null);     // Catch: Throwable -> L14 Exception -> L26
        r21.w("EntityDBHelper", "EntityHistory cleared, deleted=" + r22);     // Catch: Throwable -> L14 Exception -> L26
        Log.w("EntityDBHelper", "EntityHistory cleared, deleted=" + r22);     // Catch: Throwable -> L14 Exception -> L26
    L31:
        r10.clear();     // Catch: Throwable -> L14
        r13.close();
        r11 = r16;
        r20 = true;
    L26:
        e = e;
    L30:
        Logger.INSTANCE.w("EntityDBHelper", "EntityHistory clear failed", e);     // Catch: Throwable -> L14
        Log.w("EntityDBHelper", "EntityHistory clear failed", e);     // Catch: Throwable -> L14
    L28:
        e = e;
        goto L30
    L6:
        r14 = null;
        r15 = null;
        goto L7
    }

    public final Pair j(List r10) {
        kotlin.jvm.internal.q.g(r10, "daoList");
        ArrayList r11 = new ArrayList();
        this.f6106a.beginTransaction();
        Iterator r12 = r10.iterator();     // Catch: Throwable -> L17
    L5:
        if (r12.hasNext() == false) goto L19;
        u r13 = (u) r12.next();     // Catch: Throwable -> L17
        ContentValues r14 = new ContentValues();     // Catch: Throwable -> L17
        r14.put("entity_id", r13.c());     // Catch: Throwable -> L17
        r14.put("entity_data", r13.b());     // Catch: Throwable -> L17
        r14.put(EntityProvider.KEY_ENTITY_TYPE, Integer.valueOf(r13.e()));     // Catch: Throwable -> L17
        r14.put("entity_action", r13.a().b());     // Catch: Throwable -> L17
        if (this.f6106a.insert("EntityHistory", null, r14) == (-1)) goto L5;
        r11.add(r13);     // Catch: Throwable -> L17
        goto L5
    L19:
        this.f6106a.setTransactionSuccessful();     // Catch: Throwable -> L17
        this.f6106a.endTransaction();
        return new Pair(Boolean.valueOf(!r11.isEmpty()), r11);
    L17:
        th = move-exception;
        this.f6106a.endTransaction();
        throw th;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase r10) {
        kotlin.jvm.internal.q.g(r10, CloudControlInf.DB);
        r10.execSQL(StringsKt__IndentKt.e("\n            CREATE TABLE EntityHistory (\n                id INTEGER PRIMARY KEY AUTOINCREMENT,\n                entity_id TEXT,\n                entity_data TEXT,\n                entity_type INTEGER,\n                entity_action TEXT\n            )\n        "));
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase r10, int r11, int r12) {
        kotlin.jvm.internal.q.g(r10, CloudControlInf.DB);
        Logger.INSTANCE.i("EntityDBHelper", "oldVersion: " + r11 + "  newVersion:" + r12);
        if (r11 != r12) goto L5;
        return;
    L5:
        int r13 = r11;
    L6:
        if (r13 >= r12) goto L8;
        Logger.INSTANCE.i("EntityDBHelper", "upgrade database form version " + r11 + " to version " + r12);
        r13 = r13 + 1;
        goto L6
    }

    public /* synthetic */ t(Context r10, DefaultConstructorMarker r11) {
        this(r10);
    }
}
