package androidx.work.impl;

import android.content.ContentValues;
import androidx.room.migration.AutoMigrationSpec;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.monitor.cloudmessage.consts.CloudControlInf;

/* JADX INFO: loaded from: classes.dex */
public final class b implements AutoMigrationSpec {
    public b() {
    }

    @Override // androidx.room.migration.AutoMigrationSpec
    public void onPostMigrate(SupportSQLiteDatabase r10) {
        kotlin.jvm.internal.q.g(r10, CloudControlInf.DB);
        r10.execSQL("UPDATE workspec SET period_count = 1 WHERE last_enqueue_time <> 0 AND interval_duration <> 0");
        ContentValues r11 = new ContentValues(1);
        r11.put("last_enqueue_time", Long.valueOf(System.currentTimeMillis()));
        r10.update("WorkSpec", 3, r11, "last_enqueue_time = 0 AND interval_duration <> 0 ", new Object[0]);
    }
}
