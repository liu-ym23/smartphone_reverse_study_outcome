package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DefaultExecutor.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class at {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f38863a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final aw f38864b = null;

    static {
        f38863a = kotlinx.coroutines.internal.am.a("kotlinx.coroutines.main.delay", false);
        f38864b = b();
    }

    public static final aw a() {
        return f38864b;
    }

    private static final aw b() {
        if (f38863a == false) goto L5;
        cm r0 = bd.b();
        if (kotlinx.coroutines.internal.ab.a(r0) == true) goto L10;
        boolean r2 = ZeusTransformUtils.instanceOf(r0, aw.class);
        Object r1 = r0;
        if (r2 == false) goto L10;
    L12:
        return (aw) ZeusTransformUtils.preCheckCast(r1, aw.class, "com.obric.aiagent.plugin");
    L10:
        r1 = as.f38861a;
        goto L12
    L5:
        return (aw) ZeusTransformUtils.preCheckCast(as.f38861a, aw.class, "com.obric.aiagent.plugin");
    }
}
