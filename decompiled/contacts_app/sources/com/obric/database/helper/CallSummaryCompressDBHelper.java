package com.obric.database.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.android.contacts.calllog.v2.CallLogListAdapter;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.obric.contacts.DatabaseConstantsKt;
import com.obric.database.entity.CallSummaryComposeBetaEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CallSummaryCompressDBHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007J,\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007J\u000e\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\"\u0010\u001b\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\nH\u0016J\u0016\u0010\u001e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0017¨\u0006\u001f"}, d2 = {"Lcom/obric/database/helper/CallSummaryCompressDBHelper;", "Landroid/database/sqlite/SQLiteOpenHelper;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "createTable", "", CloudControlInf.DB, "Landroid/database/sqlite/SQLiteDatabase;", "deleteById", "", "id", "", "getData", "", "Lcom/obric/database/entity/CallSummaryComposeBetaEntity;", CallLogListAdapter.PAYLOAD_SELECTION, "", "getDataFromStartToEnd", "startId", "endId", "insertData", "values", "Landroid/content/ContentValues;", "isTableExist", "", "onCreate", "onUpgrade", "oldVersion", "newVersion", "updateData", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CallSummaryCompressDBHelper extends SQLiteOpenHelper {
    public CallSummaryCompressDBHelper(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, DatabaseConstantsKt.CONTACTS_DB_NAME, null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase r2) {
        Intrinsics.checkNotNullParameter(r2, CloudControlInf.DB);
        createTable(r2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase r1, int r2, int r3) {
        if (isTableExist() == true) goto L7;
        if (r1 == null) goto L8;
        createTable(r1);
        return;
    L8:
        return;
    }

    public final long insertData(ContentValues r3) {
        Intrinsics.checkNotNullParameter(r3, "values");
        return getWritableDatabase().insert(DatabaseConstantsKt.CALL_SUMMARY_COMPRESS_BETA_DB_TABLE_NAME, null, r3);
    }

    public final int deleteById(long r3) {
        return getWritableDatabase().delete(DatabaseConstantsKt.CALL_SUMMARY_COMPRESS_BETA_DB_TABLE_NAME, "compress_start_id = ?", new String[]{String.valueOf(r3)});
    }

    public final int updateData(long r3, ContentValues r5) {
        Intrinsics.checkNotNullParameter(r5, "values");
        return getWritableDatabase().update(DatabaseConstantsKt.CALL_SUMMARY_COMPRESS_BETA_DB_TABLE_NAME, r5, "_id = ?", new String[]{String.valueOf(r3)});
    }

    public final List<CallSummaryComposeBetaEntity> getData(String r3) {
        return getDataFromStartToEnd(-1, Integer.MAX_VALUE, r3);
    }

    public static /* synthetic */ List getDataFromStartToEnd$default(CallSummaryCompressDBHelper r0, int r1, int r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = -1;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = Integer.MAX_VALUE;
    L9:
        return r0.getDataFromStartToEnd(r1, r2, r3);
    }

    public final List<CallSummaryComposeBetaEntity> getDataFromStartToEnd(int r13, int r14, String r15) {
        ArrayList r0 = new ArrayList();
        Cursor r12 = getReadableDatabase().query(DatabaseConstantsKt.CALL_SUMMARY_COMPRESS_BETA_DB_TABLE_NAME, new String[]{"_id", "phone_number", "call_create_time", DatabaseConstantsKt.CALL_SUMMARY_COMPRESS_BETA_COLUM_COMPRESS_RESULT, DatabaseConstantsKt.CALL_SUMMARY_COMPRESS_BETA_COLUM_COMPRESS_CONTEXT, DatabaseConstantsKt.CALL_SUMMARY_COMPRESS_BETA_COLUM_COMPRESS_START_ID, DatabaseConstantsKt.CALL_SUMMARY_COMPRESS_BETA_COLUM_COMPRESS_END_ID}, r15, null, null, null, null);
        Intrinsics.checkNotNullExpressionValue(r12, "readableDatabase.query(\n…ull, null, null\n        )");
    L4:
        if (r12.moveToNext() == false) goto L11;
        long r1 = r12.getLong(r12.getColumnIndex("_id"));
        if (r1 < r13) goto L4;
        if (r1 > r14) goto L4;
        String r3 = r12.getString(r12.getColumnIndex("phone_number"));
        Intrinsics.checkNotNullExpressionValue(r3, "cursor.getString(cursor.…BETA_COLUM_PHONE_NUMBER))");
        long r4 = r12.getLong(r12.getColumnIndex("call_create_time"));
        int r6 = r12.getInt(r12.getColumnIndex(DatabaseConstantsKt.CALL_SUMMARY_COMPRESS_BETA_COLUM_COMPRESS_RESULT));
        String r7 = r12.getString(r12.getColumnIndex(DatabaseConstantsKt.CALL_SUMMARY_COMPRESS_BETA_COLUM_COMPRESS_CONTEXT));
        Intrinsics.checkNotNullExpressionValue(r7, "cursor.getString(cursor.…_COLUM_COMPRESS_CONTEXT))");
        r0.add(new CallSummaryComposeBetaEntity(r3, r4, r6, r7, r12.getInt(r12.getColumnIndex(DatabaseConstantsKt.CALL_SUMMARY_COMPRESS_BETA_COLUM_COMPRESS_START_ID)), r12.getInt(r12.getColumnIndex(DatabaseConstantsKt.CALL_SUMMARY_COMPRESS_BETA_COLUM_COMPRESS_END_ID)), r12.getLong(r12.getColumnIndex("_id"))));
        goto L4
    L11:
        r12.close();
        return r0;
    }

    public final void createTable(SQLiteDatabase r1) {
        Intrinsics.checkNotNullParameter(r1, CloudControlInf.DB);
        r1.execSQL("CREATE TABLE call_summary_compress_beta (\n    _id INTEGER PRIMARY KEY AUTOINCREMENT,\n    phone_number TEXT,\n    call_create_time BIGINT,\n    compress_result INTEGER,\n    compress_context TEXT,\n    compress_start_id INTEGER,\n    compress_end_id INTEGER\n)");
    }

    private final boolean isTableExist() {
        Cursor r2 = getReadableDatabase().rawQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='call_summary_compress_beta'", null);
        Intrinsics.checkNotNullExpressionValue(r2, "db.rawQuery(\"SELECT name…TA_DB_TABLE_NAME'\", null)");
        boolean r0 = r2.moveToFirst();
        r2.close();
        return r0;
    }
}
