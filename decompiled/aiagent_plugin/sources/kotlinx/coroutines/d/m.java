package kotlinx.coroutines.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.internal.u;

/* JADX INFO: compiled from: Dispatcher.kt */
/* JADX INFO: loaded from: classes4.dex */
final class m extends ai {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f39247a = null;

    static {
        f39247a = new m();
    }

    private m() {
    }

    @Override // kotlinx.coroutines.ai
    public void b(d.c.g r2, Runnable r3) {
        d.c.g r1 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r2, d.c.g.class, "com.obric.aiagent.plugin");
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        c.f39236d.a(r4, l.h, true);
    }

    @Override // kotlinx.coroutines.ai
    public void a(d.c.g r2, Runnable r3) {
        d.c.g r1 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r2, d.c.g.class, "com.obric.aiagent.plugin");
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        c.f39236d.a(r4, l.h, false);
    }

    @Override // kotlinx.coroutines.ai
    public ai a(int r2) {
        u.a(r2);
        if (r2 < l.f39245d) goto L7;
        return (ai) ZeusTransformUtils.preCheckCast(this, ai.class, "com.obric.aiagent.plugin");
    L7:
        return super.a(r2);
    }
}
