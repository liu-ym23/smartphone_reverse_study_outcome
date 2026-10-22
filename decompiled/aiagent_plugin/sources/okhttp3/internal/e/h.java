package okhttp3.internal.e;

import com.bytedance.apm.battery.dao.DBHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import okhttp3.ae;
import okhttp3.x;

/* JADX INFO: compiled from: RealResponseBody.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class h extends ae {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f39929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f39930c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final e.g f39931d;

    public h(String r3, long r4, e.g r6) {
        e.g r7 = (e.g) ZeusTransformUtils.wrapperContextForParams(r6, e.g.class, "com.obric.aiagent.plugin");
        o.e(r7, DBHelper.BATTERY_COL_SOURCE);
        this.f39929b = r3;
        this.f39930c = r4;
        this.f39931d = r7;
    }

    @Override // okhttp3.ae
    public long c() {
        return this.f39930c;
    }

    @Override // okhttp3.ae
    public x b() {
        String r1 = this.f39929b;
        if (r1 != null) goto L7;
        return null;
    L7:
        return x.f40220a.b(r1);
    }

    @Override // okhttp3.ae
    public e.g d() {
        return this.f39931d;
    }
}
