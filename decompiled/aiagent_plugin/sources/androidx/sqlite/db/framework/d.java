package androidx.sqlite.db.framework;

import android.database.sqlite.SQLiteStatement;
import androidx.sqlite.db.g;

/* JADX INFO: compiled from: FrameworkSQLiteStatement.java */
/* JADX INFO: loaded from: classes.dex */
class d extends c implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SQLiteStatement f2750a;

    d(SQLiteStatement r1) {
        super(r1);
        this.f2750a = r1;
    }

    @Override // androidx.sqlite.db.g
    public int a() {
        return this.f2750a.executeUpdateDelete();
    }

    @Override // androidx.sqlite.db.g
    public long b() {
        return this.f2750a.executeInsert();
    }
}
