package androidx.work.impl;

import androidx.sqlite.db.SupportSQLiteDatabase;
import com.monitor.cloudmessage.consts.CloudControlInf;

/* JADX INFO: loaded from: classes.dex */
public final class m extends a0.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final m f5628c = null;

    static {
        f5628c = new m();
    }

    public m() {
        super(8, 9);
    }

    @Override // a0.a
    public void a(SupportSQLiteDatabase r10) {
        kotlin.jvm.internal.q.g(r10, CloudControlInf.DB);
        r10.execSQL("ALTER TABLE workspec ADD COLUMN `run_in_foreground` INTEGER NOT NULL DEFAULT 0");
    }
}
