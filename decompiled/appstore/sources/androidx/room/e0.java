package androidx.room;

import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class e0 implements SupportSQLiteOpenHelper, DelegatingOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SupportSQLiteOpenHelper f4545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f4546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RoomDatabase.QueryCallback f4547c;

    public e0(SupportSQLiteOpenHelper r10, Executor r11, RoomDatabase.QueryCallback r12) {
        kotlin.jvm.internal.q.g(r10, "delegate");
        kotlin.jvm.internal.q.g(r11, "queryCallbackExecutor");
        kotlin.jvm.internal.q.g(r12, "queryCallback");
        this.f4545a = r10;
        this.f4546b = r11;
        this.f4547c = r12;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f4545a.close();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public String getDatabaseName() {
        return this.f4545a.getDatabaseName();
    }

    @Override // androidx.room.DelegatingOpenHelper
    public SupportSQLiteOpenHelper getDelegate() {
        return this.f4545a;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getReadableDatabase() {
        return new d0(getDelegate().getReadableDatabase(), this.f4546b, this.f4547c);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getWritableDatabase() {
        return new d0(getDelegate().getWritableDatabase(), this.f4546b, this.f4547c);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public void setWriteAheadLoggingEnabled(boolean r10) {
        this.f4545a.setWriteAheadLoggingEnabled(r10);
    }
}
