package e0;

import android.database.sqlite.SQLiteStatement;
import d0.InterfaceC0651f;

/* renamed from: e0.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0681e extends C0680d implements InterfaceC0651f {

    /* renamed from: b, reason: collision with root package name */
    private final SQLiteStatement f16645b;

    C0681e(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        this.f16645b = sQLiteStatement;
    }

    @Override // d0.InterfaceC0651f
    public int n() {
        return this.f16645b.executeUpdateDelete();
    }

    @Override // d0.InterfaceC0651f
    public long t0() {
        return this.f16645b.executeInsert();
    }
}
