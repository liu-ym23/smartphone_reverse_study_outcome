package androidx.room;

import androidx.sqlite.db.SupportSQLiteOpenHelper;

/* JADX INFO: loaded from: classes6.dex */
final class AutoClosingRoomOpenHelperFactory implements SupportSQLiteOpenHelper.Factory {
    private final AutoCloser mAutoCloser;
    private final SupportSQLiteOpenHelper.Factory mDelegate;

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    public AutoClosingRoomOpenHelper create(SupportSQLiteOpenHelper.Configuration r100) {
        return new AutoClosingRoomOpenHelper(this.mDelegate.create(r100), this.mAutoCloser);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    public /* bridge */ /* synthetic */ SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration r100) {
        return create(r100);
    }

    public AutoClosingRoomOpenHelperFactory(SupportSQLiteOpenHelper.Factory r100, AutoCloser r101) {
        this.mDelegate = r100;
        this.mAutoCloser = r101;
    }
}
