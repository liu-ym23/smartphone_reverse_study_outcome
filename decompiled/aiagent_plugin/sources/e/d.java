package e;

import com.bytedance.apm.battery.dao.DBHelper;

/* JADX INFO: compiled from: Okio.kt */
/* JADX INFO: loaded from: classes4.dex */
final class d implements y {
    @Override // e.y, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // e.y, java.io.Flushable
    public void flush() {
    }

    public d() {
    }

    @Override // e.y
    public void a_(e r1, long r2) {
        d.h.b.o.e(r1, DBHelper.BATTERY_COL_SOURCE);
        r1.h(r2);
    }

    @Override // e.y
    public ab a() {
        return ab.f38700d;
    }
}
