package net.zetetic.database.sqlcipher;

import android.database.sqlite.SQLiteDatabaseCorruptException;
import androidx.sqlite.db.SupportSQLiteStatement;

/* loaded from: classes4.dex */
public final class SQLiteStatement extends SQLiteProgram implements SupportSQLiteStatement {
    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public final void execute() {
        b();
        try {
            try {
                this.b.s().d(this.c, this.g, i());
            } catch (SQLiteDatabaseCorruptException e) {
                k();
                throw e;
            }
        } finally {
            f();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public final long executeInsert() {
        b();
        try {
            try {
                return this.b.s().g(this.c, this.g, i());
            } catch (SQLiteDatabaseCorruptException e) {
                k();
                throw e;
            }
        } finally {
            f();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public final int executeUpdateDelete() {
        b();
        try {
            try {
                return this.b.s().e(this.c, this.g, i());
            } catch (SQLiteDatabaseCorruptException e) {
                k();
                throw e;
            }
        } finally {
            f();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public final long simpleQueryForLong() {
        b();
        try {
            try {
                return this.b.s().h(this.c, this.g, i());
            } catch (SQLiteDatabaseCorruptException e) {
                k();
                throw e;
            }
        } finally {
            f();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteStatement
    public final String simpleQueryForString() {
        b();
        try {
            try {
                return this.b.s().i(this.c, this.g, i());
            } catch (SQLiteDatabaseCorruptException e) {
                k();
                throw e;
            }
        } finally {
            f();
        }
    }

    public final String toString() {
        return "SQLiteProgram: " + this.c;
    }
}
