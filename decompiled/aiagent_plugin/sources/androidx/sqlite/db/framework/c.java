package androidx.sqlite.db.framework;

import android.database.sqlite.SQLiteProgram;
import androidx.sqlite.db.e;

/* JADX INFO: compiled from: FrameworkSQLiteProgram.java */
/* JADX INFO: loaded from: classes.dex */
class c implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SQLiteProgram f2749a;

    c(SQLiteProgram r1) {
        this.f2749a = r1;
    }

    @Override // androidx.sqlite.db.e
    public void a(int r1) {
        this.f2749a.bindNull(r1);
    }

    @Override // androidx.sqlite.db.e
    public void a(int r1, long r2) {
        this.f2749a.bindLong(r1, r2);
    }

    @Override // androidx.sqlite.db.e
    public void a(int r1, double r2) {
        this.f2749a.bindDouble(r1, r2);
    }

    @Override // androidx.sqlite.db.e
    public void a(int r1, String r2) {
        this.f2749a.bindString(r1, r2);
    }

    @Override // androidx.sqlite.db.e
    public void a(int r1, byte[] r2) {
        this.f2749a.bindBlob(r1, r2);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f2749a.close();
    }
}
