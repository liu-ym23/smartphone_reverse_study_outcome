package com.obric.cloudsdk.kv.room;

import android.content.Context;
import androidx.room.Room;
import androidx.room.migration.Migration;
import com.obric.cloudsdk.kv.SdkGlobals;
import kotlin.Metadata;

/* JADX INFO: compiled from: DbManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/cloudsdk/kv/room/DbManager;", "", "()V", "DATABASE_NAME", "", "MIGRATION_1_2", "Landroidx/room/migration/Migration;", "TAG", "absDatabase", "Lcom/obric/cloudsdk/kv/room/AbsDatabase;", "getInstance", "context", "Landroid/content/Context;", "cloudsdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DbManager {
    private static final String DATABASE_NAME = "kv_sync_database.db";
    public static final DbManager INSTANCE = null;
    private static final Migration MIGRATION_1_2 = null;
    private static final String TAG = "DbManager";
    private static AbsDatabase absDatabase;

    private DbManager() {
    }

    public static /* synthetic */ AbsDatabase getInstance$default(DbManager r0, Context r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = null;
    L6:
        return r0.getInstance(r1);
    }

    public final synchronized AbsDatabase getInstance(Context r4) {
        monitor-enter(this);
        AbsDatabase r0 = absDatabase;     // Catch: Throwable -> L12
        if (r0 == null) goto L7;
        monitor-exit(this);
        return r0;
    L7:
        if (r4 != null) goto L9;
        r4 = SdkGlobals.INSTANCE.getContext();     // Catch: Throwable -> L12
    L9:
        AbsDatabase r5 = (AbsDatabase) Room.databaseBuilder(r4, AbsDatabase.class, DATABASE_NAME).addMigrations(new Migration[]{MIGRATION_1_2}).build();     // Catch: Throwable -> L12
        absDatabase = r5;     // Catch: Throwable -> L12
        monitor-exit(this);
        return r5;
    L12:
        th = move-exception;
        throw th;
    }

    static {
        INSTANCE = new DbManager();
        MIGRATION_1_2 = new DbManager$MIGRATION_1_2$1();
    }
}
