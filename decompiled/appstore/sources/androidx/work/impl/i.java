package androidx.work.impl;

import androidx.sqlite.db.SupportSQLiteDatabase;
import com.monitor.cloudmessage.consts.CloudControlInf;

/* JADX INFO: loaded from: classes.dex */
public final class i extends a0.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final i f5624c = null;

    static {
        f5624c = new i();
    }

    public i() {
        super(3, 4);
    }

    @Override // a0.a
    public void a(SupportSQLiteDatabase r10) {
        kotlin.jvm.internal.q.g(r10, CloudControlInf.DB);
        r10.execSQL("\n    UPDATE workspec SET schedule_requested_at = 0\n    WHERE state NOT IN (2, 3, 5)\n        AND schedule_requested_at = -1\n        AND interval_duration <> 0\n    ");
    }
}
