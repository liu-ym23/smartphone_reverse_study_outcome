package androidx.room;

import androidx.sqlite.db.SupportSQLiteProgram;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class QueryInterceptorProgram implements SupportSQLiteProgram {
    private List<Object> mBindArgsCache;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    QueryInterceptorProgram() {
        this.mBindArgsCache = new ArrayList();
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int index) {
        saveArgsToCache(index, null);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int index, long value) {
        saveArgsToCache(index, Long.valueOf(value));
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int index, double value) {
        saveArgsToCache(index, Double.valueOf(value));
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int index, String value) {
        saveArgsToCache(index, value);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int index, byte[] value) {
        saveArgsToCache(index, value);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        this.mBindArgsCache.clear();
    }

    private void saveArgsToCache(int bindIndex, Object value) {
        int r4 = bindIndex - 1;
        if (r4 < this.mBindArgsCache.size()) goto L7;
        int r0 = this.mBindArgsCache.size();
    L5:
        if (r0 > r4) goto L7;
        this.mBindArgsCache.add(null);
        r0 = r0 + 1;
    L7:
        this.mBindArgsCache.set(r4, value);
    }

    List<Object> getBindArgs() {
        return this.mBindArgsCache;
    }
}
