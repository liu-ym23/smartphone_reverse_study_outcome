package n3;

import android.database.sqlite.SQLiteProgram;
import q7.k;

/* loaded from: classes.dex */
public class i implements m3.b {

    /* renamed from: f, reason: collision with root package name */
    public final SQLiteProgram f6835f;

    public i(SQLiteProgram sQLiteProgram) {
        k.e(sQLiteProgram, "delegate");
        this.f6835f = sQLiteProgram;
    }

    @Override // m3.b
    public final void G(int i2, long j2) {
        this.f6835f.bindLong(i2, j2);
    }

    @Override // m3.b
    public final void I(int i2, byte[] bArr) {
        this.f6835f.bindBlob(i2, bArr);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f6835f.close();
    }

    @Override // m3.b
    public final void l(int i2, String str) {
        k.e(str, "value");
        this.f6835f.bindString(i2, str);
    }

    @Override // m3.b
    public final void u(int i2) {
        this.f6835f.bindNull(i2);
    }

    @Override // m3.b
    public final void x(int i2, double d6) {
        this.f6835f.bindDouble(i2, d6);
    }
}
