package kotlinx.coroutines.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: FastServiceLoader.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f39413a = false;

    static {
        d.n.a r0 = d.n.f38560a;     // Catch: Throwable -> L4
        Object r1 = d.n.f(ZeusTransformUtils.forName("android.os.Build", "com.obric.aiagent.plugin"));     // Catch: Throwable -> L4
    L6:
        f39413a = d.n.a(r1);
        return;
    L4:
        th = move-exception;
        d.n.a r2 = d.n.f38560a;
        r1 = d.n.f(d.o.a(th));
        goto L6
    }

    public static final boolean a() {
        return f39413a;
    }
}
