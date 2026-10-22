package androidx.work.impl;

import android.content.Context;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.monitor.cloudmessage.consts.CloudControlInf;

/* JADX INFO: loaded from: classes.dex */
public final class d0 extends a0.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f5555c;

    public d0(Context r10) {
        kotlin.jvm.internal.q.g(r10, "context");
        super(9, 10);
        this.f5555c = r10;
    }

    @Override // a0.a
    public void a(SupportSQLiteDatabase r10) {
        kotlin.jvm.internal.q.g(r10, CloudControlInf.DB);
        r10.execSQL("CREATE TABLE IF NOT EXISTS `Preference` (`key` TEXT NOT NULL, `long_value` INTEGER, PRIMARY KEY(`key`))");
        androidx.work.impl.utils.m.c(this.f5555c, r10);
        androidx.work.impl.utils.h.c(this.f5555c, r10);
    }
}
