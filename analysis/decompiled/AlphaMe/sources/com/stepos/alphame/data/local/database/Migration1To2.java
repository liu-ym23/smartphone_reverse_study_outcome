package com.stepos.alphame.data.local.database;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import ch.qos.logback.core.CoreConstants;
import h0.AbstractC0587a;
import k0.InterfaceC0674b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0006R\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\t8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/stepos/alphame/data/local/database/Migration1To2;", "Lh0/a;", "Lk0/b;", "database", "", "migrateData", "(Lk0/b;)V", "Landroid/database/Cursor;", "cursor", "", "name1", "name2", "getSafeStringCompatible", "(Landroid/database/Cursor;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "migrate", "Landroid/content/Context;", CoreConstants.CONTEXT_SCOPE_VALUE, "Landroid/content/Context;", "TAG", "Ljava/lang/String;", "<init>", "(Landroid/content/Context;)V", "data_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
public final class Migration1To2 extends AbstractC0587a {

    @NotNull
    private final String TAG;

    @NotNull
    private final Context context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Migration1To2(@NotNull Context context) {
        super(1, 2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.TAG = "MigrationDebug";
    }

    private final String getSafeStringCompatible(Cursor cursor, String name1, String name2) {
        int columnIndex = cursor.getColumnIndex(name1);
        if (columnIndex == -1) {
            columnIndex = cursor.getColumnIndex(name2);
        }
        if (columnIndex == -1 || cursor.isNull(columnIndex)) {
            return null;
        }
        return cursor.getString(columnIndex);
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void migrateData(k0.InterfaceC0674b r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 452
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.alphame.data.local.database.Migration1To2.migrateData(k0.b):void");
    }

    @Override // h0.AbstractC0587a
    public void migrate(@NotNull InterfaceC0674b database) throws Exception {
        Intrinsics.checkNotNullParameter(database, "database");
        Log.e(this.TAG, "========== start migrate ==========");
        try {
            database.execSQL("ALTER TABLE `daily_usage` RENAME TO `temp_old_daily_usage`");
            database.execSQL("CREATE TABLE IF NOT EXISTS `daily_usage` (\n    `id` TEXT NOT NULL, \n    `date` INTEGER NOT NULL, \n    `mode` INTEGER NOT NULL, \n    `user_id` INTEGER NOT NULL, \n    `time_usage_path` TEXT, \n    `screen_usage_path` TEXT, \n    `notification_usage_path` TEXT,\n    PRIMARY KEY(`id`)\n)");
            migrateData(database);
            database.execSQL("DROP TABLE `temp_old_daily_usage`");
            Log.e(this.TAG, "========== migrate end ==========");
        } catch (Exception e4) {
            Log.e(this.TAG, "migrate fail", e4);
            throw e4;
        }
    }
}
