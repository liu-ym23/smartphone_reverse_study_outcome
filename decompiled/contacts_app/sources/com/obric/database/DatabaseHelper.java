package com.obric.database;

import android.content.Context;
import com.obric.database.helper.CallSummaryCompressDBHelper;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DatabaseHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/obric/database/DatabaseHelper;", "", "()V", "<set-?>", "Lcom/obric/database/helper/CallSummaryCompressDBHelper;", "callSummaryCompressDBHelper", "getCallSummaryCompressDBHelper", "()Lcom/obric/database/helper/CallSummaryCompressDBHelper;", "init", "", "context", "Landroid/content/Context;", "initCallSummaryDB", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DatabaseHelper {
    public static final DatabaseHelper INSTANCE = null;
    private static CallSummaryCompressDBHelper callSummaryCompressDBHelper;

    static {
        INSTANCE = new DatabaseHelper();
    }

    private DatabaseHelper() {
    }

    public final CallSummaryCompressDBHelper getCallSummaryCompressDBHelper() {
        return callSummaryCompressDBHelper;
    }

    @JvmStatic
    public static final void init(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        INSTANCE.initCallSummaryDB(r1);
    }

    private final synchronized void initCallSummaryDB(Context r2) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (callSummaryCompressDBHelper == null) goto L7;
        monitor-exit(this);
        return;
    L7:
        callSummaryCompressDBHelper = new CallSummaryCompressDBHelper(r2);     // Catch: Throwable -> L10
        monitor-exit(this);
    }
}
