package com.bytedance.applog.params.extract;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.bytedance.applog.log.n;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class ParamsExtractDao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f192560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SQLiteStatement f192561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SQLiteStatement f192562c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f192563a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f192564b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final JSONObject f192565c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f192566d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f192563a, r101.f192563a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f192564b, r101.f192564b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f192565c, r101.f192565c) == true) goto L18;
            return false;
        L18:
            if (this.f192566d == r101.f192566d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((this.f192563a.hashCode() * 31) + this.f192564b.hashCode()) * 31) + this.f192565c.hashCode()) * 31;
            long r101 = this.f192566d;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public final String toString() {
            return "ParamsExtractRecord(cpId=" + this.f192563a + ", sessionId=" + this.f192564b + ", json=" + this.f192565c + ", createdAt=" + this.f192566d + ')';
        }

        public a(String r100, JSONObject r101, long r102) {
            Intrinsics.checkNotNullParameter(r100, "cpId");
            Intrinsics.checkNotNullParameter("", "sessionId");
            Intrinsics.checkNotNullParameter(r101, "json");
            this.f192563a = r100;
            this.f192564b = "";
            this.f192565c = r101;
            this.f192566d = r102;
        }
    }

    public final int a(String r110) {
        Intrinsics.checkNotNullParameter(r110, "sessionId");
        SQLiteDatabase r100 = this.f192560a.getWritableDatabase();
        if (this.f192561b != null) goto L6;
        this.f192561b = r100.compileStatement("INSERT OR ABORT INTO cp_entries(cp_id, session_id, json, created_at) VALUES(?, ?, ?, ?)");
    L6:
        if (this.f192562c != null) goto L8;
        this.f192562c = r100.compileStatement("DELETE FROM cp_entries WHERE session_id!=?");
    L8:
        r100.beginTransaction();
        SQLiteStatement r101 = this.f192562c;     // Catch: Throwable -> L17 Exception -> L19
        Intrinsics.checkNotNull(r101);     // Catch: Throwable -> L17 Exception -> L19
        r101.bindString(1, r110);     // Catch: Throwable -> L17 Exception -> L19
        int r102 = r101.executeUpdateDelete();     // Catch: Throwable -> L17 Exception -> L19
        r100.setTransactionSuccessful();     // Catch: Exception -> L15 Throwable -> L17
        r100.endTransaction();     // Catch: Exception -> L32
    L12:
        SQLiteStatement r111 = this.f192562c;     // Catch: Exception -> L33
        if (r111 == null) goto L39;
    L25:
        r111.clearBindings();     // Catch: Exception -> L33
    L39:
    L15:
        Exception e100 = e;
    L21:
        n.w().c(c.f192568a, "DB deleteHistoryByCurrentSession failed for session=" + r110, new Object[]{e100});     // Catch: Throwable -> L17
        r100.endTransaction();     // Catch: Exception -> L34
    L23:
        r111 = this.f192562c;     // Catch: Exception -> L33
        if (r111 == null) goto L39;
    L17:
        th = move-exception;
        r100.endTransaction();     // Catch: Exception -> L35
    L46:
        SQLiteStatement r103 = this.f192562c;     // Catch: Exception -> L36
        if (r103 == null) goto L53;
        r103.clearBindings();     // Catch: Exception -> L36
        throw th;
    L53:
        throw th;
    L54:
        throw th;
    L19:
        e = move-exception;
        e100 = e;
        r102 = 0;
    L26:
        return r102;
    }

    public final Map<String, JSONObject> b(List<String> r110) {
        Intrinsics.checkNotNullParameter(r110, "ids");
        ArrayList r100 = (ArrayList) r110;
        if (r100.isEmpty() == true) goto L5;
        SQLiteDatabase r111 = this.f192560a.getReadableDatabase();
        HashMap r112 = new HashMap(r100.size());
        Cursor r113 = null;
        String r101 = "SELECT cp_id, json FROM cp_entries WHERE cp_id IN (" + CollectionsKt.joinToString$default(r110, ",", null, null, 0, null, ParamsExtractDao$getByIds$placeholders$1.INSTANCE, 30, null) + ')';     // Catch: Throwable -> L24 Exception -> L26
        Object[] r102 = r110.toArray(new String[0]);     // Catch: Throwable -> L24 Exception -> L26
        if (r102 == null) goto L23;
        Cursor r103 = r111.rawQuery(r101, (String[]) r102);     // Catch: Throwable -> L24 Exception -> L26
    L41:
        if (r103.moveToNext() == false) goto L39;
        String r104 = r103.getString(r103.getColumnIndexOrThrow("cp_id"));     // Catch: Throwable -> L18 Exception -> L20
        r112.put(r104, new JSONObject(r103.getString(r103.getColumnIndexOrThrow("json"))));     // Catch: Exception -> L15 Throwable -> L18
    L15:
        e = move-exception;
        n.w().c(c.f192568a, "Invalid JSON for cp_id=" + r104 + " in batch getByIds, skipping", new Object[]{e});     // Catch: Throwable -> L18 Exception -> L20
    L39:
        r103.close();     // Catch: Exception -> L35
    L31:
        return r112;
    L18:
        th = th;
        r113 = r103;
    L32:
        if (r113 != null) goto L45;
    L34:
        throw th;
    L45:
        r113.close();     // Catch: Exception -> L36
    L20:
        e = e;
        r113 = r103;
    L27:
        n.w().c(c.f192568a, "DB batch query failed in getByIds", new Object[]{e});     // Catch: Throwable -> L24
        if (r113 == null) goto L31;
        r103 = r113;
        goto L39
    L23:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");     // Catch: Throwable -> L24 Exception -> L26
    L24:
        th = th;
    L26:
        e = e;
        goto L27
    L5:
        return MapsKt.emptyMap();
    }

    public final List<String> c(String r110) {
        Intrinsics.checkNotNullParameter(r110, "sessionId");
        SQLiteDatabase r100 = this.f192560a.getReadableDatabase();
        ArrayList r101 = new ArrayList();
        Cursor r111 = null;
        r111 = r100.query("cp_entries", new String[]{"cp_id"}, "session_id!=?", new String[]{r110}, null, null, null);     // Catch: Exception -> L10 Throwable -> L15
    L5:
        if (r111.moveToNext() == false) goto L21;
        r101.add(r111.getString(r111.getColumnIndexOrThrow("cp_id")));     // Catch: Exception -> L10 Throwable -> L15
    L21:
        r111.close();     // Catch: Exception -> L19
    L14:
        return r101;
    L15:
        th = move-exception;
        if (r111 != null) goto L25;
    L18:
        throw th;
    L25:
        r111.close();     // Catch: Exception -> L20
    L10:
        e = move-exception;
        n.w().c(c.f192568a, "DB listIdsBySession failed for session=" + r110, new Object[]{e});     // Catch: Throwable -> L15
        if (r111 == null) goto L14;
        goto L14
    }

    public ParamsExtractDao(Context r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "helper");
        this.f192560a = r101;
    }

    public boolean insert(String r100, String r101, String r110) {
        Intrinsics.checkNotNullParameter(r100, "cpId");
        Intrinsics.checkNotNullParameter(r101, "sessionId");
        Intrinsics.checkNotNullParameter(r110, "json");
        long r102 = System.currentTimeMillis();
        SQLiteDatabase r103 = this.f192560a.getWritableDatabase();
        if (this.f192561b != null) goto L6;
        this.f192561b = r103.compileStatement("INSERT OR ABORT INTO cp_entries(cp_id, session_id, json, created_at) VALUES(?, ?, ?, ?)");
    L6:
        if (this.f192562c != null) goto L8;
        this.f192562c = r103.compileStatement("DELETE FROM cp_entries WHERE session_id!=?");
    L8:
        SQLiteStatement r104 = this.f192561b;
        Intrinsics.checkNotNull(r104);
        boolean r105 = true;
        r104.bindString(1, r100);     // Catch: Throwable -> L13 Exception -> L15
        r104.bindString(2, r101);     // Catch: Throwable -> L13 Exception -> L15
        r104.bindString(3, r110);     // Catch: Throwable -> L13 Exception -> L15
        r104.bindLong(4, r102);     // Catch: Throwable -> L13 Exception -> L15
    L11:
        if (r104.executeInsert() != (-1)) goto L29;
    L17:
        r105 = false;
    L29:
        r104.clearBindings();     // Catch: Exception -> L22
    L19:
        return r105;
    L13:
        th = move-exception;
        r104.clearBindings();     // Catch: Exception -> L23
    L21:
        throw th;
    L15:
        e = move-exception;
        n.w().c(c.f192568a, "DB insert failed for cp_id=" + r100, new Object[]{e});     // Catch: Throwable -> L13
        goto L17
    }
}
