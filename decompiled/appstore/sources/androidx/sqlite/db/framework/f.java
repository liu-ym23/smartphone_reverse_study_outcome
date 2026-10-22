package androidx.sqlite.db.framework;

import android.database.sqlite.SQLiteStatement;
import androidx.sqlite.db.SupportSQLiteStatement;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public final class f extends e implements SupportSQLiteStatement {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SQLiteStatement f4820b;

    public f(SQLiteStatement r10) {
        q.g(r10, "delegate");
        super(r10);
        this.f4820b = r10;
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public void execute() {
        this.f4820b.execute();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public long executeInsert() {
        return this.f4820b.executeInsert();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public int executeUpdateDelete() {
        return this.f4820b.executeUpdateDelete();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public long simpleQueryForLong() {
        return this.f4820b.simpleQueryForLong();
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public String simpleQueryForString() {
        return this.f4820b.simpleQueryForString();
    }
}
