package androidx.lifecycle.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: CreationExtras.kt */
/* JADX INFO: loaded from: classes.dex */
public final class d extends a {
    /* JADX WARN: Multi-variable type inference failed */
    public d() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public d(a r2) {
        o.e(r2, "initialExtras");
        a().putAll(r2.a());
    }

    public /* synthetic */ d(a r1, int r2, h r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = (a) ZeusTransformUtils.preCheckCast(a.C0057a.f1967a, a.class, "com.obric.aiagent.plugin");
    L5:
        this(r1);
    }

    public final <T> void a(a.b<T> r3, T r4) {
        a.b<?> r5 = (a.b) ZeusTransformUtils.wrapperContextForParams(r3, a.b.class, "com.obric.aiagent.plugin");
        o.e(r5, "key");
        a().put(r5, r4);
    }

    @Override // androidx.lifecycle.a.a
    public <T> T a(a.b<T> r3) {
        a.b r4 = (a.b) ZeusTransformUtils.wrapperContextForParams(r3, a.b.class, "com.obric.aiagent.plugin");
        o.e(r4, "key");
        return (T) a().get(r4);
    }
}
