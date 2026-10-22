package androidx.lifecycle;

import com.bytedance.apm.battery.dao.DBHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlinx.coroutines.ca;

/* JADX INFO: compiled from: LifecycleController.kt */
/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i f2059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final i.b f2060b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e f2061c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final m f2062d;

    public static /* synthetic */ void lambda$BVHtf02cQwZ0LbkY5IzNJYuLF2A(j r0, ca r1, p r2, i.a r3) {
        a(r0, r1, r2, r3);
    }

    public j(i r3, i.b r4, e r5, ca r6) {
        final ca r7 = (ca) ZeusTransformUtils.wrapperContextForParams(r6, ca.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "lifecycle");
        d.h.b.o.e(r4, "minState");
        d.h.b.o.e(r5, "dispatchQueue");
        d.h.b.o.e(r7, "parentJob");
        this.f2059a = r3;
        this.f2060b = r4;
        this.f2061c = r5;
        m r8 = new $$Lambda$j$BVHtf02cQwZ0LbkY5IzNJYuLF2A(this, r7);
        this.f2062d = r8;
        if (r3.b() != i.b.f2054a) goto L5;
        ca.a.a(r7, null, 1, null);
        a();
        return;
    L5:
        r3.a((o) ZeusTransformUtils.preCheckCast(r8, o.class, "com.obric.aiagent.plugin"));
    }

    private static final void a(j r2, ca r3, p r4, i.a r5) {
        ca r6 = (ca) ZeusTransformUtils.wrapperContextForParams(r3, ca.class, "com.obric.aiagent.plugin");
        p r7 = (p) ZeusTransformUtils.wrapperContextForParams(r4, p.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r2, "this$0");
        d.h.b.o.e(r6, "$parentJob");
        d.h.b.o.e(r7, DBHelper.BATTERY_COL_SOURCE);
        d.h.b.o.e(r5, "<anonymous parameter 1>");
        if (r7.getLifecycle().b() != i.b.f2054a) goto L6;
        ca.a.a(r6, null, 1, null);
        r2.a();
        return;
    L6:
        if (r7.getLifecycle().b().compareTo((Enum) ZeusTransformUtils.preCheckCast(r2.f2060b, Enum.class, "com.obric.aiagent.plugin")) >= 0) goto L8;
        r2.f2061c.a();
        return;
    L8:
        r2.f2061c.b();
    }

    public final void a() {
        this.f2059a.b((o) ZeusTransformUtils.preCheckCast(this.f2062d, o.class, "com.obric.aiagent.plugin"));
        this.f2061c.c();
    }
}
