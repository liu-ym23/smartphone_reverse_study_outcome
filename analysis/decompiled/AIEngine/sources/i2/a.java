package i2;

import androidx.datastore.preferences.protobuf.b1;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a extends RoomDatabase.b {

    /* renamed from: a, reason: collision with root package name */
    public final b1 f9449a;

    public a(b1 clock) {
        kotlin.jvm.internal.g.f(clock, "clock");
        this.f9449a = clock;
    }

    @Override // androidx.room.RoomDatabase.b
    public final void a(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
        frameworkSQLiteDatabase.l();
        try {
            frameworkSQLiteDatabase.n("DELETE FROM workspec WHERE state IN (2, 3, 5) AND (last_enqueue_time + minimum_retention_duration) < " + (this.f9449a.z() - o.f9483a) + " AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))");
            frameworkSQLiteDatabase.y();
        } finally {
            frameworkSQLiteDatabase.H();
        }
    }
}
