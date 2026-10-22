package androidx.work.impl;

import androidx.sqlite.db.SupportSQLiteDatabase;
import com.monitor.cloudmessage.consts.CloudControlInf;

/* JADX INFO: loaded from: classes.dex */
public final class j extends a0.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final j f5625c = null;

    static {
        f5625c = new j();
    }

    public j() {
        super(4, 5);
    }

    @Override // a0.a
    public void a(SupportSQLiteDatabase r10) {
        kotlin.jvm.internal.q.g(r10, CloudControlInf.DB);
        r10.execSQL("ALTER TABLE workspec ADD COLUMN `trigger_content_update_delay` INTEGER NOT NULL DEFAULT -1");
        r10.execSQL("ALTER TABLE workspec ADD COLUMN `trigger_max_content_delay` INTEGER NOT NULL DEFAULT -1");
    }
}
