package t0;

import h0.AbstractC0587a;
import k0.InterfaceC0674b;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: t0.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0919e extends AbstractC0587a {

    /* renamed from: a, reason: collision with root package name */
    public static final C0919e f15384a = new C0919e(11, 12);

    @Override // h0.AbstractC0587a
    public final void migrate(InterfaceC0674b db) {
        Intrinsics.checkNotNullParameter(db, "db");
        db.execSQL("ALTER TABLE workspec ADD COLUMN `out_of_quota_policy` INTEGER NOT NULL DEFAULT 0");
    }
}
