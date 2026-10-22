package androidx.work.impl;

import androidx.sqlite.db.SupportSQLiteDatabase;
import com.monitor.cloudmessage.consts.CloudControlInf;

/* JADX INFO: loaded from: classes.dex */
public final class l extends a0.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final l f5627c = null;

    static {
        f5627c = new l();
    }

    public l() {
        super(7, 8);
    }

    @Override // a0.a
    public void a(SupportSQLiteDatabase r10) {
        kotlin.jvm.internal.q.g(r10, CloudControlInf.DB);
        r10.execSQL("\n    CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `workspec`(`period_start_time`)\n    ");
    }
}
