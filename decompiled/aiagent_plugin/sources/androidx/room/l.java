package androidx.room;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: QueryInterceptorOpenHelperFactory.java */
/* JADX INFO: loaded from: classes.dex */
final class l implements androidx.sqlite.db.d.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final androidx.sqlite.db.d.c f2659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final p.f f2660b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Executor f2661c;

    l(androidx.sqlite.db.d.c r3, p.f r4, Executor r5) {
        androidx.sqlite.db.d.c r6 = (androidx.sqlite.db.d.c) ZeusTransformUtils.wrapperContextForParams(r3, androidx.sqlite.db.d.c.class, "com.obric.aiagent.plugin");
        p.f r7 = (p.f) ZeusTransformUtils.wrapperContextForParams(r4, p.f.class, "com.obric.aiagent.plugin");
        Executor r8 = (Executor) ZeusTransformUtils.wrapperContextForParams(r5, Executor.class, "com.obric.aiagent.plugin");
        this.f2659a = r6;
        this.f2660b = r7;
        this.f2661c = r8;
    }

    @Override // androidx.sqlite.db.d.c
    public androidx.sqlite.db.d b(androidx.sqlite.db.d.b r3) {
        return new k(this.f2659a.b(r3), this.f2660b, this.f2661c);
    }
}
