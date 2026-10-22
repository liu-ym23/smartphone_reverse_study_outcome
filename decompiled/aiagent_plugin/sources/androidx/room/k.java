package androidx.room;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: QueryInterceptorOpenHelper.java */
/* JADX INFO: loaded from: classes.dex */
final class k implements d, androidx.sqlite.db.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final androidx.sqlite.db.d f2656a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final p.f f2657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Executor f2658c;

    k(androidx.sqlite.db.d r3, p.f r4, Executor r5) {
        androidx.sqlite.db.d r6 = (androidx.sqlite.db.d) ZeusTransformUtils.wrapperContextForParams(r3, androidx.sqlite.db.d.class, "com.obric.aiagent.plugin");
        p.f r7 = (p.f) ZeusTransformUtils.wrapperContextForParams(r4, p.f.class, "com.obric.aiagent.plugin");
        Executor r8 = (Executor) ZeusTransformUtils.wrapperContextForParams(r5, Executor.class, "com.obric.aiagent.plugin");
        this.f2656a = r6;
        this.f2657b = r7;
        this.f2658c = r8;
    }

    @Override // androidx.sqlite.db.d
    public String a() {
        return this.f2656a.a();
    }

    @Override // androidx.sqlite.db.d
    public void a(boolean r1) {
        this.f2656a.a(r1);
    }

    @Override // androidx.sqlite.db.d
    public androidx.sqlite.db.c b() {
        return new j(this.f2656a.b(), this.f2657b, this.f2658c);
    }

    @Override // androidx.sqlite.db.d
    public androidx.sqlite.db.c c() {
        return new j(this.f2656a.c(), this.f2657b, this.f2658c);
    }

    @Override // androidx.sqlite.db.d, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f2656a.close();
    }

    @Override // androidx.room.d
    public androidx.sqlite.db.d e() {
        return this.f2656a;
    }
}
