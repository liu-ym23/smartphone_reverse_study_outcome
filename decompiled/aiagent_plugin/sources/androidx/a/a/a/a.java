package androidx.a.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: ArchTaskExecutor.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f89a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Executor f90d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Executor f91e = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f92b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final c f93c;

    public static /* synthetic */ void lambda$Fbf4AXStU7VFQsK5cMBns3esU_4(Runnable r0) {
        c(r0);
    }

    public static /* synthetic */ void lambda$LLafzISc5OdFNo5CYYPhVvLsR9A(Runnable r0) {
        d(r0);
    }

    static {
        f90d = $$Lambda$a$LLafzISc5OdFNo5CYYPhVvLsR9A.INSTANCE;
        f91e = $$Lambda$a$Fbf4AXStU7VFQsK5cMBns3esU_4.INSTANCE;
    }

    private static /* synthetic */ void d(Runnable r2) {
        Runnable r3 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin");
        a().b(r3);
    }

    private static /* synthetic */ void c(Runnable r2) {
        Runnable r3 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin");
        a().a(r3);
    }

    private a() {
        b r0 = new b();
        this.f93c = r0;
        this.f92b = r0;
    }

    public static a a() {
        if (f89a == null) goto L7;
        return f89a;
    L7:
        monitor-enter(a.class);
    L14:
        th = move-exception;
        throw th;
    L9:
        if (f89a != null) goto L11;
        f89a = new a();     // Catch: Throwable -> L14
    L11:
        monitor-exit(a.class);     // Catch: Throwable -> L14
        return f89a;
    }

    @Override // androidx.a.a.a.c
    public void a(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        this.f92b.a(r4);
    }

    @Override // androidx.a.a.a.c
    public void b(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        this.f92b.b(r4);
    }

    public static Executor b() {
        return f91e;
    }

    @Override // androidx.a.a.a.c
    public boolean c() {
        return this.f92b.c();
    }
}
