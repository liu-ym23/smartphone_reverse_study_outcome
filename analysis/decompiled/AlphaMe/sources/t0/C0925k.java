package t0;

import h0.AbstractC0587a;
import k0.InterfaceC0674b;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: t0.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0925k extends AbstractC0587a {

    /* renamed from: a, reason: collision with root package name */
    public static final C0925k f15390a = new C0925k(4, 5);

    @Override // h0.AbstractC0587a
    public final void migrate(InterfaceC0674b db) {
        Intrinsics.checkNotNullParameter(db, "db");
        db.execSQL("ALTER TABLE workspec ADD COLUMN `trigger_content_update_delay` INTEGER NOT NULL DEFAULT -1");
        db.execSQL("ALTER TABLE workspec ADD COLUMN `trigger_max_content_delay` INTEGER NOT NULL DEFAULT -1");
    }
}
