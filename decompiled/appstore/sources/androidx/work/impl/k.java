package androidx.work.impl;

import androidx.sqlite.db.SupportSQLiteDatabase;
import com.monitor.cloudmessage.consts.CloudControlInf;

/* JADX INFO: loaded from: classes.dex */
public final class k extends a0.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final k f5626c = null;

    static {
        f5626c = new k();
    }

    public k() {
        super(6, 7);
    }

    @Override // a0.a
    public void a(SupportSQLiteDatabase r10) {
        kotlin.jvm.internal.q.g(r10, CloudControlInf.DB);
        r10.execSQL("\n    CREATE TABLE IF NOT EXISTS `WorkProgress` (`work_spec_id` TEXT NOT NULL, `progress`\n    BLOB NOT NULL, PRIMARY KEY(`work_spec_id`), FOREIGN KEY(`work_spec_id`)\n    REFERENCES `WorkSpec`(`id`) ON UPDATE CASCADE ON DELETE CASCADE )\n    ");
    }
}
