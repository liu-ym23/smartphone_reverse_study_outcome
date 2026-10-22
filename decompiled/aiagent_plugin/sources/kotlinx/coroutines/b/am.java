package kotlinx.coroutines.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlinx.coroutines.aq;

/* JADX INFO: compiled from: StateFlow.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class am {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final kotlinx.coroutines.internal.al f39000a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final kotlinx.coroutines.internal.al f39001b = null;

    public static final /* synthetic */ kotlinx.coroutines.internal.al a() {
        return f39000a;
    }

    public static final /* synthetic */ kotlinx.coroutines.internal.al b() {
        return f39001b;
    }

    public static final <T> x<T> a(T r2) {
        if (r2 != null) goto L6;
        r2 = (T) kotlinx.coroutines.b.a.t.f38938a;
    L6:
        return (x) ZeusTransformUtils.preCheckCast(new al(r2), x.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> void update(x<T> r2, d.h.a.b<? super T, ? extends T> r3) {
        x r4 = (x) ZeusTransformUtils.wrapperContextForParams(r2, x.class, "com.obric.aiagent.plugin");
        d.h.a.b r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
    L3:
        Object r0 = r4.c();
        if (r4.a(r0, r5.invoke(r0)) == false) goto L3;
    }

    static {
        f39000a = new kotlinx.coroutines.internal.al("NONE");
        f39001b = new kotlinx.coroutines.internal.al("PENDING");
    }

    public static final <T> h<T> a(ak<? extends T> r4, d.c.g r5, int r6, kotlinx.coroutines.a.a r7) {
        ak r8 = (ak) ZeusTransformUtils.wrapperContextForParams(r4, ak.class, "com.obric.aiagent.plugin");
        d.c.g r9 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r5, d.c.g.class, "com.obric.aiagent.plugin");
        boolean r2 = true;
        if (aq.a() == true) goto L5;
    L12:
        if (r6 >= 0) goto L14;
    L16:
        r2 = false;
    L17:
        if (r2 == true) goto L21;
        if (r6 == (-2)) goto L21;
    L25:
        return ad.a((ab) ZeusTransformUtils.preCheckCast(r8, ab.class, "com.obric.aiagent.plugin"), r9, r6, r7);
    L21:
        if (r7 != kotlinx.coroutines.a.a.f38772b) goto L25;
        return (h) ZeusTransformUtils.preCheckCast(r8, h.class, "com.obric.aiagent.plugin");
    L14:
        if (r6 >= 2) goto L16;
    L5:
        if (r6 == (-1)) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == true) goto L12;
        throw new AssertionError();
    L7:
        r0 = false;
        goto L8
    }
}
