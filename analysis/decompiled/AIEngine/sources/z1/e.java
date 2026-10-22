package z1;

import android.database.sqlite.SQLiteStatement;
import y1.f;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e extends d implements f {

    /* renamed from: b, reason: collision with root package name */
    public final SQLiteStatement f14217b;

    public e(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        this.f14217b = sQLiteStatement;
    }

    @Override // y1.f
    public final long U() {
        return this.f14217b.executeInsert();
    }

    @Override // y1.f
    public final int r() {
        return this.f14217b.executeUpdateDelete();
    }
}
