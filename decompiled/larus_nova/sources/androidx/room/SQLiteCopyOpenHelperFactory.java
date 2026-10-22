package androidx.room;

import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes6.dex */
class SQLiteCopyOpenHelperFactory implements SupportSQLiteOpenHelper.Factory {
    private final String mCopyFromAssetPath;
    private final File mCopyFromFile;
    private final Callable<InputStream> mCopyFromInputStream;
    private final SupportSQLiteOpenHelper.Factory mDelegate;

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    public SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration r100) {
        return new SQLiteCopyOpenHelper(r100.context, this.mCopyFromAssetPath, this.mCopyFromFile, this.mCopyFromInputStream, r100.callback.version, this.mDelegate.create(r100));
    }

    public SQLiteCopyOpenHelperFactory(String r100, File r101, Callable<InputStream> r102, SupportSQLiteOpenHelper.Factory r103) {
        this.mCopyFromAssetPath = r100;
        this.mCopyFromFile = r101;
        this.mCopyFromInputStream = r102;
        this.mDelegate = r103;
    }
}
