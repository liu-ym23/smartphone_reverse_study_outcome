package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: EventLoop.common.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class cz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final cz f39215a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ThreadLocal<bj> f39216b = null;

    private cz() {
    }

    static {
        f39215a = new cz();
        f39216b = kotlinx.coroutines.internal.aq.a(new kotlinx.coroutines.internal.al("ThreadLocalEventLoop"));
    }

    public final bj a() {
        ThreadLocal<bj> r3 = f39216b;
        bj r0 = (bj) ZeusTransformUtils.preCheckCast(r3.get(), bj.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        bj r1 = bm.a();
        r3.set(r1);
        return r1;
    L6:
        return r0;
    }

    public final bj b() {
        return (bj) ZeusTransformUtils.preCheckCast(f39216b.get(), bj.class, "com.obric.aiagent.plugin");
    }

    public final void c() {
        f39216b.set(null);
    }

    public final void a(bj r1) {
        f39216b.set(r1);
    }
}
