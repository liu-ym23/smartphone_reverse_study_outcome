package androidx.sqlite.db.framework;

import android.database.sqlite.SQLiteProgram;
import androidx.sqlite.db.SupportSQLiteProgram;
import com.bytedance.apm.constant.CommonKey;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public class e implements SupportSQLiteProgram {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SQLiteProgram f4819a;

    public e(SQLiteProgram r10) {
        q.g(r10, "delegate");
        this.f4819a = r10;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int r10, byte[] r11) {
        q.g(r11, CommonKey.KEY_VALUE);
        this.f4819a.bindBlob(r10, r11);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int r10, double r11) {
        this.f4819a.bindDouble(r10, r11);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int r10, long r11) {
        this.f4819a.bindLong(r10, r11);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int r10) {
        this.f4819a.bindNull(r10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int r10, String r11) {
        q.g(r11, CommonKey.KEY_VALUE);
        this.f4819a.bindString(r10, r11);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        this.f4819a.clearBindings();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f4819a.close();
    }
}
