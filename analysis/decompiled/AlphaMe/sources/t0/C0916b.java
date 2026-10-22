package t0;

import k0.InterfaceC0674b;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: t0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0916b {

    /* renamed from: a, reason: collision with root package name */
    public final y1.f f15382a;

    public C0916b(y1.f clock) {
        Intrinsics.checkNotNullParameter(clock, "clock");
        this.f15382a = clock;
    }

    public final void a(InterfaceC0674b db) {
        Intrinsics.checkNotNullParameter(db, "db");
        Intrinsics.checkNotNullParameter(db, "db");
        db.beginTransaction();
        try {
            StringBuilder sb = new StringBuilder("DELETE FROM workspec WHERE state IN (2, 3, 5) AND (last_enqueue_time + minimum_retention_duration) < ");
            this.f15382a.getClass();
            sb.append(System.currentTimeMillis() - AbstractC0906A.f15313a);
            sb.append(" AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))");
            db.execSQL(sb.toString());
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
    }
}
