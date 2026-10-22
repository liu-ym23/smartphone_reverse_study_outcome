package n3;

import android.database.sqlite.SQLiteStatement;

/* loaded from: classes.dex */
public final class j extends i implements m3.b {

    /* renamed from: g, reason: collision with root package name */
    public final SQLiteStatement f6836g;

    public j(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        this.f6836g = sQLiteStatement;
    }

    public final long a() {
        return this.f6836g.executeInsert();
    }

    public final int b() {
        return this.f6836g.executeUpdateDelete();
    }
}
