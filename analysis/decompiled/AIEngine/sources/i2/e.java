package i2;

import android.database.SQLException;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e extends u1.a {

    /* renamed from: c, reason: collision with root package name */
    public static final e f9460c = new e(3, 4);

    @Override // u1.a
    public final void a(FrameworkSQLiteDatabase frameworkSQLiteDatabase) throws SQLException {
        frameworkSQLiteDatabase.n("\n    UPDATE workspec SET schedule_requested_at = 0\n    WHERE state NOT IN (2, 3, 5)\n        AND schedule_requested_at = -1\n        AND interval_duration <> 0\n    ");
    }
}
