package z1;

import android.database.sqlite.SQLiteProgram;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class d implements y1.d {

    /* renamed from: a, reason: collision with root package name */
    public final SQLiteProgram f14216a;

    public d(SQLiteProgram delegate) {
        g.f(delegate, "delegate");
        this.f14216a = delegate;
    }

    @Override // y1.d
    public final void F(byte[] bArr, int i10) {
        this.f14216a.bindBlob(i10, bArr);
    }

    @Override // y1.d
    public final void Y(int i10, String value) {
        g.f(value, "value");
        this.f14216a.bindString(i10, value);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f14216a.close();
    }

    @Override // y1.d
    public final void h0(int i10, long j10) {
        this.f14216a.bindLong(i10, j10);
    }

    @Override // y1.d
    public final void s(int i10, double d8) {
        this.f14216a.bindDouble(i10, d8);
    }

    @Override // y1.d
    public final void v0(int i10) {
        this.f14216a.bindNull(i10);
    }
}
