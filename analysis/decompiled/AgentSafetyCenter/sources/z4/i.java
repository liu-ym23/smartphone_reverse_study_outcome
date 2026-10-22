package z4;

import android.database.sqlite.SQLiteProgram;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class i implements y4.d {

    /* renamed from: c, reason: collision with root package name */
    public SQLiteProgram f16408c;

    @Override // y4.d
    public final void B(int i) {
        this.f16408c.bindNull(i);
    }

    @Override // y4.d
    public final void c(int i, long j10) {
        this.f16408c.bindLong(i, j10);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f16408c.close();
    }

    @Override // y4.d
    public final void h(int i, String str) {
        str.getClass();
        this.f16408c.bindString(i, str);
    }

    @Override // y4.d
    public final void j(int i, double d7) {
        this.f16408c.bindDouble(i, d7);
    }

    @Override // y4.d
    public final void s(int i, byte[] bArr) {
        this.f16408c.bindBlob(i, bArr);
    }
}
