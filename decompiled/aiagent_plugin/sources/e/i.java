package e;

import com.bytedance.apm.battery.dao.DBHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ForwardingSink.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class i implements y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final y f38727a;

    public i(y r3) {
        y r4 = (y) ZeusTransformUtils.wrapperContextForParams(r3, y.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "delegate");
        this.f38727a = r4;
    }

    @Override // e.y
    public void a_(e r2, long r3) {
        d.h.b.o.e(r2, DBHelper.BATTERY_COL_SOURCE);
        this.f38727a.a_(r2, r3);
    }

    @Override // e.y, java.io.Flushable
    public void flush() {
        this.f38727a.flush();
    }

    @Override // e.y
    public ab a() {
        return this.f38727a.a();
    }

    @Override // e.y, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f38727a.close();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.f38727a + ')';
    }
}
