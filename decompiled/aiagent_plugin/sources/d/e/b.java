package d.e;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: PlatformImplementations.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f38433a = null;

    static {
        d.e.b.a r1 = new d.e.b.a();
        f38433a = (a) ZeusTransformUtils.preCheckCast(r1, a.class, "com.obric.aiagent.plugin");
        return;
    L6:
        e = move-exception;
        ClassLoader r2 = r1.getClass().getClassLoader();
        ClassLoader r3 = a.class.getClassLoader();
        if (o.a(r2, r3) == false) goto L10;
        throw e;
    L10:
        throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + r2 + ", base type classloader: " + r3, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
    }
}
