package androidx.work.impl;

import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.monitor.cloudmessage.consts.CloudControlInf;

/* JADX INFO: loaded from: classes.dex */
public final class c extends RoomDatabase.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f5500a = null;

    static {
        f5500a = new c();
    }

    public c() {
    }

    @Override // androidx.room.RoomDatabase.b
    public void c(SupportSQLiteDatabase r10) {
        kotlin.jvm.internal.q.g(r10, CloudControlInf.DB);
        super.c(r10);
        r10.beginTransaction();
        r10.execSQL(e());     // Catch: Throwable -> L6
        r10.setTransactionSuccessful();     // Catch: Throwable -> L6
        r10.endTransaction();
        return;
    L6:
        th = move-exception;
        r10.endTransaction();
        throw th;
    }

    public final long d() {
        return System.currentTimeMillis() - x.a();
    }

    public final String e() {
        return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (last_enqueue_time + minimum_retention_duration) < " + d() + " AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
    }
}
