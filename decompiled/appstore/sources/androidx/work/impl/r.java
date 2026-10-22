package androidx.work.impl;

import android.content.Context;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.monitor.cloudmessage.consts.CloudControlInf;

/* JADX INFO: loaded from: classes.dex */
public final class r extends a0.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f5772c;

    public r(Context r10, int r11, int r12) {
        kotlin.jvm.internal.q.g(r10, "mContext");
        super(r11, r12);
        this.f5772c = r10;
    }

    @Override // a0.a
    public void a(SupportSQLiteDatabase r10) {
        kotlin.jvm.internal.q.g(r10, CloudControlInf.DB);
        if (this.f6b < 10) goto L5;
        r10.execSQL("INSERT OR REPLACE INTO `Preference` (`key`, `long_value`) VALUES (@key, @long_value)", new Object[]{"reschedule_needed", 1});
        return;
    L5:
        this.f5772c.getSharedPreferences("androidx.work.util.preferences", 0).edit().putBoolean("reschedule_needed", true).apply();
    }
}
