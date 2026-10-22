package com.bytedance.apm.agent.instrumentation;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.CancellationSignal;
import com.bytedance.apm.agent.tracing.TraceMachine;
import java.util.Arrays;

/* JADX INFO: loaded from: classes14.dex */
public class SQLiteInstrumentation {
    public static final String SQLITE = "sqlite";

    public SQLiteInstrumentation() {
    }

    public static Cursor rawQuery(SQLiteDatabase r100, String r101, String[] r102) {
        TraceMachine.enterMethod(SQLITE, "rawQuery", "db_trace");
        Cursor r103 = r100.rawQuery(r101, r102);
        TraceMachine.exitMethod(r101);
        return r103;
    }

    public static Cursor rawQuery(SQLiteDatabase r100, String r101, String[] r102, CancellationSignal r103) {
        TraceMachine.enterMethod(SQLITE, "rawQuery", "db_trace");
        Cursor r104 = r100.rawQuery(r101, r102);
        TraceMachine.exitMethod(r101);
        return r104;
    }

    public static Cursor rawQueryWithFactory(SQLiteDatabase r100, SQLiteDatabase.CursorFactory r101, String r102, String[] r103, String r104) {
        TraceMachine.enterMethod(SQLITE, "rawQueryWithFactory", "db_trace");
        Cursor r105 = r100.rawQueryWithFactory(r101, r102, r103, r104);
        TraceMachine.exitMethod(r102 + Arrays.toString(r103));
        return r105;
    }

    public static Cursor rawQueryWithFactory(SQLiteDatabase r100, SQLiteDatabase.CursorFactory r101, String r102, String[] r103, String r104, CancellationSignal r105) {
        TraceMachine.enterMethod(SQLITE, "rawQueryWithFactory", "db_trace");
        Cursor r106 = r100.rawQueryWithFactory(r101, r102, r103, r104, r105);
        TraceMachine.exitMethod(r102 + Arrays.toString(r103));
        return r106;
    }

    public static Cursor query(SQLiteDatabase r110, String r111, String[] r112, String r113, String[] r114, String r115, String r116, String r117) {
        TraceMachine.enterMethod(SQLITE, "query", "db_trace");
        Cursor r100 = r110.query(r111, r112, r113, r114, r115, r116, r117);
        TraceMachine.exitMethod(combineQuery(false, r111, r112, r113, r114, r115, r116, r117, null));
        return r100;
    }

    private static String combineQuery(boolean r100, String r101, String[] r102, String r103, String[] r104, String r105, String r106, String r107, String r108) {
        return "distinct: " + r100 + " table: " + r101 + " columns: " + Arrays.toString(r102) + " selection: " + r103 + " selectionArgs: " + Arrays.toString(r104);
    }

    public static Cursor query(SQLiteDatabase r110, String r111, String[] r112, String r113, String[] r114, String r115, String r116, String r117, String r118) {
        TraceMachine.enterMethod(SQLITE, "query", "db_trace");
        Cursor r100 = r110.query(r111, r112, r113, r114, r115, r116, r117, r118);
        TraceMachine.exitMethod(combineQuery(false, r111, r112, r113, r114, r115, r116, r117, r118));
        return r100;
    }

    public static Cursor query(SQLiteDatabase r100, boolean r101, String r102, String[] r103, String r104, String[] r105, String r106, String r110, String r111, String r112) {
        TraceMachine.enterMethod(SQLITE, "query", "db_trace");
        Cursor r107 = r100.query(r101, r102, r103, r104, r105, r106, r110, r111, r112);
        TraceMachine.exitMethod(combineQuery(r101, r102, r103, r104, r105, r106, r110, r111, r112));
        return r107;
    }

    public static Cursor queryWithFactory(SQLiteDatabase r110, SQLiteDatabase.CursorFactory r111, boolean r112, String r113, String[] r114, String r115, String[] r116, String r117, String r118, String r119, String r210, CancellationSignal r211) {
        TraceMachine.enterMethod(SQLITE, "queryWithFactory", "db_trace");
        Cursor r100 = r110.queryWithFactory(r111, r112, r113, r114, r115, r116, r117, r118, r119, r210, r211);
        TraceMachine.exitMethod(combineQuery(false, r113, r114, r115, r116, r117, r118, r119, r210));
        return r100;
    }
}
