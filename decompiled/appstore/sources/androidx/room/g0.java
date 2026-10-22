package androidx.room;

import androidx.sqlite.db.SupportSQLiteProgram;
import com.bytedance.apm.constant.CommonKey;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class g0 implements SupportSQLiteProgram {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f4553a;

    public g0() {
        this.f4553a = new ArrayList();
    }

    public final List a() {
        return this.f4553a;
    }

    public final void b(int r10, Object r11) {
        int r12 = r10 - 1;
        if (r12 < this.f4553a.size()) goto L9;
        int r13 = this.f4553a.size();
        if (r13 > r12) goto L9;
    L6:
        this.f4553a.add(null);
        if (r13 == r12) goto L9;
        r13 = r13 + 1;
    L9:
        this.f4553a.set(r12, r11);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int r10, byte[] r11) {
        kotlin.jvm.internal.q.g(r11, CommonKey.KEY_VALUE);
        b(r10, r11);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int r10, double r11) {
        b(r10, Double.valueOf(r11));
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int r10, long r11) {
        b(r10, Long.valueOf(r11));
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int r10) {
        b(r10, null);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int r10, String r11) {
        kotlin.jvm.internal.q.g(r11, CommonKey.KEY_VALUE);
        b(r10, r11);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        this.f4553a.clear();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
