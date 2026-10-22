package e0;

import android.database.sqlite.SQLiteProgram;
import d0.InterfaceC0649d;

/* renamed from: e0.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0680d implements InterfaceC0649d {

    /* renamed from: a, reason: collision with root package name */
    private final SQLiteProgram f16644a;

    C0680d(SQLiteProgram sQLiteProgram) {
        this.f16644a = sQLiteProgram;
    }

    @Override // d0.InterfaceC0649d
    public void F(int i5, byte[] bArr) {
        this.f16644a.bindBlob(i5, bArr);
    }

    @Override // d0.InterfaceC0649d
    public void Z(int i5) {
        this.f16644a.bindNull(i5);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f16644a.close();
    }

    @Override // d0.InterfaceC0649d
    public void l(int i5, String str) {
        this.f16644a.bindString(i5, str);
    }

    @Override // d0.InterfaceC0649d
    public void q(int i5, double d6) {
        this.f16644a.bindDouble(i5, d6);
    }

    @Override // d0.InterfaceC0649d
    public void z(int i5, long j5) {
        this.f16644a.bindLong(i5, j5);
    }
}
