package androidx.lifecycle;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlinx.coroutines.bd;

/* JADX INFO: compiled from: PausingDispatcher.kt */
/* JADX INFO: loaded from: classes.dex */
public final class y extends kotlinx.coroutines.ai {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f2080a;

    public y() {
        this.f2080a = new e();
    }

    @Override // kotlinx.coroutines.ai
    public boolean a(d.c.g r3) {
        d.c.g r4 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "context");
        if (bd.b().a().a(r4) == false) goto L6;
        return true;
    L6:
        return !this.f2080a.e();
    }

    @Override // kotlinx.coroutines.ai
    public void a(d.c.g r3, Runnable r4) {
        d.c.g r5 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin");
        Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "context");
        d.h.b.o.e(r6, "block");
        this.f2080a.a(r5, r6);
    }
}
