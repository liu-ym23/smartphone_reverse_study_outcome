package t0;

import h0.AbstractC0587a;
import k0.InterfaceC0674b;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: t0.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0927m extends AbstractC0587a {

    /* renamed from: a, reason: collision with root package name */
    public static final C0927m f15392a = new C0927m(7, 8);

    @Override // h0.AbstractC0587a
    public final void migrate(InterfaceC0674b db) {
        Intrinsics.checkNotNullParameter(db, "db");
        db.execSQL("\n    CREATE INDEX IF NOT EXISTS `index_WorkSpec_period_start_time` ON `workspec`(`period_start_time`)\n    ");
    }
}
