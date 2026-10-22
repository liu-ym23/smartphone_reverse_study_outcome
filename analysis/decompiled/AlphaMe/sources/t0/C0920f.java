package t0;

import h0.AbstractC0587a;
import k0.InterfaceC0674b;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: t0.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0920f extends AbstractC0587a {

    /* renamed from: a, reason: collision with root package name */
    public static final C0920f f15385a = new C0920f(12, 13);

    @Override // h0.AbstractC0587a
    public final void migrate(InterfaceC0674b db) {
        Intrinsics.checkNotNullParameter(db, "db");
        db.execSQL("UPDATE workspec SET required_network_type = 0 WHERE required_network_type IS NULL ");
        db.execSQL("UPDATE workspec SET content_uri_triggers = x'' WHERE content_uri_triggers is NULL");
    }
}
