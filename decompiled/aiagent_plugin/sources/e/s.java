package e;

import com.bytedance.apm.battery.dao.DBHelper;
import java.io.OutputStream;

/* JADX INFO: compiled from: JvmOkio.kt */
/* JADX INFO: loaded from: classes4.dex */
final class s implements y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final OutputStream f38745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ab f38746b;

    public s(OutputStream r2, ab r3) {
        d.h.b.o.e(r2, "out");
        d.h.b.o.e(r3, "timeout");
        this.f38745a = r2;
        this.f38746b = r3;
    }

    @Override // e.y
    public void a_(e r8, long r9) {
        d.h.b.o.e(r8, DBHelper.BATTERY_COL_SOURCE);
        b.a(r8.b(), 0, r9);
    L4:
        if (r9 <= 0) goto L8;
        this.f38746b.x_();
        v r0 = r8.f38713a;
        d.h.b.o.a(r0);
        int r1 = (int) Math.min(r9, r0.f38758d - r0.f38757c);
        this.f38745a.write(r0.f38756b, r0.f38757c, r1);
        r0.f38757c += r1;
        long r2 = r1;
        r9 = r9 - r2;
        r8.a(r8.b() - r2);
        if (r0.f38757c != r0.f38758d) goto L4;
        r8.f38713a = r0.c();
        w.a(r0);
        goto L4
    }

    @Override // e.y, java.io.Flushable
    public void flush() {
        this.f38745a.flush();
    }

    @Override // e.y, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f38745a.close();
    }

    @Override // e.y
    public ab a() {
        return this.f38746b;
    }

    public String toString() {
        return "sink(" + this.f38745a + ')';
    }
}
