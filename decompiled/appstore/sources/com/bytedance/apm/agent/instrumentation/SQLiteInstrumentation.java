package com.bytedance.apm.agent.instrumentation;

import android.annotation.TargetApi;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.CancellationSignal;
import com.bytedance.apm.agent.tracing.TraceMachine;
import com.bytedance.apm.constant.AgentConstants;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class SQLiteInstrumentation {
    public static final String SQLITE = "sqlite";

    public SQLiteInstrumentation() {
    }

    private static String combineQuery(boolean r10, String r11, String[] r12, String r13, String[] r14, String r15, String r16, String r17, String r18) {
        return "distinct: " + r10 + " table: " + r11 + " columns: " + Arrays.toString(r12) + " selection: " + r13 + " selectionArgs: " + Arrays.toString(r14);
    }

    public static Cursor query(SQLiteDatabase r10, boolean r11, String r12, String[] r13, String r14, String[] r15, String r16, String r17, String r18, String r19) {
        TraceMachine.enterMethod(SQLITE, "query", AgentConstants.TRACE_TYPE_DB);
        Cursor r20 = r10.query(r11, r12, r13, r14, r15, r16, r17, r18, r19);
        TraceMachine.exitMethod(combineQuery(r11, r12, r13, r14, r15, r16, r17, r18, r19));
        return r20;
    }

    @TargetApi(16)
    public static Cursor queryWithFactory(SQLiteDatabase r10, SQLiteDatabase.CursorFactory r11, boolean r12, String r13, String[] r14, String r15, String[] r16, String r17, String r18, String r19, String r20, CancellationSignal r21) {
        TraceMachine.enterMethod(SQLITE, "queryWithFactory", AgentConstants.TRACE_TYPE_DB);
        Cursor r22 = r10.queryWithFactory(r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21);
        TraceMachine.exitMethod(combineQuery(false, r13, r14, r15, r16, r17, r18, r19, r20));
        return r22;
    }

    public static Cursor rawQuery(SQLiteDatabase r10, String r11, String[] r12) {
        TraceMachine.enterMethod(SQLITE, "rawQuery", AgentConstants.TRACE_TYPE_DB);
        Cursor r13 = r10.rawQuery(r11, r12);
        TraceMachine.exitMethod(r11);
        return r13;
    }

    public static Cursor rawQueryWithFactory(SQLiteDatabase r10, SQLiteDatabase.CursorFactory r11, String r12, String[] r13, String r14) {
        TraceMachine.enterMethod(SQLITE, "rawQueryWithFactory", AgentConstants.TRACE_TYPE_DB);
        Cursor r15 = r10.rawQueryWithFactory(r11, r12, r13, r14);
        TraceMachine.exitMethod(r12 + Arrays.toString(r13));
        return r15;
    }

    public static Cursor query(SQLiteDatabase r10, String r11, String[] r12, String r13, String[] r14, String r15, String r16, String r17) {
        TraceMachine.enterMethod(SQLITE, "query", AgentConstants.TRACE_TYPE_DB);
        Cursor r18 = r10.query(r11, r12, r13, r14, r15, r16, r17);
        TraceMachine.exitMethod(combineQuery(false, r11, r12, r13, r14, r15, r16, r17, null));
        return r18;
    }

    public static Cursor rawQuery(SQLiteDatabase r10, String r11, String[] r12, CancellationSignal r13) {
        TraceMachine.enterMethod(SQLITE, "rawQuery", AgentConstants.TRACE_TYPE_DB);
        Cursor r14 = r10.rawQuery(r11, r12);
        TraceMachine.exitMethod(r11);
        return r14;
    }

    @TargetApi(16)
    public static Cursor rawQueryWithFactory(SQLiteDatabase r10, SQLiteDatabase.CursorFactory r11, String r12, String[] r13, String r14, CancellationSignal r15) {
        TraceMachine.enterMethod(SQLITE, "rawQueryWithFactory", AgentConstants.TRACE_TYPE_DB);
        Cursor r16 = r10.rawQueryWithFactory(r11, r12, r13, r14, r15);
        TraceMachine.exitMethod(r12 + Arrays.toString(r13));
        return r16;
    }

    public static Cursor query(SQLiteDatabase r10, String r11, String[] r12, String r13, String[] r14, String r15, String r16, String r17, String r18) {
        TraceMachine.enterMethod(SQLITE, "query", AgentConstants.TRACE_TYPE_DB);
        Cursor r19 = r10.query(r11, r12, r13, r14, r15, r16, r17, r18);
        TraceMachine.exitMethod(combineQuery(false, r11, r12, r13, r14, r15, r16, r17, r18));
        return r19;
    }
}
