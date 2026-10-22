package net.zetetic.database.sqlcipher;

import androidx.sqlite.db.SupportSQLiteOpenHelper;

/* loaded from: classes4.dex */
public class SupportOpenHelperFactory implements SupportSQLiteOpenHelper.Factory {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f5410a;
    public final SQLiteDatabaseHook b;
    public final boolean c;
    public final int d;

    public SupportOpenHelperFactory(byte[] bArr) {
        this(bArr, null, false);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    public final SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration configuration) {
        int i = this.d;
        if (i == -1) {
            return new SupportHelper(configuration, this.f5410a, this.b, this.c);
        }
        return new SupportHelper(configuration, this.f5410a, this.b, this.c, i);
    }

    public SupportOpenHelperFactory(byte[] bArr, SQLiteDatabaseHook sQLiteDatabaseHook, boolean z10) {
        this(bArr, sQLiteDatabaseHook, z10, -1);
    }

    public SupportOpenHelperFactory(byte[] bArr, SQLiteDatabaseHook sQLiteDatabaseHook, boolean z10, int i) {
        this.f5410a = bArr;
        this.b = sQLiteDatabaseHook;
        this.c = z10;
        this.d = i;
    }
}
