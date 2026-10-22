package androidx.room;

import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class f0 implements SupportSQLiteOpenHelper.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SupportSQLiteOpenHelper.Factory f4550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f4551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RoomDatabase.QueryCallback f4552c;

    public f0(SupportSQLiteOpenHelper.Factory r10, Executor r11, RoomDatabase.QueryCallback r12) {
        kotlin.jvm.internal.q.g(r10, "delegate");
        kotlin.jvm.internal.q.g(r11, "queryCallbackExecutor");
        kotlin.jvm.internal.q.g(r12, "queryCallback");
        this.f4550a = r10;
        this.f4551b = r11;
        this.f4552c = r12;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    public SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.b r10) {
        kotlin.jvm.internal.q.g(r10, "configuration");
        return new e0(this.f4550a.create(r10), this.f4551b, this.f4552c);
    }
}
