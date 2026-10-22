package d.c.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ContinuationImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class j extends a {
    public j(d.c.d<Object> r3) {
        d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        super(r4);
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.getContext() != d.c.h.f38423a) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == false) goto L11;
        return;
    L11:
        throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString());
    L7:
        r2 = false;
        goto L8
    }

    @Override // d.c.d
    public d.c.g getContext() {
        return (d.c.g) ZeusTransformUtils.preCheckCast(d.c.h.f38423a, d.c.g.class, "com.obric.aiagent.plugin");
    }
}
