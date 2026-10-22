package okhttp3.internal.b;

import com.bytedance.apm.battery.dao.DBHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;
import e.i;
import e.y;
import java.io.IOException;

/* JADX INFO: compiled from: FaultHidingSink.kt */
/* JADX INFO: loaded from: classes4.dex */
public class e extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.h.a.b<IOException, x> f39831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f39832b;

    public e(y r3, d.h.a.b<? super IOException, x> r4) {
        y r5 = (y) ZeusTransformUtils.wrapperContextForParams(r3, y.class, "com.obric.aiagent.plugin");
        d.h.a.b<IOException, x> r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r5, "delegate");
        o.e(r6, "onException");
        super(r5);
        this.f39831a = r6;
    }

    @Override // e.i, e.y
    public void a_(e.e r2, long r3) {
        o.e(r2, DBHelper.BATTERY_COL_SOURCE);
        if (this.f39832b == false) goto L11;
        r2.h(r3);
        return;
    L11:
        super.a_(r2, r3);     // Catch: IOException -> L8
        return;
    L8:
        e = move-exception;
        this.f39832b = true;
        this.f39831a.invoke(e);
    }

    @Override // e.i, e.y, java.io.Flushable
    public void flush() {
        if (this.f39832b == false) goto L10;
        return;
    L10:
        super.flush();     // Catch: IOException -> L7
        return;
    L7:
        e = move-exception;
        this.f39832b = true;
        this.f39831a.invoke(e);
    }

    @Override // e.i, e.y, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f39832b == false) goto L10;
        return;
    L10:
        super.close();     // Catch: IOException -> L7
        return;
    L7:
        e = move-exception;
        this.f39832b = true;
        this.f39831a.invoke(e);
    }
}
