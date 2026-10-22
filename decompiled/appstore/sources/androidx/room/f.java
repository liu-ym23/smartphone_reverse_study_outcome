package androidx.room;

import androidx.sqlite.db.SupportSQLiteOpenHelper;

/* JADX INFO: loaded from: classes.dex */
public final class f implements SupportSQLiteOpenHelper.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SupportSQLiteOpenHelper.Factory f4548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f4549b;

    public f(SupportSQLiteOpenHelper.Factory r10, e r11) {
        kotlin.jvm.internal.q.g(r10, "delegate");
        kotlin.jvm.internal.q.g(r11, "autoCloser");
        this.f4548a = r10;
        this.f4549b = r11;
    }

    public AutoClosingRoomOpenHelper a(SupportSQLiteOpenHelper.b r10) {
        kotlin.jvm.internal.q.g(r10, "configuration");
        return new AutoClosingRoomOpenHelper(this.f4548a.create(r10), this.f4549b);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    public /* bridge */ /* synthetic */ SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.b r10) {
        return a(r10);
    }
}
