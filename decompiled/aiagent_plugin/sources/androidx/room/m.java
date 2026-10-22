package androidx.room;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: QueryInterceptorProgram.java */
/* JADX INFO: loaded from: classes.dex */
final class m implements androidx.sqlite.db.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<Object> f2662a;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    m() {
        this.f2662a = new ArrayList();
    }

    @Override // androidx.sqlite.db.e
    public void a(int r2) {
        a(r2, null);
    }

    @Override // androidx.sqlite.db.e
    public void a(int r1, long r2) {
        a(r1, Long.valueOf(r2));
    }

    @Override // androidx.sqlite.db.e
    public void a(int r1, double r2) {
        a(r1, Double.valueOf(r2));
    }

    @Override // androidx.sqlite.db.e
    public void a(int r1, String r2) {
        a(r1, r2);
    }

    @Override // androidx.sqlite.db.e
    public void a(int r1, byte[] r2) {
        a(r1, r2);
    }

    private void a(int r4, Object r5) {
        int r6 = r4 - 1;
        if (r6 < this.f2662a.size()) goto L7;
        int r0 = this.f2662a.size();
    L5:
        if (r0 > r6) goto L7;
        this.f2662a.add(null);
        r0 = r0 + 1;
    L7:
        this.f2662a.set(r6, r5);
    }

    List<Object> a() {
        return this.f2662a;
    }
}
